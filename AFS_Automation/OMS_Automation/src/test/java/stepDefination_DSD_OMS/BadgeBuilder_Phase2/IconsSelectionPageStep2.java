package stepDefination_DSD_OMS.BadgeBuilder_Phase2;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.badgeBuilder_Phase1.BadgeBuilderPage;
import helper.HelpersMethod;
import pages_DSD_OMS.badgeBuilder_Phase2.BadgeBuilderPage1;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;

public class IconsSelectionPageStep2 {

    WebDriver driver;
    Scenario scenario;
    private String Color;
    private String Tcolor;
    //LoginPageBadge loginPageBadge;
    LoginPage loginpage;
    BadgeBuilderPage badgeBuilderPage;
    BadgeBuilderPage1 badgeBuilderPage1;
    static String currentURL = null;
    static boolean flag = false;
    static boolean flag1 = false;
    HomePage homepage;
    AdminHomePage adminHomePage;
    //String result=null;
    private String result1;
    private String result2;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();

    }

    @Then("Change Color of the Icon")
    public void change_color_of_the_icon() {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage1.ColourChange2();
        badgeBuilderPage1.AddToGallery();
    }

    @When("Login to Client portal1")
    public void login_to_client_portal1() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.DummyUserTest());
        loginpage.EnterPassword(TestBase.testEnvironment.DummyPassTest());
        //loginpage.ClickSignin();
        badgeBuilderPage.ClickSignin1();
        Thread.sleep(4000);
    }

//    @Given("User on login page and entered username and password1-Client portal")
//    public void user_on_login_page_and_entered_username_and_password1_client_portal()  throws InterruptedException, AWTException {
//        loginpage = new LoginPage(driver, scenario);
//        loginpage.EnterUsername(TestBase.testEnvironment.Dummyuser123());
//        loginpage.EnterPassword(TestBase.testEnvironment.Dummypass123());
//        loginpage.ClickSignin();
//    }

    @Then("Click on the Order Entry tab1")
    public void click_on_the_order_entry_tab1() {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage1.NavigateToOrderEntry1();
    }
    @And("Select Account2")
    public void select_account2() throws InterruptedException {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
//        badgeBuilderPage1.ChangeAccount2();
    }


    @Then("Select Account and start Order1")
    public void select_account_and_start_order1() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        //badgeBuilderPage.ChangeAccount1();
        //badgeBuilderPage.SelectDeliveryDate();
        //badgeBuilderPage.StartOrder();
        //badgeBuilderPage.NoPendingOrderPopup();
        //badgeBuilderPage.StartOrder();
        badgeBuilderPage.PopupOKBtn();
        badgeBuilderPage1.AddProduct_Catalog();
        badgeBuilderPage1.AddFromDropdown();
        badgeBuilderPage1.ProductNo_InSearchBar_Catalog();

    }
    @Then("Compare Product Icon color")
    public void compare_product_icon_color() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.CompareProdColour();
    }


    @Given("User should navigate to Catalog tab1")
    public void user_should_navigate_to_catalog_tab1() throws InterruptedException {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1.CatalogTab1();
        badgeBuilderPage.PopupDiscardAll();

    }


//
    @Given("Search for product")
    public void search_for_product() {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage1.SearchBoxActionCat1();
       badgeBuilderPage1.AddTocart();
    }

    @And("Click on Cart")
    public void click_on_cart() throws InterruptedException {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
//        badgeBuilderPage1.SearchBoxActionCat_2();
//        badgeBuilderPage1.Addcart2();
//        badgeBuilderPage1.ClickCart();


        badgeBuilderPage1.Click_On_UserIcon_Cart();
        badgeBuilderPage1.GoToCart();
        badgeBuilderPage1.imageIcon2();
    }

    @And("Verify Icon Color")
    public void verify_icon_color() throws InterruptedException {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage1.ColorCheck();
    }
    @And("Click new order and Enter PO")
    public void click_new_order_and_enter_po() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        //badgeBuilderPage.ChangeAccount1();
//       badgeBuilderPage.PopupDiscardAll();
//        badgeBuilderPage.RoutePopup();
        Thread.sleep(5000);
        badgeBuilderPage.StartOrder();
        Thread.sleep(5000);
        badgeBuilderPage.NoPendingOrderPopup();
        //badgeBuilderPage.StartOrder();
        badgeBuilderPage.PopupOKBtn();
        badgeBuilderPage1.POBox();
        badgeBuilderPage1.AddProduct();
        badgeBuilderPage1.SelectCatalogFromDropdown();
        badgeBuilderPage1.PopupProductEntry();
    }

    @Given("Compare Product Icon color1")
    public void compare_product_icon_color1() throws InterruptedException {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage1.ColorCheckCatalogSearch();
    }
    @And("Logout")
    public void logout() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.Click_On_UserIcon();
        badgeBuilderPage.Click_On_Signout();
    }

    @When("Click on Back")
    public void click_on_back() {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
//      driver.navigate().refresh();
        badgeBuilderPage1.Click_Back();
    }

    @Then("Select any date from Pickup Order")
    public void select_any_date_from_pickup_order() {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage1.Click_DropDown();
        badgeBuilderPage1.Select_PickupOrder1();
        badgeBuilderPage1.SelectDate1();

    }
    @Then("Add Product in Order Entry")
    public void add_product_in_order_entry() throws AWTException, InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        HelpersMethod.waitTillPageLoaded(driver, 2000);
        badgeBuilderPage.PopupOKBtn();
        badgeBuilderPage1.POBox1();
        //badgeBuilderPage.PopupOKBtn();
        badgeBuilderPage1.AddProduct();
        badgeBuilderPage1.SelectCatalogFromDropdown();
        badgeBuilderPage1.PopupProductEntry();
        badgeBuilderPage1.AddQuantity1();
        badgeBuilderPage1.SelectProduct1();
    }
    @And("Verify Icon Color from PickupOrder")
    public void verify_Icon_Color_from_PickupOrder() throws AWTException, InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1.ColorCheck1();
    }


    @Given("User should navigate to OrderControllist tab")
    public void user_should_navigate_to_order_controllist_tab() throws InterruptedException {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1.NavigateToOCL();
        badgeBuilderPage.PopupDiscardAll();


    }
    @And("Click new order and Enter PO1")
    public void click_new_order_and_enter_po1() throws InterruptedException, AWTException {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1.OrderControlAccountEntry();
        badgeBuilderPage1.ClickonNew();
        badgeBuilderPage.PopupOKBtn();
//        badgeBuilderPage.PopupOKBtn();
        badgeBuilderPage1.POBox();
        badgeBuilderPage1.AddProduct();
        badgeBuilderPage1.SelectCatalogFromDropdown();
        badgeBuilderPage1.PopupProductEntry();
        badgeBuilderPage1.AddQuantity1();

//        badgeBuilderPage1.StartOrder_OpenOrder1();
        badgeBuilderPage1.SelectProduct1();
    }
    @And("Compare Product Icon color2")
    public void compare_product_icon_color2() throws InterruptedException {
        badgeBuilderPage1 = new BadgeBuilderPage1(driver, scenario);
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1.ColorCheck();

    }

}


