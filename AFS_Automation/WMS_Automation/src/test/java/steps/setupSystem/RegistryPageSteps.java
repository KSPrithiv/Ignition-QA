package steps.setupSystem;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupSystem.RegistryPage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j

public class RegistryPageSteps {
    RegistryPage registryPage=new RegistryPage();
    WarehousePage warehousePage=new WarehousePage();

    @And("Click on Search field on Registry Page")
    public void searchRegistry() {
        registryPage.registryTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
