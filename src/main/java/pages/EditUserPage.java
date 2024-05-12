package pages;

import locators.EditUserPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditUserPage extends BasePage{
//  NOTE: Locators
    private By usernameField = By.cssSelector(EditUserPageLocators.USERNAME_FIELD_CSS_SELECTOR);
    private By saveButton = By.xpath(EditUserPageLocators.SAVE_BUTTON_XPATH);

    public EditUserPage(WebDriver driver) {
        super(driver);
    }

//  NOTE: Method for editing an existing user
    public AdminPage editUser(String newUsername){
    //  NOTE: Waiting the elements
        waitForElementToBeClickableLocated(saveButton);
        waitForElementToBeClickableLocated(usernameField);

    //  NOTE: Getting the input field and the submit button
        WebElement saveButtonElement = driver.findElement(saveButton);
        WebElement usernameFieldElement = driver.findElement(usernameField);

    //  NOTE: Inserting the new username and submitting the result
    //  TODO: For some reason the input field is not being cleared!!!
    //  TODO: That is why I have used Hot Keys to handle deletion of the old value
        usernameFieldElement.sendKeys(Keys.CONTROL + "a");
        usernameFieldElement.sendKeys(Keys.DELETE);
        setInputText(usernameFieldElement, newUsername);
        clickElement(saveButtonElement);

        return new AdminPage(driver);
    }
}
