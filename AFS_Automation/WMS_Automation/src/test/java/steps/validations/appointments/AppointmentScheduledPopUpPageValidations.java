package steps.validations.appointments;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.appointments.AppointmentScheduledPopUpPage;

public class AppointmentScheduledPopUpPageValidations {
    AppointmentScheduledPopUpPage appointmentScheduledPopUpPage = new AppointmentScheduledPopUpPage();

    @And("Validates Appointment Scheduled popup page is displayed")
    public void validateAppointmentScheduledPopUpPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentScheduledPopUpPage.isAppointmentScheduledPopUpTitleDisplayed(),
                    "Appointment Scheduled Pop Up Title is not Displayed");
        softAssert.assertTrue(appointmentScheduledPopUpPage.isAppointmentScheduledContentDisplayed(),
                    "Appointment Scheduled Content is not Displayed");
        softAssert.assertTrue(appointmentScheduledPopUpPage.isAppointmentScheduledOkButtonDisplayed(),
                    "Appointment Scheduled Ok Button is not Displayed");
        softAssert.assertAll();
    }
}
