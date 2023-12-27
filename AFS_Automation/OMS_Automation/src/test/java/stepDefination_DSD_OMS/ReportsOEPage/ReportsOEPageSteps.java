package stepDefination_DSD_OMS.ReportsOEPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.quote.NewQuotePage;
import pages_DSD_OMS.quote.QuotePage;
import pages_DSD_OMS.quote.QuoteSummaryPage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class ReportsOEPageSteps
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;

    static String Quote_No=null;
    static boolean flag=false;
    static String currentURL=null;

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderEntryPage;
    static QuotePage quotePage;
    static NewQuotePage newQuotePage;
    static QuoteSummaryPage quoteSummaryPage;
    static CheckOutSummaryPage summary;
    static CreateOGPage createOGPage;
    static NewOrderEntryPage newOE;

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
        orderEntryPage = new OrderEntryPage(driver, scenario);
        orderEntryPage.HandleError_Page();
        orderEntryPage.Refresh_Page2();
        orderEntryPage.Read_DeliveryDate();
    }



}
