package stepDefination_DSD_OMS.WebOrderingPage;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import pages_DSD_OMS.webOrdering.CutOffManagementPickupOrderPage;
import pages_DSD_OMS.webOrdering.CutOffTimeOverridePage;
import util.TestBase;

import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CutoffTimeOverrideStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;

    static AdminHomePage adminHomePage;
    static CutOffTimeOverridePage cutoffTimeOverride;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User should select {string} from horizantal menu to select Cutoff Time Override")
    public void userShouldSelectFromHorizantalMenuToSelectCutoffTimeOverride(String cutOff)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.Horizantal_MenuBar(cutOff);
    }

    @And("User should click on Branch management toggle button set times for cutoff, Cutoff Time Override Adding Company")
    public void userShouldClickOnBranchManagementToggleButtonSetTimesForCutoffCutoffTimeOverrideAddingCompany()
    {
        cutoffTimeOverride=new CutOffTimeOverridePage(driver,scenario);
        cutoffTimeOverride.clickOnCompanyOverrideToggleButton();
        cutoffTimeOverride.clickOnAddDeliveryDate();
        cutoffTimeOverride.validateAddDeliveryDatePopup();
        cutoffTimeOverride.clickOnCalenderIcon();
        cutoffTimeOverride.clickOnClockIcon();
        cutoffTimeOverride.SelectHours();
        cutoffTimeOverride.SelectMin();
        cutoffTimeOverride.ClickOnTimeSetButton();
        cutoffTimeOverride.clickOnSaveNewBlackout();
    }

    @And("User should click on Branch management toggle button set times for cutoff, Cutoff Time Override Delete Company")
    public void userShouldClickOnBranchManagementToggleButtonSetTimesForCutoffCutoffTimeOverrideDeleteCompany()
    {
        cutoffTimeOverride=new CutOffTimeOverridePage(driver,scenario);
        cutoffTimeOverride.clickOnCompanyOverrideToggleButton();
        cutoffTimeOverride.selectCutOffToDelete();
        cutoffTimeOverride.clickDeleteButton();
        cutoffTimeOverride.confirmationPopupHandle();
    }

    @And("User should click on Branch management toggle button set times for cutoff, Cutoff Time Override Adding Customer")
    public void userShouldClickOnBranchManagementToggleButtonSetTimesForCutoffCutoffTimeOverrideAddingCustomer()
    {
        cutoffTimeOverride=new CutOffTimeOverridePage(driver,scenario);
        cutoffTimeOverride.clickOnCustomerOverrideToggleButton();
        cutoffTimeOverride.clickOnAddDeliveryDate();
        cutoffTimeOverride.validateAddDeliveryDatePopup();
        cutoffTimeOverride.clickOnCalenderIcon();
        cutoffTimeOverride.clickOnClockIcon();
        cutoffTimeOverride.SelectHours();
        cutoffTimeOverride.SelectMin();
        cutoffTimeOverride.ClickOnTimeSetButton();
        cutoffTimeOverride.clickOnSaveNewBlackout();
    }

    @And("User should click on Branch management toggle button set times for cutoff, Cutoff Time Override Delete Customer")
    public void userShouldClickOnBranchManagementToggleButtonSetTimesForCutoffCutoffTimeOverrideDeleteCustomer()
    {
        cutoffTimeOverride=new CutOffTimeOverridePage(driver,scenario);
        cutoffTimeOverride.clickOnCustomerOverrideToggleButton();
        cutoffTimeOverride.selectCutOffToDelete();
        cutoffTimeOverride.clickDeleteButton();
        cutoffTimeOverride.confirmationPopupHandle();
    }
}
