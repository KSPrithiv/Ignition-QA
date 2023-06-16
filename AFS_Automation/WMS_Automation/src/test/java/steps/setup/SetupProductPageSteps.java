package steps.setup;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.setup.SetupProductPage;

@Slf4j
public class SetupProductPageSteps {
    SetupProductPage setupProductPage = new SetupProductPage();

    @Step
    @And("Waits for Setup Product page to load")
    public void waitSetupProductPageToLoad() {
        log.info("Waiting for Setup Product Page To Load");
        setupProductPage.waitSetupProductPageToLoad();
    }

    @Step
    @And("User selects product {string} on Setup Product page")
    public void selectProduct(String product) {
        log.info("User selects product on Setup Product page");
        setupProductPage.selectProduct(product);
    }

    @Step
    @And("User clicks Edit on Setup Product page")
    public void clickEditProduct() {
        log.info("User clicks Edit on Setup Product page");
        setupProductPage.clickEditProduct();
    }

    @Step
    @And("User clicks Delete on Setup Product page")
    public void clickDeleteButton() {
        log.info("User clicks Delete on Setup Product page");
        setupProductPage.clickDeleteButton();
    }

    @Step
    @And("User clicks Cancel on Setup Product page")
    public void clickCancelButton() {
        log.info("User clicks Cancel on Setup Product page");
        setupProductPage.clickCancelButton();
    }

    @Step
    @And("User clicks Edit button on Setup Product page")
    public void clickEditBtn() {
        log.info("User clicks Edit button on Setup Product page");
        setupProductPage.clickEditBtn();
    }

    @Step
    @And("User clicks Delete button on Setup Product page")
    public void clickDeleteBtn() {
        log.info("User clicks Delete button on Setup Product page");
        setupProductPage.clickDeleteBtn();
    }

    @Step
    @And("User clicks Delete Settings button on Setup Product page")
    public void clickDeleteSettingsBtn() {
        log.info("User clicks Delete Settings button on Setup Product page");
        setupProductPage.clickDeleteSettingsBtn();
    }

    @Step
    @And("User clicks Edit Settings button on Setup Product page")
    public void clickEditSettingsBtn() {
        log.info("User clicks Edit Settings button on Setup Product page");
        setupProductPage.clickEditSettingsBtn();
    }

    @Step
    @And("User clicks Shipping tab on Setup Product page")
    public void clickShippingTab() {
        log.info("User clicks Shipping tab on Setup Product page");
        setupProductPage.clickShippingTab();
    }

    @Step
    @And("User clicks Date encoding dropdown on Setup Product page")
    public void clickDateEncodingDropDown() {
        log.info("User clicks Date encoding dropdown on Setup Product page");
        setupProductPage.clickDateEncodingDropDown();
    }

    @Step
    @And("Checks individual catch weight checkbox on Setup Product page")
    public void checkIndividualCatchWeight() {
        log.info("Checks individual catch weight checkbox on Setup Product page");
        setupProductPage.checkIndividualCatchWeight();
    }

    @Step
    @And("Clicks Save on Setup Product page")
    public void clickSave() {
        log.info("Clicks Save on Setup Product page");
        setupProductPage.clickSaveButton();
    }

    @Step
    @And("Clicks Save on popup on Setup Product page")
    public void clickSaveOnPopup() {
        log.info("Clicks Save on popup on Setup Product page");
         setupProductPage.clickSave();
    }

    @Step
    @And("Clicks Date encoding Label on Setup Product page")
    public void clickDateEncodingLabel() {
        log.info("Clicks Date encoding Label on Setup Product page");
        setupProductPage.clickDateEncodingLabel();
    }

    @Step
    @And("Clicks Encoding Label on Setup Product page")
    public void clickEncodingLabel() {
        log.info("Clicks Encoding Label on Setup Product page");
        setupProductPage.clickEncodingLabel();
    }

    @Step
    @And("Clicks Used By Tab Label on Setup Product page")
    public void clickUsedByTabLabel() {
        log.info("Clicks Used By Tab Label on Setup Product page");
        setupProductPage.clickUsedByTabLabel();
    }

    @Step
    @And("Clicks Day Mapping Label on Setup Product page")
    public void clickDayMappingTabLabel() {
        log.info("Clicks Day Mapping Label on Setup Product page");
        setupProductPage.clickDayMappingTabLabel();
    }

    @Step
    @And("Clicks Month Mapping Label on Setup Product page")
    public void clickMonthMappingTabLabel() {
        log.info("Clicks Month Mapping Label on Setup Product page");
        setupProductPage.clickMonthMappingTabLabel();
    }

    @Step
    @And("Clicks Year Mapping Label on Setup Product page")
    public void clickYearMappingTabLabel() {
        log.info("Clicks Year Mapping Label on Setup Product page");
        setupProductPage.clickYearMappingTabLabel();
    }

    @Step
    @And("Clicks Week Mapping Label on Setup Product page")
    public void clickWeekMappingTabLabel() {
        log.info("Clicks Week Mapping Label on Setup Product page");
        setupProductPage.clickWeekMappingTabLabel();
    }

    @Step
    @And("Clicks Add new on Setup Product page")
    public void clickAddNewProduct() {
        log.info("Clicks Add new on Setup Product page");
        setupProductPage.clickAddNewProduct();
    }

    @Step
    @And("Clicks Add on Setup Product page")
    public void clickAddNew() {
        log.info("Clicks Add on Setup Product page");
        setupProductPage.clickAddNew();
    }

    @Step
    @And("Clicks Add on Date encoding popup on Setup Product page")
    public void clickAdd() {
        log.info("Clicks Add on Date encoding popup on Setup Product page");
        setupProductPage.clickAdd();
    }

    @Step
    @And("Clicks Edit on Date encoding popup on Setup Product page")
    public void clickEdit() {
        log.info("Clicks Edit on Date encoding popup on Setup Product page");
        setupProductPage.clickEdit();
    }

    @Step
    @And("Clicks Delete on Date encoding popup on Setup Product page")
    public void clickDelete() {
        log.info("Clicks Delete on Date encoding popup on Setup Product page");
        setupProductPage.clickDelete();
    }

    @Step
    @And("Types character {string} on Date encoding popup on Setup Product page")
    public void typeCharacter(String character) {
        log.info("Types character on Date encoding popup on Setup Product page");
        setupProductPage.typeCharacter(character);
    }

    @Step
    @And("Types value {string} on Date encoding popup on Setup Product page")
    public void typeValue(String value) {
        log.info("Types value on Date encoding popup on Setup Product page");
        setupProductPage.typeValue(value);
    }

    @Step
    @And("Clicks Add Date Encoding on Setup Product page")
    public void clickAddDateEncoding() {
        log.info("Clicks Add Date Encoding on Setup Product page");
        setupProductPage.clickAddDateEncoding();
    }

    @Step
    @And("Clicks Extract date as dropdown on Setup Product page")
    public void clickExtractDateAsDropDown() {
        log.info("Clicks Extract date as dropdown on Setup Product page");
        setupProductPage.clickExtractDateAsDropDown();
    }

    @Step
    @And("Selects Extract date as {string} on Setup Product page")
    public void selectExtractDateAs(String date) {
        log.info("Selects Extract date as on Setup Product page");
        setupProductPage.selectExtractDateAs(date);
    }

    @Step
    @And("Clicks Day Mapping dropdown on Setup Product page")
    public void clickDayMappingDropDown() {
        log.info("Clicks Day Mapping dropdown on Setup Product page");
        setupProductPage.clickDayMappingDropDown();
    }

    @Step
    @And("Selects Day Mapping {string} on Setup Product page")
    public void selectDayMapping(String dayMapping) {
        log.info("Selects Day Mapping from dropdown on Setup Product page");
        setupProductPage.selectDayMapping(dayMapping);
    }

    @Step
    @And("Clicks Month Mapping dropdown on Setup Product page")
    public void clickMonthMappingDropDown() {
        log.info("Clicks Month Mapping dropdown on Setup Product page");
        setupProductPage.clickMonthMappingDropDown();
    }

    @Step
    @And("Selects Month Mapping {string} on Setup Product page")
    public void selectMonthMapping(String monthMapping) {
        log.info("Selects Month Mapping from dropdown on Setup Product page");
        setupProductPage.selectMonthMapping(monthMapping);
    }

    @Step
    @And("Clicks Year Mapping dropdown on Setup Product page")
    public void clickYearMappingDropDown() {
        log.info("Clicks Year Mapping dropdown on Setup Product page");
        setupProductPage.clickYearMappingDropDown();
    }

    @Step
    @And("Selects Year Mapping {string} on Setup Product page")
    public void selectYearMapping(String yearMapping) {
        log.info("Selects Year Mapping from dropdown on Setup Product page");
        setupProductPage.selectYearMapping(yearMapping);
    }

    @Step
    @And("Clicks Week Mapping dropdown on Setup Product page")
    public void clickWeekMappingDropDown() {
        log.info("Clicks Week Mapping dropdown on Setup Product page");
        setupProductPage.clickWeekMappingDropDown();
    }

    @Step
    @And("Selects Week Mapping {string} on Setup Product page")
    public void selectWeekMapping(String weekMapping) {
        log.info("Selects Week Mapping from dropdown on Setup Product page");
        setupProductPage.selectWeekMapping(weekMapping);
    }

    @Step
    @And("Clicks Product Label on Setup Product page")
    public void clickProductLabel() {
        log.info("Clicks Product Label on Setup Product page");
        setupProductPage.clickProductLabel();
    }

    @Step
    @And("Clicks Product Type Label on Setup Product page")
    public void clickProductTypeLabel() {
        log.info("Clicks Product Type Label on Setup Product page");
        setupProductPage.clickProductTypeLabel();
    }

    @Step
    @And("Clicks Unit Status Label on Setup Product page")
    public void clickUnitStatusLabel() {
        log.info("Clicks Unit Status Label on Setup Product page");
        setupProductPage.clickUnitStatusLabel();
    }

    @Step
    @And("Clicks Quality Control Type Label on Setup Product page")
    public void clickQualityControlTypeLabel() {
        log.info("Clicks Quality Control Type Label on Setup Product page");
        setupProductPage.clickQualityControlTypeLabel();
    }

    @Step
    @And("Clicks Product Tab on Setup Product page")
    public void clickProductTab() {
        log.info("Clicks Product Tab on Setup Product page");
        setupProductPage.clickProductTab();
    }

    @Step
    @And("Clicks Warehouse Tab on Setup Product page")
    public void clickWarehouseTab() {
        log.info("Clicks Warehouse Tab on Setup Product page");
        setupProductPage.clickWarehouseTab();
    }

    @Step
    @And("Clicks UOM Tab on Setup Product page")
    public void clickUomTab() {
        log.info("Clicks UOM Tab on Setup Product page");
        setupProductPage.clickUomTab();
    }

    @Step
    @And("Clicks Suppliers Tab on Setup Product page")
    public void clickSuppliersTab() {
        log.info("Clicks Suppliers Tab on Setup Product page");
        setupProductPage.clickSuppliersTab();
    }

    @Step
    @And("Move to UOM Tab on Setup Product page")
    public void moveToUOMDropdown() {
        log.info("Move to UOM Tab on Setup Product page");
        setupProductPage.moveToUOMDropdown();
    }

    @Step
    @And("Move to Weight Unit on Setup Product page")
    public void moveToWeightUnitDropdown() {
        log.info("Move to Weight Unit on Setup Product page");
        setupProductPage.moveToWeightUnitDropdown();
    }

    @Step
    @And("Move to Tare Weight Unit on Setup Product page")
    public void moveToTareWeightDropdown() {
        log.info("Move to Tare Weight Unit on Setup Product page");
        setupProductPage.moveToTareWeightDropdown();
    }

    @Step
    @And("Move to Width Unit on Setup Product page")
    public void moveToWidthUnitDropdown() {
        log.info("Move to Width Unit on Setup Product page");
        setupProductPage.moveToWidthUnitDropdown();
    }

    @Step
    @And("Move to Next Width Unit on Setup Product page")
    public void moveToNextWidthUnitDropdown() {
        log.info("Move to Next Width Unit on Setup Product page");
        setupProductPage.moveToNextWidthUnitDropdown();
    }

    @Step
    @And("Move to Height Unit on Setup Product page")
    public void moveToHeightUnitDropdown() {
        log.info("Move to Height Unit on Setup Product page");
        setupProductPage.moveToHeightUnitDropdown();
    }

    @Step
    @And("Move to Next Height Unit on Setup Product page")
    public void moveToNextHeightUnitDropdown() {
        log.info("Move to Next Height Unit on Setup Product page");
        setupProductPage.moveToNextHeightUnitDropdown();
    }

    @Step
    @And("Move to Length Unit on Setup Product page")
    public void moveToLengthUnitDropdown() {
        log.info("Move to Length Unit on Setup Product page");
        setupProductPage.moveToLengthUnitDropdown();
    }

    @Step
    @And("Move to Next Length Unit on Setup Product page")
    public void moveToNextLengthUnitDropdown() {
        log.info("Move to Next Length Unit on Setup Product page");
        setupProductPage.moveToNextLengthUnitDropdown();
    }

    @Step
    @And("Move to Cut Time Unit on Setup Product page")
    public void moveToCutTimeUnitDropdown() {
        log.info("Move to Cut Time Unit on Setup Product page");
        setupProductPage.moveToCutTimeUnitDropdown();
    }

    @Step
    @And("Types Product Code {string} on Setup Product page")
    public void typeProductCode(String code) {
        log.info("Types Product Code on Setup Product page");
        setupProductPage.typeProductCode(code);
    }

    @Step
    @And("Types Long Description {string} on Setup Product page")
    public void typeLongDescription(String code) {
        log.info("Types Long Description on Setup Product page");
        setupProductPage.typeLongDescription(code);
    }

    @Step
    @And("Types Alt Description {string} on Setup Product page")
    public void typeAltDescription(String code) {
        log.info("Types Alt Description on Setup Product page");
        setupProductPage.typeAltDescription(code);
    }

    @Step
    @And("Types Size Code {string} on Setup Product page")
    public void typeSizeCode(String code) {
        log.info("Types Size Code on Setup Product page");
        setupProductPage.typeSizeCode(code);
    }

    @Step
    @And("Types Tie {string} on Setup Product page")
    public void typeTie(String tie) {
        log.info("Types Tie on Setup Product page");
        setupProductPage.typeTie(tie);
    }

    @Step
    @And("Types Voiced Code {string} on Setup Product page")
    public void typeVoicedCode(String code) {
        log.info("Types Voice dCode on Setup Product page");
        setupProductPage.typeVoicedCode(code);
    }

    @Step
    @And("Types High {string} on Setup Product page")
    public void typeHigh(String high) {
        log.info("Types High on Setup Product page");
        setupProductPage.typeHigh(high);
    }

    @Step
    @And("Types Max Stack {string} on Setup Product page")
    public void typeMaxStack(String stack) {
        log.info("Types Max Stack on Setup Product page");
        setupProductPage.typeMaxStack(stack);
    }

    @Step
    @And("Selects Product Type {string} on Setup Product page")
    public void selectProductType(String type) {
        log.info("Selects Product Type on Setup Product page");
        setupProductPage.selectProductType(type);
    }

    @Step
    @And("Selects Movement Class {string} on Setup Product page")
    public void selectMovementClass(String clazz) {
        log.info("Selects Movement Class on Setup Product page");
        setupProductPage.selectMovementClass(clazz);
    }

    @Step
    @And("Selects Warehouse {string} on Setup Product page")
    public void selectWarehouse(String warehouse) {
        log.info("Selects Warehouse on Setup Product page");
        setupProductPage.selectWarehouse(warehouse);
    }

    @Step
    @And("Selects Active {string} on Setup Product page")
    public void selectActive(String active) {
        log.info("Selects Active on Setup Product page");
        setupProductPage.selectActive(active);
    }

    @Step
    @And("Clicks OK on Setup Product page")
    public void clickOkBtn() {
        log.info("Clicks OK on Setup Product page");
        setupProductPage.clickOkBtn();
    }

    @Step
    @And("Clicks OK Button on Setup Product page")
    public void clickOKButton() {
        log.info("Clicks OK Button on Setup Product page");
        setupProductPage.clickOKButton();
    }

    @Step
    @And("Clicks Cancel on Setup Product page")
    public void clickCancelBtn() {
        log.info("Clicks Cancel on Setup Product page");
        setupProductPage.clickCancelBtn();
    }

    @Step
    @And("Clicks UOM Dropdown on Setup Product page")
    public void clickUOMDropdown() {
        log.info("Clicks UOM Dropdown on Setup Product page");
        setupProductPage.clickUOMDropdown();
    }

    @Step
    @And("Selects UOM {string} on Setup Product page")
    public void selectUOM(String uom) {
        log.info("Selects UOM on Setup Product page");
        setupProductPage.selectUOM(uom);
    }

    @Step
    @And("Select UOM from grid by index {int} on Setup Product page")
    public void selectUOMFromGrid(int index) {
        log.info("Select UOM from grid by index {int} on Setup Product page");
        setupProductPage.selectUOMFromGrid(index);
    }

    @Step
    @And("User clicks Add Filter on Setup Product page")
    public void clickAddFilterButton() {
        log.info("User clicks Add Filter on Setup Product page");
        setupProductPage.clickAddFilterButton();
    }

    @Step
    @And("User checks Is Empty radio button on Setup Product page")
    public void checkIsEmptyRadioButton() {
        log.info("User checks Is Empty radio button on Setup Product page");
        setupProductPage.checkIsEmptyRadioButton();
    }

    @Step
    @And("User types {string} filter on Setup Product page")
    public void typeFilter(String filter) {
        log.info("User types filter on Setup Product page");
        setupProductPage.typeFilter(filter);
    }

    @Step
    @And("User clicks Apply button on Setup Product page")
    public void clickApplyButton() {
        log.info("User clicks Apply button on Setup Product page");
        setupProductPage.clickApplyButton();
    }

    @Step
    @And("User clicks Clear All button on Setup Product page")
    public void clickClearAllButton() {
        log.info("User clicks Clear All button on Setup Product page");
        setupProductPage.clickClearAllButton();
    }

    @Step
    @And("User clicks Code Filter on Setup Product page")
    public void clickCodeFilter() {
        log.info("User clicks Code Filter on Setup Product page");
        setupProductPage.clickCodeFilter();
    }

    @Step
    @And("User clicks Desc Filter on Setup Product page")
    public void clickDescFilter() {
        log.info("User clicks Desc Filter on Setup Product page");
        setupProductPage.clickDescFilter();
    }

    @Step
    @And("User clicks Day Mapping Filter on Setup Product page")
    public void clickDayMappingFilter() {
        log.info("User clicks Day Mapping Filter on Setup Product page");
        setupProductPage.clickDayMappingFilter();
    }

    @Step
    @And("User clicks Month Mapping Filter on Setup Product page")
    public void clickMonthMappingFilter() {
        log.info("User clicks Month Mapping Filter on Setup Product page");
        setupProductPage.clickMonthMappingFilter();
    }

    @Step
    @And("User clicks Extract Date As Filter on Setup Product page")
    public void clickExtractDateAsFilter() {
        log.info("User clicks Extract Date As Filter on Setup Product page");
        setupProductPage.clickExtractDateAsFilter();
    }

    @Step
    @And("User clicks Year Mapping Filter on Setup Product page")
    public void clickYearMappingFilter() {
        log.info("User clicks Year Mapping Filter on Setup Product page");
        setupProductPage.clickYearMappingFilter();
    }

    @Step
    @And("User clicks Week Mapping Filter on Setup Product page")
    public void clickWeekMappingFilter() {
        log.info("User clicks Week Mapping Filter on Setup Product page");
        setupProductPage.clickWeekMappingFilter();
    }

    @Step
    @And("Enters Pack {string} on Setup Product page")
    public void enterPack(String pack) {
        log.info("Enters Pack on Setup Product page");
        setupProductPage.enterPack(pack);
    }

    @Step
    @And("Enters Weight {string} on Setup Product page")
    public void enterWeight(String weight) {
        log.info("Enters Weight on Setup Product page");
        setupProductPage.enterWeight(weight);
    }

    @Step
    @And("Clicks Weight Unit on UOM popup on Setup Product page")
    public void clickWeightUnit() {
        log.info("Clicks Weight Unit on UOM popup on Setup Product page");
        setupProductPage.clickWeightUnit();
    }

    @Step
    @And("Clicks Tare Weight Unit on UOM popup on Setup Product page")
    public void clickTareWeightUnit() {
        log.info("Clicks Tare Weight Unit on UOM popup on Setup Product page");
        setupProductPage.clickTareWeightUnit();
    }

    @Step
    @And("Clicks Width Unit on UOM popup on Setup Product page")
    public void clickWidthUnit() {
        log.info("Clicks Width Unit on UOM popup on Setup Product page");
        setupProductPage.clickWidthUnit();
    }

    @Step
    @And("Clicks Next Width Unit on UOM popup on Setup Product page")
    public void clickNextWidthUnit() {
        log.info("Clicks Next Width Unit on UOM popup on Setup Product page");
        setupProductPage.clickNextWidthUnit();
    }

    @Step
    @And("Clicks Height Unit on UOM popup on Setup Product page")
    public void clickHeightUnitUnit() {
        log.info("Clicks Height Unit on UOM popup on Setup Product page");
        setupProductPage.clickHeightUnitUnit();
    }

    @Step
    @And("Clicks Next Height Unit on UOM popup on Setup Product page")
    public void clickNextHeightUnit() {
        log.info("Clicks Next Height Unit on UOM popup on Setup Product page");
        setupProductPage.clickNextHeightUnit();
    }

    @Step
    @And("Clicks Length Unit on UOM popup on Setup Product page")
    public void clickLengthUnit() {
        log.info("Clicks Length Unit on UOM popup on Setup Product page");
        setupProductPage.clickLengthUnit();
    }

    @Step
    @And("Clicks Next Length Unit on UOM popup on Setup Product page")
    public void clickNextLengthUnit() {
        log.info("Clicks Next Length Unit on UOM popup on Setup Product page");
        setupProductPage.clickNextLengthUnit();
    }

    @Step
    @And("Clicks Cut Time Unit on UOM popup on Setup Product page")
    public void clickCutTimeUnit() {
        log.info("Clicks Cut Time Unit on UOM popup on Setup Product page");
        setupProductPage.clickCutTimeUnit();
    }

    @Step
    @And("Clicks Shelf Unit on UOM popup on Setup Product page")
    public void clickShelfUnit() {
        log.info("Clicks Shelf Unit on UOM popup on Setup Product page");
        setupProductPage.clickShelfUnit();
    }

    @Step
    @And("Enters Tare Weight {string} on Setup Product page")
    public void enterTareWeight(String tareWeight) {
        log.info("Enters Tare Weight on Setup Product page");
        setupProductPage.enterTareWeight(tareWeight);
    }

    @Step
    @And("Enters Width {string} on Setup Product page")
    public void enterWidth(String width) {
        log.info("Enters Width on Setup Product page");
        setupProductPage.enterWidth(width);
    }

    @Step
    @And("Enters Next Width {string} on Setup Product page")
    public void enterNextWidth(String width) {
        log.info("Enters Next Width on Setup Product page");
        setupProductPage.enterNextWidth(width);
    }

    @Step
    @And("Enters Height {string} on Setup Product page")
    public void enterHeight(String height) {
        log.info("Enters Height on Setup Product page");
        setupProductPage.enterHeight(height);
    }

    @Step
    @And("Enters Next Height {string} on Setup Product page")
    public void enterNextHeight(String nextHeight) {
        log.info("Enters Next Height on Setup Product page");
        setupProductPage.enterNextHeight(nextHeight);
    }

    @Step
    @And("Enters Length {string} on Setup Product page")
    public void enterLength(String length) {
        log.info("Enters Length on Setup Product page");
        setupProductPage.enterLength(length);
    }

    @Step
    @And("Enters Next Length {string} on Setup Product page")
    public void enterNextLength(String length) {
        log.info("Enters Next Length on Setup Product page");
        setupProductPage.enterNextLength(length);
    }

    @Step
    @And("Enters Cut Time {string} on Setup Product page")
    public void enterCutTime(String time) {
        log.info("Enters Cut Time on Setup Product page");
        setupProductPage.enterCutTime(time);
    }

    @Step
    @And("Enters Shelf Unit {string} on Setup Product page")
    public void enterShelfUnit(String time) {
        log.info("Enters Shelf Unit on Setup Product page");
        setupProductPage.enterShelfUnit(time);
    }

    @Step
    @And("Enters Size Code {string} on Setup Product page")
    public void enterSizeCode(String time) {
        log.info("Enters Size Code on Setup Product page");
        setupProductPage.enterSizeCode(time);
    }

    @Step
    @And("Check Include Opportunistic on Setup Product page")
    public void selectIncludeOpportunistic() {
        log.info("Check Include Opportunistic on Setup Product page");
        setupProductPage.selectIncludeOpportunistic();
    }

    @Step
    @And("Uncheck Include Opportunistic on Setup Product page")
    public void unselectIncludeOpportunistic() {
        log.info("Uncheck Include Opportunistic on Setup Product page");
        setupProductPage.unselectIncludeOpportunistic();
    }

    @Step
    @And("Enter Day Mapping 0 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping0(String mapping) {
        log.info("Enter Day Mapping 0 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping0(mapping);
    }

    @Step
    @And("Enter Day Mapping 1 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping1(String mapping) {
        log.info("Enter Day Mapping 1 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping1(mapping);
    }

    @Step
    @And("Enter Day Mapping 2 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping2(String mapping) {
        log.info("Enter Day Mapping 2 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping2(mapping);
    }

    @Step
    @And("Enter Day Mapping 3 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping3(String mapping) {
        log.info("Enter Day Mapping 3 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping3(mapping);
    }

    @Step
    @And("Enter Day Mapping 4 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping4(String mapping) {
        log.info("Enter Day Mapping 4 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping4(mapping);
    }

    @Step
    @And("Enter Day Mapping 5 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping5(String mapping) {
        log.info("Enter Day Mapping 5 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping5(mapping);
    }

    @Step
    @And("Enter Day Mapping 6 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping6(String mapping) {
        log.info("Enter Day Mapping 6 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping6(mapping);
    }

    @Step
    @And("Enter Day Mapping 7 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping7(String mapping) {
        log.info("Enter Day Mapping 7 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping7(mapping);
    }

    @Step
    @And("Enter Day Mapping 8 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping8(String mapping) {
        log.info("Enter Day Mapping 8 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping8(mapping);
    }

    @Step
    @And("Enter Day Mapping 9 {string} value on Date encoding popup on Setup Product page")
    public void enterDayMapping9(String mapping) {
        log.info("Enter Day Mapping 9 on Date encoding popup on Setup Product page");
        setupProductPage.enterDayMapping9(mapping);
    }

    @Step
    @And("Enter Month Mapping 0 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping0(String mapping) {
        log.info("Enter Month Mapping 0 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping0(mapping);
    }

    @Step
    @And("Enter Month Mapping 1 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping1(String mapping) {
        log.info("Enter Month Mapping 1 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping1(mapping);
    }

    @Step
    @And("Enter Month Mapping 2 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping2(String mapping) {
        log.info("Enter Month Mapping 2 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping2(mapping);
    }

    @Step
    @And("Enter Month Mapping 3 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping3(String mapping) {
        log.info("Enter Month Mapping 3 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping3(mapping);
    }

    @Step
    @And("Enter Month Mapping 4 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping4(String mapping) {
        log.info("Enter Month Mapping 4 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping4(mapping);
    }

    @Step
    @And("Enter Month Mapping 5 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping5(String mapping) {
        log.info("Enter Month Mapping 5 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping5(mapping);
    }

    @Step
    @And("Enter Month Mapping 6 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping6(String mapping) {
        log.info("Enter Month Mapping 6 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping6(mapping);
    }

    @Step
    @And("Enter Month Mapping 7 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping7(String mapping) {
        log.info("Enter Month Mapping 7 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping7(mapping);
    }

    @Step
    @And("Enter Month Mapping 8 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping8(String mapping) {
        log.info("Enter Month Mapping 8 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping8(mapping);
    }

    @Step
    @And("Enter Month Mapping 9 {string} value on Date encoding popup on Setup Product page")
    public void enterMonthMapping9(String mapping) {
        log.info("Enter Month Mapping 9 on Date encoding popup on Setup Product page");
        setupProductPage.enterMonthMapping9(mapping);
    }

    @Step
    @And("Enter Week Mapping 0 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping0(String mapping) {
        log.info("Enter Week Mapping 0 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping0(mapping);
    }

    @Step
    @And("Enter Week Mapping 1 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping1(String mapping) {
        log.info("Enter Week Mapping 1 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping1(mapping);
    }

    @Step
    @And("Enter Week Mapping 2 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping2(String mapping) {
        log.info("Enter Week Mapping 2 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping2(mapping);
    }

    @Step
    @And("Enter Week Mapping 3 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping3(String mapping) {
        log.info("Enter Week Mapping 3 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping3(mapping);
    }

    @Step
    @And("Enter Week Mapping 4 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping4(String mapping) {
        log.info("Enter Week Mapping 4 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping4(mapping);
    }

    @Step
    @And("Enter Week Mapping 5 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping5(String mapping) {
        log.info("Enter Week Mapping 5 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping5(mapping);
    }

    @Step
    @And("Enter Week Mapping 6 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping6(String mapping) {
        log.info("Enter Week Mapping 6 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping6(mapping);
    }

    @Step
    @And("Enter Week Mapping 7 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping7(String mapping) {
        log.info("Enter Week Mapping 7 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping7(mapping);
    }

    @Step
    @And("Enter Week Mapping 8 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping8(String mapping) {
        log.info("Enter Week Mapping 8 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping8(mapping);
    }

    @Step
    @And("Enter Week Mapping 9 {string} value on Date encoding popup on Setup Product page")
    public void enterWeekMapping9(String mapping) {
        log.info("Enter Week Mapping 9 on Date encoding popup on Setup Product page");
        setupProductPage.enterWeekMapping9(mapping);
    }

    @Step
    @And("Enter Year Mapping 0 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping0(String mapping) {
        log.info("Enter Year Mapping 0 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping0(mapping);
    }

    @Step
    @And("Enter Year Mapping 1 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping1(String mapping) {
        log.info("Enter Year Mapping 1 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping1(mapping);
    }

    @Step
    @And("Enter Year Mapping 2 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping2(String mapping) {
        log.info("Enter Year Mapping 2 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping2(mapping);
    }

    @Step
    @And("Enter Year Mapping 3 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping3(String mapping) {
        log.info("Enter Year Mapping 3 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping3(mapping);
    }

    @Step
    @And("Enter Year Mapping 4 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping4(String mapping) {
        log.info("Enter Year Mapping 4 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping4(mapping);
    }

    @Step
    @And("Enter Year Mapping 5 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping5(String mapping) {
        log.info("Enter Year Mapping 5 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping5(mapping);
    }

    @Step
    @And("Enter Year Mapping 6 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping6(String mapping) {
        log.info("Enter Year Mapping 6 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping6(mapping);
    }

    @Step
    @And("Enter Year Mapping 7 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping7(String mapping) {
        log.info("Enter Year Mapping 7 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping7(mapping);
    }

    @Step
    @And("Enter Year Mapping 8 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping8(String mapping) {
        log.info("Enter Year Mapping 8 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping8(mapping);
    }

    @Step
    @And("Enter Year Mapping 9 {string} value on Date encoding popup on Setup Product page")
    public void enterYearMapping9(String mapping) {
        log.info("Enter Year Mapping 9 on Date encoding popup on Setup Product page");
        setupProductPage.enterYearMapping9(mapping);
    }

    @Step
    @And("Enter Input Code {string} on Date encoding popup on Setup Product page")
    public void typeInputCode(String text) {
        log.info("Enter Input Code on Date encoding popup on Setup Product page");
        setupProductPage.typeInputCode(text);
    }

    @Step
    @And("Enter Input Desc {string} on Date encoding popup on Setup Product page")
    public void typeInputDesc(String text) {
        log.info("Enter Input Desc on Date encoding popup on Setup Product page");
        setupProductPage.typeInputDesc(text);
    }

    @Step
    @And("Enter Input Lot Mask {string} on Date encoding popup on Setup Product page")
    public void typeInputLotMask(String text) {
        log.info("Enter Input Lot Mask on Date encoding popup on Setup Product page");
        setupProductPage.typeInputLotMask(text);
    }

    @Step
    @And("Enter Character {string} on Month mapping on Setup Product page")
    public void typeCharacterInput(String text) {
        log.info("Enter Character on Month mapping on Setup Product page");
        setupProductPage.typeCharacterInput(text);
    }

    @Step
    @And("Enter Value {string} on Month mapping on Setup Product page")
    public void typeValueInput(String text) {
        log.info("Enter Value on Month mapping on Setup Product page");
        setupProductPage.typeValueInput(text);
    }

    @Step
    @And("Selects row {string} on Setup Product page")
    public void selectRowByNum(String row) {
        log.info("Select row on Setup Product page");
        setupProductPage.selectRowByNum(row);
    }

    @Step
    @And("Selects row by code {string} on Setup Product page")
    public void selectRowByCode(String code) {
        log.info("Select row by code on Setup Product page");
        setupProductPage.selectRowByCode(code);
    }

}
