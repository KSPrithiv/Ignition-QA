package steps.inbound.loads;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.inbound.InboundOrderLoadsDTO;
import objects.productdata.ProductData;
import ui.pages.inbound.loads.InboundLoadOrderDetailsPage;

import java.util.List;

@Slf4j
public class InboundLoadOrderDetailsPageSteps {
    InboundLoadOrderDetailsPage inboundLoadOrderDetailsPage = new InboundLoadOrderDetailsPage();
    InboundOrderLoadsDTO inboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.INBOUND_ORDER_LOAD_DATA, InboundOrderLoadsDTO.class);

    @Step
    @And("Waits For Inbound Load Order details page to load")
    public void waitForInboundLoadOrderDetailsPageToLoad() {
        log.info("Waiting for Inbound Load Order Details Page To Load");
        inboundLoadOrderDetailsPage.waitForInboundLoadOrderDetailsPageToLoad();
    }

    @Step
    @And("Getting Product Details on Inbound Load Summary page")
    public List<ProductData> getProductDetails() {
        log.info("Getting Product Details on Inbound Load Summary page");
        return inboundLoadOrderDetailsPage.getProductDetails();
    }

    @Step
    @And("Clicks Images button on Inbound Load Order Summary page")
    public void clickImagesButton() {
        log.info("Clicks Images button on Inbound Load Summary page");
        inboundLoadOrderDetailsPage.clickImagesButton();
    }

    @Step
    @When("User applies order {string} option on Inbound Load Order Summary page")
    public void applyOrderOptionForOrder(String option) {
        log.info("Applying Order option " + option + " for order ");
        inboundLoadOrderDetailsPage.selectOrderOption(option);
    }

    @Step
    @And("Types Ship Date {string} to move Order to Load on Inbound Load Order Summary page")
    public void typeShipDateForMoveOrderToLoad(String date) {
        log.info("Type Ship Date " + date);
        inboundLoadOrderDetailsPage.typeShipDate(date);
    }

    @Step
    @And("Types Ship Date by index {int} to move Order to Load on Inbound Load Order Summary page")
    public void typeShipDateByIndexForMoveOrderToLoad(int index) {
        log.info("Type Ship Date by index" );
        List<String> dates = List.of(inboundOrderLoadsDTO.getStartDates().getStartDate1(), inboundOrderLoadsDTO
                .getStartDates().getStartDate2(), inboundOrderLoadsDTO.getStartDates().getStartDate3(), inboundOrderLoadsDTO
                .getStartDates().getStartDate4(), inboundOrderLoadsDTO.getStartDates().getStartDate5(), inboundOrderLoadsDTO
                .getStartDates().getStartDate6());
        inboundLoadOrderDetailsPage.typeShipDate(dates.get(index));
    }

    @Step
    @And("Select Order Product with index {int} on Inbound Load Order Summary page")
    public void selectLoadOrderByLoadNumber(int num) {
        log.info("Select Order Product by number " + num);
        inboundLoadOrderDetailsPage.clickOrderProductByNumber(num);
    }

    @Step
    @And("Types Load {string} to move Order to Load on Inbound Load Order Summary page")
    public void typeLoadForMoveOrderToLoad(String load) {
        log.info("Type Load " + load);
        inboundLoadOrderDetailsPage.typeLoad(load);
    }

    @Step
    @And("Types Load by index {int} to move Order to Load on Inbound Load Order Summary page")
    public void typeLoadBIndexForMoveOrderToLoad(int index) {
        log.info("Type Load by index");
        List<String> loads = List.of(inboundOrderLoadsDTO.getLoadNames().getLoadName1(), inboundOrderLoadsDTO.getLoadNames()
                .getLoadName2(), inboundOrderLoadsDTO.getLoadNames().getLoadName3(), inboundOrderLoadsDTO.getLoadNames()
                .getLoadName4(), inboundOrderLoadsDTO.getLoadNames().getLoadName5(), inboundOrderLoadsDTO.getLoadNames().getLoadName6());
        inboundLoadOrderDetailsPage.typeLoad(loads.get(index));
    }

    @Step
    @And("Clicks back to Inbound Load Order Summary page")
    public void clickBack() {
        log.info("Clicking Back");
        inboundLoadOrderDetailsPage.clickBackButton();
    }

    @Step
    @And("Clicks Save on Inbound Load Order Summary page")
    public void clickSave() {
        log.info("Clicking Save");
        inboundLoadOrderDetailsPage.clickSaveButton();
    }

    @Step
    @And("Clicks No button on Inbound Load Order Summary page")
    public void clickNo() {
        log.info("Clicking No");
        inboundLoadOrderDetailsPage.clickNoButton();
    }

    @Step
    @And("Clicks Ok button on Inbound Load Order Summary page")
    public void clickOk() {
        log.info("Clicking Ok");
        inboundLoadOrderDetailsPage.clickOkButton();
    }

    @Step
    @And("Clicks change status option on Inbound Load Order Summary page")
    public void clickChangeStatusOption() {
        log.info("Clicking Change Status option");
        inboundLoadOrderDetailsPage.clickChangeStatusOption();
    }

    @Step
    @And("Clicks door option on Inbound Load Order Summary page")
    public void clickDoorOption() {
        log.info("Clicking Door option");
        inboundLoadOrderDetailsPage.clickDoorOption();
    }

    @Step
    @And("Clicks data option on Inbound Load Order Summary page")
    public void clickDataOption() {
        log.info("Clicking Data option");
        inboundLoadOrderDetailsPage.clickDataOption();
    }

    @Step
    @And("Clicks Cancel button on Inbound Load Order Summary page")
    public void clickCancel() {
        log.info("Clicking Cancel");
        inboundLoadOrderDetailsPage.clickCancel();
    }

    @Step
    @And("Clicks door on Assign doors popup on Inbound Load Order Summary page")
    public void clickDoor() {
        log.info("Clicking Door");
        inboundLoadOrderDetailsPage.clickDoorDropdown();
    }

    @Step
    @And("Clicks Cancel on Order Data on Inbound Load Order Summary page")
    public void clickCancelBtn() {
        log.info("Clicking BtnAddProductCancel");
        inboundLoadOrderDetailsPage.clickBtnAddProductCancel();
    }

    @Step
    @Then("Clicks door {string} on Inbound Load Order Summary page")
    public void clickDoor(String door) {
        log.info("Clicking Door  " + door);
        inboundLoadOrderDetailsPage.selectOption(door);
    }

}
