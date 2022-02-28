package utilities;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Synchronization_Util {

    private WebDriver driver;

    public Synchronization_Util(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void waitAndClick (final By location) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(30, TimeUnit.SECONDS);
        wait.pollingEvery(1000, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(location);
            }
        };
        System.out.println("test hit");
        wait.until(function).click();
    }

    public void waitAndClick_Xpath (final String xPath) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(30, TimeUnit.SECONDS);
        wait.pollingEvery(1000, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(xPath));
            }
        };
        wait.until(function).click();
    }

    public void waitAndClear (final By location) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(30, TimeUnit.SECONDS);
        wait.pollingEvery(1000, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(location);
            }
        };
        wait.until(function).clear();
    }

    public void waitAndEnter(String input, final By location) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(30, TimeUnit.SECONDS);
        wait.pollingEvery(1000, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(location);
            }
        };
        wait.until(function).sendKeys(input);
    }

    public String waitAndGetText_xPath (final String xPath) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(30, TimeUnit.SECONDS);
        wait.pollingEvery(1000, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(xPath));
            }
        };
        return wait.until(function).getText();
    }

    public void waitUntilNotVisible (String xPath) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
    }

    public Boolean waitUntilNotDisplayed (final String xPath) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(3, TimeUnit.SECONDS);
        wait.pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            Boolean displayed;
            public Boolean apply(WebDriver webDriver) {
                try {
                    displayed = webDriver.findElement(By.xpath(xPath)).isDisplayed();
                    return displayed;
                } catch (StaleElementReferenceException e) {
                    return false;
                }
            }
        };
        return wait.until(function);
    }

    public Boolean waitUntilNotDisplayedHelper (String xPath) {
        try {
            return waitUntilNotDisplayed(xPath);
        } catch (TimeoutException e) {
            return false;
        }
    }
}


