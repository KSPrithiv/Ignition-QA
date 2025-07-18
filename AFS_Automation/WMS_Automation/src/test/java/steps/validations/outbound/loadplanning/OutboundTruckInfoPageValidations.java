package steps.validations.outbound.loadplanning;

import common.constants.FilePaths;
import common.constants.Notifications;
import common.setup.DriverManager;
import common.utils.WebDriverUtils;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import objects.outbound.OutboundOrderLoadsDTO;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import ui.pages.outbound.loadplanning.OutboundTruckInfoPage;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class OutboundTruckInfoPageValidations {
    OutboundTruckInfoPage outboundTruckInfoPage = new OutboundTruckInfoPage();
    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

    @And("Validates Truck Info trailers exist")
    public void validateTruckInfoTrailersExist() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.getTrailers().size() > 0, "Trailers do not exist");
        softAssert.assertAll();
    }

    @And("Validates Change trailer popup")
    public void validateChangeTrailerPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getDialogWindowContentText(), Notifications.CHANGE_TRAILER,
                "Change trailer popup is not present");
        softAssert.assertAll();
    }

    @And("Validates Exit button is present")
    public void validateExitPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isExitButtonDisplayed(), "Exit Button is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isExitIconDisplayed(), "Exit Icon is not present");
        softAssert.assertAll();
    }

  /*  @And("Validates First Assignment popup is present")
    public void validateAssignmentPopupPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.verifyAssignmentPopupRowsDisplayed(0) > 0,
                "Assignment Popup Rows are not present");
        softAssert.assertAll();
    }*/
  @And("Validates First Assignment popup is present")
  public void validateAssignmentPopupPresent() {
      SoftAssert softAssert = new SoftAssert();
      List<WebElement> assignments = outboundTruckInfoPage.getAssignments();

      if (assignments == null || assignments.isEmpty()) {
          softAssert.fail("No assignments found on the page.");
      } else {
          WebDriver driver = WebDriverUtils.getDriverFromElement(assignments.get(0));

          int rows = outboundTruckInfoPage.verifyAssignmentPopupRowsDisplayed(driver);
          softAssert.assertTrue(rows > 0, "Assignment Popup Rows are not present");
      }

      softAssert.assertAll();
  }







    @And("Validates Assignment details on popup")
    public void validateAssignmentPopupDetails() {
        SoftAssert softAssert = new SoftAssert();
        outboundTruckInfoPage.getAssignmentPopupRows(0).stream()
                .map(row -> row.findElement(By.xpath(".//div[contains(@class, 'lp_overlayChildUM')]")))
                .forEach(el -> {
                    softAssert.assertTrue(el.isDisplayed(), "Assignment code is not displayed");
                });
        outboundTruckInfoPage.getAssignmentPopupRows(0).stream()
                .map(row -> row.findElement(By.xpath(".//div[contains(@class, 'lp_overlayChildPID')]")))
                .forEach(el -> {
                    softAssert.assertTrue(el.isDisplayed(), "Assignment id is not displayed");
                });
        outboundTruckInfoPage.getAssignmentPopupRows(0).stream()
                .map(row -> row.findElement(By.xpath(".//div[contains(@class, 'lp_overlayChildPLoc')]")))
                .forEach(el -> {
                    softAssert.assertTrue(el.isDisplayed(), "Assignment location is not displayed");
                });
        outboundTruckInfoPage.getAssignmentPopupRows(0).stream()
                .map(row -> row.findElement(By.xpath(".//div[contains(@class, 'lp_overlayChildPNAME')]")))
                .forEach(el -> {
                    softAssert.assertTrue(el.isDisplayed(), "Assignment product is not displayed");
                });
        outboundTruckInfoPage.getAssignmentPopupRows(0).stream()
                .map(row -> row.findElement(By.xpath(".//div[contains(@class, 'lp_overlayChildIcon')]")))
                .forEach(el -> {
                    softAssert.assertTrue(el.isDisplayed(), "Edit Assignment is not displayed");
                });
        softAssert.assertAll();
    }

    @And("Validates Split task popup displayed")
    public void validateSplitTaskPopupDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getWindowTitleText(), Notifications.SPLIT_TASK, "Split task title is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isQuantityDisplayed(), "Quantity is not displayed");
       // softAssert.assertTrue(outboundTruckInfoPage.isReasonDropdownDisplayed(), "Quantity is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isSplitTaskPopupDisplayed(), "Quantity is not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed on Split Task")
    public void validateNotificationOnSplitTaskDetails(String notification) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getNotificationText(), notification, "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Assignment is selected with the blue border on Split Task")
    public void validateAssignmentIsBlueOnSplitTaskDetails() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isAssignmentBorderBlue(), "Assignment selected is not with blue border");
        softAssert.assertAll();
    }

    @And("Validates Exit, Work, Edit, Reprocess, Recalculate and Key buttons are present")
    public void validateTruckInfoPanelPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isExitButtonDisplayed(), "Exit Button is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isWorkButtonDisplayed(), "Work Button is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isEditButtonDisplayed(), "Edit Button is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isReprocessButtonDisplayed(), "Reprocess Button is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isRecalculateButtonDisplayed(), "Recalculate Button is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isKeyButtonDisplayed(), "Key Button is not present");
        softAssert.assertAll();
    }

    @And("Validates Exit, Work, Edit, Reprocess, Recalculate and Key buttons are not present")
    public void validateTruckInfoPanelNotPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(outboundTruckInfoPage.isExitButtonDisplayed(), "Exit Button is present");
        softAssert.assertFalse(outboundTruckInfoPage.isWorkButtonDisplayed(), "Work Button is present");
        softAssert.assertFalse(outboundTruckInfoPage.isEditButtonDisplayed(), "Edit Button is present");
        softAssert.assertFalse(outboundTruckInfoPage.isReprocessButtonDisplayed(), "Reprocess Button is present");
        softAssert.assertFalse(outboundTruckInfoPage.isRecalculateButtonDisplayed(), "Recalculate Button is present");
        softAssert.assertFalse(outboundTruckInfoPage.isKeyButtonDisplayed(), "Key Button is present");
        softAssert.assertAll();
    }

    @And("Validates Inbound link is present")
    public void validateInboundPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isInboundLinkDisplayed(), "Inbound link is not present");
        softAssert.assertAll();
    }

    @And("Validates Shorts link is present")
    public void validateShortsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isShortsLinkDisplayed(), "Shorts link is not present");
        softAssert.assertAll();
    }

    @And("Validates Position and Pallets are present")
    public void validatePositionAndPalletsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isPositionsLabelDisplayed(), "Positions Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isPositionsValueDisplayed(), "Positions Value is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isPalletsLabelDisplayed(), "Pallets Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isPalletsValueDisplayed(), "Pallets Value is not present");
        softAssert.assertAll();
    }

    @And("Validates Trailer Cube is present")
    public void validateTrailerCubePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isTrailerCubeLabelDisplayed(), "Trailer Cube Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isTrailerCubeValueDisplayed(), "Trailer Cube Value is not present");
        softAssert.assertAll();
    }

    @And("Validates Route Cube is present")
    public void validateRouteCubePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isRouteCubeLabelDisplayed(), "Route Cube Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isRouteCubeValueDisplayed(), "Route Cube Value is not present");
        softAssert.assertAll();
    }

    @And("Validates Trailer Weight is present")
    public void validateTrailerWeightPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isTrailerWeightLabelDisplayed(), "Trailer Weight Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isTrailerWeightValueDisplayed(), "Trailer Weight Value is not present");
        softAssert.assertAll();
    }

    @And("Validates Route Weight is present")
    public void validateRouteWeightPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isRouteWeightLabelDisplayed(), "Route Weight Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isRouteWeightValueDisplayed(), "Route Weight Value is not present");
        softAssert.assertAll();
    }

    @And("Validates Route Weight is displayed in RED color if Route Weight is greater than Trailer Weight")
    public void validateRouteWeightDisplayedInRed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isRouteWeightGreaterTrailerWeight(), "Route Weight is greater then Trailer Weight");
        softAssert.assertAll();
    }

    @And("Validates Expected inbound popup is displayed")
    public void validateExpectedInboundDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getWindowTitleText(), Notifications.EXPECTED_INBOUND,
                "Expected Inbound is not present");
        softAssert.assertAll();
    }

    @And("Validates Shorts popup is displayed")
    public void validateShortsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getWindowTitleText(), Notifications.SHORTS,
                "Shorts is not present");
        softAssert.assertAll();
    }

    @And("Validates Expected inbound table is displayed")
    public void validateExpectedInboundTableDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isTableGridDisplayed(),"Table Grid is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Shorts table is displayed")
    public void validateShortsTableDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isTableGridDisplayed(),"Table Grid is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Route label, Ship Date and Time, Trailer and Door dropdowns, Inbound and Shorts links are present")
    public void validateTruckInfoPanelWithShipDateAndTimePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isRouteLabelDisplayed(), "Route Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isShipDateInputDisplayed(), "Ship Date is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isShipTimeInputDisplayed(), "Ship Time is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isTrailerDropDownDisplayed(), "Trailer dropdown is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isDoorDropDownDisplayed(), "Door dropdown is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isInboundLinkDisplayed(), "Inbound link is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isShortsLinkDisplayed(), "Shorts link is not present");
        softAssert.assertAll();
    }

    @And("Validates Type label, Positions label, Trailer and Route cubes, Trailer and Route weights are present")
    public void validateTruckInfoPanelWithTrailerAndRouteCubesPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isTypeLabelDisplayed(), "Type Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isPositionsLabelDisplayed(), "Positions Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isTrailerCubeLabelDisplayed(), "Trailer Cube Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isRouteCubeLabelDisplayed(), "Route Cube Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isTrailerWeightLabelDisplayed(), "Trailer Weight Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isRouteWeightLabelDisplayed(), "Route Weight Label is not present");
        softAssert.assertAll();
    }

    @And("Validates Type label and Type value are present")
    public void validateTypeLabelAndValuePresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isTypeLabelDisplayed(), "Type Label is not present");
        softAssert.assertTrue(outboundTruckInfoPage.isTypeValueDisplayed(), "Type Value is not present");
        softAssert.assertAll();
    }

    @And("Validates Trailer Type value is not empty")
    public void validateTypeValueNotEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!outboundTruckInfoPage.getTrailerTypeText().equals(StringUtils.EMPTY), "Trailer Type is empty");
        softAssert.assertAll();
    }

    @And("Validates Warning Message popup content for Exit button")
    public void validateWarningMessageRouteExceedsTrailerPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.getWarningMessageText().contains(Notifications.ROUTE_CUBE_WEIGHT_EXCEEDS_TRAILER_CUBE_WEIGHT),
                "'Route cube/weight exceeds trailer cube/weight.' message is not present");
        softAssert.assertTrue(outboundTruckInfoPage.getWarningMessageText().contains(Notifications.CONTINUE),
                "'Continue?' message is not present");
        softAssert.assertAll();
    }

    @And("Validates Warning Message 'Right and left sides of trailer are not balanced.' for Exit button")
    public void validateWarningMessageTrailerAreNotBalanced() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.getWarningMessageText().contains(Notifications.TRAILER_SIDES_NOT_BALANCED),
                "Right and left sides of trailer are not balanced.' message is not present");
        softAssert.assertAll();
    }



    @And("Validates Warning Message that Assignment cube and weight exceeds max cube and weight for Exit button")
    public void validateWarningMessageAssignmentCubeWeightExceedsMax() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.getWarningMessageText().contains(Notifications.ASSIGNMENT_CUBE_WEIGHT_EXCEEDS_MAX_CUBE_WEIGHT),
                "Right and left sides of trailer are not balanced.' message is not present");
        softAssert.assertAll();
    }

    @And("Validates Yes and No buttons are present")
    public void validateYesNoButtons() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isYesBtnDisplayed(),"Yes button is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isNoBtnDisplayed(),"No button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Yes and No buttons are displayed")
    public void validateYesNoButtonsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isYesButtonDisplayed(),"Yes button is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isNoButtonDisplayed(),"No button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Yes button is active")
    public void validateYesBtnIsActive() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By yesButtonLocator = By.xpath("//button[.//span[text()='Yes'] and contains(@class, 'k-button')]");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(yesButtonLocator));
            wait.until(ExpectedConditions.elementToBeClickable(yesButtonLocator));
            WebElement yesBtn = driver.findElement(yesButtonLocator);

            boolean isEnabled = yesBtn.isEnabled();
            boolean isDisplayed = yesBtn.isDisplayed();

            softAssert.assertTrue(isEnabled && isDisplayed, "Yes button is not active or not visible");
        } catch (Exception e) {
            softAssert.fail("Failed to find or validate Yes button: " + e.getMessage());
        }

        softAssert.assertAll();
    }





    @And("Validates that Route {string} for Truck Info is correct")
    public void validateRouteIsCorrect(String route) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.getRouteName().contains(route), "Route is not correct on Truck Info");
        softAssert.assertAll();
    }

    @And("Validates that Route by index {int} for Truck Info is correct")
    public void validateRouteByIndexIsCorrect(int index) {
        List<String> routes = List.of(outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute1(), outboundOrderLoadsDTO
                .getOutboundRoutes().getOutboundRoute2(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute3(),
                 outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute4(), outboundOrderLoadsDTO.getOutboundRoutes()
                .getOutboundRoute5(), outboundOrderLoadsDTO.getOutboundRoutes().getOutboundRoute6(), outboundOrderLoadsDTO
                .getOutboundRoutes().getOutboundRoute7());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.getRouteName().contains(routes.get(index)), "Route is not correct on Truck Info");
        softAssert.assertAll();
    }

    @And("Validates Truck diagram with details is displayed")
    public void validateTruckDiagramDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isTruckDiagramLabelDisplayed(), "Truck Diagram Label is displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isTruckInfoArrowDisplayed(), "Truck Info Arrow is displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isLoadPlanningScrollDisplayed(), "Load Planning Scroll is displayed");
        softAssert.assertAll();
    }

    @And("Validates Rebuilding assignments complete popup is displayed")
    public void validateRebuildingAssignmentsCompleteDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getWarningMessageText(), Notifications.REBUILDING_ASSIGNMENTS_COMPLETE, "Rebuilding assignments complete is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Rebuilding assignments popup is displayed")
    public void validateRebuildAssignmentsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getWarningMessageText(), Notifications.REBUILD_ASSIGNMENTS,
                "Rebuilding assignments content message is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit route fields popup is displayed")
    public void validateEditRouteFieldsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getWindowTitleText(), Notifications.EDIT_ROUTE_FIELDS,
                "Edit route fields is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Rebuilding Assignments is displayed")
    public void validateRebuildingAssignmentsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getWindowTitleText(), Notifications.REBUILDING_ASSIGNMENTS,
                "Rebuilding Assignments is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit Form Control is displayed")
    public void validateEditFormControlDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isEditFormControlDisplayed(),"Edit Form Control is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isEditFormControlDisplayed(),"Edit Form Control is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Edit Form Control Input {string} value is correct")
    public void validateEditFormControlDisplayed(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getEditFormControlInputValue().toUpperCase(), value.toUpperCase(),
                "Edit Form Control value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Save and Cancel buttons are displayed on Truck Info Page")
    public void validateSaveAndCancelButtonsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isSaveBtnDisplayed(),"Save button is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isCancelBtnDisplayed(),"Cancel button is not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed for Edit Route")
    public void verifySuccessNotificationWindow(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates {string} notification is displayed for Exit Load Planning")
    public void verifySuccessNotificationWindowForExitLoadPlanning(String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getNotificationMsg().getText().trim(), message,
                "Notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Pallet key popup")
    public void verifyPalletKeyPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isPalletHeadDisplayed(),"Pallet Head is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isPalletContentTopDisplayed(),"Pallet Content Top is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isPalletContentBottomDisplayed(),"Pallet Content Bottom is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isPalletKeyTitleDisplayed(),"Pallet Key Title is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isWaitingToBePickedDisplayed(),"Waiting To Be Picked is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isWaitingToBeLoadedDisplayed(),"Waiting To Be Loaded is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isLoadedDisplayed(),"Loaded is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isPalletDoesNotFitDisplayed(),"Pallet Does Not Fit is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isFreezerItemsDisplayed(),"Freezer Items is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isCoolerItemsDisplayed(),"Cooler Items is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isDryGoodsDisplayed(),"Dry Goods is not displayed");
        softAssert.assertAll();
    }

    @And("Validates that Ship date and time displayed on Truck Info Page")
    public void validatesThatShipDateTimeDisplayedOnTruckInfoPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.isShipDateInputDisplayed(), "Ship Date Input is not displayed");
        softAssert.assertTrue(outboundTruckInfoPage.isShipTimeInputDisplayed(), "Ship Time Input is not displayed");
        softAssert.assertAll();
    }

    @And("Validates change Ship Date notification")
    public void verifyChangeShipDatePopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getDialogWindowContentText(),  Notifications.CHANGE_SHIPDATE,
                "Change Ship Date notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Ship Date {string} value")
    public void verifyChangeShipDateValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getShipDateValue(), value,"Ship Date value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Ship Date by index {int} value")
    public void verifyChangeShipDateValueByIndex(int index) {
        List<String> dates = List.of(outboundOrderLoadsDTO.getStartDates().getStartDate1(), outboundOrderLoadsDTO.getStartDates()
                .getStartDate2(), outboundOrderLoadsDTO.getStartDates().getStartDate3(), outboundOrderLoadsDTO.getStartDates()
                .getStartDate4(), outboundOrderLoadsDTO.getStartDates().getStartDate5(), outboundOrderLoadsDTO.getStartDates()
                .getStartDate6(), outboundOrderLoadsDTO.getStartDates().getStartDate7());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getShipDateValue(), dates.get(index),"Ship Date value is not correct");
        softAssert.assertAll();
    }

    @And("Validates change Ship Time notification")
    public void verifyChangeShipTimePopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getDialogWindowContentText(),  Notifications.CHANGE_SHIPTIME,
                "Change Ship Time notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates change Door notification")
    public void verifyChangeDoorPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getDialogWindowContentText(),  Notifications.CHANGE_DOOR,
                "Change Door notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Release assignments notification")
    public void verifyReleaseAssignmentsPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getDialogWindowContentText(),  Notifications.RELEASE_ASSIGNMENTS,
                "Release assignments notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Move to new assignment notification")
    public void verifyMoveAssignmentsPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getDialogWindowContentText(),  Notifications.MOVE_ASSIGNMENTS,
                "Move to new assignment notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Move to new position notification")
    public void verifyMoveToNewPositionPopup() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.getDialogWindowContentText().contains(Notifications.MOVE_TO_POSITION),
                "Move to new position notification is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Ship Time {string} value")
    public void verifyChangeShipTimeValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getShipTimeValue(), value,"Ship Time value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Door {string} value")
    public void verifyDoorValue(String value) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outboundTruckInfoPage.getDoorDropDownText(), value,"Door value is not correct");
        softAssert.assertAll();
    }

    @And("Validates assignments are present")
    public void verifyAssignmentsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(outboundTruckInfoPage.verifyAssignmentsDisplayed() > 0,"Assignments are not present");
        softAssert.assertAll();
    }

}
