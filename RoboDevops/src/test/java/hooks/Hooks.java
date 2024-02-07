package hooks;

import config.ConfigFactory;
import driverfactory.DriverFactory;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Loggers;

import java.io.File;
import java.io.IOException;

public class Hooks {

    Logger log = Loggers.log();

    @Before(order = 0)
    public void openBrowser() {
        log.info("Browser name: "+ConfigFactory.getConfig().browser());
        DriverFactory.initDriver(ConfigFactory.getConfig().browser());
    }


    @After(order = 0)
    public void quitBrowser() {
        DriverFactory.getDriver().quit();
        log.info("Quitting the browser");
    }

    @After(order = 1)
    public void tearDown(Scenario sc) {
        if (sc.isFailed()) {
            String screenshotName = sc.getName().replaceAll(" ", "_");
            File sourceFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(sourceFile, new File("TestResult-html/HtmlReport/"+screenshotName+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                byte[] filecontent = FileUtils.readFileToByteArray(sourceFile);
                sc.attach(filecontent, "image/png", screenshotName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("Snapshot is taken");
        }
    }
}
