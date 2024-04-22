package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.quote.NewQuotePage;
import pages_DSD_OMS.standingOrder.NewStandingOrderPage;
import util.TestBase;

import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminQuoteStep {
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static NewQuotePage newQuotePage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit for Admin settings")
    public void enterProInQuickProductEntryAreaInNewQutoePageAndEnterQtyForCaseAndUnitForAdminSettings(DataTable tabledata) {
        List<List<String>> QtyValue = tabledata.asLists(String.class);
        newQuotePage = new NewQuotePage(driver, scenario);
        newQuotePage.validateNewQuote();
        newQuotePage.EnterQuickProductNoForHideZero();
        newQuotePage.QtyInGrid(QtyValue.get(0).get(0), QtyValue.get(0).get(1));
        newQuotePage.validateQuickAndGridProduct();
    }

    @Then("Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit for Admin disable settings")
    public void enterProInQuickProductEntryAreaInNewQutoePageAndEnterQtyForCaseAndUnitForAdminDisableSettings(DataTable tabledata) {
        List<List<String>> QtyValue = tabledata.asLists(String.class);
        newQuotePage = new NewQuotePage(driver, scenario);
        newQuotePage.validateNewQuote();
        newQuotePage.EnterQuickProductNoForNotHideZero();
        newQuotePage.QtyInGrid(QtyValue.get(0).get(0), QtyValue.get(0).get(1));
        newQuotePage.validateQuickAndGridProduct();
    }
}
