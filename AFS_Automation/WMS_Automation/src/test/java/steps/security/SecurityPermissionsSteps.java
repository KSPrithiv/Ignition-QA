package steps.security;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.secutiry.permissions.SecurityPermissionsPage;

@Slf4j
public class SecurityPermissionsSteps {
    SecurityPermissionsPage securityPermissionsPage = new SecurityPermissionsPage();

    @Step
    @And("Selects allow user access to Dashboard checkbox on Security Permissions page")
    public void selectAllowUserAccessToDashboard() {
        log.info("Selects allow user access to Dashboard checkbox on Security Permissions page");
        securityPermissionsPage.selectAllowUserAccessToDashboard();
    }

    @Step
    @And("Unselects allow user access to Dashboard checkbox on Security Permissions page")
    public void unselectAllowUserAccessToDashboard() {
        log.info("Unselects allow user access to Dashboard checkbox on Security Permissions page");
        securityPermissionsPage.unselectAllowUserAccessToDashboard();
    }

    @Step
    @And("Clicks Save on Security Permissions page")
    public void clickSaveButton() {
        log.info("Clicks Save on Security Permissions page");
        securityPermissionsPage.clickSaveButton();
    }

    @Step
    @And("Clicks Cancel on Security Permissions page")
    public void clickCancelButton() {
        log.info("Clicks Cancel on Security Permissions page");
        securityPermissionsPage.clickCancelButton();
    }

}
