package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.en_old.Ac;
import org.apache.commons.math3.analysis.function.Add;
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

import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class FeaturedProductsPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(xpath="//div[@class='grid-item-box'][1]/descendant::button/span[text()='Delete']")
    private WebElement Delete;

    @FindBy(id="add-product")
    private WebElement AddProd;

    //Action
    public FeaturedProductsPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void ValidateFeautedProduct()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='CPFeaturedProductsPage']",driver))
            {
                scenario.log("NAVIGATED TO FEATURED PRODUCTS PAGE");
                exists=true;
            }
            else
            {
                scenario.log("FAILED TO NAVIGATE TO FEATURED PRODUCTS PAGE");
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void ListFeaturedProduct(int maxProd)
    {
        exists=false;
        String Pro;
        int length;
        Actions act=new Actions(driver);
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            List<WebElement> Prods=HelpersMethod.FindByElements(driver,"xpath","//div[@class='product-number']/span");
            length=Prods.size();
            scenario.log("NUMBER OF PRODUCTS FOUND IN FEATURE PRODUCTS LIST "+length);
          //  if(length<=maxProd)
          //  {
                for (WebElement Prod : Prods)
                {
                    HelpersMethod.ScrollElement(driver,Prod);
                    act.moveToElement(Prod).build().perform();
                    Pro = Prod.getText();
                    scenario.log("FEATURED PRODUCT IN FEATURED PRODTUCTS LIST " + Pro);
                    exists=true;
                }
            //}
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickAddProducts()
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

            if(AddProd.isDisplayed() && AddProd.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, AddProd);
                HelpersMethod.ClickBut(driver, AddProd, 10000);

                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                if (HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    if (HelpersMethod.IsExists("//div[@id='no-products-found']", driver))
                    {
                        scenario.log("NO PRODUCTS HAS BEEN FOUND IN CATALOG");
                    } else {
                        //Click on reset filter button
                        WebEle = HelpersMethod.FindByElement(driver, "id", "productFilterResetBtn");
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        exists = true;
                        wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(600))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectProduct()
    {
        exists=false;
        WebElement WebEle;
        String ProdNo;
        try
        {
            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                //Identify the product which is not yet selected and find its product number
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Select'][1]/ancestor::div[contains(@class,'grid-item-box-item')]/ancestor::div[@class='grid-item-box']/descendant::div[@class='product-number']");
                ProdNo = WebEle.getText();
                ProdNo=ProdNo.substring(1);
                //search input box and enter product number to it
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::input[contains(@placeholder,'Search Products')]");
                HelpersMethod.EnterText(driver,WebEle,10000,ProdNo);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //Identify search index icon and click on that
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@datatestid='searchBarSearchBtn']//*[local-name()='svg']");
                HelpersMethod.ClickBut(driver,WebEle,10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                //Click on Select button
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Select']");
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ClickBut(driver,WebEle,10000);
                if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::span[@class='item-value'] /descendant::button//*[local-name()='svg']",driver))
                {
                    exists=true;
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CatalogOkButton()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[contains(text(),'Cannnot select more than')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                    WebElement okButton=modelContainer.findElement(By.xpath(".//button/span[text()='OK']"));
                    HelpersMethod.ActClick(driver,okButton,10000);
                }

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='OK']");
                HelpersMethod.ActClick(driver,WebEle,10000);

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

    public void PopupAfterChanges()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(text(),'Cannnot select more than')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=modelContainer.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,10000);
            }
        }
        catch (Exception e){}
    }

    public void ClickOnDeleteProduct()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='grid-item-box'][1]/descendant::button[@id='edit-role']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box'][1]/descendant::button[@id='edit-role']");
                HelpersMethod.ClickBut(driver, WebEle, 10000);
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

                if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(600))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'saved')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement buttonOk=modalContainer.findElement(By.xpath(".//button/span[text()='OK']|.//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver,buttonOk,10000);
                    new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("featured-product-list"))));
                    new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("featured-product-list")));
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CatalogFilter()
    {
        exists=false;
        WebElement WebEle;
        List<WebElement> Lists;
        String category;
        String subCategory=null;
        String brand=null;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement CategoryDrop=HelpersMethod.FindByElement(driver,"id","CPcategories");
                WebElement SubCateDrop=HelpersMethod.FindByElement(driver,"id","CPbrands");
                WebElement BrandDrop=HelpersMethod.FindByElement(driver,"id","CPsizes");
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='Select'][1]/ancestor::div[contains(@class,'grid-item-box-item')]/ancestor::div[@class='grid-item-box']/descendant::span[text()='Category']/following-sibling::span");
                category = WebEle.getText();
                //Click on Category drop down
                HelpersMethod.ClickBut(driver,CategoryDrop,10000);
                HelpersMethod.DropDownMenu(driver,category);
                category=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPcategories']/span[@class='k-input']").getText();
                scenario.log("CATEGORY  SELECTED IS "+category);

                //Click on Sub Category dropdown
                HelpersMethod.ClickBut(driver,SubCateDrop,10000);
                Lists=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='CPbrands-listbox-id']/li/span");
                if(Lists.size()>=2)
                {
                    WebEle = Lists.get(2);
                    subCategory = WebEle.getText();
                }
                HelpersMethod.DropDownMenu(driver,subCategory);
                subCategory=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPbrands']/span[@class='k-input']").getText();
                scenario.log("SUBCATEGORY  SELECTED IS "+subCategory);

                //Click on Brand dropdown
                HelpersMethod.ClickBut(driver,BrandDrop,10000);
                Lists=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='CPsizes-listbox-id']/li/span");
                if(Lists.size()>=2)
                {
                    WebEle = Lists.get(2);
                    brand = WebEle.getText();
                }
                HelpersMethod.DropDownMenu(driver,brand);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                brand=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPbrands']/span[@class='k-input']").getText();
                scenario.log("BRAND SELECTED IS "+brand);
            }
        }
        catch (Exception e){}
    }

    public void deleteAllFeatureProduct()
    {
        String productNo;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                List<WebElement> deleteProds = HelpersMethod.FindByElements(driver, "xpath", "//span[text()='Delete']/ancestor::button[@id='edit-role']");
                while (!deleteProds.isEmpty())
                //for(int i=0;i<=deleteProds.size()-1;i++)
                {
                    WebElement delePro = deleteProds.get(0);
                    //WebElement delePro=deleteProds.get(i);
                    productNo=HelpersMethod.FindByElement(driver,"xpath","//div[@class='grid-item-box'][1]/descendant::div[@class='product-number']/span").getText();
                    scenario.log("PRODUCT DELETED IS "+productNo);
                    HelpersMethod.ClickBut(driver, delePro, 20000);
                    deleteProds.remove(delePro);

                    wait = new FluentWait<WebDriver>(driver)
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

                    if (HelpersMethod.IsExists("//div[contains(text(),'saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                    {
                        wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(600))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                        WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                        WebElement buttonOk = modalContainer.findElement(By.xpath(".//button/span[text()='OK']|.//button/span[text()='Ok']"));
                        HelpersMethod.ActClick(driver, buttonOk, 10000);
                        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
                    }
                    new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("featured-product-list"))));
                    new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("featured-product-list")));

                    deleteProds = HelpersMethod.FindByElements(driver, "xpath", "//span[text()='Delete']/ancestor::button[@id='edit-role']");
                }
        }
        catch (Exception e){}
    }

    public void selecting3Products()
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

            if (HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'card-view')]/descendant::button/span[text()='Select'][1]");
                HelpersMethod.ActClick(driver,WebEle,10000);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        }
        catch (Exception e){}
    }

    public void deleteFirstProduct()
    {
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'card-view')]/descendant::button[@id='edit-role'][1]");
            HelpersMethod.ClickBut(driver,WebEle,10000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]");
                WebElement buttonOk = modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, buttonOk, 10000);
            }
        }
        catch (Exception e){}
    }

    public void savePopup()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=modelContainer.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,10000);
                exists=true;
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void savePopup1()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=modelContainer.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,10000);
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void clickOnLoadProducts()
    {
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                WebElement loadProd=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
                HelpersMethod.ActClick(driver,loadProd,10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void readFeaturedProduct()
    {
        exists=false;
        Actions act=new Actions(driver);
        String prodText=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='no-featured-products-selected']",driver))
            {
                scenario.log("<span style='color:red'>THERE ARE NO FEATURED PRODUCTS TO DISPLAY</span>");
                exists=true;
            }
            else if(HelpersMethod.IsExists("//div[@class='card-view']",driver))
            {
                List<WebElement> products = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='product-number']/span");
                for (WebElement prod : products)
                {
                    act.moveToElement(prod).build().perform();
                    prodText = prod.getText();
                    scenario.log("PRODUCT IN FEATURE PRODUCT LIST " + prodText);
                }
                exists=true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void validateNoProductsExists()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='no-featured-products-selected']",driver))
            {
                scenario.log("NO PRODUCT HAS BEEN FOUND UNDER FEATURED PRODUCTS");
                exists=true;
            }
            else
            {
                scenario.log("STILL CAN FIND FEATURED PRODUCTS");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}