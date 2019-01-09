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
        CatalogPage catalogPage = new CatalogPage(chromeDriver);
        Assert.assertEquals(catalogPage.getPageTitle(), "Каталог Onliner.by");
        LoginPage loginPage = catalogPage.openLoginPage();
        catalogPage = loginPage.login(login,password);
        CartPage cart = catalogPage.goToCart();
        cart.cleanCart();
        Assert.assertTrue(cart.isEmptyCart(), "CartPage wasn't cleaned!");
        CategoryPage categoryPage = catalogPage.goToCategory();
        ProductPage productPage = categoryPage.chooseRandomAvailableProduct();
        OffersPage offersPage = productPage.getOffers();
        offersPage.addRandomProductToCart();
        CartPage cartPage = catalogPage.goToCart();
        Assert.assertFalse(cartPage.isEmptyCart(), "A productPage wasn't added to cartPage!");
    }

    @AfterClass
    public void dispose() {
        chromeDriver.quit();
    }
}
