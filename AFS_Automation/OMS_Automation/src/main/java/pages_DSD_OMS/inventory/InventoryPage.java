package pages_DSD_OMS.inventory;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.DataBaseConnection;
import util.TestBase;

import java.util.List;

public class InventoryPage
{
    WebDriver driver;
    Scenario scenario;
    static String currentURL;
    static boolean exists=false;
    static String runningTotalUnits=null;
    int totalUitsValue;
    int headIndex=0;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]")
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
        String Header=null;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }

            Header=HelpersMethod.FindByElement(driver,"xpath","//div[@class='topHeaderRow row']/descendant::span").getText();
            Assert.assertEquals(Header,"Inventory");
        }
        catch (Exception e){}
    }

    public boolean ValidateInventory()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
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
            if (HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]", driver))
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
                if (!HelpersMethod.IsExists("//span[contains(text(),'Store inventory')]/parent::li[contains(@class,'k-state-active')]", driver))
                {
                    WebElement storeTab=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Store inventory')]/parent::li");
                    HelpersMethod.ActClick(driver,storeTab,1000);
                }
                if (HelpersMethod.IsExists("//span[contains(text(),'Store inventory')]/parent::li[contains(@class,'k-state-active')]", driver))
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(addProdBtn.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,addProdBtn);
                HelpersMethod.ClickBut(driver, addProdBtn, 10000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCatalogPopup()
    {
        exists=false;
        String status=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 500000);
            }
            if(HelpersMethod.IsExists("//div[text()='Products']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                scenario.log("PRODUCT DIALOG HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ListView(List<List<String>> qtyValue)
    {
        exists = false;
        WebElement WebEle=null;
        String prodValue;
        try
        {
            List<String> Prods = DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql1());
            //to load all the products in catalog
            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                WebElement loadProducts=HelpersMethod.FindByElement(driver,"xapth","//span[contains(text(),'load all products')]");
                HelpersMethod.ActClick(driver,loadProducts,1000);
            }

            //Click on 'Add filter'
            WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Products']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
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
                WebElement searchOption=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-filter-tag ']/button[contains(@class,'i-filter-tag__main')]");
                HelpersMethod.ClickBut(driver,searchOption,1000);

                prodValue= Prods.get(j);
                WebElement secondSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form/descendant::input[contains(@class,'k-textbox')]");
                HelpersMethod.EnterText(driver,secondSearch,1000,prodValue);

                //Click on Apply button
                applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button[text()='Apply']");
                HelpersMethod.ClickBut(driver,applyButton,100);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                enterQtyForProducts(qtyValue,j);
                scenario.log("PRODUCT FOUND IN CATALOG IS "+Prods.get(j));
            }
        }
        catch (Exception e){}
    }

    public void enterQtyForProducts(List<List<String>> qtyValue,int j)
    {
        Actions act=new Actions(driver);
        String headTitle=null;
        WebElement qtyInput;
        int i=0;
        try
        {
            List<WebElement> heads = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headTitle=head.getText();
                if(headTitle.equals("Cases"))
                {
                    qtyInput=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::td["+i+"]/descendant::input");
                    HelpersMethod.EnterText(driver,qtyInput,1000,qtyValue.get(j).get(0));
                    qtyInput.sendKeys(Keys.TAB);
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
                    qtyInput=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/descendant::td["+i+"]/descendant::input");
                    HelpersMethod.EnterText(driver,qtyInput,1000,qtyValue.get(j).get(1));
                    qtyInput.sendKeys(Keys.TAB);
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
            else //if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(text(),'No data available')]",driver))
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
            if(HelpersMethod.IsExists("//div[text()='Products']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement productPopup=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Products']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=productPopup.findElement(By.xpath(".//button[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,10000);
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
            if(saveButton.isDisplayed() && saveButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,saveButton,1000);
                exists=true;
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
                HelpersMethod.EnterText(driver,quickProduct,1000,TestBase.testEnvironment.getSingle_Prod_Sql());
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
                HelpersMethod.EnterText(driver,quickUnit,1000,unit);
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
        String sListText=null;
        try
        {
            List<WebElement> sotreLists=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            for(WebElement sList:sotreLists)
            {
                act.moveToElement(sList).build().perform();
                sListText=sList.getText();
                if(sListText.equalsIgnoreCase("Today"))
                {
                    act.moveToElement(sList).build().perform();
                    act.click().build().perform();
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
        String headText=null;
        String totalValue=null;
        Actions act=new Actions(driver);
        exists=false;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//th[@class='k-header']/descendant::span[@class='k-column-title']");
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
                totalUitsValue=totalUitsValue+Integer.parseInt(totalValue);
                exists=true;
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
}