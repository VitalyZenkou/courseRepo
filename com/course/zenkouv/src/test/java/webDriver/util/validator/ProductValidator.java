package webDriver.util.validator;

import webDriver.pageObject.onliner.CatalogOnliner;
import webDriver.pageObject.onliner.Category;
import webDriver.pageObject.onliner.Offers;
import webDriver.pageObject.onliner.Page;
import webDriver.util.filter.OfferFilter;
import webDriver.util.filter.ProductFilter;

public class ProductValidator {

    private ProductValidator() {
    }

    public static Page canPurchaseProduct(CatalogOnliner catalogOnliner, Category category) {
        if (ProductFilter.getAvailableProducts(category.getProducts()).isEmpty()) {
            return catalogOnliner;
        } else {
            return category;
        }
    }

    public static Page canAddProductToCart(Category category, Offers offers) {
        if (OfferFilter.getOffersWithAbilityAddToCart(offers.getOffers()).isEmpty()) {
            return category;
        } else {
            return offers;
        }
    }
}
