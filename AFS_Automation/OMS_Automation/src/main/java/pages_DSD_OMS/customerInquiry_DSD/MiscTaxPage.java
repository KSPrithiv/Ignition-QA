package pages_DSD_OMS.customerInquiry_DSD;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.RandomValues;

import java.util.List;
import java.util.Random;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class MiscTaxPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue;

    @FindBy(id="CmCustSubType")
    private WebElement SubType;

    @FindBy(id="CmFedTaxId")
    private WebElement FedTax;

    @FindBy(id="CmNonFoodTaxPercent")
    private WebElement FoodTax;

    @FindBy(id="CmTaxCode")
    private WebElement TaxCode;

    @FindBy(id="CmTaxPercent")
    private WebElement TaxPercent;

    @FindBy(id="CmTax2Code")
    private WebElement Tax2Code;

    @FindBy(id="CmTaxPercent2")
    private WebElement Tax2Percent;

    @FindBy(id="CmTax3Code")
    private WebElement Tax3Code;

    @FindBy(id="CmTaxPercent3")
    private WebElement Tax3Percent;

    @FindBy(id="CmThirdPartyPayeeNo")
    private WebElement ThirdParty;

    @FindBy(id="CmSpoilPercent")
    private  WebElement SpoilPercent;

    @FindBy(id="CmPathmarkSeqNo")
    private WebElement PathMark;

    @FindBy(id="CmBottleDepositFlag")
    private WebElement BottleDeposit;

    @FindBy(id="CmLoyaltyProgram")
    private WebElement Loyalty;

    @FindBy(id="CmFoodDollarBalance")
    private WebElement LoyaltyBal;

    @FindBy(id="CmReference1")
    private WebElement Refernce1;

    @FindBy(id="CmReference2")
    private WebElement Reference2;

    //Actions
    public MiscTaxPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void ValidateMiscTax()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//p[contains(text(),'Inventory required')]",driver))
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
        String TextDropDown;
        try
        {
            HelpersMethod.ActClick(driver,WebEle,10000);
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
        List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
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
                            HelpersMethod.ActClick(driver, Options.get(1), 10000);
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
                            HelpersMethod.ActClick(driver, Options.get(2), 10000);
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
                HelpersMethod.ActClick(driver, WebEle, 10000);
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
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10000);

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
            HelpersMethod.JSSetValueEle(driver,WebEle,10000, String.valueOf(randomFloat));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10000);

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
            HelpersMethod.EnterText(driver,WebEle,10000,RandomValues.generateRandomNumber(length));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10000);

            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
        return InputValue;
    }

    public void InventoryRequiredCheckbox()
    {
        try
        {
            List<WebElement> CheckBoxes = HelpersMethod.FindByElements(driver, "xpath", "//input[contains(@id,'InvReq')]");
            for (WebElement CheckBox : CheckBoxes)
            {
                HelpersMethod.ClickBut(driver, CheckBox, 10000);
            }
        }
        catch (Exception e){}
    }

    public void SubTypeDropDown()
    {
        InputValue=ClickOnDropDown(SubType,"CmCustSubType");
        scenario.log("SUB TYPE DROP DOWN VALUE "+InputValue);
    }

    public void FedTaxInputBox()
    {
        InputValue=EnterNumber(FedTax,10);
        scenario.log("FEDERAL TAX ID VALUE ENTERED IS "+InputValue);
    }

    public void NonFoodTaxInputBox()
    {
        InputValue=EnterAmount(FoodTax,1,9,2);
        scenario.log("NON FOOD TAX PERCENTAGE IS "+InputValue);
    }

    public void TaxCode1DropDown()
    {
        InputValue=ClickOnDropDown(TaxCode,"CmTaxCode");
        scenario.log("TAX CODE 1 DROP DOWN VALUE "+InputValue);
    }

    public void TaxPercentage1InputBox()
    {
            InputValue=EnterAmount(TaxPercent,1,9,2);
            scenario.log("TAX PERCENTAGE 1 IS "+InputValue);
    }

    public void TaxCode2DropDown()
    {
        InputValue=ClickOnDropDown(Tax2Code,"CmTax2Code");
        scenario.log("TAX CODE 2 DROP DOWN VALUE "+InputValue);
    }

    public void TaxPercentage2InputBox()
    {
        InputValue=EnterAmount(Tax2Percent,1,9,2);
        scenario.log("TAX PERCENTAGE 2 IS "+InputValue);
    }

    public void TaxCode3DropDown()
    {
        InputValue=ClickOnDropDown(Tax3Code,"CmTax3Code");
        scenario.log("TAX CODE 3 DROP DOWN VALUE "+InputValue);
    }

    public void TaxPercentage3InputBox()
    {
        InputValue=EnterAmount(Tax3Percent,1,9,2);
        scenario.log("TAX PERCENTAGE 3 IS "+InputValue);
    }

    public void PartyPayeeNo()
    {
        InputValue=EnterNumber(ThirdParty,10);
        scenario.log("THIRD PARTY PAYEE NO "+InputValue);
    }

    public void SpoilInputBox()
    {
        InputValue=EnterAmount(SpoilPercent,1,9,2);
        scenario.log("SPOIL PERCENT IS "+InputValue);
    }

    public void PathMarkDropDown()
    {
        HelpersMethod.ScrollElement(driver,PathMark);
        InputValue=ClickOnDropDown(PathMark,"CmPathmarkSeqNo");
        scenario.log("PATH MARK SEQUENCE# DROP DOWN VALUE "+InputValue);
    }

    public void ContainerDropDown()
    {
        InputValue=ClickOnDropDown(BottleDeposit,"CmBottleDepositFlag");
        scenario.log("CONTAINER DEPOSIT DROP DOWN VALUE "+InputValue);
    }

    public void LoyaltyDropDown()
    {
        InputValue=ClickOnDropDown(Loyalty,"CmLoyaltyProgram");
        scenario.log("LOYALTY PROGRAM DROP DOWN VALUE "+InputValue);
    }

    public void LoyaltyInputBox()
    {
        InputValue=EnterNumber(LoyaltyBal,6);
        scenario.log("LOYALTY BALANCE VALUE "+InputValue);
    }

    public void Reference1InputBox()
    {
        InputValue=EnterText(Refernce1,10);
        scenario.log("REFERENCE 1 VALUE "+InputValue);
    }

    public void Reference2InputBox()
    {
        InputValue=EnterText(Reference2,10);
        scenario.log("REFERENCE 2 VALUE "+InputValue);
    }
}
