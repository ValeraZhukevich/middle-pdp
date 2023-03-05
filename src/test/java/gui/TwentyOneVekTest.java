package gui;

import config.GuiConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AmazonPage;

import static io.qameta.allure.Allure.step;

@ExtendWith(GuiConfig.class)
@Feature("21 Vek")
@Tag("gui")
public class TwentyOneVekTest {

    AmazonPage amazonPage = new AmazonPage();

    @Test
    @Story("Search by product name")
    void searchByProductName() {
        amazonPage.openAmazon();
        amazonPage.typeInSearchField("Lego Star Wars");
        amazonPage.confirmSearch();
        amazonPage.setLowPrice("100");
        amazonPage.setHighPrice("200");
        amazonPage.applyFilter();

    }
}
