package pages_DSD_OMS.customerInquiry_DSD;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.RandomValues;
import java.util.List;

public class OrderPage
{
 /* Created by Divya.Ramadas@afsi.com */
 WebDriver driver;
 Scenario scenario;
 static boolean exists=false;
 static String InputValue=null;

 @FindBy(id="CmDelDefaultCoContact")
 private WebElement Contact;

 @FindBy(id="CmDelDefaultCoTel")
 private WebElement Telphone;

 @FindBy(id="CmDelDefaultCoFax")
 private WebElement Fax;

 @FindBy(id="CmDelDefaultHolRule")
 private WebElement Holiday;

 @FindBy(id="CmDelDefaultCoGiver")
 private WebElement DefaultGiver;

 @FindBy(id="CmDelDefaultCoTaker")
 private WebElement DefaultTaker ;

 @FindBy(id="CmOrdCustType")
 private WebElement CustType;

 @FindBy(id="CmShowVoidedOrders")
 private WebElement ShowOrders;

 @FindBy(id="CmShowVoidedSales")
 private WebElement ShowSales;

 @FindBy(id="CmAuthorProductList")
 private WebElement AuthProduct;

 @FindBy(id="CmMinOrderAmt")
 private WebElement MinOrder;

 @FindBy(id="CmMaxOrderAmt")
 private WebElement MaxOrder;

 @FindBy(xpath="//input[@id='CmStartForecastingDate']/ancestor::span[contains(@class,'k-widget k-dateinput')]/following-sibling::a")
 private WebElement StartForecastDate;

 @FindBy(xpath="//input[@id='CmStopForecastingDate']/ancestor::span[contains(@class,'k-widget k-dateinput')]/following-sibling::a")
 private WebElement EndForecastDate;

 @FindBy(id="CmCustForecastFlag")
 private WebElement UseForecast;


 //Action
 public OrderPage(WebDriver driver,Scenario scenario)
 {
  this.driver=driver;
  this.scenario=scenario;
  PageFactory.initElements(driver,this);
 }


 public String DropDownInCustomerInq()
 {
  String ValueSele=null;
  List<WebElement> Options= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
  try
  {
   if(Options.size()==1)
   {
    scenario.log("THERE ARE NO OPTIONS OTHER THAN 'None'");
   }
   else
   {
    if(Options.size()==2)
    {
     for (int i = 0; i <= Options.size() - 1; i++)
     {
      if (i == 1)
      {
       HelpersMethod.ActClick(driver, Options.get(1), 20);
       scenario.log("OPTIONS SELECTED IS " + Options.get(1).getText());
       ValueSele=Options.get(1).getText();
       break;
      }
     }
    }
    else
    {
     for (int i = 0; i <= Options.size() - 1; i++)
     {
      if (i == 2)
      {
       HelpersMethod.ActClick(driver, Options.get(2), 20);
       ValueSele=Options.get(2).getText();
       scenario.log("THE VALUE SELECTED FROM DROP DOWN IS "+ValueSele);
       break;
      }
     }
    }
   }
  }
  catch (Exception e){}
  return ValueSele;
 }

 public void ValidateOrderPage()
 {
  exists=false;
  try
  {
   if(HelpersMethod.IsExists("//p[contains(text(),'Order contacts and schedule')]",driver))
   {
    exists=true;
   }
   else
   {
    scenario.log("NOT NAVIGATED TO ORDER PAGE TAB");
   }
  }
  catch (Exception e){}
 }

 public void ContactInput()
 {
  exists=false;
  try
  {
   HelpersMethod.EnterText(driver,Contact,10, RandomValues.generateRandomString(10));
   InputValue=HelpersMethod.JSGetValueEle(driver,Contact,10);
   scenario.log("CONTACT INPUT ENTERED IS "+InputValue);
   if(InputValue!=null)
   {exists=true;}
   Assert.assertEquals(true,exists);
  }
  catch (Exception e){}
 }

 public void PhoneInput()
 {
  exists=false;
  try
  {
   HelpersMethod.EnterText(driver,Telphone,10, RandomValues.generateRandomNumber(10));
   InputValue=HelpersMethod.JSGetValueEle(driver,Telphone,10);
   scenario.log("PHONE NO ENTERED IS "+InputValue);
   if(InputValue!=null)
   {exists=true;}
   Assert.assertEquals(true,exists);
  }
  catch (Exception e){}
 }

 public void FaxInput()
 {
  exists=false;
  try
  {
   HelpersMethod.EnterText(driver,Fax,10, RandomValues.generateRandomNumber(10));
   InputValue=HelpersMethod.JSGetValueEle(driver,Fax,10);
   scenario.log("FAX INPUT VALUE IS "+InputValue);
   if(InputValue!=null)
   {exists=true;}
   Assert.assertEquals(true,exists);
  }
  catch (Exception e){}
 }

 public void HolidayRuleInput()
 {
  exists=false;
  try
  {
   HelpersMethod.EnterText(driver,Holiday,10, RandomValues.generateRandomString(10));
   InputValue=HelpersMethod.JSGetValueEle(driver,Holiday,10);
   scenario.log("HOLIDAY RUEL INPUT IS "+InputValue);
   if(InputValue!=null)
   {exists=true;}
   Assert.assertEquals(true,exists);
  }
  catch (Exception e){}
 }

 public void DefaultGiverInput()
 {
  exists=false;
  try
  {
   HelpersMethod.EnterText(driver,DefaultGiver,10, RandomValues.generateRandomString(10));
   InputValue=HelpersMethod.JSGetValueEle(driver, DefaultGiver,10);
   scenario.log("DEFAULT GIVER INPUT IS "+ InputValue);
   if(InputValue!=null)
   {exists=true;}
   Assert.assertEquals(true,exists);
  }
  catch (Exception e){}
 }

 public void DefaultTakerInput()
 {
  exists=false;
  try
  {
   HelpersMethod.EnterText(driver,DefaultTaker,10, RandomValues.generateRandomString(10));
   InputValue=HelpersMethod.JSGetValueEle(driver, DefaultTaker,10);
   if(InputValue!=null)
   {exists=true;}
   Assert.assertEquals(true,exists);
  }
  catch (Exception e){}
 }

 public void CustomerOrderDropDown()
 {
  exists=false;
  String TextDropDown=null;
  String TextDropDown1=null;
  WebElement WebEle=null;
  try
  {
   HelpersMethod.ActClick(driver,CustType,10);
   TextDropDown=DropDownInCustomerInq();
   WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmOrdCustType']/span[contains(@class,'k-input')]");
   TextDropDown1=WebEle.getText();
   scenario.log("CUSTOMER ORDER TYPE SELECTED IS "+TextDropDown1);

   if(TextDropDown.equals(TextDropDown1))
   {
    exists=true;
   }
   Assert.assertEquals(exists,true);
  }
  catch (Exception e){}
 }

 public void ShowVoidedOrdersDropDown()
 {
  exists=false;
  String TextDropDown=null;
  String TextDropDown1=null;
  WebElement WebEle=null;
  try
  {
   HelpersMethod.ActClick(driver,ShowOrders,10);
   TextDropDown=DropDownInCustomerInq();
   WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmShowVoidedOrders']/span[contains(@class,'k-input')]");
   TextDropDown1=WebEle.getText();
   scenario.log("SHOW VOID ORDERS VALUE ENTERD IS "+TextDropDown1);

   if(TextDropDown.equals(TextDropDown1))
   {
    exists=true;
   }
   Assert.assertEquals(exists,true);
  }
  catch (Exception e){}
 }

 public void ShowVoidedSalesDropDown()
 {
  exists=false;
  String TextDropDown=null;
  String TextDropDown1=null;
  WebElement WebEle=null;
  try
  {
   HelpersMethod.ActClick(driver,ShowSales,10);
   TextDropDown=DropDownInCustomerInq();
   WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmShowVoidedSales']/span[contains(@class,'k-input')]");
   TextDropDown1=WebEle.getText();
   scenario.log("SHOW VOID SALES VALUE IS "+TextDropDown1);

   if(TextDropDown.equals(TextDropDown1))
   {
    exists=true;
   }
   Assert.assertEquals(exists,true);
  }
  catch (Exception e){}
 }

 public void AuthorizedProdDropDown()
 {
  exists=false;
  String TextDropDown=null;
  String TextDropDown1=null;
  WebElement WebEle=null;
  try
  {
   HelpersMethod.ActClick(driver,AuthProduct,10);
   TextDropDown=DropDownInCustomerInq();
   WebEle=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CmAuthorProductList']/span[contains(@class,'k-input')]");
   TextDropDown1=WebEle.getText();
   scenario.log("AUTHOR PRODUCT SELECTED IS "+TextDropDown1);

   if(TextDropDown.equals(TextDropDown1))
   {
    exists=true;
   }
   Assert.assertEquals(exists,true);
  }
  catch (Exception e){}
 }

 public void MinOrderAmount(float minAmount)
 {
  exists=false;
  try
  {
   HelpersMethod.JSSetValueEle(driver,MinOrder,40, String.valueOf(minAmount));
   InputValue=HelpersMethod.JSGetValueEle(driver,MinOrder,40);
   scenario.log("MIN ORDER AMOUNT IS "+InputValue);
   if(InputValue!=null)
   {exists=true;}
   Assert.assertEquals(true,exists);
  }
  catch (Exception e){}
 }

 public void MaxOrderAmount(float maxAmount)
 {
  exists=false;
  try
  {
   HelpersMethod.JSSetValueEle(driver,MaxOrder,20, String.valueOf(maxAmount));
   InputValue=HelpersMethod.JSGetValueEle(driver,MaxOrder,40);
   scenario.log("MAX ORDER AMOUNT IS "+InputValue);
   if(InputValue!=null)
   {exists=true;}
   Assert.assertEquals(true,exists);
  }
  catch (Exception e){}
 }

 public void StartForecastingCal()
 {
  exists=false;
  try
  {
   HelpersMethod.ActClick(driver,StartForecastDate,20);
   if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
   {
     exists=true;
   }
   Assert.assertEquals(exists,true);
  }
  catch (Exception e){}
 }

 public void SelectStartForecastingCal()
 {
  HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
  new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
  try
  {
   String formattedDate1 = null;
   WebElement WebEle=null;
   exists=false;
   //finding element/date in calendar drop down is enabled or not.
   if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
   {
    WebEle=HelpersMethod.FindByElement(driver,"xpath","//table/descendant::tr[@role='row'][1]/td[@aria-selected='false'][1]");
    HelpersMethod.ActClick(driver,WebEle,20);
    WebEle=HelpersMethod.FindByElement(driver,"id","CmStartForecastingDate");
    formattedDate1=HelpersMethod.JSGetValueEle(driver,WebEle,10);
    if(formattedDate1!=null)
    {
     scenario.log("START DATE FOR FORECASTING SELECTED IS "+formattedDate1);
     exists=true;
    }
   }
   Assert.assertEquals(exists,true);
  }
  catch (Exception e) {}
 }

 public void StopForecastingCal()
 {
  exists=false;
  try
  {
   HelpersMethod.ActClick(driver,EndForecastDate,20);
   if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
   {
    exists=true;
   }
   Assert.assertEquals(exists,true);
  }
  catch (Exception e){}
 }

 public void SelectEndForecastingCal()
 {
  HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-calendar-monthview')]",40);
  new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-calendar-monthview')]")));
  try
  {
   String formattedDate1 = null;
   WebElement WebEle=null;
   exists=false;
   //finding element/date in calendar drop down is enabled or not. if not enabled increase the date by 6 days
   if (HelpersMethod.IsExists("//div[contains(@class,'k-calendar-monthview')]",driver))
   {
    WebEle=HelpersMethod.FindByElement(driver,"xpath","//table/descendant::td[contains(@class,'k-state-pending-focus k-today k-state-focused')]");
    HelpersMethod.ActClick(driver,WebEle,20);
    WebEle=HelpersMethod.FindByElement(driver,"id","CmStartForecastingDate");
    formattedDate1=HelpersMethod.JSGetValueEle(driver,WebEle,10);
    if(formattedDate1!=null)
    {
     scenario.log("END DATE FOR FORECASTING SELECTED IS "+formattedDate1);
     exists=true;
    }
   }
   Assert.assertEquals(exists,true);
  }
  catch (Exception e) {}
 }

 public void UseForecastingCheckbox()
 {
  exists=false;
  try
  {
   if(HelpersMethod.IsExistsById("CmCustForecastFlag",driver))
   {
    HelpersMethod.ActClick(driver,UseForecast,10);
   }
   if(UseForecast.isSelected())
   {
    scenario.log("FORE CAST FLAG IS SLECECTED");
    exists=true;}
  }
  catch (Exception e){}
 }
}
