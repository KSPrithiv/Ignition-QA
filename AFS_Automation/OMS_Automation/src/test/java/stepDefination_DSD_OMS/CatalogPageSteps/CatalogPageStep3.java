package stepDefination_DSD_OMS.CatalogPageSteps;

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
import pages_DSD_OMS.orderEntry.OrderEntryPage;
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
    Scenario scenario;

    static CatalogPage catalogpage;
    static OrderEntryPage orderEntryPage;
    static NewOrderEntryPage newOE;

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

    @And("User should navigate to Order Entry page from Catalog tab")
    public void userShouldNavigateToOrderEntryPageFromCatalogTab() throws InterruptedException, AWTException
    {
        orderEntryPage=new OrderEntryPage(driver,scenario);
        orderEntryPage.navigateToOrderEntry1();
        orderEntryPage.ValidateOE();
    }

    @And("User goes through products added to order via catalog")
    public void userGoesThroughProductsAddedToOrderViaCatalog() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
    }
}