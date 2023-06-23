package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class AdminHomePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(xpath = "//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]")
    private WebElement PermissionBy;

    @FindBy(id="save-btn")
    private WebElement SaveButton;

    @FindBy(id="cancel-btn")
    private WebElement CancelButton;

    //Action
    public AdminHomePage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void ValidatingAdminHome() throws InterruptedException
    {
        exists=false;
        String title=null;
        WebElement WebEle;
        String status=null;

        status=HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Thread.sleep(20000);
        new WebDriverWait(driver,100).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]")));

        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        try
        {
            HelpersMethod.Implicitwait(driver,80);
            title=driver.getTitle();
            if(title.equals("Ignition - Admin"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidatingAdminHome1()
    {
        exists=false;
        String title=null;
        try
        {
            HelpersMethod.Implicitwait(driver,80);
            title=driver.getTitle();
            if(title.equals("Ignition - Admin"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on Permission by
    public void ClickPermissionBy()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        try
        {
            if(HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]",driver))
            {
                HelpersMethod.ActClick(driver, PermissionBy, 20);
                if (HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]", driver))
                {
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){e.printStackTrace();}
        Assert.assertEquals(exists,true);
    }

    //Method for Selecting company
    public void SelectCompany()
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String company=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'permissions-dropdown permission-background permissions-dropdown__flex')]",driver))
            {
                //Click on Company drop down
                WebEle= HelpersMethod.FindByElement(driver,"id","dropdownList3");
                HelpersMethod.ClickBut(driver,WebEle,20);
                HelpersMethod.Implicitwait(driver,80);

                //Create list of web elements in dropdown
                company=TestBase.testEnvironment.get_CompanyNo();
                List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
                for(WebElement Val: Values)
                {
                    act.moveToElement(Val).build().perform();
                    String Val_Text = Val.getText();
                    HelpersMethod.Implicitwait(driver,40);
                    if (Val_Text.equalsIgnoreCase(company) || Val_Text.contains(company))
                    {
                        act.click(Val).build().perform();
                        HelpersMethod.Implicitwait(driver,40);
                        break;
                    }
                }
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='dropdownList3']/span[1]");
                scenario.log("COMPANY SELECTED IS "+WebEle.getText());
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                }
            }
        }
        catch (Exception e){}
    }

    public void ClicOnHumburger()
    {
        WebElement Humburger;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver)) {
                Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='item-searchbar']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                HelpersMethod.ActClick(driver, Humburger, 20);
            }
        }
        catch (Exception e){}
    }

    public void CloseHumburger()
    {
        WebElement Humburger;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]",driver))
            {
                Humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                HelpersMethod.ActClick(driver, Humburger, 20);
            }
        }
        catch (Exception e){}
    }

    //Select menu value from the side search box
    public void EnterValueInSearchBox(String Menu_Value)
    {
        Actions act=new Actions(driver);
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='drawer-menu-application-container']");
            act.moveToElement(WebEle).build().perform();
            WebElement ClearSearch=HelpersMethod.FindByElement(driver,"xpath","//div[@class='searchbar-container']/descendant::i[@class='searchbar-container-close-icon']//*[local-name()='svg']");
            if(ClearSearch.isDisplayed())
            {
                HelpersMethod.ActClick(driver,ClearSearch,20);
            }
                WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
                act.moveToElement(Search_Input).sendKeys(Menu_Value).build().perform();
                WebElement Menu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'" + Menu_Value + "')]");
                HelpersMethod.ClickBut(driver, Menu, 10);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
        }
        catch(Exception e){}
    }

    //Selecting tab from horizontal menu bar
    public void Horizantal_MenuBar(String MenuItem)
    {
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            String Menu_Text=null;
            Actions act=new Actions(driver);
            List<WebElement> MenuBars=HelpersMethod.FindByElements(driver,"xpath","//div[@class='topMenu']/descendant::li/span");
            for(WebElement Menu:MenuBars)
            {
                HelpersMethod.Implicitwait(driver,20);
                act.moveToElement(Menu).build().perform();
                HelpersMethod.Implicitwait(driver,20);
                Menu_Text=Menu.getText();
                if(MenuItem.equals(Menu_Text))
                {
                    HelpersMethod.Implicitwait(driver,10);
                    act.click(Menu).build().perform();
                    HelpersMethod.Implicitwait(driver,40);
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
        }
        catch (Exception e){}
    }

    //Click on Save button
    public void Click_SaveButton()
    {
        exists=false;
        try
        {
            if(SaveButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,SaveButton,20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
