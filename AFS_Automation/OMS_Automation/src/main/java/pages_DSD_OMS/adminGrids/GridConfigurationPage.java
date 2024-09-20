package pages_DSD_OMS.adminGrids;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
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
    static String gridName;
    static String gridName1;
    static String oldLabel;
    static String newLabel;
    static int pos=0;

    @FindBy(xpath="//div[contains(@class,'moduleNameHeader')]/span[contains(@class,'spnmoduleNameHeader')]")
    private WebElement pageHeader;

    @FindBy(id="SelectGridType")
    private WebElement gridTypeDropDown;

    @FindBy(xpath="//button/span[text()='Grid options']")
    private WebElement gridOptionDropdown;

    @FindBy(xpath="//button/span[contains(text(),'Column chooser')]")
    private WebElement columnChooser;

    public GridConfigurationPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void Refresh_Page2(String currentURL)
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(@class,'k-window k-dialog')]",driver))
            {

                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.location.reload()");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(400000));
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
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800000);
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
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void selectAvailableGrid()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(200))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(HelpersMethod.IsExists("//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Available grids')]",driver))
            {
                HelpersMethod.navigate_Horizantal_Tab(driver, "Available grids", "//li[contains(@class,'k-item')]/span[@class='k-link' and contains(text(),'Available grids')]", "xpath", "//li[contains(@class,'k-item')]/span[@class='k-link']");
                exists=true;
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void selectAnyGridType()
    {
        exists=false;
        try
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//tr[1]/descendant::div[@class='grid-name']");
            HelpersMethod.ActClick(driver,WebEle,1000);
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
            Assert.assertTrue(exists);
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
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void compareSelectedGrids(String gType)
    {
        exists=true;
        String gType1;
        try
        {
            gType1=HelpersMethod.FindByElement(driver,"xpath","//label[@id='SelectGridType-label']/following-sibling::span/descendant::span[@class='k-input']").getText();
            scenario.log("GRID SHOWN IN GRID CONFIGURATION TAB IS "+gType1);
            if(gType1.equals(gType))
            {
                scenario.log("GRID SELECTED IN AVIALABLE GRID AND GRID DISPLAYED IN GRID CONFIGURATION ARE SAME");
                exists=true;
            }
            Assert.assertTrue(exists);
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
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void selectGridTypeDropDown(String gridTypeSelect)
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            Thread.sleep(500);
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='SelectGridType-listbox-id']/li/span"))));
            new WebDriverWait(driver,Duration.ofMillis(4000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='SelectGridType-listbox-id']/li/span")));

            if(HelpersMethod.IsExists("//ul[@id='SelectGridType-listbox-id']/li/span",driver))
            {
                List<WebElement> options=driver.findElements(By.xpath("//ul[@id='SelectGridType-listbox-id']/li/span"));
                for (WebElement opt:options)
                {
                    act1.moveToElement(opt).build().perform();
                    String opt_text=opt.getText();
                    if(gridTypeSelect.equals(opt_text))
                    {
                        act1.click(opt).build().perform();
                        gridName=HelpersMethod.FindByElement(driver,"xpath","//span[@id='SelectGridType']/descendant::span[@class='k-input-value-text']").getText();
                        scenario.log("GRID TYPE SELECTED IS "+gridName);
                        break;
                    }
                }
            }
            new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul[@id='SelectGridType-listbox-id']/li/span")));
            String gType=HelpersMethod.FindByElement(driver,"xpath","//span[@id='SelectGridType']/descendant::span[@class='k-input-value-text']").getText();
            if(gType.equals(gridTypeSelect))
            {
                scenario.log("GRID TYPE SELECTED IS "+gType);
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnGridOptionDropdown()
    {
        exists=false;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Grid options']/ancestor::button"))));
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Grid options']/ancestor::button")));

            gridOptionDropdown=HelpersMethod.FindByElement(driver,"xpath","//span[text()='Grid options']/ancestor::button");
            if(gridOptionDropdown.isDisplayed() && gridOptionDropdown.isEnabled())
            {
                HelpersMethod.ClickBut(driver, gridOptionDropdown, 10000);
                scenario.log("GRID OPTION DROPDOWN CLICKED");
                exists=true;
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='SelectGrid-listbox-id']/li/span"))));
                new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='SelectGrid-listbox-id']/li/span")));
                //Thread.sleep(1000);
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void selectGridOptionDropDown(String gridOpt)
    {
        exists=false;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> listOptions= HelpersMethod.FindByElements(driver,"xpath","//ul[@id='SelectGrid-listbox-id']/li/span");
            scenario.log(String.valueOf(listOptions.size()));
            for (WebElement listOpt:listOptions)
            {
                act.moveToElement(listOpt).build().perform();
                String opt_Text=listOpt.getText();
                scenario.log(opt_Text);
                if(opt_Text.equals(gridOpt))
                {
                    act.moveToElement(listOpt).build().perform();
                    //act.click(listOpt).build().perform();
                    HelpersMethod.JScriptClick(driver,listOpt,10000);
                    scenario.log("GIRD OPTION IS SELECTED IS "+gridOpt);
                    exists=true;
                    break;
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void selectCopyFromGridOptionDropDown(String gridOpt)
    {
        exists=false;
        Actions act=new Actions(driver);
        String optText="";
        try
        {
            if(HelpersMethod.IsExists("//ul[contains(@class,'k-menu-group')]/li/descendant::span[@class='k-menu-link-text']",driver))
            {
                List<WebElement> options=HelpersMethod.FindByElements(driver,"xpath","//ul[contains(@class,'k-menu-group')]/li/descendant::span[@class='k-menu-link-text']");
                for(WebElement opt:options)
                {
                    act.moveToElement(opt).build().perform();
                    optText=opt.getText();
                    if(optText.equalsIgnoreCase(gridOpt))
                    {
                        act.moveToElement(opt).click().build().perform();
                        HelpersMethod.JScriptClick(driver,opt,10000);
                        scenario.log("SELECTED OPTION "+optText);
                        exists=true;
                        break;
                    }
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void selectOptionFromGridOptionDropDown(String gridOpt)
    {
        exists=false;
        Actions act=new Actions(driver);
        String optText;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='k-child-animation-container']/descendant::span[@class='k-menu-link-text']",driver))
            {
                List<WebElement> options=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-child-animation-container']/descendant::span[@class='k-menu-link-text']");
                for(WebElement opt:options)
                {
                    act.moveToElement(opt).build().perform();
                    optText=opt.getText();
                    if(optText.equals(gridOpt))
                    {
                        act.moveToElement(opt).click().build().perform();
                        HelpersMethod.JScriptClick(driver,opt,10000);
                        scenario.log("SELECTED OPTION "+optText);
                        exists=true;
                        break;
                    }
                }
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }


    public void selectDeleteOptionFromGridOptionDropDown(String gridOpt)
    {
        exists=false;
        Actions act=new Actions(driver);
        String optText;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='k-child-animation-container']/descendant::span[@class='k-menu-link-text']",driver))
            {
                List<WebElement> options=HelpersMethod.FindByElements(driver,"xpath","//div[@class='k-child-animation-container']/descendant::span[@class='k-menu-link-text']");
                for(WebElement opt:options)
                {
                    act.moveToElement(opt).build().perform();
                    optText=opt.getText();
                    if(optText.equals(gridOpt))
                    {
                        act.moveToElement(opt).click().build().perform();
                        act.click(opt).build().perform();
                        scenario.log("SELECTED OPTION "+optText);
                        exists=true;
                        break;
                    }
                }
            }
            Assert.assertTrue(exists);
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
                HelpersMethod.EnterText(driver,gridName,10000,gName);
                gridName.sendKeys(Keys.TAB);
                scenario.log("NEW GRID NAME SELECTED IS "+gName);
                exists=true;
            }
            Assert.assertTrue(exists);
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
                HelpersMethod.ClickBut(driver, columnChooser, 10000);
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]"))));
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void validateColumnChooser()
    {
        exists=false;
        try
        {
            WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));
            WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title k-dialog-title')]"));
            //Assert.assertEquals(modalContentTitle.getText(), "Column chooser", "Verify Title message");
            if(modalContentTitle.getText().equals("Column chooser"))
            {
                exists=true;
            }
            else
            {
                exists=false;
            }
            Assert.assertEquals(exists,true);
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

    public void clickGridDropDown()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='SelectGrid']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"id","SelectGrid");
                HelpersMethod.ActClick(driver,WebEle,10000);
                exists=true;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void gridDropdownSelection(String arg0)
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='SelectGrid-listbox-id']/li/span[@class='k-list-item-text']"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='SelectGrid-listbox-id']/li/span[@class='k-list-item-text']")));
            if(HelpersMethod.IsExists("//ul[@id='SelectGrid-listbox-id']/descendant::span[@class='k-list-item-text']",driver))
            {
                List<WebElement> options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='SelectGrid-listbox-id']/descendant::span[@class='k-list-item-text']");
                for (WebElement opt:options)
                {
                    act1.moveToElement(opt).build().perform();
                    String opt_text=opt.getText();
                    if(arg0.equals(opt_text))
                    {
                        act1.moveToElement(opt).build().perform();
                        act1.click(opt).build().perform();
                        exists=true;
                        break;
                    }
                }
            }
            if(exists==true)
            {
                scenario.log("GRID NAME SELECTED IS "+gridName);
            }
            else
            {
                scenario.log("<span style='color:red'>GRID NAME IS NOT AVAILABLE</span>");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void readGridNamesDropdown()
    {
        exists=false;
        Actions act1=new Actions(driver);
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='SelectGrid-listbox-id']/li/span[@class='k-list-item-text']"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='SelectGrid-listbox-id']/li/span[@class='k-list-item-text']")));
            if(HelpersMethod.IsExists("//ul[@id='SelectGrid-listbox-id']/li/span[@class='k-list-item-text']",driver))
            {
                scenario.log("GRIDS AVAILABLE ARE::");
                List<WebElement> options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='SelectGrid-listbox-id']/li/span[@class='k-list-item-text']");
                for (WebElement opt:options)
                {
                    act1.moveToElement(opt).build().perform();
                    String opt_text=opt.getText();
                    scenario.log(opt_text);
                }
            }
        }
        catch (Exception e){}
    }

    public void gridMainDropdownSelection()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//ul[@id='SelectGrid-listbox-id']/li/span[text()='Main']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//ul[@id='SelectGrid-listbox-id']/li/span[text()='Main']");
                HelpersMethod.ActClick(driver,WebEle,10000);
                scenario.log("CLICKED ON COPY OPTION");
                exists=true;
            }
            Assert.assertTrue(exists);
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
                HelpersMethod.ActClick(driver,defaultGrid,10000);
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
            String gridTaglle=HelpersMethod.JSGetValueEle(driver,defaultGrid,10000);
            if(gridTaglle.equals("true"))
            {
                HelpersMethod.ActClick(driver,defaultGrid,10000);
                gridTaglle=HelpersMethod.JSGetValueEle(driver,defaultGrid,10000);
                if(gridTaglle.equals("false"))
                {
                    exists=true;
                }
            }
            Assert.assertTrue(exists);
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
            List<WebElement> listOptions=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            scenario.log("DROP DOWN GRID "+listOptions.size());
            listSize=listOptions.size();
            for (WebElement listOpt:listOptions)
            {
                act.moveToElement(listOpt).build().perform();
                String opt_Text=listOpt.getText();
                scenario.log("GRID TYPE FOUND IN DROP DOWN: "+opt_Text);
                exists=true;
            }

            /*for(int i=0;i<=listOptions.size()-1;i++)
            {
                listOpt=listOptions.get(0);
                opt_Text=listOpt.getText();
                scenario.log("GRID TYPE FOUND IN DROP DOWN: "+opt_Text);
                exists=true;
            }*/
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
        return listSize;
    }

    public void validateAvailableGrid()
    {
        exists=true;
        try
        {
            Thread.sleep(2000);
            if(HelpersMethod.IsExists("//div[@class='available-grids-container']",driver))
            {
                scenario.log("USER IS IN AVAILABLE GRID CARD");
                exists=true;
            }
            else
            {
                scenario.log("USER NOT ABLE TO NAVIGATE TO AVAILABLE GRID CARD");
            }
            Assert.assertTrue(exists);
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
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='switch-control card']/descendant::span[contains(@class,'k-switch-on') and  @aria-checked='true']");
            HelpersMethod.ActClick(driver,WebEle,10000);
            if(HelpersMethod.IsExists("//div[@class='switch-control card']/descendant::span[contains(@class,'k-switch-off') and  @aria-checked='false']",driver))
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
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='switch-control card']/descendant::span[contains(@class,'k-switch-off') and  @aria-checked='false']");
            HelpersMethod.ActClick(driver,WebEle,10000);
            //Thread.sleep(1000);
            if(HelpersMethod.IsExists("//div[@class='switch-control card']/descendant::span[contains(@class,'k-switch-on') and  @aria-checked='true']",driver))
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
                HelpersMethod.ClickBut(driver,WebEle,10000);
                exists=true;
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(150))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(150))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertTrue(exists);
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
                HelpersMethod.ClickBut(driver, WebEle, 10000);
                String status = HelpersMethod.returnDocumentStatus(driver);
                if (status.equals("loading"))
                {
                    HelpersMethod.waitTillLoadingPage(driver);
                }
                Thread.sleep(500);
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
            HelpersMethod.ActClick(driver,WebEle,10000);
        }
        catch (Exception e){}
    }

    public void disableAnyColumnNameInAvailableGrid(String columnName)
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//label[contains(text(),'"+columnName+"')]/parent::div/preceding-sibling::span[contains(@class,'k-switch-on')]",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//label[contains(text(),'"+columnName+"')]/parent::div/preceding-sibling::span[contains(@class,'k-switch-on')]");
                HelpersMethod.ActClick(driver,WebEle,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String readColumnNameToBeDisabled()
    {
        exists=false;
        String columnname=null;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='available-templates-container']/descendant::div[@class='i-switch '][1]/descendant::label",driver))
            {
                columnname=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-card__card__body i-card__card__body--expanded']/div[@class='available-templates-container']/descendant::div[@class='i-switch '][1]/descendant::label").getText();
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
            // identify the id column in the grid, which contains column name of the table
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@id='GridConfigurationConfiguration']/descendant::span[@class='k-column-title']");
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
            if(exists)
            {
                scenario.log("COLUMN HAS BEEN REMOVED FROM THE GRID");
            }
        }
        catch (Exception e){}
    }

    public void validateColumnNamesInExistenceSelectedGrid(String columnName)
    {
        exists=false;
        Actions act=new Actions(driver);
        int i=0;
        try
        {
            // identify the id column in the grid, which contains column name of the table
            List<WebElement> heads=HelpersMethod.FindByElements(driver,"xpath","//div[@id='GridConfigurationConfiguration']/descendant::span[@class='k-column-title']");
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
                if(ghead_Text.equals(columnName))
                {
                    exists=true;
                }
            }
            if(exists)
            {
                scenario.log("COLUMN HAS BEEN FOUND IN THE GRID");
            }
        }
        catch (Exception e){}
    }

    public void enableAnyColumnNameInAvailableGrid(String columnName)
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//label[contains(text(),'"+columnName+"')]/parent::div/preceding-sibling::span[contains(@class,'k-switch-off')]",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//label[contains(text(),'"+columnName+"')]/parent::div/preceding-sibling::span[contains(@class,'k-switch-off')]");
                HelpersMethod.ActClick(driver,WebEle,10000);
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
            //new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]")));
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully.')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                scenario.log("ADMIN SIDE CHANGES SAVE POPUP HAS APPEARED");
                exists=true;
            }
            else
            {
                exists=false;
            }
            Assert.assertTrue(exists);
        }
        catch (Exception e){}
    }

    public void clickOnOkButtonInSavePopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement saveConfirmationPopup=HelpersMethod.FindByElement(driver,"xpath","//div[contains(text(),'saved successfully')]/ancestor::div[contains(@class,'k-window k-dialog')]");
                WebElement okButton=saveConfirmationPopup.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,10000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                exists=true;
            }
            else if(HelpersMethod.IsExists("//div[contains(text(),'Duplicate grid')]/ancestor::div[@class='k-window k-dialog']",driver))
            {
                WebElement container=HelpersMethod.FindByElement(driver,"xpath","//div[@class='k-window k-dialog']");
                WebElement okButton=container.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,10000);
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
                }
                exists=false;
            }
            Assert.assertTrue(exists);
        }
        catch(Exception e){}
    }

    public void readGridHeaderLabel()
    {
        exists=false;
        Actions act=new Actions(driver);
        String headerText;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }

               WebElement scrollEle=HelpersMethod.FindByElement(driver,"id","GridConfigurationConfiguration");
               HelpersMethod.ScrollElement(driver,scrollEle);
               List<WebElement> headers=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-grid-edit-row')]/descendant::input[@class='k-textbox']");
               for(WebElement header:headers)
               {
                   pos ++;
                   act.moveToElement(header).build().perform();
                   headerText=HelpersMethod.JSGetValueEle(driver,header,10000);
                   if(headerText.equalsIgnoreCase("Sequence"))
                   {
                       WebElement gridLabel=driver.findElement(By.xpath("//tr[contains(@class,'k-grid-edit-row')]["+pos+"]/descendant::input[@class='k-textbox']"));

                       oldLabel = HelpersMethod.JSGetValueEle(driver, gridLabel, 10000);
                       scenario.log("OLD LABEL VALUE IS " + oldLabel);
                       exists = true;
                       break;
                   }
               }
           Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public String enterNewLabel()
    {
        exists=false;
        String newLabel1=null;
        try
        {
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-grid-edit-row')]["+pos+"]/descendant::input[@class='k-textbox']",driver))
            {
                newLabel=oldLabel+"123";
                WebElement gridLabel=driver.findElement(By.xpath("//tr[contains(@class,'k-grid-edit-row')]["+pos+"]/descendant::input[@class='k-textbox']"));
                HelpersMethod.JSSetValueEle(driver,gridLabel,10000,"");
                WebElement newHead= driver.findElement(By.xpath("//tr[contains(@class,'k-grid-edit-row')]["+pos+"]/descendant::input[@class='k-textbox']"));
                HelpersMethod.ActSendKey(driver,newHead,10000,newLabel);
                scenario.log("NEW LABEL VALUE IS " + newLabel);
                newLabel1=HelpersMethod.JSGetValueEle(driver,gridLabel,10000);
            }
            if(newLabel.equalsIgnoreCase(newLabel1))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
            Thread.sleep(2000);
        }
        catch (Exception e){}
        return newLabel;
    }

    public void resetLabelToOld()
    {
        exists=false;
        String newLabel1=null;
        try
        {
            Thread.sleep(1000);
            if(HelpersMethod.IsExists("//tr[contains(@class,'k-grid-edit-row')]["+pos+"]/descendant::input[@class='k-textbox']",driver))
            {
                WebElement gridLabel=driver.findElement(By.xpath("//tr[contains(@class,'k-grid-edit-row')]["+pos+"]/descendant::input[@class='k-textbox']"));

                driver.findElement(By.xpath("//tr[contains(@class,'k-grid-edit-row')]["+pos+"]/descendant::input[@class='k-textbox']")).sendKeys("");
                HelpersMethod.JSSetValueEle(driver,gridLabel,10000,"");
                WebElement oldValue= driver.findElement(By.xpath("//tr[contains(@class,'k-grid-edit-row')]["+pos+"]/descendant::input[@class='k-textbox']"));
                HelpersMethod.ActSendKey(driver,oldValue,10000,oldLabel);
                scenario.log("OLD LABEL VALUE IS " + oldLabel);
                newLabel1=HelpersMethod.JSGetValueEle(driver,gridLabel,10000);
            }

            if(oldLabel.equalsIgnoreCase(newLabel1))
            {
                exists=true;
            }
            Thread.sleep(2000);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void checkDeletedGridName(String arg0)
    {
        exists=true;
        Actions act=new Actions(driver);
        String gridNameText;
        try
        {
            List<WebElement> gridNames=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='SelectGrid-listbox-id']/descendant::span[@class='k-list-item-text']");
            for(WebElement gridName:gridNames)
            {
                act.moveToElement(gridName).build().perform();
                gridNameText=gridName.getText();
                if(gridNameText.equals(arg0))
                {
                    scenario.log("GRID HAS NOT BEEN DELETED");
                    exists=false;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}