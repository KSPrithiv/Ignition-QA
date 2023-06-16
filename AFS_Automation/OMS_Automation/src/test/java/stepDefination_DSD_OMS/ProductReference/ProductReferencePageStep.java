package stepDefination_DSD_OMS.ProductReference;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.orderGuide.OrderGuidePage;
import pages_DSD_OMS.parOrder.ParOrderPage;
import pages_DSD_OMS.productReference.ProductReferencePage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
public class ProductReferencePageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static boolean exists = false;
    static boolean flag=false;
    static boolean flag1=false;

    LoginPage loginpage;
    HomePage homepage;
    OrderEntryPage orderpage;
    CreateOGPage createOGPage;
    ProductReferencePage productReferencePage;

    @Before
    public void LaunchBrowser(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for PR")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForPR() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for PR")
    public void user_is_on_home_pageForPR() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for PR")
    public void user_navigate_to_client_sideForPR() throws InterruptedException, AWTException
    {
        boolean result=false;
        if(flag==false)
        {
            homepage = new HomePage(driver,scenario);
            String title = driver.getTitle();
            Assert.assertEquals(title, "Ignition - Admin");
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
        }
    }

    @Then("User should select Order Entry tab for PR")
    public void user_should_select_order_entry_tabForPR() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Then("User selects Account# for PR")
    public void user_selects_accountForPR() throws InterruptedException, AWTException, ParseException {
        if(flag1==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.ChangeAccount();
            orderpage.PopUps_After_AccountChange();
            orderpage.Read_DeliveryDate();
            flag1=true;
        }
    }

    @Then("User clicks on Product reference tab")
    public void UserClicksOnProductReferenceTab()
    {
        productReferencePage=new ProductReferencePage(driver,scenario);
        productReferencePage.NavigateToProductReference();
        productReferencePage.ValidateProductReference();
    }

    @And("then assign the Customer Account# to first product")
    public void thenAssignTheCustomerAccountToFirstProduct()
    {
        productReferencePage=new ProductReferencePage(driver,scenario);
        productReferencePage.EnterCustomerAccount();
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ClickOnSave();
    }
}
