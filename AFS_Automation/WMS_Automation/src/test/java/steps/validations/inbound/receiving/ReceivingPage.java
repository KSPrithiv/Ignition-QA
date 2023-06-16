package steps.validations.inbound.receiving;

import org.openqa.selenium.By;
import ui.pages.BasePage;

public class ReceivingPage extends BasePage {

    By nextButton = By.cssSelector("button.k-button-icontext");
    By iconReceiving = By.xpath("//span[contains(text(), 'Receiving') and contains(@class, 'withoutBreadcrumbs')]");
    By orderLabel = By.xpath("//label[contains(text(), 'Order')]");
    By orderInput = By.xpath("//parent::label[text()='Order']//..//input[@class='k-input']");
    By loadLabel = By.cssSelector("#routeSearchBar-label");
    By loadInput = By.cssSelector("#routeSearchBar");

    

}
