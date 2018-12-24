package webDriver.util.filter;

import webDriver.constant.OnlinerLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.util.validator.ElementValidator;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {

    private ProductFilter() {
    }

    public static List<WebElement> getAvailableProducts(List<WebElement> products) {
        return products.stream().filter(product -> ElementValidator
                .isElementPresent(product, By.className(OnlinerLocators.PRODUCT_PRICE_CLASS_NAME)))
                .collect(Collectors.toList());
    }
}
