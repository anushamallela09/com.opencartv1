package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExtentReportManager;

public class HomePage extends ExtentReportManager {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Login")
    WebElement lnkLogin;

    @FindBy(linkText = "Register")
    WebElement lnkRegister;

    @FindBy(linkText = "My Account")
    WebElement lnkMyAccount;



    public void clickMyAccount() {
        lnkMyAccount.click();
    }
    public void clickRegister() {
        lnkRegister.click();
    }
    public void clickLogin() {
        lnkLogin.click();
    }
}
