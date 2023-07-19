package ui.pages.lookup.dockmanagement;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

import java.util.List;

public class DockManagementLookupPage extends BasePage {
    By dockManagementLookupTitle = By.className("spnmoduleNameHeader");
    By dateInputFilterDate = By.id("dateInputFilterDate");
    By dateInputFilterToDate = By.id("dateInputFilterToDate");
    By chkBoxShowAll = By.id("chkBoxShowAll");
    By chkBoxReceiving = By.id("chkBoxReceiving");
    By chkBoxShipping = By.id("chkBoxShipping");
    By chkBoxProduction = By.id("chkBoxProduction");
    By completeLabel = By.xpath("//span[contains(@class, 'dot--green')]/following-sibling::span[contains(text(), 'Complete')]");
    By inProgressLabel = By.xpath("//span[contains(@class, 'dot--yellow')]/following-sibling::span[contains(text(), 'In progress')]");
    By lateLabel = By.xpath("//span[contains(@class, 'dot--red')]/following-sibling::span[contains(text(), 'Late')]");
    By orderLabel = By.xpath("//span[@class='HeaderWithImage' and text()='Order']");
    By trailerLabel = By.xpath("//span[@class='HeaderWithImage' and text()='Trailer']");
    By scheduledLabel = By.xpath("//span[@class='HeaderWithImage' and text()='Scheduled']");
    By d1Label = By.xpath("//span[text()='D1']");
    By d2Label = By.xpath("//span[text()='D2']");
    By doorLabel = By.xpath("//span[text()='DOOR']");
    By door01Label = By.xpath("//span[text()='DOOR01']");
    By door02Label = By.xpath("//span[text()='DOOR02']");
    By door03Label = By.xpath("//span[text()='DOOR03']");
    By door04Label = By.xpath("//span[text()='DOOR04']");
    By door05Label = By.xpath("//span[text()='DOOR05']");
    By goldLabel = By.xpath("//span[text()='GOLD']");
    By productionLabel = By.xpath("//span[text()='PRODUCTION']");
    By td01Label = By.xpath("//span[text()='TD01']");
    By td02Label = By.xpath("//span[text()='TD02']");
    By outboundLabel = By.xpath("//span[text()='OUTBOUND']");
    By inboundLabel = By.xpath("//span[text()='INBOUND']");
    By items = By.xpath("//a[contains(text(), '+')]");
    By dockMgmtSummaryRows = By.xpath("//div[@class='col-xs-12']//div[contains(@style, 'background:') and @class='row']");
    By btnBack = By.id("btnBack");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By okButton = By.xpath("//button[contains(text(), 'OK')]");
    By ordersAssignToDoor = By.xpath("//span[text()='Orders assigned to door']");
    By notEmptyTrailer = By.xpath("//div[contains(@class, 'dockManagement_Col_2C')]//a[string-length() > 0]");
    By notEmptyScheduled = By.xpath("//div[contains(@class, 'dockManagement_Col_2D')]//a[string-length() > 0]");
    By changeTrailerPopUpTitle = By.cssSelector("div.k-dialog-title");
    By dateInputSchedDateLabel = By.id("dateInputSchedDate-label");
    By dateInputSchedDate = By.id("dateInputSchedDate");
    By timeInputFilterTimeLabel = By.id("timeInputFilterTime-label");
    By timeInputFilterTime = By.id("timeInputFilterTime");
    By ddlTrailer = By.id("ddlTrailer");
    By dropdownList = By.id("dropdownList");

    public void waitForDockManagementLookupPageToLoad() {
        Waiters.waitABit(7000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(dockManagementLookupTitle);
        Waiters.waitForElementToBeDisplay(dateInputFilterDate);
        Waiters.waitForElementToBeDisplay(dateInputFilterToDate);
        Waiters.waitForElementToBeDisplay(chkBoxShowAll);
        Waiters.waitForElementToBeDisplay(chkBoxReceiving);
        Waiters.waitForElementToBeDisplay(chkBoxShipping);
        Waiters.waitForElementToBeDisplay(chkBoxProduction);
    }

    public void clickItemByIndex(int index) {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(items);
        clickOnElement(getItems().get(index));
        Waiters.waitABit(5000);
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickDockMgmtSummaryRowsByIndex(int index) {
        Waiters.waitABit(2000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(dockMgmtSummaryRows);
        clickOnElement(getDockMgmtSummaryRows().get(index).findElement(By.xpath(".//div[contains(@class, 'outerDuckCell')]//a")));
        Waiters.waitABit(7000);
    }

    public void clickNotEmptyTrailerByIndex(int index) {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForPresenceOfAllElements(notEmptyTrailer);
        clickOnElement(getNotEmptyTrailers().get(index));
    }

    public void clickNotEmptyScheduledByIndex(int index) {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForPresenceOfAllElements(notEmptyScheduled);
        clickOnElement(getNotEmptyScheduled().get(index));
    }

    public void clickBackButton() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(btnBack);
        clickOnElement(btnBack);
        Waiters.waitABit(7000);
    }

    public void clickCancelButton() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(cancelButton);
        clickOnElement(cancelButton);
        Waiters.waitABit(7000);
    }

    public void clickOKButton() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(okButton);
        clickOnElement(okButton);
        Waiters.waitABit(7000);
    }

    public void typeSchedDate(String date) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDateInputSchedDate());
        clickOnElement(getDateInputSchedDate());
        pressDelete(getDateInputSchedDate());
        inputText(getDateInputSchedDate(), date);
        pressEnter(getDateInputSchedDate());
        Waiters.waitABit(7000);
    }

    public void selectDDlTrailer(CharSequence trailer) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDDlTrailer());
        clickOnElement(getDDlTrailer());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                        + trailer + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public boolean isDateInputFilterDisplayed() { return isElementDisplay(dateInputFilterDate); }

    public boolean isDateToInputFilterDisplayed() { return isElementDisplay(dateInputFilterToDate); }

    public boolean isChkBoxShowAllDisplayed() { return isElementDisplay(chkBoxShowAll); }

    public boolean isChkBoxReceivingDisplayed() { return isElementDisplay(chkBoxReceiving); }

    public boolean isChkBoxShippingDisplayed() { return isElementDisplay(chkBoxShipping); }

    public boolean isChkBoxProductionDisplayed() { return isElementDisplay(chkBoxProduction); }

    public boolean isCompleteLabelDisplayed() { return isElementDisplay(completeLabel); }

    public boolean isInProgressLabelDisplayed() { return isElementDisplay(inProgressLabel); }

    public boolean isLateLabelDisplayed() { return isElementDisplay(lateLabel);}

    public boolean isOrderLabelDisplayed() { return isElementDisplay(orderLabel); }

    public boolean isTrailerLabelDisplayed() { return isElementDisplay(trailerLabel); }

    public boolean isScheduledLabelDisplayed() { return isElementDisplay(scheduledLabel);}

    public boolean isD1LabelDisplayed() { return isElementDisplay(d1Label); }

    public boolean isD2LabelDisplayed() { return isElementDisplay(d2Label); }

    public boolean isDoorLabelDisplayed() { return isElementDisplay(doorLabel); }

    public boolean isDoor01LabelDisplayed() { return isElementDisplay(door01Label); }

    public boolean isDoor02LabelDisplayed() { return isElementDisplay(door02Label); }

    public boolean isDoor03LabelDisplayed() { return isElementDisplay(door03Label); }

    public boolean isDoor04LabelDisplayed() { return isElementDisplay(door04Label); }

    public boolean isDoor05LabelDisplayed() { return isElementDisplay(door05Label); }

    public boolean isGoldLabelDisplayed() { return isElementDisplay(goldLabel); }

    public boolean isProductionLabelDisplayed() { return isElementDisplay(productionLabel); }

    public boolean isTd01LabelDisplayed() { return isElementDisplay(td01Label); }

    public boolean isTd02LabelDisplayed() { return isElementDisplay(td02Label); }

    public int areOutboundLabelsPresent() { return elementsArePresent(getOutboundLabels()); }

    public int areInboundLabelsPresent() { return elementsArePresent(getInboundLabels()); }

    public int areItemsPresent() { return elementsArePresent(getItems()); }

    public int areDockMgmtSummaryRowsPresent() { return elementsArePresent(getDockMgmtSummaryRows()); }

    public boolean isButtonBackDisplayed() { return isElementDisplay(btnBack); }

    public boolean isOrdersAssignToDoorLabelDisplayed() { return isElementDisplay(ordersAssignToDoor); }

    public boolean isСhangeTrailerPopUpTitleDisplayed() { return isElementDisplay(getСhangeTrailerPopUpTitle()); }

    public boolean isDateInputSchedDateLabelDisplayed() { return isElementDisplay(getDateInputSchedDateLabel()); }

    public boolean isInputSchedDateDisplayed() { return isElementDisplay(getDateInputSchedDate()); }

    public boolean isInputFilterTimeLabelDisplayed() { return isElementDisplay(getTimeInputFilterTimeLabel()); }

    public boolean isInputFilterTimeDisplayed() { return isElementDisplay(getTimeInputFilterTime()); }

    public String isReceivingChkDisabled() { return getElementAttribute(getChkBoxReceiving(), "disabled"); }

    public String checkElementReceivingChk() { return checkElementAttribute(getChkBoxReceiving(), "disabled"); }

    public String isShippingChkDisabled() { return getElementAttribute(getChkBoxShipping(), "disabled"); }

    public String checkElementShippingChk() { return checkElementAttribute(getChkBoxShipping(), "disabled"); }

    public String isProductionChkDisabled() { return getElementAttribute(getChkBoxProduction(), "disabled"); }

    public String checkElementProductionChk() { return checkElementAttribute(getChkBoxProduction(), "disabled"); }

    public void typeDockMgmtStartDate(String date) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDateInputFilterDate());
        clickOnElement(getDateInputFilterDate());
        pressDelete(getDateInputFilterDate());
        inputText(getDateInputFilterDate(), date);
        pressEnter(getDateInputFilterDate());
        Waiters.waitABit(7000);
    }

    public void typeDockMgmtToDate(String date) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDateInputFilterToDate());
        clickOnElement(getDateInputFilterToDate());
        pressDelete(getDateInputFilterToDate());
        inputText(getDateInputFilterToDate(), date);
        pressEnter(getDateInputFilterToDate());
        Waiters.waitABit(4000);
    }

    public void clickSelectAll() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(chkBoxShowAll);
        clickOnElement(chkBoxShowAll);
        Waiters.waitABit(6000);
    }

    public void clickReceiving() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(chkBoxReceiving);
        clickOnElement(chkBoxReceiving);
        Waiters.waitABit(6000);
    }

    public void clickShipping() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(chkBoxShipping);
        clickOnElement(chkBoxShipping);
        Waiters.waitABit(6000);
    }

    public void clickProduction() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(chkBoxProduction);
        clickOnElement(chkBoxProduction);
        Waiters.waitABit(6000);
    }

    public String getСhangeTrailerPopUpTitleText() {
        Waiters.waitABit(2000);
        return getText(changeTrailerPopUpTitle);
    }

    public WebElement getDockManagementLookupTitle() { return findWebElement(dockManagementLookupTitle); }

    public WebElement getDateInputFilterDate() { return findWebElement(dateInputFilterDate); }

    public WebElement getDateInputFilterToDate() { return findWebElement(dateInputFilterToDate); }

    public WebElement getChkBoxShowAll() { return findWebElement(chkBoxShowAll); }

    public WebElement getChkBoxReceiving() { return findWebElement(chkBoxReceiving); }

    public WebElement getChkBoxShipping() { return findWebElement(chkBoxShipping); }

    public WebElement getChkBoxProduction() { return findWebElement(chkBoxProduction); }

    public WebElement getCompleteLabel() { return findWebElement(completeLabel); }

    public WebElement getInProgressLabel() { return findWebElement(inProgressLabel); }

    public WebElement getLateLabel() { return findWebElement(lateLabel); }

    public WebElement getOrderLabel() { return findWebElement(orderLabel); }

    public WebElement getTrailerLabel() { return findWebElement(trailerLabel); }

    public WebElement getScheduledLabel() { return findWebElement(scheduledLabel); }

    public WebElement getD1Label() { return findWebElement(d1Label); }

    public WebElement getD2Label() { return findWebElement(d2Label); }

    public WebElement getDoorLabel() { return findWebElement(doorLabel); }

    public WebElement getDoor01Label() { return findWebElement(door01Label); }

    public WebElement getDoor02Label() { return findWebElement(door02Label); }

    public WebElement getDoor03Label() { return findWebElement(door03Label); }

    public WebElement getDoor04Label() { return findWebElement(door04Label); }

    public WebElement getDoor05Label() { return findWebElement(door05Label); }

    public WebElement getGoldLabel() { return findWebElement(goldLabel); }

    public WebElement getProductionLabel() { return findWebElement(productionLabel); }

    public WebElement getTd01Label() { return findWebElement(td01Label); }

    public WebElement getTd02Label() { return findWebElement(td02Label); }

    public List<WebElement> getOutboundLabels() { return findWebElements(outboundLabel); }

    public List<WebElement> getInboundLabels() { return findWebElements(inboundLabel); }

    public List<WebElement> getItems() { return findWebElements(items); }

    public List<WebElement> getDockMgmtSummaryRows() { return findWebElements(dockMgmtSummaryRows); }

    public WebElement getBtnBack() { return findWebElement(btnBack); }

    public List<WebElement> getNotEmptyTrailers() { return findWebElements(notEmptyTrailer); }

    public List<WebElement> getNotEmptyScheduled() { return findWebElements(notEmptyScheduled); }

    public WebElement getСhangeTrailerPopUpTitle() { return findWebElement(changeTrailerPopUpTitle); }

    public WebElement getDateInputSchedDateLabel() { return findWebElement(dateInputSchedDateLabel); }

    public WebElement getDateInputSchedDate() { return findWebElement(dateInputSchedDate); }

    public WebElement getTimeInputFilterTimeLabel() { return findWebElement(timeInputFilterTimeLabel); }

    public WebElement getTimeInputFilterTime() { return findWebElement(timeInputFilterTime); }

    public WebElement getDDlTrailer() { return findWebElement(ddlTrailer); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
