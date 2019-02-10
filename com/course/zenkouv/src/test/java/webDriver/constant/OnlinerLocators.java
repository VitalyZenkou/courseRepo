package webDriver.constant;

public class OnlinerLocators {

    public static final String USER_BAR_ID = "userbar";
    public static final String LOGIN_FIELD_CSS = "#auth-container input[type='text']";
    public static final String PASSWORD_FIELD_CSS = "#auth-container input[type='password']";
    public static final String AUTH_SUBMIT_BUTTON_CSS = "#auth-container button[type='submit']";
    public static final String CATALOG_NAVIGATION_CLASS_NAME = "catalog-navigation-classifier__item";
    public static final String DATA_ID = "data-id";
    public static final String CATALOG_NAVIGATION_ASIDE_ITEM_CLASS_NAME = "catalog-navigation-list__aside-item";
    public static final String CATALOG_NAVIGATOR_DROP_DOWN_ITEM_CLASS_NAME = "catalog-navigation-list__dropdown-item";
    public static final String PRODUCT_CLASS_NAME = "schema-product__group";
    public static final String PRODUCT_TITLE_XPATH = "//a[contains(@data-bind,'attr: {href: product.html_url}')]";
    public static final String CART_BUTTON_XPATH = "//a[contains(@data-href,'https://cart.onliner.by')]";
    public static final String PRODUCT_PRICE_CLASS_NAME = "schema-product__price";
    public static final String PROFILE_CLASS_NAME = "b-top-profile__list";
    public static final String CART_PRODUCT_CLASS_NAME = "cart-product";
    public static final String TRASH_CLASS_NAME = "cart-product__remove";
    public static final String OFFERS_BUTTON_CLASS_NAME = "product-aside__compare";
    public static final String OFFER_XPATH = "//tr[contains(@class,'state_add-to-cart m-divider')]";
    public static final String CART_ITEM_XPATH = "//a[contains(@class,'b-top-navigation-cart__link')]";
}
