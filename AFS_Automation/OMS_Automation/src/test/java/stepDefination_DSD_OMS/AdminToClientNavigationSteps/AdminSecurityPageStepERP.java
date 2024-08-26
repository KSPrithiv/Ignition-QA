package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminSecurity.AdminSecurityPermissionPage;
import pages_DSD_OMS.customerInquiry_ERP.CustomerInquiryPageERP;
import pages_DSD_OMS.customerInquiry_ERP.MainPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminSecurityPageStepERP
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static LoginPage loginpage;
    static HomePage homepage;
    static AdminHomePage adminHomePage;
    static AdminSecurityPermissionPage adminSecurityPermissionPage;
    static CustomerInquiryPageERP customerInquiryPageERP;
    static MainPage mainPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page for admin and client Test scenarios")
    public void userEntersURLAndIsOnLoginPageForAdminAndClientTestScenarios() throws InterruptedException, AWTException
    {
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        loginpage.ClickSignin();
    }

    @When("User should land on landing page and verify")
    public void userShouldLandOnLandingPageAndVerify() throws InterruptedException
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.ValidatingAdminHome();
    }

    @Then("User searches for {string} {string} {string} and disable all of them")
    public void userSearchesForAndDisableAllOfThem(String control1, String control2, String control3)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(control1);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(control1);
        adminSecurityPermissionPage.uncheckCheckbox("modifycpcustomermastercontactinfoonly");
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(control2);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(control2);
        adminSecurityPermissionPage.uncheckCheckbox("modifycpcustomermasterdata");
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(control3);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(control3);
        adminSecurityPermissionPage.uncheckCheckbox("createcpcustomermasterdata");
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
    }

    @And("User logs out from Admin site, logs in to client credentials")
    public void userLogsOutFromAdminSiteLogsinToClientCredentials() throws InterruptedException, AWTException
    {
        homepage=new HomePage(driver,scenario);
        homepage.refreshPageBeforeLogout();
        homepage.Click_On_UserIcon();
        homepage.Click_On_Signout();

        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.password());
        loginpage.ClickSignin();

        homepage = new HomePage(driver,scenario);
        homepage.VerifyHomePage();
        homepage.verifyUserinfoContainer();
        homepage.navigateToClientSide();
    }

    @And("User navigate to Customer Inq ERP env and Select Customer Account#")
    public void userNavigateToCustomerInqERPEnvAndSelectCustomerAccount(DataTable dataTable)
    {
        List<List<String>> firstFilterValue = dataTable.asLists(String.class);
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.NavigateToCustomerInquiry();
        customerInquiryPageERP.clickOnCustomerAccountIndex();
        customerInquiryPageERP.validateCustomerAccountIndex();
        customerInquiryPageERP.selectCustomerAccountUsingCustomerAccount(firstFilterValue.get(0).get(0));
        customerInquiryPageERP.handleNotePopup();
    }

    @Then("User navigate to main tab and verify Primary contact has been non editable")
    public void userNavigateToMainTabAndVerifyPrimaryContactHasBeenNonEditable()
    {
        mainPage=new MainPage(driver,scenario);
        mainPage.verifyPrimaryContactDisabled();
    }

    @Then("User should log out from client and login with admin credentials")
    public void userShouldLogOutFromClientAndLoginWithAdminCredentials() throws InterruptedException, AWTException
    {
        homepage=new HomePage(driver,scenario);
        homepage.refreshPageBeforeLogout();
        homepage.Click_On_UserIcon();
        homepage.Click_On_Signout();

        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        loginpage.ClickSignin();
    }

    @And("User should enable all disabled admin settings {string} {string} {string}")
    public void userShouldEnableAllDisabledAdminSettings(String control1, String control2, String control3)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(control1);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(control1);
        adminSecurityPermissionPage.checkCheckbox("modifycpcustomermastercontactinfoonly");
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();

        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(control2);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(control2);
        adminSecurityPermissionPage.checkCheckbox("modifycpcustomermasterdata");
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();

        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(control3);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(control3);
        adminSecurityPermissionPage.checkCheckbox("createcpcustomermasterdata");
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();

        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
    }

    @Then("User navigate to main tab and verify Primary contact has been editable")
    public void userNavigateToMainTabAndVerifyPrimaryContactHasBeenEditable()
    {
        mainPage=new MainPage(driver,scenario);
        mainPage.verifyPrimaryContactEnabled();
    }
}
