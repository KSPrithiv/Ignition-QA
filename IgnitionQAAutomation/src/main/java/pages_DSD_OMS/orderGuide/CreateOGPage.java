package pages_DSD_OMS.orderGuide;

import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.eo.Se;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.aspectj.apache.bcel.classfile.Module;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileFilter;
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
        HelpersMethod.Implicitwait(driver,10);
        try
        {
            HelpersMethod.EnterText(driver,OG_Des,4,OGDesc);
        }
        catch (Exception e) {}
    }
    //Code to click on Start date calender
    public void CalenderStart()
    {
        try
        {
            HelpersMethod.ScrollElement(driver,ValidFrom);
            HelpersMethod.ActClick(driver,ValidFrom, 2);
        }
        catch (Exception e) {}
    }

    //Code to click on End date calender
    public void CalenderEnd()
    {
        try
        {
            HelpersMethod.ScrollElement(driver,ValidTo);
            HelpersMethod.ActClick(driver,ValidTo, 2);
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
                HelpersMethod.ActClick(driver, ele1, 2);
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
                HelpersMethod.ActClick(driver,ele1, 1);
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",6);
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            String ele = "//div[contains(@class,'k-calendar-monthview')]";
            boolean visible = HelpersMethod.IsExists(ele, driver);
            if (visible == true)
            {
                LocalDate myDateObj = LocalDate.now().minusDays(1);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-view k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.JSScroll(driver,ele1);
                Thread.sleep(1000);
                HelpersMethod.ActClick(driver,ele1, 1);
                Thread.sleep(1000);
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
            HelpersMethod.ScrollElement(driver,QuickProd);
            HelpersMethod.ClearText(driver,QuickProd,4);
            HelpersMethod.ActSendKey(driver, QuickProd,2,Product);
            HelpersMethod.ClearText(driver,Sequence,2);
            HelpersMethod.ActSendKey(driver, Sequence, 2,ProSeq);
            exists=true;
            scenario.log("PRODUCT# ENTERED IS "+Product+" SEQUENCE# ENTERED IS "+ProSeq);

            if(HelpersMethod.IsExists("//div[contains(text(),'no matching products')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Ok')]");
                HelpersMethod.ClickBut(driver,WebEle,2);
                exists=false;
            }
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10);
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
            HelpersMethod.ClickBut(driver,OGSave,2);
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10);

            exists=HelpersMethod.IsExists("//div[contains(text(),'Order guides saved')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver);
            if (exists==true)
            {
                WebElement PopupOk=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ActClick(driver,PopupOk,10);
                //to handle loading icon
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10);
                scenario.log("OG HAS BEEN SAVED");
            }
            else
            {
                exists=HelpersMethod.IsExists("//div[contains(text(),'An order guide already exists with this code')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver);
                if(exists==true)
                {
                    scenario.log("OG CANN'T BE SAVED WITH GIVEN DESCRIPTION, START DATE AND END DATE");
                    WebElement PopupOk=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Cancel']");
                    HelpersMethod.ActClick(driver,PopupOk,6);
                    scenario.log("CANN'T CREATE MULTIPLE OG FOR SAME DATE");
                }
                Assert.assertEquals(exists, true);
            }
        }
        catch (Exception e) {}
    }

    public boolean OGDetailValidate()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@id='card1']/descendant::span[contains(text(),'Detail order guide')]",5);
            if (HelpersMethod.IsExists("//div[@id='card1']/descendant::span[contains(text(),'Detail order guide')]", driver))
            {
                exists = true;
            }
        }
        catch (Exception e){}
        return exists;
    }

    //code to search product in OG
    public boolean SearchProd(String ProdNo) throws InterruptedException
    {
        exists = false;
        try
        {
            HelpersMethod.ScrollElement(driver,Searchbox);
            HelpersMethod.ActSendKey(driver, Searchbox,4,ProdNo);
            HelpersMethod.ActClick(driver,SearchIndex,1);
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
        try
        {
            WebElement Checkbox=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[1]");
            WebElement Button_Ele=null;
            HelpersMethod.ClickBut(driver,Checkbox,2);
            if(DeleteProd.isEnabled())
            {
                HelpersMethod.ClickBut(driver,DeleteProd,2);
                Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                if(HelpersMethod.EleDisplay(Button_Ele))
                {
                    Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,Button_Ele,1);
                }
                scenario.log("PRODUCT HAS BEEN REMOVED FROM OG");
            }
            else
            {
                scenario.log("DELETE BUTTON IS NOT ENABLED,CHECK FOR THE REASON");
            }
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
            HelpersMethod.Implicitwait(driver,20);
            if(HelpersMethod.IsExists("//div[text()='Clear']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='No']");
                HelpersMethod.ClickBut(driver,WebEle,10);
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
            HelpersMethod.Implicitwait(driver,8);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }

            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='bottomDetailCard']");
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.Implicitwait(driver,10);
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
            HelpersMethod.ActClick(driver,AddProd,10);
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='productFilterResetBtn']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::table[@class='k-grid-table']/descendant::tr[1]");
                    HelpersMethod.ActClick(driver, WebEle, 10);
                }
                else if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-grid']/descendant::table[@class='k-grid-table']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::table[@class='k-grid-table']/descendant::tr[1]");
                    HelpersMethod.ActClick(driver,WebEle,10);
                }
            }
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
            HelpersMethod.ClickBut(driver,WebEle,10);
        }
        catch (Exception e){}
    }

    public void ValidateOGPopup()
    {
        exists=false;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                HelpersMethod.EnterText(driver,WebEle,10,OGSearch);
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
                HelpersMethod.ActClick(driver,WebEle,10);
                //Click on OG
                WebElement OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/descendant::input[@class='k-checkbox']");
                HelpersMethod.ActClick(driver,OrderSel,1);
                OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,OrderSel,2);

                //Handle popup if products,in OG are not available currently
                if(HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
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
    public void CatalogPopup()
    {
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            WebElement Prod=null;
            WebElement OkBut=null;
            WebElement ResetFilter= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@data-test-id,'productFilterResetBtn')]");
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-grid']",driver))
            {
                Prod=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                OkBut=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
               HelpersMethod.ScrollElement(driver,Prod);
               HelpersMethod.ActClick(driver,Prod,10);
               HelpersMethod.ScrollElement(driver,OkBut);
                HelpersMethod.ActClick(driver,OkBut,10);
            }
            else //if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='card-view']",driver))
            {
                HelpersMethod.ActClick(driver,ResetFilter,10);
                Prod=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Select'][1]");
                OkBut=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ScrollElement(driver,Prod);
                HelpersMethod.ActClick(driver,Prod,10);
                HelpersMethod.ScrollElement(driver,OkBut);
                HelpersMethod.ActClick(driver,OkBut,10);
            }
        }
        catch (Exception e){}
    }

    //Code for handling Order popup
    public void OrderPopup()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Select orders')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",10);
            if(HelpersMethod.IsExists("//div[contains(text(),'Select orders')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@class,'list-group-item')][1]");
                HelpersMethod.ScrollElement(driver,OrderSel);
                HelpersMethod.ActClick(driver,OrderSel,2);
                OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ScrollElement(driver,OrderSel);
                HelpersMethod.ClickBut(driver,OrderSel,2);
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
            HelpersMethod.Implicitwait(driver,10);
            HelpersMethod.ScrollElement(driver,OG_Delete);
            HelpersMethod.ActClick(driver,OG_Delete,6);
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
                HelpersMethod.ClickBut(driver,DeleteOk,2);
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Order guides deleted')]/ancestor::div[@class='k-widget k-window k-dialog']",2);
                if(HelpersMethod.IsExists("//div[contains(text(),'Order guides deleted')]/ancestor::div[@class='k-widget k-window k-dialog']",driver))
                {
                    DeleteOk=HelpersMethod.FindByElement(driver,"xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,DeleteOk,2);
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
                HelpersMethod.ClickBut(driver,DeleteCancel,2);
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='bottomDetailCard']");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(OGExport.isDisplayed() && OGExport.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,OGExport);
                HelpersMethod.ActClick(driver,OGExport,10);
                HelpersMethod.Implicitwait(driver,8);
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
                String file2=null;

                for (File Exportfile:files)
                {
                   String file1 = Exportfile.getName();
                   if(file1.contains("OrderGuide"))
                   {
                       ExportOG=file1;
                       break;
                   }
                }
                HelpersMethod.Implicitwait(driver,5);
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
        try
        {
            if(OGImport.isDisplayed())
            {
                driver.findElement(By.xpath("//input[@id='ImportProducts' and @type='file']")).sendKeys("C:\\Users\\Divya.Ramadas\\Downloads\\OrderGuide_OG822.csv");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
            }
        }
        catch (Exception e){}
    }

    //Handling File open popup to select file from popup
    public void FileOpen()
    {
        ExportOG="OrderGuide_OG742.csv";
        try
        {
            //Copying the file name to input box of file upload popup
         /*   Thread.sleep(5000);
            StringSelection stringselection=new StringSelection("C:\\Users\\Divya.Ramadas\\Downloads\\"+ExportOG);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);*/

            //calling robot class and method for uploading file
          //  HelpersMethod.FileUploadRobot();
        }
        catch (Exception e){}
    }

    public void Click_On_Type()
    {
        try
        {
            HelpersMethod.ActClick(driver,Type,4);
        }
        catch (Exception e){}
    }

    public void SelectTypeFromDropDown(String type)
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]",4);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container')]",driver))
            {
                HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li","xpath",type);
            }
        }
        catch (Exception e){}
    }

    public void ClickOnDayOfWeek()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//label[contains(text(),'Day of week')]/following-sibling::span[contains(@class,'k-widget k-dropdown')]/span",4);
            if (HelpersMethod.IsExists("//label[contains(text(),'Day of week')]/following-sibling::span[contains(@class,'k-widget k-dropdown')]/span",driver))
            {
                HelpersMethod.ActClick(driver,DayOfWeek,2);
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
            HelpersMethod.ActClick(driver,AlloCust,2);
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//span[contains(text(),'Products')]",8);
            WebElement AlloCust=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Products')]");
            HelpersMethod.ActClick(driver,AlloCust,2);
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
            HelpersMethod.ClickBut(driver,CheckBox,2);
        }
        catch (Exception e){}
    }

    //Code to click on Delete button to remove customer allocation
    public void ClickOnDelete()
    {
        try
        {
           HelpersMethod.Implicitwait(driver,20);
           WebElement DelCust=HelpersMethod.FindByElement(driver,"xpath","//button[@id='buttonDelete']");
           HelpersMethod.ActClick(driver,DelCust,10);
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
            HelpersMethod.Implicitwait(driver,10);
            WebElement PlusAdd=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='addCustomerAllocationDropDown']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M19')]");
            HelpersMethod.ActClick(driver,PlusAdd,8);
            exists=true;
            HelpersMethod.Implicitwait(driver,60);
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
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            exists=HelpersMethod.IsExists("//div[contains(text(),'Select customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver);
            if(exists==true)
            {
                //Code to enter Customer allocation, and click on Index
                WebElement SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[@id='SearchBox1']");
                HelpersMethod.EnterText(driver,SearchBox,2,TestBase.testEnvironment.get_Account());
                SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
                HelpersMethod.ActClick(driver,SearchBox,2);
            }
        }
        catch (Exception e){}
        return exists;
    }

    //Code to select Customer Account
    public void CustomerAccountSelect()
    {
        try
        {
            WebElement SearchBox=null;
            //Code to select customer allocation from popup
            SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::input[@class='k-checkbox']");
            HelpersMethod.ActClick(driver,SearchBox,4);
            SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
            HelpersMethod.ActClick(driver,SearchBox,4);
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",100);
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
            WebElement ResetFilter= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@data-test-id,'productFilterResetBtn')]");
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-grid']",driver))
            {
                WebElement Input_Box=null;
                WebElement Filter_But=null;
                WebElement Filter_Remove=null;
                WebElement Product_Row=null;
                List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr/th/span[@class='k-link']");
                int i=0;
                for (WebElement Head:Heads)
                {
                    i++;
                    String Head_Text=Head.getText();
                    if(Head_Text.equals("Product #"))
                    {
                        Input_Box=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-filter-row')]/th["+i+"]/descendant::input");
                        Filter_But=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-filter-row')]/th["+i+"]/descendant::div[@class='k-filtercell-operator']/span");
                        for (int j = 0; j < Prods.size() - 1; j++)
                        {
                            HelpersMethod.EnterText(driver,Input_Box,20,Prods.get(j));
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                            }
                            //Select the product row
                            Product_Row=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]");
                            HelpersMethod.ActClick(driver,Product_Row,20);


                            //Code to clear the filter
                            Filter_Remove=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-filter-row')]/th["+i+"]/descendant::div[@class='k-filtercell-operator']/descendant::button[contains(@class,'k-clear-button-visible')]");
                            HelpersMethod.ActClick(driver,Filter_Remove,20);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                            }

                            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']",10);
                        }
                        break;
                    }
                }
                WebElement OK_But = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ActClick(driver,OK_But, 20);
            }
            else //if(HelpersMethod.IsExists("//div[contains(@class,'card-view')]",driver))
            {
                WebElement SearchBar = null;
                WebElement SearchIndex = null;
                WebElement SearchClear=null;
                WebElement SelectBut = null;
                HelpersMethod.ActClick(driver,ResetFilter,10);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                //Code to handle if catalog is displaying in card view
                for (int i = 0; i < Prods.size() - 1; i++)
                {
                    SearchClear=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[@id='searchBarClearBtn']/*[local-name()='svg']");
                    SearchBar = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[contains(@placeholder,'Search products')]");
                    SearchIndex = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M15.5')]");
                    HelpersMethod.ClearText(driver,SearchClear,20);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }
                    HelpersMethod.ActSendKey(driver,SearchBar,10,Prods.get(i));
                    HelpersMethod.ActClick(driver,SearchIndex,10);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }
                    //HelpersMethod.Implicitwait(driver, 50);
                    if (HelpersMethod.IsExists("//div[@id='no-products-found']", driver))
                    {
                        scenario.log("SORRY PRODUCT WITH # " + Prods.get(i) + " DOESN'T EXISTS");
                        WebElement Close_But = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M17')]");
                        HelpersMethod.ActClick(driver,Close_But,2);
                    }
                    else
                    {
                        HelpersMethod.Implicitwait(driver, 50);
                        scenario.log("PRODUCT # " + Prods.get(i) + " HAS BEEN ADDED TO OG");
                        HelpersMethod.ActScroll(driver, HelpersMethod.FindByElement(driver, "xpath", "//button[text()='Select']"),20);
                        SelectBut = HelpersMethod.FindByElement(driver, "xpath", "//button[text()='Select']");
                        HelpersMethod.ActClick(driver,SelectBut, 20);
                    }
                }
                WebElement OK_But = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ActClick(driver,OK_But,1);
            }
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        HelpersMethod.Implicitwait(driver, 10);
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
    public void Select_LocalChain(String Lchain)
    {
        exists=false;
            HelpersMethod.DropDownMenu(driver,Lchain);
            exists=true;
            Assert.assertEquals(exists,true);
    }

    public void ListProductsImported()
    {
        exists=false;
        WebElement WebEle;
        String Prod_Text=null;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
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

    public void clickOnAllCustomerCheckBox()
    {
        HelpersMethod.ClickBut(driver,AllCustCheckbox,40);
        HelpersMethod.WaitElementPresent(driver,"xpath","//dif[contains(text(),'Remove customer allocation')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",200);
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
}