package steps.outbound.loadplanning;

import common.constants.FilePaths;
import common.utils.objectmapper.ObjectMapperWrapper;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.inbound.InboundOrderLoadsDTO;
import objects.outbound.OutboundOrderLoadsDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.outbound.loadplanning.OutboundTruckInfoPage;
import common.setup.DriverManager.*;
import ui.pages.BasePage;

import java.awt.*;
import java.time.Duration;
import java.util.List;

import common.setup.DriverManager;

@Slf4j
public class OutboundTruckInfoPageSteps {
    Scenario scenario;
    static boolean flag=false;
    static String currentURL=null;
    WebDriver driver;

    static OutboundTruckInfoPage outboundtruckInfoPage;

    OutboundTruckInfoPage outboundTruckInfoPage = new OutboundTruckInfoPage();
    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

    public OutboundTruckInfoPageSteps() throws InterruptedException, AWTException {
    }

    @Before
    public void LaunchBrowser1(Scenario scenario) throws Exception
    {
        this.scenario=scenario;
        driver =DriverManager.getDriver();

    }

    @Step
    @And("Waits for Outbound Truck Info page to load")
    public void waitForOutboundTruckInfoPageToLoad() {
        if(flag==false) {
            log.info("Waiting for Outbound Truck Info Page To Load");
            outboundTruckInfoPage.waitOutboundTruckInfoPageToLoad();
        }
    }
//    @Step
//    @Given("User is on Truck Info Page")
//    public void User_is_on_Truck_Info_Page() {
//        if(flag==true) {
//            log.info("Clicking Trailer dropdown on Truck Info page");
//            outboundTruckInfoPage.Refresh_Page();
//        }
//    }

    @Step
    @And("User is on Truck Info Page")
    public void truckInfopage() throws InterruptedException {

            log.info("Clicking Trailer dropdown on Truck Info page");

            String currentURL = return_back_to_select_ship_date_page();
            driver.navigate().to(currentURL);
            wait(4000);
            System.out.println("Gemini 3 =======>"+currentURL);


    }

    @Step
    @Then("Clicks Trailer dropdown on Truck Info page")
    public void clickTrailer() {

            log.info("Clicking Trailer dropdown on Truck Info page");
            //String currentURL =setAssignments();
            //driver.navigate().to(currentURL);

            outboundTruckInfoPage.clickTrailerDropDown();

    }

    @Step
    @Then("Clicks Door dropdown on Truck Info page")
    public void clickDoor() {

            log.info("Clicking Door dropdown on Truck Info page");
            outboundTruckInfoPage.clickDoorDropDown();

    }

    @Step
    @Then("Selects random trailer on Truck Info page")
    public void selectRandomTrailer() {

            log.info("Selecting random trailer on Truck Info page");
            outboundTruckInfoPage.selectRandomTrailer();

    }

    @Step
    @Then("Selects door {string} on Truck Info page")
    public void selectDoor(String door) {
        log.info("Selecting door on Truck Info page");
        outboundTruckInfoPage.selectDoor(door);
    }

    @Step
    @Then("Clicks Exit button on Truck Info page")
    public void clickExitButton() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("scroll(250, 0)"); // if the element is on top.
            log.info("Clicking Exit button on Truck Info page");
            outboundTruckInfoPage.clickExitButton();

    }

    @Step
    @Then("Clicks Work button on Truck Info page")
    public void clickWorkButton() {
        log.info("Clicking Work button on Truck Info page");
        outboundTruckInfoPage.clickWorkButton();
    }

    @Step
    @Then("Clicks Edit button on Truck Info page")
    public void clickEditButton() {
        log.info("Clicking Edit button on Truck Info page");
        outboundTruckInfoPage.clickEditButton();
    }

//    @Step
//    @And("user is on the Truck Info Page")
//    public void truckInfoPage()
//    {
//        //String currentURL=getDriver().getCurrentUrl();
//
//        //getDriver().navigate().to(currentURL);
//        //getDriver().navigate().to("currentURL");
//        //System.out.println("Gemini 2 ==================>"+currentURL);
//        BasePage b= new BasePage();
//        b.refresh_navigation(currentURL);
//
//    }
    @Step
    @Then("Clicks Reprocess button on Truck Info page")
    public void clickReprocessButton() {

            log.info("Clicking Reprocess button on Truck Info page");
            outboundTruckInfoPage.clickReprocessButton();

    }

    @Step
    @Then("Clicks Recalculate button on Truck Info page")
    public void clickRecalculateButton() {
        log.info("Clicking Recalculate button on Truck Info page");
        outboundTruckInfoPage.clickRecalculateButton();
    }

    @Step
    @Then("Clicks Key button on Truck Info page")
    public void clickKeyButton() {
        log.info("Clicking Key button on Truck Info page");
        outboundTruckInfoPage.clickKeyButton();
    }

    @Step
    @When("Clicks Inbound on Truck Info page")
    public void clickInboundLink() {
        log.info("Clicking Inbound on Truck Info page");
        outboundTruckInfoPage.clickInboundLink();
    }

    @Step
    @When("Clicks Shorts on Truck Info page")
    public void clickShortsLink() {
        log.info("Clicking Shorts on Truck Info page");
        outboundTruckInfoPage.clickShortsLink();
    }

    @Step
    @Then("Clicks No button on Warning Message")
    public void clickNoButtonOnWarningMsg() throws InterruptedException {
        log.info("Clicking No button on Warning Message");
        outboundTruckInfoPage.clickNoBtn();
        //Thread.sleep(4000);
    }

    @Step
    @Then("Clicks Yes button on Warning Message")
    public void clickYesButtonOnWarningMsg() {
        log.info("Clicking Yes button on Warning Message");
        outboundTruckInfoPage.clickYesBtn();
    }

    @Step
    @And("Clicks No button on Change trailer popup")
    public void clickNoButton() {
        log.info("Clicking No button");
        outboundTruckInfoPage.clickNoButton();
    }

    @Step
    @And("Clicks Yes button on Change trailer popup")
    public void clickYesButton() {
        log.info("Clicking Yes button");
        outboundTruckInfoPage.clickYesButton();
    }

    @Step
    @And("Clicks Yes button on Move Assignment")
    public void clickYesButtonForMoveAssignment() {
        log.info("Clicking Yes button");
        outboundTruckInfoPage.clickYesButton();
    }

    @Step
    @And("Clicks No button on Move Assignment")
    public void clickNoButtonForMoveAssignment() {
        log.info("Clicking No button");
        outboundTruckInfoPage.clickNoButton();
    }

    @Step
    @And("Clicks No button on Change Ship Date popup")
    public void clickNo() {
        log.info("Clicking No button");
        outboundTruckInfoPage.clickNoButton();
    }

    @Step
    @And("Clicks Yes button on Change Ship Date popup")
    public void clickYes() {
        log.info("Clicking Yes button");
        outboundTruckInfoPage.clickYesButton();
    }

    @Step
    @And("Clicks No button on Change Ship Time popup")
    public void clickNoBtn() {
        log.info("Clicking No button");
        outboundTruckInfoPage.clickNoButton();
    }

    @Step
    @And("Clicks Yes button on Change Ship Time popup")
    public void clickYesBtn() {
        log.info("Clicking Yes button");
        outboundTruckInfoPage.clickYesButton();
    }

    @Step
    @And("Clicks No button on Change Door popup")
    public void clickNoChangeDoorButton() {
        log.info("Clicking No button");
        outboundTruckInfoPage.clickNoButton();
    }

    @Step
    @And("Clicks Yes button on Change Door popup")
    public void clickYesChangeDoorButton() {
        log.info("Clicking Yes button");
        outboundTruckInfoPage.clickYesButton();
    }

    @Step
    @And("Clicks OK button on Expected inbound popup")
    public void clickYesExpectedInboundButton() {
        log.info("Clicking Yes button");
        outboundTruckInfoPage.clickSaveBtn();
    }

    @Step
    @And("Clicks OK button on Shorts popup")
    public void clickOkOnShortsButton() {
        log.info("Clicking Save button");
        outboundTruckInfoPage.clickSaveBtn();
    }

    @Step
    @And("Edit route {string}")
    public void editRoute(String route) {
        log.info("Edit route " + route);
        outboundTruckInfoPage.typeRoute(route);
    }

    @Step
    @And("Edit route by index {int}")
    public void editRouteByIndex(int index) {
        log.info("Edit route by index");
        List<String> routes = List.of(outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute1(), outboundOrderLoadsDTO
                        .getOutboundRoutes().getOutboundRoute2(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute3(),
                outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute4(), outboundOrderLoadsDTO.getOutboundRoutes()
                        .getOutboundRoute5(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute6(), outboundOrderLoadsDTO
                        .getOutboundRoutes().getOutboundRoute7());
        outboundTruckInfoPage.typeRoute(routes.get(index));
    }

    @Step
    @And("Clicks Ok button on Truck Info")
    public void clickOkButton() {

            log.info("Clicking Yes button");
            outboundTruckInfoPage.clickOkBtn();
            //currentURL= outboundtruckInfoPage.navigateToTruckInfoPage();
            currentURL= driver.getCurrentUrl();


    }

    @Step
    @And("Clicks No button on Rebuilding Assignments popup")
    public void clickNoButtonOnRebuildingAssignments() {
        log.info("Clicking No button");
        outboundTruckInfoPage.clickNoBtn();
    }

    @Step
    @And("Clicks Yes button on Rebuilding Assignments popup")
    public void clickYesButtonOnRebuildingAssignments() throws InterruptedException {

            log.info("Clicking Yes button");
            outboundTruckInfoPage.clickYesBtn();
            Thread.sleep(4000);

    }

    @Step
    @And("Clicks Save button on Edit Route popup")
    public void clickSaveForEditRoute() throws InterruptedException {
        log.info("Clicking Save button");
        outboundTruckInfoPage.clickSaveBtn();
        Thread.sleep(4000);
    }

    @Step
    @And("Clicks Save button on Split task popup")
    public void clickSaveForSplitTask() {
        log.info("Clicking Save button");
        outboundTruckInfoPage.clickSaveButton();
    }

    @Step
    @And("Clicks Cancel button on Edit Route popup")
    public void clickCancelForEditRoute() {
        log.info("Clicking Cancel button");
        outboundTruckInfoPage.clickCancelBtn();
    }

    @Step
    @And("Clicks Truck Info Arrow button")
    public void clickTruckInfoArrowButton() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("scroll(250, 0)"); // if the element is on top.
            log.info("Clicking Truck Info Arrow button");
            outboundTruckInfoPage.clickTruckInfoArrow();
            outboundTruckInfoPage.clickTruckInfoArrow();


    }

    @Step
    @And("User gets all assignments from Truck diagram")
    public void setAssignments() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("scroll(250, 0)"); // if the element is on top.
            log.info("Get Assignments from Truck diagram page");
            outboundTruckInfoPage.setAssignmentsNumbersText();


            //currentURL = driver.getCurrentUrl();
            //System.out.println("Gemini 1 ==================>" + currentURL);


        //return currentURL;

    }

    @Step
    @And("return back to select ship date page in outbound load planning")
    public String return_back_to_select_ship_date_page() throws InterruptedException {
        currentURL = driver.getCurrentUrl();
        System.out.println("Gemini 1 ==================>" + currentURL);
        driver.navigate().to(currentURL);
        wait(4000);


        return currentURL;

    }

    @Step
    @And("Type {string} Ship Date on Truck Info page")
    public void changeShipDate(String date) {
        log.info("Typing Ship Date on Truck Info page " + date);
        outboundTruckInfoPage.typeShipDate(date);
    }

    @Step
    @And("Type Ship Date by index {int} on Truck Info page")
    public void changeShipDateByIndex(int index) {
        log.info("Typing Ship Date on Truck Info page by index");
        List<String> dates = List.of(outboundOrderLoadsDTO.getStartDates().getStartDate1(), outboundOrderLoadsDTO.getStartDates()
                .getStartDate2(), outboundOrderLoadsDTO.getStartDates().getStartDate3(), outboundOrderLoadsDTO.getStartDates()
                .getStartDate4(), outboundOrderLoadsDTO.getStartDates().getStartDate5(), outboundOrderLoadsDTO.getStartDates()
                .getStartDate6(), outboundOrderLoadsDTO.getStartDates().getStartDate7());
        outboundTruckInfoPage.typeShipDate(dates.get(index));
    }

    @Step
    @And("Type {string} Ship Time on Truck Info page")
    public void changeShipTime(String time) {
        log.info("Typing Ship Time on Truck Info page " + time);
        outboundTruckInfoPage.typeShipTime(time);
    }

    @Step
    @And("Clicks assignment popup header on Truck Info page")
    public void clickAssignmentPopupHeader() {
        log.info("Clicks assignment popup header on Truck Info page");
        outboundTruckInfoPage.clickAssignmentPopupHeader();
    }

    @Step
    @And("Clicks assignment popup header container on Truck Info page")
    public void clickAssignmentHeaderContainer() {
        log.info("Clicks assignment popup header container on Truck Info page");
        outboundTruckInfoPage.clickAssignmentHeaderContainer();
    }

    @Step
    @And("Clicks assignment popup footer on Truck Info page")
    public void clickAssignmentFooter() {
        log.info("Clicks assignment popup footer on Truck Info page");
        outboundTruckInfoPage.clickAssignmentFooter();
    }

    @Step
    @And("Select first assignment on Truck Info page")
    public void selectFirstAssignment() {
        log.info("Selecting first assignment on Truck Info page");
        outboundTruckInfoPage.clickFirstAssignment();
    }

    @Step
    @And("Clicks edit icon for first assignment on Assignments popup")
    public void selectEditFirstAssignment() {
        log.info("Selecting Edit first assignment on Truck Info page");
        outboundTruckInfoPage.selectEditFirstAssignment();
    }

    @Step
    @And("Clicks decrease quantity on Split task popup")
    public void clickDecreaseQuantity() {
        log.info("Click Decrease quantity on Split task popup");
        outboundTruckInfoPage.clickDecreaseValueArrow();
    }

    @Step
    @And("Clicks reason dropdown on Split task popup")
    public void clickReasonDropdown() {
        log.info("Click reason dropdown on Split task popup");
        outboundTruckInfoPage.clickReasonDropdown();
    }

    @Step
    @And("Selects reason {string} from dropdown on Split task popup")
    public void selectReasonFromDropdown(String reason) {
        log.info("Selects reason on Split task popup " + reason);
        outboundTruckInfoPage.selectReason(reason);
    }

    @Step
    @And("Drag and drop assignment from position {string} to position {string} on Truck Info page")
    public void dragAndDropAssignment(String from, String to) {
        log.info("Drag and drop assignment from position " + from + " to position " + to);
        outboundTruckInfoPage.dragAndDropAssignment(from, to);
    }

    @Step
    @And("Drag and drop assignment from position {string} to not empty position {string} on Truck Info page")
    public void dragAndDropAssignmentToExistingAssignment(String from, String to) {
        log.info("Drag and drop assignment from position " + from + " to not empty position " + to);
        outboundTruckInfoPage.dragAndDropAssignmentToExistingAssignment(from, to);
    }


}