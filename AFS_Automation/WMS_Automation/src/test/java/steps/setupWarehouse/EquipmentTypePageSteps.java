package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.EquipmentTypePage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j

public class EquipmentTypePageSteps {
    WarehousePage warehousePage=new WarehousePage();
    EquipmentTypePage equipmentTypePage=new EquipmentTypePage();

    @And("Click on Search field on Equipment Type Page")
    public void EquipmentTypeSearchField(){
        log.info("click on Search field");
        equipmentTypePage.equipmentTypeTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
