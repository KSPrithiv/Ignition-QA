package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.DockManagementSummaryPage;

@Slf4j
public class DockManagementSummaryPageSteps {
    DockManagementSummaryPage dockManagementSummaryPage = new DockManagementSummaryPage();

    @Step
    @And("User refreshes page")
    public void refreshPage() {
        log.info("User refreshes page");
        dockManagementSummaryPage.refreshPage();
    }

    @Step
    @Then("Go to Appointment scheduler page")
    public void goToAppointmentSchedulerPage() {
        log.info("Go to Appointment scheduler page");
        dockManagementSummaryPage.clickAppointmentIcon();
    }

    @Step
    @Then("Go to Dashboard page")
    public void goToDashboardPage() {
        log.info("Go to Dashboard page");
        dockManagementSummaryPage.clickDashboardIcon();
    }

    @Step
    @Then("Go to Loads page")
    public void goToLoadsPage() {
        log.info("Go to Loads page");
        dockManagementSummaryPage.clickInboundIcon();
        dockManagementSummaryPage.clickLoadsIcon();
    }

    @Step
    @Then("Go to Inbound Orders page")
    public void goToInboundOrdersPage() {
        log.info("Go to Inbound Orders page");
        dockManagementSummaryPage.clickInboundIcon();
        dockManagementSummaryPage.clickInboundOrdersIcon();
    }

    @Step
    @Then("Go to Inbound Receiving page")
    public void goToInboundReceivingPage() {
        log.info("Go to Inbound Receiving page");
        dockManagementSummaryPage.clickInboundIcon();
        dockManagementSummaryPage.clickReceivingIcon();
    }

    @Step
    @When("Go to Outbound Order page")
    public void goToOutboundOrderPage() {
        log.info("Go to Outbound Order page");
        dockManagementSummaryPage.clickOutboundIcon();
        dockManagementSummaryPage.clickOutboundOrdersIcon();
    }

    @Step
    @When("Go to Outbound Route page")
    public void goToOutboundRoutePage() {
        log.info("Go to Outbound Route page");
        dockManagementSummaryPage.clickOutboundIcon();
        dockManagementSummaryPage.clickRoutesIcon();
    }

    @Step
    @When("Go to Outbound Processing page")
    public void goToOutboundProcessingPage() {
        log.info("Go to Outbound Processing page");
        dockManagementSummaryPage.clickOutboundIcon();
        dockManagementSummaryPage.clickProcessingIcon();
    }

    @Step
    @When("Go to Outbound Load Planning page")
    public void goToOutboundLoadPlanningPage() {
        log.info("Go to Outbound Load Planning page");
        dockManagementSummaryPage.clickOutboundIcon();
        dockManagementSummaryPage.clickLoadPlanningIcon();
    }

    @Step
    @And("Go to Security Permissions page")
    public void goToSecurityPermissionsPage() {
        log.info("Go to Security Permissions page");
        dockManagementSummaryPage.clickSecurityIcon();
        dockManagementSummaryPage.clickPermissionsIcon();
    }

    @Step
    @When("Main page is loaded")
    public void goToDockManagementSummaryPage() {
        log.info("Go to Dock Management Summary Page");
        dockManagementSummaryPage.clickApplicationIconContainer();
    }

    @Step
    @And("User waits for Main page to load")
    public void waitForMainPageToLoad() {
        log.info("Waiting for Dock Management Summary Page To Load");
        dockManagementSummaryPage.waitForDockManagementSummaryPageToLoad();
    }

    @Step
    @And("User clicks user profile icon on Dashboard page")
    public void clickUserProfileIcon() {
        log.info("User clicks user profile icon on Dashboard page");
        dockManagementSummaryPage.clickUserProfileIcon();
    }

    @Step
    @And("Clicks user profile logout icon on Dashboard page")
    public void clickUserProfileLogoutIcon() {
        log.info("Clicks user profile logout icon on Dashboard page");
        dockManagementSummaryPage.clickUserProfileLogoutIcon();
    }

    @Step
    @Then("Go to Work Queue Task page")
    public void goToWorkQueueTaskPage() {
        log.info("Go to Work Queue Task page");
        dockManagementSummaryPage.clickWorkQueueIcon();
        dockManagementSummaryPage.clickTasksIcon();
    }

    @Step
    @Then("Go to Work Queue Assign Work page")
    public void goToWorkQueueAssignWorkPage() {
        log.info("Go to Work Queue Assign Work page");
        dockManagementSummaryPage.clickWorkQueueIcon();
        dockManagementSummaryPage.clickAssignWorkIcon();
    }

    @Step
    @Then("Go to Work Queue User history page")
    public void goToWorkQueueUserHistoryPage() {
        log.info("Go to Work Queue User history page");
        dockManagementSummaryPage.clickWorkQueueIcon();
        dockManagementSummaryPage.clickUserHistoryIcon();
    }

    @Step
    @Then("Go to Work Queue Logged-in users page")
    public void goToWorkQueueLoggedInUsersPage() {
        log.info("Go to Work Queue Logged-in users page");
        dockManagementSummaryPage.clickWorkQueueIcon();
        dockManagementSummaryPage.clickLoggedInUsersIcon();
    }

    @Step
    @Then("Go to Work Queue Assignments page")
    public void goToWorkQueueAssignmentsPage() {
        log.info("Go to Work Queue Assignments page");
        dockManagementSummaryPage.clickWorkQueueIcon();
        dockManagementSummaryPage.clickAssignmentsIcon();
    }

    @Step
    @Then("Go to Lookup Location page")
    public void goToLookupLocationPage() {
        log.info("Go to Lookup Location page");
        dockManagementSummaryPage.clickLookupIcon();
        dockManagementSummaryPage.clickLocationIcon();
    }

    @Step
    @Then("Go to Counting Count page")
    public void goToCountingCountPage() {
        log.info("Go to Counting Count page");
        dockManagementSummaryPage.clickCountingIcon();
        dockManagementSummaryPage.clickCountIcon();
    }

    @Step
    @Then("Go to Counting Dashboard page")
    public void goToCountingDashboardPage() {
        log.info("Go to Counting Dashboard page");
        dockManagementSummaryPage.clickCountingIcon();
        dockManagementSummaryPage.clickCountingDashboardIcon();
    }

    @Step
    @Then("Go to Counting Sessions page")
    public void goToCountingSessionsPage() {
        log.info("Go to Counting Sessions page");
        dockManagementSummaryPage.clickCountingIcon();
        dockManagementSummaryPage.clickCountingSessionsIcon();
    }

    @Step
    @Then("Clicks Lookup icon")
    public void clickLookupIcon() {
        log.info("Clicks Lookup icon");
        dockManagementSummaryPage.clickLookupIcon();
    }

    @Step
    @Then("Go to Lookup Product page")
    public void goToLookupProductPage() {
        log.info("Go to Lookup Product page");
        dockManagementSummaryPage.clickLookupIcon();
        dockManagementSummaryPage.clickProductIcon();
    }

    @Step
    @Then("Go to Lookup DockManagement page")
    public void goToLookupDockManagementPage() {
        log.info("Go to Lookup DockManagement page");
        dockManagementSummaryPage.clickLookupIcon();
        dockManagementSummaryPage.clickDockManagementIcon();
    }

    @Step
    @Then("Go to Setup System page")
    public void goToSetupIconPage() {
        log.info("Go to Setup System page");
        dockManagementSummaryPage.clickSetupIcon();
        dockManagementSummaryPage.clickSystemIcon();
    }

    @Step
    @Then("Go to Setup Product page")
    public void goToSetupProductPage() {
        log.info("Go to Setup Product page");
        dockManagementSummaryPage.clickSetupIcon();
        dockManagementSummaryPage.clickSetupProductIcon();
    }

    @Step
    @And("Clicks Cycle Count graph bar on DockManagement page")
    public void clickCycleCountGraphBar() {
        log.info("Clicks Cycle Count graph bar on DockManagement page");
        dockManagementSummaryPage.clickCycleCountGraphBar();
    }

    @Step
    @And("Hover over Cycle Count graph bar on DockManagement page")
    public void hoverOverCycleCountGraphBar() {
        log.info("Hover over Cycle Count graph bar on DockManagement page");
        dockManagementSummaryPage.hoverOverCycleCountGraphBar();
    }

    @Step
    @And("Hover over Count graph bar on DockManagement page")
    public void hoverOverCountGraphBar() {
        log.info("Hover over Count graph bar on DockManagement page");
        dockManagementSummaryPage.hoverOverCountGraphBar();
    }

    @Step
    @And("Clicks Let Down graph bar on DockManagement page")
    public void clickLetDownGraphBar() {
        log.info("Clicks Let Down graph bar on DockManagement page");
        dockManagementSummaryPage.clickLetDownGraphBar();
    }

    @Step
    @And("Hover over Letdown graph bar on DockManagement page")
    public void hoverOverLetDownGraphBar() {
        log.info("Hover over Letdown graph bar on DockManagement page");
        dockManagementSummaryPage.hoverOverLetDownGraphBar();
    }

    @Step
    @And("Clicks Load Count Audit graph bar on DockManagement page")
    public void clickLoadCountAuditGraphBar() {
        log.info("Clicks Load Count Audit graph bar on DockManagement page");
        dockManagementSummaryPage.clickLoadCountAuditGraphBar();
    }

    @Step
    @And("Clicks Loading graph bar on DockManagement page")
    public void clickLoadingGraphBar() {
        log.info("Clicks Loading graph bar on DockManagement page");
        dockManagementSummaryPage.clickLoadingGraphBar();
    }

    @Step
    @And("Clicks Count graph bar on DockManagement page")
    public void clickCountGraphBar() {
        log.info("Clicks Count graph bar on DockManagement page");
        dockManagementSummaryPage.clickCountGraphBar();
    }

    @Step
    @And("Clicks Dee graph bar on DockManagement page")
    public void clickDeeGraphBar() {
        log.info("Clicks Dee graph bar on DockManagement page");
        dockManagementSummaryPage.clickDeeGraphBar();
    }

    @Step
    @And("Clicks Default graph bar on DockManagement page")
    public void clickDefaultGraphBar() {
        log.info("Clicks Default graph bar on DockManagement page");
        dockManagementSummaryPage.clickDefaultGraphBar();
    }

    @Step
    @And("Clicks Load graph bar on DockManagement page")
    public void clickLoadGraphBar() {
        log.info("Clicks Load graph bar on DockManagement page");
        dockManagementSummaryPage.clickLoadGraphBar();
    }

    @Step
    @And("Clicks Pal Dry graph bar on DockManagement page")
    public void clickPalDryGraphBar() {
        log.info("Clicks Pal Dry graph bar on DockManagement page");
        dockManagementSummaryPage.clickPalDryGraphBar();
    }

    @Step
    @And("Clicks On Break graph bar on DockManagement page")
    public void clickOnBreakBar() {
        log.info("Clicks On Break graph bar on DockManagement page");
        dockManagementSummaryPage.clickOnBreakBar();
    }

}
