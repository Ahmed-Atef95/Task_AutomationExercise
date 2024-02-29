package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomMethods;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
    }

    private final By nameOfCardField = By.xpath("//input[@data-qa='name-on-card']");
    private final By cardNumberField = By.xpath("//input[@data-qa='card-number']");
    private final By cvcField = By.xpath("//input[@data-qa='cvc']");
    private final By expirationMonthField = By.xpath("//input[@data-qa='expiry-month']");
    private final By expirationYearField = By.xpath("//input[@data-qa='expiry-year']");
    private final By payAndConfirmOrderBtn = By.xpath("//button[@data-qa='pay-button']");
    private final By downloadInvoicesBtn = By.xpath("//a[@href=\"/download_invoice/900\"]");

    private final By orderPlacedSuccessMsg = By.xpath("//h2[@data-qa='order-placed']/b");
    public void fillPaymentFields(String nameOfCard, String cardNo, String cvc, String expirationMonth,
                                  String expirationYear){
        CustomMethods.findElementVisible(driver,nameOfCardField).sendKeys(nameOfCard);
        CustomMethods.findElementVisible(driver,cardNumberField).sendKeys(cardNo);
        CustomMethods.findElementVisible(driver, cvcField).sendKeys(cvc);
        CustomMethods.findElementVisible(driver,expirationMonthField).sendKeys(expirationMonth);
        CustomMethods.findElementVisible(driver,expirationYearField).sendKeys(expirationYear);
    }

    public void clickPayAndConfirmOrderBtn(){
        CustomMethods.findElementClickable(driver,payAndConfirmOrderBtn).click();
    }

    public String orderPlacedSuccessMsg(){
        return   driver.findElement(orderPlacedSuccessMsg).getText();
    }
    public void clickDownloadInvoicesBtn(){
        CustomMethods.findElementClickable(driver,downloadInvoicesBtn).click();
    }



}
