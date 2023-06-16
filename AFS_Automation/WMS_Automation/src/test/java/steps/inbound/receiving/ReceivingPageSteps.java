package steps.inbound.receiving;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.inbound.receiving.ReceivingPage;

@Slf4j
public class ReceivingPageSteps {
    ReceivingPage receivingPage = new ReceivingPage();

    @Step
    @Then("Receiving page loads")
    public void waitReceivingPageToLoad() {
        log.info("Go to Receiving page");
        receivingPage.waitReceivingPageToLoad();
    }

    @Step
    @When("User clicks Back button on Receiving page")
    public void clickBack() {
        log.info("Clicking Back button");
        receivingPage.clickBackButton();
    }

    @Step
    @And("User clicks Next button on Receiving page")
    public void clickNext() {
        log.info("Clicking Next button");
        receivingPage.clickNextButton();
    }

    @Step
    @And("User clicks Review button on Receiving page")
    public void clickReview() {
        log.info("Clicking Review button");
        receivingPage.clickReviewButton();
    }

    @Step
    @And("User clicks Cancel button on Receiving page")
    public void clickCancel() {
        log.info("Clicking Cancel button");
        receivingPage.clickCancelButton();
    }

    @Step
    @And("User clicks Receive button on Receiving page")
    public void clickReceive() {
        log.info("Clicking Receive button");
        receivingPage.clickReceiveButton();
    }

    @Step
    @And("User selects warehouse {string} on Receiving page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse {string} on Receiving page");
        receivingPage.selectWarehouse(warehouse);
    }

    @Step
    @And("Types {string} product on Receiving page")
    public void typeProduct(String product) {
        log.info("Typing product " + product);
        receivingPage.enterProduct(product);
    }

    @Step
    @And("Types {string} LPN on Receiving page")
    public void typeLPN(String lpn) {
        log.info("Typing LPN " + lpn);
        receivingPage.enterLPN(lpn);
    }

    @Step
    @And("Clears LPN on Receiving page")
    public void clearLPN() {
        log.info("Clears LPN on Receiving page");
        receivingPage.clearLPN();
    }

    @Step
    @And("Clears Product on Receiving page")
    public void clearProduct() {
        log.info("Clears Product on Receiving page");
        receivingPage.clearProduct();
    }

    @Step
    @And("Types {string} load on Receiving page")
    public void typeLoad(String load) {
        log.info("Typing load " + load);
        receivingPage.enterLoad(load);
    }

    @Step
    @And("Selects {string} dock door on Receiving page")
    public void typeDockDoor(String door) {
        log.info("Select dock door " + door);
        receivingPage.selectDockDoor(door);
    }

    @Step
    @And("Types {string} Location on Receiving page")
    public void typeLocation(String location) {
        log.info("Type location " + location);
        receivingPage.enterLocation(location);
    }

    @Step
    @And("Types {string} Qty on Receiving page")
    public void typeQty(String qty) {
        log.info("Type qty " + qty);
        receivingPage.enterQty(qty);
    }

    @Step
    @And("Types {string} Lot on Receiving page")
    public void typeLot(String lot) {
        log.info("Type lot " + lot);
        receivingPage.enterLot(lot);
    }

    @Step
    @And("Types {string} Expiration date on Receiving page")
    public void typeExpDate(String date) {
        log.info("Type Expiration date " + date);
        receivingPage.enterExpDate(date);
    }

    @Step
    @Then("Selects {int} load on Select load popup on Receiving page")
    public void selectLoad(int index) {
        log.info("Select load with index " + index);
        receivingPage.checkLoad(index);
    }

    @Step
    @And("Checks {int} pallet on Staging page")
    public void checkPallet(int index) {
        log.info("Checking pallet " + index);
        receivingPage.checkPalletByIndex(index);
    }

    @Step
    @And("Checks input for all pallets on Staging page")
    public void checkAllPallets() {
        log.info("Checking all pallet");
        receivingPage.checkAllPallets();
    }

    @Step
    @And("User clicks Delete button on Staging page")
    public void clickDelete() {
        log.info("Clicking Delete button");
        receivingPage.clickDeleteButton();
    }

    @Step
    @And("Clicks No button on Warning on Receiving page")
    public void clickNo() {
        log.info("Clicking No button");
        receivingPage.clickNoButton();
    }

    @Step
    @And("Clicks Ok button on Warning on Receiving page")
    public void clickOkButton() {
        log.info("Clicking Ok button");
        receivingPage.clickOkButton();
    }

}
