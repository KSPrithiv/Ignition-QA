package stepDefination_DSD_OMS.QuotePage;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.quote.NewQuotePage;
import pages_DSD_OMS.quote.QuotePage;
import pages_DSD_OMS.quote.QuoteSummaryPage;
import util.TestBase;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class QuotePageSteps1
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    OrderEntryPage orderEntryPage;
    NewOrderEntryPage newOE;
    NewQuotePage newQuotePage;
    QuoteSummaryPage quoteSummaryPage;
    CheckOutOrderPage checkOutOrderPage;
    OrderEntryPage orderpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("Enter multiple Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit")
    public void enterMultipleProInQuickProductEntryAreaInNewQutoePageAndEnterQtyForCaseAndUnit(DataTable tabledata)
    {
        List<List<String>> QtyList=tabledata.asLists(String.class);
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.AddMultipleProducts(QtyList);
    }

    @And("User selects one product from product grid and click on delete button")
    public void userSelectsOneProductFromProductGridAndClickOnDeleteButton()
    {
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.SelectProductInProductGrid();
        newQuotePage.ClickOnDeleteButton();
    }

    @And("User should be navigated to Quote summary page and click on Edit button")
    public void userShouldBeNavigatedToQuoteSummaryPageAndClickOnEditButton()
    {
        quoteSummaryPage=new QuoteSummaryPage(driver,scenario);
        quoteSummaryPage.ValidateQuoteSummary();
        quoteSummaryPage.ClickOnEdit();
    }

    @Then("If user navigates to payment and address page click on Back button or else add product# in Quick product entry")
    public void ifUserNavigatesToPaymentAndAddressPageClickOnBackButtonOrElseAddProductInQuickProductEntry(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>>Qty=tabledata.asLists(String.class);
        checkOutOrderPage=new CheckOutOrderPage(driver,scenario);
        boolean result=checkOutOrderPage.VerifyCheckOut();
        if(result==true)
        {
            checkOutOrderPage.BackButton_Click();
        }
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.EnterQuickProductNoSecond();
        newQuotePage.QtyInGrid(Qty.get(0).get(0),Qty.get(0).get(1));
    }

    @Then("If user navigates to payment and address page click on Back button or else Click on Add product and select OG")
    public void ifUserNavigatesToPaymentAndAddressPageClickOnBackButtonOrElseClickOnAddProductAndSelectOG(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> Qty=tabledata.asLists(String.class);
        checkOutOrderPage=new CheckOutOrderPage(driver,scenario);
        boolean result=checkOutOrderPage.VerifyCheckOut();
        if(result==true)
        {
            checkOutOrderPage.BackButton_Click();
        }
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.EnterQuickProductNoSecond();
        newQuotePage.QtyInGrid(Qty.get(0).get(0),Qty.get(0).get(1));
    }

    @Then("If user navigates to payment and address page click on Back button or else Click on Add product and select OG {string}")
    public void ifUserNavigatesToPaymentAndAddressPageClickOnBackButtonOrElseClickOnAddProductAndSelectOG(String Og,DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> Qty=tabledata.asLists(String.class);
        checkOutOrderPage=new CheckOutOrderPage(driver,scenario);
        boolean result=checkOutOrderPage.VerifyCheckOut();
        if(result==true)
        {
            checkOutOrderPage.BackButton_Click();
        }
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.ClickOnAddProduct();
        newQuotePage.selectFromOG();
        newQuotePage.validateOGPopup();
        newQuotePage.searchAndAddOG(Og);
        newQuotePage.enterQtyAfterAddingOG(Qty.get(0).get(0), Qty.get(0).get(1));
    }

    @And("User click on Comment Icon in Quote page and select Internal comment flag")
    public void userClickOnCommentIconInQuotePageAndSelectInternalCommentFlag(DataTable tabledata)
    {
        List<List<String>> Comment=tabledata.asLists(String.class);
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.ClickComment();
        newQuotePage.ClickOnPrintFlag();
        newQuotePage.SelectPrintflag();
        newQuotePage.QuoteCommentPopup(Comment.get(0).get(0));
        newQuotePage.QuoteCommentOk();
    }

    @And("User should be navigated to Quote summary page")
    public void userShouldBeNavigatedToQuoteSummaryPage()
    {
        quoteSummaryPage=new QuoteSummaryPage(driver,scenario);
        quoteSummaryPage.ValidateQuoteSummary();
    }

    @And("User verifies skip button in OE page when Quotes is already created")
    public void userVerifiesSkipButtonInOEPageWhenQuotesIsAlreadyCreated() throws InterruptedException, AWTException
    {
        orderEntryPage=new OrderEntryPage(driver,scenario);
        orderEntryPage.verifySkipButton();
    }

    @And("User verifies Skip button in New OE page")
    public void userVerifiesSkipButtonInNewOEPage() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.verifySkipButton();
    }

    @Then("Enter BOGO Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit")
    public void enterBOGOProInQuickProductEntryAreaInNewQutoePageAndEnterQtyForCaseAndUnit(DataTable tabledata)
    {
        List<List<String>> QtyValue = tabledata.asLists(String.class);
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.boGoItemsAdding();
        newQuotePage.QtyInGrid(QtyValue.get(0).get(0),QtyValue.get(0).get(1));
    }

    @And("User verifies the products added to Quote")
    public void userVerifiesTheProductsAddedToQuote()
    {
        newQuotePage=new NewQuotePage(driver,scenario);
        newQuotePage.readProductQuote();
    }

    @Then("User should reset the delivery date to current date")
    public void userShouldResetTheDeliveryDateToCurrentDate() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.ClickCalender();
        orderpage.ResetToCurrentDate();
    }

    @Then("User should navigate to OE page, User should select the current date as delivery date")
    public void userShouldNavigateToOEPageUserShouldSelectTheCurrentDateAsDeliveryDate() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.Refresh_Page1();
        orderpage.ClickCalender();
        orderpage.ResetToCurrentDate();
    }
}
