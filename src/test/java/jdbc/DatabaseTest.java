package jdbc;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.JdbcConnection;
import utils.PropertiesReader;
import utils.User;

import static utils.PropertiesReader.getProperty;

public class DatabaseTest {

    @Test
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
}
