package pages_DSD_OMS.generalSettingsPage;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;
import util.TestBase;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author
 */
public class MerchantPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String currentURL=null;
    static String InputValue=null;

    static String MerchID=null;


    @FindBy(xpath = "//div[@id='menuWrapper_selected_accesscpadmingeneralsettings']//div[@class='submenu-item-text']")
    private WebElement notices;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]")
    private WebElement hamburger;


    @FindBy(xpath = "//*[@id='DropdownList1']/span[2]")
    private WebElement destinationDropdown;
    @FindBy(xpath = "//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]")
    private WebElement PermissionBy;

    @FindBy(xpath="//*[@id='AddBtn']")
    private WebElement AddNotice;


    @FindBy(xpath="//*[@class='i-filter-tag__clear']")
    private WebElement ClearFilter;
    @FindBy(xpath="//*[@class='i-filter-tag i-filter-tag--add']/button")
    private WebElement AddFilter;

    @FindBy(xpath="//*[@class='i-btn-checkbox ']//input[@id='Status']")
    private WebElement SelectFilterStatus;

    @FindBy(xpath="//*[@class='i-btn-checkbox ']//input[@id='Description']")
    private WebElement SelectFilterDesc;

    @FindBy(xpath="//*[@class='i-btn-checkbox ']//input[@id='DestinationName']")
    private WebElement SelectFilterDestination;


    @FindBy(xpath="//*[@class='i-btn-checkbox ']//input[@id='StartDate']")
    private WebElement SelectFilterStartDate;

    @FindBy(xpath="//*[@class='i-btn-checkbox ']//input[@id='EndDate']")
    private WebElement SelectFilterEndDate;

    @FindBy(xpath="//div[@class='i-filter-popup__content']/div[2]/span/span/a/span")
    private WebElement FilterStartDateIcon;

    @FindBy(xpath="//div[@class='i-filter-popup__content']/div[3]/span/span/a/span")
    private WebElement FilterEndDateIcon;

    @FindBy(xpath="//*[@class='k-textbox']")
    private WebElement FilterText;

    @FindBy(xpath="//*[@class='k-button k-primary k-button-icontext i-filter-popup__footer__button']")
    private WebElement ApplyFilter;

    @FindBy(xpath="//*[@class='k-button k-primary k-button-icontext i-filter-popup__footer__button']")
    private WebElement ApplyNotice;

    @FindBy(xpath="//*[@class='k-button k-flat k-button-icontext']")
    private WebElement AddPrint;
    @FindBy(xpath="//*[@id='dateInput1']")
    private WebElement StartDate;

    //@FindBy(xpath="//span[@class='k-widget k-multiselect']//input[@class='k-input']")
    @FindBy(xpath = "//button[contains(text(),'Print')]")
    private WebElement PrintBut;

    @FindBy(xpath="//span[@class='k-widget k-multiselect']//span//input")
    private WebElement DeliveryMultiSelect;


    @FindBy(xpath="//span[@class='k-widget k-multiselect k-state-focused']//span//input")
    private WebElement DeliveryMultiSelectVal;
    @FindBy(id="save-btn")
    private WebElement SaveButton;

    @FindBy(id="SaveBtn")
    private WebElement MerchSaveButton;

    @FindBy(xpath="//span[@id='CPMerchantGatewayUseSSL']")
    private WebElement SSLButton;

    @FindBy(id="QuestionModalButton1")
    private WebElement YesButton;

    @FindBy(id="AddBtn")
    private WebElement AddMerchantButton;

    @FindBy(xpath="//div[@class='k-widget k-window k-dialog']//button[@id='AddBtn']")
    private WebElement AddOverrideButton;
    @FindBy(xpath="//*[@class='k-grid-table']/tbody/tr[1]")
    private WebElement selectFirstMerchantrow;
    @FindBy(id="EditBtn")
    private WebElement EditMerchantButton;

    @FindBy(id="DeleteBtn")
    private WebElement DeleteMerchantButton;


    @FindBy(id="OverridesBtn")
    private WebElement OverridesMerchantButton;
    @FindBy(xpath= "//*[@id='SendBtn']")
    private WebElement SendemailButton;

    @FindBy(id="cancel-btn")
    private WebElement CancelButton;

    //Action
    public MerchantPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void NavigateToMerchant()
    {
        WebElement WebEle = null;
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            EnterValueInSearchBox("Merchant Gateway");
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, Duration.ofMillis( 6000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menuWrapper__accesscpadmingeneralsettings']//div[@class='submenu-item-text']")));
            if(HelpersMethod.IsExists("//*[@id='menuWrapper__accesscpadmingeneralsettings']//div[@class='submenu-item-text']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[@id='menuWrapper__accesscpadmingeneralsettings']//div[@class='submenu-item-text']");
                //act.moveToElement(WebEle).click().build().perform();
                HelpersMethod.JScriptClick(driver, WebEle, 20);

            }
            currentURL=driver.getCurrentUrl();
        }
        catch (Exception e) {}
    }


    //Click on Permission by
    public void ClickPermissionBy()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 900);
        }
        try
        {
            if(HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]",driver))
            {
                HelpersMethod.ActClick(driver, PermissionBy, 200);
                if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver))
                {
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);
    }

    //Method for Selecting company
    public void SelectCompany()
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String company=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]",driver))
            {
                //Click on Company drop down
                WebEle= HelpersMethod.FindByElement(driver,"id","dropdownList3");
                HelpersMethod.ClickBut(driver,WebEle,20);
                HelpersMethod.Implicitwait(driver,80);
                Thread.sleep(10);
                //Create list of web elements in dropdown
                company=TestBase.testEnvironment.get_CompanyNo();
                List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
                for(WebElement Val: Values)
                {
                    act.moveToElement(Val).build().perform();
                    String Val_Text = Val.getText();
                    HelpersMethod.Implicitwait(driver,40);
                    if (Val_Text.equalsIgnoreCase(company) || Val_Text.contains(company))
                    {
                        act.click(Val).build().perform();
                        HelpersMethod.Implicitwait(driver,40);
                        break;
                    }
                }
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='dropdownList3']/span[1]");
                scenario.log("COMPANY SELECTED IS "+WebEle.getText());
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
            }
        }
        catch (Exception e){}
    }

//

    public void ClicOnHumburger()
    {
        WebElement Humburger;
        try
        {
                if (HelpersMethod.IsExists("//div[@class='MuiPaper-root MuiDrawer-paper drawer-closed MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0']//div[@class='item-searchbar']", driver)) {
                    Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='MuiPaper-root MuiDrawer-paper drawer-closed MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0']//div[@class='item-searchbar']");
                    HelpersMethod.JScriptClick(driver, Humburger, 20);
            }
        }
        catch (Exception e){}

    }

    public void Click_SSLButton()
    {
        exists=false;
        try
        {
            if(SSLButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,SSLButton,20);
                scenario.log("SSL Button clicked");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_YesButton()
    {
        exists=false;
        try
        {
            if(SaveButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,YesButton,20);
                scenario.log("Yes Button is clicked");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnAddMerchant()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
        try
        {
//            if(HelpersMethod.IsExists("//*[@id='AddBtn']",driver))
//            {
                HelpersMethod.JScriptClick(driver, AddMerchantButton, 200);
                scenario.log("Merchant Button is clicked ");
                exists = true;
//            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnEditMerchant()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
        try
        {
//            if(HelpersMethod.IsExists("//*[@id='AddBtn']",driver))
//            {
            HelpersMethod.clickOn(driver, selectFirstMerchantrow, 200);
            HelpersMethod.JScriptClick(driver, EditMerchantButton, 200);
            scenario.log("Merchant Edit Button is clicked ");
            exists = true;
//            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnDeleteMerchant()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
        try
        {
//            if(HelpersMethod.IsExists("//*[@id='AddBtn']",driver))
//            {
            HelpersMethod.clickOn(driver, selectFirstMerchantrow, 200);
            HelpersMethod.JScriptClick(driver, DeleteMerchantButton, 200);
            scenario.log("Merchant Delete Button is clicked ");
            exists = true;
//            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnOverrideMerchant()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
        try
        {
//            if(HelpersMethod.IsExists("//*[@id='AddBtn']",driver))
//            {
            HelpersMethod.clickOn(driver, selectFirstMerchantrow, 200);
            HelpersMethod.JScriptClick(driver, OverridesMerchantButton, 200);
            scenario.log("Merchant Overrides Merchant Button is clicked ");
            exists = true;
//            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void okButton_delete()
    {
        exists=false;
        try
        {
            if(YesButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,YesButton,20);
                scenario.log("ok Button for merchant deletion is clicked");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void addOverride_button()
    {
        exists=false;
        try
        {
            if(AddOverrideButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,AddOverrideButton,200);
                scenario.log("Add Override merchant button is clicked");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectOwnerType()
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String OwnerType=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'textbox-container-item')]",driver))
            {
                //Click on Company drop down
                WebEle= HelpersMethod.FindByElement(driver,"id","OwnerType");
                HelpersMethod.ClickBut(driver,WebEle,20);
                HelpersMethod.Implicitwait(driver,80);
                Thread.sleep(10);
                //Create list of web elements in dropdown
                OwnerType="User Role";
                List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'textbox-container')]/descendant::li");
                for(WebElement Val: Values)
                {
                    act.moveToElement(Val).build().perform();
                    String Val_Text = Val.getText();
                    HelpersMethod.Implicitwait(driver,40);
                    if (Val_Text.equalsIgnoreCase(OwnerType) || Val_Text.contains(OwnerType))
                    {
                        act.click(Val).build().perform();
                        HelpersMethod.Implicitwait(driver,40);
                        break;
                    }
                }
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='OwnerType']/span[1]");
                scenario.log("OwnerType SELECTED IS "+WebEle.getText());
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
            }
        }
        catch (Exception e){}
    }

    public void Entermerchantcredentials()
    {
        exists=false;
        WebElement merchantID;
        WebElement merchantUserName;
        WebElement merchantUserPwd;
        try
        {
            merchantID=HelpersMethod.FindByElement(driver,"xpath","//*[@id='MerchantId']");
            merchantUserName=HelpersMethod.FindByElement(driver,"xpath","//*[@id='MerchantUserName']");
            merchantUserPwd=HelpersMethod.FindByElement(driver,"xpath","//*[@id='MerchantPassword']");
            MerchID=RandomValues.generateRandomAlphaNumeric(5);
            HelpersMethod.EnterText(driver,merchantID,10,MerchID);
            HelpersMethod.EnterText(driver,merchantUserName,10,"Automation");
            HelpersMethod.EnterText(driver,merchantUserPwd,10,"Automationpwd");
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Selectmerchantprovider()
    {
        exists=false;
        WebElement merchantprovider;
        try
        {
            merchantprovider=HelpersMethod.FindByElement(driver,"id","SupportsVisa");
            HelpersMethod.ActClick(driver,merchantprovider,10);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on Save button
    public void MerchSaveButton()
    {
        exists=false;
        try
        {
            if(MerchSaveButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,MerchSaveButton,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CloseHumburger()
    {
        WebElement Humburger;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]",driver))
            {
                Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                HelpersMethod.ActClick(driver, Humburger, 20);
            }
        }

        catch (Exception e){}
    }

    public void clickSMTPConfiguration()
    {
        WebElement SMTPConfig;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='k-tabstrip-items-wrapper k-hstack']/ul/li[2]/span",driver))
            {
                SMTPConfig = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-tabstrip-items-wrapper k-hstack']/ul/li[2]/span");
                HelpersMethod.JScriptClick(driver, SMTPConfig, 20);
            }
        }
        catch (Exception e){}
    }


    //Select menu value from the side search box
    public void EnterValueInSearchBox(String Menu_Value)
    {
        Actions act=new Actions(driver);
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='drawer-menu-application-container']");
            act.moveToElement(WebEle).build().perform();
            WebElement ClearSearch=HelpersMethod.FindByElement(driver,"xpath","//div[@class='searchbar-container']/descendant::i[@class='searchbar-container-close-icon']//*[local-name()='svg']");
            if(ClearSearch.isDisplayed())
            {
                HelpersMethod.ActClick(driver,ClearSearch,20);
            }
                WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
                act.moveToElement(Search_Input).sendKeys(Menu_Value).build().perform();
                WebElement Menu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'" + Menu_Value + "')]");
                HelpersMethod.ClickBut(driver, Menu, 10);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
        }
        catch(Exception e){}
    }

    //Selecting tab from horizontal menu bar
    public void Horizantal_MenuBar(String MenuItem)
    {
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            String Menu_Text=null;
            Actions act=new Actions(driver);
            List<WebElement> MenuBars=HelpersMethod.FindByElements(driver,"xpath","//div[@class='topMenu']/descendant::li/span");
            for(WebElement Menu:MenuBars)
            {
                HelpersMethod.Implicitwait(driver,20);
                act.moveToElement(Menu).build().perform();
                HelpersMethod.Implicitwait(driver,20);
                Menu_Text=Menu.getText();
                if(MenuItem.equals(Menu_Text))
                {
                    HelpersMethod.Implicitwait(driver,10);
                    act.click(Menu).build().perform();
                    HelpersMethod.Implicitwait(driver,40);
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
        }
        catch (Exception e){}
    }

    //Click on Save button
    public void Click_SaveButton()
    {
        exists=false;
        try
        {
            if(SaveButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,SaveButton,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }


    //Enter Date value from the Create Notices section
    public void EnterStartDate(int Start_Date_Val)
    {
        //exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.Implicitwait(driver,100);
        try
        {
             ClickOnStartDateCalender();
             HelpersMethod.Implicitwait(driver,90);
             SelectStartDate(Start_Date_Val);
                   //exists=true;
            HelpersMethod.Implicitwait(driver,90);
            WebElement WebEleDate2= HelpersMethod.FindByElement(driver,"xpath","//span[@class='date2']//a[@class='k-select']//span[@class='k-icon k-i-calendar']");
            new WebDriverWait(driver,Duration.ofMillis( 6000)).until(ExpectedConditions.visibilityOf(WebEleDate2));
            Actions act = new Actions(driver);
            act.moveToElement(WebEleDate2).build().perform();
            WebEleDate2.sendKeys(Keys.TAB);
//            }
            //Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }


    //Enter Date value from the Create Notices section
    public void EnterEndDate(int End_Date_Val)
    {
       // exists=false;
        HelpersMethod.Implicitwait(driver,90);
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80);
        }
        try
        {
//            if(StartDate.isDisplayed())
//            {
            ClickOnEndDateCalender();
            HelpersMethod.Implicitwait(driver,90);
            SelectEndDate(End_Date_Val);
         //   exists=true;
//            }
        //    Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectDestination()
    {
        exists=false;
        Actions act=new Actions(driver);
        HelpersMethod.Implicitwait(driver,40);
        try
        {
             HelpersMethod.clickOn(driver,destinationDropdown,100);
             HelpersMethod.sendKeys(driver,destinationDropdown,100,"Order Entry");
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    public void ClickOnStartDateCalender()
    {
       exists=false;
        WebElement WebEle1=null;
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(6000));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@class='CPMessageCenter']/descendant::span[contains(text(),'Create notice')]",80);
        HelpersMethod.Implicitwait(driver,200);
        try
        {
            //Click on start date icon
            WebEle1= HelpersMethod.FindByElement(driver,"xpath","//label[contains(@id,'dateInput1')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]");
            //WebEle1= HelpersMethod.FindByElement(driver,"xpath","//span[@class='date1']//a[@class='k-select']//span[@class='k-icon k-i-calendar']");
            HelpersMethod.JScriptClick(driver,WebEle1,200);
            exists=true;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists,true);
            HelpersMethod.Implicitwait(driver,60);
        }
        catch (Exception e){}
    }

    public void ClickFilterStartDateCalender()
    {
        exists=false;
        WebElement WebEle1=null;
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(8000));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
        //HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","(//span[@class='k-icon k-i-calendar'])[1]",80);
        //HelpersMethod.Implicitwait(driver,80);
        try
        {
            //Click on start date icon
//            WebEle1= HelpersMethod.FindByElement(driver,"xpath","(//a[@class='k-select'])[1]");
            //WebEle1= HelpersMethod.FindByElement(driver,"xpath","//span[@class='date1']//a[@class='k-select']//span[@class='k-icon k-i-calendar']");
            HelpersMethod.JScriptClick(driver,FilterStartDateIcon,100);
            exists=true;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists,true);
            HelpersMethod.Implicitwait(driver,60);
        }
        catch (Exception e){}
    }

    public void ClickFilterEndDateCalender()
    {
        exists=false;
        WebElement WebEle1=null;
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(8000));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
        //HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","(//span[@class='k-icon k-i-calendar'])[1]",80);
        //HelpersMethod.Implicitwait(driver,80);
        try
        {
            //Click on End date icon
//            WebEle1= HelpersMethod.FindByElement(driver,"xpath","(//a[@class='k-select'])[1]");
            //WebEle1= HelpersMethod.FindByElement(driver,"xpath","//span[@class='date1']//a[@class='k-select']//span[@class='k-icon k-i-calendar']");
            HelpersMethod.JScriptClick(driver,FilterEndDateIcon,300);
            exists=true;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists,true);
            HelpersMethod.Implicitwait(driver,60);
        }
        catch (Exception e){}
    }

    public void ClickOnEndDateCalender()
    {
        exists=false;
        WebElement WebEle=null;
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(8000));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add standing po')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@class='CPMessageCenter']/descendant::span[contains(text(),'Create notice')]",60);
        HelpersMethod.Implicitwait(driver,90);
        try
        {
            //Click on end date icon
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//label[contains(@id,'dateInput2')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]");
            //WebEle= HelpersMethod.FindByElement(driver,"xpath","//span[@class='date2']//a[@class='k-select']//span[@class='k-icon k-i-calendar']");
            HelpersMethod.ActClick(driver,WebEle,90);
            exists=true;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",60);
            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists,true);
            HelpersMethod.Implicitwait(driver,60);
        }
        catch (Exception e){}
    }

    //Selecting Start date
    public void SelectStartDate(int i)
    {
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",100);
        new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
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
                    scenario.log(formattedDate1 + " HAS BEEN SELECTED AS START DATE");
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
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",600);
        new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        WebElement WebEle=null;
        String FTDate=null;
        exists=false;
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",60);
            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
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
                    scenario.log(formattedDate1 + " HAS BEEN SELECTED AS END DATE");
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

    public void DeliveryDaysInputFromDropDown() {
        exists=false;
        HelpersMethod.WaitElementPresent(driver,"xpath","//span[@class='k-widget k-multiselect']",500);
        HelpersMethod.JScriptClick(driver,DeliveryMultiSelect,300);
        HelpersMethod.sendKeys(driver,DeliveryMultiSelectVal,200,"Mon");
        DeliveryMultiSelectVal.sendKeys(Keys.ENTER);
        DeliveryMultiSelectVal.sendKeys(Keys.TAB);
        exists=true;
        Assert.assertEquals(exists,true);
    }

    public void NoticeNameInput()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[@id='name']");
            InputValue=RandomValues.generateRandomAlphaNumeric(4);
            HelpersMethod.EnterText(driver,WebEle,10,InputValue);
            //PoNo=InputValue;
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void NoticeDescInput()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[@id='description']");
            InputValue=RandomValues.generateRandomAlphaNumeric(5);
            HelpersMethod.EnterText(driver,WebEle,10,InputValue);
            //PoNo=InputValue;
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
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

}

