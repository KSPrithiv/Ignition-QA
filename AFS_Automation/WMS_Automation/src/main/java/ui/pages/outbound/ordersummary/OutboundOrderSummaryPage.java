package ui.pages.outbound.ordersummary;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class OutboundOrderSummaryPage extends BasePage {
    By title = By.cssSelector(".i-card__card__title-area__title");
    By loadingImage = By.cssSelector(".k-loading-image");
    By orderStart = By.id("dateOrderStart");
    By enterOrder = By.cssSelector("input[placeholder='Enter order']");
    By enterAccount = By.xpath("//input[@placeholder='Enter a account']");
    By clearAccount = By.cssSelector(".k-clear-value");
    By clearAccountIndex = By.cssSelector(".i-search-box__clear");
    By searchOrderButton = By
            .xpath("//div[@class='i-indexfield-container__main'][.//input[@placeholder='Enter a account']]//button");
    By allStatusesDropDown = By.cssSelector("#ddlStatus");
    By doorsDropDown = By.cssSelector("#ddlDoor");
    By doorsListDropDown = By.cssSelector("#ddDoorList");
    By orderTypeDropDown = By.cssSelector("#ddlOrderType");
    By enterProduct = By.cssSelector("input[placeholder='Enter a product']");
    By searchProductButton = By
            .xpath("//div[@class='i-indexfield-container__main'][.//input[@placeholder='Enter a product']]//button");
    By orderOptions = By.cssSelector("button[aria-label='Order options dropdownbutton']");
    By shippedStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--green')]]");
    By auditStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--purple')]]");
    By pickedStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--yellow')]]");
    By unallocatedStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--orange')]]");
    By shortsStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--red')]]");
    By waitingInboundStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--blue')]]");
    By remainderStatus = By.xpath("//span[contains(@class,'i-bar-description')][.//span[contains(@class, 'dot--gray')]]");
    By tableContent = By.xpath("//div[@class='k-grid-container']");
    By tableHeaders = By.cssSelector(".k-grid-header th");
    By detailRows = By.cssSelector(".k-grid-table .k-detail-row");
    By accountRows = By.cssSelector(".k-grid-table .k-master-row");
    By accountIndexRows = By.xpath("//div[@class='k-widget k-grid k-grid-virtual']//tr[contains(@class, 'k-master-row')]");
    By accountSearch = By.cssSelector("#gridUtilSearch_productSearchIndex");
    By orderAccount = By.xpath("//span[contains(text(), 'Test Account')]");
    By detailedRowsCheckboxes = By.cssSelector(".k-detail-cell input");
    By itemsCount = By.cssSelector(".i-summary-area__main__value");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By summaryInboundOrderDetails = By.cssSelector("#crdSummaryInboundOrderPortrait");
    By orderStatus = By.cssSelector("#span_Status");
    By backButton = By.xpath("//button[contains(text(), 'Back')]");
    By dialog = By.cssSelector(".k-dialog-title");
    By accountWindow = By.cssSelector(".k-window-title");
    By products = By.xpath("//div[@class='BarsBlock']//span[contains(@class, 'Title2 h15')]");
    By notification = By.cssSelector(".i-no-data__message");
    By statusIcon = By.cssSelector("#btnChangeStatus");
    By workIcon = By.cssSelector("#ddWorkItem");
    By taskIcon = By.xpath("//li[@role='tab'][.//span[contains(text(), 'Tasks')]]");
    By assignIcon = By.cssSelector("#ddAssignItem");
    By ordersColumn = By.xpath("//span[contains(text(), 'Orders')]");
    By quantityColumn = By.xpath("//span[contains(text(), 'Quantity')]");
    By linesColumn = By.xpath("//span[contains(text(), 'Lines')]");
    By palletsColumn = By.xpath("//span[contains(text(), 'Pallets')]");
    By cubeColumn = By.xpath("//span[contains(text(), 'Cube')]");
    By weightColumn = By.xpath("//span[contains(text(), 'Weight')]");
    By orderDet = By.cssSelector("#spnOrderNo");
    By accountDet = By.xpath("//span[@id='spnOrderNo' and contains(text(), '-')]");
    By orderDetailsStatus = By.cssSelector("#span_Status span");
    By workQueue = By.id("crdWorkQueueEmbeddedWithOutbound");
    By assignmentTab = By.xpath("//li[@role='tab'][.//span[text()='Assignments']]");
    By tasksTab = By.xpath("//li[@role='tab']//span[text()='Tasks']");
    By workQueueOrderTab = By.cssSelector(".i-card__header__title");
    By editAssignmentBtn = By.cssSelector("#EditAssignmentButton");
    By editTaskBtn = By.cssSelector("#editTaskButton");
    By deleteAssignmentBtn = By.cssSelector("#deleteAssignmetButton");
    By removeTaskBtn = By.cssSelector("#removeTaskButton");
    By releaseAssignmentBtn = By.cssSelector("#ReleaseAssignmentButton");
    By printAssignmentBtn = By.cssSelector("#PrintAssignmentButton");
    By moveAssignmentBtn = By.cssSelector("#moveTaskButton");
    By topOffTaskBtn = By.cssSelector("#topOffTaskButton");
    By reprocessTasksBtn = By.cssSelector("#reprocessTasksButton");
    By releaseCheckbox = By.cssSelector("#isRelease");
    By workQueueAssignmentTable = By.cssSelector(".k-grid-table");
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
    By estimatedTimeFilter = By.cssSelector(".i-btn-checkbox  #EstimatedTime");
    By standardTimeFilter = By.cssSelector(".i-btn-checkbox  #StandardTime");
    By actualTimeFilter = By.cssSelector(".i-btn-checkbox  #ActualTime");
    By activityIndicatorFilter = By.cssSelector(".i-btn-checkbox  #ActivityIndicator");
    By remainingFilter = By.cssSelector(".i-btn-checkbox  #Remaining");
    By printedFilter = By.cssSelector(".i-btn-checkbox  #Printed");
    By editAssignmentType = By.cssSelector("#wqListAssignmentType");
    By editAssignmentTaskGroup = By.cssSelector("#wqListTaskGroup");
    By editAssignmentEditDate = By.cssSelector("#wqAssignmentEditDate");
    By editAssignmentEditTime = By.cssSelector("#wqAssignmentEditTime");
    By editAssignmentUsers = By.cssSelector("#wqListAssignmentUsers");
    By userDropdown = By.xpath("//span[.//label[text()='User']]//span[@class='k-input']");
    By editAssignmentEditComplete = By.cssSelector("#WorkQueueAssignmentsEditComplete");
    By editAssignmentEditCompleteLabel = By.xpath("//label[@for='WorkQueueAssignmentsEditComplete']");
    By reviewOrder = By.xpath("//label[contains(text(), 'Review order')]");
    By notificationMsg = By.cssSelector(".toast-message");
    By scheduledDate = By.cssSelector("#cpDate");
    By scheduledTime = By.cssSelector("#cpTile");
    By carrierDropdown = By
            .xpath("//span[contains(@class,'k-textbox-container')][.//label[text()='Carrier']]//span[@role='listbox']");
    By paymentTypeDropdown = By
            .xpath("//span[contains(@class,'k-textbox-container')][.//label[text()='Payment type']]//span[@role='listbox']");
    By commentsArea = By
            .xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Comment']]//textarea");
    By shipperDateColumn = By.xpath("//span[text()='Date']");
    By shipperFromStatusColumn = By.xpath("//span[text()='From status']");
    By shipperToStatusColumn = By.xpath("//span[text()='To status']");
    By shipperUserColumn = By.xpath("//span[text()='User']");
    By sourceOrderTypeColumn = By.xpath("//span[text()='Order type']");
    By sourceOrderColumn = By.xpath("//span[text()='Order no.']");
    By sourceStatusColumn = By.xpath("//span[text()='Status']");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By moveShipDate = By.cssSelector("#moveStartDate-label");
    By moveShipDateInput = By.id("moveStartDate");
    By routeInput = By.xpath("//div[contains(@class, 'k-textbox-container')][.//label[text()='Route']]//input");
    By uploadButton = By.cssSelector(".k-upload-button");
    By dataAlt1 = By.xpath("//input[@name='Alt1']");
    By dataAlt2 = By.xpath("//input[@name='Alt2']");
    By dataAlt3 = By.xpath("//input[@name='alt3']");
    By dropdownList = By.id("dropdownList");

    public void waitOutboundOrderSummaryPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getTitle());
        Waiters.waitForElementToBeDisplay(getTableContent());
    }

    public void waitForWorkPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(workQueue);
        Waiters.waitForElementToBeDisplay(assignmentTab);
        Waiters.waitForElementToBeDisplay(assignmentTab);
    }

    public String getOutboundOrderPageTitle() {
        Waiters.waitForElementToBeDisplay(getTitle());
        return getTitle().getText().trim();
    }

    public List<WebElement> getRoutes() {
        Waiters.waitForPresenceOfAllElements(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class, 'k-child-animation-container')]"));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class, 'k-child-animation-container')]"));
    }

    public void clickWorkItem() {
        Waiters.waitForElementToBeClickable(getWorkIcon());
        clickOnElement(getWorkIcon());
    }

    public void clickAssignItem() {
        Waiters.waitForElementToBeClickable(getAssignIcon());
        clickOnElement(getAssignIcon());
    }

    public void clickSaveButton() {
        Waiters.waitForElementToBeClickable(getSaveButton());
        clickOnElement(getSaveButton());
    }

    public void selectOrderByOrderName(String order) {
        Waiters.waitForPresenceOfElement(tableContent);
        typeText(getEnterOrderInput(), order);
        pressTab(getEnterOrderInput());
        clickOnElement(findWebElement(By.xpath("//tr[@class='k-detail-row'][.//span[contains(text(), '" + order + "')]]")));
        Waiters.waitABit(3000);
    }

    public void clickTaskItem() {
        Waiters.waitForElementToBeClickable(getTaskIcon());
        clickOnElement(getTaskIcon());
    }

    public void clickUserDropdown() {
        Waiters.waitForElementToBeClickable(getUserDropdown());
        clickOnElement(getUserDropdown());
    }

    public void selectRandomUserFromDropdown() {
        Waiters.waitForPresenceOfAllElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        List<WebElement> users = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        clickOnElement(users.get(new Random().nextInt(users.size())));
    }

    public void selectOrderCheckboxByOrderNumber(int orderNum) {
        Waiters.waitForPresenceOfElement(tableContent);
        Waiters.waitABit(2000);
        List<WebElement> checkBoxes = getTableContent().findElements(By.xpath(".//tr[@class='k-detail-row']//input"));
        Waiters.waitForElementToBeDisplay(checkBoxes.get(orderNum));
        Waiters.waitABit(4000);
        clickOnElement(checkBoxes.get(orderNum));
        Waiters.waitABit(2000);
    }

    public String getNotificationMessageText() {
        Waiters.waitForPresenceOfElement(By.cssSelector(".toast-message"));
        return getNotificationMsg().getText().trim();
    }

    public void clickEditItem() {
        Waiters.waitForElementToBeClickable(getEditAssignmentBtn());
        clickOnElement(getEditAssignmentBtn());
    }

    public void clickAddFilter() {
        Waiters.waitForElementToBeClickable(getAddFilterButton());
        clickOnElement(getAddFilterButton());
    }

    public String getGridTableRowByIndex(int row) {
        Waiters.waitABit(2000);
        return getText(getTableContent().findElements(By.xpath(".//tr")).get(row));
    }

    public String getNoRecordsRowContent() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(By.cssSelector(".k-grid-norecords"));
        return getText(By.cssSelector(".k-grid-norecords"));
    }

    public String getOrderStartCurrentValue() {
        Waiters.waitABit(2000);
        Waiters.waitForAllElementsToBeDisplay(getOrderStart().get(0), getOrderStart().get(1));
        return getValue(findWebElements(By.id("dateOrderStart")).get(0));
    }

    public String getOrderStartFutureValue() {
        Waiters.waitABit(2000);
        Waiters.waitForAllElementsToBeDisplay(getOrderStart().get(0), getOrderStart().get(1));
        return getValue(findWebElements(By.id("dateOrderStart")).get(1));
    }

    public void typeOrderStartDate(String date) {
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeClickable(getOrderStart().get(0));
        clickOnElement(getOrderStart().get(0));
        pressDelete(getOrderStart().get(0));
        inputText(getOrderStart().get(0), date);
        pressTab(getOrderStart().get(0));
        Waiters.waitABit(8000);
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void typeOrderEndDate(String date) {
        Waiters.waitABit(3000);
        doubleClick(getOrderStart().get(1));
        Waiters.waitABit(3000);
        pressDelete(getOrderStart().get(1));
        Waiters.waitABit(3000);
        inputText(getOrderStart().get(1), date);
        Waiters.waitABit(3000);
        pressTab(getOrderStart().get(1));
        Waiters.waitABit(3000);
    }

    public void typeScheduledDate(String date) {
        doubleClick(getScheduledDate());
        pressDelete(getScheduledDate());
        inputText(getScheduledDate(), date);
        pressEnter(getScheduledDate());
        Waiters.waitABit(2000);
    }

    public void typeComments(String comments) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getCommentsArea());
        clear(getCommentsArea());
        inputText(getCommentsArea(), comments);
        Waiters.waitABit(2000);
    }

    public void typeScheduledTime(String time) {
        Waiters.waitForElementToBeClickable(getScheduledTime());
        click(getScheduledTime());
        pressLeftArrow(getScheduledTime());
        pressLeftArrow(getScheduledTime());
        pressLeftArrow(getScheduledTime());
        pressLeftArrow(getScheduledTime());
        Waiters.waitABit(2000);
        inputText(getScheduledTime(), time.split(":")[0]);
        pressRightArrow(getScheduledTime());
        Waiters.waitABit(2000);
        inputText(getScheduledTime(), time.split(":")[1]);
        pressTab(getScheduledTime());
    }

    public void typeAccount(String account) {
        Waiters.waitForElementToBeClickable(getEnterAccount());
        enterText(getEnterAccount(), account);
    }

    public void typeProduct(String product) {
        Waiters.waitForElementToBeClickable(getEnterProduct());
        enterText(getEnterProduct(), product);
        Waiters.waitABit(1000);
        pressTab(getEnterProduct());
    }

    public void searchAccount(String account) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getAccountSearch());
        enterText(getAccountSearch(), account);
        pressEnter(getAccountSearch());
    }

    public void searchOrder(CharSequence order) {
        Waiters.waitABit(2000);
        clear(getEnterOrder());
        inputText(getEnterOrder(), order);
        pressEnter(getEnterOrder());
    }

    public void clickSearchOrderButton() {
        Waiters.waitForElementToBeDisplay(getSearchOrderButton());
        clickOnElement(getSearchOrderButton());
    }

    public void selectItemByNumber(int num) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getWorkQueueAssignmentTable());
        clickOnElement(getWorkQueueAssignmentTable().findElements(By.xpath(".//tr")).get(num));
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeClickable(getCancelButton());
        clickOnElement(getCancelButton());
    }

    public void clickClearButton() {
        Waiters.waitForElementToBeClickable(getClearAccount());
        clickOnElement(getClearAccount());
        Waiters.waitABit(2000);
    }

    public void clearAccountField() {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeClickable(getEnterAccount());
        clickOnElement(getEnterAccount());
        doubleClick(enterAccount);
        clear(getEnterAccount());
        Waiters.waitABit(2000);
    }

    public void clickClearAccountSearchButton() {
        Waiters.waitForElementToBeClickable(getClearAccountIndex());
        clickOnElement(getClearAccountIndex());
    }

    public void clickAllStatusButton() {
        Waiters.waitForElementToBeClickable(getAllStatusesDropDown());
        clickOnElement(getAllStatusesDropDown());
    }

    public void clickAssignmentType() {
        Waiters.waitForElementToBeClickable(getEditAssignmentType());
        clickOnElement(getEditAssignmentType());
    }

    public void clickOrderOption() {
        Waiters.waitForElementToBeClickable(getOrderOptions());
        clickOnElement(getOrderOptions());
    }

    public List<WebElement> getAssignmentTypes() {
        Waiters.waitForPresenceOfAllElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public List<WebElement> getUsers() {
        Waiters.waitForPresenceOfElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public List<WebElement> getOrderTypes() {
        Waiters.waitForPresenceOfElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='option']"));
    }

    public String getAllStatusDropdownText() {
        Waiters.waitForElementToBeDisplay(getAllStatusesDropDown());
        return getText(getAllStatusesDropDown());
    }

    public void clickBackButton() {
        pressPageUp(getBackButton());
        Waiters.waitForElementToBeDisplay(By.xpath("//button[contains(text(), 'Back')]"));
        clickOnElement(By.xpath("//button[contains(text(), 'Back')]"));
        Waiters.waitABit(8000);
    }

    public void clearOrderInput() {
        Waiters.waitForElementToBeDisplay(getEnterOrderInput());
        doubleClick(getEnterOrderInput());
        pressDelete(getEnterOrderInput());
        Waiters.waitABit(8000);
    }

    public List<String> getAllStatuses() {
        return Arrays.stream(getText(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]")))
                .split("\\n"))
                .collect(Collectors.toList());
    }

    public String getWorkQueueOrder() {
        return getText(getWorkQueueOrderTab());
    }

    public void selectOutboundOrderStatus(String status) {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeClickable(getAllStatusesDropDown());
        clickOnElement(getAllStatusesDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "')]")));
        Waiters.waitABit(8000);
    }

    public void selectOutboundOrderOption(String option) {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeClickable(getOrderOptions());
        clickOnElement(getOrderOptions());
        Waiters.waitABit(2000);
        WebElement orderOption = findWebElement(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@class='k-item' and contains(text(), '"
                + option + "')]"));
        clickOnElement(orderOption);
        Waiters.waitABit(4000);
    }

    public void selectOutboundOrderAccount(String account) {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeClickable(getEnterAccount());
        inputText(getEnterAccount(), account);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + account + "')]")));
        pressEnter(getEnterAccount());
    }

    public void selectOutboundOrderProduct(String product) {
        Waiters.waitForElementToBeDisplay(getEnterProduct());
        Waiters.waitABit(1000);
        doubleClick(getEnterProduct());
        Waiters.waitABit(1000);
        pressDelete(getEnterProduct());
        clear(getEnterProduct());
        Waiters.waitABit(1000);
        inputText(getEnterProduct(), product);
        Waiters.waitABit(3000);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + product + "')]")));
        pressEnter(getEnterProduct());
        pressEnter(getEnterProduct());
        Waiters.waitABit(8000);
    }

    public void clickDoorDropDown(String door) {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeClickable(getDoorsDropDown());
        clickOnElement(getDoorsDropDown());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + door + "')]")));
        Waiters.waitForForElementToDisappear(getLoadingImage());
    }

    public void selectDoorListOption(String door) {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeClickable(doorsListDropDown);
        clickOnElement(doorsListDropDown);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + door + "')]")));
        Waiters.waitABit(6000);
    }

    public void selectDetailsRow(int num) {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeClickable(getDetailRows().get(num));
        Waiters.waitForElementToBeDisplay(getDetailRows().get(num));
        clickOnElement(getDetailRows().get(num));
        Waiters.waitABit(4000);
    }

    public void selectProductRow(int num) {
        Waiters.waitForPresenceOfAllElements(By.xpath("//div[contains(@id, 'divProgressbar')]"));
        clickOnElement(getProducts().get(num));
        Waiters.waitForPresenceOfElement(By.cssSelector("#spnDoor"));
    }

    public List<String> getProductsText() {
        Waiters.waitABit(2000);
        Waiters.waitForPresenceOfAllElements(By.xpath("//div[@class='BarsBlock']//span[contains(@class, 'Title2 h15')]"));
        return getProducts().stream()
                .map(row -> row.getText())
                .collect(Collectors.toList());
    }

    public void selectOrderDetailsBox(int num) {
        Waiters.waitABit(6000);
        Waiters.waitForElementToBeClickable(getDetailedRowsCheckboxes().get(num));
        clickOnElement(getDetailedRowsCheckboxes().get(num));
    }

    public int getOrderDetailsRowsNumber() {
        Waiters.waitABit(4000);
        return getDetailRows().size();
    }

    public int getAccountRowsNumber() {
        Waiters.waitABit(4000);
        return getAccountRows().size();
    }

    public List<String> getAccounts() {
        return getAccountIndexRows().stream()
                .map(WebElement::getText)
                .map(detail -> detail.split("\\n"))
                .map(arr -> Arrays.stream(arr).collect(Collectors.joining(" ")))
                .collect(Collectors.toList());
    }

    public String getOrderStatusText() {
        Waiters.waitABit(3000);
        return getText(By.cssSelector("#span_Status"));
    }

    public String getOrderDoorText() {
        Waiters.waitABit(3000);
        return getText(By.cssSelector("#spnDoor"));
    }

    public String getCarrierDropdownText() {
        Waiters.waitABit(3000);
        return getText(getCarrierDropdown());
    }

    public String getPopupTitleText() {
        Waiters.waitForElementToBeDisplay(getDialog());
        return getText(getDialog());
    }

    public String getAccountWindowTitleText() {
        Waiters.waitForElementToBeDisplay(getAccountWindow());
        return getText(getAccountWindow());
    }

    public String getScheduledDateValue() {
        Waiters.waitForElementToBeDisplay(getScheduledDate());
        return getValue(getScheduledDate());
    }

    public String getScheduledTimeValue() {
        Waiters.waitForElementToBeDisplay(getScheduledTime());
        return getValue(getScheduledTime());
    }

    public String getOrderAccountText() {
        Waiters.waitForElementToBeDisplay(getOrderAccount());
        return getText(getOrderAccount());
    }

    public String getEnterAccountText() {
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeDisplay(getEnterAccount());
        return getElementAttribute(getEnterAccount(), "placeholder");
    }

    public String getEnterProductText() {
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeDisplay(getEnterProduct());
        return getElementAttribute(getEnterProduct(), "placeholder");
    }

    public String getEnterAccountDropDownText(String value) {
        Waiters.waitABit(3000);
        return getText(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + value + "')]")));
    }

    public WebElement getEnterAccountDropDownOption(String value) {
        Waiters.waitABit(3000);
        return findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + value + "')]"));
    }

    public String getEnterProductDropDownText(String value) {
        Waiters.waitABit(4000);
        return getText(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + value + "')]")));
    }

    public String getEnterProductDropDownValue() {
        Waiters.waitABit(4000);
        return getValue(getEnterProduct());
    }

    public String getAccountDropDownValue() {
        Waiters.waitABit(3000);
        return getValue(By.cssSelector("input[placeholder='Enter a account']"));
    }

    public void clickOkButton() {
        Waiters.waitForPresenceOfElement(By.xpath("//button[contains(text(), 'Ok')]"));
        clickOnElement(By.xpath("//button[contains(text(), 'Ok')]"));
    }

    public void clickRandomPopup() {
        Waiters.waitForElementsToBeDisplay(getRoutes().get(0), getRoutes().get(getRoutes().size()-1));
        clickOnElement(getRoutes().get(new Random().nextInt(getRoutes().size())));
    }

    public void clickRouteDropdownButton() {
        Waiters.waitForElementToBeClickable(getRouteInput());
        clickOnElement(getRouteInput());
    }

    public void clickOrderTypeDropdownButton() {
        Waiters.waitForElementToBeClickable(getOrderTypeDropDown());
        clickOnElement(getOrderTypeDropDown());
    }

    public void selectOrderType(String type) {
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + type + "') and @role='option']")));
        Waiters.waitABit(3000);
    }

    public String getItemsCountValue() { return getText(getItemsCount()); }

    public List<WebElement> getAssignmentTableRows() {
        Waiters.waitForElementToBeDisplay(getWorkQueueAssignmentTable());
        return getWorkQueueAssignmentTable().findElements(By.xpath(".//tr"));
    }

    public boolean isPageTitleDisplayed() {
        return isElementDisplay(getTitle());
    }

    public boolean isLoadingImageDisplayed() {
        return isElementDisplay(getLoadingImage());
    }

    public int areOrderStartDatesDisplayed() {
        return elementsArePresent(getOrderStart());
    }

    public boolean isEnterOrderDisplayed() {
        return isElementDisplay(getEnterOrder());
    }

    public boolean isAllStatusesDropDownDisplayed() {
        return isElementDisplay(getAllStatusesDropDown());
    }

    public boolean isDoorsDropDownDisplayed() {
        return isElementDisplay(getDoorsDropDown());
    }

    public boolean isEnterProductDisplayed() {
        return isElementDisplay(getEnterProduct());
    }

    public boolean isAccountSearchDisplayed() { return isElementDisplay(getAccountSearch()); }

    public boolean isAddFilterButtonDisplayed() { return isElementDisplay(getAddFilterButton()); }

    public boolean isCancelButtonDisplayed() { return isElementDisplay(getCancelButton()); }

    public boolean isSearchProductButtonDisplayed() { return isElementDisplay(getSearchProductButton()); }

    public boolean isOrderOptionsDisplayed() { return isElementDisplay(getOrderOptions()); }

    public boolean isTableContentDisplayed() { return isElementDisplay(getTableContent()); }

    public boolean isOrdersColumnDisplayed() { return isElementDisplay(getOrdersColumn()); }

    public boolean isQuantityColumnDisplayed() { return isElementDisplay(getQuantityColumn()); }

    public boolean isLinesColumnDisplayed() { return isElementDisplay(getLinesColumn()); }

    public boolean isPalletsColumnDisplayed() { return isElementDisplay(getPalletsColumn()); }

    public boolean isCubeColumnDisplayed() { return isElementDisplay(getCubeColumn()); }

    public boolean isWeightColumnDisplayed() { return isElementDisplay(getWeightColumn()); }

    public boolean isStatusIconActive() { return checkElementAttribute(getStatusIcon(), "class").contains("k-state-disabled"); }

    public boolean isWorkIconActive() { return checkElementAttribute(getWorkIcon(), "class").contains("k-state-disabled"); }

    public boolean isAssignIconActive() {  return checkElementAttribute(getAssignIcon(), "class").contains("k-state-disabled"); }

    public boolean isShippedStatusDisplayed() { return isElementDisplay(getShippedStatus()); }

    public boolean isAuditStatusDisplayed() { return isElementDisplay(getAuditStatus());  }

    public boolean isPickedStatusDisplayed() { return isElementDisplay(getPickedStatus()); }

    public boolean isUnallocatedStatusDisplayed() { return isElementDisplay(getUnallocatedStatus()); }

    public boolean isShortsStatusDisplayed() { return isElementDisplay(getShortsStatus()); }

    public boolean isWaitingInboundStatusDisplayed() { return isElementDisplay(getWaitingInboundStatus()); }

    public boolean isRemainderStatusDisplayed() { return isElementDisplay(getRemainderStatus()); }

    public boolean isWorkQueueDisplayed() { return isElementDisplay(getWorkQueue()); }

    public boolean isTopOffTaskButtonDisplayed() { return isElementDisplay(getTopOffTaskBtn()); }

    public boolean isReprocessTasksButtonDisplayed() { return isElementDisplay(getReprocessTasksBtn()); }

    public boolean isCarrierDropdownDisplayed() { return isElementDisplay(getCarrierDropdown()); }

    public boolean isCommentsAreaDisplayed() { return isElementDisplay(getCommentsArea()); }

    public String isTotalItemsCount() { return getText(getItemsCount()); }

    public String getOrderDetailText() { return getText(getOrderDetail()); }

    public String getOrderDetailStatusText() {
        Waiters.waitABit(3000);
        return getText(getOrderDetailsStatus());
    }

    public String getAccountDetailText() { return getText(getAccountDetail()); }

    public boolean isWorkItemDisabled() { return getElementAttribute(getWorkIcon(),"class").contains("disabled"); }

    public boolean isAssignItemDisabled() { return getElementAttribute(getAssignIcon(),"class").contains("disabled"); }

    public boolean isAssignmentTabDisplayed() { return isElementDisplay(getAssignmentTab()); }

    public boolean isShipperFromStatusDisplayed() { return isElementDisplay(getShipperFromStatus()); }

    public boolean isShipperToStatusDisplayed() { return isElementDisplay(getShipperToStatus()); }

    public boolean isShipperUserDisplayed() { return isElementDisplay(getShipperUser()); }

    public boolean isSourceOrderTypeDisplayed() { return isElementDisplay(getSourceOrderType()); }

    public boolean isSourceOrderDisplayed() { return isElementDisplay(getSourceOrder()); }

    public boolean isSourceStatusDisplayed() { return isElementDisplay(getSourceStatus()); }

    public int getAssignmentTableRowsNumber() { return elementsArePresent(getAssignmentTableRows()); }

    public boolean isAssignmentTabActive() { return getElementAttribute(getAssignmentTab(), "class").contains("active"); }

    public boolean isTasksTabDisabled() { return isElementDisplay(getTasksTab()); }

    public boolean isUploadButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getUploadButton());
        return isElementDisplay(getUploadButton());
    }

    public boolean isMoveShipDateDisplayed() { return isElementDisplay(getMoveShipDate()); }

    public boolean isMoveShipDateInputDisplayed() { return isElementDisplay(getMoveShipDateInput()); }

    public boolean isRouteInputDisplayed() { return isElementDisplay(getRouteInput()); }

    public boolean isShipperDateDisplayed() { return isElementDisplay(getShipperDate()); }

    public boolean isScheduledTimeInputDisplayed() { return isElementDisplay(getScheduledTime()); }

    public boolean isScheduledDateInputDisplayed() { return isElementDisplay(getScheduledDate()); }

    public boolean isEditAssignmentButtonDisabled() { return getElementAttribute(getEditAssignmentBtn(),
            "class").contains("disabled"); }

    public boolean isDeleteAssignmentButtonDisabled() { return getElementAttribute(getDeleteAssignmentBtn(),
            "class").contains("disabled"); }

    public boolean isReleaseAssignmentButtonDisabled() { return getElementAttribute(getReleaseAssignmentBtn(),
            "class").contains("disabled"); }

    public boolean isPrintAssignmentButtonDisabled() { return getElementAttribute(getPrintAssignmentBtn(),
            "class").contains("disabled"); }

    public boolean isMoveAssignmentButtonDisabled() { return getElementAttribute(getMoveAssignmentBtn(),
            "class").contains("disabled"); }

    public boolean isSaveButtonDisabled() { return getElementAttribute(getSaveButton(),
            "class").contains("disabled"); }

    public boolean isEditAssignmentButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentBtn());
        return isElementDisplay(getEditAssignmentBtn());
    }

    public boolean isEditTaskButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditTaskButton());
        return isElementDisplay(getEditTaskButton());
    }

    public boolean isDeleteAssignmentButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getDeleteAssignmentBtn());
        return isElementDisplay(getDeleteAssignmentBtn());
    }

    public boolean isRemoveTaskButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getRemoveTaskButton());
        return isElementDisplay(getRemoveTaskButton());
    }

    public boolean isReleaseAssignmentButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getReleaseAssignmentBtn());
        return isElementDisplay(getReleaseAssignmentBtn());
    }

    public boolean isPrintAssignmentButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getPrintAssignmentBtn());
        return isElementDisplay(getPrintAssignmentBtn());
    }

    public boolean isMoveAssignmentButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getMoveAssignmentBtn());
        return isElementDisplay(getMoveAssignmentBtn());
    }

    public boolean isAssignmentCodeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getAssignmentCodeFilter());
        return isElementDisplay(getAssignmentCodeFilter());
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

    public boolean isEstimatedTimeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getEstimatedTimeFilter());
        return isElementDisplay(getEstimatedTimeFilter());
    }

    public boolean isStandardTimeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getStandardTimeFilter());
        return isElementDisplay(getStandardTimeFilter());
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

    public boolean isEditAssignmentTypeDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentType());
        return isElementDisplay(getEditAssignmentType());
    }

    public boolean isEditAssignmentTaskGroupDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentTaskGroup());
        return isElementDisplay(getEditAssignmentTaskGroup());
    }

    public boolean isEditAssignmentEditDateDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentEditDate());
        return isElementDisplay(getEditAssignmentEditDate());
    }

    public boolean isEditAssignmentEditTimeDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentEditTime());
        return isElementDisplay(getEditAssignmentEditTime());
    }

    public boolean isEditAssignmentUsersDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentUsers());
        return isElementDisplay(getEditAssignmentUsers());
    }

    public boolean isEditAssignmentEditCompleteDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentEditComplete());
        return isElementDisplay(getEditAssignmentEditComplete());
    }

    public boolean isEditAssignmentCompleteLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentCompleteLabel());
        return isElementDisplay(getEditAssignmentCompleteLabel());
    }

    public boolean isReleaseCheckboxDisplayed() {
        Waiters.waitForElementToBeDisplay(getReleaseCheckbox());
        return isElementDisplay(getReleaseCheckbox());
    }

    public boolean isPaymentTypeDropdownDisplayed() {
        Waiters.waitForElementToBeDisplay(getPaymentTypeDropdown());
        return isElementDisplay(getPaymentTypeDropdown());
    }

    public boolean isReviewOrderDisplayed() {
        Waiters.waitForElementToBeDisplay(getReviewOrder());
        return isElementDisplay(getReviewOrder());
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

    public boolean areTableHeadersPresent() {
        return elementsArePresent(getTableHeaders()) > 0;
    }

    public String getPopupTitle() { return getText(getAccountWindow()); }

    public String getEditAssignmentText() { return getText(getEditAssignmentType()); }

    public WebElement getTitle() { return findWebElement(title); }

    public WebElement getLoadingImage() { return findWebElement(loadingImage); }

    public String getItemsFound() { return getText(getItemsCount()); }

    public String getDoorDropDownValue() { return getText(getDoorsDropDown()); }

    public String getNotificationText() { return getText(getNotification()); }

    public String getCommentsText() { return getText(getCommentsArea()); }

    public boolean isGetWorkQueueOrderDisplayed(String order) { return getWorkQueueOrder().contains(order); }

    public List<WebElement> getOrderStart() { return findWebElements(orderStart); }

    public WebElement getEnterOrder() { return findWebElement(enterOrder); }

    public WebElement getEnterAccount() { return findWebElement(enterAccount); }

    public WebElement getClearAccount() { return findWebElement(clearAccount); }

    public WebElement getClearAccountIndex() { return findWebElement(clearAccountIndex); }

    public WebElement getOrderAccount() { return findWebElement(orderAccount); }

    public WebElement getSearchOrderButton() { return findWebElement(searchOrderButton); }

    public WebElement getAllStatusesDropDown() { return findWebElement(allStatusesDropDown); }

    public WebElement getDoorsDropDown() { return findWebElement(doorsDropDown); }

    public WebElement getDoorsListDropDown() { return findWebElement(doorsListDropDown); }

    public WebElement getOrderTypeDropDown() { return findWebElement(orderTypeDropDown); }

    public WebElement getEnterProduct() { return findWebElement(enterProduct); }

    public WebElement getSearchProductButton() { return findWebElement(searchProductButton); }

    public WebElement getOrderOptions() { return findWebElement(orderOptions); }

    public WebElement getShippedStatus() { return findWebElement(shippedStatus); }

    public WebElement getAuditStatus() { return findWebElement(auditStatus); }

    public WebElement getPickedStatus() { return findWebElement(pickedStatus); }

    public WebElement getUnallocatedStatus() { return findWebElement(unallocatedStatus); }

    public WebElement getShortsStatus() { return findWebElement(shortsStatus); }

    public WebElement getWaitingInboundStatus() { return findWebElement(waitingInboundStatus); }

    public WebElement getRemainderStatus() { return findWebElement(remainderStatus); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public List<WebElement> getDetailRows() { return findWebElements(detailRows); }

    public List<WebElement> getAccountRows() { return findWebElements(accountRows); }

    public List<WebElement> getAccountIndexRows() { return findWebElements(accountIndexRows); }

    public WebElement getAccountSearch() { return findWebElement(accountSearch); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public List<WebElement> getDetailedRowsCheckboxes() { return findWebElements(detailedRowsCheckboxes); }

    public WebElement getItemsCount() { return findWebElement(itemsCount); }

    public WebElement getCancelButton() { return findWebElement(cancelButton); }

    public WebElement getSummaryInboundOrderDetails() { return findWebElement(summaryInboundOrderDetails); }

    public WebElement getOrderStatus() { return findWebElement(orderStatus); }

    public WebElement getBackButton() { return findWebElement(backButton); }

    public WebElement getDialog() { return findWebElement(dialog); }

    public WebElement getAccountWindow() { return findWebElement(accountWindow); }

    public List<WebElement> getProducts() { return findWebElements(products); }

    public WebElement getNotification() { return findWebElement(notification); }

    public WebElement getStatusIcon() { return findWebElement(statusIcon); }

    public WebElement getWorkIcon() { return findWebElement(workIcon); }

    public WebElement getTaskIcon() { return findWebElement(taskIcon); }

    public WebElement getAssignIcon() { return findWebElement(assignIcon); }

    public WebElement getOrdersColumn() { return findWebElement(ordersColumn); }

    public WebElement getQuantityColumn() { return findWebElement(quantityColumn); }

    public WebElement getLinesColumn() { return findWebElement(linesColumn); }

    public WebElement getPalletsColumn() { return findWebElement(palletsColumn); }

    public WebElement getCubeColumn() { return findWebElement(cubeColumn); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getOrderDetail() { return findWebElement(orderDet); }

    public WebElement getAccountDetail() { return findWebElement(accountDet); }

    public WebElement getOrderDetailsStatus() { return findWebElement(orderDetailsStatus); }

    public WebElement getWorkQueue() { return findWebElement(workQueue); }

    public WebElement getAssignmentTab() { return findWebElement(assignmentTab); }

    public WebElement getTasksTab() { return findWebElement(tasksTab); }

    public WebElement getWorkQueueOrderTab() { return findWebElement(workQueueOrderTab); }

    public WebElement getEditAssignmentBtn() { return findWebElement(editAssignmentBtn); }

    public WebElement getDeleteAssignmentBtn() { return findWebElement(deleteAssignmentBtn); }

    public WebElement getReleaseAssignmentBtn() { return findWebElement(releaseAssignmentBtn); }

    public WebElement getPrintAssignmentBtn() { return findWebElement(printAssignmentBtn); }

    public WebElement getMoveAssignmentBtn() { return findWebElement(moveAssignmentBtn); }

    public WebElement getTopOffTaskBtn() { return findWebElement(topOffTaskBtn); }

    public WebElement getReprocessTasksBtn() { return findWebElement(reprocessTasksBtn); }

    public WebElement getWorkQueueAssignmentTable() { return findWebElement(workQueueAssignmentTable); }

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

    public WebElement getEstimatedTimeFilter() { return findWebElement(estimatedTimeFilter); }

    public WebElement getStandardTimeFilter() { return findWebElement(standardTimeFilter); }

    public WebElement getActualTimeFilter() { return findWebElement(actualTimeFilter); }

    public WebElement getActivityIndicatorFilter() { return findWebElement(activityIndicatorFilter); }

    public WebElement getRemainingFilter() { return findWebElement(remainingFilter); }

    public WebElement getPrintedFilter() { return findWebElement(printedFilter); }

    public List<WebElement> getTableHeaders() { return findWebElements(tableHeaders); }

    public WebElement getEditAssignmentType() { return findWebElement(editAssignmentType); }

    public WebElement getEditAssignmentTaskGroup() { return findWebElement(editAssignmentTaskGroup); }

    public WebElement getEditAssignmentEditDate() { return findWebElement(editAssignmentEditDate); }

    public WebElement getEditAssignmentEditTime() { return findWebElement(editAssignmentEditTime); }

    public WebElement getEditAssignmentUsers() { return findWebElement(editAssignmentUsers); }

    public WebElement getEditAssignmentEditComplete() { return findWebElement(editAssignmentEditComplete); }

    public WebElement getEditAssignmentCompleteLabel() { return findWebElement(editAssignmentEditCompleteLabel); }

    public WebElement getRemoveTaskButton() { return findWebElement(removeTaskBtn); }

    public WebElement getEditTaskButton() { return findWebElement(editTaskBtn); }

    public WebElement getReleaseCheckbox() { return findWebElement(releaseCheckbox); }

    public WebElement getUserDropdown() { return findWebElement(userDropdown); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getScheduledDate() { return findWebElement(scheduledDate); }

    public WebElement getScheduledTime() { return findWebElement(scheduledTime); }

    public WebElement getCarrierDropdown() { return findWebElement(carrierDropdown); }

    public WebElement getPaymentTypeDropdown() { return findWebElement(paymentTypeDropdown); }

    public WebElement getCommentsArea() { return findWebElement(commentsArea); }

    public WebElement getShipperDate() { return findWebElement(shipperDateColumn); }

    public WebElement getShipperFromStatus() { return findWebElement(shipperFromStatusColumn); }

    public WebElement getShipperToStatus() { return findWebElement(shipperToStatusColumn); }

    public WebElement getShipperUser() { return findWebElement(shipperUserColumn); }

    public WebElement getSourceOrderType() { return findWebElement(sourceOrderTypeColumn); }

    public WebElement getSourceOrder() { return findWebElement(sourceOrderColumn); }

    public WebElement getSourceStatus() { return findWebElement(sourceStatusColumn); }

    public WebElement getEnterOrderInput() {  return findWebElement(enterOrder); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getMoveShipDate() { return findWebElement(moveShipDate); }

    public WebElement getMoveShipDateInput() { return findWebElement(moveShipDateInput); }

    public WebElement getRouteInput() { return findWebElement(routeInput); }

    public WebElement getUploadButton() { return findWebElement(uploadButton); }

    public WebElement getReviewOrder() { return findWebElement(reviewOrder); }

    public WebElement getDataAlt1() { return findWebElement(dataAlt1); }

    public WebElement getDataAlt2() { return findWebElement(dataAlt2); }

    public WebElement getDataAlt3() { return findWebElement(dataAlt3); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
