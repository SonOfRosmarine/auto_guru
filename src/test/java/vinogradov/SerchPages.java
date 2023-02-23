package vinogradov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import  static com.codeborne.selenide.Selenide.$;
import  static com.codeborne.selenide.Selenide.open;

public class SerchPages {

    public static  String checkText = """
            @ExtendWith({SoftAssertsExtension })
            class  {
              @Test
              void test() {
                Configuration.assertionMode = SOFT;
                open ("page.html");

                $("#first").should (visible).click ();
                $("#second").should (visible).click();
              }
            }
            """;


    @BeforeAll
    static void beforAll(){

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test

     void findePages(){



        open("/selenide/selenide");
        $("#wiki-tab").click();

        $(".f6.Link--muted").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text(checkText));


    }

}
