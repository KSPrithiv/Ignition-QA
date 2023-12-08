package stepDefination_DSD_OMS.OrderGuidePage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_DSD_OMS.orderGuide.CreateOGPage;
import pages_DSD_OMS.orderGuide.OrderGuidePage;
import util.TestBase;

import java.awt.*;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class OrderGuidePageStep3
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;

    static boolean exists = false;

    static OrderGuidePage orderGuidePage;
    static CreateOGPage createOGPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("User enters OG Description {string} in search box and Delete cancel the OG verify same in OG grid")
    public void userEntersOGDescriptionInSearchBoxAndDeleteCancelTheOGVerifySameInOGGrid(String arg0) throws InterruptedException, AWTException
    {
        exists = false;
        orderGuidePage = new OrderGuidePage(driver, scenario);
        exists= orderGuidePage.OGSearchBox(arg0);
        Assert.assertEquals(exists,true);
        orderGuidePage.SearchOGSelect(arg0);
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.Click_Delete();
        createOGPage.DeleteCancel_Popup();
        orderGuidePage = new OrderGuidePage(driver, scenario);
        //once OG is deleted, search for OG in OG grid
        exists=orderGuidePage.OGSearchBox(arg0);
        Assert.assertEquals(exists,false);
    }

    @Then("User enters OG Description {string} in search box and Delete the OG verify same in OG grid")
    public void userEntersOGDescriptionInSearchBoxAndDeleteTheOGVerifySameInOGGrid(String arg0) throws InterruptedException, AWTException
    {
        exists = false;
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.ValidateOG();
        exists= orderGuidePage.OGSearchBox(arg0);
        Assert.assertEquals(exists,true);
        orderGuidePage.SearchOGSelect(arg0);
        createOGPage = new CreateOGPage(driver, scenario);
        createOGPage.Click_Delete();
        createOGPage.DeleteOk_Popup();
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.ValidateOG();
        //once OG is deleted, search for OG in OG grid
        exists=orderGuidePage.OGSearchBox(arg0);
        Assert.assertEquals(exists,false);
    }
}
