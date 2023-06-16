package steps.validations.setup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import ui.pages.setup.SetupProductPage;

import java.util.List;

public class SetupProductPageValidations {
    SetupProductPage setupProductPage = new SetupProductPage();
    SoftAssert softAssert = new SoftAssert();

    @Then("Validates Setup Product page is displayed")
    public void validateSetupProductPageDisplayed() {
        softAssert.assertTrue(setupProductPage.isProductLabelDisplayed(), "Product Label is not displayed");
        softAssert.assertTrue(setupProductPage.isProductTypeLabelDisplayed(), "Product Type Label is not displayed");
        softAssert.assertTrue(setupProductPage.isUnitOfMeasureLabelDisplayed(), "Unit Of Measure Label is not displayed");
        softAssert.assertTrue(setupProductPage.isUnitStatusLabelDisplayed(), "Unit Status Label is not displayed");
        softAssert.assertTrue(setupProductPage.isQualityControlTypeLabelDisplayed(), "Quality Control Type Label is not displayed");
        softAssert.assertTrue(setupProductPage.isPutAwayRuleLabelDisplayed(), "Put Away Rule Label is not displayed");
        softAssert.assertTrue(setupProductPage.isAliasTypeLabelDisplayed(), "Alias Type Label is not displayed");
        softAssert.assertTrue(setupProductPage.isMovementClassLabelDisplayed(), "Movement Class Label is not displayed");
        softAssert.assertTrue(setupProductPage.isGenericLookupTypeLabelDisplayed(), "Generic Lookup Type Label is not displayed");
        softAssert.assertTrue(setupProductPage.isPickSlotTypeLabelDisplayed(), "Pick Slot Type Label is not displayed");
        softAssert.assertTrue(setupProductPage.isDateEncodingLabelDisplayed(), "Date Encoding Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Add, Edit, Delete buttons are displayed on Setup Product page")
    public void validateAddEditDeleteButtonsDisplayed() {
        softAssert.assertTrue(setupProductPage.isAddProductBtnDisplayed(), "Add Product is not displayed");
        softAssert.assertTrue(setupProductPage.isEditProductBtnDisplayed(), "Edit Product is not displayed");
        softAssert.assertTrue(setupProductPage.isDeleteProductBtnDisplayed(), "Delete Product is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Date Encoding Row {string} on Setup Product page")
    public void validateDateEncodingRowDisplayed(String rowNum) {
        softAssert.assertTrue(setupProductPage.isDateEncodingRowDisplayed(rowNum), "Date Encoding Row " + rowNum + " is not displayed");
        softAssert.assertAll();
    }

    @And("Validates UOM tab details on Setup Product page")
    public void validateUOMtabDetailsDisplayed() {
        softAssert.assertTrue(setupProductPage.isReceivingUOMLabelDisplayed(), "Receiving UOM Label is not displayed");
        softAssert.assertTrue(setupProductPage.isReceivingUOMDisplayed(), "Receiving UOM is not displayed");
        softAssert.assertTrue(setupProductPage.isMovementUOMLabelDisplayed(), "Movement UOM Label is not displayed");
        softAssert.assertTrue(setupProductPage.isMovementUOMDisplayed(), "Movement UOM is not displayed");
        softAssert.assertTrue(setupProductPage.isShippingUOMLabelDisplayed(), "Shipping UOM Label is not displayed");
        softAssert.assertTrue(setupProductPage.isShippingUOMDisplayed(), "Shipping UOM is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Add is enabled and Edit, Delete are disabled on Setup Product page")
    public void validateAddEditDeleteButtonsActivity() {
        softAssert.assertFalse(setupProductPage.checkAddBtnDisabled() != null, "Add Product is not displayed");
        softAssert.assertTrue(setupProductPage.isEditBtnDisabled().equals("true"), "Edit Product is not displayed");
        softAssert.assertTrue(setupProductPage.isDeleteBtnDisabled().equals("true"), "Delete Product is not displayed");
        softAssert.assertAll();
    }


    @And("Validates Add is enabled and Edit, Delete are disabled on Date encoding popup on Setup Product page")
    public void validateAddEditDeleteButtonsOnDateEncodingActivity() {
        softAssert.assertFalse(setupProductPage.checkAddDisabled() != null, "Add is not displayed");
        softAssert.assertTrue(setupProductPage.isEditDisabled().equals("true"), "Edit is not displayed");
        softAssert.assertTrue(setupProductPage.isDeleteDisabled().equals("true"), "Delete is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page")
    public void validateDateEncodingPopupEnableDisable() {
        softAssert.assertFalse(setupProductPage.isEncodingTabDisabled().contains("k-state-disabled") , "Encoding Tab is not enabled");
        softAssert.assertFalse(setupProductPage.isUsedByTabDisabled().contains("k-state-disabled") , "Used By Tab is not enabled");
        softAssert.assertTrue(setupProductPage.isDayMappingTabDisabled().contains("k-state-disabled") , "Day Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isMonthMappingTabDisabled().contains("k-state-disabled") , "Month Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isYearMappingTabDisabled().contains("k-state-disabled") , "Year Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isWeekMappingTabDisabled().contains("k-state-disabled") , "Week Mapping Tab is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Date encoding fields are displayed correctly on Setup Product page")
    public void validateDateEncodingPopupFields() {
        softAssert.assertTrue(setupProductPage.isCodeLabelDisplayed(), "Encoding Tab is not enabled");
        softAssert.assertTrue(setupProductPage.isInputCodeDisplayed(), "Used By Tab is not enabled");
        softAssert.assertTrue(setupProductPage.isDescLabelDisplayed(), "Day Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isInputDescDisplayed(), "Month Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isLotMaskDisplayed(), "Year Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isInputLotMaskDisplayed(), "Week Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isExtractDateAsLabelDisplayed(), "Year Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isExtractDateAsDropDownDisplayed(), "Week Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isPromptLabelDisplayed(), "Year Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isInputPromptDisplayed(), "Week Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isDayMappingLabelDisplayed(), "Year Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isDayMapDropDownDisplayed(), "Week Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isMonthMappingLabelDisplayed(), "Year Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isMonthMapDropDownDisplayed(), "Week Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isYearMappingLabelDisplayed(), "Year Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isYearMapDropDownDisplayed(), "Week Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isWeekMappingLabelDisplayed(), "Year Mapping Tab is not disabled");
        softAssert.assertTrue(setupProductPage.isWeekMapDropDownDisplayed(), "Week Mapping Tab is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Items Count and Items Found on Setup Product page")
    public void validateItemsCountFoundDisplayed() {
        softAssert.assertTrue(setupProductPage.isItemsCountDisplayed(), "Items Count is not displayed");
        softAssert.assertTrue(setupProductPage.isItemsFoundDisplayed(), "Items Found is not displayed");
        softAssert.assertAll();
    }

    @And("Validates items are present on Setup Product page")
    public void validateOrdersPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(setupProductPage.isItemsCountDisplayed(),"Items Count is not displayed");
        softAssert.assertTrue(setupProductPage.isItemsFoundDisplayed(),"Items Found is not displayed");
        softAssert.assertTrue(!setupProductPage.getItemsFoundText().equals("0"),"Items Found is 0");
        softAssert.assertAll();
    }

    @And("Validates UOM grid should display all column names on Setup Product page")
    public void validateUOMGridColumns() {
        softAssert.assertTrue(setupProductPage.isNameTabDisplayed(), "Name Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isLengthTabDisplayed(), "Length Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isWidthTabDisplayed(), "Width Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isHeightTabDisplayed(), "Height Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isCubeTabDisplayed(), "Cube Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isWeightTabDisplayed(), "Weight Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isTareTabDisplayed(), "Tare Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isPacksizeTabDisplayed(), "Pack size Tab is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Dialog Title {string} on Setup Product page")
    public void validateDialogTitleText(String text) {
        softAssert.assertEquals(setupProductPage.getDialogTitleText(), text, "Dialog Title is not correct");
        softAssert.assertAll();
    }

    @And("Validates grid text {string} on Setup Product page")
    public void validateGridText(String text) {
        softAssert.assertEquals(setupProductPage.getNotificationText(), text, "Grid text is not correct");
        softAssert.assertAll();
    }

    @And("Validates Alert {string} on Setup Product page")
    public void validateAlert(String alert) {
        softAssert.assertTrue(setupProductPage.getAlert(alert).isDisplayed(), "Alert is not correct");
        softAssert.assertAll();
    }

    @And("Validates UOM options on Setup Product page")
    public void validateDialogTitleOptions() {
        softAssert.assertEquals(setupProductPage.getOptions(), List
                .of("BAGS", "CARTON", "CARTONS", "CASES", "DOZEN", "EACH", "GALLON", "KILOGRAM", "MILK CRATE", "OUNCE", "PACK", "POUNDS", "ROLL"),
                "UOM options are not correct");
        softAssert.assertAll();
    }

    @And("Validates Weight Value {string} on UOM popup on Setup Product page")
    public void validateWeightValue(String text) {
        softAssert.assertTrue(setupProductPage.getWeightValue().equals(text), "Weight Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Width Value {string} on UOM popup on Setup Product page")
    public void validateWidthValue(String text) {
        softAssert.assertTrue(setupProductPage.getWidthValue().equals(text), "Width Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Height Value {string} on UOM popup on Setup Product page")
    public void validateHeightValue(String text) {
        softAssert.assertTrue(setupProductPage.getHeightValue().equals(text), "Height Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Length Value {string} on UOM popup on Setup Product page")
    public void validateLengthValue(String text) {
        softAssert.assertTrue(setupProductPage.getLengthValue().equals(text), "Length Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Cut Time Value {string} on UOM popup on Setup Product page")
    public void validateCutTimeValue(String text) {
        softAssert.assertTrue(setupProductPage.getCutTimeValue().equals(text), "Cut Time Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Shelf Unit Value {string} on UOM popup on Setup Product page")
    public void validateShelfUnitValue(String text) {
        softAssert.assertTrue(setupProductPage.getShelfUnitValue().equals(text), "Shelf Unit Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Size Code default value on UOM popup on Setup Product page")
    public void validateSizeCodeValue() {
        softAssert.assertTrue(setupProductPage.getSizeCodeValue().equals(""), "Size Code Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Size Code Value {string} on UOM popup on Setup Product page")
    public void validateSizeCodeValue(String text) {
        softAssert.assertTrue(setupProductPage.getSizeCodeValue().equals(text), "Size Code Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates OK and Cancel on UOM popup on Setup Product page are displayed")
    public void validateOKCancelDisplayed() {
        softAssert.assertTrue(setupProductPage.isOKBtnDisplayed(), "OK button is not displayed");
        softAssert.assertTrue(setupProductPage.isCancelBtnDisplayed(), "Cancel button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Weight or Tare Weight options on Setup Product page")
    public void validateWeightOptions() {
        softAssert.assertEquals(setupProductPage.getOptions(), List.of("lb", "kg", "g", "50wt", "100wt"),
                "Weight options are not correct");
        softAssert.assertAll();
    }

    @And("Validates Width or Height or Length options on Setup Product page")
    public void validateWidthOptions() {
        softAssert.assertEquals(setupProductPage.getOptions(), List.of("in", "m", "ft", "cm"),
                "Width or Height or Length options are not correct");
        softAssert.assertAll();
    }

    @And("Validates Cut time options on Setup Product page")
    public void validateCutTimeOptions() {
        softAssert.assertEquals(setupProductPage.getOptions(), List.of("min", "sec", "hrs"),"Time options are not correct");
        softAssert.assertAll();
    }

    @And("Validates Date encoding tab grid should display all column names on Setup Product page")
    public void validateDateEncodingGridColumns() {
        softAssert.assertTrue(setupProductPage.isDateEncodingTabDisplayed(), "Date encoding Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isCodeTabDisplayed(), "Code Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isDescTabDisplayed(), "Desc Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isDayMappingTabDisplayed(), "Day Mapping Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isMonthMappingTabDisplayed(), "Month Mapping Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isExtractDateAsTabDisplayed(), "Extract Date as Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isYearMappingTabDisplayed(), "Year Mapping Tab is not displayed");
        softAssert.assertTrue(setupProductPage.isWeekMappingTabDisplayed(), "Week Mapping Tab is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Search Box and Add Filter are displayed on Setup Product page")
    public void validateSearchBoxAndAddFilterDisplayed() {
        softAssert.assertTrue(setupProductPage.isSearchBoxDisplayed(), "Search Box is not displayed");
        softAssert.assertTrue(setupProductPage.isAddFilterDisplayed(), "Add Filter is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Supplier and Product are displayed on Setup Product page")
    public void validateSupplierAndProductDisplayed() {
        softAssert.assertTrue(setupProductPage.isSupplierColumnDisplayed(), "Supplier is not displayed");
        softAssert.assertTrue(setupProductPage.isProductColumnDisplayed(), "Product is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Extract Date As Text {string} on Date encoding popup on Setup Product page")
    public void validateExtractDateAsValue(String text) {
        softAssert.assertTrue(setupProductPage.getExtractDateAsText().equals(text), "Extract Date As Text is not correct");
        softAssert.assertAll();
    }

    @And("Validates Extract date as options on Setup Product page")
    public void validateExtractDateAsOptions() {
        softAssert.assertEquals(setupProductPage.getOptions(), List.of("(None)", "Production date", "Expiration date"),
                "Extract date as options are not correct");
        softAssert.assertAll();
    }

    @And("Validates Day Mapping Text {string} on Date encoding popup on Setup Product page")
    public void validateDayMappingText(String text) {
        softAssert.assertTrue(setupProductPage.getDayMappingText().equals(text), "Day Mapping Text is not correct");
        softAssert.assertAll();
    }

    @And("Validates Day Mapping options on Setup Product page")
    public void validateDayMappingOptions() {
        softAssert.assertEquals(setupProductPage.getOptions(), List.of("(None)", "Digit from char", "char to value"),
                "Day Mapping options are not correct");
        softAssert.assertAll();
    }

    @And("Validates Month Mapping Text {string} on Date encoding popup on Setup Product page")
    public void validateMonthMappingText(String text) {
        softAssert.assertTrue(setupProductPage.getMonthMappingText().equals(text), "Month Mapping Text is not correct");
        softAssert.assertAll();
    }

    @And("Validates Month Mapping options on Setup Product page")
    public void validateMonthMappingOptions() {
        softAssert.assertEquals(setupProductPage.getOptions(), List.of("(None)", "Digit from char", "char to value"),
                "Month Mapping options are not correct");
        softAssert.assertAll();
    }

    @And("Validates Year Mapping Text {string} on Date encoding popup on Setup Product page")
    public void validateYearMappingValue(String text) {
        softAssert.assertTrue(setupProductPage.getYearMappingText().equals(text), "Year Mapping Text is not correct");
        softAssert.assertAll();
    }

    @And("Validates Year Mapping options on Setup Product page")
    public void validateYearMappingOptions() {
        softAssert.assertEquals(setupProductPage.getOptions(), List.of("(None)", "Digit from char", "char to value"),
                "Year Mapping options are not correct");
        softAssert.assertAll();
    }

    @And("Validates Week Mapping Text {string} on Date encoding popup on Setup Product page")
    public void validateWeekMappingValue(String text) {
        softAssert.assertTrue(setupProductPage.getWeekMappingText().equals(text), "Week Mapping Text is not correct");
        softAssert.assertAll();
    }

    @And("Validates Week Mapping options on Setup Product page")
    public void validateWeekMappingOptions() {
        softAssert.assertEquals(setupProductPage.getOptions(), List.of("(None)", "Digit from char", "char to value"),
                "Week Mapping options are not correct");
        softAssert.assertAll();
    }

    @And("Validates warning message {string} on Date encoding popup on Setup Product page")
    public void validateDateEncodingWarningValue(String text) {
        softAssert.assertEquals(setupProductPage.getNotificationMsgText(), text, "Notification Text is not correct");
        softAssert.assertAll();
    }

    @And("Validates {string} option on Setup Product page")
    public void validateWeekMappingOptions(String option) {
        softAssert.assertTrue(setupProductPage.getOptions().contains(option),"Date encoding option is not correct");
        softAssert.assertAll();
    }
}
