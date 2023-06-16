package pages_DSD_OMS.userManagement;


import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;
import util.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserManagementPage {
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;

    static String currentURL=null;
    UserManagementPage userManagementPage;
    @FindBy(xpath = "//div[@class='user-info-initial-container']")
    private WebElement IconContainer;

    @FindBy(xpath = "//div[contains(@class,'user-info-container')]/div[contains(@class,'user-info-initial-container')]")
    private WebElement UserIcon;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement Firstname;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement Lastname;

    @FindBy(xpath = "//input[@id='UserName']")
    private WebElement UserName;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement EnterEmail;

    @FindBy(xpath = "//input[@type='email' and @id='ConfirmEmail']")
    private WebElement Confirm_Email;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement Password;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement Confirm_Password;

    @FindBy(xpath = "//input[@role='listbox']")
    private WebElement Role_selectbox;

    @FindBy(xpath = "//button[@id='saveEditButton']")
    private WebElement Register;

    //New User registration
    @FindBy(id="add-account-part-1")
    private WebElement Acc1;

    @FindBy(id="add-account-part-2")
    private WebElement Acc2;

    @FindBy(id="add-account-part-3")
    private WebElement Acc3;

    @FindBy(id="FirstName")
    private WebElement Fname;

    @FindBy(id="LastName")
    private WebElement Lname;

    @FindBy(id="UserName")
    private WebElement Uname;

    @FindBy(id="Email")
    private WebElement Actual_Email;

    @FindBy(id="ConfirmEmail")
    private WebElement ConfirmMail;

    @FindBy(id="Password")
    private WebElement Pass;

    @FindBy(id="ConfirmPassword")
    private WebElement ConfirmPass;

    @FindBy(xpath="//button[text()='Cancel']")
    private WebElement RegCancel;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement Registration;

    String uname=null;

    String Email= RandomValues.generateEmail(30);
    String Pass_Confirm= RandomValues.generateStringWithAllobedSplChars(15);


    //Initializing the Page Objects:
    public UserManagementPage(WebDriver driver, Scenario scenario) {
        this.scenario = scenario;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Enter 'User Management' in search box and clicks the menu to navigate
    public String navigateToUserManagement()
    {
        exists = false;
        WebElement WebEle = null;
        String status = null;
//        status = HelpersMethod.returnDocumentStatus(driver);
//        if (status.equals("loading"))
//        {
//            HelpersMethod.waitTillLoadingPage(driver);
//        }
        try
        {
            Actions act = new Actions(driver);
            WebElement Search_Input = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");
            act.moveToElement(Search_Input).click().sendKeys("User Management").build().perform();
            WebElement User_ManagementMenu = HelpersMethod.FindByElement(driver, "xpath", "//span[text()='User Management']");
            HelpersMethod.ClickBut(driver, User_ManagementMenu, 100);
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
            if(HelpersMethod.IsExists("//span[text()='User Management']",driver))
            {
                scenario.log("NAVIGATED TO USER MANAGEMENT(DSD) PAGE");
            }
            //apr-11
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading")) {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            else
            {
                scenario.log("USER MANAGEMENT (DSD) MAY NOT BE ENABLED FOR THE APPLICATION");
            }
            currentURL=driver.getCurrentUrl();
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
        return currentURL;
    }

    public void enter_all_the_fields_CreateUser(){
        //WebElement Firstname = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='drawer-menu-search-container']/descendant::input");

        WebElement WebEle = null;

        HelpersMethod.sendKeys(driver,Firstname,100,"karthikA");

        HelpersMethod.sendKeys(driver,Lastname,100,"keyanA");
        HelpersMethod.sendKeys(driver,UserName,100,"karthikA");

        HelpersMethod.sendKeys(driver,EnterEmail,100,"karthikA@karthika.com");

        HelpersMethod.sendKeys(driver,Confirm_Email,100,"karthikA@karthika.com");

        HelpersMethod.sendKeys(driver,Password,100,"Password@01");

        HelpersMethod.sendKeys(driver,Confirm_Password,100,"Password@01");
        HelpersMethod.sendKeys(driver,Role_selectbox,100,"CompanyAdmin");

        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        Role_selectbox.sendKeys(Keys.ENTER);


        }

    public void ClickRegister() throws InterruptedException
    {
        try
        {
            exists = false;
            WebElement WebEle;
            if (HelpersMethod.IsExists("//button[@id='saveEditButton']", driver))
            {
                HelpersMethod.ScrollElement(driver, Register);
                HelpersMethod.JScriptClick(driver, Register, 20);
                HelpersMethod.waitTillPageLoaded(driver, 2000);

                exists = true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000);
                }
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading")) {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                scenario.log("A new User is Registered");
            }
        }
        catch (Exception e){}
    }

    public void enter_User_Role() throws InterruptedException {
        WebElement WebEle;
        //timeOut:100
        HelpersMethod.sendKeys(driver,Role_selectbox,100,"CompanyAdmin");

        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        Role_selectbox.sendKeys(Keys.ENTER);


    }

    public void EnterAccount_No()
    {
        String Account_No=null;
        try
        {
            if(HelpersMethod.EleDisplay(Acc3))
            {
                Account_No= TestBase.testEnvironment.FullAcc();
                String[] accArray = Account_No.split("-");

                //Enter the Customer Account#
                HelpersMethod.EnterText(driver,Acc1,1,accArray[0]);
                HelpersMethod.EnterText(driver,Acc2,1,accArray[1]);
                HelpersMethod.EnterText(driver,Acc3,1,accArray[2]);
            }
            else if(HelpersMethod.EleDisplay(Acc1))
            {
                HelpersMethod.EnterText(driver,Acc1,1,TestBase.testEnvironment.get_Account());
                scenario.log(TestBase.testEnvironment.get_Account());
            }
        }
        catch (Exception e) {}
    }

    //Enter value in First name input box
    public void EnterFirstName()
    {
        exists=false;
        String fname;
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,Fname,2);
            if(HelpersMethod.EleDisplay(Fname))
            {
                fname= RandomValues.generateRandomString(20);
                HelpersMethod.EnterText(driver,Fname,1,fname);
                if(fname.equals(HelpersMethod.JSGetValueEle(driver,Fname,20)))
                {
                    exists=true;
                    scenario.log("FIRST NAME: "+fname);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }




    //Enter Last name in input box
    public void EnterLastName()
    {
        exists=false;
        String lname;
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,Lname,10);
            if(HelpersMethod.EleDisplay(Lname))
            {
                lname=RandomValues.generateRandomString(20);
                HelpersMethod.EnterText(driver,Lname,1,lname);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Enter username
    public String EnterUserName()
    {
        exists=false;
        //String uname=null;
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,Uname,10);
            if(HelpersMethod.EleDisplay(Uname))
            {
                uname=RandomValues.generateRandomString(20);
                HelpersMethod.EnterText(driver,Uname,10,uname);
                exists=true;
                scenario.log("USER NAME IS "+HelpersMethod.JSGetValueEle(driver,Uname,10));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}


        return uname;
    }




    //Enter Actual_Email Id
    public void ActualEmail()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,Actual_Email,2);
            if(HelpersMethod.EleDisplay(Actual_Email))
            {
                HelpersMethod.ScrollElement(driver,Actual_Email);
                HelpersMethod.EnterText(driver,Actual_Email,2,Email);
                exists=true;
                scenario.log("ACTUAL EMAIL IS "+HelpersMethod.JSGetValueEle(driver,Actual_Email,10));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Enter value in confirmation email input box
    public void EnterConfirmEmail()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,ConfirmMail,4);
            if(HelpersMethod.EleDisplay(ConfirmMail))
            {
                HelpersMethod.EnterText(driver,ConfirmMail,1,Email);
                exists=true;
                scenario.log("CONFIRM MAIL ID IS "+HelpersMethod.JSGetValueEle(driver,ConfirmMail,10));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Enter password in password input box
    public void EnterPassword()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver, Pass,4);
            if(HelpersMethod.EleDisplay(Pass))
            {
                HelpersMethod.EnterText(driver,Pass,1,Pass_Confirm);
                exists=true;
                scenario.log("PASSWORD ENTERED IS "+HelpersMethod.JSGetValueEle(driver,Pass,10));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Enter confirm password in confirm password input box
    public void EnterConfirmPass()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,ConfirmPass,4);
            if(HelpersMethod.EleDisplay(ConfirmPass))
            {
                HelpersMethod.EnterText(driver,ConfirmPass,1,Pass_Confirm);
                exists=true;
                scenario.log("CONFIRM PASSWORD ENTERED IS "+HelpersMethod.JSGetValueEle(driver,ConfirmPass,10));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Click on Register button
    public void ClickOnRegistration()
    {
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,Registration,10);
            if(HelpersMethod.EleDisplay(Registration))
            {
                HelpersMethod.ScrollElement(driver,Registration);
                HelpersMethod.ClickBut(driver,Registration,10);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }
            }
//            if(HelpersMethod.IsExists("//div[contains(text(),'pending approval')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
//            {
//                WebElement pendingApprovalPopup = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
//                WebElement popupTitle = pendingApprovalPopup.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
//                Assert.assertEquals(popupTitle.getText(), "Registration pending approval", "Verify Title message");
//                WebElement oKButton=pendingApprovalPopup.findElement(By.xpath(".//button"));
//                HelpersMethod.ClickBut(driver,oKButton,40);
//            }
        }
        catch (Exception e) {}
    }
    //Click on cancel button in during registration
    public void CancelRegistration()
    {
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,RegCancel,4);
            if (HelpersMethod.EleDisplay(RegCancel))
            {
                HelpersMethod.ScrollElement(driver,RegCancel);
                HelpersMethod.ClickBut(driver,RegCancel,1);
            }

            //HelpersMethod.Implicitwait(driver,20);
        }
        catch (Exception e) {}
    }


}