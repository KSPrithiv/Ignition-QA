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

public class OrderEntryPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;

    @FindBy(id="CmDelDefaultCoContact")
    private WebElement deliveryContact;

    @FindBy(id="CmDelDefaultCoFirstName")
    private WebElement firstName;

    @FindBy(id="CmDelDefaultCoTel")
    private WebElement telePhone;

    @FindBy(id="CmDelDefaultCoEmail")
    private WebElement emailAddress;

    @FindBy(id="CmOrderType")
    private WebElement defaultOrderTypeDropDown;

    @FindBy(id="CmInitialProducts")
    private WebElement intialProductsDropDown;

    @FindBy(id="CMCombineAllStandard")
    private WebElement combineAllStandardCheckbox;

    @FindBy(id="CmStandingOrderCode")
    private WebElement standingOrderCodeDropDown;

    @FindBy(id="CmAuthorizedProducts")
    private WebElement authorizedProductsDropDown;

    @FindBy(id="CmCigUM")
    private WebElement defaultcigUOMDropDown;

    @FindBy(id="CmPrePrice")
    private WebElement prePriceDropDown;

    @FindBy(id="CmAllocationRank")
    private WebElement allocationRank;

    @FindBy(id="CmAllocationFactor")
    private WebElement allocationFactor;

    @FindBy(id="CmBackOrderCancel")
    private WebElement backOrderDropDown;

    @FindBy(id="CmStandardOrder")
    private WebElement standardOrderDropDown;

    @FindBy(id="CmSalesHold")
    private WebElement salesHoldDropDown;

    /*Actions */
    public OrderEntryPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public String EnterNumber(WebElement WebEle, int length)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,WebEle,10,RandomValues.generateRandomNumber(length));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,1000);

            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
        return InputValue;
    }

    public String EnterText(WebElement WebEle,int length)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,WebEle,10, RandomValues.generateRandomString(length));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,1000);

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
                HelpersMethod.ActClick(driver, Options.get(0), 2000);
            }
            else
            {
                if(Options.size()==2)
                {
                    for (int i = 0; i <= Options.size() - 1; i++)
                    {
                        if (i == 1)
                        {
                            HelpersMethod.ActClick(driver, Options.get(1), 2000);
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
                            HelpersMethod.ActClick(driver, Options.get(2), 2000);
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void deliveryContact()
    {
        InputValue=EnterText(deliveryContact,10);
        HelpersMethod.EnterText(driver,deliveryContact,1000,InputValue);
        scenario.log("DELIVERY CONTACT ENTERED IS "+HelpersMethod.JSGetValueEle(driver,deliveryContact,1000));
    }
    public void firstName()
    {
        InputValue=EnterText(firstName,10);
        HelpersMethod.EnterText(driver,firstName,1000,InputValue);
        scenario.log("FIRST NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,firstName,1000));
    }
    public void telePhone()
    {
        InputValue=EnterNumber(telePhone,10);
        HelpersMethod.EnterText(driver,telePhone,1000,InputValue);
        scenario.log("TELEPHONE NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,telePhone,1000));
    }
    public void emailAddress()
    {
        HelpersMethod.EnterText(driver,emailAddress,1000,RandomValues.generateEmail(10));
        scenario.log("EMAIL ADDRESS ENTERED IS "+HelpersMethod.JSGetValueEle(driver,emailAddress,1000));
    }

    public void defaultOrderTypeDropDown()
    {
        HelpersMethod.ClickBut(driver,defaultOrderTypeDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM DEFAULT ORDER TYPE DROP DOWN IS "+defaultOrderTypeDropDown.getText());
    }
    public void initialProductsDropDown()
    {
        HelpersMethod.ClickBut(driver,intialProductsDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM INITIAL PRODUCTS DROP DOWN IS "+intialProductsDropDown.getText());
    }

    public void standingOrderCodeDropDown()
    {
        HelpersMethod.ClickBut(driver,standingOrderCodeDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM STANDING ORDER CODE DROP DOWN IS "+standingOrderCodeDropDown.getText());
    }
    public void authorizedProductsDropDown()
    {
        HelpersMethod.ClickBut(driver,authorizedProductsDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM AUTHORIZED PRODUCTS DROP DOWN IS "+authorizedProductsDropDown.getText());
    }
    public void defaultcigUOMDropDown()
    {
        HelpersMethod.ClickBut(driver,defaultcigUOMDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM DEFAULT CIG UOM DROP DOWN IS "+defaultcigUOMDropDown.getText());
    }
    public void prePriceDropDown()
    {
        HelpersMethod.ClickBut(driver,prePriceDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM PRE PRICE DROP DOWN IS "+prePriceDropDown.getText());
    }
    public void allocationRank()
    {
        InputValue=EnterText(allocationRank,10);
        HelpersMethod.EnterText(driver,allocationRank,1000,InputValue);
        scenario.log("ALLOCATION RANK ENTERED IS "+HelpersMethod.JSGetValueEle(driver,firstName,1000));
    }
    public void allocationFactor()
    {
        InputValue=EnterText(allocationFactor,10);
        HelpersMethod.EnterText(driver,allocationFactor,1000,InputValue);
        scenario.log("FIRST NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,allocationFactor,1000));
    }

    public void backOrderDropDown()
    {
        HelpersMethod.ClickBut(driver,backOrderDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM BACK ORDER CANCEL DROP DOWN IS "+backOrderDropDown.getText());
    }
    public void standardOrderDropDown()
    {
        HelpersMethod.ClickBut(driver,standardOrderDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SALES REP DROP DOWN IS "+standardOrderDropDown.getText());
    }
    public void salesHoldDropDown()
    {
        HelpersMethod.ClickBut(driver,salesHoldDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SALES REP DROP DOWN IS "+salesHoldDropDown.getText());
    }
}
