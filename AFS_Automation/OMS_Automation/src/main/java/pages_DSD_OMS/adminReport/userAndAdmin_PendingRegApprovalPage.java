package pages_DSD_OMS.adminReport;

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
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */
public class userAndAdmin_PendingRegApprovalPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String pendReg;

    @FindBy(xpath="//span[@id='CPUsersPendingRegistrationsConfirmation-accessibility-id']/following-sibling::button//*[local-name()='svg']")
    private WebElement pendingReg;

    @FindBy(xpath="//button/span[text()='Deny']")
    private WebElement denyButton;

    @FindBy(xpath="//button/span[text()='Confirm']")
    private WebElement confirmButton;

    public userAndAdmin_PendingRegApprovalPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void clickOnPendingRegDropDown()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(800))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            Thread.sleep(6000);
            if(pendingReg.isDisplayed() && pendingReg.isEnabled() )
            {
                HelpersMethod.ActClick(driver, pendingReg, 10000);
                exists = true;
            }
            else
            {
                scenario.log("THERE IS NO PENDING REGISTRATION FOUND");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectUserPendingReg()
    {
        exists=false;
        try
        {
            WebElement WebEle;
            Actions act1= new Actions(driver);
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("CPUsersPendingRegistrationsConfirmation-listbox-id"))));
            new WebDriverWait(driver,Duration.ofMillis(20000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("CPUsersPendingRegistrationsConfirmation-listbox-id")));

            //Find whether any Pending registration dropdown is there or not
            if(HelpersMethod.IsExistsById("embeddedMediumImportanceNofitication",driver))
            {
                scenario.log("*******************THERE ARE NO PENDING REGISTRATION AVAILABLE*****************");
                exists=true;
            }

            // to fetch the web element of the modal container
            List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='CPUsersPendingRegistrationsConfirmation-listbox-id']/li/span[@class='k-list-item-text']");
            for(int i=1;i<=Options.size()-1;i++)
            {
                WebEle = Options.get(i);
                act1.moveToElement(WebEle).build().perform();
                pendReg = WebEle.getText();
                if (i == 1)
                {
                    act1.moveToElement(WebEle).build().perform();
                    act1.click(WebEle).build().perform();
                    exists=true;
                    break;
                }
            }
            scenario.log("USER SELECTED FROM DROP DOWN "+pendingReg);
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnDeny()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(denyButton.isDisplayed() && denyButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, denyButton, 10000);
                exists = true;
                Thread.sleep(1000);
            }
              Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void clickOnConfirm()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(confirmButton.isDisplayed()&&confirmButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, confirmButton, 10000);
                exists = true;
                Thread.sleep(1000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void pendingReg() throws InterruptedException
    {
        try
        {
            if (HelpersMethod.IsExists("//span[contains(text(),'Pending Registration Approval')]/ancestor::div[contains(@class,'k-window k-dialog')]", driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Pending Registration Approval", "Verify Title message");
                WebElement yesButton = modalContainer.findElement(By.xpath(".//button/span[text()='Yes']"));
                HelpersMethod.ActClick(driver, yesButton, 10000);
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                scenario.log("PENDING REGISTRATION APPROVAL");
                exists = true;
                //Thread.sleep(4000);
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void confirmDelete()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'Delete Account')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Delete Account", "Verify Title message");
                WebElement okButton=modalContainer.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,20000);
                exists=true;
                scenario.log("PENDING REGISTRATION DENYED AND ACCOUNT DELETED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void updateUserInfo()
    {
        exists=false;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            if(HelpersMethod.IsExists("//span[contains(text(),'Update User Info')]/ancestor::div[contains(@class,'k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//span[contains(@class,'k-window-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Update User Info", "Verify Title message");
                WebElement okButton=modalContainer.findElement(By.xpath(".//button/span[text()='OK']"));
                HelpersMethod.ActClick(driver,okButton,10000);
                exists=true;
                scenario.log("USER INFO HAS BEEN SUCESSFULLY UPDATEDss");
                wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(600))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateTabNavigatedTo(String navigateTab)
    {
        exists=false;
        String tabValue;
        try
        {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            if(HelpersMethod.IsExists("//li[contains(@class,'k-active')]/span[@class='k-link']",driver))
            {
                tabValue=HelpersMethod.FindByElement(driver,"xpath","//li[contains(@class,'k-active')]/span[@class='k-link']").getText();
                if(tabValue.contains(navigateTab))
                {
                    scenario.log("NAVIGATED TO "+tabValue);
                    exists = true;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void findNotExistanceOfPendingRegistration()
    {
        try
        {
            String optText;
            Actions act1= new Actions(driver);
            HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-child-animation-container')]",10000);

            //Find whether any Pending registration dropdown is there or not
            if(HelpersMethod.IsExistsById("embeddedMediumImportanceNofitication",driver))
            {
                scenario.log("*******************THERE ARE NO PENDING REGISTRATION AVAILABLE*****************");
                exists=true;
            }

            // to fetch the web element of the modal container
            List<WebElement> Options=HelpersMethod.FindByElements(driver,"xpath","//ul[@id='CPUsersPendingRegistrationsConfirmation-listbox-id']/li/span[@class='k-list-item-text']");
            for(WebElement opt:Options)
            {
                act1.moveToElement(opt).build().perform();
                optText = opt.getText();
                if (!optText.equalsIgnoreCase(pendReg))
                {
                    act1.moveToElement(opt).build().perform();
                    act1.click(opt).build().perform();
                    exists=true;
                    break;
                }
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}