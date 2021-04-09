package stepDefinitions;

import cucumber.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.assertj.core.api.Assertions;
import pageObjects.ProjectsPage;


/**
 * Created by vuong.phan on 04/07/2021 - 1:23 PM
 *
 * @project: cucumber-automationtest
 */
public class Hook extends Base {

    private Base base;

    public Hook(Base base) {
        this.base = base;
    }


    @Before
    public void InitializeTest() {
        base.getDriver();
    }

    @After("@Create")
    public void postCondition(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario is FAILED");
        } else {
            System.out.println("---Post-condition---");
            System.out.println("1. Clear the created record");
            ProjectsPage projectsPage = new ProjectsPage(driver);
            projectsPage.delete_SelectedRecord("Auto_2021", "AutoTest", "123456");
            Assertions.assertThat(projectsPage.getDeletedMessage()).isEqualTo("Delete successfully.");
            System.out.println("---Done---");
        }
        System.out.println("Close browser");
        base.quitDriver();
    }


}
