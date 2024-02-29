package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomMethods {



    public static WebElement findElement(WebDriver driver, By locator){
        return wait(driver,10).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement findElementVisible(WebDriver driver, By locator){

        return wait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement findElementClickable(WebDriver driver, By locator){
        return wait(driver,10).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void click(WebDriver driver, By locator){
       findElementClickable(driver, locator).click();
    }

    public static void clickUsingJavaScript(WebDriver driver, By locator){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", findElementClickable(driver,locator));
    }



    public static void findElementClickableAndVisible(WebDriver driver, By locator){
        wait(driver,10).until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(locator),ExpectedConditions.elementToBeClickable(locator)));
    }


    private static WebDriverWait wait(WebDriver driver, int timeout){
        return  new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }


}
