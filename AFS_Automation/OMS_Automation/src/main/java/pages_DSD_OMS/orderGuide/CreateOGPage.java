package pages_DSD_OMS.orderGuide;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.DataBaseConnection;
import util.TestBase;

import java.io.File;
import java.io.FileFilter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CreateOGPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;
    static String DOfWeek=null;
    static String ExportOG=null;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::input")
    private WebElement OG_Des;

    @FindBy(id = "quickProduct")
    private WebElement QuickProd;

    @FindBy(id = "quickSequence")
    private WebElement Sequence;

    @FindBy(xpath = "//button[contains(text(),'Add product')]")
    private WebElement AddProd;

    @FindBy(id = "buttonDelete")
    private WebElement DeleteProd;

    @FindBy(id = "Export")
    private WebElement OGExport;

    @FindBy(xpath = "//label[text()='Import']")
    private WebElement OGImport;

    @FindBy(xpath = "//div[@class='i-search-box']/descendant::input")
    private WebElement Searchbox;

    @FindBy(xpath = "//div[@class='i-search-box']//*[local-name()='svg']/*[local-name()='path' and contains(@d,'M15.5')]")
    private WebElement SearchIndex;

    @FindBy(xpath = "//button/descendant::span[contains(text(),'Add filter')]")
    private WebElement Addfilter;

    @FindBy(id = "checkBoxD")
    private WebElement AllCustCheckbox;

    @FindBy(xpath = "//label[contains(text(),'Day of week')]/following-sibling::span[contains(@class,'k-widget k-dropdown')]/span")
    private WebElement DayOfWeek;

    @FindBy(xpath = "//label[contains(text(),'Status')]/following-sibling::span[contains(@class,'k-widget k-dropdown')]/span")
    private WebElement Status;

    @FindBy(xpath = "//label[text()='Type']/following-sibling::span/span[@class='k-dropdown-wrap']")
    private WebElement Type;

    @FindBy(xpath = "//label[contains(text(),'Valid to')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]")
    private WebElement ValidTo;

    @FindBy(xpath = "//label[contains(text(),'Valid from')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]")
    private WebElement ValidFrom;

    @FindBy(id = "OGSaveButton")
    private WebElement OGSave;

    @FindBy(id = "OGCancelButton")
    private WebElement OGCancel;

    @FindBy(xpath="//button[text()='More']")
    private WebElement More;

    @FindBy(xpath = "//div[@id='card1']/descendant::button[text()='Delete']")
    private WebElement OG_Delete;

    @FindBy(xpath="//button[contains(text(),'Print')]")
    private WebElement PrintBut;

    @FindBy(id="checkBoxD")
    private WebElement AllOrderCheckbox;

    public CreateOGPage(WebDriver driver, Scenario scenario)
    {
        this.scenario = scenario;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Code to validate whether user navigated to New OG page or not
    public boolean ValidateNewOG()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            if (HelpersMethod.IsExists("//div[contains(@class,'orderGuides-card')]", driver))
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
        return exists;
    }

    //code to enter values in description page
    public void DescriptionOG(String OGDesc)
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='bottomDetailCard']/descendant::div[contains(text(),'No customers found, order guide cannot be created.')]",driver))
            {
                scenario.log("NO CUSTOMERS HAVE BEEN FOUND, SO WE CAN'T CREATE AN ORDER GUIDE");
                exists=false;
            }
            else
            {
                HelpersMethod.EnterText(driver, OG_Des, 100, OGDesc);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }
    //Code to click on Start date calender
    public void CalenderStart()
    {
        try
        {
            HelpersMethod.ScrollElement(driver,ValidFrom);
            HelpersMethod.ActClick(driver,ValidFrom, 20);
        }
        catch (Exception e) {}
    }

    //Code to click on End date calender
    public void CalenderEnd()
    {
        try
        {
            HelpersMethod.ScrollElement(driver,ValidTo);
            HelpersMethod.ActClick(driver,ValidTo, 20);
        }
        catch (Exception e) {}
    }

    //Selecting Start date
    public void SelectStartDate(String ChangeDate,int i)
    {
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",6);
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                LocalDate myDateObj = LocalDate.now().plusDays(i);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.JSScroll(driver,ele1);
                HelpersMethod.ActClick(driver, ele1, 20);
                scenario.log(formattedDate1 + " HAS BEEN SELECTED AS START DATE FOR OG");
            }
            else
            {
                scenario.log("CALENDER DROP DOWN DOESN'T EXISTS");
            }
        }
        catch (Exception e) {}
    }

    //selecting end date
    public void SelectEndDate(String ChangeDate, int i)
    {
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",6);
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            String ele = "//div[contains(@class,'k-calendar-monthview')]";
            boolean visible = HelpersMethod.IsExists(ele, driver);
            if (visible == true)
            {
                LocalDate myDateObj = LocalDate.now().plusDays(i);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.JSScroll(driver,ele1);
                HelpersMethod.ActClick(driver,ele1, 10);
                scenario.log(formattedDate1 + " HAS BEEN SELECTED AS END DATE FOR OG");
                DateTimeFormatter myFormatObjDay = DateTimeFormatter.ofPattern("EEEE");
                DOfWeek=  myDateObj.format(myFormatObjDay);
            }
            else
            {
                scenario.log("CALENDER DROP DOWN DOESN'T EXISTS");
            }
        }
        catch (Exception e) {}
    }

    //Code to Set the Valid To date as past date
    public void ValidToDatePast()
    {
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",200);
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container')]",driver))
            {
                LocalDate myDateObj = LocalDate.now().minusDays(2);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.JSScroll(driver,ele1);
                HelpersMethod.ActClick(driver,ele1, 800);
                scenario.log(formattedDate1 + " HAS BEEN SELECTED AS END DATE FOR OG");
            }
            else
            {
                scenario.log("CALENDER DROP DOWN DOESN'T EXISTS");
            }
        }
        catch (Exception e){}
    }

    //code for entereing Product# in Quick product input box, and sequence number
    public void EnterQuickProduct(String Product, String ProSeq)
    {
        exists=false;
        try
        {
            WebElement WebEle=null;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 60000);
            }
            HelpersMethod.ScrollElement(driver,QuickProd);
            HelpersMethod.ClearText(driver,QuickProd,4000);
            HelpersMethod.EnterText(driver, QuickProd,4000,Product);
            QuickProd.sendKeys(Keys.TAB);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            HelpersMethod.ClearText(driver,Sequence,1000);
            HelpersMethod.EnterText(driver, Sequence, 1000,ProSeq);
            Sequence.sendKeys(Keys.TAB);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }

            if(!HelpersMethod.IsExists("//div[contains(text(),'no matching products')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                scenario.log("PRODUCT# ENTERED IS "+Product+" SEQUENCE# ENTERED IS "+ProSeq);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
                exists=true;
            }
            else
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Ok')]");
                HelpersMethod.ClickBut(driver,WebEle,1000);
                scenario.log("NO MATCHING PRODUCTS HAS BEEN FOUND, CHECK FOR THE AVAILABILITY OF OG TYPE YOU SELECTED");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Code to click on Save button
    public void ClickOnSave()
    {
        exists=false;
        try {
               WebElement WebEle=null;
            //Click on Save button
            HelpersMethod.ClickBut(driver,OGSave,40000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
        }
        catch (Exception e) {}
    }

    public void OGDetailValidate()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@id='card1']/descendant::span[contains(text(),'Detail order guide')]",1000);
            if (HelpersMethod.IsExists("//div[@id='card1']/descendant::span[contains(text(),'Detail order guide')]", driver))
            {
                scenario.log("NAVIGATED TO OG DETAILS PAGE");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //code to search product in OG
    public boolean SearchProd(String ProdNo) throws InterruptedException
    {
        exists = false;
        try
        {
            HelpersMethod.ScrollElement(driver,Searchbox);
            HelpersMethod.ActSendKey(driver, Searchbox,1000,ProdNo);
            HelpersMethod.ActClick(driver,SearchIndex,1000);
            scenario.log("PRODUCT# ENTERED FOR SEARCH IS "+ProdNo);

            if (HelpersMethod.IsExists("//button[@class='i-link-button ']/ancestor::tr[contains(@class,'k-master-row k-grid-edit-row')]",driver))
            {
                exists = true;
            }
        }
        catch (Exception e){}
        return exists;
    }

    //Code to click on Delete button
    public void DeleteProd()
    {
        exists=false;
        try
        {
            WebElement Checkbox=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[1]");
            WebElement Button_Ele=null;
            HelpersMethod.ClickBut(driver,Checkbox,100);
            if(DeleteProd.isEnabled())
            {
                HelpersMethod.ClickBut(driver,DeleteProd,100);
                Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                if(HelpersMethod.EleDisplay(Button_Ele))
                {
                    Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,Button_Ele,100);
                    exists=true;
                }
                WebElement clearSearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__clear')]");
                HelpersMethod.ActClick(driver,clearSearchBox,200);
                scenario.log("PRODUCT HAS BEEN REMOVED FROM OG");
            }
            else
            {
                scenario.log("DELETE BUTTON IS NOT ENABLED,CHECK FOR THE REASON");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //code to click on more button
    public boolean More_Button()
    {
        exists=false;
        try
        {
            if(HelpersMethod.EleDisplay(More))
            {
                exists=true;
                HelpersMethod.ScrollElement(driver,More);
                HelpersMethod.ActClick(driver,More,10);
            }
            else
            {
                scenario.log("MORE BUTTON IS NOT DISPLAYED");
            }
        }
        catch (Exception e){}
        return exists;
    }

    //code to select Sequence clear option from drop down
    public boolean SequenceClear()
    {
        exists=false;
        Actions act=new Actions(driver);
        new WebDriverWait(driver,80).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::ul/li")));
        try
        {
            List<WebElement> MoreOptions=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container')]/descendant::ul/li");
            for(WebElement MoreOpt:MoreOptions)
            {
                String More_Text=MoreOpt.getText();
                if(More_Text.equalsIgnoreCase("Clear sequence"))
                {
                    act.moveToElement(MoreOpt).build().perform();
                    act.click(MoreOpt).build().perform();
                    scenario.log("CLEAR SEQUENCE OPTION IS SELECTED FROM DROP DOWN");
                    exists=true;
                    break;
                }
            }
        }
        catch (Exception e){}
        return exists;
    }

    //Code to select No option in Clear popup
    public void SequencePopupNo()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Clear']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='No']");
                HelpersMethod.ClickBut(driver,WebEle,20);
                exists=true;
                scenario.log("NO, OPTION IS SELECTED FROM POPUP");
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    //Code to select Yes option in Clear popup
    public void SequencePopupYes()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Clear']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']"),1);
                scenario.log("YES, OPTION IS SELECTED FROM POPUP");
            }
        }
        catch (Exception e){}
    }

    //Code to Edit sequence number in Product grid of OG
    public boolean EditSequence(String SeqNo)
    {
        exists=false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }

            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='bottomDetailCard']");
            HelpersMethod.ScrollElement(driver,WebEle);
            String Seqno=null;

            if(!HelpersMethod.IsExists("//tr[1]/descendant::span[contains(@class,'k-widget k-numerictextbox')]/descendant::input[@class='k-input k-formatted-value']",driver))
            {
                WebElement Arrow=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-icon k-i-sort')]");
                HelpersMethod.ActClick(driver,Arrow,10);
                HelpersMethod.ActClick(driver,Arrow,10);
            }
            WebElement SeqInput= HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::span[contains(@class,'k-widget k-numerictextbox')]/descendant::input[@class='k-input k-formatted-value']");
            Seqno=HelpersMethod.AttributeValue(SeqInput,"value");
            scenario.log("SEQUENCE NO. BEFORE EDITING "+Seqno);
            HelpersMethod.JSSetValueEle(driver,SeqInput,20,SeqNo);
            exists=true;
            // Seqno=HelpersMethod.AttributeValue(SeqInput,"value");
            scenario.log("SEQUENCE NO. IS CHANGED TO "+SeqNo);
        }
        catch(Exception e){}
        return  exists;
    }

    //Code for Clicking Add product button in new OG page
    public void ClickOnAddProduct()
    {
        try
        {
            HelpersMethod.ScrollElement(driver,AddProd);
            HelpersMethod.ClickBut(driver,AddProd,10);
        }
        catch (Exception e){}
    }

    //Code for Selecting value from drop down that appears after clicking Add product button
    public void SelectValueFromAddProduct(String AddFrom)
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::ul/li",40);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::ul/li",driver))
            {
                HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-child-animation-container')]/descendant::ul/li","xpath",AddFrom);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateCatalogPopup()
    {
        exists=true;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            else
            {
                scenario.log("CATALOG DOESN'T EXISTS");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectProductCatalog()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }

            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='productFilterResetBtn']");
                    HelpersMethod.ClickBut(driver,WebEle,1000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@id,'gridItemBox')][1]/descendant::button");
                    HelpersMethod.ActClick(driver, WebEle, 100);
                }
                else if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-grid']/descendant::table[@class='k-grid-table']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::table[@class='k-grid-table']/descendant::tr[1]");
                    HelpersMethod.ActClick(driver,WebEle,10000);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CatalogPopupOk()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
            HelpersMethod.ActClick(driver,WebEle,100);
        }
        catch (Exception e){}
    }

    public void ValidateOGPopup()
    {
        exists=false;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Select order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            else
            {
                exists=false;
                scenario.log("CATALOG POPUP IS NOT DISPLAYED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code for selecting OG from Order guide popup
    public void OrderGuidePopup(String OGSearch)
    {
        try
        {
            exists=false;
            WebElement WebEle;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Select order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",10);
            if(HelpersMethod.IsExists("//div[contains(text(),'Select order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Search for OG in popup
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[contains(@id,'SearchBox')]");
                HelpersMethod.EnterText(driver,WebEle,80,OGSearch);
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
                HelpersMethod.ActClick(driver,WebEle,80);
                //Click on OG
                WebElement OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/descendant::input[@class='k-checkbox']");
                HelpersMethod.ActClick(driver,OrderSel,80);
                OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,OrderSel,80);

                //Handle popup if products,in OG are not available currently
                if(HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,40);
                }
                exists=true;
            }
            else
            {
                scenario.log("ORDER GUIDE HAS NOT BEEN CREATED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code for handling "Catalog" popup and adding products to OG using catalog
  /*  public void CatalogPopup()
    {
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
        }
        try
        {
            WebElement Prod=null;
            WebElement OkBut=null;
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-grid']",driver))
            {
                Prod=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                OkBut=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
               HelpersMethod.ScrollElement(driver,Prod);
               HelpersMethod.ActClick(driver,Prod,40);
               HelpersMethod.ScrollElement(driver,OkBut);
                HelpersMethod.ActClick(driver,OkBut,40);
            }
            else //if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='card-view']",driver))
            {
                WebElement ResetFilter= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@data-test-id,'productFilterResetBtn')]");
                HelpersMethod.ActClick(driver,ResetFilter,40);
                Prod=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Select'][1]");
                OkBut=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ScrollElement(driver,Prod);
                HelpersMethod.ActClick(driver,Prod,40);
                HelpersMethod.ScrollElement(driver,OkBut);
                HelpersMethod.ActClick(driver,OkBut,40);
            }
        }
        catch (Exception e){}
    }*/

    //Code for handling Order popup
    public void OrderPopup()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Select orders')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",100);
            if(HelpersMethod.IsExists("//div[contains(text(),'Select orders')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //To select order from order popup, here i am selecting 2nd order in order popup
                WebElement OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@class,'list-group-item')][2]");
                HelpersMethod.ScrollElement(driver,OrderSel);
                HelpersMethod.ActClick(driver,OrderSel,200);
                //to read the order number selected in order popup
                String Order_No=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@class,'list-group-item')][2]/div[1]").getText();
                scenario.log("ORDER SELECTED FROM ORDER POPUP IS "+Order_No);

                //to click on OK button in order popup
                OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ScrollElement(driver,OrderSel);
                HelpersMethod.ClickBut(driver,OrderSel,200);

                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
                }

            }
            else
            {
                scenario.log("NO ORDER HAS BEEN SELECTED YET");
            }
        }
        catch (Exception e){}
    }

    //Code for Delete OG
    public void Click_Delete()
    {
        try
        {
            HelpersMethod.ScrollElement(driver,OG_Delete);
            HelpersMethod.ActClick(driver,OG_Delete,20);
        }
        catch (Exception e){}
    }
    //Code for handling Delete popup
    public void DeleteOk_Popup()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'delete this order guide ?')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",6);
            if(HelpersMethod.IsExists("//div[contains(text(),'delete this order guide ?')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement DeleteOk=HelpersMethod.FindByElement(driver,"xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,DeleteOk,20);
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Order guides deleted')]/ancestor::div[@class='k-widget k-window k-dialog']",2);
                if(HelpersMethod.IsExists("//div[contains(text(),'Order guides deleted')]/ancestor::div[@class='k-widget k-window k-dialog']",driver))
                {
                    DeleteOk=HelpersMethod.FindByElement(driver,"xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,DeleteOk,20);
                }
            }
        }
        catch (Exception e){}
    }

    //Code for cancel the delete
    public void DeleteCancel_Popup()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'delete this order guide ?')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement DeleteCancel=HelpersMethod.FindByElement(driver,"xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Cancel']");
                HelpersMethod.ClickBut(driver,DeleteCancel,20);
            }
        }
        catch (Exception e){}
    }

    //code for clicking Export button
    public void Click_Export()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
        }
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='bottomDetailCard']");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(OGExport.isDisplayed() && OGExport.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,OGExport);
                HelpersMethod.ActClick(driver,OGExport,10);
                if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("Firefox"))
                {
                    HelpersMethod.FileDownload();
                }
                //if chrome browser has been used it should close the download popup
                if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("Chrome"))
                {
                    HelpersMethod.FileDownloadsuccessPopup(driver);
                }
                exists=true;
                scenario.log("OG FILE HAS BEEN DOWN LOADED");

                //Read all the .csv files in download directory and compare with actual order number
                File dir = new File("C:\\Users\\Divya.Ramadas\\Downloads");
                FileFilter fileFilter = new WildcardFileFilter("*.csv");
                File[] files = dir.listFiles(fileFilter);


                for (File Exportfile:files)
                {
                   String file1 = Exportfile.getName();
                   if(file1.contains("OrderGuide"))
                   {
                       ExportOG=file1;
                       break;
                   }
                }
                scenario.log("ORDER GUIDE EXPORTED IS "+ ExportOG);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) { }
    }

    //Code for clicking Import button
    public void ImportClick()
    {
        exists=false;
        WebElement WebEle;
        String file1=null;
        int i=0;
        try
        {
            if(OGImport.isDisplayed())
            {
                //Read all the .csv files in download directory
                File dir = new File("C:\\Users\\Divya.Ramadas\\Downloads");
                FileFilter fileFilter = new WildcardFileFilter("*.csv");
                File[] files = dir.listFiles(fileFilter);
                for (File fileName:files)
                {
                   i++;
                   file1 = fileName.getName();
                   if(file1.contains("OrderGuide"))
                   {
                       break;
                   }
                }

                if(HelpersMethod.IsExists("//div[contains(text(),'Import failed')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Import failed')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement okButton=popUp.findElement(By.xpath(".//button[text()='Ok']"));
                    HelpersMethod.ActClick(driver,okButton,100);
                }
                else
                {
                    driver.findElement(By.xpath("//input[@id='ImportProducts' and @type='file']")).sendKeys("C:\\Users\\Divya.Ramadas\\Downloads\\" + file1);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void Click_On_Type()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//label[text()='Type']/following-sibling::span/span[@class='k-dropdown-wrap']",driver))
            {
                HelpersMethod.ScrollElement(driver,Type);
                HelpersMethod.ActClick(driver, Type, 1000);
                exists=true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectTypeFromDropDown(String type)
    {
        WebElement WebEle;
        Actions act1=new Actions(driver);
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver,80000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            new WebDriverWait(driver,6000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]"))));
            List<WebElement> Options=driver.findElements(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li"));
            for (WebElement opt:Options)
            {
                act1.moveToElement(opt).build().perform();
                String Opt_Text= opt.getText();
                if (Opt_Text.equals(type))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void ClickOnDayOfWeek()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//label[contains(text(),'Day of week')]/following-sibling::span[contains(@class,'k-widget k-dropdown')]/span",40);
            if (HelpersMethod.IsExists("//label[contains(text(),'Day of week')]/following-sibling::span[contains(@class,'k-widget k-dropdown')]/span",driver))
            {
                HelpersMethod.ActClick(driver,DayOfWeek,20);
            }
            else
            {scenario.log("DAY OF WEEK DROP DOWN IS NOT VISIBLE");}
        }
        catch(Exception e){}
    }

    public String SelectDayOfWeek()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container ')]/descendant::li",8);
            List<WebElement> WeekDays=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container ')]/descendant::li");
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container ')]",driver))
            {
                HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-popup k-child-animation-container ')]/descendant::li","xpath",DOfWeek);
            }
        }
        catch (Exception e){}
        return DOfWeek;
    }

    public String ValidateWeekOfDay()
    {
        String DayWeek=null;
        try
        {
            HelpersMethod.WaitElementPresent(driver,"xpath","//label[contains(text(),'Day of week')]",10);
            WebElement DWeek=HelpersMethod.FindByElement(driver,"xpath","//label[contains(text(),'Day of week')]/following-sibling::span/descendant::span[@class='k-input']");
            DayWeek=DWeek.getText();
        }
        catch (Exception e){}
      return DayWeek;
    }

    //Code to navigate Customer allocation menu
    public void CustomerAllocation()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//span[contains(text(),'Customer allocation')]",8);
            WebElement AlloCust=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Customer allocation')]");
            HelpersMethod.ActClick(driver,AlloCust,20);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to validate Customer Allocation grid
    public boolean ValidateCustomerAllocation()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@class='additional-accounts-grid']",6);
            exists=HelpersMethod.IsExists("//div[@class='additional-accounts-grid']",driver);
        }
        catch (Exception e){}
        return exists;
    }

    //Code to navigate Product tab menu
    public void ProductTab()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//span[contains(text(),'Products')]",100);
            HelpersMethod.navigate_Horizantal_Tab(driver,"Products","//div[contains(@class,'bottomDetailCard')]/descendant::div[contains(@class,'i-tabstrip-wrapper')]/descendant::ul/li/span[text()='Products']","xpath","//div[contains(@class,'bottomDetailCard')]/descendant::div[contains(@class,'i-tabstrip-wrapper')]/descendant::ul/li/span");
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to validate Customer Allocation grid
    public boolean ValidateProductTab()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@class='quickEntry']/following-sibling::div/div[@class='additional-accounts-grid']",6);
            exists=HelpersMethod.IsExists("//div[@class='quickEntry']/following-sibling::div/div[@class='additional-accounts-grid']",driver);
        }
        catch (Exception e){}
        return exists;
    }

    //Code to click on checkBox under customer allocation tab
    public void CheckBoxCustAllocation()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::input",8);
            WebElement CheckBox=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::input");
            HelpersMethod.ClickBut(driver,CheckBox,20);
        }
        catch (Exception e){}
    }

    //Code to click on Delete button to remove customer allocation
    public void ClickOnDelete()
    {
        try
        {
           WebElement DelCust=HelpersMethod.FindByElement(driver,"xpath","//button[@id='buttonDelete']");
           HelpersMethod.ActClick(driver,DelCust,20);
        }
        catch (Exception e){}
    }

    //Code to handle confirmation popup for deleting customer allocation
    public void CustomerAllocationDeletePopup()
    {
        WebElement WebEle=null;
        exists=true;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Remove customer allocation')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to validate customer allowcation has been removed from the grid
    public boolean ValidateDelete()
    {
        exists=false;
        try
        {
            exists=HelpersMethod.IsExists("//table[@class='k-grid-table']/descendant::div[@class='i-no-data']",driver);
        }
        catch(Exception e){}
        return exists;
    }

    //Code to click on '+' button
    public void ClickPlus()
    {
        exists=false;
        try
        {
            WebElement PlusAdd=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='addCustomerAllocationDropDown']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M19')]");
            HelpersMethod.ActClick(driver,PlusAdd,20);
            exists=true;
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-animation-container-shown')]/descendant::ul/li",40);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DropDownAcc(String CustAlloc)
    {
        try
        {
            HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-animation-container-shown')]/descendant::ul/li","xpath",CustAlloc);
        }
        catch (Exception e){}
    }

    //Code to handle popup that appears after Plus button, Enter Account# in search box and select the account#
    public boolean PopupHandle()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Select customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Code to enter Customer allocation, and click on Index
                WebElement SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[@id='SearchBox1']");
                HelpersMethod.EnterText(driver,SearchBox,100,TestBase.testEnvironment.get_AnotherAcc());
                SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
                HelpersMethod.ActClick(driver,SearchBox,100);
                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')] /descendant::tr[@class='k-grid-norecords']",driver))
                {
                    scenario.log("ACCOUNT YOU ARE SEARCHING FOR DOESN'T EXISTS");
                    exists=false;
                }
                else
                {
                    scenario.log("ACCOUNT HAS BEEN FOUND");
                    exists=true;
                }
            }
        }
        catch (Exception e){}
        return exists;
    }

    //Code to select Customer Account
    public void CustomerAccountSelect()
    {
        Actions act1=new Actions(driver);
        try
        {
            WebElement SearchBox=null;
            //Code to select customer allocation from popup
            SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row']/td[2]");
            scenario.log("ACCOUNT NUMBER SELECTED IS "+SearchBox.getText());
            SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::input[@class='k-checkbox']");
            HelpersMethod.ActClick(driver,SearchBox,100);
            SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row']/td[2]");
            scenario.log("ACCOUNT NUMBER SELECTED IS "+SearchBox.getText());
            WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
            HelpersMethod.ClickBut(driver,okButton,1000);
        }
        catch (Exception e){}
    }

    //Code to verify whether account has been selected or not
    public boolean ValidateCustSelect()
    {
        exists=false;
        try
        {
             exists=HelpersMethod.IsExists("//table[@class='k-grid-table']/descendant::tr[@class='k-master-row']",driver);
        }
        catch (Exception e){}
        return  exists;
    }

    //Code to validate catalog display
    public boolean ValidateCatalogDisplay()
    {
        try
        {
            exists=false;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",1000);
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    //Code to add multiple products to OG through Catalog
    public void AddFromCatalog(List<String> Prods) throws InterruptedException
    {
        WebElement WebEle=null;
        WebElement catalogPopup=null;
        Actions act1=new Actions(driver);
        String status;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
        }
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-grid']",driver))
            {
                    //To zoom out browser by 67%
                    if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
                    {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("document.body.style.zoom='67%'");
                    }
                    else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
                    {
                        JavascriptExecutor js=(JavascriptExecutor)driver;
                        js.executeScript("document.body.style.MozTransform='67%'");
                    }
                        //to load all the products in catalog
                        if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
                        {
                            WebElement loadProducts=HelpersMethod.FindByElement(driver,"xapth","//span[contains(text(),'load all products')]");
                            HelpersMethod.ActClick(driver,loadProducts,10000);
                        }
                        status=HelpersMethod.returnDocumentStatus(driver);
                        if (status.equals("loading"))
                        {
                            HelpersMethod.waitTillLoadingPage(driver);
                        }
                        //Click on 'Add filter'
                        catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                        WebEle= catalogPopup.findElement(By.xpath(".//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"));
                        HelpersMethod.JScriptClick(driver,WebEle,80000);

                        status=HelpersMethod.returnDocumentStatus(driver);
                        if (status.equals("loading"))
                        {
                                    HelpersMethod.waitTillLoadingPage(driver);
                        }

                        //Click on clear all
                        if(HelpersMethod.IsExists("//button[contains(text(),'Clear all')]",driver))
                        {
                            status=HelpersMethod.returnDocumentStatus(driver);
                            if (status.equals("loading"))
                            {
                                HelpersMethod.waitTillLoadingPage(driver);
                            }
                            //Click on Clear all button
                            WebElement clearAll=driver.findElement(By.xpath("//button[contains(text(),'Clear all')]"));
                            HelpersMethod.JScriptClick(driver,clearAll,100000);
                            status=HelpersMethod.returnDocumentStatus(driver);
                            if (status.equals("loading"))
                            {
                                HelpersMethod.waitTillLoadingPage(driver);
                            }
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                            }

                            status=HelpersMethod.returnDocumentStatus(driver);
                            if (status.equals("loading"))
                            {
                                HelpersMethod.waitTillLoadingPage(driver);
                            }
                            new WebDriverWait(driver,100000).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"))));
                            //Click on Add filter again
                            catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                            WebEle= catalogPopup.findElement(By.xpath(".//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"));
                            HelpersMethod.JScriptClick(driver,WebEle,80000);
                        }
                        //Enter value in 1st input
                        WebElement fistSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup')]/descendant::input[contains(@class,'i-search-box__input')]");
                        HelpersMethod.EnterText(driver,fistSearch,10000,"Product #");
                        //Click on check box
                        WebElement checkBox=HelpersMethod.FindByElement(driver,"id","ProductNumber");
                        HelpersMethod.JScriptClick(driver,checkBox,10000);
                        //Click on Apply button
                        WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Apply']");
                        HelpersMethod.JScriptClick(driver,applyButton,10000);
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                        }
                    if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
                    {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("document.body.style.zoom='100%'");
                    }
                    else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
                    {
                        JavascriptExecutor js=(JavascriptExecutor)driver;
                        js.executeScript("document.body.style.MozTransform='100%'");
                    }
                    //Enter product numbers to be searched
                    for(int j=0;j<=Prods.size()-1;j++)
                    {
                            //click on filter option button
                            catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                            WebElement searchOption =catalogPopup.findElement(By.xpath(".//span[contains(text(),'Product')]/ancestor::button[contains(@class,'i-filter-tag__main')]"));
                            HelpersMethod.JScriptClick(driver,searchOption,20000);

                            WebElement secondSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'k-textbox')]");
                            HelpersMethod.EnterText(driver,secondSearch,20000,Prods.get(j));
                            //Click on Apply button
                            applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button[text()='Apply']");
                            HelpersMethod.JScriptClick(driver,applyButton,20000);
                        status=HelpersMethod.returnDocumentStatus(driver);
                        if (status.equals("loading"))
                        {
                            HelpersMethod.waitTillLoadingPage(driver);
                        }
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
                            }
                            //Select the product from catalog
                            WebElement prod= HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]");
                            HelpersMethod.ActClick(driver,prod,10000);
                            scenario.log("PRODUCT FOUND IN CATALOG IS "+Prods.get(j));
                    }
            }
            else //if(HelpersMethod.IsExists("//div[contains(@class,'card-view')]",driver))
            {
                WebElement SearchBar = null;
                WebElement SearchIndex = null;
                WebElement SearchClear=null;
                WebElement SelectBut = null;
                WebElement ResetFilter= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@data-test-id,'productFilterResetBtn')]");
                HelpersMethod.ActClick(driver,ResetFilter,10000);
               /* if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                }*/
                //Code to handle if catalog is displaying in card view
                for (int i = 0; i < Prods.size() - 1; i++)
                {
                    SearchBar = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[contains(@placeholder,'Search products')]");
                    SearchIndex = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M15.5')]");

                    SearchClear=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[@id='searchBarClearBtn']/*[local-name()='svg']");
                    HelpersMethod.ActClick(driver,SearchClear,2000);
                  /*  if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }*/
                    HelpersMethod.ActSendKey(driver,SearchBar,400,Prods.get(i));
                    HelpersMethod.ActClick(driver,SearchIndex,40);
                   /* if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }*/

                    if (HelpersMethod.IsExists("//div[@id='no-products-found']", driver))
                    {
                        scenario.log("SORRY PRODUCT WITH # " + Prods.get(i) + " DOESN'T EXISTS");
                        WebElement Close_But = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M17')]");
                        HelpersMethod.ActClick(driver,Close_But,200);
                    }
                    else
                    {
                        scenario.log("PRODUCT # " + Prods.get(i) + " HAS BEEN ADDED TO OG");
                        HelpersMethod.ActScroll(driver, HelpersMethod.FindByElement(driver, "xpath", "//button[text()='Select']"),200);
                        SelectBut = HelpersMethod.FindByElement(driver, "xpath", "//button[text()='Select']");
                        HelpersMethod.ActClick(driver,SelectBut, 200);
                    }
                }
            }
        catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
        WebEle= catalogPopup.findElement(By.xpath(".//button[text()='Ok']"));
        HelpersMethod.JScriptClick(driver,WebEle,80000);
    }

    public void PrintOG()
    {
        exists=false;
        WebElement WebEle=null;
            if(PrintBut.isDisplayed() && PrintBut.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, PrintBut);
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, PrintBut, 10);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        exists= true;
                        scenario.log("PRINT BUTTON FOR ORDER GUIDE HAS BEEN HANDLED");
                    }
                }
                driver.switchTo().window(ParentWindow);
                exists=true;
            }
            else
            {
                scenario.log("PRINT BUTTON IS NOT ENABLED");
            }
            Assert.assertEquals(exists, true);
    }

    //Selecting local chain from the drop down
    public void Select_Chain(String chain)
    {
        exists=false;
            WebElement WebEle=null;
            Actions act1= new Actions(driver);
            // to fetch the web element of the modal container
            WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-group k-child-animation-container')]");
            List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul[contains(@class,'k-list k-reset')]/li"));
            for(int i=0;i<=Options.size()-1;i++)
            {
                WebEle = Options.get(i);
                act1.moveToElement(WebEle).build().perform();
                String Opt = WebEle.getText();
                if (Opt.equals(chain))
                {
                    act1.moveToElement(WebEle).click(WebEle).build().perform();
                    exists = true;
                    break;
                }
            }
            Assert.assertEquals(exists, true);
    }

    public void ListProductsImported()
    {
        exists=false;
        WebElement WebEle;
        String Prod_Text=null;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-grid-container')]");
            HelpersMethod.ScrollElement(driver,WebEle);

            List<WebElement> Prods= HelpersMethod.FindByElements(driver,"xpath","//button[@class='i-link-button ']//button[@class='i-link-button ']");
            for(WebElement Prod:Prods)
            {
                Prod_Text=Prod.getText();
                scenario.log("PRODUCT NO. IN IMPORTED FILE IS "+Prod_Text);
            }
            exists=true;
            Assert.assertEquals(exists,true);
    }

    public void ValidateNoProductsInGrid()
    {
        exists=false;
            if(HelpersMethod.IsExists("//tr[@class='k-grid-norecords']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
    }

    public void ReadProductFromGrid()
    {
        exists=false;
          List<WebElement> Products=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::button");
          for(WebElement Product:Products)
          {
              String Prod_Text=Product.getText();
              scenario.log("PRODUCT FOUND IN PRODUCT GRID "+Prod_Text);
          }
    }

    public void ClickCancelButton()
    {
        HelpersMethod.ClickBut(driver, OGCancel, 60);
    }

    public void clickOnAllCustomerCheckBox() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,AllCustCheckbox,40);
        //HelpersMethod.WaitElementPresent(driver,"xpath","//dif[contains(text(),'Remove customer allocation')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",200);
    }

    public void validateAllCustomerCheckBox()
    {
        if(AllCustCheckbox.isSelected())
        {
            scenario.log("WE ARE ABOUT TO CREATE OG FOR ALL THE CUSTOMERS,BECAUSE ALL CUSTOMERS CHECKBOX IS CHECKED");
        }
    }

    public void validateRemoveCustomerAllocationPopup_YesButton()
    {
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",400);
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Remove customer allocation", "Verify Title message");
        //Click on Yes in "Remove customer allocation" Popup
        WebElement yesButton=modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
        HelpersMethod.ClickBut(driver,yesButton,40);
    }

    public void validateNonExistanceOfCustomerAllocationTab()
    {
        String Tab_text=null;
        Actions act1=new Actions(driver);
        List<WebElement> OGTabs=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'bottomDetailCard')]/descendant::ul[contains(@class,'k-tabstrip-items k-reset')]/li/span");
        for(WebElement OGTab:OGTabs)
        {
            act1.moveToElement(OGTab).build().perform();
            Tab_text=OGTab.getText();
            if(!Tab_text.equals("Customer allocation"))
            {
                scenario.log("CUSTOMER ALLOCATION TAB HAS BEEN REMOVED, TO ENABLE CREATION OG FOR ALL CUSTOMERS");
            }
        }
    }

    public void selectChainFromPopup() throws InterruptedException
    {
        if(HelpersMethod.IsExists("//div[contains(text(),'chain')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
        {
           WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]");
           HelpersMethod.ActClick(driver,WebEle,100);
        }
    }

    public void validateOGType(String type)
    {
        exists=false;
        try
        {
            String status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//label[text()='Type']/following-sibling::span/descendant::span[@class='k-input']");
            String typeName=WebEle.getText();
            if(typeName.equals(type))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCustomerReference(String custRef)
    {
        exists=false;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//label[text()='Customer reference']/following-sibling::input");
            String cRef=HelpersMethod.JSGetValueEle(driver,WebEle,80);
            if(cRef.equals(custRef))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readPtoductNo()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//tr[@class='k-grid-norecords']",driver))
            {
                List<WebElement> products = HelpersMethod.FindByElements(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::button");
                for (WebElement prod : products)
                {
                    String prod_text = prod.getText();
                    scenario.log("PRODUCT FOUND IN OG " + prod_text);
                }
                exists=true;
            }
            else
            {
                scenario.log("NO PRODUCTS HAS BEEN FOUND IN OG");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnStatus()
    {
        exists=false;
        try
        {
            if(Status.isDisplayed())
            {
                HelpersMethod.ActClick(driver, Status, 1000);
                new WebDriverWait(driver,80000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectStatus(String type)
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> Options=menuContainer.findElements(By.xpath(".//ul/li"));
            for (WebElement opt:Options)
            {
                act1.moveToElement(opt).build().perform();
                String Opt_Text= opt.getText();
                if (Opt_Text.equals(type))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void validateOGTypeDropDown()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container')]",driver))
            {
                exists=true;
            }
        }
        catch (Exception e){}
    }

    public void validateSavePopup()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                // to fetch the web element of the modal container
                WebElement saveConfirm = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement saveConfirmTitle = saveConfirm.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(saveConfirmTitle.getText(), "Order guides", "Verify Title message");
            }
        }
        catch (Exception e){}
    }

    public void clickOnOk()
    {
        try
        {
            WebElement WebEle;
            if (HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                WebElement PopupOk=modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ActClick(driver,PopupOk,100000);
                //to handle loading icon
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
                scenario.log("OG HAS BEEN SAVED");
            }
            else
            {
                exists=HelpersMethod.IsExists("//div[contains(text(),'An order guide already exists with this code')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver);
                if(exists==true)
                {
                    scenario.log("OG CANN'T BE SAVED WITH GIVEN DESCRIPTION, START DATE AND END DATE");
                    WebElement PopupOk=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Cancel']");
                    HelpersMethod.ActClick(driver,PopupOk,100);
                    scenario.log("CANN'T CREATE MULTIPLE OG FOR SAME DATE");
                }
                Assert.assertEquals(exists, true);
            }
        }
        catch (Exception e){}
    }

    public void ListView()
    {
        exists = false;
        WebElement WebEle=null;
        WebElement selectButton;
        WebElement clearButton;
        Actions act=new Actions(driver);
        try {
            String Prods = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver)) {
                //to load all the products in catalog
                if (HelpersMethod.IsExists("//span[contains(text(),'load all products')]", driver)) {
                    WebElement loadProducts = HelpersMethod.FindByElement(driver, "xapth", "//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver, loadProducts, 100);
                }

                //Click on 'Add filter'
                WebElement catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = catalogPopup.findElement(By.xpath(".//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"));
                HelpersMethod.clickOn(driver, WebEle, 80);
                //To zoom out browser by 67%
                if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
                {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("document.body.style.zoom='67%'");
                }
                else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
                {
                    JavascriptExecutor js=(JavascriptExecutor)driver;
                    js.executeScript("document.body.style.MozTransform='67%'");
                }

                //Click on clear all
                WebElement clearAll = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button[contains(text(),'Clear all')]");
                if (clearAll.isDisplayed() && clearAll.isEnabled())
                {
                    HelpersMethod.JScriptClick(driver, clearAll, 200);
                    //To resize browser by 100%
                    if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
                    {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("document.body.style.zoom='100%'");
                    }
                    else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
                    {
                        JavascriptExecutor js=(JavascriptExecutor)driver;
                        js.executeScript("document.body.style.MozTransform='100%'");
                    }
                    //Click on Add filter again
                    HelpersMethod.clickOn(driver, WebEle, 80);
                }
                //Enter value in 1st input
                WebElement fistSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
                HelpersMethod.EnterText(driver, fistSearch, 100, "Product #");
                //Click on check box
                WebElement checkBox = HelpersMethod.FindByElement(driver, "id", "ProductNumber");
                HelpersMethod.ActClick(driver, checkBox, 100);

                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                }

                WebElement secondSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'k-textbox')]");
                HelpersMethod.EnterText(driver, secondSearch, 100, Prods);
                //Click on Apply button
                WebElement applyButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::button[text()='Apply']");
                HelpersMethod.ClickBut(driver, applyButton, 100);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
                }
                //Select the product from catalog
                WebElement prod = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]");
                HelpersMethod.ActClick(driver, prod, 100);
                scenario.log("PRODUCT FOUND IN CATALOG IS " + Prods);
            }
        }
        catch (Exception e){}
    }

    public void cardView()
    {
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            String Prods = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
            //enter product number in input box
            WebElement inputBox = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
            HelpersMethod.EnterText(driver,inputBox,1000,Prods);
            //Click on search icon
            WebElement  searchIcon = HelpersMethod.FindByElement(driver, "xpath", "//span[@datatestid='searchBarSearchBtn']//*[local-name()='svg']");
            HelpersMethod.ActClick(driver, searchIcon, 10000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 250000);
            }
            //add product to standing order
            WebElement selectButton = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item']/descendant::button[text()='Select']");
            HelpersMethod.ScrollElement(driver, selectButton);
            HelpersMethod.ClickBut(driver, selectButton, 2000);
            scenario.log("PRODUCT FOUND IN CATALOG IS "+Prods);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }

            //Click on 'x' button in catalog
            WebElement clearButton = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='searchBarClearBtn']");
            HelpersMethod.ScrollElement(driver,clearButton);
            act.moveToElement(clearButton).click().build().perform();
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
        }
        catch (Exception e){}
    }

    public void validateNewOGPage()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
            }
            if(HelpersMethod.IsExists("// div[contains(@class,'moduleNameHeader')]/descendant::span[contains(text(),'New order guide')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}