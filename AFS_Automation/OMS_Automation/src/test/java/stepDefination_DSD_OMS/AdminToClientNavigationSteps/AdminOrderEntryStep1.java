package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages_DSD_OMS.adminOrderEntry.adminOrderEntryPage;
import pages_DSD_OMS.adminSecurity.AdminSecurityPermissionPage;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;
import java.time.Duration;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminOrderEntryStep1
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String primarySalesRep;
    static AdminHomePage adminHomePage;
    static OrderEntryPage orderpage;
    static NewOrderEntryPage newOE;
    static AdminSecurityPermissionPage adminSecurityPermissionPage;
    static adminOrderEntryPage adminOrder;
    static CheckOutOrderPage checkorder;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should change sales rep other than primary sales rep")
    public void userShouldChangeSalesRepOtherThanPrimarySalesRep() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        primarySalesRep=orderpage.readPrimarySalesRep();
        //orderpage.clearSalesRep();
        orderpage.clickOnSalesRepIndexIcon();
        orderpage.selectSalesRep();
    }

    @And("User should verify Sales rep value")
    public void userShouldVerifySalesRepValue() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.verifySalesRepValue(primarySalesRep);
    }

    @And("User should disable admin settings {string} {string}, for permission")
    public void userShouldDisableAdminSettingsForPermission(String setting, String settingId)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.validateAdminPermissionPage();
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(setting);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(setting);
        adminSecurityPermissionPage.uncheckCheckbox(settingId);
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @And("User should enabled admin settings {string} {string}, for permission")
    public void userShouldEnabledAdminSettingsForPermission(String setting, String settingId)
    {
            adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
            adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
            adminSecurityPermissionPage.searchAdminSettingInSearchBar(setting);
            adminSecurityPermissionPage.validateAdminSettingSearchValue(setting);
            adminSecurityPermissionPage.checkCheckbox(settingId);
            adminHomePage=new AdminHomePage(driver,scenario);
            adminHomePage.Click_SaveButton();
    }

    @Then("Click on Order number in Order Entry page and check for New OE page for payment page visible")
    public void clickOnOrderNumberInOrderEntryPageAndCheckForNewOEPageForPaymentPageVisible() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Select_Order_OrdersGrid();
        //Check if user is on New OE page
//        newOE=new NewOrderEntryPage(driver,scenario);
//          exists=newOE.ValidateNewOE1();
//        Assert.assertEquals(exists,true);
    }

    @And("Click on BackToOrderlist button")
    public void clickOnBackToOrderlistButton() throws InterruptedException, AWTException
    {
        CheckOutSummaryPage checkSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkSummaryPage.clickOnBackToOrderList();
    }

    @Then("Click on Add product drop down and select catalog option for admin setting")
    public void clickOnAddProductDropDownAndSelectCatalogOptionForAdminSetting() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Add_Product_From_Catalog();
    }

    @Then("User clicks on customer account index icon and verify the customer account index dialog box")
    public void userClicksOnCustomerAccountIndexIconAndVerifyTheCustomerAccountIndexDialogBox() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.ValidateOE();
        orderpage.clickOnCustomerAccountIndex();
        orderpage.validateCustomerAccountInex();
        orderpage.validateChangeInLookAndFeelOfCustomerAccountIndex();
        orderpage.clickOnCancelButtonInCustomerAccountDialogBox();
    }

    @Then("User clicks on customer account index icon and verify the customer account index dialog box displaying addfilter and filter headers")
    public void userClicksOnCustomerAccountIndexIconAndVerifyTheCustomerAccountIndexDialogBoxDisplayingAddfilterAndFilterHeaders() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.clickOnCustomerAccountIndex();
        orderpage.validateCustomerAccountInex();
        orderpage.validateChangeInLookAndFeelOfCustomerAccountIndexContainsAddFilter();
        orderpage.clickOnCancelButtonInCustomerAccountDialogBox();
    }

    @Then("User changes the value of Default workflow method to none")
    public void userChangesTheValueOfDefaultWorkflowMethodToNone()
    {
        adminOrder=new adminOrderEntryPage(driver,scenario);
        adminOrder.clickOnDefaultWorkFlow();
        adminOrder.selectFromDefaultWorkFlow();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @Then("User searches for {string} {string} and disable admin setting")
    public void userSearchesForAndDisableAdminSetting(String adminControl, String adminControlId)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(adminControl);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(adminControl);
        adminSecurityPermissionPage.uncheckCheckbox(adminControlId);
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @Then("User searches for {string} {string} and enable admin setting")
    public void userSearchesForAndEnableAdminSetting(String adminControl, String adminControlId)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(adminControl);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(adminControl);
        adminSecurityPermissionPage.checkCheckbox(adminControlId);
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @Then("Click on Order number in Order Entry page and check for New OE page payment page is not visible")
    public void clickOnOrderNumberInOrderEntryPageAndCheckForNewOEPagePaymentPageIsNotVisible() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Select_Order_OrdersGrid();

        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        Thread.sleep(1000);
        //handling toast messages
        for(int i=0;i<=2;i++)
        {
            //check for toast message for low on inventory
            newOE.lowOnInventoryToast();
            //check for toast message for product is currently unavailable
            newOE.toastCurrentlyUnavailable();
        }

        for(int i=0;i<=1;i++)
        {
            newOE.priceCannotBeBleowCost();
            newOE.exceedsMaxQty();
        }
        exists=newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        checkorder=new CheckOutOrderPage(driver,scenario);
        Thread.sleep(4000);
        checkorder.notValidateCheckOrder();
    }

    @Then("Click on Order number in Order Entry page and check for New OE page payment page visible")
    public void clickOnOrderNumberInOrderEntryPageAndCheckForNewOEPagePaymentPageVisible() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Select_Order_OrdersGrid();

        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        Thread.sleep(1000);
        //handling toast messages
        for(int i=0;i<=2;i++)
        {
            //check for toast message for low on inventory
            newOE.lowOnInventoryToast();
            //check for toast message for product is currently unavailable
            newOE.toastCurrentlyUnavailable();
        }

        for(int i=0;i<=1;i++)
        {
            newOE.priceCannotBeBleowCost();
            newOE.exceedsMaxQty();
        }
        exists=newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        checkorder=new CheckOutOrderPage(driver,scenario);
        Thread.sleep(4000);
        checkorder.validateCheckOrder();
        checkorder.NextButton_Click();
    }
}
