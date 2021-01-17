package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Register extends BaseTest {

    @Test
    public void register() {
        CommonPage commonPage = new CommonPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);


        String email = "testas9@testas.com";
        String password = "Testukas10";
        String expectedErrorText = "Norėdami tęsti, privalote sutikti su taisyklėmis ir privatumo politika.";

        //Paspausti "PRISIJUNGIMAS"
        commonPage.openLoginPage();

        //Patikrinti ar matomos prisijungimo ir registracijos formos ar ne
        boolean loginBlockVisible = registerPage.loginBlockVisible();
        boolean registrationBlockVisible = registerPage.registrationBlockVisible();
        assertTrue(loginBlockVisible, "Login block is not visible");
        assertTrue(registrationBlockVisible, "Registration block is not visible");


        //Įrašyti registracijos formoje duomenis: email, password ir pakartot password
        //Uždėti 3 checkbox'us
        //paspausti "Registracijos" mygtuką
        registerPage.continueWithRegistration(email, password, password);


        //Patikrinti ar error tekstas rodomas jei nepaspaudėme sutikti su "Taisyklėmis"
        String actualErrorText = registerPage.getMessageText();  // surast kaip paselektint ta error message
        assertEquals(actualErrorText, expectedErrorText, "Text was different than expected");
    }
}
