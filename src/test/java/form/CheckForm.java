package form;

import form.pages.TestBase;
import org.junit.jupiter.api.Test;

public class CheckForm extends TestBase {


    @Test

    public void succedfulTest() {
        String userName = "Valera";
        String lastName = "Staroff";
        String email = "wewe@sdasd.ru";
        String number = "7111256545";
        String day = "22";
        String month = "January";
        String years = "1989";
        String subjects = "E";
        String address = "Minsk";


        objectPageCheckForm.openPage()
                .setInputFirstName(userName)
                .setInputLastName(lastName)
                .setInputEmail(email)
                .setInputGender()
                .setInputNumber(number)
                .setBirth(month, years, day)
                .setInputSubject(subjects)
                .setHobbies()
                .setUploadPicture()
                .setAddress(address)
                .setState()
                .setCity()
                .resultText()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", day + " " + month + "," + years)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", "Sport")
                .verifyResult("Address", address)
                .verifyResult("State and City", "Haryana" + " " + "Karnal");

    }


}
