package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_005_AddToCart extends BaseClass {
    @Test
    public void testAddToCart() {

        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();
        String expectedSearchText = "iMac";
        String expectedPageTitle = "Shopping Cart";

        HomePage homePage = new HomePage(driver);
        homePage.setSearch("iMac");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String actualSearchResult = searchResultPage.setSearchResult();
        if (actualSearchResult.equals(expectedSearchText)) {
            logger.info("Search  passed");
            Assert.assertTrue(true);
        } else {
            logger.info("Search  failed");
            Assert.assertTrue(false);
        }

        searchResultPage.clickSearchResult();
        ProductDisplayPage productDisplayPage = new ProductDisplayPage(driver);
        String actualProductDisplayName = productDisplayPage.setProductDisplayName();

        if (actualProductDisplayName.equals(expectedSearchText)) {
            logger.info("Productname is displayed in Productdisplaypage");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
            logger.info("Productname is not displayed in Productdisplaypage");
        }

        productDisplayPage.setAddToCart();
        productDisplayPage.setShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        String actualTitle = shoppingCartPage.setPageTitle();

        if (actualTitle.equals(expectedPageTitle)) {
            Assert.assertTrue(true);
            logger.info("ShoppingCart Page is displayed");
        } else {
            logger.info("ShoppingCart Page is not displayed");
            Assert.assertTrue(false);
        }

        String actualProductName = shoppingCartPage.setProductName();
        if (actualProductName.equals(expectedSearchText)) {
            logger.info("product is added into shopping casr page");
            Assert.assertTrue(true);
        } else {
            logger.info("Product is not added into shopping cart page");
            Assert.assertTrue(false);
        }

    }
}
