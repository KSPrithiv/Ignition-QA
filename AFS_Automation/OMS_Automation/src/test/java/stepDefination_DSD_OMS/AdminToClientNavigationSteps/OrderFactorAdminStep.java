package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderFactorAdmin.orderFactorAdminPage;
import pages_DSD_OMS.standingOrder.NewStandingOrderPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class OrderFactorAdminStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static String prodNo;
    static String customer;
    static String orderFactorQty;
    static String Ord_No;
    static boolean exists=false;
    static AdminHomePage adminHomePage;
    static orderFactorAdminPage ordFacorPage;
    static NewOrderEntryPage newOE;
    static HomePage homepage;
    static CheckOutOrderPage checkorder;
    static CheckOutSummaryPage summary;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User should navigate to {string} from horizontal menu to select Order factor, select order factor level {string}")
    public void userShouldNavigateToFromHorizontalMenuToSelectOrderFactorSelectOrderFactorLevel(String arg0, String arg1)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.Horizantal_MenuBar(arg0);
        ordFacorPage=new orderFactorAdminPage(driver,scenario);
        ordFacorPage.validateOrderFactorPage();
        ordFacorPage.orderFactorToggleButton();
        ordFacorPage.clickOnOrderFactorLevel();
        ordFacorPage.selectFactorLevel(arg1);
        ordFacorPage.validateOrderFactorLevel(arg1);
    }

    @And("User should add product to order factor list and add {string} for Order factor by customer and product")
    public void userShouldAddProductToOrderFactorListAndAddForOrderFactorByCustomerAndProduct(String qty) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        customer=TestBase.testEnvironment.FullAcc2();
        ordFacorPage=new orderFactorAdminPage(driver,scenario);
        ordFacorPage.selectCustomer(customer);
        ordFacorPage.clickOnAddProducts();
        ordFacorPage.validateProductDialogbox();
        prodNo=ordFacorPage.readFirstProductInProductDialogBox();
        ordFacorPage.productDialogBoxOkButton();
        ordFacorPage.validateAddingOfProductInOrderFactorGrid(prodNo);
        ordFacorPage.addOrderFactorQty(qty);
        orderFactorQty= ordFacorPage.readOrderFactorQty();
    }

    @And("User should add product to order factor list and add {string} for Order factor at product master level")
    public void userShouldAddProductToOrderFactorListAndAddForOrderFactorAtProductMasterLevel(String qty) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        prodNo = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
        customer=TestBase.testEnvironment.FullAcc2();
        ordFacorPage=new orderFactorAdminPage(driver,scenario);
        ordFacorPage.clickOnAddProducts();
        ordFacorPage.validateProductDialogbox();
        prodNo=ordFacorPage.readFirstProductInProductDialogBox();
        ordFacorPage.productDialogBoxOkButton();
        ordFacorPage.validateAddingOfProductInOrderFactorGrid(prodNo);
        ordFacorPage.addOrderFactorQty(qty);
        orderFactorQty=qty;
    }

    @Then("Enter Pro# in Quick Product Entry area for Order factor")
    public void enterProInQuickProductEntryAreaForOrderFactor() throws InterruptedException, AWTException
    {
        Thread.sleep(2000);
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.QuickProduct(prodNo);
    }

    @And("Check for Case and Unit input box enabled or not based on that enter value for qty to verify order factor")
    public void checkForCaseAndUnitInputBoxEnabledOrNotBasedOnThatEnterValueForQtyToVerifyOrderFactor(DataTable tabledata) throws InterruptedException, AWTException
    {
//        newOE=new NewOrderEntryPage(driver,scenario);
//        List<List<String>> PO_Qty = tabledata.asLists(String.class);
//        String Case=PO_Qty.get(0).get(0);
//        String Unit=PO_Qty.get(0).get(1);
//        String uomString=newOE.VerifyUOM();
//        if(uomString.equalsIgnoreCase("Units")||uomString.equalsIgnoreCase("EA"))
//        {
//            newOE.CheckForQuickUnitEnabled(Unit);
//            if(uomString.equalsIgnoreCase("Units"))
//            {
//                WebElement caseIn = HelpersMethod.FindByElement(driver, "id", "quickCases");
//                if (caseIn.equals(driver.switchTo().activeElement()))
//                {
//                    caseIn.sendKeys(Keys.TAB);
//                }
//            }
//            newOE.exceedsMaxQty();
//            newOE.lowOnInventoryToast();
//            newOE.toastCurrentlyUnavailable();
//        }
//        else if(uomString.equalsIgnoreCase("Cases")||uomString.equalsIgnoreCase("CS"))
//        {
//            newOE.CheckForQuickCaseEnabled(Case);
//            if(uomString.equalsIgnoreCase("Cases"))
//            {
//                WebElement unitIn = HelpersMethod.FindByElement(driver, "id", "quickUnits");
//                if (unitIn.equals(driver.switchTo().activeElement()))
//                {
//                    unitIn.sendKeys(Keys.TAB);
//                }
//            }
//            newOE.exceedsMaxQty();
//            newOE.lowOnInventoryToast();
//            newOE.toastCurrentlyUnavailable();
//        }
//        else if(uomString.equalsIgnoreCase("Cases, Units")||uomString.equalsIgnoreCase("Units, Cases")||uomString.equals("UNITS AND CASES")||uomString.equals("CS AND EA")||uomString.equals("EA AND CS")||uomString.equals("CS, EA")||uomString.equals("EA, CS"))
//        {
//            newOE.CheckForQuickCaseEnabled(Case);
//            newOE.CheckForQuickUnitEnabled(Unit);
//            newOE.exceedsMaxQty();
//            newOE.lowOnInventoryToast();
//            newOE.toastCurrentlyUnavailable();
//        }
//        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='pending-quick-entry-calls']")));
//        Thread.sleep(2000);


        newOE=new NewOrderEntryPage(driver,scenario);
        List<List<String>> PO_Qty = tabledata.asLists(String.class);
        String Case=PO_Qty.get(0).get(0);
        String Unit=PO_Qty.get(0).get(1);
        String uomString=newOE.VerifyUOM();

        if(uomString.equals("Units")||uomString.equals("EA"))
        {
            newOE.CheckForQuickUnitEnabled(Unit);
            if(uomString.equals("Units"))
            {
                WebElement caseIn = HelpersMethod.FindByElement(driver, "id", "quickCases");
                if (caseIn.equals(driver.switchTo().activeElement()))
                {
                    caseIn.sendKeys(Keys.TAB);
                }
            }
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='pending-quick-entry-calls']")));
            newOE.exceedsMaxQty();
            for(int i=0;i<=1;i++)
            {
                //check for toast message for low on inventory
                newOE.lowOnInventoryToast();
                //check for toast message for product is currently unavailable
                newOE.toastCurrentlyUnavailable();
            }
        }
        else if(uomString.equals("Cases")||uomString.equals("CS"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            if(uomString.equals("Cases"))
            {
                WebElement unitIn = HelpersMethod.FindByElement(driver, "id", "quickUnits");
                if (unitIn.equals(driver.switchTo().activeElement()))
                {
                    unitIn.sendKeys(Keys.TAB);
                }
            }
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='pending-quick-entry-calls']")));
            newOE.exceedsMaxQty();
            for(int i=0;i<=1;i++)
            {
                //check for toast message for low on inventory
                newOE.lowOnInventoryToast();
                //check for toast message for product is currently unavailable
                newOE.toastCurrentlyUnavailable();
            }
        }
        else if(uomString.equals("Cases, Units")||uomString.equals("Units, Cases")||uomString.equals("CS, EA")||uomString.equals("EA, CS"))
        {
            newOE.CheckForQuickCaseEnabled(Case);
            newOE.CheckForQuickUnitEnabled(Unit);
            //new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='pending-quick-entry-calls']")));
            newOE.exceedsMaxQty();
            for(int i=0;i<=1;i++)
            {
                //check for toast message for low on inventory
                newOE.lowOnInventoryToast();
                //check for toast message for product is currently unavailable
                newOE.toastCurrentlyUnavailable();
            }
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        Thread.sleep(2000);
    }

    @And("User logs out from Admin site")
    public void userLogsOutFromAdminSite() throws InterruptedException
    {
        homepage=new HomePage(driver,scenario);
        homepage.Click_On_UserIcon();
        homepage.Click_On_Signout();
    }

    @Then("Click on Next button and validate order factor dialog box")
    public void clickOnNextButtonAndValidateOrderFactorDialogBox() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        //handling toast messages
        for(int i=0;i<=1;i++)
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
        newOE.popupAfterNext_OrderFactor();
        newOE.orderFactorPopup(orderFactorQty);
        newOE.popupAfterNext_OrderFactor();

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
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
            //Thread.sleep(4000);
            checkorder=new CheckOutOrderPage(driver,scenario);
            Ord_No=checkorder.readOrderNumber();
            checkorder.Select_PaymentMethod_ClickDownArrow();
            if(HelpersMethod.IsExists("//tr[1]/descendant::td[@class='payment-method-type-cell']",driver))
            {
                checkorder.SelectPaymentMethod();
                scenario.log("FIRST PAYMENT OPTION HAS BEEN SELECTED");
            }
            else
            {
                checkorder.Click_On_Without_Providing_Payment();
                scenario.log("WITHOUT PROVIIDNG PAYMENT OPTION HAS BEEN SELECTED");
            }
            checkorder.DeliveryAddressCard();
            checkorder.NextButton_Click();
        }
    }

    @And("User should delete product from order factor list for Order factor by customer and product")
    public void userShouldDeleteProductFromOrderFactorListForOrderFactorByCustomerAndProduct()
    {
        ordFacorPage=new orderFactorAdminPage(driver,scenario);
        ordFacorPage.selectCustomer(customer);
        ordFacorPage.validateAddingOfProductInOrderFactorGrid(prodNo);
        ordFacorPage.selectProductOfOrderFactor();
        ordFacorPage.clickDelete();
        ordFacorPage.clickDeleteOK();
        ordFacorPage.validateDeleteProductInOrderFactorGrid(prodNo);
    }

    @And("User should delete product from order factor list for Order factor at product master level")
    public void userShouldDeleteProductFromOrderFactorListForOrderFactorAtProductMasterLevel()
    {
        ordFacorPage=new orderFactorAdminPage(driver,scenario);
        ordFacorPage.validateAddingOfProductInOrderFactorGrid(prodNo);
        ordFacorPage.selectProductOfOrderFactor();
        ordFacorPage.clickDelete();
        ordFacorPage.clickDeleteOK();
        ordFacorPage.validateDeleteProductInOrderFactorGrid(prodNo);
    }

    @Then("Click on Submit Order button and read Order_no for order factor")
    public void clickOnSubmitOrderButtonAndReadOrder_noForOrderFactor() throws InterruptedException, AWTException
    {
        summary = new CheckOutSummaryPage(driver,scenario);
        summary.validateSummaryPage();
        summary.ClickSubmit();
        for(int i=0;i<=2;i++)
        {
            summary.additionalOrderPopup();
            summary.cutoffDialog();
            summary.percentageOfAverageProd();
        }
        String sOrd_No = summary.Get_Order_No();
        if(sOrd_No!=null)
        {
            Ord_No=sOrd_No;
        }
        summary.SucessPopup();
    }
}
