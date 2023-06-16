package steps.setup;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setup.SetupSystemPage;

@Slf4j
public class SetupSystemPageSteps {
    SetupSystemPage setupSystemPage = new SetupSystemPage();

    @Step
    @And("Waits for Setup System page to load")
    public void waitForSetupSystemPageToLoad() {
        log.info("Waiting for Setup System Page To Load");
        setupSystemPage.waitSetupSystemPageToLoad();
    }

    @Step
    @And("User selects warehouse {string} on Setup System page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse on Setup System page");
        setupSystemPage.selectWarehouse(warehouse);
    }

    @Step
    @And("Clicks Function Label on Setup System page")
    public void clickFunctionLabel() {
        log.info("Click Function Label on Setup System page");
        setupSystemPage.clickFunctionLabel();
    }

    @Step
    @And("Clicks Reason Label on Setup System page")
    public void clickReasonLabel() {
        log.info("Click Reason Label on Setup System page");
        setupSystemPage.clickReasonLabel();
    }

    @Step
    @And("Clicks Printer Label on Setup System page")
    public void clickPrinterLabel() {
        log.info("Click Printer Label on Setup System page");
        setupSystemPage.clickPrinterLabel();
    }

    @Step
    @And("Clicks Label format on Setup System page")
    public void clickLabelFormatLabel() {
        log.info("Click Label format on Setup System page");
        setupSystemPage.clickLabelFormatLabel();
    }

    @Step
    @And("Clicks Label file on Setup System page")
    public void clickLabelFileLabel() {
        log.info("Click Label file on Setup System page");
        setupSystemPage.clickLabelFileLabel();
    }

    @Step
    @And("Clicks Label rule on Setup System page")
    public void clickLabelRuleLabel() {
        log.info("Click Label rule on Setup System page");
        setupSystemPage.clickLabelRuleLabel();
    }

    @Step
    @And("Clicks Purge Label on Setup System page")
    public void clickPurgeLabel() {
        log.info("Click Purge Label on Setup System page");
        setupSystemPage.clickPurgeLabel();
    }

    @Step
    @And("Clicks Registry Label on Setup System page")
    public void clickRegistryLabel() {
        log.info("Click Registry Label on Setup System page");
        setupSystemPage.clickRegistryLabel();
    }

    @Step
    @And("Clicks Permission Label on Setup System page")
    public void clickPermissionLabel() {
        log.info("Click Permission Label on Setup System page");
        setupSystemPage.clickPermissionLabel();
    }

    @Step
    @And("Clicks User Group Label on Setup System page")
    public void clickUserGroupLabel() {
        log.info("Click User Group Label on Setup System page");
        setupSystemPage.clickUserGroupLabel();
    }

    @Step
    @And("Clicks Import Data Label on Setup System page")
    public void clickImportDataLabel() {
        log.info("Click Import Data Label on Setup System page");
        setupSystemPage.clickImportDataLabel();
    }

    @Step
    @And("Clicks Computer Label on Setup System page")
    public void clickComputerLabel() {
        log.info("Click Computer Label on Setup System page");
        setupSystemPage.clickComputerLabel();
    }

}
