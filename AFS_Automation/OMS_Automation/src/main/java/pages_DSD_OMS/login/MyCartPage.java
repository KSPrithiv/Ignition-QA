package pages_DSD_OMS.login;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.TestBase;

import java.awt.*;
import java.time.Duration;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class MyCartPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="checkoutToOrder")
    private WebElement CheOutOrder;

    @FindBy(xpath = "//div[@class='delete-button-container']")
    private WebElement DeleteIcon;

    @FindBy(xpath = "//button[contains(@class,'buttonMinus')]")
    private WebElement MinusButton;

    @FindBy(xpath = "//button[contains(@class,'buttonPlus')]")
    private  WebElement PlusButton;


    public MyCartPage(WebDriver driver,Scenario scenario) throws InterruptedException, AWTException
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Click on Check out to order button
    public void CheckOut_To_Order() throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
        }
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
            HelpersMethod.ScrollElement(driver,CheOutOrder);
            HelpersMethod.ClickBut(driver,CheOutOrder,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }

            if(HelpersMethod.IsExists("//div[contains(text(),'Select order')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement selectPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebEle=selectPopup.findElement(By.xpath(".//div[contains(text(),'New order')]"));
                HelpersMethod.ActClick(driver,WebEle,20);
                WebEle=selectPopup.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']"));
                HelpersMethod.ClickBut(driver,WebEle,20);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
            }
            exists=true;

            //to handle pending order popup
            if(HelpersMethod.IsExists("//div[contains(text(),'Pending order will be overwritten')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement pendingPopup = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement startButton=pendingPopup.findElement(By.xpath(".//button[contains(text(),'Start new order')]"));
                HelpersMethod.ClickBut(driver,startButton,100);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
                }
            }

            scenario.log("CHECKOUT TO ORDER HAS BEEN CLICKED");
            Assert.assertEquals(exists,true);
    }

    //Delete button in 'My cart' page
    public void DeleteButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
            }
            WebElement Del_But = HelpersMethod.FindByElement(driver, "xpath", "//tr[1]//*[local-name()='svg' and contains(@class,'delete')]");
            if(Del_But.isDisplayed() && Del_But.isEnabled())
            {
                HelpersMethod.ActClick(driver, Del_But, 100);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                }

                scenario.log("DELETE BUTTON CLICKED");
                exists=true;
            }
            else
            {
                scenario.log("DELETE BUTTON IS NOT VISIBLE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void navigateToOrderCart()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            String PageTitle = HelpersMethod.gettingTitle(driver);
            Assert.assertEquals(PageTitle, "Order Cart");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
        }
        catch (Exception e){}
    }
}
