package steps.setupWarehouse;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setupConfiguration.*;
import ui.pages.setupWarehouse.LocationPage;

@Slf4j
public class LocationPageSteps {
    AssignmentTypePage assignmentTypePage=new AssignmentTypePage();
    LocationPage locationPage=new LocationPage();

    @And("Click on Search field on Location Page")
    public void clickLocationSearchField() throws InterruptedException {
        locationPage.locationTab();
        locationPage.locationSearchIcon();
        assignmentTypePage.searchBoxActionAssignmentType();
    }
}
