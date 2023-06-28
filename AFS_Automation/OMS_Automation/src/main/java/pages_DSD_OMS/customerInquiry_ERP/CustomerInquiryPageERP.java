package pages_DSD_OMS.customerInquiry_ERP;

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
import pages_DSD_OMS.login.HomePage;
import util.RandomValues;
import util.TestBase;

import java.util.List;

public class CustomerInquiryPageERP
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String Bill=null;
    static String Desc=null;

    @FindBy(xpath="//button[text()='New']")
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

    public void Refresh_Page()
    {
        driver.navigate().refresh();
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
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
            HelpersMethod.ClickBut(driver, CustInqMenu, 60);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
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
            }

            if(CustInqMenu.isDisplayed())
            {
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
            }
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

    public void BillNo()
    {
        exists=false;
        String BillVal=null;
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='customer-account-component']");
            HelpersMethod.ScrollElement(driver,WebEle);
            Bill= RandomValues.generateRandomNumber(10);
            act.moveToElement(bill_Input).click().build().perform();
            HelpersMethod.JSSetValueEle(driver,bill_Input,20," ");
            HelpersMethod.JSSetValueEle(driver,bill_Input,10,Bill);
            BillVal=HelpersMethod.JSGetValueEle(driver,bill_Input,10);
            if(Bill.equals(BillVal))
            {
                scenario.log("VALUE ENTERED FOR BILLING# "+BillVal);
                exists=true;
            }
            Assert.assertEquals(exists,true);
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
            Desc=RandomValues.generateRandomString(4);
            HelpersMethod.ScrollElement(driver,description_Input);
            act.moveToElement(description_Input).click().build().perform();
            HelpersMethod.clearText(driver,description_Input,10);
            HelpersMethod.EnterText(driver,description_Input,10,Desc);
            DescVal=HelpersMethod.JSGetValueEle(driver,description_Input,10);
            exists=true;
            scenario.log("CUSTOMER DESCRIPTION ENTERED IS: "+DescVal);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void New_ButtonClick()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,new_But,200);
            exists=true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 6000);
            }
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[@id='CustomerMasterBottom']",40);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Save_ButtonClick()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebElement save_Button=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Save']");
            if(save_Button.isEnabled())
            {
                HelpersMethod.ClickBut(driver, save_Button, 2000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
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
            if (HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
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
                HelpersMethod.ClickBut(driver,okButton,6000);
                exists=true;
                //new WebDriverWait(driver,2000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cards']"))));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnCustomerAccIndex()
    {
        try
        {
            HelpersMethod.ClickBut(driver,customerAccountIndex,20);
            new WebDriverWait(driver,100).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
        }
        catch (Exception e){}
    }

    public void selectCustomerAccNoPopup()
    {
        Actions act1=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                HelpersMethod.AddFilterSearch_Popup(driver,"Customer #", TestBase.testEnvironment.get_Account());
                WebElement selectAccountNo=popUp.findElement(By.xpath(".//tr[@class='k-master-row'][1]"));
                HelpersMethod.ScrollElement(driver,selectAccountNo);
                act1.moveToElement(selectAccountNo).build().perform();
                act1.moveToElement(selectAccountNo).click().build().perform();
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
            }
        }
        catch (Exception e){}
    }

    public void clickOnCopyButton()
    {
        try
        {
            WebElement copyButton=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Copy']");
            HelpersMethod.ScrollElement(driver,copyButton);
            HelpersMethod.ClickBut(driver,copyButton,100);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            new WebDriverWait(driver,1000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
        }
        catch (Exception e){}
    }

    public void copyCustomerInqPopup()
    {
        try
        {
           WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
        //   WebElement store_No=popUp.findElement(By.xpath(".//input[@id='CmCustNo']"));
       //    HelpersMethod.EnterText(driver,store_No,40,Bill);

            String fname=RandomValues.generateRandomString(4);
           WebElement full_Name=popUp.findElement(By.xpath(".//input[@id='CmFullName']"));
           HelpersMethod.EnterText(driver,full_Name,40,fname);
           scenario.log("CUSTOMER NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,full_Name,40));

           WebElement copy_Button=popUp.findElement(By.xpath(".//button[text()='Copy']"));
           HelpersMethod.ClickBut(driver,copy_Button,100);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
            }
        }
        catch (Exception e){}
    }

    public void confirmationPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=popUp.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,40);
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
            if(HelpersMethod.IsExists("//button[text()='Note']",driver))
            {
                WebElement noteButton = HelpersMethod.FindByElement(driver, "xpath", "//button[text()='Note']");
                HelpersMethod.ActClick(driver, noteButton, 100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNotePopup()
    {
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]/descendant::p"));
            Assert.assertEquals(modalContentTitle.getText(), "Notes", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void Add_Customer_Note(String notes)
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//p[contains(text(),'Notes')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement noteArea = vallidateNotePopup.findElement(By.xpath(".//textarea[@id='noteTextbox']"));
                HelpersMethod.ActSendKey(driver, noteArea, 40, notes);
                exists=true;
                scenario.log("CUSTOMER NOTES ENTERED IS: "+notes);
            }
        }
        catch (Exception e) {}
        Assert.assertEquals(exists,true);
    }

    public void Select_AlertType_Location(String AltertType, String Altertloc1, String Alertloc2)
    {
        try
        {
            WebElement WebEle = null;
            //Finding Customer notes popup
            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                //code to select alert type
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = vallidateNotePopup.findElement(By.xpath(".//span[@id='AlertType']"));
                HelpersMethod.ClickBut(driver, WebEle, 80);
                new WebDriverWait(driver, 100).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]"))));
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
                        HelpersMethod.JScriptClick(driver, WebEle, 40);
                        scenario.log("ALERT LOCATION SELECTED");
                    }
                }
            }
        }
        catch (Exception e) {}
    }

    public void Save_Note_Button()
    {
        try
        {
            exists = false;
            WebElement WebEle;
            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='SaveButton']"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ClickBut(driver, WebEle, 40);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Ok_Note_Button();
        }
        catch (Exception e) {}
    }
    public void Ok_Note_Button()
    {
        WebElement WebEle;
        try
        {
            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='CustomerCommentDialogOK']"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ClickBut(driver, WebEle, 40);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
        }
        catch (Exception e) {}
    }
}
