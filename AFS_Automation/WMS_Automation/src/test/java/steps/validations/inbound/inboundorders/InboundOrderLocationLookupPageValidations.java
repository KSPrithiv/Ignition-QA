package steps.validations.inbound.inboundorders;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.inbound.inboundorders.InboundOrderLocationLookupPage;

public class InboundOrderLocationLookupPageValidations {
    InboundOrderLocationLookupPage inboundOrderLocationLookupPage = new InboundOrderLocationLookupPage();

    @And("Validates Inbound Order Location Lookup page contains all web elements")
    public void validateInboundLoadOrderDetailsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundOrderLocationLookupPage.isTopIconPresent(), "Top Icon is not present");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isLocationSearchACFieldPresent(), "Location Search Field is not present");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isLocationInputDisplayed(), "Location Input is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isLocationButtonDisplayed(), "Location Button is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isAddLocProdButtonDisplayed(), "Add Loc Prod Button is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isEditButtonDisplayed(), "Edit Button is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isDeleteButtonDisplayed(), "Delete Button is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isTransferButtonDisplayed(), "Transfer Button is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isStatusButtonDisplayed(), "Status Button is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isPalletColumnDisplayed(), "Pallet Column is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isProductColumnDisplayed(), "Product Column is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isDescriptionColumnDisplayed(), "Description Column is not displayed");
      /*  softAssert.assertTrue(inboundOrderLocationLookupPage.isQtyColumnDisplayed(), "Qty Column is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isUomColumnDisplayed(), "Uom Column is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isLotColumnDisplayed(), "Lot Column is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isExpDateColumnDisplayed(), "Exp Date Column is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isWeightColumnDisplayed(), "Weight Column is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isOwnerColumnDisplayed(), "Owner Column is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isPalletsLabelDisplayed(), "Pallets Label is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isQuantityLabelDisplayed(), "Quantity Label is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isItemsFoundLabelDisplayed(), "Items Found Label is not displayed");
        softAssert.assertTrue(inboundOrderLocationLookupPage.isLookupLocationSearchDisplayed(), "Lookup Location Search is not displayed");*/
        softAssert.assertTrue(inboundOrderLocationLookupPage.isLookupLocationGridTableDisplayed() > 0,
                "Lookup Location Grid Table is not displayed");
        softAssert.assertAll();
    }
}
