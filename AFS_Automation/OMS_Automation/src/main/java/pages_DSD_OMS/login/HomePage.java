package pages_DSD_OMS.login;

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

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Project DSD_ERP
 * @Author Divya.Ramadas@afsi.com
 */
public class HomePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(xpath = "//div[@class='user-info-initial-container']")
    private WebElement IconContainer;

    @FindBy(xpath = "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]")
    private WebElement UserIcon;

    //Initializing the Page Objects:
    public HomePage(WebDriver driver, Scenario scenario)
    {
        this.scenario=scenario;
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void VerifyHomePage()
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

            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='user-info-container']"))));
            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-info-container']"))));

            String HomeTitle = driver.getTitle();
            if (HomeTitle.contains("Admin")||HomeTitle.contains("Order Entry"))
            {
                scenario.log("ADMIN PAGE FOUND");
                exists = true;
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void verifyUserinfoContainer()
    {
        try
        {
            exists = false;
            WebElement WebEle;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'user-info-container')]")));
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'user-info-container')]")));
            if (HelpersMethod.IsExists("//div[contains(@class,'user-info-container')]", driver))
            {
                scenario.log("USER ICON FOUND");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void navigateToClientSide()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            Thread.sleep(2000);
            //create webdriverwait instance
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("app")));
            scenario.log("IN ADMIN PAGE");
            WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer')]");
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer')]")));
            Actions act1 = new Actions(driver);
            //Move mouse on menu icon
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));

            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
            act1.moveToElement(WebEle).click().build().perform();

            //find whether side menu bar has expanded
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 800);
            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
            act1.moveToElement(side_menu).build().perform();

            //Click on arrow symbol
            WebElement arrow = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'settings-back-container')] //*[name()='svg']//*[local-name()='path' and contains(@d,'M5,8L1,12L5,16L5,13L23,13L23,11L5,11L5,8,z')]");
            if (arrow.isDisplayed())
            {
                WebElement ele4 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'settings-back-container')] //*[name()='svg']//*[local-name()='path' and contains(@d,'M5,8L1,12L5,16L5,13L23,13L23,11L5,11L5,8,z')]");
                act1.moveToElement(ele4).build().perform();
                act1.click(ele4).build().perform();
            }
            //Identify side menu bar to identify the webelements
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]")));
            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
            exists = true;

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void Click_On_UserIcon() throws InterruptedException
    {
        try
        {
            exists = false;
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
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]", 2400);
            WebElement UserIcon = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]");
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]"))));
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
            //new WebDriverWait(driver,10000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/div[@class='popup-content']/descendant::div[contains(@class,'user-info-line user-info-line-signout')]")));
            WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/div[@class='popup-content']");
            WebElement signOut = dropDown.findElement(By.xpath(".//div[contains(@class,'user-info-line user-info-line-signout')]"));
            HelpersMethod.ActClick(driver, signOut, 1000);

            //If any pending order popup appears to handle that
            if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement popUp=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement discardAll=popUp.findElement(By.xpath(".//button[contains(text(),'Discard all')]"));
                HelpersMethod.ActClick(driver,discardAll,1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                //Click again on user icon for signout
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]", 2400);
                WebElement UserIcon = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]");
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]"))));
                HelpersMethod.JScriptClick(driver, UserIcon, 8000);
                new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative popup-with-arrow standard-view user-info k-animation-container-shown')]"))));
                //Click on signout, in drop down
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/div[@class='popup-content']/descendant::div[contains(@class,'user-info-line user-info-line-signout')]")));
                dropDown = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/div[@class='popup-content']");
                signOut = dropDown.findElement(By.xpath(".//div[contains(@class,'user-info-line user-info-line-signout')]"));
                HelpersMethod.ActClick(driver, signOut, 1000);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Thread.sleep(4000);
            HelpersMethod.waitTillTitleContains(driver, "Login", 40000);
            String title = driver.getTitle();
            if (title.contains("Login"))
            {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void Change_Language() throws InterruptedException
    {
        String Lang1=null;
        String Lang2=null;
        WebElement WebEle=null;
        try
        {

            Actions act1 = new Actions(driver);
            WebElement LangInMenu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            Lang1 = LangInMenu.getAttribute("aria-label");
            scenario.log("LANGAUGE BEFORE CHANGEING LANGUAGE " + Lang1);

            act1.moveToElement(LangInMenu).build().perform();
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-popup k-menu-popup k-child-animation-container')]", 100);
            //Code to check for drop down containing different language option
            if (HelpersMethod.IsExists("//div[contains(@class,'k-popup k-menu-popup k-child-animation-container')]", driver)) ;
            {
                //creating list of langauges
                List<WebElement> Langauges = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::li[contains(@class,'language-popup-item')]/descendant::span[contains(@class,'k-menu-link-text')]");
                int i = 0;
                for (WebElement Language : Langauges)
                {
                    i++;
                    act1.moveToElement(Language).build().perform();
                    if (i == Langauges.size() - 1)
                    {
                        act1.click(Language).build().perform();
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                        }
                        break;
                    }
                }
            }
            HelpersMethod.ActClick(driver,UserIcon,1000);

            LangInMenu=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            HelpersMethod.waitTillElementDisplayed(driver,LangInMenu,10000);
            Lang2=LangInMenu.getAttribute("aria-label");
            scenario.log("LANGUAGE FOUND IS "+Lang2);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='topMenu']");
            HelpersMethod.ClickBut(driver,WebEle,1000);
        }
        catch (Exception e) {}
    }

    public void Change_Language1(String s)
    {

        String Lang1=null;
        String Lang2=null;
        WebElement WebEle=null;
        try
        {

            Actions act1 = new Actions(driver);
            WebElement LangInMenu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            HelpersMethod.waitTillElementDisplayed(driver, LangInMenu, 10000);
            Lang1 = LangInMenu.getAttribute("aria-label");
            scenario.log("LANGAUGE BEFORE CHANGING LANGUAGE " + Lang1);

            LangInMenu=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            act1.moveToElement(LangInMenu).build().perform();
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-menu-popup k-child-animation-container')]"))));
            //Code to check for drop down containing different language option
            if (HelpersMethod.IsExists("//div[contains(@class,'k-popup k-menu-popup k-child-animation-container')]", driver)) ;
            {
                //creating list of langauges
                List<WebElement> Langauges = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::li[contains(@class,'language-popup-item')]/descendant::span[contains(@class,'k-menu-link-text')]");
                for (WebElement Language : Langauges)
                {
                    act1.moveToElement(Language).build().perform();
                    String langText=Language.getText();
                    if (langText.contains(s))
                    {
                        act1.click(Language).build().perform();
                        break;
                    }
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            UserIcon=HelpersMethod.FindByElement(driver,"xpath","//div[@class='user-info-container']");
            HelpersMethod.ActClick(driver,UserIcon,1000);

            LangInMenu=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            HelpersMethod.waitTillElementDisplayed(driver,LangInMenu,10000);
            Lang2=LangInMenu.getAttribute("aria-label");
            scenario.log("LANGUAGE FOUND IS "+Lang2);
            if(Lang2.contains(s))
            {
                exists=true;
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='topMenu']");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void AdminPageUsingAdminCredentials()
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='user-info-container']"))));
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-info-container']"))));

            HelpersMethod.waitTillTitleContains(driver, "Admin", 80000);
            String HomeTitle = driver.getTitle();
            if (HomeTitle.contains("Admin"))
            {
                scenario.log("USER IS ON ADMIN PAGE, AFTER LOGINING IN WITH ADMIN CREDENTIALS");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void refreshPageBeforeLogout()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(10000));
                if(wait.until(ExpectedConditions.alertIsPresent())==null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
            }
        }
        catch (Exception e){}
    }
}