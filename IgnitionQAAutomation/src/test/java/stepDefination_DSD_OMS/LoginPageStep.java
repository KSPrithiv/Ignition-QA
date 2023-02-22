package stepDefination_DSD_OMS;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import pages_DSD_OMS.login.*;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
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
public class LoginPageStep {
    /* Created by Divya.Ramadas@afsi.com */
    private static boolean flag = false;
    public static boolean exists = false;
    static String PageTitle = null;
    static String CurrentURL = null;

    WebDriver driver;
    public Scenario scenario;
    boolean result = false;

    LoginPage loginpage;
    HomePage homepage;
    ProductPage productPage;
    OrderEntryPage orderpage;
    MyCartPage myCartpage;
    UserRegistrationPage UserReg;
    CheckOutOrderPage checkOutOrder;

    @Before
    public void LaunchBrowser(Scenario scenario) throws Exception {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
        //Thread.sleep(5000);
    }

    @After
    public void afterScenario1(Scenario scenario) throws InterruptedException, AWTException
    {
        if (scenario.isFailed())
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", scenario.getName());
        }
    }

    @Given("User enters URL and is on login page")
    public void user_enters_url_and_is_on_login_page() throws Exception {
        if (!flag) {
            scenario.log("LOADED APPLICATION URL");
            //loginpage = new LoginPage(driver, scenario);
            //loginpage.GetURL();
            flag = true;
        }
    }

    @Given("User on login page")
    public void user_on_login_page() throws InterruptedException, AWTException
    {
        loginpage = new LoginPage(driver, scenario);
        result= loginpage.validateLoginPageTitle();
        if (!result)
        {
            homepage = new HomePage(driver, scenario);
            homepage.Click_On_UserIcon();
            homepage.Click_On_Signout();
        }
        loginpage.RefreshLogin();
    }

    @Then("User entered Invalid {string} and {string}")
    public void i_entered_invalid_and(String username, String password) throws InterruptedException, AWTException
    {
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(username);
        loginpage.EnterPassword(password);
        loginpage.ClickSignin();
        boolean ErrorMsg = loginpage.CheckErrorMessage();
        Assert.assertEquals(ErrorMsg, true);
        scenario.log("INVALID USERNAME AND PASSWORD HAS BEEN ENTERED");
    }

    @Then("User entered username and password")
    public void i_entered_username_and_password() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.DummyUser());
        loginpage.EnterPassword(TestBase.testEnvironment.DummyPassword());
        loginpage.ClickSignin();
        scenario.log("VALID USERNAME AND PASSWORD HAS BEEN ENTERED");
    }

    @Then("Click on Forgotten password button")
    public void click_on_forgotten_passowrd_button() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        loginpage.ForgottenPassword();
        scenario.log("FORGOTTEN PASSWORD FUNCTIONALITY HAS BEEN USED");
    }

    @Then("Admin Page is displayed")
    public void admin_page_is_displayed() throws InterruptedException, AWTException
    {
        homepage = new HomePage(driver, scenario);
        homepage.VerifyHomePage();
        homepage.verifyUserinfoContainer();
    }

    @Then("Navigate to Client side")
    public void navigate_to_client_side()
    {
        homepage = new HomePage(driver, scenario);
        homepage.navigateToClientSide();
    }

    //Code to check for warning popup, when user name and password is wrong
    @Then("Check for warning message")
    public void check_for_warning_message() throws InterruptedException {
        String message = HelpersMethod.ReadValue(driver.findElement(By.xpath("//div[contains(text(),'Either Username or Password is incorrect. Please try again.')]")));
        Assert.assertEquals(message, "Either Username or Password is incorrect. Please try again.");
    }

    //code to click on 'Send' button, when password is forgotten
    @Then("Enter username in input box and click on send button")
    public void enter_username_in_input_box_and_click_on_send_button(DataTable tabledata) throws InterruptedException, AWTException {
        //Enter user name in popup
        List<List<String>> username = tabledata.asLists(String.class);
        loginpage = new LoginPage(driver, scenario);
        loginpage.ForgottenPasswordFunctionality(username.get(0).get(0));
    }

    @Then("Verify popup message displayed")
    public void verify_popup_message_displayed() {
        loginpage.ConfirmPopup();
    }

    //For signing out from application
    @Then("Click on user Icon")
    public void click_on_user_icon() throws InterruptedException, AWTException {
        homepage = new HomePage(driver, scenario);
        homepage.Click_On_UserIcon();
    }

    @And("Click on Logout")
    public void click_on_logout() throws InterruptedException, AWTException {
        homepage = new HomePage(driver, scenario);
        homepage.Click_On_Signout();
    }

    //Click on External catalog
    @And("User clicks on View product catalog and Product catalog should be displayed")
    public void user_clicks_on_view_product_catalog_and_product_catalog_should_be_displayed() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        loginpage.ClickExternalCatalog();
    }

    //Code to add products to cart, when Card view is enabled
    @And("user should click on Reset filter button and all the products should displayed in card view")
    public void user_should_click_on_reset_filter_button_and_all_the_products_should_displayed_in_card_view() throws InterruptedException, AWTException {
        productPage = new ProductPage(driver, scenario);
        productPage.ValidateProductPage();
        productPage.Click_ResetFilter();
        productPage.ValidateProductPage();
        productPage.CardView();
    }

    //Enter product# in search bar, and enter qty if product exists. When Products are displayed in Card view
    @Then("User enters Product# in Search bar in Catalog popup and enter Qty card view")
    public void user_enters_product_in_search_bar_in_catalog_popup_and_enter_qty_card_view(DataTable dataTable) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<List<String>> Prod_detail = dataTable.asLists(String.class);
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
        productPage = new ProductPage(driver, scenario);
        for (int i = 0; i <= Prod_No.size() - 1; i++) {
            String pro = String.valueOf(Prod_No.get(i));
            productPage.SearchProduct(pro);
            productPage.ProductExistsCard(Prod_detail.get(i).get(0));
        }
    }

    //Code to click on cart and checkout to order
    @Then("User click on cart and click on Checkout to order")
    public void user_click_on_cart_and_click_on_checkout_to_order() throws InterruptedException, AWTException {
        productPage = new ProductPage(driver, scenario);
        productPage.Cart_Button();
        productPage.Checout_to_order();
    }

    @And("Login to Application and Select customer account from popup")
    public void login_to_application_and_select_customer_account_from_popup() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.password());
        loginpage.ClickSigninForExternalOrder();
        loginpage.ValidateCustomerIndexPopup();
        loginpage.CustomerIndexPopup();
    }

    //Add product to "Checkout" from "my cart" page
    @Then("User should navigate to My Cart and click on Chekout to order button")
    public void user_should_navigate_to_my_cart_and_click_on_chekout_to_order_button() throws InterruptedException, AWTException {
        myCartpage = new MyCartPage(driver, scenario);
        PageTitle = HelpersMethod.gettingTitle(driver);
        Assert.assertEquals(PageTitle, "Ignition - Order Cart");
        myCartpage.CheckOut_To_Order();
    }

    //Code to delete the product from "Items in cart" page
    @Then("User click on cart, Delete one product from cart and click on Checkout to order")
    public void user_click_on_cart_delete_one_product_from_cart_and_click_on_checkout_to_order() throws InterruptedException, AWTException {
        productPage = new ProductPage(driver, scenario);
        productPage.Cart_Button();
        productPage.Delete_Button();
        productPage.Checout_to_order();
    }

    @Then("User should navigate to My Cart, Delete one product and click on Chekout to order button")
    public void user_should_navigate_to_my_cart_delete_one_product_and_click_on_checkout_to_order_button() throws InterruptedException, AWTException {
        myCartpage = new MyCartPage(driver, scenario);
        PageTitle = HelpersMethod.gettingTitle(driver);
        Assert.assertEquals(PageTitle, "Ignition - Order Cart");
        myCartpage.DeleteButton();
        myCartpage.CheckOut_To_Order();
    }

    @And("user should be on New Order entry page")
    public void user_should_be_on_new_order_entry_page() throws InterruptedException, AWTException {
        orderpage = new OrderEntryPage(driver, scenario);
        // orderpage.NoPendingOrderPopup();
        orderpage.NoNotePopHandling();
        orderpage.OrderGuidePopup();
        if (HelpersMethod.IsExistsById("checkoutCard", driver)) {
            checkOutOrder = new CheckOutOrderPage(driver, scenario);
            checkOutOrder.BackButton_Click();
        }
    }

    @Then("User enters Product# in Search bar in Catalog popup and enter Qty and delete the first product added")
    public void user_enters_product_in_search_bar_in_catalog_popup_and_enter_qty_and_delete_the_first_product_added(DataTable tabledata) throws InterruptedException, AWTException, SQLException {
        WebElement WebEle = null;
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
        int j = 0;

        productPage = new ProductPage(driver, scenario);
        for (int i = 0; i <= Prod_No.size() - 1; i++) {

            String pro = String.valueOf(Prod_No.get(i));
            productPage.SearchProduct(pro);
            exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
            if (exists == true) {
                HelpersMethod.ClickBut(driver, HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]"), 1);

            } else if (exists == false) {
                j++;
                productPage.ProductExistsCardDelete(Prod_detail.get(i).get(0), j, String.valueOf(Prod_No.get(i)));
            }
            scenario.log("PRODUCT # " + Prod_No.get(i) + " PRODUCT QTY " + Prod_detail.get(i).get(0));
        }
    }

    @Then("User should enter client username and password")
    public void user_should_enter_client_username_and_password() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.password());
        loginpage.ClickSignin();
        HelpersMethod.waitTillPageLoaded(driver, 100);
    }

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        loginpage.ClickSignin();
    }

    @Then("Admin landing page should displayed")
    public void admin_landing_page_should_displayed() {
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        Assert.assertEquals("Ignition - Admin", driver.getTitle());
    }

    //Click on Register here link
    @And("Click on Register here link")
    public void click_on_register_here_link() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
        loginpage.RegisterHere();
    }

    //validate display of Registration popup
    @Then("Customer Registration page should get displayed")
    public void customer_registration_page_should_get_displayed() throws InterruptedException, AWTException {
        boolean Result = false;
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(text(),'Customer Registration')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 200);
        if (HelpersMethod.IsExists("//div[contains(text(),'Customer Registration')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
            Result = true;
        }
        Assert.assertEquals(true, Result);
    }

    //Enter Value to all the input box, when register with Customer Account# is selected
    @And("Enter values in input boxes")
    public void enter_values_in_input_boxes() throws InterruptedException, AWTException {
        UserReg = new UserRegistrationPage(driver, scenario);
        UserReg.EnterAccount_No();
        UserReg.EnterFirstName();
        UserReg.EnterLastName();
        UserReg.EnterUserName();
        UserReg.ActualEmail();
        UserReg.EnterConfirmEmail();
        UserReg.EnterPassword();
        UserReg.EnterConfirmPass();
    }

    //Enter click on Registration Button
    @Then("click on Register button")
    public void click_on_register_button() throws InterruptedException, AWTException {
        UserReg = new UserRegistrationPage(driver, scenario);
        UserReg.ClickOnRegistration();
    }

    //Code to verify after clicking register button it is leading to order entry page or not
    @And("Verify User is on Order Entry Page and logout")
    public void verify_user_is_on_order_entry_page() throws InterruptedException, AWTException {
        exists = false;
        orderpage = new OrderEntryPage(driver, scenario);
        exists = orderpage.Verify_OE_Title();
        Assert.assertEquals(exists, true);

        WebElement UserIcon = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='user-info-container']");
        HelpersMethod.clickOn(driver, UserIcon, 80);

        WebElement SignOut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'signout')]");
        HelpersMethod.ActClick(driver, SignOut, 80);
    }

    //Clicking on Cancel button, to cancel registration
    @Then("click on Cancel button")
    public void click_on_cancel_button() throws InterruptedException, AWTException {
        UserReg = new UserRegistrationPage(driver, scenario);
        UserReg.CancelRegistration();
    }

    //Code to add products to cart, when List view is enabled
    @And("user should click on Reset filter button and all the products should displayed in List view")
    public void user_should_click_on_reset_filter_button_and_all_the_products_should_displayed_in_list_view() throws InterruptedException, AWTException {
        productPage = new ProductPage(driver, scenario);
        productPage.Click_ResetFilter();
        productPage.ValidateProductPage();
        productPage.GridView();
    }

    //Enter Qty for products, when List view is selected
    @Then("User enters Product# in Search bar in Catalog popup and enter Qty List view")
    public void user_enters_product_in_search_bar_in_catalog_popup_and_enter_qty_list_view(DataTable tabledata) throws InterruptedException, AWTException, SQLException {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
        productPage = new ProductPage(driver, scenario);
        for (int i = 0; i <= Prod_No.size() - 1; i++) {
            String pro = String.valueOf(Prod_No.get(i));
            productPage.SearchProduct(pro);
            exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
            if (exists == true) {
                HelpersMethod.ClickBut(driver, HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]"), 80);
            } else if (exists == false) {
                String prod = Prod_detail.get(i).get(0);
                productPage.ProductExistsList(prod);
            }
        }
    }

    //Allowing users who are not having account also register
    @And("Click on Donot have account check box, Then Enter values in input boxes")
    public void click_on_donot_have_account_checkbox_then_enter_values_in_inputboxes() throws InterruptedException, AWTException {
        UserReg = new UserRegistrationPage(driver, scenario);
        UserReg.DoNotHaveAccount();
        UserReg.CustomerName();
        UserReg.Address1();
        UserReg.City();
        UserReg.State();
        UserReg.Zip();
        UserReg.Telephone();
        UserReg.EnterFirstName();
        UserReg.EnterLastName();
        UserReg.EnterUserName();
        UserReg.ActualEmail();
        UserReg.EnterConfirmEmail();
        UserReg.EnterPassword();
        UserReg.EnterConfirmPass();
    }

    @Then("Click on sort by best match and select ascending order and verify the same")
    public void click_on_sort_by_best_match_and_select_ascending_order_and_verify_the_same(DataTable tabledata) throws InterruptedException, AWTException {
        List<List<String>> BestMatch = tabledata.asLists(String.class);
        productPage = new ProductPage(driver, scenario);
        productPage.Sort_By_ascending_order(BestMatch.get(0).get(0));
        productPage.ReturnToLogin();
    }

    //Code for searchin of products separated by comma
    @Then("User enters multiple Product# in Search bar separated by comma and Read the product# available in catalog")
    public void user_enters_multiple_product_in_search_bar_separated_by_comma_and_read_the_product_available_in_catalog() throws SQLException, InterruptedException, AWTException {
        ArrayList<String> Prod_No = (ArrayList<String>) DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
        productPage = new ProductPage(driver, scenario);
        productPage.Click_ResetFilter();
        productPage.EnterProdSeparatedByComma(Prod_No);
        productPage.ReturnToLogin();
    }

    @Then("User Clicks on Category drop down and selects the 1st category")
    public void user_clicks_on_category_drop_down_and_selects_the_1st_category(DataTable tabledata) throws InterruptedException, AWTException {
        List<List<String>> categories = tabledata.asLists(String.class);
        productPage = new ProductPage(driver, scenario);
        productPage.Click_ResetFilter();
        productPage.CategoryDropDown(categories.get(0).get(0));
    }

    @And("user Should click on Reset Filer button and verifies that Category is set back to All category")
    public void user_should_click_on_reset_filter_button_and_verifies_that_category_is_set_back_to_all_cateogyr() throws InterruptedException, AWTException {
        productPage = new ProductPage(driver, scenario);
        productPage.Click_ResetFilter();
        //productPage.VerifyCategory();
        productPage.ReturnToLogin();
    }

    @And("User on Order Entry Page")
    public void userOnOrderEntryPage() throws InterruptedException, AWTException {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.HandleError_Page();
        orderpage.Refresh_Page1();
        //orderpage.Verify_OE_Title();
        //orderpage.Refresh_Page();
        // HelpersMethod.Implicitwait(driver, 40);
    }

    @Then("User changes language to some other language option and validates language")
    public void userChangesLanguageToSomeOtherLanguageOptionAndValidatesLanguage() throws InterruptedException {
        homepage = new HomePage(driver, scenario);
        homepage.Change_Language();
        scenario.log("LANGUAGE HAS BEEN CHANGED SUCCESSFULLY");
    }

    @And("User resetting language back to")
    public void userResettingLanguageBackTo(DataTable dataTable) {
        List<List<String>> Lang = dataTable.asLists(String.class);
        homepage = new HomePage(driver, scenario);
        homepage.Change_Language1(Lang.get(0).get(0));
        scenario.log("LANGUAGE HAS BEEN CHANGED SUCCESSFULLY");
    }

    @Then("Click on user Icon on Order Entry page")
    public void clickOnUserIconOnOrderEntryPage() throws InterruptedException, AWTException {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Click_On_UserIcon();
    }

    @And("Click on Logout on Order Entry page")
    public void clickOnLogoutOnOrderEntryPage() throws InterruptedException, AWTException {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Click_On_Signout();
    }

    @And("User closes the browser")
    public void userClosesTheBrowser() {
        CurrentURL = driver.getCurrentUrl();
        driver.close();
    }

    @Then("User launches browser")
    public void userLaunchesBrowser() throws SQLException, InterruptedException, ClassNotFoundException, AWTException, InstantiationException, IllegalAccessException {
        WebElement WebEle = null;
        driver.get(CurrentURL);
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
    }

    @And("User clicks on Remember me checkbox")
    public void userClicksOnRememberMeCheckbox() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        loginpage.RememberMe();
    }

    @Then("If user is navigated to OE page Logout from application")
    public void ifUserIsNavigatedToOEPageLogoutFromApplication() throws InterruptedException, AWTException {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        orderpage = new OrderEntryPage(driver, scenario);
        String title = HelpersMethod.gettingTitle(driver);
        if (!title.equals("Ignition - Login")) {
            orderpage.Click_On_UserIcon();
            orderpage.Click_On_Signout();
        }
    }

    @And("User should be navigated to Admin page")
    public void userShouldBeNavigatedToAdminPage() {
        homepage = new HomePage(driver, scenario);
        homepage.AdminPageUsingAdminCredentials();
    }

    @And("User click on Question mark and selects ecommerce option")
    public void userClickOnQuestionMarkAndSelectsEcommerceOption() throws InterruptedException, AWTException {
        orderpage = new OrderEntryPage(driver, scenario);
        driver.navigate().refresh();
        orderpage.selecteCommerceOption();
    }

    @And("User click on Question mark and selects Sales help option")
    public void userClickOnQuestionMarkAndSelectsSalesHelpOption() throws InterruptedException, AWTException {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.selectSaleshelp();
    }

    @Then("User entered username and password for sales help")
    public void userEnteredUsernameAndPasswordForSalesHelp() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.DummyUser());
        loginpage.EnterPassword(TestBase.testEnvironment.DummyPassword());
        loginpage.ClickSigninForSalesHelp();
        scenario.log("VALID USERNAME AND PASSWORD HAS BEEN ENTERED");
    }
}
