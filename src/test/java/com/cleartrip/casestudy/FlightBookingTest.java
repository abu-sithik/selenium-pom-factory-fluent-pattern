package com.cleartrip.casestudy;

import com.cleartrip.casestudy.pages.FlightResultsPage;
import com.cleartrip.casestudy.pages.HomePage;
import com.cleartrip.casestudy.constants.Cities;
import com.cleartrip.casestudy.constants.TripTypes;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Class containing test for validating search-flight results
 */
public class FlightBookingTest extends TestBase {

    /**
     * Instance of HomePage class
     */
    private HomePage homePage;

    /**
     * Instance of FlightResultsPage class
     */
    private FlightResultsPage flightResultsPage;

    /**
     * Class level test-Setup method that intantiates {@link HomePage} and {@link FlightResultsPage}
     */
    @BeforeClass
    public void testClasSetup() {
        homePage = new HomePage(driver);
        flightResultsPage = new FlightResultsPage(driver);
    }

    /**
     * Test method for verifying whether search summary is rightly displayed when searching for flights
     */
    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        homePage.launch();
        homePage.selectTripType(TripTypes.ONE_WAY.getTripType());
        homePage.selectOrigin(Cities.BANGALORE.getCity());
        homePage.selectDestination(Cities.Delhi.getCity());
        homePage.selectDate();
        homePage.clickSearchButton();
        Assert.assertTrue(
                flightResultsPage.isSearchSummaryAvailable(),
                "Search Summary is not available after clicking the Search Button when searching for flights");
    }


}
