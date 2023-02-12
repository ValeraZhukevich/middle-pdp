package util;

import config.RestConfig;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pojo.AllureResultsPOJO;
import pojo.FilePOJO;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

@Tag("sendReport")
@ExtendWith(RestConfig.class)
public class SendReportToServer {

    @Test
    void sendReport() {

        AtomicInteger count = new AtomicInteger();
        List<FilePOJO> collect = Arrays.stream(new File("build/allure-results").list())
                .map(file -> {
                    try {
                        return FilePOJO.builder()
                                .file_name("file" + count.getAndIncrement())
                                .content_base64(encodeFileToBase64Binary("build/allure-results/" + file)).build();

                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }).collect(Collectors.toList());

        AllureResultsPOJO files = AllureResultsPOJO.builder()
                .results(collect.toArray(new FilePOJO[0]))
                .build();

        given()
                .queryParam("project_id", "pdp-middle")
                .header("Content-Type", "application/json")
                .body(files)
                .when()
                .post("http://34.65.55.99:5050/send-results")
                .then().statusCode(200);



        given()
                .param("project_id", "pdp-middle")
                .header("Content-Type", "application/json")
                .when()
                .get("http://34.65.55.99:5050/generate-report")
                .then().statusCode(200);


    }

    private static String encodeFileToBase64Binary(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        return new String(encoded, StandardCharsets.US_ASCII);
    }

}
