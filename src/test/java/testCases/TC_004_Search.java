package testCases;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_Search extends BaseClass {

    public void testSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.setSearch("iMac");
    }
}
