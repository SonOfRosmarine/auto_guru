package vinogradov;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class enterprizePage {


    @BeforeAll
    static void beforAll(){

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
    }

      @Test


    void enterprizePage(){
         open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text ("Enterprise")).click();
        $(".enterprise-hero").shouldHave(text("Build like the best"));
}

}
