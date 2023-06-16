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
    static String InputValue=null;
    WebElement SampleEle=null;

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
            HelpersMethod.EnterText(driver,ContactInput,10, RandomValues.generateRandomString(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,ContactInput,10);
            scenario.log("CONTACT INPUT ENTERED IS "+InputValue);
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
            HelpersMethod.EnterText(driver,PhoneInput,10, RandomValues.generateRandomNumber(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,PhoneInput,10);
            scenario.log("PHONE NO ENTERED IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }
    public void PrimaryRouteValue()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,PrimaryRouteInput,10, RandomValues.generateRandomNumber(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,PrimaryRouteInput,10);
            scenario.log("PRIMARY ROUTE NO ENTERED IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }
    public void WeeklyDeliSheduleDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,DeliveryWeekDropDown,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmDeliveryWeekSchedule']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("WEEKLY DELIVERY SCHEDULE SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    public void NoOfDayOrWeek()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,DeliveryNumberInput,10, RandomValues.generateRandomNumber(1));
            InputValue=HelpersMethod.JSGetValueEle(driver,DeliveryNumberInput,10);
            scenario.log("NO OF DAY OR WEEK IN INPUT ENTERED IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }
    public void DeliveryDay()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,DeliveryDayInput,10, RandomValues.getWeekday());
            InputValue=HelpersMethod.JSGetValueEle(driver,DeliveryDayInput,10);
            scenario.log("DELIVERY DAY INPUT ENTERED IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void DefaultDeliverySequence()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,DeliveryDelSeqInput,10, RandomValues.generateRandomNumber(1));
            InputValue=HelpersMethod.JSGetValueEle(driver,DeliveryDelSeqInput,10);
            scenario.log("DEFAULT DELIVERY SEQUENCE INPUT ENTERED IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void DeliverySequnce(WebElement WebEle)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,WebEle,10, RandomValues.generateRandomNumber(1));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10);
            scenario.log("SEQUENCE NO ENTERED "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void TrackPositionDropDown(WebElement WebEle)
    {
        exists=false;
        int j;
        try
        {
            HelpersMethod.ActClick(driver,WebEle,10);
            List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
            // Getting size of options available
            int size = Options.size();

            // Generate a random number with in range
            int randnMumber = ThreadLocalRandom.current().nextInt(1, size);

            // Selecting random value
            HelpersMethod.ActClick(driver, Options.get(randnMumber), 20);
            scenario.log("TRACK SELECTED IS " + Options.get(randnMumber).getText());
        }
        catch (Exception e){}
    }

    public void DeliveryRoute(WebElement WebEle)
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,WebEle,10, RandomValues.generateRandomNumber(4));
            InputValue=HelpersMethod.JSGetValueEle(driver,WebEle,10);
            scenario.log("ROUTE NO ENTERED "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void DSDrequired()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,DSDReq,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmDsdFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("DSD VALUE SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SignatureRequired()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,SignFlag,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmSignatureFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SIGNATURE VALUE SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void StoreStampRequired()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,StampFlag,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmStampFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("STORE STAMP REQUIRED SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DynamicAllocation()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,DynamicAll,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmDynamicAllocationFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("DYNAMIC ALLOCATION SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void LoadSequnceGroup()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver, LoadSeq,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmLoadSeqGrp']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("STORE STAMP REQUIRED SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ProductDeliverySequnce()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,ProdDelSeq,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmProdDelvSeqSched']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("PRODUCT DELIVERY SEQUENCE SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void AllowPromoExclusion()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,AllowPromo,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmAllowPromoExclusion']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("ALLOW PROMO EXCLUSION SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
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
        new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
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
        new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
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
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,SoldTo,10, RandomValues.generateRandomString(5));
            InputValue=HelpersMethod.JSGetValueEle(driver,SoldTo,10);
            scenario.log("SOLD TO INPUT ENTERED IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void SplitTicket()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,SplitFlag,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmTktSplitFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SPLIT TICKET SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DocumentType()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,DocType,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmInvDocType']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("AUTHOR PRODUCT SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void TemperatureReq()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,TempReq,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmTemperatureRequired']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("TEMPERATURE REQUIRED SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SeparateCrTicket()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,CreditTicket,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmHHReqdSeparateCreditTik']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("SEPARATE CREDIT TICKET SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DeliveryTicketReprint()
    {
        exists=false;
        try
        {
            HelpersMethod.EnterText(driver,DelivTicket,10, RandomValues.generateRandomString(10));
            InputValue=HelpersMethod.JSGetValueEle(driver,DelivTicket,10);
            scenario.log("CONTACT INPUT ENTERED IS "+InputValue);
            if(InputValue!=null)
            {exists=true;}
            Assert.assertEquals(true,exists);
        }
        catch (Exception e){}
    }

    public void DeliveryTicketFormat()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,DelivTicket,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmNumDelivTicketReprints']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("DELIVERY TICKET FORMATE SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void TransferType()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,TransType,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmBarcodeTicketFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("TRANSFER TYPE SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintBarcode()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,PrintBarCode,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmPrintBarCodeFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("PRINT BAR CODE SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintUPCDropDown()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,PrintUPC,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmPrintBarCodeFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("PRINT UPC SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintPreviousBal()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,PreBalance,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmPreviousBalance']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("PRINT PREVIOUS BALANCE SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
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

    public void Price()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,PriceFlag,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmPriceFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("PRICE VALUE OPTION SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ExtensionPrice()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,ExtensionPriceFlag,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmExtensionPriceFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("EXTENSTION PRICE OPTION SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void TotalPrice()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,TotalPriceFlag,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmTotalPriceFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("TOTAL PRICE OPTION SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintRetailPrice()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,PrintRetailFlag,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmPrintRetailPriceExtFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("PRINT RETAIL PRICE SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintCaseUnit()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,PriceCUFlag,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmPrintCaseUnitsFlag']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("PRINT CASES AND UNIT SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintRetailPriceExt()
    {
        exists=false;
        String TextDropDown=null;
        String TextDropDown1=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ActClick(driver,PrintRetailExtn,10);
            TextDropDown=DropDownInCustomerInq();
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmHHPrintRetailExt']/span[contains(@class,'k-input')]");
            TextDropDown1=WebEle.getText();
            scenario.log("PRINT RETAIL PRICE EXTENSION OPTION SELECTED IS "+TextDropDown1);

            if(TextDropDown.equals(TextDropDown1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
