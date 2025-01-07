package stepDefination_DSD_OMS.CatalogPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.Catalog.CatalogPage;
import pages_DSD_OMS.Catalog.ProductDescriptionPage;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class CatalogPageStep2
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    String descriptionProd;
    static boolean exists = false;
    Scenario scenario;

    static CatalogPage catalogpage;
    static NewOrderEntryPage newOE;
    static CheckOutOrderPage checkorder;
    static ProductDescriptionPage productDescriptionPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("User enters Product# in Search bar and enters Qty for single Product in list view")
    public void userEntersProductInSearchBarAndEntersQtyForSingleProductInListView(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        exists = true;
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        catalogpage = new CatalogPage(driver, scenario);
        String pro = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        catalogpage.SearchProduct1(pro);
        exists = HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]", driver);
        if (exists == true)
        {
            HelpersMethod.ClickBut(driver, HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button')]/*[local-name()='svg']/*[local-name()='path' and contains(@d,'M17')]"), 10);
        }
        else if (exists == false)
        {
            catalogpage.productInputList(Prod_detail.get(0).get(0));
        }
    }

    @Then("User enters Product# with tire pricing in Search bar")
    public void userEntersProductWithTirePricingInSearchBar()
    {
        catalogpage=new CatalogPage(driver,scenario);
        String pro=TestBase.testEnvironment.get_TirePricing();
        catalogpage.SearchProduct1(pro);
    }

    @And("User checks for the condition applied for tire pricing")
    public void userChecksForTheConditionAppliedForTirePricing()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.checkTirepricing();
    }

    @Then("User enters Product# with tire pricing in Search bar and enter some Qty")
    public void userEntersProductWithTirePricingInSearchBarAndEnterSomeQty(DataTable tabledata) throws InterruptedException
    {
        List<List<String>> Qty=tabledata.asLists(String.class);
        catalogpage=new CatalogPage(driver,scenario);
        String pro=TestBase.testEnvironment.get_TirePricing();
        catalogpage.SearchProduct1(pro);
        catalogpage.ProductExistsCard(Qty.get(0).get(0));
    }

    @Then("User click on cart in catalog and Clicks on tirepricing label")
    public void userClickOnCartInCatalogAndClicksOnTirepricingLabel()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.Cart_Button();
        catalogpage.readProdFromShoppingCartDropDown();
        catalogpage.GotoCartClick();
        catalogpage.validateCartItemCard();
        catalogpage.validateTirePricingIcon();
        catalogpage.visiblityOfTriePricingDetails();
    }

    @Then("Click on Next button for Tire pricing")
    public void clickOnNextButtonForTirePricing() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        exists=newOE.ClickNext();
        newOE.handleTirePricingpopup();
        checkorder=new CheckOutOrderPage(driver,scenario);
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//div[contains(@class,'payment-method-container')]",driver))
            {
                checkorder.SelectPaymentMethod();
            }
        /* if(checkorder.Verify_Existence_of_ContinuePayment())
        {
            checkorder.Click_On_Without_Providing_Payment();
        }*/
        }
        checkorder.DeliveryAddressCard();
        checkorder.NextButton_Click();
    }

    @Then("User enters Product# in foreign language, in Search bar")
    public void userEntersProductInForeignLanguageInSearchBar()
    {
        catalogpage = new CatalogPage(driver, scenario);
        String pro = TestBase.testEnvironment.getForeignLangDesc();
        scenario.log("PRODUCT FOR SEARCH IN SEARCH BAR "+pro);
        catalogpage.SearchProduct1(pro);
    }

    @Then("Click on sort by best match and select ascending order and verify the same from Catalog pagination")
    public void clickOnSortByBestMatchAndSelectAscendingOrderAndVerifyTheSameFromCatalogPagination(DataTable tabledata)
    {
        List<List<String>> Best_Match = tabledata.asLists(String.class);
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.navigateToLastPage();
        catalogpage.Best_MatchDropDownPagination(Best_Match.get(0).get(0));
        //catalogpage.compartingTotalDisplayedWithInPage();
        catalogpage.sortingValue();
    }

    @And("User should read Tire pricing product price")
    public void userShouldReadTirePricingProductPrice()
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.validateTirePricingIcon();
        catalogpage.checkForPriceOfProduct();
    }

    @Then("User click on cart in catalog and click on Gotocart and select Pending order")
    public void userClickOnCartInCatalogAndClickOnGotocartAndSelectPendingOrder()
    {
        catalogpage = new CatalogPage(driver, scenario);
        catalogpage.Cart_Button();
        catalogpage.readProdFromShoppingCartDropDown();
        catalogpage.GotoCartClick();
        catalogpage.validateCartItemCard();
        catalogpage.Checkout_to_order();
        catalogpage.validateSelectOrder();
        catalogpage.selectPendingOrder();
    }

    @And("User clicks on product description link, verify the product")
    public void userClicksOnProductDescriptionLinkVerifyTheProduct()
    {
        catalogpage = new CatalogPage(driver, scenario);
        descriptionProd= catalogpage.clickOnProdDescription();
        productDescriptionPage=new ProductDescriptionPage(driver,scenario);
        productDescriptionPage.validateProductDescriptionPage();
        //productDescriptionPage.validateProductDescription(descriptionProd);
    }

    @Then("User clicks on Back to catalog button and navigates back to catalog page")
    public void userClicksOnBackToCatalogButtonAndNavigatesBackToCatalogPage()
    {
        productDescriptionPage=new ProductDescriptionPage(driver,scenario);
        productDescriptionPage.Back_to_Catalog();
    }

    @And("User verifies that searched product details are still displayed and click on reset filter")
    public void userVerifiesThatSearchedProductDetailsAreStillDisplayedAndClickOnResetFilter()
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.validateCatalog();
        //catalogpage.validateProdDescription(descriptionProd);
    }

    @Then("User enters invalid {string} in Search bar")
    public void userEntersInvalidInSearchBar(String prodNum)
    {
        catalogpage=new CatalogPage(driver,scenario);
        catalogpage.SearchProduct(prodNum);
        catalogpage.validateNonExistingProduct();
    }
}