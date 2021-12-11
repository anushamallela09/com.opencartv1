package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//table[@class='table table-bordered']//tbody//tr[1]/td[2]//a")
    WebElement productName;

    public String setPageTitle(){
     String actualPageTitle = driver.getTitle();
     return actualPageTitle;
    }

    public String setProductName() {
        String actualProductName = productName.getText();
        return  actualProductName;
    }

}
