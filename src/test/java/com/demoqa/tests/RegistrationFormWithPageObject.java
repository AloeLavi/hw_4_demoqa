package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


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
                        .setPicture("img/crow-of-judgement.img");








        $("#currentAddress").setValue("Address 123");

        $("#state").scrollTo().click();
        $("[id=stateCity-wrapper]").$(byText("Haryana")).click();
        $("#city").click();
        $("[id=stateCity-wrapper]").$(byText("Karnal")).click();
        $("#submit").scrollTo().click();

        //results
        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Valeria Bagrova"));
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("vbagrova123456@gmail.com"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Female"));
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("1234567890"));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("02 August,1994"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Arts, Maths"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Reading"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("img/crow-of-judgement.jpg"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("Address 123"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("Haryana Karnal"));



    }
}
