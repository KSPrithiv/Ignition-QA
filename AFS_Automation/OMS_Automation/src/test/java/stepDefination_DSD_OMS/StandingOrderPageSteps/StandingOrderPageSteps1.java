package stepDefination_DSD_OMS.StandingOrderPageSteps;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.standingOrder.NewStandingOrderCard;
import pages_DSD_OMS.standingOrder.NewStandingOrderPage;
import util.TestBase;

import java.awt.*;

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
    static NewStandingOrderCard standingOrderCard;
    static OrderEntryPage orderpage;
    static NewStandingOrderPage standingOrder;

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
    public void userShouldClickOnGenerateStandingOrderButton() throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.ClickOnNewStandingOrderArrow();
        standingOrderCard.clickOnGenerateStandingOrder();
        standingOrderCard.verifyGenerateStandingOrderPopup();
    }

    @Then("User should select From and To date in Generate standing order\\(s) popup, Click on Ok")
    public void userShouldSelectFromAndToDateInGenerateStandingOrderSPopupClickOnOk() throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.clickOnStartStandingOrderCalender();
        standingOrderCard.validateFromStandingOrderCalender();
        standingOrderCard.selectFromDateForGenerateSO();
        standingOrderCard.clickToDateForGenerateSO();
        standingOrderCard.validateToStandingOrderCalender();
        standingOrderCard.selectToDateForGenerateSO();
        standingOrderCard.clickOnOkButtonInGenerateSO();
    }

    @And("User should click on ok, in All task completed popup")
    public void userShouldClickOnOkInAllTaskCompletedPopup()
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.validateGeneratingStandingOrdersForCustomersPopup();
        standingOrderCard.waitTillGeneratingStandingOrdersForCustomersDisappears();
        standingOrderCard.validateAllTasksCompletedPopup();
        standingOrderCard.clickOnViewDetails();
        standingOrderCard.clickOnOkGenerateStandingOrder();
        standingOrderCard.clickOnOkInAllTasksCompleted();
    }

    @And("User should Click on Cancel button")
    public void userShouldClickOnCancelButton()
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.standingOrderCancelButton();
    }

    @And("User click on Start standing order button and selects Start date {int} from current date")
    public void userClickOnStartStandingOrderButtonAndSelectsStartDateFromCurrentDate(int Sdate) throws InterruptedException
    {
        standingOrderCard= new NewStandingOrderCard(driver,scenario);
        standingOrderCard.ClickOnNewStandingOrderArrow();
        standingOrderCard.ClickOnStartStandingOrder();
        standingOrderCard.validateStartAddStandingOrderPopup();
        standingOrderCard.ClickOnStartDateCalender();
        standingOrderCard.SelectStartDate(Sdate);
        standingOrderCard.AddStartStandingOrder();
    }

    @And("User should validate that there is no end date assigned to standing order")
    public void userShouldValidateThatThereIsNoEndDateAssignedToStandingOrder()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        standingOrder.validateEndDate();
    }

    @And("User changes Customer account# for creating SO for some other customer")
    public void userChangesCustomerAccountForCreatingSOForSomeOtherCustomer() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.Change_NewAccount(TestBase.testEnvironment.get_AnotherAcc());
    }

    @And("User should change customer account# back to previous account")
    public void userShouldChangeCustomerAccountBackToPreviousAccount() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.Change_OldAccount(TestBase.testEnvironment.get_Account());
    }

    @Then("User navigates to Standing order card and selects the first expired standing order")
    public void userNavigatesToStandingOrderCardAndSelectsTheFirstExpiredStandingOrder()
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.selectExpiredSO();
    }

    @And("User sucessfuly deletes expired standing order")
    public void userSucessfulyDeletesExpiredStandingOrder() throws InterruptedException
    {
        standingOrderCard=new NewStandingOrderCard(driver,scenario);
        standingOrderCard.deleteExpiredSO();
    }

    @Then("User should validate Standing Order dialog box for SO already existing")
    public void userShouldValidateStandingOrderDialogBoxForSOAlreadyExisting()
    {
        standingOrderCard= new NewStandingOrderCard(driver,scenario);
        standingOrderCard.validateDialogboxSOAllreadyExists();
        standingOrderCard.cancelAddSO();
    }

    @Then("User should validate that Standing order Delivery schedule by default having Every week option")
    public void userShouldValidateThatStandingOrderDeliveryScheduleByDefaultHavingEveryWeekOption()
    {
        standingOrder=new NewStandingOrderPage(driver,scenario);
        //standingOrder.validateStandingOrder();
        standingOrder.validateDeliveryScheduleDate();
    }
}
