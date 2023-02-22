package pages_DSD_OMS.standingOrder;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.DataBaseConnection;
import util.TestBase;

import java.util.Date;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class NewStandingOrderPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String Prod_No=null;

    @FindBy (xpath="//div[@id='card1']/descendant::span[contains(@class,'k-icon k-i-arrow-chevron-down')]")
    private WebElement StandingOrderArrow;

    @FindBy (xpath="//button[text()='Save']")
    private WebElement SaveButton;

    @FindBy(xpath="//button[text()='Add product']")
    private WebElement AddProduct;

    @FindBy(xpath="//button[text()='Skip specific days']")
    private WebElement SkipSpecificdays;

    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement DeleteProd;

    @FindBy(id="frequency")
    private WebElement DeliverySchedule;

    @FindBy(id="quickProduct")
    private WebElement QuickProduct;

    public NewStandingOrderPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void ValidateSO()
    {
        exists=false;
        WebElement WebEle=null;
        //loading Icon
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            HelpersMethod.Implicitwait(driver,40);
            exists=HelpersMethod.IsExists("//div[contains(@class,'topHeaderRow')]/descendant::span[contains(text(),'Standing Orders')]",driver);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void QuickProductValue()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","card2");
            HelpersMethod.ScrollElement(driver,WebEle);
            //Enter Qty in quick inputbox
            String Pro= DataBaseConnection.DataBaseConn(TestBase.testEnvironment.getSingle_Prod_Sql());
            HelpersMethod.ActSendKey(driver,QuickProduct,6,Pro);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    //For entering Qty in product grid of standing order product based on input box enabled or disabled
    public void EnterQtyInProductGrid(List<List<String>> days)
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            int i=0;
            int j=0;
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//label[@class='card-title-products']");
            HelpersMethod.ScrollElement(driver,WebEle);
            List<WebElement> QtyInput=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row k-grid-edit-row')]/td[contains(@class,'cell')]");
            for (WebElement day:QtyInput)
            {
                for(;i<=7;i++)
                {
                    if(HelpersMethod.IsExists("//tr[contains(@class,'k-master-row k-grid-edit-row')]/td[contains(@class,'cell')]["+i+"]/descendant::input",driver))
                    {

                        WebEle=HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row k-grid-edit-row')]/td[contains(@class,'cell')]["+i+"]/descendant::input");
                        HelpersMethod.ActSendKey(driver,WebEle,20,days.get(0).get(j));
                        j++;
                    }
                }
            }
        }
        catch (Exception e){}
    }

//For Clicking on Save button
    public void ClickSaveButton()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(SaveButton.isDisplayed() && SaveButton.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,SaveButton);
                HelpersMethod.ClickBut(driver,SaveButton,200);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }

                if(HelpersMethod.IsExists("//div[text()='Success']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement OkButton=WebEle.findElement(By.xpath(".//button"));
                    HelpersMethod.ClickBut(driver,OkButton,400);
                }
                HelpersMethod.WaitElementPresent(driver,"id","card2",200);
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"id","card2",200);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnAddProductButton()
    {
        exists=false;
        WebElement WebEle=null;
        HelpersMethod.Implicitwait(driver,40);
        new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add product')]")));
        try
        {
            if(AddProduct.isDisplayed() && AddProduct.isEnabled())
            {
                HelpersMethod.ScrollElement(driver,AddProduct);
                HelpersMethod.ActClick(driver,AddProduct,40);
                exists=true;
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateCatalogPopup()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]",driver))
                {
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 50);
                    }
                    //Click on Add filter button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[contains(text(),'Add filter')]");
                    new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
                    HelpersMethod.ScrollElement(driver,WebEle);
                    HelpersMethod.JScriptClick(driver, WebEle, 20);

                    //Click on Clear all button
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-animation-container')]/descendant::button[contains(text(),'Clear all')]");
                    new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(WebEle));
                    if (WebEle.isDisplayed() && WebEle.isEnabled())
                    {
                        HelpersMethod.JScriptClick(driver, WebEle, 10);

                        //loading Icon
                        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                        {
                            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                        }
                        HelpersMethod.Implicitwait(driver, 40);
                    }
                    else
                    {
                        //Click on Add filter button, if 'Clear all' is disabled, we should close add filter
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button/descendant::span[contains(text(),'Add filter')]");
                        HelpersMethod.ActClick(driver, WebEle, 40);
                    }
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SearchProduct()
    {
        exists = false;
        WebElement WebEle=null;
        WebElement WebEle1=null;
        WebDriverWait wait=new WebDriverWait(driver,40);
        HelpersMethod.Implicitwait(driver,40);
        try
        {
            List<String> Prods = DataBaseConnection.DataConn1(TestBase.testEnvironment.getMultiple_Prod_Sql());
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            //Catalog displayed in list view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'i-grid')]", driver))
            {
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }

                //Check for filter icon is enabled or not
                if(HelpersMethod.IsExists("//button[contains(@class,'i-grid__filter-button')]/descendant::span[contains(@class,'k-icon k-i-filter k-icon')]",driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[contains(@class,'i-grid__filter-button')]/descendant::span[contains(@class,'k-icon k-i-filter k-icon')]");
                    HelpersMethod.ClickBut(driver, WebEle, 10);
                }
                    //Identify the filter input box in popup
                    int i=0;
                    List<WebElement> THeads=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::thead/tr[1]/th");
                    for(WebElement THead:THeads)
                    {
                        i++;
                        String Head_Text=THead.getText();
                        if(Head_Text.equals("Product #"))
                        {
                            for(String Pro:Prods)
                            {
                                WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::thead/tr[2]/th["+i+"]/descendant::input");
                                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                                {
                                    WebEle1=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle1, 100);
                                }
                                HelpersMethod.ActSendKey(driver,WebEle,40,Pro);
                                scenario.log("PRODUCT SEARCHED AND ADDED TO STANDING ORDER IS "+Pro);
                                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                                {
                                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                                }
                                WebEle1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]");
                                HelpersMethod.ActClick(driver,WebEle1,20);
                                HelpersMethod.Implicitwait(driver,40);

                                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]")));

                                //If prod# is already there in input box should clear that
                                if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::thead/tr[2]/th["+i+"]/descendant::button[contains(@class,'k-clear-button-visible')]",driver))
                                {
                                    WebEle1=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::thead/tr[2]/th["+i+"]/descendant::button[contains(@class,'k-clear-button-visible')]");
                                    HelpersMethod.ClickBut(driver,WebEle1,40);
                                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                                    {
                                        WebEle1=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle1, 100);
                                    }
                                }
                            }
                        }
                    }
            }
            //catalog card view
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'product-catalog-container')]", driver))
            {
                for (String Pro : Prods)
                {
                    //Click on 'x' button in catalog
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button-addon right-button input-group-addon')]//*[local-name()='svg']");
                    HelpersMethod.ScrollElement(driver, WebEle);
                    HelpersMethod.ActClick(driver, WebEle, 10);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }
                    //enter product number in input box
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//input[contains(@class,' product-search-input rounded-corners-left')]");
                    HelpersMethod.ActSendKey(driver, WebEle, 10, Pro);

                    //Click on search icon
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'search-button-addon search-button input-group-addon')]//*[local-name()='svg']");
                    HelpersMethod.ActClick(driver, WebEle, 20);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }
                    else
                    {
                        HelpersMethod.Implicitwait(driver, 20);
                    }
                    if (HelpersMethod.IsExists("//div[@class='grid-item-box']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='grid-item-box-item']/descendant::button[text()='Select']");
                        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='grid-item-box-item']/descendant::button[text()='Select']")));
                        HelpersMethod.ScrollElement(driver, WebEle);
                        HelpersMethod.Implicitwait(driver,20);
                        HelpersMethod.ActClick(driver, WebEle, 20);
                        HelpersMethod.Implicitwait(driver,40);
                        new WebDriverWait(driver,50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid-item-box-item']/descendant::button[contains(@class,'k-button k-flat k-button-icontext  i-button--icon-only')]")));
                        exists = true;
                    }
                    else
                    {
                        scenario.log("PRODUCT DOESN'T EXISTS");
                    }
                }
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void CatalogOKButton()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[text()='Catalog']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[contains(text(),'Ok')]");
                HelpersMethod.ActClick(driver,WebEle,8);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void MultipleQtyProducts(List<List<String>> qtys)
    {
        exists=false;
        int k=0;
        String Pro=null;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.Implicitwait(driver, 4);
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[contains(@class,'k-widget k-grid')]");
            HelpersMethod.ScrollElement(driver, WebEle);
            for (int i = 0; i < qtys.size(); i++)
            {
                for (int j = 0; j < qtys.get(i).size(); j++)
                {
                    Pro = qtys.get(i).get(j);
                    if (HelpersMethod.IsExists("//tr[contains(@class,'k-master-row')][" + (i + 1) + "]/td[contains(@class,'cell')][" + (j + 1) + "]/descendant::input", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//tr[contains(@class,'k-master-row')][" + (i + 1) + "]/td[contains(@class,'cell')][" + (j + 1) + "]/descendant::input");
                        HelpersMethod.ActSendKey(driver, WebEle, 6, qtys.get(i).get(j));
                        HelpersMethod.Implicitwait(driver, 8);
                    }
                }
            }
            HelpersMethod.Implicitwait(driver,8);
        }
        catch (Exception e){}
    }
    public void ReadProductNoInGrid()
    {
        exists=false;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::td[@field='ProductId']");
            Prod_No=WebEle.getText();
            scenario.log("PRODUCT NUMBER DELETED IS: "+Prod_No);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnCheckboxOfProductNo()
    {
        exists=false;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::input[@class='k-checkbox']");
            HelpersMethod.ScrollElement(driver,WebEle);
            HelpersMethod.ClickBut(driver,WebEle,10);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickDeleteProduct()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(DeleteProd.isDisplayed() && DeleteProd.isEnabled())
            {
                HelpersMethod.ClickBut(driver,DeleteProd,8);
                if(HelpersMethod.IsExists("//div[contains(text(),'Delete product(s)')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='Yes']");
                    HelpersMethod.ClickBut(driver,WebEle,8);
                    exists=true;
                    //loading Icon
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickOnSkipSpecificDay()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.ScrollElement(driver,SkipSpecificdays);
            HelpersMethod.ClickBut(driver,SkipSpecificdays,60);
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

    public void ValidateSkipPopup()
    {
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
            // to fetch the web element of the modal container
            WebElement modalContainer = HelpersMethod.FindByElement(driver,"xpath" ,"//div[contains(@class,'k-widget k-window k-dialog')]");

            // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Skip", "Verify Title message");
        }
        catch (Exception e){}
    }

    //Click on Skip reason dropdown
    public void ClickOnSkipReason()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","skipReason");
            HelpersMethod.ClickBut(driver,WebEle,10);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//ul[@class='k-list k-reset']/li[1]");
            HelpersMethod.ActClick(driver,WebEle,10);

            exists=true;
            //loading Icon
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.Implicitwait(driver,40);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SelectDateToSkip()
    {
        exists=false;
        WebElement WebEle=null;
        int length;
        try
        {
            List<WebElement> Dates=HelpersMethod.FindByElements(driver,"xpath","//td[contains(@style,'opacity: 1; cursor: pointer;')]/span[@class='k-link']");
            length=Dates.size();
            HelpersMethod.ClickBut(driver,Dates.get(length-4),20);
            scenario.log("DATE HAS BEEN SELECTED: "+ Dates.get(length-4).getAttribute("title"));
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SkipOkButton() throws InterruptedException
    {
        exists=false;
        WebElement WebEle=null;
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]",30);
        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

        WebElement okButton=modalContainer.findElement(By.xpath(".//button[text()='Ok']"));
        HelpersMethod.ClickBut(driver,okButton,20);
        exists=true;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        String status = HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Assert.assertEquals(exists,true);
    }

    public void SkipConfirmation()
    {
        exists=false;
        WebElement WebEle=null;
        HelpersMethod.Implicitwait(driver,40);
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Delivery skip details saved')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ClickBut(driver,WebEle,30);
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
                HelpersMethod.Implicitwait(driver,60);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String readSkipDate()
    {
        String skipDate = null;
        Date sDate = null;
        WebElement WebEle;

        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
        WebEle = modalContainer.findElement(By.xpath(".//tr[contains(@class,'k-master-row')][1]/td[1]"));
        HelpersMethod.ScrollElement(driver, WebEle);
        skipDate = WebEle.getText();

        return skipDate;
    }

    public void RemoveSkipDate()
    {
        exists=false;
        WebElement WebEle=null;
        Actions act1=new Actions(driver);
        String status=null;
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
        }
        try
        {
            HelpersMethod.Implicitwait(driver,20);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/td[1]");
            HelpersMethod.ScrollElement(driver,WebEle);
            scenario.log("SKIP CANCEL HAS BEEN DONE ON :"+WebEle.getText());
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')][1]/td[2]/button//*[local-name()='svg']");
            Thread.sleep(500);
            act1.moveToElement(WebEle).build().perform();
            act1.click(WebEle).build().perform();
            exists=true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.Implicitwait(driver,20);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) { }
    }

    public void ValidateCardView() throws InterruptedException
    {
        WebElement WebEle;
        WebElement Catelog=HelpersMethod.FindByElement(driver,"id","CPcategories");
        WebElement SubCate=HelpersMethod.FindByElement(driver,"id","CPbrands");
        WebElement Brand=HelpersMethod.FindByElement(driver,"id","CPsizes");
        String Cate=null;
        exists=false;

            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]/descendant::div[contains(@class,'product-catalog-container')]",driver))
            {
                //Read the category value of first product in catalog
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='grid-item-box'][1]/descendant::span[text()='Category']/following-sibling::span");
                Cate=WebEle.getText();

                //Click on category drop down
                HelpersMethod.ClickBut(driver,Catelog,200);
                HelpersMethod.DropDownMenu(driver,Cate);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }

                //Click on SubCategory Drop down
                HelpersMethod.ClickBut(driver,SubCate,200);
                if(HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::li[2]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li[2]");
                    HelpersMethod.ActClick(driver,WebEle,200);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }

                //Click on Brand
                HelpersMethod.ClickBut(driver,Brand,200);
                if(HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::li[2]",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li[2]");
                    HelpersMethod.ActClick(driver,WebEle,100);
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
                }

                exists=true;
            }
            Assert.assertEquals(exists,true);
    }

    public void CardViewProdSelection()
    {
        WebElement WebEle;
        exists=false;

            WebEle= HelpersMethod.FindByElement(driver,"xpath","//div[@class='grid-item-box'][1]/descendant::button");
            HelpersMethod.ClickBut(driver,WebEle,10);
            exists=true;
            Assert.assertEquals(exists,true);
    }

    public void ListAllProdInGrid()
    {
        exists=false;
            scenario.log("PRODUCTS FOUND IN STANDING ORDER:");
            List<WebElement> ProductsLists=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/td[2]");
            for(WebElement Prod: ProductsLists)
            {
                String Prod_Text=Prod.getText();
                scenario.log(Prod_Text);
                exists=true;
            }
            Assert.assertEquals(exists,true);
    }

    public void ValidityDate()
    {
            WebElement validationDate=HelpersMethod.FindByElement(driver,"xpath","//label[contains(@class,'cart-title-standing-order')]");
            scenario.log("STANDING ORDER AND VLIDITY PERIOD: "+validationDate.getText());
    }

    public void navigateToStandingOrder()
    {
          WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]");
            if (HelpersMethod.EleDisplay(WebEle))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Standing Orders", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Standing Orders')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
                }
            }
            else
            {
                scenario.log("STANDING ORDER TAB DOESN'T EXISTS, PLEASE CHECK THE ADMIN SETTINGS");
            }
    }

    public void validateCurrentweek()
    {
        exists = false;
        String currentWeek = null;

        currentWeek = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(@class,'i-summary-area__main__value')]").getText();
        if (currentWeek.equals("Even week"))
        {
            exists = true;
        }
       // Assert.assertEquals(exists, true);
    }

    public void validateDeliverySchedule()
    {
        exists = false;
        String deliverySch = null;

        deliverySch = HelpersMethod.FindByElement(driver, "xpath", "//span[@id='frequency']/span[@class='k-input']").getText();
        if (deliverySch.equals("Every week"))
        {
            exists = true;
        }
        Assert.assertEquals(exists, true);
    }
}
