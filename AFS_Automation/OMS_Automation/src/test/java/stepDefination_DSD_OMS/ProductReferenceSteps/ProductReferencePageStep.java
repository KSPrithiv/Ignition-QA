package stepDefination_DSD_OMS.ProductReferenceSteps;

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
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.orderGuide.OrderGuidePage;
import pages_DSD_OMS.parOrder.ParOrderPage;
import pages_DSD_OMS.productReference.ProductReferencePage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.util.List;

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
    static boolean flag2=false;
    static String currentURL=null;


    LoginPage loginpage;
    HomePage homepage;
    OrderEntryPage orderpage;
    CreateOGPage createOGPage;
    ProductReferencePage productReferencePage;
    OrderGuidePage orderGuidePage;
    ParOrderPage parOrderPage;

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
            //Assert.assertEquals(title, "Ignition - Admin");
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

    @Given("User must be on Order Entry Page to select OG for Product reference")
    public void userMustBeOnOrderEntryPageToSelectOGForProductReference() throws InterruptedException, AWTException
    {
        if (flag2 == false)
        {
            exists = false;
            WebElement WebEle;
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]",driver))
            {
                //Code to navigate to Order guide
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                HelpersMethod.navigate_Horizantal_Tab(driver, "Order Guides", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                currentURL = driver.getCurrentUrl();
                exists=true;
            }
            Assert.assertEquals(exists,true);
            flag2=true;
        }
    }

    @And("User should navigate to OG and select {string} from grid for Product reference")
    public void userShouldNavigateToOGAndSelectFromGridForProductReference(String OG) throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        exists= orderpage.HandleError_Page();
        if(exists==true)
        {
            orderGuidePage=new OrderGuidePage(driver,scenario);
            orderGuidePage.naviateToOG();
        }
        parOrderPage = new ParOrderPage(driver, scenario);
        parOrderPage.Refresh_Page(currentURL);
        orderGuidePage=new OrderGuidePage(driver,scenario);
        exists=false;
        exists = orderGuidePage.ValidateOG();
        Assert.assertEquals(exists, true);
        //Code to select OG from grid
        exists = false;
        exists = orderGuidePage.OGSearchBox(OG);
        Assert.assertEquals(exists, true);
        orderGuidePage.SearchOGSelect(OG);
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

    @And("Drag and Drop the table header and listout grouping")
    public void dragAndDropTheTableHeaderAndListoutGrouping(DataTable tabledata)
    {
        List<List<String>> tableHeader = tabledata.asLists(String.class);
        productReferencePage=new ProductReferencePage(driver,scenario);
        productReferencePage.DragAndDrop(tableHeader.get(0).get(0));
        productReferencePage.readGroupingDetails();
    }

    @And("User search for product using Add filter in Product reference")
    public void userSearchForProductUsingAddFilterInProductReference()
    {
        productReferencePage=new ProductReferencePage(driver,scenario);
        String prodNo=productReferencePage.readProductNo();
        productReferencePage.AddfilterProductReference("Product #",prodNo);
    }
}