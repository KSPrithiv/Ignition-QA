package pages_DSD_OMS.orderGuide;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Environment;
import util.TestBase;

import java.awt.*;
import java.time.Duration;
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

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]")
    private WebElement To;

    public OrderGuidePage(WebDriver driver, Scenario scenario) throws InterruptedException, AWTException
    {
        this.scenario=scenario;
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void Refresh_Page(String currentURL)
    {
        Actions act1=new Actions(driver);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
        }
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100000));
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
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
                //navigating back to Current URL
                driver.navigate().to(currentURL);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='dropDownNoneType']")));
        }
        catch (Exception e){}
    }

    public boolean ValidateOG()
    {
        exists=false;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-card orderGuides-card')]"))));
            if(HelpersMethod.IsExists("//span[@class='spnmoduleNameHeader' and contains(text(),'Order guide list')]|//span[@class='spnmoduleNameHeader' and contains(text(),'Order guide detail')]",driver))
            {
                scenario.log("NAVIGATED TO ORDER GUIDE");
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
            HelpersMethod.JScriptClick(driver,CreateOG,1000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
        }
        catch (Exception e){}
    }

    //code for searching OG using Searchbox
    public boolean OGSearchBox(String OGSearch)
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            HelpersMethod.ScrollElement(driver,SearchIndex);
            HelpersMethod.ActSendKey(driver,SearchBox,2000,OGSearch);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            SearchIndex=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
            HelpersMethod.ActClick(driver,SearchIndex,8000);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

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
    public void SearchOGSelect(String OGSearch)
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//tr[@class='k-master-row']",driver))
            {
                WebElement OGNo=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td/button[text()='"+OGSearch+"']");
                HelpersMethod.ActClick(driver,OGNo, 4000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
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
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-filter-tag i-filter-tag--add']/descendant::button[@class='i-filter-tag__main']",driver))
            {
                //Clear the filter option
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-filter-tag ']/descendant::button[contains(@class,'i-filter-tag__clear')]");
                HelpersMethod.ClickBut(driver,WebEle,1000);

                HelpersMethod.AddFilterSearch(driver,search1,search2);
                if(!HelpersMethod.IsExists("//div[contains(@class,'i-no-data__message')]",driver))
                {
                    List<WebElement> OGLists = HelpersMethod.FindByElements(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::button");
                        for (WebElement OGList : OGLists)
                        {
                            String OG_Text = OGList.getText();
                            scenario.log("FILTERED VALUE FROM OG " + OG_Text);
                        }
                    exists=true;
                }
                else
                {
                    scenario.log("RELAVENT FILTER VALUES DOESN'T EXISTS");
                    exists=false;
                }
            }
        }
        catch (Exception e){}
        return exists;
    }

    public boolean AddFilterForExpiredOG(String search1,String search2)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-filter-tag i-filter-tag--add']/descendant::button[@class='i-filter-tag__main']",driver))
            {
                exists=true;
                WebElement Search2=null;
                WebElement WebEle=null;

                //Clear the filter option
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-filter-tag ']/descendant::button[contains(@class,'i-filter-tag__clear')]");
                HelpersMethod.ClickBut(driver,WebEle,1000);

                //Click on Add filter button
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
                driver.findElement(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")).click();

                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",10000);
                WebElement modalContainer1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");

                WebElement Search1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
                HelpersMethod.ActSendKey(driver,Search1,1000,search1);
                //Click on Check box
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[contains(@class,'k-checkbox')]")));
                WebElement WebEle1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
                HelpersMethod.ClickBut(driver,WebEle1,1000);

                //Identify radio button and click on Radio button
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-filter-popup i-filter-popup--manyFromMany')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
                if(HelpersMethod.IsExists("//input[@id='E']",driver))
                {
                   Search2=HelpersMethod.FindByElement(driver,"id","E");
                   HelpersMethod.ClickBut(driver,Search2,1000);
                   exists=true;
                }
                /*
                if(!HelpersMethod.IsExists("//div[contains(@class,'i-no-data__message')]",driver))
                {
                    exists=true;
                }
                else
                {
                    scenario.log("RELAVENT FILTER VALUES DOESN'T EXISTS");
                    exists=false;
                }*/
                WebElement dummy=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'SearchBox')]");
                act.click(dummy).build().perform();
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            HelpersMethod.ActClick(driver,CustRef,1000);
            //HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none')]",40000);
        }
        catch (Exception e){}
    }

    //Code to select different type of OG from drop down
    public void CustRefDropDown(String OGtype)
    {
        exists=false;
        WebElement WebEle=null;
        Actions act1= new Actions(driver);
        try
        {
            // to fetch the web element of the modal container
            List<WebElement> custRefs=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li");
            for(int i=0;i<=custRefs.size()-1;i++)
            {
                WebEle=custRefs.get(i);
                act1.moveToElement(WebEle).build().perform();
                String custRef=WebEle.getText();
                if(custRef.equals(OGtype))
                {
                    act1.moveToElement(WebEle).build().perform();
                    act1.click().build().perform();
                    break;
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
            }

            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",10000);
            //new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement SubRef=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][2]");
                HelpersMethod.ActClick(driver,SubRef,4000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
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
            HelpersMethod.ClickBut(driver,CustomerAccIndex,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
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
                    HelpersMethod.EnterText(driver,SearchBox,1000,TestBase.testEnvironment.get_AnotherAcc());
                    scenario.log("ANOTHER ACCOUNT SELECTED FOR CREATING OG IS "+TestBase.testEnvironment.get_AnotherAcc());
                    //code to check for existence of Account#
                    WebElement SearchIndex=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')] //*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]");
                    HelpersMethod.ClickBut(driver,SearchIndex,1000);
                    //code to select Account#
                    WebElement SelectAcc=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')] /descendant::tr[@class='k-master-row']");
                    HelpersMethod.ActClick(driver,SelectAcc,1000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            WebElement DisOG=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-master-row'][1]/descendant::button");
            OGDis=DisOG.getText();
            HelpersMethod.ClickBut(driver,DisOG,2000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
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
            HelpersMethod.ClickBut(driver,CustomerAccIndex,2000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Select customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Enter Account number in search box in customer account # popup
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[@placeholder='Search']");
                HelpersMethod.EnterText(driver,WebEle,2000,TestBase.testEnvironment.get_AnotherAcc());
                //Click on Search Index
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]");
                HelpersMethod.ClickBut(driver,WebEle,2000);
                if(!HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']",driver))
                {
                    WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row']/td[1]");
                    scenario.log("ACCOUNT NUMBER SELECTED IS "+WebEle.getText());
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row']");
                    HelpersMethod.ActClick(driver,WebEle,2000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                    }
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

    public void ClickCustomerAccount_No_PreviousAcc()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            HelpersMethod.ClickBut(driver,CustomerAccIndex,4000);
            if(HelpersMethod.IsExists("//div[contains(text(),'Select customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Enter Account number in search box in customer account # popup
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[@placeholder='Search']");
                HelpersMethod.EnterText(driver,WebEle,2000,TestBase.testEnvironment.get_Account());
                //Click on Search Index
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__search')]");
                HelpersMethod.ClickBut(driver,WebEle,2000);
                if(!HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']",driver))
                {
                    WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row']/td[1]");
                    scenario.log("ACCOUNT NUMBER SELECTED IS "+WebEle.getText());
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row']");
                    HelpersMethod.ActClick(driver,WebEle,2000);
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
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        WebElement modalContainer =HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Select National chain", "Verify Title message");
    }

    public void selectNationalChainFromPopup(String nationalChain) throws InterruptedException
    {
        WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
        //Enter the national chain name in search box
        WebElement searchBox=modalContainer.findElement(By.xpath(".//input[@id='SearchBox1']"));
        HelpersMethod.EnterText(driver,searchBox,4000,nationalChain);
        //click on search index
        searchBox=modalContainer.findElement(By.xpath(".//*[local-name()='svg' and contains(@class,'i-search-box__search')]"));
        HelpersMethod.ClickBut(driver,searchBox,4000);
        //click on selected national chain
        WebElement nChain=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]"));
        HelpersMethod.ActClick(driver,nChain,8000);
    }

    public void FindtableHeader(String tableHead)
    {
            exists=false;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
           WebElement  WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
        }
            try
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]",driver))
                {
                    List<WebElement> TableHeads=driver.findElements(By.xpath("//thead/tr[1]/th"));
                    for(WebElement THead:TableHeads)
                    {
                        String Head=THead.getText();
                        if(Head.contains(tableHead))
                        {
                            Thread.sleep(1000);
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

    public void DisplayGroupDetails()
    {
        try
        {
            List<WebElement> Groups=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-grouping-row')]/td[@role='gridcell']/span");
            for(WebElement group:Groups)
            {
                String groupValue=group.getText();
                scenario.log("GROUP VALUE CONTAINS "+groupValue);
            }
        }
        catch (Exception e){}
    }

    public void selectSubMarketRef()
    {
        exists=false;
        try
        {
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
        }

        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",10000);
        //new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
        if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
        {
            WebElement SubRef=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
            HelpersMethod.ActClick(driver,SubRef,4000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
            }
        }
    }
    catch (Exception e){}
    }
}