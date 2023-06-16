package steps.counting.sessions;

import common.constants.TimeFormats;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.counting.sessions.CountingSessionsPage;

import java.util.Calendar;

@Slf4j
public class CountingSessionsPageSteps {
    CountingSessionsPage countingSessionsPage = new CountingSessionsPage();

    @Step
    @And("Waits for Counting Sessions page to load")
    public void waitForCountingSessionsPageToLoad() {
        log.info("Waiting for Counting Sessions page to load");
        countingSessionsPage.waitCountingSessionsPageToLoad();
    }

    @Step
    @And("User selects warehouse {string} on Counting Sessions page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse on Counting Sessions page");
        countingSessionsPage.selectWarehouse(warehouse);
    }

    @Step
    @And("User clicks session dropdown on Counting Sessions page")
    public void clickSessionDropdown() {
        log.info("User clicks session dropdown on Counting Sessions page");
        countingSessionsPage.clickSessionDropdown();
    }

    @Step
    @And("User clicks Select All Checkbox on Counting Sessions page")
    public void clickSelectAllCheckbox() {
        log.info("User clicks Select All Checkbox on Counting Sessions page");
        countingSessionsPage.clickSelectAllCheckbox();
    }

    @Step
    @And("User clicks session page title on Counting Sessions page")
    public void clickSessionsPageTitle() {
        log.info("User clicks session page title on Counting Sessions page");
        countingSessionsPage.clickSessionsPageTitle();
    }

    @Step
    @And("User selects session {string} on Counting Sessions page")
    public void selectSession(String session) {
        log.info("User selects session on Counting Sessions page");
        countingSessionsPage.selectSession(session);
    }

    @Step
    @And("User checks table row by index {int} on Counting Sessions page")
    public void checkTableRowByIndex(int index) {
        log.info("User checks table row by index on Counting Sessions page");
        countingSessionsPage.checkTableRowByIndex(index);
    }

    @Step
    @And("User clicks table location by index {int} on Counting Sessions page")
    public void clickTableLocationByIndex(int index) {
        log.info("User clicks table location by index on Counting Sessions page");
        countingSessionsPage.clickTableLocationByIndex(index);
    }

    @Step
    @And("User clicks table count by index {int} on Counting Sessions page")
    public void selectTableCountByIndex(int index) {
        log.info("User clicks table count by index on Counting Sessions page");
        countingSessionsPage.selectTableCountByIndex(index);
    }

    @Step
    @And("User clicks all inputs checkbox on Count details popup on Counting Sessions page")
    public void clickAllInputsCheckbox() {
        log.info("User clicks all inputs checkbox on Count details popup on Counting Sessions page");
        countingSessionsPage.clickAllInputsCheckbox();
    }

    @Step
    @And("User clicks Add location button on Counting Sessions page")
    public void getLocationAdd() {
        log.info("User clicks Add location button on Counting Sessions page");
        countingSessionsPage.clickLocationAdd();
    }

    @Step
    @And("User clicks New Session button on Counting Sessions page")
    public void clickNewSession() {
        log.info("User clicks New Session button on Counting Sessions page");
        countingSessionsPage.clickNewSession();
    }

    @Step
    @And("User clicks Edit Session button on Counting Sessions page")
    public void clickEditSession() {
        log.info("User clicks Edit Session button on Counting Sessions page");
        countingSessionsPage.clickEditSession();
    }

    @Step
    @And("User clicks Delete Session button on Counting Sessions page")
    public void clickDeleteSession() {
        log.info("User clicks Delete Session button on Counting Sessions page");
        countingSessionsPage.clickDeleteSession();
    }

    @Step
    @And("User types session {string} name on Counting Sessions page")
    public void typeSessionName(String name) {
        log.info("User types session name on Counting Sessions page");
        countingSessionsPage.typeSessionName(name);
    }

    @Step
    @And("User types count type {string} on Counting Sessions page")
    public void selectCountType(String type) {
        log.info("User types count type on Counting Sessions page");
        countingSessionsPage.selectCountType(type);
    }

    @Step
    @And("User selects reason {string} on Counting Sessions page")
    public void selectDeleteReason(String reason) {
        log.info("User selects reason on Counting Sessions page");
        countingSessionsPage.selectDeleteReason(reason);
    }

    @Step
    @And("User clicks OK button on Counting Sessions page")
    public void clickOKButton() {
        log.info("User clicks OK button on Counting Sessions page");
        countingSessionsPage.clickOKButton();
    }

    @Step
    @And("User clicks Ok button on Counting Sessions page")
    public void clickOkButton() {
        log.info("User clicks Ok button on Counting Sessions page");
        countingSessionsPage.clickOkButton();
    }

    @Step
    @And("User clicks Cancel button on Counting Sessions page")
    public void clickCancelButton() {
        log.info("User clicks Cancel button on Counting Sessions page");
        countingSessionsPage.clickCancelButton();
    }

    @Step
    @And("User clicks Save button on Counting Sessions page")
    public void clickSaveButton() {
        log.info("User clicks Save button on Counting Sessions page");
        countingSessionsPage.clickSaveButton();
    }

    @Step
    @And("User clicks Yes button on Counting Sessions page")
    public void clickYesButton() {
        log.info("User clicks Yes button on Counting Sessions page");
        countingSessionsPage.clickYesButton();
    }

    @Step
    @And("User clicks No button on Counting Sessions page")
    public void clickNoButton() {
        log.info("User clicks No button on Counting Sessions page");
        countingSessionsPage.clickNoButton();
    }

    @Step
    @And("User clicks Active checkbox on Counting Sessions page")
    public void clickActiveCheckbox() {
        log.info("User clicks Active checkbox on Counting Sessions page");
        countingSessionsPage.clickActiveCheckbox();
    }

    @Step
    @And("User checks All Assignments input on Counting Sessions page")
    public void checkAllAssignments() {
        log.info("User checks All Assignments input on Counting Sessions page");
        countingSessionsPage.checkAllAssignments();
    }

    @Step
    @And("User types Location code {string} on Counting Sessions page")
    public void typeLocationCode(String code) {
        log.info("User types Location code on Counting Sessions page");
        countingSessionsPage.typeLocationCode(code);
    }

    @Step
    @And("User selects Location code {string} on Counting Sessions page")
    public void selectLocationCode(String code) {
        log.info("User selects Location code on Counting Sessions page");
        countingSessionsPage.selectLocationCode(code);
    }

    @Step
    @And("User clicks Location code button on Counting Sessions page")
    public void clickLocCodeButton() {
        log.info("User clicks Location code button on Counting Sessions page");
        countingSessionsPage.clickLocCodeButton();
    }

    @Step
    @And("Selects location by index {int} on Counting Sessions page")
    public void selectTableContentByIndex(int index) {
        log.info("Selects location by index on Counting Sessions page");
        countingSessionsPage.selectTableContentByIndex(index);
    }

    @Step
    @And("User types Partial location code {string} on Counting Sessions page")
    public void typePartialLocationCode(String code) {
        log.info("User types Partial location code on Counting Sessions page");
        countingSessionsPage.typePartialLocationCode(code);
    }

    @Step
    @And("User selects Zone {string} on Counting Sessions page")
    public void selectZone(String zone) {
        log.info("User selects Zone on Counting Sessions page");
        countingSessionsPage.selectZone(zone);
    }

    @Step
    @And("User selects Location type {string} on Counting Sessions page")
    public void selectLocationType(String type) {
        log.info("User selects Location type on Counting Sessions page");
        countingSessionsPage.selectLocationType(type);
    }

    @Step
    @And("User types Starting Location {string} on Counting Sessions page")
    public void typeStartingLocation(String code) {
        log.info("User types Starting Location on Counting Sessions page");
        countingSessionsPage.typeStartingLocation(code);
    }

    @Step
    @And("User types Ending Location {string} on Counting Sessions page")
    public void typeEndingLocation(String code) {
        log.info("User types Ending Location on Counting Sessions page");
        countingSessionsPage.typeEndingLocation(code);
    }

    @Step
    @And("User clicks Location tab on Counting Sessions page")
    public void clickLocationsTab() {
        log.info("User clicks Location tab on Counting Sessions page");
        countingSessionsPage.clickLocationsTab();
    }

    @Step
    @And("User clicks Products tab on Counting Sessions page")
    public void clickProductsTab() {
        log.info("User clicks Products tab on Counting Sessions page");
        countingSessionsPage.clickProductsTab();
    }

    @Step
    @And("User clicks Assignments tab on Counting Sessions page")
    public void clickAssignmentsTab() {
        log.info("User clicks Assignments tab on Counting Sessions page");
        countingSessionsPage.clickAssignmentsTab();
    }

    @Step
    @And("User clicks Add Filter on Counting Sessions page")
    public void clickAddFilterButton() {
        log.info("User clicks Add Filter on Counting Sessions page");
        countingSessionsPage.clickAddFilterButton();
    }

    @Step
    @And("User clicks Clear Filter on Counting Sessions page")
    public void clickClearFilter() {
        log.info("User clicks Clear Filter on Counting Sessions page");
        countingSessionsPage.clickClearFilter();
    }

    @Step
    @And("User clicks Location Column on Counting Sessions page")
    public void clickLocationColumnHeader() {
        log.info("User clicks Location Column on Counting Sessions page");
        countingSessionsPage.clickLocationColumnHeader();
    }

    @Step
    @And("User clicks Zone Column on Counting Sessions page")
    public void clickZoneColumnHeader() {
        log.info("User clicks Zone Column on Counting Sessions page");
        countingSessionsPage.clickZoneColumnHeader();
    }

    @Step
    @And("User clicks Type Column on Counting Sessions page")
    public void clickTypeColumnHeader() {
        log.info("User clicks Type Column on Counting Sessions page");
        countingSessionsPage.clickTypeColumnHeader();
    }

    @Step
    @And("User clicks Status Column on Counting Sessions page")
    public void clickStatusColumnHeader() {
        log.info("User clicks Status Column on Counting Sessions page");
        countingSessionsPage.clickStatusColumnHeader();
    }

    @Step
    @And("User clicks Counts Column on Counting Sessions page")
    public void clickCountsColumnHeader() {
        log.info("User clicks Counts Column on Counting Sessions page");
        countingSessionsPage.clickCountsColumnHeader();
    }

    @Step
    @And("User clicks Release Date and Time Column on Counting Sessions page")
    public void clickReleaseDateTimeColumn() {
        log.info("User clicks Release Date and Time Column on Counting Sessions page");
        countingSessionsPage.clickReleaseDateTimeColumn();
    }

    @Step
    @And("User clicks Product Column on Counting Sessions page")
    public void clickProductColumn() {
        log.info("User clicks Product Column on Counting Sessions page");
        countingSessionsPage.clickProductColumn();
    }

    @Step
    @And("User clicks Owner Column on Counting Sessions page")
    public void clickOwnerColumnHeader() {
        log.info("User clicks Owner Column on Counting Sessions page");
        countingSessionsPage.clickOwnerColumnHeader();
    }

    @Step
    @And("User clicks Description Column on Counting Sessions page")
    public void clickDescriptionColumnHeader() {
        log.info("User clicks Description Column on Counting Sessions page");
        countingSessionsPage.clickDescriptionColumnHeader();
    }

    @Step
    @And("User clicks Book Qty Column on Counting Sessions page")
    public void clickBookQtyColumnHeader() {
        log.info("User clicks Book Qty Column on Counting Sessions page");
        countingSessionsPage.clickBookQtyColumnHeader();
    }

    @Step
    @And("User clicks Book Cost Column on Counting Sessions page")
    public void clickBookCostColumnHeader() {
        log.info("User clicks Book Cost Column on Counting Sessions page");
        countingSessionsPage.clickBookCostColumnHeader();
    }

    @Step
    @And("User clicks Product Type Column on Counting Sessions page")
    public void clickProductTypeColumnHeader() {
        log.info("User clicks Product Type on Counting Sessions page");
        countingSessionsPage.clickProductTypeColumnHeader();
    }

    @Step
    @And("User clicks Location Delete on Counting Sessions page")
    public void clickLocationDeleteButton() {
        log.info("User clicks Location Delete on Counting Sessions page");
        countingSessionsPage.clickLocationDeleteButton();
    }

    @Step
    @And("User clicks Location Release on Counting Sessions page")
    public void clickLocationReleaseButton() {
        log.info("User clicks Location Release on Counting Sessions page");
        countingSessionsPage.clickLocationReleaseButton();
    }

    @Step
    @And("User clicks Location Reconcile on Counting Sessions page")
    public void clickLocationReconcileButton() {
        log.info("User clicks Location Reconcile on Counting Sessions page");
        countingSessionsPage.clickLocationReconcileButton();
    }

    @Step
    @And("User searches for product {string} on Counting Sessions page")
    public void searchProduct(String product) {
        log.info("User searches for product on Counting Sessions page");
        countingSessionsPage.searchProduct(product);
    }

    @Step
    @And("User searches for assignment {string} on Counting Sessions page")
    public void searchAssignment(String assignment) {
        log.info("User searches for assignment on Counting Sessions page");
        countingSessionsPage.searchAssignment(assignment);
    }

    @Step
    @And("User checks Assignment by index {int} on Counting Sessions page")
    public void checkAssignment(int index) {
        log.info("User checks Assignment by index on Counting Sessions page");
        countingSessionsPage.checkAssignment(index);
    }

    @Step
    @And("User deletes product search input on Counting Sessions page")
    public void deleteProductSearchInput() {
        log.info("User deletes product search input on Counting Sessions page");
        countingSessionsPage.deleteProductSearchInput();
    }

    @Step
    @And("User clicks Add filter button on Counting Sessions page")
    public void clickAddFilter() {
        log.info("Clicking add filter on Counting Sessions page");
        countingSessionsPage.clickAddFilter();
    }

    @Step
    @And("Checks Product Checkbox on Counting Sessions page")
    public void checkProductCodeFilterCheckBox() {
        log.info("Checks Product Checkbox on Counting Sessions page");
        countingSessionsPage.checkProductCodeFilterCheckBox();
    }

    @Step
    @And("Checks Owner Checkbox on Counting Sessions page")
    public void checkOwnerCodeFilterCheckBox() {
        log.info("Checks Owner Checkbox on Counting Sessions page");
        countingSessionsPage.checkOwnerCodeFilterCheckBox();
    }

    @Step
    @And("Checks Description Checkbox on Counting Sessions page")
    public void checkProductDescFilterCheckBox() {
        log.info("Checks Description Checkbox on Counting Sessions page");
        countingSessionsPage.checkProductDescFilterCheckBox();
    }

    @Step
    @And("Checks Counts Checkbox on Counting Sessions page")
    public void checkCountFilterCheckBox() {
        log.info("Checks Counts Checkbox on Counting Sessions page");
        countingSessionsPage.checkCountFilterCheckBox();
    }

    @Step
    @And("Checks Book Cost Checkbox on Counting Sessions page")
    public void checkBookCostFilterCheckBox() {
        log.info("Checks Book Cost Checkbox on Counting Sessions page");
        countingSessionsPage.checkBookCostFilterCheckBox();
    }

    @Step
    @And("Checks Product Type Checkbox on Counting Sessions page")
    public void checkProductTypeFilterCheckBox() {
        log.info("Checks Product Type Checkbox on Counting Sessions page");
        countingSessionsPage.checkProductTypeFilterCheckBox();
    }

    @Step
    @And("Types Product {string} on Counting Sessions page")
    public void typesProductCodeFilter(String filter) {
        log.info("Types Product on Counting Sessions page");
        countingSessionsPage.typeFilter(filter);
    }

    @Step
    @And("Types Owner {string} on Counting Sessions page")
    public void typesOwnerCodeFilter(String filter) {
        log.info("Types Owner on Counting Sessions page");
        countingSessionsPage.typeFilter(filter);
    }

    @Step
    @And("Types Description {string} on Counting Sessions page")
    public void typesDescriptionCodeFilter(String filter) {
        log.info("Types Description on Counting Sessions page");
        countingSessionsPage.typeFilter(filter);
    }

    @Step
    @And("Types Counts {string} on Counting Sessions page")
    public void typesCountsCodeFilter(String filter) {
        log.info("Types Counts on Counting Sessions page");
        countingSessionsPage.typeFilter(filter);
    }

    @Step
    @And("Types Book cost {string} on Counting Sessions page")
    public void typesBookCostCodeFilter(String filter) {
        log.info("Types Book cost on Counting Sessions page");
        countingSessionsPage.typeFilter(filter);
    }

    @Step
    @And("Types Product type {string} on Counting Sessions page")
    public void typesProductTypeCodeFilter(String filter) {
        log.info("Types Product type on Counting Sessions page");
        countingSessionsPage.typeFilter(filter);
    }

    @Step
    @And("Types Tasks {string} per Assignment on Counting Sessions page")
    public void typeTasksPerAssignments(String task) {
        log.info("Types Tasks Per Assignment on Counting Sessions page");
        countingSessionsPage.typeTasksPerAssignment(task);
    }

    @Step
    @And("Clears Tasks per Assignment on Counting Sessions page")
    public void clearTasksPerAssignment() {
        log.info("Clears Tasks Per Assignment on Counting Sessions page");
        countingSessionsPage.clearTasksPerAssignment();
    }

    @Step
    @And("Clicks User directed counting radio button on Counting Sessions page")
    public void clickUserDirectedCountingButton() {
        log.info("Clicks User directed counting radio button on Counting Sessions page");
        countingSessionsPage.clickUserDirectedCountingButton();
    }

    @Step
    @And("Clicks Apply Button on Counting Sessions page")
    public void clickApplyButton() {
        log.info("Clicks Apply Button on Counting Sessions page");
        countingSessionsPage.clickApplyButton();
    }

    @Step
    @And("Clicks Clear All Button on Counting Sessions page")
    public void clickClearAllButton() {
        log.info("Clicks Clear All Button on Counting Sessions page");
        countingSessionsPage.clickClearAllButton();
    }

    @Step
    @And("Clicks Add Product Button on Counting Sessions page")
    public void clickAddProductButton() {
        log.info("Clicks Add Product Button on Counting Sessions page");
        countingSessionsPage.clickAddProductButton();
    }

    @Step
    @And("Types {string} number of products on Counting Sessions page")
    public void typeNumberOfProducts(String numOfProds) {
        log.info("Types number of products on Counting Sessions page");
        countingSessionsPage.typeNumberOfProducts(numOfProds);
    }

    @Step
    @And("Selects {string} product type on Counting Sessions page")
    public void selectProductType(String type) {
        log.info("Selects product type on Counting Sessions page");
        countingSessionsPage.selectProductType(type);
    }

    @Step
    @And("Selects {string} movement class on Counting Sessions page")
    public void selectMovementClass(String type) {
        log.info("Selects movement class on Counting Sessions page");
        countingSessionsPage.selectMovementClass(type);
    }

    @Step
    @And("Types product {string} on Counting Sessions page")
    public void typeProduct(String product) {
        log.info("Types product on Counting Sessions page");
        countingSessionsPage.typeProduct(product);
    }

    @Step
    @And("Types {string} minimum cost on Counting Sessions page")
    public void typeMinimumCost(String cost) {
        log.info("Types minimum cost on Counting Sessions page");
        countingSessionsPage.typeMinimumCost(cost);
    }

    @Step
    @And("Types {string} maximum cost on Counting Sessions page")
    public void typeMaximumCost(String cost) {
        log.info("Types maximum cost on Counting Sessions page");
        countingSessionsPage.typeMaximumCost(cost);
    }

    @Step
    @And("Selects {string} owner dropdown on Counting Sessions page")
    public void selectOwnerDropdown(String owner) {
        log.info("Selects owner dropdown on Counting Sessions page");
        countingSessionsPage.selectOwnerDropdown(owner);
    }

    @Step
    @And("Types {string} supplier on Counting Sessions page")
    public void typeSupplier(String owner) {
        log.info("Types supplier on Counting Sessions page");
        countingSessionsPage.typeSupplier(owner);
    }

    @Step
    @And("Types {string} starting product range on Counting Sessions page")
    public void typeStartingProdRange(String range) {
        log.info("Types starting product range on Counting Sessions page");
        countingSessionsPage.typeStartingProdRange(range);
    }

    @Step
    @And("Types {string} ending product range on Counting Sessions page")
    public void typeEndingProdRange(String range) {
        log.info("Types ending product range on Counting Sessions page");
        countingSessionsPage.typeEndingProdRange(range);
    }

    @Step
    @And("Types {string} prod alias type on Counting Sessions page")
    public void selectProdAliasType(String type) {
        log.info("Types prod alias type on Counting Sessions page");
        countingSessionsPage.selectProdAliasType(type);
    }

    @Step
    @And("Types {string} inventory status on Counting Sessions page")
    public void selectInventoryStatus(String type) {
        log.info("Types inventory status on Counting Sessions page");
        countingSessionsPage.selectInventoryStatus(type);
    }

    @Step
    @And("Waits for Loading image to disappear on Counting Sessions page")
    public void waitForLoadingImageToDisappear() {
        log.info("Waits for Loading image to disappear on Counting Sessions page");
        countingSessionsPage.waitForLoadingImageToDisappear();
    }

    @Step
    @And("Clicks All Checkbox button on Counting Sessions page")
    public void clickAllCheckboxButton() {
        log.info("Clicks All Checkbox button on Counting Sessions page");
        countingSessionsPage.clickAllCheckboxButton();
    }

    @Step
    @And("Clicks Delete products button on Counting Sessions page")
    public void clickProductRemoveButton() {
        log.info("Clicks Delete products button on Counting Sessions page");
        countingSessionsPage.clickProductRemoveButton();
    }

    @Step
    @And("Clicks Reset products button on Counting Sessions page")
    public void clickProductResetButton() {
        log.info("Clicks Reset products button on Counting Sessions page");
        countingSessionsPage.clickProductResetButton();
    }

    @Step
    @And("Clicks Generate locations button on Counting Sessions page")
    public void clickProductLocationsButton() {
        log.info("Clicks Generate locations button on Counting Sessions page");
        countingSessionsPage.clickProductLocationsButton();
    }

    @Step
    @And("Clicks Delete button on Counting Sessions page")
    public void clickDeleteAssignmentBtn() {
        log.info("Clicks Delete button on Counting Sessions page");
        countingSessionsPage.clickDeleteAssignmentBtn();
    }

    @Step
    @And("Clicks Release button on Counting Sessions page")
    public void clickReleaseAssignmentBtn() {
        log.info("Clicks Release button on Counting Sessions page");
        countingSessionsPage.clickReleaseAssignmentBtn();
    }

    @Step
    @And("User types future Release date in {int} days on Counting Sessions page")
    public void typesFutureDate(int days) {
        log.info("User types Release Date in " + days + " days");
        countingSessionsPage.enterDate(TimeConversion.futureDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
    }

    @Step
    @And("User types future Release time {string} days on Counting Sessions page")
    public void typesFutureTime(String time) {
        log.info("User types Release time " + time);
        countingSessionsPage.enterTime(time);
    }

    @Step
    @And("Selects user {string} days on Counting Sessions page")
    public void selectUser(String user) {
        log.info("Selects user " + user);
        countingSessionsPage.selectUser(user);
    }

    @Step
    @And("Removes date and time on Counting Sessions page")
    public void removeDateAndTime() {
        log.info("Removes date and time on Counting Sessions page");
        countingSessionsPage.removeDateAndTime();
    }

}
