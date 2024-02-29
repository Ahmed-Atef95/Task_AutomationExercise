package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleAlert {

    public static void dismissAlert(WebDriver driver, By alertTriggeringLocator) {
        driver.navigate().refresh();
        try {
            CustomMethods.click(driver, alertTriggeringLocator);
        } catch (Throwable throwable){
            //Do Nothing
        }
    }
}
