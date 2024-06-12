package pages_DSD_OMS.login;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.TestBase;

import java.awt.*;
import java.time.Duration;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class MyCartPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="checkoutToOrder")
    private WebElement CheOutOrder;

    @FindBy(xpath = "//div[@class='delete-button-container']")
    private WebElement DeleteIcon;

    @FindBy(xpath = "//button/span[contains(@class,'buttonMinus')]")
    private WebElement MinusButton;

    @FindBy(xpath = "//button[contains(@class,'buttonPlus')]")
    private  WebElement PlusButton;


    public MyCartPage(WebDriver driver,Scenario scenario) throws InterruptedException, AWTException
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Click on Check out to order button
    public void CheckOut_To_Order() throws InterruptedException
    {
        exists=false;
        WebElement WebEle;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(CheOutOrder.isDisplayed() && CheOutOrder.isEnabled())
        {
            HelpersMethod.ScrollElement(driver, CheOutOrder);
            HelpersMethod.ActClick(driver, CheOutOrder, 20000);
            exists = true;

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//span[contains(text(),'Select order')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement selectPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebEle = selectPopup.findElement(By.xpath(".//div[contains(text(),'New order')]"));
                HelpersMethod.ActClick(driver, WebEle, 10000);
                WebEle = selectPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, WebEle, 10000);
                Thread.sleep(1000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }

            //to handle pending order popup
            if (HelpersMethod.IsExists("//div[contains(text(),'Pending order will be overwritten')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement pendingPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebElement startButton = pendingPopup.findElement(By.xpath(".//button/span[contains(text(),'Start new order')]"));
                HelpersMethod.ActClick(driver, startButton, 10000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        scenario.log("CHECKOUT TO ORDER HAS BEEN CLICKED");
        Assert.assertEquals(exists,true);
    }

    //Delete button in 'My cart' page
    public void DeleteButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            WebElement Del_But = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'delete-button-container')]//*[local-name()='svg']");
            if(Del_But.isDisplayed() && Del_But.isEnabled())
            {
                HelpersMethod.ActClick(driver, Del_But, 10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                scenario.log("PRODUCT HAS BEEN DELETED FROM MY CART");
                exists=true;
            }
            else
            {
                scenario.log("DELETE BUTTON IS NOT VISIBLE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void navigateToOrderCart()
    {
        try
        {
            Thread.sleep(1000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            String PageTitle = HelpersMethod.gettingTitle(driver);
            Assert.assertEquals(PageTitle, "Order Cart");

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }
}