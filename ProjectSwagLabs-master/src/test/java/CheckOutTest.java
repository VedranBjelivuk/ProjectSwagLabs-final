import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest{
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckOutPage checkoutPage;

    @BeforeMethod
    public void SetUp(){
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutPage = new CheckOutPage(driver);
    }
    @Test //3. a)
    public void ItemTotal (){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.AddTShirt();
        inventoryPage.AddOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.ClickOnCart();
        checkoutPage.ClickCheckOut();
        checkoutPage.EnterFirstName("Vedran");
        checkoutPage.EnterLastName("Bjelivuk");
        checkoutPage.EnterPostalCode("11000");
        checkoutPage.ClickContinue();
        checkoutPage.ItemTotalPrice();
        Assert.assertEquals(checkoutPage.ItemTotalPrice(),"Item total: $33.97");
    }
    @Test //3. b)
    public void TotalPrice(){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.AddTShirt();
        inventoryPage.AddOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.ClickOnCart();
        checkoutPage.ClickCheckOut();
        checkoutPage.EnterFirstName("Vedran");
        checkoutPage.EnterLastName("Bjelivuk");
        checkoutPage.EnterPostalCode("11000");
        checkoutPage.ClickContinue();
        checkoutPage.TotalPrice();
        Assert.assertEquals(checkoutPage.TotalPrice(), "Total: $36.69");
    }
    @Test //5.
    public void FinishOrder(){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.AddTShirt();
        inventoryPage.AddOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.ClickOnCart();
        checkoutPage.ClickCheckOut();
        checkoutPage.EnterFirstName("Vedran");
        checkoutPage.EnterLastName("Bjelivuk");
        checkoutPage.EnterPostalCode("11000");
        checkoutPage.ClickContinue();
        checkoutPage.ClickFinish();
        Assert.assertEquals(checkoutPage.OrderCompleted(),"Thank you for your order!");
    }
    @AfterMethod
    public void After(){
        driver.quit();
    }
}
