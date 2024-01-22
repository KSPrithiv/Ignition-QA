package stepDefination_DSD_OMS.AllOrdersPageSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.allOrder.AllOrderPage;
import util.TestBase;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */

public class AllOrderPageStep1
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static AllOrderPage allOrders;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("User clicks on dropdown in All order for group level calculation for Qty,Total and select {string}")
    public void userClicksOnDropdownInAllOrderForGroupLevelCalculationForQtyTotalAndSelect(String opt)
    {
        allOrders=new AllOrderPage(driver,scenario);
        allOrders.clickOnQtyGrouping();
        allOrders.selectValueGroupDropDown(opt);
        allOrders.compareSelectedOpt(opt);
        allOrders.displayQtyGroupValue();
        allOrders.clickOnUnitGrouping();
        allOrders.selectValueGroupDropDown(opt);
        allOrders.compareSelectedOpt(opt);
        allOrders.displayTotalGroupValue();
    }

    @And("User validates the Sum amount in Qty and Total")
    public void userValidatesTheSumAmountInQtyAndTotal()
    {
        allOrders=new AllOrderPage(driver,scenario);
        allOrders.findSumOfQty();
        allOrders.findSumOfTotal();
    }

    @And("User validates the Avg amount in Qty and Total")
    public void userValidatesTheAvgAmountInQtyAndTotal()
    {
        allOrders=new AllOrderPage(driver,scenario);
        allOrders.findAvgOfQty();
        allOrders.findAvgOfTotal();
    }

    @And("User drag and drops {string} header")
    public void userDragAndDropsHeader(String header)////////////
    {
        allOrders=new AllOrderPage(driver,scenario);
        allOrders.dragAndDrop(header);
        allOrders.displayGroupingValue();
    }
}