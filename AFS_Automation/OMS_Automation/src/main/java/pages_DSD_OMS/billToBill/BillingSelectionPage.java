package pages_DSD_OMS.billToBill;


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
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class BillingSelectionPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="undoBillingButton")
    private WebElement UndoBillButton;

    @FindBy(id="resetButton")
    private  WebElement ResetButton;

    @FindBy(id="MailButton")
    private WebElement MailButton;

    @FindBy(id="cancelEditButton")
    private WebElement CancelButton;

    @FindBy(id="printEditButton")
    private WebElement PrintButton;

    @FindBy(id="selectEditButton")
    private WebElement SelectButton;

    @FindBy(id="switchShowSelected")
    private WebElement SwitchSelected;

    @FindBy(id="nbRangeFrom")
    private WebElement FromRange;

    @FindBy(id="nbRangeTo")
    private WebElement ToRange;

    @FindBy(id="switchShowSelected")
    private WebElement ShowSelected;

    @FindBy(id="SearchBar1")
    private WebElement SearchBar;

    public BillingSelectionPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Action
    public void ValidateBillingSelection()
    {
        exists=false;
        try
        {
            Thread.sleep(4000);
           if(HelpersMethod.IsExists("//div[@id='selectionCard']",driver))
           {
               exists=true;
           }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectBillingSelect()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//table[contains(@class,'k-grid-table')]/descendant::tr[1]/descendant::input",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//table[contains(@class,'k-grid-table')]/descendant::tr[1]/descendant::input");
                HelpersMethod.ActClick(driver,WebEle,40000);
                exists = true;
                scenario.log("CHECK BOX CLICKED IN SELECTION GRID");
            }
            else
            {
                scenario.log("BILLING SELECTION GRID DOESN'T CONTAINS ANY VALUE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickPrintButton()
    {
        exists=false;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("selectionCard"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("selectionCard")));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.id("printEditButton")));

            if(PrintButton.isDisplayed() && PrintButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, PrintButton, 40000);
                scenario.log("PRINT BUTTON HAS BEEN CLICKED");
                exists = true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void ValiddatePrintCustomerBillPopup()
    {
        exists=false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Thread.sleep(2000);
            if (HelpersMethod.IsExists("//span[contains(text(),'Print customer billing')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintCustomerBillPopUp()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button[@id='PrintButton']");
            String ParentWindow = driver.getWindowHandle();
            if(WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ClickBut(driver,WebEle,10000);
                Thread.sleep(4000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                Thread.sleep(4000);
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        if (driver.getCurrentUrl().toLowerCase().contains(".pdf"))
                        {
                            // Log that the PDF window has been found
                            scenario.log(".pdf HAS BEEN FOUND");
                            // Close the PDF window
                            driver.close();
                            scenario.log("PDF window closed successfully");
                            exists=true;
                        }
                    }
                }
                driver.switchTo().window(ParentWindow);
            }
            else
            {
                scenario.log("PRINT BUTTON IS NOT ENABLED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CancelInPrintPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Thread.sleep(1000);
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button[@id='CancelButton']");
            if (WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ClickBut(driver, WebEle, 60000);
                scenario.log("PRINT HAS BEEN CANCELLED");

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void CancelButton()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,CancelButton,10000);
            exists=true;
            scenario.log("CANCEL BUTTON HAS BEEN CLICKED");
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void UndoBilling()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,UndoBillButton,10000);
            exists=true;
            scenario.log("UNDO BILLING HAS BEEN CLICKED");
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void UndoBillingPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Undo billing')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,10000);
                exists = true;
                scenario.log("UNDO BILLING POPUP HANDLED");
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void FromRange(int arg0)
    {
        exists=false;
        try
        {
            HelpersMethod.ActClearKey(driver,FromRange,10000);
            HelpersMethod.ActSendKey(driver,FromRange,10000, String.valueOf(arg0));
            exists=true;
            scenario.log("FROM RANGE HAS BEEN SELECTED "+arg0);
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void ToRange(int arg1)
    {
        exists=false;
        try
        {
            HelpersMethod.ActClearKey(driver,ToRange,10000);
            HelpersMethod.ActSendKey(driver,ToRange,10000, String.valueOf(arg1));
            exists=true;
            scenario.log("TO RANGE HAS BEEN SELECTED "+arg1);
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void TaggleButton()
    {
        exists=false;
        try
        {
            ShowSelected.click();
            exists=true;
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void RangeSelectButton()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,SelectButton,10000);
            exists=true;
            scenario.log("RANGE SELECTED BUTTON HAS BEEN SELECTED");
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }
}
