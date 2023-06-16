package steps.validations.inbound.loads;

import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import ui.pages.inbound.loads.InboundLoadPage;

public class InboundLoadPageValidations {

    @And("Validates Inbound Load page contains all web elements")
    public void validateInboundLoadPage() {
        InboundLoadPage inboundLoadPage = new InboundLoadPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inboundLoadPage.isSummaryRouteHeaderPresent(), "Summary Route Header is not Present");
        softAssert.assertTrue(inboundLoadPage.checkLoadCardsSize(), "Load Cards are not displayed");
        softAssert.assertTrue(inboundLoadPage.isBarContainerPresent(), "Bar Container is not displayed");
        softAssert.assertTrue(inboundLoadPage.isToolBarContainerPresent(), "Tool Bar Container is not displayed");
        softAssert.assertAll();
    }
}
