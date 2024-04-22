package pages_DSD_OMS.customerInquiry_DSD;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import lombok.experimental.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;

import java.util.List;
import java.util.Random;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class PricePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue;

    @FindBy(id="CmSchHighList")
    private WebElement DefaultList;

    @FindBy(id="CmSchBasePrc")
    private WebElement BasePrice;

    @FindBy(id="CmSchRetail")
    private WebElement RetailPrice;

    @FindBy(id="CmSchCRebate")
    private WebElement Distributor;

    @FindBy(id="CmSchSRebate")
    private WebElement StoreRebate;

    @FindBy(id="CmSchVolumeDisc")
    private WebElement VolumeDis;

    @FindBy(id="CmSchBDisc")
    private WebElement BillingDis;

    @FindBy(id="CmSchTDisc")
    private WebElement TicketDis;

    @FindBy(id="CmSchTickAlt")
    private WebElement DistributorDis;

    @FindBy(id="CmSchPromo")
    private WebElement Promotion;

    @FindBy(id="CmSchProdCost")
    private WebElement ProductCost;

    @FindBy(id="CmSchProdFloorCost")
    private WebElement ProductFloor;

    @FindBy(id="CmSchContrPrc")
    private WebElement ContractPrice;

    @FindBy(id="CmSchDrvComm")
    private WebElement Driver;

    @FindBy(id="CmSchOverride")
    private WebElement DriverOverShort;

    @FindBy(id="CmSchBrokerComm")
    private WebElement Broker;

    @FindBy(id="CmSchSalesComm")
    private WebElement SalesRep;

    @FindBy(id="CmPrintPriceListFlag")
    private WebElement Printed;

    @FindBy(id="CmEmailPriceListFlag")
    private WebElement Emailed;

    @FindBy(id="CmEmailGroup")
    private WebElement EmailGroup;

    @FindBy(id="CmEmail3")
    private WebElement PrimaryEmail;

    @FindBy(id="CmEmail4")
    private WebElement SecondaryEmail;

    @FindBy(id="CmPercentDiscount")
    private WebElement DiscPercent;

    @FindBy(id="CmChrgbckPct")
    private WebElement ChargePercent;

    @FindBy(id="CmPercentFinanceCharge")
    private WebElement FincancePercent;

    @FindBy(id="CmNumOfDaysHistPricing")
    private WebElement ReturnDays;

    @FindBy(id="CmHaulRate")
    private WebElement HaulingRate;

    @FindBy(id="CmAllowPrcChg")
    private WebElement SalesCredit;

    @FindBy(id="CmPromoOverriddenFlag")
    private WebElement PromotionOverride;

    @FindBy(id="CmAllowRetailChg")
    private WebElement ChargeRetail;

    @FindBy(id="GroupSuppressPrice0Brand")
    private WebElement Brand;

    @FindBy(id="GroupSuppressPrice1Cake")
    private WebElement Cake;

    @FindBy(id="GroupSuppressPrice2Private")
    private WebElement PrivateLabel;

    @FindBy(id="GroupSuppressPrice3Deli")
    private WebElement Deli;

    //Actions
    public PricePage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void ValidatePrice()
    {
        exists=false;
        try
        {
           if(HelpersMethod.IsExists("//p[contains(text(),'Price schedule')]",driver))
           {
               exists=true;
           }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Methods to handle drop down, this is generic method for all drop down in Account page
    public String ClickOnDropDown(WebElement WebEle, String WebId)
    {
        exists=false;
        String TextDropDown=null;
        try
        {
            HelpersMethod.ActClick(driver,WebEle,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='"+WebId+"']/span[contains(@class,'k-input')]");
            InputValue=WebEle.getText();

        }
        catch (Exception e){}
        return InputValue;
    }

    public String DropDownInCustomerInq()
    {
        String ValueSele=null;
        List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
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
                            HelpersMethod.ActClick(driver, Options.get(1), 20);
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
                            HelpersMethod.ActClick(driver, Options.get(2), 20);
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

    //Generic method for check box
    public boolean ClickCheckBox(WebElement WebEle)
    {
        exists=false;
        try
        {
            if(!WebEle.isSelected())
            {
                HelpersMethod.ClickBut(driver, WebEle, 10);
            }
            if(WebEle.isSelected())
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    //Generic method to Enter text
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

    //Generic method for entering amount
    public String EnterAmount(WebElement WebEle,double minInclusive, double maxInclusive, double precision)
    {
        double randomFloat;
        exists=false;

        try
        {
            randomFloat=RandomFloat(minInclusive,maxInclusive,precision);
            HelpersMethod.JSSetValueEle(driver,WebEle,10, String.valueOf(randomFloat));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10);

            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
        return InputValue;
    }

    public double RandomFloat(double minInclusive, double maxInclusive, double precision)
    {
        double randomNum=0.0;
        try
        {
            int max = (int) (maxInclusive / precision);
            int min = (int) (minInclusive / precision);
            Random rand = new Random();
            int randomInt = rand.nextInt((max - min) + 1) + min;
            randomNum = randomInt * precision;
        }
        catch (Exception e){}
        return randomNum;
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

    public void DefaultListDropDown()
    {
        InputValue=ClickOnDropDown(DefaultList,"CmSchHighList");
        scenario.log("DEFAULT LIST DROP DOWN VALUE "+InputValue);
    }

    public void BasePriceDropDown()
    {
        HelpersMethod.ScrollElement(driver,BasePrice);
        InputValue=ClickOnDropDown(BasePrice,"CmSchBasePrc");
        scenario.log("BEST PRICE DROP DOWN VALUE "+InputValue);
    }

    public void RetailPriceDropDown()
    {
        InputValue=ClickOnDropDown(RetailPrice,"CmSchRetail");
        scenario.log("RETAIL PRICE DROP DOWN VALUE "+InputValue);
    }

    public void DistributorPartnerDropDown()
    {
        InputValue=ClickOnDropDown(Distributor,"CmSchCRebate");
        scenario.log("DISTRIBUTOR PARTNER DROP DOWN VALUE "+InputValue);
    }

    public void StoreRebateDropDown()
    {
        InputValue=ClickOnDropDown(StoreRebate,"CmSchSRebate");
        scenario.log("STORE REBATE DROP DOWN VALUE "+InputValue);
    }

    public void VolumeDiscountDropDown()
    {
        InputValue=ClickOnDropDown(VolumeDis,"CmSchVolumeDisc");
        scenario.log("VOLUBE DISCOUNT DROP DOWN VALUE "+InputValue);
    }

    public void BillingDiscountDropDown()
    {
        InputValue=ClickOnDropDown(BillingDis,"CmSchBDisc");
        scenario.log("BILLING DISCOUNT DROP DOWN VALUE "+InputValue);
    }

    public void TicketDiscountDropDown()
    {
        InputValue=ClickOnDropDown(TicketDis,"CmSchTDisc");
        scenario.log("TICKET DISCOUNT DROP DOWN VALUE "+InputValue);
    }

    public void DistributorDiscountDropDown()
    {
        InputValue=ClickOnDropDown(DistributorDis,"CmSchTickAlt");
        scenario.log("DISTRIBUTOR DISCOUNT DROP DOWN VALUE "+InputValue);
    }

    public void PromotionDropDown()
    {
        InputValue=ClickOnDropDown(Promotion,"CmSchPromo");
        scenario.log("PROMOTION DROP DOWN VALUE "+InputValue);
    }

    public void ProductCostDropDown()
    {
        InputValue=ClickOnDropDown(ProductCost,"CmSchProdCost");
        scenario.log("PRODUCT COST DROP DOWN VALUE "+InputValue);
    }

    public void ProductFloorCostDropDown()
    {
        InputValue=ClickOnDropDown(ProductFloor,"CmSchProdFloorCost");
        scenario.log("PRODUCT FLOOR COST DROP DOWN VALUE "+InputValue);
    }

    public void ContractPriceDropDown()
    {
        HelpersMethod.ScrollElement(driver,ContractPrice);
        InputValue=ClickOnDropDown(ContractPrice,"CmSchContrPrc");
        scenario.log("CONTRACT PRICE DROP DOWN VALUE "+InputValue);
    }

    public void DriverDropDown()
    {
        InputValue=ClickOnDropDown(Driver,"CmSchDrvComm");
        scenario.log("DRIVER DROP DOWN VALUE "+InputValue);
    }

    public void DriverOverShortDropDown()
    {
        InputValue=ClickOnDropDown(DriverOverShort,"CmSchOverride");
        scenario.log("DRIVER OVER SHORT DROP DOWN VALUE "+InputValue);
    }

    public void BrokerDropDown()
    {
        InputValue=ClickOnDropDown(Broker,"CmSchBrokerComm");
        scenario.log("BROKER DROP DOWN VALUE "+InputValue);
    }

    public void SalesRepDropDown()
    {
        InputValue=ClickOnDropDown(SalesRep,"CmSchSalesComm");
        scenario.log("SALES REP DROP DOWN VALUE "+InputValue);
    }

    public void PrintedCheckBox()
    {
        ClickCheckBox(Printed);
        scenario.log("DELIVERY OPTIONS PRINTED CHECK BOX SELECTED");
    }

    public void EmailedCheckBox()
    {
        ClickCheckBox(Emailed);
        scenario.log("DELIVERY OPTIONS EMAILED CHECK BOX SELECTED");
    }

    public void EmailGroupDropDown()
    {
        InputValue=ClickOnDropDown(EmailGroup,"CmEmailGroup");
        scenario.log("EMAIL GROUP DROP DOWN VALUE "+InputValue);
    }

    public void PrimaryEmailInput()
    {
        InputValue=RandomValues.generateEmail(10);
        scenario.log("PRIMARY EMAIL ENTERED IS "+InputValue);
    }

    public void SecondaryEmailInput()
    {
        InputValue=RandomValues.generateEmail(10);
        scenario.log("SECONDARY EMAIL ENTERED IS "+InputValue);
    }

    public void DiscountPerInput()
    {
        InputValue=EnterNumber(DiscPercent,1);
        scenario.log("DISCOUNT PERCENTAGE ENTERED "+InputValue);
    }

    public void ChargebackPerInput()
    {
        InputValue=EnterNumber(ChargePercent,1);
        scenario.log("CHARGE BACK PERCENTAGE "+InputValue);
    }

    public void FinanceChargeInput()
    {
        InputValue=EnterNumber(FincancePercent,1);
        scenario.log("FINANCE CHARGE PERCENTAGE "+InputValue);
    }

    public void ReturnDaysInput()
    {
        InputValue=EnterNumber(ReturnDays,1);
        scenario.log("NUMBER OF RETURN DAYS "+InputValue);
    }

    public void HaulingRateInput()
    {
        InputValue=EnterNumber(HaulingRate,1);
        scenario.log("HAULING RATE INPUT "+InputValue);
    }

    public void SalesCreditDropDown()
    {
        InputValue=ClickOnDropDown(SalesCredit,"CmAllowPrcChg");
        scenario.log("SALES CREDIT DROP DOWN VALUE "+InputValue);
    }

    public void PromotionOverrideDropDown()
    {
        InputValue=ClickOnDropDown(PromotionOverride,"CmPromoOverriddenFlag");
        scenario.log("PROMOTION OVERRIDE DROP DOWN VALUE "+InputValue);
    }

    public void ChangeRetailDropDown()
    {
        InputValue=ClickOnDropDown(ChargeRetail,"CmAllowRetailChg");
        scenario.log("CHANGE RETAIL DROP DOWN VALUE "+InputValue);
    }

    public void BrandCheckbox()
    {
        ClickCheckBox(Brand);
        scenario.log("BRAND CHECKBOX SELECTED");
    }

    public void CakeCheckbox()
    {
        ClickCheckBox(Cake);
        scenario.log("CAKE CHECKBOX SELECTED");
    }

    public void PrivateLabelCheckBox()
    {
        ClickCheckBox(PrivateLabel);
        scenario.log("PRIVATE LABEL CHECKBOX SELECTED");
    }

    public void DeliCheckbox()
    {
        ClickCheckBox(Deli);
        scenario.log("DELI CHECKBOX SELECTED");
    }
}
