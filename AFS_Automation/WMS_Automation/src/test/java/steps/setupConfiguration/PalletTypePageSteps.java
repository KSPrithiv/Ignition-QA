package steps.setupConfiguration;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupConfiguration.*;
import ui.pages.setupLabor.JobTypePage;
import ui.pages.setupLabor.SetupLaborCodePage;

@Slf4j

public class PalletTypePageSteps {
    WebDriver driver;
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    PalletTypePage palletTypePage=new PalletTypePage();
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);
    JobTypePage jobTypePage=new JobTypePage(driver);



    @And("Click on Search field on Pallet Type Page")
    public void clickPalletTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        palletTypePage.palletTypeTab();
        assignmentTypePage.searchBoxActionAssignmentType();
    }

    @And("Creating Pallet with special characters and save")
    public void createPalletType() {
        setupLaborCodePage.enterCode();
        palletTypePage.enterDescription();
        palletTypePage.save();
    }
    @And("Creating Pallet with duplicate code")
    public void createDuplicatePalletType() {
        setupLaborCodePage.enterCode();
        palletTypePage.enterDescription();
        palletTypePage.save();
    }
    @And("Verify duplicate code message")
    public void verifyMessage() {
        log.info("Verify duplicate code message");
        palletTypePage.message();
        jobTypePage.clickCancel();
    }
    @And("Go to Pallet Type Tab")
    public void goToPalletTypeTab() throws InterruptedException {
        log.info("Go to Pallet Type Tab");
        palletTypePage.palletTypeTab();
//        assignmentTypePage.searchBoxActionAssignmentType();
    }
    @And("Select Code and click on Delete")
    public void deleteLastRow() {
        log.info("Select Code and click on Delete");
        palletTypePage.clicklastRow();
        jobTypePage.clickDelete();
        jobTypePage.displayMessage();
        jobTypePage.clickCancel();
        palletTypePage.clicklastRow();
        jobTypePage.clickDelete();
        jobTypePage.deleteOK();
    }
    @And("Verify empty code message")
    public void verifyEmptyCodeMessage(){
        log.info("Verify empty code message");
        palletTypePage.enterDescription();
        palletTypePage.save();
        palletTypePage.message();
        jobTypePage.clickCancel();
    }
    @And("Verify empty description message")
    public void verifyEmptyDescriptionMessage() {
        log.info("Verify empty description message");
        setupLaborCodePage.enterCode();
        palletTypePage.save();
        palletTypePage.message();
    }

    @And("User clicks Code filter on Pallet page")
    public void clickCodeFilter()  {
        log.info("User clicks Code filter on JobType page");
        setupLaborCodePage.countCodeFilter();
        palletTypePage.clickCodeFilter();
    }
    @And("User clicks Description filter On Pallet Page")
    public void clickDescriptionFilter() throws InterruptedException {
        log.info("User clicks Code filter on JobType page");
        palletTypePage.countDescription();
        setupLaborCodePage.clickAddFilterButton();
        setupLaborCodePage.clickDescriptionFilter();
    }
    @And("User clicks Move inventory filter on Pallet page")
    public void clickMoveInventoryFilter()  {
        log.info("User clicks Move inventory filter on Pallet page");
        palletTypePage.countMoveInventory();
        setupLaborCodePage.clickAddFilterButton();
        palletTypePage.clickMoveInventoryFilter();

    }
    @And("User enter Move inventory and click on Apply button")
    public void enterMoveInventory()  {
        log.info("User clicks Move inventory filter on Pallet page");
        palletTypePage.clickMoveInventory();
        palletTypePage.verifyMoveInventoryFilter();

    }

}
