package pages_DSD_OMS.customerInquiry_DSD;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class IgnationPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;
    static String PoNo=null;

    @FindBy(xpath="//button[@id='btnAddStandingPO']//*[local-name()='svg']")
    private WebElement NewButton;

    @FindBy(id="btnEditStandingPO")
    private WebElement EditButton;

    @FindBy(id="btnDeleteStandingPO")
    private WebElement DeleteButton;

    @FindBy(id="SearchBox1")
    private WebElement SearchBar;

    @FindBy(xpath="//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]")
    private WebElement SearchIndex;

    @FindBy(id="CmCCProc")
    private WebElement CreditCard;

    //Actions
    public IgnationPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void ValidateIgnition()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//p[contains(text(),'Standing PO#')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String ClickOnDropDownSelectRandom(WebElement WebEle,String xpathValue)
    {
        exists=false;
        String TextDropDown=null;
        try
        {
            HelpersMethod.ActClick(driver,WebEle,10);
            List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
            // Getting size of options available
            int size = Options.size();

            // Generate a random number with in range
            int randnMumber = ThreadLocalRandom.current().nextInt(1, size);

            // Selecting random value
            HelpersMethod.ActClick(driver, Options.get(randnMumber), 20);
            InputValue=HelpersMethod.FindByElement(driver,"xpath","//span[@id='"+xpathValue+"']/span[@class='k-input']").getText();
        }
        catch (Exception e){}
        return InputValue;
    }

    //Generic method to Enter text
    public String EnterText(WebElement WebEle,int length)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,WebEle,10, RandomValues.generateRandomString(length));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10);

            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
        return InputValue;
    }

    public String EnterNumber(WebElement WebEle, int length)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,WebEle,10,RandomValues.generateRandomNumber(length));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10);

            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
        return InputValue;
    }

    public void ClickOnNewButton()
    {
        HelpersMethod.Implicitwait(driver,80);
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,NewButton,60);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateAddStandingPO()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to select start date and end date for standing order
    public void ClickOnStartDateCalender()
    {
        exists=false;
        WebElement WebEle=null;
        WebDriverWait wait=new WebDriverWait(driver,80);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",80);
        HelpersMethod.Implicitwait(driver,60);
        try
        {
            //Click on start date icon
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//label[contains(@id,'fromDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]");
            HelpersMethod.ActClick(driver,WebEle,20);
            exists=true;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
            new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists,true);
            HelpersMethod.Implicitwait(driver,60);
        }
        catch (Exception e){}
    }

    public void ClickOnEndDateCalender()
    {
        exists=false;
        WebElement WebEle=null;
        WebDriverWait wait=new WebDriverWait(driver,40);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",60);
        HelpersMethod.Implicitwait(driver,60);
        try
        {
            //Click on end date icon
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//label[contains(@id,'toDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]");
            HelpersMethod.ActClick(driver,WebEle,20);
            exists=true;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",60);
            new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists,true);
            HelpersMethod.Implicitwait(driver,60);
        }
        catch (Exception e){}
    }

    //Selecting Start date
    public void SelectStartDate(int i)
    {
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
        new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        try
        {
            String formattedDate1 = null;
            WebElement WebEle=null;
            String FTDate=null;
            exists=false;
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                LocalDate myDateObj = LocalDate.now().plusDays(i);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                if(ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 60);
                    scenario.log(formattedDate1 + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                    WebEle=HelpersMethod.FindByElement(driver,"id","addFromDate");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,10);
                        exists=true;
                }
                else
                {
                    scenario.log("NOT ABLE TO SELECT THE DATE");
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //selecting end date
    public void SelectEndDate(int i)
    {
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",60);
        new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        WebElement WebEle=null;
        String FTDate=null;
        exists=false;
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",60);
            new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            String ele = "//div[contains(@class,'k-calendar-monthview')]";
            boolean visible = HelpersMethod.IsExists(ele, driver);
            if (visible == true)
            {
                LocalDate myDateObj = LocalDate.now().plusDays(i);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                if(ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 40);
                    scenario.log(formattedDate1 + " HAS BEEN SELECTED AS END DATE FOR STANDING ORDER");
                    WebEle=HelpersMethod.FindByElement(driver,"id","addToDate");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,10);
                    if(!FTDate.equals(null) && !FTDate.equals("MM/DD/YYYY"))
                    {
                        exists=true;
                    }
                }
                else
                {
                    scenario.log("END DATE IS NOT VISIBLE");
                }
            }
        }
        catch (Exception e) {}
    }

    public void POInputBox()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[contains(@placeholder,'Enter PO#...')]");
            InputValue=RandomValues.generateRandomAlphaNumeric(4);
            HelpersMethod.EnterText(driver,WebEle,10,InputValue);
            PoNo=InputValue;
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnAdd()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Add']");
            if(WebEle.isEnabled())
            {
                HelpersMethod.ClickBut(driver, WebEle, 10);
                exists=true;
            }
            HelpersMethod.Implicitwait(driver,60);
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
        Actions act=new Actions(driver);
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//p[contains(text(),'Call list schedule')]");
            HelpersMethod.ScrollElement(driver,WebEle);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[@id='CmDelDay"+i+"Time']/ancestor::span[contains(@class,'k-picker-wrap')]/descendant::span[@class='k-select']/span");
            HelpersMethod.JScriptClick(driver,WebEle,10);
        }
        catch (Exception e){}
    }

    public void SelectHoursForAllDays()
    {
        exists=false;
        int hrSec;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String hr_text;
        int hr_No;
        try
        {
                new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
                new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
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
        WebElement WebEle;
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
            HelpersMethod.ActClick(driver,WebEle,60);
            new WebDriverWait(driver,60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
        }
        catch (Exception e){}
    }

    public void PaymentProcessingDropdown()
    {
        try
        {
         ClickOnDropDownSelectRandom(CreditCard,"CmCCProc");
        }
        catch (Exception e){}
    }

    public void ClickOrderTracker(int i)
    {
        String xpathValue="CmDelDay"+i+"CoTaker";
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id",xpathValue);
            ClickOnDropDownSelectRandom(WebEle,xpathValue);
            Thread.sleep(1000);
        }
        catch (Exception e){}
    }

    public void SearchPONo()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,SearchBar,10,PoNo);
            HelpersMethod.ClickBut(driver,SearchIndex,20);
            if(!HelpersMethod.IsExists("//div[@class='i-no-data']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }


    public void SelectPONo()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-grid')]/descendant::tr[contains(@class,'k-master-row')][1]");
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.ActClick(driver,WebEle,20);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickEditButton()
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver,EditButton);
            if(EditButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, EditButton, 40);
                if (HelpersMethod.IsExists("//div[contains(text(),'Edit standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EditPONo()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Edit standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle= HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'textBox0')]");
                scenario.log("PO NUMBER ENTERE BEFORE "+HelpersMethod.JSGetValueEle(driver,WebEle,10));
                HelpersMethod.JSSetValueEle(driver,WebEle,10,RandomValues.generateRandomAlphaNumeric(8));
                scenario.log("PO NUMBER EDITED AS "+HelpersMethod.JSGetValueEle(driver,WebEle,10));
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Update']");
                HelpersMethod.ClickBut(driver,WebEle,10);
                exists=true;
            }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

}