package test.webDriverTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webDriver.factory.WebDriverFactory;
import webDriver.pageObject.onliner.*;

public class OnlinerTest {

    private final String url = "https://catalog.onliner.by/";
    private final String login = "vitalyzenkou@gmail.com";
    private final String password = "Qwerty123";
    private WebDriver chromeDriver;

    @BeforeClass
    public void setup() {
        chromeDriver = WebDriverFactory.getChromeDriver();
        chromeDriver.get(url);
    }

    @Test
    public void productAddedToCart() {
        CatalogOnliner catalog = new CatalogOnliner(chromeDriver);
        Assert.assertEquals(catalog.getPageTitle(), "Каталог Onliner.by");
        Assert.assertTrue(catalog.openAuthPage().authorization(login, password), "Authorization failed!");
        Assert.assertTrue(catalog.goToCart().isCleanedCart(), "Cart wasn't cleaned!");
        Category category = catalog.goToCategory();
        Product product = category.chooseRandomAvailableProduct();
        Offers offers = product.getOffers();
        offers.addProductToCart();
        Cart cart = catalog.goToCart();
        Assert.assertTrue(cart.addedToCart(), "A product wasn't added to cart!");
    }

    @AfterClass
    public void dispose() {
        chromeDriver.quit();
    }
}
