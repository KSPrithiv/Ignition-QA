package stepDefination_DSD_OMS.GeneralSettingsStepDef;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.generalSettingsPage.EmailsPage;
import pages_DSD_OMS.generalSettingsPage.MasterPage;
import pages_DSD_OMS.generalSettingsPage.MerchantPage;
import pages_DSD_OMS.generalSettingsPage.NoticesPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;

/**
 * @Project OMS_DSD
 * @Author
 */
public class GeneralSettingPageStep
{
    /* Created by  */
    WebDriver driver;
    Scenario scenario;

    static boolean exists = false;
    static boolean flag=false;
    static boolean flag1=false;

    LoginPage loginpage;
    HomePage homepage;
    AdminHomePage adminHomePage;
    NoticesPage noticespage;
    EmailsPage emailspage;

    MerchantPage merchantpage;

    MasterPage masterpage;

    @Before
    public void LaunchBrowser(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }



    @And("User Navigates to Notices page")
    public void user_click_on_Notices() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            noticespage =new NoticesPage(driver, scenario);
            noticespage.ClicOnHumburger();
            noticespage.NavigateToNotices();
            noticespage.ClickPermissionBy();
            noticespage.SelectCompany();
            flag1=true;
        }
    }

    @And("User Navigates to Emails page")
    public void user_click_on_Emails() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            emailspage = new EmailsPage(driver, scenario);
            emailspage.ClicOnHumburger();
            emailspage.NavigateToEmails();
            //emailspage.CloseHumburger();
            emailspage.clickSMTPConfiguration();
            emailspage.clickTestEmail();
            emailspage.EnterToEmail();
            emailspage.EnterSubject();
            emailspage.EnterBody();
            flag1=true;
        }
    }

    @And("User Navigates to Merchant page")
    public void user_click_on_Merchant() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            merchantpage = new MerchantPage(driver, scenario);
            merchantpage.ClicOnHumburger();
            merchantpage.NavigateToMerchant();
            merchantpage.ClickPermissionBy();
            merchantpage.SelectCompany();
            flag1=true;
        }
    }

    @And("User Navigates to Master page")
    public void user_click_on_MasterPage() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            masterpage = new MasterPage(driver, scenario);
            masterpage.ClicOnHumburger();
            masterpage.NavigateToMaster();
//            masterpage.ClickPermissionBy();
//            masterpage.SelectCompany();
            flag1=true;
        }
    }

    @And("User filters from Available Apps")
    public void user_filter_AvailableApps() throws InterruptedException, AWTException
    {
//        if(flag1==false)
//        {
            masterpage = new MasterPage(driver, scenario);
            masterpage.FilterAvailableAppsFromDropDown("WMS");
//            flag1=true;
//        }
    }

    @And("User changes on Application menu")
    public void user_donot_save_changes() throws InterruptedException, AWTException
    {

            masterpage = new MasterPage(driver, scenario);
            masterpage.ApplicationMenuLabelInput();
            masterpage.Click_SaveButton();
            masterpage.Click_okButton();
            masterpage.Click_resetButton();
            masterpage.Click_SaveButton();
            masterpage.Click_okButton();

    }

    @And("User Sends Test Email from Emails Page")
    public void user_send_test_Emails() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            emailspage = new EmailsPage(driver, scenario);
            emailspage.clickSMTPConfiguration();
            emailspage.clickTestEmail();
            emailspage.EnterToEmail();
            emailspage.EnterSubject();
            emailspage.EnterBody();
            emailspage.clickSendEmail();
            flag1=true;
        }
    }

    @And("User Admin adds new Merchant from Merchant Gateway Page")
    public void user_add_newMerchant() throws InterruptedException, AWTException
    {

            merchantpage = new MerchantPage(driver, scenario);
            merchantpage.ClickOnAddMerchant();
            merchantpage.Entermerchantcredentials();
            merchantpage.MerchSaveButton();


    }

    @And("User Admin edit Merchant from Merchant Gateway Page")
    public void user_edit_newMerchant() throws InterruptedException, AWTException
    {

        merchantpage = new MerchantPage(driver, scenario);
        merchantpage.ClickOnEditMerchant();
        merchantpage.Selectmerchantprovider();
        merchantpage.MerchSaveButton();


    }

    @And("User Admin delete Merchant from Merchant Gateway Page")
    public void user_delete_newMerchant() throws InterruptedException, AWTException
    {

        merchantpage = new MerchantPage(driver, scenario);
        merchantpage.ClickOnDeleteMerchant();
        merchantpage.okButton_delete();


    }

    @And("User Admin Override Merchant from Merchant Gateway Page")
    public void user_Override_newMerchant() throws InterruptedException, AWTException
    {

        merchantpage = new MerchantPage(driver, scenario);
        merchantpage.ClickOnOverrideMerchant();
        merchantpage.addOverride_button();
        merchantpage.SelectOwnerType();

    }
    @And("User Admin uses SSL from Merchant Gateway Page")
    public void user_adds_ssl() throws InterruptedException, AWTException
    {

            merchantpage = new MerchantPage(driver, scenario);
            merchantpage.Click_SSLButton();

    }

    @And("User clicks Yes on popup")
    public void user_yes_save() throws InterruptedException, AWTException
    {

            merchantpage = new MerchantPage(driver, scenario);
            merchantpage.Click_YesButton();

    }
    @And("User enabled Email Template from Emails Page")
    public void user_enable_Email_template() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            emailspage = new EmailsPage(driver, scenario);
            emailspage.ClicOnHumburger();
            emailspage.NavigateToEmails();
            //emailspage.CloseHumburger();
            emailspage.clickemailtemplates();
            emailspage.enablePendingRegistrationApproval();
            emailspage.emailTemplateCheck();
            emailspage.SelectEmailTemplateFromDropDown("Pending registration approved");
            flag1=true;
        }
    }

    @And("User disabled Email Template from Emails Page")
    public void user_disable_Email_template() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            emailspage = new EmailsPage(driver, scenario);
            emailspage.ClicOnHumburger();
            emailspage.NavigateToEmails();
            //emailspage.CloseHumburger();
            emailspage.clickemailtemplates();
            emailspage.disablePasswordRequest();
            emailspage.emailTemplateCheck();
            emailspage.SelectEmailTemplateFromDropDown("Password request");
            flag1=true;
        }
    }

    @And("User selects Email Template from Emails Page")
    public void user_select_Email_template() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            emailspage = new EmailsPage(driver, scenario);
            emailspage.ClicOnHumburger();
            emailspage.NavigateToEmails();
            emailspage.clickemailtemplates();
            emailspage.emailTemplateCheck();
            emailspage.SelectEmailTemplateFromDropDown("Change password");
            flag1=true;
        }
    }

    @And("Regular User selects Email Template from Emails Page")
    public void regular_user_select_Email_template() throws InterruptedException, AWTException
    {
//        if(flag1==false)
//        {
            emailspage = new EmailsPage(driver, scenario);
            emailspage.ClicOnHumburger();
            emailspage.NavigateToEmails();
            emailspage.ClickPermissionBy();
            emailspage.SelectUser_PermissionBy();
            emailspage.NavigateToEmails();
            emailspage.ClickPermissionBy();
            emailspage.SelectUserRole();
            emailspage.RegularUser_clickemailtemplates();
            emailspage.SelectEmailTemplateFromDropDown("Successful registration");
//            flag1=true;
//        }
    }

    @And("User checks for Default & Delete Custom e-mail button")
    public void user_check_default_DeleteEmail() throws InterruptedException, AWTException
    {
//        if(flag1==false)
//        {
            emailspage = new EmailsPage(driver, scenario);
            emailspage.Default_DeleteCustomemail_Check();
//            flag1=true;
//        }
    }


    @And("User Changes in email Body")
    public void user_changes_emailBody() throws InterruptedException, AWTException
    {
//        if(flag1==false)
//        {
            emailspage = new EmailsPage(driver, scenario);
            emailspage.EnterEmailBody();
            emailspage.Click_SaveButton();
            emailspage.Click_okButton();
//            flag1=true;
//        }
    }

    @And("User clicks on reset to Default")
    public void user_click_reset_Default() throws InterruptedException, AWTException
    {
//        if(flag1==false)
//        {
        emailspage = new EmailsPage(driver, scenario);
        emailspage.Click_resetButton();
//            flag1=true;
//        }
    }

    @And("User clicks on delete Custom e-mail button")
    public void user_click_delete_custom_email() throws InterruptedException, AWTException
    {
//        if(flag1==false)
//        {
        emailspage = new EmailsPage(driver, scenario);
        emailspage.Click_delete_custom_email();
        emailspage.Click_Yesbutton_newPopUp();
//            flag1=true;
//        }
    }

    @Then("User click on Add Notice and Select Destination with StartEnd Dates")
    public void user_create_new_Notice_enter_StartEndDates() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
        noticespage.ClickOnAddNotice();
//        noticespage.EnterStartDate(2);
//        noticespage.EnterEndDate(3);
        noticespage.SelectDestination();
    }

    @Then("User click on Add Filter with status and click print")
    public void user_add_filter_click_print() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
        noticespage.ClickOnAddFilterStatus("Active");
        noticespage.ClickOnApplyFilter();
        //noticespage.ClickPrintNotice();
    }

    @Then("User click on Add Filter with description")
    public void user_add_filter_description() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
        noticespage.ClickOnAddFilterDesc("TestDescription");
        noticespage.ClickOnApplyFilter();
    }

    @Then("User click on Add Filter with destination")
    public void user_add_filter_destination() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
        noticespage.ClickOnAddFilterDestination("TestDestination");
        noticespage.ClickOnApplyFilter();
    }

    @Then("User click on Add Filter with Start Date")
    public void user_add_filter_start_Date() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
        noticespage.ClickFilterbyStartDate(2);
        noticespage.ClickOnApplyFilter();
    }

    @Then("User click on Add Filter with End Date")
    public void user_add_filter_end_Date() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
        noticespage.ClickFilterbyEndDate(3);
        noticespage.ClickOnApplyFilter();
    }

    @Then("User enters Mandatory fields for Create Notice")
    public void user_enters_Mandatoryfields() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
        noticespage.DeliveryDaysInputFromDropDown();
        noticespage.NoticeNameInput();
        noticespage.NoticeDescInput();
    }

    @And("User enter route recipient & click on Create Notice")
    public void user_CreateNotice_withrecipient() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
//        noticespage.SelectDestination();
        noticespage.ClickOnAddRecipient();
        noticespage.ClickOnRouteRecipient();
        noticespage.RouteFirstCheckBox();
        noticespage.RouteAddButton();
        noticespage.CreateNoticeButton();
        noticespage.ClickOkPopUp();
    }

    @And("User enter branch recipient & click on Create Notice")
    public void user_branch_CreateNotice_withrecipient() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
//        noticespage.SelectDestination();
        noticespage.ClickOnAddRecipient();
        noticespage.ClickOnbranchRecipient();
        noticespage.RouteFirstCheckBox();
        noticespage.RouteAddButton();
        noticespage.CreateNoticeButton();
        noticespage.ClickOkPopUp();

    }

    @And("User enter chain recipient & click on Create Notice")
    public void user_chain_CreateNotice_withrecipient() throws InterruptedException, AWTException
    {
        noticespage =new NoticesPage(driver, scenario);
//        noticespage.SelectDestination();
        noticespage.ClickOnAddRecipient();
        noticespage.ClickOnChainRecipient();
        noticespage.RouteFirstCheckBox();
        noticespage.RouteAddButton();
        noticespage.CreateNoticeButton();
        noticespage.ClickOkPopUp();

    }

}
