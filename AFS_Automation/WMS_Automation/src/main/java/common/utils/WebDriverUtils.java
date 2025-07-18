package common.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public class WebDriverUtils {

    public static WebDriver getDriverFromElement(WebElement element) {
        if (element instanceof WrapsDriver) {
            return ((WrapsDriver) element).getWrappedDriver();
        }

        try {
            // Some WebElement implementations override this dynamically
            return ((WrapsDriver) element).getWrappedDriver();
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot extract WebDriver from WebElement");
        }
    }
}
