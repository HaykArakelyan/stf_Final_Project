package pages;

import locators.AddUserPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddUserPage extends BasePage{
//  NOTE: Locators
    private By roleField = By.cssSelector(AddUserPageLocators.ROLE_FIELD_CSS_SELECTOR);
    private By selectedRole = By.cssSelector(AddUserPageLocators.SELECTED_ROLE_CSS_SELECTOR);
    private By statusField = By.xpath(AddUserPageLocators.STATUS_FIELD_XPATH);
    private By selectedStatus = By.xpath(AddUserPageLocators.SELECTED_STATUS_XPATH);
    private By employeeNameField = By.xpath(AddUserPageLocators.EMPLOYEE_NAME_FIELD_XPATH);
    private By selectedEmployeeName = By.cssSelector(AddUserPageLocators.SELECTED_EMPLOYEE_NAME_CSS_SELECTOR);
    private By usernameField = By.cssSelector(AddUserPageLocators.USERNAME_FIELD_CSS_SELECTOR);
    private By passwordField = By.xpath(AddUserPageLocators.PASSWORD_FIELD_XPATH);
    private By repeatPasswordField = By.cssSelector(AddUserPageLocators.REPEAT_PASSWORD_FIELD_CSS_SELECTOR);
    private By saveButton = By.xpath(AddUserPageLocators.SAVE_BUTTON_XPATH);

//  NOTE: Constructor
    public AddUserPage(WebDriver driver) {
        super(driver);
    }

//  NOTE: Method for creating a new user
    public AdminPage addUser(String employeeName, String username, String password){

//      NOTE: Find the role input
        waitForElementToBeClickableLocated(roleField);
        WebElement roleFieldElement = driver.findElement(roleField);
        clickElement(roleFieldElement);

//      NOTE: Select the role (Admin)
        waitForElementToBeClickableLocated(selectedRole);
        WebElement selectedRoleElement = driver.findElements(selectedRole).get(1);
        clickElement(selectedRoleElement);

//      NOTE: Find the status input
        waitForElementToBeClickableLocated(statusField);
        WebElement statusFieldElement = driver.findElement(statusField);
        clickElement(statusFieldElement);

//      NOTE: Select the status (Enabled)
        waitForElementToBeClickableLocated(selectedStatus);
        WebElement selectedStatusElement = driver.findElement(selectedStatus);
        clickElement(selectedStatusElement);

//      NOTE: Find the employee name input
        waitForElementToBeClickableLocated(employeeNameField);
        WebElement employeeNameElement = driver.findElement(employeeNameField);
        setInputText(employeeNameElement, employeeName);

//      NOTE: Select the employee name (can be found in Constants class)
        waitForElementToBeClickableLocated(selectedEmployeeName);
        WebElement selectedEmployeeNameElement = driver.findElement(selectedEmployeeName);
        clickElement(selectedEmployeeNameElement);

//      NOTE: Find and insert a username into a username input
        waitForElementToBeClickableLocated(usernameField);
        WebElement usernameFieldElement = driver.findElement(usernameField);
        setInputText(usernameFieldElement, username);

//      NOTE: Find and insert a password into a password input
        waitForElementToBeClickableLocated(passwordField);
        WebElement passwordFieldElement = driver.findElement(passwordField);
        setInputText(passwordFieldElement, password);

//      NOTE: Find and repeat the insertion of the password into the repeat password input
        waitForElementToBeClickableLocated(repeatPasswordField);
        WebElement repeatPasswordFieldElement = driver.findElement(repeatPasswordField);
        setInputText(repeatPasswordFieldElement, password);

//      NOTE: Find and click the save button to add user
        waitForElementToBeClickableLocated(saveButton);
        WebElement saveButtonElement = driver.findElement(saveButton);
        clickElement(saveButtonElement);

        return new AdminPage(driver);
    }
}
