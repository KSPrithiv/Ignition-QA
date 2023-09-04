package stepDefination_DSD_OMS.OrderEntryPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.TestBase;

import java.awt.*;

public class OrderEntryPageEnd
{
    WebDriver driver;
    Scenario scenario;

    OrderEntryPage orderpage;
    static String currentURL=null;

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
}
