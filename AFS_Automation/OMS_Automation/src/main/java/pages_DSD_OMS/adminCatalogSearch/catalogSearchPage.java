package pages_DSD_OMS.adminCatalogSearch;

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
public class catalogSearchPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;

    @FindBy(id="CPCatalogSearchLayOut")
    private WebElement searchLayout;

    @FindBy(id="CPCatalogSearchDoNotAutoLoad")
    private WebElement doNotAutoLoad;

    public catalogSearchPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void validateCatalogSearchPage()
    {
        exists=false;
        try
        {
            if (HelpersMethod.IsExists("//div[@class='CPMyOrdersCatalogSearchForm']", driver))
            {
                scenario.log("USER IS ON CATALOG SEARCH");
                exists = true;
            }
            Assert.assertEquals(exists, true);
        }
        catch (Exception e){}
    }

    public void clickCatalogSearchLayout()
    {
        exists=false;
        try
        {
          if(searchLayout.isDisplayed())
          {
              HelpersMethod.ActClick(driver,searchLayout,10000);
              exists=true;
          }
          Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void selectCatalogSearchLayout(String search)
    {
        exists=false;
        Actions act=new Actions(driver);
        String searchText;
        try
        {
            new WebDriverWait(driver,Duration.ofMillis(2000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'k-child-animation-container')]/descendant::ul/li")));
            if(HelpersMethod.IsExists("//div[contains(@class,'k-child-animation-container')]/descendant::ul/li",driver))
            {
                List<WebElement> searchLayouts=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::ul/li");
                for(WebElement searchLayout:searchLayouts)
                {
                    act.moveToElement(searchLayout).build().perform();
                    searchText=searchLayout.getText();
                    if(searchText.equals(search))
                    {
                        act.moveToElement(searchLayout).build().perform();
                        act.click(searchLayout).build().perform();
                        exists=true;
                        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(120))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
                        break;
                    }
                }
                Assert.assertEquals(exists,true);
            }
        }
        catch (Exception e){}
    }

    public void doNotLoadFullCatalogAutomaticallyEnable()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//span[@id='CPCatalogSearchDoNotAutoLoad' and @aria-checked='true']",driver))
            {
                HelpersMethod.ActClick(driver,doNotAutoLoad,10000);
                Thread.sleep(1000);
            }
            if(HelpersMethod.IsExists("//span[@id='CPCatalogSearchDoNotAutoLoad' and @aria-checked='true']",driver))
            {
                scenario.log("DONOT AUTO LOAD PODUCT CATALOG ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void doNotLoadFullCatalogAutomaticallyDisable()
    {
        exists=false;
        try
        {
            if(!HelpersMethod.IsExists("//span[@id='CPCatalogSearchDoNotAutoLoad' and @aria-checked='false']",driver))
            {
                HelpersMethod.ActClick(driver,doNotAutoLoad,10000);
                Thread.sleep(1000);
            }
            if(HelpersMethod.IsExists("//span[@id='CPCatalogSearchDoNotAutoLoad' and @aria-checked='false']",driver))
            {
                scenario.log("DONOT AUTO LOAD PODUCT CATALOG DISABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void enableDoNotLoadFullCatalogAutomatically()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CPCatalogSearchDoNotAutoLoad' and @aria-checked='true']",driver))
            {
                scenario.log("DO NOT LOAD FULL CATALOG AUTOMATICALLY, IS ENABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void disableDoNotLoadFullCatalogAutomatically()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//span[@id='CPCatalogSearchDoNotAutoLoad' and @aria-checked='false']",driver))
            {
                scenario.log("DO NOT LOAD FULL CATALOG AUTOMATICALLY, IS DISABLED");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

}
