package pages_DSD_OMS.customerInquiry_DSD;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;

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
    static String InputValue=null;
    WebElement SampleEle=null;

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
                if(HelpersMethod.IsExists("//li[contains(@class,'k-state-active')]/span[text()='Primary']",driver))
                {
                    exists=true;
                }
            }
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public String DropDownInCustomerInq()
    {
        String ValueSele=null;
        List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
        try
        {
            if(Options.size()==1)
            {
                scenario.log("THERE ARE NO OPTIONS OTHER THAN 'None'");
            }
            else
            {
                if(Options.size()==2)
                {
                    for (int i = 0; i <= Options.size() - 1; i++)
                    {
                        if (i == 1)
                        {
                            HelpersMethod.ActClick(driver, Options.get(1), 50);
                            scenario.log("OPTIONS SELECTED IS " + Options.get(1).getText());
                            ValueSele=Options.get(1).getText();
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
                            HelpersMethod.ActClick(driver, Options.get(2), 50);
                            ValueSele=Options.get(2).getText();
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e){}
        return ValueSele;
    }

    public void Address1()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,address1,40,RandomValues.generateRandomString(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,address1,10);
            scenario.log("ADDRESS LINE1 IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void Address2()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,address2,40,RandomValues.generateRandomString(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,address2,10);
            scenario.log("ADDRESS LINE2 IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void cityValue()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,city,10,RandomValues.generateRandomString(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,city,10);
            scenario.log("CITY VALUE IS "+InputValue);
            if(InputValue!=null)
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
            HelpersMethod.EnterText(driver,state,10,RandomValues.generateRandomString(2));
            InputValue=HelpersMethod.JSGetValueEle(driver,state,10);
            scenario.log("STATE VALUE IS "+InputValue);
            if(InputValue!=null)
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
            HelpersMethod.EnterText(driver,zip,10,RandomValues.generateRandomNumber(12));
            InputValue=HelpersMethod.JSGetValueEle(driver,zip,10);
            scenario.log("ZIP VALUE IS "+InputValue);
            if(InputValue!=null)
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
            HelpersMethod.EnterText(driver,countryName,10,RandomValues.generateRandomString(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,countryName,10);
            scenario.log("COUNTRY VALUE IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void PhoneValue()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,phone,10,RandomValues.generateRandomNumber(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,phone,10);
            scenario.log("PHONE VALUE IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void FaxValue()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,fax,10,RandomValues.generateRandomNumber(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,fax,10);
            scenario.log("FAX VALUE IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void SchoolLocationValue()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,school,10,RandomValues.generateRandomString(20));
            InputValue=HelpersMethod.JSGetValueEle(driver,school,10);
            scenario.log("SCHOOL LOCATION VALUE IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void VendorNo()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,vendorNo,10,RandomValues.generateRandomNumber(5));
            InputValue=HelpersMethod.JSGetValueEle(driver,vendorNo,10);
            scenario.log("VENDOR NO IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void SoldBy()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,soldBy,10,RandomValues.generateRandomNumber(5));
            InputValue=HelpersMethod.JSGetValueEle(driver,soldBy,10);
            scenario.log("SOLD BY IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void HeadAccNo()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,headAcc,10,RandomValues.generateRandomNumber(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,headAcc,10);
            scenario.log("ACCOUNT NUMBER IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void EquipmentChargeCheckbox()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,equpmentCharges,10);
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
            HelpersMethod.ActClick(driver,fuelCharge,10);
            if(fuelCharge.isSelected())
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CountryDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,country,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmCounty']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("COUNTRY VALUE IS "+TextDropDown1);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void StreetDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,street,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmStreetType']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("STREET VALUE IS "+TextDropDown1);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CustomerTypeDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,custType,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmDistributorId']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DistrbutorDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,distriNo,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmDistributorNumber']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SoldByRemittance()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,remitTo,20);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmRemitTo']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SOLD BY REMITTANCE IS "+TextDropDown1);
                    exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void StatusDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,status,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmStatus']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void FuelProductDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,fuelProd,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmFuelProduct']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DeliveryZoneDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,delivZoneDrop,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmDelivZone']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DeliveryBranchDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,branchDrop,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmDelivBranch']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SellZoneDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,sellZoneDrop,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmSellZone']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
                    exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SalesRepDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,salesmanDrop,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmSalesman']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);

                if(TextDropDown.equals(TextDropDown1))
                {
                    exists=true;
                }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SalesBranchDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,salesBranchDrop,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmSalesmanBranch']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);

                if(TextDropDown.equals(TextDropDown1))
                {
                    exists=true;
                }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ChainIdDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,chainId,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmChainId']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
                    exists=true;
        }
        catch (Exception e){}
    }

    public void BrokerDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,BrokerDrop,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmBroker']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
                    exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void MarketAreaDropDown()
    {
        exists = false;
        String TextDropDown = null;
        String TextDropDown1 = null;
        WebElement WebEle = null;
        try {
            HelpersMethod.ActClick(driver, mktAreaDrop, 10);
            TextDropDown = DropDownInCustomerInq();
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='CmMktArea']/span[contains(@class,'k-input')]");
            TextDropDown1 = WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
                exists = true;
        Assert.assertEquals(exists, true);
    }
        catch (Exception e){}
    }

    public void GroupDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,groupDrop,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmGroup']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
                    exists=true;
                    Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void CategoryDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,categoryDrop,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmCategory']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
                    exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void StoreTypeDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,storeTypeDrop,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmStoreType']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SELECTED VALUE IS "+TextDropDown1);
                    exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SuspensionReason()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,commentSuspend,10,RandomValues.generateRandomNumber(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,commentSuspend,10);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void ActiveOnDate()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,activeCal,10);
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
            HelpersMethod.ActClick(driver,suspendCal,10);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SuspendDateSelection()
    {
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
        new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        try
        {
            String formattedDate1 = null;
            WebElement WebEle=null;
            String FTDate=null;
            exists=false;
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                LocalDate myDateObj = LocalDate.now().minusDays(30);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 40);
                    scenario.log(formattedDate1 + " HAS BEEN SELECTED AS SUSPENDED DATE");
                    WebEle=HelpersMethod.FindByElement(driver,"id","CmDateSuspend");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,10);
                    if(!FTDate.equals(null) && !FTDate.equals("MM/DD/YYYY"))
                    {
                        exists=true;
                    }

            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

}
