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
 * @Author Divya.Ramadas@afsi.com
 */

public class MarketingPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue;

    @FindBy(id="CmSalesman")
    private WebElement salesRepDropDown;

    @FindBy(id="CmSalesman2")
    private WebElement salesRep2DropDown;

    @FindBy(id="CmSalesman3")
    private WebElement salesRep3DropDown;

    @FindBy(id="CmBroker")
    private WebElement brokerDropDown;

    @FindBy(id="CmBroker2")
    private WebElement broker2DropDown;

    @FindBy(id="CmBroker3")
    private WebElement broker3DropDown;

    @FindBy(id="CmFOBCode")
    private WebElement FOBCodeDropDown;

    @FindBy(id="CmRegionCode")
    private WebElement regionCodeDropDown;

    @FindBy(id="CmTerritoryCode")
    private WebElement territoryCodeDropDown;

    @FindBy(id="CmOriginCode")
    private WebElement originCodeDropDown;

    @FindBy(id="CmSalesAnalysisCust")
    private WebElement salesAnalysisCustDropDown;

    @FindBy(id="CmDesiredServiceLevel")
    private WebElement desiredServiceLevel;

//@FindBy(id="CmDistributorId")
//    private WebElement customerTypeCodeDropDown;

    @FindBy(id="CmLocalChainId")
    private WebElement localChainIdDropDown;

    @FindBy(id="CmNationalChainId")
    private WebElement nationalChainIdDropDown;

    @FindBy(id="CmPriceGroup")
    private WebElement PriceGroupDropDown;

    public MarketingPage(WebDriver driver,Scenario scenario)
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
        //WebElement dropDownOption=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-list-container k-reset i-common-dropdown i-common-dropdown__type-none')]");
        List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
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

    public void salesRepDropDown()
    {
        HelpersMethod.ClickBut(driver,salesRepDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SALES REP DROP DOWN IS "+salesRepDropDown.getText());
    }
    public void salesRep2DropDown()
    {
        HelpersMethod.ClickBut(driver,salesRep2DropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SALES REP2 DROP DOWN IS "+salesRep2DropDown.getText());
    }
    public void salesRep3DropDown()
    {
        HelpersMethod.ClickBut(driver,salesRep3DropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SALES REP3 DROP DOWN IS "+salesRep3DropDown.getText());
    }
    public void brokerDropDown()
    {
        HelpersMethod.ClickBut(driver,brokerDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM BROKER DROP DOWN IS "+brokerDropDown.getText());
    }
    public void broker2DropDown()
    {
        HelpersMethod.ClickBut(driver,broker2DropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM BROKER2 DROP DOWN IS "+brokerDropDown.getText());
    }
    public void broker3DropDown()
    {
        HelpersMethod.ClickBut(driver,broker3DropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM BROKER3 DROP DOWN IS "+broker3DropDown.getText());
    }
    public void FOBCodeDropDown()
    {
        HelpersMethod.ClickBut(driver,FOBCodeDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM FOB Code DROP DOWN IS "+FOBCodeDropDown.getText());
    }
    public void regionCodeDropDown()
    {
        HelpersMethod.ClickBut(driver, regionCodeDropDown, 40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM REGION CODE DROP DOWN IS " + regionCodeDropDown.getText());
    }
    public void territoryCodeDropDown()
    {
        HelpersMethod.ClickBut(driver,territoryCodeDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM TERRITORY DROP DOWN IS "+territoryCodeDropDown.getText());
    }
    public void originCodeDropDown()
    {
        HelpersMethod.ClickBut(driver,originCodeDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM ORIGIN CODE DROP DOWN IS "+originCodeDropDown.getText());
    }
    public void salesAnalysisCustDropDown()
    {
        HelpersMethod.ClickBut(driver,salesAnalysisCustDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SALES ANALYSIS CUST DROP DOWN IS "+salesAnalysisCustDropDown.getText());
    }
    public void desiredServiceLevel()
    {
        InputValue=EnterText(desiredServiceLevel,10);
        HelpersMethod.EnterText(driver,desiredServiceLevel,10,InputValue);
        scenario.log("FIRST NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,desiredServiceLevel,10));
    }
    /*public void customerTypeCodeDropDown()
    {
        HelpersMethod.ClickBut(driver,customerTypeCodeDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM COUNTY DROP DOWN IS "+customerTypeCodeDropDown.getText());
    }*/
    public void localChainIdDropDown()
    {
        HelpersMethod.ClickBut(driver,localChainIdDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM LOCAL CHAIN DROP DOWN IS "+localChainIdDropDown.getText());
    }
    public void nationalChainDropDown()
    {
        HelpersMethod.ClickBut(driver,nationalChainIdDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM NATIONAL CHAIN DROP DOWN IS "+nationalChainIdDropDown.getText());
    }
    public void priceGroupDropDown()
    {
        HelpersMethod.ClickBut(driver,PriceGroupDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM PRICE GROUP DROP DOWN IS "+PriceGroupDropDown.getText());
    }





}
