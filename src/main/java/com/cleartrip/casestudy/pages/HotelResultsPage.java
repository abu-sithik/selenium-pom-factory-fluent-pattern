package com.cleartrip.casestudy.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for Hotel Results page
 */
public class HotelResultsPage {

    /**
     * WebDriver Instance =
     */
    private WebDriver driver;

    /**
     * Hotel Search Summary WebElement
     */
    @FindBy(className = "searchSummary")
    private WebElement searchSummary;

    /**
     * Constructor for Hotel Results Page
     * @param driver WebDriver Instance
     */
    public HotelResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This method checks whether the Search Summary element is available in the Search Results page
     * @return true if Search Summary is available; Else, false is returned
     */
    public boolean isSearchSummaryAvailable() {
        try {
            return searchSummary.isDisplayed();
        }
        catch (NoSuchElementException NSE) {
            return false;
        }
    }
}
