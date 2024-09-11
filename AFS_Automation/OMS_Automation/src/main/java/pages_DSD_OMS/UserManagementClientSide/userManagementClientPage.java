package pages_DSD_OMS.UserManagementClientSide;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
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
import util.RandomValues;
import util.TestBase;

import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@telusagcg.com
 */
public class userManagementClientPage
{
    /* Created by Divya.Ramadas@telusagcg.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String fName= RandomValues.generateRandomString(4);
    static String lName=RandomValues.generateRandomString(4);
    static String uName=fName+lName;
    static String eMail=RandomValues.generateEmail(30);
    static String passWord=RandomValues.generateStringWithAllobedSplChars(8);

    @FindBy(id="registerByType")
    private WebElement registerBy;

    @FindBy(xpath="//button[contains(@class,'i-indexfield-container__main__button')]")
    private WebElement customerAccountIndex;

    @FindBy(id="FirstName")
    private WebElement firstName;

    @FindBy(id="LastName")
    private WebElement lastName;

    @FindBy(id="UserName")
    private WebElement userName;

    @FindBy(id="Email")
    private WebElement emailValue;

    @FindBy(id="ConfirmEmail")
    private WebElement confirmEmailValue;

    @FindBy(id="Password")
    private WebElement passwordValue;

    @FindBy(id="ConfirmPassword")
    private WebElement confirmPasswordValue;

    @FindBy(xpath="//label[text()='Role']/following-sibling::div/descendant::input")
    private WebElement roleName;

    @FindBy(id="poNumber")
    private WebElement poNo;

    @FindBy(id="saveEditButton")
    private WebElement regirstrationButton;

    @FindBy(id="cancelEditButton")
    private WebElement cancelButton;

    //Constructor
    public userManagementClientPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }
    /*Action methods*/
    public void NavigateToUserManagement()
    {
        exists = false;
        WebElement WebEle;
        String status;
        WebElement UserManageMenu=null;
        status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }

        try
        {
            Actions act = new Actions(driver);
                if (HelpersMethod.IsExists("//div[@class='item-searchbar']//*[local-name()='svg']", driver))
                {
                    WebElement humburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='item-searchbar']//*[local-name()='svg']");
                    HelpersMethod.ActClick(driver, humburger, 10000);
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='drawer-menu-search-container']/descendant::input"))));
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='drawer-menu-search-container']/descendant::input")));
                }
                if(HelpersMethod.IsExists("//div[@class='settings-back-container']",driver))
                {
                    WebElement arrow=HelpersMethod.FindByElement(driver,"xpath","//div[@class='settings-back-container']");
                    HelpersMethod.ActClick(driver,arrow,10000);
                    Thread.sleep(500);
                }
                    WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
                    act.moveToElement(Search_Input).click().sendKeys("User Management").build().perform();
                    UserManageMenu = HelpersMethod.FindByElement(driver, "xpath", "//ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'User Management')] | //ul[contains(@class,'MuiList-root ')]/descendant::span[contains(text(),'User management')]");
                    HelpersMethod.ClickBut(driver, UserManageMenu, 1000);
                    //exists = true;
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading")) {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(150))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading")) {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(150))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                    if (HelpersMethod.IsExists("//div[@class='open-menu-hamburger-icon']//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M3,18H21V16H3Zm0-5H21V11H3ZM3,6V8H21V6Z')]");
                        act.moveToElement(WebEle).click().build().perform();
                    }
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading")) {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(150))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(UserManageMenu.isDisplayed())
            {
                scenario.log("NAVIGATED TO USER MANAGEMENT PAGE");
                exists = true;
            }
            else
            {
                scenario.log("USER MANAGEMENT PAGE MAY NOT BE ENABLED FOR THE APPLICATION, CHECK WITH ADMIN SETTINGS");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void validateUserManagement()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            if(HelpersMethod.IsExists("//span[contains(@class,'spnmoduleNameHeader')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateNewUserTab()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'New user')]/parent::li[@aria-selected='true']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void Horizantal_MenuBar(String MenuItem)
    {
        WebElement WebEle;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            String Menu_Text = null;
            Actions act = new Actions(driver);
            List<WebElement> MenuBars = HelpersMethod.FindByElements(driver, "xpath", "//div[@class='i-tabstrip-wrapper ']/descendant::li/span");
            for (WebElement Menu : MenuBars)
            {
                act.moveToElement(Menu).build().perform();
                Menu_Text = Menu.getText();
                if (MenuItem.equals(Menu_Text) || Menu_Text.contains(MenuItem))
                {
                    act.moveToElement(Menu).build().perform();
                    act.click(Menu).build().perform();
                    break;
                }
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
        } catch (Exception e) {
        }
    }

    public void firstName()
    {
        exists=false;
        try
        {
            HelpersMethod.ClearText(driver,firstName,2000);
            HelpersMethod.EnterText(driver,firstName,1000,fName);
        }
        catch (Exception e){}
    }

    public void lastName()
    {
        exists=false;
        try
        {
            HelpersMethod.ClearText(driver,lastName,2000);
            HelpersMethod.EnterText(driver,lastName,1000,lName);
        }
        catch (Exception e){}
    }

    public void userName()
    {
        exists=false;
        try
        {
            HelpersMethod.ClearText(driver,userName,2000);
            HelpersMethod.EnterText(driver,userName,1000,uName);
        }
        catch (Exception e){}
    }

    public void emailAddress()
    {
        exists=false;
        try
        {
            HelpersMethod.ClearText(driver,emailValue,2000);
            HelpersMethod.EnterText(driver,emailValue,1000,eMail);
        }
        catch (Exception e){}
    }

    public void confirmEmailAddress()
    {
        exists=false;
        try
        {
            HelpersMethod.ClearText(driver,confirmEmailValue,2000);
            HelpersMethod.EnterText(driver,confirmEmailValue,1000,eMail);
        }
        catch (Exception e){}
    }

    public void password()
    {
        exists=false;
        try
        {
            HelpersMethod.ClearText(driver,passwordValue,2000);
            HelpersMethod.EnterText(driver,passwordValue,1000,passWord);
            scenario.log("PASSWORD ENTERED IS "+passWord);
        }
        catch (Exception e){}
    }

    public void confirmPassword()
    {
        exists=false;
        try
        {
            HelpersMethod.ClearText(driver,confirmPasswordValue,2000);
            HelpersMethod.EnterText(driver,confirmPasswordValue,1000,passWord);
        }
        catch (Exception e){}
    }

    public void clickRole()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,roleName,1000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        }
        catch (Exception e){}
    }
    public void clickAgainOnRole()
    {
        exists=false;
        try
        {
            WebElement roleName1=HelpersMethod.FindByElement(driver,"xpath","//label[text()='Role']/following-sibling::div/descendant::input");
            HelpersMethod.ActClick(driver,roleName1,10000);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(120))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        }
        catch (Exception e){}
    }

    public void readAllRolesAvailable()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-list-container')]/descendant::ul/li/span");
            for (WebElement Val : Values)
            {
                act.moveToElement(Val).build().perform();
                String Val_Text = Val.getText();
                scenario.log("ROLE VALUE FOUND IS: "+Val_Text);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectRole(String role)
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> Values = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-list-container')]/descendant::ul/li");
            for (WebElement Val : Values)
            {
                act.moveToElement(Val).build().perform();
                String Val_Text = Val.getText();
                if (Val_Text.equals(role))
                {
                    act.moveToElement(Val).build().perform();
                    act.click(Val).build().perform();
                    exists=true;
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                    }
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void pONumber(String poNum)
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(poNo.isDisplayed())
            {
                HelpersMethod.EnterText(driver, poNo, 1000, poNum);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnRegristration()
    {
        exists=false;
        try
        {
            if(regirstrationButton.isDisplayed() && regirstrationButton.isEnabled())
            {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                HelpersMethod.ClickBut(driver, regirstrationButton, 1000);
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnCancel()
    {
        exists=false;
        try
        {
            if(cancelButton.isDisplayed() && cancelButton.isEnabled())
            {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                HelpersMethod.ClickBut(driver, cancelButton, 1000);

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void refreshPage(String currentURL)
    {
        try
        {
            WebElement WebEle = null;
            scenario.log("CURRENT URL IS " + currentURL);
            //driver.navigate().to(currentURL);
            driver.navigate().refresh();
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
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
        }
        catch (Exception e){}
    }

    public void clickOnRegisterBy()
    {
        exists=false;
        try
        {
            if(registerBy.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,registerBy,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectRegisterBy()
    {
        exists=false;
        Actions act=new Actions(driver);
        String registerByText;
        try
        {
            List<WebElement> registerBys=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li/span");
            int opt=RandomValues.RandomNumber(registerBys.size()-1,1);
            for(int i=0;i<=registerBys.size()-1;i++)
            {
                act.moveToElement(registerBys.get(i)).build().perform();
                if(i==opt)
                {
                    registerByText=registerBys.get(opt).getText();
                    scenario.log("SELECTED REGISTER BY OPTION IS "+registerByText);
                    act.moveToElement(registerBys.get(i)).build().perform();
                    act.click().build().perform();
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnCustomerAccountIndex()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//button[contains(@class,'i-indexfield-container__main__button')]",driver))
            {
                HelpersMethod.ClickBut(driver,customerAccountIndex,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateCustomerAccountIndex()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Customer account index')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCustomerAccountNumber()
    {
        exists=false;
        try
        {
            //Entering account# in search input box
            WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
            WebElement searchBox=modelContainer.findElement(By.xpath(".//input[@class='i-search-box__input']"));
            HelpersMethod.EnterText(driver,searchBox,10000, TestBase.testEnvironment.get_Account());
            //click on search icon
            WebElement searchIcon=modelContainer.findElement(By.xpath(".//*[local-name()='svg' and contains(@class,'i-search-box__search')]"));
            HelpersMethod.ClickBut(driver,searchIcon,10000);
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]",driver))
            {
                //Select customer account# that has been searched
                WebElement accountRow = modelContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')]"));
                HelpersMethod.ActClick(driver, accountRow, 10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
