package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logging_Util {

    private final Logger log = Logger.getLogger(Logging_Util.class);

    public Logging_Util(ConfigReader_Util config) {
        PropertyConfigurator.configure(config.getLog4jFilePath());
        System.out.println("Logging Util hit");
    }

    // The path to the log4j configuration file is set by the TestFramework_Initializer before all other operations using
    // @BeforeSuite TestNG annotation.  Log4j must be configured before references to it are made in the code, or there
    // will be warnings thrown in the IDE (not really a problem though)

    public void setLog4jFilePath() {

    }

    public void log_Info(String info) {
        this.log.info(info);
    }

}
