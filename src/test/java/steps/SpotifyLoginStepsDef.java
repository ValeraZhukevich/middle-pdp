package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pages.SignUpPage;

import static com.codeborne.selenide.Selenide.*;

public class SpotifyLoginStepsDef {
    private final SignUpPage signUpPage = new SignUpPage();

    @When("I transient on sign up page")
    public void iTransientOnSignUpPage() {
        System.out.println("lalala");
    }

    @And("And fill email field as {string}")
    public void andFillEmailFieldAs(String email) {
        signUpPage.fillEmailInput(email);
    }

    @And("And fill confirm email field as {string}")
    public void andFillConfirmEmailFieldAs(String confirmEmail) {
        signUpPage.fillConfirmEmailInput(confirmEmail);
    }

    @And("And fill password field as as {string}")
    public void andFillPasswordFieldAsAs(String password) {
        signUpPage.fillPasswordInput(password);
    }

    @And("And fill display field as {string}")
    public void andFillDisplayFieldAs(String displayName) {
        signUpPage.fillDisplayNameInput(displayName);
    }


    @And("And fill month field as {string}")
    public void andFillMonthFieldAs(String month) {
        signUpPage.fillMonthInput(month);
    }

    @And("And fill year field as {int}")
    public void andFillYearFieldAs(int year) {
        Allure.attachment("log", "And so on");
        signUpPage.fillYearInput(year);
    }

    @And("And fill gender as {string}")
    public void andFillGenderAs(String gender) {
        $("#wtf").click();
        signUpPage.selectGender(gender);
    }

    @Then("everything will be ok")
    public void everythingWillBeOk() {
    }

    @And("And fill day field as {int}")
    public void andFillDayFieldAsDay(int day) {
        signUpPage.fillDayInput(day);
    }

    @Given("I'm on spotify page")
    public void iMOnSpotifyPage() {
        open("https://www.spotify.com");
        sleep(500);
        signUpPage.closeCookieFrameIfExist();
    }
}
