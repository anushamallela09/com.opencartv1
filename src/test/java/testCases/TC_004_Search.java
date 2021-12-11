package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC_004_Search extends BaseClass {
    @Test
    public void testSearch() {
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();
        try {
            HomePage homePage = new HomePage(driver);
            String expectedSearchText = "iMac";
            homePage.setSearch("iMac");
            SearchResultPage searchResultPage = new SearchResultPage(driver);
            String actualSearchResult = searchResultPage.setSearchResult();
            if (actualSearchResult.equals(expectedSearchText)) {
                logger.info("Search test case passed");
                Assert.assertTrue(true);
            } else {
                logger.info("Search test case failed");
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            logger.fatal("search failed");
            Assert.fail();
        }
        }
    }

