package pages_DSD_OMS.adminReport;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

public class orderAdminPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    public orderAdminPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void navigateToDifferentTabsInOrder(String horizontalMenu)
    {
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }

            String Menu_Text=null;
            Actions act=new Actions(driver);
            List<WebElement> MenuBar=HelpersMethod.FindByElements(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link']");
            for(WebElement Menu:MenuBar)
            {
                act.moveToElement(Menu).build().perform();
                Menu_Text=Menu.getText();
                if(Menu_Text.contains(horizontalMenu))
                {
                    WebElement menuItem=HelpersMethod.FindByElement(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'"+horizontalMenu+"')]");
                    HelpersMethod.JScriptClick(driver,menuItem,1000);
                    break;
                }
                else
                {
                    if(Menu_Text.equals(""))
                    {
                        WebElement arrowLeft=HelpersMethod.FindByElement(driver,"xapth","//button[contains(@class,'button-left')]//*[local-name()='svg']");
                        HelpersMethod.JScriptClick(driver,arrowLeft,1000);
                        List<WebElement> MenuBar1=HelpersMethod.FindByElements(driver,"xpath","//li[contains(@class,'k-item')]/span[@class='k-link']");
                        for(WebElement Menu1:MenuBar1)
                        {
                            act.moveToElement(Menu1).build().perform();
                            Menu_Text = Menu1.getText();
                            if (Menu_Text.contains(horizontalMenu))
                            {
                                WebElement menuItem = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'" + horizontalMenu + "')]");
                                HelpersMethod.JScriptClick(driver, menuItem, 1000);
                                break;
                            }
                        }
                    }
                }
            }

            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
            }
        }
        catch (Exception e){}
    }

    public void validateTabNavigatedTo(String tabOption)
    {
        exists=false;
        String tabValue=null;
        try
        {
            if(HelpersMethod.IsExists("//li[contains(@class,'k-state-active')]/span[@class='k-link']",driver))
            {
                tabValue=HelpersMethod.FindByElement(driver,"xpath","//li[contains(@class,'k-state-active')]/span[@class='k-link']").getText();
                if(tabValue.equals(tabOption))
                {
                    scenario.log("NAVIGATED TO "+tabValue);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCustomerAccount(String arg0)
    {
        exists = false;
        WebElement WebEle;
        WebElement Search2;
        String AccNo = TestBase.testEnvironment.get_Account();

        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }

        WebElement WebEle1=HelpersMethod.FindByElement(driver,"xpath","//label[@id='customerDropDown-label']/following-sibling::div/descendant::button");
        try
        {
            HelpersMethod.ClickBut(driver,WebEle1,1000);
            //validate Customer account # popup
            WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Customer account #", "Verify Title message");
            //Select customer account # by clicking Add filter button in customer account # popup
            WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
            HelpersMethod.ActClick(driver, AddFilterButton, 4000);

            //Identify the dialog popup
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active')]", 6000);
            WebElement modalContainer1 =HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-popup k-child-animation-container')]");

            //Enter customer account# in input box
            WebElement Search1 = driver.findElement(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]"));
            HelpersMethod.EnterText(driver, Search1, 1000, arg0);

            //Click on Check box
            WebEle1 = driver.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::input[@id='CM_CUSTKEY']"));
            HelpersMethod.JScriptClick(driver, WebEle1, 1000);

            //Identify radio button and click on Radio button
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 40000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 40000);
            WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
            Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            HelpersMethod.ActSendKey(driver, Search2, 1000, AccNo);

            //Click on Apply button
            WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button[text()='Apply']"));
            HelpersMethod.ClickBut(driver, ApplyButton, 1000);
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-grid-container')]", 40000);

            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[@class='i-no-data']", driver))
            {
                scenario.log("CUSTOMER ACCOUNT NUMBER DOESN'T EXISTS");
            }
            else
            {
                WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
                HelpersMethod.ScrollElement(driver, WebEle);
                HelpersMethod.ActClick(driver, WebEle, 1000);

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
                exists = true;
                String Acc = TestBase.testEnvironment.get_Account();
                scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED: " + Acc);
            }
        }
        catch (Exception e){}
    }

    public  void clickOnFromDate()
    {
        exists=false;
        WebElement startDate=HelpersMethod.FindByElement(driver,"xpath","//label[@id='fromDate-label']/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]");
        try
        {
            HelpersMethod.ActClick(driver,startDate,1000);
            exists=true;
            new WebDriverWait(driver, Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]")));
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }

    public void clickOnEndDate()
    {
        exists=false;
        WebElement toDate=HelpersMethod.FindByElement(driver,"xpath","//label[@id='toDate-label']/following-sibling::span/descendant::span[contains(@class,'k-icon k-i-calendar')]");
        try
        {
            HelpersMethod.ActClick(driver,toDate,1000);
            exists=true;
            new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]")));
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }

    public void selectFromDate() throws InterruptedException
    {
        Thread.sleep(400);
        //HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40000);
        new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
        try
        {
            String formattedDate1 = null;
            WebElement WebEle=null;
            String FTDate=null;
            exists=false;
            //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                WebElement ele1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-calendar-monthview')]/descendant::tr[@role='row'][1]/td/span[text()='1']");
                if(ele1.isDisplayed() && ele1.isEnabled())
                {
                    HelpersMethod.JSScroll(driver, ele1);
                    HelpersMethod.ActClick(driver, ele1, 8000);
                    WebEle=HelpersMethod.FindByElement(driver,"id","StartDate");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,60);
                    scenario.log(FTDate+" HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                    exists=true;
                }
                else
                {
                    scenario.log("NOT ABLE TO SELECT THE DATE");
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e) {}
    }

    public void selectToDate()
    {
        exists=false;
        WebElement WebEle;
        String FTDate=null;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
            {
                if(HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@class,'focus')]",driver))
                {
                    WebElement toDate=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]/descendant::td[contains(@class,'focus')]");
                    HelpersMethod.JSScroll(driver, toDate);
                    HelpersMethod.ActClick(driver, toDate, 1000);
                    WebEle=HelpersMethod.FindByElement(driver,"id","EndDate");
                    FTDate=HelpersMethod.JSGetValueEle(driver,WebEle,1000);
                    scenario.log(FTDate+" HAS BEEN SELECTED AS START DATE FOR STANDING ORDER");
                    exists=true;
                }
                else
                {
                    scenario.log("THERE IS NO FOCUSSED DATE");
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }

    public void clickOnExportCSV()
    {
        exists=false;
        WebElement exportCSV=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Export']");
        try
        {
            HelpersMethod.ScrollElement(driver,exportCSV);
            HelpersMethod.ActClick(driver,exportCSV,1000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'The report returned no data. Choose other parameters.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=dialogPopup.findElement(By.xpath(".//button"));
                HelpersMethod.ClickBut(driver,okButton,1000);
                scenario.log("THE REPORT IS NOT RETURNING ANY DATA");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnDownloadPDF()
    {
        exists=false;
        WebElement downloadPdf=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Download']");
        try
        {
            String ParentWindow = driver.getWindowHandle();
            HelpersMethod.ActClick(driver,downloadPdf,1000);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'The report returned no data. Choose other parameters.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=dialogPopup.findElement(By.xpath(".//button"));
                HelpersMethod.ClickBut(driver,okButton,1000);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            Thread.sleep(5000);
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
            exists = true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnResetButton()
    {
        exists=false;
        WebElement resetButton=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Reset']");
        try
        {
            if(resetButton.isDisplayed()&&resetButton.isEnabled())
            {
                HelpersMethod.ActClick(driver, resetButton, 1000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateWebElementClear()
    {
        exists=false;
        WebElement fDate=HelpersMethod.FindByElement(driver,"id","fromDate");
        String fromValue=HelpersMethod.JSGetValueEle(driver,fDate,1000);
        WebElement tDate=HelpersMethod.FindByElement(driver,"id","toDate");
        String toValue=HelpersMethod.JSGetValueEle(driver,tDate,1000);
        try
        {
            WebElement accNumber=HelpersMethod.FindByElement(driver,"id","customerDropDown_AC");
            String acc_Text=HelpersMethod.JSGetValueEle(driver,accNumber,1000);
            if(acc_Text.equals("") && fromValue.equals("MM/DD/YYYY") && toValue.equals("MM/DD/YYYY"))
            {
                scenario.log("RESET BUTTON HAS BEEN CLICKED");
                exists=true;
            }
            else
            {
                scenario.log("RESET BUTTON IS NOT WORKING");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }

    public void validateWebElementClear1()
    {
        exists=false;
        WebElement tDate=HelpersMethod.FindByElement(driver,"id","toDate");
        String toValue=HelpersMethod.JSGetValueEle(driver,tDate,1000);
        try
        {
            if(toValue.equals("MM/DD/YYYY"))
            {
                scenario.log("RESET BUTTON HAS BEEN CLICKED");
                exists=true;
            }
            else
            {
                scenario.log("RESET BUTTON IS NOT WORKING");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }

    public void validateWebElementClear2()
    {
        exists=false;
        try
        {
            WebElement fDate=HelpersMethod.FindByElement(driver,"id","OrderDate");
            String fromValue=HelpersMethod.JSGetValueEle(driver,fDate,1000);
            WebElement tDate=HelpersMethod.FindByElement(driver,"id","ShipDate");
            String toValue=HelpersMethod.JSGetValueEle(driver,tDate,1000);
            WebElement accNumber=HelpersMethod.FindByElement(driver,"id","orderNumber");
            String acc_Text=HelpersMethod.JSGetValueEle(driver,accNumber,1000);
            WebElement custNumber=HelpersMethod.FindByElement(driver,"id","customerNumber");
            String cust_Text=HelpersMethod.JSGetValueEle(driver,custNumber,1000);
            if(acc_Text.equals("") && cust_Text.equals("") && fromValue.equals("MM/DD/YYYY") && toValue.equals("MM/DD/YYYY"))
            {
                scenario.log("RESET BUTTON HAS BEEN CLICKED");
                exists=true;
            }
            else
            {
                scenario.log("RESET BUTTON IS NOT WORKING");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }

    public void clickOnEvent() throws InterruptedException
    {
        WebElement eventDropdown=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-widget k-multiselect')]");
        HelpersMethod.ActClick(driver,eventDropdown,1000);
    }

    public void selectEventFromDropDown(String event)
    {
        HelpersMethod.DropDownMenu(driver,event);
    }

    public void clickUserName() throws InterruptedException
    {
        WebElement userNameDropdown=HelpersMethod.FindByElement(driver,"xpath","//input[@id='UserName']/ancestor::span[@class='k-dropdown-wrap']/descendant::span[@class='k-select']");
        HelpersMethod.ScrollElement(driver,userNameDropdown);
        HelpersMethod.JScriptClick(driver,userNameDropdown,1000);
    }

    public void userNameSelection()
    {
        String userName=TestBase.testEnvironment.username();
        WebElement WebEle=null;
        Actions act1= new Actions(driver);
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]",1000);
        // to fetch the web element of the modal container
        WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
        List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
        for(int i=0;i<=Options.size()-1;i++)
        {
            WebEle=Options.get(i);
            act1.moveToElement(WebEle).build().perform();
            String Opt=WebEle.getText();
            if(Opt.equals(userName))
            {
                act1.moveToElement(WebEle).build().perform();
                act1.click(WebEle).build().perform();
                break;
            }
            else
            {
                act1.moveToElement(WebEle).sendKeys(Keys.ARROW_DOWN).build().perform();
            }
        }
    }

    public void enterCustomerAccountNo()
    {
        exists=true;
        try
        {
            if (HelpersMethod.IsExists("//input[@id='customerNumber']", driver))
            {
                WebElement customerAcc = HelpersMethod.FindByElement(driver, "id", "customerNumber");
                HelpersMethod.EnterText(driver, customerAcc, 1000, TestBase.testEnvironment.get_Account());
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void orderDateCalenderClick()
    {
        try
        {
            WebElement orderDate=HelpersMethod.FindByElement(driver,"xpath","//label[@id='OrderDate-label']/following-sibling::span/descendant::a");
            HelpersMethod.ActClick(driver,orderDate,1000);
        }
        catch (Exception e){}
    }


    public void orderDateSelection()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]",driver))
            {
                WebElement dateSelection=HelpersMethod.FindByElement(driver,"xpath","//td[contains(@class,'k-today')]");
                HelpersMethod.ActClick(driver,dateSelection,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnGenerateButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//button[text()='Generate']",driver))
            {
                WebElement generateButton=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Generate']");
                HelpersMethod.ClickBut(driver,generateButton,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
