package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
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
import pages_DSD_OMS.login.HomePage;
import util.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class AdminHomePage {
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;

    @FindBy(xpath = "//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]")
    private WebElement PermissionBy;

    @FindBy(id = "save-btn")
    private WebElement SaveButton;

    @FindBy(id = "cancel-btn")
    private WebElement CancelButton;

    @FindBy(id="gridName")
    private WebElement gridName;

    //Action
    public AdminHomePage(WebDriver driver, Scenario scenario)
    {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    public void ValidatingAdminHome() throws InterruptedException
    {
        exists = false;
        String title = null;
        WebElement WebEle;
        String status = null;

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        //Thread.sleep(6000);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try {
            title = driver.getTitle();
            if (title.contains("Admin")) {
                scenario.log("ADMIN PAGE HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void ValidatingAdminHome1() {
        exists = false;
        String title = null;
        try {
            title = driver.getTitle();
            if (title.contains("Admin")) {
                scenario.log("ADMIN PAGE HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    //Click on Permission by
    public void ClickPermissionBy()
    {
        exists = false;
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
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            if (HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]", driver))
            {
                PermissionBy = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'i-header-toolbar-expandable-button')]");
                HelpersMethod.ActClick(driver, PermissionBy, 4000);
                new WebDriverWait(driver, Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup i-header-toolbar-popup k-child-animation-container')]"))));
                if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver))
                {
                    scenario.log("PERMISSION DROP DOWN HAS BEEN CLICKED, TO SELECT COMPANY");
                    exists = true;
                }
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }


    public void ClickPermissionByAgain()
    {
        exists = false;
        try
        {
            Thread.sleep(6000);
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
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            if (HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]", driver))
            {
                PermissionBy = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'i-header-toolbar-expandable-button')]");
                HelpersMethod.ActClick(driver, PermissionBy, 4000);
                new WebDriverWait(driver, Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup i-header-toolbar-popup k-child-animation-container')]"))));
                if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver))
                {
                    scenario.log("PERMISSION DROP DOWN HAS BEEN CLICKED, TO SELECT COMPANY");
                    exists = true;
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //Method for Selecting company
    public void SelectCompany() throws InterruptedException
    {
        exists = false;
        WebElement WebEle;
        Actions act = new Actions(driver);
        String company = null;
        String status=null;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver))
            {
                //Click on Company drop down
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@id,'dropdownList3')]");
                HelpersMethod.ActClick(driver, WebEle, 8000);
                //Create list of web elements in dropdown
                company = TestBase.testEnvironment.get_CompanyNo();
                //identify the company drop down, and values in list
                List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li[contains(@class,'k-item')]");
                for (WebElement Val : Values)
                {
                    act.moveToElement(Val).build().perform();
                    String Val_Text = Val.getText();
                    if (Val_Text.equalsIgnoreCase(company) || Val_Text.contains(company))
                    {
                        act.moveToElement(Val).build().perform();
                        act.click(Val).build().perform();
                        scenario.log("COMPANY HAS BEEN SELECTED");
                        exists = true;
                        break;
                    }
                }
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
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            //Thread.sleep(2000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(160))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void SelectDefaultCompany() {
        exists = false;
        WebElement WebEle;
        Actions act = new Actions(driver);
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver)) {
                //Click on Company drop down
                WebEle = HelpersMethod.FindByElement(driver, "id", "dropdownList3");
                HelpersMethod.ClickBut(driver, WebEle, 1000);
                //Create list of web elements in dropdown
                List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::li");
                for (WebElement Val : Values) {
                    act.moveToElement(Val).build().perform();
                    String Val_Text = Val.getText();
                    if (Val_Text.equalsIgnoreCase("000000, Default") || Val_Text.contains("Default"))
                    {
                        act.click(Val).build().perform();
                        break;
                    }
                }
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='dropdownList3']/span[1]");
                scenario.log("COMPANY SELECTED IS " + WebEle.getText());
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                if (HelpersMethod.IsExists("//span[contains(@class,'k-i-arrow-chevron-up')]", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'k-i-arrow-chevron-up')]");
                    HelpersMethod.JScriptClick(driver, WebEle, 4000);
                }
            }
        } catch (Exception e) {
        }
    }

    public void ClickOnHumburger() {
        exists = false;
        WebElement WebEle;
        WebElement Humburger;
        try {
            Thread.sleep(1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
            }

            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("app")));
            scenario.log("IN ADMIN PAGE");
            WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer')]");
            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer')]")));
            Actions act1 = new Actions(driver);
            //Move mouse on menu icon
            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]"))));
            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));

            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            act1.moveToElement(WebEle).click().build().perform();

            //find whether side menu bar has expanded
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 800);
            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
            act1.moveToElement(side_menu).build().perform();
        } catch (Exception e) {
        }
    }

    public void clickOnHumbergerAgain() {
        exists = false;
        WebElement WebEle;
        WebElement Humburger;
        try {
            Thread.sleep(500);
            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("app")));
            scenario.log("IN ADMIN PAGE");
            WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer')]");
            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer')]")));
            Actions act1 = new Actions(driver);
            //Move mouse on menu icon
            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]"))));
            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));

            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            act1.moveToElement(WebEle).click().build().perform();

            //find whether side menu bar has expanded
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 800);
            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
            act1.moveToElement(side_menu).build().perform();
        } catch (Exception e) {
        }
    }

    public void CloseHumburger() {
        exists = false;
        WebElement Humburger;
        try {
            if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver)) {
                Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                HelpersMethod.ActClick(driver, Humburger, 15000);
            }
        } catch (Exception e) {
        }
    }

    //Select menu value from the side search box
    public void EnterValueInSearchBox(String Menu_Value) {
        Actions act = new Actions(driver);
        WebElement WebEle;
        try {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-application-container']");
            act.moveToElement(WebEle).build().perform();
            WebElement ClearSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='searchbar-container']/descendant::i[@class='searchbar-container-close-icon']//*[local-name()='svg']");
            if (ClearSearch.isDisplayed()) {
                HelpersMethod.ActClick(driver, ClearSearch, 1000);
            }
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).sendKeys(Menu_Value).build().perform();
            WebElement Menu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'" + Menu_Value + "')]");
            HelpersMethod.ActClick(driver, Menu, 1000);

            if (ClearSearch.isDisplayed()) {
                HelpersMethod.ActClick(driver, ClearSearch, 1000);
                WebElement Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                HelpersMethod.ActClick(driver, Humburger, 1000);
                new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(By.id("navigationMenuSearchBar"))));
            }
        } catch (Exception e) {
        }
    }

    //Selecting tab from horizontal menu bar
    public void Horizantal_MenuBar(String MenuItem)
    {
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
            String Menu_Text = null;
            Actions act = new Actions(driver);
            List<WebElement> MenuBars = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='topMenu']/descendant::li/span");
            for (WebElement Menu : MenuBars) {
                act.moveToElement(Menu).build().perform();
                Menu_Text = Menu.getText();
                if (MenuItem.equals(Menu_Text)) {
                    act.click(Menu).build().perform();
                    break;
                }
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
        } catch (Exception e) {
        }
    }

    //Click on Save button
    public void Click_SaveButton()
    {
        exists = false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }

            if (SaveButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, SaveButton, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement savePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement okButton=savePopup.findElement(By.xpath(".//button[text()='OK']"));
                    HelpersMethod.ClickBut(driver,okButton,1000);
                }
                exists = true;
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void EnterValueInSearchBox1(String Menu_Value, String subMenuValue)
    {
        exists = false;
        Actions act = new Actions(driver);
        WebElement WebEle;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-application-container']");
            act.moveToElement(WebEle).build().perform();
            WebElement ClearSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='searchbar-container']/descendant::i[@class='searchbar-container-close-icon']//*[local-name()='svg']");
            if (ClearSearch.isDisplayed())
            {
                HelpersMethod.ActClick(driver, ClearSearch, 1000);
            }
            //Enter main menu in search bar of the humburger
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys(Menu_Value).build().perform();
            //identify the main menu item, and click on that
            WebElement Menu = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='menu-item-text']/descendant::span[text()='" + Menu_Value + "']");
            HelpersMethod.ActClick(driver, Menu, 1000);
            //To select value from submenus
            if (HelpersMethod.IsExists("//div[@class='submenu-item-text']/descendant::span[contains(text(),'" + subMenuValue + "')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='submenu-item-text']/descendant::span[contains(text(),'" + subMenuValue + "')]");
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 1000);
                Thread.sleep(2000);
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'Ignition by Telus')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement popUpYes = WebEle1.findElement(By.xpath(".//button[text()='No']"));
                    HelpersMethod.ActClick(driver, popUpYes, 1000);
                }
                exists = true;
            }
            else
            {
                scenario.log("MENU ITEM NOT FOUND " + subMenuValue);
                exists = false;
            }
            WebElement Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            HelpersMethod.ActClick(driver, Humburger, 1000);
            new WebDriverWait(driver, Duration.ofMillis(200000)).until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(By.id("navigationMenuSearchBar"))));
            Assert.assertEquals(exists, true);
        } catch (Exception e) {
        }
    }

    public void handleSaveConfirmationPopup() {
        try {
            if (HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement popUpYes = WebEle.findElement(By.xpath(".//button[text()='OK']"));
                HelpersMethod.ActClick(driver, popUpYes, 1000);
            }
        } catch (Exception e) {
        }
    }

    public void handleError_Page()
    {
        try
        {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError"))
            {
                scenario.log("************** ERROR PAGE HAS BEEN FOUND *************");
                HelpersMethod.NavigateBack(driver);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                URL = HelpersMethod.gettingURL(driver);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
            {
               scenario.log("ADMIN PAGE HAS BEEN FOUND AFTER HANDLING ERROR PAGE");
            }
        } catch (Exception e) {}
    }

    public void refreshPage()
    {
        String status=null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
                if (wait.until(ExpectedConditions.alertIsPresent()) == null) {}
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
            }

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //Navigate to main page
                driver.navigate().refresh();
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


            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
}
