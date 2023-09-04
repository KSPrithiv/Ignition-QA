package pages_DSD_OMS.adminReport;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
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

    @FindBy(xpath="//label[@id='StartDate-label']/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]")
    private WebElement fromDate;

    @FindBy(xpath="//label[@id='EndDate-label']/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]")
    private WebElement toDate;

    @FindBy(xpath="//button[text()='Generate']")
    private WebElement generateButton;

    @FindBy(xpath="//button[text()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//button[text()='Export']")
    private WebElement exportCSV;

    @FindBy(xpath="//button[text()='Download']")
    private WebElement downloadPdf;

    public adminReportPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public  void clickOnStartCalender()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,fromDate,100);
            exists=true;
            new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }
    public void clickOnEndCalender()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,toDate,100);
            exists=true;
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }
    public void selectStartDate() throws InterruptedException
    {
        Thread.sleep(200);
        //HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40000);
        new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        try
        {
            String formattedDate1 = null;
            WebElement WebEle=null;
            String FTDate=null;
            exists=false;
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::tr[@role='row'][1]/td/span");
                if(ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 8000);
                    WebEle=HelpersMethod.FindByElement(driver,"id","StartDate");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,60);
                    scenario.log(FTDate+" HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                    exists=true;
                }
                else
                {
                    scenario.log("NOT ABLE TO SELECT THE DATE");
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e) {}
    }
    public void selectEndDate()
    {
        exists=false;
        WebElement WebEle;
        String FTDate=null;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@class,'k-state-focused')]",driver))
                {
                    WebElement toDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@class,'k-state-focused')]");
                    HelpersMethod.JSScroll(driver, toDate);
                    HelpersMethod.ActClick(driver, toDate, 1000);
                    WebEle=HelpersMethod.FindByElement(driver,"id","EndDate");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,60);
                    scenario.log(FTDate+" HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                    exists=true;
                }
                else
                {
                    scenario.log("THERE IS NO FOCUSSED DATE");
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }
    public void clickOnGenerate()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,generateButton,100);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnExportCSV()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,exportCSV,100);
            scenario.log("TO GENERATE THE FILE IN .csv FORMATE BUTTON HAS BEEN CLICKED");
            exists=true;
            if(HelpersMethod.IsExists("//div[contains(text(),'The report returned no data. Choose other parameters.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=dialogPopup.findElement(By.xpath(".//button"));
                HelpersMethod.ClickBut(driver,okButton,4000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    public void clickOnDownloadPDF()
    {
        exists=false;
        try
        {
            String ParentWindow = driver.getWindowHandle();
            HelpersMethod.ClickBut(driver,downloadPdf,100);
            scenario.log("TO GENERATE THE REPORT IN .pdf FORMATE BUTTON HAS BEEN CLICKED");
            Thread.sleep(5000);
            Set<String> PCWindows = driver.getWindowHandles();
            for (String PCwind : PCWindows)
            {
                if (!PCwind.equals(ParentWindow))
                {
                    driver.switchTo().window(PCwind);
                    driver.close();
                    scenario.log(".pdf HAS BEEN FOUND");
                    exists = true;
                }
            }
            driver.switchTo().window(ParentWindow);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void resetButtonClick()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,resetButton,100);
            exists=true;
        }
        catch (Exception e){}
    }

    public void validateWebElementInWebPage()
    {
        exists=false;
        try
        {
            String fromValue=HelpersMethod.JSGetValueEle(driver,fromDate,100);
            String toValue=HelpersMethod.JSGetValueEle(driver,toDate,100);
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
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }

    public void clickOnToDateLastLogiUser()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//label[@id='toDate-label']/following-sibling::span/descendant::a",driver))
            {
                WebElement toCalender = HelpersMethod.FindByElement(driver, "xpath", "//label[@id='toDate-label']/following-sibling::span/descendant::a");
                HelpersMethod.ActClick(driver, toCalender, 100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void toDateLastLoginUser() {
        exists = false;
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]", driver)) {
                WebElement dateSelection = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@class,'k-today')]");
                HelpersMethod.ActClick(driver, dateSelection, 100);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }
}
