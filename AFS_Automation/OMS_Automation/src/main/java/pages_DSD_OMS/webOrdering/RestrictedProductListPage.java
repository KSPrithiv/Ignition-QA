package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.messages.Messages;
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
public class RestrictedProductListPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String product;
    static String selectCat;

    @FindBy(xpath="//button/span[contains(text(),'Add product')]//*[local-name()='svg']")
    private WebElement AddProduct;

    @FindBy(xpath="//button/span[contains(text(),'Delete')]//*[local-name()='svg']")
    private WebElement DeleteButton;

    @FindBy(xpath="//label[contains(text(),'Product restrictions group')]/preceding-sibling::input[contains(@name,'productRestrictionsType')]")
    private WebElement ProdGroup;

    //Actions
    public RestrictedProductListPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void ValidateRestrictedProductList()
    {
        exists=false;
        String TitleOfPage=null;
        try
        {
            TitleOfPage= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@id,'CPMyOrderProductRestrictionsForm')]/descendant::span[contains(@class,'i-card__header__title')]").getText();
            if(TitleOfPage.equals("Restricted product list"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DisplayListOfProducts()
    {
        exists=false;
        try
        {
            List<WebElement> Products=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/td[1]");
            for(WebElement Prod:Products)
            {
                String Prod_Text=Prod.getText();
                scenario.log("RESTRICTED PRODUCT "+Prod_Text);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnAddProduct()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            HelpersMethod.ActClick(driver,AddProduct,10000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateProductPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            if(HelpersMethod.IsExists("//span[text()='Products']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectProductFromPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            product=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/td[1]/descendant::button").getText();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            exists=true;
            scenario.log("PRODUCT ADDED AS RESTRICTED PRODCUCT "+product);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnOkInPopup()
    {
        try
        {
            exists=false;
            WebElement WebEle;
            if(HelpersMethod.IsExists("//span[text()='Products']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Products']/ancestor::div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='OK']");
                HelpersMethod.ClickBut(driver,WebEle,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectProductFromGrid()
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> Products=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/td[1]");
            for(WebElement Pro:Products)
            {
                act.moveToElement(Pro).build().perform();
                String Prod_Text=Pro.getText();
                if(Prod_Text.equals(product))
                {
                    act.click(Pro).build().perform();
                    scenario.log("PRODUCT SELECTED FOR DELETING IS "+Prod_Text);
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnDeleteButton()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(DeleteButton.isDisplayed() && DeleteButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, DeleteButton, 10000);
                if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to delete this record?')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='OK']");
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                    }
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ProductGroupRadioButton()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(!ProdGroup.isSelected())
            {
                HelpersMethod.ActClick(driver,ProdGroup,1000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateProductGroup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","ProductRestricitonsGroups-label");
            if(WebEle.isDisplayed())
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickAddProductGroup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//button/span[contains(text(),'Add')]");
            HelpersMethod.ActClick(driver,WebEle,10000);
            if(HelpersMethod.IsExists("//span[contains(text(),'Add')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnDropdownInPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Add')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::input[@id='ProductRestrictionsSubGroups']/following-sibling::button");
                HelpersMethod.ActClick(driver,WebEle,1000);
                List<WebElement> Lists=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='ProductRestrictionsSubGroupslist']/li/span");
                for(int i=1;i<=Lists.size();i++)
                {
                    HelpersMethod.ActClick(driver,Lists.get(1),1000);
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[@id='ProductRestrictionsSubGroups']");
                    selectCat=HelpersMethod.JSGetValueEle(driver,WebEle,1000);
                    scenario.log("CATEGORY GROUP SELECTED IS "+selectCat);
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public  void ClickAddButtonPopup()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Add')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Add')]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }

            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateSelectedProdGroup()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> ProdsDesc=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[2]");
            for(WebElement ProdDesc:ProdsDesc)
            {
                act.moveToElement(ProdDesc).build().perform();
                String Pro_Text=ProdDesc.getText();
                if(Pro_Text.equals(selectCat))
                {
                    scenario.log("PRODUCT GROUP '"+Pro_Text+"' HAS BEEN FOUND IN GRID");
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectProdutInCatGroup()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            scenario.log("PRODUCT TO CATEGORY TO BE DELETED IS "+selectCat);
            List<WebElement> Products=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/td[2]");
            for(WebElement Pro:Products)
            {
                act.moveToElement(Pro).build().perform();
                String Prod_Text=Pro.getText();
                if(Prod_Text.equals(selectCat))
                {
                    act.moveToElement(Pro).build().perform();
                    act.click(Pro).build().perform();
                    scenario.log("CATEGORY GROUP SELECTED FOR DELETING IS "+Prod_Text);
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnOkInDeletePopup()
    {
        try
        {
            exists=false;
            WebElement WebEle;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to delete this record)]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okBtton=WebEle.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ClickBut(driver,okBtton,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}