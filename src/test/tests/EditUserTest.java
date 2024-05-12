package tests;

import env.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.AdminPage;
import pages.EditUserPage;
import pages.HomePage;

public class EditUserTest extends BaseTest{

// NOTE: Test for editing the existing user
    @Test
    public void editUserTest(){

        HomePage homePage = loginPage.fillCredentials(Constants.USERNAME, Constants.PASSWORD);
        AdminPage adminPage = homePage.openAdminTab();

        AddUserPage addUserPage = adminPage.addUser();
        adminPage = addUserPage.addUser(Constants.EMPLOYEE_NAME, Constants.NEW_USERNAME, Constants.NEW_PASSWORD);
        adminPage.searchUser(Constants.NEW_USERNAME);

        EditUserPage editUserPage = adminPage.editUser();
        adminPage = editUserPage.editUser(Constants.EDITED_USERNAME);
        String newUsername = adminPage.searchUser(Constants.EDITED_USERNAME);
        Assert.assertEquals(newUsername, Constants.EDITED_USERNAME);
    }
}
