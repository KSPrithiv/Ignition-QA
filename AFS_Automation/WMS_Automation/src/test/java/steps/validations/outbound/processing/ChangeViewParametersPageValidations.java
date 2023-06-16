package steps.validations.outbound.processing;

import common.constants.FilePaths;
import common.constants.Notifications;
import common.enums.Sources;
import common.utils.database.DataBaseConnection;
import common.utils.database.SqlQueriesUtils;
import common.utils.database.StoreProceduresUtils;
import common.utils.objectmapper.ObjectMapperWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import objects.orderdata.ProcessingOrderDTO;
import objects.storeproceduresdata.outbound.ProcessingParams;
import objects.userdata.DataBaseData;
import org.testng.asserts.SoftAssert;
import steps.LoginPageSteps;
import ui.pages.outbound.processing.ChangeViewParametersPage;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeViewParametersPageValidations {
    StoreProceduresUtils storeProceduresUtils = new StoreProceduresUtils();
    SqlQueriesUtils sqlQueriesUtils = new SqlQueriesUtils();

    @And("Validates Change View Parameters page")
    public void validateChangeViewParametersPage() {
        ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(changeViewParametersPage.isPageTitleDisplayed(), "Page Title is not visible");
        softAssert.assertTrue(changeViewParametersPage.isSourceLabelDisplayed(), "Source Label is not present");
        softAssert.assertTrue(changeViewParametersPage.isSourceValueDisplayed(), "Source Value is not present");
        softAssert.assertTrue(changeViewParametersPage.isOrder2InputDisplayed(), "Order2 Input is not present");
        softAssert.assertTrue(changeViewParametersPage.isOrder5InputDisplayed(), "Order5 Input is not present");
        softAssert.assertTrue(changeViewParametersPage.isCarrierCodeInputDisplayed(), "Carrier Code Input is not present");
        softAssert.assertTrue(changeViewParametersPage.isCarrierCodeDropdownDisplayed(), "Carrier Code Dropdown is not present");
        softAssert.assertTrue(changeViewParametersPage.isOrderTypeLabelDisplayed(), "Order Type Label is not present");
        softAssert.assertTrue(changeViewParametersPage.isOrderTypeDropDownDisplayed(), "Order Type DropDown is not present");
        softAssert.assertTrue(changeViewParametersPage.isOrderTypeLabelDisplayed(), "Order Type Label is not present");
        softAssert.assertTrue(changeViewParametersPage.isOrderTypeDropDownDisplayed(), "Order Type DropDown is not present");
        softAssert.assertTrue(changeViewParametersPage.isOwnerLabelDisplayed(), "Owner Label is not present");
        softAssert.assertTrue(changeViewParametersPage.isOwnerDropdownDisplayed(), "Owner Dropdown is not present");
        softAssert.assertTrue(changeViewParametersPage.isProductLabelPopupDisplayed(), "Product Label Popup is not present");
        softAssert.assertTrue(changeViewParametersPage.isProductInputDisplayed(), "Product Input is not present");
        softAssert.assertTrue(changeViewParametersPage.isLotLabelDisplayed(), "Lot Label is not present");
        softAssert.assertTrue(changeViewParametersPage.isLotInputDisplayed(), "Lot Input is not present");
        softAssert.assertTrue(changeViewParametersPage.isStartDateLabelDisplayed(), "Start Date Label is not present");
        softAssert.assertTrue(changeViewParametersPage.isStartDateDisplayed(), "Start Date is not present");
        softAssert.assertTrue(changeViewParametersPage.isEndDateLabelDisplayed(), "End Date Label is not present");
        softAssert.assertTrue(changeViewParametersPage.isEndDateDisplayed(), "End Date is not present");
        softAssert.assertAll();
    }
    @And("Validates start date is displayed on Change View Parameters page")
    public void validateStartDateIsDisplayed() {
        ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!changeViewParametersPage.getStartDateValue().isEmpty(), "Start Date is not empty");
        softAssert.assertAll();
    }

    @And("Validates end date is displayed on Change View Parameters page")
    public void validateEndDateIsDisplayed() {
        ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!changeViewParametersPage.getEndDateValue().isEmpty(), "End Date is not empty");
        softAssert.assertAll();
    }

    @And("Validates Change View Parameters page title")
    public void validateGetTitle() {
        ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(changeViewParametersPage.getTitle(), Notifications.CHANGE_VIEW_PARAMS,
                "Change View Parameters title is not correct");
        softAssert.assertAll();
    }

    @And("Validates Ok button is active")
    public void validateOkButtonIsActive() {
        ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!changeViewParametersPage.getOkButtonAttribute().contains("k-flat"),
                "OK button is not selected");
        softAssert.assertAll();
    }
   @SneakyThrows
    @Then("Validates Order number")
    public void validateOrderNo() {
        DataBaseData dataBaseData = DataBaseData.builder()
                .username(LoginPageSteps.environment.getDbUserName())
                .password(LoginPageSteps.environment.getDbUserPassword())
                .host(LoginPageSteps.environment.getDbIp())
                .schema(LoginPageSteps.environment.getDbName())
                .build();
        ResultSet usersData = sqlQueriesUtils.getCurrentValidUser(DataBaseConnection
                .getDataBaseConnection(dataBaseData), "Ignition WMS");
        int userId = usersData.getInt(1);
        ProcessingParams processingParams = new ObjectMapperWrapper()
                .getObject(FilePaths.PROCESSING_DATA, ProcessingParams.class);
        processingParams.setSelected_date("2022-01-01");
        processingParams.setEnd_date("2022-03-01");
        processingParams.setSource("001001");
        processingParams.setCurrentuser_id(userId);
        ResultSet resultSet = storeProceduresUtils.executeStoreProcedureGetFilteredOrderProcessingList(DataBaseConnection
                .getDataBaseConnection(dataBaseData), processingParams);
        List<ProcessingOrderDTO> processingOrderDTO = new ArrayList<>();
        do {
            processingOrderDTO.add(ProcessingOrderDTO.builder()
                    .order(resultSet.getString(2).trim())
                    .shipDate(resultSet.getString(8).trim())
                    .source(resultSet.getString(9).trim())
                    .build());
        } while(resultSet.next());
        DataBaseConnection.closeDataBaseConnection();
        ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(changeViewParametersPage.getOrderNoText(), processingOrderDTO.get(0).getOrder(),
                "Order Value is not correct");
        softAssert.assertAll();
    }

    @And("Validates other Source options on Change View Parameters page")
    public void validateSourceOptions() {
        ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
        SoftAssert softAssert = new SoftAssert();
        List<String> options = Arrays.asList(changeViewParametersPage.getSourceValues().split("\\n"));
        softAssert.assertTrue(options.contains(Sources.DEFAULT.getSource()), "Default source does not present");
        softAssert.assertTrue(options.contains(Sources.ACCOUNT.getSource()), "Account source does not present");
        softAssert.assertTrue(options.contains(Sources.SUPPLIER.getSource()), "Supplier source does not present");
        softAssert.assertTrue(options.contains(Sources.WAREHOUSE.getSource()), "Warehouse source does not present");
        softAssert.assertAll();
    }
    @And("Validates source Default value")
    public void validateSourceDefaultValue() {
        ChangeViewParametersPage changeViewParametersPage = new ChangeViewParametersPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(changeViewParametersPage.getSourceFieldText(), Sources.DEFAULT.getSource(),
                "Source Default value is not correct");
        softAssert.assertAll();
    }

}
