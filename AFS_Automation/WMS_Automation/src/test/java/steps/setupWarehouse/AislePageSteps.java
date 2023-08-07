package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.AislePage;
import ui.pages.setupWarehouse.AisleTypePage;
import ui.pages.setupWarehouse.WarehousePage;


@Slf4j

public class AislePageSteps {
    WarehousePage warehousePage=new WarehousePage();
    AislePage aislePage=new AislePage();

    @And("Click on Search field on Aisle Page")
    public void clickAisleSearchField() throws InterruptedException {
        log.info("click on Search field");
        aislePage.aisleTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
