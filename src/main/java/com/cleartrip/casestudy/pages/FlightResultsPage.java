package com.cleartrip.casestudy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Class for Flight Results Page
 */
public class FlightResultsPage {

    /**
     * Instance of WebDriver
     */
    private WebDriver driver;

    /**
     * Search Summary WebElement
     */
    @FindBy(className = "searchSummary")
    private WebElement searchSummary;

    /**
     * Constructor for flight results page
     * @param driver The Webdriver Instance
     */
    public FlightResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This method checks whether Search Summary is available in the Flight Results page
     * @return true if search summary is availabe; Else, false is returned
     */
    public boolean isSearchSummaryAvailable() {
        return searchSummary.isDisplayed();
    }
}
