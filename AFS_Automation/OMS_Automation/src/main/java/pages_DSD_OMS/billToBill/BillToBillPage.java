package pages_DSD_OMS.billToBill;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;

import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class BillToBillPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String currentURL=null;

    @FindBy(id="rbBillingPeriodWeekly")
    private  WebElement WeeklyRadio;

    @FindBy(id="rbBillingPeriodMonthly")
    private  WebElement MonthlyRadio;

    @FindBy(id="cancelEditButton")
    private  WebElement LoadButton;

    @FindBy(id="SearchBar1")
    private WebElement SearchBar;

    @FindBy(id="ddlYear")
    private  WebElement YearDropdown;

    @FindBy(id="ddlMonth")
    private WebElement MonthDropdown;

    @FindBy(id="ddlDay")
    private WebElement DateDropdown;

    public BillToBillPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void HandleError_Page()
    {
        try {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError"))
            {
                HelpersMethod.NavigateBack(driver);
                //URL = HelpersMethod.gettingURL(driver);
                driver.navigate().to(currentURL);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
            {
                HomePage homepage = new HomePage(driver, scenario);
                homepage.navigateToClientSide();
                NavigateToBillToBill();
            }
        }
        catch (Exception e) {}
    }

    public void Refresh_Page()
    {
        driver.navigate().to(currentURL);
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
    }

    public void ValidateBillToBill()
    {
        exists=false;
        String Header=null;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
            }

            Header=HelpersMethod.FindByElement(driver,"xpath","//div[@class='topHeaderRow row']/descendant::span").getText();
            Assert.assertEquals(Header,"Bill To Billing (DSD)");
        }
        catch (Exception e){}
    }

    public String NavigateToBillToBill()
    {
        exists = false;
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
            act.moveToElement(Search_Input).click().sendKeys("Bill To Billing").build().perform();
            WebElement BillMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Bill To Billing')]");
            HelpersMethod.ClickBut(driver, BillMenu, 100);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).build().perform();
                act.click(WebEle).build().perform();
            }
            if(HelpersMethod.IsExists("//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Bill To Billing')]",driver))
            {
                scenario.log("NAVIGATED TO BILL TO BILL(DSD) PAGE");
            }
            else
            {
                scenario.log("BILL TO BILLING (DSD) MAY NOT BE ENABLED FOR THE APPLICATION");
            }
            currentURL=driver.getCurrentUrl();
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
        return currentURL;
    }

    public void WeeklyRadioButton()
    {
        exists=false;
        try
        {
            if(!WeeklyRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver,WeeklyRadio,10);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void MonthlyRadioButton()
    {
        exists=false;
        try
        {
            if (!MonthlyRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver,MonthlyRadio,10);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnYearDropDown()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            HelpersMethod.Implicitwait(driver,20);
            HelpersMethod.ClickBut(driver,YearDropdown,10);
            HelpersMethod.Implicitwait(driver,4);
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container ')]/descendant::ul/li");
            WebElement YearFromDropDown=Values.get(2);
            act.moveToElement(YearFromDropDown).build().perform();
            HelpersMethod.Implicitwait(driver,10);
            //String Val_Text =YearFromDropDown.getText();
            //HelpersMethod.Implicitwait(driver,10);
            //scenario.log("YEAR SELECTED FROM DROP DOWN "+Val_Text);
            //HelpersMethod.Implicitwait(driver,5);
            act.click(YearFromDropDown).build().perform();
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnMonthlyDropDown()
    {
        exists=false;
        Actions act=new Actions(driver);
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            HelpersMethod.ClickBut(driver,MonthDropdown,10);
            HelpersMethod.Implicitwait(driver,40);
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container ')]/descendant::ul/li");
            WebElement MonthFromDropDown=Values.get(2);
            act.moveToElement(MonthFromDropDown).build().perform();
            HelpersMethod.Implicitwait(driver,40);
            //String Val_Text =MonthFromDropDown.getText();
            //HelpersMethod.Implicitwait(driver,10);
            //scenario.log("MONTH SELECTED FROM DROP DOWN "+Val_Text);
            //HelpersMethod.Implicitwait(driver,5);
            act.click(MonthFromDropDown).build().perform();
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnDateDropDown()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            HelpersMethod.Implicitwait(driver,100);
            HelpersMethod.ClickBut(driver,DateDropdown,60);
            HelpersMethod.Implicitwait(driver,100);
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container ')]/descendant::ul/li");
            WebElement DateFromDropDown=Values.get(2);
            act.moveToElement(DateFromDropDown).build().perform();
            HelpersMethod.Implicitwait(driver,100);
            //String Val_Text =DateFromDropDown.getText();
            //HelpersMethod.Implicitwait(driver,10);
            //scenario.log("DATE SELECTED FROM DROP DOWN "+Val_Text);
            //HelpersMethod.Implicitwait(driver,5);
            act.click(DateFromDropDown).build().perform();
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickBillGroup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//table[@class='k-grid-table']/descendant::tr[1]/descendant::td/input");
            if(WebEle.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,WebEle,10);
                exists=true;
            }
            else
            {
                scenario.log("BILLING GROUP IS NOT DISPLAYED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickLoadButton()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(LoadButton.isDisplayed() && LoadButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, LoadButton, 10);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
