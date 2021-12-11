package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "iMac")
    WebElement searchResult;

    public String setSearchResult() {
       String actualSearch = searchResult.getText();
       return actualSearch;
    }

    public void clickSearchResult() {
        searchResult.click();
    }
}
