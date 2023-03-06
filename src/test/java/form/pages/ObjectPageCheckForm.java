package form.pages;

import com.codeborne.selenide.SelenideElement;
import form.pages.component.Component;
import form.pages.component.ModalWindowResult;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ObjectPageCheckForm {
    Component component = new Component();
    ModalWindowResult modalWindowResult = new ModalWindowResult();
    private SelenideElement
            inputFirstName = $("[id = firstName]"),
            inputLastName = $("[id = lastName]"),
            inputEmail = $("[id = userEmail]"),

    inputNumber = $("[id = userNumber]"),
            inputSubject = $("[id = subjectsInput]"),
            inputAddress = $("[id = currentAddress]");

    public ObjectPageCheckForm openPage() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public ObjectPageCheckForm setInputFirstName(String value) {
        this.inputFirstName = inputFirstName.setValue(value);
        return this;
    }

    public ObjectPageCheckForm setInputLastName(String value) {
        this.inputLastName = inputLastName.setValue(value);
        return this;
    }

    public ObjectPageCheckForm setInputEmail(String value) {
        this.inputEmail = inputEmail.setValue(value);
        return this;
    }

    public ObjectPageCheckForm setInputGender() {
        $(By.cssSelector("label[for='gender-radio-1']")).click();
        return this;
    }

    public ObjectPageCheckForm setInputNumber(String value) {
        this.inputNumber = inputNumber.setValue(value);
        return this;
    }

    public ObjectPageCheckForm setBirth(String month, String years, String day) {
        $("[id = dateOfBirthInput]").click();
        component.setData(month, years, day);
        return this;
    }

    public ObjectPageCheckForm setInputSubject(String value) {
        this.inputSubject = inputSubject.setValue(value).pressEnter();
        return this;
    }

    public ObjectPageCheckForm setHobbies() {
        $(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        return this;
    }

    public ObjectPageCheckForm setUploadPicture() {
        $("#uploadPicture").uploadFromClasspath("pictures/5.jpg");
        return this;
    }

    public ObjectPageCheckForm setAddress(String value) {
        this.inputAddress = inputAddress.setValue(value);
        return this;
    }

    public ObjectPageCheckForm setState() {
        $("[id = state]").click();
        $("[id = stateCity-wrapper]").$(byText("Haryana")).click();
        return this;
    }

    public ObjectPageCheckForm setCity() {
        $("[id = city]").click();
        $("[id = stateCity-wrapper]").$(byText("Karnal")).click();
        $("[id = submit]").click();
        return this;
    }

    public ObjectPageCheckForm resultText() {
        modalWindowResult.checkResult();
        return this;
    }

    public ObjectPageCheckForm verifyResult(String key, String value) {
        modalWindowResult.verifyResult(key, value);
        return this;
    }

}

