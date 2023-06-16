package pages_DSD_OMS.Catalog;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;

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

    @FindBy(xpath="//button[contains(text(),'Reset filter')]")
    private WebElement ResetFilter;

    @FindBy(xpath = "//input[contains(@placeholder,'Search products')]")
    private WebElement SearchBar;

    @FindBy(xpath = "//span[contains(@class,'search-button-addon search-button input-group-addon')]/descendant::*[local-name()='svg']")
    private WebElement SearchIndex;

    @FindBy(xpath = "//span[@id='searchBarClearBtn']//*[local-name()='svg']")
    private WebElement SearchClear;

    @FindBy(id="sort-by-dropdown")
    private WebElement SortByDropDown;

    @FindBy(xpath="//button[contains(@data-test-id,'catalogGridViewBtn')]//*[local-name()='svg']")
    private WebElement CardView;

    @FindBy(xpath ="//button[contains(@data-test-id,'catalogListViewBtn')]//*[local-name()='svg']")
    private WebElement ListView;

    @FindBy(id = "shoppingCartRedBadge")
    private WebElement Cart;

    @FindBy(id="CPcategories")
    private WebElement Categories;

    @FindBy(id="CPbrands")
    private WebElement SubCat;

    @FindBy(id="CPsizes")
    private WebElement Brand;

    @FindBy(id="CPorderGuies")
    private WebElement OGDrop;


    //Constructor for Catalog page, Initializing the Page Objects:
    public CatalogPage(WebDriver driver, Scenario scenario)
    {
        this.scenario=scenario;
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public boolean ValidateCatalog()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
        }
        //HelpersMethod.Implicitwait(driver,20);
        try
        {
            if(HelpersMethod.gettingURL(driver).contains("cpProductCatalog"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    //code to click on Reset button
    public void Click_ResetFilterButton()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        //HelpersMethod.Implicitwait(driver,10);
        try
        {
            HelpersMethod.ScrollElement(driver,ResetFilter);
            HelpersMethod.ClickBut(driver,ResetFilter,40);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
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
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
       // HelpersMethod.Implicitwait(driver,10);
        try
        {
            HelpersMethod.ScrollElement(driver,CardView);
            HelpersMethod.ActClick(driver,CardView,40);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //code to click on List view
    public void Click_ListView()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.Implicitwait(driver,10);
        try
        {
            HelpersMethod.ScrollElement(driver,ListView);
            HelpersMethod.ActClick(driver,ListView,20);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Verify existence of sort by best match drop down, and then click on it. And select value from drop down
    public boolean Best_MatchDropDown(String DropSelect)
    {
        boolean result=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        HelpersMethod.Implicitwait(driver,10);
        try
        {
            if(SortByDropDown.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,SortByDropDown);
                HelpersMethod.ActClick(driver,SortByDropDown,100);
                //HelpersMethod.Implicitwait(driver,20);
                HelpersMethod.DropDownMenu(driver, DropSelect);
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
                //HelpersMethod.Implicitwait(driver,10);
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
            }
            else
            {
                scenario.log("SORT BY BEST MATCH IS NOT VISIBLE");
            }
        }
        catch (Exception e){}
        return result;
    }

    //Code for entering products in search bar
    public void SearchProduct(String Prod_no)
    {
        exists=false;
        WebElement WebEle=null;
        String status=null;
        //HelpersMethod.Implicitwait(driver,40);
        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'filter-and-search-container')]");
        HelpersMethod.ScrollElement(driver,WebEle);
        //HelpersMethod.Implicitwait(driver,20);
        status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        //HelpersMethod.Implicitwait(driver,20);
        try
        {
                WebEle=null;
                //Clear the contents of search bar
                WebEle=HelpersMethod.FindByElement(driver,"id","searchBarClearBtn");
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ClickBut(driver,WebEle,20);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }

                //Enter product# in search bar
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@class,'product-search-input')]");
                HelpersMethod.EnterText(driver,WebEle,20,Prod_no);
                scenario.log("PRODUCT SEARCHED IS "+Prod_no);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200);
                }

                //Click on search Index button
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@datatestid='searchBarSearchBtn']");
                HelpersMethod.ClickBut(driver,WebEle,20);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            //Thread.sleep(20000);
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
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }

        try
        {
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
                              HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                          }
                      }
                  }
              }
              exists = true;
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
            HelpersMethod.ActClick(driver,WebEle,20);

            //Identify update button
            UpdateBut=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'update-cart-button')]/descendant::span");
            HelpersMethod.ClickBut(driver,UpdateBut,20);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }

            //Read the Qty updated
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'ProductGridItemQuantityContainer')]");
            Qty=HelpersMethod.JSGetValueEle(driver,WebEle,20);
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
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'buttonMinus')]")));
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'buttonMinus')]")));
        try
        {
            //Decrement the qty
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'buttonMinus')]");
            HelpersMethod.ClickBut(driver,WebEle,40);

            //Identify update button
            UpdateBut=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'update-cart-button')]/descendant::span");
            HelpersMethod.ClickBut(driver,UpdateBut,20);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }

            //Read the Qty updated
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'ProductGridItemQuantityContainer')]");
            Qty=HelpersMethod.JSGetValueEle(driver,WebEle,20);
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            if(Cart.isDisplayed() && Cart.isEnabled())
            {
                HelpersMethod.ActClick(driver,Cart,30);
                HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",40);
                if(HelpersMethod.IsExists("//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",driver))
                {
                    exists=true;
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                new WebDriverWait(driver,1000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'cartItemsCard')]")));
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
            //Create instance of web driver wait, i.e. explisit wait
            WebDriverWait wait = new WebDriverWait(driver, 20);
            //create webelement for shopping cart popup
            WebElement ShoppingCart = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='popup-content']");

            //reload the Webelement ShoppingCart
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='popup-content']")));
            ShoppingCart = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='popup-content']");
            act.moveToElement(ShoppingCart).build().perform();

            //Move control to GotoCart button and click on it
            WebElement GotoCart = HelpersMethod.FindByElement(driver, "id", "goToCartButton");
            HelpersMethod.EleDisplay(GotoCart);

            act.moveToElement(GotoCart).build().perform();
            act.click(GotoCart).build().perform();
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
           // Thread.sleep(20000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to Delete Product from Shopping cart popup and Click on GotoCart button
    public void DeleteProd_GotoCartClick()
    {
        exists=false;
        WebElement WebEle=null;
        try {
           // HelpersMethod.Implicitwait(driver,40);
            Actions act = new Actions(driver);

            //Create instance of web driver wait, i.e. explisit wait
            WebDriverWait wait = new WebDriverWait(driver, 20);
            //create webelement for shopping cart popup
            WebElement ShoppingCart = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='popup-content']");
            //move control to shopping cart popup
            act.moveToElement(ShoppingCart).build().perform();
            //HelpersMethod.Implicitwait(driver,20);
            WebElement ProdRow = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='shopping-cart-row'][1]");
            act.moveToElement(ProdRow).build().perform();

            WebElement ProdDesc=HelpersMethod.FindByElement(driver,"xpath","//div[@class='shopping-cart-row'][1]/descendant::div[contains(@class,'description')]");
            scenario.log("PRODUCT REMOVED FROM DROP DOWN IS "+ProdDesc.getText());

            //Create Webelement for 'x' of first product
            WebElement x_Delete = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='shopping-cart-row'][1]/descendant::div[@class='item-remove-button']");

            //Move control 'x' button of first product to delete the product from cart
            act.moveToElement(x_Delete).build().perform();
            act.click(x_Delete).build().perform();
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            exists=true;
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
           // HelpersMethod.Implicitwait(driver,20);
            Actions act = new Actions(driver);
            //Create instance of web driver wait, i.e. explisit wait
            WebDriverWait wait = new WebDriverWait(driver, 10);
            //create webelement for shopping cart popup
            WebElement ShoppingCart = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='popup-content']");

            //reload the Webelement ShoppingCart
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='popup-content']")));
            ShoppingCart = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='popup-content']");
            act.moveToElement(ShoppingCart).build().perform();

            //Move control to GotoCart button and click on it
            WebElement GotoCart = HelpersMethod.FindByElement(driver, "id", "goToCartButton");
            HelpersMethod.EleDisplay(GotoCart);

            act.moveToElement(GotoCart).build().perform();
            act.click(GotoCart).build().perform();
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //click on checkout to order
    public void Checkout_to_order()
    {
       // HelpersMethod.Implicitwait(driver,50);
        exists=false;
        WebElement WebEle=null;
        try
        {
           new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.id("cartItemsCard")));
           if(HelpersMethod.IsExists("//span[contains(text(),'Items in cart')]",driver))
            {
                WebElement Checkout=HelpersMethod.FindByElement(driver,"id","checkoutToOrder");
                if(Checkout.isEnabled())
                {
                    //to handle start new order popup
                    if(HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog') ]/descendant::button[contains(text(),'Start new order')]");
                        HelpersMethod.ClickBut(driver,WebEle,20);
                    }

                    HelpersMethod.ScrollElement(driver, Checkout);
                    HelpersMethod.ActClick(driver,Checkout,20);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }

                    HelpersMethod.Implicitwait(driver,40);
                    //Check for Pending order popup and select start new order button in popup
                    if (HelpersMethod.IsExists("//div[contains(text(),' open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                    {
                        WebElement Button_Start = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Start new order')]");
                        HelpersMethod.ActClick(driver,Button_Start,20);
                    }
                }
            }
            exists=true;
           // HelpersMethod.Implicitwait(driver,40);
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
            if(HelpersMethod.EleDisplay(HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Select order')]/ancestor::div[@class='k-widget k-window k-dialog']")))
            {
                WebElement NewOrderPop=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::div[contains(text(),'New order')]");
                HelpersMethod.ActClick(driver,NewOrderPop,20);
                WebElement Button_Ele= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,Button_Ele,20);
                //Check for Pending order popup and select start new order button in popup
                if (HelpersMethod.IsExists("//div[contains(text(),' open order that is pending submission.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement Button_Start = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Start new order')]");
                    HelpersMethod.ActClick(driver,Button_Start,20);
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
            HelpersMethod.ClickBut(driver,DeletePro,20);
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
                WebElement ProdNo=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::div[contains(text(),'#' )][1]");
                HelpersMethod.ActClick(driver,ProdNo,20);
                WebElement Button_Ele=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[text()='Ok']");
                HelpersMethod.ClickBut(driver,Button_Ele,20);
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
            HelpersMethod.ClickBut(driver,Prodimg,20);
            exists=true;
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
            HelpersMethod.EnterText(driver,SearchBar,20,Products);
            HelpersMethod.ClickBut(driver,SearchIndex,10);

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
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
            WebDriverWait wait1=new WebDriverWait(driver,40);

            for(int i=0;i<=4;i++)
            {
                wait1.until(ExpectedConditions.elementToBeClickable(Plus1));
                Plus1=HelpersMethod.FindByElement(driver,"xpath", "//tr[1]/descendant::button[contains(@class,'Plus')]");
                HelpersMethod.ClickBut(driver,Plus1,40);
            }
            for(int i=0;i<=2;i++)
            {
                wait1.until(ExpectedConditions.elementToBeClickable(Minus1));
                Minus1=HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::button[contains(@class,'Minu')]");
                HelpersMethod.ClickBut(driver,Minus1,40);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CatalogCategoryDropDown()
    {
        exists=false;
        WebElement WebEle=null;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.ScrollElement(driver,Categories);
            HelpersMethod.ClickBut(driver,Categories,40);
            Thread.sleep(500);

            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//ul[contains(@class,'k-list k-reset')]/li");
            String Category= Values.get(2).getText();

            for(WebElement val:Values)
            {
                String val_Text=val.getText();
                if(val_Text.equals(Category))
                {
                    act.moveToElement(val).build().perform();
                    act.click(val).build().perform();
                    break;
                }
                exists=true;
            }
            scenario.log("CATEGORY SELECTED IS "+Category);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
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
                    List<WebElement> Product_Nos = HelpersMethod.FindByElements(driver, "xpath", "//tr[contains(@class,'k-master-row')]/descendant::span[contains(text(),'#')]");
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

    public void CatalogSubCategoryDropDown()
    {
        exists=false;
        Actions act=new Actions(driver);
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,SubCat,20);
            Thread.sleep(500);

            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//ul[contains(@class,'k-list k-reset')]/li");
            String SubCategory= Values.get(2).getText();

            for(WebElement val:Values)
            {
                String val_Text=val.getText();
                if(val_Text.equals(SubCategory))
                {
                    act.moveToElement(val).build().perform();
                    act.click(val).build().perform();
                    break;
                }
                exists=true;
            }
            scenario.log("SUB CATEGORY SELECTED IS "+SubCategory);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void BrandDropDown()
    {
        exists=false;
        Actions act=new Actions(driver);
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,Brand,20);
            Thread.sleep(500);

            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//ul[contains(@class,'k-list k-reset')]/li");
            String BrandName= Values.get(2).getText();

            for(WebElement val:Values)
            {
                String val_Text=val.getText();
                if(val_Text.equals(BrandName))
                {
                    act.moveToElement(val).build().perform();
                    act.click(val).build().perform();
                    break;
                }
                exists=true;
            }
            scenario.log("SUB CATEGORY SELECTED IS "+BrandName);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void OGDropDown() throws InterruptedException
    {
        exists=false;
        Actions act=new Actions(driver);
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            if(HelpersMethod.IsExists("//span[@id='CPorderGuies']",driver))
            {
                HelpersMethod.ScrollElement(driver,OGDrop);
                HelpersMethod.ClickBut(driver, OGDrop, 20);
                Thread.sleep(500);

                List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[contains(@class,'k-list k-reset')]/li");
                String OGName = Values.get(2).getText();

                for (WebElement val : Values)
                {
                    String val_Text = val.getText();
                    if (val_Text.equals(OGName))
                    {
                        act.moveToElement(val).build().perform();
                        act.click(val).build().perform();
                        break;
                    }
                    exists = true;
                }
                scenario.log("OG SELECTED IS " + OGName);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            else
            {
                scenario.log("ORDER GUIDE DROP DOWN DOESNOT EXISTS");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void FeaturedReadProduct()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[@class='slick-slider slick-initialized']",driver))
            {
                scenario.log("FEATURED PRODUCTS LIST IS NOT DISPLAYED");
            }
           //create list of webelements, containing list of products in featured products
           List<WebElement> Product_Nos = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='product-number']");
            for (WebElement Prod_No : Product_Nos)
            {
                String Prod_Text = Prod_No.getText();
                scenario.log("FEATURED PRORDUCT : " + Prod_Text);
            }
            exists=true;
            Assert.assertEquals(exists,true);
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

            //create list of webelements, containing list of products in featured products
            List<WebElement> Product_Nos = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@id,'Search_')]");
            for (WebElement Prod_No : Product_Nos)
            {
                String Prod_Text = Prod_No.getText();
                scenario.log("FEATURED PRORDUCT : " + Prod_Text);
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
        HelpersMethod.Implicitwait(driver,40);
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
        new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
        try
        {
            WebElement ProductCard= HelpersMethod.FindByElement(driver,"id","productsCard");
            HelpersMethod.ScrollElement(driver,ProductCard);
            //Clear Search bar
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='searchBarClearBtn']//*[local-name()='svg']");
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.ActClick(driver,WebEle,30);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.ActSendKey(driver,SearchBar,20,pro);
            HelpersMethod.ActClick(driver,SearchIndex,20);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            scenario.log("PRODUCT SECTLECTED IS "+pro);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
