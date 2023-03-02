package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {

    private final SelenideElement cookieContainer = $(".ot-sdk-container");
    private final SelenideElement emailInput = $("#email");
    private final SelenideElement confirmEmailInput = $("#confirm");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement displayNameInput = $("#displayname");
    private final SelenideElement dayInput = $("#day");
    private final SelenideElement monthInput = $("#month");
    private final SelenideElement yearInput = $("#year");
    private final SelenideElement maleOption = $(byText("Male"));

    private final SelenideElement acceptConditions = $("#third-party-checkbox");
    private final SelenideElement femaleOption = $(byText("Female"));
    private final SelenideElement otherOption = $(byText("Other"));
    private final SelenideElement captcha = $(".recaptcha-checkbox-border");
    private final SelenideElement closeCookieFrameButton = $("#onetrust-close-btn-container");

    public SignUpPage typeEmail(String email) {
        emailInput.val(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email) {
        confirmEmailInput.val(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        passwordInput.val(password);
        return this;
    }

    public SignUpPage typeNickname(String displayName) {
        displayNameInput.val(displayName);
        return this;
    }

    public SignUpPage typeDay(int day) {
        dayInput.val(String.valueOf(day));
        return this;
    }

    public SignUpPage chooseMonth(String month) {
        monthInput.selectOption(month);
        return this;
    }

    public SignUpPage typeYear(int year) {
        yearInput.val(String.valueOf(year));
        return this;
    }

    public SignUpPage selectMaleOption() {
        maleOption.click();
        return this;
    }

    public SignUpPage selectFemaleOption() {
        femaleOption.click();
        return this;
    }

    public void acceptAllConditions(){
        acceptConditions.click();
    }

    public SignUpPage confirmCaptcha() {
        captcha.click();
        return this;
    }

    public SignUpPage closeCookieFrameIfExist() {
        if (cookieContainer.isDisplayed()) {
            closeCookieFrameButton.click();
        }
        return this;
    }

    public SignUpPage selectGender(String gender) {
        switch (gender) {
            case "Female":
                selectFemaleOption();
                break;
            case "Other":
                selectOtherGender();
                break;
            case "Male":
            default:
                selectMaleOption();
        }
        return this;
    }

    private void selectOtherGender() {
        otherOption.click();
    }


}
