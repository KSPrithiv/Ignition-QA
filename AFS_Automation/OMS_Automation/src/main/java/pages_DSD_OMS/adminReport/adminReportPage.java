package pages_DSD_OMS.adminReport;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.checkerframework.common.value.qual.EnsuresMinLenIf;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class adminReportPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(xpath="//label[@id='StartDate-label']/following-sibling::span/descendant::button")
    private WebElement fromDate;

    @FindBy(xpath="//label[@id='EndDate-label']/following-sibling::span/descendant::button")
    private WebElement toDate;

    @FindBy(id="StartDate")
    private WebElement fDate;

    @FindBy(id="EndDate")
    private WebElement eDate;

    @FindBy(xpath="//button/span[text()='Generate']")
    private WebElement generateButton;

    @FindBy(xpath="//button/span[text()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//button/span[text()='Export']")
    private WebElement exportCSV;

    @FindBy(xpath="//button/span[text()='Download']")
    private WebElement downloadPdf;

    public adminReportPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void clickOnStartCalender()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,fromDate,10000);
            exists=true;
            new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-datepicker-popup')]")));
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }
    public void clickOnEndCalender()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,toDate,1000);
            exists=true;
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-datepicker-popup')]")));
            Assert.assertTrue(exists);
        }
        catch(Exception e){}
    }
    public void selectStartDate() throws InterruptedException
    {
        Thread.sleep(500);
        try
        {
            WebElement WebEle;
            String FTDate;
            exists=false;
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-datepicker-popup')]",driver))
            {
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-datepicker-popup')]/descendant::tr[@role='row'][1]/td[@aria-selected='false'][1]|//div[contains(@class,'k-datepicker-popup')]/descendant::tr[@role='row'][1]/td[@aria-selected='true'][1]");
                if(ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 10000);
                    WebEle=HelpersMethod.FindByElement(driver,"id","StartDate");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,10000);
                    scenario.log(FTDate+" HAS BEEN SELECTED AS START DATE SELECTED");
                    exists=true;
                }
                else
                {
                    scenario.log("NOT ABLE TO SELECT THE DATE");
                }
                Assert.assertTrue(exists);
            }
        }
        catch (Exception e) {}
    }
    public void selectEndDate()
    {
        exists=false;
        WebElement WebEle;
        String FTDate;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-datepicker-popup')]",driver))
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'k-datepicker-popup')]/descendant::td[contains(@class,'k-focus')]",driver))
                {
                    WebElement toDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-datepicker-popup')]/descendant::td[contains(@class,'k-focus')]");
                    HelpersMethod.JSScroll(driver, toDate);
                    HelpersMethod.ActClick(driver, toDate, 10000);
                    WebEle=HelpersMethod.FindByElement(driver,"id","EndDate");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,10000);
                    scenario.log(FTDate+" HAS BEEN SELECTED AS END DATE SELECTED");
                    exists=true;
                }
                else
                {
                    scenario.log("THERE IS NO FOCUSSED DATE");
                }
                Assert.assertTrue(exists);
            }
        }
        catch (Exception e){}
    }
    public void clickOnGenerate()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("WebPaymentsReportCreate"))));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("WebPaymentsReportCreate")));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text()='Generate']")));


            if(generateButton.isDisplayed() && generateButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, generateButton, 4000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists = true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnExportCSV()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(exportCSV.isDisplayed() && exportCSV.isEnabled())
            {
                HelpersMethod.ClickBut(driver, exportCSV, 10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                scenario.log("TO GENERATE THE FILE IN .csv FORMATE BUTTON HAS BEEN CLICKED");
                exists = true;
                if (HelpersMethod.IsExists("//div[contains(text(),'The report returned no data. Choose other parameters.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement dialogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton = dialogPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ClickBut(driver, okButton, 10000);
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnDownloadPDF()
    {
        exists=false;
        try
        {
            if(downloadPdf.isDisplayed() && downloadPdf.isEnabled())
            {
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, downloadPdf, 10000);
                scenario.log("TO GENERATE THE REPORT IN .pdf FORMATE BUTTON HAS BEEN CLICKED");

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

                Thread.sleep(6000);
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        Thread.sleep(1000);
                        driver.switchTo().window(PCwind);
                        Thread.sleep(500);
                        if (driver.getCurrentUrl().toLowerCase().contains(".pdf"))
                        {
                            // Log that the PDF window has been found
                            scenario.log(".pdf HAS BEEN FOUND");
                            // Close the PDF window
                            Thread.sleep(500);
                            driver.close();
                            scenario.log("PDF window closed successfully");
                            exists=true;
                        }
                    }
                }
                Thread.sleep(1000);
                driver.switchTo().window(ParentWindow);
                exists=true;
                scenario.log("CONTROL TRANSFERED TO MAIN WINDOW");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnDownloadPDFForAdmin()
    {
        exists=false;
        WebElement downloadPdf=HelpersMethod.FindByElement(driver,"xpath","//button/span[text()='Download']");
        try
        {
            String adminReportWindow = driver.getWindowHandle();
            if(downloadPdf.isDisplayed() && downloadPdf.isEnabled())
            {
                HelpersMethod.ClickBut(driver, downloadPdf, 10000);
                scenario.log("TO GENERATE THE REPORT IN .pdf FORMATE BUTTON HAS BEEN CLICKED");

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
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if(HelpersMethod.IsExists("//span[text()='Report']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Report']/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::button");
                    HelpersMethod.ActClick(driver,okButton,20000);
                    exists=true;
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                Thread.sleep(2000);
                Set<String> allWindows = driver.getWindowHandles();
                if(allWindows.size()>1)
                {
                    for (String handle : allWindows)
                    {
                        if (!handle.equals(adminReportWindow))
                        {
                            Thread.sleep(4000);
                            // Switch to each child window
                            driver.switchTo().window(handle);
                            // Optionally check the URL or title to confirm if this is the window you want to close
                            String url = driver.getCurrentUrl();
                            scenario.log("Closing window with URL: " + url);
                            Thread.sleep(500);
                            // Use JavaScript to force-close the window
                            ((JavascriptExecutor) driver).executeScript("window.close();");
                            Thread.sleep(1000);
//                            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cpadmin']"))));
//                            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cpadmin']")));
                            exists=true;
                            Thread.sleep(2000);
                        }
                    }
                }
                Thread.sleep(2000);
                // Switch back to the parent window
                driver.switchTo().window(adminReportWindow);
                scenario.log("YOU ARE IN MAIN WINDOW");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void resetButtonClick()
    {
        exists=false;
        try
        {
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

            if(resetButton.isDisplayed() && resetButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, resetButton, 10000);
                scenario.log("ALL VALUES HAVE BEEN RESET");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateWebElementInWebPage()
    {
        exists=false;
        try
        {
            String fromValue=HelpersMethod.JSGetValueEle(driver,fDate,10000);
            String toValue=HelpersMethod.JSGetValueEle(driver,eDate,10000);
            if(fromValue.equals("MM/DD/YYYY") && toValue.equals("MM/DD/YYYY"))
            {
                scenario.log("RESET BUTTON HAS BEEN CLICKED");
                exists=true;
            }
            else
            {
                scenario.log("RESET BUTTON IS NOT WORKING");
                exists=false;
            }
            Assert.assertTrue(exists);
            Thread.sleep(2000);
        }
        catch(Exception e){}
    }

    public void clickOnToDateLastLoginUser()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//label[@id='toDate-label']/following-sibling::span/descendant::button",driver))
            {
                WebElement toCalender = HelpersMethod.FindByElement(driver, "xpath", "//label[@id='toDate-label']/following-sibling::span/descendant::button");
                HelpersMethod.ActClick(driver, toCalender, 10000);
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void toDateLastLoginUser()
    {
        exists = false;
        try
        {
            if (HelpersMethod.IsExists("//div[@id='toDate-popup-id']", driver))
            {
                WebElement dateSelection = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@class,'k-today')]");
                HelpersMethod.ActClick(driver, dateSelection, 10000);
                exists = true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e) {}
    }

    public void excludeDates()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//label[contains(text(),'Exclude')]/parent::div/preceding-sibling::span",driver))
            {
                WebElement excludeDateToggle = HelpersMethod.FindByElement(driver, "xpath", "//label[contains(text(),'Exclude')]/parent::div/preceding-sibling::span");
                HelpersMethod.ActClick(driver, excludeDateToggle, 10000);
            }
            if (HelpersMethod.IsExists("//span[contains(@class,'k-switch-on')]", driver))
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}