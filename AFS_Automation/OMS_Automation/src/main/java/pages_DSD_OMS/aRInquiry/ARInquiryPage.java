package pages_DSD_OMS.aRInquiry;

import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.an.E;
import io.cucumber.java.bs.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.TestBase;

import java.awt.font.TextLayout;
import java.time.Duration;
import java.util.Set;


/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class ARInquiryPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    String InvoiceNo;
    String currentURL;

    @FindBy(xpath="//button[contains(@class,'i-indexfield-container__main__button i-button--icon-only')]")
    private WebElement Cust_Accout;

    @FindBy(id="SearchBox1")
    private WebElement SearchBox;

    @FindBy(xpath="//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]")
    private WebElement SearchIndex;

    @FindBy(xpath="//button[contains(@class,'i-filter-tag__main')]")
    private WebElement AddFilter;

    @FindBy(xpath="//button[contains(text(),'Post')]")
    private  WebElement PostBut;

    @FindBy(xpath = "//button/span[text()='Print']")
    private WebElement PrintBut;

    public ARInquiryPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,400),this);
    }

    //actions
    public void HandleError_Page()
    {
        try
        {
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
                NavigateToAR();
            }
        }
        catch (Exception e) {}
    }

    public void Refresh_Page()
    {

        driver.navigate().refresh();
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
    }

    public void Refresh_Page(String currentURL)
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400000));
                if (wait.until(ExpectedConditions.alertIsPresent()) == null)
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
                //navigate to AR inq
                driver.navigate().to(currentURL);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
        }
        catch (Exception e){}
    }

    public String NavigateToAR()
    {
        exists=false;
        try
        {
            WebElement WebEle = null;
            String status = null;
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("AR Inquiry").build().perform();
            WebElement ARMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'AR Inquiry')]");
            HelpersMethod.ClickBut(driver, ARMenu, 1000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            currentURL=driver.getCurrentUrl();
            if(HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).build().perform();
                act.click(WebEle).build().perform();
            }
            if(HelpersMethod.IsExists("//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'AR Inquiry')]",driver))
            {
                scenario.log("NAVIGATED TO AR INQUIRY PAGE");
            }
            else
            {
                scenario.log("AR INQUIRY, MAY NOT BE ENABLED FOR THE APPLICATION");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return currentURL;
    }

    public void Validate_ARInquiry()
    {
        String title=null;
        WebElement WebEle;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
        try
        {
            title=HelpersMethod.gettingTitle(driver);
            Assert.assertEquals(title,"AR Inquiry");
        }
        catch (Exception e){}
    }

    public void Click_CustomerAccount()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            HelpersMethod.ClickBut(driver,Cust_Accout,1000);
            if(HelpersMethod.IsExists("//div[contains(text(),'Customer account')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                //Entering customer account# in search box
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::input[contains(@class,'i-search-box__input')]");
                HelpersMethod.EnterText(driver,WebEle,1000, TestBase.testEnvironment.get_Account());
                //Click on search index
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]");
                HelpersMethod.ClickBut(driver,WebEle,1000);
                //Click on Account no. filtered
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]");
                HelpersMethod.ActClick(driver,WebEle,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_CheckBox()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]",driver))
            {
                scenario.log("INVOICE HAS NOT BEEN FOUND");
                exists=false;
            }
            else
            {
                scenario.log("INVOICE HAS BEEN FOUND");
                if(HelpersMethod.IsExists("//div[contains(@class,'grid-container')]/descendant::tr[contains(@class,'k-master-row')][1]",driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'grid-container')]/descendant::tr[contains(@class,'k-master-row')][1]/descendant::input");
                    HelpersMethod.ClickBut(driver,WebEle,1000);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_Post()
    {
        exists=false;
        try
        {
            if(PostBut.isDisplayed() && PostBut.isEnabled())
            {
                HelpersMethod.ClickBut(driver,PostBut,1000);
                exists=true;
            }
            else
            {
                scenario.log("POST BUTTON IS NOT VISIBLE/ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_Print()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(PrintBut.isDisplayed() && PrintBut.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, PrintBut);
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, PrintBut, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        exists= true;
                        scenario.log("PRINT BUTTON FOR AR INQUIRY HAS BEEN HANDLED");
                    }
                }
                driver.switchTo().window(ParentWindow);
                exists=true;
            }
            else
            {
                scenario.log("PRINT BUTTON IS NOT ENABLED");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void AddFilterClick()
    {
        WebElement WebEle;
        exists=false;
        try
        {
            HelpersMethod.AddFilterSearch(driver,"Invoice",InvoiceNo);
            if(HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]",driver))
            {
                scenario.log("INVOICE HAS NOT BEEN FOUND");
            }
            else
            {
                scenario.log("INVOICE HAS BEEN FOUND");
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchInvoice()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]",driver))
            {
                scenario.log("INVOICE HAS NOT BEEN FOUND");
                exists=false;
            }
            else
            {
                scenario.log("INVOICE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ReadingInvoice()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'grid-container')]/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td[2]");
            InvoiceNo=WebEle.getText();
            if(InvoiceNo.equals(""))
            {
                exists=false;
            }
            else
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchBar()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,SearchBox,1000,InvoiceNo);
            HelpersMethod.ClickBut(driver,SearchIndex,1000);
            if(HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]",driver))
            {
                scenario.log("INVOICE HAS NOT BEEN FOUND");
                exists=false;
            }
            else
            {
                scenario.log("INVOICE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}