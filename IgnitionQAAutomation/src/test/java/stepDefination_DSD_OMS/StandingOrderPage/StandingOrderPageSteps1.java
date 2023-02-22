package stepDefination_DSD_OMS.StandingOrderPage;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.standingOrder.NewStandingOrderCard;
import pages_DSD_OMS.standingOrder.NewStandingOrderPage;
import util.TestBase;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class StandingOrderPageSteps1
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    NewStandingOrderCard standingOrderCard;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should click on Standing Order Register button")
    public void userShouldClickOnStatndingOrderRegisterButton() throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.ClickOnNewStandingOrderArrow();
        standingOrderCard.clickOnStandingOrderRegisterButton();
        standingOrderCard.validateStandingOrderRegisterPopup();
    }

    @Then("User should search for Customer and Route in Standing order register popup")
    public void userShouldSearchForCustomerAndRouteInStandingOrderRegisterPopup() throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.searchForCustomerAccountNo();
        standingOrderCard.clickOnCheckboxForCustomerAcc();
        standingOrderCard.clickRemoveFilterForCustomerAcc();
        standingOrderCard.clickOnShowSelectedCustomerTaggle();
        standingOrderCard.navigateToRoute();
        standingOrderCard.searchForRoute();
        standingOrderCard.clickOnCheckboxForRoute();
        standingOrderCard.clickRemoveFilterForRoute();
        standingOrderCard.clickOnShowSelectedRouteTaggle();
    }

    @And("User should click on Excel button, should download csv files")
    public void userShouldClickOnExcelButtonShouldDownloadCsvFiles() throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.clickOnStandingOrderCardExcel();
    }

    @And("User should click on PDF button, should Open new browser")
    public void userShouldClickOnPDFButtonShouldsOpenNewBrowser() throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.clickOnStandingOrderCardPdf();
    }

    @And("User should click on Generate Standing order  button")
    public void userShouldClickOnGenerateStandingOrderButton()
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.clickOnGenerateStandingOrder();
        standingOrderCard.verifyGenerateStandingOrderPopup();
    }

    @Then("User should select From and To date in Generate standing order\\(s) popup, Click on Ok")
    public void userShouldSelectFromAndToDateInGenerateStandingOrderSPopupClickOnOk() throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.clickOnStartStandingOrderCalender();
        standingOrderCard.selectFromDateForGenerateSO();
        standingOrderCard.clickToDateForGenerateSO();
        standingOrderCard.selectToDateForGenerateSO();
        standingOrderCard.clickOnOkButtonInGenerateSO();
    }

    @And("User should click on ok, in All task completed popup")
    public void userShouldClickOnOkInAllTaskCompletedPopup()
    {
        standingOrderCard.validateGeneratingStandingOrdersForCustomersPopup();
        standingOrderCard.waitTillGeneratingStandingOrdersForCustomersDisappears();
        standingOrderCard.validateAllTasksCompletedPopup();
        standingOrderCard.clickOnViewDetails();
        standingOrderCard.clickOnOkGenerateStandingOrder();
        standingOrderCard.clickOnOkInAllTasksCompleted();
    }
}
