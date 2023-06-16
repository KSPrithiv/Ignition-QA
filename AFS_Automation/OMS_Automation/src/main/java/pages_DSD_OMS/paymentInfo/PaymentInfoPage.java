package pages_DSD_OMS.paymentInfo;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.TestBase;

/**
        * @Project OMS_DSD
        * @Author Divya.Ramadas@afsi.com
 */
public class PaymentInfoPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String currentURL=null;

    @FindBy(id="customerAccountIndexField_AC")
    private WebElement CustomerAcc;

    @FindBy(id="autoPayCheckBox")
    private  WebElement autoPayCheckBox;

    @FindBy(id="addPaymentMethodButton")
    private WebElement addPayment;

    @FindBy(id="deletePaymentMethodButton")
    private WebElement delPayment;

    @FindBy(id="setPreferedPaymentMethodButton")
    private WebElement setPreferedPay;


    public PaymentInfoPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

//Actions
public void HandleError_Page()
{
    try
    {
        String URL = HelpersMethod.gettingURL(driver);
        if (URL.contains("cpError"))
        {
            HelpersMethod.NavigateBack(driver);
            URL = HelpersMethod.gettingURL(driver);
        }
        if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
        {
            HomePage homepage = new HomePage(driver, scenario);
            homepage.navigateToClientSide();
            NavigateToPaymentInfo();
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
    }

    public void NavigateToPaymentInfo()
    {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");

                act.moveToElement(Search_Input).click().sendKeys("Bill To Billing").build().perform();
                WebElement BillMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Payment Info')]");
                HelpersMethod.ClickBut(driver, BillMenu, 20);
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
             currentURL=driver.getCurrentUrl();
            if(HelpersMethod.IsExists("//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Payment Info')]",driver))
            {
                scenario.log("NAVIGATED TO PAYMENT INFO PAGE");
            }
            else
            {
                scenario.log("PAYMENT INFO, MAY NOT BE ENABLED FOR THE APPLICATION");
            }

        } catch (Exception e) {}
        Assert.assertEquals(exists, true);
    }

    public void ValidatePaymentInfo()
    {
        String title=null;
        try
        {
            title=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'topHeaderRow row')]/descendant::span").getText();
        }
        catch (Exception e){}
        Assert.assertEquals(title,"Payment Info");
    }

    public void EnterAccount()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.ActClearKey(driver, CustomerAcc,10);
            HelpersMethod.ActSendKey(driver,CustomerAcc,10, TestBase.testEnvironment.get_Account());
            WebElement AccDrop = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@id,'option-')]");
            HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'k-list-container ')]/descendant::li", "xpath", AccDrop.getText());
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        }
        catch (Exception e){}
    }

    public void Click_Plus()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(addPayment.isDisplayed() && addPayment.isEnabled())
            {
                HelpersMethod.ClickBut(driver, addPayment, 10);
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

}
