package pages_DSD_OMS.Catalog;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CatalogPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;

    static boolean exists=false;
    static int totalNum;

    @FindBy(xpath="//button[@data-test-id='productFilterResetBtn' and contains(text(),'Reset filter')]//*[local-name()='svg']")
    private WebElement ResetFilter;

    @FindBy(xpath = "//input[contains(@placeholder,'Search products')]")
    private WebElement SearchBar;

    @FindBy(xpath = "//span[contains(@class,'search-button-addon search-button input-group-addon')]/descendant::*[local-name()='svg']")
    private WebElement SearchIndex;

    @FindBy(xpath = "//span[@id='searchBarClearBtn']//*[local-name()='svg']")
    private WebElement SearchClear;

    @FindBy(id="sort-by-dropdown")
    private WebElement SortByDropDown;

    @FindBy(xpath = "//div[contains(@class,'shopping-cart-container notification-center-item')]")
    private WebElement Cart;

    @FindBy(id="CPcategories")
    private WebElement Categories;

    @FindBy(id="CPbrands")
    private WebElement SubCat;

    @FindBy(id="CPsizes")
    private WebElement Brand;

    @FindBy(id="CPorderGuies")
    private WebElement OGDrop;

    @FindBy(id="go-to-dropdown")
    private WebElement pagination;

    //Constructor for Catalog page, Initializing the Page Objects:
    public CatalogPage(WebDriver driver, Scenario scenario)
    {
        this.scenario=scenario;
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void ValidateCatalog()
    {
        exists=false;
        String currentTitle=null;
        try
        {
            currentTitle=driver.getTitle();
            if(currentTitle.contains("Product Catalog"))
            {
                scenario.log("CATALOG PAGE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //code to click on Reset button
    public void Click_ResetFilterButton()
    {
        exists=false;
        WebElement WebEle=null;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
        try
        {
            ResetFilter=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='productFilterResetBtn' and contains(text(),'Reset filter')]//*[local-name()='svg']");
            HelpersMethod.ScrollElement(driver,ResetFilter);
            HelpersMethod.ClickBut(driver,ResetFilter,1000);
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

    //Code to click on Card view
    public void Click_CardView()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebElement CardView=HelpersMethod.FindByElement(driver,"xpath","//button[@data-test-id='catalogGridViewBtn']");
            if(CardView.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, CardView);
                HelpersMethod.ClickBut(driver, CardView, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    scenario.log("CARD VIEW IN CATALOG HAS BEEN SELECTED");
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //code to click on List view
    public void Click_ListView()
    {
        exists=false;
        WebElement WebEle=null;
      /*  if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }*/
        try
        {
            WebElement ListView=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@data-test-id,'catalogListViewBtn')]");
            if(ListView.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, ListView);
                HelpersMethod.ClickBut(driver, ListView, 2000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
                if(HelpersMethod.IsExists("//div[@class='list-view']",driver))
                {
                    scenario.log("CARD VIEW IN CATALOG HAS BEEN SELECTED");
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Verify existence of sort by best match drop down, and then click on it. And select value from drop down
    public void Best_MatchDropDown(String DropSelect)
    {
        exists=false;
        boolean result=false;
        WebElement WebEle=null;
        Actions act1=new Actions(driver);
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
        try
        {
            if(SortByDropDown.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,SortByDropDown);
                HelpersMethod.ClickBut(driver,SortByDropDown,2000);
                new WebDriverWait(driver, Duration.ofMillis(100)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]"))));
                List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]/descendant::ul/li");
                for(WebElement opt: Options)
                {
                    act1.moveToElement(opt).build().perform();
                    String opt_Text=opt.getText();
                    if(opt_Text.equals(DropSelect))
                    {
                        act1.moveToElement(opt).build().perform();
                        act1.click(opt).build().perform();
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                        }
                        break;
                    }
                }
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='list-view']");
                HelpersMethod.ScrollElement(driver,WebEle);
                List<WebElement> Prices = HelpersMethod.FindByElements(driver, "xpath", "//span[@class='product-price']");
                ArrayList<Double> Prices1=new ArrayList<Double>();
                ArrayList<Double> Prices2=new ArrayList<Double>();

                //copy content of web element, i.e. prices to list
                for(WebElement Price:Prices)
                {
                    String Price_Text=Price.getText();
                    if(!Price_Text.equals(" "))
                    {
                        Prices1.add(Double.valueOf(Price_Text));
                        Prices2.add(Double.valueOf(Price_Text));
                    }
                }
                //Sort the values in ascending order
                Collections.sort(Prices1);

                //Comparing List of integers, to find whether array is in sorted order
                for (int i = 0; i < Prices1.size(); i++)
                {
                    System.out.println("VALUES AFTER SELECTING PRICE SORT FROM DROP DOWN "+Prices1.get(i)+" VALUE AFTER PROGRAMMATICALLY SORTING "+Prices2.get(i));
                    if (Prices1.get(i).equals(Prices2.get(i)))
                    {
                        result = true;
                        scenario.log("EXPECTED VALUE: "+Prices1.get(i)+" FOUND VALUE: "+Prices2.get(i));
                    }
                    else
                    {
                        result=false;
                        scenario.log("EXPECTED VALUE: "+Prices1.get(i)+" FOUND VALUE: "+Prices2.get(i));
                        scenario.log("PRICES ARE NOT IN SORTED ORDER");
                        break;
                    }
                }
                Assert.assertEquals(result,true);
            }
            else
            {
                scenario.log("SORT BY BEST MATCH IS NOT VISIBLE");
            }
        }
        catch (Exception e){}
    }

    public void Best_MatchDropDownPagination(String DropSelect)
    {
        Actions act1=new Actions(driver);
        try
        {
            if (SortByDropDown.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, SortByDropDown);
                HelpersMethod.ActClick(driver, SortByDropDown, 2000);
                new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]")));

                WebElement menuContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]");
                List<WebElement> Options = menuContainer.findElements(By.xpath(".//ul/li"));
                for (WebElement opt : Options)
                {
                    act1.moveToElement(opt).build().perform();
                    String opt_Text = opt.getText();
                    if (opt_Text.equals(DropSelect))
                    {
                        act1.moveToElement(opt).build().perform();
                        act1.click(opt).build().perform();
                        exists = true;
                        break;
                    }
                }
            }
        }
        catch(Exception e){}
    }

    public void navigateToLastPage()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(pagination.isDisplayed() &&  pagination.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,pagination);
                HelpersMethod.ActClick(driver,pagination,100);
                WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
                List<WebElement> listValue=dropDown.findElements(By.xpath(".//ul/li"));
                for (int i=0;i<=listValue.size()-1;i++)
                {
                    act.moveToElement(listValue.get(i));
                    if(i==listValue.size()-1)
                    {
                        act.moveToElement(listValue.get(i)).click().build().perform();
                        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                        {
                            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                        }
                        exists=true;
                        break;
                    }
                }
                String pageNo=HelpersMethod.FindByElement(driver,"xpath","//span[@id='go-to-dropdown']/span[@class='k-input']").getText();
                scenario.log("YOU ARE IN PAGE "+pageNo);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void sortingValue()
    {
        exists=false;
        try
        {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='list-view']");
                HelpersMethod.ScrollElement(driver,WebEle);
                List<WebElement> Prices = HelpersMethod.FindByElements(driver, "xpath", "//span[@class='product-price']");
                ArrayList<Double> Prices1=new ArrayList<Double>();
                ArrayList<Double> Prices2=new ArrayList<Double>();

                //copy content of web element, i.e. prices to list
                for(WebElement Price:Prices)
                {
                    String Price_Text=Price.getText();
                    if(!Price_Text.equals(" "))
                    {
                        Prices1.add(Double.valueOf(Price_Text));
                        Prices2.add(Double.valueOf(Price_Text));
                    }
                }
                //Sort the values in ascending order
                Collections.sort(Prices1);

                //Comparing List of integers, to find whether array is in sorted order
                for (int i = 0; i < Prices1.size(); i++)
                {
                    System.out.println("VALUES AFTER SELECTING PRICE SORT FROM DROP DOWN "+Prices1.get(i)+" VALUE AFTER PROGRAMMATICALLY SORTING "+Prices2.get(i));
                    if (Prices1.get(i).equals(Prices2.get(i)))
                    {
                        exists=true;
                        scenario.log("EXPECTED VALUE: "+Prices1.get(i)+" FOUND VALUE: "+Prices2.get(i));
                    }
                    else
                    {
                        exists=false;
                        scenario.log("EXPECTED VALUE: "+Prices1.get(i)+" FOUND VALUE: "+Prices2.get(i));
                        scenario.log("PRICES ARE NOT IN SORTED ORDER");
                        break;
                    }
                }
                Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code for entering products in search bar
    public void SearchProduct(String Prod_no)
    {
        exists=false;
        WebElement WebEle=null;
        String status=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'filter-and-search-container')]");
            HelpersMethod.ScrollElement(driver,WebEle);
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.ScrollElement(driver,SearchClear);
            HelpersMethod.ClickBut(driver,SearchClear,4000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }

            //Enter product# in search bar
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@class,'product-search-input')]");
            HelpersMethod.EnterText(driver,WebEle,4000,Prod_no);
            scenario.log("PRODUCT SEARCHED IS "+Prod_no);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }

            //Click on search Index button
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@datatestid='searchBarSearchBtn']");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //This part of code is used when Cases and units are entered in same input box
    public void ProductExistsCard(String Qty_UnitCase) throws InterruptedException
    {
        WebElement WebEle=null;
        WebElement UpdateBut=null;
        exists=false;
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
        }

        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
            HelpersMethod.ScrollElement(driver,WebEle);

            //Check for delete button is visible
            if (HelpersMethod.IsExists("//button[contains(@class,'update-cart-button')]/following-sibling::button",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'update-cart-button')]/following-sibling::button");
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ClickBut(driver, WebEle, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
            }

            //Identify input box for Qty
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
            HelpersMethod.ScrollElement(driver, WebEle);
            if (WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ActSendKey(driver,WebEle,40,Qty_UnitCase);
                scenario.log("QTY ENTERE IS " + Qty_UnitCase);
                status=HelpersMethod.returnDocumentStatus(driver);
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
               /* if (HelpersMethod.IsExists("//div[contains(text(),'currently unavailable.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                    HelpersMethod.ClickBut(driver, WebEle, 40);
                }*/
                //Click on Add to cart button
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[contains(text(),'Add to cart')]");
                if (WebEle.isDisplayed() && WebEle.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver, WebEle);
                    HelpersMethod.ClickBut(driver, WebEle, 100);
                    exists = true;
                    status=HelpersMethod.returnDocumentStatus(driver);
                    if(status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                    }
                    status=HelpersMethod.returnDocumentStatus(driver);
                    if(status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //To increment Qty in card view
    public void IncrementCard_button()
    {
        exists=false;
        WebElement WebEle=null;
        WebElement UpdateBut=null;
        String Qty=null;
        try
        {
            //Increment the qty
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'buttonPlus')]");
            HelpersMethod.ActClick(driver,WebEle,40);

            //Identify update button
            UpdateBut=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'update-cart-button')]/descendant::span");
            HelpersMethod.ClickBut(driver,UpdateBut,40);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600);
            }

            //Read the Qty updated
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'ProductGridItemQuantityContainer')]");
            Qty=HelpersMethod.JSGetValueEle(driver,WebEle,40);
            scenario.log("QTY INCREMENTED IS "+Qty);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //To decrement Qty in card view
    public void DecrementCard_button()
    {
        exists=false;
        WebElement WebEle=null;
        WebElement UpdateBut=null;
        String Qty=null;
        new WebDriverWait(driver,Duration.ofMillis(100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'buttonMinus')]")));
        new WebDriverWait(driver,Duration.ofMillis(100)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'buttonMinus')]")));
        try
        {
            //Decrement the qty
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'buttonMinus')]");
            HelpersMethod.ClickBut(driver,WebEle,40);

            //Identify update button
            UpdateBut=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'update-cart-button')]/descendant::span");
            HelpersMethod.ClickBut(driver,UpdateBut,40);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }

            //Read the Qty updated
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'ProductGridItemQuantityContainer')]");
            Qty=HelpersMethod.JSGetValueEle(driver,WebEle,40);
            scenario.log("QTY DECREMENTED IS "+Qty);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on Cart button
    public void Cart_Button()
    {
        exists=false;
        try
        {
         /*   if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }*/

             if(Cart.isDisplayed())
            {
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(Cart)));
            HelpersMethod.ActClick(driver,Cart,1000);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",40);
            if(HelpersMethod.IsExists("//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",driver))
            {
                scenario.log("CART ICON HAS BEEN CLICKED");
                exists=true;
            }
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
          /*  if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }*/
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on GotoCart button
    public void GotoCartClick()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            Actions act = new Actions(driver);
            //Identify the Shopping cart drop down
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Shopping cart')]/ancestor::div[contains(@class,'k-animation-container k-animation-container-relative popup-with-arrow standard-view shopping-cart-popup k-animation-container-shown')]"))));
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",40);
            WebElement shoppingCart=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
            //Identify the Go to cart button
            WebElement goToCart = shoppingCart.findElement(By.xpath(".//button[@id='goToCartButton']"));
            act.moveToElement(goToCart).build().perform();
            act.click(goToCart).build().perform();
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            exists=true;
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[@id='cartItemsCard']",400);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to Delete Product from Shopping cart popup and Click on GotoCart button
    public void DeleteProd_GotoCartClick()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            Actions act = new Actions(driver);
            //Find the first product in Shopping cart
            WebElement shoppingCart=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
            WebElement ProdRow = shoppingCart.findElement(By.xpath(".//div[@class='shopping-cart-row'][1]"));
            act.moveToElement(ProdRow).build().perform();
            //find the discription of the prodcut which will be deleted
            WebElement ProdDesc=shoppingCart.findElement(By.xpath(".//div[@class='shopping-cart-row'][1]/descendant::div[contains(@class,'description')]"));
            scenario.log("PRODUCT REMOVED FROM DROP DOWN IS "+ProdDesc.getText());
            //Identify the 'x' symbol of the first product
            WebElement x_Delete = shoppingCart.findElement(By.xpath(".//div[@class='shopping-cart-row'][1]/descendant::div[@class='item-remove-button']"));

            //Move control 'x' button of first product to delete the product from cart
            act.moveToElement(x_Delete).build().perform();
            act.click(x_Delete).build().perform();
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            exists=true;
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",40);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Code to click on Goto cart button, this part of code is used only in scenario where trying to delete product from shopping cart popup
    public void ClickGotoCart1()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            Actions act = new Actions(driver);
            //Identify the Shopping cart drop down
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",40);
            WebElement shoppingCart=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]");
            //Identify the Go to cart button
            WebElement goToCart = shoppingCart.findElement(By.xpath(".//button[@id='goToCartButton']"));
            act.moveToElement(goToCart).build().perform();
            act.click(goToCart).build().perform();
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            exists=true;
            new WebDriverWait(driver,Duration.ofMillis(800)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cartItemsCard']"))));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void validateCartItemCard()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20000);
            }

            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("cartItemsCard"))));
            if(HelpersMethod.IsExists("//div[@id='cartItemsCard']",driver))
            {
                scenario.log("CART ITEMS CARD HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //click on checkout to order
    public void Checkout_to_order()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("cartItemsCard"))));
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("cartItemsCard")));
            if(HelpersMethod.IsExists("//span[contains(text(),'Items in cart')]",driver))
            {
                WebElement Checkout=HelpersMethod.FindByElement(driver,"id","checkoutToOrder");
                if(Checkout.isDisplayed() && Checkout.isEnabled())
                {
                    //to handle start new order popup
                    if(HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog') ]/descendant::button[contains(text(),'Start new order')]");
                        HelpersMethod.ClickBut(driver,WebEle,200);
                    }

                    HelpersMethod.ScrollElement(driver, Checkout);
                    HelpersMethod.ActClick(driver,Checkout,2000);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                    }

                    //Check for Pending order popup and select start new order button in popup
                    if (HelpersMethod.IsExists("//div[contains(text(),' open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                    {
                        WebElement Button_Start = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Start new order')]");
                        HelpersMethod.ActClick(driver,Button_Start,100);
                    }

                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                    }
                }
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Select new order from popup
    public void NewOrder_Option()
    {
        exists=true;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Select order')]/ancestor::div[@class='k-widget k-window k-dialog']",driver))
            {
                //select 'New order button'
                WebElement newOrderPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Select order')]/ancestor::div[@class='k-widget k-window k-dialog']");
                WebElement newOrderButton=newOrderPopup.findElement(By.xpath(".//div[contains(text(),'New order')]"));
                HelpersMethod.ActClick(driver,newOrderButton,100);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }

                //Click on 'Ok' button
                WebElement okButton=newOrderButton.findElement(By.xpath("//button[@id='okButton']"));
                HelpersMethod.JScriptClick(driver,okButton,1000);

                //Check for Pending order popup and select start new order button in popup
                if (HelpersMethod.IsExists("//div[contains(text(),' open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement Button_Start = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Start new order')]");
                    HelpersMethod.ActClick(driver,Button_Start,100);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to Delete product details from my cart page
    public void DeleteMyCart()
    {
        exists=false;
        try
        {
            WebElement ProdDesc=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::div[@class='product-name']/a");
            scenario.log("PRODUCT DELETED IS "+ProdDesc.getText());

            WebElement DeletePro=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]//*[local-name()='svg' and contains(@class,'i-icon   delete-button ')]");
            HelpersMethod.ActClick(driver,DeletePro,40);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Select the first order from the existing order
    public void AddProductToOrder()
    {
        exists=false;
        try
        {
            if(HelpersMethod.EleDisplay(HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Select order')]/ancestor::div[@class='k-widget k-window k-dialog']")))
            {
                //create 'Select order' popup object
                WebElement selectOrder=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Select order')]/ancestor::div[@class='k-widget k-window k-dialog']");
                //Create element of order number and click on order
                WebElement orderNo=selectOrder.findElement(By.xpath(".//div[contains(text(),'#' )][1]"));
                HelpersMethod.ActClick(driver,orderNo,40);
                scenario.log("ORDER NUMBER SELECTED IS: "+orderNo.getText());
                //Click on OK button in Select order popup
                WebElement ok_But=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Ok']");
                HelpersMethod.ActClick(driver,ok_But,40);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
                }
                new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("checkoutCard")));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on image of product
    public void ClickImage()
    {
        exists=false;
        try
        {
            WebElement Prodimg=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'search-results-container')]/descendant::img[@class='product-thumb']");
            HelpersMethod.ScrollElement(driver,Prodimg);
            HelpersMethod.ClickBut(driver,Prodimg,100);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Enter product details in search box separated by comma
    public boolean EnterProdSeparatedByComma(List<String> Prod)
    {
        exists=false;
        WebElement WebEle;
        try
        {
            String Products="";
            List<String> ProdList=new ArrayList<String>();
            List<String> Prod1=new ArrayList<>();

            for(int i=0;i<=Prod.size()-1;i++)
            {
                Products=Products+String.valueOf(Prod.get(i)+", ");
            }
            HelpersMethod.EnterText(driver,SearchBar,100,Products);
            HelpersMethod.ClickBut(driver,SearchIndex,100);

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }

            //get the product no. that get displayed on catalog page
            List<WebElement> Prods=HelpersMethod.FindByElements(driver,"xpath","//div[@class='product-number']/descendant::span") ;
            for (WebElement Pro:Prods)
            {
                String Pro_Text=Pro.getText();
                scenario.log("PRODUCT FOUND IS "+Pro_Text);
                ProdList.add(Pro_Text.substring(1));
                Collections.sort(ProdList);
                exists=true;
            }
        }
        catch (Exception e){}
        return exists;
    }

    //Code to increase or decrease the qty
    public void PlusMinus()
    {
        exists=false;
        try
        {
            WebElement Plus1=HelpersMethod.FindByElement(driver,"xpath", "//tr[1]/descendant::button[contains(@class,'Plus')]");
            WebElement Minus1=HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::button[contains(@class,'Minu')]");
            WebDriverWait wait1=new WebDriverWait(driver,Duration.ofMillis(1000));

            for(int i=0;i<=1;i++)
            {
                wait1.until(ExpectedConditions.elementToBeClickable(Plus1));
                Plus1=HelpersMethod.FindByElement(driver,"xpath", "//tr[1]/descendant::button[contains(@class,'Plus')]");
                HelpersMethod.ClickBut(driver,Plus1,100);
                scenario.log("INCREASED QTY");
            }
            for(int i=0;i<=2;i++)
            {
                wait1.until(ExpectedConditions.elementToBeClickable(Minus1));
                Minus1=HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::button[contains(@class,'Minu')]");
                HelpersMethod.ClickBut(driver,Minus1,100);
                scenario.log("MINUS QTY");
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CatalogCategoryDropDown(String category)
    {
        exists=false;
        WebElement WebEle=null;
        Actions act1=new Actions(driver);
        try
        {
            HelpersMethod.ScrollElement(driver,Categories);
            HelpersMethod.ClickBut(driver,Categories,100);
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]"))));

            WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]");
            List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
            for(WebElement opt: Options)
            {
                act1.moveToElement(opt).build().perform();
                String opt_Text=opt.getText();
                if(opt_Text.equals(category))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists=true;
                    break;
                }
                else
                {
                    act1.moveToElement(opt).sendKeys(Keys.ARROW_DOWN).build().perform();
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                    }
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            scenario.log("CATEGORY SELECTED IS "+category);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ReadProduct()
    {
        try
        {
            if (HelpersMethod.IsExists("//div[@id='no-products-found']",driver))
            {
                scenario.log("NO PRODUCTS OF SELECTED CATEGORY IS AVAILABLE");
            }
            else
            {
                if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
                {
                    List<WebElement> Product_Nos = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='product-number']/span");
                    for (WebElement Prod_No : Product_Nos)
                    {
                        String Prod_Text = Prod_No.getText();
                        scenario.log("PRODUCT FOUND IS: " + Prod_Text);
                    }
                }
                else if(HelpersMethod.IsExists("//div[@class='list-view']",driver))
                {
                    List<WebElement> Product_Nos = HelpersMethod.FindByElements(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::div[contains(text(),'#')]");
                    for (WebElement Prod_No : Product_Nos)
                    {
                        String Prod_Text = Prod_No.getText();
                        scenario.log("PRODUCT FOUND IS: " + Prod_Text);
                    }
                }

            }
        }
        catch (Exception e){}
    }

    public void CatalogSubCategoryDropDown(String subCat)
    {
        exists=false;
        Actions act1=new Actions(driver);
        WebElement WebEle;
        try
        {
            HelpersMethod.ClickBut(driver,SubCat,100);
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]"))));

            WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]");
            List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
            for(WebElement opt: Options)
            {
                act1.moveToElement(opt).build().perform();
                String opt_Text=opt.getText();
                if(opt_Text.equals(subCat))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists=true;
                    break;
                }
                else
                {
                    act1.moveToElement(opt).sendKeys(Keys.ARROW_DOWN).build().perform();
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }

            scenario.log("SUB CATEGORY SELECTED IS "+subCat);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}

    }

    public void BrandDropDown(String brand)
    {
        exists=false;
        Actions act1=new Actions(driver);
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,Brand,60);
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]"))));

            WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]");
            List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
            for(WebElement opt: Options)
            {
                act1.moveToElement(opt).build().perform();
                String opt_Text=opt.getText();
                if(opt_Text.equals(brand))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists=true;
                    break;
                }
                else
                {
                    act1.moveToElement(opt).sendKeys(Keys.ARROW_DOWN).build().perform();
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                    }
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
            }

            scenario.log("BRAND SELECTED IS "+brand);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void OGDropDown() throws InterruptedException
    {
        exists=false;
        Actions act1=new Actions(driver);
        WebElement WebEle=null;
        int i=0;
        String ogName=null;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CPorderGuies']",driver))
            {
                HelpersMethod.ScrollElement(driver,OGDrop);
                HelpersMethod.ClickBut(driver, OGDrop, 80);
                new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]"))));

                //check for drop down for OG
                WebElement dropDownMenu=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none')]");
                List<WebElement> dropOptions=dropDownMenu.findElements(By.xpath(".//ul/li"));
                for (WebElement dropOpt:dropOptions)
                {
                    i++;
                    act1.moveToElement(dropOpt).build().perform();
                    if(i==2)
                    {
                        ogName =dropOpt.getText();
                        act1.moveToElement(dropOpt).build().perform();
                        act1.click(dropOpt).build().perform();
                        break;
                    }
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
                scenario.log("OG SELECTED IS " + ogName);
            }
            else
            {
                scenario.log("ORDER GUIDE DROP DOWN DOESNOT EXISTS");
                exists=true;
            }
        }
        catch (Exception e){}
    }

    public void FeaturedReadProduct()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(HelpersMethod.IsExists("//div[@id='featured-products-card']",driver))
            {
                //create list of webelements, containing list of products in featured products
                List<WebElement> Product_Nos = HelpersMethod.FindByElements(driver, "xpath", "//div[@id='featured-products-card']/descendant::div[@class='product-number']");
                for (WebElement Prod_No : Product_Nos)
                {
                    String Prod_Text = Prod_No.getText();
                    scenario.log("FEATURED PRORDUCT : " + Prod_Text);
                }
                exists = true;
            }
            else
            { scenario.log("FEATURED PRODUCTS LIST IS NOT DISPLAYED");}
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void RecentSearch()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[@class='recent-searches-container']",driver))
            {
                scenario.log("RECENT SEARCH CARD IS DISABLED,ENABLE IT IN ADMIN SETTINGS");
            }

            //create list of webelements, containing list of products in recent search products
            List<WebElement> Product_Nos = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@id,'Search_')]/div/div");
            for (WebElement Prod_No : Product_Nos)
            {
                String Prod_Text = Prod_No.getText();
                scenario.log("RECENTLY SEARCHED PRORDUCTS : " + Prod_Text);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateProductsYouMayLike()
    {
        exists=false;
        WebElement WebEle=null;
        String ProdNo=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='paging-container']");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(HelpersMethod.IsExists("//span[contains(text(),'You may also like')]",driver))
            {
                HelpersMethod.ScrollElement(driver,WebEle);
                List<WebElement> ProductsNo=HelpersMethod.FindByElements(driver,"xpath","//span[contains(text(),'You may also like')]/parent::div/following-sibling::div/descendant::div[@class='product-number']");
                scenario.log("Products you may also like are: ");
                for(WebElement ProdNos:ProductsNo)
                {
                    ProdNo=ProdNos.getText();
                    scenario.log(ProdNo);
                }
                exists=true;
            }
            else
            {
                scenario.log("LIST OF PRODUCTS YOU MAY ALSO LIKE IS NOT DISPLAYED, PLEASE CHECK ADMIN SETTINGS");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchProduct1(String pro)
    {
        exists=false;
        WebElement WebEle=null;
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
        try
        {
            WebElement ProductCard= HelpersMethod.FindByElement(driver,"id","productsCard");
            HelpersMethod.ScrollElement(driver,ProductCard);
            //Clear Search bar
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='searchBarClearBtn']//*[local-name()='svg']");
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.ActClick(driver,WebEle,100);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            HelpersMethod.ActSendKey(driver,SearchBar,100,pro);
            HelpersMethod.ActClick(driver,SearchIndex,100);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            scenario.log("PRODUCT SECTLECTED IS "+pro);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readProdFromShoppingCartDropDown()
    {
        Actions act1=new Actions(driver);
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-animation-container k-animation-container-relative popup-with-arrow standard-view shopping-cart-popup k-animation-container-shown')]"))));
            WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative popup-with-arrow standard-view shopping-cart-popup k-animation-container-shown')]");
            List<WebElement> prods=dropDown.findElements(By.xpath(".//div[contains(@class,'item-description')]"));
            for(WebElement prod:prods)
            {
                act1.moveToElement(prod).build().perform();
                String prod_Text=prod.getText();
                scenario.log("PRODUCT FOUND IN SHOPPING CART: "+prod_Text);
            }
        }
        catch (Exception e){}
    }

    public void productInputList(String s)
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//input[contains(@id,'catalog-list-view-quantity-input')]",driver))
            {
                WebElement listInput = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'catalog-list-view-quantity-input')]");
                HelpersMethod.ScrollElement(driver, listInput);
                HelpersMethod.EnterText(driver, listInput, 1000, s);
                listInput.sendKeys(Keys.TAB);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void checkTirepricing()
    {
        exists=false;
        try
        {
            WebElement tireLable=HelpersMethod.FindByElement(driver,"xpath","//div[@class='label-preview-background label-preview-background-white']");
            HelpersMethod.ClickBut(driver,tireLable,100);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='k-animation-container k-animation-container-fixed k-animation-container-shown']"))));
            WebElement tirePricePopup=HelpersMethod.FindByElement(driver,"xapth","//div[@class='k-animation-container k-animation-container-fixed k-animation-container-shown']");
            if(tirePricePopup==null)
            {
                scenario.log("TIREPRICING LABEL IS GETTING DISPLAYED");
                exists=true;
            }
            else
            {
                scenario.log("TIREPRICING LABEL IS NOT GETTING DISPLAYED");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateTirePricingIcon()
    {
        exists=false;
        String tirePrice;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'card-view')]/descendant::div[@class='label-preview-label']");
            HelpersMethod.ScrollElement(driver,WebEle);
            if(HelpersMethod.IsExists("//div[contains(@class,'card-view')]/descendant::div[@class='label-preview-label']",driver))
            {
                tirePrice=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'card-view')]/descendant::div[@class='label-preview-label']").getText();
                if(tirePrice.equalsIgnoreCase("TIERED PRICING"))
                {
                    scenario.log("TIRE PRICING ICON IS VISIBLE");
                    exists = true;
                }
                else
                {
                    scenario.log("SOME OTHER ICON IS VISIBLE");
                    exists=false;
                }
            }
            else
            {
                scenario.log("TIRE PRICING ICON IS NOT VISIBLE");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void visiblityOfTriePricingDetails()
    {
        Actions act1=new Actions(driver);
        try
        {
            WebElement tirepricing=HelpersMethod.FindByElement(driver,"xpath","//div[@class='icon-preview-background icon-preview-background-white']");
            act1.moveToElement(tirepricing).build().perform();
        }
        catch (Exception e){}
    }

    public void Refresh_Page(String currentURL)
    {
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            scenario.log(currentURL);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
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
                //navigate to Catalog
                driver.navigate().to(currentURL);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
        }
        catch (Exception e){}
    }

    public void compartingTotalDisplayedWithInPage()
    {
        String productsInPage=null;
        int startNum;
        int lastNum;
        try
        {
            productsInPage=HelpersMethod.FindByElement(driver,"xpath","//div[@class='showing-items-label']").getText();
            String fNumb=productsInPage.substring(8,9);
            String lNumb=productsInPage.substring(11,12);
            startNum=Integer.parseInt(fNumb);
            lastNum= Integer.parseInt(lNumb);
            totalNum=(startNum-lastNum)+1;
            scenario.log("TOTAL NUMBER OF PRODUCTS FOUND IN LAST PAGE "+(startNum-lastNum)+totalNum);
        }
        catch (Exception e){}
    }

    public void checkForPriceOfProduct()
    {
        exists=false;
        try
        {
            String price=HelpersMethod.FindByElement(driver,"xpath","//div[@class='product-price-container']/descendant::span[contains(@class,'product-price')]").getText();
            float pri=Float.parseFloat(price);
            scenario.log("Price value is "+pri);
            if(pri>0)
            {
                scenario.log("PRICE FOUND IS POSSITIVE VALUE "+pri);
                exists=true;
            }
            else if(pri<0)
            {
                scenario.log("PRICE FOUND IS NEGATIVE VALUE "+pri);
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateSelectOrder()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Select order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectPendingOrder()
    {
        exists=true;
        try
        {

        }
        catch (Exception e){}
    }

    public String clickOnProdDescription()
    {
        exists=false;
        WebElement prodDescription;
        String prodDesc = null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='grid-item-box-item description']/descendant::a",driver))
            {
                prodDescription = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item description']/descendant::a");
                HelpersMethod.ActClick(driver, prodDescription, 1000);
                prodDesc=prodDescription.getText();
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return prodDesc;
    }

    public void validateCatalog()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='productsCard']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateProdDescription(String descriptionProd)
    {
        exists=false;
        String prodDescription=null;
        try
        {
            prodDescription = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item description']/descendant::a").getText();
            if(prodDescription.equals(descriptionProd))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNonExistingProduct()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched')]",driver))
            {
                scenario.log("PRODUCT NUMBER DOESNOT EXISTS, AND FOUND SORRY NO PRODUCTS MATCHED MESSAGE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void pointOnTirePriceLabel()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'label-preview-label')]",driver))
            {
                WebElement tireLabel = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'label-preview-label')]");
                act.moveToElement(tireLabel).build().perform();
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateTirePricingDialogBox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='k-tooltip-content']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void navigateToDescriptionPage()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
            {
                WebElement Element =HelpersMethod.FindByElement(driver,"xpath","//div[@class='card-view']/descendant::div[@class='product-catalog-image-and-number-and-price-container'][1]");
                HelpersMethod.ClickBut(driver,Element,1000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
            }
            else
            {
                if(HelpersMethod.IsExists("//div[@class='list-view']",driver))
                {
                    WebElement Element =HelpersMethod.FindByElement(driver,"xpath","//div[@class='list-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::a/ancestor::td");
                    HelpersMethod.ClickBut(driver,Element,1000);
                    exists =true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                    }
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }
}
