package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

import java.util.concurrent.TimeUnit;

public class TC_001_AccountRegistration extends BaseClass {


    @Test(groups = {"regression","master"})
    public void testAccountRegistration() {
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();
        try {
            logger.info("starting TC_001_AccountRegistration");

            HomePage homepage = new HomePage(driver);
            RegistrationPage registrationPage = new RegistrationPage(driver);
            homepage.clickMyAccount();
            logger.info("Clicked on MyAccount");
            homepage.clickRegister();
            logger.info("Clicked on Register");
            registrationPage.setRegistration("Anusha", "testtest", (registrationPage.randomeString() + "@gmail.com"),
                    "2098741523", "test", "test");
            logger.info("Enter User Details");
            String actualConfirmationMessage = registrationPage.getConfirmationMsg();
            String expectedConfirmationMessage = "Your Account Has Been Created!";
            if (actualConfirmationMessage.equals(expectedConfirmationMessage)) {
                Assert.assertTrue(true);
            } else {
                captureScreen(driver,"testAccountRegistration");
                Assert.assertTrue(false);
            }
        }catch(Exception e) {
            logger.fatal("Account Registration Failed");
            Assert.fail();
        }
            logger.info("TC_001_AccountRegistration Finished");
        }
}
