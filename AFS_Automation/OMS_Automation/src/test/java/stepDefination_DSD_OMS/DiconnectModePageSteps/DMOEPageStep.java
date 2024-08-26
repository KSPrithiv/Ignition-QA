package stepDefination_DSD_OMS.DiconnectModePageSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.disconnectedMode.DMOEPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class DMOEPageStep
{
    /* Created by Divya.Ramadas@afsi.com */
    private static boolean flag = false;
    private static boolean flag1=false;
    WebDriver driver;
    Scenario scenario;

    static DMOEPage dmoePage;
    static LoginPage loginpage;
    static HomePage homepage;
    static OrderEntryPage orderpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for DM")
    public void user_enters_url_and_is_on_login_page_and_entered_credentialsForDM() throws Exception
    {
        if(flag==false)
        {
            loginpage = new LoginPage(driver,scenario);
            loginpage.EnterUsername(TestBase.testEnvironment.username());
            loginpage.EnterPassword(TestBase.testEnvironment.password());
            loginpage.ClickSignin();
        }
    }

    @When("User is on Home Page for DM")
    public void user_is_on_home_pageForDM() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
        }
    }

    @Then("User navigate to Client side for DM")
    public void user_navigate_to_client_sideForDM() throws InterruptedException, AWTException
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

    @Then("User should select Order Entry tab for DM")
    public void user_should_select_order_entry_tabForDM() throws InterruptedException, AWTException
    {
        if(flag==false)
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
            flag=true;
        }
    }

    @Given("User should be in Order entry page")
    public void userShouldBeInOrderEntryPage() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        if(flag1==false)
        {
            orderpage.ValidateOE();
        }
        orderpage.HandleError_Page();
        orderpage.Refresh_Page2();
    }

    @When("User Clicks on network symbol and click on toggle button to navigate to disconnected mode")
    public void userClicksOnNetworkSymbolAndClickOnToggleButtonToNavigateToDisconnectedMode() throws InterruptedException, AWTException
    {
        if(flag1==false)
        {
            dmoePage = new DMOEPage(driver, scenario);
            dmoePage.NavigateToDM();
            dmoePage.DisconnectModeTaggle();
        }
    }

    @When("User Clicks on network symbol and click on toggle button to navigate to disconnected mode for cancel option")
    public void userClicksOnNetworkSymbolAndClickOnToggleButtonToNavigateToDisconnectedModeForCancelOption() throws InterruptedException, AWTException
    {
            dmoePage = new DMOEPage(driver, scenario);
            dmoePage.NavigateToDM();
            dmoePage.DisconnectModeTaggle();
    }

    @And("Then User selects cancel option in Disconnected mode popup")
    public void thenUserSelectsCancelOptionInDisconnectedModePopup()
    {
        dmoePage=new DMOEPage(driver,scenario);
        dmoePage.DisconnectModePopup();
        dmoePage.DisconnectModePopupCancel();
    }

    @And("Then User selects Go offline option in Disconnected mode popup")
    public void thenUserSelectsGoOfflineOptionInDisconnectedModePopup()
    {
        if(flag1==false)
        {
            dmoePage = new DMOEPage(driver, scenario);
            dmoePage.DisconnectModePopup();
            dmoePage.ClickGoToOffline();
        }
    }

    @Then("User should get Customer account# popup")
    public void userShouldGetCustomerAccountPopup()
    {
        if(flag1==false)
        {
            dmoePage = new DMOEPage(driver, scenario);
            dmoePage.ValidateCustomerAccountPopup();
        }
    }

    @And("User should select Customer Account# from popup and select the delivery date from popup wait till synchronized")
    public void userShouldSelectCustomerAccountFromPopupAndSelectTheDeliveryDateFromPopupWaitTillSynchronized()
    {
        if(flag1==false)
        {
            dmoePage = new DMOEPage(driver, scenario);
            dmoePage.SelectAccountNo();
            dmoePage.SelectAccountCheckBox();
            dmoePage.AccountPopupOK();
            dmoePage.SynchronizationPopup();
            dmoePage.ValidateSelectDeliveryDate();
            dmoePage.SelectDeliveryDate();
            dmoePage.SelectDeliveryDateOk();
            dmoePage.SynchronizationPopup();
            flag1=true;
        }
    }

    @Then("User must be on Order Entry Page in disconnected mode")
    public void userMustBeOnOrderEntryPageInDisconnectedMode() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.HandleError_Page();
        orderpage.Refresh_Page2();
        //HelpersMethod.Refresh(driver);
        dmoePage=new DMOEPage(driver,scenario);
        dmoePage.ValidateDisconnectedMode();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.deliveryDateSelectedIs();
    }

    @Given("User should be in OE page in DM")
    public void userShouldBeInOEPageInDM() throws InterruptedException, AWTException
    {
        dmoePage=new DMOEPage(driver,scenario);
        dmoePage.ValidateDisconnectedMode();
    }

    @When("User clicks on network symbol and click on toggle button drop down should appear")
    public void userClicksOnNetworkSymbolAndClickOnToggleButtonDropDownShouldAppear()
    {
        dmoePage=new DMOEPage(driver,scenario);
        dmoePage.ClickOnNetworkSymbolInDM();
    }

    @And("Then User should Click on toggle button to go online")
    public void thenUserShouldClickOnToggleButtonToGoOnline()
    {
        dmoePage=new DMOEPage(driver,scenario);
        dmoePage.ClickTaggleDM();
        dmoePage.GoOnlinePopup();
    }
}
