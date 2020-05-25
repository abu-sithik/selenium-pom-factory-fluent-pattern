package com.cleartrip.casestudy;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.javafx.PlatformUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.lang.reflect.Method;

import static org.apache.log4j.Logger.getLogger;

/**
 * Base Test Class which is extended Test Classes
 */
public abstract class TestBase {

    /**
     * Static WebDriver Instance
     */
    protected static WebDriver driver;

    /**
     * The constant extent.
     */
    private static ExtentReports extent;

    /**
     * The constant test.
     */
    public static ExtentTest test;

    /**
     * Static Logger instance
     */
    private static final Logger LOGGER = getLogger(TestBase.class);

    /**
     * Constant representing Interger Value for Pass status
     */
    private static final int PASS = 1;

    /**
     * Constant representing Interger Value for Fail status
     */
    private static final int FAIL = 2;

    /**
     * Constant representing Interger Value for Skip status
     */
    private static final int SKIP = 3;
    
    
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Suite level setup method where the static instance of the WebDriver is instantiated
     */
    @BeforeSuite
    public static void initDriver() {
    		
        String path = System.getProperty("user.dir");
        if (PlatformUtil.isMac()) {
        		System.out.println(path);
            System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/chromedriver_chrome_ver_81_mac");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/chromedriver_chrome_ver_81.exe");
        }

        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/chromedriver_chrome_ver_81_linux");
        }

        ChromeOptions options = new ChromeOptions();

        // The following statement sets the argument to disable notification in chrome when executing the tests
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    
    /**
     * Suite level tear-down method to quit the WebDriver instance
     */
    @AfterSuite
    public void quitDriver() {
        driver.quit();
        extent.flush();
    }
}
