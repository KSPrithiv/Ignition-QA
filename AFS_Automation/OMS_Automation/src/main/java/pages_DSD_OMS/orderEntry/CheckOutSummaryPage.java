package pages_DSD_OMS.orderEntry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public String Find_TotalAmt()
    {
        String Tot=null;
        try
        {
            Tot= HelpersMethod.ReadValue(TotAmt);
        }
        catch (Exception e){}
        return  Tot;
    }

    public void ClickSubmit() throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        String status=null;
        status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'new-order-number')]");
            HelpersMethod.ScrollElement(driver,WebEle);

            HelpersMethod.ScrollUpScrollBar(driver);
            WebElement submitButton=HelpersMethod.FindByElement(driver,"id","ConfirmSummaryButton");
            HelpersMethod.ActClick(driver,submitButton,100000);
            exists=true;
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
        }
            if(HelpersMethod.IsExists("//div[contains(@class,'question-dialog-body')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement dialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement continueBut=dialogBox.findElement(By.xpath(".//button[contains(text(),'Continue')]"));
                HelpersMethod.ClickBut(driver,continueBut,2000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
            }
            scenario.log("SUBMIT BUTTON IN ORDER SUMMARY PAGE HAS BEEN CLICKED");
            Assert.assertEquals(exists,true);
    }

    public void SucessPopup()
    {
        exists=false;
        WebElement WebEle=null;
        String status=null;

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(text(),'Order submitted successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",6000);
            // to fetch the web element of the modal container
            WebElement modalContainer =HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentText = modalContainer.findElement(By.xpath(".//div[contains(@class,'question-dialog-body')]"));
            Assert.assertEquals(modalContentText.getText(), "Order submitted successfully.", "Verify content message");
            //Click on OK button in "Success popup"
            new WebDriverWait(driver, Duration.ofMillis(100000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()='Ok']")));
            WebElement OK_But = modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
            HelpersMethod.ClickBut(driver,OK_But,800);
            exists=true;
            scenario.log("ORDER HAS BEEN SUCESSFULLY CREATED");
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
    }

    public void SucessPopupForAllOrder()
    {
        exists=false;
        WebElement WebEle=null;
        String status=null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500000);
        }

        // to fetch the web element of the modal container
        WebElement modalContainer =HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentText = modalContainer.findElement(By.xpath(".//div[contains(@class,'question-dialog-body')]"));
        Assert.assertEquals(modalContentText.getText(), "Order submitted successfully.", "Verify content message");
        //Click on OK button in "Success popup"
        WebElement OK_But = modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
        HelpersMethod.ClickBut(driver,OK_But,8000);
        exists=true;
        scenario.log("ORDER HAS BEEN SUCESSFULLY CREATED");
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
        }
    }

    public String Get_Order_No()
    {
        WebElement WebEle=null;
        try
        {
            //To zoom out browser by 67%
         /*   if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.body.style.zoom='67%'");
            }
            else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='67%'");
            }*/
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'order-number-item-container')]");
            HelpersMethod.ScrollElement(driver,WebEle);
            Order_No = HelpersMethod.ReadValue(Ord);
            scenario.log("ORDER CRATED, ORDER # IS "+Order_No);
            //To zoom in browser by 100%
          /*  if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.body.style.zoom='100%'");
            }
            else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='100%'");
            }*/
        }
        catch (Exception e){}
        return Order_No;
    }

    public String Get_Quote_No()
    {
        WebElement WebEle=null;
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
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500000);
        }

        //new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.textToBePresentInElementLocated(By.id("EditButton"),"Edit"));
        try
        {
            if (Edit_But.isDisplayed() && Edit_But.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,Edit_But);
                HelpersMethod.ActClick(driver,Edit_But,100);
            }
        }
        catch (Exception e){}
    }
    public void Click_copy()
    {
        try
        {
            exists = HelpersMethod.IsEnabledByele(CopyBut);
            if (exists == true)
            {
                HelpersMethod.ClickBut(driver,CopyBut,100);
            }
        }
        catch (Exception e) {}
    }
    public void CommentBut()
    {
        exists=false;
        try
        {
            exists=HelpersMethod.IsEnabledByele(Comment_But);
            if(exists==true)
            {
                HelpersMethod.ClickBut(driver,Comment_But,100);
                scenario.log("COMMENT BUTTON HAS BEEN CLICKED");
            }
        }
        catch (Exception e) {}
    }
    //handling 'Comment' popup for order and for product
    public void Comment_Popup(String Comment)
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Comments']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                driver.findElement(By.id("textAreaA")).sendKeys(Comment);
                scenario.log("COMMENT ENTERED IS "+Comment);

                //Click on Add button in the popup
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Add']");
                HelpersMethod.ClickBut(driver,WebEle,100);

                //Click on OK button
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,WebEle,100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
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
            HelpersMethod.ScrollElement(driver,CancelBut);
            HelpersMethod.JScriptClick(driver,CancelBut,2000);
            exists=true;
            scenario.log("CANCEL ORDER BUTTON HAS BEEN CLICKED");
            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Cancel order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
            Assert.assertEquals(exists,true);
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
                HelpersMethod.ClickBut(driver,WebEle,200);
                exists=true;
                scenario.log("CANCEL ORDER POPUP HAS BEEN HANDLED");
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 6000);
            }
            Assert.assertEquals(exists,true);
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
            HelpersMethod.ActClick(driver,Button_Close,100);
            WebElement ProdNo=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Product #']");
            HelpersMethod.ActClick(driver,ProdNo,100);
            WebElement Sort=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-icon k-i-sort')]");
            HelpersMethod.ActClick(driver,Sort,100);
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
            //Collections.sort(Pro_Sort,Collections.reverseOrder());
            Collections.sort(Pro_Sort);
            //Comparing the sorted order with list of products
            Assert.assertEquals(Pro_List,Pro_Sort);
        }
        catch(Exception e){}
    }

    public void ClickOnAllOrder()
    {
        exists=false;
        WebElement WebEle=null;
        String status=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        HelpersMethod.Implicitwait(driver,40);
        WebEle=HelpersMethod.FindByElement(driver,"id","OpenOrdersButton_sbc");
        try
        {
            if(WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ActClick(driver, WebEle, 10);
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                if(WebEle.isDisplayed())
                {
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
                HelpersMethod.ActClick(driver,WebEle,20);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            Assert.assertEquals(exists,true);
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
                HelpersMethod.ClickBut(driver, PrintBut, 10);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows) {
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        HelpersMethod.Implicitwait(driver, 10);
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
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void BackToOrderList()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,BackOrder,40);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
            }
            HelpersMethod.WaitElementPresent(driver,"id","order-search-card",400);
            Assert.assertEquals(exists,true);
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
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PickupOrderValidate()
    {
        exists=false;
        try
        {
            HelpersMethod.ScrollElement(driver,Comment_But);
            if(HelpersMethod.IsExists("//div[contains(text(),'Pick up order')]//following-sibling::div[text()='Yes']",driver))
            {
                scenario.log("PICKUP ORDER HAS BEEN SET AS YES");
                exists=true;
            }
            Assert.assertEquals(exists,true);
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
                HelpersMethod.ClickBut(driver,BackOrder,100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
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
            Assert.assertEquals(exists,true);
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
            Assert.assertEquals(exists,true);
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
                HelpersMethod.ClickBut(driver,okButton,100);
            }
        }
        catch (Exception e){}
    }
}
