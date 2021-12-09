package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (id="input-email")
    WebElement txtEmailAddress;

    @FindBy(id="input-password")
    WebElement txtPassword;

    @FindBy(xpath="//input[@type='submit']")
    WebElement btLogin;

    public void setLogin(String emailAddress,String password) {
        txtEmailAddress.sendKeys(emailAddress);
        txtPassword.sendKeys(password);
        btLogin.click();
    }
}
