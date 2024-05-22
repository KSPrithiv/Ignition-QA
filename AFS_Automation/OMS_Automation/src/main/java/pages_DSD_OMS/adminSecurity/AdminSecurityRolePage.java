package pages_DSD_OMS.adminSecurity;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;

import java.time.Duration;
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
    static String roleName;
    static String description;

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
                HelpersMethod.ClickBut(driver,plusSymbol,1000);
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
            if(HelpersMethod.IsExists("//div[contains(text(),'Add new role')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver));
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
            HelpersMethod.ActSendKey(driver,roleNameEle,1000,roleName);
            scenario.log("ROLE NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,roleNameEle,1000));
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
            HelpersMethod.ActSendKey(driver,descriptionEle,1000,description);
            scenario.log("DESCRIPTION ENTERED IS "+HelpersMethod.JSGetValueEle(driver,descriptionEle,1000));
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
            HelpersMethod.ActClick(driver,manageRole,10000);

            if(HelpersMethod.IsExists("//ul[@id='manageable-roleslist']/li/span",driver))
            {
                List<WebElement> roles=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='manageable-roleslist']/li/span");
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
            HelpersMethod.FindByElement(driver,"id","manageable-roles").click();


            WebElement rName=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']/descendant::span[@class='k-chip-label']");
            scenario.log("MANAGEABLE ROLE SELECTED IS "+rName.getText());
            //popUpOK();
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void popUpOK()
    {
        exists=false;
        try
        {
            WebElement OkButton=HelpersMethod.FindByElement(driver,"xpath","//button/span[text()='OK']");
            if(OkButton.isDisplayed() && OkButton.isEnabled())
            {
                HelpersMethod.JScriptClick(driver,OkButton,1000);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement okPopUp=modalContainer.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ClickBut(driver,okPopUp,1000);
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
                    HelpersMethod.ActClick(driver,WebEle,10000);
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
                HelpersMethod.ClickBut(driver,editSymbol,10000);
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
            if(HelpersMethod.IsExists("//div[contains(text(),'Edit role')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver));
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
            scenario.log(HelpersMethod.JSGetValueEle(driver,descriptionEle,1000)+" IS THE DESCRIPTION FOUND");

            HelpersMethod.ActClearKey(driver,descriptionEle,1000);
            HelpersMethod.ActSendKey(driver,descriptionEle,1000,description);
            scenario.log(HelpersMethod.JSGetValueEle(driver,descriptionEle,1000)+" IS THE DESCRIPTION FOUND AFTER EDIT");
            exists=true;
        }
        catch (Exception e){}
    }

    public void clickOkbuttonInEditRolePopup()
    {
        exists=false;
        try
        {
            WebElement OkButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::.//button/span[text()='Continue']");
            if(OkButton.isDisplayed() && OkButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,OkButton,1000);
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
            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnActiveCheckBox()
    {
        exists=false;
        try
        {
            WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
            modalContainer.findElement(By.xpath(".//input[@id='role-status']")).click();
        }
        catch (Exception e){}
    }

    public void validateActiveRolesInGrid()
    {
        exists=false;
        Actions act=new Actions(driver);
        String headText=null;
        try
        {
            List<WebElement> gridHeads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for (WebElement head:gridHeads)
            {
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equals(roleName))
                {
                    scenario.log("ROLE HAS NOT BEEN DEACTIVATED");
                    exists=false;
                }
                else
                {
                    scenario.log("ROLE HAS BEEN ACTIVATED");
                    exists=true;
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }
}