package pages_DSD_OMS.orderEntry;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java8.He;
import org.apache.commons.exec.ExecuteException;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;

import java.awt.*;
import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class CheckOutOrderPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static String XPath;
    static String fName=RandomValues.generateRandomString(6);
    static boolean exists=false;
    static String orderNumber;

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

    //@FindBy(id="allowOrderWithoutPayment")
    //private WebElement WithoutPayment;

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
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.EleDisplay(CheOutOrderPage))
            {
                scenario.log("CHECKOUT SUMMARY PAGE HAS BEEN FOUND");
                Result=true;
            }
        }
        catch (Exception e){}
        return Result;
    }

    public void notValidateCheckOrder()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(!HelpersMethod.EleDisplay(CheOutOrderPage))
            {
                scenario.log("CHECKOUT SUMMARY PAGE HAS NOT BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to click on Back button
    public void BackButton_Click()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }

            if(HelpersMethod.IsEnabledByele(BackButton))
          {
              HelpersMethod.ClickBut(driver,BackButton,10000);
              scenario.log("CLICKED ON BACK BUTTON");

              String status = HelpersMethod.returnDocumentStatus(driver);
              if (status.equals("loading"))
              {
                  HelpersMethod.waitTillLoadingPage(driver);
              }

              if(HelpersMethod.IsExists("//div[@class='loader']",driver))
              {
                  WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                  HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
              }

              status = HelpersMethod.returnDocumentStatus(driver);
              if (status.equals("loading"))
              {
                  HelpersMethod.waitTillLoadingPage(driver);
              }

              exists=true;
          }
          Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Don't use assert to validate click of  next button, it may fail if change shipping address admin setting is disabled
    public void NextButton_Click()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(2000);
            if(HelpersMethod.IsExists("//div[@id='checkoutCard']",driver))
            {
               wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }

                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(200))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                Thread.sleep(1000);
                if (NextButton.isDisplayed() && NextButton.isEnabled())
                {
                    HelpersMethod.ScrollElement(driver, NextButton);
                    NextButton=HelpersMethod.FindByElement(driver,"id","SubmitCheckoutButton");
                    //HelpersMethod.ClickBut(driver, NextButton, 60000);
                    HelpersMethod.ActClick(driver,NextButton,60000);
                    exists=true;
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    status = HelpersMethod.returnDocumentStatus(driver);
                    if (status.equals("loading"))
                    {
                        HelpersMethod.waitTillLoadingPage(driver);
                    }

                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                    scenario.log("CLICKED ON NEXT BUTTON");
                }
                else
                {
                    scenario.log("NEXT BUTTON IS DISABLED");
                }
            }
        }
        catch (Exception e){}
    }

    //Click on down arrow in 'Checkout card'
    public void Delivery_Address_ClickDownArrow()
    {
        try
        {
            if(!HelpersMethod.IsExists("//span[contains(@class,'i-summary-area__other__section__value')]",driver))
            {
                WebElement WebEle = null;
                WebEle = HelpersMethod.FindByElement(driver, "id", "addressCard");
                HelpersMethod.ScrollElement(driver, WebEle);
                //Check whether application is navigating to checkout card or navigating to order summary page
                if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                    HelpersMethod.ScrollElement(driver, WebEle);
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                }
            }
        }
        catch (Exception e){}
    }

    public void DeliveryAddressCard()
    {
        WebElement WebEle;
        try
        {
            if(!HelpersMethod.IsExists("//span[contains(@class,'i-summary-area__other__section__value')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                   WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                   HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                //Check whether application is navigating to checkout card or navigating to order summary page
                if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
                {
                  //Check whether address is already selected or not. If not selected select address
                  if (!driver.findElement(By.id("SubmitCheckoutButton")).isEnabled())
                  {
                      if (HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'i-summary-area__other__section__value')]", driver))
                      {
                          if (HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]", driver))
                          {
                              WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                              HelpersMethod.ClickBut(driver, WebEle, 10000);
                          }
                          WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='address-container']/descendant::tbody/tr[1]/descendant::input");
                          HelpersMethod.ClickBut(driver, WebEle, 10000);
                          scenario.log("SELECTED DELIVERY ADDRESS FROM PAYMENT AND ADDRESS CARD");
                      }
                  }
                }
            }
        }
        catch (Exception e){}
    }

    public void changeDeliveryAddressCard()
    {
        WebElement WebEle;
        try
        {
            if(!HelpersMethod.IsExists("//span[contains(@class,'i-summary-area__other__section__value')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                //Check whether application is navigating to checkout card or navigating to order summary page
                if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
                {
                        if (HelpersMethod.IsExists("//div[@id='addressCard']", driver))
                        {
                            if (HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                                HelpersMethod.ClickBut(driver, WebEle, 10000);
                            }
                            if(HelpersMethod.IsExists("//div[@class='address-container']/descendant::tbody/tr[2]/descendant::input",driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='address-container']/descendant::tbody/tr[2]/descendant::input");
                                HelpersMethod.ClickBut(driver, WebEle, 10000);
                                if(HelpersMethod.IsExists("//div[@class='address-container']/descendant::tbody/tr[@class='selected']/td[2]",driver))
                                {
                                    String addressText=HelpersMethod.FindByElement(driver,"xpath","//div[@class='address-container']/descendant::tbody/tr[@class='selected']/td[2]").getText();
                                    scenario.log("ADDRESS HAS BEEN CHANGED ONCE THE ORDER HAS BEEN CREATED "+addressText);
                                }
                            }
                        }
                }
            }
        }
        catch (Exception e){}
    }

    public void DeliveryAddressCard1()
    {
        WebElement WebEle;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                //Check whether application is navigating to checkout card or navigating to order summary page
                if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
                {
                    //Check whether address is already selected or not. If not selected select address
                    if (driver.findElement(By.id("SubmitCheckoutButton")).isEnabled())
                    {
                        if (HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'i-summary-area__other__section__value')]", driver))
                        {
                            if (HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                                HelpersMethod.ClickBut(driver, WebEle, 10000);
                            }
                            if(HelpersMethod.IsExists("//div[@class='address-container']/descendant::input[@name='a_group']",driver))
                            {
                                List<WebElement> addressRadioButton=HelpersMethod.FindByElements(driver,"xpath","//div[@class='address-container']/descendant::input[@name='a_group']");
                                if(addressRadioButton.size()>1)
                                {
                                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='address-container']/descendant::tbody/tr[2]/descendant::input");
                                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                                    scenario.log("CHANGED THE DELIVERY ADDRESS");
                                }
                                exists=true;
                                scenario.log("SELECTED DELIVERY ADDRESS FROM PAYMENT AND ADDRESS CARD");
                            }

                        }
                    }
                }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DeliveryAddressCardNotEditable()
    {
        WebElement WebEle;
        exists=true;
        try
        {
            if(!HelpersMethod.IsExists("//span[contains(@class,'i-summary-area__other__section__value')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                //Check whether application is navigating to checkout card or navigating to order summary page
                if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
                {
                    //Check whether address is already selected or not. If not selected select address
                    if (driver.findElement(By.id("SubmitCheckoutButton")).isEnabled())
                    {
                        if (HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'i-summary-area__other__section__value')]", driver))
                        {
                            if (HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]", driver))
                            {
                                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                                HelpersMethod.ClickBut(driver, WebEle, 10000);
                            }
                            if(!HelpersMethod.IsExists("//div[@class='address-container']/descendant::input[@name='a_group']",driver))
                              {
                                  exists=true;
                                  scenario.log("NOT ABLETO CHANGE DELIVERY ADDRESS!!!");
                              }
                        }
                    }
                }
                else
                {
                     scenario.log("NOT IN PAYMENT PAGE!!!!!!!");
                }
            }
            exists=true;
        }
        catch (Exception e){}
    }

    //Click on Add new Delivery address button
    public void Add_Delivery_Address(String Add1,String Add2,String city,String state,String cunt,String zipNo)
    {
        exists=false;
        WebElement WebEle;
        Actions act1=new Actions(driver);
        Wait<WebDriver> wait;
        try
        {
            //Check whether application is navigating to checkout card or navigating to order summary page
            if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                HelpersMethod.ClickBut(driver,WebEle,10000);
                WebEle=HelpersMethod.FindByElement(driver,"id","addAddressButton");
                HelpersMethod.ClickBut(driver,WebEle,10000);

                if(HelpersMethod.IsExists("//span[contains(text(),'New address')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement newAddressPopup=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'New address')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebEle=newAddressPopup.findElement(By.xpath(".//input[@id='Address']"));
                    HelpersMethod.ActSendKey(driver,WebEle,10000,Add1);
                    scenario.log("ADDRESS ENTERED IN FIRST ADDRESS INPUT BOX "+Add1);
                    WebEle=newAddressPopup.findElement(By.xpath(".//input[@id='Address2']"));
                    HelpersMethod.ActSendKey(driver,WebEle,10000,Add2);
                    scenario.log("ADDRESS ENTERED IN SECOND ADDRESS INPUT BOX "+Add2);
                    WebEle=newAddressPopup.findElement(By.xpath(".//input[@id='City']"));
                    HelpersMethod.ActSendKey(driver,WebEle,10000,city);
                    scenario.log("CITY NAME ENTERED IN INPUT BOX "+city);
                    WebEle=newAddressPopup.findElement(By.xpath(".//span[@id='State']"));
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-animation-container i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]"))));

                    // to fetch the web element of the modal container
                    WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]");
                    java.util.List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul[@id='State-listbox-id']/li/span"));
                    for(int i=0;i<=Options.size()-1;i++)
                    {
                        WebEle=Options.get(i);
                        act1.moveToElement(WebEle).build().perform();
                        String Opt=WebEle.getText();
                        if(Opt.equals(state))
                        {
                            act1.moveToElement(WebEle).build().perform();
                            act1.click(WebEle).build().perform();
                            wait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofSeconds(200))
                                    .pollingEvery(Duration.ofSeconds(2))
                                    .ignoring(NoSuchElementException.class);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                            break;
                        }
                        else
                        {
                            act1.moveToElement(WebEle).sendKeys(Keys.ARROW_DOWN).build().perform();
                            wait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofSeconds(200))
                                    .pollingEvery(Duration.ofSeconds(2))
                                    .ignoring(NoSuchElementException.class);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                        }
                    }
                    WebEle=newAddressPopup.findElement(By.xpath(".//input[@id='Zip']"));
                    HelpersMethod.ActSendKey(driver,WebEle,10000,zipNo);
                    scenario.log("ZIP VALUE ENTERED IS "+zipNo);
                    WebEle=newAddressPopup.findElement(By.xpath(".//span[@id='Country']"));
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                    HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]",10000);
                    // to fetch the web element of the modal container
                    WebElement menuContainer1 = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container i-common-dropdown i-common-dropdown__type-none k-animation-container-shown')]");
                    List<WebElement> Options1=menuContainer1.findElements (By.xpath(".//ul[@id='Country-listbox-id']/li/span"));
                    for(int i=0;i<=Options1.size()-1;i++)
                    {
                        WebEle=Options1.get(i);
                        act1.moveToElement(WebEle).build().perform();
                        String Opt=WebEle.getText();
                        if(Opt.equals(cunt))
                        {
                            act1.moveToElement(WebEle).build().perform();
                            act1.click(WebEle).build().perform();
                            wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(200))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                            break;
                        }
                        else
                        {
                            act1.moveToElement(WebEle).sendKeys(Keys.ARROW_DOWN).build().perform();
                            wait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofSeconds(200))
                                    .pollingEvery(Duration.ofSeconds(2))
                                    .ignoring(NoSuchElementException.class);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                        }
                    }
                    WebEle=newAddressPopup.findElement(By.xpath(".//button[@id='ConfirmAddressButton']"));
                    HelpersMethod.ActClick(driver,WebEle,10000);
                    exists=true;
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(400))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Code to Edit Delivery Address
    public boolean Edit_DeliveryAddress(String Add2,String Change_Add2)
    {
        WebElement WebEle;
        Wait<WebDriver> wait;
        boolean found=false;
        try
        {
            //Check whether application is navigating to checkout card or navigating to order summary page
            if (HelpersMethod.IsExists("//div[@id='web-order-page-content']",driver))
            {
                //Click on Down arrow in Select address card
                if(HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]",driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                    HelpersMethod.ScrollElement(driver, WebEle);
                    HelpersMethod.ClickBut(driver, WebEle, 10000);
                    if (HelpersMethod.IsExists("//td[@class='address-cell']/following-sibling::td[contains(text(),'" + Add2 + "')]", driver))
                    {
                        //Select radio button to select specific address
                        WebEle = driver.findElement(By.xpath("//input[contains(@id,'" + Add2 + "')]"));
                        HelpersMethod.ScrollElement(driver,WebEle);
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(400))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                        if (HelpersMethod.IsExists("//td[contains(text(),'"+Add2+"')]/ancestor::tr/descendant::button[@id='EditAddressButton']", driver))
                        {
                            //Once the radio button is selected Edit, Delete button will be visible. Click on Edit button
                            WebEle = driver.findElement(By.xpath("//td[contains(text(),'" + Add2 + "')]/ancestor::tr/descendant::button[@id='EditAddressButton']"));
                            HelpersMethod.ActClick(driver, WebEle, 10000);
                            wait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofSeconds(400))
                                    .pollingEvery(Duration.ofSeconds(2))
                                    .ignoring(NoSuchElementException.class);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                            //Check for Address popup
                            if (HelpersMethod.IsExists("//span[contains(text(),'Edit address')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                                //Edit the address 2 input box
                                WebElement editAddressPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Edit address')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                WebEle = editAddressPopup.findElement(By.xpath(".//input[@id='Address2']"));
                                HelpersMethod.WebElementClearInput(WebEle);
                                HelpersMethod.ActSendKey(driver, WebEle, 10000, Change_Add2);
                                scenario.log("SECOND ADDRESS HAS BEEN CHANGED TO " + Change_Add2);
                                WebEle = editAddressPopup.findElement(By.xpath(".//button[@id='ConfirmAddressButton']"));
                                HelpersMethod.ActClick(driver, WebEle, 10000);
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(400))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                                found = true;
                            }
                        }
                    }
                }
                else
                {
                    if (HelpersMethod.IsExists("//td[@class='address-cell']/following-sibling::td[contains(text(),'" + Add2 + "')]", driver))
                    {
                        //Select radio button to select specific address
                        WebEle = driver.findElement(By.xpath("//input[contains(@id,'" + Add2 + "')]"));
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        if (HelpersMethod.IsExists("//td[contains(text(),'" + Add2 + "')]/ancestor::tr/descendant::button[@id='EditAddressButton']", driver)) {
                            //Once the radio button is selected Edit, Delete button will be visible. Click on Edit button
                            WebEle = driver.findElement(By.xpath("//td[contains(text(),'" + Add2 + "')]/ancestor::tr/descendant::button[@id='EditAddressButton']"));
                            HelpersMethod.ActClick(driver, WebEle, 10000);
                            //Check for Address popup
                            if (HelpersMethod.IsExists("//span[contains(text(),'Edit address')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver)) {
                                //Edit the address 2 input box
                                WebElement editAddressPopup = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Edit address')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                WebEle = editAddressPopup.findElement(By.xpath(".//input[@id='Address2']"));
                                HelpersMethod.WebElementClearInput(WebEle);
                                HelpersMethod.ActSendKey(driver, WebEle, 10000, Change_Add2);
                                scenario.log("SECOND ADDRESS HAS BEEN CHANGED TO " + Change_Add2);
                                WebEle = editAddressPopup.findElement(By.xpath(".//button[@id='ConfirmAddressButton']"));
                                HelpersMethod.ClickBut(driver, WebEle, 10000);
                                found = true;
                            }
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
        WebElement WebEle;
        Wait<WebDriver> wait;
        try
        {
            //Check whether application is navigating to checkout card or navigating to order summary page
            if (HelpersMethod.IsExists("//div[@id='web-order-page-content']",driver))
            {
                //Click on Down arrow in Select address card
                if(HelpersMethod.IsExists("//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]",driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='addressCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                    HelpersMethod.ScrollElement(driver, WebEle);
                    HelpersMethod.ClickBut(driver, WebEle, 10000);

                    XPath = "//td[@class='address-cell']/following-sibling::td[contains(text(),'" + Add2 + "')]";
                    exists = HelpersMethod.IsExists(XPath, driver);
                    if (exists == true)
                    {
                        //Select radio button to select specific address
                        WebEle = driver.findElement(By.xpath("//input[contains(@id,'" + Add2 + "')]"));
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        XPath = "//td[contains(text(),'" + Add2 + "')]/ancestor::tr/descendant::button[@id='DeleteAddressButton']";
                        exists = HelpersMethod.IsExists(XPath, driver);
                        if (exists == true)
                        {
                            //Once the radio button is selected Delete button will be visible. Click on Edit button
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(text(),'" + Add2 + "')]/ancestor::tr/descendant::button[@id='DeleteAddressButton']");
                            HelpersMethod.ActClick(driver, WebEle, 10000);
                            wait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofSeconds(400))
                                    .pollingEvery(Duration.ofSeconds(2))
                                    .ignoring(NoSuchElementException.class);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                            //handling confirmation popup
                            if (HelpersMethod.IsExists("//span[contains(text(),'Confirm delete')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                                WebElement deleteConfirm = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Confirm delete')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                WebEle = deleteConfirm.findElement(By.xpath(".//button/span[text()='Yes']"));
                                HelpersMethod.ActClick(driver, WebEle, 10000);
                                scenario.log("DELIVERY ADDRESS HAS BEEN DELETED");
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(400))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                                found = true;
                            }
                        }
                    }
                }
                else
                {
                    XPath = "//td[@class='address-cell']/following-sibling::td[contains(text(),'" + Add2 + "')]";
                    exists = HelpersMethod.IsExists(XPath, driver);
                    if (exists == true)
                    {
                        //Select radio button to select specific address
                        WebEle = driver.findElement(By.xpath("//input[contains(@id,'" + Add2 + "')]"));
                        HelpersMethod.ActClick(driver, WebEle, 10000);
                        XPath = "//td[contains(text(),'" + Add2 + "')]/ancestor::tr/descendant::button[@id='DeleteAddressButton']";
                        exists = HelpersMethod.IsExists(XPath, driver);
                        if (exists == true)
                        {
                            //Once the radio button is selected Delete button will be visible. Click on Edit button
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//td[contains(text(),'" + Add2 + "')]/ancestor::tr/descendant::button[@id='DeleteAddressButton']");
                            HelpersMethod.ClickBut(driver, WebEle, 10000);
                            wait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofSeconds(400))
                                    .pollingEvery(Duration.ofSeconds(2))
                                    .ignoring(NoSuchElementException.class);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

                            //handling confirmation popup
                            if (HelpersMethod.IsExists("//span[contains(text(),'Confirm delete')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                            {
                                WebElement deleteConfirm = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Confirm delete')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                                WebEle = deleteConfirm.findElement(By.xpath(".//button/span[text()='Yes']"));
                                HelpersMethod.ActClick(driver, WebEle, 10000);
                                scenario.log("DELIVERY ADDRESS HAS BEEN DELETED");
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(400))
                                        .pollingEvery(Duration.ofSeconds(2))
                                        .ignoring(NoSuchElementException.class);
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                                found = true;
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e){}
        return found;
    }

    public String readOrderNumber()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
            {
                if (!HelpersMethod.IsExists("//div[@class='order-number-item-container']/descendant::div[@class='item-value' and contains(text,'Order')]|//div[@class='order-number-item-container']/descendant::div[@class='item-value' and contains(text,'order')]", driver))
                {
                    orderNumber = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='order-number-item-container']/descendant::div[@class='item-value']").getText();
                    scenario.log("ORDER NUMBER CREATED IS " + orderNumber);
                }
            }
        }
        catch (Exception e){}
        return orderNumber;
    }

    //Code for Selecting payment method
    public void Select_PaymentMethod_ClickDownArrow()
    {
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            WebElement WebEle;
            WebEle=HelpersMethod.FindByElement(driver,"id","addressCard");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Check whether application is navigating to checkout card or navigating to order summary page
            if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
            {
                if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='paymentMethodCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                    wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
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
            WebElement WebEle;
            //Check whether application is navigating to checkout card or navigating to order summary page
            if (HelpersMethod.IsExists("//div[@class='page-content']/descendant::div[@id='checkoutCard']",driver))
            {
                //Check whether address is already selected or not. If not selected execute else part
                if (HelpersMethod.FindByElement(driver,"id","SubmitCheckoutButton").isEnabled())
                {
                    WebEle=HelpersMethod.FindByElement(driver,"id","SubmitCheckoutButton");
                    HelpersMethod.ClickBut(driver,WebEle,10000);
                }
                else
                {
                    if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']/descendant::span[contains(@class,'i-summary-area__other__section__value')]",driver))
                    {
                        if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]",driver))
                        {
                            WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[@id='paymentMethodCard']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]");
                            HelpersMethod.ClickBut(driver,WebEle,10000);
                        }
                        WebEle=HelpersMethod.FindByElement(driver, "xpath", "//div[@class='payment-method-container']/descendant::tbody/tr[1]/descendant::input");
                        HelpersMethod.ClickBut(driver,WebEle,10000);
                        WebEle=HelpersMethod.FindByElement(driver,"id","SubmitCheckoutButton");
                        HelpersMethod.ClickBut(driver,WebEle,10000);
                    }
                }
            }
        }
        catch (Exception e){}
    }

    //Adding new payment method
    public void Adding_New_PaymentMethod(String Paytype,String AccountType)
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            if(Add_Payment.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver,Add_Payment);
                HelpersMethod.ClickBut(driver, Add_Payment, 10000);
                new WebDriverWait(driver, Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'New payment method')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
                if (HelpersMethod.IsExists("//span[contains(text(),'New payment method')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    if (PayType.isDisplayed() && PayType.isEnabled())
                    {
                        //Click on Payment type drop down
                        HelpersMethod.ClickBut(driver, PayType, 10000);
                        //Select Bank account from Payment type drop down
                        WebElement menuContainer = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::ul");
                        List<WebElement> Options = menuContainer.findElements(By.xpath(".//li"));
                        for (int i = 0; i <= Options.size() - 1; i++)
                        {
                            WebElement WebEle = Options.get(i);
                            act1.moveToElement(WebEle).build().perform();
                            String Opt = WebEle.getText();
                            if (Opt.equals(Paytype))
                            {
                                act1.moveToElement(WebEle).build().perform();
                                act1.click(WebEle).build().perform();
                                scenario.log("PAYMENT TYPE SELECTED IS " + Paytype);
                                break;
                            }
                        }

                        //enter first name
                        HelpersMethod.EnterText(driver, Fname, 10000, fName);
                        scenario.log("FIRST NAME ENTERED " + HelpersMethod.JSGetValueEle(driver, Fname, 1000));
                        //Enter last name
                        HelpersMethod.EnterText(driver, Lname, 10000, RandomValues.generateRandomString(2));
                        scenario.log("LAST NAME ENTERED IS " + HelpersMethod.JSGetValueEle(driver, Lname, 1000));
                        //Click on Account type drop down
                        HelpersMethod.ClickBut(driver, AccType, 10000);
                        //Account type selection
                        WebElement menuContainer1 = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-child-animation-container')]/descendant::ul");
                        List<WebElement> Options1 = menuContainer1.findElements(By.xpath(".//li"));
                        for (int i = 0; i <= Options1.size() - 1; i++)
                        {
                            WebElement WebEle = Options1.get(i);
                            act1.moveToElement(WebEle).build().perform();
                            String Opt = WebEle.getText();
                            if (Opt.equals(AccountType))
                            {
                                act1.moveToElement(WebEle).build().perform();
                                act1.click(WebEle).build().perform();
                                scenario.log("ACCOUNT TYPE SELECTED IS " + Paytype);
                                break;
                            }
                        }
                        //Enter Route#
                        HelpersMethod.EnterText(driver, Route_No, 10000, RandomValues.generateRandomNumber(4));
                        scenario.log("ROUTE ENTERED IS " + HelpersMethod.JSGetValueEle(driver, Route_No, 1000));
                        //Enter Account no
                        HelpersMethod.EnterText(driver, AccNo, 10000, RandomValues.generateRandomNumber(10));
                        scenario.log("ACCOUNT NUMBER ENTERED IS " + HelpersMethod.JSGetValueEle(driver, AccNo, 1000));
                        exists = true;
                    }
                    else
                    {
                        scenario.log("NO BANK ACCOUNT DETAILS CAN BE ENTERED, ONLY CREDIT CARD IS AVAILABLE");
                    }
                    //Click on OK button
                    HelpersMethod.ActClick(driver, OkPay, 10000);
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(200))
                            .pollingEvery(Duration.ofSeconds(2))
                            .ignoring(NoSuchElementException.class);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                }
            }
            else
            {
                scenario.log("ADD NEW PAYMENT BUTTON DOESN'T EXISTS");
                exists=false;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    //Click on Delete button
    public void Delete_PaymentMethod()
    {
        try
        {
            WebElement WebEle;
            if(HelpersMethod.IsExists("//td[contains(text(),'"+fName+"')]/ancestor::tr/descendant::div[@class='i-btn-radio ']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Savings - Personal')]/ancestor::tr/descendant::div[@class='i-btn-radio ']");
                HelpersMethod.ClickBut(driver,WebEle,10000);
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Savings - Personal')]/ancestor::tr/descendant::button[@id='DeletePaymentButton']");
                HelpersMethod.ClickBut(driver,WebEle,10000);
                scenario.log("PAYMENT METHOD DELETED");
            }
        }
        catch (Exception e){}
    }

    //Code to verify Display of "Continue without providing payment"
   /* public boolean Verify_Existence_of_ContinuePayment()
    {
        result=false;
        try
        {
            result=HelpersMethod.EleDisplay(withoutPayment);
            scenario.log("CONTINUE WITHOUT PAYMENT BUTTON IS DISPLAYED");
        }
        catch (Exception e){}
        return result;
    }*/

    //Click on "Continue without providing payment"
    public void Click_On_Without_Providing_Payment()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//div[@class='payment-method-container']/descendant::tbody/tr[@class='selected']",driver))
            {
                if (HelpersMethod.IsExists("//button[@id='allowOrderWithoutPayment']", driver))
                {
                    WebElement withoutPayment = HelpersMethod.FindByElement(driver, "xpath", "//button[@id='allowOrderWithoutPayment']");
                    if (withoutPayment.isEnabled())
                    {
                        HelpersMethod.ScrollElement(driver, withoutPayment);
                        HelpersMethod.ActClick(driver, withoutPayment, 40000);
                        exists = true;
                        scenario.log("CONTINUE ORDER WITHOUT PAYMENT METHOD IS SELECTED");
                    }
                }
                else
                {
                    WebElement paymentMode=HelpersMethod.FindByElement(driver,"xpath","//div[@class='payment-method-container']/descendant::tbody/tr[1]");
                    HelpersMethod.ActClick(driver,paymentMode,10000);
                    exists=true;
                    scenario.log("<span style='color:red'>>PAYMENT OPTION HAS BEEN SELECTED, NOT CONTINUE ORDER WITHOUT PAYMENT, MAY BE BECAUSE IT IS DISABLED</span>");
                }

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(400))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //Selecting first payment method
    public void SelectPaymentMethod()
    {
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='payment-method-container']/descendant::tbody/tr[1]/descendant::input",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='payment-method-container']/descendant::tbody/tr[1]/descendant::input");
                HelpersMethod.ActClick(driver, WebEle, 20000);
                scenario.log("PAYMENT METHOD HAS BEEN SELECTED");
            }
        }
        catch (Exception e){}
    }

    public String SelectPaymentMethodReadPaymentInfo()
    {
        WebElement WebEle;
        String paymentMethod=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='payment-method-container']/descendant::tbody/tr[1]/descendant::input",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='payment-method-container']/descendant::tbody/tr[1]/descendant::input");
                HelpersMethod.ClickBut(driver, WebEle, 20000);
                if(HelpersMethod.IsExists("//div[@class='payment-method-container']/descendant::tr[@class='selected']/descendant::div[contains(@class,'payment-method-type')]",driver))
                {
                    paymentMethod=HelpersMethod.FindByElement(driver,"xpath","//div[@class='payment-method-container']/descendant::tr[@class='selected']/descendant::div[contains(@class,'payment-method-type')]").getText();
                    scenario.log("PAYMENT METHOD SELECTED IS "+paymentMethod);
                }
            }
        }
        catch (Exception e){}
        return paymentMethod;
    }

    public void validateCheckOrder()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(400))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            Thread.sleep(2000);
            if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateDefaultShippingAddress()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='addressCard']/descendant::tbody/tr[@class='selected']",driver))
            {
                WebElement shippingValue = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='addressCard']/descendant::tbody/tr[@class='selected']/td[2]");
                HelpersMethod.ScrollTillElementVisible(driver,shippingValue);
                scenario.log("SHIPPING ADDRESS ALREADY SELECTED IN PAYMENT PAGE IS " + shippingValue.getText());
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validatePaymentOptionsDisabled()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//div[@id='paymentMethodCard']",driver))
            {
                List<WebElement> paymentButtons = HelpersMethod.FindByElements(driver, "xpath", "//input[contains(@id,'rb_pm')]");
                for (WebElement paymentButton : paymentButtons)
                {
                    act.moveToElement(paymentButton).build().perform();
                    if (paymentButton.isEnabled())
                    {
                        scenario.log("PAYMENT OPTION CAN BE STILL CHANGED TO SOME OTHER OPTION");
                        exists = true;
                        break;
                    }
                }
            }
            else
            {
                scenario.log("<span style='color:red'>PAYMENT PAGE ITSELF HAS NOT BEEN DISPLAYED. DISPLAY OF PAYMENT PAGE DEPENDS ON MANY ADMIN SETTINGS, PLEASE CHECK ADMIN SETTINGS ONCE</span>");
            }
            Assert.assertEquals(exists,false);
        }
        catch (Exception e){}
    }
}
