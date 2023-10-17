package ui.pages.counting.sessions;

import common.utils.Waiters;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

import static common.setup.DriverManager.getDriver;

public class CountingSessionsPage extends BasePage {
    By sessionsPageTitle = By.className("spnmoduleNameHeader");
    By countingSessionLabel = By.id("ddlSessionSession-label");
    By sessionDropdown = By.id("ddlSessionSession");
    By btnNewSession = By.id("btnNewSession");
    By btnEditSession = By.id("btnEditSession");
    By btnDeleteSession = By.xpath("//button[contains(text(), 'Delete')]");
    By locationsTab = By.xpath("//li[@role='tab']//span[text()='Locations']");
    By productsTab = By.xpath("//li[@role='tab']//span[text()='Products']");
    By assignmentsTab = By.xpath("//li[@role='tab']//span[text()='Assignments']");
    By dialogTitle = By.className("k-dialog-title");
    By sessionNameLabel = By.id("txtSessionName-label");
    By sessionName = By.id("txtSessionName");
    By countTypeLabel = By.id("ddlCountType-label");
    By countType = By.id("ddlCountType");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By okButton = By.xpath("//button[contains(text(), 'Ok')]");
    By OKButton = By.xpath("//button[contains(text(), 'OK')]");
    By yesButton = By.xpath("//button[@content='Yes']");
    By noButton = By.xpath("//button[@content='No']");
    By activeCheckbox = By.xpath("//input[@id='activeSessionCheckbox']");
    By dialogTextContent = By.id("dialogTextContent");
    By btnCSLocationAdd = By.id("btnCSLocationAdd");
    By btnLocationRemove = By.id("btnCSLocationRemove");
    By btnLocationRelease = By.id("btnCSLocationRelease");
    By btnLocationReconcile = By.id("btnCSLocationReconcile");
    By notificationMsg = By.cssSelector(".toast-message");
    By locationCodeInput = By.xpath("//div[contains(@class, 'i-indexfield-container')][.//label[@id='indexLocationIndex-label']]//input");
    By partialLocationCodeInput = By.id("txtPartialLocationCode");
    By locCodeButton = By.xpath("//div[contains(@class, 'i-indexfield-container')][.//label[@id='indexLocationIndex-label']]//button");
    By searchInput = By.id("gridUtilSearch_undefined");
    By tableContent = By.cssSelector("#gridUtil_undefined  .k-grid-table");
    By dialogCancelButton = By.id("dialogCancelButton");
    By itemsCount = By.cssSelector(".i-summary-area__main__value");
    By itemsFound = By.cssSelector(".i-summary-area__main__label");
    By zoneDropdown = By.id("ddlZone");
    By locationTypeDropdown = By.id("ddlLocationType");
    By startingLocationInput = By.xpath("//div[contains(@class, 'i-indexfield-container')][.//label[@id='indexStartingLocationIndex-label']]//input");
    By endingLocationInput = By.xpath("//div[contains(@class, 'i-indexfield-container')][.//label[@id='indexEndingLocationIndex-label']]//input");
    By sessionTableRows = By.cssSelector(".k-grid-table tr");
    By selectAllCheckbox = By.xpath("//div[@class='k-grid-header']//input");
    By windowTitle = By.cssSelector(".k-window-title");
    By locationWindowTitle = By.xpath("//div[contains(text(), 'Location index')]");
    By releaseCountsWindowTitle = By.xpath("//span[contains(text(), 'Release counts')]");
    By controlLabel = By.cssSelector(".control-label");
    By userColumn = By.xpath("//span[text()='User']");
    By userColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='User']]");
    By startTimeColumn = By.xpath("//span[text()='Start time']");
    By startTimeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Start time']]");
    By endTimeColumn = By.xpath("//span[text()='End time']");
    By endTimeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='End time']]");
    By errorsColumn = By.xpath("//span[text()='Errors']");
    By errorsColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Errors']]");
    By statusColumn = By.xpath("//span[text()='Status']");
    By statusColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Status']]");
    By countDetailsRows = By.cssSelector(".k-dialog .k-grid-table tr");
    By locationColumn = By.xpath("//span[text()='Location']");
    By locationColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Location']]");
    By zoneColumn = By.xpath("//span[text()='Zone']");
    By zoneColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Zone']]");
    By typeColumn = By.xpath("//span[text()='Type']");
    By typeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Type']]");
    By countsColumn = By.xpath("//span[text()='Counts']");
    By countsColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Counts']]");
    By releaseDateTimeColumn = By.xpath("//span[text()='Release date/time']");
    By releaseDateTimeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Release date/time']]");
    By productColumn = By.xpath("//span[text()='Product']");
    By productColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Product']]");
    By ownerColumn = By.xpath("//span[text()='Owner']");
    By ownerColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Owner']]");
    By customerColumn = By.xpath("//span[text()='Customer']");
    By customerColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Customer']]");
    By descriptionColumn = By.xpath("//span[text()='Description']");
    By descriptionColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Description']]");
    By bookCostColumn = By.xpath("//span[text()='Book cost']");
    By bookCostColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Book cost']]");
    By productTypeTimeColumn = By.xpath("//span[text()='Product type']");
    By productTypeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Product type']]");
    By bookQtyColumn = By.xpath("//span[text()='Book qty']");
    By bookQtyColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Book qty']]");
    By palletColumn = By.xpath("//span[text()='Pallet']");
    By palletColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Pallet']]");
    By uomColumn = By.xpath("//span[text()='UOM']");
    By uomColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='UOM']]");
    By currentQtyColumn = By.xpath("//span[text()='Current qty']");
    By currentQtyColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Current qty']]");
    By countedQtyColumn = By.xpath("//span[text()='Counted qty']");
    By countedQtyColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Counted qty']]");
    By varianceColumn = By.xpath("//span[text()='Variance']");
    By varianceColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Variance']]");
    By btnGenerateLocations = By.id("btnCSProductLocations");
    By productGridSearch = By.id("CSProductGridSearch");
    By assignmentGridSearch = By.id("AssignmentGridSearch");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found')]//following-sibling::span");
    By addFilterButton = By.xpath("//span[contains(text(), 'Add filter')]");
    By productCodeFilter = By.cssSelector(".i-btn-checkbox  #ProductCode");
    By ownerCodeFilter = By.cssSelector(".i-btn-checkbox  #OwnerCode");
    By productDescFilter = By.cssSelector(".i-btn-checkbox  #ProductDesc");
    By bookQtyFilter = By.cssSelector(".i-btn-checkbox  #BookQtty");
    By bookCostFilter = By.cssSelector(".i-btn-checkbox  #BookCost");
    By productTypeFilter = By.cssSelector(".i-btn-checkbox  #ProductTypeCode");
    By clearAllButton = By.xpath("//button[text()='Clear all']");
   // By inputContains = By.xpath("//input[@placeholder='Contains']");
    By inputContains = By.xpath("//input[@placeholder='Is empty']");
    By applyButton = By.xpath("//button[text()='Apply']");
    By btnProductAdd = By.id("btnCSProductAdd");
    By productLabel = By.id("txtProduct-label");
    By txtProductInput = By.id("txtProduct");
    By productTypeLabel = By.id("ddlProductType-label");
    By productTypeInput = By.id("ddlProductType");
    By movementClassLabel = By.id("ddlMovementClass-label");
    By movementDropdown = By.id("ddlMovementClass");
    By noOfProductsLabel = By.id("txtNoOfProducts-label");
    By noOfProductsInput = By.id("txtNoOfProducts");
    By minimumCostLabel = By.id("txtMinimumCost-label");
    By minimumCostInput = By.id("txtMinimumCost");
    By maximumCostLabel = By.id("txtMaximumCost-label");
    By maximumCost = By.id("txtMaximumCost");
    By ownerLabel = By.id("ddlOwner-label");
    By ddlOwnerDropdown = By.id("ddlOwner");
    By supplierIndexLabel = By.id("indexSupplierIndex-label");
    By supplierInput = By.cssSelector("input[placeholder='Select a supplier']");
    By supplierInputIcon = By.cssSelector(".i-indexfield-container__main .i-button--icon-only");
    By popupTable = By.xpath("//div[contains(@class, 'k-dialog-content')]//table[@class='k-grid-table']");
    By startingProdRangeLabel = By.id("txtStartingProdRange-label");
    By startingProdRange = By.id("txtStartingProdRange");
    By endingProdRangeLabel = By.id("txtEndingProdRange-label");
    By endingProdRange = By.id("txtEndingProdRange");
    By loadingImage = By.className(".k-i-loading--full-screen");
    By productAliasTypeLabel = By.id("ddlProductAliasType-label");
    By productAliasTypeDropdown = By.id("ddlProductAliasType");
    By inventoryStatusLabel = By.id("ddlInventoryStatus-label");
    By inventoryStatusDropdown = By.id("ddlInventoryStatus");
    By allCheckbox = By.cssSelector(".i-grid-checkbox-header .k-checkbox");
    By btnProductRemove = By.id("btnCSProductRemove");
    By btnProductReset = By.id("btnCSProductReset");
    By btnProductLocations = By.id("btnCSProductLocations");
    By removeAssignmentBtn = By.id("cycleCounting_CSAssignmentsPage_removeAssignmentBtn");
    By releaseAssignmentBtn = By.id("cycleCounting_CSAssignmentsPage_releaseAssignmentBtn");
    By dropdownList = By.id("dropdownList");
    By assignmentColumn = By.xpath("//span[text()='Assignment']");
    By assignmentColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Assignment']]");
    By totalTasksColumn = By.xpath("//span[text()='Total tasks']");
    By totalTasksColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Total tasks']]");
    By completedColumn = By.xpath("//span[text()='Completed']");
    By completedColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Completed']]");
    By taskGroupColumn = By.xpath("//span[text()='Task group']");
    By taskGroupColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Task group']]");
    By releasedColumn = By.xpath("//span[text()='Released']");
    By releasedColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Released']]");
    By checkBoxes = By.cssSelector(".k-grid-table .k-master-row input");
    By releaseLabel = By.xpath("//label[contains(text(), 'Release')]");
    By buildCountAssignmentButton= By.id("rdoBtnBuildCountAssignment_1");
    By buildCountAssignmentLabel= By.cssSelector("label[for='rdoBtnBuildCountAssignment_1']");
    By tasksPerAssignmentsLabel= By.id("txtGroup-label");
    By tasksPerAssignmentsInput= By.id("txtGroup");
    By userDirectedCountingButton= By.id("rdoBtnBuildCountAssignment_2");
    By userDirectedCountingLabel= By.cssSelector("label[for='rdoBtnBuildCountAssignment_2']");
    By dateInputSchedDateLabel = By.id("dateInputSchedDate-label");
    By dateInputSchedDate = By.id("dateInputSchedDate");
    By timeInputSchedTimeLabel= By.id("timeInputSchedTime-label");
    By timeInputSchedTime= By.id("timeInputSchedTime");
    By assignLabel = By.xpath("//label[contains(text(), 'Assign')]");
    By XcancelIcon = By.cssSelector(".i-button--icon-only");
    By toggleCalendar = By.cssSelector("a[title='Toggle calendar']");
    By userDropdown = By.xpath("//span[contains(@data-test-id, 'AssignmentsReleaseModal_userDropDown')]//span[@role='listbox']");
    By allAssignmentsCheckBox = By.xpath("//th[@role='columnheader']//input");
    By locationsLabel = By.xpath("//div[contains(text(), 'Locations:')]");
    By blindLabel = By.xpath("//div[contains(text(), 'Blind')]");
    By partiallyInformedLabel = By.xpath("//div[contains(text(), 'Partiallly informed')]");
    By autoReconcileLabel = By.xpath("//div[contains(text(), 'Auto reconcile')]");
    By ddlDeleteReasonLabel = By.id("ddlDeleteReason-label");
    By ddlDeleteReason = By.id("ddlDeleteReason");
    By allInputsCheckbox = By.xpath("//div[@class='k-widget k-grid']//div[@class='k-grid-header']//input");
    By assignmentCodeFilter = By.cssSelector(".i-btn-checkbox  #AssignmentCode");
    By totalTasksFilter = By.cssSelector(".i-btn-checkbox  #TotalTasks");
    By completedTasksFilter = By.cssSelector(".i-btn-checkbox  #CompletedTasks");
    By userNameFilter = By.cssSelector(".i-btn-checkbox  #UserNameu");
    By taskGroupFilter = By.cssSelector(".i-btn-checkbox  #TaskGroup");
    By releasedDateTimeFilter = By.cssSelector(".i-btn-checkbox  #ReleasedDateTime");
    By searchBox = By.cssSelector(".i-filter-popup--add .i-search-box__input");
    By addFilter = By.cssSelector(".i-filter-tag__main");
    By clearFilter = By.cssSelector(".i-filter-tag__clear");
    By clearSearchButton = By.cssSelector(".i-search-box .i-search-box__clear");
    By loader = By.cssSelector(".loader");

    private static String session = null;

    private WebElement getNotification(String text) { return findWebElement(By.xpath("//span[text()='" + text + "']")); }

    public static synchronized void setSession(String sessionName) { session = sessionName; }

    public static synchronized String getSession() { return session; }

    public void waitCountingSessionsPageToLoad() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(countingSessionLabel);
        Waiters.waitForElementToBeDisplay(sessionDropdown);
        Waiters.waitForElementToBeDisplay(btnNewSession);
        Waiters.waitForElementToBeDisplay(btnEditSession);
        Waiters.waitForElementToBeDisplay(btnDeleteSession);
    }

    public void selectWarehouse(String warehouse) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDropdownList());
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(warehouse))
                .findFirst()
                .orElse(null);
        clickOnElement(option);
        Waiters.returnDocumentStatus(getDriver());
    }

    public String getGridTableRowContent(int row) {
        Waiters.returnDocumentStatus(getDriver());
        Waiters.waitForPresenceOfAllElements(sessionTableRows);
        return getText(getSessionTableRows().get(row));
    }

    public void enterDate(String date) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeClickable(getToggleCalendar());
        Waiters.waitABit(4000);
        clickOnElement(getToggleCalendar());
        Waiters.waitABit(4000);
        Waiters.returnDocumentStatus(getDriver());
        String day = date.substring(3, 5).contains("0") ? date.substring(4, 5) : date.substring(3, 5);
        clickOnElement(getCalendarDay(day));
        Waiters.returnDocumentStatus(getDriver());
    }

    public void removeDateAndTime() {
        Waiters.returnDocumentStatus(getDriver());
        Waiters.waitForElementToBeClickable(getXcancelIcon());
        clickOnElement(getXcancelIcon());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void enterTime(String time) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getTimeInputSchedTime());
        Waiters.waitABit(2000);
        pressLeftArrow(getTimeInputSchedTime());
        pressLeftArrow(getTimeInputSchedTime());
        inputText(getTimeInputSchedTime(), time.split(":")[0]);
        pressLeftArrow(getTimeInputSchedTime());
        Waiters.waitABit(2000);
        inputText(getTimeInputSchedTime(), time.split(":")[0]);
        pressRightArrow(getTimeInputSchedTime());
        Waiters.waitABit(2000);
        inputText(getTimeInputSchedTime(), time.split(":")[1]);
        pressLeftArrow(getTimeInputSchedTime());
        Waiters.waitABit(2000);
        inputText(getTimeInputSchedTime(), time.split(":")[1]);
        pressLeftArrow(getTimeInputSchedTime());
        Waiters.waitABit(2000);
        inputText(getTimeInputSchedTime(), time.split(":")[1]);
        pressTab(getTimeInputSchedTime());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectUser(String user) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getUserDropdown());
        clickOnElement(getUserDropdown());
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options.stream()
                        .filter(el -> el.getText().equals(user))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("User " + user + " is not found"));
        clickOnElement(option);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void waitUntilLoaderInvisible() {
        waitUntilInvisible(3, loader);
    }

    public void clickSessionDropdown() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeClickable(sessionDropdown);
        clickOnElement(getSessionDropdown());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickSelectAllCheckbox() {
        waitUntilLoaderInvisible();
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(selectAllCheckbox);
        selectCheckbox(selectAllCheckbox);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickUnselectAllCheckbox() {
        waitUntilLoaderInvisible();
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(selectAllCheckbox);
        unselectCheckbox(selectAllCheckbox);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickLocationDeleteButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLocationRemove());
        clickOnElement(getLocationRemove());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickLocationReleaseButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLocationRelease());
        clickOnElement(getLocationRelease());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickLocationReconcileButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLocationReconcile());
        clickOnElement(getLocationReconcile());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public String getSessionDropdownValue() {
        Waiters.waitForElementToBeDisplay(sessionDropdown);
        return getText(sessionDropdown);
    }

    public String getDialogTextContent() {
        Waiters.waitForElementToBeDisplay(dialogTextContent);
        return getText(dialogTextContent);
    }

    public void clickSessionsPageTitle() {
        Waiters.waitForElementToBeDisplay(sessionsPageTitle);
        clickOnElement(sessionsPageTitle);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public boolean isActiveCheckboxChecked() { return isElementSelected(activeCheckbox); }

    public List<WebElement> sessionsList() {
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public void selectSession(String session) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementsToBeDisplay(findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[@role='option']")));
        Waiters.waitTillLoadingPage(getDriver());
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[@role='option']"));
        WebElement option = options.stream()
                .filter(el -> el.getText().contains(session))
                .findFirst()
                .orElse(null);
        scrollToCenter(option);
        clickOnElement(option);
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilInvisible(1, loader);
    }

    public void selectDeleteReason(String reason) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDeleteReason());
        clickOnElement(getDeleteReason());
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options.stream()
                .filter(el -> el.getText().contains(reason))
                .findFirst()
                .orElse(null);
        clickOnElement(option);
    }

    public void clickAllInputsCheckbox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAllInputsCheckbox());
        clickOnElement(getAllInputsCheckbox());
    }

    public void unselectTableRowByIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForPresenceOfAllElements(sessionTableRows);
        List<WebElement> rows = findWebElements(sessionTableRows);
        unselectCheckbox(rows.get(index).findElement(By.xpath(".//input")));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectTableRowByIndex(int index) {
        Waiters.waitABit(2000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForPresenceOfAllElements(sessionTableRows);
        List<WebElement> rows = findWebElements(sessionTableRows);
        Waiters.waitABit(2000);
        WebElement row = rows.get(index).findElement(By.xpath(".//input"));
        Waiters.waitABit(2000);
        clickOnElement(row);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickTableLocationByIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForPresenceOfAllElements(sessionTableRows);
        List<WebElement> rows = findWebElements(sessionTableRows);
        Waiters.waitABit(4000);
        clickOnElement(rows.get(index).findElements(By.xpath(".//button[contains(@class, 'i-link-button')]")).get(0));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectTableCountByIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForPresenceOfAllElements(sessionTableRows);
        List<WebElement> rows = findWebElements(sessionTableRows);
        clickOnElement(rows.get(index).findElements(By.xpath(".//button[contains(@class, 'i-link-button')]")).get(1));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectCountType(String type) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(countType);
        clickOnElement(countType);
        Waiters.waitABit(3000);
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(type))
                .findFirst()
                .orElse(null);
        clickOnElement(option);
    }

    public void typeLocationCode(String code) {
        Waiters.waitForElementToBeDisplay(getLocationCodeInput());
        clear(getLocationCodeInput());
        inputText(getLocationCodeInput(), code);
        pressEnter(getLocationCodeInput());
    }

    public void selectLocationCode(String code) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLocationCodeInput());
        clear(getLocationCodeInput());
        inputText(getLocationCodeInput(), code);
        WebElement locCode = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + code + "') and @role='option']"));
        clickOnElement(locCode);
    }

    public void typePartialLocationCode(String code) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getPartialLocationCodeInput());
        clear(getPartialLocationCodeInput());
        inputText(getPartialLocationCodeInput(), code);
    }

    public void selectZone(String zone) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(zoneDropdown);
        Waiters.waitABit(2000);
        clickOnElement(zoneDropdown);
        Waiters.waitABit(3000);
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(zone))
                .findFirst()
                .orElse(null);
        clickOnElement(option);
    }

    public void selectLocationType(String type) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(locationTypeDropdown);
        clickOnElement(locationTypeDropdown);
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(type))
                .findFirst()
                .orElse(null);
        clickOnElement(option);
    }

    public void typeStartingLocation(String code) {
        Waiters.waitForElementToBeDisplay(getStartingLocationInput());
        clear(getStartingLocationInput());
        inputText(getStartingLocationInput(), code);
        pressEnter(getStartingLocationInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeEndingLocation(String code) {
        Waiters.waitForElementToBeDisplay(getEndingLocationInput());
        clear(getEndingLocationInput());
        inputText(getEndingLocationInput(), code);
        pressEnter(getEndingLocationInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeSessionName(String name) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(sessionName);
        enterText(getSessionName(), name);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeRandomSessionName() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(sessionName);
        String randomSessionName = RandomStringUtils.randomAlphabetic(6);
        setSession(randomSessionName);
        enterText(getSessionName(), randomSessionName);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickUserDirectedCountingButton() {
        Waiters.waitForElementToBeDisplay(userDirectedCountingButton);
        clickOnElement(userDirectedCountingButton);
    }

    public void searchProduct(String product) {
        Waiters.waitForElementToBeDisplay(getProductGridSearch());
        enterText(getProductGridSearch(), product);
        Waiters.waitABit(5000);
        pressEnter(getProductGridSearch());
        Waiters.waitABit(6000);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void searchAssignment(String assignment) {
        Waiters.waitForElementToBeDisplay(getAssignmentGridSearch());
        enterText(getAssignmentGridSearch(), assignment);
        pressEnter(getAssignmentGridSearch());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void deleteProductSearchInput() {
        Waiters.waitForElementToBeDisplay(getProductGridSearch());
        doubleClick(getProductGridSearch());
        pressDelete(getProductGridSearch());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickNewSession() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getBtnNewSession());
        clickOnElement(getBtnNewSession());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickEditSession() {
        Waiters.waitForElementToBeDisplay(getBtnEditSession());
        clickOnElement(getBtnEditSession());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickDeleteSession() {
        Waiters.waitForElementToBeDisplay(btnDeleteSession);
        clickOnElement(btnDeleteSession);
    }

    public void clickSaveButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(saveButton);
        clickOnElement(getSaveButton());
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilInvisible(1, loader);
    }

    public void clickYesButtonIfNeeded() {
        try {
            if(isVisible(yesButton)) {
                clickOnElement(yesButton);
                Waiters.waitTillLoadingPage(getDriver());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeDisplay(cancelButton);
        clickOnElement(cancelButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickOkButton() {
        Waiters.waitForElementToBeDisplay(okButton);
        clickOnElement(okButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickOKButton() {
        Waiters.waitForElementToBeDisplay(OKButton);
        clickOnElement(OKButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickYesButton() {
        Waiters.waitForElementToBeDisplay(yesButton);
        clickOnElement(yesButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickNoButton() {
        Waiters.waitForElementToBeDisplay(noButton);
        clickOnElement(noButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickActiveCheckbox() {
        Waiters.waitForElementToBeDisplay(getActiveCheckbox());
        clickOnElement(getActiveCheckbox());
    }

    public void clickLocationAdd() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLocationAdd());
        clickOnElement(getLocationAdd());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickLocationsTab() {
        Waiters.waitForElementToBeDisplay(getLocationsTab());
        clickOnElement(getLocationsTab());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickProductsTab() {
        Waiters.waitForElementToBeDisplay(getProductsTab());
        clickOnElement(getProductsTab());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickAssignmentsTab() {
        Waiters.waitForElementToBeDisplay(getAssignmentsTab());
        clickOnElement(getAssignmentsTab());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickLocationColumnHeader() {
        Waiters.waitForElementToBeDisplay(getLocationColumnHeader());
        clickOnElement(getLocationColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickLocCodeButton() {
        Waiters.waitForElementToBeDisplay(getLocCodeButton());
        clickOnElement(getLocCodeButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickZoneColumnHeader() {
        Waiters.waitForElementToBeDisplay(getZoneColumnHeader());
        clickOnElement(getZoneColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickTypeColumnHeader() {
        Waiters.waitForElementToBeDisplay(getTypeColumnHeader());
        clickOnElement(getTypeColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickStatusColumnHeader() {
        Waiters.waitForElementToBeDisplay(getStatusColumnHeader());
        clickOnElement(getStatusColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickCountsColumnHeader() {
        Waiters.waitForElementToBeDisplay(getCountsColumnHeader());
        clickOnElement(getCountsColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickReleaseDateTimeColumn() {
        Waiters.waitForElementToBeDisplay(getReleaseDateTimeColumn());
        clickOnElement(getReleaseDateTimeColumn());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickProductColumn() {
        Waiters.waitForElementToBeDisplay(getProductColumnHeader());
        clickOnElement(getProductColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickOwnerColumnHeader() {
        Waiters.waitForElementToBeDisplay(getOwnerColumnHeader());
        clickOnElement(getOwnerColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickDescriptionColumnHeader() {
        Waiters.waitForElementToBeDisplay(getDescriptionColumnHeader());
        clickOnElement(getDescriptionColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickBookQtyColumnHeader() {
        Waiters.waitForElementToBeDisplay(getBookQtyColumnHeader());
        clickOnElement(getBookQtyColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickBookCostColumnHeader() {
        Waiters.waitForElementToBeDisplay(getBookCostColumnHeader());
        clickOnElement(getBookCostColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickProductTypeColumnHeader() {
        Waiters.waitForElementToBeDisplay(getProductTypeColumnHeader());
        clickOnElement(getProductTypeColumnHeader());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickAddFilter() {
        Waiters.waitForElementToBeDisplay(getAddFilterButton());
        clickOnElement(getAddFilterButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectTableContentByIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTableContent());
        clickOnElement(getTableContent().findElements(By.xpath(".//tr[@role='row']")).get(index));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void checkProductCodeFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProductCodeFilter());
        clickOnElement(getProductCodeFilter());
    }

    public void checkOwnerCodeFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getOwnerCodeFilter());
        clickOnElement(getOwnerCodeFilter());
    }

    public void checkProductDescFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProductDescFilter());
        clickOnElement(getProductDescFilter());
    }

    public void checkCountFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getBookQtyFilter());
        clickOnElement(getBookQtyFilter());
    }

    public void checkBookCostFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getBookCostFilter());
        clickOnElement(getBookCostFilter());
    }

    public void checkProductTypeFilterCheckBox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProductTypeFilter());
        clickOnElement(getProductTypeFilter());
    }

    public void checkAllAssignments() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAllAssignmentsCheckBox());
        clickOnElement(getAllAssignmentsCheckBox());
    }

    public void clickClearAllButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getClearAllButton());
        clickOnElement(getClearAllButton());
    }

    public void clickAddFilterButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAddFilter());
        clickOnElement(getAddFilter());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickProductRemoveButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProductRemove());
        clickOnElement(getProductRemove());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickProductResetButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProductReset());
        clickOnElement(getProductReset());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickProductLocationsButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProductLocations());
        clickOnElement(getProductLocations());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeFilter(String filter) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getInputContains());
        inputText(getInputContains(), filter);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clearSearchButton() {
        Waiters.waitTillLoadingPage(getDriver());
        if(isVisible(By.cssSelector(".i-search-box__clear"))) {
            clickOnElement(By.cssSelector(".i-search-box__clear"));
        }
        Waiters.waitTillLoadingPage(getDriver());
    }

    public String getLocationCodeInputValue() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getLocationCodeInput());
        return getValue(getLocationCodeInput());
    }

    public void clickApplyButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getApplyButton());
        clickOnElement(getApplyButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickAddProductButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getBtnProductAdd());
        clickOnElement(getBtnProductAdd());
        waitUntilInvisible(1, loader);
    }

    public void clickAllCheckboxButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAllCheckbox());
        Waiters.waitABit(5000);
        clickOnElement(getAllCheckbox());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void unClickAllCheckboxButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAllCheckbox());
        clickOnElement(getAllCheckbox());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeNumberOfProducts(String products) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(noOfProductsInput);
        enterText(getNoOfProductsInput(), products);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeTasksPerAssignment(String task) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tasksPerAssignmentsInput);
        enterText(getTasksPerAssignmentsInput(), task);
        Waiters.waitTillLoadingPage(getDriver());
    }


    public void clearTasksPerAssignment() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tasksPerAssignmentsInput);
        clear(getTasksPerAssignmentsInput());
    }

    public void clickClearFilter() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getClearFilter());
        clickOnElement(getClearFilter());
    }

    public void selectProductType(String type) {
        Waiters.waitForElementToBeDisplay(getProductTypeInput());
        clickOnElement(getProductTypeInput());
        Waiters.waitABit(4000);
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        Waiters.waitABit(4000);
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(type))
                .findFirst()
                .orElse(null);
        scrollToCenter(option);
        clickOnElement(option);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeProduct(String product) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTxtProductInput());
        enterText(getTxtProductInput(), product);
    }

    public void selectMovementClass(String mvmtClass) {
        Waiters.waitForElementToBeDisplay(movementDropdown);
        clickOnElement(movementDropdown);
        Waiters.waitABit(2000);
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(mvmtClass))
                .findFirst()
                .orElse(null);
        jsClick(option);
        Waiters.waitABit(2000);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeMinimumCost(String cost) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(minimumCostInput);
        enterText(getMinimumCostInput(), cost);
    }

    public void typeMaximumCost(String cost) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(maximumCost);
        enterText(getMaximumCost(), cost);
    }

    public void selectOwnerDropdown(String owner) {
        Waiters.waitForElementToBeDisplay(ddlOwnerDropdown);
        clickOnElement(ddlOwnerDropdown);
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(owner))
                .findFirst()
                .orElse(null);
        clickOnElement(option);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeSupplier(String supplier) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeClickable(supplierInputIcon);
        Waiters.waitABit(3000);
        jsClick(getSupplierInputIcon());
        clickOnElement(getPopupTable().findElement(By.xpath(".//tr[contains(@class, 'k-master-row')][.//td[text()='" + supplier + "']]")));
        pressTab(getSupplierInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeStartingProdRange(String range) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(startingProdRange);
        inputText(getStartingProdRange(), range);
        pressTab(getStartingProdRange());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeEndingProdRange(String range) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(endingProdRange);
        inputText(getEndingProdRange(), range);
        pressTab(getEndingProdRange());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectProdAliasType(String type) {
        Waiters.waitForElementToBeDisplay(getProductAliasTypeDropdown());
        clickOnElement(getProductAliasTypeDropdown());
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(type))
                .findFirst()
                .orElse(null);
        clickOnElement(option);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void checkAssignment(int assignment) {
        Waiters.waitForAllElementsToBeDisplay(getCheckBoxes().get(getCheckBoxes().size()-1));
        clickOnElement(getCheckBoxes().get(assignment));
    }

    public void clickDeleteAssignmentBtn() {
        Waiters.waitForAllElementsToBeDisplay(getRemoveAssignmentBtn());
        clickOnElement(getRemoveAssignmentBtn());
    }

    public void clickReleaseAssignmentBtn() {
        Waiters.waitForAllElementsToBeDisplay(getReleaseAssignmentBtn());
        clickOnElement(getReleaseAssignmentBtn());
    }

    public void selectInventoryStatus(String type) {
        Waiters.waitForElementToBeDisplay(getInventoryStatusDropdown());
        clickOnElement(getInventoryStatusDropdown());
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        WebElement option = options
                .stream()
                .filter(el -> el.getText().contains(type))
                .findFirst()
                .orElse(null);
        scrollToCenter(option);
        clickOnElement(option);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void waitForLoadingImageToDisappear() {
        Waiters.waitForForAllElementsToDisappear(getLoadingImage());
    }

    public String isRowSelected(int row) {
        Waiters.waitTillLoadingPage(getDriver());
        return getElementAttribute(getSessionTableRows().get(row), "class");
    }

    public boolean isWarningOnPopUpDisplayed(String text) { return isElementDisplay(findWebElement(By.xpath("//div[contains(text(), '"
            + text + "') and @class='i-notification-text']")));
    }

    public String getTasksPerAssignmentsInputValue() { return getValue(getTasksPerAssignmentsInput()); }

    public String getLocationColumnHeaderSortingResult() {
        waitUntilInvisible(2, loader);
        return getElementAttribute(getLocationColumnHeader(), "aria-sort");
    }

    public String getZoneColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getZoneColumnHeader(), "aria-sort");
    }

    public String getTypeColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getTypeColumnHeader(), "aria-sort");
    }

    public String getStatusColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getStatusColumnHeader(), "aria-sort");
    }

    public String getCountsColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getCountsColumnHeader(), "aria-sort");
    }

    public String getReleaseDateTimeColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getReleaseDateTimeColumnHeader(), "aria-sort");
    }

    public String getProductColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getProductColumnHeader(), "aria-sort");
    }

    public String getOwnerColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getOwnerColumnHeader(), "aria-sort");
    }

    public String getDescriptionColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getDescriptionColumnHeader(), "aria-sort");
    }

    public String getBookQtyColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getBookQtyColumnHeader(), "aria-sort");
    }

    public String getBookCostColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getBookCostColumnHeader(), "aria-sort");
    }

    public String getProductTypeColumnHeaderSortingResult() {
        Waiters.waitABit(1000);
        return getElementAttribute(getProductTypeColumnHeader(), "aria-sort");
    }

    public String isEditSessionBtnDisabled() {
        Waiters.waitABit(1000);
        return getElementAttribute(getBtnEditSession(), "aria-disabled");
    }

    public String isDeleteSessionBtnDisabled() {
        Waiters.waitABit(1000);
        return getElementAttribute(getBtnDeleteSession(), "aria-disabled");
    }

    public String isReleaseAssignmentBtnDisabled() {
        Waiters.waitABit(1000);
        return getElementAttribute(getReleaseAssignmentBtn(), "aria-disabled");
    }

    public String isRemoveAssignmentBtnDisabled() {
        Waiters.waitABit(1000);
        return getElementAttribute(getRemoveAssignmentBtn(), "aria-disabled");
    }

    public String isDeleteProductDisabled() {
        Waiters.waitABit(1000);
        return getElementAttribute(getProductRemove(), "aria-disabled");
    }

    public String isResetProductDisabled() {
        Waiters.waitABit(1000);
        return getElementAttribute(getProductReset(), "aria-disabled");
    }

    public boolean isAddProductEnabled() {
        Waiters.waitABit(1000);
        return elementIsEnabled(btnProductAdd);
    }

    public boolean isGenerateLocationsEnabled() {
        Waiters.waitABit(1000);
        return elementIsEnabled(btnGenerateLocations);
    }

    public String getWindowTitleText() { return getText(getWindowTitle()); }

    public String getDialogTitleText() {
        Waiters.waitABit(2000);
        return getText(getDialogTitle());
    }

    public String getItemsFoundValueText() { return getText(getItemsFoundValue()); }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(itemsFoundLabel);
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(itemsFoundValue);
    }

    public boolean isReleaseLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(releaseLabel);
    }

    public boolean isBuildCountAssignmentButtonDisplayed() { return isElementDisplay(buildCountAssignmentButton); }

    public boolean isBuildCountAssignmentLabelDisplayed() { return isElementDisplay(buildCountAssignmentLabel); }

    public boolean isTasksPerAssignmentsLabelDisplayed() { return isElementDisplay(tasksPerAssignmentsLabel); }

    public boolean isTasksPerAssignmentsInputDisplayed() { return isElementDisplay(tasksPerAssignmentsInput); }

    public boolean isUserDirectedCountingButtonDisplayed() { return isElementDisplay(userDirectedCountingButton); }

    public boolean isUserDirectedCountingLabelDisplayed() { return isElementDisplay(userDirectedCountingLabel); }

    public boolean isReleaseTimeInputLabelDisplayed() { return isElementDisplay(timeInputSchedTimeLabel); }

    public boolean isReleaseTimeInputDisplayed() { return isElementDisplay(timeInputSchedTime); }

    public boolean isReleaseDateLabelDisplayed() { return isElementDisplay(dateInputSchedDateLabel); }

    public boolean isReleaseDateInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(dateInputSchedDate);
    }

    public boolean isTimeInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(timeInputSchedTime);
    }

    public boolean isAssignLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(assignLabel);
    }

    public boolean isSessionsPageTitleDisplayed() { return isElementDisplay(sessionsPageTitle); }

    public boolean isCountingSessionLabelDisplayed() { return isElementDisplay(countingSessionLabel); }

    public boolean isSessionDropdownDisplayed() { return isElementDisplay(sessionDropdown); }

    public boolean isNewSessionButtonDisplayed() { return isElementDisplay(btnNewSession); }

    public boolean isEditSessionButtonDisplayed() { return isElementDisplay(btnEditSession); }

    public boolean isDeleteSessionButtonDisplayed() { return isElementDisplay(btnDeleteSession); }

    public boolean isLocationsTabDisplayed() { return isElementDisplay(getLocationsTab()); }

    public boolean isProductsTabDisplayed() { return isElementDisplay(getProductsTab()); }

    public boolean isAssignmentsTabDisplayed() { return isElementDisplay(getAssignmentsTab()); }

    public boolean isSessionNameLabelDisplayed() { return isElementDisplay(sessionNameLabel); }

    public boolean isSessionNameDisplayed() { return isElementDisplay(sessionName); }

    public boolean isLocationWindowTitleDisplayed() { return isElementDisplay(getLocationWindowTitle()); }

    public boolean isReleaseCountsWindowTitleDisplayed() { return isElementDisplay(getReleaseCountsWindowTitle()); }

    public boolean isCountTypeLabelDisplayed() { return isElementDisplay(countTypeLabel); }

    public boolean isCountTypeDisplayed() { return isElementDisplay(countType); }

    public boolean isCancelButtonDisplayed() { return isElementDisplay(cancelButton); }

    public boolean isSaveButtonDisplayed() { return isElementDisplay(saveButton); }

    public boolean isLocationAddDisplayed() { return isElementDisplay(btnCSLocationAdd); }

    public boolean isLocationRemoveDisplayed() { return isElementDisplay(btnLocationRemove); }

    public boolean isLocationReleaseDisplayed() { return isElementDisplay(btnLocationRelease); }

    public boolean isLocationReconcileDisplayed() { return isElementDisplay(btnLocationReconcile); }

    public boolean isLocationCodeInputDisplayed() { return isElementDisplay(locationCodeInput); }

    public boolean isPartialLocationCodeInputDisplayed() { return isElementDisplay(partialLocationCodeInput); }

    public boolean isZoneDropdownDisplayed() { return isElementDisplay(zoneDropdown); }

    public boolean isLocationTypeDropdownDisplayed() { return isElementDisplay(locationTypeDropdown); }

    public boolean isStartingLocationInputDisplayed() { return isElementDisplay(startingLocationInput); }

    public boolean isEndingLocationInputDisplayed() { return isElementDisplay(endingLocationInput); }

    public boolean isControlLabelDisplayed() { return isElementDisplay(controlLabel); }

    public boolean isUserColumnDisplayed() { return isElementDisplay(userColumn); }

    public boolean isUserColumnHeaderDisplayed() { return isElementDisplay(userColumnHeader); }

    public boolean isStartTimeColumnDisplayed() { return isElementDisplay(startTimeColumn); }

    public boolean isStartTimeColumnHeaderDisplayed() { return isElementDisplay(startTimeColumnHeader); }

    public boolean isEndTimeColumnDisplayed() { return isElementDisplay(endTimeColumn); }

    public boolean isEndTimeColumnHeaderDisplayed() { return isElementDisplay(endTimeColumnHeader); }

    public boolean isErrorsColumnDisplayed() { return isElementDisplay(errorsColumn); }

    public boolean isErrorsColumnHeaderDisplayed() { return isElementDisplay(errorsColumnHeader); }

    public boolean isStatusColumnDisplayed() { return isElementDisplay(statusColumn); }

    public boolean isStatusColumnHeaderDisplayed() { return isElementDisplay(statusColumnHeader); }

    public boolean isOkButtonDisplayed() { return isElementDisplay(okButton); }

    public boolean isPalletColumnDisplayed() { return isElementDisplay(palletColumn); }

    public boolean isPalletColumnHeaderDisplayed() { return isElementDisplay(palletColumnHeader); }

    public boolean isVarianceColumnDisplayed() { return isElementDisplay(varianceColumn); }

    public boolean isVarianceColumnHeaderDisplayed() { return isElementDisplay(varianceColumnHeader); }

    public boolean isCountedQtyColumnDisplayed() { return isElementDisplay(countedQtyColumn); }

    public boolean isCountedQtyColumnHeaderDisplayed() { return isElementDisplay(countedQtyColumnHeader); }

    public boolean isCurrentQtyColumnDisplayed() { return isElementDisplay(currentQtyColumn); }

    public boolean isCurrentQtyColumnHeaderDisplayed() { return isElementDisplay(currentQtyColumnHeader); }

    public boolean isUomColumnDisplayed() { return isElementDisplay(uomColumn); }

    public boolean isUomColumnHeaderDisplayed() { return isElementDisplay(uomColumnHeader); }

    public boolean isProductColumnDisplayed() { return isElementDisplay(productColumn); }

    public boolean isProductColumnHeaderDisplayed() { return isElementDisplay(productColumnHeader); }

    public boolean isOwnerColumnDisplayed() { return isElementDisplay(ownerColumn); }

    public boolean isOwnerColumnHeaderDisplayed() { return isElementDisplay(ownerColumnHeader); }

    public boolean isCustomerColumnDisplayed() { return isElementDisplay(customerColumn); }

    public boolean isCustomerColumnHeaderDisplayed() { return isElementDisplay(customerColumnHeader); }

    public boolean isDescriptionColumnDisplayed() { return isElementDisplay(descriptionColumn); }

    public boolean isDescriptionColumnHeaderDisplayed() { return isElementDisplay(descriptionColumnHeader); }

    public boolean isBookCostColumnDisplayed() { return isElementDisplay(bookCostColumn); }

    public boolean isBookCostColumnHeaderDisplayed() { return isElementDisplay(bookCostColumnHeader); }

    public boolean isProductTypeTimeColumnDisplayed() { return isElementDisplay(productTypeTimeColumn); }

    public boolean isProductTypeColumnHeaderDisplayed() { return isElementDisplay(productTypeColumnHeader); }

    public boolean isBtnGenerateLocationsDisplayed() { return isElementDisplay(getBtnGenerateLocations()); }

    public int areRowsDisplayed() { return elementsArePresent(getSessionTableRows()); }

    public boolean isProductLabelDisplayed() { return isElementDisplay(productLabel); }

    public boolean isProductInputDisplayed() { return isElementDisplay(txtProductInput); }

    public boolean isProductTypeLabelDisplayed() { return isElementDisplay(productTypeLabel); }

    public boolean isProductTypeInputDisplayed() { return isElementDisplay(productTypeInput); }

    public boolean isMovementClassLabelDisplayed() { return isElementDisplay(movementClassLabel); }

    public boolean isMovementDropdownDisplayed() { return isElementDisplay(movementDropdown); }

    public boolean isNoOfProductsLabelDisplayed() { return isElementDisplay(noOfProductsLabel); }

    public boolean isNoOfProductsInputDisplayed() { return isElementDisplay(noOfProductsInput); }

    public boolean isMinimumCostLabelDisplayed() { return isElementDisplay(minimumCostLabel); }

    public boolean isMinimumCostInputDisplayed() { return isElementDisplay(minimumCostInput); }

    public boolean isMaximumCostLabelDisplayed() { return isElementDisplay(maximumCostLabel); }

    public boolean isMaximumCostDisplayed() { return isElementDisplay(maximumCost); }

    public boolean isOwnerLabelDisplayed() { return isElementDisplay(ownerLabel); }

    public boolean isOwnerDropdownDisplayed() { return isElementDisplay(ddlOwnerDropdown); }

    public boolean isSupplierLabelDisplayed() { return isElementDisplay(supplierIndexLabel); }

    public boolean isSupplierInputDisplayed() { return isElementDisplay(supplierInput); }

    public boolean isStartingProdRangeLabelDisplayed() { return isElementDisplay(startingProdRangeLabel); }

    public boolean isStartingProdRangeDisplayed() { return isElementDisplay(startingProdRange); }

    public boolean isEndingProdRangeLabelDisplayed() { return isElementDisplay(endingProdRangeLabel); }

    public boolean isEndingProdRangeDisplayed() { return isElementDisplay(endingProdRange); }

    public boolean isLoadingImageDisplayed() { return isElementDisplay(getLoadingImage()); }

    public boolean isNotificationMsgDisplayed() { return isElementDisplay(getNotificationMsg()); }

    public boolean isAddFilterButtonDisplayed() { return isElementDisplay(getAddFilterButton()); }

    public boolean isRemoveAssignmentBtnDisplayed() { return isElementDisplay(getRemoveAssignmentBtn()); }

    public boolean isReleaseAssignmentBtnDisplayed() { return isElementDisplay(getReleaseAssignmentBtn()); }

    public boolean isLocationColumnDisplayed() { return isElementDisplay(getLocationColumn()); }

    public boolean isLocationColumnHeaderDisplayed() { return isElementDisplay(getLocationColumnHeader()); }

    public boolean isZoneColumnDisplayed() { return isElementDisplay(getZoneColumn()); }

    public boolean isZoneColumnHeaderDisplayed() { return isElementDisplay(getZoneColumnHeader()); }

    public boolean isTypeColumnDisplayed() { return isElementDisplay(getTypeColumn()); }

    public boolean isTypeColumnHeaderDisplayed() { return isElementDisplay(getTypeColumnHeader()); }

    public boolean isCountsColumnDisplayed() { return isElementDisplay(getCountsColumn()); }

    public boolean isCountsColumnHeaderDisplayed() { return isElementDisplay(getCountsColumnHeader()); }

    public boolean isReleaseDateTimeColumnDisplayed() { return isElementDisplay(getReleaseDateTimeColumn()); }

    public boolean isReleaseDateTimeColumnHeaderDisplayed() { return isElementDisplay(getReleaseDateTimeColumnHeader()); }

    public boolean isAssignmentColumnDisplayed() { return isElementDisplay(getAssignmentColumn()); }

    public boolean isAssignmentColumnHeaderDisplayed() { return isElementDisplay(getAssignmentColumnHeader()); }

    public boolean isTotalTasksColumnDisplayed() { return isElementDisplay(getTotalTasksColumn()); }

    public boolean isTotalTasksColumnHeaderDisplayed() { return isElementDisplay(getTotalTasksColumnHeader()); }

    public boolean isCompletedColumnDisplayed() { return isElementDisplay(getCompletedColumn()); }

    public boolean isCompletedColumnHeaderDisplayed() { return isElementDisplay(getCompletedColumnHeader()); }

    public boolean isTaskGroupColumnDisplayed() { return isElementDisplay(getTaskGroupColumn()); }

    public boolean isTaskGroupColumnHeaderDisplayed() { return isElementDisplay(getTaskGroupColumnHeader()); }

    public boolean isReleasedColumnDisplayed() { return isElementDisplay(getReleasedColumn()); }

    public boolean isReleasedColumnHeaderDisplayed() { return isElementDisplay(getReleasedColumnHeader()); }

    public boolean isXcancelIconDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getXcancelIcon());
    }

    public boolean isLocationsLabelDisplayed() { return isElementDisplay(getLocationsLabel()); }

    public boolean isBlindLabelDisplayed() { return isElementDisplay(getBlindLabel()); }

    public boolean isPartiallyInformedLabelDisplayed() { return isElementDisplay(getPartiallyInformedLabel()); }

    public boolean isAutoReconcileLabelDisplayed() { return isElementDisplay(getAutoReconcileLabel()); }

    public boolean isActiveCheckboxDisplayed() { return isElementDisplay(getActiveCheckbox()); }

    public boolean isLocCodeButtonDisplayed() { return isElementDisplay(locCodeButton); }

    public boolean isSearchInputDisplayed() { return isElementDisplay(searchInput); }

    public boolean isTableContentDisplayed() { return isElementDisplay(tableContent); }

    public boolean isDialogCancelButtonDisplayed() { return isElementDisplay(getDialogCancelButton()); }

    public boolean isNotificationDisplayed(String text) { return isElementDisplay(getNotification(text)); }

    public boolean isAssignmentCodeFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(assignmentCodeFilter);
    }

    public boolean isTotalTasksFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(totalTasksFilter);
    }

    public boolean isCompletedTasksFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(completedTasksFilter);
    }

    public boolean isUserNameFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(userNameFilter);
    }

    public boolean isTaskGroupFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(taskGroupFilter);
    }

    public boolean isReleasedDateTimeFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(releasedDateTimeFilter);
    }

    public boolean isSearchBoxDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(searchBox);
    }

    public boolean isAddFilterDisplayed() { return isElementDisplay(getAddFilter()); }

    public WebElement getAddFilter() { return findWebElement(addFilter); }

    public WebElement getSessionsPageTitle() { return findWebElement(sessionsPageTitle); }

    public WebElement getCountingSessionLabel() { return findWebElement(countingSessionLabel); }

    public WebElement getSessionDropdown() { return findWebElement(sessionDropdown); }

    public WebElement getBtnNewSession() { return findWebElement(btnNewSession); }

    public WebElement getBtnEditSession() { return findWebElement(btnEditSession); }

    public WebElement getBtnDeleteSession() { return findWebElement(btnDeleteSession); }

    public WebElement getLocationsTab() { return findWebElement(locationsTab); }

    public WebElement getProductsTab() { return findWebElement(productsTab); }

    public WebElement getAssignmentsTab() { return findWebElement(assignmentsTab); }

    public WebElement getDialogTitle() { return findWebElement(dialogTitle); }

    public WebElement getSessionNameLabel() { return findWebElement(sessionNameLabel); }

    public WebElement getSessionName() { return findWebElement(sessionName); }

    public WebElement getCountTypeLabel() { return findWebElement(countTypeLabel); }

    public WebElement getCountType() { return findWebElement(countType); }

    public WebElement getCancelButton() { return findWebElement(cancelButton); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getActiveCheckbox() { return findWebElement(activeCheckbox); }

    public WebElement getLocationAdd() { return findWebElement(btnCSLocationAdd); }

    public WebElement getLocationRemove() { return findWebElement(btnLocationRemove); }

    public WebElement getLocationRelease() { return findWebElement(btnLocationRelease); }

    public WebElement getLocationReconcile() { return findWebElement(btnLocationReconcile); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getLocationCodeInput() { return findWebElement(locationCodeInput); }

    public WebElement getPartialLocationCodeInput() { return findWebElement(partialLocationCodeInput); }

    public WebElement getLocCodeButton() { return findWebElement(locCodeButton); }

    public WebElement getZoneDropdown() { return findWebElement(zoneDropdown); }

    public WebElement getLocationTypeDropdown() { return findWebElement(locationTypeDropdown); }

    public WebElement getStartingLocationInput() { return findWebElement(startingLocationInput); }

    public WebElement getEndingLocationInput() { return findWebElement(endingLocationInput); }

    public List<WebElement> getSessionTableRows() { return findWebElements(sessionTableRows); }

    public WebElement getWindowTitle() { return findWebElement(windowTitle); }

    public WebElement getLocationWindowTitle() { return findWebElement(locationWindowTitle); }

    public WebElement getReleaseCountsWindowTitle() { return findWebElement(releaseCountsWindowTitle); }

    public WebElement getControlLabel() { return findWebElement(controlLabel); }

    public WebElement getUserColumn() { return findWebElement(userColumn); }

    public WebElement getUserColumnHeader() { return findWebElement(userColumnHeader); }

    public WebElement getStartTimeColumn() { return findWebElement(startTimeColumn); }

    public WebElement getStartTimeColumnHeader() { return findWebElement(startTimeColumnHeader); }

    public WebElement getEndTimeColumn() { return findWebElement(endTimeColumn); }

    public WebElement getEndTimeColumnHeader() { return findWebElement(endTimeColumnHeader); }

    public WebElement getErrorsColumn() { return findWebElement(errorsColumn); }

    public WebElement getErrorsColumnHeader() { return findWebElement(errorsColumnHeader); }

    public WebElement getStatusColumn() { return findWebElement(statusColumn); }

    public WebElement getStatusColumnHeader() { return findWebElement(statusColumnHeader); }

    public List<WebElement> getCountDetailsRows() { return findWebElements(countDetailsRows); }

    public WebElement getLocationColumn() { return findWebElement(locationColumn); }

    public WebElement getLocationColumnHeader() {
        Waiters.waitABit(3000);
        return findWebElement(locationColumnHeader);
    }

    public WebElement getZoneColumn() { return findWebElement(zoneColumn); }

    public WebElement getZoneColumnHeader() { return findWebElement(zoneColumnHeader); }

    public WebElement getTypeColumn() { return findWebElement(typeColumn); }

    public WebElement getTypeColumnHeader() { return findWebElement(typeColumnHeader); }

    public WebElement getCountsColumn() { return findWebElement(countsColumn); }

    public WebElement getCountsColumnHeader() { return findWebElement(countsColumnHeader); }

    public WebElement getReleaseDateTimeColumn() { return findWebElement(releaseDateTimeColumn); }

    public WebElement getReleaseDateTimeColumnHeader() { return findWebElement(releaseDateTimeColumnHeader); }

    public WebElement getProductColumn() { return findWebElement(productColumn); }

    public WebElement getProductColumnHeader() { return findWebElement(productColumnHeader); }

    public WebElement getOwnerColumn() { return findWebElement(ownerColumn); }

    public WebElement getOwnerColumnHeader() { return findWebElement(ownerColumnHeader); }

    public WebElement getCustomerColumn() { return findWebElement(customerColumn); }

    public WebElement getCustomerColumnHeader() { return findWebElement(customerColumnHeader); }

    public WebElement getDescriptionColumn() { return findWebElement(descriptionColumn); }

    public WebElement getDescriptionColumnHeader() { return findWebElement(descriptionColumnHeader); }

    public WebElement getBookCostColumn() { return findWebElement(bookCostColumn); }

    public WebElement getBookCostColumnHeader() { return findWebElement(bookCostColumnHeader); }

    public WebElement getProductTypeTimeColumn() { return findWebElement(productTypeTimeColumn); }

    public WebElement getProductTypeColumnHeader() { return findWebElement(productTypeColumnHeader); }

    public WebElement getBookQtyColumn() { return findWebElement(bookQtyColumn); }

    public WebElement getBookQtyColumnHeader() { return findWebElement(bookQtyColumnHeader); }

    public WebElement getPalletColumn() { return findWebElement(palletColumn); }

    public WebElement getPalletColumnHeader() { return findWebElement(palletColumnHeader); }

    public WebElement getUomColumn() { return findWebElement(uomColumn); }

    public WebElement getUomColumnHeader() { return findWebElement(uomColumnHeader); }

    public WebElement getCurrentQtyColumn() { return findWebElement(currentQtyColumn); }

    public WebElement getCurrentQtyColumnHeader() { return findWebElement(currentQtyColumnHeader); }

    public WebElement getCountedQtyColumn() { return findWebElement(countedQtyColumn); }

    public WebElement getCountedQtyColumnHeader() { return findWebElement(countedQtyColumnHeader); }

    public WebElement getVarianceColumn() { return findWebElement(varianceColumn); }

    public WebElement getVarianceColumnHeader() { return findWebElement(varianceColumnHeader); }

    public WebElement getBtnGenerateLocations() { return findWebElement(btnGenerateLocations); }

    public WebElement getProductGridSearch() { return findWebElement(productGridSearch); }

    public WebElement getAssignmentGridSearch() { return findWebElement(assignmentGridSearch); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getItemsFoundValue() { return findWebElement(itemsFoundValue); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getSearchInput() { return findWebElement(searchInput); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public WebElement getDialogCancelButton() { return findWebElement(dialogCancelButton); }

    public WebElement getItemsCount() { return findWebElement(itemsCount); }

    public WebElement getItemsFound() { return findWebElement(itemsFound); }

    public WebElement getProductCodeFilter() { return findWebElement(productCodeFilter); }

    public WebElement getOwnerCodeFilter() { return findWebElement(ownerCodeFilter); }

    public WebElement getProductDescFilter() { return findWebElement(productDescFilter); }

    public WebElement getBookQtyFilter() { return findWebElement(bookQtyFilter); }

    public WebElement getBookCostFilter() { return findWebElement(bookCostFilter); }

    public WebElement getProductTypeFilter() { return findWebElement(productTypeFilter); }

    public WebElement getClearAllButton() { return findWebElement(clearAllButton); }

    public WebElement getInputContains() { return findWebElement(inputContains); }

    public WebElement getApplyButton() { return findWebElement(applyButton); }

    public WebElement getBtnProductAdd() { return findWebElement(btnProductAdd); }

    public WebElement getProductLabel() { return findWebElement(productLabel); }

    public WebElement getTxtProductInput() { return findWebElement(txtProductInput); }

    public WebElement getProductTypeLabel() { return findWebElement(productTypeLabel); }

    public WebElement getProductTypeInput() { return findWebElement(productTypeInput); }

    public WebElement getMovementClassLabel() { return findWebElement(movementClassLabel); }

    public WebElement getMovementDropdown() { return findWebElement(movementDropdown); }

    public WebElement getNoOfProductsLabel() { return findWebElement(noOfProductsLabel); }

    public WebElement getNoOfProductsInput() { return findWebElement(noOfProductsInput); }

    public WebElement getMinimumCostLabel() { return findWebElement(minimumCostLabel); }

    public WebElement getMinimumCostInput() { return findWebElement(minimumCostInput); }

    public WebElement getMaximumCostLabel() { return findWebElement(maximumCostLabel); }

    public WebElement getMaximumCost() { return findWebElement(maximumCost); }

    public WebElement getOwnerLabel() { return findWebElement(ownerLabel); }

    public WebElement getDdlOwnerDropdown() { return findWebElement(ddlOwnerDropdown); }

    public WebElement getSupplierIndexLabel() { return findWebElement(supplierIndexLabel); }

    public WebElement getSupplierInput() { return findWebElement(supplierInput); }

    public WebElement getSupplierInputIcon() { return findWebElement(supplierInputIcon); }

    public WebElement getStartingProdRangeLabel() { return findWebElement(startingProdRangeLabel); }

    public WebElement getStartingProdRange() { return findWebElement(startingProdRange); }

    public WebElement getEndingProdRangeLabel() { return findWebElement(endingProdRangeLabel); }

    public WebElement getEndingProdRange() { return findWebElement(endingProdRange); }

    public WebElement getLoadingImage() { return findWebElement(loadingImage); }

    public WebElement getProductAliasTypeLabel() { return findWebElement(productAliasTypeLabel); }

    public WebElement getProductAliasTypeDropdown() { return findWebElement(productAliasTypeDropdown); }

    public WebElement getInventoryStatusLabel() { return findWebElement(inventoryStatusLabel); }

    public WebElement getInventoryStatusDropdown() { return findWebElement(inventoryStatusDropdown); }

    public WebElement getPopupTable() { return findWebElement(popupTable); }

    public WebElement getAllCheckbox() { return findWebElement(allCheckbox); }

    public WebElement getProductRemove() { return findWebElement(btnProductRemove); }

    public WebElement getProductReset() { return findWebElement(btnProductReset); }

    public WebElement getProductLocations() { return findWebElement(btnProductLocations); }

    public WebElement getRemoveAssignmentBtn() { return findWebElement(removeAssignmentBtn); }

    public WebElement getReleaseAssignmentBtn() { return findWebElement(releaseAssignmentBtn); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

    public WebElement getAssignmentColumn() { return findWebElement(assignmentColumn); }

    public WebElement getAssignmentColumnHeader() { return findWebElement(assignmentColumnHeader); }

    public WebElement getTotalTasksColumn() { return findWebElement(totalTasksColumn); }

    public WebElement getTotalTasksColumnHeader() { return findWebElement(totalTasksColumnHeader); }

    public WebElement getCompletedColumn() { return findWebElement(completedColumn); }

    public WebElement getCompletedColumnHeader() { return findWebElement(completedColumnHeader); }

    public WebElement getTaskGroupColumn() { return findWebElement(taskGroupColumn); }

    public WebElement getTaskGroupColumnHeader() { return findWebElement(taskGroupColumnHeader); }

    public WebElement getReleasedColumn() { return findWebElement(releasedColumn); }

    public WebElement getReleasedColumnHeader() {  return findWebElement(releasedColumnHeader); }

    public List<WebElement> getCheckBoxes() { return findWebElements(checkBoxes); }

    public WebElement getXcancelIcon() { return findWebElement(XcancelIcon); }

    private WebElement getCalendarDay(String text) {
        return findWebElement(By.xpath("//div[contains(@class, 'k-calendar-container')]//*[text()='" + text + "']"));
    }

    public WebElement getToggleCalendar() { return findWebElement(toggleCalendar); }

    public WebElement getTimeInputSchedTime() { return findWebElement(timeInputSchedTime); }

    public WebElement getUserDropdown() { return findWebElement(userDropdown); }

    public WebElement getAllAssignmentsCheckBox() { return findWebElement(allAssignmentsCheckBox); }

    public WebElement getLocationsLabel() { return findWebElement(locationsLabel); }

    public WebElement getBlindLabel() { return findWebElement(blindLabel); }

    public WebElement getPartiallyInformedLabel() { return findWebElement(partiallyInformedLabel); }

    public WebElement getAutoReconcileLabel() { return findWebElement(autoReconcileLabel); }

    public WebElement getDeleteReason() { return findWebElement(ddlDeleteReason); }

    public WebElement getReasonLabel() { return findWebElement(ddlDeleteReasonLabel); }

    public WebElement getAllInputsCheckbox() { return findWebElement(allInputsCheckbox); }

    public WebElement getTasksPerAssignmentsInput() { return findWebElement(tasksPerAssignmentsInput); }

    public WebElement getClearFilter() { return findWebElement(clearFilter); }

}
