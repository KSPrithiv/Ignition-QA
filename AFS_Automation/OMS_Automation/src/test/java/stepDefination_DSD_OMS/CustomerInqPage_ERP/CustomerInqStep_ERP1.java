package stepDefination_DSD_OMS.CustomerInqPage_ERP;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages_DSD_OMS.customerInquiry_DSD.CustomerInquiryPage;
import pages_DSD_OMS.customerInquiry_ERP.*;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import util.TestBase;

import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CustomerInqStep_ERP1
{
    /* Created by Divya.Ramadas */
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

    @And("User should enter required details in ERP Copy popup and user should cancel copy")
    public void userShouldEnterRequiredDetailsInERPCopyPopupAndUserShouldCancelCopy()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.copyCustomerInqPopupCancel();
    }

    @Then("User refreshes customer inq page in ERP")
    public void userRefreshesCustomerInqPageInERP()
    {
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.Refresh_Page();
    }

    @And("User should select customer account# in customer inq in ERP")
    public void userShouldSelectCustomerAccountInCustomerInqInERP(DataTable dataTable)
    {
        List<List<String>> firstFilterValue = dataTable.asLists(String.class);
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.clickOnCustomerAccountIndex();
        customerInquiryPageERP.validateCustomerAccountIndex();
        customerInquiryPageERP.selectCustomerAccount(firstFilterValue.get(0).get(0));
    }

    @Then("User should click on customer note icon in customer inq in ERP page and validate that note added is existing in popup")
    public void userShouldClickOnCustomerNoteIconInCustomerInqInERPPageAndValidateThatNoteAddedIsExistingInPopup(DataTable dataTable)
    {
        List<List<String>> custNote=dataTable.asLists(String.class);
        customerInquiryPageERP=new CustomerInquiryPageERP(driver,scenario);
        customerInquiryPageERP.clickOnNote();
        customerInquiryPageERP.validateNotePopup();
        customerInquiryPageERP.validateNoteInPopup(custNote.get(0).get(0));
        customerInquiryPageERP.clickOnOkButtonOfCustNote();
    }

    @Then("User clicks on Save button without entering customer name in ERP env")
    public void userClicksOnSaveButtonWithoutEnteringCustomerNameInERPEnv()
    {

    }
    
    @Then("User click on New button in ERP Customer Inq for copy of customer inq")
    public void userClickOnNewButtonInERPCustomerInqForCopyOfCustomerInq() {
    }

    @And("User should click on save button to save copy of customer inq in ERP")
    public void userShouldClickOnSaveButtonToSaveCopyOfCustomerInqInERP() {
    }
}
