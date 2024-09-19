package stepDefination_DSD_OMS.InventoryPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.inventory.InventoryPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.DataBaseConnection;
import util.TestBase;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */

public class InventoryPageSteps
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static boolean flag=false;
    static boolean flag1=false;
    static String currentURL;

    static LoginPage loginpage;
    static HomePage homepage;
    static InventoryPage inventory;
    static OrderEntryPage orderpage;

    @Before
    public void LaunchBrowser(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Inventory")
    public void userEntersUrlAndIsOnLoginPageAndEnteredCredentialsForInventory() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Inventory")
    public void userIsOnHomePageForInventory()
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for Inventory")
    public void userNavigateToClientSideForInventory()
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab for Inventory")
    public void userShouldSelectOrderEntryTabForInventory() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Then("User selects Account# for Inventory")
    public void userSelectsAccountForInventory() throws InterruptedException, AWTException, ParseException
    {
        if(flag1==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.ChangeAccount();
            //orderpage.PopUps_After_AccountChange();
            orderpage.Read_DeliveryDate();
        }
    }

    @Given("User must be on Order Entry Page to select Inventory tab")
    public void userMustBeOnOrderEntryPageToSelectInventoryTab() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        if(flag1==false)
        {
            orderpage.NavigateToOrderEntry();
        }
    }

    @And("User should navigate to Inventory tab")
    public void userShouldNavigateToInventoryTab() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            if (HelpersMethod.IsExists("//ul[@class='k-tabstrip-items k-reset']/li/span[@class='k-link' and text()='Inventory']", driver))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Inventory", "//ul[@class='k-tabstrip-items k-reset']/li/span[@class='k-link' and text()='Inventory']", "xpath", "//ul[@class='k-tabstrip-items k-reset']/li/span[@class='k-link']");
                inventory = new InventoryPage(driver, scenario);
                boolean result = inventory.ValidateInventory();
                currentURL = driver.getCurrentUrl();
                Assert.assertEquals(result, true);
            }
            else
            {
                scenario.log("INVENTORY TAB IS NOT VISIBLE");
            }
            flag1 = true;
        }
        orderpage = new OrderEntryPage(driver, scenario);
        exists= orderpage.HandleError_Page();
        orderpage.Refresh_Page(currentURL);
        inventory=new InventoryPage(driver,scenario);
        if(exists=true)
        {
            inventory.NavigateToInventory();
            inventory.navigateToStoreInventoryTab();
        }
        inventory.ValidateInventory();
    }

    @Then("User should Drag and drop any of the table header for grouping")
    public void userShouldDragAndDropAnyOfTheTableHeaderForGrouping(DataTable tabledata)
    {
        List<List<String>> drag=tabledata.asLists(String.class);
        inventory=new InventoryPage(driver,scenario);
        inventory.DragAndDropInInventory(drag.get(0).get(0));
        inventory.readGroupingValue();
    }

    @Then("User should be in Store inventory tab, in inventory page")
    public void userShouldBeInStoreInventoryTabInInventoryPage() throws SQLException
    {
        inventory=new InventoryPage(driver,scenario);
        inventory.navigateToStoreInventoryTab();
    }

    @And("User should click on Add product button and select products from Product popup and save")
    public void userShouldClickOnAddProductButtonAndSelectProductsFromProductPopupAndSave(DataTable tabledata) throws SQLException
    {
        List<List<String>> qtyValue=tabledata.asLists(String.class);
        inventory=new InventoryPage(driver,scenario);
        inventory.clickOnAddProd();
        inventory.validateCatalogPopup();
        inventory.loadProducts();
        inventory.selectShowAllProducts();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            scenario.log("CATALOG IN THE FORM OF LIST VIEW HAS BEEN FOUND");
            inventory.ListView(qtyValue);
        }
        else
        {
            List<String> Prods= DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
            for(int i=0;i<=Prods.size()-1;i++)
            {
                scenario.log("CATALOG IN THE FORM OF CARD VIEW HAS BEEN FOUND");
                inventory.cardView(qtyValue,Prods.get(i),i);
            }
        }
        inventory.clickOnCatalogOkButton();
        inventory.clickSaveButton();
        inventory.readProductsInInventory();
    }

    @Then("User should change store inventory dropdown value")
    public void userShouldChangeStoreInventoryDropdownValue()
    {
        InventoryPage inventory=new InventoryPage(driver,scenario);
        inventory.clickOnStoreInventory();
        inventory.selectStoreInventory();
    }

    @And("User enters product#, <Case>,<Unit>, <Sequence> in quick product entry")
    public void userEntersProductCaseUnitSequenceInQuickProductEntry() {
    }

    @And("User enters product#, {string}, {string}, {string} in quick product entry")
    public void userEntersProductInQuickProductEntry(String cases, String unit, String sequence)
    {
        InventoryPage inventory=new InventoryPage(driver,scenario);
        inventory.enterQuickProduct();
        inventory.enterQuickCases(cases);
        inventory.enterQuickUnit(unit);
        inventory.enterSequenceNo(sequence);
        inventory.readProductsInInventory();
    }

    @And("User should compare total units with Running total units")
    public void userShouldCompareTotalUnitsWithRunningTotalUnits(DataTable dataTable)
    {
        List<List<String>> tablehead=dataTable.asLists(String.class);
        InventoryPage inventory=new InventoryPage(driver,scenario);
        inventory.findTotalUnitsInColumn(tablehead.get(0).get(0));
        inventory.findRunningTotalUnits();
        inventory.compareTotalUnits();
    }

    @Then("User goes through products under inventory as the product added using quick entry has not been saved")
    public void userGoesThroughProductsUnderInventoryAsTheProductAddedUsingQuickEntryHasNotBeenSaved()
    {
        InventoryPage inventory=new InventoryPage(driver,scenario);
        inventory.readProductsInInventory();
    }

    @And("User cancel inventory details")
    public void userCancelInventoryDetails()
    {
        InventoryPage inventory=new InventoryPage(driver,scenario);
        inventory.clickOnCancel();
        inventory.handleCancelPopup();
        inventory.readProductsInInventory();
    }
}