package form;

import form.data.States;
import form.generate.GenerateRandomDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class ParamTest extends TestBase {

    @ValueSource(strings = {
            "8495678928", "8916254986"
    })
    @Tag("FORM")
    @DisplayName("Корректный вывод в модельном окне номера телефона введенного при регистрации")
    @ParameterizedTest
    void CorrectShowPhoneNumber(String inputPhoneNumber) {
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
    void CorrectShowFirstNameLastName(String inputFirstName, String inputLastName) {

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

    static Stream<Arguments> CorrectShowStateCity() {
        return Stream.of(
                Arguments.of(States.NCR, List.of("Delhi Gurgaon Noida")),
                Arguments.of(States.Uttar_Pradesh, List.of("Agra Lucknow Merrut")),
                Arguments.of(States.Haryana, List.of("Karnal Panipat")),
                Arguments.of(States.Rajasthan, List.of("Jaipur Jaiselmer")));
    }


    @MethodSource
    @Tag("FORM")
    @ParameterizedTest(name = "Проверка наличия опеределнного списка городов {1} для штата {0}")
    void CorrectShowStateCity(States state, List<String> cities) {


        objectPageCheckForm.openPage()
                .secretBanner()
                .setStateParam(state)
                .getCityParam()
                .checkCitiesParam(cities);


    }

}
