package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
    static int No_product;
    static String selectCat=null;

    @FindBy(xpath="//div[@class='grid-item-box'][1]/descendant::button[text()='Delete']")
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
              exists=true;
          }
            Assert.assertEquals(exists,true);
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
            List<WebElement> Prods=HelpersMethod.FindByElements(driver,"xpath","//div[@class='product-number']/span");
            length=Prods.size();
            scenario.log("NO. PRODUCTS FOUND IN FEATURE PRODUCTS LIST "+length);
            if(length<=maxProd)
            {
                for (WebElement Prod : Prods)
                {
                    HelpersMethod.ScrollElement(driver,Prod);
                    act.moveToElement(Prod).build().perform();
                    Pro = Prod.getText();
                    scenario.log("FEATURED PRODUCT IN FEATURED PRODTUCTS LIST " + Pro);
                    exists=true;
                }
            }
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
            HelpersMethod.ScrollElement(driver,AddProd);
            HelpersMethod.ClickBut(driver,AddProd,20);
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Click on reset filter button
                WebEle=HelpersMethod.FindByElement(driver,"id","productFilterResetBtn");
                HelpersMethod.ClickBut(driver,WebEle,40);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectProduct()
    {
        exists=false;
        WebElement WebEle;
        String ProdNo=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Identify the product which is not yet selected and find its product number
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Select'][1]/ancestor::div[contains(@class,'grid-item-box-item')]/ancestor::div[@class='grid-item-box']/descendant::div[@class='product-number']");
                ProdNo = WebEle.getText();
                ProdNo=ProdNo.substring(1);
                //search input box and enter product number to it
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[contains(@placeholder,'Search Products')]");
                HelpersMethod.EnterText(driver,WebEle,20,ProdNo);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                //Identify search index icon and click on that
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@datatestid='searchBarSearchBtn']//*[local-name()='svg']");
                HelpersMethod.ClickBut(driver,WebEle,20);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
                //Click on Select button
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Select']");
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ClickBut(driver,WebEle,20);
                if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[@class='item-value'] /descendant::button//*[local-name()='svg']",driver))
                {
                    exists=true;
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
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
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ClickBut(driver,WebEle,20);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PopupAfterChanges()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button");
                HelpersMethod.ClickBut(driver,WebEle,100);
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
            if(HelpersMethod.IsExists("//div[@class='grid-item-box'][1]/descendant::button[text()='Delete']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box'][1]/descendant::button[text()='Delete']");
                HelpersMethod.ClickBut(driver, WebEle, 20);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement buttonOk=modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
                    HelpersMethod.ClickBut(driver,buttonOk,60);
                }
                exists = true;
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
        String category=null;
        String subCategory=null;
        String brand=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement CategoryDrop=HelpersMethod.FindByElement(driver,"id","CPcategories");
                WebElement SubCateDrop=HelpersMethod.FindByElement(driver,"id","CPbrands");
                WebElement BrandDrop=HelpersMethod.FindByElement(driver,"id","CPsizes");
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Select'][1]/ancestor::div[contains(@class,'grid-item-box-item')]/ancestor::div[@class='grid-item-box']/descendant::span[text()='Category']/following-sibling::span");
                category = WebEle.getText();
                //Click on Category drop down
                HelpersMethod.ClickBut(driver,CategoryDrop,10);
                HelpersMethod.DropDownMenu(driver,category);
                category=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPcategories']/span[@class='k-input']").getText();
                scenario.log("CATEGORY  SELECTED IS "+category);

                //Click on Sub Category dropdown
                HelpersMethod.ClickBut(driver,SubCateDrop,10);
                Lists=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
               if(Lists.size()>=2)
               {
                   WebEle = Lists.get(2);
                   subCategory = WebEle.getText();
               }
                HelpersMethod.DropDownMenu(driver,subCategory);
                subCategory=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPbrands']/span[@class='k-input']").getText();
                scenario.log("SUBCATEGORY  SELECTED IS "+subCategory);

                //Click on Brand dropdown
                HelpersMethod.ClickBut(driver,BrandDrop,10);
                Lists=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
                if(Lists.size()>=2)
                {
                    WebEle = Lists.get(2);
                    brand = WebEle.getText();
                }
                HelpersMethod.DropDownMenu(driver,brand);
                brand=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPbrands']/span[@class='k-input']").getText();
                scenario.log("BRAND SELECTED IS "+brand);
            }
        }
        catch (Exception e){}
    }

    public void deleteAllFeatureProduct()
    {
        try
        {
            WebElement WebEle;
            List<WebElement> deleteProds = HelpersMethod.FindByElements(driver, "id", "edit-role");
            for (WebElement deleteProd : deleteProds)
            {
                HelpersMethod.ClickBut(driver, deleteProd, 100);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
                if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement buttonOk = modalContainer.findElement(By.xpath(".//button[text()='OK']"));
                    HelpersMethod.ClickBut(driver, buttonOk, 100);
                }
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
            if (HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
               WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'card-view')]/descendant::button[text()='Select'][1]");
               HelpersMethod.ClickBut(driver,WebEle,60);
            }
        }
        catch (Exception e){}
    }

    public void deleteFirstProduct()
    {
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'card-view')]/descendant::button[@id='edit-role'][1]");
            HelpersMethod.ClickBut(driver,WebEle,40);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement modalContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement buttonOk = modalContainer.findElement(By.xpath(".//button[text()='OK']"));
                HelpersMethod.ClickBut(driver, buttonOk, 60);
            }
        }
        catch (Exception e){}
    }
}
