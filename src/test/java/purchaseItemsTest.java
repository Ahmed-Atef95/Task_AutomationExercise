import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.RegistrationPage;
import static utils.DataDrivenReaderClass.JsonClass.readJson;


public class purchaseItemsTest extends TestBase{
    String timeStamp = String.valueOf(System.currentTimeMillis());
    String jsonRegistrationFilePath =  "C:\\selenium projects\\Assesment\\src\\test\\resources\\RegistrationData.json";
    String jsonPaymentFilePath =  "C:\\selenium projects\\Assesment\\src\\test\\resources\\PaymentData.json";


    @Test
    public void purchaseMenTShirt(){
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        PaymentPage paymentPage =  new PaymentPage(driver);
        homePage.clickAddMenTShirtItemToCartBtn();
        homePage.clickContinueShoppingBtn();
        homePage.clickAddBlueTopItemToCartBtn();
        homePage.clickContinueShoppingBtn();
        homePage.clickCartBtn();
        cartPage.clickProceedToCheckOutBtn();
        cartPage.clickRegisterBtn();
        registrationPage.fillUserNameAndEmailFields(readJson(jsonRegistrationFilePath,"userName"),
                readJson(jsonRegistrationFilePath,"email")+ timeStamp +
                        readJson(jsonRegistrationFilePath, "emailDomain"));

        registrationPage.clickSignUpBtn();
        registrationPage.clickMrRadioBtn();
        registrationPage.fillPasswordField(readJson(jsonRegistrationFilePath,"password"));
        registrationPage.fillDateOfBirth(
                readJson(jsonRegistrationFilePath,"day"),
                readJson(jsonRegistrationFilePath,"month"),
                readJson(jsonRegistrationFilePath,"year"));
        registrationPage.clickNewslettersAndOffers();
        registrationPage.fillAddressInfo(
                readJson(jsonRegistrationFilePath,"firstName"),
                readJson(jsonRegistrationFilePath,"lastName"),
                readJson(jsonRegistrationFilePath,"company"),
                readJson(jsonRegistrationFilePath,"address1"),
                readJson(jsonRegistrationFilePath,"address2"),
                readJson(jsonRegistrationFilePath,"state"),
                readJson(jsonRegistrationFilePath,"city"),
                readJson(jsonRegistrationFilePath,"zipCode"),
                readJson(jsonRegistrationFilePath,"mobileNumber"));
        registrationPage.clickCreateAccountBtn();
        String actualResultForCreatedAccountMsg = registrationPage.accountCreatedSuccessMsg();
        Assert.assertTrue(actualResultForCreatedAccountMsg.contains("ACCOUNT CREATED!"),"Expected 'ACCOUNT CREATED!' but found: "+ actualResultForCreatedAccountMsg);

        registrationPage.clickContinuetBtn();
        homePage.clickCartBtn();
        cartPage.clickProceedToCheckOutBtn();
        cartPage.clickPlaceOrderBtn();
        paymentPage.fillPaymentFields(
                readJson(jsonPaymentFilePath,"nameOfCard"),
                readJson(jsonPaymentFilePath, "cardNo"),
                readJson(jsonPaymentFilePath,"cvc"),
                readJson(jsonPaymentFilePath,"expirationMonth"),
                readJson(jsonPaymentFilePath,"expirationYear"));
        paymentPage.clickPayAndConfirmOrderBtn();
       paymentPage.clickDownloadInvoicesBtn();
        String actualResultForSuccessOrderPlacedMsg = paymentPage.orderPlacedSuccessMsg();
        Assert.assertTrue(actualResultForSuccessOrderPlacedMsg.contains("ORDER PLACED!"),"Expected 'ORDER PLACED!' but found: "+ actualResultForSuccessOrderPlacedMsg );

        homePage.clickLogoutBtn();

    }

}
