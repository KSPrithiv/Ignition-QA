package steps.counting.sessions;

import common.constants.FilePaths;
import common.constants.TimeFormats;
import common.utils.objectmapper.ObjectMapperWrapper;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.countingsessions.CountingSessionsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.counting.sessions.CountingSessionsPage;

import java.util.Calendar;
import java.util.List;

@Slf4j
public class CountingSessionsPageSteps {
    private static final Logger LOG = LoggerFactory.getLogger(CountingSessionsPageSteps.class);
    CountingSessionsPage countingSessionsPage = new CountingSessionsPage();
    CountingSessionsDTO countingSessionsDTO = new ObjectMapperWrapper()
                .getObject(FilePaths.COUNTING_SESSIONS_DATA, CountingSessionsDTO.class);

    @Step
    @And("Waits for Counting Sessions page to load")
    public void waitForCountingSessionsPageToLoad() {
        LOG.info("Waiting for Counting Sessions page to load");
        countingSessionsPage.waitCountingSessionsPageToLoad();
    }

    @Step
    @And("User selects warehouse {string} on Counting Sessions page")
    public void selectWarehouse(String warehouse) {
        LOG.info("User selects warehouse on Counting Sessions page");
        countingSessionsPage.selectWarehouse(warehouse);
    }

    @Step
    @And("User clicks session dropdown on Counting Sessions page")
    public void clickSessionDropdown() {
        LOG.info("User clicks session dropdown on Counting Sessions page");
        countingSessionsPage.clickSessionDropdown();
    }

    @Step
    @And("User clicks Select All Checkbox on Counting Sessions page")
    public void clickSelectAllCheckbox() {
        LOG.info("User clicks Select All Checkbox on Counting Sessions page");
        countingSessionsPage.clickSelectAllCheckbox();
    }

    @Step
    @And("User clicks Unselect All Checkbox on Counting Sessions page")
    public void clickUnselectAllCheckbox() {
        LOG.info("User clicks Unselect All Checkbox on Counting Sessions page");
        countingSessionsPage.clickUnselectAllCheckbox();
    }

    @Step
    @And("User clicks session page title on Counting Sessions page")
    public void clickSessionsPageTitle() {
        LOG.info("User clicks session page title on Counting Sessions page");
        countingSessionsPage.clickSessionsPageTitle();
    }

    @Step
    @And("User selects randomly created session on Counting Sessions page")
    public void selectRandomlyCreatedSession() {
        LOG.info("User selects randomly created session on Counting Sessions page");
        String session = countingSessionsPage.getSession();
        countingSessionsPage.selectSession(session);
    }

    @Step
    @And("User selects session {string} on Counting Sessions page")
    public void selectSession(String session) {
        LOG.info("User selects session on Counting Sessions page");
        countingSessionsPage.selectSession(session);
    }

    @Step
    @And("User selects session with index {int} on Counting Sessions page")
    public void selectSessionWithIndex(int index) {
        LOG.info("User selects session with index on Counting Sessions page");
        List<String> sessions = List.of(countingSessionsDTO.getSessions().getSession1(), countingSessionsDTO.getSessions()
            .getSession2(), countingSessionsDTO.getSessions().getSession3(), countingSessionsDTO.getSessions().getSession4(),
            countingSessionsDTO.getSessions().getSession5());
        countingSessionsPage.selectSession(sessions.get(index));
    }

    @Step
    @And("User checks table row by index {int} on Counting Sessions page")
    public void selectTableRowByIndex(int index) {
        LOG.info("User checks table row by index on Counting Sessions page");
        countingSessionsPage.selectTableRowByIndex(index);
    }

    @Step
    @And("User clicks table location by index {int} on Counting Sessions page")
    public void clickTableLocationByIndex(int index) {
        LOG.info("User clicks table location by index on Counting Sessions page");
        countingSessionsPage.clickTableLocationByIndex(index);
    }

    @Step
    @And("User clicks table count by index {int} on Counting Sessions page")
    public void selectTableCountByIndex(int index) {
        LOG.info("User clicks table count by index on Counting Sessions page");
        countingSessionsPage.selectTableCountByIndex(index);
    }

    @Step
    @And("User clicks all inputs checkbox on Count details popup on Counting Sessions page")
    public void clickAllInputsCheckbox() {
        LOG.info("User clicks all inputs checkbox on Count details popup on Counting Sessions page");
        countingSessionsPage.clickAllInputsCheckbox();
    }

    @Step
    @And("User clicks Add location button on Counting Sessions page")
    public void getLocationAdd() {
        LOG.info("User clicks Add location button on Counting Sessions page");
        countingSessionsPage.clickLocationAdd();
    }

    @Step
    @And("User clicks New Session button on Counting Sessions page")
    public void clickNewSession() {
        LOG.info("User clicks New Session button on Counting Sessions page");
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
        LOG.info("User types session name on Counting Sessions page");
        countingSessionsPage.typeSessionName(name);
    }

    @Step
    @And("User types randomly created session name on Counting Sessions page")
    public void typeRandomSessionName() {
        LOG.info("User types randomly created session name on Counting Sessions page");
        countingSessionsPage.typeRandomSessionName();
    }

    @Step
    @And("User types count type {string} on Counting Sessions page")
    public void selectCountType(String type) {
        LOG.info("User types count type on Counting Sessions page");
        countingSessionsPage.selectCountType(type);
    }

    @Step
    @And("User types count type {int} on Counting Sessions page")
    public void selectCountTypeWithIndex(int index) {
        LOG.info("User types count type with index on Counting Sessions page");
        List<String> types = List.of(countingSessionsDTO.getCountTypes().getCountType1(), countingSessionsDTO.getCountTypes().getCountType2(),
                countingSessionsDTO.getCountTypes().getCountType3(), countingSessionsDTO.getCountTypes().getCountType4());
        countingSessionsPage.selectCountType(types.get(index));
    }

    @Step
    @And("User selects reason {string} on Counting Sessions page")
    public void selectDeleteReason(String reason) {
        LOG.info("User selects reason on Counting Sessions page");
        countingSessionsPage.selectDeleteReason(reason);
    }

    @Step
    @And("User clicks OK button on Counting Sessions page")
    public void clickOKButton() {
        LOG.info("User clicks OK button on Counting Sessions page");
        countingSessionsPage.clickOKButton();
    }

    @Step
    @And("User clicks Ok button on Counting Sessions page")
    public void clickOkButton() {
        LOG.info("User clicks Ok button on Counting Sessions page");
        countingSessionsPage.clickOkButton();
    }

    @Step
    @And("User clicks Cancel button on Counting Sessions page")
    public void clickCancelButton() {
        LOG.info("User clicks Cancel button on Counting Sessions page");
        countingSessionsPage.clickCancelButton();
    }

    @Step
    @And("User clicks Save button on Counting Sessions page")
    public void clickSaveButton() {
        LOG.info("User clicks Save button on Counting Sessions page");
        countingSessionsPage.clickSaveButton();
    }

    @Step
    @And("User clicks Yes button if need to add on Counting Sessions page")
    public void clickYesButtonIfNeeded() {
        LOG.info("User clicks Yes button if need to add on Counting Sessions page");
        countingSessionsPage.clickYesButtonIfNeeded();
    }

    @Step
    @And("Wait until Loader invisible on Counting Sessions page")
    public void waitUntilLoaderInvisible() {
        LOG.info("Wait until Loader invisible on Counting Sessions page");
        countingSessionsPage.waitUntilLoaderInvisible();
    }

    @Step
    @And("User clicks Yes button on Counting Sessions page")
    public void clickYesButton() {
        LOG.info("User clicks Yes button on Counting Sessions page");
        countingSessionsPage.clickYesButton();
    }

    @Step
    @And("User clicks No button on Counting Sessions page")
    public void clickNoButton() {
        LOG.info("User clicks No button on Counting Sessions page");
        countingSessionsPage.clickNoButton();
    }

    @Step
    @And("User clicks Active checkbox on Counting Sessions page")
    public void clickActiveCheckbox() {
        LOG.info("User clicks Active checkbox on Counting Sessions page");
        countingSessionsPage.clickActiveCheckbox();
    }

    @Step
    @And("User checks All Assignments input on Counting Sessions page")
    public void checkAllAssignments() {
        LOG.info("User checks All Assignments input on Counting Sessions page");
        countingSessionsPage.checkAllAssignments();
    }

    @Step
    @And("User types Location code {string} on Counting Sessions page")
    public void typeLocationCode(String code) {
        LOG.info("User types Location code on Counting Sessions page");
        countingSessionsPage.typeLocationCode(code);
    }

    @Step
    @And("User types Location code with index {int} on Counting Sessions page")
    public void typeRandomLocationCode(int index) {
        LOG.info("User types Location code with index on Counting Sessions page");
        List<String> codes = List.of(countingSessionsDTO.getLocationCodes().getLocationCode1(), countingSessionsDTO
           .getLocationCodes().getLocationCode2(), countingSessionsDTO.getLocationCodes().getLocationCode3(),
            countingSessionsDTO.getLocationCodes().getLocationCode3(), countingSessionsDTO.getLocationCodes().getLocationCode4(),
            countingSessionsDTO.getLocationCodes().getLocationCode5(), countingSessionsDTO.getLocationCodes().getLocationCode6());
        countingSessionsPage.typeLocationCode(codes.get(index));
    }

    @Step
    @And("User selects Location code {string} on Counting Sessions page")
    public void selectLocationCode(String code) {
        LOG.info("User selects Location code on Counting Sessions page");
        countingSessionsPage.selectLocationCode(code);
    }

    @Step
    @And("User selects Location code with index {int} on Counting Sessions page")
    public void selectRandomLocationCode(int index) {
        LOG.info("User selects Location code with index on Counting Sessions page");
        List<String> codes = List.of(countingSessionsDTO.getLocationCodes().getLocationCode1(), countingSessionsDTO
           .getLocationCodes().getLocationCode2(), countingSessionsDTO.getLocationCodes().getLocationCode3(),
           countingSessionsDTO.getLocationCodes().getLocationCode3(), countingSessionsDTO.getLocationCodes().getLocationCode4(),
           countingSessionsDTO.getLocationCodes().getLocationCode5(), countingSessionsDTO.getLocationCodes().getLocationCode6());
        countingSessionsPage.selectLocationCode(codes.get(index));
    }

    @Step
    @And("User clicks Location code button on Counting Sessions page")
    public void clickLocCodeButton() {
        LOG.info("User clicks Location code button on Counting Sessions page");
        countingSessionsPage.clickLocCodeButton();
    }

    @Step
    @And("Selects location by index {int} on Counting Sessions page")
    public void selectTableContentByIndex(int index) {
        LOG.info("Selects location by index on Counting Sessions page");
        countingSessionsPage.selectTableContentByIndex(index);
    }

    @Step
    @And("User types Partial location code {string} on Counting Sessions page")
    public void typePartialLocationCode(String code) {
        LOG.info("User types Partial location code on Counting Sessions page");
        countingSessionsPage.typePartialLocationCode(code);
    }

    @Step
    @And("User selects Zone {string} on Counting Sessions page")
    public void selectZone(String zone) {
        LOG.info("User selects Zone on Counting Sessions page");
        countingSessionsPage.selectZone(zone);
    }

    @Step
    @And("User selects random Zone with index {int} on Counting Sessions page")
    public void selectZone(int index) {
        LOG.info("User selects random Zone with index on Counting Sessions page");
        List<String> zones = List.of(countingSessionsDTO.getZones().getZone1(), countingSessionsDTO.getZones().getZone2(),
             countingSessionsDTO.getZones().getZone3(), countingSessionsDTO.getZones().getZone4(), countingSessionsDTO
            .getZones().getZone5(), countingSessionsDTO.getZones().getZone6());
        countingSessionsPage.selectZone(zones.get(index));
    }

    @Step
    @And("User selects Location type {string} on Counting Sessions page")
    public void selectLocationType(String type) {
        LOG.info("User selects Location type on Counting Sessions page");
        countingSessionsPage.selectLocationType(type);
    }

    @Step
    @And("User selects random Location type with index {int} on Counting Sessions page")
    public void selectRandomLocationType(int index) {
        LOG.info("User selects random Location type on Counting Sessions page");
        List<String> types = List.of(countingSessionsDTO.getLocationTypes().getLocationType1(), countingSessionsDTO
            .getLocationTypes().getLocationType2(), countingSessionsDTO.getLocationTypes().getLocationType3(),
            countingSessionsDTO.getLocationTypes().getLocationType4(), countingSessionsDTO.getLocationTypes().getLocationType5());
        countingSessionsPage.selectLocationType(types.get(index));
    }

    @Step
    @And("User types Starting Location {string} on Counting Sessions page")
    public void typeStartingLocation(String code) {
        LOG.info("User types Starting Location on Counting Sessions page");
        countingSessionsPage.typeStartingLocation(code);
    }

    @Step
    @And("User types Starting Location with index {int} on Counting Sessions page")
    public void typeStartingLocationByIndex(int index) {
        LOG.info("User types Starting Location with index on Counting Sessions page");
        List<String> locations = List.of(countingSessionsDTO.getStartingLocations().getStartingLocation1(), countingSessionsDTO
              .getStartingLocations().getStartingLocation2(), countingSessionsDTO.getStartingLocations().getStartingLocation3(),
              countingSessionsDTO.getStartingLocations().getStartingLocation4());
        countingSessionsPage.typeStartingLocation(locations.get(index));
    }

    @Step
    @And("User types Ending Location {string} on Counting Sessions page")
    public void typeEndingLocation(String code) {
        LOG.info("User types Ending Location on Counting Sessions page");
        countingSessionsPage.typeEndingLocation(code);
    }

    @Step
    @And("User types Ending Location with index {int} on Counting Sessions page")
    public void typeEndingLocationByIndex(int index) {
        LOG.info("User types Ending Location with index on Counting Sessions page");
        List<String> locations = List.of(countingSessionsDTO.getEndingLocations().getEndingLocation1(), countingSessionsDTO
               .getEndingLocations().getEndingLocation2(), countingSessionsDTO.getEndingLocations().getEndingLocation3(),
                countingSessionsDTO.getEndingLocations().getEndingLocation4());
        countingSessionsPage.typeEndingLocation(locations.get(index));
    }

    @Step
    @And("User clicks Location tab on Counting Sessions page")
    public void clickLocationsTab() {
        LOG.info("User clicks Location tab on Counting Sessions page");
        countingSessionsPage.clickLocationsTab();
    }

    @Step
    @And("User clicks Products tab on Counting Sessions page")
    public void clickProductsTab() {
        LOG.info("User clicks Products tab on Counting Sessions page");
        countingSessionsPage.clickProductsTab();
    }

    @Step
    @And("User clicks Assignments tab on Counting Sessions page")
    public void clickAssignmentsTab() {
        LOG.info("User clicks Assignments tab on Counting Sessions page");
        countingSessionsPage.clickAssignmentsTab();
    }

    @Step
    @And("User clicks Add Filter on Counting Sessions page")
    public void clickAddFilterButton() {
        LOG.info("User clicks Add Filter on Counting Sessions page");
        countingSessionsPage.clickAddFilterButton();
    }

    @Step
    @And("User clicks Clear Filter on Counting Sessions page")
    public void clickClearFilter() {
        LOG.info("User clicks Clear Filter on Counting Sessions page");
        countingSessionsPage.clickClearFilter();
    }

    @Step
    @And("User clicks Location Column on Counting Sessions page")
    public void clickLocationColumnHeader() {
        LOG.info("User clicks Location Column on Counting Sessions page");
        countingSessionsPage.clickLocationColumnHeader();
    }

    @Step
    @And("User clicks Zone Column on Counting Sessions page")
    public void clickZoneColumnHeader() {
        LOG.info("User clicks Zone Column on Counting Sessions page");
        countingSessionsPage.clickZoneColumnHeader();
    }

    @Step
    @And("User clicks Type Column on Counting Sessions page")
    public void clickTypeColumnHeader() {
        LOG.info("User clicks Type Column on Counting Sessions page");
        countingSessionsPage.clickTypeColumnHeader();
    }

    @Step
    @And("User clicks Status Column on Counting Sessions page")
    public void clickStatusColumnHeader() {
        LOG.info("User clicks Status Column on Counting Sessions page");
        countingSessionsPage.clickStatusColumnHeader();
    }

    @Step
    @And("User clicks Counts Column on Counting Sessions page")
    public void clickCountsColumnHeader() {
        LOG.info("User clicks Counts Column on Counting Sessions page");
        countingSessionsPage.clickCountsColumnHeader();
    }

    @Step
    @And("User clicks Release Date and Time Column on Counting Sessions page")
    public void clickReleaseDateTimeColumn() {
        LOG.info("User clicks Release Date and Time Column on Counting Sessions page");
        countingSessionsPage.clickReleaseDateTimeColumn();
    }

    @Step
    @And("User clicks Product Column on Counting Sessions page")
    public void clickProductColumn() {
        LOG.info("User clicks Product Column on Counting Sessions page");
        countingSessionsPage.clickProductColumn();
    }

    @Step
    @And("User clicks Owner Column on Counting Sessions page")
    public void clickOwnerColumnHeader() {
        LOG.info("User clicks Owner Column on Counting Sessions page");
        countingSessionsPage.clickOwnerColumnHeader();
    }

    @Step
    @And("User clicks Description Column on Counting Sessions page")
    public void clickDescriptionColumnHeader() {
        LOG.info("User clicks Description Column on Counting Sessions page");
        countingSessionsPage.clickDescriptionColumnHeader();
    }

    @Step
    @And("User clicks Book Qty Column on Counting Sessions page")
    public void clickBookQtyColumnHeader() {
        LOG.info("User clicks Book Qty Column on Counting Sessions page");
        countingSessionsPage.clickBookQtyColumnHeader();
    }

    @Step
    @And("User clicks Book Cost Column on Counting Sessions page")
    public void clickBookCostColumnHeader() {
        LOG.info("User clicks Book Cost Column on Counting Sessions page");
        countingSessionsPage.clickBookCostColumnHeader();
    }

    @Step
    @And("User clicks Product Type Column on Counting Sessions page")
    public void clickProductTypeColumnHeader() {
        LOG.info("User clicks Product Type on Counting Sessions page");
        countingSessionsPage.clickProductTypeColumnHeader();
    }

    @Step
    @And("User clicks Location Delete on Counting Sessions page")
    public void clickLocationDeleteButton() {
        LOG.info("User clicks Location Delete on Counting Sessions page");
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
    @And("User searches for product with index {int} on Counting Sessions page")
    public void searchProduct(int index) {
        log.info("User searches for product with index on Counting Sessions page");
        List<String> products = List.of(countingSessionsDTO.getProducts().getProduct1(), countingSessionsDTO.getProducts()
               .getProduct2(), countingSessionsDTO.getProducts().getProduct3(), countingSessionsDTO.getProducts()
               .getProduct4(), countingSessionsDTO.getProducts().getProduct5());
        countingSessionsPage.searchProduct(products.get(index));
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
    @And("User clears Search button on Counting Sessions page")
    public void clearSearchButton() {
        log.info("User clears Search button on Counting Sessions page");
        countingSessionsPage.clearSearchButton();
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
    @And("Types Product by index {int} on Counting Sessions page")
    public void typesProductCodeFilterByIndex(int index) {
        log.info("Types Product by index on Counting Sessions page");
        List<String> products = List.of(countingSessionsDTO.getProducts().getProduct1(), countingSessionsDTO.getProducts()
                .getProduct2(), countingSessionsDTO.getProducts().getProduct3(), countingSessionsDTO.getProducts()
                .getProduct4(), countingSessionsDTO.getProducts().getProduct5());
        countingSessionsPage.typeFilter(products.get(index));
    }

    @Step
    @And("Types Owner {string} on Counting Sessions page")
    public void typesOwnerCodeFilter(String filter) {
        log.info("Types Owner on Counting Sessions page");
        countingSessionsPage.typeFilter(filter);
    }

    @Step
    @And("Types Owner by index {int} on Counting Sessions page")
    public void typesOwnerCodeFilterByIndex(int index) {
        log.info("Types Owner by index on Counting Sessions page");
        List<String> owners = List.of(countingSessionsDTO.getOwners().getOwner1(), countingSessionsDTO.getOwners()
             .getOwner2(), countingSessionsDTO.getOwners().getOwner3(), countingSessionsDTO.getOwners().getOwner4(),
             countingSessionsDTO.getOwners().getOwner5());
        countingSessionsPage.typeFilter(owners.get(index));
    }

    @Step
    @And("Types Description {string} on Counting Sessions page")
    public void typesDescriptionCodeFilter(String filter) {
        log.info("Types Description on Counting Sessions page");
        countingSessionsPage.typeFilter(filter);
    }

    @Step
    @And("Types Description by index {int} on Counting Sessions page")
    public void typesDescriptionCodeFilterByIndex(int index) {
        log.info("Types Description by index on Counting Sessions page");
        List<String> descriptions = List.of(countingSessionsDTO.getDescriptions().getDescription1(), countingSessionsDTO
               .getDescriptions().getDescription2(), countingSessionsDTO.getDescriptions().getDescription3(),
               countingSessionsDTO.getDescriptions().getDescription4(), countingSessionsDTO.getDescriptions().getDescription5());
        countingSessionsPage.typeFilter(descriptions.get(index));
    }

    @Step
    @And("Types Counts {string} on Counting Sessions page")
    public void typesCountsCodeFilter(String filter) {
        log.info("Types Counts on Counting Sessions page");
        countingSessionsPage.typeFilter(filter);
    }

    @Step
    @And("Types Counts by index {int} on Counting Sessions page")
    public void typesCountsCodeFilterByIndex(int index) {
        log.info("Types Counts on Counting Sessions page");
        List<String> types = List.of(countingSessionsDTO.getCountTypes().getCountType1(), countingSessionsDTO
              .getCountTypes().getCountType2(), countingSessionsDTO.getCountTypes().getCountType3(),
              countingSessionsDTO.getCountTypes().getCountType4());
        countingSessionsPage.typeFilter(types.get(index));
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
    @And("Types Product type by index {int} on Counting Sessions page")
    public void typesProductTypeCodeFilter(int index) {
        log.info("Types Product type by index on Counting Sessions page");
        List<String> types = List.of(countingSessionsDTO.getProductTypes().getProductType1(), countingSessionsDTO
              .getProductTypes().getProductType2(), countingSessionsDTO.getProductTypes().getProductType3(),
              countingSessionsDTO.getProductTypes().getProductType4(), countingSessionsDTO.getProductTypes()
              .getProductType5(), countingSessionsDTO.getProductTypes().getProductType6());
        countingSessionsPage.typeFilter(types.get(index));
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
    @And("Selects product type by index {int} on Counting Sessions page")
    public void selectProductTypeByIndex(int index) {
        log.info("Selects product type by index on Counting Sessions page");
        List<String> types = List.of(countingSessionsDTO.getProductTypes().getProductType1(), countingSessionsDTO
               .getProductTypes().getProductType2(), countingSessionsDTO.getProductTypes().getProductType3(),
                countingSessionsDTO.getProductTypes().getProductType4(), countingSessionsDTO.getProductTypes().getProductType5(),
                countingSessionsDTO.getProductTypes().getProductType6());
        countingSessionsPage.selectProductType(types.get(index));
    }

    @Step
    @And("Selects {string} movement class on Counting Sessions page")
    public void selectMovementClass(String type) {
        log.info("Selects movement class on Counting Sessions page");
        countingSessionsPage.selectMovementClass(type);
    }

    @Step
    @And("Selects movement class by index {int} on Counting Sessions page")
    public void selectMovementClassByIndex(int index) {
        log.info("Selects movement class by index on Counting Sessions page");
        List<String> classes = List.of(countingSessionsDTO.getMovementClasses().getMovementClass1(), countingSessionsDTO
               .getMovementClasses().getMovementClass2(), countingSessionsDTO.getMovementClasses().getMovementClass3(),
               countingSessionsDTO.getMovementClasses().getMovementClass4(), countingSessionsDTO.getMovementClasses()
               .getMovementClass5());
        countingSessionsPage.selectMovementClass(classes.get(index));
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
    @And("Selects owner dropdown by index {int} on Counting Sessions page")
    public void selectOwnerDropdownByIndex(int index) {
        log.info("Selects owner dropdown by index on Counting Sessions page");
        List<String> owners = List.of(countingSessionsDTO.getOwners().getOwner1(), countingSessionsDTO.getOwners()
                .getOwner2(), countingSessionsDTO.getOwners().getOwner3(), countingSessionsDTO.getOwners().getOwner4());
        countingSessionsPage.selectOwnerDropdown(owners.get(index));
    }

    @Step
    @And("Types {string} supplier on Counting Sessions page")
    public void typeSupplier(String owner) {
        log.info("Types supplier on Counting Sessions page");
        countingSessionsPage.typeSupplier(owner);
    }

    @Step
    @And("Types supplier by index {int} on Counting Sessions page")
    public void typeSupplierByIndex(int index) {
        log.info("Types supplier by index on Counting Sessions page");
        List<String> suppliers = List.of(countingSessionsDTO.getSuppliers().getSupplier1(), countingSessionsDTO
               .getSuppliers().getSupplier2(), countingSessionsDTO.getSuppliers().getSupplier3(), countingSessionsDTO
               .getSuppliers().getSupplier4(), countingSessionsDTO.getSuppliers().getSupplier5());
        countingSessionsPage.typeSupplier(suppliers.get(index));
    }

    @Step
    @And("Types {string} starting product range on Counting Sessions page")
    public void typeStartingProdRange(String range) {
        log.info("Types starting product range on Counting Sessions page");
        countingSessionsPage.typeStartingProdRange(range);
    }

    @Step
    @And("Types starting product range by index {int} on Counting Sessions page")
    public void typeStartingProdRangeByIndex(int index) {
        log.info("Types starting product range by index on Counting Sessions page");
        List<String> products = List.of(countingSessionsDTO.getProducts().getProduct1(), countingSessionsDTO
               .getProducts().getProduct2(), countingSessionsDTO.getProducts().getProduct3(), countingSessionsDTO
               .getProducts().getProduct4(), countingSessionsDTO.getProducts().getProduct5());
        countingSessionsPage.typeStartingProdRange(products.get(index));
    }

    @Step
    @And("Types {string} ending product range on Counting Sessions page")
    public void typeEndingProdRange(String range) {
        log.info("Types ending product range on Counting Sessions page");
        countingSessionsPage.typeEndingProdRange(range);
    }

    @Step
    @And("Types ending product range by index {int} on Counting Sessions page")
    public void typeEndingProdRange(int index) {
        log.info("Types ending product range by index on Counting Sessions page");
        List<String> products = List.of(countingSessionsDTO.getProducts().getProduct1(), countingSessionsDTO
                .getProducts().getProduct2(), countingSessionsDTO.getProducts().getProduct3(), countingSessionsDTO
                .getProducts().getProduct4(), countingSessionsDTO.getProducts().getProduct5());
        countingSessionsPage.typeEndingProdRange(products.get(index));
    }

    @Step
    @And("Types {string} prod alias type on Counting Sessions page")
    public void selectProdAliasType(String type) {
        log.info("Types prod alias type on Counting Sessions page");
        countingSessionsPage.selectProdAliasType(type);
    }

    @Step
    @And("Types prod alias type by index {int} on Counting Sessions page")
    public void selectProdAliasTypeByIndex(int index) {
        log.info("Types prod alias type on Counting Sessions page");
        List<String> products = List.of(countingSessionsDTO.getProdAliasTypes().getProdAliasType1(), countingSessionsDTO
                .getProdAliasTypes().getProdAliasType2(), countingSessionsDTO.getProdAliasTypes().getProdAliasType3(),
                countingSessionsDTO.getProdAliasTypes().getProdAliasType4(), countingSessionsDTO.getProdAliasTypes()
                .getProdAliasType5());
        countingSessionsPage.selectProdAliasType(products.get(index));
    }

    @Step
    @And("Types {string} inventory status on Counting Sessions page")
    public void selectInventoryStatus(String type) {
        log.info("Types inventory status on Counting Sessions page");
        countingSessionsPage.selectInventoryStatus(type);
    }

    @Step
    @And("Types inventory status by index {int} on Counting Sessions page")
    public void selectInventoryStatusByIndex(int index) {
        log.info("Types inventory status by index on Counting Sessions page");
        List<String> statuses = List.of(countingSessionsDTO.getInventoryStatuses().getInventoryStatus1(), countingSessionsDTO
               .getInventoryStatuses().getInventoryStatus2(), countingSessionsDTO.getInventoryStatuses().getInventoryStatus3(),
                countingSessionsDTO.getInventoryStatuses().getInventoryStatus4(), countingSessionsDTO.getInventoryStatuses()
               .getInventoryStatus5(), countingSessionsDTO.getInventoryStatuses().getInventoryStatus6());
        countingSessionsPage.selectInventoryStatus(statuses.get(index));
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
    @And("UnClicks All Checkbox button on Counting Sessions page")
    public void unClickAllCheckboxButton() {
        log.info("UnClicks All Checkbox button on Counting Sessions page");
        countingSessionsPage.unClickAllCheckboxButton();
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
    @And("Selects user {string} on Counting Sessions page")
    public void selectUser(String user) {
        log.info("Selects user " + user);
        countingSessionsPage.selectUser(user);
    }

    @Step
    @And("Selects user by index {int} on Counting Sessions page")
    public void selectUser(int index) {
        log.info("Selects user by index " + index);
        List<String> users = List.of(countingSessionsDTO.getUsers().getUser1(),countingSessionsDTO.getUsers().getUser2(),
               countingSessionsDTO.getUsers().getUser3(), countingSessionsDTO.getUsers().getUser4(), countingSessionsDTO
               .getUsers().getUser5());
        countingSessionsPage.selectUser(users.get(index));
    }

    @Step
    @And("Removes date and time on Counting Sessions page")
    public void removeDateAndTime() {
        log.info("Removes date and time on Counting Sessions page");
        countingSessionsPage.removeDateAndTime();
    }

}
