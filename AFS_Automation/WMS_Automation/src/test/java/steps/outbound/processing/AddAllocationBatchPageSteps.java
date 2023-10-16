package steps.outbound.processing;

import common.enums.BatchType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.outbound.processing.AddAllocationBatchPage;

@Slf4j
public class AddAllocationBatchPageSteps {
    AddAllocationBatchPage addAllocationBatchPage = new AddAllocationBatchPage();

    @Step
    public void waitForProcessingPageToLoad() {
        log.info("Waiting for Add Allocation Batch Page To Load");
        addAllocationBatchPage.waitAddAllocationBatchPageToLoad();
    }

    @Step
    @And("Clicks Cancel on Add Allocation Batch page")
    public void clickCancel() {
        log.info("Clicking Cancel");
        addAllocationBatchPage.clickCancelButton();
    }
    @Step
    @Then("Selects batch type PD PICKS")
    public void selectBatchType() {
        log.info("Selecting Batch Type " + BatchType.PD_PICKS.getBatchType());
        addAllocationBatchPage.selectBatchType(BatchType.PD_PICKS.getBatchType());
    }

    @Step
    @When("User types batch code on Processing page")
    public void typeBatchCode() {
        AddAllocationBatchPage.generateBatchName(4, true, false);
        log.info("Typing Batch Code " + AddAllocationBatchPage.getBatchName());
        addAllocationBatchPage.typeBatchCode(AddAllocationBatchPage.getBatchName());
    }

    @Step
    @When("User types invalid batch code {string} on Processing page")
    public void typeInvalidBatchCode(String code) {
        log.info("Typing Invalid Batch Code");
        addAllocationBatchPage.typeBatchCode(code);
    }

    @Step
    @And("Clicks Save button on Processing page")
    public void clickSave() {
        log.info("Clicking Save");
        addAllocationBatchPage.clickSaveButton();
    }

    @Step
    @Then("User clicks on batch type on Processing page")
    public void clickOnBatchType() {
        log.info("Clicking Batch Type on Processing page");
        addAllocationBatchPage.clickBatchType();
    }
}
