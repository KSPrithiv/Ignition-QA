package pages_DSD_OMS.adminReport;


import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.RandomValues;
import util.TestBase;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class userAndAdmin_AddNewUserPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String uName=null;
    static String fName=null;
    static String lName=null;
    static String pWord=null;
    static String newEmail=null;
    static String cEmail=null;

    @FindBy(id = "formHorizontalNewUserAll")
    private WebElement allCustomerAccount;

    @FindBy(xpath="//label[text()='First name']/following-sibling::input")
    private WebElement firstName;

    @FindBy(xpath="//label[text()='Last name']/following-sibling::input")
    private WebElement lastName;

    @FindBy(xpath="//label[text()='User name']/following-sibling::input")
    private WebElement userName;

    @FindBy(id="useCompanyDefaultEmail")
    private WebElement defaultEmailToggle;

    @FindBy(xpath="//label[text()='Email address']/following-sibling::input")
    private WebElement emailAddress;

    @FindBy(xpath="//label[text()='Confirm email']/following-sibling::input")
    private WebElement confirmEmail;

    @FindBy(xpath="//label[text()='Password']/following-sibling::input")
    private WebElement passwordTobe;

    @FindBy(xpath="//label[text()='Confirm password']/following-sibling::input")
    private WebElement confirmPassword;

    @FindBy(xpath="//label[text()='Role']/following-sibling::div/descendant::button")
    private WebElement rolesButton;

    @FindBy(xpath="//button[text()='Register']")
    private WebElement registerButton;

    @FindBy(xpath="//button[text()='Cancel']")
    private WebElement cancelButton;

    public userAndAdmin_AddNewUserPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void allCustomerAccountToggleButton()
    {
        exists=true;
        try
        {
            HelpersMethod.ClickBut(driver,allCustomerAccount,1000);
            if(HelpersMethod.IsExists("//div[contains(text(),'This will add all customer accounts to this login')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement allCustomerAccountPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This will add all customer accounts to this login')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement yesButton=allCustomerAccountPopup.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ActClick(driver,yesButton,1000);
            }
        }
        catch (Exception e){}
    }

    public void enterAccountNumber()
    {
        exists=false;
        String fullAcc= TestBase.testEnvironment.FullAcc();
        String[] splitAcc;
        WebElement Acc1=HelpersMethod.FindByElement(driver,"id","add-account-part-1");
        WebElement Acc2=HelpersMethod.FindByElement(driver,"id","add-account-part-2");
        WebElement Acc3=HelpersMethod.FindByElement(driver,"id","add-account-part-3");
        try
        {
            if(fullAcc.contains("-"))
            {
                splitAcc= fullAcc.split("-");
                HelpersMethod.EnterText(driver,Acc1,1000,splitAcc[0]);
                HelpersMethod.EnterText(driver,Acc2,1000,splitAcc[1]);
                HelpersMethod.EnterText(driver,Acc3,1000,splitAcc[2]);
                exists=true;
            }
            else
            {
                HelpersMethod.EnterText(driver,Acc1,1000,fullAcc);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void handleConfirmationPopupForAllCustomersToggle()
    {
        exists=false;
        try
        {
            WebElement confirmationPopup= HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'This will add all customer accounts to this login.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement yesButton=confirmationPopup.findElement(By.xpath(".//button[text()='Yes']"));
            HelpersMethod.ClickBut(driver,yesButton,1000);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterFirstName()
    {
        exists=false;
        try
        {
            fName= RandomValues.generateRandomString(6);
            HelpersMethod.EnterText(driver,firstName,1000,fName);
            exists=true;
            scenario.log("FIRST NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,firstName,1000));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterLastName()
    {
        try
        {
            lName= RandomValues.generateRandomString(4);
            HelpersMethod.EnterText(driver,lastName,1000,lName);
            scenario.log("LAST NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,lastName,1000));
        }
        catch (Exception e){}
    }

    public void enterUserName()
    {
        try
        {
            uName= RandomValues.generateRandomString(4);
            HelpersMethod.EnterText(driver,userName,1000,uName);
            scenario.log("USER NAME ENTERED IS "+HelpersMethod.JSGetValueEle(driver,userName,1000));
        }
        catch (Exception e){}
    }

    public void emailDefaultToggle()
    {
        try
        {
            HelpersMethod.ClickBut(driver,defaultEmailToggle,1000);
        }
        catch (Exception e){}
    }

    public void readDefaultEmailInputBox()
    {
        try
        {
            scenario.log("DEFAULT EMAIL ID IS "+HelpersMethod.JSGetValueEle(driver,emailAddress,1000));
        }
        catch (Exception e){}
    }

    public void readConfirmDefaultEmailInputBox()
    {
        try
        {
            scenario.log("CONFIRM DEFAULT EMAIL IS "+HelpersMethod.JSGetValueEle(driver,confirmEmail,1000));
        }
        catch (Exception e){}
    }

    public void enterNewEmail()
    {
        try
        {
            newEmail=RandomValues.generateEmail(8);
            HelpersMethod.EnterText(driver,emailAddress,1000,newEmail);
            scenario.log("EMAIL ADDRESS ENTERED IS "+HelpersMethod.JSGetValueEle(driver,emailAddress,1000));
        }
        catch (Exception e){}
    }

    public void enterConfirmEmail()
    {
        try
        {
            HelpersMethod.EnterText(driver,confirmEmail,1000,newEmail);
            scenario.log("CONFIRMATION EMAIL ENTERED IS "+HelpersMethod.JSGetValueEle(driver,confirmEmail,1000));
        }
        catch (Exception e){}
    }


    public void passwordInputBox()
    {
        try
        {
            pWord=RandomValues.generateStringWithAllobedSplChars(5);
            HelpersMethod.EnterText(driver,passwordTobe,1000,pWord);
            scenario.log("PASSWORD ENTERED IS "+HelpersMethod.JSGetValueEle(driver,passwordTobe,1000));
        }
        catch (Exception e){}
    }

    public void passwordConfirmationInputBox()
    {
        try
        {
            HelpersMethod.EnterText(driver,confirmPassword,1000,pWord);
            scenario.log("CONFIRMATION PASSWORD ENTERED IS "+HelpersMethod.JSGetValueEle(driver,confirmPassword,1000));
        }
        catch (Exception e){}
    }

    public void rolesButtonClick()
    {
        try
        {
            HelpersMethod.ClickBut(driver,rolesButton,1000);
        }
        catch (Exception e){}
    }

    public void rolesIndexPopup(String filter,String filterDesc)
    {
        WebElement WebEle1;
        WebElement Search2;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Select role')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Select role", "Verify Title message");
                //Select customer account # by clicking Add filter button in customer account # popup
                WebElement AddFilterButton = modalContainer.findElement(By.xpath(".//button/descendant::span[contains(text(),'Add filter')]"));
                HelpersMethod.ActClick(driver, AddFilterButton, 1000);

                //Enter 'Role' in input box
                WebElement Search1 = driver.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::input[contains(@class,'i-search-box__input')]"));
                HelpersMethod.EnterText(driver, Search1, 1000, filter);

                //Click on Check box
                WebEle1 = driver.findElement(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::input[@id='Name']"));
                HelpersMethod.JScriptClick(driver, WebEle1, 1000);

                //Identify radio button and click on Radio button
                HelpersMethod.WaitElementPresent(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 40000);
                HelpersMethod.waitTillElementLocatedDisplayed(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]", 40000);
                WebElement RadioPop = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
                Search2 = RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
                HelpersMethod.ActSendKey(driver, Search2, 1000, filterDesc);

                //Click on Apply button
                WebElement ApplyButton = RadioPop.findElement(By.xpath(".//button[text()='Apply']"));
                HelpersMethod.ClickBut(driver, ApplyButton, 1000);


                WebElement rowInPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]");
                HelpersMethod.ActClick(driver,rowInPopup,1000);
            }
        }
        catch (Exception e){}
    }

    public void clickOnRegistration()
    {
        try
        {
            HelpersMethod.ClickBut(driver,registerButton,1000);
        }
        catch (Exception e){}
    }
}