package form;

import form.generate.GenerateRandomDate;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CheckForm extends TestBase {

    @Tag("CheckForm")
    @Test
    public void successfulTest() {
        String userName = GenerateRandomDate.getRandomName();
        String lastName = GenerateRandomDate.getRandomLastName();
        String email = GenerateRandomDate.getEmail();
        String gender = GenerateRandomDate.getRandomItemFromArray();
        String number = GenerateRandomDate.getRandomNumber();
        String day = GenerateRandomDate.getRandomBirthDay();
        String month = GenerateRandomDate.getRandomBirthMonth();
        String years = GenerateRandomDate.getRandomBirthYears();
        String subjects = GenerateRandomDate.getRandomSubjekt();
        String hobbies = GenerateRandomDate.getRandomHobbiess();
        String address = GenerateRandomDate.getRandomAddress();
        String state = GenerateRandomDate.getRandomState();
        String city = GenerateRandomDate.getRandomCity(state);

        step("Открыть страницу", () -> {
            objectPageCheckForm.openPage();
        });
        step("Заполнить форму", () -> {
            objectPageCheckForm.secretBanner()
                    .setInputFirstName(userName)
                    .setInputLastName(lastName)
                    .setInputEmail(email)
                    .setInputGender(gender)
                    .setInputNumber(number)
                    .setBirthMonth(month)
                    .setBirthYears(years)
                    .setBirthDay(day)
                    .setInputSubject(subjects)
                    .setHobbies(hobbies)
                    .setUploadPicture()
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .resultText();
        });

        step("Осуществить проверку", () -> {
            objectPageCheckForm.verifyResult("Student Name", userName + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", number)
                    .verifyResult("Date of Birth", day + " " + month + "," + years)
                    .verifyResult("Subjects", subjects)
                    .verifyResult("Hobbies", hobbies)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city);
        });
    }


}
