package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AccountLogoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

import java.io.IOException;

public class TC_003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void testLoginDDT(String email,String pwd,String exp) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setLogin(email,pwd);

            String actual_Title = myAccountPage.myAccount();
            String expected_Title = "My Account";
            if(exp.equals("Valid")) {

            if (actual_Title.equals(expected_Title)) {
                logger.info("Login Successful");
                myAccountPage.setLogout();
                Assert.assertTrue(true);
            } else {
                logger.info("Login unsuccessful");
                Assert.assertTrue(false);
            }
            }
            if(exp.equals("Invalid")) {

                if (actual_Title.equals(expected_Title)) {
                    logger.info("Login Successful");
                    myAccountPage.setLogout();
                    Assert.assertTrue(false);
                } else {
                    logger.info("Login unsuccessful");
                    Assert.assertTrue(true);
                }
            }
        }catch(Exception e) {
            logger.fatal("Login Failed");
            Assert.fail();
        }

        logger.info("TC_003_LoginDDT Finished");


    }
    @DataProvider(name="LoginData")
    public Object [][] getData() throws IOException
    {
        String path=".\\testData\\Opencart_LoginData.xlsx";

        XLUtility xlutil=new XLUtility(path);

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcols];

        for(int i=1;i<=totalrows;i++)  //1
        {
            for(int j=0;j<totalcols;j++)  //0
            {
                logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
            }
        }
        return logindata;

    }
}
