package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//  NOTE: Base class based on POM
public class BasePage {

//  NOTE: The main driver object for whole app
    protected WebDriver driver;

//  NOTE: The main wait object for whole app
    protected WebDriverWait wait;

//  NOTE: Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//  NOTE: Method for waiting for the element by WebElement
    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

//  NOTE: Method for waiting for the element by locator (By)
    protected void waitForElementToBeClickableLocated(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

//  NOTE: Method for waiting for the visibility of element by locator (By)
    protected void waitForVisibilityOfElementLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

//  NOTE: Method for waiting for the visibility of all elements by locator (By)
    protected void waitForVisibilityOfAllElementsLocated(By locator){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

//  NOTE: Method for clicking on element by WebElement
    protected void clickElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

//  NOTE: Method for inserting a text into an element by WebElement and String
    protected void setInputText(WebElement element, String text) {
        waitForElementToBeClickable(element);
        element.clear();
        element.sendKeys(text);
    }
}
