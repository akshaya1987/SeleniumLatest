package driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

    public  static WebDriver initDriver(String browser) {

        System.out.println("Browser is : " + browser);
        System.out.println("Browser is : " + browser.equalsIgnoreCase("Chrome"));

        if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tldriver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            tldriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("Safari")) {
            tldriver.set(new SafariDriver());
        } else {
            System.out.println("Please provide proper browser name");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tldriver.get();
    }
}
