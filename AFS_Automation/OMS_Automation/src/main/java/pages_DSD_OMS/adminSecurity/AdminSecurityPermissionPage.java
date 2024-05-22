package pages_DSD_OMS.adminSecurity;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en_old.Ac;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.apache.poi.hssf.record.SCLRecord;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import util.RandomValues;
import util.TestBase;

import java.time.Duration;
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
    static String roleName;
    static String description;
    static String disabledRole;
    static  String enabledRoles;
    static String company = TestBase.testEnvironment.get_CompanyNo();
    static ArrayList<String> adminGrid= new ArrayList<>();
    static ArrayList<String> adminGrid1=new ArrayList<>();
    static ArrayList<String> adminGrid2=new ArrayList<>();

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
                HelpersMethod.ClickBut(driver,plusSymbol,10000);
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
            HelpersMethod.ActSendKey(driver,roleNameEle,10000,roleName);
            scenario.log("ROLE NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,roleNameEle,10000));
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
            HelpersMethod.ActSendKey(driver,descriptionEle,10000,description);
            scenario.log("DESCRIPTION ENTERED IS "+HelpersMethod.JSGetValueEle(driver,descriptionEle,10000));
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

            if(HelpersMethod.IsExists("//ul[@id='manageable-roleslist']/li",driver))
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
            HelpersMethod.ActClick(driver,manageRole,10000);
            WebElement rName=HelpersMethod.FindByElement(driver,"xpath","//div[@id='tagslist-manageable-roles']/descendant::span[@class='k-chip-label']");
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            WebElement OkButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='OK']");
            if(OkButton.isDisplayed() && OkButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,OkButton,10000);
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(250))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement savePopup= HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=savePopup.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,10000);
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@id='dialogTextContent']/ancestor::div[@class='k-window k-dialog']",driver))
            {
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[@id='dialogTextContent']/ancestor::div[@class='k-window k-dialog']");
                WebElement okPopUp=dialogPopup.findElement(By.xpath(".//button[contains(@id,'QuestionModalButton')]"));
                HelpersMethod.JScriptClick(driver,okPopUp,40000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(250))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
            if(HelpersMethod.IsExists("//span[contains(text(),'Edit role')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver));
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
           if(HelpersMethod.IsExists("//input[@id='comboBoxEditRole']/following-sibling::button//*[local-name()='svg']",driver))
           {
               HelpersMethod.FindByElement(driver, "xpath", "//input[@id='comboBoxEditRole']/following-sibling::button//*[local-name()='svg']").click();
               exists=true;
           }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectRoleForEditing()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//ul[@id='comboBoxEditRolelist']/li/span",driver))
            {
                List<WebElement> roles = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='comboBoxEditRolelist']/li/span");
                for (WebElement role : roles)
                {
                    act.moveToElement(role).build().perform();
                    String roleText = role.getText();
                    if (roleText.equals(roleName))
                    {
                        act.moveToElement(role).build().perform();
                        act.click(role).build().perform();
                        exists = true;
                        scenario.log("ROLE SELECTED FOR EDITING IS " + roleText);
                        break;
                    }
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
            WebElement OkButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button[@id='buttonOk']");
            if(OkButton.isDisplayed() && OkButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,OkButton,10000);
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(250))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
            if(HelpersMethod.IsExists("//div[contains(text(),'Edit role')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver));
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
            scenario.log(HelpersMethod.JSGetValueEle(driver,descriptionEle,10000)+" IS THE DESCRIPTION FOUND");

            HelpersMethod.ActClearKey(driver,descriptionEle,10000);
            HelpersMethod.ActSendKey(driver,descriptionEle,10000,description);
            exists=true;
            scenario.log(HelpersMethod.JSGetValueEle(driver,descriptionEle,10000)+" IS THE DESCRIPTION FOUND AFTER EDIT");
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOkbuttonInEditRolePopup()
    {
        exists=false;
        try
        {
            WebElement OkButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button/span[text()='OK']");
            if(OkButton.isDisplayed() && OkButton.isEnabled())
            {
                HelpersMethod.ActClick(driver,OkButton,10000);
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(250))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
                HelpersMethod.ClickBut(driver,copySymbol,10000);
                scenario.log("COPY BUTTON HAS BEEN CLICKED");
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(250))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Copy permissions')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Copy permissions')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
            if(HelpersMethod.IsExists("//span[contains(text(),'Copy permissions')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement copyPermission=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Copy permissions')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement copyPerButton=copyPermission.findElement(By.xpath(".//button[@id='CopyPermsBtn']"));
                HelpersMethod.ClickBut(driver,copyPerButton,10000);
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
            WebElement fromComp=HelpersMethod.FindByElement(driver,"xpath","//input[@id='RoleCompaniesFrom']/following-sibling::button//*[local-name()='svg']");
            HelpersMethod.ActClick(driver,fromComp,10000);
        }
        catch (Exception e){}
    }

    public void selectFromCompany()
    {
        exists=false;
        Actions act=new Actions(driver);
        WebElement WebEle;
        WebElement WebEle1;
        String Val_Text="";
        int i=0;
        try
        {
            //identify the company drop down, and values in list
            List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='RoleCompaniesFromlist']/li/span");
            for (WebElement Val : Values)
            {
                act.moveToElement(Val).build().perform();
                Val_Text = Val.getText();
                if (Val_Text.equalsIgnoreCase(company))
                {
                    WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "//ul[@id='RoleCompaniesFromlist']/li/span[contains(text(),'" + company + "')]");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Val);
                    act.moveToElement(WebEle1).build().perform();
                    act.moveToElement(WebEle1).click(WebEle1).build().perform();
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(250))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    exists = true;
                    break;
                }
            }
            WebEle=HelpersMethod.FindByElement(driver,"id","RoleCompaniesFrom");
            scenario.log("COMPANY ACCOUNT# SELECTED FOR 'FROM COMPANY' IS "+HelpersMethod.JSGetValueEle(driver,WebEle,10000));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnFromRole()
    {
        try
        {
            WebElement fromComp=HelpersMethod.FindByElement(driver,"xpath","//input[@id='RoleRolesFrom']/following-sibling::button//*[local-name()='svg']");
            HelpersMethod.ActClick(driver,fromComp,10000);
        }
        catch (Exception e){}
    }

    public void selectFromRole(String arg0)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//ul[@id='RoleRolesFromlist']/li/span",driver))
            {
               List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='RoleRolesFromlist']/li/span");
               for (WebElement Val : Values)
               {
                   act.moveToElement(Val).build().perform();
                   String Val_Text = Val.getText();
                   if (Val_Text.equals(arg0))
                   {
                       act.moveToElement(Val).build().perform();
                       act.click(Val).build().perform();
                       exists = true;
                       break;
                   }
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
        exists=false;
        try
        {
           if(HelpersMethod.IsExists("//input[@id='RoleCompaniesTo']/following-sibling::button//*[local-name()='svg']",driver))
           {
               WebElement fromComp = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='RoleCompaniesTo']/following-sibling::button//*[local-name()='svg']");
               HelpersMethod.ActClick(driver, fromComp, 10000);
               exists=true;
           }
           Assert.assertEquals(exists,true);
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
              List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='RoleCompaniesTolist']/li/span");
              for (WebElement Val : Values)
              {
                  act.moveToElement(Val).build().perform();
                  Val_Text = Val.getText();
                  if (Val_Text.equalsIgnoreCase(company))
                  {
                      WebEle1 = HelpersMethod.FindByElement(driver, "xpath", "//ul[@id='RoleCompaniesTolist']/li/span[contains(text(),'" + company + "')]");
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

            WebEle=HelpersMethod.FindByElement(driver,"id","RoleCompaniesTo");
            scenario.log("COMPANY ACCOUNT# SELECTED FOR 'FROM COMPANY' IS "+HelpersMethod.JSGetValueEle(driver,WebEle,100));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnToRole()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//input[@id='RoleRolesTo']/following-sibling::button//*[local-name()='svg']",driver))
            {
                WebElement fromComp = HelpersMethod.FindByElement(driver, "xpath", "//input[@id='RoleRolesTo']/following-sibling::button//*[local-name()='svg']");
                HelpersMethod.ActClick(driver, fromComp, 10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectToRole()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//ul[@id='RoleRolesTolist']/li/span",driver))
            {
               List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//ul[@id='RoleRolesTolist']/li/span");
               for (WebElement Val : Values)
               {
                   act.moveToElement(Val).build().perform();
                   String Val_Text = Val.getText();
                   if (Val_Text.equals(roleName))
                   {
                       act.moveToElement(Val).build().perform();
                       act.click(Val).build().perform();
                       exists = true;
                       break;
                   }
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
            HelpersMethod.ActClick(driver,copyPermissionButton,10000);
            exists=true;

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

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
            //new WebDriverWait(driver,8000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Copy permissions to')]/ancestor::div[contains(@class,'k-window k-dialog')]"))));
            if(HelpersMethod.IsExists("//span[contains(text(),'Copy permissions to')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement copyPopup=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Copy permissions to')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement yesButton=copyPopup.findElement(By.xpath(".//button[@id='CopyPermsYesBtn']"));
                HelpersMethod.ActClick(driver,yesButton,10000);
                exists=true;
                scenario.log("COPY PERMISSION HAS BEEN DONE");
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(250))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(250))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//input[@id='SearchBarPermissionsTree']/ancestor::div[@class='i-search-box']",driver))
            {
                WebElement searchBox = HelpersMethod.FindByElement(driver, "id", "SearchBarPermissionsTree");
                HelpersMethod.sendKeys(driver, searchBox, 10000, searchValue);
                scenario.log("ADMIN SETTING ENTERED FOR SEARCH IS " + HelpersMethod.JSGetValueEle(driver, searchBox, 10000));
                WebElement searchIndex = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'SearchBarPermissionsTree')]/ancestor::div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'i-search-box__search')]");
                HelpersMethod.ActClick(driver, searchIndex, 10000);
                exists = true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validateAdminSettingSearchValue(String searchValue)
    {
        exists=false;
        try
        {
            WebElement adminSet=HelpersMethod.FindByElement(driver,"xpath","//input[@class='k-checkbox']/ancestor::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']");
            String adminSetText=HelpersMethod.AttributeValue(adminSet,"title");
            if(adminSetText.equalsIgnoreCase(searchValue))
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
            if(HelpersMethod.IsExists("//input[contains(@id,'SearchBarPermissionsTree')]/ancestor::div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'i-search-box__clear')]",driver))
            {
                WebElement searchIndex = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@id,'SearchBarPermissionsTree')]/ancestor::div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'i-search-box__clear')]");
                HelpersMethod.ActClick(driver, searchIndex, 10000);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
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
            if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you wish to copy')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=false;
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Are you sure you wish to copy')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement yesButton=dialogPopup.findElement(By.xpath(".//button/span[text()='Yes']"));
                HelpersMethod.ActClick(driver,yesButton,10000);
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(250))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }

    public void clickOnInModules()
    {
        exists=true;
        try
        {
            HelpersMethod.ScrollUpScrollBar(driver);
            /*/following-sibling::* selects All the following siblings, of any tag name. But this selects all the following siblings, not only adjacent following siblings. To make this precise [1] index added.*/
            if(HelpersMethod.IsExists("//span[contains(text(),'In modules')]/following-sibling::*[1]/descendant::input",driver))
            {
                WebElement modulesInput=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'In modules')]/following-sibling::*[1]/descendant::input");
                HelpersMethod.ScrollElement(driver,modulesInput);
                HelpersMethod.ActClick(driver,modulesInput,10000);
                new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-list-container')]/descendant::ul/li")));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllModulesSelected()
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
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnInRoles()
    {
        exists=true;
        try
        {
            /*/following-sibling::* selects All the following siblings, of any tag name. But this selects all the following siblings, not only adjacent following siblings. To make this precise [1] index added.*/
            if(HelpersMethod.IsExists("//span[contains(text(),'In roles')]/following-sibling::*[1]/descendant::input",driver))
            {
                WebElement rolesInput=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'In roles')]/following-sibling::*[1]/descendant::input");
                HelpersMethod.ActClick(driver,rolesInput,10000);
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-list-container')]/descendant::ul/li")));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllRolesSelected()
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

    public void disableRoles()
    {
        exists=false;
        WebElement disRole;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input",driver))
            {
                List<WebElement> checkBoxList=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input");
                for(int i=0;i<=checkBoxList.size()-1;i++)
                {
                    if(i== checkBoxList.size()-1)
                    {
                          disabledRole=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input[@checked]/following-sibling::label/span").getText();
                          scenario.log("ROLE THAT HAS BEEN DISABLED IS "+disabledRole);
                          disRole=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input");
                          HelpersMethod.ActClick(driver,disRole,10000);
                          exists=true;
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyRolesGrid()
    {
        exists=true;
        Actions act=new Actions(driver);
        String headText;
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement tableHead:tableHeads)
            {
                act.moveToElement(tableHead).build().perform();
                headText=tableHead.getText();
                if(headText.equals(disabledRole))
                {
                    exists=false;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enableRoles()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input",driver))
            {
                List<WebElement> checkBoxList=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input");
                for(int i=0;i<=checkBoxList.size()-1;i++)
                {
                    if(i== checkBoxList.size()-1)
                    {
                        enabledRoles=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input[@checked]/following-sibling::label/span").getText();
                        scenario.log("ROLE THAT HAS BEEN DISABLED IS "+disabledRole);
                        WebElement enRole=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input");
                        HelpersMethod.ActClick(driver,enRole,10000);
                        exists=true;
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void verifyRolesGridForEnabled()
    {
        exists=false;
        Actions act=new Actions(driver);
        String headText="";
        try
        {
            List<WebElement> tableHeads=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-column-title']");
            for(WebElement tableHead:tableHeads)
            {
                act.moveToElement(tableHead).build().perform();
                headText=tableHead.getText();
                if(headText.equals(enabledRoles))
                {
                    exists=true;
                }
            }
            Assert.assertTrue(exists);Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void disableModules(String module)
    {
        exists=false;
        String checkBoxText=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input",driver))
            {
                scenario.log("ADMIN SETTING AFTER DISABLING MODULES");
                List<WebElement> checkBoxList=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input");
                for(int i=0;i<=checkBoxList.size()-1;i++)
                {
                    if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input[@checked]",driver))
                    {
                        checkBoxText=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input[@checked]/following-sibling::label/span").getText();
                        if(module.equalsIgnoreCase(checkBoxText))
                        {
                            WebElement checkBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input[@checked]");
                            HelpersMethod.ActClick(driver,checkBox,10000);
                            exists=true;
                            break;
                        }
                    }
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void enabledModules(String module)
    {
        exists=false;
        String checkBoxText=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input",driver))
            {
                scenario.log("ENABLING MODULE");
                List<WebElement> checkBoxList=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li/descendant::input");
                for(int i=0;i<=checkBoxList.size()-1;i++)
                {
                    if(HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input",driver))
                    {
                        checkBoxText=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input/following-sibling::label/span").getText();
                        if(module.equalsIgnoreCase(checkBoxText))
                        {
                            WebElement checkBox=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li["+(i+1)+"]/descendant::input");
                            HelpersMethod.ActClick(driver,checkBox,10000);
                            exists=true;
                            break;
                        }
                    }
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void readAllAdminSettings()
    {
        exists=false;
        Actions act=new Actions(driver);
        String adminText="";
        try
        {
            if(HelpersMethod.IsExists("//span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']",driver))
            {
                scenario.log("ADMIN SETTING AVAILABLE IN GRID =>");
                List<WebElement> adminSettingList = HelpersMethod.FindByElements(driver, "xpath", "//span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']");
                for (WebElement adminSet : adminSettingList)
                {
                    act.moveToElement(adminSet).build().perform();
                    adminText = adminSet.getText();
                    adminGrid.add(adminText);
                    scenario.log(adminText);
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void readAllAdminSettingsAfterDisable()
    {
        exists=false;
        Actions act=new Actions(driver);
        String adminText=null;
        try
        {
            if(HelpersMethod.IsExists("//span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']",driver))
            {
                scenario.log("ADMIN SETTING AVAILABLE IN GRID AFTER DISABLING SETTING=> ");
                List<WebElement> adminSettingList = HelpersMethod.FindByElements(driver, "xpath", "//span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']");
                for (WebElement adminSet : adminSettingList)
                {
                    act.moveToElement(adminSet).build().perform();
                    adminText = adminSet.getText();
                    adminGrid1.add(adminText);
                    scenario.log(adminText);
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validateAdminSettingAfterDisable()
    {
        exists=false;
        try
        {
            if(adminGrid.equals(adminGrid1))
            {
                scenario.log("ADMIN SETTING IS STILL ENABLED");
                exists=false;
            }
            else
            {
                scenario.log("ADMIN SETTING IS NOT DISPLAYED");
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void readAllAdminSettingsAfterEnabling()
    {
        exists=false;
        Actions act=new Actions(driver);
        String adminText=null;
        try
        {
            if(HelpersMethod.IsExists("//span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']",driver))
            {
                scenario.log("ADMIN SETTING AVAILABLE IN GRID AFTER ENABLING SETTING=> ");
                List<WebElement> adminSettingList = HelpersMethod.FindByElements(driver, "xpath", "//span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']");
                for (WebElement adminSet : adminSettingList)
                {
                    act.moveToElement(adminSet).build().perform();
                    adminText = adminSet.getText();
                    adminGrid1.add(adminText);
                    scenario.log(adminText);
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validateAdminSettingAfterEnabling()
    {
        exists=false;
        try
        {
            if(adminGrid.equals(adminGrid2))
            {
                scenario.log("ADMIN SETTING IS STILL ENABLED");
                exists=false;
            }
            else
            {
                scenario.log("ADMIN SETTING IS NOT DISPLAYED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllAdminSettingsAndDropDownArrow()
    {
        exists=false;
        Actions act=new Actions(driver);
        String adminText=null;
        try
        {
            if(HelpersMethod.IsExists("//tr[@aria-expanded='true']/descendant::span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']|//tr[@aria-expanded='false']/descendant::span[@class='k-icon k-i-expand']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']",driver))
            {
                scenario.log("ADMIN SETTING AVAILABLE IN GRID =>");
                List<WebElement> adminSettingList = HelpersMethod.FindByElements(driver, "xpath", "//tr[@aria-expanded='true']/descendant::span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']|//tr[@aria-expanded='false']/descendant::span[@class='k-icon k-i-expand']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']");
                for (WebElement adminSet : adminSettingList)
                {
                    act.moveToElement(adminSet).build().perform();
                    adminText = adminSet.getText();
                    adminGrid.add(adminText);
                    scenario.log(adminText);
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyColapsedDropDownWhenPageloaded()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//tr[@aria-expanded='false']/descendant::span[@class='k-icon k-i-expand']",driver))
            {
                scenario.log("NONE OF THE ADMIN SETTINGS DROP DOWNS ARE COLLAPSED");
                exists=false;
            }
            else if(!HelpersMethod.IsExists("//tr[@aria-expanded='false']/descendant::span[@class='k-icon k-i-expand']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void expandedDropDownCollaps()
    {
        exists=false;
        Actions act=new Actions(driver);
        String adminText=null;
        int i=0;
        try
        {
            if(HelpersMethod.IsExists("//tr[@aria-expanded='true']/descendant::span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']",driver))
            {
                scenario.log("ADMIN SETTING AVAILABLE IN GRID =>");

                //Arrow button in admin setting and disable first arrow button
                List<WebElement> adminSettingArrows=HelpersMethod.FindByElements(driver,"xpath","//tr[@aria-expanded='true']/descendant::span[@class='k-icon k-i-collapse']");
                for( i=1;i<=adminSettingArrows.size()-1;i++)
                {
                    if(i==1)
                    {
                        WebElement arrow1 = HelpersMethod.FindByElement(driver, "xpath", "//tr[@aria-expanded='true'][" + i + "]/descendant::span[@class='k-icon k-i-collapse']");
                        HelpersMethod.ActClick(driver, arrow1, 10000);
                        String collapsedSetting = HelpersMethod.FindByElement(driver, "xpath", "//tr["+i+"]/descendant::span[@class='k-icon k-i-expand']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']").getText();
                        scenario.log("ADMIN SETTING COLLAPSED"+collapsedSetting);
                        break;
                    }
                }

                scenario.log("ADMIN SETTING EXPANDED: ");
                List<WebElement> adminSettingList = HelpersMethod.FindByElements(driver, "xpath", "//tr[@aria-expanded='true']/descendant::span[@class='k-icon k-i-collapse']/following-sibling::div[contains(@class,'admin-control-table')]/descendant::div[@class='label-containerX']");
                for (WebElement adminSet : adminSettingList)
                {
                    act.moveToElement(adminSet).build().perform();
                    adminText = adminSet.getText();
                    adminGrid.add(adminText);
                    scenario.log(adminText);
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void uncheckCheckbox(String id)
    {
        exists=true;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//input[@id='"+id+"' and @data-checked='checked']|//input[@id='"+id+"' and @data-checked='indeterminate']",driver))
            {
                WebElement checkBox=HelpersMethod.FindByElement(driver,"xpath","//input[@id='"+id+"' and @data-checked='checked']|//input[@id='"+id+"' and @data-checked='indeterminate']");
                //HelpersMethod.ActClick(driver,checkBox,10000);
                act.moveToElement(checkBox).build().perform();
                act.click(checkBox).build().perform();
                scenario.log("CHECKBOX HAS BEEN UNCHECKED");
                exists=true;
            }
            else
            {
                scenario.log("CHECKBOX HAS NOT BEEN FOUND");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void checkCheckbox(String id)
    {
        exists=true;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//input[@id='"+id+"' and @data-checked='unchecked']",driver))
            {
                WebElement checkBox=HelpersMethod.FindByElement(driver,"xpath","//input[@id='"+id+"' and @data-checked='unchecked']");
                //HelpersMethod.ClickBut(driver,checkBox,10000);
                act.moveToElement(checkBox).build().perform();
                act.click(checkBox).build().perform();
                scenario.log("CHECKBOX HAS BEEN CHECKED");
                exists=true;
            }
            else
            {
                scenario.log("CHECKBOX HAS NOT BEEN FOUND");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAdminPermissionPage()
    {
        exists=false;
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(300))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(300))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        try
        {
            if(HelpersMethod.IsExists("//div[@id='permissionsByRoleCard']",driver))
            {
                scenario.log("ADMIN PERMISSION PAGE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}