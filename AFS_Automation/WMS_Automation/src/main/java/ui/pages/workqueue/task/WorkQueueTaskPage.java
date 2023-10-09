package ui.pages.workqueue.task;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

public class WorkQueueTaskPage extends BasePage {
    By taskListTitle = By.xpath("//span[contains(text(), 'Task list')]");
    By editTaskBtn = By.cssSelector("#editTaskButton");
    By deleteTaskBtn = By.cssSelector("#removeTaskButton");
    By topOffTaskButton = By.id("topOffTaskButton");
    By moveTaskBtn = By.cssSelector("#moveTaskButton");
    By reprocessTaskBtn = By.cssSelector("#reprocessTasksButton");
    By addFilterButton = By.xpath("//span[contains(text(), 'Add filter')]");
    By searchInputWorkQueueTask= By.id("TaskGridSearch_WorkQueue_self_false");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By productColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Product')]");
    By qtyColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Qty')]");
    By fromColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'From')]");
    By toColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'To')]");
    By typeColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Type')]");
    By taskGroupColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Task group')]");
    By statusColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Status')]");
    By assignmentNumColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Assignment #')]");
    By priorityColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Priority')]");
    By routeColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Route')]");
    By stopColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Stop')]");
    By shipperColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Shipper')]");
    By velocityColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Velocity')]");
    By descriptionColumn = By.xpath("//div[contains(@class, 'outBoundRSummaryWQTaskGrid')]//span[contains(text(), 'Description')]");
    By typesDropDown = By.xpath("//span[contains(text(), 'Type:')]");
    By taskGroupDropDown = By.xpath("//span[contains(text(), 'Task group:')]");
    By workQueueTasksToolTip = By.xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@class, 'k-tooltip-content')]");
    By tableContent = By.xpath("//table[@class='k-grid-table']");
    By tasksSelectedItemsFound = By.cssSelector("#wqTaskGrid .i-summary-area__other__section__label");
    By tasksSelectedCountNumber = By.cssSelector("#wqTaskGrid .i-summary-area__other__section__value");
    By tasksItemsCountNumber = By.cssSelector("#wqTaskGrid .i-summary-area__main__value");
    By productFilter = By.cssSelector(".i-btn-checkbox  #Product");
    By strQtyFilter = By.cssSelector(".i-btn-checkbox  #strQty");
    By fromFilter = By.cssSelector(".i-btn-checkbox  #From");
    By toFilter = By.cssSelector(".i-btn-checkbox  #To");
    By typeFilter = By.cssSelector(".i-btn-checkbox  #Type");
    By taskGroupFilter = By.cssSelector(".i-btn-checkbox  #TaskGroup");
    By statusFilter = By.cssSelector(".i-btn-checkbox  #Status");
    By assignmentNumberFilter = By.cssSelector(".i-btn-checkbox  #AssignmentNumber");
    By priorityFilter = By.cssSelector(".i-btn-checkbox  #Priority");
    By routeFilter = By.cssSelector(".i-btn-checkbox  #Route");
    By stopFilter = By.cssSelector(".i-btn-checkbox  #Stop");
    By shipperFilter = By.cssSelector(".i-btn-checkbox  #Shipper");
    By velocityFilter = By.cssSelector(".i-btn-checkbox  #Velocity");
    By descriptionFilter = By.cssSelector(".i-btn-checkbox  #Description");
    By clearAllButton = By.xpath("//button[text()='Clear all']");
    By inputContains = By.xpath("//input[@placeholder='Contains']");
    By applyButton = By.xpath("//button[text()='Apply']");
    By inputCheckIn = By.xpath("//input[contains(@id, 'Check In')]");
    By inputCycleCount = By.xpath("//input[contains(@id, 'Cycle Count')]");
    By inputLetdown = By.xpath("//input[contains(@id, 'Letdown')]");
    By inputLoadCountAudit = By.xpath("//input[contains(@id, 'Load Count Audit')]");
    By inputLoading = By.xpath("//input[contains(@id, 'Loading')]");
    By inputMovement = By.xpath("//input[contains(@id, 'Movement')]");
    By inputOpportunisticCount = By.xpath("//input[contains(@id, 'Opportunistic Count')]");
    By inputPackStaging = By.xpath("//input[contains(@id, 'Pack Staging')]");
    By inputPacking = By.xpath("//input[contains(@id, 'Packing')]");
    By inputPick = By.xpath("//input[contains(@id, 'Pick')]");
    By inputPickFromReserve = By.xpath("//input[contains(@id, 'Pick from Reserve')]");
    By inputPutaway = By.xpath("//input[contains(@id, 'Putaway')]");
    By inputReplenishment = By.xpath("//input[contains(@id, 'Replenishment')]");
    By inputShipping = By.xpath("//input[contains(@id, 'Shipping')]");
    By inputShortChasing = By.xpath("//input[contains(@id, 'Short Chasing')]");
    By inputTopOff = By.xpath("//input[contains(@id, 'Top Off')]");
    By inputWavePick = By.xpath("//input[contains(@id, 'Wave Pick')]");
    By inputCount = By.xpath("//input[contains(@id, 'COUNT')]");
    By inputDee = By.xpath("//input[contains(@id, 'DEE')]");
    By inputDefault = By.xpath("//input[contains(@id, 'DEFAULT')]");
    By inputLoad = By.xpath("//input[contains(@id, 'LOAD')]");
    By inputNeedsLoc = By.xpath("//input[contains(@id, 'NEEDS LOC')]");
    By inputPalChill = By.xpath("//input[contains(@id, 'PAL CHILL')]");
    By inputPalDry = By.xpath("//input[contains(@id, 'PAL DRY')]");
    By inputPalFrz = By.xpath("//input[contains(@id, 'PAL FRZ')]");
    By inputPickChill = By.xpath("//input[contains(@id, 'PICK CHILL')]");
    By inputPickDry = By.xpath("//input[contains(@id, 'PICK DRY')]");
    By inputPickFrz = By.xpath("//input[contains(@id, 'PICK FRZ')]");
    By inputReplen = By.xpath("//input[contains(@id, 'REPLEN')]");
    By inputShort = By.xpath("//input[contains(@id, 'SHORT')]");
    By inputTestcode = By.xpath("//input[contains(@id, 'TESTCODE')]");
    By inputWpBrpMed = By.xpath("//input[contains(@id, 'WP BRP, MED')]");

    public void waitWorkQueueTaskPageToLoad() {
        Waiters.waitABit(6000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getTaskListTitle());
        Waiters.waitForElementToBeDisplay(getEditTaskButton());
        Waiters.waitForElementToBeDisplay(getDeleteTaskButton());
        Waiters.waitForElementToBeDisplay(getTopOffTaskButton());
        Waiters.waitForElementToBeDisplay(getMoveTaskButton());
        Waiters.waitForElementToBeDisplay(getReprocessTaskButton());
    }

    public void clickTaskListTitle() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(taskListTitle);
        clickOnElement(taskListTitle);
    }

    public void hoverOverSearchInput() {
        Waiters.waitABit(2000);
        hover(searchInputWorkQueueTask);
    }

    public void checkTaskByTaskIndex(int index) {
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> tasks = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-master-row')]"));
        clickOnElement(tasks.get(index).findElement(By.xpath(".//input[@type='checkbox']")));
    }

    public void clickAddFilter() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getAddFilterButton());
        clickOnElement(getAddFilterButton());
    }

    public void clickClearAllButton() {
        Waiters.waitForElementToBeDisplay(getClearAllButton());
        clickOnElement(getClearAllButton());
    }

    public void checkProductFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getProductFilter());
        clickOnElement(getProductFilter());
    }

    public void typeFilter(String filter) {
        Waiters.waitForElementToBeDisplay(getInputContains());
        inputText(getInputContains(), filter);
    }

    public void clickApplyButton() {
        Waiters.waitForElementToBeDisplay(getApplyButton());
        clickOnElement(getApplyButton());
    }

    public void checkStrQtyFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getStrQtyFilter());
        clickOnElement(getStrQtyFilter());
    }

    public void checkFromFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getFromFilter());
        clickOnElement(getFromFilter());
    }

    public void checkToFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getToFilter());
        clickOnElement(getToFilter());
    }

    public void checkTypeFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getTypeFilter());
        clickOnElement(getTypeFilter());
    }

    public void checkTaskGroupFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getTaskGroupFilter());
        clickOnElement(getTaskGroupFilter());
    }

    public void checkStatusFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getStatusFilter());
        clickOnElement(getStatusFilter());
    }

    public void checkAssignmentNumberFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getAssignmentNumberFilter());
        clickOnElement(getAssignmentNumberFilter());
    }

    public void checkPriorityFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getPriorityFilter());
        clickOnElement(getPriorityFilter());
    }

    public void checkRouteFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getRouteFilter());
        clickOnElement(getRouteFilter());
    }

    public void checkStopFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getStopFilter());
        clickOnElement(getStopFilter());
    }

    public void checkShipperFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getShipperFilter());
        clickOnElement(getShipperFilter());
    }

    public void checkVelocityFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getVelocityFilter());
        clickOnElement(getVelocityFilter());
    }

    public void checkDescriptionFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getDescriptionFilter());
        clickOnElement(getDescriptionFilter());
    }

    public void checkInputCheckIn() {
        Waiters.waitForElementToBeDisplay(getInputCheckIn());
        clickOnElement(getInputCheckIn());
    }

    public void checkInputCycleCount() {
        Waiters.waitForElementToBeDisplay(getInputCycleCount());
        clickOnElement(getInputCycleCount());
    }

    public void checkInputLetdown() {
        Waiters.waitForElementToBeDisplay(getInputLetdown());
        clickOnElement(getInputLetdown());
    }

    public void checkInputLoadCountAudit() {
        Waiters.waitForElementToBeDisplay(getInputLoadCountAudit());
        clickOnElement(getInputLoadCountAudit());
    }

    public void checkInputLoading() {
        Waiters.waitForElementToBeDisplay(getInputLoading());
        clickOnElement(getInputLoading());
    }

    public void checkInputMovement() {
        Waiters.waitForElementToBeDisplay(getInputMovement());
        clickOnElement(getInputMovement());
    }

    public void checkInputOpportunisticCount() {
        Waiters.waitForElementToBeDisplay(getInputOpportunisticCount());
        clickOnElement(getInputOpportunisticCount());
    }

    public void checkInputPackStaging() {
        Waiters.waitForElementToBeDisplay(getInputPackStaging());
        clickOnElement(getInputPackStaging());
    }

    public void checkInputPacking() {
        Waiters.waitForElementToBeDisplay(getInputPacking());
        clickOnElement(getInputPacking());
    }

    public void checkInputPick() {
        Waiters.waitForElementToBeDisplay(getInputPick());
        clickOnElement(getInputPick());
    }

    public void checkInputPickFromReserve() {
        Waiters.waitForElementToBeDisplay(getInputPickFromReserve());
        clickOnElement(getInputPickFromReserve());
    }

    public void checkInputPutaway() {
        Waiters.waitForElementToBeDisplay(getInputPutaway());
        clickOnElement(getInputPutaway());
    }

    public void checkInputReplenishment() {
        Waiters.waitForElementToBeDisplay(getInputReplenishment());
        clickOnElement(getInputReplenishment());
    }

    public void checkInputShipping() {
        Waiters.waitForElementToBeDisplay(getInputShipping());
        clickOnElement(getInputShipping());
    }

    public void checkInputShortChasing() {
        Waiters.waitForElementToBeDisplay(getInputShortChasing());
        clickOnElement(getInputShortChasing());
    }

    public void checkInputTopOff() {
        Waiters.waitForElementToBeDisplay(getInputTopOff());
        clickOnElement(getInputTopOff());
    }

    public void checkInputWavePick() {
        Waiters.waitForElementToBeDisplay(getInputWavePick());
        clickOnElement(getInputWavePick());
    }

    public void checkInputCount() {
        Waiters.waitForElementToBeDisplay(getInputCount());
        clickOnElement(getInputCount());
    }

    public void checkInputDee() {
        Waiters.waitForElementToBeDisplay(getInputDee());
        clickOnElement(getInputDee());
    }

    public void checkInputDefault() {
        Waiters.waitForElementToBeDisplay(getInputDefault());
        clickOnElement(getInputDefault());
    }

    public void checkInputLoad() {
        Waiters.waitForElementToBeDisplay(getInputLoad());
        clickOnElement(getInputLoad());
    }

    public void checkInputNeedsLoc() {
        Waiters.waitForElementToBeDisplay(getInputNeedsLoc());
        clickOnElement(getInputNeedsLoc());
    }

    public void checkInputPalChill() {
        Waiters.waitForElementToBeDisplay(getInputPalChill());
        clickOnElement(getInputPalChill());
    }

    public void checkInputPalDry() {
        Waiters.waitForElementToBeDisplay(getInputPalDry());
        clickOnElement(getInputPalDry());
    }

    public void checkInputPalFrz() {
        Waiters.waitForElementToBeDisplay(getInputPalFrz());
        clickOnElement(getInputPalFrz());
    }

    public void checkInputPickChill() {
        Waiters.waitForElementToBeDisplay(getInputPickChill());
        clickOnElement(getInputPickChill());
    }

    public void checkInputPickDry() {
        Waiters.waitForElementToBeDisplay(getInputPickDry());
        clickOnElement(getInputPickDry());
    }

    public void checkInputPickFrz() {
        Waiters.waitForElementToBeDisplay(getInputPickFrz());
        clickOnElement(getInputPickFrz());
    }

    public void checkInputReplen() {
        Waiters.waitForElementToBeDisplay(getInputReplen());
        clickOnElement(getInputReplen());
    }

    public void checkInputShort() {
        Waiters.waitForElementToBeDisplay(getInputShort());
        clickOnElement(getInputShort());
    }

    public void checkInputTestcode() {
        Waiters.waitForElementToBeDisplay(getInputTestcode());
        clickOnElement(getInputTestcode());
    }

    public void checkInputWpBrpMed() {
        Waiters.waitForElementToBeDisplay(getInputWpBrpMed());
        clickOnElement(getInputWpBrpMed());
    }

    public boolean isTaskListTitleDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTaskListTitle());
    }

    public boolean isTypesDropdownDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTypesDropdown());
    }

    public boolean isTaskGroupDropdownDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTaskGroupDropdown());
    }

    public boolean isAddFilterButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAddFilterButton());
    }

    public boolean isEditButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditTaskButton());
    }

    public boolean isDeleteButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDeleteTaskButton());
    }

    public boolean isTopOffTaskButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTopOffTaskButton());
    }

    public boolean isMoveTaskButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getMoveTaskButton());
    }

    public boolean isReprocessTaskButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getReprocessTaskButton());
    }

    public boolean isSearchInputWorkQueueTaskDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSearchInputWorkQueueTask());
    }

    public boolean isWorkQueueTasksToolTipDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getWorkQueueTasksToolTip());
    }

    public boolean isProductColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getProductColumn());
    }

    public boolean isQtyColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getQtyColumn());
    }

    public boolean isFromColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getFromColumn());
    }

    public boolean isToColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getToColumn());
    }

    public boolean isTypeColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTypeColumn());
    }

    public boolean isTaskGroupColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTaskGroupColumn());
    }

    public boolean isStatusColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getStatusColumn());
    }

    public boolean isAssignmentNumColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAssignmentNumColumn());
    }

    public boolean isPriorityColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getPriorityColumn());
    }

    public boolean isRouteColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteColumn());
    }

    public boolean isStopColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getStopColumn());
    }

    public boolean isShipperColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getShipperColumn());
    }

    public boolean isVelocityColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getVelocityColumn());
    }

    public boolean isDescriptionColumnDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDescriptionColumn());
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(itemsFoundLabel);
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(itemsFoundValue);
    }

    public boolean isTasksSelectedItemsCountNumberDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTasksItemsCountNumber());
    }

    public boolean isTasksSelectedItemsFoundDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTasksSelectedItemsFound());
    }

    public boolean isTasksSelectedCountNumberDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTasksSelectedCountNumber());
    }

    public boolean isProductFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getProductFilter());
    }

    public boolean isStrQtyFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getStrQtyFilter());
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

    public boolean isTaskGroupFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTaskGroupFilter());
    }

    public boolean isStatusFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getStatusFilter());
    }

    public boolean isAssignmentNumberFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAssignmentNumberFilter());
    }

    public boolean isPriorityFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getPriorityFilter());
    }

    public boolean isRouteFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRouteFilter());
    }

    public boolean isStopFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getStopFilter());
    }

    public boolean isShipperFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getShipperFilter());
    }

    public boolean isVelocityFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getVelocityFilter());
    }

    public boolean isDescriptionFilterDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDescriptionFilter());
    }

    public String getItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundValue);
    }

    public String getSelectedItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(tasksSelectedItemsFound);
    }

    public String getSelectedItemsFoundNumber() {
        Waiters.waitABit(1000);
        return getText(tasksSelectedCountNumber);
    }

    public WebElement getTaskListTitle() { return findWebElement(taskListTitle); }

    public WebElement getTypesDropdown() { return findWebElement(typesDropDown); }

    public WebElement getTaskGroupDropdown() { return findWebElement(taskGroupDropDown); }

    public WebElement getWorkQueueTasksToolTip() { return findWebElement(workQueueTasksToolTip); }

    public WebElement getEditTaskButton() { return findWebElement(editTaskBtn); }

    public WebElement getDeleteTaskButton() { return findWebElement(deleteTaskBtn); }

    public WebElement getTopOffTaskButton() { return findWebElement(topOffTaskButton); }

    public WebElement getMoveTaskButton() { return findWebElement(moveTaskBtn); }

    public WebElement getReprocessTaskButton() { return findWebElement(reprocessTaskBtn); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getSearchInputWorkQueueTask() { return findWebElement(searchInputWorkQueueTask); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getItemsFoundValue() { return findWebElement(itemsFoundValue); }

    public WebElement getProductColumn() { return findWebElement(productColumn); }

    public WebElement getQtyColumn() { return findWebElement(qtyColumn); }

    public WebElement getFromColumn() { return findWebElement(fromColumn); }

    public WebElement getToColumn() { return findWebElement(toColumn); }

    public WebElement getTypeColumn() { return findWebElement(typeColumn); }

    public WebElement getTaskGroupColumn() { return findWebElement(taskGroupColumn); }

    public WebElement getStatusColumn() { return findWebElement(statusColumn); }

    public WebElement getAssignmentNumColumn() { return findWebElement(assignmentNumColumn); }

    public WebElement getPriorityColumn() { return findWebElement(priorityColumn); }

    public WebElement getRouteColumn() { return findWebElement(routeColumn); }

    public WebElement getStopColumn() { return findWebElement(stopColumn); }

    public WebElement getShipperColumn() { return findWebElement(shipperColumn); }

    public WebElement getVelocityColumn() { return findWebElement(velocityColumn); }

    public WebElement getDescriptionColumn() { return findWebElement(descriptionColumn); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public WebElement getTasksSelectedItemsFound() { return findWebElement(tasksSelectedItemsFound); }

    public WebElement getTasksSelectedCountNumber() { return findWebElement(tasksSelectedCountNumber); }

    public WebElement getTasksItemsCountNumber() { return findWebElement(tasksItemsCountNumber); }

    public WebElement getProductFilter() { return findWebElement(productFilter); }

    public WebElement getStrQtyFilter() { return findWebElement(strQtyFilter); }

    public WebElement getFromFilter() { return findWebElement(fromFilter); }

    public WebElement getToFilter() { return findWebElement(toFilter); }

    public WebElement getTypeFilter() { return findWebElement(typeFilter); }

    public WebElement getTaskGroupFilter() { return findWebElement(taskGroupFilter); }

    public WebElement getStatusFilter() { return findWebElement(statusFilter); }

    public WebElement getAssignmentNumberFilter() { return findWebElement(assignmentNumberFilter); }

    public WebElement getPriorityFilter() { return findWebElement(priorityFilter); }

    public WebElement getRouteFilter() { return findWebElement(routeFilter); }

    public WebElement getStopFilter() { return findWebElement(stopFilter); }

    public WebElement getShipperFilter() { return findWebElement(shipperFilter); }

    public WebElement getVelocityFilter() { return findWebElement(velocityFilter); }

    public WebElement getDescriptionFilter() { return findWebElement(descriptionFilter); }

    public WebElement getClearAllButton() { return findWebElement(clearAllButton); }

    public WebElement getInputContains() { return findWebElement(inputContains); }

    public WebElement getApplyButton() { return findWebElement(applyButton); }

    public WebElement getInputCheckIn() { return findWebElement(inputCheckIn); }

    public WebElement getInputCycleCount() { return findWebElement(inputCycleCount); }

    public WebElement getInputLetdown() { return findWebElement(inputLetdown); }

    public WebElement getInputLoadCountAudit() { return findWebElement(inputLoadCountAudit); }

    public WebElement getInputLoading() { return findWebElement(inputLoading); }

    public WebElement getInputMovement() { return findWebElement(inputMovement); }

    public WebElement getInputOpportunisticCount() { return findWebElement(inputOpportunisticCount); }

    public WebElement getInputPackStaging() { return findWebElement(inputPackStaging); }

    public WebElement getInputPacking() { return findWebElement(inputPacking); }

    public WebElement getInputPick() { return findWebElement(inputPick); }

    public WebElement getInputPickFromReserve() { return findWebElement(inputPickFromReserve); }

    public WebElement getInputPutaway() { return findWebElement(inputPutaway); }

    public WebElement getInputReplenishment() { return findWebElement(inputReplenishment); }

    public WebElement getInputShipping() { return findWebElement(inputShipping); }

    public WebElement getInputShortChasing() { return findWebElement(inputShortChasing); }

    public WebElement getInputTopOff() { return findWebElement(inputTopOff); }

    public WebElement getInputWavePick() { return findWebElement(inputWavePick); }

    public WebElement getInputCount() { return findWebElement(inputCount); }

    public WebElement getInputDee() { return findWebElement(inputDee); }

    public WebElement getInputDefault() { return findWebElement(inputDefault); }

    public WebElement getInputLoad() { return findWebElement(inputLoad); }

    public WebElement getInputNeedsLoc() { return findWebElement(inputNeedsLoc); }

    public WebElement getInputPalChill() { return findWebElement(inputPalChill); }

    public WebElement getInputPalDry() { return findWebElement(inputPalDry); }

    public WebElement getInputPalFrz() { return findWebElement(inputPalFrz); }

    public WebElement getInputPickChill() { return findWebElement(inputPickChill); }

    public WebElement getInputPickDry() { return findWebElement(inputPickDry); }

    public WebElement getInputPickFrz() { return findWebElement(inputPickFrz); }

    public WebElement getInputReplen() { return findWebElement(inputReplen); }

    public WebElement getInputShort() { return findWebElement(inputShort); }

    public WebElement getInputTestcode() { return findWebElement(inputTestcode); }

    public WebElement getInputWpBrpMed() { return findWebElement(inputWpBrpMed); }

}
