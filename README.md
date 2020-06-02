# Selenium UI Testing Automation Framework
This is a simple test project for testing a few scenarios on a [sample flight/hotel](https://cleartrip.com/)(cleartrip) booking website. There are 3 tests in total spread over 3 test classes. Underlying, it uses Selenium - open-source tool for web browsers automation, TestNG - Third-party free library for Running tests, and Extent Reports (library for interactive and detailed reports for tests). On top of this, I have implemented Page Factory and Fluent Interface patterns. These techniques eliminates the code repetition and increases the readability of automated UI tests and displays only business logic in tests, not displays low-level page elements and selenium API details in tests. Fluent Interface makes tests like natural language and allows anyone to read and understand what the test does. This framework can be used to write UI automation tests for any web application.

# Contents
* [Framework Details](#FrameworkDetails)
  * [Test Application](#app)
  * [Framework - What and Why?](#ww)
  * [Project structure](#structure)
* [Packages](#package)
  * [Main Package](#main)
  * [Test Package](#test)
  * [Reports](#reports)
* [Installation](#install)
  * [Steps to follow to setup API automation in local system](#steps)
* [Simple Example Test](#example)
  * [Step 1: Create a Page Class](#1)
  * [Step 2: Create a TestBase Class](#2)
  * [Step 3: Create a Test Class](#3)
  * [Step 4: Extent Report](#4)

# Framework Details<a name="FrameworkDetails"></a>
#### Test Application<a name="app"></a>
> I have used [sample flight/hotel](https://cleartrip.com/)(cleartrip) booking website as a basis for this framework.

#### Framework - What and Why?<a name="ww"></a>
> For any software requirement, certain common and basic tasks need to be performed. Such tasks would have been already solved and would be available as open-source/free projects. One can use that and build their code on top of it to solve the software requirements specific to them. Such base code is called a framework
      
#### Project Structure <a name="structure"></a>
- Implemented the standard directory structure and moved/created the files in the appropriate path. For instance, the page classes and the related files can be found in the path: `<working-dir>/src/main/java/com/cleartrip/casestudy` and the test classes and related files could be found in the path: `<working-dir>/src/test/java/com/cleartrip/casestudy`. 

- Created Page classes for each of the pages under test and used the PageFactory model to find and initialize web elements. Instances of the page classes will be created by the Test classes to access methods in the page classes. Thus, tests are decoupled from the pages/ elements under test. This makes the framework more maintainable

- The WebDriver is instantiated in such a way that it is static and only one instance will be created and shared across all the test classes. The Driver will only quit once all the tests are done.

- Updated the `pom.xml` file to have the necessary dependencies and plugins.
  

# Packages<a name="package"></a>
#### Main Package<a name="main"></a>
> `src/main/java/` is the core package of Framework, all the page classes and the related files can be found in this main package. Added necessary documentation to all classes. The Javadoc can be found in the paths `<working-dir>/doc/index.html`

#### Test Package<a name="test"></a>
> `src/test/java/` is the actual test package and the sub package `com.restfulbooker.apitest.businessLogics` holds all test classes (TestNG) related to restfulbooker application. The Javadoc can be found in the paths `<working-dir>/doc/ccom/cleartrip/casestudy/tests/package-summary.html`

#### Reports<a name="reports"></a>
> With the Extent library, we can create interactive and detailed reports for our API test results. We can add events, tags, devices, authors or any other relevant information we decide is essential to create an informative and stunning report. Test Reports can be found in `workingDir/ExtentReports/ExtentReportResults.html`


# Installation<a name="install"></a>
#### Steps to follow to setup/Run UI automation in local system:<a name="steps"></a>

**Install Java: [Skip this step if already installed]**
- Check if Java is installed.
  - In terminal enter java -version to check if java is installed in the system.
  - In terminal enter javac -version to check if java compiler is installed in the system.
  - Any version of java greater than 1.8 is supported.
  - Install java development kit if not available.

**Install Eclipse / Any other latest IDE [Skip this step if already installed]:** 
- Install eclipse / any IDE if not available.
  - Download eclipse installer.
  - Run eclipse installer.
  - Select install eclipse for java developers.
  - Open workbench.

**Get Code base:**
  - Clone restassuredFramework
    - url : https://github.com/abu-sithik/selenium-pom-factory-fluent-pattern.git

**Setup project in Eclipse:** 
  - File -> Open Project from File System -> Browse the folder and open the cloned project.
  - Open -> Help -> Eclipse Marketplace -> Search testng -> Install Testng for eclipse plugin -> Restart eclipse.
  - Maven will be available by default, with eclipse. To check, right click on project -> should have an option called maven.
```
Possible issues:
In case of error in pom.xml file ->Cannot read lifecycle mapping metadata for artifact org.apache.maven.plugins:mav
  - In terminal open Users/<profile_name>/.m2
  - Run rm -r repository
  - Right click on project -> Update project
In case of error in all import statements
  - Click on src/main/java folder -> build path -> remove from build path
  - Click on src -> main -> java ->right click -> build path -> use as source folder
  - Refresh the project
````
**Set up verification**
  - In business logic package -> Right click on any java file -> run as testng test.



# Simple Example Test<a name="example"></a>

> Now, let's get started with the simple example – Creating a test for flight booking case using page factory/fluent interface pattern. 

**Test Steps:**
 - Go to www.cleartrip.com
 - Select TripType (One Way Trip)
 - Select Origin (Bangalore)
 - Select Destination (Delhi)
 - Select Date (Any random date)
 - Click on “Search” button


> Below image show how page class and test classes created for each application page in different packages.
Add package image

## Step 1: Create a Page Class<a name="1"></a>
> First need to create page objects for all the implemented pages in cleartip site – HomePage.java,FlightResultsPage.java,HotelResultsPage.java,HotelsPage.java and SignInPopup.java. Then we have to create a test class that will have an instance of these page objects and will use there implemented methods/actions to create tests.

> Let’s consider this scenario, where in the home page, user selects flight booking option and enters valid details and on clicking search button, user is redirected to flight results page.

**HomePage.Java**
```
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

 ......
 ......
 ......

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
     * This method clicks on the SignIn option which appears after clicking the "Your Trips" options
     */
    public SignInPopup clickSignInOption() {
        signIn.click();
        return new SignInPopup(driver);
    }

 ......
 ......
 ......

}

```
 
> We have created a page class for ClearTrip's `HomePage` having all the `WebElements` and `Action Methods` associated to homepage using the PageFactory model.  We will be using the these `Action Methods` in our tests by initialize them to perform defined actions on those WebElements to complete our test case. I have mentioned only few weblements and action methods in above example. For complete details of page elements & methods refer `HomePage.java`.

```
    /**
     * This method launches the home page
     *
     *@returns HomePage
     */
    public HomePage launch() {
        driver.get("https://www.cleartrip.com/");
        return this;
    }

    /**
     * This method selects the trip type
     *
     * @param tripTypeOption Value of Trip Type
     * @returns HomePage
     */
    public HomePage selectTripType(String tripTypeOption) {
        tripType.findElement(By.xpath("//input[@value='" + tripTypeOption + "']")).click();
        return this;
    }

```

> In `HomePage.java` you can notice that on top of page object model, we have implemented Fluent interface pattern. For example in the above example code, both `launch` and `selectTripType` methods retruns same `HomePage` object. It uses the `Method Chaining (calling a method returns some object on which further methods can be called)` principle by returning the same HomePage, so that in our tests we can call different methods of `HomePage` in a single line instead of calling different methods with the same object reference separately. In our tests we have to write the `HomePage` object reference once and then call its methods by separating them with a (dot.). For more details refer `FlightBookingTest.java`


```
     /**
     * This method clicks on the "Hotels" link in the home page
     * @returns HotelsPage
     */
    public HotelsPage clickHotelsLink() {
        hotelLink.click();
        return new HotelsPage(driver);
    }
```

> At some cases, methods could return object of some other page. For example, in cleartip if user clicks on the Hotelslink button, application would redirect the user to the `HotelsPage`. To achive this `clickHotelsLink` method should return `HotelsPage` object when it invoked (refer above code in `HomePage.java`).

> Similarly, we can define all webelements and methods for fligts results page in `flightResultsPage.java`.

**FlightResultsPage.java**
```
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
```

## Step 2: Create a TestBase Class<a name="2"></a>

> Create a Base Test Class which is extended in all the Test Classes. So The WebDriver is instantiated in such a way that it is static and only one instance will be created and shared across all the test classes. The Driver will only quit once all the tests are done.

**TestBase.java**
```
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
```

## Step 3: Create a Test Class<a name="3"></a>

> In test class, instances of the page classes will be created to access methods in the page classes. Thus, tests are decoupled from the pages/ elements under test. This makes the framework more maintainable.

> So in this `FlightBookingTest` class we have to create the objects of HomePage, FlightResultsPage to access the methods available in those pages.

**FlightBookingTest.java**
```
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
    public void testThatResultsAppearForAOneWayJourney(Method method) {
      
        ExtentTestManager.startTest(method.getName(), "Test method for verifying whether search summary is rightly displayed when searching for flights");
        
        ExtentTestManager.getTest().log(LogStatus.INFO, "Launching the browser");
        homePage.launch() 
            .selectTripType(TripTypes.ONE_WAY.getTripType())
            .selectOrigin(Cities.BANGALORE.getCity())
            .selectDestination(Cities.Delhi.getCity())
            .selectDate()
            .clickSearchButton();
        
        ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting flight search summary details");
        Assert.assertTrue(
                flightResultsPage.isSearchSummaryAvailable(),
                "Search Summary is not available after clicking the Search Button when searching for flights");
    }


}
```
## 4) Extent HTML report<a name="4"></a>
> Test Reports can be found in `workingDir/ExtentReports/ExtentReportResults.html`

**Test Summary**

![alt text](https://github.com/abu-sithik/selenium-pom-factory-fluent-pattern/blob/master/ExtentReports/overview.png?raw=true)

**Specific Test details**

![alt text](https://github.com/abu-sithik/selenium-pom-factory-fluent-pattern/blob/master/ExtentReports/specificTest.gif?raw=true)


> So far, we have explored the sample test scenario to understand the page factory and fluent interface pattern in selenium. In real time project, we might have to add a few more classes for helpers and utility classes based on the requirement.
