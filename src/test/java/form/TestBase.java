package form;

import attach.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import form.pages.ObjectPageCheckForm;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    public ObjectPageCheckForm objectPageCheckForm = new ObjectPageCheckForm();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");;
       // Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion","100");
        Configuration.baseUrl = System.getProperty("baseUrl","https://demoqa.com");
        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
