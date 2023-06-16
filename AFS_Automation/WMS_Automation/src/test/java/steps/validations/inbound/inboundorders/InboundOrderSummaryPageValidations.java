package steps.validations.inbound.inboundorders;

import common.constants.Notifications;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.inbound.inboundorders.InboundOrderSummaryPage;

public class InboundOrderSummaryPageValidations {
    InboundOrderSummaryPage inboundOrderSummaryPage = new InboundOrderSummaryPage();

    @And("Validates Inbound Order Summary Page contains all web elements")
    public void validateInboundOrderSummaryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isTopIconPresent(), "Top Icon is not visible");
        softAssert.assertTrue(inboundOrderSummaryPage.isCardOrderSummaryFilterPresent(), "Card Order Summary Filter is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isCardOrderSummaryGridPresent(), "Card Order Summary Grid is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Inbound order summary Review page is displayed")
    public void validateReviewInboundOrderPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isProductColumnPresent(), "Product Column is not present");
        softAssert.assertTrue(inboundOrderSummaryPage.isDescriptionColumnPresent(), "Description Column is not present");
        softAssert.assertTrue(inboundOrderSummaryPage.isOrderedColumnPresent(), "Ordered Column is not present");
        softAssert.assertTrue(inboundOrderSummaryPage.isStagedColumnPresent(), "Staged Column is not present");
        softAssert.assertTrue(inboundOrderSummaryPage.isReceivedColumnPresent(), "Received Column is not present");
    //    softAssert.assertTrue(inboundOrderSummaryPage.isGtinColumnPresent(), "GTIN Column is not present");
        softAssert.assertTrue(inboundOrderSummaryPage.isExpDateColumnPresent(), "Exp Date Column is not present");
        softAssert.assertTrue(inboundOrderSummaryPage.isDateCodeColumnPresent(), "Date Code Column is not present");
  //      softAssert.assertTrue(inboundOrderSummaryPage.isQualifier1ColumnPresent(), "Qualifier1 Column is not present");
    //    softAssert.assertTrue(inboundOrderSummaryPage.isQualifier2ColumnPresent(), "Qualifier2 Column is not present");
    //    softAssert.assertTrue(inboundOrderSummaryPage.isQualifier3ColumnPresent(), "Qualifier3 Column is not present");
        softAssert.assertTrue(inboundOrderSummaryPage.isWeightColumnPresent(), "Weight Column is not present");
    //    softAssert.assertTrue(inboundOrderSummaryPage.isReviewOrderLabelPresent(), "Review Order Label is not present");
        softAssert.assertTrue(inboundOrderSummaryPage.isBtnReviewCancelPresent(), "Cancel Btn is not present");
        softAssert.assertTrue(inboundOrderSummaryPage.isBtnReviewSavePresent(), "Save Btn is not present");
        softAssert.assertAll();
    }

    @And("Validates orders are present on Inbound Order Summary page")
    public void validateOrdersPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!inboundOrderSummaryPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates orders are not present on Inbound Order Summary page")
    public void validateOrdersNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates Move popup on Inbound Order Summary page")
    public void validatePopupMoveColumns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundOrderSummaryPage.getWindowTitleText(), Notifications.MOVE,
                "Move popup page title is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isMoveShipDateDisplayed(),
                "Ship Date is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isMoveShipDateInputDisplayed(),
                "Ship Date input is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isLoadInputDisplayed(),
                "Load input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates items are present on Inbound Order Summary page")
    public void validateItemsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Change status title for Inbound Order Summary page")
    public void validatePopupChangeStatusTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundOrderSummaryPage.getDialogPopUpText(), Notifications.CHANGE_STATUS,
                "Popup Title " + Notifications.CHANGE_STATUS + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Reopen Order status on Inbound Order Summary page")
    public void verifyChangeStatusReOpenPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isReopenOrderStatusDisplayed(),"Reopen Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Finish Receiving Order status on Inbound Order Summary page")
    public void verifyChangeStatusFinishReceivingPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isFinishReceivingOrderDisplayed(),"Finish Receiving Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Ready To Receive Order status on Inbound Order Summary page")
    public void verifyChangeStatusReadyToReceivePopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isReadyToReceiveStatusDisplayed(),"Ready To Receive Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Change staged inventory content on Inbound Order Summary page")
    public void validateChangeStagedInventoryContent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundOrderSummaryPage.getDialogPopUpContentText(), Notifications.STAGED_INVENTORY,
                "Popup content " + Notifications.STAGED_INVENTORY + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Cancel Order status on Inbound Order Summary page")
    public void verifyChangeStatusCancelPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isCancelStatusDisplayed(),"Cancel Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Received, Staged, Over and Remainder are present on Inbound Order Summary page with correct color")
    public void validateProgressBarColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isReceivedQtyDisplayed(),"Received Qty is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isStagedQtyDisplayed(),"Staged Qty is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isRedQtyDisplayed(),"Red Qty is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isGrayQtyDisplayed(),"Gray Qty is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Source order screen on Inbound Order Summary page")
    public void verifySourceLoadScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isSourceOrderTypeDisplayed(),"Source Order Type is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isSourceOrderDisplayed(),"Source Order is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isSourceStatusDisplayed(),"Source Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Received, Staged and Remainder are present on Inbound Order Summary Source page with correct color")
    public void validateSourceProgressBarColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isReceivedQtyDisplayed(),"Received Qty is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isStagedQtyDisplayed(),"Staged Qty is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isGrayQtyDisplayed(),"Gray Qty is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Order option {string} on Inbound Order Summary page is disabled")
    public void validateOrderOptionIsNotActive(String option) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isOrderOptionDisabled(option),"Order Option is enabled");
        softAssert.assertAll();
    }

    @And("Validates Data option on Inbound Order Summary page is disabled")
    public void validateDataOptionIsNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isDataOptionDisabled(),"Data Option is enabled");
        softAssert.assertAll();
    }

    @And("Validates Save Button on Inbound Order Summary page is disabled")
    public void validateSaveButtonIsNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isSaveButtonDisabled(),"Save Button is enabled");
        softAssert.assertAll();
    }

    @And("Validates Save button is enabled on Inbound Order Summary page")
    public void validateSaveButtonIsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(inboundOrderSummaryPage.isSaveButtonDisabled(), "Save button is active");
        softAssert.assertAll();
    }

    @And("Validates Edit load popup on Inbound Order Summary page")
    public void verifyEditLoadPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isScheduledDateLabelDisplayed(),"Scheduled Date Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isScheduledDateDisplayed(),"Scheduled Date is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isScheduledTimeLabelDisplayed(),"Scheduled Time Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isScheduledTimeInputDisplayed(),"Scheduled Time Input is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isCarrierLabelDisplayed(),"Carrier Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isCarrierInputDisplayed(),"Carrier Input is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isTrailerLabelDisplayed(),"Trailer Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isTrailerInputDisplayed(),"Trailer Input is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isPaymentTypeLabelDisplayed(),"Payment Type Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isPaymentTypeInputDisplayed(),"Payment Type Input is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isCommentsLabelDisplayed(),"Comments Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isCommentsInputDisplayed(),"Comments Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates scheduled date {string} and scheduled time {string} on Inbound Order Summary page")
    public void validateDateAndTime(String date, String time) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.getScheduledDateValue().contains(date),
                "Scheduled date is not correct");
        softAssert.assertTrue(inboundOrderSummaryPage.getScheduledTimeValue().contains(time),
                "Scheduled time is not correct");
        softAssert.assertAll();
    }

    @And("Validates Enter data screen on Inbound Order Summary page")
    public void verifyEnterDataScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isTemperatureLabelDisplayed(),"Temperature Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isTemperatureInputDisplayed(),"Temperature Input is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isSealNumberLabelDisplayed(),"Seal Number Label is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isSealNumberInputDisplayed(),"Seal Number Input is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.areCommentsLabelsDisplayed() > 0,"Comments Labels are not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.areCommentsInputsDisplayed() > 0,"Comments Inputs are not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.areYesRadioButtonsDisplayed() > 0,"Yes Radio Buttons are not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.areNoRadioButtonsDisplayed() > 0,"No Radio Buttons is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isBtnAddProductCancelDisplayed(),"Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Assign doors title for Inbound Order Summary")
    public void validatePopupAssignDoorTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundOrderSummaryPage.getDialogPopUpText(), Notifications.ASSIGN_DOORS,
                "Popup Title " + Notifications.ASSIGN_DOORS + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Inbound Order Summary page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundOrderSummaryPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Receiver details on Inbound Order Summary page")
    public void validatePopupReceiverDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isReceiverDateColumnDisplayed(),"Receiver Date Column is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isReceiverFromStatusColumnDisplayed(),"Receiver From Status Column is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isReceiverToStatusColumnDisplayed(),"Receiver To Status Column is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isReceiverUserColumnDisplayed(),"Receiver User Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Add Filter on Inbound Order Summary page")
    public void validatePopupAddFilterDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isDateTimeCheckBoxDisplayed(),"Date Time CheckBox is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isFromStatusCheckBoxDisplayed(),"From Status CheckBox is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isToStatusCheckBoxDisplayed(),"To Status CheckBox is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isUserCheckBoxDisplayed(),"User CheckBox is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Load Images on Inbound Order Summary page")
    public void validateImagesForInboundOrder() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isSaveEditButtonDisplayed(), "Save Edit Button is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isInboundImageCaptureButtonDisplayed(), "Inbound Image Capture Button is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isSelectFilesBtnDisplayed(), "Select Files Button is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isLoadImageLabelDisplayed(), "Load Image Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Save and Cancel buttons for Load image on Inbound Order Summary page")
    public void verifySaveCancelButtons() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isSaveButtonDisplayed(),"Save Button is not displayed");
        softAssert.assertTrue(inboundOrderSummaryPage.isRouteBackButtonDisplayed(),"Route Back Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates warehouse dropdown is displayed on Inbound Order Summary page")
    public void validateWarehouse() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderSummaryPage.isWarehouseDisplayed(),"Warehouse dropdown is not displayed");
        softAssert.assertAll();
    }
}
