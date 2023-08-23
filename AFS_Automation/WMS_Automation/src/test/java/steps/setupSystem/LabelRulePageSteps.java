package steps.setupSystem;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupSystem.LabelRulePage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j
public class LabelRulePageSteps {
    LabelRulePage labelRulePage=new LabelRulePage();
    WarehousePage warehousePage=new WarehousePage();

    @And("Click on Search field on LabelRule Page")
    public void searchLabelRule() {
        labelRulePage.labelRuleTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
