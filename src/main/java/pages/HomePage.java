package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomMethods;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By menTShirtAddToCartBtn = By.xpath("//a[@data-product-id='2']");
    private final By blueTopAddToCartBtn = By.xpath("//a[@data-product-id='1']");
    private final By continueShoppingBtn = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    private final By cartBtn = By.xpath("//ul[@class='nav navbar-nav']//a[@href=\"/view_cart\"]");
    private final By signUpBtn = By.xpath("//a[@href=\"/login\"]");
    private final By logoutBtn = By.xpath("//a[@href=\"/logout\"]");


    public void clickAddMenTShirtItemToCartBtn() {
        CustomMethods.findElementClickable(driver, menTShirtAddToCartBtn).click();
    }

    public void clickContinueShoppingBtn() {
        CustomMethods.findElementClickable(driver, continueShoppingBtn).click();
    }

    public void clickAddBlueTopItemToCartBtn() {
        CustomMethods.findElementClickable(driver, blueTopAddToCartBtn).click();
    }
    public void clickCartBtn() {
        CustomMethods.findElementClickable(driver, cartBtn).click();
    }
    public void clickSignUpBtn() {
        CustomMethods.findElementClickable(driver, signUpBtn).click();
    }

    public void clickLogoutBtn() {
        CustomMethods.findElementClickable(driver, logoutBtn).click();
    }

}
