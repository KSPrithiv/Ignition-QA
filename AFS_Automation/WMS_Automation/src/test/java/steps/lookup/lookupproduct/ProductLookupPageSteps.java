package steps.lookup.lookupproduct;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.lookupproductslocationsdata.LookupProductLocationsDTO;
import ui.pages.lookup.lookupproduct.ProductLookupPage;

import java.util.List;

@Slf4j
public class ProductLookupPageSteps {
    ProductLookupPage productLookupPage = new ProductLookupPage();
    LookupProductLocationsDTO lookupDataDTO = new ObjectMapperWrapper().getObject(FilePaths.LOOKUP_DATA, LookupProductLocationsDTO.class);

    @Step
    @And("Waits for Product Lookup page to load")
    public void waitForOutboundLoadPlanningPageToLoad() {
        log.info("Waiting for Product Lookup page to load");
        productLookupPage.waitForProductLookupPageToLoad();
    }

    @Step
    @And("User clicks Product Lookup page title")
    public void clickProductLookupTitle() {
        log.info("User clicks Product Lookup page title");
        productLookupPage.clickProductLookupTitle();
    }

    @Step
    @And("User clicks History tab on Lookup Product page")
    public void clickHistoryTab() {
        log.info("User clicks History tab on Lookup Product page");
        productLookupPage.clickHistoryTab();
    }

    @Step
    @And("User clicks Setup tab on Lookup Product page")
    public void clickSetUpTab() {
        log.info("User clicks Setup tab on Lookup Product page");
        productLookupPage.clickSetUpTab();
    }

    @Step
    @And("User clicks Allocation tab on Lookup Product page")
    public void clickAllocationTab() {
        log.info("User clicks Allocation tab on Lookup Product page");
        productLookupPage.clickAllocationTab();
    }

    @Step
    @And("User types product {string} on Lookup Product page")
    public void typeProduct(String product) {
        log.info("User types product on Lookup Location page");
        productLookupPage.typeProduct(product);
    }

    @Step
    @And("User deletes product on Lookup Product page")
    public void deleteProduct() {
        log.info("User types product on Lookup Location page");
        productLookupPage.deleteProduct();
    }

    @Step
    @And("User clicks Add Filter on Lookup Product page")
    public void clickAddFilter() {
        log.info("User clicks Add Filter on Lookup Product page");
        productLookupPage.clickAddFilter();
    }

    @Step
    @And("User clicks Add Product on Lookup Product page")
    public void clickAddProductLookupButton() {
        log.info("User clicks Add Product on Lookup Product page");
        productLookupPage.clickAddProductLookupButton();
    }

    @Step
    @And("User clicks product by index {int} on Lookup Product page")
    public void clickProductByProductIndex(int index) {
        log.info("User clicks Add Product on Lookup Product page");
        productLookupPage.clickProductByProductIndex(index);
    }

    @Step
    @And("User clicks Clear All on Lookup Product page")
    public void clickClearAllButton() {
        log.info("User clicks Clear All on Lookup Product page");
        productLookupPage.clickClearAllButton();
    }

    @Step
    @And("User clicks Status button on Lookup Product page")
    public void clickEditLocProdButton() {
        log.info("User clicks Status button on Lookup Product page");
        productLookupPage.clickEditLocProdButton();
    }

    @Step
    @And("User clicks Cancel button on Lookup Product page")
    public void clickCancelButton() {
        log.info("User clicks Cancel button on Lookup Product page");
        productLookupPage.clickCancelButton();
    }

    @Step
    @And("User clicks Save button on Lookup Product page")
    public void clickSaveButton() {
        log.info("User clicks Save button on Lookup Product page");
        productLookupPage.clickSaveButton();
    }

    @Step
    @And("User selects Unit status reason {string} on Change Status popup on Lookup Product page")
    public void selectChangeUnitStatusReason(String reason) {
        log.info("User selects Unit status reason on Change Status popup on Lookup Product page");
        productLookupPage.selectChangeUnitStatusReason(reason);
    }

    @Step
    @And("User selects Unit status reason by index {int} on Change Status popup on Lookup Product page")
    public void selectChangeUnitStatusReason(int index) {
        log.info("User selects Unit status reason by index on Change Status popup on Lookup Product page");
        List<String> reasons = List.of(lookupDataDTO.getLookupUnitStatusReasons().getLookupUnitStatusReason1(), lookupDataDTO
                 .getLookupUnitStatusReasons().getLookupUnitStatusReason2(), lookupDataDTO.getLookupUnitStatusReasons()
                 .getLookupUnitStatusReason3(), lookupDataDTO.getLookupUnitStatusReasons().getLookupUnitStatusReason4(),
                 lookupDataDTO.getLookupUnitStatusReasons().getLookupUnitStatusReason5());
        productLookupPage.selectChangeUnitStatusReason(reasons.get(index));
    }

    @Step
    @And("User selects Status {string} on Change Status popup on Lookup Product page")
    public void selectChangeStatus(String status) {
        log.info("User selects Status on Change Status popup on Lookup Product page");
        productLookupPage.selectChangeStatus(status);
    }

    @Step
    @And("User selects Status by index {int} on Change Status popup on Lookup Product page")
    public void selectChangeStatus(int index) {
        log.info("User selects Status by index on Change Status popup on Lookup Product page");
        List<String> statuses = List.of(lookupDataDTO.getLookupStatuses().getLookupStatus1(), lookupDataDTO.getLookupStatuses()
                .getLookupStatus2(), lookupDataDTO.getLookupStatuses().getLookupStatus3(), lookupDataDTO.getLookupStatuses()
                .getLookupStatus4(), lookupDataDTO.getLookupStatuses().getLookupStatus5(), lookupDataDTO.getLookupStatuses()
                .getLookupStatus6(), lookupDataDTO.getLookupStatuses().getLookupStatus7());
        productLookupPage.selectChangeStatus(statuses.get(index));
    }

    @Step
    @And("Selects checkbox {int} on Lookup Product page")
    public void selectCheckBoxOptionByIndex(int index) {
        log.info("Selects Checkbox on Lookup Product page");
        productLookupPage.selectCheckBoxOptionByIndex(index);
    }

    @Step
    @And("User checks Warehouse checkbox on Lookup Product page")
    public void checkWarehouseIdFilterCheckBox() {
        log.info("User checks Warehouse checkbox on Lookup Product page");
        productLookupPage.checkWarehouseIdFilterCheckBox();
    }

    @Step
    @And("User checks Owner checkbox on Lookup Product page")
    public void checkOwnerIdFilterCheckBox() {
        log.info("User checks Owner checkbox on Lookup Product page");
        productLookupPage.checkOwnerIdFilterCheckBox();
    }

    @Step
    @And("User checks Location checkbox on Lookup Product page")
    public void checkLocationFilterCheckBox() {
        log.info("User checks Location checkbox on Lookup Product page");
        productLookupPage.checkLocationFilterCheckBox();
    }

    @Step
    @And("User checks Location Type checkbox on Lookup Product page")
    public void checkLocationTypeFilterCheckBox() {
        log.info("User checks Location Type checkbox on Lookup Product page");
        productLookupPage.checkLocationTypeFilterCheckBox();
    }

    @Step
    @And("User checks Qty checkbox on Lookup Product page")
    public void checkQtyFilterCheckBox() {
        log.info("User checks Qty checkbox on Lookup Product page");
        productLookupPage.checkQtyFilterCheckBox();
    }

    @Step
    @And("User checks UOM checkbox on Lookup Product page")
    public void checkUomFilterCheckBox() {
        log.info("User checks UOM checkbox on Lookup Product page");
        productLookupPage.checkUomFilterCheckBox();
    }

    @Step
    @And("User selects warehouse {string} on Lookup Product page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse on Lookup Product page");
        productLookupPage.selectWarehouse(warehouse);
    }

    @Step
    @And("User checks Task Type checkbox on Lookup Product page")
    public void checkTaskTypeFilterCheckBox() {
        log.info("User checks Task Type checkbox on Lookup Product page");
        productLookupPage.checkTaskTypeFilterCheckBox();
    }

    @Step
    @And("User checks Destination checkbox on Lookup Product page")
    public void checkDestinationFilterCheckBox() {
        log.info("User checks Destination checkbox on Lookup Product page");
        productLookupPage.checkDestinationFilterCheckBox();
    }

    @Step
    @And("User checks Received checkbox on Lookup Product page")
    public void checkReceivedFilterCheckBox() {
        log.info("User checks Received checkbox on Lookup Product page");
        productLookupPage.checkReceivedFilterCheckBox();
    }

    @Step
    @And("User checks Lot checkbox on Lookup Product page")
    public void checkLotFilterCheckBox() {
        log.info("User checks Lot checkbox on Lookup Product page");
        productLookupPage.checkLotFilterCheckBox();
    }

    @Step
    @And("User checks Expiry Date checkbox on Lookup Product page")
    public void checkExpiryDateFilterCheckBox() {
        log.info("User checks Expiry Date checkbox on Lookup Product page");
        productLookupPage.checkExpiryDateFilterCheckBox();
    }

    @Step
    @And("User checks Status checkbox on Lookup Product page")
    public void checkStatusIdFilterCheckBox() {
        log.info("User checks Status checkbox on Lookup Product page");
        productLookupPage.checkStatusIdFilterCheckBox();
    }

    @Step
    @And("User checks Weight checkbox on Lookup Product page")
    public void checkWeightFilterCheckBox() {
        log.info("User checks Weight checkbox on Lookup Product page");
        productLookupPage.checkWeightFilterCheckBox();
    }

    @Step
    @And("User checks Staged checkbox on Lookup Product page")
    public void checkStagedFilterCheckBox() {
        log.info("User checks Staged checkbox on Lookup Product page");
        productLookupPage.checkStagedFilterCheckBox();
    }

    @Step
    @And("Clicks Apply Button on Lookup Product page")
    public void clickApplyButton() {
        log.info("Clicks Apply Button on Lookup Product page");
        productLookupPage.clickApplyButton();
    }

    @Step
    @And("Types Qty in range from {string} to {string} on Lookup Product page")
    public void typeAmountRange(String amountFrom, String amountTo) {
        log.info("Types Qty in range on Lookup Product page");
        productLookupPage.typeAmountRange(amountFrom, amountTo);
    }

    @Step
    @And("Types Received From date {string} on Lookup Product page")
    public void typeReceivedFrom(String date) {
        log.info("Types Received From date on Lookup Product page");
        productLookupPage.typeFromDate(date);
    }

    @Step
    @And("Types Received Till date {string} on Lookup Product page")
    public void typeReceivedTill(String date) {
        log.info("Types Received Till date on Lookup Product page");
        productLookupPage.typeTillDate(date);
    }

    @Step
    @And("Types From Exp Date {string} on Lookup Product page")
    public void typeExpDateFrom(String date) {
        log.info("Types From Exp date on Lookup Product page");
        productLookupPage.typeFromDate(date);
    }

    @Step
    @And("Types Till Exp Date {string} on Lookup Product page")
    public void typeExpDateTill(String date) {
        log.info("Types Till Exp Date on Lookup Product page");
        productLookupPage.typeTillDate(date);
    }

    @Step
    @And("Types Location {string} on Lookup Product page")
    public void typeLocationFilter(String filter) {
        log.info("Types Location on Lookup Product page");
        productLookupPage.typeFilter(filter);
    }

    @Step
    @And("Types Location Type {string} on Lookup Product page")
    public void typeLocationTypeFilter(String filter) {
        log.info("Types Location Type on Lookup Product page");
        productLookupPage.typeFilter(filter);
    }

    @Step
    @And("Types UOM {string} on Lookup Product page")
    public void typeUomFilter(String filter) {
        log.info("Types UOM on Lookup Product page");
        productLookupPage.typeFilter(filter);
    }

    @Step
    @And("Types Task Type {string} on Lookup Product page")
    public void typeTaskTypeFilter(String filter) {
        log.info("Types Task Type on Lookup Product page");
        productLookupPage.typeFilter(filter);
    }

    @Step
    @And("Types Destination {string} on Lookup Product page")
    public void typeDestinationFilter(String filter) {
        log.info("Types Destination on Lookup Product page");
        productLookupPage.typeFilter(filter);
    }

    @Step
    @And("Types Staged {string} on Lookup Product page")
    public void typeStagedFilter(String filter) {
        log.info("Types Staged on Lookup Product page");
        productLookupPage.typeFilter(filter);
    }

}
