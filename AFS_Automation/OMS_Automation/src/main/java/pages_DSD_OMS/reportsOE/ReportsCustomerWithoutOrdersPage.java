package pages_DSD_OMS.reportsOE;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java8.Th;
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
import util.TestBase;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class ReportsCustomerWithoutOrdersPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;

    @FindBy(xpath="//label[text()='From date']/following-sibling::span/descendant::button//*[local-name()='svg']")
    private WebElement fromCal;

    @FindBy(xpath="//label[text()='To date']/following-sibling::span/descendant::button//*[local-name()='svg']")
    private WebElement toCal;

    @FindBy(xpath="//label[text()='From date']/following-sibling::span/descendant::input")
    private WebElement fromDate;

    @FindBy(xpath="//label[text()='To date']/following-sibling::span/descendant::input")
    private WebElement toDate;

    @FindBy(id="selectedCustomersSwitch")
    private WebElement showSelectedCustomerToggle;

    @FindBy(xpath="//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][1]/descendant::tr[@class='k-filter-row']/descendant::input[1]")
    private WebElement filterForAccount;

    @FindBy(id="generateExcel")
    private WebElement excelButton;

    @FindBy(id="generatePDF")
    private WebElement pdfButton;

    public ReportsCustomerWithoutOrdersPage(WebDriver driver, Scenario scenario)
    {
        this.scenario = scenario;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToReport()
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
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            HelpersMethod.navigate_Horizantal_Tab(driver, "Reports", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Reports')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void Refresh_Page(String currentURL)
    {
        Wait<WebDriver> wait;
        Actions act1=new Actions(driver);
        String status="";
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]", driver)) {
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
            HelpersMethod.JScriptClick(driver, OEMenu, 10000);
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
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }

            if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                WebElement pendingPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement dismissAll = pendingPopup.findElement(By.xpath("//button[contains(@id,'QuestionModalButton')"));
                HelpersMethod.ActClick(driver, dismissAll, 1000);
            }
            humBurger = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            act1.moveToElement(humBurger).click().build().perform();

            humBurger = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            act1.moveToElement(humBurger).build().perform();
            act1.click().build().perform();

            //find whether side menu bar has expanded
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 40000);
            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
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
            Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'searchbar-container')]/descendant::input[@id='navigationMenuSearchBar']");
            act1.moveToElement(Search_Input).click().build().perform();
            HelpersMethod.JSSetValueEle(driver, Search_Input, 10000, "Order Entry");

            OEMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Order Entry')]");
            HelpersMethod.JScriptClick(driver, OEMenu, 10000);
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

            if (HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement pendingPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Your order has not been submitted')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement dismissAll = pendingPopup.findElement(By.xpath("//button[contains(@id,'QuestionModalButton')"));
                HelpersMethod.ActClick(driver, dismissAll, 10000);
            }
            humBurger = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            act1.moveToElement(humBurger).click().build().perform();

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //navigate to Reports
            navigateToReport();
            scenario.log("REFRESHED REPORTS PAGE");

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
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void validateReportsPage()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String title=HelpersMethod.gettingTitle(driver);
            if(title.equals("Reports"))
            {
                scenario.log("NAVIGATED TO REPORTS PAGE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void horizantalMenu(String MenuItem)
    {
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            String Menu_Text = null;
            Actions act = new Actions(driver);
            List<WebElement> MenuBars = HelpersMethod.FindByElements(driver, "xpath", "//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[@class='i-tabstrip-wrapper ']/descendant::li[contains(@class,'k-item ')]/span");
            for (WebElement Menu : MenuBars)
            {
                act.moveToElement(Menu).build().perform();
                Menu_Text = Menu.getText();
                if (MenuItem.equals(Menu_Text) || Menu_Text.contains(MenuItem))
                {
                    act.moveToElement(Menu).build().perform();
                    act.click(Menu).build().perform();
                    break;
                }
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e) {}
    }

    public void clickOnFromDate()
    {
        exists=false;
            if(fromCal.isDisplayed() && fromCal.isEnabled())
            {
                HelpersMethod.ClickBut(driver,fromCal,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
    }

    public void selectFromDate() throws InterruptedException
    {
        exists=false;
            Thread.sleep(1000);
            WebElement fromDate=HelpersMethod.FindByElement(driver,"xpath","//td[contains(@class,'k-today')]");
            if(fromDate.isDisplayed())
            {
                HelpersMethod.ActClick(driver,fromDate,20000);
                scenario.log("FROM DATE HAS BEEN SELECTED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
    }

    public void clickOnToDate() throws InterruptedException
    {
        exists=false;
        Thread.sleep(1000);
            if(toCal.isDisplayed() && toCal.isEnabled())
            {
                HelpersMethod.ActClick(driver,toCal,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
    }

    public void selectToDate()
    {
        exists=false;
        try
        {
            Thread.sleep(1000);
            WebElement toDate=HelpersMethod.FindByElement(driver,"xpath","//td[contains(@class,'k-today')]");
            if(toDate.isDisplayed())
            {
                String todateText = HelpersMethod.AttributeValue(toDate, "title");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
                LocalDate dateTime = LocalDate.parse(todateText, formatter);
                LocalDate dateTime1=dateTime.plusDays(2);
                DateTimeFormatter currentFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                String dateText = dateTime1.format(currentFormatObj);
                WebElement changeDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-calendar-view')]/descendant::td[@class='k-calendar-td' and @title='"+dateText+"']");
                HelpersMethod.ActClick(driver,changeDate,10000);
                scenario.log("TO DATE SELECTED");
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
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

    public void selectFilteredAccountNo1()
    {
        exists=false;
        try
        {
            Thread.sleep(1000);
            List<WebElement> checkBoxs=HelpersMethod.FindByElements(driver,"xpath","//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][1]/descendant::tr[contains(@class,'k-master-row')]/descendant::input");
            for (int i = 1; i <=checkBoxs.size()-1; i++)
            {
                if(i==1||i==2)
                {
                    if (HelpersMethod.IsExists("//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][1]/descendant::tr[contains(@class,'k-master-row')][" + i + "]/descendant::input", driver))
                    {
                        WebElement accountCheckBox = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][1]/descendant::tr[contains(@class,'k-master-row')][" + i + "]/descendant::input");
                        HelpersMethod.JScriptClick(driver, accountCheckBox, 10000);
                        scenario.log("SELECTED SOME RANDOM ACCOUNTS");
                        exists = true;
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterAccountNoInFilter()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(filterForAccount.isDisplayed())
            {
                HelpersMethod.EnterText(driver,filterForAccount,20000, TestBase.testEnvironment.get_Account());
                scenario.log("ENTERED CUSTOMER ACCOUNT NUMBER IN FILTER");
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

    public void selectFilteredAccountNo()
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
            if (HelpersMethod.IsExists("//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][1]/descendant::tr[contains(@class,'k-master-row')]/descendant::input", driver))
            {
                WebElement accountCheckBox = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][1]/descendant::tr[contains(@class,'k-master-row')]/descendant::input");
                HelpersMethod.ScrollElement(driver,accountCheckBox);
                HelpersMethod.ActClick(driver, accountCheckBox, 30000);
                scenario.log("SELECTED CUSTOMER ACCOUNT CHECKBOX");
                exists=true;
            }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clearFilter()
    {
        exists=false;
        try
        {
            Thread.sleep(500);
            WebElement clearFilter=HelpersMethod.FindByElement(driver,"xpath","//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][1]/descendant::tr[@class='k-filter-row']/descendant::button[contains(@class,'clear')]");
            if(clearFilter.isDisplayed()&& clearFilter.isEnabled())
            {
                HelpersMethod.ClickBut(driver,clearFilter,10000);
                scenario.log("FILTER HAS BEEN CLEARED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickShowSelectedCustomer()
    {
        exists=false;
        try
        {
            if(showSelectedCustomerToggle.isDisplayed())
            {
                HelpersMethod.ActClick(driver,showSelectedCustomerToggle,10000);
                if(HelpersMethod.IsExists("//span[@id='selectedCustomersSwitch' and @aria-checked='true']",driver))
                {
                    scenario.log("SHOW SELECTED CUSTOMER TOGGLE BUTTON IS SELECTED");
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllSelectedCustomer()
    {
        exists=false;
        String accText;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> selectedAccount=HelpersMethod.FindByElements(driver,"xpath","//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][1]/descendant::tr[contains(@class,'k-master-row')]/descendant::td[2]");
            if(selectedAccount.size()!=0)
            {
                scenario.log("CUSTOMER ACCOUNT NUMBER SELECTED FOR GENERATING REPORTS");
                for (WebElement selectAcc:selectedAccount)
                {
                    act.moveToElement(selectAcc).build().perform();
                    accText=selectAcc.getText();
                    scenario.log(accText);
                }
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>NO CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnExcel()
    {
        exists=false;
        try
        {
            Thread.sleep(500);
            if(excelButton.isDisplayed() && excelButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,excelButton,10000);
                Thread.sleep(500);
                if (HelpersMethod.IsExists("//div[contains(text(),'No data returned, report was not generated.')]/ancestor::div[@id='toast-container']", driver))
                {
                    scenario.log("<span style='color:red'>NO DATA HAS BEEN FOUND TO GENERATE REPORTS</span>");
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'No data returned, report was not generated.')]/ancestor::div[@id='toast-container']")));
                    //exists=true;
                }
                else
                {
                    scenario.log("EXCEL REPORT IS GENERATED");
                    exists = true;
                }
            }
            else
            {
                scenario.log("<span style='color:red'>EXCEL BUTTON DISABLED</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnPdf()
    {
        exists=false;
        try
        {
            Thread.sleep(500);
            if(pdfButton.isDisplayed() && pdfButton.isEnabled())
            {
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, pdfButton, 10000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                scenario.log("TO GENERATE THE REPORT IN .pdf FORMATE BUTTON HAS BEEN CLICKED");
                Thread.sleep(5000);
                if (HelpersMethod.IsExists("//div[contains(text(),'No data returned, report was not generated.')]/ancestor::div[@id='toast-container']", driver))
                {
                    scenario.log("<span style='color:red'>NO DATA HAS BEEN FOUND TO GENERATE REPORTS</span>");
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'No data returned, report was not generated.')]/ancestor::div[@id='toast-container']")));
                    //exists=true;
                }
                else
                {
                    Set<String> PCWindows = driver.getWindowHandles();
                    for (String PCwind : PCWindows)
                    {
                        if (!PCwind.equals(ParentWindow))
                        {
                            driver.switchTo().window(PCwind);
                            driver.close();
                            scenario.log(".pdf HAS BEEN FOUND");
                            exists = true;
                        }
                    }
                    driver.switchTo().window(ParentWindow);
                }
            }
            else
            {
                scenario.log("PDF BUTTON IS DISABLED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectInvalidToDate()
    {
        exists=false;
        try
        {
            Thread.sleep(500);
            WebElement toDate=HelpersMethod.FindByElement(driver,"xpath","//td[contains(@class,'k-today')]");
            if(toDate.isDisplayed())
            {
                String todateText = HelpersMethod.AttributeValue(toDate, "title");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
                LocalDate dateTime = LocalDate.parse(todateText, formatter);
                LocalDate dateTime1=dateTime.minusDays(2);
                DateTimeFormatter currentFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                String dateText = dateTime1.format(currentFormatObj);
                WebElement changeDate=HelpersMethod.FindByElement(driver,"xpath","//td[contains(@class,'k-disabled') and @title='"+dateText+"']");
                if(HelpersMethod.IsExists("//td[contains(@class,'k-disabled') and @title='"+dateText+"']",driver))
                {
                    scenario.log("SELECTION OF INVALID TO DATE IS NOT POSSIBLE");
                    exists=true;
                }
                else
                {
                    HelpersMethod.ActClick(driver, changeDate, 10000);
                    exists=false;
                    scenario.log("<span style='color:red'>TO DATE SELECTED, IT IS NOT EXPECTED BEHAVIOUR</span>");
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enabledExcel() throws InterruptedException
    {
        exists=false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        HelpersMethod.ScrollElement(driver,excelButton);
        Thread.sleep(1500);
        if(excelButton.isDisplayed() && excelButton.isEnabled())
        {
            scenario.log("EXCEL BUTTON IS ENABLED");
            exists=true;
        }
        else
        {
            scenario.log("EXCEL BUTTON IS DISABLED");
        }
        Assert.assertEquals(exists,true);
    }

    public void enabledPdf() throws InterruptedException
    {
        exists=false;
        Thread.sleep(1500);
        if(pdfButton.isDisplayed() && pdfButton.isEnabled())
        {
            scenario.log("PDF BUTTON IS ENABLED");
            exists=true;
        }
        else
        {
            scenario.log("PDF BUTTON IS DISABLED");
        }
        driver.navigate().refresh();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        Assert.assertEquals(exists,true);
    }

    public void selectFilterForRoutesNo1()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(500);
            List<WebElement> checkBoxs=HelpersMethod.FindByElements(driver,"xpath","//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][2]/descendant::tr[contains(@class,'k-master-row')]/descendant::input");
            for (int i = 1; i <=checkBoxs.size()-1; i++)
            {
                if(i==1||i==2)
                {
                    if (HelpersMethod.IsExists("//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][2]/descendant::tr[contains(@class,'k-master-row')][" + i + "]/descendant::input", driver))
                    {
                        WebElement accountCheckBox = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][2]/descendant::tr[contains(@class,'k-master-row')][" + i + "]/descendant::input");
                        HelpersMethod.JScriptClick(driver, accountCheckBox, 10000);
                        scenario.log("SELECTED SOME RANDOM ROUTES");
                        exists = true;
                    }
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

    public void enterRouteNoInFilterForRoutes()
    {
        exists=false;
        try
        {
            WebElement filterForRoute= HelpersMethod.FindByElement(driver,"xpath",   "//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][2]/descendant::tr[@class='k-filter-row']/descendant::input[1]");
            if(filterForRoute.isDisplayed())
            {
                HelpersMethod.EnterText(driver,filterForRoute,10000, TestBase.testEnvironment.get_Account());
                scenario.log("ENTERED ROUTE NUMBER IN FILTER");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectFilteredRouteNoForRoutes()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][2]/descendant::tr[contains(@class,'k-master-row')]/descendant::input", driver))
            {
                WebElement accountCheckBox = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][2]/descendant::tr[contains(@class,'k-master-row')]/descendant::input");
                HelpersMethod.JScriptClick(driver, accountCheckBox, 10000);
                scenario.log("SELECTED ROUTE CHECKBOX");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clearFilterForRoutes()
    {
        exists=false;
        try
        {
            WebElement clearFilter=HelpersMethod.FindByElement(driver,"xpath","//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][2]/descendant::tr[@class='k-filter-row']/descendant::button[contains(@class,'clear')]");
            if(clearFilter.isDisplayed()&& clearFilter.isEnabled())
            {
                HelpersMethod.ClickBut(driver,clearFilter,10000);
                scenario.log("FILTER HAS BEEN CLEARED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickShowSelectedRoutes()
    {
        exists=false;
        try
        {
            showSelectedCustomerToggle=HelpersMethod.FindByElement(driver,"id","selectedRoutesSwitch");
            if(showSelectedCustomerToggle.isDisplayed())
            {
                HelpersMethod.ActClick(driver,showSelectedCustomerToggle,10000);
                scenario.log("SHOW SELECTED CUSTOMER TOGGLE BUTTON IS SELECTED");
                exists=true;
                Thread.sleep(500);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllSelectedCustomerForRoutes()
    {
        exists=false;
        String accText;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> selectedAccount=HelpersMethod.FindByElements(driver,"xpath","//div[@id='customersWithoutOrdersInfoNotification']/parent::div/descendant::div[contains(@class,'k-animation-container-relative')][1]/descendant::tr[contains(@class,'k-master-row')]/descendant::td[2]");
            if(selectedAccount.size()!=0)
            {
                scenario.log("ROUTE NUMBER SELECTED FOR GENERATING REPORTS");
                for (WebElement selectAcc:selectedAccount)
                {
                    act.moveToElement(selectAcc).build().perform();
                    accText=selectAcc.getText();
                    scenario.log(accText);
                }
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>NO ROUTE NUMBER HAS BEEN SELECTED</span>");
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void invisiblityOfLoading()
    {
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(@class,'k-icon k-i-loading')]")));
        }
        catch (Exception e){}
    }

    public void readFromDate()
    {
        try
        {
            String fromDateText=HelpersMethod.JSGetValueEle(driver,fromDate,10000);
            if(fromDateText.equals("")||fromDateText.equals(null))
            {
                scenario.log("FROM DATE SELECTED IS "+fromDateText);
            }
        }
        catch (Exception e){}
    }

    public void readToDate()
    {
        try
        {
            String toDateText=HelpersMethod.JSGetValueEle(driver,toDate,10000);
            if(toDateText.equals("")||toDateText.equals(null))
            {
                scenario.log("TO DATE SELECTED IS "+toDateText);
            }
        }
        catch (Exception e){}
    }
}
