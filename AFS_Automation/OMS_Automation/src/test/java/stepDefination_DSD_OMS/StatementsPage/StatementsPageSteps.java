package stepDefination_DSD_OMS.StatementsPage;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.billToBill.BillToBillPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.statementsPage.StatementsPage;
import util.TestBase;

import javax.swing.plaf.nimbus.State;
import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class StatementsPageSteps
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;
    static String currentURL=null;

    static LoginPage loginpage;
    static HomePage homepage;
    static StatementsPage statementsPage;
    static OrderEntryPage orderPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Statements")
    public void UserEntersURLAndIsOnLoginPageAndEnteredCredentialsForStatements() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver, scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Statements")
    public void userIsOnHomePageForStatements()
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for Statements")
    public void userNavigateToClientSideForStatements() throws InterruptedException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
            statementsPage=new StatementsPage(driver,scenario);
            statementsPage.NavigateStatements();
            flag=true;;
        }
    }

    @Given("User must be on Client side and select Statements")
    public void userMustBeOnClientSideAndSelectStatements() throws InterruptedException, AWTException
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.HandleError_Page();
        statementsPage.Refresh_Page();
    }

    @Then("User should confirm that he is in Statements page")
    public void userShouldConfirmThatHeIsInStatementsPage() 
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.ValidateStatements();
    }

    @And("User select Weekly check box in Statements")
    public void userSelectWeeklyCheckBoxInStatements() 
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.WeeklyCheckboxClick();
    }
    
    @Then("User Selects Year month and date from respective dropdowns")
    public void userSelectsYearMonthAndDateFromRespectiveDropdowns() 
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.YearDropdown();
        statementsPage.MonthDropdown();
        statementsPage.DateDropdown();
    }

    @And("User select Monthly check box in Statements")
    public void userSelectMonthlyCheckBoxInStatements()
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.MonthlyCheckboxClick();
    }

    @Then("User Selects Year month respective dropdowns")
    public void userSelectsYearMonthRespectiveDropdowns()
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.YearDropdown();
        statementsPage.MonthDropdown();
    }

    @And("User select Date check box in Statements")
    public void userSelectDateCheckBoxInStatements()
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.DateCheckboxClick();
    }

    @Then("User Selects start and end dates")
    public void userSelectsStartAndEndDates()
    {
        statementsPage=new StatementsPage(driver,scenario);
          statementsPage.FromDate();
          statementsPage.ToDate();
    }

    @And("User selects Customer Account# and Clicks on Generate button and verify for pdf")
    public void userSelectsCustomerAccountAndClicksOnGenerateButton()
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.SearchBar();
        statementsPage.SelectCustomerNo();
        statementsPage.GenerateButton();
    }

    @And("User selects Customer Account#")
    public void userSelectsCustomerAccount()
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.SearchBar();
        statementsPage.SearchValidation();
    }

    @And("User searches for customer account# using Add filter")
    public void userSearchesForCustomerAccountUsingAddFilter()
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.AddFilterSearch();
    }

    @And("User selects Customer Account# and Clicks on Generate button and verify for pdf for weekly")
    public void userSelectsCustomerAccountAndClicksOnGenerateButtonAndVerifyForPdfForWeekly()
    {
        statementsPage=new StatementsPage(driver,scenario);
        statementsPage.SearchBar();
        statementsPage.SelectCustomerNo();
        statementsPage.GenerateButtonWeekly();
    }
}
