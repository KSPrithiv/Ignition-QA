package stepDefination_DSD_OMS.OrderEntryPage;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

import java.awt.*;
import java.util.List;

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
    static OrderEntryPage orderEntryPage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static OrderHistoryPage orderHistoryPage;
    static OrderEntryPage orderpage;
    static CheckOutOrderPage checkorder;

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

    @And("User should validate Catalog dialogbox and use filters in customer index dialogbox")
    //public void userShouldValidateCatalogDialogboxAndUseFiltersInCustomerIndexDialogbox(String arg0, String arg1, String arg2,String arg3) throws InterruptedException, AWTException
    public void userShouldValidateCatalogDialogboxAndUseFiltersInCustomerIndexDialogbox() throws InterruptedException, AWTException
    {
        String filterValue=null;
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validateCatalogdialog();
        newOE.validateCardView();
        newOE.ResetFilter_Catalog();
        newOE.validateCatalogProducts();
        if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
        {
            newOE.ogDropDown();
            newOE.selectOGDropDown();
            newOE.readProducts();
            newOE.resetFilters();
            newOE.categoryDropDown();
            newOE.selectCategoryDropDown();
            newOE.readProducts();
            newOE.resetFilters();
            newOE.subCategoryDropDown();
            newOE.selectSubCategoryDropDown();
            newOE.readProducts();
            newOE.resetFilters();
            newOE.brandDropDown();
            newOE.selectBrandDropDown();
            newOE.readProducts();
            newOE.resetFilters();
        }
        else if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
        {
            int i=0;
            filterValue=TestBase.testEnvironment.get_Category();
            newOE.gridViewFilter("Category",filterValue,i);
            newOE.readingProdcuts();
            i=0;
            newOE.removeFilter("Category",i);
            i=0;
            filterValue=TestBase.testEnvironment.get_SubCategory();
            newOE.gridViewFilter("Sub Category",filterValue,i);
            newOE.readingProdcuts();
            i=0;
            newOE.removeFilter("Sub Category",i);
            i=0;
            filterValue=TestBase.testEnvironment.get_Brand();
            newOE.gridViewFilter("Brand",filterValue,i);
            newOE.readingProdcuts();
            i=0;
            newOE.removeFilter("Brand",i);
        }
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

    @And("User clicks on Grid type drop down and select different grid")
    public void userClicksOnGridTypeDropDownAndSelectDifferentGrid() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.clickOnGridTypeDropdown();
        newOE.selectGridTypeDropDown();
        newOE.validateGridType();
    }

    @Then("User verifies visibility of Price override icon and reset Grid type to Main grid")
    public void userVerifiesVisibilityOfPriceOverrideIconAndResetGridTypeToMainGrid() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validatePriceOverrideIcon();
        newOE.clickOnGridTypeDropdown();
        newOE.selectMainGridTypeDropDown();
        newOE.validateMainGridType();
    }

    @And("User navigates back to OE by selecting Discard all option from pending order popup")
    public void userNavigatesBackToOEBySelectingDiscardAllOptionFromPendingOrderPopup() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.clickonBackInNewOE();
        newOE.Discard_All_Pending_Order();
    }

    @Then("User verifies visibility of Price override icon change the Price in price override and reset Grid type to Main grid")
    public void userVerifiesVisibilityOfPriceOverrideIconChangeThePriceInPriceOverrideAndResetGridTypeToMainGrid(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> gridtype=tabledata.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validatePriceOverrideIcon();
        newOE.Click_On_PriceOverrideIcon();
        newOE.PriceOverridePopup_WhatIfPriceUnit(gridtype.get(0).get(0));
        newOE.clickOnGridTypeDropdown();
        newOE.selectMainGridTypeDropDown();
        newOE.validateMainGridType();
    }

    @Then("User verifies Order history page and change grid types")
    public void userVerifiesOrderHistoryPageAndChangeGridTypes(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> gridtype=tabledata.asLists(String.class);
        orderHistoryPage=new OrderHistoryPage(driver,scenario);
        orderHistoryPage.ValidateOrderHistory();
        orderHistoryPage.clickOnGridType();
        orderHistoryPage.selectGridType(gridtype.get(0).get(0));
        orderHistoryPage.validateGridType(gridtype.get(0).get(0));
    }

    @Then("User verifies visibility of Price override icon and reset Grid type to Main grid in Order history page")
    public void userVerifiesVisibilityOfPriceOverrideIconAndResetGridTypeToMainGridInOrderHistoryPage(DataTable tabledata) throws InterruptedException, AWTException
    {
        List<List<String>> gridtype=tabledata.asLists(String.class);
        orderHistoryPage=new OrderHistoryPage(driver,scenario);
        orderHistoryPage.ValidateOrderHistory();
        orderHistoryPage.clickOnGridType();
        orderHistoryPage.selectGridType(gridtype.get(0).get(0));
        orderHistoryPage.validateGridType(gridtype.get(0).get(0));
    }

    @And("User should navigate back to Order entry page from Order history page")
    public void userShouldNavigateBackToOrderEntryPageFromOrderHistoryPage() throws InterruptedException, AWTException
    {
        orderHistoryPage=new OrderHistoryPage(driver,scenario);
        orderHistoryPage.clickOnOrderButton();
    }

    @Then("User checks for duplicate comments")
    public void userChecksForDuplicateComments() throws InterruptedException, AWTException
    {
        summary=new CheckOutSummaryPage(driver,scenario);
        summary.CommentBut();
        summary.validateCommentPopup();
        summary.readComments();
        summary.clickOnOKCommentPopup();
    }

    @Then("Click on Next button when editing")
    public void clickOnNextButtonWhenEditing()
    {

    }
}
