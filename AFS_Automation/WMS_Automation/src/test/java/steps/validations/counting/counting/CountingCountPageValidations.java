package steps.validations.counting.counting;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import objects.countingcount.CountingCountDTO;
import org.testng.asserts.SoftAssert;
import ui.pages.counting.counting.CountingCountPage;

public class CountingCountPageValidations {
    CountingCountPage countingCountPage = new CountingCountPage();
    CountingCountDTO countingCountDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.COUNTING_COUNT_DATA, CountingCountDTO.class);

    @And("Validates Counting Count page is displayed")
    public void validateCountingCountPageDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isCountPageTitleDisplayed(), "Counting Page title is not displayed");
        softAssert.assertTrue(countingCountPage.isCycleCountSessionLabelDisplayed(), "Session Label is not displayed");
        softAssert.assertTrue(countingCountPage.isCycleCountSessionDisplayed(), "Session dropdown is not displayed");
        softAssert.assertTrue(countingCountPage.isCycleCountAssignmentLabelDisplayed(), "Assignment Label is not displayed");
        softAssert.assertTrue(countingCountPage.isCycleCountAssignmentDisplayed(), "Assignment dropdown is not displayed");
        softAssert.assertTrue(countingCountPage.isCycleProductSearchDisplayed(), "Product Search is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Counting Count page columns are displayed")
    public void validateCountingCountPageColumnsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isLocationColumnDisplayed(), "Location Column is not displayed");
        softAssert.assertTrue(countingCountPage.isProductColumnDisplayed(), "Product Column is not displayed");
        softAssert.assertTrue(countingCountPage.isUpcColumnDisplayed(), "UPC Column is not displayed");
        softAssert.assertTrue(countingCountPage.isDescriptionColumnDisplayed(), "Description Column is not displayed");
        softAssert.assertTrue(countingCountPage.isOnHandColumnDisplayed(), "On Hand Column is not displayed");
        softAssert.assertTrue(countingCountPage.isCountColumnDisplayed(), "Count Column is not displayed");
        softAssert.assertTrue(countingCountPage.isUomColumnDisplayed(), "UOM Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Add filter button on Counting Count page is displayed")
    public void validateAddFilterButtonDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isAddFilterButtonDisplayed(), "Add Filter Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Product Search on Counting Count page is displayed")
    public void validateProductSearchDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isCycleProductSearchDisplayed(), "Product Search is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Items Count and Items Found on Counting Count page is displayed")
    public void validateItemsCountFoundDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isItemsCountDisplayed(), "Items Count is not displayed");
        softAssert.assertTrue(countingCountPage.isItemsFoundDisplayed(), "Items Found is not displayed");
        softAssert.assertAll();
    }

    @And("Validates sessions are present on Counting Count page")
    public void validateSessionsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.getSessions() > 0, "Sessions are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Items Count on Counting Count page are present")
    public void validateItemsCountPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!countingCountPage.getItemsCountText().equals(""), "Items Count are not present");
        softAssert.assertAll();
    }

    @And("Validates Product, Factor and On Hand on Counting Count page are displayed")
    public void validateProductFactorOnHandColumnsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isProductsColumnDisplayed(), "Product Column is not displayed");
        softAssert.assertTrue(countingCountPage.isFactorColumnDisplayed(), "Factor Column is not displayed");
        softAssert.assertTrue(countingCountPage.isOnhandColumnDisplayed(), "On Hand Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Location Label on Counting Count page is displayed")
    public void validateLocationLabelPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isLocationLabelDisplayed(), "Location Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Count Quantity inputs are editable on Counting Count page")
    public void validateCountQuantityEditable() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.getCountQuantityValueByIndex(0).equals("0"), "Count Quantity input is not editable");
        softAssert.assertTrue(countingCountPage.getCountQuantityValueByIndex(1).equals("0"), "Count Quantity input is not editable");
        softAssert.assertAll();
    }

    @And("Validates Count Quantity value {string} in {int} input field on Counting Count page")
    public void validateCountQuantityValue(String value, int index) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.getCountQuantityValueByIndex(index).equals(value),
                "Count Quantity value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Items Found, Add product, Product inputs, Cancel and Save buttons are displayed on Counting Count page")
    public void validateCountTableData() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isItemsFoundLabelDisplayed(), "Items Found Label is not displayed");
       /* softAssert.assertTrue(countingCountPage.isMinusIconDisplayed(), "Minus Icon is not displayed");
        softAssert.assertTrue(countingCountPage.areProductDataTextBoxes() > 0, "Product Data inputs are not displayed");*/
        softAssert.assertTrue(countingCountPage.isCancelButtonDisplayed(), "Cancel Button is not displayed");
        softAssert.assertTrue(countingCountPage.isSaveButtonDisplayed(), "Save Button input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Product Data Text Boxes are displayed on Counting Count page")
    public void validateProductDataTextBoxes() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.areProductDataTextBoxes() > 0, "Product Data inputs are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Each and Bag are displayed on Counting Count page")
    public void validateEachAndBagData() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isEachColumnDisplayed(), "Each Column is not displayed");
        softAssert.assertTrue(countingCountPage.isBagColumnDisplayed(), "Bag Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Each and Cases are displayed on Counting Count page")
    public void validateEachAndCasesData() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isEachColumnDisplayed(), "Each Column is not displayed");
        softAssert.assertTrue(countingCountPage.isCasesColumnDisplayed(), "Cases Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Pallet and Layer and Cases are displayed on Counting Count page")
    public void validatePalletAndLayerAndCasesData() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isPalletColumnDisplayed(), "Pallet Column is not displayed");
        softAssert.assertTrue(countingCountPage.isLayerColumnDisplayed(), "Layer Column is not displayed");
        softAssert.assertTrue(countingCountPage.isCasesColumnDisplayed(), "Cases Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates LPN, LPN Type and Product Code are displayed on Counting Count page")
    public void validateLpnAndLpnTypeAndProductCodeDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isTxtLpnLabelDisplayed(), "LPN Label is not displayed");
        softAssert.assertTrue(countingCountPage.isTxtLpnDisplayed(), "LPN Input is not displayed");
        softAssert.assertTrue(countingCountPage.isPalletTypeLabelDisplayed(), "Type Label is not displayed");
        softAssert.assertTrue(countingCountPage.isPalletTypeDisplayed(), "Type Dropdown is not displayed");
        softAssert.assertTrue(countingCountPage.isProductIndexLabelDisplayed(), "Product Label is not displayed");
        softAssert.assertTrue(countingCountPage.isProductInputDisplayed(), "Product Input is not displayed");
        softAssert.assertTrue(countingCountPage.isSearchProductButtonDisplayed(), "Search Product Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Product details are displayed on Counting Count page")
    public void validateDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isOwnerLabelDisplayed(), "Owner Label is not displayed");
        softAssert.assertTrue(countingCountPage.isOwnerDropdownDisplayed(), "Owner Dropdown is not displayed");
        softAssert.assertTrue(countingCountPage.isSupplierLabelDisplayed(), "Supplier Label is not displayed");
        softAssert.assertTrue(countingCountPage.isSupplierDropdownDisplayed(), "Supplier Dropdown is not displayed");
        softAssert.assertTrue(countingCountPage.isQtyLabelDisplayed(), "Qty Label is not displayed");
        softAssert.assertTrue(countingCountPage.isQtyInputDisplayed(), "Qty Input is not displayed");
        softAssert.assertTrue(countingCountPage.isTxtQtyLabelDisplayed(), "Qty Label is not displayed");
        softAssert.assertTrue(countingCountPage.isTxtQtyDisplayed(), "Qty Input is not displayed");
        softAssert.assertTrue(countingCountPage.isUomLabelDisplayed(), "UOM Label is not displayed");
        softAssert.assertTrue(countingCountPage.isUomDropDownDisplayed(), "UOM DropDown is not displayed");
        softAssert.assertTrue(countingCountPage.isStatusLabelDisplayed(), "Status Label is not displayed");
        softAssert.assertTrue(countingCountPage.isStatusDropDownDisplayed(), "Status DropDown is not displayed");
        softAssert.assertAll();
    }

    @And("Validates save button enabled on Counting Count page")
    public void validateSaveButtonEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingCountPage.isSaveButtonEnabled(), "Save Button is not enabled");
        softAssert.assertAll();
    }

}
