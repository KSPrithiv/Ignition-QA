package pages_DSD_OMS.orderFactorAdmin;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
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
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class orderFactorAdminPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String prodNo;
    static String qtyOrderFactor;
    static String uom;
    static int pageNumber;
    int j=0;
    int l=0;
    int k=0;

   // @FindBy(xpath="//input[@id='orderFactorTypeDdl']/ancestor::span[@class='k-dropdown-wrap']/descendant::input")
   // private WebElement orderFactorIn;

    @FindBy(xpath = "//input[@id='orderFactorTypeDdl']/following-sibling::button")
    private WebElement orderFactorDropdown;

    @FindBy(id="orderFactorTypeDdl")
    private WebElement orderFactorInput;

    @FindBy(xpath="//button/span[contains(text(),'Add product')]")
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
                    .withTimeout(Duration.ofSeconds(200))
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

    public void orderFactorToggleButton()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//span[@id='CPEnableOrderFactor' and @aria-checked='true']",driver))
            {
                WebElement orderFactor=HelpersMethod.FindByElement(driver,"id","CPEnableOrderFactor");
                HelpersMethod.ActClick(driver,orderFactor,10000);
                scenario.log("ORDER FACTOR TOGGLE BUTTON HAS BEEN ENABLED");
                Thread.sleep(500);
            }
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

    public void selectFactorLevel(String orderFactorLevel)
    {
        exists=false;
        Actions act=new Actions(driver);
        String oFLevelText;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='orderFactorTypeDdllist']/li/span"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='orderFactorTypeDdllist']/li/span")));

            if(HelpersMethod.IsExists("//ul[@id='orderFactorTypeDdllist']/li/span",driver))
            {
                List<WebElement> ordFactLevels=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='orderFactorTypeDdllist']/li/span");
                for(WebElement ordFactLevel:ordFactLevels)
                {
                    act.moveToElement(ordFactLevel).build().perform();
                    oFLevelText=ordFactLevel.getText();
                    if(oFLevelText.equalsIgnoreCase(orderFactorLevel))
                    {
                        act.moveToElement(ordFactLevel).build().perform();
                        act.click(ordFactLevel).build().perform();
                        exists=true;
                        break;
                    }
                }

                wait = new FluentWait<WebDriver>(driver)
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
                        .withTimeout(Duration.ofSeconds(200))
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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

    public String readFirstProductInProductDialogBox() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException
    {
        exists=false;
        Actions act=new Actions(driver);
        Wait<WebDriver> wait;
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(400))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            if(HelpersMethod.IsExists("//div[@class='k-widget k-window k-dialog']/descendant::tr[@class='k-grid-norecords']",driver))
            {
                scenario.log("<span style='color:red'>NO PRODUCTS FOUND IN PRODUCT DIALOG BOX</span>");
            }
            else
            {
                if (HelpersMethod.IsExists("//span[contains(text(),'load all products')]", driver))
                {
                    WebElement loadProd = HelpersMethod.FindByElement(driver, "xapth", "//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver, loadProd, 10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }

                //To find title of product grid in product dialog box
                int i = 0;
                String headText;
                prodNo = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
                scenario.log("PRODUCT TO BE SEARCHED IS "+prodNo);
                List<WebElement> heads = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='k-window k-dialog']/descendant::span[@class='k-column-title']");
                for (WebElement head : heads)
                {
                    i++;
                    act.moveToElement(head).build().perform();
                    headText = head.getText();
                    if (headText.equalsIgnoreCase("Product #"))
                    {
                        break;
                    }
                }
                //Code to search for product in product dialog box
                WebElement filterProd=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::input[@class='k-input-inner']["+i+"]");
                HelpersMethod.EnterText(driver,filterProd,10000,prodNo);
                wait = new FluentWait<WebDriver>(driver)
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

                if(!HelpersMethod.IsExists("//div[@class='k-window k-dialog']/descendant::div[@class='i-no-data__message']",driver))
                {
                    if (!HelpersMethod.IsExists("//div[@class='k-window k-dialog']/descendant::tr[contains(@class,'k-selected')]", driver))
                    {
                        WebElement prodRow = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='k-window k-dialog']/descendant::tr[contains(@class,'k-master-row')]/td[1]");
                        HelpersMethod.JScriptClick(driver, prodRow, 10000);
                        wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(200))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    }
                    String proNumber=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::button[@class='i-link-button']").getText();
                    scenario.log("PRODUCT "+proNumber+" HAS BEEN FOUND IN PRODUCT GRID");
                }
                else
                {
                    scenario.log("PRODUCT HAS NOT BEEN FOUND");
                }
            }
        }
        catch (Exception e){}
        return prodNo;
    }

    public String readOrderFactorQty()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]["+k+"]/descendant::td["+l+"]/descendant::input",driver))
            {
                WebElement ordFactor=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+k+"]/descendant::td["+l+"]/descendant::input");
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(addProduct.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,addProduct,10000);
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

    public void validateProductDialogbox()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[text()='Products']/ancestor::div[@class='k-window k-dialog']",driver))
            {
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-no-data__message']",driver) && !HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
                {
                    scenario.log("NO PRODUCT HAS BEEN FOUND IN PRODUCT DIALOG BOX");
                }
                else
                {
                    scenario.log("PRODUCT DIALOG BOX HAS BEEN FOUND");
                    exists=true;
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
        String headText;
       try
       {
           if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-no-data__message']",driver))
           {
               scenario.log("<span style='color:red'>NO PRODUCT HAS BEEN FOUND</span>");
           }
           else
           {
               List<WebElement> heads = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::span[@class='k-column-title']");
               for (WebElement head : heads)
               {
                   act.moveToElement(head).build().perform();
                   headText = head.getText();
                   if (headText.equalsIgnoreCase("Product #"))
                   {
                       exists = true;
                       i++;
                       break;
                   }
               }
               Assert.assertEquals(exists, true);
               exists = false;
               if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::tr[@class='k-filter-row']/th[" + i + "]/descendant::input", driver))
               {
                   WebElement prodSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::tr[@class='k-filter-row']/th[" + i + "]/descendant::input");
                   HelpersMethod.JSSetValueEle(driver, prodSearch, 10000, prodNo);
                   scenario.log("ORDER FACTOR HAS BEEN CREATED FOR PRODUCT "+prodNo);
                   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                           .withTimeout(Duration.ofSeconds(120))
                           .pollingEvery(Duration.ofSeconds(2))
                           .ignoring(NoSuchElementException.class);
                   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                   exists = true;
               }
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
            if(!HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[@class='i-no-data__message']",driver))
            {
                WebElement prodRow=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
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
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='OK']",driver))
            {
                WebElement okButton = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='OK']");
                HelpersMethod.ActClick(driver, okButton, 10000);
                exists = true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
        String headText;
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
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-filter-row')]/descendant::input["+i+"]",driver))
            {
                WebElement inputBox=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-filter-row')]/descendant::input["+i+"]");
                HelpersMethod.EnterText(driver,inputBox,10000,prodNo);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
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

    public void selectProductOfOrderFactor(String prodNo)
    {
        exists=false;
        Actions act=new Actions(driver);
        int i=0;
        String headText;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-no-data__message']",driver))
            {
                scenario.log("<span style='color:red'>PRODUCT HAS NOT BEEN FOUND TO DELETE PRODUCT FROM ORDER FACTOR</span>");
            }
            else
            {
                List<WebElement> heads = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='i-grid']/descendant::span[@class='k-column-title']");
                for (WebElement head : heads)
                {
                    i++;
                    act.moveToElement(head).build().perform();
                    headText = head.getText();
                    if (headText.equalsIgnoreCase("Product #"))
                    {
                        exists = true;
                        break;
                    }
                }
                Assert.assertEquals(exists, true);
                exists = false;
                if (HelpersMethod.IsExists("//td["+i+"][text()="+prodNo+"]/ancestor::tr", driver))
                {
                    WebElement delEle = HelpersMethod.FindByElement(driver, "xpath", "//td[" + i + "][text()=" + prodNo + "]/ancestor::tr");
                    HelpersMethod.ActClick(driver, delEle, 10000);
                    exists=true;
                    scenario.log("PRODUCT HAS BEEN SELECTED FOR DELETING IN ORDER FACTOR");
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }

    public void addOrderFactorQty(String qty)
    {
        exists=true;
        Actions act=new Actions(driver);
        String headText;
        String pNo;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='i-grid']/descendant::span[@class='k-column-title']");

           //To find position of "Product #" column
            for(WebElement head:heads)
            {
                j++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Product #"))
                {
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);

            //To find row of product recently added as order factor
            exists=false;
            List<WebElement> prods=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/td["+j+"]");
            for(WebElement prod:prods)
            {
              k++;
              act.moveToElement(prod).build().perform();
              pNo=prod.getText();
              if(pNo.equalsIgnoreCase(prodNo))
              {
                  exists=true;
                  break;
              }
            }
            Assert.assertEquals(exists,true);

            exists=false;
            for(WebElement head:heads)
            {
                l++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Order Factor/Order increments"))
                {
                    scenario.log("QTY COLUMN HAS BEEN FOUND AT POSITION "+l);
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);

            //Enter value for order factor/order increments
            exists=false;
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]["+k+"]/descendant::td["+l+"]/descendant::input",driver))
            {
                WebElement inputBox=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+k+"]/descendant::td["+l+"]/descendant::input");
                //HelpersMethod.ClearText(driver,inputBox,10000);
                inputBox.sendKeys(Keys.CONTROL+"a");
                HelpersMethod.EnterText(driver,inputBox,10000,qty);
                scenario.log("QTY ENTERED FOR ORDER FACTOR IS "+qty);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
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
            if(HelpersMethod.IsExists("//button/span[text()='Delete']",driver))
            {
                WebElement deleteButton=HelpersMethod.FindByElement(driver,"xpath","//button/span[text()='Delete']");
                if(deleteButton.isEnabled())
                {
                    HelpersMethod.ClickBut(driver, deleteButton, 10000);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickDeleteOK()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to delete this record?')]/ancestor::div[@class='k-window k-dialog']",driver))
            {
                WebElement deleteDialogBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Are you sure you want to delete this record?')]/ancestor::div[@class='k-window k-dialog']");
                WebElement deleteOKButton=deleteDialogBox.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver, deleteOKButton, 10000);
                exists = true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
        String headText;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-filter-row')]/td["+i+"][text()='Product']",driver))
            {
                WebElement inputBox=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-filter-row')]/descendant::input["+i+"]");
                HelpersMethod.ClearText(driver,inputBox,10000);
                HelpersMethod.EnterText(driver,inputBox,10000,prodNo);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(250))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if(HelpersMethod.IsExists("//div[@class='i-grid']/descendant::div[@class='i-no-data__message']",driver))
            {
                scenario.log(prodNo+" PRODUCT HAS BEEN SUCCESSFULLY DELETED FROM ORDER FACTOR");
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
        String headText;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='i-grid']/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equals("Product #"))
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
                HelpersMethod.JSSetValueEle(driver,inputBox,10000,prodNo);//////////
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
            //exists=false;
            if(!HelpersMethod.IsExists("//div[@class='i-grid']/descendant::div[@class='i-no-data__message']",driver))
            {
                scenario.log("PRODUCT HAS BEEN FOUND");
                //exists=true;
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

    public void selectCustomer(String customer)
    {
        exists=false;
       // Actions act=new Actions(driver);
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//input[@id='orderFactorCustomerDdl']/following-sibling::button",driver))
            {
                WebElement searchBar=HelpersMethod.FindByElement(driver,"xpath","//input[@id='orderFactorCustomerDdl']/following-sibling::button");
                HelpersMethod.ActClearKey(driver,searchBar,10000);
                HelpersMethod.ActSendKeyEnter(driver,searchBar,10000,customer);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void clickLoadAllProducts()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'load all products')]",driver))
            {
                WebElement loadProd=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'load all products')]");
                HelpersMethod.ActClick(driver,loadProd,10000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void ResetFilter_Catalog()
    {
        exists=false;
        WebElement WebEle;

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

        try
        {
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]")));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]")));

            if(HelpersMethod.IsExists("//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='product-catalog-container']/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[@data-test-id='productFilterResetBtn']");
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    exists = true;
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
                else if (HelpersMethod.IsExists("//div[contains(@class,'product-catalog-container catalog-search-grid-view')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]", driver))
                    {
                        List<WebElement> filters = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-window k-dialog')]/descendant::div[contains(@class,'i-filter-tag')]");
                        if (filters.size() > 1)
                        {
                            //Click on 'Add filter'
                            WebElement catalogPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='Catalog']/ancestor::div[contains(@class,'k-window k-dialog')]");
                            WebEle = catalogPopup.findElement(By.xpath(".//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"));
                            HelpersMethod.JScriptClick(driver, WebEle, 100000);

                            status = HelpersMethod.returnDocumentStatus(driver);
                            if (status.equals("loading"))
                            {
                                HelpersMethod.waitTillLoadingPage(driver);
                            }

                            //Click on clear all
                            if (HelpersMethod.IsExists("//button/span[contains(text(),'Clear all')]", driver))
                            {
                                status = HelpersMethod.returnDocumentStatus(driver);
                                if (status.equals("loading"))
                                {
                                    HelpersMethod.waitTillLoadingPage(driver);
                                }
                                //Click on Clear all button
                                WebElement clearAll = driver.findElement(By.xpath("//button/span[contains(text(),'Clear all')]"));
                                HelpersMethod.JScriptClick(driver, clearAll, 100000);
                                exists = true;
                                status = HelpersMethod.returnDocumentStatus(driver);
                                if (status.equals("loading"))
                                {
                                    HelpersMethod.waitTillLoadingPage(driver);
                                }
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(200))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                                status = HelpersMethod.returnDocumentStatus(driver);
                                if (status.equals("loading"))
                                {
                                    HelpersMethod.waitTillLoadingPage(driver);
                                }
                                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add filter']/ancestor::button[contains(@class,'i-filter-tag__main')]"))));
                            }
                        }
                    }
                }
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            Thread.sleep(2000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Method to make sure that "Show all product" is selected in the dropdown, if not select the same
    public void selectAllProducts()
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

}
