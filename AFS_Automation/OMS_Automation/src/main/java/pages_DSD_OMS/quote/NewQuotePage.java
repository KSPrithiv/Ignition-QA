package pages_DSD_OMS.quote;

import helper.HelpersMethod;
import io.cucumber.datatable.DataTable;
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
import util.DataBaseConnection;
import util.TestBase;

import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Project DSD_ERP
 * @Author Divya.Ramadas@afsi.com
 */
public class NewQuotePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;
    static String Product;
    static String Product1;
    static String bogoProduct;

    @FindBy(id = "cancelQuoteButton")
    private WebElement CancelButton;

    @FindBy(id = "createQuoteButton")
    private WebElement CreateButton;

    @FindBy(id = "backButton")
    private WebElement BackButton;

    @FindBy(xpath = "//button[text()='Comments']")
    private WebElement CommentButton;

    @FindBy(id = "addOrderButton")
    private WebElement AddProdcutButton;

    @FindBy(id = "deleteProductButton")
    private WebElement DeleteButton;

    @FindBy(id = "SearchBoxProductRefList")
    private WebElement SearchBar;

    @FindBy(id = "quickProduct")
    private WebElement QuickProd;

    public NewQuotePage(WebDriver driver, Scenario scenario)
    {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    //Actions methods
    public void QtyInGrid(String unit,String cases)
    {
        WebElement WebEle;
        try
        {
            Thread.sleep(2000);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'TotalUnitsCol')]");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.EnterText(driver,WebEle,4000,unit);
                WebEle.sendKeys(Keys.TAB);
                scenario.log("UNIT ENTERED IS: "+unit);

                // for (int i = 0; i <= 5; i++) {
                //Check for Qty exceeds maximum of popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                    HelpersMethod.ClickBut(driver, WebEle, 1000);
                }
                //Check for 'Product Unavailable' popup
                    /*    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[@id='toast-container']", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 10);
                        }

                        //Check for 'Product low in invetory' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low')]/ancestor::div[@id='toast-container']", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 20);
                        }
                        //Check for 'There are no matching product' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'There are no matching products: ')]/ancestor::div[contains(@class,'toast toast-error')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 20);
                        }
                        //Check for popup if it is accespting only units popup
                        if (HelpersMethod.IsExists("//div[contains(text(),' can only be ordered in ')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button[text()='×']");
                            HelpersMethod.ActClick(driver, WebEle, 20);
                        }
                    }*/

            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'TotalCasesCol')]");
            if(WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.EnterText(driver,WebEle,1000,cases);
                WebEle.sendKeys(Keys.TAB);
                scenario.log("CASE ENTERED IS: "+ cases);
                // for (int i = 0; i <= 5; i++) {
                //Check for Qty exceeds maximum of popup
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                    HelpersMethod.ClickBut(driver, WebEle, 1000);
                }
                //Check for 'Product Unavailable' popup
                    /*    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[@id='toast-container']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 10);
                        }

                        //Check for 'Product low in invetory' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low')]/ancestor::div[@id='toast-container']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 10);
                        }
                        //Check for 'There are no matching product' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'There are no matching products: ')]/ancestor::div[contains(@class,'toast toast-error')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 10);
                        }
                        //Check for popup if it is accespting only units popup
                        if (HelpersMethod.IsExists("//div[contains(text(),' can only be ordered in ')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button[text()='×']");
                            HelpersMethod.ActClick(driver, WebEle, 10);
                        }
                    }*/
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void EnterQuickProductNo()
    {
        exists=false;
        try
        {
            if (QuickProd.isDisplayed())
            {
                Product = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
                HelpersMethod.EnterText(driver,QuickProd,10000,Product);
                QuickProd.sendKeys(Keys.TAB);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Product not found')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement OK_Button=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver,OK_Button,1000);
                    scenario.log("PRODUCT HAS NOT BEEN FOUND");
                }
                else
                {
                    scenario.log("PRODUCT ENTERED IN QUICK PRODUCT INPUT BOX IS: "+Product);
                }
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void EnterQuickProductNoSecond()
    {
        exists=false;
        try
        {
            if (QuickProd.isDisplayed())
            {
                Product = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
                HelpersMethod.EnterText(driver,QuickProd,10000,Product);
                QuickProd.sendKeys(Keys.TAB);
                if(HelpersMethod.IsExists("//div[contains(text(),'Product not found')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement OK_Button=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver,OK_Button,10000);
                    scenario.log("SECOND PRODUCT HAS NOT BEEN FOUND: "+Product);
                }
                else
                {
                    scenario.log("SECOND PRODUCT ENTERED IN QUICK ENTRY IS: "+Product);
                }
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ClickOnCreateButton()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            CreateButton=HelpersMethod.FindByElement(driver,"id","createQuoteButton");
            if(CreateButton.isDisplayed() && CreateButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, CreateButton, 10000);
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnCancelButton()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }
        try
        {
            if(CancelButton.isDisplayed())
            {
                HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.ClickBut(driver, CancelButton, 10000);
                scenario.log("QUOTES CREATION HAS BEEN CANCELLED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
            exists=false;
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Cancel quote')]/ancestor::div[contains(@class,'k-window k-dialog')]");
            if(WebEle.isDisplayed())
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,10000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            scenario.log("QUOTE HAS BEEN CANCELED");
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnAddProduct()
    {
        exists=false;
        try
        {
            if(AddProdcutButton.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, AddProdcutButton, 10000);
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectFromOG()
    {
        try
        {
            HelpersMethod.DropDownMenu_withOutScrollbar(driver,"From Order guies");
        }
        catch (Exception e){}
    }

    public void validateOGPopup()
    {
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Order guides", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void searchAndAddOG(String Og)
    {
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
            WebElement searchBox=modalContainer.findElement(By.xpath(".//input[@id='orderGuideSearch']"));
            HelpersMethod.EnterText(driver,searchBox,10000,Og);
            WebElement searchIndex=modalContainer.findElement(By.xpath(".//*[local-name()='svg' and contains(@class,'i-search-box__search')]"));
            HelpersMethod.ClickBut(driver,searchIndex,10000);
            WebElement oGRow=modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
            HelpersMethod.ActClick(driver,oGRow,10000);
            WebElement oKButton=modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
            HelpersMethod.ClickBut(driver,oKButton,10000);
        }
        catch (Exception e){}
    }

    public void enterQtyAfterAddingOG(String unit, String cases)
    {
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[2]/descendant::input[contains(@id,'TotalUnitsCol')]");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ActSendKey(driver,WebEle,10000,unit);
                scenario.log("UNIT ENTERED IS: "+unit);

                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                }
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[2]/descendant::input[contains(@id,'TotalCasesCol')]");
            if(WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ActSendKey(driver, WebEle, 10000, cases);
                scenario.log("CASE ENTERED IS: " + cases);
                if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                }
            }
        }
        catch (Exception e){}
    }

    public void SelectCatalog() throws InterruptedException
    {
        exists=false;
        Actions act1=new Actions(driver);
        String optText=null;
        Thread.sleep(1000);
        try
        {
            if(HelpersMethod.IsExists("//ul[@id='addOrderButton-accessibility-id']/li",driver))
            {
                List<WebElement> options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='addOrderButton-accessibility-id']/li");
                for(WebElement opt:options)
                {
                    act1.moveToElement(opt).build().perform();
                    optText=opt.getText();
                    if(optText.equalsIgnoreCase("From Catalog"))
                    {
                        act1.moveToElement(opt).build().perform();
                        act1.click(opt).build().perform();
                        scenario.log("CATALOG OPTION HAS BEEN SELECTED FROM ADD PRODUCTS DROP DOWN");
                        exists=true;
                        break;
                    }
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectProductFromCatalog() throws InterruptedException
    {
        Thread.sleep(2000);
        exists = false;
        WebElement WebEle = null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                String Prod = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
                //check for existence of list view of catalog
                if (HelpersMethod.IsExists("//div[@class='i-grid']", driver))
                {
                    //check whether filter is enabled or not
                    if (HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-filter k-icon')]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'k-icon k-i-filter k-icon')]");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                    }
                    //if filter is already enabled search for Product# header
                    int i = 0;
                    int j = 0;
                    List<WebElement> Heads = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::th[contains(@class,'k-header ')]");
                    for (WebElement Head : Heads)
                    {
                        i++;
                        String Head_text = Head.getText();
                        if (Head_text.equals("Product #"))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[@class='k-filter-row']/th[" + i + "]/descendant::input");
                            HelpersMethod.ActSendKey(driver, WebEle, 10000, Prod);
                            scenario.log("PRODUCT SEARCHED IN LIST VIEW IS: "+Prod);
                            exists=true;
                            break;
                        }
                    }
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                }
                else
                {
                    //Card view of catalog
                    if (HelpersMethod.IsExists("//div[@class='card-view']", driver) || !HelpersMethod.IsExists("//div[@class='i-grid']",driver))
                    {
                        //Enter product number into search bar
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'cp-search-bar-container')]/descendant::input");
                        HelpersMethod.ActSendKey(driver, WebEle, 10000, Prod);
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M15')]");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        scenario.log("PRODUCT SEARCHED IN CARD VIEW IS: "+Prod);
                        exists=true;
                    }
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }


    public void EnterProductQtyCatalog(String unit,String cases) throws InterruptedException {
        WebElement WebEle;
        int j=0;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='i-grid']", driver))
            {
                //Check for unit and case input boxes
                if (!HelpersMethod.IsExists("//div[@class='i-no-data__icon']", driver))
                {
                    List<WebElement> Heads1 = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::th[contains(@class,'k-header ')]");
                    for (WebElement Head1 : Heads1)
                    {
                        j++;
                        String Head_text1 = Head1.getText();
                        if (Head_text1.equals("Units"))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td[" + j + "]/descendant::input");
                            if (WebEle.isDisplayed())
                            {
                                HelpersMethod.EnterText(driver, WebEle, 10000, unit);
                                WebEle.sendKeys(Keys.TAB);
                                exists = true;
                                if(HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                                {
                                    WebElement dialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                    WebElement yesButton = dialogBox.findElement(By.xpath(".//button/span[text()='Yes']"));
                                    HelpersMethod.ClickBut(driver,yesButton,10000);
                                }
                                scenario.log("UNITS ENTERED IS: "+unit);
                            }
                        }
                        else
                        {
                            if (Head_text1.equals("Cases"))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td[" + j + "]/descendant::input");
                                if (WebEle.isDisplayed())
                                {
                                    HelpersMethod.EnterText(driver, WebEle, 10000, cases);
                                    WebEle.sendKeys(Keys.TAB);
                                    exists = true;
                                    if(HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                                    {
                                        WebElement dialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                        WebElement yesButton = dialogBox.findElement(By.xpath(".//button/span[text()='Yes']"));
                                        HelpersMethod.ClickBut(driver,yesButton,10000);
                                    }
                                    scenario.log("CASES ENTERED IS: "+cases);
                                }
                            }
                        }
                    }
                }
            }

            if (HelpersMethod.IsExists("//div[@class='card-view']", driver))
            {
                if (!HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched ')]", driver))
                {
                    //Enter value for unit input
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Unit')]/descendant::input");
                    HelpersMethod.ScrollElement(driver, WebEle);
                    if (WebEle.isDisplayed())
                    {
                        HelpersMethod.EnterText(driver, WebEle, 10000, unit);
                        WebEle.sendKeys(Keys.TAB);
                        exists = true;
                        if(HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                        {
                            WebElement dialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            WebElement yesButton = dialogBox.findElement(By.xpath(".//button/span[text()='Yes']"));
                            HelpersMethod.ClickBut(driver,yesButton,10000);
                        }
                        scenario.log("UNITS ENTERED IS: "+unit);
                    }

                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Case')]/descendant::input");
                    if (WebEle.isDisplayed())
                    {
                        HelpersMethod.EnterText(driver, WebEle, 10000, unit);
                        WebEle.sendKeys(Keys.TAB);
                        exists = true;
                        if(HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                        {
                            WebElement dialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                            WebElement yesButton = dialogBox.findElement(By.xpath(".//button/span[text()='Yes']"));
                            HelpersMethod.ClickBut(driver,yesButton,10000);
                        }
                        scenario.log("CASES ENTERED IS: "+cases);
                    }
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
        WebElement  OK_Button = HelpersMethod.FindByElement(driver, "xpath", "//button/span[text()='Ok']");
        HelpersMethod.ClickBut(driver, OK_Button, 10000);
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Thread.sleep(3000);
    }

    public void SelectOG()
    {
        exists=false;
        Actions act1=new Actions(driver);
        String ogText=null;
        try
        {
            if(HelpersMethod.IsExists("//ul[@id='addOrderButton-accessibility-id']/li",driver))
            {
                //WebElement addDropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative')]/div[contains(@class,'k-popup k-list-container k-reset k-group k-child-animation-container')]");
                List<WebElement> ogS=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='addOrderButton-accessibility-id']/li");
                for(WebElement og:ogS)
                {
                    act1.moveToElement(og).build().perform();
                    ogText=og.getText();
                    if(ogText.equals("From Order guides"))
                    {
                        act1.moveToElement(og).build().perform();
                        act1.click(og).build().perform();
                        scenario.log("OG OPTION HAS BEEN SELECTED FROM ADD PRODUCTS DROP DOWN");
                        exists=true;
                        break;
                    }
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    public void SelectOGFromPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            if(HelpersMethod.IsExists("//span[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                HelpersMethod.ActClick(driver,WebEle,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                exists=true;
                scenario.log("FIRST OG HAS BEEN SELECTED FROM POPUP");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintQuote()
    {
        exists=false;
        try
        {
            WebElement PrintBut=HelpersMethod.FindByElement(driver,"id","PrintButton");
            if(PrintBut.isDisplayed() && PrintBut.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,PrintBut);
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, PrintBut, 10000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        exists = true;
                        scenario.log("PRINT BUTTON HAS BEEN HANDLED");
                    }
                }
                driver.switchTo().window(ParentWindow);
                Assert.assertEquals(exists, true);
            }
            else
            {
                scenario.log("PRINT BUTTON IS NOT DISPLAYED/VISIBLE");
            }
        }
        catch (Exception e){}
    }

    public void QuickProdEntryMutlipleProduct(String Prod)
    {
        exists=false;
        try
        {
            if(QuickProd.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,QuickProd);
                HelpersMethod.ActClearKey(driver,QuickProd,10000);
                HelpersMethod.EnterText(driver, QuickProd, 10000, Prod);
                QuickProd.sendKeys(Keys.TAB);
                scenario.log("PRODUCT ENTERED IN QUICK PRODUCT ENTRY IS: "+Prod);
                if(HelpersMethod.IsExists("//div[contains(text(),'Product not found')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement OK_Button=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver,OK_Button,10000);
                    scenario.log("PRODUCT HAS NOT BEEN FOUND");
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void QtyInGridMultipleProduct(String unit,String cases,int count)
    {
        WebElement WebEle;
        WebEle=HelpersMethod.FindByElement(driver,"id","quoteEntryGridContainer");
        try
        {
            HelpersMethod.ScrollElement(driver,WebEle);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr["+(count+1)+"]/descendant::input[contains(@id,'TotalUnitsCol')]");
            if(WebEle.isDisplayed())
            {
                HelpersMethod.EnterText(driver,WebEle,10000,unit);
                WebEle.sendKeys(Keys.TAB);
                scenario.log("UNIT ENTERED IS: "+unit);
                if(HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement dialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement yesButton = dialogBox.findElement(By.xpath(".//button/span[text()='Yes']"));
                    HelpersMethod.ClickBut(driver,yesButton,10000);
                }
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr["+(count+1)+"]/descendant::input[contains(@id,'TotalCasesCol')]");
            if(WebEle.isDisplayed())
            {
                HelpersMethod.EnterText(driver,WebEle,10000,cases);
                WebEle.sendKeys(Keys.TAB);
                if(HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement dialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Quantity exceeds maximum')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement yesButton = dialogBox.findElement(By.xpath(".//button/span[text()='Yes']"));
                    HelpersMethod.ClickBut(driver,yesButton,10000);
                }
                scenario.log("CASES ENTERED IS: "+cases);
            }
        }
        catch (Exception e){}
    }

    public void AddMultipleProducts(List<List<String>> qtyList)
    {
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","quickProduct");
            List<String> Prod=DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql1());
            for(int i=0;i<=qtyList.size()-1;i++)
            {
                //Enter product number in input box
                String pro = String.valueOf(Prod.get(i));
                QuickProdEntryMutlipleProduct(pro);
                //Enter Qty in product grid
                QtyInGridMultipleProduct(qtyList.get(i).get(0),qtyList.get(i).get(1),i);
            }
        }
        catch (Exception e){}
    }

    public void SelectProductInProductGrid()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","quoteEntryGridContainer");
            if(WebEle.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, WebEle);
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::input[@class='k-checkbox']");
                HelpersMethod.ClickBut(driver, WebEle, 10000);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnDeleteButton()
    {
        exists=false;
        try
        {
            if(DeleteButton.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,DeleteButton,10000);
                exists=true;
                scenario.log("1ST PRODUCT IN PRODUCT GRID HAS BEEN DELETED FROM QUOTE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickComment()
    {
        exists=false;
        try
        {
            if(CommentButton.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,CommentButton);
                HelpersMethod.ClickBut(driver,CommentButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnPrintFlag()
    {
        exists = false;
        WebElement WebEle = null;
        String CommentPop = null;
        try {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Comments']/ancestor::div[contains(@class,'k-window k-dialog')]");
            if (WebEle.isDisplayed())
            {
                //Click on comment flag
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='printFlagDropDown']/descendant::span[contains(@class,'k-icon k-i-arrow-s')]");
                HelpersMethod.ClickBut(driver, WebEle, 10000);
            }
        } catch (Exception e) {}
    }

    public void SelectPrintflag()
    {
        try
        {
            //Select value from dropdown
            HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'k-slide-down-enter k-slide-down-enter-active')]/descendant::li", "xpath", "Internal");
        } catch (Exception e) {}
    }

    public void QuoteCommentPopup(String comment)
    {
        WebElement WebEle;
        String CommentPop=null;
        try
        {
            //Enter Comment in comment box
            WebEle=HelpersMethod.FindByElement(driver,"id","textAreaA");
            HelpersMethod.EnterText(driver,WebEle,10000,comment);
            //Click on Add button in comment popup
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button/span[text()='Add']");
            HelpersMethod.ClickBut(driver,WebEle,10000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-grid']");
            HelpersMethod.ScrollElement(driver,WebEle);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[2]");
            CommentPop=WebEle.getText();
            scenario.log("COMMENT ENTERED IS: "+comment);

            //Click on Ok button in comment popup
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//button/span[text()='Ok']");
            HelpersMethod.ActClick(driver,WebEle,10000);


            Assert.assertEquals(CommentPop,comment);
        }
        catch (Exception e){}
    }

    public void QuoteCommentOk()
    {
        exists=false;
        try
        {
            //Click on Ok button in comment popup
            WebElement   WebEle= HelpersMethod.FindByElement(driver,"xpath","//button/span[text()='Ok']");
            if(WebEle.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, WebEle, 10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNewQuote()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@id='quotesInputCard']",driver))
            {
                scenario.log("NAVIGATED TO QUOTES PAGE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void boGoItemsAdding()
    {
        exists=false;
        try
        {
            if (QuickProd.isDisplayed())
            {
                bogoProduct = TestBase.testEnvironment.get_BOGO();
                HelpersMethod.EnterText(driver,QuickProd,10000,bogoProduct);
                QuickProd.sendKeys(Keys.TAB);
                if(HelpersMethod.IsExists("//div[contains(text(),'Product not found')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement OK_Button=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver,OK_Button,10000);
                    scenario.log("BOGO PRODUCT HAS NOT BEEN FOUND");
                }
                else
                {
                    scenario.log("BOGO PRODUCT ENTERED IN QUICK PRODUCT INPUT BOX IS: "+bogoProduct);
                }
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readProductQuote()
    {
        exists=false;
        Actions act1=new Actions(driver);
        List<String> prods = new ArrayList<>();
        String prodText;
        try
        {
            List<WebElement> Prods=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@id,'ProductIdCol')]/a");
            scenario.log("PRODUCTS FOUND IN QUOTES");
            for(WebElement prod:Prods)
            {
                act1.moveToElement(prod).build().perform();
                prodText=prod.getText();
                prods.add(prodText);
                scenario.log(prodText);
                if(!bogoProduct.equals(prodText))
                {
                    scenario.log("BOGO PRODUCT FOUND IN QUOTE IS "+prodText);
                }
            }
        }
        catch (Exception e){}
    }

    public void validateCatalog()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'Catalog')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
                scenario.log("CATALOG DIALOG HAS BEEN FOUND");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ResetFilter_Catalog()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
        }

        try
        {
            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                //validate whether Catalog need to load products
                if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
                {
                    WebElement webEle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver,webEle,10000);
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }

                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                //if (!HelpersMethod.IsExists("//div[@class='i-grid']", driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='productFilterResetBtn']");
                    HelpersMethod.ActClick(driver,WebEle,10000);
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                }
                else if (HelpersMethod.IsExists("//div[@class='i-grid']", driver))
                {
                    if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]",driver))
                    {
                        //code to disable if any filters already added by using addfilter
                        List<WebElement> filters = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]");
                        if (filters.size() > 1)
                        {
                            //Click on 'Add filter'
                            WebElement gridCatalog = HelpersMethod.FindByElement(driver, "xpath","//div[@class='i-grid']/ancestor::div[contains(@class,'k-window k-dialog')]");
                            WebEle = gridCatalog.findElement(By.xpath("//button[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
                            HelpersMethod.ActClick(driver, WebEle, 10000);

                            if (!HelpersMethod.IsExists("//div[contains(@class,'i-filter-popup__footer')]/button[contains(@class,'k-disabled')]/span[contains(text(),'Clear all')]",driver))
                            {
                                //Click on 'Clear all'
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-filter-popup__footer')]/button/span[contains(text(),'Clear all')]");
                                HelpersMethod.ActClick(driver, WebEle, 10000);
                                exists = true;
                                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                                {
                                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                                }
                            }
                        }
                    }
                }
            }
            //Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterQuickProductNoForHideZero()
    {
        exists=false;
        try
        {
            if (QuickProd.isDisplayed())
            {
                Product = TestBase.testEnvironment.getPrecedingByZero();
                int i = 0;
                while (i < Product.length() && Product.charAt(i) == '0')
                    i++;

                // Converting string into StringBuffer object
                // as strings are immutable
                StringBuffer sb = new StringBuffer(Product);

                // The StringBuffer replace function removes
                // i characters from given index (0 here)
                sb.replace(0, i, "");

                // Returning string after removing zeros
                Product1=sb.toString();
                HelpersMethod.EnterText(driver,QuickProd,10000,Product1);
                QuickProd.sendKeys(Keys.TAB);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Product not found')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement OK_Button=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver,OK_Button,10000);
                    scenario.log("PRODUCT HAS NOT BEEN FOUND");
                }
                else
                {
                    scenario.log("PRODUCT ENTERED IN QUICK PRODUCT INPUT BOX IS: "+Product1);
                }
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void validateQuickAndGridProduct()
    {
        exists=false;
        try
        {
            WebElement proEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@id,'ProductIdCol')]/a");
            String proGrid=proEle.getText();
            if(Product1.equals(proGrid))
            {
                scenario.log("QUICK PRODUCT AND PRODUCT IN GRID FOUND ARE SAME");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterQuickProductNoForNotHideZero()
    {
        exists=false;
        try
        {
            if (QuickProd.isDisplayed())
            {
                Product = TestBase.testEnvironment.getPrecedingByZero();
                Product1=Product;
                HelpersMethod.EnterText(driver,QuickProd,10000,Product1);
                QuickProd.sendKeys(Keys.TAB);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'Product not found')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement OK_Button=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Ok']");
                    HelpersMethod.ClickBut(driver,OK_Button,10000);
                    scenario.log("PRODUCT HAS NOT BEEN FOUND");
                }
                else
                {
                    scenario.log("PRODUCT ENTERED IN QUICK PRODUCT INPUT BOX IS: "+Product1);
                }
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void selectAllProducts()
    {
        Actions act=new Actions(driver);
        String dropText;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(org.openqa.selenium.NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Thread.sleep(1000);
            if(HelpersMethod.IsExists("//span[@id='CPQoh-accessibility-id']",driver))
            {
                if(!HelpersMethod.IsExists("//span[@id='CPQoh-accessibility-id']/span[text()='Show all products']|//span[@id='CPQoh-accessibility-id']/span[text()='All Products']",driver))
                {
                    WebElement dropDown = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='CPQoh-accessibility-id']/following-sibling::button");
                    HelpersMethod.ClickBut(driver, dropDown, 10000);
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']"))));
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']")));
                    List<WebElement> dropDowns = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']");
                    for (WebElement dropDow : dropDowns)
                    {
                        act.moveToElement(dropDown).build().perform();
                        dropText = dropDow.getText();
                        if (dropText.equalsIgnoreCase("Show all products") || dropText.equalsIgnoreCase("All Products"))
                        {
                            act.moveToElement(dropDow).build().perform();
                            act.click(dropDow).build().perform();
                            break;
                        }
                    }
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(org.openqa.selenium.NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(org.openqa.selenium.NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    Thread.sleep(1000);
                }

                if(HelpersMethod.IsExists("//span[@id='CPQoh-accessibility-id']/span[text()='Show all products']|//span[@id='CPQoh-accessibility-id']/span[text()='All Products']",driver))
                {
                    exists=true;
                }
                else
                {
                    exists=false;
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }
}