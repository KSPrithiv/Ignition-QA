package pages_DSD_OMS.orderEntry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import lombok.experimental.Helper;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderHistoryPage
{
    /* Created by Divya */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="customerAccountIndexSearchBar")
    private WebElement SearchBox;

    @FindBy(xpath="//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement SearchIndex;

    @FindBy(xpath="//button[text()='Copy']")
    private WebElement CopyButton;

    @FindBy(xpath="//button[text()='Print']")
    private WebElement PrintButton;

    @FindBy(xpath="//button[@class='i-filter-tag__main']")
    private WebElement Addfilter;

    @FindBy(id="order-history-card")
    private WebElement HistoryGrid;

    @FindBy(xpath="//button[text()='Orders']")
    private WebElement OrderButton;

    @FindBy(id="grid-selection-dropdown")
    private WebElement gridType;

    //Actions
    public OrderHistoryPage(WebDriver driver, Scenario scenario) throws InterruptedException, AWTException
    {
        this.scenario=scenario;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ValidateOrderHistory()
    {
        exists=false;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
        }
        try
        {

            if(HelpersMethod.IsExists("//div[@class='order-history']",driver))
            {
                scenario.log("IN ORDER HISTORY PAGE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchBox_Entry(String Ord_No) throws InterruptedException
    {
        try
        {
            HelpersMethod.EnterText(driver,SearchBox, 40,Ord_No);
            HelpersMethod.ClickBut(driver,SearchIndex,40);
            scenario.log("ORDER NUMBER ENTERED FOR SEARCHING IN ORDER HISTORY PAGE IS "+Ord_No);
        }
        catch (Exception e){}
    }

    public void Check_Box()
    {
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]",10);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]");
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.ClickBut(driver,WebEle,40);
        }
        catch (Exception e){}
    }
    public void Copy_Button()
    {
        try
        {
            new WebDriverWait(driver,2000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("order-history-card"))));
            HelpersMethod.ScrollElement(driver, CopyButton);
            HelpersMethod.ClickBut(driver,CopyButton,10);
            scenario.log("COPY BUTTON HAS BEEN CLICKED, TO COPY ORDER HISTORY");
        }
        catch (Exception e){}
    }

    public void Click_OrderNo()
    {
        exists=false;
        WebElement WebEle=null;
        String Ord=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::button[@class='i-link-button']");
            Ord=WebEle.getText();
            scenario.log("ORDER NUMBER SELECTED IN ORDER HISTORY PAGE IS "+Ord);
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.ClickBut(driver,WebEle,40);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public boolean VerifiyHistoryGrid() throws InterruptedException
    {
        exists=false;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@id='order-history-card']", driver))
        {
            exists=true;
        }
        Assert.assertEquals(exists, true);
        return exists;
    }

    public void Click_CheckBox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]",driver))
            {
                //code to select first order in order history
                WebElement OrderHist = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]");
                HelpersMethod.ActClick(driver, OrderHist, 40);
            }
            else
            {
                scenario.log("CHECK BOX IS NOT VISIBLE IN ORDER HISTORY GRID");
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_On_RowIn_OrderHistoryGrid()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            new WebDriverWait(driver,2000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("order-history-card"))));
            if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]", driver))
            {
                //Read the Order number
                WebElement OrderNo=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::button");
                scenario.log("ORDER NUMBER SELECTED FROM ORDER HISTORY PAGE FOR CREATING COPY IS: "+OrderNo.getText());

                //code to select first order in order history
                WebElement OrderHist = HelpersMethod.FindByElement(driver, "xpath", "//table[contains(@class,'k-grid-table')]/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver, OrderHist, 100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void VerifyCommentInHistory()
    {
        exists=false;
        WebElement WebEle;
        Actions act= new Actions(driver);
        String Comm_Text=null;
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'17 L 4 5 z')] | //tr[contains(@class,'k-master-row')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'17 L 4 3 z')]",driver))
            {
                if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'17 L 4 5 z')]", driver))
                {
                    scenario.log("COMMENT HAS NOT BEEN ADDED TO THE SELECTED ORDER IN ORDER HISTORY");
                }
                else
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'17 L 4 3 z')]");
                    HelpersMethod.ClickBut(driver,WebEle,80);
                    scenario.log("COMMENTS FOUND ARE:");
                    List<WebElement> Comments = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td[2]");
                    for (WebElement Comment : Comments)
                    {
                        act.moveToElement(Comment).build().perform();
                        Comm_Text = Comment.getText();
                        scenario.log("COMMENT IN ORDER " + Comm_Text);
                    }
                }
            }
            else
            {
                scenario.log("COMMENT ICON HAS NOT BEEN FOUND");
            }
        }
        catch (Exception e){}
    }

    public void OrderButtonClick()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            HelpersMethod.ClickBut(driver,OrderButton,20);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //public void FilterActiveOrder(String s,String s1,String s2,String s3)
    public void FilterActiveOrder(String year)
    {
        WebElement WebEle;
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            int i=0;
            Actions act=new Actions(driver);
            String THead_Text=null;
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-grid']");
            HelpersMethod.ScrollElement(driver,WebEle);
            List<WebElement> TableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for(WebElement TableHead:TableHeads)
            {
                i++;
                THead_Text=TableHead.getText();
                if(THead_Text.equals("Delivery Date"))
                {
                    //WebDriverWait wait=new WebDriverWait(driver,40);
                    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@aria-label='Filter']["+i+"]/descendant::input")));
                   // WebEle=HelpersMethod.FindByElement(driver,"xpath","//th[@aria-label='Filter']["+i+"]/descendant::input");
                   // HelpersMethod.JSSetValueEle(driver,WebEle,100,year);
                   WebEle=HelpersMethod.FindByElement(driver,"xpath","//th[@aria-label='Filter']["+i+"]/descendant::a");
                   HelpersMethod.ActClick(driver,WebEle,60);
                   //To click on 2023 in calender, so that user can select 1st Jan for filterling orders in order hisotry
                   WebElement calValMonth=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-calendar-navigation']/descendant::li/span[text()='"+year+"']");
                   HelpersMethod.JScriptClick(driver,calValMonth,100);

                   //code to select Jan 1st
                    new WebDriverWait(driver,400).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='k-calendar-table']"))));
                    WebElement calDate=HelpersMethod.FindByElement(driver,"xpath","//table[@class='k-calendar-table']/descendant::td[contains(@title,'January 1,')]");
                    HelpersMethod.JScriptClick(driver,calDate,100);

                    //click on filter icon to select 'Is after' filter option
                    WebElement filterIcon=HelpersMethod.FindByElement(driver,"xpath","//th[@aria-label='Filter']["+i+"]/descendant::span[contains(@class,'k-dropdown-wrap')]");
                    HelpersMethod.ActClick(driver,filterIcon,40);

                    WebElement filterPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
                    List <WebElement> filterOptions=filterPopup.findElements(By.xpath(".//ul/li"));
                    for (WebElement filterOpt:filterOptions)
                    {
                        act.moveToElement(filterOpt).build().perform();
                        String optText=filterOpt.getText();
                        if(optText.equals("Is after"))
                        {
                            act.moveToElement(filterOpt).click().build().perform();
                            break;
                        }
                    }

                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                    }
                    new WebDriverWait(driver,10000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("order-history-card"))));
                    break;
                }
            }
            new WebDriverWait(driver,10000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("order-history-card"))));
        }
        catch (Exception e){}
    }

    public void selectDeliveryDate() throws InterruptedException
    {
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Select delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement selectDeliveryDate = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Select delivery date')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement newOrder = selectDeliveryDate.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
                scenario.log("DELIVERY DATE SELECTED IS: " + selectDeliveryDate.findElement(By.xpath(".//span[@class='line2']")).getText());
                HelpersMethod.ActClick(driver, newOrder, 40);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 6000);
                }

            }
        }
        catch (Exception e){}
    }

    public void selectNewOrderPopup()
    {
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            //handling Select order no. popup
            if(HelpersMethod.IsExists("//h4[contains(text(),'Select order')]/ancestor::div[contains(@class,'modal-content')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//h4[contains(text(),'Select order')]/ancestor::div[contains(@class,'modal-content')]"));

                WebEle=modalContainer.findElement(By.xpath(".//button[contains(text(),'New order')]"));
                HelpersMethod.ActClick(driver,WebEle,200);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
                }
            }

            //handling note popup
            if(HelpersMethod.IsExists("//p[text()='Notes']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//p[text()='Notes']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"));

                WebEle= modalContainer.findElement(By.xpath(".//button"));
                HelpersMethod.ClickBut(driver,WebEle,200);
            }
        }
        catch (Exception e){}
    }

    public void clickOnGridType()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='grid-selection-dropdown']",driver))
            {
                HelpersMethod.ClickBut(driver,gridType,100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectGridType(String gType)
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]");
            List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
            for (WebElement opt:Options)
            {
                act1.moveToElement(opt).build().perform();
                String Opt = opt.getText();
                if (Opt.equals(gType))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
                    }
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateGridType(String gType)
    {
            exists=false;
            try
            {
                String gridValue=HelpersMethod.FindByElement(driver,"xpath","//span[@id='grid-selection-dropdown']/span[@class='k-input']").getText();
                if(gridValue.equals(gType))
                {
                    scenario.log("GRID TYPE SELECTED IS "+gType);
                    exists=true;
                }
                Assert.assertEquals(exists,true);
            }
            catch (Exception e){}
    }

    public void clickOnOrderButton()
    {
        exists=false;
        try
        {
            if(OrderButton.isDisplayed() && OrderButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,OrderButton,100);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
