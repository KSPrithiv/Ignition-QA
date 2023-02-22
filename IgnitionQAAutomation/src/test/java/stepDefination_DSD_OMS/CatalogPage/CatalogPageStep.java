package stepDefination_DSD_OMS.CatalogPage;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.Catalog.ProductDescriptionPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CatalogPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static boolean exists = false;
    static boolean flag=false;
    static boolean flag1=false;
    static String currentURL=null;

    LoginPage loginpage;
    HomePage homepage;
    OrderEntryPage orderpage;
    CatalogPage catalogpage;
    NewOrderEntryPage newOE;
    CheckOutOrderPage checkorder;
    ProductDescriptionPage productdesctiptionpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Catalog")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForCatalog() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Catalog")
    public void user_is_on_home_pageForCatalog() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for Catalog")
    public void user_navigate_to_client_sideForCatalog() throws InterruptedException, AWTException
    {
        boolean result=false;
        if(flag==false)
        {
            //Thread.sleep(10000);
            homepage = new HomePage(driver,scenario);
            String title = driver.getTitle();
            Assert.assertEquals(title, "Ignition - Admin");
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab for Catalog")
    public void user_should_select_order_entry_tabForCatalog() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Then("User selects Account# for Catalog")
    public void user_selects_accountForCatalog() throws InterruptedException, AWTException, ParseException {
        if(flag1==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.ChangeAccount();
            //orderpage.PopUps_After_AccountChange();
            orderpage.Read_DeliveryDate();
        }
    }

    //Verify whether User is on OE page or not
    @Given("User must be on Order Entry Page to select Catalog")
    public void user_must_be_on_order_entry_page_to_select_catalog() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        if(flag1==false)
        {
            orderpage.NavigateToOrderEntry();
            flag1=true;
        }
        orderpage.HandleError_Page();
        orderpage.Refresh_Page(currentURL);
    }

    //Click on Catalog tab
    @And("User should navigate to Catalog tab")
    public void user_should_navigate_to_catalog_tab() throws InterruptedException, AWTException
    {
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", driver))
            {
                //Thread.sleep(10000);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Catalog", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                //Thread.sleep(25000);
                catalogpage = new CatalogPage(driver, scenario);
                boolean result = catalogpage.ValidateCatalog();
                Assert.assertEquals(result, true);

            }
            else
            {
                scenario.log("CATALOG TAB IS NOT VISIBLE");
            }
    }

    //Click on Resetfilter and validate the page, and click on List view
    @And("User should click on Reset filter button and all the products should displayed in List view in Catalog page")
    public void user_should_click_on_reset_filter_button_and_all_the_products_should_displayed_in_list_view_in_catalog_page()
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Click_ResetFilterButton();
        catalogpage.Click_ListView();
    }

    @And("User should click on Reset filter button and all the products should displayed")
    public void user_should_click_on_reset_filter_button_and_all_the_products_should_displayed()
    {
        try
        {
            catalogpage = new CatalogPage(driver, scenario);
            catalogpage.Click_ResetFilterButton();
        }
        catch (Exception e) {}
    }

    @Then("User enters Product# in Search bar")
    public void enter_product_in_search_bar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        catalogpage = new CatalogPage(driver, scenario);
        String pro = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        catalogpage.SearchProduct1(pro);
    }

    //Code for searching of product using product description
    @Then("User enters Product description in Search bar")
    public void enter_product_description_in_search_bar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
        catalogpage = new CatalogPage(driver, scenario);
        //Thread.sleep(20000);
        String pro = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.get_ProdDesc());
        //Thread.sleep(20000);
        catalogpage.SearchProduct1(pro);
    }

    //Enter the single product details
    @Then("User enters Product# in Search bar and enters Qty for single Product")
    public void user_enters_product_in_search_bar_and_enters_qty_for_single_product(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        catalogpage = new CatalogPage(driver, scenario);
        String pro = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        catalogpage.SearchProduct1(pro);
        exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
        if (exists == true)
        {
            HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]"),1);
           // HelpersMethod.Implicitwait(driver, 10);
        }
        else if (exists == false)
        {
            catalogpage.ProductExistsCard(Prod_detail.get(0).get(0));
        }
    }

    //Click on sort by best match drop down and select "Sort by price (ascending)" option
    //Sort the values in list catalog in ascending order
    @Then("Click on sort by best match and select ascending order and verify the same from Catalog page")
    public void click_on_sort_by_best_match_and_select_ascending_order_and_verify_the_same_from_catalog_page(DataTable tabledata)
    {
        List<List<String>> Best_Match = tabledata.asLists(String.class);
        catalogpage = new CatalogPage(driver, scenario);
        boolean result = catalogpage.Best_MatchDropDown(Best_Match.get(0).get(0));
        Assert.assertEquals(result, true);
    }

    //Code to click on Reset filter, and navigate to Card view
    @And("User should click on Reset filter button and all the products should displayed in Card view in Catalog page")
    public void user_should_click_on_reset_filter_button_and_all_the_products_should_displayed_in_card_view_in_catalog_page() throws InterruptedException
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Click_ResetFilterButton();
        //Thread.sleep(20000);
        catalogpage.Click_CardView();
    }

    //Code to Search for product
    @Then("User enters Product# in Search bar and enters Qty")
    public void user_enters_product_in_search_bar_and_enters_qty(DataTable tabledata) throws SQLException, InterruptedException
    {
        WebElement WebEle=null;
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
        catalogpage = new CatalogPage(driver, scenario);
        for(int i=0;i<=Prod_No.size()-1;i++)
        {
            //Thread.sleep(10000);
            catalogpage.SearchProduct(Prod_No.get(i));
            //Thread.sleep(10000);
            catalogpage.ProductExistsCard(Prod_detail.get(i).get(0));
            //Thread.sleep(10000);
        }
    }

    //code to click on cart and click on checkout to order
    @Then("User click on cart in catalog and click on Gotocart")
    public void user_click_on_cart_in_catalog_and_click_on_gotocart() throws InterruptedException, AWTException
    {
        catalogpage = new CatalogPage(driver, scenario);
        //HelpersMethod.Implicitwait(driver, 20);
        catalogpage.Cart_Button();
        //HelpersMethod.Implicitwait(driver, 20);
        catalogpage.GotoCartClick();
        //HelpersMethod.Implicitwait(driver, 20);
        catalogpage.Checkout_to_order();
        catalogpage.NewOrder_Option();
        //HelpersMethod.Implicitwait(driver, 20);
        checkorder = new CheckOutOrderPage(driver, scenario);
        if (checkorder.VerifyCheckOut())
        {
            checkorder.BackButton_Click();
        }
    }

    //Click on Delete Icon, that displays in card view. Delete button of 1st product that has been added will be clicked
    @Then("User enters Product# in Search bar and enter Qty and click on Delete button")
    public void user_enters_product_in_search_bar_and_enter_qty_and_click_on_delete_button(DataTable tabledata) throws SQLException, InterruptedException
    {
        WebElement WebEle=null;
        //HelpersMethod.Implicitwait(driver, 20);
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
        catalogpage = new CatalogPage(driver, scenario);
        for (int i = 0; i <= Prod_No.size() - 1; i++)
        {
           // Thread.sleep(1000);
            catalogpage.SearchProduct(Prod_No.get(i));
           // Thread.sleep(1000);
            exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
            if (exists == true)
            {
                WebEle=HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]");
                HelpersMethod.ClickBut(driver,WebEle,100);
                //HelpersMethod.Implicitwait(driver, 20);
            }
            else if (exists == false)
            {
               // Thread.sleep(1000);
                catalogpage.ProductExistsCard(Prod_detail.get(i).get(0));
               // Thread.sleep(1000);
                if (i == 1)
                {
                    WebEle=HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']/*[local-name()='path' and contains(@d,'M16 ')]");
                    HelpersMethod.ActClick(driver,WebEle, 100);
                    WebEle=HelpersMethod.FindByElement(driver, "id", "searchBarClearBtn");
                    HelpersMethod.ScrollElement(driver,WebEle);
                    HelpersMethod.ActClick(driver,WebEle,100);
                    scenario.log("PRODUCT "+Prod_No.get(i)+" HAS BEEN DELETED");
                }
            }
        }
    }

    //Delete product from Shopping cart popup
    @Then("User click on cart in catalog and click on Gotocart, before that Delete Product from popup")
    public void user_click_on_cart_in_catalog_and_click_on_gotocart_before_that_delete_product_from_popup() throws InterruptedException, AWTException
    {
        catalogpage = new CatalogPage(driver, scenario);
        //HelpersMethod.Implicitwait(driver, 10);
        catalogpage.Cart_Button();
        //HelpersMethod.Implicitwait(driver,10);
        catalogpage.DeleteProd_GotoCartClick();
        catalogpage.ClickGotoCart1();
        // HelpersMethod.Implicitwait(driver,10);
        catalogpage.Checkout_to_order();
        catalogpage.NewOrder_Option();
        //HelpersMethod.Implicitwait(driver, 10);
        checkorder = new CheckOutOrderPage(driver, scenario);
        if (checkorder.VerifyCheckOut())
        {
            checkorder.BackButton_Click();
        }
    }

    //Code for adding product to cart from catalog tab, Delete product from my cart page
    @Then("User click on cart in catalog and click on Gotocart, Delete product from Mycart page")
    public void user_click_on_cart_in_catalog_and_click_on_gotocart_delete_product_from_Mycart_page() throws InterruptedException, AWTException
    {
        catalogpage = new CatalogPage(driver, scenario);
        //HelpersMethod.Implicitwait(driver, 40);
        catalogpage.Cart_Button();
        //HelpersMethod.Implicitwait(driver, 40);
        catalogpage.GotoCartClick();
        catalogpage.DeleteMyCart();
        //Thread.sleep(20000);
        catalogpage.Checkout_to_order();
        //Thread.sleep(20000);
        catalogpage.NewOrder_Option();
        // HelpersMethod.Implicitwait(driver, 40);
        checkorder = new CheckOutOrderPage(driver, scenario);
        if (checkorder.VerifyCheckOut())
        {
            checkorder.BackButton_Click();
        }
    }

    //While creating order should select Order#
    @Then("User click on cart in catalog and click on Gotocart and select existing order")
    public void user_click_on_cart_in_catalog_and_click_on_gotocart_and_select_existing_order() throws InterruptedException, AWTException
    {
        catalogpage = new CatalogPage(driver, scenario);
        //HelpersMethod.Implicitwait(driver, 40);
        catalogpage.Cart_Button();
        //HelpersMethod.Implicitwait(driver, 40);
        catalogpage.GotoCartClick();
        catalogpage.Checkout_to_order();
        catalogpage.AddProductToOrder();
        //HelpersMethod.Implicitwait(driver, 40);
        checkorder = new CheckOutOrderPage(driver, scenario);
        if (checkorder.VerifyCheckOut())
        {
            checkorder.BackButton_Click();
        }
    }

    @And("User clicks on product image and enters Qty in Description page")
    public void user_clicks_on_product_image_and_enters_qty_in_description_page(DataTable tabledata) throws InterruptedException
    {
        List<List<String>> Qty = tabledata.asLists(String.class);
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.ClickImage();
        productdesctiptionpage = new ProductDescriptionPage(driver, scenario);
        //Thread.sleep(20000);
        if(HelpersMethod.IsExistsById("delete-from-cart-button",driver))
        {
            WebElement Del_But=HelpersMethod.FindByElement(driver,"id","delete-from-cart-button");
            HelpersMethod.ScrollElement(driver,Del_But);
            HelpersMethod.ClickBut(driver,Del_But,100);
            //Thread.sleep(20000);
            productdesctiptionpage.Qty_Inputbox(Qty.get(0).get(0));
            //Thread.sleep(20000);
            productdesctiptionpage.Add_to_cart();
            //Thread.sleep(10000);
            productdesctiptionpage.Increase_Descrease();
        }
        else
        {
            //Thread.sleep(20000);
            productdesctiptionpage.Qty_Inputbox(Qty.get(0).get(0));
            //Thread.sleep(20000);
            productdesctiptionpage.Add_to_cart();
            //Thread.sleep(10000);
            productdesctiptionpage.Increase_Descrease();
        }
    }

    //Enter Product# in search bar and click on product images
    @Then("User enters different Product# in Search bar and enter Qty by clicking image")
    public void user_enters_product_in_search_bar_and_enter_qty_by_clicking_image(DataTable tabledata) throws SQLException, InterruptedException
    {
        //HelpersMethod.Implicitwait(driver, 40);
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
        List<List<String>> Qty = tabledata.asLists(String.class);

        catalogpage = new CatalogPage(driver, scenario);
        for (int i = 0; i <= Prod_No.size() - 1; i++)
        {
            //HelpersMethod.Implicitwait(driver, 40);
            String pro = String.valueOf(Prod_No.get(i));
            //Thread.sleep(20000);
            catalogpage.SearchProduct1(pro);
            exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
            if (exists == true)
            {
                HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]"),10);
                //HelpersMethod.Implicitwait(driver, 40);
                scenario.log("PRODUCT DOESN'T EXISTS");
            }
            else if (exists == false)
            {
                catalogpage = new CatalogPage(driver, scenario);
                catalogpage.ClickImage();
                productdesctiptionpage = new ProductDescriptionPage(driver, scenario);
                if(HelpersMethod.IsExistsById("delete-from-cart-button",driver))
                {
                    WebElement Del_But = HelpersMethod.FindByElement(driver, "id", "delete-from-cart-button");
                    HelpersMethod.ScrollElement(driver, Del_But);
                    HelpersMethod.ClickBut(driver, Del_But, 100);
                    //Thread.sleep(20000);
                    productdesctiptionpage.Qty_Inputbox(Qty.get(0).get(0));
                    //Thread.sleep(20000);
                    productdesctiptionpage.Add_to_cart();
                    //Thread.sleep(10000);
                    productdesctiptionpage.Back_to_Catalog();
                }
                else
                {
                    //Thread.sleep(20000);
                    productdesctiptionpage.Qty_Inputbox(Qty.get(i).get(0));
                    //Thread.sleep(20000);
                    productdesctiptionpage.Add_to_cart();
                    //Thread.sleep(10000);
                    productdesctiptionpage.Back_to_Catalog();
                }
            }
        }
    }

    @Then("User enters different Product# in Search bar and enter Qty by clicking image and click Delete product")
    public void user_enters_different_product_in_search_bar_and_enter_qty_by_clicking_image_and_click_delete_product(DataTable tabledata) throws SQLException, InterruptedException
    {
        //HelpersMethod.Implicitwait(driver, 40);
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
        List<List<String>> Qty = tabledata.asLists(String.class);
        //Thread.sleep(20000);
        catalogpage = new CatalogPage(driver, scenario);
        for (int i = 0; i <= Prod_No.size() - 1; i++)
        {
            HelpersMethod.Implicitwait(driver, 40);
            String pro = String.valueOf(Prod_No.get(i));
            catalogpage.SearchProduct1(pro);
            exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
            if (exists == true)
            {
                HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]"),80);
                //HelpersMethod.Implicitwait(driver, 40);
            }
            else if (exists == false)
            {
                catalogpage = new CatalogPage(driver, scenario);
                catalogpage.ClickImage();
                productdesctiptionpage = new ProductDescriptionPage(driver, scenario);
                if(HelpersMethod.IsExists("//button[@id='delete-from-cart-button']",driver))
                {
                    WebElement Del_But = HelpersMethod.FindByElement(driver, "id", "delete-from-cart-button");
                    HelpersMethod.ScrollElement(driver, Del_But);
                    HelpersMethod.ClickBut(driver, Del_But, 40);
                    //Thread.sleep(20000);
                    productdesctiptionpage.Qty_Inputbox(Qty.get(i).get(0));
                    //Thread.sleep(20000);
                    productdesctiptionpage.Add_to_cart();
                    if (i == 0)
                    {
                       // Thread.sleep(20000);
                        productdesctiptionpage.Delete_Icon();
                    }
                    productdesctiptionpage.Back_to_Catalog();
                }
                else
                {
                    //Thread.sleep(20000);
                    productdesctiptionpage.Qty_Inputbox(Qty.get(i).get(0));
                    productdesctiptionpage.Add_to_cart();
                    //Thread.sleep(20000);
                    if (i == 0)
                    {
                       // Thread.sleep(20000);
                        productdesctiptionpage.Delete_Icon();
                        scenario.log("DELETED PRODUCT FROM PRODUCT DESCRIPTION PAGE");
                    }
                    productdesctiptionpage.Back_to_Catalog();
                }
            }
        }
    }


}
