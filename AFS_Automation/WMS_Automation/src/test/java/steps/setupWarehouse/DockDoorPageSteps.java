package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.DockDoorPage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j
public class DockDoorPageSteps {
    WarehousePage warehousePage=new WarehousePage();
    DockDoorPage dockDoorPage=new DockDoorPage();

    @And("Click on Search field on DockDoor Page")
    public void DockDoorSearchField(){
        log.info("click on Search field");
        dockDoorPage.dockDoorTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
