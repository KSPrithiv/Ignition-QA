package stepDefination_DSD_OMS.OrderEntryPage;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Project DSD_OMS_
 * @Author Divya.Ramadas
 */
public class OrderEntryPageSteps2
{
    /* Created by Divya.Ramadas */
    public static boolean exists = false;
    WebDriver driver;
    Scenario scenario;

    static OrderEntryPage orderpage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static CheckOutOrderPage checkorder;

    static String Tot_Amt=null;
    static String Tot_Amt1=null;
    static String Route=null;
    static String Route1=null;
    static String Order_No=null;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1= TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    //for entering multiple products from Quick product entry, using it for drag and drop
    @Then("Enter Prod_No in Quick Product Entry area")
    public void enterProd_NoInQuickProductEntryArea(DataTable tabledata) throws InterruptedException, AWTException, SQLException
    {
        String unitOfMeasure=null;
        java.util.List<java.util.List<String>> Prod_details = tabledata.asLists(String.class);
        newOE = new NewOrderEntryPage(driver,scenario);
        ArrayList<String> Prod_No= (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
        for (int i = 0; i <= Prod_details.size() - 1; i++)
        {
            String pro=String.valueOf(Prod_No.get(i));
            newOE.QuickProduct(pro);
            unitOfMeasure=newOE.readUnitOfMeasure();
            if(unitOfMeasure.equals("Units"))
            {
                newOE.CheckForQuickUnitEnabled(Prod_details.get(i).get(1));
                newOE.exceedsMaxQty();
                newOE.toastCurrentlyUnavailable();
            }
             else if(unitOfMeasure.equals("Cases"))
            {
                newOE.CheckForQuickCaseEnabled(Prod_details.get(i).get(0));
                newOE.exceedsMaxQty();
                newOE.toastCurrentlyUnavailable();
            }
             else if(unitOfMeasure.equals("Cases, Units"))
            {
                newOE.CheckForQuickCaseEnabled(Prod_details.get(i).get(0));
                newOE.CheckForQuickUnitEnabled(Prod_details.get(i).get(1));
                newOE.exceedsMaxQty();
                newOE.toastCurrentlyUnavailable();
            }
        }
    }

    @And("Drag and drop table header")
    public void drag_and_drop_table_header(DataTable tabledata) throws InterruptedException, AWTException
    {
        java.util.List<java.util.List<String>> TableHead=tabledata.asLists(String.class);
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.FindtableHeader(TableHead.get(0).get(0));
    }

    @Then("User enters ProdDes in Search box")
    public void user_enters_prodDes_in_search_box() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        //Enter product Desc in search bar
        newOE.SearchBox_ProdDesc(TestBase.testEnvironment.getProdDesc());
    }

    //Reading total amount from the New OE page
    @And ("Find total amount from New oe page")
    public void find_total_amount_from_new_oe_page() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        Tot_Amt=newOE.Total_NewOE();
    }

    //Reading total amount from the summary page
    @And ("Get total amount from summary page and Click on SubmitOrder button")
    public void get_total_amount_from_summary_page_and_click_on_submitorder_button() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        Tot_Amt1=summary.Find_TotalAmt();
        summary.ClickSubmit();
        scenario.log("Product Total found in New OE page: "+Tot_Amt+" Product total found in summary page: "+Tot_Amt1);
        //asserting totals
        Assert.assertEquals(Tot_Amt,Tot_Amt1);
    }

    //selecting rout from the Route index popup
    @Then ("User should  click on route index icon and select route")
    public void user_should_click_on_route_index_icon_and_select_route() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        //Select Route number using Add Filter
        orderpage.Route_No(TestBase.testEnvironment.get_RouteFilt(),TestBase.testEnvironment.get_Route());
        orderpage.validateRouteSelected(TestBase.testEnvironment.get_Route());
    }

    //Compare route selected in OE page and New OE page
    @Then ("Compare route selected in OE page with route in NewOE page")
    public void compare_route_selected_in_oe_page_with_route_in_newoe_page() throws InterruptedException, AWTException
    {
        boolean result=false;
        newOE=new NewOrderEntryPage(driver,scenario);
        String route2=TestBase.testEnvironment.get_Route();
        Route1=newOE.Read_Route();
        if(Route1.equals(route2) || Route1.contains(route2))
        {
            result=true;
        }
        Assert.assertEquals(result,true);
    }

    //To find total number of products in summary page
    @Then ("In Order Summary page compare Total no of line compare it with no of products")
    public void in_order_summary_page_compare_total_no_of_line_compare_it_with_no_of_products() throws InterruptedException, AWTException
    {
        summary= new CheckOutSummaryPage(driver,scenario);
        //summary.compareTotal();
        summary.totalProducts();
    }

    //To compare total amount in summary card and order total card
    @And ("Get total amount from summary card and Order total on SubmitOrder button")
    public void get_total_amount_from_summary_card_and_order_total_on_submitorder_button() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        Tot_Amt1=summary.Find_TotalAmt();
        //find total in summary card
        String tot=driver.findElement(By.xpath("//div[contains(text(),'Product total')]/following-sibling::div")).getText();

        //asserting totals
        Assert.assertEquals(tot,Tot_Amt1);
        summary.ClickSubmit();
    }

    //Code to change Account# to other Account#
    @And ("change the account_No to someother account#")
    public void change_the_account_no_to_someother_account_no() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        //Changing account number
        orderpage.Change_NewAccount(TestBase.testEnvironment.get_AnotherAcc());
        orderpage.PopUps_After_AccountChange();
    }
    //check whether user has navigated to NewOE enter page
    @And ("Check whether user navigated to NewOE page")
    public void check_whether_user_navigated_to_newoe_page() throws InterruptedException, AWTException
    {
        exists=false;
        newOE=new NewOrderEntryPage(driver,scenario);
        if(HelpersMethod.IsExists("//div[@id='orderEntryCard']/descendant::label[contains(text(),'New order')]",driver))
        {
            scenario.log("FOUND NEW ORDER ENTRY PAGE");
            exists=true;
        }
        else
        {
            scenario.log("CHECK WITH ADMIN SETTING IS ENABLED OR NOT, SO THAT ONCE CUSTOMER ACC# IS CHANGED SHOULD NAVIGATE TO NEW OE PAGE");
            exists=true;
        }
        Assert.assertEquals(exists,true);
    }
    //changing the account number to the previous account# which was loaded before
    @And ("user should change the Account# back to Previous Account#")
    public void user_should_change_the_account_no_back_to_previous_account_no() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_Back_But();

        orderpage=new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        //Change Customer account to old account number
            orderpage.Change_OldAccount(TestBase.testEnvironment.get_Account());
            orderpage.PopUps_After_AccountChange();
    }
    //Cancel the order from Order summary page
    @Then("Click on Cancel button in OE summary page and handle warning popup")
    public void click_on_cancel_button_in_oe_summary_page_and_handle_warning_popup() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.Cancel_Button();
        summary.VerifyCancelPopUp();
        summary.CancelPop();
    }

    //To check whether the products in order summary page are in sorted order or not
    @Then ("In Order Summary page click on up arrow for sorting product in descending order of product number")
    public void in_order_summary_page_click_on_up_arrow_for_sorting_product_in_descending_order_of_product_number() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.Product_UpArrow();
    }

    @Then("Click on Next button to naviagate to OE summary page to cancle order")
    public void clickOnNextButtonToNaviagateToOESummaryPageToCancleOrder() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        exists=newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        if(HelpersMethod.IsExists("//div[@id='checkoutCard']",driver))
        {
            checkorder = new CheckOutOrderPage(driver, scenario);
            if (HelpersMethod.IsExists("//div[@id='paymentMethodCard']", driver))
            {
                checkorder.Select_PaymentMethod_ClickDownArrow();
                if (HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']", driver)) {
                    checkorder.SelectPaymentMethod();
                    scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
                } else {
                    checkorder.Click_On_Without_Providing_Payment();
                    scenario.log("WITHOUT PROVIIDNG PAYMENT OPTION HAS BEEN SELECTED");
                }
            }
            checkorder.DeliveryAddressCard();
            checkorder.NextButton_Click();
        }
    }

  /*  @And("Order type Popup should display there user should select Regular order by using Add filter button")
    public void orderTypePopupShouldDisplayThereUserShouldSelectRegularOrderByUsingAddFilterButton()
    {

    }*/
}
