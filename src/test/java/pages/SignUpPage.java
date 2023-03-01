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
    private final SelenideElement femaleOption = $(byText("Female"));
    private final SelenideElement nonbinaryOption = $(byText("Non-binary"));
    private final SelenideElement captcha = $(".recaptcha-checkbox-border");
    private final SelenideElement closeCookieFrameButton =
            $("#onetrust-close-btn-container .onetrust-close-btn-handler");

    public SignUpPage fillEmailInput(String email) {
        emailInput.val(email);
        return this;
    }

    public SignUpPage fillConfirmEmailInput(String email) {
        confirmEmailInput.val(email);
        return this;
    }

    public SignUpPage fillPasswordInput(String password) {
        passwordInput.val(password);
        return this;
    }

    public SignUpPage fillDisplayNameInput(String displayName) {
        displayNameInput.val(displayName);
        return this;
    }

    public SignUpPage fillDayInput(int day) {
        dayInput.val(String.valueOf(day));
        return this;
    }

    public SignUpPage fillMonthInput(String month) {
        monthInput.selectOption(month);
        return this;
    }

    public SignUpPage fillYearInput(int year) {
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

    public SignUpPage selectNonBinaryOption() {
        nonbinaryOption.click();
        return this;
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
            case "Nonbinary":
                selectNonBinaryOption();
                break;
            case "Male":
            default:
                selectMaleOption();
        }
        return this;
    }


}
