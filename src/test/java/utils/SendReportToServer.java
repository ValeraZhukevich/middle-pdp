package utils;

import config.RestConfig;
import io.restassured.response.ResponseBody;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.sleep;
import static io.restassured.RestAssured.given;
import static utils.PropertiesReader.getProperty;

@Tag("allure")
@ExtendWith(RestConfig.class)
public class SendReportToServer {

    private static final int MAX_NUMBER_OF_ATTEMPTS = 5;

    @Test
    void sendReport() {
        Arrays.stream(new File(getProperty("allureResultsPath")).listFiles()).forEach(file -> {
            given()
                    .queryParam("project_id", getProperty("projectId"))
                    .header("Content-Type", "multipart/form-data")
                    .multiPart("files[]", file)
                    .when()
                    .post(getProperty("host") + getProperty("allurePort") + getProperty("sendResults"))
                    .then().statusCode(200);
        });

        int i = 0;
        do {
            ResponseBody body = given()
                    .queryParam("project_id", getProperty("projectId"))
                    .header("Content-Type", "application/json")
                    .when()
                    .get(getProperty("host") + getProperty("allurePort") + getProperty("generateReport"))
                    .body();
            if (body.jsonPath().get("meta_data.message").toString().contains("successfully")) break;
            else sleep(10000);
            i++;
        } while (i < MAX_NUMBER_OF_ATTEMPTS);
    }

}
