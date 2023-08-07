package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.DockDoorPage;
import ui.pages.setupWarehouse.WarehousePage;
import ui.pages.setupWarehouse.YardPage;

@Slf4j

public class YardPageSteps {

    WarehousePage warehousePage=new WarehousePage();
    YardPage yardPage=new YardPage();
    @And("Click on Search field on yard Page")
    public void YardSearchField(){
        log.info("click on Search field");
        warehousePage.searchBoxActionWarehouse();
        yardPage.yardTab();
    }
}
