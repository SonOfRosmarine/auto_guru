package vinogradov;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SerchPages {

    @BeforeAll
    static void beforAll(){

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test

    void FindePages(){

        open("/selenide/selenide");
        $("#wiki-tab").click();

        $(".f6.Link--muted").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text("@"))
                .shouldHave(text("ExtendWith"))
                .shouldHave(text("({"))
                .shouldHave(text("SoftAssertsExtension"))
                .shouldHave(text("."))
                .shouldHave(text("class"))
                .shouldHave(text("."))
                .shouldHave(text("})"))
                .shouldHave(text("class"))
                .shouldHave(text("Tests"))
                .shouldHave(text("{"))
                .shouldHave(text("@"))
                .shouldHave(text("void"))
                .shouldHave(text("Test"))
                .shouldHave(text("test"))
                .shouldHave(text("() {"))
                .shouldHave(text("Configuration"))
                .shouldHave(text("."))
                .shouldHave(text("assertionMode"))
                .shouldHave(text("="))
                .shouldHave(text("SOFT"))
                .shouldHave(text(";"))
                .shouldHave(text("open"))
                .shouldHave(text("("))
                .shouldHave(text("page.html"))
                .shouldHave(text(")"))
                .shouldHave(text("$"))
                .shouldHave(text("#first"))
                .shouldHave(text(")."))
                .shouldHave(text("should"))
                .shouldHave(text("("))
                .shouldHave(text("visible"))
                .shouldHave(text(")."))
                .shouldHave(text("click"))
                .shouldHave(text("();"))
                .shouldHave(text("$"))
                .shouldHave(text("("))
                .shouldHave(text("#second"))
                .shouldHave(text(")."))
                .shouldHave(text("should"))
                .shouldHave(text("("))
                .shouldHave(text("visible"))
                .shouldHave(text(")."))
                .shouldHave(text("click"))
                .shouldHave(text("(); } }"));
        sleep(3000);





    }

}
