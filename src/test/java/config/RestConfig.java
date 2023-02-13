package config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static utils.PropertiesReader.getProperty;

public class RestConfig implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        RestAssured.baseURI = getProperty("host");
        RestAssured.filters(new AllureRestAssured(), new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
