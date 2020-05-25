package com.cleartrip.casestudy.pages;

import com.cleartrip.casestudy.constants.WaitTimes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page class for SignIn popup
 */
public class SignInPopup {

    /**
     * WebDriver Instance
     */
    private WebDriver driver;

    /**
     * WebDriverWait Instance
     */
    private WebDriverWait wait;

    /**
     * SignIn Button Element in the popup
     */
    @FindBy(id = "signInButton")
    private WebElement signInButton;

    /**
     * Error message Element
     */
    @FindBy(id = "errors1")
    private WebElement signInError;

    /**
     * Constructor for SignIn popup
     *
     * @param driver WebDriver Instance
     */
    public SignInPopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, WaitTimes.TIME_10_SECONDS.getWaitTime());
    }

    /**
     * This method clicks on the "SignIn" Button in the sign-in popup
     */
    public void clickSignInButtonInPopup() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("modal_window"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    /**
     * This method returns the error message that is displayed when clicking the signIn option w/o entering all necessary details
     *
     * @return Error message
     */
    public String getErrorMessageDisplayed() {
        return signInError.getText();
    }
}
