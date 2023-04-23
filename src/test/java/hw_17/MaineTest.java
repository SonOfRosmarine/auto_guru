package hw_17;

import com.codeborne.selenide.Condition;
import config.WebConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class MaineTest extends BaseTest {

    private static final String REPOSITIRY = "SonOfRosmarine/auto_guru";
    @Test
    @Tag("Проверка наличия записи")
    public void testIssueSearchLanbda() {
        step("Открываем главную страницу", () -> {
            open("");
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

    @Step("Проверяем наличие Issue с хэштегом 904")
    public void checkHashtag() {
        $(withText("#904")).should(Condition.exist);
    }
}

