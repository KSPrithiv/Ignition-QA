package stepDefination_DSD_OMS.CompetitivePricingPageSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.competitivePricing.CompetitivePricingGeneralPage;
import pages_DSD_OMS.competitivePricing.CompetitivePricingReportPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CompetitorPricingPageERPStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;

    static LoginPage loginpage;
    static HomePage homepage;
    static CompetitivePricingGeneralPage competitivePricingGeneralPage;
    static CompetitivePricingReportPage competitivePricingReportPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= TestBase.getDriver();
    }

    @Then("User should select Group by in groupOne and even select customer")
    public void userShouldSelectGroupByInGroupOneAndEvenSelectCustomer(DataTable tableData)
    {
        List<List<String>> listValue=tableData.asLists(String.class);
        competitivePricingReportPage=new CompetitivePricingReportPage(driver,scenario);
        competitivePricingReportPage.clickOnGroup1();
        competitivePricingReportPage.selectCustomerAccountOptionDropdown(listValue.get(0).get(0));
        competitivePricingReportPage.clickCustomerAccountIndex();
        competitivePricingReportPage.validateCustomerAccountDialogBox();
        competitivePricingReportPage.clickOnAddfilterToSelectCustomer(listValue.get(0).get(0),TestBase.testEnvironment.get_Account());
        competitivePricingReportPage.selectCustomerAccountInDialogbox();
        competitivePricingReportPage.handlePrintButton();
    }

    @Then("User should select Group by in groupOne and even select chain")
    public void userShouldSelectGroupByInGroupOneAndEvenSelectChain(DataTable tableData)
    {
        List<List<String>> listValue=tableData.asLists(String.class);
        competitivePricingReportPage=new CompetitivePricingReportPage(driver,scenario);
        competitivePricingReportPage=new CompetitivePricingReportPage(driver,scenario);
        competitivePricingReportPage.clickOnGroup1();
        competitivePricingReportPage.selectCustomerAccountOptionDropdown(listValue.get(0).get(0));
        competitivePricingReportPage.clickOnChainFromDropDown();
        competitivePricingReportPage.selectChineFromDropDown();
        competitivePricingReportPage.handlePrintButton();
    }
}
