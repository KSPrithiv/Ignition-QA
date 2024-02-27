package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminCatalogStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static AdminHomePage adminPage;
    static CatalogPage catalogPage;
    static OrderEntryPage orderpage;
    static LoginPage loginPage;
    static HomePage homePage;
    static String currentURL=null;
    static String sql=null;
    static String status=null;
    static String status1=null;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User should navigate to {string} and validate it")
    public void userShouldNavigateToAndValidateIt(String horizontalTab)
    {
        adminPage=new AdminHomePage(driver,scenario);
        adminPage.Horizantal_MenuBar(horizontalTab);
    }

    @Then("User verifies whether products are getting loaded automatically or not in catalog enabled setting")
    public void userVerifiesWhetherProductsAreGettingLoadedAutomaticallyOrNotInCatalogEnabledSetting()
    {
        boolean exists=false;
        catalogPage=new CatalogPage(driver,scenario);
        exists= catalogPage.verifyProductsInCatalog();
        Assert.assertEquals(exists,true);
    }

    @Then("User verifies whether products are getting loaded automatically or not in catalog disabled setting")
    public void userVerifiesWhetherProductsAreGettingLoadedAutomaticallyOrNotInCatalogDisabledSetting()
    {
        boolean exists=false;
        catalogPage=new CatalogPage(driver,scenario);
        exists= catalogPage.verifyProductsInCatalog();
        Assert.assertEquals(exists,false);
    }

    @Then("User should select Order Entry tab for Catalog for admin setting")
    public void userShouldSelectOrderEntryTabForCatalogForAdminSetting() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.NavigateToOrderEntry();
    }

    @Then("User selects Account# for Catalog for admin setting")
    public void userSelectsAccountForCatalogForAdminSetting() throws InterruptedException, AWTException, ParseException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ChangeAccount();
        //orderpage.PopUps_After_AccountChange();
        orderpage.Read_DeliveryDate();
    }

    @And("User should navigate to Catalog tab for admin setting")
    public void userShouldNavigateToCatalogTabForAdminSetting()
    {
        if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", driver))
        {
            HelpersMethod.navigate_Horizantal_Tab(driver, "Catalog", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            catalogPage = new CatalogPage(driver, scenario);
            catalogPage.ValidateCatalog();
            currentURL = driver.getCurrentUrl();
            scenario.log(currentURL);
        }
        else
        {
            scenario.log("CATALOG TAB IS NOT VISIBLE");
        }
    }

    @Then("User enters URL and is on login page and entered credentials for admin setting")
    public void userEntersURLAndIsOnLoginPageAndEnteredCredentialsForAdminSetting() throws InterruptedException, AWTException
    {
        loginPage = new LoginPage(driver,scenario);
        loginPage.EnterUsername(TestBase.testEnvironment.username());
        loginPage.EnterPassword(TestBase.testEnvironment.password());
        loginPage.ClickSignin();
    }

    @Given("User should verify admin setting {string} is enabled by using {string}")
    public void userShouldVerifyAdminSettingIsEnabledByUsing(String setting,String key) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        sql="select sv_Value From RAMS_SettingsValues where sv_CompanyID ="+TestBase.testEnvironment.getAdminSettingCompany()+" AND sv_Key='"+key+"'";
        status=DataBaseConnection.DataConnGetStatus(sql);
        if(status.equals("0"))
        {
            DataBaseConnection.adminSettingEnabling(key, scenario);
            scenario.log("FOR ADMIN SETTING "+setting+" CHANGES");
            scenario.log("ADMIN SETTING IS ENABLED");
        }
        else
        {
            scenario.log("FOR ADMIN SETTING "+setting+" CHANGES");
            scenario.log("ADMIN SETTING IS ALREADY ENABLED");
        }
    }

    @Then("User sign out from client side for Admin setting changes")
    public void userSignOutFromClientSideForAdminSettingChanges() throws InterruptedException
    {
        //To sign out from client side
        homePage = new HomePage(driver, scenario);
        homePage.Click_On_UserIcon();
        homePage.Click_On_Signout();
    }

    @And("User should disable admin setting {string} using {string}")
    public void userShouldDisableAdminSettingUsing(String setting, String key) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        sql="select sv_Value From RAMS_SettingsValues where sv_CompanyID ="+TestBase.testEnvironment.getAdminSettingCompany()+" AND sv_Key='"+key+"'";
        status1=DataBaseConnection.DataConnGetStatus(sql);
        if(status1.equals("1"))
        {
            DataBaseConnection.adminSettingDisabling(key, scenario);
            scenario.log("FOR ADMIN SETTING "+setting+" CHANGES");
            scenario.log("ADMIN SETTING IS DISABLED");
        }
        else
        {
            scenario.log("FOR ADMIN SETTING "+setting+" CHANGES");
            scenario.log("ADMIN SETTING IS ALREADY DISABLED");
        }
    }

    @And("User should set admin setting {string} {string} as default before making changes")
    public void userShouldSetAdminSettingAsDefaultBeforeMakingChanges(String setting,String key) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if(status.equals("0"))
        {
            DataBaseConnection.adminSettingDisabling(key, scenario);
            scenario.log("FOR ADMIN SETTING "+setting+" CHANGES");
            scenario.log("ADMIN SETTING IS DISABLED");
        }
        else
        {
            DataBaseConnection.adminSettingEnabling(key,scenario);
            scenario.log("FOR ADMIN SETTING "+setting+" CHANGES");
            scenario.log("ADMIN SETTING IS ENABLED");
        }
    }

    @Given("User should verify admin setting {string} is disabled by using {string}")
    public void userShouldVerifyAdminSettingIsDisabledByUsing(String setting, String key) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        sql="select sv_Value From RAMS_SettingsValues where sv_CompanyID ="+TestBase.testEnvironment.getAdminSettingCompany()+" AND sv_Key='"+key+"'";
        status=DataBaseConnection.DataConnGetStatus(sql);

        if(status.equals("1"))
        {
            DataBaseConnection.adminSettingDisabling(key, scenario);
            scenario.log("FOR ADMIN SETTING "+setting+" CHANGES");
            scenario.log("ADMIN SETTING IS DISABLED");
        }
        else
        {
            scenario.log("FOR ADMIN SETTING "+setting+" CHANGES");
            scenario.log("ADMIN SETTING IS ALREADY DISABLED");
        }
    }
}
