package stepDefination_DSD_OMS.DiconnectModePageSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.disconnectedMode.DMOEPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.TestBase;

import java.awt.*;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class DMOEPageStep1
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;

    static DMOEPage dmoePage;
    static OrderEntryPage orderpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should select two Customer Account# from popup and select two delivery date from popup wait till synchronized")
    public void userShouldSelectTwoCustomerAccountFromPopupAndSelectTwoDeliveryDateFromPopupWaitTillSynchronized()
    {
        dmoePage = new DMOEPage(driver, scenario);
        dmoePage.selectFirstCustomerAccountNo();
        dmoePage.SelectAccountCheckBox();
        dmoePage.clearAccountNumberInDialogbox();
        dmoePage.selectSecondCustomerAccountNo();
        dmoePage.SelectAccountCheckBox();
        dmoePage.AccountPopupOK();
        dmoePage.SynchronizationPopup();
        dmoePage.ValidateSelectDeliveryDate();
        dmoePage.SelectDeliveryDate();
        dmoePage.selectSecondDeliveryDate();
        dmoePage.SelectDeliveryDateOk();
        dmoePage.SynchronizationPopup();
        dmoePage.ValidateSelectDeliveryDate();
        dmoePage.selectThirdDeliveryDate();
        dmoePage.selectFourthDeliveryDate();
        dmoePage.SelectDeliveryDateOk();
        dmoePage.SynchronizationPopup();
    }

    @And("User should verify visibility of customer account#")
    public void userShouldVerifyVisibilityOfCustomerAccount()
    {
        dmoePage=new DMOEPage(driver,scenario);
        dmoePage.clickOnAccountIndex();
        dmoePage.validateAccountDialogPopup();
        dmoePage.validateAccountNumbers();
        dmoePage.closeAccountIndex();
    }

    @When("User Clicks on network symbol and click on toggle button to navigate to disconnected mode for two customer account selection")
    public void userClicksOnNetworkSymbolAndClickOnToggleButtonToNavigateToDisconnectedModeForTwoCustomerAccountSelection() throws InterruptedException
    {
        dmoePage = new DMOEPage(driver, scenario);
        dmoePage.NavigateToDM();
        dmoePage.DisconnectModeTaggle();
    }

    @And("Then User selects Go offline option in Disconnected mode popup for two customer account selection")
    public void thenUserSelectsGoOfflineOptionInDisconnectedModePopupForTwoCustomerAccountSelection()
    {
        dmoePage = new DMOEPage(driver, scenario);
        dmoePage.DisconnectModePopup();
        dmoePage.ClickGoToOffline();
    }

    @Then("User must be on Order Entry Page in disconnected mode and navigate to Catalog tab")
    public void userMustBeOnOrderEntryPageInDisconnectedModeAndNavigateToCatalogTab() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.HandleError_Page();
        orderpage.Refresh_Page2();
        //HelpersMethod.Refresh(driver);
        dmoePage=new DMOEPage(driver,scenario);
        dmoePage.ValidateDisconnectedMode();
    }
}
