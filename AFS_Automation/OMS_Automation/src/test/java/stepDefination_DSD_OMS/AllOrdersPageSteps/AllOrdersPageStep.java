package stepDefination_DSD_OMS.AllOrdersPageSteps;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages_DSD_OMS.allOrder.AllOrderPage;
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
import java.time.Duration;
import java.util.List;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
public class AllOrdersPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static boolean exists = false;
    static String Ord_No=null;
    static String OrderNo=null;
    static boolean flag=false;
    static boolean flag1=false;
    static String CurrentULR=null;

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;
    static AllOrderPage allOrder;
    static CheckOutSummaryPage summary;
    static NewOrderEntryPage newOE;
    static CheckOutOrderPage checkOutOrderPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for All order")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForAllOrder() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for All order")
    public void user_is_on_home_pageForAllOrder() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for All order")
    public void user_navigate_to_client_sideForAllOrder() throws InterruptedException, AWTException
    {
        boolean result=false;
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            //homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab for All order")
    public void user_should_select_order_entry_tabForAllOrder() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Given("User must be on Order Entry Page to select All Orders")
    public void userMustBeOnOrderEntryPageToSelectAllOrders() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            try
            {
                exists = false;
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'All orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'All Orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Open orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Open Orders')]");
                if (HelpersMethod.EleDisplay(WebEle))
                {
                    String Menu_Text=null;
                    Actions act=new Actions(driver);
                    List<WebElement> MenuBar=HelpersMethod.FindByElements(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link']");
                    for(WebElement Menu:MenuBar)
                    {
                        act.moveToElement(Menu).build().perform();
                        Menu_Text=Menu.getText();
                        if(Menu_Text.contains("All Orders")||Menu_Text.contains("Open orders")||Menu_Text.contains("All orders")||Menu_Text.contains("Open Orders"))
                        {
                            WebElement menuItem=HelpersMethod.FindByElement(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'All orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'All Orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Open orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Open Orders')]");
                            HelpersMethod.JScriptClick(driver,menuItem,1000);
                            break;
                        }
                    }
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(150))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    String status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(150))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    CurrentULR= driver.getCurrentUrl();
                    scenario.log(CurrentULR);
                }
            }
            catch (Exception e) {}
            flag1=true;
        }
    }

    @And("User should navigate to All Orders")
    public void userShouldNavigateToAllOrders() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.HandleError_Page();
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.Refresh_Page(CurrentULR);
        allOrder.ValidateAllOrder();
    }

    @Then("User clicks on Show all orders check box")
    public void userClicksOnShowAllOrdersCheckBox()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ClickShowAllOrderCheckbox();
    }

    @And("User Clicks on Add filter button and enter values for search options")
    public void userClicksOnAddFilterButtonAndEnterValuesForSearchOptions()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.SubmittedStatusDropDown();
        allOrder.NotSubmitOptionFromDropDown();
        allOrder.AddFilterClick();
    }

    @Then("User clicks on Start order button and selects Add from drop down")
    public void userClicksOnStartOrderButtonAndSelectsAddFromDropDown() throws InterruptedException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ValidateAllOrder();
        allOrder.ClickOnStartOrder();
    }

    @Then("User selects customer account# and delivery date from popup")
    public void userSelectsCustomerAccountFromPopup() throws InterruptedException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ValidateCustomerIndexPopup();
        allOrder.CustomerIndexPopup();
        allOrder.validateDeliveryDatePopup();
        allOrder.SelectDeliveryDate();
        allOrder.WarningChangeDeliveryDate();
        allOrder.validateSelectOrder();
        allOrder.SelectOrder();
    }

    @And("Click on Submit Order button and read Order_no created for All order")
    public void clickOnSubmitOrderButtonAndReadOrder_noCreatedForAllOrder() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        summary.ClickSubmit();
        summary.additionalOrderPopup();
        for(int i=0;i<=2;i++)
        {
            summary.cutoffDialog();
            summary.percentageOfAverageProd();
        }
        Ord_No = summary.Get_Order_No();
        summary.SucessPopupForAllOrder();
        scenario.log("ORDER CREATED FOR ALL ORDER "+Ord_No);
    }

    @And("Click on Back to Orderlist button and read Order_no created for All order")
    public void clickOnBackToOrderlistButtonAndReadOrder_noCreatedForAllOrder() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        Ord_No=summary.Get_Order_No();
        summary.BackToOrderList();
        scenario.log("OPEN ORDER CREATED IS "+Ord_No);
    }

    @Then("User should be navigated back to All order page")
    public void userShouldBeNavigatedBackToAllOrderPage()
    {
        allOrder = new AllOrderPage(driver, scenario);
        allOrder.ValidateAllOrder();
    }

    @Then("User clicks on Show all Quotes check box")
    public void userClicksOnShowAllQuotesCheckBox()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ClickOnShowQuotes();
    }

    @And("User goes through all the order in Open order grid")
    public void userGoesThroughAllTheOrderInOpenOrderGrid()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.DisplayOrderNumbers();
    }

    @Then("USer should check for Comment icon")
    public void userShouldCheckForCommentIcon()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ValidateCommentIcon();
    }

    @And("User Clicks on Add filter button and Search for OrderNo")
    public void userClicksOnAddFilterButtonAndSearchForOrderNo()
    {
        allOrder=new AllOrderPage(driver,scenario);

        allOrder.ClickShowAllOrderCheckbox();
        allOrder.SearchNewlyCreatedOrder(Ord_No);
    }

    @Then("User clicks on Show all orders check box after Clicking All orders tab")
    public void userClicksOnShowAllOrdersCheckBoxAfterClickingAllOrdersTab()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ValidateAllOrder();
        allOrder.ClickShowAllOrderCheckbox();
    }

    @And("then user clicks on All Order button in summary page and read order#")
    public void thenUserClicksOnAllOrderButtonInSummaryPageAndReadOrder() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        Ord_No=summary.Get_Order_No();
        summary.ClickOnAllOrder();
        summary.SucessPopup();
    }

    @Then("User Clicks on the order# in All order grid")
    public void userClicksOnTheOrderInAllOrderGrid()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ClickOnOrderInAllOrderGrid();
    }

    @And("User clicks on Show all orders check box again")
    public void userClicksOnShowAllOrdersCheckBoxAgain()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ClickShowAllOrderCheckbox();
        allOrder.SearchNewlyCreatedOrder(Ord_No);
    }

    @Then("User clicks on OrderNo in All Order grid and User should be navigated Ordersummary page")
    public void userClicksOnOrderNoInAllOrderGridAndUserShouldBeNavigatedOrdersummaryPage() throws InterruptedException, AWTException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ClickOnOrderInAllOrderGrid();
        allOrder.NavigateToOrderSummaryPage();
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.clickOnAllOrder();
    }

    @Then("User clicks on Back to Order list button and should be navigated to OE page")
    public void userClicksOnBackToOrderListButtonAndShouldBeNavigatedToOEPage()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ClickOnBackToOrder();
    }

    @And("User enters orderNo That he has selected from order grid and validates it exists in order also")
    public void userEntersOrderNoThatHeHasSelectedFromOrderGridAndValidatesItExistsInOrderAlso() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.ValidateOE();
        orderpage.Enter_OrderNo_Searchbox(OrderNo);
        orderpage.Existence_OrderNo_OG1();
        allOrder=new AllOrderPage(driver,scenario);
        try
        {
            exists = false;
            Actions act = new Actions(driver);
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'All Orders')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "All Orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'All Orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button[contains(text(),'Start order')]"), "Start order"));

                if (HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                    act.moveToElement(WebEle).build().perform();
                    act.click(WebEle).build().perform();
                }
                allOrder = new AllOrderPage(driver, scenario);
                allOrder.ValidateAllOrder();
            }
        }
        catch (Exception e) {}
    }

    @Then("User select the order and click on copy button and select delivery date")
    public void userSelectTheOrderAndClickOnCopyButtonAndSelectDeliveryDate() throws InterruptedException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ValidateAllOrder();
        allOrder.SelectOrderForCopying(Ord_No);
        allOrder.ClickOnCopyButton();
        allOrder.validateSelectDeliveryDateForCopy();
        allOrder.SelectDeliverDateForCopy();
        allOrder.SelectNewOrderInPopUp();
    }

    @And("User clicks on Submitted status and select Submitted option from drop down")
    public void userClicksOnSubmittedStatusAndSelectSubmittedOptionFromDropDown()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.SubmittedStatusDropDown();
        allOrder.SubmitOptionFromDropDown();
    }

    @And("User clicks on search button")
    public void userClicksOnSearchButton()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ClickOnSearchButton();
    }

    @And("User clicks on Order status and select Open order option from drop down")
    public void userClicksOnOrderStatusAndSelectOpenOrderOptionFromDropDown() throws InterruptedException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.OrderStatusDropDown();
        allOrder.OrderOptionFromDropDown();
        allOrder.ClickOnSearchButton();
    }

    @And("User enters product# in input box")
    public void userEntersProductInInputBox()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.SearchProductInOrder();
        allOrder.ClickOnSearchButton();
    }

    @Then("User select the order and click on Print button")
    public void userSelectTheOrderAndClickOnPrintButton() throws InterruptedException, AWTException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.selectOrderForPrint();
        allOrder.PrintAllOrder();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.Refresh_Page(CurrentULR);
    }

    @Then("User clicks on any of the order and verifies products")
    public void userClicksOnAnyOfTheOrderAndVerifiesProducts()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.AddFilterClick();
        allOrder.ClickOnOrderInAllOrderGrid();
        allOrder.NavigateToOrderSummaryPage();
        allOrder.VerifyingProductsInOEWithOO();
    }

    @Then("Navigate to Summary order entry page and user clicks on Edit button")
    public void navigateToSummaryOrderEntryPageAndUserClicksOnEditButton() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        summary.Click_Edit();
    }

    @And("If user navigates to payment and address page click on Back button or else add product# in Quick product entry for editng all order")
    public void ifUserNavigatesToPaymentAndAddressPageClickOnBackButtonOrElseAddProductInQuickProductEntryForEditngAllOrder(DataTable tabledata) throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        List<List<String>> Qty=tabledata.asLists(String.class);
        checkOutOrderPage=new CheckOutOrderPage(driver,scenario);
        boolean result=checkOutOrderPage.VerifyCheckOut();
        if(result==true)
        {
            checkOutOrderPage.BackButton_Click();
        }
        newOE=new NewOrderEntryPage(driver,scenario);
        String Prod= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        newOE.ValidateNewOE1();
        newOE.QuickProduct(Prod);
        String Case=Qty.get(0).get(0);
        String Unit=Qty.get(0).get(1);
        String uomString=newOE.VerifyUOM();
        if(uomString.equals("Units"))
        {
            newOE.CheckForQuickUnitEnabled(Unit);
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        else if(uomString.equals("Cases"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
        else if(uomString.equals("Cases, Units")||uomString.equals("Units, Cases"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            newOE.CheckForQuickUnitEnabled(Unit);
            newOE.exceedsMaxQty();
            newOE.toastCurrentlyUnavailable();
        }
    }

    @Then("User clicks on Start order button and selects Pick up order from drop down")
    public void userClicksOnStartOrderButtonAndSelectsPickUpOrderFromDropDown() throws InterruptedException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ValidateAllOrder();
        allOrder.ClickOnStartOrderToSelectPickupOrder();
    }

    @And("User clicks on Order status and select Active order option from drop down")
    public void userClicksOnOrderStatusAndSelectActiveOrderOptionFromDropDown() throws InterruptedException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.OrderStatusDropDown();
        allOrder.ActiveOrderOptionFromDropDown();
    }

    @Then("User selects customer account# and delivery date for pickup order")
    public void userSelectsCustomerAccountAndDeliveryDateForPickupOrder() throws InterruptedException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ValidateCustomerIndexPopup();
        allOrder.CustomerIndexPopup();
        allOrder.validateSelectDeliveryDatePickupOrder();
        allOrder.selectDeliveryDateForPickupOrder();
        allOrder.validateSelectOrder();
        allOrder.SelectNewOrderInPopUp();
    }

    @Then("User selects customer account# and delivery date from popup to edit all order")
    public void userSelectsCustomerAccountAndDeliveryDateFromPopupToEditAllOrder() throws InterruptedException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ValidateCustomerIndexPopup();
        allOrder.CustomerIndexPopup();
        allOrder.validateDeliveryDatePopup();
        allOrder.SelectDeliveryDate();
        //allOrder.SelectDeliveryDateForEdit();
        allOrder.WarningChangeDeliveryDate();
        allOrder.validateSelectOrder();
        allOrder.SelectOrder();
    }

    @And("User should drag and drop {string} then verify grouping with number of elements in each group")
    public void userShouldDragAndDropThenVerifyGroupingWithNumberOfElementsInEachGroup(String TableHead)
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.FindtableHeader(TableHead);
        allOrder.DisplayGroupDetails();
    }

    @Then("USer clicks on Comment icon and comments popup gets displayed")
    public void userClicksOnCommentIconAndCommentsPopupGetsDisplayed()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ValidateCommentIcon();
        allOrder.ClickOnCommentIcon();
        allOrder.ValidateDisplayOfCommentsDialog();
        allOrder.DisplayCommentsAdded();
    }

    @Then("Enter PO# for New order for All orders")
    public void enterPOForNewOrderForAllOrders(DataTable tabledata) throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        for(int i=0;i<=1;i++)
        {
            orderpage.OrderGuidePopup();
            orderpage.NoNotePopHandling();
        }
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOEAllOrder();

        List<List<String>> PO_No = tabledata.asLists(String.class);
        newOE.EnterPO_No(PO_No.get(0).get(0));
    }

    @And("User clicks on Show all orders check box after navigating back")
    public void userClicksOnShowAllOrdersCheckBoxAfterNavigatingBack()
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ClickShowAllOrderCheckboxAgain();
    }

    @Then("Click on Next button after editing all order, order")
    public void clickOnNextButtonAfterEditingAllOrderOrder() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        exists=newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkOutOrderPage=new CheckOutOrderPage(driver,scenario);
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            Thread.sleep(4000);
            //checkorder.validateCheckOrder();
            checkOutOrderPage.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']",driver))
            {
                checkOutOrderPage.SelectPaymentMethod();
                scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
            }
            else
            {
                checkOutOrderPage.Click_On_Without_Providing_Payment();
                scenario.log("WITHOUT PROVIIDNG PAYMENT OPTION HAS BEEN SELECTED");
            }
            checkOutOrderPage.DeliveryAddressCard();
            checkOutOrderPage.NextButton_Click();
        }
    }

    @And("User Clicks on Add filter button and enter values for search options for searching in OE")
    public void userClicksOnAddFilterButtonAndEnterValuesForSearchOptionsForSearchingInOE()
    {
        allOrder=new AllOrderPage(driver,scenario);
        //allOrder.SubmittedStatusDropDown();
        //allOrder.SelectSubmitedOptionFromDropDown();
        allOrder.ClickOnSearchButton();
        String oNo=allOrder.readOrderNoForSearch();
        allOrder.AddFilterClick(oNo);
    }

    @Then("User clicks on OrderNo in All Order grid and User should be navigated Ordersummary page click on Back to order list")
    public void userClicksOnOrderNoInAllOrderGridAndUserShouldBeNavigatedOrdersummaryPageClickOnBackToOrderList() throws InterruptedException, AWTException
    {
        allOrder=new AllOrderPage(driver,scenario);
        allOrder.ClickOnOrderInAllOrderGrid();
        allOrder.NavigateToOrderSummaryPage();
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.clickOnBackToOrderList();
    }
}