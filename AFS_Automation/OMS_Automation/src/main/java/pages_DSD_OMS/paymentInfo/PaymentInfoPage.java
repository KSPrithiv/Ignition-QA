package pages_DSD_OMS.paymentInfo;

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

    @FindBy(xpath="//label[@id='customerAccountIndexField-label']/following-sibling::div/descendant::button")
    private WebElement CustAccIndex;

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
        try
        {
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("Payment Info").build().perform();
            WebElement PaymentInfoMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Payment Info')]");
            HelpersMethod.ActClick(driver, PaymentInfoMenu, 100);
            currentURL = driver.getCurrentUrl();
            exists=true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));
            if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).click().build().perform();
            }
        }
        catch (Exception e) {}
        Assert.assertEquals(exists, true);
    }

    public void ValidatePaymentInfo()
    {
        String title=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
            }
            title=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'topHeaderRow')]/descendant::span").getText();
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
           // HelpersMethod.ActClearKey(driver, CustomerAcc,10);
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

    public void clickOnCustomerAccountIndex()
    {
        try
        {
            HelpersMethod.ActClick(driver,CustAccIndex,100);
        }
        catch (Exception e){}
    }

    public void SelectCustomerAccount()
    {
        exists = false;
        WebElement WebEle;
        WebElement Search2;
        String AccNo = TestBase.testEnvironment.get_Account();
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            // code to click on Addfilter button
            WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
            HelpersMethod.ActClick(driver, AddFilterButton, 1000);

            //Identify the dialog popup
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]", 4000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]", 1000);
            WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]");

            //Validate child popup
            //WebElement childTitle = modalContainer1.findElement(By.xpath(".//div[contains(@class,'i-filter-popup__checkboxes')]/h1"));
            //Assert.assertEquals(childTitle.getText(), "Basic", "Verify Title message");

            //Enter customer account# in input box
            WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.EnterText(driver, Search1, 800, "Customer account #");

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Click on Check box
            HelpersMethod.WaitElementPresent(driver, "xpath", "//input[contains(@id,'CM_CUSTKEY')]", 400);
            new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'CM_CUSTKEY')]")));
            WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[contains(@id,'CM_CUSTKEY')]"));
            HelpersMethod.JScriptClick(driver, WebEle1, 400);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Identify radio button and click on Radio button
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 400);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 200);
            WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
            WebElement radioButton = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            if (radioButton.isDisplayed())
            {
                Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                HelpersMethod.EnterText(driver, Search2, 200, AccNo);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                //Click on Apply button
                WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button[text()='Apply']"));
                new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ApplyButton));
                HelpersMethod.ClickBut(driver, ApplyButton, 40);
            }

            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']", driver))
            {
                scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
            }
            else
            {
                WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 40);


                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                exists = true;
                String Acc = TestBase.testEnvironment.get_Account();
                scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
            }
        }
        catch (Exception e){}
    }

    public void Click_Plus()
    {
        exists=false;
        try
        {
            if(addPayment.isDisplayed() && addPayment.isEnabled())
            {
                HelpersMethod.ClickBut(driver, addPayment, 200);
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }
}
