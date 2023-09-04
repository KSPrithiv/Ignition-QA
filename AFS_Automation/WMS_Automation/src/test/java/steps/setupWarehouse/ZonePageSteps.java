package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupWarehouse.WarehousePage;
import ui.pages.setupWarehouse.Zonepage;

@Slf4j
public class ZonePageSteps {
    WarehousePage warehousePage=new WarehousePage();
    Zonepage zonepage=new Zonepage();

    @And("Click on Search field on Zone Page")
    public void clickZoneSearchField() throws InterruptedException {
        log.info("click on Search field");
        zonepage.zoneTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
