package stepDefination_DSD_OMS.ARInquirySteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.aRInquiry.ARInquiryPage;
import pages_DSD_OMS.aRInquiry.PostPaymentPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class ARInquiryPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;
    static boolean flag1=false;
    static String currentURL;

    static LoginPage loginpage;
    static HomePage homepage;
    static ARInquiryPage arInquiryPage;
    static PostPaymentPage postPaymentPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for AR Inquiry")
    public void userEntersURLAndIsonLoginPageAndEnteredCredentialsForARInquiry() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.Userword());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for AR Inquiry")
    public void userIsOnHomePageForARInquiry()
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for AR Inquiry")
    public void userNavigateToClientSideForARInquiry() throws InterruptedException
    {
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
            arInquiryPage=new ARInquiryPage(driver,scenario);
            currentURL=arInquiryPage.NavigateToAR();
            flag=true;
        }
    }

    @Given("User must be on Client side and select AR Inquiry")
    public void userMustBeOnClientSideAndSelectARInquiry()
    {
        scenario.log(currentURL);
        arInquiryPage=new ARInquiryPage(driver,scenario);
        arInquiryPage.HandleError_Page();
        HelpersMethod.Refresh(driver);
    }

    @When("User navigated to AR Inquiry validate the page")
    public void userNavigatedToARInquiryValidateThePage()
    {
        arInquiryPage=new ARInquiryPage(driver,scenario);
        arInquiryPage.Validate_ARInquiry();
    }

    @And("User should select Customer Account#")
    public void userShouldSelectCustomerAccount()
    {
        if(flag1==false)
        {
            arInquiryPage = new ARInquiryPage(driver, scenario);
            arInquiryPage.Click_CustomerAccount();
            flag1=true;
        }
    }

    @Then("User search for invoice using Add filter button")
    public void userSearchForInvoiceUsingAddFilterButton()
    {
        arInquiryPage=new ARInquiryPage(driver,scenario);
        arInquiryPage.ReadingInvoice();
        arInquiryPage.AddFilterClick();
        arInquiryPage.SearchInvoice();
    }

    @Then("User should select Invoice check box")
    public void userShouldSelectInvoiceCheckBox()
    {
        arInquiryPage=new ARInquiryPage(driver,scenario);
        arInquiryPage.Click_CheckBox();
    }

    @And("User should click on Post button and navigated to PostPayment page")
    public void userShouldClickOnPostButtonAndNavigatedToPostPaymentPage()
    {
        arInquiryPage=new ARInquiryPage(driver,scenario);
        arInquiryPage.Click_Post();
        postPaymentPage=new PostPaymentPage(driver,scenario);
        postPaymentPage.ValidatePostPayment();
    }

    @Then("User should select Add payment method and then user click on Post button")
    public void userShouldClickOnAddPaymentMethodAndThenUserClickOnPostButton()
    {
        postPaymentPage=new PostPaymentPage(driver,scenario);
        postPaymentPage.SelectPayment();
        postPaymentPage.Click_PostBut();
    }

    @Then("User should click on Add payment button and add details of payment method")
    public void userShouldClickOnAddPaymentButtonAndAddDetailsOfPaymentMethod(DataTable tabledata)
    {
        List<List<String>> AccHolderDetails=tabledata.asLists(String.class);
        postPaymentPage=new PostPaymentPage(driver,scenario);
        postPaymentPage.AddNewPayment();
        postPaymentPage.ValidateAddingPaymentDetails();
        postPaymentPage.PaymentType();
        postPaymentPage.PaymentDropDown("Bank account");
        postPaymentPage.EnterFirstName(AccHolderDetails.get(0).get(0));
        postPaymentPage.EnterLastName(AccHolderDetails.get(0).get(1));
        postPaymentPage.Click_AccType();
        postPaymentPage.Select_AccType(AccHolderDetails.get(0).get(2));
        postPaymentPage.Enter_Route();
        postPaymentPage.Enter_AccountNo();
        postPaymentPage.SetPreferenceCheckbox();
        postPaymentPage.NewPaymentOkBut();
    }

    @Then("User search for invoice using Search bar")
    public void userSearchForInvoiceUsingSearchBar()
    {
        arInquiryPage=new ARInquiryPage(driver,scenario);
        arInquiryPage.ReadingInvoice();
        arInquiryPage.SearchBar();
        arInquiryPage.SearchInvoice();
    }

    @Then("User should select Add payment method and then user click on Cancel button")
    public void userShouldSelectAddPaymentMethodAndThenUserClickOnCancelButton()
    {
        postPaymentPage=new PostPaymentPage(driver,scenario);
        postPaymentPage.SelectPayment();
        postPaymentPage.CancelButton();
        postPaymentPage.cancelPopup();
    }
}
