package pages_DSD_OMS.customerInquiry_ERP;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.RandomValues;
import util.TestBase;

import java.time.Duration;
import java.util.List;

public class CustomerInquiryPageERP
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    public static String Bill="";
    public static String Desc="";
    public static String BillVal="";

    @FindBy(id="customerInquiryNewBtn")
    private WebElement new_But;

    @FindBy(xpath="//input[contains(@id,'segmentInput_0')]")
    private WebElement bill_Input;

    @FindBy(xpath="//input[contains(@id,'segmentInput_1')]")
    private WebElement store_Input;

    @FindBy(xpath = "//input[contains(@id,'segmentInput_2')]")
    private WebElement dept_Input;

    @FindBy(xpath="//input[@placeholder='Description']")
    private WebElement description_Input;

    @FindBy(xpath="//button[contains(@class,'i-indexfield-container__main__button')]//*[local-name()='svg']")
    private WebElement customerAccountIndex;

    //Actions
    public CustomerInquiryPageERP(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void HandleError_Page()
    {
        try
        {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError"))
            {
                HelpersMethod.NavigateBack(driver);
                URL = HelpersMethod.gettingURL(driver);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
            {
                HomePage homepage = new HomePage(driver, scenario);
                homepage.navigateToClientSide();
                NavigateToCustomerInquiry();
            }
        } catch (Exception e) {}
    }

    public void removeDialogBoxIfAny()
    {
        if (HelpersMethod.IsExists("//div[contains(@class,'k-dialog-wrapper')]|//div[@class='modal-sm modal-dialog']|//div[contains(@class,'modal-content')]|//div[contains(@class,'k-dialog-wrapper order-selection ')]|//div[@class='k-dialog-wrapper priceOverrideDialog ']|//div[@class='k-dialog-wrapper OrderCommentDialog ']", driver))
        {
            WebElement dialogBox = driver.findElement(By.xpath("//div[contains(@class,'k-dialog-wrapper')]|//div[contains(@class,'modal-dialog')]|//div[contains(@class,'k-dialog-wrapper order-selection ')]|//div[contains(@class,'modal-content')]|//div[@class='k-dialog-wrapper priceOverrideDialog ']|//div[@class='k-dialog-wrapper OrderCommentDialog ']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", dialogBox);

            driver.navigate().refresh();

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }

            Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait1 = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

    }

    public void Refresh_Page()
    {
        driver.navigate().refresh();
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
    }

    public void NavigateToCustomerInquiry()
    {
        exists = false;
        WebElement WebEle;
        String status;
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

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(800))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(800))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            Actions act = new Actions(driver);
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[@class='item-searchbar']//*[local-name()='svg']", driver))
            {
                WebElement humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='item-searchbar']//*[local-name()='svg']");
                HelpersMethod.ActClick(driver, humburger, 10000);
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='drawer-menu-search-container']/descendant::input"))));
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='drawer-menu-search-container']/descendant::input")));
            }
            if(HelpersMethod.IsExists("//div[@class='settings-back-container']",driver))
            {
                WebElement arrow=HelpersMethod.FindByElement(driver,"xpath","//div[@class='settings-back-container']");
                HelpersMethod.ActClick(driver,arrow,10000);
                Thread.sleep(500);
            }
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("Customer Inquiry").build().perform();
            WebElement CustInqMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Customer Inquiry')] | //ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Customer inquiry')]");
            HelpersMethod.ClickBut(driver, CustInqMenu, 10000);
             wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //if(HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]",driver))
            if(HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']");
                act.moveToElement(WebEle).build().perform();
                act.click(WebEle).build().perform();
            }

            if(CustInqMenu.isDisplayed())
            {
                scenario.log("NAVIGATED TO CUSTOMER INQ PAGE");
                exists = true;
            }
            else
            {
                scenario.log("CUSTOMER INQ MAY NOT BE ENABLED FOR THE APPLICATION, CHECK WITH ADMIN SETTINGS");
            }

            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ValidateCustomInq()
    {
        WebElement WebEle;
        String title;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'spnmoduleNameHeader')]")));

            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'spnmoduleNameHeader')]");
            title=WebEle.getText();
            Assert.assertEquals("Customer Inquiry",title);
        }
        catch (Exception e){}
    }

    public void NavigateDifferentTabs(String TabText)
    {
        exists=false;
        Actions act=new Actions(driver);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            WebElement tabs= HelpersMethod.FindByElement(driver,"id","CustomerMasterBottomCard");
            HelpersMethod.ScrollElement(driver,tabs);
            List<WebElement> CustOptions= HelpersMethod.FindByElements(driver,"xpath","//ul[contains(@class,'k-tabstrip-items')]/li/span");
            for(WebElement CustOption:CustOptions)
            {
                act.moveToElement(CustOption).build().perform();
                String Option_Text=CustOption.getText();
                if(Option_Text.equals(TabText))
                {
                    act.moveToElement(CustOption).build().perform();
                    act.click(CustOption).build().perform();
                    String status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void BillNo(String billNo)
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String billNumber;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='customer-account-component']");
            HelpersMethod.ScrollElement(driver,WebEle);
            billNumber=HelpersMethod.FindByElement(driver,"xpath","//input[@placeholder='Bill']").getText();
            if(billNumber.equals("")||billNumber.equals("0000000000"))
            {
                //Bill = RandomValues.generateRandomNumber(10);
                //act.moveToElement(bill_Input).click().build().perform();
                HelpersMethod.JSSetValueEle(driver, bill_Input, 10000, " ");
                HelpersMethod.ActSendKey(driver, bill_Input, 10000, billNo);
                BillVal = HelpersMethod.JSGetValueEle(driver, bill_Input, 10000);
                if (billNo.equals(BillVal))
                {
                    scenario.log("VALUE ENTERED FOR BILLING# " + BillVal);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DescrVal(String desc)
    {
        exists=false;
        String DescVal;
        Actions act=new Actions(driver);
        try
        {
            HelpersMethod.ScrollElement(driver,description_Input);
            //act.moveToElement(description_Input).click().build().perform();
            //HelpersMethod.JSSetValueEle(driver,description_Input,10000,"");
            HelpersMethod.JSSetValueEle(driver,description_Input,10000,"");
            HelpersMethod.ActSendKey(driver,description_Input,10000,desc);
            DescVal=HelpersMethod.JSGetValueEle(driver,description_Input,10000);
            scenario.log("CUSTOMER DESCRIPTION ENTERED IS: "+DescVal);
            Assert.assertEquals(desc,DescVal);
        }
        catch (Exception e){}
    }

    public void New_ButtonClick()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.ActClick(driver,new_But,20000);
            exists=true;
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.WaitElementPresent(driver,"xpath","//div[@id='CustomerMasterBottom']",4000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Save_ButtonClick() throws InterruptedException
    {
        Thread.sleep(8000);
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.id("customerInquirySaveBtn"))));
            WebElement save_Button=HelpersMethod.FindByElement(driver,"id","customerInquirySaveBtn");
            if(save_Button.isEnabled())
            {
                HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.ScrollTillElementVisible(driver,save_Button);
                HelpersMethod.JScriptClick(driver, save_Button, 20000);
                scenario.log("SAVE BUTTON HAS BEEN CLICKED");
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateSaveConfirmationPopup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SaveButtonOK()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement confirmationPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=confirmationPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,10000);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnCustomerAccIndex()
    {
        exists=false;
        try
        {
            if(customerAccountIndex.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, customerAccountIndex, 10000);
                //new WebDriverWait(driver,100).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-window k-dialog')]"))));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCustomerAccNoPopup()
    {
        Actions act1=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                HelpersMethod.AddFilterSearch_Popup(driver,"Customer #", TestBase.testEnvironment.get_Account());
                WebElement selectAccountNo=popUp.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ScrollElement(driver,selectAccountNo);
                act1.moveToElement(selectAccountNo).build().perform();
                act1.moveToElement(selectAccountNo).click().build().perform();
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void ClickCopy()
    {
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.id("customerInquiryCopyBtn"))));
            if(HelpersMethod.IsExists("//button[@id='customerInquiryCopyBtn']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"id","customerInquiryCopyBtn");
                HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.ScrollTillElementVisible(driver,WebEle);
                HelpersMethod.JScriptClick(driver, WebEle, 20000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            else
            {
                scenario.log("COPY BUTTON IS NOT VISIBLE");
            }
        }
        catch (Exception e){}
    }

    public void copyCustomerInqPopup()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
           {
               WebElement popUp = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
               WebElement store_No = popUp.findElement(By.xpath(".//input[@id='CmCustNo']"));
               String billValue = HelpersMethod.JSGetValueEle(driver, store_No, 10000);
               if (billValue.equals("") || billValue.equals(null))
               {
                   Bill=RandomValues.generateRandomNumber(10);
                   HelpersMethod.EnterText(driver, store_No, 10000, Bill);
               }

               String fname = RandomValues.generateRandomString(4);
               WebElement full_Name = popUp.findElement(By.xpath(".//input[@id='CmFullName']"));
               HelpersMethod.EnterText(driver, full_Name, 10000, fname);
               scenario.log("CUSTOMER NAME ENTERED IS " + HelpersMethod.JSGetValueEle(driver, full_Name, 10000));

               WebElement copy_Button = popUp.findElement(By.xpath(".//button/span[text()='Copy']"));
               HelpersMethod.ClickBut(driver, copy_Button, 10000);
               wait = new FluentWait<WebDriver>(driver)
                       .withTimeout(Duration.ofSeconds(600))
                       .pollingEvery(Duration.ofSeconds(2))
                       .ignoring(NoSuchElementException.class);
               wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
           }
        }
        catch (Exception e){}
    }

    public void copyCustomerInqPopupCancel()
    {
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement popUp = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebElement store_No = popUp.findElement(By.xpath(".//input[@id='CmCustNo']"));
                String billValue = HelpersMethod.JSGetValueEle(driver, store_No, 10000);
                if (billValue.equals("") || billValue.equals(null))
                {
                    Bill = RandomValues.generateRandomNumber(10);
                    HelpersMethod.EnterText(driver, store_No, 10000, Bill);
                }

                String fname = RandomValues.generateRandomString(4);
                WebElement full_Name = popUp.findElement(By.xpath(".//input[@id='CmFullName']"));
                HelpersMethod.EnterText(driver, full_Name, 10000, fname);
                scenario.log("CUSTOMER NAME ENTERED IS " + HelpersMethod.JSGetValueEle(driver, full_Name, 10000));

                WebElement copy_Button = popUp.findElement(By.xpath(".//button/span[text()='Cancel']"));
                HelpersMethod.ClickBut(driver, copy_Button, 10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void confirmationPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=popUp.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnNote()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            //Thread.sleep(2000);
            if(TestBase.testEnvironment.get_browser().equals("chrome")||TestBase.testEnvironment.get_browser().equals("edge"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.zoom='67%'");
            }
            else
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='67%'");
            }

            if(HelpersMethod.IsExists("//button[@id='customerInquiryNoteBtn']",driver))
            {
                WebElement noteButton = HelpersMethod.FindByElement(driver, "id", "customerInquiryNoteBtn");
                //HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.ClickBut(driver, noteButton, 10000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            if(TestBase.testEnvironment.get_browser().equals("chrome")||TestBase.testEnvironment.get_browser().equals("edge"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.zoom='100%'");
            }
            else
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='100%'");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNotePopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='CustomerNotesTopDiv']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("CUSTOMER NOTE DIALOG BOX HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Add_Customer_Note(String notes)
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@id='CustomerNotesTopDiv']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebElement noteArea = vallidateNotePopup.findElement(By.xpath(".//textarea[@id='noteTextbox']"));
                HelpersMethod.EnterText(driver, noteArea, 1000, notes);
                scenario.log("CUSTOMER NOTES ENTERED IS: "+notes);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Select_AlertType_Location(String AlertType, String Altertloc1, String Alertloc2)
    {
        exists=false;
        try
        {
            WebElement WebEle;
            String alertText;
            Actions act=new Actions(driver);
            //Finding Customer notes popup
            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                //code to select alert type
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebEle = vallidateNotePopup.findElement(By.xpath(".//span[@id='AlertType']"));
                HelpersMethod.ClickBut(driver, WebEle, 10000);

                List<WebElement> alerts=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='AlertType-listbox-id']/descendant::span[@class='k-list-item-text']");
                for(WebElement alert:alerts)
                {
                    act.moveToElement(alert).build().perform();
                    alertText=alert.getText();
                    if(alertText.equals(AlertType))
                    {
                        act.moveToElement(alert).build().perform();
                        act.click(alert).build().perform();
                        break;
                    }
                }

                String alertText1=HelpersMethod.FindByElement(driver,"xpath","//span[@id='AlertType-accessibility-id']/span[@class='k-input-value-text']").getText();
                if(alertText1.equalsIgnoreCase(AlertType))
                {
                    scenario.log("ALERT TYPE SELECTED IS: " + AlertType);
                }

                //code to select alert location
                List<WebElement> AlertLocations = vallidateNotePopup.findElements(By.xpath(".//input[@class='k-checkbox']/following-sibling::label"));
                int i = 0;
                for (WebElement AlertLoc : AlertLocations)
                {
                    i++;
                    String AlertLoc_Text = AlertLoc.getText();
                    if (AlertLoc_Text.equals(Altertloc1) || AlertLoc_Text.equals(Alertloc2))
                    {
                        WebEle = vallidateNotePopup.findElement(By.xpath(".//div[contains(@class,'col-md-3 col-xs-12')][" + i + "]/descendant::input"));
                        HelpersMethod.JScriptClick(driver, WebEle, 10000);
                        scenario.log("ALERT LOCATION SELECTED");
                        exists=true;
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Save_Note_Button()
    {
        exists = false;
        try
        {
            WebElement WebEle;
            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
            WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='SaveButton']"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ClickBut(driver, WebEle, 10000);
            exists=true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            Ok_Note_Button();
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }
    public void Ok_Note_Button()
    {
        WebElement WebEle;
        try
        {
            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-window k-dialog')]");
            WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='CustomerCommentDialogOK']"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ClickBut(driver, WebEle, 10000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
        }
        catch (Exception e) {}
    }

    public void clickOnCustomerAccountIndex()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(@class,'customer-account-component')]/following-sibling::button//*[local-name()='svg']",driver))
            {
                WebElement custAcc= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'customer-account-component')]/following-sibling::button//*[local-name()='svg']");
                HelpersMethod.ActClick(driver,custAcc,20000);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCustomerAccountIndex()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@class='i-grid']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("CUSTOMER ACCOUNT DIALOG BOX HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCustomerAccount(String searchValue)
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::span[contains(text(),'Add filter')]/ancestor::button",driver))
            {
                //Create webelement for account dialog box
                WebElement modalContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement addButton=modalContainer.findElement(By.xpath(".//span[contains(text(),'Add filter')]/ancestor::button"));
                //find whether any filters are already enabled, if yes clear all the filters
                List<WebElement> filters=modalContainer.findElements(By.xpath(".//div[contains(@class,'i-filter-tag')]"));
                if(filters.size()!=1)
                {
                    //click on add button
                    HelpersMethod.ActClick(driver,addButton,10000);
                    //identify clear all button and click on that
                    WebElement Clear=modalContainer.findElement(By.xpath(".//button/span[contains(text(),'Clear all')]"));
                    if(Clear.isEnabled())
                    {
                        HelpersMethod.ActClick(driver,Clear,10000);
                    }
                }

                //click on add button
                HelpersMethod.ActClick(driver,addButton,10000);

                //Enter value to first input of addfilter
                WebElement addFilterInput1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup--add')]/descendant::input[@class='i-search-box__input']");
                HelpersMethod.EnterText(driver,addFilterInput1,10000,searchValue);
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","CM_FULLNAME");
                HelpersMethod.ActClick(driver,checkBox,10000);
                //enter search value in second search input box
                WebElement addFilterInput2=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__content__input')]/input");
                HelpersMethod.EnterText(driver,addFilterInput2,10000,Desc);
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__footer')]/button/span[text()='Apply']");
                HelpersMethod.ActClick(driver,applyButton,10000);
                //Select 1st row in the customer accout# dialog popup
                WebElement custAccount=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ActClick(driver,custAccount,10000);
                //Click on cancel button to close dialog box
                WebElement cancelButton=modalContainer.findElement(By.xpath(".//button/span[text()='Cancel']"));
                HelpersMethod.ActClick(driver,cancelButton,10000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            }
        }
        catch (Exception e){}
    }

    public void selectCustomerAccountNo(String searchValue)
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::span[contains(text(),'Add filter')]/ancestor::button",driver))
            {
                //Create webelement for account dialog box
                WebElement modalContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement addButton=modalContainer.findElement(By.xpath(".//span[contains(text(),'Add filter')]/ancestor::button"));
                //find whether any filters are already enabled, if yes clear all the filters
                List<WebElement> filters=modalContainer.findElements(By.xpath(".//div[contains(@class,'i-filter-tag')]"));
                if(filters.size()!=1)
                {
                    //click on add button
                    HelpersMethod.ActClick(driver,addButton,10000);
                    //identify clear all button and click on that
                    WebElement Clear=modalContainer.findElement(By.xpath(".//button/span[contains(text(),'Clear all')]"));
                    if(Clear.isEnabled())
                    {
                        HelpersMethod.ActClick(driver,Clear,10000);
                    }
                }

                //click on add button
                HelpersMethod.ActClick(driver,addButton,10000);

                //Enter value to first input of addfilter
                WebElement addFilterInput1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup--add')]/descendant::input[@class='i-search-box__input']");
                HelpersMethod.EnterText(driver,addFilterInput1,10000,searchValue);
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","FORMATTED_CM_CUSTKEY");
                HelpersMethod.ActClick(driver,checkBox,10000);
                //enter search value in second search input box
                WebElement addFilterInput2=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__content__input')]/input");
                HelpersMethod.EnterText(driver,addFilterInput2,10000,TestBase.testEnvironment.get_Account());
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__footer')]/button/span[text()='Apply']");
                HelpersMethod.ActClick(driver,applyButton,10000);
                //Select 1st row in the customer accout# dialog popup
                WebElement custAccount=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ActClick(driver,custAccount,10000);
                //Click on cancel button to close dialog box
                WebElement cancelButton=modalContainer.findElement(By.xpath(".//button/span[text()='Cancel']"));
                HelpersMethod.ActClick(driver,cancelButton,10000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            }
        }
        catch (Exception e){}
    }

    public void selectCustomerAccountForAdminSetting(String searchValue)
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::span[contains(text(),'Add filter')]/ancestor::button",driver))
            {
                //Create webelement for account dialog box
                WebElement modalContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement addButton=modalContainer.findElement(By.xpath(".//span[contains(text(),'Add filter')]/ancestor::button"));
                //find whether any filters are already enabled, if yes clear all the filters
                List<WebElement> filters=modalContainer.findElements(By.xpath(".//div[contains(@class,'i-filter-tag')]"));
                if(filters.size()!=1)
                {
                    //click on add button
                    HelpersMethod.ActClick(driver,addButton,10000);
                    //identify clear all button and click on that
                    WebElement Clear=modalContainer.findElement(By.xpath(".//button/span[contains(text(),'Clear all')]"));
                    if(Clear.isEnabled())
                    {
                        HelpersMethod.ActClick(driver,Clear,10000);
                    }
                }

                //click on add button
                HelpersMethod.ActClick(driver,addButton,10000);

                //Enter value to first input of addfilter
                WebElement addFilterInput1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup--add')]/descendant::input[@class='i-search-box__input']");
                HelpersMethod.EnterText(driver,addFilterInput1,10000,searchValue);
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","CM_FULLNAME");
                HelpersMethod.ActClick(driver,checkBox,10000);
                //enter search value in second search input box
                WebElement addFilterInput2=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__content__input')]/input");
                HelpersMethod.EnterText(driver,addFilterInput2,10000,TestBase.testEnvironment.get_Account());
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__footer')]/button/span[text()='Apply']");
                HelpersMethod.ActClick(driver,applyButton,10000);
                //Select 1st row in the customer accout# dialog popup
                WebElement custAccount=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ActClick(driver,custAccount,10000);
                //Click on cancel button to close dialog box
                WebElement cancelButton=modalContainer.findElement(By.xpath(".//button/span[text()='Cancel']"));
                HelpersMethod.ActClick(driver,cancelButton,10000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void selectCustomerAccountUsingCustomerAccount(String searchValue)
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::span[contains(text(),'Add filter')]/ancestor::button",driver))
            {
                //Create webelement for account dialog box
                WebElement modalContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement addButton=modalContainer.findElement(By.xpath(".//span[contains(text(),'Add filter')]/ancestor::button"));
                //find whether any filters are already enabled, if yes clear all the filters
                List<WebElement> filters=modalContainer.findElements(By.xpath(".//div[contains(@class,'i-filter-tag')]"));
                if(filters.size()!=1)
                {
                    //click on add button
                    HelpersMethod.ActClick(driver,addButton,10000);
                    //identify clear all button and click on that
                    WebElement Clear=modalContainer.findElement(By.xpath(".//button/span[contains(text(),'Clear all')]"));
                    if(Clear.isEnabled())
                    {
                        HelpersMethod.ActClick(driver,Clear,10000);
                    }
                }

                //click on add button
                HelpersMethod.ActClick(driver,addButton,10000);

                //Enter value to first input of addfilter
                WebElement addFilterInput1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup--add')]/descendant::input[@class='i-search-box__input']");
                HelpersMethod.EnterText(driver,addFilterInput1,10000,searchValue);
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","FORMATTED_CM_CUSTKEY");
                HelpersMethod.ActClick(driver,checkBox,10000);
                //enter search value in second search input box
                WebElement addFilterInput2=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__content__input')]/input");
                HelpersMethod.EnterText(driver,addFilterInput2,10000,TestBase.testEnvironment.get_Account());
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__footer')]/button/span[text()='Apply']");
                HelpersMethod.ActClick(driver,applyButton,10000);
                //Select 1st row in the customer accout# dialog popup
                WebElement custAccount=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ActClick(driver,custAccount,10000);
                //Click on cancel button to close dialog box
                WebElement cancelButton=modalContainer.findElement(By.xpath(".//button/span[text()='Cancel']"));
                HelpersMethod.ActClick(driver,cancelButton,10000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void validateNoteInPopup(String custNote)
    {
        exists=false;
        String commentText=null;
        Actions act=new Actions(driver);
        try
        {
            WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
            List<WebElement> comments=modelContainer.findElements(By.xpath(".//tr[contains(@class,'k-master-row')]/descendant::td[3]"));
            for(WebElement comment:comments)
            {
                act.moveToElement(comment).build().perform();
                commentText=comment.getText();
                if(commentText.equals(custNote))
                {
                    scenario.log(commentText+" COMMENT HAS BEEN FOUND IN NOTE DIALOG BOX");
                    exists=true;
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void clickOnOkButtonOfCustNote()
    {
        exists=false;
        try
        {
            WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
            WebElement okButton=modelContainer.findElement(By.xpath(".//button[@id='CustomerCommentDialogOK']"));
            if(okButton.isDisplayed() && okButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,okButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void popUpForCustomerNameRequired()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'The following fields are invalid:')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                HelpersMethod.ActClick(driver,okButton,10000);
                scenario.log("ENTERING OF CUSTOMER ACCOUNT NAME IS MUST");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnPaymentProcessing()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CmCCProc']/parent::span",driver))
            {
                scenario.log("PAYMENT PROCESS DROP DOWN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifySystemDefaultRealTime()
    {
        exists=false;
        Actions act=new Actions(driver);
        String payOptions;
        try
        {
            List<WebElement> paymentProcess=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            for(WebElement payProcess:paymentProcess)
            {
                act.moveToElement(payProcess).build().perform();
                payOptions=payProcess.getText();
                if(payOptions.equalsIgnoreCase("System default (Realtime charge)"))
                {
                    scenario.log("PAYMENT PROCESS System default (Realtime charge) HAS BEEN FOUND");
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void handleNotePopup()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@id='customerNotesDialog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement moduleContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=moduleContainer.findElement(By.xpath("//button[@id='CustomerCommentDialogOK']"));
                HelpersMethod.ActClick(driver,okButton,10000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void verifyCustomerAccountWithDefaultValue()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if(HelpersMethod.IsExists("//div[contains(@class,'customer-account-code-search')]/descendant::input",driver))
            {
                WebElement customerAccount = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-account-code-search')]/descendant::input");
                String accountValue=HelpersMethod.JSGetValueEle(driver,customerAccount,40000);
                if(accountValue.equals("##########"))
                {
                    scenario.log("FOUND DEFAULT VALUE AS ACCOUNT# AS: "+accountValue);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyCustomerAccountWithNoValue()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'customer-account-code-search')]/descendant::input",driver))
            {
                WebElement customerAccount = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-account-code-search')]/descendant::input");
                String accountValue=HelpersMethod.JSGetValueEle(driver,customerAccount,10000);
                if(accountValue.equals(""))
                {
                    scenario.log("ACCOUNT# IN CUSTOMER INQ CONTAINS NULL VALUE");
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void NoNotePopHandling()
    {
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Check for Note popup
            if(HelpersMethod.IsExists("//div[@id='customerCommentGrid']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                // to fetch the web element
                WebElement notePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                //code to click on 'Ok' button in OG popup
                WebElement okButton = notePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, okButton, 10000);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
        }
        catch (Exception e) {}
    }

    public void readDetailsInMainPage()
    {
        exists=false;
        String primaryValues;
        try
        {
            primaryValues=HelpersMethod.FindByElement(driver,"id","CmAdd1").getAttribute("value");
            scenario.log("ADDRESS FOUND IN PRIMARY TAB IS::: "+primaryValues);
            primaryValues=HelpersMethod.FindByElement(driver,"id","CmCity").getAttribute("value");
            scenario.log("CITY DEATAILS FOUND::: "+primaryValues);
            primaryValues=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmState-accessibility-id']/span").getText();
            scenario.log("STATE DEATAILS FOUND::: "+primaryValues);
        }
        catch (Exception e){}
    }
}
