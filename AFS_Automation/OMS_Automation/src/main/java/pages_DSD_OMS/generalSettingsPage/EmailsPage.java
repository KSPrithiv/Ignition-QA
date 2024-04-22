package pages_DSD_OMS.generalSettingsPage;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
public class EmailsPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String currentURL=null;
    static String InputValue=null;

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

    @FindBy(id="QuestionModalButton0")
    private WebElement okButton;

    @FindBy(xpath="//button[@class='tox-tbtn tox-tbtn--select']")
    private WebElement resetButton;

    @FindBy(id="CopyPermsYesBtn")
    private WebElement yesButton;

    @FindBy(id="restoreCustomBtn")
    private WebElement customDeleteButton;


    @FindBy(id= "SendBtn")
    private WebElement SendemailButton;

    @FindBy(id="cancel-btn")
    private WebElement CancelButton;

    //Action
    public EmailsPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }



    public void NavigateToEmails()
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
            EnterValueInSearchBox("Emails");
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menuWrapper__accesscpadmingeneralsettings']//div[@class='submenu-item-text']")));
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
                HelpersMethod.ActClick(driver, PermissionBy, 600);
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

    public void SelectUser_PermissionBy()
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String user_PermissionBy=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]",driver))
            {
                //Click on User drop down
                WebEle= HelpersMethod.FindByElement(driver,"id","dropdownList2");
                HelpersMethod.ClickBut(driver,WebEle,50);
                HelpersMethod.Implicitwait(driver,90);
                Thread.sleep(10);
                //Create list of web elements in dropdown
                user_PermissionBy="User Role";
                System.out.println(user_PermissionBy);
                List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
                for(WebElement Val: Values)
                {
                    act.moveToElement(Val).build().perform();
                    String Val_Text = Val.getText();
                    HelpersMethod.Implicitwait(driver,90);
                    if (Val_Text.equalsIgnoreCase(user_PermissionBy) || Val_Text.contains(user_PermissionBy))
                    {
                        act.click(Val).build().perform();
                        HelpersMethod.Implicitwait(driver,40);
                        break;
                    }
                }
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='dropdownList2']/span[1]");
                scenario.log("SELECTED IS "+WebEle.getText());
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
            }
        }
        catch (Exception e){}
    }

    public void SelectUserRole()
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String user=null;
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
                user="regular user";
                System.out.println(user);
                List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
                for(WebElement Val: Values)
                {
                    act.moveToElement(Val).build().perform();
                    String Val_Text = Val.getText();
                    HelpersMethod.Implicitwait(driver,40);
                    if (Val_Text.equalsIgnoreCase(user) || Val_Text.contains(user))
                    {
                        act.click(Val).build().perform();
                        HelpersMethod.Implicitwait(driver,40);
                        break;
                    }
                }
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='dropdownList3']/span[1]");
                scenario.log("user SELECTED IS "+WebEle.getText());
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

    public void clickemailtemplates()
    {
        WebElement emailTemplate;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='k-tabstrip-items-wrapper k-hstack']/ul/li[4]/span",driver))
            {
                emailTemplate = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-tabstrip-items-wrapper k-hstack']/ul/li[4]/span");
                HelpersMethod.JScriptClick(driver, emailTemplate, 20);
            }
        }
        catch (Exception e){}
    }

    public void RegularUser_clickemailtemplates()
    {
        WebElement emailTemplate;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='k-tabstrip-items-wrapper k-hstack']/ul/li[3]/span",driver))
            {
                emailTemplate = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-tabstrip-items-wrapper k-hstack']/ul/li[3]/span");
                HelpersMethod.JScriptClick(driver, emailTemplate, 20);
            }
        }
        catch (Exception e){}
    }

    public void disablePasswordRequest()
    {
        WebElement PasswordRequest;
        try
        {
            if(HelpersMethod.IsExists("//*[@id='PasswordRequest']",driver))
            {
                PasswordRequest = HelpersMethod.FindByElement(driver, "xpath", "//*[@id='PasswordRequest']");
                HelpersMethod.JScriptClick(driver, PasswordRequest, 20);
            }
        }
        catch (Exception e){}
    }

    public void enablePendingRegistrationApproval()
    {
        WebElement emailRegApproval;
        try
        {
            if(HelpersMethod.IsExists("//*[@id='RegistrationApproved']",driver))
            {
                emailRegApproval = HelpersMethod.FindByElement(driver, "xpath", "//*[@id='RegistrationApproved']");
                HelpersMethod.JScriptClick(driver, emailRegApproval, 20);
            }
        }
        catch (Exception e){}
    }

    public void emailTemplateCheck()
    {
        WebElement emailTemplatePwdReq;
        WebElement NextArrowbutton;

        try
        {
            if(HelpersMethod.IsExists("//*[@class='k-button k-button-icontext button-left i-button--icon-only']",driver))
            {
                NextArrowbutton = HelpersMethod.FindByElement(driver, "xpath", "//*[@class='k-button k-button-icontext button-left i-button--icon-only']");
                HelpersMethod.JScriptClick(driver, NextArrowbutton, 20);
            }

            if(HelpersMethod.IsExists("//div[@class='k-tabstrip-items-wrapper k-hstack']/ul/li[5]/span",driver))
            {
                emailTemplatePwdReq = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-tabstrip-items-wrapper k-hstack']/ul/li[5]/span");
                HelpersMethod.JScriptClick(driver, emailTemplatePwdReq, 20);
            }

        }
        catch (Exception e){}
    }

    public void Default_DeleteCustomemail_Check()
    {
        exists=false;
        WebElement DefaultEmail;
        WebElement DeleteCustomemail;
        try
        {
            DefaultEmail = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='k-icon k-chip-icon k-i-track-changes']");
            if (HelpersMethod.EleDisplay(DefaultEmail))
            {
                scenario.log("Default Email  is enabled");
                exists = true;
                Assert.assertEquals(exists,true);
            }
            else
            {
                scenario.log("DefaultEmail  is disabled");
                Assert.assertEquals(exists,false);

            }
              DeleteCustomemail = HelpersMethod.FindByElement(driver, "xpath", "//*[@class='k-button k-primary k-button-icontext']");
            //System.out.println(HelpersMethod.EleDisplay(DeleteCustomemail));
            if (HelpersMethod.EleDisplay(DeleteCustomemail))
            {
                scenario.log("DeleteCustom email  is enabled");
                exists = true;
                Assert.assertEquals(exists,true);

            }
            else
            {
                scenario.log("DeleteCustom email  is disabled");
                //exists = true;
                Assert.assertEquals(exists,false);

            }
        }
        catch (Exception e){}
    }

    public void EnterEmailBody()
    {
        exists=false;
        WebElement EmailBody1;
        WebElement EmailBody2;
        try
        {
//            InputValue=RandomValues.generateRandomAlphaNumeric(5)+"@gmail.com";
            driver.switchTo().frame(0);
            EmailBody1=HelpersMethod.FindByElement(driver,"xpath","//body[@id='tinymce']");
            HelpersMethod.clickOn(driver,EmailBody1,50);
            ////*[@id='EmailBodyAdminCard']//div[@class='tox-edit-area']//iframe
            EmailBody2=HelpersMethod.FindByElement(driver,"xpath","//body[@id='tinymce']/div/p");
            HelpersMethod.sendKeys(driver,EmailBody2,50,"Automation");
            //PoNo=InputValue;
            exists=true;
            Assert.assertEquals(exists,true);
            driver.switchTo().defaultContent();
        }
        catch (Exception e){}
    }

    public void SelectEmailTemplateFromDropDown(String EmailTemplate)
    {
        exists=false;
        WebElement WebEmailEle;
        WebElement WebSelectEmailDrpDwn;
        Select EmailDropDown;
        String ArrayText=null;
        int length;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//*[@id='EmailTemplatesAdminCard']",driver))
            {
                //Click on Email Template drop down
                WebSelectEmailDrpDwn= HelpersMethod.FindByElement(driver,"xpath","//*[@id='CPEmailTemplate']/span[2]");
                HelpersMethod.ClickBut(driver,WebSelectEmailDrpDwn,20);
                HelpersMethod.Implicitwait(driver,80);
                Thread.sleep(10);
                List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
                for(WebElement Val: Values)
                {
                    act.moveToElement(Val).build().perform();
                    String Val_Text = Val.getText();
                    HelpersMethod.Implicitwait(driver,40);
                    if (Val_Text.equalsIgnoreCase(EmailTemplate) || Val_Text.contains(EmailTemplate))
                    {
                        act.click(Val).build().perform();
                        HelpersMethod.Implicitwait(driver,40);
                        break;
                    }
                    else {
                        scenario.log("Email Template "+EmailTemplate + "  is NOT displayed");
                    }
                }
                WebEmailEle=HelpersMethod.FindByElement(driver,"xpath","//*[@id='CPEmailTemplate']/span[1]");
                scenario.log("Email Template SELECTED Is "+WebEmailEle.getText());
            }
        }
        catch (Exception e){}
    }

    public void clickTestEmail()
    {
        WebElement TestEmail;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-card__card ']//button[@class='k-button k-button-icontext']",driver))
            {
                TestEmail = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='i-card__card ']//button[@class='k-button k-button-icontext']");
                HelpersMethod.clickOn(driver, TestEmail, 90);
            }
        }
        catch (Exception e){}
    }

    public void EnterToEmail()
        {
            exists=false;
            WebElement ToEmail;
            try
            {
                ToEmail=HelpersMethod.FindByElement(driver,"xpath","//*[@id='CPTestEmailAddress']");
                InputValue=RandomValues.generateRandomAlphaNumeric(5)+"@gmail.com";
                HelpersMethod.EnterText(driver,ToEmail,10,InputValue);
                //PoNo=InputValue;
                exists=true;
                Assert.assertEquals(exists,true);
            }
            catch (Exception e){}
        }

    public void EnterSubject()
    {
        exists=false;
        WebElement Subject;
        try
        {
            Subject=HelpersMethod.FindByElement(driver,"xpath","//*[@id='CPTestEmailSubject']");
            InputValue=RandomValues.generateRandomAlphaNumeric(5);
            HelpersMethod.EnterText(driver,Subject,10,InputValue);
            //PoNo=InputValue;
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterBody()
    {
        exists=false;
        WebElement EmailBody;
        try
        {
            EmailBody=HelpersMethod.FindByElement(driver,"xpath","//*[@id='CPTestEmailBody']");
            InputValue=RandomValues.generateRandomAlphaNumeric(5);
            HelpersMethod.EnterText(driver,EmailBody,10,InputValue);
            //PoNo=InputValue;
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }


    public void clickSendEmail()
    {
        exists=false;
        try
        {
            if(SendemailButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,SendemailButton,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
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
                HelpersMethod.ActClick(driver,SaveButton,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on Save button
    public void Click_okButton()
    {
        exists=false;
        try
        {
            if(okButton.isDisplayed())
            {
                HelpersMethod.ActClick(driver,okButton,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on reset button
    public void Click_resetButton()
    {
        exists=false;
        try
        {
            if(resetButton.isDisplayed())
            {
                HelpersMethod.ActClick(driver,resetButton,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }


    //Click on delete_custom email
    public void Click_delete_custom_email()
    {
        exists=false;
        try
        {
            if(customDeleteButton.isDisplayed())
            {
                HelpersMethod.ActClick(driver,customDeleteButton,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_Yesbutton_newPopUp()
    {
        exists=false;
        try
        {
            if(yesButton.isDisplayed())
            {
                HelpersMethod.ActClick(driver,yesButton,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
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
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        WebElement WebEle=null;
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

