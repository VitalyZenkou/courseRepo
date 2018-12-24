package webDriver.pageObject.onliner;

import webDriver.constant.OnlinerLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Auth extends Page {

    @FindBy(css = OnlinerLocators.LOGIN_FIELD_CSS)
    private WebElement loginField;

    @FindBy(css = OnlinerLocators.PASSWORD_FIELD_CSS)
    private WebElement passwordField;

    @FindBy(css = OnlinerLocators.AUTH_SUBMIT_BUTTON_CSS)
    private WebElement submitButton;

    public Auth(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public boolean authorization(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        return isElementPresent(By.className(OnlinerLocators.PROFILE_CLASS_NAME));
    }
}
