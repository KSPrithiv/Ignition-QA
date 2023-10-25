package ui.pages.inbound.inboundorders;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

import static common.setup.DriverManager.getDriver;

public class InboundOrderSummaryPage extends BasePage {
    By topIcon = By.xpath("//span[contains(text(), 'Inbound order summary')]");
    By cardOrderSummaryFilter = By.cssSelector("#cardOrderSummaryFilter");
    By cardOrderSummaryGrid = By.cssSelector("#crdOrderSummaryCommonGrid");
    By dateRouteStart = By.cssSelector("#dateRouteStart");
    By dateRouteEnd = By.cssSelector("#dateRouteEnd");
    By enterOrderInput = By.cssSelector("input[placeholder='Enter order']");
    By enterSupplierInput = By.cssSelector("input[placeholder='Enter a supplier']");
    By enterNameInput = By.cssSelector("input[placeholder='Enter name']");
    By searchSupplierButton = By.xpath("//div[@class='i-indexfield-container w__width_100per']//button");
    By enterProductInput = By.cssSelector("input[placeholder='Enter a product']");
    By searchProductButton = By.cssSelector(".autocomplete_custom button.k-button-icontext");
    By orderOptionsButton = By.cssSelector("button[aria-label='Order options dropdownbutton']");
    By tableContent = By.cssSelector(".k-grid-content");
    By invalidEntryPopup = By.cssSelector(".k-window-title");
    By okButton = By.xpath("//button[contains(text(), 'Ok')]");
    By changeStatusOption = By.id("btnChangeStatus");
    By doorOption = By.id("ddDoorItem");
    By dataOption = By.id("ddDataItem");
    By dialogPopup = By.cssSelector(".k-dialog-title");
    By supplierSearchIndexGrid = By.cssSelector("#gridUtil_supplierSearchIndex");
    By loadingImage = By.cssSelector(".k-loading-image");
    By productColumn = By.xpath("//span[text()='Product']");
    By descriptionColumn = By.xpath("//span[text()='Description']");
    By orderedColumn = By.xpath("//span[text()='Ordered']");
    By stagedColumn = By.xpath("//span[text()='Staged']");
    By receivedColumn = By.xpath("//span[text()='Received']");
    By gtinColumn = By.xpath("//span[text()='GTIN']");
    By expDateColumn = By.xpath("//span[text()='Exp Date']");
    By dateCodeColumn = By.xpath("//span[text()='Date code']");
    By qualifier1Column = By.xpath("//span[text()='Qualifier 1']");
    By qualifier2Column = By.xpath("//span[text()='Qualifier 2']");
    By qualifier3Column = By.xpath("//span[text()='Qualifier 3']");
    By weightColumn = By.xpath("//span[text()='Weight']");
    By reviewOrderLabel = By.xpath("//label[contains(text(), 'Review order')]");
    By btnReviewCancel = By.id("btnReviewCancel");
    By btnReviewSave = By.id("btnReviewSave");
    By enterProduct = By.cssSelector("input[placeholder='Enter a product']");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By reopenOrderStatus = By.cssSelector("input[value='Reopen Order']");
    By finishReceivingOrderStatus = By.cssSelector("input[value='Finish Receiving']");
    By readyToReceiveStatus = By.cssSelector("input[value='Ready To Receive']");
    By cancelStatus = By.cssSelector("input[value='Cancel Inbound']");
    By statusCellContent = By.cssSelector(".i-status-cell__content");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By receivedQty = By.xpath("//span[contains(@class, 'dot--green')]/following-sibling::span[contains(text(), 'Received')]");
    By stagedQty = By.xpath("//span[contains(@class, 'dot--yellow')]/following-sibling::span[contains(text(), 'Staged')]");
    By redQty = By.xpath("//span[contains(@class, 'dot--red')]/following-sibling::span[contains(text(), 'Over')]");
    By grayQty = By.xpath("//span[contains(@class, 'dot--gray')]/following-sibling::span[contains(text(), 'Remainder')]");
    By sourceOrderTypeColumn = By.xpath("//span[text()='Order type']");
    By sourceOrderColumn = By.xpath("//span[text()='Order no.']");
    By sourceStatusColumn = By.xpath("//span[text()='Status']");
    By routeBackButton = By.id("RouteBackButton");
    By scheduledDateLabel = By.cssSelector("#cpDate-label");
    By scheduledDate = By.cssSelector("#cpDate");
    By scheduledTimeLabel = By.cssSelector("#cpTile-label");
    By scheduledTimeInput = By.cssSelector("#cpTile");
    By carrierLabel = By.xpath("//label[contains(text(), 'Carrier')]");
    By carrierInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Carrier')]]//span[@class='k-input']");
    By trailerLabel = By.xpath("//label[contains(text(), 'Trailer')]");
    By trailerInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Trailer')]]//span[@class='k-input']");
    By paymentTypeLabel = By.xpath("//label[contains(text(), 'Payment type')]");
    By paymentTypeInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Payment type')]]//span[@class='k-input']");
    By commentsLabel = By.xpath("//label[text()='Comment']");
    By commentsInput = By.xpath("//label[text()='Comment']//following-sibling::textarea");
    By temperatureLabel = By.xpath("//label[text()='Temperature']");
    By temperatureInput = By.xpath("//label[text()='Temperature']//following-sibling::input");
    By sealNumberLabel = By.xpath("//label[text()='Seal Number']");
    By sealNumberInput = By.xpath("//label[text()='Seal Number']//following-sibling::input");
    By commentsLabels = By.xpath("//label[text()='Comments']");
    By commentsInputs = By.xpath("//label[text()='Comments']//following-sibling::input");
    By yesRadioButtons = By.xpath("//label[text()='Yes']//preceding-sibling::input");
    By noRadioButtons = By.xpath("//label[text()='No']//preceding-sibling::input");
    By btnAddProductCancel = By.id("btnAddProductCancel");
    By noButton = By.xpath("//button[contains(text(), 'No')]");
    By yesButton = By.xpath("//button[contains(text(), 'Yes')]");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By notificationMsg = By.cssSelector(".toast-message");
    By receiverDateColumn = By.xpath("//span[text()='Date']");
    By receiverFromStatusColumn = By.xpath("//span[text()='From status']");
    By receiverToStatusColumn = By.xpath("//span[text()='To status']");
    By receiverUserColumn = By.xpath("//span[text()='User']");
    By addFilterButton = By.cssSelector(".i-filter-tag__main__text--add");
    By dateTimeCheckBox = By.id("DATETIME");
    By fromStatusCheckBox = By.id("FROM_STATUS_DESC");
    By toStatusCheckBox = By.id("TO_STATUS_DESC");
    By userCheckBox = By.id("USER_NAME");
    By windowTitle = By.cssSelector(".k-window-title");
    By moveShipDate = By.cssSelector("#moveStartDate-label");
    By moveShipDateInput = By.id("moveStartDate");
    By loadInput = By.id("OrderSummaryMove__loadrouteTxtBox");
    By inboundImageCaptureButton = By.cssSelector(".inboundImageCaptureOpButtonDiv button");
    By selectFilesBtn = By.xpath("//div[@aria-label='Select files']");
    By loadImageLabel = By.xpath("//span[text()='Load image(s)']");
    By saveEditButton = By.id("saveEditButton");
    By dialogContent = By.cssSelector(".k-dialog-content");
    By dropdownList = By.id("dropdownList");
    By loader = By.cssSelector(".loader");
    By arrowChevron = By.xpath("//button[contains(@class, 'i-card__card__title-area')]//span[contains(@class, 'k-i-arrow-chevron')]");
    By imagesButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Images')]");
    By commentsButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Comments')]");

    private By getOrderTypeDropDown(String orderType) { return By.xpath("//span[contains(text(),'" + orderType + "')]"); }

    private By getBuyerDropDown(String buyer) { return By.xpath("//span[contains(text(),'" + buyer + "')]"); }

    private By getDoorDropDown(String door) { return By.xpath("//span[contains(text(),'" + door + "')]"); }

    private By getCarrier(String carrier) { return By.xpath("//span[contains(@role,'listbox')][.//span[contains(text(), '" + carrier + "')]]"); }

    private By getOwner(String owner) { return By.xpath("//span[contains(text(),'" + owner + "')]"); }

    private By getStatus(String status) {
        return By.xpath("//span[@class='k-input' and text()='" + status + "']");
    }

    public void waitInboundOrderSummaryToLoad() {
        waitUntilInvisible(5, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTopIcon());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public List<WebElement> getOrderDropdownOptions() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForPresenceOfAllElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='menuItem']"));
        return findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='menuItem']"));
    }

    public WebElement getOrderDropdownOption(String option) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForPresenceOfAllElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[@role='menuItem']"));
        return getOrderDropdownOptions().stream()
                .filter(el -> el.getText().trim().contains(option))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order Dropdown Option " + option + " is not found"));
    }

    public boolean isOrderOptionDisabled(String option) {
        return getOrderDropdownOption(option).getAttribute("class").contains("disabled");
    }

    public boolean isDataOptionDisabled() {
        return getDataOption().getAttribute("class").contains("disabled");
    }

    public boolean isSaveButtonDisabled() {
        return getSaveButton().getAttribute("class").contains("disabled");
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(5000);
        return isElementDisplay(itemsFoundLabel); }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(5000);
        return isElementDisplay(itemsFoundValue); }

    public boolean isReopenOrderStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getReopenOrderStatus());
        return isElementDisplay(getReopenOrderStatus());
    }

    public boolean isFinishReceivingOrderDisplayed() {
        Waiters.waitForElementToBeDisplay(getFinishReceivingOrderStatus());
        return isElementDisplay(getFinishReceivingOrderStatus());
    }

    public boolean isReadyToReceiveStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getReadyToReceiveStatus());
        return isElementDisplay(getReadyToReceiveStatus());
    }

    public boolean isReceivedQtyDisplayed() { return isElementDisplay(getReceivedQty()); }

    public boolean isStagedQtyDisplayed() { return isElementDisplay(getStagedQty()); }

    public boolean isRedQtyDisplayed() {  return isElementDisplay(getRedQty()); }

    public boolean isGrayQtyDisplayed() {  return isElementDisplay(getGrayQty());  }

    public boolean isCancelStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getCancelStatus());
        return isElementDisplay(getCancelStatus());
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

    public boolean isScheduledDateLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getScheduledDateLabel());
        return isElementDisplay(getScheduledDateLabel());
    }

    public boolean isScheduledDateDisplayed() {
        Waiters.waitForElementToBeDisplay(getScheduledDate());
        return isElementDisplay(getScheduledDate());
    }

    public boolean isScheduledTimeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getScheduledTimeLabel());
        return isElementDisplay(getScheduledTimeLabel());
    }

    public boolean isScheduledTimeInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getScheduledTimeInput());
        return isElementDisplay(getScheduledTimeInput());
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

    public boolean isPaymentTypeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getPaymentTypeLabel());
        return isElementDisplay(getPaymentTypeLabel());
    }

    public boolean isPaymentTypeInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getPaymentTypeInput());
        return isElementDisplay(getPaymentTypeInput());
    }

    public boolean isCommentsLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getCommentsLabel());
        return isElementDisplay(getCommentsLabel());
    }

    public boolean isCommentsInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getCommentsInput());
        return isElementDisplay(getCommentsInput());
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

    public boolean isReceiverDateColumnDisplayed() {
        Waiters.waitForElementToBeDisplay(receiverDateColumn);
        return isElementDisplay(receiverDateColumn);
    }

    public boolean isReceiverFromStatusColumnDisplayed() {
        Waiters.waitForElementToBeDisplay(receiverFromStatusColumn);
        return isElementDisplay(receiverFromStatusColumn);
    }

    public boolean isReceiverToStatusColumnDisplayed() {
        Waiters.waitForElementToBeDisplay(receiverToStatusColumn);
        return isElementDisplay(receiverToStatusColumn);
    }

    public boolean isReceiverUserColumnDisplayed() {
        Waiters.waitForElementToBeDisplay(receiverUserColumn);
        return isElementDisplay(receiverUserColumn);
    }

    public boolean isDateTimeCheckBoxDisplayed() {
        Waiters.waitForElementToBeDisplay(getDateTimeCheckBox());
        return isElementDisplay(getDateTimeCheckBox());
    }

    public boolean isFromStatusCheckBoxDisplayed() {
        Waiters.waitForElementToBeDisplay(getFromStatusCheckBox());
        return isElementDisplay(getFromStatusCheckBox());
    }

    public boolean isToStatusCheckBoxDisplayed() {
        Waiters.waitForElementToBeDisplay(getToStatusCheckBox());
        return isElementDisplay(getToStatusCheckBox());
    }

    public boolean isUserCheckBoxDisplayed() {
        Waiters.waitForElementToBeDisplay(getUserCheckBox());
        return isElementDisplay(getUserCheckBox());
    }

    public boolean isMoveShipDateDisplayed() {
        Waiters.waitForElementToBeDisplay(getMoveShipDate());
        return isElementDisplay(getMoveShipDate());
    }

    public boolean isMoveShipDateInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getMoveShipDateInput());
        return isElementDisplay(getMoveShipDateInput());
    }

    public boolean isLoadInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getLoadInput());
        return isElementDisplay(getLoadInput());
    }

    public boolean isInboundImageCaptureButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getInboundImageCaptureButton());
        return isElementDisplay(getInboundImageCaptureButton());
    }

    public boolean isSelectFilesBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getSelectFilesBtn());
        return isElementDisplay(getSelectFilesBtn());
    }

    public boolean isSaveEditButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getSaveEditButton());
        return isElementDisplay(getSaveEditButton());
    }

    public boolean isLoadImageLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLoadImageLabel());
        return isElementDisplay(getLoadImageLabel());
    }

    public boolean isSaveButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(saveButton);
        return isElementDisplay(saveButton);
    }

    public boolean isRouteBackButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(routeBackButton);
        return isElementDisplay(routeBackButton);
    }

    public boolean isWarehouseDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getDropdownList());
    }

    public void selectOrderOption(String option) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getOrderOptionsButton());
        clickOnElement(getOrderOptionsButton());
        WebElement orderOption = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + option + "')]"));
        clickOnElement(orderOption);
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilInvisible(1, loader);
    }

    public void clickOrderOption() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getOrderOptionsButton());
        clickOnElement(getOrderOptionsButton());
    }

    public void clickImagesButton() {
        Waiters.waitForElementToBeDisplay(getImagesButton());
        clickOnElement(getImagesButton());
    }

    public void clickCommentsButton() {
        Waiters.waitForElementToBeDisplay(getCommentsButton());
        clickOnElement(getCommentsButton());
    }

    public void clickYesButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(yesButton);
        clickOnElement(yesButton);
    }

    public void clickNoButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(noButton);
        clickOnElement(noButton);
    }

    public void clickSave() {
        clickOnElement(saveButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void checkOrderByOrderNumber(int ordNum) {
        Waiters.waitABit(2000);
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(findWebElements(By.xpath("//div[contains(@class, 'BarsContainer')]/parent::*//input[@type='checkbox']"))
                .get(ordNum));
    }

    public void clickOrderStatus(String status) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getStatusDropDown(status));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeTemperature(CharSequence temperature) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTemperatureInput());
        scrollToCenter(getTemperatureInput());
        clear(getTemperatureInput());
        inputText(getTemperatureInput(), temperature);
        pressEnter(getTemperatureInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeSealNumber(CharSequence sealNumber) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSealNumberInput());
        scrollToCenter(getSealNumberInput());
        clear(getSealNumberInput());
        inputText(getSealNumberInput(), sealNumber);
        pressEnter(getSealNumberInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickBtnAddProductCancel() {
        Waiters.waitForElementToBeDisplay(getBtnAddProductCancel());
        clickOnElement(getBtnAddProductCancel());
    }

    public void clickAddFilter() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeClickable(getAddFilterButton());
        clickOnElement(getAddFilterButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectOrderStatus(String status) {
        Waiters.waitTillLoadingPage(getDriver());
        WebElement orderStatus = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "')]"));
        clickOnElement(orderStatus);
        waitUntilInvisible(5, loader);
    }

    public void selectWarehouse(String warehouse) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public String getDialogPopUpText() {
        Waiters.waitForElementToBeDisplay(By.cssSelector(".k-dialog-title"));
        return getText(getDialogPopup());
    }

    public int getRowsCount() {
        Waiters.waitForElementToBeDisplay(tableContent);
        return getTableContent().findElements(By.xpath(".//tr")).size();
    }

    public String getItemsFoundText() {
        Waiters.waitABit(5000);
        return getText(itemsFoundValue);
    }

    public String getDialogPopUpContentText() {
        Waiters.waitABit(2000);
        return getText(dialogContent);
    }

    public String getScheduledDateValue() {
        Waiters.waitForElementToBeDisplay(getScheduledDate());
        return getValue(getScheduledDate());
    }

    public String getScheduledTimeValue() {
        Waiters.waitForElementToBeDisplay(getScheduledTimeInput());
        return getValue(getScheduledTimeInput());
    }

    public void deleteProduct() {
        Waiters.waitForElementToBeDisplay(getEnterProduct());
        doubleClick(getEnterProduct());
        pressDelete(getEnterProduct());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickBuyerDropDown(String buyer) {
        Waiters.waitABit(4000);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getBuyerDropDown(buyer));
        clickOnElement(getBuyerDropDown(buyer));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectDoorDropDown(String door) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDoorDropDown(door));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickDoorDropdown() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(By.id("ddDoorList"));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickOrderTypeDropDown(String orderType) {
        waitUntilInvisible(3, loader);
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getOrderTypeDropDown(orderType));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickCarrierDropdown(String carrier) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getCarrierDropdown(carrier));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickOwnerDropdown(String owner) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getOwnerDropdown(owner));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickCancel() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(cancelButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickRouteBackButton() {
        clickOnElement(routeBackButton);
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilInvisible(2, loader);
    }

    public void selectOption(String buyer) {
        Waiters.waitTillLoadingPage(getDriver());
        List<WebElement> options = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[@role='option']"));
        WebElement option = options.stream()
                .filter(el -> el.getText().contains(buyer))
                .findFirst()
                .orElse(null);
        scrollToCenter(option);
        clickOnElement(option);
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilInvisible(3, loader);
    }

    public void selectOrderByOrderNumber(int orderNum) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> orders = findWebElements(By.xpath("//div[contains(@class, 'BarsContainer')]"));
        Waiters.waitForElementToBeDisplay(orders.get(orderNum));
        clickOnElement(orders.get(orderNum));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectOrderCheckboxByOrderNumber(int orderNum) {
        waitUntilInvisible(2, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> checkBoxes = findWebElements(By.xpath("//div[contains(@class, 'BarsContainer')]/parent::*//input[@type='checkbox']"));
        waitUntilInvisible(2, loader);
        clickOnElement(checkBoxes.get(orderNum));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void selectOrderByOrderName(String order) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(tableContent);
        typeText(getEnterOrderInput(), order);
        pressEnter(getEnterOrderInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clearOrderInput() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterOrderInput());
        clear(getEnterOrderInput());
    }

    public void typeDateRouteStart(CharSequence date) {
        Waiters.waitABit(4000);
        if(findWebElement(arrowChevron).getAttribute("class").contains("down")) {
            clickOnElement(arrowChevron);
        }
        waitUntilInvisible(1, loader);
        clickOnElement(getDateRouteStart());
        Waiters.waitABit(1000);
        clearText(getDateRouteStart());
        Waiters.waitABit(2000);
        inputText(getDateRouteStart(), date);
        pressTab(getDateRouteStart());
        waitUntilInvisible(5, loader);
    }

    public void typeDateRouteEnd(CharSequence date) {
        Waiters.waitABit(2000);
        if(findWebElement(arrowChevron).getAttribute("class").contains("down")) {
            clickOnElement(arrowChevron);
        }
        Waiters.waitABit(2000);
        jsClick(getDateRouteEnd());
        Waiters.waitABit(1000);
        clearText(getDateRouteEnd());
        Waiters.waitABit(2000);
        inputText(getDateRouteEnd(), date);
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(findWebElement(By.cssSelector(".i-card__card__title-area__title")));
        waitUntilInvisible(5, loader);
    }

    public void typeProduct(String product) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterProduct());
        inputText(getEnterProduct(), product);
        Waiters.waitABit(1000);
        pressEnter(getEnterProduct());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeScheduledDate(String date) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getScheduledDate());
        doubleClick(getScheduledDate());
        pressDelete(getScheduledDate());
        inputText(getScheduledDate(), date);
        pressEnter(getScheduledDate());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeScheduledTime(String time) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getScheduledTimeInput());
        click(getScheduledTimeInput());
        pressLeftArrow(getScheduledTimeInput());
        pressLeftArrow(getScheduledTimeInput());
        pressLeftArrow(getScheduledTimeInput());
        pressLeftArrow(getScheduledTimeInput());
        Waiters.waitABit(2000);
        inputText(getScheduledTimeInput(), time.split(":")[0]);
        pressRightArrow(getScheduledTimeInput());
        Waiters.waitABit(2000);
        inputText(getScheduledTimeInput(), time.split(":")[1]);
        pressTab(getScheduledTimeInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeShipDate(String date) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(2000);
        typeText(getMoveShipDateInput(), date);
        pressTab(getMoveShipDateInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeLoad(String load) {
        Waiters.waitTillLoadingPage(getDriver());
        typeText(getLoadInput(), load);
        pressTab(getLoadInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void searchSupplierByCode(String code) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterSupplierInput());
        enterText(getEnterSupplierInput(), code);
        pressEnter(getEnterSupplierInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void searchSupplierByName(String name) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterNameInput());
        enterText(getEnterNameInput(), name);
        pressEnter(getEnterNameInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void cleanSupplierName() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterNameInput());
        doubleClick(getEnterNameInput());
        pressDelete(getEnterNameInput());
        pressEnter(getEnterNameInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void cleanSupplierCode() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getEnterSupplierInput());
        doubleClick(getEnterSupplierInput());
        pressDelete(getEnterSupplierInput());
        pressEnter(getEnterSupplierInput());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickSearchSupplierButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSearchSupplierButton());
        clickOnElement(getSearchSupplierButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickOkButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getOkButton());
        clickOnElement(getOkButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickChangeStatusOption() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getChangeStatusOption());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickDoorOption() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDoorOption());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickDataOption() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDataOption());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickSupplierByNumber(int num) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getSupplierSearchIndexGrid());
        List<WebElement> suppliers = getSupplierSearchIndexGrid().findElements(By.cssSelector("tr"));
        clickOnElement(suppliers.get(num));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public String getWindowTitleText() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(windowTitle);
        return getText(windowTitle);
    }

    public boolean isTopIconPresent() { return isElementPresent(getTopIcon()); }

    public boolean isCardOrderSummaryFilterPresent() { return isElementPresent(getCardOrderSummaryFilter()); }

    public boolean isCardOrderSummaryGridPresent() { return isElementPresent(getCardOrderSummaryGrid()); }

    public boolean isInvalidEntryPopUpPresent() {
        return isElementPresent(getInvalidEntryPopup());
    }

    public boolean isSupplierDialogPopupPresent() {
        return isElementPresent(getDialogPopup());
    }

    public boolean isProductColumnPresent() {
        return isElementPresent(getProductColumn());
    }

    public boolean isDescriptionColumnPresent() {
        return isElementPresent(getDescriptionColumn());
    }

    public boolean isOrderedColumnPresent() {
        return isElementPresent(getOrderedColumn());
    }

    public boolean isStagedColumnPresent() {
        return isElementPresent(getStagedColumn());
    }

    public boolean isReceivedColumnPresent() { return isElementPresent(getReceivedColumn()); }

    public boolean isGtinColumnPresent() { return isElementPresent(getGtinColumn()); }

    public boolean isExpDateColumnPresent() {
        return isElementPresent(getExpDateColumn());
    }

    public boolean isDateCodeColumnPresent() {
        return isElementPresent(getDateCodeColumn());
    }

    public boolean isQualifier1ColumnPresent() {
        return isElementPresent(getQualifier1Column());
    }

    public boolean isQualifier2ColumnPresent() {
        return isElementPresent(getQualifier2Column());
    }

    public boolean isQualifier3ColumnPresent() {
        return isElementPresent(getQualifier3Column());
    }

    public boolean isWeightColumnPresent() {
        return isElementPresent(getWeightColumn());
    }

    public boolean isReviewOrderLabelPresent() {
        return isElementPresent(getReviewOrderLabel());
    }

    public boolean isBtnReviewCancelPresent() {
        return isElementPresent(getBtnReviewCancel());
    }

    public boolean isBtnReviewSavePresent() {
        return isElementPresent(getBtnReviewSave());
    }

    public String getInvalidEntryPopUpText() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector(".k-window-title"));
        return getText(getInvalidEntryPopup());
    }

    public WebElement getTopIcon() { return findWebElement(topIcon); }

    public WebElement getCardOrderSummaryFilter() { return findWebElement(cardOrderSummaryFilter); }

    public WebElement getCardOrderSummaryGrid() { return findWebElement(cardOrderSummaryGrid); }

    public WebElement getDateRouteStart() { return findWebElement(dateRouteStart); }

    public WebElement getDateRouteEnd() { return findWebElement(dateRouteEnd); }

    public WebElement getEnterOrderInput() {  return findWebElement(enterOrderInput); }

    public WebElement getEnterSupplierInput() { return findWebElement(enterSupplierInput); }

    public WebElement getEnterNameInput() { return findWebElement(enterNameInput); }

    public WebElement getSearchSupplierButton() { return findWebElement(searchSupplierButton); }

    public WebElement getEnterProductInput() { return findWebElement(enterProductInput); }

    public WebElement getSearchProductButton() { return findWebElement(searchProductButton); }

    public WebElement getOrderOptionsButton() { return findWebElement(orderOptionsButton); }

    public WebElement getImagesButton() { return findWebElement(imagesButton); }

    public WebElement getCommentsButton() { return findWebElement(commentsButton); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public WebElement getInvalidEntryPopup() { return findWebElement(invalidEntryPopup); }

    public WebElement getOkButton() { return findWebElement(okButton); }

    public WebElement getChangeStatusOption() { return findWebElement(changeStatusOption); }

    public WebElement getDoorOption() { return findWebElement(doorOption); }

    public WebElement getDataOption() { return findWebElement(dataOption); }

    public WebElement getDialogPopup() { return findWebElement(dialogPopup); }

    public WebElement getSupplierSearchIndexGrid() { return findWebElement(supplierSearchIndexGrid); }

    public WebElement getLoadingImage() { return findWebElement(loadingImage); }

    public WebElement getProductColumn() { return findWebElement(productColumn); }

    public WebElement getDescriptionColumn() { return findWebElement(descriptionColumn); }

    public WebElement getOrderedColumn() { return findWebElement(orderedColumn); }

    public WebElement getStagedColumn() { return findWebElement(stagedColumn); }

    public WebElement getReceivedColumn() { return findWebElement(receivedColumn); }

    public WebElement getGtinColumn() { return findWebElement(gtinColumn); }

    public WebElement getExpDateColumn() { return findWebElement(expDateColumn); }

    public WebElement getDateCodeColumn() { return findWebElement(dateCodeColumn); }

    public WebElement getQualifier1Column() { return findWebElement(qualifier1Column); }

    public WebElement getQualifier2Column() { return findWebElement(qualifier2Column); }

    public WebElement getQualifier3Column() { return findWebElement(qualifier3Column); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getReviewOrderLabel() { return findWebElement(reviewOrderLabel); }

    public WebElement getBtnReviewCancel() { return findWebElement(btnReviewCancel); }

    public WebElement getBtnReviewSave() { return findWebElement(btnReviewSave); }

    public WebElement getEnterProduct() { return findWebElement(enterProduct); }

    public WebElement getReopenOrderStatus() { return findWebElement(reopenOrderStatus); }

    public WebElement getReadyToReceiveStatus() { return findWebElement(readyToReceiveStatus); }

    public WebElement getCancelStatus() { return findWebElement(cancelStatus); }

    public WebElement getStatusCellContent() { return findWebElement(statusCellContent); }

    public WebElement getFinishReceivingOrderStatus() { return findWebElement(finishReceivingOrderStatus); }

    public WebElement getCarrierDropdown(String carrier) { return findWebElement(getCarrier(carrier)); }

    public WebElement getOwnerDropdown(String owner) { return findWebElement(getOwner(owner)); }

    public WebElement getStatusDropDown(String status) { return findWebElement(getStatus(status)); }

    public WebElement getReceivedQty() { return findWebElement(receivedQty); }

    public WebElement getStagedQty() { return findWebElement(stagedQty); }

    public WebElement getRedQty() { return findWebElement(redQty); }

    public WebElement getGrayQty() { return findWebElement(grayQty); }

    public WebElement getSourceOrderType() { return findWebElement(sourceOrderTypeColumn); }

    public WebElement getSourceOrder() { return findWebElement(sourceOrderColumn); }

    public WebElement getSourceStatus() { return findWebElement(sourceStatusColumn); }

    public WebElement getScheduledDateLabel() { return findWebElement(scheduledDateLabel); }

    public WebElement getScheduledDate() { return findWebElement(scheduledDate); }

    public WebElement getCarrierLabel() { return findWebElement(carrierLabel); }

    public WebElement getCarrierInput() { return findWebElement(carrierInput); }

    public WebElement getTrailerLabel() { return findWebElement(trailerLabel); }

    public WebElement getTrailerInput() { return findWebElement(trailerInput); }

    public WebElement getScheduledTimeLabel() { return findWebElement(scheduledTimeLabel); }

    public WebElement getScheduledTimeInput() { return findWebElement(scheduledTimeInput); }

    public WebElement getPaymentTypeLabel() { return findWebElement(paymentTypeLabel); }

    public WebElement getPaymentTypeInput() { return findWebElement(paymentTypeInput); }

    public WebElement getCommentsLabel() { return findWebElement(commentsLabel); }

    public WebElement getCommentsInput() { return findWebElement(commentsInput); }

    public WebElement getTemperatureLabel() { return findWebElement(temperatureLabel); }

    public WebElement getTemperatureInput() { return findWebElement(temperatureInput); }

    public WebElement getSealNumberLabel() { return findWebElement(sealNumberLabel); }

    public WebElement getSealNumberInput() { return findWebElement(sealNumberInput); }

    public List<WebElement> getCommentsLabels() { return findWebElements(commentsLabels); }

    public List<WebElement> getCommentsInputs() { return findWebElements(commentsInputs); }

    public List<WebElement> getYesRadioButtons() { return findWebElements(yesRadioButtons); }

    public List<WebElement> getNoRadioButtons() { return findWebElements(noRadioButtons); }

    public WebElement getBtnAddProductCancel() { return findWebElement(btnAddProductCancel); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getDateTimeCheckBox() { return findWebElement(dateTimeCheckBox); }

    public WebElement getFromStatusCheckBox() { return findWebElement(fromStatusCheckBox); }

    public WebElement getToStatusCheckBox() { return findWebElement(toStatusCheckBox); }

    public WebElement getUserCheckBox() { return findWebElement(userCheckBox); }

    public WebElement getMoveShipDate() { return findWebElement(moveShipDate); }

    public WebElement getMoveShipDateInput() { return getDriver().findElement(moveShipDateInput); }

    public WebElement getLoadInput() { return findWebElement(loadInput); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getInboundImageCaptureButton() { return findWebElement(inboundImageCaptureButton); }

    public WebElement getSelectFilesBtn() { return findWebElement(selectFilesBtn); }

    public WebElement getSaveEditButton() { return findWebElement(saveEditButton); }

    public WebElement getLoadImageLabel() { return findWebElement(loadImageLabel); }

    public WebElement getDialogContent() { return findWebElement(dialogContent); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
