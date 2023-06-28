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

public class AccountPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;

    @FindBy(id="CmArType")
    private WebElement ARType;

    @FindBy(id="CmGambleCat")
    private  WebElement GLCat;

    @FindBy(id="CmRuleTermsCode")
    private WebElement PayTerm;

    @FindBy(id="CmPaymentType")
    private WebElement PayType;

    @FindBy(id="CmCustChannel")
    private WebElement Channel;

    @FindBy(id="CmMthlyStmtCycle")
    private WebElement MonthState;

    @FindBy(id="CmCreditLimit")
    private WebElement CrLimit;

    @FindBy(id="CmBalance")
    private WebElement BalAmt;

    @FindBy(id="CmBillSeq")
    private WebElement BillSeq;

    @FindBy(id="CmCashDiscountPct")
    private WebElement Dicount;

    @FindBy(id="CmAltStorNo")
    private WebElement AlternateStore;

    @FindBy(id="CmBillable")
    private WebElement Billable;

    @FindBy(id="CmBillingCycle")
    private WebElement BillGroup;

    @FindBy(id="CmBillingPeriod")
    private WebElement BillPeriod;

    @FindBy(id="CmCCRdNo")
    private WebElement CrCard;

    @FindBy(id="CmCCrdExpDate")
    private WebElement CrExpDate;

    @FindBy(id="CmCreditCardflag")
    private WebElement CrCardCust;

    @FindBy(id="CmBillingReportFormat")
    private WebElement BillReport;

    @FindBy(id="CmAdminFee")
    private WebElement AdminFee;

    @FindBy(id="CmArContact")
    private WebElement ARCont;

    @FindBy(id="CmArTelNo")
    private WebElement ARPhone;

    @FindBy(id="CmArFaxNo")
    private WebElement ARFax;

    @FindBy(id="CmContractNumber")
    private WebElement ContrNo;

    @FindBy(id="CmPONumber")
    private WebElement PONo;

    @FindBy(id="CmPONumberRequired")
    private WebElement PoReq;

    @FindBy(id="CmBankName")
    private WebElement BankName;

    @FindBy(id="CmBankBranchName")
    private WebElement BranchName;

    @FindBy(id="CmPayerContact")
    private WebElement PayName;

    @FindBy(id="CmPrintMonthlyBillFlag")
    private WebElement MonthlyStatPrint;

    @FindBy(id="CmEmailMonthlyBillFlag")
    private WebElement EmailMonthBill;

    @FindBy(id="CmPrintWklyBillFlag")
    private WebElement WeeklyStatPrint;

    @FindBy(id="CmEmailWklyBillFlag")
    private WebElement EmailWeeklyBill;

    @FindBy(id="CmEmail")
    private WebElement PrimaryEmail;

    @FindBy(id="CmEmail2")
    private WebElement SecondEmail;

    @FindBy(id="CmAllowHHEmail")
    private WebElement PrintUnit;

    @FindBy(id="CmAllowHHEmail")
    private WebElement AllowHandle;

    @FindBy(id="CmStopSupplyCode")
    private WebElement StopSupply;

    @FindBy(id="CmSalesReturnRestrictionCode")
    private WebElement ReturnRest;

    @FindBy(id="CmHHDefaultDetailScreenOption")
    private WebElement DefaultDetail;

    @FindBy(id="CmEnableAutoPay")
    private WebElement AutoPay;

    @FindBy(id="CmPrintCustLoadRpt")
    private WebElement PrintCust;

    @FindBy(id="CmLeaveDamagedFlag")
    private WebElement CanDamage;

    @FindBy(id="CmSuppresedPriceAllowFlag")
    private WebElement SuppressPrice;

    @FindBy(id="CmBlockUploadFlag")
    private WebElement BlockUpload;

    @FindBy(id="CmGroupSepTkt")
    private WebElement PrintGroup;

    @FindBy(id="CmVendorSplitFlag")
    private WebElement SplitVendor;

    @FindBy(id="CmKeyCarryOver")
    private WebElement CarryOver;

    @FindBy(id="CmAllowStaleCredit")
    private WebElement AllowStaleCr;

    @FindBy(id="CmFullCaseOnlyFlag")
    private WebElement DonotAllow;

    @FindBy(id="CmAllowHHTktFlag")
    private WebElement AllowInvoice;

    //Actions
    public AccountPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Methods to handle drop down, this is generic method for all drop down in Account page
    public String ClickOnDropDown(WebElement WebEle,String WebId)
    {
        exists=false;
        String TextDropDown=null;
        try
        {
            HelpersMethod.ActClick(driver,WebEle,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='"+WebId+"']/span[contains(@class,'k-input')]");
            InputValue=WebEle.getText();
                exists=true;
            Assert.assertEquals(exists,true);
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

    //random number selection in a given range
    public int RandomNumber(int max,int min)
    {
        int randomNum=0;
        try
        {
            randomNum= (int) ((Math.random()*(max - min))+ min);
        }
        catch (Exception e){}
        return randomNum;
    }

    public void ARTypeDropDown()
    {
     InputValue=ClickOnDropDown(ARType,"CmArType");
     scenario.log("AR TYPE VALUE IS "+InputValue);
    }

    public void GLCatDropDown()
    {
        InputValue=ClickOnDropDown(GLCat,"CmGambleCat");
        scenario.log("GL CATEGORY VALUE IS "+InputValue);
    }

    public void PaymentTermDropDown()
    {
        InputValue=ClickOnDropDown(PayTerm,"CmRuleTermsCode");
        scenario.log("PAYMENT TERM VALUE IS "+InputValue);
    }

    public void PaymentTypeDropDown()
    {
        InputValue=ClickOnDropDown(PayType,"CmPaymentType");
        scenario.log("PAYMENT TYPE VALUE IS "+InputValue);
    }

    public void ChannelNoDropDown()
    {
        InputValue=ClickOnDropDown(Channel,"CmCustChannel");
        scenario.log("CHANNEL SELECTED IS "+InputValue);
    }

    public void MonthlyStatementDropDown()
    {
        InputValue=ClickOnDropDown(MonthState,"CmMthlyStmtCycle");
        scenario.log("MONTHLY STATEMENT CYCLE SELESCTED "+InputValue);
    }

    public void CreditLimitAmount()
    {
        InputValue=EnterAmount(CrLimit,1000, 2000, 2);
        scenario.log("CREDIT LIMIT AMOUNT "+InputValue);
    }

    public void BalanceAmount()
    {
        InputValue=EnterAmount(BalAmt,500, 1000, 2);
        scenario.log("CREDIT LIMIT AMOUNT "+InputValue);
    }

    public void BillingSequence()
    {
        InputValue=EnterNumber(BillSeq,8);
        scenario.log("BILLING SEQUENCE "+InputValue);
    }

    public void DiscountAmount()
    {
        InputValue=EnterAmount(BalAmt,50, 200, 2);
        scenario.log("DISCOUNT AMOUNT "+InputValue);
    }

    public void AlternateStoreInput()
    {
        InputValue=EnterNumber(AlternateStore,4);
        scenario.log("ALTERNATE STORE INPUT "+InputValue);
    }

    public void BillableCheckbox()
    {
        InputValue= String.valueOf(ClickCheckBox(Billable));
        scenario.log("STATUS OF BILLABLE CHECKBOX IS "+InputValue);
    }

    public void BillingGroupDropDown()
    {
        InputValue=ClickOnDropDown(BillGroup,"CmBillingCycle");
        scenario.log("BILLING GROUP DROP DOWN IS "+InputValue);
    }

    public void BillingPeriodDropDown()
    {
        InputValue=ClickOnDropDown(BillPeriod,"CmBillingPeriod");
        scenario.log("BILLING PERIOD DROP DOWN IS "+InputValue);
    }

    public void CreditCardInput()
    {
        InputValue=EnterNumber(CrCard,16);
        scenario.log("CREDIT CARD INPUT "+InputValue);
    }

    public void CreditCardExpinput()
    {
        String ExpMonth=null;
        String ExpYear=null;
        String CrExp=null;
        int i;
        i=RandomNumber(1,12);
        if(i>=1 && i<=9)
        {
            ExpMonth = String.format("%02d", i);
        }
        else
        {
            ExpMonth= String.valueOf(i);
        }
        scenario.log("Expire month "+ExpMonth);
        i=RandomNumber(23,55);
        ExpYear= String.valueOf(i);
        ExpMonth= ExpMonth.concat("/");
        CrExp=ExpMonth.concat(ExpYear);
        scenario.log("Cr. card exp "+CrExp);
        HelpersMethod.EnterText(driver,CrExpDate,10, String.valueOf(CrExp));
        scenario.log("CREDIT CARD EXPIRE DATE "+HelpersMethod.JSGetValueEle(driver,CrExpDate,20));
    }

    public void CreditCardCustCheckbox()
    {
        ClickCheckBox(CrCardCust);
        scenario.log("CREDIT CARD CUSTOMER CHECKBOX SELECTED");
    }

    public void BillingPreferenceDropDown()
    {
        InputValue=ClickOnDropDown(BillReport,"CmBillingReportFormat");
        scenario.log("BILLING REPORT PREFERENCE "+InputValue);
    }

    public void AdministrationFeeAmount()
    {
        InputValue=EnterAmount(AdminFee,50, 200, 2);
        scenario.log("ADDMITION FEES "+InputValue);
    }

    public void ARContactInput()
    {
        InputValue=EnterText(ARCont,10);
        HelpersMethod.EnterText(driver,ARCont,10,InputValue);
        scenario.log("AR CONTACT VALUE ENTERED IS "+InputValue);
    }

    public void ARPhoneNoInput()
    {
        InputValue=EnterNumber(ARPhone,10);
        scenario.log("AR PHONE NUMBER INPUT "+InputValue);
    }

    public void ARFaxNoInput()
    {
        InputValue=EnterNumber(ARFax,10);
        scenario.log("FAX NUMBER ENTERED IS "+InputValue);
    }

    public void ContractNoInput()
    {
        InputValue=EnterNumber(ContrNo,10);
        scenario.log("CONTRACT NUMBER INPUT "+InputValue);
    }

    public void PORequiredDropDown()
    {

    }

    public void BankNameInput()
    {
        InputValue=EnterText(BankName,15);
        scenario.log("BANK NAME IS "+InputValue);
    }

    public void BranchNameInput()
    {
        InputValue=EnterText(BranchName,15);
        scenario.log("BRANCH NAME IS "+InputValue);
    }

    public void PayerName()
    {
        InputValue=EnterText(PayName,15);
        scenario.log("PAYER NAME IS "+InputValue);
    }

    public void MonthlyStatePrintCheckbox()
    {
        ClickCheckBox(MonthlyStatPrint);
        scenario.log("MONTHLY STATEMENTS PRINT CHECKBOX SELECTED");
    }

    public void MonthlyStateEmailedCheckbox()
    {
        ClickCheckBox(EmailMonthBill);
        scenario.log("MONTHLY STATEMENTS EMAILED CHECKBOX SELECTED");
    }

    public void WeeklyStatePrintCheckbox()
    {
        ClickCheckBox(WeeklyStatPrint);
        scenario.log("WEEKLY BILLS PRINT CHECKBOX SELECTED");
    }

    public void WeeklyStateEmailedCheckbox()
    {
        ClickCheckBox(EmailWeeklyBill);
        scenario.log("WEEKLY BILLS EMAIL CHECKBOX SELECTED");
    }

    public void PrimaryEmailInput()
    {
        InputValue= RandomValues.generateEmail(10);
        HelpersMethod.EnterText(driver,PrimaryEmail,10, InputValue);
        scenario.log("PRIMARY EMAIL VALUE "+InputValue);
    }

    public void SecondaryEmailInput()
    {
        InputValue= RandomValues.generateEmail(10);
        HelpersMethod.EnterText(driver,SecondEmail,10, InputValue);
        scenario.log("SECONDARY EMAIL VALUE "+InputValue);
    }

    public void PrintUnitCheckbox()
    {
        ClickCheckBox(PrintUnit);
        scenario.log("PRINT UNIT PRICE IN WEEKLY BILLS CHECKBOX CLICKED");
    }

    public void AllowHandledCheckbox()
    {
        ClickCheckBox(AllowHandle);
        scenario.log("ALLOW HANDHELD TO EMAIL DOCUMENTS CHECKBOX CLICKED");
    }

    public void StopSupplyCodeDropDown()
    {
        InputValue=ClickOnDropDown(StopSupply,"CmStopSupplyCode");
        scenario.log("VALUE SELECTED FROM STOP SUPPLY CODE DROP DOWN "+InputValue);
    }

    public void ReturnRestCodeDropDown()
    {
        InputValue=ClickOnDropDown(ReturnRest,"CmSalesReturnRestrictionCode");
        scenario.log("VALUE SELECTED FROM RETURN RESTRICTION CODE DROP DOWN "+InputValue);
    }

    public void DefaultHHDetailDropDown()
    {
        InputValue=ClickOnDropDown(DefaultDetail,"CmHHDefaultDetailScreenOption");
        scenario.log("VALUE SELECTED FROM DEFAULT HH DETAILS SCREEN OPTION CODE DROP DOWN "+InputValue);
    }

    public void AutoPageCustomerDropDown()
    {
        InputValue=ClickOnDropDown(AutoPay,"CmEnableAutoPay");
        scenario.log("VALUE SELECTED FROM AUTO PAY CUSTOMER CODE DROP DOWN "+InputValue);
    }

    public void PrintCustomerLoadCheckbox()
    {
        ClickCheckBox(PrintCust);
        scenario.log("PRINT CUSTOMER LOAD REPORT CHECKBOX CLICKED");
    }

    public void CanDamageCheckbox()
    {
        ClickCheckBox(CanDamage);
        scenario.log("CAN DAMAGED PRODUCT BE LEFT CHECKBOX CLICKED");
    }

    public void SuppressedPriceCheckbox()
    {
        ClickCheckBox(SuppressPrice);
        scenario.log("SUPPRESSED PRICE ALLOWANCE CHECKBOX CLICKED");
    }

    public void BlockUploadCheckbox()
    {
        ClickCheckBox(BlockUpload);
        scenario.log("BLOCK UPLOAD CHECKBOX CLICKED");
    }

    public void PrintGroupedCheckbox()
    {
        ClickCheckBox(PrintGroup);
        scenario.log("PRINT GROUPED PRODUCT ON SEPARATE TICKETS CHECKBOX CLICKED");
    }

    public void SplitTicketsCheckbox()
    {
        ClickCheckBox(SplitVendor);
        scenario.log("SPLIT TICKETS BY VENDOR CHECKBOX CLICKED");
    }

    public void EnterCarryOverCheckbox()
    {
        ClickCheckBox(CarryOver);
        scenario.log("ENTER CARRY OVER INFO CHECKBOX CLICKED");
    }

    public void AllowStaleCreditCheckbox()
    {
        ClickCheckBox(AllowStaleCr);
        scenario.log("ALLOW STALE CREDIT CHECKBOX CLICKED");
    }

    public void DonotAllowSalesCheckbox()
    {
        ClickCheckBox(DonotAllow);
        scenario.log("DO NOT ALLOW SALES IN PARTIAL CASES CHECKBOX CLICKED");
    }

    public void AllowHHInvoiceCheckbox()
    {
        ClickCheckBox(AllowInvoice);
        scenario.log("ALLOW HH INVOICE TO BE CREATED CHECKBOX CLICKED");
    }
}
