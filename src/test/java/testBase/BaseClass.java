package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
    public Logger logger; //for Logging
    public ResourceBundle rb;

    @Parameters({"browser"})
    @BeforeClass(groups={"master","sanity","regression"})
    public void setup(String br) {

        rb=ResourceBundle.getBundle("config");
        logger = LogManager.getLogger(this.getClass());  //for Logging


        String ExecutionMode = rb.getString("ExecutionMode");
        if(ExecutionMode.contains("Local")) {
            if (br.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("Launched Chrome Browser");
            } else if (br.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                logger.info("Launched Edge Browser");
            } else if (br.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info("Launched firefox Browser");
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (ExecutionMode.contains("Grid")) {
            // RemoteWebDriver driver = null;
            DesiredCapabilities cap = null;
            if (br.equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("no-sandbox");
                options.addArguments("start-maximized");
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
                cap = DesiredCapabilities.chrome();
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                cap.setBrowserName("chrome");
               // if (RemoteType.contains("VM")) {
               //     cap.setPlatform(Platform.WINDOWS);
                //} else if (RemoteType.contains("AWS")) {
                //    cap.setPlatform(Platform.LINUX);
                //}
            }
            try {
                driver = new RemoteWebDriver(new URL("https://oauth-anushamallela09-311ca:047e34ad-2c82-4854-930e-d64e578f6fe2@ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass(groups = {"master","sanity","regression"})
    public void teardown() {
        driver.close();
    }
    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
        FileUtils.copyFile(source, target);
    }
    public String randomestring() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }

    public int randomeNumber() {
        String generatedString2 = RandomStringUtils.randomNumeric(5);
        return (Integer.parseInt(generatedString2));
    }


}
