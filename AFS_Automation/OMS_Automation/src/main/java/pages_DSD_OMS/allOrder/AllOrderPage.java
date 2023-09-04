package pages_DSD_OMS.allOrder;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import lombok.experimental.Helper;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    String OrderNo = null;
    static boolean exists = false;
    static String XPath=null;
    static String Product=null;

    @FindBy(id = "showAllOrdersCheckbox")
    private WebElement AllOrderCheckbox;

    @FindBy(id = "showQuotes")
    private WebElement ShowQuotes;

    @FindBy(xpath = "//button[contains(text(),'Start order')]")
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.titleIs("Ignition - All Orders"));
            String title = HelpersMethod.gettingTitle(driver);
            if (title.equals("Ignition - All Orders"))
            {
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
            //HelpersMethod.Implicitwait(driver,15);
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
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='allOrdersCheckbox']")));
        new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='allOrdersCheckbox']"),"Show all orders"));
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
                    new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(AllOrderCheckbox));
                    new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(AllOrderCheckbox));
                    HelpersMethod.ScrollElement(driver, AllOrderCheckbox);
                    HelpersMethod.ActClick(driver, AllOrderCheckbox, 10);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }
                    exists = true;
                }
            }
            Assert.assertEquals(exists, true);
           // HelpersMethod.Implicitwait(driver,40);
        }
        catch (Exception e) {}
    }

    public void AddFilterClick()
    {

        exists = false;
        try
        {
            OrderNo=ReadingOrderNo();
            HelpersMethod.ScrollElement(driver, AddFilter);
            HelpersMethod.AddFilterSearch(driver, "Order Number", OrderNo);

            if (HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]", driver))
            {
                scenario.log("NO ORDER HAS Not BEEN FOUND");
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
        Actions act1 = new Actions(driver);

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        WebEle = HelpersMethod.FindByElement(driver, "id", "openOrdersCard");
        HelpersMethod.ScrollElement(driver, WebEle);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //HelpersMethod.WaitElementPresent(driver, "id", "openOrdersCard", 150);
        //HelpersMethod.waitTillElementLocatedDisplayed(driver, "id", "openOrdersCard", 1500);
        //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        WebElement starOrderBut = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(text(),'Start order')]");
        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(starOrderBut));
        //Click on Start Order button
        act1.moveToElement(starOrderBut).build().perform();
        act1.click(starOrderBut).build().perform();

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-child-animation-container')]")));
        new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]")));
        // to fetch the web element of the modal container
        WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]"));
        //new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath(".//ul/li[@role='menuItem' and contains(text(),'Add')]")));
        List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
        for(int i=0;i<=Options.size()-1;i++)
        {
            WebEle=Options.get(i);
            act1.moveToElement(WebEle).build().perform();
            String Opt=WebEle.getText();
            if(Opt.equals("Add"))
            {
                act1.moveToElement(WebEle).build().perform();
                act1.click(WebEle).build().perform();
                break;
            }
        }
            exists = true;
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

        //validate Customer index popup
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",2000);
            new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
            Assert.assertEquals(exists, true);
    }

    public void ValidateCustomerIndexPopup()
    {
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",600);
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",600);
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

        new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        // code to click on Addfilter button
        WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
        HelpersMethod. ActClick(driver, AddFilterButton, 1000);

        //Identify the dialog popup
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",4000);
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",1000);
        WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]");

        //Validate child popup
        WebElement childTitle = modalContainer1.findElement(By.xpath(".//div[contains(@class,'i-filter-popup__checkboxes')]/h1"));
        Assert.assertEquals(childTitle.getText(), "Basic", "Verify Title message");

        //Enter customer account# in input box
        WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
        HelpersMethod.EnterText(driver, Search1, 800, "Customer #");

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Click on Check box
        HelpersMethod.WaitElementPresent(driver,"xpath","//input[@id='CM_CUSTKEY']",400);
        new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='CM_CUSTKEY']")));
        WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[@id='CM_CUSTKEY']"));
        HelpersMethod.JScriptClick(driver, WebEle1, 400);
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Identify radio button and click on Radio button
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]",400);
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 200);
        WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
        WebElement radioButton = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
        if (radioButton.isDisplayed())
        {
            Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            HelpersMethod.EnterText(driver, Search2, 200, AccNo);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Click on Apply button
            WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button[text()='Apply']"));
            new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(ApplyButton));
            HelpersMethod.ClickBut(driver, ApplyButton, 40);
        }

        if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']", driver))
        {
            scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
        }
        else
        {
            WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ActClick(driver, WebEle, 40);

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            exists = true;
            String Acc = TestBase.testEnvironment.get_Account();
            scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 100);
            }

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",40);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Select delivery date", "Verifing calender title");
            //Select date from calender
            if(HelpersMethod.IsExists(".//td[contains(@style,'opacity: 1') and contains(@class,'k-state-focused')] | .//td[contains(@style,'opacity: 1') and contains(@class,'k-state-selected')]",driver))
            {
                WebElement Date1 = modalContainer.findElement(By.xpath(".//td[contains(@style,'opacity: 1') and contains(@class,'k-state-focused')] | .//td[contains(@style,'opacity: 1') and contains(@class,'k-state-selected')]"));
                HelpersMethod.ActClick(driver,Date1,20);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    Wheel=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 400);
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
                        HelpersMethod.ActClick(driver,WebEle1,10);
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            Wheel=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 100);
                        }
                    }
                }
                else if(Dates==null)
                {
                    WebElement Arrow=modalContainer.findElement(By.xpath(".//span[@class='k-icon k-i-arrow-chevron-right']"));
                    HelpersMethod.ClickBut(driver, Arrow, 20);
                    Dates = modalContainer.findElements(By.xpath(".//td[contains(@style,'opacity')]"));
                    WebElement Date = modalContainer.findElement(By.xpath(".//td[contains(@style,'opacity: 1')]"));

                    for (WebElement WebEle1 : Dates)
                    {
                        if (WebEle1.equals(Date))
                        {
                            HelpersMethod.ActClick(driver, Date, 10);
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                Wheel=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 100);
                            }
                            break;
                        }
                    }
                }
                scenario.log("DELIVERY DATE HAS BEEN SELECTED");
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
                // to fetch the web element of the modal container
                WebElement modalContainer1 = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle1 = modalContainer1.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle1.getText(), "Warning", "Verify Title message");
                //Click on OK button
                WebElement okButton=modalContainer1.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,20);
            }
        }
        catch (Exception e) {}
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
            //HelpersMethod.Implicitwait(driver,20);
            String status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                Wheel=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, Wheel, 100);
            }

            if(!HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; cursor: pointer; background-color: rgb')]/span[contains(@title,'" + formattedDate +"')]",driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 30);
                // to fetch the web element of the modal container
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them,code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Select delivery date", "Verifing calender title");
                LocalDate myDateObj1 = LocalDate.now().plusDays(2);
                DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj1.format(myFormatObj1);
                WebElement ele1 = modalContainer.findElement(By.xpath(".//td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + formattedDate1 + "')]"));
                HelpersMethod.waitTillElementDisplayed(driver, ele1, 40);
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ActClick(driver, ele1, 40);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            else
            {
                //if Date is enabled date is increased by 'some' days already, just click on the date
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]");
                new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//descendant::td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + formattedDate +"')]")));
                WebElement dateValue=modalContainer.findElement(By.xpath(".//descendant::td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + formattedDate +"')]"));
                HelpersMethod.ActClick(driver, dateValue, 40);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
                // to fetch the web element of the modal container
                WebElement modalContainer1 = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle1 = modalContainer1.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle1.getText(), "Warning", "Verify Title message");
                //Click on OK button
                WebElement okButton=modalContainer1.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,20);
            }
        }
        catch (Exception e) {}
    }

    public void SearchNewlyCreatedOrder(String Ord_No)
    {
        //HelpersMethod.Implicitwait(driver,20);
        WebElement WebEle=null;
        WebElement Search2=null;
        String status=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            exists = HelpersMethod.waitTillLoadingPage(driver);
        }
        new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add filter')]")));
        new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add filter')]")));


        exists = false;
        try
        {
                HelpersMethod.AddFilterSearch(driver, "Order Number", Ord_No);
                //HelpersMethod.Implicitwait(driver, 15);
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
        Actions act1=new Actions(driver);
        exists = false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }

            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='allOrdersCheckbox']"),"Show all orders"));
            new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(ShowQuotes));
            new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.elementToBeClickable(ShowQuotes));
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                exists = HelpersMethod.waitTillLoadingPage(driver);
            }
            else
            {
               if(ShowQuotes.isDisplayed())
               {
                    HelpersMethod.ActClick(driver,ShowQuotes,100);
                   if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                   {
                       WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                       HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40);
                   }
                    exists = true;
                   scenario.log("SHOW ORDER FROM QUOTES CHECK BOX HAS BEEN SELECTED");
                }
               else
               {
                   scenario.log("SHOW QOUTES CHECK BOX NOT DISPLAYED");
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            List<WebElement> Orders=HelpersMethod.FindByElements(driver,"xpath","//button[contains(@class,'i-link-button ')]");
           if(Orders==null)
           {
               scenario.log("THERE ARE NO ORDER NUMBERS TO DISPLAY");
           }
           else
           {
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
                    HelpersMethod.ClickBut(driver,ChangeDD,10);
                }
                //Handling Warning Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Warning')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement WarningDD=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,WarningDD,10);
                }
            }
        }
        catch (Exception e) {}
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[contains(@class,'modal-sm modal-dialog')]/descendant::h4[contains(text(),'Select order')]",driver))
        {
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'modal-sm modal-dialog')]")));
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'modal-sm modal-dialog')]", 400);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'modal-sm modal-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'modal-header')]/descendant::h4"));
            Assert.assertEquals(modalContentTitle.getText(), "Select order", "Verifing calender title");
            //Click on New order
            WebEle = modalContainer.findElement(By.xpath(".//button[contains(text(),'New order')]"));
            HelpersMethod.ActClick(driver, WebEle, 100);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::button[contains(@class,'i-link-button ')]");
            HelpersMethod.ActClick(driver,WebEle,80);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
            }
            exists=true;
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
            }
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='spnmoduleNameHeader']");
            new WebDriverWait(driver, Duration.ofMillis(400)).until(ExpectedConditions.textToBePresentInElement(WebEle, "Checkout summary"));

            //verifying whether user naviagated to OE summary page or not
            if (HelpersMethod.waitTillTitleContains(driver, "Ignition - Order Entry", 4))
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
            WebElement WebEle = HelpersMethod.FindByElement(driver, "id", "OrdersButton");
            HelpersMethod.JScriptClick(driver, WebEle, 6);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
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
            HelpersMethod.ActClick(driver,WebEle,40);
            exists=true;
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ClickOnCopyButton()
    {
        new WebDriverWait(driver,Duration.ofMillis(6000)).until(ExpectedConditions.textToBePresentInElementLocated(By.id("copyOrderBtn"),"Copy"));
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
                HelpersMethod.ClickBut(driver,CopyButton,100);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                exists=true;
            }
            scenario.log("COPYING OF ALL ORDER HAS BEEN DONE");
            Assert.assertEquals(exists,true);
    }

    public void SelectDeliverDateForCopy() throws InterruptedException
    {
        exists=false;
        WebElement WebEle;
        String status=null;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                 HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",60);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with the, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Select delivery date", "Verifing calender title");
            //Click on New order
            WebEle=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
            HelpersMethod.ActClick(driver,WebEle,40);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists,true);
    }

    public void SubmittedStatusDropDown()
    {
        exists=false;
        WebElement WebEle;
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOf(SubmitedDropdown));
        try
        {
            if(SubmitedDropdown.isDisplayed())
            {
                WebEle=HelpersMethod.FindByElement(driver,"id","openOrdersSearchCard");
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, SubmitedDropdown, 100);
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
            new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'k-child-animation-container')]/descendant::ul/li[contains(text(),'Submitted')]")));
            WebElement submitOption=menuContainer.findElement(By.xpath(".//ul/li[contains(text(),'Submitted')]"));
            HelpersMethod.ClickBut(driver,submitOption,20);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void NotSubmitOptionFromDropDown()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]",40);
            // to fetch the web element of the modal container
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]"));
            new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'k-child-animation-container')]/descendant::ul/li[contains(text(),'Not submitted')]")));
            WebElement notSubmitOption=menuContainer.findElement(By.xpath(".ul/li[contains(text(),'Not submitted')]"));
            HelpersMethod.ClickBut(driver,notSubmitOption,20);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ClickOnSearchButton()
    {
        try
        {
            HelpersMethod.ClickBut(driver,SearchBut,40);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
        }
        catch (Exception e) {}
    }

    public void OrderStatusDropDown()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
           if(OrderStatus.isDisplayed())
           {
               WebEle=HelpersMethod.FindByElement(driver,"id","openOrdersSearchCard");
               HelpersMethod.ScrollElement(driver, WebEle);
               HelpersMethod.ActClick(driver, OrderStatus, 200);
               HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",200);
               exists=true;
               if(HelpersMethod.IsExists("//div[@class='loader']",driver))
               {
                   WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                   HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
               }
           }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void OrderOptionFromDropDown()
    {
        exists=false;
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",200);
        //HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",40);
        HelpersMethod.DropDownMenu(driver,"Open Order");
    }

    public void SearchProductInOrder()
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver,ProdNoInput);
            Product= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());

            HelpersMethod.ActSendKey(driver,ProdNoInput,8,Product);

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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.waitVisibilityOfEle(driver,PrintBut,20);
            HelpersMethod.ScrollElement(driver,PrintBut);
            String ParentWindow=driver.getWindowHandle();
            HelpersMethod.ClickBut(driver,PrintBut,20);

            Set<String> PCWindows=driver.getWindowHandles();
            for(String PCwind:PCWindows)
            {
                if(!PCwind.equals(ParentWindow))
                {
                    driver.switchTo().window(PCwind);
                    scenario.log(".pdf HAS BEEN FOUND");
                    driver.close();
                    //HelpersMethod.Implicitwait(driver,1);
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
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//h4[contains(text(),'Select order')]/ancestor::div[contains(@class,'modal-content')]",driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'modal-sm modal-dialog')]", 100);
                // to fetch the web element of the modal container
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'modal-sm modal-dialog')]"));

                // to fetch the web elements of the modal content and interact with them,code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//h4[contains(@class,'modal-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Select order", "Verify Title message");
                //Click on New order option
                WebElement newOrderOption = modalContainer.findElement(By.xpath(".//button[contains(text(),'New order')]"));
                HelpersMethod.ActClick(driver, newOrderOption, 60);

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
                    HelpersMethod.ClickBut(driver, startOrder, 40);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
      try
      {
            WebElement WebEle;
            Actions act1 = new Actions(driver);
            WebEle = HelpersMethod.FindByElement(driver, "id", "openOrdersCard");
            HelpersMethod.ScrollElement(driver, WebEle);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            HelpersMethod.WaitElementPresent(driver, "id", "openOrdersCard", 80);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "id", "openOrdersCard", 80);
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            WebElement starOrderBut = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(text(),'Start order')]");
            act1.moveToElement(starOrderBut).build().perform();
            act1.click(starOrderBut).build().perform();
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            new WebDriverWait(driver, Duration.ofMillis(400)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-child-animation-container')]")));
            // to fetch the web element of the modal container
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]"));
            //new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[@role='menuItem' and contains(text(),'Pick up order')]")));
            List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
            for(int i=0;i<=Options.size()-1;i++)
            {
              WebEle=Options.get(i);
              act1.moveToElement(WebEle).build().perform();
              String Opt=WebEle.getText();
              if(Opt.equals("Pick up order"))
              {
                act1.moveToElement(WebEle).build().perform();
                act1.click(WebEle).build().perform();
                break;
              }
            }
            exists = true;

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

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
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",40);
            // to fetch the web element of the modal container
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]"));
            List<WebElement> OrderOptions=menuContainer.findElements (By.xpath(".//ul/li"));
            for(WebElement ordOption:OrderOptions)
            {
                act1.moveToElement(ordOption).build().perform();
                String OrderOpt=ordOption.getText();
                if(OrderOpt.equals("Active"))
                {
                    act1.moveToElement(ordOption).click().build().perform();
                    break;
                }
                else
                {
                    act1.moveToElement(WebEle).sendKeys(Keys.ARROW_DOWN).build().perform();
                }
            }
        }
        catch (Exception e) { }
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
                        HelpersMethod.Implicitwait(driver,20);
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[contains(@style,'cursor: pointer;')]");
            if(HelpersMethod.EleDisplay(WebEle))
            {
                HelpersMethod.ActClick(driver,WebEle,20);
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
        }
        catch (Exception e){}
    }
}
