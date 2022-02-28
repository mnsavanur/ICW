package utilities;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import utilities.VideoRecorder_Util;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Browser_Util {

    public WebDriver driver;
    private LogAndReport_Util logAndReport;
    private Screenshot_Util screenShot;

    public Browser_Util(WebDriver webDriver, Screenshot_Util screenShot, LogAndReport_Util logAndReport) {
        this.driver = webDriver;
        this.logAndReport = logAndReport;
        this.screenShot = screenShot;
    }

    public String getsSANOrQuoteNumberFromWeb(List webElementDefinition) {
        String SANOrQuoteNumber;
        By webLocator;
        WebElement webElement;

        //switchToDefaultContent();
        //switchToFrame("screennav");
        SANOrQuoteNumber = getsTextOfWebElement(webElementDefinition);
        System.out.println("SAN Or Quote Number -> " + SANOrQuoteNumber);
        //switchToDefaultContent();
        return SANOrQuoteNumber;
    }

    public void switchToFrame(String frameNameOrID) {
        WebElement webElement = findsWebElementWithLocatorWithinDefaultTimeout(By.xpath("//frame[@*='" + frameNameOrID + "'] | //iframe[@*='" + frameNameOrID + "']"));
        if (webElement != null) {
            highlightsWebElement(webElement);
        }
        driver.switchTo().frame(frameNameOrID);
    }

    public void switchToFrameWithLocator(By frameWebLocator) {
        try {
            insertsHardCodedDelayInMilliSeconds(2000);
            WebElement webElement = findsWebElementWithLocatorWithinDefaultTimeout(frameWebLocator);
            scrollsWebElementIntoView(webElement);
            highlightsWebElement(webElement);
            driver.switchTo().frame(webElement);
            System.out.println("Switches to '" + frameWebLocator + "' window or frame.");
        } catch (NullPointerException e) {
            String info = "Switch to frame or window '" + frameWebLocator.toString() + "'  failed.";
            writesToLogAndReport("Fail", info);
            System.out.println(info);
        }
    }

    public void switchToDefaultContent() {
        System.out.println("Switches to default window content.");
        driver.switchTo().defaultContent();
    }

    public void switchToWindowWithHandle(String windowHandle) {
        try {
            System.out.println("Switches to '" + windowHandle + "' window handle.");
            this.driver.switchTo().window(windowHandle);
        } catch (NoSuchWindowException nswe) {
            System.out.println("No such window exception occurred. No window with handle '" + windowHandle + "' present.");
            writesToLogAndReport("Fail", "No such window exception occurred. No window with handle '" + windowHandle + "' present.");
        }
    }

    public void switchToChildWindow() {
        String parentWindowHandle;
        String childWindowHandle;

        parentWindowHandle = driver.getWindowHandle();
        childWindowHandle = null;

        for (String winHandle : driver.getWindowHandles()) {
            if (!parentWindowHandle.equals(winHandle)) {
                childWindowHandle = winHandle;
                driver.switchTo().window(winHandle);
            }
        }
        System.out.println("Switches to child window with handle '" + childWindowHandle + "'.");
    }

    public String getWindowHandle() {
        String currentWindowHandle;

        currentWindowHandle = this.driver.getWindowHandle();
        System.out.println("Returns current window handle '" + currentWindowHandle + "'.");
        return currentWindowHandle;
    }

    public Set<String> getAllWindowHandles() {
        System.out.println("Returns all the window handles.");
        return this.driver.getWindowHandles();
    }

    public void closeWindow() {
        String currentWindowHandle;

        currentWindowHandle = this.driver.getWindowHandle();
        this.driver.close();
        System.out.println("Window closed with handle '" + currentWindowHandle + "'.");
    }

    public boolean verifiesAlertIsPresent() {
        try {
            driver.switchTo().alert();
            System.out.println("Alert encountered.");
            return true;
        } catch (NoAlertPresentException Ex) {
            System.out.println("No alert encountered.");
            return false;
        } catch (NoSuchWindowException e) {
            System.out.println("'NoSuchWindowException' exception occurred. Window closed.");
            return false;
        }
    }

    public boolean verifiesAlertIsNotPresent() {
        if (verifiesAlertIsPresent())
            return false;
        else
            return true;
    }

    public void writesToLogAndReport(String status, String reportInfo) {
        if (status.equalsIgnoreCase("Done"))
            logAndReport.writeTo_LogAndReport(reportInfo);
        else if (status.equalsIgnoreCase("Pass"))
            logAndReport.writeTo_LogAndReport_Pass(reportInfo);
        else if (status.equalsIgnoreCase("Warning"))
            logAndReport.writeTo_LogAndReport_Warning(reportInfo);
        else if (status.equalsIgnoreCase("Fail")) {
            logAndReport.writeTo_LogAndReport_Fail(reportInfo);
            Assert.fail(reportInfo);
        }
    }

    public String takeScreenshot() {
        return this.screenShot.takeScreenshot();
    }

    public void attachScreenShotToReport() {
        logAndReport.takeScreenShotAndAttachToReport(this.screenShot.takeScreenshot());
    }

    public void navigatesToURLAndVerifiesPageTitle(String webURL, String expectedPageTitle)  {
        driver.get(webURL);
        driver.manage().window().maximize();
        waitsForLoadingToCompleteWithinStandardTimeout();

        if (expectedPageTitle == null) {
            writesToLogAndReport("Done", "Navigated to URL '" + webURL + "' without page title validation.");
        }
        /*else
        {
            if(expectedPageTitle.equalsIgnoreCase(""))
            {
                writesToLogAndReport("Done", "Navigated to URL '" + webURL + "' without page title validation as expected value is blank.");
            }
            else
            {
                Assert.assertEquals(driver.getTitle().trim(), expectedPageTitle.trim(), "BrowserUtil Class - navigatesToURLAndVerifiesPageTitle() assertion failed");
                writesToLogAndReport("Done", "Navigated to URL '" + webURL + "' and page title matched to '" + expectedPageTitle + "'");
            }
        }*/
    }

    // Method returns a stack trace (as a string) of the class that initiated the call
    // The intent is to provide the page class that made the method call (for logging purposes)
    // The method works, but I'm not sure if it is dependable in all situations, especially since a regex with indexing
    // is used to isolate the class name in the stack trace string
    public String getCallingClass() {
        return getClass().toString().split("\\.")[1];
    }

    public Boolean isDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

    public void verifyPageHeaderMatch(String actual, String expected) {
        Assert.assertEquals(actual, expected, "Page not present");
    }

    public String getCurrentDateTime() {
        Date date = new Date();
        return date.toString();
    }

    public void sendsEnterKey() {
        try {
            Robot robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
        } catch (AWTException e) {
            System.out.println("AWT exception in BrowserUtil Class");
        }
    }

    public void sendsDownArrowKey() {
        try {
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.delay(1000);
        } catch (AWTException e) {
            System.out.println("AWT exception in BrowserUtil Class");
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebElement findsWebElementWithLocatorWithinDefaultTimeout(final By webLocator) {
        WebElement webElement;
        String reportInfo;
        try {
            FluentWait<WebDriver> waitForWebDriver = new FluentWait<WebDriver>(driver);
            waitForWebDriver.withTimeout(8000, MILLISECONDS);
            waitForWebDriver.pollingEvery(100, MILLISECONDS);
            waitForWebDriver.ignoring(NoSuchElementException.class);
            Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver webDriver) {
                    return webDriver.findElement(webLocator);
                }
            };

            webElement = waitForWebDriver.until(function);
        } catch (TimeoutException e) {
            reportInfo = "Time out exception occurred. Fluent Wait could not find web element with web locator: " + webLocator.toString().split("\\:")[1];
            System.out.println(reportInfo);
            webElement = null;
        } catch (WebDriverException wde) {
            reportInfo = "Web driver exception occurred. Could not find web element with web locator: " + webLocator.toString().split("\\:")[1];
            System.out.println(reportInfo);
            webElement = null;
        }
        return webElement;
    }

    private WebElement findsWebElementWithLocatorWithinSpecifiedTimeout(final By webLocator, int timeOutInMilliSeconds) {
        WebElement webElement;
        String reportInfo;
        try {
            FluentWait<WebDriver> waitForWebDriver = new FluentWait<WebDriver>(driver);
            waitForWebDriver.withTimeout(timeOutInMilliSeconds, MILLISECONDS);
            waitForWebDriver.pollingEvery(100, MILLISECONDS);
            waitForWebDriver.ignoring(NoSuchElementException.class);
            Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver webDriver) {
                    return webDriver.findElement(webLocator);
                }
            };
            webElement = waitForWebDriver.until(function);
        } catch (TimeoutException e) {
            reportInfo = "Time out exception occurred. Fluent Wait could not find web element with web locator: " + webLocator.toString().split("\\:")[1];
            System.out.println(reportInfo);
            webElement = null;
        }
        return webElement;
    }

    public void acceptsAlert() {
        String alertMessage;

        if (verifiesAlertIsPresent()) {
            alertMessage = driver.switchTo().alert().getText().trim();
            driver.switchTo().alert().accept();
            writesToLogAndReport("Done", "Alert accepted with following message:<BR>" + alertMessage);
            System.out.println("Alert accepted with following message:<BR>" + alertMessage);
        } else {
            System.out.println("Alert expected. But no alert encountered.");
        }
    }

    public void dismissesAlertAndTransfersControlToActiveFrame(By webLocator) {
        if (verifiesAlertIsPresent()) {
            try {
                this.driver.switchTo().alert().dismiss();
                System.out.println("Alert cleared");
            } catch (NoAlertPresentException e) {
            }
            switchToDefaultContent();
            insertsHardCodedDelayInMilliSeconds(500);
            switchToFrameWithLocator(webLocator);
            insertsHardCodedDelayInMilliSeconds(500);
        }
    }

    public String dismissesAlertAndTransfersControlToTheBrowser() {
        Alert alert;
        String alertMessage = "";
        try {
            insertsHardCodedDelayInMilliSeconds(2000);
            System.out.println("In reject browser alert");
            alert = driver.switchTo().alert();
            alertMessage = alert.getText().trim();
            this.writesToLogAndReport("Done", "Alert rejected with following message:<BR>" + alertMessage);
            System.out.println("Alert rejected with following message:<BR>" + alertMessage);
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert exception occurred.");
        }
        switchToDefaultContent();
        return alertMessage;
    }

    public By getsLocatorFromWebElementDefinition(List webElementDefinition) {
        return (By) webElementDefinition.get(0);
    }

    private String getsPageNameFromWebElementDefinition(List webElementDefinition) {
        return (String) webElementDefinition.get(1);
    }

    private String getsWebElementNameFromWebElementDefinition(List webElementDefinition) {
        return (String) webElementDefinition.get(2);
    }

    public void entersDate(List webElementTextBoxDefinition, String valueToBeSetInTextBox) {
        String reportInfo;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;
        String currentDate;

        if (!valueToBeSetInTextBox.equalsIgnoreCase("$$NA$$")) {
            webLocator = getsLocatorFromWebElementDefinition(webElementTextBoxDefinition);
            pageName = getsPageNameFromWebElementDefinition(webElementTextBoxDefinition);
            webElementName = getsWebElementNameFromWebElementDefinition(webElementTextBoxDefinition);
            DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate dt = LocalDate.now();
            try {

                webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
                //scrollsWebElementIntoView(webElement);
                //highlightsWebElement(webElement);
                if (!webElement.getAttribute("value").trim().equalsIgnoreCase(valueToBeSetInTextBox)) {
                    System.out.println("" + webElementName + " -> to be cleared");
                    String ctrlA = Keys.chord(Keys.CONTROL, "a");
                    webElement.clear();
                    System.out.println("" + webElementName + " -> cleared");
                    if (!valueToBeSetInTextBox.equalsIgnoreCase("$$CLEAR$$")) {
                        if (valueToBeSetInTextBox.contains("currentDate")) {

                            if (valueToBeSetInTextBox.contains("currentDate+")) {
                                String[] futureDate;
                                futureDate = valueToBeSetInTextBox.split("[+]");
                                int month = Integer.parseInt(futureDate[1]);
                                valueToBeSetInTextBox = date.format(dt.plusMonths(month)).toString();
                            } else if (valueToBeSetInTextBox.contains("currentDate-")) {
                                String[] backDate;
                                backDate = valueToBeSetInTextBox.split("-");
                                int month = Integer.parseInt(backDate[1]);
                                valueToBeSetInTextBox = date.format(dt.minusMonths(month)).toString();
                            } else {
                                valueToBeSetInTextBox = date.format(dt).toString();
                            }
                            System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' to be entered");
                            //webElement.click();
                            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                            webElement.sendKeys(valueToBeSetInTextBox + Keys.TAB);
                            System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' entered");
                        } else {
                            System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' to be entered");
                            //webElement.click();
                            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                            webElement.sendKeys(valueToBeSetInTextBox + Keys.TAB);
                            System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' entered");
                        }
                        reportInfo = "Entered '" + valueToBeSetInTextBox + "' in " + webElementName + " on page/frame " + pageName + ".";
                    } else {
                        reportInfo = "Value '" + valueToBeSetInTextBox + "' already set in " + webElementName + " on page/frame " + pageName + ".";
                    }
                    writesToLogAndReport("Done", reportInfo);
                    waitsForLoadingToCompleteWithinStandardTimeout();
                }
            } catch (NullPointerException e) {
                reportInfo = "Web element " + webElementName + " not found on page/frame " + pageName + " with webLocator:<BR>" + webLocator.toString();
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            } catch (UnhandledAlertException uae) {
                reportInfo = "Alert exception occurred.";
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            }
        }
    }

    public void entersTextWithTabIn(List webElementTextBoxDefinition, String valueToBeSetInTextBox) {
        String reportInfo;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;

        if (!valueToBeSetInTextBox.equalsIgnoreCase("$$NA$$")) {
            webLocator = getsLocatorFromWebElementDefinition(webElementTextBoxDefinition);
            pageName = getsPageNameFromWebElementDefinition(webElementTextBoxDefinition);
            webElementName = getsWebElementNameFromWebElementDefinition(webElementTextBoxDefinition);
            try {

                webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
                //scrollsWebElementIntoView(webElement);
                //highlightsWebElement(webElement);
                if (!webElement.getAttribute("value").trim().equalsIgnoreCase(valueToBeSetInTextBox)) {
                    System.out.println("" + webElementName + " -> to be cleared");
                    String ctrlA = Keys.chord(Keys.CONTROL, "a");
                    webElement.clear();
                    System.out.println("" + webElementName + " -> cleared");
                    if (!valueToBeSetInTextBox.equalsIgnoreCase("$$CLEAR$$")) {
                        System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' to be entered");
                        //webElement.click();
                        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                        webElement.sendKeys(valueToBeSetInTextBox + Keys.TAB);
                        System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' entered");
                    }
                    reportInfo = "Entered '" + valueToBeSetInTextBox + "' in " + webElementName + " on page/frame " + pageName + ".";
                } else {
                    reportInfo = "Value '" + valueToBeSetInTextBox + "' already set in " + webElementName + " on page/frame " + pageName + ".";
                }
                writesToLogAndReport("Done", reportInfo);
                waitsForLoadingToCompleteWithinStandardTimeout();
            } catch (NullPointerException e) {
                reportInfo = "Web element " + webElementName + " not found on page/frame " + pageName + " with webLocator:<BR>" + webLocator.toString();
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            } catch (UnhandledAlertException uae) {
                reportInfo = "Alert exception occurred.";
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            }
        }
    }
    public void GLntersTextWithTabIn(List webElementTextBoxDefinition, String valueToBeSetInTextBox) {
        String reportInfo;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;

        if (!valueToBeSetInTextBox.equalsIgnoreCase("$$NA$$")) {
            webLocator = getsLocatorFromWebElementDefinition(webElementTextBoxDefinition);
            pageName = getsPageNameFromWebElementDefinition(webElementTextBoxDefinition);
            webElementName = getsWebElementNameFromWebElementDefinition(webElementTextBoxDefinition);
            try {

                webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
                //scrollsWebElementIntoView(webElement);
                //highlightsWebElement(webElement);
                if (!webElement.getAttribute("value").trim().equalsIgnoreCase(valueToBeSetInTextBox)) {
                    System.out.println("" + webElementName + " -> to be cleared");
                    String ctrlA = Keys.chord(Keys.CONTROL, "a");
                    webElement.clear();
                    System.out.println("" + webElementName + " -> cleared");
                    if (!valueToBeSetInTextBox.equalsIgnoreCase("$$CLEAR$$")) {
                        System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' to be entered");
                        //webElement.click();
                        for(int i=0;i<6;i++){
                        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                        }
                        webElement.sendKeys(valueToBeSetInTextBox + Keys.TAB);
                        System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' entered");
                    }
                    reportInfo = "Entered '" + valueToBeSetInTextBox + "' in " + webElementName + " on page/frame " + pageName + ".";
                } else {
                    reportInfo = "Value '" + valueToBeSetInTextBox + "' already set in " + webElementName + " on page/frame " + pageName + ".";
                }
                writesToLogAndReport("Done", reportInfo);
                waitsForLoadingToCompleteWithinStandardTimeout();
            } catch (NullPointerException e) {
                reportInfo = "Web element " + webElementName + " not found on page/frame " + pageName + " with webLocator:<BR>" + webLocator.toString();
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            } catch (UnhandledAlertException uae) {
                reportInfo = "Alert exception occurred.";
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            }
        }
    }

    public void entersTextWithoutTabIn(List webElementTextBoxDefinition, String valueToBeSetInTextBox) {
        String reportInfo;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementTextBoxDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementTextBoxDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementTextBoxDefinition);

        if (!valueToBeSetInTextBox.equalsIgnoreCase("$$NA$$")) {
            try {
                webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
                scrollsWebElementIntoView(webElement);
                System.out.println("" + webElementName + " -> to be cleared");
                String ctrlA = Keys.chord(Keys.CONTROL, "a");
                webElement.clear();
                System.out.println("" + webElementName + " -> cleared");
                if (!valueToBeSetInTextBox.equalsIgnoreCase("$$CLEAR$$")) {
                    System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' to be entered");
                    for (int i = 0; i < 4; i++) {
                        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                        Thread.sleep(200);
                    }
                    Thread.sleep(2000);
                    webElement.sendKeys(valueToBeSetInTextBox);
                    System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' entered");
                }
                reportInfo = "Entered '" + valueToBeSetInTextBox + "' in " + webElementName + " on page/frame " + pageName + ".";
                writesToLogAndReport("Done", reportInfo);
                waitsForLoadingToCompleteWithinStandardTimeout();
            } catch (NullPointerException e) {
                reportInfo = "Web element " + webElementName + " not found on page/frame " + pageName + " with webLocator:<BR>" + webLocator.toString();
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            } catch (UnhandledAlertException uae) {
                reportInfo = "Alert exception occurred.";
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void entersTextWithTabInRateMode(List webElementTextBoxDefinition, String valueToBeSetInTextBox) throws
            Exception {
        String reportInfo;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;


        if (!valueToBeSetInTextBox.equalsIgnoreCase("$$NA$$")) {
            webLocator = getsLocatorFromWebElementDefinition(webElementTextBoxDefinition);
            pageName = getsPageNameFromWebElementDefinition(webElementTextBoxDefinition);
            webElementName = getsWebElementNameFromWebElementDefinition(webElementTextBoxDefinition);
            try {
                webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
                scrollsWebElementIntoView(webElement);
                highlightsWebElement(webElement);
                if (!webElement.getAttribute("value").trim().equalsIgnoreCase(valueToBeSetInTextBox)) {
                    System.out.println("" + webElementName + " -> to be cleared");
                    String ctrlA = Keys.chord(Keys.CONTROL, "a");
                    webElement.clear();
                    System.out.println("" + webElementName + " -> cleared");
                    if (!valueToBeSetInTextBox.equalsIgnoreCase("$$CLEAR$$")) {
                        System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' to be entered");
                        //webElement.click();
                        try {

                            String browser = new ConfigReader_Util().getBrowser();
                            if (browser.equalsIgnoreCase("firefox")) {
                                Thread.sleep(3000);
                                webElement.sendKeys(Keys.CONTROL, "a");
                                webElement.sendKeys(valueToBeSetInTextBox + Keys.TAB);

                            } else {
                                webElement.sendKeys(ctrlA + Keys.DELETE);
                                Thread.sleep(3000);
                                webElement.sendKeys(Keys.chord(ctrlA + valueToBeSetInTextBox + Keys.TAB));
                                Thread.sleep(3000);
                            }
                        } catch (Exception e) {
                        }
                        System.out.println("" + webElementName + " -> '" + valueToBeSetInTextBox + "' entered");
                    }
                    reportInfo = "Entered '" + valueToBeSetInTextBox + "' in " + webElementName + " on page/frame " + pageName + ".";
                } else {
                    reportInfo = "Value '" + valueToBeSetInTextBox + "' already set in " + webElementName + " on page/frame " + pageName + ".";
                }
                writesToLogAndReport("Done", reportInfo);
                waitsForLoadingToCompleteWithinStandardTimeout();
            } catch (NullPointerException e) {
                reportInfo = "Web element " + webElementName + " not found on page/frame " + pageName + " with webLocator:<BR>" + webLocator.toString();
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            } catch (UnhandledAlertException uae) {
                reportInfo = "Alert exception occurred.";
                writesToLogAndReport("Fail", reportInfo);
                System.out.println(reportInfo);
            }
        }
    }

    public void clicksWebElementUsingJavaScriptExecutor(List webElementDefinition) {
        JavascriptExecutor jsExecutor;
        String reportInfo;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        try {
            jsExecutor = (JavascriptExecutor) driver;
            webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
            scrollsWebElementIntoView(webElement);
            // highlightsWebElement(webElement);
            System.out.println("" + webElementName + " -> to be clicked (JavaScript Executor)");
            jsExecutor.executeScript("arguments[0].click();", webElement);
            System.out.println("" + webElementName + " -> clicked (JavaScript Executor)");
            reportInfo = "Button " + webElementName + " clicked on page/frame " + pageName + ".";
            System.out.println(reportInfo);
            writesToLogAndReport("Done", reportInfo);
            waitsForLoadingToCompleteWithinStandardTimeout();
        } catch (Exception e) {
            reportInfo = "Exception occurred while performing click operation on " + webElementName + " within page/frame " + pageName + " with webLocator:<BR>" + webLocator;
            writesToLogAndReport("Fail", reportInfo);
            System.out.println(reportInfo);
        }
    }

    public void clicksWebElement(List webElementDefinition) {
        String reportInfo;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        try {
            webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
            //scrollsWebElementIntoView(webElement);
            //highlightsWebElement(webElement);
            System.out.println("" + webElementName + " -> to be clicked");
            webElement.click();
            System.out.println("" + webElementName + " -> clicked");
            reportInfo = "Clicked web element " + webElementName + " on page/frame " + pageName + ".";
            System.out.println(reportInfo);
            writesToLogAndReport("Done", reportInfo);
            waitsForLoadingToCompleteWithinStandardTimeout();
        } catch (Exception e) {
            reportInfo = "Exception occurred while performing click operation on " + webElementName + " within page/frame " + pageName + " with webLocator:<BR>" + webLocator;
            System.out.println(reportInfo);
            System.out.println("Trying with JS executor.");
            clicksWebElementUsingJavaScriptExecutor(webElementDefinition);
        }
    }

    public void selectsValueFromDropDown2(String valueToBeSelected, List webElementDropDownDefinition) {
        boolean valueToBeSelectedFoundWithProperty;
        String dropDownValue;
        String reportInfo;
        WebElement webElementDropDown;
        Select dropDown;
        By webLocator;
        String webElementName;
        String pageName;
        int optionIndex;

        webLocator = getsLocatorFromWebElementDefinition(webElementDropDownDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDropDownDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDropDownDefinition);

        if (!valueToBeSelected.equalsIgnoreCase("$$NA$$")) {
            webElementDropDown = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
            //scrollsWebElementIntoView(webElementDropDown);
            //highlightsWebElement(webElementDropDown);

            this.waitsForLoadingToCompleteWithinStandardTimeout();
            //String ctrlA = Keys.chord(Keys.CONTROL, "a");
            //webElementDropDown.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            //webElementDropDown.clear();
            webElementDropDown.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            webElementDropDown.sendKeys(valueToBeSelected);
            webElementDropDown.sendKeys(Keys.ARROW_DOWN);
            webElementDropDown.sendKeys(Keys.TAB);
            dropDownValue = webElementDropDown.getAttribute("data-origval");
            if (!dropDownValue.isEmpty()) {
                valueToBeSelectedFoundWithProperty = true;
                reportInfo = "Selected '" + valueToBeSelected + "' value from drop down " + webElementName + " on page/frame " + pageName + ".";
                System.out.println(reportInfo);
                writesToLogAndReport("Done", reportInfo);
            } else {
                reportInfo = "'" + valueToBeSelected + "' not found in dropDown " + webElementName + pageName + ".";
                System.out.println(reportInfo);
                writesToLogAndReport("Fail", reportInfo);
            }
        }
    }

    public void CMPDropDown(String valueToBeSelected, List webElementDropDownDefinition) {
        boolean valueToBeSelectedFoundWithProperty;
        String dropDownValue;
        String reportInfo;
        WebElement webElementDropDown;
        Select dropDown;
        By webLocator;
        String webElementName;
        String pageName;
        int optionIndex;
        String listId, controllerId, listLocator;

        webLocator = getsLocatorFromWebElementDefinition(webElementDropDownDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDropDownDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDropDownDefinition);

        if (!valueToBeSelected.equalsIgnoreCase("$$NA$$")) {
            webElementDropDown = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
            //scrollsWebElementIntoView(webElementDropDown);
            //highlightsWebElement(webElementDropDown);

            String drpDownLocator = String.valueOf(webLocator) + "//following-sibling::a";
            String drpDownLocator1[] = drpDownLocator.split(":", 2);
            controllerId = driver.findElement(webLocator).getAttribute("id");
            listId = controllerId + "list";
            listLocator = "//ul[@id=\"" + listId + "\"]/li[@data-value=\"" + valueToBeSelected + "\"]";
            this.waitsForLoadingToCompleteWithinStandardTimeout();
            driver.findElement(By.xpath(drpDownLocator1[1].trim())).click();
            this.waitUntilPleaseWaitDisappear();
            driver.findElement(By.xpath(listLocator)).click();


            dropDownValue = webElementDropDown.getAttribute("data-origval");
            if (!dropDownValue.isEmpty()) {
                valueToBeSelectedFoundWithProperty = true;
                reportInfo = "Selected '" + valueToBeSelected + "' value from drop down " + webElementName + " on page/frame " + pageName + ".";
                System.out.println(reportInfo);
                writesToLogAndReport("Done", reportInfo);
            } else {
                reportInfo = "'" + valueToBeSelected + "' not found in dropDown " + webElementName + pageName + ".";
                System.out.println(reportInfo);
                writesToLogAndReport("Fail", reportInfo);
            }
        }
    }

    public void selectsValueFromDropDown(String valueToBeSelected, List webElementDropDownDefinition) {
        boolean valueToBeSelectedFoundWithProperty;
        String reportInfo;
        //WebElement webElementDropDown1=driver.findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_TransTypeCd_comboboxinput"));
        WebElement webElementDropDown;
        Select dropDown;
        By webLocator;
        String webElementName;
        String pageName;
        int optionIndex;

        webLocator = getsLocatorFromWebElementDefinition(webElementDropDownDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDropDownDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDropDownDefinition);

        if (!valueToBeSelected.equalsIgnoreCase("$$NA$$")) {
            try {
                webElementDropDown = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
                scrollsWebElementIntoView(webElementDropDown);
                highlightsWebElement(webElementDropDown);
                sendsTabKeyOnWebElement(webElementDropDownDefinition);
                dropDown = new Select(findsWebElementWithLocatorWithinDefaultTimeout(webLocator));
                // selectByVisibleText
                try {
                    dropDown.selectByVisibleText(valueToBeSelected);

                    sendsTabKeyOnWebElement(webElementDropDownDefinition);
                    //highlightsWebElement(webElementDropDown);
                    waitsForLoadingToCompleteWithinStandardTimeout();
                    valueToBeSelectedFoundWithProperty = true;
                } catch (NoSuchElementException n) {
                    valueToBeSelectedFoundWithProperty = false;
                }
                // selectByValue
                if (!valueToBeSelectedFoundWithProperty) {
                    try {
                        dropDown.selectByValue(valueToBeSelected);
                        sendsTabKeyOnWebElement(webElementDropDownDefinition);
                        waitsForLoadingToCompleteWithinStandardTimeout();
                        valueToBeSelectedFoundWithProperty = true;
                    } catch (NoSuchElementException no) {
                        try {
                            optionIndex = getsIndexOfCompleteOrPartialMatchingVisibleTextFromDropDown(webElementDropDownDefinition, valueToBeSelected);
                            if (optionIndex > 0) {
                                dropDown.selectByIndex(optionIndex);
                                sendsTabKeyOnWebElement(webElementDropDownDefinition);
                                waitsForLoadingToCompleteWithinStandardTimeout();
                                reportInfo = "Selected index with (partial specified) visible text '" + valueToBeSelected + "' from drop down " + webElementName + " on page/frame " + pageName + ".";
                                System.out.println(reportInfo);
                                writesToLogAndReport("Done", reportInfo);
                            } else {
                                throw new java.util.NoSuchElementException();
                            }
                        } catch (NoSuchElementException noo) {
                            reportInfo = "Complete visible text/Partial visible text/Value '" + valueToBeSelected + "' not available in drop down " + webElementName + " on page/frame " + pageName + ".";
                            System.out.println(reportInfo);
                            writesToLogAndReport("Done", reportInfo);
                        }
                    }
                }
                if (valueToBeSelectedFoundWithProperty) {
                    reportInfo = "Selected '" + valueToBeSelected + "' value from drop down " + webElementName + " on page/frame " + pageName + ".";
                    System.out.println(reportInfo);
                    writesToLogAndReport("Done", reportInfo);
                } else {
                    reportInfo = "Exception occurred. Drop down " + webElementName + " not found on page/frame " + pageName + ".";
                    System.out.println(reportInfo);
                    writesToLogAndReport("Fail", reportInfo);
                }
            } catch (NullPointerException e) {
                reportInfo = "Exception occurred. Drop down " + webElementName + " not found on page/frame " + pageName + ".";
                System.out.println(reportInfo);
                writesToLogAndReport("Fail", reportInfo);
            }
        }
    }

    public void selectsValueFromDropDown3(String valueToBeSelected, List webElementDropDownDefinition) {
        boolean valueToBeSelectedFoundWithProperty;
        String reportInfo;
        WebElement webElementDropDown;
        Select dropDown;
        By webLocator;
        String webElementName;
        String pageName;
        int optionIndex;

        webLocator = getsLocatorFromWebElementDefinition(webElementDropDownDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDropDownDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDropDownDefinition);

        if (!valueToBeSelected.equalsIgnoreCase("$$NA$$")) {
            try {
                webElementDropDown = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
                dropDown = new Select(findsWebElementWithLocatorWithinDefaultTimeout(webLocator));
                // selectByVisibleText
                try {
                    dropDown.selectByVisibleText(valueToBeSelected);
                    waitsForLoadingToCompleteWithinStandardTimeout();
                    valueToBeSelectedFoundWithProperty = true;
                } catch (NoSuchElementException n) {
                    valueToBeSelectedFoundWithProperty = false;
                }
                // selectByValue
                if (!valueToBeSelectedFoundWithProperty) {
                    try {
                        dropDown.selectByValue(valueToBeSelected);
                        waitsForLoadingToCompleteWithinStandardTimeout();
                        valueToBeSelectedFoundWithProperty = true;
                    } catch (NoSuchElementException no) {
                        try {
                            optionIndex = getsIndexOfCompleteOrPartialMatchingVisibleTextFromDropDown(webElementDropDownDefinition, valueToBeSelected);
                            if (optionIndex > 0) {
                                dropDown.selectByIndex(optionIndex);
                                waitsForLoadingToCompleteWithinStandardTimeout();
                                reportInfo = "Selected index with (partial specified) visible text '" + valueToBeSelected + "' from drop down " + webElementName + " on page/frame " + pageName + ".";
                                System.out.println(reportInfo);
                                writesToLogAndReport("Done", reportInfo);
                            } else {
                                throw new java.util.NoSuchElementException();
                            }
                        } catch (NoSuchElementException noo) {
                            reportInfo = "Complete visible text/Partial visible text/Value '" + valueToBeSelected + "' not available in drop down " + webElementName + " on page/frame " + pageName + ".";
                            System.out.println(reportInfo);
                            writesToLogAndReport("Done", reportInfo);
                        }
                    }
                }
                if (valueToBeSelectedFoundWithProperty) {
                    reportInfo = "Selected '" + valueToBeSelected + "' value from drop down " + webElementName + " on page/frame " + pageName + ".";
                    System.out.println(reportInfo);
                    writesToLogAndReport("Done", reportInfo);
                } else {
                    reportInfo = "Exception occurred. Drop down " + webElementName + " not found on page/frame " + pageName + ".";
                    System.out.println(reportInfo);
                    writesToLogAndReport("Fail", reportInfo);
                }
            } catch (NullPointerException e) {
                reportInfo = "Exception occurred. Drop down " + webElementName + " not found on page/frame " + pageName + ".";
                System.out.println(reportInfo);
                writesToLogAndReport("Fail", reportInfo);
            }
        }
    }

    public int getsIndexOfCompleteOrPartialMatchingVisibleTextFromDropDown(List webElementDefinition, String
            completeOrPartialMatchingOption) {
        By webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        Select selectBox = new Select(driver.findElement(webLocator));
        List<WebElement> options = selectBox.getOptions();
        String optionText = "";
        int optionIndex = -1;
        int optionCounter;
        for (optionCounter = 0; optionCounter < options.size(); optionCounter++) {
            optionText = options.get(optionCounter).getAttribute("text");
            if (optionText.toLowerCase().contains(completeOrPartialMatchingOption.toLowerCase())) {
                optionIndex = optionCounter;
                break;
            } else {
                if (optionCounter == (options.size() - 1)) {
                    optionIndex = -1;
                }
            }
        }
        return optionIndex;
    }

    public String getsSelectedOptionFromDropDown(List webElementDefinition) {
        String selectedOption;

        By webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        selectedOption = new Select(driver.findElement(webLocator)).getFirstSelectedOption().getText().trim();
        return selectedOption;
    }

    public void waitsForPageToBeLoaded() {
        WebDriverWait waitForWebDriver;

        if (verifiesAlertIsNotPresent()) {
            try {
                System.out.println("Checking for page ready state.");
                ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
                waitForWebDriver = new WebDriverWait(driver, 180);
                waitForWebDriver.until(pageLoadCondition);
                System.out.println("Page ready state is complete.");
            } catch (UnhandledAlertException uae) {
                System.out.println("Alert displayed while waiting for page to load");
            } catch (NoSuchWindowException we) {
                System.out.println("'NoSuchWindowException' exception occurred while waiting for page to load. Window closed.");
            } catch (WebDriverException wde) {
                System.out.println("Web driver exception occurred while waiting for page to load");
            }
        }
        insertsHardCodedDelayInMilliSeconds(500);
    }

    public void waitsForLoadingToCompleteWithinStandardTimeout() {
        long timeOutInMilliSeconds = 380000;
        long startTimeInMilliSeconds = System.currentTimeMillis();

        WebElement progressBarWebElement;
        By webLocator = By.xpath("//div[@class='blockUI blockMsg blockPage']");

        insertsHardCodedDelayInMilliSeconds(1000);

        if (verifiesAlertIsNotPresent()) {
            try {
                insertsHardCodedDelayInMilliSeconds(1000);
                do {
                    progressBarWebElement = findsWebElementWithLocatorWithinSpecifiedTimeout(webLocator, 500);
                    if (progressBarWebElement != null) {
                        insertsHardCodedDelayInMilliSeconds(1000);
                    }
                } while (progressBarWebElement != null && (System.currentTimeMillis() - startTimeInMilliSeconds) < timeOutInMilliSeconds);
                waitsForPageToBeLoaded();
            } catch (Exception e) {
                System.out.println("Exception occurred while waiting for page to load");
            }
        }
    }

    public void insertsHardCodedDelayInMilliSeconds(int milliSeconds) {
        try {
            MILLISECONDS.sleep(milliSeconds);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }

    public void highlightsWebElement(WebElement webElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String webElementName = webElement.toString().substring(webElement.toString().lastIndexOf(": ") + 2).trim();
        webElementName = webElementName.substring(0, webElementName.length() - 1).trim();
        try {
            // jsExecutor.executeScript("arguments[0].style.border='3px solid red!important'", webElement);
            jsExecutor.executeScript("arguments[0].setAttribute('style', 'border-style: solid;border-color: red;border: 2px solid red!important;');", webElement);
            System.out.println("highlightsWebElement: " + webElementName);
        } catch (Exception e) {
            System.out.println("highlightsWebElement: Exception occurred.");
        }
    }

    public void setsCheckBoxTo(boolean checked, List webElementCheckBoxDefinition) {
        String reportInfo;
        JavascriptExecutor jsExecutor;
        WebElement webElementCheckBox;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementCheckBoxDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementCheckBoxDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementCheckBoxDefinition);

        try {
            jsExecutor = (JavascriptExecutor) driver;
            webElementCheckBox = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
            scrollsWebElementIntoView(webElementCheckBox);
            highlightsWebElement(webElementCheckBox);
            if (checked) {
                if (webElementCheckBox.isSelected()) {
                    reportInfo = "Checkbox " + webElementName + " already checked on page/frame " + pageName;
                } else {
                    System.out.println("" + webElementName + " -> to be checked");
                    jsExecutor.executeScript("arguments[0].click();", webElementCheckBox);
                    System.out.println("" + webElementName + " -> checked");
                    reportInfo = "Checkbox " + webElementName + " checked on page/frame " + pageName;
                }
            } else {
                if (!webElementCheckBox.isSelected()) {
                    reportInfo = "Checkbox " + webElementName + " already unchecked on page/frame " + pageName;
                } else {
                    System.out.println("" + webElementName + " -> to be unchecked");
                    jsExecutor.executeScript("arguments[0].click();", webElementCheckBox);
                    System.out.println("" + webElementName + " -> unchecked");
                    reportInfo = "Checkbox " + webElementName + " unchecked on page/frame " + pageName;
                }
            }
            System.out.println(reportInfo);
            writesToLogAndReport("Done", reportInfo);
            waitsForLoadingToCompleteWithinStandardTimeout();
        } catch (Exception e) {
            reportInfo = "Exception occurred while performing check/uncheck operation on " + webElementName + " on page/frame " + pageName + " with webLocator:<BR>" + webLocator;
            writesToLogAndReport("Fail", reportInfo);
            System.out.println(reportInfo);
        }
    }

    public void selectsRadioButton(List webElementRadioButtonDefinition) {
        String reportInfo;
        JavascriptExecutor jsExecutor;
        WebElement webElementRadioButton;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementRadioButtonDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementRadioButtonDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementRadioButtonDefinition);

        try {
            jsExecutor = (JavascriptExecutor) driver;
            webElementRadioButton = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
            scrollsWebElementIntoView(webElementRadioButton);
            highlightsWebElement(webElementRadioButton);
            if (webElementRadioButton.isSelected()) {
                reportInfo = "Radio button " + webElementName + " already selected on page/frame " + pageName;
            } else {
                System.out.println("" + webElementName + " -> to be selected");
                jsExecutor.executeScript("arguments[0].click();", webElementRadioButton);
                System.out.println("" + webElementName + " -> selected");
                reportInfo = "Radio button " + webElementName + " selected on page/frame " + pageName;
            }
            System.out.println(reportInfo);
            writesToLogAndReport("Done", reportInfo);
            waitsForLoadingToCompleteWithinStandardTimeout();
        } catch (Exception e) {
            reportInfo = "Exception occurred while selecting" + webElementName + " on page/frame " + pageName + " with webLocator:<BR>" + webLocator;
            writesToLogAndReport("Fail", reportInfo);
            System.out.println(reportInfo);
        }
    }

    public String getsTextOfWebElement(List webElementDefinition) {
        String retrievedTextFromWebElement;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        waitsForLoadingToCompleteWithinStandardTimeout();
        webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);

        scrollsWebElementIntoView(webElement);
        highlightsWebElement(webElement);

        retrievedTextFromWebElement = webElement.getAttribute("innerText").trim();

        if (retrievedTextFromWebElement.length() == 0) {
            try {
                retrievedTextFromWebElement = webElement.getAttribute("value").trim();
            } catch (NullPointerException npe) {
                System.out.println("Attribute - value doesn't exists for the webElement " + webElementName + " ");
            }
        }

        System.out.println("Retrieved text '" + retrievedTextFromWebElement + "' with length '" + retrievedTextFromWebElement.length() + "' from web element " + webElementName + " on page/frame " + pageName + ".");
        writesToLogAndReport("Done", "Retrieved text '" + retrievedTextFromWebElement + "' from web element " + webElementName + " on page/frame " + pageName + ".");
        return retrievedTextFromWebElement;
    }

    public void verifiesPartialMatchForVisibleText(String expectedUserText, List webElementDefinition) {
        String textFromWebElement;
        String lowerCaseActual;
        String lowerCaseExpected;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        textFromWebElement = getsTextOfWebElement(webElementDefinition).trim();

        lowerCaseActual = textFromWebElement.toLowerCase().trim();
        lowerCaseActual = lowerCaseActual.replace(" ", "");
        lowerCaseActual = lowerCaseActual.replace("\u00A0", "");
        lowerCaseActual = lowerCaseActual.replace("\n", "");
        lowerCaseActual = lowerCaseActual.replace("\r", "");

        lowerCaseExpected = expectedUserText.toLowerCase().trim();
        lowerCaseExpected = lowerCaseExpected.replace(" ", "");
        lowerCaseExpected = lowerCaseExpected.replace("\u00A0", "");
        lowerCaseExpected = lowerCaseExpected.replace("\n", "");
        lowerCaseExpected = lowerCaseExpected.replace("\r", "");

        if (lowerCaseActual.contains(lowerCaseExpected)) {
            writesToLogAndReport("Pass", "Text for web element " + webElementName + " on page/frame " + pageName + " contains expected text '" + expectedUserText + "'.");
        } else {
            writesToLogAndReport("Fail", "Text for web element " + webElementName + " on page/frame " + pageName + " doesn't contain expected text.<BR>Expected text: '" + expectedUserText + "'<BR>Actual text: '" + textFromWebElement + "'.");
        }
    }

    public void verifiesExactMatchForVisibleText(String expectedUserText, List webElementDefinition) {
        String textFromWebElement;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        textFromWebElement = getsTextOfWebElement(webElementDefinition).trim();
        textFromWebElement = textFromWebElement.replace(" ", "");
        textFromWebElement = textFromWebElement.replace("\u00A0", "");
        textFromWebElement = textFromWebElement.replace("\n", "");
        textFromWebElement = textFromWebElement.replace("\r", "");

        expectedUserText = expectedUserText.trim();
        expectedUserText = expectedUserText.replace(" ", "");
        expectedUserText = expectedUserText.replace("\u00A0", "");
        expectedUserText = expectedUserText.replace("\n", "");
        expectedUserText = expectedUserText.replace("\r", "");
        if (textFromWebElement.equalsIgnoreCase(expectedUserText)) {
            writesToLogAndReport("Pass", "Text for web element " + webElementName + " on page/frame " + pageName + " matches with expected text '" + expectedUserText + "'.");
        } else {
            writesToLogAndReport("Fail", "Text for web element " + webElementName + " on page/frame " + pageName + " mismatched with expected text.<BR>Expected text: '" + expectedUserText + "'<BR>Actual text: '" + textFromWebElement + "'.");
        }
    }

    public String returnsExactMatchForVisibleText(String expectedUserText, List webElementDefinition) {
        String textFromWebElement;
        By webLocator;
        String webElementName;
        String pageName;
        String message;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        textFromWebElement = getsTextOfWebElement(webElementDefinition).trim();
        textFromWebElement = textFromWebElement.replace(" ", "");
        textFromWebElement = textFromWebElement.replace("\u00A0", "");
        textFromWebElement = textFromWebElement.replace("\n", "");
        textFromWebElement = textFromWebElement.replace("\r", "");

        expectedUserText = expectedUserText.trim();
        expectedUserText = expectedUserText.replace(" ", "");
        expectedUserText = expectedUserText.replace("\u00A0", "");
        expectedUserText = expectedUserText.replace("\n", "");
        expectedUserText = expectedUserText.replace("\r", "");

        if (textFromWebElement.equalsIgnoreCase(expectedUserText)) {

            message = webElementName + " matches ";
        } else {
            message = webElementName + " doesn't match ";
        }
        return message;
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", "");
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)", "");
    }

    public void scrollsWebElementIntoView(WebElement webElement) {
        JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        String webElementName = webElement.toString().substring(webElement.toString().lastIndexOf(": ") + 2).trim();
        webElementName = webElementName.substring(0, webElementName.length() - 1).trim();
        try {
            // jsExecutor.executeScript("window.scrollTo(" + webElement.getLocation().getX() + "," + (webElement.getLocation().getY()) + ");");
            // jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
            // jsExecutor.executeScript("arguments[0].scrollIntoView();", webElement);
            jsExecutor.executeScript(scrollElementIntoMiddle, webElement);
            System.out.println("scrollsWebElementIntoView: " + webElementName);
        } catch (Exception e) {
            System.out.println("scrollsWebElementIntoView: Exception occurred. Scroll into view failed for web webElement " + webElement.toString());
        }
        /*
        Actions hoverAction = new Actions(driver);
        hoverAction.moveToElement(webElement).perform();
        insertsHardCodedDelayInMilliSeconds(250);
        System.out.println("scrollsWebElementIntoView: Web element scrolled into view '" + webElement.toString() + "'");
        */
    }


    public void sendsTabKeyOnWebElement(List webElementDefinition) {
        try {
            WebElement webElement = findsWebElementWithLocatorWithinDefaultTimeout(getsLocatorFromWebElementDefinition(webElementDefinition));
            //highlightsWebElement(webElement);
            //waitsForLoadingToCompleteWithinStandardTimeout();
            //waitsUntilWebElementIsClickable(webElementDefinition);
            if (webElement.isEnabled()) {
                webElement.sendKeys(Keys.TAB);
                waitsForLoadingToCompleteWithinStandardTimeout();
            }
        } catch (Exception e) {
            Assert.fail("sendsTabKeyOnWebElement: Tab on webElement failed");
        }
    }

    public boolean verifiesWebElementIsPresent(List webElementDefinition) {
        boolean webElementPresent;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        try {
            waitsForLoadingToCompleteWithinStandardTimeout();
            webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
            if (webElement != null) {
                scrollsWebElementIntoView(webElement);
                highlightsWebElement(webElement);
                System.out.println("Web element present with webLocator: " + webLocator.toString());
                webElementPresent = true;
            } else {
                System.out.println("Web element not present with webLocator: " + webLocator.toString());
                webElementPresent = false;
            }
        } catch (NoSuchElementException nsee) {
            webElementPresent = false;
            System.out.println("'NoSuchElementException' exception occurred for web element with webLocator: " + webLocator.toString());
        } catch (NoSuchWindowException we) {
            webElementPresent = false;
            System.out.println("'NoSuchWindowException' exception occurred for web element with webLocator: " + webLocator.toString());
        }
        return webElementPresent;
    }

    public Boolean verifiesWebElementIsPresentWithinSpecifiedTimeout(final List webElementDefinition,
                                                                     int timeOutInSeconds) {
        Boolean webElementIsPresentWithinSpecifiedTimeout = false;
        final By webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        try {
            FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
            wait.withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
            wait.pollingEvery(500, MILLISECONDS);
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(StaleElementReferenceException.class);//newly added - by Ravi
            Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver webDriver) {
                    return webDriver.findElement(webLocator).isDisplayed();
                }
            };
            webElementIsPresentWithinSpecifiedTimeout = wait.until(function);
        } catch (TimeoutException e) {
            String info = "Fluent wait could not find web element with locator: " + webLocator.toString().split("\\:")[1];
            System.out.println(info);
        }
        return webElementIsPresentWithinSpecifiedTimeout;
    }

    public boolean verifiesWebElementIsNotPresent(List webElementDefinition) {
        boolean webElementNotPresent;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        try {
            waitsForLoadingToCompleteWithinStandardTimeout();
            webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
            if (webElement == null) {
                System.out.println("Web element not present with webLocator: " + webLocator.toString());
                webElementNotPresent = true;
            } else {
                highlightsWebElement(webElement);
                System.out.println("Web element present with webLocator: " + webLocator.toString());
                webElementNotPresent = false;
            }
        } catch (NoSuchElementException nsee) {
            webElementNotPresent = true;
            System.out.println("'NoSuchElementException' exception occurred for web element with webLocator: " + webLocator.toString());
        } catch (NoSuchWindowException we) {
            webElementNotPresent = false;
            System.out.println("'NoSuchWindowException' exception occurred for web element with webLocator: " + webLocator.toString());
        }
        return webElementNotPresent;
    }

    public void waitUntilPleaseWaitDisappear() {
        try {
            while (driver.findElement(By.xpath("//span[text()='Please Wait ...']")).isDisplayed()) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {

        }
    }

    public void waitsUntilWebElementIsClickable(List webElementDefinition) {
        WebDriverWait waitForWebDriver;
        WebElement webElement;

        waitForWebDriver = new WebDriverWait(driver, 40);
        webElement = findsWebElementWithLocatorWithinDefaultTimeout(getsLocatorFromWebElementDefinition(webElementDefinition));
        waitForWebDriver.until(ExpectedConditions.elementToBeClickable(getsLocatorFromWebElementDefinition(webElementDefinition)));
    }

    public void waitsUntilWebElementIsVisible(List webElementDefinition) {
        WebDriverWait waitForWebDriver;
        WebElement webElement;//,webLocator;


        //webLocator= (WebElement) webElementDefinition.get(0);
        waitForWebDriver = new WebDriverWait(driver, 20);
        webElement = findsWebElementWithLocatorWithinDefaultTimeout(getsLocatorFromWebElementDefinition(webElementDefinition));
        //waitForWebDriver.until(ExpectedConditions.visibilityOf(webElement));
        waitForWebDriver.until(ExpectedConditions.visibilityOfElementLocated(getsLocatorFromWebElementDefinition(webElementDefinition)));
    }

    public void waitsUntilSpecifiedAttributeOfWebElementContainsValue(List webElementDefinition, String
            attributeName, String attributeValue) {
        WebDriverWait waitForWebDriver;
        WebElement webElement;

        waitForWebDriver = new WebDriverWait(driver, 20);
        webElement = findsWebElementWithLocatorWithinDefaultTimeout(getsLocatorFromWebElementDefinition(webElementDefinition));
        waitForWebDriver.until(ExpectedConditions.attributeContains(webElement, attributeName, attributeValue));
    }

    public String getsSpecifiedAttributeValueForWebElement(List webElementDefinition, String attributeName) {
        String webElementAttributeValue;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        waitsForLoadingToCompleteWithinStandardTimeout();
        webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);

        webElementAttributeValue = webElement.getAttribute(attributeName).trim();

        System.out.println("Retrieved value '" + webElementAttributeValue + "' for attribute '" + attributeName + "' from web element " + webElementName + " on page/frame " + pageName + ".");
        writesToLogAndReport("Done", "Retrieved value '" + webElementAttributeValue + "' for attribute '" + attributeName + "' from web element " + webElementName + " on page/frame " + pageName + ".");

        return webElementAttributeValue;
    }

    public boolean verifiesSpecifiedAttributeOfWebElementContainsValue(List webElementDefinition, String
            attributeName, String attributeValue) {
        String webElementAttributeValue;
        WebElement webElement;
        By webLocator;
        String webElementName;
        String pageName;
        boolean success;

        webLocator = getsLocatorFromWebElementDefinition(webElementDefinition);
        pageName = getsPageNameFromWebElementDefinition(webElementDefinition);
        webElementName = getsWebElementNameFromWebElementDefinition(webElementDefinition);

        waitsForLoadingToCompleteWithinStandardTimeout();

        webElement = findsWebElementWithLocatorWithinDefaultTimeout(webLocator);
        webElementAttributeValue = webElement.getAttribute(attributeName).trim();

        if (webElementAttributeValue.trim().toLowerCase().contains(attributeValue.trim().toLowerCase())) {
            success = true;
        } else {
            success = false;
        }

        System.out.println("Attribute '" + attributeName + "' for web element '" + webElementName + "' on page/frame '" + pageName + "' contains value '" + attributeValue + "'.");
        writesToLogAndReport("Done", "Attribute '" + attributeName + "' for web element '" + webElementName + "' on page/frame '" + pageName + "' contains value '" + attributeValue + "'.");

        return success;
    }

}