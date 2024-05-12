package pages;

import locators.AdminPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminPage extends BasePage{
//  NOTE: Locators
    private By addUserButton = By.cssSelector(AdminPageLocators.ADD_USER_BUTTON_CSS_SELECTOR);
    private By deleteUserButton = By.cssSelector(AdminPageLocators.DELETE_USER_BUTTON_CSS_SELECTOR);
    private By editUserButton = By.cssSelector(AdminPageLocators.EDIT_USER_BUTTON_CSS_SELECTOR);
    private By confirmDeleteUser = By.cssSelector(AdminPageLocators.CONFIRM_DELETE_BUTTON_CSS_SELECTOR);
    private By searchUserField = By.cssSelector(AdminPageLocators.SEARCH_USER_FIELD_CSS_SELECTOR);
    private By searchUserButton = By.cssSelector(AdminPageLocators.SEARCH_USER_BUTTON_CSS_SELECTOR);
    private By userList = By.cssSelector(AdminPageLocators.USER_LIST_CSS_SELECTOR);
    private By userListRow = By.cssSelector(AdminPageLocators.USER_LIST_ROW_CSS_SELECTOR);
    private By userListRowNameColumn = By.cssSelector(AdminPageLocators.USER_LIST_ROW_NAME_COLUMN_CSS_SELECTOR);


//  NOTE: Class variable to save each user's row field
    private List<WebElement> userDivs = new ArrayList<WebElement>();

//  NOTE: Constructor
    public AdminPage(WebDriver driver) {
        super(driver);
    }

//  NOTE: Method for searching a user with username
    public String searchUser(String username){
        waitForVisibilityOfElementLocated(searchUserField);
        waitForVisibilityOfElementLocated(searchUserButton);

        WebElement searchUserFieldElement = driver.findElement(searchUserField);
        WebElement searchUserButtonElement = driver.findElement(searchUserButton);

        setInputText(searchUserFieldElement, username);
        clickElement(searchUserButtonElement);

        waitForElementToBeClickableLocated(userListRowNameColumn);

        int index = getCurrentUser(username);
        if (index < 0){
            return "";
        }else {
            WebElement user = userDivs.get(index);
            return user.findElements(userListRowNameColumn).get(1).getText();
        }
    }

//  NOTE: Method for navigating to a page where it is possible to create a new user
    public AddUserPage addUser(){
        waitForElementToBeClickableLocated(addUserButton);

        WebElement addUserButtonElement = driver.findElement(addUserButton);
        clickElement(addUserButtonElement);

        return new AddUserPage(driver);
    }

//  NOTE: Method for navigating to a page where it is possible to edit an existing user
    public EditUserPage editUser(){
        waitForVisibilityOfElementLocated(editUserButton);

        WebElement editUserButtonElement = driver.findElement(editUserButton);
        clickElement(editUserButtonElement);

        return new EditUserPage(driver);
    }

//  NOTE: Method for deleting the first user in the page (the user is filtered by search user method mentioned above)
    public void deleteUser(){
        waitForElementToBeClickableLocated(deleteUserButton);
        WebElement deleteUserButtonElement = driver.findElement(deleteUserButton);
        clickElement(deleteUserButtonElement);

        waitForElementToBeClickableLocated(confirmDeleteUser);
        WebElement confirmDeleteUserElement = driver.findElement(confirmDeleteUser);
        clickElement(confirmDeleteUserElement);
    }

//  NOTE: Method for getting the index of the user in the list (userList)
    public int getCurrentUser(String username){
        waitForElementToBeClickableLocated(userList);
        waitForElementToBeClickableLocated(userListRow);
        waitForElementToBeClickableLocated(userListRowNameColumn);
        waitForVisibilityOfAllElementsLocated(userListRowNameColumn);

        userDivs = driver.findElement(userList).findElements(userListRow);

        for (int i = 0; i < userDivs.size(); i++){
            if (Objects.equals(userDivs.get(i).findElements(userListRowNameColumn).get(1).getText(), username)){
                return i;
            }
        }

        System.out.println();
        System.out.println("\u001B[34m" + "=========================================================");
        System.out.println("USER NOT FOUND, RETURNING 0");
        System.out.println("========================================================="  + "\u001B[0m");
        return 0;
    }

//  NOTE: Method for checking if the user is deleted or not (checking if the result of search an empty list or not)
    public Boolean checkDeletedUser(){
        waitForElementToBeClickableLocated(By.cssSelector("div[class=\"oxd-table-body\""));
        WebElement userListContainer = driver.findElement(By.cssSelector("div[class=\"oxd-table-body\""));
        return userListContainer.findElements(By.xpath("./*")).isEmpty();
    }
}
