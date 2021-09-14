package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class PracticeFormPage {

    private SelenideElement modal = $("[role=dialog]");

    private Calendar calendar = new Calendar();

    public void openPage (){
        open("https://demoqa.com/automation-practice-form");
    }

    public PracticeFormPage typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public PracticeFormPage typeLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public PracticeFormPage typeEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage typePhone(String phone) {
        $("#userNumber").setValue(phone);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String subject){
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage setHobby(String hobby){
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String pictureName){
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + pictureName));
        return this;
    }

    public PracticeFormPage setCurrentAddress(String currentAddress){
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public PracticeFormPage setState(String state){
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public PracticeFormPage setCity(String city){
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public PracticeFormPage submit(){
        $("#submit").scrollTo().click();
        return this;
    }

    public PracticeFormPage checkResultsValue(String value) {
        modal.$(".table-responsive").shouldHave(text(value));
        return this;
    }
}
