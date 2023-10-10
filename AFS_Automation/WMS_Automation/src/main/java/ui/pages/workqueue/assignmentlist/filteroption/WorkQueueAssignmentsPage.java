package ui.pages.workqueue.assignmentlist.filteroption;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

public class WorkQueueAssignmentsPage extends BasePage {
    By assignmentsTitle = By.className("spnmoduleNameHeader");
    By editAssignmentBtn = By.cssSelector("#EditAssignmentButton");
    By deleteAssignmentBtn = By.cssSelector("#deleteAssignmetButton");
    By releaseAssignmentBtn = By.cssSelector("#ReleaseAssignmentButton");
    By printAssignmentBtn = By.cssSelector("#PrintAssignmentButton");
    By moveAssignmentBtn = By.cssSelector("#moveTaskButton");
    By addFilterButton = By.cssSelector(".i-filter-tag__main__text--add");
    By assignmentGridSearch = By.cssSelector("#AssignmentGridSearch_self_WorkQueue");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
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
    By clearAllButton = By.xpath("//button[text()='Clear all']");
    By inputContains = By.xpath("//input[@placeholder='Contains']");
   // By inputContains = By.xpath("//input[@placeholder='Contains']");
    By applyButton = By.xpath("//button[text()='Apply']");
    By inputSearch = By.xpath("//input[@placeholder='Search']");
    By notStartedStatus = By.id("Not Started");
    By inProgressStatus = By.id("In Progress");
    By inActiveStatus = By.id("In Active");
    By completedStatus = By.id("Completed");
    By inputCount = By.xpath("//input[contains(@id, 'COUNT')]");
    By inputDee = By.xpath("//input[contains(@id, 'DEE')]");
    By inputDefault = By.xpath("//input[contains(@id, 'DEFAULT')]");
    By inputLoad = By.xpath("//input[contains(@id, 'LOAD')]");
    By inputNeedsLoc = By.xpath("//input[contains(@id, 'NEEDS LOC')]");
    By assignmentTypeCount = By.xpath("//input[contains(@id, 'Count')]");
    By assignmentTypeCrossDockPallet = By.xpath("//input[contains(@id, 'Crossdock Pallet')]");
    By assignmentTypeDynamic = By.xpath("//input[contains(@id, 'Dynamic')]");
    By assignmentTypePickCooler = By.xpath("//input[contains(@id, 'Pick Cooler')]");
    By assignmentTypePickDry = By.xpath("//input[contains(@id, 'Pick Dry')]");
    By assignmentTypePickFreezer = By.xpath("//input[contains(@id, 'Pick Freezer')]");
    By assignmentTypePick = By.xpath("//input[contains(@id, 'Pick')]");
    By assignmentTypePickDoNotSplit = By.xpath("//input[contains(@id, 'Pick Do Not Split')]");
    By assignmentTypePickFullPallets = By.xpath("//input[contains(@id, 'Pick Full Pallets')]");
    By isEmptyButton = By.cssSelector("#textRadioButton2");
    By editAssignmentType = By.cssSelector("#wqListAssignmentType");
    By editAssignmentTaskGroup = By.cssSelector("#wqListTaskGroup");
    By editAssignmentEditDate = By.cssSelector("#wqAssignmentEditDate");
    By editAssignmentEditTime = By.cssSelector("#wqAssignmentEditTime");
    By editAssignmentUsers = By.cssSelector("#wqListAssignmentUsers");
    By editAssignmentComplete = By.cssSelector("#WorkQueueAssignmentsEditComplete");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By okButton = By.xpath("//button[contains(text(), 'OK')]");
    By tableContent = By.xpath("//table[@class='k-grid-table']");
    By notificationMessage = By.cssSelector(".toast-message");
    By dialogTextContent = By.id("dialogTextContent");
    By releaseDate = By.id("InvoiceDate");
    By releaseTime = By.id("timeInput2");
    By releaseLabel = By.xpath("//label[text()='Release']");
    By assignLabel = By.xpath("//label[text()='Assign']");
    By releaseUsersLabel = By.id("wqListAssignmentUsers-label");
    By dialogPopup = By.cssSelector(".k-dialog-title");
    By clearRelease = By.xpath("//div[contains(@aria-labelledby, 'dialog-title')]//button[contains(@class, 'i-button--icon-only')]");
    By editTask = By.cssSelector("#editTaskButton");
    By deleteAssignment = By.cssSelector("#deleteAssignmetButton");
    By assignmentsTab = By.xpath("//ul[@role='tablist']//span[text()='Assignments']");
    By laborEstimateTab = By.xpath("//ul[@role='tablist']//span[text()='Labor estimate']");
    By laborActualTab = By.xpath("//ul[@role='tablist']//span[text()='Labor actual']");
    By assignmentNumberColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Assignment #']]");
    By assignmentNumberColumn = By.xpath("//span[text()='Assignment #']");
    By routeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Route']]");
    By routeColumn = By.xpath("//span[text()='Route']");
    By stopsColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Stops']]");
    By stopsColumn = By.xpath("//span[text()='Stops']");
    By shipperColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Shipper']]");
    By shipperColumn = By.xpath("//span[text()='Shipper']");
    By shipToColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Ship to']]");
    By shipToColumn = By.xpath("//span[text()='Ship to']");
    By tasksColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Tasks']]");
    By tasksColumn = By.xpath("//span[text()='Tasks']");
    By assignToColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Assign to']]");
    By assignToColumn = By.xpath("//span[text()='Assign to']");
    By releasedColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Released']]");
    By releasedColumn = By.xpath("//span[text()='Released']");
    By qtyColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Qty']]");
    By qtyColumn = By.xpath("//span[text()='Qty']");
    By cubeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Cube']]");
    By cubeColumn = By.xpath("//span[text()='Cube']");
    By weightColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Weight']]");
    By weightColumn = By.xpath("//span[text()='Weight']");
    By assignmentTypeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Assignment type']]");
    By assignmentTypeColumn = By.xpath("//span[text()='Assignment type']");
    By taskGroupColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Task group']]");
    By taskGroupColumn = By.xpath("//span[text()='Task group']");
    By pickedColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='%picked']]");
    By pickedColumn = By.xpath("//span[text()='%picked']");
    By btnClose = By.id("btnWQClose");

    public void waitWorkQueueAssignmentsPageToLoad() {
        Waiters.waitABit(7000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getAssignmentsTitle());
        Waiters.waitForElementToBeDisplay(editAssignmentBtn);
        Waiters.waitForElementToBeDisplay(deleteAssignmentBtn);
        Waiters.waitForElementToBeDisplay(releaseAssignmentBtn);
        Waiters.waitForElementToBeDisplay(printAssignmentBtn);
        Waiters.waitForElementToBeDisplay(moveAssignmentBtn);
        Waiters.waitForElementToBeDisplay(addFilterButton);
        Waiters.waitForElementToBeDisplay(assignmentGridSearch);
    }

    public void clickAssignmentsTitle() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentsTitle);
        clickOnElement(assignmentsTitle);
    }

    public void findValuesInSearch(String text) {
        Waiters.waitForElementToBeDisplay(assignmentGridSearch);
        inputText(getAssignmentGridSearch(), text);
        pressEnter(getAssignmentGridSearch());
    }

    public void cleanTextFromInput() {
        Waiters.waitForElementToBeDisplay(assignmentGridSearch);
        clearText(getAssignmentGridSearch());
    }

    public void typeFilter(String filter) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getInputContains());
        inputText(getInputContains(), filter);
    }

    public void typeSearch(String filter) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getInputSearch());
        inputText(getInputSearch(), filter);
    }

    public void clickIsEmptyButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(isEmptyButton);
        clickOnElement(isEmptyButton);
    }

    public void clickNotStartedStatus() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(notStartedStatus);
        clickOnElement(notStartedStatus);
    }

    public void clickInProgressStatus() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(inProgressStatus);
        clickOnElement(inProgressStatus);
    }

    public void clickInActiveStatus() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(inActiveStatus);
        clickOnElement(inActiveStatus);
    }

    public void clickCompletedStatus() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(completedStatus);
        clickOnElement(completedStatus);
    }

    public void clickInputCount() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(inputCount);
        clickOnElement(inputCount);
    }

    public void clickInputDee() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(inputDee);
        clickOnElement(inputDee);
    }

    public void clickInputDefault() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(inputDefault);
        clickOnElement(inputDefault);
    }

    public void clickInputLoad() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(inputLoad);
        clickOnElement(inputLoad);
    }

    public void clickInputNeedsLoc() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(inputNeedsLoc);
        clickOnElement(inputNeedsLoc);
    }

    public void clickAssignmentTypeCount() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentTypeCount);
        clickOnElement(assignmentTypeCount);
    }

    public void clickAssignmentTypeCrossDockPallet() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentTypeCrossDockPallet);
        clickOnElement(assignmentTypeCrossDockPallet);
    }

    public void clickAssignmentTypeDynamic() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentTypeDynamic);
        clickOnElement(assignmentTypeDynamic);
    }

    public void clickAssignmentTypePickCooler() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentTypePickCooler);
        clickOnElement(assignmentTypePickCooler);
    }

    public void clickAssignmentTypePickDry() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentTypePickDry);
        clickOnElement(assignmentTypePickDry);
    }

    public void clickAssignmentTypePickFreezer() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentTypePickFreezer);
        clickOnElement(assignmentTypePickFreezer);
    }

    public void clickAssignmentTypePick() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentTypePick);
        clickOnElement(assignmentTypePick);
    }

    public void clickAssignmentTypePickDoNotSplit() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentTypePickDoNotSplit);
        clickOnElement(assignmentTypePickDoNotSplit);
    }

    public void clickAssignmentTypePickFullPallets() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(assignmentTypePickFullPallets);
        clickOnElement(assignmentTypePickFullPallets);
    }

    public void selectAssignmentType(String text) {
        clickOnElement(editAssignmentType);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + text + "') and @role='option']")));
        Waiters.waitABit(1000);
    }

    public void selectAssignmentTaskGroup(String text) {
        clickOnElement(editAssignmentTaskGroup);
        List<WebElement> tasks = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li"));
        System.out.println(tasks.get(0).getText());
        System.out.println(tasks.get(1).getText());
        System.out.println(tasks.get(2).getText());
        WebElement task = tasks.stream()
                .filter(el -> el.getText().trim().contains(text))
                .findFirst().orElseThrow(() -> new RuntimeException("Task is not found"));
        clickOnElement(task);
        Waiters.waitABit(1000);
    }

    public void selectAssignmentUser(String text) {
        clickOnElement(editAssignmentUsers);
        Waiters.waitABit(3000);
        List<WebElement> users = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li"));
        WebElement user = users.stream()
                .filter(el -> el.getText().trim().contains(text))
                .findFirst().orElseThrow(() -> new RuntimeException("User is not found"));
        clickOnElement(user);
        Waiters.waitABit(1000);
    }

    public void enterDate(String dayNum) {
        WebElement toggle = findWebElement(By.xpath("//div[./input[@id='wqAssignmentEditDate']]//following-sibling::a"));
        Waiters.waitForElementToBeClickable(toggle);
        clickOnElement(toggle);
        Waiters.waitABit(2000);
        List<WebElement> days = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//td[@aria-selected='false']//span"));
        WebElement day = days.stream()
                .filter(el -> el.getText().trim().equals(dayNum))
                .findFirst().orElseThrow(() -> new RuntimeException("Date is not found"));
        clickOnElement(day);
        Waiters.waitABit(1000);
    }

    public void enterTime(String time) {
        WebElement timeInput = findWebElement(By.cssSelector("#wqAssignmentEditTime"));
        click(timeInput);
        pressLeftArrow(timeInput);
        pressLeftArrow(timeInput);
        pressLeftArrow(timeInput);
        pressLeftArrow(timeInput);
        Waiters.waitABit(2000);
        inputText(timeInput, time.split(":")[0]);
        pressRightArrow(timeInput);
        Waiters.waitABit(2000);
        inputText(timeInput, time.split(":")[1]);
        pressTab(timeInput);
    }

    public void enterReleaseDate(String dayNum) {
        WebElement toggle = findWebElement(By.cssSelector("a[title='Toggle calendar']"));
        Waiters.waitForElementToBeClickable(toggle);
        clickOnElement(toggle);
        Waiters.waitABit(2000);
        List<WebElement> days = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//td[@aria-selected='false']//span"));
        WebElement day = days.stream()
                .filter(el -> el.getText().trim().equals(dayNum))
                .findFirst().orElseThrow(() -> new RuntimeException("Date is not found"));
        clickOnElement(day);
        Waiters.waitABit(1000);
    }

    public void enterReleaseTime(String time) {
        WebElement assignmentsTime = findWebElement(releaseTime);
        click(findWebElement(releaseTime));
        pressLeftArrow(assignmentsTime);
        pressLeftArrow(assignmentsTime);
        pressLeftArrow(assignmentsTime);
        pressLeftArrow(assignmentsTime);
        Waiters.waitABit(2000);
        inputText(assignmentsTime, time.split(":")[0]);
        pressRightArrow(assignmentsTime);
        Waiters.waitABit(2000);
        inputText(assignmentsTime, time.split(":")[1]);
        pressTab(assignmentsTime);
    }

    public void enterFromDate(String dayNum) {
        List<WebElement> toggles = findWebElements(By.cssSelector("a[title='Toggle calendar']"));
        Waiters.waitForElementToBeClickable(toggles.get(0));
        clickOnElement(toggles.get(0));
        Waiters.waitABit(2000);
        List<WebElement> days = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//td[@aria-selected='false']//span"));
        WebElement day = days.stream()
                        .filter(el -> el.getText().trim().equals(dayNum))
                        .findFirst().orElseThrow(() -> new RuntimeException("From Date is not found"));
        clickOnElement(day);
    }

    public void enterTillDate(String dayNum) {
        List<WebElement> toggles = findWebElements(By.cssSelector("a[title='Toggle calendar']"));
        Waiters.waitForElementToBeClickable(toggles.get(1));
        clickOnElement(toggles.get(1));
        Waiters.waitABit(2000);
        List<WebElement> days = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//td[@aria-selected='false']//span"));
        WebElement day = days.stream()
                .filter(el -> el.getText().trim().equals(dayNum))
                .findFirst().orElseThrow(() -> new RuntimeException("Till Date is not found"));
        clickOnElement(day);
    }

    public void clickClearAllButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getСlearAllButton());
        clickOnElement(getСlearAllButton());
    }

    public void clickCloseBtn() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(btnClose);
        clickOnElement(btnClose);
    }

    public void clickApplyButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getApplyButton());
        clickOnElement(getApplyButton());
    }

    public void clickAddFilter() {
        Waiters.waitForElementToBeDisplay(addFilterButton);
        clickOnElement(addFilterButton);
    }

    public void clickSaveButton() {
        Waiters.waitForElementToBeDisplay(saveButton);
        clickOnElement(saveButton);
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeDisplay(cancelButton);
        clickOnElement(cancelButton);
    }

    public void checkAssignmentByAssignmentIndex(int index) {
        Waiters.waitABit(5000);
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> assignments = getTableContent().findElements(By.xpath(".//tbody//tr[contains(@class, 'k-master-row')]"));
        Waiters.waitABit(1000);
        clickOnElement(assignments.get(index).findElement(By.xpath(".//input[@type='checkbox']")));
    }

    public void clickAssignmentByAssignmentIndex(int index) {
        Waiters.waitABit(5000);
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> assignments = getTableContent().findElements(By.xpath(".//tbody//tr[contains(@class, 'k-master-row')]"));
        Waiters.waitABit(1000);
        clickOnElement(assignments.get(index).findElement(By.xpath(".//td[contains(@id, 'assignmentlink')]")));
        Waiters.waitABit(5000);
    }

    public void clickEditAssignment() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentBtn());
        clickOnElement(getEditAssignmentBtn());
    }

    public void clickDeleteAssignment() {
        Waiters.waitForElementToBeDisplay(getDeleteAssignmentBtn());
        clickOnElement(getDeleteAssignmentBtn());
    }

    public void clickReleaseAssignment() {
        Waiters.waitForElementToBeDisplay(getReleaseAssignmentBtn());
        clickOnElement(getReleaseAssignmentBtn());
    }

    public void clickPrintAssignment() {
        Waiters.waitForElementToBeDisplay(getPrintAssignmentBtn());
        clickOnElement(getPrintAssignmentBtn());
    }

    public void clickMoveAssignment() {
        Waiters.waitForElementToBeDisplay(getMoveAssignmentBtn());
        clickOnElement(getMoveAssignmentBtn());
    }

    public void checkAssignmentCodeFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getAssignmentCodeFilter());
        clickOnElement(getAssignmentCodeFilter());
    }

    public void checkRouteFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getRouteFilter());
        clickOnElement(getRouteFilter());
    }

    public void checkStopsFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getStopsFilter());
        clickOnElement(getStopsFilter());
    }

    public void checkShipperFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getShipperFilter());
        clickOnElement(getShipperFilter());
    }

    public void checkShipToFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getShipToFilter());
        clickOnElement(getShipToFilter());
    }

    public void checkTasksFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getTasksFilter());
        clickOnElement(getTasksFilter());
    }

    public void checkAssignToFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getAssignToFilter());
        clickOnElement(getAssignToFilter());
    }

    public void checkReleasedFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getReleasedFilter());
        clickOnElement(getReleasedFilter());
        Waiters.waitABit(2000);
    }

    public void checkQtyFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getQtyFilter());
        clickOnElement(getQtyFilter());
    }

    public void checkCubeFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getCubeFilter());
        clickOnElement(getCubeFilter());
    }

    public void checkWeightFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getWeightFilter());
        clickOnElement(getWeightFilter());
    }

    public void checkAssignmentTypeFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getAssignmentTypeFilter());
        clickOnElement(getAssignmentTypeFilter());
        Waiters.waitABit(8000);
    }

    public void checkTaskGroupFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getTaskGroupFilter());
        clickOnElement(getTaskGroupFilter());
    }

    public void checkPercentPickedFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getPercentPickedFilter());
        clickOnElement(getPercentPickedFilter());
    }

    public void checkInUseByFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getInUseByFilter());
        clickOnElement(getInUseByFilter());
    }

    public void checkEstimatedTimeFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getEstimatedTimeFilter());
        clickOnElement(getEstimatedTimeFilter());
    }

    public void checkStandardTimeFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getStandardTimeFilter());
        clickOnElement(getStandardTimeFilter());
    }

    public void checkActualTimeFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getActualTimeFilter());
        clickOnElement(getActualTimeFilter());
    }

    public void checkActivityIndicatorFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getActivityIndicatorFilter());
        clickOnElement(getActivityIndicatorFilter());
    }

    public void checkRemainingFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getRemainingFilter());
        clickOnElement(getRemainingFilter());
    }

    public void checkPrintedFilterCheckBox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getPrintedFilter());
        clickOnElement(getPrintedFilter());
    }

    public void clickClearRelease() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getClearRelease());
        clickOnElement(getClearRelease());
    }

    public boolean isAssignmentsTitleDisplayed() {
        Waiters.waitForElementToBeDisplay(getAssignmentsTitle());
        return isElementDisplay(getAssignmentsTitle());
    }

    public boolean isEditAssignmentBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditAssignmentBtn());
        return isElementDisplay(getEditAssignmentBtn());
    }

    public boolean isDeleteAssignmentBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getDeleteAssignmentBtn());
        return isElementDisplay(getDeleteAssignmentBtn());
    }

    public boolean isReleaseAssignmentBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getReleaseAssignmentBtn());
        return isElementDisplay(getReleaseAssignmentBtn());
    }

    public boolean isPrintAssignmentBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getPrintAssignmentBtn());
        return isElementDisplay(getPrintAssignmentBtn());
    }

    public boolean isMoveAssignmentBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getMoveAssignmentBtn());
        return isElementDisplay(getMoveAssignmentBtn());
    }

    public boolean isAddFilterButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getAddFilterButton());
        return isElementDisplay(getAddFilterButton());
    }

    public boolean isAssignmentGridSearchDisplayed() {
        Waiters.waitForElementToBeDisplay(getAssignmentGridSearch());
        return isElementDisplay(getAssignmentGridSearch());
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

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getItemsFoundLabel());
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getItemsFoundValue());
    }

    public String getItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundValue);
    }

    public boolean isCubeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getCubeFilter());
        return isElementDisplay(getCubeFilter());
    }

    public boolean isWeightFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getWeightFilter());
        return isElementDisplay(getWeightFilter());
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

    public boolean isActualTimeFilterDisplayed() {
        Waiters.waitForElementToBeDisplay(getActualTimeFilter());
        return isElementDisplay(getActualTimeFilter());
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
        Waiters.waitABit(2000);
        return isElementDisplay(getEditAssignmentType());
    }

    public boolean isEditAssignmentTaskGroupDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditAssignmentTaskGroup());
    }

    public boolean isEditAssignmentDateDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditAssignmentEditDate());
    }

    public boolean isEditAssignmentTimeDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditAssignmentEditTime());
    }

    public boolean isEditAssignmentUsersDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditAssignmentUsers());
    }

    public boolean isEditAssignmentCompleteDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getEditAssignmentEditComplete());
    }

    public boolean isSaveButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(saveButton);
        return isElementDisplay(saveButton);
    }

    public boolean isCancelButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(cancelButton);
        return isElementDisplay(cancelButton);
    }

    public boolean isOkButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(okButton);
        return isElementDisplay(okButton);
    }

    public boolean isReleaseDateDisplayed() {
        Waiters.waitForElementToBeDisplay(getReleaseDate());
        return isElementDisplay(getReleaseDate());
    }

    public boolean isReleaseTimeDisplayed() {
        Waiters.waitForElementToBeDisplay(getReleaseTime());
        return isElementDisplay(getReleaseTime());
    }

    public boolean isReleaseLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getReleaseLabel());
        return isElementDisplay(getReleaseLabel());
    }

    public boolean isAssignLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getAssignLabel());
        return isElementDisplay(getAssignLabel());
    }

    public boolean isReleaseUsersLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getReleaseUsersLabel());
        return isElementDisplay(getReleaseUsersLabel());
    }

    public boolean isEditTaskButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getEditTaskButton());
        return isElementDisplay(getEditTaskButton());
    }

    public boolean isDeleteAssignmentButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getDeleteAssignmentButton());
        return isElementDisplay(getDeleteAssignmentButton());
    }

    public boolean isAssignmentsTabDisplayed() {
        Waiters.waitForElementToBeDisplay(getAssignmentsTab());
        return isElementDisplay(getAssignmentsTab());
    }

    public boolean isLaborEstimateTabDisplayed() {
        Waiters.waitForElementToBeDisplay(getLaborEstimateTab());
        return isElementDisplay(getLaborEstimateTab());
    }

    public boolean isLaborActualTabDisplayed() {
        Waiters.waitForElementToBeDisplay(getLaborActualTab());
        return isElementDisplay(getLaborActualTab());
    }

    public String getDialogPopupText() {
        Waiters.waitForElementToBeDisplay(getDialogPopup());
        return getDialogPopup().getText().trim();
    }

    public String getNotificationMessageText() {
        Waiters.waitForElementToBeDisplay(By.cssSelector(".toast-message"));
        return getNotificationMessage().getText().trim();
    }

    public String getEditAssignmentDateValue() {
        Waiters.waitForElementToBeDisplay(editAssignmentEditDate);
        return getValue(editAssignmentEditDate);
    }

    public String getEditAssignmentTimeValue() {
        Waiters.waitForElementToBeDisplay(editAssignmentEditTime);
        return getValue(editAssignmentEditTime);
    }

    public String getDialogTextContentText() {
        Waiters.waitForElementToBeDisplay(getDialogTextContent());
        return getText(getDialogTextContent());
    }

    public String getReleaseDateValue() {
        Waiters.waitABit(2_000);
        Waiters.waitForElementToBeDisplay(releaseDate);
        return getValue(releaseDate);
    }

    public String getReleaseTimeValue() {
        Waiters.waitABit(2_000);
        Waiters.waitForElementToBeDisplay(releaseTime);
        return getValue(releaseTime);
    }

    public String getAssignmentNumberColumnHeaderSortingResult() {
        return getElementAttribute(getAssignmentNumberColumnHeader(), "aria-sort");
    }

    public String getRouteColumnHeaderSortingResult() {
        return getElementAttribute(getRouteColumnHeader(), "aria-sort");
    }

    public String getStopsColumnHeaderSortingResult() {
        return getElementAttribute(getStopsColumnHeader(), "aria-sort");
    }

    public String getShipperColumnHeaderSortingResult() {
        return getElementAttribute(getShipperColumnHeader(), "aria-sort");
    }

    public String getShipToColumnHeaderSortingResult() {
        return getElementAttribute(getShipToColumnHeader(), "aria-sort");
    }

    public String getTasksColumnHeaderSortingResult() {
        return getElementAttribute(getTasksColumnHeader(), "aria-sort");
    }

    public String getAssignToColumnHeaderSortingResult() {
        return getElementAttribute(getAssignToColumnHeader(), "aria-sort");
    }

    public String getReleasedColumnHeaderSortingResult() {
        return getElementAttribute(getReleasedColumnHeader(), "aria-sort");
    }

    public String getQtyColumnHeaderSortingResult() {
        return getElementAttribute(getQtyColumnHeader(), "aria-sort");
    }

    public String getCubeColumnHeaderSortingResult() {
        return getElementAttribute(getCubeColumnHeader(), "aria-sort");
    }

    public String getWeightColumnHeaderSortingResult() {
        return getElementAttribute(getWeightColumnHeader(), "aria-sort");
    }

    public String getAssignmentTypeColumnHeaderSortingResult() {
        return getElementAttribute(getAssignmentTypeColumnHeader(), "aria-sort");
    }

    public String getTaskGroupColumnHeaderSortingResult() {
        return getElementAttribute(getTaskGroupColumnHeader(), "aria-sort");
    }

    public String getPickedColumnHeaderSortingResult() {
        return getElementAttribute(getPickedColumnHeader(), "aria-sort");
    }

    public void clickAssignmentNumberColumnHeader() {
        Waiters.waitForElementToBeDisplay(assignmentNumberColumnHeader);
        clickOnElement(assignmentNumberColumnHeader);
    }

    public void clickRouteColumnHeader() {
        Waiters.waitForElementToBeDisplay(routeColumnHeader);
        clickOnElement(routeColumnHeader);
    }

    public void clickStopsColumnHeader() {
        Waiters.waitForElementToBeDisplay(stopsColumnHeader);
        clickOnElement(stopsColumnHeader);
    }

    public void clickShipperColumnHeader() {
        Waiters.waitForElementToBeDisplay(shipperColumnHeader);
        clickOnElement(shipperColumnHeader);
    }

    public void clickShipToColumnHeader() {
        Waiters.waitForElementToBeDisplay(shipToColumnHeader);
        clickOnElement(shipToColumnHeader);
    }

    public void clickTasksColumnHeader() {
        Waiters.waitForElementToBeDisplay(tasksColumnHeader);
        clickOnElement(tasksColumnHeader);
    }

    public void clickAssignToColumnHeader() {
        Waiters.waitForElementToBeDisplay(assignToColumnHeader);
        clickOnElement(assignToColumnHeader);
    }

    public void clickReleasedColumnHeader() {
        Waiters.waitForElementToBeDisplay(releasedColumnHeader);
        clickOnElement(releasedColumnHeader);
    }

    public void clickQtyColumnHeader() {
        Waiters.waitForElementToBeDisplay(qtyColumnHeader);
        clickOnElement(qtyColumnHeader);
    }

    public void clickCubeColumnHeader() {
        Waiters.waitForElementToBeDisplay(cubeColumnHeader);
        clickOnElement(cubeColumnHeader);
    }

    public void clickWeightColumnHeader() {
        Waiters.waitForElementToBeDisplay(weightColumnHeader);
        clickOnElement(weightColumnHeader);
    }

    public void clickAssignmentTypeColumnHeader() {
        Waiters.waitForElementToBeDisplay(assignmentTypeColumnHeader);
        clickOnElement(assignmentTypeColumnHeader);
    }

    public void clickTaskGroupColumnHeader() {
        Waiters.waitForElementToBeDisplay(taskGroupColumnHeader);
        clickOnElement(taskGroupColumnHeader);
    }

    public void clickPickedColumnHeader() {
        Waiters.waitForElementToBeDisplay(pickedColumnHeader);
        clickOnElement(pickedColumnHeader);
    }

    public WebElement getNotificationMessage() { return findWebElement(notificationMessage); }

    public WebElement getAssignmentsTitle() { return findWebElement(assignmentsTitle); }

    public WebElement getEditAssignmentBtn() { return findWebElement(editAssignmentBtn); }

    public WebElement getDeleteAssignmentBtn() { return findWebElement(deleteAssignmentBtn); }

    public WebElement getReleaseAssignmentBtn() { return findWebElement(releaseAssignmentBtn); }

    public WebElement getPrintAssignmentBtn() { return findWebElement(printAssignmentBtn); }

    public WebElement getMoveAssignmentBtn() { return findWebElement(moveAssignmentBtn); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getAssignmentGridSearch() { return findWebElement(assignmentGridSearch); }

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

    public WebElement getСlearAllButton() { return findWebElement(clearAllButton); }

    public WebElement getInputContains() { return findWebElement(inputContains); }

    public WebElement getApplyButton() { return findWebElement(applyButton); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getItemsFoundValue() { return findWebElement(itemsFoundValue); }

    public WebElement getInputSearch() { return findWebElement(inputSearch); }

    public WebElement getInputCount() { return findWebElement(inputCount); }

    public WebElement getInputDee() { return findWebElement(inputDee); }

    public WebElement getInputDefault() { return findWebElement(inputDefault); }

    public WebElement getInputLoad() { return findWebElement(inputLoad); }

    public WebElement getInputNeedsLoc() { return findWebElement(inputNeedsLoc); }

    private WebElement getCalendarDay(String text) {
        return findWebElement(By.xpath("//div[contains(@class, 'k-calendar-container')]//*[contains(text(), '" + text + "')]"));
    }

    public WebElement getEditAssignmentType() { return findWebElement(editAssignmentType); }

    public WebElement getEditAssignmentTaskGroup() { return findWebElement(editAssignmentTaskGroup); }

    public WebElement getEditAssignmentEditDate() { return findWebElement(editAssignmentEditDate); }

    public WebElement getEditAssignmentEditTime() { return findWebElement(editAssignmentEditTime); }

    public WebElement getEditAssignmentUsers() { return findWebElement(editAssignmentUsers); }

    public WebElement getEditAssignmentEditComplete() { return findWebElement(editAssignmentComplete); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public WebElement getDialogTextContent() { return findWebElement(dialogTextContent); }

    public WebElement getReleaseDate() { return findWebElement(releaseDate); }

    public WebElement getReleaseTime() { return findWebElement(releaseTime); }

    public WebElement getReleaseLabel() { return findWebElement(releaseLabel); }

    public WebElement getAssignLabel() { return findWebElement(assignLabel); }

    public WebElement getReleaseUsersLabel() { return findWebElement(releaseUsersLabel); }

    public WebElement getDialogPopup() { return findWebElement(dialogPopup); }

    public WebElement getClearRelease() { return findWebElement(clearRelease); }

    public WebElement getEditTaskButton() { return findWebElement(editTask); }

    public WebElement getDeleteAssignmentButton() { return findWebElement(deleteAssignment); }

    public WebElement getAssignmentsTab() { return findWebElement(assignmentsTab); }

    public WebElement getLaborEstimateTab() { return findWebElement(laborEstimateTab); }

    public WebElement getLaborActualTab() { return findWebElement(laborActualTab); }

    public WebElement getAssignmentNumberColumnHeader() { return findWebElement(assignmentNumberColumnHeader); }

    public WebElement getAssignmentNumberColumn() { return findWebElement(assignmentNumberColumn); }

    public WebElement getRouteColumnHeader() { return findWebElement(routeColumnHeader); }

    public WebElement getRouteColumn() { return findWebElement(routeColumn); }

    public WebElement getStopsColumnHeader() { return findWebElement(stopsColumnHeader); }

    public WebElement getStopsColumn() { return findWebElement(stopsColumn); }

    public WebElement getShipperColumnHeader() { return findWebElement(shipperColumnHeader); }

    public WebElement getShipperColumn() { return findWebElement(shipperColumn); }

    public WebElement getShipToColumnHeader() { return findWebElement(shipToColumnHeader); }

    public WebElement getShipToColumn() { return findWebElement(shipToColumn); }

    public WebElement getTasksColumnHeader() { return findWebElement(tasksColumnHeader); }

    public WebElement getTasksColumn() { return findWebElement(tasksColumn); }

    public WebElement getAssignToColumnHeader() { return findWebElement(assignToColumnHeader); }

    public WebElement getAssignToColumn() { return findWebElement(assignToColumn); }

    public WebElement getReleasedColumnHeader() { return findWebElement(releasedColumnHeader); }

    public WebElement getReleasedColumn() { return findWebElement(releasedColumn); }

    public WebElement getQtyColumnHeader() { return findWebElement(qtyColumnHeader); }

    public WebElement getQtyColumn() { return findWebElement(qtyColumn); }

    public WebElement getCubeColumnHeader() { return findWebElement(cubeColumnHeader); }

    public WebElement getCubeColumn() { return findWebElement(cubeColumn); }

    public WebElement getWeightColumnHeader() { return findWebElement(weightColumnHeader); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getAssignmentTypeColumnHeader() { return findWebElement(assignmentTypeColumnHeader); }

    public WebElement getAssignmentTypeColumn() { return findWebElement(assignmentTypeColumn); }

    public WebElement getTaskGroupColumnHeader() { return findWebElement(taskGroupColumnHeader); }

    public WebElement getTaskGroupColumn() { return findWebElement(taskGroupColumn); }

    public WebElement getPickedColumnHeader() { return findWebElement(pickedColumnHeader); }

    public WebElement getPickedColumn() { return findWebElement(pickedColumn); }

}
