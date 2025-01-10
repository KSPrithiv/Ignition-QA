package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class AdminOrderEntryPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;

    //Action
    public AdminOrderEntryPage(WebDriver driver, Scenario scenario)
    {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }
    public void validatingAdminOrderEntryPage() throws InterruptedException
    {
        exists = false;
        String title = null;
        WebElement WebEle;
        String status = null;

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        //Thread.sleep(6000);
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            title = driver.getTitle();
            if (title.contains("Admin"))
            {
                scenario.log("ADMIN PAGE HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

}
