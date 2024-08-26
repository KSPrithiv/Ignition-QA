package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.standingOrder.NewStandingOrderPage;
import util.TestBase;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminStandingOrderStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static String currentURL;
    static NewStandingOrderPage standingOrder;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should navigate to Standing Order tab for admin setting")
    public void userShouldNavigateToStandingOrderTabForAdminSetting()
    {
        if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]", driver))
        {
            HelpersMethod.navigate_Horizantal_Tab(driver, "Standing orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            standingOrder=new NewStandingOrderPage(driver,scenario);
            currentURL=standingOrder.navigateToStandingOrderPage();
            scenario.log(currentURL);
        }
        else
        {
            scenario.log("STANDING ORDER TAB IS NOT VISIBLE");
        }
    }

    @Then("User enters Product# in Quick product entry inputbox in admin setting")
    public void userEntersProductInQuickProductEntryInputboxInAdminSetting()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.adminQuickProductEntry();
        standingOrder.verifyProdNoInGridAdmin();
    }

    @And("User checks for catalog popup and searches for product in catalog for admin setting")
    public void userChecksForCatalogPopupAndSearchesForProductInCatalogForAdminSetting()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ValidateCatalogPopup();
        standingOrder.clickOnLoadAllProducts();
        standingOrder.ResetFilter_Catalog();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            standingOrder.ListViewAdmin();
        }
        else
        {
            standingOrder.cardViewAdmin();
        }
        standingOrder.CatalogOKButton();
    }

    @Then("User enters Product# in Quick product entry inputbox in admin setting for disabling")
    public void userEntersProductInQuickProductEntryInputboxInAdminSettingForDisabling()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.adminProductWithZeroQuickProductEntry();
        standingOrder.verifyProdNoWithZeroInGridAdmin();
    }

    @And("User checks for catalog popup and searches for product in catalog for admin setting zero preceding product number")
    public void userChecksForCatalogPopupAndSearchesForProductInCatalogForAdminSettingZeroPrecedingProductNumber()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.ValidateCatalogPopup();
        standingOrder.clickOnLoadAllProducts();
        standingOrder.ResetFilter_Catalog();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            standingOrder.ListViewAdminZeroPreceding();
        }
        else
        {
            standingOrder.cardViewAdminZeroPreceding();
        }
        standingOrder.CatalogOKButton();
    }
}
