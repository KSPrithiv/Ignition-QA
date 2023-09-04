package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.EquipmentChecklistPage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j

public class EquipmentChecklistPageSteps {
    WarehousePage warehousePage=new WarehousePage();
    EquipmentChecklistPage equipmentChecklistPage=new EquipmentChecklistPage();

    @And("Click on Search field on Equipment Checklist Page")
    public void EquipmentChecklistSearchField(){
        log.info("click on Search field");
        equipmentChecklistPage.equipmentChecklistTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
