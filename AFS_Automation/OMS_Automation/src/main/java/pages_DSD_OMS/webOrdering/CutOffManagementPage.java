package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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

    @FindBy(id="CPEnableCutoffWarehouseMgmt")
    private WebElement wareHouseToggle;

    @FindBy(id="CPEnableCutoffRouteMgmt")
    private WebElement routeToggle;

    @FindBy(id="CPEnableCutoffCustomerMgmt")
    private WebElement customerToggle;

    @FindBy(xpath="//div[@id='filter-by-branch']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container']")
    private WebElement filterBranchToggle;

    @FindBy(xpath="//div[@id='filter-by-warehouse']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container']")
    private WebElement filterWarehouseToggle;

    @FindBy(xpath="//div[@id='filter-by-route']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container']")
    private WebElement filterRouteToggle;

    @FindBy(xpath = "//div[@id='filter-by-customer']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container']")
    private WebElement filterCustomerMangementToggle;

    @FindBy(xpath="//div[@id='filter-by-branch']/descendant::span[@id='filter-by-active-cutoff-times']")
    private WebElement branchFilterCutoffTime;

    @FindBy(xpath="//div[@id='filter-by-warehouse']/descendant::span[@id='filter-by-active-cutoff-times']")
    private WebElement wareHouseFilterCutoffTime;

    @FindBy(xpath="//div[@id='filter-by-route']/descendant::span[@id='filter-by-active-cutoff-times']")
    private WebElement routeManagementFilterCutoffTime;

    @FindBy(xpath="//div[@id='filter-by-customer']/descendant::span[@id='filter-by-active-cutoff-times']")
    private WebElement customerManagementFilterCutoffTime;

    @FindBy(xpath="//div[@id='filter-by-branch']/descendant::span[@id='cutoff-branches']")
    private WebElement branchDropdown;

    @FindBy(xpath="//div[@id='filter-by-warehouse']/descendant::span[@id='cutoff-branches']")
    private WebElement wareHouseDropDown;

    @FindBy(xpath="//div[@id='filter-by-route']/descendant::span[@id='cutoff-branches']")
    private WebElement routeManagementDropDown;

    @FindBy(xpath="//div[@id='filter-by-customer']/descendant::span[@id='cutoff-branches']")
    private WebElement customerManagementDropDown;

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
                if(!HelpersMethod.IsExists("//span[@id='CPEnableCutoffBranchMgmt' and @aria-checked='true']",driver))
                {
                    HelpersMethod.JScriptClick(driver, branchToggle, 10000);
                    scenario.log("BRANCH TOGGLE BUTTON SELECTED");
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
                }
                    if (HelpersMethod.IsExists("//span[@id='CPEnableCutoffBranchMgmt' and @aria-checked='true']", driver))
                    {
                        exists = true;
                    }
            }
            Assert.assertTrue(exists);
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
                HelpersMethod.ScrollElement(driver, filterBranchToggle);
                if(!HelpersMethod.IsExists("//div[@id='filter-by-branch']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container' and @aria-checked='true']",driver))
                {
                    HelpersMethod.JScriptClick(driver, filterBranchToggle, 1000);
                    scenario.log("FILTER BRANCH TOGGLE BUTTON");
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
                }
                    if (HelpersMethod.IsExists("//div[@id='filter-by-branch']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container' and @aria-checked='true']", driver))
                    {
                        exists = true;
                    }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnWarehouseDropdown()
    {
        exists=false;
        try
        {
            if(wareHouseDropDown.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,wareHouseDropDown);
                HelpersMethod.ClickBut(driver,wareHouseDropDown,1000);
                scenario.log("WAREHOUSE DROPDOWN BUTTON CLICKED");
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnRouteDropdown()
    {
        exists=false;
        try
        {
            if(routeManagementDropDown.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,routeManagementDropDown);
                HelpersMethod.ClickBut(driver,routeManagementDropDown,1000);
                scenario.log("ROUTE MANAGEMENT DROPDOWN BUTTON CLICKED");
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnCustomerManagementDropdown()
    {
        exists=false;
        try
        {
            if(customerManagementDropDown.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,customerManagementDropDown);
                HelpersMethod.ClickBut(driver,customerManagementDropDown,1000);
                scenario.log("CUSTOMER MANAGEMENT DROPDOWN BUTTON CLICKED");
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void selectWarehouseFromDropdown()
    {
        try
        {
            List<WebElement> options = HelpersMethod.FindByElements(driver, "xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            Random rand = new Random();
            int list= rand.nextInt(options.size());
            options.get(list).click();
            String warehouseSelect=HelpersMethod.FindByElement(driver,"xpath","//div[@id='filter-by-warehouse']/descendant::span[@id='cutoff-branches']/span").getText();
            scenario.log("WAREHOUSE SELECTED IS: "+warehouseSelect);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
        }
        catch (Exception e){}
    }

    public void selectRouteFromDropdown()
    {
        try
        {
            List<WebElement> options = HelpersMethod.FindByElements(driver, "xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            Random rand = new Random();
            int list= rand.nextInt(options.size());
            options.get(list).click();
            String routeSelect=HelpersMethod.FindByElement(driver,"xpath","//div[@id='filter-by-route']/descendant::span[@id='cutoff-branches']/span").getText();
            scenario.log("ROUTE SELECTED IS: "+routeSelect);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void selectCustomerManagementFromDropdown()
    {
        try
        {
            List<WebElement> options = HelpersMethod.FindByElements(driver, "xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            Random rand = new Random();
            int list= rand.nextInt(options.size());
            options.get(list).click();
            String customerSelect=HelpersMethod.FindByElement(driver,"xpath","//div[@id='filter-by-route']/descendant::span[@id='cutoff-branches']/span").getText();
            scenario.log("ROUTE SELECTED IS: "+customerSelect);if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
        }
        catch (Exception e){}
    }

    public void clickOnWarehouseFilterTogglebutton()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[@id='filter-by-warehouse']/descendant::span[@id='filter-by-active-cutoff-times' and @aria-checked='true']",driver))
            {
                if (wareHouseFilterCutoffTime.isDisplayed())
                {
                    HelpersMethod.JScriptClick(driver, wareHouseFilterCutoffTime, 1000);
                    scenario.log("FILTER CUT OFF TIME TOGGLE BUTTON HAS BEEN CLICKED");
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
                    if (HelpersMethod.IsExists("//div[@id='filter-by-warehouse']/descendant::span[@id='filter-by-active-cutoff-times' and @aria-checked='true']", driver))
                    {
                        exists = true;
                    }
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnRouteFilterTogglebutton()
    {
        exists=false;
        try
        {
            if(routeManagementFilterCutoffTime.isDisplayed())
            {
                HelpersMethod.JScriptClick(driver,routeManagementFilterCutoffTime,1000);
                scenario.log("FILTER CUT OFF TIME TOGGLE BUTTON HAS BEEN CLICKED");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                if(HelpersMethod.IsExists("//div[@id='filter-by-route']/descendant::span[@id='filter-by-active-cutoff-times' and @aria-checked='true']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnCustomerManagementFilterTogglebutton()
    {
        exists=false;
        try
        {
            if(customerManagementFilterCutoffTime.isDisplayed())
            {
                HelpersMethod.JScriptClick(driver,customerManagementFilterCutoffTime,1000);
                scenario.log("FILTER CUT OFF TIME TOGGLE BUTTON HAS BEEN CLICKED");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                if(HelpersMethod.IsExists("//div[@id='filter-by-customer']/descendant::span[@id='filter-by-active-cutoff-times' and @aria-checked='true']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnCutOffTimesTogglebutton()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(timeSettingToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//span[@class='k-widget k-switch k-switch-off k-state-disabled']",driver))
                {
                    HelpersMethod.ScrollElement(driver, timeSettingToggle);
                    if (!HelpersMethod.IsExists("//div[@id='cutoff-times']/descendant::span[@class='k-switch-container' and @aria-checked='true']", driver))
                    {
                        HelpersMethod.JScriptClick(driver, timeSettingToggle, 10000);
                        wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(120))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    }
                    if (HelpersMethod.IsExists("//div[@id='cutoff-times']/descendant::span[@class='k-switch-container' and @aria-checked='true']", driver))
                    {
                        exists = true;
                    }
                }
                else
                {
                    scenario.log("<span style='color:red'>FEATURE NOT SUPPORTED IN THE ENVIRONMENT, WHERE TEST SCENARIOS ARE GETTING EXECUTED </span>");
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
            if(HelpersMethod.IsExists("//div[@id='cutoff-times']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='cutoff-times']");
                HelpersMethod.ScrollElement(driver, WebEle);
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[" + i + "]/descendant::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-select']");
                HelpersMethod.JScriptClick(driver, WebEle, 10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectHoursForAllDays()
    {

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
                        exists=true;
                        break;
                    }
                }
            }
            Assert.assertEquals(exists,true);
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
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
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
            HelpersMethod.ActClick(driver,WebEle,10000);
            new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(500);
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
                if(!HelpersMethod.IsExists("//span[@id='CPEnableCutoffBranchMgmt' and @aria-checked='false']",driver))
                {
                    HelpersMethod.JScriptClick(driver, branchToggle, 10000);
                    scenario.log("BRANCH TOGGLE BUTTON SELECTED");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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

    public void disableWarehouseToggleButton()
    {
        exists=false;
        try
        {
            if(wareHouseToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//span[@id='CPEnableCutoffWarehouseMgmt' and @aria-checked='false']",driver))
                {
                    HelpersMethod.JScriptClick(driver, wareHouseToggle, 10000);
                    scenario.log("WAREHOUSE TOGGLE BUTTON SELECTED");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                    if (HelpersMethod.IsExists("//span[@id='CPEnableCutoffWarehouseMgmt' and @aria-checked='false']", driver))
                    {
                        exists = true;
                    }
            }
            Assert.assertTrue(exists);
            Thread.sleep(2000);
        }
        catch (Exception e){}
    }

    public void disableRouteToggleButton()
    {
        exists=false;
        try
        {
            if(routeToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//span[@id='CPEnableCutoffRouteMgmt' and @aria-checked='false']",driver))
                {
                    HelpersMethod.JScriptClick(driver, routeToggle, 10000);
                    scenario.log("ROUTE TOGGLE BUTTON SELECTED");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//span[@id='CPEnableCutoffRouteMgmt' and @aria-checked='false']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
            Thread.sleep(2000);
        }
        catch (Exception e){}
    }

    public void disableCustomerManagementToggleButton()
    {
        exists=false;
        try
        {
            if(customerToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//span[@id='CPEnableCutoffCustomerMgmt' and @aria-checked='false']",driver))
                {
                    HelpersMethod.JScriptClick(driver, customerToggle, 10000);
                    scenario.log("CUSTOMER MANAGEMENT TOGGLE BUTTON SELECTED");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//span[@id='CPEnableCutoffCustomerMgmt' and @aria-checked='false']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
            Thread.sleep(2000);
        }
        catch (Exception e){}
    }

    public void clickOnWareHouseManagementToggleButton()
    {
        exists=false;
        try
        {
            if(wareHouseToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//span[@id='CPEnableCutoffWarehouseMgmt' and @aria-checked='true']",driver))
                {
                    HelpersMethod.JScriptClick(driver, wareHouseToggle, 10000);
                    scenario.log("WAREHOUSE TOGGLE BUTTON SELECTED");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                    if (HelpersMethod.IsExists("//span[@id='CPEnableCutoffWarehouseMgmt' and @aria-checked='true']", driver))
                    {
                        exists = true;
                    }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnRouteManagementToggleButton()
    {
        exists=false;
        try
        {
            if(routeToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//span[@id='CPEnableCutoffRouteMgmt' and @aria-checked='true']",driver))
                {
                    HelpersMethod.JScriptClick(driver, routeToggle, 10000);
                    scenario.log("ROUTE TOGGLE BUTTON SELECTED");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                    if (HelpersMethod.IsExists("//span[@id='CPEnableCutoffRouteMgmt' and @aria-checked='true']", driver))
                    {
                        exists = true;
                    }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnCustomerManagementToggleButton()
    {
        exists=false;
        try
        {
            if(customerToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//span[@id='CPEnableCutoffCustomerMgmt' and @aria-checked='true']",driver))
                {
                    HelpersMethod.JScriptClick(driver,customerToggle, 10000);
                    scenario.log("CUSTOMER MANAGEMENT TOGGLE BUTTON SELECTED");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                    if (HelpersMethod.IsExists("//span[@id='CPEnableCutoffCustomerMgmt' and @aria-checked='true']", driver))
                    {
                        exists = true;
                    }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnFilterRouteToggleButton()
    {
        exists=false;
        try
        {
            if(filterRouteToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//div[@id='filter-by-route']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container' and @aria-checked='true']",driver))
                {
                    HelpersMethod.ScrollElement(driver, filterRouteToggle);
                    HelpersMethod.JScriptClick(driver, filterRouteToggle, 1000);
                    scenario.log("FILTER ROUTE TOGGLE BUTTON");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//div[@id='filter-by-route']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container' and @aria-checked='true']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnFilterCustomerManagementToggleButton()
    {
        exists=false;
        try
        {
            if(filterCustomerMangementToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//div[@id='filter-by-customer']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container' and @aria-checked='true']",driver))
                {
                    HelpersMethod.ScrollElement(driver, filterCustomerMangementToggle);
                    HelpersMethod.JScriptClick(driver, filterCustomerMangementToggle, 1000);
                    scenario.log("FILTER CUSTOMER MANAGEMENT TOGGLE BUTTON");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//div[@id='filter-by-customer']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container' and @aria-checked='true']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnFilterWarehouseToggleButton()
    {
        exists=false;
        try
        {
            if(filterWarehouseToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//div[@id='filter-by-warehouse']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container' and @aria-checked='true']",driver))
                {
                    HelpersMethod.ScrollElement(driver, filterWarehouseToggle);
                    HelpersMethod.JScriptClick(driver, filterWarehouseToggle, 1000);
                    scenario.log("FILTER WAREHOUSE TOGGLE BUTTON");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                    if (HelpersMethod.IsExists("//div[@id='filter-by-warehouse']/descendant::div[@class='card-setting-area']/descendant::span[@class='k-switch-container' and @aria-checked='true']", driver))
                    {
                        exists = true;
                    }
            }
            Assert.assertTrue(exists);
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
                HelpersMethod.ClickBut(driver,branchDropdown,10000);
                scenario.log("BRANCHES DROPDOWN BUTTON CLICKED");
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
            if(options.size()==1)
            {
                HelpersMethod.ActClick(driver,options.get(0),10000);
            }
            else
            {
                Random rand = new Random();
                int list = rand.nextInt(options.size());
                options.get(list).click();
                String branchSelect = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='filter-by-branch']/descendant::span[@id='cutoff-branches']/span").getText();
                scenario.log("BRANCH SELECTED IS: " + branchSelect);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
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
                if(!HelpersMethod.IsExists("//div[@id='filter-by-branch']/descendant::span[@id='filter-by-active-cutoff-times' and @aria-checked='true']",driver))
                {
                    HelpersMethod.JScriptClick(driver, branchFilterCutoffTime, 1000);
                    scenario.log("FILTER CUT OFF TIME TOGGLE BUTTON HAS BEEN CLICKED");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                    if (HelpersMethod.IsExists("//div[@id='filter-by-branch']/descendant::span[@id='filter-by-active-cutoff-times' and @aria-checked='true']", driver))
                    {
                        exists = true;
                    }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }
}
