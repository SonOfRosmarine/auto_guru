package vinogradov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void checkDragAndDrop() {

        Selenide.open("/drag_and_drop");
        $("#column-a").shouldHave(Condition.exactText("A"));
        $("#column-b").dragAndDropTo("#column-a");
        $("#column-a").shouldHave(Condition.exactText("B"));
    }

}
