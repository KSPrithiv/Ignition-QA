package stepDefination_DSD_OMS.PaymentInfoSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.paymentInfo.NewPaymentMethodPage;
import pages_DSD_OMS.paymentInfo.PaymentInfoPage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
public class PaymentInfoPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static boolean flag=false;
    static boolean flag1=false;
    static String currentURL=null;

    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;
    static PaymentInfoPage paymentInfoPage;
    static NewPaymentMethodPage newPaymentMethodPage;

    @Before
    public void LaunchBrowser(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Payment")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForPayment() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for Payment")
    public void user_is_on_home_pageForPayment() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for Payment")
    public void user_navigate_to_client_sideForPayment() throws InterruptedException, AWTException
    {
        boolean result=false;
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
            flag=true;
        }
    }

    @Given("User should be on Client side page And User should navigate to PaymentInfo tab")
    public void userShouldBeOnClientSidePage()
    {
        exists=false;
        try
        {
            paymentInfoPage=new PaymentInfoPage(driver,scenario);
            if(flag1==false)
            {
                paymentInfoPage.NavigateToPaymentInfo();
                flag1=true;
            }
            paymentInfoPage.HandleError_Page();
            paymentInfoPage.Refresh_Page();
            paymentInfoPage.ValidatePaymentInfo();
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    @Then("User should Click on Add Payment info button and should navigate to new payment info")
    public void userShouldClickOnAddPaymentInfoButtonAndShouldNavigateToNewPaymentInfo()
    {
        exists=false;
        try
        {
            paymentInfoPage=new PaymentInfoPage(driver,scenario);
            paymentInfoPage.clickOnCustomerAccountIndex();
            paymentInfoPage.SelectCustomerAccount();
            paymentInfoPage.Click_Plus();
            newPaymentMethodPage=new NewPaymentMethodPage(driver,scenario);
            newPaymentMethodPage.Validate_NewPaymentInfo();
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    @Then("User enters all the details required to create payment info for Bank account option")
    public void userEntersAllTheDetailsRequiredToCreatePaymentInfoForBankAccountOption(DataTable tabledata)
    {
        exists=false;
        try
        {
            List<List<String>> AccHolderDetails=tabledata.asLists(String.class);
            newPaymentMethodPage=new NewPaymentMethodPage(driver,scenario);
            newPaymentMethodPage.PaymentType();
            newPaymentMethodPage.PaymentDropDown("Bank account");
            newPaymentMethodPage.EnterFirstName(AccHolderDetails.get(0).get(0));
            newPaymentMethodPage.EnterLastName(AccHolderDetails.get(0).get(1));
            newPaymentMethodPage.Click_AccType();
            newPaymentMethodPage.Select_AccType(AccHolderDetails.get(0).get(2));
            newPaymentMethodPage.Enter_Route();
            newPaymentMethodPage.Enter_AccountNo();
            newPaymentMethodPage.SetPreferenceCheckbox();
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    @And("User clicks on Save button and navigate to Payment Info page")
    public void userClicksOnSaveButtonAndNavigateToPaymentInfoPage()
    {
        exists=false;
        try
        {
            newPaymentMethodPage=new NewPaymentMethodPage(driver,scenario);
            newPaymentMethodPage.Click_Save();
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }
}
