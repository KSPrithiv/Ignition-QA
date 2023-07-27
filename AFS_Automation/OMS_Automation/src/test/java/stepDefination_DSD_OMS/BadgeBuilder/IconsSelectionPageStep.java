package stepDefination_DSD_OMS.BadgeBuilder;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages_DSD_OMS.badgeBuilder_Phase1.BadgeBuilderPage;
import helper.HelpersMethod;

import pages_DSD_OMS.badgeBuilder_Phase2.BadgeBuilderPage1;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;


public class IconsSelectionPageStep {

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
        //driver.navigate().refresh();

//        WebDriverWait wait = new WebDriverWait(driver,20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInBtn")));
    }


    @Given("User enters URL and entered to login page")
    public void user_enters_url_and_entered_to_login_page() throws Exception {
        if (flag == false) {
            HelpersMethod.Implicitwait(driver, 40);
            loginpage = new LoginPage(driver, scenario);
            flag = true;
        }
        System.out.println("Application Login page loaded successfully");
    }


    @Given("User on login page and entered username and password")
    public void user_on_login_page_and_entered_username_and_password() throws Exception {

        loginpage = new LoginPage(driver, scenario);
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        //loginpage.ClickSignin();
        badgeBuilderPage.ClickSignin1();

    }

    @When("Navigated to Admin home page")
    public void navigated_to_admin_home_page() {

        homepage = new HomePage(driver, scenario);
        homepage.VerifyHomePage();
        // adminHomePage = new AdminHomePage(driver,scenario);
        //adminHomePage.SelectCompany();


    }

    @Then("Click on General Setting tab")
    public void click_on_general_setting_tab() throws InterruptedException {

        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);

        badgeBuilderPage.ClicOnHumburger1();

        badgeBuilderPage.ClicOnGeneralSetting();

    }


    @Then("Clicks on Badge Builder")
    public void clicks_on_badge_builder() throws InterruptedException {

        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ClickOnBadgeBuilder();

    }

    @Then("Select Icon under icon selections")
    public void select_icon_under_icon_selections() {

        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ClickOnBadgeBuilderIcon();
        badgeBuilderPage.BadgeBuilderPreviewDisplay();
    }


    @Given("User should be on BadgeBuilder page")
    public void user_should_be_on_badge_builder_page() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        //HelpersMethod.Refresh(driver);
        // badgeBuilderPage.Refresh_Page(currentURL);
        System.out.println("Badge Builder Page");
    }


    @When("Select Icon under icon selection")
    public void select_icon_under_icon_selection() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ClickOnBadgeBuilderIcon2();
    }


    @And("Edit Badge name under Badge Info")
    public void edit_badge_name_under_badge_info() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.EditTextBox();

    }

    @Then("Verify updated Badge name")
    public void verify_updated_badge_name() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.EditVerify();

    }

    @Then("Verify Badge Code field")
    public void verify_badge_code_field() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.BadgeCode();

    }


    @And("Change Badge name field under Badge Info")
    public void change_badge_name_field_under_badge_info() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.EditTextBox1();
    }


    @And("Change Icon Color")
    public void change_icon_color() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ColourChange();
    }


    @And("Clicks on Save and add to gallery button")
    public void clicks_on_save_and_add_to_gallery_button() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.AddToGallery();
    }


    @Then("Verify Saved Icon Changes")
    public void verify_saved_icon_changes() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.SavedChanges();
    }


    @Then("Change BadgeType and verify changes")
    public void change_badge_type_and_verify_changes() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.BadgeType();
    }


    @Given("User must be on BadgeBuilder page")
    public void user_must_be_on_badge_builder_page() {

        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        //HelpersMethod.Refresh(driver);

    }

    @When("User should navigate to Badge Gallery")
    public void user_should_navigate_to_badge_gallery() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.Scrolldown();


    }

    @And("Click on any Badge under Badge Gallery")
    public void click_on_any_badge_under_badge_gallery() {

        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ClickOnBadgeGallerBadge();

    }

    @Then("Verify delete button")
    public void verify_delete_button() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.Delete();
        //badgeBuilderPage.ScrollUP();

    }


    @When("Click on any Badge under Badge Gallery1")
    public void click_on_any_badge_under_badge_gallery1() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ClickOnBadgeGallerBadge1();
        badgeBuilderPage.Scrolldown1();


        //badgeBuilderPage.AddToGallery();


    }


    @When("Click on the Edit button")
    public void click_on_the_edit_button() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.EditBadgeGlry();


    }


    @When("Change Badge info, Icon color and Badge type")
    public void change_badge_info_icon_color_and_badge_type() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.EditBadgeInfo();
        badgeBuilderPage.ColourChangeBDType();
//        badgeBuilderPage.AddToGallery();
//        badgeBuilderPage.SavedChanges1();
    }

    @When("Clicks on the Save and add to gallery button")
    public void clicks_on_the_save_and_add_to_gallery_button() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.AddToGallery();

    }

    @Then("Verify Saved Icon Change")
    public void verify_saved_icon_change() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.SavedChanges1();
    }

    @When("Click Permission By and select appropriate Company")
    public void click_permission_by_and_select_appropriate_company() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.selectCompany();
    }

    @And("User should navigate to Badge Gallery - TieredPricingProduct")
    public void user_should_navigate_to_badge_gallery_tiered_pricing_product() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.Scrolldown();

        badgeBuilderPage.BGTiredPricing();
        //System.out.println();

        badgeBuilderPage.EditBadgeGlry();

//        String result2 = badgeBuilderPage.BGTiredPricing();
//        System.out.println(result2);


    }

    @And("Change Color of the TieredPricingProduct Icon")
    public void change_color_of_the_tiered_pricing_product_icon() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ColourChange2();

        badgeBuilderPage.AddToGallery();

    }

    @And("Logout from Admin portal")
    public void logout_from_admin_portal() throws InterruptedException, AWTException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.Click_On_UserIcon();
        badgeBuilderPage.Click_On_Signout();
    }

    @When("Login to Client portal")
    public void login_to_client_portal() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.DummyUserTest());
        loginpage.EnterPassword(TestBase.testEnvironment.DummyPassTest());
        //loginpage.ClickSignin();
        badgeBuilderPage.ClickSignin1();
//        Thread.sleep(4000);


    }

    @Then("User should navigate to Client side")
    public void user_should_navigate_to_client_side() throws InterruptedException {
//        boolean result=false;
//        if(flag==false)
//        {
//            Thread.sleep(10000);
//            homepage = new HomePage(driver,scenario);
//            String title = driver.getTitle();
//            Assert.assertEquals(title, "Ignition - Admin");
//            homepage.verifyUserinfoContainer();
//            homepage.navigateToClientSide();
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);

        badgeBuilderPage.ClicOnGeneralSetting();
//        Thread.sleep(10000);
        badgeBuilderPage.Clientside();
//        Thread.sleep(10000);

        badgeBuilderPage.selectCompany();

    }

    @And("Click on the Order Entry tab")
    public void click_on_the_order_entry_tab() throws InterruptedException {
        badgeBuilderPage1=new BadgeBuilderPage1(driver,scenario);
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
//        badgeBuilderPage.NavigateToOrderEntry();
        badgeBuilderPage1.NavigateToOrderEntry1();

    }

    @And("Select Account and start Order")
    public void select_account_and_start_order() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1=new BadgeBuilderPage1(driver,scenario);
        //badgeBuilderPage.ChangeAccount1();
        //badgeBuilderPage.Change_OldAccount();

        //badgeBuilderPage.PopupOKBtn();
        //badgeBuilderPage.StartOrder();
        Thread.sleep(2000);
        badgeBuilderPage.StartOrder();
        badgeBuilderPage.PopupOKBtn();
        badgeBuilderPage1.POBox();


        //badgeBuilderPage.SearchProd();
        badgeBuilderPage.SearchBoxAction();


    }

    @Then("Compare TieredPricingProduct Icon Color")
    public void compare_tiered_pricing_product_icon_color() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.CompareProdColour();


        //badgeBuilderPage.TieredPricing_ProductColor_Comparison();
//        badgeBuilderPage.Click_On_UserIcon();
//        badgeBuilderPage.Click_On_Signout();

    }

    @When("User should navigate to Badge Gallery - CatchWeightItems")
    public void user_should_navigate_to_badge_gallery_catch_weight_items() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.Scrolldown();

        badgeBuilderPage.BGCatchWeightItem();
        badgeBuilderPage.EditBadgeGlry();
    }

    @When("Change Color of the CatchWeightItems Icon")
    public void change_color_of_the_catch_weight_items_icon() {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ColourChange2();
        badgeBuilderPage.AddToGallery();
    }

    @And("Select Account and start Order - CatchWeightItems")
    public void select_account_and_start_order_catch_weight_items() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage1=new BadgeBuilderPage1(driver,scenario);
        //badgeBuilderPage.ChangeAccount1();
        badgeBuilderPage.StartOrder();
//        Thread.sleep(5000);
        badgeBuilderPage.NoPendingOrderPopup();
        //badgeBuilderPage.StartOrder();
        badgeBuilderPage.PopupOKBtn();
        badgeBuilderPage1.POBox();
        Thread.sleep(4000);
        //badgeBuilderPage.SearchProd();
        badgeBuilderPage.SearchBoxActionCatchWt();
    }

    @Then("Compare CatchWeightItems Icon Color")
    public void compare_catch_weight_items_icon_color() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        Thread.sleep(10000);
        badgeBuilderPage.CompareProdColour();
        Thread.sleep(3000);
//        badgeBuilderPage.CatalogTab();

    }

    @Then("user should navigate to Catalog tab")
    public void user_should_navigate_to_catalog_tab() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);

        badgeBuilderPage.CatalogTab();
        badgeBuilderPage.PopupDiscardAll();


//        {
//            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", driver))
//            {
//                //Thread.sleep(10000);
//                HelpersMethod.navigate_Horizantal_Tab(driver, "Catalog", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
//                //Thread.sleep(25000);
//
//
//            }
//            else
//            {
//                scenario.log("CATALOG TAB IS NOT VISIBLE");
//            }
//        }
//        Thread.sleep(2000);
//        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
//        //Thread.sleep(8000);
//        badgeBuilderPage.CatalogTab();
        ;
    }

    @Then("Search for Catchweight Item")
    public void search_for_catchweight_item() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        //Thread.sleep(8000);
        badgeBuilderPage.SearchBoxActionCat();


    }
    @Then("Compare Catlog CatchWeightItems Icon Color")
    public void compare_catlog_catch_weight_items_icon_color() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ProdColourCat();
        //badgeBuilderPage.ColorCheck();
        badgeBuilderPage.Click_On_UserIcon();
        badgeBuilderPage.Click_On_Signout();

    }


    @Then("User should navigate to Order Tab")
    public void user_should_navigate_to_order_tab() throws InterruptedException {
       Thread.sleep(8000);
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);

        {
            //if(flag1==false)

            WebElement WebEle;
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Orders')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                // exists = false;
                //orderGuidePage = new OrderGuidePage(driver, scenario);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                //exists = orderGuidePage.ValidateOG();
                //currentURL=driver.getCurrentUrl();
                //Assert.assertEquals(exists, true);

            }
            else
            {
                scenario.log("ORDER GUIDE TAB DOESN'T EXISTS");
            }
            //flag1=true;

        }




        //badgeBuilderPage.AddCatProdToGrid();
    }


    @Given("Add Product to the grid and check Icon Color")
    public void
    add_product_to_the_grid_and_check_Icon_Color() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        Thread.sleep(5000);
        badgeBuilderPage.AddCatProdToGrid();
        badgeBuilderPage.ProdColourCat2();
        Thread.sleep(6000);


    }

    @Then("User should navigate to OrderGuide Tab")
    public void user_should_navigate_to_order_guide_tab() throws InterruptedException {

            badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
            badgeBuilderPage.OrderGuideTab();

            badgeBuilderPage.PopupDiscardAll();
                //flag1=true;

        }


//    }

    @Then("Add Product to the Order Guide grid")
    public void add_product_to_the_order_guide_grid() throws AWTException, InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);

        //badgeBuilderPage.PopupDiscardAll();
//        Thread.sleep(5000);
        badgeBuilderPage.CreateNewOrder();
        //badgeBuilderPage.PopupOKBtn();

    }

    @Then("Check Icon color")
    public void check_icon_color() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.SelectProduct();
        badgeBuilderPage.OrderGuideColorCheck();
//        Thread.sleep(6000);
    }

    @Given("User should navigate to Open Orders Tab")
    public void user_should_navigate_to_open_orders_tab() throws InterruptedException {

        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.OpenOrderTab();

    }

    @Then("Start Order")
    public void start_order() throws InterruptedException, AWTException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        Thread.sleep(4000);
        badgeBuilderPage.StartOrderOpenOrder();
        badgeBuilderPage.AddFromDropdown();
       // badgeBuilderPage.EnterAccountNo_InSearchBar();
        badgeBuilderPage.SelectDeliveryDate();
        badgeBuilderPage.OpenOrderPopup();

        //badgeBuilderPage.NoPendingOrderPopup();

        badgeBuilderPage.StartOrder_OpenOrder();
    }
    @And("Compare Color of Product Icon")
    public void compare_color_of_product_icon() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.ProdColourCat2();
    }
    @Given("User should navigate to Standing Order Tab")
    public void user_should_navigate_to_standing_order_tab() throws InterruptedException {

        if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]", driver)) {

            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]");
            if (HelpersMethod.EleDisplay(WebEle)) {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Standing orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
            }
        }
        if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]", driver)) {
            WebElement WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]");
            if (HelpersMethod.EleDisplay(WebEle1)) {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Standing Orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
            }
        }

        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);

        badgeBuilderPage.PopupDiscardAll();

    }
    @Then("Click on New Standing order and select date")
    public void click_on_new_standing_order_and_select_date() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
       // badgeBuilderPage.ClickOnStartStandingOrder();
        badgeBuilderPage1=new BadgeBuilderPage1(driver,scenario);


        badgeBuilderPage.ClickOnNewStandingOrderArrow();
        badgeBuilderPage.ClickOnStartStandingOrder1();
        badgeBuilderPage.VerifyCalenderPopupStandingOrder();
        Thread.sleep(3000);
        //badgeBuilderPage.ClickOnAddProductButton();
        badgeBuilderPage.ClickOnAddProductButton1();
//        //Thread.sleep(3000);
//        badgeBuilderPage.ProductNo_InSearchBar();
        badgeBuilderPage1.PopupProductEntry();
        Thread.sleep(4000);
    }
    @And("Compare Color of Product Icon of Standing Order")
    public void compare_color_of_product_icon_of_standing_order() throws InterruptedException {
        badgeBuilderPage = new BadgeBuilderPage(driver, scenario);
        badgeBuilderPage.CompareProdColour();
    }

}