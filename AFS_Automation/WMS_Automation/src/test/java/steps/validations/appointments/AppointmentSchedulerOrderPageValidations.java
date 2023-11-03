package steps.validations.appointments;

import common.constants.Notifications;
import io.cucumber.java.en.And;
import objects.orderdata.OrdersListDTO;
import org.testng.asserts.SoftAssert;
import ui.pages.appointments.AppointmentSchedulerOrderPage;

public class AppointmentSchedulerOrderPageValidations {
    AppointmentSchedulerOrderPage appointmentSchedulerPage = new AppointmentSchedulerOrderPage();

    @And("Appointment Scheduler page is displayed")
    public void validateAppointmentSchedulerPage() {
        appointmentSchedulerPage.waitForAppointmentSchedulerPageToLoad();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.isAppointmentSchedulerHeaderDisplayed(),
                  "Appointment Scheduler Header is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isAppointmentSchedulerOrderDisplayed(),
                    "Appointment Scheduler Order is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isOrderColumnDisplayed(),
                    "Order Column is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isAltOrderColumnDisplayed(),
                    "Alt Order Column is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isWarehouseColumnDisplayed(),
                    "Warehouse Column is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isSourceColumnDisplayed(),
                    "Source Column is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isOrderTypeColumnDisplayed(),
                    "Order Type Column is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isQtyColumnDisplayed(),
                    "Qty Column is not Displayed");
        softAssert.assertAll();
    }

    @And("Validates Delivery Type and Email on Appointment Scheduler Delivery page are displayed")
    public void validateDeliveryTypeAndEmailOnAppointmentSchedulerDeliveryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.isDeliveryTypeLabelDisplayed(),
                    "Delivery Type Label is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isDeliveryTypeDropDownDisplayed(),
                    "Delivery Type Drop Down is not Displayed");
        softAssert.assertTrue(!appointmentSchedulerPage.getDeliveryTypeDropDownText().isEmpty(),
                    "Delivery Type Drop Down is empty");
        softAssert.assertTrue(appointmentSchedulerPage.isEmailLabelDisplayed(),
                    "Email Label is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isEmailInputBoxDisplayed(),
                    "Email Input Box is not Displayed");
        softAssert.assertAll();
    }

    @And("Validates Alt1 and Alt2 on Appointment Scheduler Delivery page are displayed")
    public void validateAlt1AndAlt2OnAppointmentSchedulerDeliveryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.isAlt1LabelDisplayed(),
                    "Alt1 Label is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isAlt1InputBoxDisplayed(),
                    "Alt1 Input Box is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isAlt2LabelDisplayed(),
                    "Alt2 Label is not Displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isAlt2InputBoxDisplayed(),
                    "Alt2 Input Box is not Displayed");
        softAssert.assertAll();
    }

    @And("Validates Order Data on Appointment Scheduler page")
    public void validateOrderDataOnAppointmentSchedulerPage() {
        SoftAssert softAssert = new SoftAssert();
        OrdersListDTO ordersListDTO = appointmentSchedulerPage.getTableData(0);
        softAssert.assertTrue(!ordersListDTO.getOrderNumber().isEmpty());
        softAssert.assertTrue(ordersListDTO.getAltOrderNumber().isEmpty());
        softAssert.assertTrue(!ordersListDTO.getWarehouse().isEmpty());
        softAssert.assertTrue(!ordersListDTO.getSource().isEmpty());
        softAssert.assertTrue(!ordersListDTO.getOrderType().isEmpty());
        softAssert.assertTrue(!ordersListDTO.getQty().isEmpty());
        softAssert.assertAll();
    }

    @And("Validates Linked Order with index {int} on Appointment Scheduler page")
    public void validateLinkedOrdersDataOnAppointmentSchedulerPage(int index) {
        SoftAssert softAssert = new SoftAssert();
        OrdersListDTO ordersListDTO = appointmentSchedulerPage.getTableData(index);
        softAssert.assertTrue(!ordersListDTO.getOrderNumber().isEmpty(),"Order Number is empty");
        softAssert.assertTrue(!ordersListDTO.getWarehouse().isEmpty(),"Warehouse is empty");
        softAssert.assertTrue(!ordersListDTO.getSource().isEmpty(),"Source is empty");
        softAssert.assertTrue(!ordersListDTO.getOrderType().isEmpty(),"Order Type is empty");
        softAssert.assertTrue(!ordersListDTO.getQty().isEmpty(),"Qty is empty");
        softAssert.assertAll();
    }

    @And("Validates Next Button is active on Appointment Scheduler page")
    public void validateNextButtonIsActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.getNextButtonDisabilityResult() == null,
                "Next Button is not active");
        softAssert.assertAll();
    }

    @And("Validates Next Button is not active on Appointment Scheduler page")
    public void validateNextButtonIsNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.getNextButtonDisabilityResult().equals("true"),
                "Next Button is active");
        softAssert.assertAll();
    }

    @And("Validates Cancel Button is not active on Appointment Scheduler page")
    public void validateCancelButtonIsNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.getCancelButtonDisabilityResult().equals("true"),
                "Cancel Button is active");
        softAssert.assertAll();
    }

    @And("Validates Submit button is not active on Appointment Scheduler page")
    public void validateSubmitButtonIsNotActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.getSubmitButtonDisabilityResult().equals("true"),
                "Submit Button is active");
        softAssert.assertAll();
    }

    @And("Validates Submit button is active on Appointment Scheduler page")
    public void validateSubmitButtonIsActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(appointmentSchedulerPage.getSubmitButtonDisabilityResult(), null,
                "Submit Button is not active");
        softAssert.assertAll();
    }

    @And("Validates table rows number {int} on Appointment Scheduler page")
    public void validateTableRowsNumber(int rows) {
        appointmentSchedulerPage.waitForAppointmentSchedulerPageToLoad();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(appointmentSchedulerPage.getRowsCount(), rows,
                "Rows count " + rows + " in table is not correct");
        softAssert.assertAll();
    }

    @And("Validates Alt1 title on Appointment Scheduler page")
    public void validateWarning() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.isNotificationDisplayed(Notifications.ALT1_TITLE),
                "Notification " + Notifications.ALT1_TITLE + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Select Delivery Type Warning on Appointment Scheduler page")
    public void validateDeliveryTypeWarning() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.isNotificationDisplayed(Notifications.SELECT_DELIVERY_TYPE),
                "Notification " + Notifications.SELECT_DELIVERY_TYPE + " is not present");
        softAssert.assertAll();
    }

    @And("Validates Scheduler date and Scheduler time on Appointment Scheduler page")
    public void validateSchedulerDateAndTime() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.isDateSchedulerLabelDisplayed(), "Date Label is not displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isDateInputSchedulerDisplayed(), "Date Input is not displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isTimeSchedulerLabelDisplayed(), "Time Label is not displayed");
        softAssert.assertTrue(appointmentSchedulerPage.isTimeSchedulerInputDisplayed(), "Time Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Invalid Order Warning on Appointment Scheduler page")
    public void validateInvalidOrderText() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(appointmentSchedulerPage.isInvalidOrderLabelDisplayed(), "Invalid order is not present");
        softAssert.assertAll();
    }

}
