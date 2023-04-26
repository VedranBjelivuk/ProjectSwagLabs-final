import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BasePage{

    @FindBy(id = "checkout")
    WebElement checkout;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(css = "div.summary_subtotal_label")
    WebElement itemTotalPrice;

    @FindBy(css = "div.summary_total_label")
    WebElement totalPrice;

    @FindBy(id = "finish")
    WebElement finish;

    @FindBy(className = "complete-header")
    WebElement completeOrder;


    public CheckOutPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void  EnterFirstName(String name){
        firstName.sendKeys(name);
    }
    public void EnterLastName (String last){
        lastName.sendKeys(last);
    }
    public void EnterPostalCode (String postal){
        postalCode.sendKeys(postal);
    }
    public void ClickContinue (){
        continueButton.click();
    }
    public void ClickFinish (){
        finishButton.click();
    }
    public void ClickCheckOut (){
        checkout.click();
    }
    public String ItemTotalPrice(){
        return itemTotalPrice.getText();
    }
    public String TotalPrice(){
        return totalPrice.getText();
    }
    public void ClickOnFinishButton(){
        finish.click();
    }
    public String OrderCompleted(){
        return completeOrder.getText();
    }
}


