package steps.validations.inbound.inboundorders;

import common.constants.Notifications;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.inbound.inboundorders.InboundOrderDetailsPage;

public class InboundOrderDetailsPageValidations {
    InboundOrderDetailsPage inboundOrderDetailsPage = new InboundOrderDetailsPage();

    @And("Validates Inbound Order Details Page contains all web elements")
    public void validateInboundOrderSummaryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isTopIconDisplayed(), "Top Icon is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isOrderOptionsButtonDisplayed(), "Order Options Button is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isOrderStatusDisplayed(), "Order Status is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isSourceLabelDisplayed(), "Source Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isImagesButtonDisplayed(), "Images Button is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCommentsButtonDisplayed(), "Comments Button is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isToolBarDisplayed(), "Tool Bar is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isToolBarContainerPresent(), "Tool Bar Container is not present");
        softAssert.assertTrue(inboundOrderDetailsPage.isOrderDetailsPresent(), "Order Details is not present");
        softAssert.assertTrue(inboundOrderDetailsPage.isDoorFieldDisplayed(), "Door Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isQaFieldDisplayed(), "Qa Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCustomerFieldDisplayed(), "Customer Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCarrierFieldDisplayed(), "Carrier Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isLoadFieldDisplayed(), "Load Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isSourceFieldDisplayed(), "Source Field is not visible");
        softAssert.assertTrue(inboundOrderDetailsPage.isQtyFieldDisplayed(), "Qty Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCubeFieldDisplayed(), "Cube Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isWeightFieldDisplayed(), "Weight Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isChangeStatusOptionDisplayed(), "Change Status is not visible");
        softAssert.assertTrue(inboundOrderDetailsPage.isDoorOptionDisplayed(), "Door Option is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isDataOptionDisplayed(), "Data Option is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isStatusInputDisplayed(), "Status Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates orders are present on Inbound Order Details page")
    public void validateOrdersPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!inboundOrderDetailsPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates items are present on Inbound Order Details page")
    public void validateItemsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Change status title for Inbound Order Details page")
    public void validatePopupChangeStatusTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundOrderDetailsPage.getDialogPopUpText(), Notifications.CHANGE_STATUS,
                "Popup Title " + Notifications.CHANGE_STATUS + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Reopen Order status on Inbound Order Details page")
    public void verifyChangeStatusReOpenPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isReopenOrderStatusDisplayed(),"Reopen Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Finish Receiving Order status on Inbound Order Details page")
    public void verifyChangeStatusFinishReceivingPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isFinishReceivingOrderDisplayed(),"Finish Receiving Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Ready To Receive Order status on Inbound Order Details page")
    public void verifyChangeStatusReadyToReceivePopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isReadyToReceiveStatusDisplayed(),"Ready To Receive Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Received, Staged, Over and Remainder are present on Inbound Order Details page with correct color")
    public void validateProgressBarColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isReceivedQtyDisplayed(),"Received Qty is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isStagedQtyDisplayed(),"Staged Qty is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isRedQtyDisplayed(),"Red Qty is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isGrayQtyDisplayed(),"Gray Qty is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Source order screen on Inbound Order Details page")
    public void verifySourceLoadScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isSourceOrderTypeDisplayed(),"Source Order Type is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isSourceOrderDisplayed(),"Source Order is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isSourceStatusDisplayed(),"Source Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Received, Staged and Remainder are present on Inbound Order Details Source page with correct color")
    public void validateSourceProgressBarColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isReceivedQtyDisplayed(),"Received Qty is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isStagedQtyDisplayed(),"Staged Qty is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isGrayQtyDisplayed(),"Gray Qty is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit load popup on Inbound Order Details page")
    public void verifyEditLoadPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isScheduledDateLabelDisplayed(),"Scheduled Date Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isScheduledDateDisplayed(),"Scheduled Date is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isScheduledTimeLabelDisplayed(),"Scheduled Time Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isScheduledTimeInputDisplayed(),"Scheduled Time Input is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCarrierLabelDisplayed(),"Carrier Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCarrierInputDisplayed(),"Carrier Input is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isTrailerLabelDisplayed(),"Trailer Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isTrailerInputDisplayed(),"Trailer Input is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isPaymentTypeLabelDisplayed(),"Payment Type Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isPaymentTypeInputDisplayed(),"Payment Type Input is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCommentsLabelDisplayed(),"Comments Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCommentsInputDisplayed(),"Comments Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Enter data screen on Inbound Order Details page")
    public void verifyEnterDataScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isTemperatureLabelDisplayed(),"Temperature Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isTemperatureInputDisplayed(),"Temperature Input is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isSealNumberLabelDisplayed(),"Seal Number Label is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isSealNumberInputDisplayed(),"Seal Number Input is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.areCommentsLabelsDisplayed() > 0,"Comments Labels are not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.areCommentsInputsDisplayed() > 0,"Comments Inputs are not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.areYesRadioButtonsDisplayed() > 0,"Yes Radio Buttons are not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.areNoRadioButtonsDisplayed() > 0,"No Radio Buttons is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isBtnAddProductCancelDisplayed(),"Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Comments Button is present on Inbound Order Details page")
    public void validateCommentsButtonPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isCommentsButtonDisplayed(),"Comments Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Images Button is present on Inbound Order Details page")
    public void validateImagesButtonPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isImagesButtonDisplayed(),"Images Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Inbound Order Details page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundOrderDetailsPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Status, Door and Data on Inbound Order Details page")
    public void verifyStatusDoorData() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isChangeStatusOptionDisplayed(), "Change Status is not visible");
        softAssert.assertTrue(inboundOrderDetailsPage.isDoorOptionDisplayed(), "Door Option is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isDataOptionDisplayed(), "Data Option is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Inbound Order Details page contains all web elements")
    public void validateInboundOrderDetailsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isToolBarContainerPresent(), "Tool Bar Container is not Present");
        softAssert.assertTrue(inboundOrderDetailsPage.isBarContainerPresent(), "Bar Container are not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isOrderDetailsPresent(), "OrderDetails is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isDoorFieldDisplayed(), "Door Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isQaFieldDisplayed(), "Qa Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCustomerFieldDisplayed(), "Customer Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCarrierFieldDisplayed(), "Carrier Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isLoadFieldDisplayed(), "Load Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isSourceFieldDisplayed(), "Source Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isQtyFieldDisplayed(), "Qty Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isCubeFieldDisplayed(), "Cube Field is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isWeightFieldDisplayed(), "Weight Field is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Receiver details on Inbound Order Details page")
    public void validatePopupReceiverDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isReceiverDateColumnDisplayed(),"Receiver Date Column is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isReceiverFromStatusColumnDisplayed(),"Receiver From Status Column is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isReceiverToStatusColumnDisplayed(),"Receiver To Status Column is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isReceiverUserColumnDisplayed(),"Receiver User Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Add Filter on Inbound Order Details page")
    public void validatePopupAddFilterDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isDateTimeCheckBoxDisplayed(),"Date Time CheckBox is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isFromStatusCheckBoxDisplayed(),"From Status CheckBox is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isToStatusCheckBoxDisplayed(),"To Status CheckBox is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isUserCheckBoxDisplayed(),"User CheckBox is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Save button is disabled on Inbound Order Details page")
    public void validateSaveButtonIsDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isSaveButtonDisabled(), "Save button is active");
        softAssert.assertAll();
    }

    @And("Validates Save button is enabled on Inbound Order Details page")
    public void validateSaveButtonIsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(inboundOrderDetailsPage.isSaveButtonDisabled(), "Save button is active");
        softAssert.assertAll();
    }

    @And("Validates Load Images on Inbound Order Details page")
    public void validateLoadImagesForOrder() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderDetailsPage.isSaveEditButtonDisplayed(), "Save Edit Button is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isInboundImageCaptureButtonDisplayed(), "Inbound Image Capture Button is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isSelectFilesBtnDisplayed(), "Select Files Button is not displayed");
        softAssert.assertTrue(inboundOrderDetailsPage.isLoadImageLabelDisplayed(), "Load Image Label is not displayed");
        softAssert.assertAll();
    }
}
