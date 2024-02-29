import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

WebDriver driver;


@BeforeMethod
public void setUp(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to("https://automationexercise.com/");
}


    @AfterMethod
    public void tearDown(){
     driver.quit();
    }

}
