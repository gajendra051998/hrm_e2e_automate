package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {

    private By pageHeader = By.xpath("//h6[normalize-space()='Dashboard']");
    private By profileName = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By profileDropdownBtn = By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]");
    private By logoutOpt = By.xpath("//a[text()='Logout']");
    private By adminModule = By.xpath("//span[normalize-space()='Admin']");

    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageHeaderText(){
        return driver.findElement(pageHeader).getText();
    }

    public String getDashboardPageUrl(){
        return driver.getCurrentUrl();
    }

    public String getCurrentUserInfo(){
        return driver.findElement(profileName).getText();
    }

    public void userLogout(){
        driver.findElement(profileDropdownBtn).click();
//        List<WebElement> profileDropdownOptions = driver.findElements(By.xpath("//ul[@role='menu']/li"));
//        for(WebElement opt:profileDropdownOptions){
//            String option = opt.getText();
//            if(option.equals("Logout")){
//                opt.click();
//                break;
//            }
        wait.until(ExpectedConditions.elementToBeClickable(logoutOpt));
        driver.findElement(logoutOpt).click();
    }

    public void navToAdminModule(){
        driver.findElement(adminModule).click();
    }


}
