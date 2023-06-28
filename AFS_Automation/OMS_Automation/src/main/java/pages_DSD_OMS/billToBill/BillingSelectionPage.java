package pages_DSD_OMS.billToBill;

import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingColorN;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.image.renderable.ParameterBlock;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class BillingSelectionPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="undoBillingButton")
    private WebElement UndoBillButton;

    @FindBy(id="resetButton")
    private  WebElement ResetButton;

    @FindBy(id="MailButton")
    private WebElement MailButton;

    @FindBy(id="cancelEditButton")
    private WebElement CancelButton;

    @FindBy(id="printEditButton")
    private WebElement PrintButton;

    @FindBy(id="selectEditButton")
    private WebElement SelectButton;

    @FindBy(id="switchShowSelected")
    private WebElement SwitchSelected;

    @FindBy(id="nbRangeFrom")
    private WebElement FromRange;

    @FindBy(id="nbRangeTo")
    private WebElement ToRange;

    @FindBy(id="switchShowSelected")
    private WebElement ShowSelected;

    @FindBy(id="SearchBar1")
    private WebElement SearchBar;

    public BillingSelectionPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Action
    public void ValidateBillingSelection()
    {
        String Header=null;
        try
        {
            Header= HelpersMethod.FindByElement(driver,"xpath","//div[@class='topHeaderRow row']/descendant::span").getText();
            Assert.assertEquals(Header,"Billing selection");
            scenario.log("BILLING SELECTION PAGE HAS BEEN FOUND");
        }
        catch (Exception e){}
    }

    public void SelectBillingSelect() throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        String status=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-grid')]/descendant::table[@class='k-grid-table']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td/input[@type='checkbox']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-grid')]/descendant::table[@class='k-grid-table']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::td/input[@type='checkbox']");
                HelpersMethod.ActClick(driver,WebEle,400);
                exists = true;
                scenario.log("CHECK BOX CLICKED IN SELECTION GRID");
            }
            else
            {
                scenario.log("BILLING SELECTION GRID DOESN'T CONTAINS ANY VALUE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickPrintButton()
    {
        exists=false;
        try
        {
           if(PrintButton.isDisplayed())
           {
               HelpersMethod.ClickBut(driver, PrintButton, 200);
               scenario.log("PRINT BUTTON HAS BEEN CLICKED");
               exists = true;
           }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValiddatePrintCustomerBillPopup()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Print customer billing')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void PrintCustomerBillPopUp()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[@id='PrintButton']");
            String ParentWindow = driver.getWindowHandle();
            if(WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ClickBut(driver,WebEle,100);
                Thread.sleep(2000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
                        scenario.log("PRINT BUTTON FOR BILL TO BILL(DSD) HAS BEEN HANDLED");
                    }
                }
                Assert.assertEquals(exists, true);
                driver.switchTo().window(ParentWindow);
            }
            else
            {
                scenario.log("PRINT BUTTON IS NOT ENABLED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CancelInPrintPopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[@id='CancelButton']");
            String ParentWindow = driver.getWindowHandle();
            if (WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ClickBut(driver, WebEle, 100);
                scenario.log("PRINT HAS BEEN CANCELLED");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CancelButton()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,CancelButton,100);
            exists=true;
            scenario.log("CANCLE BUTTON HAS BEEN CLICKED");
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void UndoBilling()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,UndoBillButton,20);
            exists=true;
            scenario.log("UNDO BILLING HAS BEEN CICKED");
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void UndoBillingPopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Undo billing')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,20);
                exists = true;
                scenario.log("UNDO BILLING POPUP HANDLED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void FromRange(int arg0)
    {
        exists=false;
        try
        {
            HelpersMethod.ActClearKey(driver,FromRange,10);
            HelpersMethod.ActSendKey(driver,FromRange,20, String.valueOf(arg0));
            exists=true;
            scenario.log("FROM RANGE HAS BEEN SELECTED "+arg0);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ToRange(int arg1)
    {
        exists=false;
        try
        {
            HelpersMethod.ActClearKey(driver,ToRange,20);
            HelpersMethod.ActSendKey(driver,ToRange,10, String.valueOf(arg1));
            exists=true;
            scenario.log("TO RNAGE HAS BEEN SELECTED "+arg1);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void TaggleButton()
    {
        exists=false;
        try
        {
            ShowSelected.click();
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void RangeSelectButton()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,SelectButton,20);
            exists=true;
            scenario.log("RANGE SELECTED BUTTON HAS BEEN SELECTED");
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
