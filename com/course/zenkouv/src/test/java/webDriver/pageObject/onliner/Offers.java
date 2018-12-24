package webDriver.pageObject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.constant.OnlinerLocators;
import webDriver.util.filter.OfferFilter;
import webDriver.util.random.WebDriverRandomUtils;

import java.util.List;

public class Offers extends Page {

    @FindAll({@FindBy(xpath = OnlinerLocators.OFFER_XPATH)})
    private List<WebElement> offers;

    public Offers(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public List<WebElement> getOffers() {
        return offers;
    }

    public void addProductToCart() {
        WebElement offer = WebDriverRandomUtils.getRandomWebElement(OfferFilter.getOffersWithAbilityAddToCart(offers), "This product hasn't any offers!");
        WebElement cartButton = offer.findElement(By.xpath(OnlinerLocators.CART_BUTTON_XPATH));
        moveTo(cartButton);
        cartButton.click();
    }
}
