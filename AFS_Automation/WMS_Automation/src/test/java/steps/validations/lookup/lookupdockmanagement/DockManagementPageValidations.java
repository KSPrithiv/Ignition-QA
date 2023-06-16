package steps.validations.lookup.lookupdockmanagement;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.lookup.dockmanagement.DockManagementLookupPage;

public class DockManagementPageValidations {
    DockManagementLookupPage dockManagementLookupPage = new DockManagementLookupPage();

    @And("Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page")
    public void validateGridItemsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.isDateInputFilterDisplayed(),"Date Input Filter is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isDateToInputFilterDisplayed(),"Date To Input Filter is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isChkBoxShowAllDisplayed(),"Chk Box Show All is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isChkBoxReceivingDisplayed(),"Chk Box Receiving is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isChkBoxShippingDisplayed(),"Chk Box Shipping is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isChkBoxProductionDisplayed(),"Chk Box Production is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isCompleteLabelDisplayed(),"Complete Label is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isInProgressLabelDisplayed(),"In Progress Label is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isLateLabelDisplayed(),"Late Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates DockManagement Lookup Page dates are displayed on DockManagement Lookup page")
    public void validateDatesDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.isDateInputFilterDisplayed(), "Date Input Filter is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isDateToInputFilterDisplayed(), "Date To Input Filter is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page")
    public void validateRoutesOrdersLoadsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.areOutboundLabelsPresent() > 0,"Outbound Labels are not displayed");
        softAssert.assertTrue(dockManagementLookupPage.areInboundLabelsPresent() > 0,"Inbound Labels are not displayed");
        softAssert.assertTrue(dockManagementLookupPage.areItemsPresent() > 0,"Items are not displayed");
        softAssert.assertTrue(dockManagementLookupPage.areDockMgmtSummaryRowsPresent() > 0,"DockMgmt Summary Rows are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Item Details are displayed on DockManagement Lookup page")
    public void validateItemDetailsAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.isOrdersAssignToDoorLabelDisplayed(),"Orders Assign To Door is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isButtonBackDisplayed(),"Button Back is not displayed");
        softAssert.assertAll();
    }

    @And("Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page")
    public void validateDockMgmtSummaryRowsAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.areDockMgmtSummaryRowsPresent() > 0,"DockMgmt Summary Rows are not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} popup is displayed on DockManagement Lookup page")
    public void validateWindowTitleDisplayed(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.getСhangeTrailerPopUpTitleText().contains(text));
        softAssert.assertAll();
    }

    @And("Validates Scheduled time popup is displayed on DockManagement Lookup page")
    public void validateSchedDateTimeDetailsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.isDateInputSchedDateLabelDisplayed(), "Scheduled Date Label is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isInputSchedDateDisplayed(), "Scheduled Date is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isInputFilterTimeLabelDisplayed(), "Time Label is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isInputFilterTimeDisplayed(), "Time is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Receiving, Shipping, Production are disabled on DockManagement Lookup page")
    public void validateReceivingShippingProductionDisabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.isChkBoxShowAllDisplayed(), "Scheduled Date Label is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isReceivingChkDisabled().equals("true"), "Receiving checkbox is not disabled");
        softAssert.assertTrue(dockManagementLookupPage.isShippingChkDisabled().equals("true"), "Shipping checkbox is not disabled");
        softAssert.assertTrue(dockManagementLookupPage.isProductionChkDisabled().equals("true"), "Production checkbox is not disabled");
        softAssert.assertAll();
    }

    @And("Validates Receiving, Shipping, Production are enabled on DockManagement Lookup page")
    public void validateReceivingShippingProductionEnabled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.isChkBoxShowAllDisplayed(), "Scheduled Date Label is not displayed");
        softAssert.assertNull(dockManagementLookupPage.checkElementReceivingChk(), "Receiving checkbox is not enabled");
        softAssert.assertNull(dockManagementLookupPage.checkElementShippingChk(), "Shipping checkbox is not enabled");
        softAssert.assertNull(dockManagementLookupPage.checkElementProductionChk(), "Production checkbox is not enabled");
        softAssert.assertAll();
    }

    @And("Validates Color Indication labels are correct on DockManagement Lookup page")
    public void validateColorIndicationLabelsCorrect() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dockManagementLookupPage.isCompleteLabelDisplayed(), "Complete Label is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isInProgressLabelDisplayed(), "In Progress Label is not displayed");
        softAssert.assertTrue(dockManagementLookupPage.isLateLabelDisplayed(), "Late Label is not displayed");
        softAssert.assertAll();
    }
}
