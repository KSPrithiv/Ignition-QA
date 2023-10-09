package ui.pages.appointments;

import common.utils.Waiters;
import objects.orderdata.OrdersListDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentSchedulerOrderPage extends BasePage {
    By appointmentSchedulerIcon = By.xpath("//span[contains(text(), 'Appointment scheduler')]");
    By orderInput = By.cssSelector("#autoCompleteOrder");
    By clearButton = By.cssSelector("span[title='clear']");
    By ordersList = By.xpath("//div[contains(@class, 'k-animation-container-shown')]");
    By nextButton = By.cssSelector("#btnSave");
    By cancelButton = By.cssSelector("#btnCancel");
    By deliveryTypeLabel = By.cssSelector("#ddlDeliveryType-label");
    By deliveryTypeDropDown = By.cssSelector("#ddlDeliveryType");
    By emailLabel = By.cssSelector("#txtEmail-label");
    By emailInputBox = By.cssSelector("#txtEmail");
    By alt1Label = By.cssSelector("#txt2-label");
    By alt1InputBox = By.cssSelector("#txt2");
    By alt2Label = By.cssSelector("#txt3-label");
    By alt2InputBox = By.cssSelector("#txt3");
    By deleteButton = By.cssSelector("#btnDelete");
    By submitButton = By.cssSelector("#btnSave");
    By dateInput = By.cssSelector("#dateInputSchdulerDate");
    By toggleCalendar = By.cssSelector("a[title='Toggle calendar']");
    By tableHeader = By.xpath("//div[@class='k-grid-header']");
    By tableContent = By.xpath("//table[@class='k-grid-table']");
    By orderColumn = By.xpath("//span[contains(text(), 'Order #')]");
    By altOrderColumn = By.xpath("//span[contains(text(), 'Alt order #')]");
    By warehouseColumn = By.xpath("//span[contains(text(), 'Warehouse')]");
    By sourceColumn = By.xpath("//span[contains(text(), 'Source')]");
    By orderTypeColumn = By.xpath("//span[contains(text(), 'Order type')]");
    By qtyColumn = By.xpath("//span[contains(text(), 'Qty')]");
    By invalidOrder = By.xpath("//span[contains(text(), 'Invalid order')]");

    public void waitForAppointmentSchedulerPageToLoad() {
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitForElementToBeDisplay(getAppointmentSchedulerIcon());
    }

    public void addValidOrder(CharSequence orderNum) {
        Waiters.waitForElementToBeDisplay(getOrderInput());
        doubleClick(getOrderInput());
        inputText(getOrderInput(), orderNum);
        clickOnElement(findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + orderNum + "')]")));
        Waiters.waitABit(2000);
    }

    public void typeOrderNumber(CharSequence orderNum) {
        Waiters.waitForElementToBeDisplay(getOrderInput());
        doubleClick(getOrderInput());
        inputText(getOrderInput(), orderNum);
    }

    public void addValidOrderThatOnInboundRouteWithOtherOrders(CharSequence orderNum) {
        Waiters.waitForElementToBeDisplay(getOrderInput());
        doubleClick(getOrderInput());
        pressDelete(getOrderInput());
        enterText(getOrderInput(), orderNum);
        pressTab(getOrderInput());
        pressBackSpace(getOrderInput());
        Waiters.waitABit(2000);
        inputText(getOrderInput(), orderNum.subSequence(orderNum.length()-1, orderNum.length()));
    }

    public void selectDeliveryType(CharSequence deliveryType) {
        Waiters.waitForElementToBeDisplay(getDeliveryTypeDropDown());
        clickOnElement(getDeliveryTypeDropDown());
        WebElement type = findWebElement(By.xpath("//div[contains(@class, 'k-animation-container-shown')]//*[contains(text(), '"
                + deliveryType + "')]"));
        clickOnElement(type);
    }

    public void clearOrderInput() {
        Waiters.waitForElementToBeDisplay(getClearButton());
        clickOnElement(getClearButton());
    }

    public void deleteOrderCharacter() {
        Waiters.waitForElementToBeDisplay(getClearButton());
        deleteCharacter(getOrderInput());
    }

    public void selectOrderByRowNumber(int row) {
        Waiters.waitForPresenceOfAllElements(tableContent);
        WebElement order = getTableContent().findElements(By.xpath(".//tr")).get(row);
        clickOnElement(order);
    }

    public void clickDeleteButton() {
        Waiters.waitForElementToBeClickable(getDeleteButton());
        clickOnElement(getDeleteButton());
    }

    public void clickNextButton() {
        Waiters.waitForElementToBeClickable(getNextButton());
        clickOnElement(getNextButton());
    }

    public void clickCancelButton() {
        Waiters.waitForElementToBeClickable(getCancelButton());
        clickOnElement(getCancelButton());
    }

    public void clickSubmitButton() {
        Waiters.waitABit(1000);
        clickOnElement(getSubmitButton());
    }

    public void clearAlt1InputBox() {
        Waiters.waitForElementToBeDisplay(getAlt1InputBox());
        clearText(getAlt1InputBox());
    }

    public void clearAlt2InputBox() {
        Waiters.waitForElementToBeDisplay(getAlt2InputBox());
        clearText(getAlt2InputBox());
    }

    public String getSubmitButtonDisabilityResult() {
        return checkElementAttribute(getSubmitButton(), "aria-disabled");
    }

    public OrdersListDTO getTableData(int rowNumber) {
        Waiters.waitABit(8000);
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> rows = getTableContent().findElements(By.xpath(".//tr"));
        Waiters.waitABit(2000);
        List<String> orderData = rows.get(rowNumber).findElements(By.xpath(".//td"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
       return OrdersListDTO.builder()
               .orderNumber(orderData.get(0))
               .altOrderNumber(orderData.get(1))
               .warehouse(orderData.get(2))
               .source(orderData.get(3))
               .orderType(orderData.get(4))
               .qty(orderData.get(5))
               .build();
    }

    public int getRowsCount() {
        Waiters.waitForElementToBeDisplay(tableContent);
        List<WebElement> rows = getTableContent().findElements(By.xpath(".//tr"));
        Waiters.waitABit(2000);
        return rows.size();
    }

    public void inputEmail(String email) {
        Waiters.waitForElementToBeDisplay(getEmailInputBox());
        inputText(getEmailInputBox(), email);
    }

    public void clearAlt1() {
        Waiters.waitForElementToBeDisplay(getAlt1InputBox());
        doubleClick(getAlt1InputBox());
        pressDelete(getAlt1InputBox());
    }

    public void enterDate(String date) {
        Waiters.waitForElementToBeClickable(getToggleCalendar());
        clickOnElement(getToggleCalendar());
        Waiters.waitABit(2000);
        String day = date.substring(3, 5).contains("0") ? date.substring(4, 5) : date.substring(3, 5);
        clickOnElement(getCalendarDay(day));
        Waiters.waitABit(2000);
    }

    public void inputAlt1(String atl1) {
        Waiters.waitForElementToBeDisplay(getAlt1InputBox());
        inputText(getAlt1InputBox(), atl1);
    }

    public void inputAlt2(String atl2) {
        Waiters.waitForElementToBeDisplay(getAlt2InputBox());
        inputText(getAlt2InputBox(), atl2);
    }

    public String getInvalidOrderWarning() {
        Waiters.waitForElementToBeDisplay(getInvalidOrderNotification());
        return getText(getAlt2InputBox());
    }

    public boolean isInvalidOrderWarningHasText(String text) {
        Waiters.waitForElementToBeDisplay(getInvalidOrderNotification());
        return getText(getInvalidOrder()).contains(text);
    }

    public String getNextButtonDisabilityResult() {
        return getElementAttribute(getNextButton(), "aria-disabled");
    };

    public boolean isAppointmentSchedulerHeaderDisplayed() {
       return isElementDisplay(getTableHeader());
    }

    public boolean isAppointmentSchedulerOrderDisplayed() {
        return isElementDisplay(getOrderInput());
    }

    public boolean isOrderColumnDisplayed() { return isElementDisplay(getOrderColumn()); }

    public boolean isAltOrderColumnDisplayed() {
        return isElementDisplay(getAltOrderColumn());
    }

    public boolean isWarehouseColumnDisplayed() {
        return isElementDisplay(getWarehouseColumn());
    }

    public boolean isSourceColumnDisplayed() {
        return isElementDisplay(getSourceColumn());
    }

    public boolean isOrderTypeColumnDisplayed() {
        return isElementDisplay(getOrderTypeColumn());
    }

    public boolean isQtyColumnDisplayed() {
        return isElementDisplay(getQtyColumn());
    }

    public boolean isDeliveryTypeLabelDisplayed() {
        return isElementDisplay(getDeliveryTypeLabel());
    }

    public boolean isDeliveryTypeDropDownDisplayed() {
        return isElementDisplay(getDeliveryTypeDropDown());
    }

    public String getDeliveryTypeDropDownText() {
        return getText(getDeliveryTypeDropDown());
    }

    public boolean isEmailLabelDisplayed() {
        return isElementDisplay(getEmailLabel());
    }

    public boolean isEmailInputBoxDisplayed() {
        return isElementDisplay(getEmailInputBox());
    }

    public boolean isAlt1LabelDisplayed() {
        return isElementDisplay(getAlt1Label());
    }

    public boolean isAlt1InputBoxDisplayed() {
        return isElementDisplay(getAlt1InputBox());
    }

    public boolean isAlt2LabelDisplayed() { return isElementDisplay(getAlt2Label());    }

    public boolean isAlt2InputBoxDisplayed() {
        return isElementDisplay(getAlt2InputBox());
    }

    public boolean isNotificationDisplayed(String text) { return isElementDisplay(getNotification(text)); }

    public WebElement getAppointmentSchedulerIcon() {
        return findWebElement(appointmentSchedulerIcon);
    }

    public WebElement getOrderInput() {
        return findWebElement(orderInput);
    }

    public WebElement getClearButton() {
        return findWebElement(clearButton);
    }

    public WebElement getOrdersList() { return findWebElement(ordersList); }

    public WebElement getTableHeader() {
        return findWebElement(tableHeader);
    }

    public WebElement getNextButton() { return findWebElement(nextButton); }

    public WebElement getCancelButton() { return findWebElement(cancelButton); }

    public WebElement getSubmitButton() { return findWebElement(submitButton); }

    public WebElement getDeliveryTypeLabel() { return findWebElement(deliveryTypeLabel); }

    public WebElement getDeliveryTypeDropDown() { return findWebElement(deliveryTypeDropDown); }

    public WebElement getEmailLabel() { return findWebElement(emailLabel); }

    public WebElement getDateInput() { return findWebElement(dateInput); }

    public WebElement getToggleCalendar() { return findWebElement(toggleCalendar); }

    public WebElement getEmailInputBox() { return findWebElement(emailInputBox); }

    public WebElement getAlt1Label() { return findWebElement(alt1Label); }

    public WebElement getAlt1InputBox() { return findWebElement(alt1InputBox); }

    public WebElement getAlt2Label() { return findWebElement(alt2Label); }

    public WebElement getAlt2InputBox() { return findWebElement(alt2InputBox); }

    private WebElement getNotification(String text) { return findWebElement(By.xpath("//div[text()='" + text + "']"));  }

    private WebElement getCalendarDay(String text) {
        return findWebElement(By.xpath("//div[contains(@class, 'k-calendar-container')]//*[contains(text(), '" + text + "')]"));
    }

    public WebElement getDeleteButton() { return findWebElement(deleteButton); }

    public WebElement getTableContent() { return findWebElement(tableContent); }

    public WebElement getOrderColumn() {
        return findWebElement(orderColumn);
    }

    public WebElement getAltOrderColumn() {
        return findWebElement(altOrderColumn);
    }

    public WebElement getWarehouseColumn() {
        return findWebElement(warehouseColumn);
    }

    public WebElement getSourceColumn() {
        return findWebElement(sourceColumn);
    }

    public WebElement getOrderTypeColumn() {
        return findWebElement(orderTypeColumn);
    }

    public WebElement getQtyColumn() {
        return findWebElement(qtyColumn);
    }

    public WebElement getInvalidOrderNotification() { return findWebElement(invalidOrder); }

    public By getInvalidOrder() {
        return invalidOrder;
    }

}
