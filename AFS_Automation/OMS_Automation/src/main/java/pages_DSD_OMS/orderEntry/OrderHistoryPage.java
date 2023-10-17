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
import java.time.Duration;
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
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
            HelpersMethod.EnterText(driver,SearchBox, 1000,Ord_No);
            HelpersMethod.ClickBut(driver,SearchIndex,1000);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]",10);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]");
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.ClickBut(driver,WebEle,1000);
        }
        catch (Exception e){}
    }
    public void Copy_Button()
    {
        try
        {
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("order-history-card"))));
            HelpersMethod.ScrollElement(driver, CopyButton);
            HelpersMethod.ClickBut(driver,CopyButton,1000);
            scenario.log("COPY BUTTON HAS BEEN CLICKED, TO COPY ORDER HISTORY");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
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
            HelpersMethod.ClickBut(driver,WebEle,1000);
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
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
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
                HelpersMethod.ActClick(driver, OrderHist, 1000);
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
        Actions act1=new Actions(driver);
        WebElement statu;
        String statusText=null;
        exists=false;
        int i=0;
        try
        {
          //creating list of 'status' column value to find active order and to neglect skip and cancel orders
          List<WebElement> status=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::span[contains(@class,'status-cell')]");
            for(WebElement sta:status)
            {
              i++;
              act1.moveToElement(sta).build().perform();
              statusText=sta.getText();
              if(statusText.equalsIgnoreCase("ACTIVE"))
              {
                  //Read the Order number
                  WebElement OrderNo=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+i+"]/descendant::button");
                  scenario.log("ORDER NUMBER SELECTED FROM ORDER HISTORY PAGE FOR CREATING COPY IS: "+OrderNo.getText());

                  //code to select first order in order history
                  WebElement OrderHist = HelpersMethod.FindByElement(driver, "xpath", "//table[contains(@class,'k-grid-table')]/descendant::tr[contains(@class,'k-master-row')]["+i+"]");
                  act1.moveToElement(OrderHist).build().perform();
                  act1.click().build().perform();
                  exists=true;
                  break;
              }
          }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
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
                    HelpersMethod.ClickBut(driver,WebEle,1000);
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
            HelpersMethod.ClickBut(driver,OrderButton,1000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //public void FilterActiveOrder(String s,String s1,String s2,String s3)
    public void FilterActiveOrder()
    {
        WebElement WebEle;
        exists=false;
        try
        {
            int i=0;
            Actions act=new Actions(driver);
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-grid']");
            HelpersMethod.ScrollElement(driver,WebEle);
            WebElement headTitle=HelpersMethod.FindByElement(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title' and contains(text(),'Delivery Date')]");
            act.moveToElement(headTitle).click().build().perform();
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            act.moveToElement(headTitle).click().build().perform();
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            Assert.assertEquals(exists,true);
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
                HelpersMethod.ActClick(driver, newOrder, 1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            //handling Select order no. popup
            if(HelpersMethod.IsExists("//h4[contains(text(),'Select order')]/ancestor::div[contains(@class,'modal-content')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//h4[contains(text(),'Select order')]/ancestor::div[contains(@class,'modal-content')]"));

                WebEle=modalContainer.findElement(By.xpath(".//button[contains(text(),'New order')]"));
                HelpersMethod.ActClick(driver,WebEle,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
            }

            //handling note popup
            if(HelpersMethod.IsExists("//p[text()='Notes']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//p[text()='Notes']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"));

                WebEle= modalContainer.findElement(By.xpath(".//button"));
                HelpersMethod.ClickBut(driver,WebEle,1000);
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
                HelpersMethod.ClickBut(driver,gridType,1000);
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
        WebElement opt;
        try
        {
            List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li");
            for (int i=0;i<=Options.size()-1;i++)
            {
                opt=Options.get(i);
                if(i==1)
                {
                    act1.moveToElement(opt).build().perform();
                        act1.moveToElement(opt).build().perform();
                        act1.click(opt).build().perform();
                        exists = true;
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
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
                if(!gridValue.equals(""))
                {
                    scenario.log("GRID TYPE SELECTED IS "+gridValue);
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
                HelpersMethod.ClickBut(driver,OrderButton,1000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_On_OrderNumber()
    {
        exists=false;
        try
        {
            //Read the Order number
            WebElement OrderNo=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::button");
            scenario.log("ORDER NUMBER SELECTED FROM ORDER HISTORY PAGE FOR CREATING COPY IS: "+OrderNo.getText());

            HelpersMethod.ClickBut(driver,OrderNo,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
        }
        catch (Exception e){}
    }
}
