package pages_DSD_OMS.orderFactorAdmin;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java8.He;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import util.DataBaseConnection;
import util.TestBase;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class orderFactorAdminPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String prodNo=null;
    static String qtyOrderFactor=null;
    static String uom=null;

    @FindBy(xpath="//input[@id='orderFactorTypeDdl']/ancestor::span[@class='k-dropdown-wrap']")
    private WebElement orderFactorDropdown;

    @FindBy(id="orderFactorTypeDdl")
    private WebElement orderFactorInput;

    @FindBy(xpath="//button[contains(text(),'Add product')]")
    private WebElement addProduct;



    public orderFactorAdminPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void validateOrderFactorPage()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@id='cp-order-factor']",driver))
            {
                scenario.log("ORDER FACTOR PAGE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnOrderFactorLevel()
    {
        exists=false;
        try
        {
            if(orderFactorDropdown.isDisplayed())
            {
                HelpersMethod.ActClick(driver,orderFactorDropdown,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}

    }

    public void selectFactorLevel()
    {
        exists=false;
        Actions act=new Actions(driver);
        String oFLevelText=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::ul/li",driver))
            {
                List<WebElement> ordFactLevels=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::ul/li");
                for(WebElement ordFactLevel:ordFactLevels)
                {
                    act.moveToElement(ordFactLevel).build().perform();
                    oFLevelText=ordFactLevel.getText();
                    if(oFLevelText.equalsIgnoreCase("Order factor at product master level"))
                    {
                        act.moveToElement(ordFactLevel).build().perform();
                        act.click(ordFactLevel).build().perform();
                        exists=true;
                        break;
                    }
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateOrderFactorLevel(String qtyOrderFactorlevel)
    {
        exists=false;
        String LevelText;
        try
        {
            LevelText=HelpersMethod.JSGetValueEle(driver,orderFactorInput,10000);
            if(LevelText.equalsIgnoreCase(qtyOrderFactorlevel))
            {
                scenario.log("ORDER FACTOR LEVEL SELECTED IS "+LevelText);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String readFirstOrderFactorProduct()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]/td[1]",driver))
            {
                prodNo=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/td[1]").getText();
                scenario.log("PRODUCT NUMBER SELECTED IS "+prodNo);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
        return prodNo;
    }

    public String readOrderFactorQty()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]/td[4]/descendant::input",driver))
            {
                WebElement ordFactor=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/td[4]/descendant::input");
                qtyOrderFactor=HelpersMethod.JSGetValueEle(driver,ordFactor,10000);
                scenario.log("ORDER FACTOR FOUND FOR PRODUCT "+prodNo+" IS "+qtyOrderFactor);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return qtyOrderFactor;
    }

    public String readOrderFactorUom()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][1]/td[3]",driver))
            {
                WebElement ordFactor=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/td[3]");
                uom=ordFactor.getText();
                scenario.log("UOM FOUND FOR ORDER FACTOR PRODUCT "+prodNo+" IS "+uom);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return uom;
    }

    public void clickOnAddProducts()
    {
        exists=false;
        try
        {
            if(addProduct.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,addProduct,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateProductDialogbox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-grid']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data__message']",driver))
                {
                    scenario.log("NO PRODUCT HAS BEEN FOUND IN PRODUCT DIALOG BOX");
                }
                else
                {
                    scenario.log("PRODUCT DIALOG BOX HAS BEEN FOUND");
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void searchForProductInDialogbox(String prodNo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        exists=false;
        int i=0;
        Actions act=new Actions(driver);
        String headText=null;
       try
       {
           List<WebElement> heads = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[@class='k-column-title']");
           for (WebElement head : heads)
           {
               act.moveToElement(head).build().perform();
               headText = head.getText();
               if (headText.equalsIgnoreCase("Product #"))
               {
                   exists=true;
                   i++;
                   break;
               }
           }
           Assert.assertEquals(exists,true);
           exists=false;
           if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-filter-row']/th["+i+"]/descendant::input",driver))
           {
               WebElement prodSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-filter-row']/th[" + i + "]/descendant::input");
               HelpersMethod.JSSetValueEle(driver,prodSearch,10000,prodNo);

               Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                       .withTimeout(Duration.ofSeconds(120))
                       .pollingEvery(Duration.ofSeconds(2))
                       .ignoring(NoSuchElementException.class);
               wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
               exists=true;
           }
           Assert.assertEquals(exists,true);
       }
       catch (Exception e){}
    }

    public void selectProductInDialogbox()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data__message']",driver))
            {
                WebElement prodRow=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver,prodRow,10000);
                scenario.log("PRODUCT FOUND");
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>NO PRODUCT HAS BEEN FOUND</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void productDialogBoxOkButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']",driver))
            {
                WebElement okButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ActClick(driver, okButton, 10000);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAddingOfProductInOrderFactorGrid(String prodNo)
    {
        exists=true;
        int i=0;
        Actions act=new Actions(driver);
        String headText=null;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='i-grid']/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Product #"))
                {
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
            exists=false;
            if(HelpersMethod.IsExists("//div[@class='i-grid']/descendant::tr[@class='k-filter-row']/descendant::input["+i+"]",driver))
            {
                WebElement inputBox=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-grid']/descendant::tr[@class='k-filter-row']/descendant::input["+i+"]");
                HelpersMethod.JSSetValueEle(driver,inputBox,10000,prodNo);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
            exists=false;
            if(!HelpersMethod.IsExists("//div[@class='i-grid']/descendant::div[@class='i-no-data__message']",driver))
            {
                scenario.log("PRODUCT HAS BEEN FOUND");
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>NO PRODUCTS HAS BEEN FOUND</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void addOrderFactorQty(String qty)
    {
        exists=true;
        int i=0;
        Actions act=new Actions(driver);
        String headText=null;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='i-grid']/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Order Factor/Order increments"))
                {
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
            //Enter value for order factor/order increments
            exists=false;
            if(HelpersMethod.IsExists("//div[@class='i-grid']/descendant::tr[@class='k-filter-row']/descendant::input["+i+"]",driver))
            {
                WebElement inputBox=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-grid']/descendant::tr[@class='k-master-row']/descendant::td["+i+"]/input");
                HelpersMethod.JSSetValueEle(driver,inputBox,10000,qty);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickDelete()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//button[text()='Delete']",driver))
            {
                WebElement deleteButton=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Delete']");
                HelpersMethod.ClickBut(driver,deleteButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateDeleteProductInOrderFactorGrid(String prodNo)
    {
        exists=true;
        int i=0;
        Actions act=new Actions(driver);
        String headText=null;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='i-grid']/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Product #"))
                {
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
            exists=false;
            if(HelpersMethod.IsExists("//div[@class='i-grid']/descendant::tr[@class='k-filter-row']/descendant::input["+i+"]",driver))
            {
                WebElement inputBox=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-grid']/descendant::tr[@class='k-filter-row']/descendant::input["+i+"]");
                HelpersMethod.JSSetValueEle(driver,inputBox,10000,prodNo);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
            exists=false;
            if(HelpersMethod.IsExists("//div[@class='i-grid']/descendant::div[@class='i-no-data__message']",driver))
            {
                scenario.log("PRODUCT HAS BEEN SUCCESSFULLY DELETED FROM ORDER FACTOR");
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>NOT ABLE TO DELETE PRODUCT FROM ORDER FACTOR</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public boolean productAlreadyExistsAsOrderFactor(String prodNo)
    {
        exists=true;
        boolean result=false;
        int i=0;
        Actions act=new Actions(driver);
        String headText=null;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='i-grid']/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Product #"))
                {
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
            exists=false;
            if(HelpersMethod.IsExists("//div[@class='i-grid']/descendant::tr[@class='k-filter-row']/descendant::input["+i+"]",driver))
            {
                WebElement inputBox=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-grid']/descendant::tr[@class='k-filter-row']/descendant::input["+i+"]");
                HelpersMethod.JSSetValueEle(driver,inputBox,10000,prodNo);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
            exists=false;
            if(!HelpersMethod.IsExists("//div[@class='i-grid']/descendant::div[@class='i-no-data__message']",driver))
            {
                scenario.log("PRODUCT HAS BEEN FOUND");
                exists=true;
                result=true;
            }
            else
            {
                scenario.log("<span style='color:red'>NO PRODUCTS HAS BEEN FOUND</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return result;
    }
}
