package tests;

import env.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.AdminPage;
import pages.HomePage;

public class AddUserTest extends BaseTest{

// NOTE: Test for adding a user
    @Test
    public void addUserTest(){
        HomePage homePage = loginPage.fillCredentials(Constants.USERNAME, Constants.PASSWORD);
        AdminPage adminPage = homePage.openAdminTab();

        AddUserPage addUserPage = adminPage.addUser();
        adminPage = addUserPage.addUser(Constants.EMPLOYEE_NAME, Constants.NEW_USERNAME, Constants.NEW_PASSWORD);

        String newUserUsername = adminPage.searchUser(Constants.NEW_USERNAME);
        Assert.assertEquals(newUserUsername, Constants.NEW_USERNAME);
    }
}
