package stepDefination_DSD_OMS.UserManagementClientsidePageStep;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.UserManagementClientSide.userManagementClientPage;

import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class UserManagement_ClientSideStep
{
    /* Created by Divya.Ramadas@afsi.com */
    static boolean flag=false;
    WebDriver driver;
    Scenario scenario;
    static LoginPage loginpage;
    static HomePage homepage;
    static userManagementClientPage userManagementpage;
    static String currentURL;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for User and account client login")
    public void userEntersURLAndIsOnLoginPageAndEnteredCredentialsForUserAndAccountClientLogin() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for User and account client login")
    public void userIsOnHomePageForUserAndAccountClientLogin()
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for User and account client login")
    public void userNavigateToClientSideForUserAndAccountClientLogin() throws InterruptedException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
            userManagementpage = new userManagementClientPage(driver, scenario);
            userManagementpage.NavigateToUserManagement();
            currentURL= driver.getCurrentUrl();
            flag=true;
        }
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.refreshPage(currentURL);
        //driver.navigate().to(currentURL);
    }

    @Given("User must be on Client side and select User Management")
    public void userMustBeOnClientSideAndSelectUserManagement()
    {
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.validateUserManagement();
        userManagementpage.validateNewUserTab();
    }

    @Then("User should enter all the required fields in new user details card")
    public void userShouldEnterAllTheRequiredFieldsInNewUserDetailsCard()
    {
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.firstName();
        userManagementpage.lastName();
        userManagementpage.userName();
        userManagementpage.emailAddress();
        userManagementpage.confirmEmailAddress();
        userManagementpage.password();
        userManagementpage.confirmPassword();
    }

    @And("User should select role and enter PO#")
    public void userShouldSelectRoleAndEnterPO(DataTable tabledata)
    {
        List<List<String>> role=tabledata.asLists(String.class);
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.clickRole();
        userManagementpage.readAllRolesAvailable();
        userManagementpage.selectRole(role.get(0).get(0));
        userManagementpage.clickRole();
        userManagementpage.pONumber(role.get(0).get(1));
    }

    @Then("User clicks on register buttton")
    public void userClicksOnRegisterButtton()
    {
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.clickOnRegristration();
    }

    @Then("User clicks on Cancel buttton")
    public void userClicksOnCancelButtton()
    {
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.clickOnCancel();
    }
}
