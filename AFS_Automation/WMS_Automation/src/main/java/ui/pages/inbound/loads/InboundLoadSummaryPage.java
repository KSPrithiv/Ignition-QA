package ui.pages.inbound.loads;

import common.constants.TimeFormats;
import common.utils.Waiters;
import common.utils.time.TimeConversion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.Calendar;
import java.util.List;

public class InboundLoadSummaryPage extends BasePage {

    By topIcon = By.xpath("//span[contains(text(), 'Inbound load summary')]");
    By dropdownList = By.id("dropdownList");
    By cardRouteSummaryFilter = By.cssSelector("#cardRouteSummaryFilter");
    By cardRouteSummaryGrid = By.cssSelector("#divSummaryCommon");
    By dateRouteStart = By.cssSelector("#dateRouteStart");
    By dateRouteEnd = By.cssSelector("#dateRouteEnd");
    By enterLoadInput = By.cssSelector("input[placeholder='Enter load']");
    By enterSupplierInput = By.cssSelector("input[placeholder='Enter a supplier']");
    By searchSupplierButton = By.xpath("//div[@class='i-indexfield-container w__width_100per']//button");
    By enterNameInput = By.cssSelector("input[placeholder='Enter name']");
    By enterProductInput = By.cssSelector("input[placeholder='Enter a product']");
    By searchProductButton = By.cssSelector(".autocomplete_custom button.k-button-icontext");
    By loadOptionsButton = By.cssSelector("button[aria-label='Load options dropdownbutton']");
    By tableContent = By.cssSelector(".k-grid-table");
    By invalidEntryPopup = By.cssSelector(".k-window-title");
    By dialogPopup = By.cssSelector(".k-dialog-title");
    By dialogContent = By.cssSelector(".k-dialog-content");
    By dialogTextContent = By.id("dialogTextContent");
    By okButton = By.xpath("//button[contains(text(), 'OK')]");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By noButton = By.xpath("//button[contains(text(), 'No')]");
    By yesButton = By.xpath("//button[contains(text(), 'Yes')]");
    By routeBackButton = By.id("RouteBackButton");
    By clearButton = By.cssSelector("span[title=clear]");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By changeStatusOption = By.id("btnChangeStatus");
    By doorOption = By.id("ddDoorItem");
    By dataOption = By.id("ddDataItem");
    By notificationMsg = By.cssSelector(".toast-message");
    By temperatureLabel = By.xpath("//label[text()='Temperature']");
    By temperatureInput = By.xpath("//label[text()='Temperature']//following-sibling::input");
    By sealNumberLabel = By.xpath("//label[text()='Seal number']");
    By sealNumberInput = By.xpath("//label[text()='Seal number']//following-sibling::input");
    By commentsLabels = By.xpath("//label[text()='Comments']");
    By commentsInputs = By.xpath("//label[text()='Comments']//following-sibling::input");
    By yesRadioButtons = By.xpath("//label[text()='Yes']//preceding-sibling::input");
    By noRadioButtons = By.xpath("//label[text()='No']//preceding-sibling::input");
    By btnAddProductCancel = By.id("btnAddProductCancel");
    By loadCodeLabel = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Load code']]");
    By loadCodeInput = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Load code']]//input");
    By scheduledDateLabel = By.cssSelector("#cpDate-label");
    By scheduledDate = By.cssSelector("#cpDate");
    By carrierLabel = By.xpath("//label[contains(text(), 'Carrier')]");
    By carrierInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Carrier')]]//span[@class='k-input']");
    By trailerLabel = By.xpath("//label[contains(text(), 'Trailer')]");
    By trailerInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Trailer')]]//span[@class='k-input']");
    By doorLabel = By.xpath("//label[contains(text(), 'Door')]");
    By doorInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Door')]]//span[@class='k-input']");
    By loadTypeLabel = By.xpath("//label[contains(text(), 'Load type')]");
    By loadTypeInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Load type')]]//span[@class='k-input']");
    By scheduledTimeLabel = By.cssSelector("#cpTile-label");
    By scheduledTimeInput = By.cssSelector("#cpTile");
    By driverLabel = By.xpath("//label[contains(text(), 'Driver')]");
    By driverInput = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Driver']]//input");
    By temperatureField = By.xpath("//span[contains(@class,'k-textbox-container')][.//label[text()='Temperature']]//input");
    By sourceOrderTypeColumn = By.xpath("//span[text()='Order type']");
    By sourceOrderColumn = By.xpath("//span[text()='Order no.']");
    By sourceStatusColumn = By.xpath("//span[text()='Status']");
    By readyToReceiveStatus = By.cssSelector("input[value='Ready To Receive']");
    By cancelInboundStatus = By.cssSelector("input[value='Cancel Inbound']");
    By reopenOrderStatus = By.cssSelector("input[value='Reopen Order']");
    By finishReceivingOrderStatus = By.cssSelector("input[value='Finish Receiving']");
    By loadField = By.xpath("//span[contains(text(), 'Load')]");
    By orderLoadNumber = By.xpath("//span[contains(text(), 'Order')]//following-sibling::span[contains(@id, 'spnOrderNo')]");
    By ownerField = By.xpath("//span[contains(text(), 'Owner')]");
    By sourceField = By.xpath("//span[contains(text(), 'Source')]");
    By loadNumber = By.cssSelector("#spnRouteCodeNo");
    By doorField = By.xpath("//span[contains(text(), 'Door')]");
    By qaField = By.xpath("//span[contains(text(), 'QA')]");
    By trailerField = By.xpath("//span[contains(text(), 'Trailer')]");
    By carrierField = By.xpath("//span[contains(text(), 'Carrier')]");
    By ordersField = By.xpath("//span[contains(text(), 'Orders')]");
    By qtyField = By.xpath("//span[contains(text(), 'Qty')]");
    By cubeField = By.xpath("//span[contains(text(), 'Cube')]");
    By weightField = By.xpath("//span[contains(text(), 'Weight')]");
    By imagesButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Images')]");
    By commentsButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Comments')]");
    By receivedQty = By.xpath("//span[contains(@class, 'dot--green')]/following-sibling::span[contains(text(), 'Received')]");
    By stagedQty = By.xpath("//span[contains(@class, 'dot--yellow')]/following-sibling::span[contains(text(), 'Staged')]");
    By redQty = By.xpath("//span[contains(@class, 'dot--red')]/following-sibling::span[contains(text(), 'Over')]");
    By grayQty = By.xpath("//span[contains(@class, 'dot--gray')]/following-sibling::span[contains(text(), 'Remainder')]");
    By loadOrders = By.cssSelector("#crdInboundOrderPortrait .BarsBlock");
    By orderedLabel = By.xpath("//label[contains(text(), 'Ordered:')]");
    By stagedLabel = By.xpath("//label[contains(text(), 'Staged:')]");
    By receivedLabel = By.xpath("//label[contains(text(), 'Received:')]");
    By reviewLoadLabel = By.xpath("//label[contains(text(), 'Review load')]");
    By productColumn = By.xpath("//table[@role='presentation']//span[text() ='Product']");
    By descriptionColumn = By.xpath("//table[@role='presentation']//span[text() ='Description']");
    By qualifier1Column = By.xpath("//table[@role='presentation']//span[text() ='Qualifier 1']");
    By orderedColumn = By.xpath("//table[@role='presentation']//span[text() ='Ordered']");
    By stagedColumn = By.xpath("//table[@role='presentation']//span[text() ='Staged']");
    By receivedColumn = By.xpath("//table[@role='presentation']//span[text() ='Received']");
    By statusColumn = By.xpath("//table[@role='presentation']//span[text() ='Status']");
    By lotColumn = By.xpath("//table[@role='presentation']//span[text() ='Lot']");
    By expDateColumn = By.xpath("//table[@role='presentation']//span[text() ='Exp Date']");
    By dateCodeColumn = By.xpath("//table[@role='presentation']//span[text() ='Date code']");
    By weightColumn = By.xpath("//table[@role='presentation']//span[text() ='Weight']");
    By cancelBtn = By.id("btnReviewCancel");
    By saveBtn = By.id("btnReviewSave");

    private By getCarrier(String carrier) {
        return By.xpath("//span[contains(@role,'listbox')][.//span[contains(text(), '" + carrier + "')]]");
    }

    private By getStatus(String status) {
        return By.xpath("//span[@class='k-input' and text()='" + status + "']");
    }

    private By getDoorDropDown(String door) {
        return By.xpath("//span[contains(@class, 'dropdown-list')]//span[contains(text(),'" + door + "')]");
    }

    private By getLoadTypeDropDown(String loadType) {
        return By.xpath("//span[contains(text(),'" + loadType + "')]");
    }

    private By getBuyerDropDown(String buyer) {
        return By.xpath("//span[contains(text(),'" + buyer + "')]");
    }

    public void waitInboundLoadSummaryPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitABit(6000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getTopIcon());
        Waiters.waitForElementToBeDisplay(getLoadOptionsButton());
        Waiters.waitForElementToBeDisplay(getStatusDropDown("All statuses"));
    }

    public void selectLoadOption(String option) {
        Waiters.waitForElementToBeDisplay(getLoadOptionsButton());
        Waiters.waitABit(4000);
        clickOnElement(getLoadOptionsButton());
        WebElement loadedOption = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + option + "')]"));
        clickOnElement(loadedOption);
        Waiters.waitABit(1000);
    }

    public void clickLoadOptionDropDown() {
        Waiters.waitForElementToBeDisplay(getLoadOptionsButton());
        Waiters.waitABit(4000);
        clickOnElement(getLoadOptionsButton());
    }

    public void clickDoorDropdown(String door) {
        Waiters.waitABit(2000);
        clickOnElement(getDoorDropDown(door));
        Waiters.waitABit(2000);
    }

    public void clickLoadTypeDropdown(String loadType) {
        Waiters.waitABit(2000);
        clickOnElement(getLoadTypeDropDown(loadType));
        Waiters.waitABit(2000);
    }

    public void clickBuyerDropDown(String buyer) {
        Waiters.waitABit(2000);
        clickOnElement(getBuyerDropDown(buyer));
        Waiters.waitABit(2000);
    }

    public void clickLoadStatus(String status) {
        Waiters.waitABit(4000);
        clickOnElement(getStatusDropDown(status));
        Waiters.waitABit(2000);
    }

    public void selectLoadStatus(String status) {
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "')]")));
        Waiters.waitABit(2000);
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public int getRowsCount() {
        Waiters.waitForPresenceOfElement(tableContent);
        return getTableContent().findElements(By.xpath(".//tr")).size();
    }

    public void selectLoadByLoadNumber(int loadNum) {
        Waiters.waitForPresenceOfElement(tableContent);
        List<WebElement> loads = getTableContent().findElements(By.xpath(".//tr[@class='k-detail-row']"));
        Waiters.waitABit(1000);
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        Waiters.waitABit(1000);
        clickOnElement(loads.get(loadNum).findElements(By.xpath(".//input")).get(0));
    }

    public void clickLoadByLoadNumber(int loadNum) {
        Waiters.waitForPresenceOfElement(tableContent);
        List<WebElement> loads = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-detail-row')]"));
        Waiters.waitABit(1000);
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        Waiters.waitABit(1000);
        clickOnElement(loads.get(loadNum));
    }

    public void searchLoad(String load) {
        Waiters.waitForPresenceOfElement(tableContent);
        enterText(getEnterLoadInput(), load);
        pressEnter(getEnterLoadInput());
    }

    public void searchSupplierByCode(String code) {
        Waiters.waitForElementToBeDisplay(getEnterSupplierInput());
        enterText(getEnterSupplierInput(), code);
        pressEnter(getEnterSupplierInput());
    }

    public void searchSupplierByName(String name) {
        Waiters.waitForElementToBeDisplay(getEnterNameInput());
        enterText(getEnterNameInput(), name);
        pressEnter(getEnterNameInput());
    }

    public void cleanSupplierName() {
        Waiters.waitForElementToBeDisplay(getEnterNameInput());
        doubleClick(getEnterNameInput());
        pressDelete(getEnterNameInput());
        pressEnter(getEnterNameInput());
    }

    public void cleanProduct() {
        Waiters.waitABit(2000);
        clickOnElement(getClearButton());
    }

    public void cleanLoad() {
        Waiters.waitForPresenceOfElement(tableContent);
        doubleClick(getEnterLoadInput());
        pressDelete(getEnterLoadInput());
        pressEnter(getEnterLoadInput());
    }

    public String getGridTableRowContent(int row) {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeDisplay(getTableContent());
        return getText(getTableContent().findElements(By.xpath(".//tr")).get(row));
    }

    public void clickCarrierDropdown(String carrier) {
        Waiters.waitABit(4000);
        clickOnElement(getCarrierDropdown(carrier));
        Waiters.waitABit(2000);
    }

    public void clickChangeStatusOption() {
        Waiters.waitABit(4000);
        clickOnElement(getChangeStatusOption());
        Waiters.waitABit(2000);
    }

    public void clickDoorOption() {
        Waiters.waitABit(4000);
        clickOnElement(getDoorOption());
        Waiters.waitABit(2000);
    }

    public void clickDataOption() {
        Waiters.waitABit(4000);
        clickOnElement(getDataOption());
        Waiters.waitABit(2000);
    }

    public void clickDoorDropdown() {
        Waiters.waitABit(4000);
        clickOnElement(By.id("ddDoorList"));
        Waiters.waitABit(2000);
    }

    public void selectOption(String option) {
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + option + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickSave() {
        clickOnElement(saveButton);
        Waiters.waitABit(2000);
    }

    public void clickCancel() {
        clickOnElement(cancelButton);
        Waiters.waitABit(2000);
    }

    public void clickRouteBackButton() {
        clickOnElement(routeBackButton);
        Waiters.waitABit(2000);
    }

    public void clickNoButton() {
        clickOnElement(noButton);
        Waiters.waitABit(2000);
    }

    public void selectLoadByLoadRouteCode(String routeCode) {
        Waiters.waitForPresenceOfElement(tableContent);
        List<WebElement> loads = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-detail-row')]"));
        Waiters.waitABit(1000);
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        WebElement route = loads.stream()
                .filter(el -> el.getText().contains(routeCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Route with Route Code " + routeCode + " is not found"));
        clickOnElement(route);
    }

    public void checkLoadByLoadRouteCode(String routeCode) {
        Waiters.waitForPresenceOfElement(tableContent);
        List<WebElement> loads = getTableContent().findElements(By.xpath(".//tr[contains(@class, 'k-detail-row')]"));
        Waiters.waitABit(1000);
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        WebElement route = loads.stream()
                .filter(el -> el.getText().contains(routeCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Route with Route Code " + routeCode + " is not found"));
        clickOnElement(route.findElement(By.xpath(".//input[@type='checkbox']")));
    }

    public void checkLoadByLoadRouteIndex(int index) {
        Waiters.waitForPresenceOfElement(tableContent);
        List<WebElement> loads = getTableContent().findElements(By
                .xpath(".//tbody//tr[contains(@class, 'k-detail-row')]//tr[contains(@class, 'k-master-row')]"));
        Waiters.waitABit(1000);
        scrollTo(By.xpath("//span[contains(text(), 'Statistics')]"));
        Waiters.waitForElementToBeDisplay(loads.get(index).findElement(By.xpath(".//input[@type='checkbox']")));
        clickOnElement(loads.get(index).findElement(By.xpath(".//input[@type='checkbox']")));
    }

    public void typeDateLoadStart(CharSequence date) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDateRouteStart());
        doubleClick(getDateRouteStart());
        pressDelete(getDateRouteStart());
        inputText(getDateRouteStart(), date);
        pressEnter(getDateRouteStart());
        Waiters.waitABit(5000);
    }

    public void typePastDateLoadStart(int days) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDateRouteStart());
        doubleClick(getDateRouteStart());
        pressDelete(getDateRouteStart());
        inputText(getDateRouteStart(), TimeConversion.pastDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
        pressEnter(getDateRouteStart());
        Waiters.waitABit(2000);
    }

    public void typeFutureDateLoadStart(int days) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDateRouteStart());
        doubleClick(getDateRouteStart());
        pressDelete(getDateRouteStart());
        inputText(getDateRouteStart(), TimeConversion.futureDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
        pressEnter(getDateRouteStart());
        Waiters.waitABit(2000);
    }

    public void typePastDateLoadEnd(int days) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDateRouteEnd());
        doubleClick(getDateRouteEnd());
        pressDelete(getDateRouteEnd());
        inputText(getDateRouteEnd(), TimeConversion.pastDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
        pressEnter(getDateRouteEnd());
        Waiters.waitABit(2000);
    }

    public void typeFutureDateLoadEnd(int days) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDateRouteEnd());
        doubleClick(getDateRouteEnd());
        pressDelete(getDateRouteEnd());
        inputText(getDateRouteEnd(), TimeConversion.futureDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
        pressEnter(getDateRouteEnd());
        Waiters.waitABit(2000);
    }

    public void typeDateRouteEnd(CharSequence date) {
        Waiters.waitForElementToBeDisplay(getDateRouteEnd());
        doubleClick(getDateRouteEnd());
        pressDelete(getDateRouteEnd());
        inputText(getDateRouteEnd(), date);
        pressEnter(getDateRouteEnd());
        Waiters.waitABit(2000);
    }

    public void typeProduct(CharSequence product) {
        Waiters.waitForElementToBeDisplay(getEnterProductInput());
        inputText(getEnterProductInput(), product);
        pressEnter(getEnterProductInput());
        Waiters.waitABit(2000);
    }

    public void typeTemperature(CharSequence temperature) {
        Waiters.waitForElementToBeDisplay(getTemperatureInput());
        clear(getTemperatureInput());
        inputText(getTemperatureInput(), temperature);
        pressEnter(getTemperatureInput());
        Waiters.waitABit(2000);
    }

    public void typeSealNumber(CharSequence sealNumber) {
        Waiters.waitForElementToBeDisplay(getSealNumberInput());
        clear(getSealNumberInput());
        inputText(getSealNumberInput(), sealNumber);
        pressEnter(getSealNumberInput());
        Waiters.waitABit(2000);
    }

    public void typeDriver(String driver) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDriverInput());
        enterText(getDriverInput(), driver);
    }

    public void clickSearchSupplierButton() {
        Waiters.waitForElementToBeDisplay(getSearchSupplierButton());
        clickOnElement(getSearchSupplierButton());
        Waiters.waitABit(2000);
    }

    public void clickOkButton() {
        Waiters.waitForElementToBeDisplay(getOkButton());
        clickOnElement(getOkButton());
    }

    public void clickBtnAddProductCancel() {
        Waiters.waitForElementToBeDisplay(getBtnAddProductCancel());
        clickOnElement(getBtnAddProductCancel());
    }

    public void clickReadyToReceiveStatus() {
        Waiters.waitForElementToBeDisplay(getReadyToReceiveStatus());
        clickOnElement(getReadyToReceiveStatus());
    }

    public void clickLoadOrderByNumber(int num) {
        Waiters.waitABit(2000);
        clickOnElement(getLoadOrders().get(num));
    }

    public boolean isTopIconPresent() {
        Waiters.waitForPresenceOfElement(By.xpath("//span[contains(text(), 'Inbound load summary')]"));
        return isElementPresent(getTopIcon());
    }

    public boolean isDropdownListDisplayed() {
        Waiters.waitForElementToBeDisplay(getDropdownList());
        return isElementPresent(getDropdownList());
    }

    public boolean isDateRouteStartPresent() {
        Waiters.waitForPresenceOfElement(By.cssSelector("#dateRouteStart"));
        return isElementPresent(getDateRouteStart());
    }

    public boolean isDateRouteEndPresent() {
        Waiters.waitForPresenceOfElement(By.cssSelector("#dateRouteEnd"));
        return isElementPresent(getDateRouteEnd());
    }

    public boolean isStatusDropDownPresent() {
        Waiters.waitForPresenceOfElement(By.xpath("//span[@class='k-input' and text()='All statuses']"));
        return isElementPresent(getStatusDropDown("All statuses"));
    }

    public boolean isCardRouteSummaryFilterPresent() {
        Waiters.waitForPresenceOfElement(By.cssSelector("#cardRouteSummaryFilter"));
        return isElementPresent(getCardRouteSummaryFilter());
    }

    public boolean isCardRouteSummaryGridPresent() {
        Waiters.waitForPresenceOfElement(By.cssSelector("#divSummaryCommon"));
        return isElementPresent(getCardRouteSummaryGrid());
    }

    public boolean isInvalidEntryPopUpDisplayed() {
        return isElementDisplay(getInvalidEntryPopup());
    }

    public boolean isTemperatureLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getTemperatureLabel());
        return isElementDisplay(getTemperatureLabel());
    }

    public boolean isTemperatureInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getTemperatureInput());
        return isElementDisplay(getTemperatureInput());
    }

    public boolean isSealNumberLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getSealNumberLabel());
        return isElementDisplay(getSealNumberLabel());
    }

    public boolean isSealNumberInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getSealNumberInput());
        return isElementDisplay(getSealNumberInput());
    }

    public int areCommentsLabelsDisplayed() {
        Waiters.waitForAllElementsToBeDisplay(getCommentsLabels().get(0));
        return elementsArePresent(getCommentsLabels());
    }

    public int areCommentsInputsDisplayed() {
        Waiters.waitForAllElementsToBeDisplay(getCommentsInputs().get(0));
        return elementsArePresent(getCommentsInputs());
    }

    public int areYesRadioButtonsDisplayed() {
        Waiters.waitForAllElementsToBeDisplay(getYesRadioButtons().get(0));
        return elementsArePresent(getYesRadioButtons());
    }

    public int areNoRadioButtonsDisplayed() {
        Waiters.waitForAllElementsToBeDisplay(getNoRadioButtons().get(0));
        return elementsArePresent(getNoRadioButtons());
    }

    public boolean isBtnAddProductCancelDisplayed() {
        Waiters.waitForElementToBeDisplay(getBtnAddProductCancel());
        return isElementDisplay(getBtnAddProductCancel());
    }

    public boolean isLoadCodeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLoadCodeLabel());
        return isElementDisplay(getLoadCodeLabel());
    }

    public boolean isLoadCodeInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getLoadCodeInput());
        return isElementDisplay(getLoadCodeInput());
    }

    public boolean isScheduledDateLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getScheduledDateLabel());
        return isElementDisplay(getScheduledDateLabel());
    }

    public boolean isScheduledDateDisplayed() {
        Waiters.waitForElementToBeDisplay(getScheduledDate());
        return isElementDisplay(getScheduledDate());
    }

    public boolean isCarrierLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getCarrierLabel());
        return isElementDisplay(getCarrierLabel());
    }

    public boolean isCarrierInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getCarrierInput());
        return isElementDisplay(getCarrierInput());
    }

    public boolean isTrailerLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getTrailerLabel());
        return isElementDisplay(getTrailerLabel());
    }

    public boolean isTrailerInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getTrailerInput());
        return isElementDisplay(getTrailerInput());
    }

    public boolean isDoorLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDoorLabel());
        return isElementDisplay(getDoorLabel());
    }

    public boolean isDoorInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getDoorInput());
        return isElementDisplay(getDoorInput());
    }

    public boolean isLoadTypeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLoadTypeLabel());
        return isElementDisplay(getLoadTypeLabel());
    }

    public boolean isLoadTypeInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getLoadTypeInput());
        return isElementDisplay(getLoadTypeInput());
    }

    public boolean isScheduledTimeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getScheduledTimeLabel());
        return isElementDisplay(getScheduledTimeLabel());
    }

    public boolean isScheduledTimeInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getScheduledTimeInput());
        return isElementDisplay(getScheduledTimeInput());
    }

    public boolean isDriverLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDriverLabel());
        return isElementDisplay(getDriverLabel());
    }

    public boolean isDriverInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getDriverInput());
        return isElementDisplay(getDriverInput());
    }

    public boolean isTemperatureFieldDisplayed() {
        Waiters.waitForElementToBeDisplay(getTemperatureField());
        return isElementDisplay(getTemperatureField());
    }

    public boolean isSourceOrderTypeDisplayed() {
        Waiters.waitForElementToBeDisplay(getSourceOrderType());
        return isElementDisplay(getSourceOrderType());
    }

    public boolean isSourceOrderDisplayed() {
        Waiters.waitForElementToBeDisplay(getSourceOrder());
        return isElementDisplay(getSourceOrder());
    }

    public boolean isSourceStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getSourceStatus());
        return isElementDisplay(getSourceStatus());
    }

    public boolean isReadyToReceiveStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getReadyToReceiveStatus());
        return isElementDisplay(getReadyToReceiveStatus());
    }

    public boolean isCancelInboundStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getCancelInboundStatus());
        return isElementDisplay(getCancelInboundStatus());
    }

    public boolean isReopenOrderStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getReopenOrderStatus());
        return isElementDisplay(getReopenOrderStatus());
    }

    public boolean isFinishReceivingOrderDisplayed() {
        Waiters.waitForElementToBeDisplay(getFinishReceivingOrderStatus());
        return isElementDisplay(getFinishReceivingOrderStatus());
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(itemsFoundLabel);
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(itemsFoundValue);
    }

    public boolean isLoadFieldDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLoadField());
    }

    public boolean isLoadNumberDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getLoadNumber());
    }

    public boolean isDoorFieldDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDoorField());
    }

    public boolean isQaFieldDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getQaField());
    }

    public boolean isCarrierFieldDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(carrierField);
    }

    public boolean isOrdersFieldDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getOrdersField());
    }

    public boolean isQtyFieldDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getQtyField());
    }

    public boolean isCubeFieldDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCubeField());
    }

    public boolean isWeightFieldDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getWeightField());
    }

    public boolean isImagesButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getImagesButton());
    }

    public boolean isWarehouseDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getDropdownList());
    }

    public boolean isCommentsButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCommentsButton());
    }

    public boolean isReceivedQtyDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getReceivedQty());
    }

    public boolean isStagedQtyDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getStagedQty());
    }

    public boolean isRedQtyDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getRedQty());
    }

    public boolean isGrayQtyDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getGrayQty());
    }

    public boolean isSaveButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(saveButton);
    }

    public boolean isCancelButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(cancelButton);
    }

    public boolean isYesButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(yesButton);
    }

    public boolean isNoButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(noButton);
    }

    public int isLoadOrdersListDisplayed() {
        Waiters.waitABit(2000);
        return elementsArePresent(getLoadOrders());
    }

    public String getItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundValue);
    }

    public String getInvalidEntryPopUpText() {
        Waiters.waitForPresenceOfElement(".k-window-title");
        return getText(getInvalidEntryPopup());
    }

    public String getDialogPopUpText() {
        Waiters.waitForPresenceOfElement(".k-dialog-title");
        return getText(getDialogPopup());
    }

    public String getDialogTextTitle() {
        Waiters.waitForPresenceOfElement("#dialogTextContent");
        return getText(getDialogTextContent());
    }

    public String getDialogPopUpContentText() {
        Waiters.waitForPresenceOfElement(".k-dialog-content");
        return getText(getDialogContent());
    }

    public String getDateRouteStartValue() {
        Waiters.waitForElementToBeDisplay(getDateRouteStart());
        return getValue(getDateRouteStart());
    }

    public String getDateRouteEndValue() {
        Waiters.waitForElementToBeDisplay(getDateRouteEnd());
        return getValue(getDateRouteEnd());
    }

    public boolean isOrderedLabelDisplayed() { return isElementDisplay(getOrderedLabel()); }

    public boolean isStagedLabelDisplayed() { return isElementDisplay(getStagedLabel()); }

    public boolean isReceivedLabelDisplayed() { return isElementDisplay(getReceivedLabel()); }

    public boolean isReviewLoadLabelDisplayed() { return isElementDisplay(getReviewLoadLabel()); }

    public boolean isProductColumnDisplayed() { return isElementDisplay(getProductColumn()); }

    public boolean isDescriptionColumnDisplayed() { return isElementDisplay(getDescriptionColumn()); }

    public boolean isQualifier1ColumnDisplayed() { return isElementDisplay(getQualifier1Column()); }

    public boolean isOrderedColumnDisplayed() { return isElementDisplay(getOrderedColumn()); }

    public boolean isStagedColumnDisplayed() { return isElementDisplay(getStagedColumn()); }

    public boolean isReceivedColumnDisplayed() { return isElementDisplay(getReceivedColumn()); }

    public boolean isStatusColumnDisplayed() { return isElementDisplay(getStatusColumn()); }

    public boolean isLotColumnDisplayed() { return isElementDisplay(getLotColumn()); }

    public boolean isExpDateColumnDisplayed() { return isElementDisplay(getExpDateColumn()); }

    public boolean isDateCodeColumnDisplayed() { return isElementDisplay(getDateCodeColumn()); }

    public boolean isCancelBtnDisplayed() { return isElementDisplay(getCancelBtn()); }

    public boolean isSaveBtnDisplayed() { return isElementDisplay(getSaveBtn()); }

    public String isDataOptionDisabled() {
        return getElementAttribute(getDataOption(), "aria-disabled");
    }

    public String isEditDisabled() {
        return getElementAttribute(findWebElement(By.xpath("//li[@role='menuItem' and text()='Edit']")), "aria-disabled");
    }

    public String isSourceDisabled() {
        return getElementAttribute(findWebElement(By.xpath("//li[@role='menuItem' and text()='Source']")), "aria-disabled");
    }

    public String isReceiveDisabled() {
        return getElementAttribute(findWebElement(By.xpath("//li[@role='menuItem' and text()='Receive']")), "aria-disabled");
    }

    public WebElement getTopIcon() {
        return findWebElement(topIcon);
    }

    public WebElement getDropdownList() {
        return findWebElement(dropdownList);
    }

    public WebElement getCardRouteSummaryFilter() {
        return findWebElement(cardRouteSummaryFilter);
    }

    public WebElement getCardRouteSummaryGrid() {
        return findWebElement(cardRouteSummaryGrid);
    }

    public WebElement getDateRouteStart() {
        return findWebElement(dateRouteStart);
    }

    public WebElement getDateRouteEnd() {
        return findWebElement(dateRouteEnd);
    }

    public WebElement getEnterLoadInput() {
        return findWebElement(enterLoadInput);
    }

    public WebElement getEnterNameInput() {
        return findWebElement(enterNameInput);
    }

    public WebElement getEnterSupplierInput() {
        return findWebElement(enterSupplierInput);
    }

    public WebElement getSearchSupplierButton() {
        return findWebElement(searchSupplierButton);
    }

    public WebElement getEnterProductInput() {
        return findWebElement(enterProductInput);
    }

    public WebElement getSearchProductButton() {
        return findWebElement(searchProductButton);
    }

    public WebElement getLoadOptionsButton() {
        return findWebElement(loadOptionsButton);
    }

    public WebElement getTableContent() {
        return findWebElement(tableContent);
    }

    public WebElement getInvalidEntryPopup() {
        return findWebElement(invalidEntryPopup);
    }

    public WebElement getDialogPopup() {
        return findWebElement(dialogPopup);
    }

    public WebElement getDialogContent() {
        return findWebElement(dialogContent);
    }

    public WebElement getOkButton() {
        return findWebElement(okButton);
    }

    public WebElement getClearButton() {
        return findWebElement(clearButton);
    }

    public WebElement getStatusDropDown(String status) {
        return findWebElement(getStatus(status));
    }

    public WebElement getItemsFoundLabel() {
        return findWebElement(itemsFoundLabel);
    }

    public WebElement getItemsFoundValue() {
        return findWebElement(itemsFoundValue);
    }

    public WebElement getCarrierDropdown(String carrier) {
        return findWebElement(getCarrier(carrier));
    }

    public WebElement getChangeStatusOption() {
        return findWebElement(changeStatusOption);
    }

    public WebElement getDoorOption() {
        return findWebElement(doorOption);
    }

    public WebElement getDataOption() {
        return findWebElement(dataOption);
    }

    public WebElement getNotificationMsg() {
        return findWebElement(notificationMsg);
    }

    public WebElement getTemperatureLabel() {
        return findWebElement(temperatureLabel);
    }

    public WebElement getTemperatureInput() {
        return findWebElement(temperatureInput);
    }

    public WebElement getSealNumberLabel() { return findWebElement(sealNumberLabel); }

    public WebElement getSealNumberInput() {
        return findWebElement(sealNumberInput);
    }

    public List<WebElement> getCommentsLabels() {
        return findWebElements(commentsLabels);
    }

    public List<WebElement> getCommentsInputs() {
        return findWebElements(commentsInputs);
    }

    public List<WebElement> getYesRadioButtons() {
        return findWebElements(yesRadioButtons);
    }

    public List<WebElement> getNoRadioButtons() {
        return findWebElements(noRadioButtons);
    }

    public WebElement getBtnAddProductCancel() {
        return findWebElement(btnAddProductCancel);
    }

    public WebElement getLoadCodeLabel() {
        return findWebElement(loadCodeLabel);
    }

    public WebElement getLoadCodeInput() {
        return findWebElement(loadCodeInput);
    }

    public WebElement getScheduledDateLabel() {
        return findWebElement(scheduledDateLabel);
    }

    public WebElement getScheduledDate() {
        return findWebElement(scheduledDate);
    }

    public WebElement getCarrierLabel() {
        return findWebElement(carrierLabel);
    }

    public WebElement getCarrierInput() {
        return findWebElement(carrierInput);
    }

    public WebElement getDoorLabel() {
        return findWebElement(doorLabel);
    }

    public WebElement getDoorInput() {
        return findWebElement(doorInput);
    }

    public WebElement getTrailerLabel() {
        return findWebElement(trailerLabel);
    }

    public WebElement getTrailerInput() {
        return findWebElement(trailerInput);
    }

    public WebElement getLoadTypeLabel() {
        return findWebElement(loadTypeLabel);
    }

    public WebElement getLoadTypeInput() {
        return findWebElement(loadTypeInput);
    }

    public WebElement getScheduledTimeLabel() {
        return findWebElement(scheduledTimeLabel);
    }

    public WebElement getScheduledTimeInput() {
        return findWebElement(scheduledTimeInput);
    }

    public WebElement getDriverLabel() {
        return findWebElement(driverLabel);
    }

    public WebElement getDriverInput() {
        return findWebElement(driverInput);
    }

    public WebElement getTemperatureField() {
        return findWebElement(temperatureField);
    }

    public WebElement getSourceOrderType() {
        return findWebElement(sourceOrderTypeColumn);
    }

    public WebElement getSourceOrder() {
        return findWebElement(sourceOrderColumn);
    }

    public WebElement getSourceStatus() {
        return findWebElement(sourceStatusColumn);
    }

    public WebElement getReadyToReceiveStatus() {
        return findWebElement(readyToReceiveStatus);
    }

    public WebElement getCancelInboundStatus() {
        return findWebElement(cancelInboundStatus);
    }

    public WebElement getReopenOrderStatus() {
        return findWebElement(reopenOrderStatus);
    }

    public WebElement getFinishReceivingOrderStatus() {
        return findWebElement(finishReceivingOrderStatus);
    }

    public WebElement getLoadField() {
        return findWebElement(loadField);
    }

    public WebElement getLoadNumber() {
        return findWebElement(loadNumber);
    }

    public WebElement getDoorField() {
        return findWebElement(doorField);
    }

    public WebElement getQaField() {
        return findWebElement(qaField);
    }

    public WebElement getTrailerField() {
        return findWebElement(trailerField);
    }

    public WebElement getCarrierField() {
        return findWebElement(carrierField);
    }

    public WebElement getOrdersField() {
        return findWebElement(ordersField);
    }

    public WebElement getQtyField() {
        return findWebElement(qtyField);
    }

    public WebElement getCubeField() {
        return findWebElement(cubeField);
    }

    public WebElement getWeightField() {
        return findWebElement(weightField);
    }

    public WebElement getImagesButton() {
        return findWebElement(imagesButton);
    }

    public WebElement getCommentsButton() {
        return findWebElement(commentsButton);
    }

    public WebElement getReceivedQty() {
        return findWebElement(receivedQty);
    }

    public WebElement getStagedQty() {
        return findWebElement(stagedQty);
    }

    public WebElement getRedQty() {
        return findWebElement(redQty);
    }

    public WebElement getGrayQty() {
        return findWebElement(grayQty);
    }

    public List<WebElement> getLoadOrders() {
        return findWebElements(loadOrders);
    }

    public WebElement getDialogTextContent() {
        return findWebElement(dialogTextContent);
    }

    public WebElement getOrderedLabel() {
        return findWebElement(orderedLabel);
    }

    public WebElement getStagedLabel() {
        return findWebElement(stagedLabel);
    }

    public WebElement getReceivedLabel() {
        return findWebElement(receivedLabel);
    }

    public WebElement getReviewLoadLabel() {
        return findWebElement(reviewLoadLabel);
    }

    public WebElement getProductColumn() {
        return findWebElement(productColumn);
    }

    public WebElement getDescriptionColumn() {
        return findWebElement(descriptionColumn);
    }

    public WebElement getQualifier1Column() {
        return findWebElement(qualifier1Column);
    }

    public WebElement getOrderedColumn() {
        return findWebElement(orderedColumn);
    }

    public WebElement getStagedColumn() {
        return findWebElement(stagedColumn);
    }

    public WebElement getReceivedColumn() {
        return findWebElement(receivedColumn);
    }

    public WebElement getStatusColumn() {
        return findWebElement(statusColumn);
    }

    public WebElement getLotColumn() {
        return findWebElement(lotColumn);
    }

    public WebElement getExpDateColumn() {
        return findWebElement(expDateColumn);
    }

    public WebElement getDateCodeColumn() {
        return findWebElement(dateCodeColumn);
    }

    public WebElement getWeightColumn() {
        return findWebElement(weightColumn);
    }

    public WebElement getCancelBtn() { return findWebElement(cancelBtn); }

    public WebElement getSaveBtn() { return findWebElement(saveBtn); }

}
