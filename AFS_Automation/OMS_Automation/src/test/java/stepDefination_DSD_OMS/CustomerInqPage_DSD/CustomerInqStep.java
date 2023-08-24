package stepDefination_DSD_OMS.CustomerInqPage_DSD;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_DSD_OMS.customerInquiry_DSD.*;
import pages_DSD_OMS.customerInquiry_ERP.IgnitionPageERP;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class CustomerInqStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;
    static boolean flag1=false;
    static boolean flag2=false;
    static String DelSeq=null;
    static String Track=null;
    static String Route=null;
    static String currentURL=null;
    WebElement WebEle;

    LoginPage loginpage;
    HomePage homepage;
    CustomerInquiryPage customerInquiryPage;
    PrimaryPage primaryPage;
    BillToPage billToPage;
    OrderPage orderPage;
    DeliveriesPage deliveriesPage;
    AccountPage accountPage;
    PricePage pricePage;
    MiscTaxPage miscTaxPage;
    DEX_EDIPage dex_ediPage;
    IgnitionPage ignitionPage;


    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials Customer inq")
    public void userEntersURLAndIsOnLoginPageAndEnteredCredentialsCustomerInq() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Customer inq")
    public void userIsOnHomePageForCustomerInq()
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }

    }

    @Then("User navigate to Client side for Customer inq")
    public void userNavigateToClientSideForCustomerInq() throws InterruptedException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            String title = driver.getTitle();
            //Assert.assertEquals(title, "Ignition - Admin");
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
            customerInquiryPage= new CustomerInquiryPage(driver, scenario);
            customerInquiryPage.NavigateToCustomerInquiry();
            flag=true;
        }
    }

    @Given("User must be on Client side and select Customer Inq page")
    public void userMustBeOnClientSideAndSelectCustomerInqPage()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.HandleError_Page();
    }

    @When("User should confirm that he is in Customer Inq page")
    public void userShouldConfirmThatHeIsInCustomerInqPage()
    {
        if(flag1==false)
        {
            customerInquiryPage = new CustomerInquiryPage(driver, scenario);
            customerInquiryPage.NavigateToCustomerInquiry();
        }
    }

    @Then("User click on New button")
    public void userClickOnNewButton()
    {
        if(flag1==false)
        {
            customerInquiryPage = new CustomerInquiryPage(driver, scenario);
            customerInquiryPage.ValidateCustomInq();
            customerInquiryPage.New_ButtonClick();
            flag1=true;
        }
    }

    @And("Enter the Customer Account#")
    public void enterTheCustomerAccount()
    {
            customerInquiryPage = new CustomerInquiryPage(driver, scenario);
            customerInquiryPage.ValidateCustomInq();
            customerInquiryPage.BillNo();
            customerInquiryPage.StoreNo();
            customerInquiryPage.DeptNo();
            customerInquiryPage.DescrVal();
    }

    @And("User enters value to all the input box in primary page")
    public void userEntersValueToAllTheInputBoxInPrimaryPage() throws InterruptedException
    {
        primaryPage=new PrimaryPage(driver,scenario);
        primaryPage.ValidatePrimaryPage();
        primaryPage.Address1();
        primaryPage.Address2();
        primaryPage.cityValue();
        primaryPage.CountryDropDown();
        primaryPage.StateValue();
        primaryPage.ZipValue();
        primaryPage.CountryValue();
        primaryPage.PhoneValue();
        primaryPage.FaxValue();
        primaryPage.SchoolLocationValue();
        primaryPage.StreetDropDown();
        primaryPage.CustomerTypeDropDown();
        primaryPage.DistrbutorDropDown();
        primaryPage.VendorNo();
        primaryPage.SoldBy();
        //primaryPage.SoldByRemittance();
        primaryPage.HeadAccNo();
        primaryPage.StatusDropDown();
        primaryPage.SuspendOnDate();
       // primaryPage.SuspendDateSelection();
        primaryPage.ActiveOnDate();
        primaryPage.SuspensionReason();
        primaryPage.EquipmentChargeCheckbox();
        primaryPage.FuelChargeCheckbox();
        primaryPage.FuelProductDropDown();
        primaryPage.DeliveryZoneDropDown();
        primaryPage.DeliveryBranchDropDown();
        primaryPage.SellZoneDropDown();
        primaryPage.SalesRepDropDown();
        primaryPage.SalesBranchDropDown();
        primaryPage.ChainIdDropDown();
        primaryPage.BrokerDropDown();
        primaryPage.MarketAreaDropDown();
        primaryPage.GroupDropDown();
        primaryPage.CategoryDropDown();
        primaryPage.StoreTypeDropDown();
    }

    @Then("User clicks on Save button in Customer inq and handles popup")
    public void userClicksOnSaveButtonInCustomerInqAndHandlesPopup()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.Save_ButtonClick();
    }

    @And("User navigate to BillTo tab and User enteres the value for all web elements")
    public void userNavigateToBillToTabAndUserEnteresTheValueForAllWebElements()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.NavigateDifferentTabs("Bill to");
        billToPage=new BillToPage(driver,scenario);
        billToPage.ValidateBillTo();
        billToPage.Address1Value();
        billToPage.Address2Value();
        billToPage.CityValue();
        billToPage.ZipValue();
        billToPage.StateValue();
        billToPage.CountryValue();
    }

    @And("User navigate to Orders tab and User enteres the value for all web elements")
    public void userNavigateToOrdersTabAndUserEnteresTheValueForAllWebElements(DataTable dataTable)
    {
        List<List<Float>> amountValue=dataTable.asLists(float.class);
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.NavigateDifferentTabs("Orders");
        orderPage=new OrderPage(driver,scenario);
        orderPage.ValidateOrderPage();
        orderPage.ContactInput();
        orderPage.PhoneInput();
        orderPage.FaxInput();
        orderPage.HolidayRuleInput();
        orderPage.DefaultGiverInput();
        orderPage.DefaultTakerInput();
        orderPage.CustomerOrderDropDown();
        orderPage.ShowVoidedOrdersDropDown();
        orderPage.ShowVoidedSalesDropDown();
        orderPage.AuthorizedProdDropDown();
        orderPage.MinOrderAmount(amountValue.get(0).get(0));
        orderPage.MaxOrderAmount(amountValue.get(0).get(1));
        //orderPage.StartForecastingCal();
        //orderPage.SelectStartForecastingCal();
        //orderPage.StopForecastingCal();
        //orderPage.SelectEndForecastingCal();
        orderPage.UseForecastingCheckbox();
    }

    @And("User navigate to Deliveries tab and User enteres the value for all web elements")
    public void userNavigateToDeliveriesTabAndUserEnteresTheValueForAllWebElements() throws InterruptedException
    {
        int i;
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.NavigateDifferentTabs("Deliveries");
        deliveriesPage=new DeliveriesPage(driver,scenario);
        deliveriesPage.ValidateDeliveries();
        deliveriesPage.ContactValue();
        deliveriesPage.PhoneValue();
        deliveriesPage.PrimaryRouteValue();
        //deliveriesPage.WeeklyDeliSheduleDropDown();
        deliveriesPage.NoOfDayOrWeek();
        deliveriesPage.DeliveryDay();
        deliveriesPage.DefaultDeliverySequence();
        for(i=1;i<=7;i++)
        {
            DelSeq="CmDelDay"+i+"Seq";
            WebEle=HelpersMethod.FindByElement(driver,"id",DelSeq);
            deliveriesPage.DeliverySequnce(WebEle);
        }
        for(i=1;i<=7;i++)
        {
            Track="CmDelDay"+i+"TruckPos";
            WebEle=HelpersMethod.FindByElement(driver,"id",Track);
            deliveriesPage.TrackPositionDropDown(WebEle);
        }
        for(i=1;i<=7;i++)
        {
            Route="CmDelDay"+i+"Route";
            WebEle= HelpersMethod.FindByElement(driver,"id",Route);
            deliveriesPage.DeliveryRoute(WebEle);
        }
        deliveriesPage.DSDrequired();
        deliveriesPage.SignatureRequired();
        deliveriesPage.StoreStampRequired();
        deliveriesPage.DynamicAllocation();
        deliveriesPage.LoadSequnceGroup();
        deliveriesPage.ProductDeliverySequnce();
        deliveriesPage.AllowPromoExclusion();
        deliveriesPage.HHLastDeliveryDate();
        //deliveriesPage.SelectHHLastDeliveryDate();
        //deliveriesPage.HHLastScheduleDate();
        //deliveriesPage.SelectHHLastScheduleDate();
        deliveriesPage.Soldto();
        deliveriesPage.SplitTicket();
        deliveriesPage.Price();
        deliveriesPage.ExtensionPrice();
        deliveriesPage.TotalPrice();
        deliveriesPage.PrintRetailPrice();
        deliveriesPage.PrintCaseUnit();
        deliveriesPage.PrintRetailPriceExt();
    }

    @And("User navigate to Account tab and User enteres the value for all web elements")
    public void userNavigateToAccountTabAndUserEnteresTheValueForAllWebElements()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.NavigateDifferentTabs("Account");
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        accountPage=new AccountPage(driver,scenario);
        accountPage.ARTypeDropDown();
        accountPage.GLCatDropDown();
        accountPage.PaymentTermDropDown();
        accountPage.PaymentTypeDropDown();
        accountPage.ChannelNoDropDown();
        accountPage.MonthlyStatementDropDown();
        //accountPage.CreditLimitAmount();
        accountPage.BalanceAmount();
        accountPage.BillingSequence();
        accountPage.DiscountAmount();
        accountPage.AlternateStoreInput();
        accountPage.BillableCheckbox();
        accountPage.BillingGroupDropDown();
        accountPage.BillingPeriodDropDown();
        //accountPage.CreditCardInput();
        //accountPage.CreditCardExpinput();
        //accountPage.CreditCardCustCheckbox();
        accountPage.BillingPreferenceDropDown();
        accountPage.AdministrationFeeAmount();
        accountPage.ARContactInput();
        accountPage.ARPhoneNoInput();
        accountPage.ARFaxNoInput();
        accountPage.ContractNoInput();
        accountPage.PORequiredDropDown();
        accountPage.BankNameInput();
        accountPage.BranchNameInput();
        accountPage.PayerName();
        accountPage.MonthlyStatePrintCheckbox();
        accountPage.MonthlyStateEmailedCheckbox();
        accountPage.WeeklyStatePrintCheckbox();
        accountPage.WeeklyStateEmailedCheckbox();
        accountPage.PrimaryEmailInput();
        accountPage.SecondaryEmailInput();
        accountPage.PrintUnitCheckbox();
        accountPage.AllowHandledCheckbox();
        accountPage.StopSupplyCodeDropDown();
        accountPage.ReturnRestCodeDropDown();
        accountPage.DefaultHHDetailDropDown();
        accountPage.AutoPageCustomerDropDown();
        accountPage.PrintCustomerLoadCheckbox();
        accountPage.CanDamageCheckbox();
        accountPage.SuppressedPriceCheckbox();
        accountPage.BlockUploadCheckbox();
        accountPage.PrintGroupedCheckbox();
        accountPage.SplitTicketsCheckbox();
        accountPage.EnterCarryOverCheckbox();
        accountPage.AllowStaleCreditCheckbox();
        accountPage.DonotAllowSalesCheckbox();
        accountPage.AllowHHInvoiceCheckbox();
    }

    @And("User navigate to Price tab and User enteres the value for all web elements")
    public void userNavigateToPriceTabAndUserEnteresTheValueForAllWebElements()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.NavigateDifferentTabs("Price");
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        pricePage=new PricePage(driver,scenario);
        pricePage.ValidatePrice();
        pricePage.DefaultListDropDown();
        pricePage.BasePriceDropDown();
        pricePage.RetailPriceDropDown();
        pricePage.DistributorPartnerDropDown();
        pricePage.StoreRebateDropDown();
        pricePage.VolumeDiscountDropDown();
        pricePage.BillingDiscountDropDown();
        pricePage.TicketDiscountDropDown();
        pricePage.DistributorDiscountDropDown();
        pricePage.PromotionDropDown();
        pricePage.ProductCostDropDown();
        pricePage.ProductFloorCostDropDown();
        pricePage.ContractPriceDropDown();
        pricePage.DriverDropDown();
        pricePage.DriverOverShortDropDown();
        pricePage.BrokerDropDown();
        pricePage.SalesRepDropDown();
        pricePage.PrintedCheckBox();
        pricePage.EmailedCheckBox();
        pricePage.EmailGroupDropDown();
        pricePage.PrimaryEmailInput();
        pricePage.SecondaryEmailInput();
        pricePage.DiscountPerInput();
        pricePage.ChargebackPerInput();
        pricePage.FinanceChargeInput();
        pricePage.ReturnDaysInput();
        pricePage.HaulingRateInput();
        pricePage.SalesCreditDropDown();
        pricePage.PromotionOverrideDropDown();
        pricePage.ChangeRetailDropDown();
        pricePage.BrandCheckbox();
        pricePage.CakeCheckbox();
        pricePage.PrivateLabelCheckBox();
        pricePage.DeliCheckbox();
    }

    @And("User navigate to Misc.Tax tab and User enteres the value for all web elements")
    public void userNavigateToMiscTaxTabAndUserEnteresTheValueForAllWebElements()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.NavigateDifferentTabs("Misc./Tax");
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        miscTaxPage=new MiscTaxPage(driver,scenario);
        miscTaxPage.ValidateMiscTax();
        miscTaxPage.InventoryRequiredCheckbox();
        miscTaxPage.SubTypeDropDown();
        miscTaxPage.FedTaxInputBox();
        miscTaxPage.NonFoodTaxInputBox();
        miscTaxPage.TaxCode1DropDown();
        miscTaxPage.TaxPercentage1InputBox();
        miscTaxPage.TaxCode2DropDown();
        miscTaxPage.TaxPercentage2InputBox();
        miscTaxPage.TaxCode3DropDown();
        miscTaxPage.TaxPercentage3InputBox();
        miscTaxPage.PartyPayeeNo();
        miscTaxPage.SpoilInputBox();
        miscTaxPage.PathMarkDropDown();
        miscTaxPage.ContainerDropDown();
        miscTaxPage.LoyaltyDropDown();
        miscTaxPage.LoyaltyInputBox();
        miscTaxPage.Reference1InputBox();
        miscTaxPage.Reference2InputBox();
    }

    @And("User navigate to Dex.Edi tab and User enteres the value for all web elements")
    public void userNavigateToDexEdiTabAndUserEnteresTheValueForAllWebElements()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.NavigateDifferentTabs("DEX/EDI");
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        dex_ediPage=new DEX_EDIPage(driver,scenario);
        dex_ediPage.ValidateDEXEDI();
        dex_ediPage.DEXCustomerDropDown();
        dex_ediPage.DEXStandardDropDown();
        dex_ediPage.DEXCommIdInputBox();
        dex_ediPage.DEXDunsNo();
        dex_ediPage.DEXLocationInputBox();
        dex_ediPage.DEXAllCodeInputBox();
        dex_ediPage.DEXPriorPrintDropDown();
        dex_ediPage.DEXAfterPrintDropDown();
        dex_ediPage.DEXComIdInputBox();
        dex_ediPage.DEXDunNoInputBox();
        dex_ediPage.DEXLocInputBox();
        dex_ediPage.EDIInputBox();
        dex_ediPage.GLNNoInputBox();
    }

    @And("User navigate to Ignition tab")
    public void userNavigateToIgnitionTab()
    {
        if(flag2==false)
        {
            customerInquiryPage = new CustomerInquiryPage(driver, scenario);
            customerInquiryPage.NavigateDifferentTabs("TELUS OMS");
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
            }
            ignitionPage = new IgnitionPage(driver, scenario);
            ignitionPage.ValidateIgnition();
            currentURL = driver.getCurrentUrl();
            flag2=true;
        }
        //ignitionPage.cancelPopup();
        ignitionPage=new IgnitionPage(driver,scenario);
        ignitionPage.validateAddStandingOrder();
    }

    @Then("User clicks on Create new button and standing PO popup appeared")
    public void userClicksOnCreateNewButtonAndStandingOrderPopupAppeared()
    {
        ignitionPage=new IgnitionPage(driver,scenario);
        ignitionPage.ValidateIgnition();
        ignitionPage.ClickOnNewButton();
        ignitionPage.ValidateAddStandingPO();
    }

    @And("User selects {int} day from current date and {int} day from end date and Select Payment processing")
    public void userSelectsDayFromCurrentDateAndDayFromEndDateAndSelectPaymentProcessing(int arg0, int arg1)
    {
        ignitionPage=new IgnitionPage(driver,scenario);
        ignitionPage.ValidateAddStandingPO();
        ignitionPage.ClickOnStartDateCalender();
        ignitionPage.SelectStartDate(arg0);
        ignitionPage.ClickOnEndDateCalender();
        ignitionPage.SelectEndDate(arg1);
        ignitionPage.POInputBox();
        ignitionPage.ClickOnAdd();
        ignitionPage.PaymentProcessingDropdown();
    }

    @Then("User selects time for order time for different days")
    public void userSelectsTimeForOrderTimeForDifferentDays() throws InterruptedException
    {
        ignitionPage=new IgnitionPage(driver,scenario);
        List<WebElement> Clocks= HelpersMethod.FindByElements(driver,"xpath","//div[@class='ignition-call-list-schedule-details row']/descendant::span[@class='k-icon k-i-clock']");
        for(int i=1;i<= Clocks.size();i++)
        {
            ignitionPage.ClickClockIcon(i);
            ignitionPage.SelectHoursForAllDays();
            ignitionPage.SelectMinForAllDays();
            ignitionPage.ClickOnSetButton();
        }
    }

    @And("User selects Order taker from drop down")
    public void userSelectsOrderTakerFromDropDown()
    {
        ignitionPage=new IgnitionPage(driver,scenario);
        List<WebElement> OrderTakers=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'ignition-call-list-schedule-details row')]/descendant::span[contains(@class,'k-widget k-dropdown')]");
        for(int i=1;i<=OrderTakers.size();i++)
        {
            ignitionPage.ClickOrderTracker(i);
        }
    }

    @Then("User clicks on Save button")
    public void userClicksOnSaveButton()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.Save_ButtonClick();
        customerInquiryPage.validateSaveConfirmationPopup();
        customerInquiryPage.SaveButtonOK();
    }

    @Then("User enters Description of customer and load already saved details")
    public void userEntersDescriptionOfCustomerAndLoadAlreadySavedDetails()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.LoadCustomer();
    }

    @Then("User enters PO in search box and user should make sure that PO details displayed in grid")
    public void userEntersPOInSearchBoxAndUserShouldMakeSureThatPODetailsDisplayedInGrid()
    {
        ignitionPage=new IgnitionPage(driver,scenario);
        ignitionPage.SearchPONo();
    }

    @And("User should be able to select the PO details and edit end date as {int} days")
    public void userShouldBeAbleToSelectThePODetailsAndEditEndDateAsDays(int arg0)
    {
        ignitionPage=new IgnitionPage(driver,scenario);
        ignitionPage.SelectPONo();
        ignitionPage.ClickEditButton();
        ignitionPage.validateEditStndingPO();
        ignitionPage.ClickOnEndDateCalenderInEditPopup();
        ignitionPage.SelectEndDateInEditPopup(arg0);
    }

    @Then("User clicks on Copy button and popup should display")
    public void userClicksOnCopyButtonAndPopupShouldDisplay()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.ClickCopy();
        customerInquiryPage.CopyCutomerPopup();
    }

    @Then("User clicks on Save button before adding values to ignition in DSD")
    public void userClicksOnSaveButtonBeforeAddingValuesToIgnitionInDSD()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.BillNo();
        //customerInquiryPage.StoreNo();
        //customerInquiryPage.DeptNo();
        customerInquiryPage.DescrVal();
        customerInquiryPage.Save_ButtonClick();
        customerInquiryPage.validateSaveConfirmationPopup();
        customerInquiryPage.SaveButtonOK();
    }

    @Then("Add note in popup in cust inq")
    public void addNoteInPopupInCustInq(DataTable tabledata)
    {
        customerInquiryPage = new CustomerInquiryPage(driver, scenario);
        List<List<String>> Cust_Note = tabledata.asLists(String.class);
        customerInquiryPage.clickOnNote();
        customerInquiryPage.validateNotePopup();
        customerInquiryPage.Add_Customer_Note(Cust_Note.get(0).get(0));
    }

    @And("User should select the Alert Type and Alert location to display notes in DSD cust inq")
    public void userShouldSelectTheAlertTypeAndAlertLocationToDisplayNotesInDSDCustInq(DataTable tabledata)
    {
        customerInquiryPage = new CustomerInquiryPage(driver, scenario);
        List<List<String>> Alerts=tabledata.asLists(String.class);
        customerInquiryPage.Select_AlertType_Location(Alerts.get(0).get(0),Alerts.get(0).get(1),Alerts.get(0).get(2));
    }

    @Then("Click on Save button in DSD cust inq")
    public void clickOnSaveButtonInDSDCustInq()
    {
        customerInquiryPage = new CustomerInquiryPage(driver, scenario);
        customerInquiryPage.Save_Note_Button();
        customerInquiryPage.Ok_Note_Button();
    }

    @Then("PO has been saved")
    public void poHasBeenSaved()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.validateSaveConfirmationPopup();
        customerInquiryPage.SaveButtonOK();
    }

    @Then("User changes PO value")
    public void userChangesPOValue()
    {
        ignitionPage=new IgnitionPage(driver,scenario);
        ignitionPage.POInputBox();
        ignitionPage.ClickUpdate();
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.validateSaveConfirmationPopup();
        customerInquiryPage.SaveButtonOK();
    }

    @Then("User clears search bar in ignition tab")
    public void userClearsSearchBarInIgnitionTab()
    {
        ignitionPage=new IgnitionPage(driver,scenario);
        ignitionPage.clearSearchbar();
    }

    @Then("User selects Standing PO# from the grid and click Delete")
    public void userSelectsStandingPOFromTheGridAndClickDelete()
    {
        List<WebElement> Pos= HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]");
       for(int i=0;i<= Pos.size()-1;i++)
       {
           IgnitionPageERP ignitionPageERP = new IgnitionPageERP(driver, scenario);
           ignitionPageERP.selectPONoForDelete(i);
           ignitionPageERP.clickDelete();
           ignitionPageERP.confirmationPopUp();
       }
    }
}
