package form.pages.component;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Component {
    public void setDataMonth(String month) {
        $(".react-datepicker__month-dropdown-container").$(byText(month)).click();
    }
    public void setDataYears(String years) {
        $(".react-datepicker__year-dropdown-container").$(byText(years)).click();
    }
    public void setDataDay(String day) {
        $(".react-datepicker__month-container").$(byText(day)).click();
    }

}
