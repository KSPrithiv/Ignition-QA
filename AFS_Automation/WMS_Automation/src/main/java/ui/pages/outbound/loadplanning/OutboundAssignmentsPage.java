package ui.pages.outbound.loadplanning;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;
import java.util.stream.Collectors;

public class OutboundAssignmentsPage extends BasePage {
    By assignmentsTitle = By.className("spnmoduleNameHeader");
    By editAssignmentBtn = By.cssSelector("#EditAssignmentButton");
    By deleteAssignmentBtn = By.cssSelector("#deleteAssignmetButton");
    By releaseAssignmentBtn = By.cssSelector("#ReleaseAssignmentButton");
    By printAssignmentBtn = By.cssSelector("#PrintAssignmentButton");
    By moveAssignmentBtn = By.cssSelector("#moveTaskButton");
    By assignmentTypeDropDown = By.xpath("//span[contains(text(), 'Assignment type:')]");
    By taskGroupDropDown = By.xpath("//span[contains(text(), 'Task group:')]");
    By statusesDropDown = By.xpath("//span[contains(text(), 'Status:')]");
    By addFilterButton = By.cssSelector(".i-filter-tag__main__text--add");
    By searchInput = By.id("AssignmentGridSearch_loadPlanner_loadPlanner");
    By tableContent = By.className("k-grid-table");
    By rows = By.cssSelector(".k-grid-table .k-master-row");
    By checkBoxes = By.cssSelector(".k-grid-table .k-master-row input");
    By assignments = By.xpath("//td[contains(@id, 'assignmentlink')]/a");
    By backButton = By.id("backAssignmentBtn");
    By itemsCount = By.cssSelector(".i-summary-area__main__value");
    By itemsFound = By.cssSelector(".i-summary-area__main__label");

    public void waitOutboundOrderSummaryPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getAssignmentsTitle());
        Waiters.waitForElementToBeDisplay(getTableContent());
    }

    public boolean isEditAssignmentBtnDisplayed() { return isElementDisplay(getEditAssignmentBtn()); }

    public boolean isDeleteAssignmentBtnDisplayed() { return isElementDisplay(getDeleteAssignmentBtn()); }

    public boolean isReleaseAssignmentBtnDisplayed() { return isElementDisplay(getReleaseAssignmentBtn()); }

    public boolean isPrintAssignmentBtnDisplayed() { return isElementDisplay(getPrintAssignmentBtn()); }

    public boolean isMoveAssignmentBtnDisplayed() { return isElementDisplay(getMoveAssignmentBtn()); }

    public boolean isAssignmentTypeDropDownDisplayed() { return isElementDisplay(getAssignmentTypeDropDown()); }

    public boolean isTaskGroupDropDownDisplayed() { return isElementDisplay(getTaskGroupDropDown()); }

    public boolean isStatusesDropDownDisplayed() { return isElementDisplay(getStatusesDropDown()); }

    public boolean isAddFilterButtonDisplayed() { return isElementDisplay(getAddFilterButton()); }

    public boolean isSearchInputDisplayed() { return isElementDisplay(getSearchInput()); }

    public int verifyRowsDisplayed() { return elementsArePresent(getRows()); }

    public int verifyCheckBoxesDisplayed() { return elementsArePresent(getCheckBoxes()); }

    public boolean isItemsCountDisplayed() { return isElementDisplay(getItemsCount()); }

    public boolean isBackButtonDisplayed() { return isElementDisplay(getBackButton()); }

    public String getAssignmentTitleText() {
        Waiters.waitForElementToBeDisplay(getAssignmentsTitle());
        return getText(getAssignmentsTitle());
    }

    public String getAssignmentNumber(int index) {
        Waiters.waitForElementsToBeDisplay(getAssignments().get(index));
        return getText(getAssignments().get(index));
    }

    public List<String> getAssignmentsNumbers() {
        return getAssignments().stream()
               .map(assignment -> assignment.getText().trim())
               .collect(Collectors.toList());
    }

    public void clickBackButton() {
        Waiters.waitForElementToBeDisplay(getBackButton());
        clickOnElement(getBackButton());
    }

    public void checkAssignment(int assignment) {
        Waiters.waitForAllElementsToBeDisplay(getCheckBoxes().get(getCheckBoxes().size()-1));
        clickOnElement(getCheckBoxes().get(assignment));
    }

    public WebElement getAssignmentsTitle() { return findWebElement(assignmentsTitle); }

    public WebElement getEditAssignmentBtn() { return findWebElement(editAssignmentBtn); }

    public WebElement getDeleteAssignmentBtn() { return findWebElement(deleteAssignmentBtn); }

    public WebElement getReleaseAssignmentBtn() { return findWebElement(releaseAssignmentBtn); }

    public WebElement getPrintAssignmentBtn() { return findWebElement(printAssignmentBtn); }

    public WebElement getMoveAssignmentBtn() { return findWebElement(moveAssignmentBtn); }

    public WebElement getAssignmentTypeDropDown() { return findWebElement(assignmentTypeDropDown); }

    public WebElement getTaskGroupDropDown() { return findWebElement(taskGroupDropDown); }

    public WebElement getStatusesDropDown() { return findWebElement(statusesDropDown); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getSearchInput() { return findWebElement(searchInput); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public List<WebElement> getRows() { return findWebElements(rows); }

    public List<WebElement> getCheckBoxes() { return findWebElements(checkBoxes); }

    public List<WebElement> getAssignments() { return findWebElements(assignments); }

    public WebElement getBackButton() { return findWebElement(backButton); }

    public WebElement getItemsCount() { return findWebElement(itemsCount); }

    public WebElement getItemsFound() { return findWebElement(itemsFound); }
}
