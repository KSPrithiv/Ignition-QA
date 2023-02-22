package pages_DSD_OMS.customerInquiry_DSD;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.RandomValues;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class BillToPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;

    @FindBy(id="CmAltBillToAdd1")
    private WebElement Address1;

    @FindBy(id="CmAltBillToAdd2")
    private WebElement Address2;

    @FindBy(id="CmAltBillToCity")
    private WebElement City;

    @FindBy(id="CmAltBillToState")
    private WebElement State;

    @FindBy(id="CmAltBillToZip")
    private WebElement Zip;

    @FindBy(id="CmAltBillToCntry")
    private WebElement Country;

    //actions
    public BillToPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void ValidateBillTo()
    {
        exists=false;
        try
        {
           if(HelpersMethod.IsExists("//p[contains(text(),'Primary bill to address')]",driver))
           {
               exists=true;
           }
           else
           {
               scenario.log("NOT NAVIGATED TO BILL TO TAB");
           }
        }
        catch (Exception e){}
    }

    public void Address1Value()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,Address1,10, RandomValues.generateRandomString(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,Address1,10);
            if(!InputValue.equals("null"))
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void Address2Value()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,Address2,10, RandomValues.generateRandomString(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,Address2,10);
            if(!InputValue.equals("null"))
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void CityValue()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,City,10, RandomValues.generateRandomString(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,City,10);
            if(!InputValue.equals("null"))
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void ZipValue()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,Zip,10, RandomValues.generateRandomNumber(8));
            InputValue=HelpersMethod.JSGetValueEle(driver,Zip,10);
            if(!InputValue.equals("null"))
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void StateValue()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,State,10, RandomValues.generateRandomString(8));
            InputValue=HelpersMethod.JSGetValueEle(driver,State,10);
            if(!InputValue.equals("null"))
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void CountryValue()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,Country,10, RandomValues.generateRandomString(8));
            InputValue=HelpersMethod.JSGetValueEle(driver,Country,10);
            if(!InputValue.equals("null"))
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }


}
