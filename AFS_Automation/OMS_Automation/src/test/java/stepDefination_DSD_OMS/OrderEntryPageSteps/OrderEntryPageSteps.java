package stepDefination_DSD_OMS.OrderEntryPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.*;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderEntryPageSteps
{
    /* Created by Divya.Ramadas@afsi.com */
    private static boolean flag = false;
    private static boolean flag1=false;
    WebDriver driver;
    Scenario scenario;

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static OrderHistoryPage orderhistory;
    static CheckOutOrderPage checkorder;

    static boolean exists=false;
    static String Ord_No=null;
    //static String currentDate=null;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials")
    public void user_enters_url_and_is_on_login_page_and_entered_credentials() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page")
    public void user_is_on_home_page() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side")
    public void user_navigate_to_client_side() throws InterruptedException, AWTException
    {
        boolean result=false;
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab")
    public void user_should_select_order_entry_tab() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Then("User selects Account#")
    public void user_selects_account() throws InterruptedException, AWTException, ParseException
    {
        if(flag1==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.ChangeAccount();
            //orderpage.PopUps_After_AccountChange();
            //orderpage.Read_DeliveryDate();
            flag1=true;
        }
    }

    @Given("User must be on Order Entry Page")
    public void user_must_be_on_order_entry_page() throws InterruptedException, AWTException, ParseException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.HandleError_Page();
        orderpage.Refresh_Page2();
        orderpage.Read_DeliveryDate();
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Discard_All_Pending_Order();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NoPendingOrderPopup();
    }

    @Then("Change the date {int} days after current date")
    public void change_the_date_days_after_current_date(Integer int1) throws InterruptedException, AWTException, ParseException
    {
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        //create object of OE Page
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Read_DeliveryDate();
        orderpage.ClickCalender();
        orderpage.SelectDate(int1);
        orderpage.cancelOGselection();
        orderpage.ChangedDeliveryDate();
    }

    @Then("User must click Start Order button")
    public void user_must_click_start_order_button() throws InterruptedException, AWTException
    {
        exists=false;
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        //check for 'Start Order' button
        orderpage.Scroll_start();
        exists=orderpage.Start_Order();
    }

    @Then("User should make selection between Pending order or Start New order")
    public void user_should_make_selection_between_pending_order_or_start_new_order() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        //Handling Pending order popup
        orderpage.NoPendingOrderPopup();
    }

    @Then("User should make selection between Pending order or Start New order by selecting Pending Order option")
    public void userShouldMakeSelectionBetweenPendingOrderOrStartNewOrderBySelectingPendingOrderOption() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        //Handling Pending order popup by selecting continue with pending order
        orderpage.ContinuePendingOrderFromPopup();
    }

    @Then("User must again click Start Order button")
    public void userMustAgainClickStartOrderButton() throws InterruptedException, AWTException
    {
        exists=false;
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.ValidateOE();
        exists=orderpage.Start_OrderAgain();
        Assert.assertEquals(exists,true);
    }

    @Then("User should select Note from popup and Order guide from popup")
    public void userShouldSelectNoteFromPopupAndOrderGuideFromPopup() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        for(int i=0;i<=1;i++)
        {
            orderpage.OrderGuidePopup();
            Thread.sleep(1000);
            orderpage.NoNotePopHandling();
        }
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
    }

    @Then("User should select Note from popup and Order guide from popup for OG")
    public void userShouldSelectNoteFromPopupAndOrderGuideFromPopupForOG() throws InterruptedException, AWTException
    {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        for(int i=0;i<=1;i++)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.OrderGuidePopup();
            orderpage.NoNotePopHandling();
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
    }

    @Then("User should select Note from popup and Order guide from popup for quote")
    public void userShouldSelectNoteFromPopupAndOrderGuideFromPopupForQuote() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
       /* if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }*/
        for(int i=0;i<=1;i++)
        {
            orderpage.OrderGuidePopup();
            orderpage.NoNotePopHandling();
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
    }

    @Then("User should select Note from popup and select any OG from popup")
    public void user_should_select_note_from_popup_and_select_any_og_from_popup(DataTable tabledata) throws Throwable
    {
        List<List<String>> og_Name = tabledata.asLists(String.class);
        orderpage = new OrderEntryPage(driver, scenario);
        for(int i=0;i<=1;i++)
        {
            orderpage.NoNotePopHandling();
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            orderpage.selectOGPopup(og_Name.get(0).get(0));
        }
    }

    @Then("User should find select Order guide from popup")
    public void user_should_find_select_order_guide_from_popup() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.OrderGuidePopup();
    }

    @Then("User enters Product# in Search box")
    public void user_enters_product_in_search_box() throws Throwable
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        String ProdNo= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        newOE.EnterProdNo_InSearchBar(ProdNo);
    }

    @Then("Check for Catalog popup")
    public void check_for_catalog_popup() throws InterruptedException, AWTException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.CheckForCatalog();
    }

    @Then("Enter PO# for New order")
    public void enter_po_for_new_order(DataTable tabledata) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NO_NotePopup();
        newOE=new NewOrderEntryPage(driver,scenario);
        List<List<String>> PO_No = tabledata.asLists(String.class);
        newOE.EnterPO_No(PO_No.get(0).get(0));
    }

    @Then("Enter PO# for New order for Quote to Order")
    public void enter_po_for_new_order_for_quote_to_order(DataTable tabledata) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NO_NotePopup();
        newOE=new NewOrderEntryPage(driver,scenario);
        List<List<String>> PO_No = tabledata.asLists(String.class);
        newOE.EnterPO_No(PO_No.get(0).get(0));
        newOE.unavailableProduct();
    }

    //For entering Qty in catalog, based on catalog display. i.e. card catalog/list catalog
    @Then("Enter the Qty in the Product grid Case and Unit")
    public void enter_the_qty_in_the_product_grid_Case_and_Unit(DataTable tabledata) throws Throwable
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        List<List<String>> ProQty = tabledata.asLists(String.class);
        newOE.validateCatalogProducts();
        newOE.EnterQty(ProQty.get(0).get(0), ProQty.get(0).get(1));
    }

    @Then("Click on Next button")
    public void click_on_next_button() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        //handling toast messages
        for(int i=0;i<=2;i++)
        {
            //check for toast message for low on inventory
            newOE.lowOnInventoryToast();
            //check for toast message for product is currently unavailable
            newOE.toastCurrentlyUnavailable();
        }

        for(int i=0;i<=1;i++)
        {
            newOE.priceCannotBeBleowCost();
            newOE.exceedsMaxQty();
        }
        exists=newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            Thread.sleep(4000);
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']",driver))
            {
                checkorder.SelectPaymentMethod();
                scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
            }
            else
            {
                checkorder.Click_On_Without_Providing_Payment();
                scenario.log("WITHOUT PROVIIDNG PAYMENT OPTION HAS BEEN SELECTED");
            }
            checkorder.DeliveryAddressCard();
            checkorder.NextButton_Click();
        }
    }

    @Then("Click on Next after editing order All order")
    public void ClickOnNextAfterEditingOrderAllOrder() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        exists=newOE.ClickNext();
        Assert.assertEquals(exists,true);
        checkorder=new CheckOutOrderPage(driver,scenario);
        checkorder.Select_PaymentMethod_ClickDownArrow();
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            checkorder.Click_On_Without_Providing_Payment();
        }
        checkorder.DeliveryAddressCard();
        checkorder.NextButton_Click();
    }

    @Then("Click on SubmitOrder button")
    public void click_on_submit_order_button() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        summary.ClickSubmit();
        for(int i=0;i<=2;i++)
        {
            summary.additionalOrderPopup();
            summary.cutoffDialog();
            summary.percentageOfAverageProd();
        }
        summary.SucessPopup();
    }

    @Then("Click on Submit Order button and read Order_no")
    public void click_on_submit_order_button_and_read_order_no() throws InterruptedException, AWTException
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

    //To search crated order using Add filter, in OE page
    @Then("Click on Add filter button and search for order using search options")
    public void click_on_add_filter_button_and_search_for_order_using_search_options() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        exists=orderpage.Verify_OE_Title();
        HelpersMethod.AddFilterSearch(driver,"Order #",Ord_No);
    }

    @Then("User should be navigated to Order Entry page")
    public void user_should_be_navigated_to_order_entry_page() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Refresh_Page1();
        //orderpage.Verify_OEPage();
        orderpage.Verify_OE_Title();
    }

    @Then("Enter Pro# in Quick Product Entry area")
    public void enter_pro_in_quick_product_entry_area() throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.QuickProduct(DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd()));
    }

    @Then("Enter Pro# in Quick Product Entry area for price override")
    public void enter_pro_in_quick_product_entry_area_for_price_override() throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.priceOverrideQuickProduct(TestBase.testEnvironment.prodPriceRide());
    }

    @Then("Click on Cancel button")
    public void click_on_cancel_button() throws InterruptedException, AWTException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.OECancel();
    }

    @Then("Check for Warning popup")
    public void check_for_warning_popup() throws InterruptedException, AWTException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.CancelPop();
    }

    @Then("Check for Skip button is visible and Click on Skip button and select reason")
    public void check_for_skip_button_is_visible_and_Click_on_Skip_button(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> Reason = tabledata.asLists(String.class);
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        orderpage.SkipVisible_Click(Reason.get(0).get(0));
    }

     @Then("Check for visibility of Remove Skip button")
    public void check_for_visibility_of_remove_skip_button() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        boolean visible = orderpage.CheckForRemoveSkip();
        Assert.assertEquals(visible, true);
    }

    @Then("Check for Remove Skip button is visible and Click on Remove Skip button")
    public void check_for_remove_skip_button_is_visible_and_click_on_skip_button() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        orderpage.ClickRemoveSkip();
        orderpage.RemoveSkipOK();
        orderpage.ClickCalender();
        orderpage.ResetToCurrentDate();
    }

    @Then("Check for visibility of Skip button")
    public void check_for_visibility_of_skip_button() throws InterruptedException, AWTException
    {
        exists=false;
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        exists=orderpage.CheckForSkip();
        Assert.assertEquals(exists,true);
    }

    @Then("Check for Case and Unit input box enabled or not based on that enter value")
    public void check_for_case_and_unit_input_box_enabled_or_not_based_on_that_enter_value(DataTable tabledata) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        List<List<String>> PO_Qty = tabledata.asLists(String.class);
        String Case=PO_Qty.get(0).get(0);
        String Unit=PO_Qty.get(0).get(1);
        String uomString=newOE.VerifyUOM();
        if(uomString.equals("Units")||uomString.equals("EA"))
        {
            newOE.CheckForQuickUnitEnabled(Unit);
            if(uomString.equals("Units"))
            {
                WebElement caseIn = HelpersMethod.FindByElement(driver, "id", "quickCases");
                if (caseIn.equals(driver.switchTo().activeElement()))
                {
                    caseIn.sendKeys(Keys.TAB);
                }
            }
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        else if(uomString.equals("Cases")||uomString.equals("CS"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            if(uomString.equals("Cases"))
            {
                WebElement unitIn = HelpersMethod.FindByElement(driver, "id", "quickUnits");
                if (unitIn.equals(driver.switchTo().activeElement()))
                {
                    unitIn.sendKeys(Keys.TAB);
                }
            }
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        else if(uomString.equals("Cases, Units")||uomString.equals("Units, Cases")||uomString.equals("CS, EA")||uomString.equals("EA, CS"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            newOE.CheckForQuickUnitEnabled(Unit);
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        Thread.sleep(2000);
    }

    @Then("Click on Back button")
    public void click_on_back_button() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.Click_Back_But();
    }

    @Then("Click on Back button to handle Pending order Popup")
    public void clickOnBackButtonToHandlePendingOrderPopup() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_Back_Pending();
    }

    @Then("Popup message for Pending order should be displayed")
    public void popup_message_for_pending_order_should_be_displayed() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Create_Pending_Order_Popup();
    }

    @Then("Discard all Pending order should be displayed")
    public void discard_all_pending_order_should_be_displayed() throws InterruptedException, AWTException
    {   newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Discard_All_Pending_Order();
    }

    @Then("Click on Skip button in New order entry page and also select the reason")
    public void click_on_skip_button_in_new_order_entry_page_and_also_select_the_reason(DataTable tabledata) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        List<List<String>> Reason = tabledata.asLists(String.class);
        newOE.New_OE_Click_Skip_Button();
        newOE.New_OE_Validate_Skip_Button();
        newOE.New_OE_Select_SkipReason(Reason.get(0).get(0));
    }

    @Then("Click on History button")
    public void click_on_history_button() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        exists=orderpage.Verify_OE_Title();
        //Assert.assertEquals(exists,true);
        orderpage.Click_HistoryButton();
    }

    @Then("User verifies Order history page and add history Order to order")
    public void user_verifies_order_history_page() throws InterruptedException, AWTException
    {
        orderhistory=new OrderHistoryPage(driver,scenario);
        exists=orderhistory.VerifiyHistoryGrid();
        Assert.assertEquals(exists,true);
        orderhistory.FilterActiveOrder();
        //Click on first row in the order historhy page
        orderhistory.Click_On_RowIn_OrderHistoryGrid();
    }

    @Then("Enter order# in search box in Order History page")
    public void enter_order_in_search_box_in_order_history_page(DataTable tabledata) throws InterruptedException, AWTException
    {
        orderhistory=new OrderHistoryPage(driver,scenario);
        List<List<String>> Ord_num = tabledata.asLists(String.class);
        orderhistory.SearchBox_Entry(Ord_num.get(0).get(1));
    }

    @Then("Click on check box in the Order grid")
    public void click_on_check_box_in_the_order_grid() throws InterruptedException, AWTException
    {
        orderhistory=new OrderHistoryPage(driver,scenario);
        orderhistory.Check_Box();
    }

    @Then("Click on Copy button")
    public void click_on_copy_button() throws InterruptedException, AWTException
    {
        orderhistory=new OrderHistoryPage(driver,scenario);
        orderhistory.Copy_Button();
    }

    @Then("Enter Order# in Search box in Order Entry page")
    public void enter_order_in_search_box_in_order_entry_page() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Enter_OrderNo_Searchbox(Ord_No);
    }

    @Then("Click on Order number in Order Entry page")
    public void click_on_order_number_in_order_entry_page() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Select_Order_OrdersGrid();
    }

    @Then("Click on Order number in Order Entry page and check for New OE page")
    public void clickOnOrderNumberInOrderEntryPageAndCheckForNewOEPage() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Select_Order_OrdersGrid();
        //Check if user is on New OE page
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE1();
        if(exists==true)
        {
            exists=newOE.ClickNext();
            newOE.OutOfStockPop_ERP();
            checkorder=new CheckOutOrderPage(driver,scenario);
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
            {
                checkorder.Click_On_Without_Providing_Payment();
            }
            checkorder.DeliveryAddressCard();
            checkorder.NextButton_Click();
        }
    }

    @Then("Navigate to Summary order entry page")
    public void navigate_to_new_order_entry_page() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        summary.Click_Edit();
        
        //Check for Delivery address page
        if(HelpersMethod.IsExists("//div[@id='checkoutCard']",driver))
        {
            if(HelpersMethod.IsExistsById("CancelCheckoutButton",driver))
            {
                //Click on back button
                HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver,"id","CancelCheckoutButton"),1);
            }
        }
    }

    @Then("Enter new product# in the quick product entry with qty")
    public void enter_new_product_in_the_quick_product_entry_with_qty(DataTable table) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        List<List<String>> ProdDetails=table.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        String Prod=DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        newOE.QuickProduct(Prod);
        String uomValue=newOE.VerifyUOM();
        String Case=ProdDetails.get(0).get(0);
        String Unit=ProdDetails.get(0).get(1);
        if(uomValue.equals("Units"))
        {
            newOE.CheckForQuickUnitEnabled(Unit);
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        else if(uomValue.equals("Cases"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        else if(uomValue.equals("Cases, Units") || uomValue.equals("Units, Cases"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            newOE.CheckForQuickUnitEnabled(Unit);
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
    }

    @Then("User should Select delivery date from popup")
    public void user_shold_select_delivery_date_from_popup() throws InterruptedException, AWTException
    {
        orderhistory=new OrderHistoryPage(driver,scenario);
        orderhistory.selectDeliveryDate();
    }

    @Then("Select New order option from popup")
    public void select_new_order_option_from_popup() throws InterruptedException, AWTException
    {
        orderhistory=new OrderHistoryPage(driver,scenario);
        orderhistory.selectNewOrderPopup();
    }

    @Then("User should enter Units and Cases in product grid")
    public void user_should_enter_units_and_cases_in_product_grid(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> ProdDetails=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Enter_Qty_InGrid(ProdDetails.get(0).get(0),ProdDetails.get(0).get(1));
    }

    @When("User clicks on drop down next to Start order button")
    public void user_clicks_on_drop_down_next_to_start_order_button() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        orderpage.Scroll_start();
        orderpage.Click_DropDown();
    }

    @Then("Select Par Order from drop down options")
    public void select_par_order_from_drop_down_options() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Select_Par_Order();
        orderpage.ParOrderPopup();
        orderpage.ParOrderPopupOk();
    }

    //Code for Exporting order
    @Then("navigate to newOE page and Click on Export button")
    public void navigate_to_newoe_page_and_click_on_export_button() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        Ord_No=newOE.Export_button();
    }

    //Click on Edit button in Order summary page
    @And("Click on Edit button")
    public void click_on_edit_button() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        summary.Click_Edit();
    }

    @And("Click on Back button in Checkout Card page")
    public void click_on_back_button_in_checkout_card_page() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Click_on_BackButton();
    }

    //for imorting .csv file from local system. I am using same folder that has been exported
    @And ("Click on Import button")
    public void click_on_import_button() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Import_button(Ord_No);
        newOE.ValidateNewOE();
    }

    @Then("Add Qty for first product in product grid")
    public void add_qty_for_first_product_in_product_grid(DataTable tabledata) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        List<List<String>> ProdQty=tabledata.asLists(String.class);
        String Qty=ProdQty.get(0).get(0);
        newOE.QtyProdGrid(Qty);
    }

    @Then("User Should handle Pending order popup, and select continue with pending order button")
    public void userShouldHandlePendingOrderPopupAndSelectContinueWithPendingOrderButton() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ContinuePendingOrderFromPopup();
        orderpage.NO_NotePopup();
        orderpage.OrderGuidePopup();
    }

    @And("Click on Back to Orderlist button and read Order_no")
    public void clickOnBackToOrderlistButtonAndReadOrder_no() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.ClickSubmit();
        summary.Get_Order_No();
        //summary.BackToOrderList();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.ValidateOE();
    }

    @Given("User should close the browser")
    public void userShouldCloseTheBrowser()
    {
        driver.close();
    }

    @Then("Click on Next button in Payment page")
    public void clickOnNextButtonInPaymentPage() throws InterruptedException, AWTException
    {
        checkorder=new CheckOutOrderPage(driver,scenario);
        checkorder.VerifyCheckOut();
        checkorder.Select_PaymentMethod_ClickDownArrow();
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            checkorder.Click_On_Without_Providing_Payment();
        }
        checkorder.DeliveryAddressCard();
         checkorder.NextButton_Click();
    }

    @Then("Click on Order number in Order Entry page and check for New OE page for editing Order")
    public void clickOnOrderNumberInOrderEntryPageAndCheckForNewOEPageForEditingOrder() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Select_Order_OrdersGrid();
        //Check if user is on New OE page
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE1();
        Assert.assertEquals(exists,true);
    }

    @Then("Click on Next button after editing order")
    public void clickOnNextButtonAfterEditingOrder() throws InterruptedException, AWTException {
        exists = false;
        newOE = new NewOrderEntryPage(driver, scenario);
        newOE.readProductsInOrder();
        exists = newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver)) {
            checkorder = new CheckOutOrderPage(driver, scenario);
            checkorder.DeliveryAddressCard();
            if (HelpersMethod.IsExists("//div[@id='paymentMethodCard']", driver)) {
                checkorder.Select_PaymentMethod_ClickDownArrow();
                if (HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']", driver)) {
                    checkorder.SelectPaymentMethod();
                } else {
                    checkorder.Click_On_Without_Providing_Payment();
                }
            }
            checkorder.NextButton_Click();
        }
    }
    //verifying whether ordernumber is existing in OG or not
    @And("verify whether Order number is not existing in OG")
    public void verify_whether_order_number_is_not_existing_in_OG() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        orderpage.Enter_OrderNo_Searchbox(Ord_No);
        orderpage.Existence_OrderNo_OG();
    }

    @And("User should select Product from catalog and Enter Qty for the products in disconnected mode")
    public void userShouldSelectProductFromCatalogAndEnterQtyForTheProductsInDisconnectedMode(DataTable tabledata) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        String Prod_No= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Validate_Catalog();
        newOE.ResetFilter_CatalogDisconnectedMode();
        String pro=String.valueOf(Prod_No);
        newOE.validateCatalogProducts();
        newOE.Search_Prod_in_Catalog(pro);
        newOE.EnterQty(Prod_detail.get(0).get(0),Prod_detail.get(0).get(1));
        scenario.log("PRODUCT # "+pro+" PRODUCT QTY "+Prod_detail.get(0).get(0)+" "+Prod_detail.get(0).get(1));
    }

    @Then("Click on Next button and validate shipping address")
    public void clickOnNextButtonAndValidateShippingAddress() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        exists=newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            Thread.sleep(4000);
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']",driver))
            {
                checkorder.SelectPaymentMethod();
                scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
            }
            else
            {
                checkorder.Click_On_Without_Providing_Payment();
                scenario.log("WITHOUT PROVIIDNG PAYMENT OPTION HAS BEEN SELECTED");
            }
            checkorder.validateDefaultShippingAddress();
            checkorder.NextButton_Click();
        }
    }
}
