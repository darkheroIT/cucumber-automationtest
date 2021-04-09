package cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by vuong.phan on 04/08/2021 - 3:58 PM
 *
 * @project: cucumber-automationtest
 */
public class Wait {
    private static final int TIMEOUT = 60;
    private static WebDriverWait webDriverWait;

    public static void waitForElementPresent(WebDriver driver,WebElement element) {
        webDriverWait = new WebDriverWait(driver, TIMEOUT);
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.getCause();
        }
    }
}
