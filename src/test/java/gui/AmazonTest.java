package gui;

import config.SelenoidConfig;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(SelenoidConfig.class)
public class AmazonTest {

    @Tag("gui")
    @Test
    void searchByProductName() {
        open("https://oz.by");
        $(".styles_primaryButton__30pEq").click();
        sleep(6000);
        $("#catalogSearch").val("Star wars lego").pressEnter();
        $x("//label[@title='Lego']").click();
        $("#j-filter__btn").click();
        $x("//span[text()='$200 & Above']").click();
        $(".s-card-container").click();
        $("#productTitle").shouldHave(text("LEGO Star Wars Millennium Falcon 75257"));
        $("#add-to-wishlist-button-group").click();
        $(By.name("signIn")).shouldBe(visible);
        sleep(5000);

//        open("https://oz.by");
//        sleep(50000);
//        $("#top-s").val("Star wars lego").pressEnter();
    }
}
