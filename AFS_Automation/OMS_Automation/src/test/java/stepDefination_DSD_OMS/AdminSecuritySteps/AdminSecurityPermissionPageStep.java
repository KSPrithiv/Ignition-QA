package stepDefination_DSD_OMS.AdminSecuritySteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminSecurity.AdminSecurityPermissionPage;
import pages_DSD_OMS.adminSecurity.AdminSecurityPermission_ByUserPage;
import util.TestBase;

 /**
         * @Project DSD_OMS
        * @Author Divya.Ramadas@afsi.com
 */
public class AdminSecurityPermissionPageStep
{
        /* Created by Divya.Ramadas@afsi.com */
        WebDriver driver;
        Scenario scenario;
        static AdminSecurityPermissionPage adminSecurityPermissionPage;
        static AdminSecurityPermission_ByUserPage adminSecurityPermission_byUserPage;

        @Before
        public void LaunchBrowser1(Scenario scenario) throws Exception
        {
            this.scenario=scenario;
            TestBase driver1=TestBase.getInstanceOfDriver();
            driver= driver1.getDriver();
        }

    @Then("User clicks on plus symbol to create new role, popup will appear enter all required fields, {string} and save in Permission")
    public void userClicksOnPlusSymbolToCreateNewRolePopupWillAppearEnterAllRequiredFieldsAndSaveInPermission(String arg0)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.validatePermissionPage();
        adminSecurityPermissionPage.clickOnPlusButton();
        adminSecurityPermissionPage.validateAddNewRole();
        adminSecurityPermissionPage.addRoleName();
        adminSecurityPermissionPage.addDescription();
        adminSecurityPermissionPage.manageableRole(arg0);
        adminSecurityPermissionPage.popUpOK();
        adminSecurityPermissionPage.validateConfirmationPopup();
        adminSecurityPermissionPage.confirmationPopup();
    }

    @And("User confirm that newly added role is displayed in grid in Permission")
    public void userConfirmThatNewlyAddedRoleIsDisplayedInGridInPermission()
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.validatePermissionPage();
        adminSecurityPermissionPage.validateNewPermissionAdded();
    }

    @Then("User selects role from the grid and clicks on edit button in Permission")
    public void userSelectsRoleFromTheGridAndClicksOnEditButtonInPermission()
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.validatePermissionPage();
        adminSecurityPermissionPage.clickOnEditButton();
        adminSecurityPermissionPage.validateEditRolepopup();
        adminSecurityPermissionPage.clickOnRoleDropdown();
        adminSecurityPermissionPage.selectRoleForEditing();
        adminSecurityPermissionPage.clickOkbuttonInEditRolePopup1();
        adminSecurityPermissionPage.validateEditRole1popup();
        adminSecurityPermissionPage.changeDescriptionEditRolepopup();
        adminSecurityPermissionPage.clickOkbuttonInEditRolePopup();
        adminSecurityPermissionPage.validateConfirmationPopup();
        adminSecurityPermissionPage.confirmationPopup();
    }

    @Then("User should create copy of role in Permission by selecting {string}")
    public void userShouldCreateCopyOfRoleInPermissionBySelecting(String arg0)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.validatePermissionPage();
        adminSecurityPermissionPage.clickOnCopyButton();
        adminSecurityPermissionPage.validateCopyPermissionPopup();
        adminSecurityPermissionPage.clickOnFromCompany();
        adminSecurityPermissionPage.selectFromCompany();
        adminSecurityPermissionPage.clickOnFromRole();
        adminSecurityPermissionPage.selectFromRole(arg0);
        adminSecurityPermissionPage.clickOnToCompany();
        adminSecurityPermissionPage.selectToCompany();
        adminSecurityPermissionPage.clickOnToRole();
        adminSecurityPermissionPage.selectToRole();
        adminSecurityPermissionPage.clickOnCopyPermissionButton();
        adminSecurityPermissionPage.copyPermissionToPopup();
        adminSecurityPermissionPage.confirmationPopup1();
        //adminSecurityPermissionPage.validateConfirmationPopup();
        adminSecurityPermissionPage.confirmationPopup();
        adminSecurityPermissionPage.compareEnabledPermissions(arg0);
    }

    @Then("User should enter admin setting value {string} in search bar")
    public void userShouldEnterAdminSettingValueInSearchBar(String arg0)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(arg0);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(arg0);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
    }

    @Then("User should navigate to {string} card")
    public void userShouldNavigateToCard(String arg0)
    {
        adminSecurityPermission_byUserPage=new AdminSecurityPermission_ByUserPage(driver,scenario);
        adminSecurityPermission_byUserPage.navigateToByUser();
        adminSecurityPermission_byUserPage.validatePermissionPage();
    }

    @Then("User should enter {string} and {string} in add user to table")
    public void userShouldEnterAndInAddUserToTable(String arg0, String arg1)
    {
        adminSecurityPermission_byUserPage=new AdminSecurityPermission_ByUserPage(driver,scenario);
        adminSecurityPermission_byUserPage.clickOnPlusButton();
        adminSecurityPermission_byUserPage.validateAddUserToTable();
        adminSecurityPermission_byUserPage.clickRole();
        adminSecurityPermission_byUserPage.selectRole(arg0);
        adminSecurityPermission_byUserPage.clickUser();
        adminSecurityPermission_byUserPage.selectUser(arg1);
        adminSecurityPermission_byUserPage.validateUser(arg1);
        adminSecurityPermission_byUserPage.clickOnOkButton();
    }

    @Then("User should enter {string} and {string} in add user to table and find modules enabled")
    public void userShouldEnterAndInAddUserToTableAndFindModulesEnabled(String role, String user)
    {
        adminSecurityPermission_byUserPage=new AdminSecurityPermission_ByUserPage(driver,scenario);
        adminSecurityPermission_byUserPage.clickOnPlusButton();
        adminSecurityPermission_byUserPage.validateAddUserToTable();
        adminSecurityPermission_byUserPage.clickRole();
        adminSecurityPermission_byUserPage.selectRole(role);
        adminSecurityPermission_byUserPage.clickUser();
        adminSecurityPermission_byUserPage.selectUser(user);
        adminSecurityPermission_byUserPage.validateUser(user);
        adminSecurityPermission_byUserPage.clickOnOkButton();
        adminSecurityPermission_byUserPage.validateGridHeader(user);
        adminSecurityPermission_byUserPage.clickOnModulesDropdown();
        adminSecurityPermission_byUserPage.readModulesEnabled();
    }

    @And("User selects admin permission {string} to be searched in search bar")
    public void userSelectsAdminPermissionToBeSearchedInSearchBar(String arg0)
    {
        adminSecurityPermission_byUserPage=new AdminSecurityPermission_ByUserPage(driver,scenario);
        adminSecurityPermission_byUserPage.searchAdminSettingInSearchBar(arg0);
        adminSecurityPermission_byUserPage.validateAdminSettingSearchValue(arg0);
        adminSecurityPermission_byUserPage.searchAdminSettingInSearchBarClear();
    }

    @Then("User clicks on In Modules input box and verify the modules enabled")
    public void userClicksOnInModulesInputBoxAndVerifyTheModulesEnabled()
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.clickOnInModules();
        adminSecurityPermissionPage.readAllModulesSelected();
    }

    @Then("User clicks on In Roles input box and verify the roles enabled")
    public void userClicksOnInRolesInputBoxAndVerifyTheRolesEnabled()
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.clickOnInRoles();
        adminSecurityPermissionPage.readAllRolesSelected();
    }

    @Then("User clicks on In Roles input box, disable roles and verify it in grid")
    public void userClicksOnInRolesInputBoxDisableRolesAndVerifyItInGrid()
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.clickOnInRoles();
        adminSecurityPermissionPage.readAllRolesSelected();
        adminSecurityPermissionPage.disableRoles();
        adminSecurityPermissionPage.verifyRolesGrid();
        adminSecurityPermissionPage.enableRoles();
        adminSecurityPermissionPage.verifyRolesGridForEnabled();
    }
}
