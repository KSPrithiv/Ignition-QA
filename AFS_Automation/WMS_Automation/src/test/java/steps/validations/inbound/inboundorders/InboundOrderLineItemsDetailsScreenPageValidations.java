package steps.validations.inbound.inboundorders;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.inbound.inboundorders.InboundOrderLineItemsDetailsScreenPage;

public class InboundOrderLineItemsDetailsScreenPageValidations {
    InboundOrderLineItemsDetailsScreenPage inboundOrderLineItemsDetailsScreenPage = new InboundOrderLineItemsDetailsScreenPage();

    @And("Validates Product details and UPC on Inbound Order Line Items Details page")
    public void verifyProductDetailsAndUPC() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isProductLabelDisplayed(),"Product Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isLocationColumnDisplayed(),"Location Column is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isLocationTypeColumnDisplayed(),"Location Type Column is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isQtyColumnDisplayed(),"Qty Column is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isUomColumnDisplayed(),"Uom Column is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isLotColumnDisplayed(),"Lot Column is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isExpDateColumnDisplayed(),"Exp Date Column is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isStatusColumnDisplayed(),"Status Column is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isWeightColumnDisplayed(),"Weight Column is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isStagedColumnDisplayed(),"Staged Column is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.areOrderLinesTableColumnsDisplayed(),"Order Lines Table Columns are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Inbound Order Line Item Details page contains all web elements")
    public void validateInboundOrderLineItemDetailsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isOrderLabelPresent(), "Order Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isOrderDetailsPresent(), "Order Details is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isDoorFieldDisplayed(), "Door Field is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isQaFieldDisplayed(), "Qa Field is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isOwnerFieldDisplayed(), "Owner Field is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isCarrierFieldDisplayed(), "Carrier Field is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isLoadFieldDisplayed(), "Load Field is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isSourceFieldDisplayed(), "Source Field is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isQtyFieldDisplayed(), "Qty Field is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isCubeFieldDisplayed(), "Cube Field is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isWeightFieldDisplayed(), "Weight Field is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Inbound Order data screen on Inbound Order Line Items Details page")
    public void verifyLoadOrderDataScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isOrderLabelOnDataDisplayed(),"Order Label On Data page is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isTemperatureLabelDisplayed(),"Temperature Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isTemperatureInputDisplayed(),"Temperature Input is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isSealNumberLabelDisplayed(),"Seal Number Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isSealNumberInputDisplayed(),"Seal Number Input is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.areCommentsLabelsDisplayed() > 0,"Comments Labels are not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.areCommentsInputsDisplayed() > 0,"Comments Inputs are not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.areYesRadioButtonsDisplayed() > 0,"Yes Radio Buttons are not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.areNoRadioButtonsDisplayed() > 0,"No Radio Buttons is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isBtnAddProductCancelDisplayed(),"Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit order line popup on Inbound Order Line Items Details page")
    public void verifyEditOrderLineScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isOrderedQuantityLabelDisplayed(),"Ordered Quantity Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isOrderedQuantityInputDisplayed(),"Ordered Quantity is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isLotCodeDisplayed(),"Lot Code is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isLotCodeDropDownDisplayed(),"Lot Code DropDown is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isExpirationDateDisplayed(),"Expiration Date is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isExpirationDateInputDisplayed(),"Expiration Date Input is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isRequiredStatusDisplayed(),"Required Status is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isRefusedQtyLabelDisplayed(),"Refused Qty Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isRefusedQtyInputDisplayed(),"Refused Qty Input is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isCommentLabelDisplayed(),"Comment Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isReceivedWeightLabelDisplayed(),"Received Weight Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isReceivedWeightInputDisplayed(),"Received Weight Input is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isGtinLabelDisplayed(),"Gtin Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isGtinInputDisplayed(),"Gtin Input is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isDateCodeLabelDisplayed(),"Date Code Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isDateCodeInputDisplayed(),"Date Code Input is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isRejectedStatusLabelDisplayed(),"Rejected Status Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isRejectedStatusesDisplayed(),"Rejected Statuses not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isRefusalReasonLabelDisplayed(),"Refusal Reason Label is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isRefusalReasonInputDisplayed(),"Refusal Reason Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Order Images on Inbound Order Line Items Details page")
    public void validateLoadImagesForOrder() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isSaveEditButtonDisplayed(), "Save Edit Button is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isInboundImageCaptureButtonDisplayed(), "Inbound Image Capture Button is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isSelectFilesBtnDisplayed(), "Select Files Button is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isLoadImageLabelDisplayed(), "Load Image Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Save and Cancel buttons for Load image on Inbound Order Line Items Details page")
    public void verifySaveCancelBtns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isSaveButtonDisplayed(),"Save Button is not displayed");
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Images Button is displayed on Inbound Order Line Items Details page")
    public void verifyImagesButtonDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isImagesButtonDisplayed(),"Images Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Comments Button is displayed on Inbound Order Line Items Details page")
    public void verifyCommentsButtonDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderLineItemsDetailsScreenPage.isCommentsButtonDisplayed(),"Comments Button is not displayed");
        softAssert.assertAll();
    }

}
