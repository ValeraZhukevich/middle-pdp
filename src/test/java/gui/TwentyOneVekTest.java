package gui;

import config.GuiConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@ExtendWith(GuiConfig.class)
@Feature("21 Vek")
@Tag("gui")
public class TwentyOneVekTest {

    @Test
    @Story("Search by product name")
    void searchByProductName() {

        step("Open main 21vek.by page", () ->
                open("https://21vek.by"));

        step("Accept cookies", () ->
                $(".Button-module__blue-primary").click());

        step("Enter Stars Wars Lego in searching field", () -> {
            $("#catalogSearch").val("Star wars lego");
            $("#catalogSearch").pressEnter();
        });

        step("Choose Lego manufacturer filter", () ->
                $x("//label[@title='Lego']").click());

        step("Execute filter", () ->
                $("#j-filter__btn").click());

        step("Add first result to basket", () ->
                $x("//button[@data-ga_action='add_to_cart']").click());

        step("Go to basket", () ->
                $(".headerCart").click());

        step("Basket has one product", () ->
                $(".BasketTabsScreen_counter__2iMje").shouldHave(text("1")));
    }
}
