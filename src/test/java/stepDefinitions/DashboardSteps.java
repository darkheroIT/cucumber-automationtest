package stepDefinitions;

import cucumber.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.DashboardPage;

/**
 * Created by vuong.phan on 04/07/2021 - 1:32 PM
 *
 * @project: cucumber-automationtest
 */
public class DashboardSteps extends Base{
    private Base base;

    public DashboardSteps(Base base) {
        this.base = base;
    }

    DashboardPage dashboardPage = new DashboardPage(base.driver);

    @Then("he should be on my dashboard")
    public void he_should_be_on_my_dashboard() {
        String expectTitle = ":: eMRB - Dashboard ::";
        Assert.assertEquals("Wrong Page",expectTitle,dashboardPage.getPageTitle());

    }
    @Given("User is on the Projects page")
    public void user_is_on_the_projects_page() throws InterruptedException {

        dashboardPage.select_TopMenu("Administration");
        dashboardPage.select_SubMenu("Projects");
    }

}
