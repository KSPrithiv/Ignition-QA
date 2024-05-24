package pages_DSD_OMS.UserManagementClientSide;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class PendingRegistrationClientPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="userPendingRegistrationsField")
    private WebElement selectUserDrop;

    @FindBy(id="cancelEditButton")
    private WebElement denyButton;

    @FindBy(id="saveEditButton")
    private WebElement confirmButton;

    public PendingRegistrationClientPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void validatePendingRegistrationPage()
    {
        exists = false;
        try
        {
            if(HelpersMethod.IsExists("//div[@id='usersPendingRegistrationsConfirmationControl']",driver))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e) {}
    }

    public void clickOnSelectUserDropDown()
    {
        exists=false;
        try
        {
            //WebElement selectUserDrop=HelpersMethod.FindByElement(driver,"id","userPendingRegistrationsField");
            if(selectUserDrop.isDisplayed() && selectUserDrop.isEnabled())
            {
                HelpersMethod.ClickBut(driver,selectUserDrop,10000);
                exists=true;
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-list-container')]/descendant::ul/li")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectUserfromDropDown()
    {
        exists=false;
        Actions act=new Actions(driver);
        String userNameSelect=null;
        try
        {
            if (HelpersMethod.IsExists("//div[contains(@class,'k-list-container')]/descendant::ul/li", driver))
            {
               List<WebElement> users=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-list-container')]/descendant::ul/li");
                for (WebElement user:users)
                {
                    act.moveToElement(user).build().perform();
                    userNameSelect=user.getText();
                    act.click(user).build().perform();
                    break;
                }
                if (HelpersMethod.IsExists("//div[@class='loader']", driver))
                {
                    WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 2000000);
                }
                if(HelpersMethod.FindByElement(driver,"xpath","//span[@id='userPendingRegistrationsField']/span[@class='k-input']").getText().equals(userNameSelect))
                {
                    exists=true;
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }

    public void clickDenyButton()
    {
        exists=false;
        try
        {
            if(denyButton.isDisplayed() && denyButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,denyButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void handleDenyConfirmationDialogBox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Pending registration approval')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement yesButton=modelContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                HelpersMethod.ActClick(driver,yesButton,10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }

    public void clickConfirmButton()
    {
        exists=false;
        try
        {
            if(confirmButton.isDisplayed() && confirmButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver,confirmButton,10000);
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void handleConfirmConfirmationDialogBox()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Pending registration approval')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modelContainer=HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-window k-dialog')]");
                WebElement yesButton=modelContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                HelpersMethod.ActClick(driver,yesButton,1000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(120))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }
}
