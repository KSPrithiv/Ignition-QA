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

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Project DSD_OMS
 * @Author divya.ramadas@telusagcg.com
 */
public class IgnitionPage
{
    /* Created by divya.ramadas@telusagcg.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;
    static String PoNo=null;

    @FindBy(id="btnAddStandingPO")
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
    public IgnitionPage(WebDriver driver, Scenario scenario)
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
        new WebDriverWait(driver, Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-child-animation-container')]"))));
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver,NewButton);
            HelpersMethod.ActClick(driver,NewButton,10000);
            exists=true;
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
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
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Add standing po", "Verify Title message");
            }
        }
        catch (Exception e){}
    }

    //Code to select start date and end date for standing order
    public void ClickOnStartDateCalender()
    {
        exists=false;
        WebElement WebEle=null;
        //new WebDriverWait(driver,60000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
        //new WebDriverWait(driver,60000).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
        try
        {
            if(HelpersMethod.IsExists("//label[contains(@id,'fromDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]",driver))
            {
                //identify the popup
                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                //Click on start date icon
                WebEle = modalContainer.findElement(By.xpath(".//label[contains(@id,'fromDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
                HelpersMethod.ActClick(driver, WebEle, 80000);
                exists=true;
                //new WebDriverWait(driver, 200000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]"))));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnEndDateCalender()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//label[contains(@id,'toDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')",driver))
            {
                //identify the popup
                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                //Click on end date icon
                WebEle = modalContainer.findElement(By.xpath(".//label[contains(@id,'toDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
                HelpersMethod.ActClick(driver, WebEle, 20000);
                exists=true;
                new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]"))));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Selecting Start date
    public void SelectStartDate(int i) {
       /* HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",100000);
        new WebDriverWait(driver,80000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        WebElement WebEle=null;
        String FTDate=null;
        exists=false;
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",100000);
            new WebDriverWait(driver,100000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            if(HelpersMethod.IsExists("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver)) {
                //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
                if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]", driver)) {
                    LocalDate myDateObj = LocalDate.now().plusDays(i);
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                    formattedDate1 = myDateObj.format(myFormatObj);
                    WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                    if (ele1.isDisplayed() && ele1.isEnabled()) {
                        HelpersMethod.JSScroll(driver, ele1);
                        HelpersMethod.ActClick(driver, ele1, 200000);
                        exists=true;
                        scenario.log(formattedDate1 + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                        WebEle = HelpersMethod.FindByElement(driver, "id", "addFromDate");
                        FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 60);
                        if (!FTDate.equals(null) && !FTDate.equals("MM/DD/YYYY")) {
                            exists = true;
                        }
                    } else {
                        scenario.log("NOT ABLE TO SELECT START DATE");
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }*/
        try {
            WebElement fromDateContainer;
            WebElement WebEle;
            String FTDate = null;
            String status = null;
            String formattedDate1 = null;
            // new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
            new WebDriverWait(driver, Duration.ofMillis(50000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-container')]"))));
            //Select 'From' date from Start date calender
            //if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", driver)) {
                // to fetch the web element of the modal container
               /* fromDateContainer = HelpersMethod.FindByElement(driver, "xpath", "//table[@class='k-calendar-table']");
                WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@class,'k-state-focused')]"));
                if (ele1.isDisplayed() && ele1.isEnabled()) {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 100);
                    exists = true;
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading")) {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "id", "addFromDate");
                    FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 80);
                    scenario.log(FTDate + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                } else {
                    scenario.log("FAILED TO SELECT START DATE");
                }*/
                if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]", driver)) {
                    LocalDate myDateObj = LocalDate.now().plusDays(i);
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                    formattedDate1 = myDateObj.format(myFormatObj);
                    WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                    if (ele1.isDisplayed() && ele1.isEnabled()) {
                        HelpersMethod.JSScroll(driver, ele1);
                        HelpersMethod.ActClick(driver, ele1, 200000);
                        exists = true;
                        scenario.log(formattedDate1 + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                        WebEle = HelpersMethod.FindByElement(driver, "id", "addFromDate");
                        FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 60);
                        if (!FTDate.equals(null) && !FTDate.equals("MM/DD/YYYY")) {
                            exists = true;
                        }
                    } else {
                        scenario.log("NOT ABLE TO SELECT START DATE");
                    }
                }
           // }
        } catch (Exception e) {
        }
    }

        //selecting end date
    public void SelectEndDate(int i)
    {
        //HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",80000);
        //new WebDriverWait(driver,80000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
      /*  WebElement WebEle=null;
        String FTDate=null;
        exists=false;
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",10000);
            new WebDriverWait(driver,10000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            if(HelpersMethod.IsExists("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver)) {
                //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
                if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]", driver)) {
                    LocalDate myDateObj = LocalDate.now().plusDays(i);
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                    formattedDate1 = myDateObj.format(myFormatObj);
                    WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                    if (ele1.isDisplayed() && ele1.isEnabled()) {
                        HelpersMethod.JSScroll(driver, ele1);
                        HelpersMethod.ActClick(driver, ele1, 2000);
                        scenario.log(formattedDate1 + " HAS BEEN SELECTED AS END DATE FOR STANDING ORDER");
                        WebEle = HelpersMethod.FindByElement(driver, "id", "addToDate");
                        FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 60);
                        if (!FTDate.equals(null) && !FTDate.equals("MM/DD/YYYY")) {
                            exists = true;
                        }
                    } else {
                        scenario.log("END DATE IS NOT VISIBLE");
                    }
                }
            }
        }*/
        try
        {
            WebElement fromDateContainer;
            WebElement WebEle;
            String FTDate = null;
            String status = null;
            //new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-container')]"))));


            //Select 'To' date from End date calender
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", driver)) {
                // to fetch the web element of the modal container
                fromDateContainer = HelpersMethod.FindByElement(driver, "xpath", "//table[@class='k-calendar-table']");
                WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@class,'k-state-focused')]"));
                if (ele1.isDisplayed() && ele1.isEnabled()) {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 40);
                    exists = true;
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading")) {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "id", "addFromDate");
                    FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 80);
                    scenario.log(FTDate + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                } else {
                    scenario.log("FAILED TO SELECT START DATE");
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
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
                HelpersMethod.ClickBut(driver, WebEle, 100);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
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
            new WebDriverWait(driver,Duration.ofMillis(100)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
            new WebDriverWait(driver,Duration.ofMillis(100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
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
            new WebDriverWait(driver,Duration.ofMillis(100)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
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
                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                    WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                    Assert.assertEquals(modalContentTitle.getText(), "Edit standing po", "Verify Title message");
                }
            }
        }
        catch (Exception e){}
    }

    public void ClickUpdate()
    {
        WebElement WebEle;
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Edit standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"));
            WebEle=modalContainer.findElement(By.xpath(".//button[text()='Update']"));
            HelpersMethod.ActClick(driver,WebEle,2000);
            if(HelpersMethod.IsExists("//div[contains(text(),'A Standing PO# already exists within the given date range')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement popUp = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                WebEle=popUp.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver,WebEle,40);
            }
        }
        catch (Exception e){}
    }

    public void cancelPopup()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                WebElement WebEle=modalContainer.findElement(By.xpath(".//button[text()='Cancel']"));
                HelpersMethod.ClickBut(driver,WebEle,80);
            }
        }
        catch (Exception e){}
    }

    public void validateAddStandingOrder()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Please save the new customer data')]",driver))
            {
                exists=false;
            }
            else
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateEditStndingPO()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Edit standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Edit standing po", "Verify Title message");
            }
        }
        catch (Exception e){}
    }

    public void ClickOnEndDateCalenderInEditPopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            //identify the popup
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
            //Click on end date icon
            WebEle= modalContainer.findElement(By.xpath(".//label[contains(@id,'toDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
            HelpersMethod.ActClick(driver,WebEle,2000);
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]"))));
        }
        catch (Exception e){}
    }

    public void SelectEndDateInEditPopup(int i)
    {
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",80000);
        new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        WebElement WebEle=null;
        String FTDate=null;
        exists=false;
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",10000);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
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
                    HelpersMethod.ActClick(driver, ele1, 40000);
                    scenario.log(formattedDate1 + " HAS BEEN SELECTED AS END DATE FOR STANDING ORDER");
                    WebEle=HelpersMethod.FindByElement(driver,"id","addToDate");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,60);
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

    public void clearSearchbar()
    {
        exists=true;
        try
        {
            if(HelpersMethod.IsExists("//*[local-name()='svg' and contains(@class,'i-search-box__clear')]",driver))
            {
                WebElement clearSearch=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg' and contains(@class,'i-search-box__clear')]");
                HelpersMethod.ActClick(driver,clearSearch,100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
