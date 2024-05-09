package hooks;

import config.ConfigFactory;
import driverfactory.DriverFactory;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Loggers;
import utilities.TestContext;
import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContext testContext;
     static Logger log = Loggers.log();
    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @BeforeAll(order = 0)
    public static void before_all() {
        log.info("Browser name: "+ConfigFactory.getConfig().browser());
        DriverFactory.initDriver(ConfigFactory.getConfig().browser());
    }

    @AfterAll(order = 0)
    public static void after_all() {
        DriverFactory.getDriver().quit();
        log.info("***********************************************************r");
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
