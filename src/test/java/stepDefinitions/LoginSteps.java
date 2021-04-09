package stepDefinitions;

import cucumber.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

import java.util.List;
import java.util.Map;

/**
 * Created by vuong.phan on 04/07/2021 - 1:32 PM
 *
 * @project: cucumber-automationtest
 */
public class LoginSteps extends Base {

    private Base base;

    public LoginSteps(Base base) {
        this.base = base;
    }

    LoginPage loginPage = new LoginPage(base.driver);

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        base.getURL("https://emrb-dev01.azurewebsites.net/Account/LogIn");
    }

    @When("he logins as ad admin")
    public void he_logins_as_ad_admin(DataTable table) {
        loginPage.acceptCookie();
        List<Map<String, String>> loginAccount = table.asMaps();
        for (Map<String, String> data : loginAccount) {
            loginPage.enter_Username(data.get("userName"));
            loginPage.enter_Password(data.get("password"));
        }
        loginPage.clickOn_Login();
    }

}
