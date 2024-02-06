package stepDefination_DSD_OMS.OrderEntryPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderEntryPageSteps6
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
    static CheckOutOrderPage checkorder;
    static String changedSalesRep;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    //Method to create pickup order
    @And("Select Pickup Order from drop down options and select delivery date")
    public void select_pickup_order_from_drop_down_options_and_select_delivery_date() throws InterruptedException, AWTException
    {
        //for selecting pickup order
        orderpage=new OrderEntryPage(driver, scenario);
        orderpage.Pickup_Order();
        orderpage.SelectPickupOrderDeliveryDate();
    }

    @And("User validates Pickup order check box is selected")
    public void userValidatesPickupOrderCheckBoxIsSelected() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.Validate_Pickup_Order();
    }

    @And("Click on SubmitOrder button before that validate pickup order")
    public void clickOnSubmitOrderButtonBeforeThatValidatePickupOrder() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.ValidateSummaryOrderPage();
        summary.PickupOrderValidate();
        summary.ClickSubmit();
        summary.cutoffDialog();
        summary.SucessPopup();
    }

    @And("User navigated to New OE page and clicks on Pickup check box")
    public void userNavigatedToNewOEPageAndClicksOnPickupCheckBox() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.ClickPickupCheckBox();
        newOE.validatePickupCheckBoxSelected();
    }

    @And("Select Pickup Order from drop down options and select delivery date by verifying existence of todays date")
    public void selectPickupOrderFromDropDownOptionsAndSelectDeliveryDateByVerifyingExistenceOfTodaysDate() throws InterruptedException, AWTException, ParseException
    {
        //for selecting pickup order
        orderpage=new OrderEntryPage(driver, scenario);
        orderpage.Pickup_Order();
        orderpage.ValidatingTodaysDate();
        orderpage.SelectPickupOrderDeliveryDate();
    }

    @And("User removes route details from Route field and Route is empty")
    public void userRemovesRouteDetailsFromRouteFieldAndRouteIsEmpty() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.ValidateOE();
        orderpage.RemoveRoute();
        orderpage.RouteIsEmpty();
    }

    @Then("User clicks on Start button and Route mandatory popup should display")
    public void userClicksOnStartButtonAndRouteMandatoryPopupShouldDisplay() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        WebElement StartBut= HelpersMethod.FindByElement(driver,"id","addButton");
        HelpersMethod.ScrollElement(driver,StartBut);
        HelpersMethod.ClickBut(driver,StartBut,1000);
        orderpage.ValidateRouteMandatoryPopup();
    }

    @And("User should handle Route mandatory popup")
    public void userShouldHandleRouteMandatoryPopup() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.RoutePopup();
        HelpersMethod.Refresh(driver);
    }

    @Then("User should enter price for product in price input box")
    public void userShouldEnterPriceForProductInPriceInputBox(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> Price = tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.EnterPriceInInputBox(Price.get(0).get(0));
       // newOE.ValidatePriceOverloadIcon();
    }

    @Then("Click on Next button and select option Continue without payment option")
    public void clickOnNextButtonAndSelectOptionContinueWithoutPaymentOption() throws InterruptedException, AWTException
    {
        /*exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        exists=newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            Thread.sleep(4000);
            checkorder.VerifyCheckOut();
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(checkorder.Verify_Existence_of_ContinuePayment())
            {
                checkorder.Click_On_Without_Providing_Payment();
            }
            checkorder.DeliveryAddressCard();
            checkorder.NextButton_Click();
        }*/
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        exists=newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            Thread.sleep(4000);
            //checkorder.validateCheckOrder();
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//button[@id='allowOrderWithoutPayment']",driver))
            {
                checkorder.Click_On_Without_Providing_Payment();
            }
            checkorder.DeliveryAddressCard();
            checkorder.NextButton_Click();
        }
    }

    @And("User clicks on filter by Qty drop down and selects {string}")
    public void userClicksOnFilterByQtyDropDownAndSelects(String arg0) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.clickOnFilterQty();
        newOE.selectFilterQty(arg0);
        newOE.displayProductsWithAvailableInventory();
    }

    @Then("Click on Add product drop down and select profile products")
    public void clickOnAddProductDropDownAndSelectProfileProducts() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_On_Add_Product();
        newOE.selectProfileProducts();
        newOE.readProductsInOrder();
    }

    @Then("User should  click on sales rep index icon and select sales rep")
    public void userShouldClickOnSalesRepIndexIconAndSelectSalesRep() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        changedSalesRep= orderpage.salesRep();
    }

    @Then("Compare Sales rep value selected in OE page with Sales rep in NewOE page")
    public void compareSalesRepValueSelectedInOEPageWithSalesRepInNewOEPage() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.validateSalesRep(changedSalesRep);

    }
}
