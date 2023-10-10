package pages_DSD_OMS.webOrdering;

import helper.HelpersMethod;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FeaturedProdSettingsPage
{
    /* Created by Divya.Ramadas@afsi.com */
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    static String MaxProd=null;
    static int IncreaseProd;
    static int DecreaseProd;

    @FindBy(xpath="//span[@id='CPFPMaxProductsToShow']/span[@class='k-input']")
    private WebElement MaxProducts;

    @FindBy(xpath="//span[@id='CPFPMaxProductsToShow']/descendant::span[contains(@class,'k-icon k-i-arrow-s')]")
    private WebElement DropDown;

    //Action
    public FeaturedProdSettingsPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void ValidateFeaturedProdSetting() throws InterruptedException
    {
        exists=false;
        String title=null;
        WebElement WebEle;
        String status=null;

        status=HelpersMethod.returnDocumentStatus(driver);
        if (status.equals("loading"))
        {
            HelpersMethod.waitTillLoadingPage(driver);
        }
        Thread.sleep(2000);
        // new WebDriverWait(driver,100).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'k-icon k-i-arrow-chevron-down i-header-toolbar-expandable-button__icon')]")));

        if(HelpersMethod.IsExists("//div[@class='loader']",driver))
        {
            WebEle=HelpersMethod.FindByElement(driver,"xpath","//div[@class='loader']");
            HelpersMethod.waitTillLoadingWheelDisappears(driver, WebEle, 100000);
        }
        try
        {
            title=driver.getTitle();
            if(title.contains("Admin"))
            {
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public int ReadingMaxProducts()
    {
        exists=false;
        try
        {
            MaxProd=MaxProducts.getText();
            if(!MaxProd.equals(null))
            {
                exists = true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
        return  Integer.parseInt(MaxProd);
    }

    public void ClickOnDropDown()
    {
        exists=false;
        try
        {
            HelpersMethod.ClickBut(driver,DropDown,1000);
        }
        catch (Exception e){}
    }

    public void SelectValueFromDropDown(int MaxVal)
    {
        exists=false;
        String ArrayText=null;
        int length;
        Actions act=new Actions(driver);
        try
        {
            List<WebElement> ArrayValues=HelpersMethod.FindByElements(driver,"xpath","//div[contains(@class,'k-child-animation-container')]/descendant::li");
            length=ArrayValues.size();
            if(!(MaxVal==length))
            {
                for(WebElement ArrayVal:ArrayValues)
                {
                    act.moveToElement(ArrayVal).build().perform();
                    ArrayText=ArrayVal.getText();
                    if(ArrayText.equals(Integer.toString(MaxVal)))
                    {
                        act.click(ArrayVal).build().perform();
                        exists=true;
                        break;
                    }
                }
            }
            else
            {
                scenario.log("MAXIMUM LIMIT OF MAX FEATURE PRODUCT HAS BEEN REACHED");
                exists=false;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public int IncreaseMaxProducts()
    {
        exists=false;
        try
        {
            IncreaseProd= Integer.parseInt(MaxProd)+1;
        }
        catch (Exception e){}
        return IncreaseProd;
    }

    public int DecreaseMaxProducts()
    {
        exists=false;
        try
        {
            DecreaseProd= Integer.parseInt(MaxProd)-1;
        }
        catch (Exception e){}
        return DecreaseProd;
    }

    public void SheildIconSelected()
    {
        exists=false;
        try
        {
            if(HelpersMethod.IsExists("//*[local-name()='svg' and contains(@class,'permission-container__icon')]//*[local-name()='path' and contains(@d,'777Z')]",driver))
            {
                scenario.log("FEATURE PRODUCTS SCHEILD ICON IS SELECTED");
                exists=true;
            }
            else
            {
                scenario.log("FEATURE PRODUCTS SHEILD ICON IS NOT SELECTED");
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }

    public void validateFeatureProd()
    {
        exists=false;
        try
        {
            if(HelpersMethod.FindByElement(driver,"xpath","//span[contains(@class,'spnmoduleNameHeader withoutBreadcrumbs')]").getText().equals("Featured Products"))
            {
                scenario.log("FEATURED PRODUCTS PAGE HAS BEEN FOUND");
                exists=true;
            }
            Assert.assertEquals(exists,true);
        }
        catch (Exception e){}
    }
}