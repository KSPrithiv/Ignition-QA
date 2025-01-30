package pages_DSD_OMS.competitivePricing;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.RandomValues;
import util.TestBase;

import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class CompetitivePricingGeneralPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String code;
    static String desc;
    static String currentURL;
    static String Prod1;


    @FindBy(xpath="//label[contains(text(),'Customer reference')]/following-sibling::span/span")
    private WebElement CustomerRefDropdown;

    @FindBy(xpath="//label[contains(text(),'Customer account #')]/following-sibling::div/descendant::button")
    private WebElement CustomerAccIndex;

    @FindBy(xpath="//label[contains(text(),'Competitor')]/following-sibling::span/span")
    private WebElement CompetitorDropdown ;

    @FindBy(xpath="//button/span[contains(text(),'New competitor')]")
    private WebElement NewCompetitor;

    @FindBy(xpath="//label[text()='Source']/following-sibling::textarea")
    private WebElement SourceText;

    @FindBy(xpath="//label[text()='Comments']/following-sibling::textarea")
    private WebElement CommentText;

    @FindBy(xpath="//button/span[contains(text(),'Load existing data')]")
    private WebElement LoadexistingData;

    @FindBy(xpath="//button/span[contains(text(),'Delete competitor data')]")
    private WebElement DeleteCompetitorData;

    @FindBy(xpath="//button/span[text()='Save']")
    private WebElement SaveBut;

    @FindBy(xpath="//button/span[text()='Cancel']")
    private WebElement CancelBut;

    @FindBy(id="plus")
    private WebElement PlusBut;

    @FindBy(id="deleteAdditionalAccountButton")
    private WebElement DeleteBut;

    @FindBy(id="SearchBox1")
    private WebElement SearchBar;

    @FindBy(xpath="//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement SearchIndex;

    public CompetitivePricingGeneralPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //actions
    public void NavigateToCompetitorPricing()
    {
        exists = false;
        WebElement WebEle;
        String status;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            Actions act = new Actions(driver);
            if (HelpersMethod.IsExists("//div[@class='item-searchbar']//*[local-name()='svg']", driver))
            {
                WebElement humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='item-searchbar']//*[local-name()='svg']");
                HelpersMethod.ActClick(driver, humburger, 10000);
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='drawer-menu-search-container']/descendant::input"))));
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='drawer-menu-search-container']/descendant::input")));
            }
            if(HelpersMethod.IsExists("//div[@class='settings-back-container']",driver))
            {
                WebElement arrow=HelpersMethod.FindByElement(driver,"xpath","//div[@class='settings-back-container']");
                HelpersMethod.ActClick(driver,arrow,10000);
                Thread.sleep(500);
            }

            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("Competitive Pricing").build().perform();
            WebElement CompetitorMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Competitive Pricing')]");
            HelpersMethod.ClickBut(driver, CompetitorMenu, 10000);
            exists = true;
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            currentURL = driver.getCurrentUrl();
            scenario.log(currentURL);

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).click().build().perform();
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Competitive Pricing')]",driver))
            {
                scenario.log("NAVIGATED TO COMPETITOR PRICING PAGE");
            }
            else
            {
                scenario.log("COMPETITOR PRICING MAY NOT BE ENABLED FOR THE APPLICATION, CHECK WITH ADMIN SETTINGS");
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e) {}
    }

    public void HandleError_Page()
    {
        try
        {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError"))
            {
                HelpersMethod.NavigateBack(driver);
                //URL = HelpersMethod.gettingURL(driver);
                driver.navigate().to(currentURL);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
            {
                HomePage homepage = new HomePage(driver, scenario);
                homepage.navigateToClientSide();
                NavigateToCompetitorPricing();
            }
        }
        catch (Exception e) {}
    }

    public void Refresh_Page()
    {
        String status;
        Wait<WebDriver> wait;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                wait = new WebDriverWait(driver, Duration.ofMillis(1000));
                if(wait.until(ExpectedConditions.alertIsPresent())==null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
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
            }


            driver.navigate().to(currentURL);

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
        }
        catch (Exception e){}
    }

    public void ValidateCompetitorGeneral()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@id='card1']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_CustomerReferenceDropDown()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(CustomerRefDropdown.isDisplayed() && CustomerRefDropdown.isEnabled())
           {
               HelpersMethod.JScriptClick(driver, CustomerRefDropdown, 10000);
               exists = true;
           }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    //public void Select_CustomerReference(String CustRef, String CustRef1)
    public void Select_CustomerReference(String CustRef)
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait;
            WebElement WebEle;
            Actions act1 = new Actions(driver);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]", 40000);
            // to fetch the web element of the modal container
            WebElement menuContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> Options = menuContainer.findElements(By.xpath(".//ul/li"));
            for (int i = 0; i <= Options.size() - 1; i++)
            {
                WebEle = Options.get(i);
                act1.moveToElement(WebEle).build().perform();
                String Opt = WebEle.getText();
                if(Opt.equalsIgnoreCase(CustRef))
                {
                    Thread.sleep(500);
                    //act1.moveToElement(WebEle).build().perform();
                    act1.click(WebEle).build().perform();
                    break;
                }
                else
                {
                    act1.moveToElement(WebEle).sendKeys(Keys.ARROW_DOWN).build().perform();
                    wait = new FluentWait<>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch(Exception e){}
    }

    public void Click_CustomerAccountIndex()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(CustomerAccIndex.isDisplayed() && CustomerAccIndex.isEnabled())
            {
                HelpersMethod.ClickBut(driver, CustomerAccIndex, 10000);
                exists = true;
                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]"))));
                new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]")));
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void ValidateCustomerAccountPopup()
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
        //Assert.assertEquals(modalContentTitle.getText(), "Customer account index", "Verify Title message");
        if(modalContentTitle.getText().equals("Customer account index"))
        {
            exists=true;
        }
        else
        {
            exists=false;
        }
    }

    public void SelectCustomerAccount()
    {
        exists = false;
        WebElement WebEle;
        String AccNo = TestBase.testEnvironment.get_Account();
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath",    "//div[contains(@class,'k-window k-dialog')]");
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            // code to click on Addfilter button
            WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
            HelpersMethod.ActClick(driver, AddFilterButton, 40000);
            Thread.sleep(1000);

            //Identify the dialog popup
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-shown')]")));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-shown')]")));

            //Enter customer account# in input box
            WebElement modelContainer1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-shown')]");
            WebElement Search1 =modelContainer1.findElement(By.xpath(".//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.ActSendKey(driver, Search1, 10000, "Customer account #");

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

//            //Click on Check box
//            Thread.sleep(1000);
            //Identify the dialog popup
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-shown')]"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-shown')]")));

            WebElement WebEle1 = modelContainer1.findElement(By.xpath(".//input[@id='formattedValue']"));
            HelpersMethod.JScriptClick(driver, WebEle1, 10000);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Identify radio button and click on Radio button
            //Thread.sleep(1000);
            //Identify the dialog popup
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-shown')]"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-shown')]")));

            WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-child-animation-container']/div[@class='k-popup']");
            WebElement searchBox1= RadioPop.findElement(By.xpath(".//input[contains(@class,'k-input-solid')]"));
            HelpersMethod.EnterText(driver,searchBox1,20000,AccNo);

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                //Click on Apply button
                WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button/span[text()='Apply']"));
                HelpersMethod.ActClick(driver, ApplyButton, 20000);

                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-no-data']", driver))
            {
                scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
            }
            else
            {
                WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 10000);

                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists = true;
                //String Acc = TestBase.testEnvironment.get_Account();
                scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + AccNo);
            }
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_NewCompetitorButton()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(NewCompetitor.isDisplayed() && NewCompetitor.isEnabled())
            {
                HelpersMethod.JScriptClick(driver, NewCompetitor, 10000);
                scenario.log("NEW COMPETITOR BUTTON HAS BEEN CLICKED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateNewCompetitorPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Add new competitor')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                //Identifying Competitor code input box
                code= RandomValues.generateRandomAlphaNumeric(4);
                WebEle=HelpersMethod.FindByElement(driver,"id","competitorCode");
                HelpersMethod.EnterText(driver,WebEle,10000,code);
                scenario.log("CODE ENTERED IS "+code);

                //Identifying description input box
                desc=RandomValues.generateRandomAlphaNumeric(4);
                WebEle=HelpersMethod.FindByElement(driver,"id","competitorDescription");
                HelpersMethod.EnterText(driver,WebEle,10000,desc);
                scenario.log("DESCRIPTION ENTERED IS "+desc);

                //Identifying Add button
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Add']");
                HelpersMethod.ActClick(driver,WebEle,10000);

                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists=true;
            }
            else
            {
                scenario.log("ADD NEW COMPETITOR POPUP IS NOT VISIBLE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SourceTextArea(String Sourcetext)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,SourceText,10000,Sourcetext);
            exists= true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CommentTextArea(String Commenttext)
    {
        exists=false;
        try
        {
            if(CommentText.isDisplayed())
            {
                HelpersMethod.EnterText(driver, CommentText, 10000, Commenttext);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectProdCatalogPopup()
    {
        exists=true;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Product index')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                for(int i=0;i<=2;i++)
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]["+i+"]");
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                }
                //Click on OK button
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::.//button/span[text()='OK']");
                HelpersMethod.ClickBut(driver,WebEle,10000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_SaveButton()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("card1"))));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("card1")));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.elementToBeClickable(By.id("card1")));

            if(SaveBut.isDisplayed() && SaveBut.isEnabled())
            {
                HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.ClickBut(driver, SaveBut, 10000);

                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                Thread.sleep(1000);
                if (HelpersMethod.IsExists("//span[contains(text(),'Save competitive')]/ancestor::div[@class='k-window k-dialog']", driver))
                {
                   wait = new FluentWait<>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement moduleContainer1=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Save competitive')]/ancestor::div[@class='k-window k-dialog']");
                    WebEle = moduleContainer1.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver, WebEle, 20000);
                    exists = true;
                    scenario.log("COMPETITOR PRICING HAS BEEN SAVED SUCCESSFULLY");

                    wait = new FluentWait<>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    wait = new FluentWait<>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_CompetitorDropdown()
    {
        exists=false;
        Actions act= new Actions(driver);
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            scenario.log("VALUE TO BE SELECTED FROM COMPETITOR: "+code);
            act.moveToElement(CompetitorDropdown).click().build().perform();
            // HelpersMethod.DropDownMenu(driver,code);
            //WebElement menuContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-list-container')]/descendant::ul/li/span");
            List<WebElement> Values = HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li/span");
            for (WebElement Val : Values)
            {
                act.moveToElement(Val).build().perform();
                String Val_Text = Val.getText();
                if (Val_Text.contains(code))
                {
                    act.moveToElement(Val).build().perform();
                    act.click(Val).build().perform();
                    scenario.log("COMPETITOR VALUE SELECTED IS "+code);
                    exists = true;
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    break;
                }
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("card1"))));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("card1")));
        }
        catch (Exception e){}
    }

    public void Click_Plus()
    {
        exists=false;
        try
        {
            if(PlusBut.isDisplayed() && PlusBut.isEnabled())
            {
                HelpersMethod.ClickBut(driver, PlusBut, 10000);
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Validate_ProductIndex()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]", 10000);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Product index", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void selectProductsForCompetitorPricing()
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String pro;
        int j=0;
        List <WebElement> Products=null;
        try
        {
            Thread.sleep(4000);
            // List<String> Prods= DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
            if(HelpersMethod.IsExists("//span[contains(text(),'Product index')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement productIndex = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                for(int i=0;i<=4;i++)
                {
                    WebEle=productIndex.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]["+(i+1)+"]"));
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                }
                WebEle=productIndex.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,WebEle,10000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //Read all the products # added to customer inq
                List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
                for (WebElement tablehead:tableHeads)
                {
                    j++;
                    act.moveToElement(tablehead).build().perform();
                    String headText=tablehead.getText();
                    if(headText.equals("Product #"))
                    {
                        Products=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td["+(j+1)+"]");
                        break;
                    }
                }
                for (WebElement prods:Products)
                {
                    act.moveToElement(prods).build().perform();
                    pro=prods.getText();
                    scenario.log("PRODUCT NUMBERS IN GRID "+pro);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void searchProductInCatalogDialogBox()
    {
        exists=false;
        Actions act=new Actions(driver);
        String headText;
        int i=0;
        try
        {
            List<WebElement> filterHeaders=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::span[contains(@class,'k-column-title')]");
            for(WebElement filterHead:filterHeaders)
            {
                i++;
                act.moveToElement(filterHead).build().perform();
                headText=filterHead.getText();
                if(headText.equals("Product #"))
                {
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);

            exists=false;
            //Enter product# in input box
            WebElement productInput=HelpersMethod.FindByElement(driver,"xpath","//th["+i+"]/descendant::div[@class='k-filtercell-wrapper']/input");
            HelpersMethod.EnterText(driver,productInput,10000,Prod1);
            //Verify whether product found in catalog dialog box
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row k-state-selected')]",driver))
            {
                  scenario.log("DUPLICATE PRODUCT HAS BEEN FOUND IN COMPETITOR PRICING");
                  exists=true;
            }
            //close catalog index dialogbox
            WebElement okButton=HelpersMethod.FindByElement(driver,"xpth","//div[contains(@class,'k-window k-dialog')]/descendant::.//button/span[text()='Continue']");
            HelpersMethod.ActClick(driver,okButton,10000);

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Selecting_SoldByUOM_Selecting_BaseUOM()
    {
        exists = false;
        WebElement WebEle;
        List<WebElement> UOMValues;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='grid-container']");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Selecting value for Sold by UOM
            for (int i = 1; i <= 5; i++)
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]["+i+"]/descendant::td[contains(@class,'preferred-cell')][1]");
                HelpersMethod.ActClick(driver, WebEle, 10000);
                UOMValues = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::ul/li");
                HelpersMethod.ActClick(driver, UOMValues.get(0), 10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
            //Selecting value for Base UOM
            exists=false;
            for(int i=1;i<=5;i++)
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+i+"]/descendant::td[contains(@class,'preferred-cell')][2]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                UOMValues=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::ul/li");
                HelpersMethod.ActClick(driver,UOMValues.get(0),10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void EnteringCompetitorPricingComment(List<List<String>> prod_detail)
    {
        exists=false;
        WebElement WebEle;
        try
        {
            for(int i=1;i<=5;i++)
            {
                //Code for entering competitor pricing
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+i+"]/descendant::td/descendant::input[@class='k-input-inner']");
                HelpersMethod.ActClearKey(driver,WebEle,10000);
                HelpersMethod.ActSendKey(driver,WebEle,10000, prod_detail.get(i).get(0));
                //Code for entering Comment in Competitor pricing
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+i+"]/descendant::td/descendant::input[@class='k-textbox']");
                HelpersMethod.EnterText(driver,WebEle,10000,prod_detail.get(i).get(1));
                exists=true;

                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("card1"))));
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("card1")));
            }
            Thread.sleep(1000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_CheckBox()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Thread.sleep(2000);
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='i-grid']"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='i-grid']")));

            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]")));
            Thread.sleep(2000);

            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]");
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 20000);
                scenario.log("1ST PRODUCT IS DELETED FROM COMPETITIVE PRICING");
                exists=true;

                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            else
            {
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_DeleteProd()
    {
        exists=false;
        try
        {
           if(DeleteBut.isDisplayed()&&DeleteBut.isEnabled())
           {
               HelpersMethod.ClickBut(driver, DeleteBut, 10000);
               Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                       .withTimeout(Duration.ofSeconds(600))
                       .pollingEvery(Duration.ofSeconds(2))
                       .ignoring(NoSuchElementException.class);
               wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

               exists = true;
           }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_DeleteCompetitorRecord()
    {
        exists=false;
        WebElement WebEle;
        try
        {
           if(DeleteCompetitorData.isDisplayed() && DeleteCompetitorData.isEnabled())
           {
               HelpersMethod.ClickBut(driver, DeleteCompetitorData, 10000);
               Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                       .withTimeout(Duration.ofSeconds(600))
                       .pollingEvery(Duration.ofSeconds(2))
                       .ignoring(NoSuchElementException.class);
               wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

               if (HelpersMethod.IsExists("//span[contains(text(),'Delete competitor data')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
               {
                   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Delete competitor data')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                   WebElement deleteButton=WebEle.findElement(By.xpath(".//button/span[text()='Delete']"));
                   HelpersMethod.ActClick(driver, deleteButton, 10000);
                   wait = new FluentWait<>(driver)
                           .withTimeout(Duration.ofSeconds(600))
                           .pollingEvery(Duration.ofSeconds(2))
                           .ignoring(NoSuchElementException.class);
                   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
               }
               wait = new FluentWait<>(driver)
                       .withTimeout(Duration.ofSeconds(600))
                       .pollingEvery(Duration.ofSeconds(2))
                       .ignoring(NoSuchElementException.class);
               wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
               if (HelpersMethod.IsExists("//span[contains(text(),'Delete competitor data')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
               {
                   WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                   WebEle = modelContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                   HelpersMethod.ActClick(driver, WebEle, 10000);
                   scenario.log("DELETE COMPETITOR PRICING IS SUCCESSFUL");
                   wait = new FluentWait<>(driver)
                           .withTimeout(Duration.ofSeconds(600))
                           .pollingEvery(Duration.ofSeconds(2))
                           .ignoring(NoSuchElementException.class);
                   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
               }
           }
        }
        catch (Exception e){}
    }

    public void SearchForProd()
    {
        Actions act=new Actions(driver);
        exists=false;
        String Prod=null;
        int i=0;
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for (WebElement tablehead:tableHeads)
            {
                i++;
                act.moveToElement(tablehead).build().perform();
                String headText=tablehead.getText();
                if(headText.equals("Product #"))
                {
                    Prod=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::td["+(i+1)+"]").getText();
                    break;
                }
            }
            //Click on Add filter button
            WebElement addFilter=HelpersMethod.FindByElement(driver,"xpath","//button/descendant::span[contains(text(),'Add filter')]");
            HelpersMethod.ClickBut(driver,addFilter,10000);

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-shown')]",80000);
            WebElement modalContainer1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-shown')]");

            WebElement Search1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.ActSendKey(driver,Search1,10000,"Product #");
            //Click on Check box
            //new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[contains(@class,'k-checkbox')]")));
            WebElement WebEle1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
            HelpersMethod.ClickBut(driver,WebEle1,10000);

            //Identify radio button and click on Radio button
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
            if(HelpersMethod.IsExists("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]",driver))
            {
                WebElement RadioPop=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
                WebElement Search2=RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                HelpersMethod.EnterText(driver,Search2,10000,Prod);
                scenario.log("PRODUCT SEARCHED FOR IN CATALOG IS "+Prod);

                //Click on Apply button
                WebElement Clear =RadioPop.findElement(By.xpath(".//button/span[text()='Apply']"));
                HelpersMethod.ClickBut(driver,Clear,10000);

                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }

            if(HelpersMethod.IsExists("//div[@class='i-no-data']",driver))
            {
                scenario.log("NO PRODUCT HAS BEEN FOUND");
                exists=false;
            }
            else
            {
                scenario.log(Prod+" HAS BEEN FOUND IN THE GRID");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchForProdSearchBar()
    {
        Actions act=new Actions(driver);
        exists=false;
        String Prod=null;
        int i=0;
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for (WebElement tablehead:tableHeads)
            {
                i++;
                act.moveToElement(tablehead).build().perform();
                String headText=tablehead.getText();
                if(headText.equals("Product #"))
                {
                    Prod=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::td["+(i+1)+"]").getText();
                    break;
                }
            }
            HelpersMethod.EnterText(driver,SearchBar,10000,Prod);
            HelpersMethod.ClickBut(driver,SearchIndex,10000);
            if(HelpersMethod.IsExists("//div[@class='i-no-data']",driver))
            {
                exists=false;
                scenario.log("NO PRODUCT HAS BEEN FOUND");
            }
            else
            {
                exists=true;
                scenario.log(Prod+" HAS BEEN FOUND IN THE GRID");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readFirstProductInGrid()
    {
        Actions act=new Actions(driver);
        exists=false;
        int i=0;
        try
        {
            List<WebElement> tableHeads = HelpersMethod.FindByElements(driver, "xpath", "//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for (WebElement tablehead : tableHeads)
            {
                i++;
                act.moveToElement(tablehead).build().perform();
                String headText = tablehead.getText();
                if (headText.equals("Product #"))
                {
                    Prod1 = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td["+i+"]").getText();
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void Click_LoadExistingData()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(LoadexistingData.isDisplayed() && LoadexistingData.isEnabled())
            {
                HelpersMethod.ClickBut(driver, LoadexistingData, 10000);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Validate_LoadExistingDataPopUp()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'Load existing data')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchCustomerDetails()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::input[@id='SearchBox1']");
            HelpersMethod.EnterText(driver,WebEle,10000,TestBase.testEnvironment.get_Account());
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
            HelpersMethod.ClickBut(driver,WebEle,10000);
            exists=true;
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectCompetitorDetails()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("card1"))));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("card1")));

            if(!HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-no-data__icon']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::input[@id='SearchBox1']");
                HelpersMethod.sendKeys(driver,WebEle,10000,code);
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                exists=true;

                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if(HelpersMethod.IsExists("//span[text()='Discard pending changes']/ancestor::div[@class='k-window k-dialog']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::button/span[text()='Discard']");
                    HelpersMethod.ActClick(driver,WebEle,10000);
                    wait = new FluentWait<>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("card1"))));
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("card1")));
            }
            else
            {
                scenario.log("<span style='color:red'>NO DATA HAS BEEN FOUND</span>");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DetailsOfProducts()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='grid-container']"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid-container']")));

            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='grid-container']");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Reading product# from the grid
            List<WebElement> Products=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[2]");
            for(WebElement Prod:Products)
            {
                String Prod_No=Prod.getText();
                scenario.log("PRODUCT FOUND IN: "+Prod_No);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnLoadAllProducts()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
           {
               WebElement loadProd=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
               HelpersMethod.ActClick(driver,loadProd,10000);

               wait = new FluentWait<WebDriver>(driver)
                       .withTimeout(Duration.ofSeconds(600))
                       .pollingEvery(Duration.ofSeconds(2))
                       .ignoring(NoSuchElementException.class);
               wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
           }
        }
        catch (Exception e){}
    }
}