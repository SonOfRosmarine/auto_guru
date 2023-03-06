package form;

import com.codeborne.selenide.Configuration;
import form.pages.ObjectPageCheckForm;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public ObjectPageCheckForm objectPageCheckForm = new ObjectPageCheckForm();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }
}
