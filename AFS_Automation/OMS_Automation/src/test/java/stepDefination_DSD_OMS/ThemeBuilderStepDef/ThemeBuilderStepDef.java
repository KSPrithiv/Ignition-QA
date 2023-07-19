package stepDefination_DSD_OMS.ThemeBuilderStepDef;

import helper.HelpersMethod;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.Th;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_DSD_OMS.CRMPage.CRMPage;
import pages_DSD_OMS.login.HomePage;
import pages_DSD_OMS.login.LoginPage;
import pages_DSD_OMS.orderEntry.OrderEntryPage;
import pages_DSD_OMS.themeBuilderPage.ThemeBuilderPage;
import pages_DSD_OMS.webOrdering.AdminHomePage;
import util.TestBase;
import java.awt.*;

public class ThemeBuilderStepDef {

    WebDriver driver;
    Scenario scenario;
    LoginPage loginpage;
    HomePage homepage;
    ThemeBuilderPage themeBuilderPage;
    AdminHomePage adminHomePage;

    CRMPage crmPage;
    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        TestBase driver1 = TestBase.getInstanceOfDriver();
        driver = driver1.getDriver();
    }
    /*@After
    public void afterScenario() {
        // Refresh browser after each scenario (if needed)
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
        //wait.until(ExpectedConditions.jsReturnsValue("return document.readyState").equals("complete"));
    }*/
    @Given("User enters correct URL and opened login page")
    public void user_enters_correct_url_and_opened_login_page() throws InterruptedException, AWTException {
        System.out.println("WebPage opened successfully");
        loginpage = new LoginPage(driver, scenario);
    }

    @Given("User able to open login page")
    public void user_able_to_open_login_page() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver, scenario);
    }

    @When("User entered correct Admin username and password")
    public void user_entered_correct_admin_username_and_password() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.getAdminUser());
        loginpage.EnterPassword(TestBase.testEnvironment.getAdminPass());
        loginpage.ClickSignin();
    }
    @Then("Admin Page is opened successfully")
    public void admin_page_is_opened_successfully() throws InterruptedException {
        homepage = new HomePage(driver,scenario);
        homepage.VerifyHomePage();
    }
    @Then("User click on the General settings option")
    public void user_click_on_the_general_settings_option() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        System.out.println("click on Hamburger");
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.ClickOnGSHumburger();
    }
    @Then("User click on the Branding Option")
    public void user_click_on_the_branding_option() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.ClickOnThemeBuilder();

    }
    @And("Verify there should be twentyFive default themes available")
    public void verifyThereShouldBeTwentyFiveDefaultThemesAvailable() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.verifyThemeBuilderPage();
        // themeBuilderPage.verifyLoginPage();
    }
    @And("Verify all theme image should appear")
    public void VerifyAllThemeImageShouldAppear() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.verifyAllThemeImage();
    }
    @Then("Select any image in the theme and validate preview")
    public void selectAnyImageInTheThemeAndValidatePreview() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.selectImageforTheme();
        themeBuilderPage.validatePreview();
        //themeBuilderPage.cancelChanges();
        //themeBuilderPage.saveChanges();
    }
    @When("Select My own theme radio button with Light header text")
    public void selectMyOwnThemeRadioButtonWithLightHeaderText() throws AWTException, InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.chooseCustomThemeLight();
        //Thread.sleep(4000);
        //themeBuilderPage.cancelChanges();
        //themeBuilderPage.saveChanges();
    }

    @Then("Click on choose photo to select custom theme and validate preview of light header text")
    public void clickOnChoosePhotoToSelectCustomThemeAndValidatePreviewOfLightHeaderText() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.validatePreview();
    }
   /* @Then("Click on choose photo to select custom theme and validate preview")
    public void clickOnChoosePhotoToSelectCustomThemeAndValidatePreview() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.validatePreview();
        //Thread.sleep(4000);
        //themeBuilderPage.cancelChanges();
        //Thread.sleep(4000);
    }*/
    @When("Select My own theme radio button with Dark header text")
    public void selectMyOwnThemeRadioButtonWithDarkHeaderText() throws AWTException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.chooseCustomThemeDark();
    }
    @Then("Click on choose photo to select custom theme and validate preview of dark header text")
    public void clickOnChoosePhotoToSelectCustomThemeAndValidatePreviewOfDarkHeaderText() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.validatePreview();
        themeBuilderPage.cancelChanges();
    }
    @When("Select any primary theme colour")
    public void selectAnyPrimaryThemeColour() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.selectPrimaryColour();
    }
    @Then("Validate preview of main component with primary colour")
    public void validatePreviewOfMainComponentWithPrimaryColour() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        //themeBuilderPage.cancelChanges();
        themeBuilderPage.saveChanges();
        themeBuilderPage.verifyPriColorPreview();
    }
    @When("Select any secondary theme colour")
    public void selectAnySecondaryThemeColour() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.selectSecondaryColour();
        themeBuilderPage.saveChanges();
    }
    @Then("Validate preview of other component with secondary colour")
    public void validatePreviewOfOtherComponentWithSecondaryColour() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.verifySecColorPreview();
        themeBuilderPage.cancelChanges();
    }
    @When("User click on reset default theme settings")
    public void userClickOnResetDefaultThemeSettings() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.resetDeThSettings();
        themeBuilderPage.cancelChanges();
    }
    @Then("Validate colors are back to default colors")
    public void validateColorsAreBackToDefaultColors() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.validateDefaultSettings();
    }
    @When("User click on select files under company logo section")
    public void userClickOnSelectFilesUnderCompanyLogoSection() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.selectCompanyLogo();
    }
    @Then("Verify company logo should appear in the center card of the login page")
    public void verifyCompanyLogoShouldAppearInTheCenterCardOfTheLoginPage() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.verifyCompanyLogo();
        themeBuilderPage.saveChanges();
    }
    @When("User select any theme and make any changes with theme")
    public void userSelectAnyThemeAndMakeAnyChangesWithTheme() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        //themeBuilderPage.selectImageforTheme();
        themeBuilderPage.makeChangesToCancel();
        System.out.println("make all changes");
    }
    @Then("User click on cancel button to discard all changes")
    public void userClickOnCancelButtonToDiscardAllChanges() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.validatePreview();
        themeBuilderPage.cancelChanges();
        themeBuilderPage.verifyCancelAllChanges();
    }
    @Then("User click permission by dropdown")
    public void userClickPermissionByDropdown() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.permissionByDD();
        HelpersMethod.waitTillPageLoaded(driver, 5000);
    }

    @And("Select any other than company from permission by dropdown")
    public void selectAnyOtherThanCompanyFromPermissionByDropdown() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.selectOtherDD();
        HelpersMethod.waitTillPageLoaded(driver, 5000);
    }
    @Then("Validate that theme builder is disappearing for other company level it only accessible for company level")
    public void validateThatThemeBuilderIsDisappearingForOtherCompanyLevelItOnlyAccessibleForCompanyLevel() {
        System.out.println("11 TC done successfully");
        //themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        //themeBuilderPage.verifyThemeBuilderDisappear();
    }
    @When("Click on the permission by DD and Select company which client user registered")
    public void clickOnThePermissionByDDAndSelectCompanyWhichClientUserRegistered() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.permissionByDD();
        adminHomePage=new AdminHomePage(driver,scenario);
        //adminHomePage.ClickPermissionBy();
        adminHomePage.SelectCompany();
    }
    @When("User select any theme and make any changes with theme to save")
    public void userSelectAnyThemeAndMakeAnyChangesWithThemeToSave() throws InterruptedException {
        themeBuilderPage=new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.makeChangesToSave();
        //HelpersMethod.waitTillPageLoaded(driver, 5000);

    }
    @Then("User click on save button to save all changes")
    public void userClickOnSaveButtonToSaveAllChanges() throws InterruptedException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.validatePreview();
        themeBuilderPage.saveChanges();
        themeBuilderPage.verifySaveAllChanges();

    }
    @And("Click on logout")
    public void clickOnLogout() throws InterruptedException, AWTException {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.clickToLogOut();
        /*OrderEntryPage orderEntryPage=new OrderEntryPage(driver, scenario);
        orderEntryPage.Click_On_Signout();*/
        System.out.println("logout from site successfully");
    }

    @Then("Validate login page is updated according to theme selection")
    public void validateLoginPageIsUpdatedAccordingToThemeSelection() {
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        themeBuilderPage.verifyLoginPgWithNewTheme();
    }
    @And("Login with client and validate colors of components are updated")
    public void loginWithClientAndValidateColorsOfComponentsAreUpdated() throws InterruptedException, AWTException {
        loginpage = new LoginPage(driver,scenario);
        loginpage.EnterUsername(TestBase.testEnvironment.username());
        loginpage.EnterPassword(TestBase.testEnvironment.password());
        loginpage.ClickSignin();
        //themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        //themeBuilderPage.loginWithClient();
        //themeBuilderPage.validateColorComp();
        themeBuilderPage.verifyNewThemeAfterLogin();
    }
    @Then("Click on every module in left menu and validate all module master page should change according to new theme")
    public void clickOnEveryModuleInLeftMenuAndValidateAllModuleMasterPageShouldChangeAccordingToNewTheme() throws InterruptedException {
        crmPage=new CRMPage(driver,scenario);
        crmPage.clickOnHamburgerMenu();
        crmPage.clickOnSettingsBtn();
        themeBuilderPage =new ThemeBuilderPage(driver,scenario);
        //themeBuilderPage.verifyEveryModuleMasterPage();
        themeBuilderPage.clickOnOrderEntry();
    }
}
