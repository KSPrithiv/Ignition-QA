package pages_DSD_OMS.disconnectedMode;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.en_old.Ac;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Environment;
import util.TestBase;

import java.awt.font.TextLayout;
import java.time.Duration;
import java.util.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class DMOEPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static Environment testEnvironment;
    static boolean exists = false;
    static String C_Date1 = null;
    static String ChangeDate=null;

    public DMOEPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void NavigateToDM() throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        Thread.sleep(20000);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'connection-mode-container')]//*[local-name()='svg']//*[local-name()='path' and  contains(@d,'M17')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'connection-mode-container')]//*[local-name()='svg']//*[local-name()='path' and  contains(@d,'M17')]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                exists=true;
            }
            else{scenario.log("NETWORK SYMBOL IS NOT VISIBLE");}
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void DisconnectModeTaggle()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Connection']/ancestor::div[contains(@class,'k-popup')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup')]/descendant::span[contains(@class,'k-widget k-switch k-switch-on')]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void DisconnectModePopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
            if(HelpersMethod.IsExists("//div[contains(text(),'Disconnected mode')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void ClickGoToOffline()
    {
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Go offline']");
            HelpersMethod.ActClick(driver,WebEle,10000);
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void DisconnectModePopupCancel()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]")));
            if(HelpersMethod.IsExists("//div[contains(text(),'Disconnected mode')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Cancel']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void ValidateCustomerAccountPopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Select customers')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    //To select customer Account# in Add filter in customer account# popup
    public void SelectAccountNo()
    {
        exists=false;
        WebElement WebEle=null;
        String Acc=TestBase.testEnvironment.get_Account();
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@class,'i-filter-tag__main')]",driver))
            {
                HelpersMethod.AddFilterSearch_Popup(driver,"Customer #",Acc);
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void selectFirstCustomerAccountNo()
    {
        exists=false;
        WebElement WebEle=null;
        String Acc=TestBase.testEnvironment.get_Account();
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@class,'i-filter-tag__main')]",driver))
            {
                HelpersMethod.AddFilterSearch_Popup(driver,"Customer #",Acc);
                scenario.log("FIRST CUSTOMER ACCOUNT# HAS BEEN SELECTED");
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void selectSecondCustomerAccountNo()
    {
        exists=false;
        WebElement WebEle=null;
        String Acc=TestBase.testEnvironment.get_AnotherAcc();
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(@class,'i-filter-tag__main')]",driver))
            {
                HelpersMethod.AddFilterSearch_Popup(driver,"Customer #",Acc);
                scenario.log("SECOND CUSTOMER ACCOUNT# HAS BEEN SELECTED");
                exists = true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void SelectAccountCheckBox()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::table[@class='k-grid-table']/descendant::input[@type='checkbox']");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void clearAccountNumberInDialogbox()
    {
        exists=true;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[@class='i-filter-tag__clear']//*[local-name()='svg']",driver))
            {
                WebElement clearAccountButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[@class='i-filter-tag__clear']//*[local-name()='svg']");
                HelpersMethod.ActClick(driver,clearAccountButton,2000);
                exists=true;
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void AccountPopupOK()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[text()='Ok']");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void ValidateSelectDeliveryDate()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                scenario.log("DELIVERY DATE POPUP HAS BEEN FOUND");
                exists=true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void SelectDeliveryDate()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[2]");
                HelpersMethod.ClickBut(driver,WebEle,2000);
                //HelpersMethod.ActClick(driver, WebEle, 1000);
                //HelpersMethod.JScriptClick(driver,WebEle,2000);
                scenario.log("DELIVERY DATE HAS BEEN SELECTED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectSeconDeliveryDate()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[3]");
                HelpersMethod.ClickBut(driver,WebEle,2000);
                scenario.log("DELIVERY DATE HAS BEEN SELECTED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectThirdDeliveryDate()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[4]");
                HelpersMethod.ClickBut(driver,WebEle,2000);
                scenario.log("DELIVERY DATE HAS BEEN SELECTED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectFourthDeliveryDate()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[5]");
                HelpersMethod.ClickBut(driver,WebEle,2000);
                scenario.log("DELIVERY DATE HAS BEEN SELECTED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectDeliveryDateOk()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            exists=true;
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void SynchronizationPopup()
    {
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Synchronizing Device Data')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Synchronizing Device Data')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                new WebDriverWait(driver, Duration.ofMillis(600000)).until(ExpectedConditions.invisibilityOf(WebEle));
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(1000))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOf(WebEle));
            }
        }
        catch (Exception e){}
    }

    public void ValidateDisconnectedMode()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'notification-center-item offline')]",driver))
            {
                scenario.log("USER IS ON DISCONNECTED MODE");
                exists=true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void ClickOnNetworkSymbolInDM()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'connection-mode-container notification-center-item offline')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M21')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'connection-mode-container notification-center-item offline')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M21')]");
                HelpersMethod.ActClick(driver,WebEle,1000);
                exists=true;
            }
        }
        catch (InterruptedException e) {}
        Assert.assertEquals(exists,true);
    }

    public void ClickTaggleDM()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'i-switch connection-mode-switch')]/descendant::span[contains(@class,'k-widget k-switch k-switch-off')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-switch connection-mode-switch')]/descendant::span[contains(@class,'k-widget k-switch k-switch-off')]");
                HelpersMethod.ActClick(driver,WebEle,200);
                exists=true;
            }
        }
        catch (InterruptedException e) {}
        Assert.assertEquals(exists,true);
    }

    public void GoOnlinePopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Connected mode')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Go online')]");
                HelpersMethod.ActClick(driver,WebEle,200);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
                }
                exists=true;
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void clickOnAccountIndex()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@data-test-id='customerAccountNumberComboBox']/following-sibling::button",driver))
            {
                WebElement customerIndex=HelpersMethod.FindByElement(driver,"xpath","//span[@data-test-id='customerAccountNumberComboBox']/following-sibling::button");
                HelpersMethod.ClickBut(driver,customerIndex,2000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAccountDialogPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-grid']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                scenario.log("CUSTOMER ACCOUNT INDEX POPUP HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAccountNumbers()
    {
        exists=false;
        Actions act=new Actions(driver);
        String headText=null;
        String accText=null;
        ArrayList<String> accNumber=new ArrayList<String>();
        List<WebElement> accounts = null;
        
        int i=0;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::span[@class='k-link']");
            for(WebElement head:heads)
            {
                i++;
              act.moveToElement(head).build().perform();
              headText=head.getText();
              if(headText.equalsIgnoreCase("Customer #"))
              {
                  accounts=driver.findElements(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td["+i+"]"));
                  break;
              }
            }
            scenario.log("CUSTOMER ACCOUNT# SELECTED ARE:");
            //accounts=HelpersMethod.FindByElements(driver,"xapth","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]/td["+i+"]");
            for (WebElement account:accounts)
            {
                act.moveToElement(account).build().perform();
                accText=account.getText();
                scenario.log(accText);
                accNumber.add(accText.substring(accText.length()-4));
            }
            for(int j=0;j<=accNumber.size()-1;j++)
            {
               if(TestBase.testEnvironment.get_Account().equals(accNumber.get(j))||TestBase.testEnvironment.get_AnotherAcc().equals(accNumber.get(j)))
               {
                   exists=true;
               }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void closeAccountIndex()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(text(),'Customer')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                WebElement cancelButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Cancel']");
                HelpersMethod.ActClick(driver,cancelButton,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}