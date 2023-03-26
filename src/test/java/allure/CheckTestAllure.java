package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class CheckTestAllure {
    private static final String REPOSITIRY = "SonOfRosmarine/auto_guru";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("SonOfRosmarine/auto_guru");
        $(".header-search-input").submit();
        $(linkText("SonOfRosmarine/auto_guru")).click();
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(text("Allure"));
    }

    @Test
    public void testIssueSearchLanbda() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Осуществляем поиск репозитория" + REPOSITIRY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITIRY);
            $(".header-search-input").submit();
        });
        step("Кликаем по ссылке репазитория" + REPOSITIRY, () -> {
            $(linkText(REPOSITIRY)).click();
        });
        step("Открываем таб issue", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие записи", () -> {
            $("#issue_1_link").shouldHave(text("Allure"));
        });

    }

    @Test
    public void testIssueSearchWithStep() {
        Steps steps = new Steps();
        steps.openMainPage();
        steps.searchRepo(REPOSITIRY);
        steps.clickRepo(REPOSITIRY);
        steps.openIssue();
        steps.checkWrite();
    }

}
