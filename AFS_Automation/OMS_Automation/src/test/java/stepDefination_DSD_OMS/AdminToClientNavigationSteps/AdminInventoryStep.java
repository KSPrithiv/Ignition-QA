package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.inventory.InventoryPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminInventoryStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static String currentURL=null;
    static InventoryPage inventoryPage;
    static OrderEntryPage orderPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should click on Add product button and validate automatic load of products in product dialog box enabled")
    public void userShouldClickOnAddProductButtonAndValidateAutomaticLoadOfProductsInProductDialogBoxEnabled()
    {
        boolean exists;
        inventoryPage=new InventoryPage(driver,scenario);
        inventoryPage.clickOnAddProd();
        inventoryPage.validateCatalogPopup();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            scenario.log("CATALOG IN THE FORM OF LIST VIEW HAS BEEN FOUND");
            exists= inventoryPage.listViewProductLoaded();
        }
        else
        {
            scenario.log("CATALOG IN THE FORM OF CARD VIEW HAS BEEN FOUND");
            exists= inventoryPage.cardViewProductLoaded();
        }
        inventoryPage.clickOnResetFilter();
        inventoryPage.clickOnCatalogOkButton();
        Assert.assertEquals(exists,true);
    }

    @And("User should click on Add product button and validate automatic load of products in product dialog box disabled")
    public void userShouldClickOnAddProductButtonAndValidateAutomaticLoadOfProductsInProductDialogBoxDisabled()
    {
        boolean exists=false;
        inventoryPage=new InventoryPage(driver,scenario);
        inventoryPage.clickOnAddProd();
        inventoryPage.validateCatalogPopup();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            scenario.log("CATALOG IN THE FORM OF LIST VIEW HAS BEEN FOUND");
            exists= inventoryPage.listViewProductLoaded();
        }
        else
        {
            scenario.log("CATALOG IN THE FORM OF CARD VIEW HAS BEEN FOUND");
            exists= inventoryPage.cardViewProductLoaded();
        }
        inventoryPage.clickOnResetFilter();
        inventoryPage.clickOnCatalogOkButton();
        Assert.assertEquals(exists,false);
    }

    @Then("User should select Order Entry tab for Inventory for admin setting")
    public void userShouldSelectOrderEntryTabForInventoryForAdminSetting() throws InterruptedException, AWTException
    {
        orderPage = new OrderEntryPage(driver, scenario);
        orderPage.NavigateToOrderEntry();
    }

    @Then("User selects Account# for Inventory for admin setting")
    public void userSelectsAccountForInventoryForAdminSetting() throws InterruptedException, AWTException, ParseException
    {
        orderPage = new OrderEntryPage(driver, scenario);
        orderPage.ChangeAccount();
        orderPage.Read_DeliveryDate();
    }

    @And("User should navigate to Inventory tab for admin setting")
    public void userShouldNavigateToInventoryTabForAdminSetting()
    {
        if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", driver))
        {
            HelpersMethod.navigate_Horizantal_Tab(driver, "Inventory", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Inventory')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            inventoryPage = new InventoryPage(driver, scenario);
            boolean result = inventoryPage.ValidateInventory();
            currentURL = driver.getCurrentUrl();
            Assert.assertEquals(result, true);
        }
        else
        {
            scenario.log("CATALOG TAB IS NOT VISIBLE");
        }
    }
}
