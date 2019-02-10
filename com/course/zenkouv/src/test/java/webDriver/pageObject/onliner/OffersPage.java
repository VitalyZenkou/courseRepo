package webDriver.pageObject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.constant.OnlinerLocators;
import webDriver.util.filter.ElementFilter;
import webDriver.util.random.WebDriverRandomUtils;

import java.util.List;

public class OffersPage extends Page {

    @FindAll({@FindBy(xpath = OnlinerLocators.OFFER_XPATH)})
    private List<WebElement> offers;

    public OffersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public List<WebElement> getOffers() {
        return offers;
    }

    public void addRandomProductToCart() {
        WebElement offer = WebDriverRandomUtils.getRandomWebElement(ElementFilter
                .getAvailableElements(offers, By.xpath(OnlinerLocators.CART_BUTTON_XPATH)), "This product hasn't any offers!");
        WebElement cartButton = offer.findElement(By.xpath(OnlinerLocators.CART_BUTTON_XPATH));
        moveTo(cartButton);
        cartButton.click();
    }
}
