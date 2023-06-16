package ui.pages.inbound.inboundorders;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;

import java.util.List;

public class InboundOrderDetailsPage extends BasePage {

    By topIcon = By.xpath("//span[contains(text(), 'Inbound order summary')]");
    By toolBarContainer = By.cssSelector(".i-toolbar-container");
    By barContainer = By.cssSelector(".BarsContainer");
    By orderLabel = By.xpath("//span[contains(text(), 'Order')]");
    By orderDet = By.cssSelector("#spnOrderNo");
    By productList = By.cssSelector("#crdInboundOrderPortrait .BarsBlock");
    By orderNumber = By.xpath("//span[contains(text(),'Order')]//following-sibling::span[@id='spnOrderNo']");
    By ownerField = By.xpath("//span[contains(text(), 'Owner')]");
    By sourceField = By.xpath("//span[contains(text(), 'Source')]");
 //   By loadNumber = By.xpath("//span[contains(text(),'Load')]//following-sibling::span");
    By doorField = By.xpath("//span[contains(text(), 'Door')]");
    By qaField = By.xpath("//span[contains(text(), 'QA')]");
    By carrierField = By.xpath("//span[contains(text(), 'Carrier')]");
    By loadField = By.xpath("//span[contains(text(), 'Load')]");
    By qtyField = By.xpath("//span[contains(text(), 'Qty')]");
    By cubeField = By.xpath("//span[contains(text(), 'Cube')]");
    By weightField = By.xpath("//span[contains(text(), 'Weight')]");
    By changeStatusOption = By.id("btnChangeStatus");
    By doorOption = By.id("ddDoorItem");
    By dataOption = By.id("ddDataItem");
    By statusInput = By.id("span_Status");
    By orderOptionsButton = By.cssSelector("button[aria-label='Order options dropdownbutton']");
    By orderStatus = By.id("span_Status");
    By sourceLabel = By.xpath("//span[contains(text(), 'Source')]");
    By imagesButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Images')]");
    By commentsButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Comments')]");
    By toolBar = By.cssSelector(".i-toolbar-container__summary");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By reopenOrderStatus = By.cssSelector("input[value='Reopen Order']");
    By finishReceivingOrderStatus = By.cssSelector("input[value='Finish Receiving']");
    By readyToReceiveStatus = By.cssSelector("input[value='Ready To Receive']");
    By dialogPopup = By.cssSelector(".k-dialog-title");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By sourceOrderTypeColumn = By.xpath("//span[text()='Order type']");
    By sourceOrderColumn = By.xpath("//span[text()='Order no.']");
    By sourceStatusColumn = By.xpath("//span[text()='Status']");
    By routeBackButton = By.id("RouteBackButton");
    By noButton = By.xpath("//button[contains(text(), 'No')]");
    By yesButton = By.xpath("//button[contains(text(), 'Yes')]");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By tableContent = By.cssSelector(".k-grid-container");
    By receivedQty = By.xpath("//span[contains(@class, 'dot--green')]/following-sibling::span[contains(text(), 'Received')]");
    By stagedQty = By.xpath("//span[contains(@class, 'dot--yellow')]/following-sibling::span[contains(text(), 'Staged')]");
    By redQty = By.xpath("//span[contains(@class, 'dot--red')]/following-sibling::span[contains(text(), 'Over')]");
    By grayQty = By.xpath("//span[contains(@class, 'dot--gray')]/following-sibling::span[contains(text(), 'Remainder')]");
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
    By moveShipDate = By.id("moveStartDate-label");
    By moveShipDateInput = By.id("moveStartDate");
    By moveLoad = By.id("OrderSummaryMove__loadrouteTxtBox-label");
    By moveLoadInput = By.id("OrderSummaryMove__loadrouteTxtBox");
    By orderProducts = By.cssSelector("#crdInboundOrderPortrait .BarsBlock");
    By orderLineItems = By.cssSelector("#crdInboundOrderPortrait .BarsContainer");
    By btnProductData = By.id("btnProductData");
    By btnProductEdit = By.id("btnProductEdit");
    By btnOrderLineFieldsImage = By.id("btnOrderLineFieldsImage");
    By saveEditButton = By.id("saveEditButton");
    By inboundImageCaptureButton = By.cssSelector(".inboundImageCaptureOpButtonDiv button");
    By selectFilesBtn = By.xpath("//div[@aria-label='Select files']");
    By loadImageLabel = By.xpath("//span[text()='Load image(s)']");
    By orderLocationLink = By.xpath("//td[contains(@id, 'orderLocationlink')]//a");
    By locationColumn = By.xpath("//table[@role='presentation']//span[text() ='Location']");
    By locationTypeColumn = By.xpath("//table[@role='presentation']//span[text() ='Location type']");
    By qtyColumn = By.xpath("//table[@role='presentation']//span[text() ='Qty']");
    By uomColumn = By.xpath("//table[@role='presentation']//span[text() ='UOM']");
    By lotColumn = By.xpath("//table[@role='presentation']//span[text() ='Lot']");
    By expDateColumn = By.xpath("//table[@role='presentation']//span[text() ='Exp date']");
    By statusColumn = By.xpath("//table[@role='presentation']//span[text() ='Status']");
    By weightColumn = By.xpath("//table[@role='presentation']//span[text() ='Weight']");
    By stagedColumn = By.xpath("//table[@role='presentation']//span[text() ='Staged?']");

    private By getStatus(String status) {
        return By.xpath("//span[@class='k-input' and text()='" + status + "']");
    }

    private By getDoorDropDown(String door) { return By.xpath("//span[contains(text(),'" + door + "')]"); }

    public void waitInboundOrderDetailsPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitABit(6000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getTopIcon());
        Waiters.waitForElementToBeDisplay(toolBarContainer);
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(itemsFoundLabel);
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(itemsFoundValue);
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

    public boolean isMoveLoadDisplayed() {
        Waiters.waitForElementToBeDisplay(getMoveLoad());
        return isElementDisplay(getMoveLoad());
    }

    public boolean isMoveLoadInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getMoveLoadInput());
        return isElementDisplay(getMoveLoadInput());
    }

    public String getItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundValue);
    }

    public void selectOrderOption(String option) {
        Waiters.waitForElementToBeDisplay(getOrderOptionsButton());
        Waiters.waitABit(1000);
        clickOnElement(getOrderOptionsButton());
        WebElement orderOption = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + option + "')]"));
        clickOnElement(orderOption);
    }

    public void selectOrderStatus(String status) {
        WebElement orderStatus = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "')]"));
        clickOnElement(orderStatus);
        Waiters.waitABit(2000);
    }

    public void selectOrderByOrderNumber(int orderNum) {
        Waiters.waitABit(1000);
        Waiters.waitForPresenceOfElement(tableContent);
        List<WebElement> orders = getTableContent().findElements(By.xpath(".//div[contains(@class, 'BarsBlock')]"));
        Waiters.waitForElementToBeDisplay(orders.get(orderNum));
        clickOnElement(orders.get(orderNum));
        Waiters.waitABit(1000);
    }

    public void clickOrderStatus(String status) {
        Waiters.waitABit(4000);
        clickOnElement(getStatusDropDown(status));
        Waiters.waitABit(2000);
    }

    public void selectOption(String option) {
        clickOnElement(findWebElements(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                        + option + "') and @role='option']"))
                .stream().findFirst().get());
        Waiters.waitABit(2000);
    }

    public void typeShipDate(String date) {
        Waiters.waitABit(1000);
        Waiters.waitForElementToBeDisplay(getMoveShipDateInput());
        clickOnElement(getMoveShipDateInput());
        pressDelete(getMoveShipDateInput());
        inputText(getMoveShipDateInput(), date);
        pressEnter(getMoveShipDateInput());
        Waiters.waitABit(2000);
    }

    public void typeLoad(String load) {
        Waiters.waitABit(2000);
        typeText(getMoveLoadInput(), load);
        Waiters.waitABit(2000);
        pressTab(getMoveLoadInput());
    }

    public void clickChangeStatusOption() {
        Waiters.waitABit(2000);
        clickOnElement(getChangeStatusOption());
        Waiters.waitABit(2000);
    }

    public void clickDoorOption() {
        Waiters.waitABit(2000);
        clickOnElement(getDoorOption());
        Waiters.waitABit(2000);
    }

    public void clickDataOption() {
        Waiters.waitABit(2000);
        clickOnElement(getDataOption());
        Waiters.waitABit(2000);
    }

    public void selectDoorDropDown(String door) {
        Waiters.waitABit(2000);
        clickOnElement(getDoorDropDown(door));
        Waiters.waitABit(2000);
    }

    public void clickDoorDropdown() {
        Waiters.waitABit(2000);
        clickOnElement(By.id("ddDoorList"));
        Waiters.waitABit(2000);
    }

    public void clickCancel() {
        Waiters.waitABit(2000);
        clickOnElement(cancelButton);
        Waiters.waitABit(2000);
    }

    public void clickSave() {
        Waiters.waitABit(2000);
        clickOnElement(saveButton);
        Waiters.waitABit(1000);
    }

    public void clickRouteBackButton() {
        clickOnElement(routeBackButton);
        Waiters.waitABit(2000);
    }

    public String getDialogPopUpText() {
        Waiters.waitForPresenceOfElement(".k-dialog-title");
        return getText(getDialogPopup());
    }

    public void clickAddFilter() {
        Waiters.waitForElementToBeClickable(getAddFilterButton());
        clickOnElement(getAddFilterButton());
        Waiters.waitABit(3000);
    }

    public void clickOrderProductByNumber(int num) {
        Waiters.waitABit(2000);
        clickOnElement(getOrderProducts().get(num));
        Waiters.waitABit(1000);
    }

    public void clickOrderLineItemByNumber(int num) {
        Waiters.waitABit(2000);
        clickOnElement(getOrderLineItems().get(num));
        Waiters.waitABit(1000);
    }

    public void clickProductDataBtn() {
        Waiters.waitForElementToBeDisplay(btnProductData);
        clickOnElement(btnProductData);
    }

    public void clickProductEditBtn() {
        Waiters.waitForElementToBeDisplay(btnProductEdit);
        clickOnElement(btnProductEdit);
    }

    public void clickOrderLineFieldsImageBtn() {
        Waiters.waitForElementToBeDisplay(btnOrderLineFieldsImage);
        clickOnElement(btnOrderLineFieldsImage);
        Waiters.waitABit(2000);
    }

    public boolean isTopIconDisplayed() {  return isElementDisplay(getTopIcon()); }

    public boolean isOrderOptionsButtonDisplayed() {  return isElementDisplay(getOrderOptionsButton()); }

    public boolean isOrderStatusDisplayed() {  return isElementDisplay(getOrderStatus()); }

    public boolean isOrderNumberDisplayed() {  return isElementDisplay(getOrderNumber()); }

    public boolean isSourceLabelDisplayed() {  return isElementDisplay(getSourceLabel()); }

    public boolean isImagesButtonDisplayed() {  return isElementDisplay(getImagesButton()); }

    public boolean isCommentsButtonDisplayed() {  return isElementDisplay(getCommentsButton()); }

    public boolean isToolBarDisplayed() {  return isElementDisplay(getToolBar()); }

    public boolean isToolBarContainerPresent() { return isElementPresent(getToolBarContainer()); }

    public boolean isBarContainerPresent() { return isElementPresent(getBarContainer()); }

    public boolean isOrderLabelPresent() { return isElementPresent(getOrderLabel()); }

    public boolean isOrderDetailsPresent() { return isElementPresent(getOrderDet()); }

 //   public boolean isLoadNumberDisplayed() {  return isElementDisplay(getLoadNumber()); }

    public boolean isDoorFieldDisplayed() {  return isElementDisplay(getDoorField()); }

    public boolean isQaFieldDisplayed() {  return isElementDisplay(getQaField()); }

    public int isProductListDisplayed() { return elementsArePresent(getProductList()); }

    public boolean isOwnerFieldDisplayed() { return isElementDisplay(getOwnerField()); }

    public boolean isCarrierFieldDisplayed() { return isElementDisplay(getCarrierField()); }

    public boolean isLoadFieldDisplayed() { return isElementDisplay(getLoadField()); }

    public boolean isSourceFieldDisplayed() { return isElementDisplay(getSourceField()); }

    public boolean isQtyFieldDisplayed() { return isElementDisplay(getQtyField()); }

    public boolean isCubeFieldDisplayed() { return isElementDisplay(getCubeField()); }

    public boolean isWeightFieldDisplayed() { return isElementDisplay(getWeightField()); }

    public boolean isChangeStatusOptionDisplayed() { return isElementDisplay(getChangeStatusOption()); }

    public boolean isDoorOptionDisplayed() { return isElementDisplay(getDoorOption()); }

    public boolean isDataOptionDisplayed() { return isElementDisplay(getDataOption()); }

    public boolean isStatusInputDisplayed() { return isElementDisplay(getStatusInput()); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

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

    public boolean isSaveButtonDisabled() { return getElementAttribute(getSaveButton(),
            "class").contains("disabled"); }

    public boolean isSaveEditButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getSaveEditButton());
        return isElementDisplay(getSaveEditButton());
    }

    public boolean isInboundImageCaptureButtonDisplayed() {
        Waiters.waitForElementToBeDisplay(getInboundImageCaptureButton());
        return isElementDisplay(getInboundImageCaptureButton());
    }

    public boolean isSelectFilesBtnDisplayed() {
        Waiters.waitForElementToBeDisplay(getSelectFilesBtn());
        return isElementDisplay(getSelectFilesBtn());
    }

    public boolean isLoadImageLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getLoadImageLabel());
        return isElementDisplay(getLoadImageLabel());
    }

    public WebElement getTopIcon() { return findWebElement(topIcon); }

    public WebElement getOrderOptionsButton() { return findWebElement(orderOptionsButton); }

    public WebElement getOrderStatus() { return findWebElement(orderStatus); }

    public WebElement getOrderNumber() { return findWebElement(orderNumber); }

    public WebElement getSourceLabel() { return findWebElement(sourceLabel); }

    public WebElement getImagesButton() { return findWebElement(imagesButton); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getCommentsButton() { return findWebElement(commentsButton); }

    public WebElement getToolBar() { return findWebElement(toolBar); }

    public WebElement getToolBarContainer() { return findWebElement(toolBarContainer); }

    public WebElement getBarContainer() { return findWebElement(barContainer); }

    public WebElement getOrderLabel() { return findWebElement(orderLabel); }

    public WebElement getOrderDet() { return findWebElement(orderDet); }

    public List<WebElement> getProductList() { return findWebElements(productList); }

    public WebElement getOwnerField() { return findWebElement(ownerField); }

    public WebElement getSourceField() { return findWebElement(sourceField); }

//    public SelenideElement getLoadNumber() { return $(loadNumber); }

    public WebElement getDoorField() { return findWebElement(doorField); }

    public WebElement getQaField() { return findWebElement(qaField); }

    public WebElement getCarrierField() { return findWebElement(carrierField); }

    public WebElement getLoadField() { return findWebElement(loadField); }

    public WebElement getQtyField() { return findWebElement(qtyField); }

    public WebElement getCubeField() { return findWebElement(cubeField); }

    public WebElement getWeightField() { return findWebElement(weightField); }

    public WebElement getChangeStatusOption() { return findWebElement(changeStatusOption); }

    public WebElement getDoorOption() { return findWebElement(doorOption); }

    public WebElement getDataOption() { return findWebElement(dataOption); }

    public WebElement getStatusInput() { return findWebElement(statusInput); }

    public WebElement getReopenOrderStatus() { return findWebElement(reopenOrderStatus); }

    public WebElement getReadyToReceiveStatus() { return findWebElement(readyToReceiveStatus); }

    public WebElement getFinishReceivingOrderStatus() { return findWebElement(finishReceivingOrderStatus); }

    public WebElement getDialogPopup() { return findWebElement(dialogPopup); }

    public WebElement getStatusDropDown(String status) { return findWebElement(getStatus(status)); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

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

    public WebElement getDateTimeCheckBox() { return findWebElement(dateTimeCheckBox); }

    public WebElement getFromStatusCheckBox() { return findWebElement(fromStatusCheckBox); }

    public WebElement getToStatusCheckBox() { return findWebElement(toStatusCheckBox); }

    public WebElement getUserCheckBox() { return findWebElement(userCheckBox); }

    public WebElement getMoveShipDate() { return findWebElement(moveShipDate); }

    public WebElement getMoveShipDateInput() { return findWebElement(moveShipDateInput); }

    public WebElement getMoveLoad() { return findWebElement(moveLoad); }

    public WebElement getMoveLoadInput() { return findWebElement(moveLoadInput); }

    public List<WebElement> getOrderProducts() { return findWebElements(orderProducts); }

    public List<WebElement> getOrderLineItems() { return findWebElements(orderLineItems); }

    public WebElement getBtnProductData() { return findWebElement(btnProductData); }

    public WebElement getBtnProductEdit() { return findWebElement(btnProductEdit); }

    public WebElement getBtnOrderLineFieldsImage() { return findWebElement(btnOrderLineFieldsImage); }

    public WebElement getSaveEditButton() { return findWebElement(saveEditButton); }

    public WebElement getInboundImageCaptureButton() { return findWebElement(inboundImageCaptureButton); }

    public WebElement getSelectFilesBtn() { return findWebElement(selectFilesBtn); }

    public WebElement getLoadImageLabel() { return findWebElement(loadImageLabel); }

}
