package ui.pages.workqueue.workassign;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

public class WorkQueueWorkAssignPage extends BasePage {
    By taskGroupTitle = By.xpath("//span[contains(text(), 'Task group')]");
    By taskGroupDropdown = By.id("wqListTaskGroup");
    By addFilterButton = By.xpath("//span[contains(text(), 'Add filter')]");
    By assignWorkUserForm = By.id("assignWorkUserForm");
    By saveEditButton = By.id("saveEditButton");
    By cancelEditButton = By.id("cancelEditButton");
    By wmUserHeader = By.id("wmUserHeader");
    By wmUserGrpHeader = By.id("wmUserGrpHeader");
    By wqUserFormDivUserList = By.xpath("//div[@id='wqUserFormDivUser']//div[contains(@class, 'i-btn-checkbox')]");
    By wqUserFormDivUserGroupList = By.xpath("//div[@id='wqUserFormDivUserGroup']//div[contains(@class, 'i-btn-checkbox')]");
    By notificationMsg = By.cssSelector(".toast-message");
    By userGroupCheckbox  = By.id("Description");
    By adminUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'A')]");
    By buyersUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'B')]");
    By defaultUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'D')]");
    By freezerUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'F')]");
    By managersUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'M')]");
    By operatorsUserGroup = By.xpath("//div[contains(@class,'i-btn-checkbox')]//span[contains(text(), 'O')]");
    By clearAllButton = By.xpath("//button[text()='Clear all']");
    By dropdownList = By.id("dropdownList");

    private WebElement getUserByUserName(String name) {
        return findWebElement(By.xpath("//label[contains(text(), '" + name + "')]//preceding-sibling::input[@type='checkbox']"));
    }

    public WebElement getTaskGroupDropdownValue(String taskGroup) {
        return findWebElement(By.xpath("//span[contains(text(), '" + taskGroup + "')]"));
    }

    public void waitWorkQueueWorkAssignPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitABit(6000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getTaskGroupTitle());
        Waiters.waitForElementToBeDisplay(getSaveEditButton());
        Waiters.waitForElementToBeDisplay(getCancelEditButton());
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickOnTaskGroup() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getTaskGroupDropdown());
        clickOnElement(getTaskGroupDropdown());
    }

    public void selectTaskGroup(String option) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getTaskGroupDropdown());
        clickOnElement(getTaskGroupDropdown());
        WebElement taskGroupOption = findWebElement(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@class='k-item' and contains(text(), '"
                + option + "')]"));
        clickOnElement(taskGroupOption);
        Waiters.waitABit(2000);
    }

    public void clickSaveEditButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getTaskGroupDropdown());
        clickOnElement(getSaveEditButton());
    }

    public void clickCancelEditButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getCancelEditButton());
        clickOnElement(getCancelEditButton());
    }

    public void clickFilterButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getAddFilterButton());
        clickOnElement(getAddFilterButton());
    }

    public void clickUserGroupCheckbox() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(userGroupCheckbox);
        clickOnElement(userGroupCheckbox);
    }

    public void clickClearAllButton() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getClearAllButton());
        clickOnElement(getClearAllButton());
    }

    public void checkUserByName(String name) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getUserByUserName(name));
        clickOnElement(getUserByUserName(name));
    }

    public void checkAdminUserGroup() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(adminUserGroup);
        clickOnElement(adminUserGroup);
    }

    public void checkBuyersUserGroup() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(buyersUserGroup);
        clickOnElement(buyersUserGroup);
    }

    public void checkDefaultUserGroup() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(defaultUserGroup);
        clickOnElement(defaultUserGroup);
    }

    public void checkFreezerUserGroup() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(freezerUserGroup);
        clickOnElement(freezerUserGroup);
    }

    public void checkManagersUserGroup() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(managersUserGroup);
        clickOnElement(managersUserGroup);
    }

    public void checkOperatorsUserGroup() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(operatorsUserGroup);
        clickOnElement(operatorsUserGroup);
    }

    public boolean isTaskGroupTitleDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTaskGroupTitle());
    }

    public boolean isTaskGroupDropdownDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTaskGroupDropdown());
    }

    public boolean isAddFilterButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAddFilterButton());
    }

    public boolean isAssignWorkUserFormDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getAssignWorkUserForm());
    }

    public boolean isSaveEditButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getSaveEditButton());
    }

    public boolean isCancelEditButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCancelEditButton());
    }

    public boolean isWmUserHeaderDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getWmUserHeader());
    }

    public boolean isWmUserGrpHeaderDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getWmUserGrpHeader());
    }

    public WebElement getTaskGroupTitle() { return findWebElement(taskGroupTitle); }

    public WebElement getTaskGroupDropdown() { return findWebElement(taskGroupDropdown); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getAssignWorkUserForm() { return findWebElement(assignWorkUserForm); }

    public WebElement getSaveEditButton() { return findWebElement(saveEditButton); }

    public WebElement getCancelEditButton() { return findWebElement(cancelEditButton); }

    public WebElement getWmUserHeader() { return findWebElement(wmUserHeader); }

    public WebElement getWmUserGrpHeader() { return findWebElement(wmUserGrpHeader); }

    public List<WebElement> getWqUserFormDivUserList() { return findWebElements(wqUserFormDivUserList); }

    public List<WebElement> getWqUserFormDivUserGroupList() { return findWebElements(wqUserFormDivUserGroupList); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getClearAllButton() { return findWebElement(clearAllButton); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
