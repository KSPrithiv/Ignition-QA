package pages_DSD_OMS.login;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import util.TestBase;
import java.awt.*;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;


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

    @FindBy(id = "signInBtn")
    //@FindBy(xpath="//button[contains(@class,'k-button k-primary k-button-icontext')]")
    private WebElement SignIn;

    @FindBy(xpath = "//button[text()='Forgot password']")
    private WebElement Forgotten;

    @FindBy(id = "viewProductCatalogLink")
    private WebElement ExternalCatalog;

    @FindBy(id="rememberMe")
    private WebElement RememberMe;

    @FindBy(xpath = "//a[@id='registerHereLink']")
    private WebElement Register;

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
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.waitTillTitleContains(driver,"Login",2000);
            String title= driver.getTitle();
            if(title.contains("Login"))
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
            Thread.sleep(8000);
            HelpersMethod.clearText(driver,Username,8000);
            HelpersMethod.sendKeys(driver,Username,1000,un);
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
            HelpersMethod.clearText(driver,Password,1000);
            HelpersMethod.sendKeys(driver,Password,1000,pwd);
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
            String status=null;
            if(SignIn.isEnabled())
            {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                HelpersMethod.ScrollElement(driver, SignIn);
                HelpersMethod.ActClick(driver, SignIn, 1000);
                HelpersMethod.waitTillPageLoaded(driver, 800000);
                Thread.sleep(5000);
                exists = true;
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                scenario.log("SIGNIN BUTTON CLICKED");
            }
        }
        catch (Exception e){}
    }

    public boolean CheckErrorMessage()
    {
        Boolean visiblity=null;
        WebElement ErrorMessage=HelpersMethod.FindByElement(driver,"id","errorValidation");
        //new WebDriverWait(driver,200).until(ExpectedConditions.visibilityOf(ErrorMessage));
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
                HelpersMethod.ActClick(driver, Forgotten, 1000);
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'password-assistance-dialog ')]/descendant::div[contains(@class,'k-widget k-window k-dialog')]", 100);
            WebElement ForgottenPass = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'password-assistance-dialog ')]/descendant::div[contains(@class,'k-widget k-window k-dialog')]");
            if (ForgottenPass.isDisplayed())
            {
                //Enter user name in input box, in popup
                WebElement UserInput = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Password')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::input");
                HelpersMethod.clearText(driver, UserInput, 1000);
                HelpersMethod.sendKeys(driver, UserInput, 1000,username);
                String emailUserName=HelpersMethod.JSGetValueEle(driver,UserInput,1000);
                scenario.log("USER NAME ENTERED FOR PASSWORD ASSISTANCE "+emailUserName);
                //Click on Send button
                WebElement SendBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Send']");
                HelpersMethod.clickOn(driver, SendBut, 1000);
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
            Thread.sleep(2000);
           // HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//p[contains(text(),'product catalog')]", 400000);
            if(HelpersMethod.IsExists("//a[@id='viewProductCatalogLink']/p",driver))
            {
                HelpersMethod.ScrollElement(driver,ExternalCatalog);
                //HelpersMethod.ActClick(driver,ExternalCatalog,1000);
                HelpersMethod.JScriptClick(driver,ExternalCatalog,10000);
                exists=true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
                HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'product-catalog-page')]",100000);
                new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'ext-product-catalog-app')]")));
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
            Thread.sleep(8000);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//a[@id='registerHereLink']",driver))
            {
                HelpersMethod.ScrollDownScrollBar(driver);
                HelpersMethod.ActClick(driver,Register,10000);
                scenario.log("REGISTER HERE BUTTON IS CLICKED");
                exists=true;
            }
            else
            {
                scenario.log("REGISTER HERE BUTTON IS NOT VISIBLE");
                exists=false;
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
            if (RememberMe.isDisplayed() && RememberMe.isEnabled())
            {
                HelpersMethod.ActClick(driver, RememberMe, 1000);
                exists=true;
            }
            else
            {scenario.log("REMEMBER ME CHECKBOX IS NOT VISIBLE");}
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateCustomerIndexPopup()
    {
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", 20000);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Customer account index", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void CustomerIndexPopup() throws InterruptedException
    {
        exists = false;
        WebElement WebEle;
        WebElement Search2;
        String AccNo = TestBase.testEnvironment.get_Account();
        String status=null;
        try
        {
            Thread.sleep(4000);
            //new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            // code to click on Addfilter button
            WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
            HelpersMethod.ActClick(driver, AddFilterButton, 1000);

            //Identify the dialog popup
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 6000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]", 6000);
            WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");

            //Enter customer account# in input box
            WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.EnterText(driver, Search1, 1000, "Customer #");

            //Click on Check box
            HelpersMethod.WaitElementPresent(driver, "xpath", "//input[@id='FORMATTED_CM_CUSTKEY']", 400);
           // new WebDriverWait(driver, 20000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='CM_CUSTKEY']")));
            WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[@id='FORMATTED_CM_CUSTKEY']"));
            HelpersMethod.JScriptClick(driver, WebEle1, 1000);

            //Identify radio button and click on Radio button
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 1000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 1000);
            WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
            Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            HelpersMethod.ActSendKey(driver, Search2, 1000, AccNo);

            //Click on Apply button
            WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button[text()='Apply']"));
            HelpersMethod.ClickBut(driver, ApplyButton, 1000);
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-grid-container')]", 1000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']", driver))
            {
                scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
            }
            else
            {
                WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 1000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists = true;
                String Acc = TestBase.testEnvironment.get_Account();
                scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
            }
            Thread.sleep(4000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickSigninForSalesHelp()
    {
        try {
            exists = false;
            WebElement WebEle;
            String status = null;
            if (SignIn.isEnabled()) {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                HelpersMethod.ScrollElement(driver, SignIn);
                HelpersMethod.ActClick(driver, SignIn, 1000);
                HelpersMethod.waitTillPageLoaded(driver, 800000);
                Thread.sleep(5000);
                exists = true;
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                scenario.log("SIGNIN BUTTON CLICKED");
            }
        }
        catch (Exception e){}
    }

    public void ClickSigninForExternalOrder()
    {
        try {
            exists = false;
            WebElement WebEle;
            String status = null;
            if (SignIn.isEnabled()) {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                HelpersMethod.ScrollElement(driver, SignIn);
                HelpersMethod.ActClick(driver, SignIn, 1000);
                HelpersMethod.waitTillPageLoaded(driver, 800000);
                Thread.sleep(5000);
                exists = true;
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                scenario.log("SIGNIN BUTTON CLICKED");
            }
        }
        catch (Exception e){}
    }

    public void enterCredentialsCheckboxClick()
    {
        try
        {
            String username = TestBase.testEnvironment.username();
            String password = TestBase.testEnvironment.password();
            boolean rememberMe = true;

            LoginRequest loginRequest = new LoginRequest(username, password, rememberMe);
            Gson gson = new Gson();
            String jsonPayload = gson.toJson(loginRequest);

            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(TestBase.testEnvironment.get_url());
            httpPost.setEntity(new StringEntity(jsonPayload, ContentType.APPLICATION_JSON));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                // Process the response as needed (e.g., check for success or failure)
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
                String line;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                // Handle the response JSON or other data
                String jsonResponse = stringBuilder.toString();
                scenario.log(jsonResponse);
            } else {scenario.log("No response entity received.");
            }
        }
        catch (Exception e){}
    }
}