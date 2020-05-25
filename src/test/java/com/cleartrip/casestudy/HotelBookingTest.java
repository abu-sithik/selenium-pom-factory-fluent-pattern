package com.cleartrip.casestudy;

import com.cleartrip.casestudy.pages.HomePage;
import com.cleartrip.casestudy.pages.HotelsPage;
import com.cleartrip.casestudy.constants.Localities;
import com.cleartrip.casestudy.constants.TravellerOptions;
import com.cleartrip.casestudy.pages.HotelResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import com.cleartrip.casestudy.listeners.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;


/**
 * Class containing test for validating search-hotels results
 */
public class HotelBookingTest extends TestBase {

    /**
     * Instance of HomePage class
     */
    private HomePage homePage;

    /**
     * Instance of HotelResultsPage
     */
    private HotelResultsPage hotelResultsPage;

    /**
     * Instance of HotelsHomePage
     */
    private HotelsPage hotelsHomePage;

    /**
     * Class level test-setup method that instantiates {@link HomePage}, {@link HotelResultsPage} & {@link HotelsPage}
     */
    @BeforeClass
    public void testClasSetup() {
        homePage = new HomePage(driver);
        hotelResultsPage = new HotelResultsPage(driver);
        hotelsHomePage = new HotelsPage(driver);
    }

    /**
     * Test method for verifying whether search summary is rightly displayed when searching for hotels
     */
    @Test
    public void testThatResultsAppearWhenSearchingHotels(Method method) {
    	
    	
    		ExtentTestManager.startTest(method.getName(), "Test method for verifying whether search summary is rightly displayed when searching for hotels");
        
		ExtentTestManager.getTest().log(LogStatus.INFO, "Launching the browser");
        homePage.launch();
        homePage.clickHotelsLink();
        hotelsHomePage.selectLocality(Localities.INDIRANAGAR_BANGALORE.getLocality());
        hotelsHomePage.selectTravellerOption(TravellerOptions.ROOM_1_ADULT_2.getTravellerOption());
        hotelsHomePage.clickSearchButton();
        
        ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting hotel search summary details");
        Assert.assertTrue(hotelResultsPage.isSearchSummaryAvailable(),
                "Search Summary is not available after clicking the Search Button when searching for flights");
    }

}
