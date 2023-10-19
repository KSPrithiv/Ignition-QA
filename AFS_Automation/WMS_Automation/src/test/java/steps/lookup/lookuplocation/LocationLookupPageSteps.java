package steps.lookup.lookuplocation;

import common.constants.FilePaths;
import common.constants.TimeFormats;
import common.utils.objectmapper.ObjectMapperWrapper;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.countingsessions.CountingSessionsDTO;
import objects.lookupproductslocationsdata.LookupDataDTO;
import ui.pages.lookup.lookuplocation.LocationLookupPage;

import java.util.Calendar;
import java.util.List;

@Slf4j
public class LocationLookupPageSteps {
    LocationLookupPage locationLookupPage = new LocationLookupPage();
    LookupDataDTO lookupDataDTO = new ObjectMapperWrapper().getObject(FilePaths.LOOKUP_DATA, LookupDataDTO.class);

    @Step
    @And("Waits for Location Lookup page to load")
    public void waitForLocationLookupPageToLoad() {
        log.info("Waiting for Location Lookup page to load");
        locationLookupPage.waitForLocationLookupPageToLoad();
    }

    @Step
    @And("User types location {string} on Lookup Location page")
    public void typeLocation(String location) {
        log.info("User types location on Lookup Location page");
        locationLookupPage.typeLocation(location);
    }

    @Step
    @And("User types location by index {int} on Lookup Location page")
    public void typeLocationByIndex(int index) {
        log.info("User types location on Lookup Location page");
        List<String> locations = List.of(lookupDataDTO.getLookupLocations().getLookupLocation1(), lookupDataDTO
                .getLookupLocations().getLookupLocation2(), lookupDataDTO.getLookupLocations().getLookupLocation3(),
                 lookupDataDTO.getLookupLocations().getLookupLocation4(), lookupDataDTO.getLookupLocations()
                .getLookupLocation5());
        locationLookupPage.typeLocation(locations.get(index));
    }

    @Step
    @And("User enters location {string} on Lookup Location page")
    public void enterLocation(String location) {
        log.info("User enters location on Lookup Location page");
        locationLookupPage.enterLocation(location);
    }

    @Step
    @And("User selects warehouse {string} on Lookup Location page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse {string} on Lookup Location page");
        locationLookupPage.selectWarehouse(warehouse);
    }

    @Step
    @And("User clears location on Lookup Location page")
    public void clearLocation() {
        log.info("User clears location on Lookup Location page");
        locationLookupPage.clearLocation();
    }

    @Step
    @And("User clicks location search button on Lookup Location page")
    public void clickLocationSearchButton() {
        log.info("User clicks location search button on Lookup Location page");
        locationLookupPage.clickLocationSearchButton();
    }

    @Step
    @And("User selects location by index {int} on Lookup Location page")
    public void selectLocationByIndex(int index) {
        log.info("User selects location by index on Lookup Location page");
        locationLookupPage.selectLocationByIndex(index);
    }

    @Step
    @And("User types Qty {string} on Lookup Location page")
    public void typeQty(String qty) {
        log.info("User types Qty on Lookup Location page");
        locationLookupPage.typeQty(qty);
    }

    @Step
    @And("User clears Product Qty on Lookup Location page")
    public void clearProductQty() {
        log.info("User clears Product Qty on Lookup Location page");
        locationLookupPage.clearProductQty();
    }

    @Step
    @And("User types Date Code {string} on Lookup Location page")
    public void typeDateCode(String code) {
        log.info("User types Date Code on Lookup Location page");
        locationLookupPage.typeDateCode(code);
    }

    @And("User types Lot {string} on Lookup Location page")
    public void typeAutocompleteLot(String lot) {
        log.info("User types Lot on Lookup Location page");
        locationLookupPage.typeAutocompleteLot(lot);
    }

    @Step
    @And("User types LPN {string} on Lookup Location page")
    public void typeLPN(String code) {
        log.info("User types LPN on Lookup Location page");
        locationLookupPage.typeLPN(code);
    }

    @Step
    @And("User edits LPN {string} on Lookup Location page")
    public void editLPN(String code) {
        log.info("User edits LPN on Lookup Location page");
        locationLookupPage.editLPN(code);
    }

    @Step
    @And("User clears edit LPN on Lookup Location page")
    public void clearEditLPN() {
        log.info("User clears edit LPN on Lookup Location page");
        locationLookupPage.clearEditLPN();
    }

    @Step
    @And("User types Receipt date {string} on Lookup Location page")
    public void typeReceiptDate(String date) {
        log.info("User types Receipt date on Lookup Location page");
        locationLookupPage.typeReceiptDate(date);
    }

    @Step
    @And("User types Expiration date {string} on Lookup Location page")
    public void typeExpDate(String date) {
        log.info("User types Expiration date on Lookup Location page");
        locationLookupPage.typeExpDate(date);
    }

    @Step
    @And("User types Product {string} on Lookup Location page")
    public void typeProduct(String code) {
        log.info("User types Product on Lookup Location page");
        locationLookupPage.typeProduct(code);
    }

    @Step
    @And("User clicks Production Reason dropdown on Lookup Location page")
    public void clickProductionReason() {
        log.info("User clicks Production Reason on Lookup Location page");
        locationLookupPage.clickProductionReason();
    }

    @Step
    @And("Selects Production Reason {string} on Lookup Location page")
    public void selectProductionReason(String reason) {
        log.info("Selects Production Reason on Lookup Location page");
        locationLookupPage.selectProductionReason(reason);
    }

    @Step
    @And("Selects Inventory Reason {string} on Lookup Location page")
    public void selectInventoryReason(String reason) {
        log.info("Selects Inventory Reason on Lookup Location page");
        locationLookupPage.selectInventoryReason(reason);
    }

    @Step
    @And("Selects Receipt date change reason {string} on Lookup Location page")
    public void selectRecDateChangeReason(String reason) {
        log.info("Selects Receipt date change reason on Lookup Location page");
        locationLookupPage.selectRecDateChangeReason(reason);
    }

    @Step
    @And("Selects Expiration date change reason {string} on Lookup Location page")
    public void selectExpDateChangeReason(String reason) {
        log.info("Selects Expiration date change reason on Lookup Location page");
        locationLookupPage.selectExpDateChangeReason(reason);
    }

    @Step
    @And("User clears Product on Lookup Location page")
    public void clearProductInput() {
        log.info("User clears Product on Lookup Location page");
        locationLookupPage.clearProductInput();
    }

    @Step
    @And("User checks Product {string} on Lookup Location page")
    public void checkProduct(String product) {
        log.info("User checks Product on Lookup Location page");
        locationLookupPage.checkProduct(product);
    }

    @Step
    @And("User cleans Location Input on Lookup Location page")
    public void cleanLocationInput() {
        log.info("User cleans Location Input on Lookup Location page");
        locationLookupPage.cleanLocationInput();
    }

    @Step
    @And("User clicks Location Product {int} on Lookup Location page")
    public void typeLocation(int index) {
        log.info("User clicks Location Product on Lookup Location page");
        locationLookupPage.clickLocationProductByIndex(index);
    }

    @Step
    @And("User checks Location Product {int} on Lookup Location page")
    public void checksProductByIndex(int index) {
        log.info("User clicks Location Product on Lookup Location page");
        locationLookupPage.checksProductByIndex(index);
    }

    @Step
    @And("User selects Label type {string} on Lookup Location page")
    public void selectsLabelType(String type) {
        log.info("User selects Label type on Lookup Location page");
        locationLookupPage.selectLabelType(type);
    }

    @Step
    @And("User selects Label type by index {int} on Lookup Location page")
    public void selectsLabelType(int index) {
        log.info("User selects Label type by index on Lookup Location page");
        List<String> labels = List.of(lookupDataDTO.getLookupLocations().getLookupLocation1(), lookupDataDTO
                .getLookupLocations().getLookupLocation2(), lookupDataDTO.getLookupLocations().getLookupLocation3(),
                 lookupDataDTO.getLookupLocations().getLookupLocation4(), lookupDataDTO.getLookupLocations()
                .getLookupLocation5());
        locationLookupPage.selectLabelType(labels.get(index));
    }

    @Step
    @And("User selects Printer {string} on Lookup Location page")
    public void selectPrinter(String printer) {
        log.info("User selects Printer on Lookup Location page");
        locationLookupPage.selectPrinter(printer);
    }

    @Step
    @And("Clicks Label type dropdown on Lookup Location page")
    public void clickLabelTypeDropdown() {
        log.info("Clicks Label type dropdown on Lookup Location page");
        locationLookupPage.clickLabelTypeDropdown();
    }

    @Step
    @And("User clicks Column Header checkbox on Lookup Location page")
    public void clickColumnHeaderCheckBox() {
        log.info("User clicks Column Header checkbox on Lookup Location page");
        locationLookupPage.clickColumnHeaderCheckBox();
    }

    @Step
    @And("User clicks Pallet Type on Add Inventory Lookup Location page")
    public void clickPalletType() {
        log.info("User clicks Pallet Type on Add Inventory Lookup Location page");
        locationLookupPage.clickPalletType();
    }

    @Step
    @And("User clicks Show detail checkbox on Lookup Location page")
    public void clickLookupProductShowPalletCheck() {
        log.info("User clicks Show detail checkbox on Lookup Location page");
        locationLookupPage.clickLookupProductShowPalletCheck();
    }

    @Step
    @And("User clicks Edit button on Lookup Location page")
    public void clickEditButton() {
        log.info("User clicks Edit button on Lookup Location page");
        locationLookupPage.clickEditButton();
    }

    @Step
    @And("User clicks Delete button on Lookup Location page")
    public void clickDeleteButton() {
        log.info("User clicks Delete button on Lookup Location page");
        locationLookupPage.clickDeleteButton();
    }

    @Step
    @And("User clicks Transfer button on Lookup Location page")
    public void clickTransferButton() {
        log.info("User clicks Transfer button on Lookup Location page");
        locationLookupPage.clickTransferButton();
    }

    @Step
    @And("User clicks Status button on Lookup Location page")
    public void clickStatusButton() {
        log.info("User clicks Status button on Lookup Location page");
        locationLookupPage.clickStatusButton();
    }

    @Step
    @And("User clicks Labels button on Lookup Location page")
    public void clickPrintLocButton() {
        log.info("User clicks Labels button on Lookup Location page");
        locationLookupPage.clickPrintLocButton();
    }

    @Step
    @And("User selects Status {string} on Change Status popup on Lookup Location page")
    public void selectChangeStatus(String status) {
        log.info("User selects Status on Change Status popup on Lookup Location page");
        locationLookupPage.selectChangeStatus(status);
    }

    @Step
    @And("User selects Unit status reason {string} on Change Status popup on Lookup Location page")
    public void selectChangeUnitStatusReason(String reason) {
        log.info("User selects Unit status reason on Change Status popup on Lookup Location page");
        locationLookupPage.selectChangeUnitStatusReason(reason);
    }

    @Step
    @And("User clicks Ok button on Lookup Location page")
    public void clickOkButton() {
        log.info("User clicks Ok button on Lookup Location page");
        locationLookupPage.clickOkButton();
    }

    @Step
    @And("User clicks OK button on Lookup Location page")
    public void clickOKButton() {
        log.info("User clicks OK button on Lookup Location page");
        locationLookupPage.clickOKButton();
    }

    @Step
    @And("User clicks Cancel button on Lookup Location page")
    public void clickCancelButton() {
        log.info("User clicks Cancel button on Lookup Location page");
        locationLookupPage.clickCancelButton();
    }

    @Step
    @And("User clicks Save button on Lookup Location page")
    public void clickSaveButton() {
        log.info("User clicks Save button on Lookup Location page");
        locationLookupPage.clickSaveButton();
    }

    @Step
    @And("User clicks Yes button on Lookup Location page")
    public void clickYesButton() {
        log.info("User clicks Yes button on Lookup Location page");
        locationLookupPage.clickYesButton();
    }

    @Step
    @And("User clicks No button on Lookup Location page")
    public void clickNoButton() {
        log.info("User clicks No button on Lookup Location page");
        locationLookupPage.clickNoButton();
    }

    @Step
    @And("User clicks Delete Reason on Lookup Location page")
    public void clickDeleteReason() {
        log.info("User clicks Delete Reason on Lookup Location page");
        locationLookupPage.clickDeleteReason();
    }

    @Step
    @And("User clicks Back on Lookup Location page")
    public void clickBackButton() {
        log.info("User clicks Back on Lookup Location page");
        locationLookupPage.clickBackButton();
    }

    @Step
    @And("User selects Delete Reason {string} on Lookup Location page")
    public void clickDeleteReason(String reason) {
        log.info("User selects Delete Reason on Lookup Location page");
        locationLookupPage.selectDeleteReason(reason);
    }

    @Step
    @And("User selects Date Code Reason {string} on Lookup Location page")
    public void selectDateCodeReason(String reason) {
        log.info("User selects Date Code Reason on Lookup Location page");
        locationLookupPage.selectDateCodeReason(reason);
    }

    @Step
    @And("User selects Status {string} on Lookup Location page")
    public void selectStatus(String status) {
        log.info("User selects Status on Lookup Location page");
        locationLookupPage.selectStatus(status);
    }

    @Step
    @And("Selects Product Status {string} on Lookup Location page")
    public void selectProductStatus(String status) {
        log.info("User selects product status on Lookup Location page");
        locationLookupPage.selectProductStatus(status);
    }

    @Step
    @And("Clicks Add Location button on Lookup Location page")
    public void clickAddLocProdButton() {
        log.info("Clicks Add Location button on Lookup Location page");
        locationLookupPage.clickAddLocProdButton();
    }

    @Step
    @And("User types Future Date in {int} days on Lookup Location page")
    public void typesFutureDate(int days) {
        log.info("User types Future Date in " + days + " days");
        locationLookupPage.enterDate(TimeConversion.futureDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
    }

    @Step
    @And("Selects owner {string} on Lookup Location page")
    public void selectOwner(String owner) {
        log.info("Selects owner on Lookup Location page");
        locationLookupPage.selectOwner(owner);
    }

    @Step
    @And("Selects supplier {string} on Lookup Location page")
    public void selectSupplier(String supplier) {
        log.info("Selects supplier on Lookup Location page");
        locationLookupPage.selectSupplier(supplier);
    }

    @Step
    @And("Clicks supplier on Lookup Location page")
    public void clickSupplier() {
        log.info("Clicks supplier on Lookup Location page");
        locationLookupPage.clickSupplier();
    }

    @Step
    @And("Selects UOM {string} on Lookup Location page")
    public void selectUOM(String uom) {
        log.info("Selects UOM on Lookup Location page");
        locationLookupPage.selectUOM(uom);
    }

    @Step
    @And("Clicks Production on button on Lookup Location page")
    public void clicksProduction() {
        log.info("Clicks Production on button on Lookup Location page");
        locationLookupPage.clickProductionButton();
    }

}
