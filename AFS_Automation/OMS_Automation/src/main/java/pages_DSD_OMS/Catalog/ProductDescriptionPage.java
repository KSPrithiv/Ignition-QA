package pages_DSD_OMS.Catalog;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    //Declaration of page Webelements
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
        WebElement WebEle=null;
        try
        {
            //code to click on Add to cart button
            HelpersMethod.ScrollElement(driver,Add_Cart);
            HelpersMethod.ActClick(driver,Add_Cart,40);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
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
        WebElement WebEle=null;
        try
        {
            for(int i=0;i<=2;i++)
            {
                //Incrase the Qty by one, by pressing up arrow
                HelpersMethod.ClickBut(driver,Increase,40);

                HelpersMethod.ClickBut(driver,Update_Cart,40);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
                scenario.log("INCREASE BUTTON CLICKED IN PRODUCT DESCRIPTION PAGE");
            }
            for(int i=0;i<=1;i++)
            {
                //Decrease the Qty by one, by pressing down arrow
                HelpersMethod.ClickBut(driver,Decrease,40);
                HelpersMethod.ClickBut(driver,Update_Cart,40);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
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
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,PreviousPage,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //code to click on Delete Icon in product Discription page
    public void Delete_Icon()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ScrollElement(driver,Delete_cart);
            HelpersMethod.ClickBut(driver,Delete_cart,40);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            exists=true;
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
           if(HelpersMethod.IsExists("//span[contains(text(),'Frequently bought together')]",driver)) {
               List<WebElement> Product_Names = HelpersMethod.FindByElements(driver, "xpath", "//div[@id='products-may-like-card']/descendant::div[@class='product-description']/a");
               for (WebElement Prod_Name : Product_Names) {
                   String Prod_Text = Prod_Name.getText();
                   scenario.log("PRODUCT FOUND IS: " + Prod_Text);
               }
               exists = true;
           }
           else
           {
               scenario.log("FREQUENTLY BOUGHT TOGETHER PRODUCTS ARE NOT DISPLAYED, CHECK ADMIN SETTINGS");
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
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
