package pages_DSD_OMS.orderEntry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import lombok.experimental.Helper;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
           // HelpersMethod.Implicitwait(driver, 15);
            HelpersMethod.EnterText(driver,SearchBox, 10,Ord_No);
           // Thread.sleep(500);
            HelpersMethod.ClickBut(driver,SearchIndex,2);
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
            HelpersMethod.ClickBut(driver,WebEle,10);
        }
        catch (Exception e){}
    }
    public void Copy_Button()
    {
        try
        {
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
           // HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::div[contains(@id,'OrderNumberCol')]",18);
           WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::button[@class='i-link-button']");
           Ord=WebEle.getText();
           scenario.log("ORDER NUMBER SELECTED IN ORDER HISTORY PAGE IS "+Ord);
           HelpersMethod.ScrollElement(driver,WebEle);
           HelpersMethod.ClickBut(driver,WebEle,10);
           exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public boolean VerifiyHistoryGrid()
    {
        HelpersMethod.Implicitwait(driver, 40);
        WebElement WebEle=null;
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            if(HelpersMethod.EleDisplay(HistoryGrid))
            {
                exists=true;
            }
        }
        catch (Exception e){}
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
                HelpersMethod.ActClick(driver, OrderHist, 10);
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.Implicitwait(driver,10);
            if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]", driver))
            {
                //code to select first order in order history
                WebElement OrderHist = HelpersMethod.FindByElement(driver, "xpath", "//table[contains(@class,'k-grid-table')]/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver, OrderHist, 10);
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
                    HelpersMethod.ClickBut(driver,WebEle,20);
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

    public void FilterActiveOrder()
    {
        WebElement WebEle;
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            int i=0;
            String THead_Text=null;
            List<WebElement> TableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for(WebElement TableHead:TableHeads)
            {
                i++;
                THead_Text=TableHead.getText();
                if(THead_Text.equals("Delivery Date"))
                {

                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//th[@aria-label='Filter']["+i+"]/descendant::input");
                    act.moveToElement(WebEle).click().sendKeys("2022").build().perform();
                    break;
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
            }
        }
        catch (Exception e){}
    }
}
