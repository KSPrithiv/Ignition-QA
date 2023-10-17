package steps.outbound.processing;

import common.constants.FilePaths;
import common.enums.Sources;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.outbound.OutboundOrderLoadsDTO;
import org.apache.commons.lang3.RandomStringUtils;
import ui.pages.outbound.processing.ChangeViewParametersPage;

import java.util.List;

@Slf4j
public class ChangeViewParametersPageSteps {
    ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

    @Step
    public void waitForChangeViewParametersPageToLoad() {
        log.info("Waiting for Change View Parameters Page To Load");
        changeViewParametersPage.waitChangeViewParametersPageToLoad();
    }

    @Step
    @When("User clicks Source option on Change View Parameters page")
    public void clickSource() {
        log.info("Clicking Source Option");
        changeViewParametersPage.clickSourceButton();
    }

    @Step
    @And("Selects Source Account on Change View Parameters page")
    public void selectSource() {
        log.info("Selecting Source " + Sources.ACCOUNT.getSource());
        changeViewParametersPage.selectAccount(Sources.ACCOUNT.getSource());
    }

    @Step
    @And("Enters Code {string} on Change View Parameters page")
    public void enterCode(String code) {
        log.info("Entering code " + code);
        changeViewParametersPage.enterCode(code);
    }

    @Step
    @And("Enters Code by index {int} on Change View Parameters page")
    public void enterCodeByIndex(int index) {
        List<String> codes = List.of(outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount1(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount2(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount3(),
                 outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount4(), outboundOrderLoadsDTO.getOutboundAccounts()
                .getOutboundAccount5(), outboundOrderLoadsDTO.getOutboundAccounts().getOutboundAccount6(), outboundOrderLoadsDTO
                .getOutboundAccounts().getOutboundAccount7());
        log.info("Entering code by index");
        changeViewParametersPage.enterCode(codes.get(index));
    }

    @Step
    @When("Enters Code that does not exist in DB on Change View Parameters page")
    public void enterRandomCode() {
        String code = RandomStringUtils.randomAlphabetic(6);
        log.info("Entering code " + code);
        changeViewParametersPage.enterCode(code);
    }

    @Step
    @And("Clears order on Change View Parameters page")
    public void clearOrder() {
        log.info("Clear order");
        changeViewParametersPage.clearOrder();
    }

    @Step
    @And("Enters order {string} on Change View Parameters page")
    public void enterOrder(String order) {
        log.info("Entering order " + order);
        changeViewParametersPage.typeOrder(order);
    }

    @Step
    @And("Enters order by index {int} on Change View Parameters page")
    public void enterOrderByIndex(int index) {
        log.info("Entering order by index");
        List<String> orders = List.of(outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder1(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder2(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder3(),
                 outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder4(), outboundOrderLoadsDTO.getOutboundOrders()
                .getOutboundOrder5(), outboundOrderLoadsDTO.getOutboundOrders().getOutboundOrder6(), outboundOrderLoadsDTO
                .getOutboundOrders().getOutboundOrder7());
        changeViewParametersPage.typeOrder(orders.get(index));
    }

    @Step
    @And("Selects Start Date {string} on Change View Parameters page")
    public void selectStartDate(String date) {
        log.info("Selecting Start Date " + date);
        changeViewParametersPage.selectStartDate(date);
    }

    @Step
    @And("Selects Start Date by index {int} on Change View Parameters page")
    public void selectStartDate(int index) {
        log.info("Selecting Start Date by index on Change View Parameters page");
        List<String> dates = List.of(outboundOrderLoadsDTO.getEndDates().getEndDate1(), outboundOrderLoadsDTO.getEndDates()
                .getEndDate2(), outboundOrderLoadsDTO.getEndDates().getEndDate3(), outboundOrderLoadsDTO.getEndDates()
                .getEndDate4(), outboundOrderLoadsDTO.getEndDates().getEndDate5(), outboundOrderLoadsDTO.getEndDates()
                .getEndDate6(), outboundOrderLoadsDTO.getEndDates().getEndDate7());
        changeViewParametersPage.selectStartDate(dates.get(index));
    }

    @Step
    @And("Clicks Ok on Change View Parameters page")
    public void clickOk() {
        log.info("Clicking OK button");
        changeViewParametersPage.clickOKbutton();
    }

    @Step
    @And("Clicks Cancel on Change View Parameters page")
    public void clickCancel() {
        log.info("Clicking Cancel button");
        changeViewParametersPage.clickCancelButton();
    }
}
