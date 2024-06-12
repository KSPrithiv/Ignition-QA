package pages_DSD_OMS.customerInquiry_DSD;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class DeliveriesPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue;

    @FindBy(id="CmDelDefaultDelvContact")
    private WebElement ContactInput;

    @FindBy(id="CmDelDefaultDelvTel")
    private WebElement PhoneInput;

    @FindBy(id="CmPrimaryRoute")
    private WebElement PrimaryRouteInput;

    @FindBy(id="CmDeliveryWeekSchedule")
    private WebElement DeliveryWeekDropDown;

    @FindBy(id="CmDeliveryNumber")
    private WebElement DeliveryNumberInput;

    @FindBy(id="CmScheduledDeliveryDay")
    private WebElement DeliveryDayInput;

    @FindBy(id="CmDelDefaultDelseq")
    private WebElement DeliveryDelSeqInput;

    @FindBy(id="CmDelDay1Seq")
    private WebElement MonDelSeq;

    @FindBy(id="CmDelDay2Seq")
    private WebElement TueDelSeq;

    @FindBy(id="CmDelDay3Seq")
    private WebElement WedDelSeq;

    @FindBy(id="CmDelDay4Seq")
    private WebElement ThuDelSeq;

    @FindBy(id="CmDelDay5Seq")
    private WebElement FriDelSeq;

    @FindBy(id="CmDelDay6Seq")
    private WebElement SatDelSeq;

    @FindBy(id="CmDelDay7Seq")
    private WebElement SunDelSeq;

    @FindBy(id="CmDelDay1Route")
    private WebElement MonRoute;

    @FindBy(id="CmDelDay2Route")
    private WebElement TueRoute;

    @FindBy(id="CmDelDay3Route")
    private WebElement WedRoute;

    @FindBy(id="CmDelDay4Route")
    private WebElement ThuRoute;

    @FindBy(id="CmDelDay5Route")
    private WebElement FriRoute;

    @FindBy(id="CmDelDay6Route")
    private WebElement SatRoute;

    @FindBy(id="CmDelDay7Route")
    private WebElement SunRoute;

    @FindBy(id="CmDelDay1TruckPos")
    private WebElement MonTrack;

    @FindBy(id="CmDelDay2TruckPos")
    private WebElement TueTrack;

    @FindBy(id="CmDelDay3TruckPos")
    private WebElement WedTrack;

    @FindBy(id="CmDelDay4TruckPos")
    private WebElement ThuTrack;

    @FindBy(id="CmDelDay5TruckPos")
    private WebElement FriTrack;

    @FindBy(id="CmDelDay6TruckPos")
    private WebElement SatTrack;

    @FindBy(id="CmDelDay7TruckPos")
    private WebElement SunTrack;

    @FindBy(id="CmDsdFlag")
    private WebElement DSDReq;

    @FindBy(id="CmSignatureFlag")
    private WebElement SignFlag;

    @FindBy(id="CmStampFlag")
    private WebElement StampFlag;

    @FindBy(id="CmDynamicAllocationFlag")
    private WebElement DynamicAll;

    @FindBy(id="CmLoadSeqGrp")
    private WebElement LoadSeq;

    @FindBy(id="CmProdDelvSeqSched")
    private WebElement ProdDelSeq;

    @FindBy(id="CmAllowPromoExclusion")
    private WebElement AllowPromo;

    @FindBy(xpath="//input[@id='CmLastDelivDate']/ancestor::span[contains(@class,'k-widget k-dateinput')]/following-sibling::a")
    private WebElement LastDelivDate;

    @FindBy(xpath="//input[@id='CmLastSchedDate']/ancestor::span[contains(@class,'k-widget k-dateinput')]/following-sibling::a")
    private WebElement LastSchedDate;

    @FindBy(id="CmSoldTo")
    private WebElement SoldTo;

    @FindBy(id="CmTktSplitFlag")
    private WebElement SplitFlag;

    @FindBy(id="CmInvDocType")
    private WebElement DocType;

    @FindBy(id="CmTemperatureRequired")
    private WebElement TempReq;

    @FindBy(id="CmHHReqdSeparateCreditTik")
    private WebElement CreditTicket;

    @FindBy(id="CmNumDelivTicketReprints")
    private WebElement DelivTicket;

    @FindBy(id="CmHHPrintOption")
    private WebElement DlivTicketOption;

    @FindBy(id="CmBarcodeTicketFlag")
    private WebElement TransType;

    @FindBy(id="CmPrintBarCodeFlag")
    private WebElement PrintBarCode;

    @FindBy(id="CmPrintUPCFlag")
    private WebElement PrintUPC;

    @FindBy(id="CmPreviousBalance")
    private WebElement PreBalance;

    @FindBy(id="CmItemProdFlag")
    private WebElement ItemProdFlag;

    @FindBy(id="CmPriceFlag")
    private WebElement PriceFlag;

    @FindBy(id="CmExtensionPriceFlag")
    private WebElement ExtensionPriceFlag;

    @FindBy(id="CmTotalPriceFlag")
    private WebElement TotalPriceFlag;

    @FindBy(id="CmPrintRetailPriceExtFlag")
    private WebElement PrintRetailFlag;

    @FindBy(id="CmPrintCaseUnitsFlag")
    private WebElement PriceCUFlag;

    @FindBy(id="CmHHPrintRetailExt")
    private WebElement PrintRetailExtn;

    //Actions
    public DeliveriesPage(WebDriver driver,Scenario scenario)
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
        List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-list-content']/ul/li");
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

    public void ValidateDeliveries()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//p[contains(text(),'Delivery contacts and schedule')]",driver))
            {
                exists=true;
            }
            else
            {
                scenario.log("NOT NAVIGATED TO DELIVERY CONTACTS AND SCHEULE TAB");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ContactValue()
    {
        exists=false;
        try
        {
            InputValue=EnterText(ContactInput,10);
            HelpersMethod.EnterText(driver,ContactInput,10,InputValue);
            scenario.log("CONTACT DETAILS ENTERED IS "+HelpersMethod.JSGetValueEle(driver,ContactInput,10));
        }
        catch (Exception e){}
    }

    public void PhoneValue()
    {
        exists=false;
        try
        {
            InputValue=EnterNumber(PhoneInput,10);
            HelpersMethod.EnterText(driver,PhoneInput,10,InputValue);
            scenario.log("PHONE DETAILS ENTERED IS "+HelpersMethod.JSGetValueEle(driver,PhoneInput,10));
        }
        catch (Exception e){}
    }

    public void PrimaryRouteValue()
    {
            InputValue=EnterNumber(PrimaryRouteInput,10);
            HelpersMethod.EnterText(driver,PrimaryRouteInput,10,InputValue);
            scenario.log("PRIMARY ROUTE DETAILS ENTERED IS "+HelpersMethod.JSGetValueEle(driver,PrimaryRouteInput,10));
    }

    public void WeeklyDeliSheduleDropDown()
    {
        HelpersMethod.ClickBut(driver,DeliveryWeekDropDown,40);
        selectDropDownValue();
        scenario.log("WEEKLY DELIVERY SCHEDULE FROM COUNTRY DROP DOWN IS "+DeliveryWeekDropDown.getText());
    }

    public void NoOfDayOrWeek()
    {
        exists=false;
            InputValue=EnterNumber(DeliveryNumberInput,2);
            HelpersMethod.EnterText(driver,DeliveryNumberInput,10,InputValue);
            scenario.log("# OF DAYS OR WEEKS INPUT DETAILS ENTERED IS "+HelpersMethod.JSGetValueEle(driver,DeliveryNumberInput,10));
    }

    public void DeliveryDay()
    {
        InputValue=EnterText(DeliveryDayInput,2);
        HelpersMethod.EnterText(driver,DeliveryDayInput,10,InputValue);
        scenario.log("DELIVERY DAY INPUT DETAILS ENTERED IS "+HelpersMethod.JSGetValueEle(driver,DeliveryDayInput,10));
    }

    public void DefaultDeliverySequence()
    {
        InputValue = EnterNumber(DeliveryDelSeqInput, 2);
        HelpersMethod.EnterText(driver, DeliveryDelSeqInput, 10, InputValue);
        scenario.log("DEFAULT DELIVERY SEQUENCE INPUT DETAILS ENTERED IS " + HelpersMethod.JSGetValueEle(driver, DeliveryDelSeqInput, 10));
    }

    public void DeliverySequnce(WebElement WebEle)
    {
        InputValue = EnterNumber(WebEle, 2);
        HelpersMethod.EnterText(driver, WebEle, 10, InputValue);
        scenario.log("DELIVERY SEQUENCE INPUT DETAILS ENTERED IS " + HelpersMethod.JSGetValueEle(driver, WebEle, 10));
    }

    public void TrackPositionDropDown(WebElement WebEle) throws InterruptedException
    {
        HelpersMethod.ActClick(driver,WebEle,100);
        selectDropDownValue();
        scenario.log("TRACK POSITION DROP DOWN IS "+WebEle.getText());
    }

    public void DeliveryRoute(WebElement WebEle)
    {
        InputValue=EnterText(WebEle,10);
        HelpersMethod.EnterText(driver,WebEle,10,InputValue);
        scenario.log("DELIVERY ROUTE ENTERED IS "+HelpersMethod.JSGetValueEle(driver,WebEle,10));
    }

    public void DSDrequired() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,DSDReq,100);
        selectDropDownValue();
        scenario.log("DSD VALUE SELECTED IS "+DSDReq.getText());
    }

    public void SignatureRequired() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,SignFlag,100);
        selectDropDownValue();
        scenario.log("SIGNATURE REQUIRED VALUE SELECTED IS "+SignFlag.getText());
    }

    public void StoreStampRequired() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,StampFlag,100);
        selectDropDownValue();
        scenario.log("STORE STAMP REQUIRED SELECTED IS "+SignFlag.getText());
    }

    public void DynamicAllocation() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,DynamicAll,100);
        selectDropDownValue();
        scenario.log("DYNAMIC ALLOCATION SELECTED IS "+DynamicAll.getText());
    }

    public void LoadSequnceGroup() throws InterruptedException
    {
        HelpersMethod.ActClick(driver, LoadSeq,100);
        selectDropDownValue();
        scenario.log("STORE STAMP REQUIRED SELECTED IS "+ LoadSeq.getText());
    }

    public void ProductDeliverySequnce() throws InterruptedException
    {
        HelpersMethod.ActClick(driver, ProdDelSeq,100);
        selectDropDownValue();
        scenario.log("PRODUCT DELIVERY SEQUENCE SELECTED IS"+ ProdDelSeq.getText());
    }

    public void AllowPromoExclusion() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,AllowPromo,100);
        selectDropDownValue();
        scenario.log("ALLOW PROMO EXCLUSION SELECTED IS "+ AllowPromo.getText());
    }

    public void HHLastDeliveryDate()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,LastDelivDate,20);
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    public void SelectHHLastDeliveryDate()
    {
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
        new WebDriverWait(driver, Duration.ofMillis(100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        try
        {
            String formattedDate1 = null;
            WebElement WebEle=null;
            exists=false;
            //finding element/date in calendar drop down is enabled or not.
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//table/descendant::tr[@role='row'][1]/td[@aria-selected='false'][1]");
                HelpersMethod.ActClick(driver,WebEle,20);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmLastDelivDate");
                formattedDate1=HelpersMethod.JSGetValueEle(driver,WebEle,10);
                if(formattedDate1!=null)
                {
                    scenario.log("START DATE FOR FORECASTING SELECTED IS "+formattedDate1);
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void HHLastScheduleDate()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,LastSchedDate,20);
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectHHLastScheduleDate()
    {
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
        new WebDriverWait(driver,Duration.ofMillis(100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        try
        {
            String formattedDate1 = null;
            WebElement WebEle=null;
            exists=false;
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//table/descendant::td[contains(@class,'k-state-pending-focus k-today k-state-focused')]");
                HelpersMethod.ActClick(driver,WebEle,20);
                WebEle=HelpersMethod.FindByElement(driver,"id","CmStartForecastingDate");
                formattedDate1=HelpersMethod.JSGetValueEle(driver,WebEle,10);
                if(formattedDate1!=null)
                {
                    scenario.log("END DATE FOR FORECASTING SELECTED IS "+formattedDate1);
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void Soldto()
    {
        InputValue=EnterText(SoldTo,10);
        HelpersMethod.EnterText(driver,SoldTo,10,InputValue);
        scenario.log("SOLD TO INPUT ENTERED IS "+HelpersMethod.JSGetValueEle(driver,SoldTo,10));
    }

    public void SplitTicket() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,SplitFlag,100);
        selectDropDownValue();
        scenario.log("SPLIT TICKET SELECTED IS "+ SplitFlag.getText());
    }

    public void DocumentType() throws InterruptedException
    {
        HelpersMethod.ActClick(driver, DocType,100);
        selectDropDownValue();
        scenario.log("AUTHOR PRODUCT SELECTED IS "+ DocType.getText());
    }

    public void TemperatureReq() throws InterruptedException
    {
        HelpersMethod.ActClick(driver, TempReq,100);
        selectDropDownValue();
        scenario.log("TEMPERATURE REQUIRED SELECTED IS "+ TempReq.getText());
    }

    public void SeparateCrTicket() throws InterruptedException
    {
        HelpersMethod.ActClick(driver, CreditTicket,100);
        selectDropDownValue();
        scenario.log("SEPARATE CREDIT TICKET SELECTED IS "+ CreditTicket.getText());
    }

    public void DeliveryTicketReprint()
    {
        InputValue=EnterText(DelivTicket,10);
        HelpersMethod.EnterText(driver,DelivTicket,10,InputValue);
        scenario.log("CONTACT INPUT ENTERED IS "+HelpersMethod.JSGetValueEle(driver,DelivTicket,10));
    }

    public void DeliveryTicketFormat() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,  DlivTicketOption,100);
        selectDropDownValue();
        scenario.log("DELIVERY TICKET FORMATE SELECTED IS  "+  DlivTicketOption.getText());
    }

    public void TransferType() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,TransType,100);
        selectDropDownValue();
        scenario.log("TRANSFER TYPE SELECTED IS   "+  TransType.getText());
    }

    public void PrintBarcode() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,PrintBarCode,100);
        selectDropDownValue();
        scenario.log("PRINT BAR CODE SELECTED IS   "+  PrintBarCode.getText());
    }

    public void PrintUPCDropDown() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,PrintUPC,100);
        selectDropDownValue();
        scenario.log("PRINT UPC SELECTED IS"+  PrintUPC.getText());
    }

    public void PrintPreviousBal() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,PreBalance,100);
        selectDropDownValue();
        scenario.log("PRINT PREVIOUS BALANCE SELECTED IS "+  PreBalance.getText());
    }

    public void ItemProductFlagCheckBox()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,ItemProdFlag,10);
            if(ItemProdFlag.isSelected())
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Price() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,PriceFlag,100);
        selectDropDownValue();
        scenario.log("PRICE VALUE OPTION SELECTED IS "+  PriceFlag.getText());
    }

    public void ExtensionPrice() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,ExtensionPriceFlag,100);
        selectDropDownValue();
        scenario.log("EXTENSTION PRICE OPTION SELECTED IS "+ExtensionPriceFlag.getText());
    }

    public void TotalPrice() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,TotalPriceFlag,100);
        selectDropDownValue();
        scenario.log("TOTAL PRICE OPTION SELECTED IS "+TotalPriceFlag.getText());
    }

    public void PrintRetailPrice() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,PrintRetailFlag,100);
        selectDropDownValue();
        scenario.log("PRINT RETAIL PRICE SELECTED IS "+PrintRetailFlag.getText());
    }

    public void PrintCaseUnit() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,PriceCUFlag,100);
        selectDropDownValue();
        scenario.log("PRINT CASES AND UNIT SELECTED IS "+PriceCUFlag.getText());
    }

    public void PrintRetailPriceExt() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,PrintRetailExtn,100);
        selectDropDownValue();
        scenario.log("PRINT RETAIL PRICE EXTENSION OPTION SELECTED IS "+PrintRetailExtn.getText());
    }
}
