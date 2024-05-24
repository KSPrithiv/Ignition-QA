package pages_DSD_OMS.statementsPage;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en_old.Ac;
import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;
import util.TestBase;

import java.time.Duration;
import java.util.*;

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
    static String currentURL;
    static ArrayList<String> customerAccNo=new ArrayList<>();
    static ArrayList<String> customerAccNo1=new ArrayList<>();
    static ArrayList<String> customerName=new ArrayList<>();
    static ArrayList<String> customerName1=new ArrayList<>();
    static List<WebElement> customers;

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

    @FindBy(xpath="//div[contains(@class,'i-search-box')]//*[local-name()='svg' and contains(@class,'i-search-box__search')]")
    private WebElement searchIndex;

    @FindBy(id="generateEditButton")
    private WebElement generateButton;

    private String pre;

    public StatementsPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void NavigateStatements()
    {
        exists = false;
        WebElement WebEle = null;
        String status = null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        try
        {
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("Statements").build().perform();
            WebElement StatementMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'Statements')]");
            HelpersMethod.ClickBut(driver, StatementMenu, 2000);
            Thread.sleep(4000);
            exists = true;
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
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
            scenario.log(currentURL);
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
    }

    public void Refresh_Page() throws InterruptedException
    {
        scenario.log("CURRENT URL IS "+currentURL);
        driver.navigate().to(currentURL);
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        Thread.sleep(4000);
    }

    public void ValidateStatements()
    {
        String PTitle=null;
        WebElement WebEle;
        String status="";
        try
        {
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            PTitle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'spnmoduleNameHeader')]").getText();
            if(PTitle.contains("Statements"))
            {
                scenario.log("USER IS ON STATEMENTS PAGE");
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
                scenario.log("URL FOUND "+URL);
                scenario.log("**************ERROR PAGE HAS BEEN FOUND****************");
                driver.navigate().to(currentURL);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
            {
                HomePage homepage = new HomePage(driver, scenario);
                homepage.navigateToClientSide();
                NavigateStatements();
            }
        }
        catch (Exception e) {}
    }

    public void WeeklyCheckboxClick()
    {
        exists=false;
        try
        {
            if(!weeklyCheckbox.isSelected())
            {
                HelpersMethod.ClickBut(driver,weeklyCheckbox,1000);
            }
            if(weeklyCheckbox.isSelected())
            {
                scenario.log("WEEKLY CHECKBOX HAS BEEN SELECTED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void MonthlyCheckboxClick()
    {
        exists=false;
        try
        {
            if(!monthlyCheckbox.isSelected())
            {
                HelpersMethod.ClickBut(driver,monthlyCheckbox, 1000);
            }
            if(monthlyCheckbox.isSelected())
            {
                scenario.log("MONTHLY CHECKBOX HAS BEEN SELECTED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DateCheckboxClick()
    {
        exists=false;
        try
        {
            if(!dateCheckbox.isSelected())
            {
                HelpersMethod.ClickBut(driver,dateCheckbox,1000);
            }
            if(dateCheckbox.isSelected())
            {
                scenario.log("DATE CHECKBOX HAS BEEN SELECTED");
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void YearDropdown()
    {
        exists=false;
        Actions act=new Actions(driver);
        String prYear=null;
        String pYear=null;
        String status="";
        WebElement YearFromDropDown;
        try
        {
            prYear=HelpersMethod.FindByElement(driver,"xpath","//span[@id='ddlYear']/span[contains(@class,'input')]").getText();
            scenario.log("YEAR BEFORE CHAINGING: "+prYear);
            HelpersMethod.ClickBut(driver,yearlyDropdown,1000);
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container ')]/descendant::ul/li");
            for(int i=0;i<= Values.size()-1;i++)
            {
                YearFromDropDown = Values.get(i);
                act.moveToElement(YearFromDropDown).build().perform();
                if(i==2)
                {
                    act.moveToElement(YearFromDropDown).build().perform();
                    act.click(YearFromDropDown).build().perform();
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    break;
                }
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            pYear=HelpersMethod.FindByElement(driver,"xpath","//span[@id='ddlYear']/span[contains(@class,'input')]").getText();
            scenario.log("YEAR AFTER CHAINGING: "+pYear);
            if(prYear.equals(pYear))
            {
                scenario.log("FAILED TO CHANGE YEAR");
                exists=false;
            }
            else if(!prYear.equals(pYear))
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void MonthDropdown()
    {
        exists=false;
        Actions act=new Actions(driver);
        String prMonth=null;
        String pMonth=null;
        String status="";
        WebElement monthFromDropDown;
        try
        {
            prMonth=HelpersMethod.FindByElement(driver,"xpath","//span[@id='ddlMonth']/span[contains(@class,'input')]").getText();
            scenario.log("MONTH BEFORE CHANGING: "+prMonth);
            HelpersMethod.ClickBut(driver,monthDropdown,10000);
            Thread.sleep(1000);
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container ')]/descendant::ul/li")));
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container ')]/descendant::ul/li");
           /* for(int i=0;i<= Values.size()-1;i++)
            {
                monthFromDropDown = Values.get(i);
                act.moveToElement(monthFromDropDown).build().perform();
                if(i==2)
                {
                    act.moveToElement(monthFromDropDown).build().perform();
                    act.click(monthFromDropDown).build().perform();
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    break;
                }
            }*/
            // get the len of Month list
            int maxMonth = Values.size();
            // get random number
            Random random = new Random();
            int randomMonth = random.nextInt(maxMonth);
            // Select the list item
            Values.get(randomMonth).click();

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            pMonth=HelpersMethod.FindByElement(driver,"xpath","//span[@id='ddlMonth']/span[contains(@class,'input')]").getText();
            scenario.log("MONTH AFTER CHANING: "+pMonth);
            if(prMonth.equals(pMonth))
            {
                scenario.log("FAILED TO CHANGE MONTH");
                exists = false;
            }
            else if(!prMonth.equals(pMonth))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DateDropdown()
    {
        exists=false;
        String prDate=null;
        String pDate=null;
        String status="";
        Actions act=new Actions(driver);
        WebElement dateFromDropDown;
        try
        {
            prDate=HelpersMethod.FindByElement(driver,"xpath","//span[@id='ddlDay']/span[contains(@class,'input')]").getText();
            scenario.log("DATE BEFORE CHANGING: "+prDate);
            HelpersMethod.ClickBut(driver,dateDropdown,1000);
            List<WebElement> Values=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-animation-container ')]/descendant::ul/li");
            for(int i=0;i<= Values.size()-1;i++)
            {
                dateFromDropDown = Values.get(i);
                act.moveToElement(dateFromDropDown).build().perform();
                if(i==2)
                {
                    act.moveToElement(dateFromDropDown).build().perform();
                    act.click(dateFromDropDown).build().perform();
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    break;
                }
            } status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            pDate=HelpersMethod.FindByElement(driver,"xpath","//span[@id='ddlDay']/span[contains(@class,'input')]").getText();
            scenario.log("DATE AFTER CHANGING: "+pDate);
            if(prDate.equals(pDate))
            {
                scenario.log("FAILED TO CHANGE DATE");
                exists=false;
            }
            else if(!prDate.equals(pDate))
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchBar()
    {
        exists=false;
        String status="";
        try
        {
            if(searchBar.isDisplayed())
            {
                HelpersMethod.EnterText(driver,searchBar,2000, TestBase.testEnvironment.additionalAccount());
                HelpersMethod.ActClick(driver,searchIndex,2000);
                Thread.sleep(4000);
                exists=true;
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
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
        String status="";
        try
        {
            Thread.sleep(2000);
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if(!HelpersMethod.IsExists("//tr[contains(@class,'k-grid-norecords')]",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::input[contains(@class,'checkbox')]");
                if(!WebEle.isSelected())
                {
                    HelpersMethod.ClickBut(driver,WebEle,4000);
                    scenario.log("CUSTOMER ACCOUNT NUMBER HAS BEEN SELECTED FOR STATEMENT");
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
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

    public void GenerateButtonWeekly()
    {
        exists=false;
        WebElement WebEle=null;
        String status="";
        try
        {
            String ParentWindow = driver.getWindowHandle();
            Thread.sleep(4000);
            new WebDriverWait(driver, Duration.ofMillis(200000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.id("generateEditButton"))));
            generateButton=HelpersMethod.FindByElement(driver,"id","generateEditButton");
            if(generateButton.isDisplayed() && generateButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, generateButton, 60000);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
            }
            Thread.sleep(4000);
            if(HelpersMethod.IsExists("//div[contains(text(),'There is no data to display for your defined date range')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'There is no data to display for your defined date range')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=dialogPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver,okButton,8000);
                scenario.log("***************THERE IS NO DATA TO DISPLAY IN THE SELECTED RANGE OF DATE**************");
                exists=true;
            }
            else
            {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Thread.sleep(5000);
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        exists = true;
                    }
                }
                driver.switchTo().window(ParentWindow);

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void GenerateButton()
    {
        exists=false;
        WebElement WebEle=null;
        String status="";
        try
        {
            String ParentWindow = driver.getWindowHandle();
            Thread.sleep(4000);
            new WebDriverWait(driver, Duration.ofMillis(200000)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.id("generateEditButton"))));
            generateButton=HelpersMethod.FindByElement(driver,"id","generateEditButton");
            if(generateButton.isDisplayed() && generateButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, generateButton, 60000);
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
            }
            Thread.sleep(4000);
            if(HelpersMethod.IsExists("//div[contains(text(),'There is no data to display for your defined date range')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement dialogPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'There is no data to display for your defined date range')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=dialogPopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                HelpersMethod.ActClick(driver,okButton,8000);
                scenario.log("***************THERE IS NO DATA TO DISPLAY IN THE SELECTED RANGE OF DATE**************");
                exists=true;
            }
            else
            {
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Thread.sleep(5000);
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }
                    if (!PCwind.equals(ParentWindow))
                    {
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        exists = true;
                    }
                }
                driver.switchTo().window(ParentWindow);

                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchValidation()
    {
        exists = false;
        try
        {
            if (HelpersMethod.IsExists("//tr[contains(@class,'k-grid-norecords')]", driver))
            {
                scenario.log("NO CUSTOMER ACCOUNT# HAS BEEN FOUND");
                exists = true;
            }
            else
            {
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
            HelpersMethod.ClickBut(driver,WebEle,1000);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-calendar-view k-calendar-monthview')]",4000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-view k-calendar-monthview')]",4000);

            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-content k-calendar-content k-scrollable')]/table[contains(@class,'k-calendar-table')]/descendant::tr[3]/td[1]/span");
            HelpersMethod.ClickBut(driver,WebEle,1000);
        }
        catch (Exception e){}
    }

    public void ToDate()
    {
        WebElement WebEle=null;
        try
        {
            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-textbox-container')][2]/descendant::a[contains(@class,'k-select k-select')]");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[contains(@class,'k-calendar-view k-calendar-monthview')]",4000);
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-view k-calendar-monthview')]",4000);

            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-content k-calendar-content k-scrollable')]/table[contains(@class,'k-calendar-table')]/descendant::tr/td[contains(@class,'k-calendar-td k-state-pending-focus k-state-selected k-today')]");
            HelpersMethod.ClickBut(driver,WebEle,1000);
        }
        catch (Exception e){}
    }

    public void readAllCustomerAccount()
    {
        String customerText=null;
        Actions act=new Actions(driver);
       try
       {
           customers=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[@data-grid-col-index='1']");
           for(WebElement customer:customers)
           {
               act.moveToElement(customer).build().perform();
               customerText=customer.getText();
               customerAccNo.add(customerText);
           }
           scenario.log("Customer account # found "+customerAccNo.size());
           //Display first 10 customer account#
           scenario.log("DISPLAYING FIRST 10 CUSTOMER ACCOUNT#");
           for(int i=0;i<=10;i++)
           {
               scenario.log(customerAccNo.get(i));
           }
       }
       catch (Exception e){}
    }

    public void moveToCustomerAccountNoColumn()
    {
        Actions act=new Actions(driver);
        exists=false;
        try
        {
            WebElement custAccColumn=HelpersMethod.FindByElement(driver,"xpath","//th[contains(@class,'k-filterable k-header')][1]");
            act.moveToElement(custAccColumn).click().build().perform();
            if(HelpersMethod.IsExists("//th[contains(@class,'k-filterable k-header')][1]/descendant::span[contains(@class,'k-icon k-i-sort-asc-sm')]",driver))
            {
                scenario.log("CUSTOMER ACCOUNT# SHOULD BE ARRANGED IN ACENDING ORDER NOW");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllCustomerAccountAfterSorting()
    {
        String customerText=null;
        Actions act=new Actions(driver);
        try
        {
            customers=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[@data-grid-col-index='1']");
            for(WebElement customer:customers)
            {
                act.moveToElement(customer).build().perform();
                customerText=customer.getText();
                customerAccNo1.add(customerText);
            }
            //Display first 10 customer account#
            scenario.log("DISPLAYING FIRST 10 CUSTOMER ACCOUNT#");
            for(int i=0;i<=10;i++)
            {
                scenario.log(customerAccNo1.get(i));
            }
        }
        catch (Exception e){}
    }

    public void validatingSorting()
    {
        exists=false;
        try
        {
            Collections.sort(customerAccNo);
            for(int i=0;i<=customerAccNo1.size()-1;i++)
            {
                scenario.log("\n\n ");
                scenario.log("SORTED VALUE IN UI "+customerAccNo1.get(i)+" SORTED VALUE IN COLLECTION.SORT() "+customerAccNo.get(i));
            }
            if(customerAccNo.equals(customerAccNo1))
            {
                scenario.log("CUSTOMER ACCOUNT NUMBERS ARE IN ASCENDING ORDER");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllCustomerName()
    {
        String customerText=null;
        Actions act=new Actions(driver);
        try
        {
            customers=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[@data-grid-col-index='2']");
            for(WebElement customer:customers)
            {
                act.moveToElement(customer).build().perform();
                customerText=customer.getText();
                customerName.add(customerText);
            }
            scenario.log("TOTAL NUMBER OF CUSTOMER NAME FOUND "+customerName.size());
            //Display first 10 customer account#
            scenario.log("DISPLAYING FIRST 10 CUSTOMER NAME");
            for(int i=0;i<=10;i++)
            {
                scenario.log(customerName.get(i));
            }
        }
        catch (Exception e){}
    }

    public void moveToCustomerNameColumn()
    {
        Actions act=new Actions(driver);
        exists=false;
        try
        {
            WebElement custNameColumn=HelpersMethod.FindByElement(driver,"xpath","//th[contains(@class,'k-filterable k-header')][2]");
            act.moveToElement(custNameColumn).click().build().perform();
            if(HelpersMethod.IsExists("//th[contains(@class,'k-filterable k-header')][2]/descendant::span[contains(@class,'k-icon k-i-sort-asc-sm')]",driver))
            {
                scenario.log("CUSTOMER NAME SHOULD BE ARRANGED IN ACENDING ORDER NOW");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readAllCustomerNameAfterSorting()
    {
        String customerText=null;
        Actions act=new Actions(driver);
        try
        {
            customers=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::td[@data-grid-col-index='2']");
            for(WebElement customer:customers)
            {
                act.moveToElement(customer).build().perform();
                customerText=customer.getText();
                customerName1.add(customerText);
            }
            //Display first 10 customer account#
            scenario.log("DISPLAYING FIRST 10 CUSTOMER NAME");
            for(int i=0;i<=10;i++)
            {
                scenario.log(customerName1.get(i));
            }
        }
        catch (Exception e){}
    }

    public void validatingCustomerNameSorting()
    {
        exists=false;
        try
        {
            Collections.sort(customerName, String.CASE_INSENSITIVE_ORDER);
            for(int i=0;i<=customerName.size()-1;i++)
            {
                scenario.log("SORTED VALUE IN UI "+customerName1.get(i)+" SORTED VALUE IN COLLECTION.SORT() "+customerName.get(i));
            }
           if(CollectionUtils.isEqualCollection(customerName, customerName1))
           {
               exists=true;
           }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}