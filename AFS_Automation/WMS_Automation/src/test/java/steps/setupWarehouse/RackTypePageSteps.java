package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.RackTypePage;
import ui.pages.setupWarehouse.WarehousePage;


@Slf4j
public class RackTypePageSteps {
    WarehousePage warehousePage=new WarehousePage();
    RackTypePage rackTypePage=new RackTypePage();

    @And("Click on Search field on RackType Page")
    public void clickRackTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        rackTypePage.rackTypeTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
