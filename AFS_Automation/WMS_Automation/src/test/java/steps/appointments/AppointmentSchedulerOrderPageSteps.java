package steps.appointments;

import common.constants.TimeFormats;
import common.enums.DeliveryType;
import common.utils.time.TimeConversion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import ui.pages.appointments.AppointmentSchedulerOrderPage;
import java.util.Calendar;

@Slf4j
public class AppointmentSchedulerOrderPageSteps {
    AppointmentSchedulerOrderPage appointmentSchedulerPage = new AppointmentSchedulerOrderPage();

    @Step
    @And("Waiting Appointment Scheduler Page To Load")
    public void waitForAppointmentSchedulerOrderPageToLoad() {
        log.info("Waiting Appointment Scheduler Page To Load");
        appointmentSchedulerPage.waitForAppointmentSchedulerPageToLoad();
    }

    @Step
    @When("User searches for valid order {string} for appointment on Appointment Scheduler page")
    public void searchValidOrderByOrderNumber(String order) {
        log.info("Searching for valid order number");
        appointmentSchedulerPage.addValidOrder(order);
    }

    @Step
    @When("User types order number {string} on Appointment Scheduler page")
    public void typeValidOrderNumber(CharSequence number) {
        log.info("Typing valid order number");
        appointmentSchedulerPage.typeOrderNumber(number);
    }

    @Step
    @And("User searches for Order {string} on Inbound Route with other orders on Appointment Scheduler page")
    public void searchForOrderOnInboundRouteWithOtherOrdersByOrderNumber(CharSequence number) {
        log.info("Searching for Order On Inbound Route With Other Orders By Order Number");
        appointmentSchedulerPage.addValidOrderThatOnInboundRouteWithOtherOrders(number);
    }

    @Step
    @And("User clears Alt1 Input on Appointment Scheduler page")
    public void clearAlt1Input() {
        log.info("Clearing Alt1 Input");
        appointmentSchedulerPage.clearAlt1InputBox();
    }

    @Step
    @And("User clears Alt2 Input on Appointment Scheduler page")
    public void clearAlt2Input() {
        log.info("Clearing Alt2 Input");
        appointmentSchedulerPage.clearAlt2InputBox();
    }

    @Step
    @When("Selects DOOR Delivery Type on Appointment Scheduler page")
    public void selectDeliveryType() {
        log.info("Selecting DOOR Delivery Type");
        appointmentSchedulerPage.selectDeliveryType(DeliveryType.DOOR.getDeliveryType());
    }

    @Step
    @And("User deletes order by row number {int} on Appointment Scheduler page")
    public void deleteOrderByRowNumber(int rowNumber) {
        log.info("Deleting order data");
        appointmentSchedulerPage.selectOrderByRowNumber(rowNumber);
        appointmentSchedulerPage.clickDeleteButton();
    }

    @Step
    @And("User selects delivery {string} on Appointment Scheduler page")
    public void selectDelivery(String delivery) {
        log.info("Selecting delivery");
        appointmentSchedulerPage.selectDeliveryType(delivery);
    }

    @Step
    @And("Click Cancel button on Appointment Scheduler page")
    public void clickCancel() {
        log.info("Clicking Cancel Button");
        appointmentSchedulerPage.clickCancelButton();
    }

    @Step
    @And("Click Next on Appointment Scheduler page")
    public void clickNext() {
        log.info("Clicking Next Button");
        appointmentSchedulerPage.clickNextButton();
    }

    @Step
    @And("Click Submit button on Appointment Scheduler page")
    public void clickSubmit() {
        log.info("Clicking Submit Button on Appointment Scheduler page");
        appointmentSchedulerPage.clickSubmitButton();
    }

    @Step
    @And("Types email {string} on Appointment Scheduler page")
    public void typeEmail(String email) {
        log.info("Typing email " + email);
        appointmentSchedulerPage.inputEmail(email);
    }

    @Step
    @And("Clears Alt1 field on Appointment Scheduler page")
    public void clearAlt1() {
        log.info("Clearing Alt1");
        appointmentSchedulerPage.clearAlt1();
    }

    @Step
    @And("Types {string} on Alt1 input on Appointment Scheduler page")
    public void inputAlt1Field(String alt) {
        log.info("Typing ALT1 field " + alt);
        appointmentSchedulerPage.inputAlt1(alt);
    }

    @Step
    @And("Types {string} on Alt2 input on Appointment Scheduler page")
    public void inputAlt2Field(String alt) {
        log.info("Typing ALT2 field " + alt);
        appointmentSchedulerPage.inputAlt2(alt);
    }

    @Step
    @And("User types Future Date in {int} days on Appointment Scheduler page")
    public void typesFutureDate(int days) {
        log.info("User types Future Date in " + days + " days");
        appointmentSchedulerPage.enterDate(TimeConversion.futureDate(days, Calendar.DATE, TimeConversion
                .getFormattedDateTime(TimeFormats.format_MMddyyyy), TimeFormats.format_MMddyyyy));
    }

}
