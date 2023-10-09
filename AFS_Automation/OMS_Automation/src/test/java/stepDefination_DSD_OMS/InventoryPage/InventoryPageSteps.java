package stepDefination_DSD_OMS.InventoryPage;

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
    static String currentURL=null;

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
    public void userShouldNavigateToInventoryTab()
    {
        if(flag1==false)
        {
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", driver))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Catalog", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Inventory')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
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
        orderpage.HandleError_Page();
        orderpage.Refresh_Page(currentURL);
        inventory=new InventoryPage(driver,scenario);
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

    @Then("User should be in Store inventory tab, in inventroy page")
    public void userShouldBeInStoreInventoryTabInInventroyPage() throws SQLException
    {
        inventory=new InventoryPage(driver,scenario);
        inventory.navigateToStoreInventoryTab();
    }

    @And("User should click on Add product button and select products from Product popup")
    public void userShouldClickOnAddProductButtonAndSelectProductsFromProductPopup(DataTable tabledata) throws SQLException
    {
        List<List<String>> qtyValue=tabledata.asLists(String.class);
        inventory=new InventoryPage(driver,scenario);
        inventory.clickOnAddProd();
        inventory.validateCatalogPopup();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
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
    }

    @Then("User should change store inventroy dropdown value")
    public void userShouldChangeStoreInventroyDropdownValue()
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
    }
}
