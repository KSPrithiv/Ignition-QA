package helper;

import com.sun.activation.registries.LogSupport;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Project DSD_OMS
 * @Author DivyaRamadas@afsi.com
 */
public class HelpersMethod
{
    /* Created by DivyaRamadas@afsi.com */
    public static WebElement FindByElement(WebDriver driver,String selector,String value)
    {
        WebElement element=null;
        if(selector.equalsIgnoreCase("id"))
        {
            element=driver.findElement(By.id(value));
        }
        else if(selector.equalsIgnoreCase("class"))
        {
            element=driver.findElement(By.className(value));
        }
        else if(selector.equalsIgnoreCase("xpath"))
        {
            element=driver.findElement(By.xpath(value));
        }
        else if(selector.equalsIgnoreCase("cssselector"))
        {
            element=driver.findElement(By.cssSelector(value));
        }
        else if(selector.equalsIgnoreCase("linktext"))
        {
            element=driver.findElement(By.linkText(value));
        }
        else if(selector.equalsIgnoreCase("partiallinkedtext"))
        {
            element=driver.findElement(By.partialLinkText(value));
        }
        else if(selector.equalsIgnoreCase("tagname"))
        {
            element=driver.findElement(By.tagName(value));
        }
        return element;
    }

    //Generic method for creating list of web elements
    public static List<WebElement> FindByElements(WebDriver driver,String selector,String value)
    {
        List<WebElement> elements = null;
        if (selector.equalsIgnoreCase("id")) {
            elements = driver.findElements(By.id(value));
        } else if (selector.equalsIgnoreCase("class")) {
            elements = driver.findElements(By.className(value));
        } else if (selector.equalsIgnoreCase("xpath")) {
            elements = driver.findElements(By.xpath(value));
        } else if (selector.equalsIgnoreCase("cssselector")) {
            elements = driver.findElements(By.cssSelector(value));
        } else if (selector.equalsIgnoreCase("linktext")) {
            elements = driver.findElements(By.linkText(value));
        } else if (selector.equalsIgnoreCase("partiallinkedtext")) {
            elements = driver.findElements(By.partialLinkText(value));
        } else if (selector.equalsIgnoreCase("tagname")) {
            elements = driver.findElements(By.tagName(value));
        }
        return elements;
    }

    public static void Refresh(WebDriver driver)
    {
        driver.navigate().to(driver.getCurrentUrl());
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 80000);
        }
    }

    public static void NavigateBack(WebDriver driver)
    {
        driver.navigate().back();
    }

    public static void Implicitwait(WebDriver driver, int sec)
    {driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);}


    public static boolean waitVisibilityOfEle(WebDriver driver, WebElement ele, int timeOut)
    {
        if(!ele.isDisplayed())
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis( timeOut));
            wait.until(ExpectedConditions.visibilityOf(ele));
        }
        else
        {
            // ElementNotVisibleException EleVis= new ElementNotVisibleException("Element not Visible");
            // throw EleVis;
        }
        return true;
    }

    public static boolean waitClickableOfEle(WebDriver driver,WebElement ele,int timeOut)
    {
        if (!ele.isDisplayed())
        {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(timeOut));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
        }
        else
        {
            // ElementNotVisibleException EleVis = new ElementNotVisibleException("Element not Visible");
            // throw EleVis;
        }
        return true;
    }

    public static void WaitElementPresent(WebDriver driver,String selector,String val,int timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(timeOut));
        if(selector.equalsIgnoreCase("id"))
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(val)));
        }
        else if(selector.equalsIgnoreCase("class"))
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className(val)));
        }
        else if(selector.equalsIgnoreCase("xpath"))
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(val)));
        }
        else if(selector.equalsIgnoreCase("cssselector"))
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(val)));
        }
        else if(selector.equalsIgnoreCase("linktext"))
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(val)));
        }
        else if(selector.equalsIgnoreCase("partiallinkedtext"))
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(val)));
        }
        else if(selector.equalsIgnoreCase("tagname"))
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(val)));
        }
    }

    public static boolean EleDisplay(WebElement ele)
    {
        boolean display=false;
        if (ele.isDisplayed())
        {
            display =true;
        }
        else
        {
            display= false;
        }
        return display;
    }

    public static void ScrollElement(WebDriver driver, WebElement ele)
    {
        if(ele.isDisplayed())
        {((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);}
        else
        {
            //ElementNotVisibleException EleVis= new ElementNotVisibleException("Element not Visible");
            //throw EleVis;
        }
    }

    public static void ScrollTillElementVisible(WebDriver driver,WebElement element)
    {
        Dimension dim = element.getSize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(" + dim.width + "," + dim.height + ")");
    }

    public static void ScrollUpScrollBar(WebDriver driver)
    {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
    }

    public static void ScrollDownScrollBar(WebDriver driver)
    {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
    }

    public static void EnterText(WebDriver driver,WebElement element,int timeOut ,String val)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        if ((element.isDisplayed() && element.isEnabled()) == true)
        {
            element.sendKeys(val);
        }
    }

    public static void ClearText(WebDriver driver,WebElement element,int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        if (element.isDisplayed() && element.isEnabled() == true)
        {
            element.clear();
        }
        else
        {
            // ElementNotVisibleException EleVis = new ElementNotVisibleException("Element not Visible");
            // throw EleVis;
        }
    }

    public static void ClickBut(WebDriver driver,WebElement element,int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void ActSendKey(WebDriver driver,WebElement element,int timeOut,String val) throws InterruptedException
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
        element.sendKeys(val);
        act.moveToElement(element).build().perform();
        element.sendKeys(Keys.TAB);
    }

    public static void ActSendKeyEnter(WebDriver driver,WebElement element,int timeOut,String val) throws InterruptedException
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        Actions act = new Actions(driver);
        act.moveToElement(element).sendKeys(val).build().perform();
        act.moveToElement(element).sendKeys(Keys.ENTER).build().perform();
    }

    public static void ActClearKey(WebDriver driver,WebElement element,int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        Actions act = new Actions(driver);
        act.click(element).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).perform();
    }

    public static String ReadValue(WebElement ele)
    {
        String Read_Val="";
        if (ele.isDisplayed())
        {
            Read_Val = ele.getText();
        }
        else
        {
            //ElementNotVisibleException EleVis = new ElementNotVisibleException("Element not Visible");
            //throw EleVis;
        }
        return Read_Val;
    }

    public static String AttributeValue(WebElement ele,String attribute)
    {
        String Value;
        Value=ele.getAttribute(attribute);
        return Value;
    }

    public static boolean IsExists(String Xpath,WebDriver driver)
    {
        try
        {
            driver.findElement(By.xpath(Xpath));
            return true;
        }
        catch (Exception e)
        {return false;}
    }

    public static boolean IsExistsById(String Id,WebDriver driver)
    {
        try
        {
            driver.findElement(By.id(Id));
            return  true;
        }
        catch (Exception e)
        {return false;}
    }

    public static void ActClick(WebDriver driver,WebElement element,int timeOut) throws InterruptedException
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.elementToBeClickable(element));
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
        act.click(element).build().perform();
    }

    public static void JScriptClick(WebDriver driver,WebElement element,int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.elementToBeClickable(element));
        if (element.isDisplayed() && element.isEnabled())
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
        else
        {
            //ElementNotVisibleException EleVis= new ElementNotVisibleException("Element not Visible");
            //throw EleVis;
        }
    }

    public static void JSSetValueEle(WebDriver driver,WebElement element,int timeOut,String val)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed() && element.isEnabled())
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"+val+"';", element);
        }
        else
        {
            //ElementNotVisibleException EleVis= new ElementNotVisibleException("Element not Visible");
            //throw EleVis;
        }
    }

    public static String JSGetValueEle(WebDriver driver,WebElement element,int timeOut)
    {
        String value=null;
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed() && element.isEnabled())
        {
            JavascriptExecutor js=(JavascriptExecutor) driver;
            value= js.executeScript("return arguments[0].value", element).toString();
        }
        else
        {
            //ElementNotVisibleException EleVis= new ElementNotVisibleException("Element not Visible");
            //throw EleVis;
        }
        return value;
    }

    public static String returnStatus(WebDriver driver,WebElement element,int timeOut)
    {
        String value=null;
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed())
        {
            value= element.getAttribute("aria-checked");
        }
        return  value;
    }


    //To check whether element is enabled or not
    public static boolean IsEnabledById(String eleId, WebDriver driver)
    {
        boolean exists = false;
        WebElement ele = driver.findElement(By.id(eleId));
        if (ele.isEnabled())
        {
            exists = true;
        }
        return exists;
    }

    public static boolean IsEnabledByXpath(String eleXpath,WebDriver driver)
    {
        boolean exists=false;
        WebElement ele=driver.findElement(By.xpath(eleXpath));
        if(ele.isEnabled())
        {exists=true;}
        return exists;
    }

    public static boolean IsEnabledByele(WebElement ele)
    {
        boolean result=false;
        result=ele.isEnabled();
        return result;
    }

    public static void WebElementClearInput(WebElement element)
    {
        element.clear();
    }

    public static void WebElementFromDropDown(WebDriver driver,String ListElements,String ItemXpath,String ListElement) throws InterruptedException
    {
        Actions act=new Actions(driver);
        int i = 0;
        List<WebElement> ListItems = FindByElements(driver,ItemXpath,ListElements);
        for (WebElement ListItem : ListItems)
        {
            i++;
            String List_Item_value = ListItem.getText();
            act.moveToElement(ListItem).build().perform();
            if (List_Item_value.equalsIgnoreCase(ListElement) || List_Item_value.contains(ListElement.toLowerCase()))
            {
                act.click(ListItem).build().perform();
                break;
            }
        }
        if(IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=FindByElement(driver,"xpath","//div[@class='loader']");
            waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
    }

    public static void JSScroll(WebDriver driver,WebElement ele)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
    }

    public static void ActScroll(WebDriver driver,WebElement element,int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.elementToBeClickable(element));
        Actions act = new Actions(driver);
        act.moveToElement(element);
        act.perform();
    }

    public static void ActDragDrop(WebDriver driver,WebElement From,WebElement To)
    {
        Actions act=new Actions(driver);
        //Dragged and dropped.
        act.dragAndDrop(From,To).build().perform();
    }

    public static void FileUploadRobot() throws AWTException
    {
        Robot robot = new Robot();
        robot.setAutoDelay(50000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.setAutoDelay(50000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void FileDownload() throws InterruptedException, AWTException
    {

        Robot robot = new Robot();

        robot.setAutoDelay(5000);
        robot.mouseMove(630, 420); // move mouse point to specific location
        robot.delay(4000);        // delay is to make code wait for mentioned milliseconds before executing next step
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click
        robot.delay(5000);

        robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button

        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public static void FileDownloadsuccessPopup(WebDriver driver) throws AWTException, InterruptedException
    {
        Robot bot = new Robot();

        bot.keyPress(KeyEvent.VK_CONTROL);
        bot.keyPress(KeyEvent.VK_J);
        bot.keyRelease(KeyEvent.VK_CONTROL);
        bot.keyRelease(KeyEvent.VK_J);
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
        }
    }

    //code to handle drop down feature
    public static void DropDownMenu(WebDriver driver,String value)
    {
        WebElement WebEle;
        Actions act1= new Actions(driver);
        new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'k-popup k-child-animation-container')]"))));

        // to fetch the web element of the modal container
        WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
        List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li/span"));
        for(int i=0;i<=Options.size()-1;i++)
        {
            WebEle=Options.get(i);
            act1.moveToElement(WebEle).build().perform();
            String Opt=WebEle.getText();
            if(Opt.equals(value))
            {
                act1.moveToElement(WebEle).build().perform();
                act1.click(WebEle).build().perform();
                break;
            }
            else
            {
                act1.moveToElement(WebEle).sendKeys(Keys.ARROW_DOWN).build().perform();
                if(IsExists("//div[@class='loader']",driver))
                {
                    WebEle=FindByElement(driver,"xpath","//div[@class='loader']");
                    waitTillLoadingWheelDisappears(driver, WebEle, 1000000);//60000
                }
            }
        }
    }

    public static void DropDownMenu_withOutScrollbar(WebDriver driver,String value)
    {
        WebElement WebEle=null;
        Actions act1= new Actions(driver);
        HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",40);
        // to fetch the web element of the modal container
        WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]");
        List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li/span"));
        for(int i=0;i<=Options.size()-1;i++)
        {
            WebEle = Options.get(i);
            act1.moveToElement(WebEle).build().perform();
            String Opt = WebEle.getText();
            if (Opt.equals(value))
            {
                act1.moveToElement(WebEle).build().perform();
                act1.click(WebEle).build().perform();
                break;
            }
        }
    }

    public static void DropDownMenu_LowerCase(WebDriver driver,String value) throws InterruptedException
    {
        WebElement WebEle=null;
        Actions act1= new Actions(driver);
        String Opt=null;
        String Opt1=null;
        String Opt2=null;
        Opt1= value.toLowerCase();
        // to fetch the web element of the modal container
        WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
        List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li/span"));
        for(WebElement option: Options)
        {
            act1.moveToElement(option).build().perform();
            Opt=option.getText();
            Opt2=Opt.toLowerCase();
            if(Opt2.contains(Opt1))
            {
                act1.moveToElement(option).build().perform();
                act1.click(option).build().perform();
                break;
            }
        }
    }

    //Code for navigating from tab to tab
    public static void navigate_Horizantal_Tab(WebDriver driver, String MenuItem,String MenuItemLocator,String selector,String MenuItems)
    {
        Scenario scenario = null;
        boolean found=false;
        String Menu_Text=null;
        Actions act=new Actions(driver);
        List<WebElement> MenuBar=FindByElements(driver,selector,MenuItems);
        for(WebElement Menu:MenuBar)
        {
            act.moveToElement(Menu).build().perform();
            Menu_Text=Menu.getText();
            if(Menu_Text.equalsIgnoreCase(MenuItem))
            {
                WebElement menuItem=FindByElement(driver,selector,MenuItemLocator);
                JScriptClick(driver,menuItem,10000);
                found=true;
                break;
            }
        }
        String status=returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            waitTillLoadingPage(driver);
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

        status=returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            waitTillLoadingPage(driver);
        }

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
    }

    public static String gettingTitle(WebDriver driver)
    {
        String title=null;
        title=driver.getTitle();
        return title;
    }

    public static String gettingURL(WebDriver driver)
    {
        String url=null;
        url=driver.getCurrentUrl();
        return url;
    }

    /*For clearing input box*/
    public static void clearText(WebDriver driver,WebElement element,int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    /*Send key with wait method*/
    public static void sendKeys(WebDriver driver,WebElement element,int timeOut,String value)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    /*For clicking any button*/
    public static void clickOn(WebDriver driver,WebElement element,int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /*For selecting some option from list of options*/
    public static void SelectingOption(WebDriver driver,WebElement element,int timeOut,String text_option) throws InterruptedException
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        List<WebElement> options =element.findElements(By.tagName("li"));
        for (WebElement option : options)
        {
            if (option.getText().contains(text_option))
            {
                option.click();
                break;
            }
        }
    }

    /*Wait till visiblity of element*/
    public static boolean waitTillElementDisplayed(WebDriver driver,WebElement element,int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    /*Wait till Visiblity of element located at*/
    public static boolean waitTillElementLocatedDisplayed(WebDriver driver,String selector,String val,int timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
        if (selector.equalsIgnoreCase("id"))
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(val)));
        } else if (selector.equalsIgnoreCase("class")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(val)));
        } else if (selector.equalsIgnoreCase("xpath")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(val)));
        } else if (selector.equalsIgnoreCase("cssselector")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(val)));
        } else if (selector.equalsIgnoreCase("linktext")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(val)));
        } else if (selector.equalsIgnoreCase("partiallinkedtext")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(val)));
        } else if (selector.equalsIgnoreCase("tagname")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(val)));
        }
        return true;
    }

    public static boolean waitTillTitleContains(WebDriver driver, String title, int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.titleIs(title));
        return true;
    }

    public static boolean waitTillPageLoaded(WebDriver driver,int timeOut)
    {
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
        return true;
    }

    public static boolean waitTillLoadingWheelDisappears(WebDriver driver,WebElement element,int timeOut)
    {
        new WebDriverWait(driver,Duration.ofMillis(timeOut)).until(ExpectedConditions.invisibilityOf(element));
        return true;
    }

    //Code to handle page load issues. Method that can be used when java scripts are still running behind and not letting automation code to execute
    public static boolean waitTillLoadingPage(WebDriver driver)
    {
        String pageLoadStatus="";
        boolean pageWasLoaded=false;
        do
        {
            try
            {
                pageLoadStatus=returnDocumentStatus(driver);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            if(pageLoadStatus.equals("complete"))// || pageLoadStatus.equals("interactive"))
            {
                pageWasLoaded=true;
            }
        }while(!pageWasLoaded);
        return pageWasLoaded;
    }

    public static String returnDocumentStatus(WebDriver driver)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return (String) js.executeScript("return document.readyState");
    }

    //**********************************************GENERIC METHODS FOR OMS AND DSD************************************
    //Code for AddFilterSearch for DSD and OMS applications
    public static void AddFilterSearch(WebDriver driver,String SearchBoxValue,String SearhBox2Value) throws InterruptedException
    {
        WebElement Search2;
        WebElement WebEle;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);//80000
        }
        String status=HelpersMethod.returnDocumentStatus(driver);
        if(status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        //Click on Add filter button
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")));
        driver.findElement(By.xpath("//button/descendant::span[contains(text(),'Add filter')]")).click();

        waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]",80000);
        WebElement modalContainer1=FindByElement(driver,"xpath","//div[contains(@class,'k-animation-container k-animation-container-relative k-animation-container-shown')]");

        //Click on Clear all button
        WebElement Clear=modalContainer1.findElement(By.xpath(".//button/span[contains(text(),'Clear all')]"));
        if(Clear.isEnabled())
        {
            Clear.click();
        }

        WebElement Search1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
        ActSendKey(driver,Search1,1000,SearchBoxValue);
        //Click on Check box
        new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[contains(@class,'k-checkbox')]")));
        WebElement WebEle1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
        ClickBut(driver,WebEle1,1000);

        //Identify radio button and click on Radio button
        new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
        new WebDriverWait(driver,Duration.ofMillis(80000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
        if(IsExists("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]",driver))
        {
            WebElement RadioPop=FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
            Search2=RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            EnterText(driver,Search2,10000,SearhBox2Value);

            //Click on Apply button
            Clear =RadioPop.findElement(By.xpath(".//button/span[text()='Apply']"));
            ClickBut(driver,Clear,1000);
        }
        else
        {
            if(IsExists("//div[contains(@class,'k-animation-container')]/descendant::input[contains(@class,'k-textbox')]",driver))
            {
                WebElement modalContainer=driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]"));
                Search2=modalContainer.findElement(By.xpath(".//input[contains(@class,'k-textbox')]"));
                EnterText(driver, Search2, 1000, SearhBox2Value);

                //Click on Apply button
                Clear = Search2.findElement(By.xpath(".//button/span[text()='Apply']"));
                ClickBut(driver,Clear,1000);
                //loading Icon
                if (IsExists("//div[@class='loader']", driver))
                {
                    WebEle = FindByElement(driver, "xpath", "//div[@class='loader']");
                    waitTillLoadingWheelDisappears(driver, WebEle, 1000000);//200000
                }
            }
        }
    }

    //This part of code can be used when Add filter button need to be used and it is part of any popup
    public static void AddFilterSearch_Popup(WebDriver driver,String SearchBoxValue,String SearhBox2Value) throws InterruptedException
    {
        WebElement Search2;
        WebElement WebEle;
        WebElement Clear;

        //Click on Add filter, and Passing parameter to add filter drop downs
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(8000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Add filter')]")));
        driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Add filter')]")).click();
        new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-animation-container k-animation-container-shown']")));

        WebElement modalContainer1 = FindByElement(driver, "xpath", "//div[@class='k-animation-container k-animation-container-shown']");
        if(HelpersMethod.IsExists("//div[@class='k-child-animation-container']/descendant::div[@class='i-filter-popup i-filter-popup--add']",driver))
        {
            //Click on Clear all button
            if (!IsExists("//div[@class='k-animation-container k-animation-container-shown']/descendant::button/span[contains(@class,'k-button k-button-md k-button-flat k-button-flat-primary k-rounded-md k-disabled i-filter-popup__footer__button i-primary')]/span[contains(text(),'Clear all')]",driver))
            {
                Clear = driver.findElement(By.xpath("//div[@class='k-animation-container k-animation-container-shown']/descendant::button/span[contains(text(),'Clear all')]"));
                Clear.click();
                driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]/descendant::button/span[contains(text(),'Add filter')]")).click();
            }
        }

        WebElement Search1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'i-search-box__input')]"));
        ActSendKey(driver,Search1,10000,SearchBoxValue);
        //Click on Check box
        new WebDriverWait(driver,Duration.ofMillis(40000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[contains(@class,'k-checkbox')]")));
        WebElement WebEle1=modalContainer1.findElement(By.xpath(".//input[contains(@class,'k-checkbox')]"));
        ClickBut(driver,WebEle1,10000);

        //Identify radio button and click on Radio button
        new WebDriverWait(driver,Duration.ofMillis(100000)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]")));
        waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]",80000);
        if(IsExists("//div[contains(@class,'i-btn-radio filter-radio')]/ancestor::div[contains(@class,'k-child-animation-container')]",driver))
        {
            WebElement RadioPop=FindByElement(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::form[contains(@class,'i-filter-popup')]");
            Search2=RadioPop.findElement(By.xpath(".//div[contains(@class,'i-btn-radio filter-radio')][1]/following-sibling::div[contains(@class,'k-textbox-container i-filter-popup__content__input')]/input"));
            EnterText(driver,Search2,10000,SearhBox2Value);

            //Click on Apply button
            Clear =RadioPop.findElement(By.xpath(".//button/span[text()='Apply']"));
            ClickBut(driver,Clear,10000);
        }
        else
        {
            if(IsExists("//div[contains(@class,'k-animation-container')]/descendant::input[contains(@class,'k-textbox')]",driver))
            {
                WebElement modalContainer=driver.findElement(By.xpath("//div[contains(@class,'k-animation-container')]"));
                Search2=modalContainer.findElement(By.xpath(".//input[contains(@class,'k-textbox')]"));
                EnterText(driver, Search2, 10000, SearhBox2Value);

                //Click on Apply button
                Clear = Search2.findElement(By.xpath(".//button/span[text()='Apply']"));
                ClickBut(driver,Clear,10000);
                //loading Icon
                if (IsExists("//div[@class='loader']", driver))
                {
                    WebEle = FindByElement(driver, "xpath", "//div[@class='loader']");
                    waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
            }
        }
    }


    //************************************Code for DSD and OMS applications****************************************
    //Index Field Icon in Order entry, in other pages xpath is different for index field
    public static void Click_On_IndexFieldIcon(WebDriver driver,String Search1_Value,String Search2_Value) throws InterruptedException
    {
        //To handle AddFilter button in the Index field popup
        HelpersMethod.AddFilterSearch_Popup(driver,Search1_Value,Search2_Value);

        //click on the table row after filter
        HelpersMethod.JScriptClick(driver,driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]/descendant::tr[contains(@class,'k-master-row')]")),10000);
        Thread.sleep(4000);
    }
}