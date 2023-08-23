package steps.setupSystem;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ui.pages.setupLabor.SetupLaborCodePage;
import ui.pages.setupSystem.UserGroupPage;
import ui.pages.setupWarehouse.WarehousePage;

@Slf4j

public class UserGroupPageSteps {
    WebDriver driver;
    SetupLaborCodePage setupLaborCodePage = new SetupLaborCodePage(driver);
    UserGroupPage userGroupPage=new UserGroupPage();
    WarehousePage warehousePage=new WarehousePage();

    @And("Go to SetupIcon and System")
    public void setupIconAndSystem() {
        log.info("Go to SetupIcon and System");
        setupLaborCodePage.clickSetupIcon();
        userGroupPage.clickSetupSystem();
    }
    @And("Click on Search field on UserGroup Page")
    public void searchUserGroup() {
        userGroupPage.userGroupTab();
        warehousePage.searchBoxActionWarehouse();
    }
}
