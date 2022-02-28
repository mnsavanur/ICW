package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader_Util {

    private Properties configFile;

    public ConfigReader_Util() {
        this.loadConfigFile();
    }

    private void loadConfigFile() {
        try {
            InputStream configValues = ConfigReader_Util.class.getResourceAsStream("/config.properties");
            configFile = new Properties();
            configFile.load(configValues);
        } catch (IOException e) {
            System.out.println("'config.properties' file not found.");
        }
    }

    public String getConfigInfoForKey(String configKey) {
        if (configFile.getProperty(configKey) == null) {
            System.out.println("ConfigReader Utility could not find the following property: " + configKey);
            return null;
        } else {
            return configFile.getProperty(configKey);
        }
    }

    public String getBrowser() throws Exception {
        if (configFile.getProperty("browser") == null) {
            System.out.println("No browser found in config.properties file");
            return "firefox";
        } else {
            return configFile.getProperty("browser");
        }
    }

    public String getURL() {
        if (configFile.getProperty("URL") == null) {
            return "about:blank";
        } else {
            return configFile.getProperty("URL");
        }
    }

    public String getExcelFilePath(String configKeyForExcelFileName) {
        String excelFilePath;

        excelFilePath = configFile.getProperty(configKeyForExcelFileName);

        if (excelFilePath.equalsIgnoreCase("") | excelFilePath == null) {
            System.out.println("Excel file path not found in config.properties file, check spelling");
        } else {
            System.out.println("Excel file path: " + excelFilePath);
        }
        return excelFilePath;
    }

    public String getExtentFilePath() {
        if (configFile.getProperty("htmlReport_ResourcePath") == null) {
            System.out.println("No Extent Report file path found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("htmlReport_ResourcePath");
        }
    }

    public String getLog4jFilePath() {
        if (configFile.getProperty("log4j_ResourcePath") == null) {
            System.out.println("No log4j file path found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("log4j_ResourcePath");
        }
    }

    public String getScreenShotPath() {
        if (configFile.getProperty("screenShot_ResourcePath") == null) {
            System.out.println("No ScreenShot file path found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("screenShot_ResourcePath");
        }
    }

    public String getScreenShotFileType() {
        if (configFile.getProperty("screenShot_Type") == null) {
            System.out.println("No ScreenShot file type found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("screenShot_Type");
        }
    }

    public String getDateTimeFormat() {
        if (configFile.getProperty("dateTime_Format") == null) {
            System.out.println("No DateTime format found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("dateTime_Format");
        }
    }

    public String getUserRootDirectory() {
        return System.getProperty("user.dir") + "\\";
    }

    public String getDriverDirectory() {
        if (configFile.getProperty("driverDirectory") == null) {
            System.out.println("No driver directory found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("driverDirectory");
        }
    }

    public String getfirefoxDriver() {
        if (configFile.getProperty("firefoxDriver") == null) {
            System.out.println("No Firefox driver found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("firefoxDriver");
        }
    }

    public String getfirefoxDriverSystemProperty() {
        if (configFile.getProperty("firefoxDriverSystemProperty") == null) {
            System.out.println("No firefoxDriverSystemProperty found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("firefoxDriverSystemProperty");
        }
    }

    public String getMarionetteDriver() {
        if (configFile.getProperty("marionetteDriver") == null) {
            System.out.println("No marionette driver found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("marionetteDriver");
        }
    }

    public String getMarionetteSystemProperty() {
        if (configFile.getProperty("marionetteSystemProperty") == null) {
            System.out.println("No marionetteSystemProperty found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("marionetteSystemProperty");
        }
    }

    public String getIEDriver() {
        if (configFile.getProperty("ieDriver") == null) {
            System.out.println("No IE driver found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("ieDriver");
        }
    }

    public String getIEDriverSystemProperty() {
        if (configFile.getProperty("ieDriverSystemProperty") == null) {
            System.out.println("No ieDriverSystemProperty found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("ieDriverSystemProperty");
        }
    }

    public String getedgeDriver() {
        if (configFile.getProperty("edgeDriver") == null) {
            System.out.println("No Edge driver found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("edgeDriver");
        }
    }

    public String getedgeDriverSystemProperty() {
        if (configFile.getProperty("edgeDriverSystemProperty") == null) {
            System.out.println("No edgeDriverSystemProperty found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("edgeDriverSystemProperty");
        }
    }

    public String getChromeDriver() {
        if (configFile.getProperty("chromeDriver") == null) {
            System.out.println("No chrome driver found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("chromeDriver");
        }
    }

    public String getRemoteDriverURL() {
        if (configFile.getProperty("remoteDriverURL") == null) {
            System.out.println("No remote driver URL found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("remoteDriverURL");
        }
    }

    public String getChromeDriverSystemProperty() {
        if (configFile.getProperty("chromeDriverSystemProperty") == null) {
            System.out.println("No chromeDriverSystemProperty found in config.properties file");
            return null;
        } else {
            return configFile.getProperty("chromeDriverSystemProperty");
        }
    }

}