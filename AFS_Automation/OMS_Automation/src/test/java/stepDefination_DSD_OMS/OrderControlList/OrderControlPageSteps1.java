package stepDefination_DSD_OMS.OrderControlList;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderControlPageSteps1
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static OrderHistoryPage orderhistory;
    static CheckOutOrderPage checkorder;
    static OrderControlListPage orderControlList;

    static boolean exists=false;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User enters Route# in Route search input box and count number of rows in OCL grid")
    public void userEntersRouteInRouteSearchInputBoxAndCountNumberOfRowsInOCLGrid()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.enterRouteValue();
        orderControlList.readAllTheCustomer();
    }

    @Then("User should find the customer to whome comment has not been added and click on Comment icon")
    public void userShouldFindTheCustomerToWhomeCommentHasNotBeenAddedAndClickOnCommentIcon() throws InterruptedException, AWTException
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.selectCustomerAndClickCommentIcon();
    }

    @Then("the application should display all the account number in the grid in OCL")
    public void theApplicationShouldDisplayAllTheAccountNumberInTheGridInOCL()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.clickOnRefresh();
        orderControlList.readCustomerAccountsInOCL();
    }

    @And("User should click on comment icon in OCL and verify customer note")
    public void userShouldClickOnCommentIconInOCLAndVerifyCustomerNote()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.verifyCustomerNoteInOCL();
    }
}