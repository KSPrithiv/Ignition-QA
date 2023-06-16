package pages_DSD_OMS.aRInquiry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import util.RandomValues;

import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class PostPaymentPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="newPayment")
    private WebElement AddPayment;

    @FindBy(xpath="//button[text()='Post']")
    private WebElement PostBut;

    @FindBy(id="cancelBtn")
    private WebElement CancelBut;

    public PostPaymentPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,40),this);
    }

    //actions
    public void ValidatePostPayment()
    {
        exists=false;
        WebElement WebEle=null;
        String PageTitle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@class='spnmoduleNameHeader']");
            PageTitle=WebEle.getText();
            Assert.assertEquals(PageTitle,"Post payment");
        }
        catch (Exception e){}
    }

    public void SelectPayment()
    {
        exists = false;
        WebElement WebEle = null;
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'payment-method-container')]/descendant::tbody/tr[1]/descendant::input", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'payment-method-container')]/descendant::tbody/tr[1]/descendant::input");
                HelpersMethod.ClickBut(driver, WebEle, 20);
                exists = true;
            }
            else
            {
                scenario.log("NOT FOUND ANY PAYMENT METHODS");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Click_PostBut()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,PostBut,20);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Thank you')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                HelpersMethod.ClickBut(driver,WebEle,20);
            }
            exists=true;
        }
        catch (Exception e){}
    }

    public void CancelButton()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,CancelBut,20);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void AddNewPayment()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,AddPayment,20);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateAddingPaymentDetails()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'New payment method')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PaymentType()
    {
        exists=false;
        try
        {
            WebElement PaymentDropDown=HelpersMethod.FindByElement(driver,"id","PaymentType");
            HelpersMethod.ClickBut(driver,PaymentDropDown,10);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PaymentDropDown(String PayType)
    {
        exists=false;
        try
        {
            HelpersMethod.DropDownMenu(driver,PayType);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterFirstName(String FName)
    {
        exists=false;
        WebElement FirstName=HelpersMethod.FindByElement(driver,"id","FirstName");
        try
        {
            if(FirstName.isDisplayed() && FirstName.isEnabled())
            {
                HelpersMethod.EnterText(driver,FirstName,10,FName);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterLastName(String LName)
    {
        exists=false;
        WebElement LastName=HelpersMethod.FindByElement(driver,"id","LastName");
        try
        {
            if(LastName.isDisplayed() && LastName.isEnabled())
            {
                HelpersMethod.EnterText(driver,LastName,10,LName);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_AccType()
    {
        exists=false;
        WebElement BankAccType=HelpersMethod.FindByElement(driver,"id","BAAccountType");
        try
        {
            if(BankAccType.isDisplayed() && BankAccType.isEnabled())
            {
                HelpersMethod.ClickBut(driver,BankAccType,10);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Select_AccType(String AcType)
    {
        exists=false;
        try
        {
            List<WebElement> AccTypes=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-scroller')]/ul/li");
            HelpersMethod.ActClick(driver,AccTypes.get(1),20);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Enter_Route()
    {
        exists=false;
        WebElement RouteNo=HelpersMethod.FindByElement(driver,"id","BARoutingNumber");
        try
        {
            HelpersMethod.EnterText(driver,RouteNo,20, RandomValues.generateRandomAlphaNumeric(5));
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Enter_AccountNo()
    {
        exists=false;
        WebElement BankNo=HelpersMethod.FindByElement(driver,"id","BAAccountNumber");
        try
        {
            HelpersMethod.EnterText(driver,BankNo,10, RandomValues.generateRandomNumber(10));
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SetPreferenceCheckbox()
    {
        exists=false;
        WebElement SetPrefer=HelpersMethod.FindByElement(driver,"id","IsPreferred");
        try
        {
            HelpersMethod.ClickBut(driver,SetPrefer,10);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void NewPaymentOkBut()
    {
        exists=false;
        WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
        try
        {
            HelpersMethod.ClickBut(driver,WebEle,10);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
