package pages;

import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//  NOTE: The class for landing page after authentication
public class HomePage extends BasePage{
    private By adminTab = By.linkText(HomePageLocators.ADMIN_TAB_LINK_TEXT);

//  NOTE: Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

//  NOTE: Method for navigating to the Admin page
    public AdminPage openAdminTab(){
        waitForVisibilityOfElementLocated(adminTab);
        clickElement(driver.findElement(adminTab));

        return new AdminPage(driver);
    }
}
