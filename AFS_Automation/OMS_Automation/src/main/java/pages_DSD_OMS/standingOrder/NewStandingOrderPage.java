package pages_DSD_OMS.standingOrder;

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

import util.DataBaseConnection;
import util.TestBase;

import java.sql.SQLException;
import java.time.Duration;
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
    static String Prod_No;
    static String Prod_Name;
    static String ProNo;

    @FindBy (xpath="//div[@id='card1']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]")
    private WebElement StandingOrderArrow;

    @FindBy (xpath="//button[@data-test-id='saveStandingOrderBtn']")
    private WebElement SaveButton;

    @FindBy(xpath="//button[@data-test-id='openCatalogStandingOrderBtn']")
    private WebElement AddProduct;

    @FindBy(xpath = "//button/span[text()='Delete']")
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                String Menu_Text ="";
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
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                 wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
        WebElement WebEle;
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
                HelpersMethod.sendKeys(driver,QuickProduct,10000,Pro);
                QuickProduct.sendKeys(Keys.ENTER);
                if(HelpersMethod.IsExists("//span[@id='quickEntryUMs']",driver))
                {
                    WebElement uomSO= HelpersMethod.FindByElement(driver,"id","quickEntryUMs");
                    uomSO.sendKeys(Keys.TAB);
                }
                Thread.sleep(4000);
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
        WebElement WebEle;
        try
        {
            int i=0;
            int j=0;

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='grid-container']"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid-container']")));

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
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOf(SaveButton));

            if(SaveButton.isDisplayed() && SaveButton.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,SaveButton);
                HelpersMethod.ClickBut(driver,SaveButton,25000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
            Wait<WebDriver>  wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[text()='Success']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Success']/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement OkButton=WebEle.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,OkButton,10000);
                exists=true;
            }
            scenario.log("STANDING ORDER SUCESSFULLY SAVED");
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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

        new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[contains(text(),'Add product')]")));
        try
        {
            Wait<WebDriver>  wait = new FluentWait<WebDriver>(driver)
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
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(AddProduct.isDisplayed() && AddProduct.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,AddProduct);
                HelpersMethod.ClickBut(driver,AddProduct,20000);
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

    public void ValidateCatalogPopup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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

            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                exists=true;
                scenario.log("CATALOG DIALOG BOX HAS BEEN FOUND");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ListView()
    {
        exists = false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        Wait<WebDriver> wait;
        try
        {
            List<String> Prods = DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                //Click on 'Add filter'
                if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::span[text()='Add filter']/parent::button",driver))
                {
                    //Click on 'Add filter'
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::span[text()='Add filter']/parent::button");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //Enter value in 1st input
                    WebElement firstSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
                    HelpersMethod.EnterText(driver, firstSearch, 10000, "Product #");
                    //Click on check box
                    WebElement checkBox = HelpersMethod.FindByElement(driver, "id", "ProductNumber");
                    HelpersMethod.ActClick(driver, checkBox, 10000);
                    //Click on Apply button
                    WebElement applyButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::button/span[text()='Apply']");
                    HelpersMethod.ClickBut(driver, applyButton, 10000);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }

                    //Enter product numbers to be searched
                   for (int j = 0; j <= Prods.size() - 1; j++)
                    {
                        //click on filter option button
                        WebElement searchOption = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::span[text()='Product #: ']/ancestor::button");
                        HelpersMethod.ClickBut(driver, searchOption, 10000);
                        //dropDown1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
                        WebElement secondSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'k-input')]");
                        HelpersMethod.EnterText(driver, secondSearch, 10000, Prods.get(j));
                        //Click on Apply button
                        applyButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::button/span[text()='Apply']");
                        HelpersMethod.ClickBut(driver, applyButton, 10000);
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                        }
                        //Select the product from catalog
                        WebElement prod = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')]");
                        HelpersMethod.ActClick(driver, prod, 10000);
                        scenario.log("PRODUCT FOUND IN CATALOG IS " + Prods.get(j));
                    }
                }
                else
                {
                    String headText;
                    int i=0;
                    List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::span[@class='k-column-title']");
                    for(WebElement head:heads)
                    {
                        i++;
                        act.moveToElement(head).build().perform();
                        headText=head.getText();
                        if(headText.equalsIgnoreCase("Product #"))
                        {
                            for (int j = 0; j <= Prods.size() - 1; j++)
                            {
                                if(HelpersMethod.IsExists("//div[@class='k-widget k-window k-dialog']/descendant::th[@aria-label='Filter']["+i+"]/descendant::button/span[contains(@class,'k-clear-button-visible')]",driver))
                                {
                                    WebElement clearBut=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::th[@aria-label='Filter']["+i+"]/descendant::button/span[contains(@class,'k-clear-button-visible')]");
                                    HelpersMethod.ClickBut(driver,clearBut,10000);
                                    wait = new FluentWait<WebDriver>(driver)
                                            .withTimeout(Duration.ofSeconds(120))
                                            .pollingEvery(Duration.ofSeconds(2))
                                            .ignoring(NoSuchElementException.class);
                                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                                }
                                WebElement inputBox = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-widget k-window k-dialog']/descendant::th[@aria-label='Filter'][" + i + "]/descendant::input");
                                HelpersMethod.EnterText(driver, inputBox, 10000,Prods.get(j));
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(120))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                                WebElement prod=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::tr[contains(@class,'k-master-row')]");
                                HelpersMethod.ActClick(driver,prod,10000);
                            }
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void cardView(String prod)
    {

        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]",driver))
            {
                scenario.log("PRODUCT DOES NOT EXISTS");
            }
            else
            {
                //enter product number in input box
                WebElement inputBox = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
                HelpersMethod.EnterText(driver, inputBox, 10000, prod);
                //Click on search icon
                WebElement searchIcon = HelpersMethod.FindByElement(driver, "xpath", "//span[@datatestid='searchBarSearchBtn']//*[local-name()='svg']");
                HelpersMethod.ActClick(driver, searchIcon, 10000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //add product to standing order
                WebElement selectButton = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item']/descendant::button/span[text()='Select']");
                HelpersMethod.ScrollElement(driver, selectButton);
                HelpersMethod.ClickBut(driver, selectButton, 10000);
                scenario.log("PRODUCT FOUND IN CATALOG IS " + prod);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //Click on 'x' button in catalog
                WebElement clearButton = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='searchBarClearBtn']//*[local-name()='svg']");
                HelpersMethod.ScrollElement(driver, clearButton);
                act.moveToElement(clearButton).click().build().perform();

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void CatalogOKButton()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Ok')]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
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
        WebElement WebEle;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-grid-container')]");
            HelpersMethod.ScrollElement(driver, WebEle);
            for (int i = 0; i < qtys.size(); i++)
            {
                for (int j = 0; j < qtys.get(i).size(); j++)
                {
                    if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][" + (i + 1) + "]/td[contains(@class,'cell')][" + (j + 1) + "]/descendant::input", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][" + (i + 1) + "]/td[contains(@class,'cell')][" + (j + 1) + "]/descendant::input");
                        HelpersMethod.ActSendKey(driver, WebEle, 10000, qtys.get(i).get(j));
                    }
                }
            }
            Thread.sleep(2000);
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
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'k-checkbox')]");
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
        WebElement WebEle;
        try
        {
            if(DeleteProd.isDisplayed() && DeleteProd.isEnabled())
            {
                HelpersMethod.ClickBut(driver,DeleteProd,10000);
                if(HelpersMethod.IsExists("//span[contains(text(),'Delete product(s)')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Yes']");
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
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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

            Thread.sleep(1000);
            //new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test-id,'skipDeliveryDaysStandingOrderBtn')]")));
            //new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='skipDeliveryDaysStandingOrderBtn')]")));
            WebElement staandingOrderDetailsGrid=HelpersMethod.FindByElement(driver,"xpath","//label[@class='cart-title-standing-order']");
            HelpersMethod.ScrollElement(driver,staandingOrderDetailsGrid);
            WebElement skipSpecificdays = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='skipDeliveryDaysStandingOrderBtn']");
            if(skipSpecificdays.isDisplayed() && skipSpecificdays.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, skipSpecificdays);
                HelpersMethod.ClickBut(driver, skipSpecificdays, 40000);
                Thread.sleep(2000);
                exists = true;
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateSkipPopup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(HelpersMethod.IsExists("//div[@id='standing-order-skip-calendar']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("SKIP DAY POPUP HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on Skip reason dropdown
    public void ClickOnSkipReason()
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='skipReason']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "id", "skipReason");
                HelpersMethod.ClickBut(driver, WebEle, 10000);

                List<WebElement> reasons = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-list-container')]/descendant::ul/li");
                for (WebElement reason : reasons) {
                    i++;
                    act.moveToElement(reason).build().perform();
                    if (i == 1) {
                        act.moveToElement(reason).build().perform();
                        act.click().build().perform();
                        exists = true;
                        break;
                    }
                }

                //loading Icon
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                Thread.sleep(2000);
                Assert.assertEquals(exists, true);
            }
        }
        catch (Exception e){}
    }

    public void SelectDateToSkip()
    {
        exists=false;
        int i=0;
        try
        {
            /**************check for all enabled dates in calender and if enabled dates size is 0 or null then should click on arrow button in the top of calender popup
            //And select the very first enabled date in the next calender***************/
            List<WebElement> enabledDates=HelpersMethod.FindByElements(driver,"xpath","//td[contains(@style,'opacity: 1')]/span");
            int length=enabledDates.size();

            if(length<=4)
            {
                //Click on arrow
                WebElement arrow=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'i-chevron-right')]");
                HelpersMethod.JScriptClick(driver,arrow,10000);
                enabledDates=HelpersMethod.FindByElements(driver,"xpath","//td[contains(@style,'opacity: 1')]/span");
                //for(int i=1;i<=enabledDates.size()-1;i++)
                for(WebElement enableDate:enabledDates)
                {
                    i++;
                    if(i==4)
                    {
                        //tempEle=HelpersMethod.FindByElement(driver,"xpath","//td[contains(@style,'opacity: 1')]["+i+"]/span");
                        //HelpersMethod.ScrollElement(driver,tempEle);
                        //scenario.log("DATE SELECTED FOR SKIP IS "+tempEle.getText());
                        //HelpersMethod.JScriptClick(driver,tempEle,1000);
                        HelpersMethod.ScrollElement(driver,enableDate);
                        scenario.log("DATE SELECTED FOR SKIP IS "+enableDate.getText());
                        HelpersMethod.JScriptClick(driver,enableDate,10000);
                        exists=true;
                        break;
                    }
                }
            }
            else
            {
                i=0;
                //for(int i=enabledDates.size()-1;i>=0;i--)
                for(WebElement enabledDate:enabledDates)
                {
                    i++;
                    if(i==length-2)
                    {
                        //tempEle=HelpersMethod.FindByElement(driver,"xpath","//td[contains(@style,'opacity: 1')]["+i+"]/span");
                        //HelpersMethod.ScrollElement(driver,tempEle);
                        //scenario.log("DATE SELECTED FOR SKIP IS "+tempEle.getText());
                        //HelpersMethod.JScriptClick(driver,tempEle,10000);
                        HelpersMethod.ScrollElement(driver,enabledDate);
                        scenario.log("DATE SELECTED FOR SKIP IS "+enabledDate.getText());
                        HelpersMethod.JScriptClick(driver,enabledDate,10000);
                        exists=true;
                        break;
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SkipOkButton()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]", 10000);
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

            WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='OK']|.//button/span[text()='Ok']"));
            HelpersMethod.ActClick(driver, okButton, 10000);
            exists = true;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void SkipConfirmation()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
            if(HelpersMethod.IsExists("//div[contains(text(),'Delivery skip details saved')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement confirmDialog=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=confirmDialog.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,10000);
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

    public String readSkipDate()
    {
        exists=true;
        String skipDate = null;
        WebElement WebEle;
        try
        {
            // to fetch the web element of the modal container
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]",driver))
            {
                WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/td[1]"));
                HelpersMethod.ScrollElement(driver, WebEle);
                skipDate = WebEle.getText();
                scenario.log("DATE SELECTED FOR SKIP IS " + skipDate);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return skipDate;
    }

    public void RemoveSkipDate()
    {
        exists=false;

        Actions act1=new Actions(driver);
        String status;

        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/td[2]/button//*[local-name()='svg']",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
                WebElement deleteButton = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/td[2]/button//*[local-name()='svg']"));
                HelpersMethod.ScrollElement(driver,deleteButton);
                act1.moveToElement(deleteButton).build().perform();
                act1.click(deleteButton).build().perform();
                scenario.log("SKIP CANCEL HAS BEEN DONE ON :"); //+ WebEle.getText());
                exists = true;
            }
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) { }
    }

    public void ValidateCardView()
    {
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'product-catalog-container')]", driver))
            {
                WebElement WebEle;
                WebElement Catelog = HelpersMethod.FindByElement(driver, "id", "CPcategories");
                WebElement SubCate = HelpersMethod.FindByElement(driver, "id", "CPbrands");
                WebElement Brand = HelpersMethod.FindByElement(driver, "id", "CPsizes");
                String Cate;
                exists = false;

                if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'product-catalog-container')]", driver)) {
                    //Read the category value of first product in catalog
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box'][1]/descendant::span[text()='Category']/following-sibling::span");
                    Cate = WebEle.getText();

                    //Click on category drop down
                    HelpersMethod.ClickBut(driver, Catelog, 10000);
                    HelpersMethod.DropDownMenu(driver, Cate);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }

                    //Click on SubCategory Drop down
                    HelpersMethod.ClickBut(driver, SubCate, 10000);
                    if (HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::li[2]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::li[2]");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                    }
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }

                    //Click on Brand
                    HelpersMethod.ClickBut(driver, Brand, 10000);
                    if (HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::li[2]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::li[2]");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
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
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                scenario.log("CATALOG IS DISPLAYED IN GRID VIEW");
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                exists=true;
            }
            else
            {
                scenario.log("CATALOG IS DISPLAYED IN CARD VIEW");
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box'][1]/descendant::button");
                HelpersMethod.ClickBut(driver, WebEle, 10000);
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
                String Menu_Text;
                Actions act=new Actions(driver);
                List<WebElement> MenuBar=HelpersMethod.FindByElements(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link']");
                for(WebElement Menu:MenuBar)
                {
                    act.moveToElement(Menu).build().perform();
                    Menu_Text=Menu.getText();
                    if(Menu_Text.contains("Standing Orders")||Menu_Text.contains("Standing orders"))
                    {
                        WebElement menuItem=HelpersMethod.FindByElement(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'All orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]|//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing orders')]");
                        HelpersMethod.JScriptClick(driver,menuItem,10000);
                        break;
                    }
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
        Wait<WebDriver> wait;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                wait = new WebDriverWait(driver, Duration.ofMillis(1000));
                if (wait.until(ExpectedConditions.alertIsPresent()) == null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
                //navigate to Standing order
                driver.navigate().to(currentURL);

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

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void SearchProductSingleProd()
    {
        exists = false;
        WebElement WebEle;
        Actions act1=new Actions(driver);
        try
        {
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                //to load all the products in catalog
                if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
                {
                    WebElement loadProducts=HelpersMethod.FindByElement(driver,"xapth","//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver,loadProducts,10000);
                }

                //Click on 'Add filter'
                WebElement catalogPopup=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebEle = catalogPopup.findElement(By.xpath("//button/span[contains(@class,'i-filter-tag__main')]/descendant::span[text()='Add filter']"));
                HelpersMethod.clickOn(driver, WebEle, 10000);

                //Click on clear all
                WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
                WebElement clearAll=dropDown.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::button/span[contains(text(),'Clear all')]"));
                if(clearAll.isDisplayed() && clearAll.isEnabled())
                {
                    HelpersMethod.ActClick(driver,clearAll,10000);
                    //Click on Add filter again
                    HelpersMethod.clickOn(driver, WebEle, 10000);
                }
                //Enter value in 1st input
                WebElement fistSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
                HelpersMethod.EnterText(driver,fistSearch,10000,"Product #");
                //Click on check box
                WebElement checkBox=HelpersMethod.FindByElement(driver,"id","ProductNumber");
                HelpersMethod.ActClick(driver,checkBox,10000);
                WebElement secondSearch=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'k-textbox')]");
                HelpersMethod.EnterText(driver,secondSearch,10000,Prod_No);
                //Click on Apply button
                WebElement applyButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::button/span[text()='Apply']");
                HelpersMethod.ClickBut(driver,applyButton,10000);

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                scenario.log("PRODUCT FOUND IN CATALOG IS "+Prod_No);
                exists=true;
            }
            else
            {
                //enter product number in input box
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
                HelpersMethod.EnterText(driver, WebEle, 10000, Prod_No);
                scenario.log(WebEle.getText()+"PRODUCT# ENTERED FOR SEARCH");
                Thread.sleep(2000);
                if(HelpersMethod.IsExists("//div[@id='react-autowhatever-searchBarAutoSuggest']/ul/li/descendant::span[@class='product-number']",driver))
                {
                    String autoValueText;
                    List<WebElement> autoComplete = driver.findElements(By.xpath("//div[@id='react-autowhatever-searchBarAutoSuggest']/ul/li/descendant::span[@class='product-number']"));
                    for (WebElement autoValue : autoComplete)
                    {
                        act1.moveToElement(autoValue).build().perform();
                        autoValueText = autoValue.getText();
                        if (autoValueText.contains(Prod_No))
                        {
                            act1.moveToElement(autoValue).click().build().perform();
                            exists=true;
                            break;
                        }
                    }
                }

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                scenario.log("PRODUCT FOUND IN CATALOG IS "+Prod_No);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void SearchProductDiscription()
    {
        exists = false;
        WebElement WebEle;
        WebElement WebEle1;
        Actions act=new Actions(driver);
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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

            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::span[text()='Add filter']",driver))
                {
//                    //Click on 'Add filter'
//                    WebElement catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
//                    WebEle = catalogPopup.findElement(By.xpath("//button/descendant::span[text()='Add filter']"));
//                    HelpersMethod.clickOn(driver, WebEle, 10000);

//                    //Enter value in 1st input
//                    WebElement fistSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]");
//                    HelpersMethod.EnterText(driver, fistSearch, 10000, "Description");
//                    //Click on check box
//                    WebElement checkBox = HelpersMethod.FindByElement(driver, "id", "Name");
//                    HelpersMethod.ActClick(driver, checkBox, 10000);
//                    Thread.sleep(400);
//                    //entering product name/description in second search box
//                    WebElement secondSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container-shown')]/descendant::input[contains(@class,'k-input')]");
//                    HelpersMethod.EnterText(driver, secondSearch, 20000, Prod_Name);
//                    //Click on Apply button
//                    WebElement applyButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container-shown')]/descendant::button/span[text()='Apply']");
//                    HelpersMethod.ClickBut(driver, applyButton, 10000);


                    //Search for Description in the catalog dialog box
                    String headText;
                    int i=0;
                    List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-window k-dialog']/descendant::span[@class='k-column-title']");
                    for(WebElement head:heads)
                    {
                        i++;
                        act.moveToElement(head).build().perform();
                        headText=head.getText();
                        if(headText.equalsIgnoreCase("Description"))
                        {
                            break;
                        }
                    }

                    WebElement productInputBox=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::tr[@class='k-table-row k-filter-row']/descendant::th["+i+"]/descendant::input");
                    HelpersMethod.EnterText(driver,productInputBox,10000,Prod_Name);

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    scenario.log("PRODUCT FOUND IN CATALOG IS " + Prod_Name);
                    exists = true;
                }
                else
                {
                    String headText;
                    int i=0;
                    List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-window k-dialog']/descendant::span[@class='k-column-title']");
                    for(WebElement head:heads)
                    {
                        i++;
                        act.moveToElement(head).build().perform();
                        headText=head.getText();
                        if(headText.equalsIgnoreCase("Description"))
                        {
                                if(HelpersMethod.IsExists("//div[@class='k-window k-dialog']/descendant::th[@aria-label='Filter']["+i+"]/descendant::button/span[contains(@class,'k-clear-button-visible')]",driver))
                                {
                                    WebElement clearBut=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::th[@aria-label='Filter']["+i+"]/descendant::button/span[contains(@class,'k-clear-button-visible')]");
                                    HelpersMethod.ClickBut(driver,clearBut,10000);
                                    wait = new FluentWait<WebDriver>(driver)
                                            .withTimeout(Duration.ofSeconds(400))
                                            .pollingEvery(Duration.ofSeconds(2))
                                            .ignoring(NoSuchElementException.class);
                                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                                }
                                WebElement inputBox = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-window k-dialog']/descendant::th[@aria-label='Filter'][" + i + "]/descendant::input");
                                HelpersMethod.EnterText(driver, inputBox, 10000,Prod_Name);
                                exists=true;
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(400))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                                WebElement prod=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::tr[contains(@class,'k-master-row')]");
                                HelpersMethod.ActClick(driver,prod,20000);
                            break;
                        }
                    }
                }
            }
            else
            {
                //enter product number in input box
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
                HelpersMethod.EnterText(driver, WebEle, 10000, Prod_Name);
                scenario.log(WebEle.getText()+"PRODUCT DESCRIPTION ENTERED FOR SEARCH");

                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'suggestions-list')]/li")));
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'suggestions-list')]/li")));

                //This is to select product from autosuggestion list
                WebEle1=HelpersMethod.FindByElement(driver,"xpath","//ul[contains(@class,'suggestions-list')]/li[1]");
                HelpersMethod.ActClick(driver,WebEle1,10000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if(!HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]",driver))
                {
                    scenario.log("PRODUCT HAS BEEN FOUND");
                    exists=true;
                }
                else
                {
                    scenario.log("NO PRODUCTS FOUND");
                    exists=false;
                }
                scenario.log("PRODUCT FOUND IN CATALOG IS "+Prod_Name);
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validateProductSelectedOrNot()
    {
        exists=false;
        String desText;
        int i=0;
        try
        {
            Thread.sleep(2000);
            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]"))));
            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]"))));

            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]/descendant::tr[contains(@class,'k-master-row k-selected')]",driver))
                {
                    scenario.log("PRODUCT IS ALREADY SELECTED, IN GRID VIEW");
                    exists=true;
                }
            }
            else if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'card-view')]",driver))
            {

                //search for exact product in catalog for product by comparing description
                List<WebElement> descriptionItem=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@id,'gridItem')]/descendant::span[contains(@class,'product-name')]");
                for(WebElement desItem:descriptionItem)
                {
                    i++;
                    desText=desItem.getText();
                    if(desText.equalsIgnoreCase("Prod_Name"))
                    {
                        break;
                    }
                }

                if(HelpersMethod.IsExists("//div[contains(@id,'gridItem')]["+i+"]/descendant::button[contains(@class,'k-disabled')][1]/span[text()='Select']",driver))
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
            if (HelpersMethod.IsExists("//div[contains(text(),'To skip this dates')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement dialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'To skip this dates')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=dialogBox.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okButton,10000);
                scenario.log("<span style='color:red'>YOU NEED TO REMOVE ORDER TO SKIP SELECTED DATE AND EVEN CHECK DELIVERY DATE SHOULD MATCH SKIP DATE IN STANDING ORDER</span>");
            }
            else
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickCategory()
    {
        exists=false;
        WebElement showAllProd;
        Actions act1=new Actions(driver);
        String status;
        String head_text;
        String listText;
        int i=0;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[@class='card-view']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                if (HelpersMethod.IsExists("//span[@id='CPcategories']", driver))
                {
                    showAllProd = HelpersMethod.FindByElement(driver, "id", "CPcategories");
                    HelpersMethod.ActClick(driver, showAllProd, 10000);
                    exists = true;
                }
            }
            else if(HelpersMethod.IsExists("//div[contains(@class,'catalog-search-grid-view')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                    //Find all the headers of catalog dialog box, when displayed in list view
                    List<WebElement> headers = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::th[contains(@class,'k-header')]/descendant::span[contains(@class,'k-column-title')]");
                    for (WebElement head : headers)
                    {
                        i++;
                        head_text = head.getText();
                        if (head_text.equals("Category"))
                        {
                            break;
                        }
                    }
                    //Enter search value in input box
                    String searchValue = TestBase.testEnvironment.get_Category();
                    WebElement catalogFilter = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-filter-row')]/th[" + i + "]/descendant::input");
                    HelpersMethod.EnterText(driver,catalogFilter,10000,searchValue);

                    //Click on filter icon
                    WebElement filterIcon = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-filter-row')]/th["+i+"]/descendant::span[contains(@class,'k-icon k-svg-icon k-svg-i-filter k-button-icon')]");
                    HelpersMethod.ActClick(driver, filterIcon, 10000);
                    List<WebElement> Lists = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-list-container')]/descendant::ul/li/span");
                    for (WebElement listValue : Lists)
                    {
                        act1.moveToElement(listValue).build().perform();
                        listText = listValue.getText();
                        if (listText.equals("Is equal to"))
                        {
                            act1.moveToElement(listValue).build().perform();
                            act1.click().build().perform();
                            break;
                        }
                    }

                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }

                    String catFilterVal = HelpersMethod.JSGetValueEle(driver, catalogFilter, 10000);
                    if (catFilterVal.equals(searchValue))
                    {
                        scenario.log("IN CATEGORY OPTION SEARCHED IS " + searchValue);
                        exists = true;
                    }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCategory()
    {
        exists=false;
        String prods;
        Actions act=new Actions(driver);
        String cat=TestBase.testEnvironment.get_Category();
        try
        {
            //WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> allProds=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container-relative k-list-container')]/descendant::ul/li");
            for(WebElement prod:allProds)
            {
                act.moveToElement(prod).build().perform();
                prods=prod.getText();
                if(prods.equals(cat))
                {
                    act.moveToElement(prod).build().perform();
                    act.click(prod).build().perform();
                    exists = true;
                    break;
                }
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            WebElement dropDown1=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPcategories']/span[@class='k-input']");
            String selectValue=dropDown1.getText();
            scenario.log("OPTION SELECTED FROM CATEGORY DROP DOWN "+selectValue);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void resetFilter()
    {
        exists=false;
        try
        {
            WebElement resetFilter = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='productFilterResetBtn']");
            HelpersMethod.ClickBut(driver, resetFilter, 10000);
            exists = true;
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
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
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]"))));
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]"))));
                if (HelpersMethod.IsExists("//div[@class='card-view']", driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//button/span[contains(text(),'Reset filter')]");
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                else if (HelpersMethod.IsExists("//div[@class='i-grid']", driver))
                {
                    if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]",driver))
                    {
                        List<WebElement> filters=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]");
                       if(filters.size()>1)
                       {
                           //Click on 'Add filter'
                           WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Add filter']/parent::button");
                           HelpersMethod.ClickBut(driver, WebEle, 10000);

                           //Click on 'Clear all'
                           if (HelpersMethod.IsExists("//div[contains(@class,'i-filter-popup__footer')]/button[contains(@class,'primary')]/span[contains(text(),'Clear all')]",driver))
                           {
                               WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'i-filter-popup__footer')]/button[contains(@class,'primary')]/span[contains(text(),'Clear all')]");
                               HelpersMethod.ScrollTillElementVisible(driver, WebEle);
                               HelpersMethod.JScriptClick(driver, WebEle, 10000);
                               Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                       .withTimeout(Duration.ofSeconds(400))
                                       .pollingEvery(Duration.ofSeconds(2))
                                       .ignoring(NoSuchElementException.class);
                               wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                           }
                       }
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void selectAllProduct()
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

    public void ReadProductNameInGrid() throws InterruptedException
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
        Thread.sleep(2000);
        try
        {
            List<WebElement> heads= HelpersMethod.FindByElements(driver,"xpath","//thead/tr[contains(@style,'touch-action')]/th");
            for (WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                head_text=head.getText();
                //if(head_text.equals("Product Number"))
                if(head_text.equals("Description"))
                {
                    Prod_Name=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::td["+i+"]").getText();
                    exists=true;
                    break;
                }
            }
            if(exists==false)
            {
                scenario.log("PRODUCT DESCRIPTION HEADER IS NOT FOUND");
            }
            scenario.log("PRODUCT NUMBER FOUND IN GRID IS : "+Prod_Name);
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

    public void validateDeliveryScheduleDate()
    {
        exists=false;
        try
        {
            Thread.sleep(1000);
            WebElement standingOrderDetailsGrid=HelpersMethod.FindByElement(driver,"xpath","//label[@class='cart-title-standing-order']");
            HelpersMethod.ScrollElement(driver,standingOrderDetailsGrid);
            WebElement DeliverySchedule=HelpersMethod.FindByElement(driver,"id","frequency");
            if(DeliverySchedule.isDisplayed() && DeliverySchedule.isEnabled())
            {
                String deliveryScheduleText=HelpersMethod.FindByElement(driver,"xpath","//span[@id='frequency']/span[@class='k-input']").getText();
                if(deliveryScheduleText.equals("Every week"))
                {
                    scenario.log("DELIVERY SCHEDULE VALUE FOUND IS " + deliveryScheduleText);
                    exists = true;
                }
                else
                {
                    scenario.log("DELIVERY SCHEDULE VALUE FOUND IS "+deliveryScheduleText);
                    exists=false;
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }

    public void clickOnLoadAllProducts()
    {
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                WebElement loadProd=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
                HelpersMethod.ActClick(driver,loadProd,10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void adminQuickProductEntry()
    {
        exists=false;
        WebElement WebEle;
        String headText;
        int i=0;
        Actions act1=new Actions(driver);
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","card2");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(QuickProduct.isDisplayed() && QuickProduct.isEnabled())
            {
                //Enter Qty in quick inputbox
                String Pro=TestBase.testEnvironment.getPrecedingByZero();
                //int i = 0;
                //while (i < Pro.length() && Pro.charAt(i) == '0')
                //    i++;

                // Converting string into StringBuffer object, as strings are immutable
                //StringBuffer sb = new StringBuffer(Pro);

                // The StringBuffer replace function removes,i characters from given index (0 here)
                //sb.replace(0, i, "");

                // Returning string after removing zeros
                //Pro1=sb.toString();

                //Finding whether the quick product is having leading zero
                act1.moveToElement(QuickProduct).click().build().perform();
                HelpersMethod.ActSendKey(driver,QuickProduct,10000,Pro);
                //QuickProduct.sendKeys(Keys.ENTER);
                if(HelpersMethod.IsExists("//span[@id='quickEntryUMs']",driver))
                   {
                      WebElement uomSO= HelpersMethod.FindByElement(driver,"id","quickEntryUMs");
                      uomSO.sendKeys(Keys.TAB);
                   }
                Thread.sleep(4000);
                List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//th/descendant::span[@class='k-column-title']|//th/div[@class='i-btn-checkbox ']|//th/a[@class='k-link']");
                for(WebElement head:heads)
                {
                  i++;
                  act1.moveToElement(head).build().perform();
                  headText=head.getText();
                  if(headText.equalsIgnoreCase("Product Number"))
                  {
                        break;
                  }
                }

                //Code to read product# from grid and compare it with string after removing zeros from product#
                String prodInGrid=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/td["+i+"]").getText();
                if(!prodInGrid.startsWith("0"))
                {
                        scenario.log("PRODUCT ENTERED IN QUICK ENTRY WITHOUT PRECEDING ZEROS " + prodInGrid);
                        exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyProdNoInGridAdmin()
    {
        exists=false;
        Actions act=new Actions(driver);
        String headText;
        int i=0;
        try
        {
           List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
           for(WebElement head:heads)
           {
               i++;
               act.moveToElement(head).build().perform();
               headText=head.getText();
               if(headText.equalsIgnoreCase("Product number"))
               {
                   break;
               }
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

           WebElement prodEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/td["+(i)+"]");
           act.moveToElement(prodEle).build().perform();
           String prod=prodEle.getText();
           scenario.log("PRODUCT FOUND IN GRID IS "+prod);
           if(!prod.startsWith("0"))
           {
               scenario.log("PRODUCT NUMBER ENTERED IN GRID, WITHOUT PRECEDING ZERO");
               exists=true;
           }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ListViewAdmin()
    {
        exists=false;
        Actions act=new Actions(driver);
        String prodText;
        int i=0;
        try
        {
            //Code to search for product in search filter
            String prodNo=TestBase.testEnvironment.getPrecedingByZero();
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::th[@class='k-header']/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                prodText=head.getText();
                if(prodText.equalsIgnoreCase("Product #"))
                {
                    break;
                }
            }
            WebElement prodFilter=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::div[@class='k-filtercell']["+i+"]/descendant::input");
            HelpersMethod.EnterText(driver,prodFilter,10000,prodNo);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //code to read product# in catalog dialog box
            prodText=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[@class='i-link-button']").getText();
            if(!prodText.startsWith("0"))
            {
                scenario.log("PRODUCT NUMBER IS NOT HAVING PRECEDING ZERO VALUES");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void cardViewAdmin()
    {
        exists=false;
        String prodText="";
        try
        {
            //code to enter value in search bar of catalog dialog box
            String prodNo=TestBase.testEnvironment.getPrecedingByZero();
            WebElement searchBar=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'cp-search-bar')]/descendant::input");
            HelpersMethod.EnterText(driver,searchBar,10000,prodNo);
            WebElement searchIndex=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'cp-search-bar')]/descendant::span[@datatestid='searchBarSearchBtn']");
            HelpersMethod.ActClick(driver,searchIndex,10000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //code to read product# searched, and find zero is not added
            prodText=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='product-number']/span").getText();
            prodText = prodText.startsWith("#") ? prodText.substring(1) : prodText;
            if(!prodText.startsWith("0"))
            {
                scenario.log("PRODUCT NUMBER IS NOT STARTING WITH ZERO");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void adminProductWithZeroQuickProductEntry()
    {
        exists=false;
        WebElement WebEle;
        Actions act1=new Actions(driver);
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","card2");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(QuickProduct.isDisplayed() && QuickProduct.isEnabled())
            {
                //Enter Qty in quick inputbox
                ProNo=TestBase.testEnvironment.getPrecedingByZero();
                act1.moveToElement(QuickProduct).click().build().perform();
                HelpersMethod.sendKeys(driver,QuickProduct,10000,ProNo);
                QuickProduct.sendKeys(Keys.ENTER);
                if(HelpersMethod.IsExists("//span[@id='quickEntryUMs']",driver))
                {
                    WebElement uomSO= HelpersMethod.FindByElement(driver,"id","quickEntryUMs");
                    uomSO.sendKeys(Keys.TAB);
                }
                Thread.sleep(4000);
                if(ProNo.startsWith("0"))
                {
                    scenario.log("PRODUCT ENTERED IN QUICK ENTRY WITH PRECEDING ZEROS " + ProNo);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyProdNoWithZeroInGridAdmin()
    {
        exists=false;
        Actions act=new Actions(driver);
        String headText;
        int i=0;
        try
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

            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[contains(@class,'k-column-title')]");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Product number") || headText.equalsIgnoreCase("Product Number"))
                {
                    break;
                }
            }

            WebElement prodEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/td["+(i+1)+"]");
            act.moveToElement(prodEle).build().perform();
            String prod=prodEle.getText();
            scenario.log("PRODUCT FOUND IN GRID IS "+prod);
            if(prod.equals(ProNo))
            {
                scenario.log("PRODUCT NUMBER ENTERED IN QUICK ENTRY AND GRID ARE SAME AND WITH PRECEDING ZERO");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ListViewAdminZeroPreceding()
    {
        exists=false;
        Actions act=new Actions(driver);
        String prodText;
        int i=0;
        try
        {
           /* List<WebElement> Products= HelpersMethod.FindByElements(driver,"xpath","//button[@class='i-link-button']");
            for(WebElement prod:Products)
            {
                act.moveToElement(prod).build().perform();
                prodText=prod.getText();
                if(prodText.startsWith("0")|| prodText.length()==8)
                {
                    scenario.log("<span style='color:red'>PRODUCT NUMBER IS HAVING PRECEDING ZERO VALUES</span>");
                    exists=true;
                    break;
                }
            }*/
            //Code to search for product in search filter
            String prodNo=TestBase.testEnvironment.getPrecedingByZero();
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::th[@class='k-header']/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                prodText=head.getText();
                if(prodText.equalsIgnoreCase("Product #"))
                {
                    break;
                }
            }
            WebElement prodFilter=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::div[@class='k-filtercell']["+i+"]/descendant::input");
            HelpersMethod.EnterText(driver,prodFilter,10000,prodNo);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //code to read product# in catalog dialog box
            prodText=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[@class='i-link-button']").getText();
            if(prodText.startsWith("0")|| prodText.length()==8||prodText.length()==5)
            {
                scenario.log("<span style='color:red'>PRODUCT NUMBER IS HAVING PRECEDING ZERO VALUES</span>");
                exists=true;
            }

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void cardViewAdminZeroPreceding()
    {
        exists=false;
        String prodText="";
        try
        {
            //code to enter value in search bar of catalog dialog box
            String prodNo=TestBase.testEnvironment.getPrecedingByZero();
            WebElement searchBar=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'cp-search-bar')]/descendant::input");
            HelpersMethod.EnterText(driver,searchBar,10000,prodNo);
            WebElement searchIndex=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'cp-search-bar')]/descendant::span[@datatestid='searchBarSearchBtn']");
            HelpersMethod.ActClick(driver,searchIndex,10000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //code to read product# searched, and find zero is not added
            prodText=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='product-number']/span").getText();
            prodText = prodText.startsWith("#") ? prodText.substring(1) : prodText;
            if(prodText.startsWith("0")|| prodText.length()==8||prodText.length()==5)
            {
                scenario.log("<span style='color:red'>PRODUCT NUMBER IS HAVING PRECEDING ZERO VALUES</span>");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ListViewAdminZeroPrecedingOMS()
    {
        exists=false;
        Actions act=new Actions(driver);
        String prodText;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            List<WebElement> Products= HelpersMethod.FindByElements(driver,"xpath","//button[@class='i-link-button']");
            for(WebElement prod:Products)
            {
                act.moveToElement(prod).build().perform();
                prodText=prod.getText();
                if(prodText.startsWith("0") || prodText.length()==5||prodText.length()==8)
                {
                    scenario.log("<span style='color:red'>PRODUCT NUMBER IS HAVING PRECEDING ZERO VALUES</span>");
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void cardViewAdminZeroPrecedingOMS()
    {
        exists=false;
        Actions act=new Actions(driver);
        String prodText;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            List<WebElement> Products= HelpersMethod.FindByElements(driver,"xpath","//button[@class='i-link-button']");
            for(WebElement prod:Products)
            {
                act.moveToElement(prod).build().perform();
                prodText=prod.getText();
                if(prodText.startsWith("0") || prodText.length()==5)
                {
                    scenario.log("<span style='color:red'>PRODUCT NUMBER IS HAVING PRECEDING ZERO VALUES</span>");
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}