package stepDefination_DSD_OMS.WebOrderingPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import pages_DSD_OMS.webOrdering.BlackoutAndCutoffPage;
import util.TestBase;

import java.text.ParseException;

/**
 * @Project Divya.Ramadas@telusagcd.com
 * @Author Divya.Ramadas
 */
public class BlackoutAndCutoffStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;

    static AdminHomePage adminHomePage;
    static BlackoutAndCutoffPage blackoutAndCutoffPage;


    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should navigate to {string} tab")
    public void userShouldNavigateToTab(String blackout)
    {
        if(flag==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHumburger();
            adminHomePage.EnterValueInSearchBox(blackout);
            adminHomePage.CloseHumburger();
            blackoutAndCutoffPage = new BlackoutAndCutoffPage(driver, scenario);
            blackoutAndCutoffPage.validateBlackoutCutoff();
            flag=true;
        }
    }

    @Then("User should click on Add blackout button and enter all required value in dialog box")
    public void userShouldClickOnAddBlackoutButtonAndEnterAllRequiredValueInDialogBox()
    {
        blackoutAndCutoffPage=new BlackoutAndCutoffPage(driver,scenario);
        blackoutAndCutoffPage.clickOnAddButton();
        blackoutAndCutoffPage.validateAddBlackoutDialogbox();
        blackoutAndCutoffPage.selectDateForBlackout();
        blackoutAndCutoffPage.noOfDaysWarning();
        blackoutAndCutoffPage.blackoutMessage();
        blackoutAndCutoffPage.clickSaveButton();
        blackoutAndCutoffPage.saveConfirmationPopup();
    }

    @Then("User clicks on Edit button and change message and save blackouts")
    public void userClicksOnEditButtonAndChangeMessageAndSaveBlackouts() throws ParseException
    {
        blackoutAndCutoffPage=new BlackoutAndCutoffPage(driver,scenario);
        blackoutAndCutoffPage.selectBlackOutDateFromGrid();
        blackoutAndCutoffPage.clickOnEditButton();
        blackoutAndCutoffPage.validateEditBlackoutDialog();
        blackoutAndCutoffPage.editBalckoutDetails();
        blackoutAndCutoffPage.clickSaveButton();
        blackoutAndCutoffPage.saveConfirmationPopup();
    }

    @Then("User clicks on Delete button and save changes")
    public void userClicksOnDeleteButtonAndSaveChanges() throws ParseException
    {
        blackoutAndCutoffPage=new BlackoutAndCutoffPage(driver,scenario);
        blackoutAndCutoffPage.selectBlackOutDateForDeleteFromGrid();
        blackoutAndCutoffPage.clickOnDeleteButton();
        blackoutAndCutoffPage.validateDeleteDialogBox();
        blackoutAndCutoffPage.clickOnOkButton();
        blackoutAndCutoffPage.confirmDeletePopup();
    }

    @Then("User should select customer account# in blackout")
    public void userShouldSelectCustomerAccountInBlackout()
    {
        blackoutAndCutoffPage=new BlackoutAndCutoffPage(driver,scenario);
        blackoutAndCutoffPage.clickOnCustomerSelectionDropDown();
        blackoutAndCutoffPage.selectCustomerFromDropDown();
    }

    @Then("User clicks on Edit button for customer account and change message and save blackouts")
    public void userClicksOnEditButtonForCustomerAccountAndChangeMessageAndSaveBlackouts()
    {
        blackoutAndCutoffPage=new BlackoutAndCutoffPage(driver,scenario);
        blackoutAndCutoffPage.selectBlackOutDateForDeleteFromGrid();
        blackoutAndCutoffPage.clickOnEditButton();
        blackoutAndCutoffPage.validateEditBlackoutDialog();
        blackoutAndCutoffPage.editBalckoutDetails();
        blackoutAndCutoffPage.clickSaveButton();
        blackoutAndCutoffPage.saveConfirmationPopup();
    }

    @Then("User clicks on Delete button and save changes for blackouts")
    public void userClicksOnDeleteButtonAndSaveChangesForBlackouts()
    {
        blackoutAndCutoffPage=new BlackoutAndCutoffPage(driver,scenario);
        blackoutAndCutoffPage.selectBlackOutDateForDeleteFromGridForCustomer();
        blackoutAndCutoffPage.clickOnDeleteButton();
        blackoutAndCutoffPage.validateDeleteDialogBox();
        blackoutAndCutoffPage.clickOnOkButton();
        blackoutAndCutoffPage.confirmDeletePopup();
    }
}
