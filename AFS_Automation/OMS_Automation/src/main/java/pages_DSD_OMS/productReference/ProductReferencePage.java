package pages_DSD_OMS.productReference;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.TestBase;

import java.util.List;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
public class ProductReferencePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String status=null;

    @FindBy (xpath="//div[@class='i-search-box']/descendant::input")
    private WebElement searchBox;

    @FindBy(xpath="")
    private WebElement customerNoInput;

    public ProductReferencePage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void NavigateToProductReference()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.Implicitwait(driver,10);
            WebElement ParList=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Product reference')]");
            HelpersMethod.ScrollElement(driver,ParList);
            HelpersMethod.ActClick(driver,ParList,10);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            else
            {
                HelpersMethod.Implicitwait(driver, 20);
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void ValidateProductReference()
    {
        exists=false;
        WebElement webEle=null;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","customerProdutRefCard");
            if(WebEle.isDisplayed())
            {
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void EnterCustomerAccount()
    {
        exists=false;
        WebElement WebEle=null;
        String headText=null;
        String Acc_NO= TestBase.testEnvironment.get_Account();
        int i=0;
        try
        {
            List<WebElement> Theads=HelpersMethod.FindByElements(driver,"xpath","//thead/tr[1]/th/span[@class='k-link']");
            for(WebElement Thead:Theads)
            {
                i++;
                headText=Thead.getText();
                if(headText.equals("Custom Column 1"))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')]/td["+(i)+"]/input");
                    HelpersMethod.ScrollElement(driver,WebEle);
                    HelpersMethod.ActSendKey(driver,WebEle,10, Acc_NO);
                    exists = true;
                }
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }
}
