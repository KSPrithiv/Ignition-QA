package steps.validations.inbound.loads;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.inbound.loads.InboundLoadOrderLineItemsPage;

public class InboundLoadOrderLineItemsPageValidations {
    InboundLoadOrderLineItemsPage inboundLoadOrderLineItemsPage = new InboundLoadOrderLineItemsPage();

    @And("Validates Inbound Load Order Line Items page contains all web elements")
    public void validateInboundLoadOrderDetailsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isToolBarContainerPresent(), "Tool Bar Container is not present");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isOrderLabelPresent(), "Order Label is not present");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isOrderLoadNumberPresent(), "Order Load Number is not present");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isDoorFieldDisplayed(), "Door Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isQaFieldDisplayed(), "Qa Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isCustomerFieldDisplayed(), "Customer Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isCarrierFieldDisplayed(), "Carrier Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isLoadFieldDisplayed(), "Load Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isSourceFieldDisplayed(), "Source Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isQtyFieldDisplayed(), "Qty Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isCubeFieldDisplayed(), "Cube Field is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isWeightFieldDisplayed(), "Weight Field is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Product details and UPC on Inbound Load Order Line Items page")
    public void verifyProductDetailsAndUPC() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isProductLabelDisplayed(),"Product Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isLocationColumnDisplayed(),"Location Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isLocationTypeColumnDisplayed(),"Location Type Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isQtyColumnDisplayed(),"Qty Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isUomColumnDisplayed(),"Uom Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isLotColumnDisplayed(),"Lot Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isExpDateColumnDisplayed(),"Exp Date Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isStatusColumnDisplayed(),"Status Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isWeightColumnDisplayed(),"Weight Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isStagedColumnDisplayed(),"Staged Column is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.areOrderLinesTableColumnsDisplayed(),"Order Lines Table Columns are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Product UPC is displayed on Inbound Load Order Line Items page")
    public void verifyProductUPCdisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!inboundLoadOrderLineItemsPage.getUPCNumber().equals(""),"Product UPC is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Load Order data screen on Inbound Load Order Line Items page")
    public void verifyLoadOrderDataScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isOrderLabelOnDataDisplayed(),"Order Label On Data page is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isTemperatureLabelDisplayed(),"Temperature Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isTemperatureInputDisplayed(),"Temperature Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isSealNumberLabelDisplayed(),"Seal Number Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isSealNumberInputDisplayed(),"Seal Number Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.areCommentsLabelsDisplayed() > 0,"Comments Labels are not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.areCommentsInputsDisplayed() > 0,"Comments Inputs are not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.areYesRadioButtonsDisplayed() > 0,"Yes Radio Buttons are not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.areNoRadioButtonsDisplayed() > 0,"No Radio Buttons is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isBtnAddProductCancelDisplayed(),"Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit order line popup on Inbound Load Order Line Items page")
    public void verifyEditOrderLineScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isOrderedQuantityLabelDisplayed(),"Ordered Quantity Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isOrderedQuantityInputDisplayed(),"Ordered Quantity is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isLotCodeDisplayed(),"Lot Code is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isLotCodeDropDownDisplayed(),"Lot Code DropDown is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isExpirationDateDisplayed(),"Expiration Date is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isExpirationDateInputDisplayed(),"Expiration Date Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isRequiredStatusDisplayed(),"Required Status is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isRefusedQtyLabelDisplayed(),"Refused Qty Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isRefusedQtyInputDisplayed(),"Refused Qty Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isCommentLabelDisplayed(),"Comment Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isCommentTextAreaDisplayed(),"Comment Text Area is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isReceivedWeightLabelDisplayed(),"Received Weight Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isReceivedWeightInputDisplayed(),"Received Weight Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isGtinLabelDisplayed(),"Gtin Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isGtinInputDisplayed(),"Gtin Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isDateCodeLabelDisplayed(),"Date Code Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isDateCodeInputDisplayed(),"Date Code Input is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isRejectedStatusLabelDisplayed(),"Rejected Status Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isRejectedStatusesDisplayed(),"Rejected Statuses not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isRefusalReasonLabelDisplayed(),"Refusal Reason Label is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isRefusalReasonInputDisplayed(),"Refusal Reason Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Save and Cancel buttons for Load image on Inbound Load Order Line Items page")
    public void verifySaveCancelBtns() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isSaveButtonDisplayed(),"Save Button is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Images Button is displayed on Inbound Load Order Line Items page")
    public void verifyImagesButtonDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isImagesButtonDisplayed(),"Images Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Comments Button is displayed on Inbound Load Order Line Items page")
    public void verifyCommentsButtonDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isCommentsButtonDisplayed(),"Comments Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Load Images on Inbound Load Order Line Items page")
    public void validateLoadImagesForOrder() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isSaveEditButtonDisplayed(), "Save Edit Button is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isInboundImageCaptureButtonDisplayed(), "Inbound Image Capture Button is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isSelectFilesBtnDisplayed(), "Select Files Button is not displayed");
        softAssert.assertTrue(inboundLoadOrderLineItemsPage.isLoadImageLabelDisplayed(), "Load Image Label is not displayed");
        softAssert.assertAll();
    }

}
