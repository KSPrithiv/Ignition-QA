package stepDefination_DSD_OMS.OrderControlList;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderControlPageSteps
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    LoginPage loginpage;
    HomePage homepage;
    OrderEntryPage orderpage;
    NewOrderEntryPage newOE;
    CheckOutSummaryPage summary;
    OrderHistoryPage orderhistory;
    CheckOutOrderPage checkorder;
    OrderControlListPage orderControlList;

    static boolean exists=false;
    static boolean flag=false;
    static boolean flag1=false;
    static String currentURL=null;
    static String Ord_No=null;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for OCL")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForOCL() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            HelpersMethod.Implicitwait(driver, 10);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            HelpersMethod.Implicitwait(driver, 2);
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for OCL")
    public void user_is_on_home_pageForOCL() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            HelpersMethod.Implicitwait(driver,10);
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for OCL")
    public void user_navigate_to_client_sideForOCL() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            Thread.sleep(10000);
            homepage = new HomePage(driver,scenario);
            String title = driver.getTitle();
            Assert.assertEquals(title, "Ignition - Admin");
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab for OCL")
    public void user_should_select_order_entry_tab() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Then("User selects Account# for OCL")
    public void user_selects_accountForOCL() throws InterruptedException, AWTException, ParseException {
        if(flag1==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.ChangeAccount();
            //orderpage.PopUps_After_AccountChange();
            orderpage.Read_DeliveryDate();
        }
    }

    @Given("User must be on Order Entry Page to select OCL")
    public void UserMustBeOnOrderEntryPageToSelectOCL() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.HandleError_Page();
        orderpage.Refresh_Page(currentURL);
    }

    @And("User should navigate to OCL")
    public void userShouldNavigateToOCL()
    {
        if(flag1==false)
        {
            WebElement WebEle = null;
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Order control list", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                orderControlList = new OrderControlListPage(driver, scenario);
                orderControlList.Validate_OCL();
                currentURL=driver.getCurrentUrl();
            }
            else
            {
                scenario.log("ORDER GUIDE TAB DOESN'T EXISTS");
            }
            flag1=true;
        }
    }

    @Then("User should select Order traker from drop down")
    public void userShouldSelectOrderTrakerFromDropDown()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Click_OrderTracker();
        orderControlList.Select_OrderTracker();
    }

    @And("Change the delivery date {int} days after current date")
    public void changeTheDeliveryDateDaysAfterCurrentDate(int days)
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Call_Date_Click();
        orderControlList.Call_Date_Selection(days);
    }

    @Then("User Clicks on Untaken radio button")
    public void userClicksOnUntakenRadioButton()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Select_Untaken();
    }

    @Then("User clicks on Order icon in OCL grid")
    public void userClicksOnOrderIconInOCLGrid()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.OrderIcon_Click();
    }

    @And("User validate that he is in NewOE page")
    public void userValidateThatHeIsInNewOEPage() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        exists= newOE.ValidateNewOE();
        Assert.assertEquals(exists,true);
    }

    @And("User Clicks on Back button in NewOE page and User must be in OCL page")
    public void userClicksOnBackButtonInNewOEPageAndUserMustBeInOCLPage() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        exists= newOE.ValidateNewOE();
        if(exists==true)
        {
            newOE.Click_Back_But();
        }
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Validate_OCL();
    }

    @Then("User clicks on Add filter button and enter value for first search box and second search box")
    public void userClicksOnAddFilterButtonAndEnterValueForFirstSearchBoxAndSecondSearchBox(DataTable datatable) throws InterruptedException, AWTException
    {
        List<List<String>> FirstSearch=datatable.asLists(String.class);
        orderControlList=new OrderControlListPage(driver,scenario);
        String Acc=TestBase.testEnvironment.get_Account();
        orderControlList.AddFilterOCL(FirstSearch.get(0).get(0),Acc);
        orderControlList.ValidateOCLGrid();
    }

    @And("User clicks on All radio button")
    public void userClicksOnAllRadioButton()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Select_All();
    }

    @Then("User select OCL which is not skipped")
    public void userSelectOCLWhichIsNotSkipped()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Skip_NotSkip();
    }

    @And("User Clicks on Skip button and validates the skip popup selects the reason")
    public void userClicksOnSkipButtonAndValidatesTheSkipPopupSelectsTheReason(DataTable datatable)
    {
        List<String> SkipReason=datatable.asList(String.class);
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.SkipPop(SkipReason.get(0));
    }

    @Then("User validates skip option")
    public void userValidatesSkipOption()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.ValidateSkip();
    }

    @Then("User select OCL which is skipped")
    public void userSelectOCLWhichIsSkipped()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Skip();
    }

    @And("User handles Remove skip popup")
    public void userHandlesRemoveSkipPopup()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.RemoveSkipPopUp();
    }

    @Then("User validates Not skip option")
    public void userValidatesNotSkipOption()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.ValidateNotSkip();
    }

    @Then("User should drag and drop grid header")
    public void userShouldDragAndDropGridHeader(DataTable dataTable)
    {
        List<String> Header=dataTable.asList(String.class);
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.DragDropHeader(Header.get(0));
    }

    @Then("User should be navigated to Order control list page")
    public void userShouldBeNavigatedToOrderControlListPage()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Validate_OCL();
    }

    @Then("User clicks on Print button and handle the new browser window")
    public void userClicksOnPrintButtonAndHandleTheNewBrowserWindow()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.clickOnPrintButton();
    }

    @Then("User Clicks on Taken radio button")
    public void userClicksOnTakenRadioButton()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Select_Taken();
    }

    @Then("User Clicks on Untaken radio button and user clicks on Refresh button")
    public void userClicksOnUntakenRadioButtonAndUserClicksOnRefreshButton()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Select_Untaken();
        orderControlList.Refresh_Click();
    }

    @And("User verifies existance of customer account for which skip is enabled, exists under taken")
    public void userVerifiesExistanceOfCustomerAccountForWhichSkipIsEnabledExistsUnderTaken()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.verifySkipInTaken();
    }

    @And("Click on Submit Order button and read Order_no for OCL")
    public void clickOnSubmitOrderButtonAndReadOrder_noForOCL() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        summary.ClickSubmit();
        Ord_No = summary.Get_Order_No();
        summary.SucessPopup();
    }

    @And("User enters OrderNo in search box to search for order")
    public void userEntersOrderNoInSearchBoxToSearchForOrder()
    {
    }

    @Then("User finds the comment for order in OCL")
    public void userFindsTheCommentForOrderInOCL()
    {
    }


}
