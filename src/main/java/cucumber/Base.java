package cucumber;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by vuong.phan on 04/07/2021 - 1:25 PM
 *
 * @project: cucumber-automationtest
 */
public class Base {
    public static WebDriver driver;
    private static final int TIMEOUT = 60;
    private static WebDriverWait wait;

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void moveWindows() {
        driver.manage().window().setPosition(new Point(2000, 0));//display 2
    }

    public void getURL(String url){
        driver.get(url);
    }

    public void waitForElementPresent(WebElement element) {
        wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void getDriver(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        moveWindows();
        maximizeWindow();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


}
