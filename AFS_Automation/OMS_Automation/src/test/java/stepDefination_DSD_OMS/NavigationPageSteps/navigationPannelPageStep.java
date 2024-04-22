package stepDefination_DSD_OMS.NavigationPageSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.inventory.InventoryPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class navigationPannelPageStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static LoginPage loginpage;
    static AdminHomePage adminHomePage;
    static HomePage homepage;


    @Before
    public void LaunchBrowser(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Given("User should be on Admin page and click on permission dropdown")
    public void userShouldBeOnAdminPageAndClickOnPermissionDropdown() throws InterruptedException
    {
            //verify that landing page is Admin page
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickPermissionBy();
            adminHomePage.validatePermissionbarExpanded();
    }

    @Then("User clicks on hamburger menu and should make sure that permission dropdown menu is closed")
    public void userClicksOnHamburgerMenuAndShouldMakeSureThatPermissionDropdownMenuIsClosed()
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.ClickOnHamburger();
        adminHomePage.validateHamburgerExpanded();
        adminHomePage.validatePermissionCollapse();
        adminHomePage.CloseHamburger();
        adminHomePage.handleError_Page();
        adminHomePage.refreshPage();
    }

    @Given("User should be on Admin page")
    public void userShouldBeOnAdminPage() throws InterruptedException
    {
        //verify that landing page is Admin page
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.ValidatingAdminHome();
    }

    @Then("User verifies existance of hamburger icon")
    public void userVerifiesExistanceOfHamburgerIcon()
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.validateHamburgerIcon();
        adminHomePage.handleError_Page();
        adminHomePage.refreshPage();
    }

    @Then("User clicks on hamburger menu and verifies existence of search bar")
    public void userClicksOnHamburgerMenuAndVerifiesExistenceOfSearchBar()
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.ClickOnHamburger();
        adminHomePage.validateHamburgerExpanded();
        adminHomePage.validatePermissionCollapse();
        adminHomePage.validateSearchBar();
        adminHomePage.CloseHamburger();
        adminHomePage.handleError_Page();
        adminHomePage.refreshPage();
    }

    @Then("User enters some menu item for searching")
    public void userEntersSomeMenuItemForSearching(DataTable tableData)
    {
        List<List<String>> menuValue=tableData.asLists(String.class);
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.EnterValueInSearchBox(menuValue.get(0).get(0));
        adminHomePage.validateSearchSucess(menuValue.get(0).get(0));
        adminHomePage.CloseHamburger();
        adminHomePage.handleError_Page();
        adminHomePage.refreshPage();
    }

    @Then("User Logout from application")
    public void userLogoutFromApplication() throws InterruptedException
    {
        homepage=new HomePage(driver,scenario);
        homepage.Click_On_UserIcon();
        homepage.Click_On_Signout();
    }

    @Given("User should be on login page and enter client credentials")
    public void userShouldBeOnLoginPageAndEnterClientCredentials() throws InterruptedException, AWTException
    {
        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.password());
        loginpage.ClickSignin();
    }

    @And("User should verify that he is in landing page")
    public void userShouldVerifyThatHeIsInLandingPage()
    {
        homepage = new HomePage(driver,scenario);
        homepage.VerifyHomePage();
    }
}
