package steps.lookup.lookupdockmanagement;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.lookup.dockmanagement.DockManagementLookupPage;

@Slf4j
public class DockManagementPageSteps {
    DockManagementLookupPage dockManagementLookupPage = new DockManagementLookupPage();

    @Step
    @And("Waits for Dock Management Lookup page to load")
    public void waitForDockManagementLookupPageToLoad() {
        log.info("Waits for Dock Management Lookup page to load");
        dockManagementLookupPage.waitForDockManagementLookupPageToLoad();
    }

    @Step
    @And("User types {string} date from input on Dock Management page")
    public void typeDockMgmtStartDate(String date) {
        log.info("User types date from input on Dock Management page");
        dockManagementLookupPage.typeDockMgmtStartDate(date);
    }

    @Step
    @And("User types {string} date to input on Dock Management page")
    public void typeDockMgmtToDate(String date) {
        log.info("User types date to input on Dock Management page");
        dockManagementLookupPage.typeDockMgmtToDate(date);
    }

    @Step
    @And("User selects warehouse {string} on Dock Management page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse on Dock Management page");
        dockManagementLookupPage.selectWarehouse(warehouse);
    }

    @Step
    @And("User clicks item {int} on Dock Management page")
    public void clickItemByIndex(int index) {
        log.info("User clicks item on Dock Management page");
        dockManagementLookupPage.clickItemByIndex(index);
    }

    @Step
    @And("User clicks Dock Mgmt Summary row {int} on Dock Management page")
    public void clickDockMgmtSummaryRowsByIndex(int index) {
        log.info("User clicks Dock Mgmt Summary row on Dock Management page");
        dockManagementLookupPage.clickDockMgmtSummaryRowsByIndex(index);
    }

    @Step
    @And("User clicks Back on Dock Management Summary page")
    public void clickBackButton() {
        log.info("User clicks Back on Dock Management Summary page");
        dockManagementLookupPage.clickBackButton();
    }

    @Step
    @And("User clicks Cancel on Dock Management Summary page")
    public void clickCancelButton() {
        log.info("User clicks Cancel on Dock Management Summary page");
        dockManagementLookupPage.clickCancelButton();
    }

    @Step
    @And("User clicks OK on Dock Management Summary page")
    public void clickOKButton() {
        log.info("User clicks OK on Dock Management Summary page");
        dockManagementLookupPage.clickOKButton();
    }

    @Step
    @And("User clicks not empty Trailer by index {int} on Dock Management Summary page")
    public void clickNotEmptyTrailerByIndex(int index) {
        log.info("User clicks not empty Trailer on Dock Management Summary page");
        dockManagementLookupPage.clickNotEmptyTrailerByIndex(index);
    }

    @Step
    @And("User clicks not empty Scheduled by index {int} on Dock Management Summary page")
    public void clickNotEmptyScheduledByIndex(int index) {
        log.info("User clicks not empty Scheduled on Dock Management Summary page");
        dockManagementLookupPage.clickNotEmptyScheduledByIndex(index);
    }

    @Step
    @And("User types Scheduled date {string} on Dock Management Summary page")
    public void typeScheduledTime(String date) {
        log.info("User types Scheduled date on Dock Management Summary page");
        dockManagementLookupPage.typeSchedDate(date);
    }

    @Step
    @And("User selects trailer {string} on Dock Management Summary page")
    public void typeTrailer(String date) {
        log.info("User selects trailer on Dock Management Summary page");
        dockManagementLookupPage.selectDDlTrailer(date);
    }

    @Step
    @And("User clicks Select All checkbox on Dock Management page")
    public void clickSelectAll() {
        log.info("User clicks Select All checkbox on Dock Management page");
        dockManagementLookupPage.clickSelectAll();
    }

    @Step
    @And("User clicks Receiving checkbox on Dock Management page")
    public void clickReceiving() {
        log.info("User clicks Receiving checkbox on Dock Management page");
        dockManagementLookupPage.clickReceiving();
    }

    @Step
    @And("User clicks Shipping checkbox on Dock Management page")
    public void clickShipping() {
        log.info("User clicks Shipping checkbox on Dock Management page");
        dockManagementLookupPage.clickShipping();
    }

    @Step
    @And("User clicks Production checkbox on Dock Management page")
    public void clickProduction() {
        log.info("User clicks Production checkbox on Dock Management page");
        dockManagementLookupPage.clickProduction();
    }

}
