package pages_DSD_OMS.webOrdering;

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
import util.TestBase;

import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class AdminHomePage
{
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
        String title;
        String status;

        status = HelpersMethod.returnDocumentStatus(driver);
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
            title = driver.getTitle();
            if (title.contains("Admin"))
            {
                scenario.log("ADMIN PAGE HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void ValidatingAdminHome1()
    {
        exists = false;
        String title;
        try
        {
            title = driver.getTitle();
            if (title.contains("Admin"))
            {
                scenario.log("ADMIN PAGE HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    //Click on Permission by
    public void ClickPermissionBy()
    {
        exists = false;
        try
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

            Thread.sleep(2000);
            if (HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]", driver))
            {
                PermissionBy = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'i-header-toolbar-expandable-button')]");
                HelpersMethod.ActClick(driver, PermissionBy, 10000);
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

    public void ClickPermissionByAgain()
    {
        exists = false;
        try
        {
            //Thread.sleep(2000);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Wait<WebDriver> wait  = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait  = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            scenario.log("YOU WILL BE SELECTING COMPANY NOW");
            if (HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]", driver))
            {
                PermissionBy = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'i-header-toolbar-expandable-button')]");
                HelpersMethod.ActClick(driver, PermissionBy, 20000);
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
    public void ClickPermissionByAgain1()
    {
        exists = false;
        try
        {
            //Thread.sleep(2000);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Wait<WebDriver> wait  = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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

            if (HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-arrow-chevron-up i-header-toolbar-expandable-button__icon')]", driver))
            {
                HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'k-icon k-i-arrow-chevron-up i-header-toolbar-expandable-button__icon')]//*[local-name()='svg']").click();
//                new WebDriverWait(driver, Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(@class,'k-icon k-i-arrow-chevron-up i-header-toolbar-expandable-button__icon')]"))));
//                if (!HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver))
//                {
//                    scenario.log("PERMISSION DROP DOWN HAS BEEN CLICKED, AFTER SELECTING COMPANY");
//                    exists = true;
//                }
            }
            //Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Method for Selecting company
    public void SelectCompany() throws InterruptedException
    {
        exists = false;

        Actions act = new Actions(driver);
        String company;
        String status;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver))
            {
                //Click on Company drop down
                HelpersMethod.FindByElement(driver, "xpath", "//span[@id='dropdownList3-accessibility-id']/following-sibling::button//*[local-name()='svg']").click();
                //Create list of web elements in dropdown
                company = TestBase.testEnvironment.get_CompanyNo();
                //identify the company drop down, and values in list
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='dropdownList3-listbox-id']/li/span")));
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='dropdownList3-listbox-id']/li/span")));
                List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='dropdownList3-listbox-id']/li/span");
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
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void SelectDefaultCompany()
    {
        exists = false;
        WebElement WebEle;
        Actions act = new Actions(driver);
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver))
            {
                //Click on Company drop down
//                WebEle = HelpersMethod.FindByElement(driver, "id", "dropdownList3");
//                HelpersMethod.ClickBut(driver, WebEle, 10000);
                HelpersMethod.FindByElement(driver, "xpath", "//span[@id='dropdownList3-accessibility-id']/following-sibling::button//*[local-name()='svg']").click();
                //Create list of web elements in dropdown
                List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='dropdownList3-listbox-id']/li/span");
                for (WebElement Val : Values)
                {
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
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                if (HelpersMethod.IsExists("//span[contains(@class,'k-i-arrow-chevron-up')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'k-i-arrow-chevron-up')]");
                    HelpersMethod.JScriptClick(driver, WebEle, 10000);
                }
            }
        }
        catch (Exception e) {}
    }

    public void SelectDifferentCompany() throws InterruptedException
    {
        exists = false;
        WebElement WebEle;
        Actions act = new Actions(driver);
        String company;
        String company1;
        String status;
        WebElement Val;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver))
            {
                //Click on Company drop down
                HelpersMethod.FindByElement(driver, "xpath", "//span[@id='dropdownList3-accessibility-id']/following-sibling::button//*[local-name()='svg']").click();
                //Create list of web elements in dropdown
                company = TestBase.testEnvironment.get_CompanyNo();
                //identify the company drop down, and values in list
                List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='dropdownList3-listbox-id']/li/span");
                for(int i=0;i<=Values.size()-1;i++)
                {
                    Val=HelpersMethod.FindByElement(driver, "xpath", "//ul[@id='dropdownList3-listbox-id']/li["+(i+1)+"]/span");
                    act.moveToElement(Val).build().perform();
                    company1=Val.getText();

                    if(!company1.contains(company) && !company1.contains("Default"))
                    {
                        act.moveToElement(Val).build().perform();
                        act.click(Val).build().perform();
                        scenario.log("DIFFERENT COMPANY HAS BEEN SELECTED");
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ClickOnHamburger()
    {
        exists = false;
        WebElement WebEle;
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
            Thread.sleep(2000);
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

            //find whether side menu bar has expanded, if it has been expanded closde it
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 10000);
            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
            act1.moveToElement(side_menu).build().perform();
        }
        catch (Exception e) {}
    }

    public void clickOnHumbergerAgain()
    {
        exists = false;
        WebElement WebEle;
        try
        {
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
        }
        catch (Exception e) {}
    }

    public void CloseHamburger()
    {
        exists = false;
        WebElement Humburger;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
            {
                Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                HelpersMethod.ActClick(driver, Humburger, 20000);
            }
        }
        catch (Exception e) {}
    }

    //Select menu value from the side search box
    public void EnterValueInSearchBox(String Menu_Value)
    {
        Actions act = new Actions(driver);
        WebElement WebEle;
        String status;
        Wait<WebDriver> wait;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-application-container']");
            act.moveToElement(WebEle).build().perform();
            WebElement ClearSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='searchbar-container']/descendant::i[@class='searchbar-container-close-icon']//*[local-name()='svg']");
            if (ClearSearch.isDisplayed())
            {
                HelpersMethod.ActClick(driver, ClearSearch, 10000);
            }
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "id", "navigationMenuSearchBar");
            act.moveToElement(Search_Input).click().sendKeys(Menu_Value).build().perform();
            WebElement Menu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'" + Menu_Value + "')]");
            HelpersMethod.ActClick(driver, Menu, 10000);

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
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
                    .withTimeout(Duration.ofSeconds(150))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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

            if (ClearSearch.isDisplayed())
            {
                //code to clear search value
                ClearSearch=HelpersMethod.FindByElement(driver,"xpath","//div[@class='searchbar-container']/descendant::i[@class='searchbar-container-close-icon']//*[local-name()='svg']");
                HelpersMethod.ActClick(driver, ClearSearch, 10000);
                //code to close opened hamburger
                WebElement Hamburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                HelpersMethod.ActClick(driver, Hamburger, 10000);
                new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(By.id("navigationMenuSearchBar"))));
            }
        }
        catch (Exception e) {}
    }

    //Selecting tab from horizontal menu bar
    public void Horizantal_MenuBar(String MenuItem)
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            String Menu_Text;
            Actions act = new Actions(driver);
            List<WebElement> MenuBars = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='topMenu']/descendant::li/span");
            for (WebElement Menu : MenuBars)
            {
                act.moveToElement(Menu).build().perform();
                Menu_Text = Menu.getText();
                if (MenuItem.equals(Menu_Text))
                {
                    act.click(Menu).build().perform();
                    break;
                }
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e) {}
    }

    //Click on Save button
    public void Click_SaveButton()
    {
        exists = false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (SaveButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, SaveButton, 10000);
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

                if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement savePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton=savePopup.findElement(By.xpath(".//button/span[text()='OK']"));
                    HelpersMethod.ActClick(driver,okButton,10000);
                    //exists = true;
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
                }
            }
        }
        catch (Exception e) {}
    }

    public void EnterValueInSearchBox1(String Menu_Value, String subMenuValue)
    {
        exists = false;
        String status="";
        Actions act = new Actions(driver);
        WebElement WebEle;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-application-container']");
            act.moveToElement(WebEle).build().perform();
            WebElement ClearSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='searchbar-container']/descendant::i[@class='searchbar-container-close-icon']//*[local-name()='svg']");
            if (ClearSearch.isDisplayed())
            {
                HelpersMethod.ActClick(driver, ClearSearch, 10000);
            }
            //Enter main menu in search bar of the humburger
            WebElement Search_Input=HelpersMethod.FindByElement(driver,"id","navigationMenuSearchBar");
            act.moveToElement(Search_Input).click().sendKeys(Menu_Value).build().perform();
            //identify the main menu item, and click on that
            WebElement Menu = HelpersMethod.FindByElement(driver, "xpath", "//span[@class='menu-item-text']/descendant::span[text()='" + Menu_Value + "']");
            HelpersMethod.ActClick(driver, Menu, 10000);
            //To select value from submenus
            if (HelpersMethod.IsExists("//div[@class='submenu-item-text']/descendant::span[contains(text(),'" + subMenuValue + "')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='submenu-item-text']/descendant::span[contains(text(),'" + subMenuValue + "')]");
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 10000);
                Thread.sleep(2000);

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'Ignition by Telus')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "div[contains(@class,'k-window k-dialog')]");
                    WebElement popUpYes = WebEle1.findElement(By.xpath(".//button/span[text()='No']"));
                    HelpersMethod.ActClick(driver, popUpYes, 10000);
                }
                exists = true;
            }
            else
            {
                scenario.log("MENU ITEM NOT FOUND " + subMenuValue);
                exists = false;
            }

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

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(150))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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

            //WebElement Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            //HelpersMethod.ActClick(driver, Humburger, 1000);
            new WebDriverWait(driver, Duration.ofMillis(200000)).until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(By.id("navigationMenuSearchBar"))));
            Assert.assertTrue(exists);
        }
        catch (Exception e) {}
    }

    public void handleSaveConfirmationPopup()
    {
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "div[contains(@class,'k-window k-dialog')]");
                WebElement popUpYes = WebEle.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, popUpYes, 1000);
            }
        }
        catch (Exception e) {}
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
                        .pollingEvery(Duration.ofSeconds(2))
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
        String status;
        Wait<WebDriver> wait;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]|//div[@class='modal-content']", driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                wait = new WebDriverWait(driver, Duration.ofMillis(10000));
                if (wait.until(ExpectedConditions.alertIsPresent()) == null) {}
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(150))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }

            wait = new FluentWait<WebDriver>(driver)
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
                    .withTimeout(Duration.ofSeconds(150))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(150))
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
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));


            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(2000);
        } catch (Exception e) {}
    }

    public void removeUnwantedDialogbox()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
                if(wait.until(ExpectedConditions.alertIsPresent())==null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }

                Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void validatePermissionbarExpanded()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown')]",driver))
            {
                scenario.log("PERMISSION BAR HAS BEEN EXPANDED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateHamburgerExpanded()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'drawer-menu-items-container-expanded')]",driver))
            {
                scenario.log("HUMBURGER HAS BEEN EXPANDED");
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validatePermissionCollapse()
    {
        exists=false;
        try
        {
          Thread.sleep(200);
          if(!HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown')]",driver))
            {
               scenario.log("PERMISSION BAR HAS BEEN COLLAPSED");
               exists=true;
            }
            Assert.assertTrue(exists);
       }
       catch (Exception e){}
    }

    public void validateHamburgerIcon()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='item-searchbar']//*[local-name()='svg']",driver))
            {
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validateSearchBar()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExistsById("navigationMenuSearchBar",driver))
            {
                scenario.log("SEARCHBAR HAS BEEN FOUND IN HAMBURGER");
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validateSearchSucess(String menuSearch)
    {
        exists=false;
        try
        {
            String menuItem=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'drawer-menu-items')]/descendant::span[@style='font-weight: bold;']").getText();
            if(menuItem.equalsIgnoreCase(menuSearch))
            {
                scenario.log("MENU ITEM SEARCH IS SUCCESSFUL");
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void adminSettingDisable(String setting,String identifier,String varForIdentifier)
    {
        exists=false;
        try
        {
            WebElement adminSetting=HelpersMethod.FindByElement(driver,identifier,varForIdentifier);
            if(adminSetting.isDisplayed())
            {
                scenario.log("ADMIN SETTING "+setting+" HAS BEEN FOUND");
                String status = HelpersMethod.returnStatus(driver, adminSetting, 10000);
                if (status.equals("true"))
                {
                    HelpersMethod.JScriptClick(driver, adminSetting, 10000);
                }
                status = HelpersMethod.returnStatus(driver, adminSetting, 10000);
                if (status.equals("false"))
                {
                    scenario.log(setting+" IS DISABLED");
                    exists=true;
                }
                else
                {
                    scenario.log("FAILED TO DISABLE "+setting);
                }
            }
            else
            {
                scenario.log("<span style='color:red'> ADMIN STTING HAS NOT BEEN FOUND </span>");
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void adminSettingEnable(String setting,String identifier,String varForIdentifier)
    {
        exists=false;
        try
        {
            WebElement adminSetting=HelpersMethod.FindByElement(driver,identifier,varForIdentifier);
            if(adminSetting.isDisplayed())
            {
                scenario.log("ADMIN SETTING "+setting+" HAS BEEN FOUND");
                String status = HelpersMethod.returnStatus(driver, adminSetting, 10000);
                if (status.equals("false"))
                {
                    HelpersMethod.JScriptClick(driver, adminSetting, 10000);
                }
                status = HelpersMethod.returnStatus(driver, adminSetting, 10000);
                if (status.equals("true"))
                {
                    exists=true;
                }
            }
            else
            {
                scenario.log("<span style='color:red'> ADMIN SETTING HAS NOT BEEN FOUND </span>");
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }
}
