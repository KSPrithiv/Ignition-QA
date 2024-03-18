package pages_DSD_OMS.adminCatalogSearch;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @Project Divya.Ramadas@telusagcg.com
 * @Author Divya.Ramadas
 */
public class catalogSearchPage
{
    /* Created by Divya.Ramadas */
    WebDriver driver;
    Scenario scenario;


    public catalogSearchPage(WebDriver driver,Scenario scenario)
    {
        this.driver=driver;
        this.scenario=scenario;
        PageFactory.initElements(driver,this);
    }

    public void validateCatalogSearchPage()
    {

    }
}
