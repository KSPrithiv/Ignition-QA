package steps.outbound.processing;

import common.utils.database.SqlQueriesUtils;
import common.utils.database.StoreProceduresUtils;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.outbound.processing.AddAllocationBatchPage;
import ui.pages.outbound.processing.ProcessingPage;

@Slf4j
public class ProcessingPageSteps {
    ProcessingPage processingPage = new ProcessingPage();
    StoreProceduresUtils storeProceduresUtils = new StoreProceduresUtils();
    SqlQueriesUtils sqlQueriesUtils = new SqlQueriesUtils();

    @Step
    @And("Wait for Processing page to load")
    public void waitForProcessingPageToLoad() {
        log.info("Waiting for Processing Page To Load");
        processingPage.waitProcessingPageToLoad();
    }

    @Step
    @And("User goes to Unbatched on Processing page")
    public void goToUnbatchedOrders() {
        log.info("Go to Unbatched Orders");
        processingPage.clickUnbatchedOrders();
    }

    @Step
    @And("User goes to Batches on Processing page")
    public void goToBatches() {
        log.info("Go to Batches");
        processingPage.clickBatches();
    }

    @Step
    @And("User goes to All Orders on Processing page")
    public void goToAllOrders() {
        log.info("Go to All Orders");
        processingPage.clickAllOrders();
    }

    @Step
    @And("Closes order details on Processing page")
    public void closeOrderDetails() {
        log.info("Closing Order Details");
        processingPage.clickCloseButton();
    }

    @Step
    @And("User selects calendar on Processing page")
    public void clickCalendar() {
        log.info("Clicking calendar");
        processingPage.clickCalendarOption();
    }

    @Step
    @And("Clicks Process button on Processing page")
    public void clickProcessButton() {
        log.info("Clicking Process button");
        processingPage.clickProcessButton();
    }

    @Step
    @And("Clicks Unprocess button on Processing page")
    public void clickUnprocessButton() {
        log.info("Clicking Unprocess button");
        processingPage.clickUnprocessButton();
    }

    @Step
    @And("Clicks Ok on Processing page")
    public void clickOK() {
        log.info("Clicking Ok on Processing page");
        processingPage.clickOkButton();
    }

    @Step
    @And("Clicks delete button on Processing page")
    public void clickDelete() {
        log.info("Clicking Delete");
        processingPage.clickDeleteButton();
    }

    @Step
    @And("User selects warehouse {string} on Processing page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse {string} on Processing page");
        processingPage.selectWarehouse(warehouse);
    }

    @Step
    @And("Clicks Yes button on Processing page")
    public void clickYes() {
        log.info("Clicking Yes");
        processingPage.clickYesButton();
    }

    @Step
    @And("Clicks No button on Processing page")
    public void clickNo() {
        log.info("Clicking No");
        processingPage.clickNoButton();
    }

    @Step
    @And("Check Unbatched Order with index {int} on Processing page")
    public void checkUnbatchedOrdersByOrderNumber(int number) {
        log.info("Checking order " + number);
        processingPage.checkUnbatchedOrderByNumber(number);
    }

    @Step
    @And("Check All Orders By Order index {int} on Processing page")
    public void checkAllOrdersByOrderNumber(int number) {
        log.info("Checking order " + number);
        processingPage.checkOrderByNumber(number);
    }

    @Step
    @And("User clicks filtering order on Processing page")
    public void clickFilteredOrders() {
        log.info("Clicking filtered orders ");
        processingPage.clickFilteredOrders();
    }

    @Step
    @And("Drag and drop order by order index {int} on Processing page")
    public void dragAndDropOrderByOrderNumber(int number) {
        log.info("Drag And Drop Order By Order number " + number);
        processingPage.dragAndDropOrderToBatch(number, AddAllocationBatchPage.getBatchName());
    }

    @Step
    @And("User clicks add button on Processing page")
    public void clickAdd() {
        log.info("Clicking Add");
        processingPage.clickAddButton();
    }

    @Step
    @And("User selects processing date {string} on Processing page")
    public void selectDate(String date) {
        log.info("Selecting date");
        processingPage.selectDate(date);
    }

    @Step
    @And("User selects batch by name on Processing page")
    public void selectBatchByName() {
        log.info("Selecting Batch " + AddAllocationBatchPage.getBatchName());
        processingPage.clickBatch(AddAllocationBatchPage.getBatchName());
    }

    @Step
    @And("User selects batch {string} on Processing page")
    public void selectBatch(String name) {
        log.info("Selecting Batch " + name);
        processingPage.clickBatch(name);
    }

}
