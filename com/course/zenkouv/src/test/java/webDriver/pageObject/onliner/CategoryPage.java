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

public class CategoryPage extends Page {

    @FindAll({@FindBy(className = OnlinerLocators.PRODUCT_CLASS_NAME)})
    private List<WebElement> products;

    public CategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public ProductPage chooseRandomAvailableProduct() {
        List<WebElement> availableProducts = ElementFilter.getAvailableElements(products, By.className(OnlinerLocators.PRODUCT_PRICE_CLASS_NAME));
        WebElement product = WebDriverRandomUtils.getRandomWebElement(availableProducts, "There isn't any product!");
        moveTo(product);
        product.findElement(By.xpath(OnlinerLocators.PRODUCT_TITLE_XPATH)).click();
        return new ProductPage(driver);
    }
}
