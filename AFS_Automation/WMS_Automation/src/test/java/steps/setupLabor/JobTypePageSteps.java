package steps.setupLabor;
import common.constants.FilePaths;
import common.setup.DriverManager;
import common.setup.Environment;
import common.utils.Waiters;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import ui.pages.setupLabor.JobTypePage;
import ui.pages.setupLabor.SetupLaborCodePage;
//import util.TestBase;

import static common.setup.DriverManager.buildWebDriver;

@Slf4j

public class JobTypePageSteps {

    WebDriver driver;
    public static Environment environment;
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);
    JobTypePage jobTypePage=new JobTypePage(driver);


    @Step
    @And("Go to JobType Tab")
    public void gotoJobTypeTab() throws InterruptedException {
        log.info("Go to JobType Tab");
        setupLaborCodePage.jobtypeTab();
    }
    @Step
    @And("Verify JobType screen elements")
    public void verifyJobTypeScreenElements() throws InterruptedException {
        log.info("Go to JobType Tab");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(jobTypePage.isAddFilterButtonEnabled(), "Add Filter button is not enabled");
        softAssert.assertAll();
        softAssert.assertTrue(jobTypePage.isEditBtnDisabled().equals("true"), "Edit Product is not displayed");


    }

    @Step
    @And("Click on Add button")
    public void clickonAdd() throws InterruptedException {
        log.info("Click on Add button");
        setupLaborCodePage.addButton();
    }
    @Step
    @And("Creating JobType with special characters and users")
    public void createJobType() throws InterruptedException {
        log.info("Creating JobType with special characters and users");
        setupLaborCodePage.enterCode();
        setupLaborCodePage.usersTab();
    }
    @Step
    @And("Select any Code and click on Delete")
    public void selectAnyCodeAndclickOnDelete() throws InterruptedException {
        log.info("Select any Code and click on Delete");
        jobTypePage.clickCode();
        jobTypePage.clickDelete();
        jobTypePage.displayMessage();
        jobTypePage.clickCancel();
        jobTypePage.clickCode();
        jobTypePage.clickDelete();
        jobTypePage.deleteOK();
    }


    @Step
    @And("Select User DropDown List and Save")
    public void userDropDownAndSave() throws InterruptedException {
        setupLaborCodePage.selectUser();
    }
    @Step
    @And("Create Job Type with empty code")
    public void emptyCodeJobType() throws InterruptedException {
        setupLaborCodePage.addButton();
        setupLaborCodePage.enterCode2();
        setupLaborCodePage.enterSave();
        setupLaborCodePage.addButton();
        setupLaborCodePage.enterSave();
//        setupLaborCodePage.quit();
    }
    @Step
    @And("User clicks Add Filter on JobType page")
    public void clickAddFilterButton() throws InterruptedException {
        log.info("User clicks Add Filter on JobType page");
        setupLaborCodePage.jobtypeTab();
        setupLaborCodePage.clickAddFilterButton();
    }
    @Step
    @And("User clicks Code filter on JobType page")
    public void clickCodeFilter() throws InterruptedException {
        log.info("User clicks Code filter on JobType page");
        setupLaborCodePage.countCodeFilter();
        setupLaborCodePage.clickCodeFilter();
    }
    @Step
    @And("User enter Code and click on Apply button")
    public void enterCode() throws InterruptedException {
        log.info("User enter Code");
        setupLaborCodePage.enterFilterLetter();
        setupLaborCodePage.clickApply();
        setupLaborCodePage.verifyCodeFilter();
    }
    @Step
    @And("Verify Clear button")
    public void verifyClearButton() throws InterruptedException {
        log.info("Verify Clear button");
        setupLaborCodePage.clickAddFilterButton();
        setupLaborCodePage.clearAllFilterButton();
    }
    @Step
    @And("User clicks User group filter on JobType page")
    public void clickUsergroupFilter() throws InterruptedException {
        log.info("User clicks Code filter on JobType page");
        setupLaborCodePage.countUserGroup();
        setupLaborCodePage.clickAddFilterButton();
        setupLaborCodePage.clickUsergroupFilter();
    }
    @Step
    @And("User enter UserGroup and click on Apply button")
    public void enterUserGroup() throws InterruptedException {
        log.info("User enter Code");
        setupLaborCodePage.enterFilterLetter();
        setupLaborCodePage.clickApply();
        setupLaborCodePage.verifyUserGroupFilter();
    }

    @Step
    @And("User clicks Description filter on JobType page")
    public void clickDescriptionFilter() throws InterruptedException {
        log.info("User clicks Code filter on JobType page");
        setupLaborCodePage.countDescription();
        setupLaborCodePage.clickAddFilterButton();
        setupLaborCodePage.clickDescriptionFilter();
    }
    @Step
    @And("User enter Description and click on Apply button")
    public void enterDescription() throws InterruptedException {
        log.info("User enter Code");
        setupLaborCodePage.enterFilterLetter();
        setupLaborCodePage.clickApply();
        setupLaborCodePage.verifyDescriptionFilter();
    }

    @Step
    @And("User clicks Labor standard filter on JobType page")
    public void clickLaborstandardFilter() throws InterruptedException {
        log.info("User clicks Code filter on JobType page");
        setupLaborCodePage.countLaborStandard();
        setupLaborCodePage.clickAddFilterButton();
        setupLaborCodePage.clickLaborStandardFilter();
    }
    @Step
    @And("User enter Labor standard and click on Apply button")
    public void enterLaborstandard() throws InterruptedException {
        log.info("User enter Code");
        setupLaborCodePage.clickLaborStandared();
//        setupLaborCodePage.clickApply();
        setupLaborCodePage.verifyLaborStandardFilter();
    }
    @Step
    @And("Click on Search field on JobType Page")
    public void clickSearchField() throws InterruptedException {
        log.info("click on Search field");
        setupLaborCodePage.jobtypeTab();
        setupLaborCodePage.searchBoxActionJobType();
    }
    @Step
    @And("Verify Search functionalities")
    public void verifySearchFunctionality() throws InterruptedException {
        setupLaborCodePage.rownumber1();
        setupLaborCodePage.closeIcon();
        setupLaborCodePage.verifyTablerows();
        setupLaborCodePage.searchBoxAction3();
    }

}
