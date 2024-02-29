package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomMethods;
import utils.GoogleAlert;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By proceedToCheckOutBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By registerBtn = By.xpath("//p[text()='Register / Login account to proceed on checkout.']//following::a[@href=\"/login\"]");
    private final By placeOrderBtn = By.cssSelector("a[href='/payment']");


   public void clickProceedToCheckOutBtn(){
       GoogleAlert.dismissAlert(driver,proceedToCheckOutBtn);
   }
    public void clickRegisterBtn(){
        CustomMethods.findElementClickable(driver,registerBtn).click();
    }
    public void clickPlaceOrderBtn(){
        CustomMethods.clickUsingJavaScript(driver,placeOrderBtn);
    }



}
