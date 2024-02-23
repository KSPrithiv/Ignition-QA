package stepDefination_DSD_OMS.WebOrderingPageSteps;

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
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CutoffManagementStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean flag=false;

    static AdminHomePage adminHomePage;
    static BlackoutAndCutoffPage blackoutAndCutoffPage;
    static CutOffManagementPage cutOffManagementPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should navigate to {string} tab for Cutoff management")
    public void userShouldNavigateToTabForCutoffManagement(String blacOut)
    {
        if(flag==false)
        {
            adminHomePage = new AdminHomePage(driver, scenario);
            adminHomePage.ClickOnHamburger();
            adminHomePage.EnterValueInSearchBox(blacOut);
            adminHomePage.CloseHamburger();
            blackoutAndCutoffPage = new BlackoutAndCutoffPage(driver, scenario);
            blackoutAndCutoffPage.validateBlackoutCutoff();
            flag=true;
        }
    }

    @Then("User should select {string} from horizontal menu to select Cutoff management")
    public void userShouldSelectFromHorizontalMenuToSelectCutoffManagement(String cutOff)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.Horizantal_MenuBar(cutOff);
    }

    @And("User should click on Branch management toggle button select branch and set times for cutoff")
    public void userShouldClickOnBranchManagementToggleButtonSelectBranchAndSetTimesForCutoff() throws InterruptedException, AWTException
    {
       //Check whether the environment in which scenarios are running supports this admin settings
      // if(HelpersMethod.IsExists("//*[local-name()='g' and @id='dsd']|//*[local-name()='g' and @id='rams']",driver))
      // {
           cutOffManagementPage = new CutOffManagementPage(driver, scenario);
           cutOffManagementPage.clickOnBranchManagementToggleButton();
           cutOffManagementPage.clickOnFilterBranchToggleButton();
           cutOffManagementPage.clickOnBranchDropdown();
           cutOffManagementPage.selectBranchFromDropdown();
           cutOffManagementPage.clickOnCutOffTimesTogglebutton();
           List<WebElement> Clocks = HelpersMethod.FindByElements(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-icon k-i-clock']");
           for (int i = 1; i <= Clocks.size(); i++)
           {
               cutOffManagementPage.ClickClockIcon(i);
               cutOffManagementPage.SelectHoursForAllDays();
               cutOffManagementPage.SelectMinForAllDays();
               cutOffManagementPage.ClickOnSetButton();
           }
           cutOffManagementPage.clickOnBranchFilterTogglebutton();
           adminHomePage = new AdminHomePage(driver, scenario);
           adminHomePage.Click_SaveButton();
           cutOffManagementPage = new CutOffManagementPage(driver, scenario);
           cutOffManagementPage.disableBranchToggleButton();
           adminHomePage = new AdminHomePage(driver, scenario);
           adminHomePage.Click_SaveButton();
    /*   }
       else
       {
           scenario.log("**********SELECTED ENVIRONMENT IS NOT SUPPORTING THIS FEATURE-ONLY DSD AND RAMS SUPPORTS THIS FEATURE*********");
       }*/
    }

    @And("User should click on Warehouse management toggle button select branch and set times for cutoff")
    public void userShouldClickOnWarehouseManagementToggleButtonSelectBranchAndSetTimesForCutoff()
    {
        cutOffManagementPage=new CutOffManagementPage(driver,scenario);
        cutOffManagementPage.clickOnWareHouseManagementToggleButton();
        cutOffManagementPage.clickOnFilterWarehouseToggleButton();
        cutOffManagementPage.clickOnWarehouseDropdown();
        cutOffManagementPage.selectWarehouseFromDropdown();
        cutOffManagementPage.clickOnCutOffTimesTogglebutton();
        List<WebElement> Clocks= HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-icon k-i-clock']");
        for(int i=1;i<= Clocks.size();i++)
        {
            cutOffManagementPage.ClickClockIcon(i);
            cutOffManagementPage.SelectHoursForAllDays();
            cutOffManagementPage.SelectMinForAllDays();
            cutOffManagementPage.ClickOnSetButton();
        }
        cutOffManagementPage.clickOnWarehouseFilterTogglebutton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
        cutOffManagementPage=new CutOffManagementPage(driver,scenario);
        cutOffManagementPage.disableWarehouseToggleButton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @And("User should click on Route management toggle button select branch and set times for cutoff")
    public void userShouldClickOnRouteManagementToggleButtonSelectBranchAndSetTimesForCutoff()
    {
        cutOffManagementPage=new CutOffManagementPage(driver,scenario);
        cutOffManagementPage.clickOnRouteManagementToggleButton();
        cutOffManagementPage.clickOnFilterRouteToggleButton();
        cutOffManagementPage.clickOnRouteDropdown();
        cutOffManagementPage.selectRouteFromDropdown();
        cutOffManagementPage.clickOnCutOffTimesTogglebutton();
        List<WebElement> Clocks= HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-icon k-i-clock']");
        for(int i=1;i<= Clocks.size();i++)
        {
            cutOffManagementPage.ClickClockIcon(i);
            cutOffManagementPage.SelectHoursForAllDays();
            cutOffManagementPage.SelectMinForAllDays();
            cutOffManagementPage.ClickOnSetButton();
        }
        cutOffManagementPage.clickOnRouteFilterTogglebutton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
        cutOffManagementPage=new CutOffManagementPage(driver,scenario);
        cutOffManagementPage.disableRouteToggleButton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }

    @And("User should click on Customer management toggle button select branch and set times for cutoff")
    public void userShouldClickOnCustomerManagementToggleButtonSelectBranchAndSetTimesForCutoff()
    {
        cutOffManagementPage=new CutOffManagementPage(driver,scenario);
        cutOffManagementPage.clickOnCustomerManagementToggleButton();
        cutOffManagementPage.clickOnFilterCustomerManagementToggleButton();
        cutOffManagementPage.clickOnCustomerManagementDropdown();
        cutOffManagementPage.selectCustomerManagementFromDropdown();
        cutOffManagementPage.clickOnCutOffTimesTogglebutton();
        List<WebElement> Clocks= HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-icon k-i-clock']");
        for(int i=1;i<= Clocks.size();i++)
        {
            cutOffManagementPage.ClickClockIcon(i);
            cutOffManagementPage.SelectHoursForAllDays();
            cutOffManagementPage.SelectMinForAllDays();
            cutOffManagementPage.ClickOnSetButton();
        }
        cutOffManagementPage.clickOnCustomerManagementFilterTogglebutton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
        cutOffManagementPage=new CutOffManagementPage(driver,scenario);
        cutOffManagementPage.disableCustomerManagementToggleButton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }
}
