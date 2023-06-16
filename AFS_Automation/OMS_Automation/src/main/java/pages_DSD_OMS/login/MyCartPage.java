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
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
        }
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
            HelpersMethod.WaitElementPresent(driver,"id","cartItemsCard",600);
            HelpersMethod.ScrollElement(driver,CheOutOrder);
            HelpersMethod.ClickBut(driver,CheOutOrder,200);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
            }

            //HelpersMethod.WaitElementPresent(driver,"xpath","//div[@id='checkoutCard']",800);
            scenario.log("CHECKOUT TO ORDER HAS BEEN CLICKED");
            Assert.assertEquals(exists,true);
    }

    //Delete button in 'My cart' page
    public void DeleteButton()
    {
        exists=false;
        try
        {
            WebElement Del_But = HelpersMethod.FindByElement(driver, "xpath", "//tr[1]//*[local-name()='svg' and contains(@class,'delete')]");
            if(Del_But.isDisplayed() && Del_But.isEnabled())
            {
                HelpersMethod.ActClick(driver, Del_But, 60);
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
}
