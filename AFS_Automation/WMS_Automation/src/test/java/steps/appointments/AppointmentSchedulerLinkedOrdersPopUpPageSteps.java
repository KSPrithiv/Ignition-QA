package steps.appointments;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.appointments.AppointmentSchedulerLinkedOrdersPopUpPage;

@Slf4j
public class AppointmentSchedulerLinkedOrdersPopUpPageSteps {
    AppointmentSchedulerLinkedOrdersPopUpPage appointmentSchedulerLinkedOrdersPopUpPage = new AppointmentSchedulerLinkedOrdersPopUpPage();

    @Step
    @And("Waits for Appointment Scheduler Linked Orders PopUp Page to load")
    public void waitAppointmentSchedulerLinkedOrdersPopUpToLoad() {
        log.info("Waiting Appointment Scheduler Linked Orders Pop Up Page To Load ");
        appointmentSchedulerLinkedOrdersPopUpPage.waitForAppointmentSchedulerLinkedOrdersPopUpPageToLoad();
    }

    @Step
    @And("Click Cancel Button on Appointment Scheduler page")
    public void clickOnCancelButton() {
        log.info("Clicking Cancel Button on Appointment Scheduler page");
        appointmentSchedulerLinkedOrdersPopUpPage.clickLinkedOrdersPopUpCancelButton();
    }

    @Step
    @And("Click Ok button on Linked Orders popup on Appointment Scheduler page")
    public void clickOnOkButton() {
        log.info("Clicking Ok Button");
        appointmentSchedulerLinkedOrdersPopUpPage.clickLinkedOrdersPopUpOkButton();
    }

}
