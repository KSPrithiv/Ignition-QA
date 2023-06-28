package stepDefination_DSD_OMS.AdminSecurityStep;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminReport.adminReportPage;
import pages_DSD_OMS.adminSecurity.AdminSecurityRolePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class AdminSecurityRolePageStep
{
        /* Created by Divya.Ramadas@afsi.com */
        static boolean flag=false;
        WebDriver driver;
        Scenario scenario;
        AdminSecurityRolePage adminSecurityRolePage;
        LoginPage loginpage;
        AdminHomePage adminHomePage;

        @Before
        public void LaunchBrowser1(Scenario scenario) throws Exception
        {
            this.scenario=scenario;
            TestBase driver1=TestBase.getInstanceOfDriver();
            driver= driver1.getDriver();
        }

    @Given("User enters URL and is on login page and entered credentials for Admin setting for admin security")
    public void userEntersURLAndIsOnLoginPageAndEnteredCredentialsForAdminSettingForAdminSecurity() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver, scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
            loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
            loginpage.ClickSignin();
        }
    }

    @Given("User is on Home Page for Admin setting to select Admin option for admin security")
    public void userIsOnHomePageForAdminSettingToSelectAdminOptionForAdminSecurity() throws InterruptedException
    {
        if(flag==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
            flag=true;
        }
    }

    @When("User is on Home Page for Admin setting for admin security")
    public void userIsOnHomePageForAdminSettingForAdminSecurity() throws InterruptedException
    {
        if(flag==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
        }
    }

    @Then("User Clicks on Permissions by drop down to select Customer Account# for admin security")
    public void userClicksOnPermissionsByDropDownToSelectCustomerAccountForAdminSecurity() throws InterruptedException
    {
        if(flag==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickPermissionBy();
            adminHomePage.SelectCompany();
        }
    }

    @Then("User clicks on plus symbol to create new role, popup will appear enter all required fields, {string} and save")
    public void userClicksOnPlusSymbolToCreateNewRolePopupWillAppearEnterAllRequiredFieldsAndSave(String arg0)
    {
        adminSecurityRolePage=new AdminSecurityRolePage(driver,scenario);
        adminSecurityRolePage.validateRolePage();
        adminSecurityRolePage.clickOnPlusButton();
        adminSecurityRolePage.validateAddNewRole();
        adminSecurityRolePage.addRoleName();
        adminSecurityRolePage.addDescription();
        adminSecurityRolePage.manageableRole(arg0);
        adminSecurityRolePage.validateConfirmPopup();
        adminSecurityRolePage.confirmationPopup();
    }

    @And("User confirm that newly added role is displayed in grid")
    public void userConfirmThatNewlyAddedRoleIsDisplayedInGrid()
    {
        adminSecurityRolePage=new AdminSecurityRolePage(driver,scenario);
        adminSecurityRolePage.validateRolePage();
        adminSecurityRolePage.validateNewRoleAdded();
    }

    @Then("User selects role from the grid and clicks on edit button")
    public void userSelectsRoleFromTheGridAndClicksOnEditButton()
    {
        adminSecurityRolePage=new AdminSecurityRolePage(driver,scenario);
        adminSecurityRolePage.validateRolePage();
        adminSecurityRolePage.selectRoleToEdit();
        adminSecurityRolePage.clickOnEditButton();
        adminSecurityRolePage.validateEditRolepopup();
        adminSecurityRolePage.makeChangesToDescription();
        adminSecurityRolePage.clickOkbuttonInEditRolePopup();
        adminSecurityRolePage.confirmationPopup();
    }
}
