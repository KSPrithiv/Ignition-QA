package steps.setupSystem;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupSystem.PermissionPage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j

public class PermissionPageSteps {
    PermissionPage permissionPage=new PermissionPage();

    WarehousePage warehousePage=new WarehousePage();

    @And("Click on Search field on Permission Page")
    public void searchPermission() {
        permissionPage.permissionTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
