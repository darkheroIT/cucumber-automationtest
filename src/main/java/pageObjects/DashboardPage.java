package pageObjects;

import cucumber.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by vuong.phan on 04/07/2021 - 1:31 PM
 *
 * @project: cucumber-automationtest
 */
public class DashboardPage extends Base {

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//ul[@class='nav top-2']")
    private static WebElement top_Navigation;


    public String getPageTitle() {
        return driver.getTitle();
    }


    public void select_TopMenu(String name) {
        List<WebElement> topMenus = top_Navigation.findElements(By.tagName("li"));
        for (WebElement menu : topMenus) {
            if (menu.getText().equalsIgnoreCase(name)) {
                menu.click();
                break;
            }
        }
    }

    public void select_SubMenu(String name) {
        Actions actions = new Actions(driver);
        WebElement subMenu=  driver.findElement(By.linkText(name));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }




}
