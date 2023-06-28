package pages_DSD_OMS.inventory;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages_DSD_OMS.login.HomePage;

import java.util.List;

public class InventoryPage
{
    WebDriver driver;
    Scenario scenario;
    static String currentURL;
    static boolean exists=false;

    @FindBy(xpath="//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]")
    private WebElement To;


    public InventoryPage(WebDriver driver, Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void HandleError_Page()
    {
        try {
            String URL = HelpersMethod.gettingURL(driver);
            if (URL.contains("cpError")) {
                HelpersMethod.NavigateBack(driver);
                URL = HelpersMethod.gettingURL(driver);
            }
            if (HelpersMethod.gettingURL(driver).contains("CPAdmin"))
            {
                HomePage homepage = new HomePage(driver, scenario);
                homepage.navigateToClientSide();
                NavigateToInventory();
            }
        }
        catch (Exception e) {}
    }

    public void Refresh_Page()
    {
        driver.navigate().to(currentURL);
        if (HelpersMethod.IsExists("//div[@class='loader']", driver))
        {
            WebElement WebEle = HelpersMethod.FindByElement(driver, "xpath", "//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 1000);
        }
    }

    public void NavigateToInventory()
    {
        exists=false;
        String Header=null;
        WebElement WebEle;
        try
        {
            if(HelpersMethod.IsExists("//div[@class='loader']",driver))
            {
                WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
                HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 400);
            }

            Header=HelpersMethod.FindByElement(driver,"xpath","//div[@class='topHeaderRow row']/descendant::span").getText();
            Assert.assertEquals(Header,"Inventory");
        }
        catch (Exception e){}
    }

    public boolean ValidateInventory()
    {
        exists=false;
        WebElement WebEle=null;
        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 800);
        }
        try
        {
            if(HelpersMethod.gettingURL(driver).contains("cpInventory"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return exists;
    }

    public void DragAndDropInInventory(String To_Text)
    {
        exists = false;
        try
        {
            WebElement ProdGrid = HelpersMethod.FindByElement(driver, "id", "store-inventory-grid-wrapper");
            HelpersMethod.ScrollElement(driver, ProdGrid);
            if (HelpersMethod.IsExists("//div[contains(@class,'k-grouping-header')]/descendant::div[contains(@class,'k-indicator-container')]", driver))
            {
                List<WebElement> TableHeads = driver.findElements(By.xpath("//thead/tr[1]/th"));
                for (WebElement THead : TableHeads)
                {
                    String Head = THead.getText();
                    if (Head.equals(To_Text))
                    {
                        HelpersMethod.ActDragDrop(driver, THead, To);
                        exists = true;
                    }
                }
            }
            else
            {
                scenario.log("DRAG AND DROP HEADER MAY NOT BE ENABLED, CHECK ADMIN SETTINGS");
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e) {}
    }

    public void readGroupingValue()
    {
        try
        {
            List<WebElement> groups=HelpersMethod.FindByElements(driver,"xpath","//tr[@class='k-grouping-row']/td[1]/span");
            for(WebElement group:groups)
            {
                scenario.log("GROUP VALUE IS "+group.getText());
            }
        }
        catch (Exception e){}
    }
}
