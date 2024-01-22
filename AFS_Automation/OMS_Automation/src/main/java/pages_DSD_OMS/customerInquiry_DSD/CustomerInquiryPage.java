package pages_DSD_OMS.customerInquiry_DSD;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
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

import java.time.Duration;
import java.util.List;
import java.util.ServiceConfigurationError;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class CustomerInquiryPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String Bill=null;
    static String Store=null;
    static String Dept=null;
    static String Desc="skjldfgs123";
    static String currentURL=null;

    @FindBy(xpath="//button[text()='New']")
    private WebElement new_But;

    @FindBy(id="save-button")
    private WebElement save_But;

    @FindBy(xpath="//input[contains(@id,'segmentInput_0')]")
    private WebElement bill_Input;

    @FindBy(xpath="//input[contains(@id,'segmentInput_1')]")
    private WebElement store_Input;

    @FindBy(xpath = "//input[contains(@id,'segmentInput_2')]")
    private WebElement dept_Input;

    @FindBy(xpath="//input[@placeholder='Description']")
    private WebElement description_Input;

    //Actions
    public CustomerInquiryPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void HandleError_Page()
    {
        try {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError")) {
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
        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
        {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.location.reload()");
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
          /*  if (wait.until(ExpectedConditions.alertIsPresent()) == null)
            {

            }
            else
            {*/
                Alert alert = driver.switchTo().alert();
                alert.accept();
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            //}
            wait1 = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
    }

    public void Refresh_Page()
    {
        driver.navigate().refresh();
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
    }

    public void NavigateToCustomerInquiry()
    {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("Customer Inquiry").build().perform();
            WebElement CustInqMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Customer Inquiry')] | //ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Customer inquiry')]");
            HelpersMethod.ClickBut(driver, CustInqMenu, 1000);
            exists = true;
            /*   if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                    act.moveToElement(WebEle).build().perform();
                    act.click(WebEle).build().perform();
                }*/

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(150))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(150))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            currentURL = driver.getCurrentUrl();
            scenario.log(currentURL);

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).click().build().perform();
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if(CustInqMenu.isDisplayed())
            {
                currentURL= driver.getCurrentUrl();
                scenario.log("NAVIGATED TO CUSTOMER INQ PAGE");
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
        WebElement WebEle=null;
        String title;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            //WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'spnmoduleNameHeader')]");
            //title=WebEle.getText();
            title=HelpersMethod.gettingTitle(driver);
            Assert.assertEquals("Customer Master",title);
        }
        catch (Exception e){}
    }

    public void NavigateDifferentTabs(String TabText)
    {
        exists=false;
        Actions act=new Actions(driver);
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
                    //act.click(CustOption).build().perform();
                    HelpersMethod.JScriptClick(driver,CustOption,1000);
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void BillNo()
    {
        exists=false;
        String BillVal=null;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String billValue=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='customer-account-component']");
            HelpersMethod.ScrollElement(driver,WebEle);
            billValue=HelpersMethod.JSGetValueEle(driver, bill_Input, 1000);
            if(billValue.equals(""))
            {
                Bill = RandomValues.generateRandomNumber(10);
                act.moveToElement(bill_Input).click().build().perform();
                HelpersMethod.EnterText(driver, bill_Input, 1000, Bill);
                BillVal = HelpersMethod.JSGetValueEle(driver, bill_Input, 1000);
                scenario.log("BILL VALUE ENTERED IS "+BillVal);
            }
        }
        catch (Exception e){}
    }

    public void StoreNo()
    {
        exists=false;
        String storeValue=null;
        String StoreVal=null;
        Actions act=new Actions(driver);
        try
        {
            storeValue=HelpersMethod.JSGetValueEle(driver,store_Input,10000);
            if(storeValue.equals(""))
            {
                Store = RandomValues.generateRandomNumber(8);
                act.moveToElement(store_Input).click().build().perform();
                HelpersMethod.EnterText(driver, store_Input, 10000, Store);
                scenario.log("STORE # IS: " + Store);
                StoreVal = HelpersMethod.JSGetValueEle(driver, store_Input, 10000);
                scenario.log("STORE NUMBER ENTERED IS "+StoreVal);
            }
        }
        catch (Exception e){}
    }

    public void DeptNo()
    {
        exists=false;
        String departValue=null;
        String DeptVal=null;
        Actions act=new Actions(driver);
        try
        {
            departValue=HelpersMethod.JSGetValueEle(driver,store_Input,10000);
            if(departValue.equals(""))
            {
                Dept = RandomValues.generateRandomNumber(6);
                act.moveToElement(dept_Input).click().build().perform();
                HelpersMethod.EnterText(driver, dept_Input, 10000, Dept);
                scenario.log("DEPARTMENT NUMBER ENTERED IS " + Dept);
                DeptVal = HelpersMethod.JSGetValueEle(driver, dept_Input, 10000);
                scenario.log("DEPARTMENT VALUE ENTERED IS1 "+DeptVal);
            }
        }
        catch (Exception e){}
    }

    public void DescrVal()
    {
        exists=false;
        String DescVal=null;
        Actions act=new Actions(driver);
        try
        {
            Desc=RandomValues.generateRandomString(6);
            act.moveToElement(description_Input).click().build().perform();
            HelpersMethod.EnterText(driver,description_Input,10000,Desc);
            scenario.log("DESCRIPTION ENTERED IS "+Desc);

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }

            DescVal=HelpersMethod.JSGetValueEle(driver,description_Input,10000);
            if(DescVal.equals(Desc))
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void New_ButtonClick()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,new_But,1000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[@id='CustomerMasterBottom']",40);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Save_ButtonClick() throws InterruptedException
    {
        Thread.sleep(8000);
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            WebElement save_Button=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Save']");
            if(save_Button.isEnabled())
            {
                HelpersMethod.ClickBut(driver, save_Button, 2000);
                scenario.log("SAVE BUTTON HAS BEEN CLICKED");
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(5))
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
            Thread.sleep(4000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            if (HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
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
                if (HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement confirmationPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement okButton=confirmationPopup.findElement(By.xpath(".//button[text()='Ok']"));
                    HelpersMethod.ActClick(driver,okButton,1000);
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

    public void clickOnNote()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//button[text()='Note']",driver))
            {
                WebElement noteButton = HelpersMethod.FindByElement(driver, "xpath", "//button[text()='Note']");
                HelpersMethod.ActClick(driver, noteButton, 10000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
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
           if(HelpersMethod.IsExists("//div[@id='CustomerNotesTopDiv']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
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
            if (HelpersMethod.IsExists("//div[@id='CustomerNotesTopDiv']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement noteArea = vallidateNotePopup.findElement(By.xpath(".//textarea[@id='noteTextbox']"));
                HelpersMethod.EnterText(driver, noteArea, 1000, notes);
                scenario.log("CUSTOMER NOTES ENTERED IS: "+notes);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Select_AlertType_Location(String AltertType, String Altertloc1, String Alertloc2)
    {
        exists=false;
        try
        {
            WebElement WebEle = null;
            //Finding Customer notes popup
            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                //code to select alert type
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = vallidateNotePopup.findElement(By.xpath(".//span[@id='AlertType']"));
                HelpersMethod.ClickBut(driver, WebEle, 1000);
                new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]"))));
                HelpersMethod.DropDownMenu(driver, AltertType);
                scenario.log("ALERT TYPE SELECTED IS: "+AltertType);

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
                        HelpersMethod.JScriptClick(driver, WebEle, 1000);
                        exists=true;
                        scenario.log("ALERT LOCATION SELECTED");
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Save_Note_Button()
    {
        try
        {
            exists = false;
            WebElement WebEle;
            if(HelpersMethod.IsExists("//button[@id='SaveButton']",driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='SaveButton']"));
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ClickBut(driver, WebEle, 1000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }
    public void Ok_Note_Button()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//button[@id='CustomerCommentDialogOK']",driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='CustomerCommentDialogOK']"));
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ClickBut(driver, WebEle, 1000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Creating list of customer note in customer note grid and select one of the note
    public void Select_Note(String cust_Note)
    {
        WebElement WebEle=null;
        exists=false;
        try
        {
            int i=0;
            //Read all the note from the grid
            java.util.List<WebElement> Notes=driver.findElements(By.xpath("//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr/td[3]"));
            for(WebElement Note:Notes)
            {
                i++;
                String Note_Text=Note.getText();
                if(Note_Text.equals(cust_Note))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr["+i+"]/td[3]");
                    HelpersMethod.ClickBut(driver,WebEle,1000);
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on Copy button in Customer note popup
    public void Click_Copy_Note()
    {
        exists=false;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","copyNote");
            HelpersMethod.ActClick(driver,WebEle,8000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code for deleting note
    public void Select_Note_Del(String Note_Del)
    {
        exists=false;
        try
        {
            int i = 0;
            WebElement WebEle=null;
            //Read all the note from the grid
            List<WebElement> Notes = driver.findElements(By.xpath("//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr/td[3]"));
            for (WebElement Note : Notes)
            {
                i++;
                String Note_Text = Note.getText();
                if (Note_Text.equals(Note_Del))
                {
                    //Select the note
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr[" + i + "]/td[3]");
                    HelpersMethod.ActClick(driver,WebEle,8000);
                    //Delete the note
                    WebEle=HelpersMethod.FindByElement(driver,"id","deleteNote");
                    HelpersMethod.ActClick(driver,WebEle,8000);
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                    }
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //For reset button functionality in cusomter note popup
    public void ReSet_Note_Button()
    {
        exists=false;
        try
        {
            WebElement Button_Ele=HelpersMethod.FindByElement(driver,"id","resetNote");
            HelpersMethod.ClickBut(driver,Button_Ele,1000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void LoadCustomer()
    {
        exists=false;
        WebElement WebEle;
        String DescVal=null;
        try
        {
            HelpersMethod.EnterText(driver,description_Input,1000,Desc);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//li[contains(@id,'react-autowhatever-AccountDescription--item')]");
            HelpersMethod.ActClick(driver,WebEle,1000);
            DescVal=HelpersMethod.JSGetValueEle(driver,description_Input,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
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
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//button[text()='Copy']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Copy']");
                HelpersMethod.ClickBut(driver,WebEle,2000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
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

    public void CopyCutomerPopup()
    {
        WebElement WebEle;
        String InputVal;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Copy customer", "Verify Title message");

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmCustNo");
                HelpersMethod.EnterText(driver,WebEle,8000,InputVal);
                scenario.log("BILL TO# IS "+InputVal);

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmStorNo");
                HelpersMethod.EnterText(driver,WebEle,8000,InputVal);
                scenario.log("STORE# IS "+InputVal);

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmDeptNo");
                HelpersMethod.EnterText(driver,WebEle,8000,InputVal);
                scenario.log("DEPARTMENT# IS "+InputVal);

                InputVal=RandomValues.generateRandomString(10);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmFullName");
                HelpersMethod.EnterText(driver,WebEle,8000,InputVal);
                scenario.log("CUSTOMER NAME IS "+InputVal);

                WebElement copyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Copy']");
                HelpersMethod.ActClick(driver,copyButton,8000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

              /*  if(HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement okButton=WebEle.findElement(By.xpath(".//button[text()='Ok']"));
                    HelpersMethod.ActClick(driver,okButton,10000);
                }*/

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CopyCutomerPopupCancel()
    {
        WebElement WebEle;
        String InputVal;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Copy customer", "Verify Title message");

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmCustNo");
                HelpersMethod.EnterText(driver,WebEle,8000,InputVal);
                scenario.log("BILL TO# IS "+InputVal);

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmStorNo");
                HelpersMethod.EnterText(driver,WebEle,8000,InputVal);
                scenario.log("STORE# IS "+InputVal);

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmDeptNo");
                HelpersMethod.EnterText(driver,WebEle,8000,InputVal);
                scenario.log("DEPARTMENT# IS "+InputVal);

                InputVal=RandomValues.generateRandomString(10);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmFullName");
                HelpersMethod.EnterText(driver,WebEle,8000,InputVal);
                scenario.log("CUSTOMER NAME IS "+InputVal);

                WebElement cancelButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Cancel']");
                HelpersMethod.ActClick(driver,cancelButton,8000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

              /*  if(HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The information has been saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement cancelButton=WebEle.findElement(By.xpath(".//button[text()='Cancel']"));
                    HelpersMethod.ActClick(driver,cancelButton,1000);
                }*/
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void refreshPage()
    {
        exists=true;
        try
        {
            driver.navigate().to(currentURL);
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
        catch (Exception e){}
    }

    public void clickOnCustomerAccountIndex()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'customer-account-component')]/following-sibling::button//*[local-name()='svg']",driver))
            {
                WebElement custAcc= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'customer-account-component')]/following-sibling::button//*[local-name()='svg']");
                HelpersMethod.ClickBut(driver,custAcc,1000);
                exists=true;
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
            if(HelpersMethod.IsExists("//div[@class='i-grid']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
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
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[contains(text(),'Add filter')]/ancestor::button",driver))
            {
                //Create webelement for account dialog box
                WebElement modalContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement addButton=modalContainer.findElement(By.xpath(".//span[contains(text(),'Add filter')]/ancestor::button"));
                //find whether any filters are already enabled, if yes clear all the filters
                List<WebElement> filters=modalContainer.findElements(By.xpath(".//div[contains(@class,'i-filter-tag')]"));
                if(filters.size()!=1)
                {
                    //click on add button
                    HelpersMethod.ActClick(driver,addButton,1000);
                    //identify clear all button and click on that
                    WebElement Clear=modalContainer.findElement(By.xpath(".//button[contains(text(),'Clear all')]"));
                    if(Clear.isEnabled())
                    {
                        HelpersMethod.ActClick(driver,Clear,2000);
                    }
                }

                //click on add button
                HelpersMethod.ActClick(driver,addButton,1000);

                //Enter value to first input of addfilter
                WebElement addFilterInput1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup--add')]/descendant::input[@class='i-search-box__input']");
                HelpersMethod.EnterText(driver,addFilterInput1,2000,searchValue);
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","CM_FULLNAME");
                HelpersMethod.ActClick(driver,checkBox,2000);
                //enter search value in second search input box
                WebElement addFilterInput2=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__content__input')]/input");
                HelpersMethod.EnterText(driver,addFilterInput2,4000,Desc);
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__footer')]/button[text()='Apply']");
                HelpersMethod.ActClick(driver,applyButton,1000);
                //Select 1st row in the customer accout# dialog popup
                WebElement custAccount=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ActClick(driver,custAccount,1000);
                //Click on cancel button to close dialog box
                WebElement cancelButton=modalContainer.findElement(By.xpath(".//button[text()='Cancel']"));
                HelpersMethod.ActClick(driver,cancelButton,1000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
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
            WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
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
            WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement okButton=modelContainer.findElement(By.xpath(".//button[@id='CustomerCommentDialogOK']"));
            if(okButton.isDisplayed() && okButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,okButton,2000);
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
            if(HelpersMethod.IsExists("//div[contains(text(),'The following fields are invalid:')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ActClick(driver,okButton,1000);
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
        String payOptions=null;
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

    //public void NoNotePopHandling(String note)
    public void NoNotePopHandling()
    {
        WebElement WebEle = null;
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
            if(HelpersMethod.IsExists("//div[@id='customerCommentGrid']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                // to fetch the web element
                WebElement notePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                //code to click on 'Ok' button in OG popup
                WebElement okButton = notePopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ActClick(driver, okButton, 4000);
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
}

