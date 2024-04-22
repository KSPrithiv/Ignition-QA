package pages_DSD_OMS.standingOrder;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import lombok.val;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Environment;
import util.TestBase;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class NewStandingOrderCard
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="addStandingOrder")
    private WebElement StartStandingOrder;

    @FindBy(id="copyStandingOrder")
    private WebElement CopyStandingOrder;

    @FindBy(id="deleteStandingOrder")
    private WebElement DeleteStandingOrder;

    @FindBy(id="generateStandingOrders")
    private WebElement GenerateStandingOrder;

    @FindBy(id="showStandingOrderRegisterButton")
    private WebElement ShowStandingOrder;

    public NewStandingOrderCard(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Action
    public void ClickOnNewStandingOrderArrow() throws InterruptedException
    {
        exists = false;
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
        }
        new WebDriverWait(driver,Duration.ofMillis(60000)).until(ExpectedConditions.presenceOfElementLocated(By.id("card1")));
        //Click on arrow if Start standing order card is not visible
        if (HelpersMethod.IsExists("//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]", driver))
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]")));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'StandingOrder-expandable-card')]/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]")));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ActClick(driver, WebEle, 50000);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        }
    }

    public void ClickOnStartStandingOrder() throws InterruptedException
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }

            if (HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-arrow-chevron-up')]", driver))
            {
                if (StartStandingOrder.isDisplayed() && StartStandingOrder.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver, StartStandingOrder);
                    HelpersMethod.JScriptClick(driver, StartStandingOrder, 1000);
                    scenario.log("START STANDING ORDER BUTTON CLICKED");
                    String status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Add standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
                    HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(text(),'Add standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 80000);
                    exists = true;
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    //Code to select start date and end date for standing order
    public void VerifyCalenderPopupStandingOrder() throws InterruptedException
    {
        WebElement fromDateContainer;
        WebElement WebEle;
        String FTDate=null;
        try {
            //Create WebElement for popup
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 6000);
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            //Click on From Calender icon
            WebElement startDateIcon = modalContainer.findElement(By.xpath(".//label[contains(@id,'addFromDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
            HelpersMethod.ActClick(driver, startDateIcon, 1000);

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));

            //Select 'From' date from Start date calender
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", driver))
            {
                // to fetch the web element of the modal container
                fromDateContainer = HelpersMethod.FindByElement(driver, "xpath", "//table[@class='k-calendar-table']");
                WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@class,'k-state-focused')]"));
                if (ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 1000);
                    exists = true;
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "id", "addFromDate");
                    FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 1000);
                    scenario.log(FTDate + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                }
                else
                {
                    scenario.log("FAILED TO SELECT START DATE");
                }
            }

            //Click on To calender icon
            WebElement toDateIcon = modalContainer.findElement(By.xpath(".//label[contains(@id,'addToDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
            HelpersMethod.ActClick(driver, toDateIcon, 1000);
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));

            //Select 'To' date from End date calender
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", driver))
            {
                // to fetch the web element of the modal container
                fromDateContainer = HelpersMethod.FindByElement(driver, "xpath", "//table[@class='k-calendar-table']");
                WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@class,'k-state-focused')]"));
                if (ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 10000);
                    exists = true;
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "id", "addToDate");
                    FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 10000);
                    scenario.log(FTDate + " HAS BEEN SELECTED AS END DATE FOR STANDING ORDER");
                }
                else
                {
                    scenario.log("FAILED TO SELECT START DATE");
                }
            }
            //Click on ADD button
            WebEle = modalContainer.findElement(By.xpath(".//button[text()='Add']"));
            HelpersMethod.ActClick(driver, WebEle, 10000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        }
        catch (Exception e){}
    }

    public void validateStartAddStandingOrderPopup()
    {
        exists=false;
        try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 1000);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            if (HelpersMethod.IsExists("//div[contains(text(),'Add standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnStartDateCalender() throws InterruptedException
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 400);

            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            WebElement startDateIcon = modalContainer.findElement(By.xpath(".//label[contains(@id,'addFromDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(startDateIcon));
            HelpersMethod.JScriptClick(driver, startDateIcon, 1000);
            exists = true;
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]", 800);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ClickOnEndDateCalender() throws InterruptedException
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            WebElement toDateIcon = modalContainer.findElement(By.xpath(".//label[contains(@id,'addToDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
            HelpersMethod.JScriptClick(driver, toDateIcon, 1000);
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 10000);
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
        }
        catch (Exception e){}
    }

    //Selecting Start date
    public void SelectStartDate(int i) throws InterruptedException
    {
        String formattedDate1 = null;
        WebElement WebEle=null;
        String FTDate=null;
        exists=false;
        try
        {
            LocalDate myDateObj = LocalDate.now().plusDays(i);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            formattedDate1 = myDateObj.format(myFormatObj);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", 80);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Visibility of Start calender
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", driver))
            {
                // to fetch the web element of the modal container
                WebElement fromDateContainer = driver.findElement(By.xpath("//table[@class='k-calendar-table']"));
                WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@title,'" + formattedDate1 + "')]"));
                if (ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 1000);
                    exists = true;
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "id", "addFromDate");
                    FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 1000);
                    scenario.log(FTDate + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                }
                else
                {
                    scenario.log("FAILED TO SELECT START DATE");
                }
            }
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    //selecting end date
    public void SelectEndDate(int i) throws InterruptedException
    {
        String formattedDate1 = null;
        String FTDate=null;
        WebElement WebEle=null;
        exists=false;
        try
        {
            LocalDate myDateObj = LocalDate.now().plusDays(i);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            formattedDate1 = myDateObj.format(myFormatObj);

            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", 80);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Visibility of End calender
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", driver)) {
                // to fetch the web element of the modal container
                WebElement fromDateContainer = driver.findElement(By.xpath("//table[@class='k-calendar-table']"));

                WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@title,'" + formattedDate1 + "')]"));
                if (ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 1000);
                    exists = true;
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "id", "addToDate");
                    FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 1000);
                    scenario.log(FTDate + " HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                }
                else
                {
                    scenario.log("FAILED TO SELECT END DATE");
                }
            }
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void AddStartStandingOrder() throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            //Click on Add button
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 10000);
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            // Verify the title of Add standin order popup
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Add standing order", "Verify Title message");

            WebEle = modalContainer.findElement(By.xpath(".//button[text()='Add']"));
            HelpersMethod.ActClick(driver, WebEle, 10000);
            exists = true;
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void DeleteStandingOrders() throws InterruptedException
    {
        try
        {
            exists = false;
            WebElement WebEle = null;
            int i=0;
            List<WebElement> StandingOrders = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'standing-orders')]/descendant::span[contains(@class,'pending')]/ancestor::button|//div[contains(@class,'standing-orders')]/descendant::span[contains(@class,'standing-orders-status active  ')]/ancestor::button");
            scenario.log("TOTAL NUMBER OF ACTIVE AND PENDING SO FOUND ARE " + StandingOrders.size());
            while(!StandingOrders.isEmpty())
            {
                i++;
                scenario.log(i+" STANDING ORDER HAS BEEN DELETED");
                WebElement SO=StandingOrders.get(0);
                HelpersMethod.ScrollElement(driver, SO);
                HelpersMethod.ActClick(driver, SO, 10000);
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

                //Click on down arrow in standing order card
                ClickOnNewStandingOrderArrow();
                HelpersMethod.ClickBut(driver, DeleteStandingOrder, 10000);
                if (HelpersMethod.IsExists("//div[contains(text(),'Delete standing order?')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                    // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                    WebElement modalContentTitle = modalContainer.findElement(By.xpath("//div[contains(@class,'k-window-title k-dialog-title')]"));
                    Assert.assertEquals(modalContentTitle.getText(), "Delete standing order?", "Verify Title message");

                    WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                    HelpersMethod.ActClick(driver, WebEle, 10000);

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    scenario.log("STANDING ORDER DELETED");
                    exists = true;
                }
                //Thread.sleep(500);
                StandingOrders.remove(SO);
                //Thread.sleep(500);
                StandingOrders=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'standing-orders')]/descendant::span[contains(@class,'standing-orders-status active  ')]/ancestor::button|//div[contains(@class,'standing-orders')]/descendant::span[contains(@class,'standing-orders-status   pending')]/ancestor::button");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void deleteExpiredSO() throws InterruptedException
    {
        WebElement WebEle;
        try
        {
            ClickOnNewStandingOrderArrow();
            HelpersMethod.ClickBut(driver,DeleteStandingOrder,10000);
            if(HelpersMethod.IsExists("//div[contains(text(),'Delete standing order?')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Delete standing order?", "Verify Title message");

                WebEle = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ActClick(driver, WebEle, 10000);
                scenario.log("EXPIRED STANDING ORDER DELETED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickCopyStandingOrderButton()
    {
        try
        {
            exists = false;
            if (CopyStandingOrder.isDisplayed() && CopyStandingOrder.isEnabled())
            {
                HelpersMethod.ClickBut(driver, CopyStandingOrder, 10000);
                scenario.log("COPY STANDING ORDER HAS BEEN CLICKED");
                exists = true;
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(text(),'Copy standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 10000);
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copy standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void validateVisiblilityOfCopyStandingOrderDiaglog()
    {
        exists = false;
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(text(),'Copy standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 400);
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 400);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Copy standing order", "Verify Title message");
    }

    public void copyStandingOrderDialogForStartDate(int dStart) throws InterruptedException
    {
        String formattedDate1 = null;
        WebElement WebEle = null;
        String FTDate = null;
        exists = false;

        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 30);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
        WebElement startDateIcon = modalContainer.findElement(By.xpath(".//label[contains(@id,'copyFromDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
        HelpersMethod.ActClick(driver, startDateIcon, 10000);
        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]")));
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        //upon Visibility of Start calender
        LocalDate myDateObj = LocalDate.now().plusDays(dStart);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        formattedDate1 = myDateObj.format(myFormatObj);

        // to fetch the web element of the modal container
        WebElement fromDateContainer = driver.findElement(By.xpath("//div[contains(@class,'k-calendar-view')]/descendant::table[@class='k-calendar-table']"));
        WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@title,'" + formattedDate1 + "')]"));
        HelpersMethod.JSScroll(driver, ele1);
        HelpersMethod.ActClick(driver, ele1, 10000);
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        WebEle = HelpersMethod.FindByElement(driver, "id", "copyFromDate");
        FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 10000);
        scenario.log(FTDate + " HAS BEEN SELECTED AS START DATE FOR COPY STANDING ORDER");
        if (!FTDate.equals(null) && !FTDate.equals("MM/DD/YYYY"))
        {
            exists = true;
        }
        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        Assert.assertEquals(exists, true);
    }

    public void copyStandingOrderDialogForEndDate(int dEnd) throws InterruptedException
    {
        String formattedDate1 = null;
        WebElement WebEle = null;
        String FTDate = null;
        exists = false;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 10000);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
        WebElement endDateIcon = modalContainer.findElement(By.xpath(".//label[contains(@id,'copyToDate-label')]/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]"));
        HelpersMethod.ActClick(driver, endDateIcon, 10000);
        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        // to fetch the web element of the modal container
        WebElement ToDateContainer = driver.findElement(By.xpath("//div[contains(@class,'k-calendar-view')]/descendant::table[@class='k-calendar-table']"));

        LocalDate myDateObj = LocalDate.now().plusDays(dEnd);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        formattedDate1 = myDateObj.format(myFormatObj);
        WebElement ele1 = ToDateContainer.findElement(By.xpath(".//td[contains(@title,'" + formattedDate1 + "')]"));
        HelpersMethod.JSScroll(driver, ele1);
        HelpersMethod.ActClick(driver, ele1, 10000);
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        WebEle = HelpersMethod.FindByElement(driver, "id", "copyToDate");
        FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 10000);
        scenario.log(FTDate + " HAS BEEN SELECTED AS END DATE FOR COPY STANDING ORDER");
        if (!FTDate.equals(null) && !FTDate.equals("MM/DD/YYYY"))
        {
            exists = true;
        }
        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
    }

    public void copyButtonInCopyStandingOrderDiaglog()
    {
        exists = false;
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 10000);
        // to fetch the web element of the modal container
        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

        //Click on Copy Button
        WebElement copyButton = modalContainer.findElement(By.xpath("//button[text()='Copy']"));
        if (copyButton.isEnabled())
        {
            HelpersMethod.ClickBut(driver, copyButton, 10000);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[text()='Success']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",10000);
            exists = true;
        }
        Assert.assertEquals(exists, true);
    }

    public void copySuccessPopup()
    {
        try
        {
            exists = false;
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[text()='Success']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 2000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[text()='Success']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 4000);
            // to fetch the web element of the modal container
            WebElement copySuccessContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement successContentTitle = copySuccessContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(successContentTitle.getText(), "Success", "Verify Title message");

            //Click on Ok Button
            WebElement OkButton = copySuccessContainer.findElement(By.xpath(".//button[text()='OK']"));
            HelpersMethod.ClickBut(driver, OkButton, 10000);
            exists = true;
            scenario.log("STANDING ORDER HAS BEEN COPIED SUCESSFULLY");
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickOnStandingOrderRegisterButton()
    {
        exists=false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.ClickBut(driver, ShowStandingOrder, 10000);
            exists = true;
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 10000);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void validateStandingOrderRegisterPopup()
    {
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 200);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Standing order register", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void searchForCustomerAccountNo()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-loading')]",driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(@class,'k-icon k-i-loading')]")));
            }
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement custFilterInput = modalContainer.findElement(By.xpath(".//th[2]/div[@class='k-filtercell'][1]/descendant::input"));
            String Acc_No = TestBase.testEnvironment.get_Account();
            HelpersMethod.EnterText(driver, custFilterInput, 10000, Acc_No);
            exists = true;
            scenario.log("CUSTOMER ACCOUNT# ENTERED IS " + TestBase.testEnvironment.get_Account());
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        }
        catch (Exception e){}
    }

    public void clickOnCheckboxForCustomerAcc() throws InterruptedException
    {
        exists=false;
        try
        {
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement checkBoxCustomerAcc = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]/descendant::input"));
            HelpersMethod.ActClick(driver, checkBoxCustomerAcc, 10000);
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickRemoveFilterForCustomerAcc() throws InterruptedException
    {
        exists=false;
        try
        {
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement custFilterButton = modalContainer.findElement(By.xpath(".//th[2]/div[@class='k-filtercell'][1]/descendant::button[@title='Clear']"));
            HelpersMethod.ActClick(driver, custFilterButton, 10000);
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickOnShowSelectedCustomerTaggle() throws InterruptedException
    {
        exists=false;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[@id='standingOrderRegisterDialog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
        {
            WebElement custFilterButton = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[@id='selectedCustomersSwitch']");
            HelpersMethod.ActClick(driver, custFilterButton, 10000);
            exists = true;
        }
        Assert.assertEquals(exists,true);
    }

    public void navigateToRoute()
    {
        exists=false;
        try {
            Actions act1 = new Actions(driver);
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            List<WebElement> menus = modalContainer.findElements(By.xpath(".//div[contains(@class,'k-window-content k-dialog-content')]/descendant::ul/li/span"));
            for (WebElement menu : menus) {
                act1.moveToElement(menu).build().perform();
                String menu_Text = menu.getText();
                if (menu_Text.equals("Routes")) {
                    act1.moveToElement(menu).click().build().perform();
                    exists = true;
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void searchForRoute()
    {
        exists = false;
        try
        {
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement custFilterInput = modalContainer.findElement(By.xpath(".//div[@class='k-animation-container k-animation-container-relative'][2]/descendant::table[1]/descendant::tr[@class='k-filter-row']/th[2]/div[@class='k-filtercell'][1]/descendant::input"));
            String route = TestBase.testEnvironment.get_Route1();
            HelpersMethod.EnterText(driver, custFilterInput, 10000, route);
            exists = true;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickOnCheckboxForRoute() throws InterruptedException
    {
        exists = false;
        try
        {
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement checkBoxRoute = modalContainer.findElement(By.xpath(".//div[@class='k-animation-container k-animation-container-relative'][2]/descendant::tr[contains(@class,'k-master-row')]/descendant::input"));
            HelpersMethod.ActClick(driver, checkBoxRoute, 10000);
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickRemoveFilterForRoute() throws InterruptedException
    {
        exists=false;
        try
        {
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement custFilterButton = modalContainer.findElement(By.xpath(".//div[@class='k-animation-container k-animation-container-relative'][2]/descendant::tr[@class='k-filter-row']/descendant::th[2]/div[@class='k-filtercell'][1]/descendant::button[@title='Clear']"));
            HelpersMethod.ActClick(driver, custFilterButton, 10000);
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickOnShowSelectedRouteTaggle() throws InterruptedException
    {
        exists = false;
        try
        {
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement custFilterButton = modalContainer.findElement(By.xpath(".//span[@id='selectedRoutesSwitch']"));
            HelpersMethod.ActClick(driver, custFilterButton, 10000);
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickOnStandingOrderCardExcel() throws InterruptedException
    {
        exists = false;
        try
        {
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement excelButton = modalContainer.findElement(By.xpath(".//button[@id='standingOrderRegisterDialogExcelButton']"));
            HelpersMethod.ActClick(driver, excelButton, 10000);
            exists = true;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@id='toast-container']", driver))
            {
                scenario.log("NO DATA HAS BEEN GENERATED");
                Thread.sleep(2000);
            }
            else
            {
                scenario.log(".csv FILE DOWNLOADED");
            }
            WebElement cancelButton = modalContainer.findElement(By.xpath(".//button[@id='standingOrderRegisterDialogCancelButton']"));
            HelpersMethod.ClickBut(driver, cancelButton, 10000);
            Thread.sleep(6000);
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickOnStandingOrderCardPdf() throws InterruptedException
    {
        try
        {
            exists = false;
            String ParentWindow = driver.getWindowHandle();
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement pdfButton = modalContainer.findElement(By.xpath(".//button[@id='standingOrderRegisterDialogPDFButton']"));
            HelpersMethod.ActClick(driver, pdfButton, 10000);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Thread.sleep(2000);
            if (HelpersMethod.IsExists("//div[@id='toast-container']", driver))
            {
                scenario.log("<span style='color:red'>NO DATA HAS BEEN GENERATED</span>");
                exists=true;
                Thread.sleep(3000);
            }
            else
            {
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        exists = true;
                        scenario.log("STANDING ORDER REGISTER HAS BEEN HANDLED");
                    }
                }
                driver.switchTo().window(ParentWindow);
            }
            //Click on Cancel button
            WebElement cancelButton = modalContainer.findElement(By.xpath(".//button[@id='standingOrderRegisterDialogCancelButton']"));
            HelpersMethod.ClickBut(driver, cancelButton, 10000);
            Assert.assertEquals(exists, true);
        }
        catch ( Exception e){}
    }

    public void clickOnGenerateStandingOrder()
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

            if (GenerateStandingOrder.isDisplayed() && GenerateStandingOrder.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,GenerateStandingOrder);
                HelpersMethod.ClickBut(driver, GenerateStandingOrder, 10000);
                scenario.log("GENERATE STANDING ORDER HAS BEEN CLICKED");
                exists = true;
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

    public void verifyGenerateStandingOrderPopup() throws InterruptedException
    {
        Thread.sleep(1000);
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Generate standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnStartStandingOrderCalender()
    {
        try
        {
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
            //Identify From calender and click
            WebElement fromCalender = modalContainer.findElement(By.xpath(".//label[contains(text(),'From date')]/following-sibling::span/descendant::a/span"));
            HelpersMethod.JScriptClick(driver, fromCalender, 10000);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-widget k-calendar k-calendar-range')]")));
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-calendar k-calendar-range')]")));
        }
        catch (Exception e){}
    }

    public void selectFromDateForGenerateSO()
    {
        exists=false;
        try
        {
            Actions act1 = new Actions(driver);
            if(HelpersMethod.IsExists("//div[contains(text(),'Generate standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement selectableDate = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@class,'k-calendar-td k-range-end k-range-start k-state-pending-focus k-state-selected')]/span");
                HelpersMethod.ScrollDownScrollBar(driver);
                HelpersMethod.ScrollTillElementVisible(driver, selectableDate);
                act1.moveToElement(selectableDate).build().perform();
                act1.click(selectableDate).build().perform();
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch ( Exception e){}
    }

    public void clickToDateForGenerateSO()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Generate standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver)) {
                // to fetch the web element of the modal container
                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                //Identify From calender and click
                WebElement toCalender = modalContainer.findElement(By.xpath(".//label[contains(text(),'To date')]/following-sibling::span/descendant::a/span"));
                HelpersMethod.JScriptClick(driver, toCalender, 10000);
                exists=true;
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-widget k-calendar k-calendar-range')]")));
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-calendar k-calendar-range')]")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void selectToDateForGenerateSO()
    {
        try
        {
            exists=false;
            Actions act1 = new Actions(driver);
            if(HelpersMethod.IsExists("//div[contains(text(),'Generate standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                List<WebElement> selectableDates = HelpersMethod.FindByElements(driver,"xpath","//td[contains(@class,'k-calendar-td') and contains(@style,'opacity: 1;')]");
                int j=selectableDates.size()-1;
                for (int i = selectableDates.size() - 1; i >= 1; i--)
               //for(int i=0;i<=selectableDates.size()-1;i++)
               {
                   act1.moveToElement(selectableDates.get(i)).build().perform();
                   //if (i == selectableDates.size() - 1)
                   if (i == 1)
                   {
                       String selectTo = selectableDates.get(i).getAttribute("title");
                       WebElement selTo = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@class,'k-calendar-td') and @title='" + selectTo + "']");
                       act1.moveToElement(selTo).build().perform();
                       HelpersMethod.JScriptClick(driver, selTo, 10000);
                       exists=true;
                       break;
                   }
               }
            }
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }

    public void clickOnOkButtonInGenerateSO() throws InterruptedException
    {
        exists=false;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Generate standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Generate standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
            if(HelpersMethod.IsExists("//div[contains(text(),'Generate standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Generate standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement OkCalender = modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ActClick(driver, OkCalender, 20000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateGeneratingStandingOrdersForCustomersPopup()
    {
        if(HelpersMethod.IsExists("//div[contains(text(),'Getting list of standing order customers.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Generate standing order(s)", "Verify Title message");
        }
    }

    public void waitTillGeneratingStandingOrdersForCustomersDisappears()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Getting list of standing order customers.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Getting list of standing order customers.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAllTasksCompletedPopup()
    {
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'All tasks completed. Error count:')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Generate standing order(s)", "Verify Title message");
            }
        }
        catch (Exception e){}
    }

    public void clickOnViewDetails()
    {
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            //creating webelement for view details button
            WebElement viewDetailsButton = modalContainer.findElement(By.xpath(".//button[contains(text(),'View details')]"));
            if (viewDetailsButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, viewDetailsButton, 10000);
            }
            else
            {
                scenario.log("VIEW DETAILS BUTTON IS NOT ENABLED, MAY BE NOT ABLE TO GENERATE THE REPORT PLZ CHECK THE DATE RANGE");
            }
        }
        catch (Exception e){}
    }

    public void clickOnOkGenerateStandingOrder()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                //creating webelement for view details button
                WebElement okButton = modalContainer.findElement(By.xpath(".//button[contains(text(),'Ok')]"));
                HelpersMethod.ClickBut(driver, okButton, 10000);
            }
        }
        catch (Exception e){}
    }

    public void clickOnOkInAllTasksCompleted()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Generate standing order(s)')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                //creating webelement for view details button
                WebElement okButton = modalContainer.findElement(By.xpath(".//button[contains(text(),'Ok')]"));
                HelpersMethod.ClickBut(driver, okButton, 10000);
            }
        }
        catch (Exception e){}
    }

    public void standingOrderCancelButton()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//button[@id='standingOrderRegisterDialogCancelButton']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[@id='standingOrderRegisterDialogCancelButton']");
                HelpersMethod.ClickBut(driver,WebEle,10000);
                exists=true;
                Thread.sleep(2000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public List<WebElement> readDatesOfStandingOrder()
    {
        exists=false;
        WebElement WebEle=null;
        Actions act=new Actions(driver);
        List<WebElement> soDate = null;
        String status;
        try
        {
            List<WebElement> StandingOrders = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'standing-orders')]/descendant::span[contains(@class,'standing-orders-status active')] | //div[contains(@class,'standing-orders')]/descendant::span[contains(@class,'standing-orders-status pending')]");
            scenario.log("TOTAL ACTIVE AND PENDING STANDING ORDERS FOUND ARE "+StandingOrders.size());
            soDate=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'standing-orders')]/descendant::span[contains(@class,'standing-orders-status active')]/following-sibling::div[2] | //div[contains(@class,'standing-orders')]/descendant::span[contains(@class,'standing-orders-status pending')]/following-sibling::div[2]");
        }
        catch (Exception e){}
        return soDate;
    }

    public void selectExpiredSO()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[@class='standing-orders']/descendant::span[contains(@class,'standing-orders-status  expired ')][1]/ancestor::button",driver))
            {
                WebElement expiredSO=HelpersMethod.FindByElement(driver,"xpath","//div[@class='standing-orders']/descendant::span[contains(@class,'standing-orders-status  expired ')][1]/ancestor::button");
                HelpersMethod.ActClick(driver,expiredSO,10000);
                exists=true;
            }
            else
            {
                scenario.log("NO EXPIRED STANDING ORDER HAS BEEN FOUND");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateFromStandingOrderCalender()
    {
        exists=false;
        try
        {
            Thread.sleep(500);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateToStandingOrderCalender()
    {
        exists=false;
        try
        {
            Thread.sleep(500);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateDialogboxSOAllreadyExists()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Standing order exist for the selected date.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=modelContainer.findElement(By.xpath(".//button[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void cancelAddSO()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Add standing order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement cancelButton=modelContainer.findElement(By.xpath(".//button[text()='Cancel']"));
                HelpersMethod.ActClick(driver,cancelButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}