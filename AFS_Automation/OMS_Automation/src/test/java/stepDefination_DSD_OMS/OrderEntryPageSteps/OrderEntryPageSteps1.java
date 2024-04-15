package stepDefination_DSD_OMS.OrderEntryPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderHistoryPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderEntryPageSteps1
{
    /* Created by Divya.Ramadas@afsi.com */
    private static boolean flag = false;
    WebDriver driver;
    Scenario scenario;

    static OrderEntryPage orderpage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static OrderHistoryPage orderhistory;

    //static String XPath=null;
    static boolean exists=false;
    //static String Ord_No=null;
    //static String ProdNo=null;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1= TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    /* Created By Divya.Ramadas@afsi.com*/
    @Then("Click on Dropdown next to Ordertype input box Order type Popup should display")
    public void click_on_dropdown_next_to_ordertype_input_box_order_type_popup_should_display(DataTable tabledata) throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        List<List<String>> OrderType=tabledata.asLists(String.class);
        orderpage.orderTypeClick();
        orderpage.selectRegularOrder(OrderType.get(0).get(0),OrderType.get(0).get(1));
    }

    //Method for creating order using 'Copy from' drop down, in New OE page
    @Then("User should click on Copy from dropdown and Select Order history")
    public void user_should_click_on_copy_from_dropdown_and_select_order_history(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> OrdHist=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_On_Copy_From_DropDown(OrdHist.get(0).get(0));
    }

    @Then("Enter Qty for the products in Product grid")
    public void enter_qty_for_the_products_in_product_grid(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> QtyDetails = tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.EnterQty_ProductGrid(driver, QtyDetails);
    }

    //For Clicking Comment
    @Then("User should click on Comment icon in Order entry card")
    public void user_should_click_on_comment_icon_in_order_entry_card() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.Comment_Icon();
    }

    //Add comment in comment popup
    @Then("User should enter comment in comment popup")
    public void user_should_enter_comment_in_comment_popup(DataTable tabledata) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        List<List<String>> Comment = tabledata.asLists(String.class);
        newOE.validateCommentPopup();
        newOE.Comment_Popup(Comment.get(0).get(0));
    }

    //Click on Order number in Order history page
    @Then("Click on Order number in Order history grid")
    public void click_on_order_number_in_order_history_grid() throws InterruptedException, AWTException
    {
        orderhistory=new OrderHistoryPage(driver,scenario);
        orderhistory.Click_OrderNo();
    }

    //Click on Copy button in order summary page
    @Then("Click on Copy button in Summary page")
    public void click_on_copy_button_in_summary_page() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        summary.Click_copy();
    }

    //Comment icon in Order summary page
    @Then("Click on Comment icon in Summary page")
    public void click_on_comment_icon_in_summary_page() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        summary.CommentBut();
    }

    @And("Enter Comment in summary page")
    public void enter_comment_in_summary_page(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> Comment=tabledata.asLists(String.class);
        summary=new CheckOutSummaryPage(driver,scenario);
        //summary.validateSummaryPage();
        summary.Comment_Popup(Comment.get(0).get(0));
    }

    //Click on Add product button and select From catalog drop down
    @Then("Click on Add product drop down and select catalog option")
    public void click_on_add_product_drop_down_and_select_catalog_option() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Add_Product_From_Catalog();
    }

    @And("User should select Product from catalog and Enter Qty for the products")
    public void user_should_select_product_from_catalog_and_enter_qty_for_the_products_in_product_grid(DataTable tabledata) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        String Prod_No= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Validate_Catalog();
        newOE.clickOnLoadAllProducts();
        newOE.ResetFilter_Catalog();
        String pro=String.valueOf(Prod_No);
        newOE.validateCatalogProducts();
        newOE.Search_Prod_in_Catalog(pro);
        newOE.EnterQty(Prod_detail.get(0).get(0),Prod_detail.get(0).get(1));
        scenario.log("PRODUCT # "+pro+" PRODUCT QTY "+Prod_detail.get(0).get(0)+" "+Prod_detail.get(0).get(1));
    }

    @And("User should select Product from catalog and Enter Qty for the products for OCL")
    public void userShouldSelectProductFromCatalogAndEnterQtyForTheProductsForOCL(DataTable tabledata) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        String Prod_No= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Validate_Catalog();
        newOE.clickOnLoadAllProducts();
        newOE.ResetFilter_Catalog();
        newOE.validateCatalogProducts();
        //newOE.searchProdCatalogForOCL();
        newOE.enterQtyOCL(Prod_detail.get(0).get(0),Prod_detail.get(0).get(1));

        //scenario.log("PRODUCT # "+pro+" PRODUCT QTY "+Prod_detail.get(0).get(0)+" "+Prod_detail.get(0).get(1));
    }

    //Code to add notes at coustomer level
    @And ("User should click on Notes icon")
    public void user_should_click_on_notes_icon() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.click_On_CustomerNotes();
    }

    @Then ("Add note in popup")
    public void add_note_in_popup(DataTable tabledata) throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        List<List<String>> Cust_Note = tabledata.asLists(String.class);
        orderpage.Validate_Customer_Note();
        orderpage.Add_Customer_Note(Cust_Note.get(0).get(0));
    }

    @And("User should select the Alert Type and Alert location to display notes")
    public void user_should_select_the_alert_type_and_alert_location_to_display_notes(DataTable tabledata) throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        List<List<String>> Alerts=tabledata.asLists(String.class);
        orderpage.Select_AlertType_Location(Alerts.get(0).get(0),Alerts.get(0).get(1),Alerts.get(0).get(2));
    }

    @Then ("Click on Save button and Ok button")
    public void click_on_save_button_and_ok_button() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Save_Note_Button();
    }

    //Customer note, Copy button
    @And("Read all the Notes in Customer note grid and select one note")
    public void read_all_the_notes_in_customer_note_grid_and_select_one_note(DataTable tabledata) throws InterruptedException,  AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        List<List<String>> Cust_Note = tabledata.asLists(String.class);
        if(HelpersMethod.IsExists("//div[@class='customer-notes-header']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
        {
            orderpage.Select_Customer_Note(Cust_Note.get(0).get(0));
        }
    }

    //Click on Copy button in Customer note grid
    @And("Click on Copy button in Note grid")
    public void click_on_copy_button_in_note_grid() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Click_Copy_CustomerNote();
    }

    //Save button in Customer note popup
    @Then("Click on Save button")
    public void click_on_save_button() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Save_Note_Button();
    }
    @And("Read all the Notes in Customer note grid and select one note for Deleting")
    public void read_all_the_notes_in_customer_note_grid_and_select_one_note_for_deleting(DataTable tabledata) throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        List<List<String>> Cust_Note = tabledata.asLists(String.class);
        //Check for existence of customer note grid
        if(HelpersMethod.IsExists("//div[@class='customer-notes-header']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
        {
            orderpage.Select_Customer_Note_Del(Cust_Note.get(0).get(0));
        }
    }

    @Then("Click on Ok button")
    public void click_on_ok_button() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        orderpage.Ok_Note_Button();
    }

    @Then("Click on Reset button and Click on Ok button")
    public void click_on_reset_button_and_click_on_ok_button() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        orderpage.ReSet_Button();
        orderpage.Ok_Note_Button();
    }

    @Then("User verifies Order history page")
    public void userVerifiesOrderHistoryPage() throws InterruptedException, AWTException
    {
        exists=false;
        orderhistory=new OrderHistoryPage(driver,scenario);
        exists=orderhistory.VerifiyHistoryGrid();
    }

    @Then("Click on Add product drop down and select OrderGuide option")
    public void clickOnAddProductDropDownAndSelectOrderGuideOption(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> OGName = tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_On_Add_Product();
        newOE.SelectOGFromDropdown();
        newOE.validateOGPopup();
        newOE.OrderGuideGrid(OGName.get(0).get(0));
    }

    @Then("User verifies Order history page and add history Order to order select Order")
    public void userVerifiesOrderHistoryPageAndAddHistoryOrderToOrderSelectOrder() throws InterruptedException, AWTException
    {
        orderhistory=new OrderHistoryPage(driver,scenario);
        exists=orderhistory.VerifiyHistoryGrid();
        Assert.assertEquals(exists,true);
        orderhistory.FilterActiveOrder();
        //Click on first row in the order historhy page
        orderhistory.Click_On_OrderNumber();
    }
}
