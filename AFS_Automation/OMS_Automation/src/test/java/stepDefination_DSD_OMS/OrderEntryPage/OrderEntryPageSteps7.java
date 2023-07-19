package stepDefination_DSD_OMS.OrderEntryPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class OrderEntryPageSteps7
{
    /* Created by Divya.Ramadas@afsi.com */

    WebDriver driver;
    Scenario scenario;

    static boolean exists=false;
    OrderEntryPage orderEntryPage;
    NewOrderEntryPage newOE;
    CheckOutSummaryPage summary;
    OrderHistoryPage orderHistoryPage;
    OrderEntryPage orderpage;
    CheckOutOrderPage checkorder;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should be in Order summary page and click on back to Orderlist button")
    public void userShouldBeInOrderSummaryPageAndClickOnBackToOrderlistButton() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.ValidateSummaryOrderPage();
        summary.clickOnBackToOrderList();
    }

    @And("User should validate Catalog dialogbox and use filters in customer index dialogbox {string},{string},{string},{string}")
    public void userShouldValidateCatalogDialogboxAndUseFiltersInCustomerIndexDialogbox(String arg0, String arg1, String arg2,String arg3) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validateCatalogdialog();
        newOE.validateCardView();
        newOE.showAllProductDropDown();
        newOE.selectShowAllProductDropDown();
        newOE.readProducts();
        newOE.resetFilters();
        newOE.ogDropDown();
        newOE.selectOGDropDown(arg3);
        newOE.readProducts();
        newOE.resetFilters();
        newOE.categoryDropDown();
        newOE.selectCategoryDropDown(arg0);
        newOE.readProducts();
        newOE.resetFilters();
        newOE.subCategoryDropDown();
        newOE.selectSubCategoryDropDown(arg1);
        newOE.readProducts();
        newOE.resetFilters();
        newOE.brandDropDown();
        newOE.selectBrandDropDown(arg2);
        newOE.readProducts();
        newOE.resetFilters();
    }

    @Then("User clicks on icon next to address")
    public void userClicksOnIconNextToAddress() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.clickOnInfoIcon();
        orderpage.validateInfoDialogBox();
        orderpage.readShippingAddress();
    }

    @Then("User clicks on Privacy policy link and window with pivacy policy will open, user handles it")
    public void userClicksOnPrivacyPolicyLinkAndWindowWithPivacyPolicyWillOpenUserHandlesIt() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.validateVisiblityOfPrivacyPolicy();
        orderpage.clickOnPrivacyPolicy();
        orderpage.handlePrivacyPolicy();
    }
}
