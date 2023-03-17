package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Feature("Search on onliner.by")
public class OnlinerPage {
    private final SelenideElement searchInput = $(".fast-search__input");
    private final SelenideElement category = $("a.category__title");
    private final SelenideElement starWars = $x("//input[@value='starwars']/ancestor::label");
    private final SelenideElement millenniumFalcon = $x("//span[contains(text(), 'LEGO Star Wars 75192')]");
    private final SelenideElement productName = $("h1.catalog-masthead__title");

    @Step("Open onliner.by")
    public void openOnliner(){
        open("https://onliner.by");
    }

    @Step("Type '{searchValue}' in search")
    public void typeInSearchField(String searchValue){
        searchInput.setValue(searchValue).pressEnter();
    }

    @Step("Choose first category")
    public void chooseFirstCatgory(){
        switchTo().frame($(".modal-iframe"));
        category.click();
    }

    @Step("Choose Star Wars")
    public void chooseStarWars(){
        starWars.scrollTo().click();
    }

    @Step("Choose Star Wars")
    public void chooseMillenniumFalcon(){
        millenniumFalcon.click();
    }

    @Step("Product name should has text '{productTitle}'")
    public void productNameShouldHasText(String productTitle){
        productName.shouldHave(text(productTitle));
    }

}
