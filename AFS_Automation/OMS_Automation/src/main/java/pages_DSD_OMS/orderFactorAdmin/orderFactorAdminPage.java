package pages_DSD_OMS.orderFactorAdmin;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
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
    static int columnNo=0;
    static int lastPage=0;
    static int a=0;
    static int pageNumber=0;
    static int rowNo=0;
    int skipRow=0;

   // @FindBy(xpath="//input[@id='orderFactorTypeDdl']/ancestor::span[@class='k-dropdown-wrap']/descendant::input")
   // private WebElement orderFactorIn;

    @FindBy(xpath = "//input[@id='orderFactorTypeDdl']/ancestor::span[@class='k-dropdown-wrap']/descendant::span[contains(@class,'k-i-arrow-s')]")
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

    public void selectFactorLevel(String orderFactorLevel)
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
                    if(oFLevelText.equalsIgnoreCase(orderFactorLevel))
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

    public String readFirstProductInProductDialogBox()
    {
        exists=false;
        WebElement prod;
        String titleText;String pageText;String creditText;
        Actions act=new Actions(driver);
        Wait<WebDriver> wait;
        List<WebElement> pages;
        boolean found=false;
        WebElement page1 = null;
        int lastPage;
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
                    WebElement loadProd=HelpersMethod.FindByElement(driver,"xapth","//span[contains(text(),'load all products')]");
                    HelpersMethod.ActClick(driver,loadProd,10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(120))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
                if(HelpersMethod.IsExists("//*[local-name()='svg']/ancestor::tr[@class='k-master-row']/descendant::button|//*[local-name()='svg']/ancestor::tr[@class='k-master-row k-alt']/descendant::button|//*[local-name()='svg']/ancestor::tr[@class='k-master-row k-state-selected']/descendant::button",driver))
                {
                    //Code to find last page number
                    WebElement lastArrow= HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::span[@class='k-icon k-i-arrow-end-right']");
                    HelpersMethod.ActClick(driver,lastArrow,10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //code to read last page number
                    List<WebElement> pageNos=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::ul[@class='k-pager-numbers k-reset']/li/a");
                    int i=pageNos.size()-1;
                    act.moveToElement(pageNos.get(i)).build().perform();
                    lastPage= Integer.parseInt(pageNos.get(i).getText());
                    scenario.log("NUMBER OF PAGES IN PRODUCT DIALOG BOX ARE: "+lastPage);

                    //code to navigate to first page again
                    WebElement firstArrow=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::span[@class='k-icon k-i-arrow-end-left']");
                    HelpersMethod.ActClick(driver,firstArrow,10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //code to loop through the page numbers
                    for(int j=0;j<=lastPage;j++)
                    {
                        pages = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='k-widget k-window k-dialog']/descendant::ul[@class='k-pager-numbers k-reset']/li/a");
                        for (WebElement page : pages)
                        {
                            act.moveToElement(page).build().perform();
                            pageText = page.getText();
                            if (!pageText.equalsIgnoreCase("..."))
                            {
                                act.moveToElement(page).build().perform();
                                pageNumber = Integer.parseInt(page.getText());
                                act.click(page).build().perform();
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(200))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                                if (HelpersMethod.IsExists("//*[local-name()='svg' and @fill='#FF9800']/ancestor::tr[@class='k-master-row']/descendant::button|//*[local-name()='svg' and @fill='#FF9800']/ancestor::tr[@class='k-master-row k-alt']/descendant::button", driver))
                                {
                                    List<WebElement> products = HelpersMethod.FindByElements(driver, "xpath", "//*[local-name()='svg' and @fill='#FF9800']/ancestor::tr[@class='k-master-row']/descendant::button|//*[local-name()='svg' and @fill='#FF9800']/ancestor::tr[@class='k-master-row k-alt']/descendant::button");
                                    for (int l = 0; l <= products.size() - 1; l++)
                                    {
                                        if (l == 0)
                                        {
                                            prod = products.get(l);
                                            prodNo = prod.getText();
                                            scenario.log("PRODUCT NUMBER SELECTED FOR ORDER FACTOR IS " + prodNo);
                                            HelpersMethod.ActClick(driver, prod, 10000);
                                            found=true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if(found==true)
                            {
                                break;
                            }
                        }
                        if(found==true)
                        {
                            break;
                        }
                        else if(found==false)
                        {
                            int size = pages.size() - 1;
                            page1 = pages.get(size);
                            pageText = page1.getText();
                            if (pageText.equals("..."))
                            {
                                act.moveToElement(page1).build().perform();
                                act.click().build().perform();
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(200))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                            }
                            else
                            {
                                scenario.log("<span style='color:red'>ALL PRODUCTS ARE PART OF ORDER FACTOR</span>");
                            }
                        }
                    }
                }
                else
                {
                    //Code to find last page number
                    WebElement lastArrow= HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::span[@class='k-icon k-i-arrow-end-right']");
                    HelpersMethod.ActClick(driver,lastArrow,10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //code to read last page number
                    List<WebElement> pageNos=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::ul[@class='k-pager-numbers k-reset']/li/a");
                    int i=pageNos.size()-1;
                    act.moveToElement(pageNos.get(i)).build().perform();
                    lastPage= Integer.parseInt(pageNos.get(i).getText());
                    scenario.log("NUMBER OF PAGES IN PRODUCT DIALOG BOX ARE: "+lastPage);

                    //code to navigate to first page again
                    WebElement firstArrow=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::span[@class='k-icon k-i-arrow-end-left']");
                    HelpersMethod.ActClick(driver,firstArrow,10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    //code to loop through the page numbers
                    for(int j=0;j<=lastPage;j++)
                    {
                        pages = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='k-widget k-window k-dialog']/descendant::ul[@class='k-pager-numbers k-reset']/li/a");
                        for (WebElement page : pages)
                        {
                            act.moveToElement(page).build().perform();
                            pageText = page.getText();
                            if (!pageText.equalsIgnoreCase("..."))
                            {
                                act.moveToElement(page).build().perform();
                                pageNumber = Integer.parseInt(page.getText());
                                act.click(page).build().perform();
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(200))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                                //Code to find unselected product for order factor
                                if(HelpersMethod.IsExists("//div[@class='k-widget k-window k-dialog']/descendant::tr[@class='k-master-row k-alt']/descendant::button|//div[@class='k-widget k-window k-dialog']/descendant::tr[@class='k-master-row']/descendant::button",driver))
                                {
                                    List<WebElement> products = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='k-widget k-window k-dialog']/descendant::tr[@class='k-master-row k-alt']/descendant::button|//div[@class='k-widget k-window k-dialog']/descendant::tr[@class='k-master-row']/descendant::button");
                                    for (int p = 0; p <= products.size() - 1; p++)
                                    {
                                        if (p == 0)
                                        {
                                            prod = products.get(p);
                                            prodNo = prod.getText();
                                            scenario.log("PRODUCT NUMBER SELECTED FOR ORDER FACTOR IS " + prodNo);
                                            HelpersMethod.ActClick(driver, prod, 10000);
                                            found=true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if(found==true)
                            {
                                break;
                            }
                        }
                        if(found==true)
                        {
                            break;
                        }
                        else if(found==false)
                        {
                            int size = pages.size() - 1;
                            page1 = pages.get(size);
                            pageText = page1.getText();
                            if (pageText.equals("..."))
                            {
                                act.moveToElement(page1).build().perform();
                                act.click().build().perform();
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(200))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                            }
                            else
                            {
                                scenario.log("<span style='color:red'>ALL PRODUCTS ARE PART OF ORDER FACTOR</span>");
                            }
                        }
                    }
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(addProduct.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,addProduct,10000);
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
        String headText=null;
       try
       {
           if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data__message']",driver))
           {
               scenario.log("<span style='color:red'>NO PRODUCT HAS BEEN FOUND</span>");
           }
           else
           {
               List<WebElement> heads = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[@class='k-column-title']");
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
               if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-filter-row']/th[" + i + "]/descendant::input", driver))
               {
                   WebElement prodSearch = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-filter-row']/th[" + i + "]/descendant::input");
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

    public void selectProductOfOrderFactor()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-no-data__message']",driver))
            {
                scenario.log("<span style='color:red'>PRODUCT HAS NOT BEEN FOUND TO DELETE PRODUCT FROM ORDER FACTOR</span>");
            }
            else
            {
               WebElement delEle=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-master-row k-grid-edit-row']");
               HelpersMethod.ActClick(driver,delEle,10000);
               scenario.log("PRODUCT HAS BEEN SELECTED FOR DELETING IN ORDER FACTOR");
            }
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@class='i-grid']/descendant::span[@class='k-column-title']");
            for(WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equalsIgnoreCase("Order Factor/Order increments"))
                {
                    scenario.log("QTY COLUMN HAS BEEN FOUND AT POSITION "+i);
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
            //Enter value for order factor/order increments
            exists=false;
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')]/descendant::td["+i+"]/descendant::input",driver))
            {
                WebElement inputBox=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td["+i+"]/descendant::input");
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
            if(HelpersMethod.IsExists("//button[text()='Delete']",driver))
            {
                WebElement deleteButton=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Delete']");
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
            if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to delete this record?')]/ancestor::div[@class='k-widget k-window k-dialog']",driver))
            {
                WebElement deleteOKButton=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[text()='OK']");
                if(deleteOKButton.isEnabled())
                {
                    HelpersMethod.ActClick(driver, deleteOKButton, 10000);
                    exists = true;
                }
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
                HelpersMethod.ClearText(driver,inputBox,10000);
                HelpersMethod.EnterText(driver,inputBox,10000,prodNo);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
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
        String headText=null;
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

    /*public void selectCustomer(String customer)
    {
        exists=false;
        Actions act=new Actions(driver);
        String accText;
        try
        {
            if(HelpersMethod.IsExists("//input[@id='orderFactorCustomerDdl']/parent::span[@class='k-searchbar']/following-sibling::span",driver))
            {
                //click on arrow for gettting drop down
                WebElement arrowIcon=HelpersMethod.FindByElement(driver,"xpath","//input[@id='orderFactorCustomerDdl']/parent::span[@class='k-searchbar']/following-sibling::span");
                HelpersMethod.ActClick(driver,arrowIcon,10000);
                //Select customer account number from drop down
                List<WebElement> accounts=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container-relative k-list-containe')]/descendant::ul/li");
                for(WebElement account:accounts)
                {
                     act.moveToElement(account).build().perform();
                     accText=account.getText();
                     if(accText.contains(customer))
                     {
                         act.moveToElement(account).build().perform();
                         act.click().build().perform();
                         scenario.log(customer+" CUSTOMER ACCOUNT # HAS BEEN FOUND");
                         Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                 .withTimeout(Duration.ofSeconds(120))
                                 .pollingEvery(Duration.ofSeconds(2))
                                 .ignoring(NoSuchElementException.class);
                         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                         exists=true;
                         break;
                     }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }*/

    public void selectCustomer(String customer)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//input[@id='orderFactorCustomerDdl']/parent::span[@class='k-searchbar']",driver))
            {
                WebElement searchBar=HelpersMethod.FindByElement(driver,"xpath","//input[@id='orderFactorCustomerDdl']/parent::span[@class='k-searchbar']");
                HelpersMethod.ActClearKey(driver,searchBar,10000);
                HelpersMethod.ActSendKeyEnter(driver,searchBar,10000,customer);
            }
        }
        catch (Exception e){}
    }
}
