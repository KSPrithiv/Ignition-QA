package pages_DSD_OMS.generalSettingsPage;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class GeneralSettingsPage {
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    public GeneralSettingsPage(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
    }
    @BeforeMethod
    public void WaitForPage() {
        HelpersMethod.Implicitwait(driver, 10);
    }

    public void clickOnMasterPage(){
        try
        {
            exists = false;
            String status = HelpersMethod.returnDocumentStatus(driver);
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
            if (status.equals("loading"))
            {
                HelpersMethod.waitTillLoadingPage(driver);
            }
            HelpersMethod.WaitElementPresent(driver, "xpath", "//div[@class='item-searchbar']", 2400);
            WebElement Hamburger = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='item-searchbar']");
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.visibilityOf(Hamburger));
            new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.elementToBeClickable(Hamburger));
            HelpersMethod.JScriptClick(driver, Hamburger, 4000);
            exists = true;
            if (HelpersMethod.IsExists("//div[@class='loader']", driver))
            {
                new WebDriverWait(driver,Duration.ofMillis(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            }
        }
        catch (Exception e){}
    }
}
