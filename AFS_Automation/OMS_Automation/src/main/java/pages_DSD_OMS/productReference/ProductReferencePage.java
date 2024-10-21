package pages_DSD_OMS.productReference;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.TestBase;

import java.time.Duration;
import java.util.List;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
public class ProductReferencePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy (xpath="//div[@class='i-search-box']/descendant::input")
    private WebElement searchBox;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-grouping-drop-container')]")
    private WebElement To;

    @FindBy(xpath="//div[contains(@class,'i-filter-tag i-filter-tag--add')]/button")
    private WebElement Addfilter;

    @FindBy(xpath="")
    private WebElement customerNoInput;

    public ProductReferencePage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void selectOGForPR(String Og)
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]/descendant::button[text()='"+Og+"']",driver))
            {
                WebElement og= HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::button[text()='"+Og+"']");
                HelpersMethod.ClickBut(driver,og,1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                exists=true;
            }
        }
        catch (Exception e){}
    }

    public void NavigateToProductReference()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(HelpersMethod.IsExists("//span[contains(text(),'Product reference')]",driver))
            {
                if(HelpersMethod.IsExists("//span[contains(text(),'Product reference')]",driver))
                {
                    WebElement ParList = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Par list')]");
                    HelpersMethod.ScrollElement(driver, ParList);

                    HelpersMethod.navigate_Horizantal_Tab(driver, "Product reference", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Product reference')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                    exists = true;
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
                }
            }
            else
            {
                scenario.log("PRODUCT REFERNCE TAB DOESN'T EXISTS, PLEASE CHECK ADMIN SETTINGS");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateProductReference()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("customerProdutRefCard"))));
            if(HelpersMethod.IsExists("//div[@id='customerProdutRefCard']",driver))
            {
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void EnterCustomerAccount()
    {
        exists=false;
        WebElement WebEle;
        String headText=null;
        String Acc_NO= TestBase.testEnvironment.get_Account();
        int i=0;
        try
        {
            List<WebElement> Theads=HelpersMethod.FindByElements(driver,"xpath","//thead/tr[1]/th/descendant::span[@class='k-column-title']");
            for(WebElement Thead:Theads)
            {
                i++;
                headText=Thead.getText();
                if(headText.contains("Custom Column 1") || headText.contains("Custom column 1"))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')][1]/td["+(i)+"]/input");
                    HelpersMethod.ScrollElement(driver,WebEle);
                    HelpersMethod.clearText(driver,WebEle,10000);
                    HelpersMethod.EnterText(driver,WebEle,10000, Acc_NO);
                    scenario.log("ACCOUNT NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,WebEle,10000));
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DragAndDrop(String To_Text)
    {
        exists=false;
        try
        {
            WebElement OEProdGrid=HelpersMethod.FindByElement(driver,"id","card2");
            HelpersMethod.ScrollElement(driver,OEProdGrid);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-grouping-drop-container')]",driver))
            {
                List<WebElement> TableHeads=driver.findElements(By.xpath("//thead/tr[1]/th/descendant::span[@class='k-column-title']"));
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

    public void readGroupingDetails()
    {
        Actions act1=new Actions(driver);
        String groupingHead=null;
        try
        {
            scenario.log("GROUPING HEADER IS: ");
            List<WebElement> groups=HelpersMethod.FindByElements(driver,"xapth","//tr[@class='k-grouping-row']/descendant::span");
            for(WebElement group:groups)
            {
                act1.moveToElement(group).build().perform();
                groupingHead=group.getText();
                scenario.log(groupingHead);
            }
        }
        catch (Exception e){}
    }

    public String readProductNo()
    {
        String prod=null;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("customerProdutRefCard"))));
            WebElement prod_No=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::button");
            prod=prod_No.getText();
            scenario.log("PRODUCT TO BE SEARCHED IS "+prod);
        }
        catch (Exception e){}
        return prod;
    }

    public void AddfilterProductReference(String s, String prodNo)
    {
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("customerProdutRefCard"))));
            //HelpersMethod.AddFilterSearch(driver,s,prodNo);
            WebElement Search2;
            WebElement WebEle;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);//80000
            }
            String status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Click on Add filter button
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
            HelpersMethod.FindByElement(driver,"xpath","//button/descendant::span[contains(text(),'Add filter')]").click();

            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[@class='k-child-animation-container']",80000);
            WebElement modalContainer1=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-child-animation-container']");

            //Click on Clear all button
            WebElement Clear=modalContainer1.findElement(By.xpath(".//button/span[contains(text(),'Clear all')]"));
            if(Clear.isEnabled())
            {
                Clear.click();
            }

            WebElement Search1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.ActSendKey(driver,Search1,10000,s);
            //Click on Check box
            WebElement WebEle1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
            HelpersMethod.ClickBut(driver,WebEle1,10000);

                if(HelpersMethod.IsExists("//div[contains(@class,'k-animation-container k-animation-container-shown')]/descendant::input[contains(@class,'k-textbox')]",driver))
                {
                    WebElement modalContainer=driver.findElement(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-shown')]"));
                    Search2=modalContainer.findElement(By.xpath(".//input[contains(@class,'k-textbox')]"));
                    HelpersMethod.EnterText(driver, Search2, 10000, prodNo);

                    //Click on Apply button
                    Clear = Search2.findElement(By.xpath(".//button/span[text()='Apply']"));
                    HelpersMethod.ClickBut(driver,Clear,10000);
                    //loading Icon
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle =HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);//200000
                    }
                }
        }
        catch (Exception e){}
    }
}