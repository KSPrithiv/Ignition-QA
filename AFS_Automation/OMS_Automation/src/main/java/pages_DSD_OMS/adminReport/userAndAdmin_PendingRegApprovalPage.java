package pages_DSD_OMS.adminReport;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

        @FindBy(id="CPUsersPendingRegistrationsConfirmation")
        private WebElement pendingReg;

        @FindBy(xpath="//button[text()='Deny']")
        private WebElement denyButton;

        @FindBy(xpath="//button[text()='Confirm']")
        private WebElement confirmButton;

        public userAndAdmin_PendingRegApprovalPage(WebDriver driver,Scenario scenario)
        {
            this.driver=driver;
            this.scenario=scenario;
            PageFactory.initElements(driver,this);
        }

        public void clickOnPendingRegDropDown()
        {
            try
            {
                HelpersMethod.ActClick(driver,pendingReg,60);
            }
            catch (Exception e){}
        }

        public void selectUserPendingReg()
        {
            try
            {
                WebElement WebEle=null;
                String Opt=null;
                Actions act1= new Actions(driver);
                HelpersMethod.waitTillElementLocatedDisplayed(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]",40);
                // to fetch the web element of the modal container
                WebElement menuContainer = HelpersMethod.FindByElement(driver,"xpath","//div[contains(@class,'k-popup k-child-animation-container')]");
                List<WebElement> Options=menuContainer.findElements (By.xpath(".//ul/li"));
                for(int i=0;i<=Options.size()-1;i++)
                {
                    WebEle = Options.get(i);
                    act1.moveToElement(WebEle).build().perform();
                    Opt = WebEle.getText();
                    if (i == 0)
                    {
                        act1.moveToElement(WebEle).build().perform();
                        act1.click(WebEle).build().perform();
                        break;
                    }
                }
                scenario.log("USER SELECTED FROM DROP DOWN "+Opt);
            }
            catch (Exception e){}
        }


    public void clickOnDeny()
    {
        try
        {
            HelpersMethod.ClickBut(driver,denyButton,100);
            if(HelpersMethod.IsExists("//div[contains(text(),'This will delete the user.')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Pending Registration Approval", "Verify Title message");
                WebElement yesButton = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                HelpersMethod.ClickBut(driver, yesButton, 100);
                scenario.log("PENDING REGISTRATION APPROVAL DENEY");
                if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                {
                    WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                    HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 10000);
                }

            }

        }
        catch (Exception e){}
    }

    public void clickOnConfirm()
    {
        exists=false;
        try
        {
            if(confirmButton.isDisplayed()&&confirmButton.isEnabled())
            {
                HelpersMethod.ClickBut(driver, confirmButton, 100);
                if (HelpersMethod.IsExists("//div[contains(text(),'Pending Registration Approval')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]", driver))
                {
                    WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                    // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                    WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                    Assert.assertEquals(modalContentTitle.getText(), "Pending Registration Approval", "Verify Title message");
                    WebElement yesButton = modalContainer.findElement(By.xpath(".//button[text()='Yes']"));
                    HelpersMethod.ClickBut(driver, yesButton, 100);
                    if(HelpersMethod.IsExists("//div[@class='loader']",driver))
                    {
                        WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                        HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 4000);
                    }

                    scenario.log("PENDING REGISTRATION APPROVAL");
                    exists = true;
                }
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
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebElement WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 8000);
            }
            if(HelpersMethod.IsExists("//div[contains(text(),'Delete Account')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Delete Account", "Verify Title message");
                WebElement okButton=modalContainer.findElement(By.xpath(".//button[text()='OK']"));
                HelpersMethod.ClickBut(driver,okButton,100);
                exists=true;
                scenario.log("PENDING REGISTRATION DENYED AND ACCOUNT DELETED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void updateUserInfo()
    {
        try
        {
            if(HelpersMethod.IsExists("//div[contains(text(),'Update User Info')]/ancestor::div[contains(@class,'k-widget k-window k-dialog')]",driver))
            {
                WebElement modalContainer = driver.findElement(By.xpath("//div[contains(@class,'k-widget k-window k-dialog')]"));

                // to fetch the web elements of the modal content and interact with them, code to fetch content of modal title and verify it
                WebElement modalContentTitle = modalContainer.findElement(By.xpath(".//div[contains(@class,'k-window-title k-dialog-title')]"));
                Assert.assertEquals(modalContentTitle.getText(), "Update User Info", "Verify Title message");
                WebElement okButton=modalContainer.findElement(By.xpath(".//button[text()='OK']"));
                HelpersMethod.ClickBut(driver,okButton,100);
                exists=true;
                scenario.log("USER INFO HAS BEEN SUCESSFULLY UPDATEDss");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}
