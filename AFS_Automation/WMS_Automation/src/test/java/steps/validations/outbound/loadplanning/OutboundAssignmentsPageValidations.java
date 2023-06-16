package steps.validations.outbound.loadplanning;

import common.constants.Notifications;
import common.utils.Waiters;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.outbound.loadplanning.OutboundAssignmentsPage;
import ui.pages.outbound.loadplanning.OutboundTruckInfoPage;

public class OutboundAssignmentsPageValidations {
    OutboundAssignmentsPage outboundAssignmentsPage = new OutboundAssignmentsPage();

    @And("Validates table with assignments exist")
    public void validateAssignmentsExist() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundAssignmentsPage.verifyRowsDisplayed() > 0,"Assignments are not displayed");
        softAssert.assertTrue(outboundAssignmentsPage.verifyCheckBoxesDisplayed() > 0,"Assignment checkboxes are not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignments page title is correct")
    public void validateAssignmentPageTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundAssignmentsPage.getAssignmentTitleText(), Notifications.ASSIGNMENTS,
                "Assignments title is not correct");
        softAssert.assertAll();
    }

    @And("Validates that assignments in truck and assignments in Work queue are matched")
    public void validateAssignments() {
        OutboundTruckInfoPage outboundTruckInfoPage = new OutboundTruckInfoPage();
        SoftAssert softAssert = new SoftAssert();
        outboundAssignmentsPage.getAssignmentsNumbers().stream()
                .forEach(num -> {
                    softAssert.assertTrue(outboundTruckInfoPage.getAssignmentsNumbers().toString().contains(num),
                            "Assignment from Assignments Page in not present on Outbound Truck Info Page");
                        });                        ;
        softAssert.assertAll();
    }
}
