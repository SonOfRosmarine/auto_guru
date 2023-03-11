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
            inputFirstName = $("#firstName"),
            inputLastName = $("#lastName"),
            input_gender = $("#genterWrapper"),
            inputEmail = $("#userEmail"),
            inputNumber = $("#userNumber"),
            inputSubject = $("#subjectsInput"),
            inputHobbies = $("#hobbiesWrapper"),
            inputAddress = $("#currentAddress");

    public ObjectPageCheckForm openPage() {
        open("/automation-practice-form");
        return this;
    }

    public ObjectPageCheckForm secretBanner() {
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

    public ObjectPageCheckForm setInputGender(String gender) {
        input_gender.$(byText(gender)).click();
        return this;
    }

    public ObjectPageCheckForm setInputNumber(String value) {
        this.inputNumber = inputNumber.setValue(value);
        return this;
    }

    public ObjectPageCheckForm setBirthMonth(String month) {
        $("#dateOfBirthInput").click();
        component.setDataMonth(month);
        return this;
    }
    public ObjectPageCheckForm setBirthYears(String years) {
        $("#dateOfBirthInput").click();
        component.setDataYears(years);
        return this;
    }
    public ObjectPageCheckForm setBirthDay(String day) {
        $("#dateOfBirthInput").click();
        component.setDataDay(day);
        return this;
    }

    public ObjectPageCheckForm setInputSubject(String value) {
        this.inputSubject = inputSubject.setValue(value).pressEnter();
        return this;
    }

    public ObjectPageCheckForm setHobbies(String value) {
        inputHobbies.$(byText(value)).click();
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

    public ObjectPageCheckForm setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public ObjectPageCheckForm setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        $("#submit").click();
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


