package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
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

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("Check for Catalog popup and check for price column in catalog in Disconnected mode")
    public void checkForCatalogPopupAndCheckForPriceColumnInCatalogInDisconnectedMode() throws InterruptedException, AWTException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.CheckForCatalog();
        newOE.verifyNoPriceColumn();
    }

    @Then("Check for Catalog popup and check for price column existence in catalog in Disconnected mode")
    public void checkForCatalogPopupAndCheckForPriceColumnExistenceInCatalogInDisconnectedMode() throws InterruptedException, AWTException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.CheckForCatalog();
        newOE.verifyPriceColumn();
    }
}
