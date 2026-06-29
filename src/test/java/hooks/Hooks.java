package hooks;

import com.aventstack.extentreports.ExtentTest;
import driver.DriverFactory;
import io.cucumber.java.*;
import pages.LoginPage;
import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.ConfigReader;

public class Hooks {

    @Before(order = 1)
    public void startUp() {

        ConfigReader.initProperties();

        DriverFactory.initDriver(
                ConfigReader.getProperty("browser"));

        System.out.println(
                "Driver in startup = "
                        + DriverFactory.getDriver());

        DriverFactory.getDriver()
                .get(ConfigReader.getProperty("url"));
    }

    @Before(order = 2)
    public void createExtentTest(Scenario scenario) {

        ExtentTest test = ExtentManager
                .getExtent()
                .createTest(scenario.getName());

        ExtentTestManager.setTest(test);
    }

    @Before(value = "@adminLogin", order = 3)
    public void loginAsAdmin() {

        System.out.println(
                "Driver in admin hook = "
                        + DriverFactory.getDriver());

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
                ConfigReader.getProperty("admin.username"),
                ConfigReader.getProperty("admin.password"));
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            ExtentTestManager
                    .getTest()
                    .fail("Scenario Failed");
        } else {
            ExtentTestManager
                    .getTest()
                    .pass("Scenario Passed");
        }

        ExtentManager.getExtent().flush();

        DriverFactory.quitDriver();
    }
}