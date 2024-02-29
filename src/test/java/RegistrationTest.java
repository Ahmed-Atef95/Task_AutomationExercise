import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.RegistrationPage;
import static utils.DataDrivenReaderClass.JsonClass.readJson;

public class RegistrationTest extends TestBase{

    String timeStamp = String.valueOf(System.currentTimeMillis());
    String jsonRegistrationFilePath =  "C:\\selenium projects\\Assesment\\src\\test\\resources\\RegistrationData.json";

    @Test
    public void validRegistration(){
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.clickSignUpBtn();
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
        String actualResult = registrationPage.accountCreatedSuccessMsg();
        Assert.assertTrue(actualResult.contains("ACCOUNT CREATED!"),"Expected 'ACCOUNT CREATED!' but found: "+ actualResult);

    }


}
