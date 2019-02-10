package webDriver.pageObject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public abstract class Page {

    protected final WebDriver driver;
    private final Wait<WebDriver> wait;

    protected Page(WebDriver driver) {
        this.driver = driver;
        Duration waitTime = Duration.ofSeconds(5);
        Duration interval = Duration.ofMillis(5);
        wait = new FluentWait<>(driver).withTimeout(waitTime).pollingEvery(interval).ignoring(NoSuchElementException.class);
    }

    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    protected void moveTo(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected WebElement findElementWithWait(By locator) {
        return wait.until(webDriver -> driver.findElement(locator));
    }
}
