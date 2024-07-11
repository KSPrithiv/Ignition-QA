package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.time.Duration;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminLoginStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static OrderEntryPage orderpage;
    static LoginPage loginpage;
    static String CurrentURL = null;
    static String tLogin=null;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User click on Question mark and should validate no sales help option displayed")
    public void userClickOnQuestionMarkAndShouldValidateNoSalesHelpOptionDisplayed() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.clickQuestionMark();
        orderpage.validateNoSalesHelp();
    }

    @And("User click on Question mark and should validate no ecomerce help option displayed")
    public void userClickOnQuestionMarkAndShouldValidateNoEcomerceHelpOptionDisplayed() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.clickQuestionMark();
        orderpage.validateNoeCommerceHelp();
    }

    @And("Verify Register here link is visible in login page")
    public void verifyRegisterHereLinkIsVisibleInLoginPage() throws InterruptedException, AWTException
    {
        loginpage = new LoginPage(driver, scenario);
        loginpage.validateLoginPageTitle();
        loginpage.validateRegisterHere();
    }

    @And("Verify Register here link is non visible in login page")
    public void verifyRegisterHereLinkIsNonVisibleInLoginPage() throws InterruptedException, AWTException
    {
        loginpage = new LoginPage(driver, scenario);
        loginpage.validateLoginPageTitle();
        loginpage.validateNonRegisterHere();
    }

    @And("User click on Question mark and selects ecommerce option and check for non existance")
    public void userClickOnQuestionMarkAndSelectsEcommerceOptionAndCheckForNonExistance() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        driver.navigate().refresh();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        orderpage.nonExistenceOfSelecteCommerceOption();
    }

    @When("User enters URL and is on login page for admin setting")
    public void userEntersURLAndIsOnLoginPageForAdminSetting() throws InterruptedException
    {
        scenario.log("LOADED APPLICATION URL");
        CurrentURL=driver.getCurrentUrl();
        scenario.log(CurrentURL);
        tLogin=driver.getTitle();
        driver.navigate().refresh();
        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
    }
}
