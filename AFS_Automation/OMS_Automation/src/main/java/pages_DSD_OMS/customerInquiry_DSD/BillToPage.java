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
    static String InputValue;

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

    public String EnterText(WebElement WebEle,int length)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,WebEle,10, RandomValues.generateRandomString(length));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
        return InputValue;
    }

    public String EnterNumber(WebElement WebEle, int length)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,WebEle,10,RandomValues.generateRandomNumber(length));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10);

            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
        return InputValue;
    }

    public void Address1Value()
    {
        exists=false;
        try
        {
            InputValue=EnterText(Address1,10);
            HelpersMethod.EnterText(driver,Address1,10,InputValue);
            scenario.log("ADDRESS 1 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,Address1,10));
        }
        catch (Exception e){}
    }

    public void Address2Value()
    {
        exists=false;
        try
        {
            InputValue=EnterText(Address1,10);
            HelpersMethod.EnterText(driver,Address1,10,InputValue);
            scenario.log("ADDRESS 1 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,Address1,10));
        }
        catch (Exception e){}
    }

    public void CityValue()
    {
        exists=false;
        try
        {
            InputValue=EnterText(City,10);
            HelpersMethod.EnterText(driver,City,10,InputValue);
            scenario.log("CITY VALUE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,City,10));
        }
        catch (Exception e){}
    }

    public void ZipValue()
    {
        exists=false;
        try
        {
            InputValue=EnterNumber(Zip,10);
            HelpersMethod.EnterText(driver,Zip,10,InputValue);
            scenario.log("ADDRESS 1 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,Zip,10));
        }
        catch (Exception e){}
    }

    public void StateValue()
    {
        exists=false;
        try
        {
            InputValue=EnterText(State,10);
            HelpersMethod.EnterText(driver,State,10,InputValue);
            scenario.log("STATE VALUE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,State,10));
        }
        catch (Exception e){}
    }

    public void CountryValue()
    {
        exists=false;
        try
        {
            InputValue=EnterText(Country,10);
            HelpersMethod.EnterText(driver,Country,10,InputValue);
            scenario.log("STATE VALUE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,Country,10));
        }
        catch (Exception e){}
    }
}
