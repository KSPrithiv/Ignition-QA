package steps.validations.appointments;

import common.constants.Notifications;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.appointments.AppointmentSchedulerLinkedOrdersPopUpPage;

public class AppointmentSchedulerLinkedOrdersPopUpPageValidations {
    AppointmentSchedulerLinkedOrdersPopUpPage appointmentSchedulerLinkedOrdersPopUpPage =
            new AppointmentSchedulerLinkedOrdersPopUpPage();

    @And("Validates Linked Orders popup is displayed on Appointment Scheduler Linked Orders PopUp Page")
    public void validateLinkedOrdersPopUpTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerLinkedOrdersPopUpPage.isElementDisplay(appointmentSchedulerLinkedOrdersPopUpPage
                        .getLinkedOrdersPopUpTitle()),"Linked Orders Pop Up Title is not displayed");
        softAssert.assertEquals(appointmentSchedulerLinkedOrdersPopUpPage.getLinkedOrdersPopUpTitleText(), Notifications.CONFIRM_TITLE);
        softAssert.assertAll();
    }

    @And("Validates Linked Orders popup content is displayed on Appointment Scheduler Linked Orders PopUp Page")
    public void validateLinkedOrdersPopUpContent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerLinkedOrdersPopUpPage.isElementDisplay(appointmentSchedulerLinkedOrdersPopUpPage
                        .getLinkedOrdersPopUpContent()),"Linked Orders Pop Up Content is not displayed");
        softAssert.assertEquals(appointmentSchedulerLinkedOrdersPopUpPage.getLinkedOrdersPopUpContentText(),
                Notifications.LINKED_ORDERS_NOTIFICATION_CHECK);
        softAssert.assertAll();
    }

    @And("Validates Linked Orders popup Cancel button on Appointment Scheduler Linked Orders PopUp Page")
    public void validateLinkedOrdersPopUpCancelButton() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerLinkedOrdersPopUpPage.isElementDisplay(appointmentSchedulerLinkedOrdersPopUpPage
                        .getLinkedOrdersPopUpCancelButton()),"Linked Orders Pop Up Cancel Button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Linked Orders popup Ok button on Appointment Scheduler Linked Orders PopUp Page")
    public void validateLinkedOrdersPopUpOkButton() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerLinkedOrdersPopUpPage.isElementDisplay(appointmentSchedulerLinkedOrdersPopUpPage
                        .getLinkedOrdersPopUpOkButton()),"Linked Orders Pop Up OK Button is not displayed");
        softAssert.assertAll();
    }

}
