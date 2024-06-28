package pages_DSD_OMS.customerInquiry_DSD;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class PrimaryPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue;

    @FindBy(id="CmAdd1")
    private WebElement address1;

    @FindBy(id="CmAdd2")
    private WebElement address2;

    @FindBy(id="CmCity")
    private WebElement city;

    @FindBy(id="CmCounty")
    private WebElement country;

    @FindBy(id="CmState")
    private WebElement state;

    @FindBy(id="CmZip")
    private WebElement zip;

    @FindBy(id="CmCntry")
    private WebElement countryName;

    @FindBy(id="CmGenlTel")
    private WebElement phone;

    @FindBy(id="CmGenlFax")
    private WebElement fax;

    @FindBy(id="CmSchoolLocation")
    private WebElement school;

    @FindBy(id="CmStreetType")
    private WebElement street;

    @FindBy(id="CmDistributorId")
    private WebElement custType;

    @FindBy(id="CmDistributorNumber")
    private WebElement distriNo;

    @FindBy(id="CmVendorNumber")
    private WebElement vendorNo;

    @FindBy(id="CmOwner")
    private WebElement soldBy;

    @FindBy(id="CmRemitTo")
    private WebElement remitTo;

    @FindBy(id="CmHead")
    private WebElement headAcc;

    @FindBy(id="CmStatus")
    private WebElement status;

    @FindBy(xpath="//input[@id='CmDateSuspend']/ancestor::span[contains(@class,'k-widget k-dateinput')]/following-sibling::a")
    private WebElement suspendCal;

    @FindBy(xpath="//input[@id='CmDateReinstate']/ancestor::span[contains(@class,'k-widget k-dateinput')]/following-sibling::a")
    private WebElement activeCal;

    @FindBy(id="CmReasonSuspend")
    private WebElement commentSuspend;

    @FindBy(id="CmEquipmentChargeFlag")
    private WebElement equpmentCharges;

    @FindBy(id="CmFuelCharge")
    private WebElement fuelCharge;

    @FindBy(id="CmFuelProduct")
    private WebElement fuelProd;

    @FindBy(id="CmDelivZone")
    private  WebElement delivZoneDrop;

    @FindBy(id="CmDelivBranch")
    private WebElement branchDrop;

    @FindBy(id="CmSellZone")
    private WebElement sellZoneDrop;

    @FindBy(id="CmSalesman")
    private WebElement salesmanDrop;

    @FindBy(id="CmSalesmanBranch")
    private WebElement salesBranchDrop;

    @FindBy(id="CmChainId")
    private WebElement chainId;

    @FindBy(id="CmBroker")
    private WebElement BrokerDrop;

    @FindBy(id="CmMktArea")
    private WebElement mktAreaDrop;

    @FindBy(id="CmGroup")
    private WebElement groupDrop;

    @FindBy(id="CmCategory")
    private WebElement categoryDrop;

    @FindBy(id="CmStoreType")
    private WebElement storeTypeDrop;

    //Actions
    public PrimaryPage(WebDriver driver,Scenario scenario)
    {
        this.scenario=scenario;
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void ValidatePrimaryPage()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExistsById("CustomerMasterBottomCard",driver))
            {
                if(HelpersMethod.IsExists("//li[contains(@class,'k-active')]/span[text()='Primary']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
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
        //WebElement dropDownOption=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-list-content']/ul/li/span")));
        List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-list-content']/ul/li/span");
        try
        {
           if(Options.size()==1)
            {
                scenario.log("THERE ARE NO OPTIONS OTHER THAN 'None'");
                HelpersMethod.ActClick(driver, Options.get(0), 10000);
            }
            else
            {
                if(Options.size()==2)
                {
                    for (int i = 0; i <= Options.size() - 1; i++)
                    {
                        if (i == 1)
                        {
                            HelpersMethod.ActClick(driver, Options.get(1), 10000);
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
                            HelpersMethod.ActClick(driver, Options.get(2), 1000);
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void Address1()
    {
        exists=false;
        try
        {
            InputValue=EnterText(address1,10);
            HelpersMethod.EnterText(driver,address1,10,InputValue);
            scenario.log("ADDRESS 1 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,address1,10));
        }
        catch (Exception e){}
    }

    public void Address2()
    {
        exists=false;
        try
        {
            InputValue=EnterText(address2,10);
            HelpersMethod.EnterText(driver,address2,10,InputValue);
            scenario.log("ADDRESS 2 ENTERED IS "+HelpersMethod.JSGetValueEle(driver,address2,10));
        }
        catch (Exception e){}
    }

    public void cityValue()
    {
        exists=false;
        try
        {
            InputValue=EnterText(city,10);
            HelpersMethod.EnterText(driver,city,10,InputValue);
            scenario.log("CITY NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,city,10));
        }
        catch (Exception e){}
    }

    public  void countryDropDown()
    {
        HelpersMethod.ClickBut(driver,country,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM COUNTRY DROP DOWN IS "+country.getText());
    }

    public void StateValue()
    {
            InputValue=EnterText(state,10);
            HelpersMethod.EnterText(driver,state,10,InputValue);
            scenario.log("STATE VALUE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,state,10));
    }

    public void ZipValue()
    {
            InputValue=EnterNumber(zip,10);
            HelpersMethod.EnterText(driver,zip,10,InputValue);
            scenario.log("ZIP VALUE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,zip,10));
    }

    public void CountryValue()
    {
            InputValue=EnterText(countryName,10);
            HelpersMethod.EnterText(driver,countryName,10,InputValue);
            scenario.log("COUNTY VALUE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,countryName,10));
    }

    public void PhoneValue()
    {
            InputValue=EnterNumber(phone,10);
            HelpersMethod.EnterText(driver,phone,10,InputValue);
            scenario.log("PHONE VALUE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,phone,10));
    }

    public void FaxValue()
    {
            InputValue=EnterNumber(fax,10);
            HelpersMethod.EnterText(driver,fax,10,InputValue);
            scenario.log("FAX VALUE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,fax,10));
    }

    public void SchoolLocationValue()
    {
            InputValue=EnterText(school,10);
            HelpersMethod.EnterText(driver,school,10,InputValue);
            scenario.log("SCHOOL LOCATION ENTERED IS "+HelpersMethod.JSGetValueEle(driver,school,10));
    }

    public void VendorNo()
    {
            InputValue=RandomValues.generateRandomNumber(10);
            HelpersMethod.EnterText(driver,vendorNo,10,InputValue);
            scenario.log("VENDOR NUMBER ENTERED IS "+HelpersMethod.JSGetValueEle(driver,vendorNo,10));
    }

    public void SoldBy()
    {
            InputValue=EnterText(soldBy,10);
            HelpersMethod.EnterText(driver,soldBy,10,InputValue);
            scenario.log("SOLD BY ENTERED IS "+HelpersMethod.JSGetValueEle(driver,soldBy,10));
    }

    public void HeadAccNo()
    {
            InputValue=RandomValues.generateRandomNumber(10);
            HelpersMethod.EnterText(driver,headAcc,10,InputValue);
            scenario.log("HEAD ACCOUNT ENTERED IS "+HelpersMethod.JSGetValueEle(driver,headAcc,10));
    }

    public void EquipmentChargeCheckbox()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,equpmentCharges,10000);
            if(equpmentCharges.isSelected())
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void FuelChargeCheckbox()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,fuelCharge,10000);
            if(fuelCharge.isSelected())
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CountryDropDown() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,country,10000);
        selectDropDownValue();
        scenario.log("COUNTRY DROP DOWN IS "+country.getText());
    }

    public void StreetDropDown() throws InterruptedException
    {
        HelpersMethod.ScrollElement(driver,street);
        HelpersMethod.ActClick(driver,street,10000);
        selectDropDownValue();
        scenario.log("STREET DROP DOWN IS "+street.getText());
    }

    public void CustomerTypeDropDown() throws InterruptedException
    {
        HelpersMethod.ScrollElement(driver,custType);
        HelpersMethod.ActClick(driver,custType,10000);
        selectDropDownValue();
        scenario.log("CUSTOMER TYPE DROP DOWN IS "+custType.getText());
    }

    public void DistrbutorDropDown() throws InterruptedException
    {
        HelpersMethod.ScrollElement(driver,distriNo);
        HelpersMethod.ActClick(driver,distriNo,10000);
        selectDropDownValue();
        scenario.log("DISTRIBUTOR DROP DOWN IS "+distriNo.getText());
    }

    public void SoldByRemittance() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,soldBy,10000);
        selectDropDownValue();
        scenario.log("SOLD BY DROP DOWN IS "+soldBy.getText());
    }

    public void StatusDropDown() throws InterruptedException
    {
        HelpersMethod.ScrollElement(driver,status);
        HelpersMethod.JScriptClick(driver,status,10000);
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-list-content']/ul/li")));
        List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-list-content']/ul/li");
        String optText;
        Actions act=new Actions(driver);
        for(WebElement opt:Options)
        {
            act.moveToElement(opt).build().perform();
            optText=opt.getText();
            if(optText.equalsIgnoreCase("Active"))
            {
                act.moveToElement(opt).build().perform();
                act.click(opt).build().perform();
                break;
            }
        }
        scenario.log("STATUS DROP DOWN IS "+status.getText());
    }

    public void FuelProductDropDown() throws InterruptedException
    {
        HelpersMethod.ScrollElement(driver,fuelProd);
        HelpersMethod.ActClick(driver,fuelProd,10000);
        selectDropDownValue();
        scenario.log("FUEL PRODUCT DROP DOWN IS "+fuelProd.getText());
    }

    public void DeliveryZoneDropDown() throws InterruptedException
    {
        HelpersMethod.ScrollElement(driver,delivZoneDrop);
        HelpersMethod.ActClick(driver,delivZoneDrop,10000);
        selectDropDownValue();
        scenario.log("DELIVERY ZONE DROP DOWN IS "+delivZoneDrop.getText());
    }

    public void DeliveryBranchDropDown() throws InterruptedException
    {
        HelpersMethod.ScrollElement(driver,branchDrop);
        HelpersMethod.ActClick(driver,branchDrop,10000);
        selectDropDownValue();
        scenario.log("BRANCH DROP DOWN IS "+branchDrop.getText());
    }

    public void SellZoneDropDown() throws InterruptedException
    {
        HelpersMethod.ScrollElement(driver,sellZoneDrop);
        HelpersMethod.ActClick(driver,sellZoneDrop,10000);
        selectDropDownValue();
        scenario.log("SELL ZONE DROP DOWN IS "+sellZoneDrop.getText());
    }

    public void SalesRepDropDown()
    {
        HelpersMethod.ClickBut(driver,salesmanDrop,10000);
        selectDropDownValue();
        scenario.log("SALES MAN DROP DOWN IS "+salesmanDrop.getText());
    }

    public void SalesBranchDropDown()
    {
        HelpersMethod.ClickBut(driver,salesBranchDrop,10000);
        selectDropDownValue();
        scenario.log("SALES BRANCH DROP DOWN IS "+salesBranchDrop.getText());
    }

    public void ChainIdDropDown()
    {
        HelpersMethod.ClickBut(driver,chainId,10000);
        selectDropDownValue();
        scenario.log("CHAIN ID DROP DOWN IS "+chainId.getText());
    }

    public void BrokerDropDown()
    {
        HelpersMethod.ClickBut(driver,BrokerDrop,10000);
        selectDropDownValue();
        scenario.log("BROKER DROP DOWN IS "+BrokerDrop.getText());
    }

    public void MarketAreaDropDown()
    {
        HelpersMethod.ClickBut(driver,mktAreaDrop,10000);
        selectDropDownValue();
        scenario.log("MARKET AREA DROP DOWN IS "+mktAreaDrop.getText());
    }

    public void GroupDropDown()
    {
        HelpersMethod.ClickBut(driver,groupDrop,10000);
        selectDropDownValue();
        scenario.log("GROUP DROP DOWN IS "+groupDrop.getText());
    }

    public void CategoryDropDown()
    {
        HelpersMethod.ClickBut(driver,categoryDrop,10000);
        selectDropDownValue();
        scenario.log("CATEGORY DROP DOWN IS "+categoryDrop.getText());
    }

    public void StoreTypeDropDown()
    {
        HelpersMethod.ClickBut(driver,storeTypeDrop,10000);
        selectDropDownValue();
        scenario.log("STORE TYPE DROP DOWN IS "+storeTypeDrop.getText());
    }

    public void SuspensionReason()
    {
        InputValue=EnterText(commentSuspend,10);
        HelpersMethod.EnterText(driver,commentSuspend,10000,InputValue);
        scenario.log("COMMENT SUSPEND ENTERED IS "+HelpersMethod.JSGetValueEle(driver,commentSuspend,10));
    }

    public void ActiveOnDate()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,activeCal,10000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SuspendOnDate()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,suspendCal,10000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

}
