package steps.validations.outbound.processing;

import common.constants.FilePaths;
import common.constants.Notifications;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import objects.outbound.OutboundOrderLoadsDTO;
import org.testng.asserts.SoftAssert;
import ui.pages.outbound.processing.AddAllocationBatchPage;

import java.util.List;

public class AddAllocationBatchPageValidations {
    AddAllocationBatchPage addAllocationBatchPage = new AddAllocationBatchPage();
    OutboundOrderLoadsDTO outboundOrderLoadsDTO = new ObjectMapperWrapper()
            .getObject(FilePaths.OUTBOUND_ORDER_LOAD_DATA, OutboundOrderLoadsDTO.class);

    @And("Validate Add Allocation Batch page is displayed")
    public void validateAddAllocationBatchPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addAllocationBatchPage.isCodeLabelDisplayed(), "Code Label is not present");
        softAssert.assertTrue(addAllocationBatchPage.isCodeInputDisplayed(), "Code Input is not present");
        softAssert.assertTrue(addAllocationBatchPage.isBatchLabelDisplayed(), "Batch Label is not present");
        softAssert.assertTrue(addAllocationBatchPage.isBatchInputDisplayed(), "Batch Input is not present");
        softAssert.assertTrue(addAllocationBatchPage.isCancelButtonDisplayed(), "Cancel Button is not present");
        softAssert.assertTrue(addAllocationBatchPage.isSaveButtonDisplayed(), "Save Button is not present");
        softAssert.assertAll();
    }

    @And("Validates Add Allocation Batch page title is correct")
    public void validateAddAllocationBatchPageTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addAllocationBatchPage.getTitle(), Notifications.BATCH_ALLOCATION_TITLE
                , "Batch Title is not correct");
        softAssert.assertAll();
    }

    @And("Validates Successful title {string} and message {string}")
    public void validateSuccessfulNotification(String title, String message) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addAllocationBatchPage.getNotificationTitleText(), title, "Notification Title is not correct");
        softAssert.assertEquals(addAllocationBatchPage.getNotificationMessageText(), message, "Notification Message is not correct");
        softAssert.assertAll();
    }

    @And("Validates batch code value")
    public void validateBatchCodeValue() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addAllocationBatchPage.getBatchCodeValue(), AddAllocationBatchPage.getBatchName(), "Batch Code Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates invalid batch code {string}")
    public void validateBatchCodeValue(String code) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addAllocationBatchPage.getBatchCodeValue(), code, "Batch Code Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates Batch Type {string} is displayed")
    public void validateBatchTypeIsDisplayed(String type) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addAllocationBatchPage.isBatchTypeDropDownDisplayed(type),
                    "Batch Type " + type + " is not Displayed");
        softAssert.assertAll();
    }

    @And("Validates Batch Type by index {int} is displayed")
    public void validateBatchTypeByIndexIsDisplayed(int index) {
        List<String> types = List.of(outboundOrderLoadsDTO.getOutboundBatches().getOutboundBatch1(), outboundOrderLoadsDTO
                .getOutboundBatches().getOutboundBatch2(), outboundOrderLoadsDTO.getOutboundBatches().getOutboundBatch3());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addAllocationBatchPage.isBatchTypeDropDownDisplayed(types.get(index)),
                "Batch Type " + types.get(index) + " is not Displayed");
        softAssert.assertAll();
    }

}
