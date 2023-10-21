package steps.validations.lookup.lookupplabel;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.lookup.lookuplabel.LabelLookupPage;

public class LabelLookupPageValidations {
    LabelLookupPage labelLookupPage = new LabelLookupPage();

    @And("Validates Label Lookup Page base elements are loaded")
    public void validatePrintLabelPopupElementsPresent() {
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


}
