package pages_DSD_OMS.Catalog;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class ProductDescriptionPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    //Declaration of page Web elements
    @FindBy(id="product-quantity")
    private WebElement Qty_In;

    @FindBy(id="add-to-cart-button")
    private WebElement Add_Cart;

    @FindBy(id="update-cart-button")
    private WebElement Update_Cart;

    @FindBy(xpath="//span[contains(@class,'increase')]")
    private WebElement Increase;

    @FindBy(xpath = "//span[contains(@class,'decrease')]")
    private WebElement Decrease;

    @FindBy(id="back-to-previous-page")
    private WebElement PreviousPage;

    @FindBy(id="delete-from-cart-button")
    private WebElement Delete_cart;

    //Constructor for Catalog page, Initializing the Page Objects:
    public ProductDescriptionPage(WebDriver driver, Scenario scenario)
    {
        this.scenario=scenario;
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    //Enter value in input box
    public void Qty_Inputbox(String Qty)
    {
        exists=false;
        try
        {

            //HelpersMethod.WaitElementPresent(driver,"classname","product-detail-container",100000);
            HelpersMethod.ScrollElement(driver,Qty_In);
            //Code to enter Qty in Input box
            HelpersMethod.EnterText(driver, Qty_In, 4000, Qty);
            exists = true;
        }
        catch (Exception e) {}
        Assert.assertEquals(exists,true);
    }
    //Code to click on Add to cart
    public void Add_to_cart()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            //code to click on Add to cart button
            Add_Cart= HelpersMethod.FindByElement(driver,"id","add-to-cart-button");
            HelpersMethod.ScrollElement(driver,Add_Cart);
            HelpersMethod.ClickBut(driver,Add_Cart,4000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
            }
            Thread.sleep(2000);
            if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement unavailablePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement yesButton = unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver, yesButton, 1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to increase or decrease the Qty by using arrow keys
    public void Increase_Descrease()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            for(int i=0;i<=2;i++)
            {
                //Incrase the Qty by one, by pressing up arrow
                HelpersMethod.ClickBut(driver,Increase,1000);
                HelpersMethod.ClickBut(driver,Update_Cart,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                Thread.sleep(1000);
                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement unavailablePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement yesButton = unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver, yesButton, 1000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                    }
                }
                scenario.log("INCREASE BUTTON CLICKED IN PRODUCT DESCRIPTION PAGE");
            }
            for(int i=0;i<=1;i++)
            {
                //Decrease the Qty by one, by pressing down arrow
                HelpersMethod.ClickBut(driver,Decrease,1000);
                HelpersMethod.ClickBut(driver,Update_Cart,1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                Thread.sleep(1000);
                if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement unavailablePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This product is currently unavailable')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement yesButton = unavailablePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver, yesButton, 1000);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                    }
                }
                scenario.log("DECREASE BUTTON CLICKED IN PRODUCT DESCRIPTION PAGE");
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to click on Back to previous page, in product discription page
    public void Back_to_Catalog()
    {
        exists=false;

        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if(PreviousPage.isDisplayed() && PreviousPage.isEnabled())
            {
                HelpersMethod.ClickBut(driver, PreviousPage, 1000);
                exists = true;
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //code to click on Delete Icon in product Discription page
    public void Delete_Icon()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(Delete_cart.isDisplayed() && Delete_cart.isEnabled())
            {
                HelpersMethod.ScrollElement(driver, Delete_cart);
                HelpersMethod.ClickBut(driver, Delete_cart, 1000);
                exists = true;
            }
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to display product name, which comes under product you may like
    public void FrequentlyBought()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'Frequently bought together')]",driver))
            {
                WebElement freqItems=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Frequently bought together')]");
                HelpersMethod.ScrollElement(driver,freqItems);
                List<WebElement> Product_Names = HelpersMethod.FindByElements(driver, "xpath", "//div[@id='products-may-like-card']/descendant::div[@class='product-description']/a");
                for (WebElement Prod_Name : Product_Names)
                {
                    String Prod_Text = Prod_Name.getText();
                    scenario.log("PRODUCT FOUND IS: " + Prod_Text);
                }
                exists = true;
            }
            else
            {
                scenario.log("<span style='color:red'>FREQUENTLY BOUGHT TOGETHER PRODUCTS ARE NOT DISPLAYED, CHECK ADMIN SETTINGS</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateProductDescriptionPage()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String head=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'spnmoduleNameHeader')]").getText();
            if(head.contains("Product detail"))
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateProductDescription(String descriptionProd)
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String prodDesc=HelpersMethod.FindByElement(driver,"xpath","//div[@class='product-description-container']/div[@class='product-description']").getText();
            if(prodDesc.equals("descriptionProd"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}