package pages_DSD_OMS.adminOrderEntry;

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

import java.time.Duration;
import java.util.List;

public class adminOrderEntryPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    public adminOrderEntryPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void navigateToOrderWorkflow()
    {
        try
        {
            String Menu_Text;
            Actions act=new Actions(driver);
            List<WebElement> MenuBar=HelpersMethod.FindByElements(driver,"xpath","//span[@class='k-link']");
            for(WebElement Menu:MenuBar)
            {
                act.moveToElement(Menu).build().perform();
                Menu_Text=Menu.getText();
                if(Menu_Text.equalsIgnoreCase("Order workflow"))
                {
                    WebElement menuItem=HelpersMethod.FindByElement(driver,"xpath","//span[@class='k-link']");
                    HelpersMethod.JScriptClick(driver,menuItem,10000);
                    break;
                }
            }
            String status=HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
               HelpersMethod.waitTillLoadingPage(driver);
            }

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));

            status=HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
               HelpersMethod.waitTillLoadingPage(driver);
            }

            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(600))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        }
        catch (Exception e){}
    }

    public void clickOnDefaultWorkFlow()
    {
        try
        {
            WebElement defaultWorkFlow=HelpersMethod.FindByElement(driver,"xpath","//span[@id='CPDefaultWorkFlowInOrderEntry']/descendant::button");
            HelpersMethod.ClickBut(driver,defaultWorkFlow,10000);
            new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@id,'CPDefaultWorkFlowInOrderEntry')]/li/span[@class='k-list-item-text']"))));
            new WebDriverWait(driver,Duration.ofMillis(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@id,'CPDefaultWorkFlowInOrderEntry')]/li/span[@class='k-list-item-text']")));
        }
        catch (Exception e){}
    }

    public void selectFromDefaultWorkFlow()
    {
        Actions act=new Actions(driver);
        String workFlowText;
        try
        {
            if(HelpersMethod.IsExists("//ul[contains(@id,'CPDefaultWorkFlowInOrderEntry')]/li/span[@class='k-list-item-text']",driver))
            {
                List<WebElement> defaultWorkFlows=HelpersMethod.FindByElements(driver,"xpath","//ul[contains(@id,'CPDefaultWorkFlowInOrderEntry')]/li/span[@class='k-list-item-text']");
                for(WebElement defaultWork:defaultWorkFlows)
                {
                    workFlowText=defaultWork.getText();
                    if(workFlowText.equalsIgnoreCase("None"))
                    {
                        act.moveToElement(defaultWork).build().perform();
                        act.click(defaultWork).build().perform();
                        break;
                    }
                }
            }
        }
        catch (Exception e){}
    }
}
