import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {

    @FindBy(className = "product_sort_container")
    WebElement sortDropDown;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement sauceLabsOnesie;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement boltTShirt;

    @FindBy(css = "#shopping_cart_container span")
    WebElement cart;

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

    @FindBy(id = "remove-sauce-labs-onesie")
    WebElement removeOnesie;

    @FindBy(id = "remove-sauce-labs-bike-light" )
    WebElement removeBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement visibleOnesie;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement visibleBikeLight;


    public InventoryPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void SortItemByValue(){
        Select drop = new Select(sortDropDown);
        drop.selectByValue("lohi");
    }
    public String Cart(){
        return cart.getText();
    }
    public void AddOnesie(){
        sauceLabsOnesie.click();
    }
    public void AddBikeLight(){
        bikeLight.click();
    }
    public void AddTShirt(){
        boltTShirt.click();
    }
    public void ClickOnCart(){
        cart.click();
    }
    public void RemoveOnesie(){
        removeOnesie.click();
    }
    public void RemoveBikeLight(){
        removeBikeLight.click();
    }
    public void ClickOnContinueShopping(){
        continueShopping.click();
    }
}



