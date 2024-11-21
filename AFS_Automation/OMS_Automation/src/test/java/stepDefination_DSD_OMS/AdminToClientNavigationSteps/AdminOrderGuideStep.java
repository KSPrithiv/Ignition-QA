package stepDefination_DSD_OMS.AdminToClientNavigationSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages_DSD_OMS.orderGuide.OrderGuidePage;
import util.TestBase;

import java.awt.*;
import java.time.Duration;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */

public class AdminOrderGuideStep
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static OrderGuidePage orderGuidePage;
    static String currentURL;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @And("User should navigate to Order Guide tab for admin setting")
    public void userShouldNavigateToOrderGuideTabForAdminSetting() throws InterruptedException, AWTException
    {
        WebElement WebEle;
        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order guides')]");
        if (HelpersMethod.EleDisplay(WebEle))
        {
            exists = false;
            orderGuidePage = new OrderGuidePage(driver, scenario);
            HelpersMethod.navigate_Horizantal_Tab(driver, "Order Guides", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order Guides')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order guides')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            exists = orderGuidePage.ValidateOG();
            currentURL=driver.getCurrentUrl();
            Assert.assertEquals(exists, true);
        }
        else
        {
            scenario.log("ORDER GUIDE TAB DOESN'T EXISTS");
        }
    }

    @And("User should validate that customer account# index and customer reference is not visible")
    public void userShouldValidateThatCustomerAccountIndexAndCustomerReferenceIsNotVisible() throws InterruptedException, AWTException
    {
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.ValidateOG();
        orderGuidePage.validateCustomerReferenceAndCustomerAccountIndexNotVisible();
    }

    @And("User should validate that customer account# index and customer reference is visible")
    public void userShouldValidateThatCustomerAccountIndexAndCustomerReferenceIsVisible() throws InterruptedException, AWTException
    {
        orderGuidePage = new OrderGuidePage(driver, scenario);
        orderGuidePage.ValidateOG();
        orderGuidePage.validateCustomerReferenceAndCustomerAccountIndex();
    }
}
