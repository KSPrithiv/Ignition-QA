package pages_DSD_OMS.adminCustomerInq;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import util.TestBase;

import java.time.Duration;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class customerInqAdminPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(xpath="//div[contains(@class,'moduleNameHeader')]/span[contains(@class,'spnmoduleNameHeader')]")
    private WebElement pageHeader;

    @FindBy(id="SelectGridType")
    private WebElement gridTypeDropDown;

    @FindBy(xpath="//button[contains(text(),'Grid options')]")
    private WebElement gridOptionDropdown;

    @FindBy(xpath="//button[contains(text(),'Column chooser')]")
    private WebElement columnChooser;

    public customerInqAdminPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void validatingAdminCustomerInqPage()
    {
        exists = false;
        String title;
        WebElement WebEle;
        String status;

        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        //Thread.sleep(6000);
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        try
        {
            if (HelpersMethod.IsExists("//span[@class='spnmoduleNameHeader withoutBreadcrumbs' and text()='Customer Inquiry']| //span[@class='spnmoduleNameHeader withoutBreadcrumbs' and text()='Customer inquiry']",driver))
            {
                scenario.log("ADMIN PAGE FOR CUSTOMER INQUIRY HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void enableAutoPopulateNextTogglebutton() throws InterruptedException
    {
        exists=false;
//        try
//        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[@id='CPIncludeAutomaticallyPopulateCustomerNo' and @aria-checked='false']",driver))
            {
                WebElement autoPopulateNextRadioButton = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='CPIncludeAutomaticallyPopulateCustomerNo']");
                HelpersMethod.ActClick(driver, autoPopulateNextRadioButton, 10000);
            }
            if(HelpersMethod.IsExists("//span[@id='CPIncludeAutomaticallyPopulateCustomerNo' and @aria-checked='true']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
//        }
//        catch (Exception e){}
    }

    public void disableAutoPopulateNextTogglebutton() throws InterruptedException
    {
        exists=false;
//        try
//        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[@id='CPIncludeAutomaticallyPopulateCustomerNo' and @aria-checked='true']",driver))
            {
                WebElement autoPopulateNextRadioButton = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='CPIncludeAutomaticallyPopulateCustomerNo']");
                HelpersMethod.ActClick(driver, autoPopulateNextRadioButton, 10000);
            }
            if(HelpersMethod.IsExists("//span[@id='CPIncludeAutomaticallyPopulateCustomerNo' and @aria-checked='false']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
//        }
//        catch (Exception e){}
    }

    public void useDefaultSettingsForStoreNumberVariable()
    {
        exists=false;
        try
        {
            WebElement storeVariable=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Use default Settings for Store Number']/parent::div/following-sibling::div/descendant::label[text()='Variable']/preceding-sibling::input");
            //String radioValue=HelpersMethod.JSGetValueEle(driver,storeVariable,10000);
            if(!storeVariable.isSelected())
            {
                HelpersMethod.ActClick(driver, storeVariable, 10000);
            }
            //radioValue=HelpersMethod.JSGetValueEle(driver,storeVariable,10000);
            if(storeVariable.isSelected())
            {
                scenario.log("USE DEFAULT SETTINGS FOR STORE NUMBER, VARIABLE RADIO BUTTON ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void useDefaultSettingsDepartmentNumberVariable()
    {
        exists=false;
        try
        {
            WebElement departmentVariable=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Use default Settings Department Number']/parent::div/following-sibling::div/descendant::label[text()='Variable']/preceding-sibling::input");
            if(!departmentVariable.isSelected())
            {
                HelpersMethod.ActClick(driver, departmentVariable, 10000);
            }
            if(departmentVariable.isSelected())
            {
                scenario.log("USE DEFAULT SETTINGS FOR DEPARTMENT NUMBER, VARIABLE RADIO BUTTON ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void useDefaultSettingsForStoreNumberFixed()
    {
        exists=false;
        try
        {
            WebElement storeFixed=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Use default Settings for Store Number']/parent::div/following-sibling::div/descendant::label[text()='Fixed']/preceding-sibling::input");
            if(!storeFixed.isSelected())
            {
                HelpersMethod.ActClick(driver, storeFixed, 10000);
            }
            if(storeFixed.isSelected())
            {
                scenario.log("USE DEFAULT SETTINGS FOR STORE NUMBER, FIXED RADIO BUTTON ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void useDefaultSettingsDepartmentNumberFixed()
    {
        exists=false;
        try
        {
            WebElement departmentFixed=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Use default Settings Department Number']/parent::div/following-sibling::div/descendant::label[text()='Fixed']/preceding-sibling::input");
            if(!departmentFixed.isSelected())
            {
                HelpersMethod.ActClick(driver, departmentFixed, 10000);
            }
            if(departmentFixed.isSelected())
            {
                scenario.log("USE DEFAULT SETTINGS FOR DEPARTMENT NUMBER, FIXED RADIO BUTTON ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void useDefaultSettingsForStoreNumberManual()
    {
        exists=false;
        try
        {
            WebElement storeManual=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Use default Settings for Store Number']/parent::div/following-sibling::div/descendant::label[text()='Manual']/preceding-sibling::input");
            if(!storeManual.isSelected())
            {
                HelpersMethod.ActClick(driver, storeManual, 10000);
            }
            if(storeManual.isSelected())
            {
                scenario.log("USE DEFAULT SETTINGS FOR STORE NUMBER, MANUAL RADIO BUTTON ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void useDefaultSettingsDepartmentNumberManual()
    {
        exists=false;
        try
        {
            WebElement departmentManual=HelpersMethod.FindByElement(driver,"xpath","//div[text()='Use default Settings Department Number']/parent::div/following-sibling::div/descendant::label[text()='Manual']/preceding-sibling::input");
            if(!departmentManual.isSelected())
            {
                HelpersMethod.ActClick(driver, departmentManual, 10000);
            }
            if(departmentManual.isSelected())
            {
                scenario.log("USE DEFAULT SETTINGS FOR DEPARTMENT NUMBER, MANUAL RADIO BUTTON ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String readStoreNoValue()
    {
        exists=false;
        String storeNo="";
        try
        {
            if(HelpersMethod.IsExists("//input[@id='CPIncludeStoreNumber']",driver))
            {
                WebElement store=HelpersMethod.FindByElement(driver,"id","CPIncludeStoreNumber");
                storeNo=HelpersMethod.JSGetValueEle(driver,store,10000);
                scenario.log("STORE VALUE FOUND "+storeNo);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return storeNo;
    }

    public String readDeptNovalue()
    {
        exists=false;
        String deptNo="";
        try
        {
            if(HelpersMethod.IsExists("//input[@id='CPIncludeDeptNumber']",driver))
            {
                WebElement dept=HelpersMethod.FindByElement(driver,"id","CPIncludeDeptNumber");
                deptNo=HelpersMethod.JSGetValueEle(driver,dept,10000);
                scenario.log("DEPARTMENT NO FOUND IS "+deptNo);
                exists=true;
            }
        }
        catch (Exception e){}
        return deptNo;
    }
}
