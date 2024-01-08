package pages_DSD_OMS.UserManagementClientSide;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.RandomValues;
import util.TestBase;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class manageRegistrationClientPageDSD
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(xpath="//label[@id='userSelect-label']/following-sibling::div/descendant::button")
    private WebElement userIndex;





    public manageRegistrationClientPageDSD(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void validateManageRegistrationPage()
    {
        exists = false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='manageRegistrationsTab']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void clickOnUserIndexIcon()
    {
        exists=false;
        try
        {
            if(userIndex.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,userIndex,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateUserIndexDialogbox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='gridUtil_undefined']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void searchForUserInDialogbox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::input[@id='gridUtilSearch_undefined']",driver))
            {
                WebElement modelContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement searchBox = modelContainer.findElement(By.xpath(".//input[@id='gridUtilSearch_undefined']"));
                HelpersMethod.EnterText(driver, searchBox, 1000, TestBase.testEnvironment.userManageRegistration());
                WebElement searchIndex=modelContainer.findElement(By.xpath(".//*[local-name()='svg' and @class='i-icon   i-search-box__search']"));
                HelpersMethod.ActClick(driver,searchIndex,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectUserFromDialogBox()
    {
        exists=true;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[@class='k-master-row']",driver))
            {
                WebElement modelContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement userDetails=modelContainer.findElement(By.xpath(".//tr[@class='k-master-row']"));
                HelpersMethod.ActClick(driver,userDetails,1000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterPrimaryCustomerAccount()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='primary-account-parts-container']",driver))
            {
                WebElement primary=HelpersMethod.FindByElement(driver,"xpath","//div[@class='primary-account-parts-container']");
                HelpersMethod.ScrollElement(driver,primary);
                String[] primaryAccount = TestBase.testEnvironment.FullAcc().split("-");
                WebElement primary1 = HelpersMethod.FindByElement(driver, "id", "add-primary-account-part-1");
                WebElement primary2 = HelpersMethod.FindByElement(driver, "id", "add-primary-account-part-2");
                WebElement primary3 = HelpersMethod.FindByElement(driver, "id", "add-primary-account-part-3");

                HelpersMethod.EnterText(driver,primary1,1000,primaryAccount[0]);
                HelpersMethod.EnterText(driver,primary2,1000,primaryAccount[1]);
                HelpersMethod.EnterText(driver,primary3,1000,primaryAccount[2]);
            }
        }
        catch (Exception e){}
    }

    public void clickOnAddButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//button[@id='addPrimaryAccountButton']",driver))
            {
                WebElement addButton=HelpersMethod.FindByElement(driver,"id","addPrimaryAccountButton");
                HelpersMethod.ClickBut(driver,addButton,1000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnDeleteButton()
    {
        exists=false;
        try
        {
            WebElement delButton=HelpersMethod.FindByElement(driver,"xpath","//div[@id='primaryAccountCard']/descendant::button[contains(@id,'del')]");
            if(delButton.isDisplayed() && delButton.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,delButton);
                HelpersMethod.ClickBut(driver,delButton,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void handleConfirmationDialogbox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Remove primary account')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
               WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
               WebElement yesButton=modelContainer.findElement(By.xpath(".//button[text()='Yes']"));
               HelpersMethod.ActClick(driver,yesButton,1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
        }
        catch (Exception e){}
    }

    public void validateUserdetailsDisplayed()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='userInfoCard']",driver))
            {
                scenario.log("USER DETAILS HAS BEEN LOADED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterSecondaryCustomerAccount()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='primary-account-parts-container']",driver))
            {
                WebElement second=HelpersMethod.FindByElement(driver,"xpath","//div[@id='secondaryAccountCard']");
                HelpersMethod.ScrollElement(driver,second);
                String[] secondAccount = TestBase.testEnvironment.FullAcc1().split("-");
                WebElement second1 = HelpersMethod.FindByElement(driver, "id", "add-sec-account-part-1");
                WebElement second2 = HelpersMethod.FindByElement(driver, "id", "add-sec-account-part-2");
                WebElement second3 = HelpersMethod.FindByElement(driver, "id", "add-sec-account-part-3");

                HelpersMethod.EnterText(driver,second1,1000,secondAccount[0]);
                HelpersMethod.EnterText(driver,second2,1000,secondAccount[1]);
                HelpersMethod.EnterText(driver,second3,1000,secondAccount[2]);
            }
        }
        catch (Exception e){}
    }

    public void clickOnSecondaryAddButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//button[@id='deleteAdditionalAccountButton']",driver))
            {
                WebElement addButton=HelpersMethod.FindByElement(driver,"id","deleteAdditionalAccountButton");
                HelpersMethod.ClickBut(driver,addButton,1000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnSecondaryDeleteButton()
    {
        exists=false;
        try
        {
            WebElement delButton=HelpersMethod.FindByElement(driver,"xpath","//button[@id='deleteAdditionalAccountButton']");
            if(delButton.isDisplayed() && delButton.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,delButton);
                HelpersMethod.ClickBut(driver,delButton,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void updatePONumber()
    {
        exists=false;
        try
        {
            WebElement poInput=HelpersMethod.FindByElement(driver,"id","PONumber");
            if(poInput.isDisplayed())
            {
                HelpersMethod.ActClearKey(driver,poInput,1000);
                String poNo=RandomValues.generateRandomNumber(4);
                HelpersMethod.ActSendKey(driver,poInput,1000, poNo);
                scenario.log("PO# CHANGED TO "+poNo);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnUpdateButton()
    {
        exists=false;
        try
        {
            WebElement updateButton=HelpersMethod.FindByElement(driver,"id","updateUserInfo");
            if(updateButton.isDisplayed() && updateButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,updateButton,1000);
                exists=true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
