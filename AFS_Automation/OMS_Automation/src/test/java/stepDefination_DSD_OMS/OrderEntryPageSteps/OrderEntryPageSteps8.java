package stepDefination_DSD_OMS.OrderEntryPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
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
import org.testng.Assert;
import pages_DSD_OMS.orderEntry.*;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class OrderEntryPageSteps8
{
    /* Created by Divya.Ramadas@afsi.com */

    WebDriver driver;
    Scenario scenario;

    static boolean exists=false;
    static String currenturl;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static OrderEntryPage orderpage;
    static CheckOutOrderPage checkorder;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User searches for Brand and goes through the product numbers")
    public void userSearchesForBrandAndGoesThroughTheProductNumbers() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validateCatalogdialog();
        if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
        {
            if (HelpersMethod.IsExists("//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']", driver))
            {
                newOE.clickOnLoadAllProducts();
                newOE.ResetFilter_Catalog();
                newOE.selectAllProductsCatalogDialogbox();
                newOE.listCatelog();
                newOE.readProductInList();
                newOE.catalogOK();
            }
        }
        else
        {
            if (HelpersMethod.IsExists("//button[@data-test-id='productFilterResetBtn']", driver))
            {
                newOE.clickOnLoadAllProducts();
                newOE.ResetFilter_Catalog();
                newOE.selectAllProductsCatalogDialogbox();
                newOE.cardCatelog();
                newOE.readProductInCard();
                newOE.catalogOK();
            }
        }
    }

    @And("Select Pickup Order from drop down options and select last delivery date")
    public void selectPickupOrderFromDropDownOptionsAndSelectLastDeliveryDate() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver, scenario);
        orderpage.Pickup_Order();
        orderpage.lastPickupOrder();
    }

    @Then("User should be navigated to Order Entry page and compare the dates")
    public void userShouldBeNavigatedToOrderEntryPageAndCompareTheDates() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.comparePickUpDates();
        orderpage.Refresh_Page1();
        //orderpage.Verify_OEPage();
        orderpage.Verify_OE_Title();
    }

    @And("Cancel popup should appear and verify button Cancel and Skip button for current date")
    public void cancelPopupShouldAppearAndVerifyButtonCancelAndSkipButtonForCurrentDate() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        //newOE.OECancel();
        newOE.VerifyCancelPopUp();
        newOE.CancelAndSkipPopupDisabled();
        newOE.CancelPop();
    }

    @And("User searches for QoH and goes through the product numbers")
    public void userSearchesForQoHAndGoesThroughTheProductNumbers(DataTable dataTable) throws InterruptedException, AWTException
    {
        List<List<String>> QoHValue = dataTable.asLists(String.class);
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.validateCatalogdialog();
        if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
        {
            newOE.clickOnLoadAllProducts();
            newOE.ResetFilter_Catalog();
            newOE.selectAllProductsCatalogDialogbox();
            newOE.listCatelogQoH(QoHValue.get(0).get(0));
            newOE.readProductInList();
            newOE.catalogOK();
        }
        else
        {
            newOE.catalogOK();
            scenario.log("<span style='color:red'>THIS SCENARIO WORKS ONLY ON LIST VIEW</span>");
        }
    }

    @And("User should select Product from catalog Index popup search input box and Enter Qty for the products")
    public void userShouldSelectProductFromCatalogIndexPopupSearchInputBoxAndEnterQtyForTheProducts(DataTable tabledata) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException, AWTException
    {
        List<List<String>> Prod_detail = tabledata.asLists(String.class);
        String Prod_No= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Validate_Catalog();
        newOE.clickOnLoadAllProducts();
        newOE.selectAllProductsCatalogDialogbox();
        newOE.ResetFilter_Catalog();
        String pro=String.valueOf(Prod_No);
        //newOE.validateCatalogProducts();
        newOE.Search_Prod_in_CatalogIndexDialogbox(pro);
        newOE.EnterQty(Prod_detail.get(0).get(0),Prod_detail.get(0).get(1));
        scenario.log("PRODUCT # "+pro+" PRODUCT QTY "+Prod_detail.get(0).get(0)+" "+Prod_detail.get(0).get(1));
        newOE.Catalog_OK();
    }

    @And("User should verify that payment options in Payment page are disabled")
    public void userShouldVerifyThatPaymentOptionsInPaymentPageAreDisbled() throws InterruptedException, AWTException
    {
        exists = false;
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Select_Order_OrdersGrid();
        //Check if user is on New OE page
        newOE=new NewOrderEntryPage(driver,scenario);
        exists=newOE.ValidateNewOE1();
        Assert.assertEquals(exists,true);
        newOE.readProductsInOrder();
        exists = newOE.ClickNext();
        newOE.OutOfStockPop_ERP();
        checkorder=new CheckOutOrderPage(driver,scenario);
        //checkorder.VerifyCheckOut();
        checkorder.validatePaymentOptionsDisabled();
        checkorder.NextButton_Click();
    }

    @Then("Click on Next button and read payment methods")
    public void clickOnNextButtonAndReadPaymentMethods() throws InterruptedException, AWTException
    {
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
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        checkorder=new CheckOutOrderPage(driver,scenario);
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            Thread.sleep(4000);
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']",driver))
            {
                currenturl=checkorder.SelectPaymentMethodReadPaymentInfo();
                scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
            }
            else
            {
                checkorder.Click_On_Without_Providing_Payment();
                scenario.log("WITHOUT PROVIDING PAYMENT OPTION HAS BEEN SELECTED");
            }
            checkorder.DeliveryAddressCard();
            checkorder.NextButton_Click();
        }
    }

    @And("Click on SubmitOrder button and compare payment info")
    public void clickOnSubmitOrderButtonAndComparePaymentInfo() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        summary.validatePaymentInSummary(currenturl);
        summary.ClickSubmit();
        for(int i=0;i<=2;i++)
        {
            summary.additionalOrderPopup();
            summary.cutoffDialog();
            summary.percentageOfAverageProd();
        }
        summary.SucessPopup();
    }

    @Then("Click on Next button and select the very first payment option")
    public void clickOnNextButtonAndSelectTheVeryFirstPaymentOption() throws InterruptedException, AWTException
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

        checkorder=new CheckOutOrderPage(driver,scenario);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            Thread.sleep(4000);
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']",driver))
            {
                checkorder.SelectPaymentMethod();
                scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
            }
            checkorder.DeliveryAddressCard();
            checkorder.NextButton_Click();
        }
    }

    @Then("User enters foreign language description of Product in Search box")
    public void userEntersForeignLanguageDescriptionOfProductInSearchBox() throws InterruptedException, AWTException
    {
            newOE = new NewOrderEntryPage(driver,scenario);
            String ProdName= TestBase.testEnvironment.getForeignLangDesc();
            newOE.EnterForignLanguage_InSearchBar(ProdName);
    }
}
