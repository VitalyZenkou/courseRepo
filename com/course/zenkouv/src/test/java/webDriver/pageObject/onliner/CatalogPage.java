package webDriver.pageObject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.constant.OnlinerLocators;
import webDriver.util.random.WebDriverRandomUtils;

import java.util.List;

public class CatalogPage extends Page {

    @FindBy(id = OnlinerLocators.USER_BAR_ID)
    private WebElement authBar;

    @FindAll({@FindBy(className = OnlinerLocators.CATALOG_NAVIGATION_CLASS_NAME)})
    private List<WebElement> categories;

    @FindBy(xpath = OnlinerLocators.CART_ITEM_XPATH)
    private WebElement cartItem;

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public LoginPage openLoginPage() {
        authBar.click();
        return new LoginPage(super.driver);
    }

    public CategoryPage goToCategory() {
        WebElement category = WebDriverRandomUtils.getRandomWebElement(categories, "There isn't any catalog item!");
        category.click();
        List<WebElement> sideItemsList = findElementWithWait(By.
                cssSelector(getCatalogSelectorCssLocator(category.getAttribute(OnlinerLocators.DATA_ID))))
                .findElements(By.className(OnlinerLocators.CATALOG_NAVIGATION_ASIDE_ITEM_CLASS_NAME));
        WebElement sideItem = WebDriverRandomUtils.getRandomWebElement(sideItemsList, "There isn't any side item!");
        moveTo(sideItem);
        List<WebElement> dropDownItemsList = sideItem.findElements(By.className(OnlinerLocators.CATALOG_NAVIGATOR_DROP_DOWN_ITEM_CLASS_NAME));
        WebElement dropDownItem = WebDriverRandomUtils.getRandomWebElement(dropDownItemsList, "There isn't any drop down item!");
        moveTo(dropDownItem);
        dropDownItem.click();
        return new CategoryPage(driver);
    }

    private String getCatalogSelectorCssLocator(String dataId) {
        return String.format("div.catalog-navigation-list__category[data-id='%s']", dataId);
    }

    public CartPage goToCart(){
        cartItem.click();
        return new CartPage(super.driver);
    }
}
