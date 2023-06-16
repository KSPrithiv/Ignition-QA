package steps.validations.inbound.loads;
import common.constants.Notifications;
import io.cucumber.java.en.And;
import objects.productdata.ProductData;
import org.testng.asserts.SoftAssert;
import steps.inbound.loads.InboundLoadOrderDetailsPageSteps;
import ui.pages.inbound.loads.InboundLoadOrderDetailsPage;

import java.util.List;

public class InboundLoadOrderDetailsPageValidations {
    InboundLoadOrderDetailsPageSteps inboundLoadOrderDetailsPageSteps = new InboundLoadOrderDetailsPageSteps();
    InboundLoadOrderDetailsPage inboundLoadOrderDetailsPage = new InboundLoadOrderDetailsPage();
    SoftAssert softAssert = new SoftAssert();

    @And("Validates Inbound Load Order details page contains all web elements")
    public void validateInboundLoadOrderDetailsPage() {
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isToolBarContainerPresent(), "Tool Bar Container is not Present");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isBarContainerPresent(), "Bar Container are not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isOrderDetailsPresent(), "OrderDetails is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isDoorFieldDisplayed(), "Door Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isQaFieldDisplayed(), "Qa Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isOwnerFieldDisplayed(), "Owner Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isCarrierFieldDisplayed(), "Carrier Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isLoadFieldDisplayed(), "Load Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isSourceFieldDisplayed(), "Source Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isQtyFieldDisplayed(), "Qty Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isCubeFieldDisplayed(), "Cube Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isWeightFieldDisplayed(), "Weight Field is not displayed");
        softAssert.assertAll();
    }

    @And("Validates product list details is not empty")
    public void validateProductListDetails() {
        List<ProductData> productDataDetails = inboundLoadOrderDetailsPageSteps.getProductDetails();
        productDataDetails.stream()
         .forEach(detail -> {
            softAssert.assertTrue(!detail.getProductCode().isEmpty(), "Product Code is Empty");
            softAssert.assertTrue(!detail.getProductDescription().isEmpty(), "Product Description is Empty");
            softAssert.assertTrue(!detail.getProductAmount().isEmpty(), "Product Amount is Empty");
        });
        softAssert.assertAll();
    }

    @And("Validates load orders Summary totals is present on Inbound Load Order Summary page")
    public void validateLoadsPresent() {
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isItemsFoundLabelDisplayed(),"Items Found Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isItemsFoundValueDisplayed(),"Items Found Value is not displayed");
        softAssert.assertTrue(!inboundLoadOrderDetailsPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates Comments Button is present on Inbound Load Order Summary page")
    public void validateCommentsButtonPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isCommentsButtonDisplayed(),"Comments Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Images Button is present on Inbound Load Order Summary page")
    public void validateImagesButtonPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isImagesButtonDisplayed(),"Images Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Change status title for Inbound Load Order Summary page")
    public void validatePopupChangeStatusTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadOrderDetailsPage.getDialogPopUpText(), Notifications.CHANGE_STATUS,
                "Popup Title " + Notifications.CHANGE_STATUS + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Reopen Order status on Inbound Load Order Summary page")
    public void verifyChangeStatusReOpenPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isReopenOrderStatusDisplayed(),"Reopen Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Finish Receiving Order status on Inbound Load Order Summary page")
    public void verifyChangeStatusFinishReceivingPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isFinishReceivingOrderDisplayed(),"Finish Receiving Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Change status popup with Ready To Receive Order status on Inbound Load Order Summary page")
    public void verifyChangeStatusReadyToReceivePopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isReadyToReceiveStatusDisplayed(),"Ready To Receive Order Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Quantity received is less than Order quantity inventory content on Inbound Load Order Summary page")
    public void validateQuantityReceivedLessOrderQuantityContent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadOrderDetailsPage.getDialogPopUpContentText(), Notifications.QUANTITY_RECEIVED_LESS_ORDER_QUANTITY,
                "Popup content " + Notifications.QUANTITY_RECEIVED_LESS_ORDER_QUANTITY + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Change staged inventory content on Inbound Load Order Summary page")
    public void validateChangeStagedInventoryContent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadOrderDetailsPage.getDialogPopUpContentText(), Notifications.STAGED_INVENTORY,
                "Popup content " + Notifications.STAGED_INVENTORY + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Order status {string} is correct on Inbound Load Order Summary page")
    public void validateOrderStatus(String status) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadOrderDetailsPage.getStatusCellContentText(), status,"Order status " +
                inboundLoadOrderDetailsPage.getStatusCellContentText() + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates Received, Staged, Over and Remainder are present on Inbound Load Order Summary page with correct color")
    public void validateProgressBarColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isReceivedQtyDisplayed(),"Received Qty is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isStagedQtyDisplayed(),"Staged Qty is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isRedQtyDisplayed(),"Red Qty is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isGrayQtyDisplayed(),"Gray Qty is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Received, Staged and Remainder are present on Inbound Load Order Summary page with correct color")
    public void validateSourcePageProgressBarColors() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isReceivedQtyDisplayed(),"Received Qty is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isStagedQtyDisplayed(),"Staged Qty is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isGrayQtyDisplayed(),"Gray Qty is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Source load screen on Inbound Load Order Summary page")
    public void verifySourceLoadScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isSourceOrderTypeDisplayed(),"Source Order Type is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isSourceOrderDisplayed(),"Source Order is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isSourceStatusDisplayed(),"Source Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit load popup on Inbound Load Order Summary page")
    public void verifyEditLoadPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isLoadCodeLabelDisplayed(),"Load Code Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isLoadCodeInputDisplayed(),"Load Code Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isScheduledDateLabelDisplayed(),"Scheduled Date Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isScheduledDateDisplayed(),"Scheduled Date is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isCarrierLabelDisplayed(),"Carrier Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isCarrierInputDisplayed(),"Carrier Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isTrailerLabelDisplayed(),"Trailer Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isTrailerInputDisplayed(),"Trailer Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isDoorLabelDisplayed(),"Door Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isDoorInputDisplayed(),"Door Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isLoadTypeLabelDisplayed(),"Load Type Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isLoadTypeInputDisplayed(),"Load Type Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isScheduledTimeLabelDisplayed(),"Scheduled Time Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isScheduledTimeInputDisplayed(),"Scheduled Time Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isDriverLabelDisplayed(),"Driver Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isDriverInputDisplayed(),"Driver Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isTemperatureFieldDisplayed(),"Temperature Field is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Assign doors title for Inbound Load Order Summary page")
    public void validatePopupAssignDoorTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadOrderDetailsPage.getDialogPopUpText(), Notifications.ASSIGN_DOORS,
                "Popup Title " + Notifications.ASSIGN_DOORS + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Inbound Load Order Summary page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(inboundLoadOrderDetailsPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates popup Receiver title on Inbound Load Order Details page")
    public void validatePopupReceiverTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.getPopupTitleText().contains(Notifications.RECEIVER),
                "Popup Title " + Notifications.SHIPPER + " is not correct");
        softAssert.assertAll();
    }

    @And("Validates popup Receiver details on Inbound Load Order Details page")
    public void validatePopupReceiverDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isReceiverDateColumnDisplayed(),"Receiver Date Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isReceiverFromStatusColumnDisplayed(),"Receiver From Status Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isReceiverToStatusColumnDisplayed(),"Receiver To Status Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isReceiverUserColumnDisplayed(),"Receiver User Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Move popup on Inbound Load Order Details page")
    public void validatePopupMoveColumns() {

        softAssert.assertEquals(inboundLoadOrderDetailsPage.getWindowTitleText(), Notifications.MOVE,
                "Move popup page title is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isMoveShipDateDisplayed(),
                "Ship Date is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isMoveShipDateInputDisplayed(),
                "Ship Date input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isLoadInputDisplayed(),
                "Load input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Save button is disabled for Move order to Load")
    public void validateSaveButtonIsDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isSaveButtonDisabled(), "Save button is active");
        softAssert.assertAll();
    }

    @And("Validates Save button is enabled for Move order to Load")
    public void validateSaveButtonIsEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(inboundLoadOrderDetailsPage.isSaveButtonDisabled(), "Save button is active");
        softAssert.assertAll();
    }

    @And("Validates Load Images on Inbound Load Order Details page")
    public void validateLoadImagesForOrder() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isSaveEditButtonDisplayed(), "Save Edit Button is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isInboundImageCaptureButtonDisplayed(), "Inbound Image Capture Button is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isSelectFilesBtnDisplayed(), "Select Files Button is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isLoadImageLabelDisplayed(), "Load Image Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Enter data screen on Inbound Load Order Details page")
    public void verifyEnterDataScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isTemperatureLabelDisplayed(),"Temperature Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isTemperatureInputDisplayed(),"Temperature Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isSealNumberLabelDisplayed(),"Seal Number Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isSealNumberInputDisplayed(),"Seal Number Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.areCommentsLabelsDisplayed() > 0,"Comments Labels are not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.areCommentsInputsDisplayed() > 0,"Comments Inputs are not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.areYesRadioButtonsDisplayed() > 0,"Yes Radio Buttons are not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.areNoRadioButtonsDisplayed() > 0,"No Radio Buttons is not displayed");
        softAssert.assertTrue(inboundLoadOrderDetailsPage.isBtnAddProductCancelDisplayed(),"Notification is not displayed");
        softAssert.assertAll();
    }

}
