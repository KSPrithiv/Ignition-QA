package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminSecurity.AdminSecurityPermissionPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminReportsStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static AdminHomePage adminHomePage;
    static AdminSecurityPermissionPage adminSecurityPermissionPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should enable all disabled admin settings {string}")
    public void userShouldEnableAllDisabledAdminSettings(String adminControl)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(adminControl);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(adminControl);
        adminSecurityPermissionPage.checkCheckbox("accesscpadminreportsmyorders");
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();

        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
    }

    @Then("User drag and drop menu tab option in Admin setting")
    public void userDragAndDropMenuTabOptionInAdminSetting()
    {


    }
}
