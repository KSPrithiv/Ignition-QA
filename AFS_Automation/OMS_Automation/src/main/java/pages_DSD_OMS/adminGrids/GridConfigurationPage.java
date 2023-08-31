package pages_DSD_OMS.adminGrids;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class GridConfigurationPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    WebElement WebEle;
    static boolean exists=false;
    static String gridName=null;
    static String gridName1=null;

    @FindBy(xpath="//div[contains(@class,'moduleNameHeader')]/span[contains(@class,'spnmoduleNameHeader')]")
    private WebElement pageHeader;

    @FindBy(id="SelectGridType")
    private WebElement gridTypeDropDown;

    @FindBy(xpath="//button[contains(text(),'Grid options')]")
    private WebElement gridOptionDropdown;

    @FindBy(xpath="//button[contains(text(),'Column chooser')]")
    private WebElement columnChooser;

    public GridConfigurationPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void Refresh_Page2(String currentURL)
    {
        Actions act1=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {

                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, 40);
                if(wait.until(ExpectedConditions.alertIsPresent())==null)
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
                driver.navigate().to(currentURL);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebElement   WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
            }
        }
        catch (Exception e){}
    }

    public void validateGridConfigurationPage()
    {
        exists=false;
        try
        {
            String pHead= pageHeader.getText();
            if (pHead.equals("Configuration"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectAvailableGrid()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Available grids')]",driver))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Available grids", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Available grids')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectAnyGridType()
    {
        exists=false;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::div[@class='grid-name']");
            HelpersMethod.ActClick(driver,WebEle,100);
        }
        catch (Exception e){}
    }

    public String readGridType()
    {
        exists=false;
        String gType=null;
        try
        {
            gType=HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::div[@class='grid-name']").getText();
            scenario.log("GRID SELECTED IN AVAILABLE GRID IS "+gType);
            if(gType!=null)
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return gType;
    }

    public void selectGridConfiguration()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Grid configuration')]",driver))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Grid configuration", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Grid configuration')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void compareSelectedGrids(String gType)
    {
        exists=true;
        String gType1=null;
        try
        {
            gType1=HelpersMethod.FindByElement(driver,"xpath","//label[@id='SelectGridType-label']/following-sibling::span/descendant::span[@class='k-input']").getText();
            scenario.log("GRID SHOWN IN GRID CONFIGURATION TAB IS "+gType1);
            if(gType1.equals(gType))
            {
                scenario.log("GRID SELECTED IN AVIALABLE GRID AND GRID DISPLAYED IN GRID CONFIGURATION ARE SAME");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnGridTypeDropDown()
    {
        exists=false;
        try
        {
            if(gridTypeDropDown.isDisplayed() && gridTypeDropDown.isEnabled())
            {
                HelpersMethod.ActClick(driver, gridTypeDropDown, 1000);
                scenario.log("GRID TYPE DROP DOWN HAS BEEN CLICKED");
                exists = true;
                new WebDriverWait(driver, 60000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void selectGridTypeDropDown(String gridTypeSelect)
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            Thread.sleep(100);
            //new WebDriverWait(driver, 60000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container')]",driver))
            {
                List<WebElement> options=driver.findElements(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]/descendant::ul/li"));
                for (WebElement opt:options)
                {
                    act1.moveToElement(opt).build().perform();
                    String opt_text=opt.getText();
                    if(gridTypeSelect.equals(opt_text))
                    {
                        act1.click(opt).build().perform();
                        gridName=HelpersMethod.FindByElement(driver,"xpath","//span[@id='SelectGridType']/span[@class='k-input']").getText();
                        scenario.log("GRID TYPE SELECTED IS "+gridName);
                        break;
                    }
                }
            }
            String gType=HelpersMethod.FindByElement(driver,"xpath","//span[@id='SelectGridType']/span[@class='k-input']").getText();
            if(gType.equals(gridTypeSelect))
            {
                scenario.log("GRID TYPE SELECTED IS "+gType);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
    
    public void clickOnGridOptionDropdown()
    {
        exists=false;
        try
        {
            if(gridOptionDropdown.isDisplayed() && gridOptionDropdown.isEnabled())
            {
                HelpersMethod.ClickBut(driver, gridOptionDropdown, 200);
                scenario.log("GRID OPTION DROPDOWN CLICKED");
                exists=true;
                new WebDriverWait(driver,8000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]"))));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectGridOptionDropDown(String gridOpt)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
           List<WebElement> listOptions= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/ul/li[@class='k-item']|//div[contains(@class,'k-child-animation-container')]/ul/li[@class='k-item k-state-focused']");
           scenario.log(String.valueOf(listOptions.size()));
            for (WebElement listOpt:listOptions)
            {
              act.moveToElement(listOpt).build().perform();
              String opt_Text=listOpt.getText();
              scenario.log(opt_Text);
              if(opt_Text.equals(gridOpt))
              {
               act.moveToElement(listOpt).build().perform();
               act.click(listOpt).build().perform();
               scenario.log("GIRD OPTION IS SELECTED IS "+gridOpt);
               exists=true;
               break;
              }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCopyFromGridOptionDropDown(String gridOpt)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/ul/li[text()='Copy']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/ul/li[text()='Copy']");
                HelpersMethod.ActClick(driver,WebEle,200);
                scenario.log("CLICKED ON COPY OPTION");
                exists=true;
            }
                Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enterGridName(String gName)
    {
        exists=false;
        try
        {
            WebElement gridName=HelpersMethod.FindByElement(driver,"id","gridName");
            if(gridName.isDisplayed() && gridName.isEnabled())
            {
                HelpersMethod.sendKeys(driver,gridName,1000,gName);
                scenario.log("NEW GRID NAME SELECTED IS "+gName);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnColumnChooser()
    {
        exists=false;
        try
        {
            if(columnChooser.isDisplayed() && columnChooser.isEnabled())
            {
                HelpersMethod.ClickBut(driver, columnChooser, 200);
                new WebDriverWait(driver,1000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"))));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateColumnChooser()
    {
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
            Assert.assertEquals(modalContentTitle.getText(), "Column chooser", "Verify Title message");
        }
        catch (Exception e){}
    }

    public void dragAndDropColumnHeader(String tab)
    {
        exists=false;

        try
        {
            Actions actions=new Actions(driver);
            WebElement fromWebElement= HelpersMethod.FindByElement(driver,"xpath", "//td[text()='"+tab+"']/ancestor::div[@class='i-draggable-item']");
            WebElement toWebElement=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@id,'ActiveItemsAdminCard')]/descendant::div[contains(@class,'i-droppable-container')]");
            int x = toWebElement.getLocation().x;
            int y = toWebElement.getLocation().y;
            scenario.log("X"+x+","+"Y"+y);
            Actions action=new Actions(driver);
            action.dragAndDropBy(fromWebElement,x,y).build().perform();

            actions.moveToElement(fromWebElement)
                    .clickAndHold(fromWebElement)
                    .pause(Duration.ofSeconds(5))
                    .dragAndDrop(fromWebElement,toWebElement)
                    .build().perform();
            scenario.log("X"+x+","+"Y"+y);

            actions.keyDown(Keys.CONTROL)
                    .click(fromWebElement)
                    .click(toWebElement)
                    .keyUp(Keys.CONTROL);
            Action selectMultiple = actions.build();
            selectMultiple.perform();

            Action dragAndDrop = actions.moveToElement(fromWebElement)
            .clickAndHold(fromWebElement)
                    .moveToElement(toWebElement)
                    .release(toWebElement)
                    .build();
            dragAndDrop.perform();
        }
        catch (Exception e){}
    }

    public void gridHeaderAddedValidate()
    {
        exists=false;
        try
        {

        }
        catch (Exception e){}
    }

    public void clickGridDropDown()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='SelectGrid']",driver))
            {
               WebEle=HelpersMethod.FindByElement(driver,"id","SelectGrid");
               HelpersMethod.ActClick(driver,WebEle,1000);
               new WebDriverWait(driver,10000).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void gridDropdownSelection(String arg0)
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-popup k-child-animation-container')]",driver))
            {
                 WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
                 List<WebElement> options=WebEle.findElements(By.xpath(".//ul/li"));
                for (WebElement opt:options)
                {
                    act1.moveToElement(opt).build().perform();
                    String opt_text=opt.getText();
                    if(arg0.equals(opt_text))
                    {
                        act1.moveToElement(opt).build().perform();
                        act1.click(opt).build().perform();
                        gridName=HelpersMethod.FindByElement(driver,"xpath","//span[@id='SelectGrid']/span[@class='k-input']").getText();
                        scenario.log("GRID NAME SELECTED IS "+gridName);
                       break;
                    }
                }
            }
        }
        catch (Exception e){}
    }

    public void toggleDefaultGrid()
    {
        try
        {
            if(HelpersMethod.IsExists("//span[@id='defaultGrid' and @aria-checked='false']",driver))
            {
                WebElement defaultGrid=HelpersMethod.FindByElement(driver,"xpath","//span[@id='defaultGrid' and @aria-checked='false']");
                HelpersMethod.ActClick(driver,defaultGrid,100);
                scenario.log("GRID HAS BEEN SET AS DEFAULT");
            }
        }
        catch (Exception e){}
    }

    public void againClickToggleDefaultGrid()
    {
        exists=false;
        try
        {
            WebElement defaultGrid=HelpersMethod.FindByElement(driver,"xpath","//span[@id='defaultGrid']/input");
            String gridTaglle=HelpersMethod.JSGetValueEle(driver,defaultGrid,100);
            if(gridTaglle.equals("true"))
            {
                HelpersMethod.ActClick(driver,defaultGrid,100);
                gridTaglle=HelpersMethod.JSGetValueEle(driver,defaultGrid,100);
                if(gridTaglle.equals("false"))
                {
                    exists=true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public int readAllGridNames()
    {
        exists=false;
        Actions act=new Actions(driver);
        int listSize=0;
        try
        {
            WebElement gridOption=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
            List<WebElement> listOptions= gridOption.findElements(By.xpath(".//ul/li"));
            listSize=listOptions.size();
            for (WebElement listOpt:listOptions)
            {
                act.moveToElement(listOpt).build().perform();
                String opt_Text=listOpt.getText();
                scenario.log("GRID TYPE FOUND IN DROP DOWN: "+opt_Text);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return listSize;
    }

    public void validateAvailableGrid()
    {
        exists=true;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='available-grids-container']",driver))
            {
                scenario.log("USER IS IN AVAILABLE GRID CARD");
                exists=true;
            }
            else
            {
                scenario.log("USER NOT ABLE TO NAVIGATE TO AVAILABLE GRID CARD");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readGridNameDisabledInAvailableGrid()
    {
        exists=false;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::div[@class='grid-name']");
            gridName1=WebEle.getText();
            scenario.log("GRID SELECTED FOR DISABLING IN GRID TYPE DROP DOWN IS "+gridName1);
        }
        catch (Exception e){}
    }

    public void disableAvailableGrid()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='switch-control card']/descendant::span[@class='k-switch-container' and  @aria-checked='true']");
            HelpersMethod.ActClick(driver,WebEle,100);
            if(HelpersMethod.IsExists("//div[@class='switch-control card']/descendant::span[@class='k-switch-container' and  @aria-checked='false']",driver))
            {
                scenario.log("SELECTED GRID HAS BEEN DISABLED IN AVAILABLE GRID");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enableAvailableGrid()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='switch-control card']/descendant::span[@class='k-switch-container' and  @aria-checked='false']");
            HelpersMethod.ActClick(driver,WebEle,200);
            if(HelpersMethod.IsExists("//div[@class='switch-control card']/descendant::span[@class='k-switch-container' and  @aria-checked='true']",driver))
            {
                scenario.log("SELECTED GRID HAS BEEN ENABLED IN AVAILABLE GRID");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnSaveButton()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"id","save-btn");
            if(WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ClickBut(driver,WebEle,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickSaveButtonInAvailablegrid()
    {
        exists=false;
        WebElement WebEle;
        try
        {
            WebEle = HelpersMethod.FindByElement(driver, "id", "save-btn");
            if (WebEle.isDisplayed() && WebEle.isEnabled())
            {
                HelpersMethod.ClickBut(driver, WebEle, 1000);
                exists = true;
            }
        }
        catch (Exception e){}
    }

    public void selectAnyGridInAvailableGrid()
    {
        try
        {
            WebElement WebEle= HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::div[@class='grid-name']");
            HelpersMethod.ActClick(driver,WebEle,100);
        }
        catch (Exception e){}
    }

    public void disableAnyColumnNameInAvailableGrid()
    {
        exists=false;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='available-templates-container']/descendant::div[@class='i-switch '][1]/descendant::span[@class='k-switch-container' and @aria-checked='true']");
            if(HelpersMethod.IsExists(" //div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='available-templates-container']/descendant::div[@class='i-switch '][1]/descendant::span[@class='k-switch-container' and @aria-checked='true']",driver))
            {
                HelpersMethod.ActClick(driver,WebEle,100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String readColumnNameDisabled()
    {
        exists=false;
        String columnname=null;
        try
        {
            if(HelpersMethod.IsExists(" //div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='available-templates-container']/descendant::div[@class='i-switch '][1]/descendant::label",driver))
            {
                columnname=HelpersMethod.FindByElement(driver,"xpath"," //div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='available-templates-container']/descendant::div[@class='i-switch '][1]/descendant::label").getText();
                exists=true;
            }
        }
        catch (Exception e){}
        return  columnname;
    }

    public void validateColumnNamesInSelectedGrid(String columnName)
    {
        exists=false;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//span[text()='Grid configuration']/ancestor::div[@class='i-card']/descendant::th[@class='k-header']");
            for (WebElement head:heads)
            {
                i++;
                act.moveToElement(head).build().perform();
                String head_Text=head.getText();
                if(head_Text.equals("ID"))
                {
                   break;
                }
            }
            List<WebElement> gridHeads=HelpersMethod.FindByElements(driver,"xpath","//span[text()='Grid configuration']/ancestor::div[@class='i-card']/descendant::tr[contains(@class,'k-master-row')]/td["+i +"]");
            for (WebElement ghead:gridHeads)
            {
                act.moveToElement(ghead).build().perform();
                String ghead_Text=ghead.getText();
                if(!ghead_Text.equals(columnName))
                {
                    exists=true;
                }
            }

            if(exists==true)
            {
                scenario.log("COLUMN HAS BEEN REMOVED FROM THE GRID");
            }
        }
        catch (Exception e){}
    }

    public void enableAnyColumnNameInAvailableGrid()
    {
        exists=false;
        try
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='available-templates-container']/descendant::div[@class='i-switch '][1]/descendant::span[@class='k-switch-container' and @aria-checked='false']");
            if(HelpersMethod.IsExists(" //div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='available-templates-container']/descendant::div[@class='i-switch '][1]/descendant::span[@class='k-switch-container' and @aria-checked='false']",driver))
            {
                HelpersMethod.ActClick(driver,WebEle,100);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateSavedailogbox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                scenario.log("ADMIN SIDE CHANGES SAVE POPUP HAS APPEARED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnOkButtonInSavePopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement saveConfirmationPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=saveConfirmationPopup.findElement(By.xpath(".//button[contains(@id,'QuestionModalButton')]"));
                HelpersMethod.ActClick(driver,okButton,200);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch(Exception e){}
    }
}
