package com.cleartrip.casestudy.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Base Test Class which is extended Test Classes
 */
public abstract class TestBase {

    /**
     * Static WebDriver Instance
     */
    protected static WebDriver driver;

     
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Suite level setup method where the static instance of the WebDriver is instantiated
     */
    @BeforeSuite
    public static void initDriver() {
    		
    		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        
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
    }
}
