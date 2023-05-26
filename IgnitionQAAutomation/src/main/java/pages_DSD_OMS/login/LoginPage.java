package pages_DSD_OMS.login;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import util.TestBase;

import java.awt.*;
import java.util.ServiceConfigurationError;
import java.util.concurrent.TimeUnit;

/**
 * @Project DSD_ERP
 * @Author Divya.Ramadas@afsi.com
 */
public class LoginPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    //public static String url=null;

    @FindBy(xpath = "//label[text()='Login']/following-sibling::input")
    private WebElement Username;

    @FindBy(xpath = "//label[text()='Password']/following-sibling::input")
    private WebElement Password;

    //@FindBy(xpath = "//button[contains(@class,'k-button k-primary k-button-icontext') and contains(text(),'Sign in')]")
    @FindBy(xpath = "(//div[@class='form-group'])[4]/button")
    private WebElement SignIn;

    @FindBy(xpath = "//button[text()='Forgot password']")
    private WebElement Forgotten;

    @FindBy(xpath = "//a/p[contains(text(),'View product catalog')]")
    private WebElement ExternalCatalog;

    @FindBy(id="rememberMe")
    private WebElement RememberMe;

    @FindBy(xpath = "//p[contains(text(),'Register here')]")
    private WebElement Register;

//    @BeforeClass
//    public void WaitForPage()
//    {
//        HelpersMethod.Implicitwait(driver,40);
//    }

    public LoginPage(WebDriver driver,Scenario scenario) throws InterruptedException, AWTException
    {
        this.scenario=scenario;
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public boolean validateLoginPageTitle()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            HelpersMethod.waitTillTitleContains(driver,"Ignition - Login",20);
            String title= driver.getTitle();
            if(title.equals("Ignition - Login"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    public void EnterUsername(String un) throws InterruptedException
    {
        exists=false;
        try
        {
            HelpersMethod.clearText(driver,Username,40);
            HelpersMethod.sendKeys(driver,Username,40,un);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    public void EnterPassword(String pwd) throws InterruptedException
    {
        exists=false;
        try
        {
            HelpersMethod.clearText(driver,Password,40);
            HelpersMethod.sendKeys(driver,Password,40,pwd);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    public void ClickSignin() throws InterruptedException
    {
        try
        {
            exists = false;
            WebElement WebEle;
            //if (HelpersMethod.IsExists("//button[contains(@class,'k-button k-primary k-button-icontext') and contains(text(),'Sign in')]", driver))
            if (HelpersMethod.IsExists("(//div[@class='form-group'])[4]/button", driver))
            {
                HelpersMethod.ScrollElement(driver, SignIn);
                HelpersMethod.JScriptClick(driver, SignIn, 20);
                //HelpersMethod.clickOn(driver, SignIn, 20);
                HelpersMethod.waitTillPageLoaded(driver, 2000);

                exists = true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("SIGNIN BUTTON CLICKED");
            }
        }
        catch (Exception e){}
    }
    public boolean CheckErrorMessage()
    {
        Boolean visiblity=null;
            WebElement ErrorMessage=HelpersMethod.FindByElement(driver,"id","errorValidation");
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(ErrorMessage));
            if (ErrorMessage.isDisplayed())
            {
                visiblity = true;
            }
            else
            {
                visiblity = false;
            }
        return visiblity;
    }

    public void ForgottenPassword()
    {
        exists=false;
        try
        {
            if (Forgotten.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,Forgotten);
                HelpersMethod.ActClick(driver, Forgotten, 20);
                exists=true;
            }
            else
            {
                scenario.log("FORGOTTEN PASSWORD BUTTON HAS NOT BEEN DISPLAYED");
            }
            Assert.assertEquals(exists,true);
        } catch (Exception e) {}
    }

    public void ForgottenPasswordFunctionality(String username)
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'password-assistance-dialog ')]/descendant::div[contains(@class,'k-widget k-window k-dialog')]", 2);
            WebElement ForgottenPass = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'password-assistance-dialog ')]/descendant::div[contains(@class,'k-widget k-window k-dialog')]");
            if (ForgottenPass.isDisplayed())
            {
                //Enter user name in input box, in popup
                WebElement UserInput = HelpersMethod.FindByElement(driver, "xpath", "//label[contains(text(),'User name')]/following-sibling::input");
                HelpersMethod.clearText(driver, UserInput, 10);
                HelpersMethod.sendKeys(driver, UserInput, 10,username);
                //Click on Send button
                WebElement SendBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Send']");
                HelpersMethod.clickOn(driver, SendBut, 10);
                scenario.log("FORGOTTEN PASSWORD BUTTON HAS BEEN HANDLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on View product catalog in login page
    public void ClickExternalCatalog()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//p[contains(text(),'product catalog')]", 10);
            if(HelpersMethod.EleDisplay(ExternalCatalog))
            {
                HelpersMethod.ScrollElement(driver,ExternalCatalog);
                HelpersMethod.ActClick(driver,ExternalCatalog,100);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                }
                new WebDriverWait(driver,1000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'ext-product-catalog-app')]")));
            }
            else
            {
                scenario.log("EXTERNAL CATALOG IS NOT VISIBLE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Click on Register here link
    public void RegisterHere()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            HelpersMethod.WaitElementPresent(driver,"id","unauthorized-content",2000);
            if(Register.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,Register);
                HelpersMethod.JScriptClick(driver,Register,800);
                exists=true;
            }
            else
            {scenario.log("REGISTER HERE BUTTON IS NOT VISIBLE");}
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void RefreshLogin()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 6000);
            }
           driver.navigate().to(TestBase.testEnvironment.get_url());
           exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 6000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ConfirmPopup()
    {
        exists=false;

        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='toast-container']");
            exists=true;
            if(HelpersMethod.EleDisplay(WebEle))
            {
                scenario.log("CONFIRMATION POPUP HAS BEEN DISPLAYED");
            }
            else
            {
                scenario.log("CONFIRMATION POPUP HAS NOT BEEN DISPLAYED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void RememberMe()
    {
        exists=false;
        try
        {
            if (RememberMe.isDisplayed())
            {
                HelpersMethod.ActClick(driver, RememberMe, 10);
                exists=true;
            }
            else
            {scenario.log("REMEMBER ME CHECKBOX IS NOT VISIBLE");}
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public boolean IfNotInLoginPage()
    {
        exists=false;
        try
        {
            String URL = HelpersMethod.gettingURL(driver);
            if (!URL.equals(TestBase.testEnvironment.get_url()))
            {
                exists = true;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public void ValidateCustomerIndexPopup()
    {
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",600);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Customer account index", "Verify Title message");
    }

    public void CustomerIndexPopup() throws InterruptedException
    {
        exists = false;
        WebElement WebEle;
        WebElement Search2;
        String AccNo = TestBase.testEnvironment.get_Account();

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        // code to click on Addfilter button
        WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
        HelpersMethod. ActClick(driver, AddFilterButton, 800);

        //Identify the dialog popup
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]",1500);
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",600);
        WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]");

        //Validate child popup
        WebElement childTitle = modalContainer1.findElement(By.xpath(".//div[contains(@class,'i-filter-popup__checkboxes')]/h1"));
        Assert.assertEquals(childTitle.getText(), "Basic", "Verify Title message");

        //Enter customer account# in input box
        WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
        HelpersMethod.EnterText(driver, Search1, 800, "Customer #");

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Click on Check box
        HelpersMethod.WaitElementPresent(driver,"xpath","//input[@id='CM_CUSTKEY']",400);
        new WebDriverWait(driver,200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='CM_CUSTKEY']")));
        WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[@id='CM_CUSTKEY']"));
        HelpersMethod.JScriptClick(driver, WebEle1, 400);
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        //Identify radio button and click on Radio button
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]",400);
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
            new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(ApplyButton));
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

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
            }
            exists = true;
            String Acc = TestBase.testEnvironment.get_Account();
            scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
        }
    }

    public void ClickSigninForSalesHelp()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//button[contains(@class,'k-button k-primary k-button-icontext') and contains(text(),'Sign in')]",driver))
        {
            exists = false;
            if (HelpersMethod.IsExists("//button[contains(@class,'k-button k-primary k-button-icontext') and contains(text(),'Sign in')]", driver))
            {
                HelpersMethod.ScrollElement(driver, SignIn);
                HelpersMethod.JScriptClick(driver, SignIn, 20);
                HelpersMethod.waitTillPageLoaded(driver, 500);
                exists = true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    new WebDriverWait(driver, 6000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                scenario.log("SIGNIN BUTTON CLICKED");
            }
        }
    }

    public void ClickSigninForExternalOrder()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//button[contains(@class,'k-button k-primary k-button-icontext') and contains(text(),'Sign in')]", driver))
            {
                HelpersMethod.ScrollElement(driver, SignIn);
                HelpersMethod.JScriptClick(driver, SignIn, 20);
                HelpersMethod.waitTillPageLoaded(driver, 2000);

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                new WebDriverWait(driver,800).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[@class='k-widget k-window k-dialog']")));
                exists = true;
                scenario.log("SIGNIN BUTTON CLICKED");
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }
    public void Refresh_Page()
    {

        driver.navigate().refresh();
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
    }
}
