package hooks;

import driver.DriverFactory;
import io.cucumber.java.*;

import pages.LoginPage;
import utils.ConfigReader;

public class Hooks {

    @Before(order=1)
    public void startUp(){
        ConfigReader.initProperties();
        DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        System.out.println(
                "Driver in startup = "
                        + DriverFactory.getDriver());

        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Before(value="@adminLogin", order=2)
    public void loginAsAdmin() {

        System.out.println(
                "Driver in admin hook = "
                        + DriverFactory.getDriver());
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login("Admin","admin123");
    }

    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }


}
