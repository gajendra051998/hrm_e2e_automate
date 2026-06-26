package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AdminUserManagementPage {

    WebDriver driver;

    private By userNameField = By.xpath("//*[@class='oxd-input oxd-input--active']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//self::input");
    private By empNameField= By.xpath("//div[@class='oxd-form-row']/div/div//input[@placeholder='Type for hints...']");
    private By userRoleFieldIcon = By.xpath("//*[@class='oxd-input-group__label-wrapper']/label[text()='User Role']//parent::div//following-sibling::div//descendant::i");
    private By statusFieldIcon = By.xpath(" //*[@class='oxd-input-group__label-wrapper']/label[text()='Status']//parent::div//following-sibling::div//descendant::i");
    private By userRoleList = By.xpath("//div[@role='listbox']/div");
    private By searchButton = By.xpath("//button[normalize-space()='Search']");
    private By resetButton = By.xpath("//button[normalize-space()='Reset']");
    private By statusList = By.xpath("//div[@role='listbox']/div");
    private By tableUserList = By.xpath("//div[@class='oxd-table-body']//div[@role='row']/div[2]");
    private By tableRoleList = By.xpath("//div[@class='oxd-table-body']//div[@role='row']/div[3]");
    private By tableEmpNameList = By.xpath("//div[@class='oxd-table-body']//div[@role='row']/div[4]");
    private By tableStatusList = By.xpath("//div[@class='oxd-table-body']//div[@role='row']/div[5]");

    public AdminUserManagementPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
    }

    public void enterEmployeeName(String emplName){
        driver.findElement(empNameField).sendKeys(emplName);
    }

    public void selectUserRole(String userRole){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(userRoleFieldIcon));
        driver.findElement(userRoleFieldIcon).click();
        List<WebElement> roles = driver.findElements(userRoleList);
        for(WebElement role:roles){
            if(role.getText().equalsIgnoreCase(userRole)){
                role.click();
                break;
            }
        }
    }

    public void selectStatus(String userStatus){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(statusFieldIcon));
        driver.findElement(statusFieldIcon).click();
        List<WebElement> statusLst = driver.findElements(statusList);
        for(WebElement lst:statusLst){
            if(lst.getText().equalsIgnoreCase(userStatus)){
                lst.click();
                break;
            }
        }
    }

    public void clickSearch(){
        driver.findElement(searchButton).click();
    }

    public void clickReset(){
        driver.findElement(resetButton).click();
    }

    public boolean isUserPresent(String username){
        List<WebElement> users = driver.findElements(tableUserList);
        for(WebElement usr:users){
            if(usr.getText().trim().equalsIgnoreCase(username)){
                return true;
            }
        }
        return false;
    }

    public boolean isRolePresent(String role){
        List<WebElement> roles = driver.findElements(tableRoleList);
        for(WebElement r:roles){
            if(r.getText().trim().equalsIgnoreCase(role)){
                return true;
            }
        }
        return false;
    }
    public boolean isEmployeePresent(String empName){
        List<WebElement> names = driver.findElements(tableEmpNameList);
        for(WebElement name:names){
            if(name.getText().trim().equalsIgnoreCase(empName)){
                return true;
            }
        }
        return false;
    }
    public boolean isStatusPresent(String status){
        List<WebElement> sts = driver.findElements(tableStatusList);
        for(WebElement s:sts){
            if(s.getText().trim().equalsIgnoreCase(status)){
                return true;
            }
        }
        return false;
    }

    public boolean isUserNameFieldEmpty(){
        String data = driver.findElement(userNameField).getText();
        if(data.isEmpty()) {
            return true;
        }
        return false;
    }

}
