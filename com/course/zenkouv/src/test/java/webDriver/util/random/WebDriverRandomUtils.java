package webDriver.util.random;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class WebDriverRandomUtils {

    private WebDriverRandomUtils() {
    }

    public static WebElement getRandomWebElement(List<WebElement> elements, String message) {
        if (!elements.isEmpty()) {
            return elements.get(new Random().nextInt(elements.size()));
        } else {
            throw new NoSuchElementException(message);
        }
    }
}
