package pages_DSD_OMS.quote;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.DataBaseConnection;
import util.TestBase;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @Project DSD_ERP
 * @Author Divya.Ramadas@afsi.com
 */
public class NewQuotePage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists = false;
    static String Product = null;

    @FindBy(id = "cancelQuoteButton")
    private WebElement CancelButton;

    @FindBy(id = "createQuoteButton")
    private WebElement CreateButton;

    @FindBy(id = "backButton")
    private WebElement BackButton;

    @FindBy(xpath = "//button[text()='Comments']")
    private WebElement CommentButton;

    @FindBy(xpath = "//button[contains(text(),'Add product')]")
    private WebElement AddProdcutButton;

    @FindBy(id = "deleteProductButton")
    private WebElement DeleteButton;

    @FindBy(id = "SearchBoxProductRefList")
    private WebElement SearchBar;

    @FindBy(id = "quickProduct")
    private WebElement QuickProd;

    public NewQuotePage(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }

    //Actions methods
    public void QtyInGrid(String unit,String cases)
    {
            WebElement WebEle=null;
            try
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'TotalUnitsCol')]");
                HelpersMethod.ScrollElement(driver,WebEle);
                if(WebEle.isDisplayed() && WebEle.isEnabled())
                {
                    HelpersMethod.ActSendKey(driver,WebEle,8,unit);
                    scenario.log("UNIT ENTERED IS: "+unit);

                    for (int i = 0; i <= 5; i++) {
                        //Check for Qty exceeds maximum of popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ClickBut(driver, WebEle, 20);
                        }
                        //Check for 'Product Unavailable' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[@id='toast-container']", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 10);
                        }
                        HelpersMethod.Implicitwait(driver, 2);
                        //Check for 'Product low in invetory' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low')]/ancestor::div[@id='toast-container']", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 6);
                        }
                        //Check for 'There are no matching product' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'There are no matching products: ')]/ancestor::div[contains(@class,'toast toast-error')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 6);
                        }
                        //Check for popup if it is accespting only units popup
                        if (HelpersMethod.IsExists("//div[contains(text(),' can only be ordered in ')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button[text()='×']");
                            HelpersMethod.ActClick(driver, WebEle, 6);
                        }
                    }

                }
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//input[contains(@id,'TotalCasesCol')]");
                if(WebEle.isDisplayed() && WebEle.isEnabled())
                {
                    HelpersMethod.ActSendKey(driver,WebEle,8,cases);
                    scenario.log("CASE ENTERED IS: "+ cases);
                    for (int i = 0; i <= 5; i++) {
                        //Check for Qty exceeds maximum of popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'Quantity exceeds maximum of')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                            HelpersMethod.ClickBut(driver, WebEle, 20);
                        }
                        //Check for 'Product Unavailable' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently unavailable.')]/ancestor::div[@id='toast-container']", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 10);
                        }
                        HelpersMethod.Implicitwait(driver, 2);
                        //Check for 'Product low in invetory' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'This product is currently low')]/ancestor::div[@id='toast-container']", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 6);
                        }
                        //Check for 'There are no matching product' popup
                        if (HelpersMethod.IsExists("//div[contains(text(),'There are no matching products: ')]/ancestor::div[contains(@class,'toast toast-error')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button");
                            HelpersMethod.ClickBut(driver, WebEle, 6);
                        }
                        //Check for popup if it is accespting only units popup
                        if (HelpersMethod.IsExists("//div[contains(text(),' can only be ordered in ')]", driver)) {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='toast-container']/descendant::button[text()='×']");
                            HelpersMethod.ActClick(driver, WebEle, 6);
                        }
                    }
                }
            }
            catch (Exception e){}
    }

    public void EnterQuickProductNo()
    {
        HelpersMethod.Implicitwait(driver,4);
        exists=false;
        try
        {
            if (QuickProd.isDisplayed())
            {
                Product = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
                HelpersMethod.ActSendKey(driver,QuickProd,4,Product);
                if(HelpersMethod.IsExists("//div[contains(text(),'Product not found')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement OK_Button=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,OK_Button,4);
                    scenario.log("PRODUCT HAS NOT BEEN FOUND");
                }
                else
                {
                    scenario.log("PRODUCT ENTERED IN QUICK PRODUCT INPUT BOX IS: "+Product);
                }
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }


    public void EnterQuickProductNoSecond()
    {
        HelpersMethod.Implicitwait(driver,4);
        exists=false;
        try
        {
            if (QuickProd.isDisplayed())
            {
                Product = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
                HelpersMethod.ActSendKey(driver,QuickProd,4,Product);
                if(HelpersMethod.IsExists("//div[contains(text(),'Product not found')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement OK_Button=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                    HelpersMethod.ClickBut(driver,OK_Button,4);
                    scenario.log("SECOND PRODUCT HAS NOT BEEN FOUND: "+Product);
                }
                else
                {
                    scenario.log("SECOND PRODUCT ENTERED IN QUICK ENTRY IS: "+Product);
                }
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void ClickOnCreateButton()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ClickBut(driver,CreateButton,10);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnCancelButton()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            if(CancelButton.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, CancelButton, 10);
                exists = true;
            }
            Assert.assertEquals(exists,true);
            exists=false;
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Cancel quote')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
            if(WebEle.isDisplayed())
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                HelpersMethod.ClickBut(driver,WebEle,4);
                exists=true;
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
            }
            scenario.log("QUOTE HAS BEEN CANCELED");
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnAddProduct()
    {
        exists=false;
        try
        {
            if(AddProdcutButton.isDisplayed())
            {
                HelpersMethod.ClickBut(driver, AddProdcutButton, 2);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectCatalog()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",driver))
            {
                HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-animation-container')]/descendant::ul/li","xpath","From Catalog");
                exists=true;
                scenario.log("CATALOG OPTION HAS BEEN SELECTED FROM DROPDOWN THAT APPEARS AFTER CLICKING ADD PRODUCT BUTTON");
            }
        }
        catch (Exception e){}
        Assert.assertEquals(exists,true);
    }

    public void SelectProductFromCatalog()
    {
        exists = false;
        WebElement WebEle = null;
        try {
            if (HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver)) {
                String Prod = DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_OneMoreProd());
                //check for existence of list view of catalog
                if (HelpersMethod.IsExists("//div[@class='i-grid']", driver))
                {
                    //check whether filter is enabled or not
                    if (HelpersMethod.IsExists("//span[contains(@class,'k-icon k-i-filter k-icon')]", driver)) {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'k-icon k-i-filter k-icon')]");
                        HelpersMethod.ActClick(driver, WebEle, 4);
                    }
                    //if filter is already enabled search for Product# header
                    int i = 0;
                    int j = 0;
                    List<WebElement> Heads = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::th[contains(@class,'k-header ')]");
                    for (WebElement Head : Heads)
                    {
                        i++;
                        String Head_text = Head.getText();
                        if (Head_text.equals("Product #"))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[@class='k-filter-row']/th[" + i + "]/descendant::input");
                            HelpersMethod.ActSendKey(driver, WebEle, 4, Prod);
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
                            scenario.log("PRODUCT SEARCHED IN LIST VIEW IS: "+Prod);
                            break;
                        }
                    }
                }
                else
                {
                    //Card view of catalog
                    if (HelpersMethod.IsExists("//div[@class='card-view']", driver))
                    {
                        //Enter product number into search bar
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'cp-search-bar-container')]/descendant::input");
                        HelpersMethod.ActSendKey(driver, WebEle, 4, Prod);
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]//*[local-name()='svg']//*[local-name()='path' and contains(@d,'M15')]");
                        HelpersMethod.ActClick(driver, WebEle, 8);
                        HelpersMethod.Implicitwait(driver, 4);
                        scenario.log("PRODUCT SEARCHED IN CARD VIEW IS: "+Prod);
                    }
                }
            }
        }
        catch(Exception e){}
    }


public void EnterProductQtyCatalog(String unit,String cases)
{
    WebElement WebEle=null;
    int j=0;
    try
    {
        if (HelpersMethod.IsExists("//div[@class='i-grid']", driver))
        {
            //Check for unit and case input boxes
            if (!HelpersMethod.IsExists("//div[@class='i-no-data__icon']", driver)) {
                List<WebElement> Heads1 = HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-widget k-window k-dialog')]/descendant::th[contains(@class,'k-header ')]");
                for (WebElement Head1 : Heads1)
                {
                    j++;
                    String Head_text1 = Head1.getText();
                    if (Head_text1.equals("Units"))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td[" + j + "]/descendant::input");
                        if (WebEle.isDisplayed())
                        {
                            HelpersMethod.EnterText(driver, WebEle, 4, unit);
                            WebEle.sendKeys(Keys.TAB);
                            exists = true;
                            scenario.log("UNITS ENTERED IS: "+unit);
                        }
                    }
                    else
                    {
                        if (Head_text1.equals("Cases"))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::td[" + j + "]/descendant::input");
                            if (WebEle.isDisplayed()) {
                                HelpersMethod.EnterText(driver, WebEle, 4, cases);
                                WebEle.sendKeys(Keys.TAB);
                                exists = true;
                                scenario.log("CASES ENTERED IS: "+cases);
                            }
                        }
                    }
                }
            }
        }

        if (HelpersMethod.IsExists("//div[@class='card-view']", driver))
        {
            if (!HelpersMethod.IsExists("//div[contains(text(),'Sorry, no products matched ')]", driver)) {
                //Enter value for unit input
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Unit')]/descendant::input");
                HelpersMethod.ScrollElement(driver, WebEle);
                if (WebEle.isDisplayed())
                {
                    HelpersMethod.EnterText(driver, WebEle, 4, unit);
                    WebEle.sendKeys(Keys.TAB);
                    exists = true;
                    scenario.log("UNITS ENTERED IS: "+unit);
                }

                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(text(),'Case')]/descendant::input");
                if (WebEle.isDisplayed()) {
                    HelpersMethod.EnterText(driver, WebEle, 4, unit);
                    WebEle.sendKeys(Keys.TAB);
                    exists = true;
                    scenario.log("CASES ENTERED IS: "+cases);
                }
            }
        }
            Assert.assertEquals(exists, true);
    }
    catch (Exception e) {}
    WebElement  OK_Button = HelpersMethod.FindByElement(driver, "xpath", "//button[text()='Ok']");
    HelpersMethod.ClickBut(driver, OK_Button, 2);
    }

    public void SelectOG()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",driver))
            {
                HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-animation-container')]/descendant::ul/li","xpath","From Order guides");
                exists=true;
                scenario.log("OG OPTION HAS BEEN SELECTED FROM ADD PRODUCTS DROP DOWN");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    public void SelectOGFromPopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Order guides')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                HelpersMethod.ActClick(driver,WebEle,6);
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                HelpersMethod.ActClick(driver,WebEle,2);
                exists=true;
                scenario.log("FIRST OG HAS BEEN SELECTED FROM POPUP");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void PrintQuote()
    {
        exists=false;
        HelpersMethod.Implicitwait(driver,10);
        try
        {
            WebElement PrintBut=HelpersMethod.FindByElement(driver,"id","PrintButton");
            if(PrintBut.isDisplayed() && PrintBut.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,PrintBut);
                String ParentWindow = driver.getWindowHandle();
                HelpersMethod.ClickBut(driver, PrintBut, 10);
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
                Set<String> PCWindows = driver.getWindowHandles();
                for (String PCwind : PCWindows)
                {
                    if (!PCwind.equals(ParentWindow))
                    {
                        HelpersMethod.Implicitwait(driver,10);
                        driver.switchTo().window(PCwind);
                        scenario.log(".pdf HAS BEEN FOUND");
                        driver.close();
                        HelpersMethod.Implicitwait(driver, 1);
                        exists = true;
                        scenario.log("PRINT BUTTON HAS BEEN HANDLED");
                    }
                }

                driver.switchTo().window(ParentWindow);
                Assert.assertEquals(exists, true);
            }
            else
            {
                scenario.log("PRINT BUTTON IS NOT DISPLAYED/VISIBLE");
            }
        }
        catch (Exception e){}
    }

    public void QuickProdEntryMutlipleProduct(String Prod)
    {
        exists=false;
        try
        {
          if(QuickProd.isDisplayed())
          {
              HelpersMethod.Implicitwait(driver,2);
             HelpersMethod.ClearText(driver,QuickProd,4);
              HelpersMethod.ActSendKey(driver, QuickProd, 4, Prod);
              scenario.log("PRODUCT ENTERED IN QUICK PRODUCT ENTRY IS: "+Prod);
              if(HelpersMethod.IsExists("//div[contains(text(),'Product not found')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
              {
                  WebElement OK_Button=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Ok']");
                  HelpersMethod.ClickBut(driver,OK_Button,4);
                  scenario.log("PRODUCT HAS NOT BEEN FOUND");
              }
              WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
              HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 5);
              exists=true;
          }
          Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void QtyInGridMultipleProduct(String unit,String cases,int count)
    {
        WebElement WebEle=null;
        WebEle=HelpersMethod.FindByElement(driver,"id","quoteEntryGridContainer");
        try
        {
            HelpersMethod.ScrollElement(driver,WebEle);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr["+(count+1)+"]/descendant::input[contains(@id,'TotalUnitsCol')]");
            if(WebEle.isDisplayed())
            {
                HelpersMethod.EnterText(driver,WebEle,8,unit);
                scenario.log("UNIT ENTERED IS: "+unit);
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr["+(count+1)+"]/descendant::input[contains(@id,'TotalCasesCol')]");
            if(WebEle.isDisplayed())
            {
                HelpersMethod.EnterText(driver,WebEle,8,cases);
                scenario.log("CASES ENTERED IS: "+cases);
            }
        }
        catch (Exception e){}
    }

    public void AddMultipleProducts(List<List<String>> qtyList)
    {
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"id","quickProduct");
            List<String> Prod=DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
            for(int i=0;i<=qtyList.size()-1;i++)
            {
                //Enter product number in input box
                String pro = String.valueOf(Prod.get(i));
                QuickProdEntryMutlipleProduct(pro);
                //Enter Qty in product grid
                QtyInGridMultipleProduct(qtyList.get(i).get(0),qtyList.get(i).get(1),i);
                HelpersMethod.Implicitwait(driver,1);
            }
        }
        catch (Exception e){}
    }

    public void SelectProductInProductGrid()
    {
        exists=false;
        WebElement WebEle=null;
        HelpersMethod.Implicitwait(driver,2);
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","quoteEntryGridContainer");
            if(WebEle.isDisplayed())
            {
                HelpersMethod.ScrollElement(driver, WebEle);
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][1]/descendant::input[@class='k-checkbox']");
                HelpersMethod.ClickBut(driver, WebEle, 6);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnDeleteButton()
    {
        exists=false;
        try
        {
            if(DeleteButton.isDisplayed())
            {
                HelpersMethod.ClickBut(driver,DeleteButton,4);
                exists=true;
                scenario.log("1ST PRODUCT IN PRODUCT GRID HAS BEEN DELETED FROM QUOTE");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
     }

     public void ClickComment()
     {
         exists=false;
         try
         {
             if(CommentButton.isDisplayed())
             {
                 HelpersMethod.ScrollElement(driver,CommentButton);
                 HelpersMethod.ClickBut(driver,CommentButton,4);
                 HelpersMethod.Implicitwait(driver,10);
              exists=true;
             }
             Assert.assertEquals(exists,true);
         }
         catch (Exception e){}
     }

     public void ClickOnPrintFlag()
     {
         exists = false;
         WebElement WebEle = null;
         String CommentPop = null;
         HelpersMethod.Implicitwait(driver, 15);
         try {
             WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[text()='Comments']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]");
             if (WebEle.isDisplayed())
             {
                 //Click on comment flag
                 WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='printFlagDropDown']/descendant::span[contains(@class,'k-icon k-i-arrow-s')]");
                 HelpersMethod.ClickBut(driver, WebEle, 8);
             }
         } catch (Exception e) {}
     }

     public void SelectPrintflag()
     {
         try
         {
             HelpersMethod.Implicitwait(driver,10);
             //Select value from dropdown
             HelpersMethod.WebElementFromDropDown(driver, "//div[contains(@class,'k-slide-down-enter k-slide-down-enter-active')]/descendant::li", "xpath", "Internal");
             HelpersMethod.Implicitwait(driver, 10);
         } catch (Exception e) {}
     }

     public void QuoteCommentPopup(String comment)
     {
         WebElement WebEle=null;
         String CommentPop=null;
         try
               {
                   HelpersMethod.Implicitwait(driver,10);
                 //Enter Comment in comment box
                 WebEle=HelpersMethod.FindByElement(driver,"id","textAreaA");
                 HelpersMethod.EnterText(driver,WebEle,4,comment);
                 //Click on Add button in comment popup
                 WebEle=HelpersMethod.FindByElement(driver,"xpath","//button[text()='Add']");
                 HelpersMethod.ClickBut(driver,WebEle,4);
                 WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                 HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 20);
                 HelpersMethod.Implicitwait(driver,10);

                 WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-grid']");
                   HelpersMethod.ScrollElement(driver,WebEle);
                 WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[@class='k-master-row']/descendant::td[2]");
                 CommentPop=WebEle.getText();
                   scenario.log("COMMENT ENTERED IS: "+comment);

                 //Click on Ok button in comment popup
                 WebEle= HelpersMethod.FindByElement(driver,"xpath","//button[text()='Ok']");
                 HelpersMethod.ActClick(driver,WebEle,15);


             Assert.assertEquals(CommentPop,comment);
         }
         catch (Exception e){}
     }

     public void QuoteCommentOk()
     {
         exists=false;
         try
         {
             //Click on Ok button in comment popup
             WebElement   WebEle= HelpersMethod.FindByElement(driver,"xpath","//button[text()='Ok']");
             if(WebEle.isDisplayed())
             {
                 HelpersMethod.ClickBut(driver, WebEle, 15);
                 exists=true;
             }
             Assert.assertEquals(exists,true);
         }
         catch (Exception e){}
     }
}
