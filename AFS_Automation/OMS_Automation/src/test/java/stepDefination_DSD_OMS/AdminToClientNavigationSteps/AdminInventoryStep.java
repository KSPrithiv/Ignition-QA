package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.inventory.InventoryPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
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
    static AdminHomePage adminHomePage;
    static OrderControlListPage orderControlListPage;
    static HomePage homepage;
    static LoginPage loginpage;
    static OrderEntryPage orderpage;
    static InventoryPage inventoryPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should click on Add product button and validate automatic load of products in product dialog box")
    public void userShouldClickOnAddProductButtonAndValidateAutomaticLoadOfProductsInProductDialogBox()
    {
        inventoryPage=new InventoryPage(driver,scenario);
        inventoryPage.clickOnAddProd();
        inventoryPage.validateCatalogPopup();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            scenario.log("CATALOG IN THE FORM OF LIST VIEW HAS BEEN FOUND");
            inventoryPage.listViewProductLoaded();
        }
        else
        {
            scenario.log("CATALOG IN THE FORM OF CARD VIEW HAS BEEN FOUND");
            inventoryPage.cardViewProductLoaded();
        }
        inventoryPage.clickOnCatalogOkButton();
    }
}
