package pages_DSD_OMS.orderEntry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderEntryPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean result = false;
    static String C_Date1;
    static String ChangeDate;
    static String currentURL;
    static String dateCurrent;
    static String deliveryDate;
    static String primarySalesRep;
    static String ParentWindow;
    static String pickUpDate;
    static boolean exists = false;
    static String formattedDate;

    @FindBy(id = "customerAccountNumberComboBox")
    private WebElement AccNo;

    @FindBy(xpath="//button[@id='customeraddress']//*[local-name()='svg']")
    private WebElement AddressIcon;

    @FindBy(id = "addButton")
    private WebElement StartOrder;

    @FindBy(xpath = "//button[contains(@class,'k-button k-primary') and @aria-label=' dropdownbutton']")
    private WebElement StartOrderDropButton;

    @FindBy(id = "skipButton")
    private WebElement Skip;

    @FindBy(id = "customerAccountIndexSearchBar")
    private WebElement SearchOrder;

    @FindBy(xpath = "//div[contains(@class,'i-search-box')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement SearchIndex;

    @FindBy(xpath = "//span[contains(@class,'k-datepicker')]/button//*[local-name()='svg']")
    private WebElement deliveryCalender;

    @FindBy(id = "summaryOrderOptions_HistoryOrder")
    private WebElement HistoryButton;

    @FindBy(id = "addButton_dropdown")
    private WebElement DropDown;

    @FindBy(xpath = "//button/span[text()='Remove Skip']")
    private WebElement RemoveSkip;

    @FindBy(xpath = "//button[@id='customernotes']")
    private WebElement CustomerNote;

    @FindBy(id = "noteTextbox")
    private WebElement NoteArea;

    @FindBy(id = "SaveButton")
    private WebElement Save_But;

    @FindBy(xpath = "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']")
    private WebElement Ok_But;

    @FindBy(xpath = "//div[contains(@class,'CPDeliveryDates')]/descendant::input")
    private WebElement DelivDate;

    @FindBy(xpath = "//input[@id='RouteIndex']")
    private WebElement RouteInput;

    @FindBy(xpath = "//label[@id='RouteIndex-label']/parent::div/descendant::button")
    private WebElement RouteOE;

    @FindBy(id = "skipButton")
    private WebElement SkipButton;

    @FindBy(xpath = "//span[@data-test-id='customerAccountNumberComboBox']/following-sibling::button")
    private WebElement AccIndexIcon;

    public OrderEntryPage(WebDriver driver, Scenario scenario) throws InterruptedException, AWTException
    {
        this.scenario = scenario;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean HandleError_Page()
    {
        exists=false;
        try
        {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError"))
            {
                Thread.sleep(10000);
                scenario.log("************** ERROR PAGE HAS BEEN FOUND *************");
                exists=true;
                HelpersMethod.NavigateBack(driver);
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
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                driver.navigate().to(currentURL);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
            {
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
                HomePage homepage = new HomePage(driver, scenario);
                homepage.navigateToClientSide();
                NavigateToOrderEntry();
                ChangeAccount();
                PopUps_After_AccountChange();
            }
        } catch (Exception e) {}
        return exists;
    }

    public void NavigateToOrderEntry()
    {
        exists=false;
        WebElement WebEle;
        String status;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Actions act = new Actions(driver);
            //Code to enter search value in hamburger input box and click on it
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("Order Entry").build().perform();

            WebElement OEMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Order Entry')]|//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'OE')]");
            HelpersMethod.ActClick(driver, OEMenu, 20000);

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

            currentURL = driver.getCurrentUrl();
            scenario.log(currentURL);

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //code to click on opened hamburger icon
            if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).click().build().perform();
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            scenario.log("NAVIGATED TO ORDER ENTRY PAGE");
        }
        catch (Exception e) {}
    }

    public void NavigateingToOrderEntry()
    {
        exists=false;
        WebElement WebEle;
        String status;

        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            //navigate back to OE page from New OE page
            if(HelpersMethod.IsExists("//div[@id='orderEntryCard']",driver))
            {
                WebElement backButton=HelpersMethod.FindByElement(driver,"id","backButton");
                HelpersMethod.ClickBut(driver,backButton,10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }

            Actions act = new Actions(driver);
            //code to click on hamburger to expand
            WebElement humBurger=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            act.moveToElement(humBurger).build().perform();
            act.click(humBurger).build().perform();
            //find whether side menu bar has expanded
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 40000);
            WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
            act.moveToElement(side_menu).build().perform();

            if(HelpersMethod.IsExists("//i[@class='searchbar-container-close-icon']",driver))
            {
                WebElement closeButton=HelpersMethod.FindByElement(driver,"xpath","//i[@class='searchbar-container-close-icon']");
                if(closeButton.isDisplayed() && closeButton.isDisplayed())
                {
                    HelpersMethod.ActClick(driver, closeButton, 10000);
                }
            }

            //Code to enter search value in hamburger input box and click on it
            WebElement Search_Input=HelpersMethod.FindByElement(driver,"id","navigationMenuSearchBar");
            act.moveToElement(Search_Input).click().sendKeys("Order Entry").build().perform();
            WebElement OEMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Order Entry')]|//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'OE')]");
            HelpersMethod.ActClick(driver, OEMenu, 20000);

            if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted')]/ancestor::div[@class='k-widget k-window k-dialog']",driver))
            {
              WebElement dialogBoxSubmit=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Submit order']");
              HelpersMethod.ActClick(driver,dialogBoxSubmit,10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }

            //Code to handle order already exists dialog box
            if(HelpersMethod.IsExists("//div[contains(text(),'Existing orders found')]/ancestor::div[@class='k-widget k-window k-dialog']",driver))
            {
                WebElement yesButton=HelpersMethod.FindByElement(driver,"xpath","//button/span[text()='Yes']");
                HelpersMethod.ActClick(driver,yesButton,10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement pendingPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement dismissAll= pendingPopup.findElement(By.xpath("//button[contains(@id,'QuestionModalButton')"));
                    HelpersMethod.ActClick(driver,dismissAll,10000);
                }

                //code to click on opened hamburger icon
            if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).click().build().perform();
            }
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

            scenario.log("NAVIGATED TO ORDER ENTRY PAGE");
        }
        catch (Exception e) {}
    }

    public void navigateToOrderEntry1()
    {
        try
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Orders')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='web-order-page']")));
                currentURL = driver.getCurrentUrl();
            }
            else
            {
                scenario.log("ORDERS TAB DOESN'T EXISTS, PLEASE CHECK THE ADMIN SETTINGS");
            }
        }
        catch (Exception e) {}
    }

    public void ChangeAccount()
    {
        exists = false;
        WebElement WebEle;
        String Acc_No ="";
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
                .withTimeout(Duration.ofSeconds(120))
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
            //new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("customerAccountNumberComboBox")));
            Actions act = new Actions(driver);
            Acc_No = TestBase.testEnvironment.get_Account();
            WebEle = HelpersMethod.FindByElement(driver, "id", "customerAccountNumberComboBox");
            act.moveToElement(WebEle).click().build().perform();
            if(HelpersMethod.JSGetValueEle(driver,WebEle,1000).equals(""))
            {
                act.sendKeys(WebEle, Acc_No).build().perform();
            }
            else
            {
                HelpersMethod.JSSetValueEle(driver,WebEle,1000,"");
                WebEle.sendKeys(Keys.BACK_SPACE);
                act.sendKeys(WebEle, Acc_No).build().perform();
            }
            WebElement AccDrop1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-list-container ')]/descendant::li");
            HelpersMethod.JScriptClick(driver, AccDrop1, 1000);
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

            WebEle = HelpersMethod.FindByElement(driver, "id", "customerAccountNumberComboBox");
            Acc_No = HelpersMethod.JSGetValueEle(driver, WebEle, 2000);
            scenario.log("CUSTOMER ACCOUNT# SELECTED IS " + Acc_No);
            if (!Acc_No.equals(null))
            {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Change_OldAccount(String account)
    {
        exists = false;
        try
        {
            Refresh_Page(currentURL);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Actions act = new Actions(driver);
            scenario.log("ACCOUNT NUMBER WILL BE CHANGED TO "+account);
            act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys("").build().perform();
            act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys(account).build().perform();

            new WebDriverWait(driver, Duration.ofMillis(8000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-list-container ')]/descendant::li")));
            WebElement AccDrop = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@id,'option-')]");

            WebElement AccDrop1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-list-container ')]/descendant::li");
            HelpersMethod.JScriptClick(driver, AccDrop1, 10000);
            exists = true;

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void PopUps_After_AccountChange()
    {
        WebElement WebEle;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            for (int i = 0; i <= 3; i++)
            {
                //Check for 'Upcoming blackout dates'
                if (HelpersMethod.IsExists("//p[contains(text(),'Upcoming blackout dates')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                    driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']")).click();
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                }

                //check for note popup
                if (HelpersMethod.IsExists("//div[@id='customerCommentGrid']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton = WebEle.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver, okButton, 20000);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                }

                if (HelpersMethod.IsExists("//div[@id='order-guide-grid']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton = WebEle.findElement(By.xpath(".//button/span[text()='Cancel']"));
                    HelpersMethod.ActClick(driver, okButton, 10000);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                }

                //Checking for the open order popup
                if (HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                    WebElement startOrder = WebEle.findElement(By.xpath(".//button/span[contains(text(),'Start new order')]"));
                    HelpersMethod.ActClick(driver, startOrder, 10000);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                }
            }
        }
        catch (Exception e) {}
    }

    public boolean Verify_OE_Title()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            if(HelpersMethod.IsExists("//div[@class='order-search-grid']",driver))
            {
                scenario.log("ORDER ENTRY PAGE HAS BEEN FOUND");
                exists = true;
            }
        }
        catch (Exception e) {}
        return exists;
    }

   public void Refresh_Page1()
    {
        try
        {
          //  WebElement WebEle = null;
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

            driver.navigate().to(currentURL);
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            driver.navigate().refresh();
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e) {}
    }

    public void Refresh_Page2()
    {
        String status;
        Wait<WebDriver> wait;
        Actions act1=new Actions(driver);
        try
        {
                if (HelpersMethod.IsExists("//div[contains(@class,'k-dialog-wrapper')]|//div[@class='modal-sm modal-dialog']|//div[contains(@class,'modal-content')]|//div[contains(@class,'k-dialog-wrapper order-selection ')]|//div[@class='k-dialog-wrapper priceOverrideDialog ']|//div[@class='k-dialog-wrapper OrderCommentDialog ']", driver))
                {
                    WebElement dialogBox = driver.findElement(By.xpath("//div[contains(@class,'k-dialog-wrapper')]|//div[contains(@class,'modal-dialog')]|//div[contains(@class,'k-dialog-wrapper order-selection ')]|//div[contains(@class,'modal-content')]|//div[@class='k-dialog-wrapper priceOverrideDialog ']|//div[@class='k-dialog-wrapper OrderCommentDialog ']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", dialogBox);

                    driver.navigate().refresh();

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to leave this page?')]/ancestor::div[@class='k-window k-dialog']",driver))
                {
                    WebElement submitButton=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::span[text()='Submit order']");
                    HelpersMethod.ActClick(driver,submitButton,10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }

//            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]|//div[@class='modal-content']",driver))
//            {
//                JavascriptExecutor js = ((JavascriptExecutor) driver);
//                js.executeScript("window.location.reload()");
//                wait = new FluentWait<WebDriver>(driver)
//                        .withTimeout(Duration.ofSeconds(200))
//                        .pollingEvery(Duration.ofSeconds(2))
//                        .ignoring(NoSuchElementException.class);
//                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
//
//                wait = new WebDriverWait(driver, Duration.ofMillis(1000));
//                if(wait.until(ExpectedConditions.alertIsPresent())==null)
//                {
//
//                }
//                else
//                {
//                    Alert alert = driver.switchTo().alert();
//                    alert.accept();
//                }
//                wait = new FluentWait<WebDriver>(driver)
//                        .withTimeout(Duration.ofSeconds(200))
//                        .pollingEvery(Duration.ofSeconds(2))
//                        .ignoring(NoSuchElementException.class);
//                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
//
//                status = HelpersMethod.returnDocumentStatus(driver);
//                if (status.equals("loading"))
//                {
//                    HelpersMethod.waitTillLoadingPage(driver);
//                }
//
//                wait = new FluentWait<WebDriver>(driver)
//                        .withTimeout(Duration.ofSeconds(200))
//                        .pollingEvery(Duration.ofSeconds(2))
//                        .ignoring(NoSuchElementException.class);
//                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
//
//            }
//
                WebElement humBurger=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act1.moveToElement(humBurger).build().perform();
                act1.click(humBurger).build().perform();

                //find whether side menu bar has expanded
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 40000);
                WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
                act1.moveToElement(side_menu).build().perform();

                if(HelpersMethod.IsExists("//i[@class='searchbar-container-close-icon']",driver))
                {
                    WebElement closeButton=HelpersMethod.FindByElement(driver,"xpath","//i[@class='searchbar-container-close-icon']");
                    if(closeButton.isDisplayed() && closeButton.isDisplayed())
                    {
                        HelpersMethod.ActClick(driver, closeButton, 10000);
                    }
                }

                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'searchbar-container')]/descendant::input[@id='navigationMenuSearchBar']"))));
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'searchbar-container')]/descendant::input[@id='navigationMenuSearchBar']"))));

                WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'searchbar-container')]/descendant::input[@id='navigationMenuSearchBar']");
                act1.moveToElement(Search_Input).click().sendKeys("Order Entry").build().perform();

                WebElement OEMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Order Entry')]");
                HelpersMethod.ActClick(driver,OEMenu,10000);
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
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement pendingPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement dismissAll= pendingPopup.findElement(By.xpath("//button[contains(@id,'QuestionModalButton')"));
                    HelpersMethod.ActClick(driver,dismissAll,10000);
                }
                humBurger=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act1.moveToElement(humBurger).click().build().perform();

                wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

   public void Refresh_Page(String currentURL1)
    {
            scenario.log("CURRENT URL IS "+currentURL1);
            driver.navigate().to(currentURL1);
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
    }

    //change the Customer Account#
    public void Change_NewAccount(String Acc)
    {
        exists = false;
        WebElement WebEle;
        String headText;
        Actions act=new Actions(driver);
        Wait<WebDriver> wait;
        int i=0;
        try
        {
            scenario.log("ACCOUNT NUMBER WILL BE CHANGED TO "+Acc);
            if (HelpersMethod.IsExists("//span[@data-test-id='customerAccountNumberComboBox']/following-sibling::button",driver))
            {
                HelpersMethod.ActClick(driver, AccIndexIcon, 10000);
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
                if (HelpersMethod.IsExists("//span[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
//                    if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::input[contains(@class,'i-search-box')]", driver))
//                    {
//                        //Click on Add filter button
//                      WebElement addFilter=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'i-filter-tag__main')]");
//                      HelpersMethod.ClickBut(driver,addFilter,10000);
//                      //Enter value for search in inputbox
//                      WebElement searchInput=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative')]/descendant::input[contains(@class,'i-search-box__input')]");
//                      HelpersMethod.EnterText(driver,searchInput,10000,"Customer #");
//                      //Click on check box in first drop down
//                      WebElement checkBox=HelpersMethod.FindByElement(driver,"id","FORMATTED_CM_CUSTKEY");
//                      HelpersMethod.ActClick(driver,checkBox,10000);
//                      //Enter value in input box of 2nd drop down
//                        WebElement searchinput2=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative')]/descendant::input[@class='k-textbox']");
//                        HelpersMethod.EnterText(driver,searchinput2,10000,Acc);
//                       //Click on Apply button
//                       WebElement applyBut=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative')]/descendant::button/span[text()='Apply']");
//                       HelpersMethod.ClickBut(driver,applyBut,10000);
//                       //Selecting Account number
//                        WebElement accNo=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]");
//                        HelpersMethod.ActClick(driver,accNo,10000);
//
//                        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                                .withTimeout(Duration.ofSeconds(200))
//                                .pollingEvery(Duration.ofSeconds(2))
//                                .ignoring(NoSuchElementException.class);
//                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
//                    }

                    //identify headers of customer index popup
                    List<WebElement> heads= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::thead/descendant::span[@class='k-column-title']");
                    for(WebElement head:heads)
                    {
                        i++;
                       act.moveToElement(head).build().perform();
                       headText=head.getText();
                       if(headText.equalsIgnoreCase("Customer #"))
                       {
                           break;
                       }
                    }

                    WebElement accountFilter=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::thead/descendant::input[@class='k-input-inner']["+i+"]");
                    HelpersMethod.ActSendKey(driver,accountFilter,10000,Acc);
                    //Selecting Account number
                    WebElement accNo=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]");
                    HelpersMethod.ActClick(driver,accNo,10000);
                    wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(200))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            PopUps_After_AccountChange();
            WebEle = HelpersMethod.FindByElement(driver, "id", "customerAccountNumberComboBox");
            String Acc_No = HelpersMethod.JSGetValueEle(driver, WebEle, 2000);
            scenario.log("CUSTOMER ACCOUNT# SELECTED IS " + Acc_No);
            if (!Acc_No.equals(null))
            {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //Preceding by zero, This feature is only for DSD
    public boolean Account_Zero()
    {
        try
        {
            result = false;
            String Acc1 = AccNo.getAttribute("value");
            if(Acc1.contains("-"))
            {
                //Code to read account# from properties file and remove preceding zeros
                String Acc_Sub[] = Acc1.split("-");
                for (String Accs : Acc_Sub)
                {
                    if (Accs.length() != 1)
                    {
                        int firstValue = Integer.parseInt(String.valueOf(Accs.charAt(0)));
                        if (firstValue != 0)
                        {
                            result = true;
                        }
                    }
                }
            }
            else
            {
                int firstValue = Integer.parseInt(String.valueOf(Acc1.charAt(0)));
                if (firstValue != 0)
                {
                    result = true;
                }
            }
        }
        catch (Exception e) {}
        return result;
    }

    public void ValidateCustomerIndexPopup()
    {
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]", 600);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Customer account index", "Verify Title message");
    }

    public void CustomerIndexPopup() throws InterruptedException
    {
        exists = false;
        WebElement WebEle;
        WebElement Search2;
        String AccNo = TestBase.testEnvironment.get_AnotherAcc();

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }

        new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]")));
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

        // code to click on Addfilter button
        new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]")));
        WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
        HelpersMethod.JScriptClick(driver, AddFilterButton, 1000);

        //Identify the dialog popup
        new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]")));
        new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]")));
        WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");

        //Enter customer account# in input box
        WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
        HelpersMethod.EnterText(driver, Search1, 1000, "Customer #");

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Click on Check box
        new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='CM_CUSTKEY']")));
        WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[@id='CM_CUSTKEY']"));

        HelpersMethod.JScriptClick(driver, WebEle1, 1000);
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Identify radio button and click on Radio button
        new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]")));
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 40);
        WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
        WebElement radioButton = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
        if (radioButton.isDisplayed()) {
            Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            HelpersMethod.EnterText(driver, Search2, 1000, AccNo);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Click on Apply button
            WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button/span[text()='Apply']"));
            new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.elementToBeClickable(ApplyButton));
            HelpersMethod.ClickBut(driver, ApplyButton, 1000);
        }

        if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-no-data']", driver)) {
            scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
        } else {
            WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ActClick(driver, WebEle, 1000);

            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            exists = true;
            String Acc = TestBase.testEnvironment.get_AnotherAcc();
            scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
        }
    }

    public void ValidateOE()
    {
        exists = false;
        try {
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

            if(HelpersMethod.IsExists("//div[@id='web-order-page-content']",driver))
            {
                scenario.log("NAVIGATED TO ORDER ENTRY PAGE");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Scroll_start() throws InterruptedException
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "id", "order-search-card", 20000);
            //HelpersMethod.ScrollElement(driver, driver.findElement(By.id("order-search-card")));
            HelpersMethod.ScrollElement(driver,StartOrder);
            Thread.sleep(1000);
            //HelpersMethod.waitClickableOfEle(driver, StartOrder, 10000);
        }
        catch (Exception e)
        { }
    }

    public void NoPendingOrderPopup()
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
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]", 4000);
                WebElement noPendingOrderPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");

                WebElement startOrder = noPendingOrderPopup.findElement(By.xpath(".//button/span[contains(text(),'Start new order')]"));
                HelpersMethod.ClickBut(driver, startOrder, 10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e) {}
    }

    public void ContinuePendingOrderFromPopup()
    {
        exists = false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]", 10000);
                WebElement noPendingOrderPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");

                WebElement continuePendingOrder = noPendingOrderPopup.findElement(By.xpath(".//button/span[contains(text(),'Continue pending order')]"));
                if (continuePendingOrder.isDisplayed() && continuePendingOrder.isEnabled())
                {
                    HelpersMethod.ClickBut(driver, continuePendingOrder, 10000);
                    scenario.log("CONTINUE PENDING ORDER BUTTON HAS BEEN CLICKED");
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
        }
        catch (Exception e) {}
    }

    public void NO_NotePopup()
    {
        WebElement WebEle;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div/p[1][contains(text(),'Notes')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]", 10000);
                // to fetch the web element
                WebElement notePopup = HelpersMethod.FindByElement(driver, "xpath", "//div/p[1][contains(text(),'Notes')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                //code to click on 'Ok' button in OG popup
                WebElement okButton = notePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver, okButton, 40000);
                scenario.log("NOTE POPUP HAS BEEN HANDLED");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        } catch (Exception e) {}
    }

    public void OrderGuidePopup()
    {
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
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            if (HelpersMethod.IsExists("//div[@id='order-guide-grid']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                // to fetch the web element
                WebElement ogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='order-guide-grid']/ancestor::div[contains(@class,'k-window k-dialog')]");
                //code to click on 'Ok' button in OG popup
                WebElement okButton = ogPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, okButton, 10000);
                scenario.log("ORDER GUIDE POPUP HAS BEEN FOUND");

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
            }
        }
        catch (Exception e) {}
    }

    public void selectOGPopup(String og_Name)
    {
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[@id='order-guide-grid']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                // to fetch the web element
                WebElement ogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='order-guide-grid']/ancestor::div[contains(@class,'k-window k-dialog')]");

                //selecting OG in from popup
                WebElement ogSelect = ogPopup.findElement(By.xpath(".//td[text()='" + og_Name + "']/ancestor::tr"));
                HelpersMethod.ActClick(driver, ogSelect, 10000);

                //code to click on 'Ok' button in OG popup
                WebElement okButton = ogPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver, okButton, 10000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
        }
        catch (Exception e) {}
    }

    //public void NoNotePopHandling(String note)
    public void NoNotePopHandling()
    {
        try
        {
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
            //Check for Note popup
            if(HelpersMethod.IsExists("//div[@id='customerCommentGrid']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                // to fetch the web element
                WebElement notePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customerCommentGrid']/ancestor::div[contains(@class,'k-window k-dialog')]");
                //code to click on 'Ok' button in OG popup
                WebElement okButton = notePopup.findElement(By.xpath(".//button[@id='CustomerCommentDialogOK']"));
                HelpersMethod.ActClick(driver, okButton, 20000);
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
            }
        } catch (Exception e) {}
    }

    //blackout dates
    public void blackoutDialogHandling()
    {
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//p[contains(text(),'Upcoming blackout dates')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']")).click();
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
        }
        catch (Exception e){}
    }

    public void ClickCalender() throws InterruptedException
    {
        exists = false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if(HelpersMethod.IsExists("//div[@class='CPDeliveryDates']/descendant::button/span",driver))
        {
            WebElement deliveryCalender = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='CPDeliveryDates']/descendant::button");
            HelpersMethod.ClickBut(driver, deliveryCalender, 20000);
            new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-view')]/descendant::table[@class='k-calendar-table']")));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-view')]/descendant::table[@class='k-calendar-table']")));
            exists = true;
        }
        Assert.assertEquals(exists, true);
    }

    public void Read_DeliveryDate() throws InterruptedException, ParseException
    {
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

        if (formattedDate == null ||formattedDate.equals(""))
        {
            formattedDate = driver.findElement(By.xpath("//input[contains(@id,'delivery-date-web-order-header-calendar')]")).getAttribute("value");
            //Find the current date and change it's formate
            SimpleDateFormat fromUser1 = new SimpleDateFormat("EEE, MMM d, yyyy");
            SimpleDateFormat fromUser = new SimpleDateFormat("EEEE, MMMM d, yyyy");
            C_Date1 = fromUser.format(fromUser1.parse(formattedDate));
            dateCurrent=fromUser.format(fromUser1.parse(formattedDate));
            scenario.log("<span style='color:red'>DELIBERY DATE FOUND, AFTER LOGGING IN TO APPLICATION  " + C_Date1+"</span>");
        }
    }

    public String Read_DeliveryDate1() throws InterruptedException, ParseException
    {
        String deliveryDate="";
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
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        if (formattedDate != null)
        {
            formattedDate = driver.findElement(By.xpath("//input[contains(@id,'delivery-date-web-order-header-calendar')]")).getAttribute("value");
            deliveryDate=formattedDate.substring(4);
        }
        return deliveryDate;
    }

    public void validateDeliveryDateIsSameAsWhenLoaded()
    {
        try
        {
            String currentDate=HelpersMethod.FindByElement(driver,"id","delivery-date-web-order-header-calendar").getAttribute("value");
            if(!formattedDate.equals(currentDate))
            {
                ValidateOE();
                ClickCalender();
                ResetToCurrentDate();
            }
        }
        catch (Exception e){}
    }

    public void ChangedDeliveryDate()
    {
        exists = false;
        try
        {
            if(HelpersMethod.IsExists("//input[contains(@id,'delivery-date-web-order-header-calendar')]",driver))
            {
                ChangeDate = formattedDate = driver.findElement(By.xpath("//input[contains(@id,'delivery-date-web-order-header-calendar')]")).getAttribute("value");
                exists = true;
                scenario.log("SELECT DELIVERY DATE IS " + ChangeDate);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ResetToCurrentDate() throws InterruptedException
    {
        exists=false;
        WebElement WebEle;
        WebElement CDate;
        try
        {
            scenario.log("PREVIOUS DELIVERY DATE "+C_Date1);
            //click on date, When current date is differnt and delivery date is different, to set the date according to the date shown at the time of loading application
            new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]"))));
            //cod to click on month, if date is not visible in expanded calender
            if(!HelpersMethod.IsExists("//table[@class='k-calendar-table']/descendant::td/span[contains(@title,'" + C_Date1 + "')]",driver))
            {
                String monthToSelect=formattedDate.substring(5,8);
                WebElement monthInCalender=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'k-calendar-title')]");
                HelpersMethod.ClickBut(driver,monthInCalender,10000);
                WebElement toBeSelectMonth=HelpersMethod.FindByElement(driver,"xpath","//table[@class='k-calendar-table']/descendant::span[contains(@title,'"+monthToSelect+"')]");
                HelpersMethod.ClickBut(driver,toBeSelectMonth,10000);
            }
                CDate = HelpersMethod.FindByElement(driver, "xpath", "//table[@class='k-calendar-table']/descendant::td[contains(@style,'opacity:')]/span[contains(@title,'" + C_Date1 + "')]");
                HelpersMethod.ScrollElement(driver, CDate);
                HelpersMethod.ActClick(driver, CDate, 20000);

                for (int i = 0; i <= 3; i++)
                {
                    //Handling Change delivery date Popup
                    if (HelpersMethod.IsExists("//span[text()='Change delivery date' and contains(@class,'k-dialog-title')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement changeDeliveryDate = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Change delivery date' and contains(@class,'k-dialog-title')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                        WebElement ChangeDD = changeDeliveryDate.findElement(By.xpath(".//button/span[text()='Change delivery date']"));
                        HelpersMethod.ActClick(driver, ChangeDD, 10000);
                    }
                    //Handling Warning Popup
                    if (HelpersMethod.IsExists("//span[contains(text(),'Warning')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement warningPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Change delivery date' and contains(@class,'k-dialog-title')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                        WebElement WarningDD = warningPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                        HelpersMethod.ActClick(driver, WarningDD, 10000);
                    }
                    //Warning popup for pending order or to start new order
                    if (HelpersMethod.IsExists("//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement pendingPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        WebEle = pendingPopup.findElement(By.xpath(".//button/span[contains(text(),'Start new order')]"));
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                for (int i = 0; i <= 1; i++)
                {
                    //NOte popup
                    NoNotePopHandling();
                    //OG popup
                    OrderGuidePopup();
                }
                //read the date after changing the delivery date to date found at the time of loading the application
                String resetDate = driver.findElement(By.xpath("//input[contains(@id,'delivery-date-web-order-header-calendar')]")).getAttribute("value");
                scenario.log("DATE HAS BEEN RESET TO "+resetDate);
                SimpleDateFormat fromUser1 = new SimpleDateFormat("EEE, MMM d, yyyy");
                SimpleDateFormat fromUser = new SimpleDateFormat("EEEE, MMMM d, yyyy");
                String resetDateFormatted = fromUser.format(fromUser1.parse(resetDate));
                //Assert.assertEquals(C_Date1,resetDateFormatted);
                if(C_Date1.equals(resetDateFormatted))
                {
                    exists=true;
                }
                Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectDate(int days)
    {
        exists=false;
        WebElement WebEle;
//        Actions act=new Actions(driver);
//        WebElement ele1;
        String formattedDate1 = null;
//        String formattedDate2=null;
//        String formDate1=null;
        WebElement date;
        boolean exists1=false;
        try
        {
            Thread.sleep(1000);
          /*  LocalDate currentDate=LocalDate.now();
            DateTimeFormatter currentFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d,yyyy");
            formattedDate2 = currentDate.format(currentFormatObj);
            scenario.log("TODAY'S DATE IS "+formattedDate2);

            LocalDate myDateObj = LocalDate.now().plusDays(days);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            formattedDate1 = myDateObj.format(myFormatObj);
            DateTimeFormatter myFormObj = DateTimeFormatter.ofPattern("d");
            formDate1=myDateObj.format(myFormObj);
            scenario.log("DATE TO BE CHANGED TO "+formDate1);*/

            //read current date in OE page
            deliveryDate=HelpersMethod.FindByElement(driver,"id","delivery-date-web-order-header-calendar").getAttribute("value");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, MMM d, yyyy", Locale.ENGLISH);
            LocalDate dateTime = LocalDate.parse(deliveryDate, formatter);
            LocalDate dateTime1=dateTime.plusDays(days);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            formattedDate1 = dateTime1.format(myFormatObj);
            System.out.println(formattedDate1);

            //to check whether date is visible in displayed calender
         /*   if(HelpersMethod.IsExists("//td[contains(@style,'opacity:')]/span[@class='k-link' and contains(@title,'" + formattedDate1 +"')]",driver))
            {
                    ele1 = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@style,'opacity:')]/span[@class='k-link' and contains(@title,'" + formattedDate1 + "')]");
                    //HelpersMethod.waitTillElementDisplayed(driver, ele1, 10000);
                    new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@style,'opacity:')]/span[@class='k-link' and contains(@title,'" + formattedDate1 + "')]")));
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ClickBut(driver, ele1, 10000);
                    scenario.log("SKIP DATE IS "+formDate1);
                    exists=true;
            }
            else
            {
                //if the date is not present in visible calender, click on arrow button to navigate to next month
                if (HelpersMethod.IsExists("//button[contains(@class,'k-nav-next')]/span[contains(@class,'k-i-arrow-chevron-right')]", driver))
                {
                    //Click on Arrow in calender, when date has not been found in visible calender
                    WebElement arrow = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'k-nav-next')]/span[contains(@class,'k-i-arrow-chevron-right')]");
                    HelpersMethod.ClickBut(driver, arrow, 10000);
                    if (HelpersMethod.IsExists("//td[contains(@style,'opacity:')]/span[@class='k-link' and contains(@title,'"+formDate1+"')]", driver))
                    {
                        ele1 = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@style,'opacity:')]/span[contains(@title,'" + formDate1 + "')]");
                        HelpersMethod.waitTillElementDisplayed(driver, ele1, 10000);
                        HelpersMethod.JSScroll(driver, ele1);
                        HelpersMethod.ClickBut(driver, ele1, 20000);
                        scenario.log("SKIP DATE IS "+formDate1);
                        exists=true;
                    }
                }
            }*/

            //Code to check for next enabled date
            List<WebElement> dates=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-calendar-tr']/td[contains(@style,'background-color: rgb(151, 199, 119)')]");
            if((dates.size())==1)
            {
                //code to click on month in displayed calendar
                WebElement monthHead=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-calendar-header')]/button");
                HelpersMethod.ActClick(driver,monthHead,10000);
                //code to click on next month name
                Thread.sleep(500);
                WebElement nextMonth=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-calendar-tr']/td[contains(@style,'background-color: rgb(151, 199, 119)')]");
                HelpersMethod.ActClick(driver,nextMonth,10000);

                //code to select first enabled date in the calendar of next month
                dates=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-calendar-tr']/td[contains(@style,'background-color: rgb(151, 199, 119)')]");
                date=dates.get(0);
                HelpersMethod.ActClick(driver,date,10000);
                exists1=CheckForRemoveSkip();
                if(exists1==true)
                {
                    ClickRemoveSkip();
                    RemoveSkipOK();
                }
                exists=true;
            }
            else
            {
                date=dates.get(1);
                HelpersMethod.ActClick(driver,date,10000);
                exists1=CheckForRemoveSkip();
                if(exists1==true)
                {
                    ClickRemoveSkip();
                    RemoveSkipOK();
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);

            Thread.sleep(2000);
            for (int i = 0; i <= 2; i++)
            {
                //Handling Warning Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Changing the delivery date may require repricing the ticket details based on the new delivery date.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement warningPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Changing the delivery date may require repricing the ticket details based on the new delivery date.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                    WebElement WarningDD = warningPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ClickBut(driver, WarningDD, 10000);
                }
                //Handling Change delivery date Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'To change the delivery date for this pending order')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement changeDeliveryDate = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Change delivery date']/ancestor::div[contains(@class,'k-window k-dialog')]");

                    WebElement ChangeDD = changeDeliveryDate.findElement(By.xpath(".//button/span[text()='Change delivery date']"));
                    HelpersMethod.ClickBut(driver, ChangeDD, 10000);
                }

                //Warning popup for pending order or to start new order
                if (HelpersMethod.IsExists("//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement pendingPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                    WebEle = pendingPopup.findElement(By.xpath(".//button/span[contains(text(),'Start new order')]"));
                    HelpersMethod.ActClick(driver, WebEle, 10000);
                }
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        }
        catch (Exception e) {}
    }

    public void selectDateForSkipDate(int days)
    {
        exists=false;
        WebElement WebEle;
//        Actions act=new Actions(driver);
//        WebElement ele1;
        String formattedDate1;
//        String formattedDate2=null;
//        String formDate1=null;
        WebElement date;
        try
        {
            Thread.sleep(1000);

            //read current date in OE page
            deliveryDate=HelpersMethod.FindByElement(driver,"id","delivery-date-web-order-header-calendar").getAttribute("value");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, MMM d, yyyy", Locale.ENGLISH);
            LocalDate dateTime = LocalDate.parse(deliveryDate, formatter);
            LocalDate dateTime1=dateTime.plusDays(days);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            formattedDate1 = dateTime1.format(myFormatObj);
            System.out.println(formattedDate1);

            //Code to check for next enabled date
            List<WebElement> dates=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-calendar-tr']/td[contains(@style,'background-color: rgb(151, 199, 119)')]");
            if((dates.size())<=4)
            {
                //code to click on month in displayed calendar
                WebElement monthHead=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-calendar-header')]/button");
                HelpersMethod.ActClick(driver,monthHead,10000);
                //code to click on next month name
                Thread.sleep(500);
                List<WebElement> nextMonths=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-calendar-tr']/td[contains(@style,'background-color: rgb(151, 199, 119)')]");
                WebElement nextMonth=nextMonths.get(1);
                HelpersMethod.ActClick(driver,nextMonth,10000);

                //code to select first enabled date in the calendar of next month
                dates=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-calendar-tr']/td[contains(@style,'background-color: rgb(151, 199, 119)')]");
                date=dates.get(1);
                HelpersMethod.ActClick(driver,date,10000);
                exists=true;
            }
            else
            {
                date=dates.get(5);
                HelpersMethod.ActClick(driver,date,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);

            Thread.sleep(2000);
            for (int i = 0; i <= 2; i++)
            {
                //Handling Warning Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Changing the delivery date may require repricing the ticket details based on the new delivery date.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement warningPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Changing the delivery date may require repricing the ticket details based on the new delivery date.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                    WebElement WarningDD = warningPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ClickBut(driver, WarningDD, 10000);
                }
                //Handling Change delivery date Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'To change the delivery date for this pending order')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement changeDeliveryDate = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Change delivery date' and contains(@class,'k-dialog-title')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                    WebElement ChangeDD = changeDeliveryDate.findElement(By.xpath(".//button/span[text()='Change delivery date']"));
                    HelpersMethod.ClickBut(driver, ChangeDD, 10000);
                }

                //Warning popup for pending order or to start new order
                if (HelpersMethod.IsExists("//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement pendingPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                    WebEle = pendingPopup.findElement(By.xpath(".//button/span[contains(text(),'Start new order')]"));
                    HelpersMethod.ActClick(driver, WebEle, 10000);
                }
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        }
        catch (Exception e) {}
    }

    //Click on Start order button
    public boolean Start_Order()
    {
        exists = false;
        WebElement WebEle;
        String status;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            //code to check delivery date is not having any cutoff, if yes, change the date to some other delivery date and click on start button
//            ClickCalender();
//            List<WebElement> deliveryDates=HelpersMethod.FindByElements(driver,"xpath","//td[contains(@style,'background-color: rgb')]");
//            for(WebElement deliveryDate:deliveryDates)
//            {
//               HelpersMethod.ActClick(driver,deliveryDate,20000);
//               //Thread.sleep(500);
               if (HelpersMethod.IsExistsById("addButton", driver) && !HelpersMethod.IsExists("//button[@id='addButton' and contains(@class,'disabled')]",driver))
                {
                  HelpersMethod.ScrollElement(driver, SearchOrder);
                  HelpersMethod.ClickBut(driver, StartOrder, 10000);
                  scenario.log("START BUTTON HAS BEEN CLICKED");
                  status = HelpersMethod.returnDocumentStatus(driver);
                  if (status.equals("loading"))
                  {
                      HelpersMethod.waitTillLoadingPage(driver);
                  }
                  exists = true;
                }
                else
                {
                   //If start button is not enabled either skip is enabled or cutoff date has been reached
                   ClickCalender();
                   ChangedDeliveryDate();
                   SelectDate(1);
                   HelpersMethod.ScrollElement(driver, SearchOrder);
                   HelpersMethod.ClickBut(driver, StartOrder, 10000);
                   status = HelpersMethod.returnDocumentStatus(driver);
                   if (status.equals("loading"))
                   {
                       HelpersMethod.waitTillLoadingPage(driver);
                   }
                   exists = true;
               }
           // }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {}
        return exists;
    }

    public boolean Start_OrderForAdmin()
    {
        exists = false;
        WebElement WebEle;
        String status = "";
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            //code to check delivery date is not having any cutoff, if yes, change the date to some other delivery date and click on start button
            ClickCalender();
            List<WebElement> deliveryDates=HelpersMethod.FindByElements(driver,"xpath","//td[contains(@style,'background-color: rgb')]");
            for(WebElement deliveryDate:deliveryDates)
            {
                HelpersMethod.ActClick(driver,deliveryDate,20000);
                //Thread.sleep(500);
                if (HelpersMethod.IsExistsById("addButton", driver) && StartOrder.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver, SearchOrder);
                    HelpersMethod.ClickBut(driver, StartOrder, 10000);
                    scenario.log("START BUTTON HAS BEEN CLICKED");
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    exists = true;
                    break;
                }
//                else
//                {
//                   //If start button is not enabled either skip is enabled or cutoff date has been reached
//                   ClickCalender();
//                   ChangedDeliveryDate();
//                   SelectDate(1);
//                   HelpersMethod.ScrollElement(driver, SearchOrder);
//                   HelpersMethod.ClickBut(driver, StartOrder, 10000);
//                   status = HelpersMethod.returnDocumentStatus(driver);
//                   if (status.equals("loading"))
//                   {
//                       HelpersMethod.waitTillLoadingPage(driver);
//                   }
//                   exists = true;
//               }
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {}
        return exists;
    }




    public boolean Start_OrderAgain()
    {
        exists = false;
        WebElement WebEle;
        String status = "";
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            WebEle = HelpersMethod.FindByElement(driver, "id", "addButton");
            HelpersMethod.JScriptClick(driver, WebEle, 10000);
            scenario.log("START ORDER HAS BEEN CLICKED");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
        return exists;
    }

    public void SkipVisible_Click(String reason)
    {
        exists = false;
        Actions act1=new Actions(driver);
        try
        {
            WebElement WebEle;
            //Navigate back to Order Entry page
            if (HelpersMethod.IsExists("//label[contains(text(),'New order')]/ancestor::div[contains(@class,'i-card order-entry-card')]", driver))
            {
                driver.navigate().back();
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }

            if (!HelpersMethod.IsExists("//button/span[contains(text(),'Remove Skip')]", driver))
            {
                HelpersMethod.ClickBut(driver, SkipButton, 10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Skip']/ancestor::div[contains(@class,'k-window k-dialog')]"))));
                if (HelpersMethod.IsExists("//span[text()='Skip']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {

                    WebElement skipPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                    //Identify the skip reason drop down
                    WebEle = skipPopup.findElement(By.xpath(".//span[@id='SkipReason']/descendant::button"));
                    HelpersMethod.ActClick(driver, WebEle, 10000);
                    HelpersMethod.WaitElementPresent(driver, "xpath", "//ul[@id='SkipReason-listbox-id']/li/span", 20000);
                    String Opt;
                    String Opt1;
                    String Opt2;
                    Opt1= reason.toLowerCase();
                    // to fetch the web element of the modal container
                    List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='SkipReason-listbox-id']/li/span");
                    for(WebElement option: Options)
                    {
                        act1.moveToElement(option).build().perform();
                        Opt=option.getText();
                        Opt2=Opt.toLowerCase();
                        if(Opt2.contains(Opt1))
                        {
                            act1.moveToElement(option).build().perform();
                            act1.click(option).build().perform();
                            break;
                        }
                    }
                    WebElement okButton=skipPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver,okButton,10000);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                }
            }
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public boolean CheckForRemoveSkip()
    {
        exists = false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
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
            HelpersMethod.ScrollElement(driver, RemoveSkip);
            //Check for existence of Remove Skip button
            if (HelpersMethod.IsExists("//button/span[text()='Remove Skip']", driver))
            {
                exists = true;
                scenario.log("REMOVE SKIP HAS BEEN FOUND");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
        return exists;
    }

    public void ClickRemoveSkip()
    {
        WebElement WebEle;
        exists = false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            HelpersMethod.ScrollElement(driver, RemoveSkip);
            //Check for Remove skip, and click on it
            if (HelpersMethod.IsExists("//button/span[text()='Remove Skip']", driver))
            {
                HelpersMethod.ScrollElement(driver, RemoveSkip);
                HelpersMethod.ClickBut(driver, RemoveSkip, 10000);
                exists = true;
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(HelpersMethod.IsExists("//div[contains(text(),'Remove Skip for this date?')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=modelContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver,okButton,20000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void RemoveSkipOK()
    {
        exists = false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//span[contains(text(),'Remove Skip')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement removeSkipPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebElement removeSkip = removeSkipPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver, removeSkip, 10000);
                scenario.log("REMOVESKIP POPUP HAS BEEN HANDLED");
                exists = true;

               wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public boolean CheckForSkip()
    {
        exists = false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//button/span[text()='Skip']", driver))
            {
                HelpersMethod.ScrollElement(driver, Skip);
                exists = true;
                scenario.log("SKIP BUTTON FOUND");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
        return exists;
    }

    public void Click_HistoryButton()
    {
        WebElement WebEle;
        exists = false;
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

        try
        {
            HelpersMethod.ScrollElement(driver, HistoryButton);
            HelpersMethod.ClickBut(driver, HistoryButton, 10000);
            exists = true;
            scenario.log("ORDER HISTORY BUTTON HAS BEEN CLICKED");
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Enter_OrderNo_Searchbox(String Order_No)
    {
        exists = false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            scenario.log("ORDER NUMBER I AM SEARCHING FOR IS "+Order_No);
            HelpersMethod.ScrollElement(driver, SearchOrder);
            HelpersMethod.EnterText(driver, SearchOrder, 10000, Order_No);
            HelpersMethod.ClickBut(driver, SearchIndex, 10000);
            exists = true;
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void Existence_OrderNo_OG()
    {
        boolean result = false;
        try
        {
            if (!HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]", driver))
            {
                result = true;
                scenario.log("ORDER HAS NOT BEEN FOUND IN ORDER GRID");
            }
            Assert.assertEquals(result, true);
        }
        catch (Exception e) {}
    }

    public void Existence_OrderNo_OG1()
    {
        boolean result = false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]", driver))
            {
                scenario.log("SEARCH IS SUCCESSFULL");
                result = true;
            }
            else
            {
                scenario.log("SEARCH IS NOT SUCCESSFULL");
            }
            Assert.assertEquals(result, true);
        }
        catch (Exception e) {}
    }

    public void Select_Order_OrdersGrid()
    {
        WebElement WebEle;
        exists = false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]/descendant::td/button", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::td/button");
                HelpersMethod.ClickBut(driver, WebEle, 10000);
                scenario.log("ORDER GUIDE OPTION HAS BEEN SELECTED");
                exists=true;
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Click_DropDown()
    {
        exists = false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            WebElement WebEle = driver.findElement(By.id("order-search-card"));
            HelpersMethod.ScrollElement(driver, WebEle);
            if(DropDown.isDisplayed() && DropDown.isEnabled())
            {
                HelpersMethod.ClickBut(driver, DropDown, 20000);
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='addButton_dropdown-accessibility-id']/li")));
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='addButton_dropdown-accessibility-id']/li")));
                exists=true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Select_Par_Order()
    {
        exists = false;
        String optionText="";
        Actions act1=new Actions(driver);
        try
        {
            List<WebElement> options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='addButton_dropdown-accessibility-id']/li");
            for(WebElement opt:options)
            {
                act1.moveToElement(opt).build().perform();
                optionText=opt.getText();
                if(optionText.equals("Par ordering"))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists = true;
                    scenario.log("PAR ORDER OPTION HAS BEEN SELECTED");
                    break;
                }
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void SelectQuote()
    {
        exists = false;
        Actions act1=new Actions(driver);
        String optionText;
        try
        {
            List<WebElement> options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='addButton_dropdown-accessibility-id']/li/descendant::span[@class='k-menu-link-text']");
            for(WebElement opt:options)
            {
                act1.moveToElement(opt).build().perform();
                optionText=opt.getText();
                if(optionText.equals("Quote"))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists = true;
                    scenario.log("QUOTE OPTION HAS BEEN SELECTED");
                    break;
                }
            }
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
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //For creating customer notes
    public void click_On_CustomerNotes()
    {
        exists = false;
        String status;
        WebElement WebEle;
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            Actions act = new Actions(driver);
            act.moveToElement(CustomerNote);
            act.click(CustomerNote).build().perform();
            scenario.log("CUSTOMER NOTE ICON HAS BEEN CLICKED");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //Verify for Customer note popup
    public void Validate_Customer_Note()
    {
        exists=false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Enter customer note in customer note popup in notetext area
    public void Add_Customer_Note(String notes)
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@id='customerNotesDialog']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebElement noteArea = vallidateNotePopup.findElement(By.xpath(".//textarea[@id='noteTextbox']"));
                HelpersMethod.ActSendKey(driver, noteArea, 10000, notes);
                exists=true;
                scenario.log("CUSTOMER NOTES ENTERED IS: "+notes);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Alert type in customer note
    public void Select_AlertType_Location(String AltertType, String Altertloc1, String Alertloc2)
    {
        exists=false;
        try
        {
            WebElement WebEle;
            //Finding Customer notes popup
            if (HelpersMethod.IsExists("//div[@id='customerNotesDialog']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                //code to select alert type
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebEle = vallidateNotePopup.findElement(By.xpath(".//span[@id='AlertType']"));
                HelpersMethod.ClickBut(driver, WebEle, 10000);
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]"))));
                HelpersMethod.DropDownMenu(driver, AltertType);
                scenario.log("ALERT TYPE SELECTED IS: "+AltertType);

                //code to select alert location
                List<WebElement> AlertLocations = vallidateNotePopup.findElements(By.xpath(".//input[@class='k-checkbox']/following-sibling::label"));
                int i = 0;
                for (WebElement AlertLoc : AlertLocations)
                {
                    i++;
                    String AlertLoc_Text = AlertLoc.getText();
                    if (AlertLoc_Text.equals(Altertloc1) || AlertLoc_Text.equals(Alertloc2))
                    {
                        WebEle = vallidateNotePopup.findElement(By.xpath(".//div[contains(@class,'col-md-3 col-xs-12')][" + i + "]/descendant::input"));
                        HelpersMethod.JScriptClick(driver, WebEle, 10000);
                        exists=true;
                        scenario.log("ALERT LOCATION SELECTED");
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Save and Ok button handling in customer note popup
    public void Save_Note_Button()
    {
        exists=false;
        try
        {
            WebElement WebEle;
            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customerNotesDialog']/ancestor::div[contains(@class,'k-window k-dialog')]");
            WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='SaveButton']"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ActClick(driver, WebEle, 10000);
            exists=true;

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists,true);
            Ok_Note_Button();
            Thread.sleep(4000);
        }
        catch (Exception e) {}
    }

    public void Ok_Note_Button()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customerNotesDialog']/ancestor::div[contains(@class,'k-window k-dialog')]");
            WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='CustomerCommentDialogOK']"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ActClick(driver, WebEle, 10000);

            exists=true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Creating list of customer note in customer note grid and select one of the note
    public void Select_Customer_Note(String cust_Note)
    {
        WebElement WebEle = null;
        exists = false;
        try
        {
            int i = 0;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Read all the note from the grid
            java.util.List<WebElement> Notes = driver.findElements(By.xpath("//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr/td[3]"));
            for (WebElement Note : Notes)
            {
                i++;
                String Note_Text = Note.getText();
                if (Note_Text.equals(cust_Note))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr[" + i + "]/td[3]");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    exists = true;
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    scenario.log("CUSTOMER NOTE HAS BEEN SELECTED");
                    break;
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //Click on Copy button in Customer note popup
    public void Click_Copy_CustomerNote()
    {
        exists = false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customerNotesDialog']/ancestor::div[contains(@class,'k-window k-dialog')]");
            WebElement WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='copyNote']"));
            HelpersMethod.ActClick(driver, WebEle, 10000);
            exists = true;

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            scenario.log("COPY CUSTOMER NOTE BUTTON HAS BEEN CLICKED");
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //Method for pickup order
    public void Pickup_Order()
    {
        Actions act1=new Actions(driver);
        exists = false;
        String optionText;
        try
        {
            List<WebElement> options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='addButton_dropdown-accessibility-id']/li/descendant::span[@class='k-menu-link-text']");
            for(WebElement opt:options)
            {
                act1.moveToElement(opt).build().perform();
                optionText=opt.getText();
                if(optionText.equals("Pick up order"))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists = true;
                    scenario.log("PICKUP ORDER OPTION HAS BEEN SELECTED");
                    break;
                }
            }
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
        catch (Exception e) {}
    }

    //Code for handling Delivery date for pickup order
    public void SelectPickupOrderDeliveryDate(String dDate)
    {
        exists = false;
        WebElement WebEle;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Check for existence of Select delivery date popup
            if (HelpersMethod.IsExists("//span[contains(text(),'Select pickup date')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
               /* WebElement deliveryDatePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Select pickup date')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebEle = deliveryDatePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/td"));
                WebEle1=deliveryDatePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/td/span[@class='line2']"));
                scenario.log("DATE SELECTED FOR PICK UP ORDER IS "+WebEle1.getText());
                //Click on first date in Select delivery date popup
                HelpersMethod.ClickBut(driver, WebEle, 10000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }*/

                //find list of dates in pickup order
                WebElement deliveryDatePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]/td/span[@class='line2' and contains(text(),'"+dDate+"')]",driver))
                {
                    WebEle = deliveryDatePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]/td/span[@class='line2' and contains(text(),'"+dDate+"')]"));
                    scenario.log("DATE SELECTED FOR PICK UP ORDER IS " + WebEle.getText());
                    //Click on first date in Select delivery date popup
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                else
                {
                    WebEle = deliveryDatePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/td/span[@class='line2']"));
                    scenario.log("DATE SELECTED FOR PICK UP ORDER IS " + WebEle.getText());
                    //Click on first date in Select delivery date popup
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
        }
        catch (Exception e) {}
    }

    //Code for deleting customer note
    public void Select_Customer_Note_Del(String cust_Note)
    {
        exists = false;
        try
        {
            int i = 0;
            WebElement WebEle;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Read all the note from the grid
            List<WebElement> Notes = driver.findElements(By.xpath("//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr/td[3]"));
            for (WebElement Note : Notes)
            {
                i++;
                String Note_Text = Note.getText();
                if (Note_Text.equals(cust_Note))
                {
                    //Select the note
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr[" + i + "]/td[3]");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    //Delete the note
                    WebEle = HelpersMethod.FindByElement(driver, "id", "deleteNote");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    scenario.log("DELETE BUTTON IN CUSTOMER NOTE HAS BEEN CLICKED");
                    exists = true;
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    break;
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //For reset button functionality in cusomter note popup
    public void ReSet_Button()
    {
        exists = false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            WebElement Button_Ele = HelpersMethod.FindByElement(driver, "id", "resetNote");
            HelpersMethod.ClickBut(driver, Button_Ele, 10000);
            exists = true;
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            scenario.log("RESET BUTTON IN CUSTOMER NOTE POPUP HAS BEEN CLICKED");
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public String validateRouteValue()
    {
        String rNo="";
        try
        {
            WebElement routeEle=HelpersMethod.FindByElement(driver,"id","RouteIndex");
            rNo=HelpersMethod.JSGetValueEle(driver,routeEle,10000);
        }
        catch (Exception e){}
        return rNo;
    }

    //click on route index button
    public void clickRouteIndex()
    {
        exists=false;
        WebElement WebEle;
        exists = false;
        String routeChange=null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        try
        {
            //Click on Index icon next to Route#
            WebElement route_No = HelpersMethod.FindByElement(driver, "xpath", "//label[contains(@id,'RouteIndex-label')]/following-sibling::div/descendant::button");
            HelpersMethod.ClickBut(driver, route_No, 10000);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@id='RouteIndexProvider']/ancestor::div[contains(@class,'k-window k-dialog')]", 200000);
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
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Selcting route from the index popup
    public void Route_No(String SearchOpt, String SearchDetail)
    {
        exists=false;
        String status;
        WebElement Clear;
        try
        {
                scenario.log("SEARCH SCENARIO FOR ROUTE"+SearchOpt+" AND "+SearchDetail);

                //Click on Add filter
                WebElement addFilter = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::span[contains(text(),'Add filter')]");
                HelpersMethod.ActClick(driver, addFilter, 10000);
                new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-shown')]")));
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-shown')]", 10000);

                //Enter filter values in drop down
                WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-shown')]");
                WebElement search1 = modalContainer1.findElement(By.xpath(".//input[@class='i-search-box__input']"));
                HelpersMethod.JSSetValueEle(driver, search1, 10000, SearchOpt);
                Thread.sleep(1000);
                //Click on check box
                WebElement checkBox = driver.findElement(By.xpath(".//input[@id='code']"));
                HelpersMethod.ActClick(driver, checkBox, 10000);

                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
                new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));

                Thread.sleep(1000);
                //Enter 2nd search value
                modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]");
                WebElement search2 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-input k-input-md k-rounded-md k-input-solid')]"));
                HelpersMethod.EnterText(driver, search2, 10000, SearchDetail);
                //click on apply button
                WebElement apply = modalContainer1.findElement(By.xpath(".//button/span[text()='Apply']"));
                HelpersMethod.ActClick(driver, apply, 10000);
                //Select route in dialog box
                WebElement routeValue = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]");
                HelpersMethod.ActClick(driver, routeValue, 10000);

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
                WebElement routeCha = HelpersMethod.FindByElement(driver, "id", "RouteIndex");
                //routeCha.sendKeys(Keys.TAB);
                String routeChange = HelpersMethod.JSGetValueEle(driver, routeCha, 10000);
                scenario.log("ROUTE FOUND IN INPUT BOX IS " + routeChange);
                if (routeChange.equalsIgnoreCase(TestBase.testEnvironment.get_Route()) || routeChange.contains(TestBase.testEnvironment.get_Route()))
                {
                    scenario.log("ROUTE SELECTED IS " + routeChange);
                    exists = true;
                }
                if (HelpersMethod.IsExists("//div[@id='toast-container']", driver))
                {
                    new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
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

    //Click on Route index icon
    public void Route_Popup()
    {
        exists = false;
        try
        {
            HelpersMethod.ClickBut(driver, RouteOE, 10000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    //Click on 1st route in popup
    public void Route1()
    {
        exists = false;
        try
        {
            if (HelpersMethod.IsExists("//span[contains(text(),'Route #')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='RouteIndexProvider']/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver, WebEle, 10000);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public String salesRep()
    {
        WebElement WebEle;
        Actions act=new Actions(driver);
        exists = false;
        String saleRepChange ="";
        int i=0;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        try
        {
            //Click on Index icon next to Sales rep
            WebElement salesRep = HelpersMethod.FindByElement(driver, "xpath", "//label[contains(@id,'SalesRepIndex-label')]/following-sibling::div/descendant::button");
            HelpersMethod.ClickBut(driver, salesRep, 10000);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//span[text()='Sales rep']/ancestor::div[contains(@class,'k-window k-dialog')]", 200000);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Sales rep", "Verify Title message");

            //Selecting sales rep
            List<WebElement> saleRep=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td[2]");
            for(WebElement sRep:saleRep)
            {
                i++;
                act.moveToElement(sRep).build().perform();
                saleRepChange=sRep.getText();
                if(!saleRepChange.equalsIgnoreCase("None"))
                {
                    WebElement sale=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]["+i+"]");
                    act.moveToElement(sale).build().perform();
                    act.click(sale).build().perform();
                    break;
                }
            }

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

            //Read the Sales rep value
            Thread.sleep(2000);
            WebElement salRep=HelpersMethod.FindByElement(driver,"id","SalesRepIndex");
            salRep.sendKeys(Keys.TAB);
            String saleChange=HelpersMethod.JSGetValueEle(driver,salRep,2000);
            if(saleChange!="None")
            {
                scenario.log("SALES REP SELECTED IS "+saleChange);
                exists = true;
            }
            if(HelpersMethod.IsExists("//div[@id='toast-container']",driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
            }
            Thread.sleep(6000);
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
        return saleRepChange;
    }




    //Code to select OG from popup
    public void SelectOrderGuidePopup()
    {
        try
        {
            if (HelpersMethod.IsExists("//span[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement orderGuidePopup = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                //code to select OG from popup
                WebElement OgSelect = orderGuidePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ActClick(driver, OgSelect, 10000);
                //Code to read name of OG
                String OGDis = orderGuidePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/descendant::td[1]")).getText();
                //code to click ok button in popup
                WebElement Orderguide = orderGuidePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver, Orderguide, 10000);
                scenario.log("OG HAS BEEN SELECTED POPUP " + OGDis);
            }
            else
            {
                scenario.log("OG POPUP HAS NOT APPEARED");
            }
        }
        catch (Exception e) {}
    }

    public void Click_On_UserIcon() throws InterruptedException
    {
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]", 2400);
            WebElement UserIcon = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]");
            new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]"))));
            HelpersMethod.JScriptClick(driver, UserIcon, 8000);

            exists = true;
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative popup-with-arrow standard-view user-info k-animation-container-shown')]"))));
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Click_On_Signout() throws InterruptedException
    {
        try
        {
            exists = false;
            WebElement WebEle;
            WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/div[@class='popup-content']");
            WebElement signOut = dropDown.findElement(By.xpath(".//div[contains(@class,'user-info-line user-info-line-signout')]"));
            HelpersMethod.ActClick(driver, signOut, 10000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            HelpersMethod.waitTillTitleContains(driver, "Login", 1000);
            String title = driver.getTitle();
            if (title.equals("Login"))
            {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void SearchBoxAction(String Quote)
    {
        exists = false;
        try
        {
            if (SearchOrder.isDisplayed())
            {
                HelpersMethod.EnterText(driver, SearchOrder, 10000, Quote);
                HelpersMethod.ActClick(driver, SearchIndex, 10000);
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            else
            {
                scenario.log("SEARCH BOX IS NOT VISIBLE");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ValidateQuoteOrder(String Ord_No)
    {
        exists = false;
        WebElement WebEle;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[@class='i-link-button ']");
            String O_No = WebEle.getText();
            if (O_No.equals(Ord_No))
            {
                scenario.log("ORDER/QUOTE HAS BEEN FOUND");
                exists = true;
            }
            else
            {
                scenario.log("ORDER/QUOTE HAS NOT BEEN FOUND");
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void ClickOnQuote()
    {
        exists = false;
        try
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::button[@class='i-link-button ']");
           if(WebEle.isDisplayed() && WebEle.isEnabled())
           {
               HelpersMethod.ScrollTillElementVisible(driver,WebEle);
               HelpersMethod.ClickBut(driver, WebEle, 20000);
               if(HelpersMethod.IsExists("//div[@class='loader']",driver))
               {
                   WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                   HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
               }
               String status = HelpersMethod.returnDocumentStatus(driver);
               if (status.equals("loading"))
               {
                   HelpersMethod.waitTillLoadingPage(driver);
               }
               scenario.log("QUOTE HAS BEEN SELECTED");
               exists = true;
           }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void ParOrderPopup()
    {
        exists = false;
        WebElement WebEle;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(250))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            if (HelpersMethod.IsExists("//div[@id='order-guide-grid']/ancestor::div[@class='k-widget k-window k-dialog']", driver))
            {
                WebElement orderGudides = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                //Select 1st OG from the popup, automatically it will selet 1st par order in the popup
                WebEle = orderGudides.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ActClick(driver, WebEle, 10000);

                //Select first par order from the popup
                new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='par-list-grid']/ancestor::div[@class='k-widget k-window k-dialog']"))));
                WebElement parList = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-widget k-window k-dialog']");
                //WebElement parSelect = parList.findElement(By.xpath(".//div[@id='par-list-grid']/descendant::tr[contains(@class,'k-master-row')][1]"));
                WebElement parText = parList.findElement(By.xpath(".//div[@id='par-list-grid']/descendant::tr[contains(@class,'k-master-row')][1]/td"));
                scenario.log("PAR LIST SELECTED IS: " + parText.getText());
                //HelpersMethod.ActClick(driver, parSelect, 10000);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(250))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            else
            {
                scenario.log("MAY BE THERE IS ONLY ONE OG/PAR LIST, WHICH WILL BE BY DEFAULT ADDED TO OE");
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ParOrderPopupOk()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
            HelpersMethod.ActClick(driver, WebEle, 10000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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

            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ValidatingTodaysDate() throws ParseException
    {
        exists = false;
        WebElement WebEle;
        String CurrentDate ="";

        //Check for existence of Select delivery date popup
        if (HelpersMethod.IsExists("//span[contains(text(),'Select pickup date')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
        {
            WebElement selectDeliveryDate=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Select pickup date')]/ancestor::div[contains(@class,'k-window k-dialog')]");
            List<WebElement> DeliveryDates = selectDeliveryDate.findElements(By.xpath(".//table[contains(@class,'k-grid-table')]/descendant::span[@class='line2']"));
            for (WebElement DeliveryDate : DeliveryDates)
            {
                scenario.log("DELIVERY DATES DISPLAYED IN POPUP " + DeliveryDate.getText());
            }

           //Converting the Current delivery date formate to
            SimpleDateFormat fromUser1 = new SimpleDateFormat("MMM d, yyyy");
            SimpleDateFormat fromUser = new SimpleDateFormat("EEEE, MMMM d, yyyy");
            String formattedDate = fromUser1.format(fromUser.parse(C_Date1));

            //Comparting system date with date in popup
            WebEle = DeliveryDates.get(0);
            CurrentDate = WebEle.getText();
            scenario.log("FIRST DATE FOR PICKUP ORDER, IN POPUP IS " + CurrentDate);
            if (CurrentDate.equals(formattedDate))
            {
                scenario.log("DATE SAME AS OF DELIVERY DATE HAS BEEN FOUND IN PICKUP ORDER DELIVER DATE POPUP.....PLEASE CHECK ADMIN SETTINGS " + WebEle.getText());
                exists = true;
            }
            else
            {
                scenario.log("DATE SAME AS OF DELIVERY DATE HAS NOT BEEN FOUND IN PICKUP ORDER DELIVERY DATE POPUP");
            }
            Assert.assertEquals(exists, true);
        }
    }

    public void RemoveRoute()
    {
        exists = false;
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

            if(HelpersMethod.IsExists("//input[@id='RouteIndex']/following-sibling::span[@class='k-clear-value']",driver))
            {
                WebElement routeEle=HelpersMethod.FindByElement(driver,"xpath","//div[@data-test-id='RouteIndex']");
                HelpersMethod.ScrollElement(driver,routeEle);
                WebElement RouteRemove = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='RouteIndex']");
                RouteRemove.sendKeys("");
                String s = Keys.chord(Keys.CONTROL, "a");
                RouteRemove.sendKeys(s);
                RouteRemove.sendKeys(Keys.DELETE);
                //Code to clear route input box
                //WebElement clearRoute=HelpersMethod.FindByElement(driver,"xpath","//label[@id='RouteIndex-label']/following-sibling::div/descendant::span[contains(@class,'k-clear-value k-i-close')]");
                //HelpersMethod.ActClick(driver,clearRoute,10000);
                exists = true;
                scenario.log("ROUTE VALUE HAS BEEN REMOVED");
            }
            Thread.sleep(1000);
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void RouteIsEmpty()
    {
        exists = false;
        try
        {
            if(HelpersMethod.IsExists("//input[@id='RouteIndex']",driver))
            {
                String RouteValue = HelpersMethod.JSGetValueEle(driver, RouteInput, 10000);
                if (RouteValue.equals(""))
                {
                    scenario.log("ROUTE VALUE IS EMPTY");
                    exists = true;
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ValidateRouteMandatoryPopup()
    {
        exists = false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                scenario.log("ROUTE NUMBER MANDATORY POPUP DISPLAYED");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void RoutePopup()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement routeNumberPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                WebEle = routeNumberPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, WebEle, 10000);
                scenario.log("ROUTE NUMBER REQUIRED POPUP HAS BEEN HANDLED");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void changeDeliveryDateToStandingOrderSkip(String date1) throws InterruptedException
    {
        exists = false;
        String status ="";
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[@id='delivery-date-web-order-header-calendar-popup-id']", 10000);
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@id='delivery-date-web-order-header-calendar-popup-id']", 10000);
        WebElement fromDateContainer = driver.findElement(By.xpath("//table[@class='k-calendar-table']"));
        WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td/span[contains(@title,'" + date1 + "')]"));
        new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.elementToBeClickable(ele1));
        HelpersMethod.JSScroll(driver, ele1);
        HelpersMethod.JScriptClick(driver, ele1, 10000);

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
    }

    public void readSOSkipDateInOE()
    {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        //Reading changed delivery date
        WebElement changedDate = HelpersMethod.FindByElement(driver, "id", "delivery-date-web-order-header-calendar");
    }

    public void selecteCommerceOption() throws InterruptedException
    {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Click on question mark
        WebElement questionMark = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M11,18h')]");
        HelpersMethod.ActClick(driver, questionMark, 10000);
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 2000);
        WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
        WebElement eCommerce = dropDown.findElement(By.xpath("//div[contains(@class,'help-links-line ecommerce-link')]"));
        String ParentWindow = driver.getWindowHandle();

        eCommerce = dropDown.findElement(By.xpath("//div[contains(@class,'help-links-line ecommerce-link')]"));
        HelpersMethod.ActClick(driver, eCommerce, 10000);
        Thread.sleep(2000);
        Set<String> PCWindows = driver.getWindowHandles();
        for (String PCwind : PCWindows)
        {
            if (!PCwind.equals(ParentWindow))
            {
                driver.switchTo().window(PCwind);
                driver.close();
                exists = true;
                scenario.log("eCOMMERCE HELP BUTTON HAS BEEN HANDLED");
            }
        }
        Assert.assertEquals(exists, true);
        driver.switchTo().window(ParentWindow);
    }

    public void clickQuestionMark()
    {
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Click on question mark
            String ParentWindow = driver.getWindowHandle();
            WebElement questionMark = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M11,18h')]");
            HelpersMethod.ActClick(driver, questionMark, 10000);
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 600);
        }
        catch (Exception e){}
    }

    public void selectSaleshelp() throws InterruptedException
    {
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Click on question mark
            String ParentWindow = driver.getWindowHandle();
            WebElement questionMark = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M11,18h')]");
            HelpersMethod.ActClick(driver, questionMark, 10000);
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 600);
            WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
            WebElement salesHelp = dropDown.findElement(By.xpath("//div[contains(@class,'help-links-line sales-link')]"));

            HelpersMethod.ActClick(driver, salesHelp, 6000);
            Thread.sleep(2000);
            Set<String> PCWindows = driver.getWindowHandles();
            for (String PCwind : PCWindows)
            {
                if (!PCwind.equals(ParentWindow))
                {
                    driver.switchTo().window(PCwind);
                    driver.close();
                    exists = true;
                    scenario.log("SALES HELP HAS BEEN HANDELED");
                }
            }
            Assert.assertEquals(exists, true);
            driver.switchTo().window(ParentWindow);
        }
        catch (Exception e) {}
    }

    public void orderTypeClick()
    {
        try
        {
            WebElement ordType = HelpersMethod.FindByElement(driver, "xpath", "//label[@id='OrderTypeIndex-label']/following-sibling::div/button");
            HelpersMethod.ClickBut(driver, ordType, 10000);
        }
        catch (Exception e) {}
    }

    public void selectRegularOrder(String s, String s1)
    {
        exists=false;
        String status;
        try
        {
            //Clear all regular order type
            WebElement orderTypeClear=HelpersMethod.FindByElement(driver,"xpath","//input[@id='OrderTypeIndex']/following-sibling::span[@class='k-clear-value']//*[local-name()='svg']");
            HelpersMethod.JScriptClick(driver,orderTypeClear,20000);

            //Enter order type in input box
            WebElement orderType=HelpersMethod.FindByElement(driver,"xpath","//input[@id='OrderTypeIndex']");
            HelpersMethod.JSSetValueEle(driver,orderType,20000,s1);

            WebElement orderTypeContent=HelpersMethod.FindByElement(driver,"xpath","//input[@id='OrderTypeIndex']");
            String orderTypeText=HelpersMethod.JSGetValueEle(driver,orderTypeContent,20000);
            if(orderTypeText.contains("Regular Order"))
            {
                exists=true;
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void verifySkipButton()
    {
        exists=false;
        try
        {
            WebElement skipButton=HelpersMethod.FindByElement(driver,"id","skipButton");
            if(skipButton.isDisplayed())
            {
                scenario.log("SKIP BUTTON IS VISIBLE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnInfoIcon()
    {
        exists=false;
        try
        {
            if(AddressIcon.isDisplayed() && AddressIcon.isEnabled())
            {
                HelpersMethod.ClickBut(driver, AddressIcon,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateInfoDialogBox()
    {
        exists=false;
        try
        {
            Thread.sleep(1000);
            if(HelpersMethod.IsExists("//div[contains(text(),'Contact information')]/ancestor::div[contains(@class,'i-content-holder-popup--custom k-animation-container-shown')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readShippingAddress()
    {
        exists=false;
        try
        {
            WebElement address=HelpersMethod.FindByElement(driver,"xpath","//td[contains(@class,'order-header-popup__table__left')]/div[1]");
            scenario.log("ADDRESS FOUND IS "+address.getText());
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void validateVisiblityOfPrivacyPolicy()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//a[contains(text(),'Privacy policy')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnPrivacyPolicy()
    {
        exists=false;
        try
        {
            ParentWindow = driver.getWindowHandle();
            WebElement privacyLink=HelpersMethod.FindByElement(driver,"xpath","//a[contains(text(),'Privacy policy')]");
            HelpersMethod.ScrollDownScrollBar(driver);
            HelpersMethod.ActClick(driver,privacyLink,10000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void handlePrivacyPolicy()
    {
        exists=false;
        try
        {
            Set<String> PCWindows = driver.getWindowHandles();
            Thread.sleep(2000);
            for (String PCwind : PCWindows)
            {
                if (!PCwind.equals(ParentWindow))
                {
                    driver.switchTo().window(PCwind);
                    scenario.log("PRIVACY POLICY LINK HAS BEEN FOUND");
                    driver.close();
                    exists = true;
                    scenario.log("PRIVACY POLICY WINDOW HAS BEEN HANDLED");
                }
                driver.switchTo().window(ParentWindow);
            }
        }
        catch (Exception e){}
    }

    public void lastPickupOrder()
    {
        exists = false;
        WebElement WebEle;
        Actions act1=new Actions(driver);
        try
        {
            //Check for existence of Select delivery date popup
            if (HelpersMethod.IsExists("//span[contains(text(),'Select pickup date')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement pickDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                List<WebElement> dates=pickDate.findElements(By.xpath(".//tr[contains(@class,'k-master-row')]/td"));
                for (int i=0;i<=dates.size()-1;i++)
                {
                    act1.moveToElement(dates.get(i)).build().perform();
                    if(i== dates.size()-1)
                    {
                        WebElement lastdate=pickDate.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]["+(i+1)+"]/td"));
                        WebElement lastdateText=   pickDate.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]["+(i+1)+"]/td/descendant::span[@class='line2']"));
                        pickUpDate=lastdateText.getText();
                        HelpersMethod.ScrollElement(driver,lastdate);
                        HelpersMethod.ClickBut(driver,lastdate,10000);
                        scenario.log("LAST DATE FOUND IN PICKUP DATE DIALOG BOX "+pickUpDate);
                        exists=true;
                        break;
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void comparePickUpDates()
    {
        exists=false;
        try
        {
            WebElement deliveryDate=HelpersMethod.FindByElement(driver,"","delivery-date-web-order-header-calendar");
            String deliverDateText=HelpersMethod.JSGetValueEle(driver,deliveryDate,10000);
            if(deliverDateText.contains(pickUpDate))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectDatePendingOrder(String formattedDate, int int1)
    {
        exists = false;
        WebElement WebEle;
        try {
            String formattedDate1="";

            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date
            String ele = "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; cursor: pointer; background-color: rgb')]/span[contains(@title,'" + ChangeDate + "')]|//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@class,'k-state-selected k-state-focused')]/span[contains(@title,'" + ChangeDate + "')]|//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; cursor: pointer;')]/span[contains(@title,'" + ChangeDate + "')]";
            boolean visible = HelpersMethod.IsExists(ele, driver);
            if (visible == false)
            {
                LocalDate myDateObj = LocalDate.now().plusDays(int1 + 1);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.waitTillElementDisplayed(driver, ele1, 2000);
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ClickBut(driver, ele1, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            else
            {
                //if Date is enabled date is increased by 'some' days already, just click on the date
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + ChangeDate + "')]");
                HelpersMethod.waitTillElementDisplayed(driver, ele1, 2000);
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ClickBut(driver, ele1, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
        }
        catch (Exception e){}
    }

    public void cancelOGselection()
    {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//span[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                // to fetch the web element
                WebElement ogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                //code to click on 'Ok' button in OG popup
                WebElement okButton = ogPopup.findElement(By.xpath(".//button/span[text()='Cancel']"));
                HelpersMethod.ClickBut(driver, okButton, 1000);
                scenario.log("ORDER GUIDE POPUP HAS BEEN FOUND");

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e) {}
    }

    //don't use assert here as verification for note dialog box is put inside for loop first time it returns true 2nd time returns false causing this method to fail
    public void verifyNoteInDialogbox(String commentText)
    {
        exists=false;
        Actions act=new Actions(driver);
        String noteText="";
        String nText="";
        int i=0;
        WebElement WebEle;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@id='customerCommentGrid']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                List<WebElement> notes=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td[3]");
                for(WebElement note:notes)
                {
                    i++;
                    act.moveToElement(note).build().perform();
                    noteText=note.getText();
                    if (noteText.equalsIgnoreCase(commentText))
                    {
                        nText=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]["+i+"]/td[3]").getText();
                        WebElement noteRow=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]["+i+"]");
                        HelpersMethod.ActClick(driver,noteRow,10000);
                        exists=true;
                        break;
                    }
                }
                //compare comments
                if(nText.equalsIgnoreCase(commentText))
                {
                    scenario.log("COMMENT FOUND IS SAME AS COMMENT ENTERED");
                    exists=true;
                }
                // to fetch the web element
                WebElement notePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                //code to click on 'Ok' button in OG popup
                WebElement okButton = notePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, okButton, 4000);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
        }
        catch (Exception e){}
    }

    public void validateExistingOrder()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> orders=HelpersMethod.FindByElements(driver,"xpath","//table[@class='k-grid-table']/descendant::td/button");
            if(orders.size()>=1)
            {
                for(WebElement order:orders)
                {
                    act.moveToElement(order).build().perform();
                    scenario.log("ORDER NUMBER FOUND IS "+order.getText());
                }
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>THERE ARE NO ORDER CREATED</span>");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateSucessOrErrorSubmittingMessage()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(@class,'k-notification-error')]",driver))
            {
                WebElement closeIcon=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg' and contains(@class,'i-icon--close-error')]");
                HelpersMethod.ActClick(driver,closeIcon,10000);
                scenario.log("ERROR MESSAGE HAS BEEN FOUND IN ORDER ENTRY PAGE");
                exists=true;
            }
            else if(HelpersMethod.IsExists("//div[contains(@class,'k-notification-success')]",driver))
            {
                WebElement closeIcon=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg' and contains(@class,'i-icon--close-success')]");
                HelpersMethod.ActClick(driver,closeIcon,10000);
                scenario.log("<span style='color:red'>SUCCESS MESSAGE HAS BEEN FOUND IN ORDER ENTRY PAGE</span>");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNoSucessOrErrorSubmittingMessage()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[contains(@class,'k-notification-error')]|//div[contains(@class,'k-notification-success')]",driver))
            {
                scenario.log("NO ERROR MESSAGE HAS BEEN FOUND IN ORDER ENTRY PAGE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNoSalesHelp()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]",driver))
            {
                WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
                WebElement salesHelp = dropDown.findElement(By.xpath("//div[contains(@class,'help-links-line sales-link')]"));
                if(salesHelp.isDisplayed())
                {
                    scenario.log("<span style='color:red'> STILL FINDING SALE PAGE</span>");
                }
            }
            else
            {
                //String ParentWindow = driver.getWindowHandle();
                Set<String> instancewindow= driver.getWindowHandles();
                Iterator<String> it = instancewindow.iterator();
                String parent =it.next();
                String child = it.next();
                driver.switchTo().window(child);
                String childURL=driver.getCurrentUrl();
                if(!childURL.contains("HelpDocs/Ignition-OMS-Sales"))
                {
                    scenario.log("NO SALES PAGE HAS BEEN FOUND");
                    exists=true;
                }
                Thread.sleep(2000);
                driver.close();
                driver.switchTo().window(parent);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNoeCommerceHelp()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]",driver))
            {
                WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
                WebElement salesHelp = dropDown.findElement(By.xpath("//div[contains(@class,'help-links-line ecommerce-link')]"));
                if(salesHelp.isDisplayed())
                {
                    scenario.log("<span style='color:red'> STILL FINDING eCOMMERCE PAGE</span>");
                }
            }
            else
            {
                Set<String> instancewindow= driver.getWindowHandles();
                Iterator<String> it = instancewindow.iterator();
                String parent =it.next();
                String child = it.next();
                Thread.sleep(2000);
                driver.switchTo().window(child);
                String childURL=driver.getCurrentUrl();
                if(!childURL.contains("Ignition-OMS-eCommerce"))
                {
                    scenario.log("NO eCOMMERCE PAGE HAS BEEN FOUND");
                    exists=true;
                }
                driver.close();
                driver.switchTo().window(parent);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Start_OrderDisabled()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            if (HelpersMethod.IsExistsById("addButton", driver) && !StartOrder.isEnabled())
            {
                scenario.log("MULTIPLE ORDERS PER DELIVERY DAY, IS DISABLED. AND WORKING AS EXPECTED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ordersExistingInOE()
    {
        exists=false;
        Actions act=new Actions(driver);
        String orderText;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement  WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            List<WebElement> orderLists=HelpersMethod.FindByElements(driver,"xpath","//button[@class='i-link-button ']");
            scenario.log("NUMBER OF ORDERS ALREADY CREATED ARE "+orderLists.size());
            scenario.log("ORDERS ARE:");
            for(WebElement orderList:orderLists)
            {
                act.moveToElement(orderList).build().perform();
                orderText=orderList.getText();
                scenario.log(orderText);
            }
        }
        catch (Exception e){}
    }


    public void Start_OrderMultipleOrderPerDay()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//button[@id='addButton']", driver) && StartOrder.isEnabled())
            {
                scenario.log("MULTIPLE ORDERS PER DELIVERY DAY, IS ENABLED. AND WORKING AS EXPECTED");
                HelpersMethod.ScrollElement(driver, SearchOrder);
                HelpersMethod.ClickBut(driver, StartOrder, 10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String readPrimarySalesRep()
    {
        exists=false;
//        try
//        {
            if(HelpersMethod.IsExists("//input[@id='SalesRepIndex']",driver))
            {
                WebElement pSalesRep=HelpersMethod.FindByElement(driver,"xpath","//input[@id='SalesRepIndex']");
                primarySalesRep=HelpersMethod.JSGetValueEle(driver,pSalesRep,10000);
                scenario.log("PRIMARY SALES REP FOUND IN ORDER ENTRY PAGE IS "+primarySalesRep);
            }
//        }
//        catch (Exception e){}
        return primarySalesRep;
    }

    public void clearSalesRep()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@data-test-id='SalesRepIndex']/descendant::span[contains(@class,'k-i-close')]",driver))
            {
                WebElement clearSalesRep=HelpersMethod.FindByElement(driver,"xpath","//div[@data-test-id='SalesRepIndex']/descendant::span[contains(@class,'k-i-close')]");
                HelpersMethod.ActClick(driver,clearSalesRep,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnSalesRepIndexIcon() throws InterruptedException
    {
        exists=false;
//        try
//        {
            if(HelpersMethod.IsExists("//div[@data-test-id='SalesRepIndex']/descendant::button//*[local-name()='svg']",driver))
            {
                WebElement saleRepIndex=HelpersMethod.FindByElement(driver,"xpath","//div[@data-test-id='SalesRepIndex']/descendant::button//*[local-name()='svg']");
                HelpersMethod.ActClick(driver,saleRepIndex,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
//        }
//        catch (Exception e){}
    }

    public void selectSalesRep()
    {
        exists=false;
        Actions act=new Actions(driver);
        String saleText;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='SalesRepIndexProvider']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                List<WebElement> salesReps=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td[2]");
                for(WebElement salesRep:salesReps)
                {
                    act.moveToElement(salesRep).build().perform();
                    saleText=salesRep.getText();
                    if(!saleText.equalsIgnoreCase(primarySalesRep))
                    {
                        act.moveToElement(salesRep).build().perform();
                        act.click(salesRep).build().perform();
                        scenario.log("SALES REP SELECTED IS "+saleText);
                        exists=true;
                        break;
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void yourOrderNotSubmitted()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[@class='k-window k-dialog']",driver))
            {
                WebElement submitButton=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::button/span[text()='Submit order']");
                HelpersMethod.ActClick(driver,submitButton,10000);


            }
        }
        catch (Exception e){}
    }

    public void startDisabledChangeDeliveryDate()
    {
        try
        {
            if(HelpersMethod.IsExists("//button[@id='addButton' and contains(@class,'disabled')]",driver))
            {
                HelpersMethod.ActClick(driver,deliveryCalender,10000);
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-animation-container k-animation-container-shown']")));

                WebElement changeDelivery=HelpersMethod.FindByElement(driver,"xpath","//tbody/descendant::td[contains(@style,'background-color: rgb')][1]/span");
                HelpersMethod.ActClick(driver,changeDelivery,10000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if(HelpersMethod.IsExists("//span[text()='Warning']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ActClick(driver,okButton,10000);

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists=CheckForRemoveSkip();
                if(exists==true)
                {
                    ClickRemoveSkip();
                    RemoveSkipOK();
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
        }
        catch (Exception e){}
    }

    public void AddfilterSearch(String SearchBoxValue,String SearhBox2Value)
    {
        WebElement Clear;
        try
        {
            WebElement Search2;
            WebElement WebEle;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);//80000
            }
            String status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Click on Add filter button
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
            driver.findElement(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")).click();

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",80000);
            WebElement modalContainer1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");

            WebElement Search1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.ActSendKey(driver,Search1,1000,SearchBoxValue);
            //Click on Check box
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[contains(@class,'k-checkbox')]")));
            WebElement WebEle1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
            HelpersMethod.ClickBut(driver,WebEle1,1000);

            //Identify radio button and click on Radio button
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            if(HelpersMethod.IsExists("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]",driver))
            {
                WebElement RadioPop=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
                Search2=RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                HelpersMethod.EnterText(driver,Search2,10000,SearhBox2Value);

                //Click on Apply button
                Clear =RadioPop.findElement(By.xpath(".//button/span[text()='Apply']"));
                HelpersMethod.ClickBut(driver,Clear,10000);
            }
        }
        catch (Exception e){}
    }
}

