package stepDefination_DSD_OMS.CatalogPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.Catalog.ProductDescriptionPage;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CatalogPageStep3
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    String descriptionProd=null;
    static boolean exists = false;
    Scenario scenario;

    static CatalogPage catalogpage;
    static NewOrderEntryPage newOE;
    static CheckOutOrderPage checkorder;
    static ProductDescriptionPage productDescriptionPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("User enters Tire pricing Product# in Search bar and verifying whether tire pricing dialog box appeared or not")
    public void userEntersTirePricingProductInSearchBarAndVerifyingWhetherTirePricingDialogBoxAppearedOrNot()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.SearchProduct(TestBase.testEnvironment.get_TirePricing());
        catalogpage.pointOnTirePriceLabel();
        catalogpage.validateTirePricingDialogBox();
    }

    @And("Now User should navigate to Catalog tab")
    public void nowUserShouldNavigateToCatalogTab()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.toCatalogTab();
        catalogpage.ValidateCatalog();
    }

    @Then("User click on cart in catalog and click on Gotocart and select pending order")
    public void user_click_on_cart_in_catalog_and_click_on_gotocart_and_select_pending_order() throws InterruptedException, AWTException
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Cart_Button();
        catalogpage.readProdFromShoppingCartDropDown();
        catalogpage.GotoCartClick();
        catalogpage.validateCartItemCard();
        catalogpage.Checkout_to_order();
        catalogpage.AddProductToPendingOrder();
    }

    @Then("User adds product to cart")
    public void userAddsProductToCart(DataTable tableData)
    {
        List<List<String>> Qty = tableData.asLists(String.class);
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.addProductToCart(Qty.get(0).get(0));
    }
}