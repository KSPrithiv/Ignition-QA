package pages_DSD_OMS.adminSecurity;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.messages.internal.com.google.protobuf.util.Values;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
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
    //static String roleNameText;

    @FindBy(id = "AddBtn")
    private WebElement plusSymbol;

    @FindBy(id="SearchBarPermissionsTree")
    private WebElement searchBar;

    @FindBy(xpath="//div[@class='i-grid-searchbar ']//*[local-name()='svg' and @class='i-icon i-icon--base i-search-box__search']")
    private WebElement searchIndex;

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
        Assert.assertTrue(exists);
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
            Assert.assertTrue(exists);
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
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validateAddUserToTable()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Add user to table')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickRole()
    {
        exists=false;
        try
        {
            WebElement role=HelpersMethod.FindByElement(driver,"xpath","//input[@id='comboBoxAddUserRole']/following-sibling::button//*[local-name()='svg']");
            HelpersMethod.ActClick(driver,role,10000);
        }
        catch (Exception e){}
    }

    public void selectRole(String roleName)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='comboBoxAddUserRolelist']/li/span");
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
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));


            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","comboBoxAddUserRole");
            scenario.log("ROLE SELECTED IS "+HelpersMethod.JSGetValueEle(driver,WebEle,10000));
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickUser()
    {
        exists=false;
        try
        {
            //if already user is selected we need to clear that, for that below code is
            if(HelpersMethod.IsExists("//input[@id='comboBoxAddUser']/following-sibling::span[@title='clear']",driver))
            {
                WebElement closeEle=HelpersMethod.FindByElement(driver,"xpath","//input[@id='comboBoxAddUser']/following-sibling::span[@title='clear']");
                HelpersMethod.ActClick(driver,closeEle,10000);
            }
            //to select the user we need to click on drop down
            if(HelpersMethod.IsExists("//input[@id='comboBoxAddUser']/following-sibling::button//*[local-name()='svg']",driver))
            {
                WebElement user=HelpersMethod.FindByElement(driver,"xpath","//input[@id='comboBoxAddUser']/following-sibling::button//*[local-name()='svg']");
                HelpersMethod.ActClick(driver, user, 10000);
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void selectUser()
    {
        exists=false;
        WebElement Val;
        WebElement WebEle1, WebEle;
        Actions act=new Actions(driver);
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='comboBoxAddUserlist']/li/span")));
            if(HelpersMethod.IsExists("//ul[@id='comboBoxAddUserlist']/li/span",driver))
            {
                List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='comboBoxAddUserlist']/li/span");
                for(int i = 1; i<= Values.size()-1; i++)
                {
                    Val=Values.get(i);
                    act.moveToElement(Val).build().perform();
                    if(i==1)
                    {
                        WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "//ul[@id='comboBoxAddUserlist']/li["+i+"]/span");
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Val);
                        act.moveToElement(WebEle1).build().perform();
                        act.moveToElement(WebEle1).click(WebEle1).build().perform();
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                        }
                        exists = true;
                        break;
                    }
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
            WebEle=HelpersMethod.FindByElement(driver,"id","comboBoxAddUser");
            scenario.log("ROLE SELECTED IS "+HelpersMethod.JSGetValueEle(driver,WebEle,10000));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateUser()
    {
        exists=false;
        try
        {
            WebElement userSelected=HelpersMethod.FindByElement(driver,"id","comboBoxAddUser");
            String userText=HelpersMethod.AttributeValue(userSelected,"value");
            scenario.log("USER SELECTED IS "+userText);
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
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
            }
            Assert.assertTrue(exists);
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
        Assert.assertTrue(exists);
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
            Assert.assertTrue(exists);
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
        Assert.assertTrue(exists);
    }


    public void validateGridHeader(String roleNameText)
    {
        exists=false;
        String headText;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> headers=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for (WebElement heads:headers)
            {
                act.moveToElement(heads).build().perform();
                headText=heads.getText();
                if(headText.equals(roleNameText))
                {
                    exists=true;
                    break;
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnModulesDropdown()
    {
        exists=true;
        try
        {
            /*/following-sibling::* selects All the following siblings, of any tag name. But this selects all the following siblings, not only adjacent following siblings. To make this precise [1] index added.*/
            if(HelpersMethod.IsExists("//span[contains(text(),'In modules')]/following-sibling::*[1]/descendant::input",driver))
            {
                WebElement modulesInput=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'In modules')]/following-sibling::*[1]/descendant::input");
                HelpersMethod.ActClick(driver,modulesInput,1000);
                new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-list-container')]/descendant::ul/li")));
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void readModulesEnabled()
    {
        exists=false;
        String checkBoxText;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input",driver))
            {
                scenario.log("ROLES SELECTED ARE AS FOLLOWS: ");
                List<WebElement> checkBoxList=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input");
                for(int i=0;i<=checkBoxList.size()-1;i++)
                {
                    if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input[@checked]",driver))
                    {
                        checkBoxText=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input[@checked]/following-sibling::label").getText();
                        scenario.log(checkBoxText);
                        exists=true;
                    }
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }
}
