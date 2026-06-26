package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    private WebDriver driver;
    private By adminmdl = By.xpath("//span[text()='Admin']");
    private By pageHeader = By.xpath("//h6[contains(., 'Admin')]");
    private By userMgmtHeaderOpt = By.xpath("//nav[@role='navigation']//descendant::span[contains(text(),'User Management')]");
    private By userOpt = By.xpath("//nav[@role='navigation']//descendant::a[contains(text(),'Users')]");

    public AdminPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageHeader(){
        return driver.findElement(pageHeader).getText();
    }

    public void navigateToAdminModule(){
        driver.findElement(adminmdl).click();
    }

    public void navToUsers(){
        driver.findElement(userMgmtHeaderOpt).click();
        driver.findElement(userOpt).click();
    }

}
