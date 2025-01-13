package stepDefination_DSD_OMS.WebOrderingPageSteps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.webOrdering.NavigationPage;
import util.TestBase;

public class NavigationPageStep
{
    WebDriver driver;
    Scenario scenario;

    static NavigationPage navigationPage;

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
        //navigationPage.WebOrderMenuItems1();
        //navigationPage.DisplayMenuTabInWebOrderMenu();
    }

    @And("User should Drag and drop Available apps item to Web order menu")
    public void userShouldDragAndDropAvailableAppsItemToWebOrderMenu()
    {
        navigationPage=new NavigationPage(driver,scenario);
        navigationPage.FromAvailableAppToWebOrder();
        navigationPage.WebOrderMenuItems();
    }

    @Then("User selects menu under web order menu label")
    public void userSelectsMenuUnderWebOrderMenuLabel()
    {
        navigationPage=new NavigationPage(driver,scenario);
        navigationPage.ValidateNavigation();
        navigationPage.selectLabelName();
    }

    @And("User changes the label name and verifies that label has been changed to new label name")
    public void userChangesTheLabelNameAndVerifiesThatLabelHasBeenChangedToNewLabelName()
    {
        navigationPage=new NavigationPage(driver,scenario);
        navigationPage.changeLabelName();
        navigationPage.verifyLabelValue();
    }

    @Then("User resets the label name to previous label")
    public void userResetsTheLabelNameToPreviousLabel()
    {
        navigationPage=new NavigationPage(driver,scenario);
        navigationPage.resetPreviousValue();
    }
}
