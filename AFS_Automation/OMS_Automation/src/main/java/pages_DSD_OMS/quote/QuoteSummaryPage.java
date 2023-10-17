package pages_DSD_OMS.quote;

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

import java.time.Duration;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class QuoteSummaryPage
{
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="OrdersButton")
    private WebElement BackToOrderList;

    @FindBy(id="ConverToOrderGuideBtn")
    private WebElement ConvertOG;

    @FindBy(id="CopyQuoteBtn")
    private WebElement CopyQuote;

    @FindBy(id="CancelSummaryButton")
    private WebElement CancelButton;

    @FindBy(id="createOrderButton")
    private WebElement ConvertOrder;

    @FindBy(id="EditButton")
    private WebElement EditButton;

    public QuoteSummaryPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void ValidateQuoteSummary()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SummaryCard']")));
            if(HelpersMethod.IsExists("//div[@id='SummaryCard']",driver))
            {
                scenario.log("QUOTE SUMMARY PAGE HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnBackToOrder()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(BackToOrderList.isDisplayed())
            {
                HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.ClickBut(driver,BackToOrderList,1000);
                scenario.log("QUOTE BACK BUTTON HAS BEEN CLICKED");
                exists=true;
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
           /* if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }*/
        }
        catch (Exception e){}
    }

    public void ClickOnConvertOG()
    {
        exists=true;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if(ConvertOG.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,ConvertOG);
                HelpersMethod.ClickBut(driver,ConvertOG,6000);
                scenario.log("CONVERT QUOTE AS ORDER GUIDE");
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnConvertOrder()
    {
        exists=true;
        WebElement WebEle=null;
        try
        {
            Thread.sleep(1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if(ConvertOrder.isDisplayed())
            {
                HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.ClickBut(driver,ConvertOrder,1000);
                scenario.log("QUOTE CONVERT TO ORDER BUTTON CLICKED");
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
            }
            Assert.assertEquals(exists,true);
            exists=false;
            if(HelpersMethod.IsExists("//div[contains(text(),'Convert quote to order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement confirmDialog=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement yesButton=confirmDialog.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ClickBut(driver,yesButton,6000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
                }
            }
            Assert.assertEquals(exists,true);
            Thread.sleep(500);
        }
        catch (Exception e){}
    }

    public void ClickOnCancel()
    {
        exists=true;
        WebElement WebEle=null;
        try
        {
            if(ConvertOrder.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,CancelButton,1000);
                scenario.log("CANCEL BUTTON TO CANCEL QUOTE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
            exists=false;
            if(HelpersMethod.IsExists("//div[contains(text(),'Cancel quote')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnCopy()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
        }
        try
        {
            if(CopyQuote.isDisplayed() && CopyQuote.isEnabled())
            {
                HelpersMethod.ClickBut(driver,CopyQuote,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                scenario.log("QUOTE COPY BUTTON HAS BEEN CLICKED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnEdit()
    {
        exists=false;
        try
        {
            if(EditButton.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,EditButton,1000);
                scenario.log("QUOTE EDIT BUTTON HAS BEEN CLICKED");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void NavgiateBackToOE()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.navigate_Horizantal_Tab(driver, "Orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            scenario.log("NAVIGATED BACK TO ORDER ENTRY");
        }
        catch (Exception e){}
    }
}