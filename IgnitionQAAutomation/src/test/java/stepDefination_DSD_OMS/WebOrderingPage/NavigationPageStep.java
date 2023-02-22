package stepDefination_DSD_OMS.WebOrderingPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;
import pages_DSD_OMS.webOrdering.NavigationPage;
import util.TestBase;

public class NavigationPageStep
{
    WebDriver driver;
    Scenario scenario;
    static boolean exists=false;
    NavigationPage navigationPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        TestBase driver1=TestBase.getInstanceOfDriver();
        driver= driver1.getDriver();
    }

    @Then("User should Drag and drop menu item from Web order menu to Available apps")
    public void userShouldDragAndDropMenuItemFromWebOrderMenuToAvailableApps()
    {
        navigationPage=new NavigationPage(driver,scenario);
        navigationPage.ValidateNavigation();
        navigationPage.FromWebOrderToAvailableApp();
        navigationPage.DisplayMenuTabInWebOrderMenu();
    }

    @And("User should Drag and drop Available apps item to Web order menu")
    public void userShouldDragAndDropAvailableAppsItemToWebOrderMenu()
    {
        navigationPage=new NavigationPage(driver,scenario);
        navigationPage.FromAvailableAppToWebOrder();
    }
}
