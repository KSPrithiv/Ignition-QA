package stepDefination_DSD_OMS.AdminReportSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.adminReport.orderAdminPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderAdminPageStep
{
        /* Created by Divya.Ramadas@afsi.com */
        WebDriver driver;
        Scenario scenario;
        static AdminHomePage adminHomePage;
        static orderAdminPage orderadminPage;

        @Before
        public void LaunchBrowser1(Scenario scenario) throws Exception
        {
            this.scenario=scenario;
            TestBase driver1=TestBase.getInstanceOfDriver();
            driver= driver1.getDriver();
        }

        @And("User should enter menu {string} in search bar and select {string}")
        public void user_should_enter_menu_in_search_bar_and_select(String arg0, String arg1)
        {
                adminHomePage = new AdminHomePage(driver, scenario);
                adminHomePage.ClickOnHamburger();
                adminHomePage.EnterValueInSearchBox1(arg0,arg1);
                adminHomePage.handleSaveConfirmationPopup();
        }

    @Then("User selects {string} in Orders page in admin login and validate user is in selected Tab")
    public void userSelectsInOrdersPageInAdminLoginAndValidateUserIsInSelectedTab(String arg0)
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.navigateToDifferentTabsInOrder(arg0);
        orderadminPage.validateTabNavigatedTo(arg0);
    }

    @Then("User selects Customer Accoun# {string}, From and End dates for Creating reports")
    public void userSelectsCustomerAccounFromAndEndDatesForCreatingReports(String arg0) throws InterruptedException
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.selectCustomerAccount(arg0);
        orderadminPage.clickOnFromDate();
        orderadminPage.selectFromDate();
        orderadminPage.clickOnEndDate();
        orderadminPage.selectToDate();
    }

    @And("User click Generate button and clicks on export .csv and clicks on export .pdf")
    public void userClickGenerateButtonAndClicksOnExportCsvAndClicksOnExportPdf()
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.clickOnExportCSV();
        orderadminPage.clickOnDownloadPDF();
    }

    @Then("User click on reset button in Order tab and all the webelement should be clear")
    public void userClickOnResetButtonInOrderTabAndAllTheWebelementShouldBeClear()
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.clickOnResetButton();
        orderadminPage.validateWebElementClear();
    }

    @Then("User click on reset button in Administration tab and all the webelement should be clear")
    public void userClickOnResetButtonInAdministrationTabAndAllTheWebelementShouldBeClear()
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.clickOnResetButton();
        orderadminPage.validateWebElementClear();
    }

    @Then("User click on Download .pdf to download document")
    public void userClickOnDownloadPdfToDownloadDocument()
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.clickOnDownloadPDF();
    }

    @And("User click on clicks on export .csv")
    public void userClickOnClicksOnExportCsv()
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.clickOnExportCSV();
    }

    @And("User selects User name and {string} to genrate report")
    public void userSelectsUserNameAndToGenrateReport(String event) throws InterruptedException
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.clickUserName();
        orderadminPage.userNameSelection();
        orderadminPage.clickOnEvent();
        orderadminPage.selectEventFromDropDown(event);
    }

    @Then("User enters customer account#, From and End dates for Creating reports")
    public void userEntersCustomerAccountFromAndEndDatesForCreatingReports()
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.enterCustomerAccountNo();
        orderadminPage.orderDateCalenderClick();
        orderadminPage.orderDateSelection();
    }

    @And("User clicks on Generate button in Orders tab")
    public void userClicksOnGenerateButtonInOrdersTab()
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.clickOnGenerateButton();
    }

    @Then("User click on reset button in Last user login dates and all the webelement should be clear")
    public void userClickOnResetButtonInLastUserLoginDatesAndAllTheWebelementShouldBeClear()
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.clickOnResetButton();
        orderadminPage.validateWebElementClear1();
    }

    @Then("User click on reset button in Orders, Orders tab and all the webelement should be clear")
    public void userClickOnResetButtonInOrdersOrdersTabAndAllTheWebelementShouldBeClear()
    {
        orderadminPage=new orderAdminPage(driver,scenario);
        orderadminPage.clickOnResetButton();
        orderadminPage.validateWebElementClear2();
    }
}
