package webDriver.util.filter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.util.validator.ElementValidator;

import java.util.List;
import java.util.stream.Collectors;

public class ElementFilter {

    private ElementFilter() {
    }

    public static List<WebElement> getAvailableElements(List<WebElement> elements, By by) {
        return elements.stream().filter(product -> ElementValidator
                .isElementPresent(product,by))
                .collect(Collectors.toList());
    }
}
