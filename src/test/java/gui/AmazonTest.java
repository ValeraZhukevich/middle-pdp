package gui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AmazonTest {

    @Tag("gui")
    @Test
    void searchByProductName() {
        open("https://amazon.com");
        $("#twotabsearchtextbox").setValue("Samsung s22").pressEnter();
        $(".a-section").click();
        sleep(5000);
    }
}
