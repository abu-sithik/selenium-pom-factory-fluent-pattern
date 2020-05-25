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
    public HomePage launch() {
        driver.get("https://www.cleartrip.com/");
        return this;
    }

    /**
     * This method selects the trip type
     *
     * @param tripTypeOption Value of Trip Type
     */
    public HomePage selectTripType(String tripTypeOption) {
        tripType.findElement(By.xpath("//input[@value='" + tripTypeOption + "']")).click();
        return this;
    }

    /**
     * This method selects the place of origin
     *
     * @param origin Value of Origin
     */
    public HomePage selectOrigin(String origin) {
        this.origin.clear();
        this.origin.sendKeys(origin);
        wait.until(ExpectedConditions.visibilityOfAllElements(originOptions));
        originOptions.get(Indices.INDEX_0.getIndexValue()).click();
        return this;
    }
    

    /**
     * This method selects the destination
     *
     * @param destination Value of Destination
     */
    public HomePage selectDestination(String destination) {
        this.destination.clear();
        this.destination.sendKeys(destination);
        wait.until(ExpectedConditions.visibilityOfAllElements(destOptions));
        destOptions.get(Indices.INDEX_0.getIndexValue()).click();
        return this;
    }

    /**
     * This method picks the date from the date picker
     */
    public HomePage selectDate() {
        datePicker.click();
        return this;
    }

    /**
     * This method clicks on the search button after
     */
    public FlightResultsPage clickSearchButton() {
        searchButton.click();
        return new FlightResultsPage(driver);
    }

    /**
     * This method clicks on the "Hotels" link in the home page
     */
    public HotelsPage clickHotelsLink() {
        hotelLink.click();
        return new HotelsPage(driver);
    }

    /**
     * This method clicks on the "Your Tripis" link on the top right of the page
     */
    public HomePage clickYourTrips() {
        yourTrips.click();
        return this;
    }

    /**
     * This method clicks on the SignIn option which appears after clicking the "Your Trips" options
     */
    public SignInPopup clickSignInOption() {
        signIn.click();
        return new SignInPopup(driver);
    }

}
