package stepDefination_DSD_OMS.OrderControlListSteps;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages_DSD_OMS.orderControlListPage.OrderControlListPage;
import pages_DSD_OMS.orderEntry.NewOrderEntryPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import util.RandomValues;
import util.TestBase;

import java.awt.*;
import java.time.Duration;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya Ramadas
 */
public class OrderControlPageSteps2
{
    /* Created by Divya Ramadas */
    WebDriver driver;
    Scenario scenario;
    static String commentText=null;

    static OrderControlListPage orderControlList;
    static NewOrderEntryPage newOE;
    static OrderEntryPage orderpage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User should add customer note using Order control List")
    public void userShouldAddCustomerNoteUsingOrderControlList()
    {
        orderControlList=new OrderControlListPage(driver,scenario);
        commentText= RandomValues.generateRandomString(2000);
        orderControlList.clickOnCustomerNote();
        orderControlList.validateCustomerNotePopup();
        orderControlList.customerNotePopup(commentText);
    }

    @Then("User should verify Note content from popup and select Order guide from popup")
    public void userShouldVerifyNoteContentFromPopupAndSelectOrderGuideFromPopup() throws InterruptedException, AWTException
    {
        orderpage = new OrderEntryPage(driver, scenario);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        for(int i=0;i<=1;i++)
        {
            orderpage.OrderGuidePopup();
            Thread.sleep(1000);
            orderpage.verifyNoteInDialogbox(commentText);
        }
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
    }
}
