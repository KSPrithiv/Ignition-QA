package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class NavigationPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String label=null;
    static String label1=null;
    static String labelNameText=null;

    @FindBy(xpath="//div[@id='AvailableItemsAdminCard']/descendant::div[contains(@class,'i-droppable-container')]")
    private WebElement AvailableApp;

    @FindBy(xpath="//div[@id='ActiveItemsAdminCard']/descendant::div[contains(@class,'i-droppable-container')]")
    private WebElement WebOrderMenu;

    @FindBy(xpath="//div[@id='ActiveItemDetailAdminCard']/descendant::label[text()='Label']/following-sibling::input")
    private WebElement labelInput;

    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement resetButton;

    //Action
    public NavigationPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }
    public void FromWebOrderToAvailableApp()
    {
        exists=false;
        Actions act=new Actions(driver);
        WebElement WebEle;
        int index;
        try
        {
            List<WebElement> MenuItems= HelpersMethod.FindByElements(driver,"xpath","//div[@id='ActiveItemsAdminCard']/descendant::div[@class='i-draggable-item']/div[contains(@class,'i-draggable-item__container')]");
            index= MenuItems.size()-1;
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@id='ActiveItemsAdminCard']/descendant::div[@class='i-draggable-item']["+index+"]/div[contains(@class,'i-draggable-item__container')]");
            //HelpersMethod.ActDragDrop(driver,WebEle,AvailableApp);
            act.clickAndHold(WebEle).moveToElement(AvailableApp).release().build().perform();
            exists=true;
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void FromAvailableAppToWebOrder()
    {
        exists=false;
        Actions act=new Actions(driver);
        WebElement fromElement;
        WebElement toElement=HelpersMethod.FindByElement(driver,"xpath","//div[@id='ActiveItemsAdminCard']/descendant::div[@class='i-droppable-container']");
        int index;
        try
        {

            List<WebElement> MenuItems= HelpersMethod.FindByElements(driver,"xpath","//div[@id='AvailableItemsAdminCard']/descendant::div[@class='i-draggable-item']/div[contains(@class,'i-draggable-item__container')]");
            if(MenuItems.size()==1)
            {
                index=1;
                fromElement = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='AvailableItemsAdminCard']/descendant::div[@class='i-draggable-item'][" + index + "]/div[contains(@class,'i-draggable-item__container')]");
                //HelpersMethod.ActDragDrop(driver, WebEle, WebOrderMenu);
                //METHOD1
                Actions builder = new Actions(driver);

                Action dragAndDrop = builder.clickAndHold(fromElement)
                        .moveToElement(toElement)
                        .release(toElement)
                        .build();
                dragAndDrop.perform();
                //METHOD2
              //  act.dragAndDrop(fromElement, toElement).build().perform();

                //METHOD3
           /*     final String java_script =
                        "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                                "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                                "ction(format,data){this.items[format]=data;this.types.append(for" +
                                "mat);},getData:function(format){return this.items[format];},clea" +
                                "rData:function(format){}};var emit=function(event,target){var ev" +
                                "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                                "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                                "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                                "'drop',tgt);emit('dragend',src);";

              //  ((JavascriptExecutor).getDriver()).executeScript(java_script, toElement, fromElement);
                Thread.sleep(2000);


                org.openqa.selenium.Point coordinates1 = toElement.getLocation();
                Point coordinates2 = fromElement.getLocation();
                Robot robot = new Robot();
                robot.mouseMove(coordinates1.getX(), coordinates1.getY());
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseMove(coordinates2.getX(), coordinates2.getY());
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                Thread.sleep(2000);*/


                exists = true;
            }
            else
            {
                index = MenuItems.size() - 1;
                fromElement = HelpersMethod.FindByElement(driver, "xpath", "//div[@id='AvailableItemsAdminCard']/descendant::div[@class='i-draggable-item'][" + index + "]/div[contains(@class,'i-draggable-item__container')]");
                HelpersMethod.ActDragDrop(driver, fromElement, toElement);
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void DisplayMenuTabInWebOrderMenu()
    {
        String MenuTab;
        try
        {
            List<WebElement> Menus= HelpersMethod.FindByElements(driver,"xpath","//div[@id='ActiveItemsAdminCard']/descendant::div[@class='i-draggable-item']/div[contains(@class,'i-draggable-item__container')]/descendant::div[@class='content']|//div[@id='ActiveItemsAdminCard']/descendant::div[@class='i-draggable-item']/div[contains(@class,'i-draggable-item__container')]/descendant::div[@class='content active']");
            scenario.log("WEBORDER MENU TABS FOUND ARE AS FOLLOWS:");
            for (WebElement Menu:Menus)
            {
                MenuTab=Menu.getText();
                scenario.log(MenuTab);
            }
        }
        catch (Exception e){}
    }

    public void ValidateNavigation()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[contains(@class,'spnmoduleNameHeader withoutBreadcrumbs') and contains(text(),'Navigation')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectLabelName()
    {
        try
        {
            //check box click
            WebElement checkBox=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-draggable-item'][1]/descendant::input");
            HelpersMethod.ClickBut(driver,checkBox,10000);
            //Read label value associated with check box
            label=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-draggable-item'][1]/descendant::div[@class='content active']").getText();
            scenario.log("LABEL SELECTED FOR CHANGING LABEL IS "+label);
        }
        catch (Exception e){}
    }

    public void changeLabelName()
    {
        exists=false;
        try
        {
            labelNameText=label+"_Test";
            HelpersMethod.ScrollElement(driver,labelInput);
            HelpersMethod.EnterText(driver,labelInput,10000,labelNameText);
            labelInput.sendKeys(Keys.ENTER);
            labelNameText=HelpersMethod.JSGetValueEle(driver,labelInput,10000);
            if(!label.equals(labelNameText))
            {
                scenario.log("NEW LABEL NAME GIVEN IS "+labelNameText);
                exists=true;
            }
            else
            {
                scenario.log("<span style='color:red'>STILL FINDING LABEL NAME AS "+label+"</span>");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void verifyLabelValue()
    {
        exists=false;
        try
        {
            label1=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-draggable-item'][1]/descendant::div[@class='content active']").getText();
            if(label1.equals(labelNameText))
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

    public void resetPreviousValue()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,resetButton,1000);
            label1=HelpersMethod.FindByElement(driver,"xpath","//div[@class='i-draggable-item'][1]/descendant::div[@class='content active']").getText();
            scenario.log("AFTER RESETTING THE VALUE LABEL IS CHANGED TO "+label1);
            if(label1.equals(label))
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
}