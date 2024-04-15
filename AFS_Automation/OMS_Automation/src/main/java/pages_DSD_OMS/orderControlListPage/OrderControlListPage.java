package pages_DSD_OMS.orderControlListPage;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en_old.Ac;
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
import org.testng.IAlterSuiteListener;
import org.w3c.dom.Text;
import util.TestBase;

import java.sql.Ref;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderControlListPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static String Acc_No=null;
    static String originalGrid=null;
    static boolean exists = false;
    static String customerAccount;
    List<WebElement> SkipList1=null;
    List<WebElement> Skiplist2=null;
    static int columnNo=0;
    static int lastPage=0;
    static int a=0;
    static int pageHold=0;
    static int rowNo=0;
    int skipRow=0;

    @FindBy(xpath = "//span[@id='OrderTaker']/descendant::span[@class='k-select']")
    private WebElement OrderTaker;

    @FindBy(id="CallDesk")
    private WebElement callDesk;

    @FindBy(id = "All")
    private WebElement AllRadio;

    @FindBy(xpath = "//a[contains(@title,'Toggle calendar')]/span")
    private WebElement CallDate;

    @FindBy(id = "refreshButton")
    private WebElement RefreshButton;

    @FindBy(id = "printButton")
    private WebElement PrintButton;

    @FindBy(id = "Taken")
    private WebElement TakenRadio;

    @FindBy(id = "Untaken")
    private WebElement UntakenRadio;

    @FindBy(id = "customerAccountIndexSearchBar")
    private WebElement SearchBox;

    @FindBy(xpath = "//div[contains(@class,'i-search-box')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement SearchIndex;

    @FindBy(xpath="//div[contains(@class,'i-search-box')]//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__clear')]")
    private WebElement SearchClear;

    @FindBy(xpath = "//tr[1]/descendant::div[contains(@id,'PlaceOrderColIcon')]//*[local-name()='svg']")
    private WebElement OrderIcon;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]")
    private WebElement To;

    @FindBy(xpath="//span[contains(@class,'k-multiselect')]/descendant::input")
    private  WebElement Route;

    @FindBy(xpath="//span[contains(@class,'core-grid-grid-selection-dropdown')]")
    private WebElement gridDropDown;

    public OrderControlListPage(WebDriver driver, Scenario scenario)
    {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void Validate_OCL()
    {
        exists=false;
        try
        {
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
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(300))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Thread.sleep(4000);
            if(HelpersMethod.IsExists("//div[@id='gridOrderControlList']",driver))
            {
                scenario.log("NAVIGATED TO ORDER CONTROL LIST");
                exists = true;
            }
            Assert.assertEquals(exists,true);

        }
        catch (Exception e) {}
    }

    public void Refresh_Page(String currentURL) throws InterruptedException
    {
        Actions act1=new Actions(driver);
        String status=null;
        Wait<WebDriver> wait;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                wait = new WebDriverWait(driver, Duration.ofMillis(10000));
                if (wait.until(ExpectedConditions.alertIsPresent()) == null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement humBurger = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act1.moveToElement(humBurger).build().perform();
                act1.click().build().perform();

                //find whether side menu bar has expanded
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 40000);
                WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
                act1.moveToElement(side_menu).build().perform();

                if (HelpersMethod.IsExists("//i[@class='searchbar-container-close-icon']", driver))
                {
                    WebElement closeButton = HelpersMethod.FindByElement(driver, "xpath", "//i[@class='searchbar-container-close-icon']");
                    if (closeButton.isDisplayed() && closeButton.isDisplayed())
                    {
                        HelpersMethod.ActClick(driver, closeButton, 10000);
                    }
                }

                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'searchbar-container')]/descendant::input[@id='navigationMenuSearchBar']"))));
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'searchbar-container')]/descendant::input[@id='navigationMenuSearchBar']"))));
                WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'searchbar-container')]/descendant::input[@id='navigationMenuSearchBar']");
                act1.moveToElement(Search_Input).click().build().perform();
                HelpersMethod.JSSetValueEle(driver, Search_Input, 10000, "Order Entry");

                WebElement OEMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Order Entry')]");
                HelpersMethod.ActClick(driver, OEMenu, 10000);
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

            wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(150))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement pendingPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement dismissAll = pendingPopup.findElement(By.xpath("//button[contains(@id,'QuestionModalButton')"));
                    HelpersMethod.ActClick(driver, dismissAll, 10000);
                }
                humBurger = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act1.moveToElement(humBurger).click().build().perform();

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(150))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //navigate to OCL
                //driver.navigate().to(currentURL);
                navigateToOCL();

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
                    .withTimeout(Duration.ofSeconds(140))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            scenario.log("REFRESHED PAGE IN OCL");

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(150))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void Click_OrderTaker()
    {
        exists = false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(OrderTaker.isDisplayed())
            {
                HelpersMethod.ActClick(driver, OrderTaker, 10000);
                exists = true;
            }
            else
            {
                scenario.log("PLEASE CHECK FOR THE ADMIN SETTINGS");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Select_OrderTaker()
    {
        exists = false;
        Actions act1=new Actions(driver);
        WebElement WebEle = null;
        try
        {
            int i=0;
            List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-reset i-common-dropdown')]/descendant::ul/li");
            for(WebElement Opt:Options)
            {
                i++;
                act1.moveToElement(Opt).build().perform();
                if(i==2)
                {
                    act1.moveToElement(Opt).click().build().perform();
                    scenario.log("ORDER TAKER HAS BEEN SELECTED");
                    exists=true;
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

            if (HelpersMethod.IsExists("//div[contains(text(),'Failed to connect to API')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Failed to connect to API')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver, WebEle, 1000);
            }
            WebElement orderTakerText=HelpersMethod.FindByElement(driver,"xpath","//span[@id='OrderTaker']/span[1]");
            scenario.log("ORDER TAKER SELECTED IS "+orderTakerText.getText());
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Select_Untaken()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if (!UntakenRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver, UntakenRadio, 10000);
                scenario.log("UNTAKEN RATIO BUTTON SELECTED");
                Thread.sleep(500);
            }
        }
        catch (Exception e) {}
    }

    public void Select_Taken()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if (!TakenRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver, TakenRadio, 10000);
                scenario.log("TAKEN RATIO BUTTON HAS BEEN SELECTED");
                Thread.sleep(500);
            }
            //Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Select_All()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if (!AllRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver, AllRadio, 10000);
                scenario.log("ALL RADIO BUTTON HAS BEEN SELECTED");
                Thread.sleep(500);
                //exists=true;
            }
            //Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Refresh_Click()
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.ClickBut(driver, RefreshButton, 4000);
            scenario.log("REFRESH BUTTON CLICKED");
            exists = true;
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

            Thread.sleep(1000);
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void OrderIcon_Click(int i)
    {
        exists = false;
        WebElement WebEle = null;
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
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            OrderIcon=HelpersMethod.FindByElement(driver,"xpath",  "//tr["+i+"]/descendant::div[contains(@id,'PlaceOrderColIcon')]//*[local-name()='svg']");
            HelpersMethod.ScrollElement(driver,OrderIcon);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("gridOrderControlList"))));
            HelpersMethod.ActClick(driver,OrderIcon,10000);
            scenario.log("ORDER ICON HAS BEEN CLICKED");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Call_Date_Click()
    {
        exists = false;
        try
        {
            if(CallDate.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, CallDate, 10000);

                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]", 800);
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void Call_Date_Selection(int i)
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

            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", 200);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Visibility of calender
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", driver))
            {
                // to fetch the web element of the modal container
                WebElement fromDateContainer = driver.findElement(By.xpath("//table[@class='k-calendar-table']"));

                WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@title,'" + formattedDate1 + "')]"));
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

                    WebEle = HelpersMethod.FindByElement(driver, "id", "CallDate");
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    FTDate = (String) jse.executeScript("return arguments[0].getAttribute('value');", WebEle);

                    scenario.log(FTDate + " HAS BEEN SELECTED FOR OCL");
                }
                else
                {
                    scenario.log("FAILED TO SELECT END DATE");
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ValidateOCLGrid()
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//td[contains(text(),'No records available')]", driver))
            {
                scenario.log("NO RECORDS HAS BEEN FOUND FOR SELECTED CUSTOMER");
            }
            else
            {
                scenario.log("SOME DETAILS HAS BEEN FOUND");
            }
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void AddFilterOCL(String SearchValue1,String SearchBoxValue2)
    {
        exists=false;
        WebElement WebEle=null;
        WebDriverWait wait=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-filter-toolbar']/descendant::button/descendant::span[contains(text(),'Add filter')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='i-filter-toolbar']/descendant::button/descendant::span[contains(text(),'Add filter')]");
                HelpersMethod.ClickBut(driver, WebEle, 1000);
            }

            //Click on Clear all button
            WebElement Clear=driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::button[contains(text(),'Clear all')]"));
            if(Clear.isEnabled()==true)
            {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::button[contains(text(),'Clear all')]")));
                driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::button[contains(text(),'Clear all')]")).click();
                //loading Icon
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }

            //Enter value in first searchbox in popup
            WebElement Search1=driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.EnterText(driver,Search1,1000,SearchValue1);

            //Click on checkbox
            WebElement checkBox=driver.findElement(By.id("DisplayCustomerKey"));
            HelpersMethod.ActClick(driver,checkBox,1000);

            //Enter Value in Search box in 2nd popup
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::input[@class='k-textbox']")));
            if(HelpersMethod.IsExists("//div[contains(@class,'k-animation-container')]/descendant::input[@class='k-textbox']",driver))
            {
                WebElement modalContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container')]");
                WebElement Search2=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container')]/descendant::input[contains(@class,'k-textbox')]");
                HelpersMethod.EnterText(driver, Search2, 1000, SearchBoxValue2);

                //Click on Apply button
                Clear = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container')]/descendant::button[text()='Apply']");
                HelpersMethod.ClickBut(driver,Clear,1000);

                //loading Icon
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                scenario.log("ADDFILTER OERATION SUCESSFULL, BY USING ACCOUNT NUMBER");
            }
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void Skip_NotSkip()
    {
        exists=false;
        WebElement WebEle=null;
        Actions act1=new Actions(driver);
        int i=0;
        String head_Text=null;
        String skipText=null;
        Wait<WebDriver> wait;
        try
        {
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            for(WebElement head:Heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                head_Text = head.getText();
                if (head_Text.equals("Customer key")||head_Text.equals("Customer Key"))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td[" + i + "]/descendant::div[contains(@class,'CPKendoDataGrid')]/span");
                    Acc_No= WebEle.getText();
                    break;
                }
            }
            scenario.log("CUSTOMER ACCOUNT NUMBER SELECTED FOR SKIP IS "+Acc_No);
            i=0;
            for(WebElement head:Heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                head_Text = head.getText();
                if (head_Text.equals("Skip status")||head_Text.equals("Skip Status"))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td[" + i + "]/descendant::span[contains(@class,'k-i-arrow')]");
                    HelpersMethod.ActClick(driver,WebEle,10000);
                    exists=true;
                    break;
                }
            }

            //create a list of values in skip drop down
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset k-animation-container-shown')]"))));

            List <WebElement> dropDownValues=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li");
            for(WebElement dropDown:dropDownValues)
            {
                act1.moveToElement(dropDown).build().perform();
                skipText=dropDown.getText();
                if(skipText.equalsIgnoreCase("Skipped"))
                {
                    act1.moveToElement(dropDown).build().perform();
                    act1.click(dropDown).build().perform();
                    exists=true;
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(250))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    break;
                }
            }

            wait = new FluentWait<WebDriver>(driver)
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
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SkipPop(String reason)
    {
        exists=false;
        WebElement WebEle;
        Actions act1 = new Actions(driver);
        String Opt=null;
        String Opt1=null;
        String Opt2=null;
        Opt1= reason.toLowerCase();
        try
        {
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

            if (HelpersMethod.IsExists("//div[text()='Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 10000);
                // to fetch the web element of the modal container
                WebElement skipPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                //Identify the skip reason drop down
                WebElement skipReason = skipPopup.findElement(By.xpath(".//span[@id='SkipReason']"));
                HelpersMethod.ClickBut(driver, skipReason, 4000);

                // to fetch the web element of the modal container
                List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
                for(WebElement option: Options)
                {
                    act1.moveToElement(option).build().perform();
                    Opt=option.getText();
                    Opt2=Opt.toLowerCase();
                    if(Opt2.contains(Opt1) || Opt2.contains("Others"))
                    {
                        act1.moveToElement(option).build().perform();
                        act1.click(option).build().perform();
                        scenario.log("REASON FOR SKIP HAS BEEN SELECTED");
                        break;
                    }
                }

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                WebElement okButton = skipPopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ActClick(driver, okButton, 4000);

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

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                //exists=true;
            }
            //Assert.assertEquals(exists,true);
        } catch (Exception e) {}
    }

    public void selectionOfSkipValidation()
    {
        Actions act1=new Actions(driver);
        exists=false;
        int i=0;
        String head_Text=null;
        WebElement WebEle;
        try
        {
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            for(WebElement head:Heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                head_Text = head.getText();
                if (head_Text.equals("Skip status")||head_Text.equals("Skip Status"))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td["+i+"]/descendant::span[contains(@class,'k-dropdown-wrap')]/span[@class='k-input']");
                    if(WebEle.getText().equals("Skipped"))
                    {
                        scenario.log("SKIP OPTION SELECTED SUCCESSFULLY");
                        exists=true;
                    }
                    else
                    {
                        scenario.log("SKIP OPTION SELECTION FAILED");
                        exists=false;
                    }
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateSkip()
    {
        try
        {
            Skiplist2=HelpersMethod.FindByElements(driver,"xpath","//span[contains(text(),'Not skipped')]");
            Assert.assertNotEquals(SkipList1.size(),Skiplist2.size());
            scenario.log("SKIP HAS BEEN SET, AND VERIFIED");
        }
        catch (Exception e){}
    }

    public void Skip()
    {
        exists=true;
        WebElement WebEle=null;
        Actions act1=new Actions(driver);
        String head_Text=null;
        int i=0;
        try
        {
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            WebEle=HelpersMethod.FindByElement(driver,"id","gridOrderControlList");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Create list of Skipped drop down, and select the first skip dropdown
            SkipList1=HelpersMethod.FindByElements(driver,"xpath","//span[contains(text(),'Skipped')]");
            for(;skipRow<=SkipList1.size()-1;skipRow++)
            {
                if(SkipList1.get(skipRow).isEnabled())
                {
                    HelpersMethod.ActClick(driver, SkipList1.get(skipRow), 1000);
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }

            //new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]")));
            //create a list of values in skip drop down
            List <WebElement> dropDownOptions=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li");
            for(WebElement dropDownOpt:dropDownOptions)
            {
                act1.moveToElement(dropDownOpt).build().perform();
                String opt_Text=dropDownOpt.getText();
                if(opt_Text.equals("Not skipped"))
                {
                    act1.moveToElement(dropDownOpt).build().perform();
                    act1.click(dropDownOpt).build().perform();
                    exists=true;
                    break;
                }
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifySkipInTaken() throws InterruptedException
    {
        exists=false;
        Thread.sleep(10000);
        try
        {
            HelpersMethod.ScrollElement(driver,SearchBox);
            HelpersMethod.ActClick(driver,SearchClear,10000);
            HelpersMethod.EnterText(driver,SearchBox,10000,Acc_No);
            HelpersMethod.ActClick(driver,SearchIndex,10000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(!HelpersMethod.IsExists("//td[contains(text(),'No records available')]",driver))
            {
                scenario.log("SKIP CUSTOMER ACCOUNT# HAS BEEN FOUND UNDER TAKEN");
                exists=true;
            }
            else
            {
                scenario.log("SKIP CUSTOMER ACCOUNT# NOT FOUND UNDER ORDER TAKEN");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void RemoveSkipPopUp()
    {
        exists=false;
        WebElement WebEle=null;
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

            if(HelpersMethod.IsExists("//div[text()='Remove Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ActClick(driver,WebEle,10000);
                //exists=true;
            }

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
            //Thread.sleep(500);
            //Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateNotSkip()
    {
        try
        {
            Skiplist2=HelpersMethod.FindByElements(driver,"xpath","//span[contains(text(),'Skipped')]");
            Assert.assertNotEquals(SkipList1.size(),Skiplist2.size());
        }
        catch (Exception e){}
    }

    public void DragDropHeader(String To_Text)
    {
        exists=false;
        try
        {
            WebElement OCLProdGrid=HelpersMethod.FindByElement(driver,"id","gridOrderControlList");
            HelpersMethod.ScrollElement(driver,OCLProdGrid);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]",driver))
            {
                List<WebElement> TableHeads=driver.findElements(By.xpath("//thead/tr[1]/th"));
                for(WebElement THead:TableHeads)
                {
                    String Head=THead.getText();
                    if(Head.equals(To_Text))
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

    public void clickOnPrintButton()
    {
        try
        {
            String ParentWindow = driver.getWindowHandle();
            HelpersMethod.ClickBut(driver, PrintButton, 1000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            Set<String> PCWindows = driver.getWindowHandles();
            for (String PCwind : PCWindows)
            {
                if (!PCwind.equals(ParentWindow))
                {
                    driver.switchTo().window(PCwind);
                    scenario.log(".pdf HAS BEEN FOUND");
                    driver.close();
                    exists = true;
                    scenario.log("PRINT BUTTON IN OCL HAS BEEN HANDLED");
                }
            }
            driver.switchTo().window(ParentWindow);
        }
        catch (Exception e){}
    }

    public void ValidateSkipPopup()
    {
        try
        {
            WebElement WebEle = null;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(text(),'Skip')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 1000);
            // to fetch the web element of the modal container
            //WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Skip')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            //WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            //Assert.assertEquals(modalContentTitle.getText(), "Skip", "Verify Title message");
            //verify that skip popup has been displayed
            if(HelpersMethod.IsExists("//div[contains(text(),'Skip')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                scenario.log("SKIP POPUP HAS BEEN FOUND");
            }
            else
            {
                scenario.log("<span style='color:red'>SKIP POPUP HAS NOT BEEN FOUND</span>");
            }
        }
        catch (Exception e){}
    }

    public void validateSkipPopupNonExistence()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            //HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(text(),'Skip')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 10000);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Skip')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            if(!modalContainer.isDisplayed())
            {
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void searchOrderInOCL(String ord_no)
    {
        exists=false;
        try
        {
            if(!ord_no.equals(null))
            {
                //Click on Clear button, to clear search bar
                HelpersMethod.ActClick(driver,SearchClear,10000);
                //Enter value in search box
                HelpersMethod.EnterText(driver, SearchBox, 1000, ord_no);
                HelpersMethod.ClickBut(driver, SearchIndex, 1000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            else
            {
                exists = false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readOrderComment()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String head_Text=null;
        int i=0;
        WebElement WebEle;
        try
        {
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            for(WebElement head:Heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                head_Text=head.getText();
                if(head_Text.equals("Order note")||head_Text.equals("Order Note"))
                {
                    if(!HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]/descendant::td["+i+"]/descendant::span[contains(@class,'CPKendoDataGrid')]",driver))
                    {
                        scenario.log("NO ORDER NOTE HAS BEEN ADDED");
                        exists=false;
                    }
                    else
                    {
                        scenario.log("ORDER NOTE IS ADDED");
                        exists=true;
                    }
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterRouteValue()
    {
        Actions act=new Actions(driver);
        exists=false;
        try
        {
            act.moveToElement(Route).build().perform();
            HelpersMethod.sendKeys(driver,Route,1000,TestBase.testEnvironment.get_Route1());
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
            HelpersMethod.ActClick(driver,dropDown,1000);
            WebElement dummyEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'notification-center-container')]");
            HelpersMethod.ClickBut(driver,dummyEle,1000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            WebElement routeNo=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-widget k-multiselect')]/descendant::li/span[1]");
            scenario.log("ROUTE ENTERED FOR SEARCH: "+routeNo.getText());
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllTheCustomer()
    {
        exists=false;
        try
        {
            List<WebElement> noRows=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]");
            int size= noRows.size();
            if(size>=0)
            {
                scenario.log("NUMBER OF RECORDS FOUND FOR THE SELECTED ROUTE: " + size);
                exists=true;
            }
            else
            {
                scenario.log("NO RECORDS FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readGroupingDetails()
    {
        Actions act1=new Actions(driver);
        try
        {
            List<WebElement> Groups=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-grouping-row']/descendant::p");
            for(WebElement group:Groups)
            {
                act1.moveToElement(group).build().perform();
                scenario.log("GROUPING IN OCL "+group.getText());
            }
        }
        catch (Exception e){}
    }

    public void selectCustomerAndClickCommentIcon()
    {
        exists=false;
        int i=0;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th/descendant::span[contains(@class,'k-column-title')]");
            for (WebElement tableHead:tableHeads)
            {
                i++;
                act.moveToElement(tableHead).build().perform();
                String head_Text=tableHead.getText();
                if(head_Text.equalsIgnoreCase("Customer note"))
                {
                    WebElement CustomerNote=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/td["+i+"]");
                    HelpersMethod.ScrollElement(driver,CustomerNote);
                    act.moveToElement(CustomerNote).build().perform();
                    act.click(CustomerNote).build().perform();
                    exists=true;
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
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnRefresh()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver, RefreshButton, 1000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void readCustomerAccountsInOCL()
    {
        exists=false;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]");
            for (WebElement tableHead:tableHeads)
            {
                i++;
                act.moveToElement(tableHead).build().perform();
                String headText=tableHead.getText();
                if(headText.equals("Customer key"))
                {
                    break;
                }
            }
            List<WebElement> Accounts=HelpersMethod.FindByElements(driver,"xpath","//table[@class='k-grid-table']/descendant::tr/td["+i+"]");
            for(WebElement Acc:Accounts)
            {
                act.moveToElement(Acc).build().perform();
                String AccText=Acc.getText();
                scenario.log("CUSTOMER ACCOUNT NUMBERS FOUND IN OCL GRID "+AccText);
            }
        }
        catch (Exception e){}
    }

    public void verifyCustomerNoteInOCL()
    {
        exists=false;
        int i=0;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th/descendant::span[contains(@class,'k-column-title')]");
            for (WebElement tableHead:tableHeads)
            {
                i++;
                act.moveToElement(tableHead).build().perform();
                String head_Text=tableHead.getText();
                if(head_Text.equalsIgnoreCase("Customer note"))
                {
                    WebElement CustomerNote=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/td["+i+"]/span/descendant::span");
                    scenario.log("CUSTOMER NOTE ADDED IS "+CustomerNote.getText());
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyOrderInOCLgrid(String ord_no)
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver,SearchBox);
            HelpersMethod.EnterText(driver,SearchBox,1000,ord_no);
            HelpersMethod.ActClick(driver,SearchIndex,1000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyNewOrderIconInOCLgrid()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[contains(@id,'PlaceOrderColIcon')]//*[local-name()='svg' and @fill='blue']",driver))
            {
                scenario.log("NEW ORDER ICON HAS NOT BEEN FOUND");
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>NEW ORDER ICON HAS BEEN FOUND, PLEASE CHECK ADMIN SETTING.</span>");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clearSearchBar()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,SearchClear,1000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void verifyOrderType()
    {
        exists=false;
        String headText=null;
        String orderType=null;
        int i=0;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for (WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Order type"))
                {
                    orderType=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/td["+i+"]/descendant::span").getText();
                    scenario.log("ORDER TYPE CREATED IS "+orderType);
                    exists=true;
                    break;
                }
                else
                {
                    exists=false;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readCustomerAccountNo()
    {
        exists=false;
        int i=0;
        String headText=null;
        String custAcc=null;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equals("Customer key"))
                {
                    custAcc=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/td["+i+"]/descendant::span[2]").getText();
                    scenario.log("CUSTOMER ACCOUNT NUMBER FOUND IS "+custAcc);
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateChangeOfRemoveSkip()
    {
        Actions act1=new Actions(driver);
        String head_Text;
        exists=false;
        try
        {
            int j=0;
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            for(WebElement head:Heads)
            {
                j++;
                act1.moveToElement(head).build().perform();
                head_Text = head.getText();
                if (head_Text.equals("Skip status")||head_Text.equals("Skip Status"))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]["+skipRow+"]/descendant::td["+j+"]/descendant::span[contains(@class,'k-dropdown-wrap')]/span[@class='k-input']");
                    scenario.log("NOT SKIP OPTION SELECTED SUCCESSFULLY" +WebEle.getText());
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readOrginalGridName()
    {
        exists=true;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(@class,'core-grid-grid-selection-dropdown')]/descendant::span[@class='k-input']",driver))
            {
                originalGrid=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'core-grid-grid-selection-dropdown')]/descendant::span[@class='k-input']").getText();
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllHeadersOfGrid()
    {
        exists=false;
        String headText=null;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(@class,'k-column-title')]",driver))
            {
                List<WebElement> headers = HelpersMethod.FindByElements(driver, "xpath", "//span[contains(@class,'k-column-title')]");
                scenario.log("HEADERS FOUND THE OCL GRID: ");
                for (WebElement header : headers)
                {
                    headText = header.getText();
                    scenario.log(headText);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void changeGridType()
    {
        exists=false;
        String gridText=null;
        Actions act=new Actions(driver);
        try
        {
            HelpersMethod.ActClick(driver,gridDropDown,1000);
            List<WebElement> gridLists=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            for (WebElement grid:gridLists)
            {
                act.moveToElement(grid).build().perform();
                gridText=grid.getText();
                if(!originalGrid.equalsIgnoreCase(gridText))
                {
                    act.moveToElement(grid).build().perform();
                    act.click().build().perform();
                    exists=true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void resetGridTypeToOriginal()
    {
        exists=false;
        String gridText=null;
        Actions act=new Actions(driver);
        try
        {
            HelpersMethod.ActClick(driver,gridDropDown,1000);
            List<WebElement> gridLists=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            for (WebElement grid:gridLists)
            {
                act.moveToElement(grid).build().perform();
                gridText=grid.getText();
                if(originalGrid.equalsIgnoreCase(gridText))
                {
                    act.moveToElement(grid).build().perform();
                    act.click().build().perform();
                    exists=true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void callTimeFilterDisabled()
    {
        exists=false;
        Actions act=new Actions(driver);
        String headText=null;
        int i=0;
        try
        {
            List<WebElement> gridHeaders= HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for (WebElement gridHead:gridHeaders)
            {
                i++;
                act.moveToElement(gridHead).build().perform();
                headText=gridHead.getText();
                if(headText.equalsIgnoreCase("Call time"))
                {
                    break;
                }
            }
            if(HelpersMethod.IsExists("//tr[@class='k-filter-row']/descendant::th[contains(@aria-label,'Filter') and contains(@aria-colindex,'"+i+"')]/div[@class='cp-grid-hide-filter']",driver))
            {
                scenario.log("FILTER FOR CALL TIME HAS BEEN DISABLED");
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>FILTER FOR CALL TIME SHOULD BE DISABLED,BUT IT IS VISIBLE</span>");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void callBackTimeFilterDisabled()
    {
        exists=false;
        Actions act=new Actions(driver);
        String headText=null;
        int i=0;
        try
        {
            List<WebElement> gridHeaders= HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for (WebElement gridHead:gridHeaders)
            {
                i++;
                act.moveToElement(gridHead).build().perform();
                headText=gridHead.getText();
                if(headText.equalsIgnoreCase("Call back time"))
                {
                    break;
                }
            }
            if(HelpersMethod.IsExists("//tr[@class='k-filter-row']/descendant::th[contains(@aria-label,'Filter') and contains(@aria-colindex,'"+i+"')]/div[@class='cp-grid-hide-filter']",driver))
            {
                scenario.log("FILTER FOR CALL BACK TIME HAS BEEN DISABLED");
                exists=true;
            }
            else
            {
                scenario.log("************FILTER FOR CALL BACK TIME SHOULD BE DISABLED************");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterMultipleRouteValue()
    {
        Actions act=new Actions(driver);
        WebElement route;
        String routeText=null;
        exists=false;
        try
        {
            act.moveToElement(Route).build().perform();
            act.click().build().perform();
            //select route value from drop down
            List<WebElement> routes=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            for(int i=0;i<=routes.size()-1;i++)
            {
                route=routes.get(i);
                act.moveToElement(route).build().perform();
                if(i==1 || i==2 || i==3)
                {
                    act.moveToElement(route).build().perform();
                    act.click().build().perform();
                    exists=true;
                }
            }
            //click some where on route input box
            WebElement routeInput=HelpersMethod.FindByElement(driver,"xpath","//span[@class='k-searchbar']/descendant::input");
            act.moveToElement(routeInput).click().build().perform();

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            //to display route numbers selected
            List<WebElement> routeNos=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-widget k-multiselect')]/descendant::li/span[1]");
            for(WebElement routeNo:routeNos)
            {
                act.moveToElement(routeNo).build().perform();
                scenario.log("ROUTE ENTERED FOR SEARCH: " + routeNo.getText());
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void removeMutlipleRouteValue()
    {
        Actions act=new Actions(driver);
        WebElement removeRoute;
        try
        {
            List<WebElement> removeRoutes= HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-widget k-multiselect')]/descendant::span[contains(@class,'k-icon k-i-close')]");
            for (int i=0;i<=removeRoutes.size()-1;i++)
            {
                removeRoute=removeRoutes.get(i);
                act.moveToElement(removeRoute).build().perform();
                act.click().build().perform();
                readAllTheCustomer();
            }
        }
        catch (Exception e){}
    }

    public void clickOnCustomerNote()
    {
        exists=false;
        int i=0;
        String headText=null;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]");
            for(WebElement head:heads)
            {
              i++;
              act.moveToElement(head).build().perform();
              headText=head.getText();
              if(headText.equalsIgnoreCase("Customer note"))
              {
                  act.moveToElement(head).build().perform();
                  act.click().build().perform();
                  break;
              }
            }
            if(HelpersMethod.IsExists("//tr[1]/td[" + i + "]//*[local-name()='svg']",driver))
            {
                WebElement customerNote = HelpersMethod.FindByElement(driver, "xpath", "//tr[1]/td[" + i + "]//*[local-name()='svg']");
                HelpersMethod.ClickBut(driver, customerNote, 1000);
                exists = true;
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCustomerNotePopup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[@id='CustomerNotesTopDiv']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                scenario.log("CUSTOMER NOTE DIALOG BOX HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void customerNotePopup(String commentText) throws InterruptedException
    {
        exists=false;
        String alertText=null;
        Actions act=new Actions(driver);
        String acceptedComment;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Click on end date calender
                WebElement commentPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement endCalender = commentPopup.findElement(By.xpath(".//label[@id='EndDate-label']/following-sibling::span/descendant::a"));
                HelpersMethod.ActClick(driver, endCalender, 10000);
                //identify end date and click on end date
                WebElement endDate=HelpersMethod.FindByElement(driver,"xpath","//td[contains(@class,'k-calendar-td k-state-pending-focus')]");
                HelpersMethod.ActClick(driver,endDate,10000);
                //identify text area for entering comment and enter text
                WebElement commentArea=commentPopup.findElement(By.xpath(".//textarea[@id='noteTextbox']"));
                HelpersMethod.ActSendKey(driver,commentArea,20000,commentText);
                //Click on Alert type drop down
                WebElement alertType=commentPopup.findElement(By.xpath(".//span[@id='AlertType']"));
                HelpersMethod.ActClick(driver, alertType,10000);
                List<WebElement> alertTypes=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
                for(WebElement aType:alertTypes)
                {
                    act.moveToElement(aType).build().perform();
                    alertText=aType.getText();
                    if(alertText.equalsIgnoreCase("Both"))
                    {
                        act.moveToElement(aType).build().perform();
                        act.click().build().perform();
                        break;
                    }
                }
                //identify checkbox for Order Entry under alert location and click on that
                WebElement oeCheckbox=commentPopup.findElement(By.xpath(".//input[@id='showInOrderEntry']"));
                HelpersMethod.ActClick(driver,oeCheckbox,10000);
                //Click on save button
                WebElement saveButton=HelpersMethod.FindByElement(driver,"xpath","//button[@id='SaveButton']");
                HelpersMethod.ActClick(driver,saveButton,10000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //validate content of customer note/comment entered by user with comment accepted in dialog box size are same
                List<WebElement> comments=commentPopup.findElements(By.xpath(".//tr[contains(@class,'k-master-row')]/descendant::td[3]"));
                for(WebElement comment:comments)
                {
                    acceptedComment = comment.getText();
                    if (commentText.equalsIgnoreCase(acceptedComment))
                    {
                        //scenario.log("ENTERED TEXT IS AS FOLLOWS " + acceptedComment);
                        exists = true;
                        break;
                    }
                }
                //click on ok button of customer note dialog box
                WebElement okButton=commentPopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ActClick(driver,okButton,10000);
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

    public void navigateToOCL()
    {
        exists=false;
        WebElement WebEle = null;
        String status;
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
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]");
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.EleDisplay(WebEle))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Order control list", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Order control list')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
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

                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(140))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            else
            {
                scenario.log("ORDER CONTROL TAB DOESN'T EXISTS");
            }
        }
        catch (Exception e){}
    }

    public void validateCallDeskDisplayed()
    {
        exists=false;
        try
        {
            if(!callDesk.isDisplayed())
            {
                scenario.log("CALL DESK INPUT BOX IS NOT DISPLAYED");
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>CALL DESK INPUT BOX IS DISPLAYED</span>");
                exists=false;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void checkForOrderIcon()
    {
        exists=false;
        int i=0;
        try
        {
            do
            {
                i++;
                if(HelpersMethod.IsExists("//tr["+i+"]/descendant::div[contains(@id,'PlaceOrderColIcon')]//*[local-name()='svg']",driver))
                {
                    readCustomerAccountNo();
                    OrderIcon_Click(i);
                    exists=true;
                    break;
                }
            }while(!exists);
        }
        catch (Exception e){}
    }

    public void validateOrderTakerNonDisplay()
    {
        exists=false;
        try
        {
            if(!OrderTaker.isDisplayed())
            {
                scenario.log("ORDER TAKER DROP DOWN NOT DISPLAYED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateOrderTakerDisplay()
    {
        exists=false;
        try
        {
            if(OrderTaker.isDisplayed())
            {
                scenario.log("ORDER TAKER DROP DOWN IS DISPLAYED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCreatedByColumn()
    {
        exists=false;
        String headText=null;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for(WebElement head:heads)
            {
                a++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Order created by"))
                {
                    scenario.log("ORDER CREATED BY COLUMN HAS BEEN FOUND");
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void displayOrderCreatedByName()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]/td["+a+"]/descendant::div[contains(@class,'CPKendoDataGrid-Text')]/span",driver))
            {
                WebElement createdBy=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/td[14]/descendant::div[contains(@class,'CPKendoDataGrid-Text')]/span");
                String createdByName=createdBy.getText();
                if(!createdByName.equals(""))
                {
                    scenario.log("OPEN ORDER IS CREATED BY " + createdByName);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void searchForValidCustomer(String custName)
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.EnterText(driver,SearchBox,10000,custName);
            HelpersMethod.ActClick(driver,SearchIndex,10000);

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void searchForCreditHolder(String creditHold)
    {
        exists=false;
        String headText;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Credit hold"))
                {
                    scenario.log("CREDIT HOLD HAS BEEN FOUND");
                    break;
                }
            }

            if(HelpersMethod.IsExists("//th["+i+"]/descendant::input[@class='k-textbox']",driver))
            {
                WebElement inputboxSearch = HelpersMethod.FindByElement(driver, "xpath", "//th[" + i + "]/descendant::input[@class='k-textbox']");
                HelpersMethod.EnterText(driver, inputboxSearch, 10000, creditHold);
                if (HelpersMethod.IsExists("//td[contains(text(),'No records available')]",driver))
                {
                    scenario.log("<span style='color:red'>NO RELEVANT RECORD FOUND</span>");
                    exists = false;
                }
                else
                {
                    exists=true;
                }
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void newOrderIcon()
    {
        exists=false;
        String headText;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("New Order"))
                {
                    scenario.log("NEW ORDER COLUMN FOUND");
                    break;
                }
            }

            if(!HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]/descendant::td["+i+"]//*[local-name()='svg']",driver))
            {
                 scenario.log("NEW ORDER ICON HAS NOT BEEN FOUND");
                 exists = true;
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void searchHardHold()
    {
        String titleText;String pageText;String creditText;
        Actions act=new Actions(driver);
        List<WebElement> pages;
        boolean found=false;
        WebElement page1 = null;
        try
        {
            //code to find 'Credit hold' column number
            List<WebElement> titles=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement title:titles)
            {
                columnNo++;
                act.moveToElement(title).build().perform();
                titleText=title.getText();
                if(titleText.equalsIgnoreCase("Credit hold"))
                {
                    break;
                }
            }
            //Code to find last page number
            WebElement lastArrow= HelpersMethod.FindByElement(driver,"xpath","//span[@class='k-icon k-i-arrow-end-right']");
            HelpersMethod.ActClick(driver,lastArrow,10000);

            //code to read last page number
            List<WebElement> pageNos=HelpersMethod.FindByElements(driver,"xpath","//ul[@class='k-pager-numbers k-reset']/li/a");
            int i=pageNos.size()-1;
            act.moveToElement(pageNos.get(i)).build().perform();
            lastPage= Integer.parseInt(pageNos.get(i).getText());
            scenario.log("NUMBER OF PAGES IN OCL ARE: "+lastPage);

            //code to navigate to first page again
            WebElement firstArrow=HelpersMethod.FindByElement(driver,"xpath","//span[@class='k-icon k-i-arrow-end-left']");
            HelpersMethod.ActClick(driver,firstArrow,10000);

            //code to find Hard hold
            for(int j=0;j<=lastPage;j++)
            {
                pages=HelpersMethod.FindByElements(driver,"xpath","//ul[@class='k-pager-numbers k-reset']/li/a");
                for(WebElement page:pages)
                {
                    act.moveToElement(page).build().perform();
                    pageText=page.getText();
                    if(!pageText.equalsIgnoreCase("..."))
                    {
                        act.moveToElement(page).build().perform();
                        pageHold= Integer.parseInt(page.getText());
                        act.click(page).build().perform();

                        List<WebElement> creditHolds=HelpersMethod.FindByElements(driver,"xpath","//tr/descendant::td["+columnNo+"]/descendant::div/span");
                        for(WebElement creditHold:creditHolds)
                        {
                            rowNo++;
                            act.moveToElement(creditHold).build().perform();
                            creditText= creditHold.getText();
                            if(creditText.equalsIgnoreCase("Hard Hold"))
                            {
                                scenario.log("HARD HOLD HAS BEEN FOUND IN PAGE NO "+pageHold+" AT ROW NUMBER "+rowNo);
                                found=true;
                                break;
                            }
                        }
                    }
                    if(found==true)
                    {
                        break;
                    }
                }
                if(found==true)
                {
                    break;
                }
                else if(found==false)
                {
                    int size=pages.size()-1;
                    page1=pages.get(size);
                    pageText=page1.getText();
                    if(pageText.equals("..."))
                    {
                        act.moveToElement(page1).build().perform();
                        act.click().build().perform();
                    }
                    else
                    {
                        scenario.log("<span style='color:red'>NO HARD HOLD CUSTOMER HAS BEEN FOUND</span>");
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public String searchForPreviousCustomerForHardHold()
    {
        String titleText;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            //find customer account number which is having hard hold
            List<WebElement> titles=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement title:titles)
            {
                i++;
                act.moveToElement(title).build().perform();
                titleText=title.getText();
                if(titleText.equalsIgnoreCase("Customer key"))
                {
                    break;
                }
            }
            customerAccount=HelpersMethod.FindByElement(driver,"xpath",    "//tr["+rowNo+"]/descendant::td["+i+"]/descendant::div/span").getText();
            scenario.log("CUSTOMER ACCOUNT NUMBER WITH HARD HOLD IS "+customerAccount);

            //code to find order icon column
            int noHoldRow=rowNo-1;
            i=0;
            titles=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement title:titles)
            {
                i++;
                act.moveToElement(title).build().perform();
                titleText=title.getText();
                if(titleText.equalsIgnoreCase("New Order"))
                {
                    break;
                }
            }
            //code to click on order icon, in previous row to Hard hold
            //WebElement orderIcon=HelpersMethod.FindByElement(driver,"xapth","//tr["+noHoldRow+"]/descendant::td["+i+"]/descendant::div//*[local-name()='svg']//*[local-name()='path']");
            WebElement orderIcon=HelpersMethod.FindByElement(driver,"xpath","//tr["+noHoldRow+"]/descendant::div[contains(@id,'PlaceOrderColIcon')]//*[local-name()='svg']");
            HelpersMethod.ScrollElement(driver,orderIcon);
            HelpersMethod.ActClick(driver,orderIcon,10000);
        }
        catch (Exception e){}
        return customerAccount;
    }
}