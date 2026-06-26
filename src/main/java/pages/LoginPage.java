package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    private By userNameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//div[@role='alert']//p");
    private By requiredFieldMessage = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getLoginPageUrl(){
        return driver.getCurrentUrl();
    }

    public void enterUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public boolean isLoginBtnDisplay(){
        return driver.findElement(loginBtn).isDisplayed();
    }

    public boolean isRequiredFieldMessageEmpty(){
        return driver.findElements(requiredFieldMessage).isEmpty();
    }

    public void login(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickLoginBtn();
    }
}
