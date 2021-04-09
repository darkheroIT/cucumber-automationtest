package stepDefinitions;

import cucumber.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import pageObjects.DashboardPage;
import pageObjects.ProjectsPage;

import java.util.List;
import java.util.Map;

/**
 * Created by vuong.phan on 04/07/2021 - 2:16 PM
 *
 * @project: cucumber-automationtest
 */
public class ProjectsSteps extends Base {
    private Base base;

    public ProjectsSteps(Base base) {
        this.base = base;
    }

    ProjectsPage projectsPage = new ProjectsPage(base.driver);

    @When("he clicks on Add New button")
    public void he_clicks_on_add_new_button() {
        projectsPage.clickOn_AddNew();
    }

    @When("enters the value to some fields as following")
    public void enters_the_value_to_some_fields_as_following(DataTable table) {
        List<Map<String, String>> projectInformation = table.asMaps();
        for (Map<String, String> value : projectInformation) {
            projectsPage.enter_ProjectNo(value.get("projectNo"));
            projectsPage.enter_ProjectName(value.get("projectName"));
            projectsPage.enter_SerialNo(value.get("serialNo"));
        }

    }

    @When("clicks on Save button")
    public void clicks_on_save_button() {
        projectsPage.clickOn_Save();
    }

    @Then("he sees a confirmation message")
    public void he_sees_a_confirmation_message() {
        String expectedMessage = "Data saved successfully.";
        Assert.assertEquals("Wrong Message", expectedMessage, projectsPage.getConfirmationMessage());
    }

    @Then("sees the new record in the list")
    public void sees_the_new_record_in_the_list(DataTable table) throws InterruptedException {
        projectsPage.clickOn_Back();
        projectsPage.enter_Search("Auto");
        List<Map<String, String>> expectedResult = table.asMaps();
        for (Map<String, String> data : expectedResult) {
            Assertions.assertThat(projectsPage.isCreatedSuccessfully(data.get("projectNo"), data.get("projectName"), data.get("serialNo"))).isEqualTo(true);
        }

    }
}
