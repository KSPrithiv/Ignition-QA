package pages_DSD_OMS.paymentInfo;

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
import util.TestBase;

import java.time.Duration;

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
    static String currentURL;

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
                driver.navigate().to(currentURL);
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
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("Payment Info").build().perform();
            if(HelpersMethod.IsExists("//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Payment Info')]|//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Payment info')]",driver)) {
                WebElement PaymentInfoMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Payment Info')]|//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Payment info')]");
                HelpersMethod.ActClick(driver, PaymentInfoMenu, 10000);
                currentURL = driver.getCurrentUrl();
                exists = true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]")));
                if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                    act.moveToElement(WebEle).click().build().perform();
                }
            }
            else
            {
                scenario.log("PAYMENT INFO PAGE NOT FOUND");
            }
        }
        catch (Exception e) {}
        Assert.assertEquals(exists, true);
    }

    public void ValidatePaymentInfo()
    {
        exists=false;
        String title=null;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            title=HelpersMethod.gettingTitle(driver);
            if(title.contains("Payment Info"));
            {
                exists=true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void EnterAccount()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            // HelpersMethod.ActClearKey(driver, CustomerAcc,10);
            HelpersMethod.ActSendKey(driver,CustomerAcc,1000, TestBase.testEnvironment.get_Account());
            WebElement AccDrop = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@id,'option-')]");
            HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'k-list-container ')]/descendant::li", "xpath", AccDrop.getText());
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void clickOnCustomerAccountIndex()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement  WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(CustAccIndex.isDisplayed() && CustAccIndex.isEnabled())
            {
                HelpersMethod.ActClick(driver, CustAccIndex, 10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
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

            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]")));
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            // code to click on Addfilter button
            WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
            HelpersMethod.ActClick(driver, AddFilterButton, 10000);

            //Identify the dialog popup
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]", 8000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]", 8000);
            WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]");

            //Enter customer account# in input box
            WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.EnterText(driver, Search1, 10000, "Customer account #");

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Click on Check box
            HelpersMethod.WaitElementPresent(driver, "xpath", "//input[contains(@id,'CM_CUSTKEY')]", 400);
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'CM_CUSTKEY')]")));
            WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[contains(@id,'CM_CUSTKEY')]"));
            HelpersMethod.JScriptClick(driver, WebEle1, 10000);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Identify radio button and click on Radio button
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 4000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 4000);
            WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
            WebElement radioButton = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            if (radioButton.isDisplayed())
            {
                Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                HelpersMethod.EnterText(driver, Search2, 10000, AccNo);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                //Click on Apply button
                WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button/span[text()='Apply']"));
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(ApplyButton));
                HelpersMethod.ClickBut(driver, ApplyButton, 10000);
            }

            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-no-data']", driver))
            {
                scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
            }
            else
            {
                WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 10000);

                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
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
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement  WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(addPayment.isDisplayed() && addPayment.isEnabled())
            {
                HelpersMethod.ClickBut(driver, addPayment, 10000);
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }
}