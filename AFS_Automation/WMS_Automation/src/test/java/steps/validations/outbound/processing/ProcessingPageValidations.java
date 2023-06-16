package steps.validations.outbound.processing;

import common.constants.FilePaths;
import common.constants.Notifications;
import common.constants.TimeFormats;
import common.utils.database.DataBaseConnection;
import common.utils.database.SqlQueriesUtils;
import common.utils.database.StoreProceduresUtils;
import common.utils.objectmapper.ObjectMapperWrapper;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import lombok.SneakyThrows;
import objects.orderdata.ProcessingOrderDTO;
import objects.storeproceduresdata.outbound.ProcessingParams;
import objects.userdata.DataBaseData;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import steps.LoginPageSteps;
import ui.pages.outbound.processing.AddAllocationBatchPage;
import ui.pages.outbound.processing.ProcessingPage;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static common.utils.time.TimeConversion.getFormattedDate;

public class ProcessingPageValidations {
    ProcessingPage processingPage = new ProcessingPage();
    StoreProceduresUtils storeProceduresUtils = new StoreProceduresUtils();
    SqlQueriesUtils sqlQueriesUtils = new SqlQueriesUtils();

    @And("Processing page contains all web elements")
    public void validateProcessingPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isTopIconDisplayed(), "Top Icon is not visible");
        softAssert.assertTrue(processingPage.isProcessButtonDisplayed(), "Process Button is not present");
        softAssert.assertTrue(processingPage.isUnprocessButtonDisplayed(), "Unprocess Button is not present");
        softAssert.assertTrue(processingPage.isAddButtonDisplayed(), "Add Button is not present");
        softAssert.assertTrue(processingPage.isDeleteButtonDisplayed(), "Delete Button is not present");
        softAssert.assertTrue(processingPage.isProcessingLabelDisplayed(), "Processing Label is not present");
        softAssert.assertTrue(processingPage.isProcessingInputDisplayed(), "Processing Input is not present");
        softAssert.assertAll();
    }

    @And("Validates orders list on Processing page is displayed")
    public void validateOrdersList() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isProcessingGridHeaderDisplayed(), "Processing Grid Header is not present");
        softAssert.assertTrue(processingPage.isProcessingGridTableDisplayed(), "Processing Grid Table is not present");
        softAssert.assertTrue(processingPage.getRowsCount() > 0, "Orders are not present in Processing Grid Table");
        softAssert.assertAll();
    }

    @And("Validates Yes and No buttons are displayed on Unprocess batch popup")
    public void validateYesNoButtons() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isYesButtonDisplayed(), "Yes button is not present");
        softAssert.assertTrue(processingPage.isNoButtonDisplayed(), "No button is not present");
        softAssert.assertAll();
    }

    @And("Validates Unprocess batch popup text")
    public void validateDialogContentText() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(processingPage.getDialogContentText(), Notifications.UNPROCESS_BATCH_MESSAGE,
                "Unprocess batch popup meessage is not correct");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Processing page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(processingPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates order details on Processing page")
    public void validateOrdersDetailsList() {
        SoftAssert softAssert = new SoftAssert();
        if(processingPage.getRowsCount() > 0) {
            processingPage.getRows()
                    .stream()
                    .forEach(item -> {
                        item.click();
                        softAssert.assertTrue(processingPage.getOrderDetailsInfo().contains("Order:"), "Order details are not displayed");
                        softAssert.assertTrue(processingPage.getOrderDetailsInfo().contains("Source:"), "Source details are not displayed");
                        softAssert.assertAll();
                    });
        }
    }

    @And("Validates order section is displayed on Processing page")
    public void validateOrderSection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isAllOrdersListDisplayed(), "All Orders List is not present");
        softAssert.assertTrue(processingPage.isFilteredOrdersListDisplayed(), "Filtered Orders List is not present");
        softAssert.assertTrue(processingPage.isUnbatchedOrdersListDisplayed(),
                    "Unbatched Orders List not present in Processing Grid Table");
        softAssert.assertTrue(processingPage.isBatchesIconDisplayed(),
                    "Batches List not present in Processing Grid Table");
        softAssert.assertAll();
    }

    @And("Validates all orders section is selected on Processing page")
    public void validateAllOrdersSectionIsSelected() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isAllOrdersListSelected(), "All Orders List is not selected");
        softAssert.assertAll();
    }

    @And("Validates default processing date on Processing page")
    public void validateProcessingDate() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(processingPage.getProcessingInputValue(), TimeConversion.getFormattedCurrentDate(TimeFormats
                .format_MMddyyyy), "Default Processing date is not correct");
        softAssert.assertAll();
    }

    @And("Validates batch list is displayed on Processing page")
    public void validateBatchList() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.getBatchesCount() > 0, "Batches are not present");
        softAssert.assertAll();
    }

    @And("Validate batch section is displayed on Processing page")
    public void validateBatchSectionIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isBatchesIconDisplayed(),"Batch Icon does not exist");
        softAssert.assertAll();
    }

    @And("Validate batch required error popup that batch is required on Processing page")
    public void validateBatchRequiredErrorPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(processingPage.getBatchErrorPopUpText(), Notifications.BATCH_REQUIRED,
                "Batch Error is not correct");
        softAssert.assertAll();
    }

    @And("Validate batch name error popup that batch is required on Processing page")
    public void validateBatchNameErrorPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(processingPage.getBatchErrorPopUpText(), Notifications.BATCH_NAME,"Batch Error is not correct");
        softAssert.assertAll();
    }

    @And("Validate batch is selected on Processing page")
    public void validateBatchIsSelected() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isBatchSelected(AddAllocationBatchPage.getBatchName()), "Batch is not selected");
        softAssert.assertAll();
    }

    @And("Validate batch is displayed on Processing page")
    public void validateBatchIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isBatchDisplayed(AddAllocationBatchPage.getBatchName()),"Batch does not exist");
        softAssert.assertAll();
    }

    @And("Validates date {string} value is correct on Processing page")
    public void validateDateValueIsCorrect(String date) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isDateValueExists(),"Date does not exist");
        softAssert.assertEquals(processingPage.isDateValueCorrect(), date,"Date Value Correct is not correct");
        softAssert.assertAll();
    }

    @And("Validates current date is correct on Processing page")
    public void validateCurrentDateIsCorrect() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isDateValueExists(),"Date does not exist");
        softAssert.assertEquals(processingPage.isDateValueCorrect(), TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy),"Current Date is not correct");
        softAssert.assertAll();
    }

    @And("Validates calendar is displayed on Processing page")
    public void validateCalendarIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isCalendarDisplayed(),"Calendar is not displayed");
        softAssert.assertAll();
    }

    @And("Validates order date {string} on Processing page")
    public void validateOrdersDate(String date) {
        SoftAssert softAssert = new SoftAssert();
        if(processingPage.getRowsCount() > 0) {
            softAssert.assertTrue(!processingPage.getOrdersDates().isEmpty(),
                    "Orders Dates do not exist");
            processingPage.getOrdersDates()
                    .stream()
                    .forEach( d -> {
                        softAssert.assertTrue(d.contains(date), "Orders Dates does not contain date " + date);
                    });
            softAssert.assertAll();
        }
    }

    @And("Validates statuses colors on Processing page")
    public void validateColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.getShippedStatusColorPoint().getAttribute("class").contains("green"),
                "Shipped Status Color is not Green");
        softAssert.assertTrue(processingPage.getUnallocatedStatusColorPoint().getAttribute("class").contains("orange"),
                "Shipped Status Color is not Green");
        softAssert.assertTrue(processingPage.getAllocatedStatusColorPoint().getAttribute("class").contains("yellow"),
                "Shipped Status Color is not Green");
        softAssert.assertAll();
    }

    @And("Validates orders number in not {string} on Processing page")
    public void getOrdersNumberNotNull(String number) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!processingPage.getOrdersNumber().equals(number),
                "Orders count is not correct" );
        softAssert.assertAll();
    }

    @And("Validates filtered order details: start date {string}, source {string}, year {string} on Processing page")
    public void validateFilteredOrderDetails(String startDate, String source, String year) {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> rows = processingPage.getFilteredOrders();
        for(int i = 0; i < processingPage.getFilteredOrdersNumber()-1; i++) {
            String date = Arrays.asList(processingPage.getFilteredOrderDetailsInfo(rows.get(i)).split("\\n"))
                    .stream()
                    .filter(el -> el.contains(year))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No Ship Date found"));
            String account = Arrays.asList(processingPage.getFilteredOrderDetailsInfo(rows.get(i)).split("\\n"))
                    .stream()
                    .filter(el -> el.equals(source))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No Source found"));
            softAssert.assertEquals(account, source, "Not correct Account " + account +  "is in Grid");
            softAssert.assertTrue(getFormattedDate(TimeFormats.format_yyyy_MM_dd, TimeFormats.format_MMddyyyy, startDate)
                    .before(getFormattedDate(TimeFormats.format_Mddyyyy, TimeFormats.format_MMddyyyy, date)),
                    "Date " + getFormattedDate(TimeFormats.format_Mddyyyy,TimeFormats.format_MMddyyyy, date) + " is not before start date " +
                            getFormattedDate(TimeFormats.format_yyyy_MM_dd, TimeFormats.format_MMddyyyy, startDate));
            softAssert.assertAll();
        }
    }

    @SneakyThrows
    @And("Validates Filtered order detail on Processing page")
    public void validateFilteredOrderDetail() {
        String year = "2022";
        DataBaseData dataBaseData = DataBaseData.builder()
                .username(LoginPageSteps.environment.getDbUserName())
                .password(LoginPageSteps.environment.getDbUserPassword())
                .host(LoginPageSteps.environment.getDbIp())
                .schema(LoginPageSteps.environment.getDbName())
                .build();
        ResultSet usersData = sqlQueriesUtils.getCurrentValidUser(DataBaseConnection
                .getDataBaseConnection(dataBaseData), "Ignition WMS");
        int userId = usersData.getInt(1);
        ProcessingParams processingParams = new ObjectMapperWrapper()
                .getObject(FilePaths.PROCESSING_DATA, ProcessingParams.class);
        processingParams.setSelected_date("2022-01-01");
        processingParams.setEnd_date("2022-03-01");
        processingParams.setSource("001001");
        processingParams.setCurrentuser_id(userId);
        ResultSet resultSet = storeProceduresUtils.executeStoreProcedureGetFilteredOrderProcessingList(DataBaseConnection
                .getDataBaseConnection(dataBaseData), processingParams);
        List<ProcessingOrderDTO> processingOrderDTO = new ArrayList<>();
        do {
            processingOrderDTO.add(ProcessingOrderDTO.builder()
                    .order(resultSet.getString(2).trim())
                    .shipDate(resultSet.getString(8).trim())
                    .source(resultSet.getString(9).trim())
                    .build());
        } while(resultSet.next());
        DataBaseConnection.closeDataBaseConnection();
        ProcessingPage processingPage = new ProcessingPage();
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> rows = processingPage.getFilteredOrders();
        String orderNo = Arrays.asList(processingPage.getFilteredOrderDetailsInfo(rows.get(0)).split("\\n"))
                .stream()
                .filter(el -> el.equals(processingOrderDTO.get(0).getOrder()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Order " + processingOrderDTO.get(0).getOrder() + " found"));
        String date = Arrays.asList(processingPage.getFilteredOrderDetailsInfo(rows.get(0)).split("\\n"))
                .stream()
                .filter(el -> el.contains(year))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Ship Date found"));
        softAssert.assertTrue(getFormattedDate(TimeFormats.format_yyyy_MM_dd, TimeFormats.format_MMddyyyy, processingParams.getSelected_date())
                        .before(getFormattedDate(TimeFormats.format_Mddyyyy, TimeFormats.format_MMddyyyy, date)),
                "Date " + getFormattedDate(TimeFormats.format_MMddyyyy, TimeFormats.format_MMddyyyy, date) + " is not before start date " +
                        getFormattedDate(TimeFormats.format_yyyy_MM_dd, TimeFormats.format_MMddyyyy, processingParams.getSelected_date()));
        softAssert.assertEquals(orderNo, processingOrderDTO.get(0).getOrder(),
                "Not correct Order " + processingOrderDTO.get(0).getOrder() +  "is in Grid");
        softAssert.assertAll();
    }

    @And("Validates filtered order contains No Record on Processing page")
    public void validateFilteredOrderNoRecord() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(processingPage.getFilteredOrders().get(0).getText(), Notifications.NO_RECORDS,
                "Notification " + Notifications.NO_RECORDS +  " is not in Grid");
        softAssert.assertAll();
    }

    @And("Validate Unbatched Order with index {int} is checked on Processing page")
    public void validateUnbatchedOrderIsChecked(int num) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isOrderUnbatchedChecked(num),
                "Unbatched Order is not checked");
        softAssert.assertAll();
    }

    @And("Validates batch is deleted on Processing page")
    public void validateDeleteBatchText() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(processingPage.getDeleteBatchText(), Notifications.BATCH_DELETE,
                "Delete Batch Notification is not correct");
        softAssert.assertAll();
    }

    @And("Validates Delete batch popup is displayed on Processing page")
    public void validateDeleteBatchPopUpIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(processingPage.isDeleteBatchPopupDisplayed(), "Delete Batch Popup is not present");
        softAssert.assertAll();
    }

    @And("Validates Delete batch popup is not displayed on Processing page")
    public void validateDeleteBatchPopUpIsNotDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(processingPage.isDeleteBatchPopupDisplayed(), "Delete Batch Popup is present");
        softAssert.assertAll();
    }
}
