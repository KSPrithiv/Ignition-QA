package stepDefination_DSD_OMS.OrderControlListSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import util.TestBase;

import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderControlPageSteps1
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

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

    @Then("User should find the customer to whom comment has to be added and click on Comment icon")
    public void userShouldFindTheCustomerToWhomCommentHasToBeAddedAndClickOnCommentIcon() throws InterruptedException, AWTException
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Validate_OCL();
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

    @Then("User should gothrough the column names displayed")
    public void userShouldGothroughTheColumnNamesDisplayed()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.readOrginalGridName();
        orderControlList.readAllHeadersOfGrid();
    }

    @And("User should change the grid and gothrough the column names displayed")
    public void userShouldChangeTheGridAndGothroughTheColumnNamesDisplayed()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.changeGridType();
        orderControlList.readAllHeadersOfGrid();
        orderControlList.resetGridTypeToOriginal();
    }

    @Then("User should search for call time column and check whether filter has been disabled")
    public void userShouldSearchForCallTimeColumnAndCheckWhetherFilterHasBeenDisabled()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.callTimeFilterDisabled();
    }

    @Then("User should search for call back time column and check whether filter has been disabled")
    public void userShouldSearchForCallBackTimeColumnAndCheckWhetherFilterHasBeenDisabled()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.callBackTimeFilterDisabled();
    }

    @Then("User enters multiple Route# in Route search input box and count number of rows in OCL grid")
    public void userEntersMultipleRouteInRouteSearchInputBoxAndCountNumberOfRowsInOCLGrid()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.enterMultipleRouteValue();
        orderControlList.readAllTheCustomer();
    }

    @And("User remove route from search bar")
    public void userRemoveRouteFromSearchBar()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.enterMultipleRouteValue();
        orderControlList.removeMutlipleRouteValue();
    }

    @Then("User should change Delivery date")
    public void userShouldChangeDeliveryDate() throws InterruptedException
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Validate_OCL();
        orderControlList.selectDeliveryDateRadioButton();
        orderControlList.Call_Date_Click();
        orderControlList.Call_Date_Selection(1);
        //orderControlList.validateRoutesValuesPresent();
    }
}