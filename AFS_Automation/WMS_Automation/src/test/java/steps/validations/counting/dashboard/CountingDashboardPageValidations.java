package steps.validations.counting.dashboard;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.counting.dashboard.CountingDashboardPage;

public class CountingDashboardPageValidations {
    CountingDashboardPage countingDashboardPage = new CountingDashboardPage();

    @And("Validates Counting Dashboard page is displayed")
    public void validateCountingCountPageDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingDashboardPage.isDashboardPageTitleDisplayed(), "Counting Page title is not displayed");
        softAssert.assertTrue(countingDashboardPage.isCountSessionLabelDisplayed(), "Session Label is not displayed");
        softAssert.assertTrue(countingDashboardPage.isCountSessionDisplayed(), "Session dropdown is not displayed");
        softAssert.assertTrue(countingDashboardPage.isCountAssignmentLabelDisplayed(), "Assignment Label is not displayed");
        softAssert.assertTrue(countingDashboardPage.isCountAssignmentDisplayed(), "Assignment dropdown is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Location and Product tabs are displayed on Counting Dashboard page")
    public void validateLocationProductTabsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingDashboardPage.isLocationTabDisplayed(), "Location Tab is not displayed");
        softAssert.assertTrue(countingDashboardPage.isProductTabDisplayed(), "Product Tab is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Locations counted dashboard and Locations with discrepancies are displayed on Counting Dashboard page")
    public void validateLocationDashboardDetailsAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingDashboardPage.isLocationCountedCardGuageDisplayed(), "Location Counted Card Guage is not displayed");
        softAssert.assertTrue(countingDashboardPage.isLocDiscrepanciesTitleDisplayed(), "Locations with discrepancies is not displayed");
        softAssert.assertTrue(countingDashboardPage.isCardDiscrepancyDisplayed(), "Card Discrepancy is not displayed");
        softAssert.assertTrue(countingDashboardPage.isCountedLabelDisplayed(), "Counted Label is not displayed");
        softAssert.assertTrue(countingDashboardPage.isOnHandLabelDisplayed(), "OnHand Label is not displayed");
        softAssert.assertAll();
    }

    @And("Validates Products counted dashboard and Products with discrepancies are displayed on Counting Dashboard page")
    public void validateProductDashboardDetailsAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countingDashboardPage.isProductCountedCardGuageDisplayed(), "Products Counted Card Guage is not displayed");
        softAssert.assertTrue(countingDashboardPage.isProdDiscrepanciesTitleDisplayed(), "Products with discrepancies is not displayed");
        softAssert.assertTrue(countingDashboardPage.isCardDiscrepancyDisplayed(), "Card Discrepancy is not displayed");
        softAssert.assertTrue(countingDashboardPage.isCountedLabelDisplayed(), "Counted Label is not displayed");
        softAssert.assertTrue(countingDashboardPage.isOnHandLabelDisplayed(), "OnHand Label is not displayed");
        softAssert.assertAll();
    }

}
