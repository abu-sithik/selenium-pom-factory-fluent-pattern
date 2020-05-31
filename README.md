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
	* [1) Create a simple test](#1)

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
Now, let's get started with the simple example – a simple flight/hotel booking site.
### 1) Create a simple test<a name="1"></a>
