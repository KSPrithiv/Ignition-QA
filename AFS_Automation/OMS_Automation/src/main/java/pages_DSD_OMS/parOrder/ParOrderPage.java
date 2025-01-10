package pages_DSD_OMS.parOrder;

import gherkin.lexer.He;
import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
    static String ProdNo;

    @FindBy(id = "plusAdditionalAccountButtonFlat")
    private WebElement NewPar;

    @FindBy(id="deleteAdditionalAccountButton")
    private WebElement DelPar;

    @FindBy(xpath ="//label[contains(text(),'Par list')]/following-sibling::span/descendant::button//*[local-name()='svg']")
    private WebElement ParlistDropdown;

    @FindBy(xpath="//div[@class='parList-container']/descendant::label[contains(text(),'Description')]/following-sibling::input")
    private WebElement ParDes;

    @FindBy(xpath = "//div[@class='parList-container']/descendant::input[@id='SearchBox1']")
    private WebElement ParSearchBox;

    @FindBy(id="save")
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
        Wait<WebDriver> wait;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]", driver))
            {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                wait = new WebDriverWait(driver, Duration.ofMillis(1000));
                if (wait.until(ExpectedConditions.alertIsPresent()) == null)
                {

                }
                else
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                }
               wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
                //navigating back to Current URL
                driver.navigate().to(currentURL);
                scenario.log("NAVIGATED TO ORDER GUIDE/PAR ORDER");

            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }

            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000000);
            }
        }
        catch (Exception e){}
    }

    public void ClickParTab()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(text(),'Par list')]",driver))
            {
                WebElement ParList = HelpersMethod.FindByElement(driver, "xpath", "//span[contains(text(),'Par list')]");
                HelpersMethod.ScrollElement(driver, ParList);
                HelpersMethod.navigate_Horizantal_Tab(driver, "Par list", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Par list')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                exists = true;
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickProductTab()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebElement ParList=HelpersMethod.FindByElement(driver,"xpath","//span[contains(text(),'Products')]");
            HelpersMethod.ScrollElement(driver,ParList);
            HelpersMethod.ActClick(driver,ParList,1000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ValidateParlistTab()
    {
        exists=false;
        try
        {
            HelpersMethod.WaitElementPresent(driver,"xpath","//div[@class='parList-container']",80000);
            if(HelpersMethod.IsExists("//div[@class='parList-container']",driver))
            {
                scenario.log("USER IN PAR ORDER LIST");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void ClickNewPar()
    {
        WebElement WebEle;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            HelpersMethod.ClickBut(driver,NewPar,10000);
            exists=true;
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DeletePar()
    {
        WebElement WebEle;
        exists=false;
        try
        {
            if(DelPar.isEnabled())
            {

                HelpersMethod.ClickBut(driver, DelPar, 1000);
                if (HelpersMethod.IsExists("//div[contains(text(),'Delete')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
                {
                    WebElement deletePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                    WebElement Ok_But = deletePopup.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ActClick(driver, Ok_But, 1000);
                    exists = true;
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 200000);
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
        WebElement WebEle;
        try
        {
            if(ParSave.isEnabled())
            {
                HelpersMethod.ClickBut(driver, ParSave, 20000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                }
                if(HelpersMethod.IsExists("//div[text()='Par list']/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement savePopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                    WebElement Ok_But=savePopup.findElement(By.xpath(".//descendant::button/span[text()='OK']"));
                    HelpersMethod.ActClick(driver,Ok_But,400000);
                    exists=true;
                }
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
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
            WebElement WebEle;
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
        WebElement WebEle;
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
            }
            if(ParlistDropdown.isDisplayed())
            {
                HelpersMethod.ActClick(driver, ParlistDropdown, 1000);
                String status = HelpersMethod.returnDocumentStatus(driver);
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

    public void SelectParlistFromDropdown(String parList)
    {
        exists=false;
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='dropDownNoneType-listbox-id']/descendant::span")));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='dropDownNoneType-listbox-id']/descendant::span")));
            List<WebElement> parListItems=driver.findElements(By.xpath("//ul[@id='dropDownNoneType-listbox-id']/descendant::span"));
            for (WebElement pList:parListItems)
            {
                exists=false;
                act.moveToElement(pList).build().perform();
                String pList_text=pList.getText();
                if(pList_text.equalsIgnoreCase(parList))
                {
                    act.moveToElement(pList).build().perform();
                    act.click().build().perform();
                    //HelpersMethod.JScriptClick(driver,pList,10000);
                    scenario.log(" PAR LIST FOUND IS "+pList_text);
                    exists=true;
                    break;
                }
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 600000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void EnterProductNoInSearchBox()
    {
        WebElement WebEle;
        exists=false;
        try
        {
            scenario.log("PRODUCT TO BE SEARCHED IS "+ProdNo);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-search-box']/descendant::input");
            HelpersMethod.EnterText(driver,WebEle,1000,ProdNo);
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-search-box']//*[local-name()='svg' and contains(@class,'search-box__search')]");
            HelpersMethod.ClickBut(driver,WebEle,1000);
            if(HelpersMethod.IsExists("//div[contains(@class,'i-no-data__icon')]",driver))
            {
                scenario.log("PRODUCT HAS NOT BEEN FOUND IN PARLIST");
            }
            else
            {
                scenario.log("PRODUCT HAS BEEN FOUND IN PARLIST");
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//*[local-name()='svg' and contains(@class,'i-icon   i-search-box__clear')]");
                HelpersMethod.ActClick(driver,WebEle,1000);
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
            HelpersMethod.sendKeys(driver,parQty,1000,s);
        }
        catch (Exception e){}
    }

    public void enterQtyForParQty1(String qty)
    {
        exists=false;
        try
        {
            WebElement parQty=HelpersMethod.FindByElement(driver,"xpath","//tr["+1+"]/td/descendant::input[contains(@class,'k-formatted-value')]");
            HelpersMethod.sendKeys(driver,parQty,10000,qty);
        }
        catch (Exception e){}
    }

    public void clickOnAddFilter()
    {
        exists=false;
        try
        {
            HelpersMethod.ActClick(driver,addFilter,1000);
            exists=true;
            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateFilterPopup()
    {
        exists=false;
        try
        {
            //WebElement popupContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
            WebElement popupSearch1=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-child-animation-container']/descendant::div[@class='i-search-box']/descendant::input");
            HelpersMethod.sendKeys(driver,popupSearch1,10000,"Par quantity");
            WebElement popupCheckbox=HelpersMethod.FindByElement(driver,"xpath","//input[@id='ParQuantity']");
            HelpersMethod.ClickBut(driver,popupCheckbox,10000);
            new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]"))));
        }
        catch (Exception e){}
    }

    public void enterValueForFilter(String searchVal1, String searchVal2)
    {
        exists=false;
        try
        {
            WebElement popupContainer1 = HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-animation-container k-animation-container-shown']");
            WebElement searchInput1=popupContainer1.findElement(By.xpath(".//span[contains(@class,'k-textbox-container i-filter-popup__content__input')][1]/descendant::input"));
            HelpersMethod.ActSendKey(driver,searchInput1,10000,searchVal1);
            WebElement searchInput2=popupContainer1.findElement(By.xpath(".//span[contains(@class,'k-textbox-container i-filter-popup__content__input')][2]/descendant::input"));
            HelpersMethod.ActSendKey(driver,searchInput2,10000,searchVal2);
            WebElement applyButton=popupContainer1.findElement(By.xpath(".//button/span[text()='Apply']"));
            HelpersMethod.ActClick(driver,applyButton,10000);
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
                HelpersMethod.ClickBut(driver,WebEle,10000);
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

    public void deleteAllPar()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            ClickParDropDown();
            List<WebElement> pars=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-slide-down-enter')]/descendant::ul/li");
            while(!pars.isEmpty())
            {
                //select parlist from par
                WebElement delePar = pars.get(0);
                HelpersMethod.ClickBut(driver,delePar,1000);

                //click on Delete button
                HelpersMethod.ClickBut(driver,DelPar,1000);

                if(HelpersMethod.IsExists("//div[contains(text(),'Are you sure you want to delete par list')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
                {
                    WebElement deleteConfirm= HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'Are you sure you want to delete par list')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                    WebElement deleOkButton=deleteConfirm.findElement(By.xpath(".//button/span[text()='Ok']"));
                    HelpersMethod.ClickBut(driver,deleOkButton,1000);
                    if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                    {
                        WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400000);
                    }
                }
                //remove parlist from list also
                pars.remove(delePar);
                //click on parlist drop down
                ClickParDropDown();
                //reassign list value with new list of parlist
                pars =  HelpersMethod.FindByElements(driver, "xpath", "//div[contains(@class,'k-slide-down-enter')]/descendant::ul/li");
            }
        }
        catch (Exception e){}
    }
}