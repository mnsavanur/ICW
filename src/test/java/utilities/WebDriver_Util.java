package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URL;
import java.util.HashMap;

public class WebDriver_Util {

    private ConfigReader_Util config;
    private WebDriver webDriver;

    public WebDriver_Util(ConfigReader_Util configReader) {
        this.config = configReader;
    }

    private WebDriver createDriverInstance() {
        String browser;
        System.out.println("WebDriver Util hit");
        try {
            browser = config.getBrowser();
            if (browser.equalsIgnoreCase("firefox")) {
               // System.setProperty(config.getfirefoxDriverSystemProperty(), config.getDriverDirectory() + config.getfirefoxDriver());
                //FirefoxOptions options = new FirefoxOptions();
                //FirefoxOptions options = new FirefoxOptions().setBinary(binary);
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                System.out.println("Firefox driver loaded");

            } else if (browser.equalsIgnoreCase("marionette")) {
                System.setProperty(config.getMarionetteSystemProperty(), config.getDriverDirectory() + config.getMarionetteDriver());
                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile driverProfile = profile.getProfile("webdriver");
                DesiredCapabilities browserCapabilities = DesiredCapabilities.firefox();
                browserCapabilities.setCapability("marionette", true);
                browserCapabilities.setCapability(FirefoxDriver.PROFILE, driverProfile);
                //webDriver = new MarionetteDriver(browserCapabilities);
                System.out.println("Marionette driver loaded");

            } else if (browser.equalsIgnoreCase("ie")) {
                //System.setProperty(config.getIEDriverSystemProperty(), config.getDriverDirectory() + config.getIEDriver());
                InternetExplorerOptions ieOption = new InternetExplorerOptions();
                // ieOption.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                ieOption.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                ieOption.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver(ieOption);
                System.out.println("IE driver loaded");

            } else if (browser.equalsIgnoreCase("chrome")) {
                //System.setProperty(config.getChromeDriverSystemProperty(), config.getDriverDirectory() + config.getChromeDriver());
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("chrome.switches", "--disable-extensions");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(chromeOptions);
                System.out.println("Chrome Driver loaded");

            } else if (browser.equalsIgnoreCase("edge")) {
                //System.setProperty(config.getedgeDriverSystemProperty(), config.getDriverDirectory() + config.getedgeDriver());

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("credentials_enable_service", false);
                edgeOptions.setCapability("profile.password_manager_enabled", false);
                edgeOptions.setCapability("useAutomationExtension", false);
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver(edgeOptions);
                System.out.println("Edge Driver loaded");

            } else if (browser.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(Platform.WINDOWS);
                capabilities.setVersion("56.0.2924.87");
                webDriver = new RemoteWebDriver(new URL(config.getRemoteDriverURL()), capabilities);
                System.out.println("Remote driver loaded");
            } else {
                // Use a sensible default in case the driver name is misspelled in the config file
                webDriver = new FirefoxDriver();
                System.out.println("Default firefox driver loaded");
            }
        } catch (Exception e) {
            e.printStackTrace();
            webDriver = new FirefoxDriver();
            System.out.println("IO Error in WebDriver Util - Default firefox driver loaded");
        }
        return webDriver;
    }

    public WebDriver createAndRetrieveWebDriverInstance() {
        return this.createDriverInstance();
    }

    public void killWebDriverInstance() {
        System.out.println("Killing WebDriver");
        try {
            webDriver.close();
            webDriver.quit();
            VideoRecorder_Util.stopRecord();
        } catch (UnhandledAlertException f) {
            webDriver.switchTo().alert();
            webDriver.switchTo().alert().accept();
            webDriver.close();
            webDriver.quit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred whiling killing the web driver.");
        }
    }

}