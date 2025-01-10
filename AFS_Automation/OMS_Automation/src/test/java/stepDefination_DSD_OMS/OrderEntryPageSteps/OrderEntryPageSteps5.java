package stepDefination_DSD_OMS.OrderEntryPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.time.Duration;
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

    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static OrderHistoryPage orderHistoryPage;
    static OrderEntryPage orderpage;
    static CheckOutOrderPage checkorder;
    static String paymentMethod;
    static boolean exists=false;
    static String Ord_No;


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
    public void userShouldClickOnDeliveryDateAndSelectDeliveryDateByIncreasingOneDayThenUserShouldHandleThePopupAlso() throws InterruptedException, AWTException, ParseException
    {
        //create object of OE Page
        orderpage = new OrderEntryPage(driver, scenario);
        //get current date add some days to current date
        /*LocalDate myDateObj = LocalDate.now().plusDays(1);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        orderpage.ClickCalender();

        orderpage.SelectDatePendingOrder(formattedDate, 1);
        orderpage.ChangedDeliveryDate();*/

        //create object of OE Page
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Read_DeliveryDate();
        orderpage.ClickCalender();
        orderpage.SelectDate(1);
        orderpage.cancelOGselection();
        orderpage.ChangedDeliveryDate();

        //Handle Popup that appears after changing delivery date
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.ValidateChangeDeliveryDatePopup();
        newOE.SelectChangeDeliveryDatePopup();
    }

    @And("User should verify all other WebElements are disabled, and no Products in Product grid")
    public void userShouldVerifyAllOtherWebElementsAreDisabledAndNoProductsInProductGrid() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        boolean exists=newOE.VerifyForMessageForPOMandatory();
        if(exists==true)
        {
            newOE.VerifyWebElements();
            newOE.VerifyProductGrid();
        }
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
        if(HelpersMethod.IsExists("//div[@id='orderEntryCard']",driver))
        {
            newOE = new NewOrderEntryPage(driver, scenario);
            newOE.ValidateNewOE();
            newOE.OECancel();
        }
        else if(HelpersMethod.IsExists("//div[@id='order-search-card']",driver))
        {
            Wait<WebDriver> wait;
            orderpage=new OrderEntryPage(driver,scenario);
            orderpage.Start_Order();
            orderpage.NoPendingOrderPopup();
            for (int i = 0; i <= 1; i++)
            {
                orderpage.OrderGuidePopup();
                Thread.sleep(1000);
                orderpage.NoNotePopHandling();
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            newOE = new NewOrderEntryPage(driver, scenario);
            newOE.ValidateNewOE();
            newOE.OECancel();
        }
    }

    @And("User should click on Cancel and skip button by selecting reason")
    public void userShouldClickOnCancelAndSkipButtonBySelectingReason(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> Reason = tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.VerifyCancelPopUp();
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

    @And("User should click on delivery date and select delivery date by increase day for pending order then user should handle the popup also")
    public void userShouldClickOnDeliveryDateAndSelectDeliveryDateByIncreaseDayForPendingOrderThenUserShouldHandleThePopupAlso() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        Actions act=new Actions(driver);
        orderpage.ClickCalender();
        List<WebElement> dates= HelpersMethod.FindByElements(driver,"xapth","//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]/descendant::tr[@role='row']/td[contains(@style,'background-color: rgb')]");
        for(int i=1;i<=dates.size();i++)
        {
            act.moveToElement(dates.get(i)).build().perform();
            if(i==1)
            {
                act.moveToElement(dates.get(i)).build().perform();
                act.click(dates.get(i)).build().perform();
                break;
            }
        }

        //get current date add some days to current date
        LocalDate myDateObj = LocalDate.now().plusDays(1);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);

        orderpage.SelectDatePendingOrder(formattedDate, 1);
        orderpage.ChangedDeliveryDate();

        //Handle Popup that appears after changing delivery date
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateChangeDeliveryDatePopup();
        newOE.SelectChangeDeliveryDatePopup();
    }

    @And("Drag and drop table header in submit page")
    public void dragAndDropTableHeaderInSubmitPage(DataTable tabledata) throws InterruptedException, AWTException
    {
       java.util.List<java.util.List<String>> TableHead=tabledata.asLists(String.class);
       summary = new CheckOutSummaryPage(driver,scenario);
       summary.FindtableHeader(TableHead.get(0).get(0));
    }

    @Then("User should select the product in product grid in NewOE page")
    public void userShouldSelectTheProductInProductGridInNewOEPage() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.selectFirstRowInGrid();
    }

    @And("User should click on info dropdown, to select price inq option and validate the price inq dialog box display")
    public void userShouldClickOnInfoDropdownToSelectPriceInqOptionAndValidateThePriceInqDialogBoxDisplay() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.clickOnInfoDropDown();
        newOE.selectShowPriceInq();
        newOE.validatePriceInqDialogBox();
        newOE.readValuesInPriceInqDialogBox();
        newOE.clickOkbuttonOfPriceInqDialogBox();
    }

    @Then("Click on Next button and validate that in order entry page payment options are disabled")
    public void clickOnNextButtonAndValidateThatInOrderEntryPagePaymentOptionsAreDisabled() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        Thread.sleep(1000);
        //handling toast messages
        for(int i=0;i<=2;i++)
        {
            //check for toast message for low on inventory
            newOE.lowOnInventoryToast();
            //check for toast message for product is currently unavailable
            newOE.toastCurrentlyUnavailable();
        }

        for(int i=0;i<=1;i++)
        {
            newOE.priceCannotBeBleowCost();
            newOE.exceedsMaxQty();
        }
        exists=newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        checkorder=new CheckOutOrderPage(driver,scenario);
        Thread.sleep(4000);
        Ord_No=checkorder.readOrderNumber();
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//tr/descendant::td[@class='payment-method-type-cell']/descendant::input[@checked]",driver) && HelpersMethod.IsExists("//button[@id='allowOrderWithoutPayment' and @disabled]",driver))
            {
                scenario.log("PAYMENT OPTION HAS BEEN SELECTED AT THE TIME OF CREATION OF ORDER");
            }
            checkorder.DeliveryAddressCard();
            checkorder.NextButton_Click();
        }
    }
}
