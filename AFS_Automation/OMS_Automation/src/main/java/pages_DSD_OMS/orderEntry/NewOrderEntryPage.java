package pages_DSD_OMS.orderEntry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en_old.Ac;
import org.apache.commons.io.filefilter.WildcardFileFilter;
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
import util.DataBaseConnection;
import util.TestBase;

import java.awt.*;
import java.io.File;
import java.io.FileFilter;
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

    @FindBy(xpath = "//input[@id='quickUnits']|//input[@id='quickCases']")
    private WebElement QuickCase;

    @FindBy(xpath = "//input[@id='quickUnits']")
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

    @FindBy(id="copy-selection")
    private WebElement CopyFrom;

    @FindBy(id="addButton")
    private WebElement AddProduct;

    @FindBy(id="PrintButton")
    private  WebElement PrintBut;

    @FindBy(xpath = "//button[@data-test-id='commentButton']")
    private WebElement Ord_Comments;

    @FindBy(xpath = "//tr[1]/descendant::div[contains(@id,'OrderLineCommentIconColIcon')]")
    private WebElement Prod_Comments;

    @FindBy(xpath = "//button/span[text()='Export']")
    private WebElement Export_but;

    @FindBy(xpath = "//label[text()='Import']//*[local-name()='svg' and contains(@class,'import-icon')]")
    private  WebElement Import_but;

    @FindBy(xpath = "//input[@id='ImportOrder']")
    private WebElement Import_Input;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-grouping-drop-container')]")
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

    @FindBy(xpath="//button[@data-test-id='grid-selection']/span")
    private WebElement gridType;

    @FindBy(xpath="//span[@id='quickEntryUMs']")
    private WebElement uomDropDown;

    static boolean exists = false;
    static String XPath;
    static String Order_No;
    static String Actual_Order;
    static int rowIndex=0;
    static String baseCost;

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

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
           if(HelpersMethod.IsExists("//div[@id='orderEntryCard']",driver))
           {
                scenario.log("NEW ORDER ENTRY PAGE HAS BEEN FOUND");
                exists=true;
           }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    public boolean verificationOfNewOE()
    {
        exists=false;

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'order-entry-page')]",driver))
            {
                scenario.log("NEW ORDER ENTRY PAGE HAS BEEN FOUND");
                exists=true;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public boolean ValidateNewOEAllOrder() throws InterruptedException
    {
        exists=false;

        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
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

        exists=false;
        String status;

        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        try
        {
            Thread.sleep(4000);
           if(HelpersMethod.IsExists("//label[contains(text(),'Order # ')]",driver))
           {
               scenario.log("NEW ORDER ENTRY PAGE HAS BEEN FOUND");
               exists=true;
               Thread.sleep(4000);
           }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    public void EnterPO_No(String PO_Num) throws InterruptedException
    {

        exists=false;

        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("orderEntryCard"))));
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.textToBePresentInElementLocated(By.id("poNumber-label"), "PO #"));
            if (PO_No.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, PO_No);
                HelpersMethod.ActClearKey(driver, PO_No, 20000);
                HelpersMethod.ActSendKey(driver, PO_No, 20000, PO_Num);
                PO_No.sendKeys(Keys.TAB);
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("orderEntryCard"))));
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
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExistsById("orderEntryCard",driver))
            {
                if(Back_But.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver,Back_But);
                    HelpersMethod.ClickBut(driver, Back_But, 10000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
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
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@class='header-value-row quick-entry-bar header-open row']",driver))
            {
                if(Back_But.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver,Back_But);
                    HelpersMethod.ClickBut(driver, Back_But, 10000);
                    exists=true;
                    if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to leave this page?')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Discard all')]");
                        HelpersMethod.ClickBut(driver,WebEle,10000);
                    }
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    String status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickBackButtonAccountChange()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@class='header-value-row quick-entry-bar header-open row']",driver))
            {
                if(Back_But.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver,Back_But);
                    HelpersMethod.ClickBut(driver, Back_But, 10000);
                    exists=true;
                    if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to leave this page?')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Discard all')]");
                        HelpersMethod.ClickBut(driver,WebEle,10000);
                    }
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    String status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
           //Assert.assertEquals(exists, true);
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
                    HelpersMethod.ClickBut(driver, Back_But, 10000);
                    if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to leave this page?')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                    {
                        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
                        Assert.assertEquals(modalContentTitle.getText(), "Your order has not been submitted. Are you sure you want to leave this page?", "Verify Title message");
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void Create_Pending_Order_Popup()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement pendingOrderPopup =HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                WebElement startOrder=pendingOrderPopup.findElement(By.xpath(".//button/span[contains(text(),'without submitting')]"));
                HelpersMethod.ClickBut(driver,startOrder,10000);
                scenario.log("PENDING ORDER WITH OUT SUBMITTING OPTION HAS BEEN SELECTED");
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement Button_Ele=dialogPopup.findElement(By.xpath(".//button/span[contains(text(),'Discard all')]"));
                HelpersMethod.ActClick(driver,Button_Ele,10000);
                scenario.log("DISCARD ALL PENDING ORDER OPTION IS SELECTED");
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(2000);
        }
        catch (Exception e){}
    }

    public void EnterProdNo_InSearchBar(String Product)
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver, SearchProd);
            HelpersMethod.sendKeys(driver,SearchProd,10000,Product);
            HelpersMethod.ClickBut(driver,IndexSearch,10000);
            exists=true;
            scenario.log("PRODUCT SEARCHED USING SEARCH BAR IS "+Product);

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void EnterForignLanguage_InSearchBar(String Product)
    {
        exists=false;
        try
        {
            if(SearchProd.isDisplayed()&&SearchProd.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, SearchProd);
                HelpersMethod.sendKeys(driver, SearchProd, 10000, Product);
                HelpersMethod.ClickBut(driver, IndexSearch, 10000);
                exists = true;
                scenario.log("PRODUCT SEARCHED USING SEARCH BAR IS " + Product);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void CheckForCatalog()
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(200))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-window k-dialog')]",10000);
                WebElement catlogPopup = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement modalContentTitle = catlogPopup.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Catalog", "Verify Title message");
            }
    }

    //For entering qty in catalog popup based on card/ list catalog display
    public void EnterQty(String unit, String cas) throws InterruptedException
    {
        Thread.sleep(4000);
        exists = false;
        WebElement WebEle;
        Actions act1=new Actions(driver);
        try
        {
            //Check for catalog popup
            if (HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                    //When "Card view" of catlog is enabled
                    if (HelpersMethod.IsExists("//div[@class='card-view']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        //Enter Unit value in input box of catalog
                        if (HelpersMethod.IsExists("//div[contains(text(),'Unit')]/descendant::input", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Unit')]/descendant::input");
                            HelpersMethod.ScrollElement(driver, WebEle);
                            act1.moveToElement(WebEle).click().build().perform();
                            act1.sendKeys(Keys.CONTROL + "a");
                            act1.sendKeys(Keys.DELETE);
                            act1.sendKeys(WebEle, unit).build().perform();
                            act1.sendKeys(Keys.TAB).build().perform();
                            scenario.log("UNIT ENTERED IN CATALOG " + unit);

                            //Check for popups
                            for (int a = 0; a <= 2; a++)
                            {
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                {
                                    // to fetch the web element of the modal container
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                    //click on Yes button
                                    WebElement yesButton = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                    HelpersMethod.ActClick(driver, yesButton, 10000);
                                }

                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                {
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                                    WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                    HelpersMethod.ActClick(driver, okButton, 20000);
                                }
                            }
                        }
                        //Enter Case value in input box of catalog
                        if (HelpersMethod.IsExists("//div[contains(text(),'Case')]/descendant::input", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Case')]/descendant::input");
                            HelpersMethod.ScrollElement(driver, WebEle);
                            act1.moveToElement(WebEle).click().build().perform();
                            act1.sendKeys(Keys.CONTROL + "a");
                            act1.sendKeys(Keys.DELETE);
                            act1.sendKeys(WebEle, unit).build().perform();
                            act1.sendKeys(Keys.TAB).build().perform();
                            scenario.log("CASES ENTERED IN CATALOG " + cas);
                            //Check for popups
                            for (int a = 0; a <= 2; a++)
                            {
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                {
                                    // to fetch the web element of the modal container
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                    //click on Yes button
                                    WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                    HelpersMethod.ActClick(driver, WebEle, 10000);
                                    scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                {
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                                    WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                    HelpersMethod.ActClick(driver, WebEle, 10000);
                                }
                            }
                        }
                    }
                        //Grid view display of catalog
                    else if (HelpersMethod.IsExists("//div[contains(@class,'catalog-search-grid-view')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                            int b = 0;
                            List<WebElement> tableHeads = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='i-grid']/descendant::th/descendant::span[@class='k-link']");
                            for (WebElement tableHead : tableHeads)
                            {
                                b++;
                                WebElement UnitCase = null;
                                String THead_Text = tableHead.getText();
                                if (THead_Text.equals("Units"))
                                {
                                   if(HelpersMethod.IsExists("//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + b + "]/descendant::input",driver))
                                    {
                                        UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + b + "]/descendant::input");
                                        HelpersMethod.ScrollElement(driver, UnitCase);
                                        if (UnitCase.isDisplayed() && UnitCase.isEnabled())
                                        {
                                            HelpersMethod.ActSendKey(driver, UnitCase, 10000, unit);
                                            scenario.log("UNITS ENTERED IN CATALOG " + unit);
                                            //Check for popups
                                            for (int a = 0; a <= 2; a++)
                                            {
                                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                                {
                                                    // to fetch the web element of the modal container
                                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                                    //click on Yes button
                                                    WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                                    HelpersMethod.ActClick(driver, WebEle, 10000);
                                                    scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                                                }

                                                //"Product is currently unavailable" popup
                                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                                {
                                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                                                    WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                                    HelpersMethod.ActClick(driver, WebEle, 10000);
                                                    scenario.log("PRODUCT IS CURRENTLY UNAVAILABLE POPUP HANDLED");
                                                }
                                            }
                                        }
                                    }
                                }
                                else
                                {
                                    if (THead_Text.equals("Cases"))
                                    {
                                        if(HelpersMethod.IsExists("//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + b + "]/descendant::input",driver))
                                        {
                                            //Find whether Cases input box is displayed
                                            UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + b + "]/descendant::input");
                                            HelpersMethod.ScrollElement(driver, UnitCase);
                                            if (UnitCase.isDisplayed() && UnitCase.isEnabled())
                                            {
                                                HelpersMethod.ActSendKey(driver, UnitCase, 10000, cas);
                                                scenario.log("CASES ENTERED IN CATALOG is " + cas);
                                                //Check for popups
                                                for (int a = 0; a <= 2; a++)
                                                {
                                                    //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                                    if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                                    {
                                                        // to fetch the web element of the modal container
                                                        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                                        //click on Yes button
                                                        WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                                        HelpersMethod.ActClick(driver, WebEle, 10000);
                                                        scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                                                    }

                                                    //"Product is currently unavailable" popup
                                                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                                    {
                                                        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                                        WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                                        HelpersMethod.ActClick(driver, WebEle, 10000);
                                                        scenario.log("PRODUCT IS CURRENTLY UNAVAILABLE POPUP HANDLED");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                    }
                    exists = true;
                    WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebEle = modelContainer.findElement(By.xpath(".//button/span[contains(text(),'Ok')]"));
                    HelpersMethod.ActClick(driver, WebEle, 30000);
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (InterruptedException e) {}
    }

    //For entering qty in catalog popup based on card/ list catalog display
    public void enterQtyOCL(String unit, String cas) throws InterruptedException
    {
        Thread.sleep(2000);
        exists = false;
        WebElement WebEle;
        Wait<WebDriver> wait;

        try
        {
            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    if(HelpersMethod.IsExists("//div[contains(@id,'gridItemBox')][1]/descendant::div[contains(text(),'Case')]/descendant::input[1]",driver))
                    {
                        WebElement caseInputbox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@id,'gridItemBox')][1]/descendant::div[contains(text(),'Case')]/descendant::input[1]");
                        HelpersMethod.ActSendKey(driver,caseInputbox,10000,cas);

                        //Check for popups
                        for (int a = 0; a <= 2; a++)
                        {
                            //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                                // to fetch the web element of the modal container
                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                //click on Yes button
                                WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                HelpersMethod.ActClick(driver, WebEle, 20000);
                                scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                            }

                            //"Product is currently unavailable" popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                                WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                HelpersMethod.ActClick(driver, WebEle, 20000);
                            }
                        }
                    }
                    if(HelpersMethod.IsExists("//div[contains(@id,'gridItemBox')][1]/descendant::div[contains(text(),'Unit')]/descendant::input[1]",driver))
                    {
                        WebElement unitInputbox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@id,'gridItemBox')][1]/descendant::div[contains(text(),'Unit')]/descendant::input[1]");
                        HelpersMethod.ActSendKey(driver,unitInputbox,10000,unit);
                        //Check for popups
                        for (int a = 0; a <= 2; a++)
                        {
                            //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                                // to fetch the web element of the modal container
                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                //click on Yes button
                                WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                HelpersMethod.ActClick(driver, WebEle, 20000);
                                scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                            }

                            //"Product is currently unavailable" popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                                WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                HelpersMethod.ActClick(driver, WebEle, 20000);
                            }
                        }
                    }
                    exists=true;
                }
                else
                {
                    if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
                    {
                        int b = 0;
                        List<WebElement> tableHeads = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='i-grid']/descendant::th/descendant::span[@class='k-link']");
                        for (WebElement tableHead : tableHeads)
                        {
                            b++;
                            WebElement UnitCase;
                            String THead_Text = tableHead.getText();
                            if (THead_Text.equals("Units"))
                            {
                                if(HelpersMethod.IsExists("//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + b + "]/descendant::input",driver))
                                {
                                    UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + b + "]/descendant::input");
                                    HelpersMethod.ScrollElement(driver, UnitCase);
                                    if (UnitCase.isDisplayed() && UnitCase.isEnabled())
                                    {
                                        HelpersMethod.ActSendKey(driver, UnitCase, 20000, unit);
                                        scenario.log("UNITS ENTERED IN CATALOG " + unit);
                                        //Check for popups
                                        for (int a = 0; a <= 2; a++)
                                        {
                                            //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                            {
                                                // to fetch the web element of the modal container
                                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                                //click on Yes button
                                                WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                                HelpersMethod.ActClick(driver, WebEle, 20000);
                                                scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                                            }

                                            //"Product is currently unavailable" popup
                                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                            {
                                                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                                                WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                                HelpersMethod.ActClick(driver, WebEle, 20000);
                                            }
                                        }
                                    }
                                }
                            }
                            else if (THead_Text.equals("Cases"))
                                {
                                    if(HelpersMethod.IsExists("//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + b + "]/descendant::input",driver))
                                    {
                                        //Find whether Cases input box is displayed
                                        UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[" + b + "]/descendant::input");
                                        HelpersMethod.ScrollElement(driver, UnitCase);
                                        if (UnitCase.isDisplayed() && UnitCase.isEnabled())
                                        {
                                            HelpersMethod.ActSendKey(driver, UnitCase, 20000, cas);
                                            scenario.log("CASES ENTERED IN CATALOG is " + cas);
                                            //Check for popups
                                            for (int a = 0; a <= 2; a++)
                                            {
                                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                                {
                                                    // to fetch the web element of the modal container
                                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                                    //click on Yes button
                                                    WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                                    HelpersMethod.ActClick(driver, WebEle, 20000);
                                                    scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                                                }

                                                //"Product is currently unavailable" popup
                                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                                {
                                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                                                    WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                                    HelpersMethod.ActClick(driver, WebEle, 20000);
                                                }
                                            }
                                        }
                                    }
                                //}
                            }
                        }
                       wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(200))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                        exists=true;
                    }
                }
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/span[text()='Ok']");
                HelpersMethod.ActClick(driver, WebEle, 10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (InterruptedException e) {}
    }

    public boolean ClickNext() throws InterruptedException
    {
        exists=false;
        Wait<WebDriver> wait;
        try
        {
            if(HelpersMethod.IsExists("//button[@id='submitOrderButton']",driver))
            {
                if (Next_But.isDisplayed() && Next_But.isEnabled())
                {
                    HelpersMethod.ScrollUpScrollBar(driver);
                    //Thread.sleep(2000);
                    Next_But = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='submitOrderButton']//*[local-name()='svg']");
                    HelpersMethod.ActClick(driver, Next_But, 20000);
                    scenario.log("NEXT BUTTON CLICKED");

                    String status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    exists = true;
                }
            }
            else if(HelpersMethod.IsExists("//div[contains(@class,'k-split-button')]",driver))
            {
                if (HelpersMethod.IsExists("//button[@id='ConfirmSummaryButton']", driver))
                {
                    WebElement submitButton = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='ConfirmSummaryButton']");
                    HelpersMethod.ScrollUpScrollBar(driver);
                    HelpersMethod.ClickBut(driver, submitButton, 10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(java.util.NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    exists = true;
                }
                else if (HelpersMethod.IsExists("//button[@id='ConfirmSummarySplitButton']", driver))
                {
                    //Click on Arrow button next to submit button
                    WebElement submitCutOff = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='ConfirmSummarySplitButton']/following-sibling::div/button/span");
                    HelpersMethod.ClickBut(driver, submitCutOff, 10000);
                    new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-child-animation-container']/descendant::ul/li")));
                    //Click on list that appears
                    WebElement arrowCutoff = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-child-animation-container']/descendant::ul/li");
                    HelpersMethod.ActClick(driver, arrowCutoff, 10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(java.util.NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    exists = true;
                }

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){ }
        return exists;
    }

    public void OutOfStockPop_ERP() throws InterruptedException
    {
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(6000);
            for (int i = 0; i <=22; i++)
            {
                //minimum order amount ************Minimum amount per order************ Admin setting
                if (HelpersMethod.IsExists("//div[contains(text(),'Minimum order amount has not been reached')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //click on Adjust button
                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Minimum order amount has not been reached')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='Adjust']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("MINIMUM ORDER AMOUNT HAS NOT BEEN REACHED HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    //code to increase the qty of products in the grid
                    Enter_Qty_InGrid("60","70");
                    ClickNext();
                }

                //Critical item popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //click on No button
                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='No']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("CRITICAL ITEMS NOT ORDERED POPUP HANDLED");

                   wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'which is less than the minimum order amount of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                    WebElement yesButton = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                    HelpersMethod.ActClick(driver, yesButton, 20000);
                    scenario.log("AMOUNT LESS THAN THE MINIMUM ORDER AMOUNT POPUP HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//div[contains(text(),' the quantity order has been increased')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),' the quantity order has been increased')]/ancestor::div[contains(@class,'k-window k-dialog')]"));
                    WebElement continueButton = modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                    HelpersMethod.ActClick(driver,continueButton, 20000);
                    scenario.log("BCZ OF ORDER FACTOR QTY HAS BEEN INCREASED, POPUP HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Frequently ordered items')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Frequently ordered items')]/ancestor::div[contains(@class,'k-window k-dialog')]"));
                    WebElement noButton = modalContainer.findElement(By.xpath(".//button/span[text()='No']"));
                    HelpersMethod.ActClick(driver,noButton, 20000);
                    scenario.log("FREQUENTLY ORDERED ITEMS POPUP HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Changes are not allowed for this order.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Changes are not allowed for this order.')]/ancestor::div[contains(@class,'k-window k-dialog')]"));
                    WebElement continueButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver,continueButton, 20000);
                    scenario.log("CUTOFF TIME POPUP, CHNGES ARE NOT ALLOWED FOR THIS ORDER, HAS BEEN HANDLED");

                   wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Attention: Although the cutoff time has been reached for this delivery date, you may still move forward with the order submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Attention: Although the cutoff time has been reached for this delivery date, you may still move forward with the order submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]"));
                    WebElement continueButton = modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                    HelpersMethod.ActClick(driver,continueButton, 20000);
                    scenario.log("CUTOFF TIME POPUP HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                //out of stock popup
                if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on Continue button
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("% OF YOUR AVERAGE ORDER POPUP HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                //Critical items popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on yes button
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='No']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("CRITICAL ITEMS DIALOG BOX FOUND");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                //Product cutoff time dialog box
                if (HelpersMethod.IsExists("//div[contains(text(),'has passed the cutoff time. No changes will be made to this product.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'has passed the cutoff time. No changes will be made to this product.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on Continue button
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("PRODUCT CUTOFF DIALOG BOX HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                //Order factor dialog box
                if (HelpersMethod.IsExists("//div[contains(text(),'requires an order factor of')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'requires an order factor of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on Continue button
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("ORDER FACTOR OF DIALOG BOX HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                //code to handle minimum order amount dialog box
                if(HelpersMethod.IsExists("//div[contains(text(),'The minimum order amount has not been reached')]/ancestor::div[@class='k-window k-dialog']",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::button");
                    HelpersMethod.ActClick(driver,okButton,10000);
                    scenario.log("MINIMUM ORDER AMOUNT HAS NOT BEEN REACHED, DIALOG BOX HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    String prodNo= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
                    QuickProduct(prodNo);
                    enterQtyForQuickProd();
                    ClickNext();
                }
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(500))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(500))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(500))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void orderFactorPopup(String orderFactorQty) throws InterruptedException
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(1000);
            if (HelpersMethod.IsExists("//div[contains(text(),'The quantity order has been increased to "+orderFactorQty+"')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                WebElement continueButton = modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                HelpersMethod.ActClick(driver, continueButton, 20000);
                scenario.log("BCZ OF ORDER FACTOR QTY HAS BEEN INCREASED, POPUP HAS BEEN HANDLED");
                scenario.log("************ORDER FACOTR DIALOG BOX HAS BEEN FOUND***********");
                exists=true;

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void popupAfterNext_OrderFactor() throws InterruptedException
    {
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            //Thread.sleep(2000);
            for (int i = 0; i <=7; i++)
            {
                //Critical item popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //click on No button
                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='No']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("CRITICAL ITEMS NOT ORDERED POPUP HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'which is less than the minimum order amount of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                    WebElement yesButton = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                    HelpersMethod.ActClick(driver, yesButton, 20000);
                    scenario.log("AMOUNT LESS THAN THE MINIMUM ORDER AMOUNT POPUP HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }

                if(HelpersMethod.IsExists("//div[contains(text(),'Frequently ordered items')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                    WebElement noButton = modalContainer.findElement(By.xpath(".//button/span[text()='No']"));
                    HelpersMethod.ActClick(driver,noButton, 20000);
                    scenario.log("FREQUENTLY ORDERED ITEMS POPUP HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Changes are not allowed for this order.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                    WebElement continueButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver,continueButton, 20000);
                    scenario.log("CUTOFF TIME POPUP, CHNGES ARE NOT ALLOWED FOR THIS ORDER, HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Attention: Although the cutoff time has been reached for this delivery date, you may still move forward with the order submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Attention: Although the cutoff time has been reached for this delivery date, you may still move forward with the order submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]"));
                    WebElement continueButton = modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                    HelpersMethod.ActClick(driver,continueButton, 20000);
                    scenario.log("CUTOFF TIME POPUP HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                //out of stock popup
                if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on Continue button
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("% OF YOUR AVERAGE ORDER POPUP HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                //Critical items popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Critical items not ordered')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on yes button
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='No']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("CRITICAL ITEMS DIALOG BOX FOUND");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                //Product cutoff time dialog box
                if (HelpersMethod.IsExists("//div[contains(text(),'has passed the cutoff time. No changes will be made to this product.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'has passed the cutoff time. No changes will be made to this product.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on Continue button
                    WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                    HelpersMethod.ActClick(driver,WebEle, 20000);
                    scenario.log("PRODUCT CUTOFF DIALOG BOX HAS BEEN HANDLED");

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void QuickProduct(String Prod) throws InterruptedException
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(QuickPro.isDisplayed() && QuickPro.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,QuickPro);
                HelpersMethod.clearText(driver,QuickPro,10000);
                HelpersMethod.EnterText(driver, QuickPro, 40000, Prod);
                QuickPro.sendKeys(Keys.TAB);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                if(HelpersMethod.IsExists("//span[@id='quickEntryUMs']",driver))
                {
                    uomDropDown.sendKeys(Keys.TAB);
                }
                scenario.log("PRODUCT ADDED TO THE ORDER Via QUICK PRODUCT ENTRY " + Prod);

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void priceOverrideQuickProduct(String Prod) throws InterruptedException
    {
        exists=false;
        try
        {
            if(QuickPro.isDisplayed() && QuickPro.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,QuickPro);
                HelpersMethod.EnterText(driver, QuickPro, 10000, Prod);
                QuickPro.sendKeys(Keys.TAB);
                uomDropDown.sendKeys(Keys.TAB);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                scenario.log("PRODUCT ADDED TO THE ORDER Via QUICK PRODUCT ENTRY " + Prod);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String VerifyUOM()
    {
        exists=false;
        WebElement WebEle=null;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'quickUMs')]/label[contains(@class,'quick-um-single-value')]|//span[@id='quickEntryUMs']/span[@class='k-input']|//span[@id='quickEntryUMs']/descendant::span[@class='k-input-value-text']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'quickUMs')]/label[contains(@class,'quick-um-single-value')]|//span[@id='quickEntryUMs']/span[@class='k-input']|//span[@id='quickEntryUMs']/descendant::span[@class='k-input-value-text']");
                scenario.log("UOM IS ENABLED AND IT CONTAINS "+WebEle.getText()+" VALUE IN IT");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return WebEle.getText();
    }

    public void OECancel()
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver,Cancel_But);
            HelpersMethod.JScriptClick(driver,Cancel_But,10000);
            scenario.log("ORDER CANCEL, BUTTON CLICKED");
            exists=true;
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void VerifyCancelPopUp()
    {
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//span[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Cancel order", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void CancelAndSkipPopupEnabled()
    {
        exists=false;
        try
        {
            WebElement cancelSkipPopup=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-window k-dialog')]");
            WebElement CAndSButton=cancelSkipPopup.findElement(By.xpath(".//button/span[contains(text(),'Cancel & skip')]"));
            if(CAndSButton.isEnabled())
            {
                scenario.log("CANCEL AND SKIP BUTTON IS ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CancelAndSkipPopupDisabled()
    {
        exists=false;
        try
        {
            WebElement cancelSkipPopup=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-window k-dialog')]");
            //WebElement CAndSButton=cancelSkipPopup.findElement(By.xpath(".//button/span[contains(text(),'Cancel & skip')]"));
            if(HelpersMethod.IsExists("//span[text()='Cancel & skip']/ancestor::button[contains(@class,'disabled')]",driver))
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
        WebElement WebEle;
        try
        {
            //Check for the Cancel Order warning popup
            if (HelpersMethod.IsExists("//span[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement cancelPopup = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

                WebEle=cancelPopup.findElement(By.xpath(".//button/span[text()='Yes']"));
                HelpersMethod.ClickBut(driver,WebEle,10000);
                scenario.log("CANCEL ORDER POPUP HAS BEEN HANDLED");
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void CancelAndSkipPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            //Check for the Cancel Order warning popup
            if (HelpersMethod.IsExists("//span[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement cancelPopup = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

                WebEle=cancelPopup.findElement(By.xpath(".//button/span[text()='Cancel & skip']"));
                HelpersMethod.ActClick(driver,WebEle,10000);
                scenario.log("CANCEL AND SKIP ORDER POPUP HAS BEEN CLICKED");
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void CheckForQuickCaseEnabled(String Case)  throws InterruptedException
    {
        WebElement WebEle;
        String status;
        try
        {
            //WebElement uom=HelpersMethod.FindByElement(driver,"xpath","//span[@id='quickEntryUMs']/span[@class='k-input']|//div[contains(@class,'quickUnits')]/descendant::input[@id='quickUnits']");
            WebElement uom=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'quickUMs')]/label[contains(@class,'quick-um-single-value')]|//span[@id='quickEntryUMs']/span[@class='k-input']|//div[contains(@class,'quickUnits')]/descendant::input[@id='quickUnits']|//div[contains(@class,'quickUMs')]/label[contains(@class,'quick-um-single-value')]|//span[@id='quickEntryUMs']/span[@class='k-input']|//span[@id='quickEntryUMs']/descendant::span[@class='k-input-value-text']");
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOf(uom));
            String uomText=uom.getText();
            if(uomText.contains("Cases")||uomText.contains("CS"))
            {
                HelpersMethod.ScrollElement(driver, QuickPro);
                if (QuickCase.isDisplayed() && QuickCase.isEnabled())
                {
                    HelpersMethod.ClearText(driver, QuickCase, 10000);
                    HelpersMethod.EnterText(driver, QuickCase, 10000, Case);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    QuickCase.sendKeys(Keys.TAB);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading")) {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    scenario.log("CASE ENTERED FOR QUICK PRODUCT IS " + Case);
                    //Check for popups
                    for (int a = 0; a <= 2; a++)
                    {
                        //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            // to fetch the web element of the modal container
                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            //click on Yes button
                            WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                            HelpersMethod.ActClick(driver, WebEle, 10000);
                            status = HelpersMethod.returnDocumentStatus(driver);
                            if (status.equals("loading"))
                            {
                                HelpersMethod.waitTillLoadingPage(driver);
                            }
                            scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                        }

                        //"Product is currently unavailable" popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                            WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                            HelpersMethod.ActClick(driver, WebEle, 10000);
                        }
                        //Check for 'Product low in invetory' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low')]/ancestor::div[@id='toast-container']",driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ActClick(driver, WebEle, 10000);
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'% of your average order')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            WebElement continueButton = modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                            HelpersMethod.ActClick(driver, continueButton, 10000);
                        }
                    }
                }
            }
        }
        catch (Exception e) {}
    }

    public void CheckForQuickUnitEnabled(String Unit)  throws InterruptedException
    {
        WebElement WebEle;
        String status;
        try
        {
            WebElement uom=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'quickUMs')]/label[contains(@class,'quick-um-single-value')]|//span[@id='quickEntryUMs']/span[@class='k-input']|//div[contains(@class,'quickUMs')]/label[contains(@class,'quick-um-single-value')]|//span[@id='quickEntryUMs']/span[@class='k-input']|//span[@id='quickEntryUMs']/descendant::span[@class='k-input-value-text']");
            String uomText=uom.getText();
            if(uomText.contains("Units")||uomText.contains("EA"))
            {
               HelpersMethod.ScrollElement(driver, QuickPro);
               if (QuickUnit.isDisplayed() && QuickUnit.isEnabled())
               {
                  exists = false;
                 HelpersMethod.ClearText(driver, QuickUnit, 10000);
                 HelpersMethod.EnterText(driver, QuickUnit, 10000, Unit);
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                 }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("UNIT ENTERED FOR QUICK PRODUCT IS " + Unit);

                for (int i = 0; i <= 3; i++)
                {
                //Check for Qty exceeds maximum of popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    // to fetch the web element of the modal container
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on Yes button
                    WebElement yesButton  = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                    HelpersMethod.ActClick(driver, yesButton, 10000);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    scenario.log("QUANTITY EXCEEDS MAXIMUM OF POPUP HANDLED");
                }
                    //"Product is currently unavailable" popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                        WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                        HelpersMethod.ActClick(driver, okButton, 10000);
                    }

                    //Check for 'Product low in invetory' popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low')]/ancestor::div[@id='toast-container']",driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                    }

                    if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'% of your average order')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        WebElement continueButton = modalContainer.findElement(By.xpath(".//button/span[text()='Continue']"));
                        HelpersMethod.ActClick(driver, continueButton, 10000);
                    }
                }
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
        Thread.sleep(6000);
        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            for(int i=0;i<=2;i++)
            {
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    // to fetch the web element of the modal container
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on Yes button
                    WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    scenario.log("QUANTITY EXCEEDS MAXIMUM POPUP HANDLED");
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                }

                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement unavailablePopup  = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement okPopup=unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ClickBut(driver, okPopup, 10000);
                    scenario.log("UNAVAILABLE POPUP HANDLED");
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
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
            if(SkipButton.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, SkipButton, 10000);
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void New_OE_Validate_Skip_Button()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//span[text()='Skip']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("SKIP BUTTON HAS BEEN FOUND IN NEW OE PAGE");
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>CHECK DELIVERY DATE HAS BEEN CHANGED OR NOT, SKIP BUTTON NOT FOUND</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void New_OE_Select_SkipReason(String reason) throws InterruptedException
    {
        try
        {
            WebElement Skip_Pop = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Skip']/ancestor::div[contains(@class,'k-window k-dialog')]");
            exists = HelpersMethod.EleDisplay(Skip_Pop);
            if (exists == true)
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='SkipReason']/descendant::button");
                HelpersMethod.JScriptClick(driver, WebEle, 10000);
                HelpersMethod.DropDownMenu_LowerCase(driver,reason);
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/span[text()='Ok']");
                HelpersMethod.ClickBut(driver, WebEle, 10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
        try
        {
            WebElement grid=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver, grid);
            if(UnitInput.isDisplayed() && UnitInput.isEnabled())
            {
                HelpersMethod.ActSendKey(driver, UnitInput, 10000, unit);
                scenario.log("UNIT ENTERED IN GRID IS " + unit);
                for (int j = 0; j <= 3; j++)
                {
                    //Handling product unavailable, popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement dialogCurrentUnavailable = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        WebElement okButton=dialogCurrentUnavailable.findElement(By.xpath(".//button/span[text()='Ok']"));
                        HelpersMethod.ClickBut(driver, okButton, 10000);
                    }

                   //Check for 'Qty exceeds maximum of' Popup
                   if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                   {
                    WebElement dialogExceed = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement yesButton=dialogExceed.findElement(By.xpath(".//button/span[text()='Yes']"));
                    HelpersMethod.ClickBut(driver, yesButton, 10000);
                   }
                }
            }
            if(CaseInput.isDisplayed() && CaseInput.isEnabled())
            {
                HelpersMethod.ActSendKey(driver, CaseInput, 10000, cas);
                scenario.log("CASE ENTERED IN GRID IS "+cas);
                for (int j = 0; j <= 3; j++)
                {
                    //Handling product unavailable, popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement dialogCurrentUnavailable = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        WebElement okButton=dialogCurrentUnavailable.findElement(By.xpath(".//button/span[text()='Ok']"));
                        HelpersMethod.ClickBut(driver, okButton, 10000);
                    }

                    //Check for 'Qty exceeds maximum of' Popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement dialogExceed = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        WebElement yesButton=dialogExceed.findElement(By.xpath(".//button/span[text()='Yes']"));
                        HelpersMethod.ClickBut(driver, yesButton, 10000);
                    }
                }
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_On_Copy_From_DropDown(String OrdHist)
    {
        exists=false;
        String dropText;
        Actions act=new Actions(driver);
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            HelpersMethod.ScrollElement(driver, CopyFrom);
            HelpersMethod.ClickBut(driver,CopyFrom,10000);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='copy-selection-accessibility-id']/li")));

            List<WebElement>copyFromDropDowns=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='copy-selection-accessibility-id']/li");
            for(WebElement copyDrop:copyFromDropDowns)
            {
                act.moveToElement(copyDrop).build().perform();
                dropText=copyDrop.getText();
                if(dropText.equalsIgnoreCase("Order history"))
                {
                    act.moveToElement(copyDrop).build().perform();
                    act.click(copyDrop).build().perform();
                    exists=true;
                    break;
                }
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
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
            if(AddProduct.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, AddProduct);
                HelpersMethod.ActClick(driver, AddProduct, 20000);
                scenario.log("ADD PRODUCT BUTTON HAS BEEN CLICKED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void SelectOGFromDropdown()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String menuText;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='addButton-accessibility-id']/li/descendant::span[@class='k-menu-link-text']"))));
            List<WebElement> dropdownMenus=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='addButton-accessibility-id']/li/descendant::span[@class='k-menu-link-text']");
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

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateOGPopup()
    {
        //HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//span[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-window k-dialog')]",400);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//span[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Order guides", "Verify Title message");

    }

    public void OrderGuideGrid(String OGName)
    {
        WebElement OG;
        WebElement WebEle;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                //Enter OG name in search box, of OG popup
                OG=HelpersMethod.FindByElement(driver,"id","orderGuideSearch");
                HelpersMethod.EnterText(driver,OG,10000,OGName);

                //Click on search index icon
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
                HelpersMethod.ClickBut(driver,WebEle,10000);

                //Click on OG
                OG=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::td[text()='"+OGName+"']/parent::tr");
                HelpersMethod.ActClick(driver,OG,10000);

                //Click on OK button in OG popup
                OG=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                HelpersMethod.ActClick(driver,OG,10000);

                exists=true;
                scenario.log("ORDER GUIDE SELECTED IS "+OGName);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectCatalogFromDropdown()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String menuText;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='addButton-accessibility-id']/li/descendant::span[@class='k-menu-link-text']"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='addButton-accessibility-id']/li/descendant::span[@class='k-menu-link-text']"))));
            List<WebElement> dropdownMenus=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='addButton-accessibility-id']/li/descendant::span[@class='k-menu-link-text']");
            for(WebElement dropDown:dropdownMenus)
            {
                act1.moveToElement(dropDown).build().perform();
                menuText=dropDown.getText();
                if(menuText.equals("From Catalog"))
                {
                    act1.moveToElement(dropDown).build().perform();
                    act1.click(dropDown).build().perform();
                    exists=true;
                    scenario.log("ADD PRODUCT FROM CATALOG");
                    break;
                }
            }

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }



    //For entering Qty in Product grid
    public void EnterQty_ProductGrid(WebDriver driver,List<List<String>> QtyDetails)
    {
        try
        {
            WebElement WebEle;
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
                        HelpersMethod.EnterText(driver, WebEle, 10000, QtyDetails.get(i).get(0));
                        WebEle.sendKeys(Keys.TAB);
                        scenario.log("QTY ENTERED IN CASES INPUTBOX "+QtyDetails.get(i).get(0));
                        Thread.sleep(500);
                        for (int j = 0; j <= 3; j++)
                        {
                             //Check for 'Qty exceeds maximum of' Popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                               WebElement qtyExceeds=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                               WebElement yesButton=qtyExceeds.findElement(By.xpath(".//button/span[text()='Yes']"));
                               HelpersMethod.ActClick(driver,yesButton,10000);
                            }

                            //Handling Product unavailable
                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low on inventory')]/ancestor::div[contains(@id,'toast-container')]", driver))
                           {
                                WebElement closeButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@id,'toast-container')]/descendant::button");
                                HelpersMethod.ClickBut(driver, closeButton, 10000);
                           }

                           //Handling product unavailable, popup
                           if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                           {
                             WebElement unavailable=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                             WebElement okButton=unavailable.findElement(By.xpath(".//button/span[text()='Ok']"));
                             HelpersMethod.ActClick(driver,okButton,10000);
                           }
                        }
                    }

                    //Check Whether Units is enabled or not
                    if (HelpersMethod.IsExists("//tr["+(i+1)+"]/descendant::input[contains(@id,'TotalUnitsCol')]", driver))
                    {
                        WebEle = driver.findElement(By.xpath("//tr["+(i+1)+"]/descendant::input[contains(@id,'TotalUnitsCol')]"));
                        HelpersMethod.EnterText(driver, WebEle, 10000,QtyDetails.get(i).get(1));
                        WebEle.sendKeys(Keys.TAB);
                        scenario.log("QTY ENTERED IN UNIT INPUTBOX "+QtyDetails.get(i).get(1));
                        Thread.sleep(500);
                        for (int j = 0; j <= 3; j++)
                        {
                            //Check for 'Qty exceeds maximum of' Popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                                WebElement qtyExceeds=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                WebElement yesButton=qtyExceeds.findElement(By.xpath(".//button/span[text()='Yes']"));
                                HelpersMethod.ActClick(driver,yesButton,10000);
                            }

                            //Handling Product unavailable
                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low on inventory')]/ancestor::div[contains(@id,'toast-container')]", driver))
                            {
                                WebElement closeButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@id,'toast-container')]/descendant::button");
                                HelpersMethod.ClickBut(driver, closeButton, 10000);
                            }

                            //Handling product unavailable, popup
                            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                                WebElement unavailable=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                WebElement okButton=unavailable.findElement(By.xpath(".//button/span[text()='Ok']"));
                                HelpersMethod.ActClick(driver,okButton,10000);
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e){}
    }

    public void Comment_Icon()
    {
        exists=false;
        try
        {
            Thread.sleep(2000);
            if(Ord_Comments.isDisplayed() && Ord_Comments.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, Ord_Comments);
                HelpersMethod.ClickBut(driver, Ord_Comments, 10000);
                exists=true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Thread.sleep(4000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCommentPopup()
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
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(2000);

            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='textAreaA']/ancestor::div[contains(@class,'k-window k-dialog')]")));
            if(HelpersMethod.IsExists("//textarea[@id='textAreaA']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("COMMENT POPUP HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //handling 'Comment' popup for order and for product
    public void Comment_Popup(String Comment)
    {
        exists=false;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            WebElement prodCommentPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
            //Sending comment to comment input box in product comment popup
            WebElement prodCommText=HelpersMethod.FindByElement(driver,"id","textAreaA");
            HelpersMethod.ActSendKey(driver,prodCommText,10000,Comment);
            //Select Comment flag
            WebElement commentFlag=HelpersMethod.FindByElement(driver,"id","printFlagDropDown");
            HelpersMethod.ActClick(driver,commentFlag,10000);
            //select value from comment flag drop down
            List<WebElement> flags=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='printFlagDropDown-listbox-id']/li/span");
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
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Click on Add button in the popup
            WebElement addButton=prodCommentPopup.findElement(By.xpath(".//button/span[text()='Add']//*[local-name()='svg']"));
            HelpersMethod.ActClick(driver,addButton,10000);

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Comments')]/ancestor::div[contains(@class,'k-window k-dialog')]"))));
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Comments')]/ancestor::div[contains(@class,'k-window k-dialog')]"))));

            scenario.log("COMMENT ADDED IS "+Comment);

            //read content of note added and comapre it with note entered
            String addedComment=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::table[@class='k-table k-grid-table k-table-md']/descendant::tr[1]/td[2]").getText();
            scenario.log("COMMENT ADDED TO GRID "+addedComment);
            if(Comment.equalsIgnoreCase(addedComment))
            {
                scenario.log("COMMENT ENTERED AND COMMENT ADDED ARE SAME");
                exists=true;
            }
            else
            {
                scenario.log("COMMENT ENTERED AND COMMENT ADDED ARE DIFFERENT");
                exists=false;
            }
            ok_ButtonOrderComment();
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ok_ButtonOrderComment()
    {
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Comments')]/ancestor::div[contains(@class,'k-window k-dialog')]"))));
            WebElement prodCommentPopup=HelpersMethod.FindByElement(driver,"xpath","//textArea[@id='textAreaA']/ancestor::div[contains(@class,'k-window k-dialog')]");
            //Click on OK button
            WebElement okButton=prodCommentPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
            HelpersMethod.ActClick(driver,okButton,10000);
        }
        catch (Exception e){}
    }

    public void Prod_Comment_Icon()
    {
        try
        {
            WebElement WebEle;
            if(HelpersMethod.IsExists("//tr[1]/descendant::div[contains(@id,'OrderLineCommentIconColIcon')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ClickBut(driver,Prod_Comments,10000);
                scenario.log("PRODUCT COMMENT ICON FOUND ");
            }
            else
            {
                scenario.log("PRODUCT COMMENT ICON DOESN'T EXISTS");
            }
        }
        catch(Exception e){}
    }

    public void validateProductComment()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='embeddedErrorNofitication1']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("COMMENT AT PRODUCT LEVEL HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Comment_PopupProd(String Comment)
    {
        exists=false;
        int i=0;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[@id='embeddedErrorNofitication1']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement prodCommentPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                //Sending comment to comment input box in product comment popup
                WebElement prodCommText=prodCommentPopup.findElement(By.xpath(".//textarea[@id='textAreaA']"));
                HelpersMethod.ActSendKey(driver,prodCommText,10000,Comment);
                //Select Comment flag
                WebElement commentFlag=HelpersMethod.FindByElement(driver,"id","printFlagDropDown");
                HelpersMethod.ActClick(driver,commentFlag,10000);
                //select value from comment flag drop down
                List<WebElement> flags=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='printFlagDropDown-listbox-id']/descendant::span");
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
                WebElement addButton=prodCommentPopup.findElement(By.xpath(".//button/span[text()='Add']"));
                HelpersMethod.ClickBut(driver,addButton,10000);
                //Click on OK button
                WebElement okButton=prodCommentPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,10000);
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

            if(HelpersMethod.IsExists("//div[@id='embeddedErrorNofitication1']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement prodCommentPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                //Sending comment to comment input box in product comment popup
                WebElement prodCommText=prodCommentPopup.findElement(By.xpath(".//textarea[@id='textAreaA']"));
                HelpersMethod.ActSendKey(driver,prodCommText,10000,Comment);
                //Select Comment flag
                WebElement commentFlag=HelpersMethod.FindByElement(driver,"id","printFlagDropDown");
                HelpersMethod.ActClick(driver,commentFlag,10000);
                //select value from comment flag drop down
                List<WebElement> flags=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='printFlagDropDown-listbox-id']/descendant::span");
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
                WebElement addButton=prodCommentPopup.findElement(By.xpath(".//button/span[text()='Add']"));
                HelpersMethod.ClickBut(driver,addButton,10000);
                //Click on OK button
               // WebElement okButton=prodCommentPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
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
        try
        {
            Click_On_Add_Product();
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='addButton-accessibility-id']/li/descendant::span[@class='k-menu-link-text']"))));
            WebElement menuContainer = driver.findElement(By.xpath("//ul[@id='addButton-accessibility-id']/li"));
            WebElement optionToClick = menuContainer.findElement(By.xpath(".//span[@class='k-menu-link-text' and contains(text(),'From Catalog')]"));
            // click the option
            HelpersMethod.ActClick(driver, optionToClick, 10000);

            scenario.log("ADD PRODUCT FROM CATALOG IS SELECTED");
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e) {}
    }

    public void Validate_Catalog()
    {
        exists=false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'product-catalog-container')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
                scenario.log("CATALOG DIALOG BOX HAS BEEN FOUND");
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@class='card-view']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                if (HelpersMethod.IsExists("//button/span[contains(text(),'Reset filter')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/span[contains(text(),'Reset filter')]");
                    HelpersMethod.ActClick(driver, WebEle, 10000);
                    exists = true;
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            else if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
            {
                    List<WebElement> filters=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]");
                    if(filters.size()>1)
                    {
                        //Click on 'Add filter'
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        Thread.sleep(1000);
                        //Click on 'Clear all'
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-filter-popup__footer')]/button/span[contains(text(),'Clear all')]");
                        if (WebEle.isEnabled())
                        {
                            HelpersMethod.ScrollElement(driver, WebEle);
                            HelpersMethod.ActClick(driver, WebEle, 10000);
                            exists = true;
                            wait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofSeconds(200))
                                    .pollingEvery(Duration.ofSeconds(2))
                                    .ignoring(NoSuchElementException.class);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                        }
                        //if filter header is not displayed click on filter icon
                        if (!HelpersMethod.IsExists("//span[contains(@class,'k-i-filter-clear k-icon')]", driver))
                        {
                            WebElement filterIcon = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'k-i-filter-clear k-icon')]");
                            HelpersMethod.JScriptClick(driver, filterIcon, 10000);
                        }
                    }
            }
        }
        catch (Exception e){}
    }

    public void Search_Prod_in_Catalog(String Prods) throws InterruptedException
    {
        Thread.sleep(2000);
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    //Click on clear button in search bar
                    WebEle = catalogPopup.findElement(By.xpath("//span[contains(@class,'right-button')]"));
                    HelpersMethod.ScrollElement(driver,WebEle);
                    HelpersMethod.clickOn(driver, WebEle, 10000);

                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //Enter product number in search bar
                    WebEle = catalogPopup.findElement(By.xpath("//input[contains(@class,' product-search-input ')]"));
                    HelpersMethod.sendKeys(driver, WebEle, 10000,Prods);
                    scenario.log("PRODUCT NUMBER ENTERED IN SEARCH BAR "+Prods);

                    //Enter search index
                    WebEle=catalogPopup.findElement(By.xpath("//div[@class='searchBarDropdown']/descendant::span[contains(@class,' search-button ')]"));
                    HelpersMethod.clickOn(driver, WebEle, 10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    exists=true;
                }
                else if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
                {
                        //Click on 'Add filter'
                        WebEle = catalogPopup.findElement(By.xpath("//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
                        HelpersMethod.ActClick(driver, WebEle, 10000);

                        scenario.log("PORDUCT NUMBER ENERED IN INPUT BOX " + Prods);
                        //Enter value in first search box
                        if (HelpersMethod.IsExists("//div[contains(@class,'i-filter-popup i-filter-popup--add')]", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-filter-popup i-filter-popup--add')]/descendant::input[contains(@class,'i-search-box__input')]");
                            HelpersMethod.sendKeys(driver, WebEle, 10000, "Product #");
                            //Click on Check box
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-filter-popup i-filter-popup--add')]/descendant::input[contains(@class,'k-checkbox')]");
                            HelpersMethod.ActClick(driver, WebEle, 10000);

                            //Click on Apply button
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//form[contains(@class,'i-filter-popup i-filter-popup--text')]/descendant::button/span[text()='Apply']");
                            HelpersMethod.ActClick(driver, WebEle, 10000);

                            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofSeconds(120))
                                    .pollingEvery(Duration.ofSeconds(2))
                                    .ignoring(NoSuchElementException.class);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                        }

                        //Click on Product# button
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'i-filter-tag__main')]/span[text()='Product #: ']");
                        HelpersMethod.ActClick(driver, WebEle, 10000);

                        //Enter product # in inputbox
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input");
                        HelpersMethod.ActSendKey(driver, WebEle, 10000, Prods);
                        scenario.log("PORDUCT NUMBER ENERED IN INPUT BOX " + Prods);

                        //Click on Apply button
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//form[contains(@class,'i-filter-popup i-filter-popup--text')]/descendant::button/span[text()='Apply']");
                        HelpersMethod.ActClick(driver, WebEle, 10000);

                        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(120))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                        exists = true;

                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Search_Prod_in_CatalogIndexDialogbox(String Prods)
    {
        exists=false;
        WebElement WebEle;
        String tHeadText;
        int i=0;
        try
        {
            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    //Click on clear button in search bar
                    WebEle = catalogPopup.findElement(By.xpath("//span[contains(@class,'right-button')]"));
                    HelpersMethod.ScrollElement(driver,WebEle);
                    HelpersMethod.clickOn(driver, WebEle, 10000);

                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //Enter product number in search bar
                    WebEle = catalogPopup.findElement(By.xpath("//input[contains(@class,' product-search-input ')]"));
                    HelpersMethod.sendKeys(driver, WebEle, 10000,Prods);
                    scenario.log("PRODUCT NUMBER ENTERED IN SEARCH BAR "+Prods);

                    //Enter search index
                    WebEle=catalogPopup.findElement(By.xpath("//div[@class='searchBarDropdown']/descendant::span[contains(@class,' search-button ')]"));
                    HelpersMethod.clickOn(driver, WebEle, 10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    exists=true;
                }
                else
                {
                    if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
                    {
                        scenario.log("PORDUCT NUMBER ENERED IN INPUT BOX "+Prods);
                        List<WebElement> tableHeader= HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@style,'touch-action')]/descendant::span[contains(@class,'k-column-title')]");
                        for (WebElement tHead:tableHeader)
                        {
                            i++;
                            tHeadText=tHead.getText();
                            if(tHeadText.equalsIgnoreCase("Product #"))
                            {
                                break;
                            }
                        }
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-filter-row']/th["+i+"]/descendant::input");

                        for (int j = 0; j < Prods.length(); j++)
                        {
                            String s = new StringBuilder().append(Prods.charAt(j)).toString();
                            //WebEle.sendKeys(s);
                            HelpersMethod.EnterText(driver,WebEle,10000,s);
                            exists=true;
                        }

                        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(120))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterQty_MutlipleProd(String unit,String cas) throws InterruptedException
    {
        exists = false;
        try
        {
            WebElement WebEle;
            WebElement UnitCase;
            Actions act1 = new Actions(driver);
            //Check for catalog popup
            if (driver.findElement(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]")).isDisplayed())
            {
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]"))));
                WebElement catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");

                    //When "Card view" of catlog is enabled
                    if (HelpersMethod.IsExists("//div[@class='card-view']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        //Enter Unit value in input box of catalog
                        if (HelpersMethod.IsExists("//input[contains(@id,'catalog-quantity-input')]", driver))
                        {
                            WebEle = catalogPopup.findElement(By.xpath(".//input[contains(@id,'catalog-quantity-input')]"));
                            HelpersMethod.ScrollElement(driver, WebEle);
                            HelpersMethod.ClearText(driver, WebEle, 10000);
                            act1.moveToElement(WebEle).click().build().perform();
                            act1.sendKeys(WebEle, unit).build().perform();
                            act1.sendKeys(Keys.TAB).build().perform();
                            scenario.log("UNIT ENTERED IN CATALOG " + unit);

                            //Check for popups
                            for (int a = 0; a <= 2; a++)
                            {
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                                    // to fetch the web element of the modal container
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                    //click on Yes button
                                    WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                    HelpersMethod.ActClick(driver, WebEle, 1000);
                                }
                                //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                    WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ActClick(driver, Popup, 10000);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                                    WebElement okButton  = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                    HelpersMethod.ActClick(driver, okButton, 10000);
                                }
                            }
                        }
                        //Enter Case value in input box of catalog
                        if (HelpersMethod.IsExists("//input[contains(@id,'catalog-cases')]", driver)) {
                            WebEle = catalogPopup.findElement(By.xpath(".//input[contains(@id,'catalog-cases')]"));
                            HelpersMethod.ScrollElement(driver, WebEle);
                            HelpersMethod.ClearText(driver, WebEle, 10000);
                            act1.moveToElement(WebEle).click().build().perform();
                            act1.sendKeys(WebEle, unit).build().perform();
                            act1.sendKeys(Keys.TAB).build().perform();
                            scenario.log("CASES ENTERED IN CATALOG " + cas);
                            //Check for popups
                            for (int a = 0; a <= 2; a++)
                            {
                                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                                    // to fetch the web element of the modal container
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                    //click on Yes button
                                    WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                    HelpersMethod.ActClick(driver, WebEle, 10000);
                                }
                                //Check for "Out of Stock" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                    WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                    HelpersMethod.ActClick(driver, Popup, 10000);
                                }
                                //"Product is currently unavailable" popup
                                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                                    WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                    HelpersMethod.ActClick(driver, okButton, 10000);
                                }
                            }
                        }
                    }
                   //Grid view display of catalog
                   else if (driver.findElement(By.xpath("//div[contains(@class,'catalog-search-grid-view')]/ancestor::div[contains(@class,'k-window k-dialog')]")).isDisplayed()) {
                        int b = 0;
                        List<WebElement> tableHeads = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='i-grid']/descendant::th[@class='k-header ']/span[@class='k-link']");
                        for (WebElement tableHead : tableHeads)
                        {
                            b++;
                            String THead_Text = tableHead.getText();
                            if (THead_Text.equals("Units"))
                            {
                                if (HelpersMethod.IsExists("//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')]//descendant::td[" + b  + "]/descendant::input",driver))
                                {
                                    UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')]//descendant::td[" + b + "]/descendant::input");
                                    HelpersMethod.ScrollElement(driver, UnitCase);
                                    HelpersMethod.ActSendKey(driver, UnitCase, 1000, unit);
                                    scenario.log("UNITS ENTERED IN CATALOG " + unit);
                                    //Check for popups
                                    for (int a = 0; a <= 2; a++)
                                    {
                                        //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                        {
                                            // to fetch the web element of the modal container
                                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                            //click on Yes button
                                            WebElement yesButton = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                            HelpersMethod.ActClick(driver, yesButton, 1000);
                                        }
                                        //Check for "Out of Stock" popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                        {
                                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                            WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                            HelpersMethod.ActClick(driver, Popup, 1000);
                                        }
                                        //"Product is currently unavailable" popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                        {
                                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                                            WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                            HelpersMethod.ActClick(driver, okButton, 1000);
                                        }
                                    }
                                }
                            }
                        }
                        for (WebElement tableHead : tableHeads)
                        {
                            String THead_Text = tableHead.getText();
                            if (THead_Text.equals("Cases"))
                            {
                                //Find whether Cases input box is displayed
                                if (HelpersMethod.IsExists("//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')]//descendant::td[" + b  + "]/descendant::input",driver))
                                {
                                    UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='product-catalog-container catalog-search-grid-view']/descendant::tr[contains(@class,'k-master-row')]//descendant::td[" + b + "]/descendant::input");
                                    HelpersMethod.ScrollElement(driver, UnitCase);
                                    HelpersMethod.ActSendKey(driver, UnitCase, 1000, cas);
                                    scenario.log("CASES ENTERED IN CATALOG is " + cas);
                                    //Check for popups
                                    for (int a = 0; a <= 2; a++)
                                    {
                                        //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                        {
                                            // to fetch the web element of the modal container
                                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                            //click on Yes button
                                            WebElement yesButton = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                                            HelpersMethod.ActClick(driver, yesButton, 1000);
                                        }
                                        //Check for "Out of Stock" popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                        {
                                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Out of stock')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                            WebElement Popup = modalContainer.findElement(By.xpath(".//button"));
                                            HelpersMethod.ActClick(driver, Popup, 1000);
                                        }
                                        //"Product is currently unavailable" popup
                                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                                        {
                                            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                                            WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                                            HelpersMethod.ActClick(driver, okButton, 1000);
                                        }
                                    }
                                }
                            }
                        }
                   }
            }
        }
        catch (Exception e) {}
    }

    public void Catalog_OK()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
            HelpersMethod.ActClick(driver,WebEle, 10000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String Export_button(String ordNo)
    {
        WebElement WebEle;

        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(Export_but.isDisplayed() && Export_but.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,Export_but);
                HelpersMethod.ActClick(driver,Export_but,10000);
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
              /*  File dir = new File("C:\\Users\\Divya.Ramadas\\Downloads");
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
                scenario.log(file2+" FILE HAS BEEN DOWNLOADED");*/
            }
        }
        catch (Exception e) { }
        return Actual_Order;
    }

    public void Import_button(String ord_No)
    {
        exists=false;
        WebElement WebEle;
        int intOrdNo= Integer.parseInt(ord_No);
        String Ord_no="";
        try
        {
            if(TestBase.testEnvironment.get_url().contains("dsd"))
            {
                //send file name to input box
                ord_No=String.format("%010d",intOrdNo);
                Ord_no = "Order_" + ord_No + ".csv";
            }
            else
            {
                Ord_no = "Order_" + ord_No + ".csv";
            }
            scenario.log("ORDER IMPORTED IS "+Ord_no);
            if(Import_but.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,Import_but);
                driver.findElement(By.xpath("//input[@id='ImportOrder' and @type='file']")).sendKeys("C:\\Users\\Divya.Ramadas\\Downloads\\"+Ord_no);
                exists=true;
            }

            //Handling import confirmation popup
            if(HelpersMethod.IsExists("//div[contains(text(),'overridden on import')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                HelpersMethod.ActClick(driver,WebEle,10000);
                scenario.log("ORDER HAS BEEN IMPORTED SUCESSFULY");
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
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
            HelpersMethod.EnterText(driver,HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')][1]/descendant::input[contains(@id,'TotalUnitsCol')]"),10000,Qty);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_on_BackButton()
    {
        try
        {
            Thread.sleep(1000);
            WebElement Back_Checout=driver.findElement(By.id("CancelCheckoutButton"));
            HelpersMethod.ScrollElement(driver,Back_Checout);
            HelpersMethod.ClickBut(driver,Back_Checout,10000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
            if(HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-grouping-drop-container')]",driver))
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
            HelpersMethod.EnterText(driver,SearchProd,10000,Prod_Des);
            HelpersMethod.ClickBut(driver,IndexSearch,10000);
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
        String New_route="";
        try
        {
            Thread.sleep(2000);
            WebElement routeIndex=HelpersMethod.FindByElement(driver,"id","RouteIndex");
            HelpersMethod.ScrollElement(driver,routeIndex);
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
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            if(HelpersMethod.IsExists("//input[@id='sortByKeyed' and @data-checked='checked']",driver))
            {
                WebElement sortCheckBox = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='sortByKeyed' and @data-checked='unchecked']");
                HelpersMethod.ActClick(driver,sortCheckBox,10000);
            }

            //To zoom out browser by 50%
            if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.body.style.zoom='50%'");
            }
            else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='50%'");
            }

            WebElement header=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Product #')]");
            if(HelpersMethod.EleDisplay(header))
            {
                HelpersMethod.ScrollElement(driver,header);
                HelpersMethod.JScriptClick(driver,header,10000);

                WebElement Acend_Decend=HelpersMethod.FindByElement(driver,"xpath","//th/descendant::span[contains(text(),'Product #')]/following-sibling::span[contains(@class,'k-icon k-i-sort')]");
                if(HelpersMethod.EleDisplay(Acend_Decend))
                {
                    act.moveToElement(Acend_Decend).doubleClick(Acend_Decend).build().perform();
                }
            }

            //find the column number for Product #
            List<WebElement> theads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for (WebElement head:theads)
            {
                i++;
                act.moveToElement(head).build().perform();
                String head_Text= head.getText();
                if(head_Text.equals("Product #"))
                {
                    break;
                }
            }

            //Creating list of webelements for Products in Order summary grid
            List<WebElement> Products=driver.findElements(By.xpath("//tr[contains(@class,'k-master-row')]/td["+i+"]/descendant::span[contains(@class,'CPKendoDataGrid-Label-rightmargin')]"));
            ArrayList<String> Pro_List=new ArrayList<>();
            for(WebElement Prod: Products)
            {
                Pro_List.add(Prod.getText());
            }
            //Creating sorted list of products in Summary grid
            ArrayList<String> Pro_Sort=new ArrayList<>(Pro_List);
            Collections.sort(Pro_Sort);
            //Comparing the sorted order with list of products
            //Assert.assertEquals(Pro_List,Pro_Sort);
            if(Pro_Sort.equals(Pro_List)==true)
            {
                scenario.log("PRODUCT NUMBERS ARE IN SORTED ORDER");
            }
            else
            {
                scenario.log("PRODUCT NUMBERS ARE NOT IN SORTED ORDER");
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
                HelpersMethod.ClickBut(driver, Route_No, 10000);
                scenario.log("ROUTE NO INDEX HAS BEEN CLICKED");
            }
        }
        catch(Exception e){}
    }

    //Select 2nd route from the popup
    public String SelectRoute()
    {
        String RouteVal=null;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Route #')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='RouteIndexProvider']/descendant::tr[contains(@class,'k-master-row')][2]");
                RouteVal=WebEle.getText();

                HelpersMethod.ActClick(driver,WebEle,10000);
                if(HelpersMethod.IsExists("//div[contains(text(),'The cutoff time')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement cutoffPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'The cutoff time')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton=cutoffPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver,okButton,10000);
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
        String RouteVal1="";
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
            WebElement CommGrid=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
            if(CommGrid.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, CommGrid, 10000);
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
            XPath = "//span[contains(text(),'comments')]/ancestor::div[contains(@class,'k-window k-dialog')]";
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
            XPath = "//span[contains(text(),'comments')]/ancestor::div[contains(@class,'k-window k-dialog')]";
            exists = HelpersMethod.IsExists(XPath, driver);
            if (exists == true)
            {
                WebElement TextArea=HelpersMethod.FindByElement(driver,"id","textAreaA");
                HelpersMethod.ClearText(driver,TextArea,10000);
                HelpersMethod.EnterText(driver,TextArea,10000,Comment);
                scenario.log("COMMENT UPDATED IS "+Comment);
            }
        }
        catch (Exception e){}
    }

    public void Update_Button()
    {
        try
        {
            WebElement Update_But=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Update']");
            if(Update_But.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, Update_But, 10000);
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
            WebElement Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Add']");
            if(Button_Ele.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, Button_Ele, 10000);
                scenario.log("ADD BUTTON IN COMMENT POPUP HAS BEEN CLICKED");
            }
        }
        catch (Exception e){}
    }

    public void Comment_Ok()
    {
        try
        {
            WebElement Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
            if(Button_Ele.isDisplayed())
            {
                //Click on OK button
                HelpersMethod.ClickBut(driver, Button_Ele, 10000);
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
            WebElement CommGrid=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::td[2]");
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
        WebElement UnitCase;
        WebElement YesBut;
        try {
            if (HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]", driver))
            {
                if (HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]", driver))
                {
                    UnitCase = HelpersMethod.FindByElement(driver, "xpath", "//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]");
                    HelpersMethod.ActSendKey(driver, UnitCase, 10000, Unit);
                    scenario.log("UNIT ENTERED IN INPUT BOX IS "+Unit);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }

                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement exceedPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            YesBut = exceedPopup.findElement(By.xpath(".//button/span[text()='Yes']"));
                            HelpersMethod.ActClick(driver, YesBut, 10000);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                            }
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement unavailablePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            YesBut = unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                            HelpersMethod.ActClick(driver, YesBut, 1000);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                            }
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
        WebElement UnitCase;
        WebElement YesBut;
        try
        {
            if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]",driver))
            {
                UnitCase=HelpersMethod.FindByElement(driver,"xpath","//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]");
                HelpersMethod.ActSendKey(driver,UnitCase,1000,Case);
                scenario.log("CASES VALUE ENTERED IN INPUT BOX IS "+Case);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                for(int i=0;i<=1;i++)
                {
                    if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement exceedPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        YesBut = exceedPopup.findElement(By.xpath(".//button/span[text()='Yes']"));
                        HelpersMethod.ActClick(driver, YesBut, 1000);
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                        }
                    }
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement unavailablePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        YesBut = unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                        HelpersMethod.ActClick(driver, YesBut, 1000);
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                        }
                    }
                }
                scenario.log("ENTER CASE QTY HAS BEEN ENTERED IN PRODUCT GRID");
            }
        }
        catch (Exception e){}
    }

    public void EnterUnusualQtyProductLine(String Unit,String Case)
    {
        WebElement WebEle;
        WebElement UnitCase;
        WebElement YesBut;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]",driver))
            {
                if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]",driver))
                {
                    UnitCase=HelpersMethod.FindByElement(driver,"xpath","//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalUnits')]");
                    HelpersMethod.EnterText(driver,UnitCase,10000,Unit);
                    scenario.log("UNIT ENTERED IN INPUT BOX IS "+Unit+" FOR QTY EXCEEDS POPUP");
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement exceedPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            YesBut = exceedPopup.findElement(By.xpath(".//button/span[text()='Yes']"));
                            HelpersMethod.ActClick(driver, YesBut, 1000);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                            }
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement unavailablePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            YesBut = unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                            HelpersMethod.ActClick(driver, YesBut, 1000);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                            }
                        }
                    }
                    HelpersMethod.WaitElementPresent(driver,"id","orderEntryGridContainer",10000);
                    HelpersMethod.waitTillElementLocatedDisplayed(driver,"id","orderEntryGridContainer",10000);
                }
                else if(HelpersMethod.IsExists("//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]",driver))
                {
                    UnitCase=HelpersMethod.FindByElement(driver,"xpath","//tr[1][contains(@class,'k-master-row k-grid-edit-row')]/descendant::input[contains(@id,'TotalCases')]");
                    HelpersMethod.EnterText(driver,UnitCase,1000,Case);
                    scenario.log("CASES ENTERED IN INPUT BOX IS "+Case+" FOR QTY EXCEEDS POPUP");
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
                    for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement exceedPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            YesBut = exceedPopup.findElement(By.xpath(".//button/span[text()='Yes']"));
                            HelpersMethod.ActClick(driver, YesBut, 1000);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                            }
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement unavailablePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            YesBut = unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                            HelpersMethod.ActClick(driver, YesBut, 1000);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                            }
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
        WebElement WebEle;
        WebElement YesBut;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver,WebEle);
            if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]/descendant::input[contains(@id,'TotalUnits')]", driver))
            {
                List<WebElement> unitInputs = HelpersMethod.FindByElements(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::input[contains(@id,'TotalUnits')]");
                for (WebElement unitInput : unitInputs)
                {
                    if (unitInput.isDisplayed())
                    {
                        HelpersMethod.ScrollElement(driver, unitInput);
                        HelpersMethod.ActSendKey(driver, unitInput, 1000, Unit);
                        scenario.log("QTY ENTERED FOR HANDLING UNUSUAL QTY POPUP IS " + Unit);
                        break;
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            for(int i=0;i<=1;i++)
                    {
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement exceedPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            YesBut = exceedPopup.findElement(By.xpath(".//button/span[text()='Yes']"));
                            HelpersMethod.ActClick(driver, YesBut, 1000);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                            }
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                        {
                            WebElement unavailablePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            YesBut = unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                            HelpersMethod.ActClick(driver, YesBut, 1000);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                            }
                        }
                    }
                    scenario.log("UNUSUAL QTY, FOR UNITS POPUP HAS BEEN HANDLED");
        }
        catch (Exception e){}
    }

    public void EnterUnusualCaseQtyProductLine(String Case)
    {
        WebElement WebEle;
        WebElement YesBut;

        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "id", "orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver, WebEle);
            if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]/descendant::input[contains(@id,'TotalCases')]", driver))
            {
                List<WebElement> caseInputs = HelpersMethod.FindByElements(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::input[contains(@id,'TotalCases')]");
                for (WebElement caseInput:caseInputs)
                {
                    if(caseInput.isDisplayed())
                    {
                        HelpersMethod.ScrollElement(driver,caseInput);
                        HelpersMethod.ActSendKey(driver,caseInput,1000,Case);
                        scenario.log("QTY ENTERED FOR HANDLING UNUSUAL QTY POPUP IS "+Case);
                        break;
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            for (int j = 0; j <= 1; j++)
            {
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                    {
                        WebElement exceedPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        YesBut = exceedPopup.findElement(By.xpath(".//button/span[text()='Yes']"));
                        HelpersMethod.ActClick(driver, YesBut, 1000);
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                        }
                    }
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement unavailablePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        YesBut = unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                        HelpersMethod.ActClick(driver, YesBut, 1000);
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                        }
                    }
                }
                scenario.log("UNUSUAL QTY, FOR CASE POPUP HAS BEEN HANDLED");
            }
        }
        catch (Exception e){}
    }

    public void SaveOrderWithOutSubmitting()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
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
            WebElement PopupSubmit = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
            if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                exists = true;
                if (HelpersMethod.EleDisplay(PopupSubmit))
                {
                    PopupSubmit = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Next')]");
                    HelpersMethod.ActClick(driver, PopupSubmit, 10000);
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
        try
        {
            Thread.sleep(1000);
            WebElement productGrid=HelpersMethod.FindByElement(driver,"id","orderEntryGridContainer");
            HelpersMethod.ScrollElement(driver,productGrid);
           /* List<WebElement> titles=HelpersMethod.FindByElements(driver,"xpath", "//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
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
            int i=0;
            //check for visisblility of price override icon
            List<WebElement> priceInput=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-grid-edit-row')]/td["+(priceLoc+1)+"]");
            for(WebElement priceIn:priceInput)
            {
                i++;
                act.moveToElement(priceIn).build().perform();
                if(HelpersMethod.IsExists("//tr[contains(@class,'k-grid-edit-row')]["+i+"]/td["+(priceLoc+1)+"]/descendant::input[contains(@id,'FinalPriceCol')]/preceding-sibling::div//*[local-name()='path' and contains(@d,'M12')]",driver))
                {
                    WebElement priceBeforeOverride=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-grid-edit-row')]["+i+"]/td["+(priceLoc+1)+"]/descendant::input[contains(@id,'FinalPriceCol')]");
                    scenario.log("PRICE FOUND BEFORE PRICE OVERRIDE "+priceBeforeOverride.getText());
                    //rowCount=i;
                    break;
                }
            }*/
            int i=0;
            //check for visisblility of price override icon
            List<WebElement> priceInput=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::input[contains(@id,'FinalPrice')]/preceding-sibling::div//*[local-name()='svg' and contains(@fill,'#000000')]");
            for(WebElement priceIn:priceInput)
            {
                i++;
                act.moveToElement(priceIn).build().perform();
                if(HelpersMethod.IsExists("//tr[contains(@class,'k-grid-edit-row')]["+i+"]/descendant::input[contains(@id,'FinalPriceCol')]/preceding-sibling::div//*[local-name()='svg' and contains(@fill,'#000000')]",driver))
                {
                    //price before overriding
                    WebElement priceBeforeOverride=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-grid-edit-row')]["+i+"]/descendant::input[contains(@id,'FinalPriceCol')]");
                    scenario.log("PRICE FOUND BEFORE PRICE OVERRIDE "+priceBeforeOverride.getText());
                    rowIndex=i;
                    break;
                }
            }

            //Identify and click on price override icon
            WebElement priceOverIcon=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+rowIndex+"]/descendant::input[contains(@id,'FinalPrice')]/preceding-sibling::div//*[local-name()='svg']");
            HelpersMethod.ActClick(driver,priceOverIcon,10000);

            Thread.sleep(2000);
            //validate price override popup
            if(HelpersMethod.IsExists("//div[contains(@class,'selectPriceOverrideDialog ')]",driver))
            {
                scenario.log("PRICE OVERRIDE DIALOG BOX BEEN FOUND");
                exists=true;
            }

            //to identify price override icon
            //WebElement priceOverIcon=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-grid-edit-row')]["+i+"]/td["+(priceLoc+1)+"]/descendant::input[contains(@id,'FinalPriceCol')]/preceding-sibling::div//*[local-name()='path' and contains(@d,'M12')]");
            //HelpersMethod.ActClick(driver,priceOverIcon,1000);
            //validate visibility of price override dialog box
           /* if(HelpersMethod.IsExists("//div[contains(text(),'Price override')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("PRICE OVERRIDE DIALOG BOX HAS BEEN FOUND");
                exists=true;
            }*/
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readValueAfterOverride()
    {
        exists=false;
        String priceAfterOverride="";
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]["+rowIndex+"]/descendant::input[contains(@id,'FinalPrice')]",driver))
            {
                WebElement priceOverride= HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-grid-edit-row')]["+rowIndex+"]/descendant::input[contains(@id,'FinalPriceCol')]");
                priceAfterOverride=HelpersMethod.AttributeValue(priceOverride,"value");
                scenario.log("PRICE AFTER OVERRIDE IS "+priceAfterOverride);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PriceOverridePopup_WhatIfPricePrice(String priceOverride)
    {
        WebElement WebEle;
        Actions act=new Actions(driver);
        String status;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='selectPriceOverride']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                //What if button, finding webelement
                WebElement whatIf =HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button[contains(text(),'What if (alt-w)')]");
                HelpersMethod.ClickBut(driver,whatIf,10000);
                if(HelpersMethod.IsExists("//div[contains(@id,'priceOverrideDialog')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement overridePrice=HelpersMethod.FindByElement(driver,"id","overridePrice");
                    String PriceFound=HelpersMethod.JSGetValueEle(driver,overridePrice,10000);
                    scenario.log("ACTUAL PRICE FOUND IS "+PriceFound);

                    act.moveToElement(overridePrice).click().build().perform();
                    HelpersMethod.JSSetValueEle(driver,overridePrice,10000,"");
                    overridePrice.sendKeys(Keys.BACK_SPACE);
                    act.sendKeys(overridePrice, priceOverride).build().perform();

                    overridePrice.sendKeys(Keys.TAB);
                    scenario.log("PRICE OVERRIDED BY "+priceOverride);
                    //Click on Ok button in popup
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                    //Thread.sleep(1000);
                }
                for(int i=0;i<=2;i++)
                {
                    if (HelpersMethod.IsExists("//li[contains(text(),'price was set to the original price.')]/ancestor::div[contains(@class,'k-widget k-notification k-notification-error')]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-notification-error')]//*[local-name()='svg' and contains(@class,'close-error')]//*[local-name()='path']");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        scenario.log("BASE PRICE SET BACK TO ORIGINAL PRICE");
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                        }
                    }

                    if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        // to fetch the web element of the modal container
                        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        //click on Yes button
                        WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        scenario.log("QUANTITY EXCEEDS MAXIMUM POPUP HANDLED");
                        status = HelpersMethod.returnDocumentStatus(driver);
                        if (status.equals("loading"))
                        {
                            HelpersMethod.waitTillLoadingPage(driver);
                        }
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                        }
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void PriceOverridePopup_WhatIfPriceUnit(String priceOverride)
    {
        WebElement WebEle;
        Actions act=new Actions(driver);
        String status;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='selectPriceOverride']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                //What if button, finding webelement
                WebElement whatIf =HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::span[contains(text(),'What if (alt-w)')]");
                HelpersMethod.ClickBut(driver,whatIf,10000);
                if(HelpersMethod.IsExists("//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement pricePerUnit = HelpersMethod.FindByElement(driver, "id", "overridePricePerUnit");
                    String PriceFound = HelpersMethod.JSGetValueEle(driver, pricePerUnit, 1000);
                    scenario.log("ACTUAL PRICE FOUND IS " + PriceFound);
                    //Enter value for Price per unit input box
                    act.moveToElement(pricePerUnit).click().build().perform();
                    HelpersMethod.JSSetValueEle(driver,pricePerUnit,10000,"");
                    pricePerUnit.sendKeys(Keys.BACK_SPACE);
                    act.sendKeys(pricePerUnit, priceOverride).build().perform();
                    pricePerUnit.sendKeys(Keys.TAB);

                    scenario.log("PRICE OVERRIDED BY " + priceOverride);
                    //Click on Ok button in popup
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'priceOverride-table-container')]/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    Thread.sleep(2000);
                }
                for(int i=0;i<=1;i++)
                {
                    if (HelpersMethod.IsExists("//li[contains(text(),'price was set to the original price.')]/ancestor::div[contains(@class,'k-widget k-notification k-notification-error')]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-notification-error')]//*[local-name()='svg' and contains(@class,'close-error')]//*[local-name()='path']");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        scenario.log("BASE PRICE SET BACK TO ORIGINAL PRICE");
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                        }
                    }

                    if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        // to fetch the web element of the modal container
                        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        //click on Yes button
                        WebEle = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                        HelpersMethod.ClickBut(driver, WebEle, 10000);
                        scenario.log("QUANTITY EXCEEDS MAXIMUM POPUP HANDLED");
                        status = HelpersMethod.returnDocumentStatus(driver);
                        if (status.equals("loading"))
                        {
                            HelpersMethod.waitTillLoadingPage(driver);
                        }
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                        }
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

    public void Validate_Pickup_Order() throws InterruptedException
    {
        Thread.sleep(4000);
        exists=false;
        try
        {
            boolean result1=HelpersMethod.IsExists("//div[contains(@class,'inline-form-group form-group form-group-sm')]/span[contains(text(),'Date')]",driver);
            String result=PickupOrder.getAttribute("disabled");
            //if(result.equals("")||result1==true)
            if(HelpersMethod.IsExists("//input[@id='pickupOrder' and @data-checked='checked']",driver) || result1==true)
            {
                scenario.log("PICKUP ORDER HAS BEEN SELECTED");
                exists=true;
                if(result1==true)
                {
                    String pickDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'inline-form-group')]/span[contains(text(),'Date')]/following-sibling::span").getText();
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
        WebElement WebEle;
        try
        {
            if(PrintBut.isDisplayed() && PrintBut.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, PrintBut);
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, PrintBut, 10000);
                scenario.log("PRINT BUTTON HAS BEEN CLICKED IN NEW OE PAGE");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            if(HelpersMethod.IsExists("//span[contains(@class,'k-window-title k-dialog-title') and contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-window k-dialog')]|//div[text()='Warning']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("CHANGE DELIVERY DATE POPUP HAS BEEN FOUND");
               // exists=true;
            }
          //  Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectChangeDeliveryDatePopup()
    {

        WebElement WebEle;
        try
        {
            for(int i=0;i<=1;i++)
            {
                if(HelpersMethod.IsExists("//span[text()='Warning']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                }
                if (HelpersMethod.IsExists("//span[contains(@class,'k-window-title k-dialog-title') and contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button[contains(text(),'Change delivery date')]");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    //exists = true;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        }
        catch (Exception e){}
    }



    public boolean VerifyForMessageForPOMandatory()
    {
        exists=false;
        WebElement PO_Notification;
        try
        {
           if(HelpersMethod.IsExists("//div[contains(text(),'Po number must be provided for the current order.')]",driver))
           {
               if (!PO_No.getText().equals(" "))
               {
                   HelpersMethod.ActClearKey(driver, PO_No, 10000);
                   PO_Notification = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Po number must be provided for the current order.')]");
                   if (PO_Notification.isDisplayed()) {
                       scenario.log("PO# IS MANDATORY FIELD");
                       exists = true;
                   }
               }
               else
               {
                   PO_Notification = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Po number must be provided for the current order.')]");
                   if (PO_Notification.isDisplayed())
                   {
                       scenario.log("PO# IS MANDATORY FIELD");
                       exists = true;
                   }
               }
           }
           else
           {
               scenario.log("<span style='color:red'>PO# NOT IS MANDATORY FIELD, CHECK WITH ADMIN SETTINGS</span>");
               exists=false;
           }
        }
        catch (Exception e){}
        return exists;
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
                HelpersMethod.ClickBut(driver,PickupOrder,10000);
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
        String price1;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","FinalPriceCol0");
            HelpersMethod.ActSendKey(driver,WebEle,10000," ");
            HelpersMethod.JSSetValueEle(driver,WebEle,10000,price);
            price1=HelpersMethod.JSGetValueEle(driver,WebEle,10000);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            //new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.id("orderEntryGridContainer"))));
            if(HelpersMethod.IsExists("//div[@id='orderEntryGridContainer']",driver))
            {
                WebElement produGrid = HelpersMethod.FindByElement(driver, "id", "orderEntryGridContainer");
                HelpersMethod.ScrollElement(driver, produGrid);
                scenario.log("PRODUCT FOUND IN ORDER ARE ");
                List<WebElement> Products = HelpersMethod.FindByElements(driver, "xpath", "//td[contains(@class,'CPKendoDataGrid-td pointerRow')]/descendant::a[@data-value='formattedValue']");
                for (WebElement prod : Products)
                {
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
            HelpersMethod.ScrollUpScrollBar(driver);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void handleTirePricingpopup()
    {
        if(HelpersMethod.IsExists("//div[contains(text(),'the following product ')]/ancestor::",driver))
        {
            WebElement tirePricing=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'the following product ')]/ancestor::div[contains(@class,'k-window k-dialog')]");
            WebElement continueButton=tirePricing.findElement(By.xpath(".//button/span[text()='Continue']"));
            HelpersMethod.ClickBut(driver,continueButton,10000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        }
    }

    public String readUnitOfMeasure()
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        WebElement unitOfMeasure = null;
        if(HelpersMethod.IsExists("//span[@id='quickEntryUMs']/span[@class='k-input']|//span[@id='quickEntryUMs']/descendant::span[@class='k-input-value-text']",driver))
        {
            unitOfMeasure = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='quickEntryUMs']/span[@class='k-input']|//span[@id='quickEntryUMs']/descendant::span[@class='k-input-value-text']");
        }
        else if(HelpersMethod.IsExists("//div[contains(@class,'quickUMs')]/descendant::label[contains(@class,'quick-um-single-value')]",driver))
        {
            unitOfMeasure = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'quickUMs')]/descendant::label[contains(@class,'quick-um-single-value')]");
        }
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
            WebElement gridSelected=HelpersMethod.FindByElement(driver,"xpath","//button[@id='grid-selection']/descendant::span[@class='k-button-text']");
            String gridName=gridSelected.getText();
            if(gridName.contains(grid))
            {
              scenario.log("GRID SELECTED IN NEW ORDER "+gridName);
              exists=true;
            }
            else
            {
                scenario.log("GRID SELECTED IS NOT SAME AS DEFAULT GRID SELECTED IN ADMIN"+gridName);
                exists=false;
            }
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
                HelpersMethod.ActClick(driver, ShowAllProd, 10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectFilterQty(String arg0)
    {
        exists=false;
        String listEle_Text="";
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li",driver))
            {
                List<WebElement> listEles = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-list-container')]/descendant::ul/li");
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
        String listEle_Text;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//ul[@id='addButton-accessibility-id']/li/descendant::span[@class='k-menu-link-text']",driver))
            {
                List<WebElement> listEles = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='addButton-accessibility-id']/li/descendant::span[@class='k-menu-link-text']");
                for (WebElement listEle:listEles)
                {
                    act.moveToElement(listEle).build().perform();
                    listEle_Text=listEle.getText();
                    if(listEle_Text.equals("From profile"))
                    {
                        act.moveToElement(listEle).build().perform();
                        act.click(listEle).build().perform();
                        scenario.log("FROM PROFILE HAS BEEN SELECTED FROM ADD PRODUCT DROP DOWN");
                        exists=true;
                        break;
                    }
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateProfileProductsInGrid()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[@class='k-grid k-grid-md']",driver))
            {
                scenario.log("<span style='color:red'>NO PROFILE PRODUCTS HAVE BEEN FOUND");
            }
            else
            {
                scenario.log("PROFILE PRODUCTS HAVE BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCatalogdialog()
    {
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        //HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-window k-dialog')]",100000);
        WebElement catalogDialog = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

        WebElement modalContentTitle = catalogDialog.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
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
                HelpersMethod.ActClick(driver,showAllProd,10000);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
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
            HelpersMethod.ClickBut(driver, resetFilter, 10000);
            exists = true;
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
                HelpersMethod.ActClick(driver,showAllProd,10000);
                exists = true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectOGDropDown()
    {
            exists=false;
            String prods;
            Actions act=new Actions(driver);
            String og=TestBase.testEnvironment.get_OrderGuide();
            try
            {
                WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
                List<WebElement> allProds=dropDown.findElements(By.xpath(".//ul/li"));
                for(WebElement prod:allProds)
                {
                    act.moveToElement(prod).build().perform();
                    prods=prod.getText();
                    if(prods.contains(og))
                    {
                        act.moveToElement(prod).build().perform();
                        act.click(prod).build().perform();
                        exists=true;
                        break;
                    }
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
                HelpersMethod.ActClick(driver,showAllProd,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCategoryDropDown()
    {
        exists=false;
        String prods;
        Actions act=new Actions(driver);
        String category=TestBase.testEnvironment.get_Category();
        try
        {
            WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> allProds=dropDown.findElements(By.xpath(".//ul/li"));
            for(WebElement prod:allProds)
            {
                act.moveToElement(prod).build().perform();
                prods=prod.getText();
                if(prods.equals(category))
                {
                    act.moveToElement(prod).build().perform();
                    act.click(prod).build().perform();
                    exists = true;
                    break;
                }
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
                HelpersMethod.ActClick(driver,showAllProd,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectSubCategoryDropDown()
    {
        exists = false;
        String prods;
        Actions act = new Actions(driver);
        String subCategory=TestBase.testEnvironment.get_SubCategory();
        try {
            WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> allProds = dropDown.findElements(By.xpath(".//ul/li"));
            for (WebElement prod : allProds)
            {
                act.moveToElement(prod).build().perform();
                prods = prod.getText();
                if (prods.equals(subCategory))
                {
                    act.moveToElement(prod).build().perform();
                    act.click(prod).build().perform();
                    exists = true;
                    break;
                }
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
                HelpersMethod.ActClick(driver,showAllProd,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectBrandDropDown()
    {
        exists=false;
        String prods;
        Actions act=new Actions(driver);
        String brand=TestBase.testEnvironment.get_Brand();
        try
        {
            WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> allProds=dropDown.findElements(By.xpath(".//ul/li"));
            for(WebElement prod:allProds)
            {
                act.moveToElement(prod).build().perform();
                prods=prod.getText();
                if(prods.equals(brand))
                {
                    act.moveToElement(prod).build().perform();
                    act.click(prod).build().perform();
                    exists = true;
                    break;
                }
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
                scenario.log("CATALOG HAS BEEN DISPLAYED AS CARD VIEW");
                exists=true;
            }
            else if(HelpersMethod.IsExists("//div[@class='i-grid']",driver))
            {
                scenario.log("CATALOG IS DISPLAYED IN GRID VIEW");
                exists=true;
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
            Thread.sleep(2000);
            if(HelpersMethod.IsExists("//button[@data-test-id='grid-selection']/span",driver))
            {
                HelpersMethod.ScrollElement(driver,gridType);
                HelpersMethod.ClickBut(driver,gridType,2000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectGridTypeDropDown()
    {
        exists=false;
        Actions act1=new Actions(driver);
        //WebElement opt;
        String optText;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-child-animation-container']/descendant::ul/li"))));
            List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-child-animation-container']/descendant::ul/li");
            //for (int i=0;i<=Options.size()-1;i++)
            for(WebElement opt:Options)
            {
                //opt=Options.get(i);
                act1.moveToElement(opt).build().perform();
                optText=opt.getText();
                if (!optText.equals("Main grid"))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists=true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            String gridName=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='grid-selection']").getText();
            scenario.log("GRID SELECTED IS "+gridName);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectMainGridTypeDropDown()
    {
        exists=false;
        Actions act1=new Actions(driver);
        //WebElement opt;
        String optText;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-child-animation-container']/descendant::ul/li"))));
            List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-child-animation-container']/descendant::ul/li");
            //for (int i=0;i<=Options.size()-1;i++)
            for(WebElement opt:Options)
            {
                act1.moveToElement(opt).build().perform();
                optText=opt.getText();
                if (optText.equals("Main grid"))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists=true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            String gridName=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='grid-selection']").getText();
            scenario.log("GRID SELECTED IS "+gridName);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateGridType()
    {
        exists=false;
        try
        {
            String gridValue=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='grid-selection']").getText();
            if(!gridValue.equals("Main grid"))
            {
                scenario.log("GRID TYPE SELECTED IS "+gridValue);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateMainGridType()
    {
        exists=false;
        try
        {
            String gridValue=HelpersMethod.FindByElement(driver,"xpath","//button[@id='grid-selection']/descendant::span[@class='k-button-text']").getText();
            if(gridValue.equals("Main grid"))
            {
                scenario.log("GRID TYPE SELECTED IS "+gridValue);
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
            WebElement oeGrid=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-grid-header k-grid-draggable-header')]");
            HelpersMethod.ScrollElement(driver,oeGrid);
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
        String listText;
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
                    if(head_text.equals("Brand"))
                    {
                        break;
                    }
                }
                //Enter search value in input box
                String searchValue=TestBase.testEnvironment.get_Brand();
                WebElement catalogFilter=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-filter-row']/th["+i+"]/descendant::input");

                WebElement filterInput= driver.findElement(By.xpath("//tr[@class='k-filter-row']/th["+i+"]/descendant::input"));
                act1.moveToElement(filterInput).click().build().perform();
                HelpersMethod.JSSetValueEle(driver,filterInput,1000,"");
                filterInput.sendKeys(Keys.BACK_SPACE);
                HelpersMethod.JSSetValueEle(driver,filterInput,1000,searchValue);

                //Click on filter icon
                WebElement filterIcon=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-filter-row']/th["+i+"]/descendant::span[contains(@class,'k-icon k-i-filter k-icon')]");
                HelpersMethod.ActClick(driver,filterIcon,1000);
                List<WebElement> Lists=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
                for(WebElement listValue:Lists)
                {
                    act1.moveToElement(listValue).build().perform();
                    listText=listValue.getText();
                    if(listText.equals("Is equal to"))
                    {
                        act1.moveToElement(listValue).build().perform();
                        act1.click().build().perform();
                        break;
                    }
                }

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }

                String catFilterVal=HelpersMethod.JSGetValueEle(driver,catalogFilter,1000);
                if(catFilterVal.equals(searchValue))
                {
                    scenario.log("IN BRAND OPTION SEARCHED IS "+searchValue);
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
                WebElement catPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                List<WebElement> Products=catPopup.findElements(By.xpath(".//button[@class='i-link-button']"));
                for (WebElement product:Products)
                {
                    prod_Text= product.getText();
                    scenario.log("PRODUCTS FOUND IN CATALOG "+prod_Text);
                    exists=true;
                }
            }
            else
            {
                scenario.log("NO PRODUCTS HAS BEEN FOUND");
            }
            Assert.assertEquals(exists,true);
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
                WebElement catPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
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
            WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
            WebElement okButton=catalogPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
            if(okButton.isDisplayed() && okButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,okButton,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validatePickupCheckBoxSelected()
    {
        exists=false;
        try
        {
            //WebElement pickCheckbox=HelpersMethod.FindByElement(driver,"id","pickupOrder");
            if(HelpersMethod.IsExists("//input[@id='pickupOrder' and @data-checked='checked']",driver))
            {
                scenario.log("PICKUP ORDER CHECKBOX IS VISIBLE AND CAN PROCEED WITH CREATING PICKUP ORDER");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void toastCurrentlyUnavailable()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            for(int i=0;i<=1;i++)
           {
               if (HelpersMethod.IsExists("//div[@class='toast-message' and contains(text(),'This product is currently unavailable.')]", driver))
               {
                   Thread.sleep(500);
                   WebElement toastCurrentlyUnavailable = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='toast-message' and contains(text(),'This product is currently unavailable.')]/preceding-sibling::button[text()='×']");
                   HelpersMethod.ActClick(driver, toastCurrentlyUnavailable, 20000);
                   scenario.log("TOAST MESSAGE FOR: CURRENTLY UNAVAILABLE HAS BEEN HANDLED");
                   Thread.sleep(500);
               }
               if (HelpersMethod.IsExists("//div[@class='toast-message' and contains(text(),'This product is currently low on inventory.')]", driver))
               {
                   Thread.sleep(500);
                   WebElement toastCurrentlyUnavailable = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='toast-message' and contains(text(),'This product is currently low on inventory.')]/preceding-sibling::button[text()='×']");
                   HelpersMethod.ActClick(driver, toastCurrentlyUnavailable, 20000);
                   scenario.log("TOAST MESSAGE FOR: CURRENTLY UNAVAILABLE HAS BEEN HANDLED");
                   Thread.sleep(500);
               }
               if(HelpersMethod.IsExists("//div[contains(text(),'There are no matching products: ')]/ancestor::div[@id='toast-container']",driver))
               {
                   Thread.sleep(500);
                   WebElement toastNoMatchingProd=HelpersMethod.FindByElement(driver,"xpath","//div[@id='toast-container']/descendant::button");
                   HelpersMethod.ActClick(driver,toastNoMatchingProd,20000);
                   scenario.log("<span style='color:red'>TOAST MESSAGE FOR: THERE ARE NO MATCHING PRODUCTS HAS BEEN HANDLED</span>");
                   Thread.sleep(500);
               }
           }
        }
        catch (Exception e){}
    }

    public void navigateToOrderEntryIfNavigatedToNewOE()
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        //check whether navigated to new OE page after changing account, if yes, navigate back to OE page
        try
        {
            if(HelpersMethod.IsExists("//label[contains(text(),'New order')]",driver))
            {
                WebElement backButton=HelpersMethod.FindByElement(driver,"id","backButton");
                HelpersMethod.ClickBut(driver,backButton,10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void priceCannotBeBleowCost()
    {
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Price cannot be set below the cost')]/ancestor::div[@class='k-widget k-notification k-notification-error']",driver))
            {
                Thread.sleep(500);
                WebElement toastCurrentlyUnavailable=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-notification k-notification-error']/descendant::button//*[local-name()='svg']");
                HelpersMethod.ActClick(driver,toastCurrentlyUnavailable,20000);
                scenario.log("TOAST MESSAGE FOR: PRICE CANNOT BE SET BELOW HAS BEEN HANDLED");
                Thread.sleep(500);
            }
        }
        catch (Exception e){}
    }

    public void unavailableProduct()
    {
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                //click on Continue button
                WebEle=modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver,WebEle, 10000);
                scenario.log("This product is currently unavailable.");

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void listCatelogQoH(String searchValue)
    {
        exists=false;
        String head_text;
        String status;
        int i=0;
        String listText;
        Actions act1=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//button[@class='i-grid__filter-button']",driver))
            {
                //if filter header is not displayed click on filter icon
                if(!HelpersMethod.IsExists("//span[contains(@class,'k-i-filter-clear k-icon')]",driver))
                {
                    WebElement filterIcon=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-i-filter-clear k-icon')]");
                    HelpersMethod.JScriptClick(driver,filterIcon,10000);
                }
                //Find all the headers of catalog dialog box, when displayed in list view
                List<WebElement> headers = HelpersMethod.FindByElements(driver, "xpath", "//th[@class='k-header']/descendant::span[@class='k-column-title']");
                for(WebElement head:headers)
                {
                    i++;
                    HelpersMethod.ScrollTillElementVisible(driver,head);
                    head_text=head.getText();
                    if(head_text.equals("Quantity on hand") || head_text.equals("QoH"))
                    {
                        scenario.log("QUANTITY ON HAND COLUMN HAS BEEN FOUND IN COLUMN NUMBER "+i);
                        break;
                    }
                }
                //Enter search value in input box
                WebElement filterInput= driver.findElement(By.xpath("//tr[@class='k-filter-row']/th["+i+"]/descendant::input[contains(@class,'k-input')]"));
                HelpersMethod.EnterText(driver,filterInput,10000,searchValue);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                //act1.moveToElement(filterInput).click().build().perform();
                //HelpersMethod.JSSetValueEle(driver,filterInput,1000,"");
                //filterInput.sendKeys(Keys.BACK_SPACE);
                //filterInput.sendKeys(searchValue);

                //Click on filter icon
                WebElement filterIcon=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-filter-row']/th["+i+"]/descendant::span[contains(@class,'k-icon k-i-filter k-icon')]");
                act1.moveToElement(filterIcon).build().perform();
                HelpersMethod.JScriptClick(driver,filterIcon,10000);
                List<WebElement> Lists=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
                for(WebElement listValue:Lists)
                {
                    act1.moveToElement(listValue).build().perform();
                    listText=listValue.getText();
                    if(listText.equals("Is equal to"))
                    {
                        act1.moveToElement(listValue).build().perform();
                        act1.click().build().perform();
                        scenario.log("FILTER VALUE USED TO FILTER QoH COLUMN IS Is equal to");
                        break;
                    }
                }

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                 wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if(!HelpersMethod.IsExists("//div[@class='i-no-data__message']",driver))
                {
                    exists = true;
                }
                else
                {
                    scenario.log("<span style='color:red'> NO PRODUCT HAS BEEN FOUND AFTER APPLYING QoH FILTER</span>");
                    scenario.log("<span style='color:red'>PLEASE SEARCH WITH VALID SEARCH VALUE</span>");
                }
            }
            else
            {
                scenario.log("<span style='color:red'>QoH FILTER NOT VISIBLE, PLZ CHECK ADMIN SETTING</span>");
                scenario.log("<span style='color:red'>THIS SCENARIO IS APPLICABLE ONLY ON LIST VIEW CATALOG</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCatalogProducts()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]/ancestor::div[contains(@class,'k-window k-dialog')]|//div[contains(@class,'i-no-data__message')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                scenario.log("<space style='color:red'>SORRY NO PRODUCTS HAS BEEN FOUND</space>");
                exists=false;
            }
            else
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateSalesRep(String changedSalesRep)
    {
        exists=false;
        try
        {
            String changeSaleRep=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Sales rep')]/following-sibling::span").getText();
            scenario.log("SALES REP IN OE PAGE IS "+changedSalesRep+" SALES REP FOUND IN NEW OE PAGE IS "+changeSaleRep);
            if(changedSalesRep.equalsIgnoreCase(changeSaleRep))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ResetFilter_CatalogDisconnectedMode()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        try
        {
            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//button/span[contains(text(),'Reset filter')]");
                    HelpersMethod.ActClick(driver,WebEle,10000);
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                }
                else if (HelpersMethod.IsExists("//div[@class='i-grid']", driver))
                {
                    if(HelpersMethod.IsExists("//div[@class='k-window k-dialog']/descendant::span[@class='i-filter-tag__main__text i-filter-tag__main__text--add']",driver))
                    {
                        //Click on 'Add filter'
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']");
                        HelpersMethod.ActClick(driver, WebEle, 10000);

                        //Click on 'Clear all'
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-filter-popup__footer')]/button/span[contains(text(),'Clear all')]");
                        if (WebEle.isEnabled())
                        {
                            HelpersMethod.ActClick(driver, WebEle, 10000);
                            exists = true;
                            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                            }
                        }
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickonBackInNewOE()
    {
        exists=false;
        try
        {
            if(Back_But.isDisplayed() && Back_But.isEnabled())
            {
                HelpersMethod.ScrollTillElementVisible(driver, Back_But);
                HelpersMethod.ClickBut(driver, Back_But, 2000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validatePriceOverridePopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='selectPriceOverride']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void gridViewFilter(String filterHeader,String filterValue,int i)
    {
        exists=false;
        String tHeadText=null;
        try
        {
            List<WebElement> tableHeader= HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@style,'touch-action')]/descendant::span[contains(@class,'k-column-title')]");
            for (WebElement tHead:tableHeader)
            {
                i++;
                tHeadText=tHead.getText();
                if(tHeadText.equalsIgnoreCase(filterHeader))
                {
                    break;
                }
            }
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-filter-row']/th["+i+"]/descendant::input");
            HelpersMethod.JSSetValueEle(driver,WebEle,1000,"");
            WebEle.sendKeys(Keys.BACK_SPACE);

            for (int j = 0; j < filterValue.length(); j++)
            {
                char c = filterValue.charAt(j);
                String s = new StringBuilder().append(c).toString();
                WebEle.sendKeys(s);
            }

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            scenario.log("PRODUCTS FOUND UNDER "+filterValue);
        }
        catch (Exception e){}
    }

    public void removeFilter(String filterHeader,int i)
    {
        Actions act=new Actions(driver);
        String tHeadText=null;
        try
        {
            List<WebElement> tableHeader= HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for (WebElement tHead:tableHeader)
            {
                i++;
                tHeadText=tHead.getText();
                if(tHeadText.equalsIgnoreCase(filterHeader))
                {
                    break;
                }
            }
            //Click on remove filter value
            WebElement removeFilter=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-filter-row']/th["+i+"]/descendant::span[contains(@class,'clear')]");
            act.moveToElement(removeFilter).click().build().perform();

            Wait<WebDriver> wait  = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void readingProdcuts()
    {
        String prodNo=null;
        try
        {
            //Read all the product numbers that falls on particular category/sub category/brand
            List<WebElement> prods= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button[contains(@class,'i-link-button')]");
            for (WebElement prod:prods)
            {
                prodNo=prod.getText();
                scenario.log(prodNo);
            }
        }
        catch (Exception e){}
    }

    public void lowOnInventoryToast()
    {
        try
        {
            if(HelpersMethod.IsExists(" //div[contains(text(),'This product is currently low on inventory')]/ancestor::div[contains(@class,'toast toast-warning')]",driver))
            {
                scenario.log("LOW IN INVENTORY TOAST HAS BEEN HANDLED");
                HelpersMethod.FindByElement(driver,"xpath","//button[@class='toast-close-button']").click();
            }
        }
        catch (Exception e){}
    }

    public void clickOnInfoDropDown()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//button[@data-test-id='info-selection']",driver))
            {
                WebElement infoDropDown = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='info-selection']");
                HelpersMethod.ClickBut(driver,infoDropDown,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectShowPriceInq()
    {
        exists=false;
        Actions act=new Actions(driver);
        String infoText;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li",driver))
            {
                List<WebElement> infoLists = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-list-container')]/descendant::ul/li");
                for(WebElement infoList:infoLists)
                {
                    act.moveToElement(infoList).build().perform();
                    infoText= infoList.getText();
                    if(infoText.equals("Show price inquiry"))
                    {
                        act.moveToElement(infoList).build().perform();
                        act.click(infoList).build().perform();
                        exists=true;
                        break;
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateShowPriceDialogbox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Price inquiry')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readCostPrice()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExistsById("SalesBaseCost",driver))
            {
                WebElement bCost=HelpersMethod.FindByElement(driver,"id","SalesBaseCost");
                baseCost=HelpersMethod.JSGetValueEle(driver,bCost,10000);
                scenario.log("SALES BASE COST OF PRODUCT IS "+bCost);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnLoadAllProducts()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                WebElement loadProd=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
                HelpersMethod.ActClick(driver,loadProd,20000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void verifyProductGridTitle(String newLabel)
    {
        exists=false;
        String titleText;
        Actions act=new Actions(driver);
        try
        {

            WebElement dragDropHeader=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-grouping-header']");
            HelpersMethod.ScrollTillElementVisible(driver,dragDropHeader);

            List<WebElement> titles=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement title:titles)
            {
                act.moveToElement(title).build().perform();
                titleText=title.getText();
                scenario.log("TITLE FOUND IN PRODUCT GRID "+titleText);
            }


            for(WebElement title:titles)
            {
                act.moveToElement(title).build().perform();
                titleText=title.getText();
                if(titleText.equalsIgnoreCase(newLabel))
                {
                    scenario.log("CHANGES TO TITLE HAS BEEN REFLECTED");
                    exists=true;
                    break;
                }
            }
            Thread.sleep(1000);

            if(exists==false)
            {
                scenario.log("<span style='color:red'>CHANGES TO TITLE HAS NOT BEEN REFLECTED</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validatePOMandatoryMessage()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='poNumberNotification']",driver))
            {
                scenario.log("PO# IS MANDATORY MESSAGE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validatePONoMandatoryMessage()
    {
        exists=false;
        try
        {
            if(AddProduct.isDisplayed() && AddProduct.isEnabled())
            {
                scenario.log("PO# IS MANDATORY MESSAGE HAS NOT BEEN FOUND");
                scenario.log("DO CHECK EVEN IN CUSTOMER INQ, ACCOUNT, PO# MANDATORY SETTING SHOULD BE SET TO NO");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNoAutoLoadProducts()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(@class,'i-no-data__link')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("DO NOT LOAD FULL CATALOG AUTOMATICALLY,HAS BEEN ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAutoLoadProducts()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//span[contains(@class,'i-no-data__link')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("DO NOT LOAD FULL CATALOG AUTOMATICALLY,HAS BEEN ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifySalesRepValue(String primarySalesRep)
    {
        exists=false;
        String salesRep=null;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Sales rep')]/following-sibling::span",driver))
            {
                salesRep = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Sales rep')]/following-sibling::span").getText();
                scenario.log("SALRES REP VALUE FOUND IN NEW ORDER ENTRY PAGE IS "+salesRep);
                if (!salesRep.equalsIgnoreCase(primarySalesRep) && !salesRep.equalsIgnoreCase(" "))
                {
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyNoPriceColumn()
    {
        exists=false;
        try
        {
            //Code to verify existence of price value in grid or card layout catalog
            if(!HelpersMethod.IsExists("//span[@class='item-name' and contains(text(),'Price')]|//div[contains(@class,'k-window k-dialog')]/descendant::span[@class='k-column-title' and text()='Price']",driver))
            {
                scenario.log("SUCCESSFULLY DISABLED DISPLAY OF PRICE VALUE IN DISCONNECTED MODE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyPriceColumn()
    {
        exists=false;
        try
        {
            //Code to verify existence of price value in grid or card layout catalog
            if(HelpersMethod.IsExists("//span[@class='item-name' and contains(text(),'Price')]|//div[contains(@class,'k-window k-dialog')]/descendant::span[@class='k-column-title' and text()='Price']",driver))
            {
                scenario.log("SUCCESSFULLY DISPLAYING PRICE VALUE IN DISCONNECTED MODE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String validateRouteValue()
    {
        String rNo="";
        try
        {
            WebElement routeEle=HelpersMethod.FindByElement(driver,"id","RouteIndex");
            HelpersMethod.ScrollElement(driver,routeEle);
            rNo=HelpersMethod.JSGetValueEle(driver,routeEle,10000);
        }
        catch (Exception e){}
        return rNo;
    }

    //click on route index button
    public void clickRouteIndex()
    {
        exists=false;
        WebElement WebEle = null;
        exists = false;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        try
        {
            //Click on Index icon next to Route#
            WebElement route_No = HelpersMethod.FindByElement(driver, "xpath", "//div[@data-test-id='RouteIndex']/descendant::button[contains(@class,'i-indexfield')]");
            if(route_No.isDisplayed())
            {
                //HelpersMethod.ClickBut(driver, route_No, 10000);
                HelpersMethod.ActClick(driver,route_No,10000);
                exists=true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@id='RouteIndexProvider']/ancestor::div[contains(@class,'k-window k-dialog')]", 200000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateRouteDialog()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='RouteIndexProvider']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("ROUTE HAS DIALOG BOX HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Selcting route from the index popup
    public void Route_No(String SearchOpt, String SearchDetail) throws InterruptedException
    {
        exists=false;
        String status;
        WebElement Clear=null;
        try
        {
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

            //Click on Add filter
            WebElement addFilter=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::span[contains(text(),'Add filter')]");
            HelpersMethod.ActClick(driver,addFilter,10000);
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]")));
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",10000);

            //Drop down after clicking add filter button
            WebElement modalContainer1 =HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");
            if(HelpersMethod.IsExists("//div[@class='k-child-animation-container']/descendant::div[@class='i-filter-popup i-filter-popup--add']",driver))
            {
                    //Click on Clear all button
                    Clear = modalContainer1.findElement(By.xpath(".//button/span[contains(text(),'Clear all')]"));
                    if (Clear.isEnabled())
                    {
                        Clear.click();
                    }
                    driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Add filter')]")).click();
            }
            //Enter filter values in drop down
            modalContainer1 =HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");
            WebElement search1=modalContainer1.findElement(By.xpath(".//input[@class='i-search-box__input']"));
            HelpersMethod.JSSetValueEle(driver,search1,10000,SearchOpt);
            Thread.sleep(1000);
            //Click on check box
            WebElement checkBox=driver.findElement(By.xpath(".//input[@id='code']"));
            HelpersMethod.ActClick(driver,checkBox,10000);
            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]",80000);
            Thread.sleep(1000);
            //Enter 2nd search value
            modalContainer1 =HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");
            WebElement search2=modalContainer1.findElement(By.xpath(".//input[@class='k-textbox']"));
            HelpersMethod.EnterText(driver,search2,10000,SearchDetail);
            //click on apply button
            WebElement apply=modalContainer1.findElement(By.xpath(".//button/span[text()='Apply']"));
            HelpersMethod.ClickBut(driver,apply,10000);
            //Select route in dialog box
            WebElement routeValue=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]");
            HelpersMethod.ActClick(driver,routeValue,10000);

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle1, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Read the route value from the route index
            Thread.sleep(1000);
            WebElement routeCha=HelpersMethod.FindByElement(driver,"id","RouteIndex");
            //routeCha.sendKeys(Keys.TAB);
            String routeChange=HelpersMethod.JSGetValueEle(driver,routeCha,10000);
            scenario.log("ROUTE FOUND IN INPUT BOX IS "+routeChange);
            if(routeChange.equalsIgnoreCase(TestBase.testEnvironment.get_Route())||routeChange.contains(TestBase.testEnvironment.get_Route()))
            {
                scenario.log("ROUTE SELECTED IS "+routeChange);
                exists = true;
            }
            if(HelpersMethod.IsExists("//div[@id='toast-container']",driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
            }
            Thread.sleep(4000);
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void validateRouteSelected(String route)
    {
        exists=false;
        try
        {
            Thread.sleep(2000);
            String routeFound=HelpersMethod.JSGetValueEle(driver,RouteInput,2000);
            if(routeFound.contains(route))
            {
                scenario.log("SUCCESSFULY SET THE ROUTE VALUE");
                exists=true;
            }
            else
            {
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch(Exception e) {}
    }

    public void compareCustomerAccountNo(String customerAccount)
    {
        exists=false;
        try
        {
         String newOECustomerAccount=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Account #')]/following-sibling::span").getText();
         if(!newOECustomerAccount.equalsIgnoreCase(customerAccount))
         {
             scenario.log("CUSTOMER ACCOUNT NUMBER WITH HARD HOLD IS "+customerAccount+" AND CUSTOMER ACCOUNT NUMBER FOUND IN NEW OE PAGE IS "+newOECustomerAccount);
             exists=true;
         }
         else
         {
            scenario.log("<span style='color:red'>CUSTOMER ACCOUNT NUMBER WITH HARD HOLD AND CUSTOMER ACCOUNT NUMBER FOUND IN NEW OE ARE SAME</span>");
         }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public boolean handleRouteNotSelectedDialogBox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                HelpersMethod.ActClick(driver,okButton,10000);
                exists=true;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public void enterQtyForQuickProd()
    {
        String Case= String.valueOf(100);
        String Unit= String.valueOf(80);
        try
        {
            String uomString=VerifyUOM();
            if(uomString.equals("Units")||uomString.equals("EA"))
            {
                CheckForQuickUnitEnabled(Unit);
                if(uomString.equals("Units"))
                {
                    WebElement caseIn = HelpersMethod.FindByElement(driver, "id", "quickCases");
                    if (caseIn.equals(driver.switchTo().activeElement()))
                    {
                        caseIn.sendKeys(Keys.TAB);
                    }
                }
                new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='pending-quick-entry-calls']")));
                exceedsMaxQty();
                for(int i=0;i<=1;i++)
                {
                    //check for toast message for low on inventory
                    lowOnInventoryToast();
                    //check for toast message for product is currently unavailable
                    toastCurrentlyUnavailable();
                }
            }
            else if(uomString.equals("Cases")||uomString.equals("CS"))
            {
                CheckForQuickCaseEnabled(Case);
                if(uomString.equals("Cases"))
                {
                    WebElement unitIn = HelpersMethod.FindByElement(driver, "id", "quickUnits");
                    if (unitIn.equals(driver.switchTo().activeElement()))
                    {
                        unitIn.sendKeys(Keys.TAB);
                    }
                }
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='pending-quick-entry-calls']")));
                exceedsMaxQty();
                for(int i=0;i<=1;i++)
                {
                    //check for toast message for low on inventory
                    lowOnInventoryToast();
                    //check for toast message for product is currently unavailable
                    toastCurrentlyUnavailable();
                }
            }
            else if(uomString.equals("Cases, Units")||uomString.equals("Units, Cases")||uomString.equals("CS, EA")||uomString.equals("EA, CS"))
            {
                CheckForQuickCaseEnabled(Case);
                CheckForQuickUnitEnabled(Unit);
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='pending-quick-entry-calls']")));
                exceedsMaxQty();
                for(int i=0;i<=1;i++)
                {
                    //check for toast message for low on inventory
                    lowOnInventoryToast();
                    //check for toast message for product is currently unavailable
                    toastCurrentlyUnavailable();
                }
            }
        }
        catch (Exception e){}
    }

    public void selectProductFromCatalog(List<List<String>> qty)
    {
        Actions act1=new Actions(driver);
        String headText;
        WebElement WebEle;
        int i=0;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-window k-dialog']/descendant::span[@class='k-column-title']");
            //to find Cases input box is visible
            for(WebElement head:heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Cases"))
                {
                    break;
                }
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::tr[contains(@class,'k-master-row')][1]/td["+i+"]/descendant::input");
            act1.moveToElement(WebEle).click().build().perform();
            act1.sendKeys(Keys.CONTROL + "a");
            act1.sendKeys(Keys.DELETE);
            act1.sendKeys(WebEle, qty.get(0).get(0)).build().perform();
            act1.sendKeys(Keys.TAB).build().perform();
            scenario.log("UNIT ENTERED IN CATALOG " + qty.get(0).get(0));

            Thread.sleep(1000);
            //Check for popups
            for (int a = 0; a <= 2; a++)
            {
                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    // to fetch the web element of the modal container
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on Yes button
                    WebElement yesButton = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                    HelpersMethod.ActClick(driver, yesButton, 10000);
                }

                //"Product is currently unavailable" popup
                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                    WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver, okButton, 20000);
                }
            }

            //to find Unit input box is visible
            i=0;
            for(WebElement head:heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Units"))
                {
                    break;
                }
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::tr[contains(@class,'k-master-row')][1]/td["+i+"]/descendant::input");
            act1.moveToElement(WebEle).click().build().perform();
            act1.sendKeys(Keys.CONTROL + "a");
            act1.sendKeys(Keys.DELETE);
            act1.sendKeys(WebEle, qty.get(0).get(1)).build().perform();
            act1.sendKeys(Keys.TAB).build().perform();
            scenario.log("CASE ENTERED IN CATALOG " + qty.get(0).get(1));
            Thread.sleep(1000);
            //Check for popups
            for (int a = 0; a <= 2; a++)
            {
                //Check for "Quantity exceeds maximum of 10 , do you want to continue ?" Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    // to fetch the web element of the modal container
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    //click on Yes button
                    WebElement yesButton = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                    HelpersMethod.ActClick(driver, yesButton, 10000);
                }

                //"Product is currently unavailable" popup
                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                    WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver, okButton, 20000);
                }
            }
        }
        catch (Exception e){}
    }
}
