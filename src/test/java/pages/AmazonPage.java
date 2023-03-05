package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

@Feature("Search on amazon.com")
public class AmazonPage {
    private final SelenideElement searchInput = $("#twotabsearchtextbox");
    private final SelenideElement confirmButton = $x("input[@value='Go']");
    private final SelenideElement lowPriceFilter = $("#low-price");
    private final SelenideElement highPriceFilter = $("#high-price");

    private final SelenideElement applyFilter = $("#a-autoid-1-announce");
    private final SelenideElement mandalorian = $x("span[contains(text(), 'The Mandalorian The Child')]");
    private final SelenideElement productTitle = $("#productTitle");

    @Step("Open amazon.com")
    public void openAmazon(){
        open("https://amazon.com");
    }

    @Step("Type '{searchValue}' in search")
    public void typeInSearchField(String searchValue){
        searchInput.setValue(searchValue);
    }

    @Step("Set '{lowPrice}' low price in filter")
    public void setLowPrice(String lowPrice){
        lowPriceFilter.setValue(lowPrice);
    }

    @Step("Set '{highPrice}' high price in filter")
    public void setHighPrice(String highPrice){
        highPriceFilter.setValue(highPrice);
    }

    @Step("Apply filter")
    public void applyFilter(){
        applyFilter.click();
    }

    @Step("Confirm search")
    public void confirmSearch(){
        confirmButton.click();
    }



}
