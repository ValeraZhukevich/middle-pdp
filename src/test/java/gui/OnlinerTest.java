package gui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.OnlinerPage;

import static io.qameta.allure.Allure.step;

//@ExtendWith(GuiConfig.class)
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
//        onlinerPage.applyFilter();

    }
}
