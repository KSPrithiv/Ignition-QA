package stepDefination_DSD_OMS.CatalogPageSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.Catalog.ProductDescriptionPage;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CatalogPageStep1
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static CatalogPage catalogpage;
    static CheckOutOrderPage checkorder;
    static ProductDescriptionPage productdesctiptionpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    //Code for finding product# which are separated by comma
    @Then("User enters Product# in Search bar separated by comma and Read the product# available in catalog")
    public void user_enters_product_in_search_bar_separated_by_comma_and_read_the_product_available_in_catalog() throws SQLException
    {
        ArrayList<String> Prod_No= (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());

        catalogpage=new CatalogPage(driver,scenario);
        boolean result=catalogpage.EnterProdSeparatedByComma(Prod_No);
        Assert.assertEquals(result,true);
    }

    //Code to increase or decrease the Qty, in My cart page
    @Then("User click on cart in catalog and click on Gotocart, Press Plus and Minus buttons")
    public void user_click_on_cart_in_catalog_and_click_on_gotocart_press_plus_and_minus_button() throws InterruptedException, AWTException
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.Cart_Button();
        scenario.log("CART ICON HAS BEEN CLICKED");
        catalogpage.GotoCartClick();
        catalogpage.PlusMinus();
        catalogpage.Checkout_to_order();
        catalogpage.NewOrder_Option();
        checkorder=new CheckOutOrderPage(driver,scenario);
        if(checkorder.VerifyCheckOut())
        {
            checkorder.BackButton_Click();
        }
    }

    @Then("User should click on Category dropdown and select any of the category")
    public void user_should_click_on_category_dropdown_and_select_any_of_the_category()
    {
        String category=TestBase.testEnvironment.get_Category();
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.CatalogCategoryDropDown(category);
        catalogpage.ReadProduct();
        /*catalogpage.CatalogSubCategoryDropDown();
        catalogpage.ReadProduct();
        catalogpage.BrandDropDown();
        catalogpage.ReadProduct();*/
    }

    @Then("User should click on SubCategory dropdown and select any of the category")
    public void user_should_click_on_subcategory_dropdown_and_select_any_of_the_category()
    {
        String subCat=TestBase.testEnvironment.get_SubCategory();
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.CatalogSubCategoryDropDown(subCat);
    }

    @Then("User should click on Brand dropdown and select any of the category")
    public void user_should_click_on_brand_dropdown_and_select_any_of_the_category()
    {
        String brand=TestBase.testEnvironment.get_Brand();
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.BrandDropDown(brand);
    }

    @Then ("User should click on Order Guide dropdown and select any of the category")
    public void user_should_click_on_order_guide_dropdown_and_select_any_of_the_category() throws InterruptedException
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.OGDropDown();
    }

    @And("User should read all the products available catalog page")
    public void user_should_read_all_the_products_available_catalog_page()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.ReadProduct();
    }

    @Then("User reads all the products listed under featured products")
    public void user_reads_all_the_products_listed_under_featured_products()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.Click_ResetFilterButton();
        catalogpage.FeaturedReadProduct();
    }

    @Then("User reads all the products listed under recent search card")
    public void user_reads_all_the_products_listed_under_recent_search_card()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.RecentSearch();
    }

    @And("User clicks on Resetfilter to list all the products")
    public void user_clicks_on_resetfilter_to_list_all_the_products()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.Click_ResetFilterButton();
    }

    @Then("User clicks on product details to navigate to Description page")
    public void user_clicks_on_product_details_to_navigate_to_description_page()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.navigateToDescriptionPage();
    }

    @And("User lists all the product numbers which comes under Frequently bought together")
    public void user_lists_all_the_product_numbers_which_comes_under_frequently_bought_together()
    {
        productdesctiptionpage=new ProductDescriptionPage(driver,scenario);
        productdesctiptionpage.FrequentlyBought();
    }

    @Then("User reads all the products listed under Products you may like")
    public void userReadsAllTheProductsListedUnderProductsYouMayLike()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.ValidateCatalog();
        catalogpage.ValidateProductsYouMayLike();
    }

    @Then("User enters Product# in Search bar and enters Qty for increase and decrease Qty")
    public void userEntersProductInSearchBarAndEntersQtyForIncreaseAndDecreaseQty(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        String Prod_No = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());

        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.SearchProduct(Prod_No);
        catalogpage.ProductExistsCard(Prod_detail.get(0).get(0));
    }
}
