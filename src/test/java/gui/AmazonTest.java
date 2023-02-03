package gui;

import config.SelenoidConfig;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.*;

@ExtendWith(SelenoidConfig.class)
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
