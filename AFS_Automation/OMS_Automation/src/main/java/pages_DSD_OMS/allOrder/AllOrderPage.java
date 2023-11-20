package pages_DSD_OMS.allOrder;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import lombok.experimental.Helper;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
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

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class AllOrderPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static String OrderNo = null;
    static boolean exists = false;
    static String Product=null;
    static String groupQtyValue=null;
    static String groupTotalValue=null;
    static int Qtysum1=0;
    static String QtySum=null;
    static String TotalSum=null;

    @FindBy(id = "showAllOrdersCheckbox")
    private WebElement AllOrderCheckbox;

    @FindBy(id = "showQuotes")
    private WebElement ShowQuotes;

    @FindBy(xpath = "//button[@data-test-id='startOrderBtn']")
    private WebElement StartOrder;

    @FindBy(id = "copyOrderBtn")
    private WebElement CopyOrder;

    @FindBy(id = "printOrderBtn")
    private WebElement PrintBut;

    @FindBy(id = "searchButton")
    private WebElement SearchBut;

    @FindBy(id = "resetButton")
    private WebElement ResetBut;

    @FindBy(id="Submitted")
    private WebElement SubmitedDropdown;

    @FindBy(id = "OrderStatus")
    private WebElement OrderStatus;

    @FindBy(xpath = "//label[@id='FromDeliveryDate-label']/following-sibling::span[contains(@class,'k-datepicker')]/descendant::span[contains(@class,'k-icon k-i-calendar')]")
    private WebElement StartCal;

    @FindBy(xpath = "//label[@id='ToDeliveryDate-label']/following-sibling::span[contains(@class,'k-datepicker')]/descendant::span[contains(@class,'k-icon k-i-calendar')]")
    private WebElement EndCal;

    @FindBy(xpath = "//div[@id='AccountNumber']//*[local-name()='svg' and contains(@class,'i-icon   ')]")
    private WebElement AccountIndex;

    @FindBy(id = "CustomerNumberDisplay")
    private WebElement AccountInput;

    @FindBy(id = "OrderNumber")
    private WebElement OrdNoInput;

    @FindBy(id = "ProductNumber")
    private WebElement ProdNoInput;

    @FindBy(xpath = "//span[contains(text(),'Add filter')]")
    private WebElement AddFilter;

    @FindBy(id="copyOrderBtn")
    private WebElement CopyButton;

    @FindBy(id="printOrderBtn")
    private WebElement PrintButton;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]")
    private WebElement To;

    @FindBy(xpath="//td[@class='main-footer-cell'][1]/descendant::span[text()='Σ']/ancestor::span[contains(@class,'k-widget k-dropdown')]")
    private WebElement QtyGroup;

    @FindBy(xpath="//td[@class='main-footer-cell'][2]/descendant::span[text()='Σ']/ancestor::span[contains(@class,'k-widget k-dropdown')]")
    private WebElement TotalGroup;

    //Constructor for Catalog page, Initializing the Page Objects:
    public AllOrderPage(WebDriver driver, Scenario scenario)
    {
        this.scenario = scenario;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ValidateAllOrder()
    {
        exists = false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(150))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String title = HelpersMethod.gettingTitle(driver);
            if (title.contains("All Orders"))
            {
                scenario.log("NAVIGATED TO ALL ORDERS");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public String ReadingOrderNo()
    {
        OrderNo=null;
        try
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[@class='k-master-row'][2]/descendant::button");
            if (HelpersMethod.IsExists("//tr[@class='k-master-row'][2]/descendant::button", driver))
            {
                OrderNo = WebEle.getText();
                scenario.log("ORDER CREATED IS: "+OrderNo);
            }
            else
            {
                scenario.log("ORDER DOESN'T EXISTS UNDER ALL ORDER");
            }
        }
        catch (Exception e) {}
        return OrderNo;
    }

    public String ReturnOrderNoRead()
    {
        return OrderNo;
    }

    public void ClickShowAllOrderCheckbox()
    {
        WebElement WebEle = null;
        String status=null;
        exists = false;
        try
        {
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                exists = HelpersMethod.waitTillLoadingPage(driver);
            }
            else
            {
                if (HelpersMethod.IsExists("//div[@class='allOrdersCheckbox']",driver))
                {
                    exists = false;
                    HelpersMethod.ScrollElement(driver, AllOrderCheckbox);
                    HelpersMethod.ActClick(driver, AllOrderCheckbox, 10000);
                    scenario.log("SHOW ALL ORDER CHECK BOX HAS BEEN CLICKED");
                    status=HelpersMethod.returnDocumentStatus(driver);
                    if(status.equals("loading"))
                    {
                        exists = HelpersMethod.waitTillLoadingPage(driver);
                    }
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(60))
                            .pollingEvery(Duration.ofSeconds(5))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    exists = true;
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ClickShowAllOrderCheckboxAgain()
    {
        WebElement WebEle = null;
        String status=null;
        exists = false;
        try
        {
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                exists = HelpersMethod.waitTillLoadingPage(driver);
            }
            else
            {
                if (HelpersMethod.IsExists("//div[@class='allOrdersCheckbox']",driver))
                {
                    exists = false;
                    HelpersMethod.ScrollElement(driver, AllOrderCheckbox);
                    HelpersMethod.ActClick(driver, AllOrderCheckbox, 10000);
                    scenario.log("SHOW ALL ORDER CHECK BOX HAS BEEN CLICKED");
                    status=HelpersMethod.returnDocumentStatus(driver);
                    if(status.equals("loading"))
                    {
                        exists = HelpersMethod.waitTillLoadingPage(driver);
                    }

                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(150))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    exists = true;
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void AddFilterClick()
    {
        exists = false;
        WebElement WebEle=null;
        try
        {
            OrderNo=ReadingOrderNo();
            HelpersMethod.ScrollElement(driver, AddFilter);
            ///////////////////////HelpersMethod.AddFilterSearch(driver, "Order Number", OrderNo);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            String status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Click on Add filter button
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
            driver.findElement(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")).click();

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",100000);
            WebElement modalContainer1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");

            //Click on Clear all button
            WebElement Clear=modalContainer1.findElement(By.xpath(".//button[contains(text(),'Clear all')]"));
            if(Clear.isEnabled())
            {
                Clear.click();
            }

            WebElement Search1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.ActSendKey(driver,Search1,1000,"Order Number");
            //Click on Check box
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[contains(@class,'k-checkbox')]")));
            WebElement WebEle1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
            HelpersMethod.ClickBut(driver,WebEle1,1000);

            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            Thread.sleep(2000);
            if(HelpersMethod.IsExists("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]",driver))
            {
                    WebElement RadioPop=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
                    WebElement Search2=RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                    HelpersMethod.EnterText(driver,Search2,10000,OrderNo);

                    //Click on Apply button
                    WebElement applyButton = Search2.findElement(By.xpath(".//button[text()='Apply']"));
                    HelpersMethod.ClickBut(driver,applyButton,1000);
                    //loading Icon
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle =HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                }

            scenario.log("SEARCHING FOR ORDER NUMBER "+OrderNo);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }

            if (HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]", driver))
            {
                scenario.log("ORDER HAS NOT BEEN FOUND");
                exists=false;
            }
            else
            {
                scenario.log("ORDER HAS BEEN FOUND " + OrderNo);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void AddFilterClick(String oNo)
    {
        exists = false;
        WebElement WebEle=null;
        try
        {
            OrderNo=ReadingOrderNo();
            HelpersMethod.ScrollElement(driver, AddFilter);
            ///////////////////////HelpersMethod.AddFilterSearch(driver, "Order Number", OrderNo);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            String status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Click on Add filter button
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
            driver.findElement(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")).click();

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",100000);
            WebElement modalContainer1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");

            //Click on Clear all button
            WebElement Clear=modalContainer1.findElement(By.xpath(".//button[contains(text(),'Clear all')]"));
            if(Clear.isEnabled())
            {
                Clear.click();
            }

            WebElement Search1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.ActSendKey(driver,Search1,1000,"Order Number");
            //Click on Check box
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[contains(@class,'k-checkbox')]")));
            WebElement WebEle1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
            HelpersMethod.ClickBut(driver,WebEle1,1000);

            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            Thread.sleep(2000);
            if(HelpersMethod.IsExists("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]",driver))
            {
                WebElement RadioPop=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
                WebElement Search2=RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                HelpersMethod.EnterText(driver,Search2,10000,oNo);

                //Click on Apply button
                WebElement applyButton = Search2.findElement(By.xpath(".//button[text()='Apply']"));
                HelpersMethod.ClickBut(driver,applyButton,1000);
                //loading Icon
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle =HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }

            scenario.log("SEARCHING FOR ORDER NUMBER "+OrderNo);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }

            if (HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]", driver))
            {
                scenario.log("ORDER HAS NOT BEEN FOUND");
                exists=false;
            }
            else
            {
                scenario.log("ORDER HAS BEEN FOUND " + OrderNo);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ClickOnStartOrder() throws InterruptedException
    {
        exists = false;
        String status = null;
        WebElement WebEle = null;
        try
        {
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            WebEle = HelpersMethod.FindByElement(driver, "id", "openOrdersCard");
            HelpersMethod.ScrollElement(driver, WebEle);
            new WebDriverWait(driver,Duration.ofMillis( 20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("openOrdersCard"))));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            WebElement starOrderBut = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(text(),'Start order')]");
            //Click on Start Order button
            HelpersMethod.JScriptClick(driver,starOrderBut,1000);

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"))));
            // to fetch the web element of the modal container
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"));

            WebElement optionToClick = menuContainer.findElement(By.xpath(".//ul/li[contains(text(),'Add')]"));
            // click the option
            HelpersMethod.ActClick(driver, optionToClick, 1000);

            exists = true;
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //validate Customer index popup
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 20000);
            new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ValidateCustomerIndexPopup()
    {
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Customer account index", "Verify Title message");
    }

    public void CustomerIndexPopup() throws InterruptedException
    {
        exists = false;
        WebElement WebEle;
        WebElement Search2;
        String AccNo = TestBase.testEnvironment.get_Account();
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        //new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        // code to click on Addfilter button
        WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
        HelpersMethod.ActClick(driver, AddFilterButton, 10000);

        //Identify the dialog popup
        new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"))));
        WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");

        //Validate child popup
        WebElement childTitle = modalContainer1.findElement(By.xpath(".//div[contains(@class,'i-filter-popup__checkboxes')]/h1"));
        Assert.assertEquals(childTitle.getText(), "Basic", "Verify Title message");

        //Enter customer account# in input box
        WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
        HelpersMethod.EnterText(driver, Search1, 80000, "Customer #");

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Click on Check box
        HelpersMethod.WaitElementPresent(driver, "xpath", "//input[contains(@id,'FORMATTED_CM_CUSTKEY')]", 80000);
        new WebDriverWait(driver, Duration.ofMillis(200000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'FORMATTED_CM_CUSTKEY')]")));
        WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[contains(@id,'FORMATTED_CM_CUSTKEY')]"));
        HelpersMethod.JScriptClick(driver, WebEle1, 80000);
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]"))));

        WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
        WebElement radioButton = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (radioButton.isDisplayed())
        {
            Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            HelpersMethod.EnterText(driver, Search2, 20000, AccNo);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Click on Apply button
            WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button[text()='Apply']"));
            new WebDriverWait(driver,Duration.ofMillis(200000)).until(ExpectedConditions.elementToBeClickable(ApplyButton));
            HelpersMethod.ClickBut(driver, ApplyButton, 20000);
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        }

        if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']", driver))
        {
            scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
        }
        else
        {
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver,Duration.ofMillis(60000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"))));
            WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
            HelpersMethod.ScrollElement(driver, WebEle);
            WebElement accountNo=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]/td[3]"));
            scenario.log("ACCOUNT NUMBER SELECTED IS "+accountNo.getText());
            HelpersMethod.ActClick(driver, WebEle, 1000);
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            exists = true;
            String Acc = TestBase.testEnvironment.get_Account();
            scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
            Thread.sleep(10000);
        }
    }

    public void SelectDeliveryDate()
    {
        try
        {
            int i=0;
            WebElement Wheel=null;
            String status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                Wheel=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 2000000);
            }
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Thread.sleep(2000);
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            //Select date from calender
            if(HelpersMethod.IsExists(".//td[contains(@style,'opacity: 1') and contains(@class,'k-state-focused')] | .//td[contains(@style,'opacity: 1') and contains(@class,'k-state-selected')]",driver))
            {
                WebElement Date1 = modalContainer.findElement(By.xpath(".//td[contains(@style,'opacity: 1') and contains(@class,'k-state-focused')] | .//td[contains(@style,'opacity: 1') and contains(@class,'k-state-selected')]"));
                WebElement selectDate=modalContainer.findElement(By.xpath(".//td[contains(@style,'opacity: 1') and contains(@class,'k-state-focused')]/span | .//td[contains(@style,'opacity: 1') and contains(@class,'k-state-selected')]/span"));
                scenario.log("SELECTED DATE IS "+selectDate.getText());
                HelpersMethod.ActClick(driver,Date1,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    Wheel=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 2000000);
                }
                scenario.log("DEFAULT DELIVERY DATE HAS BEEN SLECTED");
            }
            else
            {
                List<WebElement> Dates = modalContainer.findElements(By.xpath(".//td[contains(@style,'opacity: 1')]"));
                if(Dates!=null)
                {
                    for (WebElement WebEle1 : Dates)
                    {
                        WebElement selectDate=modalContainer.findElement(By.xpath(".//td[contains(@style,'opacity: 1')]/span"));
                        scenario.log("SELECTED DELIVERY DATE "+selectDate.getText());
                        HelpersMethod.ActClick(driver,WebEle1,200);
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            Wheel=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 2000000);
                        }
                    }
                }
                else if(Dates==null)
                {
                    WebElement Arrow=modalContainer.findElement(By.xpath(".//span[@class='k-icon k-i-arrow-chevron-right']"));
                    HelpersMethod.ClickBut(driver, Arrow, 2000);
                    Dates = modalContainer.findElements(By.xpath(".//td[contains(@style,'opacity')]"));
                    WebElement Date = modalContainer.findElement(By.xpath(".//td[contains(@style,'opacity: 1')]"));

                    for (WebElement WebEle1 : Dates)
                    {
                        if (WebEle1.equals(Date))
                        {
                            WebElement selectDate=modalContainer.findElement(By.xpath(".//td[contains(@style,'opacity: 1')]/span"));
                            scenario.log("SELECTED DATE IS "+selectDate.getText());
                            HelpersMethod.ActClick(driver, Date, 2000);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                Wheel=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 2000000);
                            }
                            break;
                        }
                    }
                }
                scenario.log("DELIVERY DATE HAS BEEN SELECTED");
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",1000);
                // to fetch the web element of the modal container
                WebElement modalContainer1 = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle1 = modalContainer1.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle1.getText(), "Warning", "Verify Title message");
                //Click on OK button
                WebElement okButton=modalContainer1.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,1000);
            }
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        }
        catch (Exception e) {}
    }

    public void selectDeliveryDateForPickupOrder()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                String pickDate=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::span[2]").getText();
                scenario.log("DATE SELECTED PICKUP ORDER "+pickDate);
                WebElement dateSelect=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver,dateSelect,1000);
                Thread.sleep(4000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectDeliveryDateForEdit()
    {
        try
        {
            WebElement WebEle=null;
            WebElement Wheel=null;
            String formattedDate1=null;

            LocalDate myDateObj = LocalDate.now().plusDays(1);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            String formattedDate = myDateObj.format(myFormatObj);
            String status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                Wheel=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 2000000);
            }

            if(!HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; cursor: pointer; background-color: rgb')]/span[contains(@title,'" + formattedDate +"')]",driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 10000);
                // to fetch the web element of the modal container
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them,code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Select delivery date", "Verifing calender title");
                LocalDate myDateObj1 = LocalDate.now().plusDays(2);
                DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj1.format(myFormatObj1);
                WebElement ele1 = modalContainer.findElement(By.xpath(".//td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + formattedDate1 + "')]"));
                HelpersMethod.waitTillElementDisplayed(driver, ele1, 100000);
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ActClick(driver, ele1, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
            }
            else
            {
                //if Date is enabled date is increased by 'some' days already, just click on the date
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",80000);
                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]");
                new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//descendant::td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + formattedDate +"')]")));
                WebElement dateValue=modalContainer.findElement(By.xpath(".//descendant::td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + formattedDate +"')]"));
                HelpersMethod.ActClick(driver, dateValue, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",1000);
                // to fetch the web element of the modal container
                WebElement modalContainer1 = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle1 = modalContainer1.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle1.getText(), "Warning", "Verify Title message");
                //Click on OK button
                WebElement okButton=modalContainer1.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,1000);
            }
        }
        catch (Exception e) {}
    }

    public void SearchNewlyCreatedOrder(String Ord_No)
    {
        WebElement WebEle=null;
        String status=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            exists = HelpersMethod.waitTillLoadingPage(driver);
        }
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add filter')]")));
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add filter')]")));

        exists = false;
        try
        {
            //HelpersMethod.AddFilterSearch(driver, "Order Number", Ord_No);
            HelpersMethod.ScrollElement(driver, AddFilter);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Click on Add filter button
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
            driver.findElement(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")).click();

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",80000);
            WebElement modalContainer1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");

            //Click on Clear all button
            WebElement Clear=modalContainer1.findElement(By.xpath(".//button[contains(text(),'Clear all')]"));
            if(Clear.isEnabled())
            {
                Clear.click();
            }

            WebElement Search1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.ActSendKey(driver,Search1,6000,"Order Number");
            //Click on Check box
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[contains(@class,'k-checkbox')]")));
            WebElement WebEle1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
            HelpersMethod.ClickBut(driver,WebEle1,1000);

            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            Thread.sleep(2000);
            if(HelpersMethod.IsExists("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]",driver))
            {
                WebElement RadioPop=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
                WebElement Search2=RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                HelpersMethod.EnterText(driver,Search2,10000,Ord_No);

                //Click on Apply button
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Apply']"))));
                WebElement applyButton = HelpersMethod.FindByElement(driver,"xpath","//button[text()='Apply']");
                HelpersMethod.ActClick(driver,applyButton,40000);

                status=HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                //loading Icon
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
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            }

            if (HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]", driver))
            {
                exists=false;
            }
            else
            {
                scenario.log("ORDER HAS BEEN FOUND " + Ord_No);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnShowQuotes()
    {
        WebElement WebEle = null;
        String status=null;
        exists = false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='allOrdersCheckbox']"),"Show all orders"));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='allOrdersCheckbox']")));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='allOrdersCheckbox']")));
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                exists = HelpersMethod.waitTillLoadingPage(driver);
            }
            else
            {
                if(ShowQuotes.isDisplayed())
                {
                    HelpersMethod.ActClick(driver,ShowQuotes,1000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                    exists = true;
                    scenario.log("SHOW ORDER FROM QUOTES CHECK BOX HAS BEEN SELECTED");
                }
                else if(!ShowQuotes.isDisplayed())
                {
                    scenario.log("SHOW QOUTES CHECK BOX NOT DISPLAYED, IT IS SUPPORTED ONLY IN DSD ENV");
                    exists=true;
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) { }
    }

    public void DisplayOrderNumbers()
    {
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            List<WebElement> Orders=HelpersMethod.FindByElements(driver,"xpath","//button[contains(@class,'i-link-button ')]");
            if(Orders.isEmpty())
            {
                scenario.log("THERE ARE NO ORDER NUMBERS TO DISPLAY");
            }
            else
            {
                scenario.log("ORDERS FOUND UNDER SHOW ALL ORDER");
                for (WebElement Order : Orders)
                {
                    String Order_No = Order.getText();
                    scenario.log("Order# "+Order_No);
                }
            }
        }
        catch (Exception e) {}
    }

    public void WarningChangeDeliveryDate()
    {
        try
        {
            for(int i=0;i<=1;i++)
            {
                //Handling Change delivery date Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement ChangeDD=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Change delivery date']");
                    HelpersMethod.ClickBut(driver,ChangeDD,1000);
                }
                //Handling Warning Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Warning')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement WarningDD=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WarningDD,1000);
                }
            }
        }
        catch (Exception e) {}
    }

    public void validateSelectOrder() throws InterruptedException
    {
        exists=false;
        WebElement WebEle;

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        Thread.sleep(1000);
        if(HelpersMethod.IsExists("//div[contains(@class,'modal-sm modal-dialog')]/descendant::h4[contains(text(),'Select order')]",driver))
        {
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'modal-sm modal-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'modal-header')]/descendant::h4"));
            Assert.assertEquals(modalContentTitle.getText(), "Select order", "Verifing calender title");
        }
    }

    public void SelectOrder() throws InterruptedException
    {
        exists=false;
        WebElement WebEle;

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[contains(@class,'modal-sm modal-dialog')]/descendant::h4[contains(text(),'Select order')]",driver))
        {
          // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'modal-sm modal-dialog')]"));

           //Click on New order
            WebEle = modalContainer.findElement(By.xpath(".//button[contains(text(),'New order')]"));
            scenario.log("SELECTED ORDER IS "+WebEle.getText());
            HelpersMethod.ActClick(driver, WebEle, 1000);
            exists = true;
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
            Thread.sleep(1000);
            Assert.assertEquals(exists, true);
        }
    }

    public void ValidateCommentIcon()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[contains(@style,'cursor: pointer;')]");
            if(HelpersMethod.EleDisplay(WebEle))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) { }
    }

    public void ClickOnOrderInAllOrderGrid()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            String status;
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]/descendant::button[contains(@class,'i-link-button ')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::button[contains(@class,'i-link-button ')]");
                HelpersMethod.ActClick(driver, WebEle, 1000);
                Thread.sleep(4000);

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(150))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                exists = true;
                scenario.log("ORDER HAS BEEN SELECTED");
            }
            else
            {
                scenario.log("NO ORDER HAS BEEN FOUND");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void NavigateToOrderSummaryPage()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='spnmoduleNameHeader']");
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.textToBePresentInElement(WebEle, "Checkout summary"));

            //verifying whether user naviagated to OE summary page or not
            if (HelpersMethod.waitTillTitleContains(driver, "Order Entry", 2000000))
            {
                exists = true;
            }
            scenario.log("NAVIGATED TO ORDER SUMMARY PAGE");
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ClickOnBackToOrder()
    {
        exists = false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            WebElement WebEle = HelpersMethod.FindByElement(driver, "id", "OrdersButton");
            HelpersMethod.JScriptClick(driver, WebEle, 1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void SelectOrderForCopying()
    {
        exists=false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]");
            HelpersMethod.ActClick(driver,WebEle,1000);
            exists=true;
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ClickOnCopyButton()
    {
        new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.textToBePresentInElementLocated(By.id("copyOrderBtn"),"Copy"));
        exists=false;
        WebElement WebEle=null;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(CopyButton.isDisplayed() && CopyButton.isEnabled())
        {
            HelpersMethod.ScrollElement(driver,CopyButton);
            HelpersMethod.ClickBut(driver,CopyButton,1000);
            scenario.log("COPYING OF ALL ORDER HAS BEEN DONE");
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
            exists=true;
        }
        Assert.assertEquals(exists,true);
    }

    public void validateSelectDeliveryDateForCopy()
    {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Select delivery date", "Verify Title message");

    }

    public void SelectDeliverDateForCopy() throws InterruptedException
    {
        exists=false;
        WebElement WebEle;
        String status=null;
        try
        {
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
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            //Click on first date in the popup
            WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
            WebElement WebEle1=modalContainer.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/descendant::span[2]"));
            scenario.log("DATE SELECTED FOR COPY IS "+WebEle1.getText());
            HelpersMethod.ActClick(driver, WebEle, 6000);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            exists = true;
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
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void SubmittedStatusDropDown()
    {
        exists=false;
        WebElement WebEle;
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOf(SubmitedDropdown));
        try
        {
            if(SubmitedDropdown.isDisplayed())
            {
                WebEle=HelpersMethod.FindByElement(driver,"id","openOrdersSearchCard");
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, SubmitedDropdown, 1000);
                exists = true;
            }
            else
            {
                scenario.log("STATUS DROP DOWN IS NOT DISPLAYED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void SubmitOptionFromDropDown()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]",40);
            // to fetch the web element of the modal container
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]"));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li[contains(text(),'Submitted')]")));
            WebElement submitOption=menuContainer.findElement(By.xpath(".//ul/li[contains(text(),'Submitted')]"));
            HelpersMethod.ClickBut(driver,submitOption,1000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void NotSubmitOptionFromDropDown()
    {
        exists=false;
        String opt=null;
        Actions act1=new Actions(driver);
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]",40);
            // to fetch the web element of the modal container
            new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li[contains(text(),'Not submitted')]")));
            List<WebElement> submitOptions=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li");
            for(WebElement sopt:submitOptions)
            {
                act1.moveToElement(sopt).build().perform();
                opt= sopt.getText();
                if(opt.equalsIgnoreCase("Not submitted"))
                {
                    act1.moveToElement(sopt).build().perform();
                    act1.click().build().perform();
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void SelectSubmitedOptionFromDropDown()
    {
        exists=false;
        String opt=null;
        Actions act1=new Actions(driver);
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]",40);
            // to fetch the web element of the modal container
            new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li[contains(text(),'Not submitted')]")));
            List<WebElement> submitOptions=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li");
            for(WebElement sopt:submitOptions)
            {
                act1.moveToElement(sopt).build().perform();
                opt= sopt.getText();
                if(opt.equalsIgnoreCase("Submitted"))
                {
                    act1.moveToElement(sopt).build().perform();
                    act1.click().build().perform();
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ClickOnSearchButton()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            if(SearchBut.isDisplayed() && SearchBut.isEnabled())
            {
                HelpersMethod.ClickBut(driver, SearchBut, 1000);
                exists=true;
                /*if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }*/
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void OrderStatusDropDown()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            if(OrderStatus.isDisplayed())
            {
                WebEle=HelpersMethod.FindByElement(driver,"id","openOrdersSearchCard");
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, OrderStatus, 2000);
                HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]",800);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void OrderOptionFromDropDown()
    {
        exists=false;
        String orderStatusText=null;
        Actions act1=new Actions(driver);
        //new WebDriverWait(driver,1000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
        //HelpersMethod.DropDownMenu(driver,"Open Order");
        try
        {
            List<WebElement> orderStatus = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-list-container')]/descendant::ul/li");
            for (WebElement oStatus : orderStatus)
            {
                act1.moveToElement(oStatus).build().perform();
                orderStatusText=oStatus.getText();
                if(orderStatusText.equalsIgnoreCase("Open Order")||orderStatusText.contains("Open Order"))
                {
                  act1.moveToElement(oStatus).build().perform();
                  act1.click(oStatus).build().perform();
                  exists=true;
                  break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchProductInOrder()
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver,ProdNoInput);
            Product= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());

            HelpersMethod.ActSendKey(driver,ProdNoInput,1000,Product);

            exists=true;
            scenario.log("PRODUCT# ENTERED FOR SEARCH IS "+Product);
        }
        catch (Exception e){}
    }

    public void PrintAllOrder()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            String ParentWindow=driver.getWindowHandle();
            HelpersMethod.ScrollElement(driver,PrintBut);
            HelpersMethod.ClickBut(driver,PrintBut,1000);
            scenario.log("PRINT BUTTON IN ALL ORDER HAS BEEN CLICKED");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            Set<String> PCWindows=driver.getWindowHandles();
            for(String PCwind:PCWindows)
            {
                if(!PCwind.equals(ParentWindow))
                {
                    Thread.sleep(40000);
                    driver.switchTo().window(PCwind);
                    scenario.log(".pdf HAS BEEN FOUND");
                    driver.close();
                    exists=true;
                    scenario.log("PRINT BUTTON FOR ALL ORDER HAS BEEN HANDLED");
                }
            }
            Assert.assertEquals(exists,true);
            driver.switchTo().window(ParentWindow);
        }
        catch (Exception e){}
    }

    public void SelectNewOrderInPopUp() throws InterruptedException
    {
        try
        {
            String status;
            /*String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }*/
            Thread.sleep(4000);

            if(HelpersMethod.IsExists("//h4[contains(text(),'Select order')]/ancestor::div[contains(@class,'modal-content')]",driver))
            {
                // to fetch the web element of the modal container
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'modal-sm modal-dialog')]"));

                // to fetch the web elements of the modal content and interact with them,code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//h4[contains(@class,'modal-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Select order", "Verify Title message");
                //Click on New order option
                WebElement newOrderOption = modalContainer.findElement(By.xpath(".//button[contains(text(),'New order')]"));
                HelpersMethod.ActClick(driver, newOrderOption, 4000);
                scenario.log("NEW ORDER HAS BEEN SELECTED TO CREATE COPY OF ALL ORDER");

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                //One more popup if appears
                if (HelpersMethod.IsExists("//div[contains(text(),'You already have an open order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement startOrder = modalContainer1.findElement(By.xpath(".//button[contains(text(),'Start new order')]"));
                    HelpersMethod.ClickBut(driver, startOrder, 1000);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
        }
        catch (Exception e){}
    }

    public void VerifyingProductsInOEWithOO()
    {
        exists=false;
        try
        {
            int i=0;
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-grid-header k-grid-draggable-header')]/descendant::th[contains(@class,'k-header ')]/span[@class='k-link']");
            for (WebElement Head:Heads)
            {
                i++;
                String Head_text=Head.getText();
                if(Head_text.equals("Product #"))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-grid-container']");
                    HelpersMethod.ScrollElement(driver,WebEle);
                    scenario.log("PRODUCTS FROUND IN OPEN ORDER ARE:");
                    List<WebElement>Products=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td["+i+"]/descendant::span[contains(@class,'CPKendoDataGrid')]");
                    for (WebElement Prod: Products)
                    {
                        scenario.log(Product);
                        String Prod_text=Prod.getAttribute("data-value");
                        scenario.log(Prod_text);
                        exists=true;
                    }
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ClickOnStartOrderToSelectPickupOrder() throws InterruptedException
    {
        exists=false;
        try
        {
            WebElement WebEle;
            Actions act1 = new Actions(driver);
            WebEle = HelpersMethod.FindByElement(driver, "id", "openOrdersCard");
            HelpersMethod.ScrollElement(driver, WebEle);
            //driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            WebEle = HelpersMethod.FindByElement(driver, "id", "openOrdersCard");
            HelpersMethod.ScrollElement(driver, WebEle);
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("openOrdersCard"))));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            WebElement starOrderBut = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(text(),'Start order')]");
            new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.elementToBeClickable(starOrderBut));
            //Click on Start Order button
            act1.moveToElement(starOrderBut).build().perform();
            act1.click(starOrderBut).build().perform();

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            new WebDriverWait(driver,Duration.ofMillis(60000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-popup k-list-container k-reset k-group k-child-animation-container')]")));
            // to fetch the web element of the modal container
            List<WebElement> allLists=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative')]/descendant::ul/li");
            for (WebElement pickUp:allLists)
            {
                act1.moveToElement(pickUp).build().perform();
                String pick_Text=pickUp.getText();
                if(pick_Text.equals("Pick up order"))
                {
                    act1.moveToElement(pickUp).build().perform();
                    act1.click(pickUp).build().perform();
                    exists = true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //validate Customer index popup
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",2000);
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ActiveOrderOptionFromDropDown()
    {
        exists=false;
        WebElement WebEle=null;
        Actions act1= new Actions(driver);
        try
        {
            // to fetch the web element of the modal container
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"));
            List<WebElement> OrderOptions=menuContainer.findElements (By.xpath(".//ul/li"));
            for(WebElement ordOption:OrderOptions)
            {
                act1.moveToElement(ordOption).build().perform();
                String OrderOpt=ordOption.getText();
                if(OrderOpt.equalsIgnoreCase("Active")||OrderOpt.contains("Ready for Delivery Invoice"))
                {
                    act1.moveToElement(ordOption).build().perform();
                    act1.click().build().perform();
                    break;
                }
            }
            String active=HelpersMethod.FindByElement(driver,"xpath","//span[@id='OrderStatus']/span[@class='k-input']").getText();
            if(active.equals("Active")||active.contains("Ready for Delivery Invoice"))
            {
                exists=true;
            }
            else
            {
                exists=false;
            }
        }
        catch (Exception e) { }
        Assert.assertEquals(exists,true);
    }

    public void FindtableHeader(String To_Text)
    {
        exists=false;
        try
        {
            WebElement OEProdGrid=HelpersMethod.FindByElement(driver,"id","openOrdersCard");
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

    public void ClickOnCommentIcon()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[contains(@style,'cursor: pointer;')]");
            if(HelpersMethod.EleDisplay(WebEle))
            {
                HelpersMethod.ActClick(driver,WebEle,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) { }
    }

    public void ValidateDisplayOfCommentsDialog()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Comments", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void DisplayCommentsAdded()
    {
        Actions act1=new Actions(driver);
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            List<WebElement> Comments=modalContainer.findElements(By.xpath("//tr[contains(@class,'k-master-row')]/td[2]"));
            for(WebElement Comment:Comments)
            {
                act1.moveToElement(Comment).build().perform();
                String Comm_Text=Comment.getText();
                scenario.log("COMMENT ADDED TO ALL ORDER "+Comm_Text);
            }
            WebElement OkButton=modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
            act1.click(OkButton).build().perform();
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            // new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOf(modalContainer));
        }
        catch (Exception e){}
    }

    public void Refresh_Page(String currentURL)
    {
        String status=null;
        Actions act1=new Actions(driver);

        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis( 400000));
                if (wait.until(ExpectedConditions.alertIsPresent()) == null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
            }
           /* else
            {*/
                driver.navigate().refresh();
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(150))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(100))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //navigate to Open order
                driver.navigate().to(currentURL);
                scenario.log("NAVIGATED TO "+currentURL);
            //}

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(100))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(100))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void validateSelectDeliveryDatePickupOrder()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(100))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(6000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",10000);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Select pickup date", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void validateDeliveryDatePopup()
    {
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
            //Thread.sleep(10000);
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Select delivery date", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void clickOnQtyGrouping()
    {
        exists=false;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            if(QtyGroup.isDisplayed())
            {
                HelpersMethod.ScrollDownScrollBar(driver);
                HelpersMethod.ActClick(driver,QtyGroup,20000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectValueGroupDropDown(String opt)
    {
        exists=false;
        Actions act1=new Actions(driver);
        String optText;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container k-reset i-common-dropdown ')]",driver))
            {
                List<WebElement> groups=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container k-reset i-common-dropdown ')]/descendant::ul/li");
                for(WebElement group:groups)
                {
                    act1.moveToElement(group).build().perform();
                    optText= group.getText();
                    if(optText.equals(opt))
                    {
                        act1.moveToElement(group).build().perform();
                        act1.click(group).build().perform();
                        exists=true;
                        scenario.log("OPTION SELECTED IS "+opt);
                        break;
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void compareSelectedOpt(String opt)
    {
        exists=false;
        try
        {
            String groupOpt=HelpersMethod.FindByElement(driver,"xpath","//td[@class='main-footer-cell'][1]/descendant::span[@class='k-input']").getText();
            if(groupOpt.equals(opt))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void displayQtyGroupValue()
    {
        exists=false;
        try
        {
            groupQtyValue=HelpersMethod.FindByElement(driver,"xpath","//td[@class='main-footer-cell'][1]/descendant::div[@class='footer-value']").getText();
            if(groupQtyValue.equals(""))
            {
                scenario.log("VALUE DISPLAYED IN FOOTER FOR QTY"+groupQtyValue);
            }
        }
        catch (Exception e){}
    }

    public void displayTotalGroupValue()
    {
        exists=false;
        try
        {
            groupTotalValue=HelpersMethod.FindByElement(driver,"xpath","//td[@class='main-footer-cell'][1]/descendant::div[@class='footer-value']").getText();
            if(groupTotalValue.equals(""))
            {
                scenario.log("VALUE DISPLAYED IN FOOTER FOR TOTAL"+groupTotalValue);
            }
        }
        catch (Exception e){}
    }

    public void clickOnUnitGrouping()
    {
        exists=false;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            if(TotalGroup.isDisplayed())
            {
                HelpersMethod.ScrollDownScrollBar(driver);
                HelpersMethod.ActClick(driver,TotalGroup,2000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void findSumOfTotal()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String headValue;
        String sumValueTotal;
        int Totalsum = 0;
        int i=0;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                headValue=head.getText();
                if(headValue.equals("Total"))
                {
                    break;
                }
            }
            List<WebElement> elementsTotalSum=HelpersMethod.FindByElements(driver,"xpath","//td["+i+"]");
            for(WebElement eleTotalSum:elementsTotalSum)
            {
                act1.moveToElement(eleTotalSum).build().perform();
                sumValueTotal=eleTotalSum.getText();
                Totalsum=Totalsum+Integer.parseInt(sumValueTotal);
            }
            if(Totalsum==Integer.parseInt(groupTotalValue))
            {
                scenario.log("SUM FOUND FOR TOTAL COLUMN IS "+Totalsum);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void findSumOfQty()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String headValue;
        String sumValueTotal;
        int i=0;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                headValue=head.getText();
                if(headValue.equals("Quantity"))
                {
                    break;
                }
            }
            List<WebElement> elementsQtySum=HelpersMethod.FindByElements(driver,"xpath","//td["+i+"]");
            for(int j=0;j<=elementsQtySum.size()-1;j++)
            {
                act1.moveToElement(elementsQtySum.get(j)).build().perform();
                sumValueTotal= elementsQtySum.get(j).getText();
                Qtysum1=Qtysum1+Integer.parseInt(sumValueTotal);
                scenario.log(Qtysum1 +" SUM OF TOTAL COLUMN ");
                System.out.println(Qtysum1 +" SUM OF TOTAL COLUMN");
            }
            System.out.println(Qtysum1 +" SUM OF TOTAL COLUMN");
            int sumQty=Integer.parseInt(groupQtyValue);
            if(Qtysum1==sumQty)
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void findAvgOfTotal()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String headValue;
        String sumValueTotal;
        int Totalsum = 0;
        int i=0;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                headValue=head.getText();
                if(headValue.equals("Total"))
                {
                    break;
                }
            }
            List<WebElement> elementsTotalSum=HelpersMethod.FindByElements(driver,"xpath","//td["+i+"]");
            for(WebElement eleTotalSum:elementsTotalSum)
            {
                act1.moveToElement(eleTotalSum).build().perform();
                sumValueTotal=eleTotalSum.getText();
                Totalsum=Totalsum+Integer.parseInt(sumValueTotal);
            }
            if(Totalsum==Integer.parseInt(groupTotalValue))
            {
                scenario.log("AVERAGE FOUND FOR TOTAL COLUMN IS "+Totalsum);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void findAvgOfQty()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String headValue;
        String sumValueTotal;
        int Qtysum = 0;
        int i=0;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                headValue=head.getText();
                if(headValue.equals("Quantity"))
                {
                    break;
                }
            }
            List<WebElement> elementsQtySum=HelpersMethod.FindByElements(driver,"xpath","//td["+i+"]");
            for(WebElement eleQtySum:elementsQtySum)
            {
                act1.moveToElement(eleQtySum).build().perform();
                sumValueTotal=eleQtySum.getText();
                Qtysum=Qtysum+Integer.parseInt(sumValueTotal);
            }
            if(Qtysum==Integer.parseInt(groupQtyValue))
            {
                scenario.log("AVERAGE FOUND FOR QTY COLUMN IS "+Qtysum);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void dragAndDrop(String header)
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]",driver))
            {
                List<WebElement> TableHeads=driver.findElements(By.xpath("//thead/tr[1]/th"));
                for(WebElement THead:TableHeads)
                {
                    String Head=THead.getText();
                    if(Head.contains(header))
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

    public void displayGroupingValue()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String groupText;
        try
        {
            List<WebElement> groupValues=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-grouping-row']/descendant::span");
            if(!groupValues.isEmpty())
            {
                scenario.log("GROUPING HAS BEEN DONE AND VALUES FOUND ARE");
                for(WebElement groupVal:groupValues)
                {
                    act1.moveToElement(groupVal).build().perform();
                    groupText=groupVal.getText();
                    scenario.log(groupText);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String readNotSubmitedOrder()
    {
        exists=false;
        String orderNo=null;
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
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            orderNo=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::td/button").getText();
        }
        catch (Exception e){}
        return orderNo;
    }
}