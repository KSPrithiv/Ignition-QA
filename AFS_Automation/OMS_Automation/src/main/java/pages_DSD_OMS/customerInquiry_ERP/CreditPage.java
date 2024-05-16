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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class CreditPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue;

    @FindBy(id="CmCreditStatus")
    private WebElement statusDropDown;

    @FindBy(id="CmCreditBranch")
    private WebElement defaultBranchDropDown;

    @FindBy(id="CmCreditWarehouse")
    private WebElement wareHouseDropDown;

    @FindBy(id="CmCreditToCompany")
    private WebElement creditToCompanyDropDown;

    @FindBy(id="CmCreditToCustomer")
    private WebElement creditToCustomerDropDown;

    @FindBy(id="CmCreditHoldCode")
    private WebElement creditHoldCodeDropDown;

    @FindBy(id="CmCreditTerms")
    private WebElement creditTermsDropDown;

    @FindBy(id="CmCreditServiceCharge")
    private WebElement creditServiceChargeDropDown;

    @FindBy(id="CmCreditRep")
    private WebElement creditRepDropDown;

    @FindBy(id="CmCreditLimit")
    private  WebElement creditLimit;

    @FindBy(id="CmMemoLimit")
    private WebElement memoLimit;

    @FindBy(xpath="//input[@id='CmCreditReviewDate']/ancestor::span[contains(@class,'k-widget k-dateinput')]/following-sibling::a")
    private WebElement creditReviewDate;

    @FindBy(xpath="//input[@id='CmNextCreditReviewDate']/ancestor::span[contains(@class,'k-widget k-dateinput')]/following-sibling::a")
    private WebElement nextCreditReviewDate;

    public CreditPage(WebDriver driver, Scenario scenario)
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

    public void statusDropDown()
    {
        HelpersMethod.ClickBut(driver,statusDropDown,1000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM STATUS DROP DOWN IS "+statusDropDown.getText());
    }
    public void defaultBranchDropDown()
    {
        HelpersMethod.ClickBut(driver,defaultBranchDropDown,1000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM DEFAULT BRANCH DROP DOWN IS "+defaultBranchDropDown.getText());
    }
    public void defaultWarehouseDropDown()
    {
        HelpersMethod.ClickBut(driver,wareHouseDropDown,1000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM DEFAULT WAREHOUSE DROP DOWN IS "+wareHouseDropDown.getText());
    }
    public void creditToCompanyDropDown()
    {
        HelpersMethod.ClickBut(driver,creditToCompanyDropDown,1000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM CREDIT TO COMPANY DROP DOWN IS "+creditToCompanyDropDown.getText());
    }
    public void creditToCustomerDropDown()
    {
        HelpersMethod.ClickBut(driver,creditToCustomerDropDown,1000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM CREDIT TO COMPANY DROP DOWN IS "+creditToCustomerDropDown.getText());
    }
    public void creditHoldCodeDropDown()
    {
        HelpersMethod.ClickBut(driver,creditHoldCodeDropDown,1000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM CREDIT TO COMPANY DROP DOWN IS "+creditHoldCodeDropDown.getText());
    }
    public void creditTermsDropDown()
    {
        HelpersMethod.ClickBut(driver,creditTermsDropDown,1000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM CREDIT TO COMPANY DROP DOWN IS "+creditTermsDropDown.getText());
    }
    public void serviceChargeDropDown()
    {
        HelpersMethod.ClickBut(driver,creditServiceChargeDropDown,1000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SERVICE CHARGE DROP DOWN IS "+creditServiceChargeDropDown.getText());
    }
    public void creditRepDropDown()
    {
        HelpersMethod.ClickBut(driver,creditRepDropDown,1000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SERVICE CHARGE DROP DOWN IS "+creditRepDropDown.getText());
    }
    public void creditLimit()
    {
        InputValue= EnterNumber(creditLimit,10);
        HelpersMethod.EnterText(driver,creditLimit,1000,InputValue);
        scenario.log("CREDIT ENTERED IS "+HelpersMethod.JSGetValueEle(driver,creditLimit,1000));
    }
    public void memoLimit()
    {
        InputValue= EnterNumber(memoLimit,10);
        HelpersMethod.EnterText(driver,memoLimit,1000,InputValue);
        scenario.log("MEMO LIMIT ENTERED IS "+HelpersMethod.JSGetValueEle(driver,memoLimit,1000));
    }

    public void reviewDateSelection()
    {
        HelpersMethod.ClickBut(driver,creditReviewDate,1000);
    }
    public void selectReviewDate()
    {
        try
        {
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",6000);
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@class,'k-calendar-td k-state-pending-focus k-today k-state-focused')]");
                HelpersMethod.JSScroll(driver,ele1);
                HelpersMethod.ActClick(driver, ele1, 1000);
                scenario.log("CURRENT DATE HAS BEEN SELECTED AS REVIEW DATE");
            }
            else
            {
                scenario.log("CALENDER DROP DOWN DOESN'T EXISTS");
            }
        }
        catch (Exception e) {}
    }

    public void nextReviewDateSelection()
    {
        HelpersMethod.ClickBut(driver,nextCreditReviewDate,2000);
    }
    public void selectNextReviewDate()
    {
        try
        {
            String formattedDate1 = null;
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",2000);

            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                LocalDate myDateObj = LocalDate.now().plusDays(4);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                formattedDate1 = myDateObj.format(myFormatObj);
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@title,'" + formattedDate1 + "')]");
                HelpersMethod.JSScroll(driver,ele1);
                HelpersMethod.ActClick(driver, ele1, 2000);
                scenario.log(formattedDate1 + " HAS BEEN SELECTED AS NEXT REVIEW DATE");
            }
            else
            {
                scenario.log("CALENDER DROP DOWN DOESN'T EXISTS");
            }
        }
        catch (Exception e) {}
    }
}
