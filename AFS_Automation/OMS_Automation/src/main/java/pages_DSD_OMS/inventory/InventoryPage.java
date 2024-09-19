package pages_DSD_OMS.inventory;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.DataBaseConnection;
import util.TestBase;

import java.time.Duration;
import java.util.List;

public class InventoryPage
{
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String runningTotalUnits;
    int totalUitsValue;
    int headIndex=0;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-grouping-drop-container')]")
    private WebElement To;

    @FindBy(id="addProductsBtn")
    private WebElement addProdBtn;

    @FindBy(id="saveStoreInventoryBtn")
    private WebElement saveButton;

    @FindBy(id="quickProduct")
    private WebElement quickProduct;

    @FindBy(id="quickCases")
    private WebElement quickCase;

    @FindBy(id="quickUnits")
    private WebElement quickUnit;

    @FindBy(id="quickSequence")
    private WebElement quickSequence;

    @FindBy(id="selectInventoryDay")
    private  WebElement selectInventory;

    @FindBy(id="cancelStoreInventoryBtn")
    private WebElement cancleButton;

    public InventoryPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
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
                NavigateToInventory();
            }
        }
        catch (Exception e) {}
    }

  /*  public void Refresh_Page()
    {
        driver.navigate().to(currentURL);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
    }*/

    public void NavigateToInventory()
    {
        exists=false;
        String Header="";
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }

            Header=HelpersMethod.FindByElement(driver,"xpath","//ul[@class='k-tabstrip-items k-reset']/li/span[@class='k-link' and text()='Inventory']").getText();
            Assert.assertEquals(Header,"Inventory");
        }
        catch (Exception e){}
    }

    public boolean ValidateInventory()
    {
        exists=false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            if(HelpersMethod.gettingURL(driver).contains("cpInventory"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    public void DragAndDropInInventory(String To_Text)
    {
        exists = false;
        try
        {
            WebElement ProdGrid = HelpersMethod.FindByElement(driver, "id", "store-inventory-grid-wrapper");
            HelpersMethod.ScrollElement(driver, ProdGrid);
            if (HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-grouping-drop-container')]", driver))
            {
                List<WebElement> TableHeads = driver.findElements(By.xpath("//thead/tr[1]/th"));
                for (WebElement THead : TableHeads)
                {
                    String Head = THead.getText();
                    if (Head.equals(To_Text))
                    {
                        HelpersMethod.ActDragDrop(driver, THead, To);
                        exists = true;
                    }
                }
            }
            else
            {
                scenario.log("DRAG AND DROP HEADER MAY NOT BE ENABLED, CHECK ADMIN SETTINGS");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void readGroupingValue()
    {
        try
        {
            List<WebElement> groups=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-grouping-row']/td[1]/span");
            for(WebElement group:groups)
            {
                scenario.log("GROUP VALUE IS "+group.getText());
            }
        }
        catch (Exception e){}
    }

    public void navigateToStoreInventoryTab()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Store inventory')]",driver))
            {
                if (!HelpersMethod.IsExists("//span[contains(text(),'Store inventory')]/parent::li[contains(@class,'active')]", driver))
                {
                    WebElement storeTab=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Store inventory')]/parent::li");
                    HelpersMethod.ActClick(driver,storeTab,1000);
                }
                if (HelpersMethod.IsExists("//span[contains(text(),'Store inventory')]/parent::li[contains(@class,'active')]", driver))
                {
                    scenario.log("STORE INVENTORY TAB IS SELECTED");
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnAddProd()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(addProdBtn.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,addProdBtn);
                HelpersMethod.ClickBut(driver, addProdBtn, 10000);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCatalogPopup()
    {
        exists=false;
        String status;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[text()='Products']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("PRODUCT DIALOG HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void loadProducts()
    {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        //to load all the products in catalog
        if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
        {
            WebElement loadProducts=driver.findElement(By.xpath("//div[@class='k-window k-dialog']/descendant::span[contains(text(),'load all products')]"));
            HelpersMethod.ScrollElement(driver,loadProducts);
            HelpersMethod.JScriptClick(driver,loadProducts,10000);

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
        }
    }

    public void ListView(List<List<String>> qtyValue)
    {
        exists = false;
        WebElement WebEle;
        String prodValue;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            List<String> Prods = DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql1());
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(1000);
            //Click on 'Add filter'
            WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Products']/ancestor::div[contains(@class,'k-window k-dialog')]");
            WebEle = catalogPopup.findElement(By.xpath(".//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
            HelpersMethod.clickOn(driver, WebEle, 10000);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='k-animation-container k-animation-container-shown']")));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-animation-container k-animation-container-shown']")));

            //Click on clear all
            WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-shown')]");
            WebElement clearAll=dropDown.findElement(By.xpath(".//span[contains(text(),'Clear all')]/parent::button"));
            if(!HelpersMethod.IsExists("//span[contains(text(),'Clear all')]/parent::button[contains(@class,'disabled')]",driver))
            {
                HelpersMethod.ActClick(driver,clearAll,10000);
                //Click on Add filter again
                HelpersMethod.clickOn(driver, WebEle, 10000);
            }
            //Enter value in 1st input
            WebElement fistSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-filter-popup i-filter-popup--add')]/descendant::input[contains(@class,'i-search-box__input')]");
            HelpersMethod.EnterText(driver,fistSearch,10000,"Product #");
            //Click on check box
            WebElement checkBox=HelpersMethod.FindByElement(driver,"id","ProductNumber");
            HelpersMethod.ActClick(driver,checkBox,10000);
            //Click on Apply button
            WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button/span[text()='Apply']");
            HelpersMethod.ActClick(driver,applyButton,10000);

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            //Enter product numbers to be searched
            for(int j=0;j<=Prods.size()-1;j++)
            {
                    prodValue= Prods.get(j);
                    //Click on Add filter again
                    catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Products']/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebEle = catalogPopup.findElement(By.xpath(".//span[contains(text(),'Product')]/parent::button[@class='i-filter-tag__main']"));
                    HelpersMethod.ActClick(driver, WebEle, 10000);
                    new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-animation-container k-animation-container-shown']"))));
                    new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-animation-container k-animation-container-shown']"))));

                    Thread.sleep(1000);
                    WebElement secondSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container-shown')]/descendant::input[@class='k-input k-input-md k-rounded-md k-input-solid']");
                    HelpersMethod.EnterText(driver, secondSearch, 20000, prodValue);

                    //Click on Apply button
                    applyButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container-shown')]/descendant::button/span[text()='Apply']");
                    HelpersMethod.ActClick(driver, applyButton, 10000);

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                  enterQtyForProducts(qtyValue.get(j).get(0),qtyValue.get(j).get(1));
                  scenario.log("PRODUCT FOUND IN CATALOG IS "+Prods.get(j));
            }
        }
        catch (Exception e){}
    }

    public void enterQty(List<List<String>> qtyValue)
    {
        Actions act=new Actions(driver);
        String headTitle;
        String qtyUnit;
        String qtyCases;
        WebElement qtyInput;
        int i=0;
        try
        {
            for(int j=1;j<=3;j++)
            {
                i=0;
                List<WebElement> heads = HelpersMethod.FindByElements(driver, "xpath", "//span[@class='k-column-title']");
                for (WebElement head : heads)
                {
                    i++;
                    act.moveToElement(head).build().perform();
                    headTitle = head.getText();
                    if (headTitle.equals("Cases"))
                    {
                        if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][" + j + "]/descendant::td[" + i + "]/descendant::input", driver))
                        {
                            qtyCases = qtyValue.get(j - 1).get(0);
                            qtyInput = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][" + j + "]/descendant::td[" + i + "]/descendant::input");
                            qtyInput.click();
                            HelpersMethod.EnterText(driver, qtyInput, 10000, qtyCases);
                            qtyInput.sendKeys(Keys.TAB);
                        }
                        break;
                    }
                }
                i = 0;
                heads = HelpersMethod.FindByElements(driver, "xpath", "//span[@class='k-column-title']");
                for (WebElement head : heads)
                {
                    i++;
                    act.moveToElement(head).build().perform();
                    headTitle = head.getText();
                    if (headTitle.equals("Units"))
                    {
                        if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]["+j+"]/descendant::td[" + i + "]/descendant::input", driver))
                        {
                            qtyUnit=qtyValue.get(j-1).get(1);
                            qtyInput = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]["+j+"]/descendant::td[" + i + "]/descendant::input");
                            qtyInput.click();
                            HelpersMethod.EnterText(driver, qtyInput, 10000, qtyUnit);
                            qtyInput.sendKeys(Keys.TAB);
                        }
                        break;
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void enterQtyForProducts(String unit,String cases)
    {
        Actions act=new Actions(driver);
        String headTitle;
        WebElement qtyInput;
        int i=0;
        try
        {
            List<WebElement> heads = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headTitle=head.getText();
                if(headTitle.equals("Cases"))
                {
                    if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::td["+i+"]/descendant::input",driver))
                    {
                        qtyInput = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::td[" + i + "]/descendant::input");
                        HelpersMethod.EnterText(driver, qtyInput, 10000, unit);
                        qtyInput.sendKeys(Keys.TAB);
                    }
                    break;
                }
            }
            i=0;
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headTitle=head.getText();
                if(headTitle.equals("Units"))
                {
                    if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::td["+i+"]/descendant::input",driver))
                    {
                        qtyInput = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::td[" + i + "]/descendant::input");
                        HelpersMethod.EnterText(driver, qtyInput, 10000,cases);
                        qtyInput.sendKeys(Keys.TAB);
                    }
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void cardView(List<List<String>> qtyValue, String prod, int i)
    {
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
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
            //add product
            if(HelpersMethod.IsExists("//div[contains(@id,'gridItemBox')]",driver))
            {
                if (HelpersMethod.IsExists("//div[contains(text(),'Unit')]/descendant::input",driver))
                {
                    WebElement unitInput=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Unit')]/descendant::input");
                    HelpersMethod.JSSetValueEle(driver,unitInput,100,qtyValue.get(0).get(i));
                    unitInput.sendKeys(Keys.TAB);
                }
                if (HelpersMethod.IsExists("//div[contains(text(),'Cases')]/descendant::input",driver))
                {
                    WebElement caseInput=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Case')]/descendant::input");
                    HelpersMethod.JSSetValueEle(driver,caseInput,100,qtyValue.get(i).get(1));
                    caseInput.sendKeys(Keys.TAB);
                }
            }
            else //if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(text(),'No data available')]",driver))
            {
                scenario.log("PRODUCT IS NOT AVAIALBE");
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

    public void clickOnCatalogOkButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[text()='Products']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement productPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Products']/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=productPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver,okButton,10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickSaveButton()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(saveButton.isDisplayed() && saveButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,saveButton,10000);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterQuickProduct()
    {
        exists=false;
        try
        {
            if(quickProduct.isDisplayed())
            {
                String prod=TestBase.testEnvironment.getSingle_Prod_Sql();
                HelpersMethod.ClearText(driver,quickProduct,10000);
                HelpersMethod.EnterText(driver,quickProduct,10000,prod);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterQuickCases(String cases)
    {
        exists=false;
        try
        {
            if(quickCase.isDisplayed() && quickCase.isEnabled())
            {
                HelpersMethod.EnterText(driver,quickCase,1000,cases);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterQuickUnit(String unit)
    {
        exists=false;
        try
        {
            if(quickUnit.isDisplayed() && quickUnit.isEnabled())
            {
                HelpersMethod.EnterText(driver,quickUnit,10000,unit);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterSequenceNo(String sequence)
    {
        exists=false;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            if(quickSequence.isDisplayed() && quickSequence.isEnabled())
            {
                HelpersMethod.EnterText(driver,quickSequence,1000,sequence);
                exists=true;
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnStoreInventory()
    {
        exists=false;
        try
        {
            if(selectInventory.isDisplayed() && selectInventory.isEnabled())
            {
                HelpersMethod.ClickBut(driver,selectInventory,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectStoreInventory()
    {
        exists=false;
        Actions act=new Actions(driver);
        String sListText="";
        try
        {
            List<WebElement> sotreLists=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='selectInventoryDay-listbox-id']/li/span");
            for(WebElement sList:sotreLists)
            {
                act.moveToElement(sList).build().perform();
                sListText=sList.getText();
                if(sListText.equalsIgnoreCase("Today"))
                {
                    act.moveToElement(sList).build().perform();
                    act.click(sList).build().perform();
                    break;
                }
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

        }
        catch (Exception e){}
    }

    public void findTotalUnitsInColumn(String headTable)
    {
        String headText;
        String totalValue;
        Actions act=new Actions(driver);
        exists=false;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for (WebElement head:heads)
            {
                headIndex++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase(headTable))
                {
                    break;
                }
            }
            List<WebElement> totalUnits=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td["+headIndex+"]");
            for(WebElement totalunit:totalUnits)
            {
                act.moveToElement(totalunit).build().perform();
                totalValue=totalunit.getText();
                if(!totalValue.equals(""))
                {
                    totalUitsValue = totalUitsValue + Integer.parseInt(totalValue);
                    exists = true;
                }
            }
            scenario.log("TOTAL OF TOTAL UNITS COLUMN "+totalUitsValue);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void findRunningTotalUnits()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Running total units')]/following-sibling::span",driver))
            {
                runningTotalUnits=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Running total units')]/following-sibling::span").getText();
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void compareTotalUnits()
    {
        exists=false;
        try
        {
            if(Integer.parseInt(runningTotalUnits)==totalUitsValue)
            {
                scenario.log("RUNNING TOTAL UNITS: "+ runningTotalUnits+" TOTAL NUMBER OF UNITS FOUND IN GRID: "+totalUitsValue);
                exists=true;
            }
            scenario.log("RUNNING TOTAL UNITS: "+ runningTotalUnits+" TOTAL NUMBER OF UNITS FOUND IN GRID: "+totalUitsValue);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public boolean listViewProductLoadedAutoloadDisabled()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                scenario.log("DO NOT AUTOLOAD CATALOG, IS DISABLED");
                exists=true;
            }
            else
            {
                scenario.log("AUTO LOAD OF PRODUCT IS ENABLED");
                exists=false;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public boolean listViewProductLoadedAutoloadEnabled()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                scenario.log("DO NOT AUTOLOAD CATALOG, IS DISABLED");
                exists=true;
            }
            else
            {
                scenario.log("AUTO LOAD OF PRODUCT IS ENABLED");
                exists=false;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public boolean cardViewProductLoadedAutoloadDisabled()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                scenario.log("AUTO LOAD OF PRODUCTS IS DISABLED");
                exists=true;
            }
            else
            {
                scenario.log("AUTO LOAD OF PRODUCT IS ENABLED");
                exists=false;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public boolean cardViewProductLoadedAutoloadEnabled()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                scenario.log("AUTO LOAD OF PRODUCTS IS DISABLED");
                exists=true;
            }
            else
            {
                scenario.log("AUTO LOAD OF PRODUCT IS ENABLED");
                exists=false;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public void clickOnResetFilter()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                WebElement loadPoducts=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
                HelpersMethod.ActClick(driver,loadPoducts,20000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if(HelpersMethod.IsExists("//div[@class='k-widget k-window k-dialog']/descendant::tr[@class='k-grid-norecords']",driver))
                {
                        scenario.log("<span style='color:red'> EVEN AFTER CLICKING LOAD PRODUCTS LINK, NOT ABLE TO SEE PRODUCT IN CATALOG</span>");
                }
                else
                {
                        scenario.log("PRODUCTS HAS BEEN SUCCESSFULLY LOADED AFTER CLICKING LOAD PRODUCTS");
                }
            }
            else
            {
                WebElement loadPoducts=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
                HelpersMethod.ActClick(driver,loadPoducts,20000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if(HelpersMethod.IsExists("//div[@class='k-widget k-window k-dialog']/descendant::tr[@class='k-grid-norecords']",driver))
                {
                    scenario.log("<span style='color:red'> EVEN AFTER CLICKING LOAD PRODUCTS LINK, NOT ABLE TO SEE PRODUCT IN CATALOG</span>");
                }
                else
                {
                    scenario.log("PRODUCTS HAS BEEN SUCCESSFULLY LOADED AFTER CLICKING LOAD PRODUCTS");
                }
            }
        }
        catch (Exception e){}
    }

    public void readProductsInInventory()
    {
        exists=false;
        String proText;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//button[@class='i-link-button']",driver))
            {
                List<WebElement> products = HelpersMethod.FindByElements(driver, "xpath", "//button[@class='i-link-button']");
                for (WebElement prod : products)
                {
                    act.moveToElement(prod).build().perform();
                    proText = prod.getText();
                    exists=true;
                    scenario.log("PRODUCTS FOUND UNDER INVENTORY " + proText);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnCancel()
    {
        exists=false;
        try
        {
            if(cancleButton.isDisplayed() && cancleButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,cancleButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void handleCancelPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[text()='Cancel']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement yesButton=modelContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                HelpersMethod.ActClick(driver,yesButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectShowAllProducts()
    {
            Actions act=new Actions(driver);
            String dropText;
            try
            {
                if(HelpersMethod.IsExists("//span[@id='CPQoh-accessibility-id']", driver))
                {
                    if (HelpersMethod.IsExists("//span[@id='CPQoh-accessibility-id']/span[text()='Show only products with available inventory']", driver))
                    {
                        WebElement dropDownMenu = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='CPQoh-accessibility-id']/following-sibling::button");
                        HelpersMethod.ClickBut(driver, dropDownMenu, 10000);
                        List<WebElement> dropDowns = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']");
                        for (WebElement dropDown : dropDowns)
                        {
                            act.moveToElement(dropDown).build().perform();
                            dropText = dropDown.getText();
                            if (dropText.equalsIgnoreCase("Show all products"))
                            {
                                act.moveToElement(dropDown).build().perform();
                                act.click(dropDown).build().perform();
                                break;
                            }
                        }
                    }
                }
            }
            catch (Exception e){}
    }
}