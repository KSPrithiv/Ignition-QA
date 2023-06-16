package steps.appointments;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.appointments.AppointmentScheduledPopUpPage;

@Slf4j
public class AppointmentScheduledPopUpPageSteps {
    AppointmentScheduledPopUpPage appointmentScheduledPopUpPage = new AppointmentScheduledPopUpPage();

    @Step
    @And("Waits for Appointment Scheduled PopUp Page to load")
    public void waitForAppointmentScheduledPopUpPageToLoad() {
        log.info("Waiting Appointment Scheduled Pop Up Page To Load");
        appointmentScheduledPopUpPage.waitForAppointmentScheduledPopUpPageToLoad();
    }

    @Step
    @And("Click Ok button on Appointment Scheduled PopUp Page")
    public void clickOnOkButton() {
        log.info("Clicking Ok Button");
        appointmentScheduledPopUpPage.clickAppointmentScheduledPopUpOkButton();
    }
}
