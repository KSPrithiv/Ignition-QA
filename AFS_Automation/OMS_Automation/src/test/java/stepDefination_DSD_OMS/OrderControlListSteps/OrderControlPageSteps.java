package stepDefination_DSD_OMS.OrderControlListSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.time.Duration;
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

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static OrderControlListPage orderControlList;

    static boolean cutOff=false;
    static boolean exists=false;
    static boolean flag=false;
    static boolean flag1=false;
    static String currentURL;
    static String Ord_No;

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
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for OCL")
    public void user_is_on_home_pageForOCL() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for OCL")
    public void user_navigate_to_client_sideForOCL() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab for OCL")
    public void user_should_select_order_entry_tab_for_OCL() throws InterruptedException, AWTException
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
        if(flag1==false)
        {
            WebElement WebEle = null;
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
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
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]");
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//span[@class='k-link' and contains(text(),'Order control list')]",driver))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Order control list", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
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
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(140))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                orderControlList = new OrderControlListPage(driver, scenario);
                orderControlList.Validate_OCL();
                currentURL=driver.getCurrentUrl();
                scenario.log("CURRENT URL IS "+currentURL);
            }
            else
            {
                scenario.log("ORDER CONTROL TAB DOESN'T EXISTS");
            }
            flag1=true;
        }
    }

    @And("User should navigate to OCL")
    public void userShouldNavigateToOCL() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.HandleError_Page();
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Refresh_Page(currentURL);
        orderControlList.Validate_OCL();
    }

    @Then("User should select Order taker from drop down")
    public void userShouldSelectOrderTakerFromDropDown()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Click_OrderTaker();
        orderControlList.Select_OrderTaker();
    }

    @And("Change the delivery date {int} days after current date")
    public void changeTheDeliveryDateDaysAfterCurrentDate(int days)
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Validate_OCL();
        orderControlList.Call_Date_Click();
        orderControlList.Call_Date_Selection(days);
    }

    @Then("User Clicks on Untaken radio button")
    public void userClicksOnUntakenRadioButton()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Validate_OCL();
        orderControlList.Select_Untaken();
    }

    @Then("User clicks on Order icon in OCL grid")
    public void userClicksOnOrderIconInOCLGrid()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.checkForOrderIcon();
    }

    @And("User validate that he is in NewOE page")
    public void userValidateThatHeIsInNewOEPage() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        exists= newOE.ValidateNewOE();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NoPendingOrderPopup();
    }

    @And("User Clicks on Back button in NewOE page and User must be in OCL page")
    public void userClicksOnBackButtonInNewOEPageAndUserMustBeInOCLPage() throws InterruptedException, AWTException
    {
        if(cutOff==false)
        {
            newOE = new NewOrderEntryPage(driver, scenario);
            exists = newOE.ValidateNewOE();
            if (exists == true)
            {
                scenario.log("AUTOMATICALLY LOAD NEXT CUSTOMER IN ORDER CONTROL LIST");
                newOE.Click_Back_But();
            }
            orderControlList = new OrderControlListPage(driver, scenario);
            orderControlList.Validate_OCL();
        }
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
        orderControlList.ValidateSkipPopup();
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
        orderControlList.Validate_OCL();
        orderControlList.Skip();
    }

    @And("User handles Remove skip popup")
    public void userHandlesRemoveSkipPopup()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.RemoveSkipPopUp();
        orderControlList.validateChangeOfRemoveSkip();
        orderControlList.Validate_OCL();
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
        orderControlList.readGroupingDetails();
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
        orderControlList.Validate_OCL();
        orderControlList.Select_Taken();
    }

    @Then("User Clicks on Untaken radio button and user clicks on Refresh button")
    public void userClicksOnUntakenRadioButtonAndUserClicksOnRefreshButton()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Select_Untaken();
        orderControlList.Refresh_Click();
    }

    @And("User verifies existence of customer account for which skip is enabled, exists under taken")
    public void userVerifiesExistenceOfCustomerAccountForWhichSkipIsEnabledExistsUnderTaken() throws InterruptedException
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.verifySkipInTaken();
    }

    @And("Click on Submit Order button and read Order_no for OCL")
    public void clickOnSubmitOrderButtonAndReadOrder_noForOCL() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        //summary.validateSummaryPage();
        summary.ClickSubmit();
        for(int i=0;i<=2;i++)
        {
            summary.additionalOrderPopup();
            summary.cutoffDialog();
            summary.percentageOfAverageProd();
        }
        String sOrd_No = summary.Get_Order_No();
        if(sOrd_No!=null)
        {
            Ord_No=sOrd_No;
        }
        summary.SucessPopup();
        Thread.sleep(4000);
    }

    @And("User enters OrderNo in search box to search for order")
    public void userEntersOrderNoInSearchBoxToSearchForOrder()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.searchOrderInOCL(Ord_No);
        orderControlList.readOrderComment();
    }

    @Then("User finds the comment for order in OCL")
    public void userFindsTheCommentForOrderInOCL()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.readOrderComment();
    }

    @And("User should verify Order number created in OCL grid and Order icon in OCL")
    public void userShouldVerifyOrderNumberCreatedInOCLGridAndOrderIconInOCL()
    {
        orderControlList = new OrderControlListPage(driver, scenario);
        orderControlList.Validate_OCL();
        orderControlList.verifyOrderInOCLgrid(Ord_No);
        orderControlList.verifyNewOrderIconInOCLgrid();
        orderControlList.clearSearchBar();
    }

    @And("User should verify Order number created in OCL grid")
    public void userShouldVerifyOrderNumberCreatedInOCLGrid()
    {
        orderControlList = new OrderControlListPage(driver, scenario);
        orderControlList.Validate_OCL();
        orderControlList.verifyOrderInOCLgrid(Ord_No);
    }

    @And("User should verify Order number created in OCL grid and Order type in OCL")
    public void userShouldVerifyOrderNumberCreatedInOCLGridAndOrderTypeInOCL()
    {
        orderControlList = new OrderControlListPage(driver, scenario);
        orderControlList.verifyOrderInOCLgrid(Ord_No);
        orderControlList.verifyOrderType();
        //orderControlList.clearSearchBar();
    }

    @Then("User refreshes page and Clicks on Taken radio button delivery date should be increased by {int}")
    public void userRefreshesPageAndClicksOnTakenRadioButtonDeliveryDateShouldBeIncreasedBy(int i)
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        orderControlList.Refresh_Click();
        orderControlList.Click_OrderTaker();
        orderControlList.Select_OrderTaker();
        orderControlList.Call_Date_Click();
        orderControlList.Call_Date_Selection(i);
        orderControlList.Select_Taken();
    }

    @And("User verify created by column value")
    public void userVerifyCreatedByColumnValue()
    {
        orderControlList = new OrderControlListPage(driver, scenario);
        orderControlList.Validate_OCL();
        orderControlList.validateCreatedByColumn();
        orderControlList.displayOrderCreatedByName();
    }

    @Then("User should search for valid customers in OCL")
    public void userShouldSearchForValidCustomersInOCL(DataTable tabledata)
    {
        List<List<String>> custName = tabledata.asLists(String.class);
        orderControlList = new OrderControlListPage(driver, scenario);
        //String url=TestBase.testEnvironment.get_url();
        //if(url.contains("dsd"))
        //{
            orderControlList.searchForValidCustomer(custName.get(0).get(0));
        //}
    }

    @Then("User should select Note from popup and Order guide from popup for OCL")
    public void userShouldSelectNoteFromPopupAndOrderGuideFromPopupForOCL() throws InterruptedException, AWTException
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[contains(text(),'The cutoff time')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
        {
            scenario.log("<span style='color:red'>CUTOFF TIME HAS BEEN FOUND</span>");
            WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement okButton=modelContainer.findElement(By.xpath(".//button[text()='Ok']"));
            HelpersMethod.ActClick(driver,okButton,10000);
            cutOff=true;
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
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
        else
        {
            orderpage = new OrderEntryPage(driver, scenario);
            for (int i = 0; i <= 1; i++)
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

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
    }

    @Then("User validate that he is in NewOE page for OCL")
    public void userValidateThatHeIsInNewOEPageForOCL() throws InterruptedException, AWTException
    {
        if(cutOff==false)
        {
            newOE = new NewOrderEntryPage(driver, scenario);
            exists = newOE.ValidateNewOE();
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NoPendingOrderPopup();
        }
    }

    @Then("User should search for credit holder in OCL")
    public void userShouldSearchForCreditHolderInOCL(DataTable tabledata)
    {
        List<List<String>> creditHold = tabledata.asLists(String.class);
        orderControlList = new OrderControlListPage(driver, scenario);
        orderControlList.searchForCreditHolder(creditHold.get(0).get(0));
    }

    @And("User should verify Order number created in OCL grid for created by column in OCL")
    public void userShouldVerifyOrderNumberCreatedInOCLGridForCreatedByColumnInOCL()
    {
        orderControlList = new OrderControlListPage(driver, scenario);
        orderControlList.Validate_OCL();
        orderControlList.verifyOrderInOCLgrid(Ord_No);
        orderControlList.clearSearchBar();
    }
}