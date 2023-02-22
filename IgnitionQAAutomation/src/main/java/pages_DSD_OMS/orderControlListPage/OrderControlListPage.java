package pages_DSD_OMS.orderControlListPage;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.apache.maven.plugin.lifecycle.Execution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.Set;


/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderControlListPage {
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static String Acc_No=null;
    static boolean exists = false;
    List<WebElement> SkipList1=null;
    List<WebElement> Skiplist2=null;


    @FindBy(id = "OrderTaker")
    private WebElement OrderTaker;

    @FindBy(id = "All")
    private WebElement AllRadio;

    @FindBy(xpath = "//label[@id='CallDate-label']/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]")
    private WebElement CallDate;

    @FindBy(id = "refreshButton")
    private WebElement RefreshButton;

    @FindBy(id = "printButton")
    private WebElement PrintButton;

    @FindBy(id = "Taken")
    private WebElement TakenRadio;

    @FindBy(id = "Untaken")
    private WebElement UntakenRadio;

    @FindBy(xpath = "//div[contains(@class,'i-search-box')]/descendant::input")
    private WebElement SearchBox;

    @FindBy(xpath = "//div[contains(@class,'i-search-box')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement SearchIndex;

    @FindBy(xpath = "//tr[1]/descendant::div[contains(@id,'PlaceOrderColIcon')]//*[local-name()='svg']")
    private WebElement OrderIcon;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]")
    private WebElement To;

    public OrderControlListPage(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void Validate_OCL()
    {
        String Title = null;
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
        }
        try
        {
            Title = HelpersMethod.gettingTitle(driver);
            Assert.assertEquals(Title, "Ignition - Order Control List");
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500);
            }
        }
        catch (Exception e) {}
    }

    public void Click_OrderTracker()
    {
        exists = false;
        try
        {
            HelpersMethod.ClickBut(driver, OrderTaker, 60);
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Select_OrderTracker() {
        exists = false;
        WebElement WebEle = null;
        try {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-common-dropdown__type-none k-animation-container-shown')]/descendant::li[2]");
            HelpersMethod.ClickBut(driver, WebEle, 10);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            if (HelpersMethod.IsExists("//div[contains(text(),'Failed to connect to API')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Failed to connect to API')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver, WebEle, 10);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Select_Untaken()
    {
        exists = false;
        try
        {
            if (!UntakenRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver, UntakenRadio, 80);
            }
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Select_Taken()
    {
        exists = false;
        try
        {
            if (!TakenRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver, TakenRadio, 80);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Select_All()
    {
        exists = false;
        try
        {
            if (!AllRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver, AllRadio, 10);
            }
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Refresh_Click()
    {
        exists = false;
        WebElement WebEle = null;
        try {
            HelpersMethod.ClickBut(driver, RefreshButton, 10);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void OrderIcon_Click()
    {
        exists = false;
        WebElement WebEle = null;
        try {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            HelpersMethod.ActClick(driver, OrderIcon, 80);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Call_Date_Click()
    {
        exists = false;
        try
        {
            HelpersMethod.ClickBut(driver, CallDate, 10);
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }


    public void Call_Date_Selection(int i)
    {
        WebElement WebEle = null;
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-calendar-view k-calendar-monthview')]", 6);
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            String ele = "//div[contains(@class,'k-calendar-view k-calendar-monthview')]";
            boolean visible = HelpersMethod.IsExists(ele, driver);
            if (visible == true)
            {
                LocalDate myDateObj = LocalDate.now().plusDays(i);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-view k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.JSScroll(driver, ele1);
                HelpersMethod.ActClick(driver, ele1, 2);
                scenario.log(formattedDate1 + " HAS BEEN SELECTED AS END DATE FOR OCL");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            else
            {
                scenario.log("CALENDER DROP DOWN DOESN'T EXISTS");
            }
        }
        catch (Exception e) {}
    }

    public void ValidateOCLGrid()
    {
        exists = false;
        WebElement WebEle = null;
        try {
            if (HelpersMethod.IsExists("//td[contains(text(),'No records available')]", driver)) {
                scenario.log("NO RECORDS HAS BEEN FOUND FOR SELECTED CUSTOMER");
            } else {
                scenario.log("SOME DETAILS HAS BEEN FOUND");
            }
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void AddFilterOCL(String SearchValue1,String SearchBoxValue2)
    {
        exists=false;
        WebElement WebEle=null;
        WebDriverWait wait=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-filter-toolbar']/descendant::button/descendant::span[contains(text(),'Add filter')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='i-filter-toolbar']/descendant::button/descendant::span[contains(text(),'Add filter')]");
                HelpersMethod.ClickBut(driver, WebEle, 10);
            }

            //Click on Clear all button
            WebElement Clear=driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::button[contains(text(),'Clear all')]"));
            if(Clear.isEnabled()==true)
            {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::button[contains(text(),'Clear all')]")));
                driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::button[contains(text(),'Clear all')]")).click();
                //loading Icon
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
                }
            }

            //Enter value in first searchbox in popup
            WebElement Search1=driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.EnterText(driver,Search1,4,SearchValue1);
            //Thread.sleep(1000);//500

            //Enter Value in Search box in 2nd popup
            WebEle = driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::input[@class='i-search-box__input']"));
            if(WebEle.isDisplayed())
            {
                HelpersMethod.EnterText(driver,WebEle,2,SearchBoxValue2);

                //Click on Check box
                driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::input[contains(@class,'k-checkbox')]")).click();
                //loading Icon
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
        }
        catch (Exception e){}
    }

    public void Skip_NotSkip()
    {
        exists=false;
        WebElement WebEle=null;
        Actions act1=new Actions(driver);
        try
        {
            //Read the customer Account number from the grid for which skip will be enabled
            Acc_No=HelpersMethod.FindByElement(driver,"xpath","//table[contains(@class,'k-grid-table')]/descendant::tr[1]/td[1]/descendant::div/span").getText();
            //Click on Skip drop down
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//table[contains(@class,'k-grid-table')]/descendant::tr[1]/descendant::span[contains(@class,'SkipOrderText')]/span[@class='k-dropdown-wrap']");
            HelpersMethod.ClickBut(driver,WebEle,80);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-up-enter k-slide-up-enter-active')]",100);

            //create a list of values in skip drop down
            HelpersMethod.DropDownMenu(driver,"Skipped");
            exists=true;

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SkipPop(String reason)
    {
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[text()='Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",200);
                // to fetch the web element of the modal container
                WebElement skipPopup = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = skipPopup.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Skip", "Verify Title message");

                //Identify the skip reason drop down
                WebEle=skipPopup.findElement(By.xpath(".//span[@id='SkipReason']"));
                HelpersMethod.ClickBut(driver,WebEle,20);
                HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-up-enter k-slide-up-enter-active')]",200);
                HelpersMethod.DropDownMenu(driver,reason);
            }
        }
        catch (Exception e){}
    }

    public void ValidateSkip()
    {
        try
        {
            Skiplist2=HelpersMethod.FindByElements(driver,"xpath","//span[contains(text(),'Not skipped')]");
            Assert.assertNotEquals(SkipList1.size(),Skiplist2.size());
        }
        catch (Exception e){}
    }

    public void Skip()
    {
        exists=true;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","gridOrderControlList");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Create list of Skipped drop down, and select the first skip dropdown
            SkipList1=HelpersMethod.FindByElements(driver,"xpath","//span[contains(text(),'Skipped')]");
            int i=0;
            for(WebElement Skip:SkipList1)
            {
                i++;
                if(Skip.isEnabled())
                {
                    HelpersMethod.ClickBut(driver, SkipList1.get(i), 10);
                    break;
                }
            }
            exists=true;
            //create a list of values in skip drop down
            HelpersMethod.DropDownMenu(driver,"Not skipped");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifySkipInTaken()
    {
        try
        {
            HelpersMethod.EnterText(driver,SearchBox,50,Acc_No);
            HelpersMethod.ClickBut(driver,SearchIndex,50);
            if(!HelpersMethod.IsExists("//td[contains(text(),'No records available')]",driver))
            {
                scenario.log("SKIP CUSTOMER ACCOUNT# HAS BEEN FOUND UNDER TAKEN");
            }
            else
            {
                scenario.log("SKIP CUSTOMER ACCOUNT# NOT FOUND UNDER ORDER TAKEN");
            }
        }
        catch (Exception e){}
    }



    public void RemoveSkipPopUp()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Remove Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,WebEle,10);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateNotSkip()
    {
        try
        {
            Skiplist2=HelpersMethod.FindByElements(driver,"xpath","//span[contains(text(),'Skipped')]");
            Assert.assertNotEquals(SkipList1.size(),Skiplist2.size());
        }
        catch (Exception e){}
    }

    public void DragDropHeader(String To_Text)
    {
        exists=false;
        try
        {
            WebElement OCLProdGrid=HelpersMethod.FindByElement(driver,"id","gridOrderControlList");
            HelpersMethod.ScrollElement(driver,OCLProdGrid);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]",driver))
            {
                List<WebElement> TableHeads=driver.findElements(By.xpath("//thead/tr[1]/th"));
                for(WebElement THead:TableHeads)
                {
                    String Head=THead.getText();
                    if(Head.contains(To_Text))
                    {
                        HelpersMethod.ActDragDrop(driver,THead,To);
                        exists=true;
                    }
                }
            }
            else
            {
                scenario.log("DRAG AND DROP HEADER MAY NOT BE ENABLED, CHECK ADMIN SETTINGS");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnPrintButton()
    {
        String ParentWindow = driver.getWindowHandle();
        HelpersMethod.ClickBut(driver,PrintButton,400);
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }

        Set<String> PCWindows = driver.getWindowHandles();
        for (String PCwind : PCWindows)
        {
            if (!PCwind.equals(ParentWindow))
            {
                driver.switchTo().window(PCwind);
                scenario.log(".pdf HAS BEEN FOUND");
                driver.close();
                exists = true;
                scenario.log("PRINT BUTTON IN OCL HAS BEEN HANDLED");
            }
        }
        driver.switchTo().window(ParentWindow);
    }
}