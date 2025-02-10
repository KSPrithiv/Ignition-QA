package pages_DSD_OMS.login;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
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
import java.awt.*;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import util.TestBase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;

import static util.TestBase.getDriver;


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

    @FindBy(xpath = "//label[text()='Login']/following-sibling::input")
    private WebElement Username;

    @FindBy(xpath = "//label[text()='Password']/following-sibling::input")
    private WebElement Password;

    @FindBy(id = "signInBtn")
    private WebElement SignIn;

    @FindBy(xpath = "//button/span[text()='Forgot password']")
    private WebElement Forgotten;

    @FindBy(id = "viewProductCatalogLink")
    private WebElement ExternalCatalog;

    @FindBy(id="rememberMe")
    private WebElement RememberMe;

    @FindBy(id= "registerHereLink")
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
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.waitTillTitleContains(driver,"Login",6000);
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
            Thread.sleep(6000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(Username.isDisplayed() && Username.isEnabled())
            {
                HelpersMethod.clearText(driver, Username, 2000);
                HelpersMethod.sendKeys(driver, Username, 50000, un);
                exists = true;
            }
              Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterPassword(String pwd) throws InterruptedException
    {
        exists=false;
        try
        {
            if(Password.isDisplayed() && Password.isEnabled())
            {
                HelpersMethod.clearText(driver, Password, 10000);
                HelpersMethod.sendKeys(driver, Password, 10000, pwd);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    public void ClickSignin() throws InterruptedException
    {
        try
        {
            exists = false;
            String status;
            if(SignIn.isEnabled())
            {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                Thread.sleep(2000);
                HelpersMethod.ScrollElement(driver, SignIn);
                //HelpersMethod.JScriptClick(driver, SignIn, 60000);
                HelpersMethod.ClickBut(driver,SignIn,60000);
                Thread.sleep(10000);

                status = HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='app']")));

                exists = true;

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(800))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                scenario.log("SIGNIN BUTTON CLICKED");
            }
        }
        catch (Exception e){}
    }

    public boolean CheckErrorMessage()
    {
        Boolean visiblity=false;
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
                HelpersMethod.ActClick(driver, Forgotten, 10000);
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
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'password-assistance-dialog ')]/descendant::div[contains(@class,'k-window k-dialog')]", 100);
            WebElement ForgottenPass = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'password-assistance-dialog ')]/descendant::div[contains(@class,'k-window k-dialog')]");
            if (ForgottenPass.isDisplayed())
            {
                //Enter user name in input box, in popup
                WebElement UserInput = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Password')]/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::input");
                HelpersMethod.clearText(driver, UserInput, 10000);
                HelpersMethod.sendKeys(driver, UserInput, 10000,username);
                String emailUserName=HelpersMethod.JSGetValueEle(driver,UserInput,10000);
                scenario.log("USER NAME ENTERED FOR PASSWORD ASSISTANCE "+emailUserName);
                //Click on Send button
                WebElement SendBut = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Send']");
                HelpersMethod.clickOn(driver, SendBut, 10000);
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
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Thread.sleep(4000);
           // HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//p[contains(text(),'product catalog')]", 400000);
            if(HelpersMethod.IsExists("//a[@id='viewProductCatalogLink']/p",driver))
            {
                HelpersMethod.ScrollElement(driver,ExternalCatalog);
                HelpersMethod.JScriptClick(driver,ExternalCatalog,40000);
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
                Thread.sleep(2000);
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
            HelpersMethod.ScrollDownScrollBar(driver);
            if(HelpersMethod.IsExists("//a[@id='registerHereLink']",driver))
            {
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

    public void validateRegisterHere()
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
            HelpersMethod.ScrollElement(driver,SignIn);
            if(HelpersMethod.IsExists("//a[@id='registerHereLink']",driver))
            {
                scenario.log("REGISTER HERE BUTTON IS VISIBLE ON LOGIN PAGE");
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

    public void validateNonRegisterHere()
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
            if(!HelpersMethod.IsExists("//a[@id='registerHereLink']",driver))
            {
                scenario.log("REGISTER HERE BUTTON IS NOT VISIBLE ON LOGIN PAGE");
                exists=true;
            }
            else
            {
                scenario.log("REGISTER HERE BUTTON IS VISIBLE");
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
                HelpersMethod.ActClick(driver, RememberMe, 10000);
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
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[@id='customerAccountIndexDialog']/ancestor::div[contains(@class,'k-window k-dialog')]", 20000);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[@id='customerAccountIndexDialog']/ancestor::div[contains(@class,'k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-titlebar')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Customer account index", "Verify Title message");
            scenario.log("CUSTOMER ACCOUNT INDEX DIALOG BOX HAS BEEN FOUND");
        }
        catch (Exception e){}
    }

    public void CustomerIndexPopup() throws InterruptedException
    {
        exists = false;
        WebElement WebEle;
        WebElement Search2;
        String Acc = TestBase.testEnvironment.get_Account();
        String status;
        Wait<WebDriver> wait;
        try
        {
            Thread.sleep(6000);
            //new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
            //WebElement modalContainer = driver.findElement(By.xpath("//div[@id='customerAccountIndexDialog']/ancestor::div[contains(@class,'k-window k-dialog')]"));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Add filter')]",driver))
            {
                driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Add filter')]")).click();
                new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-animation-container k-animation-container-shown']")));

                WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-animation-container k-animation-container-shown']");
                WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
                HelpersMethod.ActSendKey(driver, Search1, 10000, "Customer #");
                //Click on Check box
                new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'k-checkbox')]")));
                WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
                HelpersMethod.ActClick(driver, WebEle1, 10000);

                //Identify radio button and click on Radio button
                new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 80000);
                if (HelpersMethod.IsExists("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]", driver))
                {
                    WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
                    Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                    HelpersMethod.EnterText(driver, Search2, 10000, Acc);

                    //Click on Apply button
                    WebElement applyButton = RadioPop.findElement(By.xpath(".//button/span[text()='Apply']"));
                    HelpersMethod.ClickBut(driver, applyButton, 10000);
                    exists = true;
                }
            }
            else
            {
                WebElement searchBox=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::input[@id='customerAccountIndexSearchBar']");
                HelpersMethod.ActSendKey(driver,searchBox,10000,Acc);
                HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::input[@id='customerAccountIndexSearchBar']/preceding-sibling::*[local-name()='svg']").click();
            }

            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-no-data']", driver))
            {
                scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
            }
            else
            {
                status=HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                //new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]"))));
                WebElement accountNo=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ScrollElement(driver,accountNo);
                scenario.log("ACCOUNT NUMBER SELECTED IS "+accountNo.getText());
                HelpersMethod.ActClick(driver, accountNo, 10000);
                status=HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status=HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status=HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                exists=true;
                scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
                Thread.sleep(10000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickSigninForSalesHelp()
    {
        try
        {
            exists = false;
            String status;
            if (SignIn.isEnabled())
            {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                HelpersMethod.ScrollElement(driver, SignIn);
                HelpersMethod.ActClick(driver, SignIn, 10000);
                HelpersMethod.waitTillPageLoaded(driver, 800000);
                Thread.sleep(5000);
                exists = true;
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
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
            String status;
            if (SignIn.isEnabled())
            {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                HelpersMethod.ScrollElement(driver, SignIn);
                HelpersMethod.ActClick(driver, SignIn, 10000);
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
                        .withTimeout(Duration.ofSeconds(600))
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
            String password = TestBase.testEnvironment.Userword();
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
                while ((line = reader.readLine()) != null)
                {
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

    public void getURL()
    {
        String status = null;
        String currenturl=null;

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading")) {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            currenturl=driver.getCurrentUrl();
            scenario.log("CURRENT URL IS "+currenturl);
        }
        catch (Exception e){}
    }
}