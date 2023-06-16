package steps.validations.outbound.loadplanning;

import common.constants.Notifications;
import common.constants.TimeFormats;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.outbound.loadplanning.OutboundLoadPlanningPage;

public class OutboundLoadPlanningPageValidations {
    OutboundLoadPlanningPage outboundLoadPlanningPage = new OutboundLoadPlanningPage();

    @And("Validates Load Planning page is displayed")
    public void validateOutboundOrderSummaryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundLoadPlanningPage.isLoadPlanningDialogDisplayed(), "Load Planning Dialog is not present");
        softAssert.assertTrue(outboundLoadPlanningPage.isLoadPlanningShipDateDisplayed(), "Load Planning Ship Date is not present");
        softAssert.assertTrue(outboundLoadPlanningPage.isLoadPlanningShipDateLabelDisplayed(),"Load Planning Ship Date Label is not present");
        softAssert.assertTrue(outboundLoadPlanningPage.isDropDownRouteTypeDisplayed(), "Dropdown Route Type is not present");
        softAssert.assertTrue(outboundLoadPlanningPage.isDropDownRouteTypeLabelDisplayed(), "Dropdown Route Type Label is not present");
        softAssert.assertAll();
    }

    @And("Validates Load Planning popup title is displayed")
    public void validateLoadPlanningPopupTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundLoadPlanningPage.getLoadPlanningDialogText(), Notifications.LOAD_PLANNING);
        softAssert.assertAll();
    }

    @And("Validates Load Planning popup Ship Date is current date")
    public void validateLoadPlanningPopupShipDateIsCorrect() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundLoadPlanningPage.getLoadPlanningShipDateValue(), TimeConversion
                .getFormattedCurrentDate(TimeFormats.format_MMddyyyy));
        softAssert.assertAll();
    }

    @And("Validates Load Planning routes exist for selected Ship Date")
    public void validateLoadPlanningPopupRoutesExist() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundLoadPlanningPage.getRoutes().size() > 0, "Routes for Load Planning do not exist");
        softAssert.assertAll();
    }
}
