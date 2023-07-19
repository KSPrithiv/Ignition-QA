package stepDefination_DSD_OMS.ThemeBuilderStepDef;

import helper.HelpersMethod;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages_DSD_OMS.CRMPage.CRMPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.themeBuilderPage.Phase2ThemeBuilderPage;
import pages_DSD_OMS.themeBuilderPage.ThemeBuilderPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;
import java.awt.*;

public class Phase2ThemeBuilderStepDef {
    WebDriver driver;
    Scenario scenario;
    LoginPage loginpage;
    HomePage homepage;
    AdminHomePage adminHomePage;

    ThemeBuilderPage themeBuilderPage;
    Phase2ThemeBuilderPage phase2ThemeBuilderPage;
    CRMPage crmPage;

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }


    @When("Enter correct Admin username and password")
    public void enterCorrectAdminUsernameAndPassword() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        loginpage.ClickSignin();

    }
    @Then("Admin Page is open successfully")
    public void adminPageIsOpenSuccessfully() throws InterruptedException {
        homepage = new HomePage(driver,scenario);
        homepage.VerifyHomePage();
        Thread.sleep(3000);
        //HelpersMethod.Implicitwait(driver, 60);
    }
    @When("User click on permission by dropdown")
    public void userClickOnPermissionByDropdown() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.permissionByDD();
        HelpersMethod.Implicitwait(driver, 40);
    }
    @And("Select any company from dropdown")
    public void selectAnyCompanyFromDropdown() throws InterruptedException {
        System.out.println("company selected above step only");
        adminHomePage=new AdminHomePage(driver,scenario);
        adminHomePage.SelectCompany();
        /*phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.selectAnyCompany();
        Thread.sleep(15000);*/
    }
    @Then("User click on the General settings tab")
    public void userClickOnTheGeneralSettingsTab() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        themeBuilderPage=new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.ClickOnGSHumburger();
        //phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        //phase2ThemeBuilderPage.clickGeneralSettings();
        //Thread.sleep(15000);
    }

    @And("User click on the Branding Option under general settings")
    public void userClickOnTheBrandingOptionUnderGeneralSettings() throws InterruptedException {
        themeBuilderPage=new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.ClickOnThemeBuilder();
    }

    @Then("User click on left side icon of login card position")
    public void userClickOnLeftSideIconOfLoginCardPosition() throws InterruptedException {
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.loginCardPositionLeft();
    }

    @And("click on save button")
    public void clickOnSaveButton() throws InterruptedException {
        themeBuilderPage=new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.saveChanges();
    }

    @Then("Logout from admin")
    public void logoutFromAdmin() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();
    }
    @And("Login with Client credential and validate login page preview")
    public void loginWithClientCredentialAndValidateLoginPagePreview() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.password());
        loginpage.ClickSignin();
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.verifyPreviewOfLoginCardPosition();

    }
    @Then("Logout from Client")
    public void logoutFromClient() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();
    }
    @And("Validate login page should display the login box at left side of the screen")
    public void validateLoginPageShouldDisplayTheLoginBoxAtLeftSideOfTheScreen() {
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.verifyLoginPageAtLeftSide();

    }

    @Then("User click on center side icon of login card position")
    public void userClickOnCenterSideIconOfLoginCardPosition() throws InterruptedException {
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.loginCardPositionCenter();
    }

    @And("Validate login page should display the login box at center side of the screen")
    public void validateLoginPageShouldDisplayTheLoginBoxAtCenterSideOfTheScreen() {
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.verifyLoginPageAtCenterSide();
    }

    @Then("User click on right side icon of login card position")
    public void userClickOnRightSideIconOfLoginCardPosition() throws InterruptedException {
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.loginCardPositionRight();
    }

    @And("Validate login page should display the login box at right side of the screen")
    public void validateLoginPageShouldDisplayTheLoginBoxAtRightSideOfTheScreen() {
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.verifyLoginPageAtRightSide();
    }
    @Then("User Enter title value in the title text box")
    public void userEnterTitleValueInTheTitleTextBox() throws InterruptedException {
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.EnterTitleInTitleBox();
        /*themeBuilderPage=new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.saveChanges();
        themeBuilderPage.clickToLogOut();*/
        
    }

    @And("Validate login page should display the same title on the page")
    public void validateLoginPageShouldDisplayTheSameTitleOnThePage() {
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.verifyLoginPageTitle();
    }

    @Then("Click on default theme radio button to select default theme")
    public void clickOnDefaultThemeRadioButtonToSelectDefaultTheme() {
        phase2ThemeBuilderPage=new Phase2ThemeBuilderPage(driver, scenario);
        phase2ThemeBuilderPage.selectDefaultTheme();

    }

    @And("Validate login preview and click on save button")
    public void validateLoginPreviewAndClickOnSaveButton() throws InterruptedException {
        themeBuilderPage=new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.validatePreview();
        themeBuilderPage.saveChanges();
    }

    @And("Validate login page should display the default theme")
    public void validateLoginPageShouldDisplayTheDefaultTheme() {

    }
}
