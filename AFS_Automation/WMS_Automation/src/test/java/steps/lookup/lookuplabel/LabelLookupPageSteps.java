package steps.lookup.lookuplabel;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.lookupproductslocationsdata.LookupProductLocationsDTO;
import ui.pages.lookup.lookuplabel.LabelLookupPage;

@Slf4j
public class LabelLookupPageSteps {
    LabelLookupPage labelLookupPage = new LabelLookupPage();
    LookupProductLocationsDTO lookupDataDTO = new ObjectMapperWrapper().getObject(FilePaths.LOOKUP_DATA, LookupProductLocationsDTO.class);

    @Step
    @And("Waits for Label Lookup page to load")
    public void waitForLabelLookupPageToLoad() {
        log.info("Waiting for Label Lookup page to load");
        labelLookupPage.waitForLabelLookupPageToLoad();
    }

    @Step
    @And("User clicks Shipping label on Lookup Label page")
    public void typeShippingLabel() {
        log.info("User clicks Shipping label on Lookup Label page");
        labelLookupPage.clickShippingLabel();
    }

    @Step
    @And("User clicks Unit label on Lookup Label page")
    public void clickUnitLabel() {
        log.info("User clicks Unit label on Lookup Label page");
        labelLookupPage.clickUnitLabel();
    }

    @Step
    @And("User clicks Pallet label on Lookup Label page")
    public void clickPalletLabel() {
        log.info("User clicks Pallet label on Lookup Label page");
        labelLookupPage.clickPalletLabel();
    }

    @Step
    @And("User clicks Location label on Lookup Label page")
    public void clickLocationLabel() {
        log.info("User clicks Location label on Lookup Label page");
        labelLookupPage.clickLocationLabel();
    }

    @Step
    @And("User clicks Receiving Unit label on Lookup Label page")
    public void clickReceivingUnitLabel() {
        log.info("User clicks Receiving Unit label on Lookup Label page");
        labelLookupPage.clickReceivingUnitLabel();
    }

    @Step
    @And("User clicks Product label on Lookup Label page")
    public void clickProductLabel() {
        log.info("User clicks Product label on Lookup Label page");
        labelLookupPage.clickProductLabel();
    }

    @Step
    @And("User clicks Picking label on Lookup Label page")
    public void clickPickingLabel() {
        log.info("User clicks Picking label on Lookup Label page");
        labelLookupPage.clickPickingLabel();
    }

    @Step
    @And("User clicks Outbound Report label on Lookup Label page")
    public void clickOutboundReportLabel() {
        log.info("User clicks Outbound Report label on Lookup Label page");
        labelLookupPage.clickOutboundReportLabel();
    }

    @Step
    @And("User clicks Print Label Cancel button on Lookup Label page")
    public void clickPrintLabelCancelBtn() {
        log.info("User clicks Print Label Cancel button on Lookup Label page");
        labelLookupPage.clickPrintLabelCancelBtn();
    }

    @Step
    @And("User clicks Print Label Print button on Lookup Label page")
    public void clickPrintLabelPrintBtn() {
        log.info("User clicks Print Label Print button on Lookup Label page");
        labelLookupPage.clickPrintLabelPrintBtn();
    }

    @Step
    @And("User clicks From Location button on Lookup Label page")
    public void clickFromLocationBtn() {
        log.info("User clicks From Location button on Lookup Label page");
        labelLookupPage.clickFromLocationBtn();
    }

    @Step
    @And("User clicks To Location button on Lookup Label page")
    public void clickToLocationBtn() {
        log.info("User clicks To Location button on Lookup Label page");
        labelLookupPage.clickToLocationBtn();
    }

    @Step
    @And("User Cancel button on Lookup Label page")
    public void clickCancelButton() {
        log.info("User Cancel button on Lookup Label page");
        labelLookupPage.clickCancelButton();
    }
}
