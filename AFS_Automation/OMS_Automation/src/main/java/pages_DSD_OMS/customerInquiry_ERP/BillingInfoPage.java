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

public class BillingInfoPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue;

    @FindBy(id="CmInvoiceCopies")
    private WebElement invoiceCopy;

    @FindBy(id="CmSalesTaxCode")
    private WebElement salesTaxCodeDropDown;

    @FindBy(id="CmLegalName")
    private WebElement legalName;

    @FindBy(id="CmDBAName")
    private WebElement dBName;

    @FindBy(id="CmDAndB")
    private WebElement dunBrand;

    @FindBy(id="CmDAndBRating")
    private WebElement dBRating;

    @FindBy(id="CmBillToAdd1")
    private WebElement address1;

    @FindBy(id="CmBillToAdd2")
    private WebElement address2;

    @FindBy(id="CmBillToAdd3")
    private WebElement address3;

    @FindBy(id="CmBillToAdd4")
    private WebElement address4;

    @FindBy(id="CmBillToName")
    private WebElement billToName;

    @FindBy(id="CmBillToCity")
    private WebElement billToCity;

    @FindBy(id="CmBillToCntry")
    private WebElement billToCountryDropDown;

    @FindBy(id="CmBillToZip")
    private WebElement billToZip;

    @FindBy(id="CmBillToState")
    private WebElement billToStateDropDown;

    @FindBy(id="CmBillToTel")
    private WebElement billToTele;

    @FindBy(id="CmBillToFax")
    private WebElement billToFax;

    public BillingInfoPage(WebDriver driver,Scenario scenario)
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
            HelpersMethod.EnterText(driver,WebEle,1000, RandomValues.generateRandomNumber(length));
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
            HelpersMethod.EnterText(driver,WebEle,1000, RandomValues.generateRandomString(length));
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

    public void InvoiceCopy()
    {
        InputValue=EnterNumber(invoiceCopy,5);
        HelpersMethod.EnterText(driver,billToZip,1000,InputValue);
        scenario.log("INVOICE COPY ENTERED IS "+HelpersMethod.JSGetValueEle(driver,billToZip,1000));
    }

    public void salesTaxCodeDropDown()
    {
        HelpersMethod.ClickBut(driver,salesTaxCodeDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SALES TAX DROP DOWN IS "+salesTaxCodeDropDown.getText());
    }

    public void legalName()
    {
        InputValue=EnterText(legalName,10);
        HelpersMethod.EnterText(driver,legalName,1000,InputValue);
        scenario.log("LEGAL NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,legalName,1000));
    }

    public void DBAName()
    {
        InputValue=EnterText(dBName,10);
        HelpersMethod.EnterText(driver,dBName,1000,InputValue);
        scenario.log("DB NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,dBName,1000));
    }
    public void DunAndBrandStreet()
    {
        InputValue=EnterText(dunBrand,10);
        HelpersMethod.EnterText(driver,dunBrand,1000,InputValue);
        scenario.log("DUN AND BRAND STREET ENTERED IS "+HelpersMethod.JSGetValueEle(driver,dunBrand,1000));
    }

    public void DAndBRating()
    {
    InputValue=EnterNumber(dBRating,1);
    HelpersMethod.EnterText(driver,dBRating,1000,InputValue);
    scenario.log("DB RATING ENTERED IS "+HelpersMethod.JSGetValueEle(driver,dBRating,1000));
    }

    public void address1()
    {
        InputValue=EnterText(address1,20);
        HelpersMethod.EnterText(driver,address1,1000,InputValue);
        scenario.log("ADDRESS1 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,address1,1000));
    }
    public void address2()
    {
        InputValue=EnterText(address2,20);
        HelpersMethod.EnterText(driver,address2,1000,InputValue);
        scenario.log("ADDRESS2 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,address2,1000));
    }
    public void address3()
    {
        InputValue=EnterText(address3,20);
        HelpersMethod.EnterText(driver,address3,1000,InputValue);
        scenario.log("ADDRESS3 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,address3,1000));
    }
    public void address4()
    {
        InputValue=EnterText(address4,20);
        HelpersMethod.EnterText(driver,address4,1000,InputValue);
        scenario.log("ADDRESS4 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,address4,1000));
    }
    public void billingCompany()
    {
        InputValue=EnterText(billToName,10);
        HelpersMethod.EnterText(driver,billToName,1000,InputValue);
        scenario.log("ADDRESS2 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,billToName,1000));
    }
    public void billingCity()
    {
        InputValue=EnterText(billToCity,20);
        HelpersMethod.EnterText(driver,billToCity,1000,InputValue);
        scenario.log("ADDRESS2 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,billToCity,1000));
    }

    public void billToCountryDropDown()
    {
        HelpersMethod.ClickBut(driver,billToCountryDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM BILL TO COUNTRY DROP DOWN IS "+billToCountryDropDown.getText());
    }
    public void zipCode()
    {
        HelpersMethod.clearText(driver,billToZip,1000);
        HelpersMethod.EnterText(driver,billToZip,1000,RandomValues.generateRandomNumber(12));
        scenario.log("ZIP NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,billToZip,1000));
    }
    public void billToStateDropDown()
    {
        HelpersMethod.ClickBut(driver,billToStateDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SALES TAX DROP DOWN IS "+billToStateDropDown.getText());
    }

    public void phoneNumber()
    {
        InputValue=EnterNumber(billToTele,10);
        HelpersMethod.EnterText(driver,billToTele,1000,InputValue);
        scenario.log("TELEPHONE NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,billToTele,1000));
    }
    public void faxNumber()
    {
        InputValue=EnterNumber(billToFax,10);
        HelpersMethod.EnterText(driver,billToFax,1000,InputValue);
        scenario.log("FAX NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,billToFax,1000));
    }
}
