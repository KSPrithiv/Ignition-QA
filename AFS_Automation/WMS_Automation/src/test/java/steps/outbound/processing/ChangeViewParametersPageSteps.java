package steps.outbound.processing;

import common.constants.FilePaths;
import common.enums.Sources;
import common.utils.database.DataBaseConnection;
import common.utils.database.SqlQueriesUtils;
import common.utils.database.StoreProceduresUtils;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import objects.orderdata.ProcessingOrderDTO;
import objects.storeproceduresdata.outbound.ProcessingParams;
import objects.userdata.DataBaseData;
import org.apache.commons.lang3.RandomStringUtils;
import steps.LoginPageSteps;
import ui.pages.outbound.processing.ChangeViewParametersPage;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ChangeViewParametersPageSteps {
    ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
    StoreProceduresUtils storeProceduresUtils = new StoreProceduresUtils();
    SqlQueriesUtils sqlQueriesUtils = new SqlQueriesUtils();

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
    @And("Selects Start Date {string} on Change View Parameters page")
    public void selectStartDate(String date) {
        log.info("Selecting Start Date " + date);
        changeViewParametersPage.selectStartDate(date);
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
