package pages_DSD_OMS.orderEntry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.TestBase;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class NewOrderEntryPage
{
    /* Created by Divya.Ramadas@afsi.com */

    WebDriver driver;
    Scenario scenario;

    @FindBy(xpath = "//div[contains(@class,'search-bar-container')]/descendant::input[@placeholder='Search products']")
    private WebElement SearchProd;

    @FindBy(id="pickupOrder")
    private WebElement PickupOrder;

    @FindBy(id = "quickProduct")
    private WebElement QuickPro;

    @FindBy(id="quickEntryUMs")
    private WebElement UOMs;

    @FindBy(id = "quickCases")
    private WebElement QuickCase;

    @FindBy(id = "quickUnits")
    private WebElement QuickUnit;

    @FindBy(xpath = "//div[contains(@class,'search-bar-container')]/descendant::span[contains(@class,'search-button-addon')]")
    private WebElement IndexSearch;

    @FindBy(id = "poNumber")
    private WebElement PO_No;

    @FindBy(id = "submitOrderButton")
    private WebElement Next_But;

    @FindBy(id = "cancelOrderButton")
    private WebElement Cancel_But;

    @FindBy(id = "backButton")
    private WebElement Back_But;

    @FindBy(id="skipButton")
    private WebElement SkipButton;

    @FindBy(id="orderEntryCard")
    private WebElement OePage;

    @FindBy(xpath="//input[1][contains(@id,'TotalUnitsCol')]")
    private WebElement UnitInput;

    @FindBy(xpath="//input[1][contains(@id,'TotalCasesCol')]")
    private WebElement CaseInput;

    @FindBy(xpath="//button[contains(text(),'Copy from')]")
    private WebElement CopyFrom;

    @FindBy(xpath="//button[contains(text(),'Add product')]")
    private WebElement AddProduct;

    @FindBy(id="PrintButton")
    private  WebElement PrintBut;

    @FindBy(xpath = "//button[text()='Comments']")
    private WebElement Ord_Comments;

    @FindBy(xpath = "//tr[1]/descendant::div[contains(@id,'OrderLineCommentIconColIcon')]")
    private WebElement Prod_Comments;

    @FindBy(xpath = "//button[text()='Export']")
    private WebElement Export_but;

    @FindBy(xpath = "//label[text()='Import']")
    private  WebElement Import_but;

    @FindBy(xpath = "//input[@id='ImportOrder']")
    private WebElement Import_Input;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]")
    private WebElement To;

    @FindBy(xpath = "//label[contains(text(),'Product total')]/following-sibling::label")
    private  WebElement Total_amt;

    @FindBy(id = "RouteIndex")
    private  WebElement Route1;

    @FindBy(xpath = "//div[contains(@class,'order-header-separator-row')]")
    private WebElement Separator;

    @FindBy(id="filterByQuantities")
    private WebElement ShowAllProd;

    @FindBy(xpath = "//span[contains(text(),'Route #')]/parent::div/descendant::button")
    private WebElement Route_No;

    @FindBy(xpath = "//input[contains(@placeholder,'Route #')]")
    private WebElement RouteInput;

    @FindBy(xpath="//button[@data-test-id='grid-selection']")
    private WebElement gridType;

    static boolean exists = false;
    static String XPath = null;
    static String Order_No=null;
    static String Actual_Order=null;
    static String No_Prod=null;


    public NewOrderEntryPage(WebDriver driver, Scenario scenario) throws InterruptedException, AWTException
    {
        this.scenario=scenario;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions
    public boolean ValidateNewOE()
    {
        exists=false;
        WebElement WebEle=null;
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
        try
        {
           if(HelpersMethod.IsExists("//div[contains(@class,'order-entry-page')]",driver))
           {
                scenario.log("NEW ORDER ENTRY PAGE HAS BEEN FOUND");
                exists=true;
           }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    public boolean ValidateNewOEAllOrder() throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        Thread.sleep(5000);
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500000);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'order-entry-page')]",driver))
            {
                scenario.log("NEW ORDER ENTRY PAGE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    public boolean ValidateNewOE1()
    {
        WebElement WebEle=null;
        exists=false;
        String status=null;
        for(int i=0;i<=2;i++)
        {
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
        }
        try
        {
           if(HelpersMethod.IsExists("//label[contains(text(),'Order # ')]",driver))
           {
               scenario.log("NEW ORDER ENTRY PAGE HAS BEEN FOUND");
               exists=true;
           }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    public void EnterPO_No(String PO_Num) throws InterruptedException
    {
        WebElement WebEle=null;
        exists=false;

        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
        }
        try
        {
            new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("orderEntryCard"))));
            new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.textToBePresentInElementLocated(By.id("poNumber-label"), "PO #"));
            if (PO_No.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, PO_No);
                HelpersMethod.ActClearKey(driver, PO_No, 100);
                HelpersMethod.ActSendKey(driver, PO_No, 100, PO_Num);
                new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("orderEntryCard"))));
                scenario.log("PO# ENTERED IS " + PO_Num);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void Click_Back_Pending()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExistsById("orderEntryCard",driver))
            {
                if(Back_But.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver,Back_But);
                    HelpersMethod.ClickBut(driver, Back_But, 80);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='order-search-page']",driver))
                {
                    Assert.assertEquals(exists, true);
                }
            }
        }
        catch (Exception e){}
    }

    public void Click_Back_But()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExistsById("orderEntryCard",driver))
            {
                if(Back_But.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver,Back_But);
                    HelpersMethod.ClickBut(driver, Back_But, 80);
                    if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to leave this page?')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Discard all')]");
                        HelpersMethod.ClickBut(driver,WebEle,20);
                    }
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='order-search-page']",driver))
                {
                    exists=true;
                    Assert.assertEquals(exists, true);
                }
            }
        }
        catch (Exception e){}
    }

    public void Click_Back_But_NextButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExistsById("orderEntryCard",driver))
            {
                if(Back_But.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver,Back_But);
                    HelpersMethod.ClickBut(driver, Back_But, 80);
                    if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to leave this page?')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                        Assert.assertEquals(modalContentTitle.getText(), "Your order has not been submitted. Are you sure you want to leave this page?", "Verify Title message");
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void Create_Pending_Order_Popup()
    {
        WebElement WebEle=null;
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement pendingOrderPopup =HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");

                WebElement startOrder=pendingOrderPopup.findElement(By.xpath(".//button[contains(text(),'without submitting')]"));
                HelpersMethod.ClickBut(driver,startOrder,80);
                scenario.log("PENDING ORDER WITH OUT SUBMITTING OPTION HAS BEEN SELECTED");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
            }
        }
        catch (Exception e){}
    }

    public void Discard_All_Pending_Order()
    {
        exists=false;
        try
        {
            exists = HelpersMethod.EleDisplay(driver.findElement(By.xpath("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'without submitting')]")));
            if (exists == true)
            {
                WebElement Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Discard all')]");
                HelpersMethod.ClickBut(driver,Button_Ele,40);
                scenario.log("DISCARD ALL PENDING ORDER OPTION IS SELECTED");
            }
        }
        catch (Exception e){}
    }

    public void EnterProdNo_InSearchBar(String Product)
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver, SearchProd);
            HelpersMethod.sendKeys(driver,SearchProd,40,Product);
            HelpersMethod.ClickBut(driver,IndexSearch,100);
            exists=true;
            scenario.log("PRODUCT SEARCHED USING SEARCH BAR IS "+Product);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void CheckForCatalog()
    {
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",1000);
                WebElement catlogPopup = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement modalContentTitle = catlogPopup.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Catalog", "Verify Title message");
            }
        }
        catch (Exception e){}
    }

    //For entering qty in catalog popup based on card/ list catalog display
    public void EnterQty(String unit, String cas)
    {
        exists = false;
        WebElement WebEle = null;
        Actions act1=new Actions(driver);
        try
        {
            String HeadText = null;
            int i = 0;
            int j = 0;
            String XPath = null;

            //Check for catalog popup
            if (HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                //WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                if (!HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    //When "Card view" of catlog is enabled
                    if (HelpersMethod.IsExists("//div[@class='card-view']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                    {
                        //Enter Unit value in input box of catalog
                        if (HelpersMethod.IsExists("//div[contains(text(),'Unit')]/descendant::input", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Unit')]/descendant::input");
                            HelpersMethod.ScrollElement(driver, WebEle);
                            act1.moveToElement(WebEle).click().build().perform();
                            act1.sendKeys(WebEle,unit).build().perform();
                            act1.sendKeys(Keys.TAB).build().perform();
                            scenario.log("UNIT ENTERED IN CATALOG " + unit);

                            //Check for popups
                        /*    for (int a = 0; a <= 2; a++)
                            {*/
                            //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                // to fetch the web element of the modal container
                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                //click on Yes button
                                WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                                HelpersMethod.ClickBut(driver, WebEle, 80);
                            }
                         /*       //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                     WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                     WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver, Popup, 60);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                                    WebEle=modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver,WebEle, 60);
                                }
                            }
                        }*/
                            //Enter Case value in input box of catalog
                            if (HelpersMethod.IsExists("//div[contains(text(),'Case')]/descendant::input", driver)) {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Case')]/descendant::input");
                                HelpersMethod.ScrollElement(driver, WebEle);
                                act1.moveToElement(WebEle).click().build().perform();
                                act1.sendKeys(WebEle,unit).build().perform();
                                act1.sendKeys(Keys.TAB).build().perform();
                                scenario.log("CASES ENTERED IN CATALOG " + cas);
                                //Check for popups
                        /*    for (int a = 0; a <= 2; a++)
                            {*/
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                    // to fetch the web element of the modal container
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                    //click on Yes button
                                    WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                                    HelpersMethod.ClickBut(driver, WebEle, 200);
                                    scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                                }
                                //Check for "Out of Stock" popup
                           /*     if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                    WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver, Popup, 60);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                                    WebEle=modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver,WebEle, 60);
                                }
                            }*/
                            }
                        }
                        //Grid view display of catalog
                        else if (HelpersMethod.IsExists("//table[@class='k-grid-table']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            int b = 0;
                            List<WebElement> tableHeads = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='i-grid']/descendant::th[@class='k-header ']/span[@class='k-link']");
                            for (WebElement tableHead : tableHeads)
                            {
                                b++;
                                WebElement UnitCase = null;
                                String THead_Text = tableHead.getText();
                                if (THead_Text.equals("Units"))
                                {
                                    UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + (b + 1) + "]/descendant::input");
                                    HelpersMethod.ScrollElement(driver, UnitCase);
                                    if (UnitCase.isDisplayed() && UnitCase.isEnabled())
                                    {
                                        HelpersMethod.ActSendKey(driver, UnitCase, 10, unit);
                                        scenario.log("UNITS ENTERED IN CATALOG " + unit);
                                        //Check for popups
                                       /* for (int a = 0; a <= 2; a++)
                                        {*/
                                        //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                            // to fetch the web element of the modal container
                                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                            //click on Yes button
                                            WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                                            HelpersMethod.ClickBut(driver, WebEle, 200);
                                            scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                                        }
                                        /*    //Check for "Out of Stock" popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                                WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                                HelpersMethod.ClickBut(driver, Popup, 60);
                                            }
                                            //"Product is currently unavailable" popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                                                WebEle = modalContainer.findElement(By.xpath(".//button"));
                                                HelpersMethod.ClickBut(driver, WebEle, 60);
                                            }
                                        }*/
                                    }
                                }
                                else
                                {
                                    if (THead_Text.equals("Cases"))
                                    {
                                        //Find whether Cases input box is displayed
                                        UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + (b + 1) + "]/descendant::input");
                                        HelpersMethod.ScrollElement(driver, UnitCase);
                                        if (UnitCase.isDisplayed() && UnitCase.isEnabled())
                                        {
                                            HelpersMethod.ActSendKey(driver, UnitCase, 10, cas);
                                            scenario.log("CASES ENTERED IN CATALOG is " + cas);
                                            //Check for popups
                                         /*   for (int a = 0; a <= 2; a++)
                                            {*/
                                            //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                                // to fetch the web element of the modal container
                                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                                //click on Yes button
                                                WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                                                HelpersMethod.ClickBut(driver, WebEle, 2000);
                                                scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                                            }
                                        /*        //Check for "Out of Stock" popup
                                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                                    WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                                    HelpersMethod.ClickBut(driver, Popup, 60);
                                                }
                                                //"Product is currently unavailable" popup
                                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                                                    WebEle = modalContainer.findElement(By.xpath(".//button"));
                                                    HelpersMethod.ClickBut(driver, WebEle, 60);
                                                }
                                            }*/
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        scenario.log("PRODUCT HAS NOT BEEN FOUND");
                    }
                    exists = true;
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(text(),'Ok')]");
                    HelpersMethod.ClickBut(driver, WebEle, 60);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }
                }
            }
        }
        catch (InterruptedException e) {}
    }

    public boolean ClickNext() throws InterruptedException
    {
        exists=false;
        try
        {
            //new WebDriverWait(driver,1000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'contentRow row')]")));
            if(Next_But.isDisplayed() && Next_But.isEnabled())
            {
                HelpersMethod.ScrollUpScrollBar(driver);
                Next_But=HelpersMethod.FindByElement(driver,"id","submitOrderButton");
                HelpersMethod.ActClick(driver,Next_But,100);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
                exists=true;
               /* for(int i=0;i<=3;i++)
                {
                    if (HelpersMethod.IsExists("//div[contains(text(),'which is less than the minimum order amount of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                    {
                        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                        WebElement yesButton = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                        HelpersMethod.ClickBut(driver, yesButton, 100);
                    }
                    if(HelpersMethod.IsExists("//div[contains(text(),' the quantity order has been increased')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                        WebElement continueButton = modalContainer.findElement(By.xpath(".//button[text()='Continue']"));
                        HelpersMethod.ClickBut(driver,continueButton, 100);
                    }
                    if(HelpersMethod.IsExists("//div[contains(text(),'Frequently ordered items')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                        WebElement noButton = modalContainer.findElement(By.xpath(".//button[text()='No']"));
                        HelpersMethod.ClickBut(driver,noButton, 100);
                    }
                }*/
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){ }
        return exists;
    }

    public void OutOfStockPop_ERP() throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            //If delivery date has entered the cut off time, then popup will appear asking to change the delivery date
          /*  if(HelpersMethod.IsExists("//div[contains(text(),'The cutoff time for this delivery date has been reached.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,10);

                OrderEntryPage  orderPage=new OrderEntryPage(driver,scenario);
                //once we click on yes button should change the deliver date and enter PO# too
                //Click on calender,Select the next delivery date
                LocalDate myDateObj = LocalDate.now().plusDays(1);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                String formattedDate = myDateObj.format(myFormatObj);
                orderPage.ClickCalender();
                orderPage.SelectDate(formattedDate, 1);
                orderPage.ChangedDeliveryDate();

                //Enter PO#
                EnterPO_No("PO123");

                //Click on Next button
                HelpersMethod.ClickBut(driver,Next_But,100);
            }*/

            for (int i = 0; i <= 4; i++)
            {
                //out of stock popup
                if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    //click on Continue button
                    WebEle=modalContainer.findElement(By.xpath(".//button[text()='Continue']"));
                    HelpersMethod.ClickBut(driver,WebEle, 80);
                    scenario.log("% OF YOUR AVERAGE ORDER POPUP HAS BEEN HANDLED");
                }
                //Critical item popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    //click on No button
                    WebEle=modalContainer.findElement(By.xpath(".//button[text()='No']"));
                    HelpersMethod.ClickBut(driver,WebEle, 80);
                    scenario.log("CRITICAL ITEMS NOT ORDERED POPUP HANDLED");
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'which is less than the minimum order amount of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                    WebElement yesButton = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                    HelpersMethod.ClickBut(driver, yesButton, 100);
                    scenario.log("AMOUNT LESS THAN THE MINIMUM ORDER AMOUNT POPUP HANDLED");
                }
                if(HelpersMethod.IsExists("//div[contains(text(),' the quantity order has been increased')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                    WebElement continueButton = modalContainer.findElement(By.xpath(".//button[text()='Continue']"));
                    HelpersMethod.ClickBut(driver,continueButton, 100);
                    scenario.log("QTY ORDERED HAS BEEN INCREASED POPUP HAS BEEN HANDLED");
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Frequently ordered items')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                    WebElement noButton = modalContainer.findElement(By.xpath(".//button[text()='No']"));
                    HelpersMethod.ClickBut(driver,noButton, 100);
                    scenario.log("FREQUENTLY ORDERED ITEDMS POPUP HAS BEEN HANDLED");
                }
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void OutOfStockPop_DSD() throws InterruptedException
    {
        exists=false;
        try
        {
            WebElement WebEle=null;
            for (int i = 0; i <= 4; i++)
            {
                //Frequently ordered items
                if(HelpersMethod.IsExists("//div[contains(text(),'Frequently ordered items not ordered')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='No']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }

                //Qty has been increased to popup
                if (HelpersMethod.IsExists("//div[contains(text(),'the quantity order has been increased to')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[text()='Continue']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }

                //% of average order stock popup
                if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[text()='Continue']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }

                //Minimum order amount not reached  popup
                //Check for existence of product in Product grid, Of New order entry page (IN DSD ENV)
                if (HelpersMethod.IsExists("//div[contains(text(),'the minimum order amount has not been reached')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'the minimum order amount has not been reached')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button"),2);

                    //Scroll till product grid
                    HelpersMethod.ScrollElement(driver, HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer"));

                    //Check for existence of product in Product grid, Of New order entry page
                    if (HelpersMethod.IsExists("//table[contains(@class,'k-grid-table')]",driver))
                    {
                        //Check Whether Case is enabled or not
                        if (HelpersMethod.IsExists("//tr[1]/descendant::input[contains(@id,'TotalCasesCol')]",driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::input[contains(@id,'TotalCasesCol')]");
                            HelpersMethod.ActSendKey(driver, WebEle, 40,"50");
                        }

                        //Check Whether Units is enabled or not
                        if (HelpersMethod.IsExists("//tr[1]/descendant::input[contains(@id,'TotalUnitsCol')]",driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::input[contains(@id,'TotalUnitsCol')]");
                            HelpersMethod.ActSendKey(driver,WebEle, 40,"50");
                        }
                    }
                    ClickNext();
                }
                //Critical item popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                    HelpersMethod.ClickBut(driver,WebEle,60);
                    ClickNext();
                }
            }
        }
        catch (Exception e){}
    }

    public void QuickProduct(String Prod) throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(QuickPro.isDisplayed() && QuickPro.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,QuickPro);
                HelpersMethod.EnterText(driver, QuickPro, 40, Prod);
                QuickPro.sendKeys(Keys.TAB);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
                scenario.log("PRODUCT ADDED TO THE ORDER Via QUICK PRODUCT ENTRY " + Prod);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void VerifyUOM()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='quickEntryUMs']/span");
            if(WebEle.isEnabled())
            {
                scenario.log("UOM IS ENABLED AND IT CONTAINS "+WebEle.getText()+" VALUE IN IT");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void OECancel()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ScrollElement(driver,Cancel_But);
            HelpersMethod.JScriptClick(driver,Cancel_But,100);
            scenario.log("ORDER CANCEL, BUTTON CLICKED");
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 50000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void VerifyCancelPopUp()
    {
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Cancel order", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void CancelAndSkipPopupDisabled()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebElement cancelSkipPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement CAndSButton=cancelSkipPopup.findElement(By.xpath(".//button[contains(text(),'Cancel & skip')]"));
            if(!CAndSButton.isEnabled())
            {
                scenario.log("CANCEL AND SKIP BUTTON IS DISABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CancelPop()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            //Check for the Cancel Order warning popup
            if (HelpersMethod.IsExists("//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement cancelPopup = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                WebEle=cancelPopup.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ClickBut(driver,WebEle,20);
                scenario.log("CANCEL ORDER POPUP HAS BEEN HANDLED");
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
        }
        catch (Exception e){}
    }

    public void CancelAndSkipPopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            //Check for the Cancel Order warning popup
            if (HelpersMethod.IsExists("//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement cancelPopup = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                WebEle=cancelPopup.findElement(By.xpath(".//button[text()='Cancel & skip']"));
                HelpersMethod.ClickBut(driver,WebEle,80);
                scenario.log("CANCEL AND SKIP ORDER POPUP HAS BEEN CLICKED");
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
        }
        catch (Exception e){}
    }

    public void CheckForQuickCaseEnabled(String Case)  throws InterruptedException
    {
        WebElement WebEle = null;
        String status=null;
        try
        {
            WebElement uom=HelpersMethod.FindByElement(driver,"xpath","//span[@id='quickEntryUMs']/span[@class='k-input']");
            String uomText=uom.getText();
            if(uomText.contains("Cases"))
            {
                HelpersMethod.ScrollElement(driver, QuickPro);
                if (QuickCase.isDisplayed() && QuickCase.isEnabled())
                {
                    HelpersMethod.ClearText(driver, QuickCase, 100);
                    HelpersMethod.EnterText(driver, QuickCase, 100, Case);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading")) {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    QuickCase.sendKeys(Keys.TAB);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading")) {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                    }
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading")) {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    scenario.log("CASE ENTERED FOR QUICK PRODUCT IS " + Case);
                    //Check for popups
                  /* for (int a = 0; a <= 2; a++)
                   {*/
                    //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                        // to fetch the web element of the modal container
                        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                        //click on Yes button
                        WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                        HelpersMethod.ClickBut(driver, WebEle, 200);
                        status = HelpersMethod.returnDocumentStatus(driver);
                        if (status.equals("loading")) {
                            HelpersMethod.waitTillLoadingPage(driver);
                        }
                        scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                    }
                    //Check for "Out of Stock" popup
                 /*   if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                        WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                        HelpersMethod.ClickBut(driver, Popup, 60);
                    }
                    //"Product is currently unavailable" popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                        WebEle=modalContainer.findElement(By.xpath(".//button"));
                        HelpersMethod.ClickBut(driver,WebEle, 60);
                    }
                }*/


                    //Before deleting this check whether all popup added in above for loop code
              /*  for (int i = 0; i <= 5; i++)
                {
                    //Check for Qty exceeds maximum of popup
                    if(HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                        HelpersMethod.ClickBut(driver,WebEle,20);
                    }
                /*    //Check for 'Product Unavailable' popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[@id='toast-container']",driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }

                    //Check for 'Product low in invetory' popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low')]/ancestor::div[@id='toast-container']",driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }
                    //Check for 'There are no matching product' popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'There are no matching products: ')]/ancestor::div[contains(@class,'toast toast-error')]",driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }
                    //Check for popup if it is accespting only units popup
                    if(HelpersMethod.IsExists("//div[contains(text(),' can only be ordered in ')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='toast-container']/descendant::button[text()='×']");
                        HelpersMethod.ActClick(driver,WebEle,10);
                    }
                }*/
                }
            }
        }
        catch (Exception e) {}
    }

    public void CheckForQuickUnitEnabled(String Unit)  throws InterruptedException
    {
        WebElement WebEle = null;
        String status=null;
        try
        {
            WebElement uom=HelpersMethod.FindByElement(driver,"xpath","//span[@id='quickEntryUMs']/span[@class='k-input']");
            String uomText=uom.getText();
            if(uomText.contains("Units"))
            {
               HelpersMethod.ScrollElement(driver, QuickPro);
               if (QuickUnit.isDisplayed() && QuickUnit.isEnabled())
               {
                  exists = false;
                 HelpersMethod.ClearText(driver, QuickUnit, 100);
                 HelpersMethod.EnterText(driver, QuickUnit, 100, Unit);
                 status = HelpersMethod.returnDocumentStatus(driver);
                 if (status.equals("loading"))
                 {
                    HelpersMethod.waitTillLoadingPage(driver);
                 }
                 QuickUnit.sendKeys(Keys.TAB);
                 status = HelpersMethod.returnDocumentStatus(driver);
                 if (status.equals("loading"))
                 {
                    HelpersMethod.waitTillLoadingPage(driver);
                 }
                 if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                 {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                 }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("UNIT ENTERED FOR QUICK PRODUCT IS " + Unit);

                //  HelpersMethod.Implicitwait(driver, 40);
             /*   for (int i = 0; i <= 5; i++)
                {*/
                //Check for Qty exceeds maximum of popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    // to fetch the web element of the modal container
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    //click on Yes button
                    WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                    HelpersMethod.ClickBut(driver, WebEle, 100);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                }
                   /* //Check for 'Product Unavailable' popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[@id='toast-container']",driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }

                    //Check for 'Product low in invetory' popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low')]/ancestor::div[@id='toast-container']",driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }

                    //Check for 'There are no matching product' popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'There are no matching products: ')]/ancestor::div[contains(@class,'toast toast-error')]",driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }
                    //Check for popup if it is accespting only cases popup
                    if(HelpersMethod.IsExists("//div[contains(text(),' can only be ordered in ')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='toast-container']/descendant::button[text()='×']");
                        HelpersMethod.ActClick(driver,WebEle,10);
                    }
                }*/
                exists = true;
               }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void exceedsMaxQty() throws InterruptedException
    {
        String status;
        WebElement WebEle;
        status=HelpersMethod.returnDocumentStatus(driver);
        Thread.sleep(5000);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                // to fetch the web element of the modal container
                WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                //click on Yes button
                WebEle=modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ClickBut(driver,WebEle, 1000);
                status=HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
        }
        catch (Exception e){}
    }

    public void New_OE_Click_Skip_Button()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,SkipButton,100);
        }
        catch (Exception e){}
    }

    public void New_OE_Validate_Skip_Button()
    {
        exists=false;
        try
        {
            WebElement Skip_Pop = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            exists = HelpersMethod.EleDisplay(Skip_Pop);
            if (exists == true)
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void New_OE_Select_SkipReason(String reason) throws InterruptedException
    {
        try
        {
            WebElement Skip_Pop = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            exists = HelpersMethod.EleDisplay(Skip_Pop);
            if (exists == true)
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='SkipReason']/descendant::span[contains(@class,'k-icon k-i-arrow-s')]");
                HelpersMethod.JScriptClick(driver, WebEle, 80);
                HelpersMethod.DropDownMenu_LowerCase(driver,reason);
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[text()='Ok']");
                HelpersMethod.ClickBut(driver, WebEle, 80);
            }
            else
            {
                scenario.log("SKIP POPUP MISSING");
            }
        }
        catch (Exception e){}
    }

    public void Enter_Qty_InGrid(String unit,String cas) throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebElement grid=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver, grid);
            if(UnitInput.isDisplayed() && UnitInput.isEnabled())
            {
                HelpersMethod.ActSendKey(driver, UnitInput, 40, unit);
                scenario.log("UNIT ENTERED IN GRID IS " + unit);
                /*for (int j = 0; j <= 3; j++)
                {*/
                //Check for 'Qty exceeds maximum of' Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                    HelpersMethod.ClickBut(driver, WebEle, 40);
                }

                  /*  //Handling Product unavailable
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low on inventory')]/ancestor::div[contains(@id,'toast-container')]", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@id,'toast-container')]/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }

                    //Handling product unavailable, popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }
                }*/
            }
            if(CaseInput.isDisplayed() && CaseInput.isEnabled())
            {
                HelpersMethod.ActSendKey(driver, CaseInput, 10, cas);
                scenario.log("CASE ENTERED IN GRID IS "+cas);
              /*  for (int j = 0; j <= 3; j++)
                {*/
                //Check for 'Qty exceeds maximum of' Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                    HelpersMethod.ClickBut(driver, WebEle, 10);
                }

                   /* //Handling Product unavailable
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low on inventory')]/ancestor::div[contains(@id,'toast-container')]", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@id,'toast-container')]/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }

                    //Handling product unavailable, popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                        HelpersMethod.ClickBut(driver, WebEle, 10);
                    }
                }*/
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_On_Copy_From_DropDown(String OrdHist)
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver, CopyFrom);
            HelpersMethod.ClickBut(driver,CopyFrom,200);

            //new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-list-container k-reset k-group k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]"))));
            WebElement copyFromDropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-list-container k-reset k-group k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
            WebElement copyFromHistory=copyFromDropDown.findElement(By.xpath(".//li[contains(text(),'Order history')]"));
            HelpersMethod.ActClick(driver,copyFromHistory,100);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_On_Add_Product()
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver,AddProduct);
            HelpersMethod.ClickBut(driver,AddProduct,60);
            scenario.log("ADD PRODUCT BUTTON HAS BEEN CLICKED");
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void SelectOGFromDropdown()
    {
        WebElement WebEle=null;
        exists=false;
        Actions act1=new Actions(driver);
        String menuText=null;
        try
        {
            //new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"))));
            List<WebElement> dropdownMenus=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative')]/descendant::ul/li");
            for(WebElement dropDown:dropdownMenus)
            {
                act1.moveToElement(dropDown).build().perform();
                menuText=dropDown.getText();
                if(menuText.equals("From Order guides"))
                {
                    act1.moveToElement(dropDown).build().perform();
                    act1.click(dropDown).build().perform();
                    exists=true;
                    scenario.log("ADD PRODUCT FROM OG");
                    break;
                }
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateOGPopup()
    {
        //HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",400);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Order guides", "Verify Title message");

    }

    public void OrderGuideGrid(String OGName)
    {
        WebElement OG=null;
        WebElement WebEle=null;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Enter OG name in search box, of OG popup
                OG=HelpersMethod.FindByElement(driver,"id","orderGuideSearch");
                HelpersMethod.EnterText(driver,OG,100,OGName);

                //Click on search index icon
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]");
                HelpersMethod.ClickBut(driver,WebEle,100);

                //Click on OG
                OG=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::td[text()='"+OGName+"']/parent::tr");
                HelpersMethod.ActClick(driver,OG,100);

                //Click on OK button in OG popup
                OG=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ActClick(driver,OG,100);

                exists=true;
                scenario.log("ORDER GUIDE SELECTED IS "+OGName);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //For entering Qty in Product grid
    public void EnterQty_ProductGrid(WebDriver driver,List<List<String>> QtyDetails)
    {
        try
        {
            WebElement WebEle=null;
            //Scroll till product grid
            HelpersMethod.ScrollElement(driver, driver.findElement(By.id("orderEntryGridContainer")));

            //Check for existence of product in Product grid, Of New order entry page
            if (HelpersMethod.IsExists("//table[contains(@class,'k-grid-table')]",driver))
            {
                for(int i=0;i<=QtyDetails.size()-1;i++)
                {
                    //Check Whether Cases is enabled or not
                    if (HelpersMethod.IsExists("//tr["+(i+1)+"]/descendant::input[contains(@id,'TotalCasesCol')]", driver))
                    {
                        WebEle = driver.findElement(By.xpath("//tr["+(i+1)+"]/descendant::input[contains(@id,'TotalCasesCol')]"));
                        HelpersMethod.ActSendKey(driver, WebEle, 100, QtyDetails.get(i).get(0));
                        scenario.log("QTY ENTERED IN CASES INPUTBOX "+QtyDetails.get(i).get(0));
                        //for (int j = 0; j <= 3; j++)
                        //{
                        //Check for 'Qty exceeds maximum of' Popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ClickBut(driver, WebEle, 100);
                        }

                           /* //Handling Product unavailable
                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low on inventory')]/ancestor::div[contains(@id,'toast-container')]", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@id,'toast-container')]/descendant::button");
                                HelpersMethod.ClickBut(driver, WebEle, 10);
                            }

                            //Handling product unavailable, popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                                HelpersMethod.ClickBut(driver, WebEle, 10);
                            }
                        }*/
                    }

                    //Check Whether Units is enabled or not
                    if (HelpersMethod.IsExists("//tr["+(i+1)+"]/descendant::input[contains(@id,'TotalUnitsCol')]", driver))
                    {
                        WebEle = driver.findElement(By.xpath("//tr["+(i+1)+"]/descendant::input[contains(@id,'TotalUnitsCol')]"));
                        HelpersMethod.ActSendKey(driver, WebEle, 100,QtyDetails.get(i).get(1));
                        scenario.log("QTY ENTERED IN UNIT INPUTBOX "+QtyDetails.get(i).get(1));

                        //for (int j = 0; j <= 3; j++)
                        //{
                        //Check for 'Qty exceeds maximum of' Popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ClickBut(driver, WebEle, 100);
                        }

                         /*   //Handling Product unavailable
                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low on inventory')]/ancestor::div[contains(@id,'toast-container')]", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@id,'toast-container')]/descendant::button");
                                HelpersMethod.ClickBut(driver, WebEle, 10);
                            }

                            //Handling product unavailable, popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                                HelpersMethod.ClickBut(driver, WebEle, 10);
                            }
                        }*/
                    }
                }
            }
        }
        catch(Exception e){}
    }

    public void Comment_Icon()
    {
        try
        {
            HelpersMethod.ScrollElement(driver,Ord_Comments);
            HelpersMethod.ClickBut(driver,Ord_Comments,100);
        }
        catch (Exception e){}
    }

    //handling 'Comment' popup for order and for product
    public void Comment_Popup(String Comment)
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
           // HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
            // to fetch the web element of the modal container
           /* WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them,code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Comments", "Verify Title message");

            WebEle= modalContainer.findElement(By.id("textAreaA"));
            HelpersMethod.EnterText(driver,WebEle,80,Comment);
            scenario.log("COMMENT ENTERED IS "+Comment);

            //Click on Add button in the popup
            WebEle=modalContainer.findElement(By.xpath(".//button[text()='Add']"));
            new WebDriverWait(driver,Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(WebEle));
            HelpersMethod.ActClick(driver,WebEle,80);
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);

            //Click on OK button
            WebEle=modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
            HelpersMethod.ClickBut(driver,WebEle,100);
            exists=true;
            Assert.assertEquals(exists,true);*/
            WebElement prodCommentPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            //Sending comment to comment input box in product comment popup
            WebElement prodCommText=prodCommentPopup.findElement(By.xpath(".//textarea[@id='textAreaA']"));
            HelpersMethod.ActSendKey(driver,prodCommText,100,Comment);
            //Select Comment flag
            WebElement commentFlag=HelpersMethod.FindByElement(driver,"id","printFlagDropDown");
            HelpersMethod.ActClick(driver,commentFlag,100);
            //select value from comment flag drop down
            List<WebElement> flags=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset')]/descendant::ul/li");
            for(WebElement flag:flags)
            {
                i++;
                act.moveToElement(flag).build().perform();
                if(i==2)
                {
                    act.moveToElement(flag).click().build().perform();
                    break;
                }
            }
            //Click on Add button in the popup
            WebElement addButton=prodCommentPopup.findElement(By.xpath(".//button[text()='Add']"));
            HelpersMethod.ClickBut(driver,addButton,100);
            //Click on OK button
            WebElement okButton=prodCommentPopup.findElement(By.xpath(".//button[text()='Ok']"));
            HelpersMethod.ClickBut(driver,okButton,100);
            exists=true;
            scenario.log("COMMENT ADDED IS "+Comment);
        }
        catch (Exception e){}
    }

    public void Prod_Comment_Icon()
    {
        try
        {
            WebElement WebEle=null;
            if(HelpersMethod.IsExists("//tr[1]/descendant::div[contains(@id,'OrderLineCommentIconColIcon')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ClickBut(driver,Prod_Comments,100);
                scenario.log("PRODUCT COMMENT ICON FOUND ");
            }
            else
            {
                scenario.log("PRODUCT COMMENT ICON DOESN'T EXISTS");
            }
        }
        catch(Exception e){}
    }

    public void Comment_PopupProd(String Comment)
    {
        exists=false;
        int i=0;
        Actions act=new Actions(driver);
        try
        {

            if(HelpersMethod.IsExists("//div[contains(text(),'comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement prodCommentPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                //Sending comment to comment input box in product comment popup
                WebElement prodCommText=prodCommentPopup.findElement(By.xpath(".//textarea[@id='textAreaA']"));
                HelpersMethod.ActSendKey(driver,prodCommText,100,Comment);
                //Select Comment flag
                WebElement commentFlag=HelpersMethod.FindByElement(driver,"id","printFlagDropDown");
                HelpersMethod.ActClick(driver,commentFlag,100);
                //select value from comment flag drop down
                List<WebElement> flags=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset')]/descendant::ul/li");
                for(WebElement flag:flags)
                {
                    i++;
                    act.moveToElement(flag).build().perform();
                    if(i==2)
                    {
                        act.moveToElement(flag).click().build().perform();
                        break;
                    }
                }
                //Click on Add button in the popup
                WebElement addButton=prodCommentPopup.findElement(By.xpath(".//button[text()='Add']"));
                HelpersMethod.ClickBut(driver,addButton,80);
                //Click on OK button
                WebElement okButton=prodCommentPopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,80);
                exists=true;
                scenario.log("COMMENT ADDED IS "+Comment);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Comment_PopupProdUpdate(String Comment)
    {
        exists=false;
        int i=0;
        Actions act=new Actions(driver);
        try
        {

            if(HelpersMethod.IsExists("//div[contains(text(),'comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement prodCommentPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                //Sending comment to comment input box in product comment popup
                WebElement prodCommText=prodCommentPopup.findElement(By.xpath(".//textarea[@id='textAreaA']"));
                HelpersMethod.ActSendKey(driver,prodCommText,100,Comment);
                //Select Comment flag
                WebElement commentFlag=HelpersMethod.FindByElement(driver,"id","printFlagDropDown");
                HelpersMethod.ActClick(driver,commentFlag,100);
                //select value from comment flag drop down
                List<WebElement> flags=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset')]/descendant::ul/li");
                for(WebElement flag:flags)
                {
                    i++;
                    act.moveToElement(flag).build().perform();
                    if(i==2)
                    {
                        act.moveToElement(flag).click().build().perform();
                        break;
                    }
                }
                //Click on Add button in the popup
                WebElement addButton=prodCommentPopup.findElement(By.xpath(".//button[text()='Add']"));
                HelpersMethod.ClickBut(driver,addButton,80);
                //Click on OK button
               // WebElement okButton=prodCommentPopup.findElement(By.xpath(".//button[text()='Ok']"));
               // HelpersMethod.ClickBut(driver,okButton,80);
                exists=true;
                scenario.log("COMMENT ADDED IS "+Comment);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Add_Product_From_Catalog()
    {
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        WebElement WebEle=null;
        try
        {
            Click_On_Add_Product();
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"))));
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"));
            WebElement optionToClick = menuContainer.findElement(By.xpath(".//li[contains(text(),'From Catalog')]"));
            // click the option
            HelpersMethod.ActClick(driver, optionToClick, 1000);

            scenario.log("ADD PRODUCT FROM CATALOG IS SELECTED");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
            }
        }
        catch (Exception e) {}
    }

    public void Validate_Catalog()
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
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                // to fetch the web element of the modal container
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Catalog", "Verify Title message");
            }
        }
        catch (Exception e){}
    }

    public void ResetFilter_Catalog()
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
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    WebEle=catalogPopup.findElement(By.xpath("//button[contains(text(),'Reset filter')]"));
                    HelpersMethod.clickOn(driver,WebEle,100);
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                    }
                }
                else
                {
                    if (HelpersMethod.IsExists("//div[@class='i-grid']", driver))
                    {
                        //Click on 'Add filter'
                        WebEle = catalogPopup.findElement(By.xpath("//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
                        HelpersMethod.clickOn(driver, WebEle, 100);

                        //Click on 'Clear all'
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-filter-popup__footer')]/button[contains(text(),'Clear all')]");
                        HelpersMethod.ActClick(driver, WebEle, 100);
                        exists = true;
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                        }
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Search_Prod_in_Catalog(String Prods)
    {
        exists=false;
        WebElement WebEle=null;
        int i=0;
        String unit=null, cas=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    //Click on clear button in search bar
                    WebEle = catalogPopup.findElement(By.xpath("//span[contains(@class,'right-button')]"));
                    HelpersMethod.ScrollElement(driver,WebEle);
                    HelpersMethod.clickOn(driver, WebEle, 100);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                    }

                    //Enter product number in search bar
                    WebEle = catalogPopup.findElement(By.xpath("//input[contains(@class,' product-search-input ')]"));
                    HelpersMethod.sendKeys(driver, WebEle, 100,Prods);
                    scenario.log("PRODUCT NUMBER ENTERED IN SEARCH BAR "+Prods);

                    //Enter search index
                    WebEle=catalogPopup.findElement(By.xpath("//div[@class='searchBarDropdown']/descendant::span[contains(@class,' search-button ')]"));
                    HelpersMethod.clickOn(driver, WebEle, 100);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                    }
                    exists=true;
                }
                else
                {
                    if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
                    {
                        //Click on 'Add filter'
                        WebEle = catalogPopup.findElement(By.xpath("//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
                        HelpersMethod.clickOn(driver, WebEle, 100);

                        HelpersMethod.AddFilterSearch_Popup(driver,"Product #",Prods);
                        scenario.log("PORDUCT NUMBER ENERED IN INPUT BOX "+Prods);
                        //Enter value in first search box
                        if(HelpersMethod.IsExists("//div[contains(@class,'i-filter-popup i-filter-popup--add')]",driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-filter-popup i-filter-popup--add')]/descendant::input[contains(@class,'i-search-box__input')]");
                                HelpersMethod.sendKeys(driver,WebEle,100,"Product #");
                                //Click on Check box
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup i-filter-popup--add')]/descendant::input[contains(@class,'k-checkbox')]");
                                HelpersMethod.ActClick(driver,WebEle,40);
                                //Click on some other place
                                WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']");
                                HelpersMethod.ActClick(driver,WebEle,100);
                            }

                            //Click on Product# button
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'i-filter-tag__main')]/span[text()='Product #: ']");
                            HelpersMethod.ActClick(driver,WebEle,100);

                            //Enter product # in inputbox
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__content')]/descendant::input[@class='k-textbox']");
                            HelpersMethod.ActSendKey(driver,WebEle,100,Prods);
                            scenario.log("PORDUCT NUMBER ENERED IN INPUT BOX "+Prods);

                            //Click on Apply button
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//form[contains(@class,'i-filter-popup i-filter-popup--text')]/descendant::button[text()='Apply']");
                            HelpersMethod.ActClick(driver,WebEle,10);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                            }
                        exists=true;
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterQty_MutlipleProd(String unit,String cas)
    {
        exists = false;
        try
        {
            String HeadText = null;
            int i = 0;
            int j = 0;
            String XPath = null;
            WebElement WebEle = null;
            WebElement UnitCase = null;
            Actions act1=new Actions(driver);
            //Check for catalog popup
            if (driver.findElement(By.xpath("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")).isDisplayed())
            {
                new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
                WebElement catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                if (!HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    //When "Card view" of catlog is enabled
                    if (HelpersMethod.IsExists("//div[@class='card-view']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                    {
                        //Enter Unit value in input box of catalog
                        if (HelpersMethod.IsExists("//input[contains(@id,'catalog-quantity-input')]", driver))
                        {
                            WebEle = catalogPopup.findElement(By.xpath(".//input[contains(@id,'catalog-quantity-input')]"));
                            HelpersMethod.ScrollElement(driver, WebEle);
                            HelpersMethod.ClearText(driver,WebEle,100);
                            act1.moveToElement(WebEle).click().build().perform();
                            act1.sendKeys(WebEle,unit).build().perform();
                            act1.sendKeys(Keys.TAB).build().perform();
                            scenario.log("UNIT ENTERED IN CATALOG " + unit);

                            //Check for popups
                        /*  for (int a = 0; a <= 2; a++)
                            {*/
                            //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                            {
                                // to fetch the web element of the modal container
                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                //click on Yes button
                                WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                                HelpersMethod.ClickBut(driver, WebEle, 100);
                            }
                         /*       //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                     WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                     WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver, Popup, 60);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                                    WebEle=modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver,WebEle, 60);
                                }
                            }
                        }*/
                            //Enter Case value in input box of catalog
                            if (HelpersMethod.IsExists("//input[contains(@id,'catalog-cases')]", driver))
                            {
                                WebEle = catalogPopup.findElement(By.xpath(".//input[contains(@id,'catalog-cases')]"));
                                HelpersMethod.ScrollElement(driver, WebEle);
                                HelpersMethod.ClearText(driver,WebEle,100);
                                act1.moveToElement(WebEle).click().build().perform();
                                act1.sendKeys(WebEle,unit).build().perform();
                                act1.sendKeys(Keys.TAB).build().perform();
                                scenario.log("CASES ENTERED IN CATALOG " + cas);
                                //Check for popups
                        /*    for (int a = 0; a <= 2; a++)
                            {*/
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                    // to fetch the web element of the modal container
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                    //click on Yes button
                                    WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                                    HelpersMethod.ClickBut(driver, WebEle, 100);
                                }
                         /*       //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                     WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                     WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver, Popup, 60);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                                    WebEle=modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver,WebEle, 60);
                                }
                            }
                        }*/
                            }
                        }
                        //Grid view display of catalog
                        else if (driver.findElement(By.xpath("//table[@class='k-grid-table']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")).isDisplayed()) {
                            int b = 0;
                            List<WebElement> tableHeads = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='i-grid']/descendant::th[@class='k-header ']/span[@class='k-link']");
                            for (WebElement tableHead : tableHeads)
                            {
                                b++;
                                String THead_Text = tableHead.getText();
                                if (THead_Text.equals("Units"))
                                {
                                    UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')]//descendant::td[" + (b + 1) + "]/descendant::input");
                                    HelpersMethod.ScrollElement(driver, UnitCase);
                                    HelpersMethod.ActSendKey(driver, UnitCase, 100, unit);
                                    scenario.log("UNITS ENTERED IN CATALOG " + unit);
                                    //Check for popups
                        /*    for (int a = 0; a <= 2; a++)
                            {*/
                                    //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                    if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                        // to fetch the web element of the modal container
                                        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                        //click on Yes button
                                        WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                                        HelpersMethod.ClickBut(driver, WebEle, 100);
                                    }
                         /*       //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                     WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                     WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver, Popup, 60);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                                    WebEle=modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver,WebEle, 60);
                                }
                            }
                        }*/
                                }
                            }
                            for (WebElement tableHead : tableHeads) {
                                String THead_Text = tableHead.getText();
                                if (THead_Text.equals("Cases")) {
                                    //Find whether Cases input box is displayed
                                    XPath = "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')]//descendant::td[" + (b + 1) + "]/descendant::input";
                                    exists = HelpersMethod.IsExists(XPath, driver);
                                    if (exists == true) {
                                        UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')]//descendant::td[" + (b + 1) + "]/descendant::input");
                                        HelpersMethod.ScrollElement(driver, WebEle);
                                        HelpersMethod.ActSendKey(driver, UnitCase, 100, cas);
                                        scenario.log("CASES ENTERED IN CATALOG is " + cas);
                                        //Check for popups
                        /*    for (int a = 0; a <= 2; a++)
                            {*/
                                        //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                                            // to fetch the web element of the modal container
                                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                            //click on Yes button
                                            WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                                            HelpersMethod.ClickBut(driver, WebEle, 100);
                                        }
                         /*       //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                     WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                                     WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver, Popup, 60);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                                    WebEle=modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ClickBut(driver,WebEle, 60);
                                }
                            }
                        }*/
                                    }
                                }
                            }
                        }
                    } else {
                        scenario.log("PRODUCT HAS NOT BEEN FOUND");
                    }
                }
            }
        }
        catch (Exception e) {}
    }

    public void Catalog_OK()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebElement catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebEle=catalogPopup.findElement(By.xpath(".//button[contains(text(),'Ok')]"));
            HelpersMethod.ClickBut(driver,WebEle, 60);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}

    }

    public String Export_button()
    {
        WebElement WebEle=null;
        try
        {
            if(Export_but.isDisplayed() && Export_but.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,Export_but);
                HelpersMethod.ActClick(driver,Export_but,100);
                if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("Firefox"))
                {
                    HelpersMethod.FileDownload();
                }
                //if chrome browser has been used it should close the download popup
                if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("Chrome"))
                {
                    HelpersMethod.FileDownloadsuccessPopup(driver);
                }

                //read order# displayed in new OE page
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//label[contains(text(),'Order #')]");
                HelpersMethod.ScrollElement(driver,WebEle);
                Order_No=HelpersMethod.ReadValue(WebEle);
                scenario.log("EXPORTED ORDER IS "+ Order_No);
                Actual_Order=Order_No.substring(8);

                //Read all the .csv files in download directory and compare with actual order number
               /* File dir = new File("C:\\Users\\Divya.Ramadas\\Downloads");
                FileFilter fileFilter = new WildcardFileFilter("*.csv");
                File[] files = dir.listFiles(fileFilter);
                String file2=null;

                for (File Exportfile:files)
                {
                    String file1 = Exportfile.getName();
                    file1=file1.replaceAll("[a-zA-Z_]","");
                    file2 =file1.trim();
                    for( ;file2.length() > 1 && file2.charAt(0) == '0'; file2 =file2.substring(1));
                }
                scenario.log(file2+" FILE HAS BEEN DOWN LOADED");*/
            }
        }
        catch (Exception e) { }
        return Actual_Order;
    }

    public void Import_button(String ord_No)
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            //send file name to input box
            String Ord_no="Order_"+ord_No+".csv";
            scenario.log("ORDER IMPORTED IS "+Ord_no);
            if(Import_but.isDisplayed())
            {
                driver.findElement(By.xpath("//input[@id='ImportOrder' and @type='file']")).sendKeys("C:\\Users\\Divya.Ramadas\\Downloads\\"+Ord_no);
                exists=true;
            }

            //Handling import confirmation popup
            if(HelpersMethod.IsExists("//div[contains(text(),'overridden on import')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,100);
            }

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //After import add some Qty to 1st product in the grid
    public void QtyProdGrid(String Qty)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')][1]/descendant::input[contains(@id,'TotalUnitsCol')]"),40,Qty);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_on_BackButton()
    {
        WebElement WebEle=null;
        try
        {
            WebElement Back_Checout=driver.findElement(By.id("CancelCheckoutButton"));
            HelpersMethod.ScrollElement(driver,Back_Checout);
            HelpersMethod.ClickBut(driver,Back_Checout,100);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
        }
        catch (Exception e){}
    }

    public void FindtableHeader(String To_Text)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            WebElement OEProdGrid=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver,OEProdGrid);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]",driver))
            {
                List<WebElement> TableHeads=driver.findElements(By.xpath("//thead/tr[1]/th"));
                for(WebElement THead:TableHeads)
                {
                    String Head=THead.getText();
                    if(Head.contains(To_Text))
                    {
                        HelpersMethod.ActDragDrop(driver,THead,To);
                        exists=true;
                    }
                }
            }
            else
            {
                scenario.log("DRAG AND DROP HEADER MAY NOT BE ENABLED, CHECK ADMIN SETTINGS");
            }
            List<WebElement> groups=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-grouping-row']/descendant::p");
            for (WebElement group:groups)
            {
              act.moveToElement(group).build().perform();
              String group_Text=group.getText();
              scenario.log("GROUP VALUE FOUND IS "+group_Text);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Search for Product Description in Search bar
    public void SearchBox_ProdDesc(String Prod_Des)
    {
        exists=false;
        try
        {

            HelpersMethod.ScrollElement(driver, SearchProd);
            HelpersMethod.EnterText(driver,SearchProd,100,Prod_Des);
            HelpersMethod.ClickBut(driver,IndexSearch,100);
            scenario.log("PRODUCT DESCRIPTION SEARCHED IS "+Prod_Des);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }
    //method to find total amount in new order entry page
    public String Total_NewOE()
    {
        String tot_amt=null;
        try
        {
            tot_amt=HelpersMethod.ReadValue(Total_amt);
            scenario.log("TOTAL AMOUNT FOUND IN NEW OE PAGE IS "+tot_amt);
        }
        catch (Exception e){}
        return tot_amt;
    }
    //Reading value in route inputbox
    public String Read_Route()
    {
        String New_route=null;
        try
        {
            New_route=driver.findElement(By.id("RouteIndex")).getAttribute("value");
            scenario.log("ROUTE NO. FOUND IN NEW OE PAGE IS "+New_route);
        }
        catch (Exception e){}
        return New_route;
    }

    //Check whether color of Product note icon has been changed or not
    public boolean ProNote_Color()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//tr[1]/descendant::div[contains(@id,'OrderLineCommentIconColIcon')]//*[local-name()='svg' and @fill='black']",driver))
            {
                scenario.log("PRODUCT COMMENT ICON COLOR HAS BEEN CHANGED, BECAUSE OF ADDING COMMENT TO PRODUCT");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    //go to 'Unit' column in New OE grid and click on arrow symbol, to display the units in ascending or descending order
    public boolean clickOnArrow_UnitsAscedning()
    {
        boolean result=false;
        Actions act1=new Actions(driver);
        try
        {
            //HelpersMethod.ScrollElement(driver,Separator);
            List<Integer> Units=new ArrayList<>();
            List<Integer> Units1=new ArrayList<>();
            WebElement UnitHeader=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Unit')]/ancestor::th");
            if(HelpersMethod.EleDisplay(UnitHeader))
            {
                HelpersMethod.ScrollElement(driver,UnitHeader);
                act1.moveToElement(UnitHeader).build().perform();
                act1.click(UnitHeader).build().perform();

                WebElement Acend_Decend=HelpersMethod.FindByElement(driver,"xpath","//th/descendant::span[contains(text(),'Unit')]/following-sibling::span[contains(@class,'k-icon k-i-sort')]");
                if(HelpersMethod.EleDisplay(Acend_Decend))
                {
                    HelpersMethod.ActClick(driver,Acend_Decend,100);
                }
            }
            List<WebElement> Unit_Qtys=HelpersMethod.FindByElements(driver,"xpath","//input[contains(@id,'TotalUnits')]");
            for (WebElement Unit_Qty:Unit_Qtys)
            {
                String Unit_Text=Unit_Qty.getAttribute("value");
                scenario.log(Unit_Text);
                Units.add(Integer.valueOf(Unit_Text));
                Units1.add(Integer.valueOf(Unit_Text));
            }

            //Sort the values in one of the list, here Units1 has been sorted, using collection.reverseOrder()
            Collections.sort(Units1, Collections.reverseOrder());
            result=Units.equals(Units1);
        }
        catch (Exception e){}
        return result;
    }

    //Click on Route index icon in new oe page
    public void RouteIndex()
    {
        try
        {
            if(Route_No.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, Route_No, 100);
                scenario.log("ROUTE NO INDEX HAS BEEN CLICKED");
            }
        }
        catch(Exception e){}
    }

    //Select 2nd route from the popup
    public String SelectRoute()
    {
        String RouteVal=null;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Route #')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='RouteIndexProvider']/descendant::tr[@class='k-master-row'][2]");
                RouteVal=WebEle.getText();

                HelpersMethod.ActClick(driver,WebEle,100);
                if(HelpersMethod.IsExists("//div[contains(text(),'The cutoff time')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement cutoffPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The cutoff time')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement okButton=cutoffPopup.findElement(By.xpath(".//button[text()='Ok']"));
                    HelpersMethod.ClickBut(driver,okButton,100);
                    scenario.log("CUTOFF HAS BEEN REACHED, SO ROUTE CHANGE HAS NOT BEEN DONE");
                }
                scenario.log("ROUTE VALUE SELECTED FROM POPUP IS "+RouteVal);
            }
        }
        catch (Exception e){}
        return RouteVal;
    }

    //Read the route value selected from the Route input
    public String ReadRoute()
    {
        String RouteVal1=null;
        try
        {
            WebElement WebRoute=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@placeholder,'Route #')]");
            RouteVal1=WebRoute.getAttribute("value");
            scenario.log("ROUTE NUMBER FOUND IS "+RouteVal1);
        }
        catch (Exception e){}
        return RouteVal1;
    }

    //Code to select Comment from product grid
    public void SelectComment()
    {
        try
        {
            WebElement CommGrid=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]");
            if(CommGrid.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, CommGrid, 100);
                scenario.log("COMMENT ICON FOR PRODUCT HAS BEEN FOUND");
            }
            else
            {
                scenario.log("COMMENT ICON AT PRODUCT LEVEL HAS NOT BEEN FOUND");
            }
        }
        catch (Exception e){}
    }

    public void AddProdComm(String Comment)
    {
        try
        {
            XPath = "//div[contains(text(),'comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]";
            exists = HelpersMethod.IsExists(XPath, driver);
            if (exists == true)
            {
                driver.findElement(By.id("textAreaA")).sendKeys(Comment);
                scenario.log("PRODUCT COMMENT HAS BEEN ENTERED IS "+Comment);
            }
        }
        catch (Exception e){}
    }

    public void UpdateComment(String Comment)
    {
        try
        {
            XPath = "//div[contains(text(),'comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]";
            exists = HelpersMethod.IsExists(XPath, driver);
            if (exists == true)
            {
                WebElement TextArea=HelpersMethod.FindByElement(driver,"id","textAreaA");
                HelpersMethod.ClearText(driver,TextArea,100);
                HelpersMethod.EnterText(driver,TextArea,100,Comment);
                scenario.log("COMMENT UPDATED IS "+Comment);


            }
        }
        catch (Exception e){}
    }

    public void Update_Button()
    {
        try
        {
            WebElement Update_But=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Update']");
            if(Update_But.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, Update_But, 100);
                scenario.log("UPDATE BUTTON IN COMMENT POPUP HAS BEEN CLICKED");
            }
        }
        catch (Exception e){}
    }

    public void Comment_Add()
    {
        try
        {
            //Click on Add button in the popup
            WebElement Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Add']");
            if(Button_Ele.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, Button_Ele, 100);
                scenario.log("ADD BUTTON IN COMMENT POPUP HAS BEEN CLICKED");
            }
        }
        catch (Exception e){}
    }

    public void Comment_Ok()
    {
        try
        {
            WebElement Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
            if(Button_Ele.isDisplayed())
            {
                //Click on OK button
                HelpersMethod.ClickBut(driver, Button_Ele, 100);
                scenario.log("COMMENT ICON IS CLICKED");
            }
            else
            {scenario.log("COMMENT ICON HAS NOT BEEN DISPLAYED");}
        }
        catch (Exception e){}
    }

    public boolean ValidateProdComment(String UComm)
    {
        try
        {
            exists=false;
            WebElement CommGrid=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::td[2]");
            String Valid=CommGrid.getText();
            if(UComm.equals(Valid))
            {
                exists=true;
            }
            scenario.log("COMMENT UPDATED TO "+Valid);
        }
        catch (Exception e){}
        return exists;
    }

    public void EnterUnitQtyProductLine(String Unit) throws InterruptedException
    {
        WebElement UnitCase = null;
        WebElement YesBut = null;
        try {
            if (HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]", driver))
            {
                if (HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]", driver))
                {
                    UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]");
                    HelpersMethod.ActSendKey(driver, UnitCase, 100, Unit);
                    scenario.log("UNIT ENTERED IN INPUT BOX IS "+Unit);
                   /* for(int i=0;i<=1;i++)
                    {*/
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 100);
                        }
                    /*    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }
                    }*/
                    scenario.log("ENTER UNIT QTY HAS BEEN ENTERED IN PRODUCT GRID");
                }
            }
        }
        catch(Exception e){}
    }
    public void EnterCaseQtyProductLine(String Case) throws InterruptedException
    {
        WebElement UnitCase = null;
        WebElement YesBut = null;
        try
        {
            if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]",driver))
            {
                UnitCase=HelpersMethod.FindByElement(driver,"xpath","//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]");
                HelpersMethod.ActSendKey(driver,UnitCase,100,Case);
                scenario.log("CASES VALUE ENTERED IN INPUT BOX IS "+Case);
              /*  for(int i=0;i<=1;i++)
                {*/
                    if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                        YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                        HelpersMethod.ActClick(driver, YesBut, 100);
                    }
             /*       if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                        YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                        HelpersMethod.ActClick(driver, YesBut, 10);
                    }
                }*/
                scenario.log("ENTER CASE QTY HAS BEEN ENTERED IN PRODUCT GRID");
            }
        }
        catch (Exception e){}
    }

    public void EnterUnusualQtyProductLine(String Unit,String Case)
    {
        WebElement WebEle=null;
        WebElement UnitCase=null;
        WebElement YesBut=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]",driver))
            {
                if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]",driver))
                {
                    UnitCase=HelpersMethod.FindByElement(driver,"xpath","//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]");
                    HelpersMethod.EnterText(driver,UnitCase,100,Unit);
                    scenario.log("UNIT ENTERED IN INPUT BOX IS "+Unit+" FOR QTY EXCEEDS POPUP");
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 100);
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 100);
                        }
                    }
                    HelpersMethod.WaitElementPresent(driver,"id","orderEntryGridContainer",40);
                    HelpersMethod.waitTillElementLocatedDisplayed(driver,"id","orderEntryGridContainer",40);
                }
                else if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]",driver))
                {
                    UnitCase=HelpersMethod.FindByElement(driver,"xpath","//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]");
                    HelpersMethod.EnterText(driver,UnitCase,100,Case);
                    scenario.log("CASES ENTERED IN INPUT BOX IS "+Case+" FOR QTY EXCEEDS POPUP");
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 100);
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 100);
                        }
                    }
                }
                scenario.log("UNUSUAL QTY, FOR CASES AND UNITS POPUP HAS BEEN HANDLED");
            }
        }
        catch (Exception e){}
    }

    public void EnterUnusualUnitQtyProductLine(String Unit)
    {
        WebElement WebEle=null;
        WebElement UnitCase=null;
        WebElement YesBut=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]",driver))
            {
                if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]",driver))
                {
                    UnitCase=HelpersMethod.FindByElement(driver,"xpath","//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]");
                    HelpersMethod.ActSendKey(driver,UnitCase,100,Unit);
                    scenario.log("QTY ENTERED FOR HANDING UNUSUAL QTY POPUP IS "+Unit);
                    /*for(int i=0;i<=1;i++)
                    {*/
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 100);
                        }
                    /*    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }*/
                    //}
                    scenario.log("UNUSUAL QTY, FOR UNITS POPUP HAS BEEN HANDLED");
                }
            }
        }
        catch (Exception e){}
    }

    public void EnterUnusualCaseQtyProductLine(String Case)
    {
        WebElement WebEle=null;
        WebElement UnitCase=null;
        WebElement YesBut=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]",driver))
            {
                if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]",driver))
                {
                    UnitCase=HelpersMethod.FindByElement(driver,"xpath","//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]");
                    HelpersMethod.ScrollElement(driver,UnitCase);
                    HelpersMethod.ActSendKey(driver,UnitCase,100,Case);
                    scenario.log("QTY ENTERED FOR HANDING UNUSUAL QTY POPUP IS "+Case);
                   /* for(int i=0;i<=1;i++)
                    {*/
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                        {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 100);
                        }
                    /*    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                        {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }
                    }*/
                    scenario.log("UNUSUAL QTY, FOR CASE POPUP HAS BEEN HANDLED");
                }
            }
        }
        catch (Exception e){}
    }

    public void SaveOrderWithOutSubmitting()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                WebElement modalContent = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-content k-dialog-content')]"));
                Assert.assertEquals(modalContent.getText(), "Your order has not been submitted.", "Verify Title message");

            }
        }
        catch (Exception e){}
    }

    public boolean SaveOrderWithOutSubmitting_Next()
    {
        exists=false;
        try
        {
            WebElement PopupSubmit = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                exists = true;
                if (HelpersMethod.EleDisplay(PopupSubmit))
                {
                    PopupSubmit = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Next')]");
                    HelpersMethod.ClickBut(driver, PopupSubmit, 200);
                    scenario.log("YOUR ORDER HAS NOT BEEN SUBMITTED, POPUP HAS BEEN HANDLED WITH NEXT BUTTON");
                }
            }
        }
        catch (Exception e){}
        return exists;
    }

    public void Click_On_PriceOverrideIcon()
    {
        exists=false;
        Actions act=new Actions(driver);
        WebElement WebEle;
        String titleText=null;
        String price=null;
        int priceLoc = 0;
        int rowCount=0;
        try
        {
            List<WebElement> titles=HelpersMethod.FindByElements(driver,"xpath", "//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for(int i=0;i<=titles.size()-1;i++)
            {
                WebEle=titles.get(i);
                act.moveToElement(WebEle).build().perform();
                titleText=WebEle.getText();
                if(titleText.equals("Price"))
                {
                    priceLoc=i;
                    scenario.log(String.valueOf(priceLoc));
                    break;
                }
            }
            //check for visisblility of price override icon
            List<WebElement> priceInput=HelpersMethod.FindByElements(driver,"xpath","//tr/td["+(priceLoc+1)+"]/descendant::input");
            for (int i=1;i<priceInput.size();i++)
            {
                WebEle=priceInput.get(i);
                act.moveToElement(WebEle).build().perform();
                if(WebEle.isDisplayed())
                {
                    scenario.log("PRICE FOUND BEFORE PRICE OVERRIDE "+WebEle.getText());
                    rowCount=i;
                    break;
                }
            }
            //to identify price override icon
            WebElement priceOverIcon=HelpersMethod.FindByElement(driver,"xpath","//tr["+rowCount+"]/td["+(priceLoc+1)+"]/descendant::input/preceding-sibling::div");
            HelpersMethod.ActClick(driver,priceOverIcon,200);
            //validate visibility of price override dialog box
            if(HelpersMethod.IsExists("//div[contains(text(),'Price override')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                scenario.log("PRICE OVERRIDE DIALOG BOX HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PriceOverridePopup_WhatIfPricePrice(String priceOverride)
    {
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Price override')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //What if button, finding webelement
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'What if (alt-w)')]");
                HelpersMethod.ClickBut(driver,WebEle,100);
                if(HelpersMethod.IsExists("//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"id","overridePrice");
                    String PriceFound=HelpersMethod.JSGetValueEle(driver,WebEle,100);
                    scenario.log("ACTUAL PRICE FOUND IS "+PriceFound);
                    HelpersMethod.JSSetValueEle(driver,WebEle,100,priceOverride);
                    scenario.log("PRICE OVERRIDED BY "+priceOverride);
                    //Click on Ok button in popup
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,100);
                    if(HelpersMethod.IsExists("//li[contains(text(),'price was set to the original price.')]/ancestor::div[contains(@class,'k-widget k-notification k-notification-error')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-notification-error')]//*[local-name()='svg' and contains(@class,'close-error')]//*[local-name()='path']");
                        HelpersMethod.ClickBut(driver,WebEle,100);
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void PriceOverridePopup_WhatIfPriceUnit(String priceOverride)
    {
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Price override')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //What if button, finding webelement
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'What if (alt-w)')]");
                HelpersMethod.ClickBut(driver,WebEle,100);
                if(HelpersMethod.IsExists("//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"id","overridePricePerUnit");
                    String PriceFound=HelpersMethod.JSGetValueEle(driver,WebEle,100);
                    scenario.log("ACTUAL PRICE FOUND IS "+PriceFound);
                    HelpersMethod.JSSetValueEle(driver,WebEle,100,priceOverride);
                    scenario.log("PRICE OVERRIDED BY "+priceOverride);
                    //Click on Ok button in popup
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,100);
                    if(HelpersMethod.IsExists("//li[contains(text(),'price was set to the original price.')]/ancestor::div[contains(@class,'k-widget k-notification k-notification-error')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-notification-error')]//*[local-name()='svg' and contains(@class,'close-error')]//*[local-name()='path']");
                        HelpersMethod.ClickBut(driver,WebEle,100);
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void ReadProductNo()
    {
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.JSScroll(driver,WebEle);
            scenario.log("PRODUCT # FOUND IN NEW ORDER ENTRY PAGE ARE");

            List<WebElement> ProdNos=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@id,'ProductIdCol')]/a");
            for (WebElement ProdNo:ProdNos)
            {
                String Prod=ProdNo.getText();
                scenario.log(Prod);
            }
        }
        catch (Exception e){}
    }

    public void Validate_Pickup_Order()
    {
        exists=false;
        try
        {
            boolean result1=HelpersMethod.IsExists("//div[contains(@class,'inline-form-group form-group form-group-sm')]/span[contains(text(),'Date')]",driver);
            String result=PickupOrder.getAttribute("disabled");
            if(result.equals("")||result1==true)
            {
                scenario.log("PICKUP ORDER HAS BEEN SELECTED");
                exists=true;
                if(result1==true)
                {
                    String pickDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'inline-form-group form-group form-group-sm')]/span[contains(text(),'Date')]/following-sibling::span").getText();
                    scenario.log("PICKUP DATE IN NEW OE PAGE IS "+pickDate);
                }
            }
            else
            {
                scenario.log("PICKUP ORDER CHECKBOX IS NOT SELECTED");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintNewOE()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(PrintBut.isDisplayed() && PrintBut.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, PrintBut);
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, PrintBut, 100);
                scenario.log("PRINT BUTTON HAS BEEN CLICKED IN NEW OE PAGE");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
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
                        scenario.log("PRINT BUTTON FOR ALL ORDER HAS BEEN HANDLED");
                    }
                }
                driver.switchTo().window(ParentWindow);
            }
            else
            {
                scenario.log("PRINT BUTTON IS NOT ENABLED");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void No_Products_in_ProdGrid()
    {
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-pager-info k-label')]");
        }
        catch (Exception e){}
    }

    public void ValidateChangeDeliveryDatePopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectChangeDeliveryDatePopup()
    {
       // exists=false;
        WebElement WebEle;
        try
        {
            for(int i=0;i<=1;i++)
            {
                if(HelpersMethod.IsExists("//div[text()='Warning']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,100);
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Change delivery date')]");
                    HelpersMethod.ClickBut(driver, WebEle, 100);
                   // exists = true;
                }
            }
         //   Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void VerifyForMessageForPOMandatory()
    {
        exists=false;
        WebElement PO_Notification;
        try
        {
            if(!PO_No.getText().equals(" "))
            {
                HelpersMethod.ActClearKey(driver,PO_No,100);
                PO_Notification=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Po number must be provided for the current order.')]");
                if(PO_Notification.isDisplayed())
                {
                    scenario.log("PO# IS MANDATORY FIELD");
                    exists=true;
                }
            }
            else
            {
                PO_Notification=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Po number must be provided for the current order.')]");
                if (PO_Notification.isDisplayed())
                {
                    scenario.log("PO# IS MANDATORY FIELD");
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void VerifyProductGrid()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[contains(@class,'order-grid-heading')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void VerifyWebElements()
    {
        exists=false;
        try
        {
            if(!QuickPro.isEnabled() && !QuickCase.isEnabled() && !QuickUnit.isEnabled())
            {
                scenario.log("ALL WEB ELEMENTS ARE DISABLED, BECAUSE PO# IS MANDATORY FIELD");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickPickupCheckBox()
    {
        exists=false;
        try
        {
            if(PickupOrder.isDisplayed() && !PickupOrder.isSelected())
            {
                HelpersMethod.ClickBut(driver,PickupOrder,100);
                scenario.log("PICKUP ORDER CHECK BOX IS CLICKED");
                exists=true;
            }
            else
            {
                scenario.log("THERE IS NO, PICKUP ORDER CHECK BOX IN NEW ORDER ENTRY PAGE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterPriceInInputBox(String price)
    {
        exists=false;
        WebElement WebEle;
        String price1=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","FinalPriceCol0");
            HelpersMethod.ActSendKey(driver,WebEle,100," ");
            HelpersMethod.JSSetValueEle(driver,WebEle,100,price);
            price1=HelpersMethod.JSGetValueEle(driver,WebEle,100);
            if(price.equals(price1))
            {
                exists=true;
            }
            scenario.log("VALUE ENTERED FOR PRICE IS "+price1);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidatePriceOverloadIcon()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]/descendant::div[@class='icon-preview-background']//*[local-name()='svg' and @fill='#000000']",driver))
            {
                exists=true;
                scenario.log("PRICE OVERRIDE ICON COLOR HAS BEEN CHANGED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readProductsInOrder()
    {
        exists=false;
        Actions act1=new Actions(driver);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }

            //new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.id("orderEntryGridContainer"))));
            if(HelpersMethod.IsExists("//div[@id='orderEntryGridContainer']",driver))
            {
                WebElement produGrid = HelpersMethod.FindByElement(driver, "id", "orderEntryGridContainer");
                HelpersMethod.ScrollElement(driver, produGrid);
                scenario.log("PRODUCT FOUND IN ORDER ARE ");
                List<WebElement> Products = HelpersMethod.FindByElements(driver, "xpath", "//td[contains(@class,'CPKendoDataGrid-td pointerRow')]/descendant::a[@data-value='formattedValue']");
                for (WebElement prod : Products) {
                    act1.moveToElement(prod).build().perform();
                    String prod_Text = prod.getText();
                    scenario.log(prod_Text);
                }
                exists=true;
            }
            else
            {
                scenario.log("NO PRODUCTS FOUND IN ORDER");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void handleTirePricingpopup()
    {
        if(HelpersMethod.IsExists("//div[contains(text(),'the following product ')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
        {
            WebElement tirePricing=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'the following product ')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement continueButton=tirePricing.findElement(By.xpath(".//button[text()='Continue']"));
            HelpersMethod.ClickBut(driver,continueButton,100);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 60000);
            }
        }
    }

    public String readUnitOfMeasure()
    {
        WebElement unitOfMeasure= HelpersMethod.FindByElement(driver,"xpath","//span[@id='quickEntryUMs']/span[@class='k-input']");
        return unitOfMeasure.getText();
    }

    public void verifySkipButton()
    {
        exists=false;
        try
        {
            WebElement skipButton=HelpersMethod.FindByElement(driver,"id","skipButton");
            if(skipButton.isDisplayed())
            {
                scenario.log("SKIP BUTTON HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateDefaultGrid(String grid)
    {
        exists=false;
        try
        {
            WebElement gridSelected=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='grid-selection']");
            String gridName=gridSelected.getText();
            if(gridName.contains(grid))
            { exists=true;}
            scenario.log("GRID SELECTED IN NEW ORDER "+gridName);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnFilterQty()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='filterByQuantities']",driver))
            {
                HelpersMethod.ActClick(driver, ShowAllProd, 100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectFilterQty(String arg0)
    {
        exists=false;
        String listEle_Text=null;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container')]",driver))
            {
                List<WebElement> listEles = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
                for (WebElement listEle:listEles)
                {
                    act.moveToElement(listEle).build().perform();
                    listEle_Text=listEle.getText();
                    if(listEle_Text.equals(arg0))
                    {
                        act.moveToElement(listEle).build().perform();
                        act.click(listEle).build().perform();
                        scenario.log(arg0+" HAS BEEN SELECTED FROM FILTER BY QTY DROP DOWN");
                        break;
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void displayProductsWithAvailableInventory()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(!HelpersMethod.IsExists("//td[contains(text(),'No records available')]",driver))
            {
                exists=true;
            }
            if(exists==true)
            {
                List<WebElement> prods = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@id,'ProductIdCol')]/a");
                for (WebElement prod : prods)
                {
                    act.moveToElement(prod).build().perform();
                    scenario.log("PRODUCTS FOUND IN PRODUCT GRID IN NEW OE PAGE "+prod.getText());
                }
            }
            else
            {
                scenario.log("NO PRODUCTS HAS BEEN FOUND, WHEN FILTERED WITH 'Show only products with available inventory'");
            }
        }
        catch (Exception e){}
    }

    public void selectProfileProducts()
    {
        exists=false;
        String listEle_Text=null;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container')]",driver))
            {
                List<WebElement> listEles = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
                for (WebElement listEle:listEles)
                {
                    act.moveToElement(listEle).build().perform();
                    listEle_Text=listEle.getText();
                    if(listEle_Text.equals("From profile"))
                    {
                        act.moveToElement(listEle).build().perform();
                        act.click(listEle).build().perform();
                        scenario.log("'From profile' HAS BEEN SELECTED FROM ADD PRODUCTS DROP DOWN");
                        break;
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void validateCatalogdialog()
    {
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
        WebElement catalogDialog = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        WebElement modalContentTitle = catalogDialog.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Catalog", "Verify Title message");
    }

    public void showAllProductDropDown() 
    {
        exists=false;
        WebElement showAllProd;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CPQoh']",driver))
            {
                showAllProd = HelpersMethod.FindByElement(driver, "id", "CPQoh");
                HelpersMethod.ActClick(driver,showAllProd,800);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectShowAllProductDropDown()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> allProds=dropDown.findElements(By.xpath(".//ul/li"));
            for(int i=0;i<= allProds.size()-1;i++)
            {
                act.moveToElement(allProds.get(1)).click().build().perform();
                exists=true;
                break;
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            WebElement dropDown1=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPQoh']/span[@class='k-input']");
            String selectValue=dropDown1.getText();
            scenario.log("OPTION SELECTED IN ALL PRODUCTS DROPDOWN "+selectValue);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readProducts()
    {
        exists=false;
        String pro_No;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products found.')]",driver))
            {
                scenario.log("NO PRODUCTS HAS BEEN FOUND");
                exists=true;
            }
            else
            {
                WebElement scroll=HelpersMethod.FindByElement(driver,"xpath","//div[@class='product-number']");
                HelpersMethod.ScrollElement(driver,scroll);
                List<WebElement> prods=HelpersMethod.FindByElements(driver,"xpath","//div[@class='product-number']");
                for (WebElement prod:prods)
                {
                     act.moveToElement(prod).build().perform();
                     pro_No=prod.getText();
                     scenario.log("PRODUCT NUMBER FOUND IS "+pro_No);
                     exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void resetFilters()
    {
        exists=false;
        try
        {
            WebElement resetFilter = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='productFilterResetBtn']");
            HelpersMethod.ClickBut(driver, resetFilter, 100);
            exists = true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void ogDropDown()
    {
        exists=false;
        WebElement showAllProd;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CPorderGuies']",driver))
            {
                showAllProd = HelpersMethod.FindByElement(driver, "id", "CPorderGuies");
                HelpersMethod.ActClick(driver,showAllProd,800);
                exists = true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectOGDropDown(String arg3)
    {
            exists=false;
            String prods;
            Actions act=new Actions(driver);
            try
            {
                WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
                List<WebElement> allProds=dropDown.findElements(By.xpath(".//ul/li"));
                for(WebElement prod:allProds)
                {
                    act.moveToElement(prod).build().perform();
                    prods=prod.getText();
                    if(prods.contains(arg3))
                    {
                        act.moveToElement(prod).build().perform();
                        act.click(prod).build().perform();
                        exists=true;
                        break;
                    }
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
                WebElement dropDown1=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPorderGuies']/span[@class='k-input']");
                String selectValue=dropDown1.getText();
                scenario.log("OPTION SELECTED FROM ORDER GUIDE DROP DOWN "+selectValue);
                Assert.assertEquals(exists,true);
            }
            catch (Exception e){}
    }

    public void categoryDropDown()
    {
        exists=false;
        WebElement showAllProd;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CPcategories']",driver))
            {
                showAllProd = HelpersMethod.FindByElement(driver, "id", "CPcategories");
                HelpersMethod.ActClick(driver,showAllProd,800);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCategoryDropDown(String arg0)
    {
        exists=false;
        String prods;
        Actions act=new Actions(driver);
        try
        {
            WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> allProds=dropDown.findElements(By.xpath(".//ul/li"));
            for(WebElement prod:allProds)
            {
                act.moveToElement(prod).build().perform();
                prods=prod.getText();
                if(prods.equals(arg0))
                {
                    act.moveToElement(prod).build().perform();
                    act.click(prod).build().perform();
                    exists = true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            WebElement dropDown1=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPcategories']/span[@class='k-input']");
            String selectValue=dropDown1.getText();
            scenario.log("OPTION SELECTED FROM CATEGORY DROP DOWN "+selectValue);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void subCategoryDropDown()
    {
        exists=false;
        WebElement showAllProd;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CPbrands']",driver))
            {
                showAllProd = HelpersMethod.FindByElement(driver, "id", "CPbrands");
                HelpersMethod.ActClick(driver,showAllProd,800);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectSubCategoryDropDown(String arg1)
    {
        exists = false;
        String prods;
        Actions act = new Actions(driver);
        try {
            WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> allProds = dropDown.findElements(By.xpath(".//ul/li"));
            for (WebElement prod : allProds)
            {
                act.moveToElement(prod).build().perform();
                prods = prod.getText();
                if (prods.equals(arg1))
                {
                    act.moveToElement(prod).build().perform();
                    act.click(prod).build().perform();
                    exists = true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            WebElement  dropDown1=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPbrands']/span[@class='k-input']");
            String selectValue=dropDown1.getText();
            scenario.log("OPTION SELECTED FROM SUB-CATEGORY DROP DOWN "+selectValue);
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void brandDropDown()
    {
        exists=false;
        WebElement showAllProd;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CPsizes']",driver))
            {
                showAllProd = HelpersMethod.FindByElement(driver, "id", "CPsizes");
                HelpersMethod.ActClick(driver,showAllProd,800);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectBrandDropDown(String arg2)
    {
        exists=false;
        String prods;
        Actions act=new Actions(driver);
        try
        {
            WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> allProds=dropDown.findElements(By.xpath(".//ul/li"));
            for(WebElement prod:allProds)
            {
                act.moveToElement(prod).build().perform();
                prods=prod.getText();
                if(prods.equals(arg2))
                {
                    act.moveToElement(prod).build().perform();
                    act.click(prod).build().perform();
                    exists = true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            WebElement dropDown1=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPsizes']/span[@class='k-input']");
            String selectValue=dropDown1.getText();
            scenario.log("OPTION SELECTED FROM BRAND DROP DOWN "+selectValue);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCardView()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
            {
                exists=true;
            }
            else
            {
                scenario.log("CARLOG IS NOT DISPLAYED IN CARD VIEW");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnGridTypeDropdown()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//button[@data-test-id='grid-selection']",driver))
            {
                HelpersMethod.ClickBut(driver,gridType,100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectGridTypeDropDown(String gType)
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");
            List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
            for (WebElement opt:Options)
            {
                act1.moveToElement(opt).build().perform();
                String Opt = opt.getText();
                if (Opt.equals(gType))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                    }

                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateGridType(String gType)
    {
        exists=false;
        try
        {
            String gridValue=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='grid-selection']").getText();
            if(gridValue.equals(gType))
            {
                scenario.log("GRID TYPE SELECTED IS "+gType);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validatePriceOverrideIcon()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//input[contains(@id,'FinalPriceCol')]/preceding-sibling::div//*[local-name()='path' and contains(@d,'M12')]",driver))
            {
                scenario.log("PRICE OVERRIDE ICON HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void listCatelog()
    {
        exists=false;
        String head_text;
        String status;
        int i=0;
        Actions act1=new Actions(driver);
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
            if(HelpersMethod.IsExists("//button[@class='i-grid__filter-button']",driver))
            {
                //if filter header is not displayed click on filter icon
               if(!HelpersMethod.IsExists("//span[contains(@class,'k-i-filter-clear k-icon')]",driver))
               {
                   WebElement filterIcon=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-i-filter-clear k-icon')]");
                   HelpersMethod.JScriptClick(driver,filterIcon,1000);
               }
               //Find all the headers of catalog dialog box, when displayed in list view
                List<WebElement> headers = HelpersMethod.FindByElements(driver, "xpath", "//th[@class='k-header']/descendant::span[contains(@class,'k-column-title')]");
                for(WebElement head:headers)
                {
                    i++;
                    head_text=head.getText();
                    if(head_text.equals("Category"))
                    {
                        break;
                    }
                }
                //Enter search value in input box
                String searchValue=TestBase.testEnvironment.get_Category();
                WebElement catalogFilter=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-filter-row']/th["+i+"]/descendant::input");
                //act1.moveToElement(catalogFilter).build().perform();
                //act1.sendKeys(catalogFilter,searchValue).build().perform();
                //HelpersMethod.JSSetValueEle(driver,catalogFilter,1000,searchValue);
                driver.findElement(By.xpath("//tr[@class='k-filter-row']/th["+i+"]/descendant::input")).sendKeys("value","searchValue");
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 60000);
                }

                String catFilterVal=HelpersMethod.JSGetValueEle(driver,catalogFilter,1000);
                if(catFilterVal.equals(searchValue))
                {
                    scenario.log("IN CATEGORY OPTION SEARCHED IS "+searchValue);
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
                scenario.log("FILTER NOT VISIBLE, PLZ CHECK ADMIN SETTING");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readProductInList()
    {
        exists=false;
        String prod_Text;
        try
        {
            if(!HelpersMethod.IsExists("//div[@class='i-no-data']",driver))
            {
                WebElement catPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                List<WebElement> Products=catPopup.findElements(By.xpath(".//button[@class='i-link-button']"));
                for (WebElement product:Products)
                {
                    prod_Text= product.getText();
                    scenario.log("PRODUCTS FOUND IN CATALOG "+prod_Text);
                }
            }
            else
            {
                scenario.log("NO PRODUCTS HAS BEEN FOUND");
            }
        }
        catch (Exception e){}
    }

    public void cardCatelog()
    {
      exists=false;
      String catText;
      String catSelect=TestBase.testEnvironment.get_Category();
      Actions act1=new Actions(driver);
      try
      {
          //Click on Category drop down
          WebElement catalogDropdown=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPcategories']");
          HelpersMethod.ActClick(driver,catalogDropdown,1000);
          //create list of elements in dropdown
          WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
          List<WebElement> categoryLists=dropDown.findElements(By.xpath(".//ul/li"));
          //Select value from dropdown
          for(WebElement catList:categoryLists)
          {
              act1.moveToElement(catList).build().perform();
              catText=catList.getText();
              if(catText.equals(catSelect))
              {
                  act1.moveToElement(catList).build().perform();
                  act1.click(catList).build().perform();
                  break;
              }
          }
          //check selected value from dropdown
          String catelogText=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPcategories']/span[@class='k-input']").getText();
          if(catelogText.equals(catSelect))
          {
              exists=true;
          }
          Assert.assertEquals(exists,true);
      }
      catch (Exception e){}
    }

    public void readProductInCard()
    {
        String prod_Text;
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products found.')]",driver))
            {
                WebElement catPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                List<WebElement> Products=catPopup.findElements(By.xpath(".//div[@class='product-number']/span"));
                for (WebElement product:Products)
                {
                    prod_Text= product.getText();
                    scenario.log("PRODUCTS FOUND IN CATALOG "+prod_Text);
                }
                exists=true;
            }
            else
            {
                scenario.log("NO PRODUCTS HAS BEEN FOUND");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void catalogOK()
    {
        exists=false;
        try
        {
            WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement okButton=catalogPopup.findElement(By.xpath(".//button[text()='Ok']"));
            if(okButton.isDisplayed() && okButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,okButton,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
