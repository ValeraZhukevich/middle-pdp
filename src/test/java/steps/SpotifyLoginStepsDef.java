package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.GuiConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.SignUpPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

@ExtendWith(GuiConfig.class)
public class SpotifyLoginStepsDef {
    private final SignUpPage signUpPage = new SignUpPage();

    @Given("I'm on signup spotify page")
    public void iMOnSignupSpotifyPage() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        //  capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "http://34.65.55.99:4444/wd/hub";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
        open("http://spotify.com/signup");
    }


    @When("I type {string} in email input")
    public void iTypeInEmailInput(String email) {
        signUpPage.typeEmail(email);
    }

    @And("And type {string} in confirm email input")
    public void andTypeInConfirmEmailInput(String email) {
        signUpPage.typeConfirmEmail(email);
    }

    @And("And type {string} in password input")
    public void andTypeInPasswordInput(String password) {
        signUpPage.typePassword(password);
    }

    @And("And type {string} in nickname input")
    public void andTypeInNicknameInput(String nickname) {
        signUpPage.typeNickname(nickname);
    }

    @And("And type {int} in day of birthday")
    public void andTypeDayInDayOfBirthday(int day) {
        signUpPage.typeDay(day);
    }

    @And("And choose {string} as a month of birthday")
    public void andChooseAsAMonthOfBirthday(String month) {
        signUpPage.chooseMonth(month);
    }

    @And("And accept all conditions")
    public void andAcceptAllConditions() {
        signUpPage.acceptAllConditions();
    }

    @Then("everything will be ok")
    public void everythingWillBeOk() {
    }

    @And("And type {int} in year of birthday")
    public void andTypeYearInYearOfBirthday(int year) {
        signUpPage.typeYear(year);
    }

    @And("And choose {string} as gender")
    public void andChooseAsGender(String gender) {
        signUpPage.selectGender(gender);
    }
}
