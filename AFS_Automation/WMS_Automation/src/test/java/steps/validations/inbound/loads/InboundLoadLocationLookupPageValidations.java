package steps.validations.inbound.loads;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.inbound.loads.InboundLoadLocationLookupPage;

public class InboundLoadLocationLookupPageValidations {
    InboundLoadLocationLookupPage inboundLoadLocationLookupPage = new InboundLoadLocationLookupPage();

    @And("Validates Inbound Load Location Lookup page contains all web elements")
    public void validateInboundLoadOrderDetailsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadLocationLookupPage.isTopIconPresent(), "Top Icon is not present");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isLocationSearchACFieldPresent(), "Location Search Field is not present");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isLocationInputDisplayed(), "Location Input is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isLocationButtonDisplayed(), "Location Button is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isAddLocProdButtonDisplayed(), "Add Loc Prod Button is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isEditButtonDisplayed(), "Edit Button is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isDeleteButtonDisplayed(), "Delete Button is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isTransferButtonDisplayed(), "Transfer Button is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isStatusButtonDisplayed(), "Status Button is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isPalletColumnDisplayed(), "Pallet Column is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isProductColumnDisplayed(), "Product Column is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isDescriptionColumnDisplayed(), "Description Column is not displayed");
/*      softAssert.assertTrue(inboundLoadLocationLookupPage.isQtyColumnDisplayed(), "Qty Column is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isUomColumnDisplayed(), "Uom Column is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isLotColumnDisplayed(), "Lot Column is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isExpDateColumnDisplayed(), "Exp Date Column is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isWeightColumnDisplayed(), "Weight Column is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isOwnerColumnDisplayed(), "Owner Column is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isPalletsLabelDisplayed(), "Pallets Label is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isQuantityLabelDisplayed(), "Quantity Label is not displayed");*/
        softAssert.assertTrue(inboundLoadLocationLookupPage.isItemsFoundLabelDisplayed(), "Items Found Label is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isLookupLocationSearchDisplayed(), "Lookup Location Search is not displayed");
        softAssert.assertTrue(inboundLoadLocationLookupPage.isLookupLocationGridTableDisplayed() > 0,
                "Lookup Location Grid Table is not displayed");
        softAssert.assertAll();
    }
}
