package steps.validations.counting.sessions;

import common.constants.FilePaths;
import common.constants.Notifications;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import objects.countingsessions.CountingSessionsDTO;
import org.apache.commons.lang3.StringUtils;
import org.testng.asserts.SoftAssert;
import ui.pages.counting.sessions.CountingSessionsPage;

import java.util.Arrays;

public class CountingSessionsPageValidations {
    CountingSessionsPage countingSessionsPage = new CountingSessionsPage();
    CountingSessionsDTO countingSessionsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.COUNTING_SESSIONS_DATA, CountingSessionsDTO.class);

    @And("Validates Counting Sessions page is displayed")
    public void validateCountingSessionsPageDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isSessionsPageTitleDisplayed(), "Sessions Page title is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCountingSessionLabelDisplayed(), "Session Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isSessionDropdownDisplayed(), "Session dropdown is not displayed");
        softAssert.assertTrue(countingSessionsPage.isNewSessionButtonDisplayed(), "New Session Button is not displayed");
        softAssert.assertTrue(countingSessionsPage.isEditSessionButtonDisplayed(), "Edit Session Button is not displayed");
        softAssert.assertTrue(countingSessionsPage.isDeleteSessionButtonDisplayed(), "Delete Session Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Session Labels on Counting Sessions page are displayed")
    public void validateCountingSessionsLabelsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isLocationsLabelDisplayed(), "Locations Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isAutoReconcileLabelDisplayed(), "Auto Reconcile Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isActiveCheckboxDisplayed(), "Active Checkbox is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Blind Label on Counting Sessions page is displayed")
    public void validateBlindLabelDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isBlindLabelDisplayed(), "Blind Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Partially informed Label on Counting Sessions page is displayed")
    public void validatePartiallyInformedLabelDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isPartiallyInformedLabelDisplayed(), "Partially Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates sessions are present in Session dropdown on Counting Sessions page")
    public void validateCountingSessionsList() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.sessionsList().size() > 0, "Sessions are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page")
    public void validateLocationsProductsAssignmentsTabs() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isLocationsTabDisplayed(), "Locations Tab is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductsTabDisplayed(), "Products Tab is not displayed");
        softAssert.assertTrue(countingSessionsPage.isAssignmentsTabDisplayed(), "Assignments Tab is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Delete and Reset Product are disabled on Counting Sessions page")
    public void validateDeleteProductResetProductDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isDeleteProductDisabled().equals("true"), "Delete Product is not disabled");
        softAssert.assertTrue(countingSessionsPage.isResetProductDisabled().equals("true"), "Reset Product is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Generate locations is enabled on Counting Sessions page")
    public void validateGenerateLocationsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isGenerateLocationsEnabled(), "Generate Locations is not enabled");
        softAssert.assertAll();
    }

    @And("Validates Add Product is enabled on Counting Sessions page")
    public void validateAddProductEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isAddProductEnabled(), "Add Product is not enabled");
        softAssert.assertAll();
    }

    @And("Validates Session name and Count type are displayed on Counting Sessions page")
    public void validateSessionNameCountTypeDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isSessionNameLabelDisplayed(), "Session name label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isSessionNameDisplayed(), "Session name is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCountTypeLabelDisplayed(), "Count type label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCountTypeLabelDisplayed(), "Count type is not displayed");
        softAssert.assertAll();
    }

    @And("Validates session warning {string} on Counting Sessions page")
    public void validateSessionWarningOnPopup(String warning) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isWarningOnPopUpDisplayed(warning), "Correct warning is not displayed");
        softAssert.assertAll();
    }

    @And("Validates session is active on Counting Sessions page")
    public void validateSessionIsActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.getSessionDropdownValue().contains("Active"), "Session is not active");
        softAssert.assertAll();
    }

    @And("Validates Session details on Counting Sessions page")
    public void validateSessionDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isLocationRemoveDisplayed(), "Location Remove is not displayed");
        softAssert.assertTrue(countingSessionsPage.isLocationReleaseDisplayed(), "Location Release is not displayed");
        softAssert.assertTrue(countingSessionsPage.isLocationReconcileDisplayed(), "Location Reconcile is not displayed");
        softAssert.assertAll();
    }

    @And("Validates location with index {int} is selected on Counting Sessions page")
    public void validateLocationIsSelected(int index) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isRowSelected(index).contains("selected"),"Location is not selected");
        softAssert.assertAll();
    }

    @And("Validates product with index {int} is selected on Counting Sessions page")
    public void validateProductIsSelected(int index) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isRowSelected(index).contains("selected"),"Product is not selected");
        softAssert.assertAll();
    }

    @And("Validates Active Checkbox is not selected on Counting Sessions page")
    public void validateActiveCheckboxSelected() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(countingSessionsPage.isActiveCheckboxChecked(),"Active Checkbox is selected");
        softAssert.assertAll();
    }

    @And("Validates location with index {int} is not selected on Counting Sessions page")
    public void validateLocationIsNotSelected(int index) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(countingSessionsPage.isRowSelected(index).contains("selected"),"Location is selected");
        softAssert.assertAll();
    }

    @And("Validates product with index {int} is not selected on Counting Sessions page")
    public void validateProductIsNotSelected(int index) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(countingSessionsPage.isRowSelected(index).contains("selected"),"Product is selected");
        softAssert.assertAll();
    }

    @And("Validates session {string} is saved on Counting Sessions page")
    public void validateSessionIsSaved(String session) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.getSessionDropdownValue().contains(session), "Session is not saved");
        softAssert.assertAll();
    }

    @And("Validates random session is saved on Counting Sessions page")
    public void validateRandomSessionIsSaved() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.getSessionDropdownValue().contains(countingSessionsPage.getSession()), "Session is not saved");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Counting Sessions page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(countingSessionsPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates notification is not displayed on Counting Sessions page")
    public void verifyNotificationMsgDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(countingSessionsPage.isNotificationMsgDisplayed(),"Notification is displayed");
        softAssert.assertAll();
    }

    @And("Validates notification message contains {string} message on Counting Sessions page")
    public void verifyNotificationMsgText(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isNotificationMsgDisplayed(),"Notification " + text + " is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Add Location Popup on Counting Sessions page")
    public void validateAddLocationPopupDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isLocationCodeInputDisplayed(), "Location Code Input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isPartialLocationCodeInputDisplayed(), "Partial Location Code Input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isZoneDropdownDisplayed(), "Zone Dropdown is not displayed");
        softAssert.assertTrue(countingSessionsPage.isLocationTypeDropdownDisplayed(), "Location Type Dropdown is not displayed");
        softAssert.assertTrue(countingSessionsPage.isStartingLocationInputDisplayed(), "Starting Location Input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isEndingLocationInputDisplayed(), "Ending Location Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Count Details popup on Counting Sessions page")
    public void validateCountDetailsPopupDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.getWindowTitleText().contains("Count details"), "Count details is not displayed");
        softAssert.assertTrue(countingSessionsPage.isControlLabelDisplayed(), "Control Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isOkButtonDisplayed(), "OK button is not displayed");
        softAssert.assertTrue(countingSessionsPage.getCountDetailsRows().size() > 0, "Count Details rows are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Count History columns are displayed on Counting Sessions page")
    public void validateCountHistoryDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isUserColumnDisplayed(), "User Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isStartTimeColumnDisplayed(), "Start Time Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isEndTimeColumnDisplayed(), "End Time Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isErrorsColumnDisplayed(), "Errors Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isStatusColumnDisplayed(), "Status Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignments columns are displayed on Counting Sessions page")
    public void validateAssignmentsColumns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isAssignmentColumnDisplayed(), "Assignment Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isAssignmentColumnHeaderDisplayed(), "Assignment Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTotalTasksColumnDisplayed(), "Total Tasks Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTotalTasksColumnHeaderDisplayed(), "Total Tasks Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCompletedColumnDisplayed(), "Completed Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCompletedColumnHeaderDisplayed(), "Completed Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isUserColumnDisplayed(), "User Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isUserColumnHeaderDisplayed(), "User Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTaskGroupColumnDisplayed(), "Task Group Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTaskGroupColumnHeaderDisplayed(), "Task Group Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleasedColumnDisplayed(), "Released Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleasedColumnHeaderDisplayed(), "Released Column Header is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Location columns are displayed on Counting Sessions page")
    public void validateLocationColumns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isLocationColumnDisplayed(), "Location Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isLocationColumnHeaderDisplayed(), "Location Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isZoneColumnDisplayed(), "Zone Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isZoneColumnHeaderDisplayed(), "Zone Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTypeColumnDisplayed(), "Type Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTypeColumnHeaderDisplayed(), "Type Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCountsColumnDisplayed(), "Counts Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCountsColumnHeaderDisplayed(), "Counts Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleaseDateTimeColumnDisplayed(), "Release Date Time is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleaseDateTimeColumnHeaderDisplayed(), "Release Date Time Column Header is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Location Column Sorting Result on Counting Sessions page")
    public void validateLocationColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getLocationColumnHeaderSortingResult()),"Location Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Zone Column Sorting Result on Counting Sessions page")
    public void validateZoneColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getZoneColumnHeaderSortingResult()),"Zone Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Type Column Sorting Result on Counting Sessions page")
    public void validateTypeColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getTypeColumnHeaderSortingResult()),"Type Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Status Column Sorting Result on Counting Sessions page")
    public void validateStatusColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getStatusColumnHeaderSortingResult()),"Status Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Counts Column Sorting Result on Counting Sessions page")
    public void validateCountsColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getCountsColumnHeaderSortingResult()),"Counts Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Release Date Time Column Sorting Result on Counting Sessions page")
    public void validateReleaseDateTimeColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getReleaseDateTimeColumnHeaderSortingResult()),"Release Date Time Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Products tab screen is displayed on Counting Sessions page")
    public void validateProductTabScreenDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isProductColumnDisplayed(), "Product Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductColumnHeaderDisplayed(), "Product Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isOwnerColumnDisplayed(), "Owner Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isOwnerColumnHeaderDisplayed(), "Owner Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isDescriptionColumnDisplayed(), "Description Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isDescriptionColumnHeaderDisplayed(), "Description Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isBookCostColumnDisplayed(), "Book Cost Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isBookCostColumnHeaderDisplayed(), "Book Cost Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductTypeTimeColumnDisplayed(), "Product Type Time Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductTypeColumnHeaderDisplayed(), "Product Type Column Header is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Counted Location columns on Count details popup on Counting Sessions page")
    public void validateCountedLocationColumnsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isPalletColumnDisplayed(), "Pallet Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isPalletColumnHeaderDisplayed(), "Pallet Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductColumnDisplayed(), "Product Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductColumnHeaderDisplayed(), "Product Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isDescriptionColumnDisplayed(), "Description Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isDescriptionColumnHeaderDisplayed(), "Description Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCustomerColumnDisplayed(), "Customer Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCustomerColumnHeaderDisplayed(), "Customer Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isUomColumnDisplayed(), "UOM Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isUomColumnHeaderDisplayed(), "UOM Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCurrentQtyColumnDisplayed(), "Current Qty Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCurrentQtyColumnHeaderDisplayed(), "Current Qty Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCountedQtyColumnDisplayed(), "Counted Qty Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCountedQtyColumnHeaderDisplayed(), "Counted Qty Column Header is not displayed");
        softAssert.assertTrue(countingSessionsPage.isVarianceColumnDisplayed(), "Variance Column is not displayed");
        softAssert.assertTrue(countingSessionsPage.isVarianceColumnHeaderDisplayed(), "Variance Column Header is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Generate locations button is displayed on Counting Sessions page")
    public void validateGenerateLocationsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isBtnGenerateLocationsDisplayed(), "Generate locations button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates table rows are displayed on Counting Sessions page")
    public void validateRowsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.areRowsDisplayed() > 0, "Rows are not displayed");
        softAssert.assertAll();
    }

    @And("Validates items are present on Counting Sessions page")
    public void validateOrdersPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        //softAssert.assertTrue(!countingSessionsPage.getItemsFoundValueText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates items are not present on Counting Sessions page")
    public void validateOrdersNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(countingSessionsPage.getItemsFoundValueText().equals("0"),"Items Found is not 0");
        softAssert.assertAll();
    }

    @And("Validates No Record on Counting Sessions page")
    public void validateNoRecordInCountingSessionsGrid() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.getGridTableRowContent(0)
                .contains(Notifications.NO_DATA), "Items are present in table");
        softAssert.assertAll();
    }

    @And("Validates {string} popup is displayed on Counting Sessions page")
    public void validateAddProductScreenDisplayed(String title) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(countingSessionsPage.getDialogTitleText(), title,"Add product popup title is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductLabelDisplayed(),"Product Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductInputDisplayed(),"Product Input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductTypeLabelDisplayed(),"Product Type Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isProductTypeInputDisplayed(),"Product Type Input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isMovementClassLabelDisplayed(),"Movement Class Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isMovementDropdownDisplayed(),"Movement Dropdown is not displayed");
        softAssert.assertTrue(countingSessionsPage.isNoOfProductsLabelDisplayed(),"No of Products Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isNoOfProductsInputDisplayed(),"No of Products Input is not displayed");
       // softAssert.assertTrue(countingSessionsPage.isMinimumCostLabelDisplayed(),"Minimum Cost Label is not displayed");
      //  softAssert.assertTrue(countingSessionsPage.isMinimumCostInputDisplayed(),"Minimum Cost Input is not displayed");
      //  softAssert.assertTrue(countingSessionsPage.isMaximumCostLabelDisplayed(),"Maximum Cost Label is not displayed");
      //  softAssert.assertTrue(countingSessionsPage.isMaximumCostDisplayed(),"Maximum Cost is not displayed");
        softAssert.assertTrue(countingSessionsPage.isOwnerLabelDisplayed(),"Owner Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isOwnerDropdownDisplayed(),"Owner Dropdown is not displayed");
        softAssert.assertTrue(countingSessionsPage.isSupplierLabelDisplayed(),"Supplier Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isSupplierInputDisplayed(),"Supplier Input is not displayed");
      //  softAssert.assertTrue(countingSessionsPage.isStartingProdRangeLabelDisplayed(),"Starting Prod Range Label is not displayed");
      //  softAssert.assertTrue(countingSessionsPage.isStartingProdRangeDisplayed(),"Starting Prod Range is not displayed");
      //  softAssert.assertTrue(countingSessionsPage.isEndingProdRangeLabelDisplayed(),"Ending Prod Range Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertTrue(countingSessionsPage.isSaveButtonDisplayed(),"Save Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} Release popup is displayed on Counting Sessions page")
    public void validateReleaseAssignmentPopupDisplayed(String title) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(countingSessionsPage.getDialogTitleText(), title,"Assignments popup title is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleaseLabelDisplayed(),"Release Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleaseDateInputDisplayed(),"Date Input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTimeInputDisplayed(),"Time Input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isAssignLabelDisplayed(),"Assign Label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isXcancelIconDisplayed(),"X Cancel Icon is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Location index popup is displayed on Counting Sessions page")
    public void validateLocationIndexPopupDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isLocationWindowTitleDisplayed(),
                "Location index popup title is not displayed");
        softAssert.assertTrue(countingSessionsPage.isAddFilterButtonDisplayed(),"Add Filter Button is not displayed");
        softAssert.assertTrue(countingSessionsPage.isSearchInputDisplayed(),"Search Input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTableContentDisplayed(),"Table Content is not displayed");
        softAssert.assertTrue(countingSessionsPage.isDialogCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Release counts popup is displayed on Counting Sessions page")
    public void validateReleasePopupDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isReleaseCountsWindowTitleDisplayed(),"Release Counts popup title is not displayed");
        softAssert.assertTrue(countingSessionsPage.isBuildCountAssignmentLabelDisplayed(),"Build count assignment label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isBuildCountAssignmentButtonDisplayed(),"Build count assignment button is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTasksPerAssignmentsLabelDisplayed(),"Tasks per assignments label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTasksPerAssignmentsInputDisplayed(),"Tasks per assignments input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isUserDirectedCountingButtonDisplayed(),"User-directed counting button is not displayed");
        softAssert.assertTrue(countingSessionsPage.isUserDirectedCountingLabelDisplayed(),"User-directed counting label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleaseDateLabelDisplayed(),"Release Date label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleaseDateInputDisplayed(),"Release Date input is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleaseTimeInputLabelDisplayed(),"Release Time label is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleaseTimeInputDisplayed(),"Release Time input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Location Code is not empty on Counting Sessions page")
    public void validateLocationCodeInputValue() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!countingSessionsPage.getLocationCodeInputValue().equals(StringUtils.EMPTY),
                "Location Code is empty on Counting Sessions page");
        softAssert.assertAll();
    }

    @And("Validates task per assignment value {string} on Counting Sessions page")
    public void validateTasksPerAssignmentsInputValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.getTasksPerAssignmentsInputValue().equals(value),
                "Task per assignment value is not correct");
        softAssert.assertAll();
    }

    @And("Validates notification {string} on Counting Sessions page")
    public void validateNotificationDisplayed(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isNotificationDisplayed(text),"Notification value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Product Column Sorting Result on Counting Sessions page")
    public void validateProductColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getProductColumnHeaderSortingResult()),"Product Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Owner Column Sorting Result on Counting Sessions page")
    public void validateOwnerColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getOwnerColumnHeaderSortingResult()),"Owner Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Description Column Sorting Result on Counting Sessions page")
    public void validateDescriptionColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getDescriptionColumnHeaderSortingResult()),"Description Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Book Qty Column Sorting Result on Counting Sessions page")
    public void validateBookQtyColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getBookQtyColumnHeaderSortingResult()),"Book Qty Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Book Cost Column Sorting Result on Counting Sessions page")
    public void validateBookCostColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getBookCostColumnHeaderSortingResult()),"Book Cost Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates Product Type Column Sorting Result on Counting Sessions page")
    public void validateProductTypeColumnSortingResult() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Arrays.asList("ascending", "descending").contains(countingSessionsPage
                .getProductTypeColumnHeaderSortingResult()),"Product Type Column does not contain Sorting Result");
        softAssert.assertAll();
    }

    @And("Validates dialog text {string} on Counting Sessions page")
    public void validateDialogText(String warning) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(countingSessionsPage.getDialogTextContent(), warning, "Dialog content is not correct");
        softAssert.assertAll();
    }

    @And("Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page")
    public void validateAssignmentTabPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isRemoveAssignmentBtnDisplayed(),"Remove Assignment Button is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleaseAssignmentBtnDisplayed(),"Release Assignment Button is not displayed");
        softAssert.assertTrue(countingSessionsPage.isAddFilterButtonDisplayed(),"Add Filter Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Release button is disabled on Counting Sessions page")
    public void validateReleaseAssignmentBtnNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isReleaseAssignmentBtnDisabled().equals("true"), "Release button is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Delete button is disabled on Counting Sessions page")
    public void validateRemoveAssignmentBtnNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isRemoveAssignmentBtnDisabled().equals("true"), "Delete button is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Edit and Delete buttons are disabled on Counting Sessions page")
    public void validateEditDeleteBtnsNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isEditSessionBtnDisabled().equals("true"), "Edit Session button is not disabled");
        softAssert.assertTrue(countingSessionsPage.isDeleteSessionBtnDisabled().equals("true"), "Delete Session button is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Cancel and OK buttons are displayed on Counting Sessions page")
    public void validateCancelOkBtnsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isCancelButtonDisplayed(), "Cancel button is not disabled");
        softAssert.assertTrue(countingSessionsPage.isOkButtonDisplayed(), "OK button is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Assignment filters are displayed on Counting Sessions page")
    public void validateDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingSessionsPage.isAssignmentCodeFilterDisplayed(), "Assignment is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTotalTasksFilterDisplayed(), "Total Tasks is not displayed");
        softAssert.assertTrue(countingSessionsPage.isCompletedTasksFilterDisplayed(), "Completed is not displayed");
        softAssert.assertTrue(countingSessionsPage.isUserNameFilterDisplayed(), "User is not displayed");
        softAssert.assertTrue(countingSessionsPage.isTaskGroupFilterDisplayed(), "Task Group is not displayed");
        softAssert.assertTrue(countingSessionsPage.isReleasedDateTimeFilterDisplayed(), "Released is not displayed");
        softAssert.assertTrue(countingSessionsPage.isSearchBoxDisplayed(), "Search Box is not displayed");
        softAssert.assertAll();
    }
}
