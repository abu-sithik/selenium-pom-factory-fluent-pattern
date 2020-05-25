package com.cleartrip.casestudy.pages;

import com.cleartrip.casestudy.constants.Indices;
import com.cleartrip.casestudy.constants.WaitTimes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Page class for Home page
 */
public class HomePage {

    /**
     * Instance of WebDriver
     */
    private WebDriver driver;

    /**
     * Instance of WebDriverWait
     */
    private WebDriverWait wait;

    /**
     * TripType Webelement
     */
    @FindBy(xpath = "//nav[@class='row fieldRow tripType']")
    private WebElement tripType;


    /**
     * Origin Webelement
     */
    @FindBy(id = "FromTag")
    private WebElement origin;

    /**
     * Origin Options List
     */
    @FindBys({
            @FindBy(id = "ui-id-1"),
            @FindBy(tagName = "li")
    })
    private List<WebElement> originOptions;

    /**
     * Destination WebElement
     */
    @FindBy(id = "ToTag")
    private WebElement destination;

    /**
     * Destination Options List
     */
    @FindBys({
            @FindBy(id = "ui-id-2"),
            @FindBy(tagName = "li")
    })
    private List<WebElement> destOptions;

    /**
     * DatePicker WebElement
     */
    @FindBy(xpath = "//*[@id='ui-datepicker-div']//following::td[contains(@data-event, 'click')]//child::a")
    private WebElement datePicker;

    /**
     * Search Button WebElement
     */
    @FindBy(id = "SearchBtn")
    private WebElement searchButton;

    /**
     * Hotel Link WebElement
     */
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    /**
     * Your Trips link Element
     */
    @FindBy(linkText = "Your trips")
    private WebElement yourTrips;

    /**
     * SignIn Button that appears when clicking "YourTrips" Element
     */
    @FindBy(id = "SignIn")
    private WebElement signIn;

    /**
     * Constructor for Home page
     *
     * @param driver The WebDriver Instance
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, WaitTimes.TIME_5_SECONDS.getWaitTime());
    }

    /**
     * This method launches the home page
     */
    public void launch() {
        driver.get("https://www.cleartrip.com/");
    }

    /**
     * This method selects the trip type
     *
     * @param tripTypeOption Value of Trip Type
     */
    public void selectTripType(String tripTypeOption) {
        tripType.findElement(By.xpath("//input[@value='" + tripTypeOption + "']")).click();
    }

    /**
     * This method selects the place of origin
     *
     * @param origin Value of Origin
     */
    public void selectOrigin(String origin) {
        this.origin.clear();
        this.origin.sendKeys(origin);
        wait.until(ExpectedConditions.visibilityOfAllElements(originOptions));
        originOptions.get(Indices.INDEX_0.getIndexValue()).click();
    }

    /**
     * This method selects the destination
     *
     * @param destination Value of Destination
     */
    public void selectDestination(String destination) {
        this.destination.clear();
        this.destination.sendKeys(destination);
        wait.until(ExpectedConditions.visibilityOfAllElements(destOptions));
        destOptions.get(Indices.INDEX_0.getIndexValue()).click();
    }

    /**
     * This method picks the date from the date picker
     */
    public void selectDate() {
        datePicker.click();
    }

    /**
     * This method clicks on the search button after
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * This method clicks on the "Hotels" link in the home page
     */
    public void clickHotelsLink() {
        hotelLink.click();
    }

    /**
     * This method clicks on the "Your Tripis" link on the top right of the page
     */
    public void clickYourTrips() {
        yourTrips.click();
    }

    /**
     * This method clicks on the SignIn option which appears after clicking the "Your Trips" options
     */
    public void clickSignInOption() {
        signIn.click();
    }

}
