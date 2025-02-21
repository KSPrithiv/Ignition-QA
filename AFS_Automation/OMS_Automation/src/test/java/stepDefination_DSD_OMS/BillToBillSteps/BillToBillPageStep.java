package stepDefination_DSD_OMS.BillToBillSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.billToBill.BillToBillPage;
import pages_DSD_OMS.billToBill.BillingSelectionPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.TestBase;

import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class BillToBillPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;
    static String currentURL;

    static BillToBillPage billToBill;
    static BillingSelectionPage billSelection;
    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Bill to bill")
    public void userEntersURLAndIsOnLoginPageAndEnteredCredentialsForBillToBill() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.Userword());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for bill to bill")
    public void userIsOnHomePageForBillToBill()
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for bill to bill")
    public void userNavigateToClientSideForBillToBill() throws InterruptedException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
            billToBill = new BillToBillPage(driver, scenario);
            currentURL= billToBill.NavigateToBillToBill();
            billToBill.ValidateBillToBill();
            flag=true;
        }
    }

    @Given("User must be on Client side and select Bill to Bill\\(DSD)")
    public void userMustBeOnClientSideAndSelectBillToBillDSD() throws InterruptedException, AWTException
    {
            billToBill = new BillToBillPage(driver, scenario);
            billToBill.HandleError_Page();
            orderpage=new OrderEntryPage(driver,scenario);
            orderpage.Refresh_Page(currentURL);
    }

    @Then("User should confirm that he is in Bill to bill page")
    public void userShouldConfirmThatHeIsInBillToBillPage() throws InterruptedException, AWTException
    {
        billToBill=new BillToBillPage(driver,scenario);
        billToBill.ValidateBillToBill();
    }

    @And("User select Weekly radio button")
    public void userSelectWeeklyRadioButton()
    {
        billToBill=new BillToBillPage(driver,scenario);
        billToBill.WeeklyRadioButton();
        billToBill.ClickOnYearDropDown();
        billToBill.ClickOnMonthlyDropDown();
        billToBill.ClickOnDateDropDown();
    }

    @Then("User select Bill group# check box")
    public void userSelectBillGroupCheckBox()
    {
        billToBill=new BillToBillPage(driver,scenario);
        billToBill.validateBillSelection();
        billToBill.ClickBillGroup();
    }

    @And("User clicks on Load button")
    public void userClicksOnLoadButton()
    {
        billToBill=new BillToBillPage(driver,scenario);
        billToBill.ClickLoadButton();
    }

    @Then("In Bill Selection page user should click on Bill Selection group#")
    public void inBillSelectionPageUserShouldClickOnBillSelectionGroup() throws InterruptedException
    {
        billSelection=new BillingSelectionPage(driver,scenario);
        billSelection.ValidateBillingSelection();
        billSelection.SelectBillingSelect();
    }

    @And("User click on Print button on Bill selection page")
    public void userClickOnPrintButtonOnBillSelectionPage() throws InterruptedException, AWTException
    {
        billSelection=new BillingSelectionPage(driver,scenario);
        billSelection.ValidateBillingSelection();
        billSelection.ClickPrintButton();
    }

    @And("User clicks on Print button in Print customer billing popup")
    public void userClicksOnPrintButtonInPrintCustomerBillingPopup() throws InterruptedException, AWTException
    {
        billSelection=new BillingSelectionPage(driver,scenario);
        billSelection.ValiddatePrintCustomerBillPopup();
        billSelection.PrintCustomerBillPopUp();
        billSelection.CancelInPrintPopup();
    }

    @And("User select Monthly radio button")
    public void userSelectMonthlyRadioButton()
    {
        billToBill=new BillToBillPage(driver,scenario);
        billToBill.MonthlyRadioButton();
        billToBill.ValidateBillToBill();
        billToBill.ClickOnMonthlyDropDown();
        billToBill.ClickOnYearDropDown();
    }

    @And("User should click on Cancel button in Bill Selection page")
    public void userShouldClickOnCancelButtonInBillSelectionPage()
    {
        billSelection=new BillingSelectionPage(driver,scenario);
        billSelection.CancelButton();
    }

    @And("User should click on UndoBill button in Bill Selection page")
    public void userShouldClickOnUndoBillButtonInBillSelectionPage()
    {
        billSelection=new BillingSelectionPage(driver,scenario);
        billSelection.UndoBilling();
        billSelection.UndoBillingPopup();
    }

    @Then("User selects From range as {int} and to range as {int}")
    public void userSelectsFromRangeAsAndToRangeAs(int arg0, int arg1)
    {
        billSelection=new BillingSelectionPage(driver,scenario);
        billSelection.FromRange(arg0);
        billSelection.ToRange(arg1);
        billSelection.RangeSelectButton();
        billSelection.TaggleButton();
    }
}
