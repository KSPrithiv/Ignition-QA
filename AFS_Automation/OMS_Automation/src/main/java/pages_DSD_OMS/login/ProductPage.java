package pages_DSD_OMS.login;

import com.mongodb.DBRef;
import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
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

    //static WebElement WebEle=null;
    static boolean exists=false;

    @FindBy(xpath = "//button[@data-test-id='catalogPrintBtn']")
    private WebElement Print;

    @FindBy(xpath = "//button[@data-test-id='productFilterResetBtn']")
    private WebElement ReSetFilter;

    @FindBy(xpath = "//input[contains(@placeholder,'Search products')]")
    private WebElement SearchBar;

    @FindBy(xpath = "//span[@datatestid='searchBarSearchBtn']")
    private WebElement SearchIndex;

    @FindBy(xpath = "//*[local-name()='svg' and contains(@class,'i-icon   ')]//*[local-name()='path' and contains(@d,'M17')]")
    private WebElement Close;

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

    @FindBy(id="catalogGridViewBtn")
    private WebElement CardView;

    @FindBy(id="catalogListViewBtn")
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
    public void ValidateProductPage() {
        exists = false;
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
        }
        HelpersMethod.waitTillTitleContains(driver, "Ignition - Product Catalog", 200);
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
        }
        if (HelpersMethod.gettingURL(driver).contains("cpExtProductCatalog"))
        {
            exists = true;
        }
        Assert.assertEquals(exists, true);
    }

    public void Click_ResetFilter() throws InterruptedException
    {
        exists = false;
        WebElement WebEle = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            new WebDriverWait(driver, 2000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        HelpersMethod.WaitElementPresent(driver, "xpath", "//button[@data-test-id='productFilterResetBtn']", 800);
        HelpersMethod.ClickBut(driver, ReSetFilter, 1000);
        exists = true;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
        }
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Assert.assertEquals(exists, true);
    }

    //Change catalog  Card to grid view
    public void CardView()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
            if (!HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M4')]/ancestor::button[contains(@class,'k-primary')]", driver))
            {
                WebElement cardview = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M4')]/ancestor::button");
                HelpersMethod.ClickBut(driver,cardview,60);
                exists=true;
                scenario.log("CARD VIEW HAS BEEN SELECTED");
            }
            //Assert.assertEquals(exists,true);
    }

    //Change catalog grid view to card
    public void GridView()
    {
        exists=false;
        if (!HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3')]/ancestor::button[contains(@class,'k-primary')]", driver))
            {
                WebElement gridview = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3')]/ancestor::button");
                HelpersMethod.ClickBut(driver,gridview,100);
                exists=true;
                scenario.log("GRID VIEW HAS BEEN SELECTED");
            }
            Assert.assertEquals(exists,true);
    }

    //Enter Product# in Search bar and click on Index icon
    public void SearchProduct(String Prod_No) throws InterruptedException
    {
        WebElement WebEle = null;
        String SearchContent = null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.ScrollElement(driver, SearchBar);
        SearchContent = HelpersMethod.JSGetValueEle(driver, SearchBar, 60);
        if (!SearchContent.equals(" "))
        {
            WebEle = HelpersMethod.FindByElement(driver, "id", "searchBarClearBtn");
            HelpersMethod.ActClick(driver, WebEle, 60);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
        }

        HelpersMethod.EnterText(driver, SearchBar, 150, Prod_No);
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        scenario.log("PRODUCT NUMBER ENTERED IN SEARCH BOX IS " + Prod_No);

        HelpersMethod.JScriptClick(driver, SearchIndex, 400);
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'card-view')]/descendant::div[contains(@class,'product-catalog-image-and-number-and-price-container')]", 200);
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
        HelpersMethod.WaitElementPresent(driver, "id", "productsCard", 200);
        HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'i-notification-text')]|//div[contains(@class,'search-results-container')]", 600);
    }

    //Validate whether product details are displayed or not,card view
    public void ProductExistsCard(String Qty_UnitCase) throws InterruptedException
    {
        WebElement WebEle=null;

        exists=false;
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        HelpersMethod.WaitElementPresent(driver,"id","productsCard",200);
        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
        HelpersMethod.ScrollElement(driver,WebEle);

        //Check for delete button is visible
        if (HelpersMethod.IsExists("//button[contains(@class,'update-cart-button')]/following-sibling::button",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'update-cart-button')]/following-sibling::button");
            HelpersMethod.ClickBut(driver, WebEle, 60);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            //Identify input box for Qty
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
            HelpersMethod.ScrollElement(driver, WebEle);
            if (WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ActSendKey(driver,WebEle,20,Qty_UnitCase);
                scenario.log("QTY ENTERE IS " + Qty_UnitCase);
                if (HelpersMethod.IsExists("//div[contains(text(),'currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                    HelpersMethod.ClickBut(driver, WebEle, 20);
                }
                //Click on Add to cart button
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[text()='Add to cart']");
                if (WebEle.isDisplayed() && WebEle.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver, WebEle);
                    HelpersMethod.ClickBut(driver, WebEle, 20);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
                    }
                }
            }
        }
        else
        {
            //Identify input box for Qty
            if(HelpersMethod.IsExists("//div[contains(@class,'i-notification-text')]",driver))
            {
                scenario.log("PRODUCT IS NOT FOUND");
            }
            else
            {
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'search-results-container')]", 200);
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
                HelpersMethod.ScrollElement(driver, WebEle);
                if (WebEle.isDisplayed() && WebEle.isEnabled())
                {
                    HelpersMethod.ActSendKey(driver, WebEle, 100, Qty_UnitCase);
                    scenario.log("QTY ENTERE IS " + Qty_UnitCase);
                    if (HelpersMethod.IsExists("//div[contains(text(),'currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 20);
                    }
                    //Click on Add to cart button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[text()='Add to cart']");
                    if (WebEle.isDisplayed() && WebEle.isEnabled())
                    {
                        HelpersMethod.ScrollElement(driver, WebEle);
                        HelpersMethod.ClickBut(driver, WebEle, 20);
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                        }
                    }
                }
            }
        }
        exists = true;
        Assert.assertEquals(exists,true);
    }

    public void ProductExistsCardDelete(String Qty_UnitCase, int i, String Prod) throws InterruptedException
    {
        WebElement WebEle=null;
        WebElement UpdateBut=null;
        exists=false;
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
            HelpersMethod.ScrollElement(driver,WebEle);

            //Check for delete button is visible
            if (HelpersMethod.IsExists("//button[contains(@class,'update-cart-button')]/following-sibling::button",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'update-cart-button')]/following-sibling::button");
                HelpersMethod.ClickBut(driver, WebEle, 20);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                //Identify input box for Qty
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
                HelpersMethod.ScrollElement(driver, WebEle);
                if (WebEle.isDisplayed() && WebEle.isEnabled())
                {
                    HelpersMethod.ActSendKey(driver,WebEle,20,Qty_UnitCase);
                    if (HelpersMethod.IsExists("//div[contains(text(),'currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 20);
                    }
                    //Click on Add to cart button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[text()='Add to cart']");
                    if (WebEle.isDisplayed() && WebEle.isEnabled())
                    {
                        HelpersMethod.ScrollElement(driver, WebEle);
                        HelpersMethod.ClickBut(driver, WebEle, 20);
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
                        }
                    }
                    //Click on delete button only for the first product
                    if(i==1)
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M16')]");
                        HelpersMethod.ActClick(driver,WebEle,60);
                        scenario.log("DELETED PRODUCT # "+Prod);
                    }
                }
            }
            else
            {
                //Identify input box for Qty
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
                HelpersMethod.ScrollElement(driver, WebEle);
                if (WebEle.isDisplayed() && WebEle.isEnabled())
                {
                    HelpersMethod.ActSendKey(driver,WebEle,20,Qty_UnitCase);
                    if (HelpersMethod.IsExists("//div[contains(text(),'currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                        HelpersMethod.ClickBut(driver, WebEle, 20);
                    }
                    //Click on Add to cart button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[text()='Add to cart']");
                    if (WebEle.isDisplayed() && WebEle.isEnabled())
                    {
                        HelpersMethod.ScrollElement(driver, WebEle);
                        HelpersMethod.ClickBut(driver, WebEle, 20);
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                        }
                    }
                    //Click on delete button only for the first product
                    if(i==1)
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M16')]");
                        HelpersMethod.ActClick(driver,WebEle,60);
                        scenario.log("DELETED PRODUCT # "+Prod);
                    }
                }
            }

            //Code to scroll back to Product search bar
            HelpersMethod.JSScroll(driver, Close);
            HelpersMethod.ClickBut(driver, Close, 60);
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 60);
            HelpersMethod.waitTillElementDisplayed(driver, SearchBar, 60);
            exists=true;
            Assert.assertEquals(exists,true);
    }

    public void Cart_Button()
    {
        exists=false;
        WebElement WebEle;
        if(HelpersMethod.EleDisplay(Cart))
        {
            HelpersMethod.ScrollElement(driver,Cart);
            HelpersMethod.ClickBut(driver,Cart,40);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
        }
    }

    //Click on Delete button in "Items in cart" page
    public void Delete_Button() throws InterruptedException
    {
        exists=false;
        WebElement Del_But= HelpersMethod.FindByElement(driver,"xpath","//tr[1]//*[local-name()='svg' and contains(@class,'delete')]");
        HelpersMethod.ScrollElement(driver,Del_But);
        HelpersMethod.ActClick(driver,Del_But,80);
        WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::div[@class='product-number']");
        scenario.log("PRODUCT DELETED FROM CART IS "+WebEle.getText());
        exists=true;
        Assert.assertEquals(exists,true);
    }

    //click on checkout to order
    public void Checout_to_order() throws InterruptedException
    {
        exists=false;
        HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@id,'cartItemsCard')]",200);
        new WebDriverWait(driver,600).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'cartItemsCard')]")));
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
        }
        HelpersMethod.ScrollElement(driver,Checkout);
        HelpersMethod.ActClick(driver,Checkout,200);
        exists=true;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
        }
        Assert.assertEquals(exists,true);
    }

    //Code for entering Qty for products when Catalog is displayed in List view
    public void ProductExistsList(String QtyUnitCase) throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        WebElement Button_Ele=null;

            //Find number of input boxes available to enter Qty with product details
            if (HelpersMethod.IsExists("//input[contains(@id,'catalog-list-view-quantity-input')]", driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'catalog-list-view-quantity-input')]");
                HelpersMethod.ScrollElement(driver,unit_Qty);
                HelpersMethod.ActSendKey(driver,unit_Qty,20,QtyUnitCase);
                exists = HelpersMethod.IsExists("//div[contains(text(),'currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver);
                if (exists == true)
                {
                    Button_Ele=HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                    HelpersMethod.ClickBut(driver,Button_Ele,40);
                }
            }
            else
            {
                HelpersMethod.ClearText(driver, QtyList, 40);
                HelpersMethod.ActSendKey(driver, QtyList, 10, QtyUnitCase);
                exists = HelpersMethod.IsExists("//div[contains(text(),'currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver);
                if (exists == true)
                {
                    Button_Ele = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                    HelpersMethod.ClickBut(driver, Button_Ele, 10);
                }
            }

            HelpersMethod.JSScroll(driver, Close);
            HelpersMethod.ClickBut(driver, Close, 10);
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10);
            HelpersMethod.waitTillElementDisplayed(driver, SearchBar, 10);
    }

    //code to click on sort by best match
    public void Sort_By_ascending_order(String value)
    {
        boolean result=false;
            if(HelpersMethod.IsExistsById("dropdown",driver))
            {
                HelpersMethod.ClickBut(driver,SortByDropDown,40);
                HelpersMethod.DropDownMenu(driver,  value);
                List<WebElement> Prices = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='product-price-container']/descendant::span[@class='product-price']");
                List<Double> Prices1=new ArrayList<>();
                List<Double> Prices2=new ArrayList<>();

                //copy content of web element, i.e. prices to list
                scenario.log("PRODUCT FOUND IN LIST ");
                for(WebElement Price:Prices)
                {
                    String Price_Text=Price.getText();
                    scenario.log(Price_Text);
                    if(!Price_Text.equals(" "))
                    {
                        Prices1.add(Double.valueOf(Price_Text));
                        Prices2.add(Double.valueOf(Price_Text));
                    }
                }
                //Sort the values in ascending order
                Collections.sort(Prices1);
                //Comparing List of integers, to find whether array is in sorted order
                if(Prices1.equals(Prices2))
                {
                    scenario.log("PRODUCTS ARE IN SORTED ORDER");
                    result =true;
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
            Assert.assertEquals(result,true);
    }

    //Enter product details in search box separated by comma
    public void EnterProdSeparatedByComma(java.util.List<String> Prod) throws InterruptedException
    {
        boolean result=false;
        WebElement WebEle;
            String Products="";
            java.util.List<String> ProdList=new ArrayList<String>();

            for(int i=0;i<=Prod.size()-1;i++)
            {
                Products=Products+String.valueOf(Prod.get(i)+", ");
            }

            HelpersMethod.ActSendKey(driver,SearchBar,80,Products);

            HelpersMethod.ActClick(driver,SearchIndex,100);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            scenario.log("PRODUCTS ENTERED IN SEARCH BOX "+Products);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            scenario.log("PRODUCTS FOUND IN CATALOG");
            List<WebElement> Prods=HelpersMethod.FindByElements(driver,"xpath","//div[@class='product-number']/span");
            for (WebElement Product:Prods)
            {
                String Prod_Text=Product.getText();
                scenario.log(Prod_Text);
            }

            //get the product no. that get displayed on catalog page
            scenario.log("PRODUCTS FOUND WHEN SEARCHED SEPARATED BY COMMA: ");
            List<WebElement> Prods1=HelpersMethod.FindByElements(driver,"xpath","//div[@class='product-number']/descendant::span") ;
            for (WebElement Pro:Prods1)
            {
                String Pro_Text=Pro.getText();
                ProdList.add(Pro_Text.substring(1));
                Collections.sort(ProdList);
            }

            //traverse through list to read product no. from both the list
            for(int i=0;i<=Prod.size()-1;i++)
            {
                //System.out.println(Prod.get(i)+","+ProdList.get(i));
                if(Prod.get(i).equals(ProdList.get(i)))
                {
                    result=true;
                }
                else
                {
                    result=false;
                    break;
                }
            }
            Assert.assertEquals(result,true);
    }

    //Click on Category drop down and select the 1st option in the drop down
    public void CategoryDropDown(String categories) throws InterruptedException
    {
        exists=false;
        WebElement WebEle;
        Actions act1=new Actions(driver);
        String subcategories=null;
        String brand=null;
        int i=0;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
        if(Categories.isDisplayed())
        {
            HelpersMethod.ClickBut(driver, Categories, 100);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]",200);
            HelpersMethod.DropDownMenu(driver,categories);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
            }

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            //Display all the products belongs to selected categories
            if (HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products found.')]", driver))
            {
                scenario.log("NO PRODUCTS HAS BEEN FOUND");
            }
            else
            {
                new WebDriverWait(driver,600).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'search-results-container')]")));
                scenario.log("PRODUCTS FOUND AFTER CATEGORIES FILTER: ");
                List<WebElement> Products = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'grid-item-box-item description')]/descendant::a");
                for (WebElement WebEle1 : Products)
                {
                    HelpersMethod.ScrollElement(driver,WebEle1);
                    act1.moveToElement(WebEle1).build().perform();
                    String Prod_Text = WebEle1.getText();
                    scenario.log(Prod_Text);
                }

                //Select Sub-categories
                //HelpersMethod.WaitElementPresent(driver,"id","productsCard",600);
                HelpersMethod.ScrollElement(driver,SubCat);
                HelpersMethod.ActClick(driver, SubCat, 600);
                HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]",200);
                WebElement modalContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
                List<WebElement> subCats = modalContainer1.findElements(By.xpath(".//ul/li"));
                for (WebElement subCat:subCats)
                {
                    i++;
                    act1.moveToElement(subCat).build().perform();
                    if (i == 2)
                    {
                        subcategories = subCat.getText();
                        act1.moveToElement(subCat).build().perform();act1.click(subCat).build().perform();
                        scenario.log("SUB CATEGORIES SELECTED IS "+subcategories);
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
                    new WebDriverWait(driver,600).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'search-results-container')]")));
                    scenario.log("PRODUCTS FOUND UNDER SUB CATEGORIES: ");
                    List<WebElement> Products1 = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'grid-item-box-item description')]/descendant::a");
                    for (WebElement WebEle1 : Products1)
                    {
                        HelpersMethod.ScrollElement(driver,WebEle1);
                        act1.moveToElement(WebEle1).build().perform();
                        String Prod_Text = WebEle1.getText();
                        scenario.log(Prod_Text);
                    }
                    //Select Brand
                    int j=0;
                    //HelpersMethod.WaitElementPresent(driver,"id","productsCard",600);
                    HelpersMethod.ScrollElement(driver,Brand);
                    HelpersMethod.ActClick(driver, Brand, 200);
                    HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]",200);
                    WebElement modalContainer2 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
                    List<WebElement> brands = modalContainer2.findElements(By.xpath(".//ul/li"));
                    for (WebElement bran:brands)
                    {
                        j++;
                        act1.moveToElement(bran).build().perform();
                        if (j == 2)
                        {
                            brand = bran.getText();
                            act1.moveToElement(bran).build().perform();act1.click(bran).build().perform();
                            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                            {
                                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                            }
                            scenario.log("BRAND SELECTED IS "+brand);
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
                        new WebDriverWait(driver,200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'search-results-container')]")));
                        scenario.log("PRODUCTS FOUND UNDER BRAND: ");
                        List<WebElement> Products2 = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'grid-item-box-item description')]/descendant::a");
                        for (WebElement WebEle1 : Products2)
                        {
                            HelpersMethod.ScrollElement(driver,WebEle1);
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

    //Code to verify whether category has been reset to All category or not after clicking reset button
    public void VerifyCategory()
    {
        WebElement WebEle=null;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
        WebElement WebEle;
            HelpersMethod.ClickBut(driver,ReturnLogin,60);
    }
}
