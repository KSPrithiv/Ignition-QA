package stepDefination_DSD_OMS.OrderEntryPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderEntry.*;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class OrderEntryPageSteps8
{
    /* Created by Divya.Ramadas@afsi.com */

    WebDriver driver;
    Scenario scenario;

    static boolean exists=false;
    //static OrderEntryPage orderEntryPage;
    static NewOrderEntryPage newOE;
    //static CheckOutSummaryPage summary;
    //static OrderHistoryPage orderHistoryPage;
    static OrderEntryPage orderpage;
    //static CheckOutOrderPage checkorder;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User searches for Brand and goes through the product numbers")
    public void userSearchesForBrandAndGoesThroughTheProductNumbers() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validateCatalogdialog();
        if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
        {
            newOE.listCatelog();
            newOE.readProductInList();
            newOE.catalogOK();
        }
        else if(HelpersMethod.IsExists("//div[@class='product-catalog-container']",driver))
        {
            newOE.cardCatelog();
            newOE.readProductInCard();
            newOE.catalogOK();
        }
    }

    @And("Select Pickup Order from drop down options and select last delivery date")
    public void selectPickupOrderFromDropDownOptionsAndSelectLastDeliveryDate() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        orderpage.Pickup_Order();
        orderpage.lastPickupOrder();
    }

    @Then("User should be navigated to Order Entry page and compare the dates")
    public void userShouldBeNavigatedToOrderEntryPageAndCompareTheDates() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.comparePickUpDates();
        orderpage.Refresh_Page1();
        //orderpage.Verify_OEPage();
        orderpage.Verify_OE_Title();
    }

    @And("Cancel popup should appear and verify button Cancel and Skip button for current date")
    public void cancelPopupShouldAppearAndVerifyButtonCancelAndSkipButtonForCurrentDate() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        //newOE.OECancel();
        newOE.VerifyCancelPopUp();
        newOE.CancelAndSkipPopupDisabled();
        newOE.CancelPop();
    }

    @And("User searches for QoH and goes through the product numbers")
    public void userSearchesForQoHAndGoesThroughTheProductNumbers(DataTable dataTable) throws InterruptedException, AWTException
    {
        List<List<String>> QoHValue = dataTable.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validateCatalogdialog();
        if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
        {
            newOE.listCatelogQoH(QoHValue.get(0).get(0));
            newOE.readProductInList();
            newOE.catalogOK();
        }
        else if(HelpersMethod.IsExists("//div[@class='product-catalog-container']",driver))
        {
            /*newOE.cardCatelog();
            newOE.readProductInCard();
            newOE.catalogOK();*/
            scenario.log("******************************THIS SCENARIO WORKS ONLY ON LIST VIEW****************************");
        }
    }

    @And("User should select Product from catalog Index popup search input box and Enter Qty for the products")
    public void userShouldSelectProductFromCatalogIndexPopupSearchInputBoxAndEnterQtyForTheProducts(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException, AWTException
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        String Prod_No= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Validate_Catalog();
        newOE.ResetFilter_Catalog();
        String pro=String.valueOf(Prod_No);
        newOE.validateCatalogProducts();
        newOE.Search_Prod_in_CatalogIndexDialogbox(pro);
        newOE.EnterQty(Prod_detail.get(0).get(0),Prod_detail.get(0).get(1));
        scenario.log("PRODUCT # "+pro+" PRODUCT QTY "+Prod_detail.get(0).get(0)+" "+Prod_detail.get(0).get(1));
    }
}
