package pages_DSD_OMS.login;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.TestBase;
import util.RandomValues;

import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class UserRegistrationPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    boolean exists=false;

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

    @FindBy(xpath="//button/span[text()='Cancel']")
    private WebElement RegCancel;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement Registration;

    @FindBy(id = "NewUserCompanyRegistration")
    private WebElement NoAccCheckbox;

    @FindBy(id="CustomerName")
    private WebElement CustomerName;

    @FindBy(id="AddressLine1")
    private WebElement Address1;

    @FindBy(id="City")
    private WebElement City;

    @FindBy(id="State")
    private WebElement State;

    @FindBy(id="Zip")
    private WebElement Zip;

    @FindBy(id="PhoneNumber")
    private WebElement Phone;

    String Email= RandomValues.generateEmail(30);
    String Pass_Confirm= RandomValues.generateStringWithAllobedSplChars(15);

    public UserRegistrationPage(WebDriver driver, Scenario scenario) throws InterruptedException, AWTException
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Method to enter Account_No in input box
    public void EnterAccount_No()
    {
        String Account_No;
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
            HelpersMethod.waitTillElementDisplayed(driver,Fname,10000);
            if(HelpersMethod.EleDisplay(Fname))
            {
                fname=RandomValues.generateRandomString(20);
                HelpersMethod.EnterText(driver,Fname,10000,fname);
                if(fname.equals(HelpersMethod.JSGetValueEle(driver,Fname,10000)))
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
            HelpersMethod.waitTillElementDisplayed(driver,Lname,10000);
            if(HelpersMethod.EleDisplay(Lname))
            {
                lname=RandomValues.generateRandomString(20);
                HelpersMethod.EnterText(driver,Lname,10000,lname);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Enter username
    public void EnterUserName()
    {
        exists=false;
        String uname=null;
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,Uname,10000);
            if(HelpersMethod.EleDisplay(Uname))
            {
                uname=RandomValues.generateRandomString(20);
                HelpersMethod.EnterText(driver,Uname,10000,uname);
                exists=true;
                scenario.log("USER NAME IS "+HelpersMethod.JSGetValueEle(driver,Uname,10000));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    //Enter Actual_Email Id
    public void ActualEmail()
    {
        exists=false;
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,Actual_Email,1000);
            if(HelpersMethod.EleDisplay(Actual_Email))
            {
                HelpersMethod.ScrollElement(driver,Actual_Email);
                HelpersMethod.EnterText(driver,Actual_Email,10000,Email);
                exists=true;
                scenario.log("ACTUAL EMAIL IS "+HelpersMethod.JSGetValueEle(driver,Actual_Email,10000));
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
            HelpersMethod.waitTillElementDisplayed(driver,ConfirmMail,10000);
            if(HelpersMethod.EleDisplay(ConfirmMail))
            {
                HelpersMethod.EnterText(driver,ConfirmMail,10000,Email);
                exists=true;
                scenario.log("CONFIRM MAIL ID IS "+HelpersMethod.JSGetValueEle(driver,ConfirmMail,10000));
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
            HelpersMethod.waitTillElementDisplayed(driver, Pass,10000);
            if(HelpersMethod.EleDisplay(Pass))
            {
                HelpersMethod.EnterText(driver,Pass,10000,Pass_Confirm);
                exists=true;
                scenario.log("PASSWORD ENTERED IS "+HelpersMethod.JSGetValueEle(driver,Pass,10000));
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
            HelpersMethod.waitTillElementDisplayed(driver,ConfirmPass,10000);
            if(HelpersMethod.EleDisplay(ConfirmPass))
            {
                HelpersMethod.EnterText(driver,ConfirmPass,10000,Pass_Confirm);
                exists=true;
                scenario.log("CONFIRM PASSWORD ENTERED IS "+HelpersMethod.JSGetValueEle(driver,ConfirmPass,10000));
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
            HelpersMethod.waitTillElementDisplayed(driver,Registration,10000);
            if(HelpersMethod.EleDisplay(Registration))
            {
                HelpersMethod.ScrollElement(driver,Registration);
                HelpersMethod.ClickBut(driver,Registration,10000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
                }
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'pending approval')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement pendingApprovalPopup = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement popupTitle = pendingApprovalPopup.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(popupTitle.getText(), "Registration pending approval", "Verify Title message");
                WebElement oKButton=pendingApprovalPopup.findElement(By.xpath(".//button"));
                HelpersMethod.ClickBut(driver,oKButton,10000);
            }
        }
        catch (Exception e) {}
    }

    //Click on cancel button in during registration
    public void CancelRegistration()
    {
        try
        {
            HelpersMethod.waitTillElementDisplayed(driver,RegCancel,10000);
            if (HelpersMethod.EleDisplay(RegCancel))
            {
                HelpersMethod.ScrollElement(driver,RegCancel);
                HelpersMethod.ClickBut(driver,RegCancel,10000);
            }
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
            {
                HelpersMethod.ClickBut(driver,HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]/descendant::button"),1000);
            }
        }
        catch (Exception e) {}
    }

    //Visibility of 'Do't have account' checkbox
    public void validateDoNotHaveAccount()
    {
        exists=false;
        try
        {
            if(HelpersMethod.EleDisplay(NoAccCheckbox))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateDoNotHaveAccountIsNotVisible()
    {
        exists=false;
        try
        {
            if(!NoAccCheckbox.isDisplayed())
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Click on 'Do't have account' check box
    public void DoNotHaveAccount()
    {
        try
        {
            if(HelpersMethod.EleDisplay(NoAccCheckbox))
            {
                HelpersMethod.ActClick(driver,NoAccCheckbox, 10000);
            }
        }
        catch (Exception e) {}
    }

    //Enter customer name, only whe Donot have Account check box is selected
    public void CustomerName()
    {
        try
        {
            if(HelpersMethod.EleDisplay(CustomerName))
            {
                HelpersMethod.EnterText(driver,CustomerName,1000,RandomValues.generateRandomString(1000));
                scenario.log("CUSTOMER NAME: "+HelpersMethod.JSGetValueEle(driver,CustomerName,10000));
            }
        }
        catch (Exception e) {}
    }

    //Enter value for Addressline1, only when Don't have account check box is selected
    public void Address1()
    {
        try
        {
            if(HelpersMethod.EleDisplay(Address1))
            {
                HelpersMethod.EnterText(driver,Address1,10000,RandomValues.generateRandomString(10));
                scenario.log("ADDRESS ENTERED IS: "+HelpersMethod.JSGetValueEle(driver,Address1,10000));
            }
        }
        catch (Exception e) {}
    }

    //Enter city name, only when Don't have account check box is selected
    public void City()
    {
        try
        {
            if(HelpersMethod.EleDisplay(City))
            {
                HelpersMethod.EnterText(driver,City,10000,RandomValues.generateRandomString(10));
                scenario.log("CITY VALUE ENTERED: "+HelpersMethod.JSGetValueEle(driver,City,10000));
            }
        }
        catch (Exception e) {}
    }

    //Enter Value for state, only when Don't have account check box is selected
    public void State()
    {
        try
        {
            if (HelpersMethod.EleDisplay(State))
            {
                HelpersMethod.EnterText(driver,State, 10000,RandomValues.generateRandomString(2));
                scenario.log("SATE VALUE ENTERED: "+HelpersMethod.JSGetValueEle(driver,State,10000));
            }
        }
        catch (Exception e) {}
    }

    //Enter Zip value, only when Don't have account check box is selected
    public void Zip()
    {
        try
        {
            if (HelpersMethod.EleDisplay(Zip))
            {
                HelpersMethod.EnterText(driver,Zip,10000,RandomValues.generateRandomNumber(10));
                scenario.log("ZIP VALUE IS: "+HelpersMethod.JSGetValueEle(driver,Zip,10000));
            }
        }
        catch (Exception e) {}
    }

    //Enter telephone number, only when Don't have account check box is selected
    public void Telephone()
    {
        try
        {
            if(HelpersMethod.EleDisplay(Phone))
            {
                HelpersMethod.EnterText(driver,Phone,10000,RandomValues.generateRandomNumber(16));
                scenario.log("PHONE VALUE ENTERD IS: "+HelpersMethod.JSGetValueEle(driver,Phone,10000));
            }
        }
        catch (Exception e) {}
    }
}