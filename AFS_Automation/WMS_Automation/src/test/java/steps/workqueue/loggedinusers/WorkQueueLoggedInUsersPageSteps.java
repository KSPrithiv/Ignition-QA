package steps.workqueue.loggedinusers;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.workqueuedata.WorkQueueDataDTO;
import ui.pages.workqueue.loggedinusers.WorkQueueLoggedInUsersPage;

import java.util.List;

@Slf4j
public class WorkQueueLoggedInUsersPageSteps {
    WorkQueueLoggedInUsersPage workQueueLoggedInUsersPage = new WorkQueueLoggedInUsersPage();
    WorkQueueDataDTO workQueueDataDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.WORK_QUEUE_DATA, WorkQueueDataDTO.class);

    @Step
    @And("Waits for Work Queue Logged In Users page to load")
    public void waitForWorkQueueLoggedInUsersPageToLoad() {
        log.info("Waiting forWork Queue Logged In Users page to load");
        workQueueLoggedInUsersPage.waitWorkQueueLoggedInUsersPageToLoad();
    }

    @Step
    @And("User scrolls till end of grid table on Work Queue Logged In Users page")
    public void scrollsTillEndOfGridTable() {
        log.info("Waiting for Work Queue Logged In Users page To Load");
        workQueueLoggedInUsersPage.scrollToLoggedInUserTableEnd();
    }

    @Step
    @And("User selects warehouse {string} on Work Queue Logged In Users page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.selectWarehouse(warehouse);
    }

    @Step
    @And("User clicks on User Id Header on Work Queue Logged In Users page")
    public void clickUserIdHeader() {
        log.info("User clicks on User Id Header on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickUserIdColumnHeader();
    }

    @Step
    @And("User clicks on User Name Header on Work Queue Logged In Users page")
    public void clickUserNameHeader() {
        log.info("User clicks on User Name Header on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickUserNameColumnHeader();
    }

    @Step
    @And("User clicks on Computer Header on Work Queue Logged In Users page")
    public void clickComputerHeader() {
        log.info("User clicks on Computer Header on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickComputerColumnHeader();
    }

    @Step
    @And("User clicks on Equipment Header on Work Queue Logged In Users page")
    public void clickEquipmentHeader() {
        log.info("User clicks on Equipment Header on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickEquipmentColumnHeader();
    }

    @Step
    @And("User clicks on Printer Header on Work Queue Logged In Users page")
    public void clickPrinterHeader() {
        log.info("User clicks on Printer Header on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickPrinterColumnHeader();
    }

    @Step
    @And("User clicks on Login Date Header on Work Queue Logged In Users page")
    public void clickLoginDateHeader() {
        log.info("User clicks on Login Date Header on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickLoginDateColumnHeader();
    }

    @Step
    @And("User clicks on Break Date Header on Work Queue Logged In Users page")
    public void clickBreakDateHeader() {
        log.info("User clicks on Break Date Header on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickBreakDateColumnHeader();
    }

    @Step
    @And("User clicks on Labor Code Header on Work Queue Logged In Users page")
    public void clickLaborCodeHeader() {
        log.info("User clicks on Labor Code Header on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickLaborCodeColumnHeader();
    }

    @Step
    @And("User searches for {string} on Work Queue Logged In Users page")
    public void searchOnWorkQueueLoggedInUsers(String value) {
        log.info("User searches on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.findValuesInSearch(value);
    }

    @Step
    @And("User searches for user by index {int} on Work Queue Logged In Users page")
    public void searchOnWorkQueueLoggedInUsersByIndex(int index) {
        log.info("User searches for user by index on Work Queue Logged In Users page");
        List<String> users = List.of(workQueueDataDTO.getLoggedInUsersDTO().getLoggedInUser1(), workQueueDataDTO
                .getLoggedInUsersDTO().getLoggedInUser2(), workQueueDataDTO.getLoggedInUsersDTO().getLoggedInUser3(),
                workQueueDataDTO.getLoggedInUsersDTO().getLoggedInUser4(), workQueueDataDTO.getLoggedInUsersDTO()
                .getLoggedInUser5(), workQueueDataDTO.getLoggedInUsersDTO().getLoggedInUser6());
        workQueueLoggedInUsersPage.findValuesInLoggedInUserGridSearch(users.get(index));
    }

    @Step
    @And("User clicks Add filter button on Work Queue Logged In Users page")
    public void clickAddFilter() {
        log.info("Clicking add filter on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickAddFilter();
    }

    @Step
    @And("User clicks Clear All button on Work Queue Logged In Users page")
    public void clickClearAll() {
        log.info("Clicking clear all on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickClearAllButton();
    }

    @Step
    @And("Clicks Apply Button on Work Queue Logged In Users page")
    public void clickApplyButton() {
        log.info("Clicks Apply Button on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickApplyButton();
    }

    @Step
    @And("Types User Id {string} on Work Queue Logged In Users page")
    public void typesUserIdFilter(String filter) {
        log.info("Types User Id on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.typeFilter(filter);
    }

    @Step
    @And("Types User Id by index {int} on Work Queue Logged In Users page")
    public void typesUserIdFilterByIndex(int index) {
        log.info("Types User Id by index on Work Queue Logged In Users page");
        List<String> userIds = List.of(workQueueDataDTO.getUserIdsDTO().getUserId1(), workQueueDataDTO.getUserIdsDTO()
                .getUserId2(), workQueueDataDTO.getUserIdsDTO().getUserId3(), workQueueDataDTO.getUserIdsDTO().getUserId4(),
                workQueueDataDTO.getUserIdsDTO().getUserId5(), workQueueDataDTO.getUserIdsDTO().getUserId6());
        workQueueLoggedInUsersPage.typeFilter(userIds.get(index));
    }

    @Step
    @And("Types User Name {string} on Work Queue Logged In Users page")
    public void typesUserNameFilter(String filter) {
        log.info("Types User Name on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.typeFilter(filter);
    }

    @Step
    @And("Types User Name by index {int} on Work Queue Logged In Users page")
    public void typesUserNameFilterByIndex(int index) {
        log.info("Types User Name by index on Work Queue Logged In Users page");
        List<String> userNames = List.of(workQueueDataDTO.getLoggedInUsersDTO().getLoggedInUser1(), workQueueDataDTO
                .getLoggedInUsersDTO().getLoggedInUser2(), workQueueDataDTO.getLoggedInUsersDTO().getLoggedInUser3(),
                 workQueueDataDTO.getLoggedInUsersDTO().getLoggedInUser4(), workQueueDataDTO.getLoggedInUsersDTO()
                .getLoggedInUser5(), workQueueDataDTO.getLoggedInUsersDTO().getLoggedInUser6());
        workQueueLoggedInUsersPage.typeFilter(userNames.get(index));
    }

    @Step
    @And("Types Computer {string} on Work Queue Logged In Users page")
    public void typesComputerFilter(String filter) {
        log.info("Types Computer on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.typeFilter(filter);
    }

    @Step
    @And("Types Computer by index {int} on Work Queue Logged In Users page")
    public void typesComputerFilterByIndex(int index) {
        log.info("Types Computer by index on Work Queue Logged In Users page");
        List<String> computers = List.of(workQueueDataDTO.getComputersDTO().getComputer1(), workQueueDataDTO.getComputersDTO()
                .getComputer2(), workQueueDataDTO.getComputersDTO().getComputer3(), workQueueDataDTO.getComputersDTO()
                .getComputer4(), workQueueDataDTO.getComputersDTO().getComputer5(), workQueueDataDTO.getComputersDTO()
                .getComputer6());
        workQueueLoggedInUsersPage.typeFilter(computers.get(index));
    }

    @Step
    @And("Types Equipment {string} on Work Queue Logged In Users page")
    public void typesEquipmentFilter(String filter) {
        log.info("Types Equipment on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.typeFilter(filter);
    }

    @Step
    @And("Types Printer Code {string} on Work Queue Logged In Users page")
    public void typesPrinterCodeFilter(String filter) {
        log.info("Types Printer Code on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.typeFilter(filter);
    }

    @Step
    @And("Types Labor Code {string} on Work Queue Logged In Users page")
    public void typesLaborCodeFilter(String filter) {
        log.info("Types Labor Code on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.typeFilter(filter);
    }

    @Step
    @And("Checks User Id Checkbox on Work Queue Logged In Users page")
    public void checksUserIdCheckbox() {
        log.info("Checks User Id Checkbox on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.checkUserIdFilterCheckBox();
    }

    @Step
    @And("Checks User Name Checkbox on Work Queue Logged In Users page")
    public void checksUserNameCheckbox() {
        log.info("Checks User Name Checkbox on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.checkUserNameFilterCheckBox();
    }

    @Step
    @And("Checks Computer Checkbox on Work Queue Logged In Users page")
    public void checksComputerCheckbox() {
        log.info("Checks Computer Checkbox on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.checkComputerFilterCheckBox();
    }

    @Step
    @And("Selects Logout User by index {int} Dropdown on Work Queue Logged In Users page")
    public void clickLogoutUserDropdown(int index) {
        log.info("Clicks on Logout User Dropdown on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickOnLoggedInUserByIndex(index);
    }

    @Step
    @And("Clicks on Logout User Dropdown on Work Queue Logged In Users page")
    public void clickLogoutUserDropdown() {
        log.info("Clicks on Logout User Dropdown on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickLogoutUserDropdown();
    }

    @Step
    @And("Clicks Logout User label on Work Queue Logged In Users page")
    public void clickLogoutUserLabel() {
        log.info("Clicks Logout User label on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickLogoutUserLabel();
    }

    @Step
    @And("Selects Logout reason {string} on Work Queue Logged In Users page")
    public void selectLogoutUserDropdown(String option) {
        log.info("Selects Logout reason on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.selectLogoutUserReason(option);
    }

    @Step
    @And("Selects Logout reason by index {int} on Work Queue Logged In Users page")
    public void selectLogoutUserDropdown(int index) {
        log.info("Selects Logout reason by index on Work Queue Logged In Users page");
        List<String> reasons = List.of(workQueueDataDTO.getLogoutUsersDTO().getLogoutReason1(), workQueueDataDTO
                .getLogoutUsersDTO().getLogoutReason2(), workQueueDataDTO.getLogoutUsersDTO().getLogoutReason3(), workQueueDataDTO
                .getLogoutUsersDTO().getLogoutReason4());
        workQueueLoggedInUsersPage.selectLogoutUserReason(reasons.get(index));
    }

    @Step
    @And("Clicks OK button on Work Queue Logged In Users page")
    public void clickOKButton() {
        log.info("Clicks OK button on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickOK();
    }

    @Step
    @And("Clicks Cancel button on Work Queue Logged In Users page")
    public void clickCancelButton() {
        log.info("Clicks Cancel button on Work Queue Logged In Users page");
        workQueueLoggedInUsersPage.clickCancel();
    }

}
