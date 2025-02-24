package pages_DSD_OMS.orderGuide;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;

import io.cucumber.java.bs.A;
import io.cucumber.java.en_old.Ac;
import io.cucumber.java.zh_cn.假如;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.vandeseer.easytable.drawing.DrawingUtil;
import util.DataBaseConnection;
import util.TestBase;

import java.io.File;
import java.io.FileFilter;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
    static String DOfWeek;
    static String ExportOG;
    static ArrayList<String> sequence1=new ArrayList<String>();
    static ArrayList<String> sequence2=new ArrayList<>(sequence1);
    //static String importFilePath;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::input")
    private WebElement OG_Des;

    @FindBy(id = "quickProduct")
    private WebElement QuickProd;

    //@FindBy(xpath="//label[contains(text(),'Unit of measure')]/following-sibling::label")
    //@FindBy(id="quickEntryUMs")
    //private WebElement QuickUOM;

    @FindBy(id = "quickSequence")
    private WebElement Sequence;

    @FindBy(xpath = "//button[@data-test-id='ogAddProductsOptions']")
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

    @FindBy(xpath = "//label[contains(text(),'Day of week')]/following-sibling::span[contains(@class,'k-dropdownlist')]/button")
    private WebElement DayOfWeek;

    @FindBy(xpath = "//label[contains(text(),'Status')]/following-sibling::span[contains(@class,'k-dropdownlist')]/button")
    private WebElement Status;

    @FindBy(xpath = "//label[text()='Type']/following-sibling::span[contains(@class,'k-dropdownlist')]/button")
    private WebElement Type;

    @FindBy(xpath = "//label[@id='dateInputB-label']/following-sibling::span/descendant::button")
    private WebElement ValidTo;

    @FindBy(xpath = "//label[@id='dateInputA-label']/following-sibling::span/descendant::button")
    private WebElement ValidFrom;

    @FindBy(id = "OGSaveButton")
    private WebElement OGSave;

    @FindBy(id = "OGCancelButton")
    private WebElement OGCancel;

    @FindBy(xpath="//button/span[text()='More']")
    private WebElement More;

    @FindBy(xpath = "//div[@id='card1']/descendant::button/span[text()='Delete']")
    private WebElement OG_Delete;

    @FindBy(xpath="//button/span[text()='Print']")
    private WebElement PrintBut;

    @FindBy(id="checkBoxD")
    private WebElement AllOrderCheckbox;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-grouping-drop-container')]")
    private WebElement To;

    LocalDate today = LocalDate.now();
    java.time.DayOfWeek dayOfWeek = today.getDayOfWeek();

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

            if(HelpersMethod.IsExists("//div[@class='bottomDetailCard']/descendant::div[contains(text(),'No customers found, order guide cannot be created.')]",driver))
            {
                scenario.log("NO CUSTOMERS HAVE BEEN FOUND, SO WE CAN'T CREATE AN ORDER GUIDE");
                exists=false;
            }
            else
            {
                HelpersMethod.EnterText(driver, OG_Des, 4000, OGDesc);

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

                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("web-order-page-content"))));
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("web-order-page-content")));

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
            HelpersMethod.ActClick(driver,ValidFrom, 10000);
        }
        catch (Exception e) {}
    }

    //Code to click on End date calender
    public void CalenderEnd()
    {
        try
        {
            HelpersMethod.ScrollElement(driver,ValidTo);
            HelpersMethod.ActClick(driver,ValidTo, 1000);
        }
        catch (Exception e) {}
    }

    //Selecting Start date
    public void SelectStartDate(String ChangeDate,int i)
    {
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",1000);
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                LocalDate myDateObj = LocalDate.now().plusDays(i);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.JSScroll(driver,ele1);
                HelpersMethod.ActClick(driver, ele1, 10000);
                scenario.log(formattedDate1 + " HAS BEEN SELECTED AS START DATE FOR OG");
                new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",100);
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
                HelpersMethod.ActClick(driver,ele1, 10000);
                scenario.log(formattedDate1 + " HAS BEEN SELECTED AS END DATE FOR OG");
                DateTimeFormatter myFormatObjDay = DateTimeFormatter.ofPattern("EEEE");
                DOfWeek=  myDateObj.format(myFormatObjDay);
                new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",2000);
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container')]",driver))
            {
                LocalDate myDateObj = LocalDate.now().minusDays(2);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.JSScroll(driver,ele1);
                HelpersMethod.ActClick(driver,ele1, 10000);
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
            WebElement WebEle;
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

            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("card2"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("card2")));

            if(QuickProd.isDisplayed())
            {
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("web-order-page-content"))));
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("web-order-page-content")));

                HelpersMethod.ScrollElement(driver, QuickProd);
                HelpersMethod.ClearText(driver, QuickProd, 20000);
                QuickProd.click();
                HelpersMethod.EnterText(driver, QuickProd, 40000, Product);
                QuickProd.sendKeys(Keys.TAB);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                //Check whether UOM is displayed or not
                if (HelpersMethod.IsExistsById("quickEntryUMs", driver))
                {
                    WebElement QuickUOM = HelpersMethod.FindByElement(driver, "id", "quickEntryUMs");
                    QuickUOM.sendKeys(Keys.TAB);
                }

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                HelpersMethod.ActClearKey(driver, Sequence, 10000);
                Sequence.click();
                HelpersMethod.ActSendKey(driver, Sequence, 10000, ProSeq);
                Sequence.sendKeys(Keys.TAB);
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

                if (!HelpersMethod.IsExists("//div[contains(text(),'no matching products')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    scenario.log("PRODUCT# ENTERED IS " + Product + " SEQUENCE# ENTERED IS " + ProSeq);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    exists = true;
                }
                else
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Ok')]");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    scenario.log("NO MATCHING PRODUCTS HAS BEEN FOUND, CHECK FOR THE AVAILABILITY OF OG TYPE YOU SELECTED");
                    exists = false;
                }
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("web-order-page-content"))));
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("web-order-page-content")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Code to click on Save button
    public void ClickOnSave()
    {
        exists=false;
        try
        {
            WebElement WebEle;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
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
            Thread.sleep(2000);

            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("web-order-page-content"))));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("web-order-page-content")));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='OGSaveButton']")));

            if(HelpersMethod.IsExists("//button[@id='OGSaveButton']",driver) && OGSave.isEnabled())
            {
                WebElement OGSave = HelpersMethod.FindByElement(driver, "id", "OGSaveButton");
                //Click on Save button
                HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.ClickBut(driver, OGSave, 50000);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }

            //Handle popup if products,in OG are not available currently
            if(HelpersMethod.IsExists("//div[contains(text(),'The following products cannot be updated:')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The following products cannot be updated:')]/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                HelpersMethod.ActClick(driver,WebEle,10000);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void OGDetailValidate()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
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
            Thread.sleep(2000);
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
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            HelpersMethod.ActClick(driver,SearchIndex,1000);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
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
            //Finding checkbox for the searched product and clicking on checkbox
            WebElement Checkbox=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[1]");
            HelpersMethod.ClickBut(driver,Checkbox,1000);
            if(DeleteProd.isEnabled())
            {
                //clicking on Delete product button
                HelpersMethod.ClickBut(driver,DeleteProd,1000);
                //code to handle delete confirmation
                if(HelpersMethod.IsExists("//div[contains(text(),'delete this record?')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement confirmPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'delete this record?')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton=confirmPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ClickBut(driver,okButton,1000);
                    exists=true;
                }
                WebElement clearSearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__clear')]");
                HelpersMethod.ActClick(driver,clearSearchBox,2000);
                scenario.log("PRODUCT HAS BEEN REMOVED FROM OG");
                Thread.sleep(500);
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
            Thread.sleep(2000);
            if(HelpersMethod.EleDisplay(More))
            {
                HelpersMethod.ScrollElement(driver,More);
                HelpersMethod.ActClick(driver,More,10000);
                scenario.log("MORE BUTTON HAS BEEN CLICKED");
                exists=true;
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
        new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::ul/li/span")));
        try
        {
            List<WebElement> MoreOptions=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container')]/descendant::ul/li/span");
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
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[text()='Clear']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Clear']/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='No']");
                HelpersMethod.ActClick(driver,WebEle,10000);
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
            if(HelpersMethod.IsExists("//span[text()='Clear']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Clear']/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                HelpersMethod.ActClick(driver,WebEle,10000);
                scenario.log("YES, OPTION IS SELECTED FROM POPUP");
            }
        }
        catch (Exception e){}
    }

    //Code to Edit sequence number in Product grid of OG
    public boolean EditSequence(String SeqNo) throws InterruptedException
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

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

            Thread.sleep(2000);

            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='bottomDetailCard']");
            HelpersMethod.ScrollElement(driver,WebEle);
            String Seqno;

//            if(HelpersMethod.IsExists("//span[@class='k-column-title' and text()='Sequence']",driver))
//            {
//                WebElement Arrow = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='k-column-title' and text()='Sequence']/ancestor::span[@class='k-link']");
//                HelpersMethod.ActClick(driver, Arrow, 10000);
//                Arrow = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'k-svg-i-sort')]");
//                HelpersMethod.ActClick(driver, Arrow, 10000);
//            }

            WebElement SeqInput= HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::span[contains(@class,'k-numerictextbox')]/input");
            Seqno=HelpersMethod.AttributeValue(SeqInput,"value");
            scenario.log("SEQUENCE NO. BEFORE EDITING "+Seqno);
            HelpersMethod.JSSetValueEle(driver,SeqInput,10000,SeqNo);
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
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.ScrollElement(driver, AddProd);
            if(AddProd.isDisplayed() && AddProd.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, AddProd);
                Thread.sleep(1000);
                HelpersMethod.ClickBut(driver, AddProd, 20000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code for Selecting value from drop down that appears after clicking Add product button
    public void SelectValueFromAddProduct(String AddFrom)
    {
        exists=false;
        Actions act=new Actions(driver);
        String addProdText;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'k-menu-group')]/li/span")));
            if(HelpersMethod.IsExists("//ul[contains(@class,'k-menu-group')]/li/span",driver))
            {
                List<WebElement> addProds=HelpersMethod.FindByElements(driver,"xpath","//ul[contains(@class,'k-menu-group')]/li/span");
                for(WebElement addProd:addProds)
                {
                    act.moveToElement(addProd).build().perform();
                    addProdText=addProd.getText();
                    if(AddFrom.equals(addProdText))
                    {
                        act.moveToElement(addProd).build().perform();
                        act.click(addProd).build().perform();
                        exists=true;
                        break;
                    }
                }
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
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateCatalogPopup()
    {
        exists=true;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
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
        WebElement WebEle;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='productFilterResetBtn']");
                    HelpersMethod.ClickBut(driver,WebEle,1000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@id,'gridItemBox')][1]/descendant::button");
                    HelpersMethod.ActClick(driver, WebEle, 1000);
                }
                else if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-grid']/descendant::table[@class='k-grid-table']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::table[@class='k-grid-table']/descendant::tr[1]");
                    HelpersMethod.ActClick(driver,WebEle,10000);
                }
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

    public void CatalogPopupOk()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                HelpersMethod.ActClick(driver, WebEle, 10000);
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]")));
            Thread.sleep(2000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateOGPopup()
    {
        exists=false;
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

        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Select order guides')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("ORDER GUIDE POPUP HAS BEEN FOUND");
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@id='orderGuidesOGListDialog']/ancestor::div[contains(@class,'k-window k-dialog')]",10);
            if(HelpersMethod.IsExists("//div[@id='orderGuidesOGListDialog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                //Search for OG in popup
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::input[contains(@id,'SearchBox')]");
                HelpersMethod.EnterText(driver,WebEle,10000,OGSearch);
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                //Click on OG
                WebElement OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]");
                HelpersMethod.ActClick(driver,OrderSel,10000);
                OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                HelpersMethod.ClickBut(driver,OrderSel,10000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //Handle popup if products,in OG are not available currently
                if(HelpersMethod.IsExists("//div[contains(text(),'The following products cannot be updated:')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The following products cannot be updated:')]/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,10000);
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

    //code to validate presence of order popup
    public void validateOrderPopup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'Select orders')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("ORDER SELECTION DIALOG BOX FOUND!");
                exists=true;
            }
            else
            {
                scenario.log("ORDER SELECTION POPUP/DIALOG BOX NOT APPEARED");
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code for handling Order popup
    public void OrderPopup()
    {
        exists=false;
        WebElement OrderSel;
        Actions act=new Actions(driver);
        String amount_Text;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@id,'orderGuidesOrderListDialog')]/ancestor::div[contains(@class,'k-window k-dialog')]",10000);
                if(HelpersMethod.IsExists("//div[contains(@id,'orderGuidesOrderListDialog')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    int i=0;
                    List<WebElement> amounts=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td[contains(@class,'currency')]");
                    for (WebElement amount:amounts)
                    {
                        i++;
                        act.moveToElement(amount).build().perform();
                        amount_Text=amount.getText();
                        if(!amount_Text.equals("$0.00"))
                        {
                            break;
                        }
                    }

                    //To select order from order popup, by clicking check box
                    OrderSel = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]["+i+"]/descendant::input");
                    HelpersMethod.ScrollElement(driver, OrderSel);
                    HelpersMethod.ActClick(driver, OrderSel, 10000);

                    //to read the order number selected in order popup
                    String Order_No = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]["+i+"]/descendant::td[2]").getText();
                    if (!Order_No.isEmpty())
                    {
                        scenario.log("ORDER SELECTED FROM ORDER POPUP IS " + Order_No);
                        exists = true;
                    }
                    else
                    {
                        scenario.log("NO ORDER HAS BEEN FOUND");
                        exists = false;
                    }
                    //to click on OK button in order popup
                    OrderSel=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ScrollElement(driver,OrderSel);
                    HelpersMethod.ClickBut(driver,OrderSel,10000);
                }
                else  if(!HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]",driver))
                {
                    scenario.log("NO ORDER POPUP FOUND !!");
                }

                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }

            //Handle popup if products,in OG are not available currently
            if(HelpersMethod.IsExists("//div[contains(text(),'The following products cannot be updated:')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The following products cannot be updated:')]/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                HelpersMethod.ClickBut(driver,WebEle,10000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code for Delete OG
    public void Click_Delete()
    {
        exists=false;
        try
        {
            if(OG_Delete.isDisplayed() && OG_Delete.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, OG_Delete);
                HelpersMethod.ClickBut(driver, OG_Delete, 10000);
                scenario.log("OG DELETE BUTTON HAS BEEN CLICKED");
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                exists=true;
            }
            else
            {
                scenario.log("OG DELETE BUTTON HAS NOT BEEN FOUND");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    //Code for handling Delete popup
    public void DeleteOk_Popup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Are you sure you want to delete this order guide ?')]/ancestor::div[contains(@class,'k-window k-dialog')]",40000);
            if(HelpersMethod.IsExists("//div[contains(text(),'delete this order guide ?')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement DeleteOk=HelpersMethod.FindByElement(driver,"xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                HelpersMethod.ActClick(driver,DeleteOk,80000);
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

    public void deleteConfirmationPopup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Thread.sleep(1000);
            //if(HelpersMethod.IsExists("//div[contains(text(),'Order guides deleted')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            if(HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement DeleteOk=HelpersMethod.FindByElement(driver,"xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                HelpersMethod.ActClick(driver,DeleteOk,10000);
                scenario.log("OG DELETE HAS BEEN CLEARED");
                exists=true;

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code for cancel the delete
    public void DeleteCancel_Popup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(text(),'delete this order guide ?')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement DeleteCancel=HelpersMethod.FindByElement(driver,"xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Cancel']");
                HelpersMethod.ClickBut(driver,DeleteCancel,10000);
                scenario.log("CANCEL DELETE HAS BEEN SELECTED");
                exists=true;

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //code for clicking Export button
    public String Click_Export()
    {
        exists=false;
        WebElement WebEle;
        String tmpFolderPath = "";

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(800))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='bottomDetailCard']");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(OGExport.isDisplayed() && OGExport.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,OGExport);
                HelpersMethod.ActClick(driver,OGExport,1000);
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

                //to find path of exported file so that same file can be used for importing
                tmpFolderPath = System.getProperty("java.io.tmpdir");
                scenario.log("OG HAS BEEN DOWNLOADED IN PATH "+tmpFolderPath);

                //Read all the .csv files in download directory and compare with actual order number
//                File dir = new File(tmpFolderPath);
//                FileFilter fileFilter = new WildcardFileFilter("*.csv");
//                File[] files = dir.listFiles(fileFilter);
//
//                for (File Exportfile:files)
//                {
//                    String file1 = Exportfile.getName();
//                    if(file1.contains("OrderGuide"))
//                    {
//                        expectedFileName = file1;
//                        file = new File(tmpFolderPath+"\\" + expectedFileName);
//                        scenario.log(file+" IS EXPORTED ORDER GUIDE");
//                        //mportFilePath= String.valueOf(file);
//                        //ExportOG=file1;
//                        break;
//                    }
//                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) { }
        return tmpFolderPath;
    }

    //Code for clicking Import button
    public void ImportClick(String importFilePath)
    {
        exists=false;
        String file1;
        String OGno="";
        Wait<WebDriver> wait;
        try
        {
              if(HelpersMethod.IsExists("//input[@id='ImportProducts']",driver))
              {
                scenario.log("ORDER GUIDE .CSV FILE CAN BE FOUND IN PATH "+importFilePath);
                File dir = new File(importFilePath);
                FileFilter fileFilter = new WildcardFileFilter("*.csv");
                File[] files = dir.listFiles(fileFilter);
                for (File fileName:files)
                {
                    file1 = fileName.getName();
                    if(file1.contains("OrderGuide"))
                    {
                        if(TestBase.testEnvironment.get_url().contains("dsd"))
                        {
                            if(TestBase.testEnvironment.get_url().contains("ignitionqadsd"))
                            {
                                OGno="OrderGuide_OG108.csv";
                            }
                            else if(TestBase.testEnvironment.get_url().contains("autodsd"))
                            {
                                OGno="OrderGuide_OG670.csv";
                                break;
                            }
                        }
                        else if(TestBase.testEnvironment.get_url().contains("erp")||TestBase.testEnvironment.get_url().contains("ERP"))
                        {
                            OGno="OrderGuide_NEW.csv";
                        }
                    }
                }

                if(OGImport.isDisplayed())
                {
                    HelpersMethod.ScrollElement(driver,OGImport);
                    scenario.log("OG IMPORTED FROM PATH "+importFilePath+OGno);
                    driver.findElement(By.xpath("//input[@id='ImportProducts' and @type='file']")).sendKeys(importFilePath+OGno);
                    exists=true;
                    scenario.log("ORDER IMPORTED IS "+OGno);

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    if(HelpersMethod.IsExists("//span[contains(text(),'The following columns are required')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                    {
                        WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The following columns are required')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        WebElement okButton=popUp.findElement(By.xpath(".//button/span[text()='Ok']"));
                        HelpersMethod.ActClick(driver,okButton,10000);

                        wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(600))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    }
                }

                if(HelpersMethod.IsExists("//span[contains(text(),'Import failed')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Import failed')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton=popUp.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver,okButton,10000);

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
              }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_On_Type()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//label[text()='Type']/following-sibling::span[contains(@class,'k-dropdownlist')]/button",driver))
            {
                HelpersMethod.ScrollElement(driver,Type);
                HelpersMethod.ActClick(driver, Type, 10000);
                exists=true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@id,'dropDownNoneType-listbox-id')]/li/span")));
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
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@id,'dropDownNoneType-listbox-id')]/li/span"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@id,'dropDownNoneType-listbox-id')]/li/span"))));
            List<WebElement> Options=driver.findElements(By.xpath("//ul[contains(@id,'dropDownNoneType-listbox-id')]/li/span"));
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//label[contains(text(),'Day of week')]/following-sibling::span[contains(@class,'k-dropdownlist')]/button",1000);
            if (HelpersMethod.IsExists("//label[contains(text(),'Day of week')]/following-sibling::span[contains(@class,'k-dropdownlist')]/button",driver))
            {
                HelpersMethod.ActClick(driver,DayOfWeek,1000);
            }
            else
            {scenario.log("DAY OF WEEK DROP DOWN IS NOT VISIBLE");}
        }
        catch(Exception e){}
    }

    public String SelectDayOfWeek()
    {
        Actions act1=new Actions(driver);
        String wday;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@class='k-list-content']/ul[@id='dropDownNoneType-listbox-id']/li",20000);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='k-list-content']/ul[@id='dropDownNoneType-listbox-id']/li/span"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-list-content']/ul[@id='dropDownNoneType-listbox-id']/li/span")));

            List<WebElement> WeekDays=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-list-content']/ul[@id='dropDownNoneType-listbox-id']/li/span");
            for(WebElement weekDay:WeekDays)
            {
                act1.moveToElement(weekDay).build().perform();
                wday=weekDay.getText();
                if(wday.equals(DOfWeek))
                {
                    act1.moveToElement(weekDay).build().perform();
                    act1.click(weekDay).build().perform();
                    weekDay.sendKeys(Keys.TAB);
                    scenario.log("DAY OF WEEK SELECTED IS "+DOfWeek);
                    break;
                }
                else
                {
                    act1.moveToElement(weekDay).sendKeys(Keys.ARROW_DOWN).build().perform();
                }
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("web-order-page-content"))));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("web-order-page-content")));
        }
        catch (Exception e){}
        return DOfWeek;
    }

    public String ValidateWeekOfDay()
    {
        String DayWeek=null;
        try
        {
            HelpersMethod.WaitElementPresent(driver,"xpath","//label[contains(text(),'Day of week')]",10000);
            WebElement DWeek=HelpersMethod.FindByElement(driver,"xpath","//label[contains(text(),'Day of week')]/following-sibling::span/descendant::span[@class='k-input-value-text']");
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//span[contains(text(),'Customer allocation')]",10000);
            WebElement AlloCust=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Customer allocation')]");
            HelpersMethod.ActClick(driver,AlloCust,10000);
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@class='additional-accounts-grid']",10000);
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@class='quickEntry']/following-sibling::div/div[@class='additional-accounts-grid']",1000);
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::input",10000);
            WebElement CheckBox=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::input");
            HelpersMethod.ClickBut(driver,CheckBox,1000);
        }
        catch (Exception e){}
    }

    //Code to click on Delete button to remove customer allocation
    public void ClickOnDelete()
    {
        try
        {
            WebElement DelCust=HelpersMethod.FindByElement(driver,"xpath","//button[@id='buttonDelete']");
            HelpersMethod.ActClick(driver,DelCust,1000);
        }
        catch (Exception e){}
    }

    //Code to handle confirmation popup for deleting customer allocation
    public void CustomerAllocationDeletePopup()
    {
        WebElement WebEle;
        exists=true;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Remove customer allocation')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
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
            exists=HelpersMethod.IsExists("//div[@class='i-grid']/descendant::div[contains(text(),'No data available')]",driver);
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
            HelpersMethod.ActClick(driver,PlusAdd,1000);
            exists=true;
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative ')]/descendant::ul/li/span")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DropDownAcc(String CustAlloc)
    {
        try
        {
            //HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-animation-container-shown')]/descendant::ul/li/span","xpath",CustAlloc);
            Actions act=new Actions(driver);
            int i = 0;
            List<WebElement> ListItems =HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container-shown')]/descendant::ul/li/span");
            for (WebElement ListItem : ListItems)
            {
                i++;
                String List_Item_value = ListItem.getText();
                act.moveToElement(ListItem).build().perform();
                if (List_Item_value.equalsIgnoreCase(CustAlloc) || List_Item_value.contains(CustAlloc.toLowerCase()))
                {
                    act.moveToElement(ListItem).build().perform();
                    act.click(ListItem).build().perform();
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        }
        catch (Exception e){}
    }

    //Code to handle popup that appears after Plus button, Enter Account# in search box and select the account#
    public boolean PopupHandle()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
            {
                //Code to enter Customer allocation, and click on Index
                WebElement SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::input[@id='SearchBox1']");
                HelpersMethod.EnterText(driver,SearchBox,10000,TestBase.testEnvironment.get_AnotherAcc());
                SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
                HelpersMethod.ActClick(driver,SearchBox,10000);
                if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::tr[@class='k-grid-norecords']",driver))
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
            SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td[2]");
            scenario.log("ACCOUNT NUMBER SELECTED IS "+SearchBox.getText());
            SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::input[contains(@class,'k-checkbox')]");
            HelpersMethod.ActClick(driver,SearchBox,10000);
            SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td[2]");
            scenario.log("ACCOUNT NUMBER SELECTED IS "+SearchBox.getText());
            WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
            HelpersMethod.ClickBut(driver,okButton,10000);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        }
        catch (Exception e){}
    }

    //Code to verify whether account has been selected or not
    public boolean ValidateCustSelect()
    {
        exists=false;
        try
        {
            exists=HelpersMethod.IsExists("//table[@class='k-grid-table']/descendant::tr[contains(@class,'k-master-row')]",driver);
        }
        catch (Exception e){}
        return  exists;
    }

    //Code to validate catalog display
    public void ValidateCatalogDisplay()
    {
        try
        {
            exists=false;
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

            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("CATALOG DIALOG BOX DISPLAYED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to add multiple products to OG through Catalog
    public void AddFromCatalog(List<String> Prods) throws InterruptedException
    {
        WebElement WebEle;
        WebElement catalogPopup;
        String status;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-grid']",driver))
        {
//            List<WebElement> filters=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]");
//            if(filters.size()>1)
//            {
//                //Click on 'Add filter'
//                catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
//                WebEle= catalogPopup.findElement(By.xpath(".//span[text()='Add filter']/ancestor::button/span[contains(@class,'i-filter-tag__main')]"));
//                HelpersMethod.JScriptClick(driver,WebEle,100000);
//
//                 status=HelpersMethod.returnDocumentStatus(driver);
//                 if (status.equals("loading"))
//                 {
//                     HelpersMethod.waitTillLoadingPage(driver);
//                 }
//
//                //Click on clear all
//                if(HelpersMethod.IsExists("//button/span[contains(text(),'Clear all')]",driver))
//                {
//                    status = HelpersMethod.returnDocumentStatus(driver);
//                    if (status.equals("loading"))
//                    {
//                        HelpersMethod.waitTillLoadingPage(driver);
//                    }
//                    //Click on Clear all button
//                    WebElement clearAll = driver.findElement(By.xpath("//button/span[contains(text(),'Clear all')]"));
//                    if (clearAll.isDisplayed() && clearAll.isEnabled())
//                    {
//                        HelpersMethod.JScriptClick(driver, clearAll, 100000);
//
//                        status = HelpersMethod.returnDocumentStatus(driver);
//                        if (status.equals("loading"))
//                        {
//                            HelpersMethod.waitTillLoadingPage(driver);
//                        }
//                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
//                        {
//                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
//                        }
//
//                        status = HelpersMethod.returnDocumentStatus(driver);
//                        if (status.equals("loading"))
//                        {
//                            HelpersMethod.waitTillLoadingPage(driver);
//                        }
//                        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add filter']/ancestor::button/span[contains(@class,'i-filter-tag__main')]"))));
//                    }
//                }
//            }

            //Click on Add filter again
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]"))));
            catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
            WebEle = catalogPopup.findElement(By.xpath(".//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"));
            HelpersMethod.ActClick(driver, WebEle, 10000);

            //Enter value in 1st input
            WebElement fistSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
            HelpersMethod.EnterText(driver, fistSearch, 10000, "Product #");

            //Click on check box
            WebElement checkBox = HelpersMethod.FindByElement(driver, "id", "ProductNumber");
            HelpersMethod.ActClick(driver, checkBox, 10000);

            Thread.sleep(1000);
            //Click on Apply button
            WebElement applyButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container-shown')]/descendant::button/span[text()='Apply']");
            HelpersMethod.ActClick(driver, applyButton, 10000);

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

            //Enter product numbers to be searched
            for(int j=0;j<=Prods.size()-1;j++)
            {
                //click on filter option button
                catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement searchOption =catalogPopup.findElement(By.xpath(".//span[contains(text(),'Product')]/ancestor::button/span[contains(@class,'i-filter-tag__main')]"));
                HelpersMethod.JScriptClick(driver,searchOption,20000);

                WebElement secondSearch=HelpersMethod.FindByElement(driver,"xpath","//form[contains(@class,'i-filter-popup i-filter-popup--text')]/descendant::input[contains(@class,'k-input k-input-md k-rounded-md k-input-solid')]");
                HelpersMethod.EnterText(driver,secondSearch,20000,Prods.get(j));
                //Click on Apply button
                applyButton=HelpersMethod.FindByElement(driver,"xpath","//form[contains(@class,'i-filter-popup i-filter-popup--text')]/descendant::button/span[text()='Apply']");
                HelpersMethod.JScriptClick(driver,applyButton,20000);
                status=HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
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
            WebElement ResetFilter= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button[contains(@data-test-id,'productFilterResetBtn')]");
            HelpersMethod.ActClick(driver,ResetFilter,10000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            //Code to handle if catalog is displaying in card view
            for (int i = 0; i < Prods.size() - 1; i++)
            {
                SearchBar = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::input[contains(@placeholder,'Search products')]");
                SearchIndex = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M15.5')]");

                SearchClear=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::span[@id='searchBarClearBtn']/*[local-name()='svg']");
                HelpersMethod.ActClick(driver,SearchClear,10000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                HelpersMethod.ActSendKey(driver,SearchBar,10000,Prods.get(i));
                HelpersMethod.ActClick(driver,SearchIndex,10000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }

                if (HelpersMethod.IsExists("//div[@id='no-products-found']", driver))
                {
                    scenario.log("SORRY PRODUCT WITH # " + Prods.get(i) + " DOESN'T EXISTS");
                    WebElement Close_But = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M17')]");
                    HelpersMethod.ActClick(driver,Close_But,1000);
                }
                else
                {
                    scenario.log("PRODUCT # " + Prods.get(i) + " HAS BEEN ADDED TO OG");
                    HelpersMethod.ActScroll(driver, HelpersMethod.FindByElement(driver, "xpath", "//button/span[text()='Select']"),200);
                    SelectBut = HelpersMethod.FindByElement(driver, "xpath", "//button/span[text()='Select']");
                    HelpersMethod.ActClick(driver,SelectBut, 1000);
                }
            }
        }
        catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
        WebEle= catalogPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
        HelpersMethod.JScriptClick(driver,WebEle,80000);
        new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]")));
        Thread.sleep(1000);
    }

    public void PrintOG() throws InterruptedException
    {
        exists=false;
        if(PrintBut.isDisplayed() && PrintBut.isEnabled())
        {
            HelpersMethod.ScrollElement(driver, PrintBut);
            String ParentWindow = driver.getWindowHandle();
            HelpersMethod.ClickBut(driver, PrintBut, 1000);
            Thread.sleep(4000);

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Thread.sleep(6000);
            Set<String> allWindows = driver.getWindowHandles();
            if(allWindows.size()>1)
            {
                for (String handle : allWindows)
                {
                    if (!handle.equals(ParentWindow))
                    {
                        driver.switchTo().window(handle);
                        String url = driver.getCurrentUrl();
                        scenario.log("Closing window with URL: " + url);
                        Thread.sleep(500);
                        // Use JavaScript to force-close the window
                        ((JavascriptExecutor) driver).executeScript("window.close();");
                        Thread.sleep(1000);
                        exists=true;
                        Thread.sleep(1000);
                    }
                }
            }
            Thread.sleep(1000);
            // Switch back to the parent window
            driver.switchTo().window(ParentWindow);
            scenario.log("YOU ARE IN MAIN WINDOW");
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
        WebElement WebEle;
        Actions act1= new Actions(driver);
        try
        {
            // to fetch the web element of the modal container
            List<WebElement> Options = HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-animation-container k-animation-container-shown']/descendant::li/descendant::span[@class='k-menu-link-text']");
            for (int i = 0; i <= Options.size() - 1; i++)
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
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void SubCustomerRefLocalChain(String arg0,String arg1)
    {
        exists = false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]", driver))
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'i-no-data__message')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    scenario.log("<span style='color:red'>THERE ARE NO SUB REFERENCE FOUND IN DIALOG BOX</span>");
                }
                else
                {
                    WebElement SubRef = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td[contains(text(),'"+arg0+"')]|//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td[contains(text(),'"+arg1+"')]");
                    HelpersMethod.ActClick(driver, SubRef, 10000);
                    exists = true;
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ListProductsImported()
    {
        exists=false;
        WebElement WebEle;
        String Prod_Text="";
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-grid-container')]");
            HelpersMethod.ScrollElement(driver, WebEle);

            List<WebElement> Prods = HelpersMethod.FindByElements(driver, "xpath", "//button[@class='i-link-button ']//button[@class='i-link-button ']");
            for (WebElement Prod : Prods)
            {
                Prod_Text = Prod.getText();
                scenario.log("PRODUCT NO. IN IMPORTED FILE IS " + Prod_Text);
            }
            exists = true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void ValidateNoProductsInGrid()
    {
        exists=false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[@class='k-grid-norecords']",driver))
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
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        HelpersMethod.ClickBut(driver, OGCancel, 10000);
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
    }

    public void clickOnAllCustomerCheckBox() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,AllCustCheckbox,10000);
        //HelpersMethod.WaitElementPresent(driver,"xpath","//dif[contains(text(),'Remove customer allocation')]/ancestor::div[contains(@class,'k-window k-dialog')]",200);
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
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-window k-dialog')]",400);
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Remove customer allocation", "Verify Title message");
        //Click on Yes in "Remove customer allocation" Popup
        WebElement yesButton=modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
        HelpersMethod.ClickBut(driver,yesButton,10000);
    }

    public void validateNonExistanceOfCustomerAllocationTab()
    {
        String Tab_text="";
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
        try
        {
            if (HelpersMethod.IsExists("//span[contains(text(),'chain')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                if(!HelpersMethod.IsExists("//div[contains(text(),'No data available')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement selectChain = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]");
                    HelpersMethod.ActClick(driver, selectChain, 10000);
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                else
                {
                    scenario.log("<span style='color:red'>NO DATA IS AVAILABLE FOR SELECTING SUB REFERENCE TYPE</span>");
                }
            }
        }
        catch (Exception e){}
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

            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("card1"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("card1")));

            Thread.sleep(2000);
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//label[text()='Customer reference']/following-sibling::input");
            String cRef=HelpersMethod.JSGetValueEle(driver,WebEle,10000);
            if(cRef.equals(custRef))
            {
                scenario.log(cRef+" CUSTOMER REFERENCE HAS BEEN FOUND");
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
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='bottomDetailCard']"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bottomDetailCard']")));

            WebElement bottomGrid=HelpersMethod.FindByElement(driver,"xpath","//div[@class='bottomDetailCard']");
            HelpersMethod.ScrollElement(driver,bottomGrid);
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
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
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
                HelpersMethod.ActClick(driver, Status, 10000);
                new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
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
            List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-list-content']/descendant::ul/li/span");
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
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        }
        catch (Exception e){}
    }

    public void validateOGTypeDropDown()
    {
        exists=false;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@id,'dropDownNoneType-listbox-id')]/li/span")));
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@id,'dropDownNoneType-listbox-id')]/li/span")));
            if(HelpersMethod.IsExists("//ul[contains(@id,'dropDownNoneType-listbox-id')]/li/span",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateSavePopup()
    {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }

        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Order guides saved')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                // to fetch the web element of the modal container
                WebElement saveConfirm = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));


            }
        }
        catch (Exception e){}
    }

    public void clickOnOk()
    {
        try
        {
            WebElement WebEle;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            if (HelpersMethod.IsExists("//div[contains(text(),'Order guides saved')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Order guides saved')]/ancestor::div[contains(@class,'k-window k-dialog')]"));
                WebElement PopupOk=modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver,PopupOk,100000);
                //to handle loading icon
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

                scenario.log("OG HAS BEEN SAVED");
            }
            else
            {
                if(HelpersMethod.IsExists("//div[contains(text(),'An order guide already exists with this code')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    scenario.log("OG CANN'T BE SAVED WITH GIVEN DESCRIPTION, START DATE AND END DATE");
                    WebElement PopupOk=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ActClick(driver,PopupOk,10000);
                    scenario.log("CANN'T CREATE MULTIPLE OG FOR SAME DATE");
                }
                //Assert.assertEquals(exists, true);
            }
        }
        catch (Exception e){}
    }

    public void ListView()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            String Prods = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                //Click on Add filter again
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]"))));
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]"))));
                WebElement catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebEle = catalogPopup.findElement(By.xpath(".//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"));
                HelpersMethod.ActClick(driver, WebEle, 10000);

                //Enter value in 1st input
                WebElement fistSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
                HelpersMethod.EnterText(driver, fistSearch, 10000, "Product #");

                //Click on check box
                WebElement checkBox = HelpersMethod.FindByElement(driver, "id", "ProductNumber");
                HelpersMethod.ActClick(driver, checkBox, 10000);

                Thread.sleep(1000);
                WebElement secondSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container-shown')]/descendant::input[@class='k-input k-input-md k-rounded-md k-input-solid']");
                HelpersMethod.EnterText(driver, secondSearch, 20000, Prods);
                //HelpersMethod.JSSetValueEle(driver,secondSearch,20000,Prods);

                //Click on Apply button
                WebElement applyButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container-shown')]/descendant::button/span[text()='Apply']");
                HelpersMethod.ActClick(driver, applyButton, 10000);

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

                if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]",driver))
                {
                    //Select the product from catalog
                    WebElement prod = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]");
                    HelpersMethod.ScrollTillElementVisible(driver, prod);
                    HelpersMethod.ActClick(driver, prod, 10000);
                    scenario.log("PRODUCT FOUND IN CATALOG IS " + Prods);
                    exists=true;
                }
                else
                {
                    scenario.log("SEARCHED PRODUCT HAS NOT BEEN FOUND IN CATALOG");
                }
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ListViewPriceBase()
    {
        exists = false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            //String Prods = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                //to load all the products in catalog
                if (HelpersMethod.IsExists("//span[contains(text(),'load all products')]", driver))
                {
                    WebElement loadProducts = HelpersMethod.FindByElement(driver, "xapth", "//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver, loadProducts, 10000);
                }

                //Click on Add filter again
              /*  new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]"))));
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]"))));
                WebElement catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebEle = catalogPopup.findElement(By.xpath(".//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"));
                HelpersMethod.ActClick(driver, WebEle, 2000);

                //Enter value in 1st input
                WebElement fistSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
                HelpersMethod.EnterText(driver, fistSearch, 1000, "Product #");
                //Click on check box
                WebElement checkBox = HelpersMethod.FindByElement(driver, "id", "ProductNumber");
                HelpersMethod.ActClick(driver, checkBox, 1000);

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }

                WebElement secondSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'k-textbox')]");
                HelpersMethod.EnterText(driver, secondSearch, 1000, Prods);
                //Click on Apply button
                WebElement applyButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::button/span[text()='Apply']");
                HelpersMethod.ActClick(driver, applyButton, 1000);

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
                }*/

                if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]",driver))
                {
                    //Select the product from catalog
                    WebElement prod = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]");
                    HelpersMethod.ScrollTillElementVisible(driver, prod);
                    HelpersMethod.ActClick(driver, prod, 10000);
                    //scenario.log("PRODUCT FOUND IN CATALOG IS " + Prods);
                    exists=true;
                }
                else
                {
                    scenario.log("SEARCHED PRODUCT HAS NOT BEEN FOUND IN CATALOG");
                }
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void cardView()
    {
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            String Prods = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
            //enter product number in input box
            WebElement inputBox = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
            HelpersMethod.EnterText(driver,inputBox,10000,Prods);
            //Click on search icon
            WebElement  searchIcon = HelpersMethod.FindByElement(driver, "xpath", "//span[@datatestid='searchBarSearchBtn']//*[local-name()='svg']");
            HelpersMethod.ActClick(driver, searchIcon, 10000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            if(HelpersMethod.IsExists("//div[@class='grid-item-box-item']",driver))
            {
                //add product to standing order
                WebElement selectButton = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item']/descendant::button/span[text()='Select']");
                HelpersMethod.ScrollElement(driver, selectButton);
                HelpersMethod.ClickBut(driver, selectButton, 10000);
                scenario.log("PRODUCT FOUND IN CATALOG IS " + Prods);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            else
            {
                scenario.log("SEARCHED PRODUCT HAS NOT BEEN FOUND IN CATALOG");
            }

            //Click on 'x' button in catalog
            WebElement clearButton = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='searchBarClearBtn']");
            HelpersMethod.ScrollElement(driver,clearButton);
            act.moveToElement(clearButton).click().build().perform();
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        }
        catch (Exception e){}
    }

    public void cardViewPriceBase()
    {
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[@class='grid-item-box'][1]",driver))
            {
                WebElement selectButton = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box'][1]/descendant::button/span[text()='Select']");
                HelpersMethod.ScrollElement(driver, selectButton);
                HelpersMethod.ClickBut(driver, selectButton, 10000);
                //scenario.log("PRODUCT FOUND IN CATALOG IS " + Prods);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            else
            {
                scenario.log("SEARCHED PRODUCT HAS NOT BEEN FOUND IN CATALOG");
            }
        }
        catch (Exception e){}
    }

    public void validateNewOGPage()
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

            if(HelpersMethod.IsExists("//div[contains(@class,'moduleNameHeader')]/descendant::span[contains(text(),'New order guide')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCustomerIndexPopup()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]", driver))
            {
                scenario.log("CUSTOMER INDEX POPUP APPEARED,TO SELECT CUSTOMER ACCOUNT");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnCustomerAccountIndexOk()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement custAccPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=custAccPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,10000);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        }
        catch (Exception e){}
    }

    public void SelectHistoricalFromDropDown(String hist)
    {
        exists=false;
        Actions act=new Actions(driver);
        String ogTypeText=null;
        WebElement ogtype;
        try
        {
            Thread.sleep(500);
            //new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@id,'dropDownNoneType-listbox-id')]/li/span/span")));
            List<WebElement> ogTypes=HelpersMethod.FindByElements(driver,"xpath","//ul[contains(@id,'dropDownNoneType-listbox-id')]/li/span");
            for(int i=0;i<=ogTypes.size()-1;i++)
            {
                ogtype=ogTypes.get(i);
                act.moveToElement(ogtype).build().perform();
                ogTypeText=ogtype.getText();
                if(hist.equals(ogTypeText))
                {
                    act.moveToElement(ogtype).build().perform();
                    act.click(ogtype).build().perform();
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void FindtableHeader(String tableHead)
    {
        exists=false;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        try
        {
            WebElement gridHeader=HelpersMethod.FindByElement(driver,"xpath","//div[@class='bottomDetailCard']");
            HelpersMethod.ScrollElement(driver,gridHeader);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-grouping-drop-container')]",driver))
            {
                List<WebElement> TableHeads=driver.findElements(By.xpath("//thead/tr[1]/th/descendant::span[@class='k-column-title']"));
                for(WebElement THead:TableHeads)
                {
                    String Head=THead.getText();
                    if(Head.contains(tableHead))
                    {
                        Thread.sleep(1000);
                        HelpersMethod.ActDragDrop(driver,THead,To);
                        exists=true;
                    }
                }
            }
            else
            {
                scenario.log("DRAG AND DROP HEADER MAY NOT BE ENABLED, CHECK ADMIN SETTINGS");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DisplayGroupDetails()
    {
        try
        {
            List<WebElement> Groups=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-grouping-row')]/td[@role='gridcell']/span");
            for(WebElement group:Groups)
            {
                String groupValue=group.getText();
                scenario.log("GROUP VALUE CONTAINS "+groupValue);
            }
        }
        catch (Exception e){}
    }

    public void validateProductInCatalog()
    {
        exists=false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]"))));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Thread.sleep(2000);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-no-data__message')]| //div[contains(@class,'k-window k-dialog')]/descendant::div[contains(text(),'Sorry, no products found.')]",driver))
            {
               scenario.log("<span style='color:red'> NO PRODUCT FOUND IN CATALOG </span>");
               exists=false;
            }
            else
            {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("PRODUCTS FOUND IN CATALOG");
                exists=true;
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ResetFilter_Catalog()
    {
        exists=false;
        WebElement WebEle;

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]")));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]")));

            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
                {
                    WebElement loadProduct = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver, loadProduct, 10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    exists=true;
                }

                    if(HelpersMethod.IsExists("//div[@class='product-catalog-container']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='productFilterResetBtn']");
                        HelpersMethod.ClickBut(driver, WebEle, 10000);
                        exists = true;
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
                    }
                    else if (HelpersMethod.IsExists("//div[contains(@class,'product-catalog-container catalog-search-grid-view')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(600))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                        if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]", driver))
                        {
                            List<WebElement> filters = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]");
                            if (filters.size() > 1)
                            {
                                //Click on 'Add filter'
                                WebElement catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                                WebEle = catalogPopup.findElement(By.xpath(".//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"));
                                HelpersMethod.JScriptClick(driver, WebEle, 100000);

                                status = HelpersMethod.returnDocumentStatus(driver);
                                if (status.equals("loading"))
                                {
                                    HelpersMethod.waitTillLoadingPage(driver);
                                }

                                //Click on clear all
                                if (HelpersMethod.IsExists("//button/span[contains(text(),'Clear all')]", driver))
                                {
                                    status = HelpersMethod.returnDocumentStatus(driver);
                                    if (status.equals("loading"))
                                    {
                                        HelpersMethod.waitTillLoadingPage(driver);
                                    }
                                    //Click on Clear all button
                                    WebElement clearAll = driver.findElement(By.xpath("//button/span[contains(text(),'Clear all')]"));
                                    HelpersMethod.JScriptClick(driver, clearAll, 100000);
                                    exists = true;
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
                                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"))));
                                }
                            }
                        }
                    }
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Thread.sleep(2000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnGridHeaderForArrowDisplay()
    {
        exists=false;
        int i=0;
        String headText=null;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> gridHeaders=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for (WebElement gridHeader:gridHeaders)
            {
                i++;
                act.moveToElement(gridHeader).build().perform();
                headText=gridHeader.getText();
                if(headText.equalsIgnoreCase("Sequence"))
                {
                    WebElement seqHead=HelpersMethod.FindByElement(driver,"xpath","//th["+i+"]/descendant::span[contains(@class,'k-column-title')]");
                    act.moveToElement(seqHead).build().perform();
                    act.click().build().perform();
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }


    public void clickonArrowOfSeqeuence()
    {
        exists=false;
        int i=0;
        String headText=null;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> gridHeaders=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for (WebElement gridHeader:gridHeaders)
            {
                i++;
                act.moveToElement(gridHeader).build().perform();
                headText=gridHeader.getText();
                if(headText.equalsIgnoreCase("Sequence"))
                {
                    WebElement seqHead=HelpersMethod.FindByElement(driver,"xpath","//th["+i+"]/descendant::span[contains(@class,'k-icon k-i-sort')]");
                    act.moveToElement(seqHead).build().perform();
                    act.click().build().perform();
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void displaySequenceValueForFirstTime()
    {
        exists=false;
        int i=0;
        String headText=null;
        String seqText=null;
        Actions act=new Actions(driver);
        try
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

            List<WebElement> gridHeaders=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for (WebElement gridHeader:gridHeaders)
            {
                i++;
                act.moveToElement(gridHeader).build().perform();
                headText=gridHeader.getText();
                if(headText.equalsIgnoreCase("Sequence"))
                {
                    break;
                }
            }
            List<WebElement> sequences=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td["+(i+1)+"]");
            for (WebElement seq:sequences)
            {
                act.moveToElement(seq).build().perform();
                seqText=seq.getText();
                sequence1.add(seqText);
                scenario.log("VALUE FOUND FOR SEQUENCE "+seqText);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void displaySequenceValueForSecondTime()
    {
        exists=false;
        int i=0;
        String headText=null;
        String seqText=null;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> gridHeaders=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for (WebElement gridHeader:gridHeaders)
            {
                i++;
                act.moveToElement(gridHeader).build().perform();
                headText=gridHeader.getText();
                if(headText.equalsIgnoreCase("Sequence"))
                {
                    break;
                }
            }
            List<WebElement> sequences=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td["+(i+1)+"]");
            for (WebElement seq:sequences)
            {
                act.moveToElement(seq).build().perform();
                seqText=seq.getText();
                sequence2.add(seqText);
                scenario.log("VALUE FOUND FOR SEQUENCE "+seqText);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void compareSequenceNosFound()
    {
        exists=false;
        try
        {
            if(sequence1.size()== sequence2.size())
            {
                Collections.sort(sequence1);
                Collections.sort(sequence2);
                if(sequence1.equals(sequence2))
                {
                    scenario.log("SEQUNCE FOUND BEFORE "+sequence1+" "+"SEQUNCE FOUND AFTER CLICKING ARROW "+sequence2);
                    exists=true;
                }
                //To zoom out browser by 100%
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
            }
            else
            {
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectAllProducts()
    {
        Actions act=new Actions(driver);
        String dropText;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Thread.sleep(1000);
            if(HelpersMethod.IsExists("//span[@id='CPQoh-accessibility-id']",driver))
            {
                if(!HelpersMethod.IsExists("//span[@id='CPQoh-accessibility-id']/span[text()='Show all products']|//span[@id='CPQoh-accessibility-id']/span[text()='All Products']",driver))
                {
                    WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='CPQoh-accessibility-id']/following-sibling::button");
                    HelpersMethod.ClickBut(driver, dropDown, 10000);
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']"))));
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']")));
                    List<WebElement> dropDowns = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']");
                    for (WebElement dropDow : dropDowns)
                    {
                        act.moveToElement(dropDown).build().perform();
                        dropText = dropDow.getText();
                        if (dropText.equalsIgnoreCase("Show all products") || dropText.equalsIgnoreCase("All Products"))
                        {
                            act.moveToElement(dropDow).build().perform();
                            act.click(dropDow).build().perform();
                            break;
                        }
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
                    Thread.sleep(1000);
                }

                if(HelpersMethod.IsExists("//span[@id='CPQoh-accessibility-id']/span[text()='Show all products']|//span[@id='CPQoh-accessibility-id']/span[text()='All Products']",driver))
                {
                    exists=true;
                }
                else
                {
                    exists=false;
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }

    public void clickLoadAllProducts()
    {
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                WebElement loadProd=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
                HelpersMethod.ActClick(driver,loadProd,10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void clickPriceingCustomer()
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

            if(HelpersMethod.IsExists("//label[text()='Pricing customer']/following-sibling::span/button",driver))
            {
                WebElement pricingCustomer=HelpersMethod.FindByElement(driver,"xpath","//label[text()='Pricing customer']/following-sibling::span/button");
                HelpersMethod.ClickBut(driver,pricingCustomer,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectPricingCustomer(String priceCust)
    {
        exists=false;
        Actions act=new Actions(driver);
        String custPringText;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@id,'dropDownNoneType')]/descendant::span[contains(@class,'list-item-text')]"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@id,'dropDownNoneType')]/descendant::span[contains(@class,'list-item-text')]")));
            List<WebElement>  custPrings=HelpersMethod.FindByElements(driver,"xpath","//ul[contains(@id,'dropDownNoneType')]/descendant::span[contains(@class,'list-item-text')]");
            for(WebElement custPricing:custPrings)
            {
                act.moveToElement(custPricing).build().perform();
                custPringText=custPricing.getText();
                if(custPringText.contains(priceCust))
                {
                    act.moveToElement(custPricing).build().perform();
                    act.click(custPricing).build().perform();
                    exists=true;
                   break;
                }
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void handleChangePricingCustomer()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(HelpersMethod.IsExists("//span[contains(text(),'Change pricing customer')]/ancestor::div[@class='k-window k-dialog']",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']");
                WebElement yesButton=modelContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                HelpersMethod.ActClick(driver,yesButton,10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void validatePricingCustomer(String priceCust)
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String TextCustPricing=HelpersMethod.FindByElement(driver,"xpath","//label[text()='Pricing customer']/following-sibling::span/descendant::span[@class='k-input-value-text']").getText();
            if(TextCustPricing.contains(priceCust))
            {
               exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}