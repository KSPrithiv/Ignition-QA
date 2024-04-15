package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminOrderControlListStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static String currentURL;
    static AdminHomePage adminHomePage;
    static OrderControlListPage orderControlListPage;
    static HomePage homepage;
    static LoginPage loginpage;
    static OrderEntryPage orderpage;
    static OrderControlListPage orderControlPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User should disable {string} in admin side by using {string}, {string}")
    public void userShouldDisableInAdminSideByUsing(String setting,String identifier,String varForIdentifier)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.adminSettingDisable(setting,identifier,varForIdentifier);
        adminHomePage.Click_SaveButton();
    }

    @And("User Clicks on Skip button")
    public void userClicksOnSkipButton()
    {
        orderControlListPage=new OrderControlListPage(driver,scenario);
        orderControlListPage.Skip_NotSkip();
        orderControlListPage.validateSkipPopupNonExistence();
    }

    @Then("User sign out from client side and sign in to admin side")
    public void userSignOutFromClientSideAndSignInToAdminSide() throws InterruptedException, AWTException
    {
        //To sign out from client side
        homepage = new HomePage(driver, scenario);
        homepage.Click_On_UserIcon();
        homepage.Click_On_Signout();

        //sign in to admin
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        loginpage.ClickSignin();
    }

    @Then("User should enable {string} in admin side by using {string}, {string}")
    public void userShouldEnableInAdminSideByUsing(String setting, String identifier, String varForIdentifier)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.adminSettingEnable(setting,identifier,varForIdentifier);
        adminHomePage.Click_SaveButton();
    }

    @And("User should navigate to OCL for admin setting")
    public void userShouldNavigateToOCLForAdminSetting() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.NavigateToOrderEntry();
        orderControlListPage=new OrderControlListPage(driver,scenario);
        orderControlListPage.navigateToOCL();
        orderControlListPage.Validate_OCL();
    }

    @Then("User validates existence of call desk input box for not displaying")
    public void userValidatesExistenceOfCallDeskInputBoxForNotDisplaying()
    {
        orderControlListPage=new OrderControlListPage(driver,scenario);
        orderControlListPage.validateCallDeskDisplayed();
    }

    @Then("User selects Account# for OCL for admin setting")
    public void userSelectsAccountForOCLForAdminSetting() throws InterruptedException, AWTException, ParseException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ChangeAccount();
        orderpage.Read_DeliveryDate();
    }

    @And("User should navigate to OCL tab for admin setting")
    public void userShouldNavigateToOCLTabForAdminSetting()
    {
        if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]", driver))
        {
            HelpersMethod.navigate_Horizantal_Tab(driver, "Order control list", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            orderControlPage = new OrderControlListPage(driver, scenario);
            currentURL = driver.getCurrentUrl();
            scenario.log(currentURL);
        }
        else
        {
            scenario.log("ORDER CONTROL LIST TAB IS NOT VISIBLE");
        }
    }

    @Then("User validates that Order taker drop down now displaying")
    public void userValidatesThatOrderTakerDropDownNowDisplaying()
    {
        orderControlListPage=new OrderControlListPage(driver,scenario);
        orderControlListPage.Validate_OCL();
        orderControlPage = new OrderControlListPage(driver, scenario);
        orderControlPage.validateOrderTakerDisplay();
    }

    @Then("User validates that Order taker drop down not displaying")
    public void userValidatesThatOrderTakerDropDownNotDisplaying()
    {
        orderControlPage = new OrderControlListPage(driver, scenario);
        orderControlPage.Validate_OCL();
        orderControlPage.validateOrderTakerNonDisplay();
    }
}
