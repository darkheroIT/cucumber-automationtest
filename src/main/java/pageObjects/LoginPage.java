package pageObjects;

import cucumber.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vuong.phan on 04/07/2021 - 1:30 PM
 *
 * @project: cucumber-automationtest
 */
public class LoginPage extends Base {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Accept']")
    public static WebElement btnAccept_Cookie;

    @FindBy(how = How.ID, using = "UserName")
    public static WebElement txtUsername;

    @FindBy(how = How.ID, using = "Password")
    public static WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    public static WebElement btnLogin;

    public void acceptCookie(){
        waitForElementPresent(btnAccept_Cookie);
        btnAccept_Cookie.click();
    }

    public void enter_Username(String username){
        txtUsername.sendKeys(username);
    }

    public void enter_Password(String password){
        txtPassword.sendKeys(password);
    }

    public void clickOn_Login(){
        btnLogin.click();
    }

    public void validateLogin(String userName, String password){
        txtUsername.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }



}
