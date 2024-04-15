package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;

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
}
