package pages_DSD_OMS.customerInquiry_ERP;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class ARRulesPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;

    @FindBy(id="CmMktArea")
    private WebElement marketSegmentDropDown;

    @FindBy(id="CmCurrencyCode")
    private WebElement currencyCodeDropDown;

    @FindBy(id="CmExchangeRateSource")
    private WebElement exchangeRateDropDown;

    @FindBy(id="CmBillToCustomer")
    private WebElement billToCustomerDropDown;

    @FindBy(id="CmRemitToCode")
    private WebElement remitToCode;

    @FindBy(id="CmCashGroupCode")
    private WebElement cashGroupCode;

    @FindBy(id="CmApplicationMethod")
    private WebElement appMethod;

    @FindBy(id="CmStatementTo")
    private WebElement statementTo;

    @FindBy(id="CmStatementFreq")
    private WebElement statementFreq;

    @FindBy(id="CmStatementDOW")
    private WebElement statementDOW;

    @FindBy(id="CmStatementType")
    private WebElement statementType;

    //Actions
    public ARRulesPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
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

    public void marketSegmentDropDown()
    {
        HelpersMethod.ClickBut(driver,marketSegmentDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM MARKET SEGMENT DROP DOWN IS "+marketSegmentDropDown.getText());
    }
    public void currencyCode()
    {
        HelpersMethod.ClickBut(driver,currencyCodeDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM CURRENCY CODE DROP DOWN IS "+currencyCodeDropDown.getText());
    }
    public void exchangeRateSourceDropDown()
    {
        HelpersMethod.ClickBut(driver,exchangeRateDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM EXCHANGE RATE DROP DOWN IS "+exchangeRateDropDown.getText());
    }
    public void billToCustomerDropDown()
    {
        HelpersMethod.ClickBut(driver,billToCustomerDropDown,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM BILL TO CUSTOMER DROP DOWN IS "+billToCustomerDropDown.getText());
    }
    public void remitToCodeDropDown()
    {
        HelpersMethod.ClickBut(driver,remitToCode,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM REMIT TO CODE DROP DOWN IS "+remitToCode.getText());
    }
    public void cashGroupCodeDropDown()
    {
        HelpersMethod.ClickBut(driver,cashGroupCode,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM CASH GROUP CODE DROP DOWN IS "+cashGroupCode.getText());
    }
    public void applicationMethodDropDown()
    {
        HelpersMethod.ClickBut(driver,appMethod,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM APPLICATION METHOD DROP DOWN IS "+appMethod.getText());
    }
    public void statementToDropDown()
    {
        HelpersMethod.ClickBut(driver,statementTo,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM STATEMENT TO DROP DOWN IS "+statementTo.getText());
    }
    public void statementFreqDropDown()
    {
        HelpersMethod.ClickBut(driver,statementFreq,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM STATEMENT TO DROP DOWN IS "+statementFreq.getText());
    }
    public void statementDOWDropDown()
    {
        HelpersMethod.ClickBut(driver,statementDOW,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM STATEMENT TO DROP DOWN IS "+statementDOW.getText());
    }
    public void statementTypeDropDown()
    {
        HelpersMethod.ClickBut(driver,statementType,40);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM STATEMENT TO DROP DOWN IS "+statementType.getText());
    }
}
