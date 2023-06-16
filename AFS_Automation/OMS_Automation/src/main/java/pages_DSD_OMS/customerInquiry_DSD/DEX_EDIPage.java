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
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class DEX_EDIPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;

    @FindBy(id="CmDexCustFlag")
    private WebElement DEXCust;

    @FindBy(id="CmDexVersion")
    private WebElement DEXStandard;

    @FindBy(id="CmDexCommId")
    private WebElement DEXCommonId;

    @FindBy(id="CmDexDunsNo")
    private WebElement DEXDunsNo;

    @FindBy(id="CmDexLocation")
    private WebElement DEXLocation;

    @FindBy(id="CmDexAllowanceCode")
    private WebElement DEXAllowanceCode;

    @FindBy(id="CmTicketsPrintPriorDex")
    private WebElement DEXPriorPrint;

    @FindBy(id="CmTicketsPrintAfterDex")
    private WebElement DEXAfterPrint;

    @FindBy(id="CmVendorDexCommId")
    private WebElement DEXComId;

    @FindBy(id="CmVendorDexDunsNo")
    private WebElement DEXDuns;

    @FindBy(id="CmAltComDexLoc")
    private WebElement DEXLoc;

    @FindBy(id="CmEdiCustDeptNo")
    private WebElement CustDept;

    @FindBy(id="CmGlnNo")
    private WebElement GlnNo;

    //Actions
    public DEX_EDIPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void ValidateDEXEDI()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//p[contains(text(),'Customer DEX information')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Methods to handle drop down, this is generic method for all drop down in Account page
    public String ClickOnDropDownSelectRandom(WebElement WebEle,String xpathValue)
    {
        exists=false;
        String TextDropDown=null;
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
            InputValue=HelpersMethod.FindByElement(driver,"xpath","//span[@id='"+xpathValue+"']/span[@class='k-input']").getText();
        }
        catch (Exception e){}
        return InputValue;
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

    public void DEXCustomerDropDown()
    {
        InputValue=ClickOnDropDownSelectRandom(DEXCust,"CmDexCustFlag");
        scenario.log("DEX Customer Drop Down value is "+InputValue);
    }

    public void DEXStandardDropDown()
    {
        InputValue=ClickOnDropDownSelectRandom(DEXStandard,"CmDexVersion");
        scenario.log("DEX STANDARD DROP DOWN VALUE IS "+InputValue);
    }

    public void DEXCommIdInputBox()
    {
        InputValue=EnterNumber(DEXCommonId,4);
        scenario.log("DEX COMM ID VALUE IS "+InputValue);
    }

    public void DEXDunNoInputBox()
    {
        InputValue=EnterNumber(DEXDunsNo,4);
        scenario.log("DEX DUNS# VALUE IS "+InputValue);
    }

    public void DEXLocationInputBox()
    {
        InputValue=EnterText(DEXLocation,15);
        scenario.log("DEX LOCATION VALUE IS "+InputValue);
    }

    public void DEXAllCodeInputBox()
    {
        InputValue=RandomValues.generateRandomAlphaNumeric(8);
        HelpersMethod.EnterText(driver,DEXAllowanceCode,10,InputValue);
        scenario.log("DEX ALLOWANCE CODE VALUE IS "+InputValue);
    }

    public void DEXPriorPrintDropDown()
    {
        InputValue=ClickOnDropDownSelectRandom(DEXPriorPrint,"CmTicketsPrintPriorDex");
        scenario.log("TICKETS TO PRINT PRIOR DEX "+InputValue);
    }

    public void DEXAfterPrintDropDown()
    {
        InputValue=ClickOnDropDownSelectRandom(DEXAfterPrint,"CmTicketsPrintAfterDex");
        scenario.log("TICKETS TO PRINT AFTER DEX "+InputValue);
    }

    public void DEXComIdInputBox()
    {
        InputValue=EnterNumber(DEXComId,4);
        scenario.log("DEX COMM ID VALUE "+InputValue);
    }

    public void DEXDunsNo()
    {
        InputValue=EnterNumber(DEXDuns,4);
        scenario.log("DEX DUNS # VALUE "+InputValue);
    }

    public void DEXLocInputBox()
    {
        InputValue=EnterText(DEXLoc,15);
        scenario.log("DEX LOCATION VALUE IS "+InputValue);
    }

    public void EDIInputBox()
    {
        InputValue=RandomValues.generateRandomAlphaNumeric(8);
        HelpersMethod.EnterText(driver,CustDept,10,InputValue);
        scenario.log("CUSTOMER DEPARTMENT # VALUE IS "+InputValue);
    }

    public void GLNNoInputBox()
    {
        InputValue=EnterNumber(GlnNo,4);
        scenario.log("GLN # VALUE "+InputValue);
    }

}

