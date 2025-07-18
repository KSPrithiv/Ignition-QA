package ui.pages.outbound.processing;

import common.utils.Waiters;
import objects.processedorderdata.OrdersListDTO;
import objects.processedorderdata.ProductsDTO;
import objects.processedorderdata.ResponseDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static common.setup.DriverManager.getDriver;

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
    By processingGridTable = By.cssSelector(".k-grid tbody");
    By allOrdersList = By.cssSelector("#divAllOrders");
    By filteredOrdersList = By.cssSelector("#divFilteredOrders");
    By unbatchedOrdersList = By.cssSelector("#divUnbatchedOrders");
    By batchesIcon = By.xpath("//div[text()='Batches']");
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
    By okButton = By.xpath("//span[contains(text(), 'OK')]/parent::button");
    By deleteBatchPopup = By.cssSelector(".k-window-content");
    By yesButton = By.xpath("//span[contains(text(), 'Yes')]");
    By noButton = By.xpath("//span[contains(text(), 'No')]");
    By dropdownList = By.id("dropdownList");
    By dialogContent = By.cssSelector(".k-dialog-content");
    By notificationMsg = By.cssSelector(".toast-message");
    By loader = By.cssSelector(".loader");

    public void waitProcessingPageToLoad() {
        waitUntilInvisible(1, loader);
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getTopIcon());
    }

    public String getBatchErrorPopUpText() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(batchErrorPopUp);
        return getText(batchErrorPopUp).trim();
    }

    public void clickOkButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(okButton);
        clickOnElement(By.xpath("//button[contains(text(), 'OK')]"));
    }

    public List<WebElement> getRows() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(processingGridTable);
        return getProcessingGridTable().findElements(By.xpath(".//tr"));
    }

    public int getRowsCount() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(processingGridTable);
        return getProcessingGridTable().findElements(By.xpath(".//tr")).size();
    }

    public int getBatchesCount() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementsToBeDisplay(getBatchesList());
        return getBatchesList().size();
    }

    public void clickAllOrders() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeClickable(allOrdersList);
        clickOnElement(getAllOrdersList());
        waitUntilInvisible(1, loader);
    }

    public void clickFilteredOrders() {
        waitUntilInvisible(1, loader);
        clickOnElement(getFilteredOrdersList());
    }

    public String getDeleteBatchText() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(deleteBatchPopup);
        return getText(By.cssSelector(".k-window-content"));
    }

    public String getProcessingInputValue() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(processingInput);
        return getValue(processingInput);
    }

    public void clickCloseButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeClickable(getButtonClose());
        clickOnElement(getButtonClose());
    }

    public void clickDeleteButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector("#addLocProdButton3"));
        clickOnElement(getDeleteButton());
        Waiters.waitABit(2000);
    }

    public void clickUnbatchedOrders() {
        Waiters.waitForElementToBeClickable(unbatchedOrdersList);
        clickOnElement(getUnbatchedOrdersList());
        Waiters.waitABit(5000);
    }

    public void clickOrderByNumber(int num) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        Waiters.waitABit(2000);
        clickOnElement(getProcessingGridTable().findElements(By.xpath(".//tr")).get(num));
        Waiters.waitABit(2000);
    }

    public void selectWarehouse(String warehouse) {
        Waiters.waitTillLoadingPage(getDriver());
        clickOnElement(getDropdownList());
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//li[contains(text(), '"
                + warehouse + "') and @role='option']")));
        Waiters.waitABit(2000);
    }

    public void clickOrderByName(String orderName) {
        Waiters.waitTillLoadingPage(getDriver());
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
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getUnbatchedOrdersList());
        Waiters.waitABit(2000);
        clickOnElement(getProcessingGridTable().findElements(By.cssSelector("tr input")).get(num));
        Waiters.waitABit(2000);
    }

    public void checkOrderByNumber(int num) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        Waiters.waitABit(2000);
        clickOnElement(getProcessingGridTable().findElements(By.cssSelector("tr input")).get(num));
        Waiters.waitABit(2000);
    }

    public void dragAndDropOrderToBatch(int num, String batchName) {
        Waiters.waitTillLoadingPage(getDriver());
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
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getUnbatchedOrdersList());
        Waiters.waitABit(2000);
        return getElementAttribute(getProcessingGridTable()
                .findElements(By.xpath(".//tr")).get(num), "class")
                .contains("state-selected");
    }

    public void clickBatches() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(batchesIcon);
        waitUntilInvisible(1, loader);
        clickOnElement(getBatchesIcon());
        Waiters.waitABit(2000);
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

    public void clickBatch(String batchName) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(batchList);
        Waiters.waitABit(3000);
        WebElement batch = getBatchesList().stream()
           .filter(b -> b.getText().contains(batchName))
           .findFirst()
          .orElseThrow(() -> new IllegalArgumentException(("Batch " + batchName + " does not present")));
        Waiters.waitABit(3000);
        clickOnElement(batch);
    }

    public boolean isBatchSelected(String batchName) {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementsToBeDisplay(getBatchesList());
        WebElement batch = getBatchesList().stream()
                .filter(b -> b.getText().equals(batchName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(("Batch " + batchName + " does not present")));
        clickOnElement(batch);
        return getElementAttribute(batch, "class").contains("DivSelected");
    }

    public void clickAddButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeClickable(getAddButton());
        clickOnElement(getAddButton());
    }

    public void clickProcessButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeClickable(getProcessButton());
        clickOnElement(getProcessButton());
    }

    public void clickUnprocessButton() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeClickable(getUnprocessButton());
        clickOnElement(getUnprocessButton());
    }

    public void selectDate(String date) {
        Waiters.waitTillLoadingPage(getDriver());
        waitUntilStalenessOf(1, getProcessingInput());
        Waiters.waitForElementToBeDisplay(getProcessingInput());
        doubleClick(getProcessingInput());
        pressDelete(getProcessingInput());
        inputText(getProcessingInput(), date);
        Waiters.waitABit(2000);
        pressEnter(getProcessingInput());
    }

    public List<String> getOrdersDates() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeDisplay(processingGridTable);
        return getProcessingGridTable()
                .findElements(By.cssSelector(".CPKendoDataGrid-Date"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getShippedStatusColorPoint() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getShippedStatus());
        return getShippedStatus().findElement(By.xpath("span"));
    }

    public WebElement getUnallocatedStatusColorPoint() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getUnallocatedStatus());
        return getUnallocatedStatus().findElement(By.xpath("span"));
    }

    public WebElement getAllocatedStatusColorPoint() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getAllocatedStatus());
        return getAllocatedStatus().findElement(By.xpath("span"));
    }

    public String getOrdersNumber() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getOrdersCount());
        return getOrdersCount().getText();
    }

    public String getDialogContentText() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getDialogContent());
        return getDialogContent().getText();
    }

    public String getOrderDetailsInfo() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getOrderDetails());
        return getOrderDetails().getText().trim();
    }

    public String getFilteredOrderDetailsInfo(WebElement element) {
        Waiters.waitTillLoadingPage(getDriver());
        return element.getText().trim();
    }

    public List<WebElement> getFilteredOrders() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        return getProcessingGridTable().findElements(By.xpath(".//tr"));
    }

    public int getFilteredOrdersNumber() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(getProcessingGridTable());
        return getProcessingGridTable().findElements(By.xpath(".//tr")).size();
    }

    public boolean isDeleteBatchPopupDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getDeleteBatchPopUp());
    }

    public boolean isBatchDisplayed(String name) {
        Waiters.waitTillLoadingPage(getDriver());
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

    public boolean isTopIconDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getTopIcon());
    }

    public boolean isProcessingLabelDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getProcessingLabel());
    }

    public boolean isProcessingInputDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getProcessingInput());
    }

    public boolean isProcessButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getProcessButton());
    }

    public boolean isUnprocessButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getUnprocessButton());
    }

    public boolean isAddButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getAddButton());
    }

    public boolean isDeleteButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getDeleteButton());
    }

    public boolean isProcessingGridHeaderDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getProcessingGridHeader());
    }

  /*  public boolean isProcessingGridTableDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getProcessingGridTable());
    }*/
  public boolean isProcessingGridTableDisplayed() {
      Waiters.waitTillLoadingPage(getDriver());
      try {
          WebElement tableBody = getProcessingGridTable();
          List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
          return tableBody.isDisplayed() && !rows.isEmpty();
      } catch (Exception e) {
          return false;
      }
  }


    public boolean isAllOrdersListDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getAllOrdersList());
    }

    public boolean isFilteredOrdersListDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getFilteredOrdersList());
    }

    public boolean isUnbatchedOrdersListDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getUnbatchedOrdersList());
    }

    public boolean isBatchesIconDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(getBatchesIcon());
    }

    public boolean isYesButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(yesButton);
    }

    public boolean isNoButtonDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
        return isElementDisplay(noButton);
    }

    public boolean isAllOrdersListSelected() {
        Waiters.waitTillLoadingPage(getDriver());
        return !getAllOrdersList().getAttribute("style").contains("black");
    }

    public String getDateValue() {
        Waiters.waitTillLoadingPage(getDriver());
        return getValue(By.cssSelector("#dtProcessingDate"));
    }

    public String isDateValueCorrect() {
        Waiters.waitTillLoadingPage(getDriver());
        return getValue(By.cssSelector("#dtProcessingDate"));
    }

    public boolean isDateValueExists() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector("#dtProcessingDate"));
        return isElementDisplay(By.cssSelector("#dtProcessingDate"));
    }

  /*  public void clickCalendarOption() {
        Waiters.waitTillLoadingPage(getDriver());
        Waiters.waitForElementToBeDisplay(By.cssSelector("a[title='Toggle calendar']"));
        clickOnElement(By.cssSelector("a[title='Toggle calendar']"));
    }*/

    public void clickCalendarOption() {
        try {
            By calendarToggle = By.cssSelector("button[title='Toggle calendar']");

            Waiters.waitTillLoadingPage(getDriver());

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement calendarIcon = wait.until(ExpectedConditions.elementToBeClickable(calendarToggle));
            calendarIcon.click();

            System.out.println(" Calendar toggle clicked successfully.");

        } catch (TimeoutException | NoSuchElementException e) {
            System.err.println("Failed to locate or click the calendar toggle.");
            System.err.println("Page Title: " + getDriver().getTitle());
            System.err.println("Current URL: " + getDriver().getCurrentUrl());
            throw e;
        }
    }



    public boolean isCalendarDisplayed() {
        Waiters.waitTillLoadingPage(getDriver());
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
