package steps.validations.outbound.loadplanning;

import common.constants.Notifications;
import common.setup.DriverManager;
import common.utils.Waiters;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import ui.pages.outbound.loadplanning.OutboundAssignmentsPage;
import ui.pages.outbound.loadplanning.OutboundTruckInfoPage;

import java.awt.*;

public class OutboundAssignmentsPageValidations {

    WebDriver driver;
    Scenario scenario;
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
    public void validateAssignments() throws InterruptedException, AWTException {
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
