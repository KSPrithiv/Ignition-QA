package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.DockDoorGroupPage;
import ui.pages.setupWarehouse.DockDoorPage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j
public class DockDoorGroupPageSteps {
    WarehousePage warehousePage=new WarehousePage();
    DockDoorGroupPage dockDoorGroupPage=new DockDoorGroupPage();

    @And("Click on Search field on DockDoorGroup Page")
    public void DockDoorGroupSearchField(){
        log.info("click on Search field");
        dockDoorGroupPage.dockDoorGroupTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
