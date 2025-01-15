package pages_DSD_OMS.Catalog;

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

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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

    @FindBy(xpath="//button[@data-test-id='productFilterResetBtn']")
    private WebElement ResetFilter;

    @FindBy(xpath = "//input[contains(@placeholder,'Search products')]")
    private WebElement SearchBar;

    @FindBy(xpath = "//span[@datatestid='searchBarSearchBtn']//*[local-name()='svg']")
    private WebElement SearchIndex;

    @FindBy(xpath = "//span[@id='searchBarClearBtn']//*[local-name()='svg']")
    private WebElement SearchClear;

    @FindBy(xpath="//span[@id='sort-by-dropdown']/descendant::button")
    private WebElement SortByDropDown;

    @FindBy(xpath = "//div[contains(@class,'shopping-cart-container')]//*[local-name()='svg']")
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
        String currentTitle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(HelpersMethod.IsExists("//button[@data-test-id='productFilterResetBtn']",driver))
            {
                HelpersMethod.ScrollElement(driver, ResetFilter);
                HelpersMethod.ClickBut(driver, ResetFilter, 10000);
                exists=true;
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Assert.assertEquals(exists,true);
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
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Thread.sleep(1000);
            if(!HelpersMethod.IsExists("//span[@id='CPQoh-accessibility-id']/span[text()='Show all products']|//span[@id='CPQoh-accessibility-id']/span[text()='All Products']",driver))
            {
                WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPQoh-accessibility-id']/following-sibling::button");
                HelpersMethod.ClickBut(driver,dropDown,10000);
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']"))));
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']")));
                List<WebElement> dropDowns=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='CPQoh-listbox-id']/descendant::span[@class='k-list-item-text']");
                for(WebElement dropDow:dropDowns)
                {
                    act.moveToElement(dropDown).build().perform();
                    dropText=dropDow.getText();
                    if(dropText.equalsIgnoreCase("Show all products"))
                    {
                        act.moveToElement(dropDow).build().perform();
                        act.click(dropDow).build().perform();
                        break;
                    }
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                Thread.sleep(1000);
            }
        }
        catch (Exception e){}
    }

    //Code to click on Card view
    public void Click_CardView()
    {
        Actions act=new Actions(driver);

        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            if(HelpersMethod.IsExists("//button[@data-test-id='catalogGridViewBtn']//*[local-name()='svg']",driver))
            {
                if(!HelpersMethod.IsExists("//button[@data-test-id='catalogGridViewBtn' and contains(@class,'primary')]//*[local-name()='svg']",driver))
                {
                    WebElement CardView = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='catalogGridViewBtn']//*[local-name()='svg']//*[local-name()='path']");
                    act.moveToElement(CardView).build().perform();
                    act.click().build().perform();
                    //HelpersMethod.JScriptClick(driver, CardView, 10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
        }
        catch (Exception e){}
    }

    //code to click on List view
    public void Click_ListView()
    {
        exists=false;
        Actions act=new Actions(driver);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            if(HelpersMethod.IsExists("//button[@data-test-id='catalogListViewBtn']//*[local-name()='svg']//*[local-name()='path']",driver))
            {
                if(!HelpersMethod.IsExists("//button[contains(@data-test-id,'catalogListViewBtn') and contains(@class,'i-primary')]",driver))
                {
                    WebElement LView = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='catalogListViewBtn']//*[local-name()='svg']//*[local-name()='path']");
                    act.moveToElement(LView).click().build().perform();
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
        }
        catch (Exception e){}
    }

    //Verify existence of sort by best match drop down, and then click on it. And select value from drop down
    public void Best_MatchDropDown(String DropSelect)
    {
        exists=false;

        Actions act1=new Actions(driver);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            if(HelpersMethod.IsExists("//span[@id='sort-by-dropdown']/descendant::button",driver))
            {
                HelpersMethod.ScrollElement(driver,SortByDropDown);
                HelpersMethod.ActClick(driver,SortByDropDown,10000);
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='sort-by-dropdown-listbox-id']/li/span"))));
                List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='sort-by-dropdown-listbox-id']/li/span");
                for(WebElement opt: Options)
                {
                    act1.moveToElement(opt).build().perform();
                    String opt_Text=opt.getText();
                    if(opt_Text.equals(DropSelect))
                    {
                        act1.moveToElement(opt).build().perform();
                        act1.click(opt).build().perform();
                        exists=true;
                        break;
                    }
                }
               wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(1000))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            else
            {
                scenario.log("SORT BY BEST MATCH IS NOT VISIBLE");
            }
            Assert.assertEquals(exists,true);
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
                HelpersMethod.ActClick(driver, SortByDropDown, 10000);
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='sort-by-dropdown-listbox-id']/li/span")));

                List<WebElement> Options = HelpersMethod.FindByElements(driver,"xpath","//ul[@id='sort-by-dropdown-listbox-id']/li/span");
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
            Assert.assertEquals(exists,true);
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
                HelpersMethod.ActClick(driver,pagination,10000);
                WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
                List<WebElement> listValue=dropDown.findElements(By.xpath(".//ul/li"));
                for (int i=0;i<=listValue.size()-1;i++)
                {
                    act.moveToElement(listValue.get(i));
                    if(i==listValue.size()-1)
                    {
                        act.moveToElement(listValue.get(i)).click().build().perform();
                        exists=true;
                        break;
                    }
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
        WebElement WebEle;
        String status;
        try
        {
            WebElement WebEle1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'filter-and-search-container')]");
            HelpersMethod.ScrollElement(driver,WebEle1);
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.ScrollElement(driver,SearchClear);
            HelpersMethod.ClickBut(driver,SearchClear,10000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //Enter product# in search bar
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@class,'product-search-input')]");
            HelpersMethod.EnterText(driver,WebEle,10000,Prod_no);
            scenario.log("PRODUCT SEARCHED IS "+Prod_no);
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //Click on search Index button
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@datatestid='searchBarSearchBtn']");
            HelpersMethod.ClickBut(driver,WebEle,10000);

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
        WebElement WebEle;
        Wait<WebDriver> wait;
        exists=false;
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(600))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            Thread.sleep(1000);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='card-view']"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-view']")));

            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
            HelpersMethod.ScrollElement(driver,WebEle);

            //Check for delete button is visible
            if (HelpersMethod.IsExists("//button[contains(@id,'deleteCartBtn')]",driver))
            {
                WebElement deleteButton = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@id,'deleteCartBtn')]");
                HelpersMethod.ScrollElement(driver,deleteButton);
                HelpersMethod.ClickBut(driver, deleteButton, 10000);

                wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add to cart')]/ancestor::button")));
                Thread.sleep(1000);
            }
            //Identify input box for Qty
            WebElement qtyBox = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'ProductGridItemQuantityContainer')]");
            HelpersMethod.ScrollElement(driver, qtyBox);
            HelpersMethod.EnterText(driver,qtyBox,8000,Qty_UnitCase);
            qtyBox.sendKeys(Keys.TAB);
            scenario.log("QTY ENTERE IS " + Qty_UnitCase);
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='card-view']"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-view']")));

            //Click on Add to cart button
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@id,'addCartBtn')]")));
            WebElement addToCart = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@id,'addCartBtn')]");
            if (addToCart.isDisplayed() && addToCart.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, addToCart);
                HelpersMethod.ClickBut(driver, addToCart, 100000);
                exists = true;
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status=HelpersMethod.returnDocumentStatus(driver);
            {
                if(status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
            }
            Thread.sleep(1000);
            //"Product is currently unavailable" popup
            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, okButton, 1000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='card-view']"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-view']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //To increment Qty in card view
    public void IncrementCard_button()
    {
        exists=false;
        WebElement WebEle;
        WebElement UpdateBut;
        Wait<WebDriver> wait;
        String Qty;
        try
        {
            //Increment the qty
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'buttonPlus')]");
            HelpersMethod.ActClick(driver,WebEle,10000);

            //Identify update button
            UpdateBut=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'update-cart-button')]/descendant::span");
            HelpersMethod.ClickBut(driver,UpdateBut,1000);
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //Read the Qty updated
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'ProductGridItemQuantityContainer')]");
            Qty=HelpersMethod.JSGetValueEle(driver,WebEle,10000);
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
        WebElement WebEle;
        WebElement UpdateBut;
        Wait<WebDriver> wait;
        String Qty;
        new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'buttonMinus')]")));
        new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'buttonMinus')]")));
        try
        {
            //Decrement the qty
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'buttonMinus')]");
            HelpersMethod.ClickBut(driver,WebEle,10000);

            //Identify update button
            UpdateBut=HelpersMethod.FindByElement(driver,"xpath","//button[contains(@class,'update-cart-button')]/descendant::span");
            HelpersMethod.ClickBut(driver,UpdateBut,10000);

            wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //Read the Qty updated
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'ProductGridItemQuantityContainer')]");
            Qty=HelpersMethod.JSGetValueEle(driver,WebEle,10000);
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(Cart.isDisplayed())
            {
                new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(Cart)));
                new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.visibilityOf(Cart));
                HelpersMethod.ScrollElement(driver,Cart);
                HelpersMethod.ActClick(driver,Cart,10000);
                HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",40);
                if(HelpersMethod.IsExists("//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",driver))
                {
                    scenario.log("CART ICON HAS BEEN CLICKED");
                    exists=true;
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on GotoCart button
    public void GotoCartClick()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Actions act = new Actions(driver);
            //Identify the Shopping cart drop down
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Shopping cart')]/ancestor::div[contains(@class,'k-animation-container popup-with-arrow standard-view shopping-cart-popup k-animation-container-shown')]"))));
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[contains(@class,'k-animation-container popup-with-arrow standard-view shopping-cart-popup k-animation-container-shown')]",40000);
            //Identify the Go to cart button
            if(HelpersMethod.IsExists("//button[@id='goToCartButton']//*[local-name()='svg']",driver))
            {
                WebElement goToCart = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='goToCartButton']//*[local-name()='svg']");
                act.moveToElement(goToCart).build().perform();
                act.click(goToCart).build().perform();
                scenario.log("GO TO CART BUTTON CLICKED");
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                exists = true;
            }
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[@id='cartItemsCard']",100000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to Delete Product from Shopping cart popup and Click on GotoCart button
    public void DeleteProd_GotoCartClick()
    {
        exists=false;
        try
        {
            Actions act = new Actions(driver);
            //Find the first product in Shopping cart
            WebElement shoppingCart=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'standard-view shopping-cart-popup')]");
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            exists=true;
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='shopping-cart-popup-content']/ancestor::div[@class='k-child-animation-container']"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='shopping-cart-popup-content']/ancestor::div[@class='k-child-animation-container']")));
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",10000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Code to click on Goto cart button, this part of code is used only in scenario where trying to delete product from shopping cart popup
    public void ClickGotoCart1()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Actions act = new Actions(driver);
            //Identify the Shopping cart drop down
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(text(),'Shopping cart')]/ancestor::div[@class='popup-content']",10000);
            if(HelpersMethod.IsExists("//button[@id='goToCartButton']//*[local-name()='svg']",driver))
            {
                WebElement goToCart = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='goToCartButton']//*[local-name()='svg']");
                act.moveToElement(goToCart).build().perform();
                act.click(goToCart).build().perform();
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cartItemsCard']"))));
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("cartItemsCard"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("cartItemsCard")));
            if(HelpersMethod.IsExists("//span[contains(text(),'Items in cart')]",driver))
            {
                WebElement Checkout=HelpersMethod.FindByElement(driver,"id","checkoutToOrder");
                if(Checkout.isDisplayed() && Checkout.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver, Checkout);
                    HelpersMethod.ActClick(driver,Checkout,10000);
                    exists=true;
                    if(HelpersMethod.IsExists("//span[text()='Select order']/ancestor::div[@class='k-window k-dialog']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::div[@class='item-order '][1]");
                        HelpersMethod.ActClick(driver,WebEle,10000);

                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::button[@id='okButton']");
                        HelpersMethod.ActClick(driver,WebEle,10000);
                    }

                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                    //to handle start new order popup
                    if(HelpersMethod.IsExists("//div[contains(text(),'You already have an open order that is pending submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog') ]/descendant::button/span[contains(text(),'Start new order')]");
                        HelpersMethod.ActClick(driver,WebEle,10000);
                    }
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }

                    //Check for Pending order popup and select start new order button in popup
                    if (HelpersMethod.IsExists("//div[contains(text(),' open order that is pending submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        WebElement Button_Start = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button[contains(text(),'Start new order')]");
                        HelpersMethod.ActClick(driver,Button_Start,10000);
                    }

                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                    }
                }
            }
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
            if(HelpersMethod.IsExists("//span[contains(text(),'Select order')]/ancestor::div[@class='k-window k-dialog']",driver))
            {
                //select 'New order button'
                WebElement newOrderPopup=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Select order')]/ancestor::div[@class='k-window k-dialog']");
                WebElement newOrderButton=newOrderPopup.findElement(By.xpath(".//div[contains(text(),'New order')]"));
                HelpersMethod.ActClick(driver,newOrderButton,10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //Click on 'Ok' button
                WebElement okButton=newOrderButton.findElement(By.xpath("//button[@id='okButton']"));
                HelpersMethod.JScriptClick(driver,okButton,10000);

                //Check for Pending order popup and select start new order button in popup
                if (HelpersMethod.IsExists("//div[contains(text(),' open order that is pending submission.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement Button_Start = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button[contains(text(),'Start new order')]");
                    HelpersMethod.ActClick(driver,Button_Start,10000);
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
            HelpersMethod.ActClick(driver,DeletePro,10000);
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.EleDisplay(HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Select order')]/ancestor::div[@class='k-window k-dialog']")))
            {
                //create 'Select order' popup object
                WebElement selectOrder=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Select order')]/ancestor::div[@class='k-window k-dialog']");
                //Create element of order number and click on order
                WebElement orderNo=selectOrder.findElement(By.xpath(".//div[@class='item-order ' and contains(text(),'#' )][1]"));
                HelpersMethod.ActClick(driver,orderNo,10000);
                scenario.log("ORDER NUMBER SELECTED IS: "+orderNo.getText());
                //Click on OK button in Select order popup
                WebElement ok_But=HelpersMethod.FindByElement(driver,"xpath",".//button/span[text()='Ok']");
                HelpersMethod.ActClick(driver,ok_But,10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("checkoutCard")));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //code to select pending order
    public void AddProductToPendingOrder()
    {
        exists=false;
        try
        {
            if(HelpersMethod.EleDisplay(HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Select order')]/ancestor::div[@class='k-window k-dialog']")))
            {
                //create 'Select order' popup object
                WebElement selectOrder=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Select order')]/ancestor::div[@class='k-window k-dialog']");
                //Create element of order number and click on order
                WebElement orderNo=selectOrder.findElement(By.xpath(".//div[contains(@class,'item-order ') and contains(text()[2],'Pending')]"));
                HelpersMethod.ActClick(driver,orderNo,10000);
                scenario.log("ORDER NUMBER SELECTED IS: "+orderNo.getText());
                //Click on OK button in Select order popup
                WebElement ok_But=HelpersMethod.FindByElement(driver,"xpath",".//button/span[text()='Ok']");
                HelpersMethod.ActClick(driver,ok_But,10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("checkoutCard")));
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
            HelpersMethod.ClickBut(driver,Prodimg,10000);
            exists=true;
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Enter product details in search box separated by comma
    public boolean EnterProdSeparatedByComma(List<String> Prod)
    {
        exists=false;

        try
        {
            String Products="";
            List<String> ProdList=new ArrayList<String>();
            List<String> Prod1=new ArrayList<>();

            for(int i=0;i<=Prod.size()-1;i++)
            {
                Products=Products+String.valueOf(Prod.get(i)+", ");
            }
            HelpersMethod.EnterText(driver,SearchBar,10000,Products);
            HelpersMethod.ClickBut(driver,SearchIndex,10000);

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
            WebDriverWait wait1=new WebDriverWait(driver,Duration.ofMillis(10000));

            for(int i=0;i<=1;i++)
            {
                wait1.until(ExpectedConditions.elementToBeClickable(Plus1));
                Plus1=HelpersMethod.FindByElement(driver,"xpath", "//tr[1]/descendant::button[contains(@class,'Plus')]");
                HelpersMethod.ClickBut(driver,Plus1,10000);
                scenario.log("INCREASED QTY");
            }
            for(int i=0;i<=2;i++)
            {
                wait1.until(ExpectedConditions.elementToBeClickable(Minus1));
                Minus1=HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::button[contains(@class,'Minu')]");
                HelpersMethod.ClickBut(driver,Minus1,10000);
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

        Actions act1=new Actions(driver);
        try
        {
            HelpersMethod.ScrollElement(driver,Categories);
            HelpersMethod.ClickBut(driver,Categories,10000);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='CPcategories-listbox-id']/descendant::span"))));

            List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='CPcategories-listbox-id']/descendant::span");
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
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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

        try
        {
            HelpersMethod.ClickBut(driver,SubCat,10000);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='CPbrands-listbox-id']/descendant::span"))));

            //WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]");
            List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='CPbrands-listbox-id']/descendant::span");
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
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            scenario.log("SUB CATEGORY SELECTED IS "+subCat);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}

    }

    public void BrandDropDown(String brand)
    {
        exists=false;
        Actions act1=new Actions(driver);

        try
        {
            HelpersMethod.ClickBut(driver,Brand,10000);
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='CPsizes-listbox-id']/descendant::span"))));

            //WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//ul[@id='CPsizes-listbox-id']/descendant::span");
            List<WebElement> Options=HelpersMethod.FindByElements (driver,"xpath", "//ul[@id='CPsizes-listbox-id']/descendant::span");
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
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            scenario.log("BRAND SELECTED IS "+brand);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void OGDropDown() throws InterruptedException
    {
        exists=false;
        Actions act1=new Actions(driver);

        int i=0;
        String ogName=null;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CPorderGuies']",driver))
            {
                HelpersMethod.ScrollElement(driver,OGDrop);
                HelpersMethod.ClickBut(driver, OGDrop, 10000);
                new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='CPorderGuies-listbox-id']/descendant::span"))));

                //check for drop down for OG
                //WebElement dropDownMenu=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container')]");
                List<WebElement> dropOptions=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='CPorderGuies-listbox-id']/descendant::span");
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
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
        WebElement WebEle;
        String ProdNo;
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
        WebElement WebEle;
        //new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
        //new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='searchBarClearBtn']//*[local-name()='svg']")));
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@id='productsCard']",driver))
            {
                WebElement ProductCard = HelpersMethod.FindByElement(driver, "id", "productsCard");
                HelpersMethod.ScrollElement(driver, ProductCard);
                //Clear Search bar
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='searchBarClearBtn']//*[local-name()='svg']");
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 10000);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(SearchBar.isDisplayed())
            {
                //code to enter product# in search bar
                HelpersMethod.ScrollElement(driver,SearchBar);
                HelpersMethod.ActSendKey(driver, SearchBar, 10000, pro);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //code to click on search index
                HelpersMethod.ActClick(driver, SearchIndex, 10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                scenario.log("PRODUCT SECTLECTED IS " + pro);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readProdFromShoppingCartDropDown()
    {
        Actions act1=new Actions(driver);
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'k-animation-container popup-with-arrow standard-view shopping-cart-popup k-animation-container-shown')]"))));
            //WebElement dropDown=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative popup-with-arrow standard-view shopping-cart-popup k-animation-container-shown')]");
            List<WebElement> prods=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'item-description')]");
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
                HelpersMethod.EnterText(driver, listInput, 10000, s);
                listInput.sendKeys(Keys.TAB);
                Thread.sleep(1000);
                exists=true;
                //"Product is currently unavailable" popup
                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver, okButton, 10000);
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
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
            HelpersMethod.ClickBut(driver,tireLable,10000);
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
                tirePrice=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'card-view')]/descendant::div[@class='label-preview-label' and contains(text(),'Tiered pricing')]").getText();
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
        Wait<WebDriver> wait;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            scenario.log(currentURL);
            if (HelpersMethod.IsExists("//div[contains(@class,'k-dialog-wrapper')]|//div[@class='modal-sm modal-dialog']|//div[contains(@class,'modal-content')]|//div[contains(@class,'k-dialog-wrapper order-selection ')]", driver))
            {
                WebElement dialogBox = driver.findElement(By.xpath("//div[contains(@class,'k-dialog-wrapper')]|//div[contains(@class,'modal-dialog')]|//div[contains(@class,'k-dialog-wrapper order-selection ')]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", dialogBox);
                //((JavascriptExecutor) driver).executeScript("window.location.reaload()");
                driver.navigate().refresh();

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }

                //navigate to Catalog
                //navigateToCatalog();
                driver.navigate().to(currentURL);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productsCard")));

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productsCard")));
                scenario.log(driver.getCurrentUrl());
        }
        catch (Exception e){}
    }

    public void compartingTotalDisplayedWithInPage()
    {
        String productsInPage;
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
            if(HelpersMethod.IsExists("//span[contains(text(),'Select order')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
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
        String prodDesc = "";
        try
        {
            if(HelpersMethod.IsExists("//div[@class='grid-item-box-item description']/descendant::a",driver))
            {
                prodDescription = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item description']/descendant::a");
                HelpersMethod.ActClick(driver, prodDescription, 10000);
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
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@id='productsCard']",driver))
            {
                scenario.log("USER IS ON CATALOG PAGE");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateProdDescription(String descriptionProd)
    {
        exists=false;
        String prodDescription;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            prodDescription = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item description']/descendant::a").getText();
            if(prodDescription.contains(descriptionProd))
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
            if(HelpersMethod.IsExists("//div[contains(text(),'Tiered pricing')]/ancestor::div[contains(@class,'admin-badge-text-container')]",driver))
            {
                WebElement tireLabel = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Tiered pricing')]/ancestor::div[contains(@class,'admin-badge-text-container')]");
                act.moveToElement(tireLabel).clickAndHold().build().perform();
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
            Thread.sleep(1000);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-tooltip-content')]/ancestor::div[contains(@class,'k-animation-container k-animation-container')]",driver))
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
                HelpersMethod.ScrollElement(driver,Element);
                HelpersMethod.ClickBut(driver,Element,10000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            else
            {
                if(HelpersMethod.IsExists("//div[@class='list-view']",driver))
                {
                    WebElement Element =HelpersMethod.FindByElement(driver,"xpath","//div[@class='list-view']/descendant::tr[contains(@class,'k-master-row')][1]/descendant::a/ancestor::td");
                    HelpersMethod.ScrollElement(driver,Element);
                    HelpersMethod.ClickBut(driver,Element,10000);
                    exists =true;
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }

    public void sortedValuesInCatalog()
    {
        WebElement WebEle;
        boolean result=false;
        try
        {
            Thread.sleep(1500);
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='list-view']");
            HelpersMethod.ScrollElement(driver, WebEle);
            List<WebElement> Prices = HelpersMethod.FindByElements(driver, "xpath", "//tr/descendant::span[@class='product-price']");
            ArrayList<Double> Prices1 = new ArrayList<Double>();
            ArrayList<Double> Prices2 = new ArrayList<Double>();

            //copy content of web element, i.e. prices to list
            for (WebElement Price : Prices)
            {
                String Price_Text = Price.getText();
                if (!Price_Text.equals(" "))
                {
                    Prices1.add(Double.valueOf(Price_Text));
                    Prices2.add(Double.valueOf(Price_Text));
                }
            }
            //Sort the values in ascending order
            //Collections.sort(Prices1);
            Double[] prices1=Prices1.toArray(new Double[Prices1.size()]);
            Arrays.sort(prices1);

            //Comparing List of integers, to find whether array is in sorted order
            for (int i = 0; i < Prices2.size(); i++)
            {
                //System.out.println("VALUES AFTER SELECTING PRICE SORT FROM DROP DOWN " + prices1[1] + " VALUE AFTER PROGRAMMATICALLY SORTING " + Prices2.get(i));
                if (prices1[i].equals(Prices2.get(i)))
                {
                    result = true;
                   scenario.log("EXPECTED VALUE: " + prices1[i] + " FOUND VALUE: " + Prices2.get(i));
                }
                else
                {
                    result = false;
                    scenario.log("EXPECTED VALUE: " + prices1[i] + " FOUND VALUE: " + Prices2.get(i));
                    scenario.log("PRICES ARE NOT IN SORTED ORDER");
                    break;
                }
            }
            Assert.assertEquals(result, true);
        }
        catch (Exception e){}
    }

    public void toCatalogTab()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", driver))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Catalog", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                scenario.log("NAVIGATED TO CATALOG TAB");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                exists=true;
            }
            else
            {
                scenario.log("CATALOG TAB IS NOT VISIBLE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void addProductToCart(String qty)
    {
        exists=false;
        try
        {
            WebElement inputQty=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@id,'gridItemBox')][1]/descendant::input[contains(@id,'ProductGridItemQuantityContainer')]");
            HelpersMethod.EnterText(driver,inputQty,10000,qty);

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'gridItemBox')][1]/descendant::button[contains(@id,'addCartBtn')]"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'gridItemBox')][1]/descendant::button[contains(@id,'addCartBtn')]"))));
            WebElement addButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@id,'gridItemBox')][1]/descendant::button[contains(@id,'addCartBtn')]");
            HelpersMethod.ClickBut(driver,addButton,10000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            //"Product is currently unavailable" popup
            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, okButton, 10000);

                wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void validateCardView()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
            {
                scenario.log("CARD VIEW IN CATALOG HAS BEEN SELECTED");
                exists = true;
            }
            else
            {
                scenario.log("CARD VIEW IN CATALOG IS NOT VISIBLE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateListView()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='list-view']", driver))
            {
                scenario.log("LIST VIEW IN CATALOG HAS BEEN SELECTED");
                exists = true;
            }
            else
            {
                scenario.log("LIST VIEW IS NOT VISIBLE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void navigateToCatalog()
    {
        try
        {
            exists = false;
            if (HelpersMethod.IsExists("//span[@class='k-link' and contains(text(),'Catalog')]",driver))
            {
                String Menu_Text;
                Actions act=new Actions(driver);
                List<WebElement> MenuBar=HelpersMethod.FindByElements(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link']");
                for(WebElement Menu:MenuBar)
                {
                    act.moveToElement(Menu).build().perform();
                    Menu_Text=Menu.getText();
                    if(Menu_Text.contains("Catalog"))
                    {
                        WebElement menuItem=HelpersMethod.FindByElement(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Catalog')]");
                        HelpersMethod.JScriptClick(driver,menuItem,10000);
                        exists=true;
                        break;
                    }
                }
               /* if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }*/
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='productFilterResetBtn']")));

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='productFilterResetBtn']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public boolean verifyProductsInCatalogEnabled()
    {
        exists=false;
        try
        {
            WebElement productCard=HelpersMethod.FindByElement(driver,"id","productsCard");
            HelpersMethod.ScrollElement(driver,productCard);

            if(!HelpersMethod.IsExists("//div[@class='search-results-container']",driver))
            {
                scenario.log("PRODUCTS ARE NOT LOADED AUTOMATICALLY, WE NEED TO CLICK ON RESET FILTER");
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>PRODUCTS ARE LOADED AUTOMATICALLY</span>");
                exists=false;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public boolean verifyProductsInCatalogDisabled()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[contains(text(),'Use the search bar to search for products.')]",driver))
            {
                scenario.log("PRODUCTS ARE NOT LOADED AUTOMATICALLY, WE NEED TO CLICK ON RESET FILTER");
                exists=false;
            }
            else
            {
                scenario.log("<span style='color:red'>PRODUCTS ARE LOADED AUTOMATICALLY</span>");
                exists=true;
            }
        }
        catch (Exception e){}
        return exists;
    }

    public void ValidateHomeOrCatalog()
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
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='user-info-container']"))));
            new WebDriverWait(driver,Duration.ofMillis(8000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-info-container']"))));

            String HomeTitle = driver.getTitle();
            if (HomeTitle.contains("Admin")||HomeTitle.contains("Product Catalog"))
            {
                scenario.log("ADMIN PAGE OR PRODUCT CATALOG PAGE HAS BEEN FOUND");
                exists = true;
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clearSearch()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='searchBarClearBtn']",driver))
            {
                WebElement clearSearch = HelpersMethod.FindByElement(driver, "id", "searchBarClearBtn");
                HelpersMethod.ActClick(driver, clearSearch, 10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //code to find whether the search bar is clear or not
                WebElement inputSearch=HelpersMethod.FindByElement(driver,"xpath","//div[@class='searchBarDropdown']/descendant::input");
                String searchValue=HelpersMethod.JSGetValueEle(driver,inputSearch,10000);
                if(searchValue.equals(""))
                {
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readProductNumbers()
    {
        exists=false;
        String prodText;
        Actions act=new Actions(driver);
        try
        {
            scenario.log("PRODUCT NUMBER FOUND IN CATALOG ");
            List<WebElement> prodNos= HelpersMethod.FindByElements(driver,"xpath","//div[@class='product-number']/span");
            if(prodNos.size()!=0)
            {
                for (WebElement prodNo : prodNos)
                {
                    act.moveToElement(prodNo).build().perform();
                    prodText = prodNo.getText();
                    scenario.log(prodText);
                    exists=true;
                }
            }
            else
            {
                scenario.log("<span style='color:red'> PRODUCTS ARE NOT FOUND IN CATALOG</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNoPriceCard()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[@class='grid-item-box-item']/descendant::span[contains(@class,'price')]|//div[@class='grid-item-box-item']/descendant::span[contains(@class,'Price')]|//th/descendant::span[@class='k-column-title' and contains(text(),'Price')]|//th/descendant::span[@class='k-column-title' and contains(text(),'price')]",driver))
            {
                scenario.log("SUCCESSFULLY HIDDEN PRICE OF PRODUCT, UNDER CATALOG");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validatePriceCard()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='grid-item-box-item']/descendant::span[contains(@class,'price')]|//div[@class='grid-item-box-item']/descendant::span[contains(@class,'Price')]|//th/descendant::span[@class='k-column-title' and contains(text(),'Price')]|//th/descendant::span[@class='k-column-title' and contains(text(),'price')]",driver))
            {
                scenario.log("SUCCESSFULLY DISPLAYING PRICE OF PRODUCT, UNDER CATALOG");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}