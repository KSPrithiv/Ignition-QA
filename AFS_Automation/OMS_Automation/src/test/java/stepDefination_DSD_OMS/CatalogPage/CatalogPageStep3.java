package stepDefination_DSD_OMS.CatalogPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.Catalog.ProductDescriptionPage;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import util.TestBase;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CatalogPageStep3
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    String descriptionProd=null;
    static boolean exists = false;
    Scenario scenario;

    CatalogPage catalogpage;
    NewOrderEntryPage newOE;
    CheckOutOrderPage checkorder;
    ProductDescriptionPage productDescriptionPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("User enters Tire pricing Product# in Search bar and verifying whether tire pricing dialog box appeared or not")
    public void userEntersTirePricingProductInSearchBarAndVerifyingWhetherTirePricingDialogBoxAppearedOrNot()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.SearchProduct(TestBase.testEnvironment.get_TirePricing());
        catalogpage.pointOnTirePriceLabel();
        catalogpage.validateTirePricingDialogBox();
    }
}
