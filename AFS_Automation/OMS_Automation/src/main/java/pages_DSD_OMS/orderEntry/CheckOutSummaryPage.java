package pages_DSD_OMS.orderEntry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import util.TestBase;

import java.awt.*;
import java.time.Duration;
import java.util.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CheckOutSummaryPage
{
    /* Created by Divya */
    WebDriver driver;
    Scenario scenario;
    static String Order_No=null;
    static String Quote_No=null;
    static boolean exists=false;

    @FindBy(id = "ConfirmSummaryButton")
    private WebElement Submit_But;

    @FindBy(id="CancelSummaryButton")
    private WebElement Cancel_But;

    @FindBy(id="OrdersButton")
    private  WebElement BackOrder;

    @FindBy(id="CommentsButton")
    private WebElement Comment_But;

    @FindBy(id="EditButton")
    private WebElement Edit_But;

    @FindBy(id="PrintButton")
    private  WebElement PrintBut;

    @FindBy(id="CopyOrderButton_sbc")
    private WebElement CopyBut;

    @FindBy(xpath = "//div[contains(@class,'order-number-item-container')]/descendant::div[@class='item-value']")
    private  WebElement Ord;

    @FindBy(xpath = "//div[contains(text(),'Product total')]/following-sibling::div")
    private  WebElement TotAmt;

    @FindBy(id="CancelSummaryButton")
    private WebElement CancelBut;

    @FindBy(xpath = "//div[contains(@class,'k-indicator-container')]/descendant::a[contains(@class,'k-button')]")
    private WebElement Button_Close;

    public CheckOutSummaryPage(WebDriver driver,Scenario scenario) throws InterruptedException, AWTException
    {
        this.scenario=scenario;
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void validateSummaryPage()
    {
        exists=false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(@class,'checkout-summary-content')]",driver))
            {
                scenario.log("ORDER ENTRY SUMMARY PAGE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String Find_TotalAmt()
    {
        String Tot=null;
        try
        {
            HelpersMethod.ScrollElement(driver,TotAmt);
            Tot= HelpersMethod.ReadValue(TotAmt);
            scenario.log("TOTAL ORDER AMOUNT IS "+Tot);
        }
        catch (Exception e){}
        return  Tot;
    }

    public void ClickSubmit() throws InterruptedException
    {
        exists=false;
        Wait<WebDriver> wait;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        //HelpersMethod.ScrollUpScrollBar(driver);
        HelpersMethod.ScrollUpScrollBar(driver);

        if(HelpersMethod.IsExists("//button[@id='ConfirmSummaryButton']",driver))
        {
            WebElement submitButton = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='ConfirmSummaryButton']");
            HelpersMethod.ScrollUpScrollBar(driver);
            HelpersMethod.ClickBut(driver, submitButton, 20000);
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            exists=true;
        }
        else if(HelpersMethod.IsExists("//button[@id='ConfirmSummarySplitButton']",driver))
        {
            //Click on Arrow button next to submit button
            WebElement submitCutOff=HelpersMethod.FindByElement(driver,"xpath","//button[@id='ConfirmSummarySplitButton']/following-sibling::div/button/span");
            HelpersMethod.ActClick(driver,submitCutOff,20000);
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]/descendant::ul/li")));
            //Click on list that appears
            WebElement arrowCutoff=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]/descendant::ul/li");
            HelpersMethod.ActClick(driver,arrowCutoff,10000);
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            exists=true;
        }
        scenario.log("SUBMIT BUTTON IN ORDER SUMMARY PAGE HAS BEEN CLICKED");
        Assert.assertEquals(exists,true);
    }

    public void additionalOrderPopup()
    {
        try
        {
            Thread.sleep(2000);

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(text(),'Additional order(s) have been found')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement additionalPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Additional order(s) have been found')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement yesButton=additionalPopup.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ClickBut(driver,yesButton,1000);
            }
        }
        catch (Exception e){}
    }

    public void cutoffDialog()
    {
        try
        {
            //Thread.sleep(2000);
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            for(int i=0;i<=2;i++)
            {
                if (HelpersMethod.IsExists("//div[contains(text(),'Attention: Although the cutoff time has been reached')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    exists = false;
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Continue']"))));
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Continue']"))));

                    WebElement dialogBox = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement continueBut = dialogBox.findElement(By.xpath(".//button[contains(text(),'Continue')]"));
                    HelpersMethod.ActClick(driver, continueBut, 10000);
                    scenario.log("ORDER CUTOFF DIALOG BOX HAS BEEN HANDLED");
                    wait = new FluentWait<>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order for the given products:')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement percentagePopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'% of your average order for the given products:')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement continueButton = percentagePopup.findElement(By.xpath(".//button[text()='Continue']"));
                    HelpersMethod.ActClick(driver, continueButton, 2000);
                    scenario.log("% POPUP HAS BEEN HANDLED");

                    wait = new FluentWait<>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
        }
        catch (Exception e){}
    }

    public void SucessPopup()
    {
        String status;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            if (HelpersMethod.IsExists("//div[contains(text(),'Order submitted successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                // to fetch the web element of the modal container
                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentText = modalContainer.findElement(By.xpath(".//div[contains(@class,'question-dialog-body')]"));
                Assert.assertEquals(modalContentText.getText(), "Order submitted successfully.", "Verify content message");
                //Click on OK button in "Success popup"
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()='Ok']")));
                WebElement OK_But = modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver, OK_But, 8000);
                exists = true;
                scenario.log("ORDER HAS BEEN SUCESSFULLY CREATED");
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
        }
        catch (Exception e){}
    }

    public void SucessPopupForAllOrder()
    {
        exists=false;
        WebElement WebEle;
        String status;
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

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        // to fetch the web element of the modal container
        WebElement modalContainer =HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        //WebElement modalContentText = modalContainer.findElement(By.xpath(".//div[contains(@class,'question-dialog-body')]"));
        //Assert.assertEquals(modalContentText.getText(), "Order submitted successfully.", "Verify content message");
        //Click on OK button in "Success popup"
        WebElement OK_But = modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
        HelpersMethod.ClickBut(driver,OK_But,10000);
        exists=true;
        scenario.log("ORDER HAS BEEN SUCESSFULLY CREATED");
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
    }

   public String Get_Order_No()
    {
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'order-number-item-container')]");
            HelpersMethod.ScrollElement(driver,WebEle);
            Order_No = HelpersMethod.ReadValue(Ord);
            scenario.log("ORDER CRATED, ORDER # IS "+Order_No);
        }
        catch (Exception e){}
        return Order_No;
    }

    public String Get_Quote_No()
    {
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'order-number-item-container')]");
            HelpersMethod.ScrollElement(driver,WebEle);
            Quote_No = HelpersMethod.ReadValue(Ord);
            scenario.log("QUOTE IS CRATED, QUOTE # IS "+Quote_No);
        }
        catch (Exception e){}
        return Quote_No;
    }

    public void Click_Edit()
    {
        exists=false;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            if (Edit_But.isDisplayed() && Edit_But.isEnabled())
            {
                Thread.sleep(1000);
                Edit_But=HelpersMethod.FindByElement(driver,"id","EditButton");
                HelpersMethod.ScrollElement(driver,Edit_But);
                HelpersMethod.ActClick(driver,Edit_But,4000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }
    public void Click_copy()
    {
        exists=false;
        try
        {
            Thread.sleep(1000);
            if (CopyBut.isEnabled())
            {
                HelpersMethod.ClickBut(driver,CopyBut,8000);
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e) {}
    }
    public void CommentBut()
    {
        exists=false;
        try
        {
            exists=HelpersMethod.IsEnabledByele(Comment_But);
            if(exists)
            {
                HelpersMethod.ClickBut(driver,Comment_But,1000);
                scenario.log("COMMENT BUTTON HAS BEEN CLICKED");
            }
        }
        catch (Exception e) {}
    }
    //handling 'Comment' popup for order and for product
    public void Comment_Popup(String Comment)
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Comments']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                driver.findElement(By.id("textAreaA")).sendKeys(Comment);
                scenario.log("COMMENT ENTERED IS "+Comment);

                //Click on Add button in the popup
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Add']");
                HelpersMethod.ClickBut(driver,WebEle,1000);

                //Click on OK button
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    //Find the no. rows in the summary grid and compare it with total no. of product
    public int Read_no_of_Product_Grid()
    {
        int count=0;
        try
        {
            count=driver.findElements(By.xpath("//table[@class='k-grid-table']/descendant::tr[contains(@class,'k-master-row')]")).size();
            scenario.log("NUMBER OF PRODUCTS FOUND IN SUMMARY PAGE "+ count);
        }
        catch (Exception e){}
        return count;
    }
    //Cancel Button in summary page
    public void Cancel_Button()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='ConfirmSummaryButton']//*[local-name()='svg']|//button[@id='ConfirmSummarySplitButton']//*[local-name()='svg']")));
            HelpersMethod.ScrollUpScrollBar(driver);
            if(HelpersMethod.IsExistsById("CancelSummaryButton",driver))
            {
                WebElement CancelBut = HelpersMethod.FindByElement(driver, "id", "CancelSummaryButton");
                if(CancelBut.isEnabled())
                {
                    HelpersMethod.ClickBut(driver, CancelBut, 10000);
                    exists = true;
                }
            }
            scenario.log("CANCEL ORDER BUTTON HAS BEEN CLICKED");
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void VerifyCancelPopUp()
    {
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Cancel order", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void CancelPop()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            //Check for the Cancel Order warning popup
            if (HelpersMethod.IsExists("//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement cancelPopup = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
                WebEle=cancelPopup.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ClickBut(driver,WebEle,1000);
                exists=true;
                scenario.log("CANCEL ORDER POPUP HAS BEEN HANDLED");
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }
    //Click on uparrow button next to Product# column in Order summary page
    public void Product_UpArrow()
    {
        int i=0;
        Actions act=new Actions(driver);
        try
        {
            HelpersMethod.ActClick(driver,Button_Close,1000);
            //To zoom out browser by 50%
            if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.body.style.zoom='50%'");
            }
            else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='50%'");
            }
            WebElement ProdNo=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Product #']");
            HelpersMethod.JScriptClick(driver,ProdNo,1000);

            WebElement Sort=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Product #']/following-sibling::span[contains(@class,'sort')]");
            //HelpersMethod.ActClick(driver,Sort,1000);
            act.moveToElement(Sort).doubleClick(Sort).build().perform();
            //find the column number for Product #
            List<WebElement> theads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for (WebElement head:theads)
            {
                i++;
                act.moveToElement(head).build().perform();
                String head_Text= head.getText();
                if(head_Text.equals("Product #"))
                {
                    break;
                }
            }

            //Creating list of webelements for Products in Order summary grid
            List<WebElement> Products=driver.findElements(By.xpath("//tr[contains(@class,'k-master-row')]/td["+i+"]/descendant::span[contains(@class,'CPKendoDataGrid-Label-rightmargin')]"));
            ArrayList<String> Pro_List=new ArrayList<>();
            for(WebElement Prod: Products)
            {
                Pro_List.add(Prod.getText());
            }
            //Creating sorted list of products in Summary grid
            ArrayList<String> Pro_Sort=new ArrayList<>(Pro_List);
            Collections.sort(Pro_Sort);
            //Comparing the sorted order with list of products
            if(Pro_Sort.equals(Pro_List))
            {
                scenario.log("PRODUCT NUMBERS ARE IN SORTED ORDER");
            }
            else
            {
                scenario.log("PRODUCT NUMBERS ARE NOT IN SORTED ORDER");
            }

            //To zoom out browser by 100%
            if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.body.style.zoom='100%'");
            }
            else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='100%'");
            }
        }
        catch(Exception e){}
    }

    public void ClickOnAllOrder()
    {
        exists=false;
        WebElement WebEle;
        String status=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        WebEle=HelpersMethod.FindByElement(driver,"id","OpenOrdersButton_sbc");
        try
        {
            if(WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ActClick(driver, WebEle, 1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                exists=true;
            }
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Your order has not been submitted.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Submit order')]");
                HelpersMethod.ActClick(driver,WebEle,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void PrintOE()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(PrintBut.isDisplayed() && PrintBut.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, PrintBut);
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, PrintBut, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        Thread.sleep(2000);
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        exists = true;
                        scenario.log("PRINT BUTTON FOR ALL ORDER HAS BEEN HANDLED");
                    }
                }
                driver.switchTo().window(ParentWindow);
            }
            else
            {
                scenario.log("PRINT BUTTON IS NOT ENABLED");
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void BackToOrderList()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,BackOrder,1000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            HelpersMethod.WaitElementPresent(driver,"id","order-search-card",2000);
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void ValidateSummaryOrderPage()
    {
        exists=false;
        try
        {
           if(HelpersMethod.IsExists("//div[@id='SummaryCard']",driver))
           {
               exists=true;
           }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void PickupOrderValidate()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            HelpersMethod.ScrollElement(driver,Comment_But);
            if(HelpersMethod.IsExists("//div[contains(text(),'Pick up order')]//following-sibling::div[text()='Yes']",driver))
            {
                scenario.log("PICKUP ORDER HAS BEEN SET AS YES");
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnBackToOrderList()
    {
        exists=false;
        try
        {
            if(BackOrder.isDisplayed() && BackOrder.isEnabled())
            {
                HelpersMethod.ClickBut(driver,BackOrder,1000);
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validateCommentPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                scenario.log("COMMENT POPUP HAS BEEN FOUND");
               exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void readComments()
    {
        exists=false;
        String com_Text;
        HashSet<String> comment_Text=new HashSet<>();
        List<String> comment_Text1 = new ArrayList<>();
        try
        {
            List<WebElement> comments=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::td[2]");
            for(WebElement comment:comments)
            {
                com_Text=comment.getText();
                comment_Text1.add(com_Text);
                comment_Text.add(com_Text);
            }
            if(comment_Text.size()==comment_Text1.size())
            {
                scenario.log("NO DUPLICATE COMMENT HAS BEEN FOUND");
                exists=true;
            }
            else
            {
                scenario.log("DUPLICATE COMMENT HAS BEEN FOUND");
                exists=false;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnOKCommentPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']",driver))
            {
                WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Comments')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,okButton,1000);
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void compareTotal()
    {
        exists=false;
        String TotalProd,TotGrid;
        try
        {
           // TotalProd=driver.findElement(By.xpath("//div[contains(text(),'Total lines')]/following-sibling::div")).getText();
            TotGrid=Integer.toString(Read_no_of_Product_Grid());
            //Assert.assertEquals(TotalProd,TotGrid);
        }
        catch (Exception e){}
    }

    public void totalProducts()
    {
        Read_no_of_Product_Grid();
    }

    public void clickOnAllOrder()
    {
        exists=false;
        String status=null;
        WebElement WebEle;
        try
        {
            WebElement allOrder=HelpersMethod.FindByElement(driver,"id","OpenOrdersButton_sbc");
            HelpersMethod.ClickBut(driver,allOrder,1000);
            scenario.log("ORDER HAS BEEN FOUND IN ORDER ENTRY ALSO");
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        }
        catch (Exception e){}
    }

    public boolean validateExistingOrderNotDisplayed()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Existing orders found')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement yesButton=modelContainer.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ActClick(driver,yesButton,10000);
                scenario.log("<span style='color:red'> ADMIN SETTING FOR EXISTING ORDER HAS BEEN DISABLED BUT STILL ABLE TO SEE THE DIALOG BOX </span>");
                exists=false;
            }
            else
            {
                scenario.log("ADMIN SETTING FOR EXISTING ORDER HAS BEEN ENABLED AND NO DIALOG BOX IS FOUND!!!");
                exists=true;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public boolean validateExistingOrderDisplayed()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Existing orders found')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement yesButton=modelContainer.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ActClick(driver,yesButton,10000);
                scenario.log(" ADMIN SETTING FOR EXISTING ORDER HAS BEEN ENABLED, ABLE TO SEE ORDER EXISTS DIALOG BOX </span>");
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'> ADMIN SETTING FOR EXISTING ORDER HAS BEEN ENABLED AND NO DIALOG BOX IS FOUND!!!</span>");
                exists=false;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public void  validateExistingOrderCancel()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(text(),'Existing orders found')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement cancelButton=modelContainer.findElement(By.xpath(".//button[text()='Cancel order']"));
                HelpersMethod.ActClick(driver,cancelButton,10000);
                scenario.log("ADMIN SETTING FOR EXISTING ORDER HAS BEEN ENABLED, AND CANCEL ORDER HAS BEEN SELECTED");
                exists=true;
            }
            else
            {
                scenario.log("CHECK FOR ADMIN SETTING, FOR EXISTING ORDER HAS BEEN ENABLED OR NOT AND NO DIALOG BOX IS FOUND!!!");
                exists=false;
            }
        }
        catch (Exception e){}
    }

    public void  validateExistingOrderNo()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(text(),'Existing orders found')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement noButton=modelContainer.findElement(By.xpath(".//button[text()='No']"));
                HelpersMethod.ActClick(driver,noButton,10000);
                scenario.log("ADMIN SETTING FOR EXISTING ORDER HAS BEEN ENABLED, AND NO HAS BEEN SELECTED");
                exists=true;
            }
            else
            {
                scenario.log("CHECK FOR ADMIN SETTING, FOR EXISTING ORDER HAS BEEN ENABLED OR NOT AND NO DIALOG BOX IS FOUND!!!");
                exists=false;
            }
        }
        catch (Exception e){}
    }

    public void percentageOfAverageProd()
    {
        try
        {
            WebElement WebEle;
            if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                Wait<WebDriver> wait  = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                //click on Continue button
                WebEle=modalContainer.findElement(By.xpath(".//button[text()='Continue']"));
                HelpersMethod.ActClick(driver,WebEle, 4000);
                scenario.log("% OF YOUR AVERAGE ORDER POPUP HAS BEEN HANDLED");

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void ClickSubmitOE()
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollUpScrollBar(driver);
            Thread.sleep(1000);
            if(HelpersMethod.IsExists("//button[@id='ConfirmSummarySplitButton']",driver))
            {
                WebElement submitButton=HelpersMethod.FindByElement(driver,"id","ConfirmSummarySplitButton");
                //HelpersMethod.ScrollElement(driver,submitButton);
                HelpersMethod.ClickBut(driver,submitButton,20000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
