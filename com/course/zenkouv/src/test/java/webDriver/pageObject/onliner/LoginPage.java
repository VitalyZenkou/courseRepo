package webDriver.pageObject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import webDriver.constant.OnlinerLocators;

public class LoginPage extends Page {

    @FindBy(css = OnlinerLocators.LOGIN_FIELD_CSS)
    private WebElement loginField;

    @FindBy(css = OnlinerLocators.PASSWORD_FIELD_CSS)
    private WebElement passwordField;

    @FindBy(css = OnlinerLocators.AUTH_SUBMIT_BUTTON_CSS)
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public CatalogPage login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        Assert.assertTrue(isElementPresent(By.className(OnlinerLocators.PROFILE_CLASS_NAME)),"Authorization failed!");
        return new CatalogPage(super.driver);
    }
}
