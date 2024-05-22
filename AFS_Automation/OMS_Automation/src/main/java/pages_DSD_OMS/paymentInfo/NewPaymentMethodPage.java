package pages_DSD_OMS.paymentInfo;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.RandomValues;

import java.util.List;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
public class NewPaymentMethodPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="PaymentType")
    private WebElement PaymentDropDown;

    @FindBy(id="FirstName")
    private WebElement FirstName;

    @FindBy(id="LastName")
    private WebElement LastName;

    @FindBy(id="BAAccountType")
    private WebElement BankAccType;

    @FindBy(id="BARoutingNumber")
    private WebElement RouteNo;

    @FindBy(id="BAAccountNumber")
    private WebElement BankNo;

    @FindBy(id="IsPreferred")
    private WebElement SetPrefer;

    @FindBy(id="saveEditButton")
    private WebElement SaveBut;

    @FindBy(id="cancelEditButton")
    private WebElement CancelBut;

    public NewPaymentMethodPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Action
    public void Validate_NewPaymentInfo()
    {
        exists=false;
        String title=null;
        try
        {
            title= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'topHeaderRow')]/descendant::span").getText();
        }
        catch (Exception e){}
        Assert.assertEquals(title,"New payment method");
    }

    public void PaymentType()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,PaymentDropDown,1000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void PaymentDropDown(String PayType)
    {
        exists=false;
        Actions act=new Actions(driver);
        String paymentText;
        try
        {
            //HelpersMethod.DropDownMenu(driver,PayType);
            List<WebElement> paymentModes=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='PaymentType-listbox-id']/li/span");
            for(WebElement payment:paymentModes)
            {
                act.moveToElement(payment).build().perform();
                paymentText=payment.getText();
                if(paymentText.equalsIgnoreCase(PayType))
                {
                    act.moveToElement(payment).build().perform();
                    act.click(payment).build().perform();
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterFirstName(String FName)
    {
        exists=false;
        try
        {
            if(FirstName.isDisplayed() && FirstName.isEnabled())
            {
                HelpersMethod.EnterText(driver,FirstName,10000,FName);
                exists=true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void EnterLastName(String LName)
    {
        exists=false;
        try
        {
            if(LastName.isDisplayed() && LastName.isEnabled())
            {
                HelpersMethod.EnterText(driver,LastName,10000,LName);
                exists=true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void Click_AccType()
    {
        exists=false;
        try
        {
            if(BankAccType.isDisplayed() && BankAccType.isEnabled())
            {
                HelpersMethod.ClickBut(driver,BankAccType,10000);
                exists=true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void Select_AccType(String AcType)
    {
        exists=false;
        try
        {
            List<WebElement> AccTypes=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='BAAccountType-listbox-id']/li");
            HelpersMethod.ActClick(driver,AccTypes.get(1),10000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void Enter_Route()
    {
        exists=false;
        try
        {
            if(RouteNo.isDisplayed() && RouteNo.isEnabled())
            {
                String routeNo=RandomValues.generateRandomAlphaNumeric(5);
                HelpersMethod.ActSendKey(driver, RouteNo, 10000,routeNo);
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void Enter_AccountNo()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,BankNo,10000, RandomValues.generateRandomNumber(10));
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void SetPreferenceCheckbox()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,SetPrefer,10000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void Click_Save()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,SaveBut,10000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void Click_Cancel()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,CancelBut,10000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }
}