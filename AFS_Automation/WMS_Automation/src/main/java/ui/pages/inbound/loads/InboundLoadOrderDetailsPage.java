package ui.pages.inbound.loads;

import common.utils.Waiters;
import objects.productdata.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static common.setup.DriverManager.getDriver;

public class InboundLoadOrderDetailsPage extends BasePage {
    By topIcon = By.xpath("//span[contains(text(), 'Inbound load summary')]");
    By loadCards = By.cssSelector(".i-card__card .i-card__card");
    By toolBarContainer = By.cssSelector(".i-toolbar-container");
    By barContainer = By.cssSelector(".BarsContainer");
    By orderDet = By.cssSelector("#spnOrderNo");
    By productList = By.cssSelector("#crdInboundOrderPortrait .BarsBlock");
    By orderOption = By.cssSelector("button[aria-label='Order options dropdownbutton']");
    By invalidEntryPopup = By.cssSelector(".k-window-title");
    By okButton = By.xpath("//button[contains(text(), 'Ok')]");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By backButton = By.cssSelector("#RouteBackButton");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By noButton = By.xpath("//button[contains(text(), 'No')]");
    By yesButton = By.xpath("//button[contains(text(), 'Yes')]");
    By orderLoadNumber = By.xpath("//span[contains(text(), 'Order')]//following-sibling::span[contains(@id, 'spnOrderNo')]");
    By ownerField = By.xpath("//span[contains(text(), 'Owner')]");
    By customerField = By.xpath("//span[contains(text(), 'Customer')]");
    By sourceField = By.xpath("//span[contains(text(), 'Source')]");
    By loadNumber = By.cssSelector("#spnRouteCodeNo");
    By doorField = By.xpath("//span[contains(text(), 'Door')]");
    By qaField = By.xpath("//span[contains(text(), 'QA')]");
    By trailerField = By.xpath("//span[contains(text(), 'Trailer')]");
    By carrierField = By.xpath("//span[contains(text(), 'Carrier')]");
    By loadField = By.xpath("//span[contains(text(), 'Load')]");
    By ordersField = By.xpath("//span[contains(text(), 'Orders')]");
    By qtyField = By.xpath("//span[contains(text(), 'Qty')]");
    By cubeField = By.xpath("//span[contains(text(), 'Cube')]");
    By weightField = By.xpath("//span[contains(text(), 'Weight')]");
    By imagesButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Images')]");
    By commentsButton = By.xpath("//button[@id='btnImageNo' and contains(text(), 'Comments')]");
    By changeStatusOption = By.id("btnChangeStatus");
    By doorOption = By.id("ddDoorItem");
    By dataOption = By.id("ddDataItem");
    By statusInput = By.id("span_Status");
    By orderOptionButton = By.cssSelector("button[aria-label='Order options dropdownbutton']");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By windowTitle = By.cssSelector(".k-window-title");
    By dialogPopup = By.cssSelector(".k-dialog-title");
    By dialogContent = By.cssSelector(".k-dialog-content");
    By dialogTextContent = By.id("dialogTextContent");
    By reopenOrderStatus = By.cssSelector("input[value='Reopen Order']");
    By finishReceivingOrderStatus = By.cssSelector("input[value='Finish Receiving']");
    By readyToReceiveStatus = By.cssSelector("input[value='Ready To Receive']");
    By statusCellContent = By.cssSelector(".i-status-cell__content");
    By receivedQty = By.xpath("//span[contains(@class, 'dot--green')]/following-sibling::span[contains(text(), 'Received')]");
    By stagedQty = By.xpath("//span[contains(@class, 'dot--yellow')]/following-sibling::span[contains(text(), 'Staged')]");
    By redQty = By.xpath("//span[contains(@class, 'dot--red')]/following-sibling::span[contains(text(), 'Over')]");
    By grayQty = By.xpath("//span[contains(@class, 'dot--gray')]/following-sibling::span[contains(text(), 'Remainder')]");
    By sourceOrderTypeColumn = By.xpath("//span[text()='Order type']");
    By sourceOrderColumn = By.xpath("//span[text()='Order no.']");
    By sourceStatusColumn = By.xpath("//span[text()='Status']");
    By loadCodeLabel = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Load code']]");
    By loadCodeInput = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Load code']]//input");
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
    By doorLabel = By.xpath("//label[contains(text(), 'Door')]");
    By doorInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Door')]]//span[@class='k-input']");
    By loadTypeLabel = By.xpath("//label[contains(text(), 'Load type')]");
    By loadTypeInput = By.xpath("//span[contains(@class, 'k-textbox-container')][.//label[contains(text(), 'Load type')]]//span[@class='k-input']");
    By driverLabel = By.xpath("//label[contains(text(), 'Driver')]");
    By driverInput = By.xpath("//div[contains(@class,'k-textbox-container')][.//label[text()='Driver']]//input");
    By temperatureField = By.xpath("//span[contains(@class,'k-textbox-container')][.//label[text()='Temperature']]//input");
    By notificationMsg = By.cssSelector(".toast-message");
    By receiverDateColumn = By.xpath("//span[text()='Date']");
    By receiverFromStatusColumn = By.xpath("//span[text()='From status']");
    By receiverToStatusColumn = By.xpath("//span[text()='To status']");
    By receiverUserColumn = By.xpath("//span[text()='User']");
    By moveShipDate = By.id("moveStartDate-label");
    By moveShipDateInput = By.id("moveStartDate");
    By loadInput = By.id("OrderSummaryMove__loadrouteTxtBox");
    By orderProducts = By.xpath("//div[contains(@class, 'BarsBlock')]//span[contains(@id, 'spnOrderSource')]");
    By btnProductData = By.id("btnProductData");
    By btnProductEdit = By.id("btnProductEdit");
    By saveEditButton = By.id("saveEditButton");
    By inboundImageCaptureButton = By.cssSelector(".inboundImageCaptureOpButtonDiv button");
    By selectFilesBtn = By.xpath("//div[@aria-label='Select files']");
    By loadImageLabel = By.xpath("//span[text()='Load image(s)']");
    By temperatureLabel = By.xpath("//label[text()='Temperature']");
    By temperatureInput = By.xpath("//label[text()='Temperature']//following-sibling::input");
    By sealNumberLabel = By.xpath("//label[text()='Seal Number']");
    By sealNumberInput = By.xpath("//label[text()='Seal Number']//following-sibling::input");
    By commentsLabels = By.xpath("//label[text()='Comments']");
    By commentsInputs = By.xpath("//label[text()='Comments']//following-sibling::input");
    By yesRadioButtons = By.xpath("//label[text()='Yes']//preceding-sibling::input");
    By noRadioButtons = By.xpath("//label[text()='No']//preceding-sibling::input");
    By btnAddProductCancel = By.id("btnAddProductCancel");
    By loader = By.cssSelector(".loader");

    public void waitForInboundLoadOrderDetailsPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getTopIcon());
        Waiters.waitForElementToBeDisplay(getOrderOption());
    }

    public boolean isToolBarContainerPresent() { return isElementPresent(getToolBarContainer()); }

    public boolean isBarContainerPresent() { return isElementPresent(getBarContainer()); }

    public boolean isOrderOptionPresent() {
        return isElementPresent(getOrderOption());
    }

    public boolean isOrderDetailsPresent() { return isElementPresent(getOrderDet());  }

    public boolean isDoorFieldDisplayed() {  return isElementDisplay(getDoorField());  }

    public boolean isQaFieldDisplayed() {  return isElementDisplay(getQaField());  }

    public boolean isOwnerFieldDisplayed() { return isElementDisplay(getOwnerField()); }

    public boolean isCustomerFieldDisplayed() { return isElementDisplay(getCustomerField()); }

    public boolean isCarrierFieldDisplayed() { return isElementDisplay(getCarrierField()); }

    public boolean isLoadFieldDisplayed() { return isElementDisplay(getLoadField()); }

    public boolean isSourceFieldDisplayed() { return isElementDisplay(getSourceField()); }

    public boolean isQtyFieldDisplayed() { return isElementDisplay(getQtyField()); }

    public boolean isCubeFieldDisplayed() { return isElementDisplay(getCubeField()); }

    public boolean isWeightFieldDisplayed() { return isElementDisplay(getWeightField()); }

    public boolean isOrderListPresent() {
        return (getProductList().size() != 0);
    }

    public boolean isItemsFoundLabelDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(itemsFoundLabel);
    }

    public boolean isItemsFoundValueDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(itemsFoundValue);
    }

    public boolean isCommentsButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getCommentsButton());
    }

    public boolean isImagesButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(getImagesButton());
    }

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

    public boolean isYesButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(yesButton);
    }

    public boolean isNoButtonDisplayed() {
        Waiters.waitABit(2000);
        return isElementDisplay(noButton);
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

    public boolean isPaymentTypeLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getPaymentTypeLabel());
        return isElementDisplay(getPaymentTypeLabel());
    }

    public boolean isPaymentTypeInputDisplayed() {
        Waiters.waitForElementToBeDisplay(getPaymentTypeInput());
        return isElementDisplay(getPaymentTypeInput());
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

    public boolean isSaveButtonDisabled() { return getElementAttribute(getSaveButton(),
            "class").contains("disabled"); }

    public String getDialogPopUpContentText() {
        Waiters.waitABit(2000);
        return getText(getDialogContent());
    }

    public String getWindowTitleText() {
        Waiters.waitForElementToBeDisplay(windowTitle);
        return getText(windowTitle);
    }

    public String getPopupTitleText() {
        Waiters.waitForElementToBeDisplay(getDialogPopup());
        return getText(getDialogPopup());
    }

    public String getItemsFoundText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundValue);
    }

    public String getStatusCellContentText() {
        Waiters.waitForElementToBeDisplay(statusCellContent);
        return getText(getStatusCellContent());
    }

    public List<ProductData> getProductDetails() {
      List<ProductData> productData = null;
      List<List<String>> details = getProductList().stream()
               .map(WebElement::getText)
               .map(detail -> detail.split("\\n"))
               .map(element -> Arrays.asList(element))
               .collect(Collectors.toList());
        productData = details.stream().map(detail -> {
            return ProductData.builder()
                    .productCode(detail.get(0))
                    .productDescription(detail.get(1))
                    .productAmount(detail.get(2))
                    .build();
        }).collect(Collectors.toList());
      return productData;
    }

    public void selectOrderOption(String option) {
        Waiters.waitForElementToBeDisplay(getOrderOption());
        Waiters.waitABit(2000);
        clickOnElement(getOrderOption());
        WebElement orderOption = findWebElements(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + option + "') and @role='menuItem']"))
                .stream()
                .findFirst()
                .get();
        clickOnElement(orderOption);
        Waiters.waitABit(2000);
    }

    public void selectOption(String option) {
        clickOnElement(findWebElements(By
                .xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                        + option + "') and @role='option']"))
                .stream().findFirst().get());
        Waiters.waitABit(2000);
    }

    public void clickOkButton() {
        Waiters.waitForElementToBeDisplay(getOkButton());
        clickOnElement(getOkButton());
    }

    public void clickBackButton() {
        waitUntilInvisible(2, loader);
        Waiters.waitForElementToBeDisplay(getBackButton());
        clickOnElement(getBackButton());
        waitUntilInvisible(2, loader);
    }

    public void clickSaveButton() {
        Waiters.waitForElementToBeDisplay(getSaveButton());
        clickOnElement(getSaveButton());
        if(isVisible(noButton)) {
            clickOnElement(noButton);
        }
    }

    public void clickNoButton() {
        clickOnElement(noButton);
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
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDataOption());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickCancel() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(cancelButton);
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickDoorDropdown() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(By.id("ddDoorList"));
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void clickBtnAddProductCancel() {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getBtnAddProductCancel());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public void typeShipDate(String date) {
        Waiters.waitABit(4000);
        typeText(getMoveShipDateInput(), date);
        Waiters.waitABit(2000);
        pressTab(getMoveShipDateInput());
    }

    public void typeLoad(String load) {
        Waiters.waitTillLoadingPage(getDriver());
        typeText(getLoadInput(), load);
        Waiters.waitTillLoadingPage(getDriver());
        pressTab(getLoadInput());
    }

    public void clickOrderProductByNumber(int num) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getOrderProducts().get(num));
        waitUntilInvisible(1, loader);
    }

    public void clickProductDataBtn() {
        Waiters.waitForElementToBeDisplay(btnProductData);
        clickOnElement(getBtnProductData());
    }

    public void clickProductEditBtn() {
        Waiters.waitForElementToBeDisplay(btnProductEdit);
        clickOnElement(getBtnProductEdit());
    }

    public void clickImagesButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getImagesButton());
        clickOnElement(getImagesButton());
        Waiters.waitTillLoadingPage(getDriver());
    }

    public boolean isInvalidEntryPopUpPresent() {
        return isElementPresent(getInvalidEntryPopup());
    }

    public String getDialogPopUpText() {
        Waiters.waitForElementToBeDisplay(By.cssSelector(".k-dialog-title"));
        return getText(getDialogPopup());
    }

    public WebElement getTopIcon() { return findWebElement(topIcon); }

    public List<WebElement> getLoadCards() { return findWebElements(loadCards); }

    public WebElement getToolBarContainer() { return findWebElement(toolBarContainer); }

    public WebElement getBarContainer() { return findWebElement(barContainer); }

    public WebElement getOrderDet() { return findWebElement(orderDet); }

    public List<WebElement> getProductList() { return findWebElements(productList); }

    public WebElement getOrderOption() { return findWebElement(orderOption); }

    public WebElement getInvalidEntryPopup() { return findWebElement(invalidEntryPopup); }

    public WebElement getOkButton() { return findWebElement(okButton); }

    public WebElement getBackButton() { return findWebElement(backButton); }

    public WebElement getSaveButton() { return findWebElement(saveButton); }

    public WebElement getOrderLoadNumber() { return findWebElement(orderLoadNumber); }

    public WebElement getOwnerField() { return findWebElement(ownerField); }

    public WebElement getCustomerField() { return findWebElement(customerField); }

    public WebElement getSourceField() { return findWebElement(sourceField); }

    public WebElement getLoadNumber() { return findWebElement(loadNumber); }

    public WebElement getDoorField() { return findWebElement(doorField); }

    public WebElement getQaField() { return findWebElement(qaField); }

    public WebElement getTrailerField() { return findWebElement(trailerField); }

    public WebElement getCarrierField() { return findWebElement(carrierField); }

    public WebElement getLoadField() { return findWebElement(loadField); }

    public WebElement getOrdersField() { return findWebElement(ordersField); }

    public WebElement getQtyField() { return findWebElement(qtyField); }

    public WebElement getCubeField() { return findWebElement(cubeField); }

    public WebElement getWeightField() { return findWebElement(weightField); }

    public WebElement getImagesButton() { return findWebElement(imagesButton); }

    public WebElement getCommentsButton() { return findWebElement(commentsButton); }

    public WebElement getChangeStatusOption() { return findWebElement(changeStatusOption); }

    public WebElement getDoorOption() { return findWebElement(doorOption); }

    public WebElement getDataOption() { return findWebElement(dataOption); }

    public WebElement getStatusInput() { return findWebElement(statusInput); }

    public WebElement getOrderOptionButton() { return findWebElement(orderOptionButton); }

    public WebElement getDialogPopup() { return findWebElement(dialogPopup); }

    public WebElement getDialogContent() { return findWebElement(dialogContent); }

    public WebElement getWindowTitle() { return findWebElement(windowTitle); }

    public WebElement getReopenOrderStatus() { return findWebElement(reopenOrderStatus); }

    public WebElement getReadyToReceiveStatus() { return findWebElement(readyToReceiveStatus); }

    public WebElement getStatusCellContent() { return findWebElement(statusCellContent); }

    public WebElement getFinishReceivingOrderStatus() { return findWebElement(finishReceivingOrderStatus); }

    public WebElement getReceivedQty() { return findWebElement(receivedQty); }

    public WebElement getStagedQty() { return findWebElement(stagedQty); }

    public WebElement getRedQty() { return findWebElement(redQty); }

    public WebElement getGrayQty() { return findWebElement(grayQty); }

    public WebElement getSourceOrderType() { return findWebElement(sourceOrderTypeColumn); }

    public WebElement getSourceOrder() { return findWebElement(sourceOrderColumn); }

    public WebElement getSourceStatus() { return findWebElement(sourceStatusColumn); }

    public WebElement getLoadCodeLabel() { return findWebElement(loadCodeLabel); }

    public WebElement getLoadCodeInput() { return findWebElement(loadCodeInput); }

    public WebElement getScheduledDateLabel() { return findWebElement(scheduledDateLabel); }

    public WebElement getScheduledDate() { return findWebElement(scheduledDate); }

    public WebElement getCarrierLabel() { return findWebElement(carrierLabel); }

    public WebElement getCarrierInput() { return findWebElement(carrierInput); }

    public WebElement getTrailerLabel() { return findWebElement(trailerLabel); }

    public WebElement getTrailerInput() { return findWebElement(trailerInput); }

    public WebElement getPaymentTypeLabel() { return findWebElement(paymentTypeLabel); }

    public WebElement getPaymentTypeInput() { return findWebElement(paymentTypeInput); }

    public WebElement getDoorLabel() { return findWebElement(doorLabel); }

    public WebElement getDoorInput() { return findWebElement(doorInput); }

    public WebElement getLoadTypeLabel() { return findWebElement(loadTypeLabel); }

    public WebElement getLoadTypeInput() { return findWebElement(loadTypeInput); }

    public WebElement getScheduledTimeLabel() { return findWebElement(scheduledTimeLabel); }

    public WebElement getScheduledTimeInput() { return findWebElement(scheduledTimeInput); }

    public WebElement getDriverLabel() { return findWebElement(driverLabel); }

    public WebElement getDriverInput() { return findWebElement(driverInput); }

    public WebElement getTemperatureField() { return findWebElement(temperatureField); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getReceiverDateColumn() { return findWebElement(receiverDateColumn); }

    public WebElement getReceiverFromStatusColumn() { return findWebElement(receiverFromStatusColumn); }

    public WebElement getReceiverToStatusColumn() { return findWebElement(receiverToStatusColumn); }

    public WebElement getReceiverUserColumn() { return findWebElement(receiverUserColumn); }

    public WebElement getMoveShipDate() { return findWebElement(moveShipDate); }

    public WebElement getMoveShipDateInput() { return findWebElement(moveShipDateInput); }

    public WebElement getLoadInput() { return findWebElement(loadInput); }

    public List<WebElement> getOrderProducts() { return findWebElements(orderProducts); }

    public WebElement getBtnProductData() { return findWebElement(btnProductData); }

    public WebElement getBtnProductEdit() { return findWebElement(btnProductEdit); }

    public WebElement getSaveEditButton() { return findWebElement(saveEditButton); }

    public WebElement getInboundImageCaptureButton() { return findWebElement(inboundImageCaptureButton); }

    public WebElement getSelectFilesBtn() { return findWebElement(selectFilesBtn); }

    public WebElement getLoadImageLabel() { return findWebElement(loadImageLabel); }

    public WebElement getTemperatureLabel() { return findWebElement(temperatureLabel); }

    public WebElement getTemperatureInput() { return findWebElement(temperatureInput); }

    public WebElement getSealNumberLabel() { return findWebElement(sealNumberLabel); }

    public WebElement getSealNumberInput() { return findWebElement(sealNumberInput); }

    public List<WebElement> getCommentsLabels() { return findWebElements(commentsLabels); }

    public List<WebElement> getCommentsInputs() { return findWebElements(commentsInputs); }

    public List<WebElement> getYesRadioButtons() { return findWebElements(yesRadioButtons); }

    public List<WebElement> getNoRadioButtons() { return findWebElements(noRadioButtons); }

    public WebElement getBtnAddProductCancel() { return findWebElement(btnAddProductCancel); }

}
