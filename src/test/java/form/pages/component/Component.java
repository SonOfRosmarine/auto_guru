package form.pages.component;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Component {
    public void setData(String month, String years, String day) {

        $(".react-datepicker__month-dropdown-container").$(byText(month)).click();
        $(".react-datepicker__year-dropdown-container").$(byText(years)).click();
        $(".react-datepicker__month-container").$(byText(day)).click();
    }

}
