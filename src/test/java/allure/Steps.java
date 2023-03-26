package allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Осуществляем поиск репозитория {repo}")
    public void searchRepo(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Кликаем по ссылке репазитория {repo}")
    public void clickRepo(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб issue")
    public void openIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие записи")
    public void checkWrite() {
        $("#issue_1_link").shouldHave(text("Allure"));
    }
}
