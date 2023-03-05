package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

@Feature("Search on amazon.com")
public class OnlinerPage {
    private final SelenideElement searchInput = $(".fast-search__input");
    private final SelenideElement category = $("a.category__title");
    private final SelenideElement starWars = $x("//input[@value='starwars']/ancestor::label");
    private final SelenideElement applyFilter = $("#a-autoid-1-announce");
    private final SelenideElement mandalorian = $x("span[contains(text(), 'The Mandalorian The Child')]");
    private final SelenideElement productTitle = $("#productTitle");

    @Step("Open amazon.com")
    public void openOnliner(){
        open("https://onliner.by");
    }

    @Step("Type '{searchValue}' in search")
    public void typeInSearchField(String searchValue){
        searchInput.setValue(searchValue).pressEnter();
    }

    @Step("Set '{lowPrice}' low price in filter")
    public void setLowPrice(String lowPrice){
//        lowPriceFilter.setValue(lowPrice);
    }

    @Step("Set '{highPrice}' high price in filter")
    public void setHighPrice(String highPrice){
//        highPriceFilter.setValue(highPrice);
    }

    @Step("Apply filter")
    public void applyFilter(){
        applyFilter.click();
    }

    @Step("Choose first category")
    public void chooseFirstCatgory(){
        switchTo().frame($(".modal-iframe"));
        category.click();
    }

    @Step("Choose Star Wars")
    public void chooseStarWars(){
        starWars.click();
    }



}
