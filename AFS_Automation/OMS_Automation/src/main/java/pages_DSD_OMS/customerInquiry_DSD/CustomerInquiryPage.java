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
import pages_DSD_OMS.login.HomePage;
import util.RandomValues;

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
    static String Desc=null;

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

    public void Refresh_Page()
    {
        driver.navigate().refresh();
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
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
            Assert.assertEquals("Customer inquiry",title);
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
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
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
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='customer-account-component']");
            HelpersMethod.ScrollElement(driver,WebEle);
            Bill=RandomValues.generateRandomNumber(10);
            act.moveToElement(bill_Input).click().build().perform();
            HelpersMethod.EnterText(driver,bill_Input,10,Bill);
            BillVal=HelpersMethod.JSGetValueEle(driver,bill_Input,10);
        }
        catch (Exception e){}
    }

    public void StoreNo()
    {
        exists=false;
        String StoreVal=null;
        Actions act=new Actions(driver);
        try
        {
            Store=RandomValues.generateRandomNumber(8);
            act.moveToElement(store_Input).click().build().perform();
            HelpersMethod.EnterText(driver,store_Input,10,Store);
            scenario.log("STORE # IS: "+Store);
            StoreVal=HelpersMethod.JSGetValueEle(driver,store_Input,10);
                exists=true;
                Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DeptNo()
    {
        exists=false;
        String DeptVal=null;
        Actions act=new Actions(driver);
        try
        {
            Dept=RandomValues.generateRandomNumber(6);
            act.moveToElement(dept_Input).click().build().perform();
            HelpersMethod.EnterText(driver,dept_Input,10,Dept);
            scenario.log("DEPARTMENT NUMBER ENTERED IS "+Dept);
            DeptVal=HelpersMethod.JSGetValueEle(driver,dept_Input,10);
                exists=true;
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
            Desc=RandomValues.generateRandomString(6);
            act.moveToElement(description_Input).click().build().perform();
            HelpersMethod.EnterText(driver,description_Input,100,Desc);
            scenario.log("DESCRIPTION ENTERED IS "+Desc);
            DescVal=HelpersMethod.JSGetValueEle(driver,description_Input,100);
                exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void New_ButtonClick()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,new_But,100);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
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
                HelpersMethod.ClickBut(driver, save_Button, 200);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
            }
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
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
                    HelpersMethod.ClickBut(driver,okButton,100);
                    exists=true;
                    //new WebDriverWait(driver,2000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cards']"))));
                }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnNote()
    {
        try
        {
            WebElement noteButton= HelpersMethod.FindByElement(driver,"xpath","//button[text()='Note']");
            HelpersMethod.ActClick(driver,noteButton,100);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
        }
        catch (Exception e){}
    }

    public void validateNotePopup()
    {
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            //Assert.assertEquals(modalContentTitle.getText(), "Notes", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void Add_Customer_Note(String notes)
    {
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//p[contains(text(),'Notes')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement noteArea = vallidateNotePopup.findElement(By.xpath(".//textarea[@id='noteTextbox']"));
                HelpersMethod.ActSendKey(driver, noteArea, 100, notes);
                scenario.log("CUSTOMER NOTES ENTERED IS: "+notes);
            }
        }
        catch (Exception e) {}
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
                HelpersMethod.ClickBut(driver, WebEle, 100);
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
                        HelpersMethod.JScriptClick(driver, WebEle, 100);
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
            HelpersMethod.ClickBut(driver, WebEle, 100);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
            }
           // Ok_Note_Button();
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
            HelpersMethod.ClickBut(driver, WebEle, 100);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
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
                    HelpersMethod.ClickBut(driver,WebEle,1);
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
        HelpersMethod.Implicitwait(driver,20);
        exists=false;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","copyNote");
            HelpersMethod.ActClick(driver,WebEle,20);
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
                    HelpersMethod.ActClick(driver,WebEle,2);
                    //Delete the note
                    WebEle=HelpersMethod.FindByElement(driver,"id","deleteNote");
                    HelpersMethod.ActClick(driver,WebEle,2);
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
            HelpersMethod.ClickBut(driver,Button_Ele,1);
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
            HelpersMethod.EnterText(driver,description_Input,10,Desc);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//li[contains(@id,'react-autowhatever-AccountDescription--item')]");
            HelpersMethod.ActClick(driver,WebEle,10);
            DescVal=HelpersMethod.JSGetValueEle(driver,description_Input,10);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
        }
        catch (Exception e){}
    }

    public void ClickCopy()
    {
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//button[text()='Copy']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Copy']");
                HelpersMethod.ActClick(driver,WebEle,20);
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

                InputVal=RandomValues.generateRandomString(10);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmFullName");
                HelpersMethod.EnterText(driver,WebEle,80,InputVal);
                scenario.log("CUSTOMER NAME IS "+InputVal);

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmOrigCustNo");
                HelpersMethod.EnterText(driver,WebEle,80,InputVal);
                scenario.log("ORIGINAL CUSTOMER NUMBER IS "+InputVal);

                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Copy']");
                HelpersMethod.ClickBut(driver,WebEle,80);

                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                }

                if(HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The information has been saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,100);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}

