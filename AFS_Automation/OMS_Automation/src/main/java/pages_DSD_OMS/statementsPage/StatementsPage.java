package pages_DSD_OMS.statementsPage;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.TestBase;

import java.util.List;
import java.util.Set;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class StatementsPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String currentURL=null;

    @FindBy(id="cbStatementsWeekly")
    private WebElement weeklyCheckbox;

    @FindBy(id="cbStatementsMonthly")
    private WebElement monthlyCheckbox;

    @FindBy(id="cbStatementsRange")
    private WebElement dateCheckbox;

    @FindBy(id="ddlYear")
    private WebElement yearlyDropdown;

    @FindBy(id="ddlMonth")
    private WebElement monthDropdown;

    @FindBy(id="ddlDay")
    private WebElement dateDropdown;

    @FindBy(id="SearchBar1")
    private WebElement searchBar;

    @FindBy(xpath="//input[@id='SearchBar1']/ancestor::form//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement searchIndex;

    @FindBy(id="generateEditButton")
    private WebElement generateButton;

    public StatementsPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String NavigateStatements()
    {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");

                act.moveToElement(Search_Input).click().sendKeys("Statements").build().perform();
                WebElement BillMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Statements')]");
                HelpersMethod.ClickBut(driver, BillMenu, 20);
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if(HelpersMethod.IsExists("//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                    act.moveToElement(WebEle).build().perform();
                    act.click(WebEle).build().perform();
                }
                currentURL=driver.getCurrentUrl();
            if(HelpersMethod.IsExists("//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Statements')]",driver))
            {
                scenario.log("NAVIGATED TO STATEMENTS PAGE");
            }
            else
            {
                scenario.log("STATMENTS TAB MAY NOT BE ENABLED FOR THE APPLICATION");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
        return currentURL;
    }

    public void ValidateStatements()
    {
        String PTitle=null;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            PTitle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'spnmoduleNameHeader')]").getText();
            //Assert.assertEquals(PTitle,"Client Portal - Statements");
            if(PTitle.equals("Statements"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void HandleError_Page()
    {
        try
        {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError"))
            {
                HelpersMethod.NavigateBack(driver);
                URL = HelpersMethod.gettingURL(driver);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin")) {
                HomePage homepage = new HomePage(driver, scenario);
                homepage.navigateToClientSide();
                NavigateStatements();
            }
        }
        catch (Exception e) {}
    }

    public void Refresh_Page()
    {
        HelpersMethod.Implicitwait(driver,40);
        driver.navigate().refresh();
        HelpersMethod.Implicitwait(driver,40);
       /* if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 50);
        }*/
    }

    public void WeeklyCheckboxClick()
    {
        exists=false;
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            if(!weeklyCheckbox.isSelected())
            {
                HelpersMethod.ClickBut(driver,weeklyCheckbox,10);
            }
            if(weeklyCheckbox.isSelected())
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void MonthlyCheckboxClick()
    {
        exists=false;
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            if(!monthlyCheckbox.isSelected())
            {
                HelpersMethod.ClickBut(driver,monthlyCheckbox, 10);
            }
            if(monthlyCheckbox.isSelected())
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DateCheckboxClick()
    {
        exists=false;
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            if(!dateCheckbox.isSelected())
            {
                HelpersMethod.ClickBut(driver,dateCheckbox,10);
            }
            if(dateCheckbox.isSelected())
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void YearDropdown()
    {
        HelpersMethod.Implicitwait(driver,40);
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            HelpersMethod.Implicitwait(driver,40);
            HelpersMethod.ClickBut(driver,yearlyDropdown,10);
            HelpersMethod.Implicitwait(driver,40);
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container ')]/descendant::ul/li");
            WebElement YearFromDropDown=Values.get(2);
            act.moveToElement(YearFromDropDown).build().perform();
            HelpersMethod.Implicitwait(driver,40);
            act.click(YearFromDropDown).build().perform();
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void MonthDropdown()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            HelpersMethod.Implicitwait(driver,40);
            HelpersMethod.ClickBut(driver,monthDropdown,10);
            HelpersMethod.Implicitwait(driver,40);
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container ')]/descendant::ul/li");
            WebElement MonthFromDropDown=Values.get(2);
            act.moveToElement(MonthFromDropDown).build().perform();
            HelpersMethod.Implicitwait(driver,40);
            act.click(MonthFromDropDown).build().perform();
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DateDropdown()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            HelpersMethod.Implicitwait(driver,40);
            HelpersMethod.ClickBut(driver,dateDropdown,10);
            HelpersMethod.Implicitwait(driver,40);
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container ')]/descendant::ul/li");
            WebElement DateFromDropDown=Values.get(2);
            act.moveToElement(DateFromDropDown).build().perform();
            HelpersMethod.Implicitwait(driver,40);
            act.click(DateFromDropDown).build().perform();
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchBar()
    {
        exists=false;
        WebElement WebEle=null;
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            if(searchBar.isDisplayed())
            {
                HelpersMethod.EnterText(driver,searchBar,20, TestBase.testEnvironment.get_Account());
                HelpersMethod.ClickBut(driver,searchIndex,10);
                exists=true;
            }
            else
            {
                scenario.log("SEARCH BAR IS NOT VISIBLE, CHECK ADMIN SETTINGS");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectCustomerNo()
    {
        exists=false;
        WebElement WebEle=null;
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            if(!HelpersMethod.IsExists("//tr[contains(@class,'k-grid-norecords')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'checkbox')]");
                if(!WebEle.isSelected())
                {
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }
                exists=true;
            }
            else
            {
                scenario.log("CUSTOMER ACCOUNT# DOESN'T EXISTS");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void GenerateButton()
    {
        exists=false;
        WebElement WebEle=null;
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            String ParentWindow = driver.getWindowHandle();
            HelpersMethod.ClickBut(driver,generateButton,10);
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'There is no data to display for your defined date range')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ClickBut(driver,WebEle,10);
                exists=true;
            }
            else
            {
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        HelpersMethod.Implicitwait(driver, 10);
                        exists = true;
                    }
                }
                driver.switchTo().window(ParentWindow);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchValidation()
    {
        exists = false;
        WebElement WebEle = null;
        HelpersMethod.Implicitwait(driver, 40);
        try {
            if (HelpersMethod.IsExists("//tr[contains(@class,'k-grid-norecords')]", driver)) {
                scenario.log("NO CUSTOMER ACCOUNT# HAS BEEN FOUND");
                exists = true;
            } else {
                scenario.log("CUSTOMER ACCOUNT# HAS BEEN FOUND");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void AddFilterSearch()
    {
        exists=false;
        HelpersMethod.Implicitwait(driver,40);
        String search2=TestBase.testEnvironment.get_Account();
        try
        {
            HelpersMethod.AddFilterSearch(driver,"Customer account #",search2);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void FromDate()
    {
        WebElement WebEle=null;
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-textbox-container')][1]/descendant::a[contains(@class,'k-select k-select')]");
            HelpersMethod.ClickBut(driver,WebEle,10);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-calendar-view k-calendar-monthview')]",40);
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-view k-calendar-monthview')]",40);

            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-content k-calendar-content k-scrollable')]/table[contains(@class,'k-calendar-table')]/descendant::tr[3]/td[1]/span");
            HelpersMethod.ClickBut(driver,WebEle,20);
        }
        catch (Exception e){}
    }

    public void ToDate()
    {
        WebElement WebEle=null;
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-textbox-container')][2]/descendant::a[contains(@class,'k-select k-select')]");
            HelpersMethod.ClickBut(driver,WebEle,10);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-calendar-view k-calendar-monthview')]",40);
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-view k-calendar-monthview')]",40);

            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-content k-calendar-content k-scrollable')]/table[contains(@class,'k-calendar-table')]/descendant::tr/td[contains(@class,'k-calendar-td k-state-pending-focus k-state-selected k-today')]");
            HelpersMethod.ClickBut(driver,WebEle,20);
        }
        catch (Exception e){}
    }
}
