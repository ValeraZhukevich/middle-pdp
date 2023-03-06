package jdbc;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import utils.JdbcConnection;
import utils.PropertiesReader;
import pojo.User;

import static utils.PropertiesReader.getProperty;

@Tag("jdbc")
@Epic("JDBC")
@Feature("JDBC Postgres database")
public class DatabaseTest {

    @Test
    @Story("Add user to database")
    void addUser(){
        Faker faker = Faker.instance();
        int currentNumber = JdbcConnection.getUsersCount();
        User user = User.builder()
                .name(faker.name().firstName())
                .surname(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone()).build();
        Long id = JdbcConnection.saveUser(user);
        PropertiesReader.setProperty("userId", String.valueOf(id));
        user.setId(id);
        Assertions.assertEquals(++currentNumber, JdbcConnection.getUsersCount());
        Assertions.assertEquals(user, JdbcConnection.getUser(user.getId()));
    }

    @AfterEach
    void tearDown() {
        JdbcConnection.deleteUser(Long.valueOf(getProperty("userId")));
    }

    @AfterAll
    public static void closeConnections() {
        JdbcConnection.closeConnection();
    }
}
