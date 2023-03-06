package gui;

import config.GuiConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.OnlinerPage;

@ExtendWith(GuiConfig.class)
@Feature("Onliner")
@Tag("gui")
public class OnlinerTest {

    OnlinerPage onlinerPage = new OnlinerPage();

    @Test
    @Story("Search product on onliner.by")
    void searchByProductName() {
        onlinerPage.openOnliner();
        onlinerPage.typeInSearchField("Lego");
        onlinerPage.chooseFirstCatgory();
        onlinerPage.chooseStarWars();
        onlinerPage.chooseMillenniumFalcon();
        onlinerPage.productNameShouldHasText("LEGO Star Wars 75192 Сокол Тысячелетия");
    }
}
