package stepDefination_DSD_OMS.ReportsOEPageSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.reportsOE.ReportsCustomerWithoutOrdersPage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class ReportsCustomersWithoutOrdersSteps
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;

    static boolean exists=false;
    static boolean flag=false;
    static boolean flag1=false;
    static String currentURL=null;

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderEntryPage;
    static ReportsCustomerWithoutOrdersPage reportsInOEPage;


    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Reports")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForReports() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Reports")
    public void user_is_on_home_pageForReports() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for Reports")
    public void user_navigate_to_client_sideForReports() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab for Reports")
    public void user_should_select_order_entry_tabForReports() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderEntryPage = new OrderEntryPage(driver, scenario);
            orderEntryPage.NavigateToOrderEntry();
            currentURL=driver.getCurrentUrl();
        }
    }

    @Then("User selects Account# for Reports")
    public void user_selects_accountForReports() throws InterruptedException, AWTException, ParseException
    {
        if(flag==false)
        {
            orderEntryPage = new OrderEntryPage(driver, scenario);
            orderEntryPage.ChangeAccount();
            //orderEntryPage.PopUps_After_AccountChange();
            //orderEntryPage.Read_DeliveryDate();
            flag=true;
        }
    }

    @Given("User must be on Order Entry Page to select Reports")
    public void userMustBeOnOrderEntryPageToSelectReports()
    {
        if(flag1==false)
        {
            WebElement WebEle;
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Reports')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                exists = false;
                reportsInOEPage = new ReportsCustomerWithoutOrdersPage(driver, scenario);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Reports", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Reports')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                reportsInOEPage.validateReportsPage();
                currentURL=driver.getCurrentUrl();
            }
            else
            {
                scenario.log("***********REPORTS TAB DOESN'T EXISTS,PLZ CHECK ADMIN SETTING**********");
            }
            flag1=true;
        }
    }

    @And("User should navigate to Reports")
    public void userShouldNavigateToReports() throws InterruptedException, AWTException
    {
        orderEntryPage = new OrderEntryPage(driver, scenario);
        orderEntryPage.HandleError_Page();
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.Refresh_Page(currentURL);
        reportsInOEPage.validateReportsPage();
    }

    @Then("User should select from and to date for Reports generation")
    public void userShouldSelectFromAndToDateForReportsGeneration()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.clickOnFromDate();
        reportsInOEPage.selectFromDate();
        reportsInOEPage.clickOnToDate();
        reportsInOEPage.selectToDate();
    }

    @And("User should select Customer Account# to generate report")
    public void userShouldSelectCustomerAccountToGenerateReport()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.enterAccountNoInFilter();
        reportsInOEPage.selectFilteredAccountNo();
        reportsInOEPage.clearFilter();
    }

    @And("User should select Customer Account#, show selected customer toggle button")
    public void userShouldSelectCustomerAccountShowSelectedCustomerToggleButton()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.selectFilteredAccountNo1();
        reportsInOEPage.enterAccountNoInFilter();
        reportsInOEPage.selectFilteredAccountNo();
        reportsInOEPage.clearFilter();
        reportsInOEPage.clickShowSelectedCustomer();
        reportsInOEPage.readAllSelectedCustomer();
    }

    @Then("User should verify excel and pdf buttons are enabled")
    public void userShouldVerifyExcelAndPdfButtonsAreEnabled()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.enabledExcel();
        reportsInOEPage.enabledPdf();
    }

    @Then("User should click on excel button, and Pdf button to make sure that reports are generated")
    public void userShouldClickOnExcelButtonAndPdfButtonToMakeSureThatReportsAreGenerated()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.clickOnExcel();
        reportsInOEPage.clickOnPdf();
    }

    @Then("User should click on excel button to make sure that reports are generated")
    public void userShouldClickOnExcelButtonToMakeSureThatReportsAreGenerated()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.clickOnExcel();
    }

    @Then("User should click on Pdf button to make sure that reports are generated")
    public void userShouldClickOnPdfButtonToMakeSureThatReportsAreGenerated()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.clickOnPdf();
    }

    @Then("User should select from and to date for Reports generation for invalid to date")
    public void userShouldSelectFromAndToDateForReportsGenerationForInvalidToDate()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.clickOnFromDate();
        reportsInOEPage.selectFromDate();
        reportsInOEPage.clickOnToDate();
        reportsInOEPage.selectInvalidToDate();
    }

    @Then("User should navigate to Routes tab")
    public void userShouldNavigateToRoutesTab()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.horizantalMenu("Routes");
    }

    @Then("User should select from and to date for Reports generation Routes tab")
    public void userShouldSelectFromAndToDateForReportsGenerationRoutesTab()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.clickOnFromDate();
        reportsInOEPage.selectFromDate();
        reportsInOEPage.clickOnToDate();
        reportsInOEPage.selectToDate();
    }

    @And("User should select Routes to generate report Routes tab")
    public void userShouldSelectCustomerAccountToGenerateReportRoutesTab()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.selectFilterForRoutesNo1();
        reportsInOEPage.enterRouteNoInFilterForRoutes();
        reportsInOEPage.selectFilteredRouteNoForRoutes();
        reportsInOEPage.clearFilterForRoutes();
        reportsInOEPage.clickShowSelectedRoutes();
        reportsInOEPage.readAllSelectedCustomerForRoutes();
    }

    @Then("User should click on excel button to make sure that reports are generated Routes tab")
    public void userShouldClickOnExcelButtonToMakeSureThatReportsAreGeneratedRoutesTab()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.clickOnExcel();
    }

    @Then("User should click on Pdf button to make sure that reports are generated Routes tab")
    public void userShouldClickOnPdfButtonToMakeSureThatReportsAreGeneratedRoutesTab()
    {
        reportsInOEPage=new ReportsCustomerWithoutOrdersPage(driver,scenario);
        reportsInOEPage.clickOnPdf();
    }
}
