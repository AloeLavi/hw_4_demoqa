package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




public class RegistrationFormWithPageObject {


    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1600x800";
        Configuration.holdBrowserOpen = true;

    }


    @Test
    void fillNameTest(){

        registrationFormPage.openPage()
                .setFirstName("Valeria")
                .setLastName("Bagrova")
                .setEmail("vbagrova123456@gmail.com")
                .setGender("Female")
                .setNumber("1234567890")
                .setBirthDate("02", "August", "1994")
                .setSubjects("Arts")
                .setSubjects("Maths")
                .setHobbies("Reading")
                .setPicture("img/crow.jpg")
                .setAddress("My Street")
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit();


        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name","Valeria Bagrova")
                .checkResult("Student Email","vbagrova123456@gmail.com")
                .checkResult("Gender","Female")
                .checkResult("Mobile","1234567890")
                .checkResult("Date of Birth","02 August,1994")
                .checkResult("Subjects","Arts, Maths")
                .checkResult("Hobbies","Reading")
                .checkResult("Picture","crow.jpg")
                .checkResult("Address","My Street")
                .checkResult("State and City","Haryana Karnal");







/*


        //results
        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Valeria Bagrova"));
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("vbagrova123456@gmail.com"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Female"));
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("1234567890"));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("02 August,1994"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Arts, Maths"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Reading"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("img/crow.jpg"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("Address 123"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("Haryana Karnal"));
*/


    }
}
