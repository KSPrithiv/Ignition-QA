package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import util.RandomValues;
import util.TestBase;

import java.text.ParseException;
import java.time.Duration;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class BlackoutAndCutoffPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String readBlackoutDate=null;
    static String readMessage=null;

    @FindBy(id="add-blackout-date")
    private WebElement AddButton;

    @FindBy(id="edit-blackout-date")
    private WebElement EditButton;

    @FindBy(id="delete-blackout-date")
    private WebElement DeleteButton;

    @FindBy(id="blackout-customers")
    private WebElement cutomerDropDown;

    public BlackoutAndCutoffPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void clickOnAddButton()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(160))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Thread.sleep(1000);
            if(HelpersMethod.IsExists("//button[@id='add-blackout-date']",driver))
            {
                HelpersMethod.ClickBut(driver,AddButton,20000);
                scenario.log("ADD BUTTON HAS BEEN CLICKED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateAddBlackoutDialogbox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='new-blackout-date-container']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                scenario.log("BLACKOUT DIALOG HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectDateForBlackout()
    {
        exists=false;
        try
        {
            WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement calenderButton=modelContainer.findElement(By.xpath(".//a[@class='k-select']"));
            HelpersMethod.ActClick(driver,calenderButton,10000);

            //verify existence of calender and select date
            if(HelpersMethod.IsExists("//div[contains(@class,'k-widget k-calendar k-calendar-infinite')]",driver))
            {
                WebElement blackOutDate= HelpersMethod.FindByElement(driver,"xpath","//td[contains(@class,'k-calendar-td k-state-pending-focus')]");
                HelpersMethod.ClickBut(driver,blackOutDate,10000);
                //read blackout date
                WebElement readDate=HelpersMethod.FindByElement(driver,"id","new-blackout-date");
                readBlackoutDate=HelpersMethod.AttributeValue(readDate,"value");
                scenario.log("BLACKOUT DATES FOUND IS: "+readBlackoutDate);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void noOfDaysWarning()
    {
        exists=false;
        try
        {
            WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement daysWarning=modelContainer.findElement(By.xpath(".//input[@id='new-blackout-days-before-cutoff']"));
            HelpersMethod.EnterText(driver,daysWarning,10000,"2");
            //reading number of days warning
            WebElement warningDays=HelpersMethod.FindByElement(driver,"id","new-blackout-days-before-cutoff");
            String readDays=HelpersMethod.AttributeValue(warningDays,"value");
            scenario.log("BLACKOUT DAYS FOUND IS: "+readDays);
            if("2".equals(readDays))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void blackoutMessage()
    {
        exists=false;
        try
        {
            WebElement modelContainer= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement messageBlackout=modelContainer.findElement(By.xpath(".//textarea[@id='new-blackout-message']"));
            String mesageForBlackout= RandomValues.generateRandomString(100);
            HelpersMethod.EnterText(driver,messageBlackout,10000,mesageForBlackout);
            //read message entered
            WebElement warningMessage=HelpersMethod.FindByElement(driver,"id","new-blackout-message");
            readMessage=warningMessage.getText();
            scenario.log("BLACKOUT MESSAGE FOUND IS: "+readMessage);
            if(mesageForBlackout.equalsIgnoreCase(readMessage))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickSaveButton()
    {
        try
        {
            WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement saveButton=modelContainer.findElement(By.xpath(".//button[text()='Save']"));
            HelpersMethod.ClickBut(driver,saveButton,10000);
            scenario.log("BLACKOUTS DATE HAS BEEN EDITED");
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
        }
        catch (Exception e){}
    }

    public void validateBlackoutCutoff()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='blackout-dates']",driver))
            {
                scenario.log("BLACKOUTS AND CUTOFFS HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void saveConfirmationPopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            if(HelpersMethod.IsExists("//div[@id='dialogTextContent']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modelcontainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
                WebElement okButton=modelcontainer.findElement(By.xpath(".//button[contains(@id,'QuestionModalButton')]"));
                HelpersMethod.ClickBut(driver,okButton,6000);
                scenario.log("BLACKOUTS AND CUTOFFS HAS BEEN SAVED");
                exists=true;
            }
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectBlackOutDateFromGrid() throws ParseException
    {
        exists=false;
        String messageText=null;
        Actions act=new Actions(driver);
        int i=0;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            List<WebElement> messages=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/td[2]");
            for(WebElement message:messages)
            {
                i++;
                act.moveToElement(message).build().perform();
                messageText=message.getText();
                if(messageText.equals(readMessage))
                {
                    WebElement rowBlackout=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+i+"]");
                    act.moveToElement(rowBlackout).build().perform();
                    act.click().build().perform();
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void clickOnEditButton()
    {
        exists=false;
        try
        {
            if(EditButton.isDisplayed() && EditButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,EditButton,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateEditBlackoutDialog()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='new-blackout-date-container']/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void editBalckoutDetails()
    {
        exists=false;
        try
        {
            WebElement modelContainer= HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]");
            WebElement messageBlackout=modelContainer.findElement(By.xpath(".//textarea[@id='new-blackout-message']"));
            String mesageForBlackout= RandomValues.generateRandomString(100);
            HelpersMethod.clearText(driver,messageBlackout,1000);
            HelpersMethod.EnterText(driver,messageBlackout,1000,mesageForBlackout);
            //read message entered
            WebElement warningMessage=HelpersMethod.FindByElement(driver,"id","new-blackout-message");
            readMessage=warningMessage.getText();
            scenario.log("BLACKOUT MESSAGE FOUND IS: "+readMessage);
            if(mesageForBlackout.equalsIgnoreCase(readMessage))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnDeleteButton()
    {
        exists=false;
        try
        {
            if(DeleteButton.isDisplayed() && DeleteButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,DeleteButton,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateDeleteDialogBox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Confirm delete')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnOkButton()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Confirm delete')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ClickBut(driver,okButton,1000);
                scenario.log("BLACKOUTS DATE HAS BEEN DELETED");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void confirmDeletePopup()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'The information has been saved successfully.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement okButton=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-widget k-window k-dialog')]/descendant::button[text()='OK']");
                HelpersMethod.ClickBut(driver,okButton,1000);
                exists=true;
            }
        }
        catch (Exception e){}
    }

    public void selectBlackOutDateForDeleteFromGrid()
    {
        exists=false;
        String messageText=null;
        Actions act=new Actions(driver);
        int i=0;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            List<WebElement> messages=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/td[2]");
            for(WebElement message:messages)
            {
                i++;
                act.moveToElement(message).build().perform();
                messageText=message.getText();
                if(messageText.equals(readMessage))
                {
                    WebElement rowBlackout=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+i+"]");
                    act.moveToElement(rowBlackout).build().perform();
                    act.click().build().perform();
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    public void clickOnCustomerSelectionDropDown()
    {
        exists=false;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            if(cutomerDropDown.isDisplayed() && cutomerDropDown.isEnabled())
            {
                HelpersMethod.ClickBut(driver,cutomerDropDown,1000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }


    public void selectCustomerFromDropDown()
    {
        exists=false;
        String compText=null;
        String status=null;
        WebElement WebEle;
        Actions act=new Actions(driver);
        try
        {
            String companyName= TestBase.testEnvironment.FullAcc();
            List<WebElement> companies= HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
            for (WebElement company : companies)
            {
                act.moveToElement(company).build().perform();
                compText = company.getText();
                if (compText.equalsIgnoreCase(companyName) || compText.contains(companyName))
                {
                    act.moveToElement(company).build().perform();
                    act.click(company).build().perform();
                    scenario.log("COMPANY HAS BEEN SELECTED");
                    exists = true;
                    break;
                }
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000000);
            }
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(160))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectBlackOutDateForDeleteFromGridForCustomer()
    {
        exists=false;
        String messageText=null;
        Actions act=new Actions(driver);
        int i=0;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
        }
        try
        {
            List<WebElement> messages=HelpersMethod.FindByElements(driver,"xpath","//tr[contains(@class,'k-master-row')]/td[2]");
            for(WebElement message:messages)
            {
                i++;
                act.moveToElement(message).build().perform();
                messageText=message.getText();
                if(messageText.equals(readMessage))
                {
                    WebElement rowBlackout=HelpersMethod.FindByElement(driver,"xpath","//tr[contains(@class,'k-master-row')]["+i+"]");
                    act.moveToElement(rowBlackout).build().perform();
                    act.click().build().perform();
                    act.moveToElement(rowBlackout).build().perform();
                    act.click().build().perform();
                    break;
                }
            }
        }
        catch (Exception e){}
    }
}
