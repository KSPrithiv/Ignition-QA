package ui.pages.outbound.processing;

import common.utils.Waiters;
import objects.processedorderdata.OrdersListDTO;
import objects.processedorderdata.ProductsDTO;
import objects.processedorderdata.ResponseDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessingPage extends BasePage {
    By topIcon = By.xpath("//span[contains(text(), 'Processing')]");
    By processingLabel = By.cssSelector("#dtProcessingDate-label");
    By processingInput = By.cssSelector("#dtProcessingDate");
    By toggleCalendar = By.cssSelector("a[title='Toggle calendar']");
    By processButton = By.cssSelector("#addLocProdButton");
    By unprocessButton = By.cssSelector("#addLocProdButton1");
    By addButton = By.cssSelector("#addLocProdButton2");
    By deleteButton = By.cssSelector("#addLocProdButton3");
    By processingGridHeader = By.cssSelector(".k-grid-header");
    By processingGridTable = By.cssSelector(".k-grid-table");
    By allOrdersList = By.cssSelector("#divAllOrders");
    By filteredOrdersList = By.cssSelector("#divFilteredOrders");
    By unbatchedOrdersList = By.cssSelector("#divUnbatchedOrders");
    By batchesIcon = By.cssSelector("#divBatches");
    By batchListIcon = By.cssSelector("#divBatchList");
    By batchList = By.cssSelector("#divBatchList .listItemDivUnSelected");
    By orderStatusesPanel = By.cssSelector(".i-toolbar-container__summary");
    By shippedStatus = By.xpath("//span[contains(@class, 'i-bar-description')][.//span[text()='Shipped']]");
    By unallocatedStatus = By.xpath("//span[contains(@class, 'i-bar-description')][.//span[text()='Unallocated']]");
    By allocatedStatus = By.xpath("//span[contains(@class, 'i-bar-description')][.//span[text()='Allocated']]");
    By ordersCount = By.cssSelector(".i-summary-area__main__value");
    By orderDetails = By.cssSelector("#divOrderScreen");
    By buttonClose = By.cssSelector("#btnWQClose");
    By batchErrorPopUp = By.cssSelector("#dialogTextContent");
    By okButton = By.xpath("//button[contains(text(), 'OK')]");
    By deleteBatchPopup = By.cssSelector(".k-window-content");
    By yesButton = By.xpath("//button[contains(text(), 'Yes')]");
    By noButton = By.xpath("//button[contains(text(), 'No')]");
    By dropdownList = By.id("dropdownList");
    By dialogContent = By.cssSelector(".k-dialog-content");
    By notificationMsg = By.cssSelector(".toast-message");

    public void waitProcessingPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeDisplay(getTopIcon());
    }

    public String getBatchErrorPopUpText() {
        Waiters.waitForPresenceOfElement(batchErrorPopUp);
        return getText(batchErrorPopUp).trim();
    }

    public void clickOkButton() {
        Waiters.waitForPresenceOfElement(okButton);
        clickOnElement(By.xpath("//button[contains(text(), 'OK')]"));
    }

    public List<WebElement> getRows() {
        Waiters.waitForPresenceOfElement(processingGridTable);
        return getProcessingGridTable().findElements(By.xpath(".//tr"));
    }

    public int getRowsCount() {
        Waiters.waitForPresenceOfElement(processingGridTable);
        return getProcessingGridTable().findElements(By.xpath(".//tr")).size();
    }

    public int getBatchesCount() {
        Waiters.waitForPresenceOfAllElements(batchList);
        return getBatchesList().size();
    }

    public void clickAllOrders() {
        Waiters.waitForElementToBeClickable(allOrdersList);
        clickOnElement(getAllOrdersList());
        Waiters.waitABit(5000);
    }

    public void clickFilteredOrders() {
        Waiters.waitABit(5000);
        clickOnElement(getFilteredOrdersList());
    }

    public String getDeleteBatchText() {
        Waiters.waitForPresenceOfElement(deleteBatchPopup);
        return getText(By.cssSelector(".k-window-content"));
    }

    public String getProcessingInputValue() {
        Waiters.waitForPresenceOfElement(processingInput);
        return getValue(processingInput);
    }

    public void clickCloseButton() {
        Waiters.waitForElementToBeClickable(getButtonClose());
        clickOnElement(getButtonClose());
    }

    public void clickDeleteButton() {
        Waiters.waitForPresenceOfElement(By.cssSelector("#addLocProdButton3"));
        clickOnElement(getDeleteButton());
        Waiters.waitABit(2000);
    }

    public void clickUnbatchedOrders() {
        Waiters.waitForElementToBeClickable(unbatchedOrdersList);
        clickOnElement(getUnbatchedOrdersList());
        Waiters.waitABit(5000);
    }

    public void clickOrderByNumber(int num) {
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        Waiters.waitABit(2000);
        clickOnElement(getProcessingGridTable().findElements(By.xpath(".//tr")).get(num));
        Waiters.waitABit(2000);
    }

    public void selectWarehouse(String warehouse) {
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickOrderByName(String orderName) {
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        Waiters.waitABit(2000);
        WebElement row = getProcessingGridTable().findElements(By.xpath(".//tr"))
                 .stream()
                 .filter(el -> el.getText().contains(orderName))
                 .findFirst()
                 .orElseThrow(() -> new IllegalArgumentException("Order " + orderName + " does not exist in table"));
        clickOnElement(row);
        Waiters.waitABit(2000);
    }

    public void checkUnbatchedOrderByNumber(int num) {
        Waiters.waitForElementToBeDisplay(getUnbatchedOrdersList());
        Waiters.waitABit(2000);
        clickOnElement(getProcessingGridTable().findElements(By.cssSelector("tr input")).get(num));
        Waiters.waitABit(2000);
    }

    public void checkOrderByNumber(int num) {
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        Waiters.waitABit(2000);
        clickOnElement(getProcessingGridTable().findElements(By.cssSelector("tr input")).get(num));
        Waiters.waitABit(2000);
    }

    public void dragAndDropOrderToBatch(int num, String batchName) {
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        Waiters.waitABit(2000);
        WebElement order = getProcessingGridTable().findElements(By.cssSelector("tr input")).get(num);
        WebElement batch = getBatchesList()
                .stream()
                .filter(el -> el.getText().equals(batchName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
        dragAndDropTo(order, batch);
        Waiters.waitABit(2000);
    }

    public boolean isOrderUnbatchedChecked(int num) {
        Waiters.waitForElementToBeDisplay(getUnbatchedOrdersList());
        Waiters.waitABit(2000);
        return getElementAttribute(getProcessingGridTable()
                .findElements(By.xpath(".//tr")).get(num), "class")
                .contains("state-selected");
    }

    public void clickBatches() {
        Waiters.waitForPresenceOfElement(batchesIcon);
        clickOnElement(getBatchesIcon());
    }

    public void clickYesButton() {
        Waiters.waitABit(2000);
        Waiters.waitForPresenceOfElement(yesButton);
        clickOnElement(yesButton);
    }

    public void clickNoButton() {
        Waiters.waitABit(2000);
        Waiters.waitForPresenceOfElement(noButton);
        clickOnElement(noButton);
    }

    public void clickBatch(String batchName) {
        Waiters.waitForPresenceOfElement(batchList);
        WebElement batch = getBatchesList().stream()
           .filter(b -> b.getText().equals(batchName))
           .findFirst()
          .orElseThrow(() -> new IllegalArgumentException(("Batch " + batchName + " does not present")));
        clickOnElement(batch);
    }

    public boolean isBatchSelected(String batchName) {
        Waiters.waitForPresenceOfAllElements("#divBatchList .listItemDivUnSelected");
        WebElement batch = getBatchesList().stream()
                .filter(b -> b.getText().equals(batchName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(("Batch " + batchName + " does not present")));
        clickOnElement(batch);
        return getElementAttribute(batch, "class").contains("DivSelected");
    }

    public void clickAddButton() {
        Waiters.waitForElementToBeClickable(getAddButton());
        clickOnElement(getAddButton());
    }

    public void clickProcessButton() {
        Waiters.waitForElementToBeClickable(getProcessButton());
        clickOnElement(getProcessButton());
    }

    public void clickUnprocessButton() {
        Waiters.waitForElementToBeClickable(getUnprocessButton());
        clickOnElement(getUnprocessButton());
    }

    public void selectDate(String date) {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getProcessingInput());
        doubleClick(getProcessingInput());
        pressDelete(getProcessingInput());
        inputText(getProcessingInput(), date);
        Waiters.waitABit(2000);
        pressEnter(getProcessingInput());
    }

    public List<String> getOrdersDates() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(3000);
        Waiters.waitForPresenceOfElement(processingGridTable);
        return getProcessingGridTable()
                .findElements(By.cssSelector(".CPKendoDataGrid-Date"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getShippedStatusColorPoint() {
        Waiters.waitForElementToBeDisplay(getShippedStatus());
        return getShippedStatus().findElement(By.xpath("span"));
    }

    public WebElement getUnallocatedStatusColorPoint() {
        Waiters.waitForElementToBeDisplay(getUnallocatedStatus());
        return getUnallocatedStatus().findElement(By.xpath("span"));
    }

    public WebElement getAllocatedStatusColorPoint() {
        Waiters.waitForElementToBeDisplay(getAllocatedStatus());
        return getAllocatedStatus().findElement(By.xpath("span"));
    }

    public String getOrdersNumber() {
        Waiters.waitForElementToBeDisplay(getOrdersCount());
        return getOrdersCount().getText();
    }

    public String getDialogContentText() {
        Waiters.waitForElementToBeDisplay(getDialogContent());
        return getDialogContent().getText();
    }

    public String getOrderDetailsInfo() {
        Waiters.waitForElementToBeDisplay(getOrderDetails());
        return getOrderDetails().getText().trim();
    }

    public String getFilteredOrderDetailsInfo(WebElement element) {
        return element.getText().trim();
    }

    public List<WebElement> getFilteredOrders() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        return getProcessingGridTable().findElements(By.xpath(".//tr"));
    }

    public int getFilteredOrdersNumber() {
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        return getProcessingGridTable().findElements(By.xpath(".//tr")).size();
    }

    public boolean isDeleteBatchPopupDisplayed() {
        return isElementDisplay(getDeleteBatchPopUp());
    }

    public boolean isBatchDisplayed(String name) {
        Waiters.waitABit(1000);
        WebElement batch = getBatchesList()
                .stream()
                .filter(el -> el.getText().equals(name))
                .findFirst().get();
        return isElementDisplay(batch);
    }

    public ResponseDTO getOrderDetailsData() {
        List<String> orderData = Arrays.asList(getOrderDetailsInfo().split("\\n"));
        List<ProductsDTO> productsDTOList = new ArrayList<>();
        List<OrdersListDTO> ordersListDTOList = new ArrayList<>();
        List<String> newOrderData = orderData.stream().skip(2).collect(Collectors.toList());
        for(int i = 0; i < newOrderData.size(); i+=3) {
          productsDTOList.add(ProductsDTO.builder()
                .productCode(newOrderData.get(i).substring(0, 6).trim())
                .productDescription(newOrderData.get(i+1).trim())
                .count(newOrderData.get(i+2).trim()).build());
        }
        OrdersListDTO ordersListDTO = OrdersListDTO.builder()
                .order(orderData.get(0))
                .source(orderData.get(1))
                .products(productsDTOList)
                .build();
        ordersListDTOList.add(ordersListDTO);
        return ResponseDTO.builder().ordersList(ordersListDTOList).build();
    }

    public boolean isTopIconDisplayed() { return isElementDisplay(getTopIcon()); }

    public boolean isProcessingLabelDisplayed() {
        return isElementDisplay(getProcessingLabel());
    }

    public boolean isProcessingInputDisplayed() {
        return isElementDisplay(getProcessingInput());
    }

    public boolean isProcessButtonDisplayed() { return isElementDisplay(getProcessButton()); }

    public boolean isUnprocessButtonDisplayed() { return isElementDisplay(getUnprocessButton()); }

    public boolean isAddButtonDisplayed() {
        return isElementDisplay(getAddButton());
    }

    public boolean isDeleteButtonDisplayed() {
        return isElementDisplay(getDeleteButton());
    }

    public boolean isProcessingGridHeaderDisplayed() {
        return isElementDisplay(getProcessingGridHeader());
    }

    public boolean isProcessingGridTableDisplayed() {
        return isElementDisplay(getProcessingGridTable());
    }

    public boolean isAllOrdersListDisplayed() {
        return isElementDisplay(getAllOrdersList());
    }

    public boolean isFilteredOrdersListDisplayed() {
        return isElementDisplay(getFilteredOrdersList());
    }

    public boolean isUnbatchedOrdersListDisplayed() {
        return isElementDisplay(getUnbatchedOrdersList());
    }

    public boolean isBatchesIconDisplayed() {
        return isElementDisplay(getBatchesIcon());
    }

    public boolean isYesButtonDisplayed() {
        return isElementDisplay(yesButton);
    }

    public boolean isNoButtonDisplayed() {
        return isElementDisplay(noButton);
    }

    public boolean isAllOrdersListSelected() {
        return !getAllOrdersList().getAttribute("style").contains("black");
    }

    public String getDateValue() {
        return getValue(By.cssSelector("#dtProcessingDate"));
    }

    public String isDateValueCorrect() {
        return getValue(By.cssSelector("#dtProcessingDate"));
    }

    public boolean isDateValueExists() {
        Waiters.waitABit(2000);
        Waiters.waitForPresenceOfElement("#dtProcessingDate");
        return isElementDisplay(By.cssSelector("#dtProcessingDate"));
    }

    public void clickCalendarOption() {
        Waiters.waitABit(2000);
        Waiters.waitForPresenceOfElement("a[title='Toggle calendar']");
        clickOnElement(By.cssSelector("a[title='Toggle calendar']"));
    }

    public boolean isCalendarDisplayed() {
        WebElement calendar = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]"));
        return isElementDisplay(calendar);
    }

    public WebElement getTopIcon() { return findWebElement(topIcon); }

    public WebElement getProcessingLabel() { return findWebElement(processingLabel); }

    public WebElement getProcessingInput() { return findWebElement(processingInput); }

    public WebElement getToggleCalendar() { return findWebElement(toggleCalendar); }

    public WebElement getProcessButton() { return findWebElement(processButton); }

    public WebElement getUnprocessButton() { return findWebElement(unprocessButton); }

    public WebElement getAddButton() { return findWebElement(addButton); }

    public WebElement getDeleteButton() { return findWebElement(deleteButton); }

    public WebElement getProcessingGridHeader() { return findWebElement(processingGridHeader); }

    public WebElement getProcessingGridTable() { return findWebElement(processingGridTable); }

    public WebElement getAllOrdersList() { return findWebElement(allOrdersList); }

    public WebElement getFilteredOrdersList() { return findWebElement(filteredOrdersList); }

    public WebElement getUnbatchedOrdersList() { return findWebElement(unbatchedOrdersList); }

    public WebElement getBatchesIcon() { return findWebElement(batchesIcon); }

    public WebElement getBatchListIcon() { return findWebElement(batchListIcon); }

    public List<WebElement> getBatchesList() { return findWebElements(batchList); }

    public WebElement getOrderStatusesPanel() { return findWebElement(orderStatusesPanel); }

    public WebElement getShippedStatus() { return findWebElement(shippedStatus); }

    public WebElement getUnallocatedStatus() { return findWebElement(unallocatedStatus); }

    public WebElement getAllocatedStatus() { return findWebElement(allocatedStatus); }

    public WebElement getOrdersCount() { return findWebElement(ordersCount); }

    public WebElement getOrderDetails() { return findWebElement(orderDetails); }

    public WebElement getButtonClose() { return findWebElement(buttonClose); }

    public WebElement getBatchErrorPopUp() { return findWebElement(batchErrorPopUp); }

    public WebElement getOkButton() { return findWebElement(okButton); }

    public WebElement getYesButton() { return findWebElement(yesButton); }

    public WebElement getDeleteBatchPopUp() { return findWebElement(deleteBatchPopup); }

    public WebElement getDropdownList() { return findWebElement(dropdownList); }

    public WebElement getDialogContent() { return findWebElement(dialogContent); }

    public WebElement getNotificationMsg() { return findWebElement(notificationMsg); }

}
