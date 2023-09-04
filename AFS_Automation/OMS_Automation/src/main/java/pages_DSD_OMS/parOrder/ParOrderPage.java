package pages_DSD_OMS.parOrder;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
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

    @FindBy(xpath = "//button[contains(@class,'i-filter-tag')]")
    private WebElement addFilter;

    public ParOrderPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    //Actions methods
    public void Refresh_Page(String currentURL)
    {
        Actions act1=new Actions(driver);
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]", driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
                if (wait.until(ExpectedConditions.alertIsPresent()) == null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
            }
            else
            {
                //navigating back to Current URL
                driver.navigate().to(currentURL);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
            }
        }
        catch (Exception e){}
    }

    public void ClickParTab()
    {
        exists=false;
        WebElement WebEle=null;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Par list')]",driver))
            {
                WebElement ParList = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Par list')]");
                HelpersMethod.ScrollElement(driver, ParList);
                //HelpersMethod.ActClick(driver,ParList,40);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Par list", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Par list')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
                }
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
            WebElement ParList=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Products')]");
            HelpersMethod.ScrollElement(driver,ParList);
            HelpersMethod.ActClick(driver,ParList,60);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
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
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[@class='parList-container']",60);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
            }
            HelpersMethod.ClickBut(driver,NewPar,10000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
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
            if(DelPar.isEnabled())
            {

                HelpersMethod.ClickBut(driver, DelPar, 1000);
                if (HelpersMethod.IsExists("//div[contains(text(),'Delete')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement deletePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement Ok_But = deletePopup.findElement(By.xpath(".//button[text()='OK']"));
                    HelpersMethod.ActClick(driver, Ok_But, 1000);
                    exists = true;
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                    }
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterDesc(String Desc)
    {
        exists=false;
        try
        {
            HelpersMethod.ActSendKey(driver,ParDes,2000,Desc);
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
            if(ParSave.isEnabled())
            {
                HelpersMethod.ClickBut(driver, ParSave, 20000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                }
                if(HelpersMethod.IsExists("//div[text()='Par list']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
                {
                    WebElement savePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                    WebElement Ok_But=savePopup.findElement(By.xpath(".//descendant::button[text()='OK']"));
                    HelpersMethod.ActClick(driver,Ok_But,100000);
                    exists=true;
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
                }
                String parName=HelpersMethod.FindByElement(driver,"xpath","//label[text()='Par list']/following-sibling::span/descendant::span[@class='k-input']").getText();
                scenario.log("PAR LIST NAME SAVED IS "+parName);
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
            }
            HelpersMethod.ActClick(driver,ParlistDropdown,1000);
        }
        catch (Exception e){}
    }

    public void SelectParlistFromDropdown(String parList)
    {
        exists=false;
        WebElement WebEle=null;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> parListItems=driver.findElements(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li"));
            for (WebElement pList:parListItems)
            {
                exists=false;
                act.moveToElement(pList).build().perform();
                String pList_text=pList.getText();
                if(pList_text.equals(parList))
                {
                    act.moveToElement(pList).click().build().perform();
                    scenario.log(" PAR LIST FOUND IS "+pList_text);
                    exists=true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 40000);
            }
           Assert.assertEquals(exists,true);
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
            HelpersMethod.EnterText(driver,WebEle,20,ProdNo);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'search-box__search')]");
            HelpersMethod.ClickBut(driver,WebEle,20);
            if(HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]",driver))
            {
                scenario.log("PRODUCT HAS NOT BEEN FOUND IN PARLIST");
            }
            else
            {
                scenario.log("PRODUCT HAS BEEN FOUND IN PARLIST");
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__clear')]");
                HelpersMethod.ActClick(driver,WebEle,100);
                exists=true;
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
            HelpersMethod.ActClick(driver,ParlistDropdown,1000);
        }
        catch (Exception e){}
        return exists;
    }

    public void enterQtyForParQty(String s,int i)
    {
        exists=false;
        try
        {
            WebElement parQty=HelpersMethod.FindByElement(driver,"xpath","//tr["+(i+1)+"]/td/descendant::input[contains(@class,'k-formatted-value')]");
            HelpersMethod.sendKeys(driver,parQty,60,s);
        }
        catch (Exception e){}
    }

    public void clickOnAddFilter()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,addFilter,100);
            exists=true;
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateFilterPopup()
    {
        exists=false;
        try
        {
            WebElement popupContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            WebElement popupSearch1=popupContainer.findElement(By.xpath(".//div[@class='i-search-box']/descendant::input"));
            HelpersMethod.sendKeys(driver,popupSearch1,100,"Par quantity");
            WebElement popupCheckbox=HelpersMethod.FindByElement(driver,"xpath","//input[@id='ParQuantity']");
            HelpersMethod.ClickBut(driver,popupCheckbox,80);
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
        }
        catch (Exception e){}
    }

    public void enterValueForFilter(String searchVal1, String searchVal2)
    {
        exists=false;
        try
        {
            WebElement popupContainer1 = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            WebElement searchInput1=popupContainer1.findElement(By.xpath(".//span[contains(@class,'k-textbox-container i-filter-popup__content__input')][1]/descendant::input"));
            HelpersMethod.ActSendKey(driver,searchInput1,80,searchVal1);
            WebElement searchInput2=popupContainer1.findElement(By.xpath(".//span[contains(@class,'k-textbox-container i-filter-popup__content__input')][2]/descendant::input"));
            HelpersMethod.ActSendKey(driver,searchInput2,80,searchVal2);
            WebElement applyButton=popupContainer1.findElement(By.xpath(".//button[text()='Apply']"));
            HelpersMethod.ClickBut(driver,applyButton,100);
        }
        catch (Exception e){}
    }

    public void clearFilterOption()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//button[@class='i-filter-tag__clear']",driver))
            {
                WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//button[@class='i-filter-tag__clear']");
                HelpersMethod.ClickBut(driver,WebEle,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readParProducts()
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> prods=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/descendant::button");
            for (WebElement prod:prods)
            {
              act.moveToElement(prod).build().perform();
              String prod_Text=prod.getText();
              scenario.log("PRODUCT NUMBER FOUND UNDER PAR LIST: "+prod_Text);
            }
        }
        catch (Exception e){}
    }
}
