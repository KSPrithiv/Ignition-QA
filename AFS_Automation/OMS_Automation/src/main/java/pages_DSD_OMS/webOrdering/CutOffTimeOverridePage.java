package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
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

import javax.swing.text.html.parser.Parser;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CutOffTimeOverridePage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static LocalDate dateTime1;

    @FindBy(xpath="//div[@id='filter-by-company']/descendant::span[contains(@class,'k-switch-container')]")
    private WebElement companyToggle;

    @FindBy(xpath = "//div[@id='filter-by-customer']/descendant::span[contains(@class,'k-switch-container')]")
    private WebElement customerToggle;

    @FindBy(xpath="//button[@id='add-delivery-date']//*[local-name()='svg']")
    private WebElement addDeliveryDate;

    @FindBy(xpath="//button[@id='delete-delivery-date']//*[local-name()='svg']")
    private WebElement deleteDeliveryDate;

    public CutOffTimeOverridePage(WebDriver driver, Scenario scenario)
    {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCompanyOverrideToggleButton()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(companyToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//div[@id='filter-by-company']/descendant::span[contains(@class,'k-switch-container') and @aria-checked='true']",driver))
                {
                    HelpersMethod.JScriptClick(driver, companyToggle, 10000);
                    scenario.log("COMPANY TOGGLE BUTTON SELECTED UNDER CUTOFF TIME OVERRIDE");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if (HelpersMethod.IsExists("//div[@id='filter-by-company']/descendant::span[contains(@class,'k-switch-container') and @aria-checked='true']", driver))
                {
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnAddDeliveryDate()
    {
        exists=false;
        try
        {
            if(addDeliveryDate.isDisplayed() && addDeliveryDate.isEnabled())
            {
                HelpersMethod.ClickBut(driver,addDeliveryDate,10000);
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAddDeliveryDatePopup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[@id='delivery-date-notification']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickOnCalenderIcon()
    {
        exists=false;
        try
        {
            WebElement calenderButton=HelpersMethod.FindByElement(driver,"xpath","//div[@id='delivery-date-notification']/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::span[contains(@class,'k-icon k-i-calendar')]");
            HelpersMethod.ClickBut(driver,calenderButton,10000);
            Thread.sleep(2000);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-calendar-view k-vstack k-calendar-monthview')]",driver))
            {
                WebElement currentDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-calendar-view k-vstack k-calendar-monthview')]/descendant::td[contains(@class,'k-calendar-td k-state-pending-focus')]");
                String currentDateString=HelpersMethod.AttributeValue(currentDate,"title");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
                LocalDate dateTime = LocalDate.parse(currentDateString, formatter);
                dateTime1=dateTime.plusDays(3);
                DateTimeFormatter currentFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                String dateText = dateTime1.format(currentFormatObj);
                //Click on date
                WebElement changeDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-calendar-view k-vstack k-calendar-monthview')]/descendant::td[contains(@class,'k-calendar-td') and @title='"+dateText+"']");
                HelpersMethod.ScrollElement(driver,changeDate);
                HelpersMethod.ActClick(driver,changeDate,10000);

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }

                //To check whether date has been selected or not
                WebElement dateSelected=HelpersMethod.FindByElement(driver,"id","cutoff-time-override-date");
                String selectedDate=HelpersMethod.AttributeValue(dateSelected,"value");
                if(!selectedDate.equalsIgnoreCase("MM/DD/YYYY"))
                {
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnClockIcon()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }

            if(HelpersMethod.IsExists("//span[@class='k-icon k-i-clock']",driver))
            {
                WebElement clockIcon = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='k-icon k-i-clock']");
                HelpersMethod.JScriptClick(driver, clockIcon, 10000);
                exists=true;
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

    public void SelectHours()
    {
        exists=false;
        int hrSec;
        Actions act=new Actions(driver);
        String hr_text;
        int hr_No;
        try
        {
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
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

    public void SelectMin()
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

    public  void ClickOnTimeSetButton()
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

    public void clickOnSaveNewBlackout()
    {
        exists=false;
        try
        {
            //to click on save button in new blackout date
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement modelContrainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebElement saveButton = modelContrainer.findElement(By.xpath(".//button/span[text()='Save']"));
                HelpersMethod.ActClick(driver, saveButton, 1000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                //handle confirmation popup
                if (HelpersMethod.IsExists("//div[@id='dialogTextContent']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
                    WebElement modelContrainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton = modelContrainer1.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver, okButton, 1000);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCutOffToDelete()
    {
        exists=false;
        Actions act=new Actions(driver);
        String deliveryText=null;
        int i=0;
        try
        {
            DateTimeFormatter currentFormatObj = DateTimeFormatter.ofPattern("EEE, MMMM dd, yyyy");
            String dateText = dateTime1.format(currentFormatObj);
            List<WebElement> deliveryDates=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/td[1]");
            for(WebElement deliveryDate:deliveryDates)
            {
                i++;
                act.moveToElement(deliveryDate).build().perform();
                deliveryText=deliveryDate.getText();
                if(deliveryText.equalsIgnoreCase(dateText))
                {
                    WebElement deliveryRow=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+i+"]");
                    act.moveToElement(deliveryRow).click().build().perform();
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickDeleteButton()
    {
        exists=false;
        try
        {
            if(deleteDeliveryDate.isDisplayed() && deleteDeliveryDate.isEnabled())
            {
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                HelpersMethod.ClickBut(driver,deleteDeliveryDate,1000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void confirmationPopupHandle()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window-content k-dialog-content')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
               WebElement confirmationPopup= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
               WebElement okButton=confirmationPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
               HelpersMethod.ActClick(driver,okButton,1000);
               exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void disableCompanyOverrideToggleButton()
    {
        exists=false;
        try
        {
            if(companyToggle.isDisplayed())
            {
                if(HelpersMethod.IsExists("//div[@id='filter-by-company']/descendant::span[contains(@class,'k-switch-container') and @aria-checked='true']",driver))
                {
                    HelpersMethod.JScriptClick(driver, companyToggle, 1000);
                    scenario.log("COMPANY TOGGLE BUTTON SELECTED UNDER CUTOFF TIME OVERRIDE");
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
                }
                if (!HelpersMethod.IsExists("//div[@id='filter-by-company']/descendant::span[contains(@class,'k-switch-container') and @aria-checked='true']", driver))
                {
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnCustomerOverrideToggleButton()
    {
        exists=false;
        try
        {
            if(customerToggle.isDisplayed())
            {
                if(!HelpersMethod.IsExists("//div[@id='filter-by-customer']/descendant::span[contains(@class,'k-switch-container') and @aria-checked='true']",driver))
                {
                    HelpersMethod.JScriptClick(driver, customerToggle, 1000);
                    scenario.log("COMPANY TOGGLE BUTTON SELECTED UNDER CUTOFF TIME OVERRIDE");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if (HelpersMethod.IsExists("//div[@id='filter-by-customer']/descendant::span[contains(@class,'k-switch-container') and @aria-checked='true']", driver))
                {
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void saveConfirmationPopup()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }

            if(HelpersMethod.IsExists("//div[@id='dialogTextContent']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }

                WebElement confirmationPopup= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=confirmationPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver,okButton,10000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
