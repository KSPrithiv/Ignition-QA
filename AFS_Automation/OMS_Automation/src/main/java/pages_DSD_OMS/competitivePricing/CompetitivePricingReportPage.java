package pages_DSD_OMS.competitivePricing;

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
import util.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class CompetitivePricingReportPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(xpath = "//label[contains(text(),'Group by 1')]/following-sibling::span")
    private WebElement group1;

    @FindBy(xpath = "////button/span[text()='Print']")
    private WebElement printButton;


    public CompetitivePricingReportPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void validateReport()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }

            if(HelpersMethod.IsExists("//div[contains(@class,'i-comppricing-card card2')]",driver))
            {
                scenario.log("NAVIGATED TO REPORT PAGE");
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateGroupBy()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            if(HelpersMethod.IsExists("//div[@class='report-group-by']",driver))
            {
                scenario.log("NAVIGATED TO GROUP BY CARD, UNDER REPORT PAGE");
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnGroup1()
    {
        exists=true;
        try
        {
            if(group1.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,group1,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCustomerAccountOptionDropdown(String custAcc)
    {
       exists=false;
       Actions act=new Actions(driver);
       String listText;
       WebElement WebEle;
       try
       {
           if(HelpersMethod.IsExists("//div[@class='loader']",driver))
           {
               WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
               HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
           }
           new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-list-container')]/descendant::ul/li/span")));
           List<WebElement> listElements=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li/span");
           for (WebElement listEle:listElements)
           {
              act.moveToElement(listEle).build().perform();
              listText=listEle.getText();
              if(custAcc.equalsIgnoreCase(listText))
              {
                  act.moveToElement(listEle).build().perform();
                  act.click().build().perform();
                  //HelpersMethod.JScriptClick(driver,listEle,10000);
                  break;
              }
           }
           if(HelpersMethod.IsExists("//div[@class='loader']",driver))
           {
               WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
               HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
           }
       }
       catch (Exception e){}
    }

    public void clickCustomerAccountIndex()
     {
         exists=false;
         WebElement WebEle;
         try
         {
             if(HelpersMethod.IsExists("//div[@class='loader']",driver))
             {
                 WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                 HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
             }

             if(HelpersMethod.IsExists("//div[@class='dialog-grid']/descendant::button",driver))
             {
                 WebElement custIndexIcon=HelpersMethod.FindByElement(driver,"xpath","//div[@class='dialog-grid']/descendant::button");
                 HelpersMethod.ClickBut(driver,custIndexIcon,10000);
                 exists=true;
             }
             if(HelpersMethod.IsExists("//div[@class='loader']",driver))
             {
                 WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                 HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
             }
             Assert.assertEquals(exists,true);
         }
         catch (Exception e){}
     }

     public void validateCustomerAccountDialogBox()
     {
         exists=false;
         try
         {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("CUSTOMER ACCOUNT INDEX DIALOG BOX HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
         }
         catch (Exception e){}
     }

     public void clickOnAddfilterToSelectCustomer(String custAcc,String accNo)
     {
         exists=false;
         WebElement WebEle;
         try
         {
             if (HelpersMethod.IsExists("//div[@class='i-filter-tag i-filter-tag--add']/descendant::button[@class='i-filter-tag__main']", driver))
             {
                 //Clear the filter option
                 if(HelpersMethod.IsExists("//div[@class='i-filter-tag ']/descendant::button[contains(@class,'i-filter-tag__clear')]",driver))
                 {
                     WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='i-filter-tag ']/descendant::button[contains(@class,'i-filter-tag__clear')]");
                     HelpersMethod.ClickBut(driver, WebEle, 10000);
                 }
                 if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                 {
                     WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                     HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                 }

                 HelpersMethod.AddFilterSearch(driver, custAcc, accNo);
                 if (HelpersMethod.IsExists("//div[contains(@class,'i-no-data__message')]", driver))
                 {
                     scenario.log("******NO ACCOUNT NUMBER FOUND");
                     exists = false;
                 }
                 else
                 {
                     scenario.log("ACCOUNT NUMBER HAS BEEN FOUND");
                     exists = true;
                 }
             }
             Assert.assertEquals(exists, true);
         }
         catch (Exception e) {}
     }

     public void selectCustomerAccountInDialogbox()
     {
         exists=false;
         WebElement WebEle;
         try
         {
             if(HelpersMethod.IsExists("//div[@class='loader']",driver))
             {
                 WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                 HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
             }
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/descendant::input",driver))
            {
                WebElement webEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/descendant::input");
                HelpersMethod.ActClick(driver,webEle,10000);

                WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::.//button/span[text()='Continue']");
                HelpersMethod.ActClick(driver,okButton,10000);
            }
             if(HelpersMethod.IsExists("//div[@class='loader']",driver))
             {
                 WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                 HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
             }
         }
         catch (Exception e){}
     }

    public void handlePrintButton()
    {
        exists=false;
        try
        {
            if(printButton.isDisplayed() && printButton.isEnabled())
            {
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, printButton, 1000);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                scenario.log("TO GENERATE THE REPORT IN .pdf FORMATE PRINT BUTTON HAS BEEN CLICKED");
                Thread.sleep(5000);
                if (HelpersMethod.IsExists("//div[contains(text(),'No data returned, report was not generated.')]/ancestor::div[@id='toast-container']", driver))
                {
                    scenario.log("**************NO DATA HAS BEEN FOUND TO GENERATE REPORTS************");
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'No data returned, report was not generated.')]/ancestor::div[@id='toast-container']")));
                    //exists=true;
                }
                else
                {
                    Set<String> PCWindows = driver.getWindowHandles();
                    for (String PCwind : PCWindows)
                    {
                        if (!PCwind.equals(ParentWindow))
                        {
                            driver.switchTo().window(PCwind);
                            driver.close();
                            scenario.log(".pdf HAS BEEN FOUND");
                            exists = true;
                        }
                    }
                    driver.switchTo().window(ParentWindow);
                }
            }
            else
            {
                scenario.log("PDF BUTTON IS DISABLED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickAscendingRadioButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='report-group-by--component'][1]/descendant::input[@id='radioButton2']",driver))
            {
                if(!HelpersMethod.IsExists("//div[@class='report-group-by--component'][1]/descendant::input[@id='radioButton2' and @checked]",driver))
                {
                    WebElement ascending=HelpersMethod.FindByElement(driver,"xpath","//div[@class='report-group-by--component'][1]/descendant::input[@id='radioButton2']");
                    HelpersMethod.ActClick(driver,ascending,1000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickDescendingRadioButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='report-group-by--component'][1]/descendant::input[@id='radioButton3']",driver))
            {
                if(!HelpersMethod.IsExists("//div[@class='report-group-by--component'][1]/descendant::input[@id='radioButton3' and @checked]",driver))
                {
                    WebElement ascending=HelpersMethod.FindByElement(driver,"xpath","//div[@class='report-group-by--component'][1]/descendant::input[@id='radioButton3']");
                    HelpersMethod.ActClick(driver,ascending,1000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnChainFromDropDown()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }

            if(HelpersMethod.IsExists("//div[@class='report-group-by--component'][1]/descendant::span[contains(@class,'i-multiselect')]/descendant::input[@id='dropdown']",driver))
            {
                WebElement chineOption = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='report-group-by--component'][1]/descendant::span[contains(@class,'i-multiselect')]/descendant::input[@id='dropdown']");
                HelpersMethod.ActClick(driver, chineOption, 10000);
                exists=true;
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectChineFromDropDown()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='k-child-animation-container']",driver))
            {
                WebElement checkBox=HelpersMethod.FindByElement(driver,"xpath","//ul[@id='dropdownlist']/li[1]/descendant::input");
                HelpersMethod.ActClick(driver,checkBox,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}

    }

    public void enterSearchValueInInputbox()
    {
        try
        {
            WebElement groupInputBox= HelpersMethod.FindByElement(driver,"xpath","//div[@class='dialog-grid']/descendant::input");
            HelpersMethod.ActClick(driver,groupInputBox,10000);
            HelpersMethod.ActSendKeyEnter(driver,groupInputBox,10000, TestBase.testEnvironment.getCustomerName());
        }
        catch (Exception e){}
    }

    public void selectCustomerAccountOptionDropdownForReport()
    {
        try
        {
            List<WebElement> customerNames= HelpersMethod.FindByElements(driver,"xpath","//ul[@class='k-list-ul']/li/descendant::input");
            for(int i=0;i<=customerNames.size()-1;i++)
            {
                if(i==1)
                {
                    WebElement customername=HelpersMethod.FindByElement(driver,"xpath","//ul[@class='k-list-ul']/li["+i+"]/descendant::input");
                    HelpersMethod.ActClick(driver,customername,10000);
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void selectCustomerAccountOptionDropdownForReportToSelectSecondCustomer()
    {
        try
        {
            List<WebElement> customerNames= HelpersMethod.FindByElements(driver,"xpath","//ul[@class='k-list-ul']/li/descendant::input");
            for(int i=0;i<=customerNames.size()-1;i++)
            {
                if(i==2)
                {
                    WebElement customername=HelpersMethod.FindByElement(driver,"xpath","//ul[@class='k-list-ul']/li["+i+"]/descendant::input");
                    HelpersMethod.ActClick(driver,customername,10000);
                    break;
                }
            }
        }
        catch (Exception e){}
    }
}
