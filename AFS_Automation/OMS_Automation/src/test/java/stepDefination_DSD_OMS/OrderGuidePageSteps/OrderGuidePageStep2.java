package stepDefination_DSD_OMS.OrderGuidePageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.orderGuide.OrderGuidePage;
import util.TestBase;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderGuidePageStep2
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static boolean exists = false;

    static OrderGuidePage orderGuidePage;
    static CreateOGPage createOGPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("Then User enters Description {string} and clicks on All order check box")
    public void thenUserEntersDescriptionAndClicksOnAllOrderCheckBox(String ogDescription) throws InterruptedException
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.DescriptionOG(ogDescription);
        //Click on All order check box
        createOGPage.clickOnAllCustomerCheckBox();
        createOGPage.validateAllCustomerCheckBox();
        createOGPage.validateNonExistanceOfCustomerAllocationTab();
    }

    @Then("User enters Description {string} Start date {int} and No selection of end date")
    public void userEntersDescriptionStartDateAndNoSelectionOfEndDate(String ogDescription, int Sdate)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.DescriptionOG(ogDescription);

        //selecting start date
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        createOGPage.CalenderStart();
        createOGPage.SelectStartDate(formattedDate, Sdate);
    }

    @And("Check for popup to appear to select National Chain {string}")
    public void checkForPopupToAppearToSelectNationalChain(String nationalChain) throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.validateNationalChainPopup();
        orderGuidePage.selectNationalChainFromPopup(nationalChain);
    }

    @Then("User enters Description {string} Start date {int} and End date {int} day from current date and validate all customer check box")
    public void userEntersDescriptionStartDateAndEndDateDayFromCurrentDateAndValidateAllCustomerCheckBox(String arg0, int Sdate, int Edate)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.DescriptionOG(arg0);

        //selecting start date
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        createOGPage.CalenderStart();
        createOGPage.SelectStartDate(formattedDate, Sdate);

        //selecting end date
        LocalDate myDateObj1 = LocalDate.now();
        DateTimeFormatter myFormatObj1= DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate1 = myDateObj1.format(myFormatObj1);
        createOGPage.CalenderEnd();
        createOGPage.SelectEndDate(formattedDate1,Edate);
        createOGPage.validateAllCustomerCheckBox();
    }

    @And("User should make sure that customer reference {string} is same as of selected in OG page")
    public void userShouldMakeSureThatCustomerReferenceIsSameAsOfSelectedInOGPage(String custRef) throws InterruptedException
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.validateCustomerReference(custRef);
    }

    @Then("User should select header in OG grid for {string} functionality")
    public void userShouldSelectHeaderInOGGridForFunctionality(String TableHead) throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.FindtableHeader(TableHead);
        orderGuidePage.DisplayGroupDetails();
    }

    @And("Check for popup to appear to select sub customer reference for market segment")
    public void checkForPopupToAppearToSelectSubCustomerReferenceForMarketSegment(DataTable dataTable) throws InterruptedException, AWTException
    {
        List<List<String>> subCustRef=dataTable.asLists(String.class);
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.selectSubMarketRef(subCustRef);
    }

    @And("Check for popup to appear to select sub customer reference for National chain")
    public void checkForPopupToAppearToSelectSubCustomerReferenceForNationalChain(DataTable dataTable) throws InterruptedException, AWTException
    {
        List<List<String>> subCustRef=dataTable.asLists(String.class);
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.selectSubMarketRef(subCustRef);
    }

    @And("Clear filter to display both active and inactive OG")
    public void clearFilterToDisplayBothActiveAndInactiveOG() throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.ValidateOG();
        orderGuidePage.clickAddFilterClear();
    }

    @Then("User clicks on Add product button and select Catalog from drop down for price Base OG")
    public void userClicksOnAddProductButtonAndSelectCatalogFromDropDownForPriceBaseOG(DataTable dataTable) throws InterruptedException
    {
        List<List<String>> option=dataTable.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.validateNewOGPage();
        //createOGPage.validateAllCustomerCheckBox();
        createOGPage.ClickOnAddProduct();
        createOGPage.SelectValueFromAddProduct(option.get(0).get(0));
        scenario.log("OPTION SELECTED FROM ADD DROP DOWN IS "+option.get(0).get(0));
    }

    @Then("User clicks on Add product button and select Catalog from drop down for Market segment OG")
    public void userClicksOnAddProductButtonAndSelectCatalogFromDropDownForMarketSegmentOG(DataTable dataTable) throws InterruptedException
    {
        List<List<String>> option=dataTable.asLists(String.class);
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.validateNewOGPage();
        //createOGPage.validateAllCustomerCheckBox();
        createOGPage.ClickOnAddProduct();
        createOGPage.SelectValueFromAddProduct(option.get(0).get(0));
        scenario.log("OPTION SELECTED FROM ADD DROP DOWN IS "+option.get(0).get(0));
    }

    @Then("User should use filter input box in the OG grid {string} {string}")
    public void userShouldUseFilterInputBoxInTheOGGrid(String type, String status) throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        int i = 0;
        String og=TestBase.testEnvironment.get_OrderGuide();
        orderGuidePage.filterToSearch("Description",og,i);
        orderGuidePage.readingOG();
        i=0;
        orderGuidePage.resetFilter("Description",i);
        i=0;
        orderGuidePage.filterToSearch("Type",type,i);
        orderGuidePage.readingOG();
        i=0;
        orderGuidePage.resetFilter("Type",i);
        i=0;
        orderGuidePage.statusFilter("Status",status,i);
        orderGuidePage.readingOG();
        i=0;
        orderGuidePage.resetFilter("Status",i);
    }

    @Then("User should use arrow symbol to sort the value in the grid")
    public void userShouldUseArrowSymbolToSortTheValueInTheGrid() throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        int i=1;
        orderGuidePage.displayGridValue(i);
        orderGuidePage.clickArrowInGrid(i);
        orderGuidePage.displaySortedGridValue(i);
        orderGuidePage.resetGridValue(i);
        i=2;
        orderGuidePage.displayGridValue(i);
        orderGuidePage.clickArrowInGrid(i);
        orderGuidePage.displaySortedGridValue(i);
        orderGuidePage.resetGridValue(i);
        i=3;
        orderGuidePage.displayGridValue(i);
        orderGuidePage.clickArrowInGrid(i);
        orderGuidePage.displaySortedGridValue(i);
        orderGuidePage.resetGridValue(i);
        i=4;
        orderGuidePage.displayGridValue(i);
        orderGuidePage.clickArrowInGrid(i);
        orderGuidePage.displaySortedGridValue(i);
        orderGuidePage.resetGridValue(i);
        i=5;
        orderGuidePage.displayGridValue(i);
        orderGuidePage.clickArrowInGrid(i);
        orderGuidePage.displaySortedGridValue(i);
        orderGuidePage.resetGridValue(i);
    }

    @And("Check for popup to appear to select sub customer reference for Price group base schedule")
    public void checkForPopupToAppearToSelectSubCustomerReferenceForPriceGroupBaseSchedule(DataTable dataTable) throws InterruptedException, AWTException
    {
        List<List<String>> priceGroup=dataTable.asLists(String.class);
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.SubCustomerRefPriceGroupBaseSchedule(priceGroup);
    }

    @And("Check for popup to appear to select sub customer reference for Price group default schedule")
    public void checkForPopupToAppearToSelectSubCustomerReferenceForPriceGroupDefaultSchedule(DataTable dataTable) throws InterruptedException, AWTException
    {
        List<List<String>> priceGroup=dataTable.asLists(String.class);
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.SubCustomerRefPriceGroupDefaultSchedule(priceGroup);
    }

    @And ("Check for popup to appear to select sub customer reference for Standard order")
    public void checkForPopupToAppearToSelectSubCustomerReferenceForStandardOrder(DataTable dataTable) throws InterruptedException, AWTException
    {
       List<List<String>> subCustRef=dataTable.asLists(String.class);
       orderGuidePage = new OrderGuidePage(driver, scenario);
       orderGuidePage.SubCustomerRefStandardOrder(subCustRef);
   }

   @And ("Check for popup to appear to select sub customer reference for Price group deal group")
   public void checkForPopupToAppearToSelectSubCustomerReferenceForPriceGroupDealGroup(DataTable dataTable) throws InterruptedException, AWTException
   {
       List<List<String>> subCustRef=dataTable.asLists(String.class);
       orderGuidePage = new OrderGuidePage(driver, scenario);
       orderGuidePage.SubCustomerRefPriceGroupDealGroup(subCustRef);
   }

    @And("User should select products from catalog popup for Market segment")
    public void userShouldSelectProductsFromCatalogPopupForMarketSegment()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateCatalogDisplay();
        createOGPage.ResetFilter_Catalog();
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

    @And("User should select products from catalog popup for National chain")
    public void userShouldSelectProductsFromCatalogPopupForNationalChain()
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.ValidateCatalogDisplay();
        createOGPage.ResetFilter_Catalog();
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
}