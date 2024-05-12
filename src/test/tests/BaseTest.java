package tests;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

// NOTE: The Base Test class based on POM
public class BaseTest {
// NOTE: The URL of target
    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private WebDriver driver;
    protected LoginPage loginPage;

// NOTE: Different browser drivers
    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private WebDriver edgeDriver;

// NOTE: Method for setting up the environment
    @BeforeClass
    @Parameters({"browserName", "gridUrl"})
    public void setUp(String browserName, String gridUrl) throws MalformedURLException {
        chromeDriver = BrowserFactory.createRemoteDriver(browserName, gridUrl);
//        firefoxDriver = BrowserFactory.createRemoteDriver("firefox", "http://localhost:4444/wd/hub");
//        edgeDriver = BrowserFactory.createRemoteDriver("edge", "http://localhost:4444/wd/hub");
    }
// NOTE: Method for setting up the environment (Navigating to entry point)
    @BeforeClass
    public void onStartUp(){
//        TODO: Uncomment this line for visual testing and comment the next line!
        driver = new ChromeDriver();
//        driver = chromeDriver;
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        navigateToWebsite();
    }

// NOTE: Method for parallel testing
    @BeforeMethod
    public void navigateToWebsite() {
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
//        loginPage = new LoginPage(chromeDriver);


//        firefoxDriver.get(BASE_URL);
//        loginPage = new LoginPage(chromeDriver);
//
//        edgeDriver.get(BASE_URL);
//        loginPage = new LoginPage(edgeDriver);
    }

// NOTE: Method responsible for closing the emulator after each session
    @AfterClass
    public void onDestroy(){
        driver.quit();
    }

// NOTE: Method responsible for taking a screenshot if any error occurs
    @AfterMethod
    public void takeErrorScreenshot(ITestResult res){
        if (ITestResult.FAILURE == res.getStatus()){
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {
                Files.move(screenshot, new File("src/screenshots/screenshot" + res.getName() + ".png"));
            }
            catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }

// NOTE: Method responsible for closing the browsers and terminating the sessions in Selenium Grid
    @AfterTest
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
        if (firefoxDriver != null) {
            firefoxDriver.quit();
        }
        if (edgeDriver != null) {
            edgeDriver.quit();
        }
    }
}
