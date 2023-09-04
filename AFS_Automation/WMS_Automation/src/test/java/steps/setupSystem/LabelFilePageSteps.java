package steps.setupSystem;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupSystem.LabelFilePage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j
public class LabelFilePageSteps {
    LabelFilePage labelFilePage=new LabelFilePage();
    WarehousePage warehousePage=new WarehousePage();

    @And("Click on Search field on LabelFile Page")
    public void searchLabelFile() {
        labelFilePage.labelFileTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
