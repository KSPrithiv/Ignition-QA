package stepDefination_DSD_OMS.OrderEntryPageSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages_DSD_OMS.orderEntry.CheckOutOrderPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.sql.SQLException;
import java.time.Duration;

public class OrderEntryPageERP
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

    @Then("Enter Pro# in Quick Product Entry area for substitute product")
    public void enterProInQuickProductEntryAreaForSubstituteProduct() throws InterruptedException, AWTException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        newOE = new NewOrderEntryPage(driver,scenario);
        String prod= TestBase.testEnvironment.getSubstituteProd();
        Thread.sleep(500);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(!prod.equals(null))
        {
            newOE.QuickProduct(prod);
        }
        else
        {
            scenario.log("NOT ABLE TO FETCH PRODUCT# FROM DATABASE");
        }
    }

    @And("User should handle substitute product dialog box by using Ok button")
    public void userShouldHandleSubstituteProductDialogBoxByUsingOkButton() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.validateSubstituteProduct();
        newOE.readStubstitueProductName();
        newOE.substituteProductOk();
    }

    @And("User should handle substitute product dialog box by using skip substitute button")
    public void userShouldHandleSubstituteProductDialogBoxByUsingSkipSubstituteButton() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.ValidateNewOE();
        newOE.validateSubstituteProduct();
        newOE.substituteProductSkipSubstitute();
    }
}
