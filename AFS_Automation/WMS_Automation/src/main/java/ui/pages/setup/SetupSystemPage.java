package ui.pages.setup;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

public class SetupSystemPage extends BasePage {
    By functionLabel = By.xpath("//span[contains(text(), 'Function')]");
    By reasonLabel = By.xpath("//span[contains(text(), 'Reason')]");
    By printerLabel = By.xpath("//span[contains(text(), 'Printer')]");
    By labelFormatLabel = By.xpath("//span[contains(text(), 'Label format')]");
    By labelFileLabel = By.xpath("//span[contains(text(), 'Label file')]");
    By labelRuleLabel = By.xpath("//span[contains(text(), 'Label rule')]");
    By purgeLabel = By.xpath("//span[contains(text(), 'Purge')]");
    By registryLabel = By.xpath("//span[contains(text(), 'Registry')]");
    By permissionLabel = By.xpath("//span[contains(text(), 'Permission')]");
    By userGroupLabel = By.xpath("//span[contains(text(), 'User group')]");
    By importDataLabel = By.xpath("//span[contains(text(), 'Import data')]");
    By computerLabel = By.xpath("//span[contains(text(), 'Computer')]");
    By addSettingsButton = By.id("addSettingsButton");
    By addFilterButton = By.className("i-filter-tag__main__text--add");
    By inputContains = By.xpath("//input[@placeholder='Contains']");
    By applyButton = By.xpath("//button[text()='Apply']");
    By inputSearch = By.xpath("//input[@placeholder='Search']");
    By labelTypeColumn = By.xpath("//span[contains(text(), 'Label type')]");
    By descriptionColumn = By.xpath("//span[contains(text(), 'Description')]");
    By editSettingsButton = By.id("editSettingsButton");
    By deleteSettingsButton = By.id("deleteSettingsButton");
    By dropdownList = By.id("dropdownList");

    public void waitSetupSystemPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeDisplay(functionLabel);
        Waiters.waitForElementToBeDisplay(reasonLabel);
        Waiters.waitForElementToBeDisplay(printerLabel);
        Waiters.waitForElementToBeDisplay(labelFormatLabel);
        Waiters.waitForElementToBeDisplay(labelFileLabel);
        Waiters.waitForElementToBeDisplay(labelRuleLabel);
        Waiters.waitForElementToBeDisplay(purgeLabel);
        Waiters.waitForElementToBeDisplay(registryLabel);
        Waiters.waitForElementToBeDisplay(permissionLabel);
        Waiters.waitForElementToBeDisplay(userGroupLabel);
        Waiters.waitForElementToBeDisplay(importDataLabel);
        Waiters.waitForElementToBeDisplay(computerLabel);
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickFunctionLabel() {
        Waiters.waitForElementToBeClickable(functionLabel);
        clickOnElement(functionLabel);
    }

    public void clickReasonLabel() {
        Waiters.waitForElementToBeClickable(reasonLabel);
        clickOnElement(reasonLabel);
    }

    public void clickPrinterLabel() {
        Waiters.waitForElementToBeClickable(printerLabel);
        clickOnElement(printerLabel);
    }

    public void clickLabelFormatLabel() {
        Waiters.waitForElementToBeClickable(labelFormatLabel);
        clickOnElement(labelFormatLabel);
    }

    public void clickLabelFileLabel() {
        Waiters.waitForElementToBeClickable(labelFileLabel);
        clickOnElement(labelFileLabel);
    }

    public void clickLabelRuleLabel() {
        Waiters.waitForElementToBeClickable(labelRuleLabel);
        clickOnElement(labelRuleLabel);
    }

    public void clickPurgeLabel() {
        Waiters.waitForElementToBeClickable(purgeLabel);
        clickOnElement(purgeLabel);
    }

    public void clickRegistryLabel() {
        Waiters.waitForElementToBeClickable(registryLabel);
        clickOnElement(registryLabel);
    }

    public void clickPermissionLabel() {
        Waiters.waitForElementToBeClickable(permissionLabel);
        clickOnElement(permissionLabel);
    }

    public void clickUserGroupLabel() {
        Waiters.waitForElementToBeClickable(userGroupLabel);
        clickOnElement(userGroupLabel);
    }

    public void clickImportDataLabel() {
        Waiters.waitForElementToBeClickable(importDataLabel);
        clickOnElement(importDataLabel);
    }

    public void clickComputerLabel() {
        Waiters.waitForElementToBeClickable(computerLabel);
        clickOnElement(computerLabel);
    }

    public boolean isFunctionLabelDisplayed() { return isElementDisplay(functionLabel); }

    public boolean isReasonLabelDisplayed() { return isElementDisplay(reasonLabel); }

    public boolean isPrinterLabelDisplayed() { return isElementDisplay(printerLabel); }

    public boolean isLabelFormatLabelDisplayed() { return isElementDisplay(labelFormatLabel); }

    public boolean isLabelFileLabelDisplayed() { return isElementDisplay(labelFileLabel); }

    public boolean isLabelRuleLabelDisplayed() { return isElementDisplay(labelRuleLabel); }

    public boolean isPurgeLabelDisplayed() { return isElementDisplay(purgeLabel); }

    public boolean isRegistryLabelDisplayed() { return isElementDisplay(registryLabel); }

    public boolean isPermissionLabelDisplayed() { return isElementDisplay(permissionLabel); }

    public boolean isUserGroupLabelDisplayed() { return isElementDisplay(userGroupLabel); }

    public boolean isImportDataLabelDisplayed() { return isElementDisplay(importDataLabel); }

    public boolean isComputerLabelDisplayed() { return isElementDisplay(computerLabel); }

    public boolean isAddSettingsButton() { return isElementDisplay(addSettingsButton); }

    public boolean isEditSettingsButton() { return isElementDisplay(editSettingsButton); }

    public boolean isDeleteSettingsButton() { return isElementDisplay(deleteSettingsButton); }

    public WebElement getFunctionLabel() { return findWebElement(functionLabel); }

    public WebElement getReasonLabel() { return findWebElement(reasonLabel); }

    public WebElement getPrinterLabel() { return findWebElement(printerLabel); }

    public WebElement getLabelFormatLabel() { return findWebElement(labelFormatLabel); }

    public WebElement getLabelFileLabel() { return findWebElement(labelFileLabel); }

    public WebElement getLabelRuleLabel() { return findWebElement(labelRuleLabel); }

    public WebElement getPurgeLabel() { return findWebElement(purgeLabel); }

    public WebElement getRegistryLabel() { return findWebElement(registryLabel); }

    public WebElement getPermissionLabel() { return findWebElement(permissionLabel); }

    public WebElement getUserGroupLabel() { return findWebElement(userGroupLabel); }

    public WebElement getImportDataLabel() { return findWebElement(importDataLabel); }

    public WebElement getComputerLabel() { return findWebElement(computerLabel); }

    public WebElement getAddSettingsButton() { return findWebElement(addSettingsButton); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getInputContains() { return findWebElement(inputContains); }

    public WebElement getApplyButton() { return findWebElement(applyButton); }

    public WebElement getInputSearch() { return findWebElement(inputSearch); }

    public WebElement getLabelTypeColumn() { return findWebElement(labelTypeColumn); }

    public WebElement getDescriptionColumn() { return findWebElement(descriptionColumn); }

    public WebElement getEditSettingsButton() { return findWebElement(editSettingsButton); }

    public WebElement getDeleteSettingsButton() { return findWebElement(deleteSettingsButton); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
