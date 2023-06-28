package pages_DSD_OMS.adminSecurity;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.RandomValues;

import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class AdminSecurityRolePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String roleName=null;
    static String description=null;

    @FindBy(id = "add-role")
    private WebElement plusSymbol;

    @FindBy(id="edit-role")
    private WebElement editSymbol;

    @FindBy(id="save-btn")
    private WebElement saveButton;

    public AdminSecurityRolePage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void validateRolePage()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'i-card CPRolesForm')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnPlusButton()
    {
        exists=false;
        try
        {
            if(plusSymbol.isDisplayed() && plusSymbol.isEnabled())
            {
                HelpersMethod.ClickBut(driver,plusSymbol,100);
                scenario.log("CREATING NEW ROLE FROM ROLE TAB");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAddNewRole()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Add new role')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver));
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void addRoleName()
    {
        exists=false;
        roleName= RandomValues.generateRandomString(6);
        try
        {
            WebElement roleNameEle=HelpersMethod.FindByElement(driver,"id","role-name");
            HelpersMethod.ActSendKey(driver,roleNameEle,100,roleName);
            scenario.log("ROLE NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,roleNameEle,100));
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void addDescription()
    {
        exists=false;
        description= RandomValues.generateRandomString(25);
        try
        {
            WebElement descriptionEle=HelpersMethod.FindByElement(driver,"id","role-description");
            HelpersMethod.ActSendKey(driver,descriptionEle,100,description);
        scenario.log("DESCRIPTION ENTERED IS "+HelpersMethod.JSGetValueEle(driver,descriptionEle,100));
            exists=true;
        }
        catch (Exception e){}
    }

    public void manageableRole(String role)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            WebElement manageRole=HelpersMethod.FindByElement(driver,"id","manageable-roles");
            HelpersMethod.ActClick(driver,manageRole,200);

            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li",driver))
            {
                List<WebElement> roles=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
                for (WebElement rol:roles)
                {
                    act.moveToElement(rol).build().perform();
                    String role_Text=rol.getText();
                    if(role_Text.equals(role))
                    {
                        act.moveToElement(rol).build().perform();
                        act.click(rol).build().perform();
                        exists=true;
                        break;
                    }
                }
            }
            HelpersMethod.ActClick(driver,manageRole,200);
            WebElement rName=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::li/span[1]");
            scenario.log("MANAGEABLE ROLE SELECTED IS "+rName.getText());
            popUpOK();
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void popUpOK()
    {
        exists=false;
        try
        {
            WebElement OkButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
            if(OkButton.isDisplayed() && OkButton.isEnabled())
            {
                HelpersMethod.JScriptClick(driver,OkButton,1000);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNewRoleAdded()
    {
        exists=false;
        Actions actions=new Actions(driver);
        try
        {
            List<WebElement> roleNames=HelpersMethod.FindByElements(driver,"xpath","//tr/td[1]");
            for (WebElement RName:roleNames)
            {
                actions.moveToElement(RName).build().perform();
                String RName_Text=RName.getText();
                if(RName_Text.equals(roleName))
                {
                    exists=true;
                    break;
                }
            }
            if(exists==true)
            {
                scenario.log("NEWLY ADDED ROLE HAS BEEN FOUND");
            }
            else
            {
                scenario.log("NEWLY ADDED ROLE NOT FOUND");
            }
        }
        catch (Exception e){}
    }

    public void confirmationPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okPopUp=modalContainer.findElement(By.xpath(".//button[text()='OK']"));
                HelpersMethod.ClickBut(driver,okPopUp,400);
            }
        }
        catch (Exception e){}
    }

    public void selectRoleToEdit()
    {
        exists=false;
        Actions actions=new Actions(driver);
        int i=0;
        try
        {
            List<WebElement> roleNames=HelpersMethod.FindByElements(driver,"xpath","//tr/td[1]");
            for (WebElement RName:roleNames)
            {
                i++;
                actions.moveToElement(RName).build().perform();
                String RName_Text=RName.getText();
                if(RName_Text.equals(roleName))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr["+i+"]");
                    HelpersMethod.ActClick(driver,WebEle,200);
                    exists=true;
                    break;
                }
            }
            if(exists==true)
            {
                scenario.log("ROLE HAS BEEN SELECTED FOR EDITING");
            }
            else
            {
                scenario.log("NO ROLE HAS BEEN SELCTED FOR EDITING");
            }
        }
        catch (Exception e){}
    }

    public void clickOnEditButton()
    {
        exists=false;
        try
        {
            if(editSymbol.isDisplayed() && editSymbol.isEnabled())
            {
                HelpersMethod.ClickBut(driver,editSymbol,200);
                exists=true;
                scenario.log("EDIT BUTTON HAS BEEN CLICKED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateEditRolepopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Edit role')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver));
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void makeChangesToDescription()
    {
        exists=false;
        description= RandomValues.generateRandomString(25);
        try
        {
            WebElement descriptionEle=HelpersMethod.FindByElement(driver,"id","role-description");
            scenario.log(HelpersMethod.JSGetValueEle(driver,descriptionEle,100)+" IS THE DESCRIPTION FOUND");

            HelpersMethod.ActClearKey(driver,descriptionEle,100);
            HelpersMethod.ActSendKey(driver,descriptionEle,100,description);
            scenario.log(HelpersMethod.JSGetValueEle(driver,descriptionEle,100)+" IS THE DESCRIPTION FOUND AFTER EDIT");
            exists=true;
        }
        catch (Exception e){}
    }

    public void clickOkbuttonInEditRolePopup()
    {
        exists=false;
        try
        {
            WebElement OkButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
            if(OkButton.isDisplayed() && OkButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,OkButton,100);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateConfirmPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
