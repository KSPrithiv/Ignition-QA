package stepDefination_DSD_OMS.CustomerInqPage_ERP;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages_DSD_OMS.customerInquiry_DSD.CustomerInquiryPage;
import pages_DSD_OMS.customerInquiry_ERP.*;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
        * @Project DSD_OMS
        * @Author Divya.Ramadas@afsi.com
 */


public class CustomerInqStep_ERP
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;
    static boolean flag1=false;
    static boolean flag2=false;
    static String currentURL=null;
    WebElement WebEle;

    static LoginPage loginpage;
    static HomePage homepage;
    static CustomerInquiryPageERP customerInquiryPageERP;
    static MainPage mainPage;
    static ARRulesPage arRulesPage;
    static CreditPage credit;
    static BillingInfoPage billingInfo;
    static MarketingPage marketingPage;
    static PricingPage pricingPage;
    static OrderEntryPage orderEntryPage;
    static IgnitionPageERP ignitionPageERP;
    static ShippingPage shippingPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials Customer inq ERP")
    public void userEntersURLAndIsOnLoginPageAndEnteredCredentialsCustomerInqERP() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Customer inq ERP")
    public void userIsOnHomePageForCustomerInqERP()
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for Customer inq ERP")
    public void userNavigateToClientSideForCustomerInqERP() throws InterruptedException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            String title = driver.getTitle();
            //Assert.assertEquals(title, "Ignition - Admin");
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
            customerInquiryPageERP= new CustomerInquiryPageERP(driver, scenario);
            customerInquiryPageERP.NavigateToCustomerInquiry();
            flag=true;
        }
    }

    @Given("User must be on Client side and select Customer Inq in ERP")
    public void userMustBeOnClientSideAndSelectCustomerInqInERP() 
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.HandleError_Page();
    }

    @When("User should confirm that he is in Customer Inq in ERP")
    public void userShouldConfirmThatHeIsInCustomerInqInERP()
    {
        if(flag1==false)
        {
            customerInquiryPageERP = new CustomerInquiryPageERP(driver, scenario);
            customerInquiryPageERP.NavigateToCustomerInquiry();
        }
    }

    @Then("User click on New button in ERP Customer Inq")
    public void userClickOnNewButtonInERPCustomerInq()
    {
        if(flag1==false)
        {
            customerInquiryPageERP = new CustomerInquiryPageERP(driver, scenario);
            customerInquiryPageERP.ValidateCustomInq();
            customerInquiryPageERP.New_ButtonClick();
            flag1=true;
        }
    }

    @And("User enters value to all the input box in Main page")
    public void userEntersValueToAllTheInputBoxInMainPage()
    {
        mainPage=new MainPage(driver,scenario);
        mainPage.firstNameEntry();
        mainPage.lastNameEntry();
        mainPage.storeNumberEntry();
        mainPage.lookupInformation();
        mainPage.address1();
        mainPage.address2();
        mainPage.cityName();
        mainPage.countryDropDown();
        mainPage.zipCode();
        mainPage.stateDropDown();
        mainPage.phoneNumber();
        mainPage.faxNumber();
        mainPage.emailAddress();
        mainPage.websiteAddress();
        mainPage.languageDropDown();
        mainPage.vendorDropDown();
        mainPage.contactName();
        mainPage.contactTitle();
        mainPage.contactPhone();
        mainPage.primaryEmailAddress();
    }

    @And("User navigate to AR Rules tab and User enters value to all the input box in AR Rules page")
    public void userNavigateToARRulesTabAndUserEntersValueToAllTheInputBoxInARRulesPage()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.NavigateDifferentTabs("AR rules");
        arRulesPage=new ARRulesPage(driver,scenario);
        arRulesPage.marketSegmentDropDown();
        arRulesPage.currencyCode();
        arRulesPage.exchangeRateSourceDropDown();
        arRulesPage.billToCustomerDropDown();
        arRulesPage.remitToCodeDropDown();
        arRulesPage.cashGroupCodeDropDown();
        arRulesPage.applicationMethodDropDown();
        arRulesPage.statementToDropDown();
        arRulesPage.statementFreqDropDown();
        arRulesPage.statementDOWDropDown();
        arRulesPage.statementTypeDropDown();
    }

    @And("User navigate to Credit tab and User enters value to all the input box in Credit page")
    public void userNavigateToCreditTabAndUserEntersValueToAllTheInputBoxInCreditPage()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.NavigateDifferentTabs("Credit");
        credit=new CreditPage(driver,scenario);
        credit.statusDropDown();
        credit.defaultBranchDropDown();
        credit.defaultWarehouseDropDown();
        credit.creditToCompanyDropDown();
        credit.creditToCustomerDropDown();
        credit.creditLimit();
        credit.memoLimit();
        credit.creditHoldCodeDropDown();
        credit.creditTermsDropDown();
        credit.serviceChargeDropDown();
        credit.creditRepDropDown();
        credit.reviewDateSelection();
        credit.selectReviewDate();
        credit.nextReviewDateSelection();
        credit.selectNextReviewDate();
    }

    @And("User navigate to Billing Info tab and User enters value to all the input box in Billing Info page")
    public void userNavigateToBillingInfoTabAndUserEntersValueToAllTheInputBoxInBillingInfoPage()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.NavigateDifferentTabs("Billing info");
        billingInfo=new BillingInfoPage(driver,scenario);
        billingInfo.InvoiceCopy();
        billingInfo.salesTaxCodeDropDown();
        billingInfo.legalName();
        billingInfo.DBAName();
        billingInfo.DunAndBrandStreet();
        billingInfo.DAndBRating();
        billingInfo.address1();
        billingInfo.address2();
        billingInfo.address3();
        billingInfo.address4();
        billingInfo.billingCompany();
        billingInfo.billingCity();
        billingInfo.billToCountryDropDown();
        billingInfo.zipCode();
        billingInfo.billToStateDropDown();
        billingInfo.phoneNumber();
        billingInfo.faxNumber();
    }

    @And("User navigate to Marketing tab and User enters value to all the input box in Marketing page")
    public void userNavigateToMarketingTabAndUserEntersValueToAllTheInputBoxInMarketingPage()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.NavigateDifferentTabs("Marketing");
        marketingPage=new MarketingPage(driver,scenario);
        marketingPage.salesRepDropDown();
        marketingPage.salesRep2DropDown();
        marketingPage.salesRep3DropDown();
        marketingPage.brokerDropDown();
        marketingPage.broker2DropDown();
        marketingPage.broker3DropDown();
        marketingPage.FOBCodeDropDown();
        marketingPage.regionCodeDropDown();
        marketingPage.territoryCodeDropDown();
        marketingPage.originCodeDropDown();
        marketingPage.salesAnalysisCustDropDown();
        marketingPage.desiredServiceLevel();
        //marketingPage.customerTypeCode();
        marketingPage.localChainIdDropDown();
        marketingPage.nationalChainDropDown();
        marketingPage.priceGroupDropDown();
    }

    @And("User navigate to Pricing tab and User enters value to all the input box in Pricing page")
    public void userNavigateToPricingTabAndUserEntersValueToAllTheInputBoxInPricingPage() throws InterruptedException
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.NavigateDifferentTabs("Pricing");
        pricingPage=new PricingPage(driver,scenario);
        pricingPage.pricingCustomerDropDown();
        pricingPage.pricingLevelDropDown();
        pricingPage.pricingLevelDropDown();
        pricingPage.lastNotificationCalender();
        pricingPage.selectReviewDate();
        pricingPage.AIMPricingDropDown();
        pricingPage.retailPriceDropDown();
        pricingPage.shelfTagsDropDown();
        pricingPage.pricingPromotions();
    }
    @And("User navigate to Order entry tab and User enters value to all the input box in Order entry page")
    public void userNavigateToOrderEntryTabAndUserEntersValueToAllTheInputBoxInOrderEntryPage()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.NavigateDifferentTabs("Order entry");
        orderEntryPage=new OrderEntryPage(driver,scenario);
        orderEntryPage.deliveryContact();
        orderEntryPage.firstName();
        orderEntryPage.telePhone();
        orderEntryPage.emailAddress();
        orderEntryPage.defaultOrderTypeDropDown();
        //orderEntryPage.initialProductsDropDown();
        //orderEntryPage.standingOrderCodeDropDown();
        orderEntryPage.authorizedProductsDropDown();
        orderEntryPage.defaultcigUOMDropDown();
        orderEntryPage.prePriceDropDown();
        orderEntryPage.allocationRank();
        orderEntryPage.allocationFactor();
        orderEntryPage.backOrderDropDown();
        //orderEntryPage.standardOrderDropDown();
        orderEntryPage.salesHoldDropDown();
    }

    @And("User navigate to Shipping tab and User enters value to all the input box in Shipping page")
    public void userNavigateToShippingTabAndUserEntersValueToAllTheInputBoxInShippingPage()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.NavigateDifferentTabs("Shipping");
        shippingPage=new ShippingPage(driver,scenario);
        shippingPage.daysToShipTextBox();
        shippingPage.deliveryDistanceMiTextBox();
        shippingPage.deliveryDistanceKmTextBox();
        shippingPage.gpsLongitudeTextBox();
        shippingPage.gpsLatitudeTextBox();
       // shippingPage.shipLocationDropDown();
        shippingPage.freightZoneDropDown();
        shippingPage.freightMethodDropDown();
        shippingPage.freightBaseDropDown();
    }

    @Then("User clicks on Copy button and popup should display in ERP")
    public void userClicksOnCopyButtonAndPopupShouldDisplayInERP()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        //customerInquiryPageERP.clickOnCustomerAccIndex();
        //customerInquiryPageERP.selectCustomerAccNoPopup();
        customerInquiryPageERP.clickOnCopyButton();
    }

    @And("User should enter required details in ERP Copy popup")
    public void userShouldEnterRequiredDetailsInERPCopyPopup()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.copyCustomerInqPopup();
        //customerInquiryPageERP.confirmationPopup();
        customerInquiryPageERP.validateSaveConfirmationPopup();
        customerInquiryPageERP.SaveButtonOK();
    }

    @Then("User clicks on Save button before adding values to ignition")
    public void userClicksOnSaveButtonBeforeAddingValuesToIgnition()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        //customerInquiryPageERP.BillNo();
        customerInquiryPageERP.DescrVal();
        customerInquiryPageERP.Save_ButtonClick();
        customerInquiryPageERP.validateSaveConfirmationPopup();
        customerInquiryPageERP.SaveButtonOK();
    }

    @And("User navigate to Ignition tab in ERP")
    public void userNavigateToIgnitionTabInERP()
    {
        if(flag2==false)
        {
            customerInquiryPageERP = new CustomerInquiryPageERP(driver, scenario);
            customerInquiryPageERP.NavigateDifferentTabs("TELUS OMS");
            ignitionPageERP = new IgnitionPageERP(driver, scenario);
            ignitionPageERP.ValidateIgnition();
            currentURL = driver.getCurrentUrl();
            flag2=true;
        }
        ignitionPageERP=new IgnitionPageERP(driver,scenario);
        ignitionPageERP.cancelPopup();
    }

    @Then("User clicks on Create new button and standing PO popup appeared in ERP")
    public void userClicksOnCreateNewButtonAndStandingPOPopupAppearedInERP()
    {
        ignitionPageERP= new IgnitionPageERP(driver,scenario);
        ignitionPageERP.ValidateIgnition();
        ignitionPageERP.ClickOnNewButton();
    }

    @And("User selects {int} day from current date and {int} day from end date and Select Payment processing in ERP")
    public void userSelectsDayFromCurrentDateAndDayFromEndDateAndSelectPaymentProcessingInERP( int arg0, int arg1)
    {
        ignitionPageERP= new IgnitionPageERP(driver,scenario);
        ignitionPageERP.ValidateAddStandingPO();
        ignitionPageERP.ClickOnStartDateCalender();
        ignitionPageERP.SelectStartDate(arg0);
        ignitionPageERP.ClickOnEndDateCalender();
        ignitionPageERP.SelectEndDate(arg1);
        ignitionPageERP.POInputBox();
        ignitionPageERP.ClickOnAdd();
        ignitionPageERP.PaymentProcessingDropdown();
    }

    @Then("User selects time for order time for different days in ERP")
    public void userSelectsTimeForOrderTimeForDifferentDaysInERP()
    {
        ignitionPageERP= new IgnitionPageERP(driver,scenario);
        List<WebElement> Clocks= HelpersMethod.FindByElements(driver,"xpath","//div[@class='ignition-call-list-schedule-details row']/descendant::span[@class='k-icon k-i-clock']");
        for(int i=1;i<= Clocks.size()-1;i++)
        {
            ignitionPageERP.ClickClockIcon(i);
            ignitionPageERP.SelectHoursForAllDays();
            ignitionPageERP.SelectMinForAllDays();
            ignitionPageERP.ClickOnSetButton();
        }
    }

    @And("User selects Order taker from drop down in ERP")
    public void userSelectsOrderTakerFromDropDownInERP()
    {
        ignitionPageERP= new IgnitionPageERP(driver,scenario);
        List<WebElement> OrderTakers=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'ignition-call-list-schedule-details row')]/descendant::span[contains(@class,'k-widget k-dropdown')]");
        for(int i=1;i<=OrderTakers.size();i++)
        {
            ignitionPageERP.ClickOrderTracker(i);
        }
    }

    @Then("User clicks on Save button in ERP")
    public void userClicksOnSaveButtonInERP()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.Save_ButtonClick();
        customerInquiryPageERP.validateSaveConfirmationPopup();
        customerInquiryPageERP.SaveButtonOK();
    }

    @Then("User clicks on Create new button for second Standing PO")
    public void userClicksOnCreateNewButtonForSecondStandingPO()
    {
        ignitionPageERP= new IgnitionPageERP(driver,scenario);
        ignitionPageERP.ClickOnNewButton();
    }

    @Then("User enters Standing PO# in search bar and select Standing PO# in ERP")
    public void userEntersStandingPOInAddFilterAndSelectStandingPOInERP()
    {
        ignitionPageERP= new IgnitionPageERP(driver,scenario);
        ignitionPageERP.SearchPONo();
        ignitionPageERP.SelectPONo();
    }

    @And("User clicks on Edit button and handle edit statnding PO# popup in ERP")
    public void userClicksOnEditButtonAndHandleEditStatndingPOPopup()
    {
        ignitionPageERP= new IgnitionPageERP(driver,scenario);
        ignitionPageERP.ClickEditButton();
        ignitionPageERP.EditPONo();
    }

    @Then("User should clear the search value in search bar in ERP")
    public void userShouldClearTheSearchValueInSearchBar()
    {
        ignitionPageERP= new IgnitionPageERP(driver,scenario);
        ignitionPageERP.clearSearchBarValue();
    }

    @Then("User selects Standing PO# from the grid and click Delete in ERP")
    public void userSelectsStandingPOFromTheGridAndClickDeleteInERP()
    {
        List<WebElement> Pos=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]");
        for(int i=0;i<= Pos.size()-1;i++)
        {
            ignitionPageERP = new IgnitionPageERP(driver, scenario);
            ignitionPageERP.selectPONoForDelete(i);
            ignitionPageERP.clickDelete();
            ignitionPageERP.confirmationPopUp();
        }
    }

    @Then("Add note in popup in ERP cust inq")
    public void addNoteInPopupInERPCustInq(DataTable tabledata)
    {
        customerInquiryPageERP = new CustomerInquiryPageERP(driver, scenario);
        List<List<String>> Cust_Note = tabledata.asLists(String.class);
        customerInquiryPageERP.clickOnNote();
        customerInquiryPageERP.validateNotePopup();
        customerInquiryPageERP.Add_Customer_Note(Cust_Note.get(0).get(0));
    }

    @And("User should select the Alert Type and Alert location to display notes in ERP cust inq")
    public void userShouldSelectTheAlertTypeAndAlertLocationToDisplayNotesInERPCustInq(DataTable tabledata)
    {
        customerInquiryPageERP = new CustomerInquiryPageERP(driver, scenario);
        List<List<String>> Alerts=tabledata.asLists(String.class);
        customerInquiryPageERP.Select_AlertType_Location(Alerts.get(0).get(0),Alerts.get(0).get(1),Alerts.get(0).get(2));
    }

    @Then("Click on Save button in ERP cust inq")
    public void clickOnSaveButtonInERPCustInq()
    {
        customerInquiryPageERP = new CustomerInquiryPageERP(driver, scenario);
        customerInquiryPageERP.Save_Note_Button();
    }

    @Then("PO has been saved in ERP")
    public void poHasBeenSavedInERP()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.validateSaveConfirmationPopup();
        customerInquiryPageERP.SaveButtonOK();
    }
}
