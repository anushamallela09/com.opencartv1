package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountLogoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {

    @Test(groups={"master","sanity"})
    public void testLogin() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setLogin(rb.getString("email"), rb.getString("password"));

            String actual_Title = myAccountPage.myAccount();
            String expected_Title = "My Account";
            if (actual_Title.equals(expected_Title)) {
                Assert.assertTrue(true);
                logger.info("Login Successful");
            } else {
                logger.info("Login unsuccessful");
                captureScreen(driver,"testLogin");
                Assert.assertTrue(false);

            }
        }catch(Exception e) {
            logger.fatal("Login Failed");
            Assert.fail();
        }
        logger.info("TC_002_Login Finished");
        myAccountPage.setLogout();
        AccountLogoutPage accountLogoutPage = new AccountLogoutPage(driver);
        String actLogOut = accountLogoutPage.txtLogOut();
        String expLogOut = "Account Logout";

        if(actLogOut.equals(expLogOut)) {
            Assert.assertTrue(true);
            logger.info("Logout Successful");
        } else {
            logger.info("Logout Failed");
            Assert.assertTrue(false);
        }
    }
}
