package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPage {
    WebDriver driver;

    public ProductDisplayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='iMac']")
    WebElement productDisplayName;

    @FindBy(id = "button-cart")
    WebElement buttonAddToCart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;

    @FindBy(linkText = "shopping cart")
    WebElement shoppingCart;

    public String setAddToCart() {
        buttonAddToCart.click();
        String actualSuccessMessage = successMessage.getText();
        return actualSuccessMessage;
    }

    public void setShoppingCart() {
        shoppingCart.click();
    }

    public String setProductDisplayName(){
      String actualProductDisplayName =  productDisplayName.getText();
      return actualProductDisplayName;
    }
}
