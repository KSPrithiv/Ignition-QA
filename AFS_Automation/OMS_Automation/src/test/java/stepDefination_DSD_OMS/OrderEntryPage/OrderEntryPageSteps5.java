package stepDefination_DSD_OMS.OrderEntryPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderHistoryPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class OrderEntryPageSteps5
{
    /* Created by Divya.Ramadas@afsi.com */

    WebDriver driver;
    Scenario scenario;

    static boolean exists=false;
    static OrderEntryPage orderEntryPage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static OrderHistoryPage orderHistoryPage;
    static OrderEntryPage orderpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("Cancel popup should appear and verify button Cancel and Skip button")
    public void cancelPopupShouldAppearAndVerifyButtonCancelAndSkipButton() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.OECancel();
        newOE.VerifyCancelPopUp();
        newOE.CancelAndSkipPopupEnabled();
        newOE.CancelPop();
    }

    @And("User should verify UOM value for Quick unit and Quick Case value to be entered")
    public void userShouldVerifyUOMValueForQuickUnitAndQuickCaseValueToBeEntered() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.VerifyUOM();
    }

    @And("User should click on delivery date and select delivery date by increasing one day then user should handle the popup also")
    public void userShouldClickOnDeliveryDateAndSelectDeliveryDateByIncreasingOneDayThenUserShouldHandleThePopupAlso() throws InterruptedException, AWTException
    {
        //create object of OE Page
        orderpage = new OrderEntryPage(driver, scenario);
        //get current date add some days to current date
        LocalDate myDateObj = LocalDate.now().plusDays(1);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        orderpage.ClickCalender();
        orderpage.SelectDatePendingOrder(formattedDate, 1);
        orderpage.ChangedDeliveryDate();

        //Handle Popup that appears after changing delivery date
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateChangeDeliveryDatePopup();
        newOE.SelectChangeDeliveryDatePopup();
    }

    @And("User should verify all other WebElements are disabled, and no Products in Product grid")
    public void userShouldVerifyAllOtherWebElementsAreDisabledAndNoProductsInProductGrid() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.VerifyForMessageForPOMandatory();
        newOE.VerifyProductGrid();
        newOE.VerifyWebElements();
    }

    @And("User should select the First order comment icon in the order history grid to verify whether comment is added or not")
    public void userShouldSelectTheFirstOrderCommentIconInTheOrderHistoryGridToVerifyWhetherCommentIsAddedOrNot() throws InterruptedException, AWTException
    {
        orderHistoryPage=new OrderHistoryPage(driver,scenario);
        orderHistoryPage.ValidateOrderHistory();
        orderHistoryPage.VerifyCommentInHistory();
    }

    @Then("User should click on Order button in Order histroy page to navigate back to OE page")
    public void userShouldClickOnOrderButtonInOrderHistroyPageToNavigateBackToOEPage() throws InterruptedException, AWTException
    {
        orderHistoryPage=new OrderHistoryPage(driver,scenario);
        orderHistoryPage.OrderButtonClick();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.ValidateOE();
    }

    @Then("User click on Cancel button and Popup should appear")
    public void userClickOnCancelButtonAndPopupShouldAppear() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.OECancel();
    }

    @And("User should click on Cancel and skip button by selecting reason")
    public void userShouldClickOnCancelAndSkipButtonBySelectingReason(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> Reason = tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.CancelAndSkipPopup();
        newOE.New_OE_Validate_Skip_Button();
        newOE.New_OE_Select_SkipReason(Reason.get(0).get(0));
    }

    @Then("User should be on Order Summary page  and click on Print button")
    public void userShouldBeOnOrderSummaryPageAndClickOnPrintButton() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.ValidateSummaryOrderPage();
        summary.PrintOE();
    }

    @Then("User should be in NewOE page and click on Print button")
    public void userShouldBeInNewOEPageAndClickOnPrintButton() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.PrintNewOE();
    }

    @Then("User enters foregin language discription of Product in Search box")
    public void userEntersForeginLanguageDiscriptionOfProductInSearchBox() throws InterruptedException, AWTException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        String ProdName= TestBase.testEnvironment.getForeignLangDesc();
        newOE.EnterProdNo_InSearchBar(ProdName);
    }
}
