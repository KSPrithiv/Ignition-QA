package stepDefination_DSD_OMS.OrderGuidePage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.orderGuide.OrderGuidePage;
import util.TestBase;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    static String Prod_No=null;
    static String OGDis=null;
    static String WDay=null;

    static OrderGuidePage orderGuidePage;
    static CreateOGPage createOGPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("User enters OG Description {string} in search box and Delete the OG verify same in OG grid")
    public void userEntersOGDescriptionInSearchBoxAndDeleteTheOGVerifySameInOGGrid(String arg0) throws InterruptedException, AWTException
    {
        exists = false;
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists= orderGuidePage.OGSearchBox(arg0);
        Assert.assertEquals(exists,true);
        orderGuidePage.SearchOGSelect(arg0);
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.Click_Delete();
        createOGPage.DeleteOk_Popup();
        orderGuidePage = new OrderGuidePage(driver, scenario);
        //once OG is deleted, search for OG in OG grid
        exists=orderGuidePage.OGSearchBox(arg0);
        Assert.assertEquals(exists,false);
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
    public void userShouldMakeSureThatCustomerReferenceIsSameAsOfSelectedInOGPage(String custRef)
    {
        createOGPage=new CreateOGPage(driver,scenario);
        createOGPage.validateCustomerReference(custRef);
    }

    @Then("User enters OG Description {string} in search box and Delete cancel the OG verify same in OG grid")
    public void userEntersOGDescriptionInSearchBoxAndDeleteCancelTheOGVerifySameInOGGrid(String arg0) throws InterruptedException, AWTException
    {
        exists = false;
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists= orderGuidePage.OGSearchBox(arg0);
        Assert.assertEquals(exists,true);
        orderGuidePage.SearchOGSelect(arg0);
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.Click_Delete();
        createOGPage.DeleteCancel_Popup();
        orderGuidePage = new OrderGuidePage(driver, scenario);
        //once OG is deleted, search for OG in OG grid
        exists=orderGuidePage.OGSearchBox(arg0);
        Assert.assertEquals(exists,false);
    }

    @Then("User should select header in OG grid for {string} functionality")
    public void userShouldSelectHeaderInOGGridForFunctionality(String TableHead) throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.FindtableHeader(TableHead);
        orderGuidePage.DisplayGroupDetails();
    }

    @And("Check for popup to appear to select sub customer reference for market segment")
    public void checkForPopupToAppearToSelectSubCustomerReferenceForMarketSegment() throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.selectSubMarketRef();
    }

    @And("Check for popup to appear to select sub customer reference for National chain")
    public void checkForPopupToAppearToSelectSubCustomerReferenceForNationalChain() throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.selectSubMarketRef();
    }

    @And("Clear filter to display both active and inactive OG")
    public void clearFilterToDisplayBothActiveAndInactiveOG() throws InterruptedException, AWTException
    {
        orderGuidePage=new OrderGuidePage(driver,scenario);
        orderGuidePage.clickAddFilterClear();
    }
}