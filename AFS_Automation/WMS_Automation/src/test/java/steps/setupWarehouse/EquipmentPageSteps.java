package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.EquipmentPage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j

public class EquipmentPageSteps {
    WarehousePage warehousePage=new WarehousePage();
    EquipmentPage equipmentPage=new EquipmentPage();

    @And("Click on Search field on Equipment Page")
    public void EquipmentSearchField(){
        log.info("click on Search field");
        equipmentPage.equipmentTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
