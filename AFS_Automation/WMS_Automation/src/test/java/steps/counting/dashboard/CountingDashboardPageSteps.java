package steps.counting.dashboard;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.counting.dashboard.CountingDashboardPage;

@Slf4j
public class CountingDashboardPageSteps {
    CountingDashboardPage countingDashboardPage = new CountingDashboardPage();

    @Step
    @And("Waits for Counting Dashboard page to load")
    public void waitForCountingDashboardPageToLoad() {
        log.info("Waiting for Counting Dashboard Page To Load");
        countingDashboardPage.waitCountingDashboardPageToLoad();
    }

    @Step
    @And("User selects warehouse {string} on Counting Dashboard page")
    public void selectWarehouse(String warehouse) {
        log.info("User selects warehouse on Counting Dashboard page");
        countingDashboardPage.selectWarehouse(warehouse);
    }

    @Step
    @And("User click Location tab on Counting Dashboard page")
    public void clickLocationTab() {
        log.info("User click Location tab on Counting Dashboard page");
        countingDashboardPage.clickLocationTab();
    }

    @Step
    @And("User click Product tab on Counting Dashboard page")
    public void clickProductTab() {
        log.info("User click Product tab on Counting Dashboard page");
        countingDashboardPage.clickProductTab();
    }
}
