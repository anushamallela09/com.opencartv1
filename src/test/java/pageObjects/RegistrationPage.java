package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExtentReportManager;

public class RegistrationPage extends ExtentReportManager {

    WebDriver driver;

   public RegistrationPage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver,this);
   }

    @FindBy(id="input-firstname")
    WebElement txtFirstName;

    @FindBy(id="input-lastname")
    WebElement txtLastName;

    @FindBy(id="input-email")
    WebElement txtEmail;

    @FindBy(id="input-telephone")
    WebElement txtTelephone;

    @FindBy(id="input-password")
    WebElement txtPassword;

    @FindBy(id="input-confirm")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkPrivacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement txtContinue;

    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement createdAccount;

    public void setRegistration(String fname,String lastname,String email,String telephone,String password,String confirmpassword) {
        txtFirstName.sendKeys(fname);
        txtLastName.sendKeys(lastname);
        txtEmail.sendKeys(email);
        txtTelephone.sendKeys(telephone);
        txtPassword.sendKeys(password);
        txtConfirmPassword.sendKeys(confirmpassword);
        chkPrivacyPolicy.click();
        txtContinue.click();
    }

    public String getConfirmationMsg() {
        try {
            String confirmMessage = createdAccount.getText();
            return confirmMessage;
        } catch(Exception e) {
            return(e.getMessage());
        }
    }


}
