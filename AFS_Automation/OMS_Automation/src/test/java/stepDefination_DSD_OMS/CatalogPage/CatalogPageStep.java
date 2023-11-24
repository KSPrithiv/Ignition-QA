package stepDefination_DSD_OMS.CatalogPage;

import gherkin.lexer.Ca;
import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.Catalog.ProductDescriptionPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Duration;
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
    static String Ord_No=null;

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;
    static CatalogPage catalogpage;
    static NewOrderEntryPage newOE;
    static CheckOutOrderPage checkorder;
    static ProductDescriptionPage productdesctiptionpage;
    static CheckOutSummaryPage summary;

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
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
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
    public void user_selects_accountForCatalog() throws InterruptedException, AWTException, ParseException
    {
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
        }
    }

    //Click on Catalog tab
    @And("User should navigate to Catalog tab")
    public void user_should_navigate_to_catalog_tab() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", driver))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Catalog", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                catalogpage = new CatalogPage(driver, scenario);
                catalogpage.ValidateCatalog();
                currentURL = driver.getCurrentUrl();
                scenario.log(currentURL);
            }
            else
            {
                scenario.log("CATALOG TAB IS NOT VISIBLE");
            }
            flag1 = true;
        }
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.HandleError_Page();
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Refresh_Page(currentURL);
        catalogpage.validateCatalog();
    }

    //Click on Resetfilter and validate the page, and click on List view
    @And("User should click on Reset filter button and all the products should displayed in List view in Catalog page")
    public void user_should_click_on_reset_filter_button_and_all_the_products_should_displayed_in_list_view_in_catalog_page()
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Click_ResetFilterButton();
        catalogpage.Click_ListView();
        catalogpage.validateListView();
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
        scenario.log("PRODUCT FOR SEARCH IN SEARCH BAR "+pro);
        catalogpage.SearchProduct1(pro);
    }

    //Code for searching of product using product description
    @Then("User enters Product description in Search bar")
    public void enter_product_description_in_search_bar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException
    {
        catalogpage = new CatalogPage(driver, scenario);
        String pro=TestBase.testEnvironment.getProdDesc();
        scenario.log("PRODUCT DESCRIPTION FOR SEARCH "+pro);
        catalogpage.SearchProduct1(pro);
    }

    //Enter the single product details
    @Then("User enters Product# in Search bar and enters Qty for single Product")
    public void user_enters_product_in_search_bar_and_enters_qty_for_single_product(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        catalogpage = new CatalogPage(driver, scenario);
        String pro = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        scenario.log("PRODUCT SEARCHED IS "+pro);
        //catalogpage.SearchProduct1(pro);
        catalogpage.SearchProduct(pro);
        exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
        if (exists == true)
        {
            HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]"),10000);
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
        catalogpage.Best_MatchDropDown(Best_Match.get(0).get(0));
        catalogpage.sortedValuesInCatalog();
    }

    //Code to click on Reset filter, and navigate to Card view
    @And("User should click on Reset filter button and all the products should displayed in Card view in Catalog page")
    public void user_should_click_on_reset_filter_button_and_all_the_products_should_displayed_in_card_view_in_catalog_page() throws InterruptedException
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Click_ResetFilterButton();
        catalogpage.Click_CardView();
        catalogpage.validateCardView();
    }

    //Code to Search for product
    @Then("User enters Product# in Search bar and enters Qty")
    public void user_enters_product_in_search_bar_and_enters_qty(DataTable tabledata) throws SQLException, InterruptedException
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql1());
        catalogpage = new CatalogPage(driver, scenario);
        for(int i=0;i<=Prod_No.size()-1;i++)
        {
            catalogpage.SearchProduct(Prod_No.get(i));
            catalogpage.ProductExistsCard(Prod_detail.get(i).get(0));
        }
    }

    //code to click on cart and click on checkout to order
    @Then("User click on cart in catalog and click on Gotocart")
    public void user_click_on_cart_in_catalog_and_click_on_gotocart() throws InterruptedException, AWTException
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Cart_Button();
        catalogpage.readProdFromShoppingCartDropDown();
        catalogpage.GotoCartClick();
        catalogpage.validateCartItemCard();
        catalogpage.Checkout_to_order();
        catalogpage.NewOrder_Option();
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
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql1());
        catalogpage = new CatalogPage(driver, scenario);
        for (int i = 0; i <= Prod_No.size() - 1; i++)
        {
            catalogpage.SearchProduct(Prod_No.get(i));
            if (HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]");
                HelpersMethod.ClickBut(driver,WebEle,1000000);
            }
            else if (exists == false)
            {
                catalogpage.ProductExistsCard(Prod_detail.get(i).get(0));
                if (i == 1)
                {
                    new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'update-cart-button')]/following-sibling::button//*[local-name()='svg']"))));
                    WebElement deleteButton=HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'update-cart-button')]/following-sibling::button//*[local-name()='svg']");
                    HelpersMethod.ActClick(driver,deleteButton, 1000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                    String status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    scenario.log("PRODUCT "+Prod_No.get(i)+" HAS BEEN DELETED");
                }
            }
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("productsCard"))));
        }
    }

    //Delete product from Shopping cart popup
    @Then("User click on cart in catalog and click on Gotocart, before that Delete Product from popup")
    public void user_click_on_cart_in_catalog_and_click_on_gotocart_before_that_delete_product_from_popup() throws InterruptedException, AWTException
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Cart_Button();
        scenario.log("PRODUCTS BEFORE DELETING FROM SHOPPING CART: ");
        catalogpage.readProdFromShoppingCartDropDown();
        catalogpage.DeleteProd_GotoCartClick();
        scenario.log("PRODUCTS AFTER DELETING FROM SHOPPING CART: ");
        catalogpage.readProdFromShoppingCartDropDown();
        catalogpage.ClickGotoCart1();
        catalogpage.validateCartItemCard();
        catalogpage.Checkout_to_order();
        catalogpage.NewOrder_Option();
        checkorder = new CheckOutOrderPage(driver, scenario);
        if (checkorder.VerifyCheckOut())
        {
            checkorder.VerifyCheckOut();
            checkorder.BackButton_Click();
        }
    }

    //Code for adding product to cart from catalog tab, Delete product from my cart page
    @Then("User click on cart in catalog and click on Gotocart, Delete product from Mycart page")
    public void user_click_on_cart_in_catalog_and_click_on_gotocart_delete_product_from_Mycart_page() throws InterruptedException, AWTException
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Cart_Button();
        catalogpage.readProdFromShoppingCartDropDown();
        catalogpage.GotoCartClick();
        catalogpage.validateCartItemCard();
        catalogpage.DeleteMyCart();
        catalogpage.Checkout_to_order();
        catalogpage.NewOrder_Option();
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
        catalogpage.Cart_Button();
        catalogpage.readProdFromShoppingCartDropDown();
        catalogpage.GotoCartClick();
        catalogpage.validateCartItemCard();
        catalogpage.Checkout_to_order();
        catalogpage.AddProductToOrder();
    }

    @And("User clicks on product image and enters Qty in Description page")
    public void user_clicks_on_product_image_and_enters_qty_in_description_page(DataTable tabledata) throws InterruptedException
    {
        List<List<String>> Qty = tabledata.asLists(String.class);
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.ClickImage();
        productdesctiptionpage = new ProductDescriptionPage(driver, scenario);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        if(HelpersMethod.IsExistsById("delete-from-cart-button",driver))
        {
            WebElement Del_But=HelpersMethod.FindByElement(driver,"id","delete-from-cart-button");
            HelpersMethod.ScrollElement(driver,Del_But);
            HelpersMethod.ClickBut(driver,Del_But,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            productdesctiptionpage.Qty_Inputbox(Qty.get(0).get(0));
            productdesctiptionpage.Add_to_cart();
            productdesctiptionpage.Increase_Descrease();
        }
        else
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            productdesctiptionpage.Qty_Inputbox(Qty.get(0).get(0));
            productdesctiptionpage.Add_to_cart();
            productdesctiptionpage.Increase_Descrease();
        }
    }

    //Enter Product# in search bar and click on product images
    @Then("User enters different Product# in Search bar and enter Qty by clicking image")
    public void user_enters_product_in_search_bar_and_enter_qty_by_clicking_image(DataTable tabledata) throws SQLException, InterruptedException
    {
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql1());
        List<List<String>> Qty = tabledata.asLists(String.class);

        catalogpage = new CatalogPage(driver, scenario);
        for (int i = 0; i <= Prod_No.size() - 1; i++)
        {
            String pro = String.valueOf(Prod_No.get(i));
            catalogpage.SearchProduct1(pro);
            exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
            if (exists == true)
            {
                HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]"),10);
                scenario.log("PRODUCT DOESN'T EXISTS");
            }
            else if (exists == false)
            {
                catalogpage = new CatalogPage(driver, scenario);
                catalogpage.ClickImage();
                productdesctiptionpage = new ProductDescriptionPage(driver, scenario);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'cart-container')]/ancestor::div[contains(@class,'price-cart-container')]");
                HelpersMethod.ScrollElement(driver,WebEle);
                if(HelpersMethod.IsExists("//button[contains(@id,'delete-from-cart-button')]",driver))
                {
                    WebElement Del_But = HelpersMethod.FindByElement(driver, "id", "delete-from-cart-button");
                    HelpersMethod.ScrollElement(driver, Del_But);
                    HelpersMethod.ClickBut(driver, Del_But, 2000);
                    productdesctiptionpage.Qty_Inputbox(Qty.get(0).get(0));
                    productdesctiptionpage.Add_to_cart();
                    productdesctiptionpage.Back_to_Catalog();
                }
                else
                {
                    productdesctiptionpage.Qty_Inputbox(Qty.get(i).get(0));
                    productdesctiptionpage.Add_to_cart();
                    productdesctiptionpage.Back_to_Catalog();
                }
            }
        }
    }

    @Then("User enters different Product# in Search bar and enter Qty by clicking image and click Delete product")
    public void user_enters_different_product_in_search_bar_and_enter_qty_by_clicking_image_and_click_delete_product(DataTable tabledata) throws SQLException, InterruptedException
    {
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql1());
        List<List<String>> Qty = tabledata.asLists(String.class);
        catalogpage = new CatalogPage(driver, scenario);
        for (int i = 0; i <= Prod_No.size() - 1; i++)
        {
            String pro = String.valueOf(Prod_No.get(i));
            catalogpage.SearchProduct1(pro);
            exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
            if (exists == true)
            {
                HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]"),80);
            }
            else if (exists == false)
            {
                catalogpage = new CatalogPage(driver, scenario);
                catalogpage.ClickImage();
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
                productdesctiptionpage = new ProductDescriptionPage(driver, scenario);
                if(HelpersMethod.IsExists("//button[@id='delete-from-cart-button']",driver))
                {
                    WebElement Del_But = HelpersMethod.FindByElement(driver, "id", "delete-from-cart-button");
                    HelpersMethod.ScrollElement(driver, Del_But);
                    HelpersMethod.ClickBut(driver, Del_But, 2000);
                    productdesctiptionpage.Qty_Inputbox(Qty.get(i).get(0));
                    productdesctiptionpage.Add_to_cart();
                    if (i == 0)
                    {
                        productdesctiptionpage.Delete_Icon();
                    }
                    productdesctiptionpage.Back_to_Catalog();
                }
                else
                {
                    productdesctiptionpage.Qty_Inputbox(Qty.get(i).get(0));
                    productdesctiptionpage.Add_to_cart();
                    if (i == 0)
                    {
                        productdesctiptionpage.Delete_Icon();
                        scenario.log("DELETED PRODUCT FROM PRODUCT DESCRIPTION PAGE");
                    }
                    productdesctiptionpage.Back_to_Catalog();
                }
            }
        }
    }

    @Then("Click on SubmitOrder button for creating order from Catalog")
    public void clickOnSubmitOrderButtonForCreatingOrderFromCatalog() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        summary.ClickSubmit();
        for(int i=0;i<=2;i++)
        {
            summary.cutoffDialog();
            summary.additionalOrderPopup();
        }
        Ord_No = summary.Get_Order_No();
        summary.SucessPopup();
    }

    @Given("User must be on Order Entry Page to create pending order")
    public void userMustBeOnOrderEntryPageToCreatePendingOrder(String currentURL) throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.HandleError_Page();
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Refresh_Page(currentURL);
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NavigateToOrderEntry();
    }

    @Then("User should be navigated to Order Entry page after creating order from catalog")
    public void userShouldBeNavigatedToOrderEntryPageAfterCreatingOrderFromCatalog() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Verify_OE_Title();
        //HelpersMethod.navigate_Horizantal_Tab(driver, "Catalog", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.navigateToCatalog();
        catalogpage.ValidateCatalog();
    }
}