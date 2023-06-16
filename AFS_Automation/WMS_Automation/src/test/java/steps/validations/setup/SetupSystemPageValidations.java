package steps.validations.setup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import ui.pages.setup.SetupSystemPage;

public class SetupSystemPageValidations {
    SetupSystemPage setupSystemPage = new SetupSystemPage();

    @Then("Validates Setup System page is displayed")
    public void validateSetupSystemPageDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(setupSystemPage.isFunctionLabelDisplayed(), "Function Label is not displayed");
        softAssert.assertTrue(setupSystemPage.isReasonLabelDisplayed(), "Reason Label is not displayed");
        softAssert.assertTrue(setupSystemPage.isPrinterLabelDisplayed(), "Printer Label is not displayed");
        softAssert.assertTrue(setupSystemPage.isLabelFormatLabelDisplayed(), "Label Format is not displayed");
        softAssert.assertTrue(setupSystemPage.isLabelFileLabelDisplayed(), "Label File is not displayed");
        softAssert.assertTrue(setupSystemPage.isLabelRuleLabelDisplayed(), "Label Rule is not displayed");
        softAssert.assertTrue(setupSystemPage.isPurgeLabelDisplayed(), "Purge Label is not displayed");
        softAssert.assertTrue(setupSystemPage.isRegistryLabelDisplayed(), "Registry Label is not displayed");
        softAssert.assertTrue(setupSystemPage.isPermissionLabelDisplayed(), "Permission Label is not displayed");
        softAssert.assertTrue(setupSystemPage.isUserGroupLabelDisplayed(), "User Group Label is not displayed");
        softAssert.assertTrue(setupSystemPage.isImportDataLabelDisplayed(), "Import Data Label is not displayed");
        softAssert.assertTrue(setupSystemPage.isComputerLabelDisplayed(), "Computer Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Add, Edit, Delete buttons are displayed on Setup System page")
    public void validateAddEditDeleteButtonsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(setupSystemPage.isAddSettingsButton(), "Add Settings Button is not displayed");
        softAssert.assertTrue(setupSystemPage.isEditSettingsButton(), "Edit Settings Button is not displayed");
        softAssert.assertTrue(setupSystemPage.isDeleteSettingsButton(), "Delete Settings Button is not displayed");
        softAssert.assertAll();
    }
}
