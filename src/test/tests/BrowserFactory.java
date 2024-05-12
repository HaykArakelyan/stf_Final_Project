package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

// NOTE: Class responsible for creating different browser drivers by browser name
public class BrowserFactory {
    public static WebDriver createRemoteDriver(String browserName, String gridUrl) throws MalformedURLException {
        WebDriver driver;

        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
        return driver;
    }
}
