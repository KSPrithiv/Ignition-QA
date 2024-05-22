package ui.pages.outbound.routesummary;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;
import java.util.Random;

import static common.setup.DriverManager.getDriver;

public class OutboundRouteSummaryPage extends BasePage {
    By title = By.cssSelector(".spnmoduleNameHeader");
    By routeStart = By.id("dateRouteStart");
    By routeEnd = By.id("dateRouteEnd");
    By enterRoute = By.xpath("//input[@placeholder='Enter route']");
    By enterAccount = By.cssSelector("input[placeholder='Enter a account']");
    By searchAccountButton = By
            .xpath("//div[@class='i-indexfield-container__main'][.//input[@placeholder='Enter a account']]//button");
    By enterProduct = By.cssSelector("input[placeholder='Enter a product']");
    By searchProductButton = By
            .xpath("//div[@class='i-indexfield-container__main'][.//input[@placeholder='Enter a product']]//button");
    By routeOptions = By.cssSelector("button[aria-label='Route options dropdownbutton']");
    By shippedStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--green')]]");
    By auditStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--purple')]]");
    By pickedStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--yellow')]]");
    By unallocatedStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--orange')]]");
    By shortsStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--red')]]");
    By waitingInboundStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--blue')]]");
    By remainderStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--gray')]]");
    By routesColumn = By.xpath("//span[contains(text(), 'Routes')]");
    By ordersColumn = By.xpath("//span[contains(text(), 'Orders')]");
    By quantityColumn = By.xpath("//span[contains(text(), 'Quantity')]");
    By linesColumn = By.xpath("//span[contains(text(), 'Lines')]");
    By palletsColumn = By.xpath("//span[contains(text(), 'Pallets')]");
    By cubeColumn = By.xpath("//span[contains(text(), 'Cube')]");
    By weightColumn = By.xpath("//span[contains(text(), 'Weight')]");
    By amountColumn = By.xpath("//span[contains(text(), 'Amount')]");
    By tableContent = By.cssSelector(".k-grid-content");
    By itemsCount = By.cssSelector(".i-summary-area__main");
    By loadingImage = By.cssSelector(".k-loading-image");
    By windowPopup = By.cssSelector(".k-window-title");
    By windowContent = By.cssSelector(".k-window-content");
    By accountSearch = By.cssSelector("#gridUtilSearch_productSearchIndex");
    By itemsCountNumber = By.cssSelector("#GridUtilsPOLines .i-summary-area__main__value");
    By itemsFound = By.cssSelector("#GridUtilsPOLines .i-summary-area__main__label");
    By routesContent = By.cssSelector("#GridUtilsPOLines .k-grid-container");
    By assignmentsTable = By.xpath("//div[contains(@class, 'outBoundRSummaryWQAssignmentGrid')]");
    By assignmentItemsCountNumber = By.cssSelector("#wqAssignmentGrid .i-summary-area__main__value");
    By assignmentItemsFound = By.cssSelector("#wqAssignmentGrid .i-summary-area__main__label");
    By assignmentSelectedItemsCountNumber = By.cssSelector("#wqAssignmentGrid .i-summary-area__other__section__value");
    By assignmentSelectedItemsFound = By.cssSelector("#wqAssignmentGrid .i-summary-area__other__section__label");
    By tasksSelectedItemsCountNumber = By.cssSelector("#wqTaskGrid .i-summary-area__other__section__value");
    By tasksSelectedItemsFound = By.cssSelector("#wqTaskGrid .i-summary-area__other__section__label");
    By tasksItemsCountNumber = By.cssSelector("#wqTaskGrid .i-summary-area__main__value");
    By tasksItemsFound = By.cssSelector("#wqTaskGrid .i-summary-area__main__label");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By backButton = By.xpath("//button[contains(text(), 'Back')]");
    By changeStatus = By.id("btnChangeStatus");
    By doorList = By.id("ddDoorList");
    By workItem = By.id("ddWorkItem");
    By assignItem = By.id("ddAssignItem");
    By searchIcon = By.cssSelector("#gridUtilSearch_productSearchIndex");
    By productSearchIndex = By.id("gridUtil_productSearchIndex");
    By assignmentTab = By.xpath("//li[@role='tab'][.//span[text()='Assignments']]");
    By tasksTab = By.xpath("//li[@role='tab']//span[text()='Tasks']");
    By assignmentTypeDropDown = By.xpath("//span[contains(text(), 'Assignment type:')]");
    By statusesDropDown = By.xpath("//span[contains(text(), 'Status:')]");
    By typesDropDown = By.xpath("//span[contains(text(), 'Type:')]");
    By productColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Product')]");
    By qtyColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Qty')]");
    By fromColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'From')]");
    By toColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'To')]");
    By typeColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Type')]");
    By taskGroupColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Task group')]");
    By statusColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Status')]");
    By assignmentNumColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Assignment #')]");
    By inUseByColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'In Use By')]");
    By priorityColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Priority')]");
    By routeColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Route')]");
    By stopColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Stop')]");
    By shipperColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Shipper')]");
    By velocityColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Velocity')]");
    By descriptionColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Description')]");
    By taskGroupDropDown = By.xpath("//span[contains(text(), 'Task group:')]");
    By topOffTaskButton = By.id("topOffTaskButton");
    By editAssignmentBtn = By.cssSelector("#EditAssignmentButton");
    By deleteAssignmentBtn = By.cssSelector("#deleteAssignmetButton");
    By releaseAssignmentBtn = By.cssSelector("#ReleaseAssignmentButton");
    By printAssignmentBtn = By.cssSelector("#PrintAssignmentButton");
    By moveAssignmentBtn = By.cssSelector("#moveTaskButton");
    By moveTaskBtn = By.cssSelector("#moveTaskButton");
    By editTaskBtn = By.cssSelector("#editTaskButton");
    By deleteTaskBtn = By.cssSelector("#removeTaskButton");
    By reprocessTaskBtn = By.cssSelector("#reprocessTasksButton");
    By addFilterButton = By.cssSelector(".i-filter-tag__main__text--add");
    By assignmentCodeFilter = By.cssSelector(".i-btn-checkbox  #AssignmentCode");
    By routeFilter = By.cssSelector(".i-btn-checkbox  #Route");
    By stopsFilter = By.cssSelector(".i-btn-checkbox  #Stops");
    By shipperFilter = By.cssSelector(".i-btn-checkbox  #Shipper");
    By shipToFilter = By.cssSelector(".i-btn-checkbox  #ShipTo");
    By tasksFilter = By.cssSelector(".i-btn-checkbox  #Tasks");
    By assignToFilter = By.cssSelector(".i-btn-checkbox  #AssignTo");
    By releasedFilter = By.cssSelector(".i-btn-checkbox  #Released");
    By qtyFilter = By.cssSelector(".i-btn-checkbox  #Qty");
    By cubeFilter = By.cssSelector(".i-btn-checkbox  #Cube");
    By weightFilter = By.cssSelector(".i-btn-checkbox  #Weight");
    By assignmentTypeFilter = By.cssSelector(".i-btn-checkbox  #AssignmentType");
    By taskGroupFilter = By.cssSelector(".i-btn-checkbox  #TaskGroup");
    By percentPickedFilter = By.cssSelector(".i-btn-checkbox  #PercentPicked");
    By inUseByFilter = By.cssSelector(".i-btn-checkbox  #InUseBy");
    By statusFilter = By.cssSelector(".i-btn-checkbox  #Status");
    By estimatedTimeFilter = By.cssSelector(".i-btn-checkbox  #EstimatedTime");
    By standardTimeFilter = By.cssSelector(".i-btn-checkbox  #StandardTime");
    By actualTimeFilter = By.cssSelector(".i-btn-checkbox  #ActualTime");
    By activityIndicatorFilter = By.cssSelector(".i-btn-checkbox  #ActivityIndicator");
    By remainingFilter = By.cssSelector(".i-btn-checkbox  #Remaining");
    By printedFilter = By.cssSelector(".i-btn-checkbox  #Printed");
    By productFilter = By.cssSelector(".i-btn-checkbox  #Product");
    By fromFilter = By.cssSelector(".i-btn-checkbox  #From");
    By toFilter = By.cssSelector(".i-btn-checkbox  #To");
    By typeFilter = By.cssSelector(".i-btn-checkbox  #Type");
    By assignmentNumberFilter = By.cssSelector(".i-btn-checkbox  #AssignmentNumber");
    By priorityFilter = By.cssSelector(".i-btn-checkbox  #Priority");
    By stopFilter = By.cssSelector(".i-btn-checkbox  #Stop");
    By velocityFilter = By.cssSelector(".i-btn-checkbox  #Velocity");
    By descriptionFilter = By.cssSelector(".i-btn-checkbox  #Description");
    By quantityFilter = By.cssSelector(".i-btn-checkbox  #strQty");
    By taskTableHeaders = By.cssSelector("#wqTaskGrid .k-grid-header th");
    By assignmentsTableHeaders = By.cssSelector("#wqAssignmentGrid .k-grid-header th");
    By releaseCheckbox = By.cssSelector("#isRelease");
    By allAssignmentsCheckbox = By.cssSelector("#wqAssignmentGrid .i-btn-checkbox");
    By allTasksCheckbox = By.cssSelector("#wqTaskGrid .i-btn-checkbox");
    By routeTitle = By.cssSelector(".i-card__header__title");
    By allTasksGridTable = By.cssSelector(".outBoundRSummaryWQTaskGrid .k-grid-container");
    By editTaskQtyLabel = By.cssSelector("#wqTextTaskQty-label");
    By editTaskQty = By.cssSelector("#wqTextTaskQty");
    By editTaskReasonLabel = By.cssSelector("#wqListTaskTopOff-label");
    By editTaskReason = By.cssSelector("#wqListTaskTopOff");
    By editTaskFromLocationLabel = By.cssSelector("#wqListTaskFromLocation-label");
    By editTaskFromLocation = By.cssSelector("#wqListTaskFromLocation");
    By editTaskPrioritiesLabel = By.cssSelector("#wqListTaskPriorities-label");
    By editTaskPriorities = By.cssSelector("#wqListTaskPriorities");
    By editTaskGroupLabel = By.cssSelector("#wqListTaskGroup-label");
    By editTaskGroup = By.cssSelector("#wqListTaskGroup");
    By editTaskPalletsLabel = By.cssSelector("#wqListTaskPallets-label");
    By editTaskPallets = By.cssSelector("#wqListTaskPallets");
    By taskNotification = By.cssSelector(".k-dialog-content .i-notification-text");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By okButton = By.xpath("//button[contains(text(), 'Ok')]");
    By replenishToCleanCheckBox = By.cssSelector("#replenishToClean");
    By notificationMsg = By.cssSelector(".toast-message");
    By topOffModalZoneDropDown = By.cssSelector("#WorkQueueTasksButtonTopOffModalZoneDropDown");
    By moveToAssignmentLabel = By.xpath("//label[contains(text(), 'Move to assignment')]");
    By moveToNewAssignmentRadioButton = By.xpath("//input[@value='moveToNewAssignment']");
    By moveToExistingAssignmentRadioButton = By.xpath("//input[@value='moveToExistingAssignment']");
    By moveToNewShipperRadioButton = By.xpath("//input[@value='moveToNewShipper']");
    By moveToExistingShipperRadioButton = By.xpath("//input[@value='moveToExistingShipper']");
    By existingAssignmentTxtBox = By.xpath("//div[@data-test-id='existingAssignmentTxtBox']");
    By userDropdown = By.xpath("//span[.//label[text()='User']]//span[@class='k-input']");
    By routeCodeLabel = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Route code']]");
    By routeCodeInput = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Route code']]//input");
    By scheduledDateLabel = By.cssSelector("#cpDate-label");
    By scheduledDate = By.cssSelector("#cpDate");
    By carrierLabel = By.xpath("//label[contains(text(), 'Carrier')]");
    By carrierInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Carrier')]]//span[@class='k-input']");
    By routeTypeLabel = By.xpath("//label[contains(text(), 'Route type')]");
    By routeTypeInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Route type')]]//span[@class='k-input']");
    By trailerLabel = By.xpath("//label[contains(text(), 'Trailer')]");
    By trailerInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Trailer')]]//span[@class='k-input']");
    By scheduledTimeLabel = By.cssSelector("#cpTile-label");
    By scheduledTimeInput = By.cssSelector("#cpTile");
    By driverLabel = By.xpath("//label[contains(text(), 'Driver')]");
    By driverInput = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Driver']]//input");
    By maxStopsLabel = By.xpath("//label[contains(text(), 'Max stops')]");
    By maxStopsInput = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Max stops']]//input");
    By temperatureLabel = By.xpath("//label[contains(text(), 'Temperature')]");
    By temperatureInput = By.xpath("//span[contains(@class,'k-textbox-container')][.//label[text()='Temperature']]//input");
    By dataAlt1 = By.xpath("//input[@name='Alt1']");
    By dataAlt2 = By.xpath("//input[@name='Alt2']");
    By dataAlt3 = By.xpath("//input[@name='alt3']");
    By dataRouteCardPageTitle = By.cssSelector("#crdEnterDataRouteCard .i-card__header__title");
    By sourceOrderTypeColumn = By.xpath("//span[text()='Order type']");
    By sourceOrderColumn = By.xpath("//span[text()='Order no.']");
    By sourceStatusColumn = By.xpath("//span[text()='Status']");
    By sourceList = By.cssSelector("#divSourceList");
    By sourceBlock = By.cssSelector("#wmsInboundSource");
    By sourceItemsFound = By.cssSelector("#wmsInboundSource .i-summary-area__main__label");
    By sourceItemsNumber = By.cssSelector("#wmsInboundSource .i-summary-area__main__value");
    By sourceShipperColumn = By.xpath("//div[contains(@class, 'bottomGrid')]//td[contains(text(), 'Shipper')]");
    By sourceShippedStatus = By.xpath("//span[contains(@class, 'i-bar-description')][.//span[text()='Shipped']]");
    By sourceUnallocatedStatus = By.xpath("//span[contains(@class, 'i-bar-description')][.//span[text()='Unallocated']]");
    By sourceAllocatedStatus = By.xpath("//span[contains(@class, 'i-bar-description')][.//span[text()='Allocated']]");
    By routeBackButton = By.cssSelector("#RouteBackButton");
    By sourceShippedColor = By
            .xpath("//span[contains(@class, 'i-bar-description')][.//span[text()='Shipped']]//span[contains(@class, 'description__dot')]");
    By sourceUnallocatedColor = By
            .xpath("//span[contains(@class, 'i-bar-description')][.//span[text()='Unallocated']]//span[contains(@class, 'description__dot')]");
    By sourceAllocatedColor = By
            .xpath("//span[contains(@class, 'i-bar-description')][.//span[text()='Allocated']]//span[contains(@class, 'description__dot')]");
    By reviewRoute = By.xpath("//div[@class='inboundAppPageNew']//label[contains(text(), 'Review')]");
    By reviewRouteTableContent = By.xpath("//div[@class='inboundAppPageNew']//table[@class='k-grid-table']");
    By orderedLabel = By.xpath("//label[contains(text(), 'Ordered:')]");
    By pickedLabel = By.xpath("//label[contains(text(), 'Picked:')]");
    By shippedLabel = By.xpath("//label[contains(text(), 'Shipped:')]");
    By dropdownList = By.id("dropdownList");
    By arrowChevron = By.xpath("//button[contains(@class, 'i-card__card__title-area')]//span[contains(@class, 'k-i-arrow-chevron')]");
    By routeLabel = By.xpath("//span[text()='Route']");
    By enterNameInput = By.xpath("//input[contains(@placeholder, 'Enter NAME')]");
    By loader = By.cssSelector(".loader");
    private static String randomRouteCode = null;

    public void waitOutboundRouteSummaryPageToLoad() {
        waitUntilInvisible(4, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTitle());
        Waiters.waitForElementToBeDisplay(getTableContent());
        waitUntilInvisible(2, loader);
    }

    public static synchronized void setRandomRouteCode(String randomRouteCode) { randomRouteCode = randomRouteCode; }

    public static synchronized String getRandomRouteCode() { return randomRouteCode; }

    private By getStatusDropDown(String status) {
        return By.xpath("//span[contains(text(),'" + status + "')]");
    }

    private By getDoorDropDown(String door) { return By.xpath("//span[contains(text(),'" + door + "')]"); }

    private By getTemperatureTypeDropDown(String temperatureType) {
        return By.xpath("//span[contains(@role,'listbox')][.//span[@class='k-input' and text()='" + temperatureType + "']]");
    }

    private List<WebElement> getOrderTypeRowsByName(String orderType) {
        return findWebElements(By.xpath("//td[contains(text(), '" + orderType + "')]"));
    }

    public String getOutboundRouteSummaryPageTitle() {
        Waiters.waitForElementToBeDisplay(getTitle());
        return getTitle().getText().trim();
    }

    public String getGridTableRowContent(int row) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTableContent());
        return getText(getTableContent().findElements(By.xpath(".//tr")).get(row));
    }

    public WebElement getGridTableRow(int row) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTableContent());
        return getTableContent().findElements(By.xpath(".//tr")).get(row);
    }

    public void selectRandomUserFromDropdown() {
        Waiters.waitForPresenceOfAllElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        List<WebElement> users = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        clickOnElement(users.get(new Random().nextInt(users.size())));
    }

    public void typeRouteStartDate(String date) {
        Waiters.waitABit(4000);
        if(findWebElement(arrowChevron).getAttribute("class").contains("down")) {
            clickOnElement(arrowChevron);
        }
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getRouteStart());
        clickOnElement(getRouteStart());
        Waiters.waitABit(2000);
        pressDelete(getRouteStart());
        Waiters.waitABit(2000);
        inputText(getRouteStart(), date);
        Waiters.waitABit(2000);
        pressEnter(getRouteStart());
        Waiters.waitABit(8000);
    }

    public void typeRouteEndDate(String date) {
        Waiters.waitABit(4000);
        if(findWebElement(arrowChevron).getAttribute("class").contains("down")) {
            clickOnElement(arrowChevron);
        }
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilStalenessOf(1, getRouteEnd());
        clickOnElement(getRouteEnd());
        Waiters.waitABit(1000);
        clearText(getRouteEnd());
        Waiters.waitABit(2000);
        inputText(getRouteEnd(), date);
        Waiters.waitABit(1000);
        pressTab(getRouteEnd());
        Waiters.waitABit(7000);
    }

    public String getRouteStartCurrentValue() {
        Waiters.waitForAllElementsToBeDisplay(getRouteStart(), getRouteEnd());
        return getValue(findWebElement(By.id("dateRouteStart")));
    }

    public String getRouteStartFutureValue() {
        Waiters.waitForAllElementsToBeDisplay(getRouteStart(), getRouteEnd());
        return getValue(findWebElement(By.id("dateRouteEnd")));
    }

    public String getRouteValue() {
        Waiters.waitTillLoadingPage(getDriver());
        return getValue(getEnterRoute()).trim();
    }

    public String getAccountValue() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterAccount());
        return getValue(getEnterAccount()).trim();
    }

    public String getStatusText(String status) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getStatusDropDown(status));
        return getText(getStatusesDropDown(status)).trim();
    }

    public String getDoorText() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDoorList());
        return getText(getDoorList()).trim();
    }

    public List<WebElement> getDoors() {
        Waiters.waitForElementsToBeDisplay(findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']")));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public List<WebElement> getRoutes() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTableContent());
        return getTableContent().findElements(By.xpath(".//span[contains(@id, 'spnRouteCode')]"));
    }

    public void typeRoute(String route) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(2000);
        inputText(getEnterRoute(), route);
        Waiters.waitABit(2000);
        pressEnter(getEnterRoute());
        waitUntilInvisible(2, loader);
    }

    public void typeMaxStops(String maxStops) {
        Waiters.waitForElementToBeDisplay(getMaxStopsInput());
        enterText(getMaxStopsInput(), maxStops);
    }

    public void typeTemperature(String temperature) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTemperatureInput());
        doubleClick(getTemperatureInput());
        Waiters.waitABit(2000);
        pressDelete(getTemperatureInput());
        Waiters.waitABit(2000);
        enterText(getTemperatureInput(), temperature);
        pressTab(getTemperatureInput());
    }

    public String getMaxStopsValue() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getMaxStopsInput());
        return getValue(getMaxStopsInput());
    }

    public String getTemperatureValue() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTemperatureInput());
        return getValue(getTemperatureInput());
    }

    public void typeProduct(String product) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterProduct());
        enterText(getEnterProduct(), product);
        pressEnter(getEnterProduct());
        waitUntilInvisible(1, loader);
    }

    public void typeAccount(String account) {
        Waiters.waitForElementToBeDisplay(getEnterAccount());
        enterText(getEnterAccount(), account);
        pressEnter(getEnterAccount());
        waitUntilInvisible(1, loader);
    }

    public void deleteRoute() {
        Waiters.waitForElementToBeDisplay(getEnterRoute());
        clear(getEnterRoute());
        pressEnter(getEnterRoute());
    }

    public void deleteAccount() {
        Waiters.waitForElementToBeDisplay(getEnterAccount());
        doubleClick(getEnterAccount());
        pressDelete(getEnterAccount());
        pressEnter(getEnterAccount());
        waitUntilInvisible(1, loader);
    }

    public void deleteProduct() {
        Waiters.waitForElementToBeDisplay(getEnterProduct());
        doubleClick(getEnterProduct());
        pressDelete(getEnterProduct());
        pressEnter(getEnterProduct());
        waitUntilInvisible(1, loader);
    }

    public void clickDoorDropdown() {
        Waiters.waitForElementToBeDisplay(getDoorList());
        clickOnElement(getDoorList());
    }

    public void clickSearchAccount() {
        Waiters.waitForElementToBeDisplay(getSearchAccountButton());
        clickOnElement(getSearchAccountButton());
    }

    public void clickTrailerDropdown() {
        Waiters.waitForElementToBeDisplay(getTrailerInput());
        clickOnElement(getTrailerInput());
    }

    public void clickSearchProduct() {
        Waiters.waitForElementToBeDisplay(getSearchProductButton());
        clickOnElement(getSearchProductButton());
    }

    public void clickChangeStatus() {
        Waiters.waitForElementToBeDisplay(getChangeStatus());
        clickOnElement(getChangeStatus());
    }

    public void clickWorkItem() {
        Waiters.waitForElementToBeDisplay(getWorkItem());
        clickOnElement(getWorkItem());
    }

    public void clickAssignItem() {
        Waiters.waitForElementToBeDisplay(getAssignItem());
        clickOnElement(getAssignItem());
    }

    public void clickAssignments() {
        Waiters.waitForElementToBeDisplay(getAssignmentTab());
        clickOnElement(getAssignmentTab());
        waitUntilInvisible(1, loader);
    }

    public void clickTasks() {
        Waiters.waitForElementToBeDisplay(getTasksTab());
        clickOnElement(getTasksTab());
        Waiters.waitABit(2000);
    }

    public void clickUserDropdown() {
        Waiters.waitForElementToBeDisplay(getUserDropdown());
        Waiters.waitABit(5000);
        clickOnElement(getUserDropdown());
        waitUntilInvisible(2, loader);
    }

    public void clickRoutesDropdown() {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeDisplay(getRouteOptions());
        Waiters.waitABit(4000);
        clickOnElement(getRouteOptions());
        waitUntilInvisible(1, loader);
    }

    public void clickCarrierDropdown() {
        Waiters.waitForElementToBeDisplay(getCarrierInput());
        Waiters.waitABit(5000);
        clickOnElement(getCarrierInput());
        waitUntilInvisible(2, loader);
    }

    public void clickAssignmentTypeFilter() {
        Waiters.waitForElementToBeDisplay(getAssignmentTypeDropdown());
        clickOnElement(getAssignmentTypeDropdown());
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        waitUntilInvisible(1, loader);
    }

    public List<WebElement> getAssignmentTypes() {
        Waiters.waitForElementsToBeDisplay(findWebElements(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class,'i-btn-checkbox')]")));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class,'i-btn-checkbox')]"));
    }

    public List<WebElement> getUsers() {
        Waiters.waitForElementToBeDisplay(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public List<WebElement> getDoorOptions() {
        Waiters.waitForElementToBeDisplay(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public void clickTaskGroupFilter() {
        Waiters.waitForElementToBeDisplay(getTaskGroupDropdown());
        clickOnElement(getTaskGroupDropdown());
    }

    public List<WebElement> getTaskGroupItems() {
        Waiters.waitForElementsToBeDisplay(findWebElements(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class,'i-btn-checkbox')]")));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class,'i-btn-checkbox')]"));
    }

    public List<WebElement> getRouteDropdownOptions() {
        Waiters.waitForElementsToBeDisplay(findWebElements(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='menuItem']")));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='menuItem']"));
    }

    public void clickTypesFilter() {
        Waiters.waitForElementToBeDisplay(getTypesDropdown());
        clickOnElement(getTypesDropdown());
    }

    public List<WebElement> getTypesItems() {
        Waiters.waitForElementsToBeDisplay(findWebElements(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class,'i-btn-checkbox')]")));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class,'i-btn-checkbox')]"));
    }

    public void clickStatusesFilter() {
        Waiters.waitForElementToBeDisplay(getStatusesDropdown());
        clickOnElement(getStatusesDropdown());
    }

    public List<WebElement> getStatusesTabItems() {
        Waiters.waitForElementsToBeDisplay(findWebElements(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class,'i-btn-checkbox')]")));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class,'i-btn-checkbox')]"));
    }

    public void clickTaskItem() {
        Waiters.waitForElementToBeDisplay(getTasksTab());
        clickOnElement(getTasksTab());
        waitUntilInvisible(1, loader);
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeDisplay(getCancelButton());
        clickOnElement(getCancelButton());
        waitUntilInvisible(1, loader);
    }

    public String getWindowContentText() {
        Waiters.waitForElementToBeDisplay(getWindowContent());
        return getText(getWindowContent());
    }

    public String getTasksItemsCountNumberValue() {
        Waiters.waitForElementToBeDisplay(getTasksItemsCountNumber());
        return getText(getTasksItemsCountNumber());
    }

    public String getAssignmentItemsCountNumberValue() {
        Waiters.waitForElementToBeDisplay(getAssignmentItemsCountNumber());
        return getText(getAssignmentItemsCountNumber());
    }

    public String getItemsCountNumberValue() {
        Waiters.waitForElementToBeDisplay(getItemsCountNumber());
        return getText(getItemsCountNumber());
    }

    public boolean isItemsCountDisplayed() {
        Waiters.waitForElementToBeDisplay(getItems());
        return getItems().isDisplayed();
    }

    public String getEditTaskQtyValue() {
        Waiters.waitForElementToBeDisplay(getEditTaskQty());
        return getValue(getEditTaskQty());
    }

    public void typeEditTaskQtyValue(String value) {
        Waiters.waitForElementToBeDisplay(getEditTaskQty());
        doubleClick(getEditTaskQty());
        pressDelete(getEditTaskQty());
        inputText(getEditTaskQty(), value);
        pressEnter(getEditTaskQty());
    }

    public String getRouteCodeInputValue() {
        Waiters.waitForElementToBeDisplay(getRouteCodeInput());
        return getValue(getRouteCodeInput());
    }

    public String getDriverInputValue() {
        Waiters.waitTillLoadingPage(getDriver());
        return getValue(getDriverInput());
    }

    public String getRouteTypeText() {
        Waiters.waitForElementToBeDisplay(getRouteTypeInput());
        return getText(getRouteTypeInput());
    }

    public String getUserDropdownText() {
        Waiters.waitForElementToBeDisplay(getUserDropdown());
        return getText(getUserDropdown());
    }

    public void typeRouteCode(String code) {
        Waiters.waitForElementToBeDisplay(getRouteCodeInput());
        doubleClick(getRouteCodeInput());
        pressDelete(getRouteCodeInput());
        typeText(getRouteCodeInput(), code);
    }

    public void searchAccount(String account) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAccountSearch());
        enterText(getAccountSearch(), account);
        pressEnter(getAccountSearch());
    }

    public void searchProduct(String product) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSearchIcon());
        inputText(getSearchIcon(), product);
        pressEnter(getSearchIcon());
    }

    public void clickOnProductFromGridByIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProductSearchIndex());
        clickOnElement(getProductSearchIndex().findElements(By.xpath(".//tr[contains(@class,'k-master-row')]")).get(index));
    }

    public void selectOption(String status) {
        waitUntilInvisible(1, loader);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "')]")));
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilInvisible(2, loader);
    }

    public void selectOutboundRouteCarrier(String carrier) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option' and contains(text(), '"
                + carrier + "')]")));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectOutboundRouteOption(String option) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + option + "') and @role='menuItem']")));
        waitUntilInvisible(1, loader);
    }

    public void selectTrailerOption(String option) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                        + option + "') and @role='option']")));
        waitUntilInvisible(1, loader);
    }

    public void selectOutboundRouteType(String routeType) {
        Waiters.waitForElementToBeDisplay(getRouteTypeInput());
        clickOnElement(getRouteTypeInput());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                        + routeType + "')]")));
        waitUntilInvisible(1, loader);
    }

    public void typeScheduledDate(String scheduledDate) {
        Waiters.waitForElementToBeDisplay(getScheduledDate());
        Waiters.waitABit(2000);
        clear(getScheduledDate());
        typeText(getScheduledDate(), scheduledDate);
        pressEnter(getScheduledDate());
        waitUntilInvisible(1, loader);
    }

    public void typeScheduledTime(String time) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getScheduledTimeInput());
        doubleClick(getScheduledTimeInput());
        pressLeftArrow(getScheduledTimeInput());
        Waiters.waitABit(2000);
        pressLeftArrow(getScheduledTimeInput());
        Waiters.waitABit(2000);
        inputText(getScheduledTimeInput(), time.split(":")[0]);
        pressRightArrow(getScheduledTimeInput());
        Waiters.waitABit(4000);
        inputText(getScheduledTimeInput(), time.split(":")[1]);
        Waiters.waitABit(4000);
        pressLeftArrow(getScheduledTimeInput());
        Waiters.waitABit(4000);
        inputText(getScheduledTimeInput(), time.split(":")[1]);
        pressTab(getScheduledTimeInput());
    }

    public void typeDriver(String driver) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDriverInput());
        enterText(getDriverInput(), driver);
    }

    public void clickStatus(String status) {
        waitUntilInvisible(2, loader);
        Waiters.waitForElementToBeDisplay(getStatusesDropDown(status));
        clickOnElement(getStatusesDropDown(status));
    }

    public void clickDoor(String door) {
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                        + door + "') and @role='option']")));
        waitUntilInvisible(1, loader);
    }

    public void clickDoorDropdown(String door) {
        waitUntilInvisible(1, loader);
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDoorDropDown(door));
    }

    public void clickTemperatureTypeDropdown(String temperatureType) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getTemperatureTypeDropDown(temperatureType));
        waitUntilInvisible(1, loader);
    }

    public void selectTemperatureType(String temperatureType) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                        + temperatureType + "') and @role='option']")));
        waitUntilInvisible(1, loader);
    }

    public void clickOption(String door) {
        clickOnElement(getDoorList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(text(), '"
                        + door + "')]")));
        waitUntilInvisible(1, loader);
    }

    public void clickBack() {
        waitUntilInvisible(2, loader);
        clickOnElement(getBackButton());
        waitUntilInvisible(3, loader);
    }

    public void clickRouteBack() {
        Waiters.waitForElementToBeDisplay(getRouteBackButton());
        clickOnElement(getRouteBackButton());
        waitUntilInvisible(1, loader);
    }

    public void checkRouteByRowNumber(int index) {
        waitUntilInvisible(1, loader);
        Waiters.waitTillLoadingPage(getDriver());
        List<WebElement> routes = findWebElements(By.xpath("//div[contains(@class, 'BarsContainer')]//..//input"));
        WebElement webElement = routes.get(index);
        scrollToCenter(webElement);
        waitUntilStalenessOf(2, webElement);
        clickOnElement(webElement);
        waitUntilInvisible(1, loader);
    }

    public void selectRouteByRowNumber(int index) {
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> routes = findWebElements(By.xpath("//div[contains(@class, 'BarsContainer')]"));
        Waiters.waitABit(4000);
        waitUntilStalenessOf(2, routes.get(index));
        clickOnElement(routes.get(index));
        waitUntilInvisible(2, loader);
    }

    public WebElement getGridTableRowTime(int row) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTableContent());
        return getTableContent().findElements(By.xpath(".//tr[contains(@class,'k-detail-row')]//span[contains(@id, 'spnRouteTime')]"))
                .get(row);
    }

    public void clickAddFilter() {
        Waiters.waitForElementToBeClickable(getAddFilterButton());
        clickOnElement(getAddFilterButton());
        waitUntilInvisible(1, loader);
    }

    public void clickReplenishToCleanCheckBox() {
        Waiters.waitForElementToBeClickable(getReplenishToCleanCheckBox());
        clickOnElement(getReplenishToCleanCheckBox());
        waitUntilInvisible(1, loader);
    }

    public void clickOk() {
        Waiters.waitForElementToBeClickable(getOkButton());
        clickOnElement(getOkButton());
        waitUntilInvisible(1, loader);
    }

    public void clickAllAssignmentsCheckbox() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getAllAssignmentsCheckbox());
    }

    public void clickAllTasksCheckbox() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(4000);
        clickOnElement(getAllTasksCheckbox());
    }

    public void clickEditTask() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getEditTaskButton());
    }

    public void clickReprocessTask() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getReprocessTaskButton());
    }

    public void clickDeleteTask() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDeleteTaskButton());
    }

    public void clickTopOffTask() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getTopOffTaskButton());
    }

    public void clickMoveToNewAssignmentRadioButton() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getMoveToNewAssignmentRadioButton());
    }

    public void clickMoveToExistingAssignmentRadioButton() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getMoveToExistingAssignmentRadioButton());
    }

    public void clickMoveTask() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getMoveTaskButton());
    }

    public void clickMoveAssignment() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getMoveAssignmentButton());
    }

    public void clickDoorDropDown(String door) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getSelectDoorDropDown(door));
    }

    public void selectRouteAssignmentByNumber(int num) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAssignmentsGridTable());
        clickOnElement(getAssignmentsGridTable().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]")).get(num));
    }

    public void clickTopOffModalZoneDropdown() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getTopOffModalZoneDropDown());
    }

    public void selectTopOffModalZoneDropdown(String option) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getTopOffModalZoneDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                        + option + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickSave() {
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilStalenessOf(2, getLoader());
        clickOnElement(getSaveButton());
        waitUntilInvisible(2, loader);
    }

    public void clickOrderTypeColumn(String orderType, int index) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getOrderTypeRowsByName(orderType).get(index));
    }

    public void checkTasksCheckboxByIndex(int index) {
        Waiters.waitTillLoadingPage(getDriver());
        List<WebElement> checkboxes = getTasksGridTable().findElements(By.xpath(".//input"));
        clickOnElement(checkboxes.get(index));
    }

    public String getWindowTitleText() {
        Waiters.waitForElementToBeDisplay(getWindowPopup());
        return getText(getWindowPopup());
    }

    public String getDataRouteCardPageTitleText() {
        Waiters.waitForElementToBeDisplay(getDataRouteCardPageTitle());
        return getText(getDataRouteCardPageTitle());
    }

    public String getRoutesContentTextByIndex(int index) {
        Waiters.waitForElementToBeDisplay(getRoutesContent());
        List<WebElement> routes = getRoutesContent().findElements(By.xpath(".//tr[@class='k-detail-row']"));
        return getText(routes.get(index));
    }

    public String getPriorityInputDefaultText() {
        Waiters.waitForElementToBeDisplay(getEditTaskPriorities());
        return getText(getEditTaskPriorities());
    }

    public String getCarrierInputText() {
        Waiters.waitForElementToBeDisplay(getCarrierInput());
        return getText(getCarrierInput());
    }

    public String getEditTaskPalletsText() {
        Waiters.waitForElementToBeDisplay(getEditTaskPallets());
        return getText(getEditTaskPallets());
    }

    public String getScheduledDateValue() {
        Waiters.waitTillLoadingPage(getDriver());
        return getValue(getScheduledDate());
    }

    public String getScheduledTimeValue() {
        Waiters.waitTillLoadingPage(getDriver());
        return getValue(getScheduledTimeInput());
    }

    public String getNotificationText() {
        Waiters.waitForElementToBeDisplay(getTaskNotification());
        return getText(getTaskNotification());
    }

    public String getTrailerDropdownValue() {
        Waiters.waitForElementToBeDisplay(getTrailerInput());
        return getValue(getTrailerInput());
    }

    public boolean isReleaseCheckboxDisplayed() {
        Waiters.waitForElementToBeDisplay(getReleaseCheckbox());
        return isElementDisplay(getReleaseCheckbox());
    }

    public boolean isMaxStopsLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getMaxStopsLabel());
        return isElementDisplay(getMaxStopsLabel());
    }

    public boolean isMaxStopsInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getMaxStopsInput());
        return isElementDisplay(getMaxStopsInput());
    }

    public boolean isChangeStatusDisabled() { return getElementAttribute(getChangeStatus(), "class")
            .contains("disabled"); }

    public boolean isWorkItemDisabled() { return getElementAttribute(getWorkItem(), "class")
            .contains("disabled"); }

    public boolean isAssignItemDisabled() { return getElementAttribute(getAssignItem(), "class")
            .contains("disabled"); }

    public boolean isAssignmentTabActive() { return getElementAttribute(getAssignmentTab(), "class")
            .contains("active"); }

    public boolean isAccountSearchDisplayed() { return isElementDisplay(getAccountSearch()); }

    public boolean isAssignmentTypeTabDisplayed() { return isElementDisplay(getAssignmentTab()); }

    public boolean isRouteOptionsDisplayed() { return isElementDisplay(getRouteOptions()); }

    public boolean isStatusDropDownDisplayed(String status) { return isElementDisplay(getStatusesDropDown(status)); }

    public boolean isDoorDropDownDisplayed(String door) { return isElementDisplay(getDoorDropDown(door)); }

    public boolean isTemperatureTypeDropDownDisplayed(String tempType) { return isElementDisplay(getTemperatureTypeDropDown(tempType)); }

    public boolean isRoutesColumnDisplayed() { return isElementDisplay(getRoutesColumn()); }

    public boolean isOrdersColumnDisplayed() { return isElementDisplay(getOrdersColumn()); }

    public boolean isQuantityColumnDisplayed() { return isElementDisplay(getQuantityColumn()); }

    public boolean isLinesColumnDisplayed() { return isElementDisplay(getLinesColumn()); }

    public boolean isPalletsColumnDisplayed() { return isElementDisplay(getPalletsColumn()); }

    public boolean isCubeColumnDisplayed() { return isElementDisplay(getCubeColumn()); }

    public boolean isWeightColumnDisplayed() { return isElementDisplay(getWeightColumn()); }

    public boolean isAmountColumnDisplayed() { return isElementDisplay(getAmountColumn()); }

    public boolean isTableContentDisplayed() { return isElementDisplay(getTableContent()); }

    public boolean isShippedStatusDisplayed() { return isElementDisplay(getShippedStatus()); }

    public boolean isAuditStatusDisplayed() { return isElementDisplay(getAuditStatus()); }

    public boolean isPickedStatusDisplayed() { return isElementDisplay(getPickedStatus()); }

    public boolean isUnallocatedStatusDisplayed() { return isElementDisplay(getUnallocatedStatus()); }

    public boolean isShortsStatusDisplayed() { return isElementDisplay(getShortsStatus()); }

    public boolean isWaitingInboundDisplayed() { return isElementDisplay(getWaitingInboundStatus()); }

    public boolean isRemainderStatusDisplayed() { return isElementDisplay(getRemainderStatus()); }

    public boolean isAssignmentTabDisplayed() { return isElementDisplay(getAssignmentTab()); }

    public boolean isTasksTabDisabled() { return isElementDisplay(getTasksTab()); }

    public boolean isTypesDropdownDisplayed() { return isElementDisplay(getTypesDropdown()); }

    public boolean isTaskGroupDropdownDisplayed() { return isElementDisplay(getTaskGroupDropdown()); }

    public boolean isAssignmentTypesDropdownDisplayed() { return isElementDisplay(getAssignmentTypeDropdown()); }

    public boolean isStatusesDropdownDisplayed() { return isElementDisplay(getStatusesDropdown()); }

    public boolean isTopOffTaskButtonDisplayed() { return isElementDisplay(getTopOffTaskButton()); }

    public boolean isEditAssignmentDisplayed() { return isElementDisplay(getEditAssignmentButton()); }

    public boolean isDeleteAssignmentDisplayed() { return isElementDisplay(getDeleteAssignmentButton()); }

    public boolean isReleaseAssignmentDisplayed() { return isElementDisplay(getReleaseAssignmentButton()); }

    public boolean isPrintAssignmentDisplayed() { return isElementDisplay(getPrintAssignmentButton()); }

    public boolean isMoveTaskDisplayed() { return isElementDisplay(getMoveTaskButton()); }

    public boolean isSaveButtonDisplayed() { return isElementDisplay(getSaveButton()); }

    public boolean isCancelButtonDisplayed() { return isElementDisplay(getCancelButton()); }

    public boolean isAssignmentCodeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getAssignmentCodeFilter());
        return isElementDisplay(getAssignmentCodeFilter());
    }

    public boolean isAddFilterButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getAddFilterButton());
        return isElementDisplay(getAddFilterButton());
    }

    public boolean isRouteFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getRouteFilter());
        return isElementDisplay(getRouteFilter());
    }

    public boolean isStopsFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getStopsFilter());
        return isElementDisplay(getStopsFilter());
    }

    public boolean isShipperFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getShipperFilter());
        return isElementDisplay(getShipperFilter());
    }

    public boolean isShipToFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getShipToFilter());
        return isElementDisplay(getShipToFilter());
    }

    public boolean isTasksFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getTasksFilter());
        return isElementDisplay(getTasksFilter());
    }

    public boolean isAssignToFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getAssignToFilter());
        return isElementDisplay(getAssignToFilter());
    }

    public boolean isReleasedFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getReleasedFilter());
        return isElementDisplay(getReleasedFilter());
    }

    public boolean isQtyFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getQtyFilter());
        return isElementDisplay(getQtyFilter());
    }

    public boolean isCubeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getCubeFilter());
        return isElementDisplay(getCubeFilter());
    }

    public boolean isWeightFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getWeightFilter());
        return isElementDisplay(getWeightFilter());
    }

    public boolean isAssignmentTypeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getAssignmentTypeFilter());
        return isElementDisplay(getAssignmentTypeFilter());
    }

    public boolean isTaskGroupFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getTaskGroupFilter());
        return isElementDisplay(getTaskGroupFilter());
    }

    public boolean isPercentPickedFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getPercentPickedFilter());
        return isElementDisplay(getPercentPickedFilter());
    }

    public boolean isInUseByFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getInUseByFilter());
        return isElementDisplay(getInUseByFilter());
    }

    public boolean isStatusFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getStatusFilter());
        return isElementDisplay(getStatusFilter());
    }

    public boolean isEstimatedTimeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getEstimatedTimeFilter());
        return isElementDisplay(getEstimatedTimeFilter());
    }

    public boolean isStandardTimeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getStandardTimeFilter());
        return isElementDisplay(getStandardTimeFilter());
    }

    public boolean isActualTimeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getActualTimeFilter());
        return isElementDisplay(getActualTimeFilter());
    }

    public boolean isActivityIndicatorFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getActivityIndicatorFilter());
        return isElementDisplay(getActivityIndicatorFilter());
    }

    public boolean isRemainingFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getRemainingFilter());
        return isElementDisplay(getRemainingFilter());
    }

    public boolean isPrintedFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getPrintedFilter());
        return isElementDisplay(getPrintedFilter());
    }

    public boolean isDataAlt1Displayed() {
        Waiters.waitForElementToBeDisplay(getDataAlt1());
        return isElementDisplay(getDataAlt1());
    }

    public boolean isDataAlt2Displayed() {
        Waiters.waitForElementToBeDisplay(getDataAlt2());
        return isElementDisplay(getDataAlt2());
    }

    public boolean isDataAlt3Displayed() {
        Waiters.waitForElementToBeDisplay(getDataAlt3());
        return isElementDisplay(getDataAlt3());
    }

    public boolean isRouteLabelDisplayed() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getRouteLabel());
        return isElementDisplay(getRouteLabel());
    }

    public boolean isEnterNameInputDisplayed() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getEnterNameInput());
        return isElementDisplay(getEnterNameInput());
    }

    public boolean isSourceListDisplayed() {
        Waiters.waitForElementToBeDisplay(getSourceList());
        return isElementDisplay(getSourceList());
    }

    public boolean isSourceBlockDisplayed() {
        Waiters.waitForElementToBeDisplay(getSourceBlock());
        return isElementDisplay(getSourceBlock());
    }

    public boolean areTaskTableHeadersPresent() {
        return elementsArePresent(getTaskTableHeaders()) > 0;
    }

    public boolean areAssignmentsHeadersPresent() {
        return elementsArePresent(getAssignmentsTableHeaders()) > 0;
    }

    public boolean isTasksItemsCountNumberDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTasksItemsCountNumber());
    }

    public boolean isTasksItemsDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTasksItems());
    }

    public boolean isAssignmentItemsCountNumberDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAssignmentItemsCountNumber());
    }

    public boolean isAssignmentItemsDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAssignmentItems());
    }

    public boolean isAssignmentSelectedItemsCountNumberDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAssignmentSelectedItemsCountNumber());
    }

    public boolean isAssignmentSelectedItemsFoundDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAssignmentSelectedItemsFound());
    }

    public boolean isTasksSelectedItemsCountNumberDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTasksSelectedItemsCountNumber());
    }

    public boolean isTasksSelectedItemsFoundDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTasksSelectedItemsFound());
    }

    public boolean isTrailerLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTrailerLabel());
    }

    public boolean isTrailerInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTrailerInput());
    }

    public String getTrailerInputValue() {
        Waiters.waitABit(2000);
        return getText(getTrailerInput());
    }

    public boolean isTemperatureLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTemperatureLabel());
    }

    public boolean isTemperatureInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTemperatureInput());
    }

    public boolean isRouteTitleDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteTitle());
    }

    public boolean isEditTaskQtyLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskQtyLabel());
    }

    public boolean isEditTaskQtyDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskQty());
    }

    public boolean isEditTaskReasonLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskReasonLabel());
    }

    public boolean isEditTaskReasonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskReason());
    }

    public boolean isEditTaskFromLocationLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskFromLocationLabel());
    }

    public boolean isEditTaskFromLocationDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskFromLocation());
    }

    public boolean isEditTaskPrioritiesLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskPrioritiesLabel());
    }

    public boolean isEditTaskPrioritiesDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskPriorities());
    }

    public boolean isEditTaskGroupLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskGroupLabel());
    }

    public boolean isEditTaskGroupDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskGroup());
    }

    public boolean isEditTaskPalletsLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskPalletsLabel());
    }

    public boolean isEditTaskPalletsDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskPallets());
    }

    public boolean isProductFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getProductFilter());
    }

    public boolean isQuantityFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getQuantityFilter());
    }

    public boolean isFromFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getFromFilter());
    }

    public boolean isToFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getToFilter());
    }

    public boolean isTypeFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTypeFilter());
    }

    public boolean isAssignmentNumberFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAssignmentNumberFilter());
    }

    public boolean isPriorityFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getPriorityFilter());
    }

    public boolean isStopFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getStopFilter());
    }

    public boolean isVelocityFilterDisplayed() {
        Waiters.waitABit(5000);
        return isElementDisplay(getVelocityFilter());
    }

    public boolean isDescriptionFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDescriptionFilter());
    }

    public boolean isTaskNotificationDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTaskNotification());
    }

    public boolean isTopOffModalZoneDropDownDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTopOffModalZoneDropDown());
    }

    public boolean isRouteCodeLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteCodeLabel());
    }

    public boolean isRouteCodeInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteCodeInput());
    }

    public boolean isScheduledDateLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteCodeInput());
    }

    public boolean isScheduledDateDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getScheduledDate());
    }

    public boolean isCarrierLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCarrierLabel());
    }

    public boolean isCarrierInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCarrierInput());
    }

    public boolean isRouteTypeLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteTypeLabel());
    }

    public boolean isRouteTypeInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteTypeInput());
    }

    public boolean isScheduledTimeLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getScheduledTimeLabel());
    }

    public boolean isScheduledTimeInputDisplayed() {
        Waiters.waitABit(3000);
        return isElementDisplay(getScheduledTimeInput());
    }

    public boolean isDriverLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDriverLabel());
    }

    public boolean isDriverInputDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDriverInput());
    }

    public boolean isSourceOrderTypeColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSourceOrderTypeColumn());
    }

    public boolean isSourceOrderColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSourceOrderColumn());
    }

    public boolean isSourceStatusColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSourceStatusColumn());
    }

    public boolean isSourceShipperColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSourceShipperColumn());
    }

    public boolean isSourceShippedStatusDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSourceShippedStatus());
    }

    public boolean isSourceUnallocatedStatusDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSourceUnallocatedStatus());
    }

    public boolean isSourceAllocatedStatusDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSourceAllocatedStatus());
    }

    public boolean isSourceItemsFoundDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSourceItemsFound());
    }

    public boolean isSourceItemsNumberDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSourceItemsNumber());
    }

    public boolean isRouteBackButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteBackButton());
    }

    public boolean isReviewRouteTitleDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getReviewRoute());
    }

    public boolean isReviewRouteTableContentDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getReviewRouteTableContent());
    }

    public boolean isOrderedLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getOrderedLabel());
    }

    public boolean isPickedLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getPickedLabel());
    }

    public boolean isShippedLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getShippedLabel());
    }

    public boolean isProductColumnDisplayed() {
        scrollToCenter(getProductColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getProductColumn());
    }

    public boolean isQtyColumnDisplayed() {
        scrollToCenter(getProductColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getQtyColumn());
    }

    public boolean isFromColumnDisplayed() {
        scrollToCenter(getFromColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getFromColumn());
    }

    public boolean isToColumnDisplayed() {
        scrollToCenter(getToColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getToColumn());
    }

    public boolean isTypeColumnDisplayed() {
        scrollToCenter(getTypeColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getTypeColumn());
    }

    public boolean isTaskGroupColumnDisplayed() {
        scrollToCenter(getTaskGroupColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getTaskGroupColumn());
    }

    public boolean isStatusColumnDisplayed() {
        scrollToCenter(getStatusColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getStatusColumn());
    }

    public boolean isAssignmentNumColumnDisplayed() {
        scrollToCenter(getAssignmentNumColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getAssignmentNumColumn());
    }

    public boolean isInUseByColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getInUseByColumn());
    }

    public boolean isPriorityColumnDisplayed() {
        scrollToCenter(getPriorityColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getPriorityColumn());
    }

    public boolean isRouteColumnDisplayed() {
        scrollToCenter(getRouteColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteColumn());
    }

    public boolean isStopColumnDisplayed() {
        scrollToCenter(getStopColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getStopColumn());
    }

    public boolean isShipperColumnDisplayed() {
        scrollToCenter(getShipperColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getShipperColumn());
    }

    public boolean isVelocityColumnDisplayed() {
        scrollToCenter(getVelocityColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getVelocityColumn());
    }

    public boolean isDescriptionColumnDisplayed() {
        scrollToCenter(getDescriptionColumn());
        Waiters.waitABit(2000);
        return isElementDisplay(getDescriptionColumn());
    }

    public boolean isMoveToAssignmentLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getMoveToAssignmentLabel());
    }

    public boolean isMoveToNewAssignmentRadioButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getMoveToNewAssignmentRadioButton());
    }

    public boolean isMoveToExistingAssignmentRadioButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getMoveToExistingAssignmentRadioButton());
    }

    public boolean isMoveToNewShipperRadioButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getMoveToNewShipperRadioButton());
    }

    public String isMoveToNewShipperRadioButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getMoveToNewShipperRadioButton(), "disabled");
    }

    public boolean isMoveToExistingShipperRadioButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getToExistingShipperRadioButton());
    }

    public String isMoveToExistingShipperRadioButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getToExistingShipperRadioButton(), "disabled");
    }

    public boolean isGetExistingAssignmentTxtBoxDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getExistingAssignmentTxtBox());
    }

    public boolean isEditAssignmentButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getEditAssignmentButton(),"class").contains("disabled");
    }

    public boolean isDeleteAssignmentButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getDeleteAssignmentButton(),"class").contains("disabled");
    }

    public boolean isReleaseAssignmentButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getReleaseAssignmentButton(),"class").contains("disabled");
    }

    public boolean isPrintAssignmentButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getPrintAssignmentButton(),"class").contains("disabled");
    }

    public boolean isMoveAssignmentButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getMoveTaskButton(),"class").contains("disabled");
    }

    public boolean isEditTasksButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getEditTaskButton(),"class").contains("disabled");
    }

    public boolean isDeleteTasksButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getDeleteTaskButton(),"class").contains("disabled");
    }

    public boolean isMoveTasksButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getMoveTaskButton(),"class").contains("disabled"); }

    public boolean isReprocessButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getReprocessTaskButton(),"class").contains("disabled");
    }

    public boolean isTopOffButtonDisabled() {
        Waiters.waitABit(2000);
        return getElementAttribute(getTopOffTaskButton(),"class").contains("disabled");
    }

    public boolean isSourceShippedColorCorrect() {
        Waiters.waitABit(2000);
        return getElementAttribute(getSourceShippedColor(),"class").contains("green");
    }

    public boolean isSourceUnallocatedColorCorrect() {
        Waiters.waitABit(2000);
        return getElementAttribute(getSourceUnallocatedColor(),"class").contains("orange");
    }

    public boolean isSourceAllocatedColorCorrect() {
        Waiters.waitABit(2000);
        return getElementAttribute(getSourceAllocatedColor(),"class").contains("yellow");
    }

    public WebElement getTitle() { return findWebElement(title); }

    public WebElement getRouteStart() { return findWebElement(routeStart); }

    public WebElement getRouteEnd() { return findWebElement(routeEnd); }

    public WebElement getEnterRoute() { return findWebElement(enterRoute); }

    public WebElement getEnterAccount() { return findWebElement(enterAccount); }

    public WebElement getSearchAccountButton() { return findWebElement(searchAccountButton); }

    public By getStatusesDropDown(String status) {  return getStatusDropDown(status); }

    public By getSelectDoorDropDown(String door) { return getDoorDropDown(door); }

    public By getSelectTemperatureTypeDropDown(String tempType) { return getTemperatureTypeDropDown(tempType); }

    public WebElement getEnterProduct() { return findWebElement(enterProduct); }

    public WebElement getSearchProductButton() { return findWebElement(searchProductButton); }

    public WebElement getRouteOptions() { return findWebElement(routeOptions); }

    public WebElement getShippedStatus() { return findWebElement(shippedStatus); }

    public WebElement getAuditStatus() { return findWebElement(auditStatus); }

    public WebElement getPickedStatus() { return findWebElement(pickedStatus); }

    public WebElement getUnallocatedStatus() { return findWebElement(unallocatedStatus); }

    public WebElement getShortsStatus() { return findWebElement(shortsStatus); }

    public WebElement getWaitingInboundStatus() { return findWebElement(waitingInboundStatus); }

    public WebElement getRemainderStatus() { return findWebElement(remainderStatus); }

    public WebElement getRoutesColumn() { return findWebElement(routesColumn); }

    public WebElement getOrdersColumn() { return findWebElement(ordersColumn); }

    public WebElement getQuantityColumn() { return findWebElement(quantityColumn); }

    public WebElement getLinesColumn() { return findWebElement(linesColumn); }

    public WebElement getPalletsColumn() { return findWebElement(palletsColumn); }

    public WebElement getCubeColumn() { return findWebElement(cubeColumn); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getAmountColumn() { return findWebElement(amountColumn); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public WebElement getItemsCount() { return findWebElement(itemsCount); }

    public WebElement getLoadingImage() { return findWebElement(loadingImage); }

    public WebElement getLoader() { return findWebElement(loader); }

    public WebElement getWindowPopup() { return findWebElement(windowPopup); }

    public WebElement getWindowContent() { return findWebElement(windowContent); }

    public WebElement getAccountSearch() { return findWebElement(accountSearch); }

    public WebElement getTasksItemsCountNumber() { return findWebElement(tasksItemsCountNumber); }

    public WebElement getTasksItems() { return findWebElement(tasksItemsFound); }

    public WebElement getAssignmentItemsCountNumber() { return findWebElement(assignmentItemsCountNumber); }

    public WebElement getAssignmentItems() { return findWebElement(assignmentItemsFound); }

    public WebElement getItemsCountNumber() { return findWebElement(itemsCountNumber); }

    public WebElement getItems() { return findWebElement(itemsFound); }

    public WebElement getCancelButton() { return findWebElement(cancelButton); }

    public WebElement getBackButton() { return findWebElement(backButton); }

    public WebElement getChangeStatus() { return findWebElement(changeStatus); }

    public WebElement getWorkItem() { return findWebElement(workItem); }

    public WebElement getAssignItem() { return findWebElement(assignItem); }

    public WebElement getSearchIcon() { return findWebElement(searchIcon); }

    public WebElement getProductSearchIndex() { return findWebElement(productSearchIndex); }

    public WebElement getAssignmentsGridTable() { return findWebElement(assignmentsTable); }

    public WebElement getAssignmentTab() { return findWebElement(assignmentTab); }

    public WebElement getTasksTab() { return findWebElement(tasksTab); }

    public WebElement getStatusesDropdown() { return findWebElement(statusesDropDown); }

    public WebElement getAssignmentTypeDropdown() { return findWebElement(assignmentTypeDropDown); }

    public WebElement getTypesDropdown() { return findWebElement(typesDropDown); }

    public WebElement getTaskGroupDropdown() { return findWebElement(taskGroupDropDown); }

    public WebElement getTopOffTaskButton() { return findWebElement(topOffTaskButton); }

    public WebElement getEditAssignmentButton() { return findWebElement(editAssignmentBtn); }

    public WebElement getDeleteAssignmentButton() { return findWebElement(deleteAssignmentBtn); }

    public WebElement getReleaseAssignmentButton() { return findWebElement(releaseAssignmentBtn); }

    public WebElement getPrintAssignmentButton() { return findWebElement(printAssignmentBtn); }

    public WebElement getMoveTaskButton() { return findWebElement(moveTaskBtn); }

    public WebElement getMoveAssignmentButton() { return findWebElement(moveAssignmentBtn); }

    public WebElement getEditTaskButton() { return findWebElement(editTaskBtn); }

    public WebElement getDeleteTaskButton() { return findWebElement(deleteTaskBtn); }

    public WebElement getReprocessTaskButton() { return findWebElement(reprocessTaskBtn); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getAssignmentCodeFilter() { return findWebElement(assignmentCodeFilter); }

    public WebElement getRouteFilter() { return findWebElement(routeFilter); }

    public WebElement getStopsFilter() { return findWebElement(stopsFilter); }

    public WebElement getShipperFilter() { return findWebElement(shipperFilter); }

    public WebElement getShipToFilter() { return findWebElement(shipToFilter); }

    public WebElement getTasksFilter() { return findWebElement(tasksFilter); }

    public WebElement getAssignToFilter() { return findWebElement(assignToFilter); }

    public WebElement getReleasedFilter() { return findWebElement(releasedFilter); }

    public WebElement getQtyFilter() { return findWebElement(qtyFilter); }

    public WebElement getCubeFilter() { return findWebElement(cubeFilter); }

    public WebElement getWeightFilter() { return findWebElement(weightFilter); }

    public WebElement getAssignmentTypeFilter() { return findWebElement(assignmentTypeFilter); }

    public WebElement getTaskGroupFilter() { return findWebElement(taskGroupFilter); }

    public WebElement getPercentPickedFilter() { return findWebElement(percentPickedFilter); }

    public WebElement getInUseByFilter() { return findWebElement(inUseByFilter); }

    public WebElement getStatusFilter() { return findWebElement(statusFilter); }

    public WebElement getEstimatedTimeFilter() { return findWebElement(estimatedTimeFilter); }

    public WebElement getStandardTimeFilter() { return findWebElement(standardTimeFilter); }

    public WebElement getActualTimeFilter() { return findWebElement(actualTimeFilter); }

    public WebElement getActivityIndicatorFilter() { return findWebElement(activityIndicatorFilter); }

    public WebElement getRemainingFilter() { return findWebElement(remainingFilter); }

    public WebElement getPrintedFilter() { return findWebElement(printedFilter); }

    public WebElement getProductFilter() { return findWebElement(productFilter); }

    public WebElement getQuantityFilter() { return findWebElement(quantityFilter); }

    public WebElement getFromFilter() { return findWebElement(fromFilter); }

    public WebElement getToFilter() { return findWebElement(toFilter); }

    public WebElement getTypeFilter() { return findWebElement(typeFilter); }

    public WebElement getAssignmentNumberFilter() { return findWebElement(assignmentNumberFilter); }

    public WebElement getPriorityFilter() { return findWebElement(priorityFilter); }

    public WebElement getStopFilter() { return findWebElement(stopFilter); }

    public WebElement getVelocityFilter() { return findWebElement(velocityFilter); }

    public WebElement getDescriptionFilter() { return findWebElement(descriptionFilter); }

    public List<WebElement> getTaskTableHeaders() { return findWebElements(taskTableHeaders); }

    public List<WebElement> getAssignmentsTableHeaders() { return findWebElements(assignmentsTableHeaders); }

    public WebElement getReleaseCheckbox() { return findWebElement(releaseCheckbox); }

    public WebElement getAllAssignmentsCheckbox() { return findWebElement(allAssignmentsCheckbox); }

    public WebElement getAllTasksCheckbox() { return findWebElement(allTasksCheckbox); }

    public WebElement getAssignmentSelectedItemsCountNumber() { return findWebElement(assignmentSelectedItemsCountNumber); }

    public WebElement getAssignmentSelectedItemsFound() { return findWebElement(assignmentSelectedItemsFound); }

    public WebElement getTasksSelectedItemsCountNumber() { return findWebElement(tasksSelectedItemsCountNumber); }

    public WebElement getTasksSelectedItemsFound() { return findWebElement(tasksSelectedItemsFound); }

    public WebElement getRouteTitle() { return findWebElement(routeTitle); }

    public WebElement getTasksGridTable() { return findWebElement(allTasksGridTable); }

    public WebElement getEditTaskQtyLabel() { return findWebElement(editTaskQtyLabel); }

    public WebElement getEditTaskQty() { return findWebElement(editTaskQty); }

    public WebElement getEditTaskReasonLabel() { return findWebElement(editTaskReasonLabel); }

    public WebElement getEditTaskReason() { return findWebElement(editTaskReason); }

    public WebElement getEditTaskFromLocationLabel() { return findWebElement(editTaskFromLocationLabel); }

    public WebElement getEditTaskFromLocation() { return findWebElement(editTaskFromLocation); }

    public WebElement getEditTaskPrioritiesLabel() { return findWebElement(editTaskPrioritiesLabel); }

    public WebElement getEditTaskPriorities() { return findWebElement(editTaskPriorities); }

    public WebElement getEditTaskGroupLabel() { return findWebElement(editTaskGroupLabel); }

    public WebElement getEditTaskGroup() { return findWebElement(editTaskGroup); }

    public WebElement getEditTaskPalletsLabel() { return findWebElement(editTaskPalletsLabel); }

    public WebElement getEditTaskPallets() { return findWebElement(editTaskPallets); }

    public WebElement getTaskNotification() { return findWebElement(taskNotification); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getOkButton() { return findWebElement(okButton); }

    public WebElement getReplenishToCleanCheckBox() { return findWebElement(replenishToCleanCheckBox); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getTopOffModalZoneDropDown() { return findWebElement(topOffModalZoneDropDown); }

    public WebElement getMoveToAssignmentLabel() { return findWebElement(moveToAssignmentLabel); }

    public WebElement getMoveToNewAssignmentRadioButton() { return findWebElement(moveToNewAssignmentRadioButton); }

    public WebElement getMoveToExistingAssignmentRadioButton() { return findWebElement(moveToExistingAssignmentRadioButton); }

    public WebElement getMoveToNewShipperRadioButton() { return findWebElement(moveToNewShipperRadioButton); }

    public WebElement getToExistingShipperRadioButton() { return findWebElement(moveToExistingShipperRadioButton); }

    public WebElement getExistingAssignmentTxtBox() { return findWebElement(existingAssignmentTxtBox); }

    public WebElement getUserDropdown() { return findWebElement(userDropdown); }

    public WebElement getRouteCodeLabel() { return findWebElement(routeCodeLabel); }

    public WebElement getRouteCodeInput() { return findWebElement(routeCodeInput); }

    public WebElement getScheduledDateLabel() { return findWebElement(scheduledDateLabel); }

    public WebElement getScheduledDate() { return findWebElement(scheduledDate); }

    public WebElement getCarrierLabel() { return findWebElement(carrierLabel); }

    public WebElement getCarrierInput() { return findWebElement(carrierInput); }

    public WebElement getRouteTypeLabel() { return findWebElement(routeTypeLabel); }

    public WebElement getRouteTypeInput() { return findWebElement(routeTypeInput); }

    public WebElement getTrailerLabel() { return findWebElement(trailerLabel); }

    public WebElement getTrailerInput() { return findWebElement(trailerInput); }

    public WebElement getScheduledTimeLabel() { return findWebElement(scheduledTimeLabel); }

    public WebElement getScheduledTimeInput() { return findWebElement(scheduledTimeInput); }

    public WebElement getDriverLabel() { return findWebElement(driverLabel); }

    public WebElement getDriverInput() { return findWebElement(driverInput); }

    public WebElement getRoutesContent() { return findWebElement(routesContent); }

    public WebElement getMaxStopsLabel() { return findWebElement(maxStopsLabel); }

    public WebElement getMaxStopsInput() { return findWebElement(maxStopsInput); }

    public WebElement getTemperatureLabel() { return findWebElement(temperatureLabel); }

    public WebElement getTemperatureInput() { return findWebElement(temperatureInput); }

    public WebElement getDoorList() { return findWebElement(doorList); }

    public WebElement getDataAlt1() { return findWebElement(dataAlt1); }

    public WebElement getDataAlt2() { return findWebElement(dataAlt2); }

    public WebElement getDataAlt3() { return findWebElement(dataAlt3); }

    public WebElement getDataRouteCardPageTitle() { return findWebElement(dataRouteCardPageTitle); }

    public WebElement getSourceOrderTypeColumn() { return findWebElement(sourceOrderTypeColumn); }

    public WebElement getSourceOrderColumn() { return findWebElement(sourceOrderColumn); }

    public WebElement getSourceStatusColumn() { return findWebElement(sourceStatusColumn); }

    public WebElement getSourceList() { return findWebElement(sourceList); }

    public WebElement getSourceBlock() { return findWebElement(sourceBlock); }

    public WebElement getSourceShippedStatus() { return findWebElement(sourceShippedStatus); }

    public WebElement getSourceUnallocatedStatus() { return findWebElement(sourceUnallocatedStatus); }

    public WebElement getSourceAllocatedStatus() { return findWebElement(sourceAllocatedStatus); }

    public WebElement getSourceShippedColor() { return findWebElement(sourceShippedColor); }

    public WebElement getSourceUnallocatedColor() { return findWebElement(sourceUnallocatedColor); }

    public WebElement getSourceAllocatedColor() { return findWebElement(sourceAllocatedColor); }

    public WebElement getSourceItemsFound() { return findWebElement(sourceItemsFound); }

    public WebElement getSourceItemsNumber() { return findWebElement(sourceItemsNumber); }

    public WebElement getRouteBackButton() { return findWebElement(routeBackButton); }

    public WebElement getReviewRoute() { return findWebElement(reviewRoute); }

    public WebElement getReviewRouteTableContent() { return findWebElement(reviewRouteTableContent); }

    public WebElement getOrderedLabel() { return findWebElement(orderedLabel); }

    public WebElement getPickedLabel() { return findWebElement(pickedLabel); }

    public WebElement getShippedLabel() { return findWebElement(shippedLabel); }

    public WebElement getProductColumn() { return findWebElement(productColumn); }

    public WebElement getQtyColumn() { return findWebElement(qtyColumn); }

    public WebElement getFromColumn() { return findWebElement(fromColumn); }

    public WebElement getToColumn() { return findWebElement(toColumn); }

    public WebElement getTypeColumn() { return findWebElement(typeColumn); }

    public WebElement getTaskGroupColumn() { return findWebElement(taskGroupColumn); }

    public WebElement getStatusColumn() { return findWebElement(statusColumn); }

    public WebElement getAssignmentNumColumn() { return findWebElement(assignmentNumColumn); }

    public WebElement getInUseByColumn() { return findWebElement(inUseByColumn); }

    public WebElement getPriorityColumn() { return findWebElement(priorityColumn); }

    public WebElement getRouteColumn() { return findWebElement(routeColumn); }

    public WebElement getStopColumn() { return findWebElement(stopColumn); }

    public WebElement getShipperColumn() { return findWebElement(shipperColumn); }

    public WebElement getVelocityColumn() { return findWebElement(velocityColumn); }

    public WebElement getDescriptionColumn() { return findWebElement(descriptionColumn); }

    public WebElement getSourceShipperColumn() { return findWebElement(sourceShipperColumn); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

    public WebElement getRouteLabel() { return findWebElement(routeLabel); }

    public WebElement getEnterNameInput() { return findWebElement(enterNameInput); }
}
