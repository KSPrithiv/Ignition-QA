package steps.validations.lookup.lookupplabel;

import common.constants.Notifications;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.lookup.lookuplabel.LabelLookupPage;

public class LabelLookupPageValidations {
    LabelLookupPage labelLookupPage = new LabelLookupPage();

    @And("Validates Unit popup base elements are loaded for Label Lookup Page")
    public void validatePrintLabelPopupForUnitElementsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(labelLookupPage.isLabelTypeLabelDisplayed(),"Label Type is not displayed");
        softAssert.assertTrue(labelLookupPage.isUnitInputDisplayed(),"Unit Input is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelFormatLabelDisplayed(),"Label Format is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelFormatDropDownDisplayed(),"Label Format DropDown is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelNumLabelDisplayed(),"Label Num is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelNumLInputDisplayed(),"Label Num Input is not displayed");
        softAssert.assertTrue(labelLookupPage.isProductIndexLabelDisplayed(),"Product Index is not displayed");
        softAssert.assertTrue(labelLookupPage.isProductIndexInputDisplayed(),"Product Index Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Location popup base elements are loaded for Label Lookup Page")
    public void validatePrintLabelPopupForLocationElementsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(labelLookupPage.isLabelTypeLabelDisplayed(),"Label Type is not displayed");
        softAssert.assertTrue(labelLookupPage.isLocationInputDisplayed(), "Location Input is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelFormatLabelDisplayed(),"Label Format is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelFormatDropDownDisplayed(),"Label Format DropDown is not displayed");
        softAssert.assertTrue(labelLookupPage.isFromLocationLabelDisplayed(),"From location label is not displayed");
        softAssert.assertTrue(labelLookupPage.isEnterFromLocationDisplayed(),"Enter from location is not displayed");
        softAssert.assertTrue(labelLookupPage.isToLocationLabelDisplayed(),"To location label is not displayed");
        softAssert.assertTrue(labelLookupPage.isEnterToLocationDisplayed(),"Enter to location is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Receiving Unit popup base elements are loaded for Label Lookup Page")
    public void validatePrintLabelPopupForReceivingUnitElementsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(labelLookupPage.isLabelTypeLabelDisplayed(),"Label Type is not displayed");
        softAssert.assertTrue(labelLookupPage.isReceivingUnitInputDisplayed(), "Receiving Unit Input is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelFormatLabelDisplayed(),"Label Format is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelFormatDropDownDisplayed(),"Label Format DropDown is not displayed");
        softAssert.assertTrue(labelLookupPage.isLpnLabelDisplayed(),"Lpn Label is not displayed");
        softAssert.assertTrue(labelLookupPage.isLpnInputDisplayed(),"Lpn Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Product popup base elements are loaded for Label Lookup Page")
    public void validatePrintLabelPopupForProductElementsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(labelLookupPage.isLabelTypeLabelDisplayed(),"Label Type is not displayed");
        softAssert.assertTrue(labelLookupPage.isProductInputDisplayed(), "Product Input is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelFormatLabelDisplayed(),"Label Format is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelFormatDropDownDisplayed(),"Label Format DropDown is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelNumLabelDisplayed(),"Label Num is not displayed");
        softAssert.assertTrue(labelLookupPage.isLabelNumLInputDisplayed(),"Label Num Input is not displayed");
        softAssert.assertTrue(labelLookupPage.isIndexProductLabelDisplayed(),"Index Product Label is not displayed");
        softAssert.assertTrue(labelLookupPage.isSelectProductInputDisplayed(),"Select Product Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Location index popup title is displayed")
    public void validateLocationIndexPopupTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(labelLookupPage.getDialogTitleText(), Notifications.LOCATION_INDEX);
        softAssert.assertAll();
    }

}
