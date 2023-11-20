package stepDefination_DSD_OMS.QuotePage;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.*;
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.quote.NewQuotePage;
import pages_DSD_OMS.quote.QuotePage;
import pages_DSD_OMS.quote.QuoteSummaryPage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class QuotePageSteps
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static String Ord_No=null;
    static String Quote_No=null;
    static boolean flag=false;
    static boolean flag1=false;
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

    @Given("User enters URL and is on login page and entered credentials for Quotes")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForQuotes() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Quotes")
    public void user_is_on_home_pageForQuotes() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for Quotes")
    public void user_navigate_to_client_sideForQuotes() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab for Quotes")
    public void user_should_select_order_entry_tabForQuotes() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderEntryPage = new OrderEntryPage(driver, scenario);
            orderEntryPage.NavigateToOrderEntry();
            currentURL=driver.getCurrentUrl();
        }
    }

    @Then("User selects Account# for Quotes")
    public void user_selects_accountForQuotes() throws InterruptedException, AWTException, ParseException
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

    @Then("User enters Quote name {string} and Quote End date click on OK button")
    public void userEntersQuoteNameAndQuoteEndDateClickOnOKButton(String Quote)
    {
        quotePage=new QuotePage(driver,scenario);
        quotePage.validateQuote();
        quotePage.EnterQuotName(Quote);
        quotePage.ClickOnCalender();
        quotePage.SelectEndDate();
        quotePage.ClickOnOKButton();
        //newQuotePage=new NewQuotePage(driver,scenario);
        //newQuotePage.validateNewQuote();
    }

    @Then("Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit")
    public void enterProInQuickProductEntryAreaInNewQutoePageAndEnterQtyForCaseAndUnit(DataTable tabledata)
    {
        List<List<String>> QtyValue = tabledata.asLists(String.class);
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.validateNewQuote();
        newQuotePage.EnterQuickProductNo();
        newQuotePage.QtyInGrid(QtyValue.get(0).get(0),QtyValue.get(0).get(1));
    }

    @Then("Click on create button in New Quote page")
    public void clickOnCreateButtonInNewQuotePage()
    {
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.validateNewQuote();
        newQuotePage.ClickOnCreateButton();
    }

    @And("User click on Back to orderlist button from Quote summary page and Read order number")
    public void userClickOnBackToOrderlistButtonFromQuoteSummaryPageAndReadOrderNumber() throws InterruptedException, AWTException
    {
        summary =new CheckOutSummaryPage(driver,scenario);
        Quote_No=summary.Get_Quote_No();
        quoteSummaryPage=new QuoteSummaryPage(driver,scenario);
        quoteSummaryPage.ValidateQuoteSummary();
        quoteSummaryPage.ClickOnBackToOrder();
    }

    @And("User clicks on drop down next to Start order button and select Quote option")
    public void userClicksOnDropDownNextToStartOrderButtonAndSelectQuoteOption() throws InterruptedException, AWTException
    {
        orderEntryPage = new OrderEntryPage(driver, scenario);
        orderEntryPage.Click_DropDown();
        orderEntryPage.SelectQuote();
    }

    @Then("Verify User is on Order Entry Page and verify Quote is existing")
    public void verifyUserIsOnOrderEntryPageAndVerifyQuoteIsExisting() throws InterruptedException, AWTException
    {
        orderEntryPage=new OrderEntryPage(driver,scenario);
        orderEntryPage.ValidateOE();
        orderEntryPage.SearchBoxAction(Quote_No);
        orderEntryPage.ValidateQuoteOrder(Quote_No);
    }

    @Then("User selects Quote in Order Entry grid")
    public void userSelectsQuoteInOrderEntryGrid() throws InterruptedException, AWTException
    {
        orderEntryPage=new OrderEntryPage(driver,scenario);
        orderEntryPage.ClickOnQuote();
    }

    @And("User should be navigated to Quote summary page and click on Convert OG button")
    public void userShouldBeNavigatedToQuoteSummaryPageAndClickOnConvertOGButton()
    {
        quoteSummaryPage=new QuoteSummaryPage(driver,scenario);
        quoteSummaryPage.ValidateQuoteSummary();
        quoteSummaryPage.ClickOnConvertOG();
    }

    @And("User should be navigated to Quote summary page and click on Convert Order button")
    public void userShouldBeNavigatedToQuoteSummaryPageAndClickOnConvertOrderButton() throws InterruptedException, AWTException
    {
        quoteSummaryPage=new QuoteSummaryPage(driver,scenario);
        quoteSummaryPage.ValidateQuoteSummary();
        quoteSummaryPage.ClickOnConvertOrder();
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
    }

    @And("User should be navigated to Quote summary page and click on cancel button")
    public void userShouldBeNavigatedToQuoteSummaryPageAndClickOnCancelButton()
    {
        quoteSummaryPage=new QuoteSummaryPage(driver,scenario);
        quoteSummaryPage.ValidateQuoteSummary();
        quoteSummaryPage.ClickOnCancel();
    }

    @Then("Click on Cancel button in New Quote page")
    public void clickOnCancelButtonInNewQuotePage()
    {
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.validateNewQuote();
        newQuotePage.ClickOnCancelButton();
    }

    @And("User clicks on Plus symbol in new Quote page and selects Catalog option from drop down")
    public void userClicksOnPlusSymbolInNewQuotePageAndSelectsCatalogOptionFromDropDown()
    {
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.validateNewQuote();
        newQuotePage.ClickOnAddProduct();
        newQuotePage.SelectCatalog();
    }

    @Then("User adds some products from catalog")
    public void userAddsSomeProductsFromCatalog(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> Qty=tabledata.asLists(String.class);
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.validateCatalog();
        newQuotePage.ResetFilter_Catalog();
        newQuotePage.SelectProductFromCatalog();
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.EnterQty(Qty.get(0).get(0), Qty.get(0).get(1));
        //newQuotePage.EnterProductQtyCatalog(Qty.get(0).get(0), Qty.get(0).get(1));
    }

    @And("User clicks on Plus symbol in new Quote page and selects OG option from drop down")
    public void userClicksOnPlusSymbolInNewQuotePageAndSelectsOGOptionFromDropDown()
    {
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.validateNewQuote();
        newQuotePage.ClickOnAddProduct();
        newQuotePage.SelectOG();
        newQuotePage.SelectOGFromPopup();
    }

    @Then("User enters some Qty to product in Product grid")
    public void userEntersSomeQtyToProductInProductGrid(DataTable tabledata)
    {
        List<List<String>> QtyValue = tabledata.asLists(String.class);
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.QtyInGrid(QtyValue.get(0).get(0),QtyValue.get(0).get(1));
    }

    @Then("User click on Copy button in summary page and enter Quote name {string} and Click on Create button")
    public void userClickOnCopyButtonInSummaryPageAndEnterQuoteNameAndClickOnCreateButton(String Quote1) throws InterruptedException, AWTException
    {
        quoteSummaryPage=new QuoteSummaryPage(driver,scenario);
        quoteSummaryPage.ValidateQuoteSummary();
        quoteSummaryPage.ClickOnCopy();
        quotePage=new QuotePage(driver,scenario);
        quotePage.EnterQuotName(Quote1);
        quotePage.ClickOnCalender();
        quotePage.SelectEndDate();
        quotePage.ClickOnOKButton();
        orderEntryPage = new OrderEntryPage(driver, scenario);
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        for(int i=0;i<=1;i++)
        {
            orderEntryPage.OrderGuidePopup();
            orderEntryPage.NoNotePopHandling();
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.ClickOnCreateButton();
    }

    @And("User click on Print button")
    public void userClickOnPrintButton()
    {
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.PrintQuote();
    }

    @Then("User should navigated to Order Entry page from OG page")
    public void userShouldNavigatedToOrderEntryPageFromOGPage()
    {
        quoteSummaryPage=new QuoteSummaryPage(driver,scenario);
        quoteSummaryPage.NavgiateBackToOE();
    }

    @Then("User enters Description {string} Start date {int} and End date {int} day from current date for Quote to OG")
    public void userEntersDescriptionStartDateSdateAndEndDateEdateDayFromCurrentDateForQuoteToOG(String arg0,int Sdate,int Edate)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateNewOG();
        createOGPage.DescriptionOG(arg0);

        //selecting start date
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        createOGPage.CalenderStart();
        createOGPage.SelectStartDate(formattedDate, Sdate);

        //selecting end date
        LocalDate myDateObj1 = LocalDate.now();
        DateTimeFormatter myFormatObj1= DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate1 = myDateObj1.format(myFormatObj1);
        createOGPage.CalenderEnd();
        createOGPage.SelectEndDate(formattedDate1,Edate);
    }
}