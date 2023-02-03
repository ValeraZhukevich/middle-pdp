package gui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class OnlinerTest {

    @Test
    void searchByProductName() {
        open("https://sports.ru");
        $(".gadget__tournament-list").selectOption("Германия. Бундеслига");
        sleep(5000);
    }
}
