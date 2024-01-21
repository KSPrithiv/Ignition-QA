package stepDefination_DSD_OMS.UserManagementClientsidePageSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.UserManagementClientSide.manageRegistrationClientPageDSD;
import pages_DSD_OMS.UserManagementClientSide.userManagementClientPage;
import util.TestBase;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class ManageRegistration_ClientSideStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static userManagementClientPage userManagementpage;
    static manageRegistrationClientPageDSD manageregistrationClientPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User must be on Client side and select User Management for Manage registration")
    public void userMustBeOnClientSideAndSelectUserManagementForManageRegistration()
    {
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.validateUserManagement();
    }

    @Then("User should navigate to manage registration page")
    public void userShouldNavigateToManageRegistrationPage()
    {
        userManagementpage = new userManagementClientPage(driver, scenario);
        userManagementpage.Horizantal_MenuBar("Manage registrations");
        manageregistrationClientPage=new manageRegistrationClientPageDSD(driver,scenario);
        manageregistrationClientPage.validateManageRegistrationPage();
    }

    @And("User should select User from the User dialog box and validate that details are loaded")
    public void userShouldSelectUserFromTheUserDialogBoxAndValidateThatDetailsAreLoaded()
    {
        manageregistrationClientPage=new manageRegistrationClientPageDSD(driver,scenario);
        manageregistrationClientPage.clickOnUserIndexIcon();
        manageregistrationClientPage.validateUserIndexDialogbox();
        manageregistrationClientPage.searchForUserInDialogbox();
        manageregistrationClientPage.selectUserFromDialogBox();
        manageregistrationClientPage.validateUserdetailsDisplayed();
    }

    @Then("User should enter account number for primary customer account number")
    public void userShouldEnterAccountNumberForPrimaryCustomerAccountNumber()
    {
        manageregistrationClientPage=new manageRegistrationClientPageDSD(driver,scenario);
        manageregistrationClientPage.enterPrimaryCustomerAccount();
        manageregistrationClientPage.clickOnAddButton();
    }

    @Then("User should click on Delete button next to primary customer account")
    public void userShouldClickOnDeleteButtonNextToPrimaryCustomerAccount()
    {
        manageregistrationClientPage=new manageRegistrationClientPageDSD(driver,scenario);
        manageregistrationClientPage.clickOnDeleteButton();
        manageregistrationClientPage.handleConfirmationDialogbox();
    }

    @Then("User should enter account number for Secondary customer account")
    public void userShouldEnterAccountNumberForSecondaryCustomerAccount()
    {
        manageregistrationClientPage=new manageRegistrationClientPageDSD(driver,scenario);
        manageregistrationClientPage.enterSecondaryCustomerAccount();
        manageregistrationClientPage.clickOnSecondaryAddButton();
    }

    @Then("User should click on Delete button next to Delete Secondary customer account")
    public void userShouldClickOnDeleteButtonNextToDeleteSecondaryCustomerAccount()
    {
        manageregistrationClientPage=new manageRegistrationClientPageDSD(driver,scenario);
        manageregistrationClientPage.clickOnSecondaryDeleteButton();
        manageregistrationClientPage.handleConfirmationDialogbox();
    }

    @Then("User should change PO# and click on update button")
    public void userShouldChangePOAndClickOnUpdateButton()
    {
        manageregistrationClientPage=new manageRegistrationClientPageDSD(driver,scenario);
        manageregistrationClientPage.updatePONumber();
        manageregistrationClientPage.clickOnUpdateButton();
    }
}
