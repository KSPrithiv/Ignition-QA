package steps.counting.counting;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.countingcount.CountingCountDTO;
import ui.pages.counting.counting.CountingCountPage;

import java.util.List;

@Slf4j
public class CountingCountPageSteps {
    CountingCountPage countingCountPage = new CountingCountPage();
    CountingCountDTO countingCountDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.COUNTING_COUNT_DATA, CountingCountDTO.class);

    @Step
    @And("Waits for Counting Count page to load")
    public void waitForCountingCountPageToLoad() {
        log.info("Waiting for Counting Count Page To Load");
        countingCountPage.waitCountingCountPageToLoad();
    }

    @Step
    @And("User selects warehouse {string} on Counting Count page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse on Counting Count page");
        countingCountPage.selectWarehouse(warehouse);
    }

    @Step
    @And("User selects warehouse by index {int} on Counting Count page")
    public void selectWarehouseByIndex(int index) {
        log.info("User selects warehouse by index on Counting Count page");
        List<String> warehouses = List.of(countingCountDTO.getWarehouses().getWarehouse1(), countingCountDTO.getWarehouses()
               .getWarehouse2(), countingCountDTO.getWarehouses().getWarehouse3(), countingCountDTO.getWarehouses()
               .getWarehouse4(), countingCountDTO.getWarehouses().getWarehouse5());
        countingCountPage.selectWarehouse(warehouses.get(index));
    }

    @Step
    @And("User selects session {string} on Counting Count page")
    public void selectSession(String session) {
        log.info("User selects session on Counting Count page");
        countingCountPage.selectSession(session);
    }

    @Step
    @And("User selects session by index {int} on Counting Count page")
    public void selectSessionByIndex(int index) {
        log.info("User selects session by index on Counting Count page");
        List<String> sessions = List.of(countingCountDTO.getSessions().getSession1(), countingCountDTO.getSessions()
                .getSession2(), countingCountDTO.getSessions().getSession3(), countingCountDTO.getSessions().getSession4(),
                countingCountDTO.getSessions().getSession5());
        countingCountPage.selectSession(sessions.get(index));
    }

    @Step
    @And("User selects assignment {string} on Counting Count page")
    public void selectAssignment(String assignment) {
        log.info("User selects assignment on Counting Count page");
        countingCountPage.selectAssignment(assignment);
    }

    @Step
    @And("User clicks Session dropdown on Counting Count page")
    public void clickSessionDropdown() {
        log.info("User clicks Session dropdown on Counting Count page");
        countingCountPage.clickSessionDropdown();
    }

    @Step
    @And("User clicks Location filter on Counting Count page")
    public void clickLocationFilter() {
        log.info("User clicks Location filter on Counting Count page");
        countingCountPage.clickLocationFilter();
    }

    @Step
    @And("User clicks Product filter on Counting Count page")
    public void clickProductFilter() {
        log.info("User clicks Product filter on Counting Count page");
        countingCountPage.clickProductFilter();
    }

    @Step
    @And("User clicks UPC Filter on Counting Count page")
    public void clickUpcFilter() {
        log.info("User clicks UPC Filter on Counting Count page");
        countingCountPage.clickUpcFilter();
    }

    @Step
    @And("User clicks Description filter on Counting Count page")
    public void clickDescriptionFilter() {
        log.info("User clicks Description filter on Counting Count page");
        countingCountPage.clickDescriptionFilter();
    }

    @Step
    @And("User clicks On-Hand filter on Counting Count page")
    public void clickOnHandFilter() {
        log.info("User clicks On-Hand filter on Counting Count page");
        countingCountPage.clickOnHandFilter();
    }

    @Step
    @And("User clicks Counted filter on Counting Count page")
    public void clickCountedFilter() {
        log.info("User clicks Counted filter on Counting Count page");
        countingCountPage.clickCountedFilter();
    }

    @Step
    @And("User clicks UOM filter on Counting Count page")
    public void clickUomFilter() {
        log.info("User clicks UOM filter on Counting Count page");
        countingCountPage.clickUomFilter();
    }

    @Step
    @And("User clicks Clear button on Counting Count page")
    public void clickClearButton() {
        log.info("User clicks Clear button on Counting Count page");
        countingCountPage.clickClearButton();
    }

    @Step
    @And("User clicks Clear All button on Counting Count page")
    public void clickClearAllButton() {
        log.info("User clicks Clear All button on Counting Count page");
        countingCountPage.clickClearAllButton();
    }

    @Step
    @And("User clicks location {string} on Counting Count page")
    public void clickLocationRow(String location) {
        log.info("User clicks location on Counting Count page");
        countingCountPage.clickLocation(location);
    }

    @Step
    @And("User clicks location by index {int} on Counting Count page")
    public void clickLocationRowByIndex(int index) {
        log.info("User clicks location by index on Counting Count page");
        List<String> locations = List.of(countingCountDTO.getLocationCodes().getLocationCode1(), countingCountDTO
                .getLocationCodes().getLocationCode2(), countingCountDTO.getLocationCodes().getLocationCode3(),
                countingCountDTO.getLocationCodes().getLocationCode4(), countingCountDTO.getLocationCodes().getLocationCode5(),
                countingCountDTO.getLocationCodes().getLocationCode6());
        countingCountPage.clickLocation(locations.get(index));
    }

    @Step
    @And("User clicks Apply button on Counting Count page")
    public void clickApplyButton() {
        log.info("User clicks Apply button on Counting Count page");
        countingCountPage.clickApplyButton();
    }

    @Step
    @And("User clicks Add Filter on Counting Count page")
    public void clickAddFilterButton() {
        log.info("User clicks Add Filter on Counting Count page");
        countingCountPage.clickAddFilterButton();
    }

    @Step
    @And("User types {string} filter on Counting Count page")
    public void typeFilter(String filter) {
        log.info("User types filter on Counting Count page");
        countingCountPage.typeFilter(filter);
    }

    @Step
    @And("User types UPC filter by index {int} on Counting Count page")
    public void typeUPCFilterByIndex(int index) {
        log.info("User types UPC filter by index on Counting Count page");
        List<String> upces = List.of(countingCountDTO.getUpc().getUPC1(), countingCountDTO.getUpc().getUPC2(),
                countingCountDTO.getUpc().getUPC3(), countingCountDTO.getUpc().getUPC4(), countingCountDTO.getUpc()
                .getUPC5(), countingCountDTO.getUpc().getUPC6());
        countingCountPage.typeFilter(upces.get(index));
    }

    @Step
    @And("User types UOM filter by index {int} on Counting Count page")
    public void typeUOMFilterByIndex(int index) {
        log.info("User types UOM filter by index on Counting Count page");
        List<String> uoms = List.of(countingCountDTO.getUom().getUom1(), countingCountDTO.getUom().getUom2(),
                countingCountDTO.getUom().getUom3(), countingCountDTO.getUom().getUom4());
        countingCountPage.typeFilter(uoms.get(index));
    }

    @Step
    @And("User types Location filter by index {int} on Counting Count page")
    public void typeLocationFilterByIndex(int index) {
        log.info("User types Location filter by index on Counting Count page");
        List<String> locations = List.of(countingCountDTO.getLocationCodes().getLocationCode1(), countingCountDTO
               .getLocationCodes().getLocationCode2(), countingCountDTO.getLocationCodes().getLocationCode3(),
               countingCountDTO.getLocationCodes().getLocationCode4(), countingCountDTO.getLocationCodes().getLocationCode5(),
               countingCountDTO.getLocationCodes().getLocationCode6());
        countingCountPage.typeFilter(locations.get(index));
    }

    @Step
    @And("User types Product filter by index {int} on Counting Count page")
    public void typeProductFilterByIndex(int index) {
        log.info("User types Product filter by index on Counting Count page");
        List<String> products = List.of(countingCountDTO.getProducts().getProduct1(), countingCountDTO.getProducts()
                .getProduct2(), countingCountDTO.getProducts().getProduct3(), countingCountDTO.getProducts().getProduct4(),
                countingCountDTO.getProducts().getProduct5());
        countingCountPage.typeFilter(products.get(index));
    }

    @Step
    @And("User types {string} quantity in {int} input on Counting Count page")
    public void typeQuantity(String amount, int index) {
        log.info("User types quantity on Counting Count page");
        countingCountPage.typeQuantity(amount, index);
    }

    @Step
    @And("User clicks Add Product on Counting Count page")
    public void clickAddProduct() {
        log.info("User clicks Add Product on Counting Count page");
        countingCountPage.clickAddProduct();
    }

    @Step
    @And("User types product {string} on Counting Count page")
    public void typeProduct(String product) {
        log.info("User types product on Counting Count page");
        countingCountPage.typeProduct(product);
    }

    @Step
    @And("User types product by index {int} on Counting Count page")
    public void typeProduct(int index) {
        log.info("User types product by index on Counting Count page");
        List<String> products = List.of(countingCountDTO.getProducts().getProduct1(), countingCountDTO.getProducts()
                .getProduct2(), countingCountDTO.getProducts().getProduct3(), countingCountDTO.getProducts().getProduct4(),
                countingCountDTO.getProducts().getProduct5());
        countingCountPage.typeProduct(products.get(index));
    }

    @Step
    @And("User selects owner by index {int} on Counting Count page")
    public void selectOwnerByIndex(int index) {
        log.info("User selects owner by index on Counting Count page");
        List<String> owners = List.of(countingCountDTO.getOwners().getOwner1(), countingCountDTO.getOwners().getOwner2(),
                countingCountDTO.getOwners().getOwner3(), countingCountDTO.getOwners().getOwner4(), countingCountDTO
                .getOwners().getOwner5());
        countingCountPage.selectOwner(owners.get(index));
    }

    @Step
    @And("User selects owner {string} on Counting Count page")
    public void selectOwner(String owner) {
        log.info("User selects owner on Counting Count page");
        countingCountPage.selectOwner(owner);
    }

    @Step
    @And("User selects supplier by index {int} on Counting Count page")
    public void selectSupplierByIndex(int index) {
        log.info("User selects supplier by index on Counting Count page");
        List<String> suppliers = List.of(countingCountDTO.getSuppliers().getSupplier1(), countingCountDTO.getSuppliers()
                .getSupplier2(), countingCountDTO.getSuppliers().getSupplier3(), countingCountDTO.getSuppliers()
                .getSupplier4(), countingCountDTO.getSuppliers().getSupplier5());
        countingCountPage.selectSupplier(suppliers.get(index));
    }

    @Step
    @And("User selects supplier {string} on Counting Count page")
    public void selectSupplier(String supplier) {
        log.info("User selects supplier on Counting Count page");
        countingCountPage.selectSupplier(supplier);
    }

    @Step
    @And("User types qty {string} on Counting Count page")
    public void typeQty(String qty) {
        log.info("User types qty on Counting Count page");
        countingCountPage.typeQty(qty);
    }

    @Step
    @And("User selects UOM by index {int} on Counting Count page")
    public void selectUOMByIndex(int index) {
        log.info("User selects UOM by index on Counting Count page");
        List<String> uoms = List.of(countingCountDTO.getUom().getUom1(), countingCountDTO.getUom().getUom2(),
                countingCountDTO.getUom().getUom3(), countingCountDTO.getUom().getUom4());
        countingCountPage.selectUOM(uoms.get(index));
    }

    @Step
    @And("User selects UOM {string} on Counting Count page")
    public void selectUOM(String uom) {
        log.info("User selects UOM on Counting Count page");
        countingCountPage.selectUOM(uom);
    }

    @Step
    @And("User selects status by index {int} on Counting Count page")
    public void selectProductStatusByIndex(int index) {
        log.info("User selects status by index on Counting Count page");
        List<String> statuses = List.of(countingCountDTO.getProductStatuses().getInventoryStatus1(), countingCountDTO
                .getProductStatuses().getInventoryStatus2(), countingCountDTO.getProductStatuses().getInventoryStatus3(),
                countingCountDTO.getProductStatuses().getInventoryStatus4(), countingCountDTO.getProductStatuses()
                .getInventoryStatus5());
        countingCountPage.selectProductStatus(statuses.get(index));
    }

    @Step
    @And("User selects status {string} on Counting Count page")
    public void selectProductStatus(String status) {
        log.info("User selects status on Counting Count page");
        countingCountPage.selectProductStatus(status);
    }

    @Step
    @And("User types date code {string} on Counting Count page")
    public void typeDateCode(String code) {
        log.info("User types date code on Counting Count page");
        countingCountPage.typeDateCode(code);
    }

    @Step
    @And("Clicks Cancel button on Counting Count page")
    public void clickCancel() {
        log.info("User clicks Cancel button on Counting Count page");
        countingCountPage.clickCancel();
    }

}
