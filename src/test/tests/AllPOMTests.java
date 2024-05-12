package tests;

import env.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.AdminPage;
import pages.EditUserPage;
import pages.HomePage;

// NOTE: Class for running all the tests with the scenario
public class AllPOMTests extends BaseTest{

// NOTE: Method for running all tests
    @Test
    public void runAllTests(){
    // NOTE: Setting up the environment
        HomePage homePage = loginPage.fillCredentials(Constants.USERNAME, Constants.PASSWORD);
        AdminPage adminPage = homePage.openAdminTab();

    // NOTE: Searching the Admin user by username
        String name = adminPage.searchUser("Admin");
        Assert.assertEquals(name, "Admin");

    // NOTE: Adding a user with predefined username, password and employee name
        adminPage = homePage.openAdminTab();
        AddUserPage addUserPage = adminPage.addUser();
        adminPage = addUserPage.addUser(Constants.EMPLOYEE_NAME, Constants.NEW_USERNAME, Constants.NEW_PASSWORD);

        String newUserUsername = adminPage.searchUser(Constants.NEW_USERNAME);
        Assert.assertEquals(newUserUsername, Constants.NEW_USERNAME);

    // NOTE: Editing the username of existing user (created above)
        EditUserPage editUserPage = adminPage.editUser();
        adminPage = editUserPage.editUser(Constants.EDITED_USERNAME);
        String newUsername = adminPage.searchUser(Constants.EDITED_USERNAME);
        Assert.assertEquals(newUsername, Constants.EDITED_USERNAME);

    // NOTE: Deleting the user that we have created and edited above
        adminPage = homePage.openAdminTab();
        adminPage.searchUser(Constants.EDITED_USERNAME);
        adminPage.deleteUser();
        boolean isDeleted = adminPage.checkDeletedUser();
        Assert.assertTrue(isDeleted);
    }
}
