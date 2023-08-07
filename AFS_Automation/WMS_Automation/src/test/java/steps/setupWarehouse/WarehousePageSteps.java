package steps.setupWarehouse;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupLabor.SetupLaborCodePage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j

public class WarehousePageSteps {
    WebDriver driver;
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);
    WarehousePage warehousePage=new WarehousePage();

    @And("Go to SetupIcon and Warehouse")
    public void setupIconAndWarehouse() throws InterruptedException {
        log.info("Go to SetupIcon and Warehouse");
        setupLaborCodePage.clickSetupIcon();
        warehousePage.clickSetupWarehouse();
    }
    @And("Click on Search field on Warehouse Page")
    public void clickWarehouseSearchField() throws InterruptedException {
        log.info("click on Search field");
        warehousePage.warehouseTab();
        warehousePage.searchBoxActionWarehouse();
    }
    @Step
    @And("Verify Search functionalities2")
    public void verifyWarehouseSearchFunctionality() throws InterruptedException {
        log.info("Verify Search Functionality");
        warehousePage.rownumber1();
    }
    @Step
    @And("Verify remove icon2")
    public void closeIcononAssignmentType() throws InterruptedException {
        log.info("Verify remove Icon");
        setupLaborCodePage.closeIcon();
    }
    @Step
    @And("Verify Search functionality with non existing search keyword2")
    public void nonExistingKeywordonWarehouse() throws InterruptedException {
        log.info("Verify Search functionality with non existing search keyword");
        setupLaborCodePage.verifyTablerows();
        warehousePage.searchBoxAction6();
    }
}
