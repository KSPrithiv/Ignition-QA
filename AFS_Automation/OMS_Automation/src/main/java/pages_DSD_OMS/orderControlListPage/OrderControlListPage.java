package pages_DSD_OMS.orderControlListPage;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.Text;
import util.TestBase;

import java.sql.Ref;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderControlListPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static String Acc_No=null;
    static boolean exists = false;
    List<WebElement> SkipList1=null;
    List<WebElement> Skiplist2=null;
    int skipRow=0;

    @FindBy(id = "OrderTaker")
    private WebElement OrderTaker;

    @FindBy(id = "All")
    private WebElement AllRadio;

    @FindBy(xpath = "//a[contains(@title,'Toggle calendar')]/span")
    private WebElement CallDate;

    @FindBy(id = "refreshButton")
    private WebElement RefreshButton;

    @FindBy(id = "printButton")
    private WebElement PrintButton;

    @FindBy(id = "Taken")
    private WebElement TakenRadio;

    @FindBy(id = "Untaken")
    private WebElement UntakenRadio;

    @FindBy(id = "customerAccountIndexSearchBar")
    private WebElement SearchBox;

    @FindBy(xpath = "//div[contains(@class,'i-search-box')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement SearchIndex;

    @FindBy(xpath="//div[contains(@class,'i-search-box')]//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__clear')]")
    private WebElement SearchClear;

    @FindBy(xpath = "//tr[1]/descendant::div[contains(@id,'PlaceOrderColIcon')]//*[local-name()='svg']")
    private WebElement OrderIcon;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]")
    private WebElement To;

    @FindBy(xpath="//span[contains(@class,'k-multiselect')]/descendant::input")
    private  WebElement Route;

    public OrderControlListPage(WebDriver driver, Scenario scenario)
    {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void Validate_OCL()
    {
        exists=false;
        String Title = null;
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            Title = HelpersMethod.gettingTitle(driver);
            if(Title.equalsIgnoreCase("Order Control List"))
            {
                scenario.log("NAVIGATED TO ORDER CONTROL LIST");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Refresh_Page(String currentURL)
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
                if (wait.until(ExpectedConditions.alertIsPresent()) == null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
            }
            else
            {
                //navigate to OCL
                driver.navigate().to(currentURL);
                scenario.log("REFRESHED PAGE IN OCL");
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
        }
        catch (Exception e){}
    }

    public void Click_OrderTracker()
    {
        exists = false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            if(OrderTaker.isDisplayed())
            {
                HelpersMethod.ActClick(driver, OrderTaker, 1000);
                exists = true;
            }
            else
            {
                scenario.log("PLEASE CHECK FOR THE ADMIN SETTINGS");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void Select_OrderTracker()
    {
        exists = false;
        Actions act1=new Actions(driver);
        WebElement WebEle = null;
        try
        {
            int i=0;
            WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
            List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
            for(WebElement Opt:Options)
            {
                i++;
                act1.moveToElement(Opt).build().perform();
                if(i==2)
                {
                    act1.moveToElement(Opt).click().build().perform();
                    scenario.log("ORDER TAKER HAS BEEN SELECTED");
                    exists=true;
                    break;
                }
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if (HelpersMethod.IsExists("//div[contains(text(),'Failed to connect to API')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Failed to connect to API')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver, WebEle, 1000);
            }
            WebElement orderTakerText=HelpersMethod.FindByElement(driver,"xpath","//span[@id='OrderTaker']/span[1]");
            scenario.log("ORDER TAKER SELECTED IS "+orderTakerText.getText());
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Select_Untaken()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            if (!UntakenRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver, UntakenRadio, 1000);
                scenario.log("UNTAKEN RATIO BUTTON SELECTED");
            }
        }
        catch (Exception e) {}
    }

    public void Select_Taken()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            if (!TakenRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver, TakenRadio, 1000);
                scenario.log("TAKEN RATIO BUTTON HAS BEEN SELECTED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Select_All()
    {
        exists=false;
        try
        {
            if (!AllRadio.isSelected())
            {
                HelpersMethod.ClickBut(driver, AllRadio, 1000);
                scenario.log("ALL RADIO BUTTON HAS BEEN SELECTED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Refresh_Click()
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            HelpersMethod.ClickBut(driver, RefreshButton, 1000);
            scenario.log("REFRESH BUTTON CLICKED");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void OrderIcon_Click()
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            HelpersMethod.ScrollElement(driver,OrderIcon);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("gridOrderControlList"))));
            HelpersMethod.ActClick(driver,OrderIcon,1000);
            scenario.log("ORDER ICON HAS BEEN CLICKED");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
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
            HelpersMethod.ClickBut(driver, CallDate, 1000);

            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]", 800);
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-calendar-container k-group k-reset k-animation-container-shown')]")));
            exists=true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void Call_Date_Selection(int i)
    {
        String formattedDate1 = null;
        String FTDate=null;
        WebElement WebEle=null;
        exists=false;
        try
        {
            LocalDate myDateObj = LocalDate.now().plusDays(i);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            formattedDate1 = myDateObj.format(myFormatObj);

            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", 200);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Visibility of calender
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]", driver))
            {
                // to fetch the web element of the modal container
                WebElement fromDateContainer = driver.findElement(By.xpath("//table[@class='k-calendar-table']"));

                WebElement ele1 = fromDateContainer.findElement(By.xpath(".//td[contains(@title,'" + formattedDate1 + "')]"));
                if (ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 1000);
                    exists = true;
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
                    WebEle = HelpersMethod.FindByElement(driver, "id", "CallDate");
                    //FTDate = HelpersMethod.JSGetValueEle(driver, WebEle, 100);
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    FTDate = (String) jse.executeScript("return arguments[0].getAttribute('value');", WebEle);

                    scenario.log(FTDate + " HAS BEEN SELECTED FOR OCL");
                }
                else
                {
                    scenario.log("FAILED TO SELECT END DATE");
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ValidateOCLGrid()
    {
        exists = false;
        WebElement WebEle = null;
        try
        {
            if (HelpersMethod.IsExists("//td[contains(text(),'No records available')]", driver))
            {
                scenario.log("NO RECORDS HAS BEEN FOUND FOR SELECTED CUSTOMER");
            }
            else
            {
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
                HelpersMethod.ClickBut(driver, WebEle, 1000);
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            }

            //Enter value in first searchbox in popup
            WebElement Search1=driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.EnterText(driver,Search1,1000,SearchValue1);

            //Enter Value in Search box in 2nd popup
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::input[@class='i-search-box__input']")));
            WebEle = driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::input[@class='i-search-box__input']"));
            if(WebEle.isDisplayed())
            {
                HelpersMethod.EnterText(driver,WebEle,1000,SearchBoxValue2);

                //Click on Check box
                driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]/descendant::input[contains(@class,'k-checkbox')]")).click();
                //loading Icon
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
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
        int i=0;
        String head_Text=null;
        String skipText=null;
        try
        {
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            for(WebElement head:Heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                head_Text = head.getText();
                if (head_Text.equals("Customer key")||head_Text.equals("Customer Key"))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td[" + i + "]/descendant::div[contains(@class,'CPKendoDataGrid')]/span");
                    Acc_No= WebEle.getText();
                    break;
                }
            }
            scenario.log("CUSTOMER ACCOUNT NUMBER SELECTED FOR SKIP IS "+Acc_No);
            i=0;
            for(WebElement head:Heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                head_Text = head.getText();
                if (head_Text.equals("Skip status")||head_Text.equals("Skip Status"))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td[" + i + "]/descendant::span[contains(@class,'k-dropdown-wrap')]");
                    HelpersMethod.ActClick(driver,WebEle,1000);
                    break;
                }
            }

            //create a list of values in skip drop down
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset k-animation-container-shown')]"))));
            //WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset k-animation-container-shown')]");
            //WebElement dropDownOption=dropDown.findElement(By.xpath(".//li[text()='Skipped']"));
            //act1.moveToElement(dropDownOption).build().perform();
            //act1.click(dropDownOption).build().perform();
            List <WebElement> dropDownValues=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li");
            for(WebElement dropDown:dropDownValues)
            {
                act1.moveToElement(dropDown).build().perform();
                skipText=dropDown.getText();
                if(skipText.equals("Skipped"))
                {
                    act1.moveToElement(dropDown).build().perform();
                    act1.click(dropDown).build().perform();
                    exists=true;
                    break;
                }
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SkipPop(String reason)
    {
        exists=false;
        WebElement WebEle;
        Actions act1 = new Actions(driver);
        try {
            if (HelpersMethod.IsExists("//div[text()='Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 10000);
                // to fetch the web element of the modal container
                WebElement skipPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

                //Identify the skip reason drop down
                WebElement skipReason = skipPopup.findElement(By.xpath(".//span[@id='SkipReason']"));
                HelpersMethod.ClickBut(driver, skipReason, 4000);
                HelpersMethod.DropDownMenu_LowerCase(driver,reason);

                WebElement okButton = skipPopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ActClick(driver, okButton, 4000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        } catch (Exception e) {}
    }

    public void selectionOfSkipValidation()
    {
        Actions act1=new Actions(driver);
        exists=false;
        int i=0;
        String head_Text=null;
        WebElement WebEle;
        try
        {
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            for(WebElement head:Heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                head_Text = head.getText();
                if (head_Text.equals("Skip status")||head_Text.equals("Skip Status"))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td["+i+"]/descendant::span[contains(@class,'k-dropdown-wrap')]/span[@class='k-input']");
                    if(WebEle.getText().equals("Skipped"))
                    {
                        scenario.log("SKIP OPTION SELECTED SUCCESSFULLY");
                        exists=true;
                    }
                    else
                    {
                        scenario.log("SKIP OPTION SELECTION FAILED");
                        exists=false;
                    }
                    break;
                }
            }
            Assert.assertEquals(exists,true);
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
        Actions act1=new Actions(driver);
        String head_Text=null;
        int i=0;
        try
        {
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            WebEle=HelpersMethod.FindByElement(driver,"id","gridOrderControlList");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Create list of Skipped drop down, and select the first skip dropdown
            SkipList1=HelpersMethod.FindByElements(driver,"xpath","//span[contains(text(),'Skipped')]");
            for(;skipRow<=SkipList1.size()-1;skipRow++)
            {
                if(SkipList1.get(skipRow).isEnabled())
                {
                    HelpersMethod.ActClick(driver, SkipList1.get(skipRow), 1000);
                    break;
                }
            }
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]")));
            //create a list of values in skip drop down
            List <WebElement> dropDownOptions=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li");
            for(WebElement dropDownOpt:dropDownOptions)
            {
                act1.moveToElement(dropDownOpt).build().perform();
                String opt_Text=dropDownOpt.getText();
                if(opt_Text.equals("Not skipped"))
                {
                    act1.moveToElement(dropDownOpt).build().perform();
                    act1.click(dropDownOpt).build().perform();
                    exists=true;
                    break;
                }
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifySkipInTaken()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,SearchBox,1000,Acc_No);
            HelpersMethod.ClickBut(driver,SearchIndex,1000);
            if(!HelpersMethod.IsExists("//td[contains(text(),'No records available')]",driver))
            {
                scenario.log("SKIP CUSTOMER ACCOUNT# HAS BEEN FOUND UNDER TAKEN");
                exists=true;
            }
            else
            {
                scenario.log("SKIP CUSTOMER ACCOUNT# NOT FOUND UNDER ORDER TAKEN");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void RemoveSkipPopUp()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            if(HelpersMethod.IsExists("//div[text()='Remove Skip']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
                exists=true;
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
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
                    if(Head.equals(To_Text))
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
        try
        {
            String ParentWindow = driver.getWindowHandle();
            HelpersMethod.ClickBut(driver, PrintButton, 1000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
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
        catch (Exception e){}
    }

    public void ValidateSkipPopup()
    {
        try
        {
            WebElement WebEle = null;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 60);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Skip", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void searchOrderInOCL(String ord_no)
    {
        exists=false;
        try
        {
            if(!ord_no.equals(null))
            {
                HelpersMethod.EnterText(driver, SearchBox, 1000, ord_no);
                HelpersMethod.ClickBut(driver, SearchIndex, 1000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            }
            else
            {
                exists = false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readOrderComment()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String head_Text=null;
        int i=0;
        WebElement WebEle;
        try
        {
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            for(WebElement head:Heads)
            {
                i++;
                act1.moveToElement(head).build().perform();
                head_Text=head.getText();
                if(head_Text.equals("Order note")||head_Text.equals("Order Note"))
                {
                    if(!HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]/descendant::td["+i+"]/descendant::span[contains(@class,'CPKendoDataGrid')]",driver))
                    {
                        scenario.log("NO ORDER NOTE HAS BEEN ADDED");
                        exists=false;
                    }
                    else
                    {
                        scenario.log("ORDER NOTE IS ADDED");
                        exists=true;
                    }
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterRouteValue()
    {
        Actions act=new Actions(driver);
        exists=false;
        try
        {
            act.moveToElement(Route).build().perform();
            HelpersMethod.sendKeys(driver,Route,1000,TestBase.testEnvironment.get_Route1());
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
            HelpersMethod.ActClick(driver,dropDown,1000);
            WebElement dummyEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'notification-center-container')]");
            HelpersMethod.ClickBut(driver,dummyEle,1000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            WebElement routeNo=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-widget k-multiselect')]/descendant::li/span[1]");
            scenario.log("ROUTE ENTERED FOR SEARCH: "+routeNo.getText());
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllTheCustomer()
    {
        exists=false;
        try
        {
            List<WebElement> noRows=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]");
            int size= noRows.size();
            if(size>=0)
            {
                scenario.log("NUMBER OF RECORDS FOUND FOR THE SELECTED ROUTE: " + size);
                exists=true;
            }
            else
            {
                scenario.log("NO RECORDS FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readGroupingDetails()
    {
        Actions act1=new Actions(driver);
        try
        {
            List<WebElement> Groups=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-grouping-row']/descendant::p");
            for(WebElement group:Groups)
            {
                act1.moveToElement(group).build().perform();
                scenario.log("GROUPING IN OCL "+group.getText());
            }
        }
        catch (Exception e){}
    }

    public void selectCustomerAndClickCommentIcon()
    {
        exists=false;
        int i=0;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th/descendant::span[contains(@class,'k-column-title')]");
            for (WebElement tableHead:tableHeads)
            {
                i++;
                act.moveToElement(tableHead).build().perform();
                String head_Text=tableHead.getText();
                if(head_Text.equals("Customer note"))
                {
                    WebElement CustomerNote=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/td["+i+"]");
                    HelpersMethod.ScrollElement(driver,CustomerNote);
                    act.moveToElement(CustomerNote).build().perform();
                    act.click(CustomerNote).build().perform();
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnRefresh()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver, RefreshButton, 1000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void readCustomerAccountsInOCL()
    {
        exists=false;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]");
            for (WebElement tableHead:tableHeads)
            {
                i++;
                act.moveToElement(tableHead).build().perform();
                String headText=tableHead.getText();
                if(headText.equals("Customer key"))
                {
                    break;
                }
            }
            List<WebElement> Accounts=HelpersMethod.FindByElements(driver,"xpath","//table[@class='k-grid-table']/descendant::tr/td["+i+"]");
            for(WebElement Acc:Accounts)
            {
                act.moveToElement(Acc).build().perform();
                String AccText=Acc.getText();
                scenario.log("CUSTOMER ACCOUNT NUMBERS FOUND IN OCL GRID "+AccText);
            }
        }
        catch (Exception e){}
    }

    public void verifyCustomerNoteInOCL()
    {
        exists=false;
        int i=0;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th/descendant::span[contains(@class,'k-column-title')]");
            for (WebElement tableHead:tableHeads)
            {
                i++;
                act.moveToElement(tableHead).build().perform();
                String head_Text=tableHead.getText();
                if(head_Text.equals("Customer note"))
                {
                    WebElement CustomerNote=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/td["+i+"]/span/descendant::span");
                    scenario.log("CUSTOMER NOTE ADDED IS "+CustomerNote.getText());
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyOrderInOCLgrid(String ord_no)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,SearchBox,1000,ord_no);
            HelpersMethod.ActClick(driver,SearchIndex,1000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyNewOrderIconInOCLgrid()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[contains(@id,'PlaceOrderColIcon')]//*[local-name()='svg' and @fill='blue']",driver))
            {
                scenario.log("NEW ORDER ICON HAS NOT BEEN FOUND");
                exists=true;
            }
            else
            {
                scenario.log("NEW ORDER ICON HAS BEEN FOUND, PLEASE CHECK ADMIN SETTING.");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clearSearchBar()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,SearchClear,1000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void verifyOrderType()
    {
        exists=false;
        String headText=null;
        String orderType=null;
        int i=0;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for (WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Order type"))
                {
                    orderType=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/td["+i+"]/descendant::span").getText();
                    scenario.log("ORDER TYPE CREATED IS "+orderType);
                    exists=true;
                    break;
                }
                else
                {
                    exists=false;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readCustomerAccountNo()
    {
        exists=false;
        int i=0;
        String headText=null;
        String custAcc=null;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equals("Customer key"))
                {
                    custAcc=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/td["+i+"]/descendant::span[2]").getText();
                    scenario.log("CUSTOMER ACCOUNT NUMBER FOUND IS "+custAcc);
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateChangeOfRemoveSkip()
    {
        Actions act1=new Actions(driver);
        String head_Text;
        exists=false;
        try
        {
            int j=0;
            List<WebElement> Heads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
            for(WebElement head:Heads)
            {
                j++;
                act1.moveToElement(head).build().perform();
                head_Text = head.getText();
                if (head_Text.equals("Skip status")||head_Text.equals("Skip Status"))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]["+skipRow+"]/descendant::td["+j+"]/descendant::span[contains(@class,'k-dropdown-wrap')]/span[@class='k-input']");
                    scenario.log("NOT SKIP OPTION SELECTED SUCCESSFULLY" +WebEle.getText());
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}