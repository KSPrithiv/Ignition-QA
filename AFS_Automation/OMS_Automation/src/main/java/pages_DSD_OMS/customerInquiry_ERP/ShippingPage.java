package pages_DSD_OMS.customerInquiry_ERP;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.RandomValues;

import java.util.List;

/**
 * @Project DSD_OMS
 * @Author divya.ramadas@telusagcg.com
 */

public class ShippingPage
{
    /* Created by divya.ramadas@telusagcg.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;

    @FindBy(id="CmDaysToShip")
    private WebElement daysToShip;

    @FindBy(id="CmDeliveryDistanceMiles")
    private WebElement deliveryDistanceMi;

    @FindBy(id="CmDeliveryDistanceKM")
    private WebElement deliveryDistanceKm;

    @FindBy(id="CmGPSLongitude")
    private WebElement gpsLongitude;

    @FindBy(id="CmGPSLatitude")
    private WebElement gpsLatitude;

    @FindBy(id="CmShipLocation")
    private WebElement shipLocationDropDown;

    @FindBy(id="CmFreightZone")
    private WebElement freightZoneDropDown;

    @FindBy(id="CmFreightMethod")
    private WebElement freightMethodDropDown;

    @FindBy(id="CmFreightBase")
    private WebElement freightBaseDropDown;

    @FindBy(id="CmExcludeCallList")
    private WebElement excludeCallListCheckBox;

    public ShippingPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
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

    public void selectDropDownValue()
    {
        String selectValue=null;
        WebElement dropDownOption=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none')]");
        List<WebElement> Options= dropDownOption.findElements(By.xpath(".//ul/li"));
        int option=RandomValues.createRandomIntBetween(0,Options.size()-1);
        try
        {
            if(Options.size()==1)
            {
                scenario.log("THERE ARE NO OPTIONS OTHER THAN 'None'");
                HelpersMethod.ActClick(driver, Options.get(0), 20);
            }
            else
            {
                if(Options.size()==2)
                {
                    for (int i = 0; i <= Options.size() - 1; i++)
                    {
                        if (i == 1)
                        {
                            HelpersMethod.ActClick(driver, Options.get(1), 20);
                            break;
                        }
                    }
                }
                else
                {
                    for (int i = 0; i <= Options.size() - 1; i++)
                    {
                        if (i == 2)
                        {
                            HelpersMethod.ActClick(driver, Options.get(2), 20);
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void daysToShipTextBox()
    {
        InputValue=EnterText(daysToShip,10);
        HelpersMethod.EnterText(driver,daysToShip,10,InputValue);
        scenario.log("DELIVERY CONTACT ENTERED IS "+HelpersMethod.JSGetValueEle(driver,daysToShip,10));
    }
    public void deliveryDistanceMiTextBox()
    {
        InputValue=EnterText(deliveryDistanceMi,10);
        HelpersMethod.EnterText(driver,deliveryDistanceMi,10,InputValue);
        scenario.log("DELIVERY DISTANCE Mi ENTERED IS "+HelpersMethod.JSGetValueEle(driver,deliveryDistanceMi,10));
    }
    public void deliveryDistanceKmTextBox()
    {
        InputValue=EnterText(deliveryDistanceKm,10);
        HelpersMethod.EnterText(driver,deliveryDistanceKm,10,InputValue);
        scenario.log("DELIVERY DISTANCE Km ENTERED IS "+HelpersMethod.JSGetValueEle(driver,deliveryDistanceKm,10));
    }
    public void gpsLongitudeTextBox()
    {
        InputValue=EnterText(gpsLongitude,10);
        HelpersMethod.EnterText(driver,gpsLongitude,10,InputValue);
        scenario.log("GPS LONGITUDE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,gpsLongitude,10));
    }
    public void gpsLatitudeTextBox()
    {
        InputValue=EnterText(gpsLatitude,10);
        HelpersMethod.EnterText(driver,gpsLatitude,10,InputValue);
        scenario.log("GPS LONGITUDE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,gpsLatitude,10));
    }

    public void shipLocationDropDown()
    {
        HelpersMethod.ClickBut(driver,shipLocationDropDown,40);
        selectDropDownValue();
        scenario.log("SHIPPING DROP DOWN IS "+shipLocationDropDown.getText());
    }

    public void freightZoneDropDown()
    {
        HelpersMethod.ClickBut(driver,freightZoneDropDown,40);
        selectDropDownValue();
        scenario.log("FREIGHT ZONE DROP DOWN IS "+freightZoneDropDown.getText());
    }

    public void freightMethodDropDown()
    {
        HelpersMethod.ClickBut(driver,freightMethodDropDown,40);
        selectDropDownValue();
        scenario.log("FREIGHT METHOD DROP DOWN IS "+freightMethodDropDown.getText());
    }

    public void freightBaseDropDown()
    {
        HelpersMethod.ClickBut(driver,freightBaseDropDown,40);
        selectDropDownValue();
        scenario.log("FREIGHT BASE DROP DOWN IS "+freightBaseDropDown.getText());
    }

    public void excludeCallListCheckBox()
    {
        HelpersMethod.ClickBut(driver,excludeCallListCheckBox,10);
        scenario.log("EXCLUDE CALL LIST CHECKBOX SELECTED");
    }
}
