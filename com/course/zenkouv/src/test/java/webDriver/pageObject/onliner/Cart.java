package webDriver.pageObject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.constant.OnlinerLocators;

import java.util.List;

public class Cart extends Page {

    @FindBy(className = OnlinerLocators.CART_PRODUCT_CLASS_NAME)
    private List<WebElement> products;

    public Cart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public boolean addedToCart() {
        return !isEmptyCart();
    }

    public boolean isCleanedCart() {
        if (!products.isEmpty()) {
            products.forEach(product ->
            {
                product.findElement(By.className(OnlinerLocators.TRASH_CLASS_NAME)).click();
                (new WebDriverWait(super.driver, 1)).until(ExpectedConditions.invisibilityOf(product));
            });
            leaveCart();
            return true;
        } else {
            leaveCart();
            return isEmptyCart();
        }
    }

    private void leaveCart() {
        super.driver.navigate().back();
    }

    private boolean isEmptyCart() {
        return !isElementPresent(By.className(OnlinerLocators.TRASH_CLASS_NAME));
    }
}
