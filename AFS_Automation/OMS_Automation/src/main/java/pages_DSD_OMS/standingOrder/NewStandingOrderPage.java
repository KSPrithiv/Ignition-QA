package pages_DSD_OMS.standingOrder;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.Catalog.ProductDescriptionPage;
import util.DataBaseConnection;
import util.TestBase;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @FindBy(xpath="//button[text()='Skip specific days']")
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
                        HelpersMethod.JScriptClick(driver, menuItem, 100);
                        exists=true;
                        break;
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
        //loading Icon
      /*  if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
        }*/
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
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","card2");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(QuickProduct.isDisplayed() && QuickProduct.isEnabled())
            {
                //Enter Qty in quick inputbox
                String Pro = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
                HelpersMethod.ActSendKey(driver, QuickProduct, 80, Pro);
                QuickProduct.sendKeys(Keys.TAB);
                QuickProduct.sendKeys(Keys.TAB);

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
                        HelpersMethod.ActSendKey(driver,WebEle,20,days.get(0).get(j));
                        j++;
                    }
                }
            }
        }
        catch (Exception e){}
    }

//For Clicking on Save button
    public void ClickSaveButton()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(SaveButton.isDisplayed() && SaveButton.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,SaveButton);
                HelpersMethod.ClickBut(driver,SaveButton,200);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
                }

                if(HelpersMethod.IsExists("//div[text()='Success']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement OkButton=WebEle.findElement(By.xpath(".//button"));
                    HelpersMethod.ClickBut(driver,OkButton,400);
                    exists=true;
                }
                HelpersMethod.WaitElementPresent(driver,"id","card2",200);
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"id","card2",200);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnAddProductButton()
    {
        exists=false;
        WebElement WebEle=null;
        new WebDriverWait(driver,100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add product')]")));
        try
        {
            if(AddProduct.isDisplayed() && AddProduct.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,AddProduct);
                HelpersMethod.ActClick(driver,AddProduct,100);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]",driver))
                {
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }
                    //Click on Add filter button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[contains(text(),'Add filter')]");
                    new WebDriverWait(driver,100).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
                    HelpersMethod.ScrollElement(driver,WebEle);
                    HelpersMethod.JScriptClick(driver, WebEle, 80);

                    //Click on Clear all button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container')]/descendant::button[contains(text(),'Clear all')]");
                    new WebDriverWait(driver,100).until(ExpectedConditions.elementToBeClickable(WebEle));
                    if (WebEle.isDisplayed() && WebEle.isEnabled())
                    {
                        HelpersMethod.JScriptClick(driver, WebEle, 80);
                        //loading Icon
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                        }
                    }
                    else
                    {
                        //Click on Add filter button, if 'Clear all' is disabled, we should close add filter
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[contains(text(),'Add filter')]");
                        HelpersMethod.ActClick(driver, WebEle, 80);
                    }
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchProduct()
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
                    HelpersMethod.ActClick(driver,loadProducts,100);
                }

                //Click on 'Add filter'
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = catalogPopup.findElement(By.xpath("//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
                HelpersMethod.clickOn(driver, WebEle, 80);

                //Click on clear all
                    WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
                    WebElement clearAll=dropDown.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::button[contains(text(),'Clear all')]"));
                    if(clearAll.isDisplayed() && clearAll.isEnabled())
                    {
                        HelpersMethod.ActClick(driver,clearAll,200);
                        //Click on Add filter again
                        HelpersMethod.clickOn(driver, WebEle, 80);
                    }
                    //Enter value in 1st input
                WebElement fistSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
                HelpersMethod.EnterText(driver,fistSearch,100,"Product #");
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","ProductNumber");
                HelpersMethod.ActClick(driver,checkBox,100);
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button[text()='Apply']");
                HelpersMethod.ClickBut(driver,applyButton,100);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                }
                //Enter product numbers to be searched
                for(int j=0;j<=Prods.size()-1;j++)
                {
                    //click on filter option button
                    WebElement searchOption=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'i-filter-tag__main')]");
                    HelpersMethod.ClickBut(driver,searchOption,100);
                    //dropDown1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
                    WebElement secondSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'k-textbox')]");
                    HelpersMethod.EnterText(driver,secondSearch,100,Prods.get(j));
                    //Click on Apply button
                    applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button[text()='Apply']");
                    HelpersMethod.ClickBut(driver,applyButton,100);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
                    }
                    //Select the product from catalog
                    WebElement prod= HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]");
                    HelpersMethod.ActClick(driver,prod,100);
                    scenario.log("PRODUCT FOUND IN CATALOG IS "+Prods.get(j));
                }
            }
            else //card view //if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'product-catalog-container')]", driver))
            {
                for (int j=0;j<=Prods.size()-1;j++)
                {
                    //enter product number in input box
                    WebElement inputBox = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
                    HelpersMethod.sendKeys(driver, inputBox, 8000, Prods.get(j));

                    //Click on search icon
                    WebElement  searchIcon = HelpersMethod.FindByElement(driver, "xpath", "//span[@datatestid='searchBarSearchBtn']//*[local-name()='svg']");
                    HelpersMethod.ActClick(driver, searchIcon, 10000);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 250000);
                    }
                    //add product to standing order
                    selectButton = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item']/descendant::button[text()='Select']");
                    HelpersMethod.ScrollElement(driver, selectButton);
                    HelpersMethod.ClickBut(driver, selectButton, 2000);
                    scenario.log("PRODUCT FOUND IN CATALOG IS "+Prods.get(j));
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                    }
                    //Click on 'x' button in catalog
                    clearButton = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='searchBarClearBtn']//*[local-name()='svg']");
                    act.moveToElement(clearButton).click().build().perform();
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500000);
                    }
                }
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
                HelpersMethod.ActClick(driver,WebEle,40);
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
                        HelpersMethod.ActSendKey(driver, WebEle, 100, qtys.get(i).get(j));
                    }
                }
            }
        }
        catch (Exception e){}
    }
    public void ReadProductNoInGrid()
    {
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
            HelpersMethod.ClickBut(driver,WebEle,80);
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
                HelpersMethod.ClickBut(driver,DeleteProd,40);
                if(HelpersMethod.IsExists("//div[contains(text(),'Delete product(s)')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                    HelpersMethod.ClickBut(driver,WebEle,40);
                    scenario.log("PRODUCT HAS BEEN DELETED FROM STANDING ORDER");
                    exists=true;
                    //loading Icon
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
            HelpersMethod.ScrollElement(driver,SkipSpecificdays);
            HelpersMethod.ClickBut(driver,SkipSpecificdays,60);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",200);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath" ,"//div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Skip", "Verify Title message");
        }
        catch (Exception e){}
    }

    //Click on Skip reason dropdown
    public void ClickOnSkipReason()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","skipReason");
            HelpersMethod.ClickBut(driver,WebEle,60);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//ul[@class='k-list k-reset']/li[1]");
            HelpersMethod.ActClick(driver,WebEle,60);

            exists=true;
            //loading Icon
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectDateToSkip()
    {
        exists=false;
        WebElement WebEle=null;
        int length;
        try
        {
            List<WebElement> Dates=HelpersMethod.FindByElements(driver,"xpath","//td[contains(@style,'opacity: 1; cursor: pointer;')]/span[@class='k-link']");
            length=Dates.size();
            HelpersMethod.ClickBut(driver,Dates.get(length-4),60);
            scenario.log("DATE HAS BEEN SELECTED: "+ Dates.get(length-4).getAttribute("title"));
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SkipOkButton() throws InterruptedException
    {
        exists=false;
        try {
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]", 100);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

            WebElement okButton = modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
            HelpersMethod.ClickBut(driver, okButton, 200);
            exists = true;
        /*if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }*/
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void SkipConfirmation()
    {
        exists=false;
        WebElement WebEle=null;
        /*if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 6000);
        }*/
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Delivery skip details saved')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ClickBut(driver,WebEle,600);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                }

            }
            Assert.assertEquals(exists,true);
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
                    HelpersMethod.ClickBut(driver, Catelog, 200);
                    HelpersMethod.DropDownMenu(driver, Cate);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }

                    //Click on SubCategory Drop down
                    HelpersMethod.ClickBut(driver, SubCate, 200);
                    if (HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::li[2]", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::li[2]");
                        HelpersMethod.ActClick(driver, WebEle, 200);
                    }
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }

                    //Click on Brand
                    HelpersMethod.ClickBut(driver, Brand, 200);
                    if (HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::li[2]", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::li[2]");
                        HelpersMethod.ActClick(driver, WebEle, 2000);
                    }
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver)) {
                scenario.log("CATALOG IS DISPLAYED IN GRID VIEW, PLEASE CHECK ADMIN SETTING ");
            } else {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box'][1]/descendant::button");
                HelpersMethod.ClickBut(driver, WebEle, 40);
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
                        HelpersMethod.JScriptClick(driver,menuItem,100);
                        break;
                    }
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
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
                WebDriverWait wait = new WebDriverWait(driver, 100);
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
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
            }
        }
        catch (Exception e){}
    }

    public void SearchProductSingleProd()
    {
        exists = false;
        WebElement WebEle=null;
        try
        {
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                //to load all the products in catalog
                if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
                {
                    WebElement loadProducts=HelpersMethod.FindByElement(driver,"xapth","//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver,loadProducts,100);
                }

                //Click on 'Add filter'
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle = catalogPopup.findElement(By.xpath("//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
                HelpersMethod.clickOn(driver, WebEle, 80);

                //Click on clear all
                WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
                WebElement clearAll=dropDown.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::button[contains(text(),'Clear all')]"));
                if(clearAll.isDisplayed() && clearAll.isEnabled())
                {
                    HelpersMethod.ActClick(driver,clearAll,200);
                    //Click on Add filter again
                    HelpersMethod.clickOn(driver, WebEle, 80);
                }
                //Enter value in 1st input
                WebElement fistSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
                HelpersMethod.EnterText(driver,fistSearch,100,"Product #");
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","ProductNumber");
                HelpersMethod.ActClick(driver,checkBox,100);
                WebElement secondSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'k-textbox')]");
                HelpersMethod.EnterText(driver,secondSearch,100,Prod_No);
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button[text()='Apply']");
                HelpersMethod.ClickBut(driver,applyButton,100);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
                scenario.log("PRODUCT FOUND IN CATALOG IS "+Prod_No);
                exists=true;
            }
            else
            {
                    //enter product number in input box
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
                    HelpersMethod.ActSendKey(driver, WebEle, 80, Prod_No);

                    //Click on search icon
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button-addon search-button input-group-addon')]//*[local-name()='svg']");
                    HelpersMethod.ActClick(driver, WebEle, 80);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
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
}
