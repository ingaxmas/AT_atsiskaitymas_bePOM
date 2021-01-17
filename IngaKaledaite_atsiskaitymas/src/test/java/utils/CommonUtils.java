package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {
    public static void hoverOverElement(WebDriver driver, By locator) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator)).build().perform();
    }
}
