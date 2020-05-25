package com.cleartrip.casestudy.pages;

import com.cleartrip.casestudy.constants.Indices;
import com.cleartrip.casestudy.constants.WaitTimes;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Page class for Hotels Home page
 */
public class HotelsPage {

    /**
     * WebDriver Instance
     */
    private WebDriver driver;

    /**
     * WebDriverWait Instance
     */
    private WebDriverWait wait;

    /**
     * Locality textbox element
     */
    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    /**
     * Search Button WebElement
     */
    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    /**
     * Traveller Selection WebElement
     */
    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    /**
     * List of Localities
     */
    @FindBys({
            @FindBy(id = "ui-id-1"),
            @FindBy(tagName = "li")
    })
    private List<WebElement> localityOptions;

    /**
     * Constructor for Hotels Page
     *
     * @param driver WebDriver Instance
     */
    public HotelsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, WaitTimes.TIME_10_SECONDS.getWaitTime());
    }

    /**
     * This method selects the locality based on the specified string representation of the locality
     *
     * @param locality Value of locality
     */
    public HotelsPage selectLocality(String locality) {
        wait.until(ExpectedConditions.visibilityOf(localityTextBox));
        localityTextBox.clear();
        localityTextBox.sendKeys(locality);
        wait.until(ExpectedConditions.visibilityOfAllElements(localityOptions));
        localityOptions.get(Indices.INDEX_1.getIndexValue()).click();
        return this;
    }

    /**
     * This method selects Traveller option based on the specified option
     *
     * @param travellersOption Value of the traveller option to be selected
     */
    public HotelsPage selectTravellerOption(String travellersOption) {
        Select travellerSelect = new Select(travellerSelection);
        travellerSelect.selectByVisibleText(travellersOption);
        return this;
    }

    /**
     * This method clicks the search button
     */
    public HotelResultsPage clickSearchButton() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).moveToElement(searchButton).click().perform();
        return new HotelResultsPage(driver);
    }
}
