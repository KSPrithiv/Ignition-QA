package steps.setupSystem;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupSystem.PurgePage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j

public class PurgePageSteps {
    PurgePage purgePage=new PurgePage();
    WarehousePage warehousePage=new WarehousePage();

    @And("Click on Search field on Purge Page")
    public void searchPurge() {
        purgePage.purgeTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
