package ui.pages.outbound.processing;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.stream.Collectors;

import static common.setup.DriverManager.getDriver;

public class ChangeViewParametersPage extends BasePage {
    By pageTitle = By.cssSelector(".k-window-title");
    By sourceLabel = By.cssSelector("#accountDropdown-label");
    By accountDropdown = By.cssSelector("#accountDropdown");
    By sourceValue = By.cssSelector("#txtCode");
    By orderLabel = By.cssSelector("#txtorderNumber-label");
    By orderInput = By.cssSelector("#txtorderNumber");
    By orderTypeLabel = By.cssSelector("#orderTypeDropDown-label");
    By orderTypeDropDown = By.cssSelector("#orderTypeDropDown");
    By carrierCodeInput = By.cssSelector("#carrierCodeDropdown-label");
    By carrierCodeDropdown = By.cssSelector("#carrierCodeDropdown");
    By ownerLabel = By.cssSelector("#ownerDropdown-label");
    By ownerDropdown = By.cssSelector("#ownerDropdown");
    By productLabel = By.xpath("//label[text()='Product']");
    By productInput = By.xpath("//input[@placeholder='Search product']");
    By order2Label = By.cssSelector("#txtOrder2-label");
    By order2Input = By.cssSelector("#txtOrder2");
    By order3Label = By.cssSelector("#txtOrder3-label");
    By order3Input = By.cssSelector("#txtOrder3");
    By order4Label = By.cssSelector("#txtOrder4-label");
    By order4Input = By.cssSelector("#txtOrder4");
    By order5Label = By.cssSelector("#txtOrder5-label");
    By order5Input = By.cssSelector("#txtOrder5");
    By lotLabel = By.cssSelector("#txtLot-label");
    By lotInput = By.cssSelector("#txtLot");
    By startDateLabel = By.cssSelector("#StartDate-label");
    By startDate = By.cssSelector("#StartDate");
    By endDateLabel = By.cssSelector("#EndDate-label");
    By endDate = By.cssSelector("#EndDate");
    By okButton = By.xpath("//button[contains(text(), 'OK')]");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By loader = By.cssSelector(".loader");

    public void waitChangeViewParametersPageToLoad() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getPageTitle());
        Waiters.waitForElementToBeDisplay(getSourceLabel());
    }

    public String getStartDateValue() {
        return getValue(By.cssSelector("#StartDate"));
    }

    public String getEndDateValue() {
        return getValue(By.cssSelector("#EndDate"));
    }

    public String getTitle() {
        Waiters.waitForElementToBeDisplay(getPageTitle());
        return getText(By.cssSelector(".k-window-title"));
    }

    public String getOkButtonAttribute() {
        Waiters.waitForElementToBeDisplay(getOkButton());
        return getElementAttribute(getOkButton(), "class");
    }

    public String getSourceFieldText() {
        Waiters.waitForElementToBeDisplay(getAccountDropdown());
        return getText(By.cssSelector("#accountDropdown"));
    }

    public String getOrderNoText() {
        Waiters.waitForElementToBeDisplay(getOrderInput());
        return getValue(By.cssSelector("#txtorderNumber"));
    }

    public void typeAccountCode(String accountCode) {
        Waiters.waitForElementToBeDisplay(getSourceValue());
        enterText(getSourceValue(), accountCode);
    }

    public void typeOrder(String orderNum) {
        Waiters.waitForElementToBeDisplay(getOrderInput());
        enterText(getOrderInput(), orderNum);
    }

    public void clearOrder() {
        Waiters.waitForElementToBeDisplay(getOrderInput());
        clear(getOrderInput());
    }

    public void selectStartDate(String date) {
        waitUntilInvisible(1, loader);
        waitUntilStalenessOf(1, getStartDate());
        doubleClick(getStartDate());
        pressDelete(getStartDate());
        waitUntilStalenessOf(1, getStartDate());
        inputText(getStartDate(), date);
        Waiters.waitABit(2000);
        pressTab(getStartDate());
    }

    public void selectEndDate(String date) {
        waitUntilInvisible(1, loader);
        waitUntilStalenessOf(1, getEndDate());
        doubleClick(getEndDate());
        pressDelete(getEndDate());
        waitUntilStalenessOf(1, getEndDate());
        inputText(getEndDate(), date);
        Waiters.waitABit(2000);
        pressTab(getEndDate());
    }

    public void clickOKbutton() {
        Waiters.waitForElementToBeDisplay(getOkButton());
        clickOnElement(getOkButton());
        Waiters.waitABit(2000);
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeDisplay(getCancelButton());
        clickOnElement(getCancelButton());
        Waiters.waitABit(2000);
    }

    public void clickSourceButton() {
        Waiters.waitForElementToBeClickable(getAccountDropdown());
        Waiters.waitABit(2000);
        clickOnElement(getAccountDropdown());
    }

    public void enterCode(String code) {
        Waiters.waitForElementToBeDisplay(getSourceValue());
        enterText(getSourceValue(), code);
    }

    public String getSourceValues() {
       return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]"))
                .stream()
                .map(option -> option.getText().trim())
                .collect(Collectors.joining("\\n"));
    }

    public void selectAccount(String source) {
        clickOnElement(getAccountDropdown());
        Waiters.waitABit(1000);
        WebElement option = findWebElement(By.xpath("//*[text()='" + source + "']"));
        clickOnElement(option);
    }

    public boolean isPageTitleDisplayed() {
        return isElementDisplay(pageTitle);
    }

    public boolean isSourceLabelDisplayed() {
        return isElementDisplay(getSourceLabel());
    }

    public boolean isAccountDropdownDisplayed() {
        return isElementDisplay(getAccountDropdown());
    }

    public boolean isSourceValueDisplayed() {
        return isElementDisplay(getSourceValue());
    }

    public boolean isOrderLabelDisplayed() {
        return isElementDisplay(orderLabel);
    }

    public boolean isOrderInputDisplayed() {
        return isElementDisplay(orderInput);
    }

    public boolean isOrderTypeLabelDisplayed() {
        return isElementDisplay(orderTypeLabel);
    }

    public boolean isOrderTypeDropDownDisplayed() {
        return isElementDisplay(orderTypeDropDown);
    }

    public boolean isCarrierCodeInputDisplayed() {
        return isElementDisplay(carrierCodeInput);
    }

    public boolean isCarrierCodeDropdownDisplayed() {
        return isElementDisplay(carrierCodeDropdown);
    }

    public boolean isOwnerLabelDisplayed() {
        return isElementDisplay(ownerLabel);
    }

    public boolean isOwnerDropdownDisplayed() {
        return isElementDisplay(ownerDropdown);
    }

    public boolean isProductLabelPopupDisplayed() {
        return isElementDisplay(productLabel);
    }

    public boolean isProductInputDisplayed() {
        return isElementDisplay(productInput);
    }

    public boolean isOrder2LabelDisplayed() {
        return isElementDisplay(order2Label);
    }

    public boolean isOrder2InputDisplayed() {
        return isElementDisplay(order2Input);
    }

    public boolean isOrder3LabelDisplayed() {
        return isElementDisplay(order3Label);
    }

    public boolean isOrder3InputDisplayed() {
        return isElementDisplay(order3Input);
    }

    public boolean isOrder4LabelDisplayed() {
        return isElementDisplay(order4Label);
    }

    public boolean isOrder4InputDisplayed() {
        return isElementDisplay(order4Input);
    }

    public boolean isOrder5LabelDisplayed() {
        return isElementDisplay(order5Label);
    }

    public boolean isOrder5InputDisplayed() {
        return isElementDisplay(order5Input);
    }

    public boolean isLotLabelDisplayed() {
        return isElementDisplay(lotLabel);
    }

    public boolean isLotInputDisplayed() {
        return isElementDisplay(lotInput);
    }

    public boolean isStartDateLabelDisplayed() {
        return isElementDisplay(startDateLabel);
    }

    public boolean isStartDateDisplayed() { return isElementDisplay(startDate); }

    public boolean isEndDateLabelDisplayed() {
        return isElementDisplay(endDateLabel);
    }

    public boolean isEndDateDisplayed() {
        return isElementDisplay(endDate);
    }

    public boolean isOkButtonDisplayed() {
        return isElementDisplay(okButton);
    }

    public boolean isCancelButtonDisplayed() {
        return isElementDisplay(cancelButton);
    }

    public WebElement getPageTitle() {
        return findWebElement(pageTitle);
    }

    public WebElement getSourceLabel() {
        return findWebElement(sourceLabel);
    }

    public WebElement getAccountDropdown() {
        return findWebElement(accountDropdown);
    }

    public WebElement getSourceValue() { return findWebElement(sourceValue); }

    public WebElement getOrderLabel() {
        return findWebElement(orderLabel);
    }

    public WebElement getOrderInput() {
        return findWebElement(orderInput);
    }

    public WebElement getOrderTypeLabel() {
        return findWebElement(orderTypeLabel);
    }

    public WebElement getOrderTypeDropDown() {
        return findWebElement(orderTypeDropDown);
    }

    public WebElement getCarrierCodeInput() {
        return findWebElement(carrierCodeInput);
    }

    public WebElement getCarrierCodeDropdown() {
        return findWebElement(carrierCodeDropdown);
    }

    public WebElement getOwnerLabel() {
        return findWebElement(ownerLabel);
    }

    public WebElement getOwnerDropdown() {
        return findWebElement(ownerDropdown);
    }

    public WebElement getProductLabel() {
        return findWebElement(productLabel);
    }

    public WebElement getProductInput() {
        return findWebElement(productInput);
    }

    public WebElement getOrder2Label() {
        return findWebElement(order2Label);
    }

    public WebElement getOrder2Input() {
        return findWebElement(order2Input);
    }

    public WebElement getOrder3Label() {
        return findWebElement(order3Label);
    }

    public WebElement getOrder3Input() {
        return findWebElement(order3Input);
    }

    public WebElement getOrder4Label() {
        return findWebElement(order4Label);
    }

    public WebElement getOrder4Input() {
        return findWebElement(order4Input);
    }

    public WebElement getOrder5Label() {
        return findWebElement(order5Label);
    }

    public WebElement getOrder5Input() {
        return findWebElement(order5Input);
    }

    public WebElement getLotLabel() {
        return findWebElement(lotLabel);
    }

    public WebElement getLotInput() {
        return findWebElement(lotInput);
    }

    public WebElement getStartDateLabel() {
        return findWebElement(startDateLabel);
    }

    public WebElement getStartDate() { return findWebElement(startDate); }

    public WebElement getEndDateLabel() {
        return findWebElement(endDateLabel);
    }

    public WebElement getEndDate() {
        return findWebElement(endDate);
    }

    public WebElement getOkButton() {
        return findWebElement(okButton);
    }

    public WebElement getCancelButton() {
        return findWebElement(cancelButton);
    }

}
