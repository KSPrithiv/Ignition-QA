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
public class NoticesPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String currentURL;
    static String InputValue;

    @FindBy(xpath = "//div[@id='menuWrapper_selected_accesscpadmingeneralsettings']//div[@class='submenu-item-text']")
    private WebElement notices;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]")
    private WebElement hamburger;


    @FindBy(xpath = "//*[@id='DropdownList1']/span[2]")
    private WebElement destinationDropdown;


    @FindBy(id = "DropdownList1")
    private WebElement destinationListDropdown;

    @FindBy(xpath = "//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]")
    private WebElement PermissionBy;

    @FindBy(xpath="//*[@id='AddBtn']")
    private WebElement AddNotice;

    @FindBy(xpath="//div[contains(@class,'k-window-content')]/descendant::li[4]")
    private WebElement RouteNoticeTab;

    @FindBy(xpath="//div[contains(@class,'k-window-content')]/descendant::li[2]")
    private WebElement BranchNoticeTab;

    @FindBy(xpath="//div[contains(@class,'k-window-content')]/descendant::li[3]")
    private WebElement ChainNoticeTab;

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

    @FindBy(xpath = "//button/span[text()='Print']")
    private WebElement PrintBut;

    @FindBy(xpath="//span[@class='k-widget k-multiselect']//span//input")
    private WebElement DeliveryMultiSelect;


    @FindBy(xpath="//span[@class='k-widget k-multiselect k-state-focused']//span//input")
    private WebElement DeliveryMultiSelectVal;
    @FindBy(id="save-btn")
    private WebElement SaveButton;

    @FindBy(id="cancel-btn")
    private WebElement CancelButton;

    //Action
    public NoticesPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }


    public void NavigateToNotices()
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
            EnterValueInSearchBox("Notices");
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
            new WebDriverWait(driver, Duration.ofMillis(8000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menuWrapper__accesscpadmingeneralsettings']//div[@class='submenu-item-text']")));
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


    public void ClickOnAddFilterStatus(String status)
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@class='i-filter-tag__clear']",driver))
            {
                HelpersMethod.JScriptClick(driver, ClearFilter, 90);
                exists = true;
            }

            if(HelpersMethod.IsExists("//*[@class='i-filter-tag i-filter-tag--add']/button",driver))
            {
                HelpersMethod.JScriptClick(driver, AddFilter, 90);
                HelpersMethod.JScriptClick(driver,SelectFilterStatus,90);
                HelpersMethod.EnterText(driver,FilterText,70,status);

                    exists = true;
            }
//            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnAddFilterDesc(String Desc)
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@class='i-filter-tag__clear']",driver))
            {
                HelpersMethod.JScriptClick(driver, ClearFilter, 90);
                exists = true;
            }

            if(HelpersMethod.IsExists("//*[@class='i-filter-tag i-filter-tag--add']/button",driver))
            {
                HelpersMethod.JScriptClick(driver, AddFilter, 90);
                HelpersMethod.JScriptClick(driver,SelectFilterDesc,90);
                HelpersMethod.EnterText(driver,FilterText,70,Desc);

                exists = true;
            }
//            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnAddFilterDestination(String Destination)
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@class='i-filter-tag__clear']",driver))
            {
                HelpersMethod.JScriptClick(driver, ClearFilter, 90);
                exists = true;
            }

            if(HelpersMethod.IsExists("//*[@class='i-filter-tag i-filter-tag--add']/button",driver))
            {
                HelpersMethod.JScriptClick(driver, AddFilter, 90);
                HelpersMethod.JScriptClick(driver,SelectFilterDestination,90);
                HelpersMethod.EnterText(driver,FilterText,70,Destination);

                exists = true;
            }
            //Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickFilterbyStartDate(int Start_Date_Val)
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@class='i-filter-tag__clear']",driver))
            {
                HelpersMethod.JScriptClick(driver, ClearFilter, 90);
                exists = true;
            }

            if(HelpersMethod.IsExists("//*[@class='i-filter-tag i-filter-tag--add']/button",driver))
            {
                HelpersMethod.JScriptClick(driver, AddFilter, 90);
                HelpersMethod.JScriptClick(driver,SelectFilterStartDate,90);
                //HelpersMethod.EnterText(driver,FilterText,70,Destination);
                try
                {

                    ClickFilterStartDateCalender();
                    HelpersMethod.Implicitwait(driver,90);
                    SelectStartDate(Start_Date_Val);

                }
                catch (Exception e){}
                exists = true;
            }
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickFilterbyEndDate(int End_Date_Val)
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@class='i-filter-tag__clear']",driver))
            {
                HelpersMethod.JScriptClick(driver, ClearFilter, 90);
                exists = true;
            }

            if(HelpersMethod.IsExists("//*[@class='i-filter-tag i-filter-tag--add']/button",driver))
            {
                HelpersMethod.JScriptClick(driver, AddFilter, 90);
                HelpersMethod.JScriptClick(driver,SelectFilterEndDate,90);
                //HelpersMethod.EnterText(driver,FilterText,70,Destination);
                try
                {
                    ClickFilterEndDateCalender();
                    HelpersMethod.Implicitwait(driver,200);
                    SelectEndDate(End_Date_Val);
                }
                catch (Exception e){}
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnApplyFilter()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@class='k-button k-primary k-button-icontext i-filter-popup__footer__button']",driver))
            {
                HelpersMethod.JScriptClick(driver, ApplyFilter, 90);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnApplyNotice()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@class='i-filter-tag i-filter-tag--add']/button",driver))
            {
                HelpersMethod.JScriptClick(driver, ApplyNotice, 90);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickPrintNotice()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@class='k-button k-flat k-button-icontext']",driver))
            {
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.JScriptClick(driver, AddPrint, 90);
                exists = true;
                driver.switchTo().window(driver.getWindowHandle());
                scenario.log(".pdf HAS BEEN FOUND");
                driver.close();
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);
    }


    public void ClickOnAddNotice()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@id='AddBtn']",driver))
            {
                HelpersMethod.JScriptClick(driver, AddNotice, 90);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnAddRecipient()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
        }
        try
        {
            if(HelpersMethod.IsExists("//*[@id='AddBtn']",driver))
            {
                HelpersMethod.JScriptClick(driver, AddNotice, 90);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnRouteRecipient()
    {
        exists=false;
        WebElement WebEle;

        try
        {
                HelpersMethod.JScriptClick(driver, RouteNoticeTab, 90);
                exists = true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnbranchRecipient()
    {
        exists=false;
        WebElement WebEle;

        try
        {
            HelpersMethod.JScriptClick(driver, BranchNoticeTab, 90);
            exists = true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void ClickOnChainRecipient()
    {
        exists=false;
        WebElement WebEle;

        try
        {
            HelpersMethod.JScriptClick(driver, ChainNoticeTab, 90);
            exists = true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);

    }

    public void RouteFirstCheckBox()
    {
        exists=false;
        WebElement WebEle;
        HelpersMethod.Implicitwait(driver,20);
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]");
            HelpersMethod.ClickBut(driver,WebEle,10);
        }
        catch (Exception e){}
    }

    public void RouteAddButton()
    {
        exists=false;
        WebElement WebEle;
        HelpersMethod.Implicitwait(driver,20);
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"id","ModalButton1");
            HelpersMethod.ClickBut(driver,WebEle,10);
        }
        catch (Exception e){}
    }

    public void CreateNoticeButton()
    {
        exists=false;
        WebElement WebEle;
        HelpersMethod.Implicitwait(driver,20);
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-card__card__body')]//div[@class='create-button']/button");
            HelpersMethod.ClickBut(driver,WebEle,10);
        }
        catch (Exception e){}
    }

    public void ClickOkPopUp()
    {
        exists=false;
        WebElement WebEle;
        HelpersMethod.Implicitwait(driver,20);
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"id","QuestionModalButton0");
            HelpersMethod.ClickBut(driver,WebEle,10);
        }
        catch (Exception e){}
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
            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.visibilityOf(WebEleDate2));
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
    public void SelectDestination_notice()
    {
//        exists=false;
//        try
//        {
////            if(HelpersMethod.IsExists("(//div[contains(@class,'i-card__card__body i-card__card__body')])[1]",driver))
////            {
//                HelpersMethod.WebElementFromDropDown(driver,"(//div[contains(@class,'i-card')])[1]/descendant:li","xpath","Order Entry");
//                exists=true;
//                scenario.log("Destination OPTION HAS BEEN SELECTED FROM Destination DROP DOWN");
////            }
//            Assert.assertEquals(exists,true);
//        }
        WebElement WebEle;
        exists=false;
        Actions act=new Actions(driver);
        HelpersMethod.Implicitwait(driver,4000);
        String Destination = null;
        try {
            HelpersMethod.JScriptClick(driver, destinationListDropdown, 1000);
            WebEle = HelpersMethod.FindByElement(driver,"id","DropdownList1");
//            Select dropdown = new Select(WebEle);
//            dropdown.selectByValue("Order Entry");
            act.moveToElement(WebEle).build().perform();
            //act.moveToElement(WebEle).click().build().perform();
            //act.click("Order Entry").build().perform();
            //act.sendKeys(WebEle,"Order Entry").build().perform();
            act.sendKeys(WebEle,"Order Entry").build().perform();
            act.keyDown(Keys.chord(Keys.DOWN,Keys.DOWN)).build().perform();
            //HelpersMethod.JSSetValueEle(driver,WebEle,200,"Order Entry");
           // Actions KeyDown = new Actions(driver);
//            KeyDown.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN,Keys.ENTER)).perform();
        }
        catch (Exception e){}
    }

    public void SelectCatalogFromDropdown() {
        WebElement WebEle = null;
        exists = false;
        try {
            HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li", "xpath", "Order Entry");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }
    public void SelectDestination()
    {
        WebElement WebEle;
        exists=false;
        Actions act=new Actions(driver);
        HelpersMethod.Implicitwait(driver,4000);
        String Destination = null;
        try
        {
             HelpersMethod.JScriptClick(driver,destinationListDropdown,50);
//             HelpersMethod.sendKeys(driver,destinationDropdown,100,"Order Entry");
            Destination ="Handheld";
            //List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
            for(WebElement Val: Values)
            {
                act.moveToElement(Val).build().perform();
                String Val_Text = Val.getText();
                HelpersMethod.Implicitwait(driver,40);
                if (Val_Text.equalsIgnoreCase(Destination) || Val_Text.contains(Destination))
                {
                    HelpersMethod.JScriptClick(driver,Val,200);
                    HelpersMethod.Implicitwait(driver,40);
                    break;
                }
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='DropdownList1']/span[1]");
            scenario.log("Destination SELECTED IS "+WebEle.getText());
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnStartDateCalender()
    {
       exists=false;
        WebElement WebEle1=null;
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(8000));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add Standing PO')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
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
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add Standing PO')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
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
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add Standing PO')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
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
        WebElement WebEle;
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(8000));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add Standing PO')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
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
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists,true);
            HelpersMethod.Implicitwait(driver,60);
        }
        catch (Exception e){}
    }

    //Selecting Start date
    public void SelectStartDate(int i)
    {
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",100);
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        try
        {
            String formattedDate1 = null;
            WebElement WebEle;
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
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        WebElement WebEle;
        String FTDate=null;
        exists=false;
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",60);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
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

