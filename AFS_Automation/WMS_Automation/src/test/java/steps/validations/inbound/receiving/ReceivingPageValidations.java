package steps.validations.inbound.receiving;

import io.cucumber.java.en.And;
import org.apache.commons.lang3.StringUtils;
import org.testng.asserts.SoftAssert;
import ui.pages.inbound.receiving.ReceivingPage;

public class ReceivingPageValidations {
    ReceivingPage receivingPage = new ReceivingPage();
    SoftAssert softAssert = new SoftAssert();

    @And("Receiving page contains all web elements")
    public void validateReceivingPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isTopIconDisplayed(), "Top Icon is not visible");
        softAssert.assertTrue(receivingPage.isOrderLabelPresent(), "Order Label is not present");
        softAssert.assertTrue(receivingPage.isOrderInputPresent(), "Order Input is not present");
        softAssert.assertTrue(receivingPage.isLoadLabelPresent(), "Load Label is not present");
        softAssert.assertTrue(receivingPage.isLoadInputPresent(), "Load Input is not present");
        softAssert.assertTrue(receivingPage.isDoorLabelPresent(), "Door Label is not present");
        softAssert.assertTrue(receivingPage.isDoorInputPresent(), "Door Input is not present");
        softAssert.assertTrue(receivingPage.isLocationLabelPresent(), "Location Label is not present");
        softAssert.assertTrue(receivingPage.isLocationInputPresent(), "Location Input is not present");
        softAssert.assertAll();
    }

    @And("Back button is clickable on Receiving page")
    public void validateBackButtonOnReceivingPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isBackButtonClickable(), "Back button is not clickable");
        softAssert.assertAll();
    }

    @And("Verify default {string} Location on Receiving page")
    public void validateDefaultLocationReceivingPage(String location) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(receivingPage.getLocationValue(), location, "Default Location is not correct");
        softAssert.assertAll();
    }

    @And("Validates Qty, UOM, Status and Expiration date displayed on Receiving page")
    public void validateDefaultFieldsOnReceivingPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isQtyInputDisplayed(), "Qty Input is not displayed");
        softAssert.assertTrue(receivingPage.isUomLabelDisplayed(), "UOM Label is not displayed");
        softAssert.assertTrue(receivingPage.isUomDropDownDisplayed(), "UOM Dropdown is not displayed");
        softAssert.assertTrue(receivingPage.isStatusLabelDisplayed(), "Status Label is not displayed");
        softAssert.assertTrue(receivingPage.isStatusDropdownDisplayed(), "Status Dropdown is not displayed");
        softAssert.assertTrue(receivingPage.isExpDateInputDisplayed(), "ExpDate Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates table is displayed on Staging screen")
    public void validateTableOnStagingPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isPalletColumnDisplayed(), "Pallet Column is not displayed");
        softAssert.assertTrue(receivingPage.isProductColumnDisplayed(), "Product Column is not displayed");
        softAssert.assertTrue(receivingPage.isDescriptionColumnDisplayed(), "Description Column is not displayed");
        softAssert.assertTrue(receivingPage.isQtyColumnDisplayed(), "Qty Column is not displayed");
        softAssert.assertTrue(receivingPage.isUomColumnDisplayed(), "Uom Column is not displayed");
        softAssert.assertTrue(receivingPage.isLotColumnDisplayed(), "Lot Column is not displayed");
        softAssert.assertTrue(receivingPage.isExpDateColumnDisplayed(), "ExpDate Column is not displayed");
        softAssert.assertTrue(receivingPage.isWeightColumnDisplayed(), "Weight Column is not displayed");
        softAssert.assertTrue(receivingPage.isCustomerColumnDisplayed(), "Customer Column is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Receive button is displayed on Receiving page")
    public void validateReceiveButtonOnReceivingPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isReceiveButtonDisplayed(), "Receive Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Back button is displayed on Stage page")
    public void validateBackButtonOnStagePage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isBackButtonOnStageDisplayed(), "Back Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Receive button is displayed on Stage page")
    public void validateReceiveButtonOnStagePage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isReceiveButtonOnStageDisplayed(), "Receive Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Cancel button is displayed on Stage page")
    public void validateCancelButtonOnStagePage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isCancelButtonOnStageDisplayed(), "Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Next button is displayed on Stage page")
    public void validateNextButtonOnStagePage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isNextButtonOnStageDisplayed(), "Next Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Delete button is displayed on Stage page")
    public void validateDeleteButtonOnStagePage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isDeleteButtonOnStageDisplayed(), "Delete Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} message content on dialog popup on Receiving page")
    public void validateWarningMessage(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(receivingPage.getDialogTextContentText(),  message, "Warning Message is not correct");
        softAssert.assertAll();
    }

    @And("Validates Yes and No buttons displayed on Receiving page")
    public void validateYesNoButtons() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isYesButtonDisplayed(), "Yes Button is not displayed");
        softAssert.assertTrue(receivingPage.isNoButtonDisplayed(), "No Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} title on dialog popup on Receiving page")
    public void validateTitleMessage(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(receivingPage.getWarningTitleText(),  message, "Warning Title is not correct");
        softAssert.assertAll();
    }

    @And("Validates Staging screen summary details on Receiving page")
    public void validateStagingScreenSummaryDetail() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isPalletsLabelDisplayed(), "Pallets Label is not displayed");
        softAssert.assertTrue(receivingPage.isPalletsValueDisplayed(), "Pallets Value is not displayed");
     //   softAssert.assertTrue(!receivingPage.getPalletsValueText().contains("0"), "Pallets Value is 0");
        softAssert.assertTrue(receivingPage.isTotalQtyLabelDisplayed(), "Total Qty Label is not displayed");
        softAssert.assertTrue(receivingPage.isTotalQtyValueDisplayed(), "Total Qty Value is not displayed");
   //     softAssert.assertTrue(!receivingPage.getTotalQtyValueText().contains("0"), "Total Qty Value is 0");
        softAssert.assertTrue(receivingPage.isItemsFoundLabelDisplayed(), "Pallets Label is not displayed");
        softAssert.assertTrue(receivingPage.isItemsFoundValueDisplayed(), "Pallets Label is not displayed");
    //    softAssert.assertTrue(!receivingPage.getItemsFoundValueText().contains("0"), "Items Found Value is 0");
        softAssert.assertAll();
    }

    @And("Validates Receiving page details on Receiving page")
    public void validateReceivingPageDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(receivingPage.isPalletsLabelDisplayed(), "Pallets Label is not displayed");
        softAssert.assertTrue(receivingPage.isPalletsValueDisplayed(), "Pallets Value is not displayed");
        softAssert.assertTrue(!receivingPage.getPalletsValueText().contains("0"), "Pallets Value is 0");
        softAssert.assertTrue(receivingPage.isTotalQtyLabelDisplayed(), "Total Qty Label is not displayed");
        softAssert.assertTrue(receivingPage.isTotalQtyValueDisplayed(), "Total Qty Value is not displayed");
        softAssert.assertTrue(!receivingPage.getTotalQtyValueText().contains("0"), "Total Qty Value is 0");
        softAssert.assertTrue(receivingPage.isItemsFoundLabelDisplayed(), "Pallets Label is not displayed");
        softAssert.assertTrue(receivingPage.isItemsFoundValueDisplayed(), "Pallets Label is not displayed");
        softAssert.assertTrue(!receivingPage.getItemsFoundValueText().contains("0"), "Items Found Value is 0");
        softAssert.assertAll();
    }

    @And("Validates Receiving page values on Receiving page")
    public void validateReceivingPageValues() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!receivingPage.getOrderValue().equals(StringUtils.EMPTY), "Order Value is empty");
        softAssert.assertTrue(!receivingPage.getLoadValue().equals(StringUtils.EMPTY), "Load Value is empty");
        softAssert.assertTrue(!receivingPage.getDockDoorText().equals(StringUtils.EMPTY), "DockDoor Text is empty");
        softAssert.assertTrue(!receivingPage.getLocationValue().equals(StringUtils.EMPTY), "Location Value is empty");
        softAssert.assertAll();
    }

    @And("Validates {string} Location on Receiving page")
    public void validateLocationOnReceivingPage(String location) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(receivingPage.getLocationValue(),  location, "Location is not correct");
        softAssert.assertAll();
    }
}
