package webDriver.pageObject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.constant.OnlinerLocators;
import webDriver.util.filter.ProductFilter;
import webDriver.util.random.WebDriverRandomUtils;

import java.util.List;

public class Category extends Page {

    @FindAll({@FindBy(className = OnlinerLocators.PRODUCT_CLASS_NAME)})
    private List<WebElement> products;

    public Category(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public Product chooseRandomAvailableProduct() {
        List<WebElement> availableProducts = ProductFilter.getAvailableProducts(products);
        WebElement product = WebDriverRandomUtils.getRandomWebElement(availableProducts, "There isn't any product!");
        moveTo(product);
        product.findElement(By.xpath(OnlinerLocators.PRODUCT_TITLE_XPATH)).click();
        return new Product(driver);
    }
}
