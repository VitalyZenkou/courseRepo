package webDriver.util.validator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementValidator {

    private ElementValidator() {
    }

    public static boolean isElementPresent(WebElement element, By locator) {
        return element.findElements(locator).size() > 0;
    }
}
