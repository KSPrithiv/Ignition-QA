package steps.workqueue.workassign;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.workqueue.workassign.WorkQueueWorkAssignPage;

@Slf4j
public class WorkQueueWorkAssignSteps {
    WorkQueueWorkAssignPage workQueueWorkAssignPage = new WorkQueueWorkAssignPage();

    @Step
    @And("Waits for Work Queue Work Assign page to load")
    public void waitForWorkQueueTaskPageToLoad() {
        log.info("Waiting for Work Queue Work Assign page To Load");
        workQueueWorkAssignPage.waitWorkQueueWorkAssignPageToLoad();
    }

    @Step
    @And("User selects warehouse {string} on Work Queue Work Assign page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse on Work Queue Work Assign page");
        workQueueWorkAssignPage.selectWarehouse(warehouse);
    }

    @Step
    @And("Clicks on Task Group on Work Queue Work Assign page")
    public void clicksTaskGroup() {
        log.info("Clicks on Task Group on Work Queue Work Assign page");
        workQueueWorkAssignPage.clickOnTaskGroup();
    }

    @Step
    @And("Selects {string} Task Group on Work Queue Work Assign page")
    public void selectsTaskGroup(String option) {
        log.info("Selects Task Group on Work Queue Work Assign page");
        workQueueWorkAssignPage.selectTaskGroup(option);
    }

    @Step
    @And("Checks {string} user on Work Queue Work Assign page")
    public void checkUser(String user) {
        log.info("Checks user on Work Queue Work Assign page");
        workQueueWorkAssignPage.checkUserByName(user);
    }

    @Step
    @And("Clicks Save Button on Work Queue Work Assign page")
    public void clickSave() {
        log.info("Clicks Save Button on Work Queue Work Assign page");
        workQueueWorkAssignPage.clickSaveEditButton();
    }

    @Step
    @And("Clicks Cancel Button on Work Queue Work Assign page")
    public void clickCancel() {
        log.info("Clicks Cancel Button on Work Queue Work Assign page");
        workQueueWorkAssignPage.clickCancelEditButton();
    }

    @Step
    @And("Clicks Filter Button on Work Queue Work Assign page")
    public void clickFilter() {
        log.info("Clicks Filter Button on Work Queue Work Assign page");
        workQueueWorkAssignPage.clickFilterButton();
    }

    @Step
    @And("Clicks User Group Checkbox on Work Queue Work Assign page")
    public void clickUserGroupCheckbox() {
        log.info("Clicks User Group Checkbox on Work Queue Work Assign page");
        workQueueWorkAssignPage.clickUserGroupCheckbox();
    }

    @Step
    @And("Checks Admin User Group on Work Queue Work Assign page")
    public void checkAdminUserGroup() {
        log.info("Checks Admin User Group on Work Queue Work Assign page");
        workQueueWorkAssignPage.checkAdminUserGroup();
    }

    @Step
    @And("Checks Buyers User Group on Work Queue Work Assign page")
    public void checkBuyersUserGroup() {
        log.info("Checks Buyers User Group on Work Queue Work Assign page");
        workQueueWorkAssignPage.checkBuyersUserGroup();
    }

    @Step
    @And("Checks Default User Group on Work Queue Work Assign page")
    public void checkDefaultUserGroup() {
        log.info("Checks Default User Group on Work Queue Work Assign page");
        workQueueWorkAssignPage.checkDefaultUserGroup();
    }

    @Step
    @And("Checks Freezer User Group on Work Queue Work Assign page")
    public void checkFreezerUserGroup() {
        log.info("Checks Freezer User Group on Work Queue Work Assign page");
        workQueueWorkAssignPage.checkFreezerUserGroup();
    }

    @Step
    @And("Checks Managers User Group on Work Queue Work Assign page")
    public void checkManagersUserGroup() {
        log.info("Checks Managers User Group on Work Queue Work Assign page");
        workQueueWorkAssignPage.checkManagersUserGroup();
    }

    @Step
    @And("Checks Operators User Group on Work Queue Work Assign page")
    public void checkOperatorsUserGroup() {
        log.info("Checks Operators User Group on Work Queue Work Assign page");
        workQueueWorkAssignPage.checkOperatorsUserGroup();
    }

    @Step
    @And("User clicks Clear All button on Work Queue Work Assign page")
    public void clickClearAll() {
        log.info("Clicking clear all on Work Queue Work Assign page");
        workQueueWorkAssignPage.clickClearAllButton();
    }

}
