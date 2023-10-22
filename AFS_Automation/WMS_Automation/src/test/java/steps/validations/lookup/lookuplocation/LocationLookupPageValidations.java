package steps.validations.lookup.lookuplocation;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import objects.lookupproductslocationsdata.LookupProductLocationsDTO;
import org.testng.asserts.SoftAssert;
import ui.pages.lookup.lookuplocation.LocationLookupPage;

import java.util.List;

public class LocationLookupPageValidations {
    LocationLookupPage locationLookupPage = new LocationLookupPage();
    LookupProductLocationsDTO lookupDataDTO = new ObjectMapperWrapper().getObject(FilePaths.LOOKUP_DATA, LookupProductLocationsDTO.class);

    @And("Validates Location Lookup Page base elements are loaded")
    public void validateGridItemsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isLocationSearchLabelDisplayed(),"Location Search Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isLocationSearchInputDisplayed(),"Location Search Input is not displayed");
        softAssert.assertTrue(locationLookupPage.isLocationSearchButtonDisplayed(),"Location Search Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Inventory details of location on Location Lookup page are loaded")
    public void validateInventoryDetailsOfLocationPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isEditButtonDisplayed(),"Edit Button is not displayed");
        softAssert.assertTrue(locationLookupPage.isDeleteButtonDisplayed(),"Delete Button is not displayed");
        softAssert.assertTrue(locationLookupPage.isTransferButtonDisplayed(),"Transfer Button is not displayed");
        softAssert.assertTrue(locationLookupPage.isStatusButtonDisplayed(),"Status Button is not displayed");
        softAssert.assertTrue(locationLookupPage.isProductColumnHeaderDisplayed(),"Product Column Header is not displayed");
        softAssert.assertTrue(locationLookupPage.isDescriptionColumnHeaderDisplayed(),"Description Column Header is not displayed");
        softAssert.assertTrue(locationLookupPage.isQtyColumnHeaderDisplayed(),"Qty Column Header is not displayed");
        softAssert.assertTrue(locationLookupPage.isUomColumnHeaderDisplayed(),"Uom Column Header is not displayed");
        softAssert.assertTrue(locationLookupPage.isExpDateColumnHeaderDisplayed(),"ExpDate Column Header is not displayed");
        softAssert.assertTrue(locationLookupPage.isWeightColumnHeaderDisplayed(),"Weight Column Header is not displayed");
        softAssert.assertTrue(locationLookupPage.isOwnerColumnHeaderDisplayed(),"Owner Column Header is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Print Label on Location Lookup page is displayed")
    public void validatePrintLocDisplayed() {
        SoftAssert softAssert = new SoftAssert();
      //  softAssert.assertTrue(locationLookupPage.isBtnPrintLocDisplayed(), "Btn Print Loc is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Notification Warning {string} on Location Lookup page is displayed")
    public void validateNotificationWarningText(String warning) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getNotificationWarningText().contains(warning), "Notification Warning is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Inventory details of location on Location Lookup page are not displayed")
    public void validateInventoryDetailsOfLocationNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(locationLookupPage.isEditButtonDisplayed(),"Edit Button is displayed");
        softAssert.assertFalse(locationLookupPage.isDeleteButtonDisplayed(),"Delete Button is displayed");
        softAssert.assertFalse(locationLookupPage.isTransferButtonDisplayed(),"Transfer Button is displayed");
        softAssert.assertFalse(locationLookupPage.isStatusButtonDisplayed(),"Status Button is displayed");
        softAssert.assertAll();
    }

    @And("Validates popup text {string} on Location Lookup page")
    public void validateInvalidPopupSelectionMessage(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locationLookupPage.getDialogContentText(), text,
                "Invalid popup selection message is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Transfer window title {string} on Location Lookup page")
    public void validateTransferWindowTitle(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locationLookupPage.getWindowTitleText(), text,
                "Transfer Window Title is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Labels window title {string} on Location Lookup page")
    public void validateLabelsWindowTitle(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locationLookupPage.getWindowTitleText(), text,
                "Labels Window Title is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Transfer window details are displayed on Location Lookup page")
    public void validateTransferWindowDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isDdlProductTransferredLabelDisplayed(),"Product Transferred Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlProductTransferredDisplayed(),"Product Transferred is not displayed");
        softAssert.assertTrue(locationLookupPage.isTxtQtyLabelDisplayed(),"Txt Qty Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isTxtQtyDisplayed(),"Txt Qty is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlReasonLabelDisplayed(),"Reason Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlReasonDisplayed(),"Reason is not displayed");
        softAssert.assertTrue(locationLookupPage.isChkUndoTransferDisplayed(),"Chk Undo Transfer is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Delete window title {string} on Location Lookup page")
    public void validateDeleteWindowTitle(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locationLookupPage.getWindowTitleText(), text,
                "Delete Window Title is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Yes and No buttons are displayed on Delete assignment popup on Location Lookup page")
    public void validateYesAndNoButtonsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isYesButtonDisplayed(),"Yes Button is not displayed");
        softAssert.assertTrue(locationLookupPage.isNoButtonDisplayed(),"No Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Cancel and Ok buttons are displayed on Delete assignment popup on Location Lookup page")
    public void validateCancelAndOkButtonsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertTrue(locationLookupPage.isOkButtonDisplayed(),"Ok Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Label type {string} exists in dropdown on Location Lookup page")
    public void validateLabelTypeOption(String option) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isLabelTypeOptionExists(option),"Label Type " + option + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Delete Reason label and dropdown are displayed on Location Lookup page")
    public void validateDeleteReasonLabelAndDropdownPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isDeleteReasonLabelDisplayed(),"Delete Reason label is not displayed");
        softAssert.assertTrue(locationLookupPage.isDeleteReasonDisplayed(),"Delete Reason is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit inventory elements are displayed on Location Lookup page")
    public void validateEditInventoryElementsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isTxtEditProductLPNLabelDisplayed(),"Product LPN Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isTxtEditProductLPNDisplayed(),"Product LPN is not displayed");
        softAssert.assertTrue(locationLookupPage.isTxtEditProductCodeLabelDisplayed(),"Product Code Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isTxtEditProductCodeDisplayed(),"Product Code is not displayed");
        softAssert.assertTrue(locationLookupPage.isTxtEditSupplierLabelDisplayed(),"Supplier Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isTxtEditSupplierDisplayed(),"Supplier is not displayed");
        softAssert.assertTrue(locationLookupPage.isBoxAddProductQtyLabelDisplayed(),"Product Qty Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isBoxAddProductQtyDisplayed(),"Product Qty is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlEditProductUOMLabelDisplayed(),"Product UOM Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlEditProductUOMDisplayed(),"Product UOM is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlEditProductStatusLabelDisplayed(),"Product Status Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlEditProductStatusDisplayed(),"Product Status is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Product index field is greyed-out on Location Lookup page")
    public void validateProductIndexFieldDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isProductCodeDisabled().equals("true"),"Product Code is enabled");
        softAssert.assertAll();
    }

    @And("Validates Inventory Reason Label and Inventory Reason are displayed on Location Lookup page")
    public void validateInventoryReasonLabelAndInventoryReasonDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isInventoryReasonLabelDisplayed(),"Inventory Reason Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isInventoryReasonDisplayed(),"Inventory Reason is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Delete Reason Label and Delete Reason are displayed on Location Lookup page")
    public void validateDeleteReasonLabelAndDeleteReasonDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isDeleteInventoryReasonLabelDisplayed(),"Delete Reason Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isDeleteInventoryReasonDisplayed(),"Delete Reason is not displayed");
        softAssert.assertAll();
    }

    @And("Validates LPN, Product and Type are displayed on Location Lookup page")
    public void validateLpnProductTypeAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isAddProductLPNLabelDisplayed(),"LPN Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isAddProductLPNDisplayed(),"LPN input is not displayed");
        softAssert.assertTrue(locationLookupPage.isPalletTypeLabelDisplayed(),"Type Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isPalletTypeDisplayed(),"Type is not displayed");
        softAssert.assertTrue(locationLookupPage.isProductLabelDisplayed(),"Product Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isEnterProductInputDisplayed(),"Product Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Cancel and Save buttons are displayed on Add inventory on Location Lookup page")
    public void validateCancelAndSaveButtonsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isCancelButtonDisplayed(),"Cancel Button is not displayed");
        softAssert.assertTrue(locationLookupPage.isSaveButtonDisplayed(),"Save Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates LPN field should be empty on Location Lookup page")
    public void validateLPN_FieldIsEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getValueAddProductLPN().equals(""),"LPN is not empty");
        softAssert.assertAll();
    }

    @And("Validates Weight Serial is displayed on Location Lookup page")
    public void validateWeightSerialLabel() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isWeightSerialLabelDisplayed(),"Weight Serial is not displayed");
        softAssert.assertAll();
    }


    @And("Validates LPN field should be not empty on Location Lookup page")
    public void validateLPN_FieldIsNotEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(locationLookupPage.getValueAddProductLPN().equals(""),"LPN is empty");
        softAssert.assertAll();
    }

    @And("Validates options from dropdown are present on Location Lookup page")
    public void validateOptionsArePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getListOfOptions().size() > 0,"Options are not present");
        softAssert.assertAll();
    }

    @And("Validates dialog content text {string} on Location Lookup page")
    public void validateLPNWindowTitle(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getDialogContentText().contains(text),"LPN Window Title is not correct");
        softAssert.assertAll();
    }

    @And("Validates product details for location on Location Lookup page")
    public void validateProductDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isProductOwnerLabelDisplayed(),"Owner Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isProductOwnerDisplayed(),"Owner Input is not displayed");
        softAssert.assertTrue(locationLookupPage.isProductSupplierLabelDisplayed(),"Supplier Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isProductSupplierDisplayed(),"Supplier Input is not displayed");
        softAssert.assertTrue(locationLookupPage.isBoxAddProductQtyLabelDisplayed(),"Product Qty Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isBoxAddProductQtyDisplayed(),"Product Qty Input is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlEditProductUOMLabelDisplayed(),"Product UOM Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlEditProductUOMDisplayed(),"Product UOM Input is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlEditProductStatusLabelDisplayed(),"Product Status Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isDdlEditProductStatusDisplayed(),"Product Status Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Production Reason on Location Lookup page")
    public void validateProductionReasonDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isProductionReasonLabelDisplayed(),"Production Reason label is not displayed");
        softAssert.assertTrue(locationLookupPage.isProductionReasonDisplayed(),"Production Reason is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Production Reasons exist on Location Lookup page")
    public void validateProductionReasonOptions() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getOptionsNumber() > 0,"Production Reasons exist");
        softAssert.assertAll();
    }

    @And("Validates Suppliers number is less than {int} on Location Lookup page")
    public void validateSuppliersNumberLessThan(int number) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getOptionsNumber() < number,"Suppliers number is not correct");
        softAssert.assertAll();
    }

    @And("Validates Suppliers number is more than {int} on Location Lookup page")
    public void validateSuppliersNumberMoreThan(int number) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getOptionsNumber() > number,"Suppliers number is not correct");
        softAssert.assertAll();
    }

    @And("Validates Types number is more than {int} on Location Lookup page")
    public void validateTypeNumberMoreThan(int number) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getOptionsNumber() > number,"Type number is not correct");
        softAssert.assertAll();
    }

    @And("Validates 'Unit status' and 'Unit status Reason' on Location Lookup page")
    public void validateUnitStatusAndUnitStatusReasonDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isStatusLabelDisplayed(), "Status Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isStatusDisplayed(), "Status is not displayed");
        softAssert.assertTrue(locationLookupPage.isStatusReasonLabelDisplayed(), "Status Reason Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isStatusReasonDisplayed(), "Status Reason is not displayed");
    }

    @And("Validates Notification Message text {string} on Lookup Location page")
    public void validateNotificationMessageText(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getNotificationMessageText().contains(text),"LPN Window Title is not correct");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Lookup Location page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locationLookupPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Grid items are not present on Lookup Location page")
    public void validateGridItemsNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.getPalletsIndicatorValueText().equals("0"),"Pallets is not 0");
        softAssert.assertTrue(locationLookupPage.getQuantityIndicatorValueText().equals("0"),"Quantity is not 0");
        softAssert.assertTrue(locationLookupPage.getItemsFoundIndicatorValueText().equals("0"),"Items Found is not 0");
        softAssert.assertAll();
    }

    @And("Validates Location Search Field is present on Lookup Location page")
    public void validateOnlyLocationIndexSearchFieldPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isLocationSearchLabelDisplayed(),"Location Search Label is not displayed");
        softAssert.assertTrue(locationLookupPage.isLocationSearchInputDisplayed(),"Location Search Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Add location button is disabled on Lookup Location page")
    public void validateAddLocButtonDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locationLookupPage.isAddLocButtonDisabled(),"Add location button is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Production label {string} on Lookup Location page")
    public void validateProductionLabelText(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locationLookupPage.getProductionLabelText(), text, "Production label is not correct");
        softAssert.assertAll();
    }

    @And("Validates Production label by index {int} on Lookup Location page")
    public void validateProductionLabelText(int index) {
        SoftAssert softAssert = new SoftAssert();
        List<String> locations = List.of(lookupDataDTO.getLookupLocations().getLookupLocation1(), lookupDataDTO
                .getLookupLocations().getLookupLocation2(), lookupDataDTO.getLookupLocations().getLookupLocation3(),
                lookupDataDTO.getLookupLocations().getLookupLocation4(), lookupDataDTO.getLookupLocations()
                .getLookupLocation5());
        softAssert.assertEquals(locationLookupPage.getProductionLabelText(), "*Production* " + locations.get(index),
                "Production label is not correct");
        softAssert.assertAll();
    }

}
