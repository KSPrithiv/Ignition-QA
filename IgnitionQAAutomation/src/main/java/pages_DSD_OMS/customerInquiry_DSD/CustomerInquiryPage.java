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
        HelpersMethod.Implicitwait(driver,10);
        driver.navigate().refresh();
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
            //HelpersMethod.JSSetValueEle(driver,bill_Input,10,Bill);
            act.moveToElement(bill_Input).click().build().perform();
            HelpersMethod.EnterText(driver,bill_Input,10,Bill);
            BillVal=HelpersMethod.JSGetValueEle(driver,bill_Input,10);
            if(Bill.equals(BillVal))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
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
            //HelpersMethod.JSSetValueEle(driver,store_Input,10,Store);
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
            //HelpersMethod.JSSetValueEle(driver,dept_Input,10,Dept);
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
            //HelpersMethod.JSSetValueEle(driver,description_Input,10,Desc);
            act.moveToElement(description_Input).click().build().perform();
            HelpersMethod.EnterText(driver,description_Input,10,Desc);
            scenario.log("DESCRIPTION ENTERED IS "+Desc);
            DescVal=HelpersMethod.JSGetValueEle(driver,description_Input,10);

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
            HelpersMethod.ActClick(driver,new_But,10);
            exists=true;
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
            if(save_But.isDisplayed() && save_But.isEnabled())
            {
                HelpersMethod.ActClick(driver, save_But, 10);
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Note_Click()
    {
        exists=false;
        WebElement WebEle=null;
        WebElement note_But=HelpersMethod.FindByElement(driver,"xpath","//button[text()='New']");
        try
        {
            HelpersMethod.ActClick(driver,note_But,10);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Validate_Customer_Note()
    {
        exists=false;

        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }

    //Enter customer note in customer note popup in notetext area
    public void Add_Customer_Note(String Note)
    {
        exists=false;
        try
        {
            WebElement NoteArea=HelpersMethod.FindByElement(driver,"id","noteTextbox");
            HelpersMethod.ActSendKey(driver,NoteArea,10,Note);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Alert type in customer note
    public void Select_AlertType_Location(String AltertType,String Altertloc1,String Alertloc2)
    {
        try
        {
            WebElement WebEle=null;
            //Finding Customer notes popup
            if(HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Click on AlertType dorp down, and select Alerttype
                WebEle=HelpersMethod.FindByElement(driver,"id","AlertType");
                HelpersMethod.ClickBut(driver,WebEle,10);
                HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-list-container ')]/descendant::li","xpath",AltertType);

                //Click on Alert location check boxes
                java.util.List<WebElement> AlertLocations=driver.findElements(By.xpath("//input[@class='k-checkbox']/following-sibling::label"));
                int i=0;
                for(WebElement AlertLoc:AlertLocations)
                {
                    i++;
                    String AlertLoc_Text=AlertLoc.getText();
                    if(AlertLoc_Text.equals(Altertloc1) || AlertLoc_Text.equals(Alertloc2))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'col-md-3 col-xs-12')]["+i+"]/descendant::input");
                        HelpersMethod.JScriptClick(driver,WebEle,10);
                    }
                }
            }
        }
        catch (Exception e){}
    }

    //Save and Ok button handling in customer note popup
    public void Save_Note_Button()
    {
        exists=false;
        WebElement Save_Note=null;
        WebElement WebEle=null;
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            Save_Note= HelpersMethod.FindByElement(driver,"id","SaveButton");
            HelpersMethod.ScrollElement(driver,Save_Note);
            HelpersMethod.ActClick(driver,Save_Note,10);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.Implicitwait(driver,40);
            Ok_Note_Button();
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Ok_Note_Button()
    {
        HelpersMethod.Implicitwait(driver,20);
        exists=false;
        WebElement Note_Ok=null;
        try
        {
            Note_Ok=HelpersMethod.FindByElement(driver,"id","CustomerCommentDialogOK");
            HelpersMethod.ActClick(driver,Note_Ok,2);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
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
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
         /*   if(DescVal.equals(Desc))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);*/
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
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmCustNo");
                HelpersMethod.EnterText(driver,WebEle,10,InputVal);
                scenario.log("BILL TO NUMBER IS "+InputVal);

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmStorNo");
                HelpersMethod.EnterText(driver,WebEle,10,InputVal);
                scenario.log("STORE NUMBER IS "+InputVal);

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmDeptNo");
                HelpersMethod.EnterText(driver,WebEle,10,InputVal);
                scenario.log("DEPARTMENT NUMBER IS "+InputVal);

                InputVal=RandomValues.generateRandomString(10);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmFullName");
                HelpersMethod.EnterText(driver,WebEle,10,InputVal);
                scenario.log("CUSTOMER NAME IS "+InputVal);

                InputVal=RandomValues.generateRandomNumber(6);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmOrigCustNo");
                HelpersMethod.EnterText(driver,WebEle,10,InputVal);
                scenario.log("ORIGINAL CUSTOMER NUMBER IS "+InputVal);

                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Copy customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Copy']");
                HelpersMethod.ClickBut(driver,WebEle,10);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }

                if(HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The information has been saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,40);
                }
            }
        }
        catch (Exception e){}
    }

}

