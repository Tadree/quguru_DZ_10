package ru.tadree;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;


import static io.qameta.allure.Allure.step;


public class FormTest extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    String phone = faker.numerify("##########");
    String day = "1";
    String month = "January";
    String year = "2000";
    String subject = "Biology";
    String hobby = "Music";
    String picture = "DZ2.png";
    String currentAddress = faker.address().fullAddress();
    String state = "Uttar Pradesh";
    String city = "Agra";


    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void positiveFillTest() {

        step("Open students registration form", () -> {
            practiceFormPage.openPage();
        });

        step("Fill students registration form", () -> {
            practiceFormPage.typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeEmail(email)
                    .selectGender(gender)
                    .typePhone(phone)
                    .setDateOfBirth("01", "January", "2000")
                    .setSubject(subject)
                    .setHobby(hobby)
                    .uploadPicture(picture)
                    .setCurrentAddress(currentAddress)
                    .setState("Uttar Pradesh")
                    .setCity("Agra")
                    .submit();
        });

        step("Verify successful form submit", () -> {
            practiceFormPage.checkResultsValue(firstName + " " + lastName)
                    .checkResultsValue(email)
                    .checkResultsValue(gender)
                    .checkResultsValue(phone)
                    .checkResultsValue(day + " " + month + "," + year)
                    .checkResultsValue(subject)
                    .checkResultsValue(hobby)
                    .checkResultsValue(picture)
                    .checkResultsValue(currentAddress)
                    .checkResultsValue(state + " " + city);
        });
    }
}
