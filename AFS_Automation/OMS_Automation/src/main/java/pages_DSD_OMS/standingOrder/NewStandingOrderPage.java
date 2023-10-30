package pages_DSD_OMS.standingOrder;

import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.DataBaseConnection;
import util.TestBase;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class NewStandingOrderPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static String currentURL=null;
    static boolean exists=false;
    static String Prod_No=null;

    @FindBy (xpath="//div[@id='card1']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]")
    private WebElement StandingOrderArrow;

    @FindBy (xpath="//button[text()='Save']")
    private WebElement SaveButton;

    @FindBy(xpath="//button[text()='Add product']")
    private WebElement AddProduct;

    @FindBy(xpath="//button[@data-test-id='skipDeliveryDaysStandingOrderBtn']")
    private WebElement SkipSpecificdays;

    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement DeleteProd;

    @FindBy(id="frequency")
    private WebElement DeliverySchedule;

    @FindBy(id="quickProduct")
    private WebElement QuickProduct;

    public NewStandingOrderPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String navigateToStandingOrderPage()
    {
        exists = false;
        try
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                String Menu_Text = null;
                Actions act = new Actions(driver);
                List<WebElement> MenuBar = HelpersMethod.FindByElements(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                for (WebElement Menu : MenuBar)
                {
                    act.moveToElement(Menu).build().perform();
                    Menu_Text = Menu.getText();
                    if (Menu_Text.contains("Standing Orders") || Menu_Text.contains("Standing orders"))
                    {
                        WebElement menuItem = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]");
                        HelpersMethod.JScriptClick(driver, menuItem, 1000);
                        exists=true;
                        break;
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                currentURL = driver.getCurrentUrl();
            }
            else
            {
                scenario.log("STANDING ORDER MENU IS NOT DISPLAYED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return currentURL;
    }

    public void ValidateSO()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            exists=HelpersMethod.IsExists("//div[contains(@class,'topHeaderRow')]/descendant::span[contains(text(),'Standing Orders')]|//div[contains(@class,'topHeaderRow')]/descendant::span[contains(text(),'Standing orders')]",driver);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void QuickProductValue()
    {
        exists=false;
        WebElement WebEle=null;
        Actions act1=new Actions(driver);
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","card2");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(QuickProduct.isDisplayed() && QuickProduct.isEnabled())
            {
                //Enter Qty in quick inputbox
                String Pro = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
                act1.moveToElement(QuickProduct).click().build().perform();
                HelpersMethod.sendKeys(driver,QuickProduct,1000,Pro);
                QuickProduct.sendKeys(Keys.TAB);
                WebElement uomSO= HelpersMethod.FindByElement(driver,"id","quickEntryUMs");
                uomSO.sendKeys(Keys.TAB);
                Thread.sleep(8000);
                scenario.log("PRODUCT ENTERED IN QUICK ENTRY IS " + Pro);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //For entering Qty in product grid of standing order product based on input box enabled or disabled
    public void EnterQtyInProductGrid(List<List<String>> days)
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            int i=0;
            int j=0;
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//label[@class='card-title-products']");
            HelpersMethod.ScrollElement(driver,WebEle);
            List<WebElement> QtyInput=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')]/td[contains(@class,'cell')]");
            for (WebElement day:QtyInput)
            {
                for(;i<=7;i++)
                {
                    if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row k-grid-edit-row')]/td[contains(@class,'cell')]["+i+"]/descendant::input",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row k-grid-edit-row')]/td[contains(@class,'cell')]["+i+"]/descendant::input");
                        HelpersMethod.ActSendKey(driver,WebEle,20000,days.get(0).get(j));
                        j++;
                    }
                }
            }
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    //For Clicking on Save button
    public void ClickSaveButton()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOf(SaveButton));
            if(SaveButton.isDisplayed() && SaveButton.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,SaveButton);
                HelpersMethod.ClickBut(driver,SaveButton,15000);

                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                exists=true;
                scenario.log("STANDING ORDER SAVE BUTTON CLICKED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void sucessPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }

            if(HelpersMethod.IsExists("//div[text()='Success']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement OkButton=WebEle.findElement(By.xpath(".//button"));
                HelpersMethod.ClickBut(driver,OkButton,1000);
                exists=true;
            }
            scenario.log("STANDING ORDER SUCESSFULLY SAVED");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            new WebDriverWait(driver,Duration.ofMillis(60000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='i-card StandingOrder-card-grid']"))));
            new WebDriverWait(driver,Duration.ofMillis(60000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='i-card StandingOrder-card-grid']"))));
            if(HelpersMethod.IsExists("//div[@class='i-card StandingOrder-card-grid']",driver))
            {
                scenario.log("READY TO CREATE NEXT STANDING ORDER");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnAddProductButton()
    {
        exists=false;
        WebElement WebEle=null;
        new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add product')]")));
        try
        {
            if(AddProduct.isDisplayed() && AddProduct.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,AddProduct);
                HelpersMethod.ActClick(driver,AddProduct,1000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateCatalogPopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]",driver))
                {
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                    }
                    //Click on Add filter button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[contains(text(),'Add filter')]");
                    new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
                    HelpersMethod.ScrollElement(driver,WebEle);
                    HelpersMethod.JScriptClick(driver, WebEle, 100);

                    //Click on Clear all button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container')]/descendant::button[contains(text(),'Clear all')]");
                    new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(WebEle));
                    if (WebEle.isDisplayed() && WebEle.isEnabled())
                    {
                        HelpersMethod.JScriptClick(driver, WebEle, 1000);
                        //loading Icon
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                        }
                    }
                    else
                    {
                        //Click on Add filter button, if 'Clear all' is disabled, we should close add filter
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[contains(text(),'Add filter')]");
                        HelpersMethod.ActClick(driver, WebEle, 1000);
                    }
                }
                exists=true;
            }
            scenario.log("CATALOG DIALOG BOX HAS BEEN FOUND");
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ListView()
    {
        exists = false;
        WebElement WebEle=null;
        WebElement selectButton;
        WebElement clearButton;
        Actions act=new Actions(driver);
        try
        {
            List<String> Prods = DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                //to load all the products in catalog
                if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
                {
                    WebElement loadProducts=HelpersMethod.FindByElement(driver,"xapth","//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver,loadProducts,1000);
                }

                //Click on 'Add filter'
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = catalogPopup.findElement(By.xpath(".//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
                HelpersMethod.clickOn(driver, WebEle, 1000);

                //Click on clear all
                WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
                WebElement clearAll=dropDown.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::button[contains(text(),'Clear all')]"));
                if(clearAll.isDisplayed() && clearAll.isEnabled())
                {
                    HelpersMethod.ActClick(driver,clearAll,1000);
                    //Click on Add filter again
                    HelpersMethod.clickOn(driver, WebEle, 1000);
                }
                //Enter value in 1st input
                WebElement fistSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
                HelpersMethod.EnterText(driver,fistSearch,1000,"Product #");
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","ProductNumber");
                HelpersMethod.ActClick(driver,checkBox,1000);
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button[text()='Apply']");
                HelpersMethod.ClickBut(driver,applyButton,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                //Enter product numbers to be searched
                for(int j=0;j<=Prods.size()-1;j++)
                {
                    //click on filter option button
                    WebElement searchOption=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'i-filter-tag__main')]");
                    HelpersMethod.ClickBut(driver,searchOption,1000);
                    //dropDown1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
                    WebElement secondSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'k-textbox')]");
                    HelpersMethod.EnterText(driver,secondSearch,1000,Prods.get(j));
                    //Click on Apply button
                    applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button[text()='Apply']");
                    HelpersMethod.ClickBut(driver,applyButton,100);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                    }
                    //Select the product from catalog
                    WebElement prod= HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]");
                    HelpersMethod.ActClick(driver,prod,1000);
                    scenario.log("PRODUCT FOUND IN CATALOG IS "+Prods.get(j));
                }
            }
        }
        catch (Exception e){}
    }

    public void cardView(String prod)
    {
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            //enter product number in input box
            WebElement inputBox = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
            HelpersMethod.EnterText(driver,inputBox,1000,prod);
            //Click on search icon
            WebElement  searchIcon = HelpersMethod.FindByElement(driver, "xpath", "//span[@datatestid='searchBarSearchBtn']//*[local-name()='svg']");
            HelpersMethod.ActClick(driver, searchIcon, 10000);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 250000);
            }
            //add product to standing order
            WebElement selectButton = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item']/descendant::button[text()='Select']");
            HelpersMethod.ScrollElement(driver, selectButton);
            HelpersMethod.ClickBut(driver, selectButton, 2000);
            scenario.log("PRODUCT FOUND IN CATALOG IS "+prod);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }

            //Click on 'x' button in catalog
            WebElement clearButton = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='searchBarClearBtn']");
            HelpersMethod.ScrollElement(driver,clearButton);
            act.moveToElement(clearButton).click().build().perform();
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
        }
        catch (Exception e){}
    }

    public void CatalogOKButton()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Ok')]");
                HelpersMethod.ActClick(driver,WebEle,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void MultipleQtyProducts(List<List<String>> qtys)
    {
        exists=false;
        int k=0;
        WebElement WebEle=null;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-grid')]");
            HelpersMethod.ScrollElement(driver, WebEle);
            for (int i = 0; i < qtys.size(); i++)
            {
                for (int j = 0; j < qtys.get(i).size(); j++)
                {
                    if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][" + (i + 1) + "]/td[contains(@class,'cell')][" + (j + 1) + "]/descendant::input", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][" + (i + 1) + "]/td[contains(@class,'cell')][" + (j + 1) + "]/descendant::input");
                        HelpersMethod.ActSendKey(driver, WebEle, 1000, qtys.get(i).get(j));
                    }
                }
            }
        }
        catch (Exception e){}
    }
    public void ReadProductNoInGrid()
    {
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
        //To zoom out browser by 67%
        if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom='67%'");
        }
        else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
        {
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("document.body.style.MozTransform='67%'");
        }
        exists=false;
        Actions act=new Actions(driver);
        String head_text;
        int i=0;
        try
        {
            List<WebElement> heads= HelpersMethod.FindByElements(driver,"xpath","//thead/tr[contains(@style,'touch-action')]/th");
            for (WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                head_text=head.getText();
                if(head_text.equals("Product Number"))
                {
                    Prod_No=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::td["+i+"]").getText();

                    exists=true;
                    break;
                }
            }
            if(exists==false)
            {
                scenario.log("PRODUCT NUMBER HEADER IS NOT FOUND");
            }
            scenario.log("PRODUCT NUMBER FOUND IN GRID IS : "+Prod_No);
            //To zoom in browser back to 100%
            if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("chrome")|TestBase.testEnvironment.get_browser().equalsIgnoreCase("edge"))
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.body.style.zoom='100%'");
            }
            else if(TestBase.testEnvironment.get_browser().equalsIgnoreCase("firefox"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='100%'");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnCheckboxOfProductNo()
    {
        exists=false;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::input[@class='k-checkbox']");
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.ClickBut(driver,WebEle,1000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickDeleteProduct()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(DeleteProd.isDisplayed() && DeleteProd.isEnabled())
            {
                HelpersMethod.ClickBut(driver,DeleteProd,4000);
                if(HelpersMethod.IsExists("//div[contains(text(),'Delete product(s)')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                    HelpersMethod.ClickBut(driver,WebEle,1000);
                    scenario.log("PRODUCT HAS BEEN DELETED FROM STANDING ORDER");
                    exists=true;
                    //loading Icon
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnSkipSpecificDay()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            SkipSpecificdays=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@data-test-id,'skipDeliveryDaysStandingOrderBtn')]");
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOf(SkipSpecificdays));
            HelpersMethod.ScrollElement(driver,SkipSpecificdays);
            HelpersMethod.ClickBut(driver,SkipSpecificdays,20000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateSkipPopup()
    {
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",20000);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath" ,"//div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Skip", "Verify Title message");
            scenario.log("SKIP DAY POPUP HAS BEEN FOUND");
        }
        catch (Exception e){}
    }

    //Click on Skip reason dropdown
    public void ClickOnSkipReason()
    {
        exists=false;
        WebElement WebEle=null;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","skipReason");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            List<WebElement> reasons=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            for(WebElement reason:reasons)
            {
                i++;
                act.moveToElement(reason).build().perform();
                if(i==1)
                {
                    act.moveToElement(reason).build().perform();
                    act.click().build().perform();
                    exists=true;
                    break;
                }
            }

            //loading Icon
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectDateToSkip(int days)
    {
        exists=false;
        WebElement WebEle=null;
        int length;
        try
        {
            WebElement ele1;
            String formattedDate1 = null;
            LocalDate myDateObj = LocalDate.now().plusDays(days);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            formattedDate1 = myDateObj.format(myFormatObj);
            //code to be executed when the date is visible in existing calender
            if(HelpersMethod.IsExists("//td[contains(@style,'opacity:')]/span[contains(@title,'" + formattedDate1 +"')]",driver))
            {
                if (!HelpersMethod.IsExists("//td[contains(@style,'opacity:')]/span[@class='k-link-disabled' and contains(@title,'" + formattedDate1 + "')]", driver))
                {
                    ele1 = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@style,'opacity:')]/span[contains(@title,'" + formattedDate1 + "')]");
                    HelpersMethod.waitTillElementDisplayed(driver, ele1, 10000);
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ClickBut(driver, ele1, 1000);
                    scenario.log("SKIP DATE IS "+formattedDate1);
                }
                else
                {
                    myDateObj = LocalDate.now().plusDays(11);
                    myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                    formattedDate1 = myDateObj.format(myFormatObj);
                    ele1 = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@style,'opacity:')]/span[contains(@title,'" + formattedDate1 + "')]");
                    HelpersMethod.waitTillElementDisplayed(driver, ele1, 10000);
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ClickBut(driver, ele1, 1000);
                    scenario.log("SKIP DATE IS "+formattedDate1);
                }
            }
            else
            {
                //if the date is not present in visible calender, click on arrow button to navigate to next month
                if(HelpersMethod.IsExists("//button[contains(@class,'k-nav-next')]/span[contains(@class,'k-i-arrow-chevron-right')]",driver))
                {
                    //Click on Arrow in calender, when date has not been found in visible calender
                    WebElement arrow=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'k-nav-next')]/span[contains(@class,'k-i-arrow-chevron-right')]");
                    HelpersMethod.ClickBut(driver,arrow,1000);
                    if(!HelpersMethod.IsExists("//td[contains(@style,'opacity:')]/span[@class='k-link-disabled' and contains(@title,'" + formattedDate1 +"')]",driver))
                    {
                        ele1 = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@style,'opacity:')]/span[contains(@title,'" + formattedDate1 + "')]");
                        HelpersMethod.waitTillElementDisplayed(driver, ele1, 40000);
                        HelpersMethod.JSScroll(driver, ele1);
                        HelpersMethod.ClickBut(driver, ele1, 1000);
                        scenario.log("SKIP DATE IS "+formattedDate1);
                    }
                    else
                    {
                        myDateObj = LocalDate.now().plusDays(11);
                        myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                        formattedDate1 = myDateObj.format(myFormatObj);
                        ele1 = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(@style,'opacity:')]/span[contains(@title,'" + formattedDate1 + "')]");
                        HelpersMethod.waitTillElementDisplayed(driver, ele1, 40000);
                        HelpersMethod.JSScroll(driver, ele1);
                        HelpersMethod.ClickBut(driver, ele1, 1000);
                        scenario.log("SKIP DATE IS "+formattedDate1);
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void SkipOkButton() throws InterruptedException
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            WebElement okButton = modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
            HelpersMethod.ClickBut(driver, okButton, 1000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void SkipConfirmation()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Delivery skip details saved')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement confirmDialog=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=confirmDialog.findElement(By.xpath(".//button[text()='OK']"));
                HelpersMethod.ClickBut(driver,okButton,8000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            //Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String readSkipDate()
    {
        String skipDate = null;
        WebElement WebEle;
        try
        {
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/td[1]"));
            HelpersMethod.ScrollElement(driver, WebEle);
            skipDate = WebEle.getText();
        }
        catch (Exception e){}
        return skipDate;
    }

    public void RemoveSkipDate()
    {
        exists=false;
        WebElement WebEle=null;
        Actions act1=new Actions(driver);
        String status=null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/td[1]");
            HelpersMethod.ScrollElement(driver,WebEle);
            scenario.log("SKIP CANCEL HAS BEEN DONE ON :"+WebEle.getText());
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/td[2]/button//*[local-name()='svg']");
            Thread.sleep(800);
            act1.moveToElement(WebEle).build().perform();
            act1.click(WebEle).build().perform();
            exists=true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) { }
    }

    public void ValidateCardView() throws InterruptedException
    {
        try {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'product-catalog-container')]", driver))
            {
                WebElement WebEle;
                WebElement Catelog = HelpersMethod.FindByElement(driver, "id", "CPcategories");
                WebElement SubCate = HelpersMethod.FindByElement(driver, "id", "CPbrands");
                WebElement Brand = HelpersMethod.FindByElement(driver, "id", "CPsizes");
                String Cate = null;
                exists = false;

                if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'product-catalog-container')]", driver)) {
                    //Read the category value of first product in catalog
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box'][1]/descendant::span[text()='Category']/following-sibling::span");
                    Cate = WebEle.getText();

                    //Click on category drop down
                    HelpersMethod.ClickBut(driver, Catelog, 1000);
                    HelpersMethod.DropDownMenu(driver, Cate);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }

                    //Click on SubCategory Drop down
                    HelpersMethod.ClickBut(driver, SubCate, 1000);
                    if (HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::li[2]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::li[2]");
                        HelpersMethod.ActClick(driver, WebEle, 1000);
                    }
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }

                    //Click on Brand
                    HelpersMethod.ClickBut(driver, Brand, 1000);
                    if (HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::li[2]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::li[2]");
                        HelpersMethod.ActClick(driver, WebEle, 2000);
                    }
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }

                    exists = true;
                }
            } else {
                scenario.log("CATALOG IS NOT DISPLAYING IN CARD VIEW");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void CardViewProdSelection()
    {
        WebElement WebEle;
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                scenario.log("CATALOG IS DISPLAYED IN GRID VIEW, PLEASE CHECK ADMIN SETTING ");
            }
            else
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box'][1]/descendant::button");
                HelpersMethod.ClickBut(driver, WebEle, 1000);
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ListAllProdInGrid()
    {
        try
        {
            exists = false;
            if(TestBase.testEnvironment.get_browser().equals("chrome")||TestBase.testEnvironment.get_browser().equals("edge"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.zoom='67%'");
            }
            else
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='67%'");
            }
            scenario.log("PRODUCTS FOUND IN STANDING ORDER:");
            List<WebElement> ProductsLists = HelpersMethod.FindByElements(driver, "xpath", "//tr[contains(@class,'k-master-row')]/td[2]");
            for (WebElement Prod : ProductsLists)
            {
                String Prod_Text = Prod.getText();
                scenario.log(Prod_Text);
                exists = true;
            }
            if(TestBase.testEnvironment.get_browser().equals("chrome")||TestBase.testEnvironment.get_browser().equals("edge"))
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.zoom='100%'");
            }
            else
            {
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("document.body.style.MozTransform='100%'");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ValidityDate()
    {
        try
        {
            WebElement validationDate = HelpersMethod.FindByElement(driver, "xpath", "//label[contains(@class,'cart-title-standing-order')]");
            scenario.log("STANDING ORDER AND VLIDITY PERIOD: " + validationDate.getText());
        }
        catch (Exception e){}
    }

    public void navigateToStandingOrder()
    {
        try
        {
            exists = false;
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                String Menu_Text=null;
                Actions act=new Actions(driver);
                List<WebElement> MenuBar=HelpersMethod.FindByElements(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link']");
                for(WebElement Menu:MenuBar)
                {
                    act.moveToElement(Menu).build().perform();
                    Menu_Text=Menu.getText();
                    if(Menu_Text.contains("Standing Orders")||Menu_Text.contains("Standing orders"))
                    {
                        WebElement menuItem=HelpersMethod.FindByElement(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'All orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]");
                        HelpersMethod.JScriptClick(driver,menuItem,1000);
                        break;
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
        }
        catch (Exception e){}
    }

    public void validateCurrentweek()
    {
        exists = false;
        String currentWeek = null;
        try
        {
            currentWeek = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'i-summary-area__main__value')]").getText();
            if (currentWeek.equals("Even week"))
            {
                exists = true;
            }
        }
        catch (Exception e){}
    }

    public void validateDeliverySchedule()
    {
        exists = false;
        String deliverySch = null;
        try
        {
            deliverySch = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='frequency']/span[@class='k-input']").getText();
            if (deliverySch.equals("Every week"))
            {
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void Refresh_Page(String currentURL)
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000000));
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
                //navigate to Standing order
                driver.navigate().to(currentURL);
                scenario.log("STANDING ORDER PAGE HAS BEEN FOUND");
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
           /* if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000000);
            }*/
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void SearchProductSingleProd()
    {
        exists = false;
        WebElement WebEle=null;
        Actions act1=new Actions(driver);
        try
        {
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                //to load all the products in catalog
                if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
                {
                    WebElement loadProducts=HelpersMethod.FindByElement(driver,"xapth","//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver,loadProducts,4000);
                }

                //Click on 'Add filter'
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = catalogPopup.findElement(By.xpath("//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
                HelpersMethod.clickOn(driver, WebEle, 2000);

                //Click on clear all
                WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
                WebElement clearAll=dropDown.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::button[contains(text(),'Clear all')]"));
                if(clearAll.isDisplayed() && clearAll.isEnabled())
                {
                    HelpersMethod.ActClick(driver,clearAll,2000);
                    //Click on Add filter again
                    HelpersMethod.clickOn(driver, WebEle, 2000);
                }
                //Enter value in 1st input
                WebElement fistSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
                HelpersMethod.EnterText(driver,fistSearch,2000,"Product #");
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","ProductNumber");
                HelpersMethod.ActClick(driver,checkBox,2000);
                WebElement secondSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'k-textbox')]");
                HelpersMethod.EnterText(driver,secondSearch,2000,Prod_No);
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button[text()='Apply']");
                HelpersMethod.ClickBut(driver,applyButton,2000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                scenario.log("PRODUCT FOUND IN CATALOG IS "+Prod_No);
                exists=true;
            }
            else
            {
                //enter product number in input box
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
                HelpersMethod.EnterText(driver, WebEle, 2000, Prod_No);
                scenario.log(WebEle.getText()+"PRODUCT# ENTERED FOR SEARCH");
                Thread.sleep(1000);
                String autoValueText;
                List<WebElement> autoComplete=driver.findElements(By.xpath("//div[@id='react-autowhatever-searchBarAutoSuggest']/ul/li/descendant::span[@class='product-number']"));
                for(WebElement autoValue:autoComplete)
                {
                    act1.moveToElement(autoValue).build().perform();
                    autoValueText=autoValue.getText();
                    if(autoValueText.contains(Prod_No))
                    {
                        act1.moveToElement(autoValue).click().build().perform();
                        break;
                    }
                }

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                scenario.log("PRODUCT FOUND IN CATALOG IS "+Prod_No);
                exists=true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void validateProductSelectedOrNot()
    {
        exists=false;
        try
        {
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row k-state-selected')]",driver))
                {
                    scenario.log("PRODUCT IS ALREADY SELECTED, IN GRID VIEW");
                    exists=true;
                }
            }
            else
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Select' and contains(@class,'k-state-disabled')]",driver))
                {
                    scenario.log("PRODUCT IS ALREADY SELECTED, IN CARD VIEW. AND SELECT BUTTON IS DISABLED");
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateEndDate()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//label[contains(@class,'cart-title-standing-order')]",driver))
            {
                String titleCard=HelpersMethod.FindByElement(driver,"xpath","//label[contains(@class,'cart-title-standing-order')").getText();
                if(titleCard.toLowerCase().contains("no end date"))
                {
                    scenario.log("STANDING ORDER CREATED WITHOUT END DATE!!!");
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateStandingOrder()
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
                WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            String titleSO=driver.getTitle();
            if(titleSO.contains("Standing Order"))
            {
                scenario.log("STANDING ORDER PAGE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void orderAlreadyExists()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'To skip this dates')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement dialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'To skip this dates')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=dialogBox.findElement(By.xpath(".//button[text()='OK']"));
                HelpersMethod.ClickBut(driver,okButton,2000);
                scenario.log("************ YOU NEED TO REMOVE ORDER TO SKIP SELECTED DATE *****************");
            }
            else
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}