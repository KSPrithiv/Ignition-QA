package pages_DSD_OMS.quote;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class QuoteSummaryPage
{
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="OrdersButton")
    private WebElement BackToOrderList;

    @FindBy(id="ConverToOrderGuideBtn")
    private WebElement ConvertOG;

    @FindBy(id="CopyQuoteBtn")
    private WebElement CopyQuote;

    @FindBy(id="CancelSummaryButton")
    private WebElement CancelButton;

    @FindBy(id="createOrderButton")
    private WebElement ConvertOrder;

    @FindBy(id="EditButton")
    private WebElement EditButton;

    public QuoteSummaryPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void ValidateQuoteSummary()
    {
        HelpersMethod.Implicitwait(driver,10);
        exists=false;
        try
        {
            HelpersMethod.waitTillTitleContains(driver,"Ignition - Order Entry",20);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnBackToOrder()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.Implicitwait(driver,40);

        try
        {
            if(BackToOrderList.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,BackToOrderList,10);
                exists=true;
            }
            Assert.assertEquals(exists,true);
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10);
        }
        catch (Exception e){}
    }

    public void ClickOnConvertOG()
    {
        exists=true;
        try
        {
         if(ConvertOG.isDisplayed())
         {
             HelpersMethod.ClickBut(driver,ConvertOG,8);
             exists=true;
             WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
             HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
         }
         Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnConvertOrder()
    {
        exists=true;
        WebElement WebEle=null;
        try
        {
            if(ConvertOrder.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,ConvertOrder,8);
                exists=true;
            }
            Assert.assertEquals(exists,true);
            exists=false;
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Convert quote to order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            if(WebEle.isDisplayed())
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,4);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnCancel()
    {
        exists=true;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            if(ConvertOrder.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,CancelButton,10);
                exists=true;
            }
            Assert.assertEquals(exists,true);
            exists=false;
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Cancel quote')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            if(WebEle.isDisplayed())
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,10);
                exists=true;
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnCopy()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            if(CopyQuote.isDisplayed() && CopyQuote.isEnabled())
            {
                HelpersMethod.ClickBut(driver,CopyQuote,10);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnEdit()
    {
        exists=false;
        try
        {
            if(EditButton.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,EditButton,10);
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void NavgiateBackToOE()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.Implicitwait(driver,40);
            HelpersMethod.navigate_Horizantal_Tab(driver, "Orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        }
        catch (Exception e){}
    }
}
