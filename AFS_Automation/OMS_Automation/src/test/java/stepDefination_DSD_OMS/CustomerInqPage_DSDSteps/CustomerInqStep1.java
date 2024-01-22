package stepDefination_DSD_OMS.CustomerInqPage_DSDSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages_DSD_OMS.customerInquiry_DSD.*;
import util.TestBase;

import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CustomerInqStep1
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;

    static CustomerInquiryPage customerInquiryPage;
    static IgnitionPage ignitionPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
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

    @Then("User refreshes customer inq page")
    public void userRefreshesCustomerInqPage()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.refreshPage();
    }

    @And("User should select customer account# in customer inq")
    public void userShouldSelectCustomerAccountInCustomerInq(DataTable dataTable)
    {
        List<List<String>> firstFilterValue = dataTable.asLists(String.class);
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.clickOnCustomerAccountIndex();
        customerInquiryPage.validateCustomerAccountIndex();
        customerInquiryPage.selectCustomerAccount(firstFilterValue.get(0).get(0));
        customerInquiryPage.NoNotePopHandling();
    }

    @Then("User should click on customer note icon in customer inq page and validate that note added is existing in popup")
    public void userShouldClickOnCustomerNoteIconInCustomerInqPageAndValidateThatNoteAddedIsExistingInPopup(DataTable datatable)
    {
        List<List<String>> custNote=datatable.asLists(String.class);
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.clickOnNote();
        customerInquiryPage.validateNotePopup();
        customerInquiryPage.validateNoteInPopup(custNote.get(0).get(0));
        customerInquiryPage.clickOnOkButtonOfCustNote();
    }

    @Then("User clicks on Copy button and popup should display after entering values should cancel copy")
    public void userClicksOnCopyButtonAndPopupShouldDisplayAfterEnteringValuesShouldCancelCopy() throws InterruptedException
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.ClickCopy();
        customerInquiryPage.CopyCutomerPopupCancel();
    }

    @Then("User clicks on Save button without entering customer name")
    public void userClicksOnSaveButtonWithoutEnteringCustomerName() throws InterruptedException
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.BillNo();
        customerInquiryPage.StoreNo();
        customerInquiryPage.DeptNo();
        customerInquiryPage.Save_ButtonClick();
        customerInquiryPage.popUpForCustomerNameRequired();
    }

    @Then("User click on New button to cancel creation of customer inq")
    public void userClickOnNewButtonToCancelCreationOfCustomerInq()
    {
        customerInquiryPage = new CustomerInquiryPage(driver, scenario);
        customerInquiryPage.ValidateCustomInq();
        customerInquiryPage.New_ButtonClick();
    }

    @Then("User click on New button for copy of customer inq")
    public void userClickOnNewButtonForCopyOfCustomerInq()
    {
        customerInquiryPage = new CustomerInquiryPage(driver, scenario);
        customerInquiryPage.ValidateCustomInq();
        customerInquiryPage.New_ButtonClick();
    }

    @And("User should click on save button to save copy of customer inq")
    public void userShouldClickOnSaveButtonToSaveCopyOfCustomerInq() throws InterruptedException
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.Save_ButtonClick();
        customerInquiryPage.validateSaveConfirmationPopup();
        customerInquiryPage.SaveButtonOK();
    }

    @Then("User should navigate to Telus tab")
    public void userShouldNavigateToTelusTab()
    {
        customerInquiryPage = new CustomerInquiryPage(driver, scenario);
        customerInquiryPage.NavigateDifferentTabs("TELUS OMS");
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        ignitionPage = new IgnitionPage(driver, scenario);
        ignitionPage.ValidateIgnition();
    }

    @And("User click on Payment processing and verify visibility of System default Realtime charge option")
    public void userClickOnPaymentProcessingAndVerifyVisibilityOfSystemDefaultRealtimeChargeOption()
    {
        customerInquiryPage=new CustomerInquiryPage(driver,scenario);
        customerInquiryPage.clickOnPaymentProcessing();
        customerInquiryPage.verifySystemDefaultRealTime();
    }
}
