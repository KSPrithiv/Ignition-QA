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

public class PricingPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String InputValue=null;

    @FindBy(id="CmPricingCustomer")
    private WebElement pricingCustomerDropDown;

    @FindBy(id="CmPricingZone")
    private WebElement pricingZoneDropDown;

    @FindBy(id="CmPricingLevel")
    private WebElement pricingLevelDropDown;

    @FindBy(xpath="//label[@id='CmPricingLastNotification-label']/following-sibling::span/descendant::a")
    private WebElement lastNotificationCalender;

    @FindBy(id="CmAIMPricing")
    private WebElement AIMPricingDropDown;

    @FindBy(id="CmSchRetail")
    private WebElement retailPriceDropDown;

    @FindBy(id="CmPricingShelfTags")
    private WebElement shelfTagsDropDown;

    @FindBy(id="CmPricingPromotions")
    private WebElement applyPromotionsCheckbox;

    public PricingPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
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

    public void pricingCustomerDropDown()
    {
        HelpersMethod.ClickBut(driver,pricingCustomerDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM PRICING CUSTOMER DROP DOWN IS "+pricingCustomerDropDown.getText());
    }
    public void pricingZoneDropDown()
    {
        HelpersMethod.ClickBut(driver,pricingZoneDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM PRICING ZONE DROP DOWN IS "+pricingZoneDropDown.getText());
    }
    public void pricingLevelDropDown()
    {
        HelpersMethod.ClickBut(driver,pricingLevelDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SALES REP DROP DOWN IS "+pricingLevelDropDown.getText());
    }
    public void lastNotificationCalender()
    {
        HelpersMethod.ClickBut(driver,lastNotificationCalender,1000);
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
                HelpersMethod.ActClick(driver, ele1, 2000);
                scenario.log("CURRENT DATE HAS BEEN SELECTED AS LAST NOTIFICATION DATE");
            }
            else
            {
                scenario.log("CALENDER DROP DOWN DOESN'T EXISTS");
            }
        }
        catch (Exception e) {}
    }

    public void AIMPricingDropDown()
    {
        HelpersMethod.ClickBut(driver,AIMPricingDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM AIM PRICING DROP DOWN IS "+AIMPricingDropDown.getText());
    }
    public void retailPriceDropDown()
    {
        HelpersMethod.ClickBut(driver,retailPriceDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM RETAIL PRICE DROP DOWN IS "+retailPriceDropDown.getText());
    }
    public void shelfTagsDropDown()
    {
        HelpersMethod.ClickBut(driver,shelfTagsDropDown,4000);
        selectDropDownValue();
        scenario.log("VALUE SELECTED FROM SHELF TAGS DROP DOWN IS "+shelfTagsDropDown.getText());
    }
    public void pricingPromotions() throws InterruptedException
    {
        HelpersMethod.ActClick(driver,applyPromotionsCheckbox,1000);
    }
}
