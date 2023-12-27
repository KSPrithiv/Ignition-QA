package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CutOffManagementPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="CPEnableCutoffBranchMgmt")
    private WebElement branchToggle;

    @FindBy(xpath="//div[@id='filter-by-branch']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container']")
    private WebElement filterBranchToggle;

    @FindBy(xpath="//div[@id='filter-by-branch']/descendant::span[@id='filter-by-active-cutoff-times']")
    private WebElement branchFilterCutoffTime;

    @FindBy(xpath="//div[@id='filter-by-branch']/descendant::span[@id='cutoff-branches']")
    private WebElement branchDropdown;

    @FindBy(xpath="//div[@id='filter-by-branch']/descendant::span[@id='cutoff-timezones']")
    private WebElement timeZoneDropdown;

    @FindBy(xpath="//div[@id='cutoff-times']/descendant::span[@class='k-switch-container']")
    private WebElement timeSettingToggle;


    public CutOffManagementPage(WebDriver driver, Scenario scenario)
    {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    public void clickOnBranchManagementToggleButton() 
    {
        exists=false;
        try
        {
            if(branchToggle.isDisplayed())
            {
                HelpersMethod.JScriptClick(driver,branchToggle,1000);
                scenario.log("BRANCH TOGGLE BUTTON SELECTED");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                if(HelpersMethod.IsExists("//span[@id='CPEnableCutoffBranchMgmt' and @aria-checked='true']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnFilterBranchToggleButton()
    {
        exists=false;
        try
        {
            if(filterBranchToggle.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,filterBranchToggle);
               HelpersMethod.JScriptClick(driver,filterBranchToggle,1000);
               scenario.log("FILTER BRANCH TOGGLE BUTTON");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
               if(HelpersMethod.IsExists("//div[@id='filter-by-branch']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container' and @aria-checked='true']",driver))
               {
                   exists=true;
               }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnBranchDropdown()
    {
        exists=false;
        try
        {
            if(branchDropdown.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,branchDropdown);
                HelpersMethod.ClickBut(driver,branchDropdown,1000);
                scenario.log("BRANCH DROPDOWN BUTTON CLICKED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectBranchFromDropdown()
    {
        try
        {
            List<WebElement> options = HelpersMethod.FindByElements(driver, "xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            Random rand = new Random();
            int list= rand.nextInt(options.size());
            options.get(list).click();
            String branchSelect=HelpersMethod.FindByElement(driver,"xpath","//div[@id='filter-by-branch']/descendant::span[@id='cutoff-branches']/span").getText();
            scenario.log("BRANCH SELECTED IS: "+branchSelect);
        }
        catch (Exception e){}
    }

    public void clickOnBranchFilterTogglebutton()
    {
        exists=false;
        try
        {
            if(branchFilterCutoffTime.isDisplayed())
            {
                HelpersMethod.JScriptClick(driver,branchFilterCutoffTime,1000);
                scenario.log("FILTER CUT OFF TIME TOGGLE BUTTON HAS BEEN CLICKED");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                if(HelpersMethod.IsExists("//div[@id='filter-by-branch']/descendant::span[@id='filter-by-active-cutoff-times' and @aria-checked='true']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnCutOffTimesTogglebutton()
    {
        exists=false;
        try
        {
            if(timeSettingToggle.isDisplayed())
            {
                HelpersMethod.JScriptClick(driver,timeSettingToggle,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                if(HelpersMethod.IsExists("//div[@id='cutoff-times']/descendant::span[@class='k-switch-container' and @aria-checked='true']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public int RandomNumber(int max,int min)
    {
        int randomNum=0;
        try
        {
            randomNum= (int) ((Math.random()*(max - min))+ min);
        }
        catch (Exception e){}
        return randomNum;
    }

    public void ClickClockIcon(int i)
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[@id='cutoff-times']");
            HelpersMethod.ScrollElement(driver,WebEle);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr["+i+"]/descendant::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-select']");
            HelpersMethod.JScriptClick(driver,WebEle,1000);
        }
        catch (Exception e){}
    }

    public void SelectHoursForAllDays()
    {
        exists=false;
        int hrSec;
        Actions act=new Actions(driver);
        String hr_text;
        int hr_No;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
            if(HelpersMethod.IsExists("//div[contains(@class,'k-timeselector k-reset')]",driver))
            {
                hrSec=RandomNumber(1,12);
                scenario.log("HOURS SELECTED IS "+hrSec);
                List<WebElement> hrs= HelpersMethod.FindByElements(driver,"xpath","//span[text()='hour']/following-sibling::div/descendant::li/span");
                for(WebElement hr:hrs)
                {
                    act.moveToElement(hr).build().perform();
                    act.click(hr).build().perform();
                    hr_text= hr.getText();
                    hr_No= Integer.parseInt(hr_text);
                    if(hr_No==hrSec)
                    {
                        break;
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void SelectMinForAllDays()
    {
        exists=false;
        int hrSec;
        Actions act=new Actions(driver);
        String min_text;
        int min_No;
        try
        {
            hrSec=RandomNumber(0,59);
            scenario.log("MINITS SELECTED IS "+hrSec);
            List<WebElement> mins= HelpersMethod.FindByElements(driver,"xpath","//span[text()='minute']/following-sibling::div/descendant::li/span");
            for(WebElement min:mins)
            {
                act.moveToElement(min).build().perform();
                act.click(min).build().perform();
                min_text= min.getText();
                min_No= Integer.parseInt(min_text);
                if(min_No==hrSec)
                {
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public  void ClickOnSetButton()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Set']");
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.ActClick(driver,WebEle,1000);
            new WebDriverWait(driver, Duration.ofMillis(100)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
        }
        catch (Exception e){}
    }

    public void disableBranchToggleButton()
    {
        exists=false;
        try
        {
            if(branchToggle.isDisplayed())
            {
                HelpersMethod.JScriptClick(driver,branchToggle,1000);
                scenario.log("BRANCH TOGGLE BUTTON SELECTED");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                if(HelpersMethod.IsExists("//span[@id='CPEnableCutoffBranchMgmt' and @aria-checked='false']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
            Thread.sleep(2000);
        }
        catch (Exception e){}
    }
}
