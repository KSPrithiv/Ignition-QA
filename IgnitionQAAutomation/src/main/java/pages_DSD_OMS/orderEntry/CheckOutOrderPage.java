package pages_DSD_OMS.orderEntry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java8.He;
import org.apache.commons.exec.ExecuteException;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CheckOutOrderPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    String XPath=null;
    boolean exists=false;
    boolean result=false;

    @FindBy(id="checkoutCard")
    private WebElement CheOutOrderPage;

    @FindBy(id = "addPaymentButton")
    private WebElement Add_Payment;

    @FindBy(id="PaymentType")
    private WebElement PayType;

    @FindBy(id="FirstName")
    private WebElement Fname;

    @FindBy(id="LastName")
    private WebElement Lname;

    @FindBy(id="BARoutingNumber")
    private WebElement Route_No;

    @FindBy(xpath="//span[@id='BAAccountType']")
    private WebElement AccType;

    @FindBy(xpath = "//input[@id='BAAccountNumber']")
    private WebElement AccNo;

    @FindBy(id="CCNumber")
    private WebElement Card_No ;

    @FindBy(id="CCExpMonth")
    private WebElement CExp_Month;

    @FindBy(id="CCExpYear")
    private WebElement CExp_Year;

    @FindBy(id="CCCVC")
    private WebElement Cvc;

    @FindBy(id="OkPaymentButton")
    private WebElement OkPay;

    @FindBy(id="DeletePaymentButton")
    private WebElement Pay_Delete_But;

    @FindBy(id="addAddressButton")
    private WebElement Add_Address;

    @FindBy(id="DeleteAddressButton")
    private WebElement Add_Delete_But;

    @FindBy(id="EditAddressButton")
    private WebElement Edit_Address_But;

    @FindBy(id="CancelCheckoutButton")
    private WebElement BackButton;

    @FindBy(id="SubmitCheckoutButton")
    private WebElement NextButton;

    @FindBy(id="allowOrderWithoutPayment")
    private WebElement WithoutPayment;

    public CheckOutOrderPage(WebDriver driver, Scenario scenario) throws InterruptedException, AWTException
    {
        this.driver =driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Verify whether CheckOutOrderPage
    public boolean VerifyCheckOut()
    {
        boolean Result=false;
        try
        {
            if(HelpersMethod.EleDisplay(CheOutOrderPage))
            {
                Result=true;
            }
        }
        catch (Exception e){}
        return Result;
    }

    //Code to click on Back button
    public void BackButton_Click()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
          if(HelpersMethod.IsEnabledByele(BackButton))
          {
              HelpersMethod.ClickBut(driver,BackButton,10);
              scenario.log("CLICKED ON BACK BUTTON");
              if(HelpersMethod.IsExists("//div[@class='loader']",driver))
              {
                  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                  HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
              }
              exists=true;
          }
          Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void NextButton_Click()
    {
        try
        {
            WebElement WebEle=null;
            //HelpersMethod.Implicitwait(driver,40);
            if(HelpersMethod.IsEnabledByele(NextButton))
            {
                HelpersMethod.ScrollElement(driver,NextButton);
                HelpersMethod.ClickBut(driver,NextButton,10);
                scenario.log("CLICKED ON NEXT BUTTON");
               /* for(int i=0;i<=4;i++)
                {
                    if (HelpersMethod.IsExists("//div[contains(text(),'The following products are not within the required')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')])", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Continue']");
                        HelpersMethod.clickOn(driver, WebEle, 10);
                    }
                    if (HelpersMethod.IsExists("//div[contains(text(),'has passed the cutoff time.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Continue']");
                        HelpersMethod.clickOn(driver, WebEle, 10);
                    }
                    if(HelpersMethod.IsExists("//div[contains(text(),'Order total equals zero')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Continue']");
                        HelpersMethod.clickOn(driver, WebEle, 10);
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver,WebEle,10);
                    }
                    //% of average order stock popup
                    if (HelpersMethod.IsExists("//div[contains(text(),'% of your average order for the given products')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-widget k-window k-dialog']/descendant::button[text()='Continue']");
                        HelpersMethod.ClickBut(driver,WebEle,10);
                    }
                }*/
            }
            else
            {
                scenario.log("NEXT BUTTON IS DISABLED");
            }
        }
        catch (Exception e){}
    }

    //Click on down arrow in 'Checkout card'
    public void Delivery_Address_ClickDownArrow()
    {
        try
        {
            WebElement WebEle=null;
            WebEle=HelpersMethod.FindByElement(driver,"id","addressCard");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Check whether application is navigating to checkout card or navigating to order summary page
            if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ClickBut(driver,WebEle,10);
            }
        }
        catch (Exception e){}
    }

    public void DeliveryAddressCard()
    {
        WebElement WebEle=null;
        exists=false;
        try
        {
            //Check whether application is navigating to checkout card or navigating to order summary page
            if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
            {
                //Check whether address is already selected or not. If not selected execute else part
                if (driver.findElement(By.id("SubmitCheckoutButton")).isEnabled())
                {
                    WebEle=HelpersMethod.FindByElement(driver,"id","SubmitCheckoutButton");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }
                else
                {
                    if(HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'i-summary-area__other__section__value')]",driver))
                    {
                        if(HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                            HelpersMethod.ClickBut(driver,WebEle,80);
                        }
                        WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[@class='address-container']/descendant::tbody/tr[1]/descendant::input");
                        HelpersMethod.ClickBut(driver,WebEle,80);

                        //Check whether 'SubmitCheckoutButton' is enabled or not
                        WebEle=HelpersMethod.FindByElement(driver,"id","SubmitCheckoutButton");
                        exists=HelpersMethod.IsEnabledByele(WebEle);
                        Assert.assertEquals(exists,true);
                    }
                }
            }
        }
        catch (Exception e){}
    }

    //Click on Add new Delivery address button
    public void Add_Delivery_Address(String Add1,String Add2,String city,String state,String cunt,String zipNo)
    {
        WebElement WebEle=null;
        try
        {
            //Check whether application is navigating to checkout card or navigating to order summary page
            XPath = "//div[@class='page-content']/descendant::div[@id='checkoutCard']";
            exists = HelpersMethod.IsExists(XPath, driver);
            if (exists == true)
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                HelpersMethod.ClickBut(driver,WebEle,10);
                WebEle=HelpersMethod.FindByElement(driver,"id","addAddressButton");
                HelpersMethod.ClickBut(driver,WebEle,10);
                XPath="//div[contains(text(),'New address')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]";
                exists=HelpersMethod.IsExists(XPath,driver);
                if(exists==true)
                {
                    WebEle=HelpersMethod.FindByElement(driver,"id","Address");
                    HelpersMethod.ActSendKey(driver,WebEle,10,Add1);
                    scenario.log("ADDRESS ENTERED IN FIRST ADDRESS INPUT BOX "+Add1);
                    WebEle=HelpersMethod.FindByElement(driver,"id","Address2");
                    HelpersMethod.ActSendKey(driver,WebEle,10,Add2);
                    scenario.log("ADDRESS ENTERED IN SECOND ADDRESS INPUT BOX "+Add2);
                    WebEle=HelpersMethod.FindByElement(driver,"id","City");
                    HelpersMethod.ActSendKey(driver,WebEle,10,city);
                    scenario.log("CITY NAME ENTERED IN INPUT BOX "+city);
                   /// HelpersMethod.Implicitwait(driver,2);
                    WebEle=HelpersMethod.FindByElement(driver,"id","State");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                    HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-list-container ')]/descendant::li","//div[contains(@class,'k-list-container ')]/descendant::li[contains(text(),'"+state+"')]",state);
                    WebEle=HelpersMethod.FindByElement(driver,"id","Zip");
                    HelpersMethod.ActSendKey(driver,WebEle,10,zipNo);
                    scenario.log("ZIP VALUE ENTERED IS "+zipNo);
                    WebEle=HelpersMethod.FindByElement(driver,"id","Country");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                    HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-list-container ')]/descendant::li","//div[contains(@class,'k-list-container ')]/descendant::li[contains(text(),'"+cunt+"')]",cunt);
                    ////HelpersMethod.Implicitwait(driver,2);
                    WebEle=HelpersMethod.FindByElement(driver,"id","ConfirmAddressButton");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }
            }
        }
        catch (Exception e){}
    }

    //Code to Edit Delivery Address
    public boolean Edit_DeliveryAddress(String Add2,String Change_Add2)
    {
        WebElement WebEle=null;
        boolean found=false;
        try
        {
            //Check whether application is navigating to checkout card or navigating to order summary page
            if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
            {
                //Click on Down arrow in Select address card
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                HelpersMethod.ScrollElement(driver,WebEle);
                HelpersMethod.ClickBut(driver,WebEle,10);
                if(HelpersMethod.IsExists("//td[@class='address-cell']/following-sibling::td[contains(text(),'"+Add2+"')]",driver))
                {
                    //Select radio button to select specific address
                    WebEle=driver.findElement(By.xpath("//input[contains(@id,'"+Add2+"')]"));
                    HelpersMethod.ActClick(driver,WebEle,10);
                    if(HelpersMethod.IsExists("//td[contains(text(),'"+Add2+"')]/ancestor::tr/descendant::button[@id='EditAddressButton']",driver))
                    {
                        //Once the radio button is selected Edit, Delete button will be visible. Click on Edit button
                        WebEle=driver.findElement(By.xpath("//td[contains(text(),'"+Add2+"')]/ancestor::tr/descendant::button[@id='EditAddressButton']"));
                        HelpersMethod.ActClick(driver,WebEle,10);
                        //Check for Address popup
                        if(HelpersMethod.IsExists("//div[contains(text(),'Edit address')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                        {
                            //Edit the address 2 input box
                            WebEle=HelpersMethod.FindByElement(driver,"id","Address2");
                            HelpersMethod.WebElementClearInput(WebEle);
                            HelpersMethod.ActSendKey(driver,WebEle,10,Change_Add2);
                            scenario.log("SECOND ADDRESS HAS BEEN CHANGED TO "+Change_Add2);
                            WebEle=HelpersMethod.FindByElement(driver,"id","ConfirmAddressButton");
                            HelpersMethod.ClickBut(driver,WebEle,10);
                            found=true;
                        }
                    }
                }
            }
            Assert.assertEquals(found,true);
        }
        catch (Exception e){}
        return found;
    }

    public boolean Delete_DeliveryAddress(String Add2)
    {
        boolean found=false;
        WebElement WebEle=null;
        try
        {
            //Check whether application is navigating to checkout card or navigating to order summary page
            XPath = "//div[@class='page-content']/descendant::div[@id='checkoutCard']";
            exists = HelpersMethod.IsExists(XPath, driver);
            if (exists == true)
            {
                //Click on Down arrow in Select address card
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                HelpersMethod.ClickBut(driver,WebEle,10);
                XPath="//td[@class='address-cell']/following-sibling::td[contains(text(),'"+Add2+"')]";
                exists=HelpersMethod.IsExists(XPath,driver);
                if(exists==true)
                {
                    //Select radio button to select specific address
                    WebEle=driver.findElement(By.xpath("//input[contains(@id,'"+Add2+"')]"));
                    HelpersMethod.ActClick(driver,WebEle,10);
                    XPath="//td[contains(text(),'"+Add2+"')]/ancestor::tr/descendant::button[@id='DeleteAddressButton']";
                    exists=HelpersMethod.IsExists(XPath,driver);
                    if(exists==true)
                    {
                        //Once the radio button is selected Delete button will be visible. Click on Edit button
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//td[contains(text(),'"+Add2+"')]/ancestor::tr/descendant::button[@id='DeleteAddressButton']");
                        HelpersMethod.ClickBut(driver,WebEle,10);

                        //handling confirmation popup
                        XPath="//div[contains(text(),'Confirm delete')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]";
                        exists=HelpersMethod.IsExists(XPath,driver);
                        if(exists==true)
                        {
                            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ClickBut(driver,WebEle,10);
                            scenario.log("DELIVERY ADDRESS HAS BEEN DELETED");
                        }
                    }
                }
                XPath="//td[@class='address-cell']/following-sibling::td[contains(text(),'"+Add2+"')]";
                exists=HelpersMethod.IsExists(XPath,driver);
                if(exists==false)
                {
                    found=true;
                }
            }
        }
        catch (Exception e){}
        return found;
    }

    //Code for Selecting payment method
    public void Select_PaymentMethod_ClickDownArrow()
    {
        try
        {
            WebElement WebEle=null;
            WebEle=HelpersMethod.FindByElement(driver,"id","addressCard");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Check whether application is navigating to checkout card or navigating to order summary page
            XPath = "//div[@class='page-content']/descendant::div[@id='checkoutCard']";
            exists = HelpersMethod.IsExists(XPath, driver);
            if (exists == true)
            {
                if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='paymentMethodCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                    HelpersMethod.ClickBut(driver,WebEle,60);
                }
            }
        }
        catch (Exception e){}
    }

    //Select Payment method
    public void PaymentMethod()
    {
        try
        {
            WebElement WebEle=null;
            //Check whether application is navigating to checkout card or navigating to order summary page
            if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
            {
                //Check whether address is already selected or not. If not selected execute else part
                if (HelpersMethod.FindByElement(driver,"id","SubmitCheckoutButton").isEnabled())
                {
                    WebEle=HelpersMethod.FindByElement(driver,"id","SubmitCheckoutButton");
                    HelpersMethod.ClickBut(driver,WebEle,10);
                }
                else
                {
                    if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']/descendant::span[contains(@class,'i-summary-area__other__section__value')]",driver))
                    {
                        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[@id='paymentMethodCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                            HelpersMethod.ClickBut(driver,WebEle,60);
                        }
                        WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[@class='payment-method-container']/descendant::tbody/tr[1]/descendant::input");
                        HelpersMethod.ClickBut(driver,WebEle,60);
                        WebEle=HelpersMethod.FindByElement(driver,"id","SubmitCheckoutButton");
                        HelpersMethod.ClickBut(driver,WebEle,60);
                    }
                }
            }
        }
        catch (Exception e){}
    }

    //Adding new payment method
    public void Adding_New_PaymentMethod(String Paytype, String Finame, String Laname, String AccountType, String Route, String AccNumb)
    {
        try
        {
            HelpersMethod.ClickBut(driver,Add_Payment,10);
            if(HelpersMethod.IsExists("//div[contains(text(),'New payment method')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                //Click on Payment type drop down
                HelpersMethod.ClickBut(driver,PayType,10);
                //Select Bank account from Payment type drop down
                HelpersMethod.DropDownMenu(driver,Paytype);
                //enter first name
                HelpersMethod.EnterText(driver,Fname,10,Finame);
                scenario.log("FIRST NAME ENTERED "+Finame);
                //Enter last name
                HelpersMethod.EnterText(driver,Lname,10,Laname);
                scenario.log("LAST NAME ENTERED IS "+Laname);
                //Click on Account type drop down
                HelpersMethod.ClickBut(driver,AccType,10);
                //Account type selection
                HelpersMethod.DropDownMenu(driver,AccountType);
                //Enter Route#
                HelpersMethod.EnterText(driver,Route_No,10,Route);
                scenario.log("ROUTE ENTERED IS "+Route);
                //Enter Account no
                HelpersMethod.EnterText(driver,AccNo,10,AccNumb);
                scenario.log("ACCOUNT NUMBER ENTERED IS "+AccNumb);
                //Click on OK button
                HelpersMethod.ClickBut(driver,OkPay,10);
            }
        }
        catch (Exception e){}
    }

    //Click on Delete button
    public void Delete_PaymentMethod(String DeletePay)
    {
        try
        {
            WebElement WebEle=null;
            if(HelpersMethod.IsExists("//td[contains(text(),'Divya AR')]/ancestor::tr/descendant::div[@class='i-btn-radio ']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Savings - Personal')]/ancestor::tr/descendant::div[@class='i-btn-radio ']");
                HelpersMethod.ClickBut(driver,WebEle,10);
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Savings - Personal')]/ancestor::tr/descendant::button[@id='DeletePaymentButton']");
                HelpersMethod.ClickBut(driver,WebEle,10);
                scenario.log("PAYMENT METHOD DELETED");
            }
        }
        catch (Exception e){}
    }

    //Code to verify Display of "Continue without providing payment"
    public boolean Verify_Existence_of_ContinuePayment()
    {
        result=false;
        try
        {
            result=HelpersMethod.EleDisplay(WithoutPayment);
        }
        catch (Exception e){}
        return result;
    }

    //Click on "Continue without providing payment"
    public void Click_On_Without_Providing_Payment()
    {
        try
        {
            HelpersMethod.ClickBut(driver,WithoutPayment,40);
            scenario.log("CONTINUE ORDER WITHOUT PAYMENT METHOD IS SELECTED");
        }
        catch (Exception e){}
    }

    //Selecting first payment method
    public void SelectPaymentMethod()
    {
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='payment-method-container']/descendant::tbody/tr[1]/descendant::input");
            HelpersMethod.ClickBut(driver,WebEle,40);
        }
        catch (Exception e){}
    }
}
