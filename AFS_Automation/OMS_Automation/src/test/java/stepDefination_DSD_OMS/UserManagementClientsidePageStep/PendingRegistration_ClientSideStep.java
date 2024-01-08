package stepDefination_DSD_OMS.UserManagementClientsidePageStep;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.UserManagementClientSide.PendingRegistrationClientPage;
import pages_DSD_OMS.UserManagementClientSide.manageRegistrationClientPageDSD;
import pages_DSD_OMS.UserManagementClientSide.userManagementClientPage;
import util.TestBase;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class PendingRegistration_ClientSideStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static userManagementClientPage userManagementpage;
    static PendingRegistrationClientPage pendingRegistrationClientPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User must be on Client side and select User Management for Pending registration")
    public void userMustBeOnClientSideAndSelectUserManagementForPendingRegistration()
    {
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.validateUserManagement();
    }

    @Then("User should navigate to Pending registration page")
    public void userShouldNavigateToPendingRegistrationPage()
    {
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.Horizantal_MenuBar("Pending registrations");
        pendingRegistrationClientPage=new PendingRegistrationClientPage(driver,scenario);
        pendingRegistrationClientPage.validatePendingRegistrationPage();
    }

    @And("User should select user details from Select User dropdown")
    public void userShouldSelectUserDetailsFromSelectUserDropdown()
    {
        pendingRegistrationClientPage=new PendingRegistrationClientPage(driver,scenario);
        pendingRegistrationClientPage.clickOnSelectUserDropDown();
        pendingRegistrationClientPage.selectUserfromDropDown();
    }

    @Then("User clicks on Deny button")
    public void userClicksOnDenyButton()
    {
        pendingRegistrationClientPage=new PendingRegistrationClientPage(driver,scenario);
        pendingRegistrationClientPage.clickDenyButton();
        pendingRegistrationClientPage.handleDenyConfirmationDialogBox();
    }


    @Then("User clicks on Confirm button")
    public void userClicksOnConfirmButton()
    {
        pendingRegistrationClientPage=new PendingRegistrationClientPage(driver,scenario);
        pendingRegistrationClientPage.clickConfirmButton();
        pendingRegistrationClientPage.handleConfirmConfirmationDialogBox();
    }
}
