package pages_DSD_OMS.login;

import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import io.cucumber.java.ro.Si;
import io.cucumber.java8.Th;
import lombok.experimental.Helper;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.userManagement.UserManagementPage;

import java.awt.*;
import java.awt.event.KeyEvent;
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
        try {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, 20000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
            HelpersMethod.WaitElementPresent(driver, "xpath", "//span[contains(@class,'spnmoduleNameHeader withoutBreadcrumbs')]", 20000);
            new WebDriverWait(driver, 20000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'spnmoduleNameHeader withoutBreadcrumbs')]")));
            HelpersMethod.waitTillTitleContains(driver, "Ignition - Admin", 2000);
            String HomeTitle = driver.getTitle();
            if (HomeTitle.contains("Ignition - Admin"))
            {
                exists = true;
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
            new WebDriverWait(driver,2000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'user-info-container')]")));
            new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'user-info-container')]")));
            if (HelpersMethod.IsExists("//div[contains(@class,'user-info-container')]", driver))
            {
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
            //create webdriverwait instance
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //xpath for side_menu="//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer')]"
            WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/*[1]");
            Actions act1 = new Actions(driver);
            //Move mouse on menu icon
           /* if (HelpersMethod.IsExists("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
            {*/
               //submenu bar before click original pattai -reduced -hamburger
                new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));

                //submenu bar after click
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act1.moveToElement(WebEle).build().perform();
                act1.click(WebEle).build().perform();
            //}
           /* else
            {
                //move mouse to Ignition icon container
                WebElement ele2 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-closed MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
                act1.moveToElement(ele2).build().perform();
            }*/

            //find whether side menu bar has expanded
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 800);
            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/*[1]");
            act1.moveToElement(side_menu).build().perform();

            //Click on arrow symbol
            //previous xpath = //div[contains(@class,'settings-back-container')] //*[name()='svg']//*[local-name()='path' and contains(@d,'M5,8L1,12L5,16L5,13L23,13L23,11L5,11L5,8,z')]")
            WebElement arrow = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Settings']/../../div[1]");
            if (arrow.isDisplayed())
            {
                WebElement ele4 = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Settings']/../../div[1]");
                act1.moveToElement(ele4).build().perform();
                act1.click(ele4).build().perform();
            }
            //Karthik     Identify side menu bar to identify the webelements -27-Mar 2023 until Assert
            /*new WebDriverWait(driver,200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]")));
            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
            exists = true;

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                //-reduced
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists, true); Karthik      */
        }
        catch (Exception e){}
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
               new WebDriverWait(driver,8000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]", 2400);
            WebElement UserIcon = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]/following-sibling::div[contains(@class,'user-info-setting-shape')]");
            new WebDriverWait(driver, 6000).until(ExpectedConditions.visibilityOf(UserIcon));
            HelpersMethod.JScriptClick(driver, UserIcon, 2000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,8000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative popup-with-arrow standard-view user-info k-animation-container-shown')]", 600);
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }

            HelpersMethod.waitTillTitleContains(driver, "Ignition - Login", 60);
            String title = driver.getTitle();
            if (title.equals("Ignition - Login"))
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
           // HelpersMethod.Implicitwait(driver,10);
            Actions act1 = new Actions(driver);
            WebElement LangInMenu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            HelpersMethod.waitTillElementDisplayed(driver, LangInMenu, 100);
            Lang1 = LangInMenu.getAttribute("aria-label");
            scenario.log("LANGAUGE BEFORE CHANGEING LANGUAGE " + Lang1);

            HelpersMethod.waitTillElementDisplayed(driver, LangInMenu, 100);
            act1.moveToElement(LangInMenu).build().perform();
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-menu-popup k-popup')]/descendant::li", 2);
            //Code to check for drop down containing different language option
            if (HelpersMethod.IsExists("//div[contains(@class,'k-menu-popup k-popup')]", driver)) ;
            {
                //creating list of langauges
                List<WebElement> Langauges = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-menu-popup k-popup')]/descendant::li");
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
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
                        }
                        break;
                    }
                }
            }
            HelpersMethod.ActClick(driver,UserIcon,100);

            LangInMenu=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            HelpersMethod.waitTillElementDisplayed(driver,LangInMenu,100);
            Lang2=LangInMenu.getAttribute("aria-label");
            scenario.log("LANGUAGE FOUND IS "+Lang2);
        }
        catch (Exception e) {}
    }

    public void Change_Language1(String s)
    {

        String Lang1=null;
        String Lang2=null;
        WebElement WebEle=null;
        Actions act2=new Actions(driver);
        try
        {
            //HelpersMethod.Implicitwait(driver,10);
            Actions act1 = new Actions(driver);
            WebElement LangInMenu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            HelpersMethod.waitTillElementDisplayed(driver, LangInMenu, 40);
            Lang1 = LangInMenu.getAttribute("aria-label");
            scenario.log("LANGAUGE BEFORE CHANGEING LANGUAGE " + Lang1);

            UserIcon=HelpersMethod.FindByElement(driver,"xpath","//div[@class='user-info-container']");
            HelpersMethod.ActClick(driver,UserIcon,40);
            LangInMenu=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            HelpersMethod.waitTillElementDisplayed(driver, LangInMenu, 40);
            act1.moveToElement(LangInMenu).build().perform();
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-menu-popup k-popup')]", 8);
            //Code to check for drop down containing different language option
            if (HelpersMethod.IsExists("//div[contains(@class,'k-menu-popup k-popup')]", driver)) ;
            {
                //creating list of langauges
                List<WebElement> Langauges = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-menu-popup k-popup')]/descendant::li");
                for (WebElement Language : Langauges)
                {
                    act1.moveToElement(Language).build().perform();
                    if (Language.getText().contains(s))
                    {
                        act1.click(Language).build().perform();
                        break;
                    }
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
            }
            //HelpersMethod.Implicitwait(driver,20);
            UserIcon=HelpersMethod.FindByElement(driver,"xpath","//div[@class='user-info-container']");
            HelpersMethod.ActClick(driver,UserIcon,80);

            LangInMenu=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'user-info-line bgonhover')]/descendant::li");
            HelpersMethod.waitTillElementDisplayed(driver,LangInMenu,80);
            Lang2=LangInMenu.getAttribute("aria-label");
            scenario.log("LANGUAGE FOUND IS "+Lang2);
            if(Lang2.contains(s))
            {
                exists=true;
            }
            Thread.sleep(1000);
            //UserIcon=HelpersMethod.FindByElement(driver,"xpath","//div[@class='user-info-container']");
            //act2.moveToElement(UserIcon).build().perform();
            //act2.click(UserIcon).build().perform();
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void AdminPageUsingAdminCredentials()
    {
        WebElement WebEle=null;
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
        try
        {
            if(HelpersMethod.IsExistsById("CPGeneralGlobalForm",driver))
            {
                scenario.log("USER IS ON ADMIN PAGE, AFTER LOGINING IN WITH ADMIN CREDENTIALS");
            }
        }
        catch (Exception e){}
    }

//    public void navigateToClientSide() {
//        exists = false;
//        WebElement WebEle;
//        try {
//            //create webdriverwait instance
//            String status = HelpersMethod.returnDocumentStatus(driver);
//            if (status.equals("loading")) {
//                HelpersMethod.waitTillLoadingPage(driver);
//            }
//            //xpath for side_menu="//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer')]"
//            WebElement side_menu = HelpersMethod.FindByElement(driver, "xpath", "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/*[1]");
//            Actions act1 = new Actions(driver);
//            //Move mouse on menu icon
//           /* if (HelpersMethod.IsExists("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
//            {*/
//            new WebDriverWait(driver, 400).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));
//            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
//            act1.moveToElement(WebEle).build().perform();
//            act1.click(WebEle).build().perform();
//            //}
//           /* else
//            {
//                //move mouse to Ignition icon container
//                WebElement ele2 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-closed MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
//                act1.moveToElement(ele2).build().perform();
//            }*/
//
//            //find whether side menu bar has expanded
//            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]", 800);
//            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/*[1]");
//            act1.moveToElement(side_menu).build().perform();
//
//            //Click on arrow symbol
//            //previous xpath = //div[contains(@class,'settings-back-container')] //*[name()='svg']//*[local-name()='path' and contains(@d,'M5,8L1,12L5,16L5,13L23,13L23,11L5,11L5,8,z')]")
//            WebElement arrow = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Settings']/../../div[1]");
//            if (arrow.isDisplayed()) {
//                WebElement ele4 = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Settings']/../../div[1]");
//                act1.moveToElement(ele4).build().perform();
//                act1.click(ele4).build().perform();
//            }
//            //Identify side menu bar to identify the webelements
//            new WebDriverWait(driver, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]")));
//            side_menu = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'MuiPaper-root MuiDrawer-paper drawer-opened MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft MuiPaper-elevation0')]");
//            exists = true;
//
//            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
//                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
//                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
//            }
//            Assert.assertEquals(exists, true);
//        } catch (Exception e) {
//        }
//    }

}
