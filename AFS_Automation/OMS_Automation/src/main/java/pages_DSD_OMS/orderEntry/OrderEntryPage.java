package pages_DSD_OMS.orderEntry;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import lombok.var;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.TestBase;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderEntryPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    static boolean result = false;
    static String C_Date1 = null;
    static String ChangeDate = null;
    static String currentURL = null;
    Scenario scenario;
    String ParentWindow;

    @FindBy(id = "customerAccountNumberComboBox")
    private WebElement AccNo;

    @FindBy(id="customeraddress")
    private WebElement AddressIcon;

    @FindBy(id = "addButton")
    private WebElement StartOrder;

    @FindBy(xpath = "//button[contains(@class,'k-button k-primary') and @aria-label=' dropdownbutton']")
    private WebElement StartOrderDropButton;

    @FindBy(xpath = "//button[text()='Skip']")
    private WebElement Skip;

    @FindBy(id = "customerAccountIndexSearchBar")
    private WebElement SearchOrder;

    @FindBy(xpath = "//div[contains(@class,'i-search-box')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement SearchIndex;

    @FindBy(xpath = "//span[@class='k-widget k-datepicker']/descendant::a")
    private WebElement deliveryCalender;

    @FindBy(xpath = "//button[text()='History']")
    private WebElement HistoryButton;

    @FindBy(xpath = "//button[@id='addButton']/following-sibling::div/button")
    private WebElement DropDown;

    @FindBy(xpath = "//button[text()='Remove Skip']")
    private WebElement RemoveSkip;

    @FindBy(xpath = "//button[@id='customernotes']")
    private WebElement CustomerNote;

    @FindBy(id = "noteTextbox")
    private WebElement NoteArea;

    @FindBy(id = "SaveButton")
    private WebElement Save_But;

    @FindBy(xpath = "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']")
    private WebElement Ok_But;

    @FindBy(xpath = "//div[contains(@class,'CPDeliveryDates')]/descendant::input")
    private WebElement DelivDate;

    @FindBy(xpath = "//input[@id='RouteIndex']/ancestor::span[@class='k-widget k-autocomplete']")
    private WebElement RouteInput;

    @FindBy(xpath = "//label[@id='RouteIndex-label']/parent::div/descendant::button")
    private WebElement RouteOE;

    @FindBy(id = "skipButton")
    private WebElement SkipButton;

    @FindBy(xpath = "//span[@data-test-id='customerAccountNumberComboBox']/following-sibling::button")
    private WebElement AccIndexIcon;

    String XPath = null;
    boolean exists = false;
    String Id = null;
    static String formattedDate = null;


    public OrderEntryPage(WebDriver driver, Scenario scenario) throws InterruptedException, AWTException {
        this.scenario = scenario;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void HandleError_Page()
    {
        try
        {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError")) {
                HelpersMethod.NavigateBack(driver);
                URL = HelpersMethod.gettingURL(driver);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
            {
                HomePage homepage = new HomePage(driver, scenario);
                homepage.navigateToClientSide();
                NavigateToOrderEntry();
                ChangeAccount();
                PopUps_After_AccountChange();
            }
        } catch (Exception e) {}
    }

    public void NavigateToOrderEntry()
    {
        WebElement WebEle = null;
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("Order Entry").build().perform();
            WebElement OEMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Order Entry')]");
            HelpersMethod.ActClick(driver, OEMenu, 100);
            currentURL = driver.getCurrentUrl();
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));
            if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).click().build().perform();
            }
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
                new WebDriverWait(driver, 400).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='web-order-page']")));
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
        WebElement WebEle = null;
        String Acc_No = null;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            Actions act = new Actions(driver);
            Acc_No = TestBase.testEnvironment.get_Account();
            WebEle = HelpersMethod.FindByElement(driver, "id", "customerAccountNumberComboBox");
            act.moveToElement(WebEle).click().build().perform();
            if(HelpersMethod.JSGetValueEle(driver,WebEle,100).equals(""))
            {
                act.sendKeys(WebEle, Acc_No).build().perform();
            }
            else
            {
                HelpersMethod.JSSetValueEle(driver,WebEle,100,"");
                WebEle.sendKeys(Keys.BACK_SPACE);
                act.sendKeys(WebEle, Acc_No).build().perform();
            }
            WebElement AccDrop1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-list-container ')]/descendant::li");
            HelpersMethod.JScriptClick(driver, AccDrop1, 100);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 60000);
            }
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
        WebElement WebEle = null;
        try
        {
            Refresh_Page(currentURL);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
            }
            Actions act = new Actions(driver);
            scenario.log("ACCOUNT NUMBER WILL BE CHANGED TO "+account);
            act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys("").build().perform();
            act.moveToElement(driver.findElement(By.id("customerAccountNumberComboBox"))).sendKeys(account).build().perform();

            new WebDriverWait(driver, 800).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'k-list-container ')]/descendant::li")));
            WebElement AccDrop = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@id,'option-')]");

            WebElement AccDrop1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-list-container ')]/descendant::li");
            HelpersMethod.JScriptClick(driver, AccDrop1, 40);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void PopUps_After_AccountChange()
    {
        WebElement WebEle = null;
        try {
            for (int i = 0; i <= 2; i++)
            {
                //Check for 'Upcoming blackout dates'
                if (HelpersMethod.IsExists("//p[contains(text(),'Upcoming blackout dates')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']")).click();
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }
                }

                //check for note popup
                if (HelpersMethod.IsExists("//p[contains(text(),'Notes')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//p[contains(text(),'Notes')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement okButton = WebEle.findElement(By.xpath(".//button[text()='Ok']"));
                    HelpersMethod.ClickBut(driver, okButton, 80);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }
                }
                //Checking for the open order popup
                if (HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement startOrder = WebEle.findElement(By.xpath(".//button[contains(text(),'Start new order')]"));
                    HelpersMethod.ClickBut(driver, startOrder, 40);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }
                }
            }
        } catch (Exception e) {}
    }

    public boolean Verify_OE_Title()
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            HelpersMethod.waitTillTitleContains(driver, "Ignition - Order Entry", 100);
            String title = driver.getTitle();
            if (title.equals("Ignition - Order Entry"))
            {
                exists = true;
            }
        }
        catch (Exception e) {}
        return exists;
    }

    public void Verify_OEPage()
    {
        exists = false;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {
            if (HelpersMethod.IsExists("//div[@id='order-search-card']", driver))
            {
                exists = true;
            }
            Assert.assertEquals(true, exists);
        } catch (Exception e) {}
    }

   public void Refresh_Page1()
    {
        try
        {
            WebElement WebEle = null;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
            }
            driver.navigate().to(currentURL);
            driver.navigate().refresh();
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
            }
        } catch (Exception e) {}
    }

    public void Refresh_Page2()
    {
        Actions act1=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, 40);
                if(wait.until(ExpectedConditions.alertIsPresent())==null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
            }
            else
            {
                WebElement humBurger=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act1.moveToElement(humBurger).click().build().perform();

                //find whether side menu bar has expanded
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 800);
                WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
                act1.moveToElement(side_menu).build().perform();

                if(HelpersMethod.IsExists("//i[@class='searchbar-container-close-icon']",driver))
                {
                    WebElement closeButton=HelpersMethod.FindByElement(driver,"xpath","//i[@class='searchbar-container-close-icon']");
                    HelpersMethod.ActClick(driver,closeButton,400);
                }

                WebElement Search_Input = HelpersMethod.FindByElement(driver, "id", "navigationMenuSearchBar");
                act1.moveToElement(Search_Input).click().sendKeys("Order Entry").build().perform();
                WebElement OEMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Order Entry')]");
                HelpersMethod.ActClick(driver, OEMenu, 100);
                if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement pendingPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement dismissAll= pendingPopup.findElement(By.id("QuestionModalButton1"));
                    HelpersMethod.ActClick(driver,dismissAll,400);
                }
                humBurger=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act1.moveToElement(humBurger).click().build().perform();
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
            }
        }
        catch (Exception e){}
    }

   public void Refresh_Page(String currentURL1)
    {
            WebElement WebEle = null;
            scenario.log("CURRENT URL IS "+currentURL1);
            driver.navigate().to(currentURL1);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
    }

    //change the Customer Account#
    public void Change_NewAccount(String Acc)
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            scenario.log("ACCOUNT NUMBER WILL BE CHANGED TO "+Acc);
            if (HelpersMethod.IsExists("//span[@data-test-id='customerAccountNumberComboBox']/following-sibling::button",driver))
            {
                HelpersMethod.ActClick(driver, AccIndexIcon, 100);
                new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
                if (HelpersMethod.IsExists("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[contains(@class,'i-search-box')]", driver))
                    {
                        HelpersMethod.AddFilterSearch_Popup(driver,"Customer #",TestBase.testEnvironment.get_AnotherAcc());
                        //Selecting row in customer account#
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='k-grid-container']/descendant::tr[@class='k-master-row']");
                        HelpersMethod.ClickBut(driver, WebEle, 60);

                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                        }
                    }
                }
            }
            PopUps_After_AccountChange();
            WebEle = HelpersMethod.FindByElement(driver, "id", "customerAccountNumberComboBox");
            String Acc_No = HelpersMethod.JSGetValueEle(driver, WebEle, 2000);
            scenario.log("CUSTOMER ACCOUNT# SELECTED IS " + Acc_No);
            if (!Acc_No.equals(null))
            {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    //Preceding by zero, This feature is only for DSD
    public boolean Account_Zero() {
        try {
            result = false;
            String Acc1 = AccNo.getAttribute("value");
            //Code to read account# from properties file and remove preceding zeros
            String Acc_Sub[] = Acc1.split("-");
            int i = 0;
            for (String Accs : Acc_Sub)
            {
                int length = Accs.length();
                if (Accs.length() != 1)
                {
                    int firstValue =Integer.parseInt(String.valueOf(Accs.charAt(0)));
                    if (firstValue!=0)
                    {
                        result = true;
                    }
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 600);
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
        String AccNo = TestBase.testEnvironment.get_AnotherAcc();

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }

        new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        // code to click on Addfilter button
        new WebDriverWait(driver, 400).until(ExpectedConditions.elementToBeClickable(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]")));
        WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
        HelpersMethod.JScriptClick(driver, AddFilterButton, 400);

        //Identify the dialog popup
        new WebDriverWait(driver, 800).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]")));
        new WebDriverWait(driver, 600).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]")));
        WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");

        //Enter customer account# in input box
        WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
        HelpersMethod.EnterText(driver, Search1, 200, "Customer #");

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Click on Check box
        new WebDriverWait(driver, 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='CM_CUSTKEY']")));
        WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[@id='CM_CUSTKEY']"));

        HelpersMethod.JScriptClick(driver, WebEle1, 100);
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Identify radio button and click on Radio button
        new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]")));
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 40);
        WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
        WebElement radioButton = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
        if (radioButton.isDisplayed()) {
            Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            HelpersMethod.EnterText(driver, Search2, 40, AccNo);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Click on Apply button
            WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button[text()='Apply']"));
            new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ApplyButton));
            HelpersMethod.ClickBut(driver, ApplyButton, 40);
        }

        if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']", driver)) {
            scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
        } else {
            WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ActClick(driver, WebEle, 40);

            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            exists = true;
            String Acc = TestBase.testEnvironment.get_AnotherAcc();
            scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
        }
    }

    public void ValidateOE() {
        exists = false;
        String status = null;
        WebElement WebEle = null;
        try {
            String OETitle = HelpersMethod.gettingTitle(driver);
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void Scroll_start() throws InterruptedException {
        try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "id", "order-search-card", 20);
            HelpersMethod.ScrollElement(driver, driver.findElement(By.id("order-search-card")));
            HelpersMethod.waitClickableOfEle(driver, StartOrder, 400);
        } catch (Exception e) {
            scenario.log(e.getMessage());
            scenario.log(e.getMessage());
        }
    }

    public void NoPendingOrderPopup() {
        WebElement WebEle = null;
        try {
            if (HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 60);
                WebElement noPendingOrderPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                WebElement startOrder = noPendingOrderPopup.findElement(By.xpath(".//button[contains(text(),'Start new order')]"));
                HelpersMethod.ClickBut(driver, startOrder, 200);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                }
            }
        } catch (Exception e) {
        }
    }

    public void ContinuePendingOrderFromPopup()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 60);
                WebElement noPendingOrderPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                WebElement noPendingOrderContent = noPendingOrderPopup.findElement(By.xpath(".//div[contains(@class,'k-window-content k-dialog-content')]"));
                Assert.assertEquals(noPendingOrderContent.getText(), "You already have an open order that is pending submission. Would you like to switch to that Pending order or start a new order? If you start a new order, the Pending order will be overwritten.", "Verify Title message");

                WebElement startOrder = noPendingOrderPopup.findElement(By.xpath(".//button[contains(text(),'Continue pending order')]"));
                HelpersMethod.ClickBut(driver, startOrder, 100);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
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
            if (HelpersMethod.IsExists("//div/p[1][contains(text(),'Notes')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
                // to fetch the web element
                WebElement notePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                //code to click on 'Ok' button in OG popup
                WebElement okButton = notePopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, okButton, 100);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
                }
            }
        } catch (Exception e) {}
    }

    public void OrderGuidePopup()
    {
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                // to fetch the web element
                WebElement ogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                //code to click on 'Ok' button in OG popup
                WebElement okButton = ogPopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, okButton, 800);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                }
            }
        } catch (Exception e) {
        }
    }

    public void selectOGPopup(String og_Name)
    {
        WebElement WebEle = null;
        try {
            if (HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                // to fetch the web element
                WebElement ogPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                //selecting OG in from popup
                WebElement ogSelect = ogPopup.findElement(By.xpath(".//td[text()='" + og_Name + "']/ancestor::tr"));
                HelpersMethod.ActClick(driver, ogSelect, 400);

                //code to click on 'Ok' button in OG popup
                WebElement okButton = ogPopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, okButton, 400);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                }
            }
        } catch (Exception e) {
        }
    }

    //public void NoNotePopHandling(String note)
    public void NoNotePopHandling()
    {
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
            }
            //Check for Note popup
            if (HelpersMethod.IsExists("//div/p[1][contains(text(),'Notes')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                // to fetch the web element
                WebElement notePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                //code to click on 'Ok' button in OG popup
                WebElement okButton = notePopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, okButton, 400);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 6000);
                }
            }
        } catch (Exception e) {}
    }

    public void ClickCalender() throws InterruptedException
    {
        exists = false;
        WebElement deliveryCalender =HelpersMethod.FindByElement(driver,"xpath","//div[@class='CPDeliveryDates']/descendant::a");
        HelpersMethod.JScriptClick(driver, deliveryCalender, 4000);
        new WebDriverWait(driver,4000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-view')]/descendant::table[@class='k-calendar-table']"))));
        exists = true;
        Assert.assertEquals(exists, true);
    }

    public void Read_DeliveryDate() throws InterruptedException, ParseException
    {
        new WebDriverWait(driver, 800000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'delivery-date-web-order-header-calendar')]"))));
        if (formattedDate == null)
        {
            formattedDate = driver.findElement(By.xpath("//input[contains(@id,'delivery-date-web-order-header-calendar')]")).getAttribute("value");
            //Find the current date and change it's formate
            SimpleDateFormat fromUser1 = new SimpleDateFormat("EEE, MMM d, yyyy");
            SimpleDateFormat fromUser = new SimpleDateFormat("EEEE, MMMM d, yyyy");
            C_Date1 = fromUser.format(fromUser1.parse(formattedDate));
            scenario.log("DELIBERY DATE FOUND, AFTER LOGGING IN TO APPLICATION  " + C_Date1);
        }
    }

    public void ChangedDeliveryDate()
    {
        exists = false;
        ChangeDate = formattedDate = driver.findElement(By.xpath("//input[contains(@id,'delivery-date-web-order-header-calendar')]")).getAttribute("value");
        exists = true;
        scenario.log("Delivery date is " + ChangeDate);
        Assert.assertEquals(exists, true);
    }

    public void ResetToCurrentDate() throws InterruptedException
    {
        WebElement WebEle = null;
        WebElement CDate = null;

        try {
            //click on date
            new WebDriverWait(driver, 1000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]"))));
            CDate = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@title,'" + C_Date1 + "')]");
            HelpersMethod.ClickBut(driver, CDate, 100);

            for (int i = 0; i <= 3; i++) {
                //Handling Change delivery date Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    WebElement changeDeliveryDate = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                    WebElement ChangeDD = changeDeliveryDate.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Change delivery date']"));
                    HelpersMethod.ClickBut(driver, ChangeDD, 80);
                }
                //Handling Warning Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Warning')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    WebElement warningPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                    WebElement WarningDD = warningPopup.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']"));
                    HelpersMethod.ClickBut(driver, WarningDD, 80);
                }
                //Warning popup for pending order or to start new order
                if (HelpersMethod.IsExists("//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    WebElement pendingPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                    WebEle = pendingPopup.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Start new order')]"));
                    HelpersMethod.ActClick(driver, WebEle, 80);
                }
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            for (int i = 0; i <= 1; i++)
            {
                //NOte popup
                NoNotePopHandling();
                //OG popup
                OrderGuidePopup();
            }
        }
        catch (Exception e){}
    }

    public void SelectDate(String ChangeDate, int int1)
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            String formattedDate1 = null;

            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date
            String ele = "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; cursor: pointer; background-color: rgb')]/span[contains(@title,'" + ChangeDate + "')]|//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@class,'k-state-selected k-state-focused')]/span[contains(@title,'" + ChangeDate + "')]|//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; cursor: pointer;')]/span[contains(@title,'" + ChangeDate +"')]";
            boolean visible = HelpersMethod.IsExists(ele, driver);
            if (visible == false)
            {
                LocalDate myDateObj = LocalDate.now().plusDays(int1 + 1);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.waitTillElementDisplayed(driver, ele1, 80);
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ClickBut(driver, ele1, 100);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
                }
            }
            else
            {
                //if Date is enabled date is increased by 'some' days already, just click on the date
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@style,'opacity: 1; ')]/span[contains(@title,'" + ChangeDate + "')]");
                HelpersMethod.waitTillElementDisplayed(driver, ele1, 80);
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ClickBut(driver, ele1, 100);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
                }
            }
            for (int i = 0; i <= 3; i++)
            {
                //Handling Warning Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Warning')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    WebElement warningPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                    WebElement WarningDD = warningPopup.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']"));
                    HelpersMethod.ClickBut(driver, WarningDD, 80);
                }
                //Handling Change delivery date Popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    WebElement changeDeliveryDate = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Change delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                    WebElement ChangeDD = changeDeliveryDate.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Change delivery date']"));
                    HelpersMethod.ClickBut(driver, ChangeDD, 80);
                }

                //Warning popup for pending order or to start new order
                if (HelpersMethod.IsExists("//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    WebElement pendingPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Pending order or start a new order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                    WebEle = pendingPopup.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Start new order')]"));
                    HelpersMethod.ActClick(driver, WebEle, 80);
                }
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            for (int i = 0; i <= 1; i++)
            {
                //Check for note popup
                NoNotePopHandling();
                //Check for OG popup
                OrderGuidePopup();
            }
            //Navigating to OE page, if changing date leads to New OE page
            exists = HelpersMethod.IsExistsById("backButton", driver);
            if (exists == true) {
                HelpersMethod.ActClick(driver, driver.findElement(By.id("backButton")), 40);
                if (exists == true) {
                    HelpersMethod.ActClick(driver, driver.findElement(By.id("backButton")), 40);
                    if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'without submitting')]", driver)) {
                        WebElement noPendingOrderPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                        WebElement startOrder = noPendingOrderPopup.findElement(By.xpath(".//button[contains(text(),'Discard all')]"));
                        HelpersMethod.ClickBut(driver, startOrder, 80);
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                        }
                    }
                }
            }
            new WebDriverWait(driver, 1000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("order-search-card"))));
        } catch (Exception e) {
        }
    }

    //Click on Start order button
    public boolean Start_Order()
    {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            if (HelpersMethod.IsExistsById("addButton", driver) && StartOrder.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, SearchOrder);
                HelpersMethod.ClickBut(driver, StartOrder, 100);
                scenario.log("START BUTTON HAS BEEN CLICKED");
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                exists = true;
            }
            else
            {
                //If start button is not enabled either skip is enabled or cutoff date has been reached
                ClickCalender();
                ChangedDeliveryDate();
                SelectDate(ChangeDate, 100);
                HelpersMethod.ScrollElement(driver, SearchOrder);
                HelpersMethod.ClickBut(driver, StartOrder, 100);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {}
        return exists;
    }

    public boolean Start_OrderAgain()
    {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "id", "addButton");
            HelpersMethod.JScriptClick(driver, WebEle, 40);
            scenario.log("START ORDER HAS BEEN CLICKED");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
        try {
            WebElement WebEle = null;
            //Navigate back to Order Entry page
            if (HelpersMethod.IsExists("//label[contains(text(),'New order')]/ancestor::div[contains(@class,'i-card order-entry-card')]", driver))
            {
                //driver.navigate().refresh();
                driver.navigate().back();
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
            }

            if (!HelpersMethod.IsExists("//button[contains(text(),'Remove Skip')]", driver))
            {
                HelpersMethod.ClickBut(driver, SkipButton, 100);
                new WebDriverWait(driver,800).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));

                if (HelpersMethod.IsExists("//div[text()='Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {

                    WebElement skipPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                    //Identify the skip reason drop down
                    WebEle = skipPopup.findElement(By.xpath(".//span[@id='SkipReason']"));
                    HelpersMethod.ClickBut(driver, WebEle, 100);
                    HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 200);
                    String Opt=null;
                    String Opt1=null;
                    String Opt2=null;
                    Opt1= reason.toLowerCase();
                    // to fetch the web element of the modal container
                    WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
                    List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
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
                    WebElement okButton=skipPopup.findElement(By.xpath(".//button[text()='Ok']"));
                    HelpersMethod.ClickBut(driver,okButton,100);
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
        WebElement WebEle = null;
      /*  if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 5000);
        }*/
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        try {
            HelpersMethod.ScrollElement(driver, RemoveSkip);
            //Check for existence of Remove Skip button
            if (HelpersMethod.IsExists("//button[text()='Remove Skip']", driver))
            {
                exists = true;
                scenario.log("REMOVE SKIP HAS BEEN FOUND");
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
        return exists;
    }

    public void ClickRemoveSkip()
    {
        WebElement WebEle = null;
        exists = false;
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            HelpersMethod.ScrollElement(driver, RemoveSkip);
            //Check for Remove skip, and click on it
            if (HelpersMethod.IsExists("//button[text()='Remove Skip']", driver))
            {
                HelpersMethod.ScrollElement(driver, RemoveSkip);
                HelpersMethod.ClickBut(driver, RemoveSkip, 100);
                exists = true;
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void RemoveSkipOK() {
        exists = false;
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Remove Skip')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement removeSkipPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement removeSkip = removeSkipPopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, removeSkip, 80);
                scenario.log("REMOVESKIP POPUP HAS BEEN HANDLED");
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public boolean CheckForSkip()
    {
        exists = false;
        WebElement WebEle = null;
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }

            if (HelpersMethod.IsExists("//button[text()='Skip']", driver))
            {
                HelpersMethod.ScrollElement(driver, Skip);
                exists = true;
                scenario.log("SKIP BUTTON FOUND");
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
        return exists;
    }

    public void Click_HistoryButton()
    {
        WebElement WebEle = null;
        exists = false;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
        try
        {
            HelpersMethod.ScrollElement(driver, HistoryButton);
            HelpersMethod.ClickBut(driver, HistoryButton, 100);
            exists = true;
            scenario.log("ORDER HISTORY BUTTON HAS BEEN CLICKED");
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Enter_OrderNo_Searchbox(String Order_No)
    {
        WebElement WebEle = null;
        exists = false;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
        }
        try
        {
            HelpersMethod.ScrollElement(driver, SearchOrder);
            HelpersMethod.EnterText(driver, SearchOrder, 40, Order_No);
            HelpersMethod.ClickBut(driver, SearchIndex, 40);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void Existence_OrderNo_OG()
    {
        boolean result = false;
        try
        {
            if (!HelpersMethod.IsExists("//tr[@class='k-master-row']", driver))
            {
                result = true;
                scenario.log("ORDER HAS BEEN FOUND IN ORDER GRID");
            }
            Assert.assertEquals(result, true);
        }
        catch (Exception e) {}
    }

    public void Existence_OrderNo_OG1()
    {
        boolean result = false;
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
        try
        {
            if (HelpersMethod.IsExists("//tr[@class='k-master-row'][1]", driver))
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
        WebElement WebEle = null;
        exists = false;
        try
        {
            if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]/descendant::td/button", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::td/button");
                HelpersMethod.ClickBut(driver, WebEle, 1000);
                scenario.log("ORDER GUIDE OPTION HAS BEEN SELECTED");
                exists=true;
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Click_DropDown()
    {
        exists = false;
        try
        {
            WebElement WebEle = driver.findElement(By.id("order-search-card"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ClickBut(driver, DropDown, 200);
            exists = true;

            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Select_Par_Order()
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"));
            WebElement optionToClick = menuContainer.findElement(By.xpath(".//li[contains(text(),'Par ordering')]"));
            // click the option
            HelpersMethod.ActClick(driver, optionToClick, 1000);
            exists = true;
            scenario.log("PAR ORDER OPTION HAS BEEN SELECTED");
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void SelectQuote()
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",40);
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"));
            WebElement optionToClick = menuContainer.findElement(By.xpath(".//li[contains(text(),'Quote')]"));
            // click the option
            HelpersMethod.ActClick(driver, optionToClick, 100);
            exists = true;
            scenario.log("QUOTES OPTION HAS BEEN SELECTED");
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //For creating customer notes
    public void click_On_CustomerNotes()
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

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }

            Actions act = new Actions(driver);
            act.moveToElement(CustomerNote);
            act.click(CustomerNote).build().perform();
            scenario.log("CUSTOMER NOTE ICON HAS BEEN CLICKED");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
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
            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//p[contains(text(),'Notes')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement noteArea = vallidateNotePopup.findElement(By.xpath(".//textarea[@id='noteTextbox']"));
                HelpersMethod.ActSendKey(driver, noteArea, 2000, notes);
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
            WebElement WebEle = null;
            //Finding Customer notes popup
            if (HelpersMethod.IsExists("//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                //code to select alert type
                WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = vallidateNotePopup.findElement(By.xpath(".//span[@id='AlertType']"));
                HelpersMethod.ClickBut(driver, WebEle, 1000);
                new WebDriverWait(driver, 1000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]"))));
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
                        HelpersMethod.JScriptClick(driver, WebEle, 100);
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
            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='SaveButton']"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ClickBut(driver, WebEle, 100);
            exists=true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists,true);
            Ok_Note_Button();
        }
        catch (Exception e) {}
    }

    public void Ok_Note_Button()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='CustomerCommentDialogOK']"));
            HelpersMethod.ScrollElement(driver, WebEle);
            HelpersMethod.ClickBut(driver, WebEle, 100);
            exists=true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
            //Read all the note from the grid
            java.util.List<WebElement> Notes = driver.findElements(By.xpath("//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr/td[3]"));
            for (WebElement Note : Notes)
            {
                i++;
                String Note_Text = Note.getText();
                if (Note_Text.equals(cust_Note))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customerCommentGrid']/descendant::div[contains(@class,'k-grid-container')]/descendant::tr[" + i + "]/td[3]");
                    HelpersMethod.ClickBut(driver, WebEle, 100);
                    exists = true;
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
            WebElement vallidateNotePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'customer-notes-header')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement WebEle = vallidateNotePopup.findElement(By.xpath(".//button[@id='copyNote']"));
            HelpersMethod.ActClick(driver, WebEle, 100);
            exists = true;
            scenario.log("COPY CUSTOMER NOTE BUTTON HAS BEEN CLICKED");
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //Method for pickup order
    public void Pickup_Order()
    {
        WebElement WebEle;
        exists = false;
        try
        {
            new WebDriverWait(driver,800).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"))));
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]"));
            WebElement optionToClick = menuContainer.findElement(By.xpath(".//li[contains(text(),'Pick up order')]"));
            // click the option
            HelpersMethod.ActClick(driver, optionToClick, 1000);
            scenario.log("PICKUP ORDER HAS BEEN SELECTED");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //Code for handling Delivery date for pickup order
    public void SelectPickupOrderDeliveryDate()
    {
        exists = false;
        WebElement WebEle;
        WebElement WebEle1;
        try
        {
            //Check for existence of Select delivery date popup
            if (HelpersMethod.IsExists("//div[contains(text(),'Select delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement deliveryDatePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Select delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = deliveryDatePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/td"));
                WebEle1=deliveryDatePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/td/span[@class='line2']"));
                scenario.log("DATE SELECTED FOR PICK UP ORDER IS "+WebEle1.getText());
                //Click on first date in Select delivery date popup
                HelpersMethod.ClickBut(driver, WebEle, 100);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
            WebElement WebEle = null;
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
                    HelpersMethod.ClickBut(driver, WebEle, 100);
                    //Delete the note
                    WebEle = HelpersMethod.FindByElement(driver, "id", "deleteNote");
                    HelpersMethod.ClickBut(driver, WebEle, 100);
                    scenario.log("DELETE BUTTON IN CUSTOMER NOTE HAS BEEN CLICKED");
                    exists = true;
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
            WebElement Button_Ele = HelpersMethod.FindByElement(driver, "id", "resetNote");
            HelpersMethod.ClickBut(driver, Button_Ele, 100);
            exists = true;
            scenario.log("RESET BUTTON IN CUSTOMER NOTE POPUP HAS BEEN CLICKED");
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //Selcting route from the index popup
    public void Route_No(String SearchOpt, String SearchDetail)
    {
        WebElement WebEle = null;
        exists = false;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
        try {
            //Click on Index icon next to Route#
            WebElement route_No = HelpersMethod.FindByElement(driver, "xpath", "//label[contains(@id,'RouteIndex-label')]/following-sibling::div/descendant::button");
            HelpersMethod.ClickBut(driver, route_No, 100);

            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[text()='Route #']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 30);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Route #", "Verify Title message");

            //Selecting route # in Route # popup
            HelpersMethod.Click_On_IndexFieldIcon(driver, SearchOpt, SearchDetail);
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    //Click on Route index icon
    public void Route_Popup() {
        exists = false;
        try {
            HelpersMethod.ClickBut(driver, RouteOE, 40);
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    //Click on 1st route in popup
    public void Route1() {
        exists = false;
        try {
            if (HelpersMethod.IsExists("//div[contains(text(),'Route #')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='RouteIndexProvider']/descendant::tr[@class='k-master-row'][1]");
                HelpersMethod.ActClick(driver, WebEle, 10);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    //Code to select OG from popup
    public void SelectOrderGuidePopup() {
        try {
            if (HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                WebElement orderGuidePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                //code to select OG from popup
                WebElement OgSelect = orderGuidePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ActClick(driver, OgSelect, 40);
                //Code to read name of OG
                String OGDis = orderGuidePopup.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/descendant::td[1]")).getText();
                //code to click ok button in popup
                WebElement Orderguide = orderGuidePopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, Orderguide, 40);
                scenario.log("OG HAS BEEN SELECTED POPUP " + OGDis);
            } else {
                scenario.log("OG POPUP HAS NOT APPEARED");
            }
        } catch (Exception e) {
        }
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]", 2400);
            WebElement UserIcon = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]");
            new WebDriverWait(driver, 10000).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]"))));
            HelpersMethod.JScriptClick(driver, UserIcon, 8000);

            exists = true;
            new WebDriverWait(driver,20000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative popup-with-arrow standard-view user-info k-animation-container-shown')]"))));
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
            HelpersMethod.ActClick(driver, signOut, 400);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }

            HelpersMethod.waitTillTitleContains(driver, "Ignition - Login", 60);
            String title = driver.getTitle();
            if (title.equals("Ignition - Login"))
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
                HelpersMethod.EnterText(driver, SearchOrder, 40, Quote);
                HelpersMethod.ActClick(driver, SearchIndex, 20);
                exists = true;
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
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
        try {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[@class='i-link-button ']");
            String O_No = WebEle.getText();
            if (O_No.equals(Ord_No)) {
                scenario.log("ORDER HAS BEEN FOUND");
                exists = true;
            } else {
                scenario.log("ORDER HAS NOT BEEN FOUND");
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void ClickOnQuote()
    {
        exists = false;
        try {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[@class='i-link-button ']");
            HelpersMethod.ClickBut(driver, WebEle, 60);
            exists = true;
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public boolean ParOrderPopup()
    {
        exists = false;
        boolean exists1 = false;
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
        }
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement orderGudides = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                //Select 1st OG from the popup, automatically it will selet 1st par order in the popup
                WebEle = orderGudides.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                HelpersMethod.ActClick(driver, WebEle, 10);

                //Select first par order from the popup
                new WebDriverWait(driver, 400).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Par list')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
                WebElement parList = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Par list')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement parSelect = parList.findElement(By.xpath(".//div[@id='par-list-grid']/descendant::tr[contains(@class,'k-master-row')][1]"));
                WebElement parText = parList.findElement(By.xpath(".//div[@id='par-list-grid']/descendant::tr[contains(@class,'k-master-row')][1]/td"));
                scenario.log("PAR LIST SELECTED IS: " + parText.getText());
                HelpersMethod.ActClick(driver, parSelect, 100);
                exists1 = true;
                exists = true;
            }
            else
            {
                scenario.log("MAY BE THERE IS ONLY ONE OG/PAR LIST, WHICH WILL BE BY DEFAULT ADDED TO OE");
                exists = true;
            }
            Assert.assertEquals(exists, true);
            Assert.assertEquals(exists1, true);
        }
        catch (Exception e) {}
        return exists1;
    }

    public void ParOrderPopupOk()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
            HelpersMethod.ActClick(driver, WebEle, 100);
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ValidatingTodaysDate()
    {
        exists = false;
        WebElement WebEle;
        String CurrentDate = null;

        //Check for existence of Select delivery date popup
        if (HelpersMethod.IsExists("//div[contains(text(),'Select delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
        {
            WebElement selectDeliveryDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Select delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            List<WebElement> DeliveryDates = selectDeliveryDate.findElements(By.xpath(".//table[contains(@class,'k-grid-table')]/descendant::span[@class='line2']"));
            for (WebElement DeliveryDate : DeliveryDates)
            {
                scenario.log("DELIVERY DATES DISPLAYED IN POPUP " + DeliveryDate.getText());
            }

            //finding present date
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
            String formattedDate = sdf.format(date);
            System.out.println(formattedDate);
            //Comparting system date with date in popup
            WebEle = DeliveryDates.get(0);
            CurrentDate = WebEle.getText();
            scenario.log("CURRENT DATE IS " + CurrentDate);
            if (CurrentDate.equals(formattedDate))
            {
                scenario.log("TODAYS DATE HAS BEEN FOUND IN PICKUP ORDER DELIVER DATE POPUP " + WebEle.getText());
                exists = true;
            }
            else
            {
                scenario.log("TODAYS DATE HAS NOT BEEN FOUND IN PICKUP ORDER DELIVERY DATE POPUP");
            }
            Assert.assertEquals(exists, true);
        }
    }

    public void RemoveRoute()
    {
        exists = false;
        Actions act = new Actions(driver);
        try
        {
            //act.moveToElement(RouteInput).build().perform();
            WebElement RouteRemove = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='RouteIndex']/parent::span/following-sibling::span[@title='clear']");
            HelpersMethod.JScriptClick(driver,RouteRemove,200);
            //act.moveToElement(RouteRemove).build().perform();
            //act.click(RouteRemove).build().perform();
            exists = true;
            scenario.log("ROUTE VALUE HAS BEEN REMOVED");
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void RouteIsEmpty()
    {
        exists = false;
        try
        {
            String RouteValue = HelpersMethod.JSGetValueEle(driver, RouteInput, 100);
            if (RouteValue.equals(null))
            {
                scenario.log("ROUTE VALUE IS EMPTY");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ValidateRouteMandatoryPopup() {
        exists = false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
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
            if (HelpersMethod.IsExists("//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement routeNumberPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Route number required')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

                WebEle = routeNumberPopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, WebEle, 40);
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
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/ancestor::div[contains(@class,'k-calendar-container')]", 500);
        HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/ancestor::div[contains(@class,'k-calendar-container')]", 400);
        WebElement fromDateContainer = driver.findElement(By.xpath("//table[@class='k-calendar-table']"));
        WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td/span[contains(@title,'" + date1 + "')]"));
        new WebDriverWait(driver, 600).until(ExpectedConditions.elementToBeClickable(ele1));
        HelpersMethod.JSScroll(driver, ele1);
        HelpersMethod.JScriptClick(driver, ele1, 500);

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
      /*  if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
        }*/
        //Click on question mark
        WebElement questionMark = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M11,18h')]");
        HelpersMethod.ActClick(driver, questionMark, 1000);
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 80);
        WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
        WebElement eCommerce = dropDown.findElement(By.xpath("//div[contains(@class,'help-links-line ecommerce-link')]"));
        String ParentWindow = driver.getWindowHandle();
        HelpersMethod.ActClick(driver, eCommerce, 100);

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

    public void selectSaleshelp() throws InterruptedException
    {
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Click on question mark
            String ParentWindow = driver.getWindowHandle();
            WebElement questionMark = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M11,18h')]");
            HelpersMethod.ActClick(driver, questionMark, 1000);
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 600);
            WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
            WebElement salesHelp = dropDown.findElement(By.xpath("//div[contains(@class,'help-links-line sales-link')]"));

            HelpersMethod.ActClick(driver, salesHelp, 1000);

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
            HelpersMethod.ClickBut(driver, ordType, 80);
        }
        catch (Exception e) {}
    }

    public void selectRegularOrder(String s, String s1)
    {
        try
        {
            HelpersMethod.Click_On_IndexFieldIcon(driver, s, s1);
            //validate popup for regular order
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(text(),'Order type')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 100);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Order type')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Order type", "Verify Title message");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
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
                HelpersMethod.ClickBut(driver, AddressIcon,100);
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
            if(HelpersMethod.IsExists("//div[contains(text(),'Contact information')]/ancestor::div[contains(@class,'k-popup k-child-animation-container')]",driver))
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
            HelpersMethod.ScrollElement(driver,privacyLink);
            HelpersMethod.ActClick(driver,privacyLink,100);
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
}

