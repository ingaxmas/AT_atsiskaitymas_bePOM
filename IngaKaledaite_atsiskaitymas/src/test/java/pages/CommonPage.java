package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    //------------------Locators--------------------
    By myLoginLink = By.cssSelector("a[href$='/login']");
    By mainSearchInputField = By.xpath("//*[@id=\"search-block\"]/div/span/span/input[2]");
    By clickSearch = By.xpath("//*[@id=\"search-block\"]/div/span/span/input[2]");




    //----------------Methods-------------------------
    public void openLoginPage(){
        driver.findElement(myLoginLink).click();
    }

    public void searchMainCategory(String categoryToOpen) {
        driver.findElement(mainSearchInputField).sendKeys(categoryToOpen);
        driver.findElement(clickSearch).sendKeys(Keys.ENTER);
    }


    public void searchByBrand(){

    }
}
