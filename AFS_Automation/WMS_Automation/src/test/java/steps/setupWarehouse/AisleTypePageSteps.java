package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.AisleTypePage;
import ui.pages.setupWarehouse.WarehousePage;


@Slf4j
public class AisleTypePageSteps {
    WarehousePage warehousePage=new WarehousePage();
    AisleTypePage aisleTypePage=new AisleTypePage();

    @And("Click on Search field on AisleType Page")
    public void clickAisleTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        aisleTypePage.aisleTypeTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
