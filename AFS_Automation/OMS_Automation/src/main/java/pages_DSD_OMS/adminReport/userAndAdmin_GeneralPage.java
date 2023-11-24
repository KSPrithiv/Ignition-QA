package pages_DSD_OMS.adminReport;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class userAndAdmin_GeneralPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy (id="CPEnforceUniqueUserEmail")
    private WebElement enforceUniqueEmail;

    @FindBy (id="CPAdminApprovesRegistrations")
    private WebElement pendingRegistration;

    @FindBy (id="CPExcludeNonWebCustomers")
    private WebElement excludeNonWebEle;

    @FindBy (id="CPEnableCustomerRegistration")
    private WebElement newCustomerRegi;

    @FindBy (id="CPCCPrimarySalesmanOnRegistrationEmail")
    private WebElement primarySalRegistration;

    @FindBy(id="save-btn")
    private WebElement saveButton;

    public userAndAdmin_GeneralPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void validateAllToggleButtons()
    {
        exists=false;
        try
        {
            if(enforceUniqueEmail.isDisplayed() && pendingRegistration.isDisplayed() && excludeNonWebEle.isDisplayed() && newCustomerRegi.isDisplayed() && primarySalRegistration.isDisplayed())
            {
                exists=true;
            }
            else
            {
                scenario.log("NOT ALL THE 5 TOGGLE BUTTONS DISPLAYED, PELEASE CHECK ADMIN SETTINGS");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enablePendingRegistrationToggle()
    {
        exists=false;
        String result=null;
        try
        {
            result=pendingRegistration.getAttribute("aria-checked");
            if(result.equals("false"))
            {
                HelpersMethod.ClickBut(driver, pendingRegistration, 1000);
                scenario.log("PENDING REGISTRATION TAGGLE BUTTON ENABLED");
            }
        }
        catch (Exception e){}
    }

    public void validatePendingRegirationTab()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@class='k-link' and contains(text(),'Pending registration approval')]",driver))
            {
                scenario.log("PENDING REGISTRATION APPROVAL TAB DISPLAYED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enableNewCustomerRegistrationFromLoginPage()
    {
        exists=false;
        String result=null;
        try
        {
            result=newCustomerRegi.getAttribute("aria-checked");
            if(result.equals("true"))
            {
                HelpersMethod.ClickBut(driver, newCustomerRegi, 1000);
                scenario.log("NEW CUSTOMER REGISTRATION FROM LOGIN PAGE TOGGLE ALREADY SELECTED");
                exists=true;
            }
            else
            {
                scenario.log("NEW CUSTOMER REGISTRATION FROM LOGIN PAGE TOGGLE ALREADY DESELECTED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnSaveButton()
    {
        exists=true;
        try
        {
            if(saveButton.isDisplayed() && saveButton.isEnabled()) {
                HelpersMethod.ClickBut(driver, saveButton, 8000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver)) {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }

                if (HelpersMethod.IsExists("//div[contains(text(),'The information has been')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                    WebElement confirmationPopup = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'The information has been')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement okButton = confirmationPopup.findElement(By.xpath(".//button[text()='OK']"));
                    HelpersMethod.ActClick(driver, okButton, 1000);
                    exists = true;
                }
            }
            else
            {
                scenario.log("SAVE BUTTON DISABLED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enableNewCustomerRegistrationFromLoginPage1()
    {
        exists=false;
        String result=null;
        try
        {
            result=newCustomerRegi.getAttribute("aria-checked");
            if(result.equals("false"))
            {
                HelpersMethod.ClickBut(driver, newCustomerRegi, 1000);
                scenario.log("ENABLES NEW CUSTOMER REGISTRATION FROM LOGIN PAGE TOGGLE BUTTON");
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}