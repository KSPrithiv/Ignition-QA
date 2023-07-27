package ui.pages;

import common.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DockManagementSummaryPage extends BasePage {
    By applicationIconContainer = By.cssSelector(".application-icon-container");
    By hamburgerIcon = By.className("open-menu-hamburger-icon");
    By topHeaderRow = By.cssSelector("div[class='topHeaderRow  row']");
    By topIcon = By.cssSelector(".spnmoduleNameHeader");
    By dockManagementSummaryTableDivider = By.cssSelector(".DockManagementSummaryTableDivider");
    By transactionsGraph = By.xpath("//span[text()='TRANSACTIONS' and contains(@class, 'i-card__title')]");
    By tasksByTypeGraph = By.xpath("//h4[text()='Tasks by Type']");
    By checkInTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Check In']");
    By cycleCountTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Cycle Count']");
    By cycleCountPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[contains(@d, 'M55.939 63.903')]");
    By letdownTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Letdown']");
    By letdownPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[contains(@d, 'M81.061 304.39')]");
    By loadCountAuditTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Load Count Audit']");
    By loadCountAuditPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[contains(@d, 'M106.183 300.878')]");
    By loadingTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Loading']");
    By loadingPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[contains(@d, 'M131.305 300')]");
    By movementTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Movement']");
    By opportunisticCountTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Opportunistic Count']");
    By packStagingTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Pack Staging']");
    By packingTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Packing']");
    By pickTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Pick']");
    By pickFromReserveTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Pick from Reserve']");
    By putawayTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Putaway']");
    By replenishmentTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Replenishment']");
    By shippingTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Shipping']");
    By shortChasingTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Short Chasing']");
    By topOffTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Top Off']");
    By wavePickTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Tasks by Type']]//*[text()='Wave Pick']");
    By orderStatusGraph = By.xpath("//span[text()='ORDER STATUS' and contains(@class, 'i-card__title')]");
    By inboundLoadsGraph = By.xpath("//h4[text()='Inbound Loads']");
    By outboundRoutesGraph = By.xpath("//h4[text()='Outbound Routes']");
    By assignmentsByGroupGraph = By.xpath("//h4[text()='Assignments by Group']");
    By inboundOrdersGraph = By.xpath("//h4[text()='Inbound Orders']");
    By outboundOrdersGraph = By.xpath("//h4[text()='Outbound Orders']");
    By pickingStatusGraph = By.xpath("//h4[text()='Picking Status']");
    By lateInboundGraph = By.xpath("//h4[text()='Late Inbound']");
    By lateOutboundGraph = By.xpath("//h4[text()='Late Outbound']");
    By replenishmentStatusGraph = By.xpath("//h4[text()='Replenishment Status']");
    By laborGraph = By.xpath("//span[text()='LABOR' and contains(@class, 'i-card__title')]");
    By activeOperatorsGraph = By.xpath("//h4[text()='Active Operators']");
    By activeOperatorsMin8h = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Active Operators']]//*[contains(text(), '<8 hours')]");
    By activeOperators8h24h = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Active Operators']]//*[contains(text(), '8-24 hours')]");
    By activeOperators24hPlus = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Active Operators']]//*[contains(text(), '24+ hours')]");
    By activeOperatorsOnBreak = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Active Operators']]//*[contains(text(), 'On break')]");
    By onBreakBarPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Active Operators']]//*[contains(@d, 'M328.5 72.5')]");
    By inventoryGraph = By.xpath("//span[text()='INVENTORY' and contains(@class, 'i-card__title')]");
    By byStatusGraph = By.xpath("//h4[text()='By Status']");
    By byStatusCloseToCode = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='By Status']]//*[contains(text(), 'Close to Code')]");
    By byStatusDamaged = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='By Status']]//*[contains(text(), 'Damaged')]");
    By byStatusExpired = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='By Status']]//*[contains(text(), 'Expired')]");
    By byStatusFDAHOLD = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='By Status']]//*[contains(text(), 'FDA HOLD')]");
    By byStatusHoldTest = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='By Status']]//*[contains(text(), 'Hold Test')]");
    By byStatusQualityControl = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='By Status']]//*[contains(text(), 'Quality Control')]");
    By byStatusShipped = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='By Status']]//*[contains(text(), 'Shipped')]");
    By capacityGraph = By.xpath("//span[text()='CAPACITY' and contains(@class, 'i-card__title')]");
    By warehouseCapacityGraph = By.xpath("//h4[text()='Warehouse Capacity']");
    By arcgauge = By.cssSelector(".k-arcgauge");
    By arcgaugeLabel = By.cssSelector(".k-arcgauge-label");
    By operatorsByGroupGraph = By.xpath("//h4[text()='Operators by Group']");
    By emptyLocationsByZoneGraph = By.xpath("//h4[text()='Empty Locations by Zone']");
    By byPick = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Empty Locations by Zone']]//*[contains(text(), 'Pick')]");
    By byReserve = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Empty Locations by Zone']]//*[contains(text(), 'Reserve')]");
    By listBoxIcon = By.cssSelector("span[class='k-input']");
    By searchIcon = By.cssSelector("div[class='item-searchbar']");
    By dashboardIcon = By.xpath("//ul[contains(@class, 'drawer-menu-list-items')]//span[text()='Dashboard']");
    By inboundIcon = By.xpath("//ul[contains(@class, 'drawer-menu-list-items')]//span[text()='Inbound']");
    By loadsSubmenuIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Loads') and @class='submenu-item-text']");
    By inboundOrdersSubmenuIcon = By.xpath("//div[contains(text(), 'Inbound Orders') and @class='submenu-item-text']");
    By receivingSubmenuIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Receiving') and @class='submenu-item-text']");
    By inboundReportsSubmenuIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Inbound reports') and @class='submenu-item-text']");
    By outboundIcon = By.xpath("//ul[contains(@class, 'drawer-menu-list-items')]//span[text()='Outbound']");
    By processingIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Processing') and @class='submenu-item-text']");
    By routesIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Routes') and @class='submenu-item-text']");
    By outboundOrdersIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Outbound Orders')]");
    By loadPlanningIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Load Planning') and @class='submenu-item-text']");
    By outboundReportsIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Outbound Reports') and @class='submenu-item-text']");
    By lookupIcon = By.xpath("//ul[contains(@class, 'drawer-menu-list-items')]//span[text()='Lookup']");
    By workQueueIcon = By.xpath("//ul[contains(@class, 'drawer-menu-list-items')]//span[text()='Work Queue']");
    By tasksIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Tasks') and @class='submenu-item-text']");
    By assignWorkIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Assign Work') and @class='submenu-item-text']");
    By userHistoryIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'User History') and @class='submenu-item-text']");
    By loggedInUsersIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Logged-In Users') and @class='submenu-item-text']");
    By assignmentsIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Assignments') and @class='submenu-item-text']");
    By countingIcon = By.xpath("//ul[contains(@class, 'drawer-menu-list-items')]//span[text()='Counting']");
    By setupIcon = By.xpath("//ul[contains(@class, 'drawer-menu-list-items')]//span[text()='Setup']");
    By setupProductIcon = By.xpath("//div[contains(@id, 'accesscpwmssettingssystem')]//div[contains(text(), 'Product')]");
    By appointmentsIcon = By.xpath("//ul[contains(@class, 'drawer-menu-list-items')]//span[text()='Appointments']");
    By locationIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Location') and @class='submenu-item-text']");
    By productIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Product') and @class='submenu-item-text']");
    By dockManagementIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Dock Management') and @class='submenu-item-text']");
    By lookupReportsIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Lookup Reports') and @class='submenu-item-text']");
    By countIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Counting') and @class='submenu-item-text']");
    By countingDashboardIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Dashboard') and @class='submenu-item-text']");
    By countingSessionsIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Sessions') and @class='submenu-item-text']");
    By exportIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Export') and @class='submenu-item-text']");
    By systemIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'System') and @class='submenu-item-text']");
    By multiListItemButton = By.cssSelector(".drawer-menu-container-more-items .MuiListItem-button");
    By securityIcon = By.xpath("//span[contains(text(), 'Security')]");
    By permissionsIcon = By.xpath("//div[@class='submenu-items-list']//div[contains(text(), 'Permissions') and @class='submenu-item-text']");
    By userProfileIcon = By.cssSelector(".user-info-initial-container");
    By userProfileLogoutIcon = By.cssSelector(".user-info-line-signout .i-icon");
    By userProfileFooterIcon = By.cssSelector(".drawer-menu-footer-container .i-icon");
    By countTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='COUNT']");
    By countTaskPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[contains(@d, 'M55.939 63.903')]");
    By deeTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='DEE']");
    By deeTaskPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[contains(@d, 'M70.833 316.846')]");
    By defaultTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='DEFAULT']");
    By defaultTaskPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[contains(@d, 'M96.833 313.735')]");
    By loadTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='LOAD']");
    By loadTaskPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[contains(@d, 'M122.833 319.957')]");
    By palDryTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='PAL DRY']");
    By palDryTaskPath = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[contains(@d, 'M148.833 204.862')]");
    By palFrzTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='PAL FRZ']");
    By pickChillTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='PICK CHILL']");
    By pickDryTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='PICK DRY']");
    By pickFrzTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='PICK FRZ']");
    By shortTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='SHORT']");
    By wpChillTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='WP CHILL']");
    By xdockPalTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='XDOCK PAL']");
    By xrepNdFrzTask = By.xpath("//div[contains(@class, 'i-card__card__body')][.//h4[text()='Assignments by Group']]//*[text()='XREP ND FRZ']");

    public void waitForDockManagementSummaryPageToLoad() {
        Waiters.waitABit(4000);
        Waiters.waitForElementToBeDisplay(getTopIcon());
    }

    public void clickListBoxIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getListBoxIcon());
        clickOnElement(getListBoxIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickUserProfileIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(userProfileIcon);
        clickOnElement(userProfileIcon);
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickUserProfileLogoutIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(userProfileLogoutIcon);
        clickOnElement(userProfileLogoutIcon);
        Waiters.waitABit(2000);
    }

    public void clickSearchIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getSearchIcon());
        clickOnElement(getSearchIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickDashboardIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getDashboardIcon());
        clickOnElement(getDashboardIcon());
        Waiters.waitABit(8000);
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickInboundIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getInboundIcon());
        clickOnElement(getInboundIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(2000);
    }

    public void hoverInboundIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getInboundIcon());
        hover(getInboundIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickLoadsIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getLoadsSubmenuIcon());
        clickOnElement(getLoadsSubmenuIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(15000);
    //    clickOnElement(getHamburgerIcon());
    }

    public void clickInboundOrdersIcon() {
        Waiters.waitForElementToBeDisplay(getInboundOrdersSubmenuIcon());
        clickOnElement(getInboundOrdersSubmenuIcon());
        Waiters.waitABit(7000);
    }

    public void clickReceivingIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getReceivingSubmenuIcon());
        clickOnElement(getReceivingSubmenuIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    //    clickOnElement(getHamburgerIcon());
    }

    public void clickInboundReportsIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getInboundReportsSubmenuIcon());
        clickOnElement(getInboundReportsSubmenuIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
     //   clickOnElement(getHamburgerIcon());
    }

    public void clickOutboundIcon() {
        Waiters.waitABit(25000);
        Waiters.waitForElementToBeDisplay(getOutboundIcon());
        clickOnElement(getOutboundIcon());
        Waiters.waitABit(5000);
    }

    public void clickOutboundOrdersIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getOutboundOrdersIcon());
        clickOnElement(getOutboundOrdersIcon());
        Waiters.waitABit(6000);
    //    clickOnElement(getHamburgerIcon());
    }

    public void clickTasksIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getTasksIcon());
        clickOnElement(getTasksIcon());
        Waiters.waitABit(8000);
   //     clickOnElement(getHamburgerIcon());
    }

    public void clickAssignWorkIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getAssignWorkIcon());
        clickOnElement(getAssignWorkIcon());
        Waiters.waitABit(8000);
   //     clickOnElement(getHamburgerIcon());
    }

    public void clickUserHistoryIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getUserHistoryIcon());
        clickOnElement(getUserHistoryIcon());
        Waiters.waitABit(8000);
    //    clickOnElement(getHamburgerIcon());
    }

    public void clickLoggedInUsersIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getLoggedInUsersIcon());
        clickOnElement(getLoggedInUsersIcon());
        Waiters.waitABit(8000);
     //   clickOnElement(getHamburgerIcon());
    }

    public void clickAssignmentsIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getAssignmentsIcon());
        clickOnElement(getAssignmentsIcon());
        Waiters.waitABit(8000);
      //  clickOnElement(getHamburgerIcon());
    }

    public void clickLocationIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getLocationIcon());
        clickOnElement(getLocationIcon());
        Waiters.waitABit(8000);
     //   clickOnElement(getHamburgerIcon());
    }

    public void clickCountingIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getCountingIcon());
        clickOnElement(getCountingIcon());
    }

    public void clickProductIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getProductIcon());
        clickOnElement(getProductIcon());
        Waiters.waitABit(8000);
    //    clickOnElement(getHamburgerIcon());
    }

    public void clickSetupProductIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(setupProductIcon);
        clickOnElement(setupProductIcon);
        Waiters.waitABit(8000);
    }

    public void clickDockManagementIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeDisplay(getDockManagementIcon());
        clickOnElement(getDockManagementIcon());
        Waiters.waitABit(8000);
      //  clickOnElement(getHamburgerIcon());
    }

    public void clickOutboundReportsIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getOutboundReportsIcon());
        clickOnElement(getOutboundReportsIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
     //   clickOnElement(getHamburgerIcon());
    }

    public void clickLoadPlanningIcon() {
        Waiters.waitABit(2000);
        clickOnElement(getLoadPlanningIcon());
        Waiters.waitABit(5000);
    //    clickOnElement(getHamburgerIcon());
    }

    public void clickProcessingIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getProcessingIcon());
        clickOnElement(getProcessingIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
       // clickOnElement(getHamburgerIcon());
    }

    public void clickRoutesIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getRoutesIcon());
        clickOnElement(getRoutesIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
   //     clickOnElement(getHamburgerIcon());
    }

    public void clickLookupIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getLookupIcon());
        clickOnElement(getLookupIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickWorkQueueIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getWorkQueueIcon());
        clickOnElement(getWorkQueueIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickCountIcon() {
        Waiters.waitForElementToBeClickable(getCountIcon());
        clickOnElement(getCountIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickCountingDashboardIcon() {
        Waiters.waitForElementToBeClickable(getCountingDashboardIcon());
        clickOnElement(getCountingDashboardIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickCountingSessionsIcon() {
        Waiters.waitForElementToBeClickable(getCountingSessionsIcon());
        clickOnElement(getCountingSessionsIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickSetupIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getSetupIcon());
        clickOnElement(getSetupIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickSecurityIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(multiListItemButton);
        clickOnElement(multiListItemButton);
        Waiters.waitABit(5000);
        Waiters.waitForElementToBeClickable(getSecurityIcon());
        clickOnElement(getSecurityIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickPermissionsIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getPermissionsIcon());
        clickOnElement(getPermissionsIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
      //  clickOnElement(getHamburgerIcon());
    }

    public void clickAppointmentIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getAppointmentsIcon());
        clickOnElement(getAppointmentsIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickSystemIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getSystemIcon());
        clickOnElement(getSystemIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public void clickApplicationIconContainer() {
        Waiters.waitABit(3000);
        Waiters.waitForElementToBeClickable(getApplicationIconContainer());
        clickOnElement(getApplicationIconContainer());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5000);
    }

    public void clickCycleCountGraphBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getCycleCountPath());
        clickOnElement(getCycleCountPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }

    public void hoverOverCycleCountGraphBar() {
        Waiters.waitABit(2000);
        hover(cycleCountPath);
    }

    public void hoverOverCountGraphBar() {
        Waiters.waitABit(2000);
        hover(countTaskPath);
    }

    public void clickLetDownGraphBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getLetdownPath());
        clickOnElement(getLetdownPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }

    public void hoverOverLetDownGraphBar() {
        Waiters.waitABit(2000);
        hover(letdownPath);
    }

    public void clickLoadCountAuditGraphBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getLoadCountAuditPath());
        clickOnElement(getLoadCountAuditPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }

    public void clickLoadingGraphBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getLoadingPath());
        clickOnElement(getLoadingPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }
    public void clickCountGraphBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getCountTaskPath());
        clickOnElement(getCountTaskPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }

    public void clickDeeGraphBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getDeeTaskPath());
        clickOnElement(getDeeTaskPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }

    public void clickDefaultGraphBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getDefaultTaskPath());
        clickOnElement(getDefaultTaskPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }

    public void clickLoadGraphBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getLoadTaskPath());
        clickOnElement(getLoadTaskPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }

    public void clickPalDryGraphBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getPalDryTaskPath());
        clickOnElement(getPalDryTaskPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }

    public void clickOnBreakBar() {
        Waiters.waitABit(10000);
        Waiters.waitForElementToBeClickable(getOnBreakBarPath());
        clickOnElement(getOnBreakBarPath());
        Waiters.waitUntilPageWillLoadedSelenide();
        Waiters.waitABit(5_000);
    }

    public void hoverOverApplicationContainerIcon() {
        Waiters.waitABit(2000);
        Waiters.waitForElementToBeClickable(getAppointmentsIcon());
        hover(getAppointmentsIcon());
        Waiters.waitUntilPageWillLoadedSelenide();
    }

    public boolean isListBoxIconVisible() {
        Waiters.waitABit(2000);
        return isElementDisplay(getListBoxIcon());
    }

    public boolean isTopHeaderRowVisible() {
        Waiters.waitABit(2000);
        return isElementDisplay(getTopHeaderRow());
    }

    public boolean isLocationIconVisible() {
        Waiters.waitABit(1000);
        return isElementDisplay(getLocationIcon());
    }

    public boolean isProductIconVisible() {
        Waiters.waitABit(1000);
        return isElementDisplay(getProductIcon());
    }

    public boolean isDockManagementIconVisible() {
        Waiters.waitABit(1000);
        return isElementDisplay(getDockManagementIcon());
    }

    public boolean isNumberOfTasksVisible() {
        Waiters.waitABit(1000);
        return isElementDisplay(findWebElement(By
            .xpath("//div[contains(@class, 'k-animation-container-shown')]//div[contains(@style, 'background-color')]")));
    }

    public boolean isTransactionsGraphDisplayed() { return isElementDisplay(getTransactionsGraph()); }

    public boolean isTasksByTypeGraphDisplayed() { return isElementDisplay(getTasksByTypeGraph()); }

    public boolean isOrderStatusGraphDisplayed() { return isElementDisplay(getOrderStatusGraph()); }

    public boolean isInboundLoadsGraphDisplayed() { return isElementDisplay(getInboundLoadsGraph()); }

    public boolean isOutboundRoutesGraphDisplayed() { return isElementDisplay(getOutboundRoutesGraph()); }

    public boolean isAssignmentsByGroupGraphDisplayed() { return isElementDisplay(getAssignmentsByGroupGraph()); }

    public boolean isInboundOrdersGraphDisplayed() { return isElementDisplay(getInboundOrdersGraph()); }

    public boolean isOutboundOrdersGraphDisplayed() { return isElementDisplay(getOutboundOrdersGraph()); }

    public boolean isPickingStatusGraphDisplayed() { return isElementDisplay(getPickingStatusGraph()); }

    public boolean isLateInboundGraphDisplayed() { return isElementDisplay(getLateInboundGraph()); }

    public boolean isLateOutboundGraphDisplayed() { return isElementDisplay(getLateOutboundGraph()); }

    public boolean isReplenishmentStatusGraphDisplayed() { return isElementDisplay(getReplenishmentStatusGraph()); }

    public boolean isLaborGraphDisplayed() { return isElementDisplay(getLaborGraph()); }

    public boolean isActiveOperatorsGraphDisplayed() { return isElementDisplay(getActiveOperatorsGraph()); }

    public boolean isActiveOperatorsMin8hDisplayed() { return isElementDisplay(getActiveOperatorsMin8h()); }

    public boolean isActiveOperators8h24hDisplayed() { return isElementDisplay(getActiveOperators8h24h()); }

    public boolean isActiveOperators24hPlusDisplayed() { return isElementDisplay(getActiveOperators24hPlus()); }

    public boolean isActiveOperatorsOnBreakDisplayed() { return isElementDisplay(getActiveOperatorsOnBreak()); }

    public boolean isCapacityGraphDisplayed() { return isElementDisplay(getCapacityGraph()); }

    public boolean isWarehouseCapacityGraphDisplayed() { return isElementDisplay(getWarehouseCapacityGraph()); }

    public boolean isByStatusGraphDisplayed() { return isElementDisplay(getByStatusGraph()); }

    public boolean isOperatorsByGroupGraphDisplayed() { return isElementDisplay(getOperatorsByGroupGraph()); }

    public boolean isEmptyLocationsByZoneGraphDisplayed() { return isElementDisplay(getEmptyLocationsByZoneGraph()); }

    public boolean isByPickDisplayed() { return isElementDisplay(getByPick()); }

    public boolean isByReserveDisplayed() { return isElementDisplay(getByReserve()); }

    public boolean isUserProfileFooterIconDisplayed() { return isElementDisplay(getUserProfileFooterIcon()); }

    public boolean isCheckInTaskDisplayed() { return isElementDisplay(getCheckInTask()); }

    public boolean isCycleCountTaskDisplayed() { return isElementDisplay(getCycleCountTask()); }

    public boolean isLetdownTaskDisplayed() { return isElementDisplay(getLetdownTask()); }

    public boolean isLoadCountAuditTaskDisplayed() { return isElementDisplay(getLoadCountAuditTask()); }

    public boolean isLoadingTaskDisplayed() { return isElementDisplay(getLoadingTask()); }

    public boolean isMovementTaskDisplayed() { return isElementDisplay(getMovementTask()); }

    public boolean isInventoryGraphDisplayed() { return isElementDisplay(getInventoryGraph()); }

    public boolean isCloseToCodeDisplayed() { return isElementDisplay(getByStatusCloseToCode()); }

    public boolean isDamagedDisplayed() { return isElementDisplay(getByStatusDamaged()); }

    public boolean isExpiredDisplayed() { return isElementDisplay(getByStatusExpired()); }

    public boolean isFDAHOLDDisplayed() { return isElementDisplay(getByStatusFDAHOLD()); }

    public boolean isHoldTestDisplayed() { return isElementDisplay(getByStatusHoldTest()); }

    public boolean isQualityControlDisplayed() { return isElementDisplay(getByStatusQualityControl()); }

    public boolean isShippedDisplayed() { return isElementDisplay(getByStatusShipped()); }

    public boolean isOpportunisticCountTaskDisplayed() { return isElementDisplay(getOpportunisticCountTask()); }

    public boolean isPackStagingTaskDisplayed() { return isElementDisplay(getPackStagingTask()); }

    public boolean isPackingTaskDisplayed() { return isElementDisplay(getPackingTask()); }

    public boolean isPickTaskDisplayed() { return isElementDisplay(getPickTask()); }

    public boolean isPickFromReserveTaskDisplayed() { return isElementDisplay(getPickFromReserveTask()); }

    public boolean isPutawayTaskDisplayed() { return isElementDisplay(getPutawayTask()); }

    public boolean isReplenishmentTaskDisplayed() { return isElementDisplay(getReplenishmentTask()); }

    public boolean isShippingTaskDisplayed() { return isElementDisplay(getShippingTask()); }

    public boolean isShortChasingTaskDisplayed() { return isElementDisplay(getShortChasingTask()); }

    public boolean isTopOffTaskDisplayed() { return isElementDisplay(getTopOffTask()); }

    public boolean isWavePickTaskDisplayed() { return isElementDisplay(getWavePickTask()); }

    public boolean isCountTaskDisplayed() { return isElementDisplay(getCountTask()); }

    public boolean isDeeTaskDisplayed() { return isElementDisplay(getDeeTask()); }

    public boolean isDefaultTaskDisplayed() { return isElementDisplay(getDefaultTask()); }

    public boolean isLoadTaskDisplayed() { return isElementDisplay(getLoadTask()); }

    public boolean isPalDryTaskDisplayed() { return isElementDisplay(getPalDryTask()); }

    public boolean isPalFrzTaskDisplayed() { return isElementDisplay(getPalFrzTask()); }

    public boolean isPickChillTaskDisplayed() { return isElementDisplay(getPickChillTask()); }

    public boolean isPickDryTaskDisplayed() { return isElementDisplay(getPickDryTask()); }

    public boolean isPickFrzTaskDisplayed() { return isElementDisplay(getPickFrzTask()); }

    public boolean isShortTaskDisplayed() { return isElementDisplay(getShortTask()); }

    public boolean isWpChillTaskDisplayed() { return isElementDisplay(getWpChillTask()); }

    public boolean isXdockPalTaskDisplayed() { return isElementDisplay(getXdockPalTask()); }

    public boolean isXrepNdFrzDisplayed() { return isElementDisplay(getXrepNdFrzTask()); }

    public boolean isArcgaugeDisplayed() { return isElementDisplay(arcgauge); }

    public boolean isArcgaugeLabelDisplayed() { return isElementDisplay(arcgaugeLabel); }

    public WebElement getApplicationIconContainer() { return findWebElement(applicationIconContainer); }

    public WebElement getHamburgerIcon() { return findWebElement(hamburgerIcon); }

    public WebElement getTopHeaderRow() { return findWebElement(topHeaderRow); }

    public WebElement getDockManagementSummaryTableDivider() { return findWebElement(dockManagementSummaryTableDivider); }

    public WebElement getTopIcon() { return findWebElement(topIcon); }

    public WebElement getListBoxIcon() { return findWebElement(listBoxIcon); }

    public WebElement getSearchIcon() { return findWebElement(searchIcon); }

    public WebElement getDashboardIcon() { return findWebElement(dashboardIcon); }

    public WebElement getInboundIcon() { return findWebElement(inboundIcon); }

    public WebElement getLoadsSubmenuIcon() {  return findWebElement(loadsSubmenuIcon); }

    public WebElement getInboundOrdersSubmenuIcon() { return findWebElement(inboundOrdersSubmenuIcon); }

    public WebElement getReceivingSubmenuIcon() { return findWebElement(receivingSubmenuIcon); }

    public WebElement getInboundReportsSubmenuIcon() { return findWebElement(inboundReportsSubmenuIcon); }

    public WebElement getOutboundIcon() { return findWebElement(outboundIcon); }

    public WebElement getProcessingIcon() { return findWebElement(processingIcon); }

    public WebElement getRoutesIcon() { return findWebElement(routesIcon); }

    public WebElement getOutboundOrdersIcon() { return findWebElement(outboundOrdersIcon); }

    public WebElement getLoadPlanningIcon() { return findWebElement(loadPlanningIcon); }

    public WebElement getOutboundReportsIcon() { return findWebElement(outboundReportsIcon); }

    public WebElement getLookupIcon() { return findWebElement(lookupIcon); }

    public WebElement getWorkQueueIcon() { return findWebElement(workQueueIcon); }

    public WebElement getCountingIcon() { return findWebElement(countingIcon); }

    public WebElement getSetupIcon() { return findWebElement(setupIcon); }

    public WebElement getTasksIcon() { return findWebElement(tasksIcon); }

    public WebElement getAssignWorkIcon() { return findWebElement(assignWorkIcon); }

    public WebElement getUserHistoryIcon() { return findWebElement(userHistoryIcon); }

    public WebElement getLoggedInUsersIcon() { return findWebElement(loggedInUsersIcon); }

    public WebElement getAssignmentsIcon() { return findWebElement(assignmentsIcon); }

    public WebElement getAppointmentsIcon() { return findWebElement(appointmentsIcon); }

    public WebElement getLocationIcon() { return findWebElement(locationIcon); }

    public WebElement getProductIcon() { return findWebElement(productIcon); }

    public WebElement getDockManagementIcon() { return findWebElement(dockManagementIcon); }

    public WebElement getCountIcon() { return findWebElement(countIcon); }

    public WebElement getCountingDashboardIcon() { return findWebElement(countingDashboardIcon); }

    public WebElement getCountingSessionsIcon() { return findWebElement(countingSessionsIcon); }

    public WebElement getLookupReportsIcon() { return findWebElement(lookupReportsIcon); }

    public WebElement getSystemIcon() { return findWebElement(systemIcon); }

    public WebElement getSecurityIcon() { return findWebElement(securityIcon); }

    public WebElement getPermissionsIcon() { return findWebElement(permissionsIcon); }

    public WebElement getExportIcon() { return findWebElement(exportIcon); }

    public WebElement getTransactionsGraph() { return findWebElement(transactionsGraph); }

    public WebElement getTasksByTypeGraph() { return findWebElement(tasksByTypeGraph); }

    public WebElement getOrderStatusGraph() { return findWebElement(orderStatusGraph); }

    public WebElement getInboundLoadsGraph() { return findWebElement(inboundLoadsGraph); }

    public WebElement getOutboundRoutesGraph() { return findWebElement(outboundRoutesGraph); }

    public WebElement getAssignmentsByGroupGraph() { return findWebElement(assignmentsByGroupGraph); }

    public WebElement getInboundOrdersGraph() { return findWebElement(inboundOrdersGraph); }

    public WebElement getOutboundOrdersGraph() { return findWebElement(outboundOrdersGraph); }

    public WebElement getPickingStatusGraph() { return findWebElement(pickingStatusGraph); }

    public WebElement getLateInboundGraph() { return findWebElement(lateInboundGraph); }

    public WebElement getLateOutboundGraph() { return findWebElement(lateOutboundGraph); }

    public WebElement getReplenishmentStatusGraph() { return findWebElement(replenishmentStatusGraph); }

    public WebElement getLaborGraph() { return findWebElement(laborGraph); }

    public WebElement getActiveOperatorsGraph() { return findWebElement(activeOperatorsGraph); }

    public WebElement getActiveOperatorsMin8h() { return findWebElement(activeOperatorsMin8h); }

    public WebElement getActiveOperators8h24h() { return findWebElement(activeOperators8h24h); }

    public WebElement getActiveOperators24hPlus() { return findWebElement(activeOperators24hPlus); }

    public WebElement getActiveOperatorsOnBreak() { return findWebElement(activeOperatorsOnBreak); }

    public WebElement getCapacityGraph() { return findWebElement(capacityGraph); }

    public WebElement getWarehouseCapacityGraph() { return findWebElement(warehouseCapacityGraph); }

    public WebElement getByStatusGraph() { return findWebElement(byStatusGraph); }

    public WebElement getOperatorsByGroupGraph() { return findWebElement(operatorsByGroupGraph); }

    public WebElement getEmptyLocationsByZoneGraph() { return findWebElement(emptyLocationsByZoneGraph); }

    public WebElement getByPick() { return findWebElement(byPick); }

    public WebElement getByReserve() { return findWebElement(byReserve); }

    public WebElement getUserProfileFooterIcon() { return findWebElement(userProfileFooterIcon); }

    public WebElement getCheckInTask() { return findWebElement(checkInTask); }

    public WebElement getCycleCountTask() { return findWebElement(cycleCountTask); }

    public WebElement getCycleCountPath() { return findWebElement(cycleCountPath); }

    public WebElement getLetdownTask() { return findWebElement(letdownTask); }

    public WebElement getLetdownPath() { return findWebElement(letdownPath); }

    public WebElement getLoadCountAuditTask() { return findWebElement(loadCountAuditTask); }

    public WebElement getLoadCountAuditPath() { return findWebElement(loadCountAuditPath); }

    public WebElement getLoadingTask() { return findWebElement(loadingTask); }

    public WebElement getLoadingPath() { return findWebElement(loadingPath);  }

    public WebElement getMovementTask() { return findWebElement(movementTask); }

    public WebElement getOpportunisticCountTask() { return findWebElement(opportunisticCountTask); }

    public WebElement getPackStagingTask() { return findWebElement(packStagingTask); }

    public WebElement getPackingTask() { return findWebElement(packingTask); }

    public WebElement getPickTask() { return findWebElement(pickTask); }

    public WebElement getPickFromReserveTask() { return findWebElement(pickFromReserveTask); }

    public WebElement getPutawayTask() { return findWebElement(putawayTask); }

    public WebElement getReplenishmentTask() { return findWebElement(replenishmentTask); }

    public WebElement getShippingTask() { return findWebElement(shippingTask); }

    public WebElement getShortChasingTask() { return findWebElement(shortChasingTask); }

    public WebElement getTopOffTask() { return findWebElement(topOffTask); }

    public WebElement getWavePickTask() { return findWebElement(wavePickTask); }

    public WebElement getCountTask() { return findWebElement(countTask); }

    public WebElement getDeeTask() { return findWebElement(deeTask); }

    public WebElement getDefaultTask() { return findWebElement(defaultTask); }

    public WebElement getLoadTask() { return findWebElement(loadTask); }

    public WebElement getPalDryTask() { return findWebElement(palDryTask); }

    public WebElement getPalFrzTask() { return findWebElement(palFrzTask); }

    public WebElement getPickChillTask() { return findWebElement(pickChillTask); }

    public WebElement getPickDryTask() { return findWebElement(pickDryTask); }

    public WebElement getPickFrzTask() { return findWebElement(pickFrzTask); }

    public WebElement getShortTask() { return findWebElement(shortTask); }

    public WebElement getWpChillTask() { return findWebElement(wpChillTask); }

    public WebElement getXdockPalTask() { return findWebElement(xdockPalTask); }

    public WebElement getXrepNdFrzTask() { return findWebElement(xrepNdFrzTask); }

    public WebElement getCountTaskPath() { return findWebElement(countTaskPath); }

    public WebElement getDeeTaskPath() { return findWebElement(deeTaskPath); }

    public WebElement getDefaultTaskPath() { return findWebElement(defaultTaskPath); }

    public WebElement getLoadTaskPath() { return findWebElement(loadTaskPath); }

    public WebElement getPalDryTaskPath() { return findWebElement(palDryTaskPath); }

    public WebElement getOnBreakBarPath() { return findWebElement(onBreakBarPath); }

    public WebElement getInventoryGraph() { return findWebElement(inventoryGraph); }

    public WebElement getByStatusCloseToCode() { return findWebElement(byStatusCloseToCode); }

    public WebElement getByStatusDamaged() { return findWebElement(byStatusDamaged); }

    public WebElement getByStatusExpired() { return findWebElement(byStatusExpired); }

    public WebElement getByStatusFDAHOLD() { return findWebElement(byStatusFDAHOLD); }

    public WebElement getByStatusHoldTest() { return findWebElement(byStatusHoldTest); }

    public WebElement getByStatusQualityControl() { return findWebElement(byStatusQualityControl); }

    public WebElement getByStatusShipped() { return findWebElement(byStatusShipped); }

    public WebElement getMultiListItemButton() { return findWebElement(multiListItemButton); }

    public WebElement getUserProfileIcon() { return findWebElement(userProfileIcon); }

    public WebElement getUserProfileLogoutIcon() { return findWebElement(userProfileLogoutIcon); }

  }
