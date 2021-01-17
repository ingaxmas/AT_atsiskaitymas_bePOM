package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    //------------Locators---------------------

    By loginForm = By.xpath("//form[@action='/login-check']");
    By registerForm = By.id("customer_registration");
    By emailInputField = By.id("customer_registration_email");
    By passwordInputField = By.id("customer_registration_user_plainPassword_first");
    By passwordInputFieldSecond = By.id("customer_registration_user_plainPassword_second");
    By generalOffers = By.id("customer_registration_marketing_generalOffers");
    By personalOffers = By.id("customer_registration_marketing_personalOffers");
    //By agreeWithTerms = By.id("customer_registration_marketing_acceptSensitiveData");
    By getPersonalOffersTo = By.id("customer_registration_marketing_typeAddress");
    By registerButton = By.xpath("//*[@id=\"customer_registration\"]/button");
    By registerFormMessageText = By.cssSelector(".error-message ");

    public boolean loginBlockVisible() {
        return driver.findElement(loginForm).isDisplayed();
    }

    public boolean registrationBlockVisible() {
        return driver.findElement(registerForm).isDisplayed();
    }

    public void continueWithRegistration(String email, String password, String secondPassword) {
        enterEmailAddress(email);
        enterPassword(password);
        enterSecondPassword(password);
        clickGeneralOffersCheckBox();
        clickPersonalOffersCheckBox();
        clickGetPersonalOffersCheckBox();
        clickRegisterButton();

    }

    public void enterEmailAddress(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public void enterSecondPassword(String password) {
        driver.findElement(passwordInputFieldSecond).sendKeys(password);
    }

    public void clickGeneralOffersCheckBox() {
        driver.findElement(generalOffers).click();
    }

    public void clickPersonalOffersCheckBox() {
        driver.findElement(personalOffers).click();
    }

    public void clickGetPersonalOffersCheckBox() {
        driver.findElement(getPersonalOffersTo).click();
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getMessageText() {
        return driver.findElement(registerFormMessageText).getText();
    }

}
