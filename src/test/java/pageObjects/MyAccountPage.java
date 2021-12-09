package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement lnkMyAccount;

    @FindBy(linkText = "Logout")
    WebElement lnkLogout;

    public String myAccount() {
        String title = driver.getTitle();
        return title;
    }

    public void setLogout() {
        lnkMyAccount.click();
        lnkLogout.click();
    }
}
