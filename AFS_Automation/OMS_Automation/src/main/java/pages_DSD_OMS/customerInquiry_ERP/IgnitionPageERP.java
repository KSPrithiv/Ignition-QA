package pages_DSD_OMS.customerInquiry_ERP;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
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
    public class IgnitionPageERP
    {
        /* Created by divya.ramadas@telusagcg.com */
        WebDriver driver;
        Scenario scenario;
        static boolean exists=false;
        static String InputValue;
        static String PoNo;

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
        public IgnitionPageERP(WebDriver driver, Scenario scenario)
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
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
            try
            {
                HelpersMethod.ActClick(driver,WebEle,10000);
                List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
                // Getting size of options available
                int size = Options.size();

                // Generate a random number with in range
                int randnMumber = ThreadLocalRandom.current().nextInt(1, size);

                // Selecting random value
                HelpersMethod.ActClick(driver, Options.get(randnMumber), 10000);
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
                HelpersMethod.EnterText(driver,WebEle,10000, RandomValues.generateRandomString(length));
                InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10000);

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
                HelpersMethod.EnterText(driver,WebEle,10000,RandomValues.generateRandomNumber(length));
                InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10000);

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
                HelpersMethod.ActClick(driver,NewButton,10000);
                exists=true;
                new WebDriverWait(driver,Duration.ofMillis(60000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Add Standing PO')]/ancestor::div[contains(@class,'k-window k-dialog')]"))));
                Assert.assertEquals(exists,true);
            }
            catch (Exception e){}
        }

    public void ValidateAddStandingPO()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Add Standing PO')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Add Standing PO", "Verify Title message");
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
            //new WebDriverWait(driver,60000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add Standing PO')]/ancestor::div[contains(@class,'k-window k-dialog')]"))));
            try
            {
                //identify the popup
                WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                //Click on start date icon
                WebEle= modalContainer.findElement(By.xpath(".//label[contains(@id,'fromDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
                HelpersMethod.ActClick(driver,WebEle,20000);
                new WebDriverWait(driver,Duration.ofMillis(60000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]"))));
            }
            catch (Exception e){}
        }

        public void ClickOnEndDateCalender()
        {
            exists=false;
            WebElement WebEle=null;
            try
            {
                //identify the popup
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                //Click on end date icon
                WebEle= modalContainer.findElement(By.xpath(".//label[contains(@id,'toDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
                HelpersMethod.ActClick(driver,WebEle,10000);
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]"))));
            }
            catch (Exception e){}
        }

        //Selecting Start date
        public void SelectStartDate(int i)
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",100000);
            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            WebElement WebEle=null;
            String FTDate=null;
            exists=false;
            try
            {
                String formattedDate1 = null;
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",20000);
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
                        scenario.log(formattedDate1 + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                        WebEle=HelpersMethod.FindByElement(driver,"id","addFromDate");
                        FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,10000);
                        if(!FTDate.equals(null) && !FTDate.equals("MM/DD/YYYY"))
                        {
                            exists=true;
                        }
                    }
                    else
                    {
                        scenario.log("NOT ABLE TO SELECT START DATE");
                    }
                }
            }
            catch (Exception e) {}
        }

        //selecting end date
        public void SelectEndDate(int i)
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",10000);
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            WebElement WebEle=null;
            String FTDate=null;
            exists=false;
            try
            {
                String formattedDate1 = null;
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",60);
                new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
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
                        HelpersMethod.ActClick(driver, ele1, 10000);
                        scenario.log(formattedDate1 + " HAS BEEN SELECTED AS END DATE FOR STANDING ORDER");
                        WebEle=HelpersMethod.FindByElement(driver,"id","addToDate");
                        FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,10000);
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
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::input[contains(@placeholder,'Enter PO#...')]");
                InputValue=RandomValues.generateRandomAlphaNumeric(4);
                HelpersMethod.EnterText(driver,WebEle,10000,InputValue);
                PoNo=InputValue;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
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
                WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Add']");
                if(WebEle.isEnabled())
                {
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
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
            Actions act=new Actions(driver);
            String hr_text;
            int hr_No;
            try
            {
                new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
                new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
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
                HelpersMethod.ActClick(driver,WebEle,60);
                new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::div[contains(@class,'k-timeselector k-reset')]")));
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
                HelpersMethod.EnterText(driver,SearchBar,10000,PoNo);
                HelpersMethod.ClickBut(driver,SearchIndex,10000);
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
                HelpersMethod.ActClick(driver,WebEle,10000);
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
                    HelpersMethod.ClickBut(driver, EditButton, 10000);
                    if (HelpersMethod.IsExists("//div[contains(text(),'Edit standing po')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
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
                if(HelpersMethod.IsExists("//div[contains(text(),'Edit standing po')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement editStandingPO=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Edit standing po')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebEle= editStandingPO.findElement(By.xpath(".//input[contains(@id,'textBox0')]"));
                    scenario.log("PO NUMBER ENTERE BEFORE "+HelpersMethod.JSGetValueEle(driver,WebEle,10000));
                    HelpersMethod.JSSetValueEle(driver,WebEle,10000, RandomValues.generateRandomAlphaNumeric(8));
                    scenario.log("PO NUMBER EDITED AS "+HelpersMethod.JSGetValueEle(driver,WebEle,10000));
                    WebEle=editStandingPO.findElement(By.xpath(".//button[text()='Update']"));
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                    exists=true;
                }
                Assert.assertEquals(exists,true);
            }
            catch (Exception e){}
        }

        public void clearSearchBarValue()
        {
            exists=false;
            try
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg' and contains(@class,'i-search-box__clear')]");
                HelpersMethod.ClickBut(driver,WebEle,10000);
                exists=true;
                Assert.assertEquals(exists,true);
            }
            catch (Exception e){}
        }

        public void selectPONoForDelete(int i)
        {
            Actions act1=new Actions(driver);
            try
            {
                WebElement sPO=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+(i+1)+"]");
                act1.moveToElement(sPO).build().perform();
                act1.click(sPO).build().perform();
                scenario.log("STANDING PO SELECTED FOR DELETE");
            }
            catch (Exception e){}
        }

        public void clickDelete()
        {
            WebElement deleteButton=HelpersMethod.FindByElement(driver,"id","btnDeleteStandingPO");
            try
            {
                if(deleteButton.isDisplayed() && deleteButton.isEnabled())
                {
                    HelpersMethod.ClickBut(driver,deleteButton,10000);
                    scenario.log("CLICK ON DELETE BUTTON");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            catch (Exception e){}
        }

        public void confirmationPopUp()
        {
            try
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Delete standing po')]/ancestor::div[contains(@class,'k-window k-dialog')]"));
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Delete standing po", "Verify Title message");
                //Delete confirmation popup
                WebElement deletePopup=modalContainer.findElement(By.xpath(".//button/span[text()='Delete']"));
                HelpersMethod.ActClick(driver,deletePopup,10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //Delete success popup
                if(HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton=popUp.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver,okButton,10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            catch (Exception e){}
        }

        public void cancelPopup()
        {
            try
            {
                if(HelpersMethod.IsExists("//div[contains(text(),'standing po')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                    WebElement WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='Cancel']"));
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                }
            }
            catch (Exception e){}
        }
    }

