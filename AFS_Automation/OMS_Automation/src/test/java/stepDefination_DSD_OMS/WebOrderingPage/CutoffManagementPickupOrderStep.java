package stepDefination_DSD_OMS.WebOrderingPage;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import pages_DSD_OMS.webOrdering.BlackoutAndCutoffPage;
import pages_DSD_OMS.webOrdering.CutOffManagementPage;
import pages_DSD_OMS.webOrdering.CutOffManagementPickupOrderPage;
import util.TestBase;

import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CutoffManagementPickupOrderStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;

    static AdminHomePage adminHomePage;
    static CutOffManagementPickupOrderPage cutoffManagementPickupOrder;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User should select {string} from horizantal menu to select Cutoff management_pickup order")
    public void userShouldSelectFromHorizantalMenuToSelectCutoffManagement_pickupOrder(String cutOff)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.Horizantal_MenuBar(cutOff);
    }

    @And("User should click on Branch management toggle button select branch and set times for cutoff, Cutoff management_pickup order")
    public void userShouldClickOnBranchManagementToggleButtonSelectBranchAndSetTimesForCutoffCutoffManagement_pickupOrder()
    {
        cutoffManagementPickupOrder=new CutOffManagementPickupOrderPage(driver,scenario);
        cutoffManagementPickupOrder.clickOnBranchManagementToggleButton();
        cutoffManagementPickupOrder.clickOnFilterBranchToggleButton();
        cutoffManagementPickupOrder.clickOnBranchDropdown();
        cutoffManagementPickupOrder.selectBranchFromDropdown();
        cutoffManagementPickupOrder.clickOnCutOffTimesTogglebutton();
        List<WebElement> Clocks= HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-icon k-i-clock']");
        for(int i=1;i<= Clocks.size();i++)
        {
            cutoffManagementPickupOrder.ClickClockIcon(i);
            cutoffManagementPickupOrder.SelectHoursForAllDays();
            cutoffManagementPickupOrder.SelectMinForAllDays();
            cutoffManagementPickupOrder.ClickOnSetButton();
        }
        cutoffManagementPickupOrder.clickOnBranchFilterTogglebutton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
        cutoffManagementPickupOrder=new CutOffManagementPickupOrderPage(driver,scenario);
        cutoffManagementPickupOrder.disableBranchToggleButton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @And("User should click on Warehouse management toggle button select branch and set times for cutoff, Cutoff management_pickup order")
    public void userShouldClickOnWarehouseManagementToggleButtonSelectBranchAndSetTimesForCutoffCutoffManagement_pickupOrder()
    {
        cutoffManagementPickupOrder=new CutOffManagementPickupOrderPage(driver,scenario);
        cutoffManagementPickupOrder.clickOnWarehouseManagementToggleButton();
        cutoffManagementPickupOrder.clickOnFilterWarehouseToggleButton();
        cutoffManagementPickupOrder.clickOnWarehouseDropdown();
        cutoffManagementPickupOrder.selectWarehouseFromDropdown();
        cutoffManagementPickupOrder.clickOnCutOffTimesTogglebutton();
        List<WebElement> Clocks= HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-icon k-i-clock']");
        for(int i=1;i<= Clocks.size();i++)
        {
            cutoffManagementPickupOrder.ClickClockIcon(i);
            cutoffManagementPickupOrder.SelectHoursForAllDays();
            cutoffManagementPickupOrder.SelectMinForAllDays();
            cutoffManagementPickupOrder.ClickOnSetButton();
        }
        cutoffManagementPickupOrder.clickOnWarehouseFilterTogglebutton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
        cutoffManagementPickupOrder=new CutOffManagementPickupOrderPage(driver,scenario);
        cutoffManagementPickupOrder.disableWarehouseToggleButton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }
}
