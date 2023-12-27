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
            adminHomePage.ClickOnHumburger();
            adminHomePage.EnterValueInSearchBox(blacOut);
            adminHomePage.CloseHumburger();
            blackoutAndCutoffPage = new BlackoutAndCutoffPage(driver, scenario);
            blackoutAndCutoffPage.validateBlackoutCutoff();
            flag=true;
        }
    }

    @Then("User should select {string} from horizantal menu to select Cutoff management")
    public void userShouldSelectFromHorizantalMenuToSelectCutoffManagement(String cutOff)
    {
        adminHomePage = new AdminHomePage(driver, scenario);
        adminHomePage.Horizantal_MenuBar(cutOff);
    }

    @And("User should click on Branch management toggle button select branch and set times for cutoff")
    public void userShouldClickOnBranchManagementToggleButtonSelectBranchAndSetTimesForCutoff() throws InterruptedException, AWTException
    {
        cutOffManagementPage=new CutOffManagementPage(driver,scenario);
        cutOffManagementPage.clickOnBranchManagementToggleButton();
        cutOffManagementPage.clickOnFilterBranchToggleButton();
        cutOffManagementPage.clickOnBranchDropdown();
        cutOffManagementPage.selectBranchFromDropdown();
        cutOffManagementPage.clickOnCutOffTimesTogglebutton();
        List<WebElement> Clocks= HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-icon k-i-clock']");
        for(int i=1;i<= Clocks.size();i++)
        {
            cutOffManagementPage.ClickClockIcon(i);
            cutOffManagementPage.SelectHoursForAllDays();
            cutOffManagementPage.SelectMinForAllDays();
            cutOffManagementPage.ClickOnSetButton();
        }
        cutOffManagementPage.clickOnBranchFilterTogglebutton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
        cutOffManagementPage=new CutOffManagementPage(driver,scenario);
        cutOffManagementPage.disableBranchToggleButton();
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.Click_SaveButton();
    }
}
