package pages;

import config.ConfigFactory;
import driverfactory.DriverFactory;
import enums.WaitStrategy;
import generics.PageFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

public class CalendarHandler {

    @Test
    public void Test() {

        final String DEFAULT_SCREENSHOT_PATH = System.getProperty("user.dir") + "/target/screenshot/";
        System.out.println(DEFAULT_SCREENSHOT_PATH);
    }

    @Test
    public void display() {
        System.out.println("Hello");
        Assert.assertTrue(true);
    }

    @Test
    public void _setDate() throws InterruptedException {
        // XPATHs of the elements
        By calendar = By.xpath("//button[@aria-label='Open the date view']");
        By previousButton = By.xpath("//a[@data-action='prev']");
        By nextButton = By.xpath("//a[@data-action='next']");
        By midButton = By.xpath("//a[@title='Navigate to year view']");
        By allDates = By.xpath("//tbody[@class='k-calendar-tbody']/tr/td[not(contains(@class,'k-other-month'))]");
        By allMonths = By.xpath("//table[contains(@class,'k-meta-view k-yea')]/tbody[@class='k-calendar-tbody']/tr/td[not(contains(@class,'k-other-month'))]");
        By centerButton = By.xpath("//div[@class='k-header k-hstack']/a[contains(@class,'k-calendar-nav-fast')]");

        // Elements
        List<WebElement> allMonthsElements;
        List<WebElement> allDatesElements;
        WebElement calendarElement;
        WebElement nextButtonElement;
        WebElement previousButtonElement;
        WebElement centerButtonElement;

        String dateTime = "28/02/2023 2:00 PM";
        DriverFactory.initDriver(ConfigFactory.getConfig().browser());
        DriverFactory.getDriver().get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
        calendarElement = PageFunctions._performExplicitWait(calendar, WaitStrategy.PRESENCE);
        calendarElement.click();
//        Thread.sleep(1000);
        centerButtonElement = PageFunctions._performExplicitWait(midButton, WaitStrategy.CLICKABLE);
//        Thread.sleep(1000);
        centerButtonElement.click();
        String[] dateMonthYear = dateTime.split(" ")[0].split("/");
        int yearDifferance = Integer.parseInt(dateMonthYear[2]) - Calendar.getInstance().get(Calendar.YEAR);
//        System.out.println(yearDifferance);
//        System.out.println(yearDifferance < 0);
        if (yearDifferance != 0) {
            if (yearDifferance > 0) {
                for (int i = 1; i <= yearDifferance; i++) {
                    nextButtonElement = PageFunctions._performExplicitWait(nextButton, WaitStrategy.PRESENCE);
                    nextButtonElement.click();
                }

            } else {
                for (int i = 1; i <= (yearDifferance * (-1)); i++) {
                    previousButtonElement = PageFunctions._performExplicitWait(previousButton, WaitStrategy.PRESENCE);
                    previousButtonElement.click();
                }
            }
        }
        try {
//            allMonthsElements = PageFunctions._performExplicitWaitForElements(allMonths, WaitStrategy.CLICKABLE);
//            allDatesElements = PageFunctions._performExplicitWaitForElements(allDates, WaitStrategy.CLICKABLE);

            PageFunctions._performExplicitWaitForElements(allMonths, WaitStrategy.CLICKABLE).get(Integer.parseInt(dateMonthYear[1]) - 1).click();
            Thread.sleep(1000);
            PageFunctions._performExplicitWaitForElements(allDates, WaitStrategy.CLICKABLE).get(Integer.parseInt(dateMonthYear[0]) - 1).click();
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }
}
