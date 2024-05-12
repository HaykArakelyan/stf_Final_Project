package tests;

import env.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.AdminPage;
import pages.HomePage;

public class AdminTest extends BaseTest{

// NOTE: Test for searching the user by username
    @Test
    public void searchUserTest(){
        HomePage homePage = loginPage.fillCredentials(Constants.USERNAME, Constants.PASSWORD);
        AdminPage adminPage = homePage.openAdminTab();

        String name = adminPage.searchUser("Admin");
        Assert.assertEquals(name, "Admin");
    }
// NOTE: Test for deleting the user (the user is filtered with the help of search)
    @Test void deleteUserTest(){
        HomePage homePage = loginPage.fillCredentials(Constants.USERNAME, Constants.PASSWORD);
        AdminPage adminPage = homePage.openAdminTab();

        AddUserPage addUserPage = adminPage.addUser();
        adminPage = addUserPage.addUser(Constants.EMPLOYEE_NAME, Constants.NEW_USERNAME, Constants.NEW_PASSWORD);

        adminPage.searchUser(Constants.NEW_USERNAME);
        adminPage.deleteUser();
        boolean isDeleted = adminPage.checkDeletedUser();
        Assert.assertTrue(isDeleted);
    }
}
