package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages_DSD_OMS.adminCatalogSearch.catalogSearchPage;
import pages_DSD_OMS.adminSecurity.AdminSecurityPermissionPage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import pages_DSD_OMS.webOrdering.AdminOrderEntryPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminOrderEntryStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String Ord_No;
    static OrderEntryPage orderpage;
    static CheckOutSummaryPage checkOutSummaryPage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static AdminHomePage adminHomePage;
    static catalogSearchPage catSearchPage;
    static LoginPage loginPage;
    static AdminOrderEntryPage adminOrderEntryPage;
    static AdminSecurityPermissionPage adminSecurityPermissionPage;
    static CheckOutOrderPage checkorder;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Given("User enters URL and is on login page and entered credentials for Admin settings")
    public void userEntersUrlAndIsOnLoginPageAndEnteredCredentialsForAdminSettings() throws InterruptedException, AWTException
    {
            loginPage = new LoginPage(driver, scenario);
            loginPage.EnterUsername(TestBase.testEnvironment.getAdminUser());
            loginPage.EnterPassword(TestBase.testEnvironment.getAdminPass());
            loginPage.ClickSignin();
    }

    @When("User is on Home Page for Admin settings")
    public void userIsOnHomePageForAdminSettings() throws InterruptedException
    {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ValidatingAdminHome();
    }

    @Then("User Clicks on Permissions by drop down to select Customer Account#s")
    public void userClicksOnPermissionsByDropDownToSelectCustomerAccounts() throws InterruptedException
    {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickPermissionBy();
            adminHomePage.SelectCompany();
    }

    @Then("User selects Account# for Admin side setting")
    public void userSelectsAccountForAdminSideSetting() throws InterruptedException, AWTException, ParseException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ChangeAccount();
        for(int i=0;i<=1;i++)
        {
            orderpage.OrderGuidePopup();
            Thread.sleep(2000);
            orderpage.NoNotePopHandling();
            orderpage.NoPendingOrderPopup();
            orderpage.blackoutDialogHandling();
        }
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.verificationOfNewOE();
        if(exists==true)
        {
            newOE.Click_Back_But();
        }
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        orderpage.Read_DeliveryDate();
    }

    @Then("User should find out whether orders are already created or not")
    public void userShouldFindOutWhetherOrdersAreAlreadyCreatedOrNot() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.validateExistingOrder();
    }

    @And("Click on SubmitOrder button to verify Existing order dialog box")
    public void clickOnSubmitOrderButtonToVerifyExistingOrderDialogBox() throws InterruptedException, AWTException
    {
        boolean exists=false;
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        exists=checkOutSummaryPage.validateExistingOrderNotDisplayed();
        for(int i=0;i<=2;i++)
        {
            checkOutSummaryPage.additionalOrderPopup();
            checkOutSummaryPage.cutoffDialog();
        }
        checkOutSummaryPage.SucessPopup();
        Assert.assertEquals(exists,true);
    }

    @And("Click on SubmitOrder button to display of Existing order dialog box")
    public void clickOnSubmitOrderButtonToDisplayOfExistingOrderDialogBox() throws InterruptedException, AWTException
    {
        boolean exists=false;
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        //exists=checkOutSummaryPage.validateExistingOrderNotDisplayed();
        for(int i=0;i<=2;i++)
        {
            exists=checkOutSummaryPage.validateExistingOrderNotDisplayed();
            checkOutSummaryPage.additionalOrderPopup();
            checkOutSummaryPage.cutoffDialog();
        }
        checkOutSummaryPage.SucessPopup();
        Assert.assertEquals(exists,false);
    }

    @And("User should handle different dialog box that appears before creating order")
    public void userShouldHandleDifferentDialogBoxThatAppearsBeforeCreatingOrder() throws InterruptedException, AWTException, ParseException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.NavigateToOrderEntry();
        orderpage.Read_DeliveryDate();
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Discard_All_Pending_Order();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NoPendingOrderPopup();
    }

    @And("Click on SubmitOrder button and click on cancel button when Order exists dialog box appears")
    public void clickOnSubmitOrderButtonAndClickOnCancelButtonWhenOrderExistsDialogBoxAppears() throws InterruptedException, AWTException
    {
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        checkOutSummaryPage.validateExistingOrderCancel();
    }

    @And("Click on SubmitOrder button and click on No button when Order exists dialog box appears")
    public void clickOnSubmitOrderButtonAndClickOnNoButtonWhenOrderExistsDialogBoxAppears() throws InterruptedException, AWTException
    {
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        checkOutSummaryPage.validateExistingOrderNo();
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.Cancel_Button();
        checkOutSummaryPage.CancelPop();
    }

    @Then("User should select Order Entry tab for admin")
    public void userShouldSelectOrderEntryTabForAdmin() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.NavigateToOrderEntry();
    }

    @And("Click on SubmitOrder button to display of Existing order dialog box after enabling admin setting")
    public void clickOnSubmitOrderButtonToDisplayOfExistingOrderDialogBoxAfterEnablingAdminSetting() throws InterruptedException, AWTException
    {
        boolean exists=false;
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        exists=checkOutSummaryPage.validateExistingOrderDisplayed();
        for(int i=0;i<=2;i++)
        {
            checkOutSummaryPage.additionalOrderPopup();
            checkOutSummaryPage.cutoffDialog();
        }
        checkOutSummaryPage.SucessPopup();
        Assert.assertEquals(exists,true);
    }

//    @And("Click on SubmitOrder button to verify sucess error message on submitting")
//    public void clickOnSubmitOrderButtonToVerifyErrorMessageOnSubmitting() throws InterruptedException, AWTException
//    {
//        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
//        checkOutSummaryPage.validateSummaryPage();
//        checkOutSummaryPage.ClickSubmitOE();
//        summary = new CheckOutSummaryPage(driver,scenario);
//        for(int i=0;i<=2;i++)
//        {
//            summary.additionalOrderPopup();
//            summary.cutoffDialog();
//            summary.percentageOfAverageProd();
//        }
 //       summary = new CheckOutSummaryPage(driver,scenario);
//        summary.validateSummaryPage();
 //       summary.ClickSubmit();
//        for(int i=0;i<=2;i++)
//        {
//            summary.additionalOrderPopup();
//            summary.cutoffDialog();
//            summary.percentageOfAverageProd();
//        }
//        summary.SucessPopup();
//    }

    @Then("User should be navigated to Order Entry page and verify the success or error submitting message")
    public void userShouldBeNavigatedToOrderEntryPageAndVerifyTheSuccessErrorSubmittingMessage() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.validateSucessOrErrorSubmittingMessage();
    }

    @Then("User should be navigated to Order Entry page and verify the success error submitting message is not displayed")
    public void userShouldBeNavigatedToOrderEntryPageAndVerifyTheSuccessErrorSubmittingMessageIsNotDisplayed() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        //orderpage.ValidateOE();
        orderpage.validateNoSucessOrErrorSubmittingMessage();
    }

    @Then("Enter PO# for New order and Po mandatory message should display")
    public void enterPOForNewOrderAndPoMandatoryMessageShouldDisplay(DataTable tabledata) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NO_NotePopup();
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validatePOMandatoryMessage();
        List<List<String>> PO_No = tabledata.asLists(String.class);
        newOE.EnterPO_No(PO_No.get(0).get(0));
    }

    @Then("Enter PO# for New order and Po mandatory message should not display")
    public void enterPOForNewOrderAndPoMandatoryMessageShouldNotDisplay(DataTable tabledata) throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NO_NotePopup();
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validatePONoMandatoryMessage();
        List<List<String>> PO_No = tabledata.asLists(String.class);
        newOE.EnterPO_No(PO_No.get(0).get(0));
    }

    @Then("User must click Start Order button should be disabled")
    public void userMustClickStartOrderButtonShouldBeDisabled() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        //check for 'Start Order' button
        orderpage.Scroll_start();
        orderpage.Start_OrderDisabled();
    }

    @Then("User should check start order button enabled click Start Order button")
    public void userShouldCheckStartOrderButtonEnabledClickStartOrderButton() throws InterruptedException, AWTException
    {
        exists=false;
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        orderpage.ordersExistingInOE();
        //check for 'Start Order' button
        orderpage.Scroll_start();
        orderpage.Start_OrderMultipleOrderPerDay();
    }

    @Then("User should be navigated to Order Entry page and display all orders created")
    public void userShouldBeNavigatedToOrderEntryPageAndDisplayAllOrdersCreated() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Refresh_Page1();
        //orderpage.Verify_OEPage();
        orderpage.Verify_OE_Title();
        orderpage.ordersExistingInOE();
    }

    @And("User should verify products are not auto loaded select Product from catalog and Enter Qty for the products")
    public void userShouldVerifyProductsAreNotAutoLoadedSelectProductFromCatalogAndEnterQtyForTheProducts(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        String Prod_No= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        newOE.Validate_Catalog();
        newOE.validateNoAutoLoadProducts();
        newOE.clickOnLoadAllProducts();
        newOE.ResetFilter_Catalog();
        String pro=String.valueOf(Prod_No);
        newOE.validateDisplayCatalogProducts();
        newOE.Search_Prod_in_Catalog(pro);
        newOE.EnterQty(Prod_detail.get(0).get(0),Prod_detail.get(0).get(1));
        newOE.Catalog_OK();
    }

    @And("User should verify products are auto loaded select Product from catalog and Enter Qty for the products")
    public void userShouldVerifyProductsAreAutoLoadedSelectProductFromCatalogAndEnterQtyForTheProducts(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        String Prod_No= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        newOE.Validate_Catalog();
        newOE.validateAutoLoadProducts();
        newOE.ResetFilter_Catalog();
        newOE.selectAllProductsCatalogDialogbox();
        newOE.validateDisplayCatalogProducts();
        newOE.Search_Prod_in_Catalog(Prod_No);
        newOE.EnterQty(Prod_detail.get(0).get(0),Prod_detail.get(0).get(1));
        //scenario.log("PRODUCT # "+Prod_No+" PRODUCT QTY "+Prod_detail.get(0).get(0)+" "+Prod_detail.get(0).get(1));
        newOE.Catalog_OK();
    }

    @And("User should enter menu {string} in search bar to navigate to catalog search")
    public void userShouldEnterMenuInSearchBarToNavigateToCatalogSearch(String arg0)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.ClickOnHamburger();
        adminHomePage.EnterValueInSearchBox(arg0);
        adminHomePage.removeUnwantedDialogbox();
        adminHomePage.CloseHamburger();
        catSearchPage=new catalogSearchPage(driver,scenario);
        catSearchPage.validateCatalogSearchPage();
    }

    @And("User should save all the details")
    public void userShouldSaveAllTheDetails()
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.Click_SaveButton();
    }

    @Then("User should select {string} in Catalog search layout and enable Do not load full catalog automatically")
    public void userShouldSelectInCatalogSearchLayoutAndEnableDoNotLoadFullCatalogAutomatically(String arg0)
    {
        catSearchPage=new catalogSearchPage(driver,scenario);
        catSearchPage.clickCatalogSearchLayout();
        catSearchPage.selectCatalogSearchLayout(arg0);
        catSearchPage.doNotLoadFullCatalogAutomaticallyEnable();
        catSearchPage.enableDoNotLoadFullCatalogAutomatically();
    }

    @Then("User should select {string} in Catalog search layout and disable Do not load full catalog automatically")
    public void userShouldSelectInCatalogSearchLayoutAndDisableDoNotLoadFullCatalogAutomatically(String arg0)
    {
        catSearchPage=new catalogSearchPage(driver,scenario);
        catSearchPage.clickCatalogSearchLayout();
        catSearchPage.selectCatalogSearchLayout(arg0);
        catSearchPage.doNotLoadFullCatalogAutomaticallyDisable();
        catSearchPage.disableDoNotLoadFullCatalogAutomatically();
    }

    @And("User should enter menu {string} in search bar to navigate to order entry search")
    public void userShouldEnterMenuInSearchBarToNavigateToOrderEntrySearch(String arg0) throws InterruptedException
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.removeUnwantedDialogbox();
        adminHomePage.ClickOnHamburger();
        adminHomePage.EnterValueInSearchBox(arg0);
        //adminHomePage.CloseHamburger();
        adminOrderEntryPage=new AdminOrderEntryPage(driver,scenario);
        adminOrderEntryPage.validatingAdminOrderEntryPage();
    }

    @Then("User must click Start Order button for Admin setting testing")
    public void userMustClickStartOrderButtonForAdminSettingTesting() throws InterruptedException, AWTException
    {
        exists=false;
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.verificationOfNewOE();
        if(exists==true)
        {
            newOE.Click_Back_But();
        }
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ValidateOE();
        //find whether route is empty or not, if empty should select some route value
        orderpage.validateRouteValue();
        //check for 'Start Order' button
        orderpage.Scroll_start();
        exists=orderpage.Start_Order();
    }

    @And("User should disable admin settings {string} {string}")
    public void userShouldDisableAdminSettings(String setting, String settingId)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(setting);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(setting);
        adminSecurityPermissionPage.uncheckCheckbox(settingId);
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @And("User should enabled admin settings {string} {string}")
    public void userShouldEnabledAdminSettings(String setting, String settingId)
    {
        adminSecurityPermissionPage=new AdminSecurityPermissionPage(driver,scenario);
        adminSecurityPermissionPage.searchAdminSettingInSearchBarClear();
        adminSecurityPermissionPage.searchAdminSettingInSearchBar(setting);
        adminSecurityPermissionPage.validateAdminSettingSearchValue(setting);
        adminSecurityPermissionPage.uncheckCheckbox(settingId);
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @Then("Click on Next button and validate that checkout order page not visible")
    public void clickOnNextButtonAndValidateThatCheckoutOrderPageNotVisible() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
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
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[@id='checkoutCard']",driver))
        {
            exists=true;
            checkorder=new CheckOutOrderPage(driver,scenario);
            if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
            {
                Thread.sleep(4000);
                Ord_No = checkorder.readOrderNumber();
                checkorder.Select_PaymentMethod_ClickDownArrow();
                if (HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']", driver))
                {
                    checkorder.SelectPaymentMethod();
                    scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
                } else
                {
                    checkorder.Click_On_Without_Providing_Payment();
                    scenario.log("WITHOUT PROVIIDNG PAYMENT OPTION HAS BEEN SELECTED");
                }
                checkorder.DeliveryAddressCardNotEditable();
                checkorder.NextButton_Click();
            }
        }
        Assert.assertEquals(exists,true);
    }

    @Then("Click on Next button and validate that checkout order page is visible")
    public void clickOnNextButtonAndValidateThatCheckoutOrderPageIsVisible() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
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
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[@id='checkoutCard']",driver))
        {
          exists=true;
          checkorder=new CheckOutOrderPage(driver,scenario);
          if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
          {
              Thread.sleep(4000);
              Ord_No = checkorder.readOrderNumber();
              checkorder.Select_PaymentMethod_ClickDownArrow();
              if (HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']", driver))
              {
                  checkorder.SelectPaymentMethod();
                  scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
              } else
              {
                  checkorder.Click_On_Without_Providing_Payment();
                  scenario.log("WITHOUT PROVIIDNG PAYMENT OPTION HAS BEEN SELECTED");
              }
              checkorder.DeliveryAddressCard1();
              checkorder.NextButton_Click();
          }
        }
        Assert.assertEquals(exists,true);
    }

    @Then("User must click Start Order button for Admin setting")
    public void userMustClickStartOrderButtonForAdminSetting() throws InterruptedException, AWTException
    {
        exists=false;
        if (HelpersMethod.IsExists("//div[@id='order-search-card']", driver))
        {
            orderpage = new OrderEntryPage(driver, scenario);
            orderpage.ValidateOE();
            //find whether route is empty or not, if empty should select some route value
            orderpage.validateRouteValue();
            //check for 'Start Order' button
            orderpage.Scroll_start();
            exists = orderpage.Start_OrderForAdmin();
        }
    }

    @And("User click on Question mark and selects Sales help option and check for non existance")
    public void userClickOnQuestionMarkAndSelectsSalesHelpOptionAndCheckForNonExistance() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.selectSaleshelp();
        orderpage.selectSaleshelpDisable();
    }


}
