package pages_DSD_OMS.adminSecurity;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;
import util.TestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class AdminSecurityPermissionPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String roleName=null;
    static String description=null;
    static String company = TestBase.testEnvironment.get_CompanyNo();

    @FindBy(id = "AddBtn")
    private WebElement plusSymbol;

    @FindBy(id="EditBtn")
    private WebElement editSymbol;

    @FindBy(id="CopyBtn")
    private WebElement copySymbol;

    @FindBy(id="save-btn")
    private WebElement saveButton;

    public AdminSecurityPermissionPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void validatePermissionPage()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'CPPermissionsForm')]",driver))
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
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void popUpOK()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            WebElement OkButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
            if(OkButton.isDisplayed() && OkButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,OkButton,1000);
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

    public void validateNewPermissionAdded()
    {
        exists=false;
        Actions actions=new Actions(driver);
        try
        {
            List<WebElement> roleNames=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
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

    public void validateConfirmationPopup()
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
            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okPopUp=dialogPopup.findElement(By.xpath(".//button[contains(@id,'QuestionModalButton')]"));
                HelpersMethod.JScriptClick(driver,okPopUp,40000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
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

    public void clickOnRoleDropdown()
    {
        exists=false;
        try
        {
            WebElement dropDownRoleEdit=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[contains(@class,'k-icon k-i-arrow-s')]");
            HelpersMethod.ActClick(driver,dropDownRoleEdit,200);
        }
        catch (Exception e){}
    }

    public void selectRoleForEditing()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> roles=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
            for (WebElement role:roles)
            {
                act.moveToElement(role).build().perform();
                String roleText=role.getText();
                if(roleText.equals(roleName))
                {
                    act.moveToElement(role).build().perform();
                    act.click(role).build().perform();
                    exists=true;
                    scenario.log("ROLE SELECTED FOR EDITING IS "+roleText);
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOkbuttonInEditRolePopup1()
    {
        exists=false;
        try
        {
            WebElement OkButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[@id='buttonOk']");
            if(OkButton.isDisplayed() && OkButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,OkButton,100);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateEditRole1popup()
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

    public void changeDescriptionEditRolepopup()
    {
        exists=false;
        description= RandomValues.generateRandomString(25);
        try
        {
            WebElement descriptionEle=HelpersMethod.FindByElement(driver,"id","role-description");
            scenario.log(HelpersMethod.JSGetValueEle(driver,descriptionEle,100)+" IS THE DESCRIPTION FOUND");

            HelpersMethod.ActClearKey(driver,descriptionEle,100);
            HelpersMethod.ActSendKey(driver,descriptionEle,100,description);
            exists=true;
            scenario.log(HelpersMethod.JSGetValueEle(driver,descriptionEle,100)+" IS THE DESCRIPTION FOUND AFTER EDIT");
            Assert.assertEquals(exists,true);
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

    public void clickOnCopyButton() 
    {
        exists=false;
        try
        {
            if(copySymbol.isDisplayed() && copySymbol.isEnabled())
            {
                HelpersMethod.ClickBut(driver,copySymbol,100);
                scenario.log("COPY BUTTON HAS BEEN CLICKED");
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCopyPermissionPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Copy permissions')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {

                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnFromCompany()
    {
        try
        {
            WebElement fromComp=HelpersMethod.FindByElement(driver,"xpath","//label[@id='RoleCompaniesFrom-label']/following-sibling::span/descendant::span[@class='k-icon k-i-arrow-s']");
            HelpersMethod.ActClick(driver,fromComp,200);
        }
        catch (Exception e){}
    }

    public void selectFromCompany()
    {
        exists=false;
        Actions act=new Actions(driver);
        WebElement WebEle = null;
        WebElement WebEle1=null;
        String Val_Text=null;
        int i=0;
        try
        {
            //identify the company drop down, and values in list
            List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
            for (WebElement Val : Values)
            {
                act.moveToElement(Val).build().perform();
                Val_Text = Val.getText();
                if (Val_Text.equalsIgnoreCase(company))
                {
                    WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li[contains(text(),'" + company + "')]");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Val);
                    act.moveToElement(WebEle1).build().perform();
                    act.moveToElement(WebEle1).click(WebEle1).build().perform();
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                    }
                    exists = true;
                    break;
                }
            }
            WebEle=HelpersMethod.FindByElement(driver,"id","RoleCompaniesFrom");
            scenario.log("COMPANY ACCOUNT# SELECTED FOR 'FROM COMPANY' IS "+HelpersMethod.JSGetValueEle(driver,WebEle,100));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnFromRole()
    {
        try
        {
            WebElement fromComp=HelpersMethod.FindByElement(driver,"xpath","//label[@id='RoleRolesFrom-label']/following-sibling::span/descendant::span[@class='k-icon k-i-arrow-s']");
            HelpersMethod.ActClick(driver,fromComp,200);
        }
        catch (Exception e){}
    }

    public void selectFromRole(String arg0)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li[contains(@class,'k-item')]");
            for (WebElement Val : Values)
            {
                act.moveToElement(Val).build().perform();
                String Val_Text = Val.getText();
                if(Val_Text.equals(arg0))
                {
                    act.moveToElement(Val).build().perform();
                    act.click(Val).build().perform();
                    exists=true;
                    break;
                }
            }
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","RoleRolesFrom");
            scenario.log("'FROM' ROLE SELECTED IS "+HelpersMethod.JSGetValueEle(driver,WebEle,100));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnToCompany()
    {
        try
        {
            WebElement fromComp=HelpersMethod.FindByElement(driver,"xpath","//label[@id='RoleCompaniesTo-label']/following-sibling::span/descendant::span[@class='k-icon k-i-arrow-s']");
            HelpersMethod.ActClick(driver,fromComp,200);
        }
        catch (Exception e){}
    }

    public void selectToCompany()
    {
        exists=false;
        Actions act=new Actions(driver);
        WebElement WebEle;
        WebElement WebEle1;
        String Val_Text;
        try
        {
            List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li");
            for (WebElement Val : Values)
            {
                act.moveToElement(Val).build().perform();
                Val_Text = Val.getText();
                if (Val_Text.equalsIgnoreCase(company))
                {
                    WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li[contains(text(),'" + company + "')]");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Val);
                    act.moveToElement(WebEle1).build().perform();
                    act.moveToElement(WebEle1).click(WebEle1).build().perform();
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
                    }
                    exists = true;
                    break;
                }
            }

            WebEle=HelpersMethod.FindByElement(driver,"id","RoleCompaniesFrom");
            scenario.log("COMPANY ACCOUNT# SELECTED FOR 'FROM COMPANY' IS "+HelpersMethod.JSGetValueEle(driver,WebEle,100));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnToRole()
    {
        try
        {
            WebElement fromComp=HelpersMethod.FindByElement(driver,"xpath","//label[@id='RoleRolesTo-label']/following-sibling::span/descendant::span[@class='k-icon k-i-arrow-s']");
            HelpersMethod.ActClick(driver,fromComp,200);
        }
        catch (Exception e){}
    }

    public void selectToRole()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li[contains(@class,'k-item')]");
            for (WebElement Val : Values)
            {
                act.moveToElement(Val).build().perform();
                String Val_Text = Val.getText();
                if(Val_Text.equals(roleName))
                {
                    act.moveToElement(Val).build().perform();
                    act.click(Val).build().perform();
                    exists=true;
                    break;
                }
            }
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","RoleRolesTo");
            scenario.log("'TO' ROLE SELECTED IS "+HelpersMethod.JSGetValueEle(driver,WebEle,100));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnCopyPermissionButton()
    {
        exists=false;
        try
        {
            WebElement copyPermissionButton=HelpersMethod.FindByElement(driver,"id","CopyPermsBtn");
            HelpersMethod.ActClick(driver,copyPermissionButton,2000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }

            scenario.log("CLICKED ON COPY PERMISSION BUTTON");
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void copyPermissionToPopup()
    {
        exists=false;
        try
        {
            //new WebDriverWait(driver,8000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Copy permissions to')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]"))));
            if(HelpersMethod.IsExists("//div[contains(text(),'Copy permissions to')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement yesButton=HelpersMethod.FindByElement(driver,"id","CopyPermsYesBtn");
                HelpersMethod.ActClick(driver,yesButton,10000);
                exists=true;
                scenario.log("COPY PERMISSION HAS BEEN DONE");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void searchAdminSettingInSearchBar(String searchValue)
    {
        exists=false;
        try
        {
            WebElement searchBox= HelpersMethod.FindByElement(driver,"id","SearchBarPermissionsTree");
            HelpersMethod.sendKeys(driver,searchBox,600,searchValue);
            scenario.log("ADMIN SETTING ENTERED FOR SEARCH IS "+ HelpersMethod.JSGetValueEle(driver,searchBox,200));
            WebElement searchIndex=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'SearchBarPermissionsTree')]/ancestor::div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
            HelpersMethod.ActClick(driver,searchIndex,200);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void validateAdminSettingSearchValue(String searchValue)
    {
        exists=false;
        try
        {
            String adminSet=HelpersMethod.FindByElement(driver,"xpath","//input[@class='k-checkbox']/ancestor::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']").getText();
            if(adminSet.equals(searchValue))
            {
                scenario.log("VALUE SEARCHED HAS BEEN FOUND "+adminSet);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void searchAdminSettingInSearchBarClear()
    {
        exists=false;
        try
        {
            WebElement searchIndex=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'SearchBarPermissionsTree')]/ancestor::div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'i-search-box__clear')]");
            HelpersMethod.ActClick(driver,searchIndex,200);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void compareEnabledPermissions(String arg0)
    {
        exists=false;
        int a=0;
        int b=0;
        int i=0;
        int j=0;
        String headText=null;
        List<String> copyPermission=new ArrayList<>();
        List<String> copiedPermission=new ArrayList<>();
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for (WebElement head:tableHeads)
            {
                a++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equals(arg0))
                {
                    break;
                }
            }
            for (WebElement head:tableHeads)
            {
                b++;
                act.moveToElement(head).build().perform();
                headText=head.getText();
                if(headText.equals(roleName))
                {
                    break;
                }
            }
            List<WebElement> firstCheckBox=HelpersMethod.FindByElements(driver,"xpath","//tr[@aria-expanded='false']/descendant::td["+a+"]/input");
            for(WebElement fCheckBox:firstCheckBox)
            {
                i++;
                act.moveToElement(fCheckBox).build().perform();
                if(fCheckBox.isSelected())
                {
                    copyPermission.add(HelpersMethod.FindByElement(driver,"xpath","//tr[@aria-expanded='false']["+i+"]/descendant::div[@class='label-containerX']").getText());
                }
            }
            List<WebElement> secondCheckBox=HelpersMethod.FindByElements(driver,"xpath","//tr[@aria-expanded='false']/descendant::td["+b+"]/input");
            for(WebElement sCheckBox:secondCheckBox)
            {
                j++;
                act.moveToElement(sCheckBox).build().perform();
                if(sCheckBox.isSelected())
                {
                    copiedPermission.add(HelpersMethod.FindByElement(driver,"xpath","//tr[@aria-expanded='false']["+j+"]/descendant::div[@class='label-containerX']").getText());
                }
            }
            if(copyPermission.equals(copiedPermission))
            {
                scenario.log("SUCCESSFULLY COPEIED ADMIN PERMISSION FROM "+arg0+"TO "+roleName);
                exists=true;
            }
            else
            {
                scenario.log("COPYING OF ADMIN PERMISSION FROM "+arg0+"TO "+roleName+" WAS NOT SUCESSFULL");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void confirmationPopup1()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you wish to copy')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=false;
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Are you sure you wish to copy')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement yesButton=dialogPopup.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ClickBut(driver,yesButton,100);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }
}
