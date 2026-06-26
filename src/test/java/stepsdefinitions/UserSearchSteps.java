package stepsdefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AdminPage;
import pages.AdminUserManagementPage;
import pages.DashboardPage;
import pages.LoginPage;

public class UserSearchSteps {

    //LoginPage loginpage;
    DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
    AdminPage adminPage = new AdminPage(DriverFactory.getDriver());
    AdminUserManagementPage adminUserMgmtPage = new AdminUserManagementPage(DriverFactory.getDriver());

    @When("the admin searches user with username {string}")
    public void the_admin_searches_user_with_username(String string) {
        // Write code here that turns the phrase above into concrete actions
        //adminPage.navigateToAdminModule();
        dashboardPage.navToAdminModule();
        adminPage.navToUsers();
        adminUserMgmtPage.enterUserName(string);
        adminUserMgmtPage.clickSearch();
    }

    @Then("the user {string} should be displayed in the search results")
    public void the_user_should_be_displayed_in_the_search_results(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(adminUserMgmtPage.isUserPresent(string),"User not found");
    }

    @When("the admin searches users with role {string}")
    public void the_admin_searches_users_with_role(String string) {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.navToAdminModule();
        adminPage.navToUsers();
        adminUserMgmtPage.selectUserRole(string);
        adminUserMgmtPage.clickSearch();
    }

    @Then("users matching role {string} should be displayed")
    public void users_matching_role_should_be_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(adminUserMgmtPage.isRolePresent(string),"This Role is not available");
    }

    @When("the admin searches users with employee name {string}")
    public void the_admin_searches_users_with_employee_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.navToAdminModule();
        adminPage.navToUsers();
        adminUserMgmtPage.enterEmployeeName(string);
        adminUserMgmtPage.clickSearch();

    }

    @Then("users matching employee name {string} should be displayed")
    public void users_matching_employee_name_should_be_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(adminUserMgmtPage.isEmployeePresent(string),"Employee not found");
    }

    @When("the admin searches users with status {string}")
    public void the_admin_searches_users_with_status(String string) {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.navToAdminModule();
        adminPage.navToUsers();
        adminUserMgmtPage.selectStatus(string);
        adminUserMgmtPage.clickSearch();
    }

    @Then("users matching status {string} should be displayed")
    public void users_matching_status_should_be_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(adminUserMgmtPage.isStatusPresent(string),"Status not found");
    }

    @Given("the admin enters search criteria")
    public void the_admin_enters_search_criteria() {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.navToAdminModule();
        adminPage.navToUsers();
        adminUserMgmtPage.enterUserName("Admin");
    }

    @When("the admin clicks the reset button")
    public void the_admin_clicks_the_reset_button() {
        // Write code here that turns the phrase above into concrete actions
        adminUserMgmtPage.clickReset();
    }

    @Then("all search filters should be cleared")
    public void all_search_filters_should_be_cleared() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(adminUserMgmtPage.isUserNameFieldEmpty());
    }

}
