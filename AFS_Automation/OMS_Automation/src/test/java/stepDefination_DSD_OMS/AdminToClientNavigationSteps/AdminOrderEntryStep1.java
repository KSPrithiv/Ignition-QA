package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminCatalogSearch.catalogSearchPage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.CheckOutSummaryPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

import java.awt.*;

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
    static String primarySalesRep=null;
    static OrderEntryPage orderpage;
    static CheckOutSummaryPage checkOutSummaryPage;
    static NewOrderEntryPage newOE;
    static CheckOutSummaryPage summary;
    static AdminHomePage adminHomePage;
    static catalogSearchPage catSearchPage;
    static LoginPage loginPage;

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
        orderpage.clearSalesRep();
        orderpage.clickOnSalesRepIndexIcon();
        orderpage.selectSalesRep();
    }

    @And("User should verify Sales rep value")
    public void userShouldVerifySalesRepValue() throws InterruptedException, AWTException
    {
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.verifySalesRepValue(primarySalesRep);
    }
}
