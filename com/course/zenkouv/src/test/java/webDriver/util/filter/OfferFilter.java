package webDriver.util.filter;

import webDriver.constant.OnlinerLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.util.validator.ElementValidator;

import java.util.List;
import java.util.stream.Collectors;

public class OfferFilter {

    private OfferFilter() {
    }

    public static List<WebElement> getOffersWithAbilityAddToCart(List<WebElement> offers) {
        return offers.stream().filter(offer -> ElementValidator
                .isElementPresent(offer, By.xpath(OnlinerLocators.CART_BUTTON_XPATH)))
                .collect(Collectors.toList());
    }
}
