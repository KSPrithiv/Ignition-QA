package pages_DSD_OMS.parOrder;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

/**
 * @Project OMS_DSD
 * @Author Divya.Ramadas@afsi.com
 */
public class ParOrderPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String status=null;
    static String ProdNo=null;

    @FindBy(id = "plusAdditionalAccountButtonFlat")
    private WebElement NewPar;

    @FindBy(id="deleteAdditionalAccountButton")
    private WebElement DelPar;

    @FindBy(xpath ="//label[contains(text(),'Par list')]/following-sibling::span/span[@id='dropDownNoneType']")
    private WebElement ParlistDropdown;

    /*@FindBy(xpath="//label[contains(text(),'Code')]/following-sibling::input")
    private WebElement ParCode;*/

    @FindBy(xpath="//div[@class='parList-container']/descendant::label[contains(text(),'Description')]/following-sibling::input")
    private WebElement ParDes;

    @FindBy(xpath = "//div[@class='parList-container']/descendant::input[@id='SearchBox1']")
    private WebElement ParSearchBox;

    @FindBy(xpath="//button[contains(text(),'Save par')]")
    private WebElement ParSave;

    @FindBy(id="OGSaveButton")
    private WebElement OGSave;

    @FindBy(id="OGCancelButton")
    private WebElement OGCancel;

    public ParOrderPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions methods
    public void ClickParTab()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.Implicitwait(driver,40);
            WebElement ParList=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Par list')]");
            HelpersMethod.ScrollElement(driver,ParList);
            HelpersMethod.ActClick(driver,ParList,10);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            else
            {
                HelpersMethod.Implicitwait(driver, 20);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickProductTab()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            HelpersMethod.Implicitwait(driver,40);
            WebElement ParList=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Products')]");
            HelpersMethod.ScrollElement(driver,ParList);
            HelpersMethod.ActClick(driver,ParList,20);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            else
            {
                HelpersMethod.Implicitwait(driver, 20);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public boolean ValidateParlistTab()
    {
        exists=false;
        try
        {
            HelpersMethod.Implicitwait(driver,40);
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[@class='parList-container']",10);
           exists = HelpersMethod.IsExists("//div[@class='parList-container']",driver);
        }
        catch (Exception e){}
        return exists;
    }

    public void ClickNewPar()
    {
        WebElement WebEle=null;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.Implicitwait(driver, 40);
            HelpersMethod.ClickBut(driver,NewPar,20);
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

    public void DeletePar()
    {
        WebElement WebEle=null;
        exists=false;
        try
        {
            HelpersMethod.Implicitwait(driver,40);
            HelpersMethod.ClickBut(driver,DelPar,20);
            if(HelpersMethod.IsExists("//div[contains(text(),'Delete')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
               WebElement Ok_But=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
               HelpersMethod.ActClick(driver,Ok_But,1);
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

 /*   public void EnterCode(String Code)
    {
        exists=false;
        try
        {
            HelpersMethod.ActClearKey(driver,ParCode,10);
            HelpersMethod.ActSendKey(driver,ParCode,2,Code);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }*/

    public void EnterDesc(String Desc)
    {
        exists=false;
        try
        {
            HelpersMethod.ActClearKey(driver,ParDes,20);
            HelpersMethod.ActSendKey(driver,ParDes,10,Desc);
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void SavePar()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            status=null;
            HelpersMethod.JScriptClick(driver,ParSave,10);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.Implicitwait(driver,10);
           if(HelpersMethod.IsExists("//div[text()='Par list']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement Ok_But=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ActClick(driver,Ok_But,10);
            }
           exists=true;
           status=null;
            status=HelpersMethod.returnDocumentStatus(driver);
            if(status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            else
            {
                HelpersMethod.Implicitwait(driver,20);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String ReadProductValueFromOG()
    {
        try
        {
            WebElement WebEle=null;
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')][1]/descendant::button");
            ProdNo=WebEle.getText();
        }
        catch (Exception e){}
        return ProdNo;
    }

    public int ReadAllProductValueFromPar()
    {
        exists=false;
        List<WebElement> ParProd=null;
        try
        {
            ParProd=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::button");
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return ParProd.size();
    }

    public void ClickParDropDown()
    {
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            HelpersMethod.ActClick(driver,ParlistDropdown,10);
        }
        catch (Exception e){}
    }

    public void SelectParlistFromDropdown(String parList)
    {
        WebElement WebEle=null;
        String ParDes=null;
        try
        {
            HelpersMethod.WebElementFromDropDown(driver,"//div[contains(@class,'k-animation-container')]/descendant::ul/li","xpath",parList);
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100);
            }
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'parList-container')]/descendant::label[text()='Code']/following-sibling::input");
            ParDes=HelpersMethod.JSGetValueEle(driver,WebEle,10);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'parList-container')]/descendant::label[text()='Description']/following-sibling::input");
            ParDes=ParDes+"-"+HelpersMethod.JSGetValueEle(driver,WebEle,10);
            Assert.assertEquals(parList,ParDes);
            scenario.log(ParDes+" PAR LIST HAS BEEN FOUND");
        }
        catch (Exception e){}
    }

    public void EnterProductNoInSearchBox()
    {
        WebElement WebEle=null;
        exists=false;
        try
        {
            scenario.log("PRODUCT TO BE SEARCHED IS "+ProdNo);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-search-box']/descendant::input");
            HelpersMethod.EnterText(driver,WebEle,2,ProdNo);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'search-box__search')]");
            HelpersMethod.ClickBut(driver,WebEle,2);
            exists=true;
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'i-no-data__icon')]");
            if(!WebEle.isDisplayed())
            {
                scenario.log("PRODUCT HAS NOT BEEN FOUND IN PARLIST");
            }
            else
            {
                scenario.log("PRODUCT HAS BEEN FOUND IN PARLIST");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ReadProducts()
    {
        exists=false;
        try
        {
            String ProdNo=null;
            List<WebElement> Prods=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row ')]/descendant::button");
            for(WebElement Prod:Prods)
            {
                ProdNo=Prod.getText();
                scenario.log("PRODUCT FOUND IN PARLIST "+ProdNo);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public boolean ConfirmDeletePar()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,ParlistDropdown,10);
        }
        catch (Exception e){}
        return exists;
    }
}
