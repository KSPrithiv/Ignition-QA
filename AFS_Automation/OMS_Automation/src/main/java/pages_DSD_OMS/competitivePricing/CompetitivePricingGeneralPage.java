package pages_DSD_OMS.competitivePricing;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.DataBaseConnection;
import util.RandomValues;
import util.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class CompetitivePricingGeneralPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String code=null;
    static String desc=null;
    static String currentURL=null;

    @FindBy(xpath="//label[contains(text(),'Customer reference')]/following-sibling::span/span")
    private WebElement CustomerRefDropdown;

    @FindBy(xpath="//label[contains(text(),'Customer account #')]/following-sibling::div/descendant::button")
    private WebElement CustomerAccIndex;

    @FindBy(xpath="//label[contains(text(),'Competitor')]/following-sibling::span/span")
    private WebElement CompetitorDropdown ;

    @FindBy(xpath="//button[contains(text(),'New competitor')]")
    private WebElement NewCompetitor;

    @FindBy(xpath="//label[text()='Source']/following-sibling::textarea")
    private WebElement SourceText;

    @FindBy(xpath="//label[text()='Comments']/following-sibling::textarea")
    private WebElement CommentText;

    @FindBy(xpath="//button[contains(text(),'Load existing data')]")
    private WebElement LoadexistingData;

    @FindBy(xpath="//button[contains(text(),'Delete competitor data')]")
    private WebElement DeleteCompetitorData;

    @FindBy(xpath="//button[text()='Save']")
    private WebElement SaveBut;

    @FindBy(xpath="//button[text()='Cancel']")
    private WebElement CancelBut;

    @FindBy(id="plus")
    private WebElement PlusBut;

    @FindBy(id="deleteAdditionalAccountButton")
    private WebElement DeleteBut;

    @FindBy(id="SearchBox1")
    private WebElement SearchBar;

    @FindBy(xpath="//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement SearchIndex;

    public CompetitivePricingGeneralPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //actions
    public void NavigateToCompetitorPricing()
    {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try {
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");

            act.moveToElement(Search_Input).click().sendKeys("Competitive Pricing").build().perform();
            WebElement CompetitorMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Competitive Pricing')]");
            HelpersMethod.ClickBut(driver, CompetitorMenu, 1000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                act.moveToElement(WebEle).build().perform();
                act.click(WebEle).build().perform();
            }
            currentURL=driver.getCurrentUrl();
            if(HelpersMethod.IsExists("//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Competitive Pricing')]",driver))
            {
                scenario.log("NAVIGATED TO COMPETITOR PRICING PAGE");
            }
            else
            {
                scenario.log("COMPETITOR PRICING MAY NOT BE ENABLED FOR THE APPLICATION, CHECK WITH ADMIN SETTINGS");
            }
            Assert.assertEquals(exists, true);
        } catch (Exception e) {}
    }

    public void HandleError_Page()
    {
        try
        {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError"))
            {
                HelpersMethod.NavigateBack(driver);
                URL = HelpersMethod.gettingURL(driver);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
            {
                HomePage homepage = new HomePage(driver, scenario);
                homepage.navigateToClientSide();
                NavigateToCompetitorPricing();
            }
        }
        catch (Exception e) {}
    }

    public void Refresh_Page()
    {
        Actions act1=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
                if(wait.until(ExpectedConditions.alertIsPresent())==null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
            }
           /* else
            {*/
                driver.navigate().to(currentURL);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            //}
        }
        catch (Exception e){}
    }

    public void ValidateCompetitorGeneral()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='card1']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_CustomerReferenceDropDown()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,CustomerRefDropdown,1000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}

    }

    //public void Select_CustomerReference(String CustRef, String CustRef1)
    public void Select_CustomerReference(String CustRef)
    {
        exists=false;
        WebElement Search2=null;
        try
        {
            WebElement WebEle = null;
            Actions act1 = new Actions(driver);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]", 10000);
            // to fetch the web element of the modal container
            WebElement menuContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> Options = menuContainer.findElements(By.xpath(".//ul/li"));
            for (int i = 0; i <= Options.size() - 1; i++)
            {
                WebEle = Options.get(i);
                act1.moveToElement(WebEle).build().perform();
                String Opt = WebEle.getText();

                if(Opt.contains(CustRef))
                {
                    act1.moveToElement(WebEle).build().perform();
                    act1.click(WebEle).build().perform();
                    break;
                }
                else
                {
                    act1.moveToElement(WebEle).sendKeys(Keys.ARROW_DOWN).build().perform();
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                    }
                }
            }
        }
        catch(Exception e){}
    }

    public void Click_CustomerAccountIndex()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver, CustomerAccIndex, 1000);
            exists = true;
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ValidateCustomerAccountPopup()
    {
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",600);
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",600);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
        Assert.assertEquals(modalContentTitle.getText(), "Customer account index", "Verify Title message");
    }

    public void SelectCustomerAccount()
    {
        exists = false;
        WebElement WebEle;
        WebElement Search2;
        String AccNo = TestBase.testEnvironment.get_Account();
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            // code to click on Addfilter button
            WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
            HelpersMethod.ActClick(driver, AddFilterButton, 2000);

            //Identify the dialog popup
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]", 5000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]", 2000);
            WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");

            //Enter customer account# in input box
            WebElement Search1 = modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.EnterText(driver, Search1, 2000, "Customer account #");

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Click on Check box
            HelpersMethod.WaitElementPresent(driver, "xpath", "//input[@id='value']", 20000);
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='value']")));
            WebElement WebEle1 = modalContainer1.findElement(By.xpath(".//input[@id='value']"));
            HelpersMethod.JScriptClick(driver, WebEle1, 1000);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Identify radio button and click on Radio button
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 20000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 20000);
            WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
            WebElement radioButton = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            if (radioButton.isDisplayed())
            {
                Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                HelpersMethod.EnterText(driver, Search2, 1000, AccNo);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                //Click on Apply button
                WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button[text()='Apply']"));
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(ApplyButton));
                HelpersMethod.ClickBut(driver, ApplyButton, 1000);
            }

            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']", driver))
            {
                scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
            }
            else
            {
                WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 1000);

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                exists = true;
                String Acc = TestBase.testEnvironment.get_Account();
                scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
            }
        }
        catch (Exception e){}
    }

    public void Click_NewCompetitorButton()
    {
        exists=false;

        try
        {
            HelpersMethod.ActClick(driver,NewCompetitor,1000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateNewCompetitorPopup()
    {
        exists=false;
        WebElement WebEle=null;

        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Add new competitor')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Identifying Competitor code input box
                code= RandomValues.generateRandomAlphaNumeric(4);
                WebEle=HelpersMethod.FindByElement(driver,"id","competitorCode");
                HelpersMethod.EnterText(driver,WebEle,1000,code);
                scenario.log("CODE ENTERED IS "+code);

                //Identifying description input box
                desc=RandomValues.generateRandomAlphaNumeric(4);
                WebEle=HelpersMethod.FindByElement(driver,"id","competitorDescription");
                HelpersMethod.EnterText(driver,WebEle,1000,desc);
                scenario.log("DESCRIPTION ENTERED IS "+desc);

                //Identifying Add button
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Add']");
                HelpersMethod.ClickBut(driver,WebEle,1000);

                exists=true;
            }
            else
            {
                scenario.log("ADD NEW COMPETITOR POPUP IS NOT VISIBLE");
            }
        }
        catch (Exception e){}
    }

    public void SourceTextArea(String Sourcetext)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,SourceText,1000,Sourcetext);
            exists= true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CommentTextArea(String Commenttext)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,CommentText,1000,Commenttext);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}

    }

    public void SelectProdCatalogPopup()
    {
        exists=true;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Product index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                for(int i=0;i<=2;i++)
                {
                    HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]["+i+"]");
                    HelpersMethod.ClickBut(driver,WebEle,1000);
                }
                //Click on OK button
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}

    }

    public void Click_SaveButton()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,SaveBut,1000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Save competitive pricing data')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_CompetitorDropdown()
    {
        exists=false;
        Actions act= new Actions(driver);
        String compet_text=null;
        WebElement WebEle;
        try
        {
            scenario.log("VALUE TO BE SELECTED FROM COMPETITOR: "+code);
            act.moveToElement(CompetitorDropdown).click().build().perform();
            // HelpersMethod.DropDownMenu(driver,code);
            WebElement menuContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> Values = menuContainer.findElements(By.xpath(".//ul/li"));
            for (WebElement Val : Values)
            {
                act.moveToElement(Val).build().perform();
                String Val_Text = Val.getText();
                if (Val_Text.contains(code))
                {
                    act.moveToElement(Val).build().perform();
                    act.click(Val).build().perform();
                    scenario.log("COMPETITOR VALUE SELECTED IS "+code);
                    exists = true;
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                    }
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void Click_Plus()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,PlusBut,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Validate_ProductIndex()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Product index", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void selectProductsForCompetitorPricing()
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        String pro=null;
        int j=0;
        List <WebElement> Products=null;
        try
        {
            // List<String> Prods= DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
            if(HelpersMethod.IsExists("//div[contains(text(),'Product index')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement productIndex = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                for(int i=0;i<=4;i++)
                {
                    WebEle=productIndex.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]["+(i+1)+"]"));
                    HelpersMethod.ClickBut(driver,WebEle,1000);
                }
                WebEle=productIndex.findElement(By.xpath(".//button[text()='OK']"));
                HelpersMethod.ClickBut(driver,WebEle,1000);

                //Read all the products # added to customer inq
                List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
                for (WebElement tablehead:tableHeads)
                {
                    j++;
                    act.moveToElement(tablehead).build().perform();
                    String headText=tablehead.getText();
                    if(headText.equals("Product #"))
                    {
                        Products=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td["+(j+1)+"]");
                        break;
                    }
                }
                for (WebElement prods:Products)
                {
                    act.moveToElement(prods).build().perform();
                    pro=prods.getText();
                    scenario.log("PRODUCT NUMBERS IN GRID "+pro);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Selecting_SoldByUOM_Selecting_BaseUOM()
    {
        exists = false;
        WebElement WebEle = null;
        List<WebElement> UOMValues = null;

        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-grid']");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Selecting value for Sold by UOM
            for (int i = 0; i <= 4; i++)
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][" + (i + 1) + "]/descendant::td[contains(@class,'preferred-cell')][1]");
                HelpersMethod.ActClick(driver, WebEle, 1000);
                UOMValues = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::ul/li");
                HelpersMethod.ActClick(driver, UOMValues.get(0), 1000);
            }
            //Selecting value for Base UOM
            for(int i=0;i<=4;i++)
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+(i+1)+"]/descendant::td[contains(@class,'preferred-cell')][2]");
                HelpersMethod.ActClick(driver,WebEle,1000);
                UOMValues=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::ul/li");
                HelpersMethod.ActClick(driver,UOMValues.get(0),1000);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void EnteringCompetitorPricingComment(List<List<String>> prod_detail)
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            for(int i=0;i<=4;i++)
            {
                //Code for entering competitor pricing
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+(i+1)+"]/descendant::td/descendant::input[contains(@class,'k-input k-formatted-value')]");
                HelpersMethod.ActClearKey(driver,WebEle,1000);
                HelpersMethod.ActSendKey(driver,WebEle,1000, prod_detail.get(i).get(0));
                //Code for entering Comment in Competitor pricing
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+(i+1)+"]/descendant::td/descendant::input[contains(@class,'k-textbox')]");
                HelpersMethod.EnterText(driver,WebEle,1000,prod_detail.get(i).get(1));
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_CheckBox()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]");
            HelpersMethod.ClickBut(driver,WebEle,1000);
        }
        catch (Exception e){}
    }

    public void Click_DeleteProd()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,DeleteBut,1000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_DeleteCompetitorRecord()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,DeleteCompetitorData,1000);
            if(HelpersMethod.IsExists("//div[contains(text(),'Delete competitor data')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Delete']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Delete competitor data')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
            }
        }
        catch (Exception e){}
    }

    public void SearchForProd()
    {
        Actions act=new Actions(driver);
        exists=false;
        WebElement WebEle=null;
        String Prod=null;
        int i=0;
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for (WebElement tablehead:tableHeads)
            {
                i++;
                act.moveToElement(tablehead).build().perform();
                String headText=tablehead.getText();
                if(headText.equals("Product #"))
                {
                    Prod=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::td["+(i+1)+"]").getText();
                    break;
                }
            }

            HelpersMethod.AddFilterSearch(driver,"Product #",Prod);
            if(HelpersMethod.IsExists("//div[@class='i-no-data']",driver))
            {
                scenario.log("NO PRODUCT HAS BEEN FOUND");
                exists=false;
            }
            else
            {
                scenario.log(Prod+" HAS BEEN FOUND IN THE GRID");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchForProdSearchBar()
    {
        Actions act=new Actions(driver);
        exists=false;
        WebElement WebEle=null;
        String Prod=null;
        int i=0;
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//th[contains(@class,'k-header')]/descendant::span[@class='k-column-title']");
            for (WebElement tablehead:tableHeads)
            {
                i++;
                act.moveToElement(tablehead).build().perform();
                String headText=tablehead.getText();
                if(headText.equals("Product #"))
                {
                    Prod=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::td["+(i+1)+"]").getText();
                    break;
                }
            }
            HelpersMethod.EnterText(driver,SearchBar,1000,Prod);
            HelpersMethod.ClickBut(driver,SearchIndex,1000);
            if(HelpersMethod.IsExists("//div[@class='i-no-data']",driver))
            {
                exists=false;
                scenario.log("NO PRODUCT HAS BEEN FOUND");
            }
            else
            {
                exists=true;
                scenario.log(Prod+" HAS BEEN FOUND IN THE GRID");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Click_LoadExistingData()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,LoadexistingData,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
        }
        catch (Exception e){}
    }

    public void Validate_LoadExistingDataPopUp()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Load existing data')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchCustomerDetails()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[@id='SearchBox1']");
            HelpersMethod.EnterText(driver,WebEle,1000,TestBase.testEnvironment.get_Account());
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectCompetitorDetails()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(!HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data__icon']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row'][1]");
                HelpersMethod.ActClick(driver,WebEle,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            }
            else
            {
                scenario.log("NO DATA HAS BEEN FOUND");
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DetailsOfProducts()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-grid']");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Reading product# from the grid
            List<WebElement> Products=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[2]");
            for(WebElement Prod:Products)
            {
                String Prod_No=Prod.getText();
                scenario.log("PRODUCT FOUND IN: "+Prod_No);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

}