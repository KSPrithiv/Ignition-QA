package stepDefination_DSD_OMS.CompetitivePricingPageSteps;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.competitivePricing.CompetitivePricingGeneralPage;
import pages_DSD_OMS.competitivePricing.CompetitivePricingReportPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import util.TestBase;

import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CompetitorPricingPageStep1
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static CompetitivePricingReportPage competitivePricingReportPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User navigates to {string} under competitor pricing and select {string} tab under Reports")
    public void userNavigatesToUnderCompetitorPricingAndSelectTabUnderReports(String report, String group)
    {
        HelpersMethod.navigate_Horizantal_Tab(driver, report, "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'"+report+"')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
        competitivePricingReportPage=new CompetitivePricingReportPage(driver,scenario);
        competitivePricingReportPage.validateReport();
        HelpersMethod.navigate_Horizantal_Tab(driver, group, "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'"+group+"')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
        competitivePricingReportPage.validateGroupBy();
    }

    @Then("User should select customer account# in groupOne and even select customer")
    public void userShouldSelectCustomerAccountInGroupOneAndEvenSelectCustomer(DataTable tableData)
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

    @Then("User should select multiple customer account# in groupOne and even select customer")
    public void userShouldSelectMultipleCustomerAccountInGroupOneAndEvenSelectCustomer(DataTable tableData)
    {
        List<List<String>> listValue=tableData.asLists(String.class);
        competitivePricingReportPage=new CompetitivePricingReportPage(driver,scenario);
        competitivePricingReportPage.clickOnGroup1();
        competitivePricingReportPage.selectCustomerAccountOptionDropdown(listValue.get(0).get(0));
        //to select 1st customer account number
        competitivePricingReportPage.clickCustomerAccountIndex();
        competitivePricingReportPage.validateCustomerAccountDialogBox();
        competitivePricingReportPage.clickOnAddfilterToSelectCustomer(listValue.get(0).get(0),TestBase.testEnvironment.get_Account());
        competitivePricingReportPage.selectCustomerAccountInDialogbox();
        //to select 2nd customer account number
        competitivePricingReportPage.clickCustomerAccountIndex();
        competitivePricingReportPage.validateCustomerAccountDialogBox();
        competitivePricingReportPage.clickOnAddfilterToSelectCustomer(listValue.get(0).get(0),TestBase.testEnvironment.get_AnotherAcc());
        competitivePricingReportPage.selectCustomerAccountInDialogbox();
        competitivePricingReportPage.handlePrintButton();
    }

    @Then("User should select customer account# in groupOne and even select customer and select ascending order radio button")
    public void userShouldSelectCustomerAccountInGroupOneAndEvenSelectCustomerAndSelectAscendingOrderRadioButton(DataTable tableData)
    {
        List<List<String>> listValue=tableData.asLists(String.class);
        competitivePricingReportPage=new CompetitivePricingReportPage(driver,scenario);
        competitivePricingReportPage.clickOnGroup1();
        competitivePricingReportPage.selectCustomerAccountOptionDropdown(listValue.get(0).get(0));
        competitivePricingReportPage.clickAscendingRadioButton();
        competitivePricingReportPage.clickCustomerAccountIndex();
        competitivePricingReportPage.validateCustomerAccountDialogBox();
        competitivePricingReportPage.clickOnAddfilterToSelectCustomer(listValue.get(0).get(0),TestBase.testEnvironment.get_Account());
        competitivePricingReportPage.selectCustomerAccountInDialogbox();
        competitivePricingReportPage.handlePrintButton();
    }

    @Then("User should select customer account# in groupOne and even select customer and select descending order radio button")
    public void userShouldSelectCustomerAccountInGroupOneAndEvenSelectCustomerAndSelectDescendingOrderRadioButton(DataTable tableData)
    {
        List<List<String>> listValue=tableData.asLists(String.class);
        competitivePricingReportPage=new CompetitivePricingReportPage(driver,scenario);
        competitivePricingReportPage.clickOnGroup1();
        competitivePricingReportPage.selectCustomerAccountOptionDropdown(listValue.get(0).get(0));
        competitivePricingReportPage.clickDescendingRadioButton();
        competitivePricingReportPage.clickCustomerAccountIndex();
        competitivePricingReportPage.validateCustomerAccountDialogBox();
        competitivePricingReportPage.clickOnAddfilterToSelectCustomer(listValue.get(0).get(0),TestBase.testEnvironment.get_Account());
        competitivePricingReportPage.selectCustomerAccountInDialogbox();
        competitivePricingReportPage.handlePrintButton();
    }
}
