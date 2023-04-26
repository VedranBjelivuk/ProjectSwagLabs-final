import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest{
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void SetUp(){
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test //2. a)
    public void Add3CheapestProductsInCart(){
        loginPage.Login("standard_user", "secret_sauce");
        inventoryPage.SortItemByValue();
        inventoryPage.AddOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.AddTShirt();
        Assert.assertEquals(inventoryPage.Cart(),"3");
    }
    @Test //2. b)
    public void Add2ProductsAndRemove(){
        loginPage.Login("standard_user", "secret_sauce");
        inventoryPage.AddBikeLight();
        inventoryPage.AddOnesie();
        inventoryPage.ClickOnCart();
        inventoryPage.RemoveBikeLight();
        inventoryPage.RemoveOnesie();
        inventoryPage.ClickOnContinueShopping();
        Assert.assertEquals(inventoryPage.visibleBikeLight.isDisplayed(),true);
        Assert.assertEquals(inventoryPage.visibleOnesie.isDisplayed(), true);
    }
    @AfterMethod
    public  void After(){
        driver.quit();
    }
}
