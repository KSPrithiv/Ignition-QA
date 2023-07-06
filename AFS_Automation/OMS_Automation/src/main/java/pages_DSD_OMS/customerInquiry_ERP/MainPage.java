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
public class MainPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;

    @FindBy(id="CmFirstName")
    private WebElement FName;

    @FindBy(id="CmLastName")
    private WebElement LName;

    @FindBy(id="CmStoreNumber")
    private WebElement storeNumber;

    @FindBy(id="CmLookupInfo")
    private WebElement lookUpInfo;

    @FindBy(id="CmAdd1")
    private WebElement address1;

    @FindBy(id="CmAdd2")
    private WebElement address2;

    @FindBy(id="CmCity")
    private WebElement cityName;

    @FindBy(id="CmCntry")
    private WebElement countryDropDown;

    @FindBy(id="CmZip")
    private WebElement zipNumber;

    @FindBy(id="CmState")
    private WebElement stateDropDown;

    @FindBy(id="CmGenlTel")
    private WebElement teleNumber;

    @FindBy(id="CmGenlFax")
    private WebElement faxNumber;

    @FindBy(id="CmGenlEmail")
    private WebElement emailId;

    @FindBy(id="CmGenlWebsite")
    private WebElement websiteId;

    @FindBy(id="CmLangCode")
    private WebElement languageDropDown;

    @FindBy(id="CmVendorNumber")
    private WebElement vendorDropDown;

    @FindBy(id="CMPrimaryContactName")
    private WebElement primaryContactName;

    @FindBy(id="CMPrimaryContactTitle")
    private WebElement primaryContactTitle;

    @FindBy(id="CMPrimaryContactPhone")
    private WebElement primaryPhone;

    @FindBy(id="CMPrimaryContactEmail")
    private WebElement primaryEmail;

    //Actions
    public MainPage(WebDriver driver,Scenario scenario)
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
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10);

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

    public void countryDropDown()
    {
       HelpersMethod.ClickBut(driver,countryDropDown,40);
       selectDropDownValue();
       scenario.log("VALUE SELECTED FROM COUNTY DROP DOWN IS "+countryDropDown.getText());
    }

    public void stateDropDown()
    {
        HelpersMethod.ClickBut(driver,stateDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM STATE DROP DOWN IS "+stateDropDown.getText());
    }

    public void languageDropDown()
    {
        HelpersMethod.ClickBut(driver,languageDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM LANGUAGE DROP DOWN IS "+languageDropDown.getText());
    }

    public void vendorDropDown()
    {
        HelpersMethod.ClickBut(driver,vendorDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM VENDOR DROP DOWN IS "+vendorDropDown.getText());
    }

    public void firstNameEntry()
    {
        InputValue=EnterText(FName,10);
        HelpersMethod.EnterText(driver,FName,80,InputValue);
        scenario.log("FIRST NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,FName,10));
    }
    public void lastNameEntry()
    {
        InputValue=EnterText(LName,10);
        HelpersMethod.EnterText(driver,LName,10,InputValue);
        scenario.log("LAST NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,LName,10));
    }
    public void storeNumberEntry()
    {
        InputValue= EnterNumber(storeNumber,10);
        HelpersMethod.EnterText(driver,storeNumber,10,InputValue);
        scenario.log("STORE NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,storeNumber,10));
    }
    public void lookupInformation()
    {
        InputValue=EnterText(lookUpInfo,10);
        HelpersMethod.EnterText(driver,lookUpInfo,10,InputValue);
        scenario.log("LOOK UP INFORMATION ENTERED IS "+HelpersMethod.JSGetValueEle(driver,lookUpInfo,10));
    }
    public void address1()
    {
        InputValue=EnterText(address1,20);
        HelpersMethod.EnterText(driver,address1,10,InputValue);
        scenario.log("ADDRESS1 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,address1,10));
    }
    public void address2()
    {
        InputValue=EnterText(address2,20);
        HelpersMethod.EnterText(driver,address2,10,InputValue);
        scenario.log("ADDRESS2 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,address2,10));
    }
    public void cityName()
    {
        InputValue=EnterText(cityName,20);
        HelpersMethod.EnterText(driver,cityName,10,InputValue);
        scenario.log("CITY NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,cityName,10));
    }
    public void zipCode()
    {
        InputValue=EnterNumber(zipNumber,10);
        HelpersMethod.EnterText(driver,zipNumber,10,InputValue);
        scenario.log("ZIP NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,zipNumber,10));
    }
    public void phoneNumber()
    {
        InputValue=EnterNumber(teleNumber,10);
        HelpersMethod.EnterText(driver,teleNumber,10,InputValue);
        scenario.log("TELEPHONE NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,teleNumber,10));
    }
    public void faxNumber()
    {
        InputValue=EnterNumber(faxNumber,10);
        HelpersMethod.EnterText(driver,faxNumber,10,InputValue);
        scenario.log("FAX NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,faxNumber,10));
    }
    public void emailAddress()
    {
        HelpersMethod.EnterText(driver,emailId,10,RandomValues.generateEmail(10));
        scenario.log("EMAIL ADDRESS ENTERED IS "+HelpersMethod.JSGetValueEle(driver,emailId,10));
    }
    public void contactName()
    {
        InputValue=EnterText(primaryContactName,20);
        HelpersMethod.EnterText(driver,primaryContactName,10,InputValue);
        scenario.log("PRIMARY CONTACT NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,primaryContactName,10));
    }
    public void contactTitle()
    {
        InputValue=EnterText(primaryContactTitle,20);
        HelpersMethod.EnterText(driver,primaryContactTitle,10,InputValue);
        scenario.log("PRIMARY CONTACT TITLE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,primaryContactTitle,10));
    }
    public void contactPhone()
    {
        InputValue=EnterNumber(primaryPhone,20);
        HelpersMethod.EnterText(driver,primaryPhone,10,InputValue);
        scenario.log("PRIMARY CONTACT NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,primaryPhone,10));
    }
    public void primaryEmailAddress()
    {
        HelpersMethod.EnterText(driver,primaryEmail,10,RandomValues.generateEmail(10));
        scenario.log("EMAIL ADDRESS ENTERED IS "+HelpersMethod.JSGetValueEle(driver,primaryEmail,10));
    }
    public void websiteAddress()
    {
        HelpersMethod.EnterText(driver,websiteId,10,RandomValues.generateWebsite(20));
        scenario.log("WEB SITE NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,websiteId,10));
    }
}
