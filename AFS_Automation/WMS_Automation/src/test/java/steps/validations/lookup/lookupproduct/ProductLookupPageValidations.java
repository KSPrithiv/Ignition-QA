package steps.validations.lookup.lookupproduct;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.lookup.lookupproduct.ProductLookupPage;

public class ProductLookupPageValidations {
    ProductLookupPage productLookupPage = new ProductLookupPage();

    @And("Validates Product Lookup Page base elements are loaded")
    public void validateGridItemsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productLookupPage.isProductLookupTitleDisplayed(),"Product Lookup Title is not displayed");
        softAssert.assertTrue(productLookupPage.isProductLookupButtonDisplayed(),"Product Lookup Button is not displayed");
        softAssert.assertTrue(productLookupPage.isProductSearchLabelDisplayed(),"Product Search Label is not displayed");
        softAssert.assertTrue(productLookupPage.isProductSearchInputDisplayed(),"Product Search Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page")
    public void validateTabsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productLookupPage.isLookupTabDisplayed(), "Lookup Tab is not displayed");
        softAssert.assertTrue(productLookupPage.areAllocationTabsDisplayed(),"Allocation Tabs are not displayed");
        softAssert.assertTrue(productLookupPage.areSetupTabsDisplayed(),"Setup Tabs are not displayed");
        softAssert.assertTrue(productLookupPage.areHistoryTabsDisplayed(),"History Tabs are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Product details are loaded on Lookup Product page")
    public void validateProductDetailsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productLookupPage.isLocationColumnDisplayed(),"Location Column is not displayed");
        softAssert.assertTrue(productLookupPage.isLocationColumnHeaderDisplayed(),"Location Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isLocationTypeColumnDisplayed(),"Location Type Column is not displayed");
        softAssert.assertTrue(productLookupPage.isLocationTypeColumnHeaderDisplayed(),"Location Type Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isQtyColumnDisplayed(),"Qty Column is not displayed");
        softAssert.assertTrue(productLookupPage.isQtyColumnHeaderDisplayed(),"Qty Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isUomColumnDisplayed(),"Uom Column is not displayed");
        softAssert.assertTrue(productLookupPage.isUomColumnHeaderDisplayed(),"Uom Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isTaskTypeColumnDisplayed(),"Task Type Column is not displayed");
        softAssert.assertTrue(productLookupPage.isTaskTypeColumnHeaderDisplayed(),"Task Type Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isDestinationColumnDisplayed(),"Destination Column is not displayed");
        softAssert.assertTrue(productLookupPage.isDestinationColumnHeaderDisplayed(),"Destination Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isReceivedColumnDisplayed(),"Received Column is not displayed");
        softAssert.assertTrue(productLookupPage.isReceivedColumnHeaderDisplayed(),"Received Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isLotColumnDisplayed(),"Lot Column is not displayed");
        softAssert.assertTrue(productLookupPage.isLotColumnHeaderDisplayed(),"Lot Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isExpDateColumnDisplayed(),"Exp Date Column is not displayed");
        softAssert.assertTrue(productLookupPage.isExpDateColumnHeaderDisplayed(),"Exp Date Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isStatusColumnDisplayed(),"Status Column is not displayed");
        softAssert.assertTrue(productLookupPage.isStatusColumnHeaderDisplayed(),"Status Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isWeightColumnDisplayed(),"Weight Column is not displayed");
        softAssert.assertTrue(productLookupPage.isWeightColumnHeaderDisplayed(),"Weight Column Header is not displayed");
        softAssert.assertTrue(productLookupPage.isStaged_ColumnDisplayed(),"Staged Column is not displayed");
        softAssert.assertTrue(productLookupPage.isStaged_ColumnHeaderDisplayed(),"Staged Column Header is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Product details are not loaded on Lookup Product page")
    public void validateProductDetailsNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(productLookupPage.isLocationColumnDisplayed(),"Location Column is not displayed");
        softAssert.assertFalse(productLookupPage.isLocationColumnHeaderDisplayed(),"Location Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isLocationTypeColumnDisplayed(),"Location Type Column is not displayed");
        softAssert.assertFalse(productLookupPage.isLocationTypeColumnHeaderDisplayed(),"Location Type Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isQtyColumnDisplayed(),"Qty Column is not displayed");
        softAssert.assertFalse(productLookupPage.isQtyColumnHeaderDisplayed(),"Qty Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isUomColumnDisplayed(),"Uom Column is not displayed");
        softAssert.assertFalse(productLookupPage.isUomColumnHeaderDisplayed(),"Uom Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isTaskTypeColumnDisplayed(),"Task Type Column is not displayed");
        softAssert.assertFalse(productLookupPage.isTaskTypeColumnHeaderDisplayed(),"Task Type Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isDestinationColumnDisplayed(),"Destination Column is not displayed");
        softAssert.assertFalse(productLookupPage.isDestinationColumnHeaderDisplayed(),"Destination Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isReceivedColumnDisplayed(),"Received Column is not displayed");
        softAssert.assertFalse(productLookupPage.isReceivedColumnHeaderDisplayed(),"Received Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isLotColumnDisplayed(),"Lot Column is not displayed");
        softAssert.assertFalse(productLookupPage.isLotColumnHeaderDisplayed(),"Lot Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isExpDateColumnDisplayed(),"Exp Date Column is not displayed");
        softAssert.assertFalse(productLookupPage.isExpDateColumnHeaderDisplayed(),"Exp Date Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isStatusColumnDisplayed(),"Status Column is not displayed");
        softAssert.assertFalse(productLookupPage.isStatusColumnHeaderDisplayed(),"Status Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isWeightColumnDisplayed(),"Weight Column is not displayed");
        softAssert.assertFalse(productLookupPage.isWeightColumnHeaderDisplayed(),"Weight Column Header is not displayed");
        softAssert.assertFalse(productLookupPage.isStaged_ColumnDisplayed(),"Staged Column is not displayed");
        softAssert.assertFalse(productLookupPage.isStaged_ColumnHeaderDisplayed(),"Staged Column Header is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Setup Product details are loaded on Lookup Product page")
    public void validateSetupDetailsForProduct() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productLookupPage.isProductLabelDisplayed(),"Product Label is not displayed");
        softAssert.assertTrue(productLookupPage.isDescriptionLabelDisplayed(),"Description Label is not displayed");
        softAssert.assertTrue(productLookupPage.isProductTypeLabelDisplayed(),"Product Type Label is not displayed");
        softAssert.assertTrue(productLookupPage.isTieHighLabelDisplayed(),"Tie High Label is not displayed");
        softAssert.assertTrue(productLookupPage.isMovementClassLabelDisplayed(),"Movement Class Label is not displayed");
        softAssert.assertTrue(productLookupPage.isDedicatedPickLocationsLabelDisplayed(),"Dedicated Pick Locations Label is not displayed");
        softAssert.assertTrue(productLookupPage.isUnitsOfMeasureLabelDisplayed(),"Units Of Measure Label is not displayed");
        softAssert.assertTrue(productLookupPage.isAliasesLabelDisplayed(),"Aliases Label is not displayed");
        softAssert.assertTrue(productLookupPage.isVendorsLabelDisplayed(),"Vendors Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Allocation Product details are loaded on Lookup Product page")
    public void validateAllocationDetailsForProduct() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productLookupPage.isUomColumnDisplayed(),"Uom Column is not displayed");
        softAssert.assertTrue(productLookupPage.isConversionColumnDisplayed(),"Conversion Column is not displayed");
        softAssert.assertTrue(productLookupPage.isActualColumnDisplayed(),"Actual Column is not displayed");
        softAssert.assertTrue(productLookupPage.isBookColumnDisplayed(),"Book Column is not displayed");
        softAssert.assertTrue(productLookupPage.isInboundColumnDisplayed(),"Inbound Column is not displayed");
        softAssert.assertTrue(productLookupPage.isOutboundColumnDisplayed(),"Outbound Column is not displayed");
        softAssert.assertTrue(productLookupPage.isSoftAllocatedColumnDisplayed(),"Soft Allocated Column is not displayed");
        softAssert.assertTrue(productLookupPage.isHardAllocatedColumnDisplayed(),"Hard Allocated Column is not displayed");
        softAssert.assertTrue(productLookupPage.isStagedColumnDisplayed(),"Staged Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates 'Unit status' and 'Unit status Reason' on Lookup Product page")
    public void validateUnitStatusAndUnitStatusReasonDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productLookupPage.isStatusLabelDisplayed(), "Status Label is not displayed");
        softAssert.assertTrue(productLookupPage.isStatusDisplayed(), "Status is not displayed");
        softAssert.assertTrue(productLookupPage.isStatusReasonLabelDisplayed(), "Status Reason Label is not displayed");
        softAssert.assertTrue(productLookupPage.isStatusReasonDisplayed(), "Status Reason is not displayed");
    }

    @And("Validates Notification Message text {string} on Lookup Product page")
    public void validateNotificationMessageText(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productLookupPage.getNotificationMessageText().contains(text),"Product Window Title is not correct");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Lookup Product page")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productLookupPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Show Pallet CheckBox is displayed on Lookup Product page")
    public void validateShowPalletPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productLookupPage.isProductShowPalletCheckDisplayed(),"Show Pallet Check box is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Grid items are not present on Lookup Product page")
    public void validateGridItemsNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productLookupPage.getPalletsIndicatorValueText().equals("0"),"Pallets is not 0");
        softAssert.assertTrue(productLookupPage.getQuantityIndicatorValueText().equals("0"),"Quantity is not 0");
        softAssert.assertTrue(productLookupPage.getItemsFoundIndicatorValueText().equals("0"),"Items Found is not 0");
        softAssert.assertAll();
    }

    @And("Validates Grid items are present on Lookup Product page")
    public void validateGridItemsAreFound() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!productLookupPage.getPalletsIndicatorValueText().equals("0"),"Pallets is not 0");
        softAssert.assertTrue(!productLookupPage.getQuantityIndicatorValueText().equals("0"),"Quantity is not 0");
        softAssert.assertTrue(!productLookupPage.getItemsFoundIndicatorValueText().equals("0"),"Items Found is not 0");
        softAssert.assertAll();
    }
}
