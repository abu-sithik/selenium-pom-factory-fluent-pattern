package com.cleartrip.casestudy.tests;

import com.cleartrip.casestudy.pages.HomePage;
import com.cleartrip.casestudy.pages.SignInPopup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import com.cleartrip.casestudy.listeners.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class containing test to validate the error message when clicking SignIn w/o entering the necessary details
 */
public class SignInTest extends TestBase {

    /**
     * Instance of HomePage class
     */
    private HomePage homePage;

    /**
     * Instance of SignIn Page class
     */
    private SignInPopup signInPopup;

    /**
     * Class level test-Setup method that instantiates {@link HomePage} & {@link SignInPopup}
     */
    @BeforeClass
    public void testClasSetup() {
        homePage = new HomePage(driver);
        signInPopup = new SignInPopup(driver);
    }

    /**
     * Test method for verifying whether the right error message is displayed when trying to sign-in w/o entering valid credentials
     */
    @Test
    public void testErrorThrownWhenSignInDetailsAreMissing(Method method) {
    	
    		ExtentTestManager.startTest(method.getName(), "Description: Test method for verifying whether the right error message is "
    				+ "displayed when trying to sign-in w/o entering valid credentials");
    		
    		ExtentTestManager.getTest().log(LogStatus.INFO, "Launching the homePage");
        homePage.launch()
        			.clickYourTrips()
		        .clickSignInOption()
		        .clickSignInButtonInPopup();
        
        ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting Alert message");
        Assert.assertTrue(
                signInPopup.getErrorMessageDisplayed().contains("There were errors in your submission"),
                "The expected error message is not thrown when trying to sign-in without inputting the username and password");
    }
}
