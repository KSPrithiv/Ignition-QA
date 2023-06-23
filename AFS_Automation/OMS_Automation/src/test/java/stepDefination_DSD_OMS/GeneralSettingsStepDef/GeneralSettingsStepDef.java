package stepDefination_DSD_OMS.GeneralSettingsStepDef;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.themeBuilderPage.ThemeBuilderPage;
import util.TestBase;

public class GeneralSettingsStepDef {

    WebDriver driver;
    Scenario scenario;
    ThemeBuilderPage themeBuilderPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }

    @Then("User click on general settings menu")
    public void userClickOnGeneralSettingsMenu() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.ClickOnGSHumburger();
    }

    @And("Select Master Page option")
    public void selectMasterPageOption() {
        
    }

    @Then("Select and drag any value from Available app and drop inside Application menu")
    public void selectAndDragAnyValueFromAvailableAppAndDropInsideApplicationMenu() {
        
    }

    @And("Verify the dragged value is available in Application manu")
    public void verifyTheDraggedValueIsAvailableInApplicationManu() {
    }
}
