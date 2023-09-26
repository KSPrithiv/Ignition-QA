package steps.validations.inbound.loads;

import common.constants.Notifications;
import common.constants.TimeFormats;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.inbound.loads.InboundLoadSummaryPage;
import java.util.Calendar;

public class InboundLoadSummaryPageValidations {
    InboundLoadSummaryPage inboundLoadSummaryPage = new InboundLoadSummaryPage();

    @And("Inbound Load Summary page main elements are present")
    public void validateInboundLoadSummaryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isTopIconPresent(), "Top Icon is not visible");
        softAssert.assertTrue(inboundLoadSummaryPage.isDateRouteStartPresent(), "Date Route Start is not visible");
        softAssert.assertTrue(inboundLoadSummaryPage.isDateRouteEndPresent(), "Date Route End is not visible");
        softAssert.assertTrue(inboundLoadSummaryPage.isStatusDropDownPresent(), "Status dropdown is not visible");
        softAssert.assertTrue(inboundLoadSummaryPage.isCardRouteSummaryFilterPresent(), "Card Route Summary Filter is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isCardRouteSummaryGridPresent(), "Card Route Summary Grid is not displayed");
        softAssert.assertAll();
      }

    @And("Inbound Load Summary Details page main elements are present")
    public void validateInboundLoadSummaryDetailsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isLoadFieldDisplayed(), "Load Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isLoadNumberDisplayed(), "Load Number is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isDoorFieldDisplayed(), "Door Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isQaFieldDisplayed(), "Qa Field End is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isCarrierFieldDisplayed(), "Carrier Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isOrdersFieldDisplayed(), "Orders Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isQtyFieldDisplayed(), "Qty Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isCubeFieldDisplayed(), "Cube Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isWeightFieldDisplayed(), "Weight Field is not displayed");
        softAssert.assertAll();
    }

    @And("Inbound Load Summary Staging screen with elements is displayed")
    public void validateInboundLoadSummaryStagingPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isReceivedLabelDisplayed(), "Received Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isReviewLoadLabelDisplayed(), "Review Load is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isProductColumnDisplayed(), "Product Column is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isDescriptionColumnDisplayed(), "Description Column is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isQualifier1ColumnDisplayed(), "Qualifier Column is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isOrderedColumnDisplayed(), "Ordered Column is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isStagedColumnDisplayed(), "Staged Column is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isReceivedColumnDisplayed(), "Received Column is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isExpDateColumnDisplayed(), "Exp Date Column is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isDateCodeColumnDisplayed(), "Date Code Column is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isCancelBtnDisplayed(), "Cancel Btn is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isSaveBtnDisplayed(), "Save Btn is not displayed");
        softAssert.assertAll();
    }

    @And("Inbound Load Order Summary Details page main elements are present")
    public void validateInboundLoadOrderSummaryDetailsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isOrdersFieldDisplayed(), "Load Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isLoadFieldDisplayed(), "Load Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isLoadNumberDisplayed(), "Load Number is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isDoorFieldDisplayed(), "Door Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isQaFieldDisplayed(), "Qa Field End is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isCarrierFieldDisplayed(), "Carrier Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isOrdersFieldDisplayed(), "Orders Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isQtyFieldDisplayed(), "Qty Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isCubeFieldDisplayed(), "Cube Field is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isWeightFieldDisplayed(), "Weight Field is not displayed");
        softAssert.assertAll();
    }

    @And("Validates default values of Start Date and End date on Inbound Load Summary page")
    public void validateDefaultStartDateAndEndDate() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadSummaryPage.getDateRouteStartValue(), TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy),"Route Start Date is not correct");
        softAssert.assertEquals(inboundLoadSummaryPage.getDateRouteEndValue(), TimeConversion.futureDate(1,
                Calendar.DATE, TimeConversion.getFormattedDateTime(TimeFormats.format_MMddyyyy),
                TimeFormats.format_MMddyyyy), "Route End Date is not correct");
        softAssert.assertAll();
    }

    @And("Validates loads are present on Inbound Load Summary page")
    public void validateLoadsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!inboundLoadSummaryPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates orders are present for load on Inbound Load Summary page")
    public void validateOrdersPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!inboundLoadSummaryPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates orders are not present for load on Inbound Load Summary page")
    public void validateOrdersNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates Yes Button and No Button are present on load popup on Inbound Load Summary page")
    public void validateYesButtonAndNoButtonPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isYesButtonDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isNoButtonDisplayed(),"Items Found Value is not displayed");
        softAssert.assertAll();
    }

    @And("Validates images are present on Inbound Load Summary page")
    public void validateImagesPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isImagesButtonDisplayed(),"Images Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates warehouse dropdown is displayed on Inbound Load Summary page")
    public void validateWarehouse() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isWarehouseDisplayed(),"Warehouse dropdown is not displayed");
        softAssert.assertAll();
    }

    @And("Validates comments are present on Inbound Load Summary page")
    public void validateCommentsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isCommentsButtonDisplayed(),"Comments Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Received, Staged, Over and Remainder are present on Inbound Load Summary page with correct color")
    public void validateProgressBarColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isReceivedQtyDisplayed(),"Received Qty is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isStagedQtyDisplayed(),"Staged Qty is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isRedQtyDisplayed(),"Red Qty is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isGrayQtyDisplayed(),"Gray Qty is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Received, Staged and Remainder are present on Inbound Load Summary Source page with correct color")
    public void validateSourceProgressBarColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isReceivedQtyDisplayed(),"Received Qty is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isStagedQtyDisplayed(),"Staged Qty is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isGrayQtyDisplayed(),"Gray Qty is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Items found is displayed on Inbound Load Summary page")
    public void validateItemsFoundPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!inboundLoadSummaryPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates Items found not displayed on Inbound Load Summary page")
    public void validateItemsFoundNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates Items are displayed on Inbound Load Summary page")
    public void validateItemsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertAll();
    }

    @And("Validates No Record Inbound Load Summary grid")
    public void validateNoRecordInOutboundOrderSummaryGrid() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.getGridTableRowContent(0)
                .contains(Notifications.NO_DATA), "Loads are present in table");
        softAssert.assertAll();
    }

    @And("Validates Images page are displayed on Inbound Load Summary page")
    public void validateImagesPageDetailsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isSelectFilesBtnDisplayed(),"Select files button is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isLoadImageLabelDisplayed(),"Load Images label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isSaveEditButtonDisplayed(),"Save button is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isInboundImageCaptureButtonDisplayed(),"Image Capture button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Assign doors title for Inbound Load Summary")
    public void validatePopupAssignDoorTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadSummaryPage.getDialogPopUpText(), Notifications.ASSIGN_DOORS,
                "Popup Title " + Notifications.ASSIGN_DOORS + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Change status title for Inbound Load Summary")
    public void validatePopupChangeStatusTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadSummaryPage.getDialogPopUpText(), Notifications.CHANGE_STATUS,
                "Popup Title " + Notifications.CHANGE_STATUS + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Change stage title for Inbound Load Summary")
    public void validatePopupChangeStageTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadSummaryPage.getDialogPopUpText(), Notifications.CHANGE_STAGE,
                "Popup Title " + Notifications.CHANGE_STAGE + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates warning message title for Inbound Load Summary")
    public void validateWarningMessageTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadSummaryPage.getDialogPopUpText(), Notifications.WARNING_MESSAGE,
                "Popup Title " + Notifications.WARNING_MESSAGE + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Change stage content for Inbound Load Summary")
    public void validateChangeStageContent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadSummaryPage.getDialogPopUpContentText(), Notifications.STAGE_LOAD,
                "Popup content " + Notifications.STAGE_LOAD + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Change staged inventory content for Inbound Load Summary")
    public void validateChangeStagedInventoryContent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadSummaryPage.getDialogPopUpContentText(), Notifications.STAGED_INVENTORY,
                "Popup content " + Notifications.STAGED_INVENTORY + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Quantity received is less than Order quantity inventory content for Inbound Load Summary")
    public void validateQuantityReceivedLessOrderQuantityContent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadSummaryPage.getDialogPopUpContentText(), Notifications.QUANTITY_RECEIVED_LESS_ORDER_QUANTITY,
                "Popup content " + Notifications.QUANTITY_RECEIVED_LESS_ORDER_QUANTITY + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Inbound Load Summary page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadSummaryPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Enter data screen on Inbound Load Summary page")
    public void verifyEnterDataScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isTemperatureLabelDisplayed(),"Temperature Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isTemperatureInputDisplayed(),"Temperature Input is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isSealNumberLabelDisplayed(),"Seal Number Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isSealNumberInputDisplayed(),"Seal Number Input is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.areCommentsLabelsDisplayed() > 0,"Comments Labels are not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.areCommentsInputsDisplayed() > 0,"Comments Inputs are not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.areYesRadioButtonsDisplayed() > 0,"Yes Radio Buttons are not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.areNoRadioButtonsDisplayed() > 0,"No Radio Buttons is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isBtnAddProductCancelDisplayed(),"Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Data option on Inbound Load Summary page is disabled")
    public void verifyDataOptionDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isDataOptionDisabled().equals("true"),"Data option is enabled");
        softAssert.assertAll();
    }

    @And("Validates Edit on Inbound Load Summary page is disabled")
    public void verifyEditDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isEditDisabled().equals("true"),"Edit is enabled");
        softAssert.assertAll();
    }

    @And("Validates Source on Inbound Load Summary page is disabled")
    public void verifySourceDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isSourceDisabled().equals("true"),"Source is enabled");
        softAssert.assertAll();
    }

    @And("Validates Receive on Inbound Load Summary page is disabled")
    public void verifyReceiveDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isReceiveDisabled().equals("true"),"Receive is enabled");
        softAssert.assertAll();
    }

    @And("Validates Edit load popup on Inbound Load Summary page")
    public void verifyEditLoadPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isLoadCodeLabelDisplayed(),"Load Code Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isLoadCodeInputDisplayed(),"Load Code Input is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isScheduledDateLabelDisplayed(),"Scheduled Date Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isScheduledDateDisplayed(),"Scheduled Date is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isCarrierLabelDisplayed(),"Carrier Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isCarrierInputDisplayed(),"Carrier Input is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isTrailerLabelDisplayed(),"Trailer Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isTrailerInputDisplayed(),"Trailer Input is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isDoorLabelDisplayed(),"Door Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isDoorInputDisplayed(),"Door Input is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isLoadTypeLabelDisplayed(),"Load Type Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isLoadTypeInputDisplayed(),"Load Type Input is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isScheduledTimeLabelDisplayed(),"Scheduled Time Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isScheduledTimeInputDisplayed(),"Scheduled Time Input is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isDriverLabelDisplayed(),"Driver Label is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isDriverInputDisplayed(),"Driver Input is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isTemperatureFieldDisplayed(),"Temperature Field is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Source load screen on Inbound Load Summary page")
    public void verifySourceLoadScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isSourceOrderTypeDisplayed(),"Source Order Type is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isSourceOrderDisplayed(),"Source Order is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isSourceStatusDisplayed(),"Source Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Ready To Receive and Cancel Inbound statuses on Inbound Load Summary page")
    public void verifyChangeStatusPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isReadyToReceiveStatusDisplayed(),"Ready To Receive Status is not displayed");
        softAssert.assertTrue(inboundLoadSummaryPage.isCancelInboundStatusDisplayed(),"Cancel Inbound Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Reopen Order status on Inbound Load Summary page")
    public void verifyChangeStatusReOpenPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isReopenOrderStatusDisplayed(),"Reopen Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Finish Receiving status on Inbound Load Summary page")
    public void verifyChangeStatusFinishReceivingPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadSummaryPage.isFinishReceivingOrderDisplayed(),"Finish Receiving Status is not displayed");
        softAssert.assertAll();
    }

}
