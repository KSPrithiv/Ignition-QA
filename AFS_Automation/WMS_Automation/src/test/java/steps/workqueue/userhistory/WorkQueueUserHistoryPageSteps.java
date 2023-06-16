package steps.workqueue.userhistory;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.workqueue.userhistory.WorkQueueUserHistoryPage;

@Slf4j
public class WorkQueueUserHistoryPageSteps {
    WorkQueueUserHistoryPage workQueueUserHistoryPage = new WorkQueueUserHistoryPage();

    @Step
    @And("Waits for Work Queue User History page to load")
    public void waitForWorkQueueUserHistoryPageToLoad() {
        log.info("Waiting for Work Queue User History Page To Load");
        workQueueUserHistoryPage.waitWorkQueueUserHistoryPageToLoad();
    }

    @Step
    @And("User selects warehouse {string} on Work Queue User History page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse on Work Queue User History page");
        workQueueUserHistoryPage.selectWarehouse(warehouse);
    }

    @Step
    @And("User scrolls till end of grid table on Work Queue User History page")
    public void scrollsTillEndOfGridTable() {
        log.info("Waiting for Work Queue User History Page To Load");
        workQueueUserHistoryPage.scrollToUserHistoryTableEnd();
    }

    @Step
    @And("User clicks on Login Header on Work Queue User History page")
    public void clickLoginHeader() {
        log.info("User clicks on Login Header on Work Queue User History page");
        workQueueUserHistoryPage.clickLoginHeader();
    }

    @Step
    @And("User clicks on Logout Header on Work Queue User History page")
    public void clickLogoutHeader() {
        log.info("User clicks on Logout Header on Work Queue User History page");
        workQueueUserHistoryPage.clickLogoutHeader();
    }

    @Step
    @And("User clicks on User Id Header on Work Queue User History page")
    public void clickUserIdHeader() {
        log.info("User clicks on User Id Header on Work Queue User History page");
        workQueueUserHistoryPage.clickUserIdHeader();
    }

    @Step
    @And("User clicks on User Name Header on Work Queue User History page")
    public void clickUserNameHeader() {
        log.info("User clicks on User Name Header on Work Queue User History page");
        workQueueUserHistoryPage.clickUserNameHeader();
    }

    @Step
    @And("User searches for {string} on Work Queue User History page")
    public void searchOnWorkQueueUserHistory(String value) {
        log.info("User searches on Work Queue User History page");
        workQueueUserHistoryPage.findValuesInSearch(value);
    }

    @Step
    @And("User clears Search on Work Queue User History page")
    public void clearSearchOnWorkQueueUserHistory() {
        log.info("User clears Search on Work Queue User History page");
        workQueueUserHistoryPage.clearValueInSearch();
    }

}
