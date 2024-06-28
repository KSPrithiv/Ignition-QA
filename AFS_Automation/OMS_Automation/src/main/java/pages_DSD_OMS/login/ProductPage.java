package pages_DSD_OMS.login;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import com.mongodb.DBRef;
import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
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

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ServiceConfigurationError;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class ProductPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    //static WebElement WebEle;
    static boolean exists=false;
    static String pageTitle;

    @FindBy(xpath = "//button[@data-test-id='catalogPrintBtn']")
    private WebElement Print;

    @FindBy(xpath = "//button[@data-test-id='productFilterResetBtn']")
    private WebElement ReSetFilter;

    @FindBy(xpath = "//input[contains(@placeholder,'Search products')]")
    private WebElement SearchBar;

    @FindBy(xpath = "//span[@datatestid='searchBarSearchBtn']//*[local-name()='svg']")
    private WebElement SearchIndex;

    @FindBy(id = "searchBarClearBtn")
    private WebElement Clear;

    @FindBy(xpath ="//input[contains(@id,'Units')]")
    private WebElement unit_Qty;

    @FindBy(xpath = "//input[contains(@id,'Cases)]")
    private WebElement case_Qty;

    @FindBy(xpath="//input[contains(@id,'ProductGridItemQuantityContainer')]")
    private WebElement Qtycard;

    @FindBy(xpath="//input[contains(@id,'catalog-list-view-quantity-input')]")
    private WebElement QtyList;

    @FindBy(xpath = "//button[contains(@class,'buttonPlus ')]")
    private WebElement QtyPlus;

    @FindBy(xpath = "//button[contains(@class,'buttonMinus')]")
    private WebElement QtyMinus;

    @FindBy(xpath = "//button/descendant::span[text()='Add to cart']")
    private WebElement AddToCart;

    @FindBy(xpath="//button[@data-test-id='catalogGridViewBtn']//*[local-name()='svg']")
    private WebElement CardView;

    @FindBy(xpath="//button[@data-test-id='catalogListViewBtn']//*[local-name()='svg']")
    private WebElement ListView;

    @FindBy(xpath = "//button[text()='Cart']")
    private WebElement Cart;

    @FindBy(xpath = "//button[text()='Return to Login']")
    private WebElement ReturnLogin;

    @FindBy(id="checkoutToOrder")
    private WebElement Checkout;

    @FindBy(id="sort-by-dropdown")
    private WebElement SortByDropDown;

    @FindBy(id="CPcategories")
    private WebElement Categories;

    @FindBy(id="CPbrands")
    private WebElement SubCat;

    @FindBy(id="CPsizes")
    private WebElement Brand;

    public ProductPage(WebDriver driver,Scenario scenario) throws InterruptedException, AWTException
    {
        this.driver= driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Validating Product catalog page has displayed or not
    public boolean ValidateProductPage()
    {
        exists = false;
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
            HelpersMethod.waitTillTitleContains(driver, "Product Catalog", 100000);

            if (HelpersMethod.gettingURL(driver).contains("cpExtProductCatalog"))
            {
                scenario.log("EXTERNAL PRODUCT CATALOG HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
        return exists;
    }

    public String productTitle()
    {
        exists=false;
        try
        {
            pageTitle=HelpersMethod.gettingTitle(driver);
        }
        catch (Exception e){}
        return pageTitle;
    }

    public void Click_ResetFilter() throws InterruptedException
    {
        try
        {
            exists = false;
            WebElement WebEle;
            HelpersMethod.ClickBut(driver, ReSetFilter, 10000);
            scenario.log("RESET BUTTON HAS BEEN CLICKED TO DISPLAY ALL THE PRODUCTS IN EXTERNAL CATALOG");
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    //Change catalog  Card to grid view
    public void CardView()
    {
        WebElement WebEle;
        Actions act1=new Actions(driver);
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            if (!HelpersMethod.IsExists("//button[@data-test-id='catalogGridViewBtn']", driver))
            {
                WebElement cardview = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='catalogGridViewBtn']");
//                act1.moveToElement(cardview).build().perform();
//                HelpersMethod.ActClick(driver,cardview,10000);
                HelpersMethod.ClickBut(driver,cardview,10000);

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("CARD VIEW HAS BEEN SELECTED");
            }
        }
        catch (Exception e){}
    }

    //Change catalog grid view to card
    public void GridView()
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            Thread.sleep(8000);
            //new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(By.id("productsCard"))));
            //new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.presenceOfElementLocated(By.id("productsCard")));

            if(HelpersMethod.IsExists("//button[@data-test-id='catalogListViewBtn']", driver))
            {
                WebElement gridview = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='catalogListViewBtn']");
                HelpersMethod.ScrollElement(driver,gridview);
                HelpersMethod.ClickBut(driver,gridview,20000);
                exists = true;
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

                scenario.log("GRID VIEW HAS BEEN SELECTED");
                Thread.sleep(8000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    //Enter Product# in Search bar and click on Index icon
    public void SearchProduct(String Prod_No) throws InterruptedException
    {
        try
        {
            WebElement WebEle;

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            HelpersMethod.ScrollElement(driver, SearchBar);
            HelpersMethod.ActClick(driver,Clear,10000);

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            //Enter product# in search input box
            HelpersMethod.EnterText(driver, SearchBar, 10000, Prod_No);
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            //Click on search index icon
            HelpersMethod.ActClick(driver, SearchIndex, 10000);
            scenario.log("PRODUCT NUMBER ENTERED IN SEARCH BOX IS " + Prod_No);

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    //Validate whether product details are displayed or not,card view
    public void ProductExistsCard(String Qty_UnitCase) throws InterruptedException
    {
        WebElement WebEle;
        exists=false;
        String status;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
            HelpersMethod.ScrollElement(driver, WebEle);

            //Identify input box for Qty
            if (HelpersMethod.IsExists("//div[contains(@class,'i-notification-text')]", driver))
            {
                scenario.log("PRODUCT IS NOT FOUND");
            }
            else
            {
                //HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'search-results-container')]", 20000);
                WebElement productContainer = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
                HelpersMethod.ScrollElement(driver, productContainer);
                if (productContainer.isDisplayed() && productContainer.isEnabled())
                {
                    HelpersMethod.clearText(driver,productContainer,10000);
                    HelpersMethod.EnterText(driver, productContainer, 20000, Qty_UnitCase);
                    productContainer.sendKeys(Keys.TAB);
                    scenario.log("QTY ENTERE IS " + Qty_UnitCase);
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    //Click on Add to cart button
                    WebElement addButton = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@id,'addCartBtn')]");
                    //HelpersMethod.ScrollElement(driver, addButton);
                    HelpersMethod.ActClick(driver, addButton, 10000);
                    Thread.sleep(1000);
                    //"Product is currently unavailable" popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                    {
                        WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");

                        WebElement okButton=modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                        HelpersMethod.ActClick(driver,okButton, 10000);

                    }
                    exists = true;
                }
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void ProductExistsCardDelete(String Qty_UnitCase, int i, String Prod) throws InterruptedException
    {
        WebElement WebEle;
        WebElement UpdateBut;
        exists=false;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
            HelpersMethod.ScrollElement(driver, WebEle);

            //Identify input box for Qty
            if (HelpersMethod.IsExists("//div[contains(@class,'i-notification-text')]", driver))
            {
                scenario.log("PRODUCT IS NOT FOUND");
            }
            else
            {
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'search-results-container')]", 10000);
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
                HelpersMethod.ScrollElement(driver, WebEle);
                if (WebEle.isDisplayed() && WebEle.isEnabled())
                {
                    HelpersMethod.ActSendKey(driver, WebEle, 10000, Qty_UnitCase);
                    scenario.log("QTY ENTERE IS " + Qty_UnitCase);

                    //Click on Add to cart button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@id,'addCartBtn')]");
                    HelpersMethod.ScrollElement(driver, WebEle);
                    HelpersMethod.ActClick(driver, WebEle, 10000);
                    Thread.sleep(500);
                    //"Product is currently unavailable" popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                    {
                        WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                        WebElement okButton=modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                        HelpersMethod.ActClick(driver,okButton, 10000);
                    }

                    //Click on delete button only for the first product
                    if (i == 1)
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@id,'deleteCartBtn')]//*[local-name()='svg']");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        scenario.log("DELETED PRODUCT # " + Prod);
                    }
                    exists = true;
                }
            }
            //driver.navigate().refresh();
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void Cart_Button()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if (Cart.isDisplayed() && Cart.isEnabled())
            {
                HelpersMethod.ScrollUpScrollBar(driver);
                HelpersMethod.JScriptClick(driver, Cart, 20000);
                Thread.sleep(1000);
                exists=true;
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
                Thread.sleep(2000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on Delete button in "Items in cart" page
    public void Delete_Button() throws InterruptedException
    {
        try
        {
            exists = false;
            WebElement Del_But = HelpersMethod.FindByElement(driver, "xpath", "//tr[1]//*[local-name()='svg' and contains(@class,'delete')]");
            HelpersMethod.ScrollElement(driver, Del_But);
            HelpersMethod.ActClick(driver, Del_But, 10000);
            scenario.log("FIRST PRODUCT HAS BEEN DELETED FROM ITEMS IN CART PAGE");
            exists = true;
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[1]/descendant::div[@class='product-number']");
            scenario.log("PRODUCT DELETED FROM CART IS " + WebEle.getText());
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    //click on checkout to order
    public void Checout_to_order() throws InterruptedException
    {
        exists=false;
        String status;
        try
        {
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@id,'cartItemsCard')]", 10000);
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'cartItemsCard')]")));

            HelpersMethod.ScrollElement(driver, Checkout);
            HelpersMethod.ActClick(driver, Checkout, 10000);
            exists = true;
            /*if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }*/
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Thread.sleep(6000);
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    //Code for entering Qty for products when Catalog is displayed in List view
    public void ProductExistsList(String QtyUnitCase) throws InterruptedException
    {
        exists=false;

        Wait<WebDriver> wait;
        String qtyEntered="";
        try
        {
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Thread.sleep(1000);
            //Find number of input boxes available to enter Qty with product details
            if (HelpersMethod.IsExists("//input[contains(@id,'catalog-list-view-quantity-input')]", driver))
            {
                unit_Qty = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'catalog-list-view-quantity-input')]");
                HelpersMethod.ScrollElement(driver, unit_Qty);
                HelpersMethod.ClearText(driver, unit_Qty, 10000);
                HelpersMethod.EnterText(driver, unit_Qty, 30000, QtyUnitCase);
                unit_Qty.sendKeys(Keys.TAB);

                 wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                qtyEntered=HelpersMethod.JSGetValueEle(driver,unit_Qty,10000);
                scenario.log("QTY ENTERED IS "+qtyEntered);
                //"Product is currently unavailable" popup
                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton=modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver,okButton, 10000);

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            else
            {
                QtyList=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'catalog-list-view-quantity-input')]");
                HelpersMethod.ClearText(driver, QtyList, 10000);
                HelpersMethod.EnterText(driver, QtyList, 10000, QtyUnitCase);
                QtyList.sendKeys(Keys.TAB);
                //Thread.sleep(2000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //"Product is currently unavailable" popup
                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement modalContainer =HelpersMethod.FindByElement (driver, "xpath","//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton=modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver,okButton, 10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }

            HelpersMethod.JSScroll(driver, Clear);
            HelpersMethod.ClickBut(driver, Clear, 10000);
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    //code to click on sort by best match
    public void Sort_By_ascending_order(String value)
    {
        boolean result=false;
        String dropText="";
        Actions act=new Actions(driver);
        try
        {
            if (SortByDropDown.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, SortByDropDown, 10000);
                List<WebElement> dropValues=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='sort-by-dropdown-listbox-id']/li/span");
                for(WebElement dropValue:dropValues)
                {
                    act.moveToElement(dropValue).build().perform();
                    dropText=dropValue.getText();
                    if(dropText.equalsIgnoreCase(value))
                    {
                        act.moveToElement(dropValue).build().perform();
                        act.click(dropValue).build().perform();
                        break;
                    }
                }

                List<WebElement> Prices = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='product-price-container']/descendant::span[@class='product-price']");
                List<Double> Prices1 = new ArrayList<>();
                List<Double> Prices2 = new ArrayList<>();

                //copy content of web element, i.e. prices to list
                scenario.log("PRODUCT FOUND IN LIST ");
                for (WebElement Price : Prices)
                {
                    String Price_Text = Price.getText();
                    scenario.log(Price_Text);
                    if (!Price_Text.equals(" "))
                    {
                        Prices1.add(Double.valueOf(Price_Text));
                        Prices2.add(Double.valueOf(Price_Text));
                    }
                }
                //Sort the values in ascending order
                Collections.sort(Prices1);
                //Comparing List of integers, to find whether array is in sorted order
                if (Prices1.equals(Prices2))
                {
                    scenario.log("PRODUCTS ARE IN SORTED ORDER");
                    result = true;
                }
                else
                {
                    scenario.log("PRODUCTS ARE NOT IN SORTED ORDER");
                }
            }
            else
            {
                scenario.log("SORTING DROP DOWN IS NOT VISIBLE");
            }
            Assert.assertEquals(result, true);
        }
        catch (Exception e){}
    }

    //Enter product details in search box separated by comma
    public void EnterProdSeparatedByComma(java.util.List<String> Prod) throws InterruptedException
    {
        boolean result=false;
        String Products="";
        java.util.List<String> ProdList=new ArrayList<String>();

        try
        {
            for (int i = 0; i <= Prod.size() - 1; i++)
            {
                Products = Products + String.valueOf(Prod.get(i) + ", ");
            }

            HelpersMethod.ActSendKey(driver, SearchBar, 10000, Products);
            HelpersMethod.ActClick(driver, SearchIndex, 10000);

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            scenario.log("PRODUCTS ENTERED IN SEARCH BOX " + Products);

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='product-catalog-page']"))));
            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-catalog-page']"))));

            scenario.log("PRODUCTS FOUND IN CATALOG");
            List<WebElement> Prods = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='product-number']/span");
            for (WebElement Product : Prods)
            {
                String Prod_Text = Product.getText();
                scenario.log(Prod_Text);
            }

            //get the product no. that get displayed on catalog page
            scenario.log("PRODUCTS FOUND WHEN SEARCHED SEPARATED BY COMMA: ");
            List<WebElement> Prods1 = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='product-number']/descendant::span");
            for (WebElement Pro : Prods1)
            {
                String Pro_Text = Pro.getText();
                ProdList.add(Pro_Text.substring(1));
            }

            //traverse through list to read product no. from both the list
         /*   for (int i = 0; i <= Prod.size() - 1; i++)
            {
                if (Prod.get(i).equals(ProdList.get(i)))
                {
                    scenario.log("Prod"+Prod.get(i)+"ProdList"+ProdList.get(i));
                    result = true;
                }
                else
                {
                    result = false;
                    break;
                }
            }*/
            String PText;
            String PText1;
            Prods1 = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='product-number']/descendant::span");
            for (WebElement Pro : Prods1)
            {
                PText = Pro.getText();
                PText1=PText.replaceAll("#","");
                for(int i=0;i<=ProdList.size()-1;i++)
                {
                    if (ProdList.contains(PText1))
                    {
                        result = true;
                    }
                    else
                    {
                        result = false;
                        break;
                    }
                }
            }

            Assert.assertEquals(result, true);
        }
        catch (Exception e){}
    }

    //Click on Category drop down and select the 1st option in the drop down
    public void CategoryDropDown(String categories) throws InterruptedException
    {
        exists=false;
        WebElement WebEle;
        Actions act1=new Actions(driver);
        String subcategories;
        String brand;
        int i=0;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if (Categories.isDisplayed())
            {
                HelpersMethod.ActClick(driver, Categories, 10000);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]"))));
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]", 2000);
                HelpersMethod.DropDownMenu(driver, categories);
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                //Display all the products belongs to selected categories
                if (HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products found.')]", driver))
                {
                    scenario.log("NO PRODUCTS HAS BEEN FOUND");
                }
                else
                {
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'search-results-container')]")));
                    scenario.log("PRODUCTS FOUND AFTER CATEGORIES FILTER: ");
                    List<WebElement> Products = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'grid-item-box-item description')]/descendant::a");
                    for (WebElement WebEle1 : Products)
                    {
                        HelpersMethod.ScrollElement(driver, WebEle1);
                        act1.moveToElement(WebEle1).build().perform();
                        String Prod_Text = WebEle1.getText();
                        scenario.log(Prod_Text);
                        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'product-catalog-container')]", 1000);
                    }

                    //Select Sub-categories
                    HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'product-catalog-container')]", 1000);
                    HelpersMethod.ScrollElement(driver, SubCat);
                    HelpersMethod.ActClick(driver, SubCat, 10000);
                    new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]"))));
                    HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 200);
                    WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
                    List<WebElement> subCats = modalContainer1.findElements(By.xpath(".//ul/li/span"));
                    for (WebElement subCat : subCats)
                    {
                        i++;
                        act1.moveToElement(subCat).build().perform();
                        if (i == 2)
                        {
                            subcategories = subCat.getText();
                            act1.moveToElement(subCat).build().perform();
                            act1.click(subCat).build().perform();
                            scenario.log("SUB CATEGORIES SELECTED IS " + subcategories);
                            break;
                        }
                    }
                    //Display all the products belongs to selected Sub-categories
                    if (HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products found.')]", driver))
                    {
                        scenario.log("NO PRODUCTS HAS BEEN FOUND");
                    }
                    else
                    {
                        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'search-results-container')]")));
                        scenario.log("PRODUCTS FOUND UNDER SUB CATEGORIES: ");
                        List<WebElement> Products1 = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'grid-item-box-item description')]/descendant::a");
                        for (WebElement WebEle1 : Products1)
                        {
                            HelpersMethod.ScrollElement(driver, WebEle1);
                            act1.moveToElement(WebEle1).build().perform();
                            String Prod_Text = WebEle1.getText();
                            scenario.log(Prod_Text);
                            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'product-catalog-container')]", 1000);
                        }
                        //Select Brand
                        int j = 0;
                        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'product-catalog-container')]", 1000);
                        HelpersMethod.ScrollElement(driver, Brand);
                        HelpersMethod.ActClick(driver, Brand, 10000);
                        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]"))));
                        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 200);
                        WebElement modalContainer2 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
                        List<WebElement> brands = modalContainer2.findElements(By.xpath(".//ul/li/span"));
                        for (WebElement bran : brands)
                        {
                            j++;
                            act1.moveToElement(bran).build().perform();
                            if (j == 2)
                            {
                                brand = bran.getText();
                                act1.moveToElement(bran).build().perform();
                                act1.click(bran).build().perform();
                                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                                {
                                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                                }
                                scenario.log("BRAND SELECTED IS " + brand);
                                break;
                            }
                        }
                        if (HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products found.')]", driver))
                        {
                            scenario.log("NO PRODUCTS HAS BEEN FOUND");
                        }
                        else
                        {
                            //Display all the products belongs to selected Sub-categories
                            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'search-results-container')]")));
                            scenario.log("PRODUCTS FOUND UNDER BRAND: ");
                            List<WebElement> Products2 = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'grid-item-box-item description')]/descendant::a");
                            for (WebElement WebEle1 : Products2)
                            {
                                HelpersMethod.ScrollElement(driver, WebEle1);
                                act1.moveToElement(WebEle1).build().perform();
                                String Prod_Text = WebEle1.getText();
                                scenario.log(Prod_Text);
                            }
                        }
                    }
                }
            }
            else
            {
                scenario.log("CATEGORY DROP DOWN IS NOT VISIBLE");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    //Code to verify whether category has been reset to All category or not after clicking reset button
    public void VerifyCategory()
    {
        WebElement WebEle;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            String Cat_text=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPcategories']/span[@class='k-input']").getText();
            if(Cat_text.equalsIgnoreCase("All categories"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ReturnToLogin()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver, ReturnLogin, 10000);
            scenario.log("RETURN TO LOGIN PAGE BUTTON HAS BEEN CLICKED");
            Thread.sleep(1000);
            if(driver.getTitle().contains("Login"))
            {
                scenario.log("NAVIGATED BACK TO LOGIN PAGE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnAllProduct()
    {
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                WebElement loadProd=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
                HelpersMethod.ActClick(driver,loadProd,10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }
}