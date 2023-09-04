package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupWarehouse.LocationTypePage;
import ui.pages.setupWarehouse.WarehousePage;


@Slf4j

public class LocationTypePageSteps {
    WarehousePage warehousePage=new WarehousePage();
    LocationTypePage locationTypePage=new LocationTypePage();

    @And("Click on Search field on Location Type Page")
    public void clickLocationTypeSearchField() throws InterruptedException {
        log.info("click on Search field");
        locationTypePage.locationTypeTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
