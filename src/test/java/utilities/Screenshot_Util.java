package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot_Util {

    private ConfigReader_Util config;
    private WebDriver webDriver;
    private String directory;
    private String screenShotFileType;
    private String dateTimeFormat;
    private String rootDirectory;
    private int msTimeDelay = 5000;

    public Screenshot_Util(WebDriver webDriver, ConfigReader_Util configReader) {
        this.config = configReader;
        this.webDriver = webDriver;
        this.directory = this.config.getScreenShotPath();
        this.screenShotFileType = this.config.getScreenShotFileType();
        this.dateTimeFormat = this.config.getDateTimeFormat();
        this.rootDirectory = this.config.getUserRootDirectory();
    }

    private String getCurrentDateTime() {
        Date currentDateTime = new Date();
        SimpleDateFormat timeStamp = new SimpleDateFormat (this.dateTimeFormat);
        return timeStamp.format(currentDateTime);
    }

    public String takeScreenshot() {
        String fileName = getCurrentDateTime() + "." + this.screenShotFileType;
        try {
            try {
                Thread.sleep(this.msTimeDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            File sourceFile = ((TakesScreenshot) this.webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(this.directory + fileName));
        } catch (IOException e) {
            System.err.println("screenshot failed");
        }
        return this.rootDirectory + "\\" + this.directory + fileName;
    }
}
