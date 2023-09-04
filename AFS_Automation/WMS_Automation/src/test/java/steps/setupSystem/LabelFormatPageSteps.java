package steps.setupSystem;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupSystem.LabelFormatPage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j

public class LabelFormatPageSteps {
    LabelFormatPage labelFormatPage=new LabelFormatPage();
    WarehousePage warehousePage=new WarehousePage();

    @And("Click on Search field on LabelFormat Page")
    public void searchLabelFormat() {
        labelFormatPage.labelFormatTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
