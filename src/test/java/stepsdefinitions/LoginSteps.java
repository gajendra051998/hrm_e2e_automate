package stepsdefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    //WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

    @Given("the user is on the OrangeHRM login page")
    public void the_user_is_on_the_orange_hrm_login_page() {
        // Write code here that turns the phrase above into concrete actions
        loginPage = new LoginPage(DriverFactory.getDriver());
        dashboardPage = new DashboardPage(DriverFactory.getDriver());
        Assert.assertTrue(loginPage.getLoginPageUrl().contains("/auth/login"));
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterUserName(string);
        loginPage.enterPassword(string2);
    }

    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLoginBtn();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        String actPageUrl = dashboardPage.getDashboardPageUrl();
        Assert.assertTrue(actPageUrl.contains("dashboard"));
    }

    @Then("the dashboard should be visible")
    public void the_dashboard_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(dashboardPage.getPageHeaderText(),"Dashboard");
    }

    @Then("the user should see login error message {string}")
    public void the_user_should_see_login_error_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(loginPage.getErrorMessage().contains(string));
    }

    @Then("the user should see required field validation message")
    public void the_user_should_see_required_field_validation_message() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertFalse(loginPage.isRequiredFieldMessageEmpty());
    }

    @When("the user logs out from the application")
    public void the_user_logs_out_from_the_application() {
        // Write code here that turns the phrase above into concrete
        // actions
        dashboardPage.userLogout();
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        //wait.until(ExpectedConditions.urlContains("login"));
        Assert.assertFalse(dashboardPage.getDashboardPageUrl().contains("dashboard"));
        Assert.assertTrue(loginPage.getLoginPageUrl().contains("login"));
    }
}
