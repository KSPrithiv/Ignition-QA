package stepDefination_DSD_OMS.OrderGuidePageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.orderGuide.OrderGuidePage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderGuidePageStep1
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static OrderGuidePage orderGuidePage;
    static CreateOGPage createOGPage;

    static boolean exists = false;
    static String Prod_No=null;
    static String OGDis=null;
    static String WDay=null;
    static String importFilePath;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    //Code for creating OG using Catalog
    @Then("User clicks on Add product button and select Catalog from drop down")
    public void user_clicks_on_add_product_button_and_select_catalog_from_drop_down(DataTable dataTable)
    {
        List<List<String>> option=dataTable.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ClickOnAddProduct();
        createOGPage.SelectValueFromAddProduct(option.get(0).get(0));
        scenario.log("OPTION SELECTED FROM ADD DROP DOWN IS "+option.get(0).get(0));
    }

    @And("User should select products from catalog popup")
    public void user_should_select_products_from_catalog_popup()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateCatalogDisplay();
        createOGPage.clickLoadAllProducts();
        createOGPage.ResetFilter_Catalog();
        createOGPage.selectAllProducts();
        createOGPage.validateProductInCatalog();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            createOGPage.ListView();
        }
        else
        {
            createOGPage.cardView();
        }
        createOGPage.CatalogPopupOk();
    }

    @And("User should select products from catalog popup for Price base")
    public void user_should_select_products_from_catalog_popupForPriceBase() throws InterruptedException {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateCatalogDisplay();
        createOGPage.clickLoadAllProducts();
        createOGPage.ResetFilter_Catalog();
        createOGPage.selectAllProducts();
        createOGPage.validateProductInCatalog();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            createOGPage.ListViewPriceBase();
        }
        else
        {
            createOGPage.cardViewPriceBase();
        }
        createOGPage.CatalogPopupOk();
        Thread.sleep(5000);
    }

    //Code to delete OG from the OG grid
    @Then("User enters OG Description in search box and Delete the OG verify same in OG grid")
    public void user_enters_og_description_in_search_box_and_delete_the_og_verify_same_in_og_grid(DataTable tabledata) throws InterruptedException, AWTException
    {
        exists=false;
        List<List<String>> OGSearch=tabledata.asLists(String.class);
        orderGuidePage = new OrderGuidePage(driver, scenario);
        createOGPage=new CreateOGPage(driver,scenario);
        for(int i=0;i<OGSearch.size()-1;i++)
        {
            orderGuidePage.OGSearchBox(OGSearch.get(i).get(0));
            orderGuidePage.SearchOGSelect(OGSearch.get(i).get(0));
            createOGPage.Click_Delete();
            createOGPage.DeleteOk_Popup();
            //once OG is deleted, search for OG in OG grid
            orderGuidePage.OGSearchBox(OGSearch.get(i).get(0));
        }
    }

    @Then("User click on AddFilter button and handle different popup")
    public void userClickOnAddFilterButtonAndHandleDifferentPopup(DataTable dataTable) throws InterruptedException, AWTException
    {
        List<List<String>> AddOption=dataTable.asLists(String.class);
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.ValidateOG();
        orderGuidePage.AddFilterClick(AddOption.get(0).get(0),AddOption.get(0).get(1));
    }

    @And("User verifies New OG page and clicks on import button")
    public void userVerifiesNewOGPageAndClicksOnImportButton() throws InterruptedException
    {
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.ValidateNewOG();
        createOGPage.ImportClick(importFilePath);
        createOGPage.ListProductsImported();
    }

    @Then("User selects type of OG from drop down")
    public void userSelectsTypeOfOGFromDropDown(DataTable dataTable)
    {
        List<List<String>> Type=dataTable.asLists(String.class);
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.ValidateNewOG();
        createOGPage.Click_On_Type();
        createOGPage.validateOGTypeDropDown();
        createOGPage.SelectTypeFromDropDown(Type.get(0).get(0));
        createOGPage.validateOGType(Type.get(0).get(0));
    }

    @Then("User should click on Customer Reference drop down and select type of OG")
    public void userShouldClickOnCustomerReferenceDropDownAndSelectTypeOfOG(DataTable dataTable) throws InterruptedException, AWTException
    {
        List<List<String>> CusRef=dataTable.asLists(String.class);
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.ValidateOG();
        orderGuidePage.CustomerRef();
        orderGuidePage.CustRefDropDown(CusRef.get(0).get(0));
    }


    @Then("User should click on Customer Reference drop down and select type of OG {string}")
    public void userShouldClickOnCustomerReferenceDropDownAndSelectTypeOfOG(String orderType) throws InterruptedException, AWTException
    {
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.ValidateOG();
        orderGuidePage.CustomerRef();
        orderGuidePage.CustRefDropDown(orderType);
    }

    @And("Check for popup to appear to select sub customer reference for local chain")
    public void checkForPopupToAppearToSelectSubCustomerReferenceForLocalChain(DataTable dataTable) throws InterruptedException, AWTException
    {
        List<List<String>> subCustRef=dataTable.asLists(String.class);
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.SubCustomerRefLocalChain(subCustRef);
    }

    @And("Check for popup to appear to select sub customer reference")
    public void checkForPopupToAppearToSelectSubCustomerReference() throws InterruptedException, AWTException
    {
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.SubCustomerRef();
    }

    @And("User should navigate back to OG page and navigate back to local chain and verify OG {string}  existence")
    public void userShouldNavigateBackToOGPageAndNavigateBackToLocalChainAndVerifyOGExistence(DataTable dataTable,String Og) throws InterruptedException, AWTException
    {
        orderGuidePage = new OrderGuidePage(driver, scenario);
        boolean result = orderGuidePage.ValidateOG();
        Assert.assertEquals(result, true);
        scenario.log("USER IS ON ORDER GUIDE PAGE");

        //code to change Customer reference to Local chain
        List<List<String>> CusRef=dataTable.asLists(String.class);
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.CustomerRef();
        orderGuidePage.CustRefDropDown(CusRef.get(0).get(0));
        orderGuidePage.SubCustomerRef();

        //Code to verify whether OG is existing in OG grid or not
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists=orderGuidePage.OGSearchBox(Og);
        Assert.assertEquals(exists,true);
    }

    @And("User selects Day of week from drop down")
    public void userSelectsDayOfWeekFromDropDown()
    {
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.ClickOnDayOfWeek();
        WDay=createOGPage.SelectDayOfWeek();
    }

    @And("User should navigate to OG and change the Customer Account#")
    public void userShouldNavigateToOGAndChangeTheCustomerAccount() throws InterruptedException, AWTException
    {
        if (HelpersMethod.EleDisplay(HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]")))
        {
            HelpersMethod.navigate_Horizantal_Tab(driver, "Order Guides", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            orderGuidePage = new OrderGuidePage(driver, scenario);
            boolean result = orderGuidePage.ValidateOG();
            Assert.assertEquals(result, true);
        }
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.CustomerAcc();
        orderGuidePage.AccountPopup();
    }

    @Then("User reads first OG from OG grid and navigates to new OG page")
    public void userReadsFirstOGFromOGGridAndNavigatesToNewOGPage() throws InterruptedException, AWTException
    {
        orderGuidePage = new OrderGuidePage(driver, scenario);
        OGDis=orderGuidePage.SelectOG();
    }

    @And("User selects end date as past date")
    public void userSelectsEndDateAsPastDate() throws InterruptedException, AWTException
    {
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.OGDetailValidate();
        createOGPage.clickOnStatus();
        createOGPage.selectStatus("Expired");
        //createOGPage.CalenderEnd();
        //createOGPage.ValidToDatePast();
        createOGPage.ClickOnSave();
        createOGPage.validateSavePopup();
        createOGPage.clickOnOk();
    }

    @And("User should navigate back to OG page and verify OG {string} by selecting status as expired")
    public void userShouldNavigateBackToOGPageAndVerifyOGBySelectingStatusAsExpired(String OGDis) throws InterruptedException, AWTException
    {
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists=orderGuidePage.ValidateOG();
        Assert.assertEquals(exists,true);
        exists=orderGuidePage.AddFilterForExpiredOG("Status","Expired");
        Assert.assertEquals(exists,true);
        orderGuidePage.OGSearchBoxClear();
        exists=orderGuidePage.OGSearchBox(OGDis);
        Assert.assertEquals(exists,true);
    }

    @And("User should navigate back to OG page change account# and verify OG {string}  existence")
    public void userShouldNavigateBackToOGPageChangeAccountAndVerifyOGExistence(String Og) throws InterruptedException, AWTException
    {
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.CustomerAcc();
        orderGuidePage.AccountPopup();
    }

    @And("User should navigate back to OG page, verify OG {string} existence and verify that Week of day is selected")
    public void userShouldNavigateBackToOGPageVerifyOGExistenceAndVerifyThatWeekOfDayIsSelected(String Og) throws InterruptedException, AWTException
    {
        String DayWeek=null;
        orderGuidePage = new OrderGuidePage(driver, scenario);
        boolean result = orderGuidePage.ValidateOG();
        //Assert.assertEquals(result, true);
        scenario.log("USER IS ON ORDER GUIDE PAGE");

        //Code to verify whether OG is existing in OG grid or not
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists=orderGuidePage.OGSearchBox(Og);
        Assert.assertEquals(exists,true);

        //Click on OG and navigate to OG details page
        orderGuidePage.SearchOGSelect(Og);
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.OGDetailValidate();
        DayWeek=createOGPage.ValidateWeekOfDay();
        scenario.log(WDay+" IS RANDOMLY SELECTED DAY");
        scenario.log(DayWeek+"DAY SELECTED IN DAY OF WEEK");
        Assert.assertEquals(WDay,DayWeek);
    }

    @And("User should navigate to CustomerAllocation tab")
    public void userShouldNavigateToCustomerAllocationTab()
    {
        exists=false;
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.CustomerAllocation();
        exists=createOGPage.ValidateCustomerAllocation();
        Assert.assertEquals(exists,true);
    }

    @Then("Select CustomerAllocation check box and click on Delete button")
    public void selectCustomerAllocationCheckBoxAndClickOnDeleteButton()
    {
        exists=false;
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.CheckBoxCustAllocation();
        createOGPage.ClickOnDelete();
        createOGPage.CustomerAllocationDeletePopup();
        exists=createOGPage.ValidateDelete();
        Assert.assertEquals(exists,true);
        scenario.log("Customer Allocation has been removed sucessfully");
    }

    @Then("User Clicks on Plus button and select value from drop down")
    public void userClicksOnPlusButtonAndSelectValueFromDropDown(DataTable tableData)
    {
        List<List<String>> PlusDrop=tableData.asLists(String.class);
        exists=false;
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.ClickPlus();
        createOGPage.DropDownAcc(PlusDrop.get(0).get(0));
    }

    @And("User verify popup appears and enter account# in search box")
    public void userVerifyPopupAppearsAndEnterAccountInSearchBox()
    {
        exists=false;
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.validateCustomerIndexPopup();
        exists=createOGPage.PopupHandle();
        Assert.assertEquals(exists,true);
    }

    @Then("Select customer account# and verify that account# is added")
    public void selectCustomerAccountAndVerifyThatAccountIsAdded()
    {
        exists=false;
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.CustomerAccountSelect();
        exists=createOGPage.ValidateCustSelect();
        createOGPage.clickOnCustomerAccountIndexOk();
        //createOGPage.ClickOnSave();
    }

    @And("User should select products from catalog popup to add multiple products")
    public void userShouldSelectProductsFromCatalogPopupToAddMultipleProducts() throws SQLException, InterruptedException
    {
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.ValidateCatalogDisplay();
        createOGPage.clickLoadAllProducts();
        createOGPage.ResetFilter_Catalog();
        createOGPage.selectAllProducts();
        createOGPage.validateProductInCatalog();
        createOGPage.AddFromCatalog(DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql1()));
    }

    @And("User verifies New OG page and clicks on export button")
    public void userVerifiesNewOGPageAndClicksOnExportButton()
    {
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.ValidateNewOG();
        importFilePath=createOGPage.Click_Export();
    }

    @Then("User Clicks on Customer Account_No button and select other Customer Account_No")
    public void userClicksOnCustomerAccount_NoButtonAndSelectOtherCustomerAccount_No() throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.ClickCustomerAccount_No();
    }

    @Then("User Clicks on Plus button and select {string} from drop down")
    public void userClicksOnPlusButtonAndSelectFromDropDown(String arg0) throws InterruptedException
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ClickPlus();
        createOGPage.Select_Chain(arg0);
        createOGPage.selectChainFromPopup();
    }

    @Then("User should navigate back to Product tab in OG")
    public void userShouldNavigateBackToProductTabInOG()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ProductTab();
        createOGPage.ValidateProductTab();
    }

    @And("User validates that previously added products are removed from product grid")
    public void userValidatesThatPreviouslyAddedProductsAreRemovedFromProductGrid()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateNoProductsInGrid();
    }

    @And("User changes the Customer Account# to the previous Account#")
    public void userChangesTheCustomerAccountToThePreviousAccount() throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.ClickCustomerAccount_No_PreviousAcc();
    }

    @Then("Then User enters Description {string} and End date for loacl chain")
    public void thenUserEntersDescriptionAndEndDateForLoaclChain(String Og)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.DescriptionOG(Og);
        //selecting end date
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        createOGPage.CalenderEnd();
        createOGPage.SelectEndDate(formattedDate,20);
    }

    @And("User validates Customer reference input box to verify the OG created")
    public void userValidatesCustomerReferenceInputBoxToVerifyTheOGCreated(DataTable tableData)
    {
        List<List<String>> custRef=tableData.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.validateCustomerReference(custRef.get(0).get(0));
    }

    @Then("User selects type of OG from drop down to select historical OG")
    public void userSelectsTypeOfOGFromDropDownToSelectHistoricalOG(DataTable dataTable)
    {
        List<List<String>> Type=dataTable.asLists(String.class);
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.ValidateNewOG();
        createOGPage.Click_On_Type();
        createOGPage.validateOGTypeDropDown();
        createOGPage.SelectHistoricalFromDropDown(Type.get(0).get(0));
        createOGPage.validateOGType(Type.get(0).get(0));
    }

    @And("User should select products from catalog popup for Local chain")
    public void userShouldSelectProductsFromCatalogPopupForLocalChain()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateCatalogDisplay();
        createOGPage.clickLoadAllProducts();
        createOGPage.ResetFilter_Catalog();
        createOGPage.selectAllProducts();
        createOGPage.validateProductInCatalog();
        if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
        {
            createOGPage.ListViewPriceBase();
        }
        else
        {
            createOGPage.cardViewPriceBase();
        }
        createOGPage.CatalogPopupOk();
    }

    @Then("User deletes {string} created for day of week")
    public void userDeletesOrderGuideCreatedForDayOfWeek(String arg0) throws InterruptedException, AWTException
    {
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.Click_Delete();
        createOGPage.DeleteOk_Popup();
        createOGPage.deleteConfirmationPopup();
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.ValidateOG();
        //once OG is deleted, search for OG in OG grid
        exists=orderGuidePage.OGSearchBox(arg0);
        Assert.assertEquals(exists,false);
    }

    @And("User validates Customer reference {string} to verify the OG created and select pricing customer value from dropdown {string}")
    public void userValidatesCustomerReferenceToVerifyTheOGCreatedAndSelectPricingCustomerValueFromDropdown(String ogType,String priceCust)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateNewOG();
        createOGPage.validateCustomerReference(ogType);
        createOGPage.clickPriceingCustomer();
        createOGPage.selectPricingCustomer(priceCust);
        createOGPage.handleChangePricingCustomer();
        createOGPage.validatePricingCustomer(priceCust);
    }
}
