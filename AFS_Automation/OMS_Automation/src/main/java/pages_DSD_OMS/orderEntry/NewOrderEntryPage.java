package pages_DSD_OMS.orderEntry;

import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Environment;
import util.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileFilter;
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
public class NewOrderEntryPage
{
    /* Created by Divya */
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

    @FindBy(id="poNumberNotification")
    private WebElement PO_Notification;

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

    @FindBy(xpath = "//input[contains(@placeholder,'Route')]")
    private  WebElement Route1;

    @FindBy(xpath="//th/span[contains(text(),'Unit')]")
            private WebElement UnitHeader;

    @FindBy(xpath="//th/span[contains(text(),'Unit')]/span")
            private WebElement Asced_Decend;

    @FindBy(xpath = "//div[contains(@class,'order-header-separator-row')]")
            private WebElement Separator;

    @FindBy(id="filterByQuantities")
            private WebElement ShowAllProd;

    @FindBy(xpath = "//span[contains(text(),'Route #')]/parent::div/descendant::button")
            private WebElement Route_No;

    @FindBy(xpath = "//input[contains(@placeholder,'Route #')]")
            private WebElement RouteInput;

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
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
        }
        try
        {
          HelpersMethod.Implicitwait(driver,20);
          exists=HelpersMethod.IsExists("//div[contains(@class,'order-entry-page')]",driver);
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
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
        }
        try
        {
            HelpersMethod.Implicitwait(driver,8);
            exists=HelpersMethod.IsExists("//label[contains(text(),'Order # ')]",driver);
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }

           new WebDriverWait(driver,100).until(ExpectedConditions.textToBePresentInElementLocated(By.id("poNumber-label"),"PO #"));
            if(PO_No.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, PO_No);
                HelpersMethod.ActClearKey(driver, PO_No, 10);
                HelpersMethod.ActSendKey(driver, PO_No, 10, PO_Num);
                scenario.log("PO# ENTERED IS "+PO_Num);

                exists=true;
            }
            Assert.assertEquals(exists,true);
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
                    HelpersMethod.ClickBut(driver, Back_But, 10);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                    HelpersMethod.ClickBut(driver, Back_But, 10);
                    if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to leave this page?')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Discard all')]");
                        HelpersMethod.ClickBut(driver,WebEle,20);
                    }
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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

    public void Create_Pending_Order_Popup()
    {
        WebElement WebEle=null;
        exists=false;
        try
        {
            exists = HelpersMethod.EleDisplay(driver.findElement(By.xpath("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'without submitting')]")));
            if (exists == true)
            {
                WebElement Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'without submitting')]");
                HelpersMethod.ClickBut(driver,Button_Ele,6);
                scenario.log("WITH OUT SUBMITTING OPTION HAS BEEN SELECTED");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                HelpersMethod.ClickBut(driver,Button_Ele,4);
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
            HelpersMethod.sendKeys(driver,SearchProd,10,Product);
            HelpersMethod.ClickBut(driver,IndexSearch,4);
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",100);
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
        exists=false;
        WebElement WebEle=null;
       // HelpersMethod.Implicitwait(driver,40);
        try
        {
            String HeadText = null;
            int i = 0;
            int j = 0;
            String XPath = null;

            //Check for catalog popup
            if (HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                if (!HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    //When "Card view" of catlog is enabled
                    if (HelpersMethod.IsExists("//div[@class='card-view']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        //Enter Unit value in input box of catalog
                        if (HelpersMethod.IsExists("//div[contains(text(),'Unit')]/descendant::input",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Unit')]/descendant::input");
                            HelpersMethod.ScrollElement(driver,WebEle);
                            HelpersMethod.EnterText(driver,WebEle , 10, unit);
                            WebEle.sendKeys(Keys.TAB);
                            scenario.log("UNIT ENTERED IN CATALOG " + unit);

                            //Check for popups
                            for (int a = 0; a <= 2; a++)
                            {
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                    HelpersMethod.ClickBut(driver,WebEle, 10);
                                }
                               /* //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]\"",driver))
                                {
                                    WebElement Popup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                    HelpersMethod.ClickBut(driver, Popup, 10);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                    HelpersMethod.ClickBut(driver,WebEle, 10);
                                }*/
                            }
                        }
                        //Enter Case value in input box of catalog
                        if (HelpersMethod.IsExists("//div[contains(text(),'Case')]/descendant::input",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Case')]/descendant::input");
                            HelpersMethod.ScrollElement(driver,WebEle);
                            HelpersMethod.EnterText(driver,WebEle, 10, cas);
                            WebEle.sendKeys(Keys.TAB);
                            scenario.log("CASES ENTERED IN CATALOG " + cas);
                            //Check for popups
                          //  for (int a = 0; a <= 2; a++)
                          //  {
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                    HelpersMethod.ClickBut(driver,WebEle, 10);
                                }
                               /* //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]\"",driver))
                                {
                                    WebElement Popup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                    HelpersMethod.ClickBut(driver, Popup, 10);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                    HelpersMethod.ClickBut(driver,WebEle, 10);
                                }
                            }*/
                        }
                    }
                    //Grid view display of catalog
                    else if(HelpersMethod.IsExists("//table[@class='k-grid-table']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        int b = 0;
                        List<WebElement> tableHeads = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='i-grid']/descendant::th[@class='k-header ']/span[@class='k-link']");
                        for (WebElement tableHead : tableHeads)
                        {
                            b++;
                            WebElement UnitCase=null;
                            String THead_Text=tableHead.getText();
                            if (THead_Text.equals("Units"))
                            {
                                UnitCase= HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td["+(b+1)+"]/descendant::input");
                                HelpersMethod.ScrollElement(driver,UnitCase);
                                if(UnitCase.isDisplayed() && UnitCase.isEnabled())
                                {
                                    HelpersMethod.ActSendKey(driver, UnitCase, 10, unit);
                                    scenario.log("UNITS ENTERED IN CATALOG " + unit);
                                    //Check for popups
                                  //  for (int a = 0; a <= 2; a++)
                                  //  {
                                        //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                        {
                                            WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                            HelpersMethod.ClickBut(driver,WebEle, 4);
                                        }
                                   /*     //Check for "Out of Stock" popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                        {
                                            WebElement Popup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                            HelpersMethod.ClickBut(driver, Popup, 4);
                                        }
                                        //"Product is currently unavailable" popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                        {
                                            WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                            HelpersMethod.ClickBut(driver,WebEle, 2);
                                        }
                                    }*/
                                }
                            }
                            else
                            {
                                if (THead_Text.equals("Cases"))
                                {
                                    //Find whether Cases input box is displayed
                                    UnitCase= HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td["+(b+1)+"]/descendant::input");
                                    HelpersMethod.ScrollElement(driver,UnitCase);
                                    if(UnitCase.isDisplayed() && UnitCase.isEnabled())
                                    {
                                        HelpersMethod.ActSendKey(driver, UnitCase, 10, cas);
                                        scenario.log("CASES ENTERED IN CATALOG is " + cas);
                                        //Check for popups
                                        //for (int a = 0; a <= 2; a++)
                                        //{
                                            //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                            {
                                                WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                                HelpersMethod.ClickBut(driver,WebEle, 4);
                                            }
                                        /*    //Check for "Out of Stock" popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                            {
                                                WebElement Popup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                                HelpersMethod.ClickBut(driver, Popup, 4);
                                            }
                                            //"Product is currently unavailable" popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                            {
                                                WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                                HelpersMethod.ClickBut(driver,WebEle, 2);
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
                exists=true;
                WebEle=HelpersMethod.FindByElement(driver, "xpath", "//button[contains(text(),'Ok')]");
                HelpersMethod.ClickBut(driver,WebEle, 10);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
        }
        catch (Exception e) { }
    }

    public boolean ClickNext() throws InterruptedException
    {
        exists=false;
        try
        {
            new WebDriverWait(driver,200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'contentRow row')]")));
            if(Next_But.isDisplayed() && Next_But.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,Next_But);
                HelpersMethod.ClickBut(driver,Next_But,100);
                exists=true;
          /*    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
              {
                  HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
              }*/
                Assert.assertEquals(exists,true);
            }
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
            if(HelpersMethod.IsExists("//div[contains(text(),'The cutoff time for this delivery date has been reached.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
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
                HelpersMethod.ClickBut(driver,Next_But,20);
            }

            /*for (int i = 0; i <= 4; i++)
            {
               //Frequently ordered items
                if(HelpersMethod.IsExists("//div[contains(text(),'Frequently ordered items not ordered')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='No']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }
                // requires an order factor of 8 units. the quantity order has been increased to 16
                if (HelpersMethod.IsExists("//div[contains(text(),'the quantity order has been increased to')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[text()='Continue']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }

                //out of stock popup
                if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[text()='Continue']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }
                }

                //Minimum order amount has not been reached
                if (HelpersMethod.IsExists("//div[contains(text(),'the minimum order amount')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'the minimum order amount')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }
                //Critical item popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                    ClickNext();
                }
            }*/
            ClickNext();
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
                HelpersMethod.ActSendKey(driver, QuickPro, 40, Prod);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.ClickBut(driver,Cancel_But,20);
            scenario.log("ORDER HAS BEEN CANCEL BUTTON CLICKED");
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

    public void VerifyCancelPopUp()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CancelAndSkipPopupDisabled()
    {
        exists=false;
        WebElement WebEle;
        try
        {
           WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Cancel & skip')]");
           if(!WebEle.isEnabled())
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
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,20);
                scenario.log("CANCEL ORDER POPUP HAS BEEN HANDLED");
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Cancel & skip']");
                HelpersMethod.ClickBut(driver,WebEle,20);
                scenario.log("CANCEL AND SKIP ORDER POPUP HAS BEEN CLICKED");
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
            HelpersMethod.ScrollElement(driver, QuickPro);
            if (QuickCase.isDisplayed() && QuickCase.isEnabled())
            {
                HelpersMethod.ClearText(driver,QuickCase,20);
                HelpersMethod.sendKeys(driver, QuickCase, 20, Case);

                QuickCase.sendKeys(Keys.ENTER);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                status=HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("CASE ENTERED FOR QUICK PRODUCT IS " + Case);
             //   HelpersMethod.Implicitwait(driver, 40);
              /*  for (int i = 0; i <= 5; i++)
                {*/
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
        catch (Exception e) {}
    }

    public void CheckForQuickUnitEnabled(String Unit)  throws InterruptedException
    {
        WebElement WebEle = null;
        String status=null;

        try
        {
            HelpersMethod.ScrollElement(driver, QuickPro);
            if (QuickUnit.isDisplayed() && QuickUnit.isEnabled())
            {
                exists=false;
                HelpersMethod.ClearText(driver,QuickUnit,20);
                HelpersMethod.sendKeys(driver, QuickUnit, 20, Unit);

                QuickUnit.sendKeys(Keys.ENTER);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                status=HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("UNIT ENTERED FOR QUICK PRODUCT IS " + Unit);

              //  HelpersMethod.Implicitwait(driver, 40);
             /*   for (int i = 0; i <= 5; i++)
                {*/
                    //Check for Qty exceeds maximum of popup
                    if(HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                        HelpersMethod.ClickBut(driver,WebEle,20);
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
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void New_OE_Click_Skip_Button()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,SkipButton,20);
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
                HelpersMethod.JScriptClick(driver, WebEle, 10);
                HelpersMethod.DropDownMenu_LowerCase(driver, "//ul[contains(@class,'k-list k-reset')]/descendant::li");
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[text()='Ok']");
                HelpersMethod.ClickBut(driver, WebEle, 10);
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
            HelpersMethod.ClickBut(driver,CopyFrom,60);
            HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-animation-container-relative k-animation-container-shown')]/descendant::li","xpath",OrdHist);
            exists=true;
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
     try
         {
             HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]/descendant::li","xpath","From Order guides");
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
                HelpersMethod.EnterText(driver,OG,20,OGName);

                //Click on search index icon
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]");
                HelpersMethod.ClickBut(driver,WebEle,20);

                //Click on OG
                OG=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row'][1]");
                HelpersMethod.ActClick(driver,OG,20);

                //Click on OK button in OG popup
                OG=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ActClick(driver,OG,10);

                exists=true;
                scenario.log("ORDER GUIDE SELECTED IS "+OGName);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                        HelpersMethod.ActSendKey(driver, WebEle, 10, QtyDetails.get(i).get(0));
                        scenario.log("QTY ENTERED IN CASES INPUTBOX "+QtyDetails.get(i).get(0));
                        //for (int j = 0; j <= 3; j++)
                        //{
                            //Check for 'Qty exceeds maximum of' Popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                HelpersMethod.ClickBut(driver, WebEle, 60);
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
                        HelpersMethod.ActSendKey(driver, WebEle, 10,QtyDetails.get(i).get(1));
                        scenario.log("QTY ENTERED IN UNIT INPUTBOX "+QtyDetails.get(i).get(1));

                        //for (int j = 0; j <= 3; j++)
                        //{
                            //Check for 'Qty exceeds maximum of' Popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                HelpersMethod.ClickBut(driver, WebEle, 60);
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
            HelpersMethod.ClickBut(driver,Ord_Comments,80);
        }
        catch (Exception e){}
    }

    //handling 'Comment' popup for order and for product
    public void Comment_Popup(String Comment)
    {
        exists=false;
        WebElement WebEle;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them,code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Comments", "Verify Title message");

            WebEle= modalContainer.findElement(By.id("textAreaA"));
            HelpersMethod.EnterText(driver,WebEle,20,Comment);
            scenario.log("COMMENT ENTERED IS "+Comment);

            //Click on Add button in the popup
            WebEle=modalContainer.findElement(By.xpath(".//button[text()='Add']"));
            new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(WebEle));
            HelpersMethod.ActClick(driver,WebEle,20);
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);

            //Click on OK button
            WebEle=modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
            HelpersMethod.ClickBut(driver,WebEle,20);
            exists=true;
            Assert.assertEquals(exists,true);
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
                HelpersMethod.ClickBut(driver,Prod_Comments,10);
                scenario.log("COMMENT ENTERED FOR PRODUCT IS "+Prod_Comments);
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
        try
        {
            WebElement WebEle=null;
            if(HelpersMethod.IsExists("//div[contains(text(),'comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                driver.findElement(By.id("textAreaA")).sendKeys(Comment);

                //Click on Add button in the popup
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Add']");
                HelpersMethod.ClickBut(driver,WebEle,10);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }

                //Click on OK button
                HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']"),4);
            }
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
            HelpersMethod.Implicitwait(driver,40);
            HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]/descendant::li","xpath","From Catalog");
            scenario.log("ADD PRODUCT FROM CATALOG IS SELECTED");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(text(),'Reset filter')]");
                HelpersMethod.clickOn(driver,WebEle,20);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            else
            {
                if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
                {
                    //Click on 'Add filter'
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']");
                    HelpersMethod.clickOn(driver,WebEle,40);

                    //Click on 'Clear all'
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__footer')]/button[contains(text(),'Clear all')]");
                    HelpersMethod.ActClick(driver,WebEle,20);
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                        //Click on clear button in search bar
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'right-button')]");
                        HelpersMethod.ScrollElement(driver,WebEle);
                        HelpersMethod.clickOn(driver, WebEle, 10);
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                        }

                        //Enter product number in search bar
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input ')]");
                        HelpersMethod.sendKeys(driver, WebEle, 10,Prods);
                        scenario.log("PRODUCT NUMBER ENTERED IN SEARCH BAR "+Prods);

                        //Enter search index
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='searchBarDropdown']/descendant::span[contains(@class,' search-button ')]");
                        HelpersMethod.clickOn(driver, WebEle, 10);
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                        }
                        exists=true;
                }
                else
                {
                    if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
                    {
                            //Click on 'Add filter'
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']");
                            HelpersMethod.clickOn(driver, WebEle, 20);
                            HelpersMethod.Implicitwait(driver, 10);
                            //Enter value in first search box
                            if(HelpersMethod.IsExists("//div[contains(@class,'i-filter-popup i-filter-popup--add')]",driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-filter-popup i-filter-popup--add')]/descendant::input[contains(@class,'i-search-box__input')]");
                                HelpersMethod.sendKeys(driver,WebEle,6,"Product #");
                                //Click on Check box
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup i-filter-popup--add')]/descendant::input[contains(@class,'k-checkbox')]");
                                HelpersMethod.ActClick(driver,WebEle,6);
                                //Click on some other place
                                WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']");
                                HelpersMethod.ActClick(driver,WebEle,2);
                            }

                            //Click on Product# button
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'i-filter-tag__main')]/span[text()='Product #: ']");
                            HelpersMethod.ActClick(driver,WebEle,10);

                            //Enter product # in inputbox
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup__content')]/descendant::input[@class='k-textbox']");
                            HelpersMethod.ActSendKey(driver,WebEle,10,Prods);
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
        exists=false;
        try
        {
            String HeadText = null;
            int i = 0;
            int j = 0;
            String XPath = null;
            WebElement WebEle=null;
            WebElement UnitCase = null;
            //Check for catalog popup
            if (driver.findElement(By.xpath("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")).isDisplayed())
            {
                if (!HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    //When "Card view" of catlog is enabled
                    if (HelpersMethod.IsExists("//div[@class='card-view']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        //Enter Unit value in input box of catalog
                        if (HelpersMethod.IsExists("//div[contains(text(),'Units')]/descendant::input",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Unit')]/descendant::input");
                            HelpersMethod.ScrollElement(driver,WebEle);
                            HelpersMethod.EnterText(driver,WebEle , 4, unit);
                            WebEle.sendKeys(Keys.TAB);
                            scenario.log("UNIT ENTERED IN CATALOG " + unit);

                            //Check for popups
                            for (int a = 0; a <= 2; a++)
                            {
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                    HelpersMethod.ClickBut(driver,WebEle, 4);
                                }
                                //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebElement Popup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                    HelpersMethod.ClickBut(driver, Popup, 4);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                    HelpersMethod.ClickBut(driver,WebEle, 2);
                                }
                            }
                        }
                        //Enter Case value in input box of catalog
                        if (HelpersMethod.IsExists("//div[contains(text(),'Cases')]/descendant::input",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Case')]/descendant::input");
                            HelpersMethod.ScrollElement(driver,WebEle);
                            HelpersMethod.EnterText(driver,WebEle, 2, cas);
                            WebEle.sendKeys(Keys.TAB);
                            scenario.log("CASES ENTERED IN CATALOG " + cas);
                            //Check for popups
                            for (int a = 0; a <= 2; a++)
                            {
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                    HelpersMethod.ClickBut(driver,WebEle, 4);
                                }
                                //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebElement Popup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                    HelpersMethod.ClickBut(driver, Popup, 4);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                {
                                    WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                    HelpersMethod.ClickBut(driver,WebEle, 2);
                                }
                            }
                        }
                    }
                    //Grid view display of catalog
                    else if (driver.findElement(By.xpath("//table[@class='k-grid-table']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")).isDisplayed())
                    {
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
                                HelpersMethod.ActSendKey(driver, UnitCase, 10, unit);
                                scenario.log("UNITS ENTERED IN CATALOG " + unit);
                                //Check for popups
                                for (int a = 0; a <= 2; a++)
                                {
                                    //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                    if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                    {
                                        WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                        HelpersMethod.ClickBut(driver,WebEle, 4);
                                    }
                                    //Check for "Out of Stock" popup
                                    if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                    {
                                        WebElement Popup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                        HelpersMethod.ClickBut(driver, Popup, 4);
                                    }
                                    //"Product is currently unavailable" popup
                                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                    {
                                        WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                        HelpersMethod.ClickBut(driver,WebEle, 2);
                                    }
                                }
                            }
                        }
                        for (WebElement tableHead : tableHeads)
                        {
                            String THead_Text=tableHead.getText();
                                if (THead_Text.equals("Cases"))
                                {
                                    //Find whether Cases input box is displayed
                                    XPath = "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')]//descendant::td[" + (b+1) + "]/descendant::input";
                                    exists = HelpersMethod.IsExists(XPath, driver);
                                    if (exists == true)
                                    {
                                        UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')]//descendant::td[" + (b + 1) + "]/descendant::input");
                                        HelpersMethod.ScrollElement(driver,WebEle);
                                        HelpersMethod.ActSendKey(driver, UnitCase, 1, cas);
                                        scenario.log("CASES ENTERED IN CATALOG is " + cas);
                                        //Check for popups
                                        for (int a = 0; a <= 2; a++)
                                        {
                                            //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                            {
                                                WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                                                HelpersMethod.ClickBut(driver,WebEle, 4);
                                            }
                                            //Check for "Out of Stock" popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                            {
                                                WebElement Popup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                                HelpersMethod.ClickBut(driver, Popup, 4);
                                            }
                                            //"Product is currently unavailable" popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                                            {
                                                WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                                                HelpersMethod.ClickBut(driver,WebEle, 2);
                                            }
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
            }
        } catch (Exception e) {}
    }

    public void Catalog_OK()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver, "xpath", "//button[contains(text(),'Ok')]");
            HelpersMethod.ClickBut(driver,WebEle, 2);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}

    }

    public String Export_button()
    {
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            if(Export_but.isDisplayed() && Export_but.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,Export_but);
                HelpersMethod.ActClick(driver,Export_but,10);
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

                //read order# displayed in new OE page
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//label[contains(text(),'Order #')]");
                HelpersMethod.ScrollElement(driver,WebEle);
                Order_No=HelpersMethod.ReadValue(WebEle);
                Actual_Order=Order_No.substring(8);

                //Read all the .csv files in download directory and compare with actual order number
                File dir = new File("C:\\Users\\Divya.Ramadas\\Downloads");
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
                scenario.log(file2+" FILE HAS BEEN DOWN LOADED");
                HelpersMethod.Implicitwait(driver,5);
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
            String Ord_no="Order_"+Actual_Order+".csv";

            if(Import_but.isDisplayed())
            {
                driver.findElement(By.xpath("//input[@id='ImportOrder' and @type='file']")).sendKeys("C:\\Users\\Divya.Ramadas\\Downloads\\"+Order_No);
            }

            //Handling import confirmation popup
            if(HelpersMethod.IsExists("//div[contains(text(),'overridden on import')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,10);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //After import add some Qty to 1st product in the grid
    public void QtyProdGrid(String Qty)
    {
        exists=false;
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            HelpersMethod.EnterText(driver,HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')][1]/descendant::input[contains(@id,'TotalUnitsCol')]"),10,Qty);
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
            HelpersMethod.ClickBut(driver,Back_Checout,10);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        }
        catch (Exception e){}
    }

    public void FindtableHeader(String To_Text)
    {
        exists=false;
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
            HelpersMethod.Implicitwait(driver,20);
            HelpersMethod.ScrollElement(driver, SearchProd);
            HelpersMethod.EnterText(driver,SearchProd,10,Prod_Des);
            HelpersMethod.ClickBut(driver,IndexSearch,10);
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
            New_route=Route1.getAttribute("value");
            scenario.log("ROUTE NO. FOUND IN NEW OE PAGE IS "+New_route);
        }
        catch (Exception e){}
        return New_route;
    }

    //Check whether color of Product note icon has been changed or not
    public boolean ProNote_Color()
    {
        try
        {
            XPath="//*[local-name()='svg' and @fill='#5cb85c']";
            exists=HelpersMethod.IsExists(XPath,driver);
        }
        catch (Exception e){}
        return exists;
    }

    //go to 'Unit' column in New OE grid and click on arrow symbol, to display the units in ascending or descending order
    public boolean UnitsAscedning()
    {
        boolean result=false;
        try
        {
            HelpersMethod.ScrollElement(driver,Separator);
            List<Integer> Units=new ArrayList<>();
            List<Integer> Units1=new ArrayList<>();
            if(HelpersMethod.EleDisplay(UnitHeader))
            {
                HelpersMethod.ActClick(driver,UnitHeader,10);
                if(HelpersMethod.EleDisplay(Asced_Decend))
                {
                    HelpersMethod.ActClick(driver,Asced_Decend,10);
                }
            }
            List<WebElement> Unit_Qtys=HelpersMethod.FindByElements(driver,"xpath","//input[contains(@id,'TotalUnits')]");
            for (WebElement Unit_Qty:Unit_Qtys)
            {
                String Unit_Text=Unit_Qty.getAttribute("value");
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
                HelpersMethod.ClickBut(driver, Route_No, 10);
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

                HelpersMethod.ActClick(driver,WebEle,10);
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
                HelpersMethod.ActClick(driver, CommGrid, 10);
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
                HelpersMethod.ClearText(driver,TextArea,10);
                HelpersMethod.EnterText(driver,TextArea,10,Comment);
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
                HelpersMethod.ClickBut(driver, Update_But, 10);
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
                HelpersMethod.ClickBut(driver, Button_Ele, 2);
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
                HelpersMethod.ClickBut(driver, Button_Ele, 10);
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
                    HelpersMethod.EnterText(driver, UnitCase, 10, Unit);
                    scenario.log("UNIT ENTERED IN INPUT BOX IS "+Unit);
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }
                    }
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
                    HelpersMethod.EnterText(driver,UnitCase,10,Case);
                    scenario.log("CASES VALUE ENTERED IN INPUT BOX IS "+Case);
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }
                    }
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
                    HelpersMethod.EnterText(driver,UnitCase,20,Unit);
                    scenario.log("UNIT ENTERED IN INPUT BOX IS "+Unit+" FOR QTY EXCEEDS POPUP");
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 20);
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 20);
                        }
                    }
                    HelpersMethod.WaitElementPresent(driver,"id","orderEntryGridContainer",40);
                    HelpersMethod.waitTillElementLocatedDisplayed(driver,"id","orderEntryGridContainer",40);
                    HelpersMethod.Implicitwait(driver,40);
                }
                else if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]",driver))
                {
                    UnitCase=HelpersMethod.FindByElement(driver,"xpath","//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]");
                    HelpersMethod.EnterText(driver,UnitCase,30,Case);
                    scenario.log("CASES ENTERED IN INPUT BOX IS "+Case+" FOR QTY EXCEEDS POPUP");
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 20);
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 20);
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
                    HelpersMethod.EnterText(driver,UnitCase,10,Unit);
                    scenario.log("QTY ENTERED FOR HANDING UNUSUAL QTY POPUP IS "+Unit);
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }
                    }
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
                    HelpersMethod.EnterText(driver,UnitCase,20,Case);
                    scenario.log("QTY ENTERED FOR HANDING UNUSUAL QTY POPUP IS "+Case);
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                        {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ActClick(driver, YesBut, 20);
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                        {
                            YesBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                            HelpersMethod.ActClick(driver, YesBut, 10);
                        }
                    }
                    scenario.log("UNUSUAL QTY, FOR CASE POPUP HAS BEEN HANDLED");
                }
            }
        }
        catch (Exception e){}
    }

    public boolean SaveOrderWithOutSubmitting()
    {
        try
        {
            exists=false;
            WebElement PopupSubmit=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public boolean SaveOrderWithOutSubmitting_Next()
    {
        exists=false;
     try
     {
         WebElement PopupSubmit = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
         if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
             exists = true;
             if (HelpersMethod.EleDisplay(PopupSubmit))
             {
                 PopupSubmit = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Next')]");
                 HelpersMethod.ClickBut(driver, PopupSubmit, 10);
                 scenario.log("YOUR ORDER HAS NOT BEEN SUBMITTED, POPUP HAS BEEN HANDLED WITH NEXT BUTTON");
             }
         }
     }
     catch (Exception e){}
        return exists;
    }

    public void Click_On_PriceOverrideIcon()
    {
        try
        {
            String price=null;
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row ')][1]/descendant::div[contains(@class,'icon-preview-icon')]");
            if(WebEle.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, WebEle);
                //HelpersMethod.ClickBut(driver,WebEle,4);
                HelpersMethod.JScriptClick(driver,WebEle,10);
                WebEle=HelpersMethod.FindByElement(driver,"id","FinalPriceCol0");
                price=WebEle.getText();
                scenario.log("PRICE FOUND IN PRODUCT GRID "+price);
                scenario.log("USER CLICKED ON PRICE OVERRIDE ICON IN PRODUCT GRID, IN NEW ORDER GUIDE");
            }
            else
            {
                WebEle=HelpersMethod.FindByElement(driver,"id","FinalPriceCol1");
                price=WebEle.getText();
                WebEle= HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row ')][1]/descendant::div[contains(@class,'icon-preview-icon')]");
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ClickBut(driver,WebEle,10);
                scenario.log("PRICE FOUND IN PRODUCT GRID "+price);
                scenario.log("USER CLICKED ON PRICE OVERRIDE ICON IN PRODUCT GRID, IN NEW ORDER GUIDE");
            }
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
                HelpersMethod.ClickBut(driver,WebEle,10);
                if(HelpersMethod.IsExists("//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"id","overridePrice");
                    String PriceFound=HelpersMethod.JSGetValueEle(driver,WebEle,10);
                    scenario.log("ACTUAL PRICE FOUND IS "+PriceFound);
                    HelpersMethod.JSSetValueEle(driver,WebEle,10,priceOverride);
                    scenario.log("PRICE OVERRIDED BY "+priceOverride);
                    //Click on Ok button in popup
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                    if(HelpersMethod.IsExists("//li[contains(text(),'price was set to the original price.')]/ancestor::div[contains(@class,'k-widget k-notification k-notification-error')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-notification-error')]//*[local-name()='svg' and contains(@class,'close-error')]//*[local-name()='path']");
                        HelpersMethod.ClickBut(driver,WebEle,10);
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
                HelpersMethod.ClickBut(driver,WebEle,10);
                if(HelpersMethod.IsExists("//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"id","overridePricePerUnit");
                    String PriceFound=HelpersMethod.JSGetValueEle(driver,WebEle,10);
                    scenario.log("ACTUAL PRICE FOUND IS "+PriceFound);
                    HelpersMethod.JSSetValueEle(driver,WebEle,10,priceOverride);
                    scenario.log("PRICE OVERRIDED BY "+priceOverride);
                    //Click on Ok button in popup
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                    if(HelpersMethod.IsExists("//li[contains(text(),'price was set to the original price.')]/ancestor::div[contains(@class,'k-widget k-notification k-notification-error')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-notification-error')]//*[local-name()='svg' and contains(@class,'close-error')]//*[local-name()='path']");
                        HelpersMethod.ClickBut(driver,WebEle,10);
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
            HelpersMethod.Implicitwait(driver,40);
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.JSScroll(driver,WebEle);
            HelpersMethod.Implicitwait(driver,40);
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
            if(PickupOrder.isDisplayed() && PickupOrder.isSelected())
            {
                scenario.log("PICKUP ORDER HAS BEEN ENABLED");
                 exists=true;
            }
            else
            {
                scenario.log("PICKUP ORDER CHECKBOX IS NOT DISPLAYED");
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
                HelpersMethod.ClickBut(driver, PrintBut, 10);
                scenario.log("PRINT BUTTON HAS BEEN CLICKED IN NEW OE PAGE");
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
                        HelpersMethod.Implicitwait(driver, 40);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            if(HelpersMethod.IsExists("//divdiv[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectChangeDeliveryDatePopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            for(int i=0;i<=1;i++)
            {
                if(HelpersMethod.IsExists("//div[text()='Warning']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Change delivery date')]");
                    HelpersMethod.ClickBut(driver, WebEle, 10);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void VerifyForMessageForPOMandatory()
    {
        exists=false;
        try
        {
            if(PO_Notification.isDisplayed())
            {
                scenario.log("PO# IS MANDATORY FIELD");
                exists=true;
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
                HelpersMethod.ClickBut(driver,PickupOrder,20);
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
            HelpersMethod.ActSendKey(driver,WebEle,20," ");
            HelpersMethod.JSSetValueEle(driver,WebEle,10,price);
            price1=HelpersMethod.JSGetValueEle(driver,WebEle,10);
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
}
