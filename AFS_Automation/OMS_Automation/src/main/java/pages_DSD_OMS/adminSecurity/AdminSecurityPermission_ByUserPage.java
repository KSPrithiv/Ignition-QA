package pages_DSD_OMS.adminSecurity;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class AdminSecurityPermission_ByUserPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String roleName=null;
    static String description=null;

    @FindBy(id = "AddBtn")
    private WebElement plusSymbol;

    public AdminSecurityPermission_ByUserPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void navigateToByUser()
    {
        exists=false;
        try
        {
            HelpersMethod.navigate_Horizantal_Tab(driver, "By user", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'By user')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
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
                HelpersMethod.ClickBut(driver,plusSymbol,1000);
                scenario.log("CREATING NEW ROLE FROM ROLE TAB");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAddUserToTable()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Add user to table')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickRole()
    {
        exists=false;
        try
        {
            WebElement role=HelpersMethod.FindByElement(driver,"xpath","//input[@id='comboBoxAddUserRole']/ancestor::span[@class='k-dropdown-wrap']/descendant::span[contains(@class,'k-icon k-i-arrow-s')]");
            HelpersMethod.ActClick(driver,role,1000);
        }
        catch (Exception e){}
    }

    public void selectRole(String roleName)
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
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","comboBoxAddUserRole");
            scenario.log("ROLE SELECTED IS "+HelpersMethod.JSGetValueEle(driver,WebEle,100));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickUser()
    {
        exists=false;
        try
        {
            WebElement role=HelpersMethod.FindByElement(driver,"xpath","//input[@id='comboBoxAddUser']/ancestor::span[@class='k-dropdown-wrap']/descendant::span[contains(@class,'k-icon k-i-arrow-s')]");
            HelpersMethod.ActClick(driver,role,1000);
        }
        catch (Exception e){}
    }

    public void selectUser(String userName)
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
                if(Val_Text.equalsIgnoreCase(userName))
                {
                    act.moveToElement(Val).build().perform();
                    act.click(Val).build().perform();
                    exists=true;
                    break;
                }
            }
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","comboBoxAddUser");
            scenario.log("ROLE SELECTED IS "+HelpersMethod.JSGetValueEle(driver,WebEle,100));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnOkButton()
    {
        exists=false;
        try
        {
            WebElement okButton=HelpersMethod.FindByElement(driver,"id","buttonOk");
            if(okButton.isDisplayed() && okButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,okButton,1000);
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

    public void searchAdminSettingInSearchBar(String searchValue)
    {
        exists=false;
        try
        {
            WebElement searchBox= HelpersMethod.FindByElement(driver,"id","SearchBarPermissionsTree");
            HelpersMethod.sendKeys(driver,searchBox,1000,searchValue);
            scenario.log("ADMIN SETTING ENTERED FOR SEARCH IS "+ HelpersMethod.JSGetValueEle(driver,searchBox,200));
            WebElement searchIndex=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'SearchBarPermissionsTree')]/ancestor::div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
            HelpersMethod.ActClick(driver,searchIndex,1000);
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
            HelpersMethod.ActClick(driver,searchIndex,1000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }
}
