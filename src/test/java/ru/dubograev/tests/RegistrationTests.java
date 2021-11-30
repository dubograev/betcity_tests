package ru.dubograev.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationTests extends TestBase {
    Faker faker = new Faker();

    @Test
    void registrationWithWrongPhoneNumber() {
        step("Open url 'https://betcity.ru/ru/reg'", () ->
                open("https://betcity.ru/ru/reg"));
        step("Fill the form with wrong phone number", () -> {
            $("[formcontrolname=phone]").$("input").setValue("8000");
            $("[formcontrolname=birthday]").$("input").setValue("10.10.1980");
            $("[formcontrolname=password]").$("input").setValue(faker.internet().password());
        });
        step("Check that Warning message is displayed", () ->
                $("[formcontrolname=phone]").shouldHave(text("Минимум 14 символов")));
    }

    @Test
    void registrationWithAgeLessThan18() {
        step("Open url 'https://betcity.ru/ru/reg'", () ->
                open("https://betcity.ru/ru/reg"));
        step("Fill the form with age less than 18", () -> {
            $("[formcontrolname=phone]").$("input").setValue(faker.phoneNumber().cellPhone());
            $("[formcontrolname=birthday]").$("input").setValue("10.10.2010");
            $("[formcontrolname=password]").$("input").setValue("a1111111");
            $(".checkbox-new__mark").click();
            $(".button.button_submit-v2").click();
        });
        step("Check that Warning message is displayed", () ->
                $("[formcontrolname=birthday]").shouldHave(text(" Регистрация возможна только для лиц старше 18 лет ")));
    }

    @Test
    void registrationWithEmptyPassword() {
        step("Open url 'https://betcity.ru/ru/reg'", () ->
                open("https://betcity.ru/ru/reg"));
        step("Fill the form with empty password", () -> {
            $("[formcontrolname=phone]").$("input").setValue(faker.phoneNumber().cellPhone());
            $("[formcontrolname=birthday]").$("input").setValue("10.10.2000");
            $(".checkbox-new__mark").click();
        });
        step("Check that Submit button is not enabled", () ->
                $(".button.button_submit-v2").shouldHave(attribute("disabled")));
    }
}
