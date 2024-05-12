package pages;

import locators.LoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private final By usernameField = By.cssSelector(LoginPageLocators.USERNAME_FIELD_CSS_SELECTOR);
    private final By passwordField = By.xpath(LoginPageLocators.PASSWORD_FIELD_XPAth);
    private final By loginButton = By.cssSelector(LoginPageLocators.LOGIN_BUTTON_CSS_SELECTOR);

//  NOTE: Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //  NOTE: Method for authentication
    public HomePage fillCredentials(String username, String password){
    //  NOTE: Waiting for the elements
        waitForElementToBeClickableLocated(usernameField);
        waitForVisibilityOfElementLocated(passwordField);
        waitForElementToBeClickableLocated(loginButton);

    //  NOTE: Getting the elements
        WebElement usernameFieldElement = driver.findElement(usernameField);
        WebElement passwordFieldElement = driver.findElement(passwordField);
        WebElement loginButtonElement = driver.findElement(loginButton);

    //  NOTE: Filling the credentials and submitting
        setInputText(usernameFieldElement, username);
        setInputText(passwordFieldElement, password);
        clickElement(loginButtonElement);

        return new HomePage(driver);
    }
}
