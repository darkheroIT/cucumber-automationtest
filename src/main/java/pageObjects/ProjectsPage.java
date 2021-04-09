package pageObjects;

import cucumber.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by vuong.phan on 04/07/2021 - 1:31 PM
 *
 * @project: cucumber-automationtest
 */
public class ProjectsPage extends Base {


    public ProjectsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "addNewProject")
    private static WebElement btnAddNew;

    @FindBy(how = How.ID, using = "ProjectNo")
    private static WebElement txtProjectNo;

    @FindBy(how = How.ID, using = "ProductName")
    private static WebElement txtProjectName;

    @FindBy(how = How.ID, using = "UnitNo")
    private static WebElement txtSerialNo;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private static WebElement btnSave;

    @FindBy(how = How.XPATH, using = "//li[contains(text(), 'Data saved successfully.')]")
    private static WebElement lblConfirmationMessage;

    @FindBy(how = How.XPATH, using = "//tbody[@role='rowgroup']/tr")
    private static WebElement projectTable;

    @FindBy(how = How.LINK_TEXT, using = "Back To")
    private static WebElement btnBack;

    @FindBy(how = How.XPATH, using = "//a[@title='Back to previous page']")
    private static WebElement btnBack1;

    @FindBy(how = How.ID, using = "Keyword")
    private static WebElement txtSearch;

    @FindBy(how = How.XPATH, using = "//span[@class='k-pager-info k-label']")
    private static WebElement lblFilterResult;

    @FindBy(how = How.XPATH, using = "//input[@class='chkbx']")
    private static WebElement chkbxProject;

    @FindBy(how = How.LINK_TEXT, using = "Delete")
    private static WebElement btnDelete;

    @FindBy(how = How.XPATH, using = "//li[contains(text(), 'Delete successfully.')]")
    private static WebElement lblDeletedMessage;

    public void clickOn_AddNew() {
        btnAddNew.click();
    }

    public void enter_ProjectNo(String projNo) {
        txtProjectNo.sendKeys(projNo);
    }

    public void enter_ProjectName(String projName) {
        txtProjectName.sendKeys(projName);
    }

    public void enter_SerialNo(String serialNo) {
        txtSerialNo.sendKeys(serialNo);
    }

    public void clickOn_Save() {
        btnSave.click();
    }

    public String getConfirmationMessage() {
        return lblConfirmationMessage.getText();
    }

    public void clickOn_Back() {
        waitForElementPresent(btnBack1);
        btnBack1.click();
    }

    public void enter_Search(String value) throws InterruptedException {
        txtSearch.sendKeys(value);
        txtSearch.sendKeys(Keys.ENTER);
        waitForElementPresent(projectTable);
        Thread.sleep(2000);

    }

    public void printTableData() {
        List<WebElement> projectsData = projectTable.findElements(By.xpath("//tbody[@role='rowgroup']/tr/td"));
        for (WebElement row : projectsData) {
            System.out.println(row.getText());
        }
    }


    public boolean isCreatedSuccessfully(String projectNo, String projectName, String serialNo) {
        boolean isFound = false;
        List<WebElement> rows = projectTable.findElements(By.xpath("//tbody[@role='rowgroup']/tr"));
        for (WebElement row : rows) {
            if (row.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td[3]")).getText().equals(projectNo)
                    && row.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td[4]")).getText().equals(projectName)
                    && row.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td[5]")).getText().equals(serialNo)
            ) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }


    public void delete_SelectedRecord(String projectNo, String projectName, String serialNo) {
        List<WebElement> tableRows = projectTable.findElements(By.xpath("//tbody[@role='rowgroup']/tr"));
        for (WebElement row : tableRows) {
            if (row.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td[3]")).getText().equals(projectNo)
                    && row.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td[4]")).getText().equals(projectName)
                    && row.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td[5]")).getText().equals(serialNo)
            ) {
                chkbxProject.click();
                break;
            }
        }
        btnDelete.click();
        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();

    }

    public String getDeletedMessage() {
        return lblDeletedMessage.getText();
    }

}
