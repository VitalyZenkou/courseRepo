package webDriver.util.validator;

import org.openqa.selenium.By;
import webDriver.constant.OnlinerLocators;
import webDriver.pageObject.onliner.CatalogPage;
import webDriver.pageObject.onliner.CategoryPage;
import webDriver.pageObject.onliner.OffersPage;
import webDriver.pageObject.onliner.Page;
import webDriver.util.filter.ElementFilter;

public class ProductValidator {

    private ProductValidator() {
    }

    public static Page canPurchaseProduct(CatalogPage catalogPage, CategoryPage categoryPage) {
        if (ElementFilter.getAvailableElements(categoryPage.getProducts(), By.className(OnlinerLocators.PRODUCT_PRICE_CLASS_NAME)).isEmpty()) {
            return catalogPage;
        } else {
            return categoryPage;
        }
    }

    public static Page canAddProductToCart(CategoryPage categoryPage, OffersPage offersPage) {
        if (ElementFilter.getAvailableElements(offersPage.getOffers(),By.xpath(OnlinerLocators.CART_BUTTON_XPATH)).isEmpty()) {
            return categoryPage;
        } else {
            return offersPage;
        }
    }
}
