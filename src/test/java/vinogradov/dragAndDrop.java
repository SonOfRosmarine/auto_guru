package vinogradov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.nio.channels.SocketChannel.open;

public class dragAndDrop {

    @BeforeAll
    static void beforAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }
@Test

    void checkDragAndDrop(){

    Selenide.open("/drag_and_drop");
    $("#column-a").shouldHave(Condition.exactText("A"));
    $("#column-b").dragAndDropTo("#column-a");
    $("#column-a").shouldHave(Condition.exactText("B"));
}

}
