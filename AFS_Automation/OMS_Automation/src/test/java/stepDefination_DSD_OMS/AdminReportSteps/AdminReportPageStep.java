package stepDefination_DSD_OMS.AdminReportSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminReport.adminReportPage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class AdminReportPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    static boolean flag=false;
    static boolean flag1=false;
    static boolean flag2=false;
    static boolean flag3=false;
    static boolean flag4=false;
    static boolean flag5=false;
    static boolean flag6=false;
    WebDriver driver;
    Scenario scenario;
    static LoginPage loginpage;
    static AdminHomePage adminHomePage;
    static adminReportPage adminreportPage;
    
    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Admin setting for Admin reports")
    public void userEntersURLAndIsOnLoginPageAndEnteredCredentialsForAdminSettingForAdminReports() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver, scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
            loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Admin setting for Admin reports")
    public void userIsOnHomePageForAdminSettingForAdminReports() throws InterruptedException
    {
        if(flag==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
        }
    }

    @Then("User Clicks on Permissions by drop down to select Customer Account# for Admin reports")
    public void userClicksOnPermissionsByDropDownToSelectCustomerAccountForAdminReports() throws InterruptedException
    {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.handleError_Page();
            adminHomePage.refreshPage();
            adminHomePage.ClickPermissionBy();
            adminHomePage.SelectCompany();
    }

    @Given("User is on Home Page for Admin setting to select Admin option for Admin reports")
    public void userIsOnHomePageForAdminSettingToSelectAdminOptionForAdminReports() throws InterruptedException
    {
        if(flag==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
            flag=true;
        }
    }

    /*  @And("User should enter menu {string} in search bar to navigate to Web Payments")
      public void userShouldEnterMenuInSearchBarToNavigateToNavigateToWebPayments(String arg0)
      {
          if(flag1==false)
            {
              adminHomePage = new AdminHomePage(driver, scenario);
              adminHomePage.ClickOnHumburger();
              adminHomePage.EnterValueInSearchBox(arg0);
              adminHomePage.CloseHumburger();
            }
      }*/
    @And("User should enter menu {string} in search bar and select {string} for Reports, Web Payment")
    public void userShouldEnterMenuInSearchBarAndSelectForReportsWebPayment(String arg0, String arg1)
    {
        if(flag1==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHamburger();
            adminHomePage.EnterValueInSearchBox1(arg0, arg1);
            adminHomePage.CloseHamburger();
        }
    }

    @Then("User selects Start and End dates for Creating reports")
    public void userSelectsStartAndEndDatesForCreatingReports() throws InterruptedException
    {
        if(flag1==false)
        {
            adminreportPage = new adminReportPage(driver, scenario);
            adminreportPage.clickOnStartCalender();
            adminreportPage.selectStartDate();
            adminreportPage.clickOnEndCalender();
            adminreportPage.selectEndDate();
            flag1=true;
        }
    }

    @And("User should enter menu {string} in search bar and select {string} for Reports, Admin Options")
    public void userShouldEnterMenuInSearchBarAndSelectForReportsAdminOptions(String arg0, String arg1)
    {
        if(flag2==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHamburger();
            adminHomePage.EnterValueInSearchBox1(arg0, arg1);
            adminHomePage.CloseHamburger();
            flag2=true;
        }
    }

    @And("User should enter menu {string} in search bar and select {string} for Reports, Orders tab")
    public void userShouldEnterMenuInSearchBarAndSelectForReportsOrdersTab(String arg0, String arg1)
    {
        if(flag3==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHamburger();
            adminHomePage.EnterValueInSearchBox1(arg0, arg1);
            adminHomePage.CloseHamburger();
            flag3=true;
        }
    }

   /* @Given("User is on Home Page for Admin setting to select Admin option for Admin Permissions")
    public void userIsOnHomePageForAdminSettingToSelectAdminOptionForAdminPermissions() throws InterruptedException
    {
        if(flag6==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
            flag6=true;
        }
    }*/


    @And("User should enter menu {string} in search bar and select {string}, for user and accounts")
    public void userShouldEnterMenuInSearchBarAndSelectForUserAndAccounts(String arg0, String arg1)
    {
        if(flag4==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHamburger();
            adminHomePage.EnterValueInSearchBox1(arg0,arg1);
            adminHomePage.CloseHamburger();
            flag4=true;
        }
    }

    @And("User should enter menu {string} in search bar and select {string} for Reports, Admin Options for event and activities")
    public void userShouldEnterMenuInSearchBarAndSelectForReportsAdminOptionsForEventAndActivities(String arg0, String arg1)
    {
        if(flag5==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHamburger();
            adminHomePage.EnterValueInSearchBox1(arg0, arg1);
            adminHomePage.CloseHamburger();
            flag5=true;
        }
    }

    @And("User click Generate button and clicks on export .csv")
    public void userClickGenerateButtonAndClicksOnExportCsv()
    {
        adminreportPage=new adminReportPage(driver,scenario);
        adminreportPage.clickOnGenerate();
        adminreportPage.clickOnExportCSV();
    }

    @And("User click Generate button and clicks on export .pdf")
    public void userClickGenerateButtonAndClicksOnExportPdf()
    {
        adminreportPage=new adminReportPage(driver,scenario);
        adminreportPage.clickOnGenerate();
        adminreportPage.clickOnDownloadPDF();
    }

    @And("User clicks on reset button value set to all web elements in WebPage should be reset")
    public void userClicksOnResetButtonValueSetToAllWebElementsInWebPageShouldBeReset()
    {
        adminreportPage=new adminReportPage(driver,scenario);
        adminreportPage.resetButtonClick();
        adminreportPage.validateWebElementInWebPage();
    }

    @Then("User selects To dates for Creating reports on Last user login dates")
    public void userSelectsToDatesForCreatingReportsOnLastUserLoginDates()
    {
        adminreportPage=new adminReportPage(driver,scenario);
        adminreportPage.clickOnToDateLastLogiUser();
        adminreportPage.toDateLastLoginUser();
    }

    @Then("User Clicks on Permissions by drop down to select different Customer Account# for admin security")
    public void userClicksOnPermissionsByDropDownToSelectDifferentCustomerAccountForAdminSecurity() throws InterruptedException
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.handleError_Page();
        adminHomePage.refreshPage();
        adminHomePage.ClickPermissionBy();
        adminHomePage.SelectDifferentCompany();
    }
}