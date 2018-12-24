package webDriver.pageObject.onliner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.constant.OnlinerLocators;

public class Product extends Page {

    @FindBy(className = OnlinerLocators.OFFERS_BUTTON_CLASS_NAME)
    private WebElement offersButton;

    public Product(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public Offers getOffers() {
        offersButton.click();
        return new Offers(super.driver);
    }
}
