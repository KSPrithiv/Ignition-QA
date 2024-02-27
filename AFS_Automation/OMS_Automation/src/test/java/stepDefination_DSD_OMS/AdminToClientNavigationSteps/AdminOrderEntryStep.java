package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
public class AdminOrderEntryStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static OrderEntryPage orderpage;
    static CheckOutSummaryPage checkOutSummaryPage;
    static NewOrderEntryPage newOE;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User selects Account# for Admin side setting")
    public void userSelectsAccountForAdminSideSetting() throws InterruptedException, AWTException, ParseException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.ChangeAccount();
        orderpage.Read_DeliveryDate();
    }

    @Then("User should find out whether orders are already created or not")
    public void userShouldFindOutWhetherOrdersAreAlreadyCreatedOrNot() throws InterruptedException, AWTException
    {
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.validateExistingOrder();
    }

    @And("Click on SubmitOrder button to verify Existing order dialog box")
    public void clickOnSubmitOrderButtonToVerifyExistingOrderDialogBox() throws InterruptedException, AWTException
    {
        boolean exists=false;
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        exists=checkOutSummaryPage.validateExistingOrderNotDisplayed();
        for(int i=0;i<=2;i++)
        {
            checkOutSummaryPage.additionalOrderPopup();
            checkOutSummaryPage.cutoffDialog();
        }
        checkOutSummaryPage.SucessPopup();
        Assert.assertEquals(exists,true);
    }

    @And("Click on SubmitOrder button to display of Existing order dialog box")
    public void clickOnSubmitOrderButtonToDisplayOfExistingOrderDialogBox() throws InterruptedException, AWTException
    {
        boolean exists=false;
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        exists=checkOutSummaryPage.validateExistingOrderNotDisplayed();
        for(int i=0;i<=2;i++)
        {
            checkOutSummaryPage.additionalOrderPopup();
            checkOutSummaryPage.cutoffDialog();
        }
        checkOutSummaryPage.SucessPopup();
        Assert.assertEquals(exists,false);
    }

    @And("User should handle different dialog box that appears before creating order")
    public void userShouldHandleDifferentDialogBoxThatAppearsBeforeCreatingOrder() throws InterruptedException, AWTException, ParseException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.NavigateToOrderEntry();
        orderpage.Read_DeliveryDate();
        newOE=new NewOrderEntryPage(driver,scenario);
        newOE.Discard_All_Pending_Order();
        orderpage=new OrderEntryPage(driver,scenario);
        orderpage.NoPendingOrderPopup();
    }

    @And("Click on SubmitOrder button and click on cancel button when Order exists dialog box appears")
    public void clickOnSubmitOrderButtonAndClickOnCancelButtonWhenOrderExistsDialogBoxAppears() throws InterruptedException, AWTException
    {
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        checkOutSummaryPage.validateExistingOrderCancel();
    }

    @And("Click on SubmitOrder button and click on No button when Order exists dialog box appears")
    public void clickOnSubmitOrderButtonAndClickOnNoButtonWhenOrderExistsDialogBoxAppears() throws InterruptedException, AWTException
    {
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        checkOutSummaryPage.validateExistingOrderCancel();
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.Cancel_Button();
        checkOutSummaryPage.CancelPop();
    }

    @Then("User should select Order Entry tab for admin")
    public void userShouldSelectOrderEntryTabForAdmin() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        orderpage.NavigateToOrderEntry();
    }

    @And("Click on SubmitOrder button to display of Existing order dialog box after enabling admin setting")
    public void clickOnSubmitOrderButtonToDisplayOfExistingOrderDialogBoxAfterEnablingAdminSetting() throws InterruptedException, AWTException
    {
        boolean exists=false;
        checkOutSummaryPage=new CheckOutSummaryPage(driver,scenario);
        checkOutSummaryPage.validateSummaryPage();
        checkOutSummaryPage.ClickSubmit();
        exists=checkOutSummaryPage.validateExistingOrderNotDisplayed();
        for(int i=0;i<=2;i++)
        {
            checkOutSummaryPage.additionalOrderPopup();
            checkOutSummaryPage.cutoffDialog();
        }
        checkOutSummaryPage.SucessPopup();
        Assert.assertEquals(exists,true);
    }
}
