package stepDefination_DSD_OMS.StandingOrderPage;

import gherkin.lexer.Da;
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
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.standingOrder.NewStandingOrderCard;
import pages_DSD_OMS.standingOrder.NewStandingOrderPage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
        * @Project DSD_OMS
        * @Author Divya.Ramadas@afsi.com
 */

public class StandingOrderPageSteps
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static boolean flag=false;
    static boolean flag1=false;
    static boolean flag2=false;
    static String sDate=null;
    static String date1=null;
    static String currentURL=null;

    LoginPage loginpage;
    HomePage homepage;
    OrderEntryPage orderpage;
    NewStandingOrderPage standingOrder;
    NewStandingOrderCard standingOrderCard;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for SO")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForSO() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            HelpersMethod.Implicitwait(driver, 40);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            HelpersMethod.Implicitwait(driver, 40);
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for SO")
    public void user_is_on_home_pageForSO() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            HelpersMethod.Implicitwait(driver,40);
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for SO")
    public void user_navigate_to_client_sideForSO() throws InterruptedException, AWTException
    {
        boolean result=false;
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

    @Then("User should select Order Entry tab for SO")
    public void user_should_select_order_entry_tabForSO() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Then("User selects Account# for SO")
    public void user_selects_accountForSO() throws InterruptedException, AWTException, ParseException {
        if(flag1==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.ChangeAccount();
            //orderpage.PopUps_After_AccountChange();
            orderpage.Read_DeliveryDate();
            flag1=true;
        }
    }

    @Given("User must be on Order Entry Page to select Standing Order and navigate to standing order")
    public void userMustBeOnOrderEntryPageToSelectStandingOrderAndNavigateToStandingOrder() throws InterruptedException, AWTException
    {
        if(flag2==false)
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Standing Orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                standingOrder = new NewStandingOrderPage(driver, scenario);
                standingOrder.ValidateSO();
                currentURL=driver.getCurrentUrl();
            }
            else
            {
                scenario.log("STANDING ORDER TAB DOESN'T EXISTS");
            }
            flag2=true;
        }
    }

    @And("User click on Start standing order button and selects start and end date from popup")
    public void userClickOnStartStandingOrderButtonAndSelectsStartAndEndDateFromPopup() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.HandleError_Page();
        orderpage.Refresh_Page(currentURL);
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.ClickOnNewStandingOrderArrow();
        standingOrderCard.ClickOnStartStandingOrder();
        standingOrderCard.validateStartAddStandingOrderPopup();
        standingOrderCard.VerifyCalenderPopupStandingOrder();
    }

    @Then("User enters Product# in Quick product entry inputbox")
    public void userEntersProductInQuickProductEntryInputbox()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ValidateSO();
        standingOrder.QuickProductValue();
    }

    @And("User enters Qty in standing order product grid based on enabled days")
    public void userEntersQtyInStandingOrderProductGridBasedOnEnabledDays(DataTable tabledata)
    {
        List<List<String>> Days=tabledata.asLists(String.class);
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.EnterQtyInProductGrid(Days);
    }

    @Then("User clicks on Save button and handles popup")
    public void userClicksOnSaveButtonAndHandlesPopup()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ClickSaveButton();
    }

    @Then("User clicks on Save button and handles popup and continue creation of multiple standing order")
    public void userClicksOnSaveButtonAndHandlesPopupAndContinueCreationOfMultipleStandingOrder() throws InterruptedException, AWTException
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ClickSaveButton();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.Refresh_Page(currentURL);
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ValidateSO();
    }

    @And("User click on Start standing order button and selects Start date {int} and End date {int} day from current date")
    public void userClickOnStartStandingOrderButtonAndSelectsStartDateAndEndDateDayFromCurrentDate(int Sdate,int Edate) throws InterruptedException
    {
        standingOrderCard= new NewStandingOrderCard(driver,scenario);
        standingOrderCard.ClickOnNewStandingOrderArrow();
        standingOrderCard.ClickOnStartStandingOrder();
        standingOrderCard.validateStartAddStandingOrderPopup();
        standingOrderCard.ClickOnStartDateCalender();
        standingOrderCard.SelectStartDate(Sdate);
        standingOrderCard.ClickOnEndDateCalender();
        standingOrderCard.SelectEndDate(Edate);
        standingOrderCard.AddStartStandingOrder();
    }

    @Then("User click on Add Product button in Standing order page and select catalog option")
    public void userClickOnAddProductButtonInStandingOrderPageAndSelectCatalogOption()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.validateCurrentweek();
        standingOrder.validateDeliverySchedule();
        standingOrder.ClickOnAddProductButton();
    }

    @And("User checks for catalog popup and searches for product in catalog")
    public void userChecksForCatalogPopupAndSearchesForProductInCatalog()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ValidateCatalogPopup();
        standingOrder.SearchProduct();
        standingOrder.CatalogOKButton();
    }

    @And("User enters Qty in standing order product grid based on enabled days for multiple products")
    public void userEntersQtyInStandingOrderProductGridBasedOnEnabledDaysForMultipleProducts(DataTable tabledata)
    {
        List<List<String>> Qtys=tabledata.asLists(String.class);
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.MultipleQtyProducts(Qtys);
    }

    @Then("read the first product from the product grid and click on check box")
    public void readTheFirstProductFromTheProductGridAndClickOnCheckBox()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ReadProductNoInGrid();
        standingOrder.ClickOnCheckboxOfProductNo();
    }

    @And("User clicks on Delete Product button and confirms deletion")
    public void userClicksOnDeleteProductButtonAndConfirmsDeletion()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ClickDeleteProduct();
    }

    @Then("Click on Skip specific day and select reason date for skip in skip popup and click on ok")
    public void clickOnSkipSpecificDayAndSelectReasonDateForSkipInSkipPopupAndClickOnOk() throws InterruptedException
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ClickOnSkipSpecificDay();
        standingOrder.ValidateSkipPopup();
        standingOrder.ClickOnSkipReason();
        standingOrder.SelectDateToSkip();
        standingOrder.SkipOkButton();
        standingOrder.SkipConfirmation();
    }

    @Then("Click on Skip specific day and select first date in the list of skip days in skip popup and click on ok")
    public void clickOnSkipSpecificDayAndSelectFirstDateInTheListOfSkipDaysInSkipPopupAndClickOnOk() throws InterruptedException
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ClickOnSkipSpecificDay();
        standingOrder.ValidateSkipPopup();
        standingOrder.RemoveSkipDate();
        standingOrder.SkipOkButton();
    }

    @Then("User navigates to Standing order card and clicks on Delete button")
    public void userNavigatesToStandingOrderCardAndClicksOnDeleteButton() throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.ClickOnNewStandingOrderArrow();
        standingOrderCard.DeleteStandingOrders();
    }

    @And("User should make sure that Catalog popup displayed in card view and select Category values")
    public void userShouldMakeSureThatCatalogPopupDisplayedInCardViewAndSelectCategoryValues() throws InterruptedException
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ValidateCardView();
    }

    @Then("Select products from card view")
    public void selectProductsFromCardView()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.CardViewProdSelection();
        standingOrder.CatalogOKButton();
    }

    @Then("User checks for all the prodcuts in Active SO")
    public void userChecksForAllTheProdcutsInActiveSO()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ListAllProdInGrid();
    }

    @And("User clicks on Copy Standing order button selects start and end date as {int} and {int} day from current date")
    public void userClicksOnCopyStandingOrderButtonSelectsStartAndEndDateAsAndDayFromCurrentDate(int dStart, int dEnd) throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.ClickOnNewStandingOrderArrow();
        standingOrderCard.clickCopyStandingOrderButton();
        standingOrderCard.validateVisiblilityOfCopyStandingOrderDiaglog();
        standingOrderCard.copyStandingOrderDialogForStartDate(dStart);
        standingOrderCard.copyStandingOrderDialogForEndDate(dEnd);
        standingOrderCard.copyButtonInCopyStandingOrderDiaglog();
        standingOrderCard.copySuccessPopup();
    }

    @Then("User checks for the products added to copied SO")
    public void userChecksForTheProductsAddedToCopiedSO()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ValidityDate();
        standingOrder.ListAllProdInGrid();
    }

    @Then("User Click on Skip specific day and read the skip date value and click on Ok")
    public void userClickOnSkipSpecificDayAndReadTheSkipDateValueAndClickOnOk() throws ParseException, InterruptedException
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ClickOnSkipSpecificDay();
        standingOrder.ValidateSkipPopup();
        sDate= standingOrder.readSkipDate();
        standingOrder.SkipOkButton();
        LocalDate myDateObj = LocalDate.parse(sDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        sDate = myDateObj.format(myFormatObj);
    }

    @And("User should navigate to OE page, User should select the same delivery date from calender")
    public void userShouldNavigateToOEPageUserShouldSelectTheSameDeliveryDateFromCalender() throws InterruptedException, AWTException, ParseException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.navigateToOrderEntry1();
        orderpage.ClickCalender();
        orderpage.changeDeliveryDateToStandingOrderSkip(sDate);
        orderpage.readSOSkipDateInOE();
    }

    @Then("User should verify for that date remove skip has been enabled or Skip has been disabled")
    public void userShouldVerifyForThatDateRemoveSkipHasBeenEnabledOrSkipHasBeenDisabled() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.CheckForRemoveSkip();
        orderpage.ClickCalender();
        orderpage.ResetToCurrentDate();
        standingOrder = new NewStandingOrderPage(driver, scenario);
        standingOrder.navigateToStandingOrder();
        standingOrder.ValidateSO();
    }
}
