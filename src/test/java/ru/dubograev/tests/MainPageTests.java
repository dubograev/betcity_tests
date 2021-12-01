package ru.dubograev.tests;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.dubograev.helpers.DriverUtils;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends TestBase {
    @ParameterizedTest(name = "Page {0} should have title {1}")
    @CsvSource(value = {
            "Линия; Линия • Ставки на спорт online • БЕТСИТИ",
            "LIVE; Ставки на спорт LIVE • Online ставки по ходу матча • БЕТСИТИ",
            "Live-календарь; Ставки на сегодня • Live календарь • БЕТСИТИ",
            "Live-результаты; Лайв Результаты матчей • БЕТСИТИ",
            "Результаты; Результаты матчей за сегодня • БЕТСИТИ",
            "Статистика; Статистика матчей - футбол, теннис, хоккей и другие виды спорта",
            "Информация; О компании • Букмекерская контора БЕТСИТИ",
    }, delimiter = ';')
    @AllureId("5978")
    void mainMenuButtons(String button, String title) {
        step("Open url 'https://betcity.ru/'", () ->
                open("https://betcity.ru/"));
        step("Check that the title for " + button + " is " + title, () -> {
            $(".push-confirm").$("[aria-label=Закрыть]").click();
            $("app-menu").$(".menu").$(byText(button)).click();
            String expectedTitle = title;
            sleep(2000);
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @AllureId("5977")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://betcity.ru/'", () ->
            open("https://betcity.ru/"));

        step("Page title should have text 'Ставки на спорт онлайн • Букмекерская контора БЕТСИТИ'", () -> {
            String expectedTitle = "Ставки на спорт онлайн • Букмекерская контора БЕТСИТИ";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @AllureId("5979")
    @DisplayName("Page console logs should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://betcity.ru/'", () ->
            open("https://betcity.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
