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

public class CartPage extends Page {

    @FindBy(className = OnlinerLocators.CART_PRODUCT_CLASS_NAME)
    private List<WebElement> products;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public boolean isEmptyCart() {
        return !isElementPresent(By.className(OnlinerLocators.TRASH_CLASS_NAME));
    }

    public void cleanCart() {
        if (!products.isEmpty()) {
            products.forEach(product -> {
                product.findElement(By.className(OnlinerLocators.TRASH_CLASS_NAME)).click();
                (new WebDriverWait(super.driver, 1)).until(ExpectedConditions.invisibilityOf(product));
            });
            leaveCart();
        } else {
            leaveCart();
        }
    }

    private void leaveCart() {
        super.driver.navigate().back();
    }
}
