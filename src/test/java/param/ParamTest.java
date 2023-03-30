package param;

import form.TestBase;
import form.data.States;
import form.generate.GenerateRandomDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

public class ParamTest extends TestBase {

    @ValueSource(strings = {
            "8495678928", "8916254986"
    })
    @Tag("FORM")
    @DisplayName("Корректный вывод в модельном окне номера телефона введенного при регистрации")
    @ParameterizedTest
    void сorrectShowPhoneNumber(String inputPhoneNumber) {
        String userName = GenerateRandomDate.getRandomName();
        String lastName = GenerateRandomDate.getRandomLastName();
        String email = GenerateRandomDate.getEmail();
        String gender = GenerateRandomDate.getRandomItemFromArray();
        String day = GenerateRandomDate.getRandomBirthDay();
        String month = GenerateRandomDate.getRandomBirthMonth();
        String years = GenerateRandomDate.getRandomBirthYears();

        objectPageCheckForm.openPage()
                .secretBanner()
                .setInputFirstName(userName)
                .setInputLastName(lastName)
                .setInputEmail(email)
                .setInputGender(gender)
                .setInputNumber(inputPhoneNumber)
                .setBirthMonth(month)
                .setBirthYears(years)
                .setBirthDay(day)
                .resultText()
                .verifyResult("Mobile", inputPhoneNumber);

    }


    @CsvSource(value = {
            "Djon, Week",
            "Donald, Trump"
    })
    @Tag("FORM")
    @ParameterizedTest(name = "Корректный вывод в модельном окне Имени {0},Фамилии{1} введенного при регистрации")
    void сorrectShowFirstNameLastName(String inputFirstName, String inputLastName) {

        String email = GenerateRandomDate.getEmail();
        String gender = GenerateRandomDate.getRandomItemFromArray();
        String number = GenerateRandomDate.getRandomNumber();
        String day = GenerateRandomDate.getRandomBirthDay();
        String month = GenerateRandomDate.getRandomBirthMonth();
        String years = GenerateRandomDate.getRandomBirthYears();

        objectPageCheckForm.openPage()
                .secretBanner()
                .setInputFirstName(inputFirstName)
                .setInputLastName(inputLastName)
                .setInputEmail(email)
                .setInputGender(gender)
                .setInputNumber(number)
                .setBirthMonth(month)
                .setBirthYears(years)
                .setBirthDay(day)
                .resultText()
                .verifyResult("Student Name", inputFirstName + " " + inputLastName);
    }

    static Stream<Arguments> сorrectShowStateCity() {
        return Stream.of(
                Arguments.of("NCR", List.of("Delhi Gurgaon Noida")),
                Arguments.of("Uttar Pradesh", List.of("Agra Lucknow Merrut")),
                Arguments.of("Haryana", List.of("Karnal Panipat")),
                Arguments.of("Rajasthan", List.of("Jaipur Jaiselmer")));
    }


    @MethodSource
    @Tag("FORM")
    @ParameterizedTest(name = "Проверка наличия опеределнного списка городов {1} для штата {0}")
    void сorrectShowStateCity(String state, List<String> cities) {


        objectPageCheckForm.openPage()
                .secretBanner()
                .setStateParam(state)
                .getCityParam()
                .checkCitiesParam(cities);


    }

    @Test
    @ParameterizedTest
    @EnumSource(value = States.class, names = {"NCR", "Haryana", "Rajasthan"})
    void testEnumSorce(States state) {
        String userName = GenerateRandomDate.getRandomName();
        String lastName = GenerateRandomDate.getRandomLastName();
        String email = GenerateRandomDate.getEmail();
        String gender = GenerateRandomDate.getRandomItemFromArray();
        String number = GenerateRandomDate.getRandomNumber();
        String day = GenerateRandomDate.getRandomBirthDay();
        String month = GenerateRandomDate.getRandomBirthMonth();
        String years = GenerateRandomDate.getRandomBirthYears();
        objectPageCheckForm.openPage()
                .secretBanner()
                .setInputFirstName(userName)
                .setInputLastName(lastName)
                .setInputEmail(email)
                .setInputGender(gender)
                .setInputNumber(number)
                .setBirthMonth(month)
                .setBirthYears(years)
                .setBirthDay(day)
                .setState(String.valueOf(state))
                .resultText()
                .verifyResult("State", String.valueOf(state));


    }
}
