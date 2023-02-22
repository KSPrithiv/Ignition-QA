package stepDefination_DSD_OMS.OrderControlList;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import pages_DSD_OMS.orderEntry.*;
import util.TestBase;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderControlPageSteps1
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    LoginPage loginpage;
    HomePage homepage;
    OrderEntryPage orderpage;
    NewOrderEntryPage newOE;
    CheckOutSummaryPage summary;
    OrderHistoryPage orderhistory;
    CheckOutOrderPage checkorder;
    OrderControlListPage orderControlList;

    static boolean exists=false;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User enters Route# in Route search input box and count number of rows in OCL grid")
    public void userEntersRouteInRouteSearchInputBoxAndCountNumberOfRowsInOCLGrid()
    {
    }

}
