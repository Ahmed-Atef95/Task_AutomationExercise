package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.CustomMethods;
import utils.GoogleAlert;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameField = By.xpath("//input[@data-qa='signup-name']");
    private final By emailField = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpBtn = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By mrRadioBtn = By.xpath("//input[@id='id_gender1']");
    private final By passwordField = By.xpath("//input[@data-qa='password']");
    private final By daysField = By.xpath("//select[@id='days']");
    private final By monthsField = By.xpath("//select[@id='months']");
    private final By yearsField = By.xpath("//select[@id='years']");
    private final By newsLetterCheckBox = By.xpath("//input[@id='newsletter']");
    private final By offersOptingCheckBox = By.xpath("//input[@id='optin']");
    private final By firstNameField = By.xpath("//input[@id='first_name']");
    private final By lastNameField = By.xpath("//input[@id='last_name']");
    private final By companyField = By.xpath("//input[@id='company']");
    private final By address1Field = By.xpath("//input[@id='address1']");
    private final By address2Field = By.xpath("//input[@id='address2']");
    private final By stateField = By.xpath("//input[@id='state']");
    private final By cityField = By.xpath("//input[@id='city']");
    private final By zipCodeField = By.xpath("//input[@id='zipcode']");
    private final By mobileNumberField = By.xpath("//input[@id='mobile_number']");
    private final By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    private final By continueBtn = By.xpath("//a[@data-qa='continue-button']");
    private final By accountCreatedSuccessMsg = By.xpath("//h2[@data-qa='account-created']//b");


    public void fillUserNameAndEmailFields(String userName, String email){
        CustomMethods.findElementVisible(driver,userNameField).sendKeys(userName);
        CustomMethods.findElementVisible(driver,emailField).sendKeys(email);
    }

    public void clickSignUpBtn(){
        CustomMethods.findElementClickable(driver,signUpBtn).click();
    }

    public void clickMrRadioBtn(){
        CustomMethods.findElementClickable(driver,mrRadioBtn).click();
    }
    public void fillPasswordField(String password){
        CustomMethods.findElementVisible(driver,passwordField).sendKeys(password);
    }

    public void fillDateOfBirth(String day, String month, String year){
        Select selectDay = new Select(CustomMethods.findElementVisible(driver,daysField));
        selectDay.selectByVisibleText(day);
        Select selectMonth = new Select(CustomMethods.findElementVisible(driver,monthsField));
        selectMonth.selectByVisibleText(month);
        Select selectYear = new Select(CustomMethods.findElementVisible(driver,yearsField));
        selectYear.selectByVisibleText(year);
}

    public void clickNewslettersAndOffers(){
        CustomMethods.clickUsingJavaScript(driver,newsLetterCheckBox);
        CustomMethods.clickUsingJavaScript(driver,offersOptingCheckBox);
    }

    public void fillAddressInfo(String fName, String lName, String company,String address1, String address2,
                                String state, String city, String zipCode, String mobileNumber){
       CustomMethods.findElementVisible(driver,firstNameField).sendKeys(fName);
       CustomMethods.findElementVisible(driver,lastNameField).sendKeys(lName);
       CustomMethods.findElementVisible(driver,companyField).sendKeys(company);
       CustomMethods.findElementVisible(driver,address1Field).sendKeys(address1);
       CustomMethods.findElementVisible(driver,address2Field).sendKeys(address2);
       CustomMethods.findElementVisible(driver,stateField).sendKeys(state);
       CustomMethods.findElementVisible(driver,cityField).sendKeys(city);
       CustomMethods.findElementVisible(driver,zipCodeField).sendKeys(zipCode);
       CustomMethods.findElementVisible(driver,mobileNumberField).sendKeys(mobileNumber);
    }

    public void clickCreateAccountBtn(){
        CustomMethods.clickUsingJavaScript(driver,createAccountBtn);
    }

    public void clickContinuetBtn(){
        CustomMethods.findElementClickable(driver,continueBtn).click();
        GoogleAlert.dismissAlert(driver,continueBtn);
    }

    public String accountCreatedSuccessMsg(){
     return driver.findElement(accountCreatedSuccessMsg).getText();
    }








}
