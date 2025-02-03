package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.disconnectedMode.DMOEPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.TestBase;

import java.awt.*;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminDisconnectedModeStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static NewOrderEntryPage newOE;
    static DMOEPage dmoePage;
    static CatalogPage catalogPage;
    static HomePage homepage;
    static OrderEntryPage orderpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @When("User is on Home Page for DM for admin setting")
    public void user_is_on_home_pageForDMForAdminSetting()
    {
            //verify the home page
            homepage = new HomePage(driver,scenario);
            homepage.VerifyHomePage();
    }

    @Then("User navigate to Client side for DM for admin setting")
    public void user_navigate_to_client_sideForDMForAdminSetting()
    {
            homepage = new HomePage(driver,scenario);
            homepage.verifyUserinfoContainer();
            homepage.navigateToClientSide();
    }

    @Then("User should select Order Entry tab for DM for admin setting")
    public void user_should_select_order_entry_tabForDMForAdminSetting() throws InterruptedException, AWTException
    {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.NavigateToOrderEntry();
    }

    @When("User Clicks on network symbol and click on toggle button to navigate to disconnected mode for admin setting")
    public void userClicksOnNetworkSymbolAndClickOnToggleButtonToNavigateToDisconnectedModeForAdminSetting() throws InterruptedException
    {
            dmoePage = new DMOEPage(driver, scenario);
            dmoePage.NavigateToDM();
            dmoePage.DisconnectModeTaggle();
    }

    @And("Then User selects Go offline option in Disconnected mode popup for admin setting")
    public void thenUserSelectsGoOfflineOptionInDisconnectedModePopupForAdminSetting()
    {
            dmoePage = new DMOEPage(driver, scenario);
            dmoePage.DisconnectModePopup();
            dmoePage.ClickGoToOffline();
    }


    @Then("User should get Customer account# popup for admin setting")
    public void userShouldGetCustomerAccountPopupForAdminSetting()
    {
        dmoePage = new DMOEPage(driver, scenario);
        dmoePage.ValidateCustomerAccountPopup();
    }

    @And("User should select Customer Account# from popup and select the delivery date from popup wait till synchronized for admin setting")
    public void userShouldSelectCustomerAccountFromPopupAndSelectTheDeliveryDateFromPopupWaitTillSynchronizedForAdminSetting()
    {
            dmoePage = new DMOEPage(driver, scenario);
            dmoePage.SelectAccountNo();
            //dmoePage.SelectAccountCheckBox();
            dmoePage.AccountPopupOK();
            dmoePage.SynchronizationPopup();
            dmoePage.ValidateSelectDeliveryDate();
            dmoePage.SelectDeliveryDate();
            dmoePage.SelectDeliveryDateOk();
            dmoePage.SynchronizationPopup();
    }

    @Then("Check for Catalog popup and check for no price column in catalog in Disconnected mode")
    public void checkForCatalogPopupAndCheckForNoPriceColumnInCatalogInDisconnectedMode() throws InterruptedException, AWTException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.CheckForCatalog();
        newOE.clickOnLoadAllProducts();
        newOE.ResetFilter_Catalog();
        newOE.selectAllProductsCatalogDialogbox();
        newOE.verifyNoPriceColumn();
    }

    @Then("Check for Catalog popup and check for price column existence in catalog in Disconnected mode")
    public void checkForCatalogPopupAndCheckForPriceColumnExistenceInCatalogInDisconnectedMode() throws InterruptedException, AWTException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.CheckForCatalog();
        newOE.clickOnLoadAllProducts();
        newOE.ResetFilter_Catalog();
        newOE.selectAllProductsCatalogDialogbox();
        newOE.verifyPriceColumn();
    }

    @Then("User should verify for price of product detail not existence")
    public void userShouldVerifyForPriceOfProductDetailNotExistence()
    {
        catalogPage=new CatalogPage(driver,scenario);
        catalogPage.validateCatalog();

        catalogPage.validateNoPriceCard();
    }

    @Then("User should verify for price of product detail existence")
    public void userShouldVerifyForPriceOfProductDetailExistence()
    {
        catalogPage=new CatalogPage(driver,scenario);
        catalogPage.validateCatalog();
        catalogPage.validatePriceCard();
    }
}
