import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class
LoginTest extends BaseTest{
    ChromeDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void SetUp(){
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
    }
    @Test
    public void LoginWithValidData(){
        loginPage.Login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void LoginWithWrongUserName(){
        loginPage.Login("standarduser","secret_sauce");
        Assert.assertEquals(loginPage.getTextMessage(), "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void LoginWithWrongPassword(){
        loginPage.Login("standard_user", "secretsauce");
        Assert.assertEquals(loginPage.getTextMessage(), "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void LoginWithWrongUserAndPass(){
        loginPage.Login("standarduser","secretsauce");
        Assert.assertEquals(loginPage.getTextMessage(), "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void LoginWithEmptyUserAndPass(){
        loginPage.Login("", "");
        Assert.assertEquals(loginPage.getTextMessage(), "Epic sadface: Username is required");
    }
    @AfterMethod
    public  void After(){
        driver.quit();

    }
}
