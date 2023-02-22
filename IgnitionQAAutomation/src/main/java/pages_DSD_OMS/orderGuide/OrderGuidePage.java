package pages_DSD_OMS.orderGuide;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.commons.collections.IteratorUtils;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.Environment;
import util.TestBase;

import java.awt.*;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class OrderGuidePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static boolean exists=false;

    @FindBy(id="dropDownNoneType")
    private WebElement CustRef;

    @FindBy(id="plusAdditionalAccountButtonFlat")
    private WebElement CreateOG;

    @FindBy(xpath="//label[@id='textBoxE-label']/ancestor::div[@class='flex-container']/descendant::button")
    private WebElement CustAccNoButton;

    @FindBy(id="SearchBox1")
    private WebElement SearchBox;

    @FindBy(xpath = "//div[@class='i-search-box']//*[local-name()='svg']/*[local-name()='path' and contains(@d,'M15.5')]")
    private WebElement SearchIndex;

    @FindBy(xpath="//div[@class='i-filter-tag i-filter-tag--add']/descendant::button[@class='i-filter-tag__main']")
    private WebElement AddFilter;

    @FindBy(xpath="//label[contains(text(),'Customer account')]/parent::div/following-sibling::button")
    private WebElement CustomerAccIndex;

    public OrderGuidePage(WebDriver driver, Scenario scenario) throws InterruptedException, AWTException
    {
        this.scenario=scenario;
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void Refresh_Page()
    {
        WebElement WebEle=null;
        driver.navigate().refresh();
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
    }

    public boolean ValidateOG()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@class='spnmoduleNameHeader' and contains(text(),'Order guide list')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    public void CrateOG()
    {
        try
        {
            HelpersMethod.ScrollElement(driver,CreateOG);
            HelpersMethod.JScriptClick(driver,CreateOG,40);
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10);
        }
        catch (Exception e){}
    }

    //code for searching OG using Searchbox
    public boolean OGSearchBox(String OGSearch)
    {
        exists=false;
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            HelpersMethod.ScrollElement(driver,SearchIndex);
            HelpersMethod.ActSendKey(driver,SearchBox,20,OGSearch);
            HelpersMethod.ActClick(driver,SearchIndex,20);

            if(HelpersMethod.IsExists("//tr[@class='k-master-row']",driver))
            {
                exists=true;
                scenario.log("ORDER GUIDE ENTERED IN SEARCH BOX IS " + OGSearch);
            }
           else
           if(HelpersMethod.IsExists("//tr[@class='k-grid-norecords']",driver))
            {
                exists=false;
                scenario.log("ORDER GUIDE DOESNOT EXISTS");
            }
        }
        catch (Exception e){}
        return  exists;
    }

    //Click on OG in OG grid, once searching is sucessfull
    public void SearchOGSelect()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//tr[@class='k-master-row']",driver))
            {
                WebElement OGNo=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-master-row']/descendant::td/button");
                HelpersMethod.ActClick(driver,OGNo, 20);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            else
            {
                scenario.log("ORDER GUIDE DOESNOT EXISTS");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to click on Addfilter
    public boolean AddFilterClick(String search1,String search2)
    {
        exists=false;
        try
        {
            if(AddFilter.isDisplayed())
            {
                exists=true;
                HelpersMethod.AddFilterSearch(driver,search1,search2);
                if(!HelpersMethod.IsExists("//div[contains(@class,'i-no-data__message')]",driver))
                {
                    List<WebElement> OGLists = HelpersMethod.FindByElements(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::button");
                    for (int i = 0; i <= 5; i++)
                    {
                        for (WebElement OGList : OGLists)
                        {
                            String OG_Text = OGList.getText();
                            scenario.log("Filtered value from Add filter " + OG_Text);
                        }
                    }
                }
                else
                {
                    scenario.log("RELAVENT FILTER VALUES DOESN'T EXISTS");
                }
            }
        }
        catch (Exception e){}
        return exists;
    }

    //Code to click on Customer reference
    public void CustomerRef()
    {
        try
        {
            HelpersMethod.ActClick(driver,CustRef,40);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]",40);
        }
        catch (Exception e){}
    }

    //Code to select different type of OG from drop down
    public void CustRefDropDown(String OGtype)
    {
       /* List<WebElement> CustRefTypes=null;
        Actions act1=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container ')]",driver))
            {
                CustRefTypes=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container ')]/descendant::ul/li");
                for(WebElement CustRefType:CustRefTypes)
                {
                    act1.moveToElement(CustRefType).build().perform();
                    String CustRef_Text=CustRefType.getText();
                    if(CustRef_Text.equals(OGtype))
                    {
                        act1.click(CustRefType).build().perform();
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10);
                        break;
                    }
                }
            }
        }
        catch (Exception e){}*/
        exists=false;
        WebElement WebEle=null;
        Actions act1= new Actions(driver);
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",40);
            // to fetch the web element of the modal container
            WebElement menuContainer = driver.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]"));
            List<WebElement> custRefs=menuContainer.findElements (By.xpath(".//ul/li"));
            for(int i=0;i<=custRefs.size()-1;i++)
            {
                WebEle=custRefs.get(i);
                act1.moveToElement(WebEle).build().perform();
                String custRef=WebEle.getText();
                if(custRef.equals(OGtype))
                {
                    act1.moveToElement(WebEle).click().build().perform();
                    break;
                }
                else
                {
                    act1.moveToElement(WebEle).sendKeys(Keys.ARROW_DOWN).build().perform();
                }
            }
        }
        catch (Exception e) { }
    }

    //Code to check for popup and to select sub category in Customer reference
    public void SubCustomerRef()
    {
        try
        {
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",10);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement SubRef=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver,SubRef,10);
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                if(WebEle.isDisplayed())
                {
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10);
                }
            }
        }
        catch (Exception e){}
    }

    //Code to click on customer account# index icon
    public void CustomerAcc()
    {
        try
        {
            HelpersMethod.ClickBut(driver,CustomerAccIndex,10);

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40);
            }
        }
        catch (Exception e){}
    }

    //Code for handling customer account# popup
    public void AccountPopup()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Select customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[@id='SearchBox1']",driver))
                {
                    WebElement SearchBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[@id='SearchBox1']");
                    HelpersMethod.EnterText(driver,SearchBox,10,TestBase.testEnvironment.get_AnotherAcc());
                    scenario.log("ANOTHER ACCOUNT SELECTED FOR CREATING OG IS "+TestBase.testEnvironment.get_AnotherAcc());
                    //code to check for existence of Account#
                    WebElement SearchIndex=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')] //*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]");
                    HelpersMethod.ClickBut(driver,SearchIndex,10);
                    //code to select Account#
                    WebElement SelectAcc=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')] /descendant::tr[@class='k-master-row']");
                    HelpersMethod.ActClick(driver,SelectAcc,10);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40);
                    }
                }
                else
                {
                    scenario.log("SEARCH BOX IN CUSTOMER ACCOUNT# POPUP, DOESN'T EXISTS");
                }
            }
        }
        catch (Exception e){}
    }

    //Code to select first order guide from OG grid
    public String SelectOG()
    {
        String OGDis=null;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40);
            }
            WebElement DisOG=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-master-row'][1]/descendant::button");
            OGDis=DisOG.getText();
            HelpersMethod.ClickBut(driver,DisOG,2);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40);
            }
        }
        catch (Exception e){}
        return OGDis;
    }

    //Click on Customer Account# to change Customer Account#
    public void ClickCustomerAccount_No()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            HelpersMethod.ClickBut(driver,CustomerAccIndex,20);
            if(HelpersMethod.IsExists("//div[contains(text(),'Select customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Enter Account number in search box in customer account # popup
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[@placeholder='Search']");
                HelpersMethod.EnterText(driver,WebEle,20,TestBase.testEnvironment.get_AnotherAcc());
                //Click on Search Index
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]");
                HelpersMethod.ClickBut(driver,WebEle,20);
                if(!HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']",driver))
                {
                    WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row']/td[1]");
                    scenario.log("ACCOUNT NUMBER SELECTED IS "+WebEle.getText());
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row']");
                    HelpersMethod.ActClick(driver,WebEle,20);
                    exists=true;
                }
                else
                {
                    scenario.log("CUSTOMER ACCOUNT # DOES NOT EXISTS");
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }

    public void validateNationalChainPopup()
    {
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",100);
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Select National chain", "Verify Title message");
    }

    public void selectNationalChainFromPopup(String nationalChain) throws InterruptedException
    {
        WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
        //Enter the national chain name in search box
        WebElement searchBox=modalContainer.findElement(By.xpath(".//input[@id='SearchBox1']"));
        HelpersMethod.EnterText(driver,searchBox,60,nationalChain);
        //click on search index
        searchBox=modalContainer.findElement(By.xpath(".//*[local-name()='svg' and contains(@class,'i-search-box__search')]"));
        HelpersMethod.ClickBut(driver,searchBox,60);
        //click on selected national chain
        searchBox=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
        HelpersMethod.ActClick(driver,searchBox,100);
    }
}
