package stepDefination_DSD_OMS.OrderEntryPageSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

import java.awt.*;
import java.time.Duration;

public class OrderEntryPageEnd
{
    WebDriver driver;
    Scenario scenario;

    static OrderEntryPage orderpage;
    static NewOrderEntryPage newOE;
    static CheckOutOrderPage checkorder;

    static String currentURL;
    static boolean exists=false;
    static String Ord_No;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User refreshes page")
    public void userRefreshesPage() throws InterruptedException, AWTException
    {
        currentURL=driver.getCurrentUrl();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.Refresh_Page(currentURL);
    }

    @Given("User must be on Order Entry Page to Skip Order")
    public void userMustBeOnOrderEntryPageToSkipOrder() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.HandleError_Page();
        orderpage.Refresh_Page1();
        orderpage.ClickCalender();
        orderpage.ResetToCurrentDate();
        orderpage.ChangedDeliveryDate();
    }

    @Then("Click on Next button and verify for duplicate product")
    public void clickOnNextButtonAndVerifyForDuplicateProduct() throws InterruptedException, AWTException
    {
        exists=false;
        newOE = new NewOrderEntryPage(driver,scenario);
        newOE.readProductsInOrder();
        newOE.findDuplicateProducts();
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
        Ord_No=checkorder.readOrderNumber();
        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
        {
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
}
