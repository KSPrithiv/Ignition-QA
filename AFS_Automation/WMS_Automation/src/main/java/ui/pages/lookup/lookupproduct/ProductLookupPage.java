package ui.pages.lookup.lookupproduct;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;

public class ProductLookupPage extends BasePage {
    By productLookupTitle = By.className("spnmoduleNameHeader");
    By productLookupButton = By.cssSelector(".i-indexfield-container__main .k-button");
    By productSearchLabel = By.id("locationSearchACField-label");
    By productSearchInput = By.xpath("//input[@placeholder='Enter product']");
    By lookupTab = By.xpath("//li[@role='menuitem']//span[text()='Lookup']");
    By warehouseTab = By.xpath("//li[@role='menuitem']//span[text()='Warehouse']");
    By allocationTab = By.xpath("//ul[contains(@class, 'k-tabstrip-items')]//span[text()='Allocation']");
    By setupTab = By.xpath("//ul[contains(@class, 'k-tabstrip-items')]//span[text()='Setup']");
    By historyTab = By.xpath("//ul[contains(@class, 'k-tabstrip-items')]//span[text()='History']");
    By productShowPalletCheck = By.id("lookupProductShowPalletCheck");
    By lookupProductHistory = By.id("lookupProductHistory");
    By palletsLabel = By.xpath("//span[text()='Pallets:']");
    By quantityLabel = By.xpath("//span[text()='Quantity:']");
    By itemsFoundLabel = By.xpath("//span[contains(text(), 'Items found:')]");
    By addFilterButton = By.cssSelector(".i-filter-tag__main__text--add");
    By dateColumn = By.xpath("//span[text()='Date /']");
    By dateColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Date /']]");
    By timeColumn = By.xpath("//span[text()='Time']");
    By timeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Time']]");
    By warehouseColumn = By.xpath("//span[text()='Warehouse']");
    By warehouseColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Warehouse']]");
    By userColumn = By.xpath("//span[text()='User']");
    By userColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='User']]");
    By functionColumn = By.xpath("//span[text()='Function']");
    By functionColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Function']]");
    By reasonColumn = By.xpath("//span[text()='Reason']");
    By reasonColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Reason']]");
    By lotColumn = By.xpath("//span[text()='Lot']");
    By lotColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Lot']]");
    By expDateColumn = By.xpath("//span[text()='Exp Date']");
    By expDateColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Exp Date']]");
    By locationColumn = By.xpath("//span[text()='Location']");
    By locationColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Location']]");
    By locationTypeColumn = By.xpath("//span[text()='Location Type']");
    By locationTypeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Location Type']]");
    By qtyColumn = By.xpath("//span[text()='Quantity']");
    By qtyColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Quantity']]");
    By uomColumn = By.xpath("//span[text()='UOM']");
    By uomColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='UOM']]");
    By conversionColumn = By.xpath("//span[text()='Conversion']");
    By conversionColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Conversion']]");
    By actualColumn = By.xpath("//span[text()='Actual']");
    By actualColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Actual']]");
    By bookColumn = By.xpath("//span[text()='Book']");
    By bookColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Book']]");
    By inboundColumn = By.xpath("//span[text()='Inbound']");
    By inboundColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Inbound']]");
    By outboundColumn = By.xpath("//span[text()='Outbound']");
    By outboundColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Outbound']]");
    By softAllocatedColumn = By.xpath("//span[text()='Soft allocated']");
    By softAllocatedColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Soft allocated']]");
    By hardAllocatedColumn = By.xpath("//span[text()='Hard allocated']");
    By hardAllocatedColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Hard allocated']]");
    By taskTypeColumn = By.xpath("//span[text()='Task Type']");
    By taskTypeColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Task Type']]");
    By destinationColumn = By.xpath("//span[text()='Destination']");
    By destinationColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Destination']]");
    By receivedColumn = By.xpath("//span[text()='Received']");
    By receivedColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Received']]");
    By statusColumn = By.xpath("//span[text()='Status']");
    By statusColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Status']]");
    By orderColumn = By.xpath("//span[text()='Order']");
    By orderColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Order']]");
    By weightColumn = By.xpath("//span[text()='Weight']");
    By weightColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Weight']]");
    By stagedColumn = By.xpath("//span[text()='Staged']");
    By stagedColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Staged']]");
    By staged_Column = By.xpath("//span[text()='Staged?']");
    By staged_ColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Staged?']]");
    By pickUomColumn = By.xpath("//span[text()='Pick UOM']");
    By pickUomColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Pick UOM']]");
    By replenishUomColumn = By.xpath("//span[text()='Replenish UOM']");
    By replenishUomColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Replenish UOM']]");
    By capacityColumn = By.xpath("//span[text()='Capacity']");
    By capacityColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Capacity']]");
    By replenishmentLevelColumn = By.xpath("//span[text()='Replenishment level']");
    By replenishmentLevelColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Replenishment level']]");
    By reserveThresholdColumn = By.xpath("//span[text()='Reserve threshold']");
    By reserveThresholdColumnHeader = By.xpath("//th[@role='columnheader'][.//span[text()='Reserve threshold']]");
    By productLabel = By.xpath("//div[@role='tabpanel']//label[text()='Product']");
    By descriptionLabel = By.xpath("//div[@role='tabpanel']//label[text()='Description']");
    By productTypeLabel = By.xpath("//div[@role='tabpanel']//label[text()='Product type']");
    By tieHighLabel = By.xpath("//div[@role='tabpanel']//label[text()='Tie/high']");
    By movementClassLabel = By.xpath("//div[@role='tabpanel']//label[text()='Movement class']");
    By dedicatedPickLocationsLabel = By.xpath("//div[@role='tabpanel']//label[text()='Dedicated pick locations']");
    By unitsOfMeasureLabel = By.xpath("//div[@role='tabpanel']//label[text()='Units of measure']");
    By aliasesLabel = By.xpath("//div[@role='tabpanel']//label[text()='Aliases']");
    By vendorsLabel = By.xpath("//div[@role='tabpanel']//label[text()='Vendors']");
    By editLocProdButton = By.id("editLocProdButton");
    By ddlStatusLabel = By.id("ddlStatus-label");
    By ddlStatus = By.id("ddlStatus");
    By ddlStatusReasonLabel = By.id("ddlStatusReason-label");
    By ddlStatusReason = By.id("ddlStatusReason");
    By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    By notificationText = By.cssSelector("#pgstatusError .i-notification-text");
    By notificationMsg = By.cssSelector(".toast-message");
    By clearAllButton = By.xpath("//button[text()='Clear all']");
    By checkBoxes = By.cssSelector(".i-filter-popup__checkboxes .i-btn-checkbox");
    By warehouseIdFilter = By.cssSelector(".i-btn-checkbox  #WarehouseId");
    By ownerIdFilter = By.cssSelector(".i-btn-checkbox  #OwnerId");
    By locationFilter = By.cssSelector(".i-btn-checkbox  #Location");
    By locationTypeFilter = By.cssSelector(".i-btn-checkbox  #LocationType");
    By qtyFilter = By.cssSelector(".i-btn-checkbox  #Qty");
    By uomFilter = By.cssSelector(".i-btn-checkbox  #UOM");
    By taskTypeFilter = By.cssSelector(".i-btn-checkbox  #TaskType");
    By destinationFilter = By.cssSelector(".i-btn-checkbox  #Destination");
    By receivedFilterFilter = By.cssSelector(".i-btn-checkbox  #ReceivedFilter");
    By lotFilter = By.cssSelector(".i-btn-checkbox  #Lot");
    By expiryDateFilterFilter = By.cssSelector(".i-btn-checkbox  #ExpiryDateFilter");
    By statusIdFilter = By.cssSelector(".i-btn-checkbox  #StatusId");
    By weightFilter = By.cssSelector(".i-btn-checkbox  #Weight");
    By stagedFilter = By.cssSelector(".i-btn-checkbox  #Staged");
    By inputContains = By.xpath("//input[@placeholder='Contains']");
    By applyButton = By.xpath("//button[text()='Apply']");
    By inputSearch = By.xpath("//input[@placeholder='Search']");
    By palletsIndicator= By.xpath("//span[contains(text(), 'Pallets:')]");
    By palletsIndicatorValue = By.xpath("//span[contains(text(), 'Pallets:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By quantityIndicator= By.xpath("//span[contains(text(), 'Quantity:')]");
    By quantityIndicatorValue = By.xpath("//span[contains(text(), 'Quantity:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By itemsFoundIndicator= By.xpath("//span[contains(text(), 'Items found:')]");
    By itemsFoundIndicatorValue = By.xpath("//span[contains(text(), 'Items found:')]//following-sibling::span[@class='i-summary-area__main__value']");
    By qtyInputs = By.cssSelector(".k-numerictextbox input");
    By dataInputs = By.cssSelector(".k-dateinput input");
    By dropdownList = By.id("dropdownList");

    public void waitForProductLookupPageToLoad() {
        refresh();
        refresh();
        refresh();
        Waiters.waitABit(8000);
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(productLookupButton);
        Waiters.waitForElementToBeDisplay(productSearchLabel);
        Waiters.waitForElementToBeDisplay(productSearchInput);
    }

    public void clickProductLookupTitle() {
        Waiters.waitForElementToBeDisplay(productLookupTitle);
        clickOnElement(productLookupTitle);
        Waiters.waitABit(3000);
    }

    public void typeProduct(String product) {
        Waiters.waitForElementToBeDisplay(productSearchInput);
        inputText(getProductSearchInput(), product);
        pressEnter(getProductSearchInput());
        Waiters.waitABit(3000);
    }

    public void deleteProduct() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(productSearchInput);
        clear(getProductSearchInput());
        pressEnter(getProductSearchInput());
    }

    public void clickHistoryTab() {
        Waiters.waitForElementToBeDisplay(getHistoryTab());
        clickOnElement(getHistoryTab());
        Waiters.waitABit(2000);
    }

    public void clickSetUpTab() {
        Waiters.waitForElementToBeDisplay(getSetupTab());
        clickOnElement(getSetupTab());
        Waiters.waitABit(2000);
    }

    public void clickAllocationTab() {
        Waiters.waitForElementToBeDisplay(getAllocationTab());
        clickOnElement(getAllocationTab());
        Waiters.waitABit(2000);
    }

    public void clickEditLocProdButton() {
        Waiters.waitForElementToBeDisplay(getEditLocProdButton());
        clickOnElement(getEditLocProdButton());
        Waiters.waitABit(2000);
    }

    public void selectChangeStatus(String status) {
        Waiters.waitForElementToBeDisplay(ddlStatus);
        clickOnElement(ddlStatus);
        WebElement option = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + status + "') and @role='option']"));
        clickOnElement(option);
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void selectChangeUnitStatusReason(String reason) {
        Waiters.waitForElementToBeDisplay(ddlStatusReason);
        clickOnElement(ddlStatusReason);
        WebElement option = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + reason + "') and @role='option']"));
        clickOnElement(option);
    }

    public void selectCheckBoxOptionByIndex(int index) {
        Waiters.waitForPresenceOfAllElements(checkBoxes);
        Waiters.waitABit(1000);
        clickOnElement(getCheckBoxesOptions().get(index));
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeDisplay(cancelButton);
        clickOnElement(cancelButton);
        Waiters.waitABit(5000);
    }

    public void clickSaveButton() {
        Waiters.waitForElementToBeDisplay(saveButton);
        clickOnElement(saveButton);
        Waiters.waitABit(2000);
    }

    public void clickAddFilter() {
        Waiters.waitForElementToBeDisplay(addFilterButton);
        clickOnElement(addFilterButton);
    }

    public void typeFilter(String filter) {
        Waiters.waitForElementToBeDisplay(getInputContains());
        inputText(getInputContains(), filter);
    }

    public void typeAmountRange(String amountFrom, String amountTo) {
        Waiters.waitForPresenceOfAllElements(qtyInputs);
        inputText(getQtyInputs().get(0), amountFrom);
        inputText(getQtyInputs().get(1), amountTo);
    }

    public void typeFromDate(String receivedFrom) {
        Waiters.waitForPresenceOfAllElements(dataInputs);
        inputText(geDataInputs().get(0), receivedFrom);
        pressTab(geDataInputs().get(0));
    }

    public void typeTillDate(String receivedTill) {
        Waiters.waitForPresenceOfAllElements(dataInputs);
        inputText(geDataInputs().get(1), receivedTill);
        pressTab(geDataInputs().get(1));
    }

    public void clickApplyButton() {
        Waiters.waitForElementToBeDisplay(getApplyButton());
        clickOnElement(getApplyButton());
    }

    public void clickClearAllButton() {
        Waiters.waitForElementToBeDisplay(getСlearAllButton());
        clickOnElement(getСlearAllButton());
    }

    public void checkWarehouseIdFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getWarehouseIdFilter());
        clickOnElement(getWarehouseIdFilter());
    }

    public void checkOwnerIdFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getOwnerIdFilter());
        clickOnElement(getOwnerIdFilter());
    }

    public void checkLocationFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getLocationFilter());
        clickOnElement(getLocationFilter());
    }

    public void checkLocationTypeFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getLocationTypeFilter());
        clickOnElement(getLocationTypeFilter());
    }

    public void checkQtyFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getQtyFilter());
        clickOnElement(getQtyFilter());
    }

    public void checkUomFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getUomFilter());
        clickOnElement(getUomFilter());
    }

    public void checkTaskTypeFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getTaskTypeFilter());
        clickOnElement(getTaskTypeFilter());
    }

    public void checkDestinationFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getDestinationFilter());
        clickOnElement(getDestinationFilter());
    }

    public void checkReceivedFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getReceivedFilterFilter());
        clickOnElement(getReceivedFilterFilter());
    }

    public void checkLotFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getLotFilter());
        clickOnElement(getLotFilter());
    }

    public void checkExpiryDateFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getExpiryDateFilter());
        clickOnElement(getExpiryDateFilter());
    }

    public void checkStatusIdFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getStatusIdFilter());
        clickOnElement(getStatusIdFilter());
    }

    public void checkWeightFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getWeightFilter());
        clickOnElement(getWeightFilter());
    }

    public void checkStagedFilterCheckBox() {
        Waiters.waitForElementToBeDisplay(getStagedFilter());
        clickOnElement(getStagedFilter());
    }

    public String getPalletsIndicatorValueText() {
        Waiters.waitABit(2000);
        return getText(palletsIndicatorValue);
    }

    public String getQuantityIndicatorValueText() {
        Waiters.waitABit(2000);
        return getText(quantityIndicatorValue);
    }

    public String getItemsFoundIndicatorValueText() {
        Waiters.waitABit(2000);
        return getText(itemsFoundIndicatorValue);
    }

    public String getNotificationMessageText() {
        Waiters.waitForElementToBeDisplay(getNotificationText());
        return getText(getNotificationText());
    }

    public boolean isStatusLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlStatusLabel());
        return isElementDisplay(getDdlStatusLabel());
    }

    public boolean isStatusDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlStatus());
        return isElementDisplay(getDdlStatus());
    }

    public boolean isStatusReasonLabelDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlStatusReasonLabel());
        return isElementDisplay(getDdlStatusReasonLabel());
    }

    public boolean isStatusReasonDisplayed() {
        Waiters.waitForElementToBeDisplay(getDdlStatusReason());
        return isElementDisplay(getDdlStatusReason());
    }

    public boolean isProductLookupTitleDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getProductLookupTitle());
    }

    public boolean isProductLookupButtonDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getProductLookupButton());
    }

    public boolean isProductSearchLabelDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getProductSearchLabel());
    }

    public boolean isProductSearchInputDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getProductSearchInput());
    }

    public boolean isLookupTabDisplayed() {
        Waiters.waitABit(1000);
        return isElementDisplay(getLookupTab());
    }

    public boolean areAllocationTabsDisplayed() {
        Waiters.waitABit(1000);
        return elementsArePresent(getAllocationTabs()) > 0;
    }

    public boolean areSetupTabsDisplayed() {
        Waiters.waitABit(1000);
        return elementsArePresent(getSetupTabs()) > 0;
    }

    public boolean areHistoryTabsDisplayed() {
        Waiters.waitABit(1000);
        return elementsArePresent(getHistoryTabs()) > 0;
    }

    public boolean isProductShowPalletCheckDisplayed() {
        return isElementDisplay(getProductShowPalletCheck());
    }

    public boolean isPickUomColumnDisplayed() { return isElementDisplay(getPickUomColumn()); }

    public boolean isPickUomColumnHeaderDisplayed() { return isElementDisplay(getPickUomColumnHeader()); }

    public boolean isReplenishUomColumnDisplayed() { return isElementDisplay(getReplenishUomColumn()); }

    public boolean isReplenishUomColumnHeaderDisplayed() { return isElementDisplay(getReplenishUomColumnHeader()); }

    public boolean isCapacityColumnDisplayed() { return isElementDisplay(getCapacityColumn()); }

    public boolean isCapacityColumnHeaderDisplayed() { return isElementDisplay(getCapacityColumnHeader()); }

    public boolean isReplenishmentLevelColumnDisplayed() { return isElementDisplay(getReplenishmentLevelColumn()); }

    public boolean isReplenishmentLevelColumnHeaderDisplayed() { return isElementDisplay(getReplenishmentLevelColumnHeader()); }

    public boolean isReserveThresholdColumnDisplayed() { return isElementDisplay(getReserveThresholdColumn()); }

    public boolean isReserveThresholdColumnHeaderDisplayed() { return isElementDisplay(getReserveThresholdColumnHeader()); }

    public boolean isProductLabelDisplayed() { return isElementDisplay(getProductLabel()); }

    public boolean isDescriptionLabelDisplayed() { return isElementDisplay(getDescriptionLabel()); }

    public boolean isProductTypeLabelDisplayed() { return isElementDisplay(getProductTypeLabel()); }

    public boolean isTieHighLabelDisplayed() { return isElementDisplay(getTieHighLabel()); }

    public boolean isMovementClassLabelDisplayed() { return isElementDisplay(getMovementClassLabel()); }

    public boolean isDedicatedPickLocationsLabelDisplayed() { return isElementDisplay(getDedicatedPickLocationsLabel()); }

    public boolean isUnitsOfMeasureLabelDisplayed() { return isElementDisplay(getUnitsOfMeasureLabel()); }

    public boolean isAliasesLabelDisplayed() { return isElementDisplay(getAliasesLabel()); }

    public boolean isVendorsLabelDisplayed() { return isElementDisplay(getVendorsLabel()); }

    public boolean isDateColumnDisplayed() { return isElementDisplay(getDateColumn()); }

    public boolean isDateColumnHeaderDisplayed() { return isElementDisplay(getDateColumnHeader()); }

    public boolean isTimeColumnDisplayed() { return isElementDisplay(getTimeColumn()); }

    public boolean isTimeColumnHeaderDisplayed() { return isElementDisplay(getTimeColumnHeader()); }

    public boolean isWarehouseColumnDisplayed() { return isElementDisplay(getWarehouseColumn()); }

    public boolean isWarehouseColumnHeaderDisplayed() { return isElementDisplay(getWarehouseColumnHeader()); }

    public boolean isUserColumnDisplayed() { return isElementDisplay(getUserColumn()); }

    public boolean isUserColumnHeaderDisplayed() { return isElementDisplay(getUserColumnHeader()); }

    public boolean isFunctionColumnDisplayed() { return isElementDisplay(getFunctionColumn()); }

    public boolean isFunctionColumnHeaderDisplayed() { return isElementDisplay(getFunctionColumnHeader()); }

    public boolean isReasonColumnDisplayed() { return isElementDisplay(getReasonColumn()); }

    public boolean isReasonColumnHeaderDisplayed() { return isElementDisplay(getReasonColumnHeader()); }

    public boolean isLotColumnDisplayed() { return isElementDisplay(getLotColumn()); }

    public boolean isLotColumnHeaderDisplayed() { return isElementDisplay(getLotColumnHeader()); }

    public boolean isExpDateColumnDisplayed() { return isElementDisplay(getExpDateColumn()); }

    public boolean isExpDateColumnHeaderDisplayed() { return isElementDisplay(getExpDateColumnHeader()); }

    public boolean isQtyColumnDisplayed() { return isElementDisplay(getQtyColumn()); }

    public boolean isQtyColumnHeaderDisplayed() { return isElementDisplay(getQtyColumnHeader()); }

    public boolean isLocationColumnDisplayed() { return isElementDisplay(getLocationColumn()); }

    public boolean isLocationColumnHeaderDisplayed() { return isElementDisplay(getLocationColumnHeader()); }

    public boolean isLocationTypeColumnDisplayed() { return isElementDisplay(getLocationTypeColumn()); }

    public boolean isLocationTypeColumnHeaderDisplayed() { return isElementDisplay(getLocationTypeColumnHeader()); }

    public boolean isUomColumnDisplayed() { return isElementDisplay(getUomColumn()); }

    public boolean isUomColumnHeaderDisplayed() { return isElementDisplay(getUomColumnHeader()); }

    public boolean isConversionColumnDisplayed() { return isElementDisplay(getConversionColumn()); }

    public boolean isConversionColumnHeaderDisplayed() { return isElementDisplay(getConversionColumnHeader()); }

    public boolean isTaskTypeColumnDisplayed() { return isElementDisplay(getTaskTypeColumn()); }

    public boolean isTaskTypeColumnHeaderDisplayed() { return isElementDisplay(getTaskTypeColumnHeader()); }

    public boolean isDestinationColumnDisplayed() { return isElementDisplay(getDestinationColumn()); }

    public boolean isDestinationColumnHeaderDisplayed() { return isElementDisplay(getDestinationColumnHeader()); }

    public boolean isReceivedColumnDisplayed() { return isElementDisplay(getReceivedColumn()); }

    public boolean isReceivedColumnHeaderDisplayed() { return isElementDisplay(getReceivedColumnHeader()); }

    public boolean isWeightColumnDisplayed() { return isElementDisplay(getWeightColumn()); }

    public boolean isWeightColumnHeaderDisplayed() { return isElementDisplay(getWeightColumnHeader()); }

    public boolean isStagedColumnDisplayed() { return isElementDisplay(getStagedColumn()); }

    public boolean isStagedColumnHeaderDisplayed() { return isElementDisplay(getStagedColumnHeader()); }

    public boolean isStaged_ColumnDisplayed() { return isElementDisplay(getStaged_Column()); }

    public boolean isStaged_ColumnHeaderDisplayed() { return isElementDisplay(getStaged_ColumnHeader()); }

    public boolean isActualColumnDisplayed() { return isElementDisplay(getActualColumn()); }

    public boolean isActualColumnHeaderDisplayed() { return isElementDisplay(getActualColumnHeader()); }

    public boolean isBookColumnDisplayed() { return isElementDisplay(getBookColumn()); }

    public boolean isBookColumnHeaderDisplayed() { return isElementDisplay(getBookColumnHeader()); }

    public boolean isInboundColumnDisplayed() { return isElementDisplay(getInboundColumn()); }

    public boolean isInboundColumnHeaderDisplayed() { return isElementDisplay(getInboundColumnHeader()); }

    public boolean isOutboundColumnDisplayed() { return isElementDisplay(getOutboundColumn()); }

    public boolean isOutboundColumnHeaderDisplayed() { return isElementDisplay(getOutboundColumnHeader()); }

    public boolean isSoftAllocatedColumnDisplayed() { return isElementDisplay(getSoftAllocatedColumn()); }

    public boolean isSoftAllocatedColumnHeaderDisplayed() { return isElementDisplay(getSoftAllocatedColumnHeader()); }

    public boolean isHardAllocatedColumnDisplayed() { return isElementDisplay(getHardAllocatedColumn()); }

    public boolean isHardAllocatedColumnHeaderDisplayed() { return isElementDisplay(getHardAllocatedColumnHeader()); }

    public boolean isStatusColumnDisplayed() { return isElementDisplay(getStatusColumn()); }

    public boolean isStatusColumnHeaderDisplayed() { return isElementDisplay(getStatusColumnHeader()); }

    public boolean isOrderColumnDisplayed() { return isElementDisplay(getOrderColumn()); }

    public boolean isOrderColumnHeaderDisplayed() { return isElementDisplay(getOrderColumnHeader()); }

    public WebElement getProductLookupTitle() { return findWebElement(productLookupTitle); }

    public WebElement getProductLookupButton() { return findWebElement(productLookupButton); }

    public WebElement getProductSearchLabel() { return findWebElement(productSearchLabel); }

    public WebElement getProductSearchInput() { return findWebElement(productSearchInput); }

    public WebElement getLookupTab() { return findWebElement(lookupTab); }

    public WebElement getWarehouseTab() { return findWebElement(warehouseTab); }

    public List<WebElement> getAllocationTabs() { return findWebElements(allocationTab); }

    public WebElement getAllocationTab() { return findWebElement(allocationTab); }

    public List<WebElement> getSetupTabs() { return findWebElements(setupTab); }

    public WebElement getSetupTab() { return findWebElement(setupTab); }

    public List<WebElement> getHistoryTabs() { return findWebElements(historyTab); }

    public WebElement getHistoryTab() { return findWebElement(historyTab); }

    public WebElement getProductShowPalletCheck() { return findWebElement(productShowPalletCheck); }

    public WebElement getLookupProductHistory() { return findWebElement(lookupProductHistory); }

    public WebElement getPalletsLabel() { return findWebElement(palletsLabel); }

    public WebElement getQuantityLabel() { return findWebElement(quantityLabel); }

    public WebElement getItemsFoundLabel() { return findWebElement(itemsFoundLabel); }

    public WebElement getAddFilterButton() { return findWebElement(addFilterButton); }

    public WebElement getDateColumn() { return findWebElement(dateColumn); }

    public WebElement getDateColumnHeader() { return findWebElement(dateColumnHeader); }

    public WebElement getTimeColumn() { return findWebElement(timeColumn); }

    public WebElement getTimeColumnHeader() { return findWebElement(timeColumnHeader); }

    public WebElement getWarehouseColumn() { return findWebElement(warehouseColumn); }

    public WebElement getWarehouseColumnHeader() { return findWebElement(warehouseColumnHeader); }

    public WebElement getUserColumn() { return findWebElement(userColumn); }

    public WebElement getUserColumnHeader() { return findWebElement(userColumnHeader); }

    public WebElement getFunctionColumn() { return findWebElement(functionColumn); }

    public WebElement getFunctionColumnHeader() { return findWebElement(functionColumnHeader); }

    public WebElement getReasonColumn() { return findWebElement(reasonColumn); }

    public WebElement getReasonColumnHeader() { return findWebElement(reasonColumnHeader); }

    public WebElement getLotColumn() { return findWebElement(lotColumn); }

    public WebElement getLotColumnHeader() { return findWebElement(lotColumnHeader); }

    public WebElement getExpDateColumn() { return findWebElement(expDateColumn); }

    public WebElement getExpDateColumnHeader() { return findWebElement(expDateColumnHeader); }

    public WebElement getQtyColumn() { return findWebElement(qtyColumn); }

    public WebElement getQtyColumnHeader() { return findWebElement(qtyColumnHeader); }

    public WebElement getActualColumn() { return findWebElement(actualColumn); }

    public WebElement getActualColumnHeader() { return findWebElement(actualColumnHeader); }

    public WebElement getBookColumn() { return findWebElement(bookColumn); }

    public WebElement getBookColumnHeader() { return findWebElement(bookColumnHeader); }

    public WebElement getStatusColumn() { return findWebElement(statusColumn); }

    public WebElement getStatusColumnHeader() { return findWebElement(statusColumnHeader); }

    public WebElement getOrderColumn() { return findWebElement(orderColumn); }

    public WebElement getOrderColumnHeader() { return findWebElement(orderColumnHeader); }

    public WebElement getLocationColumn() { return findWebElement(locationColumn); }

    public WebElement getLocationColumnHeader() { return findWebElement(locationColumnHeader); }

    public WebElement getLocationTypeColumn() { return findWebElement(locationTypeColumn); }

    public WebElement getLocationTypeColumnHeader() { return findWebElement(locationTypeColumnHeader); }

    public WebElement getUomColumn() { return findWebElement(uomColumn); }

    public WebElement getUomColumnHeader() { return findWebElement(uomColumnHeader); }

    public WebElement getTaskTypeColumn() { return findWebElement(taskTypeColumn); }

    public WebElement getTaskTypeColumnHeader() { return findWebElement(taskTypeColumnHeader); }

    public WebElement getDestinationColumn() { return findWebElement(destinationColumn); }

    public WebElement getDestinationColumnHeader() { return findWebElement(destinationColumnHeader); }

    public WebElement getReceivedColumn() { return findWebElement(receivedColumn); }

    public WebElement getReceivedColumnHeader() { return findWebElement(receivedColumnHeader); }

    public WebElement getWeightColumn() { return findWebElement(weightColumn); }

    public WebElement getWeightColumnHeader() { return findWebElement(weightColumnHeader); }

    public WebElement getStagedColumn() { return findWebElement(stagedColumn); }

    public WebElement getStagedColumnHeader() { return findWebElement(stagedColumnHeader); }

    public WebElement getStaged_Column() { return findWebElement(staged_Column); }

    public WebElement getStaged_ColumnHeader() { return findWebElement(staged_ColumnHeader); }

    public WebElement getPickUomColumn() { return findWebElement(pickUomColumn); }

    public WebElement getPickUomColumnHeader() { return findWebElement(pickUomColumnHeader); }

    public WebElement getReplenishUomColumn() { return findWebElement(replenishUomColumn); }

    public WebElement getReplenishUomColumnHeader() { return findWebElement(replenishUomColumnHeader); }

    public WebElement getCapacityColumn() { return findWebElement(capacityColumn); }

    public WebElement getCapacityColumnHeader() { return findWebElement(capacityColumnHeader); }

    public WebElement getReplenishmentLevelColumn() { return findWebElement(replenishmentLevelColumn); }

    public WebElement getReplenishmentLevelColumnHeader() { return findWebElement(replenishmentLevelColumnHeader); }

    public WebElement getReserveThresholdColumn() { return findWebElement(reserveThresholdColumn); }

    public WebElement getReserveThresholdColumnHeader() { return findWebElement(reserveThresholdColumnHeader); }

    public WebElement getProductLabel() { return findWebElement(productLabel); }

    public WebElement getDescriptionLabel() { return findWebElement(descriptionLabel); }

    public WebElement getProductTypeLabel() { return findWebElement(productTypeLabel); }

    public WebElement getTieHighLabel() { return findWebElement(tieHighLabel); }

    public WebElement getMovementClassLabel() { return findWebElement(movementClassLabel); }

    public WebElement getDedicatedPickLocationsLabel() { return findWebElement(dedicatedPickLocationsLabel); }

    public WebElement getUnitsOfMeasureLabel() { return findWebElement(unitsOfMeasureLabel); }

    public WebElement getAliasesLabel() { return findWebElement(aliasesLabel); }

    public WebElement getVendorsLabel() { return findWebElement(vendorsLabel); }

    public WebElement getEditLocProdButton() { return findWebElement(editLocProdButton); }

    public WebElement getConversionColumn() { return findWebElement(conversionColumn); }

    public WebElement getConversionColumnHeader() { return findWebElement(conversionColumnHeader); }

    public WebElement getInboundColumn() { return findWebElement(inboundColumn); }

    public WebElement getInboundColumnHeader() { return findWebElement(inboundColumnHeader); }

    public WebElement getOutboundColumn() { return findWebElement(outboundColumn); }

    public WebElement getOutboundColumnHeader() { return findWebElement(outboundColumnHeader); }

    public WebElement getSoftAllocatedColumn() { return findWebElement(softAllocatedColumn); }

    public WebElement getSoftAllocatedColumnHeader() { return findWebElement(softAllocatedColumnHeader); }

    public WebElement getHardAllocatedColumn() { return findWebElement(hardAllocatedColumn); }

    public WebElement getHardAllocatedColumnHeader() { return findWebElement(hardAllocatedColumnHeader); }

    public WebElement getDdlStatusLabel() { return findWebElement(ddlStatusLabel); }

    public WebElement getDdlStatus() { return findWebElement(ddlStatus); }

    public WebElement getDdlStatusReasonLabel() { return findWebElement(ddlStatusReasonLabel); }

    public WebElement getDdlStatusReason() { return findWebElement(ddlStatusReason); }

    public WebElement getNotificationText() { return findWebElement(notificationText); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

    public WebElement getСlearAllButton() { return findWebElement(clearAllButton); }

    public WebElement getWarehouseIdFilter() { return findWebElement(warehouseIdFilter); }

    public WebElement getOwnerIdFilter() { return findWebElement(ownerIdFilter); }

    public WebElement getLocationFilter() { return findWebElement(locationFilter); }

    public WebElement getLocationTypeFilter() { return findWebElement(locationTypeFilter); }

    public WebElement getQtyFilter() { return findWebElement(qtyFilter); }

    public WebElement getUomFilter() { return findWebElement(uomFilter); }

    public WebElement getTaskTypeFilter() { return findWebElement(taskTypeFilter); }

    public WebElement getDestinationFilter() { return findWebElement(destinationFilter); }

    public WebElement getReceivedFilterFilter() { return findWebElement(receivedFilterFilter); }

    public WebElement getLotFilter() { return findWebElement(lotFilter); }

    public WebElement getExpiryDateFilter() { return findWebElement(expiryDateFilterFilter); }

    public WebElement getStatusIdFilter() { return findWebElement(statusIdFilter); }

    public WebElement getWeightFilter() { return findWebElement(weightFilter); }

    public WebElement getStagedFilter() { return findWebElement(stagedFilter); }

    public WebElement getInputContains() { return findWebElement(inputContains); }

    public WebElement getApplyButton() { return findWebElement(applyButton); }

    public WebElement getInputSearch() { return findWebElement(inputSearch); }

    public WebElement getPalletsIndicator() { return findWebElement(palletsIndicator); }

    public WebElement getPalletsIndicatorValue() { return findWebElement(palletsIndicatorValue); }

    public WebElement getQuantityIndicator() { return findWebElement(quantityIndicator); }

    public WebElement getQuantityIndicatorValue() { return findWebElement(quantityIndicatorValue); }

    public WebElement getItemsFoundIndicator() { return findWebElement(itemsFoundIndicator); }

    public WebElement getItemsFoundIndicatorValue() { return findWebElement(itemsFoundIndicatorValue); }

    public List<WebElement> getCheckBoxesOptions() { return findWebElements(checkBoxes); }

    public List<WebElement> getQtyInputs() { return findWebElements(qtyInputs); }

    public List<WebElement> geDataInputs() { return findWebElements(dataInputs); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

}
